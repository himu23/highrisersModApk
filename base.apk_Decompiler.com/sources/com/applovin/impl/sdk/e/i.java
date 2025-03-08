package com.applovin.impl.sdk.e;

import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.d;

public class i extends d {
    private a aTY;

    public interface a {
        void b(d.a aVar);
    }

    public i(n nVar, a aVar) {
        super("TaskCollectAdvertisingId", nVar, true);
        this.aTY = aVar;
    }

    public void run() {
        this.aTY.b(this.sdk.BS().Di());
    }
}
