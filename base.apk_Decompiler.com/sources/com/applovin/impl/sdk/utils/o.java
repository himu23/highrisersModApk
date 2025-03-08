package com.applovin.impl.sdk.utils;

import java.lang.Comparable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.RandomAccess;
import java.util.Set;

public class o<T extends Comparable<? super T>> implements RandomAccess, Set<T> {
    private final ArrayList<T> aVQ = new ArrayList<>();
    private final HashSet<T> aVR = new HashSet<>();

    public int size() {
        return this.aVQ.size();
    }

    public boolean isEmpty() {
        return this.aVQ.isEmpty();
    }

    public boolean contains(Object obj) {
        return this.aVR.contains(obj);
    }

    public Iterator<T> iterator() {
        return this.aVQ.iterator();
    }

    public Object[] toArray() {
        return this.aVQ.toArray();
    }

    public <T1> T1[] toArray(T1[] t1Arr) {
        return this.aVQ.toArray(t1Arr);
    }

    /* renamed from: a */
    public boolean add(T t) {
        if (contains(t)) {
            return false;
        }
        if (isEmpty() || t.compareTo(Lp()) > 0) {
            this.aVQ.add(t);
        } else {
            this.aVQ.add(c(t), t);
        }
        return this.aVR.add(t);
    }

    public boolean remove(Object obj) {
        int b = b((Comparable) obj);
        if (b == -1) {
            return false;
        }
        this.aVQ.remove(b);
        return this.aVR.remove(obj);
    }

    public boolean containsAll(Collection<?> collection) {
        return this.aVR.containsAll(collection);
    }

    public boolean addAll(Collection<? extends T> collection) {
        Iterator<? extends T> it = collection.iterator();
        while (true) {
            boolean z = false;
            while (true) {
                if (!it.hasNext()) {
                    return z;
                }
                if (add((Comparable) it.next()) || z) {
                    z = true;
                }
            }
        }
    }

    public boolean retainAll(Collection<?> collection) {
        boolean z = false;
        for (int size = size() - 1; size >= 0; size--) {
            Comparable comparable = (Comparable) this.aVQ.get(size);
            if (!collection.contains(comparable)) {
                this.aVQ.remove(size);
                this.aVR.remove(comparable);
                z = true;
            }
        }
        return z;
    }

    public boolean removeAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (true) {
            boolean z = false;
            while (true) {
                if (!it.hasNext()) {
                    return false;
                }
                Object next = it.next();
                if (z || remove(next)) {
                    z = true;
                }
            }
        }
    }

    public void clear() {
        this.aVQ.clear();
        this.aVR.clear();
    }

    public T gU(int i) {
        return (Comparable) this.aVQ.get(i);
    }

    public void a(int i, T t) {
        this.aVR.remove((Comparable) this.aVQ.get(i));
        this.aVQ.set(i, t);
        this.aVR.add(t);
    }

    public T gV(int i) {
        T t = (Comparable) this.aVQ.remove(i);
        this.aVR.remove(t);
        return t;
    }

    public int b(T t) {
        if (t == null || !contains(t)) {
            return -1;
        }
        return c(t);
    }

    public T Lp() {
        return (Comparable) this.aVQ.get(size() - 1);
    }

    public int c(T t) {
        int binarySearch = Collections.binarySearch(this.aVQ, t);
        if (binarySearch < 0) {
            return ~binarySearch;
        }
        Comparable gU = gU(binarySearch);
        while (binarySearch >= 0 && gU == gU(binarySearch)) {
            binarySearch--;
        }
        return binarySearch + 1;
    }

    public int d(T t) {
        int binarySearch = Collections.binarySearch(this.aVQ, t);
        if (binarySearch < 0) {
            return ~binarySearch;
        }
        Comparable gU = gU(binarySearch);
        while (binarySearch < size() && gU == gU(binarySearch)) {
            binarySearch++;
        }
        return binarySearch;
    }
}
