package com.applovin.exoplayer2.i.a;

import com.applovin.exoplayer2.c.i;
import com.applovin.exoplayer2.i.f;
import com.applovin.exoplayer2.i.g;
import com.applovin.exoplayer2.i.h;
import com.applovin.exoplayer2.i.j;
import com.applovin.exoplayer2.i.k;
import com.applovin.exoplayer2.l.ai;
import java.util.ArrayDeque;
import java.util.PriorityQueue;

abstract class c implements g {
    private long KL;
    private final ArrayDeque<a> Qg = new ArrayDeque<>();
    private final ArrayDeque<k> Qh;
    private final PriorityQueue<a> Qi;
    private a Qj;
    private long Qk;

    /* access modifiers changed from: protected */
    public final long au() {
        return this.KL;
    }

    /* access modifiers changed from: protected */
    public abstract void b(j jVar);

    public void bd(long j) {
        this.KL = j;
    }

    /* access modifiers changed from: protected */
    public abstract boolean mg();

    /* access modifiers changed from: protected */
    public abstract f mh();

    public void release() {
    }

    public c() {
        for (int i = 0; i < 10; i++) {
            this.Qg.add(new a());
        }
        this.Qh = new ArrayDeque<>();
        for (int i2 = 0; i2 < 2; i2++) {
            this.Qh.add(new b(new c$$ExternalSyntheticLambda0(this)));
        }
        this.Qi = new PriorityQueue<>();
    }

    /* renamed from: lV */
    public j hc() throws h {
        com.applovin.exoplayer2.l.a.checkState(this.Qj == null);
        if (this.Qg.isEmpty()) {
            return null;
        }
        a pollFirst = this.Qg.pollFirst();
        this.Qj = pollFirst;
        return pollFirst;
    }

    /* renamed from: a */
    public void D(j jVar) throws h {
        com.applovin.exoplayer2.l.a.checkArgument(jVar == this.Qj);
        a aVar = (a) jVar;
        if (aVar.gX()) {
            a(aVar);
        } else {
            long j = this.Qk;
            this.Qk = 1 + j;
            long unused = aVar.Qk = j;
            this.Qi.add(aVar);
        }
        this.Qj = null;
    }

    /* renamed from: lW */
    public k hd() throws h {
        if (this.Qh.isEmpty()) {
            return null;
        }
        while (!this.Qi.isEmpty() && ((a) ai.R(this.Qi.peek())).rJ <= this.KL) {
            a aVar = (a) ai.R(this.Qi.poll());
            if (aVar.gY()) {
                k kVar = (k) ai.R(this.Qh.pollFirst());
                kVar.bt(4);
                a(aVar);
                return kVar;
            }
            b(aVar);
            if (mg()) {
                f mh = mh();
                k kVar2 = (k) ai.R(this.Qh.pollFirst());
                kVar2.a(aVar.rJ, mh, Long.MAX_VALUE);
                a(aVar);
                return kVar2;
            }
            a(aVar);
        }
        return null;
    }

    private void a(a aVar) {
        aVar.clear();
        this.Qg.add(aVar);
    }

    /* access modifiers changed from: protected */
    public void a(k kVar) {
        kVar.clear();
        this.Qh.add(kVar);
    }

    public void dI() {
        this.Qk = 0;
        this.KL = 0;
        while (!this.Qi.isEmpty()) {
            a((a) ai.R(this.Qi.poll()));
        }
        a aVar = this.Qj;
        if (aVar != null) {
            a(aVar);
            this.Qj = null;
        }
    }

    /* access modifiers changed from: protected */
    public final k mA() {
        return this.Qh.pollFirst();
    }

    private static final class a extends j implements Comparable<a> {
        /* access modifiers changed from: private */
        public long Qk;

        private a() {
        }

        /* renamed from: b */
        public int compareTo(a aVar) {
            if (gY() == aVar.gY()) {
                long j = this.rJ - aVar.rJ;
                if (j == 0) {
                    j = this.Qk - aVar.Qk;
                    if (j == 0) {
                        return 0;
                    }
                }
                if (j > 0) {
                    return 1;
                }
                return -1;
            } else if (gY()) {
                return 1;
            } else {
                return -1;
            }
        }
    }

    private static final class b extends k {
        private i.a<b> Os;

        public b(i.a<b> aVar) {
            this.Os = aVar;
        }

        public final void release() {
            this.Os.releaseOutputBuffer(this);
        }
    }
}
