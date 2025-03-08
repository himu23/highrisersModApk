package com.ironsource.mediationsdk;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.ironsource.g8;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.ads.nativead.AdapterNativeAdData;
import com.ironsource.mediationsdk.ads.nativead.interfaces.NativeAdSmashListener;
import com.ironsource.mediationsdk.adunit.adapter.AdapterDebugInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterAPSDataInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBaseInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterConsentInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterMetaDataInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterSettingsInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.nativead.AdapterNativeAdViewBinder;
import com.ironsource.mediationsdk.adunit.adapter.listener.NetworkInitializationListener;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdData;
import com.ironsource.mediationsdk.bidding.BiddingDataCallback;
import com.ironsource.mediationsdk.config.ConfigFile;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.sdk.BannerSmashListener;
import com.ironsource.mediationsdk.sdk.InterstitialSmashListener;
import com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener;
import com.ironsource.z1;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class u implements AdapterAPSDataInterface, AdapterBaseInterface, AdapterConsentInterface, AdapterDebugInterface, AdapterMetaDataInterface, AdapterSettingsInterface, BannerSmashListener, z1, InterstitialSmashListener, NativeAdSmashListener, RewardedVideoSmashListener {
    private final AbstractAdapter a;
    private NetworkInitializationListener b;

    public u(AbstractAdapter abstractAdapter) {
        this.a = abstractAdapter;
    }

    public Map<String, Object> a(AdData adData) {
        JSONObject a2 = g8.a(adData.getConfiguration());
        JSONObject a3 = g8.a(adData.getAdUnitData());
        IronSource.AD_UNIT ad_unit = (IronSource.AD_UNIT) adData.getAdUnitData().get("adUnit");
        if (ad_unit == IronSource.AD_UNIT.REWARDED_VIDEO) {
            return this.a.getRewardedVideoBiddingData(a2, a3);
        }
        if (ad_unit == IronSource.AD_UNIT.INTERSTITIAL) {
            return this.a.getInterstitialBiddingData(a2, a3);
        }
        if (ad_unit == IronSource.AD_UNIT.BANNER) {
            return this.a.getBannerBiddingData(a2, a3);
        }
        if (ad_unit == IronSource.AD_UNIT.NATIVE_AD) {
            return this.a.getNativeAdBiddingData(a2, a3);
        }
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.error("ad unit not supported - " + ad_unit);
        return null;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        String pluginType = ConfigFile.getConfigFile().getPluginType();
        if (!TextUtils.isEmpty(pluginType)) {
            this.a.setPluginData(pluginType);
        }
    }

    public void a(AdData adData, BiddingDataCallback biddingDataCallback) {
        JSONObject a2 = g8.a(adData.getConfiguration());
        JSONObject a3 = g8.a(adData.getAdUnitData());
        IronSource.AD_UNIT ad_unit = (IronSource.AD_UNIT) adData.getAdUnitData().get("adUnit");
        if (ad_unit == IronSource.AD_UNIT.REWARDED_VIDEO) {
            this.a.collectRewardedVideoBiddingData(a2, a3, biddingDataCallback);
        } else if (ad_unit == IronSource.AD_UNIT.INTERSTITIAL) {
            this.a.collectInterstitialBiddingData(a2, a3, biddingDataCallback);
        } else if (ad_unit == IronSource.AD_UNIT.BANNER) {
            this.a.collectBannerBiddingData(a2, a3, biddingDataCallback);
        } else if (ad_unit == IronSource.AD_UNIT.NATIVE_AD) {
            this.a.collectNativeAdBiddingData(a2, a3, biddingDataCallback);
        } else {
            IronLog ironLog = IronLog.INTERNAL;
            ironLog.error("ad unit not supported - " + ad_unit);
        }
    }

    public String getAdapterVersion() {
        return this.a.getVersion();
    }

    public LoadWhileShowSupportState getBannerLoadWhileShowSupportedState(NetworkSettings networkSettings) {
        return this.a.getBannerLoadWhileShowSupportState(networkSettings.getBannerSettings());
    }

    public LoadWhileShowSupportState getLoadWhileShowSupportedState(NetworkSettings networkSettings) {
        return this.a.getLoadWhileShowSupportState(networkSettings.getRewardedVideoSettings());
    }

    public String getNetworkSDKVersion() {
        return this.a.getCoreSDKVersion();
    }

    public void init(AdData adData, Context context, NetworkInitializationListener networkInitializationListener) {
        this.b = networkInitializationListener;
        String str = (String) adData.getAdUnitData().get("userId");
        IronSource.AD_UNIT ad_unit = (IronSource.AD_UNIT) adData.getAdUnitData().get("adUnit");
        a();
        JSONObject a2 = g8.a(adData.getConfiguration());
        if (ad_unit == IronSource.AD_UNIT.REWARDED_VIDEO) {
            this.a.initRewardedVideoWithCallback("", str, a2, this);
        } else if (ad_unit == IronSource.AD_UNIT.INTERSTITIAL) {
            Integer num = adData.getInt("instanceType");
            if (num == null || num.intValue() != 1) {
                this.a.initInterstitialForBidding("", str, a2, this);
            } else {
                this.a.initInterstitial("", str, a2, this);
            }
        } else if (ad_unit == IronSource.AD_UNIT.BANNER) {
            Integer num2 = adData.getInt("instanceType");
            if (num2 == null || num2.intValue() != 1) {
                this.a.initBannerForBidding("", str, a2, this);
            } else {
                this.a.initBanners("", str, a2, this);
            }
        } else if (ad_unit == IronSource.AD_UNIT.NATIVE_AD) {
            Integer num3 = adData.getInt("instanceType");
            if (num3 == null || num3.intValue() != 1) {
                this.a.initNativeAdForBidding("", str, a2, this);
            } else {
                this.a.initNativeAds("", str, a2, this);
            }
        } else {
            IronLog ironLog = IronLog.INTERNAL;
            ironLog.error("ad unit not supported - " + ad_unit);
        }
    }

    public boolean isUsingActivityBeforeImpression(IronSource.AD_UNIT ad_unit) {
        return this.a.isUsingActivityBeforeImpression(ad_unit);
    }

    public void onBannerAdClicked() {
    }

    public void onBannerAdLeftApplication() {
    }

    public void onBannerAdLoadFailed(IronSourceError ironSourceError) {
    }

    public void onBannerAdLoaded(View view, FrameLayout.LayoutParams layoutParams) {
    }

    public void onBannerAdScreenDismissed() {
    }

    public void onBannerAdScreenPresented() {
    }

    public void onBannerAdShown() {
    }

    public void onBannerInitFailed(IronSourceError ironSourceError) {
        IronLog.ADAPTER_CALLBACK.verbose();
        NetworkInitializationListener networkInitializationListener = this.b;
        if (networkInitializationListener != null) {
            networkInitializationListener.onInitFailed(ironSourceError.getErrorCode(), ironSourceError.getErrorMessage());
        }
    }

    public void onBannerInitSuccess() {
        IronLog.ADAPTER_CALLBACK.verbose();
        NetworkInitializationListener networkInitializationListener = this.b;
        if (networkInitializationListener != null) {
            networkInitializationListener.onInitSuccess();
        }
    }

    public void onInterstitialAdClicked() {
    }

    public void onInterstitialAdClosed() {
    }

    public void onInterstitialAdLoadFailed(IronSourceError ironSourceError) {
    }

    public void onInterstitialAdOpened() {
    }

    public void onInterstitialAdReady() {
    }

    public void onInterstitialAdShowFailed(IronSourceError ironSourceError) {
    }

    public void onInterstitialAdShowSucceeded() {
    }

    public void onInterstitialAdVisible() {
    }

    public void onInterstitialInitFailed(IronSourceError ironSourceError) {
        IronLog.ADAPTER_CALLBACK.verbose();
        NetworkInitializationListener networkInitializationListener = this.b;
        if (networkInitializationListener != null) {
            networkInitializationListener.onInitFailed(ironSourceError.getErrorCode(), ironSourceError.getErrorMessage());
        }
    }

    public void onInterstitialInitSuccess() {
        IronLog.ADAPTER_CALLBACK.verbose();
        NetworkInitializationListener networkInitializationListener = this.b;
        if (networkInitializationListener != null) {
            networkInitializationListener.onInitSuccess();
        }
    }

    public void onNativeAdClicked() {
    }

    public void onNativeAdInitFailed(IronSourceError ironSourceError) {
        IronLog.ADAPTER_CALLBACK.verbose();
        NetworkInitializationListener networkInitializationListener = this.b;
        if (networkInitializationListener != null) {
            networkInitializationListener.onInitFailed(ironSourceError.getErrorCode(), ironSourceError.getErrorMessage());
        }
    }

    public void onNativeAdInitSuccess() {
        IronLog.ADAPTER_CALLBACK.verbose();
        NetworkInitializationListener networkInitializationListener = this.b;
        if (networkInitializationListener != null) {
            networkInitializationListener.onInitSuccess();
        }
    }

    public void onNativeAdLoadFailed(IronSourceError ironSourceError) {
    }

    public void onNativeAdLoaded(AdapterNativeAdData adapterNativeAdData, AdapterNativeAdViewBinder adapterNativeAdViewBinder) {
    }

    public void onNativeAdShown() {
    }

    public void onRewardedVideoAdClicked() {
    }

    public void onRewardedVideoAdClosed() {
    }

    public void onRewardedVideoAdEnded() {
    }

    public void onRewardedVideoAdOpened() {
    }

    public void onRewardedVideoAdRewarded() {
    }

    public void onRewardedVideoAdShowFailed(IronSourceError ironSourceError) {
    }

    public void onRewardedVideoAdStarted() {
    }

    public void onRewardedVideoAdVisible() {
    }

    public void onRewardedVideoAvailabilityChanged(boolean z) {
    }

    public void onRewardedVideoInitFailed(IronSourceError ironSourceError) {
        IronLog.ADAPTER_CALLBACK.verbose();
        NetworkInitializationListener networkInitializationListener = this.b;
        if (networkInitializationListener != null) {
            networkInitializationListener.onInitFailed(ironSourceError.getErrorCode(), ironSourceError.getErrorMessage());
        }
    }

    public void onRewardedVideoInitSuccess() {
        IronLog.ADAPTER_CALLBACK.verbose();
        NetworkInitializationListener networkInitializationListener = this.b;
        if (networkInitializationListener != null) {
            networkInitializationListener.onInitSuccess();
        }
    }

    public void onRewardedVideoLoadFailed(IronSourceError ironSourceError) {
    }

    public void onRewardedVideoLoadSuccess() {
    }

    public void setAPSData(IronSource.AD_UNIT ad_unit, JSONObject jSONObject) {
        AbstractAdapter abstractAdapter = this.a;
        if (abstractAdapter instanceof SetAPSInterface) {
            ((SetAPSInterface) abstractAdapter).setAPSData(ad_unit, jSONObject);
        }
    }

    public void setAdapterDebug(boolean z) {
        this.a.setAdapterDebug(Boolean.valueOf(z));
    }

    public void setConsent(boolean z) {
        this.a.setConsent(z);
    }

    public void setMetaData(String str, List<String> list) {
        this.a.setMetaData(str, list);
    }
}
