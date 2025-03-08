package com.ironsource.mediationsdk;

import android.app.Activity;
import android.content.Context;
import com.ironsource.mediationsdk.demandOnly.ISDemandOnlyBannerLayout;
import com.ironsource.mediationsdk.demandOnly.ISDemandOnlyInterstitialListener;
import com.ironsource.mediationsdk.demandOnly.ISDemandOnlyRewardedVideoListener;
import com.ironsource.mediationsdk.impressionData.ImpressionDataListener;
import com.ironsource.mediationsdk.logger.LogListener;
import com.ironsource.mediationsdk.model.InterstitialPlacement;
import com.ironsource.mediationsdk.model.Placement;
import com.ironsource.mediationsdk.sdk.InitializationListener;
import com.ironsource.mediationsdk.sdk.InterstitialListener;
import com.ironsource.mediationsdk.sdk.LevelPlayInterstitialListener;
import com.ironsource.mediationsdk.sdk.LevelPlayRewardedVideoListener;
import com.ironsource.mediationsdk.sdk.LevelPlayRewardedVideoManualListener;
import com.ironsource.mediationsdk.sdk.OfferwallListener;
import com.ironsource.mediationsdk.sdk.RewardedVideoListener;
import com.ironsource.mediationsdk.sdk.RewardedVideoManualListener;
import com.ironsource.mediationsdk.sdk.SegmentListener;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public abstract class IronSource {

    public enum AD_UNIT {
        REWARDED_VIDEO("rewardedVideo"),
        INTERSTITIAL(IronSourceConstants.AD_UNIT_IS_MEDIATION_STATE),
        OFFERWALL("offerwall"),
        BANNER("banner"),
        NATIVE_AD("nativeAd");
        
        private String a;

        private AD_UNIT(String str) {
            this.a = str;
        }

        public String toString() {
            return this.a;
        }
    }

    public static void addImpressionDataListener(ImpressionDataListener impressionDataListener) {
        p.o().b(impressionDataListener);
    }

    public static void clearRewardedVideoServerParameters() {
        p.o().b();
    }

    public static IronSourceBannerLayout createBanner(Activity activity, ISBannerSize iSBannerSize) {
        return p.o().b(activity, iSBannerSize);
    }

    public static ISDemandOnlyBannerLayout createBannerForDemandOnly(Activity activity, ISBannerSize iSBannerSize) {
        return p.o().a(activity, iSBannerSize);
    }

    public static void destroyBanner(IronSourceBannerLayout ironSourceBannerLayout) {
        p.o().a(ironSourceBannerLayout);
    }

    public static void destroyISDemandOnlyBanner(String str) {
        p.o().c(str);
    }

    public static String getAdvertiserId(Context context) {
        return p.o().b(context);
    }

    public static synchronized String getISDemandOnlyBiddingData(Context context) {
        String a;
        synchronized (IronSource.class) {
            a = p.o().a(context);
        }
        return a;
    }

    public static InterstitialPlacement getInterstitialPlacementInfo(String str) {
        return p.o().g(str);
    }

    @Deprecated
    public static void getOfferwallCredits() {
        p.o().getOfferwallCredits();
    }

    public static Placement getRewardedVideoPlacementInfo(String str) {
        return p.o().i(str);
    }

    public static void init(Context context, String str) {
        init(context, str, (AD_UNIT[]) null);
    }

    public static void init(Context context, String str, InitializationListener initializationListener) {
        init(context, str, initializationListener, (AD_UNIT[]) null);
    }

    public static void init(Context context, String str, InitializationListener initializationListener, AD_UNIT... ad_unitArr) {
        p.o().a(context, str, false, initializationListener, ad_unitArr);
    }

    public static void init(Context context, String str, AD_UNIT... ad_unitArr) {
        p.o().a(context, str, false, (InitializationListener) null, ad_unitArr);
    }

    public static void initISDemandOnly(Context context, String str, AD_UNIT... ad_unitArr) {
        p.o().a(context, str, ad_unitArr);
    }

    public static boolean isBannerPlacementCapped(String str) {
        return p.o().s(str);
    }

    public static boolean isISDemandOnlyInterstitialReady(String str) {
        return p.o().f(str);
    }

    public static boolean isISDemandOnlyRewardedVideoAvailable(String str) {
        return p.o().k(str);
    }

    public static boolean isInterstitialPlacementCapped(String str) {
        return p.o().t(str);
    }

    public static boolean isInterstitialReady() {
        return p.o().D();
    }

    @Deprecated
    public static boolean isOfferwallAvailable() {
        return p.o().isOfferwallAvailable();
    }

    public static boolean isRewardedVideoAvailable() {
        return p.o().J();
    }

    public static boolean isRewardedVideoPlacementCapped(String str) {
        return p.o().u(str);
    }

    public static void launchTestSuite(Context context) {
        p.o().d(context);
    }

    public static void loadBanner(IronSourceBannerLayout ironSourceBannerLayout) {
        p.o().b(ironSourceBannerLayout);
    }

    public static void loadBanner(IronSourceBannerLayout ironSourceBannerLayout, String str) {
        p.o().a(ironSourceBannerLayout, str);
    }

    public static void loadISDemandOnlyBanner(Activity activity, ISDemandOnlyBannerLayout iSDemandOnlyBannerLayout, String str) {
        p.o().a(activity, iSDemandOnlyBannerLayout, str);
    }

    public static void loadISDemandOnlyBannerWithAdm(Activity activity, ISDemandOnlyBannerLayout iSDemandOnlyBannerLayout, String str, String str2) {
        p.o().a(activity, iSDemandOnlyBannerLayout, str, str2);
    }

    public static void loadISDemandOnlyInterstitial(Activity activity, String str) {
        p.o().a(activity, str);
    }

    public static void loadISDemandOnlyInterstitialWithAdm(Activity activity, String str, String str2) {
        p.o().b(activity, str, str2);
    }

    public static void loadISDemandOnlyRewardedVideo(Activity activity, String str) {
        p.o().b(activity, str);
    }

    public static void loadISDemandOnlyRewardedVideoWithAdm(Activity activity, String str, String str2) {
        p.o().a(activity, str, str2);
    }

    public static void loadInterstitial() {
        p.o().N();
    }

    public static void loadRewardedVideo() {
        p.o().O();
    }

    public static void onPause(Activity activity) {
        p.o().a(activity);
    }

    public static void onResume(Activity activity) {
        p.o().b(activity);
    }

    public static void removeImpressionDataListener(ImpressionDataListener impressionDataListener) {
        p.o().a(impressionDataListener);
    }

    public static void removeInterstitialListener() {
        p.o().f();
    }

    @Deprecated
    public static void removeOfferwallListener() {
        p.o().e();
    }

    public static void removeRewardedVideoListener() {
        p.o().d();
    }

    public static void setAdRevenueData(String str, JSONObject jSONObject) {
        p.o().a(str, jSONObject);
    }

    public static void setAdaptersDebug(boolean z) {
        p.o().a(z);
    }

    public static void setConsent(boolean z) {
        p.o().b(z);
    }

    public static boolean setDynamicUserId(String str) {
        return p.o().e(str);
    }

    public static void setISDemandOnlyInterstitialListener(ISDemandOnlyInterstitialListener iSDemandOnlyInterstitialListener) {
        p.o().a(iSDemandOnlyInterstitialListener);
    }

    public static void setISDemandOnlyRewardedVideoListener(ISDemandOnlyRewardedVideoListener iSDemandOnlyRewardedVideoListener) {
        p.o().a(iSDemandOnlyRewardedVideoListener);
    }

    @Deprecated
    public static void setInterstitialListener(InterstitialListener interstitialListener) {
        p.o().a(interstitialListener);
    }

    public static void setLevelPlayInterstitialListener(LevelPlayInterstitialListener levelPlayInterstitialListener) {
        p.o().a(levelPlayInterstitialListener);
    }

    public static void setLevelPlayRewardedVideoListener(LevelPlayRewardedVideoListener levelPlayRewardedVideoListener) {
        p.o().a(levelPlayRewardedVideoListener);
    }

    public static void setLevelPlayRewardedVideoManualListener(LevelPlayRewardedVideoManualListener levelPlayRewardedVideoManualListener) {
        p.o().a(levelPlayRewardedVideoManualListener);
    }

    public static void setLogListener(LogListener logListener) {
        p.o().a(logListener);
    }

    public static void setManualLoadRewardedVideo(RewardedVideoManualListener rewardedVideoManualListener) {
        p.o().a(rewardedVideoManualListener);
    }

    public static void setMediationType(String str) {
        p.o().h(str);
    }

    public static void setMetaData(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str2);
        p.o().a(str, (List<String>) arrayList);
    }

    public static void setMetaData(String str, List<String> list) {
        p.o().a(str, list);
    }

    public static void setNetworkData(String str, JSONObject jSONObject) {
        p.o().b(str, jSONObject);
    }

    @Deprecated
    public static void setOfferwallListener(OfferwallListener offerwallListener) {
        p.o().a(offerwallListener);
    }

    @Deprecated
    public static void setRewardedVideoListener(RewardedVideoListener rewardedVideoListener) {
        p.o().a(rewardedVideoListener);
    }

    public static void setRewardedVideoServerParameters(Map<String, String> map) {
        p.o().a(map);
    }

    public static void setSegment(IronSourceSegment ironSourceSegment) {
        p.o().a(ironSourceSegment);
    }

    public static void setSegmentListener(SegmentListener segmentListener) {
        p.o().a(segmentListener);
    }

    public static void setUserId(String str) {
        p.o().v(str);
    }

    public static void setWaterfallConfiguration(WaterfallConfiguration waterfallConfiguration, AD_UNIT ad_unit) {
        p.o().a(ad_unit, waterfallConfiguration);
    }

    public static void shouldTrackNetworkState(Context context, boolean z) {
        p.o().a(context, z);
    }

    public static void showISDemandOnlyInterstitial(String str) {
        p.o().b(str);
    }

    public static void showISDemandOnlyRewardedVideo(String str) {
        p.o().a(str);
    }

    public static void showInterstitial() {
        p.o().c((Activity) null);
    }

    public static void showInterstitial(Activity activity) {
        p.o().c(activity);
    }

    public static void showInterstitial(Activity activity, String str) {
        p.o().c(activity, str);
    }

    public static void showInterstitial(String str) {
        p.o().c((Activity) null, str);
    }

    @Deprecated
    public static void showOfferwall() {
        p.o().c();
    }

    @Deprecated
    public static void showOfferwall(String str) {
        p.o().j(str);
    }

    public static void showRewardedVideo() {
        p.o().d((Activity) null);
    }

    public static void showRewardedVideo(Activity activity) {
        p.o().d(activity);
    }

    public static void showRewardedVideo(Activity activity, String str) {
        p.o().f(activity, str);
    }

    public static void showRewardedVideo(String str) {
        p.o().f((Activity) null, str);
    }
}
