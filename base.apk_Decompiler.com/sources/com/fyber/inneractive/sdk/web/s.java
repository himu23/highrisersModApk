package com.fyber.inneractive.sdk.web;

import com.fyber.inneractive.sdk.flow.p;
import com.fyber.inneractive.sdk.ignite.i;
import com.fyber.inneractive.sdk.ignite.j;
import com.fyber.inneractive.sdk.network.q;
import com.fyber.inneractive.sdk.util.IAlog;

public class s implements Runnable {
    public final /* synthetic */ r a;

    public s(r rVar) {
        this.a = rVar;
    }

    public void run() {
        r rVar = this.a;
        rVar.a.stopLoading();
        IAlog.a("%sonLoadTimeout after %d msec", IAlog.a((Object) rVar), Long.valueOf(rVar.n));
        j jVar = rVar.h;
        if (jVar != null && rVar.d != null) {
            ((p.a) jVar).a(q.IGNITE_FLOW_FAILED_TO_LOAD_WEBPAGE, rVar.k, i.LOAD_WEBPAGE_TIMEOUT.e(), rVar.d);
        }
    }
}
