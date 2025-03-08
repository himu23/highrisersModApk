package com.fyber.inneractive.sdk.player.exoplayer2.source;

import android.net.Uri;
import android.os.Handler;
import android.util.Pair;
import com.fyber.inneractive.sdk.player.exoplayer2.e;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.i;
import com.fyber.inneractive.sdk.player.exoplayer2.h;
import com.fyber.inneractive.sdk.player.exoplayer2.p;
import com.fyber.inneractive.sdk.player.exoplayer2.source.i;
import com.fyber.inneractive.sdk.player.exoplayer2.source.n;
import com.fyber.inneractive.sdk.player.exoplayer2.upstream.b;
import com.fyber.inneractive.sdk.player.exoplayer2.upstream.g;
import com.fyber.inneractive.sdk.player.exoplayer2.upstream.x;
import java.io.IOException;

public final class l implements n, n.a {
    public final Uri a;
    public final g.a b;
    public final i c;
    public final int d;
    public final Handler e;
    public final a f;
    public final p.b g = new p.b();
    public n.a h;
    public boolean i;

    public interface a {
    }

    public l(Uri uri, g.a aVar, i iVar, int i2, Handler handler, a aVar2, String str) {
        this.a = uri;
        this.b = aVar;
        this.c = iVar;
        this.d = i2;
        this.e = handler;
        this.f = aVar2;
    }

    public void a() throws IOException {
    }

    public void b() {
        this.h = null;
    }

    public void a(e eVar, boolean z, n.a aVar) {
        this.h = aVar;
        ((h) aVar).f.obtainMessage(7, Pair.create(new q(-9223372036854775807L, false), (Object) null)).sendToTarget();
    }

    public m a(int i2, b bVar, long j) {
        com.fyber.inneractive.sdk.player.exoplayer2.util.a.a(i2 == 0);
        return new i(this.a, this.b.a(), this.c.a(), this.d, this.e, this.f, this, bVar, (String) null);
    }

    public void a(m mVar) {
        i iVar = (i) mVar;
        i.d dVar = iVar.j;
        x xVar = iVar.i;
        j jVar = new j(iVar, dVar);
        x.b<? extends x.c> bVar = xVar.b;
        if (bVar != null) {
            bVar.a(true);
        }
        xVar.a.execute(jVar);
        xVar.a.shutdown();
        iVar.n.removeCallbacksAndMessages((Object) null);
        iVar.G = true;
    }

    public void a(p pVar, Object obj) {
        boolean z = false;
        if (pVar.a(0, this.g, false).d != -9223372036854775807L) {
            z = true;
        }
        if (!this.i || z) {
            this.i = z;
            this.h.a(pVar, (Object) null);
        }
    }
}
