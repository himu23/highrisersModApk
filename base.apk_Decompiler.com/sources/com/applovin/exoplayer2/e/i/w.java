package com.applovin.exoplayer2.e.i;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import com.applovin.exoplayer2.ai;
import com.applovin.exoplayer2.common.base.Ascii;
import com.applovin.exoplayer2.e.h;
import com.applovin.exoplayer2.e.i;
import com.applovin.exoplayer2.e.i.ad;
import com.applovin.exoplayer2.e.j;
import com.applovin.exoplayer2.e.l;
import com.applovin.exoplayer2.e.u;
import com.applovin.exoplayer2.e.v;
import com.applovin.exoplayer2.l.ag;
import com.applovin.exoplayer2.l.x;
import com.applovin.exoplayer2.l.y;
import java.io.IOException;
import kotlin.UByte;

public final class w implements h {
    public static final l vq = new w$$ExternalSyntheticLambda0();
    private j BG;
    private final SparseArray<a> Fa;
    private final y Fb;
    private final v Fc;
    private boolean Fd;
    private boolean Fe;
    private boolean Ff;
    private long Fg;
    private u Fh;
    private boolean vB;
    private final ag zS;

    public void a(j jVar) {
        this.BG = jVar;
    }

    public void release() {
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ h[] ih() {
        return new h[]{new w()};
    }

    public w() {
        this(new ag(0));
    }

    public w(ag agVar) {
        this.zS = agVar;
        this.Fb = new y(4096);
        this.Fa = new SparseArray<>();
        this.Fc = new v();
    }

    public boolean a(i iVar) throws IOException {
        byte[] bArr = new byte[14];
        iVar.c(bArr, 0, 14);
        if (442 != (((bArr[0] & UByte.MAX_VALUE) << Ascii.CAN) | ((bArr[1] & UByte.MAX_VALUE) << Ascii.DLE) | ((bArr[2] & UByte.MAX_VALUE) << 8) | (bArr[3] & UByte.MAX_VALUE)) || (bArr[4] & 196) != 68 || (bArr[6] & 4) != 4 || (bArr[8] & 4) != 4 || (bArr[9] & 1) != 1 || (bArr[12] & 3) != 3) {
            return false;
        }
        iVar.bI(bArr[13] & 7);
        iVar.c(bArr, 0, 3);
        if (1 == (((bArr[0] & UByte.MAX_VALUE) << Ascii.DLE) | ((bArr[1] & UByte.MAX_VALUE) << 8) | (bArr[2] & UByte.MAX_VALUE))) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0027, code lost:
        if (r5 != r7) goto L_0x002c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002a, code lost:
        if (r5 != false) goto L_0x002c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0040 A[LOOP:0: B:16:0x0038->B:18:0x0040, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void o(long r5, long r7) {
        /*
            r4 = this;
            com.applovin.exoplayer2.l.ag r5 = r4.zS
            long r5 = r5.pU()
            r0 = 0
            r1 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r3 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r3 != 0) goto L_0x0012
            r5 = 1
            goto L_0x0013
        L_0x0012:
            r5 = 0
        L_0x0013:
            if (r5 != 0) goto L_0x002a
            com.applovin.exoplayer2.l.ag r5 = r4.zS
            long r5 = r5.pS()
            int r3 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r3 == 0) goto L_0x0031
            r1 = 0
            int r3 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r3 == 0) goto L_0x0031
            int r1 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r1 == 0) goto L_0x0031
            goto L_0x002c
        L_0x002a:
            if (r5 == 0) goto L_0x0031
        L_0x002c:
            com.applovin.exoplayer2.l.ag r5 = r4.zS
            r5.aI(r7)
        L_0x0031:
            com.applovin.exoplayer2.e.i.u r5 = r4.Fh
            if (r5 == 0) goto L_0x0038
            r5.ag(r7)
        L_0x0038:
            android.util.SparseArray<com.applovin.exoplayer2.e.i.w$a> r5 = r4.Fa
            int r5 = r5.size()
            if (r0 >= r5) goto L_0x004e
            android.util.SparseArray<com.applovin.exoplayer2.e.i.w$a> r5 = r4.Fa
            java.lang.Object r5 = r5.valueAt(r0)
            com.applovin.exoplayer2.e.i.w$a r5 = (com.applovin.exoplayer2.e.i.w.a) r5
            r5.jb()
            int r0 = r0 + 1
            goto L_0x0038
        L_0x004e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.e.i.w.o(long, long):void");
    }

    public int b(i iVar, u uVar) throws IOException {
        j jVar;
        com.applovin.exoplayer2.l.a.N(this.BG);
        long j = iVar.m1771if();
        int i = (j > -1 ? 1 : (j == -1 ? 0 : -1));
        if (i != 0 && !this.Fc.jt()) {
            return this.Fc.j(iVar, uVar);
        }
        aH(j);
        u uVar2 = this.Fh;
        if (uVar2 != null && uVar2.hT()) {
            return this.Fh.a(iVar, uVar);
        }
        iVar.ic();
        long id = i != 0 ? j - iVar.id() : -1;
        if ((id != -1 && id < 4) || !iVar.b(this.Fb.hO(), 0, 4, true)) {
            return -1;
        }
        this.Fb.fx(0);
        int px = this.Fb.px();
        if (px == 441) {
            return -1;
        }
        if (px == 442) {
            iVar.c(this.Fb.hO(), 0, 10);
            this.Fb.fx(9);
            iVar.bH((this.Fb.po() & 7) + 14);
            return 0;
        } else if (px == 443) {
            iVar.c(this.Fb.hO(), 0, 2);
            this.Fb.fx(0);
            iVar.bH(this.Fb.pp() + 6);
            return 0;
        } else if (((px & InputDeviceCompat.SOURCE_ANY) >> 8) != 1) {
            iVar.bH(1);
            return 0;
        } else {
            int i2 = px & 255;
            a aVar = this.Fa.get(i2);
            if (!this.Fd) {
                if (aVar == null) {
                    if (i2 == 189) {
                        jVar = new b();
                        this.Fe = true;
                        this.Fg = iVar.ie();
                    } else if ((px & 224) == 192) {
                        jVar = new q();
                        this.Fe = true;
                        this.Fg = iVar.ie();
                    } else if ((px & 240) == 224) {
                        jVar = new k();
                        this.Ff = true;
                        this.Fg = iVar.ie();
                    } else {
                        jVar = null;
                    }
                    if (jVar != null) {
                        jVar.a(this.BG, new ad.d(i2, 256));
                        aVar = new a(jVar, this.zS);
                        this.Fa.put(i2, aVar);
                    }
                }
                if (iVar.ie() > ((!this.Fe || !this.Ff) ? PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED : this.Fg + PlaybackStateCompat.ACTION_PLAY_FROM_URI)) {
                    this.Fd = true;
                    this.BG.ig();
                }
            }
            iVar.c(this.Fb.hO(), 0, 2);
            this.Fb.fx(0);
            int pp = this.Fb.pp() + 6;
            if (aVar == null) {
                iVar.bH(pp);
            } else {
                this.Fb.U(pp);
                iVar.a(this.Fb.hO(), 0, pp);
                this.Fb.fx(6);
                aVar.K(this.Fb);
                y yVar = this.Fb;
                yVar.fA(yVar.pl());
            }
            return 0;
        }
    }

    private void aH(long j) {
        if (!this.vB) {
            this.vB = true;
            if (this.Fc.dd() != -9223372036854775807L) {
                u uVar = new u(this.Fc.ju(), this.Fc.dd(), j);
                this.Fh = uVar;
                this.BG.a(uVar.hS());
                return;
            }
            this.BG.a(new v.b(this.Fc.dd()));
        }
    }

    private static final class a {
        private final x EN = new x(new byte[64]);
        private boolean EO;
        private boolean EP;
        private boolean EQ;
        private int ER;
        private final j Fi;
        private long rJ;
        private final ag zS;

        public a(j jVar, ag agVar) {
            this.Fi = jVar;
            this.zS = agVar;
        }

        public void jb() {
            this.EQ = false;
            this.Fi.jb();
        }

        public void K(y yVar) throws ai {
            yVar.r(this.EN.tf, 0, 3);
            this.EN.fx(0);
            jd();
            yVar.r(this.EN.tf, 0, this.ER);
            this.EN.fx(0);
            js();
            this.Fi.e(this.rJ, 4);
            this.Fi.K(yVar);
            this.Fi.jc();
        }

        private void jd() {
            this.EN.bR(8);
            this.EO = this.EN.ik();
            this.EP = this.EN.ik();
            this.EN.bR(6);
            this.ER = this.EN.bQ(8);
        }

        private void js() {
            this.rJ = 0;
            if (this.EO) {
                this.EN.bR(4);
                this.EN.bR(1);
                this.EN.bR(1);
                long bQ = (((long) this.EN.bQ(3)) << 30) | ((long) (this.EN.bQ(15) << 15)) | ((long) this.EN.bQ(15));
                this.EN.bR(1);
                if (!this.EQ && this.EP) {
                    this.EN.bR(4);
                    this.EN.bR(1);
                    this.EN.bR(1);
                    this.EN.bR(1);
                    this.zS.br((((long) this.EN.bQ(3)) << 30) | ((long) (this.EN.bQ(15) << 15)) | ((long) this.EN.bQ(15)));
                    this.EQ = true;
                }
                this.rJ = this.zS.br(bQ);
            }
        }
    }
}
