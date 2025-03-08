package com.unity3d.ads.adplayer;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.unity3d.ads.adplayer.CommonWebViewBridge$handleInvocation$1", f = "CommonWebViewBridge.kt", i = {}, l = {102}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: CommonWebViewBridge.kt */
final class CommonWebViewBridge$handleInvocation$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $callback;
    final /* synthetic */ String $className;
    final /* synthetic */ String $methodName;
    int label;
    final /* synthetic */ CommonWebViewBridge this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CommonWebViewBridge$handleInvocation$1(CommonWebViewBridge commonWebViewBridge, String str, String str2, String str3, Continuation<? super CommonWebViewBridge$handleInvocation$1> continuation) {
        super(2, continuation);
        this.this$0 = commonWebViewBridge;
        this.$callback = str;
        this.$className = str2;
        this.$methodName = str3;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CommonWebViewBridge$handleInvocation$1(this.this$0, this.$callback, this.$className, this.$methodName, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CommonWebViewBridge$handleInvocation$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CommonWebViewBridge commonWebViewBridge = this.this$0;
            String str = this.$callback;
            Object[] objArr = {this.$className + '.' + this.$methodName + " is not valid."};
            this.label = 1;
            if (commonWebViewBridge.respond(str, "ERROR", objArr, this) == coroutine_suspended) {
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
