package com.unity3d.scar.adapter.v2000.scarads;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.LoadAdError;
import com.unity3d.scar.adapter.common.IScarBannerAdListenerWrapper;

public class ScarBannerAdListener extends ScarAdListener {
    private final AdListener _adListener = new AdListener() {
        public void onAdClicked() {
            ScarBannerAdListener.super.onAdClicked();
            ScarBannerAdListener.this._adListenerWrapper.onAdClicked();
        }

        public void onAdClosed() {
            ScarBannerAdListener.super.onAdClosed();
            ScarBannerAdListener.this._adListenerWrapper.onAdClosed();
        }

        public void onAdFailedToLoad(LoadAdError loadAdError) {
            ScarBannerAdListener.super.onAdFailedToLoad(loadAdError);
            ScarBannerAdListener.this._scarBannerAd.removeAdView();
            ScarBannerAdListener.this._adListenerWrapper.onAdFailedToLoad(loadAdError.getCode(), loadAdError.getMessage());
        }

        public void onAdImpression() {
            ScarBannerAdListener.super.onAdImpression();
            ScarBannerAdListener.this._adListenerWrapper.onAdImpression();
        }

        public void onAdLoaded() {
            ScarBannerAdListener.super.onAdLoaded();
            ScarBannerAdListener.this._adListenerWrapper.onAdLoaded();
        }

        public void onAdOpened() {
            ScarBannerAdListener.super.onAdOpened();
            ScarBannerAdListener.this._adListenerWrapper.onAdOpened();
        }
    };
    /* access modifiers changed from: private */
    public final IScarBannerAdListenerWrapper _adListenerWrapper;
    /* access modifiers changed from: private */
    public final ScarBannerAd _scarBannerAd;

    public AdListener getAdListener() {
        return this._adListener;
    }

    public ScarBannerAdListener(IScarBannerAdListenerWrapper iScarBannerAdListenerWrapper, ScarBannerAd scarBannerAd) {
        this._adListenerWrapper = iScarBannerAdListenerWrapper;
        this._scarBannerAd = scarBannerAd;
    }
}
