package com.ironsource.adapters.unityads;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import com.ironsource.adapters.ironsource.IronSourceAdapter;
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
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.metadata.MetaData;
import com.ironsource.mediationsdk.metadata.MetaDataUtils;
import com.ironsource.mediationsdk.sdk.BannerSmashListener;
import com.ironsource.mediationsdk.sdk.InterstitialSmashListener;
import com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.unity3d.ads.IUnityAdsInitializationListener;
import com.unity3d.ads.IUnityAdsTokenListener;
import com.unity3d.ads.UnityAds;
import com.unity3d.ads.UnityAdsLoadOptions;
import com.unity3d.ads.UnityAdsShowOptions;
import com.unity3d.ads.metadata.MediationMetaData;
import com.unity3d.ads.metadata.PlayerMetaData;
import com.unity3d.services.banners.BannerView;
import com.unity3d.services.banners.UnityBannerSize;
import com.unity3d.services.core.device.reader.JsonStorageKeyNames;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

class UnityAdsAdapter extends AbstractAdapter implements IUnityAdsInitializationListener, INetworkInitCallbackListener {
    private static final String GitHash = "3edb79ce8";
    private static final String VERSION = "4.3.34";
    /* access modifiers changed from: private */
    public static String asyncToken = null;
    private static HashSet<INetworkInitCallbackListener> initCallbackListeners = new HashSet<>();
    private static InitState mInitState = InitState.INIT_STATE_NONE;
    private static AtomicBoolean mWasInitCalled = new AtomicBoolean(false);
    private final String ADAPTER_VERSION_KEY = "adapter_version";
    private final String ADS_GATEWAY_ENABLED = "adsGateway";
    private final String CONSENT_CCPA = "privacy.consent";
    private final String CONSENT_GDPR = "gdpr.consent";
    private final String GAME_DESIGNATION = "mode";
    private final String GAME_ID = "sourceId";
    private final String LWS_SUPPORT_STATE = "isSupportedLWS";
    private final String MEDIATION_NAME = "ironSource";
    private final String MIXED_AUDIENCE = "mixed";
    private final String PLACEMENT_ID = "zoneId";
    private final String UNITYADS_COPPA = JsonStorageKeyNames.USER_NON_BEHAVIORAL_KEY;
    private final String UNITYADS_METADATA_COPPA_KEY = "unityads_coppa";
    protected ConcurrentHashMap<String, Boolean> mInterstitialAdsAvailability;
    private ConcurrentHashMap<String, String> mInterstitialPlacementIdToLoadedAdObjectId;
    private ConcurrentHashMap<String, BannerView> mPlacementIdToBannerAd;
    private ConcurrentHashMap<String, UnityAdsBannerListener> mPlacementIdToBannerListener;
    private ConcurrentHashMap<String, BannerSmashListener> mPlacementIdToBannerSmashListener;
    private ConcurrentHashMap<String, UnityAdsInterstitialListener> mPlacementIdToInterstitialListener;
    private ConcurrentHashMap<String, InterstitialSmashListener> mPlacementIdToInterstitialSmashListener;
    private ConcurrentHashMap<String, UnityAdsRewardedVideoListener> mPlacementIdToRewardedVideoListener;
    private ConcurrentHashMap<String, RewardedVideoSmashListener> mPlacementIdToRewardedVideoSmashListener;
    protected ConcurrentHashMap<String, Boolean> mRewardedVideoAdsAvailability;
    private ConcurrentHashMap<String, String> mRewardedVideoPlacementIdToLoadedAdObjectId;
    private CopyOnWriteArraySet<String> mRewardedVideoPlacementIdsForInitCallbacks;
    private final Object mUnityAdsStorageLock = new Object();

    private enum InitState {
        INIT_STATE_NONE,
        INIT_STATE_IN_PROGRESS,
        INIT_STATE_SUCCESS,
        INIT_STATE_FAILED
    }

    private boolean isOSSupported() {
        return true;
    }

    public String getVersion() {
        return "4.3.34";
    }

    public boolean isUsingActivityBeforeImpression(IronSource.AD_UNIT ad_unit) {
        return false;
    }

    public static UnityAdsAdapter startAdapter(String str) {
        return new UnityAdsAdapter(str);
    }

    private UnityAdsAdapter(String str) {
        super(str);
        IronLog.INTERNAL.verbose();
        this.mPlacementIdToRewardedVideoSmashListener = new ConcurrentHashMap<>();
        this.mPlacementIdToRewardedVideoListener = new ConcurrentHashMap<>();
        this.mRewardedVideoPlacementIdToLoadedAdObjectId = new ConcurrentHashMap<>();
        this.mRewardedVideoAdsAvailability = new ConcurrentHashMap<>();
        this.mRewardedVideoPlacementIdsForInitCallbacks = new CopyOnWriteArraySet<>();
        this.mPlacementIdToInterstitialSmashListener = new ConcurrentHashMap<>();
        this.mPlacementIdToInterstitialListener = new ConcurrentHashMap<>();
        this.mInterstitialPlacementIdToLoadedAdObjectId = new ConcurrentHashMap<>();
        this.mInterstitialAdsAvailability = new ConcurrentHashMap<>();
        this.mPlacementIdToBannerSmashListener = new ConcurrentHashMap<>();
        this.mPlacementIdToBannerListener = new ConcurrentHashMap<>();
        this.mPlacementIdToBannerAd = new ConcurrentHashMap<>();
    }

    public static IntegrationData getIntegrationData(Context context) {
        return new IntegrationData("UnityAds", "4.3.34");
    }

    public String getCoreSDKVersion() {
        return UnityAds.getVersion();
    }

    public static String getAdapterSDKVersion() {
        return UnityAds.getVersion();
    }

    private void initSDK(String str, JSONObject jSONObject) {
        if (mInitState == InitState.INIT_STATE_NONE || mInitState == InitState.INIT_STATE_IN_PROGRESS) {
            initCallbackListeners.add(this);
        }
        if (mWasInitCalled.compareAndSet(false, true)) {
            IronLog.ADAPTER_API.verbose();
            mInitState = InitState.INIT_STATE_IN_PROGRESS;
            synchronized (this.mUnityAdsStorageLock) {
                MediationMetaData mediationMetaData = new MediationMetaData(ContextProvider.getInstance().getApplicationContext());
                mediationMetaData.setName("ironSource");
                mediationMetaData.setVersion(IronSourceUtils.getSDKVersion());
                mediationMetaData.set("adapter_version", (Object) "4.3.34");
                mediationMetaData.commit();
            }
            setUnityAdsMetaData("adsGateway", jSONObject.optBoolean("adsGateway", false));
            UnityAds.setDebugMode(isAdaptersDebugEnabled());
            UnityAds.initialize(ContextProvider.getInstance().getApplicationContext(), str, false, this);
            getAsyncToken();
        }
    }

    public void onNetworkInitCallbackSuccess() {
        IronLog.ADAPTER_CALLBACK.verbose();
        for (String next : this.mPlacementIdToRewardedVideoSmashListener.keySet()) {
            RewardedVideoSmashListener rewardedVideoSmashListener = this.mPlacementIdToRewardedVideoSmashListener.get(next);
            if (this.mRewardedVideoPlacementIdsForInitCallbacks.contains(next)) {
                rewardedVideoSmashListener.onRewardedVideoInitSuccess();
            } else {
                loadRewardedVideoInternal(next, (String) null, rewardedVideoSmashListener);
            }
        }
        for (InterstitialSmashListener onInterstitialInitSuccess : this.mPlacementIdToInterstitialSmashListener.values()) {
            onInterstitialInitSuccess.onInterstitialInitSuccess();
        }
        for (BannerSmashListener onBannerInitSuccess : this.mPlacementIdToBannerSmashListener.values()) {
            onBannerInitSuccess.onBannerInitSuccess();
        }
    }

    public void onNetworkInitCallbackFailed(String str) {
        IronLog.ADAPTER_CALLBACK.verbose();
        for (String next : this.mPlacementIdToRewardedVideoSmashListener.keySet()) {
            RewardedVideoSmashListener rewardedVideoSmashListener = this.mPlacementIdToRewardedVideoSmashListener.get(next);
            if (this.mRewardedVideoPlacementIdsForInitCallbacks.contains(next)) {
                rewardedVideoSmashListener.onRewardedVideoInitFailed(ErrorBuilder.buildInitFailedError(str, IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
            } else {
                rewardedVideoSmashListener.onRewardedVideoAvailabilityChanged(false);
            }
        }
        for (InterstitialSmashListener onInterstitialInitFailed : this.mPlacementIdToInterstitialSmashListener.values()) {
            onInterstitialInitFailed.onInterstitialInitFailed(ErrorBuilder.buildInitFailedError(str, "Interstitial"));
        }
        for (BannerSmashListener onBannerInitFailed : this.mPlacementIdToBannerSmashListener.values()) {
            onBannerInitFailed.onBannerInitFailed(ErrorBuilder.buildInitFailedError(str, "Banner"));
        }
    }

    public void onInitializationComplete() {
        IronLog.ADAPTER_CALLBACK.verbose();
        mInitState = InitState.INIT_STATE_SUCCESS;
        Iterator<INetworkInitCallbackListener> it = initCallbackListeners.iterator();
        while (it.hasNext()) {
            it.next().onNetworkInitCallbackSuccess();
        }
        initCallbackListeners.clear();
    }

    public void onInitializationFailed(UnityAds.UnityAdsInitializationError unityAdsInitializationError, String str) {
        IronLog.ADAPTER_CALLBACK.verbose();
        mInitState = InitState.INIT_STATE_FAILED;
        String str2 = getUnityAdsInitializationErrorCode(unityAdsInitializationError) + str;
        Iterator<INetworkInitCallbackListener> it = initCallbackListeners.iterator();
        while (it.hasNext()) {
            it.next().onNetworkInitCallbackFailed(str2);
        }
        initCallbackListeners.clear();
    }

    public void initRewardedVideoWithCallback(String str, String str2, JSONObject jSONObject, RewardedVideoSmashListener rewardedVideoSmashListener) {
        String optString = jSONObject.optString("sourceId");
        String optString2 = jSONObject.optString("zoneId");
        if (!isOSSupported()) {
            IronSourceError errorForUnsupportedAdapter = errorForUnsupportedAdapter(IronSourceConstants.REWARDED_VIDEO_AD_UNIT);
            IronLog.INTERNAL.error(errorForUnsupportedAdapter.getErrorMessage());
            rewardedVideoSmashListener.onRewardedVideoInitFailed(errorForUnsupportedAdapter);
        } else if (TextUtils.isEmpty(optString)) {
            IronLog.INTERNAL.error("missing params = sourceId");
            rewardedVideoSmashListener.onRewardedVideoInitFailed(ErrorBuilder.buildInitFailedError("Missing params - sourceId", IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
        } else if (TextUtils.isEmpty(optString2)) {
            IronLog.INTERNAL.error("missing params = zoneId");
            rewardedVideoSmashListener.onRewardedVideoInitFailed(ErrorBuilder.buildInitFailedError("Missing params - zoneId", IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
        } else {
            IronLog ironLog = IronLog.ADAPTER_API;
            ironLog.verbose("gameId = " + optString + ", placementId = " + optString2);
            this.mPlacementIdToRewardedVideoSmashListener.put(optString2, rewardedVideoSmashListener);
            this.mRewardedVideoPlacementIdsForInitCallbacks.add(optString2);
            int i = AnonymousClass2.$SwitchMap$com$ironsource$adapters$unityads$UnityAdsAdapter$InitState[mInitState.ordinal()];
            if (i == 1 || i == 2) {
                initSDK(optString, jSONObject);
            } else if (i == 3) {
                rewardedVideoSmashListener.onRewardedVideoInitSuccess();
            } else if (i == 4) {
                rewardedVideoSmashListener.onRewardedVideoInitFailed(ErrorBuilder.buildInitFailedError("UnityAds SDK init failed", IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
            }
        }
    }

    /* renamed from: com.ironsource.adapters.unityads.UnityAdsAdapter$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$ironsource$adapters$unityads$UnityAdsAdapter$InitState;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.ironsource.adapters.unityads.UnityAdsAdapter$InitState[] r0 = com.ironsource.adapters.unityads.UnityAdsAdapter.InitState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$ironsource$adapters$unityads$UnityAdsAdapter$InitState = r0
                com.ironsource.adapters.unityads.UnityAdsAdapter$InitState r1 = com.ironsource.adapters.unityads.UnityAdsAdapter.InitState.INIT_STATE_NONE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$ironsource$adapters$unityads$UnityAdsAdapter$InitState     // Catch:{ NoSuchFieldError -> 0x001d }
                com.ironsource.adapters.unityads.UnityAdsAdapter$InitState r1 = com.ironsource.adapters.unityads.UnityAdsAdapter.InitState.INIT_STATE_IN_PROGRESS     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$ironsource$adapters$unityads$UnityAdsAdapter$InitState     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.ironsource.adapters.unityads.UnityAdsAdapter$InitState r1 = com.ironsource.adapters.unityads.UnityAdsAdapter.InitState.INIT_STATE_SUCCESS     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$ironsource$adapters$unityads$UnityAdsAdapter$InitState     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.ironsource.adapters.unityads.UnityAdsAdapter$InitState r1 = com.ironsource.adapters.unityads.UnityAdsAdapter.InitState.INIT_STATE_FAILED     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ironsource.adapters.unityads.UnityAdsAdapter.AnonymousClass2.<clinit>():void");
        }
    }

    public void initAndLoadRewardedVideo(String str, String str2, JSONObject jSONObject, JSONObject jSONObject2, RewardedVideoSmashListener rewardedVideoSmashListener) {
        String optString = jSONObject.optString("sourceId");
        String optString2 = jSONObject.optString("zoneId");
        if (!isOSSupported()) {
            IronLog.INTERNAL.error(errorForUnsupportedAdapter(IronSourceConstants.REWARDED_VIDEO_AD_UNIT).getErrorMessage());
            rewardedVideoSmashListener.onRewardedVideoAvailabilityChanged(false);
        } else if (TextUtils.isEmpty(optString)) {
            IronLog.INTERNAL.error("missing params = sourceId");
            rewardedVideoSmashListener.onRewardedVideoAvailabilityChanged(false);
        } else if (TextUtils.isEmpty(optString2)) {
            IronLog.INTERNAL.error("missing params = zoneId");
            rewardedVideoSmashListener.onRewardedVideoAvailabilityChanged(false);
        } else {
            IronLog ironLog = IronLog.ADAPTER_API;
            ironLog.verbose("gameId = " + optString + ", placementId = " + optString2);
            this.mPlacementIdToRewardedVideoSmashListener.put(optString2, rewardedVideoSmashListener);
            int i = AnonymousClass2.$SwitchMap$com$ironsource$adapters$unityads$UnityAdsAdapter$InitState[mInitState.ordinal()];
            if (i == 1 || i == 2) {
                initSDK(optString, jSONObject);
            } else if (i == 3) {
                loadRewardedVideoInternal(optString2, (String) null, rewardedVideoSmashListener);
            } else if (i == 4) {
                rewardedVideoSmashListener.onRewardedVideoAvailabilityChanged(false);
            }
        }
    }

    public void loadRewardedVideoForBidding(JSONObject jSONObject, JSONObject jSONObject2, String str, RewardedVideoSmashListener rewardedVideoSmashListener) {
        String optString = jSONObject.optString("zoneId");
        IronLog ironLog = IronLog.ADAPTER_API;
        ironLog.verbose("placementId = " + optString);
        loadRewardedVideoInternal(optString, str, rewardedVideoSmashListener);
    }

    public void loadRewardedVideo(JSONObject jSONObject, JSONObject jSONObject2, RewardedVideoSmashListener rewardedVideoSmashListener) {
        String optString = jSONObject.optString("zoneId");
        IronLog ironLog = IronLog.ADAPTER_API;
        ironLog.verbose("placementId = " + optString);
        loadRewardedVideoInternal(optString, (String) null, rewardedVideoSmashListener);
    }

    private void loadRewardedVideoInternal(String str, String str2, RewardedVideoSmashListener rewardedVideoSmashListener) {
        IronLog ironLog = IronLog.ADAPTER_API;
        ironLog.verbose("placementId = " + str);
        this.mRewardedVideoAdsAvailability.put(str, false);
        UnityAdsRewardedVideoListener unityAdsRewardedVideoListener = new UnityAdsRewardedVideoListener(this, rewardedVideoSmashListener, str);
        this.mPlacementIdToRewardedVideoListener.put(str, unityAdsRewardedVideoListener);
        UnityAdsLoadOptions unityAdsLoadOptions = new UnityAdsLoadOptions();
        String uuid = UUID.randomUUID().toString();
        unityAdsLoadOptions.setObjectId(uuid);
        if (!TextUtils.isEmpty(str2)) {
            unityAdsLoadOptions.setAdMarkup(str2);
        }
        this.mRewardedVideoPlacementIdToLoadedAdObjectId.put(str, uuid);
        UnityAds.load(str, unityAdsLoadOptions, unityAdsRewardedVideoListener);
    }

    public void showRewardedVideo(JSONObject jSONObject, RewardedVideoSmashListener rewardedVideoSmashListener) {
        String optString = jSONObject.optString("zoneId");
        IronLog ironLog = IronLog.ADAPTER_API;
        ironLog.verbose("placementId = " + optString);
        if (isRewardedVideoAvailable(jSONObject)) {
            this.mRewardedVideoAdsAvailability.put(optString, false);
            if (!TextUtils.isEmpty(getDynamicUserId())) {
                synchronized (this.mUnityAdsStorageLock) {
                    PlayerMetaData playerMetaData = new PlayerMetaData(ContextProvider.getInstance().getApplicationContext());
                    playerMetaData.setServerId(getDynamicUserId());
                    playerMetaData.commit();
                }
            }
            UnityAdsShowOptions unityAdsShowOptions = new UnityAdsShowOptions();
            unityAdsShowOptions.setObjectId(this.mRewardedVideoPlacementIdToLoadedAdObjectId.get(optString));
            UnityAds.show(ContextProvider.getInstance().getCurrentActiveActivity(), optString, unityAdsShowOptions, this.mPlacementIdToRewardedVideoListener.get(optString));
            return;
        }
        rewardedVideoSmashListener.onRewardedVideoAdShowFailed(ErrorBuilder.buildNoAdsToShowError(IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
    }

    public boolean isRewardedVideoAvailable(JSONObject jSONObject) {
        if (!isOSSupported()) {
            IronLog.INTERNAL.error(errorForUnsupportedAdapter(IronSourceConstants.REWARDED_VIDEO_AD_UNIT).getErrorMessage());
            return false;
        }
        String optString = jSONObject.optString("zoneId");
        IronLog ironLog = IronLog.ADAPTER_API;
        ironLog.verbose("placementId = " + optString);
        if (!this.mRewardedVideoAdsAvailability.containsKey(optString) || !this.mRewardedVideoAdsAvailability.get(optString).booleanValue()) {
            return false;
        }
        return true;
    }

    public Map<String, Object> getRewardedVideoBiddingData(JSONObject jSONObject, JSONObject jSONObject2) {
        return getBiddingData();
    }

    public void initInterstitialForBidding(String str, String str2, JSONObject jSONObject, InterstitialSmashListener interstitialSmashListener) {
        IronLog.ADAPTER_API.verbose();
        initInterstitial(str, str2, jSONObject, interstitialSmashListener);
    }

    public void initInterstitial(String str, String str2, JSONObject jSONObject, InterstitialSmashListener interstitialSmashListener) {
        String optString = jSONObject.optString("sourceId");
        String optString2 = jSONObject.optString("zoneId");
        if (!isOSSupported()) {
            IronSourceError errorForUnsupportedAdapter = errorForUnsupportedAdapter("Interstitial");
            IronLog.INTERNAL.error(errorForUnsupportedAdapter.getErrorMessage());
            interstitialSmashListener.onInterstitialInitFailed(errorForUnsupportedAdapter);
        } else if (TextUtils.isEmpty(optString)) {
            IronLog.INTERNAL.error("missing params = sourceId");
            interstitialSmashListener.onInterstitialInitFailed(ErrorBuilder.buildInitFailedError("Missing params - sourceId", "Interstitial"));
        } else if (TextUtils.isEmpty(optString2)) {
            IronLog.INTERNAL.error("missing params = zoneId");
            interstitialSmashListener.onInterstitialInitFailed(ErrorBuilder.buildInitFailedError("Missing params - zoneId", "Interstitial"));
        } else {
            IronLog ironLog = IronLog.ADAPTER_API;
            ironLog.verbose("gameId = " + optString + ", placementId = " + optString2);
            this.mPlacementIdToInterstitialSmashListener.put(optString2, interstitialSmashListener);
            int i = AnonymousClass2.$SwitchMap$com$ironsource$adapters$unityads$UnityAdsAdapter$InitState[mInitState.ordinal()];
            if (i == 1 || i == 2) {
                initSDK(optString, jSONObject);
            } else if (i == 3) {
                interstitialSmashListener.onInterstitialInitSuccess();
            } else if (i == 4) {
                interstitialSmashListener.onInterstitialInitFailed(ErrorBuilder.buildInitFailedError("UnityAds SDK init failed", "Interstitial"));
            }
        }
    }

    public void loadInterstitialForBidding(JSONObject jSONObject, JSONObject jSONObject2, String str, InterstitialSmashListener interstitialSmashListener) {
        String optString = jSONObject.optString("zoneId");
        IronLog ironLog = IronLog.ADAPTER_API;
        ironLog.verbose("placementId = " + optString);
        loadInterstitialInternal(jSONObject, interstitialSmashListener, str, optString);
    }

    public void loadInterstitial(JSONObject jSONObject, JSONObject jSONObject2, InterstitialSmashListener interstitialSmashListener) {
        String optString = jSONObject.optString("zoneId");
        IronLog ironLog = IronLog.ADAPTER_API;
        ironLog.verbose("placementId = " + optString);
        loadInterstitialInternal(jSONObject, interstitialSmashListener, (String) null, optString);
    }

    private void loadInterstitialInternal(JSONObject jSONObject, InterstitialSmashListener interstitialSmashListener, String str, String str2) {
        IronLog ironLog = IronLog.ADAPTER_API;
        ironLog.verbose("placementId = " + str2);
        this.mInterstitialAdsAvailability.put(str2, false);
        UnityAdsInterstitialListener unityAdsInterstitialListener = new UnityAdsInterstitialListener(this, interstitialSmashListener, str2);
        this.mPlacementIdToInterstitialListener.put(str2, unityAdsInterstitialListener);
        UnityAdsLoadOptions unityAdsLoadOptions = new UnityAdsLoadOptions();
        String uuid = UUID.randomUUID().toString();
        unityAdsLoadOptions.setObjectId(uuid);
        if (!TextUtils.isEmpty(str)) {
            unityAdsLoadOptions.setAdMarkup(str);
        }
        this.mInterstitialPlacementIdToLoadedAdObjectId.put(str2, uuid);
        UnityAds.load(str2, unityAdsLoadOptions, unityAdsInterstitialListener);
    }

    public void showInterstitial(JSONObject jSONObject, InterstitialSmashListener interstitialSmashListener) {
        String optString = jSONObject.optString("zoneId");
        IronLog ironLog = IronLog.ADAPTER_API;
        ironLog.verbose("placementId = " + optString);
        if (isInterstitialReady(jSONObject)) {
            this.mInterstitialAdsAvailability.put(optString, false);
            UnityAdsShowOptions unityAdsShowOptions = new UnityAdsShowOptions();
            unityAdsShowOptions.setObjectId(this.mInterstitialPlacementIdToLoadedAdObjectId.get(optString));
            UnityAds.show(ContextProvider.getInstance().getCurrentActiveActivity(), optString, unityAdsShowOptions, this.mPlacementIdToInterstitialListener.get(optString));
            return;
        }
        interstitialSmashListener.onInterstitialAdShowFailed(ErrorBuilder.buildNoAdsToShowError("Interstitial"));
    }

    public boolean isInterstitialReady(JSONObject jSONObject) {
        if (!isOSSupported()) {
            IronLog.INTERNAL.error(errorForUnsupportedAdapter("Interstitial").getErrorMessage());
            return false;
        }
        String optString = jSONObject.optString("zoneId");
        IronLog ironLog = IronLog.ADAPTER_API;
        ironLog.verbose("placementId = " + optString);
        if (!this.mInterstitialAdsAvailability.containsKey(optString) || !this.mInterstitialAdsAvailability.get(optString).booleanValue()) {
            return false;
        }
        return true;
    }

    public Map<String, Object> getInterstitialBiddingData(JSONObject jSONObject, JSONObject jSONObject2) {
        return getBiddingData();
    }

    public void initBannerForBidding(String str, String str2, JSONObject jSONObject, BannerSmashListener bannerSmashListener) {
        initBanners(str, str2, jSONObject, bannerSmashListener);
    }

    public void initBanners(String str, String str2, JSONObject jSONObject, BannerSmashListener bannerSmashListener) {
        String optString = jSONObject.optString("sourceId");
        String optString2 = jSONObject.optString("zoneId");
        if (!isOSSupported()) {
            IronSourceError errorForUnsupportedAdapter = errorForUnsupportedAdapter("Banner");
            IronLog.INTERNAL.error(errorForUnsupportedAdapter.getErrorMessage());
            bannerSmashListener.onBannerInitFailed(errorForUnsupportedAdapter);
        } else if (TextUtils.isEmpty(optString)) {
            IronLog.INTERNAL.error("missing params = sourceId");
            bannerSmashListener.onBannerInitFailed(ErrorBuilder.buildInitFailedError("Missing params - sourceId", "Banner"));
        } else if (TextUtils.isEmpty(optString2)) {
            IronLog.INTERNAL.error("missing params = zoneId");
            bannerSmashListener.onBannerInitFailed(ErrorBuilder.buildInitFailedError("Missing params - zoneId", "Banner"));
        } else {
            IronLog ironLog = IronLog.ADAPTER_API;
            ironLog.verbose("gameId = " + optString + ", placementId = " + optString2);
            this.mPlacementIdToBannerSmashListener.put(optString2, bannerSmashListener);
            int i = AnonymousClass2.$SwitchMap$com$ironsource$adapters$unityads$UnityAdsAdapter$InitState[mInitState.ordinal()];
            if (i == 1 || i == 2) {
                initSDK(optString, jSONObject);
            } else if (i == 3) {
                bannerSmashListener.onBannerInitSuccess();
            } else if (i == 4) {
                bannerSmashListener.onBannerInitFailed(ErrorBuilder.buildInitFailedError("UnityAds SDK init failed", "Banner"));
            }
        }
    }

    public void loadBannerForBidding(JSONObject jSONObject, JSONObject jSONObject2, String str, IronSourceBannerLayout ironSourceBannerLayout, BannerSmashListener bannerSmashListener) {
        loadBannerInternal(jSONObject, jSONObject2, ironSourceBannerLayout, bannerSmashListener, str);
    }

    public void loadBanner(JSONObject jSONObject, JSONObject jSONObject2, IronSourceBannerLayout ironSourceBannerLayout, BannerSmashListener bannerSmashListener) {
        loadBannerInternal(jSONObject, jSONObject2, ironSourceBannerLayout, bannerSmashListener, (String) null);
    }

    public void loadBannerInternal(JSONObject jSONObject, JSONObject jSONObject2, IronSourceBannerLayout ironSourceBannerLayout, BannerSmashListener bannerSmashListener, String str) {
        String optString = jSONObject.optString("zoneId");
        if (ironSourceBannerLayout == null) {
            IronLog.INTERNAL.error("banner is null");
            bannerSmashListener.onBannerAdLoadFailed(ErrorBuilder.buildNoConfigurationAvailableError("banner is null"));
        } else if (!isBannerSizeSupported(ironSourceBannerLayout.getSize()).booleanValue()) {
            IronLog ironLog = IronLog.ADAPTER_API;
            ironLog.verbose("size not supported, size = " + ironSourceBannerLayout.getSize().getDescription());
            bannerSmashListener.onBannerAdLoadFailed(ErrorBuilder.unsupportedBannerSize(getProviderName()));
        } else {
            IronLog ironLog2 = IronLog.ADAPTER_API;
            ironLog2.verbose("placementId = " + optString);
            BannerView bannerView = getBannerView(ironSourceBannerLayout, optString, bannerSmashListener);
            UnityAdsLoadOptions unityAdsLoadOptions = new UnityAdsLoadOptions();
            unityAdsLoadOptions.setObjectId(UUID.randomUUID().toString());
            if (!TextUtils.isEmpty(str)) {
                unityAdsLoadOptions.setAdMarkup(str);
            }
            bannerView.load(unityAdsLoadOptions);
        }
    }

    public void destroyBanner(JSONObject jSONObject) {
        String optString = jSONObject.optString("zoneId");
        IronLog ironLog = IronLog.ADAPTER_API;
        ironLog.verbose("placementId = " + optString);
        if (this.mPlacementIdToBannerAd.get(optString) != null) {
            this.mPlacementIdToBannerAd.get(optString).destroy();
            this.mPlacementIdToBannerAd.remove(optString);
        }
    }

    public Map<String, Object> getBannerBiddingData(JSONObject jSONObject, JSONObject jSONObject2) {
        return getBiddingData();
    }

    public void releaseMemory(IronSource.AD_UNIT ad_unit, JSONObject jSONObject) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("adUnit = " + ad_unit);
        if (ad_unit == IronSource.AD_UNIT.REWARDED_VIDEO) {
            this.mPlacementIdToRewardedVideoSmashListener.clear();
            this.mPlacementIdToRewardedVideoListener.clear();
            this.mRewardedVideoPlacementIdToLoadedAdObjectId.clear();
            this.mRewardedVideoAdsAvailability.clear();
            this.mRewardedVideoPlacementIdsForInitCallbacks.clear();
        } else if (ad_unit == IronSource.AD_UNIT.INTERSTITIAL) {
            this.mPlacementIdToInterstitialSmashListener.clear();
            this.mPlacementIdToInterstitialListener.clear();
            this.mInterstitialPlacementIdToLoadedAdObjectId.clear();
            this.mInterstitialAdsAvailability.clear();
        } else if (ad_unit == IronSource.AD_UNIT.BANNER) {
            for (BannerView destroy : this.mPlacementIdToBannerAd.values()) {
                destroy.destroy();
            }
            this.mPlacementIdToBannerSmashListener.clear();
            this.mPlacementIdToBannerListener.clear();
            this.mPlacementIdToBannerAd.clear();
        }
    }

    /* access modifiers changed from: protected */
    public void setConsent(boolean z) {
        IronLog ironLog = IronLog.ADAPTER_API;
        ironLog.verbose("setConsent = " + z);
        setUnityAdsMetaData("gdpr.consent", z);
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
            if (MetaDataUtils.isValidMetaData(str, "unityads_coppa", formatValueForType)) {
                setCOPPAValue(MetaDataUtils.getMetaDataBooleanValue(formatValueForType));
            }
        }
    }

    private void setUnityAdsMetaData(String str, boolean z) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("key = " + str + "value = " + z);
        synchronized (this.mUnityAdsStorageLock) {
            com.unity3d.ads.metadata.MetaData metaData = new com.unity3d.ads.metadata.MetaData(ContextProvider.getInstance().getApplicationContext());
            metaData.set(str, (Object) Boolean.valueOf(z));
            if (str.equals(JsonStorageKeyNames.USER_NON_BEHAVIORAL_KEY)) {
                metaData.set("mode", (Object) "mixed");
            }
            metaData.commit();
        }
    }

    private void setCOPPAValue(boolean z) {
        IronLog ironLog = IronLog.ADAPTER_API;
        ironLog.verbose("value = " + z);
        setUnityAdsMetaData(JsonStorageKeyNames.USER_NON_BEHAVIORAL_KEY, z);
    }

    private void setCCPAValue(boolean z) {
        IronLog ironLog = IronLog.ADAPTER_API;
        ironLog.verbose("value = " + z);
        setUnityAdsMetaData("privacy.consent", z ^ true);
    }

    private Map<String, Object> getBiddingData() {
        String str;
        if (InitState.INIT_STATE_SUCCESS == mInitState) {
            str = UnityAds.getToken();
        } else if (!TextUtils.isEmpty(asyncToken)) {
            str = asyncToken;
            getAsyncToken();
        } else {
            IronLog.INTERNAL.verbose("returning null as token since init did not finish successfully and async token did not return");
            return null;
        }
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        IronLog ironLog = IronLog.ADAPTER_API;
        ironLog.verbose("token = " + str);
        HashMap hashMap = new HashMap();
        hashMap.put(IronSourceAdapter.IRONSOURCE_BIDDING_TOKEN_KEY, str);
        return hashMap;
    }

    private Boolean isBannerSizeSupported(ISBannerSize iSBannerSize) {
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
        }
        switch (c) {
            case 0:
            case 1:
            case 2:
            case 3:
                return true;
            default:
                return false;
        }
    }

    private UnityBannerSize getBannerSize(ISBannerSize iSBannerSize, boolean z) {
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
        }
        switch (c) {
            case 0:
                return new UnityBannerSize(300, IronSourceConstants.INTERSTITIAL_DAILY_CAPPED);
            case 1:
            case 3:
                return new UnityBannerSize(320, 50);
            case 2:
                return z ? new UnityBannerSize(728, 90) : new UnityBannerSize(320, 50);
            default:
                return null;
        }
    }

    private BannerView getBannerView(IronSourceBannerLayout ironSourceBannerLayout, String str, BannerSmashListener bannerSmashListener) {
        if (this.mPlacementIdToBannerAd.get(str) != null) {
            this.mPlacementIdToBannerAd.get(str).destroy();
            this.mPlacementIdToBannerAd.remove(str);
        }
        BannerView bannerView = new BannerView(ContextProvider.getInstance().getCurrentActiveActivity(), str, getBannerSize(ironSourceBannerLayout.getSize(), AdapterUtils.isLargeScreen(ContextProvider.getInstance().getApplicationContext())));
        UnityAdsBannerListener unityAdsBannerListener = new UnityAdsBannerListener(this, bannerSmashListener, str);
        this.mPlacementIdToBannerListener.put(str, unityAdsBannerListener);
        bannerView.setListener(unityAdsBannerListener);
        this.mPlacementIdToBannerAd.put(str, bannerView);
        return bannerView;
    }

    /* access modifiers changed from: protected */
    public FrameLayout.LayoutParams createLayoutParams(UnityBannerSize unityBannerSize) {
        return new FrameLayout.LayoutParams(AdapterUtils.dpToPixels(ContextProvider.getInstance().getApplicationContext(), unityBannerSize.getWidth()), -2, 17);
    }

    private IronSourceError errorForUnsupportedAdapter(String str) {
        return ErrorBuilder.buildInitFailedError("UnityAds SDK version is not supported", str);
    }

    private int getUnityAdsInitializationErrorCode(UnityAds.UnityAdsInitializationError unityAdsInitializationError) {
        if (unityAdsInitializationError == null) {
            return 510;
        }
        for (UnityAds.UnityAdsInitializationError name : UnityAds.UnityAdsInitializationError.values()) {
            if (name.name().equalsIgnoreCase(unityAdsInitializationError.toString())) {
                return UnityAds.UnityAdsInitializationError.valueOf(unityAdsInitializationError.toString()).ordinal();
            }
        }
        return 510;
    }

    /* access modifiers changed from: protected */
    public int getUnityAdsLoadErrorCode(UnityAds.UnityAdsLoadError unityAdsLoadError) {
        if (unityAdsLoadError == null) {
            return 510;
        }
        for (UnityAds.UnityAdsLoadError name : UnityAds.UnityAdsLoadError.values()) {
            if (name.name().equalsIgnoreCase(unityAdsLoadError.toString())) {
                return UnityAds.UnityAdsLoadError.valueOf(unityAdsLoadError.toString()).ordinal();
            }
        }
        return 510;
    }

    /* access modifiers changed from: protected */
    public int getUnityAdsShowErrorCode(UnityAds.UnityAdsShowError unityAdsShowError) {
        if (unityAdsShowError == null) {
            return 510;
        }
        for (UnityAds.UnityAdsShowError name : UnityAds.UnityAdsShowError.values()) {
            if (name.name().equalsIgnoreCase(unityAdsShowError.toString())) {
                return UnityAds.UnityAdsShowError.valueOf(unityAdsShowError.toString()).ordinal();
            }
        }
        return 510;
    }

    public LoadWhileShowSupportState getLoadWhileShowSupportState(JSONObject jSONObject) {
        LoadWhileShowSupportState loadWhileShowSupportState = LoadWhileShowSupportState.LOAD_WHILE_SHOW_BY_INSTANCE;
        return (jSONObject == null || jSONObject.optBoolean("isSupportedLWS", true)) ? loadWhileShowSupportState : LoadWhileShowSupportState.NONE;
    }

    public void getAsyncToken() {
        IronLog.INTERNAL.verbose();
        UnityAds.getToken(new IUnityAdsTokenListener() {
            public void onUnityAdsTokenReady(String str) {
                IronLog.ADAPTER_CALLBACK.verbose("async token returned");
                String unused = UnityAdsAdapter.asyncToken = str;
            }
        });
    }
}
