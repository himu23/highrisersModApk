package com.fyber.inneractive.sdk.player.ui;

import androidx.work.impl.Scheduler;

public class n implements Runnable {
    public final /* synthetic */ l a;

    public n(l lVar) {
        this.a = lVar;
    }

    public void run() {
        l lVar = this.a;
        int i = lVar.E + Scheduler.MAX_GREEDY_SCHEDULER_LIMIT;
        lVar.E = i;
        lVar.x.setProgress(i);
        l lVar2 = this.a;
        if (lVar2.E == lVar2.F) {
            lVar2.G = null;
            lVar2.E = 0;
            lVar2.F = 0;
            return;
        }
        lVar2.postDelayed(lVar2.G, 200);
    }
}
