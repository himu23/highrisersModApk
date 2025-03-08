package com.applovin.exoplayer2;

import android.os.Bundle;
import com.applovin.exoplayer2.d.e;
import com.applovin.exoplayer2.g;
import com.applovin.exoplayer2.l.ai;
import com.applovin.exoplayer2.l.c;
import com.applovin.exoplayer2.m.b;
import com.ironsource.mediationsdk.logger.IronSourceError;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class v implements g {
    public static final g.a<v> br = new v$$ExternalSyntheticLambda0();
    private static final v dn = new a().bT();
    public final int dA;
    public final List<byte[]> dB;
    public final e dC;
    public final long dD;
    public final int dE;
    public final float dF;
    public final int dG;
    public final float dH;
    public final byte[] dI;
    public final int dJ;
    public final b dK;
    public final int dL;
    public final int dM;
    public final int dN;
    public final int dO;
    public final int dP;
    public final int dQ;
    public final int dR;
    private int dS;

    /* renamed from: do  reason: not valid java name */
    public final String f8do;
    public final String dp;
    public final String dq;
    public final int dr;
    public final int ds;
    public final int dt;
    public final int du;
    public final int dv;
    public final String dw;
    public final com.applovin.exoplayer2.g.a dx;
    public final String dy;
    public final String dz;
    public final int height;

    private static <T> T b(T t, T t2) {
        return t != null ? t : t2;
    }

    public int bS() {
        int i;
        int i2 = this.dE;
        if (i2 == -1 || (i = this.height) == -1) {
            return -1;
        }
        return i2 * i;
    }

    public static final class a {
        /* access modifiers changed from: private */
        public int dA;
        /* access modifiers changed from: private */
        public List<byte[]> dB;
        /* access modifiers changed from: private */
        public e dC;
        /* access modifiers changed from: private */
        public long dD;
        /* access modifiers changed from: private */
        public int dE;
        /* access modifiers changed from: private */
        public float dF;
        /* access modifiers changed from: private */
        public int dG;
        /* access modifiers changed from: private */
        public float dH;
        /* access modifiers changed from: private */
        public byte[] dI;
        /* access modifiers changed from: private */
        public int dJ;
        /* access modifiers changed from: private */
        public b dK;
        /* access modifiers changed from: private */
        public int dL;
        /* access modifiers changed from: private */
        public int dM;
        /* access modifiers changed from: private */
        public int dN;
        /* access modifiers changed from: private */
        public int dO;
        /* access modifiers changed from: private */
        public int dP;
        /* access modifiers changed from: private */
        public int dQ;
        /* access modifiers changed from: private */
        public int dR;
        /* access modifiers changed from: private */

        /* renamed from: do  reason: not valid java name */
        public String f9do;
        /* access modifiers changed from: private */
        public String dp;
        /* access modifiers changed from: private */
        public String dq;
        /* access modifiers changed from: private */
        public int dr;
        /* access modifiers changed from: private */
        public int ds;
        /* access modifiers changed from: private */
        public int dt;
        /* access modifiers changed from: private */
        public int du;
        /* access modifiers changed from: private */
        public String dw;
        /* access modifiers changed from: private */
        public com.applovin.exoplayer2.g.a dx;
        /* access modifiers changed from: private */
        public String dy;
        /* access modifiers changed from: private */
        public String dz;
        /* access modifiers changed from: private */
        public int height;

        public a E(int i) {
            this.dr = i;
            return this;
        }

        public a F(int i) {
            this.ds = i;
            return this;
        }

        public a G(int i) {
            this.dt = i;
            return this;
        }

        public a H(int i) {
            this.du = i;
            return this;
        }

        public a I(int i) {
            this.dA = i;
            return this;
        }

        public a J(int i) {
            this.dE = i;
            return this;
        }

        public a K(int i) {
            this.height = i;
            return this;
        }

        public a L(int i) {
            this.dG = i;
            return this;
        }

        public a M(int i) {
            this.dJ = i;
            return this;
        }

        public a N(int i) {
            this.dL = i;
            return this;
        }

        public a O(int i) {
            this.dM = i;
            return this;
        }

        public a P(int i) {
            this.dN = i;
            return this;
        }

        public a Q(int i) {
            this.dO = i;
            return this;
        }

        public a R(int i) {
            this.dP = i;
            return this;
        }

        public a S(int i) {
            this.dQ = i;
            return this;
        }

        public a T(int i) {
            this.dR = i;
            return this;
        }

        public a a(e eVar) {
            this.dC = eVar;
            return this;
        }

        public a a(b bVar) {
            this.dK = bVar;
            return this;
        }

        public a a(byte[] bArr) {
            this.dI = bArr;
            return this;
        }

        public a b(com.applovin.exoplayer2.g.a aVar) {
            this.dx = aVar;
            return this;
        }

        public a c(List<byte[]> list) {
            this.dB = list;
            return this;
        }

        public a d(float f) {
            this.dF = f;
            return this;
        }

        public a e(float f) {
            this.dH = f;
            return this;
        }

        public a g(String str) {
            this.f9do = str;
            return this;
        }

        public a h(String str) {
            this.dp = str;
            return this;
        }

        public a j(String str) {
            this.dq = str;
            return this;
        }

        public a k(String str) {
            this.dw = str;
            return this;
        }

        public a l(String str) {
            this.dy = str;
            return this;
        }

        public a m(String str) {
            this.dz = str;
            return this;
        }

        public a p(long j) {
            this.dD = j;
            return this;
        }

        public a() {
            this.dt = -1;
            this.du = -1;
            this.dA = -1;
            this.dD = Long.MAX_VALUE;
            this.dE = -1;
            this.height = -1;
            this.dF = -1.0f;
            this.dH = 1.0f;
            this.dJ = -1;
            this.dL = -1;
            this.dM = -1;
            this.dN = -1;
            this.dQ = -1;
            this.dR = 0;
        }

        private a(v vVar) {
            this.f9do = vVar.f8do;
            this.dp = vVar.dp;
            this.dq = vVar.dq;
            this.dr = vVar.dr;
            this.ds = vVar.ds;
            this.dt = vVar.dt;
            this.du = vVar.du;
            this.dw = vVar.dw;
            this.dx = vVar.dx;
            this.dy = vVar.dy;
            this.dz = vVar.dz;
            this.dA = vVar.dA;
            this.dB = vVar.dB;
            this.dC = vVar.dC;
            this.dD = vVar.dD;
            this.dE = vVar.dE;
            this.height = vVar.height;
            this.dF = vVar.dF;
            this.dG = vVar.dG;
            this.dH = vVar.dH;
            this.dI = vVar.dI;
            this.dJ = vVar.dJ;
            this.dK = vVar.dK;
            this.dL = vVar.dL;
            this.dM = vVar.dM;
            this.dN = vVar.dN;
            this.dO = vVar.dO;
            this.dP = vVar.dP;
            this.dQ = vVar.dQ;
            this.dR = vVar.dR;
        }

        public a D(int i) {
            this.f9do = Integer.toString(i);
            return this;
        }

        public v bT() {
            return new v(this);
        }
    }

    private v(a aVar) {
        this.f8do = aVar.f9do;
        this.dp = aVar.dp;
        this.dq = ai.bj(aVar.dq);
        this.dr = aVar.dr;
        this.ds = aVar.ds;
        int f = aVar.dt;
        this.dt = f;
        int g = aVar.du;
        this.du = g;
        this.dv = g != -1 ? g : f;
        this.dw = aVar.dw;
        this.dx = aVar.dx;
        this.dy = aVar.dy;
        this.dz = aVar.dz;
        this.dA = aVar.dA;
        this.dB = aVar.dB == null ? Collections.emptyList() : aVar.dB;
        e n = aVar.dC;
        this.dC = n;
        this.dD = aVar.dD;
        this.dE = aVar.dE;
        this.height = aVar.height;
        this.dF = aVar.dF;
        int i = 0;
        this.dG = aVar.dG == -1 ? 0 : aVar.dG;
        this.dH = aVar.dH == -1.0f ? 1.0f : aVar.dH;
        this.dI = aVar.dI;
        this.dJ = aVar.dJ;
        this.dK = aVar.dK;
        this.dL = aVar.dL;
        this.dM = aVar.dM;
        this.dN = aVar.dN;
        this.dO = aVar.dO == -1 ? 0 : aVar.dO;
        this.dP = aVar.dP != -1 ? aVar.dP : i;
        this.dQ = aVar.dQ;
        if (aVar.dR != 0 || n == null) {
            this.dR = aVar.dR;
        } else {
            this.dR = 1;
        }
    }

    public a bR() {
        return new a();
    }

    public v B(int i) {
        return bR().T(i).bT();
    }

    public String toString() {
        return "Format(" + this.f8do + ", " + this.dp + ", " + this.dy + ", " + this.dz + ", " + this.dw + ", " + this.dv + ", " + this.dq + ", [" + this.dE + ", " + this.height + ", " + this.dF + "], [" + this.dL + ", " + this.dM + "])";
    }

    public int hashCode() {
        int i;
        int i2;
        int i3;
        int i4;
        if (this.dS == 0) {
            String str = this.f8do;
            int i5 = 0;
            int hashCode = (IronSourceError.ERROR_NON_EXISTENT_INSTANCE + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.dp;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.dq;
            if (str3 == null) {
                i = 0;
            } else {
                i = str3.hashCode();
            }
            int i6 = (((((((((hashCode2 + i) * 31) + this.dr) * 31) + this.ds) * 31) + this.dt) * 31) + this.du) * 31;
            String str4 = this.dw;
            if (str4 == null) {
                i2 = 0;
            } else {
                i2 = str4.hashCode();
            }
            int i7 = (i6 + i2) * 31;
            com.applovin.exoplayer2.g.a aVar = this.dx;
            if (aVar == null) {
                i3 = 0;
            } else {
                i3 = aVar.hashCode();
            }
            int i8 = (i7 + i3) * 31;
            String str5 = this.dy;
            if (str5 == null) {
                i4 = 0;
            } else {
                i4 = str5.hashCode();
            }
            int i9 = (i8 + i4) * 31;
            String str6 = this.dz;
            if (str6 != null) {
                i5 = str6.hashCode();
            }
            this.dS = ((((((((((((((((((((((((((((((i9 + i5) * 31) + this.dA) * 31) + ((int) this.dD)) * 31) + this.dE) * 31) + this.height) * 31) + Float.floatToIntBits(this.dF)) * 31) + this.dG) * 31) + Float.floatToIntBits(this.dH)) * 31) + this.dJ) * 31) + this.dL) * 31) + this.dM) * 31) + this.dN) * 31) + this.dO) * 31) + this.dP) * 31) + this.dQ) * 31) + this.dR;
        }
        return this.dS;
    }

    public boolean equals(Object obj) {
        int i;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        v vVar = (v) obj;
        int i2 = this.dS;
        if ((i2 == 0 || (i = vVar.dS) == 0 || i2 == i) && this.dr == vVar.dr && this.ds == vVar.ds && this.dt == vVar.dt && this.du == vVar.du && this.dA == vVar.dA && this.dD == vVar.dD && this.dE == vVar.dE && this.height == vVar.height && this.dG == vVar.dG && this.dJ == vVar.dJ && this.dL == vVar.dL && this.dM == vVar.dM && this.dN == vVar.dN && this.dO == vVar.dO && this.dP == vVar.dP && this.dQ == vVar.dQ && this.dR == vVar.dR && Float.compare(this.dF, vVar.dF) == 0 && Float.compare(this.dH, vVar.dH) == 0 && ai.r(this.f8do, vVar.f8do) && ai.r(this.dp, vVar.dp) && ai.r(this.dw, vVar.dw) && ai.r(this.dy, vVar.dy) && ai.r(this.dz, vVar.dz) && ai.r(this.dq, vVar.dq) && Arrays.equals(this.dI, vVar.dI) && ai.r(this.dx, vVar.dx) && ai.r(this.dK, vVar.dK) && ai.r(this.dC, vVar.dC) && a(vVar)) {
            return true;
        }
        return false;
    }

    public boolean a(v vVar) {
        if (this.dB.size() != vVar.dB.size()) {
            return false;
        }
        for (int i = 0; i < this.dB.size(); i++) {
            if (!Arrays.equals(this.dB.get(i), vVar.dB.get(i))) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static v b(Bundle bundle) {
        a aVar = new a();
        c.F(bundle);
        int i = 0;
        String string = bundle.getString(t(0));
        v vVar = dn;
        aVar.g((String) b(string, vVar.f8do)).h((String) b(bundle.getString(t(1)), vVar.dp)).j((String) b(bundle.getString(t(2)), vVar.dq)).E(bundle.getInt(t(3), vVar.dr)).F(bundle.getInt(t(4), vVar.ds)).G(bundle.getInt(t(5), vVar.dt)).H(bundle.getInt(t(6), vVar.du)).k((String) b(bundle.getString(t(7)), vVar.dw)).b((com.applovin.exoplayer2.g.a) b((com.applovin.exoplayer2.g.a) bundle.getParcelable(t(8)), vVar.dx)).l((String) b(bundle.getString(t(9)), vVar.dy)).m((String) b(bundle.getString(t(10)), vVar.dz)).I(bundle.getInt(t(11), vVar.dA));
        ArrayList arrayList = new ArrayList();
        while (true) {
            byte[] byteArray = bundle.getByteArray(C(i));
            if (byteArray == null) {
                a a2 = aVar.c((List<byte[]>) arrayList).a((e) bundle.getParcelable(t(13)));
                String t = t(14);
                v vVar2 = dn;
                a2.p(bundle.getLong(t, vVar2.dD)).J(bundle.getInt(t(15), vVar2.dE)).K(bundle.getInt(t(16), vVar2.height)).d(bundle.getFloat(t(17), vVar2.dF)).L(bundle.getInt(t(18), vVar2.dG)).e(bundle.getFloat(t(19), vVar2.dH)).a(bundle.getByteArray(t(20))).M(bundle.getInt(t(21), vVar2.dJ)).a((b) c.a(b.br, bundle.getBundle(t(22)))).N(bundle.getInt(t(23), vVar2.dL)).O(bundle.getInt(t(24), vVar2.dM)).P(bundle.getInt(t(25), vVar2.dN)).Q(bundle.getInt(t(26), vVar2.dO)).R(bundle.getInt(t(27), vVar2.dP)).S(bundle.getInt(t(28), vVar2.dQ)).T(bundle.getInt(t(29), vVar2.dR));
                return aVar.bT();
            }
            arrayList.add(byteArray);
            i++;
        }
    }

    private static String t(int i) {
        return Integer.toString(i, 36);
    }

    private static String C(int i) {
        return t(12) + "_" + Integer.toString(i, 36);
    }
}
