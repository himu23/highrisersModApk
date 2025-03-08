package com.applovin.exoplayer2.e.i;

import com.applovin.exoplayer2.e.d;
import com.applovin.exoplayer2.e.h;
import com.applovin.exoplayer2.e.i;
import com.applovin.exoplayer2.e.i.ad;
import com.applovin.exoplayer2.e.j;
import com.applovin.exoplayer2.e.l;
import com.applovin.exoplayer2.e.u;
import com.applovin.exoplayer2.e.v;
import com.applovin.exoplayer2.l.a;
import com.applovin.exoplayer2.l.x;
import com.applovin.exoplayer2.l.y;
import java.io.IOException;

public final class e implements h {
    public static final l vq = new e$$ExternalSyntheticLambda0();
    private final f CA;
    private final y CB;
    private final x CC;
    private long CD;
    private long CE;
    private int CF;
    private boolean CG;
    private boolean Cq;
    private final int jF;
    private final y uO;
    private boolean vB;
    private j vG;

    public void release() {
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ h[] ih() {
        return new h[]{new e()};
    }

    public e() {
        this(0);
    }

    public e(int i) {
        this.jF = (i & 2) != 0 ? i | 1 : i;
        this.CA = new f(true);
        this.CB = new y(2048);
        this.CF = -1;
        this.CE = -1;
        y yVar = new y(10);
        this.uO = yVar;
        this.CC = new x(yVar.hO());
    }

    public boolean a(i iVar) throws IOException {
        int W = W(iVar);
        int i = W;
        int i2 = 0;
        int i3 = 0;
        do {
            iVar.c(this.uO.hO(), 0, 2);
            this.uO.fx(0);
            if (!f.cu(this.uO.pp())) {
                i++;
                iVar.ic();
                iVar.bI(i);
            } else {
                i2++;
                if (i2 >= 4 && i3 > 188) {
                    return true;
                }
                iVar.c(this.uO.hO(), 0, 4);
                this.CC.fx(14);
                int bQ = this.CC.bQ(13);
                if (bQ <= 6) {
                    i++;
                    iVar.ic();
                    iVar.bI(i);
                } else {
                    iVar.bI(bQ - 6);
                    i3 += bQ;
                }
            }
            i2 = 0;
            i3 = 0;
        } while (i - W < 8192);
        return false;
    }

    public void a(j jVar) {
        this.vG = jVar;
        this.CA.a(jVar, new ad.d(0, 1));
        jVar.ig();
    }

    public void o(long j, long j2) {
        this.Cq = false;
        this.CA.jb();
        this.CD = j2;
    }

    public int b(i iVar, u uVar) throws IOException {
        a.N(this.vG);
        long j = iVar.m1771if();
        int i = this.jF;
        if (!((i & 2) == 0 && ((i & 1) == 0 || j == -1))) {
            X(iVar);
        }
        int read = iVar.read(this.CB.hO(), 0, 2048);
        boolean z = read == -1;
        c(j, z);
        if (z) {
            return -1;
        }
        this.CB.fx(0);
        this.CB.fA(read);
        if (!this.Cq) {
            this.CA.e(this.CD, 4);
            this.Cq = true;
        }
        this.CA.K(this.CB);
        return 0;
    }

    private int W(i iVar) throws IOException {
        int i = 0;
        while (true) {
            iVar.c(this.uO.hO(), 0, 10);
            this.uO.fx(0);
            if (this.uO.pt() != 4801587) {
                break;
            }
            this.uO.fz(3);
            int pC = this.uO.pC();
            i += pC + 10;
            iVar.bI(pC);
        }
        iVar.ic();
        iVar.bI(i);
        if (this.CE == -1) {
            this.CE = (long) i;
        }
        return i;
    }

    private void c(long j, boolean z) {
        if (!this.vB) {
            boolean z2 = false;
            boolean z3 = (this.jF & 1) != 0 && this.CF > 0;
            if (!z3 || this.CA.je() != -9223372036854775807L || z) {
                if (!z3 || this.CA.je() == -9223372036854775807L) {
                    this.vG.a(new v.b(-9223372036854775807L));
                } else {
                    j jVar = this.vG;
                    if ((this.jF & 2) != 0) {
                        z2 = true;
                    }
                    jVar.a(b(j, z2));
                }
                this.vB = true;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0083  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void X(com.applovin.exoplayer2.e.i r10) throws java.io.IOException {
        /*
            r9 = this;
            boolean r0 = r9.CG
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            r0 = -1
            r9.CF = r0
            r10.ic()
            long r1 = r10.ie()
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 != 0) goto L_0x0018
            r9.W(r10)
        L_0x0018:
            r1 = 0
            r2 = 0
        L_0x001a:
            r5 = 1
            com.applovin.exoplayer2.l.y r6 = r9.uO     // Catch:{ EOFException -> 0x0076 }
            byte[] r6 = r6.hO()     // Catch:{ EOFException -> 0x0076 }
            r7 = 2
            boolean r6 = r10.b(r6, r1, r7, r5)     // Catch:{ EOFException -> 0x0076 }
            if (r6 == 0) goto L_0x0077
            com.applovin.exoplayer2.l.y r6 = r9.uO     // Catch:{ EOFException -> 0x0076 }
            r6.fx(r1)     // Catch:{ EOFException -> 0x0076 }
            com.applovin.exoplayer2.l.y r6 = r9.uO     // Catch:{ EOFException -> 0x0076 }
            int r6 = r6.pp()     // Catch:{ EOFException -> 0x0076 }
            boolean r6 = com.applovin.exoplayer2.e.i.f.cu(r6)     // Catch:{ EOFException -> 0x0076 }
            if (r6 != 0) goto L_0x003a
            goto L_0x0078
        L_0x003a:
            com.applovin.exoplayer2.l.y r6 = r9.uO     // Catch:{ EOFException -> 0x0076 }
            byte[] r6 = r6.hO()     // Catch:{ EOFException -> 0x0076 }
            r7 = 4
            boolean r6 = r10.b(r6, r1, r7, r5)     // Catch:{ EOFException -> 0x0076 }
            if (r6 != 0) goto L_0x0048
            goto L_0x0077
        L_0x0048:
            com.applovin.exoplayer2.l.x r6 = r9.CC     // Catch:{ EOFException -> 0x0076 }
            r7 = 14
            r6.fx(r7)     // Catch:{ EOFException -> 0x0076 }
            com.applovin.exoplayer2.l.x r6 = r9.CC     // Catch:{ EOFException -> 0x0076 }
            r7 = 13
            int r6 = r6.bQ(r7)     // Catch:{ EOFException -> 0x0076 }
            r7 = 6
            if (r6 <= r7) goto L_0x006c
            long r7 = (long) r6     // Catch:{ EOFException -> 0x0076 }
            long r3 = r3 + r7
            int r2 = r2 + 1
            r7 = 1000(0x3e8, float:1.401E-42)
            if (r2 != r7) goto L_0x0063
            goto L_0x006b
        L_0x0063:
            int r6 = r6 + -6
            boolean r6 = r10.j(r6, r5)     // Catch:{ EOFException -> 0x0076 }
            if (r6 != 0) goto L_0x001a
        L_0x006b:
            goto L_0x0077
        L_0x006c:
            r9.CG = r5     // Catch:{ EOFException -> 0x0076 }
            java.lang.String r1 = "Malformed ADTS stream"
            r6 = 0
            com.applovin.exoplayer2.ai r1 = com.applovin.exoplayer2.ai.c(r1, r6)     // Catch:{ EOFException -> 0x0076 }
            throw r1     // Catch:{ EOFException -> 0x0076 }
        L_0x0076:
        L_0x0077:
            r1 = r2
        L_0x0078:
            r10.ic()
            if (r1 <= 0) goto L_0x0083
            long r0 = (long) r1
            long r3 = r3 / r0
            int r10 = (int) r3
            r9.CF = r10
            goto L_0x0085
        L_0x0083:
            r9.CF = r0
        L_0x0085:
            r9.CG = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.e.i.e.X(com.applovin.exoplayer2.e.i):void");
    }

    private v b(long j, boolean z) {
        return new d(j, this.CE, d(this.CF, this.CA.je()), this.CF, z);
    }

    private static int d(int i, long j) {
        return (int) ((((long) (i * 8)) * 1000000) / j);
    }
}
