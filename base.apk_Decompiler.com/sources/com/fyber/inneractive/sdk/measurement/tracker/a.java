package com.fyber.inneractive.sdk.measurement.tracker;

import android.webkit.WebView;
import com.fyber.inneractive.sdk.flow.q;
import com.fyber.inneractive.sdk.util.IAlog;
import com.iab.omid.library.fyber.adsession.AdEvents;
import com.iab.omid.library.fyber.adsession.AdSessionConfiguration;
import com.iab.omid.library.fyber.adsession.CreativeType;
import com.iab.omid.library.fyber.adsession.ImpressionType;
import com.iab.omid.library.fyber.adsession.Owner;
import com.iab.omid.library.fyber.adsession.Partner;

public class a extends c {
    public a(Partner partner, WebView webView, q qVar) {
        super(partner, webView, qVar);
    }

    public void a(WebView webView) {
        super.a(webView);
        AdEvents createAdEvents = AdEvents.createAdEvents(this.a);
        this.b = createAdEvents;
        createAdEvents.loaded();
    }

    public void b() {
        IAlog.e("%s Unsupported functionality for non video MRAID ads", IAlog.a((Object) this));
    }

    public AdSessionConfiguration c() {
        try {
            return AdSessionConfiguration.createAdSessionConfiguration(CreativeType.HTML_DISPLAY, ImpressionType.UNSPECIFIED, Owner.NATIVE, Owner.NONE, false);
        } catch (Throwable th) {
            a(th);
            return null;
        }
    }

    public void a() {
        AdEvents adEvents;
        if (!this.d && this.a != null && (adEvents = this.b) != null) {
            this.d = true;
            try {
                adEvents.impressionOccurred();
            } catch (Throwable th) {
                a(th);
            }
        }
    }
}
