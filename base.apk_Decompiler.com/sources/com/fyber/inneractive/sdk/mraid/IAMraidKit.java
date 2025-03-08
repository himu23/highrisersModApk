package com.fyber.inneractive.sdk.mraid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.factories.a;
import com.fyber.inneractive.sdk.factories.b;
import com.fyber.inneractive.sdk.factories.c;
import com.fyber.inneractive.sdk.flow.b0;
import com.fyber.inneractive.sdk.flow.n;
import com.fyber.inneractive.sdk.renderers.g;
import com.fyber.inneractive.sdk.renderers.k;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.w;
import com.fyber.inneractive.sdk.util.x;

public class IAMraidKit extends BroadcastReceiver {
    private static final w sProvider = new a();

    public class a implements w {
        public x a() {
            return x.Mraid;
        }

        public boolean a(String str) {
            return false;
        }
    }

    public class b implements b.C0096b {
        public b(IAMraidKit iAMraidKit) {
        }

        public com.fyber.inneractive.sdk.interfaces.a a() {
            return new n();
        }

        public com.fyber.inneractive.sdk.response.b b() {
            return new com.fyber.inneractive.sdk.response.c();
        }
    }

    public class c implements c.a {
        public c() {
        }

        public boolean a(InneractiveAdSpot inneractiveAdSpot) {
            return IAMraidKit.this.isMRaidSpotContent(inneractiveAdSpot);
        }

        public com.fyber.inneractive.sdk.interfaces.c b(InneractiveAdSpot inneractiveAdSpot) {
            return new k();
        }
    }

    public class d implements a.C0095a {
        public d() {
        }

        public boolean a(InneractiveAdSpot inneractiveAdSpot) {
            return IAMraidKit.this.isMRaidSpotContent(inneractiveAdSpot);
        }

        public com.fyber.inneractive.sdk.interfaces.b b(InneractiveAdSpot inneractiveAdSpot) {
            return new g();
        }
    }

    /* access modifiers changed from: private */
    public boolean isMRaidSpotContent(InneractiveAdSpot inneractiveAdSpot) {
        return inneractiveAdSpot.getAdContent() != null && (inneractiveAdSpot.getAdContent() instanceof b0);
    }

    public void onReceive(Context context, Intent intent) {
        IAlog.a("IAMraidKit: onReceive in package: %s", context.getApplicationContext().getPackageName());
        w wVar = sProvider;
        IAConfigManager.M.I.put(wVar.a(), wVar);
        b bVar = new b(this);
        b.a.a.a(com.fyber.inneractive.sdk.response.a.RETURNED_ADTYPE_HTML, bVar);
        b.a.a.a(com.fyber.inneractive.sdk.response.a.RETURNED_ADTYPE_MRAID, bVar);
        com.fyber.inneractive.sdk.factories.c cVar = c.b.a;
        cVar.a.add(new c());
        com.fyber.inneractive.sdk.factories.a aVar = a.b.a;
        aVar.a.add(new d());
    }
}
