package com.unity3d.ads.core.domain;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bHBø\u0001\u0000¢\u0006\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"Lcom/unity3d/ads/core/domain/GetAndroidUniversalRequestForPayLoad;", "Lcom/unity3d/ads/core/domain/GetUniversalRequestForPayLoad;", "getUniversalRequestSharedData", "Lcom/unity3d/ads/core/domain/GetUniversalRequestSharedData;", "(Lcom/unity3d/ads/core/domain/GetUniversalRequestSharedData;)V", "invoke", "Lgateway/v1/UniversalRequestOuterClass$UniversalRequest;", "payload", "Lgateway/v1/UniversalRequestOuterClass$UniversalRequest$Payload;", "(Lgateway/v1/UniversalRequestOuterClass$UniversalRequest$Payload;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: GetAndroidUniversalRequestForPayLoad.kt */
public final class GetAndroidUniversalRequestForPayLoad implements GetUniversalRequestForPayLoad {
    private final GetUniversalRequestSharedData getUniversalRequestSharedData;

    public GetAndroidUniversalRequestForPayLoad(GetUniversalRequestSharedData getUniversalRequestSharedData2) {
        Intrinsics.checkNotNullParameter(getUniversalRequestSharedData2, "getUniversalRequestSharedData");
        this.getUniversalRequestSharedData = getUniversalRequestSharedData2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object invoke(gateway.v1.UniversalRequestOuterClass.UniversalRequest.Payload r6, kotlin.coroutines.Continuation<? super gateway.v1.UniversalRequestOuterClass.UniversalRequest> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.unity3d.ads.core.domain.GetAndroidUniversalRequestForPayLoad$invoke$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            com.unity3d.ads.core.domain.GetAndroidUniversalRequestForPayLoad$invoke$1 r0 = (com.unity3d.ads.core.domain.GetAndroidUniversalRequestForPayLoad$invoke$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            com.unity3d.ads.core.domain.GetAndroidUniversalRequestForPayLoad$invoke$1 r0 = new com.unity3d.ads.core.domain.GetAndroidUniversalRequestForPayLoad$invoke$1
            r0.<init>(r5, r7)
        L_0x0019:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0042
            if (r2 != r3) goto L_0x003a
            java.lang.Object r6 = r0.L$3
            gateway.v1.UniversalRequestKt$Dsl r6 = (gateway.v1.UniversalRequestKt.Dsl) r6
            java.lang.Object r1 = r0.L$2
            gateway.v1.UniversalRequestKt$Dsl r1 = (gateway.v1.UniversalRequestKt.Dsl) r1
            java.lang.Object r2 = r0.L$1
            gateway.v1.UniversalRequestKt$Dsl r2 = (gateway.v1.UniversalRequestKt.Dsl) r2
            java.lang.Object r0 = r0.L$0
            gateway.v1.UniversalRequestOuterClass$UniversalRequest$Payload r0 = (gateway.v1.UniversalRequestOuterClass.UniversalRequest.Payload) r0
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x006c
        L_0x003a:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0042:
            kotlin.ResultKt.throwOnFailure(r7)
            gateway.v1.UniversalRequestKt$Dsl$Companion r7 = gateway.v1.UniversalRequestKt.Dsl.Companion
            gateway.v1.UniversalRequestOuterClass$UniversalRequest$Builder r2 = gateway.v1.UniversalRequestOuterClass.UniversalRequest.newBuilder()
            java.lang.String r4 = "newBuilder()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r4)
            gateway.v1.UniversalRequestKt$Dsl r7 = r7._create(r2)
            com.unity3d.ads.core.domain.GetUniversalRequestSharedData r2 = r5.getUniversalRequestSharedData
            r0.L$0 = r6
            r0.L$1 = r7
            r0.L$2 = r7
            r0.L$3 = r7
            r0.label = r3
            java.lang.Object r0 = r2.invoke(r0)
            if (r0 != r1) goto L_0x0067
            return r1
        L_0x0067:
            r1 = r7
            r2 = r1
            r7 = r0
            r0 = r6
            r6 = r2
        L_0x006c:
            gateway.v1.UniversalRequestOuterClass$UniversalRequest$SharedData r7 = (gateway.v1.UniversalRequestOuterClass.UniversalRequest.SharedData) r7
            r6.setSharedData(r7)
            r1.setPayload(r0)
            gateway.v1.UniversalRequestOuterClass$UniversalRequest r6 = r2._build()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.GetAndroidUniversalRequestForPayLoad.invoke(gateway.v1.UniversalRequestOuterClass$UniversalRequest$Payload, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
