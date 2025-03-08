package com.applovin.exoplayer2.e.i;

import com.applovin.exoplayer2.e.i.ad;
import com.applovin.exoplayer2.e.j;
import com.applovin.exoplayer2.e.x;
import com.applovin.exoplayer2.l.v;
import com.applovin.exoplayer2.l.y;
import java.util.Arrays;

public final class k implements j {
    private static final double[] Db = {23.976023976023978d, 24.0d, 25.0d, 29.97002997002997d, 30.0d, 50.0d, 59.94005994005994d, 60.0d};
    private String Ct;
    private long Da;
    private final af Dc;
    private final y Dd;
    private final r De;
    private final boolean[] Df;
    private final a Dg;
    private long Dh;
    private boolean Di;
    private long Dj;
    private long Dk;
    private long Dl;
    private boolean Dm;
    private boolean Dn;
    private boolean vJ;
    private x wl;

    public void e(long j, int i) {
        this.Dk = j;
    }

    public void jc() {
    }

    public k() {
        this((af) null);
    }

    k(af afVar) {
        this.Dc = afVar;
        this.Df = new boolean[4];
        this.Dg = new a(128);
        if (afVar != null) {
            this.De = new r(178, 128);
            this.Dd = new y();
        } else {
            this.De = null;
            this.Dd = null;
        }
        this.Dk = -9223372036854775807L;
        this.Da = -9223372036854775807L;
    }

    public void jb() {
        v.b(this.Df);
        this.Dg.Y();
        r rVar = this.De;
        if (rVar != null) {
            rVar.Y();
        }
        this.Dh = 0;
        this.Di = false;
        this.Dk = -9223372036854775807L;
        this.Da = -9223372036854775807L;
    }

    public void a(j jVar, ad.d dVar) {
        dVar.jy();
        this.Ct = dVar.jA();
        this.wl = jVar.y(dVar.jz(), 2);
        af afVar = this.Dc;
        if (afVar != null) {
            afVar.a(jVar, dVar);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:50:0x011f  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0121  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0144  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void K(com.applovin.exoplayer2.l.y r21) {
        /*
            r20 = this;
            r0 = r20
            com.applovin.exoplayer2.e.x r1 = r0.wl
            com.applovin.exoplayer2.l.a.N(r1)
            int r1 = r21.il()
            int r2 = r21.pk()
            byte[] r3 = r21.hO()
            long r4 = r0.Dh
            int r6 = r21.pj()
            long r6 = (long) r6
            long r4 = r4 + r6
            r0.Dh = r4
            com.applovin.exoplayer2.e.x r4 = r0.wl
            int r5 = r21.pj()
            r6 = r21
            r4.c(r6, r5)
        L_0x0028:
            boolean[] r4 = r0.Df
            int r4 = com.applovin.exoplayer2.l.v.a(r3, r1, r2, r4)
            if (r4 != r2) goto L_0x0041
            boolean r4 = r0.vJ
            if (r4 != 0) goto L_0x0039
            com.applovin.exoplayer2.e.i.k$a r4 = r0.Dg
            r4.e(r3, r1, r2)
        L_0x0039:
            com.applovin.exoplayer2.e.i.r r4 = r0.De
            if (r4 == 0) goto L_0x0040
            r4.g(r3, r1, r2)
        L_0x0040:
            return
        L_0x0041:
            byte[] r5 = r21.hO()
            int r7 = r4 + 3
            byte r5 = r5[r7]
            r5 = r5 & 255(0xff, float:3.57E-43)
            int r8 = r4 - r1
            boolean r9 = r0.vJ
            r10 = 0
            r11 = 1
            if (r9 != 0) goto L_0x008a
            if (r8 <= 0) goto L_0x005a
            com.applovin.exoplayer2.e.i.k$a r9 = r0.Dg
            r9.e(r3, r1, r4)
        L_0x005a:
            if (r8 >= 0) goto L_0x005e
            int r9 = -r8
            goto L_0x005f
        L_0x005e:
            r9 = 0
        L_0x005f:
            com.applovin.exoplayer2.e.i.k$a r12 = r0.Dg
            boolean r9 = r12.B(r5, r9)
            if (r9 == 0) goto L_0x008a
            com.applovin.exoplayer2.e.i.k$a r9 = r0.Dg
            java.lang.String r12 = r0.Ct
            java.lang.Object r12 = com.applovin.exoplayer2.l.a.checkNotNull(r12)
            java.lang.String r12 = (java.lang.String) r12
            android.util.Pair r9 = a((com.applovin.exoplayer2.e.i.k.a) r9, (java.lang.String) r12)
            com.applovin.exoplayer2.e.x r12 = r0.wl
            java.lang.Object r13 = r9.first
            com.applovin.exoplayer2.v r13 = (com.applovin.exoplayer2.v) r13
            r12.j(r13)
            java.lang.Object r9 = r9.second
            java.lang.Long r9 = (java.lang.Long) r9
            long r12 = r9.longValue()
            r0.Dj = r12
            r0.vJ = r11
        L_0x008a:
            com.applovin.exoplayer2.e.i.r r9 = r0.De
            if (r9 == 0) goto L_0x00db
            if (r8 <= 0) goto L_0x0095
            r9.g(r3, r1, r4)
            r1 = 0
            goto L_0x0096
        L_0x0095:
            int r1 = -r8
        L_0x0096:
            com.applovin.exoplayer2.e.i.r r8 = r0.De
            boolean r1 = r8.cC(r1)
            if (r1 == 0) goto L_0x00c8
            com.applovin.exoplayer2.e.i.r r1 = r0.De
            byte[] r1 = r1.EJ
            com.applovin.exoplayer2.e.i.r r8 = r0.De
            int r8 = r8.EK
            int r1 = com.applovin.exoplayer2.l.v.i(r1, r8)
            com.applovin.exoplayer2.l.y r8 = r0.Dd
            java.lang.Object r8 = com.applovin.exoplayer2.l.ai.R(r8)
            com.applovin.exoplayer2.l.y r8 = (com.applovin.exoplayer2.l.y) r8
            com.applovin.exoplayer2.e.i.r r9 = r0.De
            byte[] r9 = r9.EJ
            r8.l(r9, r1)
            com.applovin.exoplayer2.e.i.af r1 = r0.Dc
            java.lang.Object r1 = com.applovin.exoplayer2.l.ai.R(r1)
            com.applovin.exoplayer2.e.i.af r1 = (com.applovin.exoplayer2.e.i.af) r1
            long r8 = r0.Da
            com.applovin.exoplayer2.l.y r12 = r0.Dd
            r1.a((long) r8, (com.applovin.exoplayer2.l.y) r12)
        L_0x00c8:
            r1 = 178(0xb2, float:2.5E-43)
            if (r5 != r1) goto L_0x00db
            byte[] r1 = r21.hO()
            int r8 = r4 + 2
            byte r1 = r1[r8]
            if (r1 != r11) goto L_0x00db
            com.applovin.exoplayer2.e.i.r r1 = r0.De
            r1.cB(r5)
        L_0x00db:
            if (r5 == 0) goto L_0x00e9
            r1 = 179(0xb3, float:2.51E-43)
            if (r5 != r1) goto L_0x00e2
            goto L_0x00e9
        L_0x00e2:
            r1 = 184(0xb8, float:2.58E-43)
            if (r5 != r1) goto L_0x0147
            r0.Dm = r11
            goto L_0x0147
        L_0x00e9:
            int r1 = r2 - r4
            boolean r4 = r0.Dn
            r8 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r4 == 0) goto L_0x0114
            boolean r4 = r0.vJ
            if (r4 == 0) goto L_0x0114
            long r13 = r0.Da
            int r4 = (r13 > r8 ? 1 : (r13 == r8 ? 0 : -1))
            if (r4 == 0) goto L_0x0114
            boolean r15 = r0.Dm
            long r11 = r0.Dh
            r19 = r5
            long r4 = r0.Dl
            long r11 = r11 - r4
            int r4 = (int) r11
            int r16 = r4 - r1
            com.applovin.exoplayer2.e.x r12 = r0.wl
            r18 = 0
            r17 = r1
            r12.a(r13, r15, r16, r17, r18)
            goto L_0x0116
        L_0x0114:
            r19 = r5
        L_0x0116:
            boolean r4 = r0.Di
            if (r4 == 0) goto L_0x0121
            boolean r4 = r0.Dn
            if (r4 == 0) goto L_0x011f
            goto L_0x0121
        L_0x011f:
            r1 = 1
            goto L_0x0142
        L_0x0121:
            long r4 = r0.Dh
            long r11 = (long) r1
            long r4 = r4 - r11
            r0.Dl = r4
            long r4 = r0.Dk
            int r1 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r1 == 0) goto L_0x012e
            goto L_0x0139
        L_0x012e:
            long r4 = r0.Da
            int r1 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r1 == 0) goto L_0x0138
            long r11 = r0.Dj
            long r4 = r4 + r11
            goto L_0x0139
        L_0x0138:
            r4 = r8
        L_0x0139:
            r0.Da = r4
            r0.Dm = r10
            r0.Dk = r8
            r1 = 1
            r0.Di = r1
        L_0x0142:
            if (r19 != 0) goto L_0x0145
            r10 = 1
        L_0x0145:
            r0.Dn = r10
        L_0x0147:
            r1 = r7
            goto L_0x0028
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.e.i.k.K(com.applovin.exoplayer2.l.y):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0072  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.util.Pair<com.applovin.exoplayer2.v, java.lang.Long> a(com.applovin.exoplayer2.e.i.k.a r8, java.lang.String r9) {
        /*
            byte[] r0 = r8.tf
            int r1 = r8.fR
            byte[] r0 = java.util.Arrays.copyOf(r0, r1)
            r1 = 4
            byte r2 = r0[r1]
            r2 = r2 & 255(0xff, float:3.57E-43)
            r3 = 5
            byte r4 = r0[r3]
            r5 = r4 & 255(0xff, float:3.57E-43)
            r6 = 6
            byte r6 = r0[r6]
            r6 = r6 & 255(0xff, float:3.57E-43)
            int r2 = r2 << r1
            int r5 = r5 >> r1
            r2 = r2 | r5
            r4 = r4 & 15
            int r4 = r4 << 8
            r4 = r4 | r6
            r5 = 7
            byte r6 = r0[r5]
            r6 = r6 & 240(0xf0, float:3.36E-43)
            int r6 = r6 >> r1
            r7 = 2
            if (r6 == r7) goto L_0x003c
            r7 = 3
            if (r6 == r7) goto L_0x0036
            if (r6 == r1) goto L_0x0030
            r1 = 1065353216(0x3f800000, float:1.0)
            goto L_0x0043
        L_0x0030:
            int r1 = r4 * 121
            float r1 = (float) r1
            int r6 = r2 * 100
            goto L_0x0041
        L_0x0036:
            int r1 = r4 * 16
            float r1 = (float) r1
            int r6 = r2 * 9
            goto L_0x0041
        L_0x003c:
            int r1 = r4 * 4
            float r1 = (float) r1
            int r6 = r2 * 3
        L_0x0041:
            float r6 = (float) r6
            float r1 = r1 / r6
        L_0x0043:
            com.applovin.exoplayer2.v$a r6 = new com.applovin.exoplayer2.v$a
            r6.<init>()
            com.applovin.exoplayer2.v$a r9 = r6.g((java.lang.String) r9)
            java.lang.String r6 = "video/mpeg2"
            com.applovin.exoplayer2.v$a r9 = r9.m((java.lang.String) r6)
            com.applovin.exoplayer2.v$a r9 = r9.J(r2)
            com.applovin.exoplayer2.v$a r9 = r9.K(r4)
            com.applovin.exoplayer2.v$a r9 = r9.e((float) r1)
            java.util.List r1 = java.util.Collections.singletonList(r0)
            com.applovin.exoplayer2.v$a r9 = r9.c((java.util.List<byte[]>) r1)
            com.applovin.exoplayer2.v r9 = r9.bT()
            byte r1 = r0[r5]
            r1 = r1 & 15
            int r1 = r1 + -1
            if (r1 < 0) goto L_0x0098
            double[] r2 = Db
            int r4 = r2.length
            if (r1 >= r4) goto L_0x0098
            r1 = r2[r1]
            int r8 = r8.Dq
            int r8 = r8 + 9
            byte r8 = r0[r8]
            r0 = r8 & 96
            int r0 = r0 >> r3
            r8 = r8 & 31
            if (r0 == r8) goto L_0x0090
            double r3 = (double) r0
            r5 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r3 = r3 + r5
            int r8 = r8 + 1
            double r5 = (double) r8
            double r3 = r3 / r5
            double r1 = r1 * r3
        L_0x0090:
            r3 = 4696837146684686336(0x412e848000000000, double:1000000.0)
            double r3 = r3 / r1
            long r0 = (long) r3
            goto L_0x009a
        L_0x0098:
            r0 = 0
        L_0x009a:
            java.lang.Long r8 = java.lang.Long.valueOf(r0)
            android.util.Pair r8 = android.util.Pair.create(r9, r8)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.e.i.k.a(com.applovin.exoplayer2.e.i.k$a, java.lang.String):android.util.Pair");
    }

    private static final class a {
        private static final byte[] Do = {0, 0, 1};
        private boolean Dp;
        public int Dq;
        public int fR;
        public byte[] tf;

        public void Y() {
            this.Dp = false;
            this.fR = 0;
            this.Dq = 0;
        }

        public a(int i) {
            this.tf = new byte[i];
        }

        public boolean B(int i, int i2) {
            if (this.Dp) {
                int i3 = this.fR - i2;
                this.fR = i3;
                if (this.Dq == 0 && i == 181) {
                    this.Dq = i3;
                } else {
                    this.Dp = false;
                    return true;
                }
            } else if (i == 179) {
                this.Dp = true;
            }
            byte[] bArr = Do;
            e(bArr, 0, bArr.length);
            return false;
        }

        public void e(byte[] bArr, int i, int i2) {
            if (this.Dp) {
                int i3 = i2 - i;
                byte[] bArr2 = this.tf;
                int length = bArr2.length;
                int i4 = this.fR;
                if (length < i4 + i3) {
                    this.tf = Arrays.copyOf(bArr2, (i4 + i3) * 2);
                }
                System.arraycopy(bArr, i, this.tf, this.fR, i3);
                this.fR += i3;
            }
        }
    }
}
