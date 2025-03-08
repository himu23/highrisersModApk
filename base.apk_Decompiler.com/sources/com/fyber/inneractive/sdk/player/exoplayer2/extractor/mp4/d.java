package com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4;

import android.util.Log;
import android.util.Pair;
import android.util.SparseArray;
import com.applovin.exoplayer2.common.base.Ascii;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.f;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.g;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.h;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.l;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.m;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.n;
import com.fyber.inneractive.sdk.player.exoplayer2.util.i;
import com.fyber.inneractive.sdk.player.exoplayer2.util.k;
import com.fyber.inneractive.sdk.player.exoplayer2.util.r;
import com.fyber.inneractive.sdk.player.exoplayer2.util.u;
import com.unity3d.services.core.device.MimeTypes;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public final class d implements f {
    public static final int D = u.a("seig");
    public static final byte[] E = {-94, 57, 79, 82, 90, -101, 79, Ascii.DC4, -94, 68, 108, 66, 124, 100, -115, -12};
    public n A;
    public n[] B;
    public boolean C;
    public final int a;
    public final SparseArray<b> b;
    public final k c;
    public final k d;
    public final k e;
    public final k f;
    public final r g;
    public final k h;
    public final byte[] i;
    public final Stack<a.C0120a> j;
    public final LinkedList<a> k;
    public int l;
    public int m;
    public long n;
    public int o;
    public k p;
    public long q;
    public int r;
    public long s;
    public long t;
    public b u;
    public int v;
    public int w;
    public int x;
    public boolean y;
    public h z;

    public static final class a {
        public final long a;
        public final int b;

        public a(long j, int i) {
            this.a = j;
            this.b = i;
        }
    }

    public d(int i2, r rVar) {
        this(i2, (r) null, (h) null);
    }

    public final void a() {
        this.l = 0;
        this.o = 0;
    }

    public void a(h hVar) {
        this.z = hVar;
    }

    public boolean a(g gVar) throws IOException, InterruptedException {
        return g.a(gVar, true);
    }

    public void b() {
    }

    public d(int i2, r rVar, h hVar) {
        this.a = i2;
        this.g = rVar;
        this.h = new k(16);
        this.c = new k(i.a);
        this.d = new k(5);
        this.e = new k();
        this.f = new k(1);
        this.i = new byte[16];
        this.j = new Stack<>();
        this.k = new LinkedList<>();
        this.b = new SparseArray<>();
        this.s = -9223372036854775807L;
        this.t = -9223372036854775807L;
        a();
    }

    public final void c() {
        if ((this.a & 4) != 0 && this.A == null) {
            n a2 = this.z.a(this.b.size(), 4);
            this.A = a2;
            a2.a(com.fyber.inneractive.sdk.player.exoplayer2.i.a((String) null, "application/x-emsg", Long.MAX_VALUE));
        }
        if ((this.a & 8) != 0 && this.B == null) {
            n a3 = this.z.a(this.b.size() + 1, 3);
            a3.a(com.fyber.inneractive.sdk.player.exoplayer2.i.a((String) null, "application/cea-608", (String) null, -1, 0, (String) null, (com.fyber.inneractive.sdk.player.exoplayer2.drm.a) null));
            this.B = new n[]{a3};
        }
    }

    public void a(long j2, long j3) {
        int size = this.b.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.b.valueAt(i2).a();
        }
        this.k.clear();
        this.r = 0;
        this.j.clear();
        a();
    }

    public static final class b {
        public final j a = new j();
        public final n b;
        public h c;
        public c d;
        public int e;
        public int f;
        public int g;

        public b(n nVar) {
            this.b = nVar;
        }

        public void a(h hVar, c cVar) {
            hVar.getClass();
            this.c = hVar;
            cVar.getClass();
            this.d = cVar;
            this.b.a(hVar.f);
            a();
        }

        public void a() {
            j jVar = this.a;
            jVar.d = 0;
            jVar.r = 0;
            jVar.l = false;
            jVar.q = false;
            jVar.n = null;
            this.e = 0;
            this.g = 0;
            this.f = 0;
        }
    }

    public int a(g gVar, l lVar) throws IOException, InterruptedException {
        g gVar2;
        long j2;
        long j3;
        byte b2;
        byte[] bArr;
        byte[] bArr2;
        int i2;
        boolean z2;
        int i3;
        loop0:
        while (true) {
            gVar2 = gVar;
            while (true) {
                int i4 = this.l;
                int i5 = 0;
                if (i4 == 0) {
                    if (this.o == 0) {
                        if (!((com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) gVar).b(this.h.a, 0, 8, true)) {
                            return -1;
                        }
                        this.o = 8;
                        this.h.e(0);
                        this.n = this.h.m();
                        this.m = this.h.c();
                    }
                    if (this.n == 1) {
                        ((com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) gVar).b(this.h.a, 8, 8, false);
                        this.o += 8;
                        this.n = this.h.p();
                    }
                    long j4 = this.n;
                    long j5 = (long) this.o;
                    if (j4 >= j5) {
                        com.fyber.inneractive.sdk.player.exoplayer2.extractor.b bVar = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) gVar;
                        long j6 = bVar.c - j5;
                        if (this.m == a.L) {
                            int size = this.b.size();
                            for (int i6 = 0; i6 < size; i6++) {
                                j jVar = this.b.valueAt(i6).a;
                                jVar.getClass();
                                jVar.c = j6;
                                jVar.b = j6;
                            }
                        }
                        int i7 = this.m;
                        if (i7 == a.i) {
                            this.u = null;
                            this.q = j6 + this.n;
                            if (!this.C) {
                                this.z.a(new m.a(this.s));
                                this.C = true;
                            }
                            this.l = 2;
                        } else if (i7 == a.C || i7 == a.E || i7 == a.F || i7 == a.G || i7 == a.H || i7 == a.L || i7 == a.M || i7 == a.N || i7 == a.Q) {
                            long j7 = (bVar.c + this.n) - 8;
                            this.j.add(new a.C0120a(this.m, j7));
                            if (this.n == ((long) this.o)) {
                                a(j7);
                            } else {
                                a();
                            }
                        } else if (i7 == a.T || i7 == a.S || i7 == a.D || i7 == a.B || i7 == a.U || i7 == a.x || i7 == a.y || i7 == a.P || i7 == a.z || i7 == a.A || i7 == a.V || i7 == a.d0 || i7 == a.e0 || i7 == a.i0 || i7 == a.h0 || i7 == a.f0 || i7 == a.g0 || i7 == a.R || i7 == a.O || i7 == a.G0) {
                            if (this.o == 8) {
                                long j8 = this.n;
                                if (j8 <= 2147483647L) {
                                    k kVar = new k((int) j8);
                                    this.p = kVar;
                                    System.arraycopy(this.h.a, 0, kVar.a, 0, 8);
                                    this.l = 1;
                                } else {
                                    throw new com.fyber.inneractive.sdk.player.exoplayer2.l("Leaf atom with length > 2147483647 (unsupported).");
                                }
                            } else {
                                throw new com.fyber.inneractive.sdk.player.exoplayer2.l("Leaf atom defines extended atom size (unsupported).");
                            }
                        } else if (this.n <= 2147483647L) {
                            this.p = null;
                            this.l = 1;
                        } else {
                            throw new com.fyber.inneractive.sdk.player.exoplayer2.l("Skipping atom with length > 2147483647 (unsupported).");
                        }
                    } else {
                        throw new com.fyber.inneractive.sdk.player.exoplayer2.l("Atom size less than header length (unsupported).");
                    }
                } else if (i4 != 1) {
                    long j9 = Long.MAX_VALUE;
                    if (i4 != 2) {
                        b2 = 6;
                        if (i4 == 3) {
                            if (this.u != null) {
                                break loop0;
                            }
                            SparseArray<b> sparseArray = this.b;
                            int size2 = sparseArray.size();
                            b bVar2 = null;
                            for (int i8 = 0; i8 < size2; i8++) {
                                b valueAt = sparseArray.valueAt(i8);
                                int i9 = valueAt.g;
                                j jVar2 = valueAt.a;
                                if (i9 != jVar2.d) {
                                    long j10 = jVar2.f[i9];
                                    if (j10 < j9) {
                                        j9 = j10;
                                        bVar2 = valueAt;
                                    }
                                }
                            }
                            if (bVar2 == null) {
                                com.fyber.inneractive.sdk.player.exoplayer2.extractor.b bVar3 = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) gVar2;
                                int i10 = (int) (this.q - bVar3.c);
                                if (i10 >= 0) {
                                    bVar3.c(i10);
                                    a();
                                } else {
                                    throw new com.fyber.inneractive.sdk.player.exoplayer2.l("Offset to end of mdat was negative.");
                                }
                            } else {
                                com.fyber.inneractive.sdk.player.exoplayer2.extractor.b bVar4 = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) gVar2;
                                int i11 = (int) (bVar2.a.f[bVar2.g] - bVar4.c);
                                if (i11 < 0) {
                                    Log.w("FragmentedMp4Extractor", "Ignoring negative offset to sample data.");
                                    i11 = 0;
                                }
                                bVar4.c(i11);
                                this.u = bVar2;
                            }
                        } else {
                            break loop0;
                        }
                    } else {
                        int size3 = this.b.size();
                        b bVar5 = null;
                        for (int i12 = 0; i12 < size3; i12++) {
                            j jVar3 = this.b.valueAt(i12).a;
                            if (jVar3.q) {
                                long j11 = jVar3.c;
                                if (j11 < j9) {
                                    bVar5 = this.b.valueAt(i12);
                                    j9 = j11;
                                }
                            }
                        }
                        if (bVar5 == null) {
                            this.l = 3;
                        } else {
                            com.fyber.inneractive.sdk.player.exoplayer2.extractor.b bVar6 = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) gVar2;
                            int i13 = (int) (j9 - bVar6.c);
                            if (i13 >= 0) {
                                bVar6.c(i13);
                                j jVar4 = bVar5.a;
                                bVar6.b(jVar4.p.a, 0, jVar4.o, false);
                                jVar4.p.e(0);
                                jVar4.q = false;
                            } else {
                                throw new com.fyber.inneractive.sdk.player.exoplayer2.l("Offset to encryption data was negative.");
                            }
                        }
                    }
                } else {
                    int i14 = ((int) this.n) - this.o;
                    k kVar2 = this.p;
                    if (kVar2 != null) {
                        com.fyber.inneractive.sdk.player.exoplayer2.extractor.b bVar7 = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) gVar2;
                        bVar7.b(kVar2.a, 8, i14, false);
                        int i15 = this.m;
                        k kVar3 = this.p;
                        a.b bVar8 = new a.b(i15, kVar3);
                        long j12 = bVar7.c;
                        if (!this.j.isEmpty()) {
                            this.j.peek().Q0.add(bVar8);
                        } else if (i15 == a.B) {
                            kVar3.e(8);
                            int b3 = a.b(kVar3.c());
                            kVar3.f(4);
                            long m2 = kVar3.m();
                            if (b3 == 0) {
                                j3 = kVar3.m();
                                j2 = kVar3.m();
                            } else {
                                j3 = kVar3.p();
                                j2 = kVar3.p();
                            }
                            long j13 = j12 + j2;
                            long j14 = j3;
                            long a2 = u.a(j14, 1000000, m2);
                            kVar3.f(2);
                            int q2 = kVar3.q();
                            int[] iArr = new int[q2];
                            long[] jArr = new long[q2];
                            long[] jArr2 = new long[q2];
                            long[] jArr3 = new long[q2];
                            long j15 = a2;
                            while (i5 < q2) {
                                int c2 = kVar3.c();
                                if ((c2 & Integer.MIN_VALUE) == 0) {
                                    long m3 = kVar3.m();
                                    iArr[i5] = c2 & Integer.MAX_VALUE;
                                    jArr[i5] = j13;
                                    jArr3[i5] = j15;
                                    j14 += m3;
                                    int i16 = q2;
                                    long[] jArr4 = jArr2;
                                    long[] jArr5 = jArr3;
                                    j15 = u.a(j14, 1000000, m2);
                                    jArr4[i5] = j15 - jArr5[i5];
                                    kVar3.f(4);
                                    j13 += (long) iArr[i5];
                                    i5++;
                                    jArr = jArr;
                                    jArr3 = jArr5;
                                    jArr2 = jArr4;
                                    q2 = i16;
                                    g gVar3 = gVar;
                                } else {
                                    throw new com.fyber.inneractive.sdk.player.exoplayer2.l("Unhandled indirect reference");
                                }
                            }
                            Pair create = Pair.create(Long.valueOf(a2), new com.fyber.inneractive.sdk.player.exoplayer2.extractor.a(iArr, jArr, jArr2, jArr3));
                            this.t = ((Long) create.first).longValue();
                            this.z.a((m) create.second);
                            this.C = true;
                        } else if (i15 == a.G0 && this.A != null) {
                            kVar3.e(12);
                            kVar3.j();
                            kVar3.j();
                            long a3 = u.a(kVar3.m(), 1000000, kVar3.m());
                            kVar3.e(12);
                            int a4 = kVar3.a();
                            this.A.a(kVar3, a4);
                            long j16 = this.t;
                            if (j16 != -9223372036854775807L) {
                                this.A.a(j16 + a3, 1, a4, 0, (byte[]) null);
                            } else {
                                this.k.addLast(new a(a3, a4));
                                this.r += a4;
                            }
                        }
                    } else {
                        ((com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) gVar).c(i14);
                    }
                    a(((com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) gVar).c);
                }
            }
        }
        b bVar9 = this.u;
        j jVar5 = bVar9.a;
        int[] iArr2 = jVar5.h;
        int i17 = bVar9.e;
        this.v = iArr2[i17];
        if (jVar5.l) {
            k kVar4 = jVar5.p;
            int i18 = jVar5.a.a;
            i iVar = jVar5.n;
            if (iVar == null) {
                iVar = bVar9.c.h[i18];
            }
            int i19 = iVar.a;
            boolean z3 = jVar5.m[i17];
            k kVar5 = this.f;
            kVar5.a[0] = (byte) ((z3 ? 128 : 0) | i19);
            kVar5.e(0);
            n nVar = bVar9.b;
            nVar.a(this.f, 1);
            nVar.a(kVar4, i19);
            if (!z3) {
                i3 = i19 + 1;
            } else {
                int q3 = kVar4.q();
                kVar4.f(-2);
                int i20 = (q3 * 6) + 2;
                nVar.a(kVar4, i20);
                i3 = i19 + 1 + i20;
            }
            this.w = i3;
            this.v += i3;
        } else {
            this.w = 0;
        }
        if (this.u.c.g == 1) {
            this.v -= 8;
            ((com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) gVar2).c(8);
        }
        this.l = 4;
        this.x = 0;
        b bVar10 = this.u;
        j jVar6 = bVar10.a;
        h hVar = bVar10.c;
        n nVar2 = bVar10.b;
        int i21 = bVar10.e;
        int i22 = hVar.k;
        if (i22 == 0) {
            while (true) {
                int i23 = this.w;
                int i24 = this.v;
                if (i23 >= i24) {
                    break;
                }
                this.w += nVar2.a(gVar2, i24 - i23, false);
            }
        } else {
            byte[] bArr3 = this.d.a;
            bArr3[0] = 0;
            bArr3[1] = 0;
            bArr3[2] = 0;
            int i25 = i22 + 1;
            int i26 = 4 - i22;
            while (this.w < this.v) {
                int i27 = this.x;
                if (i27 == 0) {
                    ((com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) gVar2).b(bArr3, i26, i25, false);
                    this.d.e(0);
                    this.x = this.d.o() - 1;
                    this.c.e(0);
                    nVar2.a(this.c, 4);
                    nVar2.a(this.d, 1);
                    if (this.B != null) {
                        String str = hVar.f.f;
                        byte b4 = bArr3[4];
                        byte[] bArr4 = i.a;
                        if ((MimeTypes.VIDEO_H264.equals(str) && (b4 & Ascii.US) == b2) || (MimeTypes.VIDEO_H265.equals(str) && ((b4 & 126) >> 1) == 39)) {
                            z2 = true;
                            this.y = z2;
                            this.w += 5;
                            this.v += i26;
                        }
                    }
                    z2 = false;
                    this.y = z2;
                    this.w += 5;
                    this.v += i26;
                } else {
                    if (this.y) {
                        this.e.c(i27);
                        ((com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) gVar2).b(this.e.a, 0, this.x, false);
                        nVar2.a(this.e, this.x);
                        i2 = this.x;
                        k kVar6 = this.e;
                        int a5 = i.a(kVar6.a, kVar6.c);
                        this.e.e(MimeTypes.VIDEO_H265.equals(hVar.f.f) ? 1 : 0);
                        this.e.d(a5);
                        com.fyber.inneractive.sdk.player.exoplayer2.text.cea.a.a((jVar6.j[i21] + ((long) jVar6.i[i21])) * 1000, this.e, this.B);
                    } else {
                        i2 = nVar2.a(gVar2, i27, false);
                    }
                    this.w += i2;
                    this.x -= i2;
                    b2 = 6;
                }
            }
        }
        long j17 = (jVar6.j[i21] + ((long) jVar6.i[i21])) * 1000;
        boolean z4 = jVar6.l;
        boolean z5 = (z4 ? (char) 0 : 0) | jVar6.k[i21];
        int i28 = jVar6.a.a;
        if (z4) {
            i iVar2 = jVar6.n;
            if (iVar2 != null) {
                bArr2 = iVar2.b;
            } else {
                bArr2 = hVar.h[i28].b;
            }
            bArr = bArr2;
        } else {
            bArr = null;
        }
        r rVar = this.g;
        if (rVar != null) {
            j17 = rVar.a(j17);
        }
        nVar2.a(j17, z5 ? 1 : 0, this.v, 0, bArr);
        while (!this.k.isEmpty()) {
            a removeFirst = this.k.removeFirst();
            int i29 = this.r;
            int i30 = removeFirst.b;
            int i31 = i29 - i30;
            this.r = i31;
            this.A.a(j17 + removeFirst.a, 1, i30, i31, (byte[]) null);
        }
        b bVar11 = this.u;
        bVar11.e++;
        int i32 = bVar11.f + 1;
        bVar11.f = i32;
        int[] iArr3 = jVar6.g;
        int i33 = bVar11.g;
        if (i32 == iArr3[i33]) {
            bVar11.g = i33 + 1;
            bVar11.f = 0;
            this.u = null;
        }
        this.l = 3;
        return 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:255:0x05db  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(long r56) throws com.fyber.inneractive.sdk.player.exoplayer2.l {
        /*
            r55 = this;
        L_0x0000:
            r0 = r55
        L_0x0002:
            java.util.Stack<com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a$a> r1 = r0.j
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x06ee
            java.util.Stack<com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a$a> r1 = r0.j
            java.lang.Object r1 = r1.peek()
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a$a r1 = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.C0120a) r1
            long r1 = r1.P0
            int r3 = (r1 > r56 ? 1 : (r1 == r56 ? 0 : -1))
            if (r3 != 0) goto L_0x06ee
            java.util.Stack<com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a$a> r1 = r0.j
            java.lang.Object r1 = r1.pop()
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a$a r1 = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.C0120a) r1
            int r2 = r1.a
            int r3 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.C
            r4 = 12
            r5 = 8
            r7 = 1
            if (r2 != r3) goto L_0x015d
            java.util.List<com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a$b> r2 = r1.Q0
            com.fyber.inneractive.sdk.player.exoplayer2.drm.a r2 = a((java.util.List<com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.b>) r2)
            int r3 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.N
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a$a r3 = r1.c(r3)
            android.util.SparseArray r14 = new android.util.SparseArray
            r14.<init>()
            java.util.List<com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a$b> r8 = r3.Q0
            int r8 = r8.size()
            r9 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r15 = r9
            r9 = 0
        L_0x0049:
            if (r9 >= r8) goto L_0x00b0
            java.util.List<com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a$b> r10 = r3.Q0
            java.lang.Object r10 = r10.get(r9)
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a$b r10 = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.b) r10
            int r11 = r10.a
            int r12 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.z
            if (r11 != r12) goto L_0x008e
            com.fyber.inneractive.sdk.player.exoplayer2.util.k r10 = r10.P0
            r10.e(r4)
            int r11 = r10.c()
            int r12 = r10.o()
            int r12 = r12 - r7
            int r13 = r10.o()
            int r6 = r10.o()
            int r10 = r10.c()
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.c r4 = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.c
            r4.<init>(r12, r13, r6, r10)
            android.util.Pair r4 = android.util.Pair.create(r11, r4)
            java.lang.Object r6 = r4.first
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r6 = r6.intValue()
            java.lang.Object r4 = r4.second
            r14.put(r6, r4)
            goto L_0x00ab
        L_0x008e:
            int r4 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.O
            if (r11 != r4) goto L_0x00ab
            com.fyber.inneractive.sdk.player.exoplayer2.util.k r4 = r10.P0
            r4.e(r5)
            int r6 = r4.c()
            int r6 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.b(r6)
            if (r6 != 0) goto L_0x00a6
            long r10 = r4.m()
            goto L_0x00aa
        L_0x00a6:
            long r10 = r4.p()
        L_0x00aa:
            r15 = r10
        L_0x00ab:
            int r9 = r9 + 1
            r4 = 12
            goto L_0x0049
        L_0x00b0:
            android.util.SparseArray r3 = new android.util.SparseArray
            r3.<init>()
            java.util.List<com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a$a> r4 = r1.R0
            int r4 = r4.size()
            r5 = 0
        L_0x00bc:
            if (r5 >= r4) goto L_0x00e4
            java.util.List<com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a$a> r6 = r1.R0
            java.lang.Object r6 = r6.get(r5)
            r8 = r6
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a$a r8 = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.C0120a) r8
            int r6 = r8.a
            int r9 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.E
            if (r6 != r9) goto L_0x00e1
            int r6 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.D
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a$b r9 = r1.d(r6)
            r13 = 0
            r10 = r15
            r12 = r2
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.h r6 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.b.a((com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.C0120a) r8, (com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.b) r9, (long) r10, (com.fyber.inneractive.sdk.player.exoplayer2.drm.a) r12, (boolean) r13)
            if (r6 == 0) goto L_0x00e1
            int r8 = r6.a
            r3.put(r8, r6)
        L_0x00e1:
            int r5 = r5 + 1
            goto L_0x00bc
        L_0x00e4:
            int r1 = r3.size()
            android.util.SparseArray<com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.d$b> r2 = r0.b
            int r2 = r2.size()
            if (r2 != 0) goto L_0x012f
            r6 = 0
        L_0x00f1:
            if (r6 >= r1) goto L_0x0125
            java.lang.Object r2 = r3.valueAt(r6)
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.h r2 = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.h) r2
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.d$b r4 = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.d$b
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.h r5 = r0.z
            int r7 = r2.b
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.n r5 = r5.a(r6, r7)
            r4.<init>(r5)
            int r5 = r2.a
            java.lang.Object r5 = r14.get(r5)
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.c r5 = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.c) r5
            r4.a(r2, r5)
            android.util.SparseArray<com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.d$b> r5 = r0.b
            int r7 = r2.a
            r5.put(r7, r4)
            long r4 = r0.s
            long r7 = r2.e
            long r4 = java.lang.Math.max(r4, r7)
            r0.s = r4
            int r6 = r6 + 1
            goto L_0x00f1
        L_0x0125:
            r55.c()
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.h r1 = r0.z
            r1.c()
            goto L_0x0002
        L_0x012f:
            android.util.SparseArray<com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.d$b> r2 = r0.b
            int r2 = r2.size()
            if (r2 != r1) goto L_0x0138
            goto L_0x0139
        L_0x0138:
            r7 = 0
        L_0x0139:
            com.fyber.inneractive.sdk.player.exoplayer2.util.a.b(r7)
            r6 = 0
        L_0x013d:
            if (r6 >= r1) goto L_0x0002
            java.lang.Object r2 = r3.valueAt(r6)
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.h r2 = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.h) r2
            android.util.SparseArray<com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.d$b> r4 = r0.b
            int r5 = r2.a
            java.lang.Object r4 = r4.get(r5)
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.d$b r4 = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.d.b) r4
            int r5 = r2.a
            java.lang.Object r5 = r14.get(r5)
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.c r5 = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.c) r5
            r4.a(r2, r5)
            int r6 = r6 + 1
            goto L_0x013d
        L_0x015d:
            int r3 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.L
            if (r2 != r3) goto L_0x06d1
            android.util.SparseArray<com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.d$b> r2 = r0.b
            int r3 = r0.a
            byte[] r4 = r0.i
            java.util.List<com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a$a> r6 = r1.R0
            int r6 = r6.size()
            r8 = 0
        L_0x016e:
            if (r8 >= r6) goto L_0x0642
            java.util.List<com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a$a> r9 = r1.R0
            java.lang.Object r9 = r9.get(r8)
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a$a r9 = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.C0120a) r9
            int r10 = r9.a
            int r11 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.M
            if (r10 != r11) goto L_0x0620
            int r10 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.y
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a$b r10 = r9.d(r10)
            com.fyber.inneractive.sdk.player.exoplayer2.util.k r10 = r10.P0
            r10.e(r5)
            int r11 = r10.c()
            int r12 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.b
            int r12 = r10.c()
            r13 = r3 & 16
            if (r13 != 0) goto L_0x0198
            goto L_0x0199
        L_0x0198:
            r12 = 0
        L_0x0199:
            java.lang.Object r12 = r2.get(r12)
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.d$b r12 = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.d.b) r12
            if (r12 != 0) goto L_0x01a3
            r12 = 0
            goto L_0x01eb
        L_0x01a3:
            r13 = r11 & 1
            if (r13 == 0) goto L_0x01b1
            long r13 = r10.p()
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.j r15 = r12.a
            r15.b = r13
            r15.c = r13
        L_0x01b1:
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.c r13 = r12.d
            r14 = r11 & 2
            if (r14 == 0) goto L_0x01bd
            int r14 = r10.o()
            int r14 = r14 - r7
            goto L_0x01bf
        L_0x01bd:
            int r14 = r13.a
        L_0x01bf:
            r15 = r11 & 8
            if (r15 == 0) goto L_0x01c8
            int r15 = r10.o()
            goto L_0x01ca
        L_0x01c8:
            int r15 = r13.b
        L_0x01ca:
            r16 = r11 & 16
            if (r16 == 0) goto L_0x01d5
            int r16 = r10.o()
            r7 = r16
            goto L_0x01d7
        L_0x01d5:
            int r7 = r13.c
        L_0x01d7:
            r11 = r11 & 32
            if (r11 == 0) goto L_0x01e0
            int r10 = r10.o()
            goto L_0x01e2
        L_0x01e0:
            int r10 = r13.d
        L_0x01e2:
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.j r11 = r12.a
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.c r13 = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.c
            r13.<init>(r14, r15, r7, r10)
            r11.a = r13
        L_0x01eb:
            if (r12 != 0) goto L_0x01ef
            goto L_0x0620
        L_0x01ef:
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.j r7 = r12.a
            long r10 = r7.r
            r12.a()
            int r13 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.x
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a$b r14 = r9.d(r13)
            if (r14 == 0) goto L_0x021f
            r14 = r3 & 2
            if (r14 != 0) goto L_0x021f
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a$b r10 = r9.d(r13)
            com.fyber.inneractive.sdk.player.exoplayer2.util.k r10 = r10.P0
            r10.e(r5)
            int r11 = r10.c()
            int r11 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.b(r11)
            r13 = 1
            if (r11 != r13) goto L_0x021b
            long r10 = r10.p()
            goto L_0x021f
        L_0x021b:
            long r10 = r10.m()
        L_0x021f:
            java.util.List<com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a$b> r13 = r9.Q0
            int r14 = r13.size()
            r20 = r2
            r2 = 0
            r5 = 0
            r15 = 0
        L_0x022a:
            if (r15 >= r14) goto L_0x0258
            java.lang.Object r21 = r13.get(r15)
            r22 = r6
            r6 = r21
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a$b r6 = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.b) r6
            r23 = r10
            int r10 = r6.a
            int r11 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.A
            if (r10 != r11) goto L_0x024f
            com.fyber.inneractive.sdk.player.exoplayer2.util.k r6 = r6.P0
            r10 = 12
            r6.e(r10)
            int r6 = r6.o()
            if (r6 <= 0) goto L_0x0251
            int r2 = r2 + r6
            int r5 = r5 + 1
            goto L_0x0251
        L_0x024f:
            r10 = 12
        L_0x0251:
            int r15 = r15 + 1
            r6 = r22
            r10 = r23
            goto L_0x022a
        L_0x0258:
            r22 = r6
            r23 = r10
            r6 = 0
            r10 = 12
            r12.g = r6
            r12.f = r6
            r12.e = r6
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.j r6 = r12.a
            r6.d = r5
            r6.e = r2
            int[] r11 = r6.g
            if (r11 == 0) goto L_0x0272
            int r11 = r11.length
            if (r11 >= r5) goto L_0x027a
        L_0x0272:
            long[] r11 = new long[r5]
            r6.f = r11
            int[] r5 = new int[r5]
            r6.g = r5
        L_0x027a:
            int[] r5 = r6.h
            if (r5 == 0) goto L_0x0281
            int r5 = r5.length
            if (r5 >= r2) goto L_0x0299
        L_0x0281:
            int r2 = r2 * 125
            int r2 = r2 / 100
            int[] r5 = new int[r2]
            r6.h = r5
            int[] r5 = new int[r2]
            r6.i = r5
            long[] r5 = new long[r2]
            r6.j = r5
            boolean[] r5 = new boolean[r2]
            r6.k = r5
            boolean[] r2 = new boolean[r2]
            r6.m = r2
        L_0x0299:
            r2 = 0
            r5 = 0
            r6 = 0
        L_0x029c:
            r25 = 0
            if (r2 >= r14) goto L_0x0439
            java.lang.Object r18 = r13.get(r2)
            r10 = r18
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a$b r10 = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.b) r10
            int r15 = r10.a
            int r11 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.A
            if (r15 != r11) goto L_0x0409
            int r11 = r5 + 1
            com.fyber.inneractive.sdk.player.exoplayer2.util.k r10 = r10.P0
            r15 = 8
            r10.e(r15)
            int r15 = r10.c()
            int r28 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.b
            r28 = r11
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.h r11 = r12.c
            r29 = r13
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.j r13 = r12.a
            r30 = r14
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.c r14 = r13.a
            int[] r0 = r13.g
            int r31 = r10.o()
            r0[r5] = r31
            long[] r0 = r13.f
            r32 = r7
            r31 = r8
            long r7 = r13.b
            r0[r5] = r7
            r33 = r15 & 1
            if (r33 == 0) goto L_0x02ec
            r33 = r1
            int r1 = r10.c()
            r34 = r2
            long r1 = (long) r1
            long r7 = r7 + r1
            r0[r5] = r7
            goto L_0x02f0
        L_0x02ec:
            r33 = r1
            r34 = r2
        L_0x02f0:
            r0 = r15 & 4
            if (r0 == 0) goto L_0x02f6
            r0 = 1
            goto L_0x02f7
        L_0x02f6:
            r0 = 0
        L_0x02f7:
            int r1 = r14.d
            if (r0 == 0) goto L_0x02ff
            int r1 = r10.o()
        L_0x02ff:
            r2 = r15 & 256(0x100, float:3.59E-43)
            if (r2 == 0) goto L_0x0305
            r2 = 1
            goto L_0x0306
        L_0x0305:
            r2 = 0
        L_0x0306:
            r7 = r15 & 512(0x200, float:7.175E-43)
            if (r7 == 0) goto L_0x030c
            r7 = 1
            goto L_0x030d
        L_0x030c:
            r7 = 0
        L_0x030d:
            r8 = r15 & 1024(0x400, float:1.435E-42)
            if (r8 == 0) goto L_0x0313
            r8 = 1
            goto L_0x0314
        L_0x0313:
            r8 = 0
        L_0x0314:
            r15 = r15 & 2048(0x800, float:2.87E-42)
            r35 = r1
            if (r15 == 0) goto L_0x031c
            r15 = 1
            goto L_0x031d
        L_0x031c:
            r15 = 0
        L_0x031d:
            long[] r1 = r11.i
            r36 = r4
            if (r1 == 0) goto L_0x0344
            int r4 = r1.length
            r37 = r12
            r12 = 1
            if (r4 != r12) goto L_0x0341
            r4 = 0
            r38 = r1[r4]
            int r1 = (r38 > r25 ? 1 : (r38 == r25 ? 0 : -1))
            if (r1 != 0) goto L_0x0341
            long[] r1 = r11.j
            r38 = r1[r4]
            r4 = r8
            r1 = r9
            long r8 = r11.c
            r40 = 1000(0x3e8, double:4.94E-321)
            r42 = r8
            long r25 = com.fyber.inneractive.sdk.player.exoplayer2.util.u.a((long) r38, (long) r40, (long) r42)
            goto L_0x0348
        L_0x0341:
            r4 = r8
            r1 = r9
            goto L_0x0348
        L_0x0344:
            r4 = r8
            r1 = r9
            r37 = r12
        L_0x0348:
            int[] r8 = r13.h
            int[] r9 = r13.i
            long[] r12 = r13.j
            r38 = r1
            boolean[] r1 = r13.k
            r39 = r1
            int r1 = r11.b
            r40 = r8
            r8 = 2
            if (r1 != r8) goto L_0x0361
            r1 = r3 & 1
            if (r1 == 0) goto L_0x0361
            r1 = 1
            goto L_0x0362
        L_0x0361:
            r1 = 0
        L_0x0362:
            int[] r8 = r13.g
            r8 = r8[r5]
            int r8 = r8 + r6
            r27 = r12
            long r11 = r11.c
            if (r5 <= 0) goto L_0x0374
            r41 = r6
            long r5 = r13.r
            r47 = r3
            goto L_0x037a
        L_0x0374:
            r41 = r6
            r47 = r3
            r5 = r23
        L_0x037a:
            r3 = r41
        L_0x037c:
            if (r3 >= r8) goto L_0x0403
            if (r2 == 0) goto L_0x0389
            int r41 = r10.o()
            r48 = r2
            r2 = r41
            goto L_0x038d
        L_0x0389:
            r48 = r2
            int r2 = r14.b
        L_0x038d:
            if (r7 == 0) goto L_0x0398
            int r41 = r10.o()
            r49 = r7
            r7 = r41
            goto L_0x039c
        L_0x0398:
            r49 = r7
            int r7 = r14.c
        L_0x039c:
            if (r3 != 0) goto L_0x03a5
            if (r0 == 0) goto L_0x03a5
            r50 = r0
            r0 = r35
            goto L_0x03b4
        L_0x03a5:
            if (r4 == 0) goto L_0x03b0
            int r41 = r10.c()
            r50 = r0
            r0 = r41
            goto L_0x03b4
        L_0x03b0:
            r50 = r0
            int r0 = r14.d
        L_0x03b4:
            if (r15 == 0) goto L_0x03c8
            r51 = r4
            int r4 = r10.c()
            int r4 = r4 * 1000
            r52 = r14
            r53 = r15
            long r14 = (long) r4
            long r14 = r14 / r11
            int r4 = (int) r14
            r9[r3] = r4
            goto L_0x03d1
        L_0x03c8:
            r51 = r4
            r52 = r14
            r53 = r15
            r4 = 0
            r9[r3] = r4
        L_0x03d1:
            r43 = 1000(0x3e8, double:4.94E-321)
            r41 = r5
            r45 = r11
            long r14 = com.fyber.inneractive.sdk.player.exoplayer2.util.u.a((long) r41, (long) r43, (long) r45)
            long r14 = r14 - r25
            r27[r3] = r14
            r40[r3] = r7
            r4 = 16
            int r0 = r0 >> r4
            r4 = 1
            r0 = r0 & r4
            if (r0 != 0) goto L_0x03ee
            if (r1 == 0) goto L_0x03ec
            if (r3 != 0) goto L_0x03ee
        L_0x03ec:
            r0 = 1
            goto L_0x03ef
        L_0x03ee:
            r0 = 0
        L_0x03ef:
            r39[r3] = r0
            long r14 = (long) r2
            long r5 = r5 + r14
            int r3 = r3 + 1
            r2 = r48
            r7 = r49
            r0 = r50
            r4 = r51
            r14 = r52
            r15 = r53
            goto L_0x037c
        L_0x0403:
            r13.r = r5
            r6 = r8
            r5 = r28
            goto L_0x041f
        L_0x0409:
            r33 = r1
            r34 = r2
            r47 = r3
            r36 = r4
            r41 = r6
            r32 = r7
            r31 = r8
            r38 = r9
            r37 = r12
            r29 = r13
            r30 = r14
        L_0x041f:
            int r2 = r34 + 1
            r0 = r55
            r13 = r29
            r14 = r30
            r8 = r31
            r7 = r32
            r1 = r33
            r4 = r36
            r12 = r37
            r9 = r38
            r3 = r47
            r10 = 12
            goto L_0x029c
        L_0x0439:
            r33 = r1
            r47 = r3
            r36 = r4
            r32 = r7
            r31 = r8
            r38 = r9
            r37 = r12
            int r0 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.d0
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a$b r0 = r9.d(r0)
            if (r0 == 0) goto L_0x04c5
            r12 = r37
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.h r1 = r12.c
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.i[] r1 = r1.h
            r2 = r32
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.c r3 = r2.a
            int r3 = r3.a
            r1 = r1[r3]
            com.fyber.inneractive.sdk.player.exoplayer2.util.k r0 = r0.P0
            int r1 = r1.a
            r3 = 8
            r0.e(r3)
            int r4 = r0.c()
            int r5 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.b
            r5 = 1
            r4 = r4 & r5
            if (r4 != r5) goto L_0x0473
            r0.f(r3)
        L_0x0473:
            int r3 = r0.l()
            int r4 = r0.o()
            int r5 = r2.e
            if (r4 != r5) goto L_0x04a7
            if (r3 != 0) goto L_0x0496
            boolean[] r3 = r2.m
            r5 = 0
            r6 = 0
        L_0x0485:
            if (r5 >= r4) goto L_0x04a3
            int r7 = r0.l()
            int r6 = r6 + r7
            if (r7 <= r1) goto L_0x0490
            r7 = 1
            goto L_0x0491
        L_0x0490:
            r7 = 0
        L_0x0491:
            r3[r5] = r7
            int r5 = r5 + 1
            goto L_0x0485
        L_0x0496:
            if (r3 <= r1) goto L_0x049a
            r0 = 1
            goto L_0x049b
        L_0x049a:
            r0 = 0
        L_0x049b:
            int r6 = r3 * r4
            boolean[] r1 = r2.m
            r3 = 0
            java.util.Arrays.fill(r1, r3, r4, r0)
        L_0x04a3:
            r2.a(r6)
            goto L_0x04c7
        L_0x04a7:
            com.fyber.inneractive.sdk.player.exoplayer2.l r0 = new com.fyber.inneractive.sdk.player.exoplayer2.l
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r3 = "Length mismatch: "
            r1.<init>(r3)
            r1.append(r4)
            java.lang.String r3 = ", "
            r1.append(r3)
            int r2 = r2.e
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>((java.lang.String) r1)
            throw r0
        L_0x04c5:
            r2 = r32
        L_0x04c7:
            int r0 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.e0
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a$b r0 = r9.d(r0)
            if (r0 == 0) goto L_0x0513
            com.fyber.inneractive.sdk.player.exoplayer2.util.k r0 = r0.P0
            r1 = 8
            r0.e(r1)
            int r3 = r0.c()
            int r4 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.b
            r4 = r3 & 1
            r5 = 1
            if (r4 != r5) goto L_0x04e4
            r0.f(r1)
        L_0x04e4:
            int r1 = r0.o()
            if (r1 != r5) goto L_0x04ff
            int r1 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.b(r3)
            long r3 = r2.c
            if (r1 != 0) goto L_0x04f7
            long r0 = r0.m()
            goto L_0x04fb
        L_0x04f7:
            long r0 = r0.p()
        L_0x04fb:
            long r3 = r3 + r0
            r2.c = r3
            goto L_0x0513
        L_0x04ff:
            com.fyber.inneractive.sdk.player.exoplayer2.l r0 = new com.fyber.inneractive.sdk.player.exoplayer2.l
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Unexpected saio entry count: "
            r2.<init>(r3)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            r0.<init>((java.lang.String) r1)
            throw r0
        L_0x0513:
            int r0 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.i0
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a$b r0 = r9.d(r0)
            if (r0 == 0) goto L_0x0521
            com.fyber.inneractive.sdk.player.exoplayer2.util.k r0 = r0.P0
            r1 = 0
            a(r0, r1, r2)
        L_0x0521:
            int r0 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.f0
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a$b r0 = r9.d(r0)
            int r1 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.g0
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a$b r1 = r9.d(r1)
            if (r0 == 0) goto L_0x05d1
            if (r1 == 0) goto L_0x05d1
            com.fyber.inneractive.sdk.player.exoplayer2.util.k r0 = r0.P0
            com.fyber.inneractive.sdk.player.exoplayer2.util.k r1 = r1.P0
            r3 = 8
            r0.e(r3)
            int r3 = r0.c()
            int r4 = r0.c()
            int r5 = D
            if (r4 == r5) goto L_0x0548
            goto L_0x05d1
        L_0x0548:
            int r3 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.b(r3)
            r4 = 4
            r6 = 1
            if (r3 != r6) goto L_0x0553
            r0.f(r4)
        L_0x0553:
            int r0 = r0.c()
            if (r0 != r6) goto L_0x05c9
            r0 = 8
            r1.e(r0)
            int r0 = r1.c()
            int r3 = r1.c()
            if (r3 == r5) goto L_0x0569
            goto L_0x05d1
        L_0x0569:
            int r0 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.b(r0)
            if (r0 != r6) goto L_0x0581
            long r3 = r1.m()
            int r0 = (r3 > r25 ? 1 : (r3 == r25 ? 0 : -1))
            if (r0 == 0) goto L_0x0579
            r3 = 2
            goto L_0x0587
        L_0x0579:
            com.fyber.inneractive.sdk.player.exoplayer2.l r0 = new com.fyber.inneractive.sdk.player.exoplayer2.l
            java.lang.String r1 = "Variable length decription in sgpd found (unsupported)"
            r0.<init>((java.lang.String) r1)
            throw r0
        L_0x0581:
            r3 = 2
            if (r0 < r3) goto L_0x0587
            r1.f(r4)
        L_0x0587:
            long r4 = r1.m()
            r6 = 1
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 != 0) goto L_0x05c1
            r1.f(r3)
            int r0 = r1.l()
            r3 = 1
            if (r0 != r3) goto L_0x059d
            r13 = 1
            goto L_0x059e
        L_0x059d:
            r13 = 0
        L_0x059e:
            if (r13 != 0) goto L_0x05a1
            goto L_0x05d1
        L_0x05a1:
            int r0 = r1.l()
            r3 = 16
            byte[] r4 = new byte[r3]
            byte[] r5 = r1.a
            int r6 = r1.b
            r7 = 0
            java.lang.System.arraycopy(r5, r6, r4, r7, r3)
            int r5 = r1.b
            int r5 = r5 + r3
            r1.b = r5
            r1 = 1
            r2.l = r1
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.i r3 = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.i
            r3.<init>(r13, r0, r4)
            r2.n = r3
            goto L_0x05d2
        L_0x05c1:
            com.fyber.inneractive.sdk.player.exoplayer2.l r0 = new com.fyber.inneractive.sdk.player.exoplayer2.l
            java.lang.String r1 = "Entry count in sgpd != 1 (unsupported)."
            r0.<init>((java.lang.String) r1)
            throw r0
        L_0x05c9:
            com.fyber.inneractive.sdk.player.exoplayer2.l r0 = new com.fyber.inneractive.sdk.player.exoplayer2.l
            java.lang.String r1 = "Entry count in sbgp != 1 (unsupported)."
            r0.<init>((java.lang.String) r1)
            throw r0
        L_0x05d1:
            r1 = 1
        L_0x05d2:
            java.util.List<com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a$b> r0 = r9.Q0
            int r0 = r0.size()
            r6 = 0
        L_0x05d9:
            if (r6 >= r0) goto L_0x061a
            java.util.List<com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a$b> r3 = r9.Q0
            java.lang.Object r3 = r3.get(r6)
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a$b r3 = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.b) r3
            int r4 = r3.a
            int r5 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.h0
            if (r4 != r5) goto L_0x060e
            com.fyber.inneractive.sdk.player.exoplayer2.util.k r3 = r3.P0
            r4 = 8
            r3.e(r4)
            byte[] r5 = r3.a
            int r7 = r3.b
            r8 = r36
            r10 = 16
            r11 = 0
            java.lang.System.arraycopy(r5, r7, r8, r11, r10)
            int r5 = r3.b
            int r5 = r5 + r10
            r3.b = r5
            byte[] r5 = E
            boolean r5 = java.util.Arrays.equals(r8, r5)
            if (r5 != 0) goto L_0x060a
            goto L_0x0615
        L_0x060a:
            a(r3, r10, r2)
            goto L_0x0615
        L_0x060e:
            r8 = r36
            r4 = 8
            r10 = 16
            r11 = 0
        L_0x0615:
            int r6 = r6 + 1
            r36 = r8
            goto L_0x05d9
        L_0x061a:
            r8 = r36
            r4 = 8
            r11 = 0
            goto L_0x062f
        L_0x0620:
            r33 = r1
            r20 = r2
            r47 = r3
            r22 = r6
            r31 = r8
            r1 = 1
            r11 = 0
            r8 = r4
            r4 = 8
        L_0x062f:
            int r0 = r31 + 1
            r4 = r8
            r2 = r20
            r6 = r22
            r1 = r33
            r3 = r47
            r5 = 8
            r7 = 1
            r8 = r0
            r0 = r55
            goto L_0x016e
        L_0x0642:
            r0 = r1
            r11 = 0
            java.util.List<com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a$b> r0 = r0.Q0
            com.fyber.inneractive.sdk.player.exoplayer2.drm.a r0 = a((java.util.List<com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.b>) r0)
            if (r0 == 0) goto L_0x0000
            r1 = r55
            android.util.SparseArray<com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.d$b> r2 = r1.b
            int r2 = r2.size()
            r6 = 0
        L_0x0655:
            if (r6 >= r2) goto L_0x06eb
            android.util.SparseArray<com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.d$b> r3 = r1.b
            java.lang.Object r3 = r3.valueAt(r6)
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.d$b r3 = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.d.b) r3
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.n r4 = r3.b
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.h r3 = r3.c
            com.fyber.inneractive.sdk.player.exoplayer2.i r3 = r3.f
            com.fyber.inneractive.sdk.player.exoplayer2.i r5 = new com.fyber.inneractive.sdk.player.exoplayer2.i
            r12 = r5
            java.lang.String r13 = r3.a
            java.lang.String r14 = r3.e
            java.lang.String r15 = r3.f
            java.lang.String r7 = r3.c
            r16 = r7
            int r7 = r3.b
            r17 = r7
            int r7 = r3.g
            r18 = r7
            int r7 = r3.j
            r19 = r7
            int r7 = r3.k
            r20 = r7
            float r7 = r3.l
            r21 = r7
            int r7 = r3.m
            r22 = r7
            float r7 = r3.n
            r23 = r7
            byte[] r7 = r3.p
            r24 = r7
            int r7 = r3.o
            r25 = r7
            com.fyber.inneractive.sdk.player.exoplayer2.video.b r7 = r3.q
            r26 = r7
            int r7 = r3.r
            r27 = r7
            int r7 = r3.s
            r28 = r7
            int r7 = r3.t
            r29 = r7
            int r7 = r3.u
            r30 = r7
            int r7 = r3.v
            r31 = r7
            int r7 = r3.x
            r32 = r7
            java.lang.String r7 = r3.y
            r33 = r7
            int r7 = r3.z
            r34 = r7
            long r7 = r3.w
            r35 = r7
            java.util.List<byte[]> r7 = r3.h
            r37 = r7
            com.fyber.inneractive.sdk.player.exoplayer2.metadata.a r3 = r3.d
            r39 = r3
            r38 = r0
            r12.<init>(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r37, r38, r39)
            r4.a(r5)
            int r6 = r6 + 1
            goto L_0x0655
        L_0x06d1:
            r54 = r1
            r1 = r0
            r0 = r54
            java.util.Stack<com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a$a> r2 = r1.j
            boolean r2 = r2.isEmpty()
            if (r2 != 0) goto L_0x06eb
            java.util.Stack<com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a$a> r2 = r1.j
            java.lang.Object r2 = r2.peek()
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a$a r2 = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.C0120a) r2
            java.util.List<com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a$a> r2 = r2.R0
            r2.add(r0)
        L_0x06eb:
            r0 = r1
            goto L_0x0002
        L_0x06ee:
            r1 = r0
            r55.a()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.d.a(long):void");
    }

    public static void a(k kVar, int i2, j jVar) throws com.fyber.inneractive.sdk.player.exoplayer2.l {
        kVar.e(i2 + 8);
        int c2 = kVar.c();
        int i3 = a.b;
        if ((c2 & 1) == 0) {
            boolean z2 = (c2 & 2) != 0;
            int o2 = kVar.o();
            if (o2 == jVar.e) {
                Arrays.fill(jVar.m, 0, o2, z2);
                jVar.a(kVar.a());
                kVar.a(jVar.p.a, 0, jVar.o);
                jVar.p.e(0);
                jVar.q = false;
                return;
            }
            throw new com.fyber.inneractive.sdk.player.exoplayer2.l("Length mismatch: " + o2 + ", " + jVar.e);
        }
        throw new com.fyber.inneractive.sdk.player.exoplayer2.l("Overriding TrackEncryptionBox parameters is unsupported.");
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00ab  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.fyber.inneractive.sdk.player.exoplayer2.drm.a a(java.util.List<com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.b> r14) {
        /*
            int r0 = r14.size()
            r1 = 0
            r2 = 0
            r4 = r1
            r3 = 0
        L_0x0008:
            if (r3 >= r0) goto L_0x00b9
            java.lang.Object r5 = r14.get(r3)
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a$b r5 = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.b) r5
            int r6 = r5.a
            int r7 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.V
            if (r6 != r7) goto L_0x00b5
            if (r4 != 0) goto L_0x001d
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
        L_0x001d:
            com.fyber.inneractive.sdk.player.exoplayer2.util.k r5 = r5.P0
            byte[] r5 = r5.a
            com.fyber.inneractive.sdk.player.exoplayer2.util.k r6 = new com.fyber.inneractive.sdk.player.exoplayer2.util.k
            r6.<init>((byte[]) r5)
            int r8 = r6.c
            r9 = 32
            if (r8 >= r9) goto L_0x002d
            goto L_0x0085
        L_0x002d:
            r6.e(r2)
            int r8 = r6.c()
            int r9 = r6.a()
            int r9 = r9 + 4
            if (r8 == r9) goto L_0x003d
            goto L_0x0085
        L_0x003d:
            int r8 = r6.c()
            if (r8 == r7) goto L_0x0044
            goto L_0x0085
        L_0x0044:
            int r7 = r6.c()
            int r7 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.b(r7)
            r8 = 1
            if (r7 <= r8) goto L_0x0063
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r8 = "Unsupported pssh version: "
            r6.<init>(r8)
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            java.lang.String r7 = "PsshAtomUtil"
            android.util.Log.w(r7, r6)
            goto L_0x0085
        L_0x0063:
            java.util.UUID r9 = new java.util.UUID
            long r10 = r6.i()
            long r12 = r6.i()
            r9.<init>(r10, r12)
            if (r7 != r8) goto L_0x007b
            int r7 = r6.o()
            int r7 = r7 * 16
            r6.f(r7)
        L_0x007b:
            int r7 = r6.o()
            int r8 = r6.a()
            if (r7 == r8) goto L_0x0087
        L_0x0085:
            r6 = r1
            goto L_0x0099
        L_0x0087:
            byte[] r8 = new byte[r7]
            byte[] r10 = r6.a
            int r11 = r6.b
            java.lang.System.arraycopy(r10, r11, r8, r2, r7)
            int r10 = r6.b
            int r10 = r10 + r7
            r6.b = r10
            android.util.Pair r6 = android.util.Pair.create(r9, r8)
        L_0x0099:
            if (r6 != 0) goto L_0x009d
            r6 = r1
            goto L_0x00a1
        L_0x009d:
            java.lang.Object r6 = r6.first
            java.util.UUID r6 = (java.util.UUID) r6
        L_0x00a1:
            if (r6 != 0) goto L_0x00ab
            java.lang.String r5 = "FragmentedMp4Extractor"
            java.lang.String r6 = "Skipped pssh atom (failed to extract uuid)"
            android.util.Log.w(r5, r6)
            goto L_0x00b5
        L_0x00ab:
            com.fyber.inneractive.sdk.player.exoplayer2.drm.a$b r7 = new com.fyber.inneractive.sdk.player.exoplayer2.drm.a$b
            java.lang.String r8 = "video/mp4"
            r7.<init>(r6, r8, r5, r2)
            r4.add(r7)
        L_0x00b5:
            int r3 = r3 + 1
            goto L_0x0008
        L_0x00b9:
            if (r4 != 0) goto L_0x00bc
            goto L_0x00cd
        L_0x00bc:
            com.fyber.inneractive.sdk.player.exoplayer2.drm.a r1 = new com.fyber.inneractive.sdk.player.exoplayer2.drm.a
            int r14 = r4.size()
            com.fyber.inneractive.sdk.player.exoplayer2.drm.a$b[] r14 = new com.fyber.inneractive.sdk.player.exoplayer2.drm.a.b[r14]
            java.lang.Object[] r14 = r4.toArray(r14)
            com.fyber.inneractive.sdk.player.exoplayer2.drm.a$b[] r14 = (com.fyber.inneractive.sdk.player.exoplayer2.drm.a.b[]) r14
            r1.<init>(r2, r14)
        L_0x00cd:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.d.a(java.util.List):com.fyber.inneractive.sdk.player.exoplayer2.drm.a");
    }
}
