package com.unity3d.ads.adplayer;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.adplayer.CommonWebViewBridge", f = "CommonWebViewBridge.kt", i = {0}, l = {60, 62}, m = "request", n = {"callback"}, s = {"L$0"})
/* compiled from: CommonWebViewBridge.kt */
final class CommonWebViewBridge$request$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CommonWebViewBridge this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CommonWebViewBridge$request$1(CommonWebViewBridge commonWebViewBridge, Continuation<? super CommonWebViewBridge$request$1> continuation) {
        super(continuation);
        this.this$0 = commonWebViewBridge;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.request((String) null, (String) null, (Object[]) null, this);
    }
}
