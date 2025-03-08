package com.applovin.exoplayer2.m.a;

final class e {
    public final a afx;
    public final a afy;
    public final boolean afz;
    public final int dJ;

    public static e fT(int i) {
        return a(50.0f, 36, 72, 180.0f, 360.0f, i);
    }

    public static e a(float f, int i, int i2, float f2, float f3, int i3) {
        int i4;
        float f4;
        float[] fArr;
        int i5;
        int i6;
        int i7;
        float f5 = f;
        int i8 = i;
        int i9 = i2;
        float f6 = f2;
        float f7 = f3;
        com.applovin.exoplayer2.l.a.checkArgument(f5 > 0.0f);
        com.applovin.exoplayer2.l.a.checkArgument(i8 >= 1);
        com.applovin.exoplayer2.l.a.checkArgument(i9 >= 1);
        com.applovin.exoplayer2.l.a.checkArgument(f6 > 0.0f && f6 <= 180.0f);
        com.applovin.exoplayer2.l.a.checkArgument(f7 > 0.0f && f7 <= 360.0f);
        float radians = (float) Math.toRadians((double) f6);
        float radians2 = (float) Math.toRadians((double) f7);
        float f8 = radians / ((float) i8);
        float f9 = radians2 / ((float) i9);
        int i10 = i9 + 1;
        int i11 = ((i10 * 2) + 2) * i8;
        float[] fArr2 = new float[(i11 * 3)];
        float[] fArr3 = new float[(i11 * 2)];
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        while (i12 < i8) {
            float f10 = radians / 2.0f;
            float f11 = (((float) i12) * f8) - f10;
            int i15 = i12 + 1;
            float f12 = (((float) i15) * f8) - f10;
            int i16 = 0;
            while (i16 < i10) {
                float f13 = f11;
                int i17 = i15;
                int i18 = 0;
                while (i18 < 2) {
                    if (i18 == 0) {
                        f4 = f13;
                        i4 = i10;
                    } else {
                        i4 = i10;
                        f4 = f12;
                    }
                    float f14 = ((float) i16) * f9;
                    float f15 = f9;
                    int i19 = i16;
                    double d = (double) f5;
                    float f16 = f8;
                    double d2 = (double) ((f14 + 3.1415927f) - (radians2 / 2.0f));
                    int i20 = i18;
                    double d3 = (double) f4;
                    float[] fArr4 = fArr3;
                    float f17 = f12;
                    fArr2[i13] = -((float) (Math.sin(d2) * d * Math.cos(d3)));
                    float f18 = radians;
                    float f19 = radians2;
                    fArr2[i13 + 1] = (float) (d * Math.sin(d3));
                    int i21 = i13 + 3;
                    fArr2[i13 + 2] = (float) (d * Math.cos(d2) * Math.cos(d3));
                    fArr4[i14] = f14 / f19;
                    int i22 = i14 + 2;
                    fArr4[i14 + 1] = (((float) (i12 + i20)) * f16) / f18;
                    if (i19 == 0 && i20 == 0) {
                        i7 = i2;
                        i6 = i19;
                        i5 = i20;
                    } else {
                        i7 = i2;
                        i6 = i19;
                        i5 = i20;
                        if (!(i6 == i7 && i5 == 1)) {
                            fArr = fArr4;
                            i14 = i22;
                            i13 = i21;
                            i18 = i5 + 1;
                            i9 = i7;
                            i16 = i6;
                            fArr3 = fArr;
                            radians = f18;
                            i10 = i4;
                            f9 = f15;
                            f8 = f16;
                            radians2 = f19;
                            f12 = f17;
                        }
                    }
                    System.arraycopy(fArr2, i13, fArr2, i21, 3);
                    i13 += 6;
                    fArr = fArr4;
                    System.arraycopy(fArr, i14, fArr, i22, 2);
                    i14 += 4;
                    i18 = i5 + 1;
                    i9 = i7;
                    i16 = i6;
                    fArr3 = fArr;
                    radians = f18;
                    i10 = i4;
                    f9 = f15;
                    f8 = f16;
                    radians2 = f19;
                    f12 = f17;
                }
                float f20 = radians2;
                float f21 = f9;
                int i23 = i10;
                float[] fArr5 = fArr3;
                float f22 = f12;
                int i24 = i16;
                int i25 = i9;
                float f23 = radians;
                int i26 = i24 + 1;
                f11 = f13;
                i15 = i17;
                f8 = f8;
                radians2 = f20;
                f12 = f22;
                int i27 = i26;
                i9 = i25;
                i16 = i27;
            }
            i8 = i;
            i12 = i15;
        }
        return new e(new a(new b(0, fArr2, fArr3, 1)), i3);
    }

    public e(a aVar, int i) {
        this(aVar, aVar, i);
    }

    public e(a aVar, a aVar2, int i) {
        this.afx = aVar;
        this.afy = aVar2;
        this.dJ = i;
        this.afz = aVar == aVar2;
    }

    public static final class b {
        public final int afB;
        public final float[] afC;
        public final float[] afD;
        public final int rm;

        public b(int i, float[] fArr, float[] fArr2, int i2) {
            this.afB = i;
            com.applovin.exoplayer2.l.a.checkArgument(((long) fArr.length) * 2 == ((long) fArr2.length) * 3);
            this.afC = fArr;
            this.afD = fArr2;
            this.rm = i2;
        }
    }

    public static final class a {
        private final b[] afA;

        public a(b... bVarArr) {
            this.afA = bVarArr;
        }

        public int qK() {
            return this.afA.length;
        }

        public b fU(int i) {
            return this.afA[i];
        }
    }
}
