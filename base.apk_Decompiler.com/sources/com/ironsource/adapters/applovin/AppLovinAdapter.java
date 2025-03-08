package com.ironsource.adapters.applovin;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import com.applovin.adview.AppLovinAdView;
import com.applovin.adview.AppLovinIncentivizedInterstitial;
import com.applovin.adview.AppLovinInterstitialAd;
import com.applovin.adview.AppLovinInterstitialAdDialog;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinErrorCodes;
import com.applovin.sdk.AppLovinPrivacySettings;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkConfiguration;
import com.applovin.sdk.AppLovinSdkSettings;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.AbstractAdapter;
import com.ironsource.mediationsdk.AdapterUtils;
import com.ironsource.mediationsdk.INetworkInitCallbackListener;
import com.ironsource.mediationsdk.ISBannerSize;
import com.ironsource.mediationsdk.IntegrationData;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.IronSourceBannerLayout;
import com.ironsource.mediationsdk.LoadWhileShowSupportState;
import com.ironsource.mediationsdk.l;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.metadata.MetaData;
import com.ironsource.mediationsdk.metadata.MetaDataUtils;
import com.ironsource.mediationsdk.sdk.BannerSmashListener;
import com.ironsource.mediationsdk.sdk.InterstitialSmashListener;
import com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

class AppLovinAdapter extends AbstractAdapter implements INetworkInitCallbackListener {
    private static final String DEFAULT_ZONE_ID = "defaultZoneId";
    private static final String GitHash = "98dc19ddd";
    private static final String META_DATA_APPLOVIN_AGE_RESTRICTION_KEY = "AppLovin_AgeRestrictedUser";
    private static final String SDK_KEY = "sdkKey";
    private static final String VERSION = "4.3.41";
    private static final String ZONE_ID = "zoneId";
    private static final HashSet<INetworkInitCallbackListener> initCallbackListeners = new HashSet<>();
    /* access modifiers changed from: private */
    public static AppLovinSdk mAppLovinSdk;
    private static InitState mInitState = InitState.INIT_STATE_NONE;
    private static final AtomicBoolean mWasInitCalled = new AtomicBoolean(false);
    protected final CopyOnWriteArraySet<String> mRewardedVideoZoneIdsForInitCallbacks = new CopyOnWriteArraySet<>();
    protected final ConcurrentHashMap<String, AppLovinBannerListener> mZoneIdToAppLovinBannerListener = new ConcurrentHashMap<>();
    protected final ConcurrentHashMap<String, AppLovinInterstitialListener> mZoneIdToAppLovinInterstitialListener = new ConcurrentHashMap<>();
    protected final ConcurrentHashMap<String, AppLovinRewardedVideoListener> mZoneIdToAppLovinRewardedVideoListener = new ConcurrentHashMap<>();
    protected final ConcurrentHashMap<String, AppLovinAdView> mZoneIdToBannerAd = new ConcurrentHashMap<>();
    protected final ConcurrentHashMap<String, FrameLayout.LayoutParams> mZoneIdToBannerLayout = new ConcurrentHashMap<>();
    protected final ConcurrentHashMap<String, AppLovinAdSize> mZoneIdToBannerSize = new ConcurrentHashMap<>();
    protected final ConcurrentHashMap<String, BannerSmashListener> mZoneIdToBannerSmashListener = new ConcurrentHashMap<>();
    protected final ConcurrentHashMap<String, AppLovinAd> mZoneIdToInterstitialAd = new ConcurrentHashMap<>();
    protected final ConcurrentHashMap<String, Boolean> mZoneIdToInterstitialAdReadyStatus = new ConcurrentHashMap<>();
    protected final ConcurrentHashMap<String, InterstitialSmashListener> mZoneIdToInterstitialSmashListener = new ConcurrentHashMap<>();
    protected final ConcurrentHashMap<String, AppLovinIncentivizedInterstitial> mZoneIdToRewardedVideoAd = new ConcurrentHashMap<>();
    protected final ConcurrentHashMap<String, RewardedVideoSmashListener> mZoneIdToRewardedVideoSmashListener = new ConcurrentHashMap<>();

    private enum InitState {
        INIT_STATE_NONE,
        INIT_STATE_IN_PROGRESS,
        INIT_STATE_SUCCESS
    }

    /* access modifiers changed from: protected */
    public String getErrorString(int i) {
        if (i == -8) {
            return "The provided ad token is invalid; ad token must be returned from AppLovin S2S integration.";
        }
        if (i == -7) {
            return "The zone provided is invalid; the zone needs to be added to your AppLovin account or may still be propagating to our servers.";
        }
        if (i == -6) {
            return "There has been a failure to render an ad on screen.";
        }
        switch (i) {
            case -1009:
                return "The device had no network connectivity at the time of an ad request, either due to airplane mode or no service.";
            case -1001:
                return "The network conditions prevented the SDK from receiving an ad.";
            case AppLovinErrorCodes.INVALID_URL /*-900*/:
                return "A postback URL you attempted to dispatch was empty or nil.";
            case AppLovinErrorCodes.INVALID_RESPONSE /*-800*/:
                return "The AppLovin servers have returned an invalid response";
            case AppLovinErrorCodes.INCENTIVIZED_USER_CLOSED_VIDEO /*-600*/:
                return "The user exited out of the ad early. You may or may not wish to grant a reward depending on your preference.";
            case AppLovinErrorCodes.INCENTIVIZED_SERVER_TIMEOUT /*-500*/:
                return "A reward validation requested timed out (usually due to poor connectivity).";
            case AppLovinErrorCodes.INCENTIVIZED_UNKNOWN_SERVER_ERROR /*-400*/:
                return "An unknown server-side error occurred.";
            case AppLovinErrorCodes.INCENTIVIZED_NO_AD_PRELOADED /*-300*/:
                return "The developer called for a rewarded video before one was available.";
            case AppLovinErrorCodes.SDK_DISABLED /*-22*/:
                return "The SDK is currently disabled.";
            case -1:
                return "The system is in unexpected state.";
            case 204:
                return "No ads are currently eligible for your device.";
            default:
                switch (i) {
                    case AppLovinErrorCodes.UNABLE_TO_PRECACHE_VIDEO_RESOURCES /*-202*/:
                        return "An attempt to cache a video resource to the filesystem failed; the device may be out of space.";
                    case AppLovinErrorCodes.UNABLE_TO_PRECACHE_IMAGE_RESOURCES /*-201*/:
                        return "An attempt to cache an image resource to the filesystem failed; the device may be out of space.";
                    case AppLovinErrorCodes.UNABLE_TO_PRECACHE_RESOURCES /*-200*/:
                        return "An attempt to cache a resource to the filesystem failed; the device may be out of space.";
                    default:
                        return "Unknown error";
                }
        }
    }

    public String getVersion() {
        return "4.3.41";
    }

    public boolean isUsingActivityBeforeImpression(IronSource.AD_UNIT ad_unit) {
        return false;
    }

    public void onNetworkInitCallbackFailed(String str) {
    }

    public static AppLovinAdapter startAdapter(String str) {
        return new AppLovinAdapter(str);
    }

    private AppLovinAdapter(String str) {
        super(str);
        IronLog.INTERNAL.verbose();
        this.mLWSSupportState = LoadWhileShowSupportState.LOAD_WHILE_SHOW_BY_INSTANCE;
    }

    public static IntegrationData getIntegrationData(Context context) {
        return new IntegrationData("AppLovin", "4.3.41");
    }

    public String getCoreSDKVersion() {
        return getAdapterSDKVersion();
    }

    public static String getAdapterSDKVersion() {
        return AppLovinSdk.VERSION;
    }

    /* access modifiers changed from: private */
    public void initSdk(String str, String str2) {
        if (mInitState == InitState.INIT_STATE_NONE || mInitState == InitState.INIT_STATE_IN_PROGRESS) {
            initCallbackListeners.add(this);
        }
        if (mWasInitCalled.compareAndSet(false, true)) {
            IronLog ironLog = IronLog.ADAPTER_API;
            ironLog.verbose("sdkKey = " + str);
            mInitState = InitState.INIT_STATE_IN_PROGRESS;
            AppLovinSdk instance = AppLovinSdk.getInstance(str, getAppLovinSDKSetting(), ContextProvider.getInstance().getApplicationContext());
            mAppLovinSdk = instance;
            instance.setMediationProvider("ironsource");
            if (!TextUtils.isEmpty(str2)) {
                IronLog ironLog2 = IronLog.ADAPTER_API;
                ironLog2.verbose("setUserIdentifier to " + str2);
                mAppLovinSdk.setUserIdentifier(str2);
            }
            mAppLovinSdk.initializeSdk((AppLovinSdk.SdkInitializationListener) new AppLovinSdk.SdkInitializationListener() {
                public void onSdkInitialized(AppLovinSdkConfiguration appLovinSdkConfiguration) {
                    AppLovinAdapter.this.initializationSuccess();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void initializationSuccess() {
        IronLog.ADAPTER_CALLBACK.verbose();
        mInitState = InitState.INIT_STATE_SUCCESS;
        Iterator<INetworkInitCallbackListener> it = initCallbackListeners.iterator();
        while (it.hasNext()) {
            it.next().onNetworkInitCallbackSuccess();
        }
        initCallbackListeners.clear();
    }

    public void onNetworkInitCallbackSuccess() {
        for (String next : this.mZoneIdToRewardedVideoSmashListener.keySet()) {
            RewardedVideoSmashListener rewardedVideoSmashListener = this.mZoneIdToRewardedVideoSmashListener.get(next);
            if (this.mRewardedVideoZoneIdsForInitCallbacks.contains(next)) {
                rewardedVideoSmashListener.onRewardedVideoInitSuccess();
            } else {
                loadRewardedVideoInternal(next, rewardedVideoSmashListener);
            }
        }
        for (InterstitialSmashListener onInterstitialInitSuccess : this.mZoneIdToInterstitialSmashListener.values()) {
            onInterstitialInitSuccess.onInterstitialInitSuccess();
        }
        for (BannerSmashListener onBannerInitSuccess : this.mZoneIdToBannerSmashListener.values()) {
            onBannerInitSuccess.onBannerInitSuccess();
        }
    }

    public void initRewardedVideoWithCallback(String str, final String str2, JSONObject jSONObject, RewardedVideoSmashListener rewardedVideoSmashListener) {
        String zoneId = getZoneId(jSONObject);
        final String optString = jSONObject.optString(SDK_KEY);
        if (TextUtils.isEmpty(optString)) {
            IronLog.INTERNAL.error("error - missing param - sdkKey");
            rewardedVideoSmashListener.onRewardedVideoInitFailed(ErrorBuilder.buildInitFailedError("Missing param - sdkKey", IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
        } else if (TextUtils.isEmpty(zoneId)) {
            IronLog.INTERNAL.error("Missing param - zoneId");
            rewardedVideoSmashListener.onRewardedVideoInitFailed(ErrorBuilder.buildInitFailedError("Missing param - zoneId", IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
        } else {
            IronLog ironLog = IronLog.ADAPTER_API;
            ironLog.verbose("zoneId = " + zoneId);
            this.mZoneIdToRewardedVideoSmashListener.put(zoneId, rewardedVideoSmashListener);
            this.mRewardedVideoZoneIdsForInitCallbacks.add(zoneId);
            int i = AnonymousClass9.$SwitchMap$com$ironsource$adapters$applovin$AppLovinAdapter$InitState[mInitState.ordinal()];
            if (i == 1 || i == 2) {
                postOnUIThread(new Runnable() {
                    public void run() {
                        AppLovinAdapter.this.initSdk(optString, str2);
                    }
                });
            } else if (i == 3) {
                rewardedVideoSmashListener.onRewardedVideoInitSuccess();
            }
        }
    }

    /* renamed from: com.ironsource.adapters.applovin.AppLovinAdapter$9  reason: invalid class name */
    static /* synthetic */ class AnonymousClass9 {
        static final /* synthetic */ int[] $SwitchMap$com$ironsource$adapters$applovin$AppLovinAdapter$InitState;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.ironsource.adapters.applovin.AppLovinAdapter$InitState[] r0 = com.ironsource.adapters.applovin.AppLovinAdapter.InitState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$ironsource$adapters$applovin$AppLovinAdapter$InitState = r0
                com.ironsource.adapters.applovin.AppLovinAdapter$InitState r1 = com.ironsource.adapters.applovin.AppLovinAdapter.InitState.INIT_STATE_NONE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$ironsource$adapters$applovin$AppLovinAdapter$InitState     // Catch:{ NoSuchFieldError -> 0x001d }
                com.ironsource.adapters.applovin.AppLovinAdapter$InitState r1 = com.ironsource.adapters.applovin.AppLovinAdapter.InitState.INIT_STATE_IN_PROGRESS     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$ironsource$adapters$applovin$AppLovinAdapter$InitState     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.ironsource.adapters.applovin.AppLovinAdapter$InitState r1 = com.ironsource.adapters.applovin.AppLovinAdapter.InitState.INIT_STATE_SUCCESS     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ironsource.adapters.applovin.AppLovinAdapter.AnonymousClass9.<clinit>():void");
        }
    }

    public void initAndLoadRewardedVideo(String str, final String str2, JSONObject jSONObject, JSONObject jSONObject2, RewardedVideoSmashListener rewardedVideoSmashListener) {
        String zoneId = getZoneId(jSONObject);
        final String optString = jSONObject.optString(SDK_KEY);
        if (TextUtils.isEmpty(optString)) {
            IronLog.INTERNAL.error("Missing param - sdkKey");
            rewardedVideoSmashListener.onRewardedVideoAvailabilityChanged(false);
        } else if (TextUtils.isEmpty(zoneId)) {
            IronLog.INTERNAL.error("Missing param - zoneId");
            rewardedVideoSmashListener.onRewardedVideoAvailabilityChanged(false);
        } else {
            IronLog ironLog = IronLog.ADAPTER_API;
            ironLog.verbose("zoneId = " + zoneId);
            this.mZoneIdToRewardedVideoSmashListener.put(zoneId, rewardedVideoSmashListener);
            int i = AnonymousClass9.$SwitchMap$com$ironsource$adapters$applovin$AppLovinAdapter$InitState[mInitState.ordinal()];
            if (i == 1 || i == 2) {
                postOnUIThread(new Runnable() {
                    public void run() {
                        AppLovinAdapter.this.initSdk(optString, str2);
                    }
                });
            } else if (i == 3) {
                loadRewardedVideoInternal(zoneId, rewardedVideoSmashListener);
            }
        }
    }

    public void loadRewardedVideo(JSONObject jSONObject, JSONObject jSONObject2, RewardedVideoSmashListener rewardedVideoSmashListener) {
        loadRewardedVideoInternal(getZoneId(jSONObject), rewardedVideoSmashListener);
    }

    private void loadRewardedVideoInternal(String str, RewardedVideoSmashListener rewardedVideoSmashListener) {
        AppLovinIncentivizedInterstitial appLovinIncentivizedInterstitial;
        IronLog ironLog = IronLog.ADAPTER_API;
        ironLog.verbose("zoneId = " + str);
        if (this.mZoneIdToRewardedVideoAd.containsKey(str)) {
            appLovinIncentivizedInterstitial = this.mZoneIdToRewardedVideoAd.get(str);
        } else {
            if (!str.equals(DEFAULT_ZONE_ID)) {
                appLovinIncentivizedInterstitial = AppLovinIncentivizedInterstitial.create(str, mAppLovinSdk);
            } else {
                appLovinIncentivizedInterstitial = AppLovinIncentivizedInterstitial.create(mAppLovinSdk);
            }
            this.mZoneIdToRewardedVideoAd.put(str, appLovinIncentivizedInterstitial);
        }
        AppLovinRewardedVideoListener appLovinRewardedVideoListener = new AppLovinRewardedVideoListener(this, rewardedVideoSmashListener, str);
        this.mZoneIdToAppLovinRewardedVideoListener.put(str, appLovinRewardedVideoListener);
        appLovinIncentivizedInterstitial.preload(appLovinRewardedVideoListener);
    }

    public void showRewardedVideo(JSONObject jSONObject, RewardedVideoSmashListener rewardedVideoSmashListener) {
        String zoneId = getZoneId(jSONObject);
        IronLog ironLog = IronLog.ADAPTER_API;
        ironLog.verbose("zoneId = " + zoneId);
        if (isRewardedVideoAvailable(jSONObject)) {
            if (!TextUtils.isEmpty(getDynamicUserId())) {
                mAppLovinSdk.setUserIdentifier(getDynamicUserId());
            }
            AppLovinRewardedVideoListener appLovinRewardedVideoListener = this.mZoneIdToAppLovinRewardedVideoListener.get(zoneId);
            this.mZoneIdToRewardedVideoAd.get(zoneId).show(ContextProvider.getInstance().getCurrentActiveActivity(), appLovinRewardedVideoListener, appLovinRewardedVideoListener, appLovinRewardedVideoListener, appLovinRewardedVideoListener);
            return;
        }
        rewardedVideoSmashListener.onRewardedVideoAdShowFailed(ErrorBuilder.buildNoAdsToShowError(IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
    }

    public boolean isRewardedVideoAvailable(JSONObject jSONObject) {
        AppLovinIncentivizedInterstitial appLovinIncentivizedInterstitial = this.mZoneIdToRewardedVideoAd.get(getZoneId(jSONObject));
        return appLovinIncentivizedInterstitial != null && appLovinIncentivizedInterstitial.isAdReadyToDisplay();
    }

    public void initInterstitial(String str, final String str2, JSONObject jSONObject, InterstitialSmashListener interstitialSmashListener) {
        String zoneId = getZoneId(jSONObject);
        final String optString = jSONObject.optString(SDK_KEY);
        if (TextUtils.isEmpty(optString)) {
            IronLog.INTERNAL.error("Missing param - sdkKey");
            interstitialSmashListener.onInterstitialInitFailed(ErrorBuilder.buildInitFailedError("Missing param - sdkKey", "Interstitial"));
        } else if (TextUtils.isEmpty(zoneId)) {
            IronLog.INTERNAL.error("Missing param - zoneId");
            interstitialSmashListener.onInterstitialInitFailed(ErrorBuilder.buildInitFailedError("Missing param - zoneId", "Interstitial"));
        } else {
            IronLog ironLog = IronLog.ADAPTER_API;
            ironLog.verbose("zoneId = " + zoneId);
            this.mZoneIdToInterstitialSmashListener.put(zoneId, interstitialSmashListener);
            int i = AnonymousClass9.$SwitchMap$com$ironsource$adapters$applovin$AppLovinAdapter$InitState[mInitState.ordinal()];
            if (i == 1 || i == 2) {
                postOnUIThread(new Runnable() {
                    public void run() {
                        AppLovinAdapter.this.initSdk(optString, str2);
                    }
                });
            } else if (i == 3) {
                interstitialSmashListener.onInterstitialInitSuccess();
            }
        }
    }

    public void loadInterstitial(JSONObject jSONObject, JSONObject jSONObject2, InterstitialSmashListener interstitialSmashListener) {
        String zoneId = getZoneId(jSONObject);
        IronLog ironLog = IronLog.ADAPTER_API;
        ironLog.verbose("zoneId = " + zoneId);
        AppLovinInterstitialListener appLovinInterstitialListener = new AppLovinInterstitialListener(this, interstitialSmashListener, zoneId);
        this.mZoneIdToAppLovinInterstitialListener.put(zoneId, appLovinInterstitialListener);
        if (!zoneId.equals(DEFAULT_ZONE_ID)) {
            mAppLovinSdk.getAdService().loadNextAdForZoneId(zoneId, appLovinInterstitialListener);
        } else {
            mAppLovinSdk.getAdService().loadNextAd(AppLovinAdSize.INTERSTITIAL, appLovinInterstitialListener);
        }
    }

    public void showInterstitial(JSONObject jSONObject, InterstitialSmashListener interstitialSmashListener) {
        String zoneId = getZoneId(jSONObject);
        IronLog ironLog = IronLog.ADAPTER_API;
        ironLog.verbose("zoneId = " + zoneId);
        if (isInterstitialReady(jSONObject)) {
            AppLovinInterstitialListener appLovinInterstitialListener = this.mZoneIdToAppLovinInterstitialListener.get(zoneId);
            AppLovinInterstitialAdDialog create = AppLovinInterstitialAd.create(mAppLovinSdk, ContextProvider.getInstance().getCurrentActiveActivity());
            create.setAdClickListener(appLovinInterstitialListener);
            create.setAdDisplayListener(appLovinInterstitialListener);
            create.setAdVideoPlaybackListener(appLovinInterstitialListener);
            create.showAndRender(this.mZoneIdToInterstitialAd.get(zoneId));
            this.mZoneIdToInterstitialAdReadyStatus.put(zoneId, false);
            return;
        }
        interstitialSmashListener.onInterstitialAdShowFailed(ErrorBuilder.buildNoAdsToShowError("Interstitial"));
    }

    public boolean isInterstitialReady(JSONObject jSONObject) {
        String zoneId = getZoneId(jSONObject);
        return this.mZoneIdToInterstitialAd.containsKey(zoneId) && this.mZoneIdToInterstitialAdReadyStatus.containsKey(zoneId) && this.mZoneIdToInterstitialAdReadyStatus.get(zoneId).booleanValue();
    }

    public void initBanners(String str, final String str2, JSONObject jSONObject, BannerSmashListener bannerSmashListener) {
        String zoneId = getZoneId(jSONObject);
        final String optString = jSONObject.optString(SDK_KEY);
        if (TextUtils.isEmpty(optString)) {
            IronLog.INTERNAL.error("Missing param - sdkKey");
            bannerSmashListener.onBannerInitFailed(ErrorBuilder.buildInitFailedError("Missing param - sdkKey", "Banner"));
        } else if (TextUtils.isEmpty(zoneId)) {
            IronLog.INTERNAL.error("Missing param - zoneId");
            bannerSmashListener.onBannerInitFailed(ErrorBuilder.buildInitFailedError("Missing param - zoneId", "Banner"));
        } else {
            IronLog ironLog = IronLog.ADAPTER_API;
            ironLog.verbose("zoneId = " + zoneId);
            this.mZoneIdToBannerSmashListener.put(zoneId, bannerSmashListener);
            int i = AnonymousClass9.$SwitchMap$com$ironsource$adapters$applovin$AppLovinAdapter$InitState[mInitState.ordinal()];
            if (i == 1 || i == 2) {
                postOnUIThread(new Runnable() {
                    public void run() {
                        AppLovinAdapter.this.initSdk(optString, str2);
                    }
                });
            } else if (i == 3) {
                bannerSmashListener.onBannerInitSuccess();
            }
        }
    }

    public void loadBanner(JSONObject jSONObject, JSONObject jSONObject2, IronSourceBannerLayout ironSourceBannerLayout, BannerSmashListener bannerSmashListener) {
        final String zoneId = getZoneId(jSONObject);
        IronLog ironLog = IronLog.ADAPTER_API;
        ironLog.verbose("zoneId = " + zoneId);
        if (ironSourceBannerLayout == null) {
            IronLog.INTERNAL.error("banner layout is null");
            bannerSmashListener.onBannerAdLoadFailed(ErrorBuilder.buildNoConfigurationAvailableError("banner layout is null"));
            return;
        }
        final AppLovinAdSize calculateBannerSize = calculateBannerSize(ironSourceBannerLayout.getSize(), AdapterUtils.isLargeScreen(ContextProvider.getInstance().getApplicationContext()));
        if (calculateBannerSize == null) {
            IronLog.INTERNAL.error("size not supported, size is null");
            bannerSmashListener.onBannerAdLoadFailed(ErrorBuilder.unsupportedBannerSize(getProviderName()));
            return;
        }
        final IronSourceBannerLayout ironSourceBannerLayout2 = ironSourceBannerLayout;
        final BannerSmashListener bannerSmashListener2 = bannerSmashListener;
        postOnUIThread(new Runnable() {
            public void run() {
                try {
                    FrameLayout.LayoutParams access$200 = AppLovinAdapter.this.getBannerLayoutParams(ironSourceBannerLayout2.getSize());
                    AppLovinBannerListener appLovinBannerListener = new AppLovinBannerListener(AppLovinAdapter.this, bannerSmashListener2, zoneId, access$200);
                    AppLovinAdView appLovinAdView = new AppLovinAdView(AppLovinAdapter.mAppLovinSdk, calculateBannerSize, ContextProvider.getInstance().getApplicationContext());
                    appLovinAdView.setAdDisplayListener(appLovinBannerListener);
                    appLovinAdView.setAdClickListener(appLovinBannerListener);
                    appLovinAdView.setAdViewEventListener(appLovinBannerListener);
                    AppLovinAdapter.this.mZoneIdToBannerAd.put(zoneId, appLovinAdView);
                    AppLovinAdapter.this.mZoneIdToBannerLayout.put(zoneId, access$200);
                    AppLovinAdapter.this.mZoneIdToAppLovinBannerListener.put(zoneId, appLovinBannerListener);
                    AppLovinAdapter.this.mZoneIdToBannerSize.put(zoneId, calculateBannerSize);
                    if (!zoneId.equals(AppLovinAdapter.DEFAULT_ZONE_ID)) {
                        AppLovinAdapter.mAppLovinSdk.getAdService().loadNextAdForZoneId(zoneId, appLovinBannerListener);
                    } else {
                        AppLovinAdapter.mAppLovinSdk.getAdService().loadNextAd(calculateBannerSize, appLovinBannerListener);
                    }
                } catch (Exception e) {
                    bannerSmashListener2.onBannerAdLoadFailed(ErrorBuilder.buildLoadFailedError(AppLovinAdapter.this.getProviderName() + " loadBanner exception " + e.getMessage()));
                }
            }
        });
    }

    public void destroyBanner(JSONObject jSONObject) {
        final String zoneId = getZoneId(jSONObject);
        final AppLovinAdView appLovinAdView = this.mZoneIdToBannerAd.get(zoneId);
        postOnUIThread(new Runnable() {
            public void run() {
                AppLovinAdView appLovinAdView = appLovinAdView;
                if (appLovinAdView != null) {
                    appLovinAdView.destroy();
                }
                AppLovinAdapter.this.mZoneIdToBannerAd.remove(zoneId);
                AppLovinAdapter.this.mZoneIdToBannerLayout.remove(zoneId);
                AppLovinAdapter.this.mZoneIdToAppLovinBannerListener.remove(zoneId);
                AppLovinAdapter.this.mZoneIdToBannerSize.remove(zoneId);
            }
        });
    }

    public void releaseMemory(IronSource.AD_UNIT ad_unit, JSONObject jSONObject) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("adUnit = " + ad_unit);
        if (ad_unit == IronSource.AD_UNIT.REWARDED_VIDEO) {
            this.mZoneIdToAppLovinRewardedVideoListener.clear();
            this.mZoneIdToRewardedVideoAd.clear();
            this.mZoneIdToRewardedVideoSmashListener.clear();
            this.mRewardedVideoZoneIdsForInitCallbacks.clear();
        } else if (ad_unit == IronSource.AD_UNIT.INTERSTITIAL) {
            this.mZoneIdToAppLovinInterstitialListener.clear();
            this.mZoneIdToInterstitialAdReadyStatus.clear();
            this.mZoneIdToInterstitialAd.clear();
            this.mZoneIdToInterstitialSmashListener.clear();
        } else if (ad_unit == IronSource.AD_UNIT.BANNER) {
            postOnUIThread(new Runnable() {
                public void run() {
                    for (AppLovinAdView destroy : AppLovinAdapter.this.mZoneIdToBannerAd.values()) {
                        destroy.destroy();
                    }
                    AppLovinAdapter.this.mZoneIdToAppLovinBannerListener.clear();
                    AppLovinAdapter.this.mZoneIdToBannerSmashListener.clear();
                    AppLovinAdapter.this.mZoneIdToBannerLayout.clear();
                    AppLovinAdapter.this.mZoneIdToBannerAd.clear();
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public void setMetaData(String str, List<String> list) {
        if (!list.isEmpty()) {
            String str2 = list.get(0);
            IronLog ironLog = IronLog.ADAPTER_API;
            ironLog.verbose("key = " + str + ", value = " + str2);
            if (MetaDataUtils.isValidCCPAMetaData(str, str2)) {
                setCCPAValue(MetaDataUtils.getMetaDataBooleanValue(str2));
                return;
            }
            String formatValueForType = MetaDataUtils.formatValueForType(str2, MetaData.MetaDataValueTypes.META_DATA_VALUE_BOOLEAN);
            if (MetaDataUtils.isValidMetaData(str, META_DATA_APPLOVIN_AGE_RESTRICTION_KEY, formatValueForType)) {
                setAgeRestrictionValue(MetaDataUtils.getMetaDataBooleanValue(formatValueForType));
            }
        }
    }

    /* access modifiers changed from: protected */
    public void setConsent(boolean z) {
        IronLog ironLog = IronLog.ADAPTER_API;
        ironLog.verbose("consent = " + z);
        AppLovinPrivacySettings.setHasUserConsent(z, ContextProvider.getInstance().getApplicationContext());
    }

    private void setAgeRestrictionValue(boolean z) {
        IronLog ironLog = IronLog.ADAPTER_API;
        ironLog.verbose("value = " + z);
        AppLovinPrivacySettings.setIsAgeRestrictedUser(z, ContextProvider.getInstance().getApplicationContext());
    }

    private void setCCPAValue(boolean z) {
        IronLog ironLog = IronLog.ADAPTER_API;
        ironLog.verbose("value = " + z);
        AppLovinPrivacySettings.setDoNotSell(z, ContextProvider.getInstance().getApplicationContext());
    }

    private AppLovinAdSize calculateBannerSize(ISBannerSize iSBannerSize, boolean z) {
        if (iSBannerSize == null) {
            IronLog ironLog = IronLog.ADAPTER_API;
            ironLog.error(getProviderName() + " calculateLayoutParams - bannerSize is null");
            return null;
        }
        String description = iSBannerSize.getDescription();
        description.hashCode();
        char c = 65535;
        switch (description.hashCode()) {
            case -387072689:
                if (description.equals(l.c)) {
                    c = 0;
                    break;
                }
                break;
            case 72205083:
                if (description.equals(l.b)) {
                    c = 1;
                    break;
                }
                break;
            case 79011241:
                if (description.equals(l.e)) {
                    c = 2;
                    break;
                }
                break;
            case 1951953708:
                if (description.equals(l.a)) {
                    c = 3;
                    break;
                }
                break;
            case 1999208305:
                if (description.equals(l.f)) {
                    c = 4;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return AppLovinAdSize.MREC;
            case 1:
            case 3:
                return AppLovinAdSize.BANNER;
            case 2:
                return z ? AppLovinAdSize.LEADER : AppLovinAdSize.BANNER;
            case 4:
                if (iSBannerSize.getHeight() >= 40 && iSBannerSize.getHeight() <= 60) {
                    return AppLovinAdSize.BANNER;
                }
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0051, code lost:
        if (r3.equals(com.ironsource.mediationsdk.l.c) == false) goto L_0x001d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.widget.FrameLayout.LayoutParams getBannerLayoutParams(com.ironsource.mediationsdk.ISBannerSize r7) {
        /*
            r6 = this;
            android.widget.FrameLayout$LayoutParams r0 = new android.widget.FrameLayout$LayoutParams
            r1 = 0
            r0.<init>(r1, r1)
            com.ironsource.environment.ContextProvider r2 = com.ironsource.environment.ContextProvider.getInstance()
            android.content.Context r2 = r2.getApplicationContext()
            java.lang.String r3 = r7.getDescription()
            r3.hashCode()
            int r4 = r3.hashCode()
            r5 = -1
            switch(r4) {
                case -387072689: goto L_0x004b;
                case 72205083: goto L_0x0040;
                case 79011241: goto L_0x0035;
                case 1951953708: goto L_0x002a;
                case 1999208305: goto L_0x001f;
                default: goto L_0x001d;
            }
        L_0x001d:
            r1 = -1
            goto L_0x0054
        L_0x001f:
            java.lang.String r1 = "CUSTOM"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x0028
            goto L_0x001d
        L_0x0028:
            r1 = 4
            goto L_0x0054
        L_0x002a:
            java.lang.String r1 = "BANNER"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x0033
            goto L_0x001d
        L_0x0033:
            r1 = 3
            goto L_0x0054
        L_0x0035:
            java.lang.String r1 = "SMART"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x003e
            goto L_0x001d
        L_0x003e:
            r1 = 2
            goto L_0x0054
        L_0x0040:
            java.lang.String r1 = "LARGE"
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x0049
            goto L_0x001d
        L_0x0049:
            r1 = 1
            goto L_0x0054
        L_0x004b:
            java.lang.String r4 = "RECTANGLE"
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L_0x0054
            goto L_0x001d
        L_0x0054:
            r3 = 50
            r4 = 320(0x140, float:4.48E-43)
            switch(r1) {
                case 0: goto L_0x00ae;
                case 1: goto L_0x00a0;
                case 2: goto L_0x007a;
                case 3: goto L_0x00a0;
                case 4: goto L_0x005c;
                default: goto L_0x005b;
            }
        L_0x005b:
            goto L_0x00bf
        L_0x005c:
            int r1 = r7.getHeight()
            r5 = 40
            if (r1 < r5) goto L_0x00bf
            int r7 = r7.getHeight()
            r1 = 60
            if (r7 > r1) goto L_0x00bf
            android.widget.FrameLayout$LayoutParams r0 = new android.widget.FrameLayout$LayoutParams
            int r7 = com.ironsource.mediationsdk.AdapterUtils.dpToPixels(r2, r4)
            int r1 = com.ironsource.mediationsdk.AdapterUtils.dpToPixels(r2, r3)
            r0.<init>(r7, r1)
            goto L_0x00bf
        L_0x007a:
            boolean r7 = com.ironsource.mediationsdk.AdapterUtils.isLargeScreen(r2)
            if (r7 == 0) goto L_0x0092
            android.widget.FrameLayout$LayoutParams r0 = new android.widget.FrameLayout$LayoutParams
            r7 = 728(0x2d8, float:1.02E-42)
            int r7 = com.ironsource.mediationsdk.AdapterUtils.dpToPixels(r2, r7)
            r1 = 90
            int r1 = com.ironsource.mediationsdk.AdapterUtils.dpToPixels(r2, r1)
            r0.<init>(r7, r1)
            goto L_0x00bf
        L_0x0092:
            android.widget.FrameLayout$LayoutParams r0 = new android.widget.FrameLayout$LayoutParams
            int r7 = com.ironsource.mediationsdk.AdapterUtils.dpToPixels(r2, r4)
            int r1 = com.ironsource.mediationsdk.AdapterUtils.dpToPixels(r2, r3)
            r0.<init>(r7, r1)
            goto L_0x00bf
        L_0x00a0:
            android.widget.FrameLayout$LayoutParams r0 = new android.widget.FrameLayout$LayoutParams
            int r7 = com.ironsource.mediationsdk.AdapterUtils.dpToPixels(r2, r4)
            int r1 = com.ironsource.mediationsdk.AdapterUtils.dpToPixels(r2, r3)
            r0.<init>(r7, r1)
            goto L_0x00bf
        L_0x00ae:
            android.widget.FrameLayout$LayoutParams r0 = new android.widget.FrameLayout$LayoutParams
            r7 = 300(0x12c, float:4.2E-43)
            int r7 = com.ironsource.mediationsdk.AdapterUtils.dpToPixels(r2, r7)
            r1 = 250(0xfa, float:3.5E-43)
            int r1 = com.ironsource.mediationsdk.AdapterUtils.dpToPixels(r2, r1)
            r0.<init>(r7, r1)
        L_0x00bf:
            r7 = 17
            r0.gravity = r7
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.adapters.applovin.AppLovinAdapter.getBannerLayoutParams(com.ironsource.mediationsdk.ISBannerSize):android.widget.FrameLayout$LayoutParams");
    }

    private AppLovinSdkSettings getAppLovinSDKSetting() {
        AppLovinSdkSettings appLovinSdkSettings = new AppLovinSdkSettings(ContextProvider.getInstance().getApplicationContext());
        appLovinSdkSettings.setVerboseLogging(isAdaptersDebugEnabled());
        return appLovinSdkSettings;
    }

    private String getZoneId(JSONObject jSONObject) {
        return !TextUtils.isEmpty(jSONObject.optString(ZONE_ID)) ? jSONObject.optString(ZONE_ID) : DEFAULT_ZONE_ID;
    }
}
