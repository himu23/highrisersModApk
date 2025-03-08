package com.unity3d.ads.core.domain;

import com.unity3d.ads.core.data.repository.CampaignStateRepository;
import com.unity3d.ads.core.data.repository.DeviceInfoRepository;
import com.unity3d.ads.core.data.repository.SessionRepository;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ!\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eHBø\u0001\u0000¢\u0006\u0002\u0010\u0010R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"Lcom/unity3d/ads/core/domain/GetAndroidAdDataRefreshRequest;", "Lcom/unity3d/ads/core/domain/GetAdDataRefreshRequest;", "getUniversalRequestForPayLoad", "Lcom/unity3d/ads/core/domain/GetUniversalRequestForPayLoad;", "sessionRepository", "Lcom/unity3d/ads/core/data/repository/SessionRepository;", "deviceInfoRepository", "Lcom/unity3d/ads/core/data/repository/DeviceInfoRepository;", "campaignStateRepository", "Lcom/unity3d/ads/core/data/repository/CampaignStateRepository;", "(Lcom/unity3d/ads/core/domain/GetUniversalRequestForPayLoad;Lcom/unity3d/ads/core/data/repository/SessionRepository;Lcom/unity3d/ads/core/data/repository/DeviceInfoRepository;Lcom/unity3d/ads/core/data/repository/CampaignStateRepository;)V", "invoke", "Lgateway/v1/UniversalRequestOuterClass$UniversalRequest;", "opportunityId", "Lcom/google/protobuf/ByteString;", "refreshToken", "(Lcom/google/protobuf/ByteString;Lcom/google/protobuf/ByteString;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: GetAndroidAdDataRefreshRequest.kt */
public final class GetAndroidAdDataRefreshRequest implements GetAdDataRefreshRequest {
    private final CampaignStateRepository campaignStateRepository;
    private final DeviceInfoRepository deviceInfoRepository;
    private final GetUniversalRequestForPayLoad getUniversalRequestForPayLoad;
    private final SessionRepository sessionRepository;

    public GetAndroidAdDataRefreshRequest(GetUniversalRequestForPayLoad getUniversalRequestForPayLoad2, SessionRepository sessionRepository2, DeviceInfoRepository deviceInfoRepository2, CampaignStateRepository campaignStateRepository2) {
        Intrinsics.checkNotNullParameter(getUniversalRequestForPayLoad2, "getUniversalRequestForPayLoad");
        Intrinsics.checkNotNullParameter(sessionRepository2, "sessionRepository");
        Intrinsics.checkNotNullParameter(deviceInfoRepository2, "deviceInfoRepository");
        Intrinsics.checkNotNullParameter(campaignStateRepository2, "campaignStateRepository");
        this.getUniversalRequestForPayLoad = getUniversalRequestForPayLoad2;
        this.sessionRepository = sessionRepository2;
        this.deviceInfoRepository = deviceInfoRepository2;
        this.campaignStateRepository = campaignStateRepository2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00cf A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x010f A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0110 A[PHI: r13 
      PHI: (r13v2 java.lang.Object) = (r13v6 java.lang.Object), (r13v1 java.lang.Object) binds: [B:28:0x010d, B:11:0x002f] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object invoke(com.google.protobuf.ByteString r11, com.google.protobuf.ByteString r12, kotlin.coroutines.Continuation<? super gateway.v1.UniversalRequestOuterClass.UniversalRequest> r13) {
        /*
            r10 = this;
            boolean r0 = r13 instanceof com.unity3d.ads.core.domain.GetAndroidAdDataRefreshRequest$invoke$1
            if (r0 == 0) goto L_0x0014
            r0 = r13
            com.unity3d.ads.core.domain.GetAndroidAdDataRefreshRequest$invoke$1 r0 = (com.unity3d.ads.core.domain.GetAndroidAdDataRefreshRequest$invoke$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r13 = r0.label
            int r13 = r13 - r2
            r0.label = r13
            goto L_0x0019
        L_0x0014:
            com.unity3d.ads.core.domain.GetAndroidAdDataRefreshRequest$invoke$1 r0 = new com.unity3d.ads.core.domain.GetAndroidAdDataRefreshRequest$invoke$1
            r0.<init>(r10, r13)
        L_0x0019:
            java.lang.Object r13 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            java.lang.String r3 = "newBuilder()"
            r4 = 3
            r5 = 2
            r6 = 1
            r7 = 0
            if (r2 == 0) goto L_0x0071
            if (r2 == r6) goto L_0x0055
            if (r2 == r5) goto L_0x003c
            if (r2 != r4) goto L_0x0034
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x0110
        L_0x0034:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x003c:
            java.lang.Object r11 = r0.L$4
            gateway.v1.AdDataRefreshRequestKt$Dsl r11 = (gateway.v1.AdDataRefreshRequestKt.Dsl) r11
            java.lang.Object r12 = r0.L$3
            gateway.v1.AdDataRefreshRequestKt$Dsl r12 = (gateway.v1.AdDataRefreshRequestKt.Dsl) r12
            java.lang.Object r2 = r0.L$2
            gateway.v1.AdDataRefreshRequestKt$Dsl r2 = (gateway.v1.AdDataRefreshRequestKt.Dsl) r2
            java.lang.Object r5 = r0.L$1
            com.google.protobuf.ByteString r5 = (com.google.protobuf.ByteString) r5
            java.lang.Object r6 = r0.L$0
            com.unity3d.ads.core.domain.GetAndroidAdDataRefreshRequest r6 = (com.unity3d.ads.core.domain.GetAndroidAdDataRefreshRequest) r6
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x00d3
        L_0x0055:
            java.lang.Object r11 = r0.L$5
            gateway.v1.AdDataRefreshRequestKt$Dsl r11 = (gateway.v1.AdDataRefreshRequestKt.Dsl) r11
            java.lang.Object r12 = r0.L$4
            gateway.v1.AdDataRefreshRequestKt$Dsl r12 = (gateway.v1.AdDataRefreshRequestKt.Dsl) r12
            java.lang.Object r2 = r0.L$3
            gateway.v1.AdDataRefreshRequestKt$Dsl r2 = (gateway.v1.AdDataRefreshRequestKt.Dsl) r2
            java.lang.Object r6 = r0.L$2
            com.google.protobuf.ByteString r6 = (com.google.protobuf.ByteString) r6
            java.lang.Object r8 = r0.L$1
            com.google.protobuf.ByteString r8 = (com.google.protobuf.ByteString) r8
            java.lang.Object r9 = r0.L$0
            com.unity3d.ads.core.domain.GetAndroidAdDataRefreshRequest r9 = (com.unity3d.ads.core.domain.GetAndroidAdDataRefreshRequest) r9
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x00a8
        L_0x0071:
            kotlin.ResultKt.throwOnFailure(r13)
            gateway.v1.AdDataRefreshRequestKt$Dsl$Companion r13 = gateway.v1.AdDataRefreshRequestKt.Dsl.Companion
            gateway.v1.AdDataRefreshRequestOuterClass$AdDataRefreshRequest$Builder r2 = gateway.v1.AdDataRefreshRequestOuterClass.AdDataRefreshRequest.newBuilder()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            gateway.v1.AdDataRefreshRequestKt$Dsl r13 = r13._create(r2)
            com.unity3d.ads.core.data.repository.SessionRepository r2 = r10.sessionRepository
            gateway.v1.SessionCountersOuterClass$SessionCounters r2 = r2.getSessionCounters()
            r13.setSessionCounters(r2)
            com.unity3d.ads.core.data.repository.DeviceInfoRepository r2 = r10.deviceInfoRepository
            r0.L$0 = r10
            r0.L$1 = r11
            r0.L$2 = r12
            r0.L$3 = r13
            r0.L$4 = r13
            r0.L$5 = r13
            r0.label = r6
            java.lang.Object r2 = r2.staticDeviceInfo(r0)
            if (r2 != r1) goto L_0x00a1
            return r1
        L_0x00a1:
            r9 = r10
            r8 = r11
            r6 = r12
            r11 = r13
            r12 = r11
            r13 = r2
            r2 = r12
        L_0x00a8:
            gateway.v1.StaticDeviceInfoOuterClass$StaticDeviceInfo r13 = (gateway.v1.StaticDeviceInfoOuterClass.StaticDeviceInfo) r13
            r11.setStaticDeviceInfo(r13)
            com.unity3d.ads.core.data.repository.DeviceInfoRepository r11 = r9.deviceInfoRepository
            gateway.v1.DynamicDeviceInfoOuterClass$DynamicDeviceInfo r11 = r11.getDynamicDeviceInfo()
            r12.setDynamicDeviceInfo(r11)
            r12.setImpressionOpportunityId(r8)
            com.unity3d.ads.core.data.repository.CampaignStateRepository r11 = r9.campaignStateRepository
            r0.L$0 = r9
            r0.L$1 = r6
            r0.L$2 = r2
            r0.L$3 = r12
            r0.L$4 = r12
            r0.L$5 = r7
            r0.label = r5
            java.lang.Object r13 = r11.getCampaignState(r0)
            if (r13 != r1) goto L_0x00d0
            return r1
        L_0x00d0:
            r11 = r12
            r5 = r6
            r6 = r9
        L_0x00d3:
            gateway.v1.CampaignStateOuterClass$CampaignState r13 = (gateway.v1.CampaignStateOuterClass.CampaignState) r13
            r11.setCampaignState(r13)
            boolean r11 = r5.isEmpty()
            if (r11 != 0) goto L_0x00e1
            r12.setAdDataRefreshToken(r5)
        L_0x00e1:
            gateway.v1.AdDataRefreshRequestOuterClass$AdDataRefreshRequest r11 = r2._build()
            gateway.v1.UniversalRequestKt r12 = gateway.v1.UniversalRequestKt.INSTANCE
            gateway.v1.UniversalRequestKt$PayloadKt$Dsl$Companion r12 = gateway.v1.UniversalRequestKt.PayloadKt.Dsl.Companion
            gateway.v1.UniversalRequestOuterClass$UniversalRequest$Payload$Builder r13 = gateway.v1.UniversalRequestOuterClass.UniversalRequest.Payload.newBuilder()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r13, r3)
            gateway.v1.UniversalRequestKt$PayloadKt$Dsl r12 = r12._create(r13)
            r12.setAdDataRefreshRequest(r11)
            gateway.v1.UniversalRequestOuterClass$UniversalRequest$Payload r11 = r12._build()
            com.unity3d.ads.core.domain.GetUniversalRequestForPayLoad r12 = r6.getUniversalRequestForPayLoad
            r0.L$0 = r7
            r0.L$1 = r7
            r0.L$2 = r7
            r0.L$3 = r7
            r0.L$4 = r7
            r0.label = r4
            java.lang.Object r13 = r12.invoke(r11, r0)
            if (r13 != r1) goto L_0x0110
            return r1
        L_0x0110:
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.GetAndroidAdDataRefreshRequest.invoke(com.google.protobuf.ByteString, com.google.protobuf.ByteString, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
