package com.unity3d.ads.core.domain.events;

import com.google.protobuf.ByteString;
import gateway.v1.OperativeEventRequestOuterClass;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.core.domain.events.GetOperativeEventRequest", f = "GetOperativeEventRequest.kt", i = {0, 0}, l = {33, 35}, m = "invoke", n = {"this", "$this$invoke_u24lambda_u241"}, s = {"L$0", "L$2"})
/* compiled from: GetOperativeEventRequest.kt */
final class GetOperativeEventRequest$invoke$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GetOperativeEventRequest this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GetOperativeEventRequest$invoke$1(GetOperativeEventRequest getOperativeEventRequest, Continuation<? super GetOperativeEventRequest$invoke$1> continuation) {
        super(continuation);
        this.this$0 = getOperativeEventRequest;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.invoke((OperativeEventRequestOuterClass.OperativeEventType) null, (ByteString) null, (ByteString) null, (ByteString) null, (String) null, this);
    }
}
