package com.unity3d.ads.gatewayclient;

import com.unity3d.ads.core.data.model.OperationType;
import gateway.v1.UniversalRequestOuterClass;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.gatewayclient.CommonGatewayClient", f = "CommonGatewayClient.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 4, 4, 4, 4, 4, 4, 4}, l = {75, 76, 78, 85, 92}, m = "request", n = {"this", "url", "request", "requestPolicy", "operationType", "retryCount", "retryDuration", "startTime", "this", "url", "request", "requestPolicy", "operationType", "retryCount", "httpResponse", "retryDuration", "startTime", "this", "url", "request", "requestPolicy", "operationType", "retryCount", "e", "retryDuration", "this", "url", "request", "requestPolicy", "operationType", "retryCount", "retryDuration"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "J$0", "J$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "J$0", "J$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "J$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "J$0"})
/* compiled from: CommonGatewayClient.kt */
final class CommonGatewayClient$request$1 extends ContinuationImpl {
    long J$0;
    long J$1;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CommonGatewayClient this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CommonGatewayClient$request$1(CommonGatewayClient commonGatewayClient, Continuation<? super CommonGatewayClient$request$1> continuation) {
        super(continuation);
        this.this$0 = commonGatewayClient;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.request((String) null, (UniversalRequestOuterClass.UniversalRequest) null, (RequestPolicy) null, (OperationType) null, this);
    }
}
