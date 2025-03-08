package com.fyber.inneractive.sdk.player.exoplayer2.util;

import kotlin.UByte;

public final class j {
    public byte[] a;
    public int b;
    public int c;
    public int d;

    public j(byte[] bArr) {
        this(bArr, bArr.length);
    }

    public void b(int i) {
        int i2 = i / 8;
        this.b = i2;
        this.c = i - (i2 * 8);
        a();
    }

    public void c(int i) {
        int i2 = i / 8;
        int i3 = this.b + i2;
        this.b = i3;
        int i4 = this.c + (i - (i2 * 8));
        this.c = i4;
        if (i4 > 7) {
            this.b = i3 + 1;
            this.c = i4 - 8;
        }
        a();
    }

    public j(byte[] bArr, int i) {
        this.a = bArr;
        this.d = i;
    }

    public int a(int i) {
        int i2;
        this.c += i;
        int i3 = 0;
        while (true) {
            i2 = this.c;
            if (i2 <= 8) {
                break;
            }
            int i4 = i2 - 8;
            this.c = i4;
            byte[] bArr = this.a;
            int i5 = this.b;
            this.b = i5 + 1;
            i3 |= (bArr[i5] & UByte.MAX_VALUE) << i4;
        }
        byte[] bArr2 = this.a;
        int i6 = this.b;
        int i7 = (-1 >>> (32 - i)) & (i3 | ((bArr2[i6] & UByte.MAX_VALUE) >> (8 - i2)));
        if (i2 == 8) {
            this.c = 0;
            this.b = i6 + 1;
        }
        a();
        return i7;
    }

    public boolean b() {
        byte[] bArr = this.a;
        int i = this.b;
        byte b2 = bArr[i];
        int i2 = this.c;
        boolean z = (b2 & (128 >> i2)) != 0;
        int i3 = i2 + 1;
        this.c = i3;
        if (i3 == 8) {
            this.c = 0;
            this.b = i + 1;
        }
        a();
        return z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r1 = r2.d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a() {
        /*
            r2 = this;
            int r0 = r2.b
            if (r0 < 0) goto L_0x0010
            int r1 = r2.d
            if (r0 < r1) goto L_0x000e
            if (r0 != r1) goto L_0x0010
            int r0 = r2.c
            if (r0 != 0) goto L_0x0010
        L_0x000e:
            r0 = 1
            goto L_0x0011
        L_0x0010:
            r0 = 0
        L_0x0011:
            com.fyber.inneractive.sdk.player.exoplayer2.util.a.b(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.exoplayer2.util.j.a():void");
    }
}
