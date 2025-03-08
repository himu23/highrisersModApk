package com.fyber.inneractive.sdk.dv;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.dv.interstitial.d;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.factories.a;
import com.fyber.inneractive.sdk.factories.b;
import com.fyber.inneractive.sdk.factories.c;
import com.fyber.inneractive.sdk.util.IAlog;

public class c extends BroadcastReceiver {

    public class a implements b.C0096b {
        public a(c cVar) {
        }

        public com.fyber.inneractive.sdk.interfaces.a a() {
            return new b();
        }

        public com.fyber.inneractive.sdk.response.b b() {
            return new e();
        }
    }

    public class b implements c.a {
        public b(c cVar) {
        }

        public boolean a(InneractiveAdSpot inneractiveAdSpot) {
            return IAConfigManager.M.F != null && (inneractiveAdSpot.getAdContent() instanceof a);
        }

        public com.fyber.inneractive.sdk.interfaces.c b(InneractiveAdSpot inneractiveAdSpot) {
            InneractiveAdRequest inneractiveAdRequest = inneractiveAdSpot.getAdContent().a;
            boolean z = inneractiveAdRequest == null || inneractiveAdRequest.getAllowFullscreen();
            if (!inneractiveAdSpot.getAdContent().e() || !z) {
                return null;
            }
            if (inneractiveAdSpot.getAdContent().d().n == UnitDisplayType.INTERSTITIAL) {
                return new d();
            }
            return new com.fyber.inneractive.sdk.dv.rewarded.c();
        }
    }

    /* renamed from: com.fyber.inneractive.sdk.dv.c$c  reason: collision with other inner class name */
    public class C0091c implements a.C0095a {
        public C0091c() {
        }

        public boolean a(InneractiveAdSpot inneractiveAdSpot) {
            return c.a(c.this, inneractiveAdSpot);
        }

        public com.fyber.inneractive.sdk.interfaces.b b(InneractiveAdSpot inneractiveAdSpot) {
            return new com.fyber.inneractive.sdk.dv.banner.b();
        }
    }

    public static boolean a(c cVar, InneractiveAdSpot inneractiveAdSpot) {
        cVar.getClass();
        return inneractiveAdSpot.getAdContent() != null && (inneractiveAdSpot.getAdContent() instanceof a);
    }

    public void onReceive(Context context, Intent intent) {
        IAlog.a("DVKit: onReceive in package: %s", context.getApplicationContext().getPackageName());
        b.a.a.a(com.fyber.inneractive.sdk.response.a.RETURNED_ADTYPE_MOBILE_ADS, new a(this));
        com.fyber.inneractive.sdk.factories.c cVar = c.b.a;
        cVar.a.add(new b(this));
        com.fyber.inneractive.sdk.factories.a aVar = a.b.a;
        aVar.a.add(new C0091c());
    }
}
