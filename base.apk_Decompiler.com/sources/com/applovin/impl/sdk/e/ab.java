package com.applovin.impl.sdk.e;

import com.applovin.impl.sdk.n;

public class ab extends d {
    private final Runnable v;

    public ab(n nVar, String str, Runnable runnable) {
        this(nVar, false, str, runnable);
    }

    public ab(n nVar, boolean z, String str, Runnable runnable) {
        super("TaskRunnable:" + str, nVar, z);
        this.v = runnable;
    }

    public void run() {
        this.v.run();
    }
}
