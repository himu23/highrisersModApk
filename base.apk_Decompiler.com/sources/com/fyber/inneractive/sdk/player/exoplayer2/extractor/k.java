package com.fyber.inneractive.sdk.player.exoplayer2.extractor;

public final class k {
    public static final String[] h = {"audio/mpeg-L1", "audio/mpeg-L2", "audio/mpeg"};
    public static final int[] i = {44100, 48000, 32000};
    public static final int[] j = {32, 64, 96, 128, 160, 192, 224, 256, 288, 320, 352, 384, 416, 448};
    public static final int[] k = {32, 48, 56, 64, 80, 96, 112, 128, 144, 160, 176, 192, 224, 256};
    public static final int[] l = {32, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, 320, 384};
    public static final int[] m = {32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, 320};
    public static final int[] n = {8, 16, 24, 32, 40, 48, 56, 64, 80, 96, 112, 128, 144, 160};
    public int a;
    public String b;
    public int c;
    public int d;
    public int e;
    public int f;
    public int g;

    public static int a(int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        if ((i2 & -2097152) != -2097152 || (i3 = (i2 >>> 19) & 3) == 1 || (i4 = (i2 >>> 17) & 3) == 0 || (i5 = (i2 >>> 12) & 15) == 0 || i5 == 15 || (i6 = (i2 >>> 10) & 3) == 3) {
            return -1;
        }
        int i8 = i[i6];
        if (i3 == 2) {
            i8 /= 2;
        } else if (i3 == 0) {
            i8 /= 4;
        }
        int i9 = (i2 >>> 9) & 1;
        if (i4 == 3) {
            return ((((i3 == 3 ? j[i5 - 1] : k[i5 - 1]) * 12000) / i8) + i9) * 4;
        }
        if (i3 == 3) {
            i7 = i4 == 2 ? l[i5 - 1] : m[i5 - 1];
        } else {
            i7 = n[i5 - 1];
        }
        int i10 = 144000;
        if (i3 == 3) {
            return ((i7 * 144000) / i8) + i9;
        }
        if (i4 == 1) {
            i10 = 72000;
        }
        return ((i10 * i7) / i8) + i9;
    }

    public static boolean a(int i2, k kVar) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        if ((i2 & -2097152) != -2097152 || (i3 = (i2 >>> 19) & 3) == 1 || (i4 = (i2 >>> 17) & 3) == 0 || (i5 = (i2 >>> 12) & 15) == 0 || i5 == 15 || (i6 = (i2 >>> 10) & 3) == 3) {
            return false;
        }
        int i10 = i[i6];
        int i11 = 2;
        if (i3 == 2) {
            i10 /= 2;
        } else if (i3 == 0) {
            i10 /= 4;
        }
        int i12 = (i2 >>> 9) & 1;
        if (i4 == 3) {
            i9 = i3 == 3 ? j[i5 - 1] : k[i5 - 1];
            i7 = (((i9 * 12000) / i10) + i12) * 4;
            i8 = 384;
        } else {
            int i13 = 144000;
            int i14 = 1152;
            if (i3 == 3) {
                i9 = i4 == 2 ? l[i5 - 1] : m[i5 - 1];
                i7 = ((144000 * i9) / i10) + i12;
                i8 = 1152;
            } else {
                i9 = n[i5 - 1];
                if (i4 == 1) {
                    i14 = 576;
                }
                if (i4 == 1) {
                    i13 = 72000;
                }
                i7 = ((i13 * i9) / i10) + i12;
                i8 = i14;
            }
        }
        String str = h[3 - i4];
        if (((i2 >> 6) & 3) == 3) {
            i11 = 1;
        }
        kVar.a = i3;
        kVar.b = str;
        kVar.c = i7;
        kVar.d = i10;
        kVar.e = i11;
        kVar.f = i9 * 1000;
        kVar.g = i8;
        return true;
    }
}
