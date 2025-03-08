package com.fyber.inneractive.sdk.renderers;

import android.content.Context;
import com.fyber.inneractive.sdk.activities.InneractiveRichMediaVideoPlayerActivityCore;
import com.fyber.inneractive.sdk.cache.session.enums.a;
import com.fyber.inneractive.sdk.config.enums.Orientation;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.external.InneractiveFullscreenAdEventsListener;
import com.fyber.inneractive.sdk.external.InneractiveUnitController;
import com.fyber.inneractive.sdk.external.WebViewRendererProcessHasGoneError;
import com.fyber.inneractive.sdk.interfaces.c;
import com.fyber.inneractive.sdk.mraid.b0;
import com.fyber.inneractive.sdk.network.j0;
import com.fyber.inneractive.sdk.network.u;
import com.fyber.inneractive.sdk.response.e;
import com.fyber.inneractive.sdk.response.f;
import com.fyber.inneractive.sdk.ui.IAmraidWebViewController;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.b0;
import com.fyber.inneractive.sdk.util.p;
import com.fyber.inneractive.sdk.util.p0;
import com.fyber.inneractive.sdk.web.b;
import com.fyber.inneractive.sdk.web.g;
import com.fyber.inneractive.sdk.web.i;

public class l implements i.m {
    public final /* synthetic */ k a;

    public l(k kVar) {
        this.a = kVar;
    }

    public void a(i iVar) {
        k kVar = this.a;
        kVar.getClass();
        IAlog.a("%sweb view callback: onExpand", IAlog.a((Object) kVar));
        boolean unused = this.a.D = true;
        this.a.S();
    }

    public void b(i iVar) {
        k kVar = this.a;
        kVar.getClass();
        IAlog.a("%sweb view callback: onResize", IAlog.a((Object) kVar));
    }

    public void c() {
        this.a.D();
    }

    public void b() {
        this.a.a((InneractiveUnitController.AdDisplayError) new WebViewRendererProcessHasGoneError());
        this.a.destroy();
    }

    public void a(i iVar, b0 b0Var) {
        k kVar = this.a;
        kVar.getClass();
        IAlog.a("%sweb view callback: onClose", IAlog.a((Object) kVar));
        k kVar2 = this.a;
        if (kVar2.D) {
            boolean unused = kVar2.D = false;
            this.a.S();
            return;
        }
        if (kVar2.G == UnitDisplayType.REWARDED) {
            kVar2.R();
        }
        c.a aVar = this.a.l;
        if (aVar != null) {
            aVar.dismissAd(true);
        }
    }

    public b0.a a(String str, p0 p0Var, b.a aVar) {
        f fVar;
        com.fyber.inneractive.sdk.cache.session.enums.b bVar;
        k kVar = this.a;
        kVar.getClass();
        IAlog.a("%sweb view callback: onClicked", IAlog.a((Object) kVar));
        Context context = p.a;
        c.a aVar2 = this.a.l;
        if (!(aVar2 == null || aVar2.getLayout() == null || this.a.l.getLayout().getContext() == null)) {
            context = this.a.l.getLayout().getContext();
        }
        if (context != null) {
            k kVar2 = this.a;
            if (kVar2.g) {
                AdContent adcontent = kVar2.b;
                if (adcontent == null) {
                    fVar = null;
                } else {
                    fVar = (f) ((com.fyber.inneractive.sdk.flow.b0) adcontent).b;
                }
                if (fVar != null) {
                    kVar2.a((e) fVar);
                }
                k kVar3 = this.a;
                a aVar3 = a.CLICK;
                if (kVar3.G == UnitDisplayType.REWARDED) {
                    bVar = com.fyber.inneractive.sdk.cache.session.enums.b.REWARDED_DISPLAY;
                } else {
                    bVar = com.fyber.inneractive.sdk.cache.session.enums.b.INTERSTITIAL_DISPLAY;
                }
                kVar3.a(aVar3, bVar);
                return this.a.a(context, str, p0Var, com.fyber.inneractive.sdk.util.i.DISPLAY);
            }
        }
        return new b0.a(b0.d.FAILED, new Exception("No context or no native click detected"), context == null ? "null" : context.getClass().getName());
    }

    public void a(String str, String str2) {
        k kVar = this.a;
        kVar.getClass();
        IAlog.a("%sweb view callback: onSuspiciousNoUserWebActionDetected", IAlog.a((Object) kVar));
        c.a aVar = this.a.l;
        if (aVar != null && aVar.getLayout() != null) {
            k kVar2 = this.a;
            if (!kVar2.E) {
                u.a(kVar2.l.getLayout().getContext(), str, str2, this.a.b);
                boolean unused = this.a.E = true;
                k kVar3 = this.a;
                kVar3.getClass();
                IAlog.a("%sreporting auto redirect", IAlog.a((Object) kVar3));
                return;
            }
            kVar2.getClass();
            IAlog.a("%sredirect already reported for this ad", IAlog.a((Object) kVar2));
        }
    }

    public void a(boolean z) {
        com.fyber.inneractive.sdk.cache.session.enums.b bVar;
        String str;
        if (z) {
            k kVar = this.a;
            if (!kVar.y) {
                kVar.y = true;
                if (kVar.b != null) {
                    IAmraidWebViewController iAmraidWebViewController = kVar.z;
                    if (iAmraidWebViewController != null) {
                        iAmraidWebViewController.n();
                    }
                    T t = ((com.fyber.inneractive.sdk.flow.b0) kVar.b).b;
                    if (!(t == null || (str = t.k) == null || str.trim().length() <= 0)) {
                        IAlog.d("%sfiring impression!", IAlog.a((Object) kVar));
                        int i = IAlog.a;
                        IAlog.a(1, (Exception) null, "AD_IMPRESSION", new Object[0]);
                        j0.b(str);
                    }
                    g gVar = kVar.z.b;
                    if (gVar != null) {
                        gVar.a("var forceReflow = function(elem){ elem = elem || document.documentElement; elem.style.zIndex = 2147483646; var width = elem.style.width, px = elem.offsetWidth+1; elem.style.width = px+'px'; setTimeout(function(){ elem.style.zIndex = 2147483646; elem.style.width = width; elem = null; }, 0); }; forceReflow(document.documentElement);");
                    }
                    a aVar = a.IMPRESSION;
                    if (kVar.G == UnitDisplayType.REWARDED) {
                        bVar = com.fyber.inneractive.sdk.cache.session.enums.b.REWARDED_DISPLAY;
                    } else {
                        bVar = com.fyber.inneractive.sdk.cache.session.enums.b.INTERSTITIAL_DISPLAY;
                    }
                    kVar.a(aVar, bVar);
                    kVar.E();
                    kVar.K();
                }
            }
        }
        k kVar2 = this.a;
        kVar2.getClass();
        IAlog.a("%sweb view callback: onVisibilityChanged: %s", IAlog.a((Object) kVar2), Boolean.valueOf(z));
    }

    public void a(i iVar, boolean z, Orientation orientation) {
        c.a aVar = this.a.l;
        if (aVar != null) {
            aVar.setActivityOrientation(z, orientation);
        }
    }

    public boolean a(String str) {
        c.a aVar = this.a.l;
        if (aVar == null || aVar.getLayout() == null) {
            return false;
        }
        boolean startRichMediaIntent = InneractiveRichMediaVideoPlayerActivityCore.startRichMediaIntent(this.a.l.getLayout().getContext(), str);
        if (!startRichMediaIntent) {
            return startRichMediaIntent;
        }
        this.a.D();
        return startRichMediaIntent;
    }

    public void a(i iVar, boolean z) {
        if (z) {
            k kVar = this.a;
            if (!kVar.t) {
                boolean unused = kVar.t = true;
                k kVar2 = this.a;
                c.a aVar = kVar2.l;
                if (aVar != null) {
                    kVar2.d(aVar.isCloseButtonDisplay());
                }
            }
            this.a.Q();
            c.a aVar2 = this.a.l;
            if (aVar2 != null && aVar2.isCloseButtonDisplay()) {
                k kVar3 = this.a;
                kVar3.q = false;
                c.a aVar3 = kVar3.l;
                if (aVar3 != null) {
                    aVar3.disableCloseButton();
                }
                kVar3.v.a();
            }
        }
    }

    public void a(InneractiveUnitController.AdDisplayError adDisplayError) {
        this.a.e(false);
        k kVar = this.a;
        EventsListener eventslistener = kVar.c;
        if (eventslistener != null) {
            ((InneractiveFullscreenAdEventsListener) eventslistener).onAdEnteredErrorState(kVar.a, adDisplayError);
        }
    }

    public void a() {
        this.a.I();
    }
}
