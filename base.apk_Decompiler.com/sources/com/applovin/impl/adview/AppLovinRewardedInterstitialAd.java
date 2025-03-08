package com.applovin.impl.adview;

import android.content.Context;
import com.applovin.adview.AppLovinIncentivizedInterstitial;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdRewardListener;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinSdk;

public class AppLovinRewardedInterstitialAd {
    private AppLovinAdDisplayListener agA;
    private AppLovinAdClickListener agC;
    private final AppLovinIncentivizedInterstitial agQ;
    private AppLovinAdVideoPlaybackListener agR;

    public void setAdClickListener(AppLovinAdClickListener appLovinAdClickListener) {
        this.agC = appLovinAdClickListener;
    }

    public void setAdDisplayListener(AppLovinAdDisplayListener appLovinAdDisplayListener) {
        this.agA = appLovinAdDisplayListener;
    }

    public void setAdVideoPlaybackListener(AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener) {
        this.agR = appLovinAdVideoPlaybackListener;
    }

    public String toString() {
        return "AppLovinRewardedInterstitialAd{}";
    }

    public AppLovinRewardedInterstitialAd(AppLovinSdk appLovinSdk) {
        this.agQ = new AppLovinIncentivizedInterstitial(appLovinSdk);
    }

    public void show(AppLovinAd appLovinAd, Context context, AppLovinAdRewardListener appLovinAdRewardListener) {
        this.agQ.show(appLovinAd, context, appLovinAdRewardListener, this.agR, this.agA, this.agC);
    }
}
