package com.fyber.inneractive.sdk.player.exoplayer2.extractor.wav;

import android.util.Log;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.b;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.g;
import com.fyber.inneractive.sdk.player.exoplayer2.l;
import com.fyber.inneractive.sdk.player.exoplayer2.util.k;
import com.fyber.inneractive.sdk.player.exoplayer2.util.u;
import java.io.IOException;

public final class c {

    public static final class a {
        public final int a;
        public final long b;

        public a(int i, long j) {
            this.a = i;
            this.b = j;
        }

        public static a a(g gVar, k kVar) throws IOException, InterruptedException {
            ((b) gVar).a(kVar.a, 0, 8, false);
            kVar.e(0);
            return new a(kVar.c(), kVar.f());
        }
    }

    public static b a(g gVar) throws IOException, InterruptedException {
        gVar.getClass();
        k kVar = new k(16);
        if (a.a(gVar, kVar).a != u.a("RIFF")) {
            return null;
        }
        b bVar = (b) gVar;
        bVar.a(kVar.a, 0, 4, false);
        kVar.e(0);
        int c = kVar.c();
        if (c != u.a("WAVE")) {
            Log.e("WavHeaderReader", "Unsupported RIFF format: " + c);
            return null;
        }
        a a2 = a.a(gVar, kVar);
        while (a2.a != u.a("fmt ")) {
            bVar.a((int) a2.b, false);
            a2 = a.a(gVar, kVar);
        }
        com.fyber.inneractive.sdk.player.exoplayer2.util.a.b(a2.b >= 16);
        bVar.a(kVar.a, 0, 16, false);
        kVar.e(0);
        int h = kVar.h();
        int h2 = kVar.h();
        int g = kVar.g();
        int g2 = kVar.g();
        int h3 = kVar.h();
        int h4 = kVar.h();
        int i = (h2 * h4) / 8;
        if (h3 == i) {
            int a3 = u.a(h4);
            if (a3 == 0) {
                Log.e("WavHeaderReader", "Unsupported WAV bit depth: " + h4);
                return null;
            } else if (h == 1 || h == 65534) {
                bVar.a(((int) a2.b) - 16, false);
                return new b(h2, g, g2, h3, h4, a3);
            } else {
                Log.e("WavHeaderReader", "Unsupported WAV format type: " + h);
                return null;
            }
        } else {
            throw new l("Expected block alignment: " + i + "; got: " + h3);
        }
    }
}
