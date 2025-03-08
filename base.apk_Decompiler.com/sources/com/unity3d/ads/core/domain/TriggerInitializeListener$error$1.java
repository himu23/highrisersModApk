package com.unity3d.ads.core.domain;

import com.unity3d.ads.UnityAds;
import com.unity3d.services.core.properties.SdkProperties;
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
@DebugMetadata(c = "com.unity3d.ads.core.domain.TriggerInitializeListener$error$1", f = "TriggerInitializeListener.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: TriggerInitializeListener.kt */
final class TriggerInitializeListener$error$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $errorMsg;
    final /* synthetic */ UnityAds.UnityAdsInitializationError $unityAdsInitializationError;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TriggerInitializeListener$error$1(UnityAds.UnityAdsInitializationError unityAdsInitializationError, String str, Continuation<? super TriggerInitializeListener$error$1> continuation) {
        super(2, continuation);
        this.$unityAdsInitializationError = unityAdsInitializationError;
        this.$errorMsg = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TriggerInitializeListener$error$1(this.$unityAdsInitializationError, this.$errorMsg, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TriggerInitializeListener$error$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            SdkProperties.notifyInitializationFailed(this.$unityAdsInitializationError, this.$errorMsg);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
