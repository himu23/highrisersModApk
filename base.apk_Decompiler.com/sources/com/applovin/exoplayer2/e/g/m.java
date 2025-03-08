package com.applovin.exoplayer2.e.g;

import com.applovin.exoplayer2.e.i;
import com.applovin.exoplayer2.l.y;
import java.io.IOException;

final class m {
    public c AY;
    public long AZ;
    public long Ba;
    public long Bb;
    public int Bc;
    public long[] Bd = new long[0];
    public int[] Be = new int[0];
    public int[] Bf = new int[0];
    public int[] Bg = new int[0];
    public long[] Bh = new long[0];
    public boolean[] Bi = new boolean[0];
    public boolean Bj;
    public boolean[] Bk = new boolean[0];
    public l Bl;
    public final y Bm = new y();
    public boolean Bn;
    public long Bo;
    public boolean Bp;
    public int jA;

    public void Y() {
        this.Bc = 0;
        this.Bo = 0;
        this.Bp = false;
        this.Bj = false;
        this.Bn = false;
        this.Bl = null;
    }

    public void A(int i, int i2) {
        this.Bc = i;
        this.jA = i2;
        if (this.Be.length < i) {
            this.Bd = new long[i];
            this.Be = new int[i];
        }
        if (this.Bf.length < i2) {
            int i3 = (i2 * 125) / 100;
            this.Bf = new int[i3];
            this.Bg = new int[i3];
            this.Bh = new long[i3];
            this.Bi = new boolean[i3];
            this.Bk = new boolean[i3];
        }
    }

    public void cq(int i) {
        this.Bm.U(i);
        this.Bj = true;
        this.Bn = true;
    }

    public void M(i iVar) throws IOException {
        iVar.a(this.Bm.hO(), 0, this.Bm.pk());
        this.Bm.fx(0);
        this.Bn = false;
    }

    public void E(y yVar) {
        yVar.r(this.Bm.hO(), 0, this.Bm.pk());
        this.Bm.fx(0);
        this.Bn = false;
    }

    public long cr(int i) {
        return this.Bh[i] + ((long) this.Bg[i]);
    }

    public boolean cs(int i) {
        return this.Bj && this.Bk[i];
    }
}
