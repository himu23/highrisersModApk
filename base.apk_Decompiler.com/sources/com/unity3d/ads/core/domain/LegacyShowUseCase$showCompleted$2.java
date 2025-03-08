package com.unity3d.ads.core.domain;

import com.unity3d.ads.IUnityAdsShowListener;
import com.unity3d.ads.core.data.model.ShowStatus;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.unity3d.ads.core.domain.LegacyShowUseCase$showCompleted$2", f = "LegacyShowUseCase.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: LegacyShowUseCase.kt */
final class LegacyShowUseCase$showCompleted$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $placement;
    final /* synthetic */ ShowStatus $status;
    final /* synthetic */ IUnityAdsShowListener $unityShowListener;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LegacyShowUseCase$showCompleted$2(IUnityAdsShowListener iUnityAdsShowListener, String str, ShowStatus showStatus, Continuation<? super LegacyShowUseCase$showCompleted$2> continuation) {
        super(2, continuation);
        this.$unityShowListener = iUnityAdsShowListener;
        this.$placement = str;
        this.$status = showStatus;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LegacyShowUseCase$showCompleted$2(this.$unityShowListener, this.$placement, this.$status, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LegacyShowUseCase$showCompleted$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            IUnityAdsShowListener iUnityAdsShowListener = this.$unityShowListener;
            if (iUnityAdsShowListener == null) {
                return null;
            }
            iUnityAdsShowListener.onUnityAdsShowComplete(this.$placement, this.$status.toUnityAdsShowCompletionState());
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
