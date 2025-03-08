package com.applovin.exoplayer2.common.a;

import com.applovin.exoplayer2.common.a.ae;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

abstract class f<K, V> implements ac<K, V> {
    @MonotonicNonNullDecl
    private transient Set<K> pA;
    @MonotonicNonNullDecl
    private transient Collection<V> pB;
    @MonotonicNonNullDecl
    private transient Map<K, Collection<V>> pC;
    @MonotonicNonNullDecl
    private transient Collection<Map.Entry<K, V>> pz;

    /* access modifiers changed from: package-private */
    public abstract Set<K> fe();

    /* access modifiers changed from: package-private */
    public abstract Collection<V> fg();

    /* access modifiers changed from: package-private */
    public abstract Collection<Map.Entry<K, V>> fj();

    /* access modifiers changed from: package-private */
    public abstract Iterator<Map.Entry<K, V>> fk();

    /* access modifiers changed from: package-private */
    public abstract Map<K, Collection<V>> fl();

    f() {
    }

    public boolean containsValue(@NullableDecl Object obj) {
        for (Collection contains : fc().values()) {
            if (contains.contains(obj)) {
                return true;
            }
        }
        return false;
    }

    public boolean h(@NullableDecl Object obj, @NullableDecl Object obj2) {
        Collection collection = (Collection) fc().get(obj);
        return collection != null && collection.contains(obj2);
    }

    public boolean i(@NullableDecl Object obj, @NullableDecl Object obj2) {
        Collection collection = (Collection) fc().get(obj);
        return collection != null && collection.remove(obj2);
    }

    public boolean c(@NullableDecl K k, @NullableDecl V v) {
        return k(k).add(v);
    }

    public Collection<Map.Entry<K, V>> fi() {
        Collection<Map.Entry<K, V>> collection = this.pz;
        if (collection != null) {
            return collection;
        }
        Collection<Map.Entry<K, V>> fj = fj();
        this.pz = fj;
        return fj;
    }

    class a extends ae.b<K, V> {
        /* access modifiers changed from: package-private */
        public ac<K, V> fF() {
            return f.this;
        }

        a() {
        }

        public Iterator<Map.Entry<K, V>> iterator() {
            return f.this.fk();
        }
    }

    class b extends f<K, V>.a implements Set<Map.Entry<K, V>> {
        b() {
            super();
        }

        public int hashCode() {
            return aq.a(this);
        }

        public boolean equals(@NullableDecl Object obj) {
            return aq.a((Set<?>) this, obj);
        }
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

    public Collection<V> values() {
        Collection<V> collection = this.pB;
        if (collection != null) {
            return collection;
        }
        Collection<V> fg = fg();
        this.pB = fg;
        return fg;
    }

    class c extends AbstractCollection<V> {
        c() {
        }

        public Iterator<V> iterator() {
            return f.this.fh();
        }

        public int size() {
            return f.this.size();
        }

        public boolean contains(@NullableDecl Object obj) {
            return f.this.containsValue(obj);
        }

        public void clear() {
            f.this.clear();
        }
    }

    /* access modifiers changed from: package-private */
    public Iterator<V> fh() {
        return ab.h(fi().iterator());
    }

    public Map<K, Collection<V>> fc() {
        Map<K, Collection<V>> map = this.pC;
        if (map != null) {
            return map;
        }
        Map<K, Collection<V>> fl = fl();
        this.pC = fl;
        return fl;
    }

    public boolean equals(@NullableDecl Object obj) {
        return ae.a((ac<?, ?>) this, obj);
    }

    public int hashCode() {
        return fc().hashCode();
    }

    public String toString() {
        return fc().toString();
    }
}
