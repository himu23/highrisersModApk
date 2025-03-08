package com.applovin.exoplayer2.e.h;

import com.applovin.exoplayer2.e.h.h;
import com.applovin.exoplayer2.e.i;
import com.applovin.exoplayer2.e.m;
import com.applovin.exoplayer2.e.n;
import com.applovin.exoplayer2.e.o;
import com.applovin.exoplayer2.e.p;
import com.applovin.exoplayer2.e.v;
import com.applovin.exoplayer2.l.ai;
import com.applovin.exoplayer2.l.y;
import java.util.Arrays;
import kotlin.UByte;

final class b extends h {
    private p BD;
    private a BE;

    b() {
    }

    public static boolean F(y yVar) {
        return yVar.pj() >= 5 && yVar.po() == 127 && yVar.pv() == 1179402563;
    }

    /* access modifiers changed from: protected */
    public void e(boolean z) {
        super.e(z);
        if (z) {
            this.BD = null;
            this.BE = null;
        }
    }

    private static boolean A(byte[] bArr) {
        return bArr[0] == -1;
    }

    /* access modifiers changed from: protected */
    public long G(y yVar) {
        if (!A(yVar.hO())) {
            return -1;
        }
        return (long) H(yVar);
    }

    /* access modifiers changed from: protected */
    public boolean a(y yVar, long j, h.a aVar) {
        byte[] hO = yVar.hO();
        p pVar = this.BD;
        if (pVar == null) {
            p pVar2 = new p(hO, 17);
            this.BD = pVar2;
            aVar.dU = pVar2.a(Arrays.copyOfRange(hO, 9, yVar.pk()), (com.applovin.exoplayer2.g.a) null);
            return true;
        } else if ((hO[0] & Byte.MAX_VALUE) == 3) {
            p.a b = n.b(yVar);
            p a2 = pVar.a(b);
            this.BD = a2;
            this.BE = new a(a2, b);
            return true;
        } else if (!A(hO)) {
            return true;
        } else {
            a aVar2 = this.BE;
            if (aVar2 != null) {
                aVar2.aD(j);
                aVar.BZ = this.BE;
            }
            com.applovin.exoplayer2.l.a.checkNotNull(aVar.dU);
            return false;
        }
    }

    private int H(y yVar) {
        int i = (yVar.hO()[2] & UByte.MAX_VALUE) >> 4;
        if (i == 6 || i == 7) {
            yVar.fz(4);
            yVar.pK();
        }
        int a2 = m.a(yVar, i);
        yVar.fx(0);
        return a2;
    }

    private static final class a implements f {
        private p BD;
        private long BF = -1;
        private long uA = -1;
        private p.a uJ;

        public long N(i iVar) {
            long j = this.BF;
            if (j < 0) {
                return -1;
            }
            long j2 = -(j + 2);
            this.BF = -1;
            return j2;
        }

        public void aD(long j) {
            this.uA = j;
        }

        public a(p pVar, p.a aVar) {
            this.BD = pVar;
            this.uJ = aVar;
        }

        public void aC(long j) {
            long[] jArr = this.uJ.uK;
            this.BF = jArr[ai.a(jArr, j, true, true)];
        }

        public v iX() {
            com.applovin.exoplayer2.l.a.checkState(this.uA != -1);
            return new o(this.BD, this.uA);
        }
    }
}
