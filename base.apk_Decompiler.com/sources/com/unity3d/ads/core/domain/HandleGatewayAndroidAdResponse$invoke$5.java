package com.unity3d.ads.core.domain;

import com.google.protobuf.ByteString;
import com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer;
import gateway.v1.AdResponseOuterClass;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.unity3d.ads.core.domain.HandleGatewayAndroidAdResponse$invoke$5", f = "HandleGatewayAndroidAdResponse.kt", i = {}, l = {155}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: HandleGatewayAndroidAdResponse.kt */
final class HandleGatewayAndroidAdResponse$invoke$5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef<AndroidFullscreenWebViewAdPlayer> $adPlayer;
    final /* synthetic */ ByteString $opportunityId;
    final /* synthetic */ AdResponseOuterClass.AdResponse $response;
    final /* synthetic */ Throwable $t;
    int label;
    final /* synthetic */ HandleGatewayAndroidAdResponse this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HandleGatewayAndroidAdResponse$invoke$5(HandleGatewayAndroidAdResponse handleGatewayAndroidAdResponse, Throwable th, ByteString byteString, AdResponseOuterClass.AdResponse adResponse, Ref.ObjectRef<AndroidFullscreenWebViewAdPlayer> objectRef, Continuation<? super HandleGatewayAndroidAdResponse$invoke$5> continuation) {
        super(2, continuation);
        this.this$0 = handleGatewayAndroidAdResponse;
        this.$t = th;
        this.$opportunityId = byteString;
        this.$response = adResponse;
        this.$adPlayer = objectRef;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HandleGatewayAndroidAdResponse$invoke$5(this.this$0, this.$t, this.$opportunityId, this.$response, this.$adPlayer, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((HandleGatewayAndroidAdResponse$invoke$5) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            HandleGatewayAndroidAdResponse handleGatewayAndroidAdResponse = this.this$0;
            Throwable th = this.$t;
            this.label = 1;
            if (handleGatewayAndroidAdResponse.cleanup(th, this.$opportunityId, this.$response, (AndroidFullscreenWebViewAdPlayer) this.$adPlayer.element, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
