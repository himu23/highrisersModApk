package com.applovin.exoplayer2.h;

import com.applovin.exoplayer2.c.c;
import com.applovin.exoplayer2.c.g;
import com.applovin.exoplayer2.e.x;
import com.applovin.exoplayer2.h.w;
import com.applovin.exoplayer2.k.b;
import com.applovin.exoplayer2.l.ai;
import com.applovin.exoplayer2.l.y;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import kotlin.jvm.internal.ByteCompanionObject;

class v {
    private long Dh;
    private final b Lu;
    private final int MK;
    private a ML;
    private a MM;
    private a MN;
    private final y uO = new y(32);

    public void lt() {
        this.MM = this.ML;
    }

    public long lu() {
        return this.Dh;
    }

    public v(b bVar) {
        this.Lu = bVar;
        int oc = bVar.oc();
        this.MK = oc;
        a aVar = new a(0, oc);
        this.ML = aVar;
        this.MM = aVar;
        this.MN = aVar;
    }

    public void Y() {
        a(this.ML);
        a aVar = new a(0, this.MK);
        this.ML = aVar;
        this.MM = aVar;
        this.MN = aVar;
        this.Dh = 0;
        this.Lu.ob();
    }

    public void a(g gVar, w.a aVar) {
        this.MM = a(this.MM, gVar, aVar, this.uO);
    }

    public void b(g gVar, w.a aVar) {
        a(this.MM, gVar, aVar, this.uO);
    }

    public void aY(long j) {
        if (j != -1) {
            while (j >= this.ML.zl) {
                this.Lu.a(this.ML.MQ);
                this.ML = this.ML.lv();
            }
            if (this.MM.MO < this.ML.MO) {
                this.MM = this.ML;
            }
        }
    }

    public int a(com.applovin.exoplayer2.k.g gVar, int i, boolean z) throws IOException {
        int read = gVar.read(this.MN.MQ.tf, this.MN.aZ(this.Dh), dN(i));
        if (read != -1) {
            dO(read);
            return read;
        } else if (z) {
            return -1;
        } else {
            throw new EOFException();
        }
    }

    public void c(y yVar, int i) {
        while (i > 0) {
            int dN = dN(i);
            yVar.r(this.MN.MQ.tf, this.MN.aZ(this.Dh), dN);
            i -= dN;
            dO(dN);
        }
    }

    private void a(a aVar) {
        if (aVar.MP) {
            int i = (this.MN.MP ? 1 : 0) + (((int) (this.MN.MO - aVar.MO)) / this.MK);
            com.applovin.exoplayer2.k.a[] aVarArr = new com.applovin.exoplayer2.k.a[i];
            for (int i2 = 0; i2 < i; i2++) {
                aVarArr[i2] = aVar.MQ;
                aVar = aVar.lv();
            }
            this.Lu.a(aVarArr);
        }
    }

    private int dN(int i) {
        if (!this.MN.MP) {
            this.MN.a(this.Lu.oa(), new a(this.MN.zl, this.MK));
        }
        return Math.min(i, (int) (this.MN.zl - this.Dh));
    }

    private void dO(int i) {
        long j = this.Dh + ((long) i);
        this.Dh = j;
        if (j == this.MN.zl) {
            this.MN = this.MN.MR;
        }
    }

    private static a a(a aVar, g gVar, w.a aVar2, y yVar) {
        if (gVar.hg()) {
            aVar = b(aVar, gVar, aVar2, yVar);
        }
        if (gVar.ha()) {
            yVar.U(4);
            a a2 = a(aVar, aVar2.zr, yVar.hO(), 4);
            int pD = yVar.pD();
            aVar2.zr += 4;
            aVar2.oW -= 4;
            gVar.by(pD);
            a a3 = a(a2, aVar2.zr, gVar.rH, pD);
            aVar2.zr += (long) pD;
            aVar2.oW -= pD;
            gVar.bx(aVar2.oW);
            return a(a3, aVar2.zr, gVar.rK, aVar2.oW);
        }
        gVar.by(aVar2.oW);
        return a(aVar, aVar2.zr, gVar.rH, aVar2.oW);
    }

    private static a b(a aVar, g gVar, w.a aVar2, y yVar) {
        int i;
        w.a aVar3 = aVar2;
        y yVar2 = yVar;
        long j = aVar3.zr;
        yVar2.U(1);
        a a2 = a(aVar, j, yVar.hO(), 1);
        long j2 = j + 1;
        byte b = yVar.hO()[0];
        boolean z = (b & ByteCompanionObject.MIN_VALUE) != 0;
        byte b2 = b & Byte.MAX_VALUE;
        c cVar = gVar.rG;
        if (cVar.rk == null) {
            cVar.rk = new byte[16];
        } else {
            Arrays.fill(cVar.rk, (byte) 0);
        }
        a a3 = a(a2, j2, cVar.rk, (int) b2);
        long j3 = j2 + ((long) b2);
        if (z) {
            yVar2.U(2);
            a3 = a(a3, j3, yVar.hO(), 2);
            j3 += 2;
            i = yVar.pp();
        } else {
            i = 1;
        }
        int[] iArr = cVar.rn;
        if (iArr == null || iArr.length < i) {
            iArr = new int[i];
        }
        int[] iArr2 = iArr;
        int[] iArr3 = cVar.ro;
        if (iArr3 == null || iArr3.length < i) {
            iArr3 = new int[i];
        }
        int[] iArr4 = iArr3;
        if (z) {
            int i2 = i * 6;
            yVar2.U(i2);
            a3 = a(a3, j3, yVar.hO(), i2);
            j3 += (long) i2;
            yVar2.fx(0);
            for (int i3 = 0; i3 < i; i3++) {
                iArr2[i3] = yVar.pp();
                iArr4[i3] = yVar.pD();
            }
        } else {
            iArr2[0] = 0;
            iArr4[0] = aVar3.oW - ((int) (j3 - aVar3.zr));
        }
        x.a aVar4 = (x.a) ai.R(aVar3.xZ);
        cVar.a(i, iArr2, iArr4, aVar4.uV, cVar.rk, aVar4.uU, aVar4.rq, aVar4.rr);
        int i4 = (int) (j3 - aVar3.zr);
        aVar3.zr += (long) i4;
        aVar3.oW -= i4;
        return a3;
    }

    private static a a(a aVar, long j, ByteBuffer byteBuffer, int i) {
        a a2 = a(aVar, j);
        while (i > 0) {
            int min = Math.min(i, (int) (a2.zl - j));
            byteBuffer.put(a2.MQ.tf, a2.aZ(j), min);
            i -= min;
            j += (long) min;
            if (j == a2.zl) {
                a2 = a2.MR;
            }
        }
        return a2;
    }

    private static a a(a aVar, long j, byte[] bArr, int i) {
        a a2 = a(aVar, j);
        int i2 = i;
        while (i2 > 0) {
            int min = Math.min(i2, (int) (a2.zl - j));
            System.arraycopy(a2.MQ.tf, a2.aZ(j), bArr, i - i2, min);
            i2 -= min;
            j += (long) min;
            if (j == a2.zl) {
                a2 = a2.MR;
            }
        }
        return a2;
    }

    private static a a(a aVar, long j) {
        while (j >= aVar.zl) {
            aVar = aVar.MR;
        }
        return aVar;
    }

    private static final class a {
        public final long MO;
        public boolean MP;
        public com.applovin.exoplayer2.k.a MQ;
        public a MR;
        public final long zl;

        public void a(com.applovin.exoplayer2.k.a aVar, a aVar2) {
            this.MQ = aVar;
            this.MR = aVar2;
            this.MP = true;
        }

        public a lv() {
            this.MQ = null;
            a aVar = this.MR;
            this.MR = null;
            return aVar;
        }

        public a(long j, int i) {
            this.MO = j;
            this.zl = j + ((long) i);
        }

        public int aZ(long j) {
            return ((int) (j - this.MO)) + this.MQ.oU;
        }
    }
}
