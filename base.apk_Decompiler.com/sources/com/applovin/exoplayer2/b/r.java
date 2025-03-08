package com.applovin.exoplayer2.b;

import com.google.android.gms.games.GamesStatusCodes;

public final class r {
    /* access modifiers changed from: private */
    public static final String[] mA = {"audio/mpeg-L1", "audio/mpeg-L2", "audio/mpeg"};
    /* access modifiers changed from: private */
    public static final int[] mB = {44100, 48000, 32000};
    /* access modifiers changed from: private */
    public static final int[] mC = {32000, 64000, 96000, 128000, 160000, 192000, 224000, 256000, 288000, 320000, 352000, 384000, 416000, 448000};
    /* access modifiers changed from: private */
    public static final int[] mD = {32000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 144000, 160000, 176000, 192000, 224000, 256000};
    /* access modifiers changed from: private */
    public static final int[] mE = {32000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 160000, 192000, 224000, 256000, 320000, 384000};
    /* access modifiers changed from: private */
    public static final int[] mF = {32000, 40000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 160000, 192000, 224000, 256000, 320000};
    /* access modifiers changed from: private */
    public static final int[] mG = {GamesStatusCodes.STATUS_MILESTONE_CLAIMED_PREVIOUSLY, 16000, 24000, 32000, 40000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 144000, 160000};

    /* access modifiers changed from: private */
    public static boolean aI(int i) {
        return (i & -2097152) == -2097152;
    }

    public static final class a {
        public int dM;
        public int dv;
        public String eg;
        public int jz;
        public int mH;
        public int mI;
        public int mJ;

        public boolean aK(int i) {
            int i2;
            int i3;
            int i4;
            int i5;
            if (!r.aI(i) || (i2 = (i >>> 19) & 3) == 1 || (i3 = (i >>> 17) & 3) == 0 || (i4 = (i >>> 12) & 15) == 0 || i4 == 15 || (i5 = (i >>> 10) & 3) == 3) {
                return false;
            }
            this.mH = i2;
            this.eg = r.mA[3 - i3];
            int i6 = r.mB[i5];
            this.dM = i6;
            int i7 = 2;
            if (i2 == 2) {
                this.dM = i6 / 2;
            } else if (i2 == 0) {
                this.dM = i6 / 4;
            }
            int i8 = (i >>> 9) & 1;
            this.mJ = r.l(i2, i3);
            if (i3 == 3) {
                int i9 = i2 == 3 ? r.mC[i4 - 1] : r.mD[i4 - 1];
                this.dv = i9;
                this.jz = (((i9 * 12) / this.dM) + i8) * 4;
            } else {
                int i10 = 144;
                if (i2 == 3) {
                    int i11 = i3 == 2 ? r.mE[i4 - 1] : r.mF[i4 - 1];
                    this.dv = i11;
                    this.jz = ((i11 * 144) / this.dM) + i8;
                } else {
                    int i12 = r.mG[i4 - 1];
                    this.dv = i12;
                    if (i3 == 1) {
                        i10 = 72;
                    }
                    this.jz = ((i10 * i12) / this.dM) + i8;
                }
            }
            if (((i >> 6) & 3) == 3) {
                i7 = 1;
            }
            this.mI = i7;
            return true;
        }
    }

    public static int aG(int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        if (!aI(i) || (i2 = (i >>> 19) & 3) == 1 || (i3 = (i >>> 17) & 3) == 0 || (i4 = (i >>> 12) & 15) == 0 || i4 == 15 || (i5 = (i >>> 10) & 3) == 3) {
            return -1;
        }
        int i7 = mB[i5];
        if (i2 == 2) {
            i7 /= 2;
        } else if (i2 == 0) {
            i7 /= 4;
        }
        int i8 = (i >>> 9) & 1;
        if (i3 == 3) {
            return ((((i2 == 3 ? mC[i4 - 1] : mD[i4 - 1]) * 12) / i7) + i8) * 4;
        }
        if (i2 == 3) {
            i6 = i3 == 2 ? mE[i4 - 1] : mF[i4 - 1];
        } else {
            i6 = mG[i4 - 1];
        }
        int i9 = 144;
        if (i2 == 3) {
            return ((i6 * 144) / i7) + i8;
        }
        if (i3 == 1) {
            i9 = 72;
        }
        return ((i9 * i6) / i7) + i8;
    }

    public static int aH(int i) {
        int i2;
        int i3;
        if (!aI(i) || (i2 = (i >>> 19) & 3) == 1 || (i3 = (i >>> 17) & 3) == 0) {
            return -1;
        }
        int i4 = (i >>> 12) & 15;
        int i5 = (i >>> 10) & 3;
        if (i4 == 0 || i4 == 15 || i5 == 3) {
            return -1;
        }
        return l(i2, i3);
    }

    /* access modifiers changed from: private */
    public static int l(int i, int i2) {
        if (i2 == 1) {
            return i == 3 ? 1152 : 576;
        }
        if (i2 == 2) {
            return 1152;
        }
        if (i2 == 3) {
            return 384;
        }
        throw new IllegalArgumentException();
    }
}
