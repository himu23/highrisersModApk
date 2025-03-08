package com.unity3d.ads.core.domain.work;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.core.domain.work.UniversalRequestJob", f = "UniversalRequestJob.kt", i = {0, 0, 1, 1}, l = {27, 30, 33}, m = "doWork$suspendImpl", n = {"$this", "universalRequestId", "$this", "universalRequestId"}, s = {"L$0", "L$1", "L$0", "L$1"})
/* compiled from: UniversalRequestJob.kt */
final class UniversalRequestJob$doWork$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ UniversalRequestJob this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UniversalRequestJob$doWork$1(UniversalRequestJob universalRequestJob, Continuation<? super UniversalRequestJob$doWork$1> continuation) {
        super(continuation);
        this.this$0 = universalRequestJob;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return UniversalRequestJob.doWork$suspendImpl(this.this$0, this);
    }
}
