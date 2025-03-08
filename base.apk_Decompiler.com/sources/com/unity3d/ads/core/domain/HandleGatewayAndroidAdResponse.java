package com.unity3d.ads.core.domain;

import com.unity3d.ads.core.data.repository.AdRepository;
import com.unity3d.ads.core.data.repository.CampaignStateRepository;
import com.unity3d.ads.core.data.repository.DeviceInfoRepository;
import com.unity3d.ads.core.data.repository.SessionRepository;
import com.unity3d.ads.core.domain.events.GetOperativeEventApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017¢\u0006\u0002\u0010\u0018J3\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"H@ø\u0001\u0000¢\u0006\u0002\u0010#J1\u0010$\u001a\u00020%2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)HBø\u0001\u0000¢\u0006\u0002\u0010*R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006+"}, d2 = {"Lcom/unity3d/ads/core/domain/HandleGatewayAndroidAdResponse;", "Lcom/unity3d/ads/core/domain/HandleGatewayAdResponse;", "adRepository", "Lcom/unity3d/ads/core/data/repository/AdRepository;", "getWebViewContainerUseCase", "Lcom/unity3d/ads/core/domain/AndroidGetWebViewContainerUseCase;", "getWebViewBridge", "Lcom/unity3d/ads/core/domain/GetWebViewBridgeUseCase;", "defaultDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "deviceInfoRepository", "Lcom/unity3d/ads/core/data/repository/DeviceInfoRepository;", "getHandleAndroidInvocationsUseCase", "Lcom/unity3d/ads/core/domain/HandleAndroidInvocationsUseCase;", "sessionRepository", "Lcom/unity3d/ads/core/data/repository/SessionRepository;", "campaignStateRepository", "Lcom/unity3d/ads/core/data/repository/CampaignStateRepository;", "executeAdViewerRequest", "Lcom/unity3d/ads/core/domain/ExecuteAdViewerRequest;", "sendDiagnosticEvent", "Lcom/unity3d/ads/core/domain/SendDiagnosticEvent;", "getOperativeEventApi", "Lcom/unity3d/ads/core/domain/events/GetOperativeEventApi;", "(Lcom/unity3d/ads/core/data/repository/AdRepository;Lcom/unity3d/ads/core/domain/AndroidGetWebViewContainerUseCase;Lcom/unity3d/ads/core/domain/GetWebViewBridgeUseCase;Lkotlinx/coroutines/CoroutineDispatcher;Lcom/unity3d/ads/core/data/repository/DeviceInfoRepository;Lcom/unity3d/ads/core/domain/HandleAndroidInvocationsUseCase;Lcom/unity3d/ads/core/data/repository/SessionRepository;Lcom/unity3d/ads/core/data/repository/CampaignStateRepository;Lcom/unity3d/ads/core/domain/ExecuteAdViewerRequest;Lcom/unity3d/ads/core/domain/SendDiagnosticEvent;Lcom/unity3d/ads/core/domain/events/GetOperativeEventApi;)V", "cleanup", "", "t", "", "opportunityId", "Lcom/google/protobuf/ByteString;", "response", "Lgateway/v1/AdResponseOuterClass$AdResponse;", "adPlayer", "Lcom/unity3d/ads/adplayer/AndroidFullscreenWebViewAdPlayer;", "(Ljava/lang/Throwable;Lcom/google/protobuf/ByteString;Lgateway/v1/AdResponseOuterClass$AdResponse;Lcom/unity3d/ads/adplayer/AndroidFullscreenWebViewAdPlayer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "invoke", "Lcom/unity3d/ads/core/data/model/LoadResult;", "context", "Landroid/content/Context;", "placementId", "", "(Lcom/google/protobuf/ByteString;Lgateway/v1/AdResponseOuterClass$AdResponse;Landroid/content/Context;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: HandleGatewayAndroidAdResponse.kt */
public final class HandleGatewayAndroidAdResponse implements HandleGatewayAdResponse {
    private final AdRepository adRepository;
    /* access modifiers changed from: private */
    public final CampaignStateRepository campaignStateRepository;
    private final CoroutineDispatcher defaultDispatcher;
    private final DeviceInfoRepository deviceInfoRepository;
    private final ExecuteAdViewerRequest executeAdViewerRequest;
    private final HandleAndroidInvocationsUseCase getHandleAndroidInvocationsUseCase;
    private final GetOperativeEventApi getOperativeEventApi;
    private final GetWebViewBridgeUseCase getWebViewBridge;
    private final AndroidGetWebViewContainerUseCase getWebViewContainerUseCase;
    private final SendDiagnosticEvent sendDiagnosticEvent;
    private final SessionRepository sessionRepository;

    public HandleGatewayAndroidAdResponse(AdRepository adRepository2, AndroidGetWebViewContainerUseCase androidGetWebViewContainerUseCase, GetWebViewBridgeUseCase getWebViewBridgeUseCase, CoroutineDispatcher coroutineDispatcher, DeviceInfoRepository deviceInfoRepository2, HandleAndroidInvocationsUseCase handleAndroidInvocationsUseCase, SessionRepository sessionRepository2, CampaignStateRepository campaignStateRepository2, ExecuteAdViewerRequest executeAdViewerRequest2, SendDiagnosticEvent sendDiagnosticEvent2, GetOperativeEventApi getOperativeEventApi2) {
        Intrinsics.checkNotNullParameter(adRepository2, "adRepository");
        Intrinsics.checkNotNullParameter(androidGetWebViewContainerUseCase, "getWebViewContainerUseCase");
        Intrinsics.checkNotNullParameter(getWebViewBridgeUseCase, "getWebViewBridge");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "defaultDispatcher");
        Intrinsics.checkNotNullParameter(deviceInfoRepository2, "deviceInfoRepository");
        Intrinsics.checkNotNullParameter(handleAndroidInvocationsUseCase, "getHandleAndroidInvocationsUseCase");
        Intrinsics.checkNotNullParameter(sessionRepository2, "sessionRepository");
        Intrinsics.checkNotNullParameter(campaignStateRepository2, "campaignStateRepository");
        Intrinsics.checkNotNullParameter(executeAdViewerRequest2, "executeAdViewerRequest");
        Intrinsics.checkNotNullParameter(sendDiagnosticEvent2, "sendDiagnosticEvent");
        Intrinsics.checkNotNullParameter(getOperativeEventApi2, "getOperativeEventApi");
        this.adRepository = adRepository2;
        this.getWebViewContainerUseCase = androidGetWebViewContainerUseCase;
        this.getWebViewBridge = getWebViewBridgeUseCase;
        this.defaultDispatcher = coroutineDispatcher;
        this.deviceInfoRepository = deviceInfoRepository2;
        this.getHandleAndroidInvocationsUseCase = handleAndroidInvocationsUseCase;
        this.sessionRepository = sessionRepository2;
        this.campaignStateRepository = campaignStateRepository2;
        this.executeAdViewerRequest = executeAdViewerRequest2;
        this.sendDiagnosticEvent = sendDiagnosticEvent2;
        this.getOperativeEventApi = getOperativeEventApi2;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x02f1, code lost:
        if (r6 != null) goto L_0x02f3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x02f3, code lost:
        r6 = r6.getMessage();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x02f8, code lost:
        r6 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x02f9, code lost:
        r7[0] = r6;
        r15 = java.lang.String.format(com.unity3d.ads.core.data.model.LoadResult.MSG_COMMUNICATION_FAILURE_WITH_DETAILS, java.util.Arrays.copyOf(r7, 1));
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r15, "format(this, *args)");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x0315, code lost:
        return com.unity3d.ads.core.data.model.LoadResult.Failure.copy$default(r0, (com.unity3d.ads.UnityAds.UnityAdsLoadError) null, r15, (java.lang.Throwable) null, 5, (java.lang.Object) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x0316, code lost:
        throw r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x0317, code lost:
        r2.L$0 = r9;
        r2.L$1 = r4;
        r2.L$2 = r8;
        r2.L$3 = r5;
        r2.L$4 = r0;
        r2.L$5 = null;
        r2.L$6 = null;
        r2.label = 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x033f, code lost:
        if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.NonCancellable.INSTANCE, new com.unity3d.ads.core.domain.HandleGatewayAndroidAdResponse$invoke$5(r9, r12, r4, r8, r5, (kotlin.coroutines.Continuation<? super com.unity3d.ads.core.domain.HandleGatewayAndroidAdResponse$invoke$5>) null), r2) == r3) goto L_0x0341;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x0341, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x0344, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x0345, code lost:
        r10 = r5;
        r6 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x0348, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x034a, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x034b, code lost:
        r7 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x034e, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x034f, code lost:
        r7 = r13;
        r6 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x0351, code lost:
        r10 = r6;
        r6 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x0353, code lost:
        r9 = r8;
        r8 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x038a, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x038b, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x038c, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:?, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:?, code lost:
        r0 = (com.unity3d.ads.adplayer.AndroidWebViewContainer) r0;
        r23 = r13.getWebViewBridge.invoke(r0);
        r16 = new com.unity3d.ads.adplayer.WebViewAdPlayer(r23, r13.deviceInfoRepository, r13.sessionRepository, r13.executeAdViewerRequest, r13.defaultDispatcher, r13.sendDiagnosticEvent);
        r15.element = new com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer(r16, com.unity3d.ads.core.extensions.ProtobufExtensionsKt.toISO8859String(r4), r0, r13.deviceInfoRepository, r13.sessionRepository);
        kotlinx.coroutines.flow.FlowKt.launchIn(kotlinx.coroutines.flow.FlowKt.onEach(r13.deviceInfoRepository.getAllowedPii(), new com.unity3d.ads.core.domain.HandleGatewayAndroidAdResponse$invoke$2(r16)), r16.getScope());
        kotlinx.coroutines.flow.FlowKt.launchIn(kotlinx.coroutines.flow.FlowKt.onEach(r16.getUpdateCampaignState(), new com.unity3d.ads.core.domain.HandleGatewayAndroidAdResponse$invoke$3(r13, r4, r12, (kotlin.coroutines.Continuation<? super com.unity3d.ads.core.domain.HandleGatewayAndroidAdResponse$invoke$3>) null)), r16.getScope());
        r5 = r8.getTrackingToken();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, "response.trackingToken");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0219, code lost:
        r10 = r10;
        r18 = r16;
        r24 = r13;
        r13 = r5;
        r5 = r14;
        r6 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:?, code lost:
        r10 = new com.unity3d.ads.core.data.model.AdObject(r4, r12, r13, (com.unity3d.ads.adplayer.FullscreenAdPlayer) r15.element, (java.lang.String) null, 16, (kotlin.jvm.internal.DefaultConstructorMarker) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x022c, code lost:
        r7 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:?, code lost:
        r10 = r7.getHandleAndroidInvocationsUseCase;
        r11 = r23.getOnInvocation();
        r12 = r8.getAdData();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, "response.adData");
        r12 = com.unity3d.ads.core.extensions.ProtobufExtensionsKt.toBase64(r12);
        r13 = r8.getAdDataRefreshToken();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r13, "response.adDataRefreshToken");
        r13 = com.unity3d.ads.core.extensions.ProtobufExtensionsKt.toBase64(r13);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, "base64ImpressionConfiguration");
        kotlinx.coroutines.flow.FlowKt.launchIn(r10.invoke(r11, r12, r13, r9, r10, new com.unity3d.ads.core.domain.HandleGatewayAndroidAdResponse$invoke$4(r0, r5, (kotlin.coroutines.Continuation<? super com.unity3d.ads.core.domain.HandleGatewayAndroidAdResponse$invoke$4>) null)), r18.getScope());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:?, code lost:
        r0 = r18.getLoadEvent();
        r2.L$0 = r7;
        r2.L$1 = r4;
        r2.L$2 = r8;
        r2.L$3 = r6;
        r2.L$4 = r10;
        r2.L$5 = null;
        r2.L$6 = null;
        r2.label = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0288, code lost:
        if (r0.await(r2) != r3) goto L_0x028b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x028a, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x028b, code lost:
        r9 = r4;
        r5 = r6;
        r10 = r7;
        r4 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:?, code lost:
        r0 = r10.campaignStateRepository;
        r2.L$0 = r10;
        r2.L$1 = r9;
        r2.L$2 = r8;
        r2.L$3 = r5;
        r2.L$4 = r4;
        r2.label = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x02a2, code lost:
        if (r0.setLoadTimestamp(r9, r2) != r3) goto L_0x02a5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x02a4, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:?, code lost:
        r0 = r10.adRepository;
        r2.L$0 = r10;
        r2.L$1 = r9;
        r2.L$2 = r8;
        r2.L$3 = r5;
        r2.L$4 = r4;
        r2.label = 5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x02b8, code lost:
        if (r0.addAd(r9, r4, r2) != r3) goto L_0x02bb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x02ba, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x02bb, code lost:
        r6 = r8;
        r8 = r9;
        r9 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x02c3, code lost:
        return new com.unity3d.ads.core.data.model.LoadResult.Success(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x02c4, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x02c5, code lost:
        r6 = r10;
        r10 = r5;
        r25 = r9;
        r9 = r8;
        r8 = r25;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x02ce, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x02cf, code lost:
        r12 = r0;
        r5 = r6;
        r9 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:?, code lost:
        r0 = new com.unity3d.ads.core.data.model.LoadResult.Failure(com.unity3d.ads.UnityAds.UnityAdsLoadError.INTERNAL_ERROR, com.unity3d.ads.core.data.model.LoadResult.MSG_COMMUNICATION_FAILURE, r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x02dd, code lost:
        if ((r12 instanceof java.util.concurrent.CancellationException) != false) goto L_0x02df;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x02e5, code lost:
        if ((r12.getCause() instanceof com.unity3d.ads.adplayer.AdPlayerError) != false) goto L_0x02e7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x02e7, code lost:
        r7 = new java.lang.Object[1];
        r6 = r12.getCause();
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x038a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x038b  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object invoke(com.google.protobuf.ByteString r27, gateway.v1.AdResponseOuterClass.AdResponse r28, android.content.Context r29, java.lang.String r30, kotlin.coroutines.Continuation<? super com.unity3d.ads.core.data.model.LoadResult> r31) {
        /*
            r26 = this;
            r1 = r26
            r0 = r31
            boolean r2 = r0 instanceof com.unity3d.ads.core.domain.HandleGatewayAndroidAdResponse$invoke$1
            if (r2 == 0) goto L_0x0018
            r2 = r0
            com.unity3d.ads.core.domain.HandleGatewayAndroidAdResponse$invoke$1 r2 = (com.unity3d.ads.core.domain.HandleGatewayAndroidAdResponse$invoke$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r0 = r2.label
            int r0 = r0 - r4
            r2.label = r0
            goto L_0x001d
        L_0x0018:
            com.unity3d.ads.core.domain.HandleGatewayAndroidAdResponse$invoke$1 r2 = new com.unity3d.ads.core.domain.HandleGatewayAndroidAdResponse$invoke$1
            r2.<init>(r1, r0)
        L_0x001d:
            java.lang.Object r0 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 2
            r6 = 1
            switch(r4) {
                case 0: goto L_0x00dc;
                case 1: goto L_0x00ae;
                case 2: goto L_0x008f;
                case 3: goto L_0x0076;
                case 4: goto L_0x0054;
                case 5: goto L_0x003b;
                case 6: goto L_0x0032;
                default: goto L_0x002a;
            }
        L_0x002a:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0032:
            java.lang.Object r2 = r2.L$0
            java.util.concurrent.CancellationException r2 = (java.util.concurrent.CancellationException) r2
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x038c
        L_0x003b:
            java.lang.Object r4 = r2.L$4
            com.unity3d.ads.core.data.model.AdObject r4 = (com.unity3d.ads.core.data.model.AdObject) r4
            java.lang.Object r5 = r2.L$3
            kotlin.jvm.internal.Ref$ObjectRef r5 = (kotlin.jvm.internal.Ref.ObjectRef) r5
            java.lang.Object r6 = r2.L$2
            gateway.v1.AdResponseOuterClass$AdResponse r6 = (gateway.v1.AdResponseOuterClass.AdResponse) r6
            java.lang.Object r8 = r2.L$1
            com.google.protobuf.ByteString r8 = (com.google.protobuf.ByteString) r8
            java.lang.Object r9 = r2.L$0
            com.unity3d.ads.core.domain.HandleGatewayAndroidAdResponse r9 = (com.unity3d.ads.core.domain.HandleGatewayAndroidAdResponse) r9
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ CancellationException -> 0x006d }
            goto L_0x02be
        L_0x0054:
            java.lang.Object r4 = r2.L$4
            com.unity3d.ads.core.data.model.LoadResult$Failure r4 = (com.unity3d.ads.core.data.model.LoadResult.Failure) r4
            java.lang.Object r5 = r2.L$3
            kotlin.jvm.internal.Ref$ObjectRef r5 = (kotlin.jvm.internal.Ref.ObjectRef) r5
            java.lang.Object r6 = r2.L$2
            gateway.v1.AdResponseOuterClass$AdResponse r6 = (gateway.v1.AdResponseOuterClass.AdResponse) r6
            java.lang.Object r8 = r2.L$1
            com.google.protobuf.ByteString r8 = (com.google.protobuf.ByteString) r8
            java.lang.Object r9 = r2.L$0
            com.unity3d.ads.core.domain.HandleGatewayAndroidAdResponse r9 = (com.unity3d.ads.core.domain.HandleGatewayAndroidAdResponse) r9
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ CancellationException -> 0x006d }
            goto L_0x0343
        L_0x006d:
            r0 = move-exception
            r10 = r5
            r25 = r9
            r9 = r6
            r6 = r25
            goto L_0x0364
        L_0x0076:
            java.lang.Object r4 = r2.L$4
            com.unity3d.ads.core.data.model.AdObject r4 = (com.unity3d.ads.core.data.model.AdObject) r4
            java.lang.Object r5 = r2.L$3
            kotlin.jvm.internal.Ref$ObjectRef r5 = (kotlin.jvm.internal.Ref.ObjectRef) r5
            java.lang.Object r8 = r2.L$2
            gateway.v1.AdResponseOuterClass$AdResponse r8 = (gateway.v1.AdResponseOuterClass.AdResponse) r8
            java.lang.Object r9 = r2.L$1
            com.google.protobuf.ByteString r9 = (com.google.protobuf.ByteString) r9
            java.lang.Object r10 = r2.L$0
            com.unity3d.ads.core.domain.HandleGatewayAndroidAdResponse r10 = (com.unity3d.ads.core.domain.HandleGatewayAndroidAdResponse) r10
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ all -> 0x00a8 }
            goto L_0x02a5
        L_0x008f:
            java.lang.Object r4 = r2.L$4
            com.unity3d.ads.core.data.model.AdObject r4 = (com.unity3d.ads.core.data.model.AdObject) r4
            java.lang.Object r5 = r2.L$3
            kotlin.jvm.internal.Ref$ObjectRef r5 = (kotlin.jvm.internal.Ref.ObjectRef) r5
            java.lang.Object r8 = r2.L$2
            gateway.v1.AdResponseOuterClass$AdResponse r8 = (gateway.v1.AdResponseOuterClass.AdResponse) r8
            java.lang.Object r9 = r2.L$1
            com.google.protobuf.ByteString r9 = (com.google.protobuf.ByteString) r9
            java.lang.Object r10 = r2.L$0
            com.unity3d.ads.core.domain.HandleGatewayAndroidAdResponse r10 = (com.unity3d.ads.core.domain.HandleGatewayAndroidAdResponse) r10
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ all -> 0x00a8 }
            goto L_0x028f
        L_0x00a8:
            r0 = move-exception
            r12 = r0
            r4 = r9
            r9 = r10
            goto L_0x02d2
        L_0x00ae:
            java.lang.Object r4 = r2.L$6
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r8 = r2.L$5
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r9 = r2.L$4
            kotlin.jvm.internal.Ref$ObjectRef r9 = (kotlin.jvm.internal.Ref.ObjectRef) r9
            java.lang.Object r10 = r2.L$3
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r11 = r2.L$2
            gateway.v1.AdResponseOuterClass$AdResponse r11 = (gateway.v1.AdResponseOuterClass.AdResponse) r11
            java.lang.Object r12 = r2.L$1
            com.google.protobuf.ByteString r12 = (com.google.protobuf.ByteString) r12
            java.lang.Object r13 = r2.L$0
            com.unity3d.ads.core.domain.HandleGatewayAndroidAdResponse r13 = (com.unity3d.ads.core.domain.HandleGatewayAndroidAdResponse) r13
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ CancellationException -> 0x00d5 }
            r14 = r8
            r15 = r9
            r8 = r11
            r9 = r4
            r4 = r12
            r12 = r10
            goto L_0x019b
        L_0x00d5:
            r0 = move-exception
            r10 = r9
            r9 = r11
            r8 = r12
            r6 = r13
            goto L_0x0364
        L_0x00dc:
            kotlin.ResultKt.throwOnFailure(r0)
            kotlin.jvm.internal.Ref$ObjectRef r4 = new kotlin.jvm.internal.Ref$ObjectRef
            r4.<init>()
            boolean r0 = r28.hasError()     // Catch:{ CancellationException -> 0x035a }
            if (r0 == 0) goto L_0x0100
            com.unity3d.ads.core.data.model.LoadResult$Failure r0 = new com.unity3d.ads.core.data.model.LoadResult$Failure     // Catch:{ CancellationException -> 0x00f8 }
            com.unity3d.ads.UnityAds$UnityAdsLoadError r9 = com.unity3d.ads.UnityAds.UnityAdsLoadError.INTERNAL_ERROR     // Catch:{ CancellationException -> 0x00f8 }
            java.lang.String r10 = "[UnityAds] Internal communication failure"
            r11 = 0
            r12 = 4
            r13 = 0
            r8 = r0
            r8.<init>(r9, r10, r11, r12, r13)     // Catch:{ CancellationException -> 0x00f8 }
            return r0
        L_0x00f8:
            r0 = move-exception
            r8 = r27
            r9 = r28
            r6 = r1
            goto L_0x0363
        L_0x0100:
            com.google.protobuf.ByteString r0 = r28.getAdData()     // Catch:{ CancellationException -> 0x035a }
            boolean r0 = r0.isEmpty()     // Catch:{ CancellationException -> 0x035a }
            if (r0 == 0) goto L_0x0118
            com.unity3d.ads.core.data.model.LoadResult$Failure r0 = new com.unity3d.ads.core.data.model.LoadResult$Failure     // Catch:{ CancellationException -> 0x00f8 }
            com.unity3d.ads.UnityAds$UnityAdsLoadError r9 = com.unity3d.ads.UnityAds.UnityAdsLoadError.NO_FILL     // Catch:{ CancellationException -> 0x00f8 }
            java.lang.String r10 = "[UnityAds] No fill"
            r11 = 0
            r12 = 4
            r13 = 0
            r8 = r0
            r8.<init>(r9, r10, r11, r12, r13)     // Catch:{ CancellationException -> 0x00f8 }
            return r0
        L_0x0118:
            boolean r0 = r28.hasWebviewConfiguration()     // Catch:{ CancellationException -> 0x035a }
            if (r0 != 0) goto L_0x012c
            com.unity3d.ads.core.data.model.LoadResult$Failure r0 = new com.unity3d.ads.core.data.model.LoadResult$Failure     // Catch:{ CancellationException -> 0x00f8 }
            com.unity3d.ads.UnityAds$UnityAdsLoadError r9 = com.unity3d.ads.UnityAds.UnityAdsLoadError.INTERNAL_ERROR     // Catch:{ CancellationException -> 0x00f8 }
            java.lang.String r10 = "[UnityAds] Internal communication failure"
            r11 = 0
            r12 = 4
            r13 = 0
            r8 = r0
            r8.<init>(r9, r10, r11, r12, r13)     // Catch:{ CancellationException -> 0x00f8 }
            return r0
        L_0x012c:
            java.net.URI r0 = new java.net.URI     // Catch:{ CancellationException -> 0x035a }
            gateway.v1.WebviewConfiguration$WebViewConfiguration r8 = r28.getWebviewConfiguration()     // Catch:{ CancellationException -> 0x035a }
            java.lang.String r8 = r8.getEntryPoint()     // Catch:{ CancellationException -> 0x035a }
            r0.<init>(r8)     // Catch:{ CancellationException -> 0x035a }
            java.lang.String r8 = r0.getQuery()     // Catch:{ CancellationException -> 0x035a }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ CancellationException -> 0x035a }
            r9.<init>()     // Catch:{ CancellationException -> 0x035a }
            java.net.URL r10 = new java.net.URL     // Catch:{ CancellationException -> 0x035a }
            java.lang.String r11 = r0.getScheme()     // Catch:{ CancellationException -> 0x035a }
            java.lang.String r12 = r0.getHost()     // Catch:{ CancellationException -> 0x035a }
            java.lang.String r0 = r0.getPath()     // Catch:{ CancellationException -> 0x035a }
            r10.<init>(r11, r12, r0)     // Catch:{ CancellationException -> 0x035a }
            java.lang.String r0 = r10.toString()     // Catch:{ CancellationException -> 0x035a }
            r9.append(r0)     // Catch:{ CancellationException -> 0x035a }
            java.lang.String r0 = "?platform=android&"
            r9.append(r0)     // Catch:{ CancellationException -> 0x035a }
            r9.append(r8)     // Catch:{ CancellationException -> 0x035a }
            java.lang.String r8 = r9.toString()     // Catch:{ CancellationException -> 0x035a }
            com.google.protobuf.ByteString r0 = r28.getImpressionConfiguration()     // Catch:{ CancellationException -> 0x035a }
            byte[] r0 = r0.toByteArray()     // Catch:{ CancellationException -> 0x035a }
            java.lang.String r0 = android.util.Base64.encodeToString(r0, r5)     // Catch:{ CancellationException -> 0x035a }
            com.unity3d.ads.core.domain.AndroidGetWebViewContainerUseCase r9 = r1.getWebViewContainerUseCase     // Catch:{ CancellationException -> 0x035a }
            r2.L$0 = r1     // Catch:{ CancellationException -> 0x035a }
            r10 = r27
            r2.L$1 = r10     // Catch:{ CancellationException -> 0x0358 }
            r11 = r28
            r2.L$2 = r11     // Catch:{ CancellationException -> 0x0356 }
            r12 = r30
            r2.L$3 = r12     // Catch:{ CancellationException -> 0x0356 }
            r2.L$4 = r4     // Catch:{ CancellationException -> 0x0356 }
            r2.L$5 = r8     // Catch:{ CancellationException -> 0x0356 }
            r2.L$6 = r0     // Catch:{ CancellationException -> 0x0356 }
            r2.label = r6     // Catch:{ CancellationException -> 0x0356 }
            java.lang.Object r9 = r9.invoke(r2)     // Catch:{ CancellationException -> 0x0356 }
            if (r9 != r3) goto L_0x0191
            return r3
        L_0x0191:
            r13 = r1
            r15 = r4
            r14 = r8
            r4 = r10
            r8 = r11
            r25 = r9
            r9 = r0
            r0 = r25
        L_0x019b:
            com.unity3d.ads.adplayer.AndroidWebViewContainer r0 = (com.unity3d.ads.adplayer.AndroidWebViewContainer) r0     // Catch:{ CancellationException -> 0x034e }
            com.unity3d.ads.core.domain.GetWebViewBridgeUseCase r10 = r13.getWebViewBridge     // Catch:{ CancellationException -> 0x034e }
            com.unity3d.ads.adplayer.WebViewBridge r23 = r10.invoke(r0)     // Catch:{ CancellationException -> 0x034e }
            com.unity3d.ads.adplayer.WebViewAdPlayer r11 = new com.unity3d.ads.adplayer.WebViewAdPlayer     // Catch:{ CancellationException -> 0x034e }
            com.unity3d.ads.core.data.repository.DeviceInfoRepository r10 = r13.deviceInfoRepository     // Catch:{ CancellationException -> 0x034e }
            com.unity3d.ads.core.data.repository.SessionRepository r6 = r13.sessionRepository     // Catch:{ CancellationException -> 0x034e }
            com.unity3d.ads.core.domain.ExecuteAdViewerRequest r5 = r13.executeAdViewerRequest     // Catch:{ CancellationException -> 0x034e }
            kotlinx.coroutines.CoroutineDispatcher r7 = r13.defaultDispatcher     // Catch:{ CancellationException -> 0x034e }
            com.unity3d.ads.core.domain.SendDiagnosticEvent r1 = r13.sendDiagnosticEvent     // Catch:{ CancellationException -> 0x034e }
            r16 = r11
            r17 = r23
            r18 = r10
            r19 = r6
            r20 = r5
            r21 = r7
            r22 = r1
            r16.<init>(r17, r18, r19, r20, r21, r22)     // Catch:{ CancellationException -> 0x034e }
            java.lang.String r18 = com.unity3d.ads.core.extensions.ProtobufExtensionsKt.toISO8859String(r4)     // Catch:{ CancellationException -> 0x034e }
            com.unity3d.ads.core.data.repository.DeviceInfoRepository r1 = r13.deviceInfoRepository     // Catch:{ CancellationException -> 0x034e }
            com.unity3d.ads.core.data.repository.SessionRepository r5 = r13.sessionRepository     // Catch:{ CancellationException -> 0x034e }
            com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer r6 = new com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer     // Catch:{ CancellationException -> 0x034e }
            r16 = r6
            r17 = r11
            r19 = r0
            r20 = r1
            r21 = r5
            r16.<init>(r17, r18, r19, r20, r21)     // Catch:{ CancellationException -> 0x034e }
            r15.element = r6     // Catch:{ CancellationException -> 0x034e }
            com.unity3d.ads.core.data.repository.DeviceInfoRepository r1 = r13.deviceInfoRepository     // Catch:{ CancellationException -> 0x034e }
            kotlinx.coroutines.flow.MutableStateFlow r1 = r1.getAllowedPii()     // Catch:{ CancellationException -> 0x034e }
            kotlinx.coroutines.flow.Flow r1 = (kotlinx.coroutines.flow.Flow) r1     // Catch:{ CancellationException -> 0x034e }
            com.unity3d.ads.core.domain.HandleGatewayAndroidAdResponse$invoke$2 r5 = new com.unity3d.ads.core.domain.HandleGatewayAndroidAdResponse$invoke$2     // Catch:{ CancellationException -> 0x034e }
            r5.<init>(r11)     // Catch:{ CancellationException -> 0x034e }
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5     // Catch:{ CancellationException -> 0x034e }
            kotlinx.coroutines.flow.Flow r1 = kotlinx.coroutines.flow.FlowKt.onEach(r1, r5)     // Catch:{ CancellationException -> 0x034e }
            kotlinx.coroutines.CoroutineScope r5 = r11.getScope()     // Catch:{ CancellationException -> 0x034e }
            kotlinx.coroutines.flow.FlowKt.launchIn(r1, r5)     // Catch:{ CancellationException -> 0x034e }
            kotlinx.coroutines.flow.Flow r1 = r11.getUpdateCampaignState()     // Catch:{ CancellationException -> 0x034e }
            com.unity3d.ads.core.domain.HandleGatewayAndroidAdResponse$invoke$3 r5 = new com.unity3d.ads.core.domain.HandleGatewayAndroidAdResponse$invoke$3     // Catch:{ CancellationException -> 0x034e }
            r6 = 0
            r5.<init>(r13, r4, r12, r6)     // Catch:{ CancellationException -> 0x034e }
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5     // Catch:{ CancellationException -> 0x034e }
            kotlinx.coroutines.flow.Flow r1 = kotlinx.coroutines.flow.FlowKt.onEach(r1, r5)     // Catch:{ CancellationException -> 0x034e }
            kotlinx.coroutines.CoroutineScope r5 = r11.getScope()     // Catch:{ CancellationException -> 0x034e }
            kotlinx.coroutines.flow.FlowKt.launchIn(r1, r5)     // Catch:{ CancellationException -> 0x034e }
            com.unity3d.ads.core.data.model.AdObject r1 = new com.unity3d.ads.core.data.model.AdObject     // Catch:{ CancellationException -> 0x034e }
            com.google.protobuf.ByteString r5 = r8.getTrackingToken()     // Catch:{ CancellationException -> 0x034e }
            java.lang.String r6 = "response.trackingToken"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)     // Catch:{ CancellationException -> 0x034e }
            T r6 = r15.element     // Catch:{ CancellationException -> 0x034e }
            com.unity3d.ads.adplayer.FullscreenAdPlayer r6 = (com.unity3d.ads.adplayer.FullscreenAdPlayer) r6     // Catch:{ CancellationException -> 0x034e }
            r7 = 0
            r16 = 16
            r17 = 0
            r10 = r1
            r18 = r11
            r11 = r4
            r24 = r13
            r13 = r5
            r5 = r14
            r14 = r6
            r6 = r15
            r15 = r7
            r10.<init>(r11, r12, r13, r14, r15, r16, r17)     // Catch:{ CancellationException -> 0x034a }
            r7 = r24
            com.unity3d.ads.core.domain.HandleAndroidInvocationsUseCase r10 = r7.getHandleAndroidInvocationsUseCase     // Catch:{ CancellationException -> 0x0348 }
            kotlinx.coroutines.flow.SharedFlow r11 = r23.getOnInvocation()     // Catch:{ CancellationException -> 0x0348 }
            com.google.protobuf.ByteString r12 = r8.getAdData()     // Catch:{ CancellationException -> 0x0348 }
            java.lang.String r13 = "response.adData"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r13)     // Catch:{ CancellationException -> 0x0348 }
            java.lang.String r12 = com.unity3d.ads.core.extensions.ProtobufExtensionsKt.toBase64(r12)     // Catch:{ CancellationException -> 0x0348 }
            com.google.protobuf.ByteString r13 = r8.getAdDataRefreshToken()     // Catch:{ CancellationException -> 0x0348 }
            java.lang.String r14 = "response.adDataRefreshToken"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r13, r14)     // Catch:{ CancellationException -> 0x0348 }
            java.lang.String r13 = com.unity3d.ads.core.extensions.ProtobufExtensionsKt.toBase64(r13)     // Catch:{ CancellationException -> 0x0348 }
            java.lang.String r14 = "base64ImpressionConfiguration"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r14)     // Catch:{ CancellationException -> 0x0348 }
            com.unity3d.ads.core.domain.HandleGatewayAndroidAdResponse$invoke$4 r14 = new com.unity3d.ads.core.domain.HandleGatewayAndroidAdResponse$invoke$4     // Catch:{ CancellationException -> 0x0348 }
            r15 = 0
            r14.<init>(r0, r5, r15)     // Catch:{ CancellationException -> 0x0348 }
            r15 = r14
            kotlin.jvm.functions.Function1 r15 = (kotlin.jvm.functions.Function1) r15     // Catch:{ CancellationException -> 0x0348 }
            r0 = r9
            r9 = r10
            r10 = r11
            r11 = r12
            r12 = r13
            r13 = r0
            r14 = r1
            kotlinx.coroutines.flow.Flow r0 = r9.invoke(r10, r11, r12, r13, r14, r15)     // Catch:{ CancellationException -> 0x0348 }
            kotlinx.coroutines.CoroutineScope r5 = r18.getScope()     // Catch:{ CancellationException -> 0x0348 }
            kotlinx.coroutines.flow.FlowKt.launchIn(r0, r5)     // Catch:{ CancellationException -> 0x0348 }
            kotlinx.coroutines.CompletableDeferred r0 = r18.getLoadEvent()     // Catch:{ all -> 0x02ce }
            r2.L$0 = r7     // Catch:{ all -> 0x02ce }
            r2.L$1 = r4     // Catch:{ all -> 0x02ce }
            r2.L$2 = r8     // Catch:{ all -> 0x02ce }
            r2.L$3 = r6     // Catch:{ all -> 0x02ce }
            r2.L$4 = r1     // Catch:{ all -> 0x02ce }
            r5 = 0
            r2.L$5 = r5     // Catch:{ all -> 0x02ce }
            r2.L$6 = r5     // Catch:{ all -> 0x02ce }
            r5 = 2
            r2.label = r5     // Catch:{ all -> 0x02ce }
            java.lang.Object r0 = r0.await(r2)     // Catch:{ all -> 0x02ce }
            if (r0 != r3) goto L_0x028b
            return r3
        L_0x028b:
            r9 = r4
            r5 = r6
            r10 = r7
            r4 = r1
        L_0x028f:
            com.unity3d.ads.core.data.repository.CampaignStateRepository r0 = r10.campaignStateRepository     // Catch:{ all -> 0x00a8 }
            r2.L$0 = r10     // Catch:{ all -> 0x00a8 }
            r2.L$1 = r9     // Catch:{ all -> 0x00a8 }
            r2.L$2 = r8     // Catch:{ all -> 0x00a8 }
            r2.L$3 = r5     // Catch:{ all -> 0x00a8 }
            r2.L$4 = r4     // Catch:{ all -> 0x00a8 }
            r1 = 3
            r2.label = r1     // Catch:{ all -> 0x00a8 }
            java.lang.Object r0 = r0.setLoadTimestamp(r9, r2)     // Catch:{ all -> 0x00a8 }
            if (r0 != r3) goto L_0x02a5
            return r3
        L_0x02a5:
            com.unity3d.ads.core.data.repository.AdRepository r0 = r10.adRepository     // Catch:{ CancellationException -> 0x02c4 }
            r2.L$0 = r10     // Catch:{ CancellationException -> 0x02c4 }
            r2.L$1 = r9     // Catch:{ CancellationException -> 0x02c4 }
            r2.L$2 = r8     // Catch:{ CancellationException -> 0x02c4 }
            r2.L$3 = r5     // Catch:{ CancellationException -> 0x02c4 }
            r2.L$4 = r4     // Catch:{ CancellationException -> 0x02c4 }
            r1 = 5
            r2.label = r1     // Catch:{ CancellationException -> 0x02c4 }
            java.lang.Object r0 = r0.addAd(r9, r4, r2)     // Catch:{ CancellationException -> 0x02c4 }
            if (r0 != r3) goto L_0x02bb
            return r3
        L_0x02bb:
            r6 = r8
            r8 = r9
            r9 = r10
        L_0x02be:
            com.unity3d.ads.core.data.model.LoadResult$Success r0 = new com.unity3d.ads.core.data.model.LoadResult$Success     // Catch:{ CancellationException -> 0x006d }
            r0.<init>(r4)     // Catch:{ CancellationException -> 0x006d }
            return r0
        L_0x02c4:
            r0 = move-exception
            r6 = r10
            r10 = r5
            r25 = r9
            r9 = r8
            r8 = r25
            goto L_0x0364
        L_0x02ce:
            r0 = move-exception
            r12 = r0
            r5 = r6
            r9 = r7
        L_0x02d2:
            com.unity3d.ads.core.data.model.LoadResult$Failure r0 = new com.unity3d.ads.core.data.model.LoadResult$Failure     // Catch:{ CancellationException -> 0x0344 }
            com.unity3d.ads.UnityAds$UnityAdsLoadError r1 = com.unity3d.ads.UnityAds.UnityAdsLoadError.INTERNAL_ERROR     // Catch:{ CancellationException -> 0x0344 }
            java.lang.String r6 = "[UnityAds] Internal communication failure"
            r0.<init>(r1, r6, r12)     // Catch:{ CancellationException -> 0x0344 }
            boolean r1 = r12 instanceof java.util.concurrent.CancellationException     // Catch:{ CancellationException -> 0x0344 }
            if (r1 == 0) goto L_0x0317
            java.lang.Throwable r1 = r12.getCause()     // Catch:{ CancellationException -> 0x0344 }
            boolean r1 = r1 instanceof com.unity3d.ads.adplayer.AdPlayerError     // Catch:{ CancellationException -> 0x0344 }
            if (r1 == 0) goto L_0x0316
            r14 = 0
            java.lang.String r1 = "[UnityAds] Internal communication failure: %s"
            r6 = 1
            java.lang.Object[] r7 = new java.lang.Object[r6]     // Catch:{ CancellationException -> 0x0344 }
            java.lang.Throwable r6 = r12.getCause()     // Catch:{ CancellationException -> 0x0344 }
            if (r6 == 0) goto L_0x02f8
            java.lang.String r6 = r6.getMessage()     // Catch:{ CancellationException -> 0x0344 }
            goto L_0x02f9
        L_0x02f8:
            r6 = 0
        L_0x02f9:
            r10 = 0
            r7[r10] = r6     // Catch:{ CancellationException -> 0x0344 }
            r6 = 1
            java.lang.Object[] r6 = java.util.Arrays.copyOf(r7, r6)     // Catch:{ CancellationException -> 0x0344 }
            java.lang.String r15 = java.lang.String.format(r1, r6)     // Catch:{ CancellationException -> 0x0344 }
            java.lang.String r1 = "format(this, *args)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r15, r1)     // Catch:{ CancellationException -> 0x0344 }
            r16 = 0
            r17 = 5
            r18 = 0
            r13 = r0
            com.unity3d.ads.core.data.model.LoadResult$Failure r0 = com.unity3d.ads.core.data.model.LoadResult.Failure.copy$default(r13, r14, r15, r16, r17, r18)     // Catch:{ CancellationException -> 0x0344 }
            return r0
        L_0x0316:
            throw r12     // Catch:{ CancellationException -> 0x0344 }
        L_0x0317:
            kotlinx.coroutines.NonCancellable r1 = kotlinx.coroutines.NonCancellable.INSTANCE     // Catch:{ CancellationException -> 0x0344 }
            kotlin.coroutines.CoroutineContext r1 = (kotlin.coroutines.CoroutineContext) r1     // Catch:{ CancellationException -> 0x0344 }
            com.unity3d.ads.core.domain.HandleGatewayAndroidAdResponse$invoke$5 r6 = new com.unity3d.ads.core.domain.HandleGatewayAndroidAdResponse$invoke$5     // Catch:{ CancellationException -> 0x0344 }
            r16 = 0
            r10 = r6
            r11 = r9
            r13 = r4
            r14 = r8
            r15 = r5
            r10.<init>(r11, r12, r13, r14, r15, r16)     // Catch:{ CancellationException -> 0x0344 }
            kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6     // Catch:{ CancellationException -> 0x0344 }
            r2.L$0 = r9     // Catch:{ CancellationException -> 0x0344 }
            r2.L$1 = r4     // Catch:{ CancellationException -> 0x0344 }
            r2.L$2 = r8     // Catch:{ CancellationException -> 0x0344 }
            r2.L$3 = r5     // Catch:{ CancellationException -> 0x0344 }
            r2.L$4 = r0     // Catch:{ CancellationException -> 0x0344 }
            r7 = 0
            r2.L$5 = r7     // Catch:{ CancellationException -> 0x0344 }
            r2.L$6 = r7     // Catch:{ CancellationException -> 0x0344 }
            r7 = 4
            r2.label = r7     // Catch:{ CancellationException -> 0x0344 }
            java.lang.Object r1 = kotlinx.coroutines.BuildersKt.withContext(r1, r6, r2)     // Catch:{ CancellationException -> 0x0344 }
            if (r1 != r3) goto L_0x0342
            return r3
        L_0x0342:
            r4 = r0
        L_0x0343:
            return r4
        L_0x0344:
            r0 = move-exception
            r10 = r5
            r6 = r9
            goto L_0x0353
        L_0x0348:
            r0 = move-exception
            goto L_0x0351
        L_0x034a:
            r0 = move-exception
            r7 = r24
            goto L_0x0351
        L_0x034e:
            r0 = move-exception
            r7 = r13
            r6 = r15
        L_0x0351:
            r10 = r6
            r6 = r7
        L_0x0353:
            r9 = r8
            r8 = r4
            goto L_0x0364
        L_0x0356:
            r0 = move-exception
            goto L_0x035f
        L_0x0358:
            r0 = move-exception
            goto L_0x035d
        L_0x035a:
            r0 = move-exception
            r10 = r27
        L_0x035d:
            r11 = r28
        L_0x035f:
            r6 = r26
            r8 = r10
            r9 = r11
        L_0x0363:
            r10 = r4
        L_0x0364:
            kotlinx.coroutines.NonCancellable r1 = kotlinx.coroutines.NonCancellable.INSTANCE
            kotlin.coroutines.CoroutineContext r1 = (kotlin.coroutines.CoroutineContext) r1
            com.unity3d.ads.core.domain.HandleGatewayAndroidAdResponse$invoke$6 r4 = new com.unity3d.ads.core.domain.HandleGatewayAndroidAdResponse$invoke$6
            r11 = 0
            r5 = r4
            r7 = r0
            r5.<init>(r6, r7, r8, r9, r10, r11)
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            r2.L$0 = r0
            r5 = 0
            r2.L$1 = r5
            r2.L$2 = r5
            r2.L$3 = r5
            r2.L$4 = r5
            r2.L$5 = r5
            r2.L$6 = r5
            r5 = 6
            r2.label = r5
            java.lang.Object r1 = kotlinx.coroutines.BuildersKt.withContext(r1, r4, r2)
            if (r1 != r3) goto L_0x038b
            return r3
        L_0x038b:
            r2 = r0
        L_0x038c:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.HandleGatewayAndroidAdResponse.invoke(com.google.protobuf.ByteString, gateway.v1.AdResponseOuterClass$AdResponse, android.content.Context, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object cleanup(java.lang.Throwable r15, com.google.protobuf.ByteString r16, gateway.v1.AdResponseOuterClass.AdResponse r17, com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer r18, kotlin.coroutines.Continuation<? super kotlin.Unit> r19) {
        /*
            r14 = this;
            r0 = r14
            r1 = r19
            boolean r2 = r1 instanceof com.unity3d.ads.core.domain.HandleGatewayAndroidAdResponse$cleanup$1
            if (r2 == 0) goto L_0x0017
            r2 = r1
            com.unity3d.ads.core.domain.HandleGatewayAndroidAdResponse$cleanup$1 r2 = (com.unity3d.ads.core.domain.HandleGatewayAndroidAdResponse$cleanup$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0017
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L_0x001c
        L_0x0017:
            com.unity3d.ads.core.domain.HandleGatewayAndroidAdResponse$cleanup$1 r2 = new com.unity3d.ads.core.domain.HandleGatewayAndroidAdResponse$cleanup$1
            r2.<init>(r14, r1)
        L_0x001c:
            java.lang.Object r1 = r2.result
            java.lang.Object r12 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r2.label
            r13 = 2
            r4 = 1
            if (r3 == 0) goto L_0x0042
            if (r3 == r4) goto L_0x0039
            if (r3 != r13) goto L_0x0031
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x00a1
        L_0x0031:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0039:
            java.lang.Object r3 = r2.L$0
            com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer r3 = (com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer) r3
            kotlin.ResultKt.throwOnFailure(r1)
            r1 = r3
            goto L_0x0093
        L_0x0042:
            kotlin.ResultKt.throwOnFailure(r1)
            gateway.v1.OperativeEventErrorDataKt$Dsl$Companion r1 = gateway.v1.OperativeEventErrorDataKt.Dsl.Companion
            gateway.v1.OperativeEventRequestOuterClass$OperativeEventErrorData$Builder r3 = gateway.v1.OperativeEventRequestOuterClass.OperativeEventErrorData.newBuilder()
            java.lang.String r5 = "newBuilder()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r5)
            gateway.v1.OperativeEventErrorDataKt$Dsl r1 = r1._create(r3)
            gateway.v1.OperativeEventRequestOuterClass$OperativeEventErrorType r3 = gateway.v1.OperativeEventRequestOuterClass.OperativeEventErrorType.OPERATIVE_EVENT_ERROR_TYPE_UNSPECIFIED
            r1.setErrorType(r3)
            java.lang.String r3 = r15.getMessage()
            if (r3 != 0) goto L_0x0061
            java.lang.String r3 = ""
        L_0x0061:
            r1.setMessage(r3)
            gateway.v1.OperativeEventRequestOuterClass$OperativeEventErrorData r1 = r1._build()
            com.unity3d.ads.core.domain.events.GetOperativeEventApi r3 = r0.getOperativeEventApi
            gateway.v1.OperativeEventRequestOuterClass$OperativeEventType r5 = gateway.v1.OperativeEventRequestOuterClass.OperativeEventType.OPERATIVE_EVENT_TYPE_LOAD_ERROR
            com.google.protobuf.ByteString r6 = r17.getTrackingToken()
            java.lang.String r7 = "response.trackingToken"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)
            com.google.protobuf.ByteString r7 = r1.toByteString()
            java.lang.String r1 = "operativeEventErrorData.toByteString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r1)
            r8 = 0
            r10 = 16
            r11 = 0
            r1 = r18
            r2.L$0 = r1
            r2.label = r4
            r4 = r5
            r5 = r16
            r9 = r2
            java.lang.Object r3 = com.unity3d.ads.core.domain.events.GetOperativeEventApi.invoke$default(r3, r4, r5, r6, r7, r8, r9, r10, r11)
            if (r3 != r12) goto L_0x0093
            return r12
        L_0x0093:
            if (r1 == 0) goto L_0x00a4
            r3 = 0
            r2.L$0 = r3
            r2.label = r13
            java.lang.Object r1 = r1.destroy(r2)
            if (r1 != r12) goto L_0x00a1
            return r12
        L_0x00a1:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        L_0x00a4:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.HandleGatewayAndroidAdResponse.cleanup(java.lang.Throwable, com.google.protobuf.ByteString, gateway.v1.AdResponseOuterClass$AdResponse, com.unity3d.ads.adplayer.AndroidFullscreenWebViewAdPlayer, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
