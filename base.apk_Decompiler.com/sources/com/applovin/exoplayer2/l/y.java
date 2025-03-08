package com.applovin.exoplayer2.l;

import com.applovin.exoplayer2.common.base.Ascii;
import com.applovin.exoplayer2.common.base.Charsets;
import java.nio.charset.Charset;
import java.util.Arrays;
import kotlin.UByte;

public final class y {
    private int limit;
    private int oX;
    private byte[] tf;

    public byte[] hO() {
        return this.tf;
    }

    public int il() {
        return this.oX;
    }

    public void l(byte[] bArr, int i) {
        this.tf = bArr;
        this.limit = i;
        this.oX = 0;
    }

    public int pj() {
        return this.limit - this.oX;
    }

    public int pk() {
        return this.limit;
    }

    public y() {
        this.tf = ai.ada;
    }

    public y(int i) {
        this.tf = new byte[i];
        this.limit = i;
    }

    public y(byte[] bArr) {
        this.tf = bArr;
        this.limit = bArr.length;
    }

    public y(byte[] bArr, int i) {
        this.tf = bArr;
        this.limit = i;
    }

    public void U(int i) {
        l(pl() < i ? new byte[i] : this.tf, i);
    }

    public void I(byte[] bArr) {
        l(bArr, bArr.length);
    }

    public void bj(int i) {
        if (i > pl()) {
            this.tf = Arrays.copyOf(this.tf, i);
        }
    }

    public void fA(int i) {
        a.checkArgument(i >= 0 && i <= this.tf.length);
        this.limit = i;
    }

    public void fx(int i) {
        a.checkArgument(i >= 0 && i <= this.limit);
        this.oX = i;
    }

    public int pl() {
        return this.tf.length;
    }

    public void fz(int i) {
        fx(this.oX + i);
    }

    public void f(x xVar, int i) {
        r(xVar.tf, 0, i);
        xVar.fx(0);
    }

    public void r(byte[] bArr, int i, int i2) {
        System.arraycopy(this.tf, this.oX, bArr, i, i2);
        this.oX += i2;
    }

    public int pm() {
        return this.tf[this.oX] & UByte.MAX_VALUE;
    }

    public char pn() {
        byte[] bArr = this.tf;
        int i = this.oX;
        return (char) ((bArr[i + 1] & UByte.MAX_VALUE) | ((bArr[i] & UByte.MAX_VALUE) << 8));
    }

    public int po() {
        byte[] bArr = this.tf;
        int i = this.oX;
        this.oX = i + 1;
        return bArr[i] & UByte.MAX_VALUE;
    }

    public int pp() {
        byte[] bArr = this.tf;
        int i = this.oX;
        this.oX = i + 2;
        return (bArr[i + 1] & UByte.MAX_VALUE) | ((bArr[i] & UByte.MAX_VALUE) << 8);
    }

    public int pq() {
        byte[] bArr = this.tf;
        int i = this.oX;
        int i2 = i + 1;
        byte b = bArr[i] & UByte.MAX_VALUE;
        this.oX = i + 2;
        return ((bArr[i2] & UByte.MAX_VALUE) << 8) | b;
    }

    public short pr() {
        byte[] bArr = this.tf;
        int i = this.oX;
        this.oX = i + 2;
        return (short) ((bArr[i + 1] & UByte.MAX_VALUE) | ((bArr[i] & UByte.MAX_VALUE) << 8));
    }

    public short ps() {
        byte[] bArr = this.tf;
        int i = this.oX;
        int i2 = i + 1;
        byte b = bArr[i] & UByte.MAX_VALUE;
        this.oX = i + 2;
        return (short) (((bArr[i2] & UByte.MAX_VALUE) << 8) | b);
    }

    public int pt() {
        byte[] bArr = this.tf;
        int i = this.oX;
        int i2 = (bArr[i] & UByte.MAX_VALUE) << Ascii.DLE;
        this.oX = i + 3;
        return (bArr[i + 2] & UByte.MAX_VALUE) | ((bArr[i + 1] & UByte.MAX_VALUE) << 8) | i2;
    }

    public int pu() {
        byte[] bArr = this.tf;
        int i = this.oX;
        int i2 = (bArr[i + 1] & UByte.MAX_VALUE) << 8;
        this.oX = i + 3;
        return (bArr[i + 2] & UByte.MAX_VALUE) | i2 | (((bArr[i] & UByte.MAX_VALUE) << Ascii.CAN) >> 8);
    }

    public long pv() {
        byte[] bArr = this.tf;
        int i = this.oX;
        this.oX = i + 4;
        return (((long) bArr[i + 3]) & 255) | ((((long) bArr[i]) & 255) << 24) | ((((long) bArr[i + 1]) & 255) << 16) | ((((long) bArr[i + 2]) & 255) << 8);
    }

    public long pw() {
        byte[] bArr = this.tf;
        int i = this.oX;
        this.oX = i + 4;
        return ((((long) bArr[i + 3]) & 255) << 24) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16);
    }

    public int px() {
        byte[] bArr = this.tf;
        int i = this.oX;
        byte b = ((bArr[i + 1] & UByte.MAX_VALUE) << Ascii.DLE) | ((bArr[i] & UByte.MAX_VALUE) << Ascii.CAN);
        this.oX = i + 4;
        return (bArr[i + 3] & UByte.MAX_VALUE) | b | ((bArr[i + 2] & UByte.MAX_VALUE) << 8);
    }

    public int py() {
        byte[] bArr = this.tf;
        int i = this.oX;
        byte b = ((bArr[i + 1] & UByte.MAX_VALUE) << 8) | (bArr[i] & UByte.MAX_VALUE);
        this.oX = i + 4;
        return ((bArr[i + 3] & UByte.MAX_VALUE) << Ascii.CAN) | b | ((bArr[i + 2] & UByte.MAX_VALUE) << Ascii.DLE);
    }

    public long pz() {
        byte[] bArr = this.tf;
        int i = this.oX;
        long j = ((((long) bArr[i]) & 255) << 56) | ((((long) bArr[i + 1]) & 255) << 48) | ((((long) bArr[i + 2]) & 255) << 40) | ((((long) bArr[i + 3]) & 255) << 32) | ((((long) bArr[i + 4]) & 255) << 24);
        this.oX = i + 8;
        return (((long) bArr[i + 7]) & 255) | j | ((((long) bArr[i + 5]) & 255) << 16) | ((((long) bArr[i + 6]) & 255) << 8);
    }

    public long pA() {
        byte[] bArr = this.tf;
        int i = this.oX;
        long j = (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40);
        this.oX = i + 8;
        return ((((long) bArr[i + 7]) & 255) << 56) | j | ((((long) bArr[i + 6]) & 255) << 48);
    }

    public int pB() {
        byte[] bArr = this.tf;
        int i = this.oX;
        byte b = (bArr[i + 1] & UByte.MAX_VALUE) | ((bArr[i] & UByte.MAX_VALUE) << 8);
        this.oX = i + 4;
        return b;
    }

    public int pC() {
        return (po() << 21) | (po() << 14) | (po() << 7) | po();
    }

    public int pD() {
        int px = px();
        if (px >= 0) {
            return px;
        }
        throw new IllegalStateException("Top bit not zero: " + px);
    }

    public int pE() {
        int py = py();
        if (py >= 0) {
            return py;
        }
        throw new IllegalStateException("Top bit not zero: " + py);
    }

    public long pF() {
        long pz = pz();
        if (pz >= 0) {
            return pz;
        }
        throw new IllegalStateException("Top bit not zero: " + pz);
    }

    public float pG() {
        return Float.intBitsToFloat(px());
    }

    public double pH() {
        return Double.longBitsToDouble(pz());
    }

    public String fB(int i) {
        return b(i, Charsets.UTF_8);
    }

    public String b(int i, Charset charset) {
        String str = new String(this.tf, this.oX, i, charset);
        this.oX += i;
        return str;
    }

    public String fC(int i) {
        if (i == 0) {
            return "";
        }
        int i2 = this.oX;
        int i3 = (i2 + i) - 1;
        String t = ai.t(this.tf, i2, (i3 >= this.limit || this.tf[i3] != 0) ? i : i - 1);
        this.oX += i;
        return t;
    }

    public String pI() {
        return b(0);
    }

    public String b(char c) {
        if (pj() == 0) {
            return null;
        }
        int i = this.oX;
        while (i < this.limit && this.tf[i] != c) {
            i++;
        }
        byte[] bArr = this.tf;
        int i2 = this.oX;
        String t = ai.t(bArr, i2, i - i2);
        this.oX = i;
        if (i < this.limit) {
            this.oX = i + 1;
        }
        return t;
    }

    public String pJ() {
        if (pj() == 0) {
            return null;
        }
        int i = this.oX;
        while (i < this.limit && !ai.fG(this.tf[i])) {
            i++;
        }
        int i2 = this.oX;
        if (i - i2 >= 3) {
            byte[] bArr = this.tf;
            if (bArr[i2] == -17 && bArr[i2 + 1] == -69 && bArr[i2 + 2] == -65) {
                this.oX = i2 + 3;
            }
        }
        byte[] bArr2 = this.tf;
        int i3 = this.oX;
        String t = ai.t(bArr2, i3, i - i3);
        this.oX = i;
        int i4 = this.limit;
        if (i == i4) {
            return t;
        }
        byte[] bArr3 = this.tf;
        if (bArr3[i] == 13) {
            int i5 = i + 1;
            this.oX = i5;
            if (i5 == i4) {
                return t;
            }
        }
        int i6 = this.oX;
        if (bArr3[i6] == 10) {
            this.oX = i6 + 1;
        }
        return t;
    }

    public long pK() {
        int i;
        int i2;
        long j = (long) this.tf[this.oX];
        int i3 = 7;
        while (true) {
            i = 1;
            if (i3 < 0) {
                break;
            }
            int i4 = 1 << i3;
            if ((((long) i4) & j) != 0) {
                i3--;
            } else if (i3 < 6) {
                j &= (long) (i4 - 1);
                i2 = 7 - i3;
            } else if (i3 == 7) {
                i2 = 1;
            }
        }
        i2 = 0;
        if (i2 != 0) {
            while (i < i2) {
                byte b = this.tf[this.oX + i];
                if ((b & 192) == 128) {
                    j = (j << 6) | ((long) (b & 63));
                    i++;
                } else {
                    throw new NumberFormatException("Invalid UTF-8 sequence continuation byte: " + j);
                }
            }
            this.oX += i2;
            return j;
        }
        throw new NumberFormatException("Invalid UTF-8 sequence first byte: " + j);
    }
}
