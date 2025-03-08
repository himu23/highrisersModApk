package com.unity3d.ads.adplayer;

import android.view.ViewGroup;
import com.unity3d.services.banners.UnityBannerSize;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J!\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H¦@ø\u0001\u0000¢\u0006\u0002\u0010\b\u0002\u0004\n\u0002\b\u0019¨\u0006\t"}, d2 = {"Lcom/unity3d/ads/adplayer/EmbeddableAdPlayer;", "Lcom/unity3d/ads/adplayer/AdPlayer;", "getEmbeddable", "Landroid/view/ViewGroup;", "showOptions", "Lcom/unity3d/ads/adplayer/ShowOptions;", "size", "Lcom/unity3d/services/banners/UnityBannerSize;", "(Lcom/unity3d/ads/adplayer/ShowOptions;Lcom/unity3d/services/banners/UnityBannerSize;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: EmbeddableAdPlayer.kt */
public interface EmbeddableAdPlayer extends AdPlayer {
    Object getEmbeddable(ShowOptions showOptions, UnityBannerSize unityBannerSize, Continuation<? super ViewGroup> continuation);
}
