package com.applovin.exoplayer2.e.d;

import com.applovin.exoplayer2.e.g.g;
import com.applovin.exoplayer2.e.h;
import com.applovin.exoplayer2.e.i;
import com.applovin.exoplayer2.e.j;
import com.applovin.exoplayer2.e.u;
import com.applovin.exoplayer2.e.v;
import com.applovin.exoplayer2.g.a;
import com.applovin.exoplayer2.g.f.b;
import com.applovin.exoplayer2.l.y;
import com.applovin.exoplayer2.v;
import java.io.IOException;

public final class a implements h {
    private int Z;
    private final y uO = new y(6);
    private j vG;
    private int wr;
    private int ws;
    private long wt = -1;
    private b wu;
    private i wv;
    private c ww;
    private g wx;

    public void a(j jVar) {
        this.vG = jVar;
    }

    public boolean a(i iVar) throws IOException {
        if (s(iVar) != 65496) {
            return false;
        }
        int s = s(iVar);
        this.wr = s;
        if (s == 65504) {
            t(iVar);
            this.wr = s(iVar);
        }
        if (this.wr != 65505) {
            return false;
        }
        iVar.bI(2);
        this.uO.U(6);
        iVar.c(this.uO.hO(), 0, 6);
        if (this.uO.pv() == 1165519206 && this.uO.pp() == 0) {
            return true;
        }
        return false;
    }

    public int b(i iVar, u uVar) throws IOException {
        int i = this.Z;
        if (i == 0) {
            u(iVar);
            return 0;
        } else if (i == 1) {
            v(iVar);
            return 0;
        } else if (i == 2) {
            w(iVar);
            return 0;
        } else if (i == 4) {
            long ie = iVar.ie();
            long j = this.wt;
            if (ie != j) {
                uVar.uc = j;
                return 1;
            }
            x(iVar);
            return 0;
        } else if (i == 5) {
            if (this.ww == null || iVar != this.wv) {
                this.wv = iVar;
                this.ww = new c(iVar, this.wt);
            }
            int b = ((g) com.applovin.exoplayer2.l.a.checkNotNull(this.wx)).b(this.ww, uVar);
            if (b == 1) {
                uVar.uc += this.wt;
            }
            return b;
        } else if (i == 6) {
            return -1;
        } else {
            throw new IllegalStateException();
        }
    }

    public void o(long j, long j2) {
        if (j == 0) {
            this.Z = 0;
            this.wx = null;
        } else if (this.Z == 5) {
            ((g) com.applovin.exoplayer2.l.a.checkNotNull(this.wx)).o(j, j2);
        }
    }

    public void release() {
        g gVar = this.wx;
        if (gVar != null) {
            gVar.release();
        }
    }

    private int s(i iVar) throws IOException {
        this.uO.U(2);
        iVar.c(this.uO.hO(), 0, 2);
        return this.uO.pp();
    }

    private void t(i iVar) throws IOException {
        this.uO.U(2);
        iVar.c(this.uO.hO(), 0, 2);
        iVar.bI(this.uO.pp() - 2);
    }

    private void u(i iVar) throws IOException {
        this.uO.U(2);
        iVar.a(this.uO.hO(), 0, 2);
        int pp = this.uO.pp();
        this.wr = pp;
        if (pp == 65498) {
            if (this.wt != -1) {
                this.Z = 4;
            } else {
                iv();
            }
        } else if ((pp < 65488 || pp > 65497) && pp != 65281) {
            this.Z = 1;
        }
    }

    private void v(i iVar) throws IOException {
        this.uO.U(2);
        iVar.a(this.uO.hO(), 0, 2);
        this.ws = this.uO.pp() - 2;
        this.Z = 2;
    }

    private void w(i iVar) throws IOException {
        String pI;
        if (this.wr == 65505) {
            y yVar = new y(this.ws);
            iVar.a(yVar.hO(), 0, this.ws);
            if (this.wu == null && "http://ns.adobe.com/xap/1.0/".equals(yVar.pI()) && (pI = yVar.pI()) != null) {
                b c = c(pI, iVar.m1771if());
                this.wu = c;
                if (c != null) {
                    this.wt = c.Kg;
                }
            }
        } else {
            iVar.bH(this.ws);
        }
        this.Z = 0;
    }

    private void x(i iVar) throws IOException {
        if (!iVar.b(this.uO.hO(), 0, 1, true)) {
            iv();
            return;
        }
        iVar.ic();
        if (this.wx == null) {
            this.wx = new g();
        }
        c cVar = new c(iVar, this.wt);
        this.ww = cVar;
        if (this.wx.a((i) cVar)) {
            this.wx.a((j) new d(this.wt, (j) com.applovin.exoplayer2.l.a.checkNotNull(this.vG)));
            iu();
            return;
        }
        iv();
    }

    private void iu() {
        a((a.C0047a) com.applovin.exoplayer2.l.a.checkNotNull(this.wu));
        this.Z = 5;
    }

    private void iv() {
        a(new a.C0047a[0]);
        ((j) com.applovin.exoplayer2.l.a.checkNotNull(this.vG)).ig();
        this.vG.a(new v.b(-9223372036854775807L));
        this.Z = 6;
    }

    private void a(a.C0047a... aVarArr) {
        ((j) com.applovin.exoplayer2.l.a.checkNotNull(this.vG)).y(1024, 4).j(new v.a().l("image/jpeg").b(new com.applovin.exoplayer2.g.a(aVarArr)).bT());
    }

    private static b c(String str, long j) throws IOException {
        b E;
        if (j == -1 || (E = e.E(str)) == null) {
            return null;
        }
        return E.ao(j);
    }
}
