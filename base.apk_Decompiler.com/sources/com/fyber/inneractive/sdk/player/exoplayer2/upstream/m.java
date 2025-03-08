package com.fyber.inneractive.sdk.player.exoplayer2.upstream;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.applovin.sdk.AppLovinEventTypes;
import com.fyber.inneractive.sdk.player.exoplayer2.util.a;
import com.fyber.inneractive.sdk.player.exoplayer2.util.u;
import com.ironsource.m2;
import java.io.IOException;

public final class m implements g {
    public final g a;
    public final g b;
    public final g c;
    public final g d;
    public g e;

    public m(Context context, a0<? super g> a0Var, g gVar) {
        this.a = (g) a.a(gVar);
        this.b = new q(a0Var);
        this.c = new c(context, a0Var);
        this.d = new e(context, a0Var);
    }

    public long a(j jVar) throws IOException {
        a.b(this.e == null);
        String scheme = jVar.a.getScheme();
        Uri uri = jVar.a;
        int i = u.a;
        String scheme2 = uri.getScheme();
        if (TextUtils.isEmpty(scheme2) || scheme2.equals(m2.h.b)) {
            if (jVar.a.getPath().startsWith("/android_asset/")) {
                this.e = this.c;
            } else {
                this.e = this.b;
            }
        } else if ("asset".equals(scheme)) {
            this.e = this.c;
        } else if (AppLovinEventTypes.USER_VIEWED_CONTENT.equals(scheme)) {
            this.e = this.d;
        } else {
            this.e = this.a;
        }
        return this.e.a(jVar);
    }

    public void close() throws IOException {
        g gVar = this.e;
        if (gVar != null) {
            try {
                gVar.close();
            } finally {
                this.e = null;
            }
        }
    }

    public int a(byte[] bArr, int i, int i2) throws IOException {
        return this.e.a(bArr, i, i2);
    }

    public Uri a() {
        g gVar = this.e;
        if (gVar == null) {
            return null;
        }
        return gVar.a();
    }
}
