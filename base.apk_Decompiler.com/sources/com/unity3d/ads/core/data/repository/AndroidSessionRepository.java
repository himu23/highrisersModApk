package com.unity3d.ads.core.data.repository;

import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import com.ironsource.m2;
import com.unity3d.ads.core.data.datasource.ByteStringDataSource;
import com.unity3d.ads.core.data.model.InitializationState;
import com.unity3d.ads.core.data.model.SessionChange;
import com.unity3d.ads.core.extensions.ProtobufExtensionsKt;
import com.unity3d.services.UnityAdsConstants;
import com.unity3d.services.core.properties.ClientProperties;
import com.unity3d.services.core.properties.SdkProperties;
import gateway.v1.NativeConfigurationOuterClass;
import gateway.v1.SessionCountersKt;
import gateway.v1.SessionCountersOuterClass;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0011\u0010O\u001a\u00020\u000bH@ø\u0001\u0000¢\u0006\u0002\u0010PJ\u0011\u0010Q\u001a\u00020\u000bH@ø\u0001\u0000¢\u0006\u0002\u0010PJ\u0011\u0010R\u001a\u00020\u000bH@ø\u0001\u0000¢\u0006\u0002\u0010PJ\b\u0010S\u001a\u00020TH\u0016J\b\u0010U\u001a\u00020TH\u0016J\u0019\u0010V\u001a\u00020T2\u0006\u0010!\u001a\u00020\u000bH@ø\u0001\u0000¢\u0006\u0002\u0010WJ\u0019\u0010X\u001a\u00020T2\u0006\u0010!\u001a\u00020\u000bH@ø\u0001\u0000¢\u0006\u0002\u0010WJ\u0019\u0010Y\u001a\u00020T2\u0006\u0010!\u001a\u00020\u000bH@ø\u0001\u0000¢\u0006\u0002\u0010WR\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0010\u0012\f\u0012\n \u000e*\u0004\u0018\u00010\r0\r0\nX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\nX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\nX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\nX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00070\nX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\nX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00130\nX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\u00020\u001e8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u000e\u0010\u0005\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R4\u0010\"\u001a\n \u000e*\u0004\u0018\u00010\r0\r2\u000e\u0010!\u001a\n \u000e*\u0004\u0018\u00010\r0\r8V@VX\u000e¢\u0006\f\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R$\u0010'\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u000b8V@VX\u000e¢\u0006\f\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R$\u0010,\u001a\u00020\r2\u0006\u0010!\u001a\u00020\r8V@VX\u000e¢\u0006\f\u001a\u0004\b-\u0010$\"\u0004\b.\u0010&R$\u0010/\u001a\u00020\u00112\u0006\u0010!\u001a\u00020\u00118V@VX\u000e¢\u0006\f\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u0014\u00104\u001a\u00020\u00138VX\u0004¢\u0006\u0006\u001a\u0004\b4\u00105R\u0014\u00106\u001a\u00020\u00138VX\u0004¢\u0006\u0006\u001a\u0004\b6\u00105R\u0014\u00107\u001a\u00020\u00138VX\u0004¢\u0006\u0006\u001a\u0004\b7\u00105R$\u00108\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u00078V@VX\u000e¢\u0006\f\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u001a\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00160>X\u0004¢\u0006\b\n\u0000\u001a\u0004\b?\u0010@R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R$\u0010A\u001a\u00020\u00192\u0006\u0010!\u001a\u00020\u00198V@VX\u000e¢\u0006\f\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u0014\u0010F\u001a\u00020\u000b8VX\u0004¢\u0006\u0006\u001a\u0004\bG\u0010)R$\u0010H\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u000b8V@VX\u000e¢\u0006\f\u001a\u0004\bI\u0010)\"\u0004\bJ\u0010+R$\u0010K\u001a\u00020\u00132\u0006\u0010!\u001a\u00020\u00138V@VX\u000e¢\u0006\f\u001a\u0004\bL\u00105\"\u0004\bM\u0010N\u0002\u0004\n\u0002\b\u0019¨\u0006Z"}, d2 = {"Lcom/unity3d/ads/core/data/repository/AndroidSessionRepository;", "Lcom/unity3d/ads/core/data/repository/SessionRepository;", "gatewayCacheDataSource", "Lcom/unity3d/ads/core/data/datasource/ByteStringDataSource;", "privacyDataSource", "fsmDataSource", "defaultNativeConfiguration", "Lgateway/v1/NativeConfigurationOuterClass$NativeConfiguration;", "(Lcom/unity3d/ads/core/data/datasource/ByteStringDataSource;Lcom/unity3d/ads/core/data/datasource/ByteStringDataSource;Lcom/unity3d/ads/core/data/datasource/ByteStringDataSource;Lgateway/v1/NativeConfigurationOuterClass$NativeConfiguration;)V", "_currentState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/google/protobuf/ByteString;", "_gameId", "", "kotlin.jvm.PlatformType", "_gatewayUrl", "_initializationState", "Lcom/unity3d/ads/core/data/model/InitializationState;", "_isTestModeEnabled", "", "_onChange", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/unity3d/ads/core/data/model/SessionChange;", "_sdkConfiguration", "_sessionCounters", "Lgateway/v1/SessionCountersOuterClass$SessionCounters;", "_sessionId", "_sessionToken", "_shouldInitialize", "featureFlags", "Lgateway/v1/NativeConfigurationOuterClass$FeatureFlags;", "getFeatureFlags", "()Lgateway/v1/NativeConfigurationOuterClass$FeatureFlags;", "value", "gameId", "getGameId", "()Ljava/lang/String;", "setGameId", "(Ljava/lang/String;)V", "gatewayState", "getGatewayState", "()Lcom/google/protobuf/ByteString;", "setGatewayState", "(Lcom/google/protobuf/ByteString;)V", "gatewayUrl", "getGatewayUrl", "setGatewayUrl", "initializationState", "getInitializationState", "()Lcom/unity3d/ads/core/data/model/InitializationState;", "setInitializationState", "(Lcom/unity3d/ads/core/data/model/InitializationState;)V", "isDiagnosticsEnabled", "()Z", "isSdkInitialized", "isTestModeEnabled", "nativeConfiguration", "getNativeConfiguration", "()Lgateway/v1/NativeConfigurationOuterClass$NativeConfiguration;", "setNativeConfiguration", "(Lgateway/v1/NativeConfigurationOuterClass$NativeConfiguration;)V", "onChange", "Lkotlinx/coroutines/flow/SharedFlow;", "getOnChange", "()Lkotlinx/coroutines/flow/SharedFlow;", "sessionCounters", "getSessionCounters", "()Lgateway/v1/SessionCountersOuterClass$SessionCounters;", "setSessionCounters", "(Lgateway/v1/SessionCountersOuterClass$SessionCounters;)V", "sessionId", "getSessionId", "sessionToken", "getSessionToken", "setSessionToken", "shouldInitialize", "getShouldInitialize", "setShouldInitialize", "(Z)V", "getGatewayCache", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPrivacy", "getPrivacyFsm", "incrementLoadRequestAdmCount", "", "incrementLoadRequestCount", "setGatewayCache", "(Lcom/google/protobuf/ByteString;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setPrivacy", "setPrivacyFsm", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidSessionRepository.kt */
public final class AndroidSessionRepository implements SessionRepository {
    private final MutableStateFlow<ByteString> _currentState;
    private MutableStateFlow<String> _gameId = StateFlowKt.MutableStateFlow(ClientProperties.getGameId());
    private final MutableStateFlow<String> _gatewayUrl;
    private final MutableStateFlow<InitializationState> _initializationState;
    private final MutableStateFlow<Boolean> _isTestModeEnabled;
    private MutableSharedFlow<SessionChange> _onChange;
    private final MutableStateFlow<NativeConfigurationOuterClass.NativeConfiguration> _sdkConfiguration;
    private final MutableStateFlow<SessionCountersOuterClass.SessionCounters> _sessionCounters;
    private final MutableStateFlow<ByteString> _sessionId;
    private final MutableStateFlow<ByteString> _sessionToken;
    private final MutableStateFlow<Boolean> _shouldInitialize;
    private final ByteStringDataSource fsmDataSource;
    private final ByteStringDataSource gatewayCacheDataSource;
    private final SharedFlow<SessionChange> onChange;
    private final ByteStringDataSource privacyDataSource;

    public SharedFlow<SessionChange> getOnChange() {
        return this.onChange;
    }

    public AndroidSessionRepository(ByteStringDataSource byteStringDataSource, ByteStringDataSource byteStringDataSource2, ByteStringDataSource byteStringDataSource3, NativeConfigurationOuterClass.NativeConfiguration nativeConfiguration) {
        Intrinsics.checkNotNullParameter(byteStringDataSource, "gatewayCacheDataSource");
        Intrinsics.checkNotNullParameter(byteStringDataSource2, "privacyDataSource");
        Intrinsics.checkNotNullParameter(byteStringDataSource3, "fsmDataSource");
        Intrinsics.checkNotNullParameter(nativeConfiguration, "defaultNativeConfiguration");
        this.gatewayCacheDataSource = byteStringDataSource;
        this.privacyDataSource = byteStringDataSource2;
        this.fsmDataSource = byteStringDataSource3;
        MutableSharedFlow<SessionChange> MutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(0, 0, (BufferOverflow) null, 7, (Object) null);
        this._onChange = MutableSharedFlow$default;
        this.onChange = FlowKt.asSharedFlow(MutableSharedFlow$default);
        UUID randomUUID = UUID.randomUUID();
        Intrinsics.checkNotNullExpressionValue(randomUUID, "randomUUID()");
        this._sessionId = StateFlowKt.MutableStateFlow(ProtobufExtensionsKt.toByteString(randomUUID));
        this._isTestModeEnabled = StateFlowKt.MutableStateFlow(Boolean.valueOf(SdkProperties.isTestMode()));
        GeneratedMessageLite build = SessionCountersOuterClass.SessionCounters.newBuilder().build();
        Intrinsics.checkNotNullExpressionValue(build, "newBuilder().build()");
        this._sessionCounters = StateFlowKt.MutableStateFlow(build);
        ByteString byteString = ByteString.EMPTY;
        Intrinsics.checkNotNullExpressionValue(byteString, "EMPTY");
        this._sessionToken = StateFlowKt.MutableStateFlow(byteString);
        ByteString byteString2 = ByteString.EMPTY;
        Intrinsics.checkNotNullExpressionValue(byteString2, "EMPTY");
        this._currentState = StateFlowKt.MutableStateFlow(byteString2);
        this._sdkConfiguration = StateFlowKt.MutableStateFlow(nativeConfiguration);
        this._gatewayUrl = StateFlowKt.MutableStateFlow(UnityAdsConstants.DefaultUrls.GATEWAY_URL);
        this._initializationState = StateFlowKt.MutableStateFlow(InitializationState.NOT_INITIALIZED);
        this._shouldInitialize = StateFlowKt.MutableStateFlow(true);
    }

    public ByteString getSessionId() {
        return this._sessionId.getValue();
    }

    public SessionCountersOuterClass.SessionCounters getSessionCounters() {
        return this._sessionCounters.getValue();
    }

    public ByteString getSessionToken() {
        return this._sessionToken.getValue();
    }

    public ByteString getGatewayState() {
        return this._currentState.getValue();
    }

    public NativeConfigurationOuterClass.NativeConfiguration getNativeConfiguration() {
        return this._sdkConfiguration.getValue();
    }

    public String getGatewayUrl() {
        return this._gatewayUrl.getValue();
    }

    public InitializationState getInitializationState() {
        return this._initializationState.getValue();
    }

    public boolean isSdkInitialized() {
        return getInitializationState() == InitializationState.INITIALIZED_SUCCESSFULLY;
    }

    public boolean isDiagnosticsEnabled() {
        return getNativeConfiguration().getDiagnosticEvents().getEnabled();
    }

    public NativeConfigurationOuterClass.FeatureFlags getFeatureFlags() {
        NativeConfigurationOuterClass.FeatureFlags featureFlags = getNativeConfiguration().getFeatureFlags();
        Intrinsics.checkNotNullExpressionValue(featureFlags, "nativeConfiguration.featureFlags");
        return featureFlags;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object getGatewayCache(kotlin.coroutines.Continuation<? super com.google.protobuf.ByteString> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.unity3d.ads.core.data.repository.AndroidSessionRepository$getGatewayCache$1
            if (r0 == 0) goto L_0x0014
            r0 = r5
            com.unity3d.ads.core.data.repository.AndroidSessionRepository$getGatewayCache$1 r0 = (com.unity3d.ads.core.data.repository.AndroidSessionRepository$getGatewayCache$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r5 = r0.label
            int r5 = r5 - r2
            r0.label = r5
            goto L_0x0019
        L_0x0014:
            com.unity3d.ads.core.data.repository.AndroidSessionRepository$getGatewayCache$1 r0 = new com.unity3d.ads.core.data.repository.AndroidSessionRepository$getGatewayCache$1
            r0.<init>(r4, r5)
        L_0x0019:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x0040
        L_0x002a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r5)
            com.unity3d.ads.core.data.datasource.ByteStringDataSource r5 = r4.gatewayCacheDataSource
            r0.label = r3
            java.lang.Object r5 = r5.get(r0)
            if (r5 != r1) goto L_0x0040
            return r1
        L_0x0040:
            ByteStringStoreOuterClass$ByteStringStore r5 = (defpackage.ByteStringStoreOuterClass.ByteStringStore) r5
            com.google.protobuf.ByteString r5 = r5.getData()
            java.lang.String r0 = "gatewayCacheDataSource.get().data"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r0)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.data.repository.AndroidSessionRepository.getGatewayCache(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public Object setGatewayCache(ByteString byteString, Continuation<? super Unit> continuation) {
        Object obj = this.gatewayCacheDataSource.set(byteString, continuation);
        return obj == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? obj : Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object getPrivacy(kotlin.coroutines.Continuation<? super com.google.protobuf.ByteString> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.unity3d.ads.core.data.repository.AndroidSessionRepository$getPrivacy$1
            if (r0 == 0) goto L_0x0014
            r0 = r5
            com.unity3d.ads.core.data.repository.AndroidSessionRepository$getPrivacy$1 r0 = (com.unity3d.ads.core.data.repository.AndroidSessionRepository$getPrivacy$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r5 = r0.label
            int r5 = r5 - r2
            r0.label = r5
            goto L_0x0019
        L_0x0014:
            com.unity3d.ads.core.data.repository.AndroidSessionRepository$getPrivacy$1 r0 = new com.unity3d.ads.core.data.repository.AndroidSessionRepository$getPrivacy$1
            r0.<init>(r4, r5)
        L_0x0019:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x0040
        L_0x002a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r5)
            com.unity3d.ads.core.data.datasource.ByteStringDataSource r5 = r4.privacyDataSource
            r0.label = r3
            java.lang.Object r5 = r5.get(r0)
            if (r5 != r1) goto L_0x0040
            return r1
        L_0x0040:
            ByteStringStoreOuterClass$ByteStringStore r5 = (defpackage.ByteStringStoreOuterClass.ByteStringStore) r5
            com.google.protobuf.ByteString r5 = r5.getData()
            java.lang.String r0 = "privacyDataSource.get().data"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r0)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.data.repository.AndroidSessionRepository.getPrivacy(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0068 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object setPrivacy(com.google.protobuf.ByteString r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.unity3d.ads.core.data.repository.AndroidSessionRepository$setPrivacy$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            com.unity3d.ads.core.data.repository.AndroidSessionRepository$setPrivacy$1 r0 = (com.unity3d.ads.core.data.repository.AndroidSessionRepository$setPrivacy$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            com.unity3d.ads.core.data.repository.AndroidSessionRepository$setPrivacy$1 r0 = new com.unity3d.ads.core.data.repository.AndroidSessionRepository$setPrivacy$1
            r0.<init>(r5, r7)
        L_0x0019:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0041
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0069
        L_0x002d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0035:
            java.lang.Object r6 = r0.L$1
            com.google.protobuf.ByteString r6 = (com.google.protobuf.ByteString) r6
            java.lang.Object r2 = r0.L$0
            com.unity3d.ads.core.data.repository.AndroidSessionRepository r2 = (com.unity3d.ads.core.data.repository.AndroidSessionRepository) r2
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0054
        L_0x0041:
            kotlin.ResultKt.throwOnFailure(r7)
            com.unity3d.ads.core.data.datasource.ByteStringDataSource r7 = r5.privacyDataSource
            r0.L$0 = r5
            r0.L$1 = r6
            r0.label = r4
            java.lang.Object r7 = r7.set(r6, r0)
            if (r7 != r1) goto L_0x0053
            return r1
        L_0x0053:
            r2 = r5
        L_0x0054:
            kotlinx.coroutines.flow.MutableSharedFlow<com.unity3d.ads.core.data.model.SessionChange> r7 = r2._onChange
            com.unity3d.ads.core.data.model.SessionChange$UserConsentChange r2 = new com.unity3d.ads.core.data.model.SessionChange$UserConsentChange
            r2.<init>(r6)
            r6 = 0
            r0.L$0 = r6
            r0.L$1 = r6
            r0.label = r3
            java.lang.Object r6 = r7.emit(r2, r0)
            if (r6 != r1) goto L_0x0069
            return r1
        L_0x0069:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.data.repository.AndroidSessionRepository.setPrivacy(com.google.protobuf.ByteString, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object getPrivacyFsm(kotlin.coroutines.Continuation<? super com.google.protobuf.ByteString> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.unity3d.ads.core.data.repository.AndroidSessionRepository$getPrivacyFsm$1
            if (r0 == 0) goto L_0x0014
            r0 = r5
            com.unity3d.ads.core.data.repository.AndroidSessionRepository$getPrivacyFsm$1 r0 = (com.unity3d.ads.core.data.repository.AndroidSessionRepository$getPrivacyFsm$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r5 = r0.label
            int r5 = r5 - r2
            r0.label = r5
            goto L_0x0019
        L_0x0014:
            com.unity3d.ads.core.data.repository.AndroidSessionRepository$getPrivacyFsm$1 r0 = new com.unity3d.ads.core.data.repository.AndroidSessionRepository$getPrivacyFsm$1
            r0.<init>(r4, r5)
        L_0x0019:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x0040
        L_0x002a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r5)
            com.unity3d.ads.core.data.datasource.ByteStringDataSource r5 = r4.fsmDataSource
            r0.label = r3
            java.lang.Object r5 = r5.get(r0)
            if (r5 != r1) goto L_0x0040
            return r1
        L_0x0040:
            ByteStringStoreOuterClass$ByteStringStore r5 = (defpackage.ByteStringStoreOuterClass.ByteStringStore) r5
            com.google.protobuf.ByteString r5 = r5.getData()
            java.lang.String r0 = "fsmDataSource.get().data"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r0)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.data.repository.AndroidSessionRepository.getPrivacyFsm(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0068 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object setPrivacyFsm(com.google.protobuf.ByteString r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.unity3d.ads.core.data.repository.AndroidSessionRepository$setPrivacyFsm$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            com.unity3d.ads.core.data.repository.AndroidSessionRepository$setPrivacyFsm$1 r0 = (com.unity3d.ads.core.data.repository.AndroidSessionRepository$setPrivacyFsm$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            com.unity3d.ads.core.data.repository.AndroidSessionRepository$setPrivacyFsm$1 r0 = new com.unity3d.ads.core.data.repository.AndroidSessionRepository$setPrivacyFsm$1
            r0.<init>(r5, r7)
        L_0x0019:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0041
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0069
        L_0x002d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0035:
            java.lang.Object r6 = r0.L$1
            com.google.protobuf.ByteString r6 = (com.google.protobuf.ByteString) r6
            java.lang.Object r2 = r0.L$0
            com.unity3d.ads.core.data.repository.AndroidSessionRepository r2 = (com.unity3d.ads.core.data.repository.AndroidSessionRepository) r2
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0054
        L_0x0041:
            kotlin.ResultKt.throwOnFailure(r7)
            com.unity3d.ads.core.data.datasource.ByteStringDataSource r7 = r5.fsmDataSource
            r0.L$0 = r5
            r0.L$1 = r6
            r0.label = r4
            java.lang.Object r7 = r7.set(r6, r0)
            if (r7 != r1) goto L_0x0053
            return r1
        L_0x0053:
            r2 = r5
        L_0x0054:
            kotlinx.coroutines.flow.MutableSharedFlow<com.unity3d.ads.core.data.model.SessionChange> r7 = r2._onChange
            com.unity3d.ads.core.data.model.SessionChange$PrivacyFsmChange r2 = new com.unity3d.ads.core.data.model.SessionChange$PrivacyFsmChange
            r2.<init>(r6)
            r6 = 0
            r0.L$0 = r6
            r0.L$1 = r6
            r0.label = r3
            java.lang.Object r6 = r7.emit(r2, r0)
            if (r6 != r1) goto L_0x0069
            return r1
        L_0x0069:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.data.repository.AndroidSessionRepository.setPrivacyFsm(com.google.protobuf.ByteString, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public boolean getShouldInitialize() {
        return this._shouldInitialize.getValue().booleanValue();
    }

    public String getGameId() {
        String value;
        String gameId;
        MutableStateFlow<String> mutableStateFlow = this._gameId;
        do {
            value = mutableStateFlow.getValue();
            String str = value;
            gameId = ClientProperties.getGameId();
        } while (!mutableStateFlow.compareAndSet(value, gameId));
        return gameId;
    }

    public void setGameId(String str) {
        String value;
        MutableStateFlow<String> mutableStateFlow = this._gameId;
        do {
            value = mutableStateFlow.getValue();
            String str2 = value;
            ClientProperties.setGameId(str);
        } while (!mutableStateFlow.compareAndSet(value, str));
    }

    public boolean isTestModeEnabled() {
        Boolean value;
        Boolean valueOf;
        MutableStateFlow<Boolean> mutableStateFlow = this._isTestModeEnabled;
        do {
            value = mutableStateFlow.getValue();
            value.booleanValue();
            valueOf = Boolean.valueOf(SdkProperties.isTestMode());
        } while (!mutableStateFlow.compareAndSet(value, valueOf));
        return valueOf.booleanValue();
    }

    public void setSessionCounters(SessionCountersOuterClass.SessionCounters sessionCounters) {
        SessionCountersOuterClass.SessionCounters value;
        Intrinsics.checkNotNullParameter(sessionCounters, m2.h.X);
        MutableStateFlow<SessionCountersOuterClass.SessionCounters> mutableStateFlow = this._sessionCounters;
        do {
            value = mutableStateFlow.getValue();
            SessionCountersOuterClass.SessionCounters sessionCounters2 = value;
        } while (!mutableStateFlow.compareAndSet(value, sessionCounters));
    }

    public void incrementLoadRequestCount() {
        SessionCountersOuterClass.SessionCounters value;
        SessionCountersKt.Dsl _create;
        MutableStateFlow<SessionCountersOuterClass.SessionCounters> mutableStateFlow = this._sessionCounters;
        do {
            value = mutableStateFlow.getValue();
            SessionCountersKt.Dsl.Companion companion = SessionCountersKt.Dsl.Companion;
            GeneratedMessageLite.Builder builder = value.toBuilder();
            Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
            _create = companion._create((SessionCountersOuterClass.SessionCounters.Builder) builder);
            _create.setLoadRequests(_create.getLoadRequests() + 1);
        } while (!mutableStateFlow.compareAndSet(value, _create._build()));
    }

    public void incrementLoadRequestAdmCount() {
        SessionCountersOuterClass.SessionCounters value;
        SessionCountersKt.Dsl _create;
        MutableStateFlow<SessionCountersOuterClass.SessionCounters> mutableStateFlow = this._sessionCounters;
        do {
            value = mutableStateFlow.getValue();
            SessionCountersKt.Dsl.Companion companion = SessionCountersKt.Dsl.Companion;
            GeneratedMessageLite.Builder builder = value.toBuilder();
            Intrinsics.checkNotNullExpressionValue(builder, "this.toBuilder()");
            _create = companion._create((SessionCountersOuterClass.SessionCounters.Builder) builder);
            _create.setLoadRequestsAdm(_create.getLoadRequestsAdm() + 1);
        } while (!mutableStateFlow.compareAndSet(value, _create._build()));
    }

    public void setSessionToken(ByteString byteString) {
        ByteString value;
        Intrinsics.checkNotNullParameter(byteString, m2.h.X);
        MutableStateFlow<ByteString> mutableStateFlow = this._sessionToken;
        do {
            value = mutableStateFlow.getValue();
            ByteString byteString2 = value;
        } while (!mutableStateFlow.compareAndSet(value, byteString));
    }

    public void setGatewayState(ByteString byteString) {
        ByteString value;
        Intrinsics.checkNotNullParameter(byteString, m2.h.X);
        MutableStateFlow<ByteString> mutableStateFlow = this._currentState;
        do {
            value = mutableStateFlow.getValue();
            ByteString byteString2 = value;
        } while (!mutableStateFlow.compareAndSet(value, byteString));
    }

    public void setNativeConfiguration(NativeConfigurationOuterClass.NativeConfiguration nativeConfiguration) {
        NativeConfigurationOuterClass.NativeConfiguration value;
        Intrinsics.checkNotNullParameter(nativeConfiguration, m2.h.X);
        MutableStateFlow<NativeConfigurationOuterClass.NativeConfiguration> mutableStateFlow = this._sdkConfiguration;
        do {
            value = mutableStateFlow.getValue();
            NativeConfigurationOuterClass.NativeConfiguration nativeConfiguration2 = value;
        } while (!mutableStateFlow.compareAndSet(value, nativeConfiguration));
    }

    public void setGatewayUrl(String str) {
        String value;
        Intrinsics.checkNotNullParameter(str, m2.h.X);
        MutableStateFlow<String> mutableStateFlow = this._gatewayUrl;
        do {
            value = mutableStateFlow.getValue();
            String str2 = value;
        } while (!mutableStateFlow.compareAndSet(value, str));
    }

    public void setInitializationState(InitializationState initializationState) {
        InitializationState value;
        Intrinsics.checkNotNullParameter(initializationState, m2.h.X);
        MutableStateFlow<InitializationState> mutableStateFlow = this._initializationState;
        do {
            value = mutableStateFlow.getValue();
            InitializationState initializationState2 = value;
        } while (!mutableStateFlow.compareAndSet(value, initializationState));
    }

    public void setShouldInitialize(boolean z) {
        Boolean value;
        MutableStateFlow<Boolean> mutableStateFlow = this._shouldInitialize;
        do {
            value = mutableStateFlow.getValue();
            value.booleanValue();
        } while (!mutableStateFlow.compareAndSet(value, Boolean.valueOf(z)));
    }
}
