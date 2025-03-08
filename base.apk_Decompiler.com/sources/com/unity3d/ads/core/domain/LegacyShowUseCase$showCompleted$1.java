package com.unity3d.ads.core.domain;

import com.unity3d.ads.IUnityAdsShowListener;
import com.unity3d.ads.core.data.model.ShowStatus;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.core.domain.LegacyShowUseCase", f = "LegacyShowUseCase.kt", i = {0, 0, 0, 0}, l = {170, 171}, m = "showCompleted", n = {"this", "placement", "status", "unityShowListener"}, s = {"L$0", "L$1", "L$2", "L$3"})
/* compiled from: LegacyShowUseCase.kt */
final class LegacyShowUseCase$showCompleted$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LegacyShowUseCase this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LegacyShowUseCase$showCompleted$1(LegacyShowUseCase legacyShowUseCase, Continuation<? super LegacyShowUseCase$showCompleted$1> continuation) {
        super(continuation);
        this.this$0 = legacyShowUseCase;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.showCompleted(0, (String) null, (ShowStatus) null, (IUnityAdsShowListener) null, this);
    }
}
