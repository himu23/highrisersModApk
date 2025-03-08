package com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls;

import android.net.Uri;
import android.os.Handler;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.a;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.e;
import com.fyber.inneractive.sdk.player.exoplayer2.source.f;
import com.fyber.inneractive.sdk.player.exoplayer2.source.m;
import com.fyber.inneractive.sdk.player.exoplayer2.source.n;
import com.fyber.inneractive.sdk.player.exoplayer2.upstream.b;
import com.fyber.inneractive.sdk.player.exoplayer2.upstream.g;
import com.fyber.inneractive.sdk.player.exoplayer2.upstream.y;
import com.fyber.inneractive.sdk.player.exoplayer2.util.a;
import java.io.IOException;

public final class h implements n, e.C0118e {
    public final Uri a;
    public final d b;
    public final f.a c;
    public e d;
    public n.a e;

    public h(Uri uri, g.a aVar, int i, Handler handler, f fVar) {
        this(uri, (d) new b(aVar), i, handler, fVar);
    }

    public void a(com.fyber.inneractive.sdk.player.exoplayer2.e eVar, boolean z, n.a aVar) {
        a.b(this.d == null);
        Uri uri = this.a;
        d dVar = this.b;
        e eVar2 = new e(uri, dVar, this.c, 3, this);
        this.d = eVar2;
        this.e = aVar;
        eVar2.i.a(new y(((b) dVar).a.a(), uri, 4, eVar2.c), eVar2, 3);
    }

    public h(Uri uri, d dVar, int i, Handler handler, f fVar) {
        this.a = uri;
        this.b = dVar;
        this.c = new f.a(handler, fVar);
    }

    public void b() {
        e eVar = this.d;
        if (eVar != null) {
            eVar.i.d();
            for (e.a aVar : eVar.e.values()) {
                aVar.b.d();
            }
            eVar.f.removeCallbacksAndMessages((Object) null);
            eVar.e.clear();
            this.d = null;
        }
        this.e = null;
    }

    public void a() throws IOException {
        e eVar = this.d;
        eVar.i.c();
        a.C0117a aVar = eVar.l;
        if (aVar != null) {
            e.a aVar2 = eVar.e.get(aVar);
            aVar2.b.c();
            IOException iOException = aVar2.j;
            if (iOException != null) {
                throw iOException;
            }
        }
    }

    public m a(int i, b bVar, long j) {
        com.fyber.inneractive.sdk.player.exoplayer2.util.a.a(i == 0);
        return new g(this.d, this.b, 3, this.c, bVar, j);
    }

    public void a(m mVar) {
        g gVar = (g) mVar;
        gVar.a.h.remove(gVar);
        gVar.h.removeCallbacksAndMessages((Object) null);
        j[] jVarArr = gVar.n;
        if (jVarArr != null) {
            for (j jVar : jVarArr) {
                int size = jVar.j.size();
                for (int i = 0; i < size; i++) {
                    jVar.j.valueAt(i).b();
                }
                jVar.g.d();
                jVar.m.removeCallbacksAndMessages((Object) null);
                jVar.s = true;
            }
        }
    }
}
