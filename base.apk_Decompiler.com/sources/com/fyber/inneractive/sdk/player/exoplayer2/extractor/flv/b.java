package com.fyber.inneractive.sdk.player.exoplayer2.extractor.flv;

import com.fyber.inneractive.sdk.player.exoplayer2.extractor.f;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.g;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.h;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.l;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.m;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.n;
import com.fyber.inneractive.sdk.player.exoplayer2.util.k;
import com.fyber.inneractive.sdk.player.exoplayer2.util.u;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.io.IOException;

public final class b implements f, m {
    public static final int n = u.a("FLV");
    public final k a = new k(4);
    public final k b = new k(9);
    public final k c = new k(11);
    public final k d = new k();
    public h e;
    public int f = 1;
    public int g;
    public int h;
    public int i;
    public long j;
    public a k;
    public e l;
    public c m;

    public long a(long j2) {
        return 0;
    }

    public void a(long j2, long j3) {
        this.f = 1;
        this.g = 0;
    }

    public void a(h hVar) {
        this.e = hVar;
    }

    public boolean a() {
        return false;
    }

    public boolean a(g gVar) throws IOException, InterruptedException {
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.b bVar = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) gVar;
        bVar.a(this.a.a, 0, 3, false);
        this.a.e(0);
        if (this.a.n() != n) {
            return false;
        }
        bVar.a(this.a.a, 0, 2, false);
        this.a.e(0);
        if ((this.a.q() & IronSourceConstants.INTERSTITIAL_DAILY_CAPPED) != 0) {
            return false;
        }
        bVar.a(this.a.a, 0, 4, false);
        this.a.e(0);
        int c2 = this.a.c();
        bVar.e = 0;
        bVar.a(c2, false);
        bVar.a(this.a.a, 0, 4, false);
        this.a.e(0);
        if (this.a.c() == 0) {
            return true;
        }
        return false;
    }

    public final k b(g gVar) throws IOException, InterruptedException {
        if (this.i > this.d.b()) {
            k kVar = this.d;
            kVar.a = new byte[Math.max(kVar.b() * 2, this.i)];
            kVar.c = 0;
            kVar.b = 0;
        } else {
            this.d.e(0);
        }
        this.d.d(this.i);
        ((com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) gVar).b(this.d.a, 0, this.i, false);
        return this.d;
    }

    public void b() {
    }

    public final boolean c(g gVar) throws IOException, InterruptedException {
        boolean z;
        c cVar;
        e eVar;
        a aVar;
        int i2 = this.h;
        if (i2 == 8 && (aVar = this.k) != null) {
            aVar.a(b(gVar), this.j);
        } else if (i2 == 9 && (eVar = this.l) != null) {
            eVar.a(b(gVar), this.j);
        } else if (i2 != 18 || (cVar = this.m) == null) {
            ((com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) gVar).c(this.i);
            z = false;
            this.g = 4;
            this.f = 2;
            return z;
        } else {
            cVar.a(b(gVar), this.j);
        }
        z = true;
        this.g = 4;
        this.f = 2;
        return z;
    }

    public long c() {
        return this.m.b;
    }

    public int a(g gVar, l lVar) throws IOException, InterruptedException {
        while (true) {
            int i2 = this.f;
            boolean z = false;
            if (i2 == 1) {
                if (!((com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) gVar).b(this.b.a, 0, 9, true)) {
                    return -1;
                }
                this.b.e(0);
                this.b.f(4);
                int l2 = this.b.l();
                boolean z2 = (l2 & 4) != 0;
                if ((l2 & 1) != 0) {
                    z = true;
                }
                if (z2 && this.k == null) {
                    this.k = new a(this.e.a(8, 1));
                }
                if (z && this.l == null) {
                    this.l = new e(this.e.a(9, 2));
                }
                if (this.m == null) {
                    this.m = new c((n) null);
                }
                this.e.c();
                this.e.a(this);
                this.g = this.b.c() - 5;
                this.f = 2;
            } else if (i2 == 2) {
                ((com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) gVar).c(this.g);
                this.g = 0;
                this.f = 3;
            } else if (i2 == 3) {
                if (!((com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) gVar).b(this.c.a, 0, 11, true)) {
                    return -1;
                }
                this.c.e(0);
                this.h = this.c.l();
                this.i = this.c.n();
                this.j = (long) this.c.n();
                this.j = (((long) (this.c.l() << 24)) | this.j) * 1000;
                this.c.f(3);
                this.f = 4;
            } else if (i2 == 4 && c(gVar)) {
                return 0;
            }
        }
    }
}
