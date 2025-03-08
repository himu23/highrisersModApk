package com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp3;

import com.fyber.inneractive.sdk.player.exoplayer2.extractor.f;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.g;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.h;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.j;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.m;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.n;
import com.fyber.inneractive.sdk.player.exoplayer2.l;
import com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.g;
import com.fyber.inneractive.sdk.player.exoplayer2.util.k;
import com.fyber.inneractive.sdk.player.exoplayer2.util.u;
import java.io.IOException;

public final class b implements f {
    public static final int m = u.a("Xing");
    public static final int n = u.a("Info");
    public static final int o = u.a("VBRI");
    public final long a;
    public final k b = new k(10);
    public final com.fyber.inneractive.sdk.player.exoplayer2.extractor.k c = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.k();
    public final j d = new j();
    public h e;
    public n f;
    public int g;
    public com.fyber.inneractive.sdk.player.exoplayer2.metadata.a h;
    public a i;
    public long j = -9223372036854775807L;
    public long k;
    public int l;

    public interface a extends m {
        long b(long j);
    }

    public b(int i2, long j2) {
        this.a = j2;
    }

    public static boolean a(int i2, long j2) {
        return ((long) (i2 & -128000)) == (j2 & -128000);
    }

    public void a(long j2, long j3) {
        this.g = 0;
        this.j = -9223372036854775807L;
        this.k = 0;
        this.l = 0;
    }

    public boolean a(g gVar) throws IOException, InterruptedException {
        return a(gVar, true);
    }

    public final a b(g gVar) throws IOException, InterruptedException {
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.b bVar = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) gVar;
        bVar.a(this.b.a, 0, 4, false);
        this.b.e(0);
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.k.a(this.b.c(), this.c);
        return new a(bVar.c, this.c.f, bVar.b);
    }

    public void b() {
    }

    public void a(h hVar) {
        this.e = hVar;
        this.f = hVar.a(0, 1);
        this.e.c();
    }

    /* JADX WARNING: type inference failed for: r16v2, types: [com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp3.b$a] */
    /* JADX WARNING: type inference failed for: r1v28, types: [com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp3.c] */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0058, code lost:
        if (r12 != n) goto L_0x005b;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0136  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x01fc  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0200  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.g r36, com.fyber.inneractive.sdk.player.exoplayer2.extractor.l r37) throws java.io.IOException, java.lang.InterruptedException {
        /*
            r35 = this;
            r0 = r35
            r1 = r36
            int r2 = r0.g
            r3 = -1
            r4 = 0
            if (r2 != 0) goto L_0x000f
            r0.a((com.fyber.inneractive.sdk.player.exoplayer2.extractor.g) r1, (boolean) r4)     // Catch:{ EOFException -> 0x000e }
            goto L_0x000f
        L_0x000e:
            return r3
        L_0x000f:
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp3.b$a r2 = r0.i
            r7 = 1000000(0xf4240, double:4.940656E-318)
            r10 = 1
            if (r2 != 0) goto L_0x0243
            com.fyber.inneractive.sdk.player.exoplayer2.util.k r2 = new com.fyber.inneractive.sdk.player.exoplayer2.util.k
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.k r11 = r0.c
            int r11 = r11.c
            r2.<init>((int) r11)
            byte[] r11 = r2.a
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.k r12 = r0.c
            int r12 = r12.c
            r13 = r1
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.b r13 = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) r13
            r13.a(r11, r4, r12, r4)
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.k r11 = r0.c
            int r12 = r11.a
            r12 = r12 & r10
            r14 = 36
            if (r12 == 0) goto L_0x003c
            int r11 = r11.e
            if (r11 == r10) goto L_0x0040
            r11 = 36
            goto L_0x0045
        L_0x003c:
            int r11 = r11.e
            if (r11 == r10) goto L_0x0043
        L_0x0040:
            r11 = 21
            goto L_0x0045
        L_0x0043:
            r11 = 13
        L_0x0045:
            int r12 = r2.c
            int r15 = r11 + 4
            if (r12 < r15) goto L_0x005b
            r2.e(r11)
            int r12 = r2.c()
            int r15 = m
            if (r12 == r15) goto L_0x006f
            int r15 = n
            if (r12 != r15) goto L_0x005b
            goto L_0x006f
        L_0x005b:
            int r12 = r2.c
            r15 = 40
            if (r12 < r15) goto L_0x006e
            r2.e(r14)
            int r12 = r2.c()
            int r14 = o
            if (r12 != r14) goto L_0x006e
            r12 = r14
            goto L_0x006f
        L_0x006e:
            r12 = 0
        L_0x006f:
            int r14 = m
            r16 = 0
            if (r12 == r14) goto L_0x0136
            int r14 = n
            if (r12 != r14) goto L_0x007b
            goto L_0x0136
        L_0x007b:
            int r11 = o
            if (r12 != r11) goto L_0x012e
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.k r11 = r0.c
            long r9 = r13.c
            long r14 = r13.b
            r12 = 10
            r2.f(r12)
            int r12 = r2.c()
            if (r12 > 0) goto L_0x0094
            r24 = r13
            goto L_0x0124
        L_0x0094:
            int r3 = r11.d
            long r4 = (long) r12
            r6 = 32000(0x7d00, float:4.4842E-41)
            if (r3 < r6) goto L_0x009e
            r6 = 1152(0x480, float:1.614E-42)
            goto L_0x00a0
        L_0x009e:
            r6 = 576(0x240, float:8.07E-43)
        L_0x00a0:
            r24 = r13
            long r12 = (long) r6
            long r20 = r12 * r7
            long r12 = (long) r3
            r18 = r4
            r22 = r12
            long r3 = com.fyber.inneractive.sdk.player.exoplayer2.util.u.a((long) r18, (long) r20, (long) r22)
            int r5 = r2.q()
            int r6 = r2.q()
            int r12 = r2.q()
            r13 = 2
            r2.f(r13)
            int r11 = r11.c
            long r7 = (long) r11
            long r9 = r9 + r7
            int r7 = r5 + 1
            long[] r8 = new long[r7]
            long[] r11 = new long[r7]
            r20 = 0
            r22 = 0
            r8[r22] = r20
            r11[r22] = r9
            r13 = 1
        L_0x00d1:
            if (r13 >= r7) goto L_0x011d
            r21 = r7
            r7 = 1
            if (r12 == r7) goto L_0x00f1
            r7 = 2
            if (r12 == r7) goto L_0x00ec
            r7 = 3
            if (r12 == r7) goto L_0x00e7
            r7 = 4
            if (r12 == r7) goto L_0x00e2
            goto L_0x0124
        L_0x00e2:
            int r7 = r2.o()
            goto L_0x00f5
        L_0x00e7:
            int r7 = r2.n()
            goto L_0x00f5
        L_0x00ec:
            int r7 = r2.q()
            goto L_0x00f5
        L_0x00f1:
            int r7 = r2.l()
        L_0x00f5:
            int r7 = r7 * r6
            r22 = r6
            long r6 = (long) r7
            long r9 = r9 + r6
            long r6 = (long) r13
            long r6 = r6 * r3
            r23 = r2
            long r1 = (long) r5
            long r6 = r6 / r1
            r8[r13] = r6
            r1 = -1
            int r6 = (r14 > r1 ? 1 : (r14 == r1 ? 0 : -1))
            if (r6 != 0) goto L_0x010c
            r1 = r9
            goto L_0x0110
        L_0x010c:
            long r1 = java.lang.Math.min(r14, r9)
        L_0x0110:
            r11[r13] = r1
            int r13 = r13 + 1
            r1 = r36
            r7 = r21
            r6 = r22
            r2 = r23
            goto L_0x00d1
        L_0x011d:
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp3.c r1 = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp3.c
            r1.<init>(r8, r11, r3)
            r16 = r1
        L_0x0124:
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.k r1 = r0.c
            int r1 = r1.c
            r2 = r24
            r2.c(r1)
            goto L_0x0132
        L_0x012e:
            r2 = r13
            r1 = 0
            r2.e = r1
        L_0x0132:
            r1 = r16
            goto L_0x01f8
        L_0x0136:
            r23 = r2
            r2 = r13
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.k r1 = r0.c
            long r3 = r2.c
            long r5 = r2.b
            int r7 = r1.g
            int r8 = r1.d
            int r9 = r1.c
            long r9 = (long) r9
            long r25 = r3 + r9
            int r3 = r23.c()
            r4 = r3 & 1
            r9 = 1
            if (r4 != r9) goto L_0x01a9
            int r4 = r23.o()
            if (r4 != 0) goto L_0x0158
            goto L_0x01a9
        L_0x0158:
            long r9 = (long) r4
            long r14 = (long) r7
            r18 = 1000000(0xf4240, double:4.940656E-318)
            long r29 = r14 * r18
            long r7 = (long) r8
            r27 = r9
            r31 = r7
            long r27 = com.fyber.inneractive.sdk.player.exoplayer2.util.u.a((long) r27, (long) r29, (long) r31)
            r4 = 6
            r3 = r3 & r4
            if (r3 == r4) goto L_0x017c
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp3.d r16 = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp3.d
            r31 = 0
            r32 = 0
            r34 = 0
            r24 = r16
            r29 = r5
            r24.<init>(r25, r27, r29, r31, r32, r34)
            goto L_0x01a9
        L_0x017c:
            int r3 = r23.o()
            long r3 = (long) r3
            r7 = r23
            r8 = 1
            r7.f(r8)
            r8 = 99
            long[] r9 = new long[r8]
            r10 = 0
        L_0x018c:
            if (r10 >= r8) goto L_0x0198
            int r13 = r7.l()
            long r14 = (long) r13
            r9[r10] = r14
            int r10 = r10 + 1
            goto L_0x018c
        L_0x0198:
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp3.d r16 = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp3.d
            int r1 = r1.c
            r24 = r16
            r29 = r5
            r31 = r9
            r32 = r3
            r34 = r1
            r24.<init>(r25, r27, r29, r31, r32, r34)
        L_0x01a9:
            if (r16 == 0) goto L_0x01df
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.j r1 = r0.d
            boolean r1 = r1.a()
            if (r1 != 0) goto L_0x01df
            r1 = 0
            r2.e = r1
            int r11 = r11 + 141
            r2.a(r11, r1)
            com.fyber.inneractive.sdk.player.exoplayer2.util.k r3 = r0.b
            byte[] r3 = r3.a
            r4 = 3
            r2.a(r3, r1, r4, r1)
            com.fyber.inneractive.sdk.player.exoplayer2.util.k r3 = r0.b
            r3.e(r1)
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.j r1 = r0.d
            com.fyber.inneractive.sdk.player.exoplayer2.util.k r3 = r0.b
            int r3 = r3.n()
            r1.getClass()
            int r4 = r3 >> 12
            r3 = r3 & 4095(0xfff, float:5.738E-42)
            if (r4 > 0) goto L_0x01db
            if (r3 <= 0) goto L_0x01df
        L_0x01db:
            r1.a = r4
            r1.b = r3
        L_0x01df:
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.k r1 = r0.c
            int r1 = r1.c
            r2.c(r1)
            if (r16 == 0) goto L_0x0132
            boolean r1 = r16.a()
            if (r1 != 0) goto L_0x0132
            int r1 = n
            if (r12 != r1) goto L_0x0132
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp3.b$a r16 = r35.b(r36)
            goto L_0x0132
        L_0x01f8:
            r0.i = r1
            if (r1 == 0) goto L_0x0200
            r1.a()
            goto L_0x0206
        L_0x0200:
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp3.b$a r1 = r35.b(r36)
            r0.i = r1
        L_0x0206:
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.h r1 = r0.e
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp3.b$a r2 = r0.i
            r1.a(r2)
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.n r1 = r0.f
            r2 = 0
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.k r3 = r0.c
            java.lang.String r4 = r3.b
            r5 = 0
            r6 = -1
            r7 = 4096(0x1000, float:5.74E-42)
            int r8 = r3.e
            int r9 = r3.d
            r10 = -1
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.j r3 = r0.d
            int r11 = r3.a
            int r12 = r3.b
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            com.fyber.inneractive.sdk.player.exoplayer2.metadata.a r3 = r0.h
            r17 = r3
            r3 = r4
            r4 = r5
            r5 = r6
            r6 = r7
            r7 = r8
            r8 = r9
            r9 = r10
            r10 = r11
            r11 = r12
            r12 = r13
            r13 = r14
            r14 = r15
            r15 = r16
            r16 = r17
            com.fyber.inneractive.sdk.player.exoplayer2.i r2 = com.fyber.inneractive.sdk.player.exoplayer2.i.a((java.lang.String) r2, (java.lang.String) r3, (java.lang.String) r4, (int) r5, (int) r6, (int) r7, (int) r8, (int) r9, (int) r10, (int) r11, (java.util.List<byte[]>) r12, (com.fyber.inneractive.sdk.player.exoplayer2.drm.a) r13, (int) r14, (java.lang.String) r15, (com.fyber.inneractive.sdk.player.exoplayer2.metadata.a) r16)
            r1.a(r2)
        L_0x0243:
            int r1 = r0.l
            if (r1 != 0) goto L_0x02b8
            r1 = r36
            r2 = r1
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.b r2 = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) r2
            r3 = 0
            r2.e = r3
            com.fyber.inneractive.sdk.player.exoplayer2.util.k r4 = r0.b
            byte[] r4 = r4.a
            r5 = 4
            r6 = 1
            boolean r4 = r2.a(r4, r3, r5, r6)
            if (r4 != 0) goto L_0x025d
            r2 = -1
            goto L_0x02c6
        L_0x025d:
            com.fyber.inneractive.sdk.player.exoplayer2.util.k r4 = r0.b
            r4.e(r3)
            com.fyber.inneractive.sdk.player.exoplayer2.util.k r3 = r0.b
            int r3 = r3.c()
            int r4 = r0.g
            long r4 = (long) r4
            boolean r4 = a((int) r3, (long) r4)
            if (r4 == 0) goto L_0x02b0
            int r4 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.k.a(r3)
            r5 = -1
            if (r4 != r5) goto L_0x0279
            goto L_0x02b0
        L_0x0279:
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.k r4 = r0.c
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.k.a(r3, r4)
            long r3 = r0.j
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L_0x02a9
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp3.b$a r3 = r0.i
            long r7 = r2.c
            long r2 = r3.b(r7)
            r0.j = r2
            long r2 = r0.a
            int r4 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r4 == 0) goto L_0x02a9
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp3.b$a r2 = r0.i
            r3 = 0
            long r2 = r2.b(r3)
            long r4 = r0.j
            long r6 = r0.a
            long r6 = r6 - r2
            long r4 = r4 + r6
            r0.j = r4
        L_0x02a9:
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.k r2 = r0.c
            int r2 = r2.c
            r0.l = r2
            goto L_0x02ba
        L_0x02b0:
            r3 = 1
            r2.c(r3)
            r1 = 0
            r0.g = r1
            goto L_0x02f8
        L_0x02b8:
            r1 = r36
        L_0x02ba:
            r3 = 1
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.n r2 = r0.f
            int r4 = r0.l
            int r1 = r2.a(r1, r4, r3)
            r2 = -1
            if (r1 != r2) goto L_0x02c8
        L_0x02c6:
            r3 = -1
            goto L_0x02f9
        L_0x02c8:
            int r2 = r0.l
            int r2 = r2 - r1
            r0.l = r2
            if (r2 <= 0) goto L_0x02d0
            goto L_0x02f8
        L_0x02d0:
            long r1 = r0.j
            long r3 = r0.k
            r5 = 1000000(0xf4240, double:4.940656E-318)
            long r3 = r3 * r5
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.k r5 = r0.c
            int r6 = r5.d
            long r6 = (long) r6
            long r3 = r3 / r6
            long r7 = r1 + r3
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.n r6 = r0.f
            int r10 = r5.c
            r9 = 1
            r11 = 0
            r12 = 0
            r6.a(r7, r9, r10, r11, r12)
            long r1 = r0.k
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.k r3 = r0.c
            int r3 = r3.g
            long r3 = (long) r3
            long r1 = r1 + r3
            r0.k = r1
            r1 = 0
            r0.l = r1
        L_0x02f8:
            r3 = 0
        L_0x02f9:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp3.b.a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.g, com.fyber.inneractive.sdk.player.exoplayer2.extractor.l):int");
    }

    public final boolean a(g gVar, boolean z) throws IOException, InterruptedException {
        int i2;
        int i3;
        int a2;
        int i4 = z ? 16384 : 131072;
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.b bVar = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) gVar;
        bVar.e = 0;
        int i5 = 0;
        if (bVar.c == 0) {
            while (true) {
                bVar.a(this.b.a, 0, 10, false);
                this.b.e(0);
                if (this.b.n() != com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.g.b) {
                    break;
                }
                this.b.f(3);
                int k2 = this.b.k();
                int i6 = k2 + 10;
                if (this.h == null) {
                    byte[] bArr = new byte[i6];
                    System.arraycopy(this.b.a, 0, bArr, 0, 10);
                    bVar.a(bArr, 10, k2, false);
                    com.fyber.inneractive.sdk.player.exoplayer2.metadata.a a3 = new com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.g((g.a) null).a(bArr, i6);
                    this.h = a3;
                    if (a3 != null) {
                        this.d.a(a3);
                    }
                } else {
                    bVar.a(k2, false);
                }
                i5 += i6;
            }
            bVar.e = 0;
            bVar.a(i5, false);
            i2 = (int) (bVar.c + ((long) bVar.e));
            if (!z) {
                bVar.c(i2);
            }
            i5 = 0;
        } else {
            i2 = 0;
        }
        int i7 = 0;
        int i8 = 0;
        while (true) {
            if (!bVar.a(this.b.a, 0, 4, i3 > 0)) {
                break;
            }
            this.b.e(0);
            int c2 = this.b.c();
            if ((i7 == 0 || a(c2, (long) i7)) && (a2 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.k.a(c2)) != -1) {
                i3++;
                if (i3 != 1) {
                    if (i3 == 4) {
                        break;
                    }
                } else {
                    com.fyber.inneractive.sdk.player.exoplayer2.extractor.k.a(c2, this.c);
                    i7 = c2;
                }
                bVar.a(a2 - 4, false);
            } else {
                int i9 = i8 + 1;
                if (i8 != i4) {
                    if (z) {
                        bVar.e = 0;
                        bVar.a(i2 + i9, false);
                    } else {
                        bVar.c(1);
                    }
                    i8 = i9;
                    i3 = 0;
                    i7 = 0;
                } else if (z) {
                    return false;
                } else {
                    throw new l("Searched too many bytes.");
                }
            }
        }
        if (z) {
            bVar.c(i2 + i8);
        } else {
            bVar.e = 0;
        }
        this.g = i7;
        return true;
    }
}
