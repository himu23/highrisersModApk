package com.unity3d.ads.core.domain;

import com.unity3d.ads.core.data.repository.CampaignStateRepository;
import com.unity3d.ads.core.data.repository.DeviceInfoRepository;
import com.unity3d.ads.core.data.repository.SessionRepository;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ!\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010HBø\u0001\u0000¢\u0006\u0002\u0010\u0011R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Lcom/unity3d/ads/core/domain/GetAndroidAdRequest;", "Lcom/unity3d/ads/core/domain/GetAdRequest;", "getUniversalRequestForPayLoad", "Lcom/unity3d/ads/core/domain/GetUniversalRequestForPayLoad;", "sessionRepository", "Lcom/unity3d/ads/core/data/repository/SessionRepository;", "deviceInfoRepository", "Lcom/unity3d/ads/core/data/repository/DeviceInfoRepository;", "campaignStateRepository", "Lcom/unity3d/ads/core/data/repository/CampaignStateRepository;", "(Lcom/unity3d/ads/core/domain/GetUniversalRequestForPayLoad;Lcom/unity3d/ads/core/data/repository/SessionRepository;Lcom/unity3d/ads/core/data/repository/DeviceInfoRepository;Lcom/unity3d/ads/core/data/repository/CampaignStateRepository;)V", "invoke", "Lgateway/v1/UniversalRequestOuterClass$UniversalRequest;", "placement", "", "impressionOpportunity", "Lcom/google/protobuf/ByteString;", "(Ljava/lang/String;Lcom/google/protobuf/ByteString;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: GetAndroidAdRequest.kt */
public final class GetAndroidAdRequest implements GetAdRequest {
    private final CampaignStateRepository campaignStateRepository;
    private final DeviceInfoRepository deviceInfoRepository;
    private final GetUniversalRequestForPayLoad getUniversalRequestForPayLoad;
    private final SessionRepository sessionRepository;

    public GetAndroidAdRequest(GetUniversalRequestForPayLoad getUniversalRequestForPayLoad2, SessionRepository sessionRepository2, DeviceInfoRepository deviceInfoRepository2, CampaignStateRepository campaignStateRepository2) {
        Intrinsics.checkNotNullParameter(getUniversalRequestForPayLoad2, "getUniversalRequestForPayLoad");
        Intrinsics.checkNotNullParameter(sessionRepository2, "sessionRepository");
        Intrinsics.checkNotNullParameter(deviceInfoRepository2, "deviceInfoRepository");
        Intrinsics.checkNotNullParameter(campaignStateRepository2, "campaignStateRepository");
        this.getUniversalRequestForPayLoad = getUniversalRequestForPayLoad2;
        this.sessionRepository = sessionRepository2;
        this.deviceInfoRepository = deviceInfoRepository2;
        this.campaignStateRepository = campaignStateRepository2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00ce A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00cf  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0103 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0104 A[PHI: r15 
      PHI: (r15v2 java.lang.Object) = (r15v6 java.lang.Object), (r15v1 java.lang.Object) binds: [B:25:0x0101, B:11:0x002f] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object invoke(java.lang.String r13, com.google.protobuf.ByteString r14, kotlin.coroutines.Continuation<? super gateway.v1.UniversalRequestOuterClass.UniversalRequest> r15) {
        /*
            r12 = this;
            boolean r0 = r15 instanceof com.unity3d.ads.core.domain.GetAndroidAdRequest$invoke$1
            if (r0 == 0) goto L_0x0014
            r0 = r15
            com.unity3d.ads.core.domain.GetAndroidAdRequest$invoke$1 r0 = (com.unity3d.ads.core.domain.GetAndroidAdRequest$invoke$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r15 = r0.label
            int r15 = r15 - r2
            r0.label = r15
            goto L_0x0019
        L_0x0014:
            com.unity3d.ads.core.domain.GetAndroidAdRequest$invoke$1 r0 = new com.unity3d.ads.core.domain.GetAndroidAdRequest$invoke$1
            r0.<init>(r12, r15)
        L_0x0019:
            java.lang.Object r15 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            java.lang.String r3 = "newBuilder()"
            r4 = 3
            r5 = 2
            r6 = 1
            r7 = 0
            if (r2 == 0) goto L_0x006c
            if (r2 == r6) goto L_0x004d
            if (r2 == r5) goto L_0x003c
            if (r2 != r4) goto L_0x0034
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x0104
        L_0x0034:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L_0x003c:
            java.lang.Object r13 = r0.L$2
            gateway.v1.AdRequestKt$Dsl r13 = (gateway.v1.AdRequestKt.Dsl) r13
            java.lang.Object r14 = r0.L$1
            gateway.v1.AdRequestKt$Dsl r14 = (gateway.v1.AdRequestKt.Dsl) r14
            java.lang.Object r2 = r0.L$0
            com.unity3d.ads.core.domain.GetAndroidAdRequest r2 = (com.unity3d.ads.core.domain.GetAndroidAdRequest) r2
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x00d4
        L_0x004d:
            java.lang.Object r13 = r0.L$5
            gateway.v1.AdRequestKt$Dsl r13 = (gateway.v1.AdRequestKt.Dsl) r13
            java.lang.Object r14 = r0.L$4
            gateway.v1.AdRequestKt$Dsl r14 = (gateway.v1.AdRequestKt.Dsl) r14
            java.lang.Object r2 = r0.L$3
            gateway.v1.AdRequestKt$Dsl r2 = (gateway.v1.AdRequestKt.Dsl) r2
            java.lang.Object r8 = r0.L$2
            com.google.protobuf.ByteString r8 = (com.google.protobuf.ByteString) r8
            java.lang.Object r9 = r0.L$1
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Object r10 = r0.L$0
            com.unity3d.ads.core.domain.GetAndroidAdRequest r10 = (com.unity3d.ads.core.domain.GetAndroidAdRequest) r10
            kotlin.ResultKt.throwOnFailure(r15)
            r11 = r2
            r2 = r15
            r15 = r11
            goto L_0x00a1
        L_0x006c:
            kotlin.ResultKt.throwOnFailure(r15)
            gateway.v1.AdRequestKt$Dsl$Companion r15 = gateway.v1.AdRequestKt.Dsl.Companion
            gateway.v1.AdRequestOuterClass$AdRequest$Builder r2 = gateway.v1.AdRequestOuterClass.AdRequest.newBuilder()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            gateway.v1.AdRequestKt$Dsl r15 = r15._create(r2)
            com.unity3d.ads.core.data.repository.SessionRepository r2 = r12.sessionRepository
            gateway.v1.SessionCountersOuterClass$SessionCounters r2 = r2.getSessionCounters()
            r15.setSessionCounters(r2)
            com.unity3d.ads.core.data.repository.DeviceInfoRepository r2 = r12.deviceInfoRepository
            r0.L$0 = r12
            r0.L$1 = r13
            r0.L$2 = r14
            r0.L$3 = r15
            r0.L$4 = r15
            r0.L$5 = r15
            r0.label = r6
            java.lang.Object r2 = r2.staticDeviceInfo(r0)
            if (r2 != r1) goto L_0x009c
            return r1
        L_0x009c:
            r10 = r12
            r9 = r13
            r8 = r14
            r13 = r15
            r14 = r13
        L_0x00a1:
            gateway.v1.StaticDeviceInfoOuterClass$StaticDeviceInfo r2 = (gateway.v1.StaticDeviceInfoOuterClass.StaticDeviceInfo) r2
            r13.setStaticDeviceInfo(r2)
            com.unity3d.ads.core.data.repository.DeviceInfoRepository r13 = r10.deviceInfoRepository
            gateway.v1.DynamicDeviceInfoOuterClass$DynamicDeviceInfo r13 = r13.getDynamicDeviceInfo()
            r14.setDynamicDeviceInfo(r13)
            r14.setImpressionOpportunityId(r8)
            r14.setPlacementId(r9)
            r14.setRequestImpressionConfiguration(r6)
            com.unity3d.ads.core.data.repository.CampaignStateRepository r13 = r10.campaignStateRepository
            r0.L$0 = r10
            r0.L$1 = r15
            r0.L$2 = r14
            r0.L$3 = r7
            r0.L$4 = r7
            r0.L$5 = r7
            r0.label = r5
            java.lang.Object r13 = r13.getCampaignState(r0)
            if (r13 != r1) goto L_0x00cf
            return r1
        L_0x00cf:
            r2 = r10
            r11 = r15
            r15 = r13
            r13 = r14
            r14 = r11
        L_0x00d4:
            gateway.v1.CampaignStateOuterClass$CampaignState r15 = (gateway.v1.CampaignStateOuterClass.CampaignState) r15
            r13.setCampaignState(r15)
            gateway.v1.AdRequestOuterClass$AdRequest r13 = r14._build()
            gateway.v1.UniversalRequestKt r14 = gateway.v1.UniversalRequestKt.INSTANCE
            gateway.v1.UniversalRequestKt$PayloadKt$Dsl$Companion r14 = gateway.v1.UniversalRequestKt.PayloadKt.Dsl.Companion
            gateway.v1.UniversalRequestOuterClass$UniversalRequest$Payload$Builder r15 = gateway.v1.UniversalRequestOuterClass.UniversalRequest.Payload.newBuilder()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r15, r3)
            gateway.v1.UniversalRequestKt$PayloadKt$Dsl r14 = r14._create(r15)
            r14.setAdRequest(r13)
            gateway.v1.UniversalRequestOuterClass$UniversalRequest$Payload r13 = r14._build()
            com.unity3d.ads.core.domain.GetUniversalRequestForPayLoad r14 = r2.getUniversalRequestForPayLoad
            r0.L$0 = r7
            r0.L$1 = r7
            r0.L$2 = r7
            r0.label = r4
            java.lang.Object r15 = r14.invoke(r13, r0)
            if (r15 != r1) goto L_0x0104
            return r1
        L_0x0104:
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.GetAndroidAdRequest.invoke(java.lang.String, com.google.protobuf.ByteString, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
