package com.unity3d.ads.adplayer;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.adplayer.Invocation", f = "Invocation.kt", i = {0}, l = {20}, m = "handle", n = {"this"}, s = {"L$0"})
/* compiled from: Invocation.kt */
final class Invocation$handle$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ Invocation this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    Invocation$handle$1(Invocation invocation, Continuation<? super Invocation$handle$1> continuation) {
        super(continuation);
        this.this$0 = invocation;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.handle((Function1<? super Continuation<Object>, ? extends Object>) null, this);
    }
}
