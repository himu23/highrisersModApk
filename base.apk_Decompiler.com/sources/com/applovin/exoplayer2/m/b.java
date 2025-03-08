package com.applovin.exoplayer2.m;

import android.os.Bundle;
import com.applovin.exoplayer2.g;
import com.ironsource.mediationsdk.logger.IronSourceError;
import java.util.Arrays;

public final class b implements g {
    public static final g.a<b> br = new b$$ExternalSyntheticLambda0();
    public final byte[] adl;
    private int dS;
    public final int yj;
    public final int yk;
    public final int yl;

    public static int fN(int i) {
        if (i == 1) {
            return 1;
        }
        if (i != 9) {
            return (i == 4 || i == 5 || i == 6 || i == 7) ? 2 : -1;
        }
        return 6;
    }

    public static int fO(int i) {
        if (i == 1) {
            return 3;
        }
        if (i == 16) {
            return 6;
        }
        if (i != 18) {
            return (i == 6 || i == 7) ? 3 : -1;
        }
        return 7;
    }

    public b(int i, int i2, int i3, byte[] bArr) {
        this.yj = i;
        this.yl = i2;
        this.yk = i3;
        this.adl = bArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        if (this.yj == bVar.yj && this.yl == bVar.yl && this.yk == bVar.yk && Arrays.equals(this.adl, bVar.adl)) {
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ColorInfo(");
        sb.append(this.yj);
        sb.append(", ");
        sb.append(this.yl);
        sb.append(", ");
        sb.append(this.yk);
        sb.append(", ");
        sb.append(this.adl != null);
        sb.append(")");
        return sb.toString();
    }

    public int hashCode() {
        if (this.dS == 0) {
            this.dS = ((((((IronSourceError.ERROR_NON_EXISTENT_INSTANCE + this.yj) * 31) + this.yl) * 31) + this.yk) * 31) + Arrays.hashCode(this.adl);
        }
        return this.dS;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ b G(Bundle bundle) {
        return new b(bundle.getInt(t(0), -1), bundle.getInt(t(1), -1), bundle.getInt(t(2), -1), bundle.getByteArray(t(3)));
    }

    private static String t(int i) {
        return Integer.toString(i, 36);
    }
}
