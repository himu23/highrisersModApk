package com.applovin.exoplayer2.f;

import android.media.MediaCodec;
import com.applovin.exoplayer2.c.f;

public class h extends f {
    public final i Hk;
    public final String Hq;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public h(java.lang.Throwable r4, com.applovin.exoplayer2.f.i r5) {
        /*
            r3 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Decoder failed: "
            r0.<init>(r1)
            r1 = 0
            if (r5 != 0) goto L_0x000c
            r2 = r1
            goto L_0x000e
        L_0x000c:
            java.lang.String r2 = r5.name
        L_0x000e:
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            r3.<init>(r0, r4)
            r3.Hk = r5
            int r5 = com.applovin.exoplayer2.l.ai.acV
            r0 = 21
            if (r5 < r0) goto L_0x0024
            java.lang.String r1 = g(r4)
        L_0x0024:
            r3.Hq = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.f.h.<init>(java.lang.Throwable, com.applovin.exoplayer2.f.i):void");
    }

    private static String g(Throwable th) {
        if (th instanceof MediaCodec.CodecException) {
            return ((MediaCodec.CodecException) th).getDiagnosticInfo();
        }
        return null;
    }
}
