package com.applovin.exoplayer2.common.a;

import com.applovin.exoplayer2.common.base.Preconditions;
import java.io.Serializable;

final class an extends ai<Comparable> implements Serializable {
    static final an qX = new an();

    public String toString() {
        return "Ordering.natural().reverse()";
    }

    /* renamed from: a */
    public int compare(Comparable comparable, Comparable comparable2) {
        Preconditions.checkNotNull(comparable);
        if (comparable == comparable2) {
            return 0;
        }
        return comparable2.compareTo(comparable);
    }

    public <S extends Comparable> ai<S> gO() {
        return ai.gP();
    }

    private an() {
    }
}
