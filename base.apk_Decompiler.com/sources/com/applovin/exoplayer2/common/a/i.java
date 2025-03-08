package com.applovin.exoplayer2.common.a;

import com.applovin.exoplayer2.common.base.Function;
import com.applovin.exoplayer2.common.base.Objects;
import com.applovin.exoplayer2.common.base.Preconditions;
import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class i<F, T> extends ai<F> implements Serializable {
    final Function<F, ? extends T> pE;
    final ai<T> pF;

    i(Function<F, ? extends T> function, ai<T> aiVar) {
        this.pE = (Function) Preconditions.checkNotNull(function);
        this.pF = (ai) Preconditions.checkNotNull(aiVar);
    }

    public int compare(F f, F f2) {
        return this.pF.compare(this.pE.apply(f), this.pE.apply(f2));
    }

    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        if (!this.pE.equals(iVar.pE) || !this.pF.equals(iVar.pF)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Objects.hashCode(this.pE, this.pF);
    }

    public String toString() {
        return this.pF + ".onResultOf(" + this.pE + ")";
    }
}
