package com.applovin.exoplayer2.common.a;

import com.applovin.exoplayer2.common.base.Preconditions;
import java.io.Serializable;
import java.util.Comparator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class m<T> extends ai<T> implements Serializable {
    final Comparator<T> pV;

    m(Comparator<T> comparator) {
        this.pV = (Comparator) Preconditions.checkNotNull(comparator);
    }

    public int compare(T t, T t2) {
        return this.pV.compare(t, t2);
    }

    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof m) {
            return this.pV.equals(((m) obj).pV);
        }
        return false;
    }

    public int hashCode() {
        return this.pV.hashCode();
    }

    public String toString() {
        return this.pV.toString();
    }
}
