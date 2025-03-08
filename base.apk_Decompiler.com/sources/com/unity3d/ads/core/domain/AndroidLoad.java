package com.unity3d.ads.core.domain;

import android.content.Context;
import com.google.protobuf.ByteString;
import com.unity3d.ads.core.data.model.LoadResult;
import com.unity3d.ads.core.data.repository.AdRepository;
import com.unity3d.ads.core.data.repository.SessionRepository;
import com.unity3d.ads.gatewayclient.GatewayClient;
import gateway.v1.AdResponseOuterClass;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J1\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aHBø\u0001\u0000¢\u0006\u0002\u0010\u001bR\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u001c"}, d2 = {"Lcom/unity3d/ads/core/domain/AndroidLoad;", "Lcom/unity3d/ads/core/domain/Load;", "defaultDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "getAdRequest", "Lcom/unity3d/ads/core/domain/GetAdRequest;", "getRequestPolicy", "Lcom/unity3d/ads/core/domain/GetRequestPolicy;", "handleGatewayAdResponse", "Lcom/unity3d/ads/core/domain/HandleGatewayAdResponse;", "sessionRepository", "Lcom/unity3d/ads/core/data/repository/SessionRepository;", "gatewayClient", "Lcom/unity3d/ads/gatewayclient/GatewayClient;", "adRepository", "Lcom/unity3d/ads/core/data/repository/AdRepository;", "(Lkotlinx/coroutines/CoroutineDispatcher;Lcom/unity3d/ads/core/domain/GetAdRequest;Lcom/unity3d/ads/core/domain/GetRequestPolicy;Lcom/unity3d/ads/core/domain/HandleGatewayAdResponse;Lcom/unity3d/ads/core/data/repository/SessionRepository;Lcom/unity3d/ads/gatewayclient/GatewayClient;Lcom/unity3d/ads/core/data/repository/AdRepository;)V", "invoke", "Lcom/unity3d/ads/core/data/model/LoadResult;", "context", "Landroid/content/Context;", "placement", "", "opportunityId", "Lcom/google/protobuf/ByteString;", "loadAdResponse", "Lgateway/v1/AdResponseOuterClass$AdResponse;", "(Landroid/content/Context;Ljava/lang/String;Lcom/google/protobuf/ByteString;Lgateway/v1/AdResponseOuterClass$AdResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidLoad.kt */
public final class AndroidLoad implements Load {
    /* access modifiers changed from: private */
    public final AdRepository adRepository;
    private final CoroutineDispatcher defaultDispatcher;
    /* access modifiers changed from: private */
    public final GatewayClient gatewayClient;
    /* access modifiers changed from: private */
    public final GetAdRequest getAdRequest;
    /* access modifiers changed from: private */
    public final GetRequestPolicy getRequestPolicy;
    /* access modifiers changed from: private */
    public final HandleGatewayAdResponse handleGatewayAdResponse;
    /* access modifiers changed from: private */
    public final SessionRepository sessionRepository;

    public AndroidLoad(CoroutineDispatcher coroutineDispatcher, GetAdRequest getAdRequest2, GetRequestPolicy getRequestPolicy2, HandleGatewayAdResponse handleGatewayAdResponse2, SessionRepository sessionRepository2, GatewayClient gatewayClient2, AdRepository adRepository2) {
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "defaultDispatcher");
        Intrinsics.checkNotNullParameter(getAdRequest2, "getAdRequest");
        Intrinsics.checkNotNullParameter(getRequestPolicy2, "getRequestPolicy");
        Intrinsics.checkNotNullParameter(handleGatewayAdResponse2, "handleGatewayAdResponse");
        Intrinsics.checkNotNullParameter(sessionRepository2, "sessionRepository");
        Intrinsics.checkNotNullParameter(gatewayClient2, "gatewayClient");
        Intrinsics.checkNotNullParameter(adRepository2, "adRepository");
        this.defaultDispatcher = coroutineDispatcher;
        this.getAdRequest = getAdRequest2;
        this.getRequestPolicy = getRequestPolicy2;
        this.handleGatewayAdResponse = handleGatewayAdResponse2;
        this.sessionRepository = sessionRepository2;
        this.gatewayClient = gatewayClient2;
        this.adRepository = adRepository2;
    }

    public Object invoke(Context context, String str, ByteString byteString, AdResponseOuterClass.AdResponse adResponse, Continuation<? super LoadResult> continuation) {
        return BuildersKt.withContext(this.defaultDispatcher, new AndroidLoad$invoke$2(this, adResponse, str, byteString, context, (Continuation<? super AndroidLoad$invoke$2>) null), continuation);
    }
}
