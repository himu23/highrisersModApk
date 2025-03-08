package com.applovin.exoplayer2.e.g;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Pair;
import com.applovin.exoplayer2.ai;
import com.applovin.exoplayer2.b.c;
import com.applovin.exoplayer2.common.base.Function;
import com.applovin.exoplayer2.d.e;
import com.applovin.exoplayer2.e.g.a;
import com.applovin.exoplayer2.e.h;
import com.applovin.exoplayer2.e.i;
import com.applovin.exoplayer2.e.j;
import com.applovin.exoplayer2.e.l;
import com.applovin.exoplayer2.e.r;
import com.applovin.exoplayer2.e.u;
import com.applovin.exoplayer2.e.v;
import com.applovin.exoplayer2.e.w;
import com.applovin.exoplayer2.e.x;
import com.applovin.exoplayer2.g.a;
import com.applovin.exoplayer2.g.f.b;
import com.applovin.exoplayer2.l.y;
import com.applovin.exoplayer2.v;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public final class g implements h, v {
    public static final l vq = new g$$ExternalSyntheticLambda0();
    private final List<a.C0047a> AA;
    private int AB;
    private a[] AC;
    private long[][] AD;
    private int AE;
    private int AF;
    private long Aa;
    private int Ab;
    private y Ac;
    private final i Az;
    private long fH;
    private final int jF;
    private final y uO;
    private j vG;
    private final y wm;
    private final y wn;
    private b wu;
    private int xI;
    private int xJ;
    private int xK;
    private final y zU;
    private final ArrayDeque<a.C0041a> zV;
    private int zY;
    private int zZ;

    /* access modifiers changed from: private */
    public static /* synthetic */ k b(k kVar) {
        return kVar;
    }

    private static boolean cm(int i) {
        return i == 1835296868 || i == 1836476516 || i == 1751411826 || i == 1937011556 || i == 1937011827 || i == 1937011571 || i == 1668576371 || i == 1701606260 || i == 1937011555 || i == 1937011578 || i == 1937013298 || i == 1937007471 || i == 1668232756 || i == 1953196132 || i == 1718909296 || i == 1969517665 || i == 1801812339 || i == 1768715124;
    }

    private static boolean cn(int i) {
        return i == 1836019574 || i == 1953653099 || i == 1835297121 || i == 1835626086 || i == 1937007212 || i == 1701082227 || i == 1835365473;
    }

    private static int co(int i) {
        if (i != 1751476579) {
            return i != 1903435808 ? 0 : 1;
        }
        return 2;
    }

    private void iL() {
        this.zY = 0;
        this.Ab = 0;
    }

    public void a(j jVar) {
        this.vG = jVar;
    }

    public long dd() {
        return this.fH;
    }

    public boolean hU() {
        return true;
    }

    public void release() {
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ h[] ih() {
        return new h[]{new g()};
    }

    public g() {
        this(0);
    }

    public g(int i) {
        this.jF = i;
        this.zY = (i & 4) != 0 ? 3 : 0;
        this.Az = new i();
        this.AA = new ArrayList();
        this.zU = new y(16);
        this.zV = new ArrayDeque<>();
        this.wm = new y(com.applovin.exoplayer2.l.v.abK);
        this.wn = new y(4);
        this.uO = new y();
        this.AB = -1;
    }

    public boolean a(i iVar) throws IOException {
        return j.e(iVar, (this.jF & 2) != 0);
    }

    public void o(long j, long j2) {
        this.zV.clear();
        this.Ab = 0;
        this.AB = -1;
        this.xI = 0;
        this.xJ = 0;
        this.xK = 0;
        if (j == 0) {
            if (this.zY != 3) {
                iL();
                return;
            }
            this.Az.Y();
            this.AA.clear();
        } else if (this.AC != null) {
            ay(j2);
        }
    }

    public int b(i iVar, u uVar) throws IOException {
        while (true) {
            int i = this.zY;
            if (i != 0) {
                if (i != 1) {
                    if (i == 2) {
                        return f(iVar, uVar);
                    }
                    if (i == 3) {
                        return e(iVar, uVar);
                    }
                    throw new IllegalStateException();
                } else if (d(iVar, uVar)) {
                    return 1;
                }
            } else if (!G(iVar)) {
                return -1;
            }
        }
    }

    public v.a ai(long j) {
        long j2;
        long j3;
        long j4;
        long j5;
        int aB;
        if (((a[]) com.applovin.exoplayer2.l.a.checkNotNull(this.AC)).length == 0) {
            return new v.a(w.uT);
        }
        int i = this.AE;
        if (i != -1) {
            n nVar = this.AC[i].AH;
            int a2 = a(nVar, j);
            if (a2 == -1) {
                return new v.a(w.uT);
            }
            long j6 = nVar.Bq[a2];
            j2 = nVar.tS[a2];
            if (j6 >= j || a2 >= nVar.jA - 1 || (aB = nVar.aB(j)) == -1 || aB == a2) {
                j5 = -1;
                j3 = -9223372036854775807L;
            } else {
                j3 = nVar.Bq[aB];
                j5 = nVar.tS[aB];
            }
            j4 = j5;
            j = j6;
        } else {
            j2 = Long.MAX_VALUE;
            j4 = -1;
            j3 = -9223372036854775807L;
        }
        int i2 = 0;
        while (true) {
            a[] aVarArr = this.AC;
            if (i2 >= aVarArr.length) {
                break;
            }
            if (i2 != this.AE) {
                n nVar2 = aVarArr[i2].AH;
                long a3 = a(nVar2, j, j2);
                if (j3 != -9223372036854775807L) {
                    j4 = a(nVar2, j3, j4);
                }
                j2 = a3;
            }
            i2++;
        }
        w wVar = new w(j, j2);
        if (j3 == -9223372036854775807L) {
            return new v.a(wVar);
        }
        return new v.a(wVar, new w(j3, j4));
    }

    private boolean G(i iVar) throws IOException {
        a.C0041a peek;
        if (this.Ab == 0) {
            if (!iVar.a(this.zU.hO(), 0, 8, true)) {
                iV();
                return false;
            }
            this.Ab = 8;
            this.zU.fx(0);
            this.Aa = this.zU.pv();
            this.zZ = this.zU.px();
        }
        long j = this.Aa;
        if (j == 1) {
            iVar.a(this.zU.hO(), 8, 8);
            this.Ab += 8;
            this.Aa = this.zU.pF();
        } else if (j == 0) {
            long j2 = iVar.m1771if();
            if (j2 == -1 && (peek = this.zV.peek()) != null) {
                j2 = peek.zl;
            }
            if (j2 != -1) {
                this.Aa = (j2 - iVar.ie()) + ((long) this.Ab);
            }
        }
        if (this.Aa >= ((long) this.Ab)) {
            if (cn(this.zZ)) {
                long ie = iVar.ie();
                long j3 = this.Aa;
                int i = this.Ab;
                long j4 = (ie + j3) - ((long) i);
                if (j3 != ((long) i) && this.zZ == 1835365473) {
                    K(iVar);
                }
                this.zV.push(new a.C0041a(this.zZ, j4));
                if (this.Aa == ((long) this.Ab)) {
                    au(j4);
                } else {
                    iL();
                }
            } else if (cm(this.zZ)) {
                com.applovin.exoplayer2.l.a.checkState(this.Ab == 8);
                com.applovin.exoplayer2.l.a.checkState(this.Aa <= 2147483647L);
                y yVar = new y((int) this.Aa);
                System.arraycopy(this.zU.hO(), 0, yVar.hO(), 0, 8);
                this.Ac = yVar;
                this.zY = 1;
            } else {
                az(iVar.ie() - ((long) this.Ab));
                this.Ac = null;
                this.zY = 1;
            }
            return true;
        }
        throw ai.p("Atom size less than header length (unsupported).");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0064 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean d(com.applovin.exoplayer2.e.i r10, com.applovin.exoplayer2.e.u r11) throws java.io.IOException {
        /*
            r9 = this;
            long r0 = r9.Aa
            int r2 = r9.Ab
            long r2 = (long) r2
            long r0 = r0 - r2
            long r2 = r10.ie()
            long r2 = r2 + r0
            com.applovin.exoplayer2.l.y r4 = r9.Ac
            r5 = 1
            r6 = 0
            if (r4 == 0) goto L_0x0044
            byte[] r11 = r4.hO()
            int r7 = r9.Ab
            int r1 = (int) r0
            r10.a(r11, r7, r1)
            int r10 = r9.zZ
            r11 = 1718909296(0x66747970, float:2.8862439E23)
            if (r10 != r11) goto L_0x0029
            int r10 = D(r4)
            r9.AF = r10
            goto L_0x004f
        L_0x0029:
            java.util.ArrayDeque<com.applovin.exoplayer2.e.g.a$a> r10 = r9.zV
            boolean r10 = r10.isEmpty()
            if (r10 != 0) goto L_0x004f
            java.util.ArrayDeque<com.applovin.exoplayer2.e.g.a$a> r10 = r9.zV
            java.lang.Object r10 = r10.peek()
            com.applovin.exoplayer2.e.g.a$a r10 = (com.applovin.exoplayer2.e.g.a.C0041a) r10
            com.applovin.exoplayer2.e.g.a$b r11 = new com.applovin.exoplayer2.e.g.a$b
            int r0 = r9.zZ
            r11.<init>(r0, r4)
            r10.a((com.applovin.exoplayer2.e.g.a.b) r11)
            goto L_0x004f
        L_0x0044:
            r7 = 262144(0x40000, double:1.295163E-318)
            int r4 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r4 >= 0) goto L_0x0051
            int r11 = (int) r0
            r10.bH(r11)
        L_0x004f:
            r10 = 0
            goto L_0x0059
        L_0x0051:
            long r7 = r10.ie()
            long r7 = r7 + r0
            r11.uc = r7
            r10 = 1
        L_0x0059:
            r9.au(r2)
            if (r10 == 0) goto L_0x0064
            int r10 = r9.zY
            r11 = 2
            if (r10 == r11) goto L_0x0064
            goto L_0x0065
        L_0x0064:
            r5 = 0
        L_0x0065:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.e.g.g.d(com.applovin.exoplayer2.e.i, com.applovin.exoplayer2.e.u):boolean");
    }

    private int e(i iVar, u uVar) throws IOException {
        int a2 = this.Az.a(iVar, uVar, this.AA);
        if (a2 == 1 && uVar.uc == 0) {
            iL();
        }
        return a2;
    }

    private void au(long j) throws ai {
        while (!this.zV.isEmpty() && this.zV.peek().zl == j) {
            a.C0041a pop = this.zV.pop();
            if (pop.bs == 1836019574) {
                g(pop);
                this.zV.clear();
                this.zY = 2;
            } else if (!this.zV.isEmpty()) {
                this.zV.peek().a(pop);
            }
        }
        if (this.zY != 2) {
            iL();
        }
    }

    private void g(a.C0041a aVar) throws ai {
        com.applovin.exoplayer2.g.a aVar2;
        com.applovin.exoplayer2.g.a aVar3;
        int i;
        List<n> list;
        ArrayList arrayList;
        int i2;
        a.C0041a aVar4 = aVar;
        ArrayList arrayList2 = new ArrayList();
        boolean z = this.AF == 1;
        r rVar = new r();
        a.b ci = aVar4.ci(1969517665);
        if (ci != null) {
            Pair<com.applovin.exoplayer2.g.a, com.applovin.exoplayer2.g.a> b = b.b(ci);
            com.applovin.exoplayer2.g.a aVar5 = (com.applovin.exoplayer2.g.a) b.first;
            com.applovin.exoplayer2.g.a aVar6 = (com.applovin.exoplayer2.g.a) b.second;
            if (aVar5 != null) {
                rVar.e(aVar5);
            }
            aVar3 = aVar6;
            aVar2 = aVar5;
        } else {
            aVar3 = null;
            aVar2 = null;
        }
        a.C0041a cj = aVar4.cj(1835365473);
        com.applovin.exoplayer2.g.a b2 = cj != null ? b.b(cj) : null;
        List<n> a2 = b.a(aVar, rVar, -9223372036854775807L, (e) null, (this.jF & 1) != 0, z, (Function<k, k>) new g$$ExternalSyntheticLambda1());
        j jVar = (j) com.applovin.exoplayer2.l.a.checkNotNull(this.vG);
        int size = a2.size();
        int i3 = 0;
        int i4 = -1;
        long j = -9223372036854775807L;
        while (i3 < size) {
            n nVar = a2.get(i3);
            if (nVar.jA == 0) {
                list = a2;
                i = size;
                arrayList = arrayList2;
            } else {
                k kVar = nVar.AG;
                int i5 = i4;
                arrayList = arrayList2;
                long j2 = kVar.fH != -9223372036854775807L ? kVar.fH : nVar.fH;
                long max = Math.max(j, j2);
                list = a2;
                i = size;
                a aVar7 = new a(kVar, nVar, jVar.y(i3, kVar.bs));
                long j3 = max;
                v.a bR = kVar.dU.bR();
                bR.I(nVar.zH + 30);
                if (kVar.bs == 2 && j2 > 0 && nVar.jA > 1) {
                    bR.d(((float) nVar.jA) / (((float) j2) / 1000000.0f));
                }
                f.a(kVar.bs, rVar, bR);
                int i6 = kVar.bs;
                com.applovin.exoplayer2.g.a[] aVarArr = new com.applovin.exoplayer2.g.a[2];
                aVarArr[0] = aVar3;
                aVarArr[1] = this.AA.isEmpty() ? null : new com.applovin.exoplayer2.g.a((List<? extends a.C0047a>) this.AA);
                f.a(i6, aVar2, b2, bR, aVarArr);
                aVar7.vH.j(bR.bT());
                if (kVar.bs == 2) {
                    i2 = i5;
                    if (i2 == -1) {
                        i2 = arrayList.size();
                    }
                } else {
                    i2 = i5;
                }
                i4 = i2;
                arrayList.add(aVar7);
                j = j3;
            }
            i3++;
            arrayList2 = arrayList;
            a2 = list;
            size = i;
        }
        this.AE = i4;
        this.fH = j;
        a[] aVarArr2 = (a[]) arrayList2.toArray(new a[0]);
        this.AC = aVarArr2;
        this.AD = a(aVarArr2);
        jVar.ig();
        jVar.a(this);
    }

    private int f(i iVar, u uVar) throws IOException {
        long ie = iVar.ie();
        if (this.AB == -1) {
            int ax = ax(ie);
            this.AB = ax;
            if (ax == -1) {
                return -1;
            }
        }
        a aVar = ((a[]) com.applovin.exoplayer2.l.ai.R(this.AC))[this.AB];
        x xVar = aVar.vH;
        int i = aVar.zB;
        long j = aVar.AH.tS[i];
        int i2 = aVar.AH.tR[i];
        long j2 = (j - ie) + ((long) this.xI);
        if (j2 < 0 || j2 >= PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
            uVar.uc = j;
            return 1;
        }
        if (aVar.AG.AR == 1) {
            j2 += 8;
            i2 -= 8;
        }
        iVar.bH((int) j2);
        if (aVar.AG.wo == 0) {
            if ("audio/ac4".equals(aVar.AG.dU.dz)) {
                if (this.xJ == 0) {
                    c.a(i2, this.uO);
                    xVar.c(this.uO, 7);
                    this.xJ += 7;
                }
                i2 += 7;
            }
            while (true) {
                int i3 = this.xJ;
                if (i3 >= i2) {
                    break;
                }
                int a2 = xVar.a((com.applovin.exoplayer2.k.g) iVar, i2 - i3, false);
                this.xI += a2;
                this.xJ += a2;
                this.xK -= a2;
            }
        } else {
            byte[] hO = this.wn.hO();
            hO[0] = 0;
            hO[1] = 0;
            hO[2] = 0;
            int i4 = aVar.AG.wo;
            int i5 = 4 - aVar.AG.wo;
            while (this.xJ < i2) {
                int i6 = this.xK;
                if (i6 == 0) {
                    iVar.a(hO, i5, i4);
                    this.xI += i4;
                    this.wn.fx(0);
                    int px = this.wn.px();
                    if (px >= 0) {
                        this.xK = px;
                        this.wm.fx(0);
                        xVar.c(this.wm, 4);
                        this.xJ += 4;
                        i2 += i5;
                    } else {
                        throw ai.c("Invalid NAL length", (Throwable) null);
                    }
                } else {
                    int a3 = xVar.a((com.applovin.exoplayer2.k.g) iVar, i6, false);
                    this.xI += a3;
                    this.xJ += a3;
                    this.xK -= a3;
                }
            }
        }
        xVar.a(aVar.AH.Bq[i], aVar.AH.zJ[i], i2, 0, (x.a) null);
        aVar.zB++;
        this.AB = -1;
        this.xI = 0;
        this.xJ = 0;
        this.xK = 0;
        return 0;
    }

    private int ax(long j) {
        int i = -1;
        int i2 = -1;
        long j2 = Long.MAX_VALUE;
        boolean z = true;
        long j3 = Long.MAX_VALUE;
        boolean z2 = true;
        long j4 = Long.MAX_VALUE;
        for (int i3 = 0; i3 < ((a[]) com.applovin.exoplayer2.l.ai.R(this.AC)).length; i3++) {
            a aVar = this.AC[i3];
            int i4 = aVar.zB;
            if (i4 != aVar.AH.jA) {
                long j5 = aVar.AH.tS[i4];
                long j6 = ((long[][]) com.applovin.exoplayer2.l.ai.R(this.AD))[i3][i4];
                long j7 = j5 - j;
                boolean z3 = j7 < 0 || j7 >= PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
                if ((!z3 && z2) || (z3 == z2 && j7 < j4)) {
                    z2 = z3;
                    j4 = j7;
                    i2 = i3;
                    j3 = j6;
                }
                if (j6 < j2) {
                    z = z3;
                    i = i3;
                    j2 = j6;
                }
            }
        }
        return (j2 == Long.MAX_VALUE || !z || j3 < j2 + 10485760) ? i2 : i;
    }

    private void ay(long j) {
        for (a aVar : this.AC) {
            n nVar = aVar.AH;
            int aA = nVar.aA(j);
            if (aA == -1) {
                aA = nVar.aB(j);
            }
            aVar.zB = aA;
        }
    }

    private void iV() {
        com.applovin.exoplayer2.g.a aVar;
        if (this.AF == 2 && (this.jF & 2) != 0) {
            j jVar = (j) com.applovin.exoplayer2.l.a.checkNotNull(this.vG);
            x y = jVar.y(0, 4);
            if (this.wu == null) {
                aVar = null;
            } else {
                aVar = new com.applovin.exoplayer2.g.a(this.wu);
            }
            y.j(new v.a().b(aVar).bT());
            jVar.ig();
            jVar.a(new v.b(-9223372036854775807L));
        }
    }

    private void K(i iVar) throws IOException {
        this.uO.U(8);
        iVar.c(this.uO.hO(), 0, 8);
        b.p(this.uO);
        iVar.bH(this.uO.il());
        iVar.ic();
    }

    private void az(long j) {
        if (this.zZ == 1836086884) {
            int i = this.Ab;
            this.wu = new b(0, j, -9223372036854775807L, j + ((long) i), this.Aa - ((long) i));
        }
    }

    private static long[][] a(a[] aVarArr) {
        long[][] jArr = new long[aVarArr.length][];
        int[] iArr = new int[aVarArr.length];
        long[] jArr2 = new long[aVarArr.length];
        boolean[] zArr = new boolean[aVarArr.length];
        for (int i = 0; i < aVarArr.length; i++) {
            jArr[i] = new long[aVarArr[i].AH.jA];
            jArr2[i] = aVarArr[i].AH.Bq[0];
        }
        long j = 0;
        int i2 = 0;
        while (i2 < aVarArr.length) {
            long j2 = Long.MAX_VALUE;
            int i3 = -1;
            for (int i4 = 0; i4 < aVarArr.length; i4++) {
                if (!zArr[i4]) {
                    long j3 = jArr2[i4];
                    if (j3 <= j2) {
                        i3 = i4;
                        j2 = j3;
                    }
                }
            }
            int i5 = iArr[i3];
            jArr[i3][i5] = j;
            j += (long) aVarArr[i3].AH.tR[i5];
            int i6 = i5 + 1;
            iArr[i3] = i6;
            if (i6 < jArr[i3].length) {
                jArr2[i3] = aVarArr[i3].AH.Bq[i6];
            } else {
                zArr[i3] = true;
                i2++;
            }
        }
        return jArr;
    }

    private static long a(n nVar, long j, long j2) {
        int a2 = a(nVar, j);
        if (a2 == -1) {
            return j2;
        }
        return Math.min(nVar.tS[a2], j2);
    }

    private static int a(n nVar, long j) {
        int aA = nVar.aA(j);
        return aA == -1 ? nVar.aB(j) : aA;
    }

    private static int D(y yVar) {
        yVar.fx(8);
        int co = co(yVar.px());
        if (co != 0) {
            return co;
        }
        yVar.fz(4);
        while (yVar.pj() > 0) {
            int co2 = co(yVar.px());
            if (co2 != 0) {
                return co2;
            }
        }
        return 0;
    }

    private static final class a {
        public final k AG;
        public final n AH;
        public final x vH;
        public int zB;

        public a(k kVar, n nVar, x xVar) {
            this.AG = kVar;
            this.AH = nVar;
            this.vH = xVar;
        }
    }
}
