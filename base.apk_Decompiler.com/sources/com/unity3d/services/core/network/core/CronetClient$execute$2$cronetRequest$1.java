package com.unity3d.services.core.network.core;

import com.unity3d.ads.core.data.model.OperationType;
import com.unity3d.ads.core.data.model.UnityAdsNetworkException;
import com.unity3d.services.core.network.model.HttpResponse;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import org.chromium.net.CronetException;
import org.chromium.net.NetworkException;
import org.chromium.net.UrlRequest;
import org.chromium.net.UrlResponseInfo;

@Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J&\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J \u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, d2 = {"com/unity3d/services/core/network/core/CronetClient$execute$2$cronetRequest$1", "Lcom/unity3d/services/core/network/core/UnityAdsUrlRequestCallback;", "onFailed", "", "request", "Lorg/chromium/net/UrlRequest;", "info", "Lorg/chromium/net/UrlResponseInfo;", "error", "Lorg/chromium/net/CronetException;", "onSucceeded", "bodyBytes", "", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: CronetClient.kt */
public final class CronetClient$execute$2$cronetRequest$1 extends UnityAdsUrlRequestCallback {
    final /* synthetic */ CancellableContinuation<HttpResponse> $cont;

    CronetClient$execute$2$cronetRequest$1(CancellableContinuation<? super HttpResponse> cancellableContinuation) {
        this.$cont = cancellableContinuation;
    }

    public void onSucceeded(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, byte[] bArr) {
        Intrinsics.checkNotNullParameter(urlRequest, "request");
        Intrinsics.checkNotNullParameter(urlResponseInfo, "info");
        Intrinsics.checkNotNullParameter(bArr, "bodyBytes");
        int httpStatusCode = urlResponseInfo.getHttpStatusCode();
        Map<String, List<String>> allHeaders = urlResponseInfo.getAllHeaders();
        String url = urlResponseInfo.getUrl();
        String negotiatedProtocol = urlResponseInfo.getNegotiatedProtocol();
        Intrinsics.checkNotNullExpressionValue(allHeaders, "allHeaders");
        Intrinsics.checkNotNullExpressionValue(url, "url");
        Intrinsics.checkNotNullExpressionValue(negotiatedProtocol, "negotiatedProtocol");
        HttpResponse httpResponse = new HttpResponse(bArr, httpStatusCode, allHeaders, url, negotiatedProtocol, "cronet");
        Result.Companion companion = Result.Companion;
        this.$cont.resumeWith(Result.m144constructorimpl(httpResponse));
    }

    public void onFailed(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, CronetException cronetException) {
        String str = null;
        NetworkException networkException = cronetException instanceof NetworkException ? (NetworkException) cronetException : null;
        Integer valueOf = networkException != null ? Integer.valueOf(networkException.getCronetInternalErrorCode()) : null;
        Integer valueOf2 = urlResponseInfo != null ? Integer.valueOf(urlResponseInfo.getHttpStatusCode()) : null;
        String url = urlResponseInfo != null ? urlResponseInfo.getUrl() : null;
        if (urlResponseInfo != null) {
            str = urlResponseInfo.getNegotiatedProtocol();
        }
        UnityAdsNetworkException unityAdsNetworkException = new UnityAdsNetworkException("Network request failed", (OperationType) null, valueOf2, url, str, valueOf, "cronet", 2, (DefaultConstructorMarker) null);
        Result.Companion companion = Result.Companion;
        this.$cont.resumeWith(Result.m144constructorimpl(ResultKt.createFailure(unityAdsNetworkException)));
    }
}
