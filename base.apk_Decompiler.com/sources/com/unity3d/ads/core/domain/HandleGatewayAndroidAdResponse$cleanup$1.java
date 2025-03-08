package com.unity3d.ads.core.domain;

import com.google.protobuf.ByteString;
import com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer;
import gateway.v1.AdResponseOuterClass;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.core.domain.HandleGatewayAndroidAdResponse", f = "HandleGatewayAndroidAdResponse.kt", i = {0}, l = {181, 187}, m = "cleanup", n = {"adPlayer"}, s = {"L$0"})
/* compiled from: HandleGatewayAndroidAdResponse.kt */
final class HandleGatewayAndroidAdResponse$cleanup$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ HandleGatewayAndroidAdResponse this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HandleGatewayAndroidAdResponse$cleanup$1(HandleGatewayAndroidAdResponse handleGatewayAndroidAdResponse, Continuation<? super HandleGatewayAndroidAdResponse$cleanup$1> continuation) {
        super(continuation);
        this.this$0 = handleGatewayAndroidAdResponse;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.cleanup((Throwable) null, (ByteString) null, (AdResponseOuterClass.AdResponse) null, (AndroidFullscreenWebViewAdPlayer) null, this);
    }
}
