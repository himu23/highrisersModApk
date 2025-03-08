package com.applovin.exoplayer2.common.a;

import com.applovin.exoplayer2.common.base.Preconditions;
import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class ao<T> extends ai<T> implements Serializable {
    final ai<? super T> qY;

    public <S extends T> ai<S> gO() {
        return this.qY;
    }

    ao(ai<? super T> aiVar) {
        this.qY = (ai) Preconditions.checkNotNull(aiVar);
    }

    public int compare(T t, T t2) {
        return this.qY.compare(t2, t);
    }

    public int hashCode() {
        return -this.qY.hashCode();
    }

    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ao) {
            return this.qY.equals(((ao) obj).qY);
        }
        return false;
    }

    public String toString() {
        return this.qY + ".reverse()";
    }
}
