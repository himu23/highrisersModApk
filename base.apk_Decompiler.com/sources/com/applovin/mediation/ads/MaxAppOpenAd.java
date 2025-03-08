package com.applovin.mediation.ads;

import android.app.Activity;
import android.content.Context;
import com.applovin.impl.mediation.ads.MaxFullscreenAdImpl;
import com.applovin.impl.mediation.ads.a;
import com.applovin.impl.sdk.utils.u;
import com.applovin.mediation.MaxAdExpirationListener;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxAdRequestListener;
import com.applovin.mediation.MaxAdRevenueListener;
import com.applovin.mediation.MaxAdReviewListener;
import com.applovin.sdk.AppLovinSdk;

public class MaxAppOpenAd {
    private final MaxFullscreenAdImpl aYv;

    public MaxAppOpenAd(String str, Context context) {
        this(str, AppLovinSdk.getInstance(context));
    }

    public MaxAppOpenAd(String str, AppLovinSdk appLovinSdk) {
        a.logApiCall("MaxAppOpenAd", "MaxAppOpenAd(adUnitId=" + str + ", sdk=" + appLovinSdk + ")");
        this.aYv = new MaxFullscreenAdImpl(str.trim(), MaxAdFormat.APP_OPEN, (MaxFullscreenAdImpl.a) null, "MaxAppOpenAd", appLovinSdk.a());
    }

    public void setListener(MaxAdListener maxAdListener) {
        MaxFullscreenAdImpl maxFullscreenAdImpl = this.aYv;
        maxFullscreenAdImpl.logApiCall("setListener(listener=" + maxAdListener + ")");
        this.aYv.setListener(maxAdListener);
    }

    public void setRevenueListener(MaxAdRevenueListener maxAdRevenueListener) {
        MaxFullscreenAdImpl maxFullscreenAdImpl = this.aYv;
        maxFullscreenAdImpl.logApiCall("setRevenueListener(listener=" + maxAdRevenueListener + ")");
        this.aYv.setRevenueListener(maxAdRevenueListener);
    }

    public void setRequestListener(MaxAdRequestListener maxAdRequestListener) {
        MaxFullscreenAdImpl maxFullscreenAdImpl = this.aYv;
        maxFullscreenAdImpl.logApiCall("setRequestListener(listener=" + maxAdRequestListener + ")");
        this.aYv.setRequestListener(maxAdRequestListener);
    }

    public void setExpirationListener(MaxAdExpirationListener maxAdExpirationListener) {
        MaxFullscreenAdImpl maxFullscreenAdImpl = this.aYv;
        maxFullscreenAdImpl.logApiCall("setExpirationListener(listener=" + maxAdExpirationListener + ")");
        this.aYv.setExpirationListener(maxAdExpirationListener);
    }

    public void setAdReviewListener(MaxAdReviewListener maxAdReviewListener) {
        MaxFullscreenAdImpl maxFullscreenAdImpl = this.aYv;
        maxFullscreenAdImpl.logApiCall("setAdReviewListener(listener=" + maxAdReviewListener + ")");
        this.aYv.setAdReviewListener(maxAdReviewListener);
    }

    public void loadAd() {
        this.aYv.logApiCall("loadAd()");
        this.aYv.loadAd((Activity) null);
    }

    public void showAd() {
        showAd((String) null);
    }

    public void showAd(String str) {
        showAd(str, (String) null);
    }

    public void showAd(String str, String str2) {
        MaxFullscreenAdImpl maxFullscreenAdImpl = this.aYv;
        maxFullscreenAdImpl.logApiCall("showAd(placement=" + str + ", customData=" + str2 + ")");
        u.N(str2, "MaxAppOpenAd");
        this.aYv.showAd(str, str2, (Activity) null);
    }

    public String getAdUnitId() {
        return this.aYv.getAdUnitId();
    }

    public boolean isReady() {
        boolean isReady = this.aYv.isReady();
        MaxFullscreenAdImpl maxFullscreenAdImpl = this.aYv;
        maxFullscreenAdImpl.logApiCall("isReady() " + isReady + " for ad unit id " + this.aYv.getAdUnitId());
        return isReady;
    }

    public void destroy() {
        this.aYv.logApiCall("destroy()");
        this.aYv.destroy();
    }

    public void setExtraParameter(String str, String str2) {
        MaxFullscreenAdImpl maxFullscreenAdImpl = this.aYv;
        maxFullscreenAdImpl.logApiCall("setExtraParameter(key=" + str + ", value=" + str2 + ")");
        this.aYv.setExtraParameter(str, str2);
    }

    public void setLocalExtraParameter(String str, Object obj) {
        MaxFullscreenAdImpl maxFullscreenAdImpl = this.aYv;
        maxFullscreenAdImpl.logApiCall("setLocalExtraParameter(key=" + str + ", value=" + obj + ")");
        this.aYv.setLocalExtraParameter(str, obj);
    }

    public String toString() {
        return "" + this.aYv;
    }
}
