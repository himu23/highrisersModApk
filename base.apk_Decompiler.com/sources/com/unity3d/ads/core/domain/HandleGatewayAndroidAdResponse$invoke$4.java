package com.unity3d.ads.core.domain;

import com.unity3d.ads.adplayer.AndroidWebViewContainer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000\u0006\n\u0002\u0010\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H@"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.unity3d.ads.core.domain.HandleGatewayAndroidAdResponse$invoke$4", f = "HandleGatewayAndroidAdResponse.kt", i = {}, l = {133}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: HandleGatewayAndroidAdResponse.kt */
final class HandleGatewayAndroidAdResponse$invoke$4 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ String $webViewUrl;
    final /* synthetic */ AndroidWebViewContainer $webviewContainer;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HandleGatewayAndroidAdResponse$invoke$4(AndroidWebViewContainer androidWebViewContainer, String str, Continuation<? super HandleGatewayAndroidAdResponse$invoke$4> continuation) {
        super(1, continuation);
        this.$webviewContainer = androidWebViewContainer;
        this.$webViewUrl = str;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new HandleGatewayAndroidAdResponse$invoke$4(this.$webviewContainer, this.$webViewUrl, continuation);
    }

    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((HandleGatewayAndroidAdResponse$invoke$4) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (this.$webviewContainer.loadUrl(this.$webViewUrl, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
