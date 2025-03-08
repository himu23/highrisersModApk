package com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls;

import com.fyber.inneractive.sdk.player.exoplayer2.decoder.b;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.d;
import com.fyber.inneractive.sdk.player.exoplayer2.j;
import com.fyber.inneractive.sdk.player.exoplayer2.source.e;
import com.fyber.inneractive.sdk.player.exoplayer2.source.f;
import com.fyber.inneractive.sdk.player.exoplayer2.source.o;
import java.io.IOException;

public final class i implements o {
    public final int a;
    public final j b;

    public i(j jVar, int i) {
        this.b = jVar;
        this.a = i;
    }

    public void a() throws IOException {
        this.b.j();
    }

    public boolean isReady() {
        j jVar = this.b;
        return jVar.y || (!jVar.h() && !jVar.j.valueAt(this.a).f());
    }

    public int a(j jVar, b bVar, boolean z) {
        j jVar2 = this.b;
        int i = this.a;
        if (jVar2.h()) {
            return -3;
        }
        loop0:
        while (jVar2.k.size() > 1) {
            int i2 = jVar2.k.getFirst().j;
            for (int i3 = 0; i3 < jVar2.j.size(); i3++) {
                if (jVar2.v[i3]) {
                    d.c cVar = jVar2.j.valueAt(i3).c;
                    if ((cVar.i == 0 ? cVar.r : cVar.b[cVar.k]) == i2) {
                        break loop0;
                    }
                }
            }
            jVar2.k.removeFirst();
        }
        f first = jVar2.k.getFirst();
        com.fyber.inneractive.sdk.player.exoplayer2.i iVar = first.c;
        if (!iVar.equals(jVar2.q)) {
            f.a aVar = jVar2.h;
            int i4 = jVar2.a;
            int i5 = first.d;
            Object obj = first.e;
            long j = first.f;
            if (aVar.b != null) {
                aVar.a.post(new e(aVar, i4, iVar, i5, obj, j));
            }
        }
        jVar2.q = iVar;
        return jVar2.j.valueAt(i).a(jVar, bVar, z, jVar2.y, jVar2.w);
    }

    public void a(long j) {
        j jVar = this.b;
        d valueAt = jVar.j.valueAt(this.a);
        if (!jVar.y || j <= valueAt.d()) {
            valueAt.a(j, true);
        } else {
            valueAt.g();
        }
    }
}
