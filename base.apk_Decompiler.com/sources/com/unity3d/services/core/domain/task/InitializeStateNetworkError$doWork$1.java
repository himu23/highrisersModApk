package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.domain.task.InitializeStateNetworkError;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.services.core.domain.task.InitializeStateNetworkError", f = "InitializeStateNetworkError.kt", i = {}, l = {33}, m = "doWork-gIAlu-s", n = {}, s = {})
/* compiled from: InitializeStateNetworkError.kt */
final class InitializeStateNetworkError$doWork$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ InitializeStateNetworkError this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InitializeStateNetworkError$doWork$1(InitializeStateNetworkError initializeStateNetworkError, Continuation<? super InitializeStateNetworkError$doWork$1> continuation) {
        super(continuation);
        this.this$0 = initializeStateNetworkError;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object r3 = this.this$0.m81doWorkgIAlus((InitializeStateNetworkError.Params) null, (Continuation<? super Result<Unit>>) this);
        return r3 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? r3 : Result.m143boximpl(r3);
    }
}
