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

public final class a implements h {
    public static final l vq = new a$$ExternalSyntheticLambda0();
    private final b Co = new b();
    private final y Cp = new y(2786);
    private boolean Cq;

    public void release() {
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ h[] ih() {
        return new h[]{new a()};
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0037, code lost:
        r8.ic();
        r4 = r4 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0040, code lost:
        if ((r4 - r3) < 8192) goto L_0x0043;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0042, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(com.applovin.exoplayer2.e.i r8) throws java.io.IOException {
        /*
            r7 = this;
            com.applovin.exoplayer2.l.y r0 = new com.applovin.exoplayer2.l.y
            r1 = 10
            r0.<init>((int) r1)
            r2 = 0
            r3 = 0
        L_0x0009:
            byte[] r4 = r0.hO()
            r8.c(r4, r2, r1)
            r0.fx(r2)
            int r4 = r0.pt()
            r5 = 4801587(0x494433, float:6.728456E-39)
            if (r4 == r5) goto L_0x005f
            r8.ic()
            r8.bI(r3)
            r4 = r3
        L_0x0023:
            r1 = 0
        L_0x0024:
            byte[] r5 = r0.hO()
            r6 = 6
            r8.c(r5, r2, r6)
            r0.fx(r2)
            int r5 = r0.pp()
            r6 = 2935(0xb77, float:4.113E-42)
            if (r5 == r6) goto L_0x0047
            r8.ic()
            int r4 = r4 + 1
            int r1 = r4 - r3
            r5 = 8192(0x2000, float:1.14794E-41)
            if (r1 < r5) goto L_0x0043
            return r2
        L_0x0043:
            r8.bI(r4)
            goto L_0x0023
        L_0x0047:
            r5 = 1
            int r1 = r1 + r5
            r6 = 4
            if (r1 < r6) goto L_0x004d
            return r5
        L_0x004d:
            byte[] r5 = r0.hO()
            int r5 = com.applovin.exoplayer2.b.b.c((byte[]) r5)
            r6 = -1
            if (r5 != r6) goto L_0x0059
            return r2
        L_0x0059:
            int r5 = r5 + -6
            r8.bI(r5)
            goto L_0x0024
        L_0x005f:
            r4 = 3
            r0.fz(r4)
            int r4 = r0.pC()
            int r5 = r4 + 10
            int r3 = r3 + r5
            r8.bI(r4)
            goto L_0x0009
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.e.i.a.a(com.applovin.exoplayer2.e.i):boolean");
    }

    public void a(j jVar) {
        this.Co.a(jVar, new ad.d(0, 1));
        jVar.ig();
        jVar.a(new v.b(-9223372036854775807L));
    }

    public void o(long j, long j2) {
        this.Cq = false;
        this.Co.jb();
    }

    public int b(i iVar, u uVar) throws IOException {
        int read = iVar.read(this.Cp.hO(), 0, 2786);
        if (read == -1) {
            return -1;
        }
        this.Cp.fx(0);
        this.Cp.fA(read);
        if (!this.Cq) {
            this.Co.e(0, 4);
            this.Cq = true;
        }
        this.Co.K(this.Cp);
        return 0;
    }
}
