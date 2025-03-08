package com.applovin.exoplayer2.e.i;

import com.applovin.exoplayer2.e.h;
import com.applovin.exoplayer2.e.i;
import com.applovin.exoplayer2.e.i.ad;
import com.applovin.exoplayer2.e.j;
import com.applovin.exoplayer2.e.l;
import com.applovin.exoplayer2.e.u;
import com.applovin.exoplayer2.e.v;
import com.applovin.exoplayer2.l.y;
import java.io.IOException;

public final class c implements h {
    public static final l vq = new c$$ExternalSyntheticLambda0();
    private final y Cp = new y(16384);
    private boolean Cq;
    private final d Cx = new d();

    public void release() {
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ h[] ih() {
        return new h[]{new c()};
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0046, code lost:
        if ((r4 - r3) < 8192) goto L_0x0049;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0048, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x003d, code lost:
        r9.ic();
        r4 = r4 + 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(com.applovin.exoplayer2.e.i r9) throws java.io.IOException {
        /*
            r8 = this;
            com.applovin.exoplayer2.l.y r0 = new com.applovin.exoplayer2.l.y
            r1 = 10
            r0.<init>((int) r1)
            r2 = 0
            r3 = 0
        L_0x0009:
            byte[] r4 = r0.hO()
            r9.c(r4, r2, r1)
            r0.fx(r2)
            int r4 = r0.pt()
            r5 = 4801587(0x494433, float:6.728456E-39)
            if (r4 == r5) goto L_0x0065
            r9.ic()
            r9.bI(r3)
            r4 = r3
        L_0x0023:
            r1 = 0
        L_0x0024:
            byte[] r5 = r0.hO()
            r6 = 7
            r9.c(r5, r2, r6)
            r0.fx(r2)
            int r5 = r0.pp()
            r6 = 44096(0xac40, float:6.1792E-41)
            if (r5 == r6) goto L_0x004d
            r6 = 44097(0xac41, float:6.1793E-41)
            if (r5 == r6) goto L_0x004d
            r9.ic()
            int r4 = r4 + 1
            int r1 = r4 - r3
            r5 = 8192(0x2000, float:1.14794E-41)
            if (r1 < r5) goto L_0x0049
            return r2
        L_0x0049:
            r9.bI(r4)
            goto L_0x0023
        L_0x004d:
            r6 = 1
            int r1 = r1 + r6
            r7 = 4
            if (r1 < r7) goto L_0x0053
            return r6
        L_0x0053:
            byte[] r6 = r0.hO()
            int r5 = com.applovin.exoplayer2.b.c.b(r6, r5)
            r6 = -1
            if (r5 != r6) goto L_0x005f
            return r2
        L_0x005f:
            int r5 = r5 + -7
            r9.bI(r5)
            goto L_0x0024
        L_0x0065:
            r4 = 3
            r0.fz(r4)
            int r4 = r0.pC()
            int r5 = r4 + 10
            int r3 = r3 + r5
            r9.bI(r4)
            goto L_0x0009
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.e.i.c.a(com.applovin.exoplayer2.e.i):boolean");
    }

    public void a(j jVar) {
        this.Cx.a(jVar, new ad.d(0, 1));
        jVar.ig();
        jVar.a(new v.b(-9223372036854775807L));
    }

    public void o(long j, long j2) {
        this.Cq = false;
        this.Cx.jb();
    }

    public int b(i iVar, u uVar) throws IOException {
        int read = iVar.read(this.Cp.hO(), 0, 16384);
        if (read == -1) {
            return -1;
        }
        this.Cp.fx(0);
        this.Cp.fA(read);
        if (!this.Cq) {
            this.Cx.e(0, 4);
            this.Cq = true;
        }
        this.Cx.K(this.Cp);
        return 0;
    }
}
