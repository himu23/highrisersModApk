package com.unity3d.ads.core.domain;

import com.google.protobuf.ByteString;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.core.domain.AndroidRefresh", f = "AndroidRefresh.kt", i = {}, l = {20}, m = "invoke", n = {}, s = {})
/* compiled from: AndroidRefresh.kt */
final class AndroidRefresh$invoke$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AndroidRefresh this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AndroidRefresh$invoke$1(AndroidRefresh androidRefresh, Continuation<? super AndroidRefresh$invoke$1> continuation) {
        super(continuation);
        this.this$0 = androidRefresh;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.invoke((ByteString) null, (ByteString) null, this);
    }
}
