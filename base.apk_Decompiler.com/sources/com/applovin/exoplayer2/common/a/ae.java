package com.applovin.exoplayer2.common.a;

import com.applovin.exoplayer2.common.base.Preconditions;
import com.applovin.exoplayer2.common.base.Supplier;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class ae {
    public static <K, V> z<K, V> a(Map<K, Collection<V>> map, Supplier<? extends List<V>> supplier) {
        return new a(map, supplier);
    }

    private static class a<K, V> extends c<K, V> {
        transient Supplier<? extends List<V>> qM;

        a(Map<K, Collection<V>> map, Supplier<? extends List<V>> supplier) {
            super(map);
            this.qM = (Supplier) Preconditions.checkNotNull(supplier);
        }

        /* access modifiers changed from: package-private */
        public Set<K> fe() {
            return ff();
        }

        /* access modifiers changed from: package-private */
        public Map<K, Collection<V>> fl() {
            return fm();
        }

        /* access modifiers changed from: protected */
        /* renamed from: fb */
        public List<V> fd() {
            return (List) this.qM.get();
        }
    }

    static abstract class b<K, V> extends AbstractCollection<Map.Entry<K, V>> {
        /* access modifiers changed from: package-private */
        public abstract ac<K, V> fF();

        b() {
        }

        public int size() {
            return fF().size();
        }

        public boolean contains(@NullableDecl Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return fF().h(entry.getKey(), entry.getValue());
        }

        public boolean remove(@NullableDecl Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return fF().i(entry.getKey(), entry.getValue());
        }

        public void clear() {
            fF().clear();
        }
    }

    static boolean a(ac<?, ?> acVar, @NullableDecl Object obj) {
        if (obj == acVar) {
            return true;
        }
        if (obj instanceof ac) {
            return acVar.fc().equals(((ac) obj).fc());
        }
        return false;
    }
}
