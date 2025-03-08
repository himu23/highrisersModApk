package com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts;

import android.util.Log;
import com.fyber.inneractive.sdk.player.exoplayer2.drm.a;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.h;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.n;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.v;
import com.fyber.inneractive.sdk.player.exoplayer2.i;
import com.fyber.inneractive.sdk.player.exoplayer2.util.k;

public final class l implements h {
    public final k a = new k(10);
    public n b;
    public boolean c;
    public long d;
    public int e;
    public int f;

    public void a() {
        this.c = false;
    }

    public void a(long j, boolean z) {
        if (z) {
            this.c = true;
            this.d = j;
            this.e = 0;
            this.f = 0;
        }
    }

    public void a(h hVar, v.d dVar) {
        dVar.a();
        n a2 = hVar.a(dVar.c(), 4);
        this.b = a2;
        a2.a(i.a(dVar.b(), "application/id3", (String) null, -1, (a) null));
    }

    public void b() {
        int i;
        if (this.c && (i = this.e) != 0 && this.f == i) {
            this.b.a(this.d, 1, i, 0, (byte[]) null);
            this.c = false;
        }
    }

    public void a(k kVar) {
        if (this.c) {
            int a2 = kVar.a();
            int i = this.f;
            if (i < 10) {
                int min = Math.min(a2, 10 - i);
                System.arraycopy(kVar.a, kVar.b, this.a.a, this.f, min);
                if (this.f + min == 10) {
                    this.a.e(0);
                    if (73 == this.a.l() && 68 == this.a.l() && 51 == this.a.l()) {
                        this.a.f(3);
                        this.e = this.a.k() + 10;
                    } else {
                        Log.w("Id3Reader", "Discarding invalid ID3 tag");
                        this.c = false;
                        return;
                    }
                }
            }
            int min2 = Math.min(a2, this.e - this.f);
            this.b.a(kVar, min2);
            this.f += min2;
        }
    }
}
