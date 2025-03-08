package com.unity3d.ads.core.domain;

import com.unity3d.ads.adplayer.WebViewClientError;
import com.unity3d.ads.core.domain.SendDiagnosticEvent;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.unity3d.ads.core.domain.AndroidSendWebViewClientErrorDiagnostics$invoke$2", f = "AndroidSendWebViewClientErrorDiagnostics.kt", i = {}, l = {25}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: AndroidSendWebViewClientErrorDiagnostics.kt */
final class AndroidSendWebViewClientErrorDiagnostics$invoke$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<WebViewClientError> $errors;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ AndroidSendWebViewClientErrorDiagnostics this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AndroidSendWebViewClientErrorDiagnostics$invoke$2(List<WebViewClientError> list, AndroidSendWebViewClientErrorDiagnostics androidSendWebViewClientErrorDiagnostics, Continuation<? super AndroidSendWebViewClientErrorDiagnostics$invoke$2> continuation) {
        super(2, continuation);
        this.$errors = list;
        this.this$0 = androidSendWebViewClientErrorDiagnostics;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AndroidSendWebViewClientErrorDiagnostics$invoke$2(this.$errors, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AndroidSendWebViewClientErrorDiagnostics$invoke$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        AndroidSendWebViewClientErrorDiagnostics androidSendWebViewClientErrorDiagnostics;
        Iterator it;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            androidSendWebViewClientErrorDiagnostics = this.this$0;
            it = this.$errors.iterator();
        } else if (i == 1) {
            it = (Iterator) this.L$1;
            androidSendWebViewClientErrorDiagnostics = (AndroidSendWebViewClientErrorDiagnostics) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        while (it.hasNext()) {
            WebViewClientError webViewClientError = (WebViewClientError) it.next();
            CharSequence url = webViewClientError.getUrl();
            Map mapOf = (url == null || url.length() == 0) ? null : MapsKt.mapOf(TuplesKt.to("webview_url", webViewClientError.getUrl()));
            Map mutableMapOf = MapsKt.mutableMapOf(TuplesKt.to("reason", Boxing.boxInt(webViewClientError.getReason().getCode())));
            if (webViewClientError.getStatusCode() != null) {
                mutableMapOf.put("webview_error_code", webViewClientError.getStatusCode());
            }
            SendDiagnosticEvent access$getSendDiagnosticEvent$p = androidSendWebViewClientErrorDiagnostics.sendDiagnosticEvent;
            this.L$0 = androidSendWebViewClientErrorDiagnostics;
            this.L$1 = it;
            this.label = 1;
            if (SendDiagnosticEvent.DefaultImpls.invoke$default(access$getSendDiagnosticEvent$p, "webview_error", (Long) null, mapOf, mutableMapOf, this, 2, (Object) null) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
