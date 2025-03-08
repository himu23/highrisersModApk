package com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls;

import android.os.Handler;
import android.text.TextUtils;
import android.util.SparseArray;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.d;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.h;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.c;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.a;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.e;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.m;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.n;
import com.fyber.inneractive.sdk.player.exoplayer2.i;
import com.fyber.inneractive.sdk.player.exoplayer2.source.f;
import com.fyber.inneractive.sdk.player.exoplayer2.source.o;
import com.fyber.inneractive.sdk.player.exoplayer2.source.p;
import com.fyber.inneractive.sdk.player.exoplayer2.source.r;
import com.fyber.inneractive.sdk.player.exoplayer2.source.s;
import com.fyber.inneractive.sdk.player.exoplayer2.upstream.x;
import com.ironsource.m2;
import java.io.IOException;
import java.util.LinkedList;

public final class j implements x.a<com.fyber.inneractive.sdk.player.exoplayer2.source.chunk.a>, p, h, d.C0115d {
    public final int a;
    public final b b;
    public final c c;
    public final com.fyber.inneractive.sdk.player.exoplayer2.upstream.b d;
    public final i e;
    public final int f;
    public final x g = new x("Loader:HlsSampleStreamWrapper");
    public final f.a h;
    public final c.b i = new c.b();
    public final SparseArray<d> j = new SparseArray<>();
    public final LinkedList<f> k = new LinkedList<>();
    public final Runnable l = new a();
    public final Handler m = new Handler();
    public boolean n;
    public boolean o;
    public int p;
    public i q;
    public int r;
    public boolean s;
    public s t;
    public int u;
    public boolean[] v;
    public long w;
    public long x;
    public boolean y;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            j.this.i();
        }
    }

    public interface b {
    }

    public j(int i2, b bVar, c cVar, com.fyber.inneractive.sdk.player.exoplayer2.upstream.b bVar2, long j2, i iVar, int i3, f.a aVar) {
        this.a = i2;
        this.b = bVar;
        this.c = cVar;
        this.d = bVar2;
        this.e = iVar;
        this.f = i3;
        this.h = aVar;
        this.w = j2;
        this.x = j2;
    }

    public void a(m mVar) {
    }

    public void a(x.c cVar, long j2, long j3, boolean z) {
        com.fyber.inneractive.sdk.player.exoplayer2.source.chunk.a aVar = (com.fyber.inneractive.sdk.player.exoplayer2.source.chunk.a) cVar;
        f.a aVar2 = this.h;
        com.fyber.inneractive.sdk.player.exoplayer2.upstream.j jVar = aVar.a;
        int i2 = aVar.b;
        int i3 = this.a;
        i iVar = aVar.c;
        int i4 = aVar.d;
        Object obj = aVar.e;
        long j4 = aVar.f;
        long j5 = aVar.g;
        long c2 = aVar.c();
        if (aVar2.b != null) {
            Handler handler = aVar2.a;
            com.fyber.inneractive.sdk.player.exoplayer2.source.c cVar2 = r2;
            com.fyber.inneractive.sdk.player.exoplayer2.source.c cVar3 = new com.fyber.inneractive.sdk.player.exoplayer2.source.c(aVar2, jVar, i2, i3, iVar, i4, obj, j4, j5, j2, j3, c2);
            handler.post(cVar2);
        }
        if (!z) {
            int size = this.j.size();
            for (int i5 = 0; i5 < size; i5++) {
                this.j.valueAt(i5).a(this.v[i5]);
            }
            ((g) this.b).a((p) this);
        }
    }

    public final boolean h() {
        return this.x != -9223372036854775807L;
    }

    public void j() throws IOException {
        this.g.c();
        c cVar = this.c;
        IOException iOException = cVar.j;
        if (iOException == null) {
            a.C0117a aVar = cVar.k;
            if (aVar != null) {
                e.a aVar2 = cVar.e.e.get(aVar);
                aVar2.b.c();
                IOException iOException2 = aVar2.j;
                if (iOException2 != null) {
                    throw iOException2;
                }
                return;
            }
            return;
        }
        throw iOException;
    }

    public void c() {
        this.n = true;
        this.m.post(this.l);
    }

    public void g() {
        if (!this.o) {
            a(this.w);
        }
    }

    public void d(long j2) {
        this.w = j2;
        this.x = j2;
        this.y = false;
        this.k.clear();
        if (this.g.b()) {
            this.g.a();
            return;
        }
        int size = this.j.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.j.valueAt(i2).a(this.v[i2]);
        }
    }

    public final void i() {
        if (!this.s && !this.o && this.n) {
            int size = this.j.size();
            int i2 = 0;
            while (i2 < size) {
                if (this.j.valueAt(i2).e() != null) {
                    i2++;
                } else {
                    return;
                }
            }
            int size2 = this.j.size();
            int i3 = 0;
            char c2 = 0;
            int i4 = -1;
            while (true) {
                char c3 = 3;
                if (i3 >= size2) {
                    break;
                }
                String str = this.j.valueAt(i3).e().f;
                if (!com.fyber.inneractive.sdk.player.exoplayer2.util.h.e(str)) {
                    if (com.fyber.inneractive.sdk.player.exoplayer2.util.h.d(str)) {
                        c3 = 2;
                    } else {
                        c3 = m2.h.K0.equals(com.fyber.inneractive.sdk.player.exoplayer2.util.h.b(str)) ? (char) 1 : 0;
                    }
                }
                if (c3 > c2) {
                    i4 = i3;
                    c2 = c3;
                } else if (c3 == c2 && i4 != -1) {
                    i4 = -1;
                }
                i3++;
            }
            r rVar = this.c.f;
            int i5 = rVar.a;
            this.u = -1;
            this.v = new boolean[size2];
            r[] rVarArr = new r[size2];
            for (int i6 = 0; i6 < size2; i6++) {
                i e2 = this.j.valueAt(i6).e();
                if (i6 == i4) {
                    i[] iVarArr = new i[i5];
                    for (int i7 = 0; i7 < i5; i7++) {
                        iVarArr[i7] = a(rVar.b[i7], e2);
                    }
                    rVarArr[i6] = new r(iVarArr);
                    this.u = i6;
                } else {
                    rVarArr[i6] = new r(a((c2 != 3 || !com.fyber.inneractive.sdk.player.exoplayer2.util.h.d(e2.f)) ? null : this.e, e2));
                }
            }
            this.t = new s(rVarArr);
            this.o = true;
            g gVar = (g) this.b;
            int i8 = gVar.k - 1;
            gVar.k = i8;
            if (i8 <= 0) {
                int i9 = 0;
                for (j jVar : gVar.n) {
                    i9 += jVar.t.a;
                }
                r[] rVarArr2 = new r[i9];
                int i10 = 0;
                for (j jVar2 : gVar.n) {
                    int i11 = jVar2.t.a;
                    int i12 = 0;
                    while (i12 < i11) {
                        rVarArr2[i10] = jVar2.t.b[i12];
                        i12++;
                        i10++;
                    }
                }
                gVar.m = new s(rVarArr2);
                ((com.fyber.inneractive.sdk.player.exoplayer2.h) gVar.j).f.obtainMessage(8, gVar).sendToTarget();
            }
        }
    }

    public void a(x.c cVar, long j2, long j3) {
        com.fyber.inneractive.sdk.player.exoplayer2.source.chunk.a aVar = (com.fyber.inneractive.sdk.player.exoplayer2.source.chunk.a) cVar;
        c cVar2 = this.c;
        cVar2.getClass();
        if (aVar instanceof c.a) {
            c.a aVar2 = (c.a) aVar;
            cVar2.i = aVar2.i;
            cVar2.a(aVar2.a.a, aVar2.l, aVar2.m);
        }
        f.a aVar3 = this.h;
        com.fyber.inneractive.sdk.player.exoplayer2.upstream.j jVar = aVar.a;
        int i2 = aVar.b;
        int i3 = this.a;
        i iVar = aVar.c;
        int i4 = aVar.d;
        Object obj = aVar.e;
        long j4 = aVar.f;
        long j5 = aVar.g;
        long c2 = aVar.c();
        if (aVar3.b != null) {
            aVar3.a.post(new com.fyber.inneractive.sdk.player.exoplayer2.source.b(aVar3, jVar, i2, i3, iVar, i4, obj, j4, j5, j2, j3, c2));
        }
        if (!this.o) {
            a(this.w);
        } else {
            ((g) this.b).a((p) this);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a4 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int a(com.fyber.inneractive.sdk.player.exoplayer2.upstream.x.c r30, long r31, long r33, java.io.IOException r35) {
        /*
            r29 = this;
            r0 = r29
            r1 = r30
            com.fyber.inneractive.sdk.player.exoplayer2.source.chunk.a r1 = (com.fyber.inneractive.sdk.player.exoplayer2.source.chunk.a) r1
            long r2 = r1.c()
            boolean r4 = r1 instanceof com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.f
            r5 = 1
            if (r4 == 0) goto L_0x0018
            r7 = 0
            int r9 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r9 != 0) goto L_0x0016
            goto L_0x0018
        L_0x0016:
            r2 = 0
            goto L_0x0019
        L_0x0018:
            r2 = 1
        L_0x0019:
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.c r3 = r0.c
            r3.getClass()
            if (r2 == 0) goto L_0x0058
            com.fyber.inneractive.sdk.player.exoplayer2.trackselection.e r2 = r3.p
            com.fyber.inneractive.sdk.player.exoplayer2.source.r r3 = r3.f
            com.fyber.inneractive.sdk.player.exoplayer2.i r7 = r1.c
            int r3 = r3.a((com.fyber.inneractive.sdk.player.exoplayer2.i) r7)
            int r3 = r2.c(r3)
            r7 = 60000(0xea60, double:2.9644E-319)
            r15 = r35
            boolean r2 = com.fyber.inneractive.sdk.player.exoplayer2.source.chunk.b.a(r2, r3, r15, r7)
            if (r2 == 0) goto L_0x005a
            if (r4 == 0) goto L_0x005b
            java.util.LinkedList<com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.f> r2 = r0.k
            java.lang.Object r2 = r2.removeLast()
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.f r2 = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.f) r2
            if (r2 != r1) goto L_0x0047
            r2 = 1
            goto L_0x0048
        L_0x0047:
            r2 = 0
        L_0x0048:
            com.fyber.inneractive.sdk.player.exoplayer2.util.a.b(r2)
            java.util.LinkedList<com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.f> r2 = r0.k
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x005b
            long r2 = r0.w
            r0.x = r2
            goto L_0x005b
        L_0x0058:
            r15 = r35
        L_0x005a:
            r5 = 0
        L_0x005b:
            com.fyber.inneractive.sdk.player.exoplayer2.source.f$a r10 = r0.h
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.j r11 = r1.a
            int r12 = r1.b
            int r13 = r0.a
            com.fyber.inneractive.sdk.player.exoplayer2.i r14 = r1.c
            int r2 = r1.d
            java.lang.Object r3 = r1.e
            long r7 = r1.f
            r17 = r7
            long r6 = r1.g
            long r25 = r1.c()
            com.fyber.inneractive.sdk.player.exoplayer2.source.f r1 = r10.b
            if (r1 == 0) goto L_0x008f
            android.os.Handler r1 = r10.a
            com.fyber.inneractive.sdk.player.exoplayer2.source.d r4 = new com.fyber.inneractive.sdk.player.exoplayer2.source.d
            r9 = r4
            r15 = r2
            r16 = r3
            r19 = r6
            r21 = r31
            r23 = r33
            r27 = r35
            r28 = r5
            r9.<init>(r10, r11, r12, r13, r14, r15, r16, r17, r19, r21, r23, r25, r27, r28)
            r1.post(r4)
        L_0x008f:
            if (r5 == 0) goto L_0x00a4
            boolean r1 = r0.o
            if (r1 != 0) goto L_0x009b
            long r1 = r0.w
            r0.a((long) r1)
            goto L_0x00a2
        L_0x009b:
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.j$b r1 = r0.b
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.g r1 = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.g) r1
            r1.a((com.fyber.inneractive.sdk.player.exoplayer2.source.p) r0)
        L_0x00a2:
            r6 = 2
            goto L_0x00a5
        L_0x00a4:
            r6 = 0
        L_0x00a5:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.j.a(com.fyber.inneractive.sdk.player.exoplayer2.upstream.x$c, long, long, java.io.IOException):int");
    }

    public /* bridge */ /* synthetic */ n a(int i2, int i3) {
        return a(i2);
    }

    public boolean a(com.fyber.inneractive.sdk.player.exoplayer2.trackselection.e[] eVarArr, boolean[] zArr, o[] oVarArr, boolean[] zArr2, boolean z) {
        com.fyber.inneractive.sdk.player.exoplayer2.trackselection.e eVar;
        com.fyber.inneractive.sdk.player.exoplayer2.util.a.b(this.o);
        for (int i2 = 0; i2 < eVarArr.length; i2++) {
            i iVar = oVarArr[i2];
            if (iVar != null && (eVarArr[i2] == null || !zArr[i2])) {
                int i3 = iVar.a;
                a(i3, false);
                this.j.valueAt(i3).b();
                oVarArr[i2] = null;
            }
        }
        com.fyber.inneractive.sdk.player.exoplayer2.trackselection.e eVar2 = null;
        boolean z2 = false;
        for (int i4 = 0; i4 < eVarArr.length; i4++) {
            if (oVarArr[i4] == null && (eVar = eVarArr[i4]) != null) {
                int a2 = this.t.a(eVar.b());
                a(a2, true);
                if (a2 == this.u) {
                    this.c.p = eVar;
                    eVar2 = eVar;
                }
                oVarArr[i4] = new i(this, a2);
                zArr2[i4] = true;
                z2 = true;
            }
        }
        if (z) {
            int size = this.j.size();
            for (int i5 = 0; i5 < size; i5++) {
                if (!this.v[i5]) {
                    this.j.valueAt(i5).b();
                }
            }
            if (eVar2 != null && !this.k.isEmpty()) {
                eVar2.a(0);
                if (eVar2.a() != this.c.f.a(this.k.getLast().c)) {
                    d(this.w);
                }
            }
        }
        if (this.p == 0) {
            this.c.j = null;
            this.q = null;
            this.k.clear();
            if (this.g.b()) {
                this.g.a();
            }
        }
        return z2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:61:0x0105  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x010e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(long r38) {
        /*
            r37 = this;
            r0 = r37
            boolean r1 = r0.y
            if (r1 != 0) goto L_0x02fa
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.x r1 = r0.g
            boolean r1 = r1.b()
            if (r1 == 0) goto L_0x0010
            goto L_0x02fa
        L_0x0010:
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.c r1 = r0.c
            java.util.LinkedList<com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.f> r3 = r0.k
            boolean r3 = r3.isEmpty()
            r4 = 0
            if (r3 == 0) goto L_0x001d
            r3 = r4
            goto L_0x0025
        L_0x001d:
            java.util.LinkedList<com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.f> r3 = r0.k
            java.lang.Object r3 = r3.getLast()
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.f r3 = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.f) r3
        L_0x0025:
            long r5 = r0.x
            r13 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r7 = (r5 > r13 ? 1 : (r5 == r13 ? 0 : -1))
            if (r7 == 0) goto L_0x0031
            goto L_0x0033
        L_0x0031:
            r5 = r38
        L_0x0033:
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.c$b r9 = r0.i
            if (r3 != 0) goto L_0x0039
            r7 = -1
            goto L_0x0041
        L_0x0039:
            com.fyber.inneractive.sdk.player.exoplayer2.source.r r7 = r1.f
            com.fyber.inneractive.sdk.player.exoplayer2.i r8 = r3.c
            int r7 = r7.a((com.fyber.inneractive.sdk.player.exoplayer2.i) r8)
        L_0x0041:
            r1.k = r4
            r10 = 0
            if (r3 != 0) goto L_0x0048
            goto L_0x004f
        L_0x0048:
            long r13 = r3.f
            long r13 = r13 - r5
            long r10 = java.lang.Math.max(r10, r13)
        L_0x004f:
            com.fyber.inneractive.sdk.player.exoplayer2.trackselection.e r8 = r1.p
            r8.a((long) r10)
            com.fyber.inneractive.sdk.player.exoplayer2.trackselection.e r8 = r1.p
            int r8 = r8.a()
            r13 = 1
            if (r7 == r8) goto L_0x005f
            r10 = 1
            goto L_0x0060
        L_0x005f:
            r10 = 0
        L_0x0060:
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.a$a[] r11 = r1.d
            r11 = r11[r8]
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.e r12 = r1.e
            boolean r12 = r12.b((com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.a.C0117a) r11)
            if (r12 != 0) goto L_0x0072
            r9.c = r11
            r1.k = r11
            goto L_0x0254
        L_0x0072:
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.e r12 = r1.e
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.b r12 = r12.a((com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.a.C0117a) r11)
            if (r3 == 0) goto L_0x0085
            if (r10 == 0) goto L_0x007d
            goto L_0x0085
        L_0x007d:
            int r5 = r3.i
            int r5 = r5 + r13
            r14 = r5
        L_0x0081:
            r7 = r8
            r2 = r11
            goto L_0x0101
        L_0x0085:
            if (r3 != 0) goto L_0x0088
            goto L_0x008a
        L_0x0088:
            long r5 = r3.f
        L_0x008a:
            boolean r10 = r12.j
            if (r10 != 0) goto L_0x00a8
            long r14 = r12.d
            r21 = r3
            long r2 = r12.o
            long r14 = r14 + r2
            int r2 = (r5 > r14 ? 1 : (r5 == r14 ? 0 : -1))
            if (r2 <= 0) goto L_0x00aa
            int r2 = r12.g
            java.util.List<com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.b$a> r3 = r12.m
            int r3 = r3.size()
            int r2 = r2 + r3
            r14 = r2
            r7 = r8
            r2 = r11
            r3 = r21
            goto L_0x0101
        L_0x00a8:
            r21 = r3
        L_0x00aa:
            java.util.List<com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.b$a> r2 = r12.m
            long r14 = r12.d
            long r5 = r5 - r14
            java.lang.Long r3 = java.lang.Long.valueOf(r5)
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.e r5 = r1.e
            boolean r5 = r5.n
            if (r5 == 0) goto L_0x00be
            if (r21 != 0) goto L_0x00bc
            goto L_0x00be
        L_0x00bc:
            r5 = 0
            goto L_0x00bf
        L_0x00be:
            r5 = 1
        L_0x00bf:
            int r6 = com.fyber.inneractive.sdk.player.exoplayer2.util.u.a
            int r6 = java.util.Collections.binarySearch(r2, r3)
            if (r6 >= 0) goto L_0x00cb
            int r6 = r6 + 2
            int r2 = -r6
            goto L_0x00de
        L_0x00cb:
            int r10 = r6 + -1
            if (r10 < 0) goto L_0x00dd
            java.lang.Object r14 = r2.get(r10)
            java.lang.Comparable r14 = (java.lang.Comparable) r14
            int r14 = r14.compareTo(r3)
            if (r14 != 0) goto L_0x00dd
            r6 = r10
            goto L_0x00cb
        L_0x00dd:
            r2 = r6
        L_0x00de:
            if (r5 == 0) goto L_0x00e5
            r3 = 0
            int r2 = java.lang.Math.max(r3, r2)
        L_0x00e5:
            int r3 = r12.g
            int r2 = r2 + r3
            if (r2 >= r3) goto L_0x00fd
            if (r21 == 0) goto L_0x00fd
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.a$a[] r2 = r1.d
            r2 = r2[r7]
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.e r3 = r1.e
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.b r12 = r3.a((com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.a.C0117a) r2)
            r3 = r21
            int r5 = r3.i
            int r5 = r5 + r13
            r14 = r5
            goto L_0x0101
        L_0x00fd:
            r3 = r21
            r14 = r2
            goto L_0x0081
        L_0x0101:
            int r5 = r12.g
            if (r14 >= r5) goto L_0x010e
            com.fyber.inneractive.sdk.player.exoplayer2.source.g r2 = new com.fyber.inneractive.sdk.player.exoplayer2.source.g
            r2.<init>()
            r1.j = r2
            goto L_0x0254
        L_0x010e:
            int r5 = r14 - r5
            java.util.List<com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.b$a> r6 = r12.m
            int r6 = r6.size()
            if (r5 < r6) goto L_0x0126
            boolean r3 = r12.j
            if (r3 == 0) goto L_0x0120
            r9.b = r13
            goto L_0x0254
        L_0x0120:
            r9.c = r2
            r1.k = r2
            goto L_0x0254
        L_0x0126:
            java.util.List<com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.b$a> r6 = r12.m
            java.lang.Object r5 = r6.get(r5)
            r8 = r5
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.b$a r8 = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.b.a) r8
            boolean r5 = r8.e
            if (r5 == 0) goto L_0x019b
            java.lang.String r5 = r12.a
            java.lang.String r6 = r8.f
            android.net.Uri r5 = com.fyber.inneractive.sdk.player.exoplayer2.util.t.a(r5, r6)
            android.net.Uri r6 = r1.l
            boolean r6 = r5.equals(r6)
            if (r6 != 0) goto L_0x0189
            java.lang.String r2 = r8.g
            com.fyber.inneractive.sdk.player.exoplayer2.trackselection.e r3 = r1.p
            int r3 = r3.d()
            com.fyber.inneractive.sdk.player.exoplayer2.trackselection.e r6 = r1.p
            java.lang.Object r6 = r6.g()
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.j r8 = new com.fyber.inneractive.sdk.player.exoplayer2.upstream.j
            r27 = 0
            r29 = 0
            r31 = -1
            r33 = 0
            r34 = 1
            r26 = 0
            r24 = r8
            r25 = r5
            r24.<init>(r25, r26, r27, r29, r31, r33, r34)
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.c$a r5 = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.c$a
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.g r10 = r1.b
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.a$a[] r11 = r1.d
            r7 = r11[r7]
            com.fyber.inneractive.sdk.player.exoplayer2.i r7 = r7.b
            byte[] r1 = r1.i
            r24 = r5
            r25 = r10
            r26 = r8
            r27 = r7
            r28 = r3
            r29 = r6
            r30 = r1
            r31 = r2
            r24.<init>(r25, r26, r27, r28, r29, r30, r31)
            r9.a = r5
            goto L_0x0254
        L_0x0189:
            java.lang.String r6 = r8.g
            java.lang.String r7 = r1.n
            boolean r6 = com.fyber.inneractive.sdk.player.exoplayer2.util.u.a((java.lang.Object) r6, (java.lang.Object) r7)
            if (r6 != 0) goto L_0x01a3
            java.lang.String r6 = r8.g
            byte[] r7 = r1.m
            r1.a(r5, r6, r7)
            goto L_0x01a3
        L_0x019b:
            r1.l = r4
            r1.m = r4
            r1.n = r4
            r1.o = r4
        L_0x01a3:
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.b$a r5 = r12.l
            if (r5 == 0) goto L_0x01ca
            java.lang.String r6 = r12.a
            java.lang.String r7 = r5.a
            android.net.Uri r25 = com.fyber.inneractive.sdk.player.exoplayer2.util.t.a(r6, r7)
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.j r6 = new com.fyber.inneractive.sdk.player.exoplayer2.upstream.j
            long r10 = r5.h
            r20 = r14
            long r13 = r5.i
            r33 = 0
            r34 = 0
            r26 = 0
            r24 = r6
            r27 = r10
            r29 = r10
            r31 = r13
            r24.<init>(r25, r26, r27, r29, r31, r33, r34)
            r13 = r6
            goto L_0x01cd
        L_0x01ca:
            r20 = r14
            r13 = r4
        L_0x01cd:
            long r5 = r12.d
            long r10 = r8.d
            long r24 = r5 + r10
            int r5 = r12.f
            int r6 = r8.c
            int r14 = r5 + r6
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.k r5 = r1.c
            android.util.SparseArray<com.fyber.inneractive.sdk.player.exoplayer2.util.r> r6 = r5.a
            java.lang.Object r6 = r6.get(r14)
            com.fyber.inneractive.sdk.player.exoplayer2.util.r r6 = (com.fyber.inneractive.sdk.player.exoplayer2.util.r) r6
            if (r6 != 0) goto L_0x01f4
            com.fyber.inneractive.sdk.player.exoplayer2.util.r r6 = new com.fyber.inneractive.sdk.player.exoplayer2.util.r
            r10 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r6.<init>(r10)
            android.util.SparseArray<com.fyber.inneractive.sdk.player.exoplayer2.util.r> r5 = r5.a
            r5.put(r14, r6)
        L_0x01f4:
            r21 = r6
            java.lang.String r5 = r12.a
            java.lang.String r6 = r8.a
            android.net.Uri r27 = com.fyber.inneractive.sdk.player.exoplayer2.util.t.a(r5, r6)
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.j r26 = new com.fyber.inneractive.sdk.player.exoplayer2.upstream.j
            r7 = r26
            long r5 = r8.h
            long r10 = r8.i
            r35 = 0
            r36 = 0
            r28 = 0
            r29 = r5
            r31 = r5
            r33 = r10
            r26.<init>(r27, r28, r29, r31, r33, r35, r36)
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.f r15 = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.f
            r5 = r15
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.g r6 = r1.a
            java.util.List<com.fyber.inneractive.sdk.player.exoplayer2.i> r10 = r1.g
            com.fyber.inneractive.sdk.player.exoplayer2.trackselection.e r11 = r1.p
            int r11 = r11.d()
            com.fyber.inneractive.sdk.player.exoplayer2.trackselection.e r12 = r1.p
            java.lang.Object r12 = r12.g()
            r39 = r5
            long r4 = r8.b
            long r4 = r24 + r4
            r8 = r15
            r15 = r4
            boolean r4 = r1.h
            r19 = r4
            byte[] r4 = r1.m
            r22 = r4
            byte[] r1 = r1.o
            r23 = r1
            r1 = r8
            r8 = r13
            r4 = r9
            r9 = r2
            r5 = r14
            r2 = r20
            r13 = r24
            r17 = r2
            r18 = r5
            r20 = r21
            r21 = r3
            r5 = r39
            r5.<init>(r6, r7, r8, r9, r10, r11, r12, r13, r15, r17, r18, r19, r20, r21, r22, r23)
            r4.a = r1
        L_0x0254:
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.c$b r1 = r0.i
            boolean r2 = r1.b
            com.fyber.inneractive.sdk.player.exoplayer2.source.chunk.a r3 = r1.a
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.a$a r4 = r1.c
            r5 = 0
            r1.a = r5
            r6 = 0
            r1.b = r6
            r1.c = r5
            if (r2 == 0) goto L_0x026a
            r1 = 1
            r0.y = r1
            return r1
        L_0x026a:
            r1 = 1
            if (r3 != 0) goto L_0x0282
            if (r4 == 0) goto L_0x0280
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.j$b r1 = r0.b
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.g r1 = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.g) r1
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.e r1 = r1.a
            java.util.IdentityHashMap<com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.a$a, com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.e$a> r1 = r1.e
            java.lang.Object r1 = r1.get(r4)
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.e$a r1 = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.e.a) r1
            r1.b()
        L_0x0280:
            r1 = 0
            return r1
        L_0x0282:
            boolean r2 = r3 instanceof com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.f
            if (r2 == 0) goto L_0x02cd
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r0.x = r4
            r2 = r3
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.f r2 = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.f) r2
            r2.D = r0
            int r4 = r2.j
            boolean r5 = r2.t
            r0.r = r4
            r6 = 0
        L_0x0299:
            android.util.SparseArray<com.fyber.inneractive.sdk.player.exoplayer2.extractor.d> r7 = r0.j
            int r7 = r7.size()
            if (r6 >= r7) goto L_0x02b0
            android.util.SparseArray<com.fyber.inneractive.sdk.player.exoplayer2.extractor.d> r7 = r0.j
            java.lang.Object r7 = r7.valueAt(r6)
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.d r7 = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.d) r7
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.d$c r7 = r7.c
            r7.r = r4
            int r6 = r6 + 1
            goto L_0x0299
        L_0x02b0:
            if (r5 == 0) goto L_0x02c8
            r4 = 0
        L_0x02b3:
            android.util.SparseArray<com.fyber.inneractive.sdk.player.exoplayer2.extractor.d> r5 = r0.j
            int r5 = r5.size()
            if (r4 >= r5) goto L_0x02c8
            android.util.SparseArray<com.fyber.inneractive.sdk.player.exoplayer2.extractor.d> r5 = r0.j
            java.lang.Object r5 = r5.valueAt(r4)
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.d r5 = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.d) r5
            r5.m = r1
            int r4 = r4 + 1
            goto L_0x02b3
        L_0x02c8:
            java.util.LinkedList<com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.f> r4 = r0.k
            r4.add(r2)
        L_0x02cd:
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.x r2 = r0.g
            int r4 = r0.f
            long r17 = r2.a(r3, r0, r4)
            com.fyber.inneractive.sdk.player.exoplayer2.source.f$a r6 = r0.h
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.j r7 = r3.a
            int r8 = r3.b
            int r9 = r0.a
            com.fyber.inneractive.sdk.player.exoplayer2.i r10 = r3.c
            int r11 = r3.d
            java.lang.Object r12 = r3.e
            long r13 = r3.f
            long r2 = r3.g
            com.fyber.inneractive.sdk.player.exoplayer2.source.f r4 = r6.b
            if (r4 == 0) goto L_0x02f9
            android.os.Handler r4 = r6.a
            com.fyber.inneractive.sdk.player.exoplayer2.source.a r15 = new com.fyber.inneractive.sdk.player.exoplayer2.source.a
            r5 = r15
            r1 = r15
            r15 = r2
            r5.<init>(r6, r7, r8, r9, r10, r11, r12, r13, r15, r17)
            r4.post(r1)
            r1 = 1
        L_0x02f9:
            return r1
        L_0x02fa:
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.j.a(long):boolean");
    }

    public long a() {
        if (h()) {
            return this.x;
        }
        if (this.y) {
            return Long.MIN_VALUE;
        }
        return this.k.getLast().g;
    }

    public d a(int i2) {
        if (this.j.indexOfKey(i2) >= 0) {
            return this.j.get(i2);
        }
        d dVar = new d(this.d);
        dVar.n = this;
        dVar.c.r = this.r;
        this.j.put(i2, dVar);
        return dVar;
    }

    public void a(i iVar) {
        this.m.post(this.l);
    }

    public final void a(int i2, boolean z) {
        int i3 = 1;
        com.fyber.inneractive.sdk.player.exoplayer2.util.a.b(this.v[i2] != z);
        this.v[i2] = z;
        int i4 = this.p;
        if (!z) {
            i3 = -1;
        }
        this.p = i4 + i3;
    }

    public static i a(i iVar, i iVar2) {
        String str;
        i iVar3 = iVar;
        i iVar4 = iVar2;
        if (iVar3 == null) {
            return iVar4;
        }
        int c2 = com.fyber.inneractive.sdk.player.exoplayer2.util.h.c(iVar4.f);
        if (c2 == 1) {
            str = a(iVar3.c, 1);
        } else {
            str = c2 == 2 ? a(iVar3.c, 2) : null;
        }
        return new i(iVar3.a, iVar4.e, iVar4.f, str, iVar3.b, iVar4.g, iVar3.j, iVar3.k, iVar4.l, iVar4.m, iVar4.n, iVar4.p, iVar4.o, iVar4.q, iVar4.r, iVar4.s, iVar4.t, iVar4.u, iVar4.v, iVar3.x, iVar3.y, iVar4.z, iVar4.w, iVar4.h, iVar4.i, iVar4.d);
    }

    public static String a(String str, int i2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split("(\\s*,\\s*)|(\\s*$)");
        StringBuilder sb = new StringBuilder();
        for (String str2 : split) {
            if (i2 == com.fyber.inneractive.sdk.player.exoplayer2.util.h.c(com.fyber.inneractive.sdk.player.exoplayer2.util.h.a(str2))) {
                if (sb.length() > 0) {
                    sb.append(",");
                }
                sb.append(str2);
            }
        }
        if (sb.length() > 0) {
            return sb.toString();
        }
        return null;
    }
}
