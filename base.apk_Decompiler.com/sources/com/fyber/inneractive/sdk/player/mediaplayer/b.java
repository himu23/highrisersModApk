package com.fyber.inneractive.sdk.player.mediaplayer;

import com.fyber.inneractive.sdk.player.controller.g;
import com.fyber.inneractive.sdk.player.mediaplayer.a;

public class b implements Runnable {
    public final /* synthetic */ com.fyber.inneractive.sdk.player.enums.b a;
    public final /* synthetic */ a b;

    public b(a aVar, com.fyber.inneractive.sdk.player.enums.b bVar) {
        this.b = aVar;
        this.a = bVar;
    }

    public void run() {
        a.k kVar = this.b.i;
        if (kVar != null) {
            ((g) kVar).a(this.a);
        }
    }
}
