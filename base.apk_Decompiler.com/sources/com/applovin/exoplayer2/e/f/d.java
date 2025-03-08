package com.applovin.exoplayer2.e.f;

import com.applovin.exoplayer2.ai;
import com.applovin.exoplayer2.b.r;
import com.applovin.exoplayer2.e.h;
import com.applovin.exoplayer2.e.i;
import com.applovin.exoplayer2.e.j;
import com.applovin.exoplayer2.e.l;
import com.applovin.exoplayer2.e.s;
import com.applovin.exoplayer2.e.u;
import com.applovin.exoplayer2.e.x;
import com.applovin.exoplayer2.g.a;
import com.applovin.exoplayer2.g.e.g;
import com.applovin.exoplayer2.l.y;
import com.applovin.exoplayer2.v;
import java.io.EOFException;
import java.io.IOException;

public final class d implements h {
    public static final l vq = new d$$ExternalSyntheticLambda0();
    private static final g.a yT = new d$$ExternalSyntheticLambda1();
    private a dx;
    private final int jF;
    private long tL;
    private final y uO;
    private long vC;
    private j vG;
    private final long yU;
    private final r.a yV;
    private final com.applovin.exoplayer2.e.r yW;
    private final s yX;
    private final x yY;
    private x yZ;
    private x za;
    private int zb;
    private long zc;
    private long zd;
    private int ze;
    private e zf;
    private boolean zg;
    private boolean zh;

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean a(int i, int i2, int i3, int i4, int i5) {
        return (i2 == 67 && i3 == 79 && i4 == 77 && (i5 == 77 || i == 2)) || (i2 == 77 && i3 == 76 && i4 == 76 && (i5 == 84 || i == 2));
    }

    private static boolean f(int i, long j) {
        return ((long) (i & -128000)) == (j & -128000);
    }

    public void iG() {
        this.zg = true;
    }

    public void release() {
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ h[] ih() {
        return new h[]{new d()};
    }

    public d() {
        this(0);
    }

    public d(int i) {
        this(i, -9223372036854775807L);
    }

    public d(int i, long j) {
        this.jF = (i & 2) != 0 ? i | 1 : i;
        this.yU = j;
        this.uO = new y(10);
        this.yV = new r.a();
        this.yW = new com.applovin.exoplayer2.e.r();
        this.zc = -9223372036854775807L;
        this.yX = new s();
        com.applovin.exoplayer2.e.g gVar = new com.applovin.exoplayer2.e.g();
        this.yY = gVar;
        this.za = gVar;
    }

    public boolean a(i iVar) throws IOException {
        return c(iVar, true);
    }

    public void a(j jVar) {
        this.vG = jVar;
        x y = jVar.y(0, 1);
        this.yZ = y;
        this.za = y;
        this.vG.ig();
    }

    public void o(long j, long j2) {
        this.zb = 0;
        this.zc = -9223372036854775807L;
        this.zd = 0;
        this.ze = 0;
        this.tL = j2;
        e eVar = this.zf;
        if ((eVar instanceof b) && !((b) eVar).ar(j2)) {
            this.zh = true;
            this.za = this.yY;
        }
    }

    public int b(i iVar, u uVar) throws IOException {
        io();
        int C = C(iVar);
        if (C == -1 && (this.zf instanceof b)) {
            long at = at(this.zd);
            if (this.zf.dd() != at) {
                ((b) this.zf).as(at);
                this.vG.a(this.zf);
            }
        }
        return C;
    }

    private int C(i iVar) throws IOException {
        if (this.zb == 0) {
            try {
                c(iVar, false);
            } catch (EOFException unused) {
                return -1;
            }
        }
        if (this.zf == null) {
            e E = E(iVar);
            this.zf = E;
            this.vG.a(E);
            this.za.j(new v.a().m(this.yV.eg).I(4096).N(this.yV.mI).O(this.yV.dM).Q(this.yW.dO).R(this.yW.dP).b((this.jF & 8) != 0 ? null : this.dx).bT());
            this.vC = iVar.ie();
        } else if (this.vC != 0) {
            long ie = iVar.ie();
            long j = this.vC;
            if (ie < j) {
                iVar.bH((int) (j - ie));
            }
        }
        return g(iVar);
    }

    private int g(i iVar) throws IOException {
        if (this.ze == 0) {
            iVar.ic();
            if (D(iVar)) {
                return -1;
            }
            this.uO.fx(0);
            int px = this.uO.px();
            if (!f(px, (long) this.zb) || r.aG(px) == -1) {
                iVar.bH(1);
                this.zb = 0;
                return 0;
            }
            this.yV.aK(px);
            if (this.zc == -9223372036854775807L) {
                this.zc = this.zf.aq(iVar.ie());
                if (this.yU != -9223372036854775807L) {
                    this.zc += this.yU - this.zf.aq(0);
                }
            }
            this.ze = this.yV.jz;
            e eVar = this.zf;
            if (eVar instanceof b) {
                b bVar = (b) eVar;
                bVar.s(at(this.zd + ((long) this.yV.mJ)), iVar.ie() + ((long) this.yV.jz));
                if (this.zh && bVar.ar(this.tL)) {
                    this.zh = false;
                    this.za = this.yZ;
                }
            }
        }
        int a = this.za.a((com.applovin.exoplayer2.k.g) iVar, this.ze, true);
        if (a == -1) {
            return -1;
        }
        int i = this.ze - a;
        this.ze = i;
        if (i > 0) {
            return 0;
        }
        this.za.a(at(this.zd), 1, this.yV.jz, 0, (x.a) null);
        this.zd += (long) this.yV.mJ;
        this.ze = 0;
        return 0;
    }

    private long at(long j) {
        return this.zc + ((j * 1000000) / ((long) this.yV.dM));
    }

    private boolean c(i iVar, boolean z) throws IOException {
        int i;
        int i2;
        int aG;
        int i3 = z ? 32768 : 131072;
        iVar.ic();
        if (iVar.ie() == 0) {
            a a = this.yX.a(iVar, (this.jF & 8) == 0 ? null : yT);
            this.dx = a;
            if (a != null) {
                this.yW.e(a);
            }
            i = (int) iVar.id();
            if (!z) {
                iVar.bH(i);
            }
            i2 = 0;
        } else {
            i2 = 0;
            i = 0;
        }
        int i4 = 0;
        int i5 = 0;
        while (true) {
            if (!D(iVar)) {
                this.uO.fx(0);
                int px = this.uO.px();
                if ((i2 == 0 || f(px, (long) i2)) && (aG = r.aG(px)) != -1) {
                    i4++;
                    if (i4 != 1) {
                        if (i4 == 4) {
                            break;
                        }
                    } else {
                        this.yV.aK(px);
                        i2 = px;
                    }
                    iVar.bI(aG - 4);
                } else {
                    int i6 = i5 + 1;
                    if (i5 != i3) {
                        if (z) {
                            iVar.ic();
                            iVar.bI(i + i6);
                        } else {
                            iVar.bH(1);
                        }
                        i5 = i6;
                        i2 = 0;
                        i4 = 0;
                    } else if (z) {
                        return false;
                    } else {
                        throw ai.c("Searched too many bytes.", (Throwable) null);
                    }
                }
            } else if (i4 <= 0) {
                throw new EOFException();
            }
        }
        if (z) {
            iVar.bH(i + i5);
        } else {
            iVar.ic();
        }
        this.zb = i2;
        return true;
    }

    private boolean D(i iVar) throws IOException {
        e eVar = this.zf;
        if (eVar != null) {
            long iF = eVar.iF();
            if (iF != -1 && iVar.id() > iF - 4) {
                return true;
            }
        }
        try {
            return !iVar.b(this.uO.hO(), 0, 4, true);
        } catch (EOFException unused) {
            return true;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: com.applovin.exoplayer2.e.f.e} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: com.applovin.exoplayer2.e.f.c} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: com.applovin.exoplayer2.e.f.b} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: com.applovin.exoplayer2.e.f.b} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: com.applovin.exoplayer2.e.f.b} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v13, resolved type: com.applovin.exoplayer2.e.f.b} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: com.applovin.exoplayer2.e.f.b} */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004e, code lost:
        if (r0 == null) goto L_0x0051;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0051, code lost:
        r0 = null;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.applovin.exoplayer2.e.f.e E(com.applovin.exoplayer2.e.i r12) throws java.io.IOException {
        /*
            r11 = this;
            com.applovin.exoplayer2.e.f.e r0 = r11.F(r12)
            com.applovin.exoplayer2.g.a r1 = r11.dx
            long r2 = r12.ie()
            com.applovin.exoplayer2.e.f.c r1 = a(r1, r2)
            boolean r2 = r11.zg
            if (r2 == 0) goto L_0x0018
            com.applovin.exoplayer2.e.f.e$a r12 = new com.applovin.exoplayer2.e.f.e$a
            r12.<init>()
            return r12
        L_0x0018:
            int r2 = r11.jF
            r2 = r2 & 4
            if (r2 == 0) goto L_0x004a
            if (r1 == 0) goto L_0x002b
            long r2 = r1.dd()
            long r0 = r1.iF()
        L_0x0028:
            r9 = r0
            r5 = r2
            goto L_0x003f
        L_0x002b:
            if (r0 == 0) goto L_0x0036
            long r2 = r0.dd()
            long r0 = r0.iF()
            goto L_0x0028
        L_0x0036:
            com.applovin.exoplayer2.g.a r0 = r11.dx
            long r2 = f(r0)
            r0 = -1
            goto L_0x0028
        L_0x003f:
            com.applovin.exoplayer2.e.f.b r0 = new com.applovin.exoplayer2.e.f.b
            long r7 = r12.ie()
            r4 = r0
            r4.<init>(r5, r7, r9)
            goto L_0x0052
        L_0x004a:
            if (r1 == 0) goto L_0x004e
            r0 = r1
            goto L_0x0052
        L_0x004e:
            if (r0 == 0) goto L_0x0051
            goto L_0x0052
        L_0x0051:
            r0 = 0
        L_0x0052:
            r1 = 1
            if (r0 == 0) goto L_0x0060
            boolean r2 = r0.hU()
            if (r2 != 0) goto L_0x006c
            int r2 = r11.jF
            r2 = r2 & r1
            if (r2 == 0) goto L_0x006c
        L_0x0060:
            int r0 = r11.jF
            r0 = r0 & 2
            if (r0 == 0) goto L_0x0067
            goto L_0x0068
        L_0x0067:
            r1 = 0
        L_0x0068:
            com.applovin.exoplayer2.e.f.e r0 = r11.d(r12, r1)
        L_0x006c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.e.f.d.E(com.applovin.exoplayer2.e.i):com.applovin.exoplayer2.e.f.e");
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0043 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00af A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:31:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.applovin.exoplayer2.e.f.e F(com.applovin.exoplayer2.e.i r11) throws java.io.IOException {
        /*
            r10 = this;
            com.applovin.exoplayer2.l.y r5 = new com.applovin.exoplayer2.l.y
            com.applovin.exoplayer2.b.r$a r0 = r10.yV
            int r0 = r0.jz
            r5.<init>((int) r0)
            byte[] r0 = r5.hO()
            com.applovin.exoplayer2.b.r$a r1 = r10.yV
            int r1 = r1.jz
            r6 = 0
            r11.c(r0, r6, r1)
            com.applovin.exoplayer2.b.r$a r0 = r10.yV
            int r0 = r0.mH
            r1 = 1
            r0 = r0 & r1
            r2 = 21
            if (r0 == 0) goto L_0x002a
            com.applovin.exoplayer2.b.r$a r0 = r10.yV
            int r0 = r0.mI
            if (r0 == r1) goto L_0x0030
            r2 = 36
            r7 = 36
            goto L_0x0037
        L_0x002a:
            com.applovin.exoplayer2.b.r$a r0 = r10.yV
            int r0 = r0.mI
            if (r0 == r1) goto L_0x0033
        L_0x0030:
            r7 = 21
            goto L_0x0037
        L_0x0033:
            r2 = 13
            r7 = 13
        L_0x0037:
            int r8 = f((com.applovin.exoplayer2.l.y) r5, (int) r7)
            r0 = 1483304551(0x58696e67, float:1.02664153E15)
            r9 = 1231971951(0x496e666f, float:976486.94)
            if (r8 == r0) goto L_0x0066
            if (r8 != r9) goto L_0x0046
            goto L_0x0066
        L_0x0046:
            r0 = 1447187017(0x56425249, float:5.3414667E13)
            if (r8 != r0) goto L_0x0061
            long r0 = r11.m1771if()
            long r2 = r11.ie()
            com.applovin.exoplayer2.b.r$a r4 = r10.yV
            com.applovin.exoplayer2.e.f.f r0 = com.applovin.exoplayer2.e.f.f.a(r0, r2, r4, r5)
            com.applovin.exoplayer2.b.r$a r1 = r10.yV
            int r1 = r1.jz
            r11.bH(r1)
            goto L_0x00b6
        L_0x0061:
            r11.ic()
            r0 = 0
            goto L_0x00b6
        L_0x0066:
            long r0 = r11.m1771if()
            long r2 = r11.ie()
            com.applovin.exoplayer2.b.r$a r4 = r10.yV
            com.applovin.exoplayer2.e.f.g r0 = com.applovin.exoplayer2.e.f.g.b(r0, r2, r4, r5)
            if (r0 == 0) goto L_0x00a0
            com.applovin.exoplayer2.e.r r1 = r10.yW
            boolean r1 = r1.ij()
            if (r1 != 0) goto L_0x00a0
            r11.ic()
            int r7 = r7 + 141
            r11.bI(r7)
            com.applovin.exoplayer2.l.y r1 = r10.uO
            byte[] r1 = r1.hO()
            r2 = 3
            r11.c(r1, r6, r2)
            com.applovin.exoplayer2.l.y r1 = r10.uO
            r1.fx(r6)
            com.applovin.exoplayer2.e.r r1 = r10.yW
            com.applovin.exoplayer2.l.y r2 = r10.uO
            int r2 = r2.pt()
            r1.bP(r2)
        L_0x00a0:
            com.applovin.exoplayer2.b.r$a r1 = r10.yV
            int r1 = r1.jz
            r11.bH(r1)
            if (r0 == 0) goto L_0x00b6
            boolean r1 = r0.hU()
            if (r1 != 0) goto L_0x00b6
            if (r8 != r9) goto L_0x00b6
            com.applovin.exoplayer2.e.f.e r11 = r10.d(r11, r6)
            return r11
        L_0x00b6:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.e.f.d.F(com.applovin.exoplayer2.e.i):com.applovin.exoplayer2.e.f.e");
    }

    private e d(i iVar, boolean z) throws IOException {
        iVar.c(this.uO.hO(), 0, 4);
        this.uO.fx(0);
        this.yV.aK(this.uO.px());
        return new a(iVar.m1771if(), iVar.ie(), this.yV, z);
    }

    private void io() {
        com.applovin.exoplayer2.l.a.N(this.yZ);
        com.applovin.exoplayer2.l.ai.R(this.vG);
    }

    private static int f(y yVar, int i) {
        if (yVar.pk() >= i + 4) {
            yVar.fx(i);
            int px = yVar.px();
            if (px == 1483304551 || px == 1231971951) {
                return px;
            }
        }
        if (yVar.pk() < 40) {
            return 0;
        }
        yVar.fx(36);
        return yVar.px() == 1447187017 ? 1447187017 : 0;
    }

    private static c a(a aVar, long j) {
        if (aVar == null) {
            return null;
        }
        int kD = aVar.kD();
        for (int i = 0; i < kD; i++) {
            a.C0047a de = aVar.de(i);
            if (de instanceof com.applovin.exoplayer2.g.e.j) {
                return c.a(j, (com.applovin.exoplayer2.g.e.j) de, f(aVar));
            }
        }
        return null;
    }

    private static long f(a aVar) {
        if (aVar == null) {
            return -9223372036854775807L;
        }
        int kD = aVar.kD();
        for (int i = 0; i < kD; i++) {
            a.C0047a de = aVar.de(i);
            if (de instanceof com.applovin.exoplayer2.g.e.l) {
                com.applovin.exoplayer2.g.e.l lVar = (com.applovin.exoplayer2.g.e.l) de;
                if (lVar.f5do.equals("TLEN")) {
                    return com.applovin.exoplayer2.h.g(Long.parseLong(lVar.Jn));
                }
            }
        }
        return -9223372036854775807L;
    }
}
