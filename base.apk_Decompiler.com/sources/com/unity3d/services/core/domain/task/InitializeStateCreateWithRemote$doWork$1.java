package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.domain.task.InitializeStateCreateWithRemote;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.services.core.domain.task.InitializeStateCreateWithRemote", f = "InitializeStateCreateWithRemote.kt", i = {}, l = {27}, m = "doWork-gIAlu-s", n = {}, s = {})
/* compiled from: InitializeStateCreateWithRemote.kt */
final class InitializeStateCreateWithRemote$doWork$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ InitializeStateCreateWithRemote this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InitializeStateCreateWithRemote$doWork$1(InitializeStateCreateWithRemote initializeStateCreateWithRemote, Continuation<? super InitializeStateCreateWithRemote$doWork$1> continuation) {
        super(continuation);
        this.this$0 = initializeStateCreateWithRemote;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object r3 = this.this$0.m73doWorkgIAlus((InitializeStateCreateWithRemote.Params) null, (Continuation<? super Result<? extends Configuration>>) this);
        return r3 == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? r3 : Result.m143boximpl(r3);
    }
}
