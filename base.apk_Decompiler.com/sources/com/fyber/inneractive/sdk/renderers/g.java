package com.fyber.inneractive.sdk.renderers;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.fyber.inneractive.sdk.R;
import com.fyber.inneractive.sdk.config.a0;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.config.t;
import com.fyber.inneractive.sdk.external.InneractiveAdViewEventsListener;
import com.fyber.inneractive.sdk.external.InneractiveAdViewUnitController;
import com.fyber.inneractive.sdk.external.InneractiveFullscreenUnitController;
import com.fyber.inneractive.sdk.flow.b0;
import com.fyber.inneractive.sdk.flow.r;
import com.fyber.inneractive.sdk.measurement.tracker.c;
import com.fyber.inneractive.sdk.ui.IAmraidWebViewController;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.n;
import com.fyber.inneractive.sdk.util.p;
import com.fyber.inneractive.sdk.util.q;
import com.fyber.inneractive.sdk.util.q0;
import com.fyber.inneractive.sdk.util.z;
import com.fyber.inneractive.sdk.web.i;
import com.ironsource.mediationsdk.utils.IronSourceConstants;

public class g extends r<b0, InneractiveAdViewEventsListener> implements com.fyber.inneractive.sdk.interfaces.b, z.b {
    public long l = 0;
    public InneractiveAdViewUnitController m;
    public IAmraidWebViewController n;
    public i.h o;
    public boolean p = false;
    public ViewGroup q;
    public RelativeLayout r;
    public long s = 0;
    public Runnable t;
    public int u = 0;
    public long v = 0;
    public boolean w = false;
    public boolean x = true;
    public boolean y = false;
    public b z;

    public static class a extends RelativeLayout {
        public final float a;

        public a(Context context, float f) {
            super(context);
            this.a = f;
        }

        public void onMeasure(int i, int i2) {
            int i3;
            View.MeasureSpec.getMode(i);
            int mode = View.MeasureSpec.getMode(i2);
            if (mode == 0 || (mode == Integer.MIN_VALUE && View.MeasureSpec.getSize(i2) > 0)) {
                int size = View.MeasureSpec.getSize(i);
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size, 1073741824);
                float f = this.a;
                if (f != 0.0f) {
                    i2 = View.MeasureSpec.makeMeasureSpec((int) (((float) size) * f), 1073741824);
                }
                i3 = makeMeasureSpec;
            } else {
                int size2 = View.MeasureSpec.getSize(i);
                int size3 = View.MeasureSpec.getSize(i2);
                i3 = View.MeasureSpec.makeMeasureSpec(size2, 1073741824);
                i2 = View.MeasureSpec.makeMeasureSpec(size3, 1073741824);
            }
            super.onMeasure(i3, i2);
        }
    }

    public enum b {
        BANNER_WIDTH(320),
        BANNER_HEIGHT(50),
        BANNER_TABLET_HEIGHT(90),
        BANNER_TABLET_WIDTH(728),
        RECTANGLE_HEIGHT(IronSourceConstants.INTERSTITIAL_DAILY_CAPPED),
        RECTANGLE_WIDTH(300);
        
        public final int value;

        /* access modifiers changed from: public */
        b(int i) {
            this.value = i;
        }
    }

    public void a() {
    }

    public void a(int i) {
        this.u = i;
    }

    public boolean canRefreshAd() {
        IAmraidWebViewController iAmraidWebViewController = this.n;
        if (iAmraidWebViewController != null) {
            return !iAmraidWebViewController.o() && !this.n.s();
        }
        return true;
    }

    public void destroy() {
        J();
        K();
        this.o = null;
        z.a.a.a.remove(this);
        Runnable runnable = this.t;
        if (runnable != null) {
            q.b.removeCallbacks(runnable);
        }
        super.destroy();
    }

    public void n() {
    }

    public int A() {
        IAmraidWebViewController iAmraidWebViewController = this.n;
        if (iAmraidWebViewController == null) {
            return -1;
        }
        if (iAmraidWebViewController.b == null || !iAmraidWebViewController.o()) {
            return p.b(this.n.e0);
        }
        return p.b(this.n.b.getWidth());
    }

    public final void K() {
        b bVar = this.z;
        if (bVar != null) {
            bVar.c();
        }
        if (this.n != null) {
            J();
            AdContent adcontent = this.b;
            if (adcontent != null) {
                ((b0) adcontent).a();
            }
            this.n = null;
            this.b = null;
            ViewGroup viewGroup = this.q;
            if (viewGroup != null) {
                viewGroup.removeView(this.r);
            }
            RelativeLayout relativeLayout = this.r;
            if (relativeLayout != null) {
                relativeLayout.removeAllViews();
                this.r = null;
            }
        }
        this.w = false;
    }

    public final void M() {
        InneractiveAdViewUnitController inneractiveAdViewUnitController;
        IAmraidWebViewController iAmraidWebViewController = this.n;
        if (iAmraidWebViewController != null && iAmraidWebViewController.b != null) {
            IAlog.a("%srefreshing ad", IAlog.a((Object) this));
            if ((!this.n.o() || this.n.s()) && (inneractiveAdViewUnitController = this.m) != null) {
                this.s = 0;
                inneractiveAdViewUnitController.refreshAd();
            }
        }
    }

    public final void N() {
        com.fyber.inneractive.sdk.web.g gVar;
        IAmraidWebViewController iAmraidWebViewController = this.n;
        if (iAmraidWebViewController != null && (gVar = iAmraidWebViewController.b) != null && gVar.getIsVisible() && this.s != 0 && !this.n.o() && !this.n.s()) {
            if (!this.x) {
                if (this.l < System.currentTimeMillis() - this.s) {
                    this.v = 1;
                } else {
                    this.v = this.l - (System.currentTimeMillis() - this.s);
                }
            }
            IAlog.a("%sresuming refresh runnable mRefreshTimeStamp %d", IAlog.a((Object) this), Long.valueOf(this.v));
            a(this.v, false);
        }
    }

    public boolean a(com.fyber.inneractive.sdk.flow.q qVar) {
        return qVar instanceof b0;
    }

    public void b(View view) {
        IAmraidWebViewController iAmraidWebViewController = this.n;
        if (iAmraidWebViewController != null) {
            iAmraidWebViewController.a(view, c.C0103c.ProgressOverlay);
        }
    }

    public void c(boolean z2) {
        IAlog.a("%sgot onLockScreenStateChanged with: %s", IAlog.a((Object) this), Boolean.valueOf(z2));
        if (z2) {
            d(false);
            b bVar = this.z;
            if (bVar != null && bVar.h) {
                bVar.c();
                return;
            }
            return;
        }
        N();
        b bVar2 = this.z;
        if (bVar2 != null) {
            bVar2.b();
        }
    }

    public int f() {
        return this.n.e0;
    }

    public int p() {
        return this.n.f0;
    }

    public void r() {
        com.fyber.inneractive.sdk.web.g gVar;
        IAlog.a("%sgot onAdRefreshFailed", IAlog.a((Object) this));
        IAmraidWebViewController iAmraidWebViewController = this.n;
        if (iAmraidWebViewController != null && (gVar = iAmraidWebViewController.b) != null) {
            if (!gVar.getIsVisible() || z.a.a.b || this.n.o() || this.n.s()) {
                IAlog.a("%sview is not visible or screen is locked or webView is Expanded or web is Resised. Waiting for visibility change", IAlog.a((Object) this));
                this.v = 1;
                return;
            }
            IAlog.a("%sview is visible and screen is unlocked: refreshing ad and webView is not expanded", IAlog.a((Object) this));
            long L = (long) L();
            this.l = L;
            if (L != 0) {
                a(10000, false);
            }
        }
    }

    public void u() {
        b bVar = this.z;
        if (bVar != null) {
            bVar.c();
        }
        RelativeLayout relativeLayout = this.r;
        if (relativeLayout != null) {
            relativeLayout.removeAllViews();
            this.r = null;
        }
        ViewGroup viewGroup = this.q;
        if (viewGroup != null) {
            viewGroup.removeAllViews();
            this.q = null;
        }
    }

    public View y() {
        IAmraidWebViewController iAmraidWebViewController = this.n;
        if (iAmraidWebViewController != null) {
            return iAmraidWebViewController.b;
        }
        return null;
    }

    public int z() {
        IAmraidWebViewController iAmraidWebViewController = this.n;
        if (iAmraidWebViewController == null) {
            return -1;
        }
        if (iAmraidWebViewController.b == null || !iAmraidWebViewController.o()) {
            return p.b(this.n.f0);
        }
        return p.b(this.n.b.getHeight());
    }

    public final void J() {
        if (this.t != null) {
            IAlog.a("%scancelling refreen runnable", IAlog.a((Object) this));
            q.b.removeCallbacks(this.t);
            this.t = null;
        }
    }

    public final int L() {
        t tVar;
        int intValue;
        int i = this.u;
        if (i == -1) {
            IAlog.a("%sreturning disable value for banner refresh", IAlog.a((Object) this));
            return 0;
        }
        if (i > 0) {
            IAlog.a("%sreturning overriden refresh interval = %d", IAlog.a((Object) this), Integer.valueOf(this.u));
            intValue = this.u;
        } else {
            com.fyber.inneractive.sdk.config.b0 b0Var = this.a.getAdContent().d;
            if (!(b0Var == null || (tVar = ((a0) b0Var).c) == null)) {
                Integer num = tVar.a;
                IAlog.a("%sreturning refreshConfig = %d", IAlog.a((Object) this), num);
                if (num != null) {
                    intValue = num.intValue();
                }
            }
            IAlog.a("%sgetRefreshInterval: returning 0. Refresh is disabled", IAlog.a((Object) this));
            return 0;
        }
        return intValue * 1000;
    }

    /* JADX WARNING: Removed duplicated region for block: B:71:0x01cc  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x01ef  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x01ff  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0207  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(android.view.ViewGroup r13) {
        /*
            r12 = this;
            com.fyber.inneractive.sdk.external.InneractiveAdSpot r0 = r12.a
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x0014
            java.lang.Object[] r13 = new java.lang.Object[r1]
            java.lang.String r0 = com.fyber.inneractive.sdk.util.IAlog.a((java.lang.Object) r12)
            r13[r2] = r0
            java.lang.String r0 = "%sYou must set the spot to render before calling renderAd"
            com.fyber.inneractive.sdk.util.IAlog.e(r0, r13)
            return
        L_0x0014:
            r12.p = r2
            r12.e = r2
            java.lang.String r3 = "InneractiveAdViewMraidAdRenderer.renderAd: Spot ad content is not the right content :( %s"
            if (r13 == 0) goto L_0x0027
            r12.q = r13
            com.fyber.inneractive.sdk.external.InneractiveUnitController r13 = r0.getSelectedUnitController()
            com.fyber.inneractive.sdk.external.InneractiveAdViewUnitController r13 = (com.fyber.inneractive.sdk.external.InneractiveAdViewUnitController) r13
            r12.m = r13
            goto L_0x0053
        L_0x0027:
            boolean r13 = r12.y
            if (r13 != 0) goto L_0x0053
            r12.K()
            com.fyber.inneractive.sdk.external.InneractiveAdSpot r13 = r12.a
            com.fyber.inneractive.sdk.flow.q r13 = r13.getAdContent()
            boolean r13 = r13 instanceof com.fyber.inneractive.sdk.flow.b0
            if (r13 == 0) goto L_0x0045
            com.fyber.inneractive.sdk.external.InneractiveAdSpot r13 = r12.a
            com.fyber.inneractive.sdk.flow.q r13 = r13.getAdContent()
            com.fyber.inneractive.sdk.flow.b0 r13 = (com.fyber.inneractive.sdk.flow.b0) r13
            r12.b = r13
            r12.f = r2
            goto L_0x0053
        L_0x0045:
            java.lang.Object[] r13 = new java.lang.Object[r1]
            com.fyber.inneractive.sdk.external.InneractiveAdSpot r0 = r12.a
            com.fyber.inneractive.sdk.flow.q r0 = r0.getAdContent()
            r13[r2] = r0
            com.fyber.inneractive.sdk.util.IAlog.e(r3, r13)
            return
        L_0x0053:
            AdContent r13 = r12.b
            r0 = 0
            if (r13 == 0) goto L_0x005e
            r4 = r13
            com.fyber.inneractive.sdk.flow.b0 r4 = (com.fyber.inneractive.sdk.flow.b0) r4
            com.fyber.inneractive.sdk.ui.IAmraidWebViewController r4 = r4.i
            goto L_0x005f
        L_0x005e:
            r4 = r0
        L_0x005f:
            r12.n = r4
            if (r4 == 0) goto L_0x021c
            com.fyber.inneractive.sdk.web.i$h r13 = r12.o
            if (r13 != 0) goto L_0x006e
            com.fyber.inneractive.sdk.renderers.e r13 = new com.fyber.inneractive.sdk.renderers.e
            r13.<init>(r12)
            r12.o = r13
        L_0x006e:
            com.fyber.inneractive.sdk.web.i$h r13 = r12.o
            r4.setListener(r13)
            AdContent r13 = r12.b
            com.fyber.inneractive.sdk.flow.b0 r13 = (com.fyber.inneractive.sdk.flow.b0) r13
            com.fyber.inneractive.sdk.external.InneractiveAdRequest r3 = r13.a
            com.fyber.inneractive.sdk.config.b0 r13 = r13.d
            r3 = -2
            r4 = 0
            if (r13 == 0) goto L_0x00bd
            com.fyber.inneractive.sdk.config.a0 r13 = (com.fyber.inneractive.sdk.config.a0) r13
            com.fyber.inneractive.sdk.config.t r5 = r13.c
            if (r5 == 0) goto L_0x00bd
            com.fyber.inneractive.sdk.config.t r5 = r13.c
            com.fyber.inneractive.sdk.config.enums.UnitDisplayType r5 = r5.b
            if (r5 == 0) goto L_0x00bd
            com.fyber.inneractive.sdk.config.t r13 = r13.c
            com.fyber.inneractive.sdk.config.enums.UnitDisplayType r13 = r13.b
            boolean r13 = r13.isFullscreenUnit()
            if (r13 == 0) goto L_0x00bd
            com.fyber.inneractive.sdk.renderers.g$a r13 = new com.fyber.inneractive.sdk.renderers.g$a
            android.view.ViewGroup r5 = r12.q
            android.content.Context r5 = r5.getContext()
            r6 = 1069547520(0x3fc00000, float:1.5)
            r13.<init>(r5, r6)
            r12.r = r13
            com.fyber.inneractive.sdk.ui.IAmraidWebViewController r5 = r12.n
            android.view.ViewGroup$LayoutParams r6 = new android.view.ViewGroup$LayoutParams
            r7 = -1
            r6.<init>(r7, r7)
            r5.a((android.view.ViewGroup) r13, (android.view.ViewGroup.LayoutParams) r6)
            android.view.ViewGroup r13 = r12.q
            android.widget.RelativeLayout r5 = r12.r
            android.view.ViewGroup$LayoutParams r6 = new android.view.ViewGroup$LayoutParams
            r6.<init>(r3, r3)
            r13.addView(r5, r6)
            goto L_0x01c8
        L_0x00bd:
            com.fyber.inneractive.sdk.renderers.g$a r13 = new com.fyber.inneractive.sdk.renderers.g$a
            android.view.ViewGroup r5 = r12.q
            android.content.Context r5 = r5.getContext()
            r13.<init>(r5, r4)
            r12.r = r13
            AdContent r13 = r12.b
            com.fyber.inneractive.sdk.flow.b0 r13 = (com.fyber.inneractive.sdk.flow.b0) r13
            T r5 = r13.b
            com.fyber.inneractive.sdk.response.f r5 = (com.fyber.inneractive.sdk.response.f) r5
            int r6 = r5.e
            int r5 = r5.f
            com.fyber.inneractive.sdk.config.b0 r13 = r13.d
            com.fyber.inneractive.sdk.util.q0 r13 = a(r6, r5, r13)
            com.fyber.inneractive.sdk.ui.IAmraidWebViewController r5 = r12.n
            int r6 = r13.a
            int r7 = r13.b
            r5.setAdDefaultSize(r6, r7)
            com.fyber.inneractive.sdk.ui.IAmraidWebViewController r5 = r12.n
            com.fyber.inneractive.sdk.web.g r6 = r5.b
            if (r6 != 0) goto L_0x011e
            android.app.Application r7 = com.fyber.inneractive.sdk.util.p.a
            if (r7 == 0) goto L_0x011e
            boolean r3 = r12.y
            if (r3 != 0) goto L_0x0119
            r12.y = r1
            AdContent r3 = r12.b
            com.fyber.inneractive.sdk.flow.b0 r3 = (com.fyber.inneractive.sdk.flow.b0) r3
            com.fyber.inneractive.sdk.config.global.s r3 = r3.c
            com.fyber.inneractive.sdk.web.g r3 = r5.a((com.fyber.inneractive.sdk.config.global.s) r3)
            r5.b = r3
            r5.h()     // Catch:{ all -> 0x0114 }
            com.fyber.inneractive.sdk.web.g r6 = r5.b
            java.lang.String r7 = r5.p
            java.lang.String r8 = r5.q
            java.lang.String r9 = "text/html"
            java.lang.String r10 = "utf-8"
            r11 = 0
            r6.loadDataWithBaseURL(r7, r8, r9, r10, r11)
            goto L_0x01c8
        L_0x0114:
            r12.a((com.fyber.inneractive.sdk.util.q0) r13)
            goto L_0x01c8
        L_0x0119:
            r12.a((com.fyber.inneractive.sdk.util.q0) r13)
            goto L_0x01c8
        L_0x011e:
            if (r6 == 0) goto L_0x0125
            android.view.ViewParent r5 = r6.getParent()
            goto L_0x0126
        L_0x0125:
            r5 = r0
        L_0x0126:
            boolean r7 = r5 instanceof android.view.ViewGroup
            if (r7 == 0) goto L_0x012f
            android.view.ViewGroup r5 = (android.view.ViewGroup) r5
            r5.removeView(r6)
        L_0x012f:
            int r5 = r13.a
            int r13 = r13.b
            r6 = 13
            int[] r6 = new int[]{r6}
            android.widget.RelativeLayout$LayoutParams r13 = com.fyber.inneractive.sdk.util.u.a(r5, r13, r6)
            com.fyber.inneractive.sdk.ui.IAmraidWebViewController r5 = r12.n
            android.widget.RelativeLayout r6 = r12.r
            r5.a((android.view.ViewGroup) r6, (android.view.ViewGroup.LayoutParams) r13)
            android.view.ViewGroup r13 = r12.q
            android.widget.RelativeLayout r5 = r12.r
            android.view.ViewGroup$LayoutParams r6 = new android.view.ViewGroup$LayoutParams
            r6.<init>(r3, r3)
            r13.addView(r5, r6)
            com.fyber.inneractive.sdk.external.InneractiveAdSpot r13 = r12.a
            if (r13 == 0) goto L_0x01c8
            com.fyber.inneractive.sdk.flow.q r13 = r13.getAdContent()
            if (r13 == 0) goto L_0x01c8
            android.view.ViewGroup r13 = r12.q
            if (r13 == 0) goto L_0x01c8
            com.fyber.inneractive.sdk.flow.e r13 = new com.fyber.inneractive.sdk.flow.e
            com.fyber.inneractive.sdk.external.InneractiveAdSpot r3 = r12.a
            com.fyber.inneractive.sdk.flow.q r3 = r3.getAdContent()
            com.fyber.inneractive.sdk.external.InneractiveAdRequest r3 = r3.a
            com.fyber.inneractive.sdk.external.InneractiveAdSpot r5 = r12.a
            com.fyber.inneractive.sdk.flow.q r5 = r5.getAdContent()
            com.fyber.inneractive.sdk.response.e r5 = r5.d()
            com.fyber.inneractive.sdk.external.InneractiveAdSpot r6 = r12.a
            com.fyber.inneractive.sdk.flow.q r6 = r6.getAdContent()
            com.fyber.inneractive.sdk.config.global.s r6 = r6.c
            r13.<init>(r3, r5, r6)
            android.view.ViewGroup r3 = r12.q
            android.content.Context r3 = r3.getContext()
            int r5 = com.fyber.inneractive.sdk.R.layout.fyber_ad_identifier_relative_layout
            android.view.View r3 = android.widget.RelativeLayout.inflate(r3, r5, r0)
            android.widget.RelativeLayout r3 = (android.widget.RelativeLayout) r3
            com.fyber.inneractive.sdk.ui.FyberAdIdentifier$Corner r5 = com.fyber.inneractive.sdk.ui.FyberAdIdentifier.Corner.BOTTOM_LEFT
            r13.a(r3, r5)
            r3.setVisibility(r2)
            r13 = 83
            r3.setGravity(r13)
            com.fyber.inneractive.sdk.ui.IAmraidWebViewController r13 = r12.n
            if (r13 != 0) goto L_0x019e
            r13 = r0
            goto L_0x01ae
        L_0x019e:
            com.fyber.inneractive.sdk.web.g r13 = r13.b
            if (r13 == 0) goto L_0x01ae
            android.view.ViewParent r5 = r13.getParent()
            if (r5 == 0) goto L_0x01ae
            android.view.ViewParent r13 = r13.getParent()
            android.view.ViewGroup r13 = (android.view.ViewGroup) r13
        L_0x01ae:
            if (r13 == 0) goto L_0x01c8
            android.view.View r5 = r12.y()
            if (r5 == 0) goto L_0x01c8
            android.view.View r5 = r12.y()
            android.view.ViewGroup$LayoutParams r5 = r5.getLayoutParams()
            com.fyber.inneractive.sdk.ui.IAmraidWebViewController r6 = r12.n
            r13.addView(r3, r5)
            com.fyber.inneractive.sdk.measurement.tracker.c$c r13 = com.fyber.inneractive.sdk.measurement.tracker.c.C0103c.IdentifierView
            r6.a((android.view.View) r3, (com.fyber.inneractive.sdk.measurement.tracker.c.C0103c) r13)
        L_0x01c8:
            AdContent r13 = r12.b
            if (r13 == 0) goto L_0x01d3
            com.fyber.inneractive.sdk.flow.b0 r13 = (com.fyber.inneractive.sdk.flow.b0) r13
            T r13 = r13.b
            r0 = r13
            com.fyber.inneractive.sdk.response.f r0 = (com.fyber.inneractive.sdk.response.f) r0
        L_0x01d3:
            if (r0 == 0) goto L_0x0223
            android.widget.RelativeLayout r13 = r12.r
            if (r13 == 0) goto L_0x0223
            com.fyber.inneractive.sdk.renderers.b r3 = new com.fyber.inneractive.sdk.renderers.b
            com.fyber.inneractive.sdk.renderers.d r5 = new com.fyber.inneractive.sdk.renderers.d
            r5.<init>(r12)
            r3.<init>(r0, r13, r5)
            r12.z = r3
            r3.i = r2
            r3.e = r1
            r3.f = r4
            int r13 = r0.t
            if (r13 < r1) goto L_0x01f7
            r5 = 100
            int r13 = java.lang.Math.min(r13, r5)
            r3.e = r13
        L_0x01f7:
            float r13 = r0.u
            r0 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r0 = (r13 > r0 ? 1 : (r13 == r0 ? 0 : -1))
            if (r0 < 0) goto L_0x0201
            r3.f = r13
        L_0x0201:
            float r13 = r3.f
            int r13 = (r13 > r4 ? 1 : (r13 == r4 ? 0 : -1))
            if (r13 < 0) goto L_0x0223
            java.lang.Object[] r13 = new java.lang.Object[r2]
            java.lang.String r0 = "IAVisibilityTracker: startTrackingVisibility"
            com.fyber.inneractive.sdk.util.IAlog.a(r0, r13)
            r3.d = r4
            long r4 = java.lang.System.currentTimeMillis()
            r3.g = r4
            r3.h = r1
            r3.a()
            goto L_0x0223
        L_0x021c:
            java.lang.Object[] r0 = new java.lang.Object[r1]
            r0[r2] = r13
            com.fyber.inneractive.sdk.util.IAlog.e(r3, r0)
        L_0x0223:
            com.fyber.inneractive.sdk.util.z r13 = com.fyber.inneractive.sdk.util.z.a.a
            java.util.List<com.fyber.inneractive.sdk.util.z$b> r0 = r13.a
            boolean r0 = r0.contains(r12)
            if (r0 != 0) goto L_0x0232
            java.util.List<com.fyber.inneractive.sdk.util.z$b> r13 = r13.a
            r13.add(r12)
        L_0x0232:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.renderers.g.a(android.view.ViewGroup):void");
    }

    public final void d(boolean z2) {
        if (this.t != null) {
            this.x = z2;
            J();
            this.v = this.l - (System.currentTimeMillis() - this.s);
            IAlog.a("%sPause refresh time : time remaning:%d ,refreshInterval: %d", IAlog.a((Object) this), Long.valueOf(this.v), Long.valueOf(this.l));
        }
    }

    public void c(View view) {
        IAmraidWebViewController iAmraidWebViewController = this.n;
        if (iAmraidWebViewController != null) {
            iAmraidWebViewController.b(view);
        }
    }

    public final void a(long j, boolean z2) {
        IAmraidWebViewController iAmraidWebViewController;
        com.fyber.inneractive.sdk.web.g gVar;
        if (TextUtils.isEmpty(this.a.getMediationNameString()) && j != 0 && !(this.a.getSelectedUnitController() instanceof InneractiveFullscreenUnitController) && this.u != -1 && (iAmraidWebViewController = this.n) != null && (gVar = iAmraidWebViewController.b) != null) {
            if (!gVar.getIsVisible()) {
                IAlog.a("%sstartRefreshTimer called but ad is not visible", IAlog.a((Object) this));
                return;
            }
            this.s = System.currentTimeMillis();
            this.l = z2 ? this.l : j;
            IAlog.a("%sstartRefreshTimer in %d msec, mRefreshInterval = %d", IAlog.a((Object) this), Long.valueOf(j), Long.valueOf(this.l));
            if (j > 1) {
                Runnable runnable = this.t;
                if (runnable != null) {
                    q.b.removeCallbacks(runnable);
                }
                J();
                f fVar = new f(this);
                this.t = fVar;
                q.b.postDelayed(fVar, j);
                return;
            }
            M();
        }
    }

    public static q0 a(int i, int i2, com.fyber.inneractive.sdk.config.b0 b0Var) {
        int i3;
        int i4;
        t tVar;
        IAlog.a("View layout params: response width and height: %d, %d", Integer.valueOf(i), Integer.valueOf(i2));
        if (i <= 0 || i2 <= 0) {
            UnitDisplayType unitDisplayType = UnitDisplayType.BANNER;
            if (!(b0Var == null || (tVar = ((a0) b0Var).c) == null)) {
                unitDisplayType = tVar.b;
            }
            if (unitDisplayType.equals(UnitDisplayType.MRECT)) {
                i4 = p.a((float) b.RECTANGLE_WIDTH.value);
                i3 = p.a((float) b.RECTANGLE_HEIGHT.value);
            } else if (n.o()) {
                i4 = p.a((float) b.BANNER_TABLET_WIDTH.value);
                i3 = p.a((float) b.BANNER_TABLET_HEIGHT.value);
            } else {
                i4 = p.a((float) b.BANNER_WIDTH.value);
                i3 = p.a((float) b.BANNER_HEIGHT.value);
            }
        } else {
            i4 = p.a((float) i);
            i3 = p.a((float) i2);
        }
        IAlog.d("View layout params: final scaled width and height: %d, %d", Integer.valueOf(i4), Integer.valueOf(i3));
        return new q0(i4, i3);
    }

    public boolean a(View view) {
        return view.equals(this.q);
    }

    public final void a(q0 q0Var) {
        FrameLayout frameLayout = new FrameLayout(this.q.getContext());
        frameLayout.setBackgroundResource(R.color.blank_background);
        this.q.removeAllViews();
        this.q.addView(frameLayout, new FrameLayout.LayoutParams(q0Var.a, q0Var.b, 17));
    }
}
