package com.applovin.exoplayer2.common.a;

import java.util.Iterator;

public abstract class ax<E> implements Iterator<E> {
    protected ax() {
    }

    @Deprecated
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
