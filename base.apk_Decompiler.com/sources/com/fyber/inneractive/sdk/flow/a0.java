package com.fyber.inneractive.sdk.flow;

import com.fyber.inneractive.sdk.util.b1;
import com.fyber.inneractive.sdk.util.q;

public class a0 implements b1.b {
    public final /* synthetic */ z a;

    public a0(z zVar) {
        this.a = zVar;
    }

    public void a(b1 b1Var) {
        Runnable runnable = this.a.o;
        if (runnable != null) {
            q.b.post(runnable);
        }
        z zVar = this.a;
        b1 b1Var2 = zVar.p;
        if (b1Var2 != null) {
            b1Var2.e = null;
            zVar.p = null;
        }
    }
}
