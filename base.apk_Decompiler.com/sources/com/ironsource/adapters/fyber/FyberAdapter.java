package com.ironsource.adapters.fyber;

import android.content.Context;
import android.text.TextUtils;
import com.fyber.inneractive.sdk.external.BidTokenProvider;
import com.fyber.inneractive.sdk.external.InneractiveAdManager;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.external.InneractiveAdSpotManager;
import com.fyber.inneractive.sdk.external.InneractiveAdViewUnitController;
import com.fyber.inneractive.sdk.external.InneractiveFullscreenUnitController;
import com.fyber.inneractive.sdk.external.InneractiveFullscreenVideoContentController;
import com.fyber.inneractive.sdk.external.OnFyberMarketplaceInitializedListener;
import com.ironsource.adapters.ironsource.IronSourceAdapter;
import com.ironsource.environment.ContextProvider;
import com.ironsource.mediationsdk.AbstractAdapter;
import com.ironsource.mediationsdk.INetworkInitCallbackListener;
import com.ironsource.mediationsdk.IntegrationData;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.IronSourceBannerLayout;
import com.ironsource.mediationsdk.LoadWhileShowSupportState;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.metadata.MetaData;
import com.ironsource.mediationsdk.metadata.MetaDataUtils;
import com.ironsource.mediationsdk.sdk.BannerSmashListener;
import com.ironsource.mediationsdk.sdk.InterstitialSmashListener;
import com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class FyberAdapter extends AbstractAdapter implements INetworkInitCallbackListener {
    private static final String GitHash = "9c1c1bb07";
    private static final String META_DATA_DT_COPPA_KEY = "DT_COPPA";
    private static final String META_DATA_DT_IS_CHILD_KEY = "DT_IsChild";
    private static final String VERSION = "4.3.28";
    /* access modifiers changed from: private */
    public static HashSet<INetworkInitCallbackListener> initCallbackListeners = new HashSet<>();
    /* access modifiers changed from: private */
    public static Boolean mCCPA;
    /* access modifiers changed from: private */
    public static Boolean mConsent;
    private static Boolean mDTCOPPA;
    /* access modifiers changed from: private */
    public static boolean mDTIsChild;
    /* access modifiers changed from: private */
    public static InitState mInitState = InitState.INIT_STATE_NONE;
    /* access modifiers changed from: private */
    public static String mUserId;
    /* access modifiers changed from: private */
    public static AtomicBoolean mWasInitCalled = new AtomicBoolean(false);
    private final String APP_ID = "appId";
    private final String MEDIATION_NAME = IronSourceConstants.IRONSOURCE_CONFIG_NAME;
    private final String SPOT_ID = "adSpotId";
    protected InneractiveAdViewUnitController mInneractiveAdViewUnitController;
    protected ConcurrentHashMap<String, Boolean> mInterstitialAdsAvailability;
    protected ConcurrentHashMap<String, Boolean> mRewardedVideoAdsAvailability;
    private CopyOnWriteArraySet<String> mRewardedVideoSpotIdsForInitCallbacks;
    /* access modifiers changed from: private */
    public ConcurrentHashMap<String, InneractiveAdSpot> mSpotIdToBannerAd;
    /* access modifiers changed from: private */
    public ConcurrentHashMap<String, FyberBannerAdListener> mSpotIdToBannerFyberAdListener;
    protected ConcurrentHashMap<String, IronSourceBannerLayout> mSpotIdToBannerLayout;
    private ConcurrentHashMap<String, BannerSmashListener> mSpotIdToBannerSmashListener;
    /* access modifiers changed from: private */
    public ConcurrentHashMap<String, InneractiveAdSpot> mSpotIdToInterstitialAd;
    /* access modifiers changed from: private */
    public ConcurrentHashMap<String, FyberInterstitialAdListener> mSpotIdToInterstitialFyberAdListener;
    private ConcurrentHashMap<String, InterstitialSmashListener> mSpotIdToInterstitialSmashListener;
    /* access modifiers changed from: private */
    public ConcurrentHashMap<String, InneractiveAdSpot> mSpotIdToRewardedVideoAd;
    /* access modifiers changed from: private */
    public ConcurrentHashMap<String, FyberRewardedVideoAdListener> mSpotIdToRewardedVideoFyberAdListener;
    private ConcurrentHashMap<String, RewardedVideoSmashListener> mSpotIdToRewardedVideoSmashListener;

    private enum InitState {
        INIT_STATE_NONE,
        INIT_STATE_IN_PROGRESS,
        INIT_STATE_SUCCESS,
        INIT_STATE_FAILED
    }

    public String getVersion() {
        return "4.3.28";
    }

    public boolean isUsingActivityBeforeImpression(IronSource.AD_UNIT ad_unit) {
        return false;
    }

    public static FyberAdapter startAdapter(String str) {
        return new FyberAdapter(str);
    }

    private FyberAdapter(String str) {
        super(str);
        IronLog.INTERNAL.verbose();
        this.mSpotIdToRewardedVideoAd = new ConcurrentHashMap<>();
        this.mSpotIdToRewardedVideoSmashListener = new ConcurrentHashMap<>();
        this.mSpotIdToRewardedVideoFyberAdListener = new ConcurrentHashMap<>();
        this.mRewardedVideoSpotIdsForInitCallbacks = new CopyOnWriteArraySet<>();
        this.mRewardedVideoAdsAvailability = new ConcurrentHashMap<>();
        this.mSpotIdToInterstitialAd = new ConcurrentHashMap<>();
        this.mSpotIdToInterstitialSmashListener = new ConcurrentHashMap<>();
        this.mSpotIdToInterstitialFyberAdListener = new ConcurrentHashMap<>();
        this.mInterstitialAdsAvailability = new ConcurrentHashMap<>();
        this.mSpotIdToBannerAd = new ConcurrentHashMap<>();
        this.mSpotIdToBannerSmashListener = new ConcurrentHashMap<>();
        this.mSpotIdToBannerFyberAdListener = new ConcurrentHashMap<>();
        this.mSpotIdToBannerLayout = new ConcurrentHashMap<>();
        this.mLWSSupportState = LoadWhileShowSupportState.LOAD_WHILE_SHOW_BY_INSTANCE;
    }

    public static IntegrationData getIntegrationData(Context context) {
        return new IntegrationData("Fyber", "4.3.28");
    }

    public String getCoreSDKVersion() {
        return getAdapterSDKVersion();
    }

    public static String getAdapterSDKVersion() {
        return InneractiveAdManager.getVersion();
    }

    private void initSDK(final String str, final String str2) {
        postOnUIThread(new Runnable() {
            public void run() {
                if (FyberAdapter.mInitState == InitState.INIT_STATE_NONE || FyberAdapter.mInitState == InitState.INIT_STATE_IN_PROGRESS) {
                    FyberAdapter.initCallbackListeners.add(FyberAdapter.this);
                }
                if (FyberAdapter.mWasInitCalled.compareAndSet(false, true)) {
                    IronLog ironLog = IronLog.ADAPTER_API;
                    ironLog.verbose("appId = " + str);
                    InitState unused = FyberAdapter.mInitState = InitState.INIT_STATE_IN_PROGRESS;
                    String unused2 = FyberAdapter.mUserId = str2;
                    FyberAdapter.this.setIsChildValue(FyberAdapter.mDTIsChild);
                    InneractiveAdManager.initialize(ContextProvider.getInstance().getApplicationContext(), str, new OnFyberMarketplaceInitializedListener() {
                        public void onFyberMarketplaceInitialized(OnFyberMarketplaceInitializedListener.FyberInitStatus fyberInitStatus) {
                            if (fyberInitStatus == OnFyberMarketplaceInitializedListener.FyberInitStatus.SUCCESSFULLY) {
                                FyberAdapter.this.initializationSuccess();
                            } else {
                                FyberAdapter.this.initializationFailure();
                            }
                        }
                    });
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void initializationSuccess() {
        IronLog.ADAPTER_CALLBACK.verbose();
        mInitState = InitState.INIT_STATE_SUCCESS;
        if (!TextUtils.isEmpty(mUserId)) {
            IronLog ironLog = IronLog.INTERNAL;
            ironLog.verbose("setUserID to " + mUserId);
            InneractiveAdManager.setUserId(mUserId);
        }
        Boolean bool = mConsent;
        if (bool != null) {
            setConsent(bool.booleanValue());
        }
        Boolean bool2 = mCCPA;
        if (bool2 != null) {
            setCCPAValue(bool2.booleanValue());
        }
        Boolean bool3 = mDTCOPPA;
        if (bool3 != null) {
            setCOPPAValue(bool3.booleanValue());
        }
        Iterator<INetworkInitCallbackListener> it = initCallbackListeners.iterator();
        while (it.hasNext()) {
            it.next().onNetworkInitCallbackSuccess();
        }
        initCallbackListeners.clear();
    }

    /* access modifiers changed from: private */
    public void initializationFailure() {
        IronLog.ADAPTER_CALLBACK.verbose();
        mInitState = InitState.INIT_STATE_FAILED;
        Iterator<INetworkInitCallbackListener> it = initCallbackListeners.iterator();
        while (it.hasNext()) {
            it.next().onNetworkInitCallbackFailed("Fyber sdk init failed");
        }
        initCallbackListeners.clear();
    }

    public void onNetworkInitCallbackSuccess() {
        for (String next : this.mSpotIdToRewardedVideoSmashListener.keySet()) {
            RewardedVideoSmashListener rewardedVideoSmashListener = this.mSpotIdToRewardedVideoSmashListener.get(next);
            if (this.mRewardedVideoSpotIdsForInitCallbacks.contains(next)) {
                rewardedVideoSmashListener.onRewardedVideoInitSuccess();
            } else {
                loadRewardedVideoInternal(next, (String) null, rewardedVideoSmashListener);
            }
        }
        for (InterstitialSmashListener onInterstitialInitSuccess : this.mSpotIdToInterstitialSmashListener.values()) {
            onInterstitialInitSuccess.onInterstitialInitSuccess();
        }
        for (BannerSmashListener onBannerInitSuccess : this.mSpotIdToBannerSmashListener.values()) {
            onBannerInitSuccess.onBannerInitSuccess();
        }
    }

    public void onNetworkInitCallbackFailed(String str) {
        for (String next : this.mSpotIdToRewardedVideoSmashListener.keySet()) {
            RewardedVideoSmashListener rewardedVideoSmashListener = this.mSpotIdToRewardedVideoSmashListener.get(next);
            if (this.mRewardedVideoSpotIdsForInitCallbacks.contains(next)) {
                rewardedVideoSmashListener.onRewardedVideoInitFailed(ErrorBuilder.buildInitFailedError(str, IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
            } else {
                rewardedVideoSmashListener.onRewardedVideoAvailabilityChanged(false);
            }
        }
        for (InterstitialSmashListener onInterstitialInitFailed : this.mSpotIdToInterstitialSmashListener.values()) {
            onInterstitialInitFailed.onInterstitialInitFailed(ErrorBuilder.buildInitFailedError(str, "Interstitial"));
        }
        for (BannerSmashListener onBannerInitFailed : this.mSpotIdToBannerSmashListener.values()) {
            onBannerInitFailed.onBannerInitFailed(ErrorBuilder.buildInitFailedError(str, "Banner"));
        }
    }

    public void initRewardedVideoWithCallback(String str, String str2, JSONObject jSONObject, RewardedVideoSmashListener rewardedVideoSmashListener) {
        String optString = jSONObject.optString("appId");
        String optString2 = jSONObject.optString("adSpotId");
        if (TextUtils.isEmpty(optString)) {
            IronLog.INTERNAL.error("Missing param - appId");
            rewardedVideoSmashListener.onRewardedVideoInitFailed(ErrorBuilder.buildInitFailedError("Missing param - appId", IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
        } else if (TextUtils.isEmpty(optString2)) {
            IronLog.INTERNAL.error("Missing param - adSpotId");
            rewardedVideoSmashListener.onRewardedVideoInitFailed(ErrorBuilder.buildInitFailedError("Missing params - adSpotId", IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
        } else {
            IronLog ironLog = IronLog.ADAPTER_API;
            ironLog.verbose("spotId = " + optString2);
            this.mSpotIdToRewardedVideoSmashListener.put(optString2, rewardedVideoSmashListener);
            this.mRewardedVideoSpotIdsForInitCallbacks.add(optString2);
            int i = AnonymousClass10.$SwitchMap$com$ironsource$adapters$fyber$FyberAdapter$InitState[mInitState.ordinal()];
            if (i == 1 || i == 2) {
                initSDK(optString, str2);
            } else if (i == 3) {
                rewardedVideoSmashListener.onRewardedVideoInitSuccess();
            } else if (i == 4) {
                IronLog ironLog2 = IronLog.INTERNAL;
                ironLog2.verbose("init failed - spotId = " + optString2);
                rewardedVideoSmashListener.onRewardedVideoInitFailed(ErrorBuilder.buildInitFailedError("Fyber sdk init failed", IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
            }
        }
    }

    /* renamed from: com.ironsource.adapters.fyber.FyberAdapter$10  reason: invalid class name */
    static /* synthetic */ class AnonymousClass10 {
        static final /* synthetic */ int[] $SwitchMap$com$ironsource$adapters$fyber$FyberAdapter$InitState;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.ironsource.adapters.fyber.FyberAdapter$InitState[] r0 = com.ironsource.adapters.fyber.FyberAdapter.InitState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$ironsource$adapters$fyber$FyberAdapter$InitState = r0
                com.ironsource.adapters.fyber.FyberAdapter$InitState r1 = com.ironsource.adapters.fyber.FyberAdapter.InitState.INIT_STATE_NONE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$ironsource$adapters$fyber$FyberAdapter$InitState     // Catch:{ NoSuchFieldError -> 0x001d }
                com.ironsource.adapters.fyber.FyberAdapter$InitState r1 = com.ironsource.adapters.fyber.FyberAdapter.InitState.INIT_STATE_IN_PROGRESS     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$ironsource$adapters$fyber$FyberAdapter$InitState     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.ironsource.adapters.fyber.FyberAdapter$InitState r1 = com.ironsource.adapters.fyber.FyberAdapter.InitState.INIT_STATE_SUCCESS     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$ironsource$adapters$fyber$FyberAdapter$InitState     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.ironsource.adapters.fyber.FyberAdapter$InitState r1 = com.ironsource.adapters.fyber.FyberAdapter.InitState.INIT_STATE_FAILED     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ironsource.adapters.fyber.FyberAdapter.AnonymousClass10.<clinit>():void");
        }
    }

    public void initAndLoadRewardedVideo(String str, String str2, JSONObject jSONObject, JSONObject jSONObject2, RewardedVideoSmashListener rewardedVideoSmashListener) {
        String optString = jSONObject.optString("appId");
        String optString2 = jSONObject.optString("adSpotId");
        if (TextUtils.isEmpty(optString)) {
            IronLog.INTERNAL.error("Missing param - appId");
            rewardedVideoSmashListener.onRewardedVideoAvailabilityChanged(false);
        } else if (TextUtils.isEmpty(optString2)) {
            IronLog.INTERNAL.error("Missing param - adSpotId");
            rewardedVideoSmashListener.onRewardedVideoAvailabilityChanged(false);
        } else {
            IronLog ironLog = IronLog.ADAPTER_API;
            ironLog.verbose("spotId = " + optString2);
            this.mSpotIdToRewardedVideoSmashListener.put(optString2, rewardedVideoSmashListener);
            int i = AnonymousClass10.$SwitchMap$com$ironsource$adapters$fyber$FyberAdapter$InitState[mInitState.ordinal()];
            if (i == 1 || i == 2) {
                initSDK(optString, str2);
            } else if (i == 3) {
                loadRewardedVideoInternal(optString2, (String) null, rewardedVideoSmashListener);
            } else if (i == 4) {
                IronLog ironLog2 = IronLog.INTERNAL;
                ironLog2.verbose("init failed - spotId = " + optString2);
                rewardedVideoSmashListener.onRewardedVideoAvailabilityChanged(false);
            }
        }
    }

    public void loadRewardedVideoForBidding(JSONObject jSONObject, JSONObject jSONObject2, String str, RewardedVideoSmashListener rewardedVideoSmashListener) {
        loadRewardedVideoInternal(jSONObject.optString("adSpotId"), str, rewardedVideoSmashListener);
    }

    public void loadRewardedVideo(JSONObject jSONObject, JSONObject jSONObject2, RewardedVideoSmashListener rewardedVideoSmashListener) {
        loadRewardedVideoInternal(jSONObject.optString("adSpotId"), (String) null, rewardedVideoSmashListener);
    }

    private void loadRewardedVideoInternal(final String str, final String str2, final RewardedVideoSmashListener rewardedVideoSmashListener) {
        IronLog ironLog = IronLog.ADAPTER_API;
        ironLog.verbose("spotId = " + str);
        postOnUIThread(new Runnable() {
            public void run() {
                InneractiveAdSpot inneractiveAdSpot = (InneractiveAdSpot) FyberAdapter.this.mSpotIdToRewardedVideoAd.get(str);
                if (inneractiveAdSpot != null) {
                    inneractiveAdSpot.destroy();
                    FyberAdapter.this.mSpotIdToRewardedVideoAd.remove(str);
                }
                InneractiveAdSpot createSpot = InneractiveAdSpotManager.get().createSpot();
                createSpot.addUnitController(new InneractiveFullscreenUnitController());
                FyberAdapter.this.setMediationData(createSpot);
                FyberRewardedVideoAdListener fyberRewardedVideoAdListener = new FyberRewardedVideoAdListener(FyberAdapter.this, rewardedVideoSmashListener, str);
                FyberAdapter.this.mSpotIdToRewardedVideoFyberAdListener.put(str, fyberRewardedVideoAdListener);
                createSpot.setRequestListener(fyberRewardedVideoAdListener);
                FyberAdapter.this.mSpotIdToRewardedVideoAd.put(str, createSpot);
                String str = str2;
                if (str == null) {
                    createSpot.requestAd(new InneractiveAdRequest(str));
                } else {
                    createSpot.loadAd(str);
                }
            }
        });
    }

    public void showRewardedVideo(final JSONObject jSONObject, final RewardedVideoSmashListener rewardedVideoSmashListener) {
        final String optString = jSONObject.optString("adSpotId");
        IronLog ironLog = IronLog.ADAPTER_API;
        ironLog.verbose("spotId = " + optString);
        postOnUIThread(new Runnable() {
            public void run() {
                if (!TextUtils.isEmpty(FyberAdapter.this.getDynamicUserId())) {
                    IronLog ironLog = IronLog.INTERNAL;
                    ironLog.verbose("setUserID to " + FyberAdapter.this.getDynamicUserId());
                    InneractiveAdManager.setUserId(FyberAdapter.this.getDynamicUserId());
                }
                InneractiveAdSpot inneractiveAdSpot = (InneractiveAdSpot) FyberAdapter.this.mSpotIdToRewardedVideoAd.get(optString);
                if (inneractiveAdSpot == null || !FyberAdapter.this.isRewardedVideoAvailable(jSONObject) || !inneractiveAdSpot.isReady()) {
                    rewardedVideoSmashListener.onRewardedVideoAdShowFailed(ErrorBuilder.buildNoAdsToShowError(IronSourceConstants.REWARDED_VIDEO_AD_UNIT));
                } else {
                    InneractiveFullscreenUnitController inneractiveFullscreenUnitController = (InneractiveFullscreenUnitController) inneractiveAdSpot.getSelectedUnitController();
                    FyberRewardedVideoAdListener fyberRewardedVideoAdListener = (FyberRewardedVideoAdListener) FyberAdapter.this.mSpotIdToRewardedVideoFyberAdListener.get(optString);
                    inneractiveFullscreenUnitController.setRewardedListener(fyberRewardedVideoAdListener);
                    inneractiveFullscreenUnitController.setEventsListener(fyberRewardedVideoAdListener);
                    InneractiveFullscreenVideoContentController inneractiveFullscreenVideoContentController = new InneractiveFullscreenVideoContentController();
                    inneractiveFullscreenVideoContentController.setEventsListener(fyberRewardedVideoAdListener);
                    inneractiveFullscreenUnitController.addContentController(inneractiveFullscreenVideoContentController);
                    inneractiveFullscreenUnitController.show(ContextProvider.getInstance().getCurrentActiveActivity());
                }
                FyberAdapter.this.mRewardedVideoAdsAvailability.put(optString, false);
            }
        });
    }

    public boolean isRewardedVideoAvailable(JSONObject jSONObject) {
        String optString = jSONObject.optString("adSpotId");
        IronLog ironLog = IronLog.ADAPTER_API;
        ironLog.verbose("spotId = " + optString);
        return this.mRewardedVideoAdsAvailability.containsKey(optString) && this.mRewardedVideoAdsAvailability.get(optString).booleanValue();
    }

    public Map<String, Object> getRewardedVideoBiddingData(JSONObject jSONObject, JSONObject jSONObject2) {
        return getBiddingData();
    }

    public void initInterstitialForBidding(String str, String str2, JSONObject jSONObject, InterstitialSmashListener interstitialSmashListener) {
        initInterstitial(str, str2, jSONObject, interstitialSmashListener);
    }

    public void initInterstitial(String str, String str2, JSONObject jSONObject, InterstitialSmashListener interstitialSmashListener) {
        String optString = jSONObject.optString("appId");
        String optString2 = jSONObject.optString("adSpotId");
        if (TextUtils.isEmpty(optString)) {
            IronLog.INTERNAL.error("missing param - appId");
            interstitialSmashListener.onInterstitialInitFailed(ErrorBuilder.buildInitFailedError("Missing param - appId", "Interstitial"));
        } else if (TextUtils.isEmpty(optString2)) {
            IronLog.INTERNAL.error("missing param - adSpotId");
            interstitialSmashListener.onInterstitialInitFailed(ErrorBuilder.buildInitFailedError("Missing params - adSpotId", "Interstitial"));
        } else {
            IronLog ironLog = IronLog.ADAPTER_API;
            ironLog.verbose("spotId = " + optString2);
            this.mSpotIdToInterstitialSmashListener.put(optString2, interstitialSmashListener);
            int i = AnonymousClass10.$SwitchMap$com$ironsource$adapters$fyber$FyberAdapter$InitState[mInitState.ordinal()];
            if (i == 1 || i == 2) {
                initSDK(optString, str2);
            } else if (i == 3) {
                interstitialSmashListener.onInterstitialInitSuccess();
            } else if (i == 4) {
                IronLog ironLog2 = IronLog.INTERNAL;
                ironLog2.verbose("init failed - spotId = " + optString2);
                interstitialSmashListener.onInterstitialInitFailed(ErrorBuilder.buildInitFailedError("Fyber sdk init failed", "Interstitial"));
            }
        }
    }

    public void loadInterstitialForBidding(JSONObject jSONObject, JSONObject jSONObject2, String str, InterstitialSmashListener interstitialSmashListener) {
        loadInterstitialInternal(jSONObject.optString("adSpotId"), str, interstitialSmashListener);
    }

    public void loadInterstitial(JSONObject jSONObject, JSONObject jSONObject2, InterstitialSmashListener interstitialSmashListener) {
        loadInterstitialInternal(jSONObject.optString("adSpotId"), (String) null, interstitialSmashListener);
    }

    private void loadInterstitialInternal(final String str, final String str2, final InterstitialSmashListener interstitialSmashListener) {
        IronLog ironLog = IronLog.ADAPTER_API;
        ironLog.verbose("spotId = " + str);
        postOnUIThread(new Runnable() {
            public void run() {
                InneractiveAdSpot inneractiveAdSpot = (InneractiveAdSpot) FyberAdapter.this.mSpotIdToInterstitialAd.get(str);
                if (inneractiveAdSpot != null) {
                    IronLog ironLog = IronLog.ADAPTER_API;
                    ironLog.verbose("destroying previous ad with spotId " + str);
                    inneractiveAdSpot.destroy();
                    FyberAdapter.this.mSpotIdToInterstitialAd.remove(str);
                }
                InneractiveAdSpot createSpot = InneractiveAdSpotManager.get().createSpot();
                createSpot.addUnitController(new InneractiveFullscreenUnitController());
                FyberAdapter.this.setMediationData(createSpot);
                FyberInterstitialAdListener fyberInterstitialAdListener = new FyberInterstitialAdListener(FyberAdapter.this, interstitialSmashListener, str);
                FyberAdapter.this.mSpotIdToInterstitialFyberAdListener.put(str, fyberInterstitialAdListener);
                createSpot.setRequestListener(fyberInterstitialAdListener);
                FyberAdapter.this.mSpotIdToInterstitialAd.put(str, createSpot);
                String str = str2;
                if (str == null) {
                    createSpot.requestAd(new InneractiveAdRequest(str));
                } else {
                    createSpot.loadAd(str);
                }
            }
        });
    }

    public void showInterstitial(final JSONObject jSONObject, final InterstitialSmashListener interstitialSmashListener) {
        final String optString = jSONObject.optString("adSpotId");
        IronLog ironLog = IronLog.ADAPTER_API;
        ironLog.verbose("spotId = " + optString);
        postOnUIThread(new Runnable() {
            public void run() {
                InneractiveAdSpot inneractiveAdSpot = (InneractiveAdSpot) FyberAdapter.this.mSpotIdToInterstitialAd.get(optString);
                if (inneractiveAdSpot == null || !FyberAdapter.this.isInterstitialReady(jSONObject) || !inneractiveAdSpot.isReady()) {
                    interstitialSmashListener.onInterstitialAdShowFailed(ErrorBuilder.buildNoAdsToShowError("Interstitial"));
                } else {
                    InneractiveFullscreenUnitController inneractiveFullscreenUnitController = (InneractiveFullscreenUnitController) inneractiveAdSpot.getSelectedUnitController();
                    inneractiveFullscreenUnitController.setEventsListener((FyberInterstitialAdListener) FyberAdapter.this.mSpotIdToInterstitialFyberAdListener.get(optString));
                    inneractiveFullscreenUnitController.addContentController(new InneractiveFullscreenVideoContentController());
                    IronLog.ADAPTER_API.verbose("showInterstitial - show");
                    inneractiveFullscreenUnitController.show(ContextProvider.getInstance().getCurrentActiveActivity());
                }
                FyberAdapter.this.mInterstitialAdsAvailability.put(optString, false);
            }
        });
    }

    public boolean isInterstitialReady(JSONObject jSONObject) {
        String optString = jSONObject.optString("adSpotId");
        IronLog ironLog = IronLog.ADAPTER_API;
        ironLog.verbose("spotId = " + optString);
        return this.mInterstitialAdsAvailability.containsKey(optString) && this.mInterstitialAdsAvailability.get(optString).booleanValue();
    }

    public Map<String, Object> getInterstitialBiddingData(JSONObject jSONObject, JSONObject jSONObject2) {
        return getBiddingData();
    }

    public void initBannerForBidding(String str, String str2, JSONObject jSONObject, BannerSmashListener bannerSmashListener) {
        initBanners(str, str2, jSONObject, bannerSmashListener);
    }

    public void initBanners(String str, String str2, JSONObject jSONObject, BannerSmashListener bannerSmashListener) {
        String optString = jSONObject.optString("appId");
        String optString2 = jSONObject.optString("adSpotId");
        if (TextUtils.isEmpty(optString)) {
            IronLog.INTERNAL.error("missing param - appId");
            bannerSmashListener.onBannerInitFailed(ErrorBuilder.buildInitFailedError("Missing param - appId", "Banner"));
        } else if (TextUtils.isEmpty(optString2)) {
            IronLog.INTERNAL.error("missing param - adSpotId");
            bannerSmashListener.onBannerInitFailed(ErrorBuilder.buildInitFailedError("Missing params - adSpotId", "Banner"));
        } else {
            IronLog ironLog = IronLog.ADAPTER_API;
            ironLog.verbose("spotId = " + optString2);
            this.mSpotIdToBannerSmashListener.put(optString2, bannerSmashListener);
            int i = AnonymousClass10.$SwitchMap$com$ironsource$adapters$fyber$FyberAdapter$InitState[mInitState.ordinal()];
            if (i == 1 || i == 2) {
                initSDK(optString, str2);
            } else if (i == 3) {
                bannerSmashListener.onBannerInitSuccess();
            } else if (i == 4) {
                IronLog ironLog2 = IronLog.INTERNAL;
                ironLog2.verbose("init failed - spotId = " + optString2);
                bannerSmashListener.onBannerInitFailed(ErrorBuilder.buildInitFailedError("Fyber sdk init failed", "Banner"));
            }
        }
    }

    public void loadBannerForBidding(JSONObject jSONObject, JSONObject jSONObject2, String str, IronSourceBannerLayout ironSourceBannerLayout, BannerSmashListener bannerSmashListener) {
        loadBannerInternal(jSONObject.optString("adSpotId"), ironSourceBannerLayout, bannerSmashListener, str);
    }

    public void loadBanner(JSONObject jSONObject, JSONObject jSONObject2, IronSourceBannerLayout ironSourceBannerLayout, BannerSmashListener bannerSmashListener) {
        loadBannerInternal(jSONObject.optString("adSpotId"), ironSourceBannerLayout, bannerSmashListener, (String) null);
    }

    private void loadBannerInternal(String str, IronSourceBannerLayout ironSourceBannerLayout, BannerSmashListener bannerSmashListener, String str2) {
        IronLog ironLog = IronLog.ADAPTER_API;
        ironLog.verbose("spotId = " + str);
        final IronSourceBannerLayout ironSourceBannerLayout2 = ironSourceBannerLayout;
        final BannerSmashListener bannerSmashListener2 = bannerSmashListener;
        final String str3 = str;
        final String str4 = str2;
        postOnUIThread(new Runnable() {
            public void run() {
                IronSourceBannerLayout ironSourceBannerLayout = ironSourceBannerLayout2;
                if (ironSourceBannerLayout == null || ironSourceBannerLayout.isDestroyed()) {
                    bannerSmashListener2.onBannerAdLoadFailed(ErrorBuilder.buildLoadFailedError("Fyber loadBanner - banner ".concat(ironSourceBannerLayout2 == null ? "layout is null" : "is destroyed")));
                    return;
                }
                FyberAdapter.this.mSpotIdToBannerLayout.put(str3, ironSourceBannerLayout2);
                InneractiveAdSpot createSpot = InneractiveAdSpotManager.get().createSpot();
                FyberAdapter.this.setMediationData(createSpot);
                FyberAdapter.this.mInneractiveAdViewUnitController = new InneractiveAdViewUnitController();
                createSpot.addUnitController(FyberAdapter.this.mInneractiveAdViewUnitController);
                FyberBannerAdListener fyberBannerAdListener = new FyberBannerAdListener(FyberAdapter.this, bannerSmashListener2, str3);
                FyberAdapter.this.mSpotIdToBannerFyberAdListener.put(str3, fyberBannerAdListener);
                createSpot.setRequestListener(fyberBannerAdListener);
                FyberAdapter.this.mInneractiveAdViewUnitController.setEventsListener(fyberBannerAdListener);
                FyberAdapter.this.mSpotIdToBannerAd.put(str3, createSpot);
                String str = str4;
                if (str == null) {
                    createSpot.requestAd(new InneractiveAdRequest(str3));
                } else {
                    createSpot.loadAd(str);
                }
            }
        });
    }

    public void destroyBanner(JSONObject jSONObject) {
        final String optString = jSONObject.optString("adSpotId");
        IronLog ironLog = IronLog.ADAPTER_API;
        ironLog.verbose("spotId = " + optString);
        postOnUIThread(new Runnable() {
            public void run() {
                InneractiveAdSpot inneractiveAdSpot = (InneractiveAdSpot) FyberAdapter.this.mSpotIdToBannerAd.get(optString);
                if (inneractiveAdSpot != null) {
                    IronLog ironLog = IronLog.ADAPTER_API;
                    ironLog.verbose("destroying previous ad with spotId " + optString);
                    inneractiveAdSpot.destroy();
                    FyberAdapter.this.mSpotIdToBannerAd.remove(optString);
                }
            }
        });
    }

    public Map<String, Object> getBannerBiddingData(JSONObject jSONObject, JSONObject jSONObject2) {
        return getBiddingData();
    }

    /* access modifiers changed from: protected */
    public void setConsent(final boolean z) {
        postOnUIThread(new Runnable() {
            public void run() {
                if (FyberAdapter.mWasInitCalled.get()) {
                    IronLog ironLog = IronLog.ADAPTER_API;
                    ironLog.verbose("setConsent - consent = " + z);
                    InneractiveAdManager.setGdprConsent(z);
                    return;
                }
                Boolean unused = FyberAdapter.mConsent = Boolean.valueOf(z);
            }
        });
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
            if (MetaDataUtils.isValidMetaData(str, META_DATA_DT_IS_CHILD_KEY, formatValueForType)) {
                setIsChildValue(MetaDataUtils.getMetaDataBooleanValue(formatValueForType));
            } else if (MetaDataUtils.isValidMetaData(str, META_DATA_DT_COPPA_KEY, formatValueForType)) {
                setCOPPAValue(MetaDataUtils.getMetaDataBooleanValue(formatValueForType));
            }
        }
    }

    /* access modifiers changed from: private */
    public void setIsChildValue(boolean z) {
        if (mInitState == InitState.INIT_STATE_NONE) {
            mDTIsChild = z;
        } else if (mInitState == InitState.INIT_STATE_IN_PROGRESS && z) {
            IronLog.ADAPTER_API.verbose("calling InneractiveAdManager.currentAudienceIsAChild");
            InneractiveAdManager.currentAudienceIsAChild();
        }
    }

    private void setCOPPAValue(boolean z) {
        if (!z) {
            return;
        }
        if (mInitState == InitState.INIT_STATE_SUCCESS) {
            IronLog.ADAPTER_API.verbose("calling InneractiveAdManager.currentAudienceAppliesToCoppa");
            InneractiveAdManager.currentAudienceAppliesToCoppa();
            return;
        }
        mDTCOPPA = Boolean.valueOf(z);
    }

    private void setCCPAValue(final boolean z) {
        postOnUIThread(new Runnable() {
            public void run() {
                if (FyberAdapter.mWasInitCalled.get()) {
                    String str = "1YY-";
                    IronLog.ADAPTER_API.verbose("setCCPAValue - value = ".concat(z ? str : "1YN-"));
                    if (!z) {
                        str = "1YN-";
                    }
                    InneractiveAdManager.setUSPrivacyString(str);
                    return;
                }
                Boolean unused = FyberAdapter.mCCPA = Boolean.valueOf(z);
            }
        });
    }

    public void releaseMemory(IronSource.AD_UNIT ad_unit, JSONObject jSONObject) {
        if (ad_unit == IronSource.AD_UNIT.REWARDED_VIDEO) {
            for (InneractiveAdSpot destroy : this.mSpotIdToRewardedVideoAd.values()) {
                destroy.destroy();
            }
            this.mSpotIdToRewardedVideoAd.clear();
            this.mSpotIdToRewardedVideoSmashListener.clear();
            this.mSpotIdToRewardedVideoFyberAdListener.clear();
            this.mRewardedVideoAdsAvailability.clear();
            this.mRewardedVideoSpotIdsForInitCallbacks.clear();
        } else if (ad_unit == IronSource.AD_UNIT.INTERSTITIAL) {
            for (InneractiveAdSpot destroy2 : this.mSpotIdToInterstitialAd.values()) {
                destroy2.destroy();
            }
            this.mSpotIdToInterstitialAd.clear();
            this.mSpotIdToInterstitialSmashListener.clear();
            this.mSpotIdToInterstitialFyberAdListener.clear();
            this.mInterstitialAdsAvailability.clear();
        } else if (ad_unit == IronSource.AD_UNIT.BANNER) {
            for (InneractiveAdSpot destroy3 : this.mSpotIdToBannerAd.values()) {
                destroy3.destroy();
            }
            this.mSpotIdToBannerAd.clear();
            this.mSpotIdToBannerLayout.clear();
            this.mSpotIdToBannerSmashListener.clear();
            this.mSpotIdToBannerFyberAdListener.clear();
        }
    }

    private Map<String, Object> getBiddingData() {
        if (mInitState != InitState.INIT_STATE_SUCCESS) {
            IronLog.INTERNAL.verbose("returning null as token since init did not finish");
            return null;
        }
        String bidderToken = BidTokenProvider.getBidderToken();
        if (TextUtils.isEmpty(bidderToken)) {
            bidderToken = "";
        }
        IronLog ironLog = IronLog.ADAPTER_API;
        ironLog.verbose("token = " + bidderToken);
        HashMap hashMap = new HashMap();
        hashMap.put(IronSourceAdapter.IRONSOURCE_BIDDING_TOKEN_KEY, bidderToken);
        return hashMap;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0046, code lost:
        if (r6.equals(com.ironsource.mediationsdk.l.c) == false) goto L_0x0028;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.widget.FrameLayout.LayoutParams calculateLayoutParams(com.ironsource.mediationsdk.ISBannerSize r6) {
        /*
            r5 = this;
            r0 = 0
            if (r6 != 0) goto L_0x000b
            com.ironsource.mediationsdk.logger.IronLog r6 = com.ironsource.mediationsdk.logger.IronLog.ADAPTER_API
            java.lang.String r1 = "bannerSize is null"
            r6.error(r1)
            return r0
        L_0x000b:
            android.widget.FrameLayout$LayoutParams r1 = new android.widget.FrameLayout$LayoutParams
            r2 = 0
            r1.<init>(r2, r2)
            com.ironsource.environment.ContextProvider r1 = com.ironsource.environment.ContextProvider.getInstance()
            android.content.Context r1 = r1.getApplicationContext()
            java.lang.String r6 = r6.getDescription()
            r6.hashCode()
            int r3 = r6.hashCode()
            r4 = -1
            switch(r3) {
                case -387072689: goto L_0x0040;
                case 79011241: goto L_0x0035;
                case 1951953708: goto L_0x002a;
                default: goto L_0x0028;
            }
        L_0x0028:
            r2 = -1
            goto L_0x0049
        L_0x002a:
            java.lang.String r2 = "BANNER"
            boolean r6 = r6.equals(r2)
            if (r6 != 0) goto L_0x0033
            goto L_0x0028
        L_0x0033:
            r2 = 2
            goto L_0x0049
        L_0x0035:
            java.lang.String r2 = "SMART"
            boolean r6 = r6.equals(r2)
            if (r6 != 0) goto L_0x003e
            goto L_0x0028
        L_0x003e:
            r2 = 1
            goto L_0x0049
        L_0x0040:
            java.lang.String r3 = "RECTANGLE"
            boolean r6 = r6.equals(r3)
            if (r6 != 0) goto L_0x0049
            goto L_0x0028
        L_0x0049:
            r6 = 50
            r3 = 320(0x140, float:4.48E-43)
            switch(r2) {
                case 0: goto L_0x0085;
                case 1: goto L_0x005f;
                case 2: goto L_0x0051;
                default: goto L_0x0050;
            }
        L_0x0050:
            return r0
        L_0x0051:
            android.widget.FrameLayout$LayoutParams r0 = new android.widget.FrameLayout$LayoutParams
            int r2 = com.ironsource.mediationsdk.AdapterUtils.dpToPixels(r1, r3)
            int r6 = com.ironsource.mediationsdk.AdapterUtils.dpToPixels(r1, r6)
            r0.<init>(r2, r6)
            goto L_0x0096
        L_0x005f:
            boolean r0 = com.ironsource.mediationsdk.AdapterUtils.isLargeScreen(r1)
            if (r0 == 0) goto L_0x0077
            android.widget.FrameLayout$LayoutParams r0 = new android.widget.FrameLayout$LayoutParams
            r6 = 728(0x2d8, float:1.02E-42)
            int r6 = com.ironsource.mediationsdk.AdapterUtils.dpToPixels(r1, r6)
            r2 = 90
            int r1 = com.ironsource.mediationsdk.AdapterUtils.dpToPixels(r1, r2)
            r0.<init>(r6, r1)
            goto L_0x0096
        L_0x0077:
            android.widget.FrameLayout$LayoutParams r0 = new android.widget.FrameLayout$LayoutParams
            int r2 = com.ironsource.mediationsdk.AdapterUtils.dpToPixels(r1, r3)
            int r6 = com.ironsource.mediationsdk.AdapterUtils.dpToPixels(r1, r6)
            r0.<init>(r2, r6)
            goto L_0x0096
        L_0x0085:
            android.widget.FrameLayout$LayoutParams r0 = new android.widget.FrameLayout$LayoutParams
            r6 = 300(0x12c, float:4.2E-43)
            int r6 = com.ironsource.mediationsdk.AdapterUtils.dpToPixels(r1, r6)
            r2 = 250(0xfa, float:3.5E-43)
            int r1 = com.ironsource.mediationsdk.AdapterUtils.dpToPixels(r1, r2)
            r0.<init>(r6, r1)
        L_0x0096:
            r6 = 17
            r0.gravity = r6
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.adapters.fyber.FyberAdapter.calculateLayoutParams(com.ironsource.mediationsdk.ISBannerSize):android.widget.FrameLayout$LayoutParams");
    }

    /* access modifiers changed from: private */
    public void setMediationData(InneractiveAdSpot inneractiveAdSpot) {
        inneractiveAdSpot.setMediationName(IronSourceConstants.IRONSOURCE_CONFIG_NAME);
        inneractiveAdSpot.setMediationVersion("4.3.28");
    }
}
