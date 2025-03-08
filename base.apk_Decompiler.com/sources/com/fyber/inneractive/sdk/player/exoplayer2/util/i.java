package com.fyber.inneractive.sdk.player.exoplayer2.util;

import java.util.Arrays;

public final class i {
    public static final byte[] a = {0, 0, 0, 1};
    public static final float[] b = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 2.1818182f, 1.8181819f, 2.909091f, 2.4242425f, 1.6363636f, 1.3636364f, 1.939394f, 1.6161616f, 1.3333334f, 1.5f, 2.0f};
    public static final Object c = new Object();
    public static int[] d = new int[10];

    public static final class a {
        public final int a;
        public final int b;
        public final boolean c;

        public a(int i, int i2, boolean z) {
            this.a = i;
            this.b = i2;
            this.c = z;
        }
    }

    public static final class b {
        public final int a;
        public final int b;
        public final int c;
        public final float d;
        public final boolean e;
        public final boolean f;
        public final int g;
        public final int h;
        public final int i;
        public final boolean j;

        public b(int i2, int i3, int i4, float f2, boolean z, boolean z2, int i5, int i6, int i7, boolean z3) {
            this.a = i2;
            this.b = i3;
            this.c = i4;
            this.d = f2;
            this.e = z;
            this.f = z2;
            this.g = i5;
            this.h = i6;
            this.i = i7;
            this.j = z3;
        }
    }

    public static int a(byte[] bArr, int i) {
        int i2;
        synchronized (c) {
            int i3 = 0;
            int i4 = 0;
            while (i3 < i) {
                while (true) {
                    if (i3 >= i - 2) {
                        i3 = i;
                        break;
                    }
                    try {
                        if (bArr[i3] == 0 && bArr[i3 + 1] == 0 && bArr[i3 + 2] == 3) {
                            break;
                        }
                        i3++;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (i3 < i) {
                    int[] iArr = d;
                    if (iArr.length <= i4) {
                        d = Arrays.copyOf(iArr, iArr.length * 2);
                    }
                    d[i4] = i3;
                    i3 += 3;
                    i4++;
                }
            }
            i2 = i - i4;
            int i5 = 0;
            int i6 = 0;
            for (int i7 = 0; i7 < i4; i7++) {
                int i8 = d[i7] - i6;
                System.arraycopy(bArr, i6, bArr, i5, i8);
                int i9 = i5 + i8;
                int i10 = i9 + 1;
                bArr[i9] = 0;
                i5 = i9 + 2;
                bArr[i10] = 0;
                i6 += i8 + 3;
            }
            System.arraycopy(bArr, i6, bArr, i5, i2 - i5);
        }
        return i2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:60:0x00f1  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x0101  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0142  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0153  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.fyber.inneractive.sdk.player.exoplayer2.util.i.b b(byte[] r20, int r21, int r22) {
        /*
            com.fyber.inneractive.sdk.player.exoplayer2.util.l r0 = new com.fyber.inneractive.sdk.player.exoplayer2.util.l
            r1 = r20
            r2 = r21
            r3 = r22
            r0.<init>(r1, r2, r3)
            r1 = 8
            r0.d(r1)
            int r2 = r0.b(r1)
            r3 = 16
            r0.d(r3)
            int r5 = r0.d()
            r4 = 100
            r6 = 3
            r7 = 1
            if (r2 == r4) goto L_0x004b
            r4 = 110(0x6e, float:1.54E-43)
            if (r2 == r4) goto L_0x004b
            r4 = 122(0x7a, float:1.71E-43)
            if (r2 == r4) goto L_0x004b
            r4 = 244(0xf4, float:3.42E-43)
            if (r2 == r4) goto L_0x004b
            r4 = 44
            if (r2 == r4) goto L_0x004b
            r4 = 83
            if (r2 == r4) goto L_0x004b
            r4 = 86
            if (r2 == r4) goto L_0x004b
            r4 = 118(0x76, float:1.65E-43)
            if (r2 == r4) goto L_0x004b
            r4 = 128(0x80, float:1.794E-43)
            if (r2 == r4) goto L_0x004b
            r4 = 138(0x8a, float:1.93E-43)
            if (r2 != r4) goto L_0x0048
            goto L_0x004b
        L_0x0048:
            r2 = 1
            r9 = 0
            goto L_0x009b
        L_0x004b:
            int r2 = r0.d()
            if (r2 != r6) goto L_0x0056
            boolean r4 = r0.c()
            goto L_0x0057
        L_0x0056:
            r4 = 0
        L_0x0057:
            r0.d()
            r0.d()
            r0.f()
            boolean r9 = r0.c()
            if (r9 == 0) goto L_0x009a
            if (r2 == r6) goto L_0x006b
            r9 = 8
            goto L_0x006d
        L_0x006b:
            r9 = 12
        L_0x006d:
            r10 = 0
        L_0x006e:
            if (r10 >= r9) goto L_0x009a
            boolean r11 = r0.c()
            if (r11 == 0) goto L_0x0097
            r11 = 6
            if (r10 >= r11) goto L_0x007c
            r11 = 16
            goto L_0x007e
        L_0x007c:
            r11 = 64
        L_0x007e:
            r12 = 0
            r13 = 8
            r14 = 8
        L_0x0083:
            if (r12 >= r11) goto L_0x0097
            if (r13 == 0) goto L_0x0090
            int r13 = r0.e()
            int r13 = r13 + r14
            int r13 = r13 + 256
            int r13 = r13 % 256
        L_0x0090:
            if (r13 != 0) goto L_0x0093
            goto L_0x0094
        L_0x0093:
            r14 = r13
        L_0x0094:
            int r12 = r12 + 1
            goto L_0x0083
        L_0x0097:
            int r10 = r10 + 1
            goto L_0x006e
        L_0x009a:
            r9 = r4
        L_0x009b:
            int r4 = r0.d()
            int r11 = r4 + 4
            int r12 = r0.d()
            if (r12 != 0) goto L_0x00b1
            int r4 = r0.d()
            int r4 = r4 + 4
            r13 = r4
            r21 = r9
            goto L_0x00d6
        L_0x00b1:
            if (r12 != r7) goto L_0x00d3
            boolean r4 = r0.c()
            r0.e()
            r0.e()
            int r10 = r0.d()
            long r13 = (long) r10
            r21 = r9
            r10 = 0
        L_0x00c5:
            long r8 = (long) r10
            int r15 = (r8 > r13 ? 1 : (r8 == r13 ? 0 : -1))
            if (r15 >= 0) goto L_0x00d0
            r0.d()
            int r10 = r10 + 1
            goto L_0x00c5
        L_0x00d0:
            r14 = r4
            r13 = 0
            goto L_0x00d7
        L_0x00d3:
            r21 = r9
            r13 = 0
        L_0x00d6:
            r14 = 0
        L_0x00d7:
            r0.d()
            r0.f()
            int r4 = r0.d()
            int r4 = r4 + r7
            int r8 = r0.d()
            int r8 = r8 + r7
            boolean r10 = r0.c()
            int r9 = 2 - r10
            int r8 = r8 * r9
            if (r10 != 0) goto L_0x00f4
            r0.f()
        L_0x00f4:
            r0.f()
            int r4 = r4 * 16
            int r8 = r8 * 16
            boolean r15 = r0.c()
            if (r15 == 0) goto L_0x012c
            int r15 = r0.d()
            int r16 = r0.d()
            int r17 = r0.d()
            int r18 = r0.d()
            if (r2 != 0) goto L_0x0114
            goto L_0x0121
        L_0x0114:
            r19 = 2
            if (r2 != r6) goto L_0x011a
            r6 = 1
            goto L_0x011b
        L_0x011a:
            r6 = 2
        L_0x011b:
            if (r2 != r7) goto L_0x011e
            r7 = 2
        L_0x011e:
            int r9 = r9 * r7
            r7 = r6
        L_0x0121:
            int r15 = r15 + r16
            int r15 = r15 * r7
            int r4 = r4 - r15
            int r17 = r17 + r18
            int r17 = r17 * r9
            int r8 = r8 - r17
        L_0x012c:
            r6 = r4
            r7 = r8
            boolean r2 = r0.c()
            if (r2 == 0) goto L_0x016f
            boolean r2 = r0.c()
            if (r2 == 0) goto L_0x016f
            int r1 = r0.b(r1)
            r2 = 255(0xff, float:3.57E-43)
            if (r1 != r2) goto L_0x0153
            int r1 = r0.b(r3)
            int r0 = r0.b(r3)
            if (r1 == 0) goto L_0x016f
            if (r0 == 0) goto L_0x016f
            float r1 = (float) r1
            float r0 = (float) r0
            float r1 = r1 / r0
            r8 = r1
            goto L_0x0173
        L_0x0153:
            float[] r0 = b
            int r2 = r0.length
            if (r1 >= r2) goto L_0x015c
            r0 = r0[r1]
            r8 = r0
            goto L_0x0173
        L_0x015c:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "Unexpected aspect_ratio_idc value: "
            r0.<init>(r2)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "NalUnitUtil"
            android.util.Log.w(r1, r0)
        L_0x016f:
            r0 = 1065353216(0x3f800000, float:1.0)
            r8 = 1065353216(0x3f800000, float:1.0)
        L_0x0173:
            com.fyber.inneractive.sdk.player.exoplayer2.util.i$b r0 = new com.fyber.inneractive.sdk.player.exoplayer2.util.i$b
            r4 = r0
            r9 = r21
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.exoplayer2.util.i.b(byte[], int, int):com.fyber.inneractive.sdk.player.exoplayer2.util.i$b");
    }

    public static a a(byte[] bArr, int i, int i2) {
        l lVar = new l(bArr, i, i2);
        lVar.d(8);
        int d2 = lVar.d();
        int d3 = lVar.d();
        lVar.f();
        return new a(d2, d3, lVar.c());
    }

    /* JADX WARNING: Removed duplicated region for block: B:74:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00b6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int a(byte[] r8, int r9, int r10, boolean[] r11) {
        /*
            int r0 = r10 - r9
            r1 = 0
            r2 = 1
            if (r0 < 0) goto L_0x0008
            r3 = 1
            goto L_0x0009
        L_0x0008:
            r3 = 0
        L_0x0009:
            com.fyber.inneractive.sdk.player.exoplayer2.util.a.b(r3)
            if (r0 != 0) goto L_0x000f
            return r10
        L_0x000f:
            r3 = 2
            if (r11 == 0) goto L_0x0040
            boolean r4 = r11[r1]
            if (r4 == 0) goto L_0x001c
            a(r11)
            int r9 = r9 + -3
            return r9
        L_0x001c:
            if (r0 <= r2) goto L_0x002b
            boolean r4 = r11[r2]
            if (r4 == 0) goto L_0x002b
            byte r4 = r8[r9]
            if (r4 != r2) goto L_0x002b
            a(r11)
            int r9 = r9 - r3
            return r9
        L_0x002b:
            if (r0 <= r3) goto L_0x0040
            boolean r4 = r11[r3]
            if (r4 == 0) goto L_0x0040
            byte r4 = r8[r9]
            if (r4 != 0) goto L_0x0040
            int r4 = r9 + 1
            byte r4 = r8[r4]
            if (r4 != r2) goto L_0x0040
            a(r11)
            int r9 = r9 - r2
            return r9
        L_0x0040:
            int r4 = r10 + -1
            int r9 = r9 + r3
        L_0x0043:
            if (r9 >= r4) goto L_0x0065
            byte r5 = r8[r9]
            r6 = r5 & 254(0xfe, float:3.56E-43)
            if (r6 == 0) goto L_0x004c
            goto L_0x0062
        L_0x004c:
            int r6 = r9 + -2
            byte r7 = r8[r6]
            if (r7 != 0) goto L_0x0060
            int r7 = r9 + -1
            byte r7 = r8[r7]
            if (r7 != 0) goto L_0x0060
            if (r5 != r2) goto L_0x0060
            if (r11 == 0) goto L_0x005f
            a(r11)
        L_0x005f:
            return r6
        L_0x0060:
            int r9 = r9 + -2
        L_0x0062:
            int r9 = r9 + 3
            goto L_0x0043
        L_0x0065:
            if (r11 == 0) goto L_0x00b9
            if (r0 <= r3) goto L_0x007a
            int r9 = r10 + -3
            byte r9 = r8[r9]
            if (r9 != 0) goto L_0x0095
            int r9 = r10 + -2
            byte r9 = r8[r9]
            if (r9 != 0) goto L_0x0095
            byte r9 = r8[r4]
            if (r9 != r2) goto L_0x0095
            goto L_0x0093
        L_0x007a:
            if (r0 != r3) goto L_0x008b
            boolean r9 = r11[r3]
            if (r9 == 0) goto L_0x0095
            int r9 = r10 + -2
            byte r9 = r8[r9]
            if (r9 != 0) goto L_0x0095
            byte r9 = r8[r4]
            if (r9 != r2) goto L_0x0095
            goto L_0x0093
        L_0x008b:
            boolean r9 = r11[r2]
            if (r9 == 0) goto L_0x0095
            byte r9 = r8[r4]
            if (r9 != r2) goto L_0x0095
        L_0x0093:
            r9 = 1
            goto L_0x0096
        L_0x0095:
            r9 = 0
        L_0x0096:
            r11[r1] = r9
            if (r0 <= r2) goto L_0x00a5
            int r9 = r10 + -2
            byte r9 = r8[r9]
            if (r9 != 0) goto L_0x00af
            byte r9 = r8[r4]
            if (r9 != 0) goto L_0x00af
            goto L_0x00ad
        L_0x00a5:
            boolean r9 = r11[r3]
            if (r9 == 0) goto L_0x00af
            byte r9 = r8[r4]
            if (r9 != 0) goto L_0x00af
        L_0x00ad:
            r9 = 1
            goto L_0x00b0
        L_0x00af:
            r9 = 0
        L_0x00b0:
            r11[r2] = r9
            byte r8 = r8[r4]
            if (r8 != 0) goto L_0x00b7
            r1 = 1
        L_0x00b7:
            r11[r3] = r1
        L_0x00b9:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.exoplayer2.util.i.a(byte[], int, int, boolean[]):int");
    }

    public static void a(boolean[] zArr) {
        zArr[0] = false;
        zArr[1] = false;
        zArr[2] = false;
    }
}
