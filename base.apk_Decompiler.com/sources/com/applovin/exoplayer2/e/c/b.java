package com.applovin.exoplayer2.e.c;

import com.applovin.exoplayer2.e.h;
import com.applovin.exoplayer2.e.i;
import com.applovin.exoplayer2.e.j;
import com.applovin.exoplayer2.e.l;
import com.applovin.exoplayer2.e.u;
import com.applovin.exoplayer2.e.v;
import com.applovin.exoplayer2.l.a;
import com.applovin.exoplayer2.l.y;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.io.IOException;

public final class b implements h {
    public static final l vq = new b$$ExternalSyntheticLambda0();
    private int Z = 1;
    private final y uO = new y(4);
    private j vG;
    private final y vW = new y(9);
    private final y vX = new y(11);
    private final y vY = new y();
    private final c vZ = new c();
    private boolean wa;
    private long wb;
    private int wc;
    private int wd;
    private int we;
    private long wf;
    private boolean wg;
    private a wh;
    private e wi;

    public void a(j jVar) {
        this.vG = jVar;
    }

    public void o(long j, long j2) {
        if (j == 0) {
            this.Z = 1;
            this.wa = false;
        } else {
            this.Z = 3;
        }
        this.wc = 0;
    }

    public void release() {
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ h[] ih() {
        return new h[]{new b()};
    }

    public boolean a(i iVar) throws IOException {
        iVar.c(this.uO.hO(), 0, 3);
        this.uO.fx(0);
        if (this.uO.pt() != 4607062) {
            return false;
        }
        iVar.c(this.uO.hO(), 0, 2);
        this.uO.fx(0);
        if ((this.uO.pp() & IronSourceConstants.INTERSTITIAL_DAILY_CAPPED) != 0) {
            return false;
        }
        iVar.c(this.uO.hO(), 0, 4);
        this.uO.fx(0);
        int px = this.uO.px();
        iVar.ic();
        iVar.bI(px);
        iVar.c(this.uO.hO(), 0, 4);
        this.uO.fx(0);
        if (this.uO.px() == 0) {
            return true;
        }
        return false;
    }

    public int b(i iVar, u uVar) throws IOException {
        a.N(this.vG);
        while (true) {
            int i = this.Z;
            if (i != 1) {
                if (i == 2) {
                    o(iVar);
                } else if (i != 3) {
                    if (i != 4) {
                        throw new IllegalStateException();
                    } else if (q(iVar)) {
                        return 0;
                    }
                } else if (!p(iVar)) {
                    return -1;
                }
            } else if (!n(iVar)) {
                return -1;
            }
        }
    }

    private boolean n(i iVar) throws IOException {
        boolean z = false;
        if (!iVar.a(this.vW.hO(), 0, 9, true)) {
            return false;
        }
        this.vW.fx(0);
        this.vW.fz(4);
        int po = this.vW.po();
        boolean z2 = (po & 4) != 0;
        if ((po & 1) != 0) {
            z = true;
        }
        if (z2 && this.wh == null) {
            this.wh = new a(this.vG.y(8, 1));
        }
        if (z && this.wi == null) {
            this.wi = new e(this.vG.y(9, 2));
        }
        this.vG.ig();
        this.wc = this.vW.px() - 5;
        this.Z = 2;
        return true;
    }

    private void o(i iVar) throws IOException {
        iVar.bH(this.wc);
        this.wc = 0;
        this.Z = 3;
    }

    private boolean p(i iVar) throws IOException {
        if (!iVar.a(this.vX.hO(), 0, 11, true)) {
            return false;
        }
        this.vX.fx(0);
        this.wd = this.vX.po();
        this.we = this.vX.pt();
        this.wf = (long) this.vX.pt();
        this.wf = (((long) (this.vX.po() << 24)) | this.wf) * 1000;
        this.vX.fz(3);
        this.Z = 4;
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x008b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean q(com.applovin.exoplayer2.e.i r10) throws java.io.IOException {
        /*
            r9 = this;
            long r0 = r9.ir()
            int r2 = r9.wd
            r3 = 8
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r6 = 1
            if (r2 != r3) goto L_0x0023
            com.applovin.exoplayer2.e.c.a r3 = r9.wh
            if (r3 == 0) goto L_0x0023
            r9.iq()
            com.applovin.exoplayer2.e.c.a r2 = r9.wh
            com.applovin.exoplayer2.l.y r10 = r9.r(r10)
            boolean r10 = r2.b(r10, r0)
        L_0x0021:
            r0 = 1
            goto L_0x0075
        L_0x0023:
            r3 = 9
            if (r2 != r3) goto L_0x0039
            com.applovin.exoplayer2.e.c.e r3 = r9.wi
            if (r3 == 0) goto L_0x0039
            r9.iq()
            com.applovin.exoplayer2.e.c.e r2 = r9.wi
            com.applovin.exoplayer2.l.y r10 = r9.r(r10)
            boolean r10 = r2.b(r10, r0)
            goto L_0x0021
        L_0x0039:
            r3 = 18
            if (r2 != r3) goto L_0x006e
            boolean r2 = r9.wg
            if (r2 != 0) goto L_0x006e
            com.applovin.exoplayer2.e.c.c r2 = r9.vZ
            com.applovin.exoplayer2.l.y r10 = r9.r(r10)
            boolean r10 = r2.b(r10, r0)
            com.applovin.exoplayer2.e.c.c r0 = r9.vZ
            long r0 = r0.dd()
            int r2 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r2 == 0) goto L_0x0021
            com.applovin.exoplayer2.e.j r2 = r9.vG
            com.applovin.exoplayer2.e.t r3 = new com.applovin.exoplayer2.e.t
            com.applovin.exoplayer2.e.c.c r7 = r9.vZ
            long[] r7 = r7.it()
            com.applovin.exoplayer2.e.c.c r8 = r9.vZ
            long[] r8 = r8.is()
            r3.<init>(r7, r8, r0)
            r2.a(r3)
            r9.wg = r6
            goto L_0x0021
        L_0x006e:
            int r0 = r9.we
            r10.bH(r0)
            r10 = 0
            r0 = 0
        L_0x0075:
            boolean r1 = r9.wa
            if (r1 != 0) goto L_0x008f
            if (r10 == 0) goto L_0x008f
            r9.wa = r6
            com.applovin.exoplayer2.e.c.c r10 = r9.vZ
            long r1 = r10.dd()
            int r10 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r10 != 0) goto L_0x008b
            long r1 = r9.wf
            long r1 = -r1
            goto L_0x008d
        L_0x008b:
            r1 = 0
        L_0x008d:
            r9.wb = r1
        L_0x008f:
            r10 = 4
            r9.wc = r10
            r10 = 2
            r9.Z = r10
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.e.c.b.q(com.applovin.exoplayer2.e.i):boolean");
    }

    private y r(i iVar) throws IOException {
        if (this.we > this.vY.pl()) {
            y yVar = this.vY;
            yVar.l(new byte[Math.max(yVar.pl() * 2, this.we)], 0);
        } else {
            this.vY.fx(0);
        }
        this.vY.fA(this.we);
        iVar.a(this.vY.hO(), 0, this.we);
        return this.vY;
    }

    private void iq() {
        if (!this.wg) {
            this.vG.a(new v.b(-9223372036854775807L));
            this.wg = true;
        }
    }

    private long ir() {
        if (this.wa) {
            return this.wb + this.wf;
        }
        if (this.vZ.dd() == -9223372036854775807L) {
            return 0;
        }
        return this.wf;
    }
}
