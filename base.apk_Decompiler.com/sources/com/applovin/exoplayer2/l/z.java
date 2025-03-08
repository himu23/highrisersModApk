package com.applovin.exoplayer2.l;

import kotlin.UByte;

public final class z {
    private byte[] tf;
    private int uW;
    private int uX;
    private int uY;

    public z(byte[] bArr, int i, int i2) {
        s(bArr, i, i2);
    }

    public void s(byte[] bArr, int i, int i2) {
        this.tf = bArr;
        this.uX = i;
        this.uW = i2;
        this.uY = 0;
        im();
    }

    public void ph() {
        int i = 1;
        int i2 = this.uY + 1;
        this.uY = i2;
        if (i2 == 8) {
            this.uY = 0;
            int i3 = this.uX;
            if (fE(i3 + 1)) {
                i = 2;
            }
            this.uX = i3 + i;
        }
        im();
    }

    public void bR(int i) {
        int i2 = this.uX;
        int i3 = i / 8;
        int i4 = i2 + i3;
        this.uX = i4;
        int i5 = this.uY + (i - (i3 * 8));
        this.uY = i5;
        if (i5 > 7) {
            this.uX = i4 + 1;
            this.uY = i5 - 8;
        }
        while (true) {
            i2++;
            if (i2 > this.uX) {
                im();
                return;
            } else if (fE(i2)) {
                this.uX++;
                i2 += 2;
            }
        }
    }

    public boolean fD(int i) {
        int i2 = this.uX;
        int i3 = i / 8;
        int i4 = i2 + i3;
        int i5 = (this.uY + i) - (i3 * 8);
        if (i5 > 7) {
            i4++;
            i5 -= 8;
        }
        while (true) {
            i2++;
            if (i2 > i4 || i4 >= this.uW) {
                int i6 = this.uW;
            } else if (fE(i2)) {
                i4++;
                i2 += 2;
            }
        }
        int i62 = this.uW;
        if (i4 < i62) {
            return true;
        }
        if (i4 == i62 && i5 == 0) {
            return true;
        }
        return false;
    }

    public boolean ik() {
        boolean z = (this.tf[this.uX] & (128 >> this.uY)) != 0;
        ph();
        return z;
    }

    public int bQ(int i) {
        int i2;
        int i3;
        this.uY += i;
        int i4 = 0;
        while (true) {
            i2 = this.uY;
            i3 = 2;
            if (i2 <= 8) {
                break;
            }
            int i5 = i2 - 8;
            this.uY = i5;
            byte[] bArr = this.tf;
            int i6 = this.uX;
            i4 |= (bArr[i6] & UByte.MAX_VALUE) << i5;
            if (!fE(i6 + 1)) {
                i3 = 1;
            }
            this.uX = i6 + i3;
        }
        byte[] bArr2 = this.tf;
        int i7 = this.uX;
        int i8 = (-1 >>> (32 - i)) & (i4 | ((bArr2[i7] & UByte.MAX_VALUE) >> (8 - i2)));
        if (i2 == 8) {
            this.uY = 0;
            if (!fE(i7 + 1)) {
                i3 = 1;
            }
            this.uX = i7 + i3;
        }
        im();
        return i8;
    }

    public boolean pL() {
        int i = this.uX;
        int i2 = this.uY;
        int i3 = 0;
        while (this.uX < this.uW && !ik()) {
            i3++;
        }
        boolean z = this.uX == this.uW;
        this.uX = i;
        this.uY = i2;
        if (z || !fD((i3 * 2) + 1)) {
            return false;
        }
        return true;
    }

    public int pM() {
        return pO();
    }

    public int pN() {
        int pO = pO();
        return (pO % 2 == 0 ? -1 : 1) * ((pO + 1) / 2);
    }

    private int pO() {
        int i = 0;
        int i2 = 0;
        while (!ik()) {
            i2++;
        }
        int i3 = (1 << i2) - 1;
        if (i2 > 0) {
            i = bQ(i2);
        }
        return i3 + i;
    }

    private boolean fE(int i) {
        if (2 <= i && i < this.uW) {
            byte[] bArr = this.tf;
            return bArr[i] == 3 && bArr[i + -2] == 0 && bArr[i - 1] == 0;
        }
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
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.l.z.im():void");
    }
}
