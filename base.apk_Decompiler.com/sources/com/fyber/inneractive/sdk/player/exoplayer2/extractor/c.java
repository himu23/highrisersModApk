package com.fyber.inneractive.sdk.player.exoplayer2.extractor;

import com.fyber.inneractive.sdk.player.exoplayer2.extractor.mkv.a;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.mkv.d;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp3.b;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.f;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.e;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.p;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.u;
import com.fyber.inneractive.sdk.player.exoplayer2.util.r;
import java.lang.reflect.Constructor;
import java.util.Collections;

public final class c implements i {
    public static final Constructor<? extends f> a;

    public synchronized f[] a() {
        f[] fVarArr;
        Constructor<? extends f> constructor = a;
        fVarArr = new f[(constructor == null ? 11 : 12)];
        fVarArr[0] = new d(new a(), 0);
        fVarArr[1] = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.d(0, (r) null);
        fVarArr[2] = new f();
        fVarArr[3] = new b(0, -9223372036854775807L);
        fVarArr[4] = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.c(0);
        fVarArr[5] = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.a(0);
        fVarArr[6] = new u(1, new r(0), new e(0, Collections.emptyList()));
        fVarArr[7] = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.flv.b();
        fVarArr[8] = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.ogg.c();
        fVarArr[9] = new p(new r(0));
        fVarArr[10] = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.wav.a();
        if (constructor != null) {
            try {
                fVarArr[11] = (f) constructor.newInstance(new Object[0]);
            } catch (Exception e) {
                throw new IllegalStateException("Unexpected error creating FLAC extractor", e);
            }
        }
        return fVarArr;
    }

    static {
        Constructor<? extends U> constructor;
        try {
            constructor = Class.forName("com.fyber.inneractive.sdk.player.exoplayer2.ext.flac.FlacExtractor").asSubclass(f.class).getConstructor(new Class[0]);
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            constructor = null;
        }
        a = constructor;
    }
}
