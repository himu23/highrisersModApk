package com.unity3d.ads.core.domain;

import com.unity3d.ads.core.data.manager.SDKPropertiesManager;
import com.unity3d.ads.core.data.manager.StorageManager;
import com.unity3d.ads.core.data.model.OperationType;
import com.unity3d.ads.core.data.model.UnityAdsNetworkException;
import com.unity3d.ads.core.data.repository.DeviceInfoRepository;
import com.unity3d.ads.core.data.repository.DiagnosticEventRepository;
import com.unity3d.ads.core.data.repository.SessionRepository;
import com.unity3d.ads.core.domain.events.EventObservers;
import com.unity3d.ads.gatewayclient.GatewayClient;
import gateway.v1.NativeConfigurationOuterClass;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.TimeoutCancellationException;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\b\u0000\u0018\u0000 /2\u00020\u0001:\u0001/Bm\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u0006\u0010\u001a\u001a\u00020\u001b¢\u0006\u0002\u0010\u001cJ\b\u0010\u001d\u001a\u00020\u001eH\u0002J \u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020!0 2\n\u0010\"\u001a\u00060#j\u0002`$H\u0002J%\u0010%\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020'2\n\u0010\"\u001a\u00060#j\u0002`$H@ø\u0001\u0000¢\u0006\u0002\u0010(J\u0011\u0010)\u001a\u00020\u001eH@ø\u0001\u0000¢\u0006\u0002\u0010*J\u0019\u0010+\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020'H@ø\u0001\u0000¢\u0006\u0002\u0010,J\u0011\u0010-\u001a\u00020\u001eHBø\u0001\u0000¢\u0006\u0002\u0010*J\b\u0010.\u001a\u00020\u001eH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u00060"}, d2 = {"Lcom/unity3d/ads/core/domain/InitializeAndroidBoldSDK;", "Lcom/unity3d/ads/core/domain/InitializeBoldSDK;", "defaultDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "getInitializeRequest", "Lcom/unity3d/ads/core/domain/GetInitializationRequest;", "getRequestPolicy", "Lcom/unity3d/ads/core/domain/GetRequestPolicy;", "handleGatewayInitializationResponse", "Lcom/unity3d/ads/core/domain/HandleGatewayInitializationResponse;", "gatewayClient", "Lcom/unity3d/ads/gatewayclient/GatewayClient;", "sessionRepository", "Lcom/unity3d/ads/core/data/repository/SessionRepository;", "eventObservers", "Lcom/unity3d/ads/core/domain/events/EventObservers;", "triggerInitializeListener", "Lcom/unity3d/ads/core/domain/TriggerInitializeListener;", "sendDiagnosticEvent", "Lcom/unity3d/ads/core/domain/SendDiagnosticEvent;", "diagnosticEventRepository", "Lcom/unity3d/ads/core/data/repository/DiagnosticEventRepository;", "deviceInfoRepository", "Lcom/unity3d/ads/core/data/repository/DeviceInfoRepository;", "storageManager", "Lcom/unity3d/ads/core/data/manager/StorageManager;", "sdkPropertiesManager", "Lcom/unity3d/ads/core/data/manager/SDKPropertiesManager;", "(Lkotlinx/coroutines/CoroutineDispatcher;Lcom/unity3d/ads/core/domain/GetInitializationRequest;Lcom/unity3d/ads/core/domain/GetRequestPolicy;Lcom/unity3d/ads/core/domain/HandleGatewayInitializationResponse;Lcom/unity3d/ads/gatewayclient/GatewayClient;Lcom/unity3d/ads/core/data/repository/SessionRepository;Lcom/unity3d/ads/core/domain/events/EventObservers;Lcom/unity3d/ads/core/domain/TriggerInitializeListener;Lcom/unity3d/ads/core/domain/SendDiagnosticEvent;Lcom/unity3d/ads/core/data/repository/DiagnosticEventRepository;Lcom/unity3d/ads/core/data/repository/DeviceInfoRepository;Lcom/unity3d/ads/core/data/manager/StorageManager;Lcom/unity3d/ads/core/data/manager/SDKPropertiesManager;)V", "checkCanInitialize", "", "getTags", "", "", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "initializationFailure", "startTime", "", "(JLjava/lang/Exception;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "initializationStart", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "initializationSuccess", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "invoke", "setupDiagnosticEvents", "Companion", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: InitializeAndroidBoldSDK.kt */
public final class InitializeAndroidBoldSDK implements InitializeBoldSDK {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String MSG_GATEWAY_DENIED = "Gateway communication failure";
    public static final String MSG_NO_INTERNET = "No internet connection";
    private final CoroutineDispatcher defaultDispatcher;
    private final DeviceInfoRepository deviceInfoRepository;
    private final DiagnosticEventRepository diagnosticEventRepository;
    private final EventObservers eventObservers;
    /* access modifiers changed from: private */
    public final GatewayClient gatewayClient;
    /* access modifiers changed from: private */
    public final GetInitializationRequest getInitializeRequest;
    /* access modifiers changed from: private */
    public final GetRequestPolicy getRequestPolicy;
    /* access modifiers changed from: private */
    public final HandleGatewayInitializationResponse handleGatewayInitializationResponse;
    private final SDKPropertiesManager sdkPropertiesManager;
    private final SendDiagnosticEvent sendDiagnosticEvent;
    private final SessionRepository sessionRepository;
    private final StorageManager storageManager;
    private final TriggerInitializeListener triggerInitializeListener;

    public InitializeAndroidBoldSDK(CoroutineDispatcher coroutineDispatcher, GetInitializationRequest getInitializationRequest, GetRequestPolicy getRequestPolicy2, HandleGatewayInitializationResponse handleGatewayInitializationResponse2, GatewayClient gatewayClient2, SessionRepository sessionRepository2, EventObservers eventObservers2, TriggerInitializeListener triggerInitializeListener2, SendDiagnosticEvent sendDiagnosticEvent2, DiagnosticEventRepository diagnosticEventRepository2, DeviceInfoRepository deviceInfoRepository2, StorageManager storageManager2, SDKPropertiesManager sDKPropertiesManager) {
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "defaultDispatcher");
        Intrinsics.checkNotNullParameter(getInitializationRequest, "getInitializeRequest");
        Intrinsics.checkNotNullParameter(getRequestPolicy2, "getRequestPolicy");
        Intrinsics.checkNotNullParameter(handleGatewayInitializationResponse2, "handleGatewayInitializationResponse");
        Intrinsics.checkNotNullParameter(gatewayClient2, "gatewayClient");
        Intrinsics.checkNotNullParameter(sessionRepository2, "sessionRepository");
        Intrinsics.checkNotNullParameter(eventObservers2, "eventObservers");
        Intrinsics.checkNotNullParameter(triggerInitializeListener2, "triggerInitializeListener");
        Intrinsics.checkNotNullParameter(sendDiagnosticEvent2, "sendDiagnosticEvent");
        Intrinsics.checkNotNullParameter(diagnosticEventRepository2, "diagnosticEventRepository");
        Intrinsics.checkNotNullParameter(deviceInfoRepository2, "deviceInfoRepository");
        Intrinsics.checkNotNullParameter(storageManager2, "storageManager");
        Intrinsics.checkNotNullParameter(sDKPropertiesManager, "sdkPropertiesManager");
        this.defaultDispatcher = coroutineDispatcher;
        this.getInitializeRequest = getInitializationRequest;
        this.getRequestPolicy = getRequestPolicy2;
        this.handleGatewayInitializationResponse = handleGatewayInitializationResponse2;
        this.gatewayClient = gatewayClient2;
        this.sessionRepository = sessionRepository2;
        this.eventObservers = eventObservers2;
        this.triggerInitializeListener = triggerInitializeListener2;
        this.sendDiagnosticEvent = sendDiagnosticEvent2;
        this.diagnosticEventRepository = diagnosticEventRepository2;
        this.deviceInfoRepository = deviceInfoRepository2;
        this.storageManager = storageManager2;
        this.sdkPropertiesManager = sDKPropertiesManager;
    }

    public Object invoke(Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(this.defaultDispatcher, new InitializeAndroidBoldSDK$invoke$2(this, (Continuation<? super InitializeAndroidBoldSDK$invoke$2>) null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public final void checkCanInitialize() {
        if (!this.sessionRepository.getShouldInitialize()) {
            throw new IllegalStateException(MSG_GATEWAY_DENIED.toString());
        } else if (!this.deviceInfoRepository.getHasInternet()) {
            throw new IllegalStateException(MSG_NO_INTERNET.toString());
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0071 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object initializationStart(kotlin.coroutines.Continuation<? super kotlin.Unit> r12) {
        /*
            r11 = this;
            boolean r0 = r12 instanceof com.unity3d.ads.core.domain.InitializeAndroidBoldSDK$initializationStart$1
            if (r0 == 0) goto L_0x0014
            r0 = r12
            com.unity3d.ads.core.domain.InitializeAndroidBoldSDK$initializationStart$1 r0 = (com.unity3d.ads.core.domain.InitializeAndroidBoldSDK$initializationStart$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r12 = r0.label
            int r12 = r12 - r2
            r0.label = r12
            goto L_0x0019
        L_0x0014:
            com.unity3d.ads.core.domain.InitializeAndroidBoldSDK$initializationStart$1 r0 = new com.unity3d.ads.core.domain.InitializeAndroidBoldSDK$initializationStart$1
            r0.<init>(r11, r12)
        L_0x0019:
            java.lang.Object r12 = r0.result
            java.lang.Object r9 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r0.label
            r10 = 2
            r2 = 1
            if (r1 == 0) goto L_0x003d
            if (r1 == r2) goto L_0x0035
            if (r1 != r10) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x0072
        L_0x002d:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L_0x0035:
            java.lang.Object r1 = r0.L$0
            com.unity3d.ads.core.domain.InitializeAndroidBoldSDK r1 = (com.unity3d.ads.core.domain.InitializeAndroidBoldSDK) r1
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x005d
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r12)
            java.lang.String r12 = "Unity Ads Initialization Start"
            com.unity3d.services.core.log.DeviceLog.debug(r12)
            com.unity3d.ads.core.domain.SendDiagnosticEvent r1 = r11.sendDiagnosticEvent
            java.lang.String r12 = "native_initialization_started"
            r3 = 0
            r4 = 0
            r5 = 0
            r7 = 14
            r8 = 0
            r0.L$0 = r11
            r0.label = r2
            r2 = r12
            r6 = r0
            java.lang.Object r12 = com.unity3d.ads.core.domain.SendDiagnosticEvent.DefaultImpls.invoke$default(r1, r2, r3, r4, r5, r6, r7, r8)
            if (r12 != r9) goto L_0x005c
            return r9
        L_0x005c:
            r1 = r11
        L_0x005d:
            com.unity3d.ads.core.data.repository.SessionRepository r12 = r1.sessionRepository
            com.unity3d.ads.core.data.model.InitializationState r2 = com.unity3d.ads.core.data.model.InitializationState.INITIALIZING
            r12.setInitializationState(r2)
            com.unity3d.ads.core.domain.events.EventObservers r12 = r1.eventObservers
            r1 = 0
            r0.L$0 = r1
            r0.label = r10
            java.lang.Object r12 = r12.invoke(r0)
            if (r12 != r9) goto L_0x0072
            return r9
        L_0x0072:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.InitializeAndroidBoldSDK.initializationStart(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object initializationSuccess(long r11, kotlin.coroutines.Continuation<? super kotlin.Unit> r13) {
        /*
            r10 = this;
            boolean r0 = r13 instanceof com.unity3d.ads.core.domain.InitializeAndroidBoldSDK$initializationSuccess$1
            if (r0 == 0) goto L_0x0014
            r0 = r13
            com.unity3d.ads.core.domain.InitializeAndroidBoldSDK$initializationSuccess$1 r0 = (com.unity3d.ads.core.domain.InitializeAndroidBoldSDK$initializationSuccess$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r13 = r0.label
            int r13 = r13 - r2
            r0.label = r13
            goto L_0x0019
        L_0x0014:
            com.unity3d.ads.core.domain.InitializeAndroidBoldSDK$initializationSuccess$1 r0 = new com.unity3d.ads.core.domain.InitializeAndroidBoldSDK$initializationSuccess$1
            r0.<init>(r10, r13)
        L_0x0019:
            r6 = r0
            java.lang.Object r13 = r6.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r9 = 1
            if (r1 == 0) goto L_0x0037
            if (r1 != r9) goto L_0x002f
            java.lang.Object r11 = r6.L$0
            com.unity3d.ads.core.domain.InitializeAndroidBoldSDK r11 = (com.unity3d.ads.core.domain.InitializeAndroidBoldSDK) r11
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x005c
        L_0x002f:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r13)
            java.lang.String r13 = "Unity Ads Initialization Success"
            com.unity3d.services.core.log.DeviceLog.debug(r13)
            com.unity3d.ads.core.domain.SendDiagnosticEvent r1 = r10.sendDiagnosticEvent
            java.lang.String r2 = "native_initialize_task_success_time"
            long r11 = com.unity3d.ads.core.extensions.TimestampExtensionsKt.duration(r11)
            java.lang.Long r3 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r11)
            r4 = 0
            r5 = 0
            r7 = 12
            r8 = 0
            r6.L$0 = r10
            r6.label = r9
            java.lang.Object r11 = com.unity3d.ads.core.domain.SendDiagnosticEvent.DefaultImpls.invoke$default(r1, r2, r3, r4, r5, r6, r7, r8)
            if (r11 != r0) goto L_0x005b
            return r0
        L_0x005b:
            r11 = r10
        L_0x005c:
            com.unity3d.ads.core.data.manager.StorageManager r12 = r11.storageManager
            r12.hasInitialized()
            com.unity3d.ads.core.domain.TriggerInitializeListener r12 = r11.triggerInitializeListener
            r12.success()
            com.unity3d.ads.core.data.repository.SessionRepository r12 = r11.sessionRepository
            com.unity3d.ads.core.data.model.InitializationState r13 = com.unity3d.ads.core.data.model.InitializationState.INITIALIZED_SUCCESSFULLY
            r12.setInitializationState(r13)
            com.unity3d.ads.core.data.manager.SDKPropertiesManager r12 = r11.sdkPropertiesManager
            r12.setInitialized(r9)
            r11.setupDiagnosticEvents()
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.InitializeAndroidBoldSDK.initializationSuccess(long, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v5, resolved type: java.lang.Exception} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object initializationFailure(long r10, java.lang.Exception r12, kotlin.coroutines.Continuation<? super kotlin.Unit> r13) {
        /*
            r9 = this;
            boolean r0 = r13 instanceof com.unity3d.ads.core.domain.InitializeAndroidBoldSDK$initializationFailure$1
            if (r0 == 0) goto L_0x0014
            r0 = r13
            com.unity3d.ads.core.domain.InitializeAndroidBoldSDK$initializationFailure$1 r0 = (com.unity3d.ads.core.domain.InitializeAndroidBoldSDK$initializationFailure$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r13 = r0.label
            int r13 = r13 - r2
            r0.label = r13
            goto L_0x0019
        L_0x0014:
            com.unity3d.ads.core.domain.InitializeAndroidBoldSDK$initializationFailure$1 r0 = new com.unity3d.ads.core.domain.InitializeAndroidBoldSDK$initializationFailure$1
            r0.<init>(r9, r13)
        L_0x0019:
            r6 = r0
            java.lang.Object r13 = r6.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 1
            if (r1 == 0) goto L_0x003c
            if (r1 != r2) goto L_0x0034
            java.lang.Object r10 = r6.L$1
            r12 = r10
            java.lang.Exception r12 = (java.lang.Exception) r12
            java.lang.Object r10 = r6.L$0
            com.unity3d.ads.core.domain.InitializeAndroidBoldSDK r10 = (com.unity3d.ads.core.domain.InitializeAndroidBoldSDK) r10
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x0077
        L_0x0034:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x003c:
            kotlin.ResultKt.throwOnFailure(r13)
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            java.lang.String r1 = "Unity Ads Initialization Failure: "
            r13.<init>(r1)
            java.lang.String r1 = r12.getMessage()
            r13.append(r1)
            java.lang.String r13 = r13.toString()
            com.unity3d.services.core.log.DeviceLog.debug(r13)
            com.unity3d.ads.core.domain.SendDiagnosticEvent r1 = r9.sendDiagnosticEvent
            java.lang.String r13 = "native_initialize_task_failure_time"
            long r10 = com.unity3d.ads.core.extensions.TimestampExtensionsKt.duration(r10)
            java.lang.Long r3 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r10)
            java.util.Map r4 = r9.getTags(r12)
            r5 = 0
            r7 = 8
            r8 = 0
            r6.L$0 = r9
            r6.L$1 = r12
            r6.label = r2
            r2 = r13
            java.lang.Object r10 = com.unity3d.ads.core.domain.SendDiagnosticEvent.DefaultImpls.invoke$default(r1, r2, r3, r4, r5, r6, r7, r8)
            if (r10 != r0) goto L_0x0076
            return r0
        L_0x0076:
            r10 = r9
        L_0x0077:
            com.unity3d.ads.core.domain.TriggerInitializeListener r11 = r10.triggerInitializeListener
            com.unity3d.ads.UnityAds$UnityAdsInitializationError r13 = com.unity3d.ads.UnityAds.UnityAdsInitializationError.INTERNAL_ERROR
            java.lang.String r12 = r12.getMessage()
            java.lang.String r12 = com.unity3d.services.core.extensions.StringExtensionsKt.toUnityMessage(r12)
            r11.error(r13, r12)
            com.unity3d.ads.core.data.repository.SessionRepository r11 = r10.sessionRepository
            com.unity3d.ads.core.data.model.InitializationState r12 = com.unity3d.ads.core.data.model.InitializationState.INITIALIZED_FAILED
            r11.setInitializationState(r12)
            com.unity3d.ads.core.data.manager.SDKPropertiesManager r10 = r10.sdkPropertiesManager
            r11 = 0
            r10.setInitialized(r11)
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.InitializeAndroidBoldSDK.initializationFailure(long, java.lang.Exception, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final Map<String, String> getTags(Exception exc) {
        Map<String, String> mutableMapOf = MapsKt.mutableMapOf(TuplesKt.to("operation", OperationType.INITIALIZATION.toString()), TuplesKt.to("reason", "unknown"));
        if (exc instanceof TimeoutCancellationException) {
            mutableMapOf.put("reason", "timeout");
        } else if (exc instanceof UnityAdsNetworkException) {
            mutableMapOf.put("reason", "network");
        }
        String message = exc.getMessage();
        if (Intrinsics.areEqual((Object) message, (Object) MSG_NO_INTERNET)) {
            mutableMapOf.put("reason", "network");
        } else if (Intrinsics.areEqual((Object) message, (Object) MSG_GATEWAY_DENIED)) {
            mutableMapOf.put("reason", "gateway");
        }
        return mutableMapOf;
    }

    private final void setupDiagnosticEvents() {
        NativeConfigurationOuterClass.DiagnosticEventsConfiguration diagnosticEvents = this.sessionRepository.getNativeConfiguration().getDiagnosticEvents();
        DiagnosticEventRepository diagnosticEventRepository2 = this.diagnosticEventRepository;
        Intrinsics.checkNotNullExpressionValue(diagnosticEvents, "config");
        diagnosticEventRepository2.configure(diagnosticEvents);
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/unity3d/ads/core/domain/InitializeAndroidBoldSDK$Companion;", "", "()V", "MSG_GATEWAY_DENIED", "", "MSG_NO_INTERNET", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: InitializeAndroidBoldSDK.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
