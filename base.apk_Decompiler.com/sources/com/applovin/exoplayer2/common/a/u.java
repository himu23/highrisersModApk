package com.applovin.exoplayer2.common.a;

import com.applovin.exoplayer2.common.a.q;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract class u<K, V> implements Serializable, Map<K, V> {
    static final Map.Entry<?, ?>[] qg = new Map.Entry[0];
    @LazyInit
    private transient w<Map.Entry<K, V>> qh;
    @LazyInit
    private transient w<K> qi;
    @LazyInit
    private transient q<V> qj;

    /* access modifiers changed from: package-private */
    public abstract boolean fZ();

    public abstract V get(@NullableDecl Object obj);

    /* access modifiers changed from: package-private */
    public abstract w<Map.Entry<K, V>> gl();

    /* access modifiers changed from: package-private */
    public abstract w<K> gn();

    /* access modifiers changed from: package-private */
    public abstract q<V> gp();

    public static <K, V> u<K, V> gi() {
        return al.qP;
    }

    public static <K, V> a<K, V> gj() {
        return new a<>();
    }

    public static class a<K, V> {
        int oW;
        @MonotonicNonNullDecl
        Comparator<? super V> qk;
        Object[] ql;
        boolean qm;

        public a() {
            this(4);
        }

        a(int i) {
            this.ql = new Object[(i * 2)];
            this.oW = 0;
            this.qm = false;
        }

        private void bj(int i) {
            int i2 = i * 2;
            Object[] objArr = this.ql;
            if (i2 > objArr.length) {
                this.ql = Arrays.copyOf(objArr, q.b.s(objArr.length, i2));
                this.qm = false;
            }
        }

        public a<K, V> l(K k, V v) {
            bj(this.oW + 1);
            j.j(k, v);
            Object[] objArr = this.ql;
            int i = this.oW;
            objArr[i * 2] = k;
            objArr[(i * 2) + 1] = v;
            this.oW = i + 1;
            return this;
        }

        public a<K, V> b(Map.Entry<? extends K, ? extends V> entry) {
            return l(entry.getKey(), entry.getValue());
        }

        public a<K, V> b(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
            if (iterable instanceof Collection) {
                bj(this.oW + ((Collection) iterable).size());
            }
            for (Map.Entry b : iterable) {
                b(b);
            }
            return this;
        }

        public u<K, V> gq() {
            gr();
            this.qm = true;
            return al.b(this.oW, this.ql);
        }

        /* access modifiers changed from: package-private */
        public void gr() {
            int i;
            if (this.qk != null) {
                if (this.qm) {
                    this.ql = Arrays.copyOf(this.ql, this.oW * 2);
                }
                Map.Entry[] entryArr = new Map.Entry[this.oW];
                int i2 = 0;
                while (true) {
                    i = this.oW;
                    if (i2 >= i) {
                        break;
                    }
                    Object[] objArr = this.ql;
                    int i3 = i2 * 2;
                    entryArr[i2] = new AbstractMap.SimpleImmutableEntry(objArr[i3], objArr[i3 + 1]);
                    i2++;
                }
                Arrays.sort(entryArr, 0, i, ai.b(this.qk).a(ab.gG()));
                for (int i4 = 0; i4 < this.oW; i4++) {
                    int i5 = i4 * 2;
                    this.ql[i5] = entryArr[i4].getKey();
                    this.ql[i5 + 1] = entryArr[i4].getValue();
                }
            }
        }
    }

    public static <K, V> u<K, V> a(Map<? extends K, ? extends V> map) {
        if ((map instanceof u) && !(map instanceof SortedMap)) {
            u<K, V> uVar = (u) map;
            if (!uVar.fZ()) {
                return uVar;
            }
        }
        return a(map.entrySet());
    }

    public static <K, V> u<K, V> a(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        a aVar = new a(iterable instanceof Collection ? ((Collection) iterable).size() : 4);
        aVar.b(iterable);
        return aVar.gq();
    }

    u() {
    }

    @Deprecated
    public final V put(K k, V v) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final V remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean containsKey(@NullableDecl Object obj) {
        return get(obj) != null;
    }

    public boolean containsValue(@NullableDecl Object obj) {
        return values().contains(obj);
    }

    public final V getOrDefault(@NullableDecl Object obj, @NullableDecl V v) {
        V v2 = get(obj);
        return v2 != null ? v2 : v;
    }

    /* renamed from: gk */
    public w<Map.Entry<K, V>> entrySet() {
        w<Map.Entry<K, V>> wVar = this.qh;
        if (wVar != null) {
            return wVar;
        }
        w<Map.Entry<K, V>> gl = gl();
        this.qh = gl;
        return gl;
    }

    /* renamed from: gm */
    public w<K> keySet() {
        w<K> wVar = this.qi;
        if (wVar != null) {
            return wVar;
        }
        w<K> gn = gn();
        this.qi = gn;
        return gn;
    }

    /* renamed from: go */
    public q<V> values() {
        q<V> qVar = this.qj;
        if (qVar != null) {
            return qVar;
        }
        q<V> gp = gp();
        this.qj = gp;
        return gp;
    }

    public boolean equals(@NullableDecl Object obj) {
        return ab.d(this, obj);
    }

    public int hashCode() {
        return aq.a(entrySet());
    }

    public String toString() {
        return ab.b(this);
    }
}
