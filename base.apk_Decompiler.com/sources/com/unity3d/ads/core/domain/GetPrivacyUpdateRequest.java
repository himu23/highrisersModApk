package com.unity3d.ads.core.domain;

import gateway.v1.PrivacyUpdateRequestOuterClass;
import gateway.v1.UniversalRequestKt;
import gateway.v1.UniversalRequestOuterClass;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001b\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHBø\u0001\u0000¢\u0006\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"Lcom/unity3d/ads/core/domain/GetPrivacyUpdateRequest;", "", "getUniversalRequestForPayLoad", "Lcom/unity3d/ads/core/domain/GetUniversalRequestForPayLoad;", "(Lcom/unity3d/ads/core/domain/GetUniversalRequestForPayLoad;)V", "invoke", "Lgateway/v1/UniversalRequestOuterClass$UniversalRequest;", "privacyUpdateRequest", "Lgateway/v1/PrivacyUpdateRequestOuterClass$PrivacyUpdateRequest;", "(Lgateway/v1/PrivacyUpdateRequestOuterClass$PrivacyUpdateRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: GetPrivacyUpdateRequest.kt */
public final class GetPrivacyUpdateRequest {
    private final GetUniversalRequestForPayLoad getUniversalRequestForPayLoad;

    public GetPrivacyUpdateRequest(GetUniversalRequestForPayLoad getUniversalRequestForPayLoad2) {
        Intrinsics.checkNotNullParameter(getUniversalRequestForPayLoad2, "getUniversalRequestForPayLoad");
        this.getUniversalRequestForPayLoad = getUniversalRequestForPayLoad2;
    }

    public static /* synthetic */ Object invoke$default(GetPrivacyUpdateRequest getPrivacyUpdateRequest, PrivacyUpdateRequestOuterClass.PrivacyUpdateRequest privacyUpdateRequest, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            privacyUpdateRequest = PrivacyUpdateRequestOuterClass.PrivacyUpdateRequest.getDefaultInstance();
            Intrinsics.checkNotNullExpressionValue(privacyUpdateRequest, "getDefaultInstance()");
        }
        return getPrivacyUpdateRequest.invoke(privacyUpdateRequest, continuation);
    }

    public final Object invoke(PrivacyUpdateRequestOuterClass.PrivacyUpdateRequest privacyUpdateRequest, Continuation<? super UniversalRequestOuterClass.UniversalRequest> continuation) {
        UniversalRequestKt universalRequestKt = UniversalRequestKt.INSTANCE;
        UniversalRequestKt.PayloadKt.Dsl.Companion companion = UniversalRequestKt.PayloadKt.Dsl.Companion;
        UniversalRequestOuterClass.UniversalRequest.Payload.Builder newBuilder = UniversalRequestOuterClass.UniversalRequest.Payload.newBuilder();
        Intrinsics.checkNotNullExpressionValue(newBuilder, "newBuilder()");
        UniversalRequestKt.PayloadKt.Dsl _create = companion._create(newBuilder);
        _create.setPrivacyUpdateRequest(privacyUpdateRequest);
        return this.getUniversalRequestForPayLoad.invoke(_create._build(), continuation);
    }
}
