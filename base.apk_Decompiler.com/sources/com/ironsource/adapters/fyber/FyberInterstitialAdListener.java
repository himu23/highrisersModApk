package com.ironsource.adapters.fyber;

import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.external.InneractiveErrorCode;
import com.fyber.inneractive.sdk.external.InneractiveFullscreenAdEventsListener;
import com.fyber.inneractive.sdk.external.InneractiveUnitController;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.sdk.InterstitialSmashListener;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import java.lang.ref.WeakReference;

public class FyberInterstitialAdListener implements InneractiveFullscreenAdEventsListener, InneractiveAdSpot.RequestListener {
    private WeakReference<FyberAdapter> mAdapter;
    private InterstitialSmashListener mListener;
    private String mSpotId;

    FyberInterstitialAdListener(FyberAdapter fyberAdapter, InterstitialSmashListener interstitialSmashListener, String str) {
        this.mAdapter = new WeakReference<>(fyberAdapter);
        this.mListener = interstitialSmashListener;
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
            return;
        }
        ((FyberAdapter) this.mAdapter.get()).mInterstitialAdsAvailability.put(this.mSpotId, true);
        this.mListener.onInterstitialAdReady();
    }

    public void onInneractiveFailedAdRequest(InneractiveAdSpot inneractiveAdSpot, InneractiveErrorCode inneractiveErrorCode) {
        IronSourceError ironSourceError;
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose("spotId = " + this.mSpotId);
        if (this.mListener == null) {
            IronLog.INTERNAL.verbose("listener is null");
            return;
        }
        WeakReference<FyberAdapter> weakReference = this.mAdapter;
        if (weakReference == null || weakReference.get() == null) {
            IronLog.INTERNAL.verbose("adapter is null");
            return;
        }
        ((FyberAdapter) this.mAdapter.get()).mInterstitialAdsAvailability.put(this.mSpotId, false);
        if (inneractiveErrorCode == null) {
            ironSourceError = ErrorBuilder.buildLoadFailedError("Interstitial failed to load (inneractiveErrorCode is null)");
        } else {
            IronLog ironLog2 = IronLog.ADAPTER_CALLBACK;
            ironLog2.verbose("inneractiveErrorCode = " + inneractiveErrorCode);
            if (inneractiveErrorCode == InneractiveErrorCode.NO_FILL) {
                ironSourceError = new IronSourceError(1158, inneractiveErrorCode.toString());
            } else {
                ironSourceError = ErrorBuilder.buildLoadFailedError(inneractiveErrorCode.toString());
            }
        }
        this.mListener.onInterstitialAdLoadFailed(ironSourceError);
    }

    public void onAdImpression(InneractiveAdSpot inneractiveAdSpot) {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose("spotId = " + this.mSpotId);
        InterstitialSmashListener interstitialSmashListener = this.mListener;
        if (interstitialSmashListener == null) {
            IronLog.INTERNAL.verbose("listener is null");
            return;
        }
        interstitialSmashListener.onInterstitialAdOpened();
        this.mListener.onInterstitialAdShowSucceeded();
    }

    public void onAdClicked(InneractiveAdSpot inneractiveAdSpot) {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose("spotId = " + this.mSpotId);
        InterstitialSmashListener interstitialSmashListener = this.mListener;
        if (interstitialSmashListener == null) {
            IronLog.INTERNAL.verbose("listener is null");
        } else {
            interstitialSmashListener.onInterstitialAdClicked();
        }
    }

    public void onAdWillOpenExternalApp(InneractiveAdSpot inneractiveAdSpot) {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose("spotId = " + this.mSpotId);
    }

    public void onAdEnteredErrorState(InneractiveAdSpot inneractiveAdSpot, InneractiveUnitController.AdDisplayError adDisplayError) {
        String str;
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose("spotId = " + this.mSpotId);
        if (this.mListener == null) {
            IronLog.INTERNAL.verbose("listener is null");
            return;
        }
        if (adDisplayError == null) {
            str = "Interstitial show failed (adDisplayError is null)";
        } else {
            str = adDisplayError.getMessage();
            IronLog ironLog2 = IronLog.ADAPTER_CALLBACK;
            ironLog2.verbose("error = " + str);
        }
        this.mListener.onInterstitialAdShowFailed(ErrorBuilder.buildShowFailedError("Interstitial", str));
    }

    public void onAdWillCloseInternalBrowser(InneractiveAdSpot inneractiveAdSpot) {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose("spotId = " + this.mSpotId);
    }

    public void onAdDismissed(InneractiveAdSpot inneractiveAdSpot) {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose("spotId = " + this.mSpotId);
        InterstitialSmashListener interstitialSmashListener = this.mListener;
        if (interstitialSmashListener == null) {
            IronLog.INTERNAL.verbose("listener is null");
        } else {
            interstitialSmashListener.onInterstitialAdClosed();
        }
    }
}
