package com.fyber.inneractive.sdk.player.exoplayer2.upstream;

import android.net.Uri;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.d;
import com.fyber.inneractive.sdk.player.exoplayer2.upstream.x;
import com.fyber.inneractive.sdk.player.exoplayer2.util.u;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

public final class y<T> implements x.c {
    public final j a;
    public final g b;
    public final a<? extends T> c;
    public volatile T d;
    public volatile boolean e;
    public volatile long f;

    public interface a<T> {
    }

    public y(g gVar, Uri uri, int i, a<? extends T> aVar) {
        this.b = gVar;
        this.a = new j(uri, 1);
        this.c = aVar;
    }

    public final boolean a() {
        return this.e;
    }

    public final void b() {
        this.e = true;
    }

    public final void load() throws IOException, InterruptedException {
        i iVar = new i(this.b, this.a);
        try {
            if (!iVar.d) {
                iVar.a.a(iVar.b);
                iVar.d = true;
            }
            this.d = ((d) this.c).a(this.b.a(), (InputStream) iVar);
        } finally {
            this.f = iVar.f;
            u.a((Closeable) iVar);
        }
    }
}
