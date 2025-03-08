package com.unity3d.ads.core.domain;

import com.unity3d.ads.IUnityAdsLoadListener;
import com.unity3d.ads.UnityAds;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.core.domain.LegacyLoadUseCase", f = "LegacyLoadUseCase.kt", i = {0, 0, 0, 0, 0}, l = {126, 127}, m = "loadFailure", n = {"this", "reason", "message", "placement", "unityLoadListener"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4"})
/* compiled from: LegacyLoadUseCase.kt */
final class LegacyLoadUseCase$loadFailure$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LegacyLoadUseCase this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LegacyLoadUseCase$loadFailure$1(LegacyLoadUseCase legacyLoadUseCase, Continuation<? super LegacyLoadUseCase$loadFailure$1> continuation) {
        super(continuation);
        this.this$0 = legacyLoadUseCase;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.loadFailure(0, (UnityAds.UnityAdsLoadError) null, (String) null, (String) null, (IUnityAdsLoadListener) null, this);
    }
}
