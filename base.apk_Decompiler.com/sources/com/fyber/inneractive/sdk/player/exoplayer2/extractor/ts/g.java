package com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts;

import com.fyber.inneractive.sdk.player.exoplayer2.drm.a;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.h;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.n;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.v;
import com.fyber.inneractive.sdk.player.exoplayer2.i;
import com.fyber.inneractive.sdk.player.exoplayer2.util.k;
import java.util.Collections;
import java.util.List;

public final class g implements h {
    public final List<v.a> a;
    public final n[] b;
    public boolean c;
    public int d;
    public int e;
    public long f;

    public g(List<v.a> list) {
        this.a = list;
        this.b = new n[list.size()];
    }

    public void a() {
        this.c = false;
    }

    public void a(long j, boolean z) {
        if (z) {
            this.c = true;
            this.f = j;
            this.e = 0;
            this.d = 2;
        }
    }

    public void a(h hVar, v.d dVar) {
        for (int i = 0; i < this.b.length; i++) {
            v.a aVar = this.a.get(i);
            dVar.a();
            n a2 = hVar.a(dVar.c(), 3);
            a2.a(i.a(dVar.b(), "application/dvbsubs", (String) null, -1, (List<byte[]>) Collections.singletonList(aVar.b), aVar.a, (a) null));
            this.b[i] = a2;
        }
    }

    public void b() {
        if (this.c) {
            for (n a2 : this.b) {
                a2.a(this.f, 1, this.e, 0, (byte[]) null);
            }
            this.c = false;
        }
    }

    public void a(k kVar) {
        if (!this.c) {
            return;
        }
        if (this.d != 2 || a(kVar, 32)) {
            if (this.d != 1 || a(kVar, 0)) {
                int i = kVar.b;
                int a2 = kVar.a();
                for (n a3 : this.b) {
                    kVar.e(i);
                    a3.a(kVar, a2);
                }
                this.e += a2;
            }
        }
    }

    public final boolean a(k kVar, int i) {
        if (kVar.a() == 0) {
            return false;
        }
        if (kVar.l() != i) {
            this.c = false;
        }
        this.d--;
        return this.c;
    }
}
