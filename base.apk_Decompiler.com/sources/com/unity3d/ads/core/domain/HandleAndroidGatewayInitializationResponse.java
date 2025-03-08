package com.unity3d.ads.core.domain;

import com.unity3d.ads.core.data.repository.SessionRepository;
import gateway.v1.InitializationResponseOuterClass;
import gateway.v1.NativeConfigurationOuterClass;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0019\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fHBø\u0001\u0000¢\u0006\u0002\u0010\rR\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"Lcom/unity3d/ads/core/domain/HandleAndroidGatewayInitializationResponse;", "Lcom/unity3d/ads/core/domain/HandleGatewayInitializationResponse;", "triggerInitializationCompletedRequest", "Lcom/unity3d/ads/core/domain/TriggerInitializationCompletedRequest;", "sessionRepository", "Lcom/unity3d/ads/core/data/repository/SessionRepository;", "sdkScope", "Lkotlinx/coroutines/CoroutineScope;", "(Lcom/unity3d/ads/core/domain/TriggerInitializationCompletedRequest;Lcom/unity3d/ads/core/data/repository/SessionRepository;Lkotlinx/coroutines/CoroutineScope;)V", "invoke", "", "response", "Lgateway/v1/InitializationResponseOuterClass$InitializationResponse;", "(Lgateway/v1/InitializationResponseOuterClass$InitializationResponse;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: HandleAndroidGatewayInitializationResponse.kt */
public final class HandleAndroidGatewayInitializationResponse implements HandleGatewayInitializationResponse {
    private final CoroutineScope sdkScope;
    private final SessionRepository sessionRepository;
    /* access modifiers changed from: private */
    public final TriggerInitializationCompletedRequest triggerInitializationCompletedRequest;

    public HandleAndroidGatewayInitializationResponse(TriggerInitializationCompletedRequest triggerInitializationCompletedRequest2, SessionRepository sessionRepository2, CoroutineScope coroutineScope) {
        Intrinsics.checkNotNullParameter(triggerInitializationCompletedRequest2, "triggerInitializationCompletedRequest");
        Intrinsics.checkNotNullParameter(sessionRepository2, "sessionRepository");
        Intrinsics.checkNotNullParameter(coroutineScope, "sdkScope");
        this.triggerInitializationCompletedRequest = triggerInitializationCompletedRequest2;
        this.sessionRepository = sessionRepository2;
        this.sdkScope = coroutineScope;
    }

    public Object invoke(InitializationResponseOuterClass.InitializationResponse initializationResponse, Continuation<? super Unit> continuation) {
        CharSequence universalRequestUrl;
        if (!initializationResponse.hasError()) {
            SessionRepository sessionRepository2 = this.sessionRepository;
            NativeConfigurationOuterClass.NativeConfiguration nativeConfiguration = initializationResponse.getNativeConfiguration();
            Intrinsics.checkNotNullExpressionValue(nativeConfiguration, "response.nativeConfiguration");
            sessionRepository2.setNativeConfiguration(nativeConfiguration);
            if (!(!initializationResponse.hasUniversalRequestUrl() || (universalRequestUrl = initializationResponse.getUniversalRequestUrl()) == null || universalRequestUrl.length() == 0)) {
                SessionRepository sessionRepository3 = this.sessionRepository;
                String universalRequestUrl2 = initializationResponse.getUniversalRequestUrl();
                Intrinsics.checkNotNullExpressionValue(universalRequestUrl2, "response.universalRequestUrl");
                sessionRepository3.setGatewayUrl(universalRequestUrl2);
            }
            if (initializationResponse.getTriggerInitializationCompletedRequest()) {
                Job unused = BuildersKt__Builders_commonKt.launch$default(this.sdkScope, (CoroutineContext) null, (CoroutineStart) null, new HandleAndroidGatewayInitializationResponse$invoke$3(this, (Continuation<? super HandleAndroidGatewayInitializationResponse$invoke$3>) null), 3, (Object) null);
            }
            return Unit.INSTANCE;
        }
        String errorText = initializationResponse.getError().getErrorText();
        Intrinsics.checkNotNullExpressionValue(errorText, "response.error.errorText");
        throw new IllegalStateException(errorText.toString());
    }
}
