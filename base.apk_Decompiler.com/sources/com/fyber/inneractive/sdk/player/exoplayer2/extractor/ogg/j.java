package com.fyber.inneractive.sdk.player.exoplayer2.extractor.ogg;

import com.fyber.inneractive.sdk.player.exoplayer2.extractor.ogg.k;

public final class j extends h {
    public a n;
    public int o;
    public boolean p;
    public k.c q;
    public k.a r;

    public static final class a {
        public final k.c a;
        public final byte[] b;
        public final k.b[] c;
        public final int d;

        public a(k.c cVar, k.a aVar, byte[] bArr, k.b[] bVarArr, int i) {
            this.a = cVar;
            this.b = bArr;
            this.c = bVarArr;
            this.d = i;
        }
    }

    public void a(boolean z) {
        super.a(z);
        if (z) {
            this.n = null;
            this.q = null;
            this.r = null;
        }
        this.o = 0;
        this.p = false;
    }

    public void b(long j) {
        this.g = j;
        int i = 0;
        this.p = j != 0;
        k.c cVar = this.q;
        if (cVar != null) {
            i = cVar.d;
        }
        this.o = i;
    }

    public long a(com.fyber.inneractive.sdk.player.exoplayer2.util.k kVar) {
        int i;
        int i2 = 0;
        byte b = kVar.a[0];
        if ((b & 1) == 1) {
            return -1;
        }
        a aVar = this.n;
        if (!aVar.c[(b >> 1) & (255 >>> (8 - aVar.d))].a) {
            i = aVar.a.d;
        } else {
            i = aVar.a.e;
        }
        if (this.p) {
            i2 = (this.o + i) / 4;
        }
        long j = (long) i2;
        kVar.d(kVar.c + 4);
        byte[] bArr = kVar.a;
        int i3 = kVar.c;
        bArr[i3 - 4] = (byte) ((int) (j & 255));
        bArr[i3 - 3] = (byte) ((int) ((j >>> 8) & 255));
        bArr[i3 - 2] = (byte) ((int) ((j >>> 16) & 255));
        bArr[i3 - 1] = (byte) ((int) ((j >>> 24) & 255));
        this.p = true;
        this.o = i;
        return j;
    }

    /* JADX WARNING: Removed duplicated region for block: B:161:0x040f A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x0411  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(com.fyber.inneractive.sdk.player.exoplayer2.util.k r22, long r23, com.fyber.inneractive.sdk.player.exoplayer2.extractor.ogg.h.a r25) throws java.io.IOException, java.lang.InterruptedException {
        /*
            r21 = this;
            r0 = r21
            r1 = r22
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.ogg.j$a r2 = r0.n
            r3 = 0
            if (r2 == 0) goto L_0x000a
            return r3
        L_0x000a:
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.ogg.k$c r2 = r0.q
            r5 = 4
            r6 = 1
            if (r2 != 0) goto L_0x0066
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.ogg.k.a(r6, r1, r3)
            long r8 = r22.f()
            int r10 = r22.l()
            long r11 = r22.f()
            int r13 = r22.e()
            int r14 = r22.e()
            int r15 = r22.e()
            int r2 = r22.l()
            r7 = r2 & 15
            double r3 = (double) r7
            r6 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r3 = java.lang.Math.pow(r6, r3)
            int r3 = (int) r3
            r2 = r2 & 240(0xf0, float:3.36E-43)
            int r2 = r2 >> r5
            double r4 = (double) r2
            double r4 = java.lang.Math.pow(r6, r4)
            int r2 = (int) r4
            int r4 = r22.l()
            r5 = 1
            r4 = r4 & r5
            if (r4 <= 0) goto L_0x004d
            r18 = 1
            goto L_0x004f
        L_0x004d:
            r18 = 0
        L_0x004f:
            byte[] r4 = r1.a
            int r1 = r1.c
            byte[] r19 = java.util.Arrays.copyOf(r4, r1)
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.ogg.k$c r1 = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.ogg.k$c
            r7 = r1
            r16 = r3
            r17 = r2
            r7.<init>(r8, r10, r11, r13, r14, r15, r16, r17, r18, r19)
            r0.q = r1
        L_0x0063:
            r4 = 0
            goto L_0x040b
        L_0x0066:
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.ogg.k$a r2 = r0.r
            r3 = 3
            if (r2 != 0) goto L_0x00ba
            r2 = 0
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.ogg.k.a(r3, r1, r2)
            long r2 = r22.f()
            int r3 = (int) r2
            java.lang.String r2 = r1.b(r3)
            int r3 = r2.length()
            long r4 = r22.f()
            int r6 = (int) r4
            java.lang.String[] r6 = new java.lang.String[r6]
            int r3 = r3 + 15
            r7 = r3
            r3 = 0
        L_0x0087:
            long r8 = (long) r3
            int r10 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r10 >= 0) goto L_0x00a1
            long r8 = r22.f()
            int r9 = (int) r8
            int r7 = r7 + 4
            java.lang.String r8 = r1.b(r9)
            r6[r3] = r8
            int r8 = r8.length()
            int r7 = r7 + r8
            int r3 = r3 + 1
            goto L_0x0087
        L_0x00a1:
            int r1 = r22.l()
            r3 = 1
            r1 = r1 & r3
            if (r1 == 0) goto L_0x00b2
            int r7 = r7 + r3
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.ogg.k$a r1 = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.ogg.k$a
            r1.<init>(r2, r6, r7)
            r0.r = r1
            goto L_0x0063
        L_0x00b2:
            com.fyber.inneractive.sdk.player.exoplayer2.l r1 = new com.fyber.inneractive.sdk.player.exoplayer2.l
            java.lang.String r2 = "framing bit expected to be set"
            r1.<init>((java.lang.String) r2)
            throw r1
        L_0x00ba:
            int r2 = r1.c
            byte[] r9 = new byte[r2]
            byte[] r4 = r1.a
            r6 = 0
            java.lang.System.arraycopy(r4, r6, r9, r6, r2)
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.ogg.k$c r2 = r0.q
            int r2 = r2.a
            r4 = 5
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.ogg.k.a(r4, r1, r6)
            int r7 = r22.l()
            r8 = 1
            int r7 = r7 + r8
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.ogg.i r8 = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.ogg.i
            byte[] r10 = r1.a
            r8.<init>(r10)
            int r1 = r1.b
            r10 = 8
            int r1 = r1 * 8
            r8.b(r1)
            r1 = 0
        L_0x00e3:
            r11 = 24
            r13 = 16
            if (r1 >= r7) goto L_0x01f4
            int r14 = r8.a(r11)
            r15 = 5653314(0x564342, float:7.92198E-39)
            if (r14 != r15) goto L_0x01d7
            int r13 = r8.a(r13)
            int r11 = r8.a(r11)
            long[] r14 = new long[r11]
            boolean r15 = r8.a()
            r16 = 0
            if (r15 != 0) goto L_0x013d
            boolean r15 = r8.a()
        L_0x0108:
            if (r6 >= r11) goto L_0x013a
            if (r15 == 0) goto L_0x0127
            boolean r18 = r8.a()
            if (r18 == 0) goto L_0x0120
            int r18 = r8.a(r4)
            r19 = 1
            int r3 = r18 + 1
            r18 = r13
            long r12 = (long) r3
            r14[r6] = r12
            goto L_0x0134
        L_0x0120:
            r18 = r13
            r19 = 1
            r14[r6] = r16
            goto L_0x0134
        L_0x0127:
            r18 = r13
            r19 = 1
            int r3 = r8.a(r4)
            int r3 = r3 + 1
            long r12 = (long) r3
            r14[r6] = r12
        L_0x0134:
            int r6 = r6 + 1
            r13 = r18
            r3 = 3
            goto L_0x0108
        L_0x013a:
            r18 = r13
            goto L_0x0173
        L_0x013d:
            r18 = r13
            r19 = 1
            int r3 = r8.a(r4)
            int r3 = r3 + 1
            r6 = r3
            r3 = 0
        L_0x0149:
            if (r3 >= r11) goto L_0x0173
            int r12 = r11 - r3
            int r12 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.ogg.k.a(r12)
            int r12 = r8.a(r12)
            r13 = r3
            r3 = 0
        L_0x0157:
            if (r3 >= r12) goto L_0x0169
            if (r13 >= r11) goto L_0x0169
            r19 = r11
            long r10 = (long) r6
            r14[r13] = r10
            int r13 = r13 + 1
            int r3 = r3 + 1
            r11 = r19
            r10 = 8
            goto L_0x0157
        L_0x0169:
            r19 = r11
            int r6 = r6 + 1
            r3 = r13
            r11 = r19
            r10 = 8
            goto L_0x0149
        L_0x0173:
            r19 = r11
            int r3 = r8.a(r5)
            r6 = 2
            if (r3 > r6) goto L_0x01c3
            r10 = 1
            if (r3 == r10) goto L_0x0181
            if (r3 != r6) goto L_0x01bb
        L_0x0181:
            r6 = 32
            r8.b(r6)
            r8.b(r6)
            int r6 = r8.a(r5)
            int r6 = r6 + r10
            r8.b(r10)
            if (r3 != r10) goto L_0x01ab
            if (r18 == 0) goto L_0x01b4
            r3 = r19
            long r10 = (long) r3
            r12 = r18
            long r12 = (long) r12
            double r10 = (double) r10
            double r12 = (double) r12
            r16 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r12 = r16 / r12
            double r10 = java.lang.Math.pow(r10, r12)
            double r10 = java.lang.Math.floor(r10)
            long r10 = (long) r10
            goto L_0x01b2
        L_0x01ab:
            r12 = r18
            r3 = r19
            int r11 = r3 * r12
            long r10 = (long) r11
        L_0x01b2:
            r16 = r10
        L_0x01b4:
            long r10 = (long) r6
            long r10 = r10 * r16
            int r3 = (int) r10
            r8.b(r3)
        L_0x01bb:
            int r1 = r1 + 1
            r3 = 3
            r6 = 0
            r10 = 8
            goto L_0x00e3
        L_0x01c3:
            com.fyber.inneractive.sdk.player.exoplayer2.l r1 = new com.fyber.inneractive.sdk.player.exoplayer2.l
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r4 = "lookup type greater than 2 not decodable: "
            r2.<init>(r4)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>((java.lang.String) r2)
            throw r1
        L_0x01d7:
            com.fyber.inneractive.sdk.player.exoplayer2.l r1 = new com.fyber.inneractive.sdk.player.exoplayer2.l
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "expected code book to start with [0x56, 0x43, 0x42] at "
            r2.<init>(r3)
            int r3 = r8.c
            r4 = 8
            int r3 = r3 * 8
            int r4 = r8.d
            int r3 = r3 + r4
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>((java.lang.String) r2)
            throw r1
        L_0x01f4:
            r1 = 6
            int r3 = r8.a(r1)
            r6 = 1
            int r3 = r3 + r6
            r6 = 0
        L_0x01fc:
            if (r6 >= r3) goto L_0x020f
            int r7 = r8.a(r13)
            if (r7 != 0) goto L_0x0207
            int r6 = r6 + 1
            goto L_0x01fc
        L_0x0207:
            com.fyber.inneractive.sdk.player.exoplayer2.l r1 = new com.fyber.inneractive.sdk.player.exoplayer2.l
            java.lang.String r2 = "placeholder of time domain transforms not zeroed out"
            r1.<init>((java.lang.String) r2)
            throw r1
        L_0x020f:
            int r3 = r8.a(r1)
            r6 = 1
            int r3 = r3 + r6
            r7 = 0
        L_0x0216:
            if (r7 >= r3) goto L_0x02cf
            int r10 = r8.a(r13)
            if (r10 == 0) goto L_0x029f
            if (r10 != r6) goto L_0x028b
            int r6 = r8.a(r4)
            int[] r10 = new int[r6]
            r12 = -1
            r12 = 0
            r14 = -1
        L_0x0229:
            if (r12 >= r6) goto L_0x0237
            int r15 = r8.a(r5)
            r10[r12] = r15
            if (r15 <= r14) goto L_0x0234
            r14 = r15
        L_0x0234:
            int r12 = r12 + 1
            goto L_0x0229
        L_0x0237:
            int r14 = r14 + 1
            int[] r12 = new int[r14]
            r15 = 0
        L_0x023c:
            if (r15 >= r14) goto L_0x026e
            r4 = 3
            int r18 = r8.a(r4)
            r4 = 1
            int r18 = r18 + 1
            r12[r15] = r18
            r11 = 2
            int r19 = r8.a(r11)
            r11 = 8
            if (r19 <= 0) goto L_0x0254
            r8.b(r11)
        L_0x0254:
            r1 = 0
        L_0x0255:
            int r13 = r4 << r19
            if (r1 >= r13) goto L_0x0263
            r8.b(r11)
            r4 = r15
            int r1 = r1 + 1
            r4 = 1
            r11 = 8
            goto L_0x0255
        L_0x0263:
            r4 = r15
            int r1 = r4 + 1
            r15 = r1
            r1 = 6
            r4 = 5
            r11 = 24
            r13 = 16
            goto L_0x023c
        L_0x026e:
            r1 = 2
            r8.b(r1)
            int r1 = r8.a(r5)
            r4 = 0
            r11 = 0
            r13 = 0
        L_0x0279:
            if (r4 >= r6) goto L_0x02c4
            r14 = r10[r4]
            r14 = r12[r14]
            int r11 = r11 + r14
        L_0x0280:
            if (r13 >= r11) goto L_0x0288
            r8.b(r1)
            int r13 = r13 + 1
            goto L_0x0280
        L_0x0288:
            int r4 = r4 + 1
            goto L_0x0279
        L_0x028b:
            com.fyber.inneractive.sdk.player.exoplayer2.l r1 = new com.fyber.inneractive.sdk.player.exoplayer2.l
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "floor type greater than 1 not decodable: "
            r2.<init>(r3)
            r2.append(r10)
            java.lang.String r2 = r2.toString()
            r1.<init>((java.lang.String) r2)
            throw r1
        L_0x029f:
            r1 = 8
            r8.b(r1)
            r4 = 16
            r8.b(r4)
            r8.b(r4)
            r4 = 6
            r8.b(r4)
            r8.b(r1)
            int r4 = r8.a(r5)
            r6 = 1
            int r4 = r4 + r6
            r6 = 0
        L_0x02ba:
            if (r6 >= r4) goto L_0x02c4
            r8.b(r1)
            int r6 = r6 + 1
            r1 = 8
            goto L_0x02ba
        L_0x02c4:
            int r7 = r7 + 1
            r1 = 6
            r4 = 5
            r6 = 1
            r11 = 24
            r13 = 16
            goto L_0x0216
        L_0x02cf:
            int r3 = r8.a(r1)
            r4 = 1
            int r3 = r3 + r4
            r6 = 0
        L_0x02d6:
            if (r6 >= r3) goto L_0x0342
            r7 = 16
            int r10 = r8.a(r7)
            r7 = 2
            if (r10 > r7) goto L_0x033a
            r7 = 24
            r8.b(r7)
            r8.b(r7)
            r8.b(r7)
            int r10 = r8.a(r1)
            int r10 = r10 + r4
            r1 = 8
            r8.b(r1)
            int[] r4 = new int[r10]
            r11 = 0
        L_0x02f9:
            if (r11 >= r10) goto L_0x0316
            r12 = 3
            int r13 = r8.a(r12)
            boolean r14 = r8.a()
            if (r14 == 0) goto L_0x030c
            r14 = 5
            int r15 = r8.a(r14)
            goto L_0x030e
        L_0x030c:
            r14 = 5
            r15 = 0
        L_0x030e:
            int r15 = r15 * 8
            int r15 = r15 + r13
            r4[r11] = r15
            int r11 = r11 + 1
            goto L_0x02f9
        L_0x0316:
            r12 = 3
            r14 = 5
            r11 = 0
        L_0x0319:
            if (r11 >= r10) goto L_0x0335
            r13 = 0
        L_0x031c:
            if (r13 >= r1) goto L_0x0330
            r15 = r4[r11]
            r17 = 1
            int r18 = r17 << r13
            r15 = r15 & r18
            if (r15 == 0) goto L_0x032b
            r8.b(r1)
        L_0x032b:
            int r13 = r13 + 1
            r1 = 8
            goto L_0x031c
        L_0x0330:
            int r11 = r11 + 1
            r1 = 8
            goto L_0x0319
        L_0x0335:
            int r6 = r6 + 1
            r1 = 6
            r4 = 1
            goto L_0x02d6
        L_0x033a:
            com.fyber.inneractive.sdk.player.exoplayer2.l r1 = new com.fyber.inneractive.sdk.player.exoplayer2.l
            java.lang.String r2 = "residueType greater than 2 is not decodable"
            r1.<init>((java.lang.String) r2)
            throw r1
        L_0x0342:
            int r3 = r8.a(r1)
            r1 = 1
            int r3 = r3 + r1
            r1 = 0
        L_0x0349:
            if (r1 >= r3) goto L_0x03cd
            r4 = 16
            int r6 = r8.a(r4)
            if (r6 == 0) goto L_0x0368
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r7 = "mapping type other than 0 not supported: "
            r4.<init>(r7)
            r4.append(r6)
            java.lang.String r4 = r4.toString()
            java.lang.String r6 = "VorbisUtil"
            android.util.Log.e(r6, r4)
            r6 = 2
            goto L_0x03c2
        L_0x0368:
            boolean r4 = r8.a()
            if (r4 == 0) goto L_0x0377
            int r4 = r8.a(r5)
            r20 = 1
            int r4 = r4 + 1
            goto L_0x037a
        L_0x0377:
            r20 = 1
            r4 = 1
        L_0x037a:
            boolean r6 = r8.a()
            if (r6 == 0) goto L_0x039e
            r6 = 8
            int r7 = r8.a(r6)
            int r7 = r7 + 1
            r6 = 0
        L_0x0389:
            if (r6 >= r7) goto L_0x039e
            int r10 = r2 + -1
            int r11 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.ogg.k.a(r10)
            r8.b(r11)
            int r10 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.ogg.k.a(r10)
            r8.b(r10)
            int r6 = r6 + 1
            goto L_0x0389
        L_0x039e:
            r6 = 2
            int r7 = r8.a(r6)
            if (r7 != 0) goto L_0x03c5
            r7 = 1
            if (r4 <= r7) goto L_0x03b1
            r7 = 0
        L_0x03a9:
            if (r7 >= r2) goto L_0x03b1
            r8.b(r5)
            int r7 = r7 + 1
            goto L_0x03a9
        L_0x03b1:
            r7 = 0
        L_0x03b2:
            if (r7 >= r4) goto L_0x03c2
            r10 = 8
            r8.b(r10)
            r8.b(r10)
            r8.b(r10)
            int r7 = r7 + 1
            goto L_0x03b2
        L_0x03c2:
            int r1 = r1 + 1
            goto L_0x0349
        L_0x03c5:
            com.fyber.inneractive.sdk.player.exoplayer2.l r1 = new com.fyber.inneractive.sdk.player.exoplayer2.l
            java.lang.String r2 = "to reserved bits must be zero after mapping coupling steps"
            r1.<init>((java.lang.String) r2)
            throw r1
        L_0x03cd:
            r1 = 6
            int r1 = r8.a(r1)
            int r2 = r1 + 1
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.ogg.k$b[] r10 = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.ogg.k.b[r2]
            r3 = 0
        L_0x03d7:
            if (r3 >= r2) goto L_0x03f7
            boolean r4 = r8.a()
            r5 = 16
            int r6 = r8.a(r5)
            int r7 = r8.a(r5)
            r11 = 8
            int r12 = r8.a(r11)
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.ogg.k$b r13 = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.ogg.k$b
            r13.<init>(r4, r6, r7, r12)
            r10[r3] = r13
            int r3 = r3 + 1
            goto L_0x03d7
        L_0x03f7:
            boolean r2 = r8.a()
            if (r2 == 0) goto L_0x0444
            int r11 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.ogg.k.a(r1)
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.ogg.j$a r4 = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.ogg.j$a
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.ogg.k$c r7 = r0.q
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.ogg.k$a r8 = r0.r
            r6 = r4
            r6.<init>(r7, r8, r9, r10, r11)
        L_0x040b:
            r0.n = r4
            if (r4 != 0) goto L_0x0411
            r1 = 1
            return r1
        L_0x0411:
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.ogg.j$a r1 = r0.n
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.ogg.k$c r1 = r1.a
            byte[] r1 = r1.f
            r10.add(r1)
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.ogg.j$a r1 = r0.n
            byte[] r1 = r1.b
            r10.add(r1)
            r2 = 0
            java.lang.String r3 = "audio/vorbis"
            r4 = 0
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.ogg.j$a r1 = r0.n
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.ogg.k$c r1 = r1.a
            int r5 = r1.c
            r6 = -1
            int r7 = r1.a
            long r8 = r1.b
            int r8 = (int) r8
            r11 = 0
            r12 = 0
            r13 = 0
            r9 = -1
            com.fyber.inneractive.sdk.player.exoplayer2.i r1 = com.fyber.inneractive.sdk.player.exoplayer2.i.a((java.lang.String) r2, (java.lang.String) r3, (java.lang.String) r4, (int) r5, (int) r6, (int) r7, (int) r8, (int) r9, (java.util.List<byte[]>) r10, (com.fyber.inneractive.sdk.player.exoplayer2.drm.a) r11, (int) r12, (java.lang.String) r13)
            r2 = r25
            r2.a = r1
            r1 = 1
            return r1
        L_0x0444:
            com.fyber.inneractive.sdk.player.exoplayer2.l r1 = new com.fyber.inneractive.sdk.player.exoplayer2.l
            java.lang.String r2 = "framing bit after modes not set as expected"
            r1.<init>((java.lang.String) r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.exoplayer2.extractor.ogg.j.a(com.fyber.inneractive.sdk.player.exoplayer2.util.k, long, com.fyber.inneractive.sdk.player.exoplayer2.extractor.ogg.h$a):boolean");
    }
}
