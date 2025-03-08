package com.fyber.inneractive.sdk.renderers;

import android.view.View;
import com.fyber.inneractive.sdk.activities.InneractiveRichMediaVideoPlayerActivityCore;
import com.fyber.inneractive.sdk.cache.session.enums.a;
import com.fyber.inneractive.sdk.cache.session.enums.b;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.a0;
import com.fyber.inneractive.sdk.config.enums.Orientation;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.external.InneractiveNativeAdEventsListener;
import com.fyber.inneractive.sdk.external.InneractiveUnitController;
import com.fyber.inneractive.sdk.external.WebViewRendererProcessHasGoneError;
import com.fyber.inneractive.sdk.flow.f0;
import com.fyber.inneractive.sdk.flow.q;
import com.fyber.inneractive.sdk.flow.z;
import com.fyber.inneractive.sdk.interfaces.c;
import com.fyber.inneractive.sdk.player.controller.w;
import com.fyber.inneractive.sdk.player.h;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.b0;
import com.fyber.inneractive.sdk.util.i;
import com.fyber.inneractive.sdk.util.p0;

public class j extends z<f0, InneractiveNativeAdEventsListener> implements w {
    public boolean x = false;

    public boolean J() {
        return false;
    }

    public int L() {
        return 0;
    }

    public int M() {
        return 0;
    }

    public long N() {
        return 0;
    }

    public boolean O() {
        return false;
    }

    public final void R() {
        AdContent adcontent = this.b;
        if (adcontent != null) {
            f0 f0Var = (f0) adcontent;
            if (f0Var.d != null && ((a0) f0Var.d).c != null) {
                IAConfigManager.M.x.a(((a0) f0Var.d).c.b == UnitDisplayType.REWARDED ? b.REWARDED_VIDEO : b.INTERSTITIAL_VIDEO, a.CLICK);
            }
        }
    }

    public long a(long j) {
        return 0;
    }

    public b0.a a(p0 p0Var, i iVar) {
        R();
        throw null;
    }

    public void a(c.b bVar) {
    }

    public void a(boolean z) {
    }

    public void a(boolean z, Orientation orientation) {
    }

    public void b() {
    }

    public /* bridge */ /* synthetic */ boolean b(q qVar) {
        f0 f0Var = (f0) qVar;
        return false;
    }

    public void e() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001a, code lost:
        r0 = (r0 = r0.h).b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void g() {
        /*
            r2 = this;
            AdContent r0 = r2.b
            if (r0 == 0) goto L_0x0027
            com.fyber.inneractive.sdk.flow.f0 r0 = (com.fyber.inneractive.sdk.flow.f0) r0
            com.fyber.inneractive.sdk.external.InneractiveAdRequest r1 = r0.a
            if (r1 == 0) goto L_0x0027
            T r1 = r0.b
            if (r1 == 0) goto L_0x0027
            T r0 = r0.b
            com.fyber.inneractive.sdk.response.g r0 = (com.fyber.inneractive.sdk.response.g) r0
            com.fyber.inneractive.sdk.model.vast.b r0 = r0.K
            if (r0 == 0) goto L_0x0023
            com.fyber.inneractive.sdk.model.vast.c r0 = r0.h
            if (r0 == 0) goto L_0x0023
            com.fyber.inneractive.sdk.model.vast.i r0 = r0.b
            if (r0 == 0) goto L_0x0023
            java.lang.String r0 = r0.toString()
            goto L_0x0024
        L_0x0023:
            r0 = 0
        L_0x0024:
            r2.a((java.lang.String) r0)
        L_0x0027:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.renderers.j.g():void");
    }

    public void j() {
        a((InneractiveUnitController.AdDisplayError) new WebViewRendererProcessHasGoneError());
    }

    public void k() {
    }

    public void l() {
    }

    public void o() {
    }

    public void onCompleted() {
    }

    public void onPlayerError() {
    }

    public void onProgress(int i, int i2) {
    }

    public void s() {
        D();
    }

    public void t() {
    }

    public boolean v() {
        return false;
    }

    public void destroy() {
        if (!this.x) {
            m();
        }
        this.b = null;
        super.destroy();
    }

    public void h() {
        IAlog.a("%snShownCloseButton", IAlog.a((Object) this));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0022, code lost:
        r1 = (r1 = r1.h).b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.fyber.inneractive.sdk.util.b0.a a(java.lang.String r1, com.fyber.inneractive.sdk.util.p0 r2, com.fyber.inneractive.sdk.web.b.a r3, boolean r4) {
        /*
            r0 = this;
            AdContent r1 = r0.b
            r2 = 0
            if (r1 == 0) goto L_0x002f
            com.fyber.inneractive.sdk.flow.f0 r1 = (com.fyber.inneractive.sdk.flow.f0) r1
            com.fyber.inneractive.sdk.external.InneractiveAdRequest r3 = r1.a
            if (r3 == 0) goto L_0x002f
            T r1 = r1.b
            if (r1 == 0) goto L_0x002f
            r0.R()
            AdContent r1 = r0.b
            com.fyber.inneractive.sdk.flow.f0 r1 = (com.fyber.inneractive.sdk.flow.f0) r1
            T r1 = r1.b
            com.fyber.inneractive.sdk.response.g r1 = (com.fyber.inneractive.sdk.response.g) r1
            com.fyber.inneractive.sdk.model.vast.b r1 = r1.K
            if (r1 == 0) goto L_0x002b
            com.fyber.inneractive.sdk.model.vast.c r1 = r1.h
            if (r1 == 0) goto L_0x002b
            com.fyber.inneractive.sdk.model.vast.i r1 = r1.b
            if (r1 == 0) goto L_0x002b
            java.lang.String r1 = r1.toString()
            goto L_0x002c
        L_0x002b:
            r1 = r2
        L_0x002c:
            r0.a((java.lang.String) r1)
        L_0x002f:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.renderers.j.a(java.lang.String, com.fyber.inneractive.sdk.util.p0, com.fyber.inneractive.sdk.web.b$a, boolean):com.fyber.inneractive.sdk.util.b0$a");
    }

    public void m() {
        this.x = true;
        AdContent adcontent = this.b;
        if (adcontent != null) {
            h hVar = ((f0) adcontent).i;
        }
        IAlog.a("%sunit controller is null!", IAlog.a((Object) this));
    }

    public void a(String str, String str2) {
        IAlog.a(IAlog.a((Object) this) + "full screen video ad renderer callback: onSuspiciousNoUserWebActionDetected", new Object[0]);
    }

    public void a(View view, String str) {
        if (view != null && view.getContext() != null) {
            InneractiveRichMediaVideoPlayerActivityCore.startRichMediaIntent(view.getContext(), str);
            D();
        }
    }
}
