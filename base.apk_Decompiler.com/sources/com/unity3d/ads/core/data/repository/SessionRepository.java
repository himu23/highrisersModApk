package com.unity3d.ads.core.data.repository;

import com.google.protobuf.ByteString;
import com.unity3d.ads.core.data.model.InitializationState;
import com.unity3d.ads.core.data.model.SessionChange;
import gateway.v1.NativeConfigurationOuterClass;
import gateway.v1.SessionCountersOuterClass;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.SharedFlow;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u0011\u0010:\u001a\u00020\rH¦@ø\u0001\u0000¢\u0006\u0002\u0010;J\u0011\u0010<\u001a\u00020\rH¦@ø\u0001\u0000¢\u0006\u0002\u0010;J\u0011\u0010=\u001a\u00020\rH¦@ø\u0001\u0000¢\u0006\u0002\u0010;J\b\u0010>\u001a\u00020?H&J\b\u0010@\u001a\u00020?H&J\u0019\u0010A\u001a\u00020?2\u0006\u0010B\u001a\u00020\rH¦@ø\u0001\u0000¢\u0006\u0002\u0010CJ\u0019\u0010D\u001a\u00020?2\u0006\u0010B\u001a\u00020\rH¦@ø\u0001\u0000¢\u0006\u0002\u0010CJ\u0019\u0010E\u001a\u00020?2\u0006\u0010B\u001a\u00020\rH¦@ø\u0001\u0000¢\u0006\u0002\u0010CR\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0018\u0010\u0006\u001a\u00020\u0007X¦\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0018\u0010\f\u001a\u00020\rX¦\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0012\u001a\u00020\u0007X¦\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\t\"\u0004\b\u0014\u0010\u000bR\u0018\u0010\u0015\u001a\u00020\u0016X¦\u000e¢\u0006\f\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0012\u0010\u001b\u001a\u00020\u001cX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001dR\u0012\u0010\u001e\u001a\u00020\u001cX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001dR\u0012\u0010\u001f\u001a\u00020\u001cX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001dR\u0018\u0010 \u001a\u00020!X¦\u000e¢\u0006\f\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0018\u0010&\u001a\b\u0012\u0004\u0012\u00020(0'X¦\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*R\u0018\u0010+\u001a\u00020,X¦\u000e¢\u0006\f\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u0012\u00101\u001a\u00020\rX¦\u0004¢\u0006\u0006\u001a\u0004\b2\u0010\u000fR\u0018\u00103\u001a\u00020\rX¦\u000e¢\u0006\f\u001a\u0004\b4\u0010\u000f\"\u0004\b5\u0010\u0011R\u0018\u00106\u001a\u00020\u001cX¦\u000e¢\u0006\f\u001a\u0004\b7\u0010\u001d\"\u0004\b8\u00109\u0002\u0004\n\u0002\b\u0019¨\u0006F"}, d2 = {"Lcom/unity3d/ads/core/data/repository/SessionRepository;", "", "featureFlags", "Lgateway/v1/NativeConfigurationOuterClass$FeatureFlags;", "getFeatureFlags", "()Lgateway/v1/NativeConfigurationOuterClass$FeatureFlags;", "gameId", "", "getGameId", "()Ljava/lang/String;", "setGameId", "(Ljava/lang/String;)V", "gatewayState", "Lcom/google/protobuf/ByteString;", "getGatewayState", "()Lcom/google/protobuf/ByteString;", "setGatewayState", "(Lcom/google/protobuf/ByteString;)V", "gatewayUrl", "getGatewayUrl", "setGatewayUrl", "initializationState", "Lcom/unity3d/ads/core/data/model/InitializationState;", "getInitializationState", "()Lcom/unity3d/ads/core/data/model/InitializationState;", "setInitializationState", "(Lcom/unity3d/ads/core/data/model/InitializationState;)V", "isDiagnosticsEnabled", "", "()Z", "isSdkInitialized", "isTestModeEnabled", "nativeConfiguration", "Lgateway/v1/NativeConfigurationOuterClass$NativeConfiguration;", "getNativeConfiguration", "()Lgateway/v1/NativeConfigurationOuterClass$NativeConfiguration;", "setNativeConfiguration", "(Lgateway/v1/NativeConfigurationOuterClass$NativeConfiguration;)V", "onChange", "Lkotlinx/coroutines/flow/SharedFlow;", "Lcom/unity3d/ads/core/data/model/SessionChange;", "getOnChange", "()Lkotlinx/coroutines/flow/SharedFlow;", "sessionCounters", "Lgateway/v1/SessionCountersOuterClass$SessionCounters;", "getSessionCounters", "()Lgateway/v1/SessionCountersOuterClass$SessionCounters;", "setSessionCounters", "(Lgateway/v1/SessionCountersOuterClass$SessionCounters;)V", "sessionId", "getSessionId", "sessionToken", "getSessionToken", "setSessionToken", "shouldInitialize", "getShouldInitialize", "setShouldInitialize", "(Z)V", "getGatewayCache", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getPrivacy", "getPrivacyFsm", "incrementLoadRequestAdmCount", "", "incrementLoadRequestCount", "setGatewayCache", "value", "(Lcom/google/protobuf/ByteString;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setPrivacy", "setPrivacyFsm", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SessionRepository.kt */
public interface SessionRepository {
    NativeConfigurationOuterClass.FeatureFlags getFeatureFlags();

    String getGameId();

    Object getGatewayCache(Continuation<? super ByteString> continuation);

    ByteString getGatewayState();

    String getGatewayUrl();

    InitializationState getInitializationState();

    NativeConfigurationOuterClass.NativeConfiguration getNativeConfiguration();

    SharedFlow<SessionChange> getOnChange();

    Object getPrivacy(Continuation<? super ByteString> continuation);

    Object getPrivacyFsm(Continuation<? super ByteString> continuation);

    SessionCountersOuterClass.SessionCounters getSessionCounters();

    ByteString getSessionId();

    ByteString getSessionToken();

    boolean getShouldInitialize();

    void incrementLoadRequestAdmCount();

    void incrementLoadRequestCount();

    boolean isDiagnosticsEnabled();

    boolean isSdkInitialized();

    boolean isTestModeEnabled();

    void setGameId(String str);

    Object setGatewayCache(ByteString byteString, Continuation<? super Unit> continuation);

    void setGatewayState(ByteString byteString);

    void setGatewayUrl(String str);

    void setInitializationState(InitializationState initializationState);

    void setNativeConfiguration(NativeConfigurationOuterClass.NativeConfiguration nativeConfiguration);

    Object setPrivacy(ByteString byteString, Continuation<? super Unit> continuation);

    Object setPrivacyFsm(ByteString byteString, Continuation<? super Unit> continuation);

    void setSessionCounters(SessionCountersOuterClass.SessionCounters sessionCounters);

    void setSessionToken(ByteString byteString);

    void setShouldInitialize(boolean z);
}
