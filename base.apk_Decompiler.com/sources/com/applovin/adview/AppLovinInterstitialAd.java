package com.applovin.adview;

import android.content.Context;
import com.applovin.impl.adview.q;
import com.applovin.sdk.AppLovinSdk;

public class AppLovinInterstitialAd {
    public String toString() {
        return "AppLovinInterstitialAd{}";
    }

    public static AppLovinInterstitialAdDialog create(AppLovinSdk appLovinSdk, Context context) {
        if (appLovinSdk == null) {
            throw new IllegalArgumentException("No sdk specified");
        } else if (context != null) {
            return new q(appLovinSdk, context);
        } else {
            throw new IllegalArgumentException("No context specified");
        }
    }
}
