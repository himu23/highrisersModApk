package com.fyber.inneractive.sdk.player.exoplayer2.source;

import com.fyber.inneractive.sdk.player.cache.h;
import com.fyber.inneractive.sdk.player.controller.d;
import com.fyber.inneractive.sdk.player.controller.u;
import com.fyber.inneractive.sdk.player.exoplayer2.source.l;
import java.io.IOException;

public class k implements Runnable {
    public final /* synthetic */ IOException a;
    public final /* synthetic */ i b;

    public k(i iVar, IOException iOException) {
        this.b = iVar;
        this.a = iOException;
    }

    public void run() {
        l.a aVar = this.b.e;
        IOException iOException = this.a;
        d dVar = (d) ((u) aVar).a.get();
        if (dVar != null && (iOException.getCause() instanceof h.g) && dVar.B) {
            dVar.a(dVar.E, dVar.D);
        }
    }
}
