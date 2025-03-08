package com.fyber.inneractive.sdk.player.exoplayer2.audio;

import com.fyber.inneractive.sdk.player.exoplayer2.util.a;
import com.google.android.gms.games.GamesStatusCodes;
import com.unity3d.ads.gatewayclient.CommonGatewayClient;
import java.util.Arrays;

public final class g {
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final short[] f;
    public int g;
    public short[] h;
    public int i;
    public short[] j;
    public int k;
    public short[] l;
    public int m = 0;
    public int n = 0;
    public float o = 1.0f;
    public float p = 1.0f;
    public int q;
    public int r;
    public int s;
    public int t;
    public int u = 0;
    public int v;
    public int w;
    public int x;

    public g(int i2, int i3) {
        this.a = i2;
        this.b = i3;
        this.c = i2 / CommonGatewayClient.CODE_400;
        int i4 = i2 / 65;
        this.d = i4;
        int i5 = i4 * 2;
        this.e = i5;
        this.f = new short[i5];
        this.g = i5;
        int i6 = i3 * i5;
        this.h = new short[i6];
        this.i = i5;
        this.j = new short[i6];
        this.k = i5;
        this.l = new short[i6];
    }

    public final void a(int i2) {
        int i3 = this.q + i2;
        int i4 = this.g;
        if (i3 > i4) {
            int i5 = i4 + (i4 / 2) + i2;
            this.g = i5;
            this.h = Arrays.copyOf(this.h, i5 * this.b);
        }
    }

    public final void b(int i2) {
        int i3 = this.r + i2;
        int i4 = this.i;
        if (i3 > i4) {
            int i5 = i4 + (i4 / 2) + i2;
            this.i = i5;
            this.j = Arrays.copyOf(this.j, i5 * this.b);
        }
    }

    public final void a(short[] sArr, int i2, int i3) {
        b(i3);
        int i4 = this.b;
        System.arraycopy(sArr, i2 * i4, this.j, this.r * i4, i4 * i3);
        this.r += i3;
    }

    public final void b(short[] sArr, int i2, int i3) {
        int i4 = this.e / i3;
        int i5 = this.b;
        int i6 = i3 * i5;
        int i7 = i2 * i5;
        for (int i8 = 0; i8 < i4; i8++) {
            int i9 = 0;
            for (int i10 = 0; i10 < i6; i10++) {
                i9 += sArr[(i8 * i6) + i7 + i10];
            }
            this.f[i8] = (short) (i9 / i6);
        }
    }

    public final int a(short[] sArr, int i2, int i3, int i4) {
        int i5 = i2 * this.b;
        int i6 = 255;
        int i7 = 1;
        int i8 = 0;
        int i9 = 0;
        while (i3 <= i4) {
            int i10 = 0;
            for (int i11 = 0; i11 < i3; i11++) {
                short s2 = sArr[i5 + i11];
                short s3 = sArr[i5 + i3 + i11];
                i10 += s2 >= s3 ? s2 - s3 : s3 - s2;
            }
            if (i10 * i8 < i7 * i3) {
                i8 = i3;
                i7 = i10;
            }
            if (i10 * i6 > i9 * i3) {
                i6 = i3;
                i9 = i10;
            }
            i3++;
        }
        this.w = i7 / i8;
        this.x = i9 / i6;
        return i8;
    }

    public final void a() {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10 = this.r;
        float f2 = this.o / this.p;
        double d2 = (double) f2;
        int i11 = 1;
        if (d2 > 1.00001d || d2 < 0.99999d) {
            int i12 = this.q;
            if (i12 >= this.e) {
                int i13 = 0;
                while (true) {
                    int i14 = this.t;
                    if (i14 > 0) {
                        int min = Math.min(this.e, i14);
                        a(this.h, i13, min);
                        this.t -= min;
                        i13 += min;
                    } else {
                        short[] sArr = this.h;
                        int i15 = this.a;
                        int i16 = i15 > 4000 ? i15 / GamesStatusCodes.STATUS_SNAPSHOT_NOT_FOUND : 1;
                        if (this.b == i11 && i16 == i11) {
                            i6 = a(sArr, i13, this.c, this.d);
                        } else {
                            b(sArr, i13, i16);
                            int a2 = a(this.f, 0, this.c / i16, this.d / i16);
                            if (i16 != i11) {
                                int i17 = a2 * i16;
                                int i18 = i16 * 4;
                                int i19 = i17 - i18;
                                int i20 = i17 + i18;
                                int i21 = this.c;
                                if (i19 < i21) {
                                    i19 = i21;
                                }
                                int i22 = this.d;
                                if (i20 > i22) {
                                    i20 = i22;
                                }
                                if (this.b == i11) {
                                    i6 = a(sArr, i13, i19, i20);
                                } else {
                                    b(sArr, i13, i11);
                                    i6 = a(this.f, 0, i19, i20);
                                }
                            } else {
                                i6 = a2;
                            }
                        }
                        int i23 = this.w;
                        int i24 = (i23 == 0 || (i9 = this.u) == 0 || this.x > i23 * 3 || i23 * 2 <= this.v * 3) ? i6 : i9;
                        this.v = i23;
                        this.u = i6;
                        if (d2 > 1.0d) {
                            short[] sArr2 = this.h;
                            if (f2 >= 2.0f) {
                                i8 = (int) (((float) i24) / (f2 - 1.0f));
                            } else {
                                this.t = (int) ((((float) i24) * (2.0f - f2)) / (f2 - 1.0f));
                                i8 = i24;
                            }
                            b(i8);
                            int i25 = i8;
                            a(i8, this.b, this.j, this.r, sArr2, i13, sArr2, i13 + i24);
                            this.r += i25;
                            i13 += i24 + i25;
                        } else {
                            int i26 = i24;
                            short[] sArr3 = this.h;
                            if (f2 < 0.5f) {
                                i7 = (int) ((((float) i26) * f2) / (1.0f - f2));
                            } else {
                                this.t = (int) ((((float) i26) * ((2.0f * f2) - 1.0f)) / (1.0f - f2));
                                i7 = i26;
                            }
                            int i27 = i26 + i7;
                            b(i27);
                            int i28 = this.b;
                            System.arraycopy(sArr3, i13 * i28, this.j, this.r * i28, i28 * i26);
                            a(i7, this.b, this.j, this.r + i26, sArr3, i26 + i13, sArr3, i13);
                            this.r += i27;
                            i13 += i7;
                        }
                    }
                    if (this.e + i13 > i12) {
                        break;
                    }
                    i11 = 1;
                }
                int i29 = this.q - i13;
                short[] sArr4 = this.h;
                int i30 = this.b;
                System.arraycopy(sArr4, i13 * i30, sArr4, 0, i30 * i29);
                this.q = i29;
            }
        } else {
            a(this.h, 0, this.q);
            this.q = 0;
        }
        float f3 = this.p;
        if (f3 != 1.0f && this.r != i10) {
            int i31 = this.a;
            int i32 = (int) (((float) i31) / f3);
            while (true) {
                if (i32 <= 16384 && i31 <= 16384) {
                    break;
                }
                i32 /= 2;
                i31 /= 2;
            }
            int i33 = this.r - i10;
            int i34 = this.s + i33;
            int i35 = this.k;
            if (i34 > i35) {
                int i36 = i35 + (i35 / 2) + i33;
                this.k = i36;
                this.l = Arrays.copyOf(this.l, i36 * this.b);
            }
            short[] sArr5 = this.j;
            int i37 = this.b;
            System.arraycopy(sArr5, i10 * i37, this.l, this.s * i37, i37 * i33);
            this.r = i10;
            this.s += i33;
            int i38 = 0;
            while (true) {
                i2 = this.s;
                i3 = i2 - 1;
                if (i38 >= i3) {
                    break;
                }
                while (true) {
                    i4 = this.m + 1;
                    int i39 = i4 * i32;
                    i5 = this.n;
                    if (i39 <= i5 * i31) {
                        break;
                    }
                    b(1);
                    int i40 = 0;
                    while (true) {
                        int i41 = this.b;
                        if (i40 >= i41) {
                            break;
                        }
                        short[] sArr6 = this.l;
                        int i42 = (i38 * i41) + i40;
                        short s2 = sArr6[i42];
                        short s3 = sArr6[i42 + i41];
                        int i43 = this.m;
                        int i44 = i43 * i32;
                        int i45 = (i43 + 1) * i32;
                        int i46 = i45 - (this.n * i31);
                        int i47 = i45 - i44;
                        this.j[(this.r * i41) + i40] = (short) (((s2 * i46) + ((i47 - i46) * s3)) / i47);
                        i40++;
                    }
                    this.n++;
                    this.r++;
                }
                this.m = i4;
                if (i4 == i31) {
                    this.m = 0;
                    a.b(i5 == i32);
                    this.n = 0;
                }
                i38++;
            }
            if (i3 != 0) {
                short[] sArr7 = this.l;
                int i48 = this.b;
                System.arraycopy(sArr7, i3 * i48, sArr7, 0, (i2 - i3) * i48);
                this.s -= i3;
            }
        }
    }

    public static void a(int i2, int i3, short[] sArr, int i4, short[] sArr2, int i5, short[] sArr3, int i6) {
        for (int i7 = 0; i7 < i3; i7++) {
            int i8 = (i4 * i3) + i7;
            int i9 = (i6 * i3) + i7;
            int i10 = (i5 * i3) + i7;
            for (int i11 = 0; i11 < i2; i11++) {
                sArr[i8] = (short) (((sArr2[i10] * (i2 - i11)) + (sArr3[i9] * i11)) / i2);
                i8 += i3;
                i10 += i3;
                i9 += i3;
            }
        }
    }
}
