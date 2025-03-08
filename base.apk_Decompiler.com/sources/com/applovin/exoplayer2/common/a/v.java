package com.applovin.exoplayer2.common.a;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract class v<K, V> extends g<K, V> implements Serializable {
    final transient int oW;
    final transient u<K, ? extends q<V>> qn;

    /* renamed from: gs */
    public u<K, Collection<V>> fc() {
        return this.qn;
    }

    public int size() {
        return this.oW;
    }

    /* renamed from: x */
    public abstract q<V> k(K k);

    public /* bridge */ /* synthetic */ boolean equals(@NullableDecl Object obj) {
        return super.equals(obj);
    }

    public /* bridge */ /* synthetic */ boolean h(@NullableDecl Object obj, @NullableDecl Object obj2) {
        return super.h(obj, obj2);
    }

    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public static class a<K, V> {
        @MonotonicNonNullDecl
        Comparator<? super V> qk;
        Map<K, Collection<V>> qt = aj.gR();
        @MonotonicNonNullDecl
        Comparator<? super K> qu;

        /* access modifiers changed from: package-private */
        public Collection<V> gx() {
            return new ArrayList();
        }

        public a<K, V> b(K k, Iterable<? extends V> iterable) {
            if (k != null) {
                Collection collection = this.qt.get(k);
                if (collection != null) {
                    for (Object next : iterable) {
                        j.j(k, next);
                        collection.add(next);
                    }
                    return this;
                }
                Iterator<? extends V> it = iterable.iterator();
                if (!it.hasNext()) {
                    return this;
                }
                Collection gx = gx();
                while (it.hasNext()) {
                    Object next2 = it.next();
                    j.j(k, next2);
                    gx.add(next2);
                }
                this.qt.put(k, gx);
                return this;
            }
            throw new NullPointerException("null key in entry: null=" + x.c(iterable));
        }

        public a<K, V> b(K k, V... vArr) {
            return b(k, Arrays.asList(vArr));
        }

        public v<K, V> gh() {
            Collection entrySet = this.qt.entrySet();
            Comparator comparator = this.qu;
            if (comparator != null) {
                entrySet = ai.b(comparator).gQ().g(entrySet);
            }
            return t.a(entrySet, this.qk);
        }
    }

    v(u<K, ? extends q<V>> uVar, int i) {
        this.qn = uVar;
        this.oW = i;
    }

    @Deprecated
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public boolean c(K k, V v) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public boolean i(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    public boolean fZ() {
        return this.qn.fZ();
    }

    public boolean containsValue(@NullableDecl Object obj) {
        return obj != null && super.containsValue(obj);
    }

    /* renamed from: gm */
    public w<K> keySet() {
        return this.qn.keySet();
    }

    /* access modifiers changed from: package-private */
    public Set<K> fe() {
        throw new AssertionError("unreachable");
    }

    /* access modifiers changed from: package-private */
    public Map<K, Collection<V>> fl() {
        throw new AssertionError("should never be called");
    }

    /* renamed from: gt */
    public q<Map.Entry<K, V>> fi() {
        return (q) super.fi();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: gu */
    public q<Map.Entry<K, V>> fj() {
        return new b(this);
    }

    private static class b<K, V> extends q<Map.Entry<K, V>> {
        final v<K, V> qv;

        b(v<K, V> vVar) {
            this.qv = vVar;
        }

        /* renamed from: fU */
        public ax<Map.Entry<K, V>> iterator() {
            return this.qv.fk();
        }

        /* access modifiers changed from: package-private */
        public boolean fZ() {
            return this.qv.fZ();
        }

        public int size() {
            return this.qv.size();
        }

        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return this.qv.h(entry.getKey(), entry.getValue());
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: gv */
    public ax<Map.Entry<K, V>> fk() {
        return new ax<Map.Entry<K, V>>() {
            final Iterator<? extends Map.Entry<K, ? extends q<V>>> qo;
            K qp = null;
            Iterator<V> qq = y.gB();

            {
                this.qo = v.this.qn.entrySet().iterator();
            }

            public boolean hasNext() {
                return this.qq.hasNext() || this.qo.hasNext();
            }

            /* renamed from: fp */
            public Map.Entry<K, V> next() {
                if (!this.qq.hasNext()) {
                    Map.Entry entry = (Map.Entry) this.qo.next();
                    this.qp = entry.getKey();
                    this.qq = ((q) entry.getValue()).iterator();
                }
                return ab.n(this.qp, this.qq.next());
            }
        };
    }

    /* renamed from: go */
    public q<V> values() {
        return (q) super.values();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: gp */
    public q<V> fg() {
        return new c(this);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: gw */
    public ax<V> fh() {
        return new ax<V>() {
            Iterator<V> qq = y.gB();
            Iterator<? extends q<V>> qs;

            {
                this.qs = v.this.qn.values().iterator();
            }

            public boolean hasNext() {
                return this.qq.hasNext() || this.qs.hasNext();
            }

            public V next() {
                if (!this.qq.hasNext()) {
                    this.qq = ((q) this.qs.next()).iterator();
                }
                return this.qq.next();
            }
        };
    }

    private static final class c<K, V> extends q<V> {
        private final transient v<K, V> qv;

        /* access modifiers changed from: package-private */
        public boolean fZ() {
            return true;
        }

        c(v<K, V> vVar) {
            this.qv = vVar;
        }

        public boolean contains(@NullableDecl Object obj) {
            return this.qv.containsValue(obj);
        }

        /* renamed from: fU */
        public ax<V> iterator() {
            return this.qv.fh();
        }

        /* access modifiers changed from: package-private */
        public int a(Object[] objArr, int i) {
            ax<? extends q<V>> fU = this.qv.qn.values().iterator();
            while (fU.hasNext()) {
                i = ((q) fU.next()).a(objArr, i);
            }
            return i;
        }

        public int size() {
            return this.qv.size();
        }
    }
}
