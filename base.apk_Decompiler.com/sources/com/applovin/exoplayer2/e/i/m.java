package com.applovin.exoplayer2.e.i;

import android.util.SparseArray;
import com.applovin.exoplayer2.e.i.ad;
import com.applovin.exoplayer2.e.j;
import com.applovin.exoplayer2.e.x;
import com.applovin.exoplayer2.l.ai;
import com.applovin.exoplayer2.l.e;
import com.applovin.exoplayer2.l.v;
import com.applovin.exoplayer2.l.y;
import com.applovin.exoplayer2.l.z;
import com.applovin.exoplayer2.v;
import com.unity3d.services.core.device.MimeTypes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class m implements j {
    private String Ct;
    private final boolean DA;
    private final boolean DB;
    private final r DC = new r(7, 128);
    private final r DD = new r(8, 128);
    private final r DE = new r(6, 128);
    private a DF;
    private boolean DG;
    private final y DH = new y();
    private final boolean[] Df = new boolean[3];
    private long Dh;
    private long Dk = -9223372036854775807L;
    private final z Dz;
    private boolean vJ;
    private x wl;

    public void e(long j, int i) {
        if (j != -9223372036854775807L) {
            this.Dk = j;
        }
        this.DG |= (i & 2) != 0;
    }

    public void jc() {
    }

    public m(z zVar, boolean z, boolean z2) {
        this.Dz = zVar;
        this.DA = z;
        this.DB = z2;
    }

    public void jb() {
        this.Dh = 0;
        this.DG = false;
        this.Dk = -9223372036854775807L;
        v.b(this.Df);
        this.DC.Y();
        this.DD.Y();
        this.DE.Y();
        a aVar = this.DF;
        if (aVar != null) {
            aVar.Y();
        }
    }

    public void a(j jVar, ad.d dVar) {
        dVar.jy();
        this.Ct = dVar.jA();
        x y = jVar.y(dVar.jz(), 2);
        this.wl = y;
        this.DF = new a(y, this.DA, this.DB);
        this.Dz.a(jVar, dVar);
    }

    public void K(y yVar) {
        jm();
        int il = yVar.il();
        int pk = yVar.pk();
        byte[] hO = yVar.hO();
        this.Dh += (long) yVar.pj();
        this.wl.c(yVar, yVar.pj());
        while (true) {
            int a2 = v.a(hO, il, pk, this.Df);
            if (a2 == pk) {
                f(hO, il, pk);
                return;
            }
            int j = v.j(hO, a2);
            int i = a2 - il;
            if (i > 0) {
                f(hO, il, a2);
            }
            int i2 = pk - a2;
            long j2 = this.Dh - ((long) i2);
            a(j2, i2, i < 0 ? -i : 0, this.Dk);
            a(j2, j, this.Dk);
            il = a2 + 3;
        }
    }

    private void a(long j, int i, long j2) {
        if (!this.vJ || this.DF.jo()) {
            this.DC.cB(i);
            this.DD.cB(i);
        }
        this.DE.cB(i);
        this.DF.a(j, i, j2);
    }

    private void f(byte[] bArr, int i, int i2) {
        if (!this.vJ || this.DF.jo()) {
            this.DC.g(bArr, i, i2);
            this.DD.g(bArr, i, i2);
        }
        this.DE.g(bArr, i, i2);
        this.DF.g(bArr, i, i2);
    }

    private void a(long j, int i, int i2, long j2) {
        if (!this.vJ || this.DF.jo()) {
            this.DC.cC(i2);
            this.DD.cC(i2);
            if (!this.vJ) {
                if (this.DC.jq() && this.DD.jq()) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(Arrays.copyOf(this.DC.EJ, this.DC.EK));
                    arrayList.add(Arrays.copyOf(this.DD.EJ, this.DD.EK));
                    v.b n = v.n(this.DC.EJ, 3, this.DC.EK);
                    v.a o = v.o(this.DD.EJ, 3, this.DD.EK);
                    this.wl.j(new v.a().g(this.Ct).m(MimeTypes.VIDEO_H264).k(e.i(n.acv, n.acw, n.acx)).J(n.dE).K(n.height).e(n.acy).c((List<byte[]>) arrayList).bT());
                    this.vJ = true;
                    this.DF.a(n);
                    this.DF.a(o);
                    this.DC.Y();
                    this.DD.Y();
                }
            } else if (this.DC.jq()) {
                this.DF.a(com.applovin.exoplayer2.l.v.n(this.DC.EJ, 3, this.DC.EK));
                this.DC.Y();
            } else if (this.DD.jq()) {
                this.DF.a(com.applovin.exoplayer2.l.v.o(this.DD.EJ, 3, this.DD.EK));
                this.DD.Y();
            }
        }
        if (this.DE.cC(i2)) {
            this.DH.l(this.DE.EJ, com.applovin.exoplayer2.l.v.i(this.DE.EJ, this.DE.EK));
            this.DH.fx(4);
            this.Dz.a(j2, this.DH);
        }
        if (this.DF.a(j, i, this.vJ, this.DG)) {
            this.DG = false;
        }
    }

    private void jm() {
        com.applovin.exoplayer2.l.a.N(this.wl);
        ai.R(this.DF);
    }

    private static final class a {
        private final boolean DA;
        private final boolean DB;
        private final SparseArray<v.b> DI = new SparseArray<>();
        private final SparseArray<v.a> DJ = new SparseArray<>();
        private final z DK;
        private byte[] DL;
        private int DM;
        private int DN;
        private long DO;
        private long DP;
        private C0044a DQ = new C0044a();
        private C0044a DR = new C0044a();
        private long Da;
        private long Dl;
        private boolean Dm;
        private boolean Dp;
        private boolean Dv;
        private final x wl;

        public boolean jo() {
            return this.DB;
        }

        public a(x xVar, boolean z, boolean z2) {
            this.wl = xVar;
            this.DA = z;
            this.DB = z2;
            byte[] bArr = new byte[128];
            this.DL = bArr;
            this.DK = new z(bArr, 0, 0);
            Y();
        }

        public void a(v.b bVar) {
            this.DI.append(bVar.act, bVar);
        }

        public void a(v.a aVar) {
            this.DJ.append(aVar.DY, aVar);
        }

        public void Y() {
            this.Dp = false;
            this.Dv = false;
            this.DR.clear();
        }

        public void a(long j, int i, long j2) {
            this.DN = i;
            this.DP = j2;
            this.DO = j;
            if (!this.DA || i != 1) {
                if (!this.DB) {
                    return;
                }
                if (!(i == 5 || i == 1 || i == 2)) {
                    return;
                }
            }
            C0044a aVar = this.DQ;
            this.DQ = this.DR;
            this.DR = aVar;
            aVar.clear();
            this.DM = 0;
            this.Dp = true;
        }

        /* JADX WARNING: Removed duplicated region for block: B:51:0x00ff  */
        /* JADX WARNING: Removed duplicated region for block: B:52:0x0102  */
        /* JADX WARNING: Removed duplicated region for block: B:54:0x0106  */
        /* JADX WARNING: Removed duplicated region for block: B:58:0x0118  */
        /* JADX WARNING: Removed duplicated region for block: B:61:0x011e  */
        /* JADX WARNING: Removed duplicated region for block: B:72:0x014e  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void g(byte[] r24, int r25, int r26) {
            /*
                r23 = this;
                r0 = r23
                r1 = r25
                boolean r2 = r0.Dp
                if (r2 != 0) goto L_0x0009
                return
            L_0x0009:
                int r2 = r26 - r1
                byte[] r3 = r0.DL
                int r4 = r3.length
                int r5 = r0.DM
                int r6 = r5 + r2
                r7 = 2
                if (r4 >= r6) goto L_0x001e
                int r5 = r5 + r2
                int r5 = r5 * 2
                byte[] r3 = java.util.Arrays.copyOf(r3, r5)
                r0.DL = r3
            L_0x001e:
                byte[] r3 = r0.DL
                int r4 = r0.DM
                r5 = r24
                java.lang.System.arraycopy(r5, r1, r3, r4, r2)
                int r1 = r0.DM
                int r1 = r1 + r2
                r0.DM = r1
                com.applovin.exoplayer2.l.z r2 = r0.DK
                byte[] r3 = r0.DL
                r4 = 0
                r2.s(r3, r4, r1)
                com.applovin.exoplayer2.l.z r1 = r0.DK
                r2 = 8
                boolean r1 = r1.fD(r2)
                if (r1 != 0) goto L_0x003f
                return
            L_0x003f:
                com.applovin.exoplayer2.l.z r1 = r0.DK
                r1.ph()
                com.applovin.exoplayer2.l.z r1 = r0.DK
                int r10 = r1.bQ(r7)
                com.applovin.exoplayer2.l.z r1 = r0.DK
                r2 = 5
                r1.bR(r2)
                com.applovin.exoplayer2.l.z r1 = r0.DK
                boolean r1 = r1.pL()
                if (r1 != 0) goto L_0x0059
                return
            L_0x0059:
                com.applovin.exoplayer2.l.z r1 = r0.DK
                r1.pM()
                com.applovin.exoplayer2.l.z r1 = r0.DK
                boolean r1 = r1.pL()
                if (r1 != 0) goto L_0x0067
                return
            L_0x0067:
                com.applovin.exoplayer2.l.z r1 = r0.DK
                int r11 = r1.pM()
                boolean r1 = r0.DB
                if (r1 != 0) goto L_0x0079
                r0.Dp = r4
                com.applovin.exoplayer2.e.i.m$a$a r1 = r0.DR
                r1.cx(r11)
                return
            L_0x0079:
                com.applovin.exoplayer2.l.z r1 = r0.DK
                boolean r1 = r1.pL()
                if (r1 != 0) goto L_0x0082
                return
            L_0x0082:
                com.applovin.exoplayer2.l.z r1 = r0.DK
                int r13 = r1.pM()
                android.util.SparseArray<com.applovin.exoplayer2.l.v$a> r1 = r0.DJ
                int r1 = r1.indexOfKey(r13)
                if (r1 >= 0) goto L_0x0093
                r0.Dp = r4
                return
            L_0x0093:
                android.util.SparseArray<com.applovin.exoplayer2.l.v$a> r1 = r0.DJ
                java.lang.Object r1 = r1.get(r13)
                com.applovin.exoplayer2.l.v$a r1 = (com.applovin.exoplayer2.l.v.a) r1
                android.util.SparseArray<com.applovin.exoplayer2.l.v$b> r3 = r0.DI
                int r5 = r1.act
                java.lang.Object r3 = r3.get(r5)
                r9 = r3
                com.applovin.exoplayer2.l.v$b r9 = (com.applovin.exoplayer2.l.v.b) r9
                boolean r3 = r9.acz
                if (r3 == 0) goto L_0x00b8
                com.applovin.exoplayer2.l.z r3 = r0.DK
                boolean r3 = r3.fD(r7)
                if (r3 != 0) goto L_0x00b3
                return
            L_0x00b3:
                com.applovin.exoplayer2.l.z r3 = r0.DK
                r3.bR(r7)
            L_0x00b8:
                com.applovin.exoplayer2.l.z r3 = r0.DK
                int r5 = r9.acB
                boolean r3 = r3.fD(r5)
                if (r3 != 0) goto L_0x00c3
                return
            L_0x00c3:
                com.applovin.exoplayer2.l.z r3 = r0.DK
                int r5 = r9.acB
                int r12 = r3.bQ(r5)
                boolean r3 = r9.acA
                r5 = 1
                if (r3 != 0) goto L_0x00f7
                com.applovin.exoplayer2.l.z r3 = r0.DK
                boolean r3 = r3.fD(r5)
                if (r3 != 0) goto L_0x00d9
                return
            L_0x00d9:
                com.applovin.exoplayer2.l.z r3 = r0.DK
                boolean r3 = r3.ik()
                if (r3 == 0) goto L_0x00f5
                com.applovin.exoplayer2.l.z r6 = r0.DK
                boolean r6 = r6.fD(r5)
                if (r6 != 0) goto L_0x00ea
                return
            L_0x00ea:
                com.applovin.exoplayer2.l.z r6 = r0.DK
                boolean r6 = r6.ik()
                r14 = r3
                r16 = r6
                r15 = 1
                goto L_0x00fb
            L_0x00f5:
                r14 = r3
                goto L_0x00f8
            L_0x00f7:
                r14 = 0
            L_0x00f8:
                r15 = 0
                r16 = 0
            L_0x00fb:
                int r3 = r0.DN
                if (r3 != r2) goto L_0x0102
                r17 = 1
                goto L_0x0104
            L_0x0102:
                r17 = 0
            L_0x0104:
                if (r17 == 0) goto L_0x0118
                com.applovin.exoplayer2.l.z r2 = r0.DK
                boolean r2 = r2.pL()
                if (r2 != 0) goto L_0x010f
                return
            L_0x010f:
                com.applovin.exoplayer2.l.z r2 = r0.DK
                int r2 = r2.pM()
                r18 = r2
                goto L_0x011a
            L_0x0118:
                r18 = 0
            L_0x011a:
                int r2 = r9.acC
                if (r2 != 0) goto L_0x014e
                com.applovin.exoplayer2.l.z r2 = r0.DK
                int r3 = r9.acD
                boolean r2 = r2.fD(r3)
                if (r2 != 0) goto L_0x0129
                return
            L_0x0129:
                com.applovin.exoplayer2.l.z r2 = r0.DK
                int r3 = r9.acD
                int r2 = r2.bQ(r3)
                boolean r1 = r1.acu
                if (r1 == 0) goto L_0x014b
                if (r14 != 0) goto L_0x014b
                com.applovin.exoplayer2.l.z r1 = r0.DK
                boolean r1 = r1.pL()
                if (r1 != 0) goto L_0x0140
                return
            L_0x0140:
                com.applovin.exoplayer2.l.z r1 = r0.DK
                int r1 = r1.pN()
                r20 = r1
                r19 = r2
                goto L_0x018e
            L_0x014b:
                r19 = r2
                goto L_0x018c
            L_0x014e:
                int r2 = r9.acC
                if (r2 != r5) goto L_0x018a
                boolean r2 = r9.acE
                if (r2 != 0) goto L_0x018a
                com.applovin.exoplayer2.l.z r2 = r0.DK
                boolean r2 = r2.pL()
                if (r2 != 0) goto L_0x015f
                return
            L_0x015f:
                com.applovin.exoplayer2.l.z r2 = r0.DK
                int r2 = r2.pN()
                boolean r1 = r1.acu
                if (r1 == 0) goto L_0x0183
                if (r14 != 0) goto L_0x0183
                com.applovin.exoplayer2.l.z r1 = r0.DK
                boolean r1 = r1.pL()
                if (r1 != 0) goto L_0x0174
                return
            L_0x0174:
                com.applovin.exoplayer2.l.z r1 = r0.DK
                int r1 = r1.pN()
                r22 = r1
                r21 = r2
                r19 = 0
                r20 = 0
                goto L_0x0192
            L_0x0183:
                r21 = r2
                r19 = 0
                r20 = 0
                goto L_0x0190
            L_0x018a:
                r19 = 0
            L_0x018c:
                r20 = 0
            L_0x018e:
                r21 = 0
            L_0x0190:
                r22 = 0
            L_0x0192:
                com.applovin.exoplayer2.e.i.m$a$a r8 = r0.DR
                r8.a(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
                r0.Dp = r4
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.e.i.m.a.g(byte[], int, int):void");
        }

        public boolean a(long j, int i, boolean z, boolean z2) {
            boolean z3 = false;
            if (this.DN == 9 || (this.DB && this.DR.a(this.DQ))) {
                if (z && this.Dv) {
                    cw(i + ((int) (j - this.DO)));
                }
                this.Dl = this.DO;
                this.Da = this.DP;
                this.Dm = false;
                this.Dv = true;
            }
            if (this.DA) {
                z2 = this.DR.jp();
            }
            boolean z4 = this.Dm;
            int i2 = this.DN;
            if (i2 == 5 || (z2 && i2 == 1)) {
                z3 = true;
            }
            boolean z5 = z4 | z3;
            this.Dm = z5;
            return z5;
        }

        private void cw(int i) {
            long j = this.Da;
            if (j != -9223372036854775807L) {
                boolean z = this.Dm;
                this.wl.a(j, z ? 1 : 0, (int) (this.DO - this.Dl), i, (x.a) null);
            }
        }

        /* renamed from: com.applovin.exoplayer2.e.i.m$a$a  reason: collision with other inner class name */
        private static final class C0044a {
            private boolean DS;
            private boolean DT;
            private v.b DU;
            private int DV;
            private int DW;
            private int DX;
            private int DY;
            private boolean DZ;
            private boolean Ea;
            private boolean Eb;
            private boolean Ec;
            private int Ed;
            private int Ee;
            private int Ef;
            private int Eg;
            private int Eh;

            public void a(v.b bVar, int i, int i2, int i3, int i4, boolean z, boolean z2, boolean z3, boolean z4, int i5, int i6, int i7, int i8, int i9) {
                this.DU = bVar;
                this.DV = i;
                this.DW = i2;
                this.DX = i3;
                this.DY = i4;
                this.DZ = z;
                this.Ea = z2;
                this.Eb = z3;
                this.Ec = z4;
                this.Ed = i5;
                this.Ee = i6;
                this.Ef = i7;
                this.Eg = i8;
                this.Eh = i9;
                this.DS = true;
                this.DT = true;
            }

            public void clear() {
                this.DT = false;
                this.DS = false;
            }

            public void cx(int i) {
                this.DW = i;
                this.DT = true;
            }

            /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
                r0 = r2.DW;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public boolean jp() {
                /*
                    r2 = this;
                    boolean r0 = r2.DT
                    if (r0 == 0) goto L_0x000e
                    int r0 = r2.DW
                    r1 = 7
                    if (r0 == r1) goto L_0x000c
                    r1 = 2
                    if (r0 != r1) goto L_0x000e
                L_0x000c:
                    r0 = 1
                    goto L_0x000f
                L_0x000e:
                    r0 = 0
                L_0x000f:
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.e.i.m.a.C0044a.jp():boolean");
            }

            private C0044a() {
            }

            /* access modifiers changed from: private */
            public boolean a(C0044a aVar) {
                int i;
                int i2;
                boolean z;
                if (!this.DS) {
                    return false;
                }
                if (!aVar.DS) {
                    return true;
                }
                v.b bVar = (v.b) com.applovin.exoplayer2.l.a.N(this.DU);
                v.b bVar2 = (v.b) com.applovin.exoplayer2.l.a.N(aVar.DU);
                if (this.DX == aVar.DX && this.DY == aVar.DY && this.DZ == aVar.DZ && ((!this.Ea || !aVar.Ea || this.Eb == aVar.Eb) && (((i = this.DV) == (i2 = aVar.DV) || (i != 0 && i2 != 0)) && ((bVar.acC != 0 || bVar2.acC != 0 || (this.Ee == aVar.Ee && this.Ef == aVar.Ef)) && ((bVar.acC != 1 || bVar2.acC != 1 || (this.Eg == aVar.Eg && this.Eh == aVar.Eh)) && (z = this.Ec) == aVar.Ec && (!z || this.Ed == aVar.Ed)))))) {
                    return false;
                }
                return true;
            }
        }
    }
}
