package com.kumobius.android.features;

import android.os.Handler;
import android.util.Log;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.integration.IntegrationHelper;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.Placement;
import com.ironsource.mediationsdk.sdk.InterstitialListener;
import com.ironsource.mediationsdk.sdk.RewardedVideoListener;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.kumobius.android.KumoAppActivity;
import com.kumobius.android.NativeInterface;
import java.util.Objects;

public class AdsFeatures implements IAdsFeature {
    private static final String s_TAG = "KumoAds";
    private final KumoAppActivity m_Activity;
    /* access modifiers changed from: private */
    public final Object m_AdsLock = new Object();
    private final Handler m_Handler = new Handler();
    private boolean m_IncentivisedAdsEnabled = false;
    private boolean m_IncentivisedPlaying = false;
    /* access modifiers changed from: private */
    public boolean m_IncentivisedReady = false;
    private boolean m_IronSourceEnabled = false;
    private boolean m_VideoAdsEnabled = false;
    /* access modifiers changed from: private */
    public int m_VideoMode = 0;
    private boolean m_VideoPlaying = false;

    public String adsGetSystemName() {
        return IronSourceConstants.IRONSOURCE_CONFIG_NAME;
    }

    public boolean adsOnBackPressed() {
        return false;
    }

    public void adsOnDestroy() {
    }

    public void adsOnStart() {
    }

    public void adsOnStop() {
    }

    public AdsFeatures(KumoAppActivity kumoAppActivity) {
        this.m_Activity = kumoAppActivity;
    }

    public void adsInit() {
        updateIronSource();
    }

    public void adsOnPause() {
        synchronized (this.m_AdsLock) {
            if (this.m_IronSourceEnabled) {
                try {
                    IronSource.onPause(this.m_Activity);
                } catch (Exception e) {
                    Log.e(s_TAG, "IronSource error: ", e);
                }
            }
        }
    }

    public void adsOnResume() {
        synchronized (this.m_AdsLock) {
            if (this.m_IronSourceEnabled) {
                try {
                    IronSource.onResume(this.m_Activity);
                } catch (Exception e) {
                    Log.e(s_TAG, "IronSource error: ", e);
                }
            }
        }
    }

    public void adsShowDebugUi() {
        this.m_Activity.runOnUiThread(new AdsFeatures$$ExternalSyntheticLambda4(this));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$adsShowDebugUi$0$com-kumobius-android-features-AdsFeatures  reason: not valid java name */
    public /* synthetic */ void m37lambda$adsShowDebugUi$0$comkumobiusandroidfeaturesAdsFeatures() {
        try {
            IntegrationHelper.validateIntegration(this.m_Activity);
        } catch (Exception e) {
            Log.e(s_TAG, "IronSource error: ", e);
        }
    }

    public boolean adsGetVideoAdsEnabled() {
        boolean z;
        synchronized (this.m_AdsLock) {
            z = this.m_VideoAdsEnabled;
        }
        return z;
    }

    public void adsSetVideoAdsEnabled(boolean z) {
        synchronized (this.m_AdsLock) {
            this.m_VideoAdsEnabled = z;
        }
        this.m_Activity.runOnUiThread(new AdsFeatures$$ExternalSyntheticLambda2(this));
    }

    public boolean adsGetVideoAdPlaying() {
        boolean z;
        synchronized (this.m_AdsLock) {
            z = this.m_VideoPlaying;
        }
        return z;
    }

    public boolean adsGetVideoAdReady() {
        boolean z;
        synchronized (this.m_AdsLock) {
            z = this.m_VideoMode == 2;
        }
        return z;
    }

    public void adsRequestVideoAd() {
        synchronized (this.m_AdsLock) {
            if (!this.m_VideoAdsEnabled) {
                Log.w(s_TAG, "Cannot request video ad if video ads not enabled");
            } else if (this.m_VideoPlaying) {
                Log.w(s_TAG, "Video already playing.");
            } else {
                this.m_VideoPlaying = true;
                this.m_Activity.runOnUiThread(new AdsFeatures$$ExternalSyntheticLambda6(this));
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$adsRequestVideoAd$1$com-kumobius-android-features-AdsFeatures  reason: not valid java name */
    public /* synthetic */ void m36lambda$adsRequestVideoAd$1$comkumobiusandroidfeaturesAdsFeatures() {
        try {
            synchronized (this.m_AdsLock) {
                if (this.m_IronSourceEnabled) {
                    if (IronSource.isInterstitialReady()) {
                        IronSource.showInterstitial();
                        return;
                    }
                }
                this.m_VideoPlaying = false;
            }
        } catch (Exception e) {
            Log.e(s_TAG, "Failed to show video", e);
            synchronized (this.m_AdsLock) {
                this.m_VideoPlaying = false;
            }
        }
    }

    public boolean adsGetIncentivisedAdsEnabled() {
        boolean z;
        synchronized (this.m_AdsLock) {
            z = this.m_IncentivisedAdsEnabled;
        }
        return z;
    }

    public void adsSetIncentivisedAdsEnabled(boolean z) {
        synchronized (this.m_AdsLock) {
            this.m_IncentivisedAdsEnabled = z;
        }
        this.m_Activity.runOnUiThread(new AdsFeatures$$ExternalSyntheticLambda2(this));
    }

    public boolean adsGetIncentivisedAdReady() {
        boolean z;
        synchronized (this.m_AdsLock) {
            z = this.m_IncentivisedReady;
        }
        return z;
    }

    public boolean adsGetIncentivisedAdPlaying() {
        boolean z;
        synchronized (this.m_AdsLock) {
            z = this.m_IncentivisedPlaying;
        }
        return z;
    }

    public void adsRequestIncentivisedAd() {
        synchronized (this.m_AdsLock) {
            if (!this.m_IncentivisedAdsEnabled) {
                Log.w(s_TAG, "Cannot request incentivised ad if incentivised ads not enabled");
            } else if (this.m_IncentivisedPlaying) {
                Log.w(s_TAG, "Video already playing.");
            } else {
                this.m_IncentivisedPlaying = true;
                this.m_Activity.runOnUiThread(new AdsFeatures$$ExternalSyntheticLambda1(this));
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$adsRequestIncentivisedAd$2$com-kumobius-android-features-AdsFeatures  reason: not valid java name */
    public /* synthetic */ void m35lambda$adsRequestIncentivisedAd$2$comkumobiusandroidfeaturesAdsFeatures() {
        try {
            synchronized (this.m_AdsLock) {
                if (this.m_IronSourceEnabled) {
                    if (IronSource.isRewardedVideoAvailable()) {
                        IronSource.showRewardedVideo();
                        return;
                    }
                }
                this.m_IncentivisedPlaying = false;
            }
        } catch (Exception e) {
            Log.e(s_TAG, "Failed to show rewarded video", e);
            synchronized (this.m_AdsLock) {
                this.m_IncentivisedPlaying = false;
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0059, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void updateIronSource() {
        /*
            r4 = this;
            java.lang.Object r0 = r4.m_AdsLock
            monitor-enter(r0)
            int r1 = com.kumobius.android.features.ads.R.string.supersonicAppId     // Catch:{ all -> 0x005a }
            java.lang.String r1 = r4.getString(r1)     // Catch:{ all -> 0x005a }
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ all -> 0x005a }
            if (r2 == 0) goto L_0x0011
            monitor-exit(r0)     // Catch:{ all -> 0x005a }
            return
        L_0x0011:
            boolean r2 = r4.m_VideoAdsEnabled     // Catch:{ all -> 0x005a }
            if (r2 != 0) goto L_0x0019
            boolean r2 = r4.m_IncentivisedAdsEnabled     // Catch:{ all -> 0x005a }
            if (r2 == 0) goto L_0x0058
        L_0x0019:
            boolean r2 = r4.m_IronSourceEnabled     // Catch:{ all -> 0x005a }
            if (r2 != 0) goto L_0x004b
            java.lang.String r2 = "KumoAds"
            java.lang.String r3 = "Starting IronSource with Mediation"
            android.util.Log.v(r2, r3)     // Catch:{ Exception -> 0x0043 }
            com.kumobius.android.features.AdsFeatures$MyInterstitialListener r2 = new com.kumobius.android.features.AdsFeatures$MyInterstitialListener     // Catch:{ Exception -> 0x0043 }
            r3 = 0
            r2.<init>()     // Catch:{ Exception -> 0x0043 }
            com.ironsource.mediationsdk.IronSource.setInterstitialListener(r2)     // Catch:{ Exception -> 0x0043 }
            com.kumobius.android.features.AdsFeatures$MyRewardedVideoListener r2 = new com.kumobius.android.features.AdsFeatures$MyRewardedVideoListener     // Catch:{ Exception -> 0x0043 }
            r2.<init>()     // Catch:{ Exception -> 0x0043 }
            com.ironsource.mediationsdk.IronSource.setRewardedVideoListener(r2)     // Catch:{ Exception -> 0x0043 }
            com.kumobius.android.KumoAppActivity r2 = r4.m_Activity     // Catch:{ Exception -> 0x0043 }
            r3 = 1
            com.ironsource.mediationsdk.IronSource.shouldTrackNetworkState(r2, r3)     // Catch:{ Exception -> 0x0043 }
            com.kumobius.android.KumoAppActivity r2 = r4.m_Activity     // Catch:{ Exception -> 0x0043 }
            com.ironsource.mediationsdk.IronSource.init(r2, r1)     // Catch:{ Exception -> 0x0043 }
            r4.m_IronSourceEnabled = r3     // Catch:{ Exception -> 0x0043 }
            goto L_0x004b
        L_0x0043:
            r1 = move-exception
            java.lang.String r2 = "KumoAds"
            java.lang.String r3 = "Failed to start IronSource Video Ads"
            android.util.Log.e(r2, r3, r1)     // Catch:{ all -> 0x005a }
        L_0x004b:
            boolean r1 = r4.m_VideoAdsEnabled     // Catch:{ all -> 0x005a }
            if (r1 == 0) goto L_0x0058
            boolean r1 = r4.m_IronSourceEnabled     // Catch:{ all -> 0x005a }
            if (r1 == 0) goto L_0x0058
            r1 = 10000(0x2710, float:1.4013E-41)
            r4.loadVideoAd(r1)     // Catch:{ all -> 0x005a }
        L_0x0058:
            monitor-exit(r0)     // Catch:{ all -> 0x005a }
            return
        L_0x005a:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x005a }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kumobius.android.features.AdsFeatures.updateIronSource():void");
    }

    /* access modifiers changed from: private */
    public void loadVideoAd(int i) {
        synchronized (this.m_AdsLock) {
            if (this.m_VideoMode == 0) {
                this.m_VideoMode = 1;
                this.m_Handler.postDelayed(new AdsFeatures$$ExternalSyntheticLambda3(), (long) i);
            }
        }
    }

    static /* synthetic */ void lambda$loadVideoAd$3() {
        Log.v(s_TAG, "Loading interstitial.");
        IronSource.loadInterstitial();
    }

    /* access modifiers changed from: private */
    public void onVideoAdComplete() {
        synchronized (this.m_AdsLock) {
            this.m_VideoPlaying = false;
        }
    }

    /* access modifiers changed from: private */
    public void onIncentivisedAdComplete() {
        synchronized (this.m_AdsLock) {
            this.m_IncentivisedPlaying = false;
        }
    }

    /* access modifiers changed from: private */
    public void onReward() {
        NativeInterface.pushAdReward(this.m_Activity, 1);
    }

    private String getString(int i) {
        return this.m_Activity.getResources().getString(i);
    }

    /* access modifiers changed from: private */
    public void addPause() {
        KumoAppActivity kumoAppActivity = this.m_Activity;
        Objects.requireNonNull(kumoAppActivity);
        kumoAppActivity.runOnUiThread(new AdsFeatures$$ExternalSyntheticLambda0(kumoAppActivity));
    }

    /* access modifiers changed from: private */
    public void removePause() {
        KumoAppActivity kumoAppActivity = this.m_Activity;
        Objects.requireNonNull(kumoAppActivity);
        kumoAppActivity.runOnUiThread(new AdsFeatures$$ExternalSyntheticLambda5(kumoAppActivity));
    }

    private class MyRewardedVideoListener implements RewardedVideoListener {
        private MyRewardedVideoListener() {
        }

        public void onRewardedVideoAdClosed() {
            Log.v(AdsFeatures.s_TAG, "onRewardedVideoAdClosed");
            AdsFeatures.this.onIncentivisedAdComplete();
            AdsFeatures.this.removePause();
        }

        public void onRewardedVideoAdOpened() {
            Log.v(AdsFeatures.s_TAG, "onRewardedVideoAdOpened");
            AdsFeatures.this.addPause();
        }

        public void onRewardedVideoAdClicked(Placement placement) {
            Log.v(AdsFeatures.s_TAG, "onRewardedVideoAdClicked");
        }

        public void onRewardedVideoAdRewarded(Placement placement) {
            Log.v(AdsFeatures.s_TAG, "onRewardedVideoAdRewarded");
            AdsFeatures.this.onReward();
        }

        public void onRewardedVideoAdShowFailed(IronSourceError ironSourceError) {
            Log.v(AdsFeatures.s_TAG, "onRewardedVideoAdShowFailed");
            AdsFeatures.this.onIncentivisedAdComplete();
        }

        public void onRewardedVideoAvailabilityChanged(boolean z) {
            Log.v(AdsFeatures.s_TAG, "onRewardedVideoAvailabilityChanged: " + z);
            synchronized (AdsFeatures.this.m_AdsLock) {
                boolean unused = AdsFeatures.this.m_IncentivisedReady = z;
            }
        }

        public void onRewardedVideoAdStarted() {
            Log.v(AdsFeatures.s_TAG, "onRewardedVideoAdStarted");
        }

        public void onRewardedVideoAdEnded() {
            Log.v(AdsFeatures.s_TAG, "onRewardedVideoAdEnded");
        }
    }

    private class MyInterstitialListener implements InterstitialListener {
        private MyInterstitialListener() {
        }

        public void onInterstitialAdReady() {
            Log.v(AdsFeatures.s_TAG, "onInterstitialAdReady");
            synchronized (AdsFeatures.this.m_AdsLock) {
                int unused = AdsFeatures.this.m_VideoMode = 2;
            }
        }

        public void onInterstitialAdLoadFailed(IronSourceError ironSourceError) {
            Log.v(AdsFeatures.s_TAG, "onInterstitialAdLoadFailed: " + ironSourceError.getErrorMessage());
            synchronized (AdsFeatures.this.m_AdsLock) {
                int unused = AdsFeatures.this.m_VideoMode = 0;
            }
            AdsFeatures.this.loadVideoAd(10000);
        }

        public void onInterstitialAdOpened() {
            Log.v(AdsFeatures.s_TAG, "onInterstitialAdOpened");
            AdsFeatures.this.addPause();
        }

        public void onInterstitialAdClosed() {
            Log.v(AdsFeatures.s_TAG, "onInterstitialAdClosed");
            synchronized (AdsFeatures.this.m_AdsLock) {
                int unused = AdsFeatures.this.m_VideoMode = 0;
                AdsFeatures.this.onVideoAdComplete();
            }
            AdsFeatures.this.removePause();
            AdsFeatures.this.loadVideoAd(10000);
        }

        public void onInterstitialAdShowSucceeded() {
            Log.v(AdsFeatures.s_TAG, "onInterstitialAdShowSucceeded");
        }

        public void onInterstitialAdShowFailed(IronSourceError ironSourceError) {
            Log.v(AdsFeatures.s_TAG, "onInterstitialAdShowFailed: " + ironSourceError.getErrorMessage());
            synchronized (AdsFeatures.this.m_AdsLock) {
                int unused = AdsFeatures.this.m_VideoMode = 0;
                AdsFeatures.this.onVideoAdComplete();
            }
            AdsFeatures.this.loadVideoAd(10000);
        }

        public void onInterstitialAdClicked() {
            Log.v(AdsFeatures.s_TAG, "onInterstitialAdClicked");
        }
    }
}
