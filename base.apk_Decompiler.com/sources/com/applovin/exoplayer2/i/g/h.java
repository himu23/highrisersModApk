package com.applovin.exoplayer2.i.g;

import com.applovin.exoplayer2.i.a;
import com.applovin.exoplayer2.i.f;
import com.applovin.exoplayer2.l.ai;
import java.util.Collections;
import java.util.List;
import java.util.Map;

final class h implements f {
    private final d Tb;
    private final long[] Tc;
    private final Map<String, g> Td;
    private final Map<String, e> Te;
    private final Map<String, String> Tf;

    public h(d dVar, Map<String, g> map, Map<String, e> map2, Map<String, String> map3) {
        this.Tb = dVar;
        this.Te = map2;
        this.Tf = map3;
        this.Td = map != null ? Collections.unmodifiableMap(map) : Collections.emptyMap();
        this.Tc = dVar.mF();
    }

    public int be(long j) {
        int b = ai.b(this.Tc, j, false, false);
        if (b < this.Tc.length) {
            return b;
        }
        return -1;
    }

    public int lX() {
        return this.Tc.length;
    }

    public long ej(int i) {
        return this.Tc[i];
    }

    public List<a> bf(long j) {
        return this.Tb.a(j, this.Td, this.Te, this.Tf);
    }
}
