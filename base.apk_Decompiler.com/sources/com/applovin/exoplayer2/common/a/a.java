package com.applovin.exoplayer2.common.a;

import com.applovin.exoplayer2.common.base.Preconditions;
import java.util.NoSuchElementException;

abstract class a<E> extends ay<E> {
    private final int oW;
    private int oX;

    /* access modifiers changed from: protected */
    public abstract E get(int i);

    public final boolean hasNext() {
        return this.oX < this.oW;
    }

    public final boolean hasPrevious() {
        return this.oX > 0;
    }

    public final int nextIndex() {
        return this.oX;
    }

    public final int previousIndex() {
        return this.oX - 1;
    }

    protected a(int i, int i2) {
        Preconditions.checkPositionIndex(i2, i);
        this.oW = i;
        this.oX = i2;
    }

    public final E next() {
        if (hasNext()) {
            int i = this.oX;
            this.oX = i + 1;
            return get(i);
        }
        throw new NoSuchElementException();
    }

    public final E previous() {
        if (hasPrevious()) {
            int i = this.oX - 1;
            this.oX = i;
            return get(i);
        }
        throw new NoSuchElementException();
    }
}
