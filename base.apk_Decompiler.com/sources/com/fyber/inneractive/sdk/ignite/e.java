package com.fyber.inneractive.sdk.ignite;

import com.fyber.inneractive.sdk.util.IAlog;

public class e implements Runnable {
    public final /* synthetic */ c a;

    public e(c cVar) {
        this.a = cVar;
    }

    public void run() {
        c cVar = this.a;
        IAlog.a("onInstallTimeout after %d msec", Long.valueOf(cVar.p));
        for (n next : cVar.i) {
            if (next != null) {
                next.b((String) null, i.INSTALL_TIMEOUT.e(), (String) null);
            }
        }
    }
}
