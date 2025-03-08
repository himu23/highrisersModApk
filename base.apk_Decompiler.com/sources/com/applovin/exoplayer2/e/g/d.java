package com.applovin.exoplayer2.e.g;

import com.applovin.exoplayer2.l.ai;

final class d {

    public static final class a {
        public final int[] tR;
        public final long[] tS;
        public final long zE;
        public final int zH;
        public final long[] zI;
        public final int[] zJ;

        private a(long[] jArr, int[] iArr, int i, long[] jArr2, int[] iArr2, long j) {
            this.tS = jArr;
            this.tR = iArr;
            this.zH = i;
            this.zI = jArr2;
            this.zJ = iArr2;
            this.zE = j;
        }
    }

    public static a a(int i, long[] jArr, int[] iArr, long j) {
        int[] iArr2 = iArr;
        int i2 = 8192 / i;
        int i3 = 0;
        for (int N : iArr2) {
            i3 += ai.N(N, i2);
        }
        long[] jArr2 = new long[i3];
        int[] iArr3 = new int[i3];
        long[] jArr3 = new long[i3];
        int[] iArr4 = new int[i3];
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < iArr2.length; i7++) {
            int i8 = iArr2[i7];
            long j2 = jArr[i7];
            while (i8 > 0) {
                int min = Math.min(i2, i8);
                jArr2[i5] = j2;
                int i9 = i * min;
                iArr3[i5] = i9;
                i6 = Math.max(i6, i9);
                jArr3[i5] = ((long) i4) * j;
                iArr4[i5] = 1;
                j2 += (long) iArr3[i5];
                i4 += min;
                i8 -= min;
                i5++;
            }
        }
        return new a(jArr2, iArr3, i6, jArr3, iArr4, j * ((long) i4));
    }
}
