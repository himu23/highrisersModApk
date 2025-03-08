package com.applovin.exoplayer2.e;

import com.applovin.exoplayer2.ai;
import com.applovin.exoplayer2.l.y;
import java.io.IOException;
import kotlin.UByte;

public final class m {

    public static final class a {
        public long uy;
    }

    public static boolean a(y yVar, p pVar, int i, a aVar) {
        y yVar2 = yVar;
        p pVar2 = pVar;
        int il = yVar.il();
        long pv = yVar.pv();
        long j = pv >>> 16;
        if (j != ((long) i)) {
            return false;
        }
        boolean z = (j & 1) == 1;
        int i2 = (int) ((pv >> 12) & 15);
        int i3 = (int) ((pv >> 8) & 15);
        int i4 = (int) (15 & (pv >> 4));
        int i5 = (int) ((pv >> 1) & 7);
        boolean z2 = (pv & 1) == 1;
        if (!a(i4, pVar2) || !b(i5, pVar2) || z2 || !a(yVar2, pVar2, z, aVar) || !a(yVar2, pVar2, i2) || !b(yVar2, pVar2, i3) || !b(yVar2, il)) {
            return false;
        }
        return true;
    }

    public static boolean a(i iVar, p pVar, int i, a aVar) throws IOException {
        long id = iVar.id();
        byte[] bArr = new byte[2];
        iVar.c(bArr, 0, 2);
        if ((((bArr[0] & UByte.MAX_VALUE) << 8) | (bArr[1] & UByte.MAX_VALUE)) != i) {
            iVar.ic();
            iVar.bI((int) (id - iVar.ie()));
            return false;
        }
        y yVar = new y(16);
        System.arraycopy(bArr, 0, yVar.hO(), 0, 2);
        yVar.fA(k.a(iVar, yVar.hO(), 2, 14));
        iVar.ic();
        iVar.bI((int) (id - iVar.ie()));
        return a(yVar, pVar, i, aVar);
    }

    public static long a(i iVar, p pVar) throws IOException {
        iVar.ic();
        boolean z = true;
        iVar.bI(1);
        byte[] bArr = new byte[1];
        iVar.c(bArr, 0, 1);
        if ((bArr[0] & 1) != 1) {
            z = false;
        }
        iVar.bI(2);
        int i = z ? 7 : 6;
        y yVar = new y(i);
        yVar.fA(k.a(iVar, yVar.hO(), 0, i));
        iVar.ic();
        a aVar = new a();
        if (a(yVar, pVar, z, aVar)) {
            return aVar.uy;
        }
        throw ai.c((String) null, (Throwable) null);
    }

    public static int a(y yVar, int i) {
        switch (i) {
            case 1:
                return 192;
            case 2:
            case 3:
            case 4:
            case 5:
                return 576 << (i - 2);
            case 6:
                return yVar.po() + 1;
            case 7:
                return yVar.pp() + 1;
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                return 256 << (i - 8);
            default:
                return -1;
        }
    }

    private static boolean a(int i, p pVar) {
        if (i <= 7) {
            return i == pVar.mI - 1;
        }
        if (i > 10 || pVar.mI != 2) {
            return false;
        }
        return true;
    }

    private static boolean b(int i, p pVar) {
        return i == 0 || i == pVar.uH;
    }

    private static boolean a(y yVar, p pVar, boolean z, a aVar) {
        try {
            long pK = yVar.pK();
            if (!z) {
                pK *= (long) pVar.uC;
            }
            aVar.uy = pK;
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    private static boolean a(y yVar, p pVar, int i) {
        int a2 = a(yVar, i);
        return a2 != -1 && a2 <= pVar.uC;
    }

    private static boolean b(y yVar, p pVar, int i) {
        int i2 = pVar.dM;
        if (i == 0) {
            return true;
        }
        if (i <= 11) {
            if (i == pVar.uF) {
                return true;
            }
            return false;
        } else if (i == 12) {
            if (yVar.po() * 1000 == i2) {
                return true;
            }
            return false;
        } else if (i > 14) {
            return false;
        } else {
            int pp = yVar.pp();
            if (i == 14) {
                pp *= 10;
            }
            if (pp == i2) {
                return true;
            }
            return false;
        }
    }

    private static boolean b(y yVar, int i) {
        return yVar.po() == com.applovin.exoplayer2.l.ai.c(yVar.hO(), i, yVar.il() - 1, 0);
    }
}
