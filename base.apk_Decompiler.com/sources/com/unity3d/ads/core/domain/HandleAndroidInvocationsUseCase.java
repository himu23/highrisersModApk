package com.unity3d.ads.core.domain;

import com.unity3d.ads.adplayer.Invocation;
import com.unity3d.ads.core.data.model.AdObject;
import com.unity3d.ads.core.data.repository.CampaignStateRepository;
import com.unity3d.ads.core.data.repository.DeviceInfoRepository;
import com.unity3d.ads.core.data.repository.SessionRepository;
import com.unity3d.ads.core.domain.events.GetOperativeEventApi;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.SharedFlow;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 %2\u00020\u0001:\u0001%BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013¢\u0006\u0002\u0010\u0014Jc\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001f2\u001c\u0010 \u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0\"\u0012\u0006\u0012\u0004\u0018\u00010\u00010!H\u0002ø\u0001\u0000¢\u0006\u0002\u0010$R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006&"}, d2 = {"Lcom/unity3d/ads/core/domain/HandleAndroidInvocationsUseCase;", "", "getAndroidAdPlayerContext", "Lcom/unity3d/ads/core/domain/GetAndroidAdPlayerContext;", "getOperativeEventApi", "Lcom/unity3d/ads/core/domain/events/GetOperativeEventApi;", "refresh", "Lcom/unity3d/ads/core/domain/Refresh;", "handleOpenUrl", "Lcom/unity3d/ads/core/domain/HandleOpenUrl;", "sessionRepository", "Lcom/unity3d/ads/core/data/repository/SessionRepository;", "deviceInfoRepository", "Lcom/unity3d/ads/core/data/repository/DeviceInfoRepository;", "campaignStateRepository", "Lcom/unity3d/ads/core/data/repository/CampaignStateRepository;", "sendPrivacyUpdateRequest", "Lcom/unity3d/ads/core/domain/SendPrivacyUpdateRequest;", "sendDiagnosticEvent", "Lcom/unity3d/ads/core/domain/SendDiagnosticEvent;", "(Lcom/unity3d/ads/core/domain/GetAndroidAdPlayerContext;Lcom/unity3d/ads/core/domain/events/GetOperativeEventApi;Lcom/unity3d/ads/core/domain/Refresh;Lcom/unity3d/ads/core/domain/HandleOpenUrl;Lcom/unity3d/ads/core/data/repository/SessionRepository;Lcom/unity3d/ads/core/data/repository/DeviceInfoRepository;Lcom/unity3d/ads/core/data/repository/CampaignStateRepository;Lcom/unity3d/ads/core/domain/SendPrivacyUpdateRequest;Lcom/unity3d/ads/core/domain/SendDiagnosticEvent;)V", "invoke", "Lkotlinx/coroutines/flow/Flow;", "Lcom/unity3d/ads/adplayer/Invocation;", "onInvocations", "Lkotlinx/coroutines/flow/SharedFlow;", "adData", "", "adDataRefreshToken", "impressionConfig", "adObject", "Lcom/unity3d/ads/core/data/model/AdObject;", "onSubscription", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlinx/coroutines/flow/SharedFlow;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/unity3d/ads/core/data/model/AdObject;Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/flow/Flow;", "Companion", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: HandleAndroidInvocationsUseCase.kt */
public final class HandleAndroidInvocationsUseCase {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String KEY_AD_DATA = "adData";
    public static final String KEY_AD_DATA_REFRESH_TOKEN = "adDataRefreshToken";
    public static final String KEY_IMPRESSION_CONFIG = "impressionConfig";
    public static final String KEY_NATIVE_CONTEXT = "nativeContext";
    public static final String KEY_PACKAGE_NAME = "packageName";
    public static final String KEY_TRACKING_TOKEN = "trackingToken";
    /* access modifiers changed from: private */
    public final CampaignStateRepository campaignStateRepository;
    /* access modifiers changed from: private */
    public final DeviceInfoRepository deviceInfoRepository;
    /* access modifiers changed from: private */
    public final GetAndroidAdPlayerContext getAndroidAdPlayerContext;
    /* access modifiers changed from: private */
    public final GetOperativeEventApi getOperativeEventApi;
    /* access modifiers changed from: private */
    public final HandleOpenUrl handleOpenUrl;
    /* access modifiers changed from: private */
    public final Refresh refresh;
    /* access modifiers changed from: private */
    public final SendDiagnosticEvent sendDiagnosticEvent;
    /* access modifiers changed from: private */
    public final SendPrivacyUpdateRequest sendPrivacyUpdateRequest;
    /* access modifiers changed from: private */
    public final SessionRepository sessionRepository;

    public HandleAndroidInvocationsUseCase(GetAndroidAdPlayerContext getAndroidAdPlayerContext2, GetOperativeEventApi getOperativeEventApi2, Refresh refresh2, HandleOpenUrl handleOpenUrl2, SessionRepository sessionRepository2, DeviceInfoRepository deviceInfoRepository2, CampaignStateRepository campaignStateRepository2, SendPrivacyUpdateRequest sendPrivacyUpdateRequest2, SendDiagnosticEvent sendDiagnosticEvent2) {
        Intrinsics.checkNotNullParameter(getAndroidAdPlayerContext2, "getAndroidAdPlayerContext");
        Intrinsics.checkNotNullParameter(getOperativeEventApi2, "getOperativeEventApi");
        Intrinsics.checkNotNullParameter(refresh2, "refresh");
        Intrinsics.checkNotNullParameter(handleOpenUrl2, "handleOpenUrl");
        Intrinsics.checkNotNullParameter(sessionRepository2, "sessionRepository");
        Intrinsics.checkNotNullParameter(deviceInfoRepository2, "deviceInfoRepository");
        Intrinsics.checkNotNullParameter(campaignStateRepository2, "campaignStateRepository");
        Intrinsics.checkNotNullParameter(sendPrivacyUpdateRequest2, "sendPrivacyUpdateRequest");
        Intrinsics.checkNotNullParameter(sendDiagnosticEvent2, "sendDiagnosticEvent");
        this.getAndroidAdPlayerContext = getAndroidAdPlayerContext2;
        this.getOperativeEventApi = getOperativeEventApi2;
        this.refresh = refresh2;
        this.handleOpenUrl = handleOpenUrl2;
        this.sessionRepository = sessionRepository2;
        this.deviceInfoRepository = deviceInfoRepository2;
        this.campaignStateRepository = campaignStateRepository2;
        this.sendPrivacyUpdateRequest = sendPrivacyUpdateRequest2;
        this.sendDiagnosticEvent = sendDiagnosticEvent2;
    }

    public final Flow<Invocation> invoke(SharedFlow<Invocation> sharedFlow, String str, String str2, String str3, AdObject adObject, Function1<? super Continuation<? super Unit>, ? extends Object> function1) {
        Intrinsics.checkNotNullParameter(sharedFlow, "onInvocations");
        Intrinsics.checkNotNullParameter(str, "adData");
        Intrinsics.checkNotNullParameter(str2, KEY_AD_DATA_REFRESH_TOKEN);
        Intrinsics.checkNotNullParameter(str3, KEY_IMPRESSION_CONFIG);
        Intrinsics.checkNotNullParameter(adObject, "adObject");
        Intrinsics.checkNotNullParameter(function1, "onSubscription");
        return FlowKt.onEach(FlowKt.onSubscription(sharedFlow, new HandleAndroidInvocationsUseCase$invoke$1(function1, (Continuation<? super HandleAndroidInvocationsUseCase$invoke$1>) null)), new HandleAndroidInvocationsUseCase$invoke$2(str, str3, str2, this, adObject, (Continuation<? super HandleAndroidInvocationsUseCase$invoke$2>) null));
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/unity3d/ads/core/domain/HandleAndroidInvocationsUseCase$Companion;", "", "()V", "KEY_AD_DATA", "", "KEY_AD_DATA_REFRESH_TOKEN", "KEY_IMPRESSION_CONFIG", "KEY_NATIVE_CONTEXT", "KEY_PACKAGE_NAME", "KEY_TRACKING_TOKEN", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: HandleAndroidInvocationsUseCase.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
