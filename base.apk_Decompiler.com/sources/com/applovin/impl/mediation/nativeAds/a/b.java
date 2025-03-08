package com.applovin.impl.mediation.nativeAds.a;

import android.content.Context;
import com.applovin.impl.mediation.ads.MaxNativeAdLoaderImpl;
import com.applovin.impl.mediation.d;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdRevenueListener;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.nativeAds.MaxNativeAdListener;
import com.applovin.mediation.nativeAds.MaxNativeAdLoader;
import com.applovin.mediation.nativeAds.MaxNativeAdView;
import com.applovin.mediation.nativeAds.adPlacer.MaxAdPlacerSettings;
import java.util.LinkedList;
import java.util.Queue;

public class b extends MaxNativeAdListener implements MaxAdRevenueListener {
    private final MaxNativeAdLoader auQ;
    private final Queue<MaxAd> auR = new LinkedList();
    private boolean auS = false;
    private a auT;
    private final int oW;
    private final Object rT = new Object();

    public interface a {
        void onAdRevenuePaid(MaxAd maxAd);

        void onNativeAdClicked(MaxAd maxAd);

        void onNativeAdLoadFailed(String str, MaxError maxError);

        void onNativeAdLoaded();
    }

    public b(MaxAdPlacerSettings maxAdPlacerSettings, Context context, a aVar) {
        this.oW = maxAdPlacerSettings.getMaxPreloadedAdCount();
        this.auT = aVar;
        MaxNativeAdLoader maxNativeAdLoader = new MaxNativeAdLoader(maxAdPlacerSettings.getAdUnitId(), context);
        this.auQ = maxNativeAdLoader;
        maxNativeAdLoader.setNativeAdListener(this);
        maxNativeAdLoader.setRevenueListener(this);
        maxNativeAdLoader.setPlacement(maxAdPlacerSettings.getPlacement());
        maxNativeAdLoader.setLocalExtraParameter(MaxNativeAdLoaderImpl.KEY_EXTRA_PARAMETER_AD_REQUEST_TYPE, d.a.NATIVE_AD_PLACER);
    }

    public void destroy() {
        this.auT = null;
        clearAds();
        this.auQ.destroy();
    }

    public boolean yO() {
        boolean z;
        synchronized (this.rT) {
            z = !this.auR.isEmpty();
        }
        return z;
    }

    public void loadAds() {
        synchronized (this.rT) {
            if (!this.auS && this.auR.size() < this.oW) {
                this.auS = true;
                this.auQ.loadAd();
            }
        }
    }

    public MaxAd yP() {
        MaxAd maxAd;
        synchronized (this.rT) {
            maxAd = null;
            while (!this.auR.isEmpty() && (maxAd == null || maxAd.getNativeAd().isExpired())) {
                maxAd = this.auR.remove();
            }
            loadAds();
        }
        return maxAd;
    }

    public void destroyAd(MaxAd maxAd) {
        this.auQ.destroy(maxAd);
    }

    public void clearAds() {
        synchronized (this.rT) {
            for (MaxAd destroyAd : this.auR) {
                destroyAd(destroyAd);
            }
            this.auR.clear();
        }
    }

    public boolean render(MaxNativeAdView maxNativeAdView, MaxAd maxAd) {
        return this.auQ.render(maxNativeAdView, maxAd);
    }

    public void onNativeAdLoaded(MaxNativeAdView maxNativeAdView, MaxAd maxAd) {
        synchronized (this.rT) {
            this.auR.add(maxAd);
            this.auS = false;
            loadAds();
        }
        a aVar = this.auT;
        if (aVar != null) {
            aVar.onNativeAdLoaded();
        }
    }

    public void onNativeAdLoadFailed(String str, MaxError maxError) {
        a aVar = this.auT;
        if (aVar != null) {
            aVar.onNativeAdLoadFailed(str, maxError);
        }
    }

    public void onNativeAdClicked(MaxAd maxAd) {
        a aVar = this.auT;
        if (aVar != null) {
            aVar.onNativeAdClicked(maxAd);
        }
    }

    public void onAdRevenuePaid(MaxAd maxAd) {
        a aVar = this.auT;
        if (aVar != null) {
            aVar.onAdRevenuePaid(maxAd);
        }
    }
}
