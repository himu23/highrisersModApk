package com.unity3d.ads;

import com.ironsource.m2;
import com.unity3d.ads.UnityAds;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005H\u0016¨\u0006\n"}, d2 = {"com/unity3d/ads/UnityAds$load$1", "Lcom/unity3d/ads/IUnityAdsLoadListener;", "onUnityAdsAdLoaded", "", "placementId", "", "onUnityAdsFailedToLoad", "error", "Lcom/unity3d/ads/UnityAds$UnityAdsLoadError;", "message", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: UnityAds.kt */
public final class UnityAds$load$1 implements IUnityAdsLoadListener {
    public void onUnityAdsAdLoaded(String str) {
        Intrinsics.checkNotNullParameter(str, m2.i);
    }

    public void onUnityAdsFailedToLoad(String str, UnityAds.UnityAdsLoadError unityAdsLoadError, String str2) {
        Intrinsics.checkNotNullParameter(str, m2.i);
        Intrinsics.checkNotNullParameter(unityAdsLoadError, "error");
        Intrinsics.checkNotNullParameter(str2, "message");
    }

    UnityAds$load$1() {
    }
}
