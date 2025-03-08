package com.unity3d.ads.adplayer;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bv\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u001a\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b\u0001\n\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015¨\u0006\u0016"}, d2 = {"Lcom/unity3d/ads/adplayer/WebViewEvent;", "", "category", "", "getCategory", "()Ljava/lang/String;", "name", "getName", "parameters", "", "getParameters", "()[Ljava/lang/Object;", "Lcom/unity3d/ads/adplayer/OnAllowedPiiChangeEvent;", "Lcom/unity3d/ads/adplayer/OnBroadcastEvent;", "Lcom/unity3d/ads/adplayer/OnMuteChangeEvent;", "Lcom/unity3d/ads/adplayer/OnPrivacyFsmChangeEvent;", "Lcom/unity3d/ads/adplayer/OnStorageEvent;", "Lcom/unity3d/ads/adplayer/OnUserConsentChangeEvent;", "Lcom/unity3d/ads/adplayer/OnVisibilityChangeEvent;", "Lcom/unity3d/ads/adplayer/OnVolumeChangeEvent;", "Lcom/unity3d/ads/adplayer/OnWebRequestComplete;", "Lcom/unity3d/ads/adplayer/OnWebRequestFailed;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: WebViewEvent.kt */
public interface WebViewEvent {
    String getCategory();

    String getName();

    Object[] getParameters();
}
