package com.applovin.exoplayer2.common.a;

import com.applovin.exoplayer2.common.base.Preconditions;
import java.io.Serializable;

final class ag extends ai<Comparable> implements Serializable {
    static final ag qN = new ag();

    public String toString() {
        return "Ordering.natural()";
    }

    /* renamed from: a */
    public int compare(Comparable comparable, Comparable comparable2) {
        Preconditions.checkNotNull(comparable);
        Preconditions.checkNotNull(comparable2);
        return comparable.compareTo(comparable2);
    }

    public <S extends Comparable> ai<S> gO() {
        return an.qX;
    }

    private ag() {
    }
}
