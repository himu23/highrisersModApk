package com.fyber.inneractive.sdk.ignite;

import com.fyber.inneractive.sdk.network.w;
import com.fyber.inneractive.sdk.util.IAlog;

public class f implements w<String> {
    public final /* synthetic */ String a;

    public f(c cVar, String str) {
        this.a = str;
    }

    public void a(Object obj, Exception exc, boolean z) {
        String str = (String) obj;
        IAlog.a("Hit Request: Hitting URL finished: %s", this.a);
        if (exc == null) {
            IAlog.a("Hit Request: Hitting URL response code: %s", str);
            return;
        }
        IAlog.a("Hit Request: Hitting URL failed: %s", exc);
    }
}
