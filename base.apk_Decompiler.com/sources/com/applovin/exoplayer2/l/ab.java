package com.applovin.exoplayer2.l;

public final class ab {
    public static boolean M(int i, int i2) {
        if (i != 0) {
            return i != 1 ? i == 2 && (i2 & 2) != 0 : (i2 & 1) != 0;
        }
        return true;
    }

    public static int L(int i, int i2) {
        for (int i3 = 1; i3 <= 2; i3++) {
            int i4 = (i + i3) % 3;
            if (M(i4, i2)) {
                return i4;
            }
        }
        return i;
    }
}
