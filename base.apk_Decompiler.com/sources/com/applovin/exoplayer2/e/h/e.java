package com.applovin.exoplayer2.e.h;

import com.applovin.exoplayer2.ai;
import com.applovin.exoplayer2.e.i;
import com.applovin.exoplayer2.e.k;
import com.applovin.exoplayer2.l.a;
import com.applovin.exoplayer2.l.y;
import java.io.IOException;

final class e {
    public int BM;
    public long BN;
    public long BO;
    public long BP;
    public long BQ;
    public int BR;
    public int BT;
    public int BU;
    public final int[] BV = new int[255];
    public int bs;
    private final y uO = new y(255);

    public void Y() {
        this.BM = 0;
        this.bs = 0;
        this.BN = 0;
        this.BO = 0;
        this.BP = 0;
        this.BQ = 0;
        this.BR = 0;
        this.BT = 0;
        this.BU = 0;
    }

    e() {
    }

    public boolean T(i iVar) throws IOException {
        return c(iVar, -1);
    }

    public boolean c(i iVar, long j) throws IOException {
        int i;
        a.checkArgument(iVar.ie() == iVar.id());
        this.uO.U(4);
        while (true) {
            i = (j > -1 ? 1 : (j == -1 ? 0 : -1));
            if ((i == 0 || iVar.ie() + 4 < j) && k.a(iVar, this.uO.hO(), 0, 4, true)) {
                this.uO.fx(0);
                if (this.uO.pv() == 1332176723) {
                    iVar.ic();
                    return true;
                }
                iVar.bH(1);
            }
        }
        do {
            if ((i != 0 && iVar.ie() >= j) || iVar.bG(1) == -1) {
                return false;
            }
            break;
        } while (iVar.bG(1) == -1);
        return false;
    }

    public boolean f(i iVar, boolean z) throws IOException {
        Y();
        this.uO.U(27);
        if (!k.a(iVar, this.uO.hO(), 0, 27, z) || this.uO.pv() != 1332176723) {
            return false;
        }
        int po = this.uO.po();
        this.BM = po;
        if (po == 0) {
            this.bs = this.uO.po();
            this.BN = this.uO.pA();
            this.BO = this.uO.pw();
            this.BP = this.uO.pw();
            this.BQ = this.uO.pw();
            int po2 = this.uO.po();
            this.BR = po2;
            this.BT = po2 + 27;
            this.uO.U(po2);
            if (!k.a(iVar, this.uO.hO(), 0, this.BR, z)) {
                return false;
            }
            for (int i = 0; i < this.BR; i++) {
                this.BV[i] = this.uO.po();
                this.BU += this.BV[i];
            }
            return true;
        } else if (z) {
            return false;
        } else {
            throw ai.p("unsupported bit stream revision");
        }
    }
}
