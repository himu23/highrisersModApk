package com.applovin.exoplayer2.e;

import com.applovin.exoplayer2.k.g;
import com.applovin.exoplayer2.l.ai;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.Arrays;

public final class e implements i {
    private final byte[] tZ = new byte[4096];
    private final g ua;
    private final long ub;
    private long uc;
    private byte[] ud = new byte[65536];
    private int ue;
    private int uf;

    private void bM(int i) {
        if (i != -1) {
            this.uc += (long) i;
        }
    }

    public void ic() {
        this.ue = 0;
    }

    public long id() {
        return this.uc + ((long) this.ue);
    }

    public long ie() {
        return this.uc;
    }

    /* renamed from: if  reason: not valid java name */
    public long m1767if() {
        return this.ub;
    }

    public e(g gVar, long j, long j2) {
        this.ua = gVar;
        this.uc = j;
        this.ub = j2;
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        int d = d(bArr, i, i2);
        if (d == 0) {
            d = a(bArr, i, i2, 0, true);
        }
        bM(d);
        return d;
    }

    public boolean a(byte[] bArr, int i, int i2, boolean z) throws IOException {
        int d = d(bArr, i, i2);
        while (d < i2 && d != -1) {
            d = a(bArr, i, i2, d, z);
        }
        bM(d);
        return d != -1;
    }

    public void a(byte[] bArr, int i, int i2) throws IOException {
        a(bArr, i, i2, false);
    }

    public int bG(int i) throws IOException {
        int bK = bK(i);
        if (bK == 0) {
            byte[] bArr = this.tZ;
            bK = a(bArr, 0, Math.min(i, bArr.length), 0, true);
        }
        bM(bK);
        return bK;
    }

    public boolean i(int i, boolean z) throws IOException {
        int bK = bK(i);
        while (bK < i && bK != -1) {
            bK = a(this.tZ, -bK, Math.min(i, this.tZ.length + bK), bK, z);
        }
        bM(bK);
        return bK != -1;
    }

    public void bH(int i) throws IOException {
        i(i, false);
    }

    public int b(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        bJ(i2);
        int i4 = this.uf;
        int i5 = this.ue;
        int i6 = i4 - i5;
        if (i6 == 0) {
            i3 = a(this.ud, i5, i2, 0, true);
            if (i3 == -1) {
                return -1;
            }
            this.uf += i3;
        } else {
            i3 = Math.min(i2, i6);
        }
        System.arraycopy(this.ud, this.ue, bArr, i, i3);
        this.ue += i3;
        return i3;
    }

    public boolean b(byte[] bArr, int i, int i2, boolean z) throws IOException {
        if (!j(i2, z)) {
            return false;
        }
        System.arraycopy(this.ud, this.ue - i2, bArr, i, i2);
        return true;
    }

    public void c(byte[] bArr, int i, int i2) throws IOException {
        b(bArr, i, i2, false);
    }

    public boolean j(int i, boolean z) throws IOException {
        bJ(i);
        int i2 = this.uf - this.ue;
        while (i2 < i) {
            i2 = a(this.ud, this.ue, i, i2, z);
            if (i2 == -1) {
                return false;
            }
            this.uf = this.ue + i2;
        }
        this.ue += i;
        return true;
    }

    public void bI(int i) throws IOException {
        j(i, false);
    }

    private void bJ(int i) {
        int i2 = this.ue + i;
        byte[] bArr = this.ud;
        if (i2 > bArr.length) {
            this.ud = Arrays.copyOf(this.ud, ai.k(bArr.length * 2, 65536 + i2, i2 + 524288));
        }
    }

    private int bK(int i) {
        int min = Math.min(this.uf, i);
        bL(min);
        return min;
    }

    private int d(byte[] bArr, int i, int i2) {
        int i3 = this.uf;
        if (i3 == 0) {
            return 0;
        }
        int min = Math.min(i3, i2);
        System.arraycopy(this.ud, 0, bArr, i, min);
        bL(min);
        return min;
    }

    private void bL(int i) {
        int i2 = this.uf - i;
        this.uf = i2;
        this.ue = 0;
        byte[] bArr = this.ud;
        byte[] bArr2 = i2 < bArr.length - 524288 ? new byte[(65536 + i2)] : bArr;
        System.arraycopy(bArr, i, bArr2, 0, i2);
        this.ud = bArr2;
    }

    private int a(byte[] bArr, int i, int i2, int i3, boolean z) throws IOException {
        if (!Thread.interrupted()) {
            int read = this.ua.read(bArr, i + i3, i2 - i3);
            if (read != -1) {
                return i3 + read;
            }
            if (i3 == 0 && z) {
                return -1;
            }
            throw new EOFException();
        }
        throw new InterruptedIOException();
    }
}
