package com.unity3d.ads.core.domain;

import com.unity3d.ads.core.data.repository.DeviceInfoRepository;
import com.unity3d.ads.core.data.repository.LegacyUserConsentRepository;
import com.unity3d.ads.core.data.repository.SessionRepository;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0011\u0010\r\u001a\u00020\u000eHBø\u0001\u0000¢\u0006\u0002\u0010\u000fR\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"Lcom/unity3d/ads/core/domain/GetAndroidInitializationRequest;", "Lcom/unity3d/ads/core/domain/GetInitializationRequest;", "getUniversalRequestForPayLoad", "Lcom/unity3d/ads/core/domain/GetUniversalRequestForPayLoad;", "getClientInfo", "Lcom/unity3d/ads/core/domain/GetClientInfo;", "sessionRepository", "Lcom/unity3d/ads/core/data/repository/SessionRepository;", "deviceInfoRepository", "Lcom/unity3d/ads/core/data/repository/DeviceInfoRepository;", "legacyUserConsentRepository", "Lcom/unity3d/ads/core/data/repository/LegacyUserConsentRepository;", "(Lcom/unity3d/ads/core/domain/GetUniversalRequestForPayLoad;Lcom/unity3d/ads/core/domain/GetClientInfo;Lcom/unity3d/ads/core/data/repository/SessionRepository;Lcom/unity3d/ads/core/data/repository/DeviceInfoRepository;Lcom/unity3d/ads/core/data/repository/LegacyUserConsentRepository;)V", "invoke", "Lgateway/v1/UniversalRequestOuterClass$UniversalRequest;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: GetAndroidInitializationRequest.kt */
public final class GetAndroidInitializationRequest implements GetInitializationRequest {
    private final DeviceInfoRepository deviceInfoRepository;
    private final GetClientInfo getClientInfo;
    private final GetUniversalRequestForPayLoad getUniversalRequestForPayLoad;
    private final LegacyUserConsentRepository legacyUserConsentRepository;
    private final SessionRepository sessionRepository;

    public GetAndroidInitializationRequest(GetUniversalRequestForPayLoad getUniversalRequestForPayLoad2, GetClientInfo getClientInfo2, SessionRepository sessionRepository2, DeviceInfoRepository deviceInfoRepository2, LegacyUserConsentRepository legacyUserConsentRepository2) {
        Intrinsics.checkNotNullParameter(getUniversalRequestForPayLoad2, "getUniversalRequestForPayLoad");
        Intrinsics.checkNotNullParameter(getClientInfo2, "getClientInfo");
        Intrinsics.checkNotNullParameter(sessionRepository2, "sessionRepository");
        Intrinsics.checkNotNullParameter(deviceInfoRepository2, "deviceInfoRepository");
        Intrinsics.checkNotNullParameter(legacyUserConsentRepository2, "legacyUserConsentRepository");
        this.getUniversalRequestForPayLoad = getUniversalRequestForPayLoad2;
        this.getClientInfo = getClientInfo2;
        this.sessionRepository = sessionRepository2;
        this.deviceInfoRepository = deviceInfoRepository2;
        this.legacyUserConsentRepository = legacyUserConsentRepository2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00e0, code lost:
        r2.setClientInfo((gateway.v1.ClientInfoOuterClass.ClientInfo) r10);
        r10 = r7.deviceInfoRepository;
        r0.L$0 = r7;
        r0.L$1 = r6;
        r0.L$2 = r5;
        r0.L$3 = r5;
        r0.label = 2;
        r10 = r10.getIdfi(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00f6, code lost:
        if (r10 != r1) goto L_0x00f9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00f8, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00f9, code lost:
        r2 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00fa, code lost:
        r10 = com.unity3d.ads.core.extensions.ProtobufExtensionsKt.toUUID((com.google.protobuf.ByteString) r10).toString();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, "deviceInfoRepository.getIdfi().toUUID().toString()");
        r2.setIdfi(r10);
        r10 = r7.deviceInfoRepository.getAnalyticsUserId();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0112, code lost:
        if (r10 == null) goto L_0x0117;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0114, code lost:
        r5.setAnalyticsUserId(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0117, code lost:
        r5.setSessionId(r7.sessionRepository.getSessionId());
        r10 = gateway.v1.InitializationDeviceInfoKt.Dsl.Companion;
        r2 = gateway.v1.InitializationRequestOuterClass.InitializationDeviceInfo.newBuilder();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, "newBuilder()");
        r10 = r10._create(r2);
        r10.setBundleId(r7.deviceInfoRepository.getAppName());
        r10.setDeviceModel(r7.deviceInfoRepository.getModel());
        r10.setDeviceMake(r7.deviceInfoRepository.getManufacturer());
        r10.setOsVersion(r7.deviceInfoRepository.getOsVersion());
        r5.setDeviceInfo(r10._build());
        r10 = r7.deviceInfoRepository;
        r0.L$0 = r7;
        r0.L$1 = r6;
        r0.L$2 = r5;
        r0.L$3 = null;
        r0.label = 3;
        r10 = r10.getAuid(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0169, code lost:
        if (r10 != r1) goto L_0x016c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x016b, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x016c, code lost:
        r2 = r5;
        r5 = r6;
        r6 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x016f, code lost:
        r10 = (com.google.protobuf.ByteString) r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0175, code lost:
        if (r10.isEmpty() != false) goto L_0x017a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0177, code lost:
        r2.setAuid(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x017a, code lost:
        r10 = r6.sessionRepository;
        r0.L$0 = r6;
        r0.L$1 = r5;
        r0.L$2 = r2;
        r0.label = 4;
        r10 = r10.getPrivacy(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0189, code lost:
        if (r10 != r1) goto L_0x018c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x018b, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x018c, code lost:
        r10 = (com.google.protobuf.ByteString) r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0192, code lost:
        if (r10.isEmpty() != false) goto L_0x0197;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0194, code lost:
        r2.setPrivacy(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0197, code lost:
        r10 = r6.sessionRepository;
        r0.L$0 = r6;
        r0.L$1 = r5;
        r0.L$2 = r2;
        r0.label = 5;
        r10 = r10.getGatewayCache(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x01a6, code lost:
        if (r10 != r1) goto L_0x01a9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x01a8, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x01a9, code lost:
        r10 = (com.google.protobuf.ByteString) r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x01af, code lost:
        if (r10.isEmpty() != false) goto L_0x01b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x01b1, code lost:
        r2.setCache(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x01b4, code lost:
        r10 = r6.legacyUserConsentRepository.getLegacyFlowUserConsent();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x01ba, code lost:
        if (r10 == null) goto L_0x01bf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x01bc, code lost:
        r2.setLegacyFlowUserConsent(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x01bf, code lost:
        r10 = r5._build();
        r2 = gateway.v1.UniversalRequestKt.INSTANCE;
        r2 = gateway.v1.UniversalRequestKt.PayloadKt.Dsl.Companion;
        r5 = gateway.v1.UniversalRequestOuterClass.UniversalRequest.Payload.newBuilder();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, "newBuilder()");
        r2 = r2._create(r5);
        r2.setInitializationRequest(r10);
        r10 = r2._build();
        r2 = r6.getUniversalRequestForPayLoad;
        r0.L$0 = null;
        r0.L$1 = null;
        r0.L$2 = null;
        r0.label = 6;
        r10 = r2.invoke(r10, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x01e8, code lost:
        if (r10 != r1) goto L_0x01eb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x01ea, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x01eb, code lost:
        return r10;
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x002f  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00dc A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0027  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object invoke(kotlin.coroutines.Continuation<? super gateway.v1.UniversalRequestOuterClass.UniversalRequest> r10) {
        /*
            r9 = this;
            boolean r0 = r10 instanceof com.unity3d.ads.core.domain.GetAndroidInitializationRequest$invoke$1
            if (r0 == 0) goto L_0x0014
            r0 = r10
            com.unity3d.ads.core.domain.GetAndroidInitializationRequest$invoke$1 r0 = (com.unity3d.ads.core.domain.GetAndroidInitializationRequest$invoke$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L_0x0019
        L_0x0014:
            com.unity3d.ads.core.domain.GetAndroidInitializationRequest$invoke$1 r0 = new com.unity3d.ads.core.domain.GetAndroidInitializationRequest$invoke$1
            r0.<init>(r9, r10)
        L_0x0019:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            java.lang.String r3 = "newBuilder()"
            r4 = 0
            switch(r2) {
                case 0: goto L_0x0090;
                case 1: goto L_0x007c;
                case 2: goto L_0x0067;
                case 3: goto L_0x0056;
                case 4: goto L_0x0045;
                case 5: goto L_0x0034;
                case 6: goto L_0x002f;
                default: goto L_0x0027;
            }
        L_0x0027:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L_0x002f:
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x01eb
        L_0x0034:
            java.lang.Object r2 = r0.L$2
            gateway.v1.InitializationRequestKt$Dsl r2 = (gateway.v1.InitializationRequestKt.Dsl) r2
            java.lang.Object r5 = r0.L$1
            gateway.v1.InitializationRequestKt$Dsl r5 = (gateway.v1.InitializationRequestKt.Dsl) r5
            java.lang.Object r6 = r0.L$0
            com.unity3d.ads.core.domain.GetAndroidInitializationRequest r6 = (com.unity3d.ads.core.domain.GetAndroidInitializationRequest) r6
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x01a9
        L_0x0045:
            java.lang.Object r2 = r0.L$2
            gateway.v1.InitializationRequestKt$Dsl r2 = (gateway.v1.InitializationRequestKt.Dsl) r2
            java.lang.Object r5 = r0.L$1
            gateway.v1.InitializationRequestKt$Dsl r5 = (gateway.v1.InitializationRequestKt.Dsl) r5
            java.lang.Object r6 = r0.L$0
            com.unity3d.ads.core.domain.GetAndroidInitializationRequest r6 = (com.unity3d.ads.core.domain.GetAndroidInitializationRequest) r6
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x018c
        L_0x0056:
            java.lang.Object r2 = r0.L$2
            gateway.v1.InitializationRequestKt$Dsl r2 = (gateway.v1.InitializationRequestKt.Dsl) r2
            java.lang.Object r5 = r0.L$1
            gateway.v1.InitializationRequestKt$Dsl r5 = (gateway.v1.InitializationRequestKt.Dsl) r5
            java.lang.Object r6 = r0.L$0
            com.unity3d.ads.core.domain.GetAndroidInitializationRequest r6 = (com.unity3d.ads.core.domain.GetAndroidInitializationRequest) r6
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x016f
        L_0x0067:
            java.lang.Object r2 = r0.L$3
            gateway.v1.InitializationRequestKt$Dsl r2 = (gateway.v1.InitializationRequestKt.Dsl) r2
            java.lang.Object r5 = r0.L$2
            gateway.v1.InitializationRequestKt$Dsl r5 = (gateway.v1.InitializationRequestKt.Dsl) r5
            java.lang.Object r6 = r0.L$1
            gateway.v1.InitializationRequestKt$Dsl r6 = (gateway.v1.InitializationRequestKt.Dsl) r6
            java.lang.Object r7 = r0.L$0
            com.unity3d.ads.core.domain.GetAndroidInitializationRequest r7 = (com.unity3d.ads.core.domain.GetAndroidInitializationRequest) r7
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x00fa
        L_0x007c:
            java.lang.Object r2 = r0.L$3
            gateway.v1.InitializationRequestKt$Dsl r2 = (gateway.v1.InitializationRequestKt.Dsl) r2
            java.lang.Object r5 = r0.L$2
            gateway.v1.InitializationRequestKt$Dsl r5 = (gateway.v1.InitializationRequestKt.Dsl) r5
            java.lang.Object r6 = r0.L$1
            gateway.v1.InitializationRequestKt$Dsl r6 = (gateway.v1.InitializationRequestKt.Dsl) r6
            java.lang.Object r7 = r0.L$0
            com.unity3d.ads.core.domain.GetAndroidInitializationRequest r7 = (com.unity3d.ads.core.domain.GetAndroidInitializationRequest) r7
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x00e0
        L_0x0090:
            kotlin.ResultKt.throwOnFailure(r10)
            gateway.v1.InitializationRequestKt$Dsl$Companion r10 = gateway.v1.InitializationRequestKt.Dsl.Companion
            gateway.v1.InitializationRequestOuterClass$InitializationRequest$Builder r2 = gateway.v1.InitializationRequestOuterClass.InitializationRequest.newBuilder()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            gateway.v1.InitializationRequestKt$Dsl r2 = r10._create(r2)
            com.unity3d.services.core.device.StorageManager$StorageType r10 = com.unity3d.services.core.device.StorageManager.StorageType.PRIVATE
            com.unity3d.services.core.device.Storage r10 = com.unity3d.services.core.device.StorageManager.getStorage(r10)
            boolean r5 = r10.readStorage()
            r6 = 1
            if (r5 == 0) goto L_0x00c5
            java.lang.String r5 = "configuration.hasInitialized"
            java.lang.Object r10 = r10.get(r5)
            boolean r5 = r10 instanceof java.lang.Boolean
            if (r5 == 0) goto L_0x00ba
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            goto L_0x00bb
        L_0x00ba:
            r10 = r4
        L_0x00bb:
            if (r10 == 0) goto L_0x00c5
            boolean r10 = r10.booleanValue()
            if (r10 == 0) goto L_0x00c5
            r10 = 1
            goto L_0x00c6
        L_0x00c5:
            r10 = 0
        L_0x00c6:
            r10 = r10 ^ r6
            r2.setIsFirstInit(r10)
            com.unity3d.ads.core.domain.GetClientInfo r10 = r9.getClientInfo
            r0.L$0 = r9
            r0.L$1 = r2
            r0.L$2 = r2
            r0.L$3 = r2
            r0.label = r6
            java.lang.Object r10 = r10.invoke(r0)
            if (r10 != r1) goto L_0x00dd
            return r1
        L_0x00dd:
            r7 = r9
            r5 = r2
            r6 = r5
        L_0x00e0:
            gateway.v1.ClientInfoOuterClass$ClientInfo r10 = (gateway.v1.ClientInfoOuterClass.ClientInfo) r10
            r2.setClientInfo(r10)
            com.unity3d.ads.core.data.repository.DeviceInfoRepository r10 = r7.deviceInfoRepository
            r0.L$0 = r7
            r0.L$1 = r6
            r0.L$2 = r5
            r0.L$3 = r5
            r2 = 2
            r0.label = r2
            java.lang.Object r10 = r10.getIdfi(r0)
            if (r10 != r1) goto L_0x00f9
            return r1
        L_0x00f9:
            r2 = r5
        L_0x00fa:
            com.google.protobuf.ByteString r10 = (com.google.protobuf.ByteString) r10
            java.util.UUID r10 = com.unity3d.ads.core.extensions.ProtobufExtensionsKt.toUUID(r10)
            java.lang.String r10 = r10.toString()
            java.lang.String r8 = "deviceInfoRepository.getIdfi().toUUID().toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r8)
            r2.setIdfi(r10)
            com.unity3d.ads.core.data.repository.DeviceInfoRepository r10 = r7.deviceInfoRepository
            java.lang.String r10 = r10.getAnalyticsUserId()
            if (r10 == 0) goto L_0x0117
            r5.setAnalyticsUserId(r10)
        L_0x0117:
            com.unity3d.ads.core.data.repository.SessionRepository r10 = r7.sessionRepository
            com.google.protobuf.ByteString r10 = r10.getSessionId()
            r5.setSessionId(r10)
            gateway.v1.InitializationDeviceInfoKt$Dsl$Companion r10 = gateway.v1.InitializationDeviceInfoKt.Dsl.Companion
            gateway.v1.InitializationRequestOuterClass$InitializationDeviceInfo$Builder r2 = gateway.v1.InitializationRequestOuterClass.InitializationDeviceInfo.newBuilder()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            gateway.v1.InitializationDeviceInfoKt$Dsl r10 = r10._create(r2)
            com.unity3d.ads.core.data.repository.DeviceInfoRepository r2 = r7.deviceInfoRepository
            java.lang.String r2 = r2.getAppName()
            r10.setBundleId(r2)
            com.unity3d.ads.core.data.repository.DeviceInfoRepository r2 = r7.deviceInfoRepository
            java.lang.String r2 = r2.getModel()
            r10.setDeviceModel(r2)
            com.unity3d.ads.core.data.repository.DeviceInfoRepository r2 = r7.deviceInfoRepository
            java.lang.String r2 = r2.getManufacturer()
            r10.setDeviceMake(r2)
            com.unity3d.ads.core.data.repository.DeviceInfoRepository r2 = r7.deviceInfoRepository
            java.lang.String r2 = r2.getOsVersion()
            r10.setOsVersion(r2)
            gateway.v1.InitializationRequestOuterClass$InitializationDeviceInfo r10 = r10._build()
            r5.setDeviceInfo(r10)
            com.unity3d.ads.core.data.repository.DeviceInfoRepository r10 = r7.deviceInfoRepository
            r0.L$0 = r7
            r0.L$1 = r6
            r0.L$2 = r5
            r0.L$3 = r4
            r2 = 3
            r0.label = r2
            java.lang.Object r10 = r10.getAuid(r0)
            if (r10 != r1) goto L_0x016c
            return r1
        L_0x016c:
            r2 = r5
            r5 = r6
            r6 = r7
        L_0x016f:
            com.google.protobuf.ByteString r10 = (com.google.protobuf.ByteString) r10
            boolean r7 = r10.isEmpty()
            if (r7 != 0) goto L_0x017a
            r2.setAuid(r10)
        L_0x017a:
            com.unity3d.ads.core.data.repository.SessionRepository r10 = r6.sessionRepository
            r0.L$0 = r6
            r0.L$1 = r5
            r0.L$2 = r2
            r7 = 4
            r0.label = r7
            java.lang.Object r10 = r10.getPrivacy(r0)
            if (r10 != r1) goto L_0x018c
            return r1
        L_0x018c:
            com.google.protobuf.ByteString r10 = (com.google.protobuf.ByteString) r10
            boolean r7 = r10.isEmpty()
            if (r7 != 0) goto L_0x0197
            r2.setPrivacy(r10)
        L_0x0197:
            com.unity3d.ads.core.data.repository.SessionRepository r10 = r6.sessionRepository
            r0.L$0 = r6
            r0.L$1 = r5
            r0.L$2 = r2
            r7 = 5
            r0.label = r7
            java.lang.Object r10 = r10.getGatewayCache(r0)
            if (r10 != r1) goto L_0x01a9
            return r1
        L_0x01a9:
            com.google.protobuf.ByteString r10 = (com.google.protobuf.ByteString) r10
            boolean r7 = r10.isEmpty()
            if (r7 != 0) goto L_0x01b4
            r2.setCache(r10)
        L_0x01b4:
            com.unity3d.ads.core.data.repository.LegacyUserConsentRepository r10 = r6.legacyUserConsentRepository
            java.lang.String r10 = r10.getLegacyFlowUserConsent()
            if (r10 == 0) goto L_0x01bf
            r2.setLegacyFlowUserConsent(r10)
        L_0x01bf:
            gateway.v1.InitializationRequestOuterClass$InitializationRequest r10 = r5._build()
            gateway.v1.UniversalRequestKt r2 = gateway.v1.UniversalRequestKt.INSTANCE
            gateway.v1.UniversalRequestKt$PayloadKt$Dsl$Companion r2 = gateway.v1.UniversalRequestKt.PayloadKt.Dsl.Companion
            gateway.v1.UniversalRequestOuterClass$UniversalRequest$Payload$Builder r5 = gateway.v1.UniversalRequestOuterClass.UniversalRequest.Payload.newBuilder()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r3)
            gateway.v1.UniversalRequestKt$PayloadKt$Dsl r2 = r2._create(r5)
            r2.setInitializationRequest(r10)
            gateway.v1.UniversalRequestOuterClass$UniversalRequest$Payload r10 = r2._build()
            com.unity3d.ads.core.domain.GetUniversalRequestForPayLoad r2 = r6.getUniversalRequestForPayLoad
            r0.L$0 = r4
            r0.L$1 = r4
            r0.L$2 = r4
            r3 = 6
            r0.label = r3
            java.lang.Object r10 = r2.invoke(r10, r0)
            if (r10 != r1) goto L_0x01eb
            return r1
        L_0x01eb:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.GetAndroidInitializationRequest.invoke(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
