package com.unity3d.ads.core.domain;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.unity3d.ads.core.domain.HandleAndroidGatewayInitializationResponse$invoke$3", f = "HandleAndroidGatewayInitializationResponse.kt", i = {}, l = {23}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: HandleAndroidGatewayInitializationResponse.kt */
final class HandleAndroidGatewayInitializationResponse$invoke$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ HandleAndroidGatewayInitializationResponse this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HandleAndroidGatewayInitializationResponse$invoke$3(HandleAndroidGatewayInitializationResponse handleAndroidGatewayInitializationResponse, Continuation<? super HandleAndroidGatewayInitializationResponse$invoke$3> continuation) {
        super(2, continuation);
        this.this$0 = handleAndroidGatewayInitializationResponse;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HandleAndroidGatewayInitializationResponse$invoke$3(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((HandleAndroidGatewayInitializationResponse$invoke$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (this.this$0.triggerInitializationCompletedRequest.invoke(this) == coroutine_suspended) {
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
