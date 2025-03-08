package com.applovin.exoplayer2.i;

import com.applovin.exoplayer2.common.a.s;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public final class c implements g {
    private final b On = new b();
    private final j Oo = new j();
    private final Deque<k> Op = new ArrayDeque();
    private int Oq;
    private boolean cw;

    public void bd(long j) {
    }

    public void release() {
        this.cw = true;
    }

    public c() {
        for (int i = 0; i < 2; i++) {
            this.Op.addFirst(new e(new c$$ExternalSyntheticLambda0(this)));
        }
        this.Oq = 0;
    }

    /* renamed from: lV */
    public j hc() throws h {
        com.applovin.exoplayer2.l.a.checkState(!this.cw);
        if (this.Oq != 0) {
            return null;
        }
        this.Oq = 1;
        return this.Oo;
    }

    /* renamed from: a */
    public void D(j jVar) throws h {
        boolean z = true;
        com.applovin.exoplayer2.l.a.checkState(!this.cw);
        com.applovin.exoplayer2.l.a.checkState(this.Oq == 1);
        if (this.Oo != jVar) {
            z = false;
        }
        com.applovin.exoplayer2.l.a.checkArgument(z);
        this.Oq = 2;
    }

    /* renamed from: lW */
    public k hd() throws h {
        com.applovin.exoplayer2.l.a.checkState(!this.cw);
        if (this.Oq != 2 || this.Op.isEmpty()) {
            return null;
        }
        k removeFirst = this.Op.removeFirst();
        if (this.Oo.gY()) {
            removeFirst.bt(4);
        } else {
            a aVar = new a(this.Oo.rJ, this.On.F(((ByteBuffer) com.applovin.exoplayer2.l.a.checkNotNull(this.Oo.rH)).array()));
            removeFirst.a(this.Oo.rJ, aVar, 0);
        }
        this.Oo.clear();
        this.Oq = 0;
        return removeFirst;
    }

    public void dI() {
        com.applovin.exoplayer2.l.a.checkState(!this.cw);
        this.Oo.clear();
        this.Oq = 0;
    }

    /* access modifiers changed from: private */
    public void a(k kVar) {
        com.applovin.exoplayer2.l.a.checkState(this.Op.size() < 2);
        com.applovin.exoplayer2.l.a.checkArgument(!this.Op.contains(kVar));
        kVar.clear();
        this.Op.addFirst(kVar);
    }

    private static final class a implements f {
        private final s<a> Or;
        private final long rJ;

        public int be(long j) {
            return this.rJ > j ? 0 : -1;
        }

        public int lX() {
            return 1;
        }

        public a(long j, s<a> sVar) {
            this.rJ = j;
            this.Or = sVar;
        }

        public long ej(int i) {
            com.applovin.exoplayer2.l.a.checkArgument(i == 0);
            return this.rJ;
        }

        public List<a> bf(long j) {
            return j >= this.rJ ? this.Or : s.ga();
        }
    }
}
