package com.unity3d.ads.core.domain;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.core.domain.GetAndroidAdPlayerContext", f = "GetAndroidAdPlayerContext.kt", i = {0}, l = {13}, m = "invoke", n = {"this"}, s = {"L$0"})
/* compiled from: GetAndroidAdPlayerContext.kt */
final class GetAndroidAdPlayerContext$invoke$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GetAndroidAdPlayerContext this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GetAndroidAdPlayerContext$invoke$1(GetAndroidAdPlayerContext getAndroidAdPlayerContext, Continuation<? super GetAndroidAdPlayerContext$invoke$1> continuation) {
        super(continuation);
        this.this$0 = getAndroidAdPlayerContext;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.invoke(this);
    }
}
