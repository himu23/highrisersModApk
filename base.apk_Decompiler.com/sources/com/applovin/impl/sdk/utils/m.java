package com.applovin.impl.sdk.utils;

import com.applovin.adview.AppLovinAdView;
import com.applovin.adview.AppLovinAdViewDisplayErrorCode;
import com.applovin.adview.AppLovinAdViewEventListener;
import com.applovin.impl.sdk.AppLovinError;
import com.applovin.impl.sdk.ad.AppLovinAdImpl;
import com.applovin.impl.sdk.ad.h;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.nativeAd.AppLovinNativeAd;
import com.applovin.impl.sdk.nativeAd.AppLovinNativeAdEventListener;
import com.applovin.impl.sdk.nativeAd.AppLovinNativeAdLoadListener;
import com.applovin.impl.sdk.x;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdExpirationListener;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxAdRequestListener;
import com.applovin.mediation.MaxAdRevenueListener;
import com.applovin.mediation.MaxAdReviewListener;
import com.applovin.mediation.MaxAdViewAdListener;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.MaxReward;
import com.applovin.mediation.MaxRewardedAdListener;
import com.applovin.mediation.nativeAds.MaxNativeAdListener;
import com.applovin.mediation.nativeAds.MaxNativeAdView;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdRewardListener;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinPostbackListener;
import com.applovin.sdk.AppLovinSdkUtils;
import com.ironsource.ac;
import java.util.Map;

public class m {
    private static boolean aVO = true;
    private static boolean aVP = true;

    public static void bj(boolean z) {
        aVO = z;
    }

    public static void bk(boolean z) {
        aVP = z;
    }

    private static boolean bl(boolean z) {
        return z ? aVO : aVP;
    }

    public static void a(AppLovinAdDisplayListener appLovinAdDisplayListener, String str) {
        if (appLovinAdDisplayListener instanceof h) {
            AppLovinSdkUtils.runOnUiThread(new m$$ExternalSyntheticLambda21(appLovinAdDisplayListener, str));
        }
    }

    public static void a(AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAd appLovinAd) {
        if (appLovinAd != null && appLovinAdDisplayListener != null) {
            AppLovinSdkUtils.runOnUiThread(new m$$ExternalSyntheticLambda11(appLovinAdDisplayListener, appLovinAd));
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void d(AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAd appLovinAd) {
        try {
            appLovinAdDisplayListener.adDisplayed(g(appLovinAd));
        } catch (Throwable th) {
            x.e("ListenerCallbackInvoker", "Unable to notify ad event listener about ad being displayed", th);
            g("adDisplayed", th);
        }
    }

    public static void b(AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAd appLovinAd) {
        if (appLovinAd != null && appLovinAdDisplayListener != null) {
            AppLovinSdkUtils.runOnUiThread(new m$$ExternalSyntheticLambda35(appLovinAdDisplayListener, appLovinAd));
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void c(AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAd appLovinAd) {
        try {
            appLovinAdDisplayListener.adHidden(g(appLovinAd));
        } catch (Throwable th) {
            x.e("ListenerCallbackInvoker", "Unable to notify ad event listener about ad being hidden", th);
            g("adHidden", th);
        }
    }

    public static void a(AppLovinAdClickListener appLovinAdClickListener, AppLovinAd appLovinAd) {
        if (appLovinAd != null && appLovinAdClickListener != null) {
            AppLovinSdkUtils.runOnUiThread(new m$$ExternalSyntheticLambda12(appLovinAdClickListener, appLovinAd));
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void b(AppLovinAdClickListener appLovinAdClickListener, AppLovinAd appLovinAd) {
        try {
            appLovinAdClickListener.adClicked(g(appLovinAd));
        } catch (Throwable th) {
            x.e("ListenerCallbackInvoker", "Unable to notify ad event listener about ad being clicked", th);
            g("adClicked", th);
        }
    }

    public static void a(AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAd appLovinAd) {
        if (appLovinAd != null && appLovinAdVideoPlaybackListener != null) {
            AppLovinSdkUtils.runOnUiThread(new m$$ExternalSyntheticLambda3(appLovinAdVideoPlaybackListener, appLovinAd));
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void b(AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAd appLovinAd) {
        try {
            appLovinAdVideoPlaybackListener.videoPlaybackBegan(g(appLovinAd));
        } catch (Throwable th) {
            x.e("ListenerCallbackInvoker", "Unable to notify ad event listener about ad playback began", th);
        }
    }

    public static void a(AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAd appLovinAd, double d, boolean z) {
        if (appLovinAd != null && appLovinAdVideoPlaybackListener != null) {
            AppLovinSdkUtils.runOnUiThread(new m$$ExternalSyntheticLambda4(appLovinAdVideoPlaybackListener, appLovinAd, d, z));
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void b(AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAd appLovinAd, double d, boolean z) {
        try {
            appLovinAdVideoPlaybackListener.videoPlaybackEnded(g(appLovinAd), d, z);
        } catch (Throwable th) {
            x.e("ListenerCallbackInvoker", "Unable to notify ad event listener about ad playback ended", th);
        }
    }

    public static void a(AppLovinAdViewEventListener appLovinAdViewEventListener, AppLovinAd appLovinAd, AppLovinAdView appLovinAdView) {
        if (appLovinAd != null && appLovinAdViewEventListener != null) {
            AppLovinSdkUtils.runOnUiThread(new m$$ExternalSyntheticLambda16(appLovinAdViewEventListener, appLovinAd, appLovinAdView));
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void f(AppLovinAdViewEventListener appLovinAdViewEventListener, AppLovinAd appLovinAd, AppLovinAdView appLovinAdView) {
        try {
            appLovinAdViewEventListener.adOpenedFullscreen(g(appLovinAd), appLovinAdView);
        } catch (Throwable th) {
            x.e("ListenerCallbackInvoker", "Unable to notify ad event listener about fullscreen opened event", th);
        }
    }

    public static void b(AppLovinAdViewEventListener appLovinAdViewEventListener, AppLovinAd appLovinAd, AppLovinAdView appLovinAdView) {
        if (appLovinAd != null && appLovinAdViewEventListener != null) {
            AppLovinSdkUtils.runOnUiThread(new m$$ExternalSyntheticLambda26(appLovinAdViewEventListener, appLovinAd, appLovinAdView));
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void e(AppLovinAdViewEventListener appLovinAdViewEventListener, AppLovinAd appLovinAd, AppLovinAdView appLovinAdView) {
        try {
            appLovinAdViewEventListener.adClosedFullscreen(g(appLovinAd), appLovinAdView);
        } catch (Throwable th) {
            x.e("ListenerCallbackInvoker", "Unable to notify ad event listener about fullscreen closed event", th);
        }
    }

    public static void c(AppLovinAdViewEventListener appLovinAdViewEventListener, AppLovinAd appLovinAd, AppLovinAdView appLovinAdView) {
        if (appLovinAd != null && appLovinAdViewEventListener != null) {
            AppLovinSdkUtils.runOnUiThread(new m$$ExternalSyntheticLambda34(appLovinAdViewEventListener, appLovinAd, appLovinAdView));
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void d(AppLovinAdViewEventListener appLovinAdViewEventListener, AppLovinAd appLovinAd, AppLovinAdView appLovinAdView) {
        try {
            appLovinAdViewEventListener.adLeftApplication(g(appLovinAd), appLovinAdView);
        } catch (Throwable th) {
            x.e("ListenerCallbackInvoker", "Unable to notify ad event listener about application leave event", th);
        }
    }

    public static void a(AppLovinAdViewEventListener appLovinAdViewEventListener, AppLovinAd appLovinAd, AppLovinAdView appLovinAdView, AppLovinAdViewDisplayErrorCode appLovinAdViewDisplayErrorCode) {
        if (appLovinAd != null && appLovinAdViewEventListener != null) {
            AppLovinSdkUtils.runOnUiThread(new m$$ExternalSyntheticLambda32(appLovinAdViewEventListener, appLovinAd, appLovinAdView, appLovinAdViewDisplayErrorCode));
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void b(AppLovinAdViewEventListener appLovinAdViewEventListener, AppLovinAd appLovinAd, AppLovinAdView appLovinAdView, AppLovinAdViewDisplayErrorCode appLovinAdViewDisplayErrorCode) {
        try {
            appLovinAdViewEventListener.adFailedToDisplay(g(appLovinAd), appLovinAdView, appLovinAdViewDisplayErrorCode);
        } catch (Throwable th) {
            x.e("ListenerCallbackInvoker", "Unable to notify ad event listener about display failed event", th);
        }
    }

    public static void a(AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAd appLovinAd, Map<String, String> map) {
        if (appLovinAd != null && appLovinAdRewardListener != null) {
            AppLovinSdkUtils.runOnUiThread(new m$$ExternalSyntheticLambda14(appLovinAdRewardListener, appLovinAd, map));
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void f(AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAd appLovinAd, Map map) {
        try {
            appLovinAdRewardListener.userRewardVerified(g(appLovinAd), map);
        } catch (Throwable th) {
            x.e("ListenerCallbackInvoker", "Unable to notify ad reward listener about successful reward validation request", th);
        }
    }

    public static void b(AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAd appLovinAd, Map<String, String> map) {
        if (appLovinAd != null && appLovinAdRewardListener != null) {
            AppLovinSdkUtils.runOnUiThread(new m$$ExternalSyntheticLambda8(appLovinAdRewardListener, appLovinAd, map));
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void e(AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAd appLovinAd, Map map) {
        try {
            appLovinAdRewardListener.userOverQuota(g(appLovinAd), map);
        } catch (Throwable th) {
            x.e("ListenerCallbackInvoker", "Unable to notify ad reward listener about exceeding quota", th);
        }
    }

    public static void c(AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAd appLovinAd, Map<String, String> map) {
        if (appLovinAd != null && appLovinAdRewardListener != null) {
            AppLovinSdkUtils.runOnUiThread(new m$$ExternalSyntheticLambda23(appLovinAdRewardListener, appLovinAd, map));
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void d(AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAd appLovinAd, Map map) {
        try {
            appLovinAdRewardListener.userRewardRejected(g(appLovinAd), map);
        } catch (Throwable th) {
            x.e("ListenerCallbackInvoker", "Unable to notify ad reward listener about reward validation request being rejected", th);
        }
    }

    public static void a(AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAd appLovinAd, int i) {
        if (appLovinAd != null && appLovinAdRewardListener != null) {
            AppLovinSdkUtils.runOnUiThread(new m$$ExternalSyntheticLambda19(appLovinAdRewardListener, appLovinAd, i));
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void b(AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAd appLovinAd, int i) {
        try {
            appLovinAdRewardListener.validationRequestFailed(g(appLovinAd), i);
        } catch (Throwable th) {
            x.e("ListenerCallbackInvoker", "Unable to notify ad reward listener about reward validation request failing", th);
        }
    }

    public static void a(MaxAdListener maxAdListener, MaxAd maxAd) {
        a(maxAdListener, maxAd, false, false);
    }

    public static void a(MaxAdListener maxAdListener, MaxAd maxAd, boolean z, boolean z2) {
        if (maxAd != null && maxAdListener != null) {
            AppLovinSdkUtils.runOnUiThread(z2, new m$$ExternalSyntheticLambda1(z, maxAdListener, maxAd));
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void h(boolean z, MaxAdListener maxAdListener, MaxAd maxAd) {
        if (bl(z)) {
            try {
                maxAdListener.onAdLoaded(maxAd);
            } catch (Throwable th) {
                a(ac.j, th, z);
                g("maxAdLoaded", th);
            }
        } else {
            maxAdListener.onAdLoaded(maxAd);
        }
    }

    public static void a(MaxAdListener maxAdListener, String str, MaxError maxError) {
        a(maxAdListener, str, maxError, false);
    }

    public static void a(MaxAdListener maxAdListener, String str, MaxError maxError, boolean z) {
        a(maxAdListener, str, maxError, z, false);
    }

    public static void a(MaxAdListener maxAdListener, String str, MaxError maxError, boolean z, boolean z2) {
        if (str != null && maxAdListener != null) {
            AppLovinSdkUtils.runOnUiThread(z2, new m$$ExternalSyntheticLambda29(z, maxAdListener, str, maxError));
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(boolean z, MaxAdListener maxAdListener, String str, MaxError maxError) {
        if (bl(z)) {
            try {
                maxAdListener.onAdLoadFailed(str, maxError);
            } catch (Throwable th) {
                a(ac.b, th, z);
                g("maxAdLoadFailed", th);
            }
        } else {
            maxAdListener.onAdLoadFailed(str, maxError);
        }
    }

    public static void b(MaxAdListener maxAdListener, MaxAd maxAd) {
        b(maxAdListener, maxAd, false, false);
    }

    public static void b(MaxAdListener maxAdListener, MaxAd maxAd, boolean z, boolean z2) {
        if (maxAd != null && maxAdListener != null) {
            AppLovinSdkUtils.runOnUiThread(z2, new m$$ExternalSyntheticLambda7(z, maxAdListener, maxAd));
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void g(boolean z, MaxAdListener maxAdListener, MaxAd maxAd) {
        if (bl(z)) {
            try {
                maxAdListener.onAdDisplayed(maxAd);
            } catch (Throwable th) {
                a("onAdDisplayed", th, z);
                g("maxAdDisplayed", th);
            }
        } else {
            maxAdListener.onAdDisplayed(maxAd);
        }
    }

    public static void c(MaxAdListener maxAdListener, MaxAd maxAd) {
        c(maxAdListener, maxAd, false, false);
    }

    public static void c(MaxAdListener maxAdListener, MaxAd maxAd, boolean z, boolean z2) {
        if (maxAd != null && maxAdListener != null) {
            AppLovinSdkUtils.runOnUiThread(z2, new m$$ExternalSyntheticLambda27(z, maxAdListener, maxAd));
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void f(boolean z, MaxAdListener maxAdListener, MaxAd maxAd) {
        if (bl(z)) {
            try {
                maxAdListener.onAdHidden(maxAd);
            } catch (Throwable th) {
                a("onAdHidden", th, z);
                g("maxAdHidden", th);
            }
        } else {
            maxAdListener.onAdHidden(maxAd);
        }
    }

    public static void d(MaxAdListener maxAdListener, MaxAd maxAd) {
        d(maxAdListener, maxAd, false, false);
    }

    public static void d(MaxAdListener maxAdListener, MaxAd maxAd, boolean z, boolean z2) {
        if (maxAd != null && maxAdListener != null) {
            AppLovinSdkUtils.runOnUiThread(z2, new m$$ExternalSyntheticLambda22(z, maxAdListener, maxAd));
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void e(boolean z, MaxAdListener maxAdListener, MaxAd maxAd) {
        if (bl(z)) {
            try {
                maxAdListener.onAdClicked(maxAd);
            } catch (Throwable th) {
                a(ac.f, th, z);
                g("maxAdClicked", th);
            }
        } else {
            maxAdListener.onAdClicked(maxAd);
        }
    }

    public static void a(MaxAdListener maxAdListener, MaxAd maxAd, MaxError maxError) {
        a(maxAdListener, maxAd, maxError, false);
    }

    public static void a(MaxAdListener maxAdListener, MaxAd maxAd, MaxError maxError, boolean z) {
        a(maxAdListener, maxAd, maxError, z, false);
    }

    public static void a(MaxAdListener maxAdListener, MaxAd maxAd, MaxError maxError, boolean z, boolean z2) {
        if (maxAd != null && maxAdListener != null) {
            AppLovinSdkUtils.runOnUiThread(z2, new m$$ExternalSyntheticLambda33(z, maxAdListener, maxAd, maxError));
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(boolean z, MaxAdListener maxAdListener, MaxAd maxAd, MaxError maxError) {
        if (bl(z)) {
            try {
                maxAdListener.onAdDisplayFailed(maxAd, maxError);
            } catch (Throwable th) {
                a("onAdDisplayFailed", th, z);
                g("maxAdDisplayFailed", th);
            }
        } else {
            maxAdListener.onAdDisplayFailed(maxAd, maxError);
        }
    }

    public static void a(MaxAdRevenueListener maxAdRevenueListener, MaxAd maxAd) {
        a(maxAdRevenueListener, maxAd, false);
    }

    public static void a(MaxAdRevenueListener maxAdRevenueListener, MaxAd maxAd, boolean z) {
        a(maxAdRevenueListener, maxAd, z, false);
    }

    public static void a(MaxAdRevenueListener maxAdRevenueListener, MaxAd maxAd, boolean z, boolean z2) {
        if (maxAd != null && maxAdRevenueListener != null) {
            AppLovinSdkUtils.runOnUiThread(z2, new m$$ExternalSyntheticLambda9(z, maxAdRevenueListener, maxAd));
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(boolean z, MaxAdRevenueListener maxAdRevenueListener, MaxAd maxAd) {
        if (bl(z)) {
            try {
                maxAdRevenueListener.onAdRevenuePaid(maxAd);
            } catch (Throwable th) {
                a("onAdRevenuePaid", th, z);
                g("maxAdPaidRevenue", th);
            }
        } else {
            maxAdRevenueListener.onAdRevenuePaid(maxAd);
        }
    }

    public static void a(MaxAdRequestListener maxAdRequestListener, String str) {
        a(maxAdRequestListener, str, false, false);
    }

    public static void a(MaxAdRequestListener maxAdRequestListener, String str, boolean z, boolean z2) {
        if (str != null && maxAdRequestListener != null) {
            AppLovinSdkUtils.runOnUiThread(z2, new m$$ExternalSyntheticLambda6(z, maxAdRequestListener, str));
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(boolean z, MaxAdRequestListener maxAdRequestListener, String str) {
        if (bl(z)) {
            try {
                maxAdRequestListener.onAdRequestStarted(str);
            } catch (Throwable th) {
                a("onAdRequestStarted", th, z);
                g("maxAdRequestStarted", th);
            }
        } else {
            maxAdRequestListener.onAdRequestStarted(str);
        }
    }

    public static void a(MaxAdExpirationListener maxAdExpirationListener, MaxAd maxAd, MaxAd maxAd2, boolean z, boolean z2) {
        if (maxAd != null && maxAd2 != null && maxAdExpirationListener != null) {
            AppLovinSdkUtils.runOnUiThread(z2, new m$$ExternalSyntheticLambda5(z, maxAdExpirationListener, maxAd, maxAd2));
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(boolean z, MaxAdExpirationListener maxAdExpirationListener, MaxAd maxAd, MaxAd maxAd2) {
        if (bl(z)) {
            try {
                maxAdExpirationListener.onExpiredAdReloaded(maxAd, maxAd2);
            } catch (Throwable th) {
                a("onExpiredAdReloaded", th, z);
                g("maxExpiredAdReloaded", th);
            }
        } else {
            maxAdExpirationListener.onExpiredAdReloaded(maxAd, maxAd2);
        }
    }

    public static void e(MaxAdListener maxAdListener, MaxAd maxAd) {
        e(maxAdListener, maxAd, false, false);
    }

    public static void e(MaxAdListener maxAdListener, MaxAd maxAd, boolean z, boolean z2) {
        if (maxAd != null && (maxAdListener instanceof MaxRewardedAdListener)) {
            AppLovinSdkUtils.runOnUiThread(z2, new m$$ExternalSyntheticLambda31(z, maxAdListener, maxAd));
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void d(boolean z, MaxAdListener maxAdListener, MaxAd maxAd) {
        if (bl(z)) {
            try {
                ((MaxRewardedAdListener) maxAdListener).onRewardedVideoStarted(maxAd);
            } catch (Throwable th) {
                a("onRewardedVideoStarted", th, z);
            }
        } else {
            ((MaxRewardedAdListener) maxAdListener).onRewardedVideoStarted(maxAd);
        }
    }

    public static void f(MaxAdListener maxAdListener, MaxAd maxAd) {
        f(maxAdListener, maxAd, false, false);
    }

    public static void f(MaxAdListener maxAdListener, MaxAd maxAd, boolean z, boolean z2) {
        if (maxAd != null && (maxAdListener instanceof MaxRewardedAdListener)) {
            AppLovinSdkUtils.runOnUiThread(z2, new m$$ExternalSyntheticLambda28(z, maxAdListener, maxAd));
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void c(boolean z, MaxAdListener maxAdListener, MaxAd maxAd) {
        if (bl(z)) {
            try {
                ((MaxRewardedAdListener) maxAdListener).onRewardedVideoCompleted(maxAd);
            } catch (Throwable th) {
                a("onRewardedVideoCompleted", th, z);
            }
        } else {
            ((MaxRewardedAdListener) maxAdListener).onRewardedVideoCompleted(maxAd);
        }
    }

    public static void a(MaxAdListener maxAdListener, MaxAd maxAd, MaxReward maxReward) {
        a(maxAdListener, maxAd, maxReward, false, false);
    }

    public static void a(MaxAdListener maxAdListener, MaxAd maxAd, MaxReward maxReward, boolean z, boolean z2) {
        if (maxAd != null && (maxAdListener instanceof MaxRewardedAdListener)) {
            AppLovinSdkUtils.runOnUiThread(z2, new m$$ExternalSyntheticLambda15(z, maxAdListener, maxAd, maxReward));
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(boolean z, MaxAdListener maxAdListener, MaxAd maxAd, MaxReward maxReward) {
        if (bl(z)) {
            try {
                ((MaxRewardedAdListener) maxAdListener).onUserRewarded(maxAd, maxReward);
            } catch (Throwable th) {
                a("onUserRewarded", th, z);
                g("maxRewardedUser", th);
            }
        } else {
            ((MaxRewardedAdListener) maxAdListener).onUserRewarded(maxAd, maxReward);
        }
    }

    public static void g(MaxAdListener maxAdListener, MaxAd maxAd) {
        g(maxAdListener, maxAd, false, false);
    }

    public static void g(MaxAdListener maxAdListener, MaxAd maxAd, boolean z, boolean z2) {
        if (maxAd != null && (maxAdListener instanceof MaxAdViewAdListener)) {
            AppLovinSdkUtils.runOnUiThread(z2, new m$$ExternalSyntheticLambda36(z, maxAdListener, maxAd));
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void b(boolean z, MaxAdListener maxAdListener, MaxAd maxAd) {
        if (bl(z)) {
            try {
                ((MaxAdViewAdListener) maxAdListener).onAdExpanded(maxAd);
            } catch (Throwable th) {
                a("onAdExpanded", th, z);
            }
        } else {
            ((MaxAdViewAdListener) maxAdListener).onAdExpanded(maxAd);
        }
    }

    public static void h(MaxAdListener maxAdListener, MaxAd maxAd) {
        h(maxAdListener, maxAd, false, false);
    }

    public static void h(MaxAdListener maxAdListener, MaxAd maxAd, boolean z, boolean z2) {
        if (maxAd != null && (maxAdListener instanceof MaxAdViewAdListener)) {
            AppLovinSdkUtils.runOnUiThread(z2, new m$$ExternalSyntheticLambda18(z, maxAdListener, maxAd));
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(boolean z, MaxAdListener maxAdListener, MaxAd maxAd) {
        if (bl(z)) {
            try {
                ((MaxAdViewAdListener) maxAdListener).onAdCollapsed(maxAd);
            } catch (Throwable th) {
                a("onAdCollapsed", th, z);
            }
        } else {
            ((MaxAdViewAdListener) maxAdListener).onAdCollapsed(maxAd);
        }
    }

    public static void a(MaxNativeAdListener maxNativeAdListener, MaxNativeAdView maxNativeAdView, MaxAd maxAd, boolean z, boolean z2) {
        if (maxAd != null && maxNativeAdListener != null) {
            AppLovinSdkUtils.runOnUiThread(z2, new m$$ExternalSyntheticLambda2(z, maxNativeAdListener, maxNativeAdView, maxAd));
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(boolean z, MaxNativeAdListener maxNativeAdListener, MaxNativeAdView maxNativeAdView, MaxAd maxAd) {
        if (bl(z)) {
            try {
                maxNativeAdListener.onNativeAdLoaded(maxNativeAdView, maxAd);
            } catch (Throwable th) {
                a("onNativeAdLoaded", th, z);
                g("maxNativeAdLoaded", th);
            }
        } else {
            maxNativeAdListener.onNativeAdLoaded(maxNativeAdView, maxAd);
        }
    }

    public static void a(MaxNativeAdListener maxNativeAdListener, String str, MaxError maxError, boolean z, boolean z2) {
        if (str != null && maxNativeAdListener != null) {
            AppLovinSdkUtils.runOnUiThread(z2, new m$$ExternalSyntheticLambda30(z, maxNativeAdListener, str, maxError));
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(boolean z, MaxNativeAdListener maxNativeAdListener, String str, MaxError maxError) {
        if (bl(z)) {
            try {
                maxNativeAdListener.onNativeAdLoadFailed(str, maxError);
            } catch (Throwable th) {
                a("onNativeAdLoadFailed", th, z);
                g("maxNativeAdLoadFailed", th);
            }
        } else {
            maxNativeAdListener.onNativeAdLoadFailed(str, maxError);
        }
    }

    public static void a(MaxNativeAdListener maxNativeAdListener, MaxAd maxAd, boolean z, boolean z2) {
        if (maxAd != null && maxNativeAdListener != null) {
            AppLovinSdkUtils.runOnUiThread(z2, new m$$ExternalSyntheticLambda20(z, maxNativeAdListener, maxAd));
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void b(boolean z, MaxNativeAdListener maxNativeAdListener, MaxAd maxAd) {
        if (bl(z)) {
            try {
                maxNativeAdListener.onNativeAdClicked(maxAd);
            } catch (Throwable th) {
                a("onNativeAdClicked", th, z);
                g("maxNativeAdClicked", th);
            }
        } else {
            maxNativeAdListener.onNativeAdClicked(maxAd);
        }
    }

    public static void b(MaxNativeAdListener maxNativeAdListener, MaxAd maxAd, boolean z, boolean z2) {
        if (maxAd != null && maxNativeAdListener != null) {
            AppLovinSdkUtils.runOnUiThread(z2, new m$$ExternalSyntheticLambda0(z, maxNativeAdListener, maxAd));
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(boolean z, MaxNativeAdListener maxNativeAdListener, MaxAd maxAd) {
        if (bl(z)) {
            try {
                maxNativeAdListener.onNativeAdExpired(maxAd);
            } catch (Throwable th) {
                a("onNativeAdExpired", th, z);
                g("maxNativeAdExpired", th);
            }
        } else {
            maxNativeAdListener.onNativeAdExpired(maxAd);
        }
    }

    public static void a(AppLovinPostbackListener appLovinPostbackListener, String str) {
        if (appLovinPostbackListener != null) {
            AppLovinSdkUtils.runOnUiThread(new m$$ExternalSyntheticLambda24(appLovinPostbackListener, str));
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void b(AppLovinPostbackListener appLovinPostbackListener, String str) {
        try {
            appLovinPostbackListener.onPostbackSuccess(str);
        } catch (Throwable th) {
            x.e("ListenerCallbackInvoker", "Unable to notify AppLovinPostbackListener about postback URL (" + str + ") executed", th);
        }
    }

    public static void a(AppLovinPostbackListener appLovinPostbackListener, String str, int i) {
        if (appLovinPostbackListener != null) {
            AppLovinSdkUtils.runOnUiThread(new m$$ExternalSyntheticLambda10(appLovinPostbackListener, str, i));
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void b(AppLovinPostbackListener appLovinPostbackListener, String str, int i) {
        try {
            appLovinPostbackListener.onPostbackFailure(str, i);
        } catch (Throwable th) {
            x.e("ListenerCallbackInvoker", "Unable to notify AppLovinPostbackListener about postback URL (" + str + ") failing to execute with error code (" + i + "):", th);
        }
    }

    public static void a(AppLovinNativeAdLoadListener appLovinNativeAdLoadListener, AppLovinError appLovinError) {
        if (appLovinNativeAdLoadListener != null) {
            AppLovinSdkUtils.runOnUiThread(new m$$ExternalSyntheticLambda25(appLovinNativeAdLoadListener, appLovinError));
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void b(AppLovinNativeAdLoadListener appLovinNativeAdLoadListener, AppLovinError appLovinError) {
        try {
            appLovinNativeAdLoadListener.onNativeAdLoadFailed(appLovinError);
        } catch (Throwable th) {
            x.e("ListenerCallbackInvoker", "Unable to notify native ad event listener about ad failing to load", th);
            g("nativeAdLoadFailed", th);
        }
    }

    public static void a(AppLovinNativeAdEventListener appLovinNativeAdEventListener, AppLovinNativeAd appLovinNativeAd) {
        if (appLovinNativeAdEventListener != null) {
            AppLovinSdkUtils.runOnUiThread(new m$$ExternalSyntheticLambda13(appLovinNativeAdEventListener, appLovinNativeAd));
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void b(AppLovinNativeAdEventListener appLovinNativeAdEventListener, AppLovinNativeAd appLovinNativeAd) {
        try {
            appLovinNativeAdEventListener.onNativeAdClicked(appLovinNativeAd);
        } catch (Throwable th) {
            x.e("ListenerCallbackInvoker", "Unable to notify native ad event listener about ad click", th);
            g("nativeAdClicked", th);
        }
    }

    public static void a(MaxAdReviewListener maxAdReviewListener, String str, MaxAd maxAd) {
        a(maxAdReviewListener, str, maxAd, false);
    }

    public static void a(MaxAdReviewListener maxAdReviewListener, String str, MaxAd maxAd, boolean z) {
        if (maxAdReviewListener != null) {
            AppLovinSdkUtils.runOnUiThread(z, new m$$ExternalSyntheticLambda17(maxAdReviewListener, str, maxAd));
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void b(MaxAdReviewListener maxAdReviewListener, String str, MaxAd maxAd) {
        try {
            maxAdReviewListener.onCreativeIdGenerated(str, maxAd);
        } catch (Throwable th) {
            x.e("ListenerCallbackInvoker", "Unable to notify Ad Review creative id generated", th);
            g("adReviewCreativeIdGenerated", th);
        }
    }

    private static AppLovinAd g(AppLovinAd appLovinAd) {
        AppLovinAdImpl appLovinAdImpl = (AppLovinAdImpl) appLovinAd;
        return appLovinAdImpl.getDummyAd() != null ? appLovinAdImpl.getDummyAd() : appLovinAd;
    }

    private static void a(String str, Throwable th, boolean z) {
        if (z) {
            h(str, th);
        } else {
            i(str, th);
        }
    }

    private static void h(String str, Throwable th) {
        x.e("ListenerCallbackInvoker", "Error in publisher callback '" + str + "'", th);
    }

    private static void i(String str, Throwable th) {
        x.f("ListenerCallbackInvoker", "Error in internal callback '" + str + "'", th);
    }

    private static void g(String str, Throwable th) {
        if (n.aAC != null) {
            n.aAC.Cs().d("ListenerCallbackInvoker", str, th);
        }
    }
}
