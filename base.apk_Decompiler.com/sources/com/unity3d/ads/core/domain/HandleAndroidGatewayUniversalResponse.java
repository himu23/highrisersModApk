package com.unity3d.ads.core.domain;

import com.unity3d.ads.core.data.repository.DeviceInfoRepository;
import com.unity3d.ads.core.data.repository.SessionRepository;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0019\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nHBø\u0001\u0000¢\u0006\u0002\u0010\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Lcom/unity3d/ads/core/domain/HandleAndroidGatewayUniversalResponse;", "Lcom/unity3d/ads/core/domain/HandleGatewayUniversalResponse;", "sessionRepository", "Lcom/unity3d/ads/core/data/repository/SessionRepository;", "deviceInfoRepository", "Lcom/unity3d/ads/core/data/repository/DeviceInfoRepository;", "(Lcom/unity3d/ads/core/data/repository/SessionRepository;Lcom/unity3d/ads/core/data/repository/DeviceInfoRepository;)V", "invoke", "", "response", "Lgateway/v1/UniversalResponseOuterClass$UniversalResponse;", "(Lgateway/v1/UniversalResponseOuterClass$UniversalResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: HandleAndroidGatewayUniversalResponse.kt */
public final class HandleAndroidGatewayUniversalResponse implements HandleGatewayUniversalResponse {
    private final DeviceInfoRepository deviceInfoRepository;
    private final SessionRepository sessionRepository;

    public HandleAndroidGatewayUniversalResponse(SessionRepository sessionRepository2, DeviceInfoRepository deviceInfoRepository2) {
        Intrinsics.checkNotNullParameter(sessionRepository2, "sessionRepository");
        Intrinsics.checkNotNullParameter(deviceInfoRepository2, "deviceInfoRepository");
        this.sessionRepository = sessionRepository2;
        this.deviceInfoRepository = deviceInfoRepository2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object invoke(gateway.v1.UniversalResponseOuterClass.UniversalResponse r9, kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof com.unity3d.ads.core.domain.HandleAndroidGatewayUniversalResponse$invoke$1
            if (r0 == 0) goto L_0x0014
            r0 = r10
            com.unity3d.ads.core.domain.HandleAndroidGatewayUniversalResponse$invoke$1 r0 = (com.unity3d.ads.core.domain.HandleAndroidGatewayUniversalResponse$invoke$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L_0x0019
        L_0x0014:
            com.unity3d.ads.core.domain.HandleAndroidGatewayUniversalResponse$invoke$1 r0 = new com.unity3d.ads.core.domain.HandleAndroidGatewayUniversalResponse$invoke$1
            r0.<init>(r8, r10)
        L_0x0019:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0052
            if (r2 == r5) goto L_0x0046
            if (r2 == r4) goto L_0x0039
            if (r2 != r3) goto L_0x0031
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x0113
        L_0x0031:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x0039:
            java.lang.Object r9 = r0.L$1
            gateway.v1.MutableDataOuterClass$MutableData r9 = (gateway.v1.MutableDataOuterClass.MutableData) r9
            java.lang.Object r2 = r0.L$0
            com.unity3d.ads.core.domain.HandleAndroidGatewayUniversalResponse r2 = (com.unity3d.ads.core.domain.HandleAndroidGatewayUniversalResponse) r2
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x00f4
        L_0x0046:
            java.lang.Object r9 = r0.L$1
            gateway.v1.MutableDataOuterClass$MutableData r9 = (gateway.v1.MutableDataOuterClass.MutableData) r9
            java.lang.Object r2 = r0.L$0
            com.unity3d.ads.core.domain.HandleAndroidGatewayUniversalResponse r2 = (com.unity3d.ads.core.domain.HandleAndroidGatewayUniversalResponse) r2
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x00c2
        L_0x0052:
            kotlin.ResultKt.throwOnFailure(r10)
            boolean r10 = r9.hasError()
            if (r10 != 0) goto L_0x0119
            boolean r10 = r9.hasMutableData()
            if (r10 == 0) goto L_0x0116
            gateway.v1.MutableDataOuterClass$MutableData r9 = r9.getMutableData()
            com.unity3d.ads.core.data.repository.DeviceInfoRepository r10 = r8.deviceInfoRepository
            kotlinx.coroutines.flow.MutableStateFlow r10 = r10.getAllowedPii()
        L_0x006b:
            java.lang.Object r2 = r10.getValue()
            r6 = r2
            gateway.v1.AllowedPiiOuterClass$AllowedPii r6 = (gateway.v1.AllowedPiiOuterClass.AllowedPii) r6
            gateway.v1.AllowedPiiOuterClass$AllowedPii r6 = r9.getAllowedPii()
            java.lang.String r7 = "mutableData.allowedPii"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)
            boolean r2 = r10.compareAndSet(r2, r6)
            if (r2 == 0) goto L_0x006b
            com.unity3d.ads.core.data.repository.SessionRepository r10 = r8.sessionRepository
            com.google.protobuf.ByteString r2 = r9.getCurrentState()
            java.lang.String r6 = "mutableData.currentState"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r6)
            r10.setGatewayState(r2)
            boolean r10 = r9.hasSessionToken()
            if (r10 == 0) goto L_0x00a3
            com.unity3d.ads.core.data.repository.SessionRepository r10 = r8.sessionRepository
            com.google.protobuf.ByteString r2 = r9.getSessionToken()
            java.lang.String r6 = "mutableData.sessionToken"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r6)
            r10.setSessionToken(r2)
        L_0x00a3:
            boolean r10 = r9.hasPrivacy()
            if (r10 == 0) goto L_0x00c1
            com.unity3d.ads.core.data.repository.SessionRepository r10 = r8.sessionRepository
            com.google.protobuf.ByteString r2 = r9.getPrivacy()
            java.lang.String r6 = "mutableData.privacy"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r6)
            r0.L$0 = r8
            r0.L$1 = r9
            r0.label = r5
            java.lang.Object r10 = r10.setPrivacy(r2, r0)
            if (r10 != r1) goto L_0x00c1
            return r1
        L_0x00c1:
            r2 = r8
        L_0x00c2:
            boolean r10 = r9.hasSessionCounters()
            if (r10 == 0) goto L_0x00d6
            com.unity3d.ads.core.data.repository.SessionRepository r10 = r2.sessionRepository
            gateway.v1.SessionCountersOuterClass$SessionCounters r5 = r9.getSessionCounters()
            java.lang.String r6 = "mutableData.sessionCounters"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
            r10.setSessionCounters(r5)
        L_0x00d6:
            boolean r10 = r9.hasCache()
            if (r10 == 0) goto L_0x00f4
            com.unity3d.ads.core.data.repository.SessionRepository r10 = r2.sessionRepository
            com.google.protobuf.ByteString r5 = r9.getCache()
            java.lang.String r6 = "mutableData.cache"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
            r0.L$0 = r2
            r0.L$1 = r9
            r0.label = r4
            java.lang.Object r10 = r10.setGatewayCache(r5, r0)
            if (r10 != r1) goto L_0x00f4
            return r1
        L_0x00f4:
            boolean r10 = r9.hasPrivacyFsm()
            if (r10 == 0) goto L_0x0116
            com.unity3d.ads.core.data.repository.SessionRepository r10 = r2.sessionRepository
            com.google.protobuf.ByteString r9 = r9.getPrivacyFsm()
            java.lang.String r2 = "mutableData.privacyFsm"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r2)
            r2 = 0
            r0.L$0 = r2
            r0.L$1 = r2
            r0.label = r3
            java.lang.Object r9 = r10.setPrivacyFsm(r9, r0)
            if (r9 != r1) goto L_0x0113
            return r1
        L_0x0113:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        L_0x0116:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        L_0x0119:
            com.unity3d.ads.core.data.repository.SessionRepository r9 = r8.sessionRepository
            r10 = 0
            r9.setShouldInitialize(r10)
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "Gateway communication failure"
            r9.<init>(r10)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.HandleAndroidGatewayUniversalResponse.invoke(gateway.v1.UniversalResponseOuterClass$UniversalResponse, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
