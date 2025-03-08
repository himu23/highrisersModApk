package com.applovin.exoplayer2.e.i;

import com.applovin.exoplayer2.b.c;
import com.applovin.exoplayer2.e.i.ad;
import com.applovin.exoplayer2.e.j;
import com.applovin.exoplayer2.e.x;
import com.applovin.exoplayer2.l.a;
import com.applovin.exoplayer2.l.x;
import com.applovin.exoplayer2.l.y;
import com.applovin.exoplayer2.v;

public final class d implements j {
    private int Ai;
    private final x Cr;
    private final y Cs;
    private String Ct;
    private int Cu;
    private long Cw;
    private boolean Cy;
    private boolean Cz;
    private int Z;
    private v dU;
    private final String dq;
    private long rJ;
    private com.applovin.exoplayer2.e.x wl;

    public void e(long j, int i) {
        if (j != -9223372036854775807L) {
            this.rJ = j;
        }
    }

    public void jb() {
        this.Z = 0;
        this.Cu = 0;
        this.Cy = false;
        this.Cz = false;
        this.rJ = -9223372036854775807L;
    }

    public void jc() {
    }

    public d() {
        this((String) null);
    }

    public d(String str) {
        x xVar = new x(new byte[16]);
        this.Cr = xVar;
        this.Cs = new y(xVar.tf);
        this.Z = 0;
        this.Cu = 0;
        this.Cy = false;
        this.Cz = false;
        this.rJ = -9223372036854775807L;
        this.dq = str;
    }

    public void a(j jVar, ad.d dVar) {
        dVar.jy();
        this.Ct = dVar.jA();
        this.wl = jVar.y(dVar.jz(), 1);
    }

    public void K(y yVar) {
        a.N(this.wl);
        while (yVar.pj() > 0) {
            int i = this.Z;
            if (i != 0) {
                if (i != 1) {
                    if (i == 2) {
                        int min = Math.min(yVar.pj(), this.Ai - this.Cu);
                        this.wl.c(yVar, min);
                        int i2 = this.Cu + min;
                        this.Cu = i2;
                        int i3 = this.Ai;
                        if (i2 == i3) {
                            long j = this.rJ;
                            if (j != -9223372036854775807L) {
                                this.wl.a(j, 1, i3, 0, (x.a) null);
                                this.rJ += this.Cw;
                            }
                            this.Z = 0;
                        }
                    }
                } else if (a(yVar, this.Cs.hO(), 16)) {
                    jd();
                    this.Cs.fx(0);
                    this.wl.c(this.Cs, 16);
                    this.Z = 2;
                }
            } else if (L(yVar)) {
                this.Z = 1;
                this.Cs.hO()[0] = -84;
                this.Cs.hO()[1] = (byte) (this.Cz ? 65 : 64);
                this.Cu = 2;
            }
        }
    }

    private boolean a(y yVar, byte[] bArr, int i) {
        int min = Math.min(yVar.pj(), i - this.Cu);
        yVar.r(bArr, this.Cu, min);
        int i2 = this.Cu + min;
        this.Cu = i2;
        return i2 == i;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x002d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean L(com.applovin.exoplayer2.l.y r6) {
        /*
            r5 = this;
        L_0x0000:
            int r0 = r6.pj()
            r1 = 0
            if (r0 <= 0) goto L_0x0031
            boolean r0 = r5.Cy
            r2 = 172(0xac, float:2.41E-43)
            r3 = 1
            if (r0 != 0) goto L_0x0018
            int r0 = r6.po()
            if (r0 != r2) goto L_0x0015
            r1 = 1
        L_0x0015:
            r5.Cy = r1
            goto L_0x0000
        L_0x0018:
            int r0 = r6.po()
            if (r0 != r2) goto L_0x0020
            r2 = 1
            goto L_0x0021
        L_0x0020:
            r2 = 0
        L_0x0021:
            r5.Cy = r2
            r2 = 64
            r4 = 65
            if (r0 == r2) goto L_0x002b
            if (r0 != r4) goto L_0x0000
        L_0x002b:
            if (r0 != r4) goto L_0x002e
            r1 = 1
        L_0x002e:
            r5.Cz = r1
            return r3
        L_0x0031:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.e.i.d.L(com.applovin.exoplayer2.l.y):boolean");
    }

    private void jd() {
        this.Cr.fx(0);
        c.a d = c.d(this.Cr);
        if (this.dU == null || d.dL != this.dU.dL || d.dM != this.dU.dM || !"audio/ac4".equals(this.dU.dz)) {
            v bT = new v.a().g(this.Ct).m("audio/ac4").N(d.dL).O(d.dM).j(this.dq).bT();
            this.dU = bT;
            this.wl.j(bT);
        }
        this.Ai = d.jz;
        this.Cw = (((long) d.jA) * 1000000) / ((long) this.dU.dM);
    }
}
