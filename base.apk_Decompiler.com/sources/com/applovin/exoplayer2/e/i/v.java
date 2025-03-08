package com.applovin.exoplayer2.e.i;

import com.applovin.exoplayer2.common.base.Ascii;
import com.applovin.exoplayer2.e.i;
import com.applovin.exoplayer2.e.u;
import com.applovin.exoplayer2.l.ag;
import com.applovin.exoplayer2.l.ai;
import com.applovin.exoplayer2.l.q;
import com.applovin.exoplayer2.l.y;
import java.io.IOException;
import kotlin.UByte;

final class v {
    private final y CB = new y();
    private final ag EU = new ag(0);
    private boolean EV;
    private boolean EW;
    private boolean EX;
    private long EY = -9223372036854775807L;
    private long EZ = -9223372036854775807L;
    private long fH = -9223372036854775807L;

    public long dd() {
        return this.fH;
    }

    public boolean jt() {
        return this.EV;
    }

    public ag ju() {
        return this.EU;
    }

    v() {
    }

    public int j(i iVar, u uVar) throws IOException {
        if (!this.EX) {
            return l(iVar, uVar);
        }
        if (this.EZ == -9223372036854775807L) {
            return Y(iVar);
        }
        if (!this.EW) {
            return k(iVar, uVar);
        }
        long j = this.EY;
        if (j == -9223372036854775807L) {
            return Y(iVar);
        }
        long br = this.EU.br(this.EZ) - this.EU.br(j);
        this.fH = br;
        if (br < 0) {
            q.h("PsDurationReader", "Invalid duration: " + this.fH + ". Using TIME_UNSET instead.");
            this.fH = -9223372036854775807L;
        }
        return Y(iVar);
    }

    public static long T(y yVar) {
        int il = yVar.il();
        if (yVar.pj() < 9) {
            return -9223372036854775807L;
        }
        byte[] bArr = new byte[9];
        yVar.r(bArr, 0, 9);
        yVar.fx(il);
        if (!C(bArr)) {
            return -9223372036854775807L;
        }
        return D(bArr);
    }

    private int Y(i iVar) {
        this.CB.I(ai.ada);
        this.EV = true;
        iVar.ic();
        return 0;
    }

    private int k(i iVar, u uVar) throws IOException {
        int min = (int) Math.min(20000, iVar.m1771if());
        long j = (long) 0;
        if (iVar.ie() != j) {
            uVar.uc = j;
            return 1;
        }
        this.CB.U(min);
        iVar.ic();
        iVar.c(this.CB.hO(), 0, min);
        this.EY = U(this.CB);
        this.EW = true;
        return 0;
    }

    private long U(y yVar) {
        int pk = yVar.pk();
        for (int il = yVar.il(); il < pk - 3; il++) {
            if (d(yVar.hO(), il) == 442) {
                yVar.fx(il + 4);
                long T = T(yVar);
                if (T != -9223372036854775807L) {
                    return T;
                }
            }
        }
        return -9223372036854775807L;
    }

    private int l(i iVar, u uVar) throws IOException {
        long j = iVar.m1771if();
        int min = (int) Math.min(20000, j);
        long j2 = j - ((long) min);
        if (iVar.ie() != j2) {
            uVar.uc = j2;
            return 1;
        }
        this.CB.U(min);
        iVar.ic();
        iVar.c(this.CB.hO(), 0, min);
        this.EZ = V(this.CB);
        this.EX = true;
        return 0;
    }

    private long V(y yVar) {
        int il = yVar.il();
        for (int pk = yVar.pk() - 4; pk >= il; pk--) {
            if (d(yVar.hO(), pk) == 442) {
                yVar.fx(pk + 4);
                long T = T(yVar);
                if (T != -9223372036854775807L) {
                    return T;
                }
            }
        }
        return -9223372036854775807L;
    }

    private int d(byte[] bArr, int i) {
        return (bArr[i + 3] & UByte.MAX_VALUE) | ((bArr[i] & UByte.MAX_VALUE) << Ascii.CAN) | ((bArr[i + 1] & UByte.MAX_VALUE) << Ascii.DLE) | ((bArr[i + 2] & UByte.MAX_VALUE) << 8);
    }

    private static boolean C(byte[] bArr) {
        if ((bArr[0] & 196) == 68 && (bArr[2] & 4) == 4 && (bArr[4] & 4) == 4 && (bArr[5] & 1) == 1 && (bArr[8] & 3) == 3) {
            return true;
        }
        return false;
    }

    private static long D(byte[] bArr) {
        byte b = bArr[0];
        byte b2 = bArr[2];
        return (((((long) b) & 56) >> 3) << 30) | ((((long) b) & 3) << 28) | ((((long) bArr[1]) & 255) << 20) | (((((long) b2) & 248) >> 3) << 15) | ((((long) b2) & 3) << 13) | ((((long) bArr[3]) & 255) << 5) | ((((long) bArr[4]) & 248) >> 3);
    }
}
