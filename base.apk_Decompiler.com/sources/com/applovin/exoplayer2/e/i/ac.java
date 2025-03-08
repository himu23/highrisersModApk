package com.applovin.exoplayer2.e.i;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import com.applovin.exoplayer2.ai;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class ac implements h {
    public static final l vq = new ac$$ExternalSyntheticLambda0();
    /* access modifiers changed from: private */
    public j BG;
    /* access modifiers changed from: private */
    public final SparseBooleanArray FA;
    /* access modifiers changed from: private */
    public final SparseBooleanArray FB;
    private final ab FC;
    private aa FD;
    /* access modifiers changed from: private */
    public int FE;
    /* access modifiers changed from: private */
    public boolean FG;
    private boolean FH;
    /* access modifiers changed from: private */
    public ad FI;
    private int FJ;
    /* access modifiers changed from: private */
    public int Fp;
    private final int Fq;
    /* access modifiers changed from: private */
    public final List<ag> Fv;
    private final y Fw;
    private final SparseIntArray Fx;
    /* access modifiers changed from: private */
    public final ad.c Fy;
    /* access modifiers changed from: private */
    public final SparseArray<ad> Fz;
    /* access modifiers changed from: private */
    public final int rm;
    private boolean vB;

    public void a(j jVar) {
        this.BG = jVar;
    }

    public void release() {
    }

    static /* synthetic */ int b(ac acVar) {
        int i = acVar.FE;
        acVar.FE = i + 1;
        return i;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ h[] ih() {
        return new h[]{new ac()};
    }

    public ac() {
        this(0);
    }

    public ac(int i) {
        this(1, i, 112800);
    }

    public ac(int i, int i2, int i3) {
        this(i, new ag(0), new g(i2), i3);
    }

    public ac(int i, ag agVar, ad.c cVar, int i2) {
        this.Fy = (ad.c) com.applovin.exoplayer2.l.a.checkNotNull(cVar);
        this.Fq = i2;
        this.rm = i;
        if (i == 1 || i == 2) {
            this.Fv = Collections.singletonList(agVar);
        } else {
            ArrayList arrayList = new ArrayList();
            this.Fv = arrayList;
            arrayList.add(agVar);
        }
        this.Fw = new y(new byte[9400], 0);
        this.FA = new SparseBooleanArray();
        this.FB = new SparseBooleanArray();
        this.Fz = new SparseArray<>();
        this.Fx = new SparseIntArray();
        this.FC = new ab(i2);
        this.BG = j.uw;
        this.Fp = -1;
        jx();
    }

    public boolean a(i iVar) throws IOException {
        byte[] hO = this.Fw.hO();
        iVar.c(hO, 0, 940);
        int i = 0;
        while (i < 188) {
            int i2 = 0;
            while (i2 < 5) {
                if (hO[(i2 * 188) + i] != 71) {
                    i++;
                } else {
                    i2++;
                }
            }
            iVar.bH(i);
            return true;
        }
        return false;
    }

    public void o(long j, long j2) {
        aa aaVar;
        com.applovin.exoplayer2.l.a.checkState(this.rm != 2);
        int size = this.Fv.size();
        for (int i = 0; i < size; i++) {
            ag agVar = this.Fv.get(i);
            boolean z = agVar.pU() == -9223372036854775807L;
            if (!z) {
                long pS = agVar.pS();
                if (pS != -9223372036854775807L) {
                    if (pS != 0) {
                        if (pS == j2) {
                        }
                    }
                }
            } else if (!z) {
            }
            agVar.aI(j2);
        }
        if (!(j2 == 0 || (aaVar = this.FD) == null)) {
            aaVar.ag(j2);
        }
        this.Fw.U(0);
        this.Fx.clear();
        for (int i2 = 0; i2 < this.Fz.size(); i2++) {
            this.Fz.valueAt(i2).jb();
        }
        this.FJ = 0;
    }

    public int b(i iVar, u uVar) throws IOException {
        i iVar2 = iVar;
        u uVar2 = uVar;
        long j = iVar.m1771if();
        if (this.FG) {
            if (j != -1 && this.rm != 2 && !this.FC.jt()) {
                return this.FC.a(iVar2, uVar2, this.Fp);
            }
            aH(j);
            if (this.FH) {
                this.FH = false;
                o(0, 0);
                if (iVar.ie() != 0) {
                    uVar2.uc = 0;
                    return 1;
                }
            }
            aa aaVar = this.FD;
            if (aaVar != null && aaVar.hT()) {
                return this.FD.a(iVar2, uVar2);
            }
        }
        if (!Z(iVar)) {
            return -1;
        }
        int jw = jw();
        int pk = this.Fw.pk();
        if (jw > pk) {
            return 0;
        }
        int px = this.Fw.px();
        if ((8388608 & px) != 0) {
            this.Fw.fx(jw);
            return 0;
        }
        int i = (4194304 & px) != 0 ? 1 : 0;
        int i2 = (2096896 & px) >> 8;
        boolean z = (px & 32) != 0;
        ad adVar = (px & 16) != 0 ? this.Fz.get(i2) : null;
        if (adVar == null) {
            this.Fw.fx(jw);
            return 0;
        }
        if (this.rm != 2) {
            int i3 = px & 15;
            int i4 = this.Fx.get(i2, i3 - 1);
            this.Fx.put(i2, i3);
            if (i4 == i3) {
                this.Fw.fx(jw);
                return 0;
            } else if (i3 != ((i4 + 1) & 15)) {
                adVar.jb();
            }
        }
        if (z) {
            int po = this.Fw.po();
            i |= (this.Fw.po() & 64) != 0 ? 2 : 0;
            this.Fw.fz(po - 1);
        }
        boolean z2 = this.FG;
        if (cD(i2)) {
            this.Fw.fA(jw);
            adVar.p(this.Fw, i);
            this.Fw.fA(pk);
        }
        if (this.rm != 2 && !z2 && this.FG && j != -1) {
            this.FH = true;
        }
        this.Fw.fx(jw);
        return 0;
    }

    private void aH(long j) {
        if (!this.vB) {
            this.vB = true;
            if (this.FC.dd() != -9223372036854775807L) {
                aa aaVar = new aa(this.FC.jv(), this.FC.dd(), j, this.Fp, this.Fq);
                this.FD = aaVar;
                this.BG.a(aaVar.hS());
                return;
            }
            this.BG.a(new v.b(this.FC.dd()));
        }
    }

    private boolean Z(i iVar) throws IOException {
        byte[] hO = this.Fw.hO();
        if (9400 - this.Fw.il() < 188) {
            int pj = this.Fw.pj();
            if (pj > 0) {
                System.arraycopy(hO, this.Fw.il(), hO, 0, pj);
            }
            this.Fw.l(hO, pj);
        }
        while (this.Fw.pj() < 188) {
            int pk = this.Fw.pk();
            int read = iVar.read(hO, pk, 9400 - pk);
            if (read == -1) {
                return false;
            }
            this.Fw.fA(pk + read);
        }
        return true;
    }

    private int jw() throws ai {
        int il = this.Fw.il();
        int pk = this.Fw.pk();
        int i = ae.i(this.Fw.hO(), il, pk);
        this.Fw.fx(i);
        int i2 = i + 188;
        if (i2 > pk) {
            int i3 = this.FJ + (i - il);
            this.FJ = i3;
            if (this.rm == 2 && i3 > 376) {
                throw ai.c("Cannot find sync byte. Most likely not a Transport Stream.", (Throwable) null);
            }
        } else {
            this.FJ = 0;
        }
        return i2;
    }

    private boolean cD(int i) {
        return this.rm == 2 || this.FG || !this.FB.get(i, false);
    }

    private void jx() {
        this.FA.clear();
        this.Fz.clear();
        SparseArray<ad> jn = this.Fy.jn();
        int size = jn.size();
        for (int i = 0; i < size; i++) {
            this.Fz.put(jn.keyAt(i), jn.valueAt(i));
        }
        this.Fz.put(0, new y(new a()));
        this.FI = null;
    }

    private class a implements x {
        private final x FK = new x(new byte[4]);

        public void a(ag agVar, j jVar, ad.d dVar) {
        }

        public a() {
        }

        public void K(y yVar) {
            if (yVar.po() == 0 && (yVar.po() & 128) != 0) {
                yVar.fz(6);
                int pj = yVar.pj() / 4;
                for (int i = 0; i < pj; i++) {
                    yVar.f(this.FK, 4);
                    int bQ = this.FK.bQ(16);
                    this.FK.bR(3);
                    if (bQ == 0) {
                        this.FK.bR(13);
                    } else {
                        int bQ2 = this.FK.bQ(13);
                        if (ac.this.Fz.get(bQ2) == null) {
                            ac.this.Fz.put(bQ2, new y(new b(bQ2)));
                            ac.b(ac.this);
                        }
                    }
                }
                if (ac.this.rm != 2) {
                    ac.this.Fz.remove(0);
                }
            }
        }
    }

    private class b implements x {
        private final x FM = new x(new byte[5]);
        private final SparseArray<ad> FN = new SparseArray<>();
        private final SparseIntArray FO = new SparseIntArray();
        private final int FP;

        public void a(ag agVar, j jVar, ad.d dVar) {
        }

        public b(int i) {
            this.FP = i;
        }

        public void K(y yVar) {
            ag agVar;
            ad adVar;
            y yVar2 = yVar;
            if (yVar.po() == 2) {
                if (ac.this.rm == 1 || ac.this.rm == 2 || ac.this.FE == 1) {
                    agVar = (ag) ac.this.Fv.get(0);
                } else {
                    agVar = new ag(((ag) ac.this.Fv.get(0)).pS());
                    ac.this.Fv.add(agVar);
                }
                if ((yVar.po() & 128) != 0) {
                    yVar2.fz(1);
                    int pp = yVar.pp();
                    int i = 3;
                    yVar2.fz(3);
                    yVar2.f(this.FM, 2);
                    this.FM.bR(3);
                    int i2 = 13;
                    int unused = ac.this.Fp = this.FM.bQ(13);
                    yVar2.f(this.FM, 2);
                    int i3 = 4;
                    this.FM.bR(4);
                    yVar2.fz(this.FM.bQ(12));
                    if (ac.this.rm == 2 && ac.this.FI == null) {
                        ad.b bVar = new ad.b(21, (String) null, (List<ad.a>) null, com.applovin.exoplayer2.l.ai.ada);
                        ac acVar = ac.this;
                        ad unused2 = acVar.FI = acVar.Fy.a(21, bVar);
                        if (ac.this.FI != null) {
                            ac.this.FI.a(agVar, ac.this.BG, new ad.d(pp, 21, 8192));
                        }
                    }
                    this.FN.clear();
                    this.FO.clear();
                    int pj = yVar.pj();
                    while (pj > 0) {
                        yVar2.f(this.FM, 5);
                        int bQ = this.FM.bQ(8);
                        this.FM.bR(i);
                        int bQ2 = this.FM.bQ(i2);
                        this.FM.bR(i3);
                        int bQ3 = this.FM.bQ(12);
                        ad.b s = s(yVar2, bQ3);
                        if (bQ == 6 || bQ == 5) {
                            bQ = s.ir;
                        }
                        pj -= bQ3 + 5;
                        int i4 = ac.this.rm == 2 ? bQ : bQ2;
                        if (!ac.this.FA.get(i4)) {
                            if (ac.this.rm == 2 && bQ == 21) {
                                adVar = ac.this.FI;
                            } else {
                                adVar = ac.this.Fy.a(bQ, s);
                            }
                            if (ac.this.rm != 2 || bQ2 < this.FO.get(i4, 8192)) {
                                this.FO.put(i4, bQ2);
                                this.FN.put(i4, adVar);
                            }
                        }
                        i = 3;
                        i3 = 4;
                        i2 = 13;
                    }
                    int size = this.FO.size();
                    for (int i5 = 0; i5 < size; i5++) {
                        int keyAt = this.FO.keyAt(i5);
                        int valueAt = this.FO.valueAt(i5);
                        ac.this.FA.put(keyAt, true);
                        ac.this.FB.put(valueAt, true);
                        ad valueAt2 = this.FN.valueAt(i5);
                        if (valueAt2 != null) {
                            if (valueAt2 != ac.this.FI) {
                                valueAt2.a(agVar, ac.this.BG, new ad.d(pp, keyAt, 8192));
                            }
                            ac.this.Fz.put(valueAt, valueAt2);
                        }
                    }
                    if (ac.this.rm != 2) {
                        ac.this.Fz.remove(this.FP);
                        ac acVar2 = ac.this;
                        int unused3 = acVar2.FE = acVar2.rm == 1 ? 0 : ac.this.FE - 1;
                        if (ac.this.FE == 0) {
                            ac.this.BG.ig();
                            boolean unused4 = ac.this.FG = true;
                        }
                    } else if (!ac.this.FG) {
                        ac.this.BG.ig();
                        int unused5 = ac.this.FE = 0;
                        boolean unused6 = ac.this.FG = true;
                    }
                }
            }
        }

        private ad.b s(y yVar, int i) {
            int il = yVar.il();
            int i2 = i + il;
            int i3 = -1;
            String str = null;
            ArrayList arrayList = null;
            while (yVar.il() < i2) {
                int po = yVar.po();
                int il2 = yVar.il() + yVar.po();
                if (il2 > i2) {
                    break;
                }
                if (po == 5) {
                    long pv = yVar.pv();
                    if (pv != 1094921523) {
                        if (pv != 1161904947) {
                            if (pv != 1094921524) {
                                if (pv == 1212503619) {
                                    i3 = 36;
                                }
                                yVar.fz(il2 - yVar.il());
                            }
                        }
                        i3 = 135;
                        yVar.fz(il2 - yVar.il());
                    }
                    i3 = 129;
                    yVar.fz(il2 - yVar.il());
                } else {
                    if (po != 106) {
                        if (po != 122) {
                            if (po == 127) {
                                if (yVar.po() != 21) {
                                }
                            } else if (po == 123) {
                                i3 = 138;
                            } else if (po == 10) {
                                str = yVar.fB(3).trim();
                            } else if (po == 89) {
                                ArrayList arrayList2 = new ArrayList();
                                while (yVar.il() < il2) {
                                    String trim = yVar.fB(3).trim();
                                    int po2 = yVar.po();
                                    byte[] bArr = new byte[4];
                                    yVar.r(bArr, 0, 4);
                                    arrayList2.add(new ad.a(trim, po2, bArr));
                                }
                                arrayList = arrayList2;
                                i3 = 89;
                            } else if (po == 111) {
                                i3 = 257;
                            }
                            yVar.fz(il2 - yVar.il());
                        }
                        i3 = 135;
                        yVar.fz(il2 - yVar.il());
                    }
                    i3 = 129;
                    yVar.fz(il2 - yVar.il());
                }
                i3 = 172;
                yVar.fz(il2 - yVar.il());
            }
            yVar.fx(i2);
            return new ad.b(i3, str, arrayList, Arrays.copyOfRange(yVar.hO(), il, i2));
        }
    }
}
