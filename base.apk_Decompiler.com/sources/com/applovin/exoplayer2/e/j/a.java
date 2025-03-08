package com.applovin.exoplayer2.e.j;

import android.util.Pair;
import com.applovin.exoplayer2.ai;
import com.applovin.exoplayer2.b.y;
import com.applovin.exoplayer2.common.base.Ascii;
import com.applovin.exoplayer2.e.h;
import com.applovin.exoplayer2.e.i;
import com.applovin.exoplayer2.e.j;
import com.applovin.exoplayer2.e.l;
import com.applovin.exoplayer2.e.u;
import com.applovin.exoplayer2.e.x;
import com.applovin.exoplayer2.k.g;
import com.applovin.exoplayer2.v;
import java.io.IOException;
import kotlin.UByte;
import okhttp3.internal.http.StatusLine;

public final class a implements h {
    public static final l vq = new a$$ExternalSyntheticLambda0();
    private b FY;
    private int FZ = -1;
    private j vG;
    private x vH;
    private long yO = -1;

    private interface b {
        void aI(long j);

        boolean d(i iVar, long j) throws IOException;

        void h(int i, long j) throws ai;
    }

    public void release() {
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ h[] ih() {
        return new h[]{new a()};
    }

    public boolean a(i iVar) throws IOException {
        return c.aa(iVar) != null;
    }

    public void a(j jVar) {
        this.vG = jVar;
        this.vH = jVar.y(0, 1);
        jVar.ig();
    }

    public void o(long j, long j2) {
        b bVar = this.FY;
        if (bVar != null) {
            bVar.aI(j2);
        }
    }

    public int b(i iVar, u uVar) throws IOException {
        io();
        if (this.FY == null) {
            b aa = c.aa(iVar);
            if (aa == null) {
                throw ai.c("Unsupported or unrecognized wav header.", (Throwable) null);
            } else if (aa.Gm == 17) {
                this.FY = new C0045a(this.vG, this.vH, aa);
            } else if (aa.Gm == 6) {
                this.FY = new c(this.vG, this.vH, aa, "audio/g711-alaw", -1);
            } else if (aa.Gm == 7) {
                this.FY = new c(this.vG, this.vH, aa, "audio/g711-mlaw", -1);
            } else {
                int p = y.p(aa.Gm, aa.uG);
                if (p != 0) {
                    this.FY = new c(this.vG, this.vH, aa, "audio/raw", p);
                } else {
                    throw ai.p("Unsupported WAV format type: " + aa.Gm);
                }
            }
        }
        if (this.FZ == -1) {
            Pair<Long, Long> ab = c.ab(iVar);
            this.FZ = ((Long) ab.first).intValue();
            long longValue = ((Long) ab.second).longValue();
            this.yO = longValue;
            this.FY.h(this.FZ, longValue);
        } else if (iVar.ie() == 0) {
            iVar.bH(this.FZ);
        }
        com.applovin.exoplayer2.l.a.checkState(this.yO != -1);
        if (this.FY.d(iVar, this.yO - iVar.ie())) {
            return -1;
        }
        return 0;
    }

    private void io() {
        com.applovin.exoplayer2.l.a.N(this.vH);
        com.applovin.exoplayer2.l.ai.R(this.vG);
    }

    private static final class c implements b {
        private final b Gc;
        private long Gi;
        private int Gj;
        private long Gk;
        private final int Gl;
        private final v dU;
        private final j vG;
        private final x vH;

        public void aI(long j) {
            this.Gi = j;
            this.Gj = 0;
            this.Gk = 0;
        }

        public c(j jVar, x xVar, b bVar, String str, int i) throws ai {
            this.vG = jVar;
            this.vH = xVar;
            this.Gc = bVar;
            int i2 = (bVar.Gn * bVar.uG) / 8;
            if (bVar.Gq == i2) {
                int i3 = bVar.Go * i2 * 8;
                int max = Math.max(i2, (bVar.Go * i2) / 10);
                this.Gl = max;
                this.dU = new v.a().m(str).G(i3).H(i3).I(max).N(bVar.Gn).O(bVar.Go).P(i).bT();
                return;
            }
            throw ai.c("Expected block size: " + i2 + "; got: " + bVar.Gq, (Throwable) null);
        }

        public void h(int i, long j) {
            this.vG.a(new d(this.Gc, 1, (long) i, j));
            this.vH.j(this.dU);
        }

        public boolean d(i iVar, long j) throws IOException {
            int i;
            int i2;
            int i3;
            long j2 = j;
            while (true) {
                i = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
                if (i <= 0 || (i2 = this.Gj) >= (i3 = this.Gl)) {
                    int i4 = this.Gc.Gq;
                    int i5 = this.Gj / i4;
                } else {
                    int a = this.vH.a((g) iVar, (int) Math.min((long) (i3 - i2), j2), true);
                    if (a == -1) {
                        j2 = 0;
                    } else {
                        this.Gj += a;
                        j2 -= (long) a;
                    }
                }
            }
            int i42 = this.Gc.Gq;
            int i52 = this.Gj / i42;
            if (i52 > 0) {
                int i6 = i52 * i42;
                int i7 = this.Gj - i6;
                this.vH.a(this.Gi + com.applovin.exoplayer2.l.ai.e(this.Gk, 1000000, (long) this.Gc.Go), 1, i6, i7, (x.a) null);
                this.Gk += (long) i52;
                this.Gj = i7;
            }
            if (i <= 0) {
                return true;
            }
            return false;
        }
    }

    /* renamed from: com.applovin.exoplayer2.e.j.a$a  reason: collision with other inner class name */
    private static final class C0045a implements b {
        private static final int[] Ga = {-1, -1, -1, -1, 2, 4, 6, 8, -1, -1, -1, -1, 2, 4, 6, 8};
        private static final int[] Gb = {7, 8, 9, 10, 11, 12, 13, 14, 16, 17, 19, 21, 23, 25, 28, 31, 34, 37, 41, 45, 50, 55, 60, 66, 73, 80, 88, 97, 107, 118, 130, 143, 157, 173, 190, 209, 230, 253, 279, StatusLine.HTTP_TEMP_REDIRECT, 337, 371, 408, 449, 494, 544, 598, 658, 724, 796, 876, 963, 1060, 1166, 1282, 1411, 1552, 1707, 1878, 2066, 2272, 2499, 2749, 3024, 3327, 3660, 4026, 4428, 4871, 5358, 5894, 6484, 7132, 7845, 8630, 9493, 10442, 11487, 12635, 13899, 15289, 16818, 18500, 20350, 22385, 24623, 27086, 29794, 32767};
        private final b Gc;
        private final int Gd;
        private final byte[] Ge;
        private final com.applovin.exoplayer2.l.y Gf;
        private final int Gg;
        private int Gh;
        private long Gi;
        private int Gj;
        private long Gk;
        private final v dU;
        private final j vG;
        private final x vH;

        private static int C(int i, int i2) {
            return i * 2 * i2;
        }

        public void aI(long j) {
            this.Gh = 0;
            this.Gi = j;
            this.Gj = 0;
            this.Gk = 0;
        }

        public C0045a(j jVar, x xVar, b bVar) throws ai {
            this.vG = jVar;
            this.vH = xVar;
            this.Gc = bVar;
            int max = Math.max(1, bVar.Go / 10);
            this.Gg = max;
            com.applovin.exoplayer2.l.y yVar = new com.applovin.exoplayer2.l.y(bVar.Gr);
            yVar.pq();
            int pq = yVar.pq();
            this.Gd = pq;
            int i = bVar.Gn;
            int i2 = (((bVar.Gq - (i * 4)) * 8) / (bVar.uG * i)) + 1;
            if (pq == i2) {
                int N = com.applovin.exoplayer2.l.ai.N(max, pq);
                this.Ge = new byte[(bVar.Gq * N)];
                this.Gf = new com.applovin.exoplayer2.l.y(N * C(pq, i));
                int i3 = ((bVar.Go * bVar.Gq) * 8) / pq;
                this.dU = new v.a().m("audio/raw").G(i3).H(i3).I(C(max, i)).N(bVar.Gn).O(bVar.Go).P(2).bT();
                return;
            }
            throw ai.c("Expected frames per block: " + i2 + "; got: " + pq, (Throwable) null);
        }

        public void h(int i, long j) {
            this.vG.a(new d(this.Gc, this.Gd, (long) i, j));
            this.vH.j(this.dU);
        }

        /* JADX WARNING: Removed duplicated region for block: B:12:0x0048  */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x003f A[EDGE_INSN: B:22:0x003f->B:10:0x003f ?: BREAK  , SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:5:0x0021  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean d(com.applovin.exoplayer2.e.i r7, long r8) throws java.io.IOException {
            /*
                r6 = this;
                int r0 = r6.Gg
                int r1 = r6.Gj
                int r1 = r6.cF(r1)
                int r0 = r0 - r1
                int r1 = r6.Gd
                int r0 = com.applovin.exoplayer2.l.ai.N(r0, r1)
                com.applovin.exoplayer2.e.j.b r1 = r6.Gc
                int r1 = r1.Gq
                int r0 = r0 * r1
                r1 = 0
                r3 = 1
                int r4 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
                if (r4 != 0) goto L_0x001e
            L_0x001c:
                r1 = 1
                goto L_0x001f
            L_0x001e:
                r1 = 0
            L_0x001f:
                if (r1 != 0) goto L_0x003f
                int r2 = r6.Gh
                if (r2 >= r0) goto L_0x003f
                int r2 = r0 - r2
                long r4 = (long) r2
                long r4 = java.lang.Math.min(r4, r8)
                int r2 = (int) r4
                byte[] r4 = r6.Ge
                int r5 = r6.Gh
                int r2 = r7.read(r4, r5, r2)
                r4 = -1
                if (r2 != r4) goto L_0x0039
                goto L_0x001c
            L_0x0039:
                int r4 = r6.Gh
                int r4 = r4 + r2
                r6.Gh = r4
                goto L_0x001f
            L_0x003f:
                int r7 = r6.Gh
                com.applovin.exoplayer2.e.j.b r8 = r6.Gc
                int r8 = r8.Gq
                int r7 = r7 / r8
                if (r7 <= 0) goto L_0x0077
                byte[] r8 = r6.Ge
                com.applovin.exoplayer2.l.y r9 = r6.Gf
                r6.a(r8, r7, r9)
                int r8 = r6.Gh
                com.applovin.exoplayer2.e.j.b r9 = r6.Gc
                int r9 = r9.Gq
                int r7 = r7 * r9
                int r8 = r8 - r7
                r6.Gh = r8
                com.applovin.exoplayer2.l.y r7 = r6.Gf
                int r7 = r7.pk()
                com.applovin.exoplayer2.e.x r8 = r6.vH
                com.applovin.exoplayer2.l.y r9 = r6.Gf
                r8.c(r9, r7)
                int r8 = r6.Gj
                int r8 = r8 + r7
                r6.Gj = r8
                int r7 = r6.cF(r8)
                int r8 = r6.Gg
                if (r7 < r8) goto L_0x0077
                r6.cE(r8)
            L_0x0077:
                if (r1 == 0) goto L_0x0084
                int r7 = r6.Gj
                int r7 = r6.cF(r7)
                if (r7 <= 0) goto L_0x0084
                r6.cE(r7)
            L_0x0084:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.e.j.a.C0045a.d(com.applovin.exoplayer2.e.i, long):boolean");
        }

        private void cE(int i) {
            long e = this.Gi + com.applovin.exoplayer2.l.ai.e(this.Gk, 1000000, (long) this.Gc.Go);
            int cG = cG(i);
            this.vH.a(e, 1, cG, this.Gj - cG, (x.a) null);
            this.Gk += (long) i;
            this.Gj -= cG;
        }

        private void a(byte[] bArr, int i, com.applovin.exoplayer2.l.y yVar) {
            for (int i2 = 0; i2 < i; i2++) {
                for (int i3 = 0; i3 < this.Gc.Gn; i3++) {
                    a(bArr, i2, i3, yVar.hO());
                }
            }
            int cG = cG(this.Gd * i);
            yVar.fx(0);
            yVar.fA(cG);
        }

        private void a(byte[] bArr, int i, int i2, byte[] bArr2) {
            int i3 = this.Gc.Gq;
            int i4 = this.Gc.Gn;
            int i5 = (i * i3) + (i2 * 4);
            int i6 = (i4 * 4) + i5;
            int i7 = (i3 / i4) - 4;
            int i8 = (short) (((bArr[i5 + 1] & UByte.MAX_VALUE) << 8) | (bArr[i5] & UByte.MAX_VALUE));
            int min = Math.min(bArr[i5 + 2] & UByte.MAX_VALUE, 88);
            int i9 = Gb[min];
            int i10 = ((i * this.Gd * i4) + i2) * 2;
            bArr2[i10] = (byte) (i8 & 255);
            bArr2[i10 + 1] = (byte) (i8 >> 8);
            for (int i11 = 0; i11 < i7 * 2; i11++) {
                byte b = bArr[((i11 / 8) * i4 * 4) + i6 + ((i11 / 2) % 4)];
                int i12 = i11 % 2 == 0 ? b & Ascii.SI : (b & UByte.MAX_VALUE) >> 4;
                int i13 = ((((i12 & 7) * 2) + 1) * i9) >> 3;
                if ((i12 & 8) != 0) {
                    i13 = -i13;
                }
                i8 = com.applovin.exoplayer2.l.ai.k(i8 + i13, -32768, 32767);
                i10 += i4 * 2;
                bArr2[i10] = (byte) (i8 & 255);
                bArr2[i10 + 1] = (byte) (i8 >> 8);
                int i14 = min + Ga[i12];
                int[] iArr = Gb;
                min = com.applovin.exoplayer2.l.ai.k(i14, 0, iArr.length - 1);
                i9 = iArr[min];
            }
        }

        private int cF(int i) {
            return i / (this.Gc.Gn * 2);
        }

        private int cG(int i) {
            return C(i, this.Gc.Gn);
        }
    }
}
