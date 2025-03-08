package com.applovin.exoplayer2.e.c;

import com.applovin.exoplayer2.ai;
import com.applovin.exoplayer2.b.a;
import com.applovin.exoplayer2.e.c.d;
import com.applovin.exoplayer2.e.x;
import com.applovin.exoplayer2.l.y;
import com.applovin.exoplayer2.v;
import com.google.android.gms.games.GamesStatusCodes;
import java.util.Collections;
import java.util.List;

final class a extends d {
    private static final int[] vT = {5512, 11025, 22050, 44100};
    private boolean vJ;
    private boolean vU;
    private int vV;

    public a(x xVar) {
        super(xVar);
    }

    /* access modifiers changed from: protected */
    public boolean e(y yVar) throws d.a {
        if (!this.vU) {
            int po = yVar.po();
            int i = (po >> 4) & 15;
            this.vV = i;
            if (i == 2) {
                this.wl.j(new v.a().m("audio/mpeg").N(1).O(vT[(po >> 2) & 3]).bT());
                this.vJ = true;
            } else if (i == 7 || i == 8) {
                this.wl.j(new v.a().m(i == 7 ? "audio/g711-alaw" : "audio/g711-mlaw").N(1).O(GamesStatusCodes.STATUS_MILESTONE_CLAIMED_PREVIOUSLY).bT());
                this.vJ = true;
            } else if (i != 10) {
                throw new d.a("Audio format not supported: " + this.vV);
            }
            this.vU = true;
        } else {
            yVar.fz(1);
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean a(y yVar, long j) throws ai {
        if (this.vV == 2) {
            int pj = yVar.pj();
            this.wl.c(yVar, pj);
            this.wl.a(j, 1, pj, 0, (x.a) null);
            return true;
        }
        int po = yVar.po();
        if (po == 0 && !this.vJ) {
            int pj2 = yVar.pj();
            byte[] bArr = new byte[pj2];
            yVar.r(bArr, 0, pj2);
            a.C0031a b = com.applovin.exoplayer2.b.a.b(bArr);
            this.wl.j(new v.a().m("audio/mp4a-latm").k(b.dw).N(b.dL).O(b.js).c((List<byte[]>) Collections.singletonList(bArr)).bT());
            this.vJ = true;
            return false;
        } else if (this.vV == 10 && po != 1) {
            return false;
        } else {
            int pj3 = yVar.pj();
            this.wl.c(yVar, pj3);
            this.wl.a(j, 1, pj3, 0, (x.a) null);
            return true;
        }
    }
}
