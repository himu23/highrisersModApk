package com.fyber.inneractive.sdk.renderers;

import android.app.Activity;
import android.content.Context;
import android.os.CountDownTimer;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.fyber.inneractive.sdk.R;
import com.fyber.inneractive.sdk.activities.InneractiveRichMediaVideoPlayerActivityCore;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.a0;
import com.fyber.inneractive.sdk.config.b0;
import com.fyber.inneractive.sdk.config.c0;
import com.fyber.inneractive.sdk.config.enums.Orientation;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.config.global.features.q;
import com.fyber.inneractive.sdk.config.global.features.r;
import com.fyber.inneractive.sdk.config.global.s;
import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.external.InneractiveContentController;
import com.fyber.inneractive.sdk.external.InneractiveFullscreenAdEventsListener;
import com.fyber.inneractive.sdk.external.InneractiveFullscreenUnitController;
import com.fyber.inneractive.sdk.external.InneractiveFullscreenVideoContentController;
import com.fyber.inneractive.sdk.external.InneractiveUnitController;
import com.fyber.inneractive.sdk.external.WebViewRendererProcessHasGoneError;
import com.fyber.inneractive.sdk.flow.f0;
import com.fyber.inneractive.sdk.flow.z;
import com.fyber.inneractive.sdk.interfaces.c;
import com.fyber.inneractive.sdk.model.vast.t;
import com.fyber.inneractive.sdk.player.a;
import com.fyber.inneractive.sdk.player.c;
import com.fyber.inneractive.sdk.player.controller.b;
import com.fyber.inneractive.sdk.player.controller.w;
import com.fyber.inneractive.sdk.player.e;
import com.fyber.inneractive.sdk.player.ui.d;
import com.fyber.inneractive.sdk.player.ui.h;
import com.fyber.inneractive.sdk.player.ui.l;
import com.fyber.inneractive.sdk.player.ui.o;
import com.fyber.inneractive.sdk.response.g;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.b0;
import com.fyber.inneractive.sdk.util.i;
import com.fyber.inneractive.sdk.util.p;
import com.fyber.inneractive.sdk.util.p0;
import com.fyber.inneractive.sdk.util.r0;
import com.fyber.inneractive.sdk.util.u;
import java.lang.ref.WeakReference;

public class m extends z<f0, InneractiveFullscreenAdEventsListener> implements w {
    public WeakReference<InneractiveFullscreenVideoContentController> A;
    public boolean B = false;
    public boolean C = false;
    public boolean D = false;
    public c.b E;
    public UnitDisplayType F = UnitDisplayType.INTERSTITIAL;
    public n G;
    public boolean H = false;
    public final c.C0106c I = new a();
    public final RelativeLayout.LayoutParams J = new RelativeLayout.LayoutParams(-1, -1);
    public boolean K = false;
    public boolean L = false;
    public c.a x;
    public h y;
    public b z;

    public class a implements c.C0106c {
        public a() {
        }

        public void a(com.fyber.inneractive.sdk.player.c cVar) {
            m.this.z.d(false);
            m.this.z.h();
        }
    }

    public void H() {
        View view = this.k;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    public boolean J() {
        return this.K;
    }

    public int L() {
        Integer b;
        AdContent adcontent = this.b;
        if (adcontent == null) {
            return -1;
        }
        f0 f0Var = (f0) adcontent;
        if (f0Var.c == null || (b = ((q) f0Var.c.a(q.class)).b("close_clickable_area_dp")) == null) {
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
        f0 f0Var = (f0) adcontent;
        if (f0Var.c == null || (b = ((q) f0Var.c.a(q.class)).b("close_visible_size_dp")) == null) {
            return -1;
        }
        return b.intValue();
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x00c6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long N() {
        /*
            r10 = this;
            boolean r0 = com.fyber.inneractive.sdk.external.InneractiveAdManager.isCurrentUserAChild()
            r1 = 0
            if (r0 == 0) goto L_0x0036
            boolean r0 = r10.B()
            if (r0 == 0) goto L_0x0035
            AdContent r0 = r10.b
            com.fyber.inneractive.sdk.flow.f0 r0 = (com.fyber.inneractive.sdk.flow.f0) r0
            com.fyber.inneractive.sdk.config.global.s r0 = r0.c
            java.lang.Class<com.fyber.inneractive.sdk.config.global.features.b> r3 = com.fyber.inneractive.sdk.config.global.features.b.class
            com.fyber.inneractive.sdk.config.global.features.g r0 = r0.a(r3)
            com.fyber.inneractive.sdk.config.global.features.b r0 = (com.fyber.inneractive.sdk.config.global.features.b) r0
            java.lang.String r3 = "end_card_skip_time_sec"
            java.lang.Integer r0 = r0.b(r3)
            r3 = 0
            if (r0 == 0) goto L_0x002a
            int r0 = r0.intValue()
            goto L_0x002b
        L_0x002a:
            r0 = 0
        L_0x002b:
            if (r0 < 0) goto L_0x0031
            r4 = 5
            if (r0 > r4) goto L_0x0031
            r3 = r0
        L_0x0031:
            if (r3 <= 0) goto L_0x0035
            long r0 = (long) r3
            return r0
        L_0x0035:
            return r1
        L_0x0036:
            com.fyber.inneractive.sdk.config.IAConfigManager r0 = com.fyber.inneractive.sdk.config.IAConfigManager.M
            com.fyber.inneractive.sdk.config.j r3 = r0.u
            com.fyber.inneractive.sdk.config.i r3 = r3.b
            java.lang.String r4 = "endcard"
            com.fyber.inneractive.sdk.config.g r3 = r3.a((java.lang.String) r4)
            r3.getClass()
            java.util.Map<java.lang.String, java.lang.String> r4 = r3.a
            java.lang.String r5 = "endcard_cr"
            boolean r4 = r4.containsKey(r5)
            r6 = 1
            java.lang.String r7 = "endcard_ci"
            r8 = 3
            if (r4 != 0) goto L_0x00cc
            java.util.Map<java.lang.String, java.lang.String> r4 = r3.a
            boolean r4 = r4.containsKey(r7)
            if (r4 == 0) goto L_0x005e
            goto L_0x00cc
        L_0x005e:
            com.fyber.inneractive.sdk.config.j r0 = r0.u
            com.fyber.inneractive.sdk.config.i r0 = r0.b
            java.lang.String r1 = java.lang.Long.toString(r8)
            java.util.Map<java.lang.String, java.lang.String> r2 = r0.a
            java.lang.String r3 = "vast_endcard_x_delay"
            boolean r2 = r2.containsKey(r3)
            if (r2 == 0) goto L_0x0079
            java.util.Map<java.lang.String, java.lang.String> r0 = r0.a
            java.lang.Object r0 = r0.get(r3)
            r1 = r0
            java.lang.String r1 = (java.lang.String) r1
        L_0x0079:
            long r8 = java.lang.Long.parseLong(r1)     // Catch:{ all -> 0x007e }
            goto L_0x007f
        L_0x007e:
        L_0x007f:
            AdContent r0 = r10.b
            if (r0 == 0) goto L_0x00f8
            com.fyber.inneractive.sdk.flow.f0 r0 = (com.fyber.inneractive.sdk.flow.f0) r0
            T r1 = r0.b
            if (r1 == 0) goto L_0x00f8
            com.fyber.inneractive.sdk.response.g r1 = (com.fyber.inneractive.sdk.response.g) r1
            com.fyber.inneractive.sdk.model.vast.b r1 = r1.K
            if (r1 == 0) goto L_0x00f8
            com.fyber.inneractive.sdk.model.vast.c r1 = r1.h
            if (r1 == 0) goto L_0x00f8
            com.fyber.inneractive.sdk.model.vast.h r1 = r1.a
            com.fyber.inneractive.sdk.model.vast.h r2 = com.fyber.inneractive.sdk.model.vast.h.Static
            if (r1 != r2) goto L_0x00f8
            com.fyber.inneractive.sdk.config.global.s r0 = r0.c
            java.lang.Class<com.fyber.inneractive.sdk.config.global.features.r> r1 = com.fyber.inneractive.sdk.config.global.features.r.class
            com.fyber.inneractive.sdk.config.global.features.g r0 = r0.a(r1)
            com.fyber.inneractive.sdk.config.global.features.r r0 = (com.fyber.inneractive.sdk.config.global.features.r) r0
            if (r0 == 0) goto L_0x00c3
            com.fyber.inneractive.sdk.config.enums.UnitDisplayType r1 = r10.F
            int[] r2 = com.fyber.inneractive.sdk.config.global.features.r.a.a
            int r1 = r1.ordinal()
            r1 = r2[r1]
            if (r1 == r6) goto L_0x00bc
            r2 = 2
            if (r1 == r2) goto L_0x00b5
            goto L_0x00c3
        L_0x00b5:
            java.lang.String r1 = "endcard_x_btn_delay_iv"
            java.lang.Integer r0 = r0.b(r1)
            goto L_0x00c4
        L_0x00bc:
            java.lang.String r1 = "endcard_x_btn_delay_rv"
            java.lang.Integer r0 = r0.b(r1)
            goto L_0x00c4
        L_0x00c3:
            r0 = 0
        L_0x00c4:
            if (r0 == 0) goto L_0x00f8
            int r0 = r0.intValue()
            long r8 = (long) r0
            goto L_0x00f8
        L_0x00cc:
            com.fyber.inneractive.sdk.config.enums.UnitDisplayType r0 = r10.F
            com.fyber.inneractive.sdk.config.enums.UnitDisplayType r4 = com.fyber.inneractive.sdk.config.enums.UnitDisplayType.REWARDED
            if (r0 != r4) goto L_0x00d3
            goto L_0x00d4
        L_0x00d3:
            r5 = r7
        L_0x00d4:
            java.util.Map<java.lang.String, java.lang.String> r0 = r3.a     // Catch:{ Exception -> 0x00e9 }
            boolean r0 = r0.containsKey(r5)     // Catch:{ Exception -> 0x00e9 }
            if (r0 == 0) goto L_0x00ea
            java.util.Map<java.lang.String, java.lang.String> r0 = r3.a     // Catch:{ Exception -> 0x00e9 }
            java.lang.Object r0 = r0.get(r5)     // Catch:{ Exception -> 0x00e9 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ Exception -> 0x00e9 }
            long r3 = java.lang.Long.parseLong(r0)     // Catch:{ Exception -> 0x00e9 }
            goto L_0x00eb
        L_0x00e9:
        L_0x00ea:
            r3 = r8
        L_0x00eb:
            int r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r0 < 0) goto L_0x00f8
            r0 = 5
            int r2 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r2 > 0) goto L_0x00f8
            r10.u = r6
            r8 = r3
        L_0x00f8:
            com.fyber.inneractive.sdk.player.controller.b r0 = r10.z
            r1 = 1000(0x3e8, double:4.94E-321)
            if (r0 == 0) goto L_0x0103
            long r3 = r8 * r1
            r0.a((long) r3)
        L_0x0103:
            long r8 = r8 * r1
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.renderers.m.N():long");
    }

    public boolean O() {
        h hVar = this.y;
        return hVar != null && ((l) hVar).f();
    }

    public void S() {
        if (!this.C && this.c != null) {
            this.C = true;
            c.a aVar = this.x;
            if (aVar != null && (aVar.wasDismissedByUser() || IAConfigManager.M.u.b.a("endcard").a("dsos", false))) {
                a(t.EVENT_CLOSE);
                a(t.EVENT_CLOSE_LINEAR);
            }
            ((InneractiveFullscreenAdEventsListener) this.c).onAdDismissed(this.a);
        }
    }

    public final void T() {
        com.fyber.inneractive.sdk.cache.session.enums.b bVar;
        AdContent adcontent = this.b;
        if (adcontent != null) {
            f0 f0Var = (f0) adcontent;
            if (f0Var.d != null && ((a0) f0Var.d).c != null) {
                UnitDisplayType unitDisplayType = ((a0) f0Var.d).c.b;
                com.fyber.inneractive.sdk.config.f0 f0Var2 = IAConfigManager.M.x;
                if (unitDisplayType == UnitDisplayType.REWARDED) {
                    bVar = com.fyber.inneractive.sdk.cache.session.enums.b.REWARDED_VIDEO;
                } else {
                    bVar = com.fyber.inneractive.sdk.cache.session.enums.b.INTERSTITIAL_VIDEO;
                }
                f0Var2.a(bVar, com.fyber.inneractive.sdk.cache.session.enums.a.CLICK);
            }
        }
    }

    public void a(c.a aVar, Activity activity) throws InneractiveUnitController.AdDisplayError {
        c0 c0Var;
        super.a(aVar, activity);
        this.x = aVar;
        this.B = false;
        this.C = false;
        this.L = false;
        InneractiveUnitController selectedUnitController = this.a.getSelectedUnitController();
        if (selectedUnitController != null) {
            if (!(selectedUnitController instanceof InneractiveFullscreenUnitController)) {
                IAlog.e("%sWrong type of unit controller found. Expecting InneractiveFullscreenUnitController", IAlog.a((Object) this));
            } else {
                InneractiveContentController selectedContentController = selectedUnitController.getSelectedContentController();
                if (selectedContentController != null) {
                    if (selectedContentController instanceof InneractiveFullscreenVideoContentController) {
                        this.A = new WeakReference<>((InneractiveFullscreenVideoContentController) selectedContentController);
                    } else {
                        IAlog.e("%sContent controller expected to be InneractiveFullscreenVideoContentController and is %s", IAlog.a((Object) this), selectedContentController.getClass().getSimpleName());
                    }
                }
            }
        }
        b0 b0Var = this.a.getAdContent().d;
        if (!(b0Var == null || (c0Var = ((a0) b0Var).f) == null)) {
            this.F = c0Var.j;
        }
        AdContent adcontent = this.b;
        if (adcontent != null) {
            ((f0) adcontent).i();
        }
        AdContent adcontent2 = this.b;
        com.fyber.inneractive.sdk.player.h hVar = adcontent2 != null ? ((f0) adcontent2).i : null;
        Context context = this.x.getLayout().getContext();
        if (hVar != null) {
            a.C0105a aVar2 = hVar.f;
            if (aVar2 == null || ((e) aVar2).b == null) {
                IAlog.e("%sFull screen video ad renderer is not valid.", IAlog.a((Object) this));
                throw new InneractiveUnitController.AdDisplayError("Full screen video could not be loaded");
            }
            ((e) aVar2).getClass();
            c cVar = new c(hVar);
            this.G = cVar;
            this.y = cVar.a(context, ((f0) this.b).c);
            b a2 = this.G.a(this.a, (f0) this.b);
            this.z = a2;
            a2.d(this.G.c());
            this.z.a(this);
            ((d) this.y).b();
            this.J.addRule(13);
            this.x.getLayout().addView((View) this.y, this.J);
            this.k = ((View) this.y).findViewById(R.id.ia_click_overlay);
            this.G.a(this.I);
            this.B = true;
        }
    }

    public void a(c.b bVar) {
        this.E = bVar;
    }

    public void b() {
    }

    public void destroy() {
        R();
        if (this.B) {
            S();
        }
        b bVar = this.z;
        if (bVar != null) {
            bVar.destroy();
            this.z = null;
        }
        h hVar = this.y;
        if (hVar != null) {
            hVar.destroy();
            this.y = null;
        }
        this.x = null;
        this.A = null;
        super.destroy();
    }

    public final void f(boolean z2) {
        h hVar = this.y;
        if (hVar != null && ((l) hVar).f() && this.K) {
            return;
        }
        if (z2) {
            b bVar = this.z;
            String str = null;
            com.fyber.inneractive.sdk.flow.vast.e c = bVar != null ? bVar.c() : null;
            if (c != null && c.c) {
                i iVar = i.FMP_ENDCARD;
                iVar.a(c.d);
                str = iVar.toString();
            }
            this.v.a(str);
            return;
        }
        this.v.a();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0021, code lost:
        r0 = (r0 = r0.h).b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void g() {
        /*
            r2 = this;
            AdContent r0 = r2.b
            if (r0 == 0) goto L_0x002e
            com.fyber.inneractive.sdk.flow.f0 r0 = (com.fyber.inneractive.sdk.flow.f0) r0
            com.fyber.inneractive.sdk.external.InneractiveAdRequest r1 = r0.a
            if (r1 == 0) goto L_0x002e
            T r0 = r0.b
            if (r0 == 0) goto L_0x002e
            r2.T()
            AdContent r0 = r2.b
            com.fyber.inneractive.sdk.flow.f0 r0 = (com.fyber.inneractive.sdk.flow.f0) r0
            T r0 = r0.b
            com.fyber.inneractive.sdk.response.g r0 = (com.fyber.inneractive.sdk.response.g) r0
            com.fyber.inneractive.sdk.model.vast.b r0 = r0.K
            if (r0 == 0) goto L_0x002a
            com.fyber.inneractive.sdk.model.vast.c r0 = r0.h
            if (r0 == 0) goto L_0x002a
            com.fyber.inneractive.sdk.model.vast.i r0 = r0.b
            if (r0 == 0) goto L_0x002a
            java.lang.String r0 = r0.toString()
            goto L_0x002b
        L_0x002a:
            r0 = 0
        L_0x002b:
            r2.a((java.lang.String) r0)
        L_0x002e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.renderers.m.g():void");
    }

    public void l() {
        com.fyber.inneractive.sdk.cache.session.enums.b bVar;
        com.fyber.inneractive.sdk.config.f0 f0Var = IAConfigManager.M.x;
        if (this.F == UnitDisplayType.INTERSTITIAL) {
            bVar = com.fyber.inneractive.sdk.cache.session.enums.b.INTERSTITIAL_VIDEO;
        } else {
            bVar = com.fyber.inneractive.sdk.cache.session.enums.b.REWARDED_VIDEO;
        }
        f0Var.a(bVar, com.fyber.inneractive.sdk.cache.session.enums.a.IMPRESSION);
        E();
    }

    public void m() {
        S();
        InneractiveAdSpot inneractiveAdSpot = this.a;
        if (inneractiveAdSpot != null && (inneractiveAdSpot instanceof com.fyber.inneractive.sdk.flow.w)) {
            ((com.fyber.inneractive.sdk.flow.w) inneractiveAdSpot).a();
        }
    }

    public void o() {
        super.o();
        this.v.b();
    }

    public void onCompleted() {
        InneractiveFullscreenVideoContentController inneractiveFullscreenVideoContentController = (InneractiveFullscreenVideoContentController) u.a(this.A);
        if (inneractiveFullscreenVideoContentController != null) {
            inneractiveFullscreenVideoContentController.onCompleted();
        }
        com.fyber.inneractive.sdk.config.f0 f0Var = IAConfigManager.M.x;
        UnitDisplayType unitDisplayType = this.F;
        UnitDisplayType unitDisplayType2 = UnitDisplayType.REWARDED;
        f0Var.a(unitDisplayType == unitDisplayType2 ? com.fyber.inneractive.sdk.cache.session.enums.b.REWARDED_VIDEO : com.fyber.inneractive.sdk.cache.session.enums.b.INTERSTITIAL_VIDEO, com.fyber.inneractive.sdk.cache.session.enums.a.COMPLETION);
        if (this.F == unitDisplayType2) {
            c.b bVar = this.E;
            if (bVar != null) {
                ((InneractiveFullscreenUnitController.a) bVar).a();
            }
            I();
        }
        AdContent adcontent = this.b;
        if (adcontent != null && ((f0) adcontent).i != null) {
            K();
        }
    }

    public void onPlayerError() {
        InneractiveFullscreenVideoContentController inneractiveFullscreenVideoContentController = (InneractiveFullscreenVideoContentController) u.a(this.A);
        c.a aVar = this.x;
        if (aVar != null) {
            aVar.dismissAd(false);
        }
        if (inneractiveFullscreenVideoContentController != null) {
            inneractiveFullscreenVideoContentController.onPlayerError();
        }
    }

    public void onProgress(int i, int i2) {
        InneractiveFullscreenVideoContentController inneractiveFullscreenVideoContentController = (InneractiveFullscreenVideoContentController) u.a(this.A);
        if (inneractiveFullscreenVideoContentController != null) {
            inneractiveFullscreenVideoContentController.onProgress(i, i2);
        }
    }

    public void s() {
        D();
    }

    public void t() {
        super.t();
        com.fyber.inneractive.sdk.util.a aVar = this.v;
        if (aVar.b) {
            aVar.e = System.currentTimeMillis();
        }
    }

    public boolean v() {
        b bVar;
        c.a aVar;
        h hVar;
        AdContent adcontent = this.b;
        if (adcontent != null) {
            f0 f0Var = (f0) adcontent;
            if (!(f0Var.i == null || (bVar = this.z) == null || (aVar = this.x) == null || (hVar = this.y) == null)) {
                ((e) f0Var.i.f).getClass();
                if (bVar == null) {
                    aVar.dismissAd(true);
                    return true;
                } else if (((l) hVar).f()) {
                    if (!this.q) {
                        return true;
                    }
                    aVar.dismissAd(true);
                    return true;
                } else if (!bVar.e()) {
                    return true;
                } else {
                    bVar.c(true);
                    return true;
                }
            }
        }
        return false;
    }

    public void x() {
        View view = this.k;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    public final void R() {
        c.a aVar = this.x;
        if (aVar != null) {
            aVar.destroy();
        }
    }

    public void b(boolean z2) {
        b bVar;
        f0 f0Var;
        T t;
        s sVar;
        s sVar2;
        View view;
        f(z2);
        h hVar = this.y;
        if ((hVar == null || (view = ((l) hVar).z) == null || view.getVisibility() != 0) && !this.H && ((bVar = this.z) == null || bVar.d())) {
            AdContent adcontent = this.b;
            if (!(adcontent == null || (t = (f0Var = (f0) adcontent).b) == null || ((g) t).K == null || (sVar = f0Var.c) == null)) {
                boolean z3 = false;
                if (((r) sVar.a(r.class)).a("dual_endcard_enabled", false)) {
                    b bVar2 = this.z;
                    r rVar = null;
                    com.fyber.inneractive.sdk.flow.vast.e c = bVar2 != null ? bVar2.c() : null;
                    if (c == null || c.b == null || !c.a || c.c) {
                        R();
                        return;
                    }
                    this.K = false;
                    this.q = false;
                    c.a aVar = this.l;
                    if (aVar != null) {
                        aVar.disableCloseButton();
                    }
                    this.v.a();
                    P();
                    K();
                    l lVar = (l) this.y;
                    ViewGroup viewGroup = lVar.j;
                    if (viewGroup != null) {
                        viewGroup.removeAllViews();
                    }
                    o oVar = new o(lVar);
                    Context context = lVar.getContext();
                    View view2 = lVar.p;
                    if (view2 != null) {
                        com.fyber.inneractive.sdk.util.q.a(new r0(view2, context, oVar));
                    }
                    u.a(lVar.p);
                    this.G.a.a(c.g);
                    AdContent adcontent2 = this.b;
                    if (!(adcontent2 == null || (sVar2 = ((f0) adcontent2).c) == null)) {
                        rVar = (r) sVar2.a(r.class);
                    }
                    h hVar2 = this.y;
                    com.fyber.inneractive.sdk.player.ui.c cVar = new com.fyber.inneractive.sdk.player.ui.c();
                    cVar.b = true;
                    cVar.g = c.b;
                    com.fyber.inneractive.sdk.model.vast.h hVar3 = com.fyber.inneractive.sdk.model.vast.h.FMP_End_Card;
                    cVar.h = hVar3;
                    if (rVar != null && rVar.a("shouldEnableEndCardAutoClick", false)) {
                        z3 = true;
                    }
                    int i = 3;
                    if (rVar != null) {
                        Integer b = rVar.b("autoClickDelay");
                        int intValue = b != null ? b.intValue() : 3;
                        if (intValue >= 0 && intValue <= 10) {
                            i = intValue;
                        }
                    }
                    Integer valueOf = Integer.valueOf(i);
                    if (z3) {
                        cVar.f = valueOf;
                    }
                    hVar2.a(new com.fyber.inneractive.sdk.player.ui.b(cVar));
                    this.G.a.a(hVar3, 2);
                    c.a aVar2 = this.x;
                    if (aVar2 != null) {
                        aVar2.secondEndCardWasDisplayed();
                        return;
                    }
                    return;
                }
            }
            R();
            return;
        }
        R();
    }

    public void e() {
        if (!this.D) {
            this.v.a(true);
        }
        this.D = true;
    }

    public void h() {
        this.K = true;
        CountDownTimer countDownTimer = this.w;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.w = null;
        }
        if (!this.t) {
            this.t = true;
            c.a aVar = this.x;
            if (aVar != null) {
                d(aVar.isCloseButtonDisplay());
            }
        }
        c.a aVar2 = this.x;
        if (aVar2 != null && aVar2.isCloseButtonDisplay()) {
            e(true ^ this.u);
        }
    }

    public void j() {
        c.a aVar = this.x;
        if (aVar != null) {
            aVar.dismissAd(false);
        }
        a((InneractiveUnitController.AdDisplayError) new WebViewRendererProcessHasGoneError());
    }

    public void k() {
        c.a aVar = this.x;
        if (aVar != null) {
            aVar.dismissAd(true);
        }
    }

    public b0.a a(p0 p0Var, i iVar) {
        Context context;
        T();
        if (this.y.getContext() == null) {
            context = p.a;
        } else {
            context = this.y.getContext();
        }
        AdContent adcontent = this.b;
        return a(context, adcontent != null ? ((f0) adcontent).k() : null, p0Var, iVar);
    }

    public void a(boolean z2, Orientation orientation) {
        c.a aVar = this.x;
        if (aVar != null) {
            aVar.setActivityOrientation(z2, orientation);
        }
    }

    public void a(String str, String str2) {
        IAlog.a(IAlog.a((Object) this) + "full screen video ad renderer callback: onSuspiciousNoUserWebActionDetected", new Object[0]);
        c.a aVar = this.x;
        if (aVar != null && aVar.getLayout() != null && this.x.getLayout().getContext() != null) {
            if (!this.L) {
                com.fyber.inneractive.sdk.network.u.a(this.x.getLayout().getContext(), str, str2, this.b);
                this.L = true;
                IAlog.a(IAlog.a((Object) this) + "reporting auto redirect", new Object[0]);
                return;
            }
            IAlog.a(IAlog.a((Object) this) + "redirect already reported for this ad", new Object[0]);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0027, code lost:
        r2 = r0.b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.fyber.inneractive.sdk.util.b0.a a(java.lang.String r4, com.fyber.inneractive.sdk.util.p0 r5, com.fyber.inneractive.sdk.web.b.a r6, boolean r7) {
        /*
            r3 = this;
            com.fyber.inneractive.sdk.config.enums.UnitDisplayType r0 = r3.F
            com.fyber.inneractive.sdk.config.enums.UnitDisplayType r1 = com.fyber.inneractive.sdk.config.enums.UnitDisplayType.INTERSTITIAL
            if (r0 != r1) goto L_0x0009
            r0 = 1
            r3.H = r0
        L_0x0009:
            AdContent r0 = r3.b
            if (r0 == 0) goto L_0x009b
            com.fyber.inneractive.sdk.flow.f0 r0 = (com.fyber.inneractive.sdk.flow.f0) r0
            T r1 = r0.b
            if (r1 == 0) goto L_0x009b
            T r1 = r0.b
            if (r1 == 0) goto L_0x009b
            T r0 = r0.b
            com.fyber.inneractive.sdk.response.g r0 = (com.fyber.inneractive.sdk.response.g) r0
            com.fyber.inneractive.sdk.model.vast.b r0 = r0.K
            r3.T()
            if (r0 == 0) goto L_0x009b
            com.fyber.inneractive.sdk.model.vast.c r0 = r0.h
            r1 = 0
            if (r0 == 0) goto L_0x0032
            com.fyber.inneractive.sdk.model.vast.i r2 = r0.b
            if (r2 == 0) goto L_0x0032
            if (r7 != 0) goto L_0x0032
            java.lang.String r2 = r2.toString()
            goto L_0x0033
        L_0x0032:
            r2 = r1
        L_0x0033:
            r3.a((java.lang.String) r2)
            if (r7 == 0) goto L_0x003b
            com.fyber.inneractive.sdk.util.i r7 = com.fyber.inneractive.sdk.util.i.DEFAULT_ENDCARD
            goto L_0x003d
        L_0x003b:
            com.fyber.inneractive.sdk.util.i r7 = com.fyber.inneractive.sdk.util.i.VAST_ENDCARD
        L_0x003d:
            com.fyber.inneractive.sdk.player.controller.b r2 = r3.z
            if (r2 == 0) goto L_0x0045
            com.fyber.inneractive.sdk.flow.vast.e r1 = r2.c()
        L_0x0045:
            if (r6 == 0) goto L_0x0054
            com.fyber.inneractive.sdk.util.i r7 = com.fyber.inneractive.sdk.util.i.FMP_ENDCARD
            java.lang.String r1 = r6.a
            r7.a((java.lang.String) r1)
            int r6 = r6.b
            r7.a((int) r6)
            goto L_0x0066
        L_0x0054:
            if (r1 == 0) goto L_0x0066
            boolean r6 = r1.c
            if (r6 == 0) goto L_0x0066
            com.fyber.inneractive.sdk.util.i r7 = com.fyber.inneractive.sdk.util.i.FMP_ENDCARD
            java.lang.String r6 = r1.e
            r7.a((java.lang.String) r6)
            int r6 = r1.d
            r7.a((int) r6)
        L_0x0066:
            com.fyber.inneractive.sdk.player.ui.h r6 = r3.y
            android.content.Context r6 = r6.getContext()
            if (r6 != 0) goto L_0x0071
            android.app.Application r6 = com.fyber.inneractive.sdk.util.p.a
            goto L_0x0077
        L_0x0071:
            com.fyber.inneractive.sdk.player.ui.h r6 = r3.y
            android.content.Context r6 = r6.getContext()
        L_0x0077:
            com.fyber.inneractive.sdk.util.b0$a r4 = r3.a(r6, r4, r5, r7)
            if (r0 == 0) goto L_0x009a
            com.fyber.inneractive.sdk.util.b0$d r5 = r4.a
            com.fyber.inneractive.sdk.util.b0$d r6 = com.fyber.inneractive.sdk.util.b0.d.FAILED
            if (r5 == r6) goto L_0x009a
            AdContent r5 = r3.b
            com.fyber.inneractive.sdk.flow.f0 r5 = (com.fyber.inneractive.sdk.flow.f0) r5
            com.fyber.inneractive.sdk.model.vast.t r6 = com.fyber.inneractive.sdk.model.vast.t.EVENT_CLICK
            java.lang.String r6 = r6.toString()
            java.lang.String[] r6 = new java.lang.String[]{r6}
            com.fyber.inneractive.sdk.player.h r5 = r5.i
            if (r5 == 0) goto L_0x009a
            java.lang.String r7 = "EVENT_TRACKING"
            r5.a(r7, r6)
        L_0x009a:
            return r4
        L_0x009b:
            com.fyber.inneractive.sdk.util.b0$a r4 = new com.fyber.inneractive.sdk.util.b0$a
            com.fyber.inneractive.sdk.util.b0$d r5 = com.fyber.inneractive.sdk.util.b0.d.FAILED
            java.lang.Exception r6 = new java.lang.Exception
            java.lang.String r7 = "Internal SDK Error"
            r6.<init>(r7)
            java.lang.String r7 = "null"
            r4.<init>(r5, r6, r7)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.renderers.m.a(java.lang.String, com.fyber.inneractive.sdk.util.p0, com.fyber.inneractive.sdk.web.b$a, boolean):com.fyber.inneractive.sdk.util.b0$a");
    }

    /* renamed from: a */
    public boolean b(f0 f0Var) {
        com.fyber.inneractive.sdk.config.h hVar;
        T t;
        com.fyber.inneractive.sdk.model.vast.b bVar;
        com.fyber.inneractive.sdk.model.vast.c cVar;
        IAConfigManager iAConfigManager = IAConfigManager.M;
        com.fyber.inneractive.sdk.config.i iVar = iAConfigManager.u.b;
        iVar.getClass();
        String str = iAConfigManager.d;
        if (iVar.b.containsKey(str)) {
            hVar = iVar.b.get(str);
        } else {
            hVar = new com.fyber.inneractive.sdk.config.h();
        }
        if (hVar.a.containsKey("endcard") || (t = f0Var.b) == null || (bVar = ((g) t).K) == null || (cVar = bVar.h) == null || cVar.a != com.fyber.inneractive.sdk.model.vast.h.Static) {
            return false;
        }
        r rVar = (r) f0Var.c.a(r.class);
        UnitDisplayType unitDisplayType = this.F;
        rVar.getClass();
        int i = r.a.a[unitDisplayType.ordinal()];
        if (i == 1) {
            return rVar.a("countdown_rv", false);
        }
        if (i != 2) {
            return false;
        }
        return rVar.a("countdown_iv", false);
    }

    public void a(boolean z2) {
        com.fyber.inneractive.sdk.player.h hVar;
        AdContent adcontent = this.b;
        if (adcontent != null && (hVar = ((f0) adcontent).i) != null) {
            hVar.a("TRACKING_COMPLETED", new String[0]);
            K();
            String[] strArr = new String[0];
            com.fyber.inneractive.sdk.player.h hVar2 = ((f0) this.b).i;
            if (hVar2 != null) {
                hVar2.a("TRACKING_COMPLETED", strArr);
            }
            if (IAConfigManager.M.u.b.a("endcard").a("dsos", false) && z2) {
                R();
            }
            f(z2);
        }
    }

    public void a(View view, String str) {
        if (view != null && view.getContext() != null) {
            InneractiveRichMediaVideoPlayerActivityCore.startRichMediaIntent(view.getContext(), str);
            D();
        }
    }

    public long a(long j) {
        if (this.u) {
            return j;
        }
        com.fyber.inneractive.sdk.config.i iVar = IAConfigManager.M.u.b;
        long j2 = 12;
        String l = Long.toString(12);
        if (iVar.a.containsKey("vast_endcard_x_fallback_delay")) {
            l = iVar.a.get("vast_endcard_x_fallback_delay");
        }
        try {
            j2 = Long.parseLong(l);
        } catch (Throwable unused) {
        }
        return j2 * 1000;
    }

    public void a(t tVar) {
        AdContent adcontent = this.b;
        if (adcontent != null) {
            f0 f0Var = (f0) adcontent;
            if (f0Var.i != null) {
                String[] strArr = {tVar.e()};
                com.fyber.inneractive.sdk.player.h hVar = f0Var.i;
                if (hVar != null) {
                    hVar.a("EVENT_TRACKING", strArr);
                }
            }
        }
    }
}
