package com.ironsource.adapters.unityads;

import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.sdk.InterstitialSmashListener;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.unity3d.ads.IUnityAdsLoadListener;
import com.unity3d.ads.IUnityAdsShowListener;
import com.unity3d.ads.UnityAds;
import java.lang.ref.WeakReference;

final class UnityAdsInterstitialListener implements IUnityAdsLoadListener, IUnityAdsShowListener {
    private WeakReference<UnityAdsAdapter> mAdapter;
    private InterstitialSmashListener mListener;
    private String mPlacementId;

    UnityAdsInterstitialListener(UnityAdsAdapter unityAdsAdapter, InterstitialSmashListener interstitialSmashListener, String str) {
        this.mAdapter = new WeakReference<>(unityAdsAdapter);
        this.mPlacementId = str;
        this.mListener = interstitialSmashListener;
    }

    public void onUnityAdsAdLoaded(String str) {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose("placementId = " + this.mPlacementId);
        if (this.mListener == null) {
            IronLog.INTERNAL.verbose("listener is null");
            return;
        }
        WeakReference<UnityAdsAdapter> weakReference = this.mAdapter;
        if (weakReference == null || weakReference.get() == null) {
            IronLog.INTERNAL.verbose("adapter is null");
            return;
        }
        ((UnityAdsAdapter) this.mAdapter.get()).mInterstitialAdsAvailability.put(this.mPlacementId, true);
        this.mListener.onInterstitialAdReady();
    }

    public void onUnityAdsFailedToLoad(String str, UnityAds.UnityAdsLoadError unityAdsLoadError, String str2) {
        IronSourceError ironSourceError;
        if (this.mListener == null) {
            IronLog.INTERNAL.verbose("listener is null");
            return;
        }
        WeakReference<UnityAdsAdapter> weakReference = this.mAdapter;
        if (weakReference == null || weakReference.get() == null) {
            IronLog.INTERNAL.verbose("adapter is null");
            return;
        }
        if (unityAdsLoadError != null) {
            ironSourceError = new IronSourceError(unityAdsLoadError == UnityAds.UnityAdsLoadError.NO_FILL ? 1158 : ((UnityAdsAdapter) this.mAdapter.get()).getUnityAdsLoadErrorCode(unityAdsLoadError), str2);
        } else {
            ironSourceError = ErrorBuilder.buildLoadFailedError("Interstitial", ((UnityAdsAdapter) this.mAdapter.get()).getProviderName(), str2);
        }
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.error("placementId = " + this.mPlacementId + " ironSourceError = " + ironSourceError);
        this.mListener.onInterstitialAdLoadFailed(ironSourceError);
        ((UnityAdsAdapter) this.mAdapter.get()).mInterstitialAdsAvailability.put(this.mPlacementId, false);
    }

    public void onUnityAdsShowStart(String str) {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose("placementId = " + this.mPlacementId);
        InterstitialSmashListener interstitialSmashListener = this.mListener;
        if (interstitialSmashListener == null) {
            IronLog.INTERNAL.verbose("listener is null");
            return;
        }
        interstitialSmashListener.onInterstitialAdOpened();
        this.mListener.onInterstitialAdShowSucceeded();
    }

    public void onUnityAdsShowFailure(String str, UnityAds.UnityAdsShowError unityAdsShowError, String str2) {
        IronSourceError ironSourceError;
        if (this.mListener == null) {
            IronLog.INTERNAL.verbose("listener is null");
            return;
        }
        WeakReference<UnityAdsAdapter> weakReference = this.mAdapter;
        if (weakReference == null || weakReference.get() == null) {
            IronLog.INTERNAL.verbose("adapter is null");
            return;
        }
        if (unityAdsShowError != null) {
            ironSourceError = new IronSourceError(((UnityAdsAdapter) this.mAdapter.get()).getUnityAdsShowErrorCode(unityAdsShowError), str2);
        } else {
            ironSourceError = ErrorBuilder.buildShowFailedError("Interstitial", str2);
        }
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.error("placementId = " + this.mPlacementId + "ironSourceError = " + ironSourceError);
        this.mListener.onInterstitialAdShowFailed(ironSourceError);
    }

    public void onUnityAdsShowClick(String str) {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose("placementId = " + this.mPlacementId);
        InterstitialSmashListener interstitialSmashListener = this.mListener;
        if (interstitialSmashListener == null) {
            IronLog.INTERNAL.verbose("listener is null");
        } else {
            interstitialSmashListener.onInterstitialAdClicked();
        }
    }

    public void onUnityAdsShowComplete(String str, UnityAds.UnityAdsShowCompletionState unityAdsShowCompletionState) {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose("placementId = " + this.mPlacementId + " completionState: " + unityAdsShowCompletionState);
        if (this.mListener == null) {
            IronLog.INTERNAL.verbose("listener is null");
            return;
        }
        int i = AnonymousClass1.$SwitchMap$com$unity3d$ads$UnityAds$UnityAdsShowCompletionState[unityAdsShowCompletionState.ordinal()];
        if (i == 1 || i == 2) {
            this.mListener.onInterstitialAdClosed();
        }
    }

    /* renamed from: com.ironsource.adapters.unityads.UnityAdsInterstitialListener$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$unity3d$ads$UnityAds$UnityAdsShowCompletionState;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.unity3d.ads.UnityAds$UnityAdsShowCompletionState[] r0 = com.unity3d.ads.UnityAds.UnityAdsShowCompletionState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$unity3d$ads$UnityAds$UnityAdsShowCompletionState = r0
                com.unity3d.ads.UnityAds$UnityAdsShowCompletionState r1 = com.unity3d.ads.UnityAds.UnityAdsShowCompletionState.SKIPPED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$unity3d$ads$UnityAds$UnityAdsShowCompletionState     // Catch:{ NoSuchFieldError -> 0x001d }
                com.unity3d.ads.UnityAds$UnityAdsShowCompletionState r1 = com.unity3d.ads.UnityAds.UnityAdsShowCompletionState.COMPLETED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ironsource.adapters.unityads.UnityAdsInterstitialListener.AnonymousClass1.<clinit>():void");
        }
    }
}
