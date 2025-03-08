package com.applovin.exoplayer2.j;

import android.util.Pair;
import com.applovin.exoplayer2.as;
import com.applovin.exoplayer2.at;
import com.applovin.exoplayer2.ba;
import com.applovin.exoplayer2.h.ac;
import com.applovin.exoplayer2.h.ad;
import com.applovin.exoplayer2.h.p;
import com.applovin.exoplayer2.l.ai;
import com.applovin.exoplayer2.l.u;

public abstract class f extends j {
    private a UU;

    /* access modifiers changed from: protected */
    public abstract Pair<at[], d[]> a(a aVar, int[][][] iArr, int[] iArr2, p.a aVar2, ba baVar) throws com.applovin.exoplayer2.p;

    public static final class a {
        private final int UV;
        private final String[] UW;
        private final int[] UX;
        private final ad[] UY;
        private final int[] UZ;
        private final int[][][] Va;
        private final ad Vb;

        public int np() {
            return this.UV;
        }

        a(String[] strArr, int[] iArr, ad[] adVarArr, int[] iArr2, int[][][] iArr3, ad adVar) {
            this.UW = strArr;
            this.UX = iArr;
            this.UY = adVarArr;
            this.Va = iArr3;
            this.UZ = iArr2;
            this.Vb = adVar;
            this.UV = iArr.length;
        }

        public int eS(int i) {
            return this.UX[i];
        }

        public ad eT(int i) {
            return this.UY[i];
        }
    }

    public final void J(Object obj) {
        this.UU = (a) obj;
    }

    public final k a(as[] asVarArr, ad adVar, p.a aVar, ba baVar) throws com.applovin.exoplayer2.p {
        int[] iArr;
        as[] asVarArr2 = asVarArr;
        ad adVar2 = adVar;
        int[] iArr2 = new int[(asVarArr2.length + 1)];
        int length = asVarArr2.length + 1;
        ac[][] acVarArr = new ac[length][];
        int[][][] iArr3 = new int[(asVarArr2.length + 1)][][];
        for (int i = 0; i < length; i++) {
            acVarArr[i] = new ac[adVar2.fR];
            iArr3[i] = new int[adVar2.fR][];
        }
        int[] a2 = a(asVarArr);
        for (int i2 = 0; i2 < adVar2.fR; i2++) {
            ac eb = adVar2.eb(i2);
            int a3 = a(asVarArr, eb, iArr2, u.ba(eb.dZ(0).dz) == 5);
            if (a3 == asVarArr2.length) {
                iArr = new int[eb.fR];
            } else {
                iArr = a(asVarArr2[a3], eb);
            }
            int i3 = iArr2[a3];
            acVarArr[a3][i3] = eb;
            iArr3[a3][i3] = iArr;
            iArr2[a3] = i3 + 1;
        }
        ad[] adVarArr = new ad[asVarArr2.length];
        String[] strArr = new String[asVarArr2.length];
        int[] iArr4 = new int[asVarArr2.length];
        for (int i4 = 0; i4 < asVarArr2.length; i4++) {
            int i5 = iArr2[i4];
            adVarArr[i4] = new ad((ac[]) ai.e(acVarArr[i4], i5));
            iArr3[i4] = (int[][]) ai.e(iArr3[i4], i5);
            strArr[i4] = asVarArr2[i4].getName();
            iArr4[i4] = asVarArr2[i4].M();
        }
        a aVar2 = new a(strArr, iArr4, adVarArr, a2, iArr3, new ad((ac[]) ai.e(acVarArr[asVarArr2.length], iArr2[asVarArr2.length])));
        Pair<at[], d[]> a4 = a(aVar2, iArr3, a2, aVar, baVar);
        return new k((at[]) a4.first, (d[]) a4.second, aVar2);
    }

    private static int a(as[] asVarArr, ac acVar, int[] iArr, boolean z) throws com.applovin.exoplayer2.p {
        int length = asVarArr.length;
        int i = 0;
        boolean z2 = true;
        for (int i2 = 0; i2 < asVarArr.length; i2++) {
            as asVar = asVarArr[i2];
            int i3 = 0;
            for (int i4 = 0; i4 < acVar.fR; i4++) {
                i3 = Math.max(i3, as.CC.af(asVar.b(acVar.dZ(i4))));
            }
            boolean z3 = iArr[i2] == 0;
            if (i3 > i || (i3 == i && z && !z2 && z3)) {
                length = i2;
                z2 = z3;
                i = i3;
            }
        }
        return length;
    }

    private static int[] a(as asVar, ac acVar) throws com.applovin.exoplayer2.p {
        int[] iArr = new int[acVar.fR];
        for (int i = 0; i < acVar.fR; i++) {
            iArr[i] = asVar.b(acVar.dZ(i));
        }
        return iArr;
    }

    private static int[] a(as[] asVarArr) throws com.applovin.exoplayer2.p {
        int length = asVarArr.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = asVarArr[i].Z();
        }
        return iArr;
    }
}
