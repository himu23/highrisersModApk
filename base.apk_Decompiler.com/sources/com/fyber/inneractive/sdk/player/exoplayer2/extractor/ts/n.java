package com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts;

import com.fyber.inneractive.sdk.player.exoplayer2.util.a;
import java.util.Arrays;

public final class n {
    public final int a;
    public boolean b;
    public boolean c;
    public byte[] d;
    public int e;

    public n(int i, int i2) {
        this.a = i;
        byte[] bArr = new byte[(i2 + 3)];
        this.d = bArr;
        bArr[2] = 1;
    }

    public void a() {
        this.b = false;
        this.c = false;
    }

    public boolean a(int i) {
        if (!this.b) {
            return false;
        }
        this.e -= i;
        this.b = false;
        this.c = true;
        return true;
    }

    public void b(int i) {
        boolean z = true;
        a.b(!this.b);
        if (i != this.a) {
            z = false;
        }
        this.b = z;
        if (z) {
            this.e = 3;
            this.c = false;
        }
    }

    public void a(byte[] bArr, int i, int i2) {
        if (this.b) {
            int i3 = i2 - i;
            byte[] bArr2 = this.d;
            int length = bArr2.length;
            int i4 = this.e + i3;
            if (length < i4) {
                this.d = Arrays.copyOf(bArr2, i4 * 2);
            }
            System.arraycopy(bArr, i, this.d, this.e, i3);
            this.e += i3;
        }
    }
}
