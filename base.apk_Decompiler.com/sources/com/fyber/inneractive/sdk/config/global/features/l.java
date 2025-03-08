package com.fyber.inneractive.sdk.config.global.features;

import com.fyber.inneractive.sdk.util.IAlog;
import com.ironsource.y8;

public class l extends g {
    public l() {
        super("omsdk");
    }

    public g b() {
        l lVar = new l();
        a((g) lVar);
        return lVar;
    }

    public boolean d() {
        boolean a = a(y8.h, false);
        IAlog.a("OMSDK AB %s", String.valueOf(a));
        return a;
    }
}
