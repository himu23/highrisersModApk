package com.fyber.inneractive.sdk.network;

import com.fyber.inneractive.sdk.config.global.s;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.network.k;
import com.fyber.inneractive.sdk.response.e;

public class o extends k {
    public final e e;

    public o(s sVar, e eVar, String str, k.a aVar) {
        super(sVar, str, aVar);
        this.e = eVar;
    }

    public boolean c() {
        a((InneractiveAdRequest) null, this.e);
        return true;
    }
}
