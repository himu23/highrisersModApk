package com.applovin.exoplayer2.e.i;

import com.applovin.exoplayer2.l.a;
import java.util.Arrays;

final class r {
    private boolean Dp;
    private final int EH;
    private boolean EI;
    public byte[] EJ;
    public int EK;

    public void Y() {
        this.Dp = false;
        this.EI = false;
    }

    public boolean cC(int i) {
        if (!this.Dp) {
            return false;
        }
        this.EK -= i;
        this.Dp = false;
        this.EI = true;
        return true;
    }

    public boolean jq() {
        return this.EI;
    }

    public r(int i, int i2) {
        this.EH = i;
        byte[] bArr = new byte[(i2 + 3)];
        this.EJ = bArr;
        bArr[2] = 1;
    }

    public void cB(int i) {
        boolean z = true;
        a.checkState(!this.Dp);
        if (i != this.EH) {
            z = false;
        }
        this.Dp = z;
        if (z) {
            this.EK = 3;
            this.EI = false;
        }
    }

    public void g(byte[] bArr, int i, int i2) {
        if (this.Dp) {
            int i3 = i2 - i;
            byte[] bArr2 = this.EJ;
            int length = bArr2.length;
            int i4 = this.EK;
            if (length < i4 + i3) {
                this.EJ = Arrays.copyOf(bArr2, (i4 + i3) * 2);
            }
            System.arraycopy(bArr, i, this.EJ, this.EK, i3);
            this.EK += i3;
        }
    }
}
