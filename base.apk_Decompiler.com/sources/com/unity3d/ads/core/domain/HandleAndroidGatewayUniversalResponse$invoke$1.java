package com.unity3d.ads.core.domain;

import gateway.v1.UniversalResponseOuterClass;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.core.domain.HandleAndroidGatewayUniversalResponse", f = "HandleAndroidGatewayUniversalResponse.kt", i = {0, 0, 1, 1}, l = {31, 37, 40}, m = "invoke", n = {"this", "mutableData", "this", "mutableData"}, s = {"L$0", "L$1", "L$0", "L$1"})
/* compiled from: HandleAndroidGatewayUniversalResponse.kt */
final class HandleAndroidGatewayUniversalResponse$invoke$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ HandleAndroidGatewayUniversalResponse this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HandleAndroidGatewayUniversalResponse$invoke$1(HandleAndroidGatewayUniversalResponse handleAndroidGatewayUniversalResponse, Continuation<? super HandleAndroidGatewayUniversalResponse$invoke$1> continuation) {
        super(continuation);
        this.this$0 = handleAndroidGatewayUniversalResponse;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.invoke((UniversalResponseOuterClass.UniversalResponse) null, this);
    }
}
