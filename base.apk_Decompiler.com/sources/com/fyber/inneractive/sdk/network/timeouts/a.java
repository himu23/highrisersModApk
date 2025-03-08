package com.fyber.inneractive.sdk.network.timeouts;

import com.fyber.inneractive.sdk.util.IAlog;

public abstract class a {
    public int a = 0;
    public int b = 0;
    public int c = 0;
    public int d = 0;
    public int e = 0;
    public int f = 0;
    public boolean g = false;

    public void a(boolean z) {
        this.g = z;
    }

    public int a() {
        int i;
        int i2 = this.c;
        int i3 = this.d;
        if (i3 <= 0) {
            IAlog.e("%s Unable resolve retries because of invalid ILAT: %d, will set retries to 0", IAlog.a((Class<?>) com.fyber.inneractive.sdk.network.timeouts.content.a.class), Integer.valueOf(i3));
            i = 0;
        } else {
            int i4 = i2 / i3;
            int i5 = i4 - 1;
            if (i5 > 3) {
                i5 = i4 - 2;
            }
            i = Math.max(i5, 0);
        }
        int i6 = this.c;
        int i7 = this.d;
        int i8 = this.e;
        int i9 = this.f;
        int max = Math.max(0, i6);
        int max2 = Math.max(0, i7);
        int max3 = Math.max(0, i);
        int max4 = Math.max(0, (max - (Math.max(0, i8) * max3)) - (Math.max(0, i9) * max3));
        int max5 = Math.max(0, max2);
        if (max3 > 0) {
            max4 %= max5;
        }
        int max6 = Math.max(max4, 0);
        if (max6 == 0 && i > 2) {
            i--;
            max6 = this.d;
        }
        int i10 = i + 1;
        int max7 = Math.max(0, max6);
        if (i10 > 0) {
            max7 /= i10;
        }
        this.b = max7;
        return Math.max(0, a(this.c, this.d, max7, 0) - 1);
    }

    public int a(int i, int i2, int i3, int i4) {
        int max = Math.max(0, i);
        if (i2 <= 0) {
            i2 = max;
        }
        int max2 = Math.max(0, i3);
        int max3 = Math.max(0, i4);
        int i5 = max3 + 1;
        int i6 = max - ((max2 * max3) + i2);
        if (i6 < 0) {
            return Math.max(max3, 0);
        }
        if (i6 == 0) {
            return Math.max(i5, 0);
        }
        return a(i6, i2, max2, i5);
    }
}
