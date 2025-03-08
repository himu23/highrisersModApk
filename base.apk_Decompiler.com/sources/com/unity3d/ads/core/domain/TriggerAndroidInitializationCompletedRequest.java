package com.unity3d.ads.core.domain;

import com.unity3d.ads.gatewayclient.GatewayClient;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0011\u0010\t\u001a\u00020\nHBø\u0001\u0000¢\u0006\u0002\u0010\u000bR\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Lcom/unity3d/ads/core/domain/TriggerAndroidInitializationCompletedRequest;", "Lcom/unity3d/ads/core/domain/TriggerInitializationCompletedRequest;", "getInitializationCompletedRequest", "Lcom/unity3d/ads/core/domain/GetInitializationCompletedRequest;", "getRequestPolicy", "Lcom/unity3d/ads/core/domain/GetRequestPolicy;", "gatewayClient", "Lcom/unity3d/ads/gatewayclient/GatewayClient;", "(Lcom/unity3d/ads/core/domain/GetInitializationCompletedRequest;Lcom/unity3d/ads/core/domain/GetRequestPolicy;Lcom/unity3d/ads/gatewayclient/GatewayClient;)V", "invoke", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TriggerAndroidInitializationCompletedRequest.kt */
public final class TriggerAndroidInitializationCompletedRequest implements TriggerInitializationCompletedRequest {
    private final GatewayClient gatewayClient;
    private final GetInitializationCompletedRequest getInitializationCompletedRequest;
    private final GetRequestPolicy getRequestPolicy;

    public TriggerAndroidInitializationCompletedRequest(GetInitializationCompletedRequest getInitializationCompletedRequest2, GetRequestPolicy getRequestPolicy2, GatewayClient gatewayClient2) {
        Intrinsics.checkNotNullParameter(getInitializationCompletedRequest2, "getInitializationCompletedRequest");
        Intrinsics.checkNotNullParameter(getRequestPolicy2, "getRequestPolicy");
        Intrinsics.checkNotNullParameter(gatewayClient2, "gatewayClient");
        this.getInitializationCompletedRequest = getInitializationCompletedRequest2;
        this.getRequestPolicy = getRequestPolicy2;
        this.gatewayClient = gatewayClient2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x006b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object invoke(kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            r10 = this;
            boolean r0 = r11 instanceof com.unity3d.ads.core.domain.TriggerAndroidInitializationCompletedRequest$invoke$1
            if (r0 == 0) goto L_0x0014
            r0 = r11
            com.unity3d.ads.core.domain.TriggerAndroidInitializationCompletedRequest$invoke$1 r0 = (com.unity3d.ads.core.domain.TriggerAndroidInitializationCompletedRequest$invoke$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L_0x0019
        L_0x0014:
            com.unity3d.ads.core.domain.TriggerAndroidInitializationCompletedRequest$invoke$1 r0 = new com.unity3d.ads.core.domain.TriggerAndroidInitializationCompletedRequest$invoke$1
            r0.<init>(r10, r11)
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
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L_0x0036:
            java.lang.Object r1 = r6.L$0
            com.unity3d.ads.core.domain.TriggerAndroidInitializationCompletedRequest r1 = (com.unity3d.ads.core.domain.TriggerAndroidInitializationCompletedRequest) r1
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x004f
        L_0x003e:
            kotlin.ResultKt.throwOnFailure(r11)
            com.unity3d.ads.core.domain.GetInitializationCompletedRequest r11 = r10.getInitializationCompletedRequest
            r6.L$0 = r10
            r6.label = r3
            java.lang.Object r11 = r11.invoke(r6)
            if (r11 != r0) goto L_0x004e
            return r0
        L_0x004e:
            r1 = r10
        L_0x004f:
            r3 = r11
            gateway.v1.UniversalRequestOuterClass$UniversalRequest r3 = (gateway.v1.UniversalRequestOuterClass.UniversalRequest) r3
            com.unity3d.ads.core.domain.GetRequestPolicy r11 = r1.getRequestPolicy
            com.unity3d.ads.gatewayclient.RequestPolicy r4 = r11.invoke()
            com.unity3d.ads.gatewayclient.GatewayClient r1 = r1.gatewayClient
            r11 = 0
            com.unity3d.ads.core.data.model.OperationType r5 = com.unity3d.ads.core.data.model.OperationType.INITIALIZATION_COMPLETED
            r7 = 1
            r8 = 0
            r9 = 0
            r6.L$0 = r9
            r6.label = r2
            r2 = r11
            java.lang.Object r11 = com.unity3d.ads.gatewayclient.GatewayClient.DefaultImpls.request$default(r1, r2, r3, r4, r5, r6, r7, r8)
            if (r11 != r0) goto L_0x006c
            return r0
        L_0x006c:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.TriggerAndroidInitializationCompletedRequest.invoke(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
