package com.ironsource.adapters.applovin;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.sdk.InterstitialSmashListener;
import java.lang.ref.WeakReference;

public class AppLovinInterstitialListener implements AppLovinAdLoadListener, AppLovinAdClickListener, AppLovinAdDisplayListener, AppLovinAdVideoPlaybackListener {
    private final WeakReference<AppLovinAdapter> mAdapter;
    private final InterstitialSmashListener mListener;
    private final String mZoneId;

    public AppLovinInterstitialListener(AppLovinAdapter appLovinAdapter, InterstitialSmashListener interstitialSmashListener, String str) {
        this.mAdapter = new WeakReference<>(appLovinAdapter);
        this.mZoneId = str;
        this.mListener = interstitialSmashListener;
    }

    public void adReceived(AppLovinAd appLovinAd) {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose("zoneId = " + this.mZoneId);
        WeakReference<AppLovinAdapter> weakReference = this.mAdapter;
        if (weakReference == null || weakReference.get() == null) {
            IronLog.INTERNAL.verbose("listener is null");
            return;
        }
        WeakReference<AppLovinAdapter> weakReference2 = this.mAdapter;
        if (weakReference2 == null || weakReference2.get() == null) {
            IronLog.INTERNAL.verbose("adapter is null");
            return;
        }
        ((AppLovinAdapter) this.mAdapter.get()).mZoneIdToInterstitialAd.put(this.mZoneId, appLovinAd);
        ((AppLovinAdapter) this.mAdapter.get()).mZoneIdToInterstitialAdReadyStatus.put(this.mZoneId, true);
        this.mListener.onInterstitialAdReady();
    }

    public void failedToReceiveAd(int i) {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose("zoneId = " + this.mZoneId + ", errorCode = " + i);
        if (this.mListener == null) {
            IronLog.INTERNAL.verbose("listener is null");
        } else if (this.mAdapter.get() == null) {
            IronLog.INTERNAL.verbose("adapter is null");
        } else {
            IronSourceError ironSourceError = new IronSourceError(i == 204 ? 1158 : i, ((AppLovinAdapter) this.mAdapter.get()).getErrorString(i));
            ((AppLovinAdapter) this.mAdapter.get()).mZoneIdToInterstitialAdReadyStatus.put(this.mZoneId, false);
            this.mListener.onInterstitialAdLoadFailed(ironSourceError);
        }
    }

    public void adDisplayed(AppLovinAd appLovinAd) {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose("zoneId = " + this.mZoneId);
        InterstitialSmashListener interstitialSmashListener = this.mListener;
        if (interstitialSmashListener == null) {
            IronLog.INTERNAL.verbose("listener is null");
            return;
        }
        interstitialSmashListener.onInterstitialAdShowSucceeded();
        this.mListener.onInterstitialAdOpened();
    }

    public void videoPlaybackBegan(AppLovinAd appLovinAd) {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose("zoneId = " + this.mZoneId);
        if (this.mListener == null) {
            IronLog.INTERNAL.verbose("listener is null");
        }
    }

    public void adClicked(AppLovinAd appLovinAd) {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose("zoneId = " + this.mZoneId);
        InterstitialSmashListener interstitialSmashListener = this.mListener;
        if (interstitialSmashListener == null) {
            IronLog.INTERNAL.verbose("listener is null");
        } else {
            interstitialSmashListener.onInterstitialAdClicked();
        }
    }

    public void videoPlaybackEnded(AppLovinAd appLovinAd, double d, boolean z) {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose("zoneId = " + this.mZoneId);
    }

    public void adHidden(AppLovinAd appLovinAd) {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose("zoneId = " + this.mZoneId);
        InterstitialSmashListener interstitialSmashListener = this.mListener;
        if (interstitialSmashListener == null) {
            IronLog.INTERNAL.verbose("listener is null");
        } else {
            interstitialSmashListener.onInterstitialAdClosed();
        }
    }
}
