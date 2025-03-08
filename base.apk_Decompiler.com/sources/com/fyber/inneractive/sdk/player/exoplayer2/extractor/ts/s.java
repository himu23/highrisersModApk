package com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts;

import com.fyber.inneractive.sdk.player.exoplayer2.extractor.h;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.n;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.v;
import com.fyber.inneractive.sdk.player.exoplayer2.i;
import com.fyber.inneractive.sdk.player.exoplayer2.util.a;
import java.util.Collections;
import java.util.List;

public final class s {
    public final List<i> a;
    public final n[] b;

    public s(List<i> list) {
        this.a = list;
        this.b = new n[list.size()];
    }

    public void a(h hVar, v.d dVar) {
        for (int i = 0; i < this.b.length; i++) {
            dVar.a();
            n a2 = hVar.a(dVar.c(), 3);
            i iVar = this.a.get(i);
            String str = iVar.f;
            boolean z = "application/cea-608".equals(str) || "application/cea-708".equals(str);
            a.a(z, "Invalid closed caption mime type provided: " + str);
            String str2 = iVar.a;
            if (str2 == null) {
                str2 = dVar.b();
            }
            a2.a(i.a(str2, str, (String) null, -1, iVar.x, iVar.y, iVar.z, (com.fyber.inneractive.sdk.player.exoplayer2.drm.a) null, Long.MAX_VALUE, Collections.emptyList()));
            this.b[i] = a2;
        }
    }
}
