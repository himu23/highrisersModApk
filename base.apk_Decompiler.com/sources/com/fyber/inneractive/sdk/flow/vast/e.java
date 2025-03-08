package com.fyber.inneractive.sdk.flow.vast;

import com.fyber.inneractive.sdk.player.controller.c;
import com.fyber.inneractive.sdk.web.a0;

public class e extends a {
    public final c g;

    public e(c cVar) {
        this.g = cVar;
        a(cVar.a());
    }

    public void a() {
        this.b = null;
        this.a = false;
        c cVar = this.g;
        a0 a0Var = cVar.a;
        if (a0Var != null) {
            a0Var.c();
            cVar.a = null;
        }
    }
}
