package com.unity3d.ads.adplayer;

import android.net.Uri;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import androidx.webkit.WebResourceErrorCompat;
import androidx.webkit.WebViewClientCompat;
import androidx.webkit.WebViewFeature;
import com.unity3d.ads.core.data.model.ErrorReason;
import com.unity3d.ads.core.data.model.ErrorReasonKt;
import java.io.InputStream;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 #2\u00020\u0001:\u0001#B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J \u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0017J \u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u001c\u0010\u001d\u001a\u00020\u001e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u001a\u0010!\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\"\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0014H\u0002R\u001a\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006$"}, d2 = {"Lcom/unity3d/ads/adplayer/AndroidWebViewClient;", "Landroidx/webkit/WebViewClientCompat;", "()V", "_onLoadFinished", "Lkotlinx/coroutines/CompletableDeferred;", "", "Lcom/unity3d/ads/adplayer/WebViewClientError;", "loadErrors", "Lkotlinx/coroutines/flow/MutableStateFlow;", "mainScope", "Lkotlinx/coroutines/CoroutineScope;", "onLoadFinished", "Lkotlinx/coroutines/Deferred;", "getOnLoadFinished", "()Lkotlinx/coroutines/Deferred;", "onPageFinished", "", "view", "Landroid/webkit/WebView;", "url", "", "onReceivedError", "request", "Landroid/webkit/WebResourceRequest;", "error", "Landroidx/webkit/WebResourceErrorCompat;", "onReceivedHttpError", "errorResponse", "Landroid/webkit/WebResourceResponse;", "onRenderProcessGone", "", "detail", "Landroid/webkit/RenderProcessGoneDetail;", "shouldInterceptRequest", "validatePage", "Companion", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidWebViewClient.kt */
public final class AndroidWebViewClient extends WebViewClientCompat {
    public static final String BLANK_PAGE = "about:blank";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final CompletableDeferred<List<WebViewClientError>> _onLoadFinished;
    private final MutableStateFlow<List<WebViewClientError>> loadErrors = StateFlowKt.MutableStateFlow(CollectionsKt.emptyList());
    private final CoroutineScope mainScope = CoroutineScopeKt.MainScope();
    private final Deferred<List<WebViewClientError>> onLoadFinished;

    public final Deferred<List<WebViewClientError>> getOnLoadFinished() {
        return this.onLoadFinished;
    }

    public AndroidWebViewClient() {
        CompletableDeferred<List<WebViewClientError>> CompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default((Job) null, 1, (Object) null);
        this._onLoadFinished = CompletableDeferred$default;
        this.onLoadFinished = CompletableDeferred$default;
    }

    public void onPageFinished(WebView webView, String str) {
        Intrinsics.checkNotNullParameter(webView, "view");
        Intrinsics.checkNotNullParameter(str, "url");
        validatePage(str);
        super.onPageFinished(webView, str);
        this._onLoadFinished.complete(this.loadErrors.getValue());
    }

    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceErrorCompat webResourceErrorCompat) {
        ErrorReason errorReason;
        List<WebViewClientError> value;
        Intrinsics.checkNotNullParameter(webView, "view");
        Intrinsics.checkNotNullParameter(webResourceRequest, "request");
        Intrinsics.checkNotNullParameter(webResourceErrorCompat, "error");
        super.onReceivedError(webView, webResourceRequest, webResourceErrorCompat);
        if (WebViewFeature.isFeatureSupported("WEB_RESOURCE_ERROR_GET_CODE")) {
            errorReason = ErrorReasonKt.webResourceToErrorReason(webResourceErrorCompat.getErrorCode());
        } else {
            errorReason = ErrorReason.REASON_UNKNOWN;
        }
        MutableStateFlow<List<WebViewClientError>> mutableStateFlow = this.loadErrors;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, CollectionsKt.plus(value, new WebViewClientError(webResourceRequest.getUrl().toString(), errorReason, (Integer) null, 4, (DefaultConstructorMarker) null))));
    }

    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        List<WebViewClientError> value;
        Intrinsics.checkNotNullParameter(webView, "view");
        Intrinsics.checkNotNullParameter(webResourceRequest, "request");
        Intrinsics.checkNotNullParameter(webResourceResponse, "errorResponse");
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        WebViewClientError webViewClientError = new WebViewClientError(webResourceRequest.getUrl().toString(), ErrorReason.REASON_WEB_ERROR_RECEIVED_HTTP, Integer.valueOf(webResourceResponse.getStatusCode()));
        MutableStateFlow<List<WebViewClientError>> mutableStateFlow = this.loadErrors;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, CollectionsKt.plus(value, webViewClientError)));
    }

    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        Intrinsics.checkNotNullParameter(webView, "view");
        Intrinsics.checkNotNullParameter(webResourceRequest, "request");
        Uri url = webResourceRequest.getUrl();
        if (Intrinsics.areEqual((Object) url != null ? url.getLastPathSegment() : null, (Object) "favicon.ico")) {
            return new WebResourceResponse("image/png", (String) null, (InputStream) null);
        }
        return super.shouldInterceptRequest(webView, webResourceRequest);
    }

    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        List<WebViewClientError> value;
        Job unused = BuildersKt__Builders_commonKt.launch$default(this.mainScope, (CoroutineContext) null, (CoroutineStart) null, new AndroidWebViewClient$onRenderProcessGone$1(webView, (Continuation<? super AndroidWebViewClient$onRenderProcessGone$1>) null), 3, (Object) null);
        MutableStateFlow<List<WebViewClientError>> mutableStateFlow = this.loadErrors;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, CollectionsKt.plus(value, new WebViewClientError(String.valueOf(webView != null ? webView.getUrl() : null), ErrorReason.REASON_WEBVIEW_RENDER_PROCESS_GONE, (Integer) null, 4, (DefaultConstructorMarker) null))));
        this._onLoadFinished.complete(this.loadErrors.getValue());
        return true;
    }

    private final void validatePage(String str) {
        List<WebViewClientError> value;
        if (Intrinsics.areEqual((Object) str, (Object) BLANK_PAGE)) {
            MutableStateFlow<List<WebViewClientError>> mutableStateFlow = this.loadErrors;
            do {
                value = mutableStateFlow.getValue();
            } while (!mutableStateFlow.compareAndSet(value, CollectionsKt.plus(value, new WebViewClientError(str, ErrorReason.REASON_WEB_BLANK, (Integer) null, 4, (DefaultConstructorMarker) null))));
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/unity3d/ads/adplayer/AndroidWebViewClient$Companion;", "", "()V", "BLANK_PAGE", "", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AndroidWebViewClient.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
