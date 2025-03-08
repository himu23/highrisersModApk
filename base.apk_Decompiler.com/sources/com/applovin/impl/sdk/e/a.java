package com.applovin.impl.sdk.e;

import android.content.Context;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.x;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class a implements Callable<Boolean> {
    private final Context E;
    protected final AtomicBoolean aTn = new AtomicBoolean();
    protected final x logger;
    protected final n sdk;
    protected final String tag;

    public Context rQ() {
        return this.E;
    }

    public a(String str, n nVar) {
        this.tag = str;
        this.sdk = nVar;
        this.logger = nVar.BN();
        this.E = n.getApplicationContext();
    }

    public void be(boolean z) {
        this.aTn.set(z);
    }
}
