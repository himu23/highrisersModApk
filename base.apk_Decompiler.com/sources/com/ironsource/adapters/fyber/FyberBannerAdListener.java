package com.ironsource.adapters.fyber;

import android.widget.FrameLayout;
import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.external.InneractiveAdViewEventsListener;
import com.fyber.inneractive.sdk.external.InneractiveErrorCode;
import com.fyber.inneractive.sdk.external.InneractiveUnitController;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.IronSourceBannerLayout;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.sdk.BannerSmashListener;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import java.lang.ref.WeakReference;

public class FyberBannerAdListener implements InneractiveAdSpot.RequestListener, InneractiveAdViewEventsListener {
    private WeakReference<FyberAdapter> mAdapter;
    private BannerSmashListener mListener;
    private String mSpotId;

    FyberBannerAdListener(FyberAdapter fyberAdapter, BannerSmashListener bannerSmashListener, String str) {
        this.mAdapter = new WeakReference<>(fyberAdapter);
        this.mListener = bannerSmashListener;
        this.mSpotId = str;
    }

    public void onInneractiveSuccessfulAdRequest(InneractiveAdSpot inneractiveAdSpot) {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose("spotId = " + this.mSpotId);
        if (this.mListener == null) {
            IronLog.INTERNAL.verbose("listener is null");
            return;
        }
        WeakReference<FyberAdapter> weakReference = this.mAdapter;
        if (weakReference == null || weakReference.get() == null) {
            IronLog.INTERNAL.verbose("adapter is null");
        } else if (!inneractiveAdSpot.isReady()) {
            BannerSmashListener bannerSmashListener = this.mListener;
            bannerSmashListener.onBannerAdLoadFailed(ErrorBuilder.buildLoadFailedError(((FyberAdapter) this.mAdapter.get()).getProviderName() + " banner failed to load, Spot not ready - " + this.mSpotId));
        } else {
            IronSourceBannerLayout ironSourceBannerLayout = ((FyberAdapter) this.mAdapter.get()).mSpotIdToBannerLayout.get(this.mSpotId);
            if (ironSourceBannerLayout == null || ironSourceBannerLayout.isDestroyed()) {
                this.mListener.onBannerAdLoadFailed(ErrorBuilder.buildLoadFailedError("Fyber loadBanner - banner ".concat(ironSourceBannerLayout == null ? "layout is null" : "is destroyed")));
                return;
            }
            FrameLayout.LayoutParams calculateLayoutParams = ((FyberAdapter) this.mAdapter.get()).calculateLayoutParams(ironSourceBannerLayout.getSize());
            if (calculateLayoutParams == null) {
                BannerSmashListener bannerSmashListener2 = this.mListener;
                bannerSmashListener2.onBannerAdLoadFailed(ErrorBuilder.unsupportedBannerSize("Fyber - size = " + ironSourceBannerLayout.getSize()));
                return;
            }
            FrameLayout frameLayout = new FrameLayout(ContextProvider.getInstance().getApplicationContext());
            ((FyberAdapter) this.mAdapter.get()).mInneractiveAdViewUnitController.bindView(frameLayout);
            this.mListener.onBannerAdLoaded(frameLayout, calculateLayoutParams);
        }
    }

    public void onInneractiveFailedAdRequest(InneractiveAdSpot inneractiveAdSpot, InneractiveErrorCode inneractiveErrorCode) {
        IronSourceError ironSourceError;
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose("spotId = " + this.mSpotId);
        if (this.mListener == null) {
            IronLog.INTERNAL.verbose("listener is null");
            return;
        }
        if (inneractiveErrorCode == null) {
            ironSourceError = ErrorBuilder.buildLoadFailedError("Banner failed to load (inneractiveErrorCode is null)");
        } else {
            IronLog ironLog2 = IronLog.ADAPTER_CALLBACK;
            ironLog2.verbose("inneractiveErrorCode = " + inneractiveErrorCode);
            if (inneractiveErrorCode == InneractiveErrorCode.NO_FILL) {
                ironSourceError = new IronSourceError(606, inneractiveErrorCode.toString());
            } else {
                ironSourceError = ErrorBuilder.buildLoadFailedError(inneractiveErrorCode.toString());
            }
        }
        this.mListener.onBannerAdLoadFailed(ironSourceError);
    }

    public void onAdImpression(InneractiveAdSpot inneractiveAdSpot) {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose("spotId = " + this.mSpotId);
        BannerSmashListener bannerSmashListener = this.mListener;
        if (bannerSmashListener == null) {
            IronLog.INTERNAL.verbose("listener is null");
        } else {
            bannerSmashListener.onBannerAdShown();
        }
    }

    public void onAdClicked(InneractiveAdSpot inneractiveAdSpot) {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose("spotId = " + this.mSpotId);
        BannerSmashListener bannerSmashListener = this.mListener;
        if (bannerSmashListener == null) {
            IronLog.INTERNAL.verbose("listener is null");
        } else {
            bannerSmashListener.onBannerAdClicked();
        }
    }

    public void onAdWillCloseInternalBrowser(InneractiveAdSpot inneractiveAdSpot) {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose("spotId = " + this.mSpotId);
        BannerSmashListener bannerSmashListener = this.mListener;
        if (bannerSmashListener == null) {
            IronLog.INTERNAL.verbose("listener is null");
        } else {
            bannerSmashListener.onBannerAdScreenDismissed();
        }
    }

    public void onAdWillOpenExternalApp(InneractiveAdSpot inneractiveAdSpot) {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose("spotId = " + this.mSpotId);
        BannerSmashListener bannerSmashListener = this.mListener;
        if (bannerSmashListener == null) {
            IronLog.INTERNAL.verbose("listener is null");
        } else {
            bannerSmashListener.onBannerAdLeftApplication();
        }
    }

    public void onAdEnteredErrorState(InneractiveAdSpot inneractiveAdSpot, InneractiveUnitController.AdDisplayError adDisplayError) {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose("spotId = " + this.mSpotId);
    }

    public void onAdExpanded(InneractiveAdSpot inneractiveAdSpot) {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose("spotId = " + this.mSpotId);
    }

    public void onAdResized(InneractiveAdSpot inneractiveAdSpot) {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose("spotId = " + this.mSpotId);
    }

    public void onAdCollapsed(InneractiveAdSpot inneractiveAdSpot) {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose("spotId = " + this.mSpotId);
    }
}
