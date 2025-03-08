package com.fyber.inneractive.sdk.flow;

import com.fyber.inneractive.sdk.config.a0;
import com.fyber.inneractive.sdk.config.global.s;
import com.fyber.inneractive.sdk.measurement.a;
import com.fyber.inneractive.sdk.measurement.tracker.c;
import com.fyber.inneractive.sdk.response.f;
import com.fyber.inneractive.sdk.ui.IAmraidWebViewController;

public class b0 extends p<f> {
    public IAmraidWebViewController i;

    public b0(com.fyber.inneractive.sdk.config.b0 b0Var, s sVar) {
        super(b0Var, sVar);
    }

    public void a() {
        if (this.g != null && e()) {
            this.g.a();
            this.g = null;
        }
        IAmraidWebViewController iAmraidWebViewController = this.i;
        if (iAmraidWebViewController != null) {
            a.C0101a aVar = iAmraidWebViewController.J;
            if (aVar != null) {
                ((c) aVar).a(false);
            }
            this.i.c();
            this.i = null;
        }
    }

    public boolean e() {
        com.fyber.inneractive.sdk.config.b0 b0Var = this.d;
        if (b0Var == null) {
            return false;
        }
        a0 a0Var = (a0) b0Var;
        if (a0Var.c == null || a0Var.c.b == null) {
            return false;
        }
        return a0Var.c.b.isFullscreenUnit();
    }

    public boolean isVideoAd() {
        return false;
    }

    public boolean g() {
        IAmraidWebViewController iAmraidWebViewController = this.i;
        return (iAmraidWebViewController == null || iAmraidWebViewController.b == null) ? false : true;
    }
}
