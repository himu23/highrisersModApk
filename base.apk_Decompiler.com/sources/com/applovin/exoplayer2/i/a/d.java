package com.applovin.exoplayer2.i.a;

import com.applovin.exoplayer2.i.a;
import com.applovin.exoplayer2.i.f;
import java.util.Collections;
import java.util.List;

final class d implements f {
    private final List<a> OV;

    public int be(long j) {
        return j < 0 ? 0 : -1;
    }

    public int lX() {
        return 1;
    }

    public d(List<a> list) {
        this.OV = list;
    }

    public long ej(int i) {
        com.applovin.exoplayer2.l.a.checkArgument(i == 0);
        return 0;
    }

    public List<a> bf(long j) {
        return j >= 0 ? this.OV : Collections.emptyList();
    }
}
