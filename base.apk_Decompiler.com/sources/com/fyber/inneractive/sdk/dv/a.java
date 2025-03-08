package com.fyber.inneractive.sdk.dv;

import com.fyber.inneractive.sdk.config.b0;
import com.fyber.inneractive.sdk.config.global.s;
import com.fyber.inneractive.sdk.dv.banner.b;
import com.fyber.inneractive.sdk.flow.q;
import com.fyber.inneractive.sdk.response.e;
import com.google.android.gms.ads.AdRequest;

public abstract class a<T> extends q<f> {
    public d g;
    public b h;
    public T i;

    public a(b0 b0Var, s sVar, f fVar) {
        super(b0Var, sVar);
        a(fVar);
    }

    public void a() {
        this.g = null;
        this.i = null;
    }

    public void a(AdRequest adRequest, d dVar) {
        this.g = dVar;
    }

    public e d() {
        return (f) this.b;
    }

    public boolean g() {
        return false;
    }

    public boolean isVideoAd() {
        return false;
    }
}
