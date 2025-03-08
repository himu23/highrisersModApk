package com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts;

import com.fyber.inneractive.sdk.player.exoplayer2.extractor.h;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.n;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.v;
import java.util.Arrays;

public final class i implements h {
    public static final double[] n = {23.976023976023978d, 24.0d, 25.0d, 29.97002997002997d, 30.0d, 50.0d, 59.94005994005994d, 60.0d};
    public String a;
    public n b;
    public boolean c;
    public long d;
    public final boolean[] e = new boolean[4];
    public final a f = new a(128);
    public boolean g;
    public long h;
    public long i;
    public boolean j;
    public boolean k;
    public long l;
    public long m;

    public void a() {
        com.fyber.inneractive.sdk.player.exoplayer2.util.i.a(this.e);
        a aVar = this.f;
        aVar.a = false;
        aVar.b = 0;
        aVar.c = 0;
        this.j = false;
        this.g = false;
        this.h = 0;
    }

    public void a(long j2, boolean z) {
        boolean z2 = j2 != -9223372036854775807L;
        this.j = z2;
        if (z2) {
            this.i = j2;
        }
    }

    public void b() {
    }

    public static final class a {
        public boolean a;
        public int b;
        public int c;
        public byte[] d;

        public a(int i) {
            this.d = new byte[i];
        }

        public void a(byte[] bArr, int i, int i2) {
            if (this.a) {
                int i3 = i2 - i;
                byte[] bArr2 = this.d;
                int length = bArr2.length;
                int i4 = this.b + i3;
                if (length < i4) {
                    this.d = Arrays.copyOf(bArr2, i4 * 2);
                }
                System.arraycopy(bArr, i, this.d, this.b, i3);
                this.b += i3;
            }
        }
    }

    public void a(h hVar, v.d dVar) {
        dVar.a();
        this.a = dVar.b();
        this.b = hVar.a(dVar.c(), 2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x00cf  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.fyber.inneractive.sdk.player.exoplayer2.util.k r26) {
        /*
            r25 = this;
            r0 = r25
            r1 = r26
            int r2 = r1.b
            int r3 = r1.c
            byte[] r4 = r1.a
            long r5 = r0.h
            int r7 = r26.a()
            long r7 = (long) r7
            long r5 = r5 + r7
            r0.h = r5
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.n r5 = r0.b
            int r6 = r26.a()
            r5.a(r1, r6)
            r5 = r2
        L_0x001e:
            boolean[] r6 = r0.e
            int r2 = com.fyber.inneractive.sdk.player.exoplayer2.util.i.a(r4, r2, r3, r6)
            if (r2 != r3) goto L_0x0030
            boolean r1 = r0.c
            if (r1 != 0) goto L_0x002f
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.i$a r1 = r0.f
            r1.a(r4, r5, r3)
        L_0x002f:
            return
        L_0x0030:
            byte[] r6 = r1.a
            int r7 = r2 + 3
            byte r6 = r6[r7]
            r6 = r6 & 255(0xff, float:3.57E-43)
            boolean r8 = r0.c
            r9 = 0
            r10 = 1
            if (r8 != 0) goto L_0x0123
            int r8 = r2 - r5
            if (r8 <= 0) goto L_0x0047
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.i$a r11 = r0.f
            r11.a(r4, r5, r2)
        L_0x0047:
            if (r8 >= 0) goto L_0x004b
            int r5 = -r8
            goto L_0x004c
        L_0x004b:
            r5 = 0
        L_0x004c:
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.i$a r8 = r0.f
            boolean r11 = r8.a
            if (r11 == 0) goto L_0x011c
            int r11 = r8.c
            if (r11 != 0) goto L_0x0060
            r11 = 181(0xb5, float:2.54E-43)
            if (r6 != r11) goto L_0x0060
            int r5 = r8.b
            r8.c = r5
            goto L_0x0123
        L_0x0060:
            int r11 = r8.b
            int r11 = r11 - r5
            r8.b = r11
            r8.a = r9
            java.lang.String r12 = r0.a
            byte[] r5 = r8.d
            int r11 = r8.b
            byte[] r5 = java.util.Arrays.copyOf(r5, r11)
            r11 = 4
            byte r13 = r5[r11]
            r13 = r13 & 255(0xff, float:3.57E-43)
            r24 = 5
            byte r14 = r5[r24]
            r15 = r14 & 255(0xff, float:3.57E-43)
            r16 = 6
            byte r9 = r5[r16]
            r9 = r9 & 255(0xff, float:3.57E-43)
            int r13 = r13 << r11
            int r15 = r15 >> r11
            r17 = r13 | r15
            r13 = r14 & 15
            int r13 = r13 << 8
            r18 = r13 | r9
            r9 = 7
            byte r13 = r5[r9]
            r13 = r13 & 240(0xf0, float:3.36E-43)
            int r13 = r13 >> r11
            r14 = 2
            if (r13 == r14) goto L_0x00ab
            r14 = 3
            if (r13 == r14) goto L_0x00a5
            if (r13 == r11) goto L_0x009f
            r11 = 1065353216(0x3f800000, float:1.0)
            r22 = 1065353216(0x3f800000, float:1.0)
            goto L_0x00b4
        L_0x009f:
            int r11 = r18 * 121
            float r11 = (float) r11
            int r13 = r17 * 100
            goto L_0x00b0
        L_0x00a5:
            int r11 = r18 * 16
            float r11 = (float) r11
            int r13 = r17 * 9
            goto L_0x00b0
        L_0x00ab:
            int r11 = r18 * 4
            float r11 = (float) r11
            int r13 = r17 * 3
        L_0x00b0:
            float r13 = (float) r13
            float r11 = r11 / r13
            r22 = r11
        L_0x00b4:
            java.util.List r20 = java.util.Collections.singletonList(r5)
            java.lang.String r13 = "video/mpeg2"
            r14 = 0
            r15 = -1
            r16 = -1
            r19 = -1082130432(0xffffffffbf800000, float:-1.0)
            r21 = -1
            r23 = 0
            com.fyber.inneractive.sdk.player.exoplayer2.i r11 = com.fyber.inneractive.sdk.player.exoplayer2.i.a((java.lang.String) r12, (java.lang.String) r13, (java.lang.String) r14, (int) r15, (int) r16, (int) r17, (int) r18, (float) r19, (java.util.List<byte[]>) r20, (int) r21, (float) r22, (com.fyber.inneractive.sdk.player.exoplayer2.drm.a) r23)
            byte r9 = r5[r9]
            r9 = r9 & 15
            int r9 = r9 - r10
            if (r9 < 0) goto L_0x00f9
            double[] r12 = n
            int r13 = r12.length
            if (r9 >= r13) goto L_0x00f9
            r13 = r12[r9]
            int r8 = r8.c
            int r8 = r8 + 9
            byte r5 = r5[r8]
            r8 = r5 & 96
            int r8 = r8 >> 5
            r5 = r5 & 31
            if (r8 == r5) goto L_0x00f0
            double r8 = (double) r8
            r15 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r8 = r8 + r15
            int r5 = r5 + 1
            r15 = r11
            double r10 = (double) r5
            double r8 = r8 / r10
            double r13 = r13 * r8
            goto L_0x00f1
        L_0x00f0:
            r15 = r11
        L_0x00f1:
            r8 = 4696837146684686336(0x412e848000000000, double:1000000.0)
            double r8 = r8 / r13
            long r8 = (long) r8
            goto L_0x00fc
        L_0x00f9:
            r15 = r11
            r8 = 0
        L_0x00fc:
            java.lang.Long r5 = java.lang.Long.valueOf(r8)
            r8 = r15
            android.util.Pair r5 = android.util.Pair.create(r8, r5)
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.n r8 = r0.b
            java.lang.Object r9 = r5.first
            com.fyber.inneractive.sdk.player.exoplayer2.i r9 = (com.fyber.inneractive.sdk.player.exoplayer2.i) r9
            r8.a(r9)
            java.lang.Object r5 = r5.second
            java.lang.Long r5 = (java.lang.Long) r5
            long r8 = r5.longValue()
            r0.d = r8
            r5 = 1
            r0.c = r5
            goto L_0x0123
        L_0x011c:
            r5 = 1
            r9 = 179(0xb3, float:2.51E-43)
            if (r6 != r9) goto L_0x0123
            r8.a = r5
        L_0x0123:
            boolean r5 = r0.c
            if (r5 == 0) goto L_0x0171
            r5 = 184(0xb8, float:2.58E-43)
            if (r6 == r5) goto L_0x012d
            if (r6 != 0) goto L_0x0171
        L_0x012d:
            int r8 = r3 - r2
            boolean r9 = r0.g
            if (r9 == 0) goto L_0x014e
            boolean r9 = r0.k
            long r10 = r0.h
            long r13 = r0.l
            long r10 = r10 - r13
            int r11 = (int) r10
            int r17 = r11 - r8
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.n r13 = r0.b
            long r14 = r0.m
            r19 = 0
            r16 = r9
            r18 = r8
            r13.a(r14, r16, r17, r18, r19)
            r9 = 0
            r0.k = r9
            goto L_0x014f
        L_0x014e:
            r9 = 0
        L_0x014f:
            if (r6 != r5) goto L_0x0157
            r0.g = r9
            r5 = 1
            r0.k = r5
            goto L_0x0171
        L_0x0157:
            boolean r5 = r0.j
            if (r5 == 0) goto L_0x015e
            long r5 = r0.i
            goto L_0x0163
        L_0x015e:
            long r5 = r0.m
            long r9 = r0.d
            long r5 = r5 + r9
        L_0x0163:
            r0.m = r5
            long r5 = r0.h
            long r8 = (long) r8
            long r5 = r5 - r8
            r0.l = r5
            r5 = 0
            r0.j = r5
            r5 = 1
            r0.g = r5
        L_0x0171:
            r5 = r2
            r2 = r7
            goto L_0x001e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.i.a(com.fyber.inneractive.sdk.player.exoplayer2.util.k):void");
    }
}
