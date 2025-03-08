package com.fyber.inneractive.sdk.flow;

import com.fyber.inneractive.sdk.util.IAlog;

public class s implements Runnable {
    public final /* synthetic */ r a;

    public s(r rVar) {
        this.a = rVar;
    }

    public void run() {
        r rVar = this.a;
        rVar.getClass();
        IAlog.a("%sRe-enabling clicks, grace period has passed", IAlog.a((Object) rVar));
        boolean unused = this.a.g = true;
        this.a.h = null;
    }
}
