package com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.f;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.g;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.h;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.m;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.v;
import com.fyber.inneractive.sdk.player.exoplayer2.util.j;
import com.fyber.inneractive.sdk.player.exoplayer2.util.k;
import com.fyber.inneractive.sdk.player.exoplayer2.util.r;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class u implements f {
    public static final long l = ((long) com.fyber.inneractive.sdk.player.exoplayer2.util.u.a("AC-3"));
    public static final long m = ((long) com.fyber.inneractive.sdk.player.exoplayer2.util.u.a("EAC3"));
    public static final long n = ((long) com.fyber.inneractive.sdk.player.exoplayer2.util.u.a("HEVC"));
    public final int a;
    public final List<r> b;
    public final k c;
    public final SparseIntArray d;
    public final v.c e;
    public final SparseArray<v> f;
    public final SparseBooleanArray g;
    public h h;
    public int i;
    public boolean j;
    public v k;

    public class a implements q {
        public final j a = new j(new byte[4]);

        public a() {
        }

        public void a(k kVar) {
            if (kVar.l() == 0) {
                kVar.f(7);
                int a2 = kVar.a() / 4;
                for (int i = 0; i < a2; i++) {
                    kVar.a(this.a, 4);
                    int a3 = this.a.a(16);
                    this.a.c(3);
                    if (a3 == 0) {
                        this.a.c(13);
                    } else {
                        int a4 = this.a.a(13);
                        u uVar = u.this;
                        uVar.f.put(a4, new r(new b(a4)));
                        u.this.i++;
                    }
                }
                u uVar2 = u.this;
                if (uVar2.a != 2) {
                    uVar2.f.remove(0);
                }
            }
        }

        public void a(r rVar, h hVar, v.d dVar) {
        }
    }

    public class b implements q {
        public final j a = new j(new byte[5]);
        public final SparseArray<v> b = new SparseArray<>();
        public final SparseIntArray c = new SparseIntArray();
        public final int d;

        public b(int i) {
            this.d = i;
        }

        /* JADX WARNING: Removed duplicated region for block: B:69:0x01f9  */
        /* JADX WARNING: Removed duplicated region for block: B:71:0x0206  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void a(com.fyber.inneractive.sdk.player.exoplayer2.util.k r25) {
            /*
                r24 = this;
                r0 = r24
                r1 = r25
                int r2 = r25.l()
                r3 = 2
                if (r2 == r3) goto L_0x000c
                return
            L_0x000c:
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.u r2 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.u.this
                int r4 = r2.a
                r5 = 0
                r6 = 1
                if (r4 == r6) goto L_0x0032
                if (r4 == r3) goto L_0x0032
                int r4 = r2.i
                if (r4 != r6) goto L_0x001b
                goto L_0x0032
            L_0x001b:
                com.fyber.inneractive.sdk.player.exoplayer2.util.r r4 = new com.fyber.inneractive.sdk.player.exoplayer2.util.r
                java.util.List<com.fyber.inneractive.sdk.player.exoplayer2.util.r> r2 = r2.b
                java.lang.Object r2 = r2.get(r5)
                com.fyber.inneractive.sdk.player.exoplayer2.util.r r2 = (com.fyber.inneractive.sdk.player.exoplayer2.util.r) r2
                long r7 = r2.a
                r4.<init>(r7)
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.u r2 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.u.this
                java.util.List<com.fyber.inneractive.sdk.player.exoplayer2.util.r> r2 = r2.b
                r2.add(r4)
                goto L_0x003b
            L_0x0032:
                java.util.List<com.fyber.inneractive.sdk.player.exoplayer2.util.r> r2 = r2.b
                java.lang.Object r2 = r2.get(r5)
                r4 = r2
                com.fyber.inneractive.sdk.player.exoplayer2.util.r r4 = (com.fyber.inneractive.sdk.player.exoplayer2.util.r) r4
            L_0x003b:
                r1.f(r3)
                int r2 = r25.q()
                r7 = 5
                r1.f(r7)
                com.fyber.inneractive.sdk.player.exoplayer2.util.j r8 = r0.a
                r1.a((com.fyber.inneractive.sdk.player.exoplayer2.util.j) r8, (int) r3)
                com.fyber.inneractive.sdk.player.exoplayer2.util.j r8 = r0.a
                r9 = 4
                r8.c(r9)
                com.fyber.inneractive.sdk.player.exoplayer2.util.j r8 = r0.a
                r10 = 12
                int r8 = r8.a(r10)
                r1.f(r8)
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.u r8 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.u.this
                int r11 = r8.a
                r12 = 8192(0x2000, float:1.14794E-41)
                r13 = 0
                r14 = 21
                if (r11 != r3) goto L_0x008a
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.v r8 = r8.k
                if (r8 != 0) goto L_0x008a
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.v$b r8 = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.v$b
                byte[] r11 = new byte[r5]
                r8.<init>(r14, r13, r13, r11)
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.u r11 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.u.this
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.v$c r15 = r11.e
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.v r8 = r15.a(r14, r8)
                r11.k = r8
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.u r8 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.u.this
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.v r11 = r8.k
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.h r8 = r8.h
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.v$d r15 = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.v$d
                r15.<init>(r2, r14, r12)
                r11.a(r4, r8, r15)
            L_0x008a:
                android.util.SparseArray<com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.v> r8 = r0.b
                r8.clear()
                android.util.SparseIntArray r8 = r0.c
                r8.clear()
                int r8 = r25.a()
            L_0x0098:
                if (r8 <= 0) goto L_0x0225
                com.fyber.inneractive.sdk.player.exoplayer2.util.j r11 = r0.a
                r1.a((com.fyber.inneractive.sdk.player.exoplayer2.util.j) r11, (int) r7)
                com.fyber.inneractive.sdk.player.exoplayer2.util.j r11 = r0.a
                r15 = 8
                int r11 = r11.a(r15)
                com.fyber.inneractive.sdk.player.exoplayer2.util.j r15 = r0.a
                r13 = 3
                r15.c(r13)
                com.fyber.inneractive.sdk.player.exoplayer2.util.j r15 = r0.a
                r6 = 13
                int r6 = r15.a(r6)
                com.fyber.inneractive.sdk.player.exoplayer2.util.j r15 = r0.a
                r15.c(r9)
                com.fyber.inneractive.sdk.player.exoplayer2.util.j r15 = r0.a
                int r15 = r15.a(r10)
                int r10 = r1.b
                int r12 = r10 + r15
                r16 = -1
                r3 = 0
                r14 = -1
                r17 = 0
            L_0x00ca:
                int r5 = r1.b
                if (r5 >= r12) goto L_0x01a8
                int r5 = r25.l()
                int r18 = r25.l()
                int r9 = r1.b
                int r9 = r9 + r18
                if (r5 != r7) goto L_0x0101
                long r20 = r25.m()
                long r22 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.u.l
                int r5 = (r20 > r22 ? 1 : (r20 == r22 ? 0 : -1))
                if (r5 != 0) goto L_0x00e7
                goto L_0x0105
            L_0x00e7:
                long r22 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.u.m
                int r5 = (r20 > r22 ? 1 : (r20 == r22 ? 0 : -1))
                if (r5 != 0) goto L_0x00ee
                goto L_0x0116
            L_0x00ee:
                long r22 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.u.n
                int r5 = (r20 > r22 ? 1 : (r20 == r22 ? 0 : -1))
                if (r5 != 0) goto L_0x013f
                r5 = 36
                r22 = r2
                r19 = r4
                r23 = r6
                r13 = 4
                r14 = 36
                goto L_0x0195
            L_0x0101:
                r7 = 106(0x6a, float:1.49E-43)
                if (r5 != r7) goto L_0x0112
            L_0x0105:
                r5 = 129(0x81, float:1.81E-43)
                r22 = r2
                r19 = r4
                r23 = r6
                r13 = 4
                r14 = 129(0x81, float:1.81E-43)
                goto L_0x0195
            L_0x0112:
                r7 = 122(0x7a, float:1.71E-43)
                if (r5 != r7) goto L_0x0123
            L_0x0116:
                r5 = 135(0x87, float:1.89E-43)
                r22 = r2
                r19 = r4
                r23 = r6
                r13 = 4
                r14 = 135(0x87, float:1.89E-43)
                goto L_0x0195
            L_0x0123:
                r7 = 123(0x7b, float:1.72E-43)
                if (r5 != r7) goto L_0x0133
                r5 = 138(0x8a, float:1.93E-43)
                r22 = r2
                r19 = r4
                r23 = r6
                r13 = 4
                r14 = 138(0x8a, float:1.93E-43)
                goto L_0x0195
            L_0x0133:
                r7 = 10
                if (r5 != r7) goto L_0x0147
                java.lang.String r3 = r1.b(r13)
                java.lang.String r3 = r3.trim()
            L_0x013f:
                r22 = r2
                r19 = r4
                r23 = r6
                r13 = 4
                goto L_0x0195
            L_0x0147:
                r7 = 89
                if (r5 != r7) goto L_0x013f
                java.util.ArrayList r5 = new java.util.ArrayList
                r5.<init>()
            L_0x0150:
                int r14 = r1.b
                if (r14 >= r9) goto L_0x018a
                java.lang.String r14 = r1.b(r13)
                java.lang.String r14 = r14.trim()
                int r7 = r25.l()
                r19 = r4
                r13 = 4
                byte[] r4 = new byte[r13]
                r22 = r2
                byte[] r2 = r1.a
                r23 = r6
                int r6 = r1.b
                r0 = 0
                java.lang.System.arraycopy(r2, r6, r4, r0, r13)
                int r0 = r1.b
                int r0 = r0 + r13
                r1.b = r0
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.v$a r0 = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.v$a
                r0.<init>(r14, r7, r4)
                r5.add(r0)
                r0 = r24
                r4 = r19
                r2 = r22
                r6 = r23
                r7 = 89
                r13 = 3
                goto L_0x0150
            L_0x018a:
                r22 = r2
                r19 = r4
                r23 = r6
                r13 = 4
                r17 = r5
                r14 = 89
            L_0x0195:
                int r0 = r1.b
                int r9 = r9 - r0
                r1.f(r9)
                r0 = r24
                r4 = r19
                r2 = r22
                r6 = r23
                r7 = 5
                r9 = 4
                r13 = 3
                goto L_0x00ca
            L_0x01a8:
                r22 = r2
                r19 = r4
                r23 = r6
                r13 = 4
                r1.e(r12)
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.v$b r0 = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.v$b
                byte[] r2 = r1.a
                byte[] r2 = java.util.Arrays.copyOfRange(r2, r10, r12)
                r4 = r17
                r0.<init>(r14, r3, r4, r2)
                r2 = 6
                if (r11 != r2) goto L_0x01c3
                r11 = r14
            L_0x01c3:
                int r15 = r15 + 5
                int r8 = r8 - r15
                r2 = r24
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.u r3 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.u.this
                int r4 = r3.a
                r5 = 2
                if (r4 != r5) goto L_0x01d1
                r4 = r11
                goto L_0x01d3
            L_0x01d1:
                r4 = r23
            L_0x01d3:
                android.util.SparseBooleanArray r3 = r3.g
                boolean r3 = r3.get(r4)
                if (r3 == 0) goto L_0x01de
                r6 = 21
                goto L_0x0212
            L_0x01de:
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.u r3 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.u.this
                int r6 = r3.a
                if (r6 != r5) goto L_0x01eb
                r6 = 21
                if (r11 != r6) goto L_0x01ed
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.v r0 = r3.k
                goto L_0x01f3
            L_0x01eb:
                r6 = 21
            L_0x01ed:
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.v$c r3 = r3.e
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.v r0 = r3.a(r11, r0)
            L_0x01f3:
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.u r3 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.u.this
                int r3 = r3.a
                if (r3 != r5) goto L_0x0206
                android.util.SparseIntArray r3 = r2.c
                r5 = 8192(0x2000, float:1.14794E-41)
                int r3 = r3.get(r4, r5)
                r5 = r23
                if (r5 >= r3) goto L_0x0212
                goto L_0x0208
            L_0x0206:
                r5 = r23
            L_0x0208:
                android.util.SparseIntArray r3 = r2.c
                r3.put(r4, r5)
                android.util.SparseArray<com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.v> r3 = r2.b
                r3.put(r4, r0)
            L_0x0212:
                r0 = r2
                r4 = r19
                r2 = r22
                r3 = 2
                r5 = 0
                r6 = 1
                r7 = 5
                r9 = 4
                r10 = 12
                r12 = 8192(0x2000, float:1.14794E-41)
                r13 = 0
                r14 = 21
                goto L_0x0098
            L_0x0225:
                r22 = r2
                r19 = r4
                r2 = r0
                android.util.SparseIntArray r0 = r2.c
                int r0 = r0.size()
                r1 = 0
            L_0x0231:
                if (r1 >= r0) goto L_0x0283
                android.util.SparseIntArray r3 = r2.c
                int r3 = r3.keyAt(r1)
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.u r4 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.u.this
                android.util.SparseBooleanArray r4 = r4.g
                r5 = 1
                r4.put(r3, r5)
                android.util.SparseArray<com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.v> r4 = r2.b
                java.lang.Object r4 = r4.valueAt(r1)
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.v r4 = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.v) r4
                if (r4 == 0) goto L_0x0276
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.u r5 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.u.this
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.v r6 = r5.k
                if (r4 == r6) goto L_0x0262
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.h r5 = r5.h
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.v$d r6 = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.v$d
                r7 = r22
                r8 = 8192(0x2000, float:1.14794E-41)
                r6.<init>(r7, r3, r8)
                r3 = r19
                r4.a(r3, r5, r6)
                goto L_0x0268
            L_0x0262:
                r3 = r19
                r7 = r22
                r8 = 8192(0x2000, float:1.14794E-41)
            L_0x0268:
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.u r5 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.u.this
                android.util.SparseArray<com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.v> r5 = r5.f
                android.util.SparseIntArray r6 = r2.c
                int r6 = r6.valueAt(r1)
                r5.put(r6, r4)
                goto L_0x027c
            L_0x0276:
                r3 = r19
                r7 = r22
                r8 = 8192(0x2000, float:1.14794E-41)
            L_0x027c:
                int r1 = r1 + 1
                r19 = r3
                r22 = r7
                goto L_0x0231
            L_0x0283:
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.u r0 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.u.this
                int r1 = r0.a
                r3 = 2
                if (r1 != r3) goto L_0x029d
                boolean r1 = r0.j
                if (r1 != 0) goto L_0x02c0
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.h r0 = r0.h
                r0.c()
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.u r0 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.u.this
                r1 = 0
                r0.i = r1
                r3 = 1
                boolean unused = r0.j = r3
                goto L_0x02c0
            L_0x029d:
                r1 = 0
                r3 = 1
                android.util.SparseArray<com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.v> r0 = r0.f
                int r4 = r2.d
                r0.remove(r4)
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.u r0 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.u.this
                int r4 = r0.a
                if (r4 != r3) goto L_0x02ae
                r5 = 0
                goto L_0x02b2
            L_0x02ae:
                int r1 = r0.i
                int r5 = r1 + -1
            L_0x02b2:
                r0.i = r5
                if (r5 != 0) goto L_0x02c0
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.h r0 = r0.h
                r0.c()
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.u r0 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.u.this
                boolean unused = r0.j = r3
            L_0x02c0:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.u.b.a(com.fyber.inneractive.sdk.player.exoplayer2.util.k):void");
        }

        public void a(r rVar, h hVar, v.d dVar) {
        }
    }

    public u(int i2, r rVar, v.c cVar) {
        this.e = (v.c) com.fyber.inneractive.sdk.player.exoplayer2.util.a.a(cVar);
        this.a = i2;
        if (i2 == 1 || i2 == 2) {
            this.b = Collections.singletonList(rVar);
        } else {
            ArrayList arrayList = new ArrayList();
            this.b = arrayList;
            arrayList.add(rVar);
        }
        this.c = new k(940);
        this.g = new SparseBooleanArray();
        this.f = new SparseArray<>();
        this.d = new SparseIntArray();
        a();
    }

    public void b() {
    }

    public boolean a(g gVar) throws IOException, InterruptedException {
        byte[] bArr = this.c.a;
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.b bVar = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) gVar;
        bVar.a(bArr, 0, 940, false);
        int i2 = 0;
        while (i2 < 188) {
            int i3 = 0;
            while (i3 != 5) {
                if (bArr[(i3 * 188) + i2] != 71) {
                    i2++;
                } else {
                    i3++;
                }
            }
            bVar.c(i2);
            return true;
        }
        return false;
    }

    public void a(h hVar) {
        this.h = hVar;
        hVar.a(new m.a(-9223372036854775807L));
    }

    public void a(long j2, long j3) {
        int size = this.b.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.b.get(i2).c = -9223372036854775807L;
        }
        this.c.r();
        this.d.clear();
        a();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00a8, code lost:
        if (r0 != ((r7 + 1) & 15)) goto L_0x00ac;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.g r10, com.fyber.inneractive.sdk.player.exoplayer2.extractor.l r11) throws java.io.IOException, java.lang.InterruptedException {
        /*
            r9 = this;
            com.fyber.inneractive.sdk.player.exoplayer2.util.k r11 = r9.c
            byte[] r0 = r11.a
            int r1 = r11.b
            int r1 = 940 - r1
            r2 = 0
            r3 = 188(0xbc, float:2.63E-43)
            if (r1 >= r3) goto L_0x001f
            int r11 = r11.a()
            if (r11 <= 0) goto L_0x001a
            com.fyber.inneractive.sdk.player.exoplayer2.util.k r1 = r9.c
            int r1 = r1.b
            java.lang.System.arraycopy(r0, r1, r0, r2, r11)
        L_0x001a:
            com.fyber.inneractive.sdk.player.exoplayer2.util.k r1 = r9.c
            r1.a((byte[]) r0, (int) r11)
        L_0x001f:
            com.fyber.inneractive.sdk.player.exoplayer2.util.k r11 = r9.c
            int r11 = r11.a()
            if (r11 >= r3) goto L_0x003f
            com.fyber.inneractive.sdk.player.exoplayer2.util.k r11 = r9.c
            int r11 = r11.c
            int r1 = 940 - r11
            r4 = r10
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.b r4 = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) r4
            int r1 = r4.a(r0, r11, r1)
            r4 = -1
            if (r1 != r4) goto L_0x0038
            return r4
        L_0x0038:
            com.fyber.inneractive.sdk.player.exoplayer2.util.k r4 = r9.c
            int r11 = r11 + r1
            r4.d(r11)
            goto L_0x001f
        L_0x003f:
            com.fyber.inneractive.sdk.player.exoplayer2.util.k r10 = r9.c
            int r11 = r10.c
            int r10 = r10.b
        L_0x0045:
            if (r10 >= r11) goto L_0x0050
            byte r1 = r0[r10]
            r4 = 71
            if (r1 == r4) goto L_0x0050
            int r10 = r10 + 1
            goto L_0x0045
        L_0x0050:
            com.fyber.inneractive.sdk.player.exoplayer2.util.k r0 = r9.c
            r0.e(r10)
            int r10 = r10 + r3
            if (r10 <= r11) goto L_0x0059
            return r2
        L_0x0059:
            com.fyber.inneractive.sdk.player.exoplayer2.util.k r0 = r9.c
            int r0 = r0.c()
            r1 = 8388608(0x800000, float:1.17549435E-38)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x006a
            com.fyber.inneractive.sdk.player.exoplayer2.util.k r11 = r9.c
            r11.e(r10)
            return r2
        L_0x006a:
            r1 = 4194304(0x400000, float:5.877472E-39)
            r1 = r1 & r0
            r3 = 1
            if (r1 == 0) goto L_0x0072
            r1 = 1
            goto L_0x0073
        L_0x0072:
            r1 = 0
        L_0x0073:
            r4 = 2096896(0x1fff00, float:2.938377E-39)
            r4 = r4 & r0
            int r4 = r4 >> 8
            r5 = r0 & 32
            if (r5 == 0) goto L_0x007f
            r5 = 1
            goto L_0x0080
        L_0x007f:
            r5 = 0
        L_0x0080:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0086
            r6 = 1
            goto L_0x0087
        L_0x0086:
            r6 = 0
        L_0x0087:
            int r7 = r9.a
            r8 = 2
            if (r7 == r8) goto L_0x00ab
            r0 = r0 & 15
            android.util.SparseIntArray r7 = r9.d
            int r8 = r0 + -1
            int r7 = r7.get(r4, r8)
            android.util.SparseIntArray r8 = r9.d
            r8.put(r4, r0)
            if (r7 != r0) goto L_0x00a5
            if (r6 == 0) goto L_0x00ab
            com.fyber.inneractive.sdk.player.exoplayer2.util.k r11 = r9.c
            r11.e(r10)
            return r2
        L_0x00a5:
            int r7 = r7 + r3
            r7 = r7 & 15
            if (r0 == r7) goto L_0x00ab
            goto L_0x00ac
        L_0x00ab:
            r3 = 0
        L_0x00ac:
            if (r5 == 0) goto L_0x00b9
            com.fyber.inneractive.sdk.player.exoplayer2.util.k r0 = r9.c
            int r0 = r0.l()
            com.fyber.inneractive.sdk.player.exoplayer2.util.k r5 = r9.c
            r5.f(r0)
        L_0x00b9:
            if (r6 == 0) goto L_0x00d9
            android.util.SparseArray<com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.v> r0 = r9.f
            java.lang.Object r0 = r0.get(r4)
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.v r0 = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.v) r0
            if (r0 == 0) goto L_0x00d9
            if (r3 == 0) goto L_0x00ca
            r0.a()
        L_0x00ca:
            com.fyber.inneractive.sdk.player.exoplayer2.util.k r3 = r9.c
            r3.d(r10)
            com.fyber.inneractive.sdk.player.exoplayer2.util.k r3 = r9.c
            r0.a(r3, r1)
            com.fyber.inneractive.sdk.player.exoplayer2.util.k r0 = r9.c
            r0.d(r11)
        L_0x00d9:
            com.fyber.inneractive.sdk.player.exoplayer2.util.k r11 = r9.c
            r11.e(r10)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.u.a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.g, com.fyber.inneractive.sdk.player.exoplayer2.extractor.l):int");
    }

    public final void a() {
        this.g.clear();
        this.f.clear();
        SparseArray<v> a2 = this.e.a();
        int size = a2.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f.put(a2.keyAt(i2), a2.valueAt(i2));
        }
        this.f.put(0, new r(new a()));
        this.k = null;
    }
}
