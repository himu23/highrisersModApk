package com.unity3d.ads.core.domain;

import com.unity3d.ads.gatewayclient.GatewayClient;
import gateway.v1.PrivacyUpdateRequestOuterClass;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001b\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fHBø\u0001\u0000¢\u0006\u0002\u0010\rR\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"Lcom/unity3d/ads/core/domain/SendPrivacyUpdateRequest;", "", "getPrivacyUpdateRequest", "Lcom/unity3d/ads/core/domain/GetPrivacyUpdateRequest;", "getRequestPolicy", "Lcom/unity3d/ads/core/domain/GetRequestPolicy;", "gatewayClient", "Lcom/unity3d/ads/gatewayclient/GatewayClient;", "(Lcom/unity3d/ads/core/domain/GetPrivacyUpdateRequest;Lcom/unity3d/ads/core/domain/GetRequestPolicy;Lcom/unity3d/ads/gatewayclient/GatewayClient;)V", "invoke", "Lgateway/v1/PrivacyUpdateResponseOuterClass$PrivacyUpdateResponse;", "privacyUpdateRequest", "Lgateway/v1/PrivacyUpdateRequestOuterClass$PrivacyUpdateRequest;", "(Lgateway/v1/PrivacyUpdateRequestOuterClass$PrivacyUpdateRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SendPrivacyUpdateRequest.kt */
public final class SendPrivacyUpdateRequest {
    private final GatewayClient gatewayClient;
    private final GetPrivacyUpdateRequest getPrivacyUpdateRequest;
    private final GetRequestPolicy getRequestPolicy;

    public SendPrivacyUpdateRequest(GetPrivacyUpdateRequest getPrivacyUpdateRequest2, GetRequestPolicy getRequestPolicy2, GatewayClient gatewayClient2) {
        Intrinsics.checkNotNullParameter(getPrivacyUpdateRequest2, "getPrivacyUpdateRequest");
        Intrinsics.checkNotNullParameter(getRequestPolicy2, "getRequestPolicy");
        Intrinsics.checkNotNullParameter(gatewayClient2, "gatewayClient");
        this.getPrivacyUpdateRequest = getPrivacyUpdateRequest2;
        this.getRequestPolicy = getRequestPolicy2;
        this.gatewayClient = gatewayClient2;
    }

    public static /* synthetic */ Object invoke$default(SendPrivacyUpdateRequest sendPrivacyUpdateRequest, PrivacyUpdateRequestOuterClass.PrivacyUpdateRequest privacyUpdateRequest, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            privacyUpdateRequest = PrivacyUpdateRequestOuterClass.PrivacyUpdateRequest.getDefaultInstance();
            Intrinsics.checkNotNullExpressionValue(privacyUpdateRequest, "getDefaultInstance()");
        }
        return sendPrivacyUpdateRequest.invoke(privacyUpdateRequest, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x006b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invoke(gateway.v1.PrivacyUpdateRequestOuterClass.PrivacyUpdateRequest r10, kotlin.coroutines.Continuation<? super gateway.v1.PrivacyUpdateResponseOuterClass.PrivacyUpdateResponse> r11) {
        /*
            r9 = this;
            boolean r0 = r11 instanceof com.unity3d.ads.core.domain.SendPrivacyUpdateRequest$invoke$1
            if (r0 == 0) goto L_0x0014
            r0 = r11
            com.unity3d.ads.core.domain.SendPrivacyUpdateRequest$invoke$1 r0 = (com.unity3d.ads.core.domain.SendPrivacyUpdateRequest$invoke$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L_0x0019
        L_0x0014:
            com.unity3d.ads.core.domain.SendPrivacyUpdateRequest$invoke$1 r0 = new com.unity3d.ads.core.domain.SendPrivacyUpdateRequest$invoke$1
            r0.<init>(r9, r11)
        L_0x0019:
            r6 = r0
            java.lang.Object r11 = r6.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x003e
            if (r1 == r3) goto L_0x0036
            if (r1 != r2) goto L_0x002e
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x006c
        L_0x002e:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x0036:
            java.lang.Object r10 = r6.L$0
            com.unity3d.ads.core.domain.SendPrivacyUpdateRequest r10 = (com.unity3d.ads.core.domain.SendPrivacyUpdateRequest) r10
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x004f
        L_0x003e:
            kotlin.ResultKt.throwOnFailure(r11)
            com.unity3d.ads.core.domain.GetPrivacyUpdateRequest r11 = r9.getPrivacyUpdateRequest
            r6.L$0 = r9
            r6.label = r3
            java.lang.Object r11 = r11.invoke(r10, r6)
            if (r11 != r0) goto L_0x004e
            return r0
        L_0x004e:
            r10 = r9
        L_0x004f:
            r3 = r11
            gateway.v1.UniversalRequestOuterClass$UniversalRequest r3 = (gateway.v1.UniversalRequestOuterClass.UniversalRequest) r3
            com.unity3d.ads.core.domain.GetRequestPolicy r11 = r10.getRequestPolicy
            com.unity3d.ads.gatewayclient.RequestPolicy r4 = r11.invoke()
            com.unity3d.ads.gatewayclient.GatewayClient r1 = r10.gatewayClient
            r10 = 0
            com.unity3d.ads.core.data.model.OperationType r5 = com.unity3d.ads.core.data.model.OperationType.PRIVACY_UPDATE
            r7 = 1
            r8 = 0
            r11 = 0
            r6.L$0 = r11
            r6.label = r2
            r2 = r10
            java.lang.Object r11 = com.unity3d.ads.gatewayclient.GatewayClient.DefaultImpls.request$default(r1, r2, r3, r4, r5, r6, r7, r8)
            if (r11 != r0) goto L_0x006c
            return r0
        L_0x006c:
            gateway.v1.UniversalResponseOuterClass$UniversalResponse r11 = (gateway.v1.UniversalResponseOuterClass.UniversalResponse) r11
            gateway.v1.UniversalResponseOuterClass$UniversalResponse$Payload r10 = r11.getPayload()
            gateway.v1.PrivacyUpdateResponseOuterClass$PrivacyUpdateResponse r10 = r10.getPrivacyUpdateResponse()
            java.lang.String r11 = "response.payload.privacyUpdateResponse"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r11)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.SendPrivacyUpdateRequest.invoke(gateway.v1.PrivacyUpdateRequestOuterClass$PrivacyUpdateRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
