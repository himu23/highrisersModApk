package com.fyber.inneractive.sdk.player.cache;

import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.network.t;
import com.fyber.inneractive.sdk.player.cache.c;
import com.fyber.inneractive.sdk.player.cache.h;
import com.fyber.inneractive.sdk.response.e;
import com.fyber.inneractive.sdk.util.IAlog;
import java.io.IOException;

public class f implements Runnable {
    public final /* synthetic */ h a;

    public f(h hVar) {
        this.a = hVar;
    }

    public void run() {
        try {
            h hVar = this.a;
            c.f b = hVar.b.b(hVar.a());
            h hVar2 = this.a;
            hVar2.c = b;
            if (b == null) {
                c.C0107c a2 = hVar2.b.a(hVar2.a());
                if (a2 == null) {
                    boolean unused = this.a.n = true;
                }
                if (a2 != null) {
                    h hVar3 = this.a;
                    IAlog.d("%s | start | got an editor for %s", hVar3.a, hVar3.a());
                    a2.a();
                }
            }
        } catch (IOException e) {
            h hVar4 = this.a;
            IAlog.a(String.format("%s | Exception raised starting a new caching process for %s", new Object[]{hVar4.a, hVar4.a()}), e, new Object[0]);
            t.a("Exception raised starting a new caching process", e.getMessage(), (InneractiveAdRequest) null, (e) null);
        }
        h hVar5 = this.a;
        if (hVar5.c != null || hVar5.n) {
            h.b(hVar5, true);
            return;
        }
        h.f fVar = hVar5.h;
        if (fVar != null) {
            fVar.start();
        }
    }
}
