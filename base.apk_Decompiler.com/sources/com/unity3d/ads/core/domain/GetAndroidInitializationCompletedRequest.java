package com.unity3d.ads.core.domain;

import com.unity3d.ads.core.data.repository.DeviceInfoRepository;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0011\u0010\u0007\u001a\u00020\bHBø\u0001\u0000¢\u0006\u0002\u0010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"Lcom/unity3d/ads/core/domain/GetAndroidInitializationCompletedRequest;", "Lcom/unity3d/ads/core/domain/GetInitializationCompletedRequest;", "getUniversalRequestForPayLoad", "Lcom/unity3d/ads/core/domain/GetUniversalRequestForPayLoad;", "deviceInfoRepository", "Lcom/unity3d/ads/core/data/repository/DeviceInfoRepository;", "(Lcom/unity3d/ads/core/domain/GetUniversalRequestForPayLoad;Lcom/unity3d/ads/core/data/repository/DeviceInfoRepository;)V", "invoke", "Lgateway/v1/UniversalRequestOuterClass$UniversalRequest;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: GetAndroidInitializationCompletedRequest.kt */
public final class GetAndroidInitializationCompletedRequest implements GetInitializationCompletedRequest {
    private final DeviceInfoRepository deviceInfoRepository;
    private final GetUniversalRequestForPayLoad getUniversalRequestForPayLoad;

    public GetAndroidInitializationCompletedRequest(GetUniversalRequestForPayLoad getUniversalRequestForPayLoad2, DeviceInfoRepository deviceInfoRepository2) {
        Intrinsics.checkNotNullParameter(getUniversalRequestForPayLoad2, "getUniversalRequestForPayLoad");
        Intrinsics.checkNotNullParameter(deviceInfoRepository2, "deviceInfoRepository");
        this.getUniversalRequestForPayLoad = getUniversalRequestForPayLoad2;
        this.deviceInfoRepository = deviceInfoRepository2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00ad A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00ae A[PHI: r9 
      PHI: (r9v2 java.lang.Object) = (r9v9 java.lang.Object), (r9v1 java.lang.Object) binds: [B:19:0x00ab, B:10:0x002b] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object invoke(kotlin.coroutines.Continuation<? super gateway.v1.UniversalRequestOuterClass.UniversalRequest> r9) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof com.unity3d.ads.core.domain.GetAndroidInitializationCompletedRequest$invoke$1
            if (r0 == 0) goto L_0x0014
            r0 = r9
            com.unity3d.ads.core.domain.GetAndroidInitializationCompletedRequest$invoke$1 r0 = (com.unity3d.ads.core.domain.GetAndroidInitializationCompletedRequest$invoke$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L_0x0019
        L_0x0014:
            com.unity3d.ads.core.domain.GetAndroidInitializationCompletedRequest$invoke$1 r0 = new com.unity3d.ads.core.domain.GetAndroidInitializationCompletedRequest$invoke$1
            r0.<init>(r8, r9)
        L_0x0019:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            java.lang.String r3 = "newBuilder()"
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x004c
            if (r2 == r5) goto L_0x0038
            if (r2 != r4) goto L_0x0030
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x00ae
        L_0x0030:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L_0x0038:
            java.lang.Object r2 = r0.L$3
            gateway.v1.InitializationCompletedEventRequestKt$Dsl r2 = (gateway.v1.InitializationCompletedEventRequestKt.Dsl) r2
            java.lang.Object r5 = r0.L$2
            gateway.v1.InitializationCompletedEventRequestKt$Dsl r5 = (gateway.v1.InitializationCompletedEventRequestKt.Dsl) r5
            java.lang.Object r6 = r0.L$1
            gateway.v1.InitializationCompletedEventRequestKt$Dsl r6 = (gateway.v1.InitializationCompletedEventRequestKt.Dsl) r6
            java.lang.Object r7 = r0.L$0
            com.unity3d.ads.core.domain.GetAndroidInitializationCompletedRequest r7 = (com.unity3d.ads.core.domain.GetAndroidInitializationCompletedRequest) r7
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0072
        L_0x004c:
            kotlin.ResultKt.throwOnFailure(r9)
            gateway.v1.InitializationCompletedEventRequestKt$Dsl$Companion r9 = gateway.v1.InitializationCompletedEventRequestKt.Dsl.Companion
            gateway.v1.InitializationCompletedEventRequestOuterClass$InitializationCompletedEventRequest$Builder r2 = gateway.v1.InitializationCompletedEventRequestOuterClass.InitializationCompletedEventRequest.newBuilder()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            gateway.v1.InitializationCompletedEventRequestKt$Dsl r2 = r9._create(r2)
            com.unity3d.ads.core.data.repository.DeviceInfoRepository r9 = r8.deviceInfoRepository
            r0.L$0 = r8
            r0.L$1 = r2
            r0.L$2 = r2
            r0.L$3 = r2
            r0.label = r5
            java.lang.Object r9 = r9.staticDeviceInfo(r0)
            if (r9 != r1) goto L_0x006f
            return r1
        L_0x006f:
            r7 = r8
            r5 = r2
            r6 = r5
        L_0x0072:
            gateway.v1.StaticDeviceInfoOuterClass$StaticDeviceInfo r9 = (gateway.v1.StaticDeviceInfoOuterClass.StaticDeviceInfo) r9
            r2.setStaticDeviceInfo(r9)
            com.unity3d.ads.core.data.repository.DeviceInfoRepository r9 = r7.deviceInfoRepository
            gateway.v1.DynamicDeviceInfoOuterClass$DynamicDeviceInfo r9 = r9.getDynamicDeviceInfo()
            r5.setDynamicDeviceInfo(r9)
            gateway.v1.InitializationCompletedEventRequestOuterClass$InitializationCompletedEventRequest r9 = r6._build()
            gateway.v1.UniversalRequestKt r2 = gateway.v1.UniversalRequestKt.INSTANCE
            gateway.v1.UniversalRequestKt$PayloadKt$Dsl$Companion r2 = gateway.v1.UniversalRequestKt.PayloadKt.Dsl.Companion
            gateway.v1.UniversalRequestOuterClass$UniversalRequest$Payload$Builder r5 = gateway.v1.UniversalRequestOuterClass.UniversalRequest.Payload.newBuilder()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r3)
            gateway.v1.UniversalRequestKt$PayloadKt$Dsl r2 = r2._create(r5)
            r2.setInitializationCompletedEventRequest(r9)
            gateway.v1.UniversalRequestOuterClass$UniversalRequest$Payload r9 = r2._build()
            com.unity3d.ads.core.domain.GetUniversalRequestForPayLoad r2 = r7.getUniversalRequestForPayLoad
            r3 = 0
            r0.L$0 = r3
            r0.L$1 = r3
            r0.L$2 = r3
            r0.L$3 = r3
            r0.label = r4
            java.lang.Object r9 = r2.invoke(r9, r0)
            if (r9 != r1) goto L_0x00ae
            return r1
        L_0x00ae:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.GetAndroidInitializationCompletedRequest.invoke(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
