package androidx.lifecycle;

import androidx.arch.core.internal.SafeIterableMap;
import java.util.Iterator;
import java.util.Map;

public class MediatorLiveData<T> extends MutableLiveData<T> {
    private SafeIterableMap<LiveData<?>, Source<?>> mSources = new SafeIterableMap<>();

    public MediatorLiveData() {
    }

    public MediatorLiveData(T t) {
        super(t);
    }

    public <S> void addSource(LiveData<S> liveData, Observer<? super S> observer) {
        if (liveData != null) {
            Source source = new Source(liveData, observer);
            Source putIfAbsent = this.mSources.putIfAbsent(liveData, source);
            if (putIfAbsent != null && putIfAbsent.mObserver != observer) {
                throw new IllegalArgumentException("This source was already added with the different observer");
            } else if (putIfAbsent == null && hasActiveObservers()) {
                source.plug();
            }
        } else {
            throw new NullPointerException("source cannot be null");
        }
    }

    public <S> void removeSource(LiveData<S> liveData) {
        Source remove = this.mSources.remove(liveData);
        if (remove != null) {
            remove.unplug();
        }
    }

    /* access modifiers changed from: protected */
    public void onActive() {
        Iterator<Map.Entry<LiveData<?>, Source<?>>> it = this.mSources.iterator();
        while (it.hasNext()) {
            ((Source) it.next().getValue()).plug();
        }
    }

    /* access modifiers changed from: protected */
    public void onInactive() {
        Iterator<Map.Entry<LiveData<?>, Source<?>>> it = this.mSources.iterator();
        while (it.hasNext()) {
            ((Source) it.next().getValue()).unplug();
        }
    }

    private static class Source<V> implements Observer<V> {
        final LiveData<V> mLiveData;
        final Observer<? super V> mObserver;
        int mVersion = -1;

        Source(LiveData<V> liveData, Observer<? super V> observer) {
            this.mLiveData = liveData;
            this.mObserver = observer;
        }

        /* access modifiers changed from: package-private */
        public void plug() {
            this.mLiveData.observeForever(this);
        }

        /* access modifiers changed from: package-private */
        public void unplug() {
            this.mLiveData.removeObserver(this);
        }

        public void onChanged(V v) {
            if (this.mVersion != this.mLiveData.getVersion()) {
                this.mVersion = this.mLiveData.getVersion();
                this.mObserver.onChanged(v);
            }
        }
    }
}
