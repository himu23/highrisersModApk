package com.unity3d.ads.core.domain;

import com.unity3d.ads.IUnityAdsLoadListener;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.core.domain.LegacyLoadUseCase", f = "LegacyLoadUseCase.kt", i = {0, 0, 0}, l = {111, 112}, m = "loadSuccess", n = {"this", "placement", "unityLoadListener"}, s = {"L$0", "L$1", "L$2"})
/* compiled from: LegacyLoadUseCase.kt */
final class LegacyLoadUseCase$loadSuccess$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LegacyLoadUseCase this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LegacyLoadUseCase$loadSuccess$1(LegacyLoadUseCase legacyLoadUseCase, Continuation<? super LegacyLoadUseCase$loadSuccess$1> continuation) {
        super(continuation);
        this.this$0 = legacyLoadUseCase;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.loadSuccess(0, (String) null, (IUnityAdsLoadListener) null, this);
    }
}
