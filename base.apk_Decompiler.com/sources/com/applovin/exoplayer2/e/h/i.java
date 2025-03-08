package com.applovin.exoplayer2.e.h;

import com.applovin.exoplayer2.ai;
import com.applovin.exoplayer2.e.h.h;
import com.applovin.exoplayer2.e.z;
import com.applovin.exoplayer2.l.y;
import com.applovin.exoplayer2.v;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final class i extends h {
    private a Cf;
    private int Cg;
    private boolean Ch;
    private z.d Ci;
    private z.b Cj;

    static int a(byte b, int i, int i2) {
        return (b >> i2) & (255 >>> (8 - i));
    }

    i() {
    }

    public static boolean F(y yVar) {
        try {
            return z.a(1, yVar, true);
        } catch (ai unused) {
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void e(boolean z) {
        super.e(z);
        if (z) {
            this.Cf = null;
            this.Ci = null;
            this.Cj = null;
        }
        this.Cg = 0;
        this.Ch = false;
    }

    /* access modifiers changed from: protected */
    public void aG(long j) {
        super.aG(j);
        int i = 0;
        this.Ch = j != 0;
        z.d dVar = this.Ci;
        if (dVar != null) {
            i = dVar.vn;
        }
        this.Cg = i;
    }

    /* access modifiers changed from: protected */
    public long G(y yVar) {
        int i = 0;
        if ((yVar.hO()[0] & 1) == 1) {
            return -1;
        }
        int a2 = a(yVar.hO()[0], (a) com.applovin.exoplayer2.l.a.N(this.Cf));
        if (this.Ch) {
            i = (this.Cg + a2) / 4;
        }
        long j = (long) i;
        d(yVar, j);
        this.Ch = true;
        this.Cg = a2;
        return j;
    }

    /* access modifiers changed from: protected */
    public boolean a(y yVar, long j, h.a aVar) throws IOException {
        if (this.Cf != null) {
            com.applovin.exoplayer2.l.a.checkNotNull(aVar.dU);
            return false;
        }
        a J = J(yVar);
        this.Cf = J;
        if (J == null) {
            return true;
        }
        z.d dVar = J.Ck;
        ArrayList arrayList = new ArrayList();
        arrayList.add(dVar.tf);
        arrayList.add(J.Cl);
        aVar.dU = new v.a().m("audio/vorbis").G(dVar.vl).H(dVar.vk).N(dVar.mI).O(dVar.dM).c((List<byte[]>) arrayList).bT();
        return true;
    }

    /* access modifiers changed from: package-private */
    public a J(y yVar) throws IOException {
        z.d dVar = this.Ci;
        if (dVar == null) {
            this.Ci = z.c(yVar);
            return null;
        }
        z.b bVar = this.Cj;
        if (bVar == null) {
            this.Cj = z.d(yVar);
            return null;
        }
        byte[] bArr = new byte[yVar.pk()];
        System.arraycopy(yVar.hO(), 0, bArr, 0, yVar.pk());
        z.c[] d = z.d(yVar, dVar.mI);
        return new a(dVar, bVar, bArr, d, z.bS(d.length - 1));
    }

    static void d(y yVar, long j) {
        if (yVar.pl() < yVar.pk() + 4) {
            yVar.I(Arrays.copyOf(yVar.hO(), yVar.pk() + 4));
        } else {
            yVar.fA(yVar.pk() + 4);
        }
        byte[] hO = yVar.hO();
        hO[yVar.pk() - 4] = (byte) ((int) (j & 255));
        hO[yVar.pk() - 3] = (byte) ((int) ((j >>> 8) & 255));
        hO[yVar.pk() - 2] = (byte) ((int) ((j >>> 16) & 255));
        hO[yVar.pk() - 1] = (byte) ((int) ((j >>> 24) & 255));
    }

    private static int a(byte b, a aVar) {
        if (!aVar.Cm[a(b, aVar.Cn, 1)].vg) {
            return aVar.Ck.vn;
        }
        return aVar.Ck.vo;
    }

    static final class a {
        public final z.b Cj;
        public final z.d Ck;
        public final byte[] Cl;
        public final z.c[] Cm;
        public final int Cn;

        public a(z.d dVar, z.b bVar, byte[] bArr, z.c[] cVarArr, int i) {
            this.Ck = dVar;
            this.Cj = bVar;
            this.Cl = bArr;
            this.Cm = cVarArr;
            this.Cn = i;
        }
    }
}
