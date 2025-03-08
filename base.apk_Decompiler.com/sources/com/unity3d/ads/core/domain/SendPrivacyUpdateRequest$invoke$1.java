package com.unity3d.ads.core.domain;

import gateway.v1.PrivacyUpdateRequestOuterClass;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.core.domain.SendPrivacyUpdateRequest", f = "SendPrivacyUpdateRequest.kt", i = {0}, l = {14, 16}, m = "invoke", n = {"this"}, s = {"L$0"})
/* compiled from: SendPrivacyUpdateRequest.kt */
final class SendPrivacyUpdateRequest$invoke$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SendPrivacyUpdateRequest this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SendPrivacyUpdateRequest$invoke$1(SendPrivacyUpdateRequest sendPrivacyUpdateRequest, Continuation<? super SendPrivacyUpdateRequest$invoke$1> continuation) {
        super(continuation);
        this.this$0 = sendPrivacyUpdateRequest;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.invoke((PrivacyUpdateRequestOuterClass.PrivacyUpdateRequest) null, this);
    }
}
