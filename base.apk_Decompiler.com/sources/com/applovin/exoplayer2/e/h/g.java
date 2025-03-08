package com.applovin.exoplayer2.e.h;

import com.applovin.exoplayer2.b.s;
import com.applovin.exoplayer2.e.h.h;
import com.applovin.exoplayer2.l.a;
import com.applovin.exoplayer2.l.y;
import com.applovin.exoplayer2.v;
import com.ironsource.mediationsdk.demandOnly.e;
import java.util.Arrays;
import kotlin.UByte;

final class g extends h {
    private static final byte[] BW = {79, 112, 117, 115, 72, 101, 97, 100};
    private boolean BX;

    g() {
    }

    public static boolean F(y yVar) {
        int pj = yVar.pj();
        byte[] bArr = BW;
        if (pj < bArr.length) {
            return false;
        }
        byte[] bArr2 = new byte[bArr.length];
        yVar.r(bArr2, 0, bArr.length);
        return Arrays.equals(bArr2, bArr);
    }

    /* access modifiers changed from: protected */
    public void e(boolean z) {
        super.e(z);
        if (z) {
            this.BX = false;
        }
    }

    /* access modifiers changed from: protected */
    public long G(y yVar) {
        return aF(B(yVar.hO()));
    }

    /* access modifiers changed from: protected */
    public boolean a(y yVar, long j, h.a aVar) {
        boolean z = true;
        if (!this.BX) {
            byte[] copyOf = Arrays.copyOf(yVar.hO(), yVar.pk());
            int i = s.i(copyOf);
            aVar.dU = new v.a().m("audio/opus").N(i).O(48000).c(s.j(copyOf)).bT();
            this.BX = true;
            return true;
        }
        a.checkNotNull(aVar.dU);
        if (yVar.px() != 1332770163) {
            z = false;
        }
        yVar.fx(0);
        return z;
    }

    private long B(byte[] bArr) {
        byte b;
        byte b2 = bArr[0];
        byte b3 = b2 & UByte.MAX_VALUE;
        byte b4 = b2 & 3;
        if (b4 != 0) {
            b = 2;
            if (!(b4 == 1 || b4 == 2)) {
                b = bArr[1] & 63;
            }
        } else {
            b = 1;
        }
        int i = b3 >> 3;
        int i2 = i & 3;
        return ((long) b) * ((long) (i >= 16 ? e.b.p << i2 : i >= 12 ? 10000 << (i & 1) : i2 == 3 ? 60000 : 10000 << i2));
    }
}
