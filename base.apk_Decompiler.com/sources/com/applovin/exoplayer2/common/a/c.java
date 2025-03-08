package com.applovin.exoplayer2.common.a;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

abstract class c<K, V> extends d<K, V> implements z<K, V> {
    /* access modifiers changed from: package-private */
    /* renamed from: fb */
    public abstract List<V> fd();

    protected c(Map<K, Collection<V>> map) {
        super(map);
    }

    /* access modifiers changed from: package-private */
    public <E> Collection<E> a(Collection<E> collection) {
        return Collections.unmodifiableList((List) collection);
    }

    /* access modifiers changed from: package-private */
    public Collection<V> a(K k, Collection<V> collection) {
        return a(k, (List) collection, (d<K, V>.i) null);
    }

    /* renamed from: j */
    public List<V> k(@NullableDecl K k) {
        return (List) super.k(k);
    }

    public boolean c(@NullableDecl K k, @NullableDecl V v) {
        return super.c(k, v);
    }

    public Map<K, Collection<V>> fc() {
        return super.fc();
    }

    public boolean equals(@NullableDecl Object obj) {
        return super.equals(obj);
    }
}
