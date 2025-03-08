package com.unity3d.ads.core.domain;

import com.unity3d.ads.IUnityAdsLoadListener;
import com.unity3d.ads.UnityAds;
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
@DebugMetadata(c = "com.unity3d.ads.core.domain.LegacyLoadUseCase$loadFailure$2", f = "LegacyLoadUseCase.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: LegacyLoadUseCase.kt */
final class LegacyLoadUseCase$loadFailure$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $message;
    final /* synthetic */ String $placement;
    final /* synthetic */ UnityAds.UnityAdsLoadError $reason;
    final /* synthetic */ IUnityAdsLoadListener $unityLoadListener;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LegacyLoadUseCase$loadFailure$2(IUnityAdsLoadListener iUnityAdsLoadListener, String str, UnityAds.UnityAdsLoadError unityAdsLoadError, String str2, Continuation<? super LegacyLoadUseCase$loadFailure$2> continuation) {
        super(2, continuation);
        this.$unityLoadListener = iUnityAdsLoadListener;
        this.$placement = str;
        this.$reason = unityAdsLoadError;
        this.$message = str2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LegacyLoadUseCase$loadFailure$2(this.$unityLoadListener, this.$placement, this.$reason, this.$message, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LegacyLoadUseCase$loadFailure$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            IUnityAdsLoadListener iUnityAdsLoadListener = this.$unityLoadListener;
            if (iUnityAdsLoadListener == null) {
                return null;
            }
            iUnityAdsLoadListener.onUnityAdsFailedToLoad(this.$placement, this.$reason, this.$message);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
