package com.unity3d.ads.core.domain;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.core.domain.GetAndroidInitializationCompletedRequest", f = "GetAndroidInitializationCompletedRequest.kt", i = {0, 0}, l = {14, 22}, m = "invoke", n = {"this", "$this$invoke_u24lambda_u240"}, s = {"L$0", "L$2"})
/* compiled from: GetAndroidInitializationCompletedRequest.kt */
final class GetAndroidInitializationCompletedRequest$invoke$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GetAndroidInitializationCompletedRequest this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GetAndroidInitializationCompletedRequest$invoke$1(GetAndroidInitializationCompletedRequest getAndroidInitializationCompletedRequest, Continuation<? super GetAndroidInitializationCompletedRequest$invoke$1> continuation) {
        super(continuation);
        this.this$0 = getAndroidInitializationCompletedRequest;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.invoke(this);
    }
}
