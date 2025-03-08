package com.applovin.impl.mediation.ads;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.applovin.impl.mediation.MaxErrorImpl;
import com.applovin.impl.mediation.ads.a;
import com.applovin.impl.mediation.d;
import com.applovin.impl.sdk.ad.g;
import com.applovin.impl.sdk.b;
import com.applovin.impl.sdk.e.ab;
import com.applovin.impl.sdk.e.q;
import com.applovin.impl.sdk.f;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.h;
import com.applovin.impl.sdk.utils.m;
import com.applovin.impl.sdk.utils.u;
import com.applovin.impl.sdk.x;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.nativeAds.MaxNativeAd;
import com.applovin.mediation.nativeAds.MaxNativeAdListener;
import com.applovin.mediation.nativeAds.MaxNativeAdView;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class MaxNativeAdLoaderImpl extends a implements b.a, f.a {
    public static final String KEY_EXTRA_PARAMETER_AD_REQUEST_TYPE = "ad_request_type";
    /* access modifiers changed from: private */
    public String amN;
    /* access modifiers changed from: private */
    public String amS;
    /* access modifiers changed from: private */
    public final Object amY = new Object();
    /* access modifiers changed from: private */
    public final a anE = new a();
    private d.a anF = d.a.PUBLISHER_INITIATED;
    /* access modifiers changed from: private */
    public MaxNativeAdListener anG;
    private final Map<String, MaxNativeAdView> anH = new HashMap();
    /* access modifiers changed from: private */
    public final Set<com.applovin.impl.mediation.b.d> anI = new HashSet();

    public String getPlacement() {
        return this.amN;
    }

    public void setPlacement(String str) {
        this.amN = str;
    }

    public MaxNativeAdLoaderImpl(String str, n nVar) {
        super(str, MaxAdFormat.NATIVE, "MaxNativeAdLoader", nVar);
        nVar.Cv().a(this);
        x xVar = this.logger;
        if (x.Fn()) {
            x xVar2 = this.logger;
            String str2 = this.tag;
            xVar2.f(str2, "Created new MaxNativeAdLoader (" + this + ")");
        }
    }

    public void loadAd(MaxNativeAdView maxNativeAdView) {
        x xVar = this.logger;
        if (x.Fn()) {
            x xVar2 = this.logger;
            String str = this.tag;
            xVar2.f(str, "Loading native ad for '" + this.adUnitId + "' into '" + maxNativeAdView + "' and notifying " + this.anE + "...");
        }
        this.extraParameters.put("integration_type", maxNativeAdView != null ? "custom_ad_view" : "no_ad_view");
        String lowerCase = UUID.randomUUID().toString().toLowerCase(Locale.US);
        a(lowerCase, maxNativeAdView);
        this.sdk.Cy().loadAd(this.adUnitId, lowerCase, MaxAdFormat.NATIVE, this.anF, this.localExtraParameters, this.extraParameters, n.getApplicationContext(), this.anE);
    }

    public boolean render(MaxNativeAdView maxNativeAdView, MaxAd maxAd) {
        if (!(maxAd instanceof com.applovin.impl.mediation.b.d)) {
            x.H(this.tag, "Failed to render native ad. `ad` needs to be of type `MediatedNativeAd` to render.");
            return false;
        } else if (maxNativeAdView == null) {
            x.H(this.tag, "Failed to render native ad. `adView` to render cannot be null.");
            return false;
        } else {
            com.applovin.impl.mediation.b.d dVar = (com.applovin.impl.mediation.b.d) maxAd;
            MaxNativeAd nativeAd = dVar.getNativeAd();
            if (nativeAd == null) {
                x xVar = this.logger;
                if (x.Fn()) {
                    this.logger.i(this.tag, "Failed to render native ad. Could not retrieve MaxNativeAd. The ad may have already been destroyed.");
                }
                return false;
            } else if (!nativeAd.isExpired() || ((Boolean) this.sdk.a(com.applovin.impl.sdk.c.a.aJJ)).booleanValue()) {
                a(maxNativeAdView, dVar, nativeAd);
                b(maxNativeAdView);
                return true;
            } else {
                x.H(this.tag, "Cancelled rendering for expired native ad. Check if an ad is expired before displaying using `MaxAd.getNativeAd().isExpired()`");
                return false;
            }
        }
    }

    public void registerClickableViews(final List<View> list, final ViewGroup viewGroup, MaxAd maxAd) {
        com.applovin.impl.mediation.b.d dVar = (com.applovin.impl.mediation.b.d) maxAd;
        final MaxNativeAd nativeAd = dVar.getNativeAd();
        if (nativeAd == null) {
            x xVar = this.logger;
            if (x.Fn()) {
                this.logger.i(this.tag, "Failed to register native ad. Could not retrieve MaxNativeAd. The ad may have already been destroyed.");
                return;
            }
            return;
        }
        dVar.c(viewGroup);
        this.sdk.Co().V(dVar);
        g(dVar);
        nativeAd.setClickableViews(list);
        nativeAd.setAdViewTracker(new b(dVar, viewGroup, this.anE, this.sdk));
        AnonymousClass1 r7 = new Runnable() {
            public void run() {
                if (!nativeAd.prepareForInteraction(list, viewGroup)) {
                    x.H(MaxNativeAdLoaderImpl.this.tag, "Failed to prepare native ad for interaction...");
                }
            }
        };
        if (nativeAd.shouldPrepareViewForInteractionOnMainThread()) {
            AppLovinSdkUtils.runOnUiThread(r7);
        } else {
            this.sdk.BO().a((com.applovin.impl.sdk.e.d) new ab(this.sdk, "renderMaxNativeAd", r7), q.b.MEDIATION_MAIN);
        }
    }

    public void handleNativeAdViewRendered(MaxAd maxAd) {
        MaxNativeAd nativeAd = ((com.applovin.impl.mediation.b.d) maxAd).getNativeAd();
        if (nativeAd == null) {
            x xVar = this.logger;
            if (x.Fn()) {
                this.logger.i(this.tag, "Failed to handle native ad rendered. Could not retrieve MaxNativeAd. The ad may have already been destroyed.");
                return;
            }
            return;
        }
        b adViewTracker = nativeAd.getAdViewTracker();
        if (adViewTracker == null) {
            x xVar2 = this.logger;
            if (x.Fn()) {
                this.logger.i(this.tag, "Failed to handle native ad rendered. Could not retrieve tracker. Ad might not have been registered via MaxNativeAdLoader.a(...).");
                return;
            }
            return;
        }
        adViewTracker.uy();
    }

    public void setNativeAdListener(MaxNativeAdListener maxNativeAdListener) {
        x xVar = this.logger;
        if (x.Fn()) {
            x xVar2 = this.logger;
            String str = this.tag;
            xVar2.f(str, "Setting native ad listener: " + maxNativeAdListener);
        }
        this.anG = maxNativeAdListener;
    }

    public void setCustomData(String str) {
        u.N(str, this.tag);
        this.amS = str;
    }

    public void destroy() {
        this.anG = null;
        this.sdk.Cv().b(this);
        synchronized (this.amY) {
            this.anH.clear();
            this.anI.clear();
        }
        super.destroy();
    }

    public void destroy(MaxAd maxAd) {
        b adViewTracker;
        if (maxAd instanceof com.applovin.impl.mediation.b.d) {
            com.applovin.impl.mediation.b.d dVar = (com.applovin.impl.mediation.b.d) maxAd;
            if (dVar.ur()) {
                x xVar = this.logger;
                if (x.Fn()) {
                    x xVar2 = this.logger;
                    String str = this.tag;
                    xVar2.f(str, "Native ad (" + dVar + ") has already been destroyed");
                    return;
                }
                return;
            }
            synchronized (this.amY) {
                this.anI.remove(dVar);
            }
            MaxNativeAdView yl = dVar.yl();
            if (!(yl == null || (adViewTracker = yl.getAdViewTracker()) == null || !maxAd.equals(adViewTracker.uz()))) {
                yl.recycle();
            }
            MaxNativeAd nativeAd = dVar.getNativeAd();
            if (!(nativeAd == null || nativeAd.getAdViewTracker() == null)) {
                nativeAd.getAdViewTracker().destroy();
            }
            this.sdk.Cb().a((g) dVar);
            this.sdk.Cy().destroyAd(dVar);
            this.sdk.CD().o(this.adUnitId, dVar.getLoadTag());
            return;
        }
        x xVar3 = this.logger;
        if (x.Fn()) {
            x xVar4 = this.logger;
            String str2 = this.tag;
            xVar4.f(str2, "Destroy failed on non-native ad(" + maxAd + ")");
        }
    }

    public void setLocalExtraParameter(String str, Object obj) {
        super.setLocalExtraParameter(str, obj);
        if (KEY_EXTRA_PARAMETER_AD_REQUEST_TYPE.equalsIgnoreCase(str) && (obj instanceof d.a)) {
            this.anF = (d.a) obj;
        }
    }

    /* access modifiers changed from: private */
    public void a(com.applovin.impl.mediation.b.d dVar) {
        if (!dVar.yo().get()) {
            this.sdk.Cb().a(dVar, this);
        }
    }

    public void onAdExpired(g gVar) {
        x xVar = this.logger;
        if (x.Fn()) {
            x xVar2 = this.logger;
            String str = this.tag;
            xVar2.f(str, "Ad expired for ad unit id " + getAdUnitId());
        }
        x xVar3 = this.logger;
        if (x.Fn()) {
            x xVar4 = this.logger;
            String str2 = this.tag;
            xVar4.f(str2, "MaxNativeAdListener.onNativeAdExpired(nativeAd=" + gVar + "), listener=" + this.anG);
        }
        m.b(this.anG, (MaxAd) (com.applovin.impl.mediation.b.d) gVar, true, true);
    }

    public void onCreativeIdGenerated(String str, String str2) {
        com.applovin.impl.mediation.b.d dVar;
        Iterator<com.applovin.impl.mediation.b.d> it = this.anI.iterator();
        while (true) {
            if (!it.hasNext()) {
                dVar = null;
                break;
            }
            dVar = it.next();
            if (dVar.xA().equalsIgnoreCase(str)) {
                break;
            }
        }
        if (dVar != null) {
            dVar.bV(str2);
            m.a(this.adReviewListener, str2, (MaxAd) dVar);
            synchronized (this.amY) {
                this.anI.remove(dVar);
            }
        }
    }

    private void a(String str, MaxNativeAdView maxNativeAdView) {
        if (!TextUtils.isEmpty(str)) {
            synchronized (this.amY) {
                this.anH.put(str, maxNativeAdView);
            }
        }
    }

    /* access modifiers changed from: private */
    public MaxNativeAdView bF(String str) {
        MaxNativeAdView remove;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (this.amY) {
            remove = this.anH.remove(str);
        }
        return remove;
    }

    /* access modifiers changed from: private */
    public void a(final MaxNativeAdView maxNativeAdView, final com.applovin.impl.mediation.b.d dVar, final MaxNativeAd maxNativeAd) {
        dVar.setNativeAdView(maxNativeAdView);
        g(dVar);
        AnonymousClass2 r0 = new Runnable() {
            public void run() {
                x xVar = MaxNativeAdLoaderImpl.this.logger;
                if (x.Fn()) {
                    x xVar2 = MaxNativeAdLoaderImpl.this.logger;
                    String str = MaxNativeAdLoaderImpl.this.tag;
                    xVar2.f(str, "Rendering native ad view: " + maxNativeAdView);
                }
                maxNativeAdView.render(dVar, MaxNativeAdLoaderImpl.this.anE, MaxNativeAdLoaderImpl.this.sdk);
                maxNativeAd.setNativeAdView(maxNativeAdView);
                if (!maxNativeAd.prepareForInteraction(maxNativeAdView.getClickableViews(), maxNativeAdView)) {
                    maxNativeAd.prepareViewForInteraction(maxNativeAdView);
                }
            }
        };
        if (maxNativeAd.shouldPrepareViewForInteractionOnMainThread()) {
            AppLovinSdkUtils.runOnUiThread(r0);
        } else {
            this.sdk.BO().a((com.applovin.impl.sdk.e.d) new ab(this.sdk, "renderMaxNativeAd", r0), q.b.MEDIATION_MAIN);
        }
    }

    /* access modifiers changed from: private */
    public void b(MaxNativeAdView maxNativeAdView) {
        b adViewTracker = maxNativeAdView.getAdViewTracker();
        if (adViewTracker == null) {
            return;
        }
        if (h.KW()) {
            if (maxNativeAdView.isAttachedToWindow()) {
                adViewTracker.uy();
            }
        } else if (maxNativeAdView.getParent() != null) {
            adViewTracker.uy();
        }
    }

    private class a implements a.C0067a {
        public void onAdDisplayFailed(MaxAd maxAd, MaxError maxError) {
        }

        public void onAdDisplayed(MaxAd maxAd) {
        }

        public void onAdHidden(MaxAd maxAd) {
        }

        public void onAdRequestStarted(String str) {
        }

        private a() {
        }

        public void onAdLoaded(MaxAd maxAd) {
            AppLovinSdkUtils.runOnUiThread(new MaxNativeAdLoaderImpl$a$$ExternalSyntheticLambda0(this, maxAd));
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void f(MaxAd maxAd) {
            x xVar = MaxNativeAdLoaderImpl.this.logger;
            if (x.Fn()) {
                MaxNativeAdLoaderImpl.this.logger.f(MaxNativeAdLoaderImpl.this.tag, "Native ad loaded");
            }
            com.applovin.impl.mediation.b.d dVar = (com.applovin.impl.mediation.b.d) maxAd;
            dVar.setPlacement(MaxNativeAdLoaderImpl.this.amN);
            dVar.setCustomData(MaxNativeAdLoaderImpl.this.amS);
            MaxNativeAdLoaderImpl.this.sdk.Co().V(dVar);
            synchronized (MaxNativeAdLoaderImpl.this.amY) {
                MaxNativeAdLoaderImpl.this.anI.add(dVar);
            }
            MaxNativeAdView a = MaxNativeAdLoaderImpl.this.bF(dVar.getLoadTag());
            if (a == null) {
                x xVar2 = MaxNativeAdLoaderImpl.this.logger;
                if (x.Fn()) {
                    MaxNativeAdLoaderImpl.this.logger.f(MaxNativeAdLoaderImpl.this.tag, "No custom view provided, checking template");
                }
                String yn = dVar.yn();
                if (StringUtils.isValidString(yn)) {
                    x xVar3 = MaxNativeAdLoaderImpl.this.logger;
                    if (x.Fn()) {
                        x xVar4 = MaxNativeAdLoaderImpl.this.logger;
                        String str = MaxNativeAdLoaderImpl.this.tag;
                        xVar4.f(str, "Using template: " + yn + "...");
                    }
                    a = new MaxNativeAdView(yn, n.getApplicationContext());
                }
            }
            if (a == null) {
                x xVar5 = MaxNativeAdLoaderImpl.this.logger;
                if (x.Fn()) {
                    MaxNativeAdLoaderImpl.this.logger.f(MaxNativeAdLoaderImpl.this.tag, "No native ad view to render. Returning the native ad to be rendered later.");
                }
                x xVar6 = MaxNativeAdLoaderImpl.this.logger;
                if (x.Fn()) {
                    x xVar7 = MaxNativeAdLoaderImpl.this.logger;
                    String str2 = MaxNativeAdLoaderImpl.this.tag;
                    xVar7.f(str2, "MaxNativeAdListener.onNativeAdLoaded(nativeAdView=null, nativeAd=" + maxAd + "), listener=" + MaxNativeAdLoaderImpl.this.anG);
                }
                m.a(MaxNativeAdLoaderImpl.this.anG, (MaxNativeAdView) null, maxAd, true, true);
                MaxNativeAdLoaderImpl.this.a(dVar);
                return;
            }
            c(a);
            MaxNativeAdLoaderImpl.this.a(a, dVar, dVar.getNativeAd());
            x xVar8 = MaxNativeAdLoaderImpl.this.logger;
            if (x.Fn()) {
                x xVar9 = MaxNativeAdLoaderImpl.this.logger;
                String str3 = MaxNativeAdLoaderImpl.this.tag;
                xVar9.f(str3, "MaxNativeAdListener.onNativeAdLoaded(nativeAdView=" + a + ", nativeAd=" + maxAd + "), listener=" + MaxNativeAdLoaderImpl.this.anG);
            }
            m.a(MaxNativeAdLoaderImpl.this.anG, a, maxAd, true, true);
            MaxNativeAdLoaderImpl.this.a(dVar);
            MaxNativeAdLoaderImpl.this.b(a);
        }

        public void onAdLoadFailed(String str, MaxError maxError) {
            MaxNativeAdView unused = MaxNativeAdLoaderImpl.this.bF(((MaxErrorImpl) maxError).getLoadTag());
            x xVar = MaxNativeAdLoaderImpl.this.logger;
            if (x.Fn()) {
                x xVar2 = MaxNativeAdLoaderImpl.this.logger;
                String str2 = MaxNativeAdLoaderImpl.this.tag;
                xVar2.f(str2, "MaxNativeAdListener.onNativeAdLoadFailed(adUnitId=" + str + ", error=" + maxError + "), listener=" + MaxNativeAdLoaderImpl.this.anG);
            }
            m.a(MaxNativeAdLoaderImpl.this.anG, str, maxError, true, true);
        }

        public void onAdClicked(MaxAd maxAd) {
            x xVar = MaxNativeAdLoaderImpl.this.logger;
            if (x.Fn()) {
                x xVar2 = MaxNativeAdLoaderImpl.this.logger;
                String str = MaxNativeAdLoaderImpl.this.tag;
                xVar2.f(str, "MaxNativeAdListener.onNativeAdClicked(nativeAd=" + maxAd + "), listener=" + MaxNativeAdLoaderImpl.this.anG);
            }
            m.a(MaxNativeAdLoaderImpl.this.anG, maxAd, true, true);
        }

        public void onAdRevenuePaid(MaxAd maxAd) {
            x xVar = MaxNativeAdLoaderImpl.this.logger;
            if (x.Fn()) {
                x xVar2 = MaxNativeAdLoaderImpl.this.logger;
                String str = MaxNativeAdLoaderImpl.this.tag;
                xVar2.f(str, "MaxAdRevenueListener.onAdRevenuePaid(ad=" + maxAd + "), listener=" + MaxNativeAdLoaderImpl.this.revenueListener);
            }
            m.a(MaxNativeAdLoaderImpl.this.revenueListener, maxAd, true, true);
        }

        private void c(MaxNativeAdView maxNativeAdView) {
            com.applovin.impl.mediation.b.d uz;
            b adViewTracker = maxNativeAdView.getAdViewTracker();
            if (adViewTracker != null && (uz = adViewTracker.uz()) != null) {
                x xVar = MaxNativeAdLoaderImpl.this.logger;
                if (x.Fn()) {
                    MaxNativeAdLoaderImpl.this.logger.f(MaxNativeAdLoaderImpl.this.tag, "Destroying previous ad");
                }
                MaxNativeAdLoaderImpl.this.destroy(uz);
            }
        }
    }

    public String toString() {
        return "MaxNativeAdLoader{adUnitId='" + this.adUnitId + "', nativeAdListener=" + this.anG + ", revenueListener=" + this.revenueListener + '}';
    }
}
