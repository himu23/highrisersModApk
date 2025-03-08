package com.applovin.impl.mediation.ads;

import android.app.Activity;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import com.applovin.impl.mediation.MaxErrorImpl;
import com.applovin.impl.mediation.ads.a;
import com.applovin.impl.mediation.d;
import com.applovin.impl.mediation.i;
import com.applovin.impl.sdk.ad.g;
import com.applovin.impl.sdk.b;
import com.applovin.impl.sdk.e.ab;
import com.applovin.impl.sdk.e.q;
import com.applovin.impl.sdk.f;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.r;
import com.applovin.impl.sdk.utils.AppLovinSdkExtraParameterKey;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.m;
import com.applovin.impl.sdk.utils.u;
import com.applovin.impl.sdk.x;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxAdRevenueListener;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.MaxReward;
import com.applovin.mediation.MaxRewardedAdListener;
import com.applovin.mediation.adapter.MaxAdapterError;
import com.applovin.sdk.AppLovinSdkUtils;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class MaxFullscreenAdImpl extends a implements b.a, f.a {
    /* access modifiers changed from: private */
    public final Object amY = new Object();
    /* access modifiers changed from: private */
    public final a anm;
    private final com.applovin.impl.mediation.b ann;
    /* access modifiers changed from: private */
    public com.applovin.impl.mediation.b.c ano = null;
    private c anp = c.IDLE;
    /* access modifiers changed from: private */
    public final AtomicBoolean anq = new AtomicBoolean();
    /* access modifiers changed from: private */
    public final AtomicBoolean anr = new AtomicBoolean();
    private boolean ans;
    /* access modifiers changed from: private */
    public boolean ant;
    private WeakReference<Activity> anu = new WeakReference<>((Object) null);
    private WeakReference<ViewGroup> anv = new WeakReference<>((Object) null);
    private WeakReference<Lifecycle> anw = new WeakReference<>((Object) null);
    protected final b listenerWrapper;

    public interface a {
        Activity getActivity();
    }

    public enum c {
        IDLE,
        LOADING,
        READY,
        SHOWING,
        DESTROYED
    }

    public MaxFullscreenAdImpl(String str, MaxAdFormat maxAdFormat, a aVar, String str2, n nVar) {
        super(str, maxAdFormat, str2, nVar);
        this.anm = aVar;
        this.listenerWrapper = new b();
        this.ann = new com.applovin.impl.mediation.b(nVar);
        nVar.Cv().a(this);
        x.D(str2, "Created new " + str2 + " (" + this + ")");
    }

    public boolean isReady() {
        boolean z;
        synchronized (this.amY) {
            com.applovin.impl.mediation.b.c cVar = this.ano;
            z = cVar != null && cVar.isReady() && this.anp == c.READY;
        }
        if (!z) {
            this.sdk.Cf().cG(this.adUnitId);
        }
        return z;
    }

    public void destroy() {
        a(c.DESTROYED, (Runnable) new MaxFullscreenAdImpl$$ExternalSyntheticLambda0(this));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void uw() {
        synchronized (this.amY) {
            if (this.ano != null) {
                x xVar = this.logger;
                if (x.Fn()) {
                    x xVar2 = this.logger;
                    String str = this.tag;
                    xVar2.f(str, "Destroying ad for '" + this.adUnitId + "'; current ad: " + this.ano + "...");
                }
                this.sdk.Cy().destroyAd(this.ano);
            }
        }
        this.sdk.Cv().b(this);
        this.ann.tS();
        super.destroy();
    }

    public void loadAd(Activity activity) {
        loadAd(activity, d.a.PUBLISHER_INITIATED);
    }

    public void loadAd(Activity activity, d.a aVar) {
        x xVar = this.logger;
        if (x.Fn()) {
            x xVar2 = this.logger;
            String str = this.tag;
            xVar2.f(str, "Loading ad for '" + this.adUnitId + "'...");
        }
        if (this.anp == c.DESTROYED) {
            boolean b2 = u.b(n.getApplicationContext(), this.sdk);
            r Cs = this.sdk.Cs();
            r.a aVar2 = r.a.INTEGRATION_ERROR;
            Cs.a(aVar2, "attemptingToLoadDestroyedAd", "debug=" + b2);
            if (b2) {
                throw new IllegalStateException("Failed to load new ad - this instance is already destroyed for ad unit ID: " + this.adUnitId);
            }
        }
        if (isReady()) {
            x xVar3 = this.logger;
            if (x.Fn()) {
                x xVar4 = this.logger;
                String str2 = this.tag;
                xVar4.f(str2, "An ad is already loaded for '" + this.adUnitId + "'");
            }
            x xVar5 = this.logger;
            if (x.Fn()) {
                x xVar6 = this.logger;
                String str3 = this.tag;
                xVar6.f(str3, "MaxAdListener.onAdLoaded(ad=" + this.ano + "), listener=" + this.adListener);
            }
            m.a(this.adListener, (MaxAd) this.ano, true, true);
            return;
        }
        a(c.LOADING, (Runnable) new MaxFullscreenAdImpl$$ExternalSyntheticLambda1(this, activity, aVar));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Incorrect type for immutable var: ssa=android.app.Activity, code=android.content.Context, for r10v0, types: [android.app.Activity] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ void a(android.content.Context r10, com.applovin.impl.mediation.d.a r11) {
        /*
            r9 = this;
            if (r10 == 0) goto L_0x0004
        L_0x0002:
            r7 = r10
            goto L_0x0018
        L_0x0004:
            com.applovin.impl.sdk.n r10 = r9.sdk
            android.app.Activity r10 = r10.CF()
            if (r10 == 0) goto L_0x0013
            com.applovin.impl.sdk.n r10 = r9.sdk
            android.app.Activity r10 = r10.CF()
            goto L_0x0002
        L_0x0013:
            android.content.Context r10 = com.applovin.impl.sdk.n.getApplicationContext()
            goto L_0x0002
        L_0x0018:
            com.applovin.impl.sdk.n r10 = r9.sdk
            com.applovin.impl.mediation.MediationServiceImpl r0 = r10.Cy()
            java.lang.String r1 = r9.adUnitId
            r2 = 0
            com.applovin.mediation.MaxAdFormat r3 = r9.adFormat
            java.util.Map r5 = r9.localExtraParameters
            java.util.Map r6 = r9.extraParameters
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$b r8 = r9.listenerWrapper
            r4 = r11
            r0.loadAd(r1, r2, r3, r4, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.a(android.app.Activity, com.applovin.impl.mediation.d$a):void");
    }

    public void showAd(String str, String str2, Activity activity) {
        List<String> xk = this.sdk.CE().xk();
        if (!this.sdk.CE().xj() || xk == null || xk.contains(this.ano.yA())) {
            if (activity == null) {
                activity = this.sdk.CF();
            }
            if (a(activity, str)) {
                a(c.SHOWING, (Runnable) new MaxFullscreenAdImpl$$ExternalSyntheticLambda6(this, str, str2, activity));
                return;
            }
            return;
        }
        String str3 = "Attempting to show ad from <" + this.ano.yA() + "> which is not in the list of selected ad networks " + xk;
        x.H(this.tag, str3);
        a(c.IDLE, (Runnable) new MaxFullscreenAdImpl$$ExternalSyntheticLambda5(this, str3));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void bE(String str) {
        com.applovin.impl.mediation.b.c cVar = this.ano;
        d((MaxAd) cVar);
        MaxErrorImpl maxErrorImpl = new MaxErrorImpl(MaxAdapterError.ERROR_CODE_AD_DISPLAY_FAILED, str);
        x xVar = this.logger;
        if (x.Fn()) {
            x xVar2 = this.logger;
            String str2 = this.tag;
            xVar2.f(str2, "MaxAdListener.onAdDisplayFailed(ad=" + cVar + ", error=" + maxErrorImpl + "), listener=" + this.adListener);
        }
        m.a(this.adListener, (MaxAd) cVar, (MaxError) maxErrorImpl, true, true);
        this.sdk.Cy().processAdDisplayErrorPostbackForUserError(maxErrorImpl, cVar);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(String str, String str2, Activity activity) {
        s(str, str2);
        this.ans = false;
        this.anu = new WeakReference<>(activity);
        this.sdk.Cy().showFullscreenAd(this.ano, activity, this.listenerWrapper);
    }

    /* access modifiers changed from: private */
    public void showAd() {
        Activity activity = (Activity) this.anu.get();
        if (activity == null) {
            activity = this.sdk.CF();
        }
        Activity activity2 = activity;
        if (this.ans) {
            showAd(this.ano.getPlacement(), this.ano.yG(), (ViewGroup) this.anv.get(), (Lifecycle) this.anw.get(), activity2);
            return;
        }
        showAd(this.ano.getPlacement(), this.ano.yG(), activity2);
    }

    public void showAd(String str, String str2, ViewGroup viewGroup, Lifecycle lifecycle, Activity activity) {
        if (viewGroup == null || lifecycle == null) {
            x.H(this.tag, "Attempting to show ad with null containerView or lifecycle.");
            MaxErrorImpl maxErrorImpl = new MaxErrorImpl(-1, "Attempting to show ad with null containerView or lifecycle.");
            x xVar = this.logger;
            if (x.Fn()) {
                this.logger.f(this.tag, "MaxAdListener.onAdDisplayFailed(ad=" + this.ano + ", error=" + maxErrorImpl + "), listener=" + this.adListener);
            }
            m.a(this.adListener, (MaxAd) this.ano, (MaxError) maxErrorImpl, true, true);
            this.sdk.Cy().processAdDisplayErrorPostbackForUserError(maxErrorImpl, this.ano);
        } else if (viewGroup.isShown() || !((Boolean) this.sdk.a(com.applovin.impl.sdk.c.a.aJY)).booleanValue()) {
            List<String> xk = this.sdk.CE().xk();
            if (!this.sdk.CE().xj() || xk == null || xk.contains(this.ano.yA())) {
                if (activity == null) {
                    activity = this.sdk.CF();
                }
                Activity activity2 = activity;
                if (a(activity2, str)) {
                    a(c.SHOWING, (Runnable) new MaxFullscreenAdImpl$$ExternalSyntheticLambda3(this, str, str2, activity2, viewGroup, lifecycle));
                    return;
                }
                return;
            }
            String str3 = "Attempting to show ad from <" + this.ano.yA() + "> which is not in the list of selected ad networks " + xk;
            x.H(this.tag, str3);
            a(c.IDLE, (Runnable) new MaxFullscreenAdImpl$$ExternalSyntheticLambda2(this, str3));
        } else {
            x.H(this.tag, "Attempting to show ad when containerView and/or its ancestors are not visible");
            MaxErrorImpl maxErrorImpl2 = new MaxErrorImpl(-1, "Attempting to show ad when containerView and/or its ancestors are not visible");
            m.a(this.adListener, (MaxAd) this.ano, (MaxError) maxErrorImpl2, true, true);
            this.sdk.Cy().processAdDisplayErrorPostbackForUserError(maxErrorImpl2, this.ano);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void bD(String str) {
        com.applovin.impl.mediation.b.c cVar = this.ano;
        d((MaxAd) cVar);
        MaxErrorImpl maxErrorImpl = new MaxErrorImpl(MaxAdapterError.ERROR_CODE_AD_DISPLAY_FAILED, str);
        x xVar = this.logger;
        if (x.Fn()) {
            x xVar2 = this.logger;
            String str2 = this.tag;
            xVar2.f(str2, "MaxAdListener.onAdDisplayFailed(ad=" + cVar + ", error=" + maxErrorImpl + "), listener=" + this.adListener);
        }
        m.a(this.adListener, (MaxAd) cVar, (MaxError) maxErrorImpl, true, true);
        this.sdk.Cy().processAdDisplayErrorPostbackForUserError(maxErrorImpl, cVar);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(String str, String str2, Activity activity, ViewGroup viewGroup, Lifecycle lifecycle) {
        s(str, str2);
        this.ans = true;
        this.anu = new WeakReference<>(activity);
        this.anv = new WeakReference<>(viewGroup);
        this.anw = new WeakReference<>(lifecycle);
        this.sdk.Cy().showFullscreenAd(this.ano, viewGroup, lifecycle, activity, this.listenerWrapper);
    }

    private boolean a(Activity activity, String str) {
        if (activity != null || MaxAdFormat.APP_OPEN == this.adFormat) {
            if (this.anp == c.DESTROYED) {
                boolean b2 = u.b(n.getApplicationContext(), this.sdk);
                this.sdk.Cs().a(r.a.INTEGRATION_ERROR, "attemptingToShowDestroyedAd", "debug=" + b2);
                if (b2) {
                    throw new IllegalStateException("Attempting to show ad that is destroyed for ad unit ID: " + this.adUnitId);
                }
            }
            if (!isReady()) {
                String str2 = "Attempting to show ad before it is ready - please check ad readiness using " + this.tag + "#isReady()";
                x.H(this.tag, str2);
                MaxErrorImpl maxErrorImpl = new MaxErrorImpl(-24, str2);
                i iVar = new i(this.adUnitId, this.adFormat, str);
                x xVar = this.logger;
                if (x.Fn()) {
                    this.logger.f(this.tag, "MaxAdListener.onAdDisplayFailed(ad=" + iVar + ", error=" + maxErrorImpl + "), listener=" + this.adListener);
                }
                m.a(this.adListener, (MaxAd) iVar, (MaxError) maxErrorImpl, true, true);
                if (this.ano != null) {
                    this.sdk.Cy().processAdDisplayErrorPostbackForUserError(maxErrorImpl, this.ano);
                }
                return false;
            }
            Long l = (Long) this.sdk.a(com.applovin.impl.sdk.c.a.aJM);
            Long l2 = (Long) this.sdk.a(com.applovin.impl.sdk.c.a.aJG);
            if (l.longValue() <= 0 || (this.ano.getTimeToLiveMillis() >= l2.longValue() && !this.anq.get())) {
                if (u.ai(n.getApplicationContext()) != 0 && this.sdk.getSettings().shouldFailAdDisplayIfDontKeepActivitiesIsEnabled()) {
                    if (u.b(n.getApplicationContext(), this.sdk)) {
                        throw new IllegalStateException("Ad failed to display! Please disable the \"Don't Keep Activities\" setting in your developer settings!");
                    } else if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.a.aJX)).booleanValue()) {
                        x.H(this.tag, "Ad failed to display! Please disable the \"Don't Keep Activities\" setting in your developer settings!");
                        MaxErrorImpl maxErrorImpl2 = new MaxErrorImpl(-5602, "Ad failed to display! Please disable the \"Don't Keep Activities\" setting in your developer settings!");
                        x xVar2 = this.logger;
                        if (x.Fn()) {
                            this.logger.f(this.tag, "MaxAdListener.onAdDisplayFailed(ad=" + this.ano + ", error=" + maxErrorImpl2 + "), listener=" + this.adListener);
                        }
                        m.a(this.adListener, (MaxAd) this.ano, (MaxError) maxErrorImpl2, true, true);
                        this.sdk.Cy().processAdDisplayErrorPostbackForUserError(maxErrorImpl2, this.ano);
                        return false;
                    }
                }
                if (this.sdk.Cf().Fb() || this.sdk.Cf().Fc()) {
                    x.H(this.tag, "Attempting to show ad when another fullscreen ad is already showing");
                    MaxErrorImpl maxErrorImpl3 = new MaxErrorImpl(-23, "Attempting to show ad when another fullscreen ad is already showing");
                    x xVar3 = this.logger;
                    if (x.Fn()) {
                        this.logger.f(this.tag, "MaxAdListener.onAdDisplayFailed(ad=" + this.ano + ", error=" + maxErrorImpl3 + "), listener=" + this.adListener);
                    }
                    m.a(this.adListener, (MaxAd) this.ano, (MaxError) maxErrorImpl3, true, true);
                    this.sdk.Cy().processAdDisplayErrorPostbackForUserError(maxErrorImpl3, this.ano);
                    return false;
                } else if (!((Boolean) this.sdk.a(com.applovin.impl.sdk.c.a.aJE)).booleanValue() || com.applovin.impl.sdk.utils.i.aa(n.getApplicationContext())) {
                    String str3 = this.sdk.getSettings().getExtraParameters().get(AppLovinSdkExtraParameterKey.BLOCK_FULLSCREEN_ADS_SHOWING_IF_ACTIVITY_FINISHING);
                    if (((!StringUtils.isValidString(str3) || !Boolean.valueOf(str3).booleanValue()) && !((Boolean) this.sdk.a(com.applovin.impl.sdk.c.a.aJF)).booleanValue()) || activity == null || !activity.isFinishing()) {
                        return true;
                    }
                    x.H(this.tag, "Attempting to show ad when activity is finishing");
                    MaxErrorImpl maxErrorImpl4 = new MaxErrorImpl(-5601, "Attempting to show ad when activity is finishing");
                    x xVar4 = this.logger;
                    if (x.Fn()) {
                        this.logger.f(this.tag, "MaxAdListener.onAdDisplayFailed(ad=" + this.ano + ", error=" + maxErrorImpl4 + "), listener=" + this.adListener);
                    }
                    m.a(this.adListener, (MaxAd) this.ano, (MaxError) maxErrorImpl4, true, true);
                    this.sdk.Cy().processAdDisplayErrorPostbackForUserError(maxErrorImpl4, this.ano);
                    return false;
                } else {
                    x.H(this.tag, "Attempting to show ad with no internet connection");
                    MaxErrorImpl maxErrorImpl5 = new MaxErrorImpl(-1009);
                    x xVar5 = this.logger;
                    if (x.Fn()) {
                        this.logger.f(this.tag, "MaxAdListener.onAdDisplayFailed(ad=" + this.ano + ", error=" + maxErrorImpl5 + "), listener=" + this.adListener);
                    }
                    m.a(this.adListener, (MaxAd) this.ano, (MaxError) maxErrorImpl5, true, true);
                    this.sdk.Cy().processAdDisplayErrorPostbackForUserError(maxErrorImpl5, this.ano);
                    return false;
                }
            } else {
                this.anr.set(true);
                this.sdk.BO().a((com.applovin.impl.sdk.e.d) new ab(this.sdk, "handleShowOnLoadTimeoutError", new MaxFullscreenAdImpl$$ExternalSyntheticLambda4(this)), q.b.BACKGROUND, l.longValue());
                return false;
            }
        } else {
            throw new IllegalArgumentException("Attempting to show ad without a valid activity.");
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void uv() {
        if (this.anr.compareAndSet(true, false)) {
            x.H(this.tag, "Failed to show an ad. Failed to load an ad in time to show.");
            this.sdk.Cf().cG(this.adUnitId);
            MaxErrorImpl maxErrorImpl = new MaxErrorImpl(-24, "Failed to show an ad. Failed to load an ad in time to show.");
            i iVar = new i(this.adUnitId, this.adFormat, this.ano.getPlacement());
            x xVar = this.logger;
            if (x.Fn()) {
                x xVar2 = this.logger;
                String str = this.tag;
                xVar2.f(str, "MaxAdListener.onAdDisplayFailed(ad=" + iVar + ", error=" + maxErrorImpl + "), listener=" + this.adListener);
            }
            m.a(this.adListener, (MaxAd) iVar, (MaxError) maxErrorImpl, true, true);
            if (this.ano != null) {
                this.sdk.Cy().processAdDisplayErrorPostbackForUserError(maxErrorImpl, this.ano);
            }
        }
    }

    private void s(String str, String str2) {
        this.ann.b(this.ano);
        this.ano.setPlacement(str);
        this.ano.setCustomData(str2);
        this.sdk.Co().V(this.ano);
        x xVar = this.logger;
        if (x.Fn()) {
            x xVar2 = this.logger;
            String str3 = this.tag;
            xVar2.f(str3, "Showing ad for '" + this.adUnitId + "'; loaded ad: " + this.ano + "...");
        }
        g(this.ano);
    }

    private void ut() {
        com.applovin.impl.mediation.b.c cVar;
        synchronized (this.amY) {
            cVar = this.ano;
            this.ano = null;
        }
        this.sdk.Cy().destroyAd(cVar);
    }

    public void onAdExpired(g gVar) {
        x xVar = this.logger;
        if (x.Fn()) {
            x xVar2 = this.logger;
            String str = this.tag;
            xVar2.f(str, "Ad expired " + getAdUnitId());
        }
        this.anq.set(true);
        a aVar = this.anm;
        Activity activity = aVar != null ? aVar.getActivity() : null;
        if (activity == null && (activity = this.sdk.BM().Az()) == null) {
            uu();
            this.listenerWrapper.onAdLoadFailed(this.adUnitId, MaxAdapterError.MISSING_ACTIVITY);
            return;
        }
        this.extraParameters.put("expired_ad_ad_unit_id", getAdUnitId());
        this.sdk.Cy().loadAd(this.adUnitId, (String) null, this.adFormat, d.a.EXPIRED, this.localExtraParameters, this.extraParameters, activity, this.listenerWrapper);
    }

    /* access modifiers changed from: private */
    public void i(com.applovin.impl.mediation.b.c cVar) {
        if (this.sdk.Cb().a(cVar, this)) {
            x xVar = this.logger;
            if (x.Fn()) {
                x xVar2 = this.logger;
                String str = this.tag;
                xVar2.f(str, "Handle ad loaded for regular ad: " + cVar);
            }
            this.ano = cVar;
            return;
        }
        x xVar3 = this.logger;
        if (x.Fn()) {
            this.logger.f(this.tag, "Loaded an expired ad, running expire logic...");
        }
        onAdExpired(cVar);
    }

    /* access modifiers changed from: private */
    public void uu() {
        com.applovin.impl.mediation.b.c cVar;
        if (this.anq.compareAndSet(true, false)) {
            synchronized (this.amY) {
                cVar = this.ano;
                this.ano = null;
            }
            this.sdk.Cy().destroyAd(cVar);
            this.extraParameters.remove("expired_ad_ad_unit_id");
        }
    }

    public void onCreativeIdGenerated(String str, String str2) {
        com.applovin.impl.mediation.b.c cVar = this.ano;
        if (cVar != null && cVar.xA().equalsIgnoreCase(str)) {
            this.ano.bV(str2);
            m.a(this.adReviewListener, str2, (MaxAd) this.ano);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0179  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x01a6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.c r13, java.lang.Runnable r14) {
        /*
            r12 = this;
            java.lang.String r0 = "Unable to transition to: "
            java.lang.String r1 = "Unable to transition to: "
            java.lang.String r2 = "Unable to transition to: "
            java.lang.String r3 = "Unknown state: "
            java.lang.String r4 = "Unable to transition to: "
            java.lang.String r5 = "Transitioning from "
            java.lang.String r6 = "Not allowed transition from "
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r7 = r12.anp
            java.lang.Object r8 = r12.amY
            monitor-enter(r8)
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r9 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.c.IDLE     // Catch:{ all -> 0x01d4 }
            r10 = 1
            r11 = 0
            if (r7 != r9) goto L_0x004d
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r0 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.c.LOADING     // Catch:{ all -> 0x01d4 }
            if (r13 != r0) goto L_0x001f
            goto L_0x0177
        L_0x001f:
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r0 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.c.DESTROYED     // Catch:{ all -> 0x01d4 }
            if (r13 != r0) goto L_0x0025
            goto L_0x0177
        L_0x0025:
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r0 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.c.SHOWING     // Catch:{ all -> 0x01d4 }
            if (r13 != r0) goto L_0x0031
            java.lang.String r0 = r12.tag     // Catch:{ all -> 0x01d4 }
            java.lang.String r1 = "No ad is loading or loaded"
            com.applovin.impl.sdk.x.H(r0, r1)     // Catch:{ all -> 0x01d4 }
            goto L_0x0062
        L_0x0031:
            com.applovin.impl.sdk.x r0 = r12.logger     // Catch:{ all -> 0x01d4 }
            boolean r0 = com.applovin.impl.sdk.x.Fn()     // Catch:{ all -> 0x01d4 }
            if (r0 == 0) goto L_0x0062
            com.applovin.impl.sdk.x r0 = r12.logger     // Catch:{ all -> 0x01d4 }
            java.lang.String r1 = r12.tag     // Catch:{ all -> 0x01d4 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x01d4 }
            r2.<init>(r4)     // Catch:{ all -> 0x01d4 }
            r2.append(r13)     // Catch:{ all -> 0x01d4 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x01d4 }
            r0.i(r1, r2)     // Catch:{ all -> 0x01d4 }
            goto L_0x0062
        L_0x004d:
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r4 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.c.LOADING     // Catch:{ all -> 0x01d4 }
            if (r7 != r4) goto L_0x0099
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r0 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.c.IDLE     // Catch:{ all -> 0x01d4 }
            if (r13 != r0) goto L_0x0057
            goto L_0x0177
        L_0x0057:
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r0 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.c.LOADING     // Catch:{ all -> 0x01d4 }
            if (r13 != r0) goto L_0x0065
            java.lang.String r0 = r12.tag     // Catch:{ all -> 0x01d4 }
            java.lang.String r1 = "An ad is already loading"
            com.applovin.impl.sdk.x.H(r0, r1)     // Catch:{ all -> 0x01d4 }
        L_0x0062:
            r10 = 0
            goto L_0x0177
        L_0x0065:
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r0 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.c.READY     // Catch:{ all -> 0x01d4 }
            if (r13 != r0) goto L_0x006b
            goto L_0x0177
        L_0x006b:
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r0 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.c.SHOWING     // Catch:{ all -> 0x01d4 }
            if (r13 != r0) goto L_0x0077
            java.lang.String r0 = r12.tag     // Catch:{ all -> 0x01d4 }
            java.lang.String r1 = "An ad is not ready to be shown yet"
            com.applovin.impl.sdk.x.H(r0, r1)     // Catch:{ all -> 0x01d4 }
            goto L_0x0062
        L_0x0077:
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r0 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.c.DESTROYED     // Catch:{ all -> 0x01d4 }
            if (r13 != r0) goto L_0x007d
            goto L_0x0177
        L_0x007d:
            com.applovin.impl.sdk.x r0 = r12.logger     // Catch:{ all -> 0x01d4 }
            boolean r0 = com.applovin.impl.sdk.x.Fn()     // Catch:{ all -> 0x01d4 }
            if (r0 == 0) goto L_0x0062
            com.applovin.impl.sdk.x r0 = r12.logger     // Catch:{ all -> 0x01d4 }
            java.lang.String r1 = r12.tag     // Catch:{ all -> 0x01d4 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x01d4 }
            r3.<init>(r2)     // Catch:{ all -> 0x01d4 }
            r3.append(r13)     // Catch:{ all -> 0x01d4 }
            java.lang.String r2 = r3.toString()     // Catch:{ all -> 0x01d4 }
            r0.i(r1, r2)     // Catch:{ all -> 0x01d4 }
            goto L_0x0062
        L_0x0099:
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r2 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.c.READY     // Catch:{ all -> 0x01d4 }
            if (r7 != r2) goto L_0x00ee
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r0 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.c.IDLE     // Catch:{ all -> 0x01d4 }
            if (r13 != r0) goto L_0x00a3
            goto L_0x0177
        L_0x00a3:
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r0 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.c.LOADING     // Catch:{ all -> 0x01d4 }
            if (r13 != r0) goto L_0x00af
            java.lang.String r0 = r12.tag     // Catch:{ all -> 0x01d4 }
            java.lang.String r1 = "An ad is already loaded"
            com.applovin.impl.sdk.x.H(r0, r1)     // Catch:{ all -> 0x01d4 }
            goto L_0x0062
        L_0x00af:
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r0 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.c.READY     // Catch:{ all -> 0x01d4 }
            if (r13 != r0) goto L_0x00c5
            com.applovin.impl.sdk.x r0 = r12.logger     // Catch:{ all -> 0x01d4 }
            boolean r0 = com.applovin.impl.sdk.x.Fn()     // Catch:{ all -> 0x01d4 }
            if (r0 == 0) goto L_0x0062
            com.applovin.impl.sdk.x r0 = r12.logger     // Catch:{ all -> 0x01d4 }
            java.lang.String r1 = r12.tag     // Catch:{ all -> 0x01d4 }
            java.lang.String r2 = "An ad is already marked as ready"
            r0.i(r1, r2)     // Catch:{ all -> 0x01d4 }
            goto L_0x0062
        L_0x00c5:
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r0 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.c.SHOWING     // Catch:{ all -> 0x01d4 }
            if (r13 != r0) goto L_0x00cb
            goto L_0x0177
        L_0x00cb:
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r0 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.c.DESTROYED     // Catch:{ all -> 0x01d4 }
            if (r13 != r0) goto L_0x00d1
            goto L_0x0177
        L_0x00d1:
            com.applovin.impl.sdk.x r0 = r12.logger     // Catch:{ all -> 0x01d4 }
            boolean r0 = com.applovin.impl.sdk.x.Fn()     // Catch:{ all -> 0x01d4 }
            if (r0 == 0) goto L_0x0062
            com.applovin.impl.sdk.x r0 = r12.logger     // Catch:{ all -> 0x01d4 }
            java.lang.String r2 = r12.tag     // Catch:{ all -> 0x01d4 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x01d4 }
            r3.<init>(r1)     // Catch:{ all -> 0x01d4 }
            r3.append(r13)     // Catch:{ all -> 0x01d4 }
            java.lang.String r1 = r3.toString()     // Catch:{ all -> 0x01d4 }
            r0.i(r2, r1)     // Catch:{ all -> 0x01d4 }
            goto L_0x0062
        L_0x00ee:
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r1 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.c.SHOWING     // Catch:{ all -> 0x01d4 }
            if (r7 != r1) goto L_0x014b
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r1 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.c.IDLE     // Catch:{ all -> 0x01d4 }
            if (r13 != r1) goto L_0x00f8
            goto L_0x0177
        L_0x00f8:
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r1 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.c.LOADING     // Catch:{ all -> 0x01d4 }
            if (r13 != r1) goto L_0x0105
            java.lang.String r0 = r12.tag     // Catch:{ all -> 0x01d4 }
            java.lang.String r1 = "Can not load another ad while the ad is showing"
            com.applovin.impl.sdk.x.H(r0, r1)     // Catch:{ all -> 0x01d4 }
            goto L_0x0062
        L_0x0105:
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r1 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.c.READY     // Catch:{ all -> 0x01d4 }
            if (r13 != r1) goto L_0x011c
            com.applovin.impl.sdk.x r0 = r12.logger     // Catch:{ all -> 0x01d4 }
            boolean r0 = com.applovin.impl.sdk.x.Fn()     // Catch:{ all -> 0x01d4 }
            if (r0 == 0) goto L_0x0062
            com.applovin.impl.sdk.x r0 = r12.logger     // Catch:{ all -> 0x01d4 }
            java.lang.String r1 = r12.tag     // Catch:{ all -> 0x01d4 }
            java.lang.String r2 = "An ad is already showing, ignoring"
            r0.i(r1, r2)     // Catch:{ all -> 0x01d4 }
            goto L_0x0062
        L_0x011c:
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r1 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.c.SHOWING     // Catch:{ all -> 0x01d4 }
            if (r13 != r1) goto L_0x0129
            java.lang.String r0 = r12.tag     // Catch:{ all -> 0x01d4 }
            java.lang.String r1 = "The ad is already showing, not showing another one"
            com.applovin.impl.sdk.x.H(r0, r1)     // Catch:{ all -> 0x01d4 }
            goto L_0x0062
        L_0x0129:
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r1 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.c.DESTROYED     // Catch:{ all -> 0x01d4 }
            if (r13 != r1) goto L_0x012e
            goto L_0x0177
        L_0x012e:
            com.applovin.impl.sdk.x r1 = r12.logger     // Catch:{ all -> 0x01d4 }
            boolean r1 = com.applovin.impl.sdk.x.Fn()     // Catch:{ all -> 0x01d4 }
            if (r1 == 0) goto L_0x0062
            com.applovin.impl.sdk.x r1 = r12.logger     // Catch:{ all -> 0x01d4 }
            java.lang.String r2 = r12.tag     // Catch:{ all -> 0x01d4 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x01d4 }
            r3.<init>(r0)     // Catch:{ all -> 0x01d4 }
            r3.append(r13)     // Catch:{ all -> 0x01d4 }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x01d4 }
            r1.i(r2, r0)     // Catch:{ all -> 0x01d4 }
            goto L_0x0062
        L_0x014b:
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r0 = com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.c.DESTROYED     // Catch:{ all -> 0x01d4 }
            if (r7 != r0) goto L_0x0158
            java.lang.String r0 = r12.tag     // Catch:{ all -> 0x01d4 }
            java.lang.String r1 = "No operations are allowed on a destroyed instance"
            com.applovin.impl.sdk.x.H(r0, r1)     // Catch:{ all -> 0x01d4 }
            goto L_0x0062
        L_0x0158:
            com.applovin.impl.sdk.x r0 = r12.logger     // Catch:{ all -> 0x01d4 }
            boolean r0 = com.applovin.impl.sdk.x.Fn()     // Catch:{ all -> 0x01d4 }
            if (r0 == 0) goto L_0x0062
            com.applovin.impl.sdk.x r0 = r12.logger     // Catch:{ all -> 0x01d4 }
            java.lang.String r1 = r12.tag     // Catch:{ all -> 0x01d4 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x01d4 }
            r2.<init>(r3)     // Catch:{ all -> 0x01d4 }
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r3 = r12.anp     // Catch:{ all -> 0x01d4 }
            r2.append(r3)     // Catch:{ all -> 0x01d4 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x01d4 }
            r0.i(r1, r2)     // Catch:{ all -> 0x01d4 }
            goto L_0x0062
        L_0x0177:
            if (r10 == 0) goto L_0x01a6
            com.applovin.impl.sdk.x r0 = r12.logger     // Catch:{ all -> 0x01d4 }
            boolean r0 = com.applovin.impl.sdk.x.Fn()     // Catch:{ all -> 0x01d4 }
            if (r0 == 0) goto L_0x01a3
            com.applovin.impl.sdk.x r0 = r12.logger     // Catch:{ all -> 0x01d4 }
            java.lang.String r1 = r12.tag     // Catch:{ all -> 0x01d4 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x01d4 }
            r2.<init>(r5)     // Catch:{ all -> 0x01d4 }
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r3 = r12.anp     // Catch:{ all -> 0x01d4 }
            r2.append(r3)     // Catch:{ all -> 0x01d4 }
            java.lang.String r3 = " to "
            r2.append(r3)     // Catch:{ all -> 0x01d4 }
            r2.append(r13)     // Catch:{ all -> 0x01d4 }
            java.lang.String r3 = "..."
            r2.append(r3)     // Catch:{ all -> 0x01d4 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x01d4 }
            r0.f(r1, r2)     // Catch:{ all -> 0x01d4 }
        L_0x01a3:
            r12.anp = r13     // Catch:{ all -> 0x01d4 }
            goto L_0x01cb
        L_0x01a6:
            com.applovin.impl.sdk.x r0 = r12.logger     // Catch:{ all -> 0x01d4 }
            boolean r0 = com.applovin.impl.sdk.x.Fn()     // Catch:{ all -> 0x01d4 }
            if (r0 == 0) goto L_0x01cb
            com.applovin.impl.sdk.x r0 = r12.logger     // Catch:{ all -> 0x01d4 }
            java.lang.String r1 = r12.tag     // Catch:{ all -> 0x01d4 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x01d4 }
            r2.<init>(r6)     // Catch:{ all -> 0x01d4 }
            com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c r3 = r12.anp     // Catch:{ all -> 0x01d4 }
            r2.append(r3)     // Catch:{ all -> 0x01d4 }
            java.lang.String r3 = " to "
            r2.append(r3)     // Catch:{ all -> 0x01d4 }
            r2.append(r13)     // Catch:{ all -> 0x01d4 }
            java.lang.String r13 = r2.toString()     // Catch:{ all -> 0x01d4 }
            r0.h(r1, r13)     // Catch:{ all -> 0x01d4 }
        L_0x01cb:
            monitor-exit(r8)     // Catch:{ all -> 0x01d4 }
            if (r10 == 0) goto L_0x01d3
            if (r14 == 0) goto L_0x01d3
            r14.run()
        L_0x01d3:
            return
        L_0x01d4:
            r13 = move-exception
            monitor-exit(r8)     // Catch:{ all -> 0x01d4 }
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.mediation.ads.MaxFullscreenAdImpl.a(com.applovin.impl.mediation.ads.MaxFullscreenAdImpl$c, java.lang.Runnable):void");
    }

    /* access modifiers changed from: private */
    public void d(MaxAd maxAd) {
        this.sdk.Cb().a((g) (com.applovin.impl.mediation.b.c) maxAd);
        this.ann.tS();
        ut();
        this.sdk.CC().m((com.applovin.impl.mediation.b.a) maxAd);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.tag);
        sb.append("{adUnitId='");
        sb.append(this.adUnitId);
        sb.append("', adListener=");
        sb.append(this.adListener == this.anm ? "this" : this.adListener);
        sb.append(", revenueListener=");
        sb.append(this.revenueListener);
        sb.append(", requestListener");
        sb.append(this.requestListener);
        sb.append(", adReviewListener");
        sb.append(this.adReviewListener);
        sb.append(", isReady=");
        sb.append(isReady());
        sb.append('}');
        return sb.toString();
    }

    private class b implements a.C0067a, MaxAdListener, MaxAdRevenueListener, MaxRewardedAdListener {
        private b() {
        }

        public void onAdLoaded(MaxAd maxAd) {
            com.applovin.impl.mediation.b.c b;
            synchronized (MaxFullscreenAdImpl.this.amY) {
                b = MaxFullscreenAdImpl.this.ano;
            }
            MaxFullscreenAdImpl.this.sdk.Cf().cI(MaxFullscreenAdImpl.this.adUnitId);
            MaxFullscreenAdImpl.this.i((com.applovin.impl.mediation.b.c) maxAd);
            if (MaxFullscreenAdImpl.this.anq.compareAndSet(true, false)) {
                MaxFullscreenAdImpl.this.extraParameters.remove("expired_ad_ad_unit_id");
                if (MaxFullscreenAdImpl.this.anr.compareAndSet(true, false)) {
                    MaxFullscreenAdImpl.this.showAd();
                }
                x xVar = MaxFullscreenAdImpl.this.logger;
                if (x.Fn()) {
                    x xVar2 = MaxFullscreenAdImpl.this.logger;
                    String str = MaxFullscreenAdImpl.this.tag;
                    xVar2.f(str, "MaxAdListener.onExpiredAdReloaded(expiredAd=" + b + ", newAd=" + maxAd + "), listener=" + MaxFullscreenAdImpl.this.expirationListener);
                }
                m.a(MaxFullscreenAdImpl.this.expirationListener, (MaxAd) b, maxAd, true, true);
                return;
            }
            MaxFullscreenAdImpl.this.a(c.READY, (Runnable) new MaxFullscreenAdImpl$b$$ExternalSyntheticLambda2(this, maxAd));
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void f(MaxAd maxAd) {
            if (MaxFullscreenAdImpl.this.ant) {
                MaxFullscreenAdImpl.this.showAd();
                return;
            }
            x xVar = MaxFullscreenAdImpl.this.logger;
            if (x.Fn()) {
                x xVar2 = MaxFullscreenAdImpl.this.logger;
                String str = MaxFullscreenAdImpl.this.tag;
                xVar2.f(str, "MaxAdListener.onAdLoaded(ad=" + maxAd + "), listener=" + MaxFullscreenAdImpl.this.adListener);
            }
            m.a(MaxFullscreenAdImpl.this.adListener, maxAd, true, true);
        }

        public void onAdLoadFailed(String str, MaxError maxError) {
            MaxFullscreenAdImpl.this.uu();
            MaxFullscreenAdImpl.this.a(c.IDLE, (Runnable) new MaxFullscreenAdImpl$b$$ExternalSyntheticLambda4(this, str, maxError));
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void b(String str, MaxError maxError) {
            x xVar = MaxFullscreenAdImpl.this.logger;
            if (x.Fn()) {
                x xVar2 = MaxFullscreenAdImpl.this.logger;
                String str2 = MaxFullscreenAdImpl.this.tag;
                xVar2.f(str2, "MaxAdListener.onAdLoadFailed(adUnitId=" + str + ", error=" + maxError + "), listener=" + MaxFullscreenAdImpl.this.adListener);
            }
            m.a(MaxFullscreenAdImpl.this.adListener, str, maxError, true, true);
        }

        public void onAdDisplayed(MaxAd maxAd) {
            boolean unused = MaxFullscreenAdImpl.this.ant = false;
            MaxFullscreenAdImpl.this.sdk.Cb().a((g) (com.applovin.impl.mediation.b.c) maxAd);
            x xVar = MaxFullscreenAdImpl.this.logger;
            if (x.Fn()) {
                x xVar2 = MaxFullscreenAdImpl.this.logger;
                String str = MaxFullscreenAdImpl.this.tag;
                xVar2.f(str, "MaxAdListener.onAdDisplayed(ad=" + maxAd + "), listener=" + MaxFullscreenAdImpl.this.adListener);
            }
            m.b(MaxFullscreenAdImpl.this.adListener, maxAd, true, true);
        }

        public void onAdHidden(MaxAd maxAd) {
            boolean unused = MaxFullscreenAdImpl.this.ant = false;
            MaxFullscreenAdImpl.this.a(c.IDLE, (Runnable) new MaxFullscreenAdImpl$b$$ExternalSyntheticLambda3(this, maxAd));
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void e(MaxAd maxAd) {
            MaxFullscreenAdImpl.this.d(maxAd);
            x xVar = MaxFullscreenAdImpl.this.logger;
            if (x.Fn()) {
                x xVar2 = MaxFullscreenAdImpl.this.logger;
                String str = MaxFullscreenAdImpl.this.tag;
                xVar2.f(str, "MaxAdListener.onAdHidden(ad=" + maxAd + "), listener=" + MaxFullscreenAdImpl.this.adListener);
            }
            m.c(MaxFullscreenAdImpl.this.adListener, maxAd, true, true);
        }

        public void onAdClicked(MaxAd maxAd) {
            x xVar = MaxFullscreenAdImpl.this.logger;
            if (x.Fn()) {
                x xVar2 = MaxFullscreenAdImpl.this.logger;
                String str = MaxFullscreenAdImpl.this.tag;
                xVar2.f(str, "MaxAdListener.onAdClicked(ad=" + maxAd + "), listener=" + MaxFullscreenAdImpl.this.adListener);
            }
            m.d(MaxFullscreenAdImpl.this.adListener, maxAd, true, true);
        }

        public void onAdRevenuePaid(MaxAd maxAd) {
            x xVar = MaxFullscreenAdImpl.this.logger;
            if (x.Fn()) {
                x xVar2 = MaxFullscreenAdImpl.this.logger;
                String str = MaxFullscreenAdImpl.this.tag;
                xVar2.f(str, "MaxAdRevenueListener.onAdRevenuePaid(ad=" + maxAd + "), listener=" + MaxFullscreenAdImpl.this.revenueListener);
            }
            m.a(MaxFullscreenAdImpl.this.revenueListener, maxAd, true);
        }

        public void onAdDisplayFailed(MaxAd maxAd, MaxError maxError) {
            boolean g = MaxFullscreenAdImpl.this.ant;
            boolean unused = MaxFullscreenAdImpl.this.ant = false;
            MaxFullscreenAdImpl.this.a(c.IDLE, (Runnable) new MaxFullscreenAdImpl$b$$ExternalSyntheticLambda1(this, maxAd, g, (com.applovin.impl.mediation.b.c) maxAd, maxError));
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void a(MaxAd maxAd, boolean z, com.applovin.impl.mediation.b.c cVar, MaxError maxError) {
            MaxFullscreenAdImpl.this.d(maxAd);
            if (z || !cVar.yd() || !MaxFullscreenAdImpl.this.sdk.CD().bw(MaxFullscreenAdImpl.this.adUnitId)) {
                x xVar = MaxFullscreenAdImpl.this.logger;
                if (x.Fn()) {
                    x xVar2 = MaxFullscreenAdImpl.this.logger;
                    String str = MaxFullscreenAdImpl.this.tag;
                    xVar2.f(str, "MaxAdListener.onAdDisplayFailed(ad=" + maxAd + ", error=" + maxError + "), listener=" + MaxFullscreenAdImpl.this.adListener);
                }
                m.a(MaxFullscreenAdImpl.this.adListener, maxAd, maxError, true, true);
                return;
            }
            AppLovinSdkUtils.runOnUiThread(true, new MaxFullscreenAdImpl$b$$ExternalSyntheticLambda0(this));
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void ux() {
            boolean unused = MaxFullscreenAdImpl.this.ant = true;
            MaxFullscreenAdImpl.this.loadAd(MaxFullscreenAdImpl.this.anm != null ? MaxFullscreenAdImpl.this.anm.getActivity() : null);
        }

        public void onRewardedVideoStarted(MaxAd maxAd) {
            x xVar = MaxFullscreenAdImpl.this.logger;
            if (x.Fn()) {
                x xVar2 = MaxFullscreenAdImpl.this.logger;
                String str = MaxFullscreenAdImpl.this.tag;
                xVar2.f(str, "MaxRewardedAdListener.onRewardedVideoStarted(ad=" + maxAd + "), listener=" + MaxFullscreenAdImpl.this.adListener);
            }
            m.e(MaxFullscreenAdImpl.this.adListener, maxAd, true, true);
        }

        public void onRewardedVideoCompleted(MaxAd maxAd) {
            x xVar = MaxFullscreenAdImpl.this.logger;
            if (x.Fn()) {
                x xVar2 = MaxFullscreenAdImpl.this.logger;
                String str = MaxFullscreenAdImpl.this.tag;
                xVar2.f(str, "MaxRewardedAdListener.onRewardedVideoCompleted(ad=" + maxAd + "), listener=" + MaxFullscreenAdImpl.this.adListener);
            }
            m.f(MaxFullscreenAdImpl.this.adListener, maxAd, true, true);
        }

        public void onUserRewarded(MaxAd maxAd, MaxReward maxReward) {
            x xVar = MaxFullscreenAdImpl.this.logger;
            if (x.Fn()) {
                x xVar2 = MaxFullscreenAdImpl.this.logger;
                String str = MaxFullscreenAdImpl.this.tag;
                xVar2.f(str, "MaxRewardedAdListener.onUserRewarded(ad=" + maxAd + ", reward=" + maxReward + "), listener=" + MaxFullscreenAdImpl.this.adListener);
            }
            m.a(MaxFullscreenAdImpl.this.adListener, maxAd, maxReward, true, true);
        }

        public void onAdRequestStarted(String str) {
            x xVar = MaxFullscreenAdImpl.this.logger;
            if (x.Fn()) {
                x xVar2 = MaxFullscreenAdImpl.this.logger;
                String str2 = MaxFullscreenAdImpl.this.tag;
                xVar2.f(str2, "MaxAdRequestListener.onAdRequestStarted(adUnitId=" + str + "), listener=" + MaxFullscreenAdImpl.this.requestListener);
            }
            m.a(MaxFullscreenAdImpl.this.requestListener, str, true, true);
        }
    }
}
