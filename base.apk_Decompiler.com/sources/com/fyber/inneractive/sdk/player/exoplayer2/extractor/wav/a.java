package com.fyber.inneractive.sdk.player.exoplayer2.extractor.wav;

import android.util.Log;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.b;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.f;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.g;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.h;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.l;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.m;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.n;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.wav.c;
import com.fyber.inneractive.sdk.player.exoplayer2.i;
import com.fyber.inneractive.sdk.player.exoplayer2.util.k;
import com.fyber.inneractive.sdk.player.exoplayer2.util.u;
import java.io.IOException;
import java.util.List;

public final class a implements f, m {
    public h a;
    public n b;
    public b c;
    public int d;
    public int e;

    public void a(long j, long j2) {
        this.e = 0;
    }

    public boolean a() {
        return true;
    }

    public boolean a(g gVar) throws IOException, InterruptedException {
        return c.a(gVar) != null;
    }

    public void b() {
    }

    public long c() {
        b bVar = this.c;
        return ((bVar.h / ((long) bVar.d)) * 1000000) / ((long) bVar.b);
    }

    public void a(h hVar) {
        this.a = hVar;
        this.b = hVar.a(0, 1);
        this.c = null;
        hVar.c();
    }

    public int a(g gVar, l lVar) throws IOException, InterruptedException {
        g gVar2 = gVar;
        if (this.c == null) {
            b a2 = c.a(gVar);
            this.c = a2;
            if (a2 != null) {
                int i = a2.b;
                int i2 = a2.a;
                this.b.a(i.a((String) null, "audio/raw", (String) null, a2.e * i * i2, 32768, i2, i, a2.f, (List<byte[]>) null, (com.fyber.inneractive.sdk.player.exoplayer2.drm.a) null, 0, (String) null));
                this.d = this.c.d;
            } else {
                throw new com.fyber.inneractive.sdk.player.exoplayer2.l("Unsupported or unrecognized wav header.");
            }
        }
        b bVar = this.c;
        if (bVar.g == 0 || bVar.h == 0) {
            gVar.getClass();
            bVar.getClass();
            b bVar2 = (b) gVar2;
            bVar2.e = 0;
            k kVar = new k(8);
            c.a a3 = c.a.a(gVar2, kVar);
            while (a3.a != u.a("data")) {
                Log.w("WavHeaderReader", "Ignoring unknown WAV chunk: " + a3.a);
                long j = a3.b + 8;
                if (a3.a == u.a("RIFF")) {
                    j = 12;
                }
                if (j <= 2147483647L) {
                    bVar2.c((int) j);
                    a3 = c.a.a(gVar2, kVar);
                } else {
                    throw new com.fyber.inneractive.sdk.player.exoplayer2.l("Chunk is too large (~2GB+) to skip; id: " + a3.a);
                }
            }
            bVar2.c(8);
            long j2 = bVar2.c;
            long j3 = a3.b;
            bVar.g = j2;
            bVar.h = j3;
            this.a.a(this);
        }
        int a4 = this.b.a(gVar2, 32768 - this.e, true);
        if (a4 != -1) {
            this.e += a4;
        }
        int i3 = this.e;
        int i4 = this.d;
        int i5 = i3 / i4;
        if (i5 > 0) {
            b bVar3 = this.c;
            int i6 = i5 * i4;
            int i7 = i3 - i6;
            this.e = i7;
            this.b.a(((((b) gVar2).c - ((long) i3)) * 1000000) / ((long) bVar3.c), 1, i6, i7, (byte[]) null);
        }
        if (a4 == -1) {
            return -1;
        }
        return 0;
    }

    public long a(long j) {
        b bVar = this.c;
        long j2 = (long) bVar.d;
        return Math.min((((j * ((long) bVar.c)) / 1000000) / j2) * j2, bVar.h - j2) + bVar.g;
    }
}
