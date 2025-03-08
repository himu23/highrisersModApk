package com.fyber.inneractive.sdk.flow;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.fyber.inneractive.sdk.R;
import com.fyber.inneractive.sdk.activities.InneractiveInternalBrowserActivity;
import com.fyber.inneractive.sdk.cache.session.c;
import com.fyber.inneractive.sdk.cache.session.d;
import com.fyber.inneractive.sdk.click.b;
import com.fyber.inneractive.sdk.click.f;
import com.fyber.inneractive.sdk.click.l;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.a0;
import com.fyber.inneractive.sdk.config.b0;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.config.f0;
import com.fyber.inneractive.sdk.config.global.s;
import com.fyber.inneractive.sdk.external.ImpressionData;
import com.fyber.inneractive.sdk.external.InneractiveAdRenderer;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.external.InneractiveAdViewEventsListenerWithImpressionData;
import com.fyber.inneractive.sdk.external.InneractiveFullscreenAdEventsListenerWithImpressionData;
import com.fyber.inneractive.sdk.external.InneractiveUnitController;
import com.fyber.inneractive.sdk.external.InneractiveUnitController.EventsListener;
import com.fyber.inneractive.sdk.external.OnGlobalImpressionDataListener;
import com.fyber.inneractive.sdk.flow.q;
import com.fyber.inneractive.sdk.ignite.k;
import com.fyber.inneractive.sdk.network.j0;
import com.fyber.inneractive.sdk.network.q0;
import com.fyber.inneractive.sdk.network.s;
import com.fyber.inneractive.sdk.network.t;
import com.fyber.inneractive.sdk.response.e;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.i;
import com.fyber.inneractive.sdk.util.p0;
import com.fyber.inneractive.sdk.web.r;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public abstract class r<AdContent extends q, EventsListener extends InneractiveUnitController.EventsListener> implements InneractiveAdRenderer, InneractiveInternalBrowserActivity.InternalBrowserListener, f.a, r.g {
    public InneractiveAdSpot a;
    public AdContent b;
    public EventsListener c;
    public boolean d = false;
    public boolean e = false;
    public boolean f = false;
    public boolean g = true;
    public Runnable h;
    public l i;
    public l.b j;
    public View k;

    public class a implements l.b {
        public final /* synthetic */ p0 a;
        public final /* synthetic */ i b;

        public a(p0 p0Var, i iVar) {
            this.a = p0Var;
            this.b = iVar;
        }

        public void a(b bVar) {
            r rVar = r.this;
            rVar.getClass();
            IAlog.a("%s super click result: %s", IAlog.a((Object) rVar), bVar);
            r rVar2 = r.this;
            if (rVar2.i == null) {
                rVar2.getClass();
                IAlog.a("%s click handler is null. Probably cancelled", IAlog.a((Object) rVar2));
                return;
            }
            rVar2.i = null;
            rVar2.j = null;
            rVar2.H();
            if (bVar != null) {
                r rVar3 = r.this;
                p0 p0Var = this.a;
                i iVar = this.b;
                rVar3.getClass();
                l.d dVar = bVar.a;
                if (dVar == l.d.OPEN_IN_EXTERNAL_APPLICATION || dVar == l.d.OPEN_GOOGLE_STORE) {
                    IAlog.a("InneractiveAdRendererImpl: handleOpenResult - opened in external application", new Object[0]);
                    List<com.fyber.inneractive.sdk.click.i> list = bVar.f;
                    com.fyber.inneractive.sdk.click.i iVar2 = list.get(list.size() - 1);
                    l.d dVar2 = iVar2.c;
                    if (dVar2 == l.d.OPENED_IN_EXTERNAL_BROWSER) {
                        rVar3.a(iVar2.a, dVar2);
                    }
                    if (rVar3.c != null) {
                        rVar3.G();
                    }
                } else if (dVar == l.d.OPENED_IN_INTERNAL_BROWSER) {
                    IAlog.a("InneractiveAdRendererImpl: handleOpenResult - opened in internal browser", new Object[0]);
                    rVar3.d = true;
                    InneractiveInternalBrowserActivity.setInternalBrowserListener(rVar3);
                } else if (dVar == l.d.OPENED_USING_CHROME_NAVIGATE || dVar == l.d.OPENED_IN_EXTERNAL_BROWSER) {
                    IAlog.a("InneractiveAdRendererImpl: handleOpenResult - opened in external browser", new Object[0]);
                    rVar3.a(bVar.d, bVar.a);
                    if (rVar3.c != null) {
                        rVar3.G();
                    }
                }
                if (rVar3.q() == k.NONE || (!TextUtils.isEmpty(bVar.c) && !bVar.c.equals("IgniteGooglePlay"))) {
                    rVar3.b(bVar, p0Var, iVar);
                }
            }
        }
    }

    public int A() {
        return -1;
    }

    public void H() {
        View y = y();
        if (y != null && this.k != null && y.getParent() != null && (y.getParent() instanceof ViewGroup)) {
            y.getLayoutParams();
            ((ViewGroup) y.getParent()).removeView(this.k);
            c(this.k);
            this.k = null;
        }
    }

    public void I() {
        AdContent adcontent = this.b;
        if (adcontent != null && adcontent.d() != null) {
            String str = this.b.d().o;
            if (!TextUtils.isEmpty(str)) {
                IAlog.d("%sfiring rewarded completion!", IAlog.a((Object) this));
                int i2 = IAlog.a;
                IAlog.a(1, (Exception) null, "AD_REWARDED_COMPLETION", new Object[0]);
                j0.b(str);
            }
        }
    }

    public void b(View view) {
    }

    public void b(e eVar) {
        String str = eVar.k;
        if (str != null && str.trim().length() > 0) {
            IAlog.d("%sfiring impression!", IAlog.a((Object) this));
            int i2 = IAlog.a;
            IAlog.a(1, (Exception) null, "AD_IMPRESSION", new Object[0]);
            j0.b(str);
        }
    }

    public void c(View view) {
    }

    public boolean canRefreshAd() {
        return true;
    }

    public void onApplicationInBackground() {
        G();
        this.f = false;
    }

    public void onInternalBrowserDismissed() {
        IAlog.a("onInternalBrowserDismissed callback called", new Object[0]);
        if (this.d) {
            this.d = false;
            InneractiveInternalBrowserActivity.setInternalBrowserListener((InneractiveInternalBrowserActivity.InternalBrowserListener) null);
        }
        F();
        this.f = false;
    }

    public k q() {
        AdContent adcontent = this.b;
        if (adcontent == null || !adcontent.f() || this.b.d() == null) {
            return k.NONE;
        }
        return this.b.d().F;
    }

    public void x() {
        View y = y();
        if (y != null && y.getParent() != null && (y.getParent() instanceof ViewGroup) && this.k == null) {
            View inflate = ViewGroup.inflate(y.getContext(), R.layout.ia_click_overlay, (ViewGroup) null);
            this.k = inflate;
            if (inflate != null) {
                ((ViewGroup) y.getParent()).addView(this.k, y.getLayoutParams());
                b(this.k);
            }
        }
    }

    public abstract View y();

    public int z() {
        return -1;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean B() {
        /*
            r2 = this;
            AdContent r0 = r2.b
            if (r0 == 0) goto L_0x002a
            com.fyber.inneractive.sdk.config.global.s r0 = r0.c
            if (r0 == 0) goto L_0x002a
            java.lang.Class<com.fyber.inneractive.sdk.config.global.features.b> r1 = com.fyber.inneractive.sdk.config.global.features.b.class
            com.fyber.inneractive.sdk.config.global.features.g r0 = r0.a(r1)
            if (r0 == 0) goto L_0x002a
            AdContent r0 = r2.b
            com.fyber.inneractive.sdk.config.global.s r0 = r0.c
            java.lang.Class<com.fyber.inneractive.sdk.config.global.features.b> r1 = com.fyber.inneractive.sdk.config.global.features.b.class
            com.fyber.inneractive.sdk.config.global.features.g r0 = r0.a(r1)
            com.fyber.inneractive.sdk.config.global.features.b r0 = (com.fyber.inneractive.sdk.config.global.features.b) r0
            java.util.List r0 = r0.c()
            java.util.ArrayList r0 = (java.util.ArrayList) r0
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x002a
            r0 = 1
            goto L_0x002b
        L_0x002a:
            r0 = 0
        L_0x002b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.flow.r.B():boolean");
    }

    public boolean C() {
        AdContent adcontent = this.b;
        if (adcontent != null) {
            return adcontent.e();
        }
        return true;
    }

    public void destroy() {
        if (this.d) {
            InneractiveInternalBrowserActivity.setInternalBrowserListener((InneractiveInternalBrowserActivity.InternalBrowserListener) null);
            this.d = false;
        }
        Runnable runnable = this.h;
        if (runnable != null) {
            com.fyber.inneractive.sdk.util.q.b.removeCallbacks(runnable);
            this.h = null;
        }
        this.b = null;
        this.c = null;
        this.a = null;
        if (this.i != null) {
            H();
            q0 q0Var = this.i.g;
            if (q0Var != null) {
                q0Var.a = true;
            }
            this.i = null;
            this.j = null;
        }
    }

    public void D() {
        e d2;
        if (this.c != null) {
            IAlog.a("%sCalling external interface onAdClicked", IAlog.a((Object) this));
            this.c.onAdClicked(this.a);
        }
        AdContent adcontent = this.b;
        if (adcontent != null && (d2 = adcontent.d()) != null) {
            IAConfigManager.M.x.a(d2.n, "LAST_CLICKED", "1");
        }
    }

    public void E() {
        e d2;
        OnGlobalImpressionDataListener onGlobalImpressionDataListener;
        if (!this.e && this.c != null) {
            IAlog.a("%sCalling external interface onAdImpression", IAlog.a((Object) this));
            this.c.onAdImpression(this.a);
            AdContent adcontent = this.b;
            if (!(adcontent == null || (d2 = adcontent.d()) == null)) {
                IAConfigManager iAConfigManager = IAConfigManager.M;
                f0 f0Var = iAConfigManager.x;
                if (f0Var != null) {
                    UnitDisplayType unitDisplayType = d2.n;
                    ImpressionData impressionData = d2.r;
                    f0Var.a(unitDisplayType, "LAST_DOMAIN_SHOWED", impressionData != null ? impressionData.getAdvertiserDomain() : null);
                    f0Var.a(unitDisplayType, "LAST_APP_BUNDLE_ID", d2.y);
                    if (this.b.isVideoAd()) {
                        f0Var.a(unitDisplayType, "LAST_VAST_SKIPED");
                        f0Var.a(unitDisplayType, "LAST_VAST_CLICKED_TYPE");
                    }
                    f0Var.a(unitDisplayType, "LAST_CLICKED");
                }
                com.fyber.inneractive.sdk.util.j0 j0Var = iAConfigManager.A;
                b0 b0Var = this.b.d;
                ImpressionData impressionData2 = d2.r;
                j0Var.getClass();
                if (!(b0Var == null || (onGlobalImpressionDataListener = j0Var.a) == null)) {
                    a0 a0Var = (a0) b0Var;
                    onGlobalImpressionDataListener.onImpression(a0Var.b, a0Var.a, impressionData2);
                }
                EventsListener eventslistener = this.c;
                if (eventslistener instanceof InneractiveFullscreenAdEventsListenerWithImpressionData) {
                    ((InneractiveFullscreenAdEventsListenerWithImpressionData) eventslistener).onAdImpression(this.a, d2.r);
                } else if (eventslistener instanceof InneractiveAdViewEventsListenerWithImpressionData) {
                    ((InneractiveAdViewEventsListenerWithImpressionData) eventslistener).onAdImpression(this.a, d2.r);
                }
            }
            this.e = true;
        }
    }

    public void F() {
        if (this.c != null) {
            IAlog.a("%sCalling external interface onAdWillCloseInternalBrowser", IAlog.a((Object) this));
            this.c.onAdWillCloseInternalBrowser(this.a);
        }
    }

    public void G() {
        if (this.c != null) {
            IAlog.a("%sCalling external interface onAdWillOpenExternalApp", IAlog.a((Object) this));
            this.c.onAdWillOpenExternalApp(this.a);
        }
        this.f = false;
    }

    public void initialize(InneractiveAdSpot inneractiveAdSpot) {
        this.a = inneractiveAdSpot;
        this.b = inneractiveAdSpot.getAdContent();
        this.c = inneractiveAdSpot.getSelectedUnitController().getEventsListener();
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x011f  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0125  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0128  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x0136  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0138  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0156  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x015f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.fyber.inneractive.sdk.util.b0.a a(android.content.Context r17, java.lang.String r18, com.fyber.inneractive.sdk.util.p0 r19, com.fyber.inneractive.sdk.util.i r20) {
        /*
            r16 = this;
            r0 = r16
            r1 = r19
            r2 = r20
            boolean r3 = r0.g
            java.lang.String r4 = "none"
            r5 = 1
            r6 = 0
            if (r3 == 0) goto L_0x017d
            boolean r3 = r0.d
            if (r3 == 0) goto L_0x0014
            goto L_0x017d
        L_0x0014:
            if (r17 == 0) goto L_0x003c
            java.lang.Object[] r3 = new java.lang.Object[r5]
            java.lang.String r7 = com.fyber.inneractive.sdk.util.IAlog.a((java.lang.Object) r16)
            r3[r6] = r7
            java.lang.String r7 = "%sBlocking clicks until grace has ended"
            com.fyber.inneractive.sdk.util.IAlog.a(r7, r3)
            r0.g = r6
            java.lang.Runnable r3 = r0.h
            if (r3 == 0) goto L_0x002e
            android.os.Handler r7 = com.fyber.inneractive.sdk.util.q.b
            r7.removeCallbacks(r3)
        L_0x002e:
            com.fyber.inneractive.sdk.flow.s r3 = new com.fyber.inneractive.sdk.flow.s
            r3.<init>(r0)
            r0.h = r3
            android.os.Handler r7 = com.fyber.inneractive.sdk.util.q.b
            r8 = 1000(0x3e8, double:4.94E-321)
            r7.postDelayed(r3, r8)
        L_0x003c:
            r16.D()
            boolean r3 = android.text.TextUtils.isEmpty(r18)
            if (r3 == 0) goto L_0x005b
            java.lang.Object[] r1 = new java.lang.Object[r6]
            java.lang.String r2 = "InneractiveAdRendererImpl: openClickThroughUrl - is empty"
            com.fyber.inneractive.sdk.util.IAlog.a(r2, r1)
            com.fyber.inneractive.sdk.util.b0$a r1 = new com.fyber.inneractive.sdk.util.b0$a
            com.fyber.inneractive.sdk.util.b0$d r2 = com.fyber.inneractive.sdk.util.b0.d.FAILED
            java.lang.Exception r3 = new java.lang.Exception
            java.lang.String r5 = "empty url"
            r3.<init>(r5)
            r1.<init>(r2, r3, r4)
            return r1
        L_0x005b:
            com.fyber.inneractive.sdk.config.IAConfigManager r3 = com.fyber.inneractive.sdk.config.IAConfigManager.M
            com.fyber.inneractive.sdk.ignite.c r4 = r3.E
            r15 = 0
            if (r4 == 0) goto L_0x007d
            AdContent r4 = r0.b
            if (r4 == 0) goto L_0x007d
            com.fyber.inneractive.sdk.response.e r4 = r4.d()
            if (r4 == 0) goto L_0x007d
            AdContent r4 = r0.b
            com.fyber.inneractive.sdk.response.e r4 = r4.d()
            boolean r4 = r4.b()
            if (r4 == 0) goto L_0x007d
            com.fyber.inneractive.sdk.ignite.c r3 = r3.E
            r3.a((com.fyber.inneractive.sdk.ignite.h) r15)
        L_0x007d:
            com.fyber.inneractive.sdk.flow.r$a r3 = new com.fyber.inneractive.sdk.flow.r$a
            r3.<init>(r1, r2)
            r0.j = r3
            boolean r3 = android.text.TextUtils.isEmpty(r18)
            if (r3 != 0) goto L_0x00b1
            android.net.Uri r3 = android.net.Uri.parse(r18)
            java.lang.String r4 = r3.getScheme()
            java.lang.String r7 = r3.getHost()
            if (r4 == 0) goto L_0x00b1
            java.lang.String r8 = "fybernativebrowser"
            boolean r4 = r4.equals(r8)
            if (r4 == 0) goto L_0x00b1
            if (r7 == 0) goto L_0x00b1
            java.lang.String r4 = "navigate"
            boolean r4 = r7.equals(r4)
            if (r4 == 0) goto L_0x00b1
            java.lang.String r4 = "url"
            java.lang.String r3 = r3.getQueryParameter(r4)
            goto L_0x00b2
        L_0x00b1:
            r3 = r15
        L_0x00b2:
            boolean r4 = android.text.TextUtils.isEmpty(r18)
            if (r4 != 0) goto L_0x00c1
            android.net.Uri r4 = android.net.Uri.parse(r18)
            java.lang.String r4 = r4.getScheme()
            goto L_0x00c2
        L_0x00c1:
            r4 = r15
        L_0x00c2:
            boolean r7 = android.text.TextUtils.isEmpty(r3)
            if (r7 != 0) goto L_0x00cb
            r9 = r3
        L_0x00c9:
            r3 = 0
            goto L_0x00d8
        L_0x00cb:
            java.lang.String r3 = "FYBER_OPEN_BROWSER"
            r7 = r18
            boolean r3 = r7.contains(r3)
            r9 = r7
            if (r3 == 0) goto L_0x00d7
            goto L_0x00c9
        L_0x00d7:
            r3 = 1
        L_0x00d8:
            android.view.View r7 = r16.y()
            if (r7 == 0) goto L_0x00e1
            r16.x()
        L_0x00e1:
            com.fyber.inneractive.sdk.click.l r7 = new com.fyber.inneractive.sdk.click.l
            r7.<init>(r3)
            r8 = 5
            com.fyber.inneractive.sdk.click.a[] r8 = new com.fyber.inneractive.sdk.click.a[r8]
            com.fyber.inneractive.sdk.click.h r10 = new com.fyber.inneractive.sdk.click.h
            r3 = r3 ^ r5
            r10.<init>(r4, r3)
            r8[r6] = r10
            com.fyber.inneractive.sdk.click.f r3 = new com.fyber.inneractive.sdk.click.f
            r3.<init>(r0, r1, r2)
            r8[r5] = r3
            com.fyber.inneractive.sdk.click.d r3 = new com.fyber.inneractive.sdk.click.d
            r3.<init>()
            r4 = 2
            r8[r4] = r3
            com.fyber.inneractive.sdk.click.g r3 = new com.fyber.inneractive.sdk.click.g
            r3.<init>()
            r4 = 3
            r8[r4] = r3
            com.fyber.inneractive.sdk.click.j r3 = new com.fyber.inneractive.sdk.click.j
            r3.<init>()
            r4 = 4
            r8[r4] = r3
            java.util.ArrayList<com.fyber.inneractive.sdk.click.a> r3 = r7.h
            java.util.List r4 = java.util.Arrays.asList(r8)
            r3.addAll(r4)
            r0.i = r7
            AdContent r3 = r0.b
            if (r3 == 0) goto L_0x0125
            com.fyber.inneractive.sdk.web.r r3 = r3.c()
            r11 = r3
            goto L_0x0126
        L_0x0125:
            r11 = r15
        L_0x0126:
            if (r11 == 0) goto L_0x012a
            r11.i = r0
        L_0x012a:
            AdContent r3 = r0.b
            if (r3 == 0) goto L_0x0138
            boolean r1 = r1.c
            boolean r1 = r3.a(r1, r2)
            if (r1 == 0) goto L_0x0138
            r12 = 1
            goto L_0x0139
        L_0x0138:
            r12 = 0
        L_0x0139:
            AdContent r1 = r0.b
            if (r1 == 0) goto L_0x0148
            com.fyber.inneractive.sdk.response.e r1 = r1.d()
            if (r1 == 0) goto L_0x0148
            AdContent r1 = r0.b
            r1.i()
        L_0x0148:
            com.fyber.inneractive.sdk.click.l r7 = r0.i
            com.fyber.inneractive.sdk.click.l$b r10 = r0.j
            AdContent r1 = r0.b
            if (r1 == 0) goto L_0x015f
            com.fyber.inneractive.sdk.response.e r1 = r1.d()
            if (r1 == 0) goto L_0x015f
            AdContent r1 = r0.b
            com.fyber.inneractive.sdk.response.e r1 = r1.d()
            com.fyber.inneractive.sdk.ignite.k r1 = r1.F
            goto L_0x0161
        L_0x015f:
            com.fyber.inneractive.sdk.ignite.k r1 = com.fyber.inneractive.sdk.ignite.k.NONE
        L_0x0161:
            r13 = r1
            com.fyber.inneractive.sdk.external.InneractiveAdSpot r1 = r0.a
            java.lang.String r14 = r1.getLocalUniqueId()
            r8 = r17
            r7.a(r8, r9, r10, r11, r12, r13, r14)
            com.fyber.inneractive.sdk.util.b0$a r1 = new com.fyber.inneractive.sdk.util.b0$a
            com.fyber.inneractive.sdk.util.b0$d r2 = com.fyber.inneractive.sdk.util.b0.d.OPEN_IN_EXTERNAL_APPLICATION
            java.lang.Class r3 = r17.getClass()
            java.lang.String r3 = r3.getName()
            r1.<init>(r2, r15, r3)
            return r1
        L_0x017d:
            boolean r1 = r0.d
            if (r1 == 0) goto L_0x0184
            java.lang.String r1 = "external/browser is already open"
            goto L_0x0186
        L_0x0184:
            java.lang.String r1 = "click is in grace period"
        L_0x0186:
            java.lang.Object[] r2 = new java.lang.Object[r5]
            r2[r6] = r1
            java.lang.String r3 = "InneractiveAdRendererImpl: openClickThroughUrl - %s"
            com.fyber.inneractive.sdk.util.IAlog.a(r3, r2)
            com.fyber.inneractive.sdk.util.b0$a r2 = new com.fyber.inneractive.sdk.util.b0$a
            com.fyber.inneractive.sdk.util.b0$d r3 = com.fyber.inneractive.sdk.util.b0.d.FAILED
            java.lang.Exception r5 = new java.lang.Exception
            r5.<init>(r1)
            r2.<init>(r3, r5, r4)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.flow.r.a(android.content.Context, java.lang.String, com.fyber.inneractive.sdk.util.p0, com.fyber.inneractive.sdk.util.i):com.fyber.inneractive.sdk.util.b0$a");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:82:0x019b, code lost:
        if (r10.a("show_cta", true) != false) goto L_0x019d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(com.fyber.inneractive.sdk.click.b r9, com.fyber.inneractive.sdk.util.p0 r10, com.fyber.inneractive.sdk.util.i r11) {
        /*
            r8 = this;
            AdContent r0 = r8.b
            r1 = 0
            if (r0 == 0) goto L_0x0008
            com.fyber.inneractive.sdk.external.InneractiveAdRequest r2 = r0.a
            goto L_0x0009
        L_0x0008:
            r2 = r1
        L_0x0009:
            if (r0 == 0) goto L_0x0010
            com.fyber.inneractive.sdk.response.e r0 = r0.d()
            goto L_0x0011
        L_0x0010:
            r0 = r1
        L_0x0011:
            AdContent r3 = r8.b
            if (r3 == 0) goto L_0x001e
            com.fyber.inneractive.sdk.config.global.s r3 = r3.c
            if (r3 == 0) goto L_0x001e
            org.json.JSONArray r3 = r3.c()
            goto L_0x001f
        L_0x001e:
            r3 = r1
        L_0x001f:
            com.fyber.inneractive.sdk.network.s$a r4 = new com.fyber.inneractive.sdk.network.s$a
            com.fyber.inneractive.sdk.network.r r5 = com.fyber.inneractive.sdk.network.r.FYBER_SUCCESS_CLICK
            r4.<init>((com.fyber.inneractive.sdk.network.r) r5, (com.fyber.inneractive.sdk.external.InneractiveAdRequest) r2, (com.fyber.inneractive.sdk.response.e) r0, (org.json.JSONArray) r3)
            com.fyber.inneractive.sdk.network.s$b r0 = new com.fyber.inneractive.sdk.network.s$b
            r0.<init>()
            long r2 = r9.e
            r5 = 0
            int r7 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x003c
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            java.lang.String r3 = "time_passed"
            r0.a(r3, r2)
        L_0x003c:
            org.json.JSONArray r2 = new org.json.JSONArray
            r2.<init>()
            java.util.List<com.fyber.inneractive.sdk.click.i> r9 = r9.f
            java.util.Iterator r9 = r9.iterator()
        L_0x0047:
            boolean r3 = r9.hasNext()
            if (r3 == 0) goto L_0x0078
            java.lang.Object r3 = r9.next()
            com.fyber.inneractive.sdk.click.i r3 = (com.fyber.inneractive.sdk.click.i) r3
            org.json.JSONObject r5 = new org.json.JSONObject
            r5.<init>()
            java.lang.String r6 = "url"
            java.lang.String r7 = r3.a     // Catch:{ Exception -> 0x0074 }
            r5.put(r6, r7)     // Catch:{ Exception -> 0x0074 }
            java.lang.String r6 = "success"
            boolean r7 = r3.b     // Catch:{ Exception -> 0x0074 }
            r5.put(r6, r7)     // Catch:{ Exception -> 0x0074 }
            java.lang.String r6 = "opened_by"
            com.fyber.inneractive.sdk.click.l$d r7 = r3.c     // Catch:{ Exception -> 0x0074 }
            r5.put(r6, r7)     // Catch:{ Exception -> 0x0074 }
            java.lang.String r6 = "reason"
            java.lang.String r3 = r3.d     // Catch:{ Exception -> 0x0074 }
            r5.put(r6, r3)     // Catch:{ Exception -> 0x0074 }
        L_0x0074:
            r2.put(r5)
            goto L_0x0047
        L_0x0078:
            java.lang.String r9 = "urls"
            r0.a(r9, r2)
            java.lang.String r9 = "origin"
            r0.a(r9, r11)
            com.fyber.inneractive.sdk.util.i r9 = com.fyber.inneractive.sdk.util.i.FMP_ENDCARD
            if (r11 != r9) goto L_0x008f
            java.lang.String r9 = r11.e()
            java.lang.String r2 = "version"
            r0.a(r2, r9)
        L_0x008f:
            if (r10 == 0) goto L_0x009c
            boolean r9 = r10.c
            if (r9 == 0) goto L_0x009c
            java.lang.Boolean r9 = java.lang.Boolean.TRUE
            java.lang.String r2 = "is_auto_click"
            r0.a(r2, r9)
        L_0x009c:
            r9 = 1
            if (r10 == 0) goto L_0x011c
            float r2 = r10.a
            r3 = 0
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 <= 0) goto L_0x011c
            float r2 = r10.b
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 <= 0) goto L_0x011c
            boolean r2 = r8.C()
            int r5 = r8.A()
            if (r2 == 0) goto L_0x00b7
            goto L_0x00bb
        L_0x00b7:
            int r5 = com.fyber.inneractive.sdk.util.p.a((int) r5)
        L_0x00bb:
            if (r5 != 0) goto L_0x00bf
            r2 = 0
            goto L_0x00c3
        L_0x00bf:
            float r2 = r10.a
            float r5 = (float) r5
            float r2 = r2 / r5
        L_0x00c3:
            boolean r5 = r8.C()
            int r6 = r8.z()
            if (r5 == 0) goto L_0x00ce
            goto L_0x00d2
        L_0x00ce:
            int r6 = com.fyber.inneractive.sdk.util.p.a((int) r6)
        L_0x00d2:
            if (r6 != 0) goto L_0x00d5
            goto L_0x00da
        L_0x00d5:
            float r10 = r10.b
            float r3 = (float) r6
            float r3 = r10 / r3
        L_0x00da:
            r10 = 2
            java.lang.Object[] r10 = new java.lang.Object[r10]
            java.lang.Float r5 = java.lang.Float.valueOf(r2)
            r6 = 0
            r10[r6] = r5
            java.lang.Float r5 = java.lang.Float.valueOf(r3)
            r10[r9] = r5
            java.lang.String r5 = "Point location -  x - %.2f , y- %.2f"
            com.fyber.inneractive.sdk.util.IAlog.a(r5, r10)
            r8.C()
            java.util.Locale r10 = java.util.Locale.ENGLISH
            java.lang.Object[] r5 = new java.lang.Object[r9]
            java.lang.Float r2 = java.lang.Float.valueOf(r2)
            r5[r6] = r2
            java.lang.String r2 = "%.2f"
            java.lang.String r5 = java.lang.String.format(r10, r2, r5)
            java.lang.String r7 = "td_x"
            com.fyber.inneractive.sdk.network.s$b r5 = r0.a(r7, r5)
            r8.C()
            java.lang.Object[] r7 = new java.lang.Object[r9]
            java.lang.Float r3 = java.lang.Float.valueOf(r3)
            r7[r6] = r3
            java.lang.String r10 = java.lang.String.format(r10, r2, r7)
            java.lang.String r2 = "td_y"
            r5.a(r2, r10)
        L_0x011c:
            boolean r10 = r8.C()
            if (r10 == 0) goto L_0x0133
            int r10 = com.fyber.inneractive.sdk.util.p.d()
            if (r10 != r9) goto L_0x012b
            java.lang.String r10 = "p"
            goto L_0x012d
        L_0x012b:
            java.lang.String r10 = "l"
        L_0x012d:
            java.lang.String r2 = "o"
            r0.a(r2, r10)
            goto L_0x014d
        L_0x0133:
            int r10 = r8.A()
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            java.lang.String r2 = "b_w"
            r0.a(r2, r10)
            int r10 = r8.z()
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            java.lang.String r2 = "b_h"
            r0.a(r2, r10)
        L_0x014d:
            AdContent r10 = r8.b
            if (r10 == 0) goto L_0x015e
            com.fyber.inneractive.sdk.config.global.s r10 = r10.c
            if (r10 == 0) goto L_0x015e
            java.lang.Class<com.fyber.inneractive.sdk.config.global.features.c> r2 = com.fyber.inneractive.sdk.config.global.features.c.class
            com.fyber.inneractive.sdk.config.global.features.g r10 = r10.a(r2)
            com.fyber.inneractive.sdk.config.global.features.c r10 = (com.fyber.inneractive.sdk.config.global.features.c) r10
            goto L_0x015f
        L_0x015e:
            r10 = r1
        L_0x015f:
            if (r10 == 0) goto L_0x01a6
            com.fyber.inneractive.sdk.model.vast.a r10 = r10.e
            if (r10 == 0) goto L_0x01a6
            boolean r10 = r10.d
            if (r10 == 0) goto L_0x01a6
            com.fyber.inneractive.sdk.util.i r10 = com.fyber.inneractive.sdk.util.i.DEFAULT_ENDCARD
            boolean r10 = r10.equals(r11)
            if (r10 != 0) goto L_0x019d
            com.fyber.inneractive.sdk.util.i r10 = com.fyber.inneractive.sdk.util.i.VIDEO_CTA
            boolean r10 = r10.equals(r11)
            if (r10 != 0) goto L_0x019d
            com.fyber.inneractive.sdk.util.i r10 = com.fyber.inneractive.sdk.util.i.VIDEO_CLICK
            boolean r10 = r10.equals(r11)
            if (r10 == 0) goto L_0x01a6
            AdContent r10 = r8.b
            if (r10 == 0) goto L_0x0192
            com.fyber.inneractive.sdk.config.global.s r10 = r10.c
            if (r10 == 0) goto L_0x0192
            java.lang.Class<com.fyber.inneractive.sdk.config.global.features.r> r11 = com.fyber.inneractive.sdk.config.global.features.r.class
            com.fyber.inneractive.sdk.config.global.features.g r10 = r10.a(r11)
            com.fyber.inneractive.sdk.config.global.features.r r10 = (com.fyber.inneractive.sdk.config.global.features.r) r10
            goto L_0x0193
        L_0x0192:
            r10 = r1
        L_0x0193:
            if (r10 == 0) goto L_0x01a6
            java.lang.String r11 = "show_cta"
            boolean r9 = r10.a((java.lang.String) r11, (boolean) r9)
            if (r9 == 0) goto L_0x01a6
        L_0x019d:
            com.fyber.inneractive.sdk.config.IAConfigManager r9 = com.fyber.inneractive.sdk.config.IAConfigManager.M
            java.lang.String r9 = r9.p
            java.lang.String r10 = "cta_lng"
            r0.a(r10, r9)
        L_0x01a6:
            org.json.JSONArray r9 = r4.f
            org.json.JSONObject r10 = r0.a
            r9.put(r10)
            r4.a((java.lang.String) r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.flow.r.b(com.fyber.inneractive.sdk.click.b, com.fyber.inneractive.sdk.util.p0, com.fyber.inneractive.sdk.util.i):void");
    }

    public void a(e eVar) {
        String str = eVar.l;
        if (str != null && str.trim().length() > 0) {
            int i2 = IAlog.a;
            IAlog.a(1, (Exception) null, "AD_CLICKED", new Object[0]);
            j0.b(str);
        }
    }

    public void a(b bVar, p0 p0Var, i iVar) {
        b(bVar, p0Var, iVar);
    }

    public final void a(String str, l.d dVar) {
        InneractiveAdRequest inneractiveAdRequest;
        JSONArray jSONArray;
        e eVar;
        AdContent adcontent = this.b;
        if (adcontent != null) {
            eVar = adcontent.d();
            AdContent adcontent2 = this.b;
            inneractiveAdRequest = adcontent2.a;
            s sVar = adcontent2.c;
            jSONArray = sVar != null ? sVar.c() : null;
        } else {
            eVar = null;
            jSONArray = null;
            inneractiveAdRequest = null;
        }
        s.a a2 = new s.a(com.fyber.inneractive.sdk.network.r.EXTERNAL_BROWSER_OPENED, inneractiveAdRequest, eVar, jSONArray).a("url", str);
        Object[] objArr = new Object[2];
        objArr[0] = "fallback";
        objArr[1] = (dVar == l.d.OPENED_USING_CHROME_NAVIGATE || dVar == l.d.OPENED_IN_EXTERNAL_BROWSER) ? "chrome" : "na";
        a2.a(objArr).a((String) null);
    }

    public void a(String str) {
        if (!this.f) {
            this.f = true;
            com.fyber.inneractive.sdk.network.r rVar = com.fyber.inneractive.sdk.network.r.VAST_EVENT_COMPANION_CLICKED;
            AdContent adcontent = this.b;
            InneractiveAdRequest inneractiveAdRequest = adcontent != null ? adcontent.a : null;
            e d2 = adcontent != null ? adcontent.d() : null;
            AdContent adcontent2 = this.b;
            s.a aVar = new s.a(rVar, inneractiveAdRequest, d2, adcontent2 != null ? adcontent2.c.c() : null);
            JSONObject jSONObject = new JSONObject();
            if (str == null) {
                str = "na";
            }
            try {
                jSONObject.put("mime", str);
            } catch (Exception unused) {
                IAlog.e("Got exception adding param to json object: %s, %s", "mime", str);
            }
            aVar.f.put(jSONObject);
            aVar.a((String) null);
        }
    }

    public void a(InneractiveUnitController.AdDisplayError adDisplayError) {
        String simpleName = adDisplayError.getClass().getSimpleName();
        String message = adDisplayError.getMessage();
        AdContent adcontent = this.b;
        e eVar = null;
        InneractiveAdRequest inneractiveAdRequest = adcontent != null ? adcontent.a : null;
        if (adcontent != null) {
            eVar = adcontent.d();
        }
        t.a(simpleName, message, inneractiveAdRequest, eVar);
        if (this.c != null) {
            IAlog.a("%sCalling external interface onAdEnteredErrorState: %s", IAlog.a((Object) this), adDisplayError.getMessage());
            this.c.onAdEnteredErrorState(this.a, adDisplayError);
        }
    }

    public void a(com.fyber.inneractive.sdk.cache.session.enums.a aVar, com.fyber.inneractive.sdk.cache.session.enums.b bVar) {
        d dVar = IAConfigManager.M.x.a;
        if (dVar != null) {
            com.fyber.inneractive.sdk.util.q.a(new c(dVar, aVar, bVar));
        }
    }
}
