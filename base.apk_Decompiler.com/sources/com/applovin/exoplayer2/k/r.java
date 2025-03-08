package com.applovin.exoplayer2.k;

import com.applovin.exoplayer2.ai;
import com.applovin.exoplayer2.k.t;
import com.applovin.exoplayer2.k.v;
import com.applovin.exoplayer2.k.w;
import java.io.FileNotFoundException;
import java.io.IOException;

public class r implements v {
    private final int aaH;

    public /* synthetic */ void bm(long j) {
        v.CC.$default$bm(this, j);
    }

    public int fl(int i) {
        int i2 = this.aaH;
        return i2 == -1 ? i == 7 ? 6 : 3 : i2;
    }

    public r() {
        this(-1);
    }

    public r(int i) {
        this.aaH = i;
    }

    public long a(v.a aVar) {
        IOException iOException = aVar.aaU;
        if ((iOException instanceof ai) || (iOException instanceof FileNotFoundException) || (iOException instanceof t.a) || (iOException instanceof w.g) || j.a(iOException)) {
            return -9223372036854775807L;
        }
        return (long) Math.min((aVar.sE - 1) * 1000, 5000);
    }
}
