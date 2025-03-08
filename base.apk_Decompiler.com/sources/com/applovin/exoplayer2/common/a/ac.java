package com.applovin.exoplayer2.common.a;

import java.util.Collection;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public interface ac<K, V> {
    boolean c(@NullableDecl K k, @NullableDecl V v);

    void clear();

    Map<K, Collection<V>> fc();

    boolean h(@NullableDecl Object obj, @NullableDecl Object obj2);

    boolean i(@NullableDecl Object obj, @NullableDecl Object obj2);

    Collection<V> k(@NullableDecl K k);

    int size();

    Collection<V> values();
}
