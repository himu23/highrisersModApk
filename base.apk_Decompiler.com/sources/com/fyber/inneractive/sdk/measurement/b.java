package com.fyber.inneractive.sdk.measurement;

import android.content.Context;
import com.fyber.inneractive.sdk.cache.e;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.measurement.tracker.d;
import com.fyber.inneractive.sdk.network.g0;
import com.fyber.inneractive.sdk.network.r0;
import com.fyber.inneractive.sdk.network.w;
import com.iab.omid.library.fyber.Omid;
import com.iab.omid.library.fyber.adsession.Partner;

public class b extends a {
    public String b;
    public String c;
    public String d;
    public Partner e;
    public final d f = new d();
    public w<String> g = new a();
    public w<String> h = new C0102b();
    public w<String> i = new c();

    public class a implements w<String> {
        public a() {
        }

        public void a(Object obj, Exception exc, boolean z) {
            String str = (String) obj;
            if (str != null) {
                b.this.b = str;
            }
        }
    }

    /* renamed from: com.fyber.inneractive.sdk.measurement.b$b  reason: collision with other inner class name */
    public class C0102b implements w<String> {
        public C0102b() {
        }

        public void a(Object obj, Exception exc, boolean z) {
            String str = (String) obj;
            if (str != null) {
                b.this.c = str;
            }
        }
    }

    public class c implements w<String> {
        public c() {
        }

        public void a(Object obj, Exception exc, boolean z) {
            String str = (String) obj;
            if (str != null) {
                b.this.d = str;
            }
        }
    }

    public static void a(b bVar, Context context) {
        bVar.getClass();
        bVar.a(context, String.format("https://cdn2.inner-active.mobi/client/ia-js-tags/omsdk/%s.js", new Object[]{Omid.getVersion()}), "omid-latest.js", bVar.g);
        bVar.a(context, String.format("https://cdn2.inner-active.mobi/client/ia-js-tags/omsdk/omid-session-client-%s.js", new Object[]{Omid.getVersion()}), "omid-session-client-latest.js", bVar.h);
        bVar.a(context, "https://cdn2.inner-active.mobi/client/ia-js-tags/omsdk/dt-omsdk-mraid-video-tracker.js", "dt-omsdk-mraid-video-tracker.js", bVar.i);
    }

    public final void a(Context context, String str, String str2, w<String> wVar) {
        g0 g0Var = new g0(wVar, context, new e(str, str2));
        IAConfigManager.M.s.a.offer(g0Var);
        g0Var.a(r0.QUEUED);
    }
}
