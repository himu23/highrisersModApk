package com.unity3d.ads.adplayer;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.adplayer.AndroidWebViewContainer", f = "AndroidWebViewContainer.kt", i = {0, 1, 2, 2, 3}, l = {18, 22, 24, 25}, m = "loadUrl", n = {"this", "this", "this", "loadResult", "loadResult"}, s = {"L$0", "L$0", "L$0", "L$1", "L$0"})
/* compiled from: AndroidWebViewContainer.kt */
final class AndroidWebViewContainer$loadUrl$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AndroidWebViewContainer this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AndroidWebViewContainer$loadUrl$1(AndroidWebViewContainer androidWebViewContainer, Continuation<? super AndroidWebViewContainer$loadUrl$1> continuation) {
        super(continuation);
        this.this$0 = androidWebViewContainer;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.loadUrl((String) null, this);
    }
}
