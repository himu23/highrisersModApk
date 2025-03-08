package com.unity3d.ads.core.domain;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.core.domain.TriggerAndroidInitializationCompletedRequest", f = "TriggerAndroidInitializationCompletedRequest.kt", i = {0}, l = {12, 14}, m = "invoke", n = {"this"}, s = {"L$0"})
/* compiled from: TriggerAndroidInitializationCompletedRequest.kt */
final class TriggerAndroidInitializationCompletedRequest$invoke$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ TriggerAndroidInitializationCompletedRequest this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TriggerAndroidInitializationCompletedRequest$invoke$1(TriggerAndroidInitializationCompletedRequest triggerAndroidInitializationCompletedRequest, Continuation<? super TriggerAndroidInitializationCompletedRequest$invoke$1> continuation) {
        super(continuation);
        this.this$0 = triggerAndroidInitializationCompletedRequest;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.invoke(this);
    }
}
