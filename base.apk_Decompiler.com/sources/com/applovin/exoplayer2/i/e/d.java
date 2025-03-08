package com.applovin.exoplayer2.i.e;

import com.applovin.exoplayer2.i.a;
import com.applovin.exoplayer2.i.f;
import com.applovin.exoplayer2.l.ai;
import java.util.Collections;
import java.util.List;

final class d implements f {
    private final List<List<a>> OV;
    private final List<Long> RW;

    public d(List<List<a>> list, List<Long> list2) {
        this.OV = list;
        this.RW = list2;
    }

    public int be(long j) {
        int b = ai.b(this.RW, Long.valueOf(j), false, false);
        if (b < this.RW.size()) {
            return b;
        }
        return -1;
    }

    public int lX() {
        return this.RW.size();
    }

    public long ej(int i) {
        boolean z = true;
        com.applovin.exoplayer2.l.a.checkArgument(i >= 0);
        if (i >= this.RW.size()) {
            z = false;
        }
        com.applovin.exoplayer2.l.a.checkArgument(z);
        return this.RW.get(i).longValue();
    }

    public List<a> bf(long j) {
        int a = ai.a(this.RW, Long.valueOf(j), true, false);
        if (a == -1) {
            return Collections.emptyList();
        }
        return this.OV.get(a);
    }
}
