package com.unity3d.ads.core.domain.events;

import com.unity3d.ads.core.data.repository.CampaignStateRepository;
import com.unity3d.ads.core.data.repository.DeviceInfoRepository;
import com.unity3d.ads.core.data.repository.SessionRepository;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ;\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HBø\u0001\u0000¢\u0006\u0002\u0010\u0013R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"Lcom/unity3d/ads/core/domain/events/GetOperativeEventRequest;", "", "deviceInfoRepository", "Lcom/unity3d/ads/core/data/repository/DeviceInfoRepository;", "sessionRepository", "Lcom/unity3d/ads/core/data/repository/SessionRepository;", "campaignStateRepository", "Lcom/unity3d/ads/core/data/repository/CampaignStateRepository;", "(Lcom/unity3d/ads/core/data/repository/DeviceInfoRepository;Lcom/unity3d/ads/core/data/repository/SessionRepository;Lcom/unity3d/ads/core/data/repository/CampaignStateRepository;)V", "invoke", "Lgateway/v1/OperativeEventRequestOuterClass$OperativeEventRequest;", "operativeEventType", "Lgateway/v1/OperativeEventRequestOuterClass$OperativeEventType;", "loadTrackingToken", "Lcom/google/protobuf/ByteString;", "opportunityId", "additionalEventData", "playerServerId", "", "(Lgateway/v1/OperativeEventRequestOuterClass$OperativeEventType;Lcom/google/protobuf/ByteString;Lcom/google/protobuf/ByteString;Lcom/google/protobuf/ByteString;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: GetOperativeEventRequest.kt */
public final class GetOperativeEventRequest {
    private final CampaignStateRepository campaignStateRepository;
    private final DeviceInfoRepository deviceInfoRepository;
    private final SessionRepository sessionRepository;

    public GetOperativeEventRequest(DeviceInfoRepository deviceInfoRepository2, SessionRepository sessionRepository2, CampaignStateRepository campaignStateRepository2) {
        Intrinsics.checkNotNullParameter(deviceInfoRepository2, "deviceInfoRepository");
        Intrinsics.checkNotNullParameter(sessionRepository2, "sessionRepository");
        Intrinsics.checkNotNullParameter(campaignStateRepository2, "campaignStateRepository");
        this.deviceInfoRepository = deviceInfoRepository2;
        this.sessionRepository = sessionRepository2;
        this.campaignStateRepository = campaignStateRepository2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00c7 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invoke(gateway.v1.OperativeEventRequestOuterClass.OperativeEventType r7, com.google.protobuf.ByteString r8, com.google.protobuf.ByteString r9, com.google.protobuf.ByteString r10, java.lang.String r11, kotlin.coroutines.Continuation<? super gateway.v1.OperativeEventRequestOuterClass.OperativeEventRequest> r12) {
        /*
            r6 = this;
            boolean r0 = r12 instanceof com.unity3d.ads.core.domain.events.GetOperativeEventRequest$invoke$1
            if (r0 == 0) goto L_0x0014
            r0 = r12
            com.unity3d.ads.core.domain.events.GetOperativeEventRequest$invoke$1 r0 = (com.unity3d.ads.core.domain.events.GetOperativeEventRequest$invoke$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r12 = r0.label
            int r12 = r12 - r2
            r0.label = r12
            goto L_0x0019
        L_0x0014:
            com.unity3d.ads.core.domain.events.GetOperativeEventRequest$invoke$1 r0 = new com.unity3d.ads.core.domain.events.GetOperativeEventRequest$invoke$1
            r0.<init>(r6, r12)
        L_0x0019:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0052
            if (r2 == r4) goto L_0x003e
            if (r2 != r3) goto L_0x0036
            java.lang.Object r7 = r0.L$1
            gateway.v1.OperativeEventRequestKt$Dsl r7 = (gateway.v1.OperativeEventRequestKt.Dsl) r7
            java.lang.Object r8 = r0.L$0
            gateway.v1.OperativeEventRequestKt$Dsl r8 = (gateway.v1.OperativeEventRequestKt.Dsl) r8
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x00ca
        L_0x0036:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x003e:
            java.lang.Object r7 = r0.L$3
            gateway.v1.OperativeEventRequestKt$Dsl r7 = (gateway.v1.OperativeEventRequestKt.Dsl) r7
            java.lang.Object r8 = r0.L$2
            gateway.v1.OperativeEventRequestKt$Dsl r8 = (gateway.v1.OperativeEventRequestKt.Dsl) r8
            java.lang.Object r9 = r0.L$1
            gateway.v1.OperativeEventRequestKt$Dsl r9 = (gateway.v1.OperativeEventRequestKt.Dsl) r9
            java.lang.Object r10 = r0.L$0
            com.unity3d.ads.core.domain.events.GetOperativeEventRequest r10 = (com.unity3d.ads.core.domain.events.GetOperativeEventRequest) r10
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x00a6
        L_0x0052:
            kotlin.ResultKt.throwOnFailure(r12)
            gateway.v1.OperativeEventRequestKt$Dsl$Companion r12 = gateway.v1.OperativeEventRequestKt.Dsl.Companion
            gateway.v1.OperativeEventRequestOuterClass$OperativeEventRequest$Builder r2 = gateway.v1.OperativeEventRequestOuterClass.OperativeEventRequest.newBuilder()
            java.lang.String r5 = "newBuilder()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r5)
            gateway.v1.OperativeEventRequestKt$Dsl r12 = r12._create(r2)
            java.util.UUID r2 = java.util.UUID.randomUUID()
            java.lang.String r5 = "randomUUID()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r5)
            com.google.protobuf.ByteString r2 = com.unity3d.ads.core.extensions.ProtobufExtensionsKt.toByteString(r2)
            r12.setEventId(r2)
            r12.setEventType(r7)
            r12.setImpressionOpportunityId(r9)
            r12.setTrackingToken(r8)
            r12.setAdditionalData(r10)
            if (r11 == 0) goto L_0x0085
            r12.setSid(r11)
        L_0x0085:
            com.unity3d.ads.core.data.repository.DeviceInfoRepository r7 = r6.deviceInfoRepository
            gateway.v1.DynamicDeviceInfoOuterClass$DynamicDeviceInfo r7 = r7.getDynamicDeviceInfo()
            r12.setDynamicDeviceInfo(r7)
            com.unity3d.ads.core.data.repository.DeviceInfoRepository r7 = r6.deviceInfoRepository
            r0.L$0 = r6
            r0.L$1 = r12
            r0.L$2 = r12
            r0.L$3 = r12
            r0.label = r4
            java.lang.Object r7 = r7.staticDeviceInfo(r0)
            if (r7 != r1) goto L_0x00a1
            return r1
        L_0x00a1:
            r10 = r6
            r8 = r12
            r9 = r8
            r12 = r7
            r7 = r9
        L_0x00a6:
            gateway.v1.StaticDeviceInfoOuterClass$StaticDeviceInfo r12 = (gateway.v1.StaticDeviceInfoOuterClass.StaticDeviceInfo) r12
            r7.setStaticDeviceInfo(r12)
            com.unity3d.ads.core.data.repository.SessionRepository r7 = r10.sessionRepository
            gateway.v1.SessionCountersOuterClass$SessionCounters r7 = r7.getSessionCounters()
            r8.setSessionCounters(r7)
            com.unity3d.ads.core.data.repository.CampaignStateRepository r7 = r10.campaignStateRepository
            r0.L$0 = r9
            r0.L$1 = r8
            r10 = 0
            r0.L$2 = r10
            r0.L$3 = r10
            r0.label = r3
            java.lang.Object r12 = r7.getCampaignState(r0)
            if (r12 != r1) goto L_0x00c8
            return r1
        L_0x00c8:
            r7 = r8
            r8 = r9
        L_0x00ca:
            gateway.v1.CampaignStateOuterClass$CampaignState r12 = (gateway.v1.CampaignStateOuterClass.CampaignState) r12
            r7.setCampaignState(r12)
            gateway.v1.OperativeEventRequestOuterClass$OperativeEventRequest r7 = r8._build()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.events.GetOperativeEventRequest.invoke(gateway.v1.OperativeEventRequestOuterClass$OperativeEventType, com.google.protobuf.ByteString, com.google.protobuf.ByteString, com.google.protobuf.ByteString, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
