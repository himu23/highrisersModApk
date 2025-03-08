package com.unity3d.ads.core.domain;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.core.domain.InitializeAndroidBoldSDK", f = "InitializeAndroidBoldSDK.kt", i = {0, 0}, l = {91}, m = "initializationFailure", n = {"this", "e"}, s = {"L$0", "L$1"})
/* compiled from: InitializeAndroidBoldSDK.kt */
final class InitializeAndroidBoldSDK$initializationFailure$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ InitializeAndroidBoldSDK this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InitializeAndroidBoldSDK$initializationFailure$1(InitializeAndroidBoldSDK initializeAndroidBoldSDK, Continuation<? super InitializeAndroidBoldSDK$initializationFailure$1> continuation) {
        super(continuation);
        this.this$0 = initializeAndroidBoldSDK;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.initializationFailure(0, (Exception) null, this);
    }
}
