package com.unity3d.ads.adplayer;

import android.content.Context;
import android.content.Intent;
import com.google.protobuf.ByteString;
import com.unity3d.ads.core.data.datasource.VolumeSettingsChange;
import com.unity3d.ads.core.data.model.SessionChange;
import com.unity3d.ads.core.data.model.ShowEvent;
import com.unity3d.ads.core.data.repository.DeviceInfoRepository;
import com.unity3d.ads.core.data.repository.SessionRepository;
import gateway.v1.AllowedPiiOuterClass;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 J2\u00020\u00012\u00020\u0002:\u0001JB-\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u0011\u0010#\u001a\u00020\u0010H@ø\u0001\u0000¢\u0006\u0002\u0010$J\u0010\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0002J\u0019\u0010)\u001a\u00020\u00102\u0006\u0010*\u001a\u00020+H@ø\u0001\u0000¢\u0006\u0002\u0010,J\u0019\u0010-\u001a\u00020\u00102\u0006\u0010*\u001a\u00020.H@ø\u0001\u0000¢\u0006\u0002\u0010/J\u0019\u00100\u001a\u00020\u00102\u0006\u00101\u001a\u000202HAø\u0001\u0000¢\u0006\u0002\u00103J\u0019\u00104\u001a\u00020\u00102\u0006\u00105\u001a\u000206HAø\u0001\u0000¢\u0006\u0002\u00107J\u0011\u00108\u001a\u00020\u0010HAø\u0001\u0000¢\u0006\u0002\u0010$J\u0019\u00109\u001a\u00020\u00102\u0006\u0010:\u001a\u00020;HAø\u0001\u0000¢\u0006\u0002\u0010<J\u0019\u0010=\u001a\u00020\u00102\u0006\u00101\u001a\u00020 HAø\u0001\u0000¢\u0006\u0002\u0010>J\u0019\u0010?\u001a\u00020\u00102\u0006\u00101\u001a\u00020 HAø\u0001\u0000¢\u0006\u0002\u0010>J\u0019\u0010@\u001a\u00020\u00102\u0006\u0010A\u001a\u00020;HAø\u0001\u0000¢\u0006\u0002\u0010<J\u0019\u0010B\u001a\u00020\u00102\u0006\u0010C\u001a\u00020DHAø\u0001\u0000¢\u0006\u0002\u0010EJ\u0010\u0010F\u001a\u00020\u00102\u0006\u0010G\u001a\u00020HH\u0016J\u0011\u0010I\u001a\u00020\u0010H@ø\u0001\u0000¢\u0006\u0002\u0010$R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0005¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u0014X\u0005¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0014X\u0005¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u001a\u001a\u00020\u001bX\u0005¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R$\u0010\u001e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0\u001f0\u0014X\u0005¢\u0006\u0006\u001a\u0004\b\"\u0010\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006K"}, d2 = {"Lcom/unity3d/ads/adplayer/AndroidFullscreenWebViewAdPlayer;", "Lcom/unity3d/ads/adplayer/AdPlayer;", "Lcom/unity3d/ads/adplayer/FullscreenAdPlayer;", "webViewAdPlayer", "Lcom/unity3d/ads/adplayer/WebViewAdPlayer;", "opportunityId", "", "webViewContainer", "Lcom/unity3d/ads/adplayer/AndroidWebViewContainer;", "deviceInfoRepository", "Lcom/unity3d/ads/core/data/repository/DeviceInfoRepository;", "sessionRepository", "Lcom/unity3d/ads/core/data/repository/SessionRepository;", "(Lcom/unity3d/ads/adplayer/WebViewAdPlayer;Ljava/lang/String;Lcom/unity3d/ads/adplayer/AndroidWebViewContainer;Lcom/unity3d/ads/core/data/repository/DeviceInfoRepository;Lcom/unity3d/ads/core/data/repository/SessionRepository;)V", "loadEvent", "Lkotlinx/coroutines/Deferred;", "", "getLoadEvent", "()Lkotlinx/coroutines/Deferred;", "markCampaignStateAsShown", "Lkotlinx/coroutines/flow/Flow;", "getMarkCampaignStateAsShown", "()Lkotlinx/coroutines/flow/Flow;", "onShowEvent", "Lcom/unity3d/ads/core/data/model/ShowEvent;", "getOnShowEvent", "scope", "Lkotlinx/coroutines/CoroutineScope;", "getScope", "()Lkotlinx/coroutines/CoroutineScope;", "updateCampaignState", "Lkotlin/Pair;", "Lcom/google/protobuf/ByteString;", "", "getUpdateCampaignState", "destroy", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "displayEventsRouter", "Lkotlinx/coroutines/Job;", "displayMessage", "Lcom/unity3d/ads/adplayer/DisplayMessage;", "handleSessionChange", "change", "Lcom/unity3d/ads/core/data/model/SessionChange;", "(Lcom/unity3d/ads/core/data/model/SessionChange;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleVolumeSettingsChange", "Lcom/unity3d/ads/core/data/datasource/VolumeSettingsChange;", "(Lcom/unity3d/ads/core/data/datasource/VolumeSettingsChange;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onAllowedPiiChange", "value", "Lgateway/v1/AllowedPiiOuterClass$AllowedPii;", "(Lgateway/v1/AllowedPiiOuterClass$AllowedPii;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onBroadcastEvent", "event", "Lorg/json/JSONObject;", "(Lorg/json/JSONObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestShow", "sendMuteChange", "isMuted", "", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendPrivacyFsmChange", "(Lcom/google/protobuf/ByteString;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendUserConsentChange", "sendVisibilityChange", "isVisible", "sendVolumeChange", "volume", "", "(DLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "show", "showOptions", "Lcom/unity3d/ads/adplayer/ShowOptions;", "terminate", "Companion", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidFullscreenWebViewAdPlayer.kt */
public final class AndroidFullscreenWebViewAdPlayer implements AdPlayer, FullscreenAdPlayer {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final MutableSharedFlow<DisplayMessage> displayMessages = SharedFlowKt.MutableSharedFlow$default(0, 0, (BufferOverflow) null, 7, (Object) null);
    private final DeviceInfoRepository deviceInfoRepository;
    /* access modifiers changed from: private */
    public final String opportunityId;
    private final SessionRepository sessionRepository;
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

    public AndroidFullscreenWebViewAdPlayer(WebViewAdPlayer webViewAdPlayer2, String str, AndroidWebViewContainer androidWebViewContainer, DeviceInfoRepository deviceInfoRepository2, SessionRepository sessionRepository2) {
        Intrinsics.checkNotNullParameter(webViewAdPlayer2, "webViewAdPlayer");
        Intrinsics.checkNotNullParameter(str, "opportunityId");
        Intrinsics.checkNotNullParameter(androidWebViewContainer, "webViewContainer");
        Intrinsics.checkNotNullParameter(deviceInfoRepository2, "deviceInfoRepository");
        Intrinsics.checkNotNullParameter(sessionRepository2, "sessionRepository");
        this.webViewAdPlayer = webViewAdPlayer2;
        this.opportunityId = str;
        this.webViewContainer = androidWebViewContainer;
        this.deviceInfoRepository = deviceInfoRepository2;
        this.sessionRepository = sessionRepository2;
    }

    public void show(ShowOptions showOptions) {
        Intrinsics.checkNotNullParameter(showOptions, "showOptions");
        if (showOptions instanceof AndroidShowOptions) {
            Context context = ((AndroidShowOptions) showOptions).getContext();
            Intent intent = new Intent(context, FullScreenWebViewDisplay.class);
            intent.putExtra("opportunityId", this.opportunityId);
            intent.addFlags(268500992);
            FlowKt.launchIn(FlowKt.onEach(new AndroidFullscreenWebViewAdPlayer$show$$inlined$filter$1(displayMessages, this), new AndroidFullscreenWebViewAdPlayer$show$2(this)), getScope());
            FlowKt.launchIn(FlowKt.onEach(this.deviceInfoRepository.getVolumeSettingsChange(), new AndroidFullscreenWebViewAdPlayer$show$3(this)), getScope());
            FlowKt.launchIn(FlowKt.onEach(new AndroidFullscreenWebViewAdPlayer$show$$inlined$filter$2(this.webViewAdPlayer.getOnShowEvent()), new AndroidFullscreenWebViewAdPlayer$show$5(this, (Continuation<? super AndroidFullscreenWebViewAdPlayer$show$5>) null)), getScope());
            FlowKt.launchIn(FlowKt.onEach(this.sessionRepository.getOnChange(), new AndroidFullscreenWebViewAdPlayer$show$6(this)), getScope());
            context.startActivity(intent);
            return;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public Object terminate(Continuation<? super Unit> continuation) {
        Object destroy = destroy(continuation);
        return destroy == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? destroy : Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public final Object handleVolumeSettingsChange(VolumeSettingsChange volumeSettingsChange, Continuation<? super Unit> continuation) {
        if (volumeSettingsChange instanceof VolumeSettingsChange.MuteChange) {
            Object sendMuteChange = this.webViewAdPlayer.sendMuteChange(((VolumeSettingsChange.MuteChange) volumeSettingsChange).isMuted(), continuation);
            return sendMuteChange == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? sendMuteChange : Unit.INSTANCE;
        } else if (!(volumeSettingsChange instanceof VolumeSettingsChange.VolumeChange)) {
            return Unit.INSTANCE;
        } else {
            Object sendVolumeChange = this.webViewAdPlayer.sendVolumeChange(((VolumeSettingsChange.VolumeChange) volumeSettingsChange).getVolume(), continuation);
            return sendVolumeChange == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? sendVolumeChange : Unit.INSTANCE;
        }
    }

    /* access modifiers changed from: private */
    public final Object handleSessionChange(SessionChange sessionChange, Continuation<? super Unit> continuation) {
        if (sessionChange instanceof SessionChange.UserConsentChange) {
            Object sendUserConsentChange = this.webViewAdPlayer.sendUserConsentChange(((SessionChange.UserConsentChange) sessionChange).getValue(), continuation);
            return sendUserConsentChange == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? sendUserConsentChange : Unit.INSTANCE;
        } else if (!(sessionChange instanceof SessionChange.PrivacyFsmChange)) {
            return Unit.INSTANCE;
        } else {
            Object sendPrivacyFsmChange = this.webViewAdPlayer.sendPrivacyFsmChange(((SessionChange.PrivacyFsmChange) sessionChange).getValue(), continuation);
            return sendPrivacyFsmChange == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? sendPrivacyFsmChange : Unit.INSTANCE;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0065 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object destroy(kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer$destroy$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer$destroy$1 r0 = (com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer$destroy$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer$destroy$1 r0 = new com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer$destroy$1
            r0.<init>(r6, r7)
        L_0x0019:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0041
            if (r2 == r4) goto L_0x0039
            if (r2 != r3) goto L_0x0031
            java.lang.Object r0 = r0.L$0
            com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer r0 = (com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer) r0
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0067
        L_0x0031:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x0039:
            java.lang.Object r2 = r0.L$0
            com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer r2 = (com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer) r2
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0059
        L_0x0041:
            kotlin.ResultKt.throwOnFailure(r7)
            kotlinx.coroutines.flow.MutableSharedFlow<com.unity3d.ads.adplayer.DisplayMessage> r7 = displayMessages
            com.unity3d.ads.adplayer.DisplayMessage$DisplayFinishRequest r2 = new com.unity3d.ads.adplayer.DisplayMessage$DisplayFinishRequest
            java.lang.String r5 = r6.opportunityId
            r2.<init>(r5)
            r0.L$0 = r6
            r0.label = r4
            java.lang.Object r7 = r7.emit(r2, r0)
            if (r7 != r1) goto L_0x0058
            return r1
        L_0x0058:
            r2 = r6
        L_0x0059:
            com.unity3d.ads.adplayer.AndroidWebViewContainer r7 = r2.webViewContainer
            r0.L$0 = r2
            r0.label = r3
            java.lang.Object r7 = r7.destroy(r0)
            if (r7 != r1) goto L_0x0066
            return r1
        L_0x0066:
            r0 = r2
        L_0x0067:
            kotlinx.coroutines.CoroutineScope r7 = r0.getScope()
            r0 = 0
            kotlinx.coroutines.CoroutineScopeKt.cancel$default(r7, r0, r4, r0)
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer.destroy(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final Job displayEventsRouter(DisplayMessage displayMessage) {
        return BuildersKt__Builders_commonKt.launch$default(getScope(), (CoroutineContext) null, (CoroutineStart) null, new AndroidFullscreenWebViewAdPlayer$displayEventsRouter$1(displayMessage, this, (Continuation<? super AndroidFullscreenWebViewAdPlayer$displayEventsRouter$1>) null), 3, (Object) null);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/unity3d/ads/adplayer/AndroidFullscreenWebViewAdPlayer$Companion;", "", "()V", "displayMessages", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/unity3d/ads/adplayer/DisplayMessage;", "getDisplayMessages", "()Lkotlinx/coroutines/flow/MutableSharedFlow;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AndroidFullscreenWebViewAdPlayer.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final MutableSharedFlow<DisplayMessage> getDisplayMessages() {
            return AndroidFullscreenWebViewAdPlayer.displayMessages;
        }
    }
}
