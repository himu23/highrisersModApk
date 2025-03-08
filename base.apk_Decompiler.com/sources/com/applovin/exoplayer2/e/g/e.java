package com.applovin.exoplayer2.e.g;

import android.util.Pair;
import android.util.SparseArray;
import com.applovin.exoplayer2.ai;
import com.applovin.exoplayer2.common.base.Ascii;
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
import com.applovin.exoplayer2.e.x;
import com.applovin.exoplayer2.g.b.c;
import com.applovin.exoplayer2.k.g;
import com.applovin.exoplayer2.l.ag;
import com.applovin.exoplayer2.l.q;
import com.applovin.exoplayer2.l.y;
import com.applovin.exoplayer2.v;
import com.unity3d.services.core.device.MimeTypes;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import kotlin.UByte;

public class e implements h {
    public static final l vq = new e$$ExternalSyntheticLambda1();
    private static final byte[] zK = {-94, 57, 79, 82, 90, -101, 79, Ascii.DC4, -94, 68, 108, 66, 124, 100, -115, -12};
    private static final v zL = new v.a().m("application/x-emsg").bT();
    private long Aa;
    private int Ab;
    private y Ac;
    private long Ad;
    private int Ae;
    private long Af;
    private long Ag;
    private b Ah;
    private int Ai;
    private boolean Aj;
    private x[] Ak;
    private x[] Al;
    private boolean Am;
    private long fH;
    private final int jF;
    private final y uO;
    private j vG;
    private final y wm;
    private int xJ;
    private int xK;
    private final k zM;
    private final List<v> zN;
    private final SparseArray<b> zO;
    private final y zP;
    private final y zQ;
    private final byte[] zR;
    private final ag zS;
    private final c zT;
    private final y zU;
    private final ArrayDeque<a.C0041a> zV;
    private final ArrayDeque<a> zW;
    private final x zX;
    private int zY;
    private int zZ;

    private static boolean cm(int i) {
        return i == 1751411826 || i == 1835296868 || i == 1836476516 || i == 1936286840 || i == 1937011556 || i == 1937011827 || i == 1668576371 || i == 1937011555 || i == 1937011578 || i == 1937013298 || i == 1937007471 || i == 1668232756 || i == 1937011571 || i == 1952867444 || i == 1952868452 || i == 1953196132 || i == 1953654136 || i == 1953658222 || i == 1886614376 || i == 1935763834 || i == 1935763823 || i == 1936027235 || i == 1970628964 || i == 1935828848 || i == 1936158820 || i == 1701606260 || i == 1835362404 || i == 1701671783;
    }

    private static boolean cn(int i) {
        return i == 1836019574 || i == 1953653099 || i == 1835297121 || i == 1835626086 || i == 1937007212 || i == 1836019558 || i == 1953653094 || i == 1836475768 || i == 1701082227;
    }

    private void iL() {
        this.zY = 0;
        this.Ab = 0;
    }

    /* access modifiers changed from: protected */
    public k a(k kVar) {
        return kVar;
    }

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
        this(i, (ag) null);
    }

    public e(int i, ag agVar) {
        this(i, agVar, (k) null, Collections.emptyList());
    }

    public e(int i, ag agVar, k kVar, List<v> list) {
        this(i, agVar, kVar, list, (x) null);
    }

    public e(int i, ag agVar, k kVar, List<v> list, x xVar) {
        this.jF = i;
        this.zS = agVar;
        this.zM = kVar;
        this.zN = Collections.unmodifiableList(list);
        this.zX = xVar;
        this.zT = new c();
        this.zU = new y(16);
        this.wm = new y(com.applovin.exoplayer2.l.v.abK);
        this.zP = new y(5);
        this.zQ = new y();
        byte[] bArr = new byte[16];
        this.zR = bArr;
        this.uO = new y(bArr);
        this.zV = new ArrayDeque<>();
        this.zW = new ArrayDeque<>();
        this.zO = new SparseArray<>();
        this.fH = -9223372036854775807L;
        this.Af = -9223372036854775807L;
        this.Ag = -9223372036854775807L;
        this.vG = j.uw;
        this.Ak = new x[0];
        this.Al = new x[0];
    }

    public boolean a(i iVar) throws IOException {
        return j.L(iVar);
    }

    public void a(j jVar) {
        this.vG = jVar;
        iL();
        iM();
        k kVar = this.zM;
        if (kVar != null) {
            this.zO.put(0, new b(jVar.y(0, kVar.bs), new n(this.zM, new long[0], new int[0], 0, new long[0], new int[0], 0), new c(0, 0, 0, 0)));
            this.vG.ig();
        }
    }

    public void o(long j, long j2) {
        int size = this.zO.size();
        for (int i = 0; i < size; i++) {
            this.zO.valueAt(i).iN();
        }
        this.zW.clear();
        this.Ae = 0;
        this.Af = j2;
        this.zV.clear();
        iL();
    }

    public int b(i iVar, u uVar) throws IOException {
        while (true) {
            int i = this.zY;
            if (i != 0) {
                if (i == 1) {
                    H(iVar);
                } else if (i == 2) {
                    I(iVar);
                } else if (J(iVar)) {
                    return 0;
                }
            } else if (!G(iVar)) {
                return -1;
            }
        }
    }

    private boolean G(i iVar) throws IOException {
        if (this.Ab == 0) {
            if (!iVar.a(this.zU.hO(), 0, 8, true)) {
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
            if (j2 == -1 && !this.zV.isEmpty()) {
                j2 = this.zV.peek().zl;
            }
            if (j2 != -1) {
                this.Aa = (j2 - iVar.ie()) + ((long) this.Ab);
            }
        }
        if (this.Aa >= ((long) this.Ab)) {
            long ie = iVar.ie() - ((long) this.Ab);
            int i = this.zZ;
            if ((i == 1836019558 || i == 1835295092) && !this.Am) {
                this.vG.a(new v.b(this.fH, ie));
                this.Am = true;
            }
            if (this.zZ == 1836019558) {
                int size = this.zO.size();
                for (int i2 = 0; i2 < size; i2++) {
                    m mVar = this.zO.valueAt(i2).Ao;
                    mVar.AZ = ie;
                    mVar.Bb = ie;
                    mVar.Ba = ie;
                }
            }
            int i3 = this.zZ;
            if (i3 == 1835295092) {
                this.Ah = null;
                this.Ad = ie + this.Aa;
                this.zY = 2;
                return true;
            }
            if (cn(i3)) {
                long ie2 = (iVar.ie() + this.Aa) - 8;
                this.zV.push(new a.C0041a(this.zZ, ie2));
                if (this.Aa == ((long) this.Ab)) {
                    au(ie2);
                } else {
                    iL();
                }
            } else if (cm(this.zZ)) {
                if (this.Ab == 8) {
                    long j3 = this.Aa;
                    if (j3 <= 2147483647L) {
                        y yVar = new y((int) j3);
                        System.arraycopy(this.zU.hO(), 0, yVar.hO(), 0, 8);
                        this.Ac = yVar;
                        this.zY = 1;
                    } else {
                        throw ai.p("Leaf atom with length > 2147483647 (unsupported).");
                    }
                } else {
                    throw ai.p("Leaf atom defines extended atom size (unsupported).");
                }
            } else if (this.Aa <= 2147483647L) {
                this.Ac = null;
                this.zY = 1;
            } else {
                throw ai.p("Skipping atom with length > 2147483647 (unsupported).");
            }
            return true;
        }
        throw ai.p("Atom size less than header length (unsupported).");
    }

    private void H(i iVar) throws IOException {
        int i = ((int) this.Aa) - this.Ab;
        y yVar = this.Ac;
        if (yVar != null) {
            iVar.a(yVar.hO(), 8, i);
            a(new a.b(this.zZ, yVar), iVar.ie());
        } else {
            iVar.bH(i);
        }
        au(iVar.ie());
    }

    private void au(long j) throws ai {
        while (!this.zV.isEmpty() && this.zV.peek().zl == j) {
            d(this.zV.pop());
        }
        iL();
    }

    private void a(a.b bVar, long j) throws ai {
        if (!this.zV.isEmpty()) {
            this.zV.peek().a(bVar);
        } else if (bVar.bs == 1936286840) {
            Pair<Long, com.applovin.exoplayer2.e.c> c = c(bVar.zo, j);
            this.Ag = ((Long) c.first).longValue();
            this.vG.a((com.applovin.exoplayer2.e.v) c.second);
            this.Am = true;
        } else if (bVar.bs == 1701671783) {
            v(bVar.zo);
        }
    }

    private void d(a.C0041a aVar) throws ai {
        if (aVar.bs == 1836019574) {
            e(aVar);
        } else if (aVar.bs == 1836019558) {
            f(aVar);
        } else if (!this.zV.isEmpty()) {
            this.zV.peek().a(aVar);
        }
    }

    private void e(a.C0041a aVar) throws ai {
        boolean z = true;
        int i = 0;
        com.applovin.exoplayer2.l.a.checkState(this.zM == null, "Unexpected moov box.");
        com.applovin.exoplayer2.d.e i2 = i(aVar.zm);
        a.C0041a aVar2 = (a.C0041a) com.applovin.exoplayer2.l.a.checkNotNull(aVar.cj(1836475768));
        SparseArray sparseArray = new SparseArray();
        int size = aVar2.zm.size();
        long j = -9223372036854775807L;
        for (int i3 = 0; i3 < size; i3++) {
            a.b bVar = aVar2.zm.get(i3);
            if (bVar.bs == 1953654136) {
                Pair<Integer, c> w = w(bVar.zo);
                sparseArray.put(((Integer) w.first).intValue(), (c) w.second);
            } else if (bVar.bs == 1835362404) {
                j = x(bVar.zo);
            }
        }
        List<n> a2 = b.a(aVar, new r(), j, i2, (this.jF & 16) != 0, false, (Function<k, k>) new e$$ExternalSyntheticLambda0(this));
        int size2 = a2.size();
        if (this.zO.size() == 0) {
            while (i < size2) {
                n nVar = a2.get(i);
                k kVar = nVar.AG;
                this.zO.put(kVar.zD, new b(this.vG.y(i, kVar.bs), nVar, a((SparseArray<c>) sparseArray, kVar.zD)));
                this.fH = Math.max(this.fH, kVar.fH);
                i++;
            }
            this.vG.ig();
            return;
        }
        if (this.zO.size() != size2) {
            z = false;
        }
        com.applovin.exoplayer2.l.a.checkState(z);
        while (i < size2) {
            n nVar2 = a2.get(i);
            k kVar2 = nVar2.AG;
            this.zO.get(kVar2.zD).a(nVar2, a((SparseArray<c>) sparseArray, kVar2.zD));
            i++;
        }
    }

    private c a(SparseArray<c> sparseArray, int i) {
        if (sparseArray.size() == 1) {
            return sparseArray.valueAt(0);
        }
        return (c) com.applovin.exoplayer2.l.a.checkNotNull(sparseArray.get(i));
    }

    private void f(a.C0041a aVar) throws ai {
        a(aVar, this.zO, this.zM != null, this.jF, this.zR);
        com.applovin.exoplayer2.d.e i = i(aVar.zm);
        if (i != null) {
            int size = this.zO.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.zO.valueAt(i2).c(i);
            }
        }
        if (this.Af != -9223372036854775807L) {
            int size2 = this.zO.size();
            for (int i3 = 0; i3 < size2; i3++) {
                this.zO.valueAt(i3).aw(this.Af);
            }
            this.Af = -9223372036854775807L;
        }
    }

    private void iM() {
        int i;
        x[] xVarArr = new x[2];
        this.Ak = xVarArr;
        x xVar = this.zX;
        int i2 = 0;
        if (xVar != null) {
            xVarArr[0] = xVar;
            i = 1;
        } else {
            i = 0;
        }
        int i3 = 100;
        if ((this.jF & 4) != 0) {
            xVarArr[i] = this.vG.y(100, 5);
            i3 = 101;
            i++;
        }
        x[] xVarArr2 = (x[]) com.applovin.exoplayer2.l.ai.e(this.Ak, i);
        this.Ak = xVarArr2;
        for (x j : xVarArr2) {
            j.j(zL);
        }
        this.Al = new x[this.zN.size()];
        while (i2 < this.Al.length) {
            x y = this.vG.y(i3, 3);
            y.j(this.zN.get(i2));
            this.Al[i2] = y;
            i2++;
            i3++;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v1, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void v(com.applovin.exoplayer2.l.y r27) {
        /*
            r26 = this;
            r0 = r26
            r1 = r27
            com.applovin.exoplayer2.e.x[] r2 = r0.Ak
            int r2 = r2.length
            if (r2 != 0) goto L_0x000a
            return
        L_0x000a:
            r2 = 8
            r1.fx(r2)
            int r2 = r27.px()
            int r2 = com.applovin.exoplayer2.e.g.a.cf(r2)
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r2 == 0) goto L_0x0071
            r5 = 1
            if (r2 == r5) goto L_0x0035
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r3 = "Skipping unsupported emsg version: "
            r1.<init>(r3)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "FragmentedMp4Extractor"
            com.applovin.exoplayer2.l.q.h(r2, r1)
            return
        L_0x0035:
            long r11 = r27.pv()
            long r5 = r27.pF()
            r7 = 1000000(0xf4240, double:4.940656E-318)
            r9 = r11
            long r13 = com.applovin.exoplayer2.l.ai.e(r5, r7, r9)
            long r5 = r27.pv()
            r7 = 1000(0x3e8, double:4.94E-321)
            long r5 = com.applovin.exoplayer2.l.ai.e(r5, r7, r9)
            long r7 = r27.pv()
            java.lang.String r2 = r27.pI()
            java.lang.Object r2 = com.applovin.exoplayer2.l.a.checkNotNull(r2)
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String r9 = r27.pI()
            java.lang.Object r9 = com.applovin.exoplayer2.l.a.checkNotNull(r9)
            java.lang.String r9 = (java.lang.String) r9
            r19 = r2
            r21 = r5
            r23 = r7
            r20 = r9
            r7 = r3
            goto L_0x00bb
        L_0x0071:
            java.lang.String r2 = r27.pI()
            java.lang.Object r2 = com.applovin.exoplayer2.l.a.checkNotNull(r2)
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String r5 = r27.pI()
            java.lang.Object r5 = com.applovin.exoplayer2.l.a.checkNotNull(r5)
            r9 = r5
            java.lang.String r9 = (java.lang.String) r9
            long r5 = r27.pv()
            long r10 = r27.pv()
            r12 = 1000000(0xf4240, double:4.940656E-318)
            r14 = r5
            long r7 = com.applovin.exoplayer2.l.ai.e(r10, r12, r14)
            long r10 = r0.Ag
            int r12 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1))
            if (r12 == 0) goto L_0x00a0
            long r10 = r10 + r7
            r16 = r10
            goto L_0x00a2
        L_0x00a0:
            r16 = r3
        L_0x00a2:
            long r10 = r27.pv()
            r12 = 1000(0x3e8, double:4.94E-321)
            r14 = r5
            long r5 = com.applovin.exoplayer2.l.ai.e(r10, r12, r14)
            long r10 = r27.pv()
            r19 = r2
            r21 = r5
            r20 = r9
            r23 = r10
            r13 = r16
        L_0x00bb:
            int r2 = r27.pj()
            byte[] r2 = new byte[r2]
            int r5 = r27.pj()
            r6 = 0
            r1.r(r2, r6, r5)
            com.applovin.exoplayer2.g.b.a r1 = new com.applovin.exoplayer2.g.b.a
            r18 = r1
            r25 = r2
            r18.<init>(r19, r20, r21, r23, r25)
            com.applovin.exoplayer2.l.y r2 = new com.applovin.exoplayer2.l.y
            com.applovin.exoplayer2.g.b.c r5 = r0.zT
            byte[] r1 = r5.a(r1)
            r2.<init>((byte[]) r1)
            int r1 = r2.pj()
            com.applovin.exoplayer2.e.x[] r5 = r0.Ak
            int r9 = r5.length
            r10 = 0
        L_0x00e5:
            if (r10 >= r9) goto L_0x00f2
            r11 = r5[r10]
            r2.fx(r6)
            r11.c(r2, r1)
            int r10 = r10 + 1
            goto L_0x00e5
        L_0x00f2:
            int r2 = (r13 > r3 ? 1 : (r13 == r3 ? 0 : -1))
            if (r2 != 0) goto L_0x0106
            java.util.ArrayDeque<com.applovin.exoplayer2.e.g.e$a> r2 = r0.zW
            com.applovin.exoplayer2.e.g.e$a r3 = new com.applovin.exoplayer2.e.g.e$a
            r3.<init>(r7, r1)
            r2.addLast(r3)
            int r2 = r0.Ae
            int r2 = r2 + r1
            r0.Ae = r2
            goto L_0x0125
        L_0x0106:
            com.applovin.exoplayer2.l.ag r2 = r0.zS
            if (r2 == 0) goto L_0x010e
            long r13 = r2.bs(r13)
        L_0x010e:
            com.applovin.exoplayer2.e.x[] r2 = r0.Ak
            int r3 = r2.length
        L_0x0111:
            if (r6 >= r3) goto L_0x0125
            r15 = r2[r6]
            r18 = 1
            r20 = 0
            r21 = 0
            r16 = r13
            r19 = r1
            r15.a(r16, r18, r19, r20, r21)
            int r6 = r6 + 1
            goto L_0x0111
        L_0x0125:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.e.g.e.v(com.applovin.exoplayer2.l.y):void");
    }

    private static Pair<Integer, c> w(y yVar) {
        yVar.fx(12);
        return Pair.create(Integer.valueOf(yVar.px()), new c(yVar.px() - 1, yVar.px(), yVar.px(), yVar.px()));
    }

    private static long x(y yVar) {
        yVar.fx(8);
        return a.cf(yVar.px()) == 0 ? yVar.pv() : yVar.pF();
    }

    private static void a(a.C0041a aVar, SparseArray<b> sparseArray, boolean z, int i, byte[] bArr) throws ai {
        int size = aVar.zn.size();
        for (int i2 = 0; i2 < size; i2++) {
            a.C0041a aVar2 = aVar.zn.get(i2);
            if (aVar2.bs == 1953653094) {
                b(aVar2, sparseArray, z, i, bArr);
            }
        }
    }

    private static void b(a.C0041a aVar, SparseArray<b> sparseArray, boolean z, int i, byte[] bArr) throws ai {
        b a2 = a(((a.b) com.applovin.exoplayer2.l.a.checkNotNull(aVar.ci(1952868452))).zo, sparseArray, z);
        if (a2 != null) {
            m mVar = a2.Ao;
            long j = mVar.Bo;
            boolean z2 = mVar.Bp;
            a2.iN();
            boolean unused = a2.Ax = true;
            a.b ci = aVar.ci(1952867444);
            if (ci == null || (i & 2) != 0) {
                mVar.Bo = j;
                mVar.Bp = z2;
            } else {
                mVar.Bo = y(ci.zo);
                mVar.Bp = true;
            }
            a(aVar, a2, i);
            l cp = a2.Ap.AG.cp(((c) com.applovin.exoplayer2.l.a.checkNotNull(mVar.AY)).zF);
            a.b ci2 = aVar.ci(1935763834);
            if (ci2 != null) {
                a((l) com.applovin.exoplayer2.l.a.checkNotNull(cp), ci2.zo, mVar);
            }
            a.b ci3 = aVar.ci(1935763823);
            if (ci3 != null) {
                a(ci3.zo, mVar);
            }
            a.b ci4 = aVar.ci(1936027235);
            if (ci4 != null) {
                b(ci4.zo, mVar);
            }
            a(aVar, cp != null ? cp.tc : null, mVar);
            int size = aVar.zm.size();
            for (int i2 = 0; i2 < size; i2++) {
                a.b bVar = aVar.zm.get(i2);
                if (bVar.bs == 1970628964) {
                    a(bVar.zo, mVar, bArr);
                }
            }
        }
    }

    private static void a(a.C0041a aVar, b bVar, int i) throws ai {
        List<a.b> list = aVar.zm;
        int size = list.size();
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            a.b bVar2 = list.get(i4);
            if (bVar2.bs == 1953658222) {
                y yVar = bVar2.zo;
                yVar.fx(12);
                int pD = yVar.pD();
                if (pD > 0) {
                    i3 += pD;
                    i2++;
                }
            }
        }
        bVar.At = 0;
        bVar.As = 0;
        bVar.Ar = 0;
        bVar.Ao.A(i2, i3);
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < size; i7++) {
            a.b bVar3 = list.get(i7);
            if (bVar3.bs == 1953658222) {
                i6 = a(bVar, i5, i, bVar3.zo, i6);
                i5++;
            }
        }
    }

    private static void a(l lVar, y yVar, m mVar) throws ai {
        int i;
        int i2 = lVar.AW;
        yVar.fx(8);
        boolean z = true;
        if ((a.cg(yVar.px()) & 1) == 1) {
            yVar.fz(8);
        }
        int po = yVar.po();
        int pD = yVar.pD();
        if (pD <= mVar.jA) {
            if (po == 0) {
                boolean[] zArr = mVar.Bk;
                i = 0;
                for (int i3 = 0; i3 < pD; i3++) {
                    int po2 = yVar.po();
                    i += po2;
                    zArr[i3] = po2 > i2;
                }
            } else {
                if (po <= i2) {
                    z = false;
                }
                i = po * pD;
                Arrays.fill(mVar.Bk, 0, pD, z);
            }
            Arrays.fill(mVar.Bk, pD, mVar.jA, false);
            if (i > 0) {
                mVar.cq(i);
                return;
            }
            return;
        }
        throw ai.c("Saiz sample count " + pD + " is greater than fragment sample count" + mVar.jA, (Throwable) null);
    }

    private static void a(y yVar, m mVar) throws ai {
        long j;
        yVar.fx(8);
        int px = yVar.px();
        if ((a.cg(px) & 1) == 1) {
            yVar.fz(8);
        }
        int pD = yVar.pD();
        if (pD == 1) {
            int cf = a.cf(px);
            long j2 = mVar.Bb;
            if (cf == 0) {
                j = yVar.pv();
            } else {
                j = yVar.pF();
            }
            mVar.Bb = j2 + j;
            return;
        }
        throw ai.c("Unexpected saio entry count: " + pD, (Throwable) null);
    }

    /* JADX WARNING: type inference failed for: r5v0, types: [android.util.SparseArray, android.util.SparseArray<com.applovin.exoplayer2.e.g.e$b>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.applovin.exoplayer2.e.g.e.b a(com.applovin.exoplayer2.l.y r4, android.util.SparseArray<com.applovin.exoplayer2.e.g.e.b> r5, boolean r6) {
        /*
            r0 = 8
            r4.fx(r0)
            int r0 = r4.px()
            int r0 = com.applovin.exoplayer2.e.g.a.cg(r0)
            int r1 = r4.px()
            if (r6 == 0) goto L_0x0019
            r6 = 0
            java.lang.Object r5 = r5.valueAt(r6)
            goto L_0x001d
        L_0x0019:
            java.lang.Object r5 = r5.get(r1)
        L_0x001d:
            com.applovin.exoplayer2.e.g.e$b r5 = (com.applovin.exoplayer2.e.g.e.b) r5
            if (r5 != 0) goto L_0x0023
            r4 = 0
            return r4
        L_0x0023:
            r6 = r0 & 1
            if (r6 == 0) goto L_0x0033
            long r1 = r4.pF()
            com.applovin.exoplayer2.e.g.m r6 = r5.Ao
            r6.Ba = r1
            com.applovin.exoplayer2.e.g.m r6 = r5.Ao
            r6.Bb = r1
        L_0x0033:
            com.applovin.exoplayer2.e.g.c r6 = r5.Aq
            r1 = r0 & 2
            if (r1 == 0) goto L_0x0040
            int r1 = r4.px()
            int r1 = r1 + -1
            goto L_0x0042
        L_0x0040:
            int r1 = r6.zF
        L_0x0042:
            r2 = r0 & 8
            if (r2 == 0) goto L_0x004b
            int r2 = r4.px()
            goto L_0x004d
        L_0x004b:
            int r2 = r6.zG
        L_0x004d:
            r3 = r0 & 16
            if (r3 == 0) goto L_0x0056
            int r3 = r4.px()
            goto L_0x0058
        L_0x0056:
            int r3 = r6.oW
        L_0x0058:
            r0 = r0 & 32
            if (r0 == 0) goto L_0x0061
            int r4 = r4.px()
            goto L_0x0063
        L_0x0061:
            int r4 = r6.jF
        L_0x0063:
            com.applovin.exoplayer2.e.g.m r6 = r5.Ao
            com.applovin.exoplayer2.e.g.c r0 = new com.applovin.exoplayer2.e.g.c
            r0.<init>(r1, r2, r3, r4)
            r6.AY = r0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.e.g.e.a(com.applovin.exoplayer2.l.y, android.util.SparseArray, boolean):com.applovin.exoplayer2.e.g.e$b");
    }

    private static long y(y yVar) {
        yVar.fx(8);
        return a.cf(yVar.px()) == 1 ? yVar.pF() : yVar.pv();
    }

    private static int a(b bVar, int i, int i2, y yVar, int i3) throws ai {
        boolean z;
        int i4;
        boolean z2;
        int i5;
        boolean z3;
        boolean z4;
        boolean z5;
        b bVar2 = bVar;
        yVar.fx(8);
        int cg = a.cg(yVar.px());
        k kVar = bVar2.Ap.AG;
        m mVar = bVar2.Ao;
        c cVar = (c) com.applovin.exoplayer2.l.ai.R(mVar.AY);
        mVar.Be[i] = yVar.pD();
        mVar.Bd[i] = mVar.Ba;
        if ((cg & 1) != 0) {
            long[] jArr = mVar.Bd;
            jArr[i] = jArr[i] + ((long) yVar.px());
        }
        boolean z6 = (cg & 4) != 0;
        int i6 = cVar.jF;
        if (z6) {
            i6 = yVar.px();
        }
        boolean z7 = (cg & 256) != 0;
        boolean z8 = (cg & 512) != 0;
        boolean z9 = (cg & 1024) != 0;
        boolean z10 = (cg & 2048) != 0;
        long j = 0;
        if (kVar.AS != null && kVar.AS.length == 1 && kVar.AS[0] == 0) {
            j = com.applovin.exoplayer2.l.ai.e(((long[]) com.applovin.exoplayer2.l.ai.R(kVar.AT))[0], 1000000, kVar.AP);
        }
        int[] iArr = mVar.Bf;
        int[] iArr2 = mVar.Bg;
        long[] jArr2 = mVar.Bh;
        int i7 = i6;
        boolean[] zArr = mVar.Bi;
        boolean z11 = kVar.bs == 2 && (i2 & 1) != 0;
        int i8 = i3 + mVar.Be[i];
        boolean z12 = z11;
        long j2 = kVar.AP;
        long j3 = j;
        long[] jArr3 = jArr2;
        long j4 = mVar.Bo;
        int i9 = i3;
        while (i9 < i8) {
            int cl = cl(z7 ? yVar.px() : cVar.zG);
            if (z8) {
                z = z7;
                i4 = yVar.px();
            } else {
                z = z7;
                i4 = cVar.oW;
            }
            int cl2 = cl(i4);
            if (z9) {
                z2 = z6;
                i5 = yVar.px();
            } else if (i9 != 0 || !z6) {
                z2 = z6;
                i5 = cVar.jF;
            } else {
                z2 = z6;
                i5 = i7;
            }
            if (z10) {
                z5 = z10;
                z4 = z8;
                z3 = z9;
                iArr2[i9] = (int) ((((long) yVar.px()) * 1000000) / j2);
            } else {
                z5 = z10;
                z4 = z8;
                z3 = z9;
                iArr2[i9] = 0;
            }
            jArr3[i9] = com.applovin.exoplayer2.l.ai.e(j4, 1000000, j2) - j3;
            if (!mVar.Bp) {
                jArr3[i9] = jArr3[i9] + bVar2.Ap.fH;
            }
            iArr[i9] = cl2;
            zArr[i9] = ((i5 >> 16) & 1) == 0 && (!z12 || i9 == 0);
            j4 += (long) cl;
            i9++;
            bVar2 = bVar;
            z7 = z;
            j2 = j2;
            z6 = z2;
            z10 = z5;
            z8 = z4;
            z9 = z3;
        }
        mVar.Bo = j4;
        return i8;
    }

    private static int cl(int i) throws ai {
        if (i >= 0) {
            return i;
        }
        throw ai.c("Unexpected negative value: " + i, (Throwable) null);
    }

    private static void a(y yVar, m mVar, byte[] bArr) throws ai {
        yVar.fx(8);
        yVar.r(bArr, 0, 16);
        if (Arrays.equals(bArr, zK)) {
            a(yVar, 16, mVar);
        }
    }

    private static void b(y yVar, m mVar) throws ai {
        a(yVar, 0, mVar);
    }

    private static void a(y yVar, int i, m mVar) throws ai {
        yVar.fx(i + 8);
        int cg = a.cg(yVar.px());
        if ((cg & 1) == 0) {
            boolean z = (cg & 2) != 0;
            int pD = yVar.pD();
            if (pD == 0) {
                Arrays.fill(mVar.Bk, 0, mVar.jA, false);
            } else if (pD == mVar.jA) {
                Arrays.fill(mVar.Bk, 0, pD, z);
                mVar.cq(yVar.pj());
                mVar.E(yVar);
            } else {
                throw ai.c("Senc sample count " + pD + " is different from fragment sample count" + mVar.jA, (Throwable) null);
            }
        } else {
            throw ai.p("Overriding TrackEncryptionBox parameters is unsupported.");
        }
    }

    private static void a(a.C0041a aVar, String str, m mVar) throws ai {
        a.C0041a aVar2 = aVar;
        m mVar2 = mVar;
        byte[] bArr = null;
        y yVar = null;
        y yVar2 = null;
        for (int i = 0; i < aVar2.zm.size(); i++) {
            a.b bVar = aVar2.zm.get(i);
            y yVar3 = bVar.zo;
            if (bVar.bs == 1935828848) {
                yVar3.fx(12);
                if (yVar3.px() == 1936025959) {
                    yVar = yVar3;
                }
            } else if (bVar.bs == 1936158820) {
                yVar3.fx(12);
                if (yVar3.px() == 1936025959) {
                    yVar2 = yVar3;
                }
            }
        }
        if (yVar != null && yVar2 != null) {
            yVar.fx(8);
            int cf = a.cf(yVar.px());
            yVar.fz(4);
            if (cf == 1) {
                yVar.fz(4);
            }
            if (yVar.px() == 1) {
                yVar2.fx(8);
                int cf2 = a.cf(yVar2.px());
                yVar2.fz(4);
                if (cf2 == 1) {
                    if (yVar2.pv() == 0) {
                        throw ai.p("Variable length description in sgpd found (unsupported)");
                    }
                } else if (cf2 >= 2) {
                    yVar2.fz(4);
                }
                if (yVar2.pv() == 1) {
                    yVar2.fz(1);
                    int po = yVar2.po();
                    int i2 = (po & 240) >> 4;
                    int i3 = po & 15;
                    boolean z = yVar2.po() == 1;
                    if (z) {
                        int po2 = yVar2.po();
                        byte[] bArr2 = new byte[16];
                        yVar2.r(bArr2, 0, 16);
                        if (po2 == 0) {
                            int po3 = yVar2.po();
                            bArr = new byte[po3];
                            yVar2.r(bArr, 0, po3);
                        }
                        mVar2.Bj = true;
                        mVar2.Bl = new l(z, str, po2, bArr2, i2, i3, bArr);
                        return;
                    }
                    return;
                }
                throw ai.p("Entry count in sgpd != 1 (unsupported).");
            }
            throw ai.p("Entry count in sbgp != 1 (unsupported).");
        }
    }

    private static Pair<Long, com.applovin.exoplayer2.e.c> c(y yVar, long j) throws ai {
        long j2;
        long j3;
        y yVar2 = yVar;
        yVar2.fx(8);
        int cf = a.cf(yVar.px());
        yVar2.fz(4);
        long pv = yVar.pv();
        if (cf == 0) {
            j3 = yVar.pv();
            j2 = yVar.pv();
        } else {
            j3 = yVar.pF();
            j2 = yVar.pF();
        }
        long j4 = j3;
        long j5 = j + j2;
        long e = com.applovin.exoplayer2.l.ai.e(j4, 1000000, pv);
        yVar2.fz(2);
        int pp = yVar.pp();
        int[] iArr = new int[pp];
        long[] jArr = new long[pp];
        long[] jArr2 = new long[pp];
        long[] jArr3 = new long[pp];
        long j6 = j4;
        long j7 = e;
        int i = 0;
        while (i < pp) {
            int px = yVar.px();
            if ((px & Integer.MIN_VALUE) == 0) {
                long pv2 = yVar.pv();
                iArr[i] = px & Integer.MAX_VALUE;
                jArr[i] = j5;
                jArr3[i] = j7;
                long j8 = j6 + pv2;
                long[] jArr4 = jArr2;
                long[] jArr5 = jArr3;
                int i2 = pp;
                int[] iArr2 = iArr;
                long e2 = com.applovin.exoplayer2.l.ai.e(j8, 1000000, pv);
                jArr4[i] = e2 - jArr5[i];
                yVar2.fz(4);
                j5 += (long) iArr2[i];
                i++;
                iArr = iArr2;
                jArr3 = jArr5;
                jArr2 = jArr4;
                jArr = jArr;
                pp = i2;
                long j9 = e2;
                j6 = j8;
                j7 = j9;
            } else {
                throw ai.c("Unhandled indirect reference", (Throwable) null);
            }
        }
        return Pair.create(Long.valueOf(e), new com.applovin.exoplayer2.e.c(iArr, jArr, jArr2, jArr3));
    }

    private void I(i iVar) throws IOException {
        int size = this.zO.size();
        long j = Long.MAX_VALUE;
        b bVar = null;
        for (int i = 0; i < size; i++) {
            m mVar = this.zO.valueAt(i).Ao;
            if (mVar.Bn && mVar.Bb < j) {
                j = mVar.Bb;
                bVar = this.zO.valueAt(i);
            }
        }
        if (bVar == null) {
            this.zY = 3;
            return;
        }
        int ie = (int) (j - iVar.ie());
        if (ie >= 0) {
            iVar.bH(ie);
            bVar.Ao.M(iVar);
            return;
        }
        throw ai.c("Offset to encryption data was negative.", (Throwable) null);
    }

    private boolean J(i iVar) throws IOException {
        int i;
        i iVar2 = iVar;
        b bVar = this.Ah;
        Throwable th = null;
        if (bVar == null) {
            bVar = a(this.zO);
            if (bVar == null) {
                int ie = (int) (this.Ad - iVar.ie());
                if (ie >= 0) {
                    iVar2.bH(ie);
                    iL();
                    return false;
                }
                throw ai.c("Offset to end of mdat was negative.", (Throwable) null);
            }
            int iP = (int) (bVar.iP() - iVar.ie());
            if (iP < 0) {
                q.h("FragmentedMp4Extractor", "Ignoring negative offset to sample data.");
                iP = 0;
            }
            iVar2.bH(iP);
            this.Ah = bVar;
        }
        int i2 = 4;
        int i3 = 1;
        if (this.zY == 3) {
            this.Ai = bVar.iQ();
            if (bVar.Ar < bVar.Au) {
                iVar2.bH(this.Ai);
                bVar.iT();
                if (!bVar.iS()) {
                    this.Ah = null;
                }
                this.zY = 3;
                return true;
            }
            if (bVar.Ap.AG.AR == 1) {
                this.Ai -= 8;
                iVar2.bH(8);
            }
            if ("audio/ac4".equals(bVar.Ap.AG.dU.dz)) {
                this.xJ = bVar.z(this.Ai, 7);
                com.applovin.exoplayer2.b.c.a(this.Ai, this.uO);
                bVar.wl.c(this.uO, 7);
                this.xJ += 7;
            } else {
                this.xJ = bVar.z(this.Ai, 0);
            }
            this.Ai += this.xJ;
            this.zY = 4;
            this.xK = 0;
        }
        k kVar = bVar.Ap.AG;
        x xVar = bVar.wl;
        long iO = bVar.iO();
        ag agVar = this.zS;
        if (agVar != null) {
            iO = agVar.bs(iO);
        }
        long j = iO;
        if (kVar.wo == 0) {
            while (true) {
                int i4 = this.xJ;
                int i5 = this.Ai;
                if (i4 >= i5) {
                    break;
                }
                this.xJ += xVar.a((g) iVar2, i5 - i4, false);
            }
        } else {
            byte[] hO = this.zP.hO();
            hO[0] = 0;
            hO[1] = 0;
            hO[2] = 0;
            int i6 = kVar.wo + 1;
            int i7 = 4 - kVar.wo;
            while (this.xJ < this.Ai) {
                int i8 = this.xK;
                if (i8 == 0) {
                    iVar2.a(hO, i7, i6);
                    this.zP.fx(0);
                    int px = this.zP.px();
                    if (px >= i3) {
                        this.xK = px - 1;
                        this.wm.fx(0);
                        xVar.c(this.wm, i2);
                        xVar.c(this.zP, i3);
                        this.Aj = this.Al.length > 0 && com.applovin.exoplayer2.l.v.a(kVar.dU.dz, hO[i2]);
                        this.xJ += 5;
                        this.Ai += i7;
                    } else {
                        throw ai.c("Invalid NAL length", th);
                    }
                } else {
                    if (this.Aj) {
                        this.zQ.U(i8);
                        iVar2.a(this.zQ.hO(), 0, this.xK);
                        xVar.c(this.zQ, this.xK);
                        i = this.xK;
                        int i9 = com.applovin.exoplayer2.l.v.i(this.zQ.hO(), this.zQ.pk());
                        this.zQ.fx(MimeTypes.VIDEO_H265.equals(kVar.dU.dz) ? 1 : 0);
                        this.zQ.fA(i9);
                        com.applovin.exoplayer2.e.b.a(j, this.zQ, this.Al);
                    } else {
                        i = xVar.a((g) iVar2, i8, false);
                    }
                    this.xJ += i;
                    this.xK -= i;
                    th = null;
                    i2 = 4;
                    i3 = 1;
                }
            }
        }
        int iR = bVar.iR();
        l iU = bVar.iU();
        xVar.a(j, iR, this.Ai, 0, iU != null ? iU.xZ : null);
        av(j);
        if (!bVar.iS()) {
            this.Ah = null;
        }
        this.zY = 3;
        return true;
    }

    private void av(long j) {
        while (!this.zW.isEmpty()) {
            a removeFirst = this.zW.removeFirst();
            this.Ae -= removeFirst.oW;
            long j2 = removeFirst.An + j;
            ag agVar = this.zS;
            if (agVar != null) {
                j2 = agVar.bs(j2);
            }
            for (x a2 : this.Ak) {
                a2.a(j2, 1, removeFirst.oW, this.Ae, (x.a) null);
            }
        }
    }

    private static b a(SparseArray<b> sparseArray) {
        int size = sparseArray.size();
        b bVar = null;
        long j = Long.MAX_VALUE;
        for (int i = 0; i < size; i++) {
            b valueAt = sparseArray.valueAt(i);
            if ((valueAt.Ax || valueAt.Ar != valueAt.Ap.jA) && (!valueAt.Ax || valueAt.At != valueAt.Ao.Bc)) {
                long iP = valueAt.iP();
                if (iP < j) {
                    bVar = valueAt;
                    j = iP;
                }
            }
        }
        return bVar;
    }

    private static com.applovin.exoplayer2.d.e i(List<a.b> list) {
        int size = list.size();
        ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            a.b bVar = list.get(i);
            if (bVar.bs == 1886614376) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                byte[] hO = bVar.zo.hO();
                UUID x = h.x(hO);
                if (x == null) {
                    q.h("FragmentedMp4Extractor", "Skipped pssh atom (failed to extract uuid)");
                } else {
                    arrayList.add(new e.a(x, "video/mp4", hO));
                }
            }
        }
        if (arrayList == null) {
            return null;
        }
        return new com.applovin.exoplayer2.d.e((List<e.a>) arrayList);
    }

    private static final class a {
        public final long An;
        public final int oW;

        public a(long j, int i) {
            this.An = j;
            this.oW = i;
        }
    }

    private static final class b {
        public final m Ao = new m();
        public n Ap;
        public c Aq;
        public int Ar;
        public int As;
        public int At;
        public int Au;
        private final y Av = new y(1);
        private final y Aw = new y();
        /* access modifiers changed from: private */
        public boolean Ax;
        public final y uO = new y();
        public final x wl;

        public b(x xVar, n nVar, c cVar) {
            this.wl = xVar;
            this.Ap = nVar;
            this.Aq = cVar;
            a(nVar, cVar);
        }

        public void a(n nVar, c cVar) {
            this.Ap = nVar;
            this.Aq = cVar;
            this.wl.j(nVar.AG.dU);
            iN();
        }

        public void c(com.applovin.exoplayer2.d.e eVar) {
            l cp = this.Ap.AG.cp(((c) com.applovin.exoplayer2.l.ai.R(this.Ao.AY)).zF);
            this.wl.j(this.Ap.AG.dU.bR().a(eVar.B(cp != null ? cp.tc : null)).bT());
        }

        public void iN() {
            this.Ao.Y();
            this.Ar = 0;
            this.At = 0;
            this.As = 0;
            this.Au = 0;
            this.Ax = false;
        }

        public void aw(long j) {
            int i = this.Ar;
            while (i < this.Ao.jA && this.Ao.cr(i) < j) {
                if (this.Ao.Bi[i]) {
                    this.Au = i;
                }
                i++;
            }
        }

        public long iO() {
            if (!this.Ax) {
                return this.Ap.Bq[this.Ar];
            }
            return this.Ao.cr(this.Ar);
        }

        public long iP() {
            if (!this.Ax) {
                return this.Ap.tS[this.Ar];
            }
            return this.Ao.Bd[this.At];
        }

        public int iQ() {
            if (!this.Ax) {
                return this.Ap.tR[this.Ar];
            }
            return this.Ao.Bf[this.Ar];
        }

        public int iR() {
            int i;
            if (!this.Ax) {
                i = this.Ap.zJ[this.Ar];
            } else {
                i = this.Ao.Bi[this.Ar] ? 1 : 0;
            }
            return iU() != null ? i | 1073741824 : i;
        }

        public boolean iS() {
            this.Ar++;
            if (!this.Ax) {
                return false;
            }
            int i = this.As + 1;
            this.As = i;
            int[] iArr = this.Ao.Be;
            int i2 = this.At;
            if (i != iArr[i2]) {
                return true;
            }
            this.At = i2 + 1;
            this.As = 0;
            return false;
        }

        public int z(int i, int i2) {
            y yVar;
            int i3;
            l iU = iU();
            if (iU == null) {
                return 0;
            }
            if (iU.AW != 0) {
                yVar = this.Ao.Bm;
                i3 = iU.AW;
            } else {
                byte[] bArr = (byte[]) com.applovin.exoplayer2.l.ai.R(iU.AX);
                this.Aw.l(bArr, bArr.length);
                yVar = this.Aw;
                i3 = bArr.length;
            }
            boolean cs = this.Ao.cs(this.Ar);
            boolean z = cs || i2 != 0;
            this.Av.hO()[0] = (byte) ((z ? 128 : 0) | i3);
            this.Av.fx(0);
            this.wl.a(this.Av, 1, 1);
            this.wl.a(yVar, i3, 1);
            if (!z) {
                return i3 + 1;
            }
            if (!cs) {
                this.uO.U(8);
                byte[] hO = this.uO.hO();
                hO[0] = 0;
                hO[1] = 1;
                hO[2] = (byte) ((i2 >> 8) & 255);
                hO[3] = (byte) (i2 & 255);
                hO[4] = (byte) ((i >> 24) & 255);
                hO[5] = (byte) ((i >> 16) & 255);
                hO[6] = (byte) ((i >> 8) & 255);
                hO[7] = (byte) (i & 255);
                this.wl.a(this.uO, 8, 1);
                return i3 + 9;
            }
            y yVar2 = this.Ao.Bm;
            int pp = yVar2.pp();
            yVar2.fz(-2);
            int i4 = (pp * 6) + 2;
            if (i2 != 0) {
                this.uO.U(i4);
                byte[] hO2 = this.uO.hO();
                yVar2.r(hO2, 0, i4);
                int i5 = (((hO2[2] & UByte.MAX_VALUE) << 8) | (hO2[3] & UByte.MAX_VALUE)) + i2;
                hO2[2] = (byte) ((i5 >> 8) & 255);
                hO2[3] = (byte) (i5 & 255);
                yVar2 = this.uO;
            }
            this.wl.a(yVar2, i4, 1);
            return i3 + 1 + i4;
        }

        public void iT() {
            l iU = iU();
            if (iU != null) {
                y yVar = this.Ao.Bm;
                if (iU.AW != 0) {
                    yVar.fz(iU.AW);
                }
                if (this.Ao.cs(this.Ar)) {
                    yVar.fz(yVar.pp() * 6);
                }
            }
        }

        public l iU() {
            l lVar;
            if (!this.Ax) {
                return null;
            }
            int i = ((c) com.applovin.exoplayer2.l.ai.R(this.Ao.AY)).zF;
            if (this.Ao.Bl != null) {
                lVar = this.Ao.Bl;
            } else {
                lVar = this.Ap.AG.cp(i);
            }
            if (lVar == null || !lVar.AV) {
                return null;
            }
            return lVar;
        }
    }
}
