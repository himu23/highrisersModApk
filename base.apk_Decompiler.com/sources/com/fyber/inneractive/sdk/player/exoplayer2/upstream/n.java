package com.fyber.inneractive.sdk.player.exoplayer2.upstream;

import android.content.Context;
import com.fyber.inneractive.sdk.player.exoplayer2.upstream.g;

public final class n implements g.a {
    public final Context a;
    public final a0<? super g> b;
    public final g.a c;

    public n(Context context, a0<? super g> a0Var, g.a aVar) {
        this.a = context.getApplicationContext();
        this.b = a0Var;
        this.c = aVar;
    }

    public g a() {
        return new m(this.a, this.b, this.c.a());
    }
}
