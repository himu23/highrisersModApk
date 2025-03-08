package com.applovin.exoplayer2.e.i;

import androidx.core.view.InputDeviceCompat;
import com.applovin.exoplayer2.e.i.ad;
import com.applovin.exoplayer2.e.j;
import com.applovin.exoplayer2.l.ag;
import com.applovin.exoplayer2.l.ai;

public final class y implements ad {
    private int Cu;
    private final x Fj;
    private final com.applovin.exoplayer2.l.y Fk = new com.applovin.exoplayer2.l.y(32);
    private int Fl;
    private boolean Fm;
    private boolean Fn;

    public void jb() {
        this.Fn = true;
    }

    public y(x xVar) {
        this.Fj = xVar;
    }

    public void a(ag agVar, j jVar, ad.d dVar) {
        this.Fj.a(agVar, jVar, dVar);
        this.Fn = true;
    }

    public void p(com.applovin.exoplayer2.l.y yVar, int i) {
        boolean z = (i & 1) != 0;
        int il = z ? yVar.il() + yVar.po() : -1;
        if (this.Fn) {
            if (z) {
                this.Fn = false;
                yVar.fx(il);
                this.Cu = 0;
            } else {
                return;
            }
        }
        while (yVar.pj() > 0) {
            int i2 = this.Cu;
            if (i2 < 3) {
                if (i2 == 0) {
                    int po = yVar.po();
                    yVar.fx(yVar.il() - 1);
                    if (po == 255) {
                        this.Fn = true;
                        return;
                    }
                }
                int min = Math.min(yVar.pj(), 3 - this.Cu);
                yVar.r(this.Fk.hO(), this.Cu, min);
                int i3 = this.Cu + min;
                this.Cu = i3;
                if (i3 == 3) {
                    this.Fk.fx(0);
                    this.Fk.fA(3);
                    this.Fk.fz(1);
                    int po2 = this.Fk.po();
                    int po3 = this.Fk.po();
                    this.Fm = (po2 & 128) != 0;
                    this.Fl = (((po2 & 15) << 8) | po3) + 3;
                    int pl = this.Fk.pl();
                    int i4 = this.Fl;
                    if (pl < i4) {
                        this.Fk.bj(Math.min(InputDeviceCompat.SOURCE_TOUCHSCREEN, Math.max(i4, this.Fk.pl() * 2)));
                    }
                }
            } else {
                int min2 = Math.min(yVar.pj(), this.Fl - this.Cu);
                yVar.r(this.Fk.hO(), this.Cu, min2);
                int i5 = this.Cu + min2;
                this.Cu = i5;
                int i6 = this.Fl;
                if (i5 != i6) {
                    continue;
                } else {
                    if (!this.Fm) {
                        this.Fk.fA(i6);
                    } else if (ai.b(this.Fk.hO(), 0, this.Fl, -1) != 0) {
                        this.Fn = true;
                        return;
                    } else {
                        this.Fk.fA(this.Fl - 4);
                    }
                    this.Fk.fx(0);
                    this.Fj.K(this.Fk);
                    this.Cu = 0;
                }
            }
        }
    }
}
