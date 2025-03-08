package com.applovin.exoplayer2.e.h;

import com.applovin.exoplayer2.e.i;
import com.applovin.exoplayer2.e.k;
import com.applovin.exoplayer2.l.a;
import com.applovin.exoplayer2.l.y;
import java.io.IOException;
import java.util.Arrays;

final class d {
    private final y BI = new y(new byte[65025], 0);
    private int BJ = -1;
    private int BK;
    private boolean BL;
    private final e Br = new e();

    public e iY() {
        return this.Br;
    }

    public y iZ() {
        return this.BI;
    }

    d() {
    }

    public void Y() {
        this.Br.Y();
        this.BI.U(0);
        this.BJ = -1;
        this.BL = false;
    }

    public boolean S(i iVar) throws IOException {
        int i;
        a.checkState(iVar != null);
        if (this.BL) {
            this.BL = false;
            this.BI.U(0);
        }
        while (!this.BL) {
            if (this.BJ < 0) {
                if (!this.Br.T(iVar) || !this.Br.f(iVar, true)) {
                    return false;
                }
                int i2 = this.Br.BT;
                if ((this.Br.bs & 1) == 1 && this.BI.pk() == 0) {
                    i2 += ct(0);
                    i = this.BK;
                } else {
                    i = 0;
                }
                if (!k.a(iVar, i2)) {
                    return false;
                }
                this.BJ = i;
            }
            int ct = ct(this.BJ);
            int i3 = this.BJ + this.BK;
            if (ct > 0) {
                y yVar = this.BI;
                yVar.bj(yVar.pk() + ct);
                if (!k.b(iVar, this.BI.hO(), this.BI.pk(), ct)) {
                    return false;
                }
                y yVar2 = this.BI;
                yVar2.fA(yVar2.pk() + ct);
                this.BL = this.Br.BV[i3 + -1] != 255;
            }
            if (i3 == this.Br.BR) {
                i3 = -1;
            }
            this.BJ = i3;
        }
        return true;
    }

    public void ja() {
        if (this.BI.hO().length != 65025) {
            y yVar = this.BI;
            yVar.l(Arrays.copyOf(yVar.hO(), Math.max(65025, this.BI.pk())), this.BI.pk());
        }
    }

    private int ct(int i) {
        int i2 = 0;
        this.BK = 0;
        while (this.BK + i < this.Br.BR) {
            int[] iArr = this.Br.BV;
            int i3 = this.BK;
            this.BK = i3 + 1;
            int i4 = iArr[i3 + i];
            i2 += i4;
            if (i4 != 255) {
                break;
            }
        }
        return i2;
    }
}
