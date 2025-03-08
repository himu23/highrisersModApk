package com.applovin.exoplayer2.common.a;

import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

class r<K, V> extends e<K, V> implements Serializable {
    @NullableDecl
    final V oy;
    @NullableDecl
    final K pn;

    @NullableDecl
    public final K getKey() {
        return this.pn;
    }

    @NullableDecl
    public final V getValue() {
        return this.oy;
    }

    r(@NullableDecl K k, @NullableDecl V v) {
        this.pn = k;
        this.oy = v;
    }

    public final V setValue(V v) {
        throw new UnsupportedOperationException();
    }
}
