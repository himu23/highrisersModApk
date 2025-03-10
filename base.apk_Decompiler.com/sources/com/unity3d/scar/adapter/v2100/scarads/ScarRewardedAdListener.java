package com.unity3d.scar.adapter.v2100.scarads;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;
import com.unity3d.scar.adapter.common.IScarRewardedAdListenerWrapper;

public class ScarRewardedAdListener extends ScarAdListener {
    /* access modifiers changed from: private */
    public final IScarRewardedAdListenerWrapper _adListenerWrapper;
    private final RewardedAdLoadCallback _adLoadCallback = new RewardedAdLoadCallback() {
        public void onAdLoaded(RewardedAd rewardedAd) {
            ScarRewardedAdListener.super.onAdLoaded(rewardedAd);
            ScarRewardedAdListener.this._adListenerWrapper.onAdLoaded();
            rewardedAd.setFullScreenContentCallback(ScarRewardedAdListener.this._fullScreenContentCallback);
            ScarRewardedAdListener.this._scarRewardedAd.setGmaAd(rewardedAd);
            if (ScarRewardedAdListener.this._loadListener != null) {
                ScarRewardedAdListener.this._loadListener.onAdLoaded();
            }
        }

        public void onAdFailedToLoad(LoadAdError loadAdError) {
            ScarRewardedAdListener.super.onAdFailedToLoad(loadAdError);
            ScarRewardedAdListener.this._adListenerWrapper.onAdFailedToLoad(loadAdError.getCode(), loadAdError.toString());
        }
    };
    /* access modifiers changed from: private */
    public final FullScreenContentCallback _fullScreenContentCallback = new FullScreenContentCallback() {
        public void onAdFailedToShowFullScreenContent(AdError adError) {
            ScarRewardedAdListener.super.onAdFailedToShowFullScreenContent(adError);
            ScarRewardedAdListener.this._adListenerWrapper.onAdFailedToShow(adError.getCode(), adError.toString());
        }

        public void onAdShowedFullScreenContent() {
            ScarRewardedAdListener.super.onAdShowedFullScreenContent();
            ScarRewardedAdListener.this._adListenerWrapper.onAdOpened();
        }

        public void onAdDismissedFullScreenContent() {
            ScarRewardedAdListener.super.onAdDismissedFullScreenContent();
            ScarRewardedAdListener.this._adListenerWrapper.onAdClosed();
        }

        public void onAdImpression() {
            ScarRewardedAdListener.super.onAdImpression();
            ScarRewardedAdListener.this._adListenerWrapper.onAdImpression();
        }

        public void onAdClicked() {
            ScarRewardedAdListener.super.onAdClicked();
            ScarRewardedAdListener.this._adListenerWrapper.onAdClicked();
        }
    };
    private final OnUserEarnedRewardListener _onUserEarnedRewardListener = new OnUserEarnedRewardListener() {
        public void onUserEarnedReward(RewardItem rewardItem) {
            ScarRewardedAdListener.this._adListenerWrapper.onUserEarnedReward();
        }
    };
    /* access modifiers changed from: private */
    public final ScarRewardedAd _scarRewardedAd;

    public RewardedAdLoadCallback getAdLoadListener() {
        return this._adLoadCallback;
    }

    public OnUserEarnedRewardListener getOnUserEarnedRewardListener() {
        return this._onUserEarnedRewardListener;
    }

    public ScarRewardedAdListener(IScarRewardedAdListenerWrapper iScarRewardedAdListenerWrapper, ScarRewardedAd scarRewardedAd) {
        this._adListenerWrapper = iScarRewardedAdListenerWrapper;
        this._scarRewardedAd = scarRewardedAd;
    }
}
