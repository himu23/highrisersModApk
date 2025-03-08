package com.applovin.exoplayer2.common.a;

import java.util.ListIterator;

public abstract class ay<E> extends ax<E> implements ListIterator<E> {
    protected ay() {
    }

    @Deprecated
    public final void add(E e) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void set(E e) {
        throw new UnsupportedOperationException();
    }
}
