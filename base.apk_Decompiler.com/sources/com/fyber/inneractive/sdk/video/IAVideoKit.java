package com.fyber.inneractive.sdk.video;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.factories.a;
import com.fyber.inneractive.sdk.factories.b;
import com.fyber.inneractive.sdk.factories.c;
import com.fyber.inneractive.sdk.flow.f0;
import com.fyber.inneractive.sdk.flow.o;
import com.fyber.inneractive.sdk.player.cache.n;
import com.fyber.inneractive.sdk.renderers.h;
import com.fyber.inneractive.sdk.renderers.j;
import com.fyber.inneractive.sdk.renderers.m;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.w;
import com.fyber.inneractive.sdk.util.x;

public class IAVideoKit extends BroadcastReceiver {
    private static final w sProvider = new a();

    public class b implements b.C0096b {
        public b(IAVideoKit iAVideoKit) {
        }

        public com.fyber.inneractive.sdk.interfaces.a a() {
            return new o("Interstitial");
        }

        public com.fyber.inneractive.sdk.response.b b() {
            return new com.fyber.inneractive.sdk.response.d();
        }
    }

    public class c implements c.a {
        public c(IAVideoKit iAVideoKit) {
        }

        public boolean a(InneractiveAdSpot inneractiveAdSpot) {
            return inneractiveAdSpot.getAdContent() != null && (inneractiveAdSpot.getAdContent() instanceof f0);
        }

        public com.fyber.inneractive.sdk.interfaces.c b(InneractiveAdSpot inneractiveAdSpot) {
            InneractiveAdRequest inneractiveAdRequest = inneractiveAdSpot.getAdContent().a;
            boolean z = inneractiveAdRequest == null || inneractiveAdRequest.getAllowFullscreen();
            if (!inneractiveAdSpot.getAdContent().e() || !z) {
                return new j();
            }
            return new m();
        }
    }

    public class d implements a.C0095a {
        public d(IAVideoKit iAVideoKit) {
        }

        public boolean a(InneractiveAdSpot inneractiveAdSpot) {
            return inneractiveAdSpot.getAdContent() != null && (inneractiveAdSpot.getAdContent() instanceof f0);
        }

        public com.fyber.inneractive.sdk.interfaces.b b(InneractiveAdSpot inneractiveAdSpot) {
            return new h();
        }
    }

    public void onReceive(Context context, Intent intent) {
        w wVar = sProvider;
        IAConfigManager.M.I.put(wVar.a(), wVar);
        n nVar = n.f;
        Context applicationContext = context.getApplicationContext();
        nVar.getClass();
        if (applicationContext == null) {
            IAlog.e("context is null, would not start the video cache.", new Object[0]);
        } else if (!nVar.a()) {
            nVar.a = applicationContext;
            new Thread(nVar.e, "VideoCache").start();
        }
        IAlog.a("IAVideoKit: onReceive in package: %s", context.getApplicationContext().getPackageName());
        b.a.a.a(com.fyber.inneractive.sdk.response.a.RETURNED_ADTYPE_VAST, new b(this));
        com.fyber.inneractive.sdk.factories.c cVar = c.b.a;
        cVar.a.add(new c(this));
        com.fyber.inneractive.sdk.factories.a aVar = a.b.a;
        aVar.a.add(new d(this));
    }

    public class a implements w {
        public boolean a(String str) {
            if (TextUtils.equals(str, "vid_cache")) {
                return n.f.a();
            }
            return false;
        }

        public x a() {
            return x.Video;
        }
    }
}
