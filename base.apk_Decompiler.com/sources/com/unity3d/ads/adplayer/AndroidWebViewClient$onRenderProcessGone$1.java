package com.unity3d.ads.adplayer;

import android.webkit.WebView;
import com.unity3d.ads.core.extensions.ViewExtensionsKt;
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
@DebugMetadata(c = "com.unity3d.ads.adplayer.AndroidWebViewClient$onRenderProcessGone$1", f = "AndroidWebViewClient.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: AndroidWebViewClient.kt */
final class AndroidWebViewClient$onRenderProcessGone$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ WebView $view;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AndroidWebViewClient$onRenderProcessGone$1(WebView webView, Continuation<? super AndroidWebViewClient$onRenderProcessGone$1> continuation) {
        super(2, continuation);
        this.$view = webView;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AndroidWebViewClient$onRenderProcessGone$1(this.$view, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AndroidWebViewClient$onRenderProcessGone$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            WebView webView = this.$view;
            if (webView != null) {
                ViewExtensionsKt.removeViewFromParent(webView);
            }
            WebView webView2 = this.$view;
            if (webView2 != null) {
                webView2.destroy();
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
