package com.unity3d.ads.core.domain;

import gateway.v1.UniversalRequestOuterClass;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.core.domain.GetAndroidUniversalRequestForPayLoad", f = "GetAndroidUniversalRequestForPayLoad.kt", i = {0, 0}, l = {12}, m = "invoke", n = {"payload", "$this$invoke_u24lambda_u240"}, s = {"L$0", "L$2"})
/* compiled from: GetAndroidUniversalRequestForPayLoad.kt */
final class GetAndroidUniversalRequestForPayLoad$invoke$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GetAndroidUniversalRequestForPayLoad this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GetAndroidUniversalRequestForPayLoad$invoke$1(GetAndroidUniversalRequestForPayLoad getAndroidUniversalRequestForPayLoad, Continuation<? super GetAndroidUniversalRequestForPayLoad$invoke$1> continuation) {
        super(continuation);
        this.this$0 = getAndroidUniversalRequestForPayLoad;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.invoke((UniversalRequestOuterClass.UniversalRequest.Payload) null, this);
    }
}
