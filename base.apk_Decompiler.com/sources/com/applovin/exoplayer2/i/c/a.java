package com.applovin.exoplayer2.i.c;

import android.graphics.Bitmap;
import com.applovin.exoplayer2.i.a;
import com.applovin.exoplayer2.i.d;
import com.applovin.exoplayer2.i.f;
import com.applovin.exoplayer2.i.h;
import com.applovin.exoplayer2.l.ai;
import com.applovin.exoplayer2.l.y;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.zip.Inflater;

public final class a extends d {
    private final y Rd = new y();
    private final C0055a Re = new C0055a();
    private Inflater Rf;
    private final y vN = new y();

    public a() {
        super("PgsDecoder");
    }

    /* access modifiers changed from: protected */
    public f c(byte[] bArr, int i, boolean z) throws h {
        this.vN.l(bArr, i);
        ac(this.vN);
        this.Re.Y();
        ArrayList arrayList = new ArrayList();
        while (this.vN.pj() >= 3) {
            com.applovin.exoplayer2.i.a a = a(this.vN, this.Re);
            if (a != null) {
                arrayList.add(a);
            }
        }
        return new b(Collections.unmodifiableList(arrayList));
    }

    private void ac(y yVar) {
        if (yVar.pj() > 0 && yVar.pm() == 120) {
            if (this.Rf == null) {
                this.Rf = new Inflater();
            }
            if (ai.a(yVar, this.Rd, this.Rf)) {
                yVar.l(this.Rd.hO(), this.Rd.pk());
            }
        }
    }

    private static com.applovin.exoplayer2.i.a a(y yVar, C0055a aVar) {
        int pk = yVar.pk();
        int po = yVar.po();
        int pp = yVar.pp();
        int il = yVar.il() + pp;
        com.applovin.exoplayer2.i.a aVar2 = null;
        if (il > pk) {
            yVar.fx(pk);
            return null;
        }
        if (po != 128) {
            switch (po) {
                case 20:
                    aVar.A(yVar, pp);
                    break;
                case 21:
                    aVar.B(yVar, pp);
                    break;
                case 22:
                    aVar.C(yVar, pp);
                    break;
            }
        } else {
            aVar2 = aVar.lU();
            aVar.Y();
        }
        yVar.fx(il);
        return aVar2;
    }

    /* renamed from: com.applovin.exoplayer2.i.c.a$a  reason: collision with other inner class name */
    private static final class C0055a {
        private final y Rg = new y();
        private final int[] Rh = new int[256];
        private boolean Ri;
        private int Rj;
        private int Rk;
        private int Rl;
        private int Rm;
        private int Rn;
        private int Ro;

        /* access modifiers changed from: private */
        public void A(y yVar, int i) {
            if (i % 5 == 2) {
                yVar.fz(2);
                Arrays.fill(this.Rh, 0);
                int i2 = i / 5;
                for (int i3 = 0; i3 < i2; i3++) {
                    int po = yVar.po();
                    int po2 = yVar.po();
                    int po3 = yVar.po();
                    int po4 = yVar.po();
                    int po5 = yVar.po();
                    double d = (double) po2;
                    double d2 = (double) (po3 - 128);
                    double d3 = (double) (po4 - 128);
                    this.Rh[po] = (ai.k((int) ((d - (0.34414d * d3)) - (d2 * 0.71414d)), 0, 255) << 8) | (po5 << 24) | (ai.k((int) ((1.402d * d2) + d), 0, 255) << 16) | ai.k((int) (d + (d3 * 1.772d)), 0, 255);
                }
                this.Ri = true;
            }
        }

        /* access modifiers changed from: private */
        public void B(y yVar, int i) {
            int pt;
            if (i >= 4) {
                yVar.fz(3);
                int i2 = i - 4;
                if ((yVar.po() & 128) != 0) {
                    if (i2 >= 7 && (pt = yVar.pt()) >= 4) {
                        this.Rn = yVar.pp();
                        this.Ro = yVar.pp();
                        this.Rg.U(pt - 4);
                        i2 = i - 11;
                    } else {
                        return;
                    }
                }
                int il = this.Rg.il();
                int pk = this.Rg.pk();
                if (il < pk && i2 > 0) {
                    int min = Math.min(i2, pk - il);
                    yVar.r(this.Rg.hO(), il, min);
                    this.Rg.fx(il + min);
                }
            }
        }

        /* access modifiers changed from: private */
        public void C(y yVar, int i) {
            if (i >= 19) {
                this.Rj = yVar.pp();
                this.Rk = yVar.pp();
                yVar.fz(11);
                this.Rl = yVar.pp();
                this.Rm = yVar.pp();
            }
        }

        public com.applovin.exoplayer2.i.a lU() {
            int i;
            int i2;
            int i3;
            if (this.Rj == 0 || this.Rk == 0 || this.Rn == 0 || this.Ro == 0 || this.Rg.pk() == 0 || this.Rg.il() != this.Rg.pk() || !this.Ri) {
                return null;
            }
            this.Rg.fx(0);
            int i4 = this.Rn * this.Ro;
            int[] iArr = new int[i4];
            int i5 = 0;
            while (i5 < i4) {
                int po = this.Rg.po();
                if (po != 0) {
                    i3 = i5 + 1;
                    iArr[i5] = this.Rh[po];
                } else {
                    int po2 = this.Rg.po();
                    if (po2 != 0) {
                        if ((po2 & 64) == 0) {
                            i = po2 & 63;
                        } else {
                            i = ((po2 & 63) << 8) | this.Rg.po();
                        }
                        if ((po2 & 128) == 0) {
                            i2 = 0;
                        } else {
                            i2 = this.Rh[this.Rg.po()];
                        }
                        i3 = i + i5;
                        Arrays.fill(iArr, i5, i3, i2);
                    }
                }
                i5 = i3;
            }
            return new a.C0050a().a(Bitmap.createBitmap(iArr, this.Rn, this.Ro, Bitmap.Config.ARGB_8888)).o(((float) this.Rl) / ((float) this.Rj)).eg(0).b(((float) this.Rm) / ((float) this.Rk), 0).ef(0).p(((float) this.Rn) / ((float) this.Rj)).q(((float) this.Ro) / ((float) this.Rk)).lU();
        }

        public void Y() {
            this.Rj = 0;
            this.Rk = 0;
            this.Rl = 0;
            this.Rm = 0;
            this.Rn = 0;
            this.Ro = 0;
            this.Rg.U(0);
            this.Ri = false;
        }
    }
}
