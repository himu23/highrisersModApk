package com.fyber.inneractive.sdk.player.exoplayer2.extractor.ogg;

import com.fyber.inneractive.sdk.player.exoplayer2.util.a;
import kotlin.UByte;

public final class i {
    public final byte[] a;
    public final int b;
    public int c;
    public int d;

    public i(byte[] bArr) {
        this.a = bArr;
        this.b = bArr.length;
    }

    public boolean a() {
        boolean z = (((this.a[this.c] & UByte.MAX_VALUE) >> this.d) & 1) == 1;
        b(1);
        return z;
    }

    public void b(int i) {
        int i2;
        int i3 = i / 8;
        int i4 = this.c + i3;
        this.c = i4;
        int i5 = this.d + (i - (i3 * 8));
        this.d = i5;
        boolean z = true;
        if (i5 > 7) {
            this.c = i4 + 1;
            this.d = i5 - 8;
        }
        int i6 = this.c;
        if (i6 < 0 || (i6 >= (i2 = this.b) && !(i6 == i2 && this.d == 0))) {
            z = false;
        }
        a.b(z);
    }

    public int a(int i) {
        int i2 = this.c;
        int min = Math.min(i, 8 - this.d);
        int i3 = i2 + 1;
        int i4 = ((this.a[i2] & UByte.MAX_VALUE) >> this.d) & (255 >> (8 - min));
        while (min < i) {
            i4 |= (this.a[i3] & UByte.MAX_VALUE) << min;
            min += 8;
            i3++;
        }
        int i5 = i4 & (-1 >>> (32 - i));
        b(i);
        return i5;
    }
}
