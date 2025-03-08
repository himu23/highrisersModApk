package com.fyber.inneractive.sdk.player;

import com.fyber.inneractive.sdk.player.controller.g;
import com.fyber.inneractive.sdk.util.IAlog;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public class d {
    public g a;
    public ScheduledThreadPoolExecutor b;
    public Runnable c;
    public boolean d = false;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            d dVar = d.this;
            dVar.getClass();
            IAlog.a("player progress monitor: run started", new Object[0]);
            int c = dVar.a.c();
            if (!dVar.d) {
                IAlog.a("run: 2 seconds passed? played for %d since last play started", Integer.valueOf(c));
                if (c >= 2000) {
                    IAlog.a("run: setting played 2 seconds flag", new Object[0]);
                    dVar.d = true;
                }
            }
            dVar.a.a(c);
        }
    }

    public d(g gVar) {
        this.a = gVar;
        this.c = new a();
    }
}
