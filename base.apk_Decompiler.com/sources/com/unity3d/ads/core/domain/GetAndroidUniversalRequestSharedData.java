package com.unity3d.ads.core.domain;

import com.unity3d.ads.core.data.repository.DeveloperConsentRepository;
import com.unity3d.ads.core.data.repository.DeviceInfoRepository;
import com.unity3d.ads.core.data.repository.SessionRepository;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0011\u0010\u000b\u001a\u00020\fHBø\u0001\u0000¢\u0006\u0002\u0010\rR\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"Lcom/unity3d/ads/core/domain/GetAndroidUniversalRequestSharedData;", "Lcom/unity3d/ads/core/domain/GetUniversalRequestSharedData;", "getSharedDataTimestamps", "Lcom/unity3d/ads/core/domain/GetSharedDataTimestamps;", "sessionRepository", "Lcom/unity3d/ads/core/data/repository/SessionRepository;", "deviceInfoRepository", "Lcom/unity3d/ads/core/data/repository/DeviceInfoRepository;", "developerConsentRepository", "Lcom/unity3d/ads/core/data/repository/DeveloperConsentRepository;", "(Lcom/unity3d/ads/core/domain/GetSharedDataTimestamps;Lcom/unity3d/ads/core/data/repository/SessionRepository;Lcom/unity3d/ads/core/data/repository/DeviceInfoRepository;Lcom/unity3d/ads/core/data/repository/DeveloperConsentRepository;)V", "invoke", "Lgateway/v1/UniversalRequestOuterClass$UniversalRequest$SharedData;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: GetAndroidUniversalRequestSharedData.kt */
public final class GetAndroidUniversalRequestSharedData implements GetUniversalRequestSharedData {
    private final DeveloperConsentRepository developerConsentRepository;
    private final DeviceInfoRepository deviceInfoRepository;
    private final GetSharedDataTimestamps getSharedDataTimestamps;
    private final SessionRepository sessionRepository;

    public GetAndroidUniversalRequestSharedData(GetSharedDataTimestamps getSharedDataTimestamps2, SessionRepository sessionRepository2, DeviceInfoRepository deviceInfoRepository2, DeveloperConsentRepository developerConsentRepository2) {
        Intrinsics.checkNotNullParameter(getSharedDataTimestamps2, "getSharedDataTimestamps");
        Intrinsics.checkNotNullParameter(sessionRepository2, "sessionRepository");
        Intrinsics.checkNotNullParameter(deviceInfoRepository2, "deviceInfoRepository");
        Intrinsics.checkNotNullParameter(developerConsentRepository2, "developerConsentRepository");
        this.getSharedDataTimestamps = getSharedDataTimestamps2;
        this.sessionRepository = sessionRepository2;
        this.deviceInfoRepository = deviceInfoRepository2;
        this.developerConsentRepository = developerConsentRepository2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object invoke(kotlin.coroutines.Continuation<? super gateway.v1.UniversalRequestOuterClass.UniversalRequest.SharedData> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof com.unity3d.ads.core.domain.GetAndroidUniversalRequestSharedData$invoke$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            com.unity3d.ads.core.domain.GetAndroidUniversalRequestSharedData$invoke$1 r0 = (com.unity3d.ads.core.domain.GetAndroidUniversalRequestSharedData$invoke$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            com.unity3d.ads.core.domain.GetAndroidUniversalRequestSharedData$invoke$1 r0 = new com.unity3d.ads.core.domain.GetAndroidUniversalRequestSharedData$invoke$1
            r0.<init>(r6, r7)
        L_0x0019:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0042
            if (r2 != r3) goto L_0x003a
            java.lang.Object r1 = r0.L$3
            gateway.v1.UniversalRequestKt$SharedDataKt$Dsl r1 = (gateway.v1.UniversalRequestKt.SharedDataKt.Dsl) r1
            java.lang.Object r2 = r0.L$2
            gateway.v1.UniversalRequestKt$SharedDataKt$Dsl r2 = (gateway.v1.UniversalRequestKt.SharedDataKt.Dsl) r2
            java.lang.Object r3 = r0.L$1
            gateway.v1.UniversalRequestKt$SharedDataKt$Dsl r3 = (gateway.v1.UniversalRequestKt.SharedDataKt.Dsl) r3
            java.lang.Object r0 = r0.L$0
            com.unity3d.ads.core.domain.GetAndroidUniversalRequestSharedData r0 = (com.unity3d.ads.core.domain.GetAndroidUniversalRequestSharedData) r0
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x007d
        L_0x003a:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x0042:
            kotlin.ResultKt.throwOnFailure(r7)
            gateway.v1.UniversalRequestKt r7 = gateway.v1.UniversalRequestKt.INSTANCE
            gateway.v1.UniversalRequestKt$SharedDataKt$Dsl$Companion r7 = gateway.v1.UniversalRequestKt.SharedDataKt.Dsl.Companion
            gateway.v1.UniversalRequestOuterClass$UniversalRequest$SharedData$Builder r2 = gateway.v1.UniversalRequestOuterClass.UniversalRequest.SharedData.newBuilder()
            java.lang.String r4 = "newBuilder()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r4)
            gateway.v1.UniversalRequestKt$SharedDataKt$Dsl r7 = r7._create(r2)
            com.unity3d.ads.core.data.repository.SessionRepository r2 = r6.sessionRepository
            com.google.protobuf.ByteString r2 = r2.getSessionToken()
            boolean r4 = r2.isEmpty()
            if (r4 != 0) goto L_0x0065
            r7.setSessionToken(r2)
        L_0x0065:
            com.unity3d.ads.core.domain.GetSharedDataTimestamps r2 = r6.getSharedDataTimestamps
            r0.L$0 = r6
            r0.L$1 = r7
            r0.L$2 = r7
            r0.L$3 = r7
            r0.label = r3
            java.lang.Object r0 = r2.invoke(r0)
            if (r0 != r1) goto L_0x0078
            return r1
        L_0x0078:
            r1 = r7
            r2 = r1
            r3 = r2
            r7 = r0
            r0 = r6
        L_0x007d:
            gateway.v1.TimestampsOuterClass$Timestamps r7 = (gateway.v1.TimestampsOuterClass.Timestamps) r7
            r1.setTimestamps(r7)
            long r4 = com.unity3d.services.core.properties.SdkProperties.getInitializationTimeEpoch()
            com.google.protobuf.Timestamp r7 = com.unity3d.ads.core.extensions.TimestampExtensionsKt.fromMillis(r4)
            r2.setSdkStartTime(r7)
            long r4 = com.unity3d.services.core.properties.SdkProperties.getAppInitializationTimeSinceEpoch()
            com.google.protobuf.Timestamp r7 = com.unity3d.ads.core.extensions.TimestampExtensionsKt.fromMillis(r4)
            r2.setAppStartTime(r7)
            com.unity3d.ads.core.data.repository.DeveloperConsentRepository r7 = r0.developerConsentRepository
            gateway.v1.DeveloperConsentOuterClass$DeveloperConsent r7 = r7.getDeveloperConsent()
            r2.setDeveloperConsent(r7)
            com.unity3d.ads.core.data.repository.DeviceInfoRepository r7 = r0.deviceInfoRepository
            gateway.v1.PiiOuterClass$Pii r7 = r7.getPiiData()
            r2.setPii(r7)
            gateway.v1.UniversalRequestOuterClass$UniversalRequest$SharedData r7 = r3._build()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.GetAndroidUniversalRequestSharedData.invoke(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
