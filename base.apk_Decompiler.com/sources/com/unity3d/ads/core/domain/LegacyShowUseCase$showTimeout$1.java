package com.unity3d.ads.core.domain;

import com.unity3d.ads.IUnityAdsShowListener;
import com.unity3d.ads.core.data.model.AdObject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.core.domain.LegacyShowUseCase", f = "LegacyShowUseCase.kt", i = {0, 0, 0, 0}, l = {125, 126}, m = "showTimeout", n = {"this", "placement", "unityShowListener", "startTime"}, s = {"L$0", "L$1", "L$2", "J$0"})
/* compiled from: LegacyShowUseCase.kt */
final class LegacyShowUseCase$showTimeout$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LegacyShowUseCase this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LegacyShowUseCase$showTimeout$1(LegacyShowUseCase legacyShowUseCase, Continuation<? super LegacyShowUseCase$showTimeout$1> continuation) {
        super(continuation);
        this.this$0 = legacyShowUseCase;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.showTimeout((AdObject) null, false, 0, (String) null, (IUnityAdsShowListener) null, this);
    }
}
