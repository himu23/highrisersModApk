package com.applovin.mediation.nativeAds;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.applovin.impl.mediation.ads.MaxNativeAdLoaderImpl;
import com.applovin.impl.mediation.ads.a;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdRevenueListener;
import com.applovin.mediation.MaxAdReviewListener;
import com.applovin.sdk.AppLovinSdk;
import java.util.List;

public class MaxNativeAdLoader {
    private final MaxNativeAdLoaderImpl aYE;

    public MaxNativeAdLoader(String str, Context context) {
        this(str, AppLovinSdk.getInstance(context), context);
    }

    public MaxNativeAdLoader(String str, AppLovinSdk appLovinSdk, Context context) {
        a.logApiCall("MaxNativeAdLoader", "MaxNativeAdLoader(adUnitId=" + str + ", sdk=" + appLovinSdk + ")");
        if (str == null) {
            throw new IllegalArgumentException("No ad unit ID specified");
        } else if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Empty ad unit ID specified");
        } else if (appLovinSdk == null) {
            throw new IllegalArgumentException("No sdk specified");
        } else if (context != null) {
            this.aYE = new MaxNativeAdLoaderImpl(str, appLovinSdk.a());
        } else {
            throw new IllegalArgumentException("No context specified");
        }
    }

    public void loadAd() {
        loadAd((MaxNativeAdView) null);
    }

    public void loadAd(MaxNativeAdView maxNativeAdView) {
        MaxNativeAdLoaderImpl maxNativeAdLoaderImpl = this.aYE;
        maxNativeAdLoaderImpl.logApiCall("loadAd(adView=" + maxNativeAdView + ")");
        this.aYE.loadAd(maxNativeAdView);
    }

    public boolean render(MaxNativeAdView maxNativeAdView, MaxAd maxAd) {
        MaxNativeAdLoaderImpl maxNativeAdLoaderImpl = this.aYE;
        maxNativeAdLoaderImpl.logApiCall("render(adView=" + maxNativeAdView + ", ad=" + maxAd + ")");
        return this.aYE.render(maxNativeAdView, maxAd);
    }

    public void setNativeAdListener(MaxNativeAdListener maxNativeAdListener) {
        MaxNativeAdLoaderImpl maxNativeAdLoaderImpl = this.aYE;
        maxNativeAdLoaderImpl.logApiCall("setNativeAdListener(listener=" + maxNativeAdListener + ")");
        this.aYE.setNativeAdListener(maxNativeAdListener);
    }

    public void setRevenueListener(MaxAdRevenueListener maxAdRevenueListener) {
        MaxNativeAdLoaderImpl maxNativeAdLoaderImpl = this.aYE;
        maxNativeAdLoaderImpl.logApiCall("setRevenueListener(listener=" + maxAdRevenueListener + ")");
        this.aYE.setRevenueListener(maxAdRevenueListener);
    }

    public void setAdReviewListener(MaxAdReviewListener maxAdReviewListener) {
        MaxNativeAdLoaderImpl maxNativeAdLoaderImpl = this.aYE;
        maxNativeAdLoaderImpl.logApiCall("setAdReviewListener(listener=" + maxAdReviewListener + ")");
        this.aYE.setAdReviewListener(maxAdReviewListener);
    }

    public void setPlacement(String str) {
        MaxNativeAdLoaderImpl maxNativeAdLoaderImpl = this.aYE;
        maxNativeAdLoaderImpl.logApiCall("setPlacement(placement=" + str + ")");
        this.aYE.setPlacement(str);
    }

    public String getPlacement() {
        this.aYE.logApiCall("getPlacement()");
        return this.aYE.getPlacement();
    }

    public void setCustomData(String str) {
        MaxNativeAdLoaderImpl maxNativeAdLoaderImpl = this.aYE;
        maxNativeAdLoaderImpl.logApiCall("setCustomData(value=" + str + ")");
        this.aYE.setCustomData(str);
    }

    public String getAdUnitId() {
        return this.aYE.getAdUnitId();
    }

    public void destroy() {
        this.aYE.logApiCall("destroy()");
        this.aYE.destroy();
    }

    public void destroy(MaxAd maxAd) {
        MaxNativeAdLoaderImpl maxNativeAdLoaderImpl = this.aYE;
        maxNativeAdLoaderImpl.logApiCall("destroy(nativeAd=" + maxAd + ")");
        this.aYE.destroy(maxAd);
    }

    public void setExtraParameter(String str, String str2) {
        MaxNativeAdLoaderImpl maxNativeAdLoaderImpl = this.aYE;
        maxNativeAdLoaderImpl.logApiCall("setExtraParameter(key=" + str + ", value=" + str2 + ")");
        this.aYE.setExtraParameter(str, str2);
    }

    public void setLocalExtraParameter(String str, Object obj) {
        MaxNativeAdLoaderImpl maxNativeAdLoaderImpl = this.aYE;
        maxNativeAdLoaderImpl.logApiCall("setLocalExtraParameter(key=" + str + ", value=" + obj + ")");
        this.aYE.setLocalExtraParameter(str, obj);
    }

    public void a(List<View> list, ViewGroup viewGroup, MaxAd maxAd) {
        this.aYE.logApiCall("a()");
        this.aYE.registerClickableViews(list, viewGroup, maxAd);
    }

    public void b(MaxAd maxAd) {
        this.aYE.logApiCall("b()");
        this.aYE.handleNativeAdViewRendered(maxAd);
    }
}
