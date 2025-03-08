package com.applovin.exoplayer2.e.i;

import com.applovin.exoplayer2.e.i.ad;
import com.applovin.exoplayer2.e.j;
import com.applovin.exoplayer2.e.x;
import com.applovin.exoplayer2.l.ai;
import com.applovin.exoplayer2.l.e;
import com.applovin.exoplayer2.l.q;
import com.applovin.exoplayer2.l.v;
import com.applovin.exoplayer2.l.y;
import com.applovin.exoplayer2.l.z;
import com.applovin.exoplayer2.v;
import com.unity3d.services.core.device.MimeTypes;
import java.util.Collections;
import java.util.List;
import kotlin.jvm.internal.ByteCompanionObject;

public final class n implements j {
    private String Ct;
    private final r DC = new r(33, 128);
    private final r DD = new r(34, 128);
    private final y DH = new y();
    private final boolean[] Df = new boolean[3];
    private long Dh;
    private long Dk = -9223372036854775807L;
    private final z Dz;
    private a Ei;
    private final r Ej = new r(32, 128);
    private final r Ek = new r(39, 128);
    private final r El = new r(40, 128);
    private boolean vJ;
    private x wl;

    public void e(long j, int i) {
        if (j != -9223372036854775807L) {
            this.Dk = j;
        }
    }

    public void jc() {
    }

    public n(z zVar) {
        this.Dz = zVar;
    }

    public void jb() {
        this.Dh = 0;
        this.Dk = -9223372036854775807L;
        v.b(this.Df);
        this.Ej.Y();
        this.DC.Y();
        this.DD.Y();
        this.Ek.Y();
        this.El.Y();
        a aVar = this.Ei;
        if (aVar != null) {
            aVar.Y();
        }
    }

    public void a(j jVar, ad.d dVar) {
        dVar.jy();
        this.Ct = dVar.jA();
        x y = jVar.y(dVar.jz(), 2);
        this.wl = y;
        this.Ei = new a(y);
        this.Dz.a(jVar, dVar);
    }

    public void K(y yVar) {
        jm();
        while (yVar.pj() > 0) {
            int il = yVar.il();
            int pk = yVar.pk();
            byte[] hO = yVar.hO();
            this.Dh += (long) yVar.pj();
            this.wl.c(yVar, yVar.pj());
            while (true) {
                if (il < pk) {
                    int a2 = v.a(hO, il, pk, this.Df);
                    if (a2 == pk) {
                        f(hO, il, pk);
                        return;
                    }
                    int k = v.k(hO, a2);
                    int i = a2 - il;
                    if (i > 0) {
                        f(hO, il, a2);
                    }
                    int i2 = pk - a2;
                    long j = this.Dh - ((long) i2);
                    int i3 = i < 0 ? -i : 0;
                    long j2 = j;
                    int i4 = i2;
                    a(j2, i4, i3, this.Dk);
                    b(j2, i4, k, this.Dk);
                    il = a2 + 3;
                }
            }
        }
    }

    private void b(long j, int i, int i2, long j2) {
        this.Ei.a(j, i, i2, j2, this.vJ);
        if (!this.vJ) {
            this.Ej.cB(i2);
            this.DC.cB(i2);
            this.DD.cB(i2);
        }
        this.Ek.cB(i2);
        this.El.cB(i2);
    }

    private void f(byte[] bArr, int i, int i2) {
        this.Ei.h(bArr, i, i2);
        if (!this.vJ) {
            this.Ej.g(bArr, i, i2);
            this.DC.g(bArr, i, i2);
            this.DD.g(bArr, i, i2);
        }
        this.Ek.g(bArr, i, i2);
        this.El.g(bArr, i, i2);
    }

    private void a(long j, int i, int i2, long j2) {
        this.Ei.b(j, i, this.vJ);
        if (!this.vJ) {
            this.Ej.cC(i2);
            this.DC.cC(i2);
            this.DD.cC(i2);
            if (this.Ej.jq() && this.DC.jq() && this.DD.jq()) {
                this.wl.j(a(this.Ct, this.Ej, this.DC, this.DD));
                this.vJ = true;
            }
        }
        if (this.Ek.cC(i2)) {
            this.DH.l(this.Ek.EJ, v.i(this.Ek.EJ, this.Ek.EK));
            this.DH.fz(5);
            this.Dz.a(j2, this.DH);
        }
        if (this.El.cC(i2)) {
            this.DH.l(this.El.EJ, v.i(this.El.EJ, this.El.EK));
            this.DH.fz(5);
            this.Dz.a(j2, this.DH);
        }
    }

    private static com.applovin.exoplayer2.v a(String str, r rVar, r rVar2, r rVar3) {
        r rVar4 = rVar;
        r rVar5 = rVar2;
        r rVar6 = rVar3;
        byte[] bArr = new byte[(rVar4.EK + rVar5.EK + rVar6.EK)];
        System.arraycopy(rVar4.EJ, 0, bArr, 0, rVar4.EK);
        System.arraycopy(rVar5.EJ, 0, bArr, rVar4.EK, rVar5.EK);
        System.arraycopy(rVar6.EJ, 0, bArr, rVar4.EK + rVar5.EK, rVar6.EK);
        z zVar = new z(rVar5.EJ, 0, rVar5.EK);
        zVar.bR(44);
        int bQ = zVar.bQ(3);
        zVar.ph();
        zVar.bR(88);
        zVar.bR(8);
        int i = 0;
        for (int i2 = 0; i2 < bQ; i2++) {
            if (zVar.ik()) {
                i += 89;
            }
            if (zVar.ik()) {
                i += 8;
            }
        }
        zVar.bR(i);
        if (bQ > 0) {
            zVar.bR((8 - bQ) * 2);
        }
        zVar.pM();
        int pM = zVar.pM();
        if (pM == 3) {
            zVar.ph();
        }
        int pM2 = zVar.pM();
        int pM3 = zVar.pM();
        if (zVar.ik()) {
            int pM4 = zVar.pM();
            int pM5 = zVar.pM();
            int pM6 = zVar.pM();
            int pM7 = zVar.pM();
            int i3 = 1;
            int i4 = (pM == 1 || pM == 2) ? 2 : 1;
            if (pM == 1) {
                i3 = 2;
            }
            pM2 -= i4 * (pM4 + pM5);
            pM3 -= i3 * (pM6 + pM7);
        }
        zVar.pM();
        zVar.pM();
        int pM8 = zVar.pM();
        for (int i5 = zVar.ik() ? 0 : bQ; i5 <= bQ; i5++) {
            zVar.pM();
            zVar.pM();
            zVar.pM();
        }
        zVar.pM();
        zVar.pM();
        zVar.pM();
        zVar.pM();
        zVar.pM();
        zVar.pM();
        if (zVar.ik() && zVar.ik()) {
            a(zVar);
        }
        zVar.bR(2);
        if (zVar.ik()) {
            zVar.bR(8);
            zVar.pM();
            zVar.pM();
            zVar.ph();
        }
        b(zVar);
        if (zVar.ik()) {
            for (int i6 = 0; i6 < zVar.pM(); i6++) {
                zVar.bR(pM8 + 5);
            }
        }
        zVar.bR(2);
        float f = 1.0f;
        if (zVar.ik()) {
            if (zVar.ik()) {
                int bQ2 = zVar.bQ(8);
                if (bQ2 == 255) {
                    int bQ3 = zVar.bQ(16);
                    int bQ4 = zVar.bQ(16);
                    if (!(bQ3 == 0 || bQ4 == 0)) {
                        f = ((float) bQ3) / ((float) bQ4);
                    }
                } else if (bQ2 < v.acq.length) {
                    f = v.acq[bQ2];
                } else {
                    q.h("H265Reader", "Unexpected aspect_ratio_idc value: " + bQ2);
                }
            }
            if (zVar.ik()) {
                zVar.ph();
            }
            if (zVar.ik()) {
                zVar.bR(4);
                if (zVar.ik()) {
                    zVar.bR(24);
                }
            }
            if (zVar.ik()) {
                zVar.pM();
                zVar.pM();
            }
            zVar.ph();
            if (zVar.ik()) {
                pM3 *= 2;
            }
        }
        zVar.s(rVar5.EJ, 0, rVar5.EK);
        zVar.bR(24);
        return new v.a().g(str).m(MimeTypes.VIDEO_H265).k(e.c(zVar)).J(pM2).K(pM3).e(f).c((List<byte[]>) Collections.singletonList(bArr)).bT();
    }

    private static void a(z zVar) {
        for (int i = 0; i < 4; i++) {
            int i2 = 0;
            while (i2 < 6) {
                int i3 = 1;
                if (!zVar.ik()) {
                    zVar.pM();
                } else {
                    int min = Math.min(64, 1 << ((i << 1) + 4));
                    if (i > 1) {
                        zVar.pN();
                    }
                    for (int i4 = 0; i4 < min; i4++) {
                        zVar.pN();
                    }
                }
                if (i == 3) {
                    i3 = 3;
                }
                i2 += i3;
            }
        }
    }

    private static void b(z zVar) {
        int pM = zVar.pM();
        boolean z = false;
        int i = 0;
        for (int i2 = 0; i2 < pM; i2++) {
            if (i2 != 0) {
                z = zVar.ik();
            }
            if (z) {
                zVar.ph();
                zVar.pM();
                for (int i3 = 0; i3 <= i; i3++) {
                    if (zVar.ik()) {
                        zVar.ph();
                    }
                }
            } else {
                int pM2 = zVar.pM();
                int pM3 = zVar.pM();
                int i4 = pM2 + pM3;
                for (int i5 = 0; i5 < pM2; i5++) {
                    zVar.pM();
                    zVar.ph();
                }
                for (int i6 = 0; i6 < pM3; i6++) {
                    zVar.pM();
                    zVar.ph();
                }
                i = i4;
            }
        }
    }

    private void jm() {
        com.applovin.exoplayer2.l.a.N(this.wl);
        ai.R(this.Ei);
    }

    private static final class a {
        private long DP;
        private long Da;
        private long Dl;
        private boolean Dm;
        private boolean Dv;
        private long Em;
        private boolean En;
        private int Eo;
        private boolean Ep;
        private boolean Eq;
        private boolean Er;
        private boolean Es;
        private final x wl;

        private static boolean cy(int i) {
            return (32 <= i && i <= 35) || i == 39;
        }

        private static boolean cz(int i) {
            return i < 32 || i == 40;
        }

        public void Y() {
            this.Ep = false;
            this.Eq = false;
            this.Er = false;
            this.Dv = false;
            this.Es = false;
        }

        public a(x xVar) {
            this.wl = xVar;
        }

        public void a(long j, int i, int i2, long j2, boolean z) {
            boolean z2 = false;
            this.Eq = false;
            this.Er = false;
            this.DP = j2;
            this.Eo = 0;
            this.Em = j;
            if (!cz(i2)) {
                if (this.Dv && !this.Es) {
                    if (z) {
                        cw(i);
                    }
                    this.Dv = false;
                }
                if (cy(i2)) {
                    this.Er = !this.Es;
                    this.Es = true;
                }
            }
            boolean z3 = i2 >= 16 && i2 <= 21;
            this.En = z3;
            if (z3 || i2 <= 9) {
                z2 = true;
            }
            this.Ep = z2;
        }

        public void h(byte[] bArr, int i, int i2) {
            if (this.Ep) {
                int i3 = this.Eo;
                int i4 = (i + 2) - i3;
                if (i4 < i2) {
                    this.Eq = (bArr[i4] & ByteCompanionObject.MIN_VALUE) != 0;
                    this.Ep = false;
                    return;
                }
                this.Eo = i3 + (i2 - i);
            }
        }

        public void b(long j, int i, boolean z) {
            if (this.Es && this.Eq) {
                this.Dm = this.En;
                this.Es = false;
            } else if (this.Er || this.Eq) {
                if (z && this.Dv) {
                    cw(i + ((int) (j - this.Em)));
                }
                this.Dl = this.Em;
                this.Da = this.DP;
                this.Dm = this.En;
                this.Dv = true;
            }
        }

        private void cw(int i) {
            long j = this.Da;
            if (j != -9223372036854775807L) {
                boolean z = this.Dm;
                this.wl.a(j, z ? 1 : 0, (int) (this.Em - this.Dl), i, (x.a) null);
            }
        }
    }
}
