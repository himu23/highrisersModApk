package com.fyber.inneractive.sdk.flow.vast;

import com.fyber.inneractive.sdk.web.a0;
import com.fyber.inneractive.sdk.web.b;

public class c extends e {
    public boolean h = false;
    public boolean i = false;
    public boolean j = false;

    public c(com.fyber.inneractive.sdk.player.controller.c cVar) {
        super(cVar);
    }

    public String b() {
        b bVar;
        a0 a0Var = this.g.a;
        if (!(a0Var instanceof com.fyber.inneractive.sdk.web.c) || (bVar = ((com.fyber.inneractive.sdk.web.c) a0Var).O) == null) {
            return null;
        }
        return bVar.b;
    }
}
