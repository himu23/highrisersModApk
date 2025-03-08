package com.applovin.exoplayer2.f;

import java.util.NoSuchElementException;

final class f {
    private int Hg = 0;
    private int Hh = -1;
    private int[] Hi;
    private int Hj;
    private int oW = 0;

    public void clear() {
        this.Hg = 0;
        this.Hh = -1;
        this.oW = 0;
    }

    public boolean isEmpty() {
        return this.oW == 0;
    }

    public f() {
        int[] iArr = new int[16];
        this.Hi = iArr;
        this.Hj = iArr.length - 1;
    }

    public void cR(int i) {
        if (this.oW == this.Hi.length) {
            jU();
        }
        int i2 = (this.Hh + 1) & this.Hj;
        this.Hh = i2;
        this.Hi[i2] = i;
        this.oW++;
    }

    public int jT() {
        int i = this.oW;
        if (i != 0) {
            int[] iArr = this.Hi;
            int i2 = this.Hg;
            int i3 = iArr[i2];
            this.Hg = (i2 + 1) & this.Hj;
            this.oW = i - 1;
            return i3;
        }
        throw new NoSuchElementException();
    }

    private void jU() {
        int[] iArr = this.Hi;
        int length = iArr.length << 1;
        if (length >= 0) {
            int[] iArr2 = new int[length];
            int length2 = iArr.length;
            int i = this.Hg;
            int i2 = length2 - i;
            System.arraycopy(iArr, i, iArr2, 0, i2);
            System.arraycopy(this.Hi, 0, iArr2, i2, i);
            this.Hg = 0;
            this.Hh = this.oW - 1;
            this.Hi = iArr2;
            this.Hj = iArr2.length - 1;
            return;
        }
        throw new IllegalStateException();
    }
}
