package com.unity3d.ads.core.domain;

import com.unity3d.ads.adplayer.Invocation;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H@"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/unity3d/ads/adplayer/Invocation;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.unity3d.ads.core.domain.HandleAndroidInvocationsUseCase$invoke$1", f = "HandleAndroidInvocationsUseCase.kt", i = {}, l = {45}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: HandleAndroidInvocationsUseCase.kt */
final class HandleAndroidInvocationsUseCase$invoke$1 extends SuspendLambda implements Function2<FlowCollector<? super Invocation>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Continuation<? super Unit>, Object> $onSubscription;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HandleAndroidInvocationsUseCase$invoke$1(Function1<? super Continuation<? super Unit>, ? extends Object> function1, Continuation<? super HandleAndroidInvocationsUseCase$invoke$1> continuation) {
        super(2, continuation);
        this.$onSubscription = function1;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HandleAndroidInvocationsUseCase$invoke$1(this.$onSubscription, continuation);
    }

    public final Object invoke(FlowCollector<? super Invocation> flowCollector, Continuation<? super Unit> continuation) {
        return ((HandleAndroidInvocationsUseCase$invoke$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Function1<Continuation<? super Unit>, Object> function1 = this.$onSubscription;
            this.label = 1;
            if (function1.invoke(this) == coroutine_suspended) {
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
