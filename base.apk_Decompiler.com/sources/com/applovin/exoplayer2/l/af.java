package com.applovin.exoplayer2.l;

import java.util.Arrays;

public final class af<V> {
    private int acR;
    private int oW;
    private V[] pJ;
    private long[] zI;

    public af() {
        this(10);
    }

    public af(int i) {
        this.zI = new long[i];
        this.pJ = newArray(i);
    }

    public synchronized void a(long j, V v) {
        bq(j);
        pR();
        b(j, v);
    }

    public synchronized void clear() {
        this.acR = 0;
        this.oW = 0;
        Arrays.fill(this.pJ, (Object) null);
    }

    public synchronized int size() {
        return this.oW;
    }

    public synchronized V pollFirst() {
        return this.oW == 0 ? null : pQ();
    }

    public synchronized V bp(long j) {
        return g(j, true);
    }

    private V g(long j, boolean z) {
        V v = null;
        long j2 = Long.MAX_VALUE;
        while (this.oW > 0) {
            long j3 = j - this.zI[this.acR];
            if (j3 < 0 && (z || (-j3) >= j2)) {
                break;
            }
            v = pQ();
            j2 = j3;
        }
        return v;
    }

    private V pQ() {
        a.checkState(this.oW > 0);
        V[] vArr = this.pJ;
        int i = this.acR;
        V v = vArr[i];
        vArr[i] = null;
        this.acR = (i + 1) % vArr.length;
        this.oW--;
        return v;
    }

    private void bq(long j) {
        int i = this.oW;
        if (i > 0) {
            if (j <= this.zI[((this.acR + i) - 1) % this.pJ.length]) {
                clear();
            }
        }
    }

    private void pR() {
        int length = this.pJ.length;
        if (this.oW >= length) {
            int i = length * 2;
            long[] jArr = new long[i];
            V[] newArray = newArray(i);
            int i2 = this.acR;
            int i3 = length - i2;
            System.arraycopy(this.zI, i2, jArr, 0, i3);
            System.arraycopy(this.pJ, this.acR, newArray, 0, i3);
            int i4 = this.acR;
            if (i4 > 0) {
                System.arraycopy(this.zI, 0, jArr, i3, i4);
                System.arraycopy(this.pJ, 0, newArray, i3, this.acR);
            }
            this.zI = jArr;
            this.pJ = newArray;
            this.acR = 0;
        }
    }

    private void b(long j, V v) {
        int i = this.acR;
        int i2 = this.oW;
        V[] vArr = this.pJ;
        int length = (i + i2) % vArr.length;
        this.zI[length] = j;
        vArr[length] = v;
        this.oW = i2 + 1;
    }

    private static <V> V[] newArray(int i) {
        return new Object[i];
    }
}
