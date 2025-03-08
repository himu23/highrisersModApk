package com.fyber.inneractive.sdk.renderers;

import android.content.Context;
import android.view.ViewGroup;
import com.fyber.inneractive.sdk.activities.InneractiveRichMediaVideoPlayerActivityCore;
import com.fyber.inneractive.sdk.cache.session.enums.a;
import com.fyber.inneractive.sdk.config.a0;
import com.fyber.inneractive.sdk.config.enums.Orientation;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.config.t;
import com.fyber.inneractive.sdk.external.InneractiveAdViewEventsListener;
import com.fyber.inneractive.sdk.external.InneractiveUnitController;
import com.fyber.inneractive.sdk.external.WebViewRendererProcessHasGoneError;
import com.fyber.inneractive.sdk.mraid.b0;
import com.fyber.inneractive.sdk.network.u;
import com.fyber.inneractive.sdk.response.f;
import com.fyber.inneractive.sdk.ui.IAmraidWebViewController;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.b0;
import com.fyber.inneractive.sdk.util.p;
import com.fyber.inneractive.sdk.util.p0;
import com.fyber.inneractive.sdk.web.b;
import com.fyber.inneractive.sdk.web.i;

public class e implements i.h {
    public final /* synthetic */ g a;

    public e(g gVar) {
        this.a = gVar;
    }

    public void a(i iVar, boolean z) {
    }

    public void a(i iVar, boolean z, Orientation orientation) {
    }

    public void a(i iVar) {
        g gVar = this.a;
        gVar.getClass();
        IAlog.a("%sweb view callback: onExpand", IAlog.a((Object) gVar));
        g gVar2 = this.a;
        EventsListener eventslistener = gVar2.c;
        if (eventslistener != null) {
            ((InneractiveAdViewEventsListener) eventslistener).onAdExpanded(gVar2.a);
        }
        g gVar3 = this.a;
        gVar3.getClass();
        IAlog.a("%sweb view callback: onExpand", IAlog.a((Object) gVar3));
        this.a.d(true);
    }

    public void b(i iVar) {
        this.a.d(true);
        g gVar = this.a;
        gVar.getClass();
        IAlog.a("%sweb view callback: onResize", IAlog.a((Object) gVar));
        g gVar2 = this.a;
        EventsListener eventslistener = gVar2.c;
        if (eventslistener != null) {
            ((InneractiveAdViewEventsListener) eventslistener).onAdResized(gVar2.a);
        }
    }

    public void c() {
        this.a.D();
        this.a.G();
    }

    public void b() {
        this.a.a((InneractiveUnitController.AdDisplayError) new WebViewRendererProcessHasGoneError());
    }

    public void a(i iVar, b0 b0Var) {
        g gVar = this.a;
        gVar.getClass();
        IAlog.a("%sweb view callback: onClose", IAlog.a((Object) gVar));
        g gVar2 = this.a;
        EventsListener eventslistener = gVar2.c;
        if (eventslistener != null) {
            ((InneractiveAdViewEventsListener) eventslistener).onAdCollapsed(gVar2.a);
        }
        this.a.N();
        g gVar3 = this.a;
        gVar3.getClass();
        IAlog.a("%sweb view callback: onClose", IAlog.a((Object) gVar3));
    }

    public b0.a a(String str, p0 p0Var, b.a aVar) {
        Context context;
        com.fyber.inneractive.sdk.cache.session.enums.b bVar;
        g gVar = this.a;
        gVar.getClass();
        IAlog.a("%sweb view callback: onClicked", IAlog.a((Object) gVar));
        ViewGroup viewGroup = this.a.q;
        if (viewGroup == null || viewGroup.getContext() == null) {
            context = p.a;
        } else {
            context = this.a.q.getContext();
        }
        if (context != null) {
            g gVar2 = this.a;
            if (gVar2.g) {
                AdContent adcontent = gVar2.b;
                f fVar = adcontent != null ? (f) ((com.fyber.inneractive.sdk.flow.b0) adcontent).b : null;
                if (fVar != null) {
                    gVar2.a((com.fyber.inneractive.sdk.response.e) fVar);
                }
                g gVar3 = this.a;
                AdContent adcontent2 = gVar3.b;
                if (adcontent2 != null) {
                    com.fyber.inneractive.sdk.flow.b0 b0Var = (com.fyber.inneractive.sdk.flow.b0) adcontent2;
                    if (!(b0Var.d == null || ((a0) b0Var.d).c == null)) {
                        a aVar2 = a.CLICK;
                        if (((a0) b0Var.d).c.b == UnitDisplayType.MRECT) {
                            bVar = com.fyber.inneractive.sdk.cache.session.enums.b.RECTANGLE_DISPLAY;
                        } else {
                            bVar = com.fyber.inneractive.sdk.cache.session.enums.b.BANNER_DISPLAY;
                        }
                        gVar3.a(aVar2, bVar);
                    }
                }
                return this.a.a(context, str, p0Var, com.fyber.inneractive.sdk.util.i.DISPLAY);
            }
        }
        return new b0.a(b0.d.FAILED, new Exception("No context or no native click detected"), context == null ? "null" : context.getClass().getName());
    }

    public void a(String str, String str2) {
        g gVar = this.a;
        gVar.getClass();
        IAlog.a("%sweb view callback: onSuspiciousNoUserWebActionDetected", IAlog.a((Object) gVar));
        ViewGroup viewGroup = this.a.q;
        if (viewGroup != null && viewGroup.getContext() != null) {
            g gVar2 = this.a;
            if (!gVar2.w) {
                u.a(gVar2.q.getContext(), str, str2, this.a.b);
                boolean unused = this.a.w = true;
                g gVar3 = this.a;
                gVar3.getClass();
                IAlog.a("%sreporting auto redirect", IAlog.a((Object) gVar3));
                return;
            }
            gVar2.getClass();
            IAlog.a("%sredirect already reported for this ad", IAlog.a((Object) gVar2));
        }
    }

    public void a(boolean z) {
        com.fyber.inneractive.sdk.config.b0 b0Var;
        t tVar;
        com.fyber.inneractive.sdk.cache.session.enums.b bVar;
        g gVar = this.a;
        gVar.getClass();
        IAlog.a("%sweb view callback: onVisibilityChanged: %s", IAlog.a((Object) gVar), Boolean.valueOf(z));
        if (z) {
            g gVar2 = this.a;
            if (!gVar2.p) {
                IAlog.a("%sonShownForTheFirstTime called", IAlog.a((Object) gVar2));
                AdContent adcontent = gVar2.b;
                f fVar = adcontent != null ? (f) ((com.fyber.inneractive.sdk.flow.b0) adcontent).b : null;
                if (fVar != null) {
                    IAmraidWebViewController iAmraidWebViewController = gVar2.n;
                    if (iAmraidWebViewController != null) {
                        iAmraidWebViewController.n();
                    }
                    gVar2.b((com.fyber.inneractive.sdk.response.e) fVar);
                }
                long L = (long) gVar2.L();
                gVar2.l = L;
                if (L != 0) {
                    gVar2.a(L, true);
                }
                AdContent adcontent2 = gVar2.b;
                if (!(adcontent2 == null || (b0Var = ((com.fyber.inneractive.sdk.flow.b0) adcontent2).d) == null || (tVar = ((a0) b0Var).c) == null)) {
                    a aVar = a.IMPRESSION;
                    if (tVar.b == UnitDisplayType.MRECT) {
                        bVar = com.fyber.inneractive.sdk.cache.session.enums.b.RECTANGLE_DISPLAY;
                    } else {
                        bVar = com.fyber.inneractive.sdk.cache.session.enums.b.BANNER_DISPLAY;
                    }
                    gVar2.a(aVar, bVar);
                }
                gVar2.E();
                this.a.p = true;
                return;
            }
            b bVar2 = gVar2.z;
            if (bVar2 != null) {
                bVar2.b();
            }
            this.a.N();
            return;
        }
        b bVar3 = this.a.z;
        if (bVar3 != null && bVar3.h) {
            bVar3.c();
        }
        this.a.d(false);
    }

    public boolean a(String str) {
        ViewGroup viewGroup = this.a.q;
        if (viewGroup == null || viewGroup.getContext() == null) {
            return false;
        }
        boolean startRichMediaIntent = InneractiveRichMediaVideoPlayerActivityCore.startRichMediaIntent(this.a.q.getContext(), str);
        if (!startRichMediaIntent) {
            return startRichMediaIntent;
        }
        g gVar = this.a;
        if (gVar.c == null) {
            return startRichMediaIntent;
        }
        gVar.D();
        return startRichMediaIntent;
    }

    public void a(InneractiveUnitController.AdDisplayError adDisplayError) {
        g gVar = this.a;
        EventsListener eventslistener = gVar.c;
        if (eventslistener != null) {
            ((InneractiveAdViewEventsListener) eventslistener).onAdEnteredErrorState(gVar.a, adDisplayError);
        }
    }
}
