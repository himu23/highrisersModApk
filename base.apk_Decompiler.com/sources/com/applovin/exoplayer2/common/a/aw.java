package com.applovin.exoplayer2.common.a;

import com.applovin.exoplayer2.common.base.Preconditions;
import java.util.Iterator;

abstract class aw<F, T> implements Iterator<T> {
    final Iterator<? extends F> ri;

    /* access modifiers changed from: package-private */
    public abstract T A(F f);

    aw(Iterator<? extends F> it) {
        this.ri = (Iterator) Preconditions.checkNotNull(it);
    }

    public final boolean hasNext() {
        return this.ri.hasNext();
    }

    public final T next() {
        return A(this.ri.next());
    }

    public final void remove() {
        this.ri.remove();
    }
}
