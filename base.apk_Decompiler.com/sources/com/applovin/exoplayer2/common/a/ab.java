package com.applovin.exoplayer2.common.a;

import com.applovin.exoplayer2.common.a.aq;
import com.applovin.exoplayer2.common.base.Function;
import com.applovin.exoplayer2.common.base.Objects;
import com.applovin.exoplayer2.common.base.Preconditions;
import com.ironsource.z3;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class ab {

    private enum a implements Function<Map.Entry<?, ?>, Object> {
        KEY {
            @NullableDecl
            /* renamed from: d */
            public Object apply(Map.Entry<?, ?> entry) {
                return entry.getKey();
            }
        },
        VALUE {
            @NullableDecl
            /* renamed from: d */
            public Object apply(Map.Entry<?, ?> entry) {
                return entry.getValue();
            }
        }
    }

    static <K> Function<Map.Entry<K, ?>, K> gF() {
        return a.KEY;
    }

    static <V> Function<Map.Entry<?, V>, V> gG() {
        return a.VALUE;
    }

    static <K, V> Iterator<K> g(Iterator<Map.Entry<K, V>> it) {
        return new aw<Map.Entry<K, V>, K>(it) {
            /* access modifiers changed from: package-private */
            /* renamed from: c */
            public K A(Map.Entry<K, V> entry) {
                return entry.getKey();
            }
        };
    }

    static <K, V> Iterator<V> h(Iterator<Map.Entry<K, V>> it) {
        return new aw<Map.Entry<K, V>, V>(it) {
            /* access modifiers changed from: package-private */
            /* renamed from: c */
            public V A(Map.Entry<K, V> entry) {
                return entry.getValue();
            }
        };
    }

    static int bl(int i) {
        if (i < 3) {
            j.a(i, "expectedSize");
            return i + 1;
        } else if (i < 1073741824) {
            return (int) ((((float) i) / 0.75f) + 1.0f);
        } else {
            return Integer.MAX_VALUE;
        }
    }

    public static <K, V> IdentityHashMap<K, V> gH() {
        return new IdentityHashMap<>();
    }

    public static <K, V> Map.Entry<K, V> n(@NullableDecl K k, @NullableDecl V v) {
        return new r(k, v);
    }

    static abstract class e<K, V> extends AbstractMap<K, V> {
        @MonotonicNonNullDecl
        private transient Set<K> pA;
        @MonotonicNonNullDecl
        private transient Collection<V> pB;
        @MonotonicNonNullDecl
        private transient Set<Map.Entry<K, V>> qG;

        /* access modifiers changed from: package-private */
        public abstract Set<Map.Entry<K, V>> fn();

        e() {
        }

        public Set<Map.Entry<K, V>> entrySet() {
            Set<Map.Entry<K, V>> set = this.qG;
            if (set != null) {
                return set;
            }
            Set<Map.Entry<K, V>> fn = fn();
            this.qG = fn;
            return fn;
        }

        public Set<K> keySet() {
            Set<K> set = this.pA;
            if (set != null) {
                return set;
            }
            Set<K> fe = fe();
            this.pA = fe;
            return fe;
        }

        /* access modifiers changed from: package-private */
        public Set<K> fe() {
            return new c(this);
        }

        public Collection<V> values() {
            Collection<V> collection = this.pB;
            if (collection != null) {
                return collection;
            }
            Collection<V> fg = fg();
            this.pB = fg;
            return fg;
        }

        /* access modifiers changed from: package-private */
        public Collection<V> fg() {
            return new d(this);
        }
    }

    static <V> V a(Map<?, V> map, @NullableDecl Object obj) {
        Preconditions.checkNotNull(map);
        try {
            return map.get(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return null;
        }
    }

    static boolean b(Map<?, ?> map, Object obj) {
        Preconditions.checkNotNull(map);
        try {
            return map.containsKey(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    static <V> V c(Map<?, V> map, Object obj) {
        Preconditions.checkNotNull(map);
        try {
            return map.remove(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return null;
        }
    }

    static boolean d(Map<?, ?> map, Object obj) {
        if (map == obj) {
            return true;
        }
        if (obj instanceof Map) {
            return map.entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    static String b(Map<?, ?> map) {
        StringBuilder aS = k.aS(map.size());
        aS.append('{');
        boolean z = true;
        for (Map.Entry next : map.entrySet()) {
            if (!z) {
                aS.append(", ");
            }
            aS.append(next.getKey());
            aS.append(z3.R);
            aS.append(next.getValue());
            z = false;
        }
        aS.append('}');
        return aS.toString();
    }

    static class c<K, V> extends aq.a<K> {
        final Map<K, V> pf;

        /* access modifiers changed from: package-private */
        public Map<K, V> fo() {
            return this.pf;
        }

        c(Map<K, V> map) {
            this.pf = (Map) Preconditions.checkNotNull(map);
        }

        public Iterator<K> iterator() {
            return ab.g(fo().entrySet().iterator());
        }

        public int size() {
            return fo().size();
        }

        public boolean isEmpty() {
            return fo().isEmpty();
        }

        public boolean contains(Object obj) {
            return fo().containsKey(obj);
        }

        public boolean remove(Object obj) {
            if (!contains(obj)) {
                return false;
            }
            fo().remove(obj);
            return true;
        }

        public void clear() {
            fo().clear();
        }
    }

    static class d<K, V> extends AbstractCollection<V> {
        final Map<K, V> pf;

        /* access modifiers changed from: package-private */
        public final Map<K, V> fo() {
            return this.pf;
        }

        d(Map<K, V> map) {
            this.pf = (Map) Preconditions.checkNotNull(map);
        }

        public Iterator<V> iterator() {
            return ab.h(fo().entrySet().iterator());
        }

        public boolean remove(Object obj) {
            try {
                return super.remove(obj);
            } catch (UnsupportedOperationException unused) {
                for (Map.Entry entry : fo().entrySet()) {
                    if (Objects.equal(obj, entry.getValue())) {
                        fo().remove(entry.getKey());
                        return true;
                    }
                }
                return false;
            }
        }

        public boolean removeAll(Collection<?> collection) {
            try {
                return super.removeAll((Collection) Preconditions.checkNotNull(collection));
            } catch (UnsupportedOperationException unused) {
                HashSet gS = aq.gS();
                for (Map.Entry entry : fo().entrySet()) {
                    if (collection.contains(entry.getValue())) {
                        gS.add(entry.getKey());
                    }
                }
                return fo().keySet().removeAll(gS);
            }
        }

        public boolean retainAll(Collection<?> collection) {
            try {
                return super.retainAll((Collection) Preconditions.checkNotNull(collection));
            } catch (UnsupportedOperationException unused) {
                HashSet gS = aq.gS();
                for (Map.Entry entry : fo().entrySet()) {
                    if (collection.contains(entry.getValue())) {
                        gS.add(entry.getKey());
                    }
                }
                return fo().keySet().retainAll(gS);
            }
        }

        public int size() {
            return fo().size();
        }

        public boolean isEmpty() {
            return fo().isEmpty();
        }

        public boolean contains(@NullableDecl Object obj) {
            return fo().containsValue(obj);
        }

        public void clear() {
            fo().clear();
        }
    }

    static abstract class b<K, V> extends aq.a<Map.Entry<K, V>> {
        /* access modifiers changed from: package-private */
        public abstract Map<K, V> fo();

        b() {
        }

        public int size() {
            return fo().size();
        }

        public void clear() {
            fo().clear();
        }

        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object a = ab.a(fo(), key);
            if (!Objects.equal(a, entry.getValue())) {
                return false;
            }
            if (a != null || fo().containsKey(key)) {
                return true;
            }
            return false;
        }

        public boolean isEmpty() {
            return fo().isEmpty();
        }

        public boolean remove(Object obj) {
            if (contains(obj)) {
                return fo().keySet().remove(((Map.Entry) obj).getKey());
            }
            return false;
        }

        public boolean removeAll(Collection<?> collection) {
            try {
                return super.removeAll((Collection) Preconditions.checkNotNull(collection));
            } catch (UnsupportedOperationException unused) {
                return aq.a((Set<?>) this, collection.iterator());
            }
        }

        public boolean retainAll(Collection<?> collection) {
            try {
                return super.retainAll((Collection) Preconditions.checkNotNull(collection));
            } catch (UnsupportedOperationException unused) {
                HashSet bp = aq.bp(collection.size());
                for (Object next : collection) {
                    if (contains(next)) {
                        bp.add(((Map.Entry) next).getKey());
                    }
                }
                return fo().keySet().retainAll(bp);
            }
        }
    }
}
