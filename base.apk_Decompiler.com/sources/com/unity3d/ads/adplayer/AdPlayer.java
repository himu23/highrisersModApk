package com.unity3d.ads.adplayer;

import com.google.protobuf.ByteString;
import com.unity3d.ads.core.data.model.ShowEvent;
import gateway.v1.AllowedPiiOuterClass;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\u0003\bf\u0018\u0000 .2\u00020\u0001:\u0001.J\u0019\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0019H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u001aJ\u0019\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001dH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u001eJ\u0011\u0010\u001f\u001a\u00020\u0004H¦@ø\u0001\u0000¢\u0006\u0002\u0010 J\u0019\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020#H¦@ø\u0001\u0000¢\u0006\u0002\u0010$J\u0019\u0010%\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0014H¦@ø\u0001\u0000¢\u0006\u0002\u0010&J\u0019\u0010'\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0014H¦@ø\u0001\u0000¢\u0006\u0002\u0010&J\u0019\u0010(\u001a\u00020\u00042\u0006\u0010)\u001a\u00020#H¦@ø\u0001\u0000¢\u0006\u0002\u0010$J\u0019\u0010*\u001a\u00020\u00042\u0006\u0010+\u001a\u00020,H¦@ø\u0001\u0000¢\u0006\u0002\u0010-R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0018\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\nR\u0012\u0010\u000e\u001a\u00020\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R$\u0010\u0012\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u00130\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\n\u0002\u0004\n\u0002\b\u0019¨\u0006/"}, d2 = {"Lcom/unity3d/ads/adplayer/AdPlayer;", "", "loadEvent", "Lkotlinx/coroutines/Deferred;", "", "getLoadEvent", "()Lkotlinx/coroutines/Deferred;", "markCampaignStateAsShown", "Lkotlinx/coroutines/flow/Flow;", "getMarkCampaignStateAsShown", "()Lkotlinx/coroutines/flow/Flow;", "onShowEvent", "Lcom/unity3d/ads/core/data/model/ShowEvent;", "getOnShowEvent", "scope", "Lkotlinx/coroutines/CoroutineScope;", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "updateCampaignState", "Lkotlin/Pair;", "Lcom/google/protobuf/ByteString;", "", "getUpdateCampaignState", "onAllowedPiiChange", "value", "Lgateway/v1/AllowedPiiOuterClass$AllowedPii;", "(Lgateway/v1/AllowedPiiOuterClass$AllowedPii;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onBroadcastEvent", "event", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestShow", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendMuteChange", "isMuted", "", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendPrivacyFsmChange", "(Lcom/google/protobuf/ByteString;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendUserConsentChange", "sendVisibilityChange", "isVisible", "sendVolumeChange", "volume", "", "(DLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AdPlayer.kt */
public interface AdPlayer {
    public static final Companion Companion = Companion.$$INSTANCE;

    Deferred<Unit> getLoadEvent();

    Flow<Unit> getMarkCampaignStateAsShown();

    Flow<ShowEvent> getOnShowEvent();

    CoroutineScope getScope();

    Flow<Pair<ByteString, Integer>> getUpdateCampaignState();

    Object onAllowedPiiChange(AllowedPiiOuterClass.AllowedPii allowedPii, Continuation<? super Unit> continuation);

    Object onBroadcastEvent(JSONObject jSONObject, Continuation<? super Unit> continuation);

    Object requestShow(Continuation<? super Unit> continuation);

    Object sendMuteChange(boolean z, Continuation<? super Unit> continuation);

    Object sendPrivacyFsmChange(ByteString byteString, Continuation<? super Unit> continuation);

    Object sendUserConsentChange(ByteString byteString, Continuation<? super Unit> continuation);

    Object sendVisibilityChange(boolean z, Continuation<? super Unit> continuation);

    Object sendVolumeChange(double d, Continuation<? super Unit> continuation);

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/unity3d/ads/adplayer/AdPlayer$Companion;", "", "()V", "broadcastEventChannel", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lorg/json/JSONObject;", "getBroadcastEventChannel", "()Lkotlinx/coroutines/flow/MutableSharedFlow;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AdPlayer.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final MutableSharedFlow<JSONObject> broadcastEventChannel = SharedFlowKt.MutableSharedFlow$default(0, 0, (BufferOverflow) null, 7, (Object) null);

        public final MutableSharedFlow<JSONObject> getBroadcastEventChannel() {
            return broadcastEventChannel;
        }

        private Companion() {
        }
    }
}
