package com.fyber.inneractive.sdk.player.exoplayer2.extractor.mkv;

import com.fyber.inneractive.sdk.player.exoplayer2.extractor.b;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.g;
import java.io.IOException;
import java.util.Stack;
import kotlin.UByte;

public final class a implements b {
    public final byte[] a = new byte[8];
    public final Stack<C0119a> b = new Stack<>();
    public final f c = new f();
    public c d;
    public int e;
    public int f;
    public long g;

    /* renamed from: com.fyber.inneractive.sdk.player.exoplayer2.extractor.mkv.a$a  reason: collision with other inner class name */
    public static final class C0119a {
        public final int a;
        public final long b;

        public C0119a(int i, long j) {
            this.a = i;
            this.b = j;
        }
    }

    public void a(c cVar) {
        this.d = cVar;
    }

    public final long b(g gVar, int i) throws IOException, InterruptedException {
        ((b) gVar).b(this.a, 0, i, false);
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            j = (j << 8) | ((long) (this.a[i2] & UByte.MAX_VALUE));
        }
        return j;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v8, resolved type: java.util.ArrayList} */
    /* JADX WARNING: type inference failed for: r4v0 */
    /* JADX WARNING: type inference failed for: r5v0 */
    /* JADX WARNING: type inference failed for: r4v1, types: [boolean] */
    /* JADX WARNING: type inference failed for: r3v4 */
    /* JADX WARNING: type inference failed for: r4v21 */
    /* JADX WARNING: type inference failed for: r5v11 */
    /* JADX WARNING: type inference failed for: r3v33, types: [int, boolean] */
    /* JADX WARNING: type inference failed for: r3v35 */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:247:0x04d4, code lost:
        r4 = -1;
        r33 = r6;
        r6 = r2;
        r2 = r33;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:249:0x04f6, code lost:
        r4 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:282:0x0580, code lost:
        r13 = null;
        r22 = 4096;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:283:0x0585, code lost:
        r25 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:317:0x0602, code lost:
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:318:0x0603, code lost:
        r4 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:330:0x0634, code lost:
        if (r2.i() == r6.getLeastSignificantBits()) goto L_0x0636;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:336:0x0662, code lost:
        r6 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:345:0x067b, code lost:
        r13 = r2;
        r25 = r4;
        r22 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:346:0x0680, code lost:
        r2 = r3.M;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:347:0x0684, code lost:
        if (r3.L == false) goto L_0x0688;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:348:0x0686, code lost:
        r4 = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:349:0x0688, code lost:
        r4 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:350:0x0689, code lost:
        r2 = r2 | r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:351:0x068e, code lost:
        if (com.fyber.inneractive.sdk.player.exoplayer2.util.h.d(r6) == false) goto L_0x06b5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:352:0x0690, code lost:
        r2 = com.fyber.inneractive.sdk.player.exoplayer2.i.a(java.lang.Integer.toString(r8), r6, (java.lang.String) null, -1, r22, r3.G, r3.I, r25, r13, r3.i, (int) r2, r3.N);
        r11 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:354:0x06b9, code lost:
        if (com.fyber.inneractive.sdk.player.exoplayer2.util.h.e(r6) == false) goto L_0x07e7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:356:0x06bd, code lost:
        if (r3.n != 0) goto L_0x06d1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:357:0x06bf, code lost:
        r2 = r3.l;
        r4 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:358:0x06c2, code lost:
        if (r2 != -1) goto L_0x06c6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:359:0x06c4, code lost:
        r2 = r3.j;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:360:0x06c6, code lost:
        r3.l = r2;
        r2 = r3.m;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:361:0x06ca, code lost:
        if (r2 != -1) goto L_0x06ce;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:362:0x06cc, code lost:
        r2 = r3.k;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:363:0x06ce, code lost:
        r3.m = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:364:0x06d1, code lost:
        r4 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:365:0x06d2, code lost:
        r2 = r3.l;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:366:0x06d6, code lost:
        if (r2 == r4) goto L_0x06ea;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:367:0x06d8, code lost:
        r9 = r3.m;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:368:0x06da, code lost:
        if (r9 == r4) goto L_0x06ea;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:369:0x06dc, code lost:
        r28 = ((float) (r3.k * r2)) / ((float) (r3.j * r9));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:370:0x06ea, code lost:
        r28 = -1.0f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:372:0x06ee, code lost:
        if (r3.q == false) goto L_0x07bb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:374:0x06f4, code lost:
        if (r3.w == -1.0f) goto L_0x07ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:376:0x06fa, code lost:
        if (r3.x == -1.0f) goto L_0x07ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:378:0x0700, code lost:
        if (r3.y == -1.0f) goto L_0x07ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:380:0x0706, code lost:
        if (r3.z == -1.0f) goto L_0x07ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:382:0x070c, code lost:
        if (r3.A == -1.0f) goto L_0x07ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:384:0x0712, code lost:
        if (r3.B == -1.0f) goto L_0x07ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:386:0x0718, code lost:
        if (r3.C == -1.0f) goto L_0x07ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:388:0x071e, code lost:
        if (r3.D == -1.0f) goto L_0x07ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:390:0x0724, code lost:
        if (r3.E == -1.0f) goto L_0x07ac;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:392:0x072a, code lost:
        if (r3.F != -1.0f) goto L_0x072e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:393:0x072e, code lost:
        r2 = new byte[25];
        r4 = java.nio.ByteBuffer.wrap(r2);
        r4.put((byte) 0);
        r4.putShort((short) ((int) ((r3.w * 50000.0f) + 0.5f)));
        r4.putShort((short) ((int) ((r3.x * 50000.0f) + 0.5f)));
        r4.putShort((short) ((int) ((r3.y * 50000.0f) + 0.5f)));
        r4.putShort((short) ((int) ((r3.z * 50000.0f) + 0.5f)));
        r4.putShort((short) ((int) ((r3.A * 50000.0f) + 0.5f)));
        r4.putShort((short) ((int) ((r3.B * 50000.0f) + 0.5f)));
        r4.putShort((short) ((int) ((r3.C * 50000.0f) + 0.5f)));
        r4.putShort((short) ((int) ((r3.D * 50000.0f) + 0.5f)));
        r4.putShort((short) ((int) (r3.E + 0.5f)));
        r4.putShort((short) ((int) (r3.F + 0.5f)));
        r4.putShort((short) r3.u);
        r4.putShort((short) r3.v);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:394:0x07ac, code lost:
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:395:0x07ad, code lost:
        r31 = new com.fyber.inneractive.sdk.player.exoplayer2.video.b(r3.r, r3.t, r3.s, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:396:0x07bb, code lost:
        r31 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:397:0x07bd, code lost:
        r2 = com.fyber.inneractive.sdk.player.exoplayer2.i.a(java.lang.Integer.toString(r8), r6, (java.lang.String) null, -1, r22, r3.j, r3.k, -1.0f, r13, -1, r28, r3.o, r3.p, r31, r3.i);
        r11 = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:399:0x07ed, code lost:
        if ("application/x-subrip".equals(r6) == false) goto L_0x0809;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:400:0x07ef, code lost:
        r2 = com.fyber.inneractive.sdk.player.exoplayer2.i.a(java.lang.Integer.toString(r8), r6, (java.lang.String) null, -1, (int) r2, r3.N, r3.i);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:401:0x0807, code lost:
        r11 = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:403:0x080f, code lost:
        if ("application/vobsub".equals(r6) != false) goto L_0x082a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:405:0x0817, code lost:
        if ("application/pgs".equals(r6) != false) goto L_0x082a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:407:0x081f, code lost:
        if ("application/dvbsubs".equals(r6) == false) goto L_0x0822;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:409:0x0829, code lost:
        throw new com.fyber.inneractive.sdk.player.exoplayer2.l("Unexpected MIME type.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:410:0x082a, code lost:
        r2 = com.fyber.inneractive.sdk.player.exoplayer2.i.a(java.lang.Integer.toString(r8), r6, (java.lang.String) null, -1, r13, r3.N, r3.i);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:411:0x083a, code lost:
        r4 = r7.a(r3.b, r11);
        r3.O = r4;
        r4.a(r2);
        r2 = r1.c;
        r3 = r1.t;
        r2.put(r3.b, r3);
        r2 = null;
     */
    /* JADX WARNING: Incorrect type for immutable var: ssa=int, code=?, for r5v1, types: [int, boolean] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.g r35) throws java.io.IOException, java.lang.InterruptedException {
        /*
            r34 = this;
            r0 = r34
            r1 = r35
            java.lang.String r2 = "Error parsing vorbis codec private"
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mkv.c r3 = r0.d
            r4 = 0
            r5 = 1
            if (r3 == 0) goto L_0x000e
            r3 = 1
            goto L_0x000f
        L_0x000e:
            r3 = 0
        L_0x000f:
            com.fyber.inneractive.sdk.player.exoplayer2.util.a.b(r3)
        L_0x0012:
            java.util.Stack<com.fyber.inneractive.sdk.player.exoplayer2.extractor.mkv.a$a> r3 = r0.b
            boolean r3 = r3.isEmpty()
            r6 = -1
            r10 = 4
            r11 = 3
            r12 = 2
            r13 = -1
            if (r3 != 0) goto L_0x0879
            r3 = r1
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.b r3 = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) r3
            long r14 = r3.c
            java.util.Stack<com.fyber.inneractive.sdk.player.exoplayer2.extractor.mkv.a$a> r3 = r0.b
            java.lang.Object r3 = r3.peek()
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mkv.a$a r3 = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.mkv.a.C0119a) r3
            long r8 = r3.b
            int r3 = (r14 > r8 ? 1 : (r14 == r8 ? 0 : -1))
            if (r3 < 0) goto L_0x0879
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mkv.c r1 = r0.d
            java.util.Stack<com.fyber.inneractive.sdk.player.exoplayer2.extractor.mkv.a$a> r3 = r0.b
            java.lang.Object r3 = r3.pop()
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mkv.a$a r3 = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.mkv.a.C0119a) r3
            int r3 = r3.a
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mkv.d$b r1 = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.mkv.d.b) r1
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mkv.d r1 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mkv.d.this
            r1.getClass()
            r8 = 160(0xa0, float:2.24E-43)
            if (r3 == r8) goto L_0x0853
            r8 = 174(0xae, float:2.44E-43)
            r9 = 0
            if (r3 == r8) goto L_0x017b
            r2 = 19899(0x4dbb, float:2.7884E-41)
            r8 = 475249515(0x1c53bb6b, float:7.0056276E-22)
            if (r3 == r2) goto L_0x0164
            r2 = 25152(0x6240, float:3.5245E-41)
            if (r3 == r2) goto L_0x013a
            r2 = 28032(0x6d80, float:3.9281E-41)
            if (r3 == r2) goto L_0x0127
            r2 = 357149030(0x1549a966, float:4.072526E-26)
            r10 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r3 == r2) goto L_0x010f
            r2 = 374648427(0x1654ae6b, float:1.718026E-25)
            if (r3 == r2) goto L_0x00f9
            if (r3 == r8) goto L_0x0071
            goto L_0x0161
        L_0x0071:
            boolean r2 = r1.u
            if (r2 != 0) goto L_0x0161
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.h r2 = r1.Y
            long r12 = r1.p
            int r3 = (r12 > r6 ? 1 : (r12 == r6 ? 0 : -1))
            if (r3 == 0) goto L_0x00e8
            long r6 = r1.s
            int r3 = (r6 > r10 ? 1 : (r6 == r10 ? 0 : -1))
            if (r3 == 0) goto L_0x00e8
            com.fyber.inneractive.sdk.player.exoplayer2.util.f r3 = r1.B
            if (r3 == 0) goto L_0x00e8
            int r3 = r3.a
            if (r3 == 0) goto L_0x00e8
            com.fyber.inneractive.sdk.player.exoplayer2.util.f r6 = r1.C
            if (r6 == 0) goto L_0x00e8
            int r6 = r6.a
            if (r6 == r3) goto L_0x0094
            goto L_0x00e8
        L_0x0094:
            int[] r6 = new int[r3]
            long[] r7 = new long[r3]
            long[] r8 = new long[r3]
            long[] r10 = new long[r3]
            r11 = 0
        L_0x009d:
            if (r11 >= r3) goto L_0x00b5
            com.fyber.inneractive.sdk.player.exoplayer2.util.f r12 = r1.B
            long r12 = r12.a((int) r11)
            r10[r11] = r12
            long r12 = r1.p
            com.fyber.inneractive.sdk.player.exoplayer2.util.f r14 = r1.C
            long r14 = r14.a((int) r11)
            long r12 = r12 + r14
            r7[r11] = r12
            int r11 = r11 + 1
            goto L_0x009d
        L_0x00b5:
            int r11 = r3 + -1
            if (r4 >= r11) goto L_0x00cc
            int r11 = r4 + 1
            r12 = r7[r11]
            r14 = r7[r4]
            long r12 = r12 - r14
            int r13 = (int) r12
            r6[r4] = r13
            r12 = r10[r11]
            r14 = r10[r4]
            long r12 = r12 - r14
            r8[r4] = r12
            r4 = r11
            goto L_0x00b5
        L_0x00cc:
            long r3 = r1.p
            long r12 = r1.o
            long r3 = r3 + r12
            r12 = r7[r11]
            long r3 = r3 - r12
            int r4 = (int) r3
            r6[r11] = r4
            long r3 = r1.s
            r12 = r10[r11]
            long r3 = r3 - r12
            r8[r11] = r3
            r1.B = r9
            r1.C = r9
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.a r3 = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.a
            r3.<init>(r6, r7, r8, r10)
            goto L_0x00f3
        L_0x00e8:
            r1.B = r9
            r1.C = r9
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.m$a r3 = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.m$a
            long r6 = r1.s
            r3.<init>(r6)
        L_0x00f3:
            r2.a(r3)
            r1.u = r5
            goto L_0x0161
        L_0x00f9:
            android.util.SparseArray<com.fyber.inneractive.sdk.player.exoplayer2.extractor.mkv.d$c> r2 = r1.c
            int r2 = r2.size()
            if (r2 == 0) goto L_0x0107
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.h r1 = r1.Y
            r1.c()
            goto L_0x0161
        L_0x0107:
            com.fyber.inneractive.sdk.player.exoplayer2.l r1 = new com.fyber.inneractive.sdk.player.exoplayer2.l
            java.lang.String r2 = "No valid tracks were found"
            r1.<init>((java.lang.String) r2)
            throw r1
        L_0x010f:
            long r2 = r1.q
            int r4 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1))
            if (r4 != 0) goto L_0x011a
            r2 = 1000000(0xf4240, double:4.940656E-318)
            r1.q = r2
        L_0x011a:
            long r2 = r1.r
            int r4 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1))
            if (r4 == 0) goto L_0x0161
            long r2 = r1.a((long) r2)
            r1.s = r2
            goto L_0x0161
        L_0x0127:
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mkv.d$c r1 = r1.t
            boolean r2 = r1.e
            if (r2 == 0) goto L_0x0161
            byte[] r1 = r1.f
            if (r1 != 0) goto L_0x0132
            goto L_0x0161
        L_0x0132:
            com.fyber.inneractive.sdk.player.exoplayer2.l r1 = new com.fyber.inneractive.sdk.player.exoplayer2.l
            java.lang.String r2 = "Combining encryption and compression is not supported"
            r1.<init>((java.lang.String) r2)
            throw r1
        L_0x013a:
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mkv.d$c r1 = r1.t
            boolean r2 = r1.e
            if (r2 == 0) goto L_0x0161
            byte[] r2 = r1.g
            if (r2 == 0) goto L_0x0159
            com.fyber.inneractive.sdk.player.exoplayer2.drm.a r3 = new com.fyber.inneractive.sdk.player.exoplayer2.drm.a
            com.fyber.inneractive.sdk.player.exoplayer2.drm.a$b[] r6 = new com.fyber.inneractive.sdk.player.exoplayer2.drm.a.b[r5]
            com.fyber.inneractive.sdk.player.exoplayer2.drm.a$b r7 = new com.fyber.inneractive.sdk.player.exoplayer2.drm.a$b
            java.util.UUID r8 = com.fyber.inneractive.sdk.player.exoplayer2.b.b
            java.lang.String r9 = "video/webm"
            r7.<init>(r8, r9, r2, r4)
            r6[r4] = r7
            r3.<init>(r5, r6)
            r1.i = r3
            goto L_0x0161
        L_0x0159:
            com.fyber.inneractive.sdk.player.exoplayer2.l r1 = new com.fyber.inneractive.sdk.player.exoplayer2.l
            java.lang.String r2 = "Encrypted Track found but ContentEncKeyID was not found"
            r1.<init>((java.lang.String) r2)
            throw r1
        L_0x0161:
            r4 = 1
            goto L_0x0878
        L_0x0164:
            int r2 = r1.v
            if (r2 == r13) goto L_0x0173
            long r3 = r1.w
            int r9 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r9 == 0) goto L_0x0173
            if (r2 != r8) goto L_0x0161
            r1.y = r3
            goto L_0x0161
        L_0x0173:
            com.fyber.inneractive.sdk.player.exoplayer2.l r1 = new com.fyber.inneractive.sdk.player.exoplayer2.l
            java.lang.String r2 = "Mandatory element SeekID or SeekPosition not found"
            r1.<init>((java.lang.String) r2)
            throw r1
        L_0x017b:
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mkv.d$c r3 = r1.t
            java.lang.String r3 = r3.a
            java.lang.String r6 = "V_VP8"
            boolean r7 = r6.equals(r3)
            if (r7 != 0) goto L_0x0263
            java.lang.String r7 = "V_VP9"
            boolean r7 = r7.equals(r3)
            if (r7 != 0) goto L_0x0263
            java.lang.String r7 = "V_MPEG2"
            boolean r7 = r7.equals(r3)
            if (r7 != 0) goto L_0x0263
            java.lang.String r7 = "V_MPEG4/ISO/SP"
            boolean r7 = r7.equals(r3)
            if (r7 != 0) goto L_0x0263
            java.lang.String r7 = "V_MPEG4/ISO/ASP"
            boolean r7 = r7.equals(r3)
            if (r7 != 0) goto L_0x0263
            java.lang.String r7 = "V_MPEG4/ISO/AP"
            boolean r7 = r7.equals(r3)
            if (r7 != 0) goto L_0x0263
            java.lang.String r7 = "V_MPEG4/ISO/AVC"
            boolean r7 = r7.equals(r3)
            if (r7 != 0) goto L_0x0263
            java.lang.String r7 = "V_MPEGH/ISO/HEVC"
            boolean r7 = r7.equals(r3)
            if (r7 != 0) goto L_0x0263
            java.lang.String r7 = "V_MS/VFW/FOURCC"
            boolean r7 = r7.equals(r3)
            if (r7 != 0) goto L_0x0263
            java.lang.String r7 = "V_THEORA"
            boolean r7 = r7.equals(r3)
            if (r7 != 0) goto L_0x0263
            java.lang.String r7 = "A_OPUS"
            boolean r7 = r7.equals(r3)
            if (r7 != 0) goto L_0x0263
            java.lang.String r7 = "A_VORBIS"
            boolean r7 = r7.equals(r3)
            if (r7 != 0) goto L_0x0263
            java.lang.String r7 = "A_AAC"
            boolean r7 = r7.equals(r3)
            if (r7 != 0) goto L_0x0263
            java.lang.String r7 = "A_MPEG/L2"
            boolean r7 = r7.equals(r3)
            if (r7 != 0) goto L_0x0263
            java.lang.String r7 = "A_MPEG/L3"
            boolean r7 = r7.equals(r3)
            if (r7 != 0) goto L_0x0263
            java.lang.String r7 = "A_AC3"
            boolean r7 = r7.equals(r3)
            if (r7 != 0) goto L_0x0263
            java.lang.String r7 = "A_EAC3"
            boolean r7 = r7.equals(r3)
            if (r7 != 0) goto L_0x0263
            java.lang.String r7 = "A_TRUEHD"
            boolean r7 = r7.equals(r3)
            if (r7 != 0) goto L_0x0263
            java.lang.String r7 = "A_DTS"
            boolean r7 = r7.equals(r3)
            if (r7 != 0) goto L_0x0263
            java.lang.String r7 = "A_DTS/EXPRESS"
            boolean r7 = r7.equals(r3)
            if (r7 != 0) goto L_0x0263
            java.lang.String r7 = "A_DTS/LOSSLESS"
            boolean r7 = r7.equals(r3)
            if (r7 != 0) goto L_0x0263
            java.lang.String r7 = "A_FLAC"
            boolean r7 = r7.equals(r3)
            if (r7 != 0) goto L_0x0263
            java.lang.String r7 = "A_MS/ACM"
            boolean r7 = r7.equals(r3)
            if (r7 != 0) goto L_0x0263
            java.lang.String r7 = "A_PCM/INT/LIT"
            boolean r7 = r7.equals(r3)
            if (r7 != 0) goto L_0x0263
            java.lang.String r7 = "S_TEXT/UTF8"
            boolean r7 = r7.equals(r3)
            if (r7 != 0) goto L_0x0263
            java.lang.String r7 = "S_VOBSUB"
            boolean r7 = r7.equals(r3)
            if (r7 != 0) goto L_0x0263
            java.lang.String r7 = "S_HDMV/PGS"
            boolean r7 = r7.equals(r3)
            if (r7 != 0) goto L_0x0263
            java.lang.String r7 = "S_DVBSUB"
            boolean r3 = r7.equals(r3)
            if (r3 == 0) goto L_0x0260
            goto L_0x0263
        L_0x0260:
            r2 = r9
            goto L_0x084f
        L_0x0263:
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mkv.d$c r3 = r1.t
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.h r7 = r1.Y
            int r8 = r3.b
            java.lang.String r14 = r3.a
            r14.getClass()
            r14.hashCode()
            int r15 = r14.hashCode()
            r9 = 24
            r13 = 16
            switch(r15) {
                case -2095576542: goto L_0x03e0;
                case -2095575984: goto L_0x03d4;
                case -1985379776: goto L_0x03c8;
                case -1784763192: goto L_0x03bc;
                case -1730367663: goto L_0x03b0;
                case -1482641358: goto L_0x03a4;
                case -1482641357: goto L_0x0398;
                case -1373388978: goto L_0x038c;
                case -933872740: goto L_0x037e;
                case -538363189: goto L_0x0370;
                case -538363109: goto L_0x0362;
                case -425012669: goto L_0x0354;
                case -356037306: goto L_0x0346;
                case 62923557: goto L_0x0338;
                case 62923603: goto L_0x032a;
                case 62927045: goto L_0x031c;
                case 82338133: goto L_0x0310;
                case 82338134: goto L_0x0302;
                case 99146302: goto L_0x02f4;
                case 444813526: goto L_0x02e7;
                case 542569478: goto L_0x02da;
                case 725957860: goto L_0x02cd;
                case 855502857: goto L_0x02c0;
                case 1422270023: goto L_0x02b3;
                case 1809237540: goto L_0x02a6;
                case 1950749482: goto L_0x0299;
                case 1950789798: goto L_0x028c;
                case 1951062397: goto L_0x027f;
                default: goto L_0x027c;
            }
        L_0x027c:
            r6 = -1
            goto L_0x03eb
        L_0x027f:
            java.lang.String r6 = "A_OPUS"
            boolean r6 = r14.equals(r6)
            if (r6 != 0) goto L_0x0288
            goto L_0x027c
        L_0x0288:
            r6 = 27
            goto L_0x03eb
        L_0x028c:
            java.lang.String r6 = "A_FLAC"
            boolean r6 = r14.equals(r6)
            if (r6 != 0) goto L_0x0295
            goto L_0x027c
        L_0x0295:
            r6 = 26
            goto L_0x03eb
        L_0x0299:
            java.lang.String r6 = "A_EAC3"
            boolean r6 = r14.equals(r6)
            if (r6 != 0) goto L_0x02a2
            goto L_0x027c
        L_0x02a2:
            r6 = 25
            goto L_0x03eb
        L_0x02a6:
            java.lang.String r6 = "V_MPEG2"
            boolean r6 = r14.equals(r6)
            if (r6 != 0) goto L_0x02af
            goto L_0x027c
        L_0x02af:
            r6 = 24
            goto L_0x03eb
        L_0x02b3:
            java.lang.String r6 = "S_TEXT/UTF8"
            boolean r6 = r14.equals(r6)
            if (r6 != 0) goto L_0x02bc
            goto L_0x027c
        L_0x02bc:
            r6 = 23
            goto L_0x03eb
        L_0x02c0:
            java.lang.String r6 = "V_MPEGH/ISO/HEVC"
            boolean r6 = r14.equals(r6)
            if (r6 != 0) goto L_0x02c9
            goto L_0x027c
        L_0x02c9:
            r6 = 22
            goto L_0x03eb
        L_0x02cd:
            java.lang.String r6 = "A_PCM/INT/LIT"
            boolean r6 = r14.equals(r6)
            if (r6 != 0) goto L_0x02d6
            goto L_0x027c
        L_0x02d6:
            r6 = 21
            goto L_0x03eb
        L_0x02da:
            java.lang.String r6 = "A_DTS/EXPRESS"
            boolean r6 = r14.equals(r6)
            if (r6 != 0) goto L_0x02e3
            goto L_0x027c
        L_0x02e3:
            r6 = 20
            goto L_0x03eb
        L_0x02e7:
            java.lang.String r6 = "V_THEORA"
            boolean r6 = r14.equals(r6)
            if (r6 != 0) goto L_0x02f0
            goto L_0x027c
        L_0x02f0:
            r6 = 19
            goto L_0x03eb
        L_0x02f4:
            java.lang.String r6 = "S_HDMV/PGS"
            boolean r6 = r14.equals(r6)
            if (r6 != 0) goto L_0x02fe
            goto L_0x027c
        L_0x02fe:
            r6 = 18
            goto L_0x03eb
        L_0x0302:
            java.lang.String r6 = "V_VP9"
            boolean r6 = r14.equals(r6)
            if (r6 != 0) goto L_0x030c
            goto L_0x027c
        L_0x030c:
            r6 = 17
            goto L_0x03eb
        L_0x0310:
            boolean r6 = r14.equals(r6)
            if (r6 != 0) goto L_0x0318
            goto L_0x027c
        L_0x0318:
            r6 = 16
            goto L_0x03eb
        L_0x031c:
            java.lang.String r6 = "A_DTS"
            boolean r6 = r14.equals(r6)
            if (r6 != 0) goto L_0x0326
            goto L_0x027c
        L_0x0326:
            r6 = 15
            goto L_0x03eb
        L_0x032a:
            java.lang.String r6 = "A_AC3"
            boolean r6 = r14.equals(r6)
            if (r6 != 0) goto L_0x0334
            goto L_0x027c
        L_0x0334:
            r6 = 14
            goto L_0x03eb
        L_0x0338:
            java.lang.String r6 = "A_AAC"
            boolean r6 = r14.equals(r6)
            if (r6 != 0) goto L_0x0342
            goto L_0x027c
        L_0x0342:
            r6 = 13
            goto L_0x03eb
        L_0x0346:
            java.lang.String r6 = "A_DTS/LOSSLESS"
            boolean r6 = r14.equals(r6)
            if (r6 != 0) goto L_0x0350
            goto L_0x027c
        L_0x0350:
            r6 = 12
            goto L_0x03eb
        L_0x0354:
            java.lang.String r6 = "S_VOBSUB"
            boolean r6 = r14.equals(r6)
            if (r6 != 0) goto L_0x035e
            goto L_0x027c
        L_0x035e:
            r6 = 11
            goto L_0x03eb
        L_0x0362:
            java.lang.String r6 = "V_MPEG4/ISO/AVC"
            boolean r6 = r14.equals(r6)
            if (r6 != 0) goto L_0x036c
            goto L_0x027c
        L_0x036c:
            r6 = 10
            goto L_0x03eb
        L_0x0370:
            java.lang.String r6 = "V_MPEG4/ISO/ASP"
            boolean r6 = r14.equals(r6)
            if (r6 != 0) goto L_0x037a
            goto L_0x027c
        L_0x037a:
            r6 = 9
            goto L_0x03eb
        L_0x037e:
            java.lang.String r6 = "S_DVBSUB"
            boolean r6 = r14.equals(r6)
            if (r6 != 0) goto L_0x0388
            goto L_0x027c
        L_0x0388:
            r6 = 8
            goto L_0x03eb
        L_0x038c:
            java.lang.String r6 = "V_MS/VFW/FOURCC"
            boolean r6 = r14.equals(r6)
            if (r6 != 0) goto L_0x0396
            goto L_0x027c
        L_0x0396:
            r6 = 7
            goto L_0x03eb
        L_0x0398:
            java.lang.String r6 = "A_MPEG/L3"
            boolean r6 = r14.equals(r6)
            if (r6 != 0) goto L_0x03a2
            goto L_0x027c
        L_0x03a2:
            r6 = 6
            goto L_0x03eb
        L_0x03a4:
            java.lang.String r6 = "A_MPEG/L2"
            boolean r6 = r14.equals(r6)
            if (r6 != 0) goto L_0x03ae
            goto L_0x027c
        L_0x03ae:
            r6 = 5
            goto L_0x03eb
        L_0x03b0:
            java.lang.String r6 = "A_VORBIS"
            boolean r6 = r14.equals(r6)
            if (r6 != 0) goto L_0x03ba
            goto L_0x027c
        L_0x03ba:
            r6 = 4
            goto L_0x03eb
        L_0x03bc:
            java.lang.String r6 = "A_TRUEHD"
            boolean r6 = r14.equals(r6)
            if (r6 != 0) goto L_0x03c6
            goto L_0x027c
        L_0x03c6:
            r6 = 3
            goto L_0x03eb
        L_0x03c8:
            java.lang.String r6 = "A_MS/ACM"
            boolean r6 = r14.equals(r6)
            if (r6 != 0) goto L_0x03d2
            goto L_0x027c
        L_0x03d2:
            r6 = 2
            goto L_0x03eb
        L_0x03d4:
            java.lang.String r6 = "V_MPEG4/ISO/SP"
            boolean r6 = r14.equals(r6)
            if (r6 != 0) goto L_0x03de
            goto L_0x027c
        L_0x03de:
            r6 = 1
            goto L_0x03eb
        L_0x03e0:
            java.lang.String r6 = "V_MPEG4/ISO/AP"
            boolean r6 = r14.equals(r6)
            if (r6 != 0) goto L_0x03ea
            goto L_0x027c
        L_0x03ea:
            r6 = 0
        L_0x03eb:
            java.lang.String r14 = "audio/x-unknown"
            java.lang.String r15 = "MatroskaExtractor"
            switch(r6) {
                case 0: goto L_0x066c;
                case 1: goto L_0x066c;
                case 2: goto L_0x0605;
                case 3: goto L_0x0600;
                case 4: goto L_0x0589;
                case 5: goto L_0x057e;
                case 6: goto L_0x057b;
                case 7: goto L_0x04f9;
                case 8: goto L_0x04dc;
                case 9: goto L_0x066c;
                case 10: goto L_0x04c1;
                case 11: goto L_0x04b8;
                case 12: goto L_0x04b4;
                case 13: goto L_0x04ab;
                case 14: goto L_0x04a7;
                case 15: goto L_0x04a3;
                case 16: goto L_0x049f;
                case 17: goto L_0x049b;
                case 18: goto L_0x0497;
                case 19: goto L_0x0493;
                case 20: goto L_0x04a3;
                case 21: goto L_0x046b;
                case 22: goto L_0x0457;
                case 23: goto L_0x0453;
                case 24: goto L_0x044f;
                case 25: goto L_0x044b;
                case 26: goto L_0x0441;
                case 27: goto L_0x03fa;
                default: goto L_0x03f2;
            }
        L_0x03f2:
            com.fyber.inneractive.sdk.player.exoplayer2.l r1 = new com.fyber.inneractive.sdk.player.exoplayer2.l
            java.lang.String r2 = "Unrecognized codec identifier."
            r1.<init>((java.lang.String) r2)
            throw r1
        L_0x03fa:
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>(r11)
            byte[] r6 = r3.h
            r2.add(r6)
            r6 = 8
            java.nio.ByteBuffer r9 = java.nio.ByteBuffer.allocate(r6)
            java.nio.ByteOrder r10 = java.nio.ByteOrder.nativeOrder()
            java.nio.ByteBuffer r9 = r9.order(r10)
            long r13 = r3.J
            java.nio.ByteBuffer r9 = r9.putLong(r13)
            byte[] r9 = r9.array()
            r2.add(r9)
            java.nio.ByteBuffer r6 = java.nio.ByteBuffer.allocate(r6)
            java.nio.ByteOrder r9 = java.nio.ByteOrder.nativeOrder()
            java.nio.ByteBuffer r6 = r6.order(r9)
            long r9 = r3.K
            java.nio.ByteBuffer r6 = r6.putLong(r9)
            byte[] r6 = r6.array()
            r2.add(r6)
            java.lang.String r6 = "audio/opus"
            r9 = 5760(0x1680, float:8.071E-42)
            r13 = r2
            r22 = 5760(0x1680, float:8.071E-42)
            goto L_0x0585
        L_0x0441:
            byte[] r2 = r3.h
            java.util.List r2 = java.util.Collections.singletonList(r2)
            java.lang.String r6 = "audio/flac"
            goto L_0x04f6
        L_0x044b:
            java.lang.String r14 = "audio/eac3"
            goto L_0x0602
        L_0x044f:
            java.lang.String r14 = "video/mpeg2"
            goto L_0x0602
        L_0x0453:
            java.lang.String r14 = "application/x-subrip"
            goto L_0x0602
        L_0x0457:
            com.fyber.inneractive.sdk.player.exoplayer2.util.k r2 = new com.fyber.inneractive.sdk.player.exoplayer2.util.k
            byte[] r6 = r3.h
            r2.<init>((byte[]) r6)
            com.fyber.inneractive.sdk.player.exoplayer2.video.c r2 = com.fyber.inneractive.sdk.player.exoplayer2.video.c.a(r2)
            java.util.List<byte[]> r6 = r2.a
            int r2 = r2.b
            r3.P = r2
            java.lang.String r2 = "video/hevc"
            goto L_0x04d4
        L_0x046b:
            int r2 = r3.H
            int r2 = com.fyber.inneractive.sdk.player.exoplayer2.util.u.a((int) r2)
            if (r2 != 0) goto L_0x048d
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r6 = "Unsupported PCM bit depth: "
            r2.<init>(r6)
            int r6 = r3.H
            r2.append(r6)
            java.lang.String r6 = ". Setting mimeType to audio/x-unknown"
            r2.append(r6)
            java.lang.String r2 = r2.toString()
            android.util.Log.w(r15, r2)
            goto L_0x0602
        L_0x048d:
            java.lang.String r6 = "audio/raw"
            r4 = r2
            r2 = 0
            goto L_0x067b
        L_0x0493:
            java.lang.String r14 = "video/x-unknown"
            goto L_0x0602
        L_0x0497:
            java.lang.String r14 = "application/pgs"
            goto L_0x0602
        L_0x049b:
            java.lang.String r14 = "video/x-vnd.on2.vp9"
            goto L_0x0602
        L_0x049f:
            java.lang.String r14 = "video/x-vnd.on2.vp8"
            goto L_0x0602
        L_0x04a3:
            java.lang.String r14 = "audio/vnd.dts"
            goto L_0x0602
        L_0x04a7:
            java.lang.String r14 = "audio/ac3"
            goto L_0x0602
        L_0x04ab:
            byte[] r2 = r3.h
            java.util.List r2 = java.util.Collections.singletonList(r2)
            java.lang.String r6 = "audio/mp4a-latm"
            goto L_0x04f6
        L_0x04b4:
            java.lang.String r14 = "audio/vnd.dts.hd"
            goto L_0x0602
        L_0x04b8:
            byte[] r2 = r3.h
            java.util.List r2 = java.util.Collections.singletonList(r2)
            java.lang.String r6 = "application/vobsub"
            goto L_0x04f6
        L_0x04c1:
            com.fyber.inneractive.sdk.player.exoplayer2.util.k r2 = new com.fyber.inneractive.sdk.player.exoplayer2.util.k
            byte[] r6 = r3.h
            r2.<init>((byte[]) r6)
            com.fyber.inneractive.sdk.player.exoplayer2.video.a r2 = com.fyber.inneractive.sdk.player.exoplayer2.video.a.b(r2)
            java.util.List<byte[]> r6 = r2.a
            int r2 = r2.b
            r3.P = r2
            java.lang.String r2 = "video/avc"
        L_0x04d4:
            r4 = -1
            r33 = r6
            r6 = r2
            r2 = r33
            goto L_0x067b
        L_0x04dc:
            byte[] r2 = new byte[r10]
            byte[] r6 = r3.h
            byte r9 = r6[r4]
            r2[r4] = r9
            byte r9 = r6[r5]
            r2[r5] = r9
            byte r9 = r6[r12]
            r2[r12] = r9
            byte r6 = r6[r11]
            r2[r11] = r6
            java.util.List r2 = java.util.Collections.singletonList(r2)
            java.lang.String r6 = "application/dvbsubs"
        L_0x04f6:
            r4 = -1
            goto L_0x067b
        L_0x04f9:
            byte[] r2 = r3.h
            int r6 = r2.length
            if (r13 > r6) goto L_0x0500
            r6 = 1
            goto L_0x0501
        L_0x0500:
            r6 = 0
        L_0x0501:
            com.fyber.inneractive.sdk.player.exoplayer2.util.a.a((boolean) r6)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0573 }
            byte r6 = r2[r13]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0573 }
            long r11 = (long) r6     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0573 }
            r16 = 255(0xff, double:1.26E-321)
            long r11 = r11 & r16
            r6 = 17
            byte r6 = r2[r6]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0573 }
            long r4 = (long) r6     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0573 }
            long r4 = r4 & r16
            r6 = 8
            long r4 = r4 << r6
            long r4 = r4 | r11
            r6 = 18
            byte r6 = r2[r6]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0573 }
            long r11 = (long) r6     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0573 }
            long r11 = r11 & r16
            long r11 = r11 << r13
            long r4 = r4 | r11
            r6 = 19
            byte r6 = r2[r6]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0573 }
            long r11 = (long) r6     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0573 }
            long r11 = r11 & r16
            long r11 = r11 << r9
            long r4 = r4 | r11
            r11 = 826496599(0x31435657, double:4.08343576E-315)
            int r6 = (r4 > r11 ? 1 : (r4 == r11 ? 0 : -1))
            if (r6 == 0) goto L_0x0531
            r2 = 0
            goto L_0x0559
        L_0x0531:
            r4 = 40
        L_0x0533:
            int r5 = r2.length     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0573 }
            int r5 = r5 - r10
            if (r4 >= r5) goto L_0x056b
            byte r5 = r2[r4]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0573 }
            if (r5 != 0) goto L_0x0568
            int r5 = r4 + 1
            byte r5 = r2[r5]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0573 }
            if (r5 != 0) goto L_0x0568
            int r5 = r4 + 2
            byte r5 = r2[r5]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0573 }
            r6 = 1
            if (r5 != r6) goto L_0x0568
            int r5 = r4 + 3
            byte r5 = r2[r5]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0573 }
            r6 = 15
            if (r5 != r6) goto L_0x0568
            int r5 = r2.length     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0573 }
            byte[] r2 = java.util.Arrays.copyOfRange(r2, r4, r5)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0573 }
            java.util.List r2 = java.util.Collections.singletonList(r2)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0573 }
        L_0x0559:
            if (r2 == 0) goto L_0x055f
            java.lang.String r14 = "video/wvc1"
            goto L_0x0603
        L_0x055f:
            java.lang.String r4 = "Unsupported FourCC. Setting mimeType to video/x-unknown"
            android.util.Log.w(r15, r4)
            java.lang.String r14 = "video/x-unknown"
            goto L_0x0603
        L_0x0568:
            int r4 = r4 + 1
            goto L_0x0533
        L_0x056b:
            com.fyber.inneractive.sdk.player.exoplayer2.l r1 = new com.fyber.inneractive.sdk.player.exoplayer2.l     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0573 }
            java.lang.String r2 = "Failed to find FourCC VC1 initialization data"
            r1.<init>((java.lang.String) r2)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0573 }
            throw r1     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0573 }
        L_0x0573:
            com.fyber.inneractive.sdk.player.exoplayer2.l r1 = new com.fyber.inneractive.sdk.player.exoplayer2.l
            java.lang.String r2 = "Error parsing FourCC VC1 codec private"
            r1.<init>((java.lang.String) r2)
            throw r1
        L_0x057b:
            java.lang.String r6 = "audio/mpeg"
            goto L_0x0580
        L_0x057e:
            java.lang.String r6 = "audio/mpeg-L2"
        L_0x0580:
            r2 = 4096(0x1000, float:5.74E-42)
            r13 = 0
            r22 = 4096(0x1000, float:5.74E-42)
        L_0x0585:
            r25 = -1
            goto L_0x0680
        L_0x0589:
            byte[] r4 = r3.h
            r5 = 0
            byte r6 = r4[r5]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x05fa }
            r5 = 2
            if (r6 != r5) goto L_0x05f4
            r5 = 0
            r6 = 1
        L_0x0593:
            byte r9 = r4[r6]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x05fa }
            r10 = -1
            if (r9 != r10) goto L_0x059d
            int r5 = r5 + 255
            int r6 = r6 + 1
            goto L_0x0593
        L_0x059d:
            r10 = 1
            int r6 = r6 + r10
            int r5 = r5 + r9
            r9 = 0
        L_0x05a1:
            byte r10 = r4[r6]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x05fa }
            r11 = -1
            if (r10 != r11) goto L_0x05ab
            int r9 = r9 + 255
            int r6 = r6 + 1
            goto L_0x05a1
        L_0x05ab:
            r11 = 1
            int r6 = r6 + r11
            int r9 = r9 + r10
            byte r10 = r4[r6]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x05fa }
            if (r10 != r11) goto L_0x05ee
            byte[] r10 = new byte[r5]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x05fa }
            r11 = 0
            java.lang.System.arraycopy(r4, r6, r10, r11, r5)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x05fa }
            int r6 = r6 + r5
            byte r5 = r4[r6]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x05fa }
            r11 = 3
            if (r5 != r11) goto L_0x05e8
            int r6 = r6 + r9
            byte r5 = r4[r6]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x05fa }
            r9 = 5
            if (r5 != r9) goto L_0x05e2
            int r5 = r4.length     // Catch:{ ArrayIndexOutOfBoundsException -> 0x05fa }
            int r5 = r5 - r6
            byte[] r5 = new byte[r5]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x05fa }
            int r9 = r4.length     // Catch:{ ArrayIndexOutOfBoundsException -> 0x05fa }
            int r9 = r9 - r6
            r11 = 0
            java.lang.System.arraycopy(r4, r6, r5, r11, r9)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x05fa }
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ ArrayIndexOutOfBoundsException -> 0x05fa }
            r6 = 2
            r4.<init>(r6)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x05fa }
            r4.add(r10)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x05fa }
            r4.add(r5)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x05fa }
            java.lang.String r6 = "audio/vorbis"
            r2 = 8192(0x2000, float:1.14794E-41)
            r13 = r4
            r22 = 8192(0x2000, float:1.14794E-41)
            goto L_0x0585
        L_0x05e2:
            com.fyber.inneractive.sdk.player.exoplayer2.l r1 = new com.fyber.inneractive.sdk.player.exoplayer2.l     // Catch:{ ArrayIndexOutOfBoundsException -> 0x05fa }
            r1.<init>((java.lang.String) r2)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x05fa }
            throw r1     // Catch:{ ArrayIndexOutOfBoundsException -> 0x05fa }
        L_0x05e8:
            com.fyber.inneractive.sdk.player.exoplayer2.l r1 = new com.fyber.inneractive.sdk.player.exoplayer2.l     // Catch:{ ArrayIndexOutOfBoundsException -> 0x05fa }
            r1.<init>((java.lang.String) r2)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x05fa }
            throw r1     // Catch:{ ArrayIndexOutOfBoundsException -> 0x05fa }
        L_0x05ee:
            com.fyber.inneractive.sdk.player.exoplayer2.l r1 = new com.fyber.inneractive.sdk.player.exoplayer2.l     // Catch:{ ArrayIndexOutOfBoundsException -> 0x05fa }
            r1.<init>((java.lang.String) r2)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x05fa }
            throw r1     // Catch:{ ArrayIndexOutOfBoundsException -> 0x05fa }
        L_0x05f4:
            com.fyber.inneractive.sdk.player.exoplayer2.l r1 = new com.fyber.inneractive.sdk.player.exoplayer2.l     // Catch:{ ArrayIndexOutOfBoundsException -> 0x05fa }
            r1.<init>((java.lang.String) r2)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x05fa }
            throw r1     // Catch:{ ArrayIndexOutOfBoundsException -> 0x05fa }
        L_0x05fa:
            com.fyber.inneractive.sdk.player.exoplayer2.l r1 = new com.fyber.inneractive.sdk.player.exoplayer2.l
            r1.<init>((java.lang.String) r2)
            throw r1
        L_0x0600:
            java.lang.String r14 = "audio/true-hd"
        L_0x0602:
            r2 = 0
        L_0x0603:
            r4 = -1
            goto L_0x0662
        L_0x0605:
            com.fyber.inneractive.sdk.player.exoplayer2.util.k r2 = new com.fyber.inneractive.sdk.player.exoplayer2.util.k
            byte[] r4 = r3.h
            r2.<init>((byte[]) r4)
            int r4 = r2.h()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0664 }
            r5 = 1
            if (r4 != r5) goto L_0x0614
            goto L_0x0636
        L_0x0614:
            r5 = 65534(0xfffe, float:9.1833E-41)
            if (r4 != r5) goto L_0x065c
            r2.e(r9)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0664 }
            long r4 = r2.i()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0664 }
            java.util.UUID r6 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mkv.d.b0     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0664 }
            long r9 = r6.getMostSignificantBits()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0664 }
            int r11 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
            if (r11 != 0) goto L_0x065c
            long r4 = r2.i()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0664 }
            long r9 = r6.getLeastSignificantBits()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0664 }
            int r2 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
            if (r2 != 0) goto L_0x065c
        L_0x0636:
            int r2 = r3.H
            int r2 = com.fyber.inneractive.sdk.player.exoplayer2.util.u.a((int) r2)
            if (r2 != 0) goto L_0x0657
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r4 = "Unsupported PCM bit depth: "
            r2.<init>(r4)
            int r4 = r3.H
            r2.append(r4)
            java.lang.String r4 = ". Setting mimeType to audio/x-unknown"
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            android.util.Log.w(r15, r2)
            goto L_0x0602
        L_0x0657:
            java.lang.String r14 = "audio/raw"
            r4 = r2
            r2 = 0
            goto L_0x0662
        L_0x065c:
            java.lang.String r2 = "Non-PCM MS/ACM is unsupported. Setting mimeType to audio/x-unknown"
            android.util.Log.w(r15, r2)
            goto L_0x0602
        L_0x0662:
            r6 = r14
            goto L_0x067b
        L_0x0664:
            com.fyber.inneractive.sdk.player.exoplayer2.l r1 = new com.fyber.inneractive.sdk.player.exoplayer2.l
            java.lang.String r2 = "Error parsing MS/ACM codec private"
            r1.<init>((java.lang.String) r2)
            throw r1
        L_0x066c:
            byte[] r2 = r3.h
            if (r2 != 0) goto L_0x0672
            r2 = 0
            goto L_0x0676
        L_0x0672:
            java.util.List r2 = java.util.Collections.singletonList(r2)
        L_0x0676:
            java.lang.String r4 = "video/mp4v-es"
            r6 = r4
            goto L_0x04f6
        L_0x067b:
            r13 = r2
            r25 = r4
            r22 = -1
        L_0x0680:
            boolean r2 = r3.M
            boolean r4 = r3.L
            if (r4 == 0) goto L_0x0688
            r4 = 2
            goto L_0x0689
        L_0x0688:
            r4 = 0
        L_0x0689:
            r2 = r2 | r4
            boolean r4 = com.fyber.inneractive.sdk.player.exoplayer2.util.h.d(r6)
            if (r4 == 0) goto L_0x06b5
            java.lang.String r18 = java.lang.Integer.toString(r8)
            int r4 = r3.G
            int r5 = r3.I
            com.fyber.inneractive.sdk.player.exoplayer2.drm.a r8 = r3.i
            java.lang.String r9 = r3.N
            r20 = 0
            r21 = -1
            r19 = r6
            r23 = r4
            r24 = r5
            r26 = r13
            r27 = r8
            r28 = r2
            r29 = r9
            com.fyber.inneractive.sdk.player.exoplayer2.i r2 = com.fyber.inneractive.sdk.player.exoplayer2.i.a((java.lang.String) r18, (java.lang.String) r19, (java.lang.String) r20, (int) r21, (int) r22, (int) r23, (int) r24, (int) r25, (java.util.List<byte[]>) r26, (com.fyber.inneractive.sdk.player.exoplayer2.drm.a) r27, (int) r28, (java.lang.String) r29)
            r11 = 1
            goto L_0x083a
        L_0x06b5:
            boolean r4 = com.fyber.inneractive.sdk.player.exoplayer2.util.h.e(r6)
            if (r4 == 0) goto L_0x07e7
            int r2 = r3.n
            if (r2 != 0) goto L_0x06d1
            int r2 = r3.l
            r4 = -1
            if (r2 != r4) goto L_0x06c6
            int r2 = r3.j
        L_0x06c6:
            r3.l = r2
            int r2 = r3.m
            if (r2 != r4) goto L_0x06ce
            int r2 = r3.k
        L_0x06ce:
            r3.m = r2
            goto L_0x06d2
        L_0x06d1:
            r4 = -1
        L_0x06d2:
            int r2 = r3.l
            r5 = -1082130432(0xffffffffbf800000, float:-1.0)
            if (r2 == r4) goto L_0x06ea
            int r9 = r3.m
            if (r9 == r4) goto L_0x06ea
            int r4 = r3.k
            int r4 = r4 * r2
            float r2 = (float) r4
            int r4 = r3.j
            int r4 = r4 * r9
            float r4 = (float) r4
            float r2 = r2 / r4
            r28 = r2
            goto L_0x06ec
        L_0x06ea:
            r28 = -1082130432(0xffffffffbf800000, float:-1.0)
        L_0x06ec:
            boolean r2 = r3.q
            if (r2 == 0) goto L_0x07bb
            float r2 = r3.w
            int r2 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r2 == 0) goto L_0x07ac
            float r2 = r3.x
            int r2 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r2 == 0) goto L_0x07ac
            float r2 = r3.y
            int r2 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r2 == 0) goto L_0x07ac
            float r2 = r3.z
            int r2 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r2 == 0) goto L_0x07ac
            float r2 = r3.A
            int r2 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r2 == 0) goto L_0x07ac
            float r2 = r3.B
            int r2 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r2 == 0) goto L_0x07ac
            float r2 = r3.C
            int r2 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r2 == 0) goto L_0x07ac
            float r2 = r3.D
            int r2 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r2 == 0) goto L_0x07ac
            float r2 = r3.E
            int r2 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r2 == 0) goto L_0x07ac
            float r2 = r3.F
            int r2 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r2 != 0) goto L_0x072e
            goto L_0x07ac
        L_0x072e:
            r2 = 25
            byte[] r2 = new byte[r2]
            java.nio.ByteBuffer r4 = java.nio.ByteBuffer.wrap(r2)
            r5 = 0
            r4.put(r5)
            float r5 = r3.w
            r9 = 1195593728(0x47435000, float:50000.0)
            float r5 = r5 * r9
            r10 = 1056964608(0x3f000000, float:0.5)
            float r5 = r5 + r10
            int r5 = (int) r5
            short r5 = (short) r5
            r4.putShort(r5)
            float r5 = r3.x
            float r5 = r5 * r9
            float r5 = r5 + r10
            int r5 = (int) r5
            short r5 = (short) r5
            r4.putShort(r5)
            float r5 = r3.y
            float r5 = r5 * r9
            float r5 = r5 + r10
            int r5 = (int) r5
            short r5 = (short) r5
            r4.putShort(r5)
            float r5 = r3.z
            float r5 = r5 * r9
            float r5 = r5 + r10
            int r5 = (int) r5
            short r5 = (short) r5
            r4.putShort(r5)
            float r5 = r3.A
            float r5 = r5 * r9
            float r5 = r5 + r10
            int r5 = (int) r5
            short r5 = (short) r5
            r4.putShort(r5)
            float r5 = r3.B
            float r5 = r5 * r9
            float r5 = r5 + r10
            int r5 = (int) r5
            short r5 = (short) r5
            r4.putShort(r5)
            float r5 = r3.C
            float r5 = r5 * r9
            float r5 = r5 + r10
            int r5 = (int) r5
            short r5 = (short) r5
            r4.putShort(r5)
            float r5 = r3.D
            float r5 = r5 * r9
            float r5 = r5 + r10
            int r5 = (int) r5
            short r5 = (short) r5
            r4.putShort(r5)
            float r5 = r3.E
            float r5 = r5 + r10
            int r5 = (int) r5
            short r5 = (short) r5
            r4.putShort(r5)
            float r5 = r3.F
            float r5 = r5 + r10
            int r5 = (int) r5
            short r5 = (short) r5
            r4.putShort(r5)
            int r5 = r3.u
            short r5 = (short) r5
            r4.putShort(r5)
            int r5 = r3.v
            short r5 = (short) r5
            r4.putShort(r5)
            goto L_0x07ad
        L_0x07ac:
            r2 = 0
        L_0x07ad:
            com.fyber.inneractive.sdk.player.exoplayer2.video.b r4 = new com.fyber.inneractive.sdk.player.exoplayer2.video.b
            int r5 = r3.r
            int r9 = r3.t
            int r10 = r3.s
            r4.<init>(r5, r9, r10, r2)
            r31 = r4
            goto L_0x07bd
        L_0x07bb:
            r31 = 0
        L_0x07bd:
            java.lang.String r18 = java.lang.Integer.toString(r8)
            int r2 = r3.j
            int r4 = r3.k
            byte[] r5 = r3.o
            int r8 = r3.p
            com.fyber.inneractive.sdk.player.exoplayer2.drm.a r9 = r3.i
            r20 = 0
            r21 = -1
            r25 = -1082130432(0xffffffffbf800000, float:-1.0)
            r27 = -1
            r19 = r6
            r23 = r2
            r24 = r4
            r26 = r13
            r29 = r5
            r30 = r8
            r32 = r9
            com.fyber.inneractive.sdk.player.exoplayer2.i r2 = com.fyber.inneractive.sdk.player.exoplayer2.i.a((java.lang.String) r18, (java.lang.String) r19, (java.lang.String) r20, (int) r21, (int) r22, (int) r23, (int) r24, (float) r25, (java.util.List<byte[]>) r26, (int) r27, (float) r28, (byte[]) r29, (int) r30, (com.fyber.inneractive.sdk.player.exoplayer2.video.b) r31, (com.fyber.inneractive.sdk.player.exoplayer2.drm.a) r32)
            r11 = 2
            goto L_0x083a
        L_0x07e7:
            java.lang.String r4 = "application/x-subrip"
            boolean r4 = r4.equals(r6)
            if (r4 == 0) goto L_0x0809
            java.lang.String r18 = java.lang.Integer.toString(r8)
            java.lang.String r4 = r3.N
            com.fyber.inneractive.sdk.player.exoplayer2.drm.a r5 = r3.i
            r20 = 0
            r21 = -1
            r19 = r6
            r22 = r2
            r23 = r4
            r24 = r5
            com.fyber.inneractive.sdk.player.exoplayer2.i r2 = com.fyber.inneractive.sdk.player.exoplayer2.i.a((java.lang.String) r18, (java.lang.String) r19, (java.lang.String) r20, (int) r21, (int) r22, (java.lang.String) r23, (com.fyber.inneractive.sdk.player.exoplayer2.drm.a) r24)
        L_0x0807:
            r11 = 3
            goto L_0x083a
        L_0x0809:
            java.lang.String r2 = "application/vobsub"
            boolean r2 = r2.equals(r6)
            if (r2 != 0) goto L_0x082a
            java.lang.String r2 = "application/pgs"
            boolean r2 = r2.equals(r6)
            if (r2 != 0) goto L_0x082a
            java.lang.String r2 = "application/dvbsubs"
            boolean r2 = r2.equals(r6)
            if (r2 == 0) goto L_0x0822
            goto L_0x082a
        L_0x0822:
            com.fyber.inneractive.sdk.player.exoplayer2.l r1 = new com.fyber.inneractive.sdk.player.exoplayer2.l
            java.lang.String r2 = "Unexpected MIME type."
            r1.<init>((java.lang.String) r2)
            throw r1
        L_0x082a:
            java.lang.String r9 = java.lang.Integer.toString(r8)
            java.lang.String r14 = r3.N
            com.fyber.inneractive.sdk.player.exoplayer2.drm.a r15 = r3.i
            r11 = 0
            r12 = -1
            r10 = r6
            com.fyber.inneractive.sdk.player.exoplayer2.i r2 = com.fyber.inneractive.sdk.player.exoplayer2.i.a((java.lang.String) r9, (java.lang.String) r10, (java.lang.String) r11, (int) r12, (java.util.List<byte[]>) r13, (java.lang.String) r14, (com.fyber.inneractive.sdk.player.exoplayer2.drm.a) r15)
            goto L_0x0807
        L_0x083a:
            int r4 = r3.b
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.n r4 = r7.a(r4, r11)
            r3.O = r4
            r4.a(r2)
            android.util.SparseArray<com.fyber.inneractive.sdk.player.exoplayer2.extractor.mkv.d$c> r2 = r1.c
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mkv.d$c r3 = r1.t
            int r4 = r3.b
            r2.put(r4, r3)
            r2 = 0
        L_0x084f:
            r1.t = r2
            goto L_0x0161
        L_0x0853:
            int r2 = r1.E
            r3 = 2
            if (r2 == r3) goto L_0x085a
            goto L_0x0161
        L_0x085a:
            boolean r2 = r1.X
            if (r2 != 0) goto L_0x0864
            int r2 = r1.M
            r3 = 1
            r2 = r2 | r3
            r1.M = r2
        L_0x0864:
            android.util.SparseArray<com.fyber.inneractive.sdk.player.exoplayer2.extractor.mkv.d$c> r2 = r1.c
            int r3 = r1.K
            java.lang.Object r2 = r2.get(r3)
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mkv.d$c r2 = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.mkv.d.c) r2
            long r3 = r1.F
            r1.a((com.fyber.inneractive.sdk.player.exoplayer2.extractor.mkv.d.c) r2, (long) r3)
            r3 = 0
            r1.E = r3
            goto L_0x0161
        L_0x0878:
            return r4
        L_0x0879:
            r3 = 0
            r4 = 1
            int r5 = r0.e
            if (r5 != 0) goto L_0x08cc
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mkv.f r5 = r0.c
            long r8 = r5.a(r1, r4, r3, r10)
            r4 = -2
            int r11 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r11 != 0) goto L_0x08be
            r4 = r1
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.b r4 = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) r4
            r4.e = r3
        L_0x0890:
            byte[] r5 = r0.a
            r4.a(r5, r3, r10, r3)
            byte[] r5 = r0.a
            byte r5 = r5[r3]
            int r5 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mkv.f.a(r5)
            r11 = -1
            if (r5 == r11) goto L_0x08b8
            if (r5 > r10) goto L_0x08b8
            byte[] r8 = r0.a
            long r8 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mkv.f.a(r8, r5, r3)
            int r3 = (int) r8
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mkv.c r8 = r0.d
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mkv.d$b r8 = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.mkv.d.b) r8
            boolean r8 = r8.a(r3)
            if (r8 == 0) goto L_0x08b8
            r4.c(r5)
            long r8 = (long) r3
            goto L_0x08be
        L_0x08b8:
            r3 = 1
            r4.c(r3)
            r3 = 0
            goto L_0x0890
        L_0x08be:
            r3 = 1
            int r4 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r4 != 0) goto L_0x08c5
            r4 = 0
            return r4
        L_0x08c5:
            r4 = 0
            int r5 = (int) r8
            r0.f = r5
            r0.e = r3
            goto L_0x08ce
        L_0x08cc:
            r3 = 1
            r4 = 0
        L_0x08ce:
            int r5 = r0.e
            if (r5 != r3) goto L_0x08df
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mkv.f r5 = r0.c
            r6 = 8
            long r5 = r5.a(r1, r4, r3, r6)
            r0.g = r5
            r3 = 2
            r0.e = r3
        L_0x08df:
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mkv.c r3 = r0.d
            int r4 = r0.f
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mkv.d$b r3 = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.mkv.d.b) r3
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mkv.d r3 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mkv.d.this
            r3.getClass()
            switch(r4) {
                case 131: goto L_0x08f7;
                case 134: goto L_0x08f5;
                case 136: goto L_0x08f7;
                case 155: goto L_0x08f7;
                case 159: goto L_0x08f7;
                case 160: goto L_0x08f3;
                case 161: goto L_0x08f1;
                case 163: goto L_0x08f1;
                case 174: goto L_0x08f3;
                case 176: goto L_0x08f7;
                case 179: goto L_0x08f7;
                case 181: goto L_0x08ef;
                case 183: goto L_0x08f3;
                case 186: goto L_0x08f7;
                case 187: goto L_0x08f3;
                case 215: goto L_0x08f7;
                case 224: goto L_0x08f3;
                case 225: goto L_0x08f3;
                case 231: goto L_0x08f7;
                case 241: goto L_0x08f7;
                case 251: goto L_0x08f7;
                case 16980: goto L_0x08f7;
                case 16981: goto L_0x08f1;
                case 17026: goto L_0x08f5;
                case 17029: goto L_0x08f7;
                case 17143: goto L_0x08f7;
                case 17545: goto L_0x08ef;
                case 18401: goto L_0x08f7;
                case 18402: goto L_0x08f1;
                case 18407: goto L_0x08f3;
                case 18408: goto L_0x08f7;
                case 19899: goto L_0x08f3;
                case 20529: goto L_0x08f7;
                case 20530: goto L_0x08f7;
                case 20532: goto L_0x08f3;
                case 20533: goto L_0x08f3;
                case 21419: goto L_0x08f1;
                case 21420: goto L_0x08f7;
                case 21432: goto L_0x08f7;
                case 21680: goto L_0x08f7;
                case 21682: goto L_0x08f7;
                case 21690: goto L_0x08f7;
                case 21930: goto L_0x08f7;
                case 21936: goto L_0x08f3;
                case 21945: goto L_0x08f7;
                case 21946: goto L_0x08f7;
                case 21947: goto L_0x08f7;
                case 21948: goto L_0x08f7;
                case 21949: goto L_0x08f7;
                case 21968: goto L_0x08f3;
                case 21969: goto L_0x08ef;
                case 21970: goto L_0x08ef;
                case 21971: goto L_0x08ef;
                case 21972: goto L_0x08ef;
                case 21973: goto L_0x08ef;
                case 21974: goto L_0x08ef;
                case 21975: goto L_0x08ef;
                case 21976: goto L_0x08ef;
                case 21977: goto L_0x08ef;
                case 21978: goto L_0x08ef;
                case 22186: goto L_0x08f7;
                case 22203: goto L_0x08f7;
                case 25152: goto L_0x08f3;
                case 25188: goto L_0x08f7;
                case 25506: goto L_0x08f1;
                case 28032: goto L_0x08f3;
                case 30320: goto L_0x08f3;
                case 30322: goto L_0x08f1;
                case 2274716: goto L_0x08f5;
                case 2352003: goto L_0x08f7;
                case 2807729: goto L_0x08f7;
                case 290298740: goto L_0x08f3;
                case 357149030: goto L_0x08f3;
                case 374648427: goto L_0x08f3;
                case 408125543: goto L_0x08f3;
                case 440786851: goto L_0x08f3;
                case 475249515: goto L_0x08f3;
                case 524531317: goto L_0x08f3;
                default: goto L_0x08ed;
            }
        L_0x08ed:
            r3 = 0
            goto L_0x08f8
        L_0x08ef:
            r3 = 5
            goto L_0x08f8
        L_0x08f1:
            r3 = 4
            goto L_0x08f8
        L_0x08f3:
            r3 = 1
            goto L_0x08f8
        L_0x08f5:
            r3 = 3
            goto L_0x08f8
        L_0x08f7:
            r3 = 2
        L_0x08f8:
            if (r3 == 0) goto L_0x09e9
            r4 = 1
            if (r3 == r4) goto L_0x09c5
            r2 = 2
            if (r3 == r2) goto L_0x0995
            r2 = 3
            if (r3 == r2) goto L_0x0964
            if (r3 == r10) goto L_0x0954
            r2 = 5
            if (r3 != r2) goto L_0x0940
            long r2 = r0.g
            r4 = 4
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 == 0) goto L_0x092d
            r4 = 8
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 != 0) goto L_0x0917
            goto L_0x092d
        L_0x0917:
            com.fyber.inneractive.sdk.player.exoplayer2.l r1 = new com.fyber.inneractive.sdk.player.exoplayer2.l
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Invalid float size: "
            r2.<init>(r3)
            long r3 = r0.g
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>((java.lang.String) r2)
            throw r1
        L_0x092d:
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mkv.c r4 = r0.d
            int r5 = r0.f
            int r3 = (int) r2
            double r1 = r0.a(r1, r3)
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mkv.d$b r4 = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.mkv.d.b) r4
            r4.a((int) r5, (double) r1)
            r1 = 0
            r0.e = r1
        L_0x093e:
            r1 = 1
            return r1
        L_0x0940:
            com.fyber.inneractive.sdk.player.exoplayer2.l r1 = new com.fyber.inneractive.sdk.player.exoplayer2.l
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r4 = "Invalid element type "
            r2.<init>(r4)
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>((java.lang.String) r2)
            throw r1
        L_0x0954:
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mkv.c r2 = r0.d
            int r3 = r0.f
            long r4 = r0.g
            int r5 = (int) r4
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mkv.d$b r2 = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.mkv.d.b) r2
            r2.a((int) r3, (int) r5, (com.fyber.inneractive.sdk.player.exoplayer2.extractor.g) r1)
            r1 = 0
            r0.e = r1
            goto L_0x093e
        L_0x0964:
            long r2 = r0.g
            r4 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 > 0) goto L_0x097f
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mkv.c r4 = r0.d
            int r5 = r0.f
            int r3 = (int) r2
            java.lang.String r1 = r0.c(r1, r3)
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mkv.d$b r4 = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.mkv.d.b) r4
            r4.a((int) r5, (java.lang.String) r1)
            r1 = 0
            r0.e = r1
            goto L_0x093e
        L_0x097f:
            com.fyber.inneractive.sdk.player.exoplayer2.l r1 = new com.fyber.inneractive.sdk.player.exoplayer2.l
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "String element size: "
            r2.<init>(r3)
            long r3 = r0.g
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>((java.lang.String) r2)
            throw r1
        L_0x0995:
            long r2 = r0.g
            r4 = 8
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 > 0) goto L_0x09af
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mkv.c r4 = r0.d
            int r5 = r0.f
            int r3 = (int) r2
            long r1 = r0.b(r1, r3)
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mkv.d$b r4 = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.mkv.d.b) r4
            r4.a((int) r5, (long) r1)
            r1 = 0
            r0.e = r1
            goto L_0x093e
        L_0x09af:
            com.fyber.inneractive.sdk.player.exoplayer2.l r1 = new com.fyber.inneractive.sdk.player.exoplayer2.l
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Invalid integer size: "
            r2.<init>(r3)
            long r3 = r0.g
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>((java.lang.String) r2)
            throw r1
        L_0x09c5:
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.b r1 = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) r1
            long r4 = r1.c
            long r1 = r0.g
            long r1 = r1 + r4
            java.util.Stack<com.fyber.inneractive.sdk.player.exoplayer2.extractor.mkv.a$a> r3 = r0.b
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mkv.a$a r6 = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.mkv.a$a
            int r7 = r0.f
            r6.<init>(r7, r1)
            r3.add(r6)
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mkv.c r1 = r0.d
            int r3 = r0.f
            long r6 = r0.g
            r2 = r1
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mkv.d$b r2 = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.mkv.d.b) r2
            r2.a((int) r3, (long) r4, (long) r6)
            r3 = 0
            r0.e = r3
            r4 = 1
            return r4
        L_0x09e9:
            r3 = 0
            r4 = 1
            long r5 = r0.g
            int r6 = (int) r5
            r5 = r1
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.b r5 = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) r5
            r5.c(r6)
            r0.e = r3
            r4 = 0
            r5 = 1
            goto L_0x0012
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.exoplayer2.extractor.mkv.a.a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.g):boolean");
    }

    public final String c(g gVar, int i) throws IOException, InterruptedException {
        if (i == 0) {
            return "";
        }
        byte[] bArr = new byte[i];
        ((b) gVar).b(bArr, 0, i, false);
        return new String(bArr);
    }

    public final double a(g gVar, int i) throws IOException, InterruptedException {
        long b2 = b(gVar, i);
        if (i == 4) {
            return (double) Float.intBitsToFloat((int) b2);
        }
        return Double.longBitsToDouble(b2);
    }
}
