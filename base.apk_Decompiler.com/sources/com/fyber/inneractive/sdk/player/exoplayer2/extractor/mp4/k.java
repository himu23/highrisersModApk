package com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4;

import com.fyber.inneractive.sdk.player.exoplayer2.util.a;
import com.fyber.inneractive.sdk.player.exoplayer2.util.u;

public final class k {
    public final int a;
    public final long[] b;
    public final int[] c;
    public final int d;
    public final long[] e;
    public final int[] f;

    public k(long[] jArr, int[] iArr, int i, long[] jArr2, int[] iArr2) {
        boolean z = true;
        a.a(iArr.length == jArr2.length);
        a.a(jArr.length == jArr2.length);
        a.a(iArr2.length != jArr2.length ? false : z);
        this.b = jArr;
        this.c = iArr;
        this.d = i;
        this.e = jArr2;
        this.f = iArr2;
        this.a = jArr.length;
    }

    public int a(long j) {
        for (int b2 = u.b(this.e, j, true, false); b2 >= 0; b2--) {
            if ((this.f[b2] & 1) != 0) {
                return b2;
            }
        }
        return -1;
    }

    public int b(long j) {
        for (int a2 = u.a(this.e, j, true, false); a2 < this.e.length; a2++) {
            if ((this.f[a2] & 1) != 0) {
                return a2;
            }
        }
        return -1;
    }
}
