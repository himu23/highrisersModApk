package com.unity3d.ads.core.domain;

import android.content.Context;
import com.unity3d.ads.IUnityAdsShowListener;
import com.unity3d.ads.UnityAdsShowOptions;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.core.domain.LegacyShowUseCase", f = "LegacyShowUseCase.kt", i = {0, 0, 0, 0, 0, 0, 3, 3, 3, 3, 3, 3, 6}, l = {52, 55, 61, 66, 68, 73, 89}, m = "invoke", n = {"this", "context", "placement", "unityAdsShowOptions", "unityShowListener", "startTime", "this", "context", "placement", "unityShowListener", "opportunityId", "startTime", "this"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "J$0", "L$0", "L$1", "L$2", "L$3", "L$4", "J$0", "L$0"})
/* compiled from: LegacyShowUseCase.kt */
final class LegacyShowUseCase$invoke$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LegacyShowUseCase this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LegacyShowUseCase$invoke$1(LegacyShowUseCase legacyShowUseCase, Continuation<? super LegacyShowUseCase$invoke$1> continuation) {
        super(continuation);
        this.this$0 = legacyShowUseCase;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.invoke((Context) null, (String) null, (UnityAdsShowOptions) null, (IUnityAdsShowListener) null, this);
    }
}
