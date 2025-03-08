package com.unity3d.ads.core.domain;

import android.content.Context;
import com.google.protobuf.ByteString;
import gateway.v1.AdResponseOuterClass;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.core.domain.HandleGatewayAndroidAdResponse", f = "HandleGatewayAndroidAdResponse.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 5}, l = {89, 137, 138, 154, 160, 164}, m = "invoke", n = {"this", "opportunityId", "response", "placementId", "adPlayer", "webViewUrl", "base64ImpressionConfiguration", "this", "opportunityId", "response", "adPlayer", "adObject", "this", "opportunityId", "response", "adPlayer", "adObject", "this", "opportunityId", "response", "adPlayer", "loadFailure", "this", "opportunityId", "response", "adPlayer", "adObject", "t"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0"})
/* compiled from: HandleGatewayAndroidAdResponse.kt */
final class HandleGatewayAndroidAdResponse$invoke$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ HandleGatewayAndroidAdResponse this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HandleGatewayAndroidAdResponse$invoke$1(HandleGatewayAndroidAdResponse handleGatewayAndroidAdResponse, Continuation<? super HandleGatewayAndroidAdResponse$invoke$1> continuation) {
        super(continuation);
        this.this$0 = handleGatewayAndroidAdResponse;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.invoke((ByteString) null, (AdResponseOuterClass.AdResponse) null, (Context) null, (String) null, this);
    }
}
