package com.unity3d.ads.core.data.repository;

import com.google.protobuf.ByteString;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.core.data.repository.AndroidSessionRepository", f = "AndroidSessionRepository.kt", i = {0, 0}, l = {99, 100}, m = "setPrivacy", n = {"this", "value"}, s = {"L$0", "L$1"})
/* compiled from: AndroidSessionRepository.kt */
final class AndroidSessionRepository$setPrivacy$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AndroidSessionRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AndroidSessionRepository$setPrivacy$1(AndroidSessionRepository androidSessionRepository, Continuation<? super AndroidSessionRepository$setPrivacy$1> continuation) {
        super(continuation);
        this.this$0 = androidSessionRepository;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.setPrivacy((ByteString) null, this);
    }
}
