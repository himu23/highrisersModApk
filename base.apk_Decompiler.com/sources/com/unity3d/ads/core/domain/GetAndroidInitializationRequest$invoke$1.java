package com.unity3d.ads.core.domain;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.core.domain.GetAndroidInitializationRequest", f = "GetAndroidInitializationRequest.kt", i = {0, 0, 1, 1, 2, 2, 3, 3, 4, 4}, l = {25, 26, 36, 41, 46, 56}, m = "invoke", n = {"this", "$this$invoke_u24lambda_u244", "this", "$this$invoke_u24lambda_u244", "this", "$this$invoke_u24lambda_u244", "this", "$this$invoke_u24lambda_u244", "this", "$this$invoke_u24lambda_u244"}, s = {"L$0", "L$2", "L$0", "L$2", "L$0", "L$2", "L$0", "L$2", "L$0", "L$2"})
/* compiled from: GetAndroidInitializationRequest.kt */
final class GetAndroidInitializationRequest$invoke$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GetAndroidInitializationRequest this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GetAndroidInitializationRequest$invoke$1(GetAndroidInitializationRequest getAndroidInitializationRequest, Continuation<? super GetAndroidInitializationRequest$invoke$1> continuation) {
        super(continuation);
        this.this$0 = getAndroidInitializationRequest;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.invoke(this);
    }
}
