package com.ironsource.adapters.unityads;

import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.sdk.BannerSmashListener;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.unity3d.services.banners.BannerErrorCode;
import com.unity3d.services.banners.BannerErrorInfo;
import com.unity3d.services.banners.BannerView;
import java.lang.ref.WeakReference;

final class UnityAdsBannerListener implements BannerView.IListener {
    private WeakReference<UnityAdsAdapter> mAdapter;
    private BannerSmashListener mListener;
    private String mPlacementId;

    UnityAdsBannerListener(UnityAdsAdapter unityAdsAdapter, BannerSmashListener bannerSmashListener, String str) {
        this.mAdapter = new WeakReference<>(unityAdsAdapter);
        this.mPlacementId = str;
        this.mListener = bannerSmashListener;
    }

    public void onBannerLoaded(BannerView bannerView) {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose("placementId = " + this.mPlacementId);
        if (this.mListener == null) {
            IronLog.INTERNAL.verbose("listener is null");
            return;
        }
        WeakReference<UnityAdsAdapter> weakReference = this.mAdapter;
        if (weakReference == null || weakReference.get() == null) {
            IronLog.INTERNAL.verbose("adapter is null");
        } else {
            this.mListener.onBannerAdLoaded(bannerView, ((UnityAdsAdapter) this.mAdapter.get()).createLayoutParams(bannerView.getSize()));
        }
    }

    public void onBannerShown(BannerView bannerView) {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose("placementId = " + this.mPlacementId);
        if (this.mListener == null) {
            IronLog.INTERNAL.verbose("listener is null");
            return;
        }
        WeakReference<UnityAdsAdapter> weakReference = this.mAdapter;
        if (weakReference == null || weakReference.get() == null) {
            IronLog.INTERNAL.verbose("adapter is null");
        } else {
            this.mListener.onBannerAdShown();
        }
    }

    public void onBannerFailedToLoad(BannerView bannerView, BannerErrorInfo bannerErrorInfo) {
        IronSourceError ironSourceError;
        if (this.mListener == null) {
            IronLog.INTERNAL.verbose("listener is null");
            return;
        }
        WeakReference<UnityAdsAdapter> weakReference = this.mAdapter;
        if (weakReference == null || weakReference.get() == null) {
            IronLog.INTERNAL.verbose("adapter is null");
            return;
        }
        String str = ((UnityAdsAdapter) this.mAdapter.get()).getProviderName() + " banner, onAdLoadFailed placementId " + this.mPlacementId + " with error: " + bannerErrorInfo.errorMessage;
        if (bannerErrorInfo.errorCode == BannerErrorCode.NO_FILL) {
            ironSourceError = new IronSourceError(606, str);
        } else {
            ironSourceError = ErrorBuilder.buildLoadFailedError(str);
        }
        IronLog.ADAPTER_CALLBACK.error("placementId = " + this.mPlacementId + " ironSourceError = " + ironSourceError);
        this.mListener.onBannerAdLoadFailed(ironSourceError);
    }

    public void onBannerClick(BannerView bannerView) {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose("placementId = " + this.mPlacementId);
        BannerSmashListener bannerSmashListener = this.mListener;
        if (bannerSmashListener == null) {
            IronLog.INTERNAL.verbose("listener is null");
        } else {
            bannerSmashListener.onBannerAdClicked();
        }
    }

    public void onBannerLeftApplication(BannerView bannerView) {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose("placementId = " + this.mPlacementId);
        BannerSmashListener bannerSmashListener = this.mListener;
        if (bannerSmashListener == null) {
            IronLog.INTERNAL.verbose("listener is null");
        } else {
            bannerSmashListener.onBannerAdLeftApplication();
        }
    }
}
