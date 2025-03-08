package com.ironsource.adapters.applovin;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdRewardListener;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener;
import java.lang.ref.WeakReference;
import java.util.Map;

public class AppLovinRewardedVideoListener implements AppLovinAdLoadListener, AppLovinAdClickListener, AppLovinAdDisplayListener, AppLovinAdVideoPlaybackListener, AppLovinAdRewardListener {
    private final WeakReference<AppLovinAdapter> mAdapter;
    private final RewardedVideoSmashListener mListener;
    private final String mZoneId;

    public AppLovinRewardedVideoListener(AppLovinAdapter appLovinAdapter, RewardedVideoSmashListener rewardedVideoSmashListener, String str) {
        this.mAdapter = new WeakReference<>(appLovinAdapter);
        this.mZoneId = str;
        this.mListener = rewardedVideoSmashListener;
    }

    public void adReceived(AppLovinAd appLovinAd) {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose("zoneId = " + this.mZoneId);
        RewardedVideoSmashListener rewardedVideoSmashListener = this.mListener;
        if (rewardedVideoSmashListener == null) {
            IronLog.INTERNAL.verbose("listener is null");
        } else {
            rewardedVideoSmashListener.onRewardedVideoAvailabilityChanged(true);
        }
    }

    public void failedToReceiveAd(int i) {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose("zoneId = " + this.mZoneId + ", errorCode = " + i);
        if (this.mListener == null) {
            IronLog.INTERNAL.verbose("listener is null");
            return;
        }
        WeakReference<AppLovinAdapter> weakReference = this.mAdapter;
        if (weakReference == null || weakReference.get() == null) {
            IronLog.INTERNAL.verbose("adapter is null");
            return;
        }
        IronSourceError ironSourceError = new IronSourceError(i == 204 ? 1058 : i, ((AppLovinAdapter) this.mAdapter.get()).getErrorString(i));
        this.mListener.onRewardedVideoAvailabilityChanged(false);
        this.mListener.onRewardedVideoLoadFailed(ironSourceError);
    }

    public void adDisplayed(AppLovinAd appLovinAd) {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose("zoneId = " + this.mZoneId);
        RewardedVideoSmashListener rewardedVideoSmashListener = this.mListener;
        if (rewardedVideoSmashListener == null) {
            IronLog.INTERNAL.verbose("listener is null");
        } else {
            rewardedVideoSmashListener.onRewardedVideoAdOpened();
        }
    }

    public void videoPlaybackBegan(AppLovinAd appLovinAd) {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose("zoneId = " + this.mZoneId);
        RewardedVideoSmashListener rewardedVideoSmashListener = this.mListener;
        if (rewardedVideoSmashListener == null) {
            IronLog.INTERNAL.verbose("listener is null");
        } else {
            rewardedVideoSmashListener.onRewardedVideoAdStarted();
        }
    }

    public void adClicked(AppLovinAd appLovinAd) {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose("zoneId = " + this.mZoneId);
        RewardedVideoSmashListener rewardedVideoSmashListener = this.mListener;
        if (rewardedVideoSmashListener == null) {
            IronLog.INTERNAL.verbose("listener is null");
        } else {
            rewardedVideoSmashListener.onRewardedVideoAdClicked();
        }
    }

    public void videoPlaybackEnded(AppLovinAd appLovinAd, double d, boolean z) {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose("zoneId = " + this.mZoneId + ", isFullyWatched = " + z);
        RewardedVideoSmashListener rewardedVideoSmashListener = this.mListener;
        if (rewardedVideoSmashListener == null) {
            IronLog.INTERNAL.verbose("listener is null");
            return;
        }
        rewardedVideoSmashListener.onRewardedVideoAdEnded();
        if (z) {
            this.mListener.onRewardedVideoAdRewarded();
        }
    }

    public void adHidden(AppLovinAd appLovinAd) {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose("zoneId = " + this.mZoneId);
        RewardedVideoSmashListener rewardedVideoSmashListener = this.mListener;
        if (rewardedVideoSmashListener == null) {
            IronLog.INTERNAL.verbose("listener is null");
        } else {
            rewardedVideoSmashListener.onRewardedVideoAdClosed();
        }
    }

    public void userRewardVerified(AppLovinAd appLovinAd, Map<String, String> map) {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose("zoneId = " + this.mZoneId);
    }

    public void userOverQuota(AppLovinAd appLovinAd, Map<String, String> map) {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose("zoneId = " + this.mZoneId);
    }

    public void userRewardRejected(AppLovinAd appLovinAd, Map<String, String> map) {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose("zoneId = " + this.mZoneId);
    }

    public void validationRequestFailed(AppLovinAd appLovinAd, int i) {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose("zoneId = " + this.mZoneId + ", errorCode = " + i);
    }
}
