package com.applovin.exoplayer2.e.i;

import com.applovin.exoplayer2.l.y;

public final class ae {
    public static boolean a(byte[] bArr, int i, int i2, int i3) {
        int i4 = 0;
        for (int i5 = -4; i5 <= 4; i5++) {
            int i6 = (i5 * 188) + i3;
            if (i6 < i || i6 >= i2 || bArr[i6] != 71) {
                i4 = 0;
            } else {
                i4++;
                if (i4 == 5) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int i(byte[] bArr, int i, int i2) {
        while (i < i2 && bArr[i] != 71) {
            i++;
        }
        return i;
    }

    public static long f(y yVar, int i, int i2) {
        yVar.fx(i);
        if (yVar.pj() < 5) {
            return -9223372036854775807L;
        }
        int px = yVar.px();
        if ((8388608 & px) != 0 || ((2096896 & px) >> 8) != i2 || (px & 32) == 0 || yVar.po() < 7 || yVar.pj() < 7 || (yVar.po() & 16) != 16) {
            return -9223372036854775807L;
        }
        byte[] bArr = new byte[6];
        yVar.r(bArr, 0, 6);
        return E(bArr);
    }

    private static long E(byte[] bArr) {
        return ((((long) bArr[0]) & 255) << 25) | ((((long) bArr[1]) & 255) << 17) | ((((long) bArr[2]) & 255) << 9) | ((((long) bArr[3]) & 255) << 1) | ((255 & ((long) bArr[4])) >> 7);
    }
}
