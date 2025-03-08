package com.applovin.impl.mediation.ads;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.applovin.impl.mediation.MaxErrorImpl;
import com.applovin.impl.mediation.ads.a;
import com.applovin.impl.mediation.d;
import com.applovin.impl.sdk.ac;
import com.applovin.impl.sdk.ad;
import com.applovin.impl.sdk.e;
import com.applovin.impl.sdk.e.ab;
import com.applovin.impl.sdk.f;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.r;
import com.applovin.impl.sdk.utils.AppLovinSdkExtraParameterKey;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.h;
import com.applovin.impl.sdk.utils.m;
import com.applovin.impl.sdk.utils.u;
import com.applovin.impl.sdk.utils.v;
import com.applovin.impl.sdk.x;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxAdRevenueListener;
import com.applovin.mediation.MaxAdViewAdListener;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.ads.MaxAdView;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class MaxAdViewImpl extends a implements ad.a, e.a, f.a {
    private final Context E;
    /* access modifiers changed from: private */
    public boolean agJ = false;
    private final String ajW = UUID.randomUUID().toString().toLowerCase(Locale.US);
    /* access modifiers changed from: private */
    public String amN;
    private final MaxAdView amO;
    private final View amP;
    private long amQ = Long.MAX_VALUE;
    private com.applovin.impl.mediation.b.b amR;
    /* access modifiers changed from: private */
    public String amS;
    private final a amT;
    private final c amU;
    /* access modifiers changed from: private */
    public final e amV;
    private final ac amW;
    private final ad amX;
    private final Object amY = new Object();
    /* access modifiers changed from: private */
    public com.applovin.impl.mediation.b.b amZ = null;
    private boolean ana;
    /* access modifiers changed from: private */
    public boolean anb;
    private boolean anc;
    private boolean and;
    private boolean ane;
    private boolean anf;
    private boolean ang;
    /* access modifiers changed from: private */
    public boolean anh;
    private boolean ani;
    private boolean anj;

    public String getPlacement() {
        return this.amN;
    }

    public void setPublisherBackgroundColor(int i) {
        this.amQ = (long) i;
    }

    public MaxAdViewImpl(String str, MaxAdFormat maxAdFormat, MaxAdView maxAdView, View view, n nVar, Context context) {
        super(str, maxAdFormat, "MaxAdView", nVar);
        if (context != null) {
            this.E = context.getApplicationContext();
            this.amO = maxAdView;
            this.amP = view;
            this.amT = new a();
            this.amU = new c();
            this.amV = new e(nVar, this);
            this.amW = new ac(maxAdView, nVar);
            this.amX = new ad(maxAdView, nVar, this);
            nVar.Cv().a(this);
            x xVar = this.logger;
            if (x.Fn()) {
                x xVar2 = this.logger;
                String str2 = this.tag;
                xVar2.f(str2, "Created new MaxAdView (" + this + ")");
                return;
            }
            return;
        }
        throw new IllegalArgumentException("No context specified");
    }

    public void setPlacement(String str) {
        if (this.amZ != null) {
            x xVar = this.logger;
            if (x.Fn()) {
                x xVar2 = this.logger;
                String str2 = this.tag;
                xVar2.h(str2, "Setting placement (" + str + ") for Ad Unit ID (" + this.adUnitId + ") after an ad has been loaded already.");
            }
        }
        this.amN = str;
    }

    public void setCustomData(String str) {
        if (this.amZ != null) {
            x xVar = this.logger;
            if (x.Fn()) {
                x xVar2 = this.logger;
                String str2 = this.tag;
                xVar2.h(str2, "Setting custom data (" + str + ") for Ad Unit ID (" + this.adUnitId + ") after an ad has been loaded already.");
            }
        }
        u.N(str, this.tag);
        this.amS = str;
    }

    public MaxAdFormat getAdFormat() {
        return this.adFormat;
    }

    public void stopAutoRefresh() {
        if (this.amZ != null) {
            x xVar = this.logger;
            if (x.Fn()) {
                x xVar2 = this.logger;
                String str = this.tag;
                xVar2.f(str, "Pausing auto-refresh with remaining time: " + this.amV.AH() + "ms");
            }
            this.amV.AJ();
        } else if (this.ane || ((Boolean) this.sdk.a(com.applovin.impl.sdk.c.a.aJx)).booleanValue()) {
            this.anb = true;
        } else {
            x.F(this.tag, "Stopping auto-refresh has no effect until after the first ad has been loaded.");
        }
    }

    public void startAutoRefresh() {
        this.anb = false;
        if (this.amV.AL()) {
            this.amV.AK();
            x xVar = this.logger;
            if (x.Fn()) {
                x xVar2 = this.logger;
                String str = this.tag;
                xVar2.f(str, "Resumed auto-refresh with remaining time: " + this.amV.AH() + "ms");
                return;
            }
            return;
        }
        x xVar3 = this.logger;
        if (x.Fn()) {
            this.logger.f(this.tag, "Ignoring call to startAutoRefresh() - ad refresh is not paused");
        }
    }

    public void loadAd() {
        loadAd(d.a.PUBLISHER_INITIATED);
    }

    public void loadAd(d.a aVar) {
        x xVar = this.logger;
        if (x.Fn()) {
            x xVar2 = this.logger;
            String str = this.tag;
            xVar2.f(str, "" + this + " Loading ad for " + this.adUnitId + "...");
        }
        boolean z = this.ane || ((Boolean) this.sdk.a(com.applovin.impl.sdk.c.a.aJx)).booleanValue();
        if (z && !this.amV.AL() && this.amV.AG()) {
            String str2 = this.tag;
            x.H(str2, "Unable to load a new ad. An ad refresh has already been scheduled in " + TimeUnit.MILLISECONDS.toSeconds(this.amV.AH()) + " seconds.");
        } else if (!z) {
            x xVar3 = this.logger;
            if (x.Fn()) {
                this.logger.f(this.tag, "Loading ad...");
            }
            a(aVar, (a.C0067a) this.amT);
        } else if (this.amR != null) {
            x xVar4 = this.logger;
            if (x.Fn()) {
                this.logger.f(this.tag, "Rendering cached ad");
            }
            up();
        } else if (this.and) {
            x xVar5 = this.logger;
            if (x.Fn()) {
                this.logger.f(this.tag, "Waiting for precache ad to load to render");
            }
            this.anc = true;
        } else {
            x xVar6 = this.logger;
            if (x.Fn()) {
                this.logger.f(this.tag, "Loading ad...");
            }
            a(aVar, (a.C0067a) this.amT);
        }
    }

    private void a(d.a aVar, a.C0067a aVar2) {
        if (ur()) {
            boolean b2 = u.b(n.getApplicationContext(), this.sdk);
            r Cs = this.sdk.Cs();
            r.a aVar3 = r.a.INTEGRATION_ERROR;
            Cs.a(aVar3, "attemptingToLoadDestroyedAdView", "debug=" + b2);
            if (!b2) {
                x.H(this.tag, "Failed to load new ad - this instance is already destroyed");
                return;
            }
            throw new IllegalStateException("Failed to load new ad - this instance is already destroyed for ad unit ID: " + this.adUnitId);
        }
        AppLovinSdkUtils.runOnUiThread(true, new MaxAdViewImpl$$ExternalSyntheticLambda0(this, aVar2, aVar));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(a.C0067a aVar, d.a aVar2) {
        com.applovin.impl.mediation.b.b bVar = this.amZ;
        if (bVar != null) {
            long a2 = this.amW.a(bVar);
            this.extraParameters.put("visible_ad_ad_unit_id", this.amZ.getAdUnitId());
            this.extraParameters.put("viewability_flags", Long.valueOf(a2));
        } else {
            this.extraParameters.remove("visible_ad_ad_unit_id");
            this.extraParameters.remove("viewability_flags");
        }
        int pxToDp = AppLovinSdkUtils.pxToDp(this.amO.getContext(), this.amO.getWidth());
        int pxToDp2 = AppLovinSdkUtils.pxToDp(this.amO.getContext(), this.amO.getHeight());
        this.extraParameters.put("viewport_width", Integer.valueOf(pxToDp));
        this.extraParameters.put("viewport_height", Integer.valueOf(pxToDp2));
        this.extraParameters.put("auto_refresh_stopped", Boolean.valueOf(this.amV.AL() || this.anb));
        this.extraParameters.put("auto_retries_disabled", Boolean.valueOf(this.anf));
        x xVar = this.logger;
        if (x.Fn()) {
            x xVar2 = this.logger;
            String str = this.tag;
            xVar2.f(str, "Loading " + this.adFormat.getLabel().toLowerCase(Locale.ENGLISH) + " ad for '" + this.adUnitId + "' and notifying " + aVar + "...");
        }
        this.sdk.Cy().loadAd(this.adUnitId, this.ajW, this.adFormat, aVar2, this.localExtraParameters, this.extraParameters, this.E, aVar);
    }

    public void setExtraParameter(String str, String str2) {
        super.setExtraParameter(str, str2);
        r(str, str2);
    }

    private void r(String str, String str2) {
        if (AppLovinSdkExtraParameterKey.ALLOW_IMMEDIATE_AUTO_REFRESH_PAUSE.equalsIgnoreCase(str)) {
            x xVar = this.logger;
            if (x.Fn()) {
                x xVar2 = this.logger;
                String str3 = this.tag;
                xVar2.f(str3, "Updated allow immediate auto-refresh pause and ad load to: " + str2);
            }
            this.ane = Boolean.parseBoolean(str2);
        } else if (AppLovinSdkExtraParameterKey.DISABLE_AUTO_RETRIES.equalsIgnoreCase(str)) {
            x xVar3 = this.logger;
            if (x.Fn()) {
                x xVar4 = this.logger;
                String str4 = this.tag;
                xVar4.f(str4, "Updated disable auto-retries to: " + str2);
            }
            this.anf = Boolean.parseBoolean(str2);
        } else if (AppLovinSdkExtraParameterKey.DISABLE_PRECACHE.equalsIgnoreCase(str)) {
            x xVar5 = this.logger;
            if (x.Fn()) {
                x xVar6 = this.logger;
                String str5 = this.tag;
                xVar6.f(str5, "Updated precached disabled to: " + str2);
            }
            this.ang = Boolean.parseBoolean(str2);
        } else if (AppLovinSdkExtraParameterKey.DISABLE_AUTO_REFRESH_ON_AD_EXPAND.equals(str)) {
            x xVar7 = this.logger;
            if (x.Fn()) {
                x xVar8 = this.logger;
                String str6 = this.tag;
                xVar8.f(str6, "Updated should stop auto-refresh on ad expand to: " + str2);
            }
            this.anh = Boolean.parseBoolean(str2);
        } else if (AppLovinSdkExtraParameterKey.FORCE_PRECACHE.equals(str)) {
            x xVar9 = this.logger;
            if (x.Fn()) {
                x xVar10 = this.logger;
                String str7 = this.tag;
                xVar10.f(str7, "Updated force precache to: " + str2);
            }
            this.ani = Boolean.parseBoolean(str2);
        } else if (AppLovinSdkExtraParameterKey.IS_ADAPTIVE_BANNER.equalsIgnoreCase(str)) {
            x xVar11 = this.logger;
            if (x.Fn()) {
                x xVar12 = this.logger;
                String str8 = this.tag;
                xVar12.f(str8, "Updated is adaptive banner to: " + str2);
            }
            this.anj = Boolean.parseBoolean(str2);
            setLocalExtraParameter(str, str2);
        }
    }

    public void destroy() {
        un();
        if (this.amR != null) {
            this.sdk.Cy().destroyAd(this.amR);
        }
        synchronized (this.amY) {
            this.agJ = true;
        }
        this.amV.AI();
        this.sdk.Cv().b(this);
        this.sdk.CD().o(this.adUnitId, this.ajW);
        super.destroy();
    }

    public void onWindowVisibilityChanged(int i) {
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.a.aJv)).booleanValue() && this.amV.AG()) {
            if (v.gZ(i)) {
                x xVar = this.logger;
                if (x.Fn()) {
                    this.logger.f(this.tag, "Ad view visible");
                }
                this.amV.AC();
                return;
            }
            x xVar2 = this.logger;
            if (x.Fn()) {
                this.logger.f(this.tag, "Ad view hidden");
            }
            this.amV.AB();
        }
    }

    private void un() {
        com.applovin.impl.mediation.b.b bVar;
        MaxAdView maxAdView = this.amO;
        if (maxAdView != null) {
            com.applovin.impl.sdk.utils.c.a(maxAdView, this.amP);
        }
        this.amX.Fw();
        synchronized (this.amY) {
            bVar = this.amZ;
        }
        if (bVar != null) {
            this.sdk.Cy().destroyAd(bVar);
        }
    }

    /* access modifiers changed from: private */
    public void a(com.applovin.impl.mediation.b.b bVar) {
        AppLovinSdkUtils.runOnUiThread(new MaxAdViewImpl$$ExternalSyntheticLambda1(this, bVar));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(com.applovin.impl.mediation.b.b bVar) {
        View adView = bVar.getAdView();
        String str = adView == null ? "MaxAdView does not have a loaded ad view" : null;
        MaxAdView maxAdView = this.amO;
        if (maxAdView == null) {
            str = "MaxAdView does not have a parent view";
        }
        if (str != null) {
            x xVar = this.logger;
            if (x.Fn()) {
                this.logger.i(this.tag, str);
            }
            MaxErrorImpl maxErrorImpl = new MaxErrorImpl(-1, str);
            x xVar2 = this.logger;
            if (x.Fn()) {
                x xVar3 = this.logger;
                String str2 = this.tag;
                xVar3.f(str2, "MaxAdListener.onAdDisplayFailed(ad=" + bVar + ", error=" + maxErrorImpl + "), listener=" + this.adListener);
            }
            m.a(this.adListener, (MaxAd) bVar, (MaxError) maxErrorImpl, true, true);
            this.sdk.Cy().processAdDisplayErrorPostbackForUserError(maxErrorImpl, bVar);
            return;
        }
        un();
        g(bVar);
        if (bVar.yw()) {
            this.amX.b(bVar);
        }
        maxAdView.setDescendantFocusability(393216);
        if (bVar.xV() != Long.MAX_VALUE) {
            this.amP.setBackgroundColor((int) bVar.xV());
        } else {
            long j = this.amQ;
            if (j != Long.MAX_VALUE) {
                this.amP.setBackgroundColor((int) j);
            } else {
                this.amP.setBackgroundColor(0);
            }
        }
        maxAdView.addView(adView);
        a(adView, bVar);
        this.sdk.Co().V(bVar);
        b(bVar);
        synchronized (this.amY) {
            this.amZ = bVar;
        }
        x xVar4 = this.logger;
        if (x.Fn()) {
            this.logger.f(this.tag, "Scheduling impression for ad manually...");
        }
        this.sdk.Cy().processRawAdImpressionPostback(bVar, this.amT);
        if (StringUtils.isValidString(this.amZ.getAdReviewCreativeId())) {
            m.a(this.adReviewListener, this.amZ.getAdReviewCreativeId(), (MaxAd) this.amZ, true);
        }
        AppLovinSdkUtils.runOnUiThreadDelayed(new MaxAdViewImpl$$ExternalSyntheticLambda3(this, bVar), bVar.xR());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d(com.applovin.impl.mediation.b.b bVar) {
        long a2 = this.amW.a(bVar);
        if (!bVar.yw()) {
            a(bVar, a2);
        }
        bH(a2);
    }

    private void uo() {
        if (uq()) {
            x xVar = this.logger;
            if (x.Fn()) {
                this.logger.f(this.tag, "Scheduling refresh precache request now");
            }
            this.and = true;
            this.sdk.BO().a((com.applovin.impl.sdk.e.d) new ab(this.sdk, "loadMaxAdForPrecacheRequest", new MaxAdViewImpl$$ExternalSyntheticLambda2(this)), com.applovin.impl.mediation.e.c.f(this.adFormat));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void us() {
        x xVar = this.logger;
        if (x.Fn()) {
            this.logger.f(this.tag, "Loading ad for pre-cache request...");
        }
        a(d.a.SEQUENTIAL_OR_PRECACHE, (a.C0067a) this.amU);
    }

    /* access modifiers changed from: private */
    public void b(MaxError maxError) {
        if (ur()) {
            x xVar = this.logger;
            if (x.Fn()) {
                x xVar2 = this.logger;
                String str = this.tag;
                xVar2.f(str, "Ad load failure with ad unit ID '" + this.adUnitId + "' occured after MaxAdView was destroyed.");
            }
        } else if (this.sdk.b(com.applovin.impl.sdk.c.a.aJr).contains(String.valueOf(maxError.getCode()))) {
            this.sdk.BN();
            if (x.Fn()) {
                x BN = this.sdk.BN();
                String str2 = this.tag;
                BN.f(str2, "Ignoring banner ad refresh for error code " + maxError.getCode());
            }
        } else if (this.anb || this.amV.AL()) {
            if (this.and) {
                x xVar3 = this.logger;
                if (x.Fn()) {
                    this.logger.f(this.tag, "Refresh pre-cache failed when auto-refresh is stopped");
                }
                this.and = false;
            }
            if (this.anc) {
                x xVar4 = this.logger;
                if (x.Fn()) {
                    x xVar5 = this.logger;
                    String str3 = this.tag;
                    xVar5.f(str3, "Refresh pre-cache failed - MaxAdListener.onAdLoadFailed(adUnitId=" + this.adUnitId + ", error=" + maxError + "), listener=" + this.adListener);
                }
                m.a(this.adListener, this.adUnitId, maxError, true, true);
            }
        } else {
            this.ana = true;
            this.and = false;
            long longValue = ((Long) this.sdk.a(com.applovin.impl.sdk.c.a.aJq)).longValue();
            if (longValue >= 0) {
                this.sdk.BN();
                if (x.Fn()) {
                    x BN2 = this.sdk.BN();
                    String str4 = this.tag;
                    BN2.f(str4, "Scheduling failed banner ad refresh " + longValue + " milliseconds from now for '" + this.adUnitId + "'...");
                }
                this.amV.bK(longValue);
            }
        }
    }

    private void a(View view, com.applovin.impl.mediation.b.b bVar) {
        int i;
        int width = bVar.getWidth();
        int height = bVar.getHeight();
        int i2 = -1;
        if (width == -1) {
            i = -1;
        } else {
            i = AppLovinSdkUtils.dpToPx(view.getContext(), width);
        }
        if (height != -1) {
            i2 = AppLovinSdkUtils.dpToPx(view.getContext(), height);
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new RelativeLayout.LayoutParams(i, i2);
        } else {
            layoutParams.width = i;
            layoutParams.height = i2;
        }
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            x xVar = this.logger;
            if (x.Fn()) {
                this.logger.f(this.tag, "Pinning ad view to MAX ad view with width: " + i + " and height: " + i2 + ".");
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
            for (int addRule : v.m(this.amO.getGravity(), 10, 14)) {
                layoutParams2.addRule(addRule);
            }
        }
        view.setLayoutParams(layoutParams);
    }

    private void b(com.applovin.impl.mediation.b.b bVar) {
        int height = this.amO.getHeight();
        int width = this.amO.getWidth();
        if (height > 0 || width > 0) {
            int pxToDp = AppLovinSdkUtils.pxToDp(this.E, height);
            int pxToDp2 = AppLovinSdkUtils.pxToDp(this.E, width);
            MaxAdFormat format = bVar.getFormat();
            int height2 = (this.anj ? format.getAdaptiveSize(pxToDp2, this.amO.getContext()) : format.getSize()).getHeight();
            int min = Math.min(format.getSize().getWidth(), h.Y(this.E).x);
            if (pxToDp < height2 || pxToDp2 < min) {
                StringBuilder sb = new StringBuilder("\n**************************************************\n`MaxAdView` size ");
                sb.append(pxToDp2);
                sb.append("x");
                sb.append(pxToDp);
                sb.append(" dp smaller than required ");
                sb.append(this.anj ? "adaptive " : "");
                sb.append("size: ");
                sb.append(min);
                sb.append("x");
                sb.append(height2);
                sb.append(" dp\nSome mediated networks (e.g. Google Ad Manager) may not render correctly\n**************************************************\n");
                String sb2 = sb.toString();
                x xVar = this.logger;
                if (x.Fn()) {
                    this.logger.i("AppLovinSdk", sb2);
                }
            }
        }
    }

    public void onAdRefresh() {
        this.anc = false;
        if (this.amR != null) {
            up();
        } else if (!uq()) {
            x xVar = this.logger;
            if (x.Fn()) {
                this.logger.f(this.tag, "Refreshing ad from network...");
            }
            loadAd(d.a.REFRESH);
        } else if (this.ana) {
            x xVar2 = this.logger;
            if (x.Fn()) {
                this.logger.f(this.tag, "Refreshing ad from network due to viewability requirements not met for refresh request...");
            }
            loadAd(d.a.REFRESH);
        } else {
            x xVar3 = this.logger;
            if (x.Fn()) {
                this.logger.i(this.tag, "Ignoring attempt to refresh ad - either still waiting for precache or did not attempt request due to visibility requirement not met");
            }
            this.anc = true;
        }
    }

    private void up() {
        x xVar = this.logger;
        if (x.Fn()) {
            x xVar2 = this.logger;
            String str = this.tag;
            xVar2.f(str, "Rendering for cached ad: " + this.amR + "...");
        }
        this.amT.onAdLoaded(this.amR);
        this.amR = null;
    }

    public void onLogVisibilityImpression() {
        a(this.amZ, this.amW.a(this.amZ));
    }

    private void a(com.applovin.impl.mediation.b.b bVar, long j) {
        x xVar = this.logger;
        if (x.Fn()) {
            this.logger.f(this.tag, "Scheduling viewability impression for ad...");
        }
        this.sdk.Cy().processViewabilityAdImpressionPostback(bVar, j, this.amT);
    }

    private void bH(long j) {
        if (!u.E(j, ((Long) this.sdk.a(com.applovin.impl.sdk.c.a.aJB)).longValue()) || this.ani) {
            x xVar = this.logger;
            if (x.Fn()) {
                this.logger.f(this.tag, "No undesired viewability flags matched or forcing pre-cache - scheduling viewability");
            }
            this.ana = false;
            uo();
            return;
        }
        x xVar2 = this.logger;
        if (x.Fn()) {
            x xVar3 = this.logger;
            String str = this.tag;
            xVar3.f(str, "Undesired flags matched - current: " + Long.toBinaryString(j) + ", undesired: " + Long.toBinaryString(j));
        }
        x xVar4 = this.logger;
        if (x.Fn()) {
            this.logger.f(this.tag, "Waiting for refresh timer to manually fire request");
        }
        this.ana = true;
    }

    /* access modifiers changed from: private */
    public void c(MaxAd maxAd) {
        this.and = false;
        if (this.anc) {
            this.anc = false;
            x xVar = this.logger;
            if (x.Fn()) {
                x xVar2 = this.logger;
                String str = this.tag;
                xVar2.f(str, "Rendering precache request ad: " + maxAd.getAdUnitId() + "...");
            }
            this.amT.onAdLoaded(maxAd);
            return;
        }
        x xVar3 = this.logger;
        if (x.Fn()) {
            this.logger.f(this.tag, "Saving pre-cache ad...");
        }
        com.applovin.impl.mediation.b.b bVar = (com.applovin.impl.mediation.b.b) maxAd;
        this.amR = bVar;
        bVar.setPlacement(this.amN);
        this.amR.setCustomData(this.amS);
    }

    private boolean uq() {
        if (this.ang) {
            return false;
        }
        return ((Boolean) this.sdk.a(com.applovin.impl.sdk.c.a.aJC)).booleanValue();
    }

    /* access modifiers changed from: private */
    public boolean ur() {
        boolean z;
        synchronized (this.amY) {
            z = this.agJ;
        }
        return z;
    }

    public void onCreativeIdGenerated(String str, String str2) {
        com.applovin.impl.mediation.b.b bVar = this.amZ;
        if (bVar == null || !bVar.xA().equalsIgnoreCase(str)) {
            com.applovin.impl.mediation.b.b bVar2 = this.amR;
            if (bVar2 != null && bVar2.xA().equalsIgnoreCase(str)) {
                this.amR.bV(str2);
                return;
            }
            return;
        }
        this.amZ.bV(str2);
        m.a(this.adReviewListener, str2, (MaxAd) this.amZ);
    }

    private abstract class b implements a.C0067a, MaxAdListener, MaxAdRevenueListener, MaxAdViewAdListener {
        private boolean anl;

        private b() {
        }

        public void onAdDisplayed(MaxAd maxAd) {
            if (maxAd.equals(MaxAdViewImpl.this.amZ)) {
                x xVar = MaxAdViewImpl.this.logger;
                if (x.Fn()) {
                    x xVar2 = MaxAdViewImpl.this.logger;
                    String str = MaxAdViewImpl.this.tag;
                    xVar2.f(str, "MaxAdListener.onAdDisplayed(ad=" + maxAd + "), listener=" + MaxAdViewImpl.this.adListener);
                }
                m.b(MaxAdViewImpl.this.adListener, maxAd, true, true);
            }
        }

        public void onAdHidden(MaxAd maxAd) {
            if (maxAd.equals(MaxAdViewImpl.this.amZ)) {
                x xVar = MaxAdViewImpl.this.logger;
                if (x.Fn()) {
                    x xVar2 = MaxAdViewImpl.this.logger;
                    String str = MaxAdViewImpl.this.tag;
                    xVar2.f(str, "MaxAdListener.onAdHidden(ad=" + maxAd + "), listener=" + MaxAdViewImpl.this.adListener);
                }
                m.c(MaxAdViewImpl.this.adListener, maxAd, true, true);
            }
        }

        public void onAdClicked(MaxAd maxAd) {
            if (maxAd.equals(MaxAdViewImpl.this.amZ)) {
                x xVar = MaxAdViewImpl.this.logger;
                if (x.Fn()) {
                    x xVar2 = MaxAdViewImpl.this.logger;
                    String str = MaxAdViewImpl.this.tag;
                    xVar2.f(str, "MaxAdListener.onAdClicked(ad=" + maxAd + "), listener=" + MaxAdViewImpl.this.adListener);
                }
                m.d(MaxAdViewImpl.this.adListener, maxAd, true, true);
            }
        }

        public void onAdDisplayFailed(MaxAd maxAd, MaxError maxError) {
            if (maxAd.equals(MaxAdViewImpl.this.amZ)) {
                x xVar = MaxAdViewImpl.this.logger;
                if (x.Fn()) {
                    x xVar2 = MaxAdViewImpl.this.logger;
                    String str = MaxAdViewImpl.this.tag;
                    xVar2.f(str, "MaxAdListener.onAdDisplayFailed(ad=" + maxAd + ", error=" + maxError + "), listener=" + MaxAdViewImpl.this.adListener);
                }
                m.a(MaxAdViewImpl.this.adListener, maxAd, maxError, true, true);
            }
        }

        public void onAdRevenuePaid(MaxAd maxAd) {
            x xVar = MaxAdViewImpl.this.logger;
            if (x.Fn()) {
                x xVar2 = MaxAdViewImpl.this.logger;
                String str = MaxAdViewImpl.this.tag;
                xVar2.f(str, "MaxAdRevenueListener.onAdRevenuePaid(ad=" + maxAd + "), listener=" + MaxAdViewImpl.this.revenueListener);
            }
            m.a(MaxAdViewImpl.this.revenueListener, maxAd, true, true);
        }

        public void onAdRequestStarted(String str) {
            x xVar = MaxAdViewImpl.this.logger;
            if (x.Fn()) {
                x xVar2 = MaxAdViewImpl.this.logger;
                String str2 = MaxAdViewImpl.this.tag;
                xVar2.f(str2, "MaxAdRequestListener.onAdRequestStarted(adUnitId=" + str + "), listener=" + MaxAdViewImpl.this.requestListener);
            }
            m.a(MaxAdViewImpl.this.requestListener, str, true, true);
        }

        public void onAdExpanded(MaxAd maxAd) {
            if (maxAd.equals(MaxAdViewImpl.this.amZ)) {
                if ((MaxAdViewImpl.this.amZ.xU() || MaxAdViewImpl.this.anh) && !MaxAdViewImpl.this.amV.AL()) {
                    this.anl = true;
                    MaxAdViewImpl.this.stopAutoRefresh();
                }
                x xVar = MaxAdViewImpl.this.logger;
                if (x.Fn()) {
                    x xVar2 = MaxAdViewImpl.this.logger;
                    String str = MaxAdViewImpl.this.tag;
                    xVar2.f(str, "MaxAdViewAdListener.onAdExpanded(ad=" + maxAd + "), listener=" + MaxAdViewImpl.this.adListener);
                }
                m.g(MaxAdViewImpl.this.adListener, maxAd, true, true);
            }
        }

        public void onAdCollapsed(MaxAd maxAd) {
            if (maxAd.equals(MaxAdViewImpl.this.amZ)) {
                if ((MaxAdViewImpl.this.amZ.xU() || MaxAdViewImpl.this.anh) && this.anl) {
                    this.anl = false;
                    MaxAdViewImpl.this.startAutoRefresh();
                }
                x xVar = MaxAdViewImpl.this.logger;
                if (x.Fn()) {
                    x xVar2 = MaxAdViewImpl.this.logger;
                    String str = MaxAdViewImpl.this.tag;
                    xVar2.f(str, "MaxAdViewAdListener.onAdCollapsed(ad=" + maxAd + "), listener=" + MaxAdViewImpl.this.adListener);
                }
                m.h(MaxAdViewImpl.this.adListener, maxAd, true, true);
            }
        }
    }

    private class a extends b {
        private a() {
            super();
        }

        public void onAdLoaded(MaxAd maxAd) {
            if (MaxAdViewImpl.this.ur()) {
                x xVar = MaxAdViewImpl.this.logger;
                if (x.Fn()) {
                    x xVar2 = MaxAdViewImpl.this.logger;
                    String str = MaxAdViewImpl.this.tag;
                    xVar2.f(str, "Precache ad with ad unit ID '" + MaxAdViewImpl.this.adUnitId + "' loaded after MaxAdView was destroyed. Destroying the ad.");
                }
                MaxAdViewImpl.this.sdk.Cy().destroyAd(maxAd);
                return;
            }
            com.applovin.impl.mediation.b.b bVar = (com.applovin.impl.mediation.b.b) maxAd;
            bVar.setPlacement(MaxAdViewImpl.this.amN);
            bVar.setCustomData(MaxAdViewImpl.this.amS);
            if (bVar.getAdView() != null) {
                Boolean bool = (Boolean) MaxAdViewImpl.this.sdk.a(com.applovin.impl.sdk.c.a.aJD);
                if (!bool.booleanValue()) {
                    MaxAdViewImpl.this.a(bVar);
                }
                if (bVar.xS()) {
                    long xT = bVar.xT();
                    MaxAdViewImpl.this.sdk.BN();
                    if (x.Fn()) {
                        x BN = MaxAdViewImpl.this.sdk.BN();
                        String str2 = MaxAdViewImpl.this.tag;
                        BN.f(str2, "Scheduling banner ad refresh " + xT + " milliseconds from now for '" + MaxAdViewImpl.this.adUnitId + "'...");
                    }
                    MaxAdViewImpl.this.amV.bK(xT);
                    if (MaxAdViewImpl.this.amV.AL() || MaxAdViewImpl.this.anb) {
                        x xVar3 = MaxAdViewImpl.this.logger;
                        if (x.Fn()) {
                            MaxAdViewImpl.this.logger.f(MaxAdViewImpl.this.tag, "Pausing ad refresh for publisher");
                        }
                        MaxAdViewImpl.this.amV.AJ();
                    }
                }
                x xVar4 = MaxAdViewImpl.this.logger;
                if (x.Fn()) {
                    x xVar5 = MaxAdViewImpl.this.logger;
                    String str3 = MaxAdViewImpl.this.tag;
                    xVar5.f(str3, "MaxAdListener.onAdLoaded(ad=" + maxAd + "), listener=" + MaxAdViewImpl.this.adListener);
                }
                m.a(MaxAdViewImpl.this.adListener, maxAd, true, true);
                if (bool.booleanValue()) {
                    MaxAdViewImpl.this.a(bVar);
                    return;
                }
                return;
            }
            MaxAdViewImpl.this.sdk.Cy().destroyAd(bVar);
            onAdLoadFailed(bVar.getAdUnitId(), new MaxErrorImpl(-5001, "Ad view not fully loaded"));
        }

        public void onAdLoadFailed(String str, MaxError maxError) {
            x xVar = MaxAdViewImpl.this.logger;
            if (x.Fn()) {
                x xVar2 = MaxAdViewImpl.this.logger;
                String str2 = MaxAdViewImpl.this.tag;
                xVar2.f(str2, "MaxAdListener.onAdLoadFailed(adUnitId=" + str + ", error=" + maxError + "), listener=" + MaxAdViewImpl.this.adListener);
            }
            m.a(MaxAdViewImpl.this.adListener, str, maxError, true, true);
            MaxAdViewImpl.this.b(maxError);
        }
    }

    private class c extends b {
        private c() {
            super();
        }

        public void onAdLoaded(MaxAd maxAd) {
            if (MaxAdViewImpl.this.agJ) {
                x xVar = MaxAdViewImpl.this.logger;
                if (x.Fn()) {
                    x xVar2 = MaxAdViewImpl.this.logger;
                    String str = MaxAdViewImpl.this.tag;
                    xVar2.f(str, "Ad with ad unit ID '" + MaxAdViewImpl.this.adUnitId + "' loaded after MaxAdView was destroyed. Destroying the ad.");
                }
                MaxAdViewImpl.this.sdk.Cy().destroyAd(maxAd);
                return;
            }
            x xVar3 = MaxAdViewImpl.this.logger;
            if (x.Fn()) {
                MaxAdViewImpl.this.logger.f(MaxAdViewImpl.this.tag, "Successfully pre-cached ad for refresh");
            }
            MaxAdViewImpl.this.c(maxAd);
        }

        public void onAdLoadFailed(String str, MaxError maxError) {
            x xVar = MaxAdViewImpl.this.logger;
            if (x.Fn()) {
                x xVar2 = MaxAdViewImpl.this.logger;
                String str2 = MaxAdViewImpl.this.tag;
                xVar2.f(str2, "Failed to precache ad for refresh with error code: " + maxError.getCode());
            }
            MaxAdViewImpl.this.b(maxError);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("MaxAdView{adUnitId='");
        sb.append(this.adUnitId);
        sb.append("', adListener=");
        sb.append(this.adListener == this.amO ? "this" : this.adListener);
        sb.append(", isDestroyed=");
        sb.append(ur());
        sb.append('}');
        return sb.toString();
    }
}
