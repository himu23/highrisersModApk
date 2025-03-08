package com.unity3d.ads.core.domain;

import com.unity3d.ads.IUnityAdsShowListener;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.core.domain.LegacyShowUseCase", f = "LegacyShowUseCase.kt", i = {0, 0, 0}, l = {146, 147}, m = "showClicked", n = {"this", "placement", "unityShowListener"}, s = {"L$0", "L$1", "L$2"})
/* compiled from: LegacyShowUseCase.kt */
final class LegacyShowUseCase$showClicked$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LegacyShowUseCase this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LegacyShowUseCase$showClicked$1(LegacyShowUseCase legacyShowUseCase, Continuation<? super LegacyShowUseCase$showClicked$1> continuation) {
        super(continuation);
        this.this$0 = legacyShowUseCase;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.showClicked(0, (String) null, (IUnityAdsShowListener) null, this);
    }
}
