package com.fyber.inneractive.sdk.flow;

import com.fyber.inneractive.sdk.config.a0;
import com.fyber.inneractive.sdk.config.b0;
import com.fyber.inneractive.sdk.config.global.s;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.model.vast.b;
import com.fyber.inneractive.sdk.player.h;
import com.fyber.inneractive.sdk.response.g;
import com.fyber.inneractive.sdk.util.c0;

public class f0 extends p<g> {
    public h i;
    public boolean j = false;

    public f0(b0 b0Var, s sVar, g gVar, InneractiveAdRequest inneractiveAdRequest) {
        super(b0Var, sVar);
        a(gVar);
        a(inneractiveAdRequest);
    }

    public void a() {
        if (this.g != null && e()) {
            this.g.a();
            this.g = null;
        }
        h hVar = this.i;
        if (hVar != null) {
            hVar.a();
            this.i = null;
        }
    }

    public boolean e() {
        a0 a0Var = (a0) this.d;
        if (a0Var.f == null) {
            return false;
        }
        return c0.a(a0Var.f.j);
    }

    public boolean g() {
        return this.i != null;
    }

    public boolean isVideoAd() {
        return true;
    }

    public String k() {
        b bVar;
        T t = this.b;
        if (t == null || (bVar = ((g) t).K) == null) {
            return null;
        }
        return bVar.b;
    }
}
