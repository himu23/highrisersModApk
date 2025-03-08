package com.unity3d.ads.core.domain;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.core.domain.InitializeAndroidBoldSDK", f = "InitializeAndroidBoldSDK.kt", i = {0}, l = {81}, m = "initializationSuccess", n = {"this"}, s = {"L$0"})
/* compiled from: InitializeAndroidBoldSDK.kt */
final class InitializeAndroidBoldSDK$initializationSuccess$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ InitializeAndroidBoldSDK this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InitializeAndroidBoldSDK$initializationSuccess$1(InitializeAndroidBoldSDK initializeAndroidBoldSDK, Continuation<? super InitializeAndroidBoldSDK$initializationSuccess$1> continuation) {
        super(continuation);
        this.this$0 = initializeAndroidBoldSDK;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.initializationSuccess(0, this);
    }
}
