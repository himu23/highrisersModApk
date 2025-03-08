package com.applovin.exoplayer2;

import com.applovin.exoplayer2.h.z;
import com.applovin.exoplayer2.l.ai;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

final class ap extends a {
    private final int ha;
    private final int hb;
    private final int[] hc;
    private final int[] hd;
    private final ba[] he;
    private final Object[] hf;
    private final HashMap<Object, Integer> hg = new HashMap<>();

    public int cP() {
        return this.ha;
    }

    public int cQ() {
        return this.hb;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ap(Collection<? extends ag> collection, z zVar) {
        super(false, zVar);
        int i = 0;
        int size = collection.size();
        this.hc = new int[size];
        this.hd = new int[size];
        this.he = new ba[size];
        this.hf = new Object[size];
        int i2 = 0;
        int i3 = 0;
        for (ag agVar : collection) {
            this.he[i3] = agVar.bf();
            this.hd[i3] = i;
            this.hc[i3] = i2;
            i += this.he[i3].cP();
            i2 += this.he[i3].cQ();
            this.hf[i3] = agVar.be();
            this.hg.put(this.hf[i3], Integer.valueOf(i3));
            i3++;
        }
        this.ha = i;
        this.hb = i2;
    }

    /* access modifiers changed from: package-private */
    public List<ba> cO() {
        return Arrays.asList(this.he);
    }

    /* access modifiers changed from: protected */
    public int c(int i) {
        return ai.a(this.hc, i + 1, false, false);
    }

    /* access modifiers changed from: protected */
    public int d(int i) {
        return ai.a(this.hd, i + 1, false, false);
    }

    /* access modifiers changed from: protected */
    public int d(Object obj) {
        Integer num = this.hg.get(obj);
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    /* access modifiers changed from: protected */
    public ba e(int i) {
        return this.he[i];
    }

    /* access modifiers changed from: protected */
    public int f(int i) {
        return this.hc[i];
    }

    /* access modifiers changed from: protected */
    public int g(int i) {
        return this.hd[i];
    }

    /* access modifiers changed from: protected */
    public Object h(int i) {
        return this.hf[i];
    }
}
