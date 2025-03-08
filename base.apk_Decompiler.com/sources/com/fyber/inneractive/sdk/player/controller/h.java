package com.fyber.inneractive.sdk.player.controller;

import com.fyber.inneractive.sdk.player.controller.g;
import com.fyber.inneractive.sdk.util.IAlog;

public class h implements Runnable {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ g b;

    public h(g gVar, boolean z) {
        this.b = gVar;
        this.a = z;
    }

    public void run() {
        g gVar = this.b;
        if (!gVar.g) {
            try {
                for (g.f e : gVar.b) {
                    e.e(this.a);
                }
            } catch (Exception e2) {
                if (IAlog.a <= 3) {
                    g gVar2 = this.b;
                    gVar2.getClass();
                    IAlog.a("%sonPlayerError callback threw an exception!", e2, IAlog.a((Object) gVar2));
                }
            }
        }
    }
}
