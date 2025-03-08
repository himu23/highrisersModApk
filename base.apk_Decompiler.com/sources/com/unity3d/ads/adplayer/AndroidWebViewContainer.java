package com.unity3d.ads.adplayer;

import android.webkit.WebView;
import com.unity3d.ads.core.domain.SendWebViewClientErrorDiagnostics;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ!\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H@ø\u0001\u0000¢\u0006\u0002\u0010\u0016J\u0011\u0010\u0017\u001a\u00020\u0011H@ø\u0001\u0000¢\u0006\u0002\u0010\u0018J\u0019\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u0015H@ø\u0001\u0000¢\u0006\u0002\u0010\u001bJ\u0019\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u0015H@ø\u0001\u0000¢\u0006\u0002\u0010\u001bR\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u001e"}, d2 = {"Lcom/unity3d/ads/adplayer/AndroidWebViewContainer;", "Lcom/unity3d/ads/adplayer/WebViewContainer;", "webView", "Landroid/webkit/WebView;", "webViewClient", "Lcom/unity3d/ads/adplayer/AndroidWebViewClient;", "sendWebViewClientErrorDiagnostics", "Lcom/unity3d/ads/core/domain/SendWebViewClientErrorDiagnostics;", "(Landroid/webkit/WebView;Lcom/unity3d/ads/adplayer/AndroidWebViewClient;Lcom/unity3d/ads/core/domain/SendWebViewClientErrorDiagnostics;)V", "isDestroyed", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "mainScope", "Lkotlinx/coroutines/CoroutineScope;", "getWebView", "()Landroid/webkit/WebView;", "addJavascriptInterface", "", "webViewBridgeInterface", "Lcom/unity3d/ads/adplayer/WebViewBridge;", "name", "", "(Lcom/unity3d/ads/adplayer/WebViewBridge;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "destroy", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "evaluateJavascript", "script", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadUrl", "url", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidWebViewContainer.kt */
public final class AndroidWebViewContainer implements WebViewContainer {
    /* access modifiers changed from: private */
    public final MutableStateFlow<Boolean> isDestroyed = StateFlowKt.MutableStateFlow(false);
    private final CoroutineScope mainScope = CoroutineScopeKt.plus(CoroutineScopeKt.MainScope(), new CoroutineName("AndroidWebViewContainer"));
    private final SendWebViewClientErrorDiagnostics sendWebViewClientErrorDiagnostics;
    private final WebView webView;
    private final AndroidWebViewClient webViewClient;

    public final WebView getWebView() {
        return this.webView;
    }

    public AndroidWebViewContainer(WebView webView2, AndroidWebViewClient androidWebViewClient, SendWebViewClientErrorDiagnostics sendWebViewClientErrorDiagnostics2) {
        Intrinsics.checkNotNullParameter(webView2, "webView");
        Intrinsics.checkNotNullParameter(androidWebViewClient, "webViewClient");
        Intrinsics.checkNotNullParameter(sendWebViewClientErrorDiagnostics2, "sendWebViewClientErrorDiagnostics");
        this.webView = webView2;
        this.webViewClient = androidWebViewClient;
        this.sendWebViewClientErrorDiagnostics = sendWebViewClientErrorDiagnostics2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x008a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00b3 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object loadUrl(java.lang.String r9, kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof com.unity3d.ads.adplayer.AndroidWebViewContainer$loadUrl$1
            if (r0 == 0) goto L_0x0014
            r0 = r10
            com.unity3d.ads.adplayer.AndroidWebViewContainer$loadUrl$1 r0 = (com.unity3d.ads.adplayer.AndroidWebViewContainer$loadUrl$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L_0x0019
        L_0x0014:
            com.unity3d.ads.adplayer.AndroidWebViewContainer$loadUrl$1 r0 = new com.unity3d.ads.adplayer.AndroidWebViewContainer$loadUrl$1
            r0.<init>(r8, r10)
        L_0x0019:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 4
            r5 = 3
            r6 = 2
            r7 = 1
            if (r2 == 0) goto L_0x005e
            if (r2 == r7) goto L_0x0056
            if (r2 == r6) goto L_0x004d
            if (r2 == r5) goto L_0x0041
            if (r2 == r4) goto L_0x0038
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x0038:
            java.lang.Object r9 = r0.L$0
            java.util.List r9 = (java.util.List) r9
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x00b4
        L_0x0041:
            java.lang.Object r9 = r0.L$1
            java.util.List r9 = (java.util.List) r9
            java.lang.Object r2 = r0.L$0
            com.unity3d.ads.adplayer.AndroidWebViewContainer r2 = (com.unity3d.ads.adplayer.AndroidWebViewContainer) r2
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x00a5
        L_0x004d:
            java.lang.Object r9 = r0.L$0
            com.unity3d.ads.adplayer.AndroidWebViewContainer r9 = (com.unity3d.ads.adplayer.AndroidWebViewContainer) r9
            kotlin.ResultKt.throwOnFailure(r10)
        L_0x0054:
            r2 = r9
            goto L_0x008b
        L_0x0056:
            java.lang.Object r9 = r0.L$0
            com.unity3d.ads.adplayer.AndroidWebViewContainer r9 = (com.unity3d.ads.adplayer.AndroidWebViewContainer) r9
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x007a
        L_0x005e:
            kotlin.ResultKt.throwOnFailure(r10)
            kotlinx.coroutines.CoroutineScope r10 = r8.mainScope
            kotlin.coroutines.CoroutineContext r10 = r10.getCoroutineContext()
            com.unity3d.ads.adplayer.AndroidWebViewContainer$loadUrl$2 r2 = new com.unity3d.ads.adplayer.AndroidWebViewContainer$loadUrl$2
            r2.<init>(r8, r9, r3)
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            r0.L$0 = r8
            r0.label = r7
            java.lang.Object r9 = kotlinx.coroutines.BuildersKt.withContext(r10, r2, r0)
            if (r9 != r1) goto L_0x0079
            return r1
        L_0x0079:
            r9 = r8
        L_0x007a:
            com.unity3d.ads.adplayer.AndroidWebViewClient r10 = r9.webViewClient
            kotlinx.coroutines.Deferred r10 = r10.getOnLoadFinished()
            r0.L$0 = r9
            r0.label = r6
            java.lang.Object r10 = r10.await(r0)
            if (r10 != r1) goto L_0x0054
            return r1
        L_0x008b:
            java.util.List r10 = (java.util.List) r10
            r9 = r10
            java.util.Collection r9 = (java.util.Collection) r9
            boolean r9 = r9.isEmpty()
            r9 = r9 ^ r7
            if (r9 == 0) goto L_0x00ba
            r0.L$0 = r2
            r0.L$1 = r10
            r0.label = r5
            java.lang.Object r9 = r2.destroy(r0)
            if (r9 != r1) goto L_0x00a4
            return r1
        L_0x00a4:
            r9 = r10
        L_0x00a5:
            com.unity3d.ads.core.domain.SendWebViewClientErrorDiagnostics r10 = r2.sendWebViewClientErrorDiagnostics
            r0.L$0 = r9
            r0.L$1 = r3
            r0.label = r4
            java.lang.Object r10 = r10.invoke(r9, r0)
            if (r10 != r1) goto L_0x00b4
            return r1
        L_0x00b4:
            com.unity3d.ads.adplayer.LoadWebViewError r10 = new com.unity3d.ads.adplayer.LoadWebViewError
            r10.<init>(r9)
            throw r10
        L_0x00ba:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.adplayer.AndroidWebViewContainer.loadUrl(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public Object evaluateJavascript(String str, Continuation<? super Unit> continuation) {
        if (this.isDestroyed.getValue().booleanValue()) {
            return Unit.INSTANCE;
        }
        Object withContext = BuildersKt.withContext(this.mainScope.getCoroutineContext(), new AndroidWebViewContainer$evaluateJavascript$2(this, str, (Continuation<? super AndroidWebViewContainer$evaluateJavascript$2>) null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    public Object addJavascriptInterface(WebViewBridge webViewBridge, String str, Continuation<? super Unit> continuation) {
        if (this.isDestroyed.getValue().booleanValue()) {
            return Unit.INSTANCE;
        }
        Object withContext = BuildersKt.withContext(this.mainScope.getCoroutineContext(), new AndroidWebViewContainer$addJavascriptInterface$2(this, webViewBridge, str, (Continuation<? super AndroidWebViewContainer$addJavascriptInterface$2>) null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object destroy(kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.unity3d.ads.adplayer.AndroidWebViewContainer$destroy$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            com.unity3d.ads.adplayer.AndroidWebViewContainer$destroy$1 r0 = (com.unity3d.ads.adplayer.AndroidWebViewContainer$destroy$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            com.unity3d.ads.adplayer.AndroidWebViewContainer$destroy$1 r0 = new com.unity3d.ads.adplayer.AndroidWebViewContainer$destroy$1
            r0.<init>(r5, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r4) goto L_0x002f
            java.lang.Object r0 = r0.L$0
            com.unity3d.ads.adplayer.AndroidWebViewContainer r0 = (com.unity3d.ads.adplayer.AndroidWebViewContainer) r0
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0064
        L_0x002f:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r6)
            kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> r6 = r5.isDestroyed
            java.lang.Object r6 = r6.getValue()
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            if (r6 == 0) goto L_0x004b
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L_0x004b:
            kotlinx.coroutines.CoroutineScope r6 = r5.mainScope
            kotlin.coroutines.CoroutineContext r6 = r6.getCoroutineContext()
            com.unity3d.ads.adplayer.AndroidWebViewContainer$destroy$2 r2 = new com.unity3d.ads.adplayer.AndroidWebViewContainer$destroy$2
            r2.<init>(r5, r3)
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            r0.L$0 = r5
            r0.label = r4
            java.lang.Object r6 = kotlinx.coroutines.BuildersKt.withContext(r6, r2, r0)
            if (r6 != r1) goto L_0x0063
            return r1
        L_0x0063:
            r0 = r5
        L_0x0064:
            kotlinx.coroutines.CoroutineScope r6 = r0.mainScope
            kotlinx.coroutines.CoroutineScopeKt.cancel$default(r6, r3, r4, r3)
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.adplayer.AndroidWebViewContainer.destroy(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
