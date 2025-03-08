package com.unity3d.ads.adplayer;

import android.view.ViewGroup;
import com.google.protobuf.ByteString;
import com.unity3d.ads.core.data.model.ShowEvent;
import com.unity3d.services.banners.UnityBannerSize;
import gateway.v1.AllowedPiiOuterClass;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.flow.Flow;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J!\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H@ø\u0001\u0000¢\u0006\u0002\u0010#J\u0019\u0010$\u001a\u00020\n2\u0006\u0010%\u001a\u00020&HAø\u0001\u0000¢\u0006\u0002\u0010'J\u0019\u0010(\u001a\u00020\n2\u0006\u0010)\u001a\u00020*HAø\u0001\u0000¢\u0006\u0002\u0010+J\u0011\u0010,\u001a\u00020\nHAø\u0001\u0000¢\u0006\u0002\u0010-J\u0019\u0010.\u001a\u00020\n2\u0006\u0010/\u001a\u000200HAø\u0001\u0000¢\u0006\u0002\u00101J\u0019\u00102\u001a\u00020\n2\u0006\u0010%\u001a\u00020\u001aHAø\u0001\u0000¢\u0006\u0002\u00103J\u0019\u00104\u001a\u00020\n2\u0006\u0010%\u001a\u00020\u001aHAø\u0001\u0000¢\u0006\u0002\u00103J\u0019\u00105\u001a\u00020\n2\u0006\u00106\u001a\u000200HAø\u0001\u0000¢\u0006\u0002\u00101J\u0019\u00107\u001a\u00020\n2\u0006\u00108\u001a\u000209HAø\u0001\u0000¢\u0006\u0002\u0010:R\u0018\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0005¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\u000eX\u0005¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u000eX\u0005¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0010R\u0012\u0010\u0014\u001a\u00020\u0015X\u0005¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R$\u0010\u0018\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b0\u00190\u000eX\u0005¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0010R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006;"}, d2 = {"Lcom/unity3d/ads/adplayer/AndroidEmbeddableWebViewAdPlayer;", "Lcom/unity3d/ads/adplayer/AdPlayer;", "Lcom/unity3d/ads/adplayer/EmbeddableAdPlayer;", "webViewAdPlayer", "Lcom/unity3d/ads/adplayer/WebViewAdPlayer;", "webViewContainer", "Lcom/unity3d/ads/adplayer/AndroidWebViewContainer;", "(Lcom/unity3d/ads/adplayer/WebViewAdPlayer;Lcom/unity3d/ads/adplayer/AndroidWebViewContainer;)V", "loadEvent", "Lkotlinx/coroutines/Deferred;", "", "getLoadEvent", "()Lkotlinx/coroutines/Deferred;", "markCampaignStateAsShown", "Lkotlinx/coroutines/flow/Flow;", "getMarkCampaignStateAsShown", "()Lkotlinx/coroutines/flow/Flow;", "onShowEvent", "Lcom/unity3d/ads/core/data/model/ShowEvent;", "getOnShowEvent", "scope", "Lkotlinx/coroutines/CoroutineScope;", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "updateCampaignState", "Lkotlin/Pair;", "Lcom/google/protobuf/ByteString;", "", "getUpdateCampaignState", "getEmbeddable", "Landroid/view/ViewGroup;", "showOptions", "Lcom/unity3d/ads/adplayer/ShowOptions;", "size", "Lcom/unity3d/services/banners/UnityBannerSize;", "(Lcom/unity3d/ads/adplayer/ShowOptions;Lcom/unity3d/services/banners/UnityBannerSize;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onAllowedPiiChange", "value", "Lgateway/v1/AllowedPiiOuterClass$AllowedPii;", "(Lgateway/v1/AllowedPiiOuterClass$AllowedPii;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onBroadcastEvent", "event", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestShow", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendMuteChange", "isMuted", "", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendPrivacyFsmChange", "(Lcom/google/protobuf/ByteString;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendUserConsentChange", "sendVisibilityChange", "isVisible", "sendVolumeChange", "volume", "", "(DLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidEmbeddableWebViewAdPlayer.kt */
public final class AndroidEmbeddableWebViewAdPlayer implements AdPlayer, EmbeddableAdPlayer {
    /* access modifiers changed from: private */
    public final WebViewAdPlayer webViewAdPlayer;
    /* access modifiers changed from: private */
    public final AndroidWebViewContainer webViewContainer;

    public Deferred<Unit> getLoadEvent() {
        return this.webViewAdPlayer.getLoadEvent();
    }

    public Flow<Unit> getMarkCampaignStateAsShown() {
        return this.webViewAdPlayer.getMarkCampaignStateAsShown();
    }

    public Flow<ShowEvent> getOnShowEvent() {
        return this.webViewAdPlayer.getOnShowEvent();
    }

    public CoroutineScope getScope() {
        return this.webViewAdPlayer.getScope();
    }

    public Flow<Pair<ByteString, Integer>> getUpdateCampaignState() {
        return this.webViewAdPlayer.getUpdateCampaignState();
    }

    public Object onAllowedPiiChange(AllowedPiiOuterClass.AllowedPii allowedPii, Continuation<? super Unit> continuation) {
        return this.webViewAdPlayer.onAllowedPiiChange(allowedPii, continuation);
    }

    public Object onBroadcastEvent(JSONObject jSONObject, Continuation<? super Unit> continuation) {
        return this.webViewAdPlayer.onBroadcastEvent(jSONObject, continuation);
    }

    public Object requestShow(Continuation<? super Unit> continuation) {
        return this.webViewAdPlayer.requestShow(continuation);
    }

    public Object sendMuteChange(boolean z, Continuation<? super Unit> continuation) {
        return this.webViewAdPlayer.sendMuteChange(z, continuation);
    }

    public Object sendPrivacyFsmChange(ByteString byteString, Continuation<? super Unit> continuation) {
        return this.webViewAdPlayer.sendPrivacyFsmChange(byteString, continuation);
    }

    public Object sendUserConsentChange(ByteString byteString, Continuation<? super Unit> continuation) {
        return this.webViewAdPlayer.sendUserConsentChange(byteString, continuation);
    }

    public Object sendVisibilityChange(boolean z, Continuation<? super Unit> continuation) {
        return this.webViewAdPlayer.sendVisibilityChange(z, continuation);
    }

    public Object sendVolumeChange(double d, Continuation<? super Unit> continuation) {
        return this.webViewAdPlayer.sendVolumeChange(d, continuation);
    }

    public AndroidEmbeddableWebViewAdPlayer(WebViewAdPlayer webViewAdPlayer2, AndroidWebViewContainer androidWebViewContainer) {
        Intrinsics.checkNotNullParameter(webViewAdPlayer2, "webViewAdPlayer");
        Intrinsics.checkNotNullParameter(androidWebViewContainer, "webViewContainer");
        this.webViewAdPlayer = webViewAdPlayer2;
        this.webViewContainer = androidWebViewContainer;
    }

    public Object getEmbeddable(ShowOptions showOptions, UnityBannerSize unityBannerSize, Continuation<? super ViewGroup> continuation) {
        return CoroutineScopeKt.coroutineScope(new AndroidEmbeddableWebViewAdPlayer$getEmbeddable$2(showOptions, this, unityBannerSize, (Continuation<? super AndroidEmbeddableWebViewAdPlayer$getEmbeddable$2>) null), continuation);
    }
}
