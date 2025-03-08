package com.unity3d.ads.core.domain;

import com.google.protobuf.ByteString;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.core.domain.GetAndroidAdDataRefreshRequest", f = "GetAndroidAdDataRefreshRequest.kt", i = {0, 0, 0, 0, 1, 1, 1}, l = {24, 27, 33}, m = "invoke", n = {"this", "opportunityId", "refreshToken", "$this$invoke_u24lambda_u240", "this", "refreshToken", "$this$invoke_u24lambda_u240"}, s = {"L$0", "L$1", "L$2", "L$4", "L$0", "L$1", "L$3"})
/* compiled from: GetAndroidAdDataRefreshRequest.kt */
final class GetAndroidAdDataRefreshRequest$invoke$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GetAndroidAdDataRefreshRequest this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GetAndroidAdDataRefreshRequest$invoke$1(GetAndroidAdDataRefreshRequest getAndroidAdDataRefreshRequest, Continuation<? super GetAndroidAdDataRefreshRequest$invoke$1> continuation) {
        super(continuation);
        this.this$0 = getAndroidAdDataRefreshRequest;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.invoke((ByteString) null, (ByteString) null, this);
    }
}
