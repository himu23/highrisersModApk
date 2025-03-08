package com.applovin.exoplayer2.i.f;

import com.applovin.exoplayer2.i.a;
import com.applovin.exoplayer2.i.f;
import com.applovin.exoplayer2.l.ai;
import java.util.Collections;
import java.util.List;

final class b implements f {
    private final a[] Sb;
    private final long[] Sc;

    public b(a[] aVarArr, long[] jArr) {
        this.Sb = aVarArr;
        this.Sc = jArr;
    }

    public int be(long j) {
        int b = ai.b(this.Sc, j, false, false);
        if (b < this.Sc.length) {
            return b;
        }
        return -1;
    }

    public int lX() {
        return this.Sc.length;
    }

    public long ej(int i) {
        boolean z = true;
        com.applovin.exoplayer2.l.a.checkArgument(i >= 0);
        if (i >= this.Sc.length) {
            z = false;
        }
        com.applovin.exoplayer2.l.a.checkArgument(z);
        return this.Sc[i];
    }

    public List<a> bf(long j) {
        int a = ai.a(this.Sc, j, true, false);
        if (a == -1 || this.Sb[a] == a.NV) {
            return Collections.emptyList();
        }
        return Collections.singletonList(this.Sb[a]);
    }
}
