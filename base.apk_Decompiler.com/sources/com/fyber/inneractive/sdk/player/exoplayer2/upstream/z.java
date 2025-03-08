package com.fyber.inneractive.sdk.player.exoplayer2.upstream;

import android.net.Uri;
import com.fyber.inneractive.sdk.player.exoplayer2.util.a;
import java.io.IOException;

public final class z implements g {
    public final g a;
    public final f b;

    public z(g gVar, f fVar) {
        this.a = (g) a.a(gVar);
        this.b = (f) a.a(fVar);
    }

    public long a(j jVar) throws IOException {
        long a2 = this.a.a(jVar);
        if (jVar.e == -1 && a2 != -1) {
            jVar = new j(jVar.a, (byte[]) null, jVar.c, jVar.d, a2, jVar.f, jVar.g);
        }
        this.b.a(jVar);
        return a2;
    }

    public void close() throws IOException {
        try {
            this.a.close();
        } finally {
            this.b.close();
        }
    }

    public int a(byte[] bArr, int i, int i2) throws IOException {
        int a2 = this.a.a(bArr, i, i2);
        if (a2 > 0) {
            this.b.a(bArr, i, a2);
        }
        return a2;
    }

    public Uri a() {
        return this.a.a();
    }
}
