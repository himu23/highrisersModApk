package com.fyber.inneractive.sdk.flow;

import android.webkit.WebView;
import com.fyber.inneractive.sdk.config.b0;
import com.fyber.inneractive.sdk.external.InneractiveError;
import com.fyber.inneractive.sdk.external.InneractiveErrorCode;
import com.fyber.inneractive.sdk.external.InneractiveInfrastructureError;
import com.fyber.inneractive.sdk.external.InneractiveVideoError;
import com.fyber.inneractive.sdk.measurement.d;
import com.fyber.inneractive.sdk.measurement.f;
import com.fyber.inneractive.sdk.model.vast.b;
import com.fyber.inneractive.sdk.model.vast.t;
import com.fyber.inneractive.sdk.player.a;
import com.fyber.inneractive.sdk.player.e;
import com.fyber.inneractive.sdk.player.h;
import com.fyber.inneractive.sdk.response.g;
import com.fyber.inneractive.sdk.response.i;
import com.fyber.inneractive.sdk.util.IAlog;
import com.iab.omid.library.fyber.adsession.AdEvents;
import com.iab.omid.library.fyber.adsession.AdSession;
import com.iab.omid.library.fyber.adsession.AdSessionConfiguration;
import com.iab.omid.library.fyber.adsession.AdSessionContext;
import com.iab.omid.library.fyber.adsession.CreativeType;
import com.iab.omid.library.fyber.adsession.ImpressionType;
import com.iab.omid.library.fyber.adsession.Owner;
import com.iab.omid.library.fyber.adsession.VerificationScriptResource;
import com.iab.omid.library.fyber.adsession.media.MediaEvents;
import com.iab.omid.library.fyber.publisher.AdSessionStatePublisher;
import java.util.List;
import org.json.JSONObject;

public class o extends h<g, f0> implements h.b {
    public h m;

    public o(String str) {
    }

    public void a() {
        d();
        this.k.a();
        this.m.a();
    }

    public String f() {
        return "send_failed_vast_creatives";
    }

    public void j() {
        b bVar;
        b bVar2;
        AdSessionConfiguration adSessionConfiguration;
        b bVar3;
        IAlog.a(IAlog.a((Object) this) + "start called", new Object[0]);
        b0 g = g();
        Response response = this.b;
        AdSessionContext adSessionContext = null;
        if (response == null) {
            bVar = null;
        } else {
            bVar = ((g) response).K;
        }
        if (bVar != null && bVar.d.size() < bVar.i) {
            bVar.d.clear();
            bVar.g.clear();
            bVar.d.addAll(bVar.k);
            bVar.g.addAll(bVar.l);
        }
        Content f0Var = new f0(g, this.g, (g) this.b, this.a);
        this.c = f0Var;
        g gVar = (g) this.b;
        h hVar = new h(gVar, this.a, f0Var, this);
        this.m = hVar;
        f0 f0Var2 = (f0) this.c;
        f0Var2.i = hVar;
        f0Var2.f = this.h;
        hVar.e = null;
        if (!(gVar == null || (bVar3 = gVar.K) == null)) {
            hVar.e = bVar3.d.poll();
        }
        if (hVar.e == null) {
            hVar.b();
            h.b bVar4 = hVar.d;
            InneractiveInfrastructureError inneractiveInfrastructureError = new InneractiveInfrastructureError(InneractiveErrorCode.SDK_INTERNAL_ERROR, g.VAST_NO_MEDIA_FILES);
            o oVar = (o) bVar4;
            oVar.a((InneractiveError) inneractiveInfrastructureError);
            oVar.a(inneractiveInfrastructureError);
            return;
        }
        hVar.e();
        a.C0105a aVar = hVar.f;
        if (aVar != null) {
            e eVar = (e) aVar;
            if (eVar.g != null) {
                d dVar = new d();
                com.fyber.inneractive.sdk.measurement.a aVar2 = eVar.g;
                List<f> list = eVar.v.e;
                f0 f0Var3 = eVar.e;
                try {
                    CreativeType creativeType = CreativeType.VIDEO;
                    ImpressionType impressionType = ImpressionType.UNSPECIFIED;
                    Owner owner = Owner.NATIVE;
                    adSessionConfiguration = AdSessionConfiguration.createAdSessionConfiguration(creativeType, impressionType, owner, owner, false);
                } catch (Throwable th) {
                    dVar.a(th);
                }
                List<VerificationScriptResource> a = dVar.a(list);
                if (!(((com.fyber.inneractive.sdk.measurement.b) aVar2).e == null || ((com.fyber.inneractive.sdk.measurement.b) aVar2).b == null)) {
                    try {
                        adSessionContext = AdSessionContext.createNativeAdSessionContext(((com.fyber.inneractive.sdk.measurement.b) aVar2).e, ((com.fyber.inneractive.sdk.measurement.b) aVar2).b, a, "", "");
                    } catch (Throwable th2) {
                        dVar.a(th2);
                    }
                }
                AdSession createAdSession = AdSession.createAdSession(adSessionConfiguration, adSessionContext);
                dVar.a = createAdSession;
                AdSessionStatePublisher adSessionStatePublisher = createAdSession.getAdSessionStatePublisher();
                if (adSessionStatePublisher != null) {
                    adSessionStatePublisher.getWebView();
                    WebView webView = adSessionStatePublisher.getWebView();
                    if (webView != null) {
                        webView.setWebViewClient(dVar.g);
                    }
                }
                dVar.b = AdEvents.createAdEvents(dVar.a);
                dVar.c = MediaEvents.createMediaEvents(dVar.a);
                dVar.a.start();
                dVar.f = f0Var3;
                eVar.h = dVar;
                eVar.i = new com.fyber.inneractive.sdk.player.f(dVar);
            }
            if (eVar.h == null && (bVar2 = eVar.v) != null) {
                for (f next : bVar2.e) {
                    com.fyber.inneractive.sdk.measurement.g gVar2 = com.fyber.inneractive.sdk.measurement.g.ERROR_DURING_RESOURCE_LOAD;
                    t tVar = t.EVENT_VERIFICATION_NOT_EXECUTED;
                    e.a((i) new com.fyber.inneractive.sdk.measurement.e(next, next.a(tVar), gVar2), tVar);
                }
            }
        }
        hVar.d();
    }

    public void b() {
        InneractiveVideoError inneractiveVideoError;
        if (this.m != null) {
            Response response = this.b;
            if (response != null) {
                g gVar = (g) response;
                if (gVar.K != null) {
                    inneractiveVideoError = gVar.K.d.size() == 0 ? new InneractiveVideoError(InneractiveVideoError.Error.ERROR_FAILED_PLAYING_ALL_MEDIA_FILES, (Throwable) null) : new InneractiveVideoError(InneractiveVideoError.Error.ERROR_FAILED_PLAYING_MEDIA_FILE, (Throwable) null);
                    this.m.a(inneractiveVideoError, (InneractiveErrorCode) null, (JSONObject) null, true);
                }
            }
            inneractiveVideoError = null;
            this.m.a(inneractiveVideoError, (InneractiveErrorCode) null, (JSONObject) null, true);
        }
        a();
        super.b();
    }
}
