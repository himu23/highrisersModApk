package com.unity3d.ads.core.domain;

import android.content.Context;
import com.unity3d.ads.IUnityAdsLoadListener;
import com.unity3d.ads.UnityAdsLoadOptions;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.core.domain.LegacyLoadUseCase", f = "LegacyLoadUseCase.kt", i = {0, 0, 0, 0, 0, 2, 2, 2, 2, 2, 2, 2, 4, 4, 4, 4, 5, 5, 5, 5, 6, 6, 6, 6, 7, 7, 7, 7}, l = {44, 49, 54, 55, 74, 78, 82, 83, 86}, m = "invoke", n = {"this", "context", "placement", "loadOptions", "unityLoadListener", "this", "context", "placement", "loadOptions", "unityLoadListener", "opportunityIdByteString", "startTime", "this", "placement", "unityLoadListener", "startTime", "this", "placement", "unityLoadListener", "startTime", "this", "placement", "unityLoadListener", "startTime", "this", "placement", "unityLoadListener", "startTime"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "J$0", "L$0", "L$1", "L$2", "J$0", "L$0", "L$1", "L$2", "J$0", "L$0", "L$1", "L$2", "J$0", "L$0", "L$1", "L$2", "J$0"})
/* compiled from: LegacyLoadUseCase.kt */
final class LegacyLoadUseCase$invoke$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LegacyLoadUseCase this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LegacyLoadUseCase$invoke$1(LegacyLoadUseCase legacyLoadUseCase, Continuation<? super LegacyLoadUseCase$invoke$1> continuation) {
        super(continuation);
        this.this$0 = legacyLoadUseCase;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.invoke((Context) null, (String) null, (UnityAdsLoadOptions) null, (IUnityAdsLoadListener) null, this);
    }
}
