package com.fyber.inneractive.sdk.renderers;

import android.view.View;
import android.widget.FrameLayout;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.config.global.features.b;
import com.fyber.inneractive.sdk.config.global.features.d;
import com.fyber.inneractive.sdk.config.global.s;
import com.fyber.inneractive.sdk.external.InneractiveAdManager;
import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.external.InneractiveFullscreenAdEventsListener;
import com.fyber.inneractive.sdk.external.InneractiveFullscreenUnitController;
import com.fyber.inneractive.sdk.flow.b0;
import com.fyber.inneractive.sdk.flow.q;
import com.fyber.inneractive.sdk.flow.w;
import com.fyber.inneractive.sdk.flow.z;
import com.fyber.inneractive.sdk.interfaces.c;
import com.fyber.inneractive.sdk.measurement.tracker.c;
import com.fyber.inneractive.sdk.network.r;
import com.fyber.inneractive.sdk.network.s;
import com.fyber.inneractive.sdk.ui.IAmraidWebViewController;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.a0;
import com.fyber.inneractive.sdk.util.b1;
import com.fyber.inneractive.sdk.util.l0;
import com.fyber.inneractive.sdk.web.g;
import com.fyber.inneractive.sdk.web.i;

public class k extends z<b0, InneractiveFullscreenAdEventsListener> {
    public boolean A = false;
    public boolean B = false;
    public boolean C = false;
    public boolean D = false;
    public boolean E = false;
    public b1 F;
    public UnitDisplayType G = UnitDisplayType.INTERSTITIAL;
    public boolean H = false;
    public boolean I = false;
    public c.b J;
    public l0 K;
    public i.h x;
    public boolean y = false;
    public IAmraidWebViewController z;

    public class a implements b1.b {
        public a() {
        }

        public void a(b1 b1Var) {
            boolean unused = k.this.H = true;
        }
    }

    public int L() {
        Integer b;
        AdContent adcontent = this.b;
        if (adcontent == null) {
            return -1;
        }
        b0 b0Var = (b0) adcontent;
        if (b0Var.c == null || b0Var.c.a(d.class) == null || (b = ((d) ((b0) this.b).c.a(d.class)).b("close_clickable_area_dp")) == null) {
            return -1;
        }
        return b.intValue();
    }

    public int M() {
        Integer b;
        AdContent adcontent = this.b;
        if (adcontent == null) {
            return -1;
        }
        b0 b0Var = (b0) adcontent;
        if (b0Var.c == null || b0Var.c.a(d.class) == null || (b = ((d) ((b0) this.b).c.a(d.class)).b("close_visible_size_dp")) == null) {
            return -1;
        }
        return b.intValue();
    }

    public long N() {
        int i;
        int i2 = 2;
        if (this.G == UnitDisplayType.REWARDED) {
            int a2 = IAConfigManager.M.u.b.a("rewarded_mraid_delay", 31, 30);
            IAlog.a("%sGetting rewarded total delay of %d seconds", IAlog.a((Object) this), Integer.valueOf(a2));
            i2 = a2;
        } else {
            com.fyber.inneractive.sdk.config.i iVar = IAConfigManager.M.u.b;
            String l = Long.toString(2);
            if (iVar.a.containsKey("mraid_x_delay")) {
                l = iVar.a.get("mraid_x_delay");
            }
            try {
                i2 = Integer.parseInt(l);
            } catch (Throwable unused) {
            }
        }
        if (InneractiveAdManager.isCurrentUserAChild()) {
            if (B()) {
                i = ((b) ((b0) this.b).c.a(b.class)).d();
            } else {
                i = Math.min(i2, 5);
            }
            i2 = Math.min(i, i2);
        }
        return (long) (i2 * 1000);
    }

    public boolean O() {
        return false;
    }

    public final void S() {
        IAmraidWebViewController iAmraidWebViewController;
        if (this.b == null || (iAmraidWebViewController = this.z) == null) {
            IAlog.a("updateWebViewLayoutParams called, but web view is invalid", new Object[0]);
            return;
        }
        g gVar = iAmraidWebViewController.b;
        if (gVar != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.gravity = 17;
            gVar.setLayoutParams(layoutParams);
        }
    }

    public void a(c.b bVar) {
        this.J = bVar;
    }

    public void m() {
        s sVar;
        EventsListener eventslistener;
        if (this.G == UnitDisplayType.REWARDED && this.H) {
            R();
        }
        if (!this.B && (eventslistener = this.c) != null) {
            this.B = true;
            ((InneractiveFullscreenAdEventsListener) eventslistener).onAdDismissed(this.a);
        }
        l0 l0Var = this.K;
        if (l0Var != null) {
            long j = l0Var.b;
            if (j != 0) {
                String a2 = a0.a(j, l0Var.d);
                l0Var.b = 0;
                l0Var.c = 0;
                l0Var.d = 0;
                InneractiveAdSpot inneractiveAdSpot = l0Var.a;
                q adContent = inneractiveAdSpot != null ? inneractiveAdSpot.getAdContent() : null;
                s.a aVar = new s.a(r.INTERSTITIAL_VIEW_TIME, adContent != null ? adContent.a : null, adContent != null ? adContent.d() : null, (adContent == null || (sVar = adContent.c) == null) ? null : sVar.c());
                aVar.a("time", a2);
                aVar.a((String) null);
            }
        }
        InneractiveAdSpot inneractiveAdSpot2 = this.a;
        if (inneractiveAdSpot2 != null && (inneractiveAdSpot2 instanceof w)) {
            ((w) inneractiveAdSpot2).a();
        }
    }

    public void o() {
        b1 b1Var;
        super.o();
        if (this.G == UnitDisplayType.REWARDED && (b1Var = this.F) != null) {
            b1Var.b();
        }
        l0 l0Var = this.K;
        if (l0Var != null) {
            if (l0Var.b == 0) {
                l0Var.b = System.currentTimeMillis();
            }
            if (l0Var.c > 0) {
                l0Var.d += System.currentTimeMillis() - l0Var.c;
                l0Var.c = 0;
            }
        }
        this.v.b();
    }

    public void t() {
        b1 b1Var;
        super.t();
        if (this.G == UnitDisplayType.REWARDED && (b1Var = this.F) != null) {
            b1Var.a();
        }
        l0 l0Var = this.K;
        if (l0Var != null) {
            l0Var.c = System.currentTimeMillis();
        }
        com.fyber.inneractive.sdk.util.a aVar = this.v;
        if (aVar.b) {
            aVar.e = System.currentTimeMillis();
        }
    }

    public boolean v() {
        boolean z2;
        if (this.l != null) {
            if (this.G == UnitDisplayType.REWARDED) {
                if (this.H) {
                    R();
                }
                z2 = this.H;
            } else {
                z2 = this.q;
            }
            if (!z2) {
                return true;
            }
        }
        c.a aVar = this.l;
        if (aVar == null) {
            return false;
        }
        aVar.dismissAd(true);
        return true;
    }

    public boolean J() {
        return !this.C && this.z.Y;
    }

    public final void R() {
        IAlog.a("%sprovide reward called", IAlog.a((Object) this));
        if (this.I) {
            IAlog.a("%sreward was already provided", IAlog.a((Object) this));
            return;
        }
        IAlog.a("%sreward sent", IAlog.a((Object) this));
        if (this.J != null) {
            a(com.fyber.inneractive.sdk.cache.session.enums.a.COMPLETION, com.fyber.inneractive.sdk.cache.session.enums.b.REWARDED_DISPLAY);
            ((InneractiveFullscreenUnitController.a) this.J).a();
        }
        IAmraidWebViewController iAmraidWebViewController = this.z;
        if (iAmraidWebViewController == null || !iAmraidWebViewController.D) {
            I();
        }
        this.I = true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
        r2 = ((com.fyber.inneractive.sdk.flow.b0) r0).d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.fyber.inneractive.sdk.interfaces.c.a r7, android.app.Activity r8) throws com.fyber.inneractive.sdk.external.InneractiveUnitController.AdDisplayError, android.content.res.Resources.NotFoundException {
        /*
            r6 = this;
            super.a((com.fyber.inneractive.sdk.interfaces.c.a) r7, (android.app.Activity) r8)
            AdContent r0 = r6.b
            r1 = 0
            if (r0 == 0) goto L_0x0014
            r2 = r0
            com.fyber.inneractive.sdk.flow.b0 r2 = (com.fyber.inneractive.sdk.flow.b0) r2
            com.fyber.inneractive.sdk.config.b0 r2 = r2.d
            if (r2 == 0) goto L_0x0014
            com.fyber.inneractive.sdk.config.a0 r2 = (com.fyber.inneractive.sdk.config.a0) r2
            com.fyber.inneractive.sdk.config.t r2 = r2.c
            goto L_0x0015
        L_0x0014:
            r2 = r1
        L_0x0015:
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x0137
            if (r0 == 0) goto L_0x0021
            r5 = r0
            com.fyber.inneractive.sdk.flow.b0 r5 = (com.fyber.inneractive.sdk.flow.b0) r5
            com.fyber.inneractive.sdk.ui.IAmraidWebViewController r5 = r5.i
            goto L_0x0022
        L_0x0021:
            r5 = r1
        L_0x0022:
            r6.z = r5
            if (r5 == 0) goto L_0x0122
            com.fyber.inneractive.sdk.web.g r5 = r5.b
            if (r5 == 0) goto L_0x0122
            com.fyber.inneractive.sdk.flow.b0 r0 = (com.fyber.inneractive.sdk.flow.b0) r0
            r0.i()
            com.fyber.inneractive.sdk.config.enums.UnitDisplayType r0 = r2.b
            r6.G = r0
            r6.A = r4
            r6.B = r4
            com.fyber.inneractive.sdk.util.l0 r0 = new com.fyber.inneractive.sdk.util.l0
            com.fyber.inneractive.sdk.external.InneractiveAdSpot r2 = r6.a
            r0.<init>(r2)
            r6.K = r0
            r6.l = r7
            com.fyber.inneractive.sdk.ui.IAmraidWebViewController r0 = r6.z
            if (r0 == 0) goto L_0x0116
            android.view.View r7 = r7.getCloseButton()
            com.fyber.inneractive.sdk.measurement.tracker.c$c r2 = com.fyber.inneractive.sdk.measurement.tracker.c.C0103c.CloseButton
            r0.a((android.view.View) r7, (com.fyber.inneractive.sdk.measurement.tracker.c.C0103c) r2)
            AdContent r7 = r6.b
            com.fyber.inneractive.sdk.flow.b0 r7 = (com.fyber.inneractive.sdk.flow.b0) r7
            T r7 = r7.b
            com.fyber.inneractive.sdk.response.f r7 = (com.fyber.inneractive.sdk.response.f) r7
            int r0 = r7.e
            int r7 = r7.f
            r2 = 300(0x12c, float:4.2E-43)
            if (r0 != r2) goto L_0x0063
            r2 = 250(0xfa, float:3.5E-43)
            if (r7 == r2) goto L_0x006b
        L_0x0063:
            r2 = 600(0x258, float:8.41E-43)
            if (r0 != r2) goto L_0x006d
            r2 = 500(0x1f4, float:7.0E-43)
            if (r7 != r2) goto L_0x006d
        L_0x006b:
            r2 = 1
            goto L_0x006e
        L_0x006d:
            r2 = 0
        L_0x006e:
            r6.C = r2
            if (r2 == 0) goto L_0x0081
            com.fyber.inneractive.sdk.ui.IAmraidWebViewController r2 = r6.z
            float r0 = (float) r0
            int r0 = com.fyber.inneractive.sdk.util.p.a((float) r0)
            float r7 = (float) r7
            int r7 = com.fyber.inneractive.sdk.util.p.a((float) r7)
            r2.setAdDefaultSize(r0, r7)
        L_0x0081:
            com.fyber.inneractive.sdk.web.i$h r7 = r6.x
            if (r7 != 0) goto L_0x008c
            com.fyber.inneractive.sdk.renderers.l r7 = new com.fyber.inneractive.sdk.renderers.l
            r7.<init>(r6)
            r6.x = r7
        L_0x008c:
            com.fyber.inneractive.sdk.ui.IAmraidWebViewController r7 = r6.z
            com.fyber.inneractive.sdk.web.i$h r0 = r6.x
            r7.setListener(r0)
            com.fyber.inneractive.sdk.external.InneractiveAdSpot r7 = r6.a
            if (r7 == 0) goto L_0x00d5
            com.fyber.inneractive.sdk.flow.q r7 = r7.getAdContent()
            if (r7 == 0) goto L_0x00d5
            if (r8 == 0) goto L_0x00d5
            com.fyber.inneractive.sdk.flow.e r7 = new com.fyber.inneractive.sdk.flow.e
            com.fyber.inneractive.sdk.external.InneractiveAdSpot r0 = r6.a
            com.fyber.inneractive.sdk.flow.q r0 = r0.getAdContent()
            com.fyber.inneractive.sdk.external.InneractiveAdRequest r0 = r0.a
            com.fyber.inneractive.sdk.external.InneractiveAdSpot r2 = r6.a
            com.fyber.inneractive.sdk.flow.q r2 = r2.getAdContent()
            com.fyber.inneractive.sdk.response.e r2 = r2.d()
            com.fyber.inneractive.sdk.external.InneractiveAdSpot r5 = r6.a
            com.fyber.inneractive.sdk.flow.q r5 = r5.getAdContent()
            com.fyber.inneractive.sdk.config.global.s r5 = r5.c
            r7.<init>(r0, r2, r5)
            int r0 = com.fyber.inneractive.sdk.R.id.ia_identifier_overlay
            android.view.View r8 = r8.findViewById(r0)
            android.view.ViewGroup r8 = (android.view.ViewGroup) r8
            com.fyber.inneractive.sdk.ui.FyberAdIdentifier$Corner r0 = com.fyber.inneractive.sdk.ui.FyberAdIdentifier.Corner.BOTTOM_LEFT
            r7.a(r8, r0)
            r8.setVisibility(r4)
            com.fyber.inneractive.sdk.ui.IAmraidWebViewController r7 = r6.z
            com.fyber.inneractive.sdk.measurement.tracker.c$c r0 = com.fyber.inneractive.sdk.measurement.tracker.c.C0103c.IdentifierView
            r7.a((android.view.View) r8, (com.fyber.inneractive.sdk.measurement.tracker.c.C0103c) r0)
        L_0x00d5:
            r6.S()
            com.fyber.inneractive.sdk.ui.IAmraidWebViewController r7 = r6.z
            com.fyber.inneractive.sdk.interfaces.c$a r8 = r6.l
            android.view.ViewGroup r8 = r8.getLayout()
            AdContent r0 = r6.b
            com.fyber.inneractive.sdk.flow.b0 r0 = (com.fyber.inneractive.sdk.flow.b0) r0
            com.fyber.inneractive.sdk.external.InneractiveAdRequest r0 = r0.a
            r7.a((android.view.ViewGroup) r8, (android.view.ViewGroup.LayoutParams) r1)
            r6.A = r3
            com.fyber.inneractive.sdk.config.enums.UnitDisplayType r7 = r6.G
            com.fyber.inneractive.sdk.config.enums.UnitDisplayType r8 = com.fyber.inneractive.sdk.config.enums.UnitDisplayType.REWARDED
            if (r7 != r8) goto L_0x0121
            com.fyber.inneractive.sdk.util.b1 r7 = new com.fyber.inneractive.sdk.util.b1
            java.util.concurrent.TimeUnit r8 = java.util.concurrent.TimeUnit.SECONDS
            com.fyber.inneractive.sdk.config.IAConfigManager r0 = com.fyber.inneractive.sdk.config.IAConfigManager.M
            com.fyber.inneractive.sdk.config.j r0 = r0.u
            com.fyber.inneractive.sdk.config.i r0 = r0.b
            r1 = 31
            r2 = 30
            java.lang.String r3 = "rewarded_mraid_delay"
            int r0 = r0.a(r3, r1, r2)
            long r0 = (long) r0
            r7.<init>(r8, r0)
            r6.F = r7
            com.fyber.inneractive.sdk.renderers.k$a r8 = new com.fyber.inneractive.sdk.renderers.k$a
            r8.<init>()
            r7.e = r8
            r7.c()
            goto L_0x0121
        L_0x0116:
            java.lang.Object[] r7 = new java.lang.Object[r3]
            AdContent r8 = r6.b
            r7[r4] = r8
            java.lang.String r8 = "InneractiveFullscreenMraidAdRenderer.renderAd: Spot ad content is not the right content :( %s"
            com.fyber.inneractive.sdk.util.IAlog.e(r8, r7)
        L_0x0121:
            return
        L_0x0122:
            java.lang.Object[] r7 = new java.lang.Object[r3]
            java.lang.String r8 = com.fyber.inneractive.sdk.util.IAlog.a((java.lang.Object) r6)
            r7[r4] = r8
            java.lang.String r8 = "%sWeb view controller content is not valid. Web view might have crashed"
            com.fyber.inneractive.sdk.util.IAlog.e(r8, r7)
            com.fyber.inneractive.sdk.external.InneractiveUnitController$AdDisplayError r7 = new com.fyber.inneractive.sdk.external.InneractiveUnitController$AdDisplayError
            java.lang.String r8 = "Web view could not be loaded"
            r7.<init>((java.lang.String) r8)
            throw r7
        L_0x0137:
            java.lang.Object[] r7 = new java.lang.Object[r3]
            java.lang.String r8 = com.fyber.inneractive.sdk.util.IAlog.a((java.lang.Object) r6)
            r7[r4] = r8
            java.lang.String r8 = "%sNo display config for full screen mraid ad renderer! Cannot render"
            com.fyber.inneractive.sdk.util.IAlog.e(r8, r7)
            com.fyber.inneractive.sdk.external.InneractiveUnitController$AdDisplayError r7 = new com.fyber.inneractive.sdk.external.InneractiveUnitController$AdDisplayError
            java.lang.String r8 = "No display config for full screen mraid"
            r7.<init>((java.lang.String) r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.renderers.k.a(com.fyber.inneractive.sdk.interfaces.c$a, android.app.Activity):void");
    }

    public /* bridge */ /* synthetic */ boolean b(q qVar) {
        b0 b0Var = (b0) qVar;
        return false;
    }

    public void destroy() {
        EventsListener eventslistener;
        if (this.A && !this.B && (eventslistener = this.c) != null) {
            this.B = true;
            ((InneractiveFullscreenAdEventsListener) eventslistener).onAdDismissed(this.a);
        }
        this.x = null;
        b1 b1Var = this.F;
        if (b1Var != null) {
            b1Var.e = null;
            this.F = null;
        }
        super.destroy();
    }

    public void b() {
        S();
    }

    public void c(View view) {
        IAmraidWebViewController iAmraidWebViewController = this.z;
        if (iAmraidWebViewController != null) {
            iAmraidWebViewController.b(view);
        }
    }

    public void b(boolean z2) {
        if (!J()) {
            if (z2) {
                this.v.a((String) null);
            } else {
                this.v.a();
            }
        }
        c.a aVar = this.l;
        if (aVar != null) {
            aVar.destroy();
        }
    }

    public void b(View view) {
        IAmraidWebViewController iAmraidWebViewController = this.z;
        if (iAmraidWebViewController != null) {
            iAmraidWebViewController.a(view, c.C0103c.ProgressOverlay);
        }
    }

    public long a(long j) {
        if (this.G == UnitDisplayType.REWARDED) {
            return 0;
        }
        com.fyber.inneractive.sdk.config.i iVar = IAConfigManager.M.u.b;
        long j2 = 13;
        String l = Long.toString(13);
        if (iVar.a.containsKey("mraid_x_fallback_delay")) {
            l = iVar.a.get("mraid_x_fallback_delay");
        }
        try {
            j2 = Long.parseLong(l);
        } catch (Throwable unused) {
        }
        return j2 * 1000;
    }
}
