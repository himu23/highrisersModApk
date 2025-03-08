package com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts;

import android.util.SparseArray;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.h;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.n;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.v;
import com.fyber.inneractive.sdk.player.exoplayer2.util.i;
import com.fyber.inneractive.sdk.player.exoplayer2.util.k;
import com.fyber.inneractive.sdk.player.exoplayer2.util.l;

public final class j implements h {
    public final s a;
    public final boolean b;
    public final boolean c;
    public final n d = new n(7, 128);
    public final n e = new n(8, 128);
    public final n f = new n(6, 128);
    public long g;
    public final boolean[] h = new boolean[3];
    public String i;
    public n j;
    public b k;
    public boolean l;
    public long m;
    public final k n = new k();

    public j(s sVar, boolean z, boolean z2) {
        this.a = sVar;
        this.b = z;
        this.c = z2;
    }

    public void a() {
        i.a(this.h);
        this.d.a();
        this.e.a();
        this.f.a();
        b bVar = this.k;
        bVar.k = false;
        bVar.o = false;
        b.a aVar = bVar.n;
        aVar.b = false;
        aVar.a = false;
        this.g = 0;
    }

    public void a(long j2, boolean z) {
        this.m = j2;
    }

    public void b() {
    }

    public static final class b {
        public final n a;
        public final boolean b;
        public final boolean c;
        public final SparseArray<i.b> d = new SparseArray<>();
        public final SparseArray<i.a> e = new SparseArray<>();
        public final l f;
        public byte[] g;
        public int h;
        public int i;
        public long j;
        public boolean k;
        public long l;
        public a m = new a();
        public a n = new a();
        public boolean o;
        public long p;
        public long q;
        public boolean r;

        public static final class a {
            public boolean a;
            public boolean b;
            public i.b c;
            public int d;
            public int e;
            public int f;
            public int g;
            public boolean h;
            public boolean i;
            public boolean j;
            public boolean k;
            public int l;
            public int m;
            public int n;
            public int o;
            public int p;

            public a() {
            }

            public static boolean a(a aVar, a aVar2) {
                boolean z;
                boolean z2;
                if (aVar.a) {
                    if (!aVar2.a || aVar.f != aVar2.f || aVar.g != aVar2.g || aVar.h != aVar2.h) {
                        return true;
                    }
                    if (aVar.i && aVar2.i && aVar.j != aVar2.j) {
                        return true;
                    }
                    int i2 = aVar.d;
                    int i3 = aVar2.d;
                    if (i2 != i3 && (i2 == 0 || i3 == 0)) {
                        return true;
                    }
                    int i4 = aVar.c.h;
                    if (i4 == 0 && aVar2.c.h == 0 && (aVar.m != aVar2.m || aVar.n != aVar2.n)) {
                        return true;
                    }
                    if ((i4 != 1 || aVar2.c.h != 1 || (aVar.o == aVar2.o && aVar.p == aVar2.p)) && (z = aVar.k) == (z2 = aVar2.k)) {
                        return z && z2 && aVar.l != aVar2.l;
                    }
                    return true;
                }
            }
        }

        public b(n nVar, boolean z, boolean z2) {
            this.a = nVar;
            this.b = z;
            this.c = z2;
            byte[] bArr = new byte[128];
            this.g = bArr;
            this.f = new l(bArr, 0, 0);
            a();
        }

        public void a() {
            this.k = false;
            this.o = false;
            a aVar = this.n;
            aVar.b = false;
            aVar.a = false;
        }
    }

    public void a(h hVar, v.d dVar) {
        dVar.a();
        this.i = dVar.b();
        n a2 = hVar.a(dVar.c(), 2);
        this.j = a2;
        this.k = new b(a2, this.b, this.c);
        this.a.a(hVar, dVar);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:53:0x01b4, code lost:
        if (r1 == 2) goto L_0x01b9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x01e5, code lost:
        if (r6 != 1) goto L_0x01e9;
     */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0138  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0171  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0173  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x01a3  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x01e4  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x01e8  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x01ed A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0205 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.fyber.inneractive.sdk.player.exoplayer2.util.k r31) {
        /*
            r30 = this;
            r0 = r30
            r1 = r31
            int r2 = r1.b
            int r3 = r1.c
            byte[] r4 = r1.a
            long r5 = r0.g
            int r7 = r31.a()
            long r7 = (long) r7
            long r5 = r5 + r7
            r0.g = r5
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.n r5 = r0.j
            int r6 = r31.a()
            r5.a(r1, r6)
        L_0x001d:
            boolean[] r1 = r0.h
            int r1 = com.fyber.inneractive.sdk.player.exoplayer2.util.i.a(r4, r2, r3, r1)
            if (r1 != r3) goto L_0x0029
            r0.a(r4, r2, r3)
            return
        L_0x0029:
            int r5 = r1 + 3
            byte r6 = r4[r5]
            r6 = r6 & 31
            int r7 = r1 - r2
            if (r7 <= 0) goto L_0x0036
            r0.a(r4, r2, r1)
        L_0x0036:
            int r1 = r3 - r1
            long r8 = r0.g
            long r10 = (long) r1
            long r8 = r8 - r10
            if (r7 >= 0) goto L_0x0040
            int r7 = -r7
            goto L_0x0041
        L_0x0040:
            r7 = 0
        L_0x0041:
            long r10 = r0.m
            boolean r12 = r0.l
            if (r12 == 0) goto L_0x0056
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.j$b r12 = r0.k
            boolean r12 = r12.c
            if (r12 == 0) goto L_0x004e
            goto L_0x0056
        L_0x004e:
            r27 = r3
            r28 = r4
            r29 = r5
            goto L_0x0130
        L_0x0056:
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.n r12 = r0.d
            r12.a(r7)
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.n r12 = r0.e
            r12.a(r7)
            boolean r12 = r0.l
            r14 = 3
            if (r12 != 0) goto L_0x00f1
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.n r12 = r0.d
            boolean r12 = r12.c
            if (r12 == 0) goto L_0x004e
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.n r12 = r0.e
            boolean r12 = r12.c
            if (r12 == 0) goto L_0x004e
            java.util.ArrayList r12 = new java.util.ArrayList
            r12.<init>()
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.n r15 = r0.d
            byte[] r2 = r15.d
            int r15 = r15.e
            byte[] r2 = java.util.Arrays.copyOf(r2, r15)
            r12.add(r2)
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.n r2 = r0.e
            byte[] r15 = r2.d
            int r2 = r2.e
            byte[] r2 = java.util.Arrays.copyOf(r15, r2)
            r12.add(r2)
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.n r2 = r0.d
            byte[] r15 = r2.d
            int r2 = r2.e
            com.fyber.inneractive.sdk.player.exoplayer2.util.i$b r2 = com.fyber.inneractive.sdk.player.exoplayer2.util.i.b(r15, r14, r2)
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.n r15 = r0.e
            byte[] r13 = r15.d
            int r15 = r15.e
            com.fyber.inneractive.sdk.player.exoplayer2.util.i$a r13 = com.fyber.inneractive.sdk.player.exoplayer2.util.i.a(r13, r14, r15)
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.n r14 = r0.j
            java.lang.String r15 = r0.i
            r27 = r3
            int r3 = r2.b
            r28 = r4
            int r4 = r2.c
            r29 = r5
            float r5 = r2.d
            java.lang.String r16 = "video/avc"
            r17 = 0
            r18 = -1
            r19 = -1
            r22 = -1082130432(0xffffffffbf800000, float:-1.0)
            r24 = -1
            r26 = 0
            r20 = r3
            r21 = r4
            r23 = r12
            r25 = r5
            com.fyber.inneractive.sdk.player.exoplayer2.i r3 = com.fyber.inneractive.sdk.player.exoplayer2.i.a((java.lang.String) r15, (java.lang.String) r16, (java.lang.String) r17, (int) r18, (int) r19, (int) r20, (int) r21, (float) r22, (java.util.List<byte[]>) r23, (int) r24, (float) r25, (com.fyber.inneractive.sdk.player.exoplayer2.drm.a) r26)
            r14.a(r3)
            r3 = 1
            r0.l = r3
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.j$b r3 = r0.k
            android.util.SparseArray<com.fyber.inneractive.sdk.player.exoplayer2.util.i$b> r3 = r3.d
            int r4 = r2.a
            r3.append(r4, r2)
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.j$b r2 = r0.k
            android.util.SparseArray<com.fyber.inneractive.sdk.player.exoplayer2.util.i$a> r2 = r2.e
            int r3 = r13.a
            r2.append(r3, r13)
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.n r2 = r0.d
            r2.a()
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.n r2 = r0.e
            r2.a()
            goto L_0x0130
        L_0x00f1:
            r27 = r3
            r28 = r4
            r29 = r5
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.n r2 = r0.d
            boolean r3 = r2.c
            if (r3 == 0) goto L_0x0114
            byte[] r3 = r2.d
            int r2 = r2.e
            com.fyber.inneractive.sdk.player.exoplayer2.util.i$b r2 = com.fyber.inneractive.sdk.player.exoplayer2.util.i.b(r3, r14, r2)
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.j$b r3 = r0.k
            android.util.SparseArray<com.fyber.inneractive.sdk.player.exoplayer2.util.i$b> r3 = r3.d
            int r4 = r2.a
            r3.append(r4, r2)
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.n r2 = r0.d
            r2.a()
            goto L_0x0130
        L_0x0114:
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.n r2 = r0.e
            boolean r3 = r2.c
            if (r3 == 0) goto L_0x0130
            byte[] r3 = r2.d
            int r2 = r2.e
            com.fyber.inneractive.sdk.player.exoplayer2.util.i$a r2 = com.fyber.inneractive.sdk.player.exoplayer2.util.i.a(r3, r14, r2)
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.j$b r3 = r0.k
            android.util.SparseArray<com.fyber.inneractive.sdk.player.exoplayer2.util.i$a> r3 = r3.e
            int r4 = r2.a
            r3.append(r4, r2)
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.n r2 = r0.e
            r2.a()
        L_0x0130:
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.n r2 = r0.f
            boolean r2 = r2.a(r7)
            if (r2 == 0) goto L_0x015a
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.n r2 = r0.f
            byte[] r3 = r2.d
            int r2 = r2.e
            int r2 = com.fyber.inneractive.sdk.player.exoplayer2.util.i.a(r3, r2)
            com.fyber.inneractive.sdk.player.exoplayer2.util.k r3 = r0.n
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.n r4 = r0.f
            byte[] r4 = r4.d
            r3.a((byte[]) r4, (int) r2)
            com.fyber.inneractive.sdk.player.exoplayer2.util.k r2 = r0.n
            r3 = 4
            r2.e(r3)
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.s r2 = r0.a
            com.fyber.inneractive.sdk.player.exoplayer2.util.k r3 = r0.n
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.n[] r2 = r2.b
            com.fyber.inneractive.sdk.player.exoplayer2.text.cea.a.a(r10, r3, r2)
        L_0x015a:
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.j$b r2 = r0.k
            int r3 = r2.i
            r4 = 9
            if (r3 == r4) goto L_0x0173
            boolean r3 = r2.c
            if (r3 == 0) goto L_0x0171
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.j$b$a r3 = r2.n
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.j$b$a r4 = r2.m
            boolean r3 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.j.b.a.a(r3, r4)
            if (r3 == 0) goto L_0x0171
            goto L_0x0173
        L_0x0171:
            r1 = 1
            goto L_0x019b
        L_0x0173:
            boolean r3 = r2.o
            if (r3 == 0) goto L_0x018d
            long r3 = r2.j
            long r10 = r8 - r3
            int r5 = (int) r10
            int r15 = r1 + r5
            boolean r13 = r2.r
            long r10 = r2.p
            long r3 = r3 - r10
            int r14 = (int) r3
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.n r10 = r2.a
            long r11 = r2.q
            r16 = 0
            r10.a(r11, r13, r14, r15, r16)
        L_0x018d:
            long r3 = r2.j
            r2.p = r3
            long r3 = r2.l
            r2.q = r3
            r1 = 0
            r2.r = r1
            r1 = 1
            r2.o = r1
        L_0x019b:
            boolean r3 = r2.r
            int r4 = r2.i
            r5 = 2
            r7 = 5
            if (r4 == r7) goto L_0x01b9
            boolean r10 = r2.b
            if (r10 == 0) goto L_0x01b7
            if (r4 != r1) goto L_0x01b7
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.j$b$a r1 = r2.n
            boolean r4 = r1.b
            if (r4 == 0) goto L_0x01b7
            int r1 = r1.e
            r4 = 7
            if (r1 == r4) goto L_0x01b9
            if (r1 != r5) goto L_0x01b7
            goto L_0x01b9
        L_0x01b7:
            r1 = 0
            goto L_0x01ba
        L_0x01b9:
            r1 = 1
        L_0x01ba:
            r1 = r1 | r3
            r2.r = r1
            long r1 = r0.m
            boolean r3 = r0.l
            if (r3 == 0) goto L_0x01c9
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.j$b r3 = r0.k
            boolean r3 = r3.c
            if (r3 == 0) goto L_0x01d3
        L_0x01c9:
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.n r3 = r0.d
            r3.b(r6)
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.n r3 = r0.e
            r3.b(r6)
        L_0x01d3:
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.n r3 = r0.f
            r3.b(r6)
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.j$b r3 = r0.k
            r3.i = r6
            r3.l = r1
            r3.j = r8
            boolean r1 = r3.b
            if (r1 == 0) goto L_0x01e8
            r1 = 1
            if (r6 == r1) goto L_0x01f3
            goto L_0x01e9
        L_0x01e8:
            r1 = 1
        L_0x01e9:
            boolean r2 = r3.c
            if (r2 == 0) goto L_0x0205
            if (r6 == r7) goto L_0x01f3
            if (r6 == r1) goto L_0x01f3
            if (r6 != r5) goto L_0x0205
        L_0x01f3:
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.j$b$a r1 = r3.m
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.j$b$a r2 = r3.n
            r3.m = r2
            r3.n = r1
            r2 = 0
            r1.b = r2
            r1.a = r2
            r3.h = r2
            r1 = 1
            r3.k = r1
        L_0x0205:
            r3 = r27
            r4 = r28
            r2 = r29
            goto L_0x001d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.j.a(com.fyber.inneractive.sdk.player.exoplayer2.util.k):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x0126  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0128  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x012b  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x013c  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0141  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x016f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(byte[] r17, int r18, int r19) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r2 = r18
            r3 = r19
            boolean r4 = r0.l
            if (r4 == 0) goto L_0x0012
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.j$b r4 = r0.k
            boolean r4 = r4.c
            if (r4 == 0) goto L_0x001c
        L_0x0012:
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.n r4 = r0.d
            r4.a(r1, r2, r3)
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.n r4 = r0.e
            r4.a(r1, r2, r3)
        L_0x001c:
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.n r4 = r0.f
            r4.a(r1, r2, r3)
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.j$b r4 = r0.k
            boolean r5 = r4.k
            if (r5 != 0) goto L_0x0029
            goto L_0x01cc
        L_0x0029:
            int r3 = r3 - r2
            byte[] r5 = r4.g
            int r6 = r5.length
            int r7 = r4.h
            int r7 = r7 + r3
            r8 = 2
            if (r6 >= r7) goto L_0x003b
            int r7 = r7 * 2
            byte[] r5 = java.util.Arrays.copyOf(r5, r7)
            r4.g = r5
        L_0x003b:
            byte[] r5 = r4.g
            int r6 = r4.h
            java.lang.System.arraycopy(r1, r2, r5, r6, r3)
            int r1 = r4.h
            int r1 = r1 + r3
            r4.h = r1
            com.fyber.inneractive.sdk.player.exoplayer2.util.l r2 = r4.f
            byte[] r3 = r4.g
            r2.a = r3
            r3 = 0
            r2.c = r3
            r2.b = r1
            r2.d = r3
            r2.a()
            com.fyber.inneractive.sdk.player.exoplayer2.util.l r1 = r4.f
            r2 = 8
            boolean r1 = r1.a(r2)
            if (r1 != 0) goto L_0x0063
            goto L_0x01cc
        L_0x0063:
            com.fyber.inneractive.sdk.player.exoplayer2.util.l r1 = r4.f
            r1.f()
            com.fyber.inneractive.sdk.player.exoplayer2.util.l r1 = r4.f
            int r1 = r1.b(r8)
            com.fyber.inneractive.sdk.player.exoplayer2.util.l r2 = r4.f
            r5 = 5
            r2.d(r5)
            com.fyber.inneractive.sdk.player.exoplayer2.util.l r2 = r4.f
            boolean r2 = r2.b()
            if (r2 != 0) goto L_0x007e
            goto L_0x01cc
        L_0x007e:
            com.fyber.inneractive.sdk.player.exoplayer2.util.l r2 = r4.f
            r2.d()
            com.fyber.inneractive.sdk.player.exoplayer2.util.l r2 = r4.f
            boolean r2 = r2.b()
            if (r2 != 0) goto L_0x008d
            goto L_0x01cc
        L_0x008d:
            com.fyber.inneractive.sdk.player.exoplayer2.util.l r2 = r4.f
            int r2 = r2.d()
            boolean r6 = r4.c
            r7 = 1
            if (r6 != 0) goto L_0x00a2
            r4.k = r3
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.j$b$a r1 = r4.n
            r1.e = r2
            r1.b = r7
            goto L_0x01cc
        L_0x00a2:
            com.fyber.inneractive.sdk.player.exoplayer2.util.l r6 = r4.f
            boolean r6 = r6.b()
            if (r6 != 0) goto L_0x00ac
            goto L_0x01cc
        L_0x00ac:
            com.fyber.inneractive.sdk.player.exoplayer2.util.l r6 = r4.f
            int r6 = r6.d()
            android.util.SparseArray<com.fyber.inneractive.sdk.player.exoplayer2.util.i$a> r9 = r4.e
            int r9 = r9.indexOfKey(r6)
            if (r9 >= 0) goto L_0x00be
            r4.k = r3
            goto L_0x01cc
        L_0x00be:
            android.util.SparseArray<com.fyber.inneractive.sdk.player.exoplayer2.util.i$a> r9 = r4.e
            java.lang.Object r9 = r9.get(r6)
            com.fyber.inneractive.sdk.player.exoplayer2.util.i$a r9 = (com.fyber.inneractive.sdk.player.exoplayer2.util.i.a) r9
            android.util.SparseArray<com.fyber.inneractive.sdk.player.exoplayer2.util.i$b> r10 = r4.d
            int r11 = r9.b
            java.lang.Object r10 = r10.get(r11)
            com.fyber.inneractive.sdk.player.exoplayer2.util.i$b r10 = (com.fyber.inneractive.sdk.player.exoplayer2.util.i.b) r10
            boolean r11 = r10.e
            if (r11 == 0) goto L_0x00e3
            com.fyber.inneractive.sdk.player.exoplayer2.util.l r11 = r4.f
            boolean r11 = r11.a(r8)
            if (r11 != 0) goto L_0x00de
            goto L_0x01cc
        L_0x00de:
            com.fyber.inneractive.sdk.player.exoplayer2.util.l r11 = r4.f
            r11.d(r8)
        L_0x00e3:
            com.fyber.inneractive.sdk.player.exoplayer2.util.l r8 = r4.f
            int r11 = r10.g
            boolean r8 = r8.a(r11)
            if (r8 != 0) goto L_0x00ef
            goto L_0x01cc
        L_0x00ef:
            com.fyber.inneractive.sdk.player.exoplayer2.util.l r8 = r4.f
            int r11 = r10.g
            int r8 = r8.b(r11)
            boolean r11 = r10.f
            if (r11 != 0) goto L_0x011f
            com.fyber.inneractive.sdk.player.exoplayer2.util.l r11 = r4.f
            boolean r11 = r11.a(r7)
            if (r11 != 0) goto L_0x0105
            goto L_0x01cc
        L_0x0105:
            com.fyber.inneractive.sdk.player.exoplayer2.util.l r11 = r4.f
            boolean r11 = r11.c()
            if (r11 == 0) goto L_0x0120
            com.fyber.inneractive.sdk.player.exoplayer2.util.l r12 = r4.f
            boolean r12 = r12.a(r7)
            if (r12 != 0) goto L_0x0117
            goto L_0x01cc
        L_0x0117:
            com.fyber.inneractive.sdk.player.exoplayer2.util.l r12 = r4.f
            boolean r12 = r12.c()
            r13 = 1
            goto L_0x0122
        L_0x011f:
            r11 = 0
        L_0x0120:
            r12 = 0
            r13 = 0
        L_0x0122:
            int r14 = r4.i
            if (r14 != r5) goto L_0x0128
            r5 = 1
            goto L_0x0129
        L_0x0128:
            r5 = 0
        L_0x0129:
            if (r5 == 0) goto L_0x013c
            com.fyber.inneractive.sdk.player.exoplayer2.util.l r14 = r4.f
            boolean r14 = r14.b()
            if (r14 != 0) goto L_0x0135
            goto L_0x01cc
        L_0x0135:
            com.fyber.inneractive.sdk.player.exoplayer2.util.l r14 = r4.f
            int r14 = r14.d()
            goto L_0x013d
        L_0x013c:
            r14 = 0
        L_0x013d:
            int r15 = r10.h
            if (r15 != 0) goto L_0x016f
            com.fyber.inneractive.sdk.player.exoplayer2.util.l r15 = r4.f
            int r3 = r10.i
            boolean r3 = r15.a(r3)
            if (r3 != 0) goto L_0x014d
            goto L_0x01cc
        L_0x014d:
            com.fyber.inneractive.sdk.player.exoplayer2.util.l r3 = r4.f
            int r15 = r10.i
            int r3 = r3.b(r15)
            boolean r9 = r9.c
            if (r9 == 0) goto L_0x01a3
            if (r11 != 0) goto L_0x01a3
            com.fyber.inneractive.sdk.player.exoplayer2.util.l r9 = r4.f
            boolean r9 = r9.b()
            if (r9 != 0) goto L_0x0165
            goto L_0x01cc
        L_0x0165:
            com.fyber.inneractive.sdk.player.exoplayer2.util.l r9 = r4.f
            int r9 = r9.e()
            r15 = r9
            r7 = 0
            r9 = 0
            goto L_0x01a6
        L_0x016f:
            if (r15 != r7) goto L_0x01a2
            boolean r3 = r10.j
            if (r3 != 0) goto L_0x01a2
            com.fyber.inneractive.sdk.player.exoplayer2.util.l r3 = r4.f
            boolean r3 = r3.b()
            if (r3 != 0) goto L_0x017e
            goto L_0x01cc
        L_0x017e:
            com.fyber.inneractive.sdk.player.exoplayer2.util.l r3 = r4.f
            int r3 = r3.e()
            boolean r9 = r9.c
            if (r9 == 0) goto L_0x019e
            if (r11 != 0) goto L_0x019e
            com.fyber.inneractive.sdk.player.exoplayer2.util.l r9 = r4.f
            boolean r9 = r9.b()
            if (r9 != 0) goto L_0x0193
            goto L_0x01cc
        L_0x0193:
            com.fyber.inneractive.sdk.player.exoplayer2.util.l r9 = r4.f
            int r9 = r9.e()
            r7 = r9
            r15 = 0
            r9 = r3
            r3 = 0
            goto L_0x01a6
        L_0x019e:
            r9 = r3
            r3 = 0
            r7 = 0
            goto L_0x01a5
        L_0x01a2:
            r3 = 0
        L_0x01a3:
            r7 = 0
            r9 = 0
        L_0x01a5:
            r15 = 0
        L_0x01a6:
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.j$b$a r0 = r4.n
            r0.c = r10
            r0.d = r1
            r0.e = r2
            r0.f = r8
            r0.g = r6
            r0.h = r11
            r0.i = r13
            r0.j = r12
            r0.k = r5
            r0.l = r14
            r0.m = r3
            r0.n = r15
            r0.o = r9
            r0.p = r7
            r1 = 1
            r0.a = r1
            r0.b = r1
            r0 = 0
            r4.k = r0
        L_0x01cc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.j.a(byte[], int, int):void");
    }
}
