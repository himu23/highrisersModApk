package com.applovin.impl.mediation;

import com.applovin.impl.mediation.b.a;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdWaterfallInfo;
import com.applovin.mediation.nativeAds.MaxNativeAd;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.ArrayList;

public class i implements MaxAd {
    private final MaxAdFormat adFormat;
    private final String adUnitId;
    private final String amN;

    public String getAdReviewCreativeId() {
        return null;
    }

    public String getAdUnitId() {
        return this.adUnitId;
    }

    public String getAdValue(String str) {
        return null;
    }

    public String getAdValue(String str, String str2) {
        return null;
    }

    public String getCreativeId() {
        return null;
    }

    public String getDspId() {
        return null;
    }

    public String getDspName() {
        return null;
    }

    public MaxAdFormat getFormat() {
        return this.adFormat;
    }

    public MaxNativeAd getNativeAd() {
        return null;
    }

    public String getNetworkName() {
        return "";
    }

    public String getNetworkPlacement() {
        return null;
    }

    public String getPlacement() {
        return this.amN;
    }

    public long getRequestLatencyMillis() {
        return 0;
    }

    public double getRevenue() {
        return 0.0d;
    }

    public String getRevenuePrecision() {
        return "undefined";
    }

    public i(String str, MaxAdFormat maxAdFormat, String str2) {
        this.adUnitId = str;
        this.adFormat = maxAdFormat;
        this.amN = str2;
    }

    public MaxAdWaterfallInfo getWaterfall() {
        return new MaxAdWaterfallInfoImpl((a) null, "", "", 0, new ArrayList());
    }

    public AppLovinSdkUtils.Size getSize() {
        return getFormat().getSize();
    }

    public String toString() {
        return "MaxAd{adUnitId=" + this.adUnitId + ", format=" + this.adFormat + "}";
    }
}
