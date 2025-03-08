package com.unity3d.ads.core.domain;

import com.unity3d.ads.IUnityAdsShowListener;
import com.unity3d.ads.core.data.model.AdObject;
import gateway.v1.OperativeEventRequestOuterClass;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000\u0006\n\u0002\u0010\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H@"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.unity3d.ads.core.domain.LegacyShowUseCase$invoke$2", f = "LegacyShowUseCase.kt", i = {}, l = {83, 84}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: LegacyShowUseCase.kt */
final class LegacyShowUseCase$invoke$2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ AdObject $adObject;
    final /* synthetic */ String $placement;
    final /* synthetic */ long $startTime;
    final /* synthetic */ IUnityAdsShowListener $unityShowListener;
    final /* synthetic */ boolean $useTimeout;
    int label;
    final /* synthetic */ LegacyShowUseCase this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LegacyShowUseCase$invoke$2(LegacyShowUseCase legacyShowUseCase, AdObject adObject, boolean z, long j, String str, IUnityAdsShowListener iUnityAdsShowListener, Continuation<? super LegacyShowUseCase$invoke$2> continuation) {
        super(1, continuation);
        this.this$0 = legacyShowUseCase;
        this.$adObject = adObject;
        this.$useTimeout = z;
        this.$startTime = j;
        this.$placement = str;
        this.$unityShowListener = iUnityAdsShowListener;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new LegacyShowUseCase$invoke$2(this.this$0, this.$adObject, this.$useTimeout, this.$startTime, this.$placement, this.$unityShowListener, continuation);
    }

    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((LegacyShowUseCase$invoke$2) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (((Boolean) this.this$0.hasStarted.getValue()).booleanValue() || ((Boolean) this.this$0.timeoutCancellationRequested.getValue()).booleanValue()) {
                return Unit.INSTANCE;
            }
            this.label = 1;
            if (this.this$0.sendOperativeError(OperativeEventRequestOuterClass.OperativeEventErrorType.OPERATIVE_EVENT_ERROR_TYPE_TIMEOUT, "timeout", this.$adObject, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else if (i == 2) {
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.label = 2;
        if (this.this$0.showTimeout(this.$adObject, this.$useTimeout, this.$startTime, this.$placement, this.$unityShowListener, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }
}
