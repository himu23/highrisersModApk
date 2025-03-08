package com.applovin.exoplayer2.e;

import kotlin.UByte;

public final class y {
    private final byte[] tf;
    private final int uW;
    private int uX;
    private int uY;

    public int il() {
        return (this.uX * 8) + this.uY;
    }

    public y(byte[] bArr) {
        this.tf = bArr;
        this.uW = bArr.length;
    }

    public boolean ik() {
        boolean z = (((this.tf[this.uX] & UByte.MAX_VALUE) >> this.uY) & 1) == 1;
        bR(1);
        return z;
    }

    public int bQ(int i) {
        int i2 = this.uX;
        int min = Math.min(i, 8 - this.uY);
        int i3 = i2 + 1;
        int i4 = ((this.tf[i2] & UByte.MAX_VALUE) >> this.uY) & (255 >> (8 - min));
        while (min < i) {
            i4 |= (this.tf[i3] & UByte.MAX_VALUE) << min;
            min += 8;
            i3++;
        }
        int i5 = i4 & (-1 >>> (32 - i));
        bR(i);
        return i5;
    }

    public void bR(int i) {
        int i2 = i / 8;
        int i3 = this.uX + i2;
        this.uX = i3;
        int i4 = this.uY + (i - (i2 * 8));
        this.uY = i4;
        if (i4 > 7) {
            this.uX = i3 + 1;
            this.uY = i4 - 8;
        }
        im();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r1 = r2.uW;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void im() {
        /*
            r2 = this;
            int r0 = r2.uX
            if (r0 < 0) goto L_0x0010
            int r1 = r2.uW
            if (r0 < r1) goto L_0x000e
            if (r0 != r1) goto L_0x0010
            int r0 = r2.uY
            if (r0 != 0) goto L_0x0010
        L_0x000e:
            r0 = 1
            goto L_0x0011
        L_0x0010:
            r0 = 0
        L_0x0011:
            com.applovin.exoplayer2.l.a.checkState(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.e.y.im():void");
    }
}
