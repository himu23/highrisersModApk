package com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts;

import com.fyber.inneractive.sdk.player.exoplayer2.extractor.h;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.n;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.v;
import com.fyber.inneractive.sdk.player.exoplayer2.util.i;
import kotlin.jvm.internal.ByteCompanionObject;

public final class k implements h {
    public final s a;
    public String b;
    public n c;
    public a d;
    public boolean e;
    public final boolean[] f = new boolean[3];
    public final n g = new n(32, 128);
    public final n h = new n(33, 128);
    public final n i = new n(34, 128);
    public final n j = new n(39, 128);
    public final n k = new n(40, 128);
    public long l;
    public long m;
    public final com.fyber.inneractive.sdk.player.exoplayer2.util.k n = new com.fyber.inneractive.sdk.player.exoplayer2.util.k();

    public static final class a {
        public final n a;
        public long b;
        public boolean c;
        public int d;
        public long e;
        public boolean f;
        public boolean g;
        public boolean h;
        public boolean i;
        public boolean j;
        public long k;
        public long l;
        public boolean m;

        public a(n nVar) {
            this.a = nVar;
        }
    }

    public k(s sVar) {
        this.a = sVar;
    }

    public void a() {
        i.a(this.f);
        this.g.a();
        this.h.a();
        this.i.a();
        this.j.a();
        this.k.a();
        a aVar = this.d;
        aVar.f = false;
        aVar.g = false;
        aVar.h = false;
        aVar.i = false;
        aVar.j = false;
        this.l = 0;
    }

    public void a(long j2, boolean z) {
        this.m = j2;
    }

    public void b() {
    }

    public void a(h hVar, v.d dVar) {
        dVar.a();
        this.b = dVar.b();
        n a2 = hVar.a(dVar.c(), 2);
        this.c = a2;
        this.d = new a(a2);
        this.a.a(hVar, dVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:146:0x0314  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x033e  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x0366  */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x03b2  */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x03b4  */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x03be  */
    /* JADX WARNING: Removed duplicated region for block: B:175:0x03c0  */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x03c4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.fyber.inneractive.sdk.player.exoplayer2.util.k r39) {
        /*
            r38 = this;
            r0 = r38
        L_0x0002:
            r1 = r39
            int r2 = r39.a()
            if (r2 <= 0) goto L_0x03e9
            int r2 = r1.b
            int r3 = r1.c
            byte[] r4 = r1.a
            long r5 = r0.l
            int r7 = r39.a()
            long r7 = (long) r7
            long r5 = r5 + r7
            r0.l = r5
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.n r5 = r0.c
            int r6 = r39.a()
            r5.a(r1, r6)
        L_0x0023:
            if (r2 >= r3) goto L_0x0002
            boolean[] r5 = r0.f
            int r5 = com.fyber.inneractive.sdk.player.exoplayer2.util.i.a(r4, r2, r3, r5)
            if (r5 != r3) goto L_0x0031
            r0.a(r4, r2, r3)
            return
        L_0x0031:
            int r6 = r5 + 3
            byte r7 = r4[r6]
            r7 = r7 & 126(0x7e, float:1.77E-43)
            r8 = 1
            int r7 = r7 >> r8
            int r9 = r5 - r2
            if (r9 <= 0) goto L_0x0040
            r0.a(r4, r2, r5)
        L_0x0040:
            int r15 = r3 - r5
            long r10 = r0.l
            long r12 = (long) r15
            long r10 = r10 - r12
            r2 = 0
            if (r9 >= 0) goto L_0x004b
            int r5 = -r9
            goto L_0x004c
        L_0x004b:
            r5 = 0
        L_0x004c:
            long r12 = r0.m
            boolean r9 = r0.e
            if (r9 == 0) goto L_0x00b5
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.k$a r9 = r0.d
            boolean r14 = r9.j
            if (r14 == 0) goto L_0x0063
            boolean r14 = r9.g
            if (r14 == 0) goto L_0x0063
            boolean r14 = r9.c
            r9.m = r14
            r9.j = r2
            goto L_0x006c
        L_0x0063:
            boolean r14 = r9.h
            if (r14 != 0) goto L_0x0078
            boolean r14 = r9.g
            if (r14 == 0) goto L_0x006c
            goto L_0x0078
        L_0x006c:
            r17 = r3
            r18 = r4
            r19 = r6
            r20 = r7
            r25 = r15
            goto L_0x030a
        L_0x0078:
            boolean r14 = r9.i
            r17 = r3
            if (r14 == 0) goto L_0x00a1
            long r2 = r9.b
            r14 = r9
            long r8 = r10 - r2
            int r9 = (int) r8
            int r23 = r15 + r9
            r8 = r14
            boolean r9 = r8.m
            r25 = r15
            long r14 = r8.k
            long r2 = r2 - r14
            int r3 = (int) r2
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.n r2 = r8.a
            long r14 = r8.l
            r24 = 0
            r18 = r2
            r19 = r14
            r21 = r9
            r22 = r3
            r18.a(r19, r21, r22, r23, r24)
            goto L_0x00a4
        L_0x00a1:
            r8 = r9
            r25 = r15
        L_0x00a4:
            long r2 = r8.b
            r8.k = r2
            long r2 = r8.e
            r8.l = r2
            r2 = 1
            r8.i = r2
            boolean r2 = r8.c
            r8.m = r2
            goto L_0x0304
        L_0x00b5:
            r17 = r3
            r25 = r15
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.n r2 = r0.g
            r2.a(r5)
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.n r2 = r0.h
            r2.a(r5)
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.n r2 = r0.i
            r2.a(r5)
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.n r2 = r0.g
            boolean r3 = r2.c
            if (r3 == 0) goto L_0x0304
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.n r3 = r0.h
            boolean r8 = r3.c
            if (r8 == 0) goto L_0x0304
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.n r8 = r0.i
            boolean r9 = r8.c
            if (r9 == 0) goto L_0x0304
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.n r9 = r0.c
            java.lang.String r14 = r0.b
            int r15 = r2.e
            int r1 = r3.e
            int r1 = r1 + r15
            r18 = r4
            int r4 = r8.e
            int r1 = r1 + r4
            byte[] r1 = new byte[r1]
            byte[] r4 = r2.d
            r19 = r6
            r6 = 0
            java.lang.System.arraycopy(r4, r6, r1, r6, r15)
            byte[] r4 = r3.d
            int r15 = r2.e
            r20 = r7
            int r7 = r3.e
            java.lang.System.arraycopy(r4, r6, r1, r15, r7)
            byte[] r4 = r8.d
            int r2 = r2.e
            int r7 = r3.e
            int r2 = r2 + r7
            int r7 = r8.e
            java.lang.System.arraycopy(r4, r6, r1, r2, r7)
            com.fyber.inneractive.sdk.player.exoplayer2.util.l r2 = new com.fyber.inneractive.sdk.player.exoplayer2.util.l
            byte[] r4 = r3.d
            int r3 = r3.e
            r2.<init>(r4, r6, r3)
            r3 = 44
            r2.d(r3)
            r3 = 3
            int r4 = r2.b(r3)
            r2.f()
            r6 = 88
            r2.d(r6)
            r6 = 8
            r2.d(r6)
            r7 = 0
            r8 = 0
        L_0x012b:
            if (r7 >= r4) goto L_0x0140
            boolean r15 = r2.c()
            if (r15 == 0) goto L_0x0135
            int r8 = r8 + 89
        L_0x0135:
            boolean r15 = r2.c()
            if (r15 == 0) goto L_0x013d
            int r8 = r8 + 8
        L_0x013d:
            int r7 = r7 + 1
            goto L_0x012b
        L_0x0140:
            r2.d(r8)
            r7 = 2
            if (r4 <= 0) goto L_0x014d
            int r8 = 8 - r4
            int r8 = r8 * 2
            r2.d(r8)
        L_0x014d:
            r2.d()
            int r8 = r2.d()
            if (r8 != r3) goto L_0x0159
            r2.f()
        L_0x0159:
            int r15 = r2.d()
            int r21 = r2.d()
            boolean r22 = r2.c()
            if (r22 == 0) goto L_0x0193
            int r22 = r2.d()
            int r23 = r2.d()
            int r24 = r2.d()
            int r26 = r2.d()
            r6 = 1
            if (r8 == r6) goto L_0x0180
            if (r8 != r7) goto L_0x017d
            goto L_0x0180
        L_0x017d:
            r28 = 1
            goto L_0x0182
        L_0x0180:
            r28 = 2
        L_0x0182:
            if (r8 != r6) goto L_0x0186
            r6 = 2
            goto L_0x0187
        L_0x0186:
            r6 = 1
        L_0x0187:
            int r22 = r22 + r23
            int r28 = r28 * r22
            int r15 = r15 - r28
            int r24 = r24 + r26
            int r6 = r6 * r24
            int r21 = r21 - r6
        L_0x0193:
            r31 = r15
            r32 = r21
            r2.d()
            r2.d()
            int r6 = r2.d()
            boolean r8 = r2.c()
            if (r8 == 0) goto L_0x01a9
            r8 = 0
            goto L_0x01aa
        L_0x01a9:
            r8 = r4
        L_0x01aa:
            if (r8 > r4) goto L_0x01b8
            r2.d()
            r2.d()
            r2.d()
            int r8 = r8 + 1
            goto L_0x01aa
        L_0x01b8:
            r2.d()
            r2.d()
            r2.d()
            r2.d()
            r2.d()
            r2.d()
            boolean r4 = r2.c()
            if (r4 == 0) goto L_0x020f
            boolean r4 = r2.c()
            if (r4 == 0) goto L_0x020f
            r4 = 0
        L_0x01d7:
            r8 = 4
            if (r4 >= r8) goto L_0x020f
            r15 = 0
        L_0x01db:
            r7 = 6
            if (r15 >= r7) goto L_0x020b
            boolean r7 = r2.c()
            if (r7 != 0) goto L_0x01e8
            r2.d()
            goto L_0x0203
        L_0x01e8:
            int r7 = r4 << 1
            int r7 = r7 + r8
            r8 = 1
            int r7 = r8 << r7
            r3 = 64
            int r3 = java.lang.Math.min(r3, r7)
            if (r4 <= r8) goto L_0x01f9
            r2.e()
        L_0x01f9:
            r7 = 0
        L_0x01fa:
            if (r7 >= r3) goto L_0x0202
            r2.e()
            int r7 = r7 + 1
            goto L_0x01fa
        L_0x0202:
            r3 = 3
        L_0x0203:
            if (r4 != r3) goto L_0x0207
            r7 = 3
            goto L_0x0208
        L_0x0207:
            r7 = 1
        L_0x0208:
            int r15 = r15 + r7
            r8 = 4
            goto L_0x01db
        L_0x020b:
            int r4 = r4 + 1
            r7 = 2
            goto L_0x01d7
        L_0x020f:
            r3 = 2
            r2.d(r3)
            boolean r3 = r2.c()
            if (r3 == 0) goto L_0x0227
            r3 = 8
            r2.d(r3)
            r2.d()
            r2.d()
            r2.f()
        L_0x0227:
            int r3 = r2.d()
            r4 = 0
            r7 = 0
            r8 = 0
        L_0x022e:
            if (r4 >= r3) goto L_0x027b
            if (r4 == 0) goto L_0x0236
            boolean r7 = r2.c()
        L_0x0236:
            if (r7 == 0) goto L_0x0250
            r2.f()
            r2.d()
            r15 = 0
        L_0x023f:
            if (r15 > r8) goto L_0x024d
            boolean r22 = r2.c()
            if (r22 == 0) goto L_0x024a
            r2.f()
        L_0x024a:
            int r15 = r15 + 1
            goto L_0x023f
        L_0x024d:
            r23 = r3
            goto L_0x0276
        L_0x0250:
            int r8 = r2.d()
            int r15 = r2.d()
            int r22 = r8 + r15
            r23 = r3
            r3 = 0
        L_0x025d:
            if (r3 >= r8) goto L_0x0268
            r2.d()
            r2.f()
            int r3 = r3 + 1
            goto L_0x025d
        L_0x0268:
            r3 = 0
        L_0x0269:
            if (r3 >= r15) goto L_0x0274
            r2.d()
            r2.f()
            int r3 = r3 + 1
            goto L_0x0269
        L_0x0274:
            r8 = r22
        L_0x0276:
            int r4 = r4 + 1
            r3 = r23
            goto L_0x022e
        L_0x027b:
            boolean r3 = r2.c()
            if (r3 == 0) goto L_0x0291
            r3 = 0
        L_0x0282:
            int r4 = r2.d()
            if (r3 >= r4) goto L_0x0291
            r4 = 5
            int r7 = r6 + 5
            r2.d(r7)
            int r3 = r3 + 1
            goto L_0x0282
        L_0x0291:
            r3 = 2
            r2.d(r3)
            boolean r3 = r2.c()
            if (r3 == 0) goto L_0x02df
            boolean r3 = r2.c()
            if (r3 == 0) goto L_0x02df
            r3 = 8
            int r3 = r2.b(r3)
            r4 = 255(0xff, float:3.57E-43)
            if (r3 != r4) goto L_0x02bf
            r4 = 16
            int r3 = r2.b(r4)
            int r2 = r2.b(r4)
            if (r3 == 0) goto L_0x02e1
            if (r2 == 0) goto L_0x02e1
            float r3 = (float) r3
            float r2 = (float) r2
            float r3 = r3 / r2
            r36 = r3
            goto L_0x02e5
        L_0x02bf:
            r4 = 16
            float[] r2 = com.fyber.inneractive.sdk.player.exoplayer2.util.i.b
            int r6 = r2.length
            if (r3 >= r6) goto L_0x02cb
            r2 = r2[r3]
            r36 = r2
            goto L_0x02e5
        L_0x02cb:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r6 = "Unexpected aspect_ratio_idc value: "
            r2.<init>(r6)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = "H265Reader"
            android.util.Log.w(r3, r2)
            goto L_0x02e1
        L_0x02df:
            r4 = 16
        L_0x02e1:
            r2 = 1065353216(0x3f800000, float:1.0)
            r36 = 1065353216(0x3f800000, float:1.0)
        L_0x02e5:
            java.util.List r34 = java.util.Collections.singletonList(r1)
            java.lang.String r27 = "video/hevc"
            r28 = 0
            r29 = -1
            r30 = -1
            r33 = -1082130432(0xffffffffbf800000, float:-1.0)
            r35 = -1
            r37 = 0
            r26 = r14
            com.fyber.inneractive.sdk.player.exoplayer2.i r1 = com.fyber.inneractive.sdk.player.exoplayer2.i.a((java.lang.String) r26, (java.lang.String) r27, (java.lang.String) r28, (int) r29, (int) r30, (int) r31, (int) r32, (float) r33, (java.util.List<byte[]>) r34, (int) r35, (float) r36, (com.fyber.inneractive.sdk.player.exoplayer2.drm.a) r37)
            r9.a(r1)
            r1 = 1
            r0.e = r1
            goto L_0x030c
        L_0x0304:
            r18 = r4
            r19 = r6
            r20 = r7
        L_0x030a:
            r4 = 16
        L_0x030c:
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.n r1 = r0.j
            boolean r1 = r1.a(r5)
            if (r1 == 0) goto L_0x0336
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.n r1 = r0.j
            byte[] r2 = r1.d
            int r1 = r1.e
            int r1 = com.fyber.inneractive.sdk.player.exoplayer2.util.i.a(r2, r1)
            com.fyber.inneractive.sdk.player.exoplayer2.util.k r2 = r0.n
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.n r3 = r0.j
            byte[] r3 = r3.d
            r2.a((byte[]) r3, (int) r1)
            com.fyber.inneractive.sdk.player.exoplayer2.util.k r1 = r0.n
            r2 = 5
            r1.f(r2)
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.s r1 = r0.a
            com.fyber.inneractive.sdk.player.exoplayer2.util.k r2 = r0.n
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.n[] r1 = r1.b
            com.fyber.inneractive.sdk.player.exoplayer2.text.cea.a.a(r12, r2, r1)
        L_0x0336:
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.n r1 = r0.k
            boolean r1 = r1.a(r5)
            if (r1 == 0) goto L_0x0360
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.n r1 = r0.k
            byte[] r2 = r1.d
            int r1 = r1.e
            int r1 = com.fyber.inneractive.sdk.player.exoplayer2.util.i.a(r2, r1)
            com.fyber.inneractive.sdk.player.exoplayer2.util.k r2 = r0.n
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.n r3 = r0.k
            byte[] r3 = r3.d
            r2.a((byte[]) r3, (int) r1)
            com.fyber.inneractive.sdk.player.exoplayer2.util.k r1 = r0.n
            r2 = 5
            r1.f(r2)
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.s r1 = r0.a
            com.fyber.inneractive.sdk.player.exoplayer2.util.k r2 = r0.n
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.n[] r1 = r1.b
            com.fyber.inneractive.sdk.player.exoplayer2.text.cea.a.a(r12, r2, r1)
        L_0x0360:
            long r1 = r0.m
            boolean r3 = r0.e
            if (r3 == 0) goto L_0x03c4
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.k$a r3 = r0.d
            r5 = 0
            r3.g = r5
            r3.h = r5
            r3.e = r1
            r3.d = r5
            r3.b = r10
            r1 = 32
            r2 = r20
            if (r2 < r1) goto L_0x03a8
            boolean r1 = r3.j
            if (r1 != 0) goto L_0x0398
            boolean r1 = r3.i
            if (r1 == 0) goto L_0x0398
            boolean r13 = r3.m
            long r5 = r3.k
            long r10 = r10 - r5
            int r14 = (int) r10
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.n r10 = r3.a
            long r11 = r3.l
            r16 = 0
            r1 = 16
            r15 = r25
            r10.a(r11, r13, r14, r15, r16)
            r4 = 0
            r3.i = r4
            goto L_0x039b
        L_0x0398:
            r1 = 16
            r4 = 0
        L_0x039b:
            r5 = 34
            if (r2 > r5) goto L_0x03ab
            boolean r5 = r3.j
            r6 = 1
            r5 = r5 ^ r6
            r3.h = r5
            r3.j = r6
            goto L_0x03ac
        L_0x03a8:
            r1 = 16
            r4 = 0
        L_0x03ab:
            r6 = 1
        L_0x03ac:
            if (r2 < r1) goto L_0x03b4
            r1 = 21
            if (r2 > r1) goto L_0x03b4
            r1 = 1
            goto L_0x03b5
        L_0x03b4:
            r1 = 0
        L_0x03b5:
            r3.c = r1
            if (r1 != 0) goto L_0x03c0
            r1 = 9
            if (r2 > r1) goto L_0x03be
            goto L_0x03c0
        L_0x03be:
            r8 = 0
            goto L_0x03c1
        L_0x03c0:
            r8 = 1
        L_0x03c1:
            r3.f = r8
            goto L_0x03d5
        L_0x03c4:
            r2 = r20
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.n r1 = r0.g
            r1.b(r2)
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.n r1 = r0.h
            r1.b(r2)
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.n r1 = r0.i
            r1.b(r2)
        L_0x03d5:
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.n r1 = r0.j
            r1.b(r2)
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.n r1 = r0.k
            r1.b(r2)
            r1 = r39
            r3 = r17
            r4 = r18
            r2 = r19
            goto L_0x0023
        L_0x03e9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.k.a(com.fyber.inneractive.sdk.player.exoplayer2.util.k):void");
    }

    public final void a(byte[] bArr, int i2, int i3) {
        if (this.e) {
            a aVar = this.d;
            if (aVar.f) {
                int i4 = aVar.d;
                int i5 = (i2 + 2) - i4;
                if (i5 < i3) {
                    aVar.g = (bArr[i5] & ByteCompanionObject.MIN_VALUE) != 0;
                    aVar.f = false;
                } else {
                    aVar.d = i4 + (i3 - i2);
                }
            }
        } else {
            this.g.a(bArr, i2, i3);
            this.h.a(bArr, i2, i3);
            this.i.a(bArr, i2, i3);
        }
        this.j.a(bArr, i2, i3);
        this.k.a(bArr, i2, i3);
    }
}
