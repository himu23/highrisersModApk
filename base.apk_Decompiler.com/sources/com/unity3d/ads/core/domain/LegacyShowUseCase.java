package com.unity3d.ads.core.domain;

import com.google.protobuf.ByteString;
import com.ironsource.d1;
import com.unity3d.ads.IUnityAdsShowListener;
import com.unity3d.ads.UnityAds;
import com.unity3d.ads.core.data.model.AdObject;
import com.unity3d.ads.core.data.model.OperationType;
import com.unity3d.ads.core.data.repository.AdRepository;
import com.unity3d.ads.core.data.repository.SessionRepository;
import com.unity3d.ads.core.domain.SendDiagnosticEvent;
import com.unity3d.ads.core.domain.events.GetOperativeEventApi;
import com.unity3d.ads.core.extensions.TimestampExtensionsKt;
import com.unity3d.ads.core.extensions.UnityAdsShowErrorMapperExtensionKt;
import gateway.v1.OperativeEventErrorDataKt;
import gateway.v1.OperativeEventRequestOuterClass;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\b\u0000\u0018\u0000 ?2\u00020\u0001:\u0001?B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0019\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H@ø\u0001\u0000¢\u0006\u0002\u0010\u0019J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u001c\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u001b0\u001f2\u0006\u0010 \u001a\u00020!H\u0002J5\u0010\"\u001a\u00020\u00162\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010&\u001a\u0004\u0018\u00010'HBø\u0001\u0000¢\u0006\u0002\u0010(J)\u0010)\u001a\u00020\u00162\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u001b2\u0006\u0010-\u001a\u00020.H@ø\u0001\u0000¢\u0006\u0002\u0010/J+\u00100\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010%\u001a\u00020\u001b2\b\u0010&\u001a\u0004\u0018\u00010'H@ø\u0001\u0000¢\u0006\u0002\u00101J3\u00102\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010%\u001a\u00020\u001b2\u0006\u00103\u001a\u0002042\b\u0010&\u001a\u0004\u0018\u00010'H@ø\u0001\u0000¢\u0006\u0002\u00105J=\u00106\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010 \u001a\u00020!2\b\b\u0002\u00107\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020\u001b2\b\u0010&\u001a\u0004\u0018\u00010'H@ø\u0001\u0000¢\u0006\u0002\u00108J\u0011\u00109\u001a\u00020\u0016H@ø\u0001\u0000¢\u0006\u0002\u0010:J+\u0010;\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010%\u001a\u00020\u001b2\b\u0010&\u001a\u0004\u0018\u00010'H@ø\u0001\u0000¢\u0006\u0002\u00101J;\u0010<\u001a\u00020\u00162\u0006\u0010-\u001a\u00020.2\u0006\u0010=\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010%\u001a\u00020\u001b2\b\u0010&\u001a\u0004\u0018\u00010'H@ø\u0001\u0000¢\u0006\u0002\u0010>R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006@"}, d2 = {"Lcom/unity3d/ads/core/domain/LegacyShowUseCase;", "", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "show", "Lcom/unity3d/ads/core/domain/Show;", "adRepository", "Lcom/unity3d/ads/core/data/repository/AdRepository;", "sendDiagnosticEvent", "Lcom/unity3d/ads/core/domain/SendDiagnosticEvent;", "getOperativeEventApi", "Lcom/unity3d/ads/core/domain/events/GetOperativeEventApi;", "sessionRepository", "Lcom/unity3d/ads/core/data/repository/SessionRepository;", "(Lkotlinx/coroutines/CoroutineDispatcher;Lcom/unity3d/ads/core/domain/Show;Lcom/unity3d/ads/core/data/repository/AdRepository;Lcom/unity3d/ads/core/domain/SendDiagnosticEvent;Lcom/unity3d/ads/core/domain/events/GetOperativeEventApi;Lcom/unity3d/ads/core/data/repository/SessionRepository;)V", "hasStarted", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "isShowing", "Ljava/util/concurrent/atomic/AtomicBoolean;", "timeoutCancellationRequested", "cancelTimeout", "", "startTime", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getOpportunityId", "", "unityAdsShowOptions", "Lcom/unity3d/ads/UnityAdsShowOptions;", "getTags", "", "reason", "Lcom/unity3d/ads/UnityAds$UnityAdsShowError;", "invoke", "context", "Landroid/content/Context;", "placement", "unityShowListener", "Lcom/unity3d/ads/IUnityAdsShowListener;", "(Landroid/content/Context;Ljava/lang/String;Lcom/unity3d/ads/UnityAdsShowOptions;Lcom/unity3d/ads/IUnityAdsShowListener;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendOperativeError", "operativeEvent", "Lgateway/v1/OperativeEventRequestOuterClass$OperativeEventErrorType;", "operativeMessage", "adObject", "Lcom/unity3d/ads/core/data/model/AdObject;", "(Lgateway/v1/OperativeEventRequestOuterClass$OperativeEventErrorType;Ljava/lang/String;Lcom/unity3d/ads/core/data/model/AdObject;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "showClicked", "(JLjava/lang/String;Lcom/unity3d/ads/IUnityAdsShowListener;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "showCompleted", "status", "Lcom/unity3d/ads/core/data/model/ShowStatus;", "(JLjava/lang/String;Lcom/unity3d/ads/core/data/model/ShowStatus;Lcom/unity3d/ads/IUnityAdsShowListener;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "showError", "message", "(JLcom/unity3d/ads/UnityAds$UnityAdsShowError;Ljava/lang/String;Ljava/lang/String;Lcom/unity3d/ads/IUnityAdsShowListener;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "showStart", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "showStarted", "showTimeout", "useTimeout", "(Lcom/unity3d/ads/core/data/model/AdObject;ZJLjava/lang/String;Lcom/unity3d/ads/IUnityAdsShowListener;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LegacyShowUseCase.kt */
public final class LegacyShowUseCase {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String KEY_OBJECT_ID = "objectId";
    public static final String MESSAGE_ALREADY_SHOWING = "Can't show a new ad unit when ad unit is already open";
    public static final String MESSAGE_NO_AD_OBJECT = "No ad object found for opportunity id: ";
    public static final String MESSAGE_OPPORTUNITY_ID = "No valid opportunity id provided";
    public static final String MESSAGE_OPT_TIMEOUT = "timeout";
    public static final String MESSAGE_TIMEOUT = "[UnityAds] Timeout while trying to show ";
    public static final String MSG_OPPORTUNITY_AND_PLACEMENT_NOT_MATCHING = "[UnityAds] Object ID and Placement ID provided does not match previously loaded ad";
    private final AdRepository adRepository;
    private final CoroutineDispatcher dispatcher;
    private final GetOperativeEventApi getOperativeEventApi;
    /* access modifiers changed from: private */
    public final MutableStateFlow<Boolean> hasStarted = StateFlowKt.MutableStateFlow(false);
    private final AtomicBoolean isShowing = new AtomicBoolean(false);
    private final SendDiagnosticEvent sendDiagnosticEvent;
    private final SessionRepository sessionRepository;
    private final Show show;
    /* access modifiers changed from: private */
    public final MutableStateFlow<Boolean> timeoutCancellationRequested = StateFlowKt.MutableStateFlow(false);

    public LegacyShowUseCase(CoroutineDispatcher coroutineDispatcher, Show show2, AdRepository adRepository2, SendDiagnosticEvent sendDiagnosticEvent2, GetOperativeEventApi getOperativeEventApi2, SessionRepository sessionRepository2) {
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "dispatcher");
        Intrinsics.checkNotNullParameter(show2, d1.u);
        Intrinsics.checkNotNullParameter(adRepository2, "adRepository");
        Intrinsics.checkNotNullParameter(sendDiagnosticEvent2, "sendDiagnosticEvent");
        Intrinsics.checkNotNullParameter(getOperativeEventApi2, "getOperativeEventApi");
        Intrinsics.checkNotNullParameter(sessionRepository2, "sessionRepository");
        this.dispatcher = coroutineDispatcher;
        this.show = show2;
        this.adRepository = adRepository2;
        this.sendDiagnosticEvent = sendDiagnosticEvent2;
        this.getOperativeEventApi = getOperativeEventApi2;
        this.sessionRepository = sessionRepository2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00cf, code lost:
        if (r12.isShowing.getAndSet(true) == false) goto L_0x00f1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00d1, code lost:
        r2 = com.unity3d.ads.UnityAds.UnityAdsShowError.ALREADY_SHOWING;
        r11.L$0 = null;
        r11.L$1 = null;
        r11.L$2 = null;
        r11.L$3 = null;
        r11.L$4 = null;
        r11.label = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00eb, code lost:
        if (r12.showError(r7, r2, MESSAGE_ALREADY_SHOWING, r9, r1, r11) != r3) goto L_0x00ee;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00ed, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00f0, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00f1, code lost:
        if (r4 == null) goto L_0x00f8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00f3, code lost:
        r2 = r12.getOpportunityId(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00f8, code lost:
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00f9, code lost:
        if (r2 != null) goto L_0x011b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00fb, code lost:
        r2 = com.unity3d.ads.UnityAds.UnityAdsShowError.INVALID_ARGUMENT;
        r11.L$0 = null;
        r11.L$1 = null;
        r11.L$2 = null;
        r11.L$3 = null;
        r11.L$4 = null;
        r11.label = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0115, code lost:
        if (r12.showError(r7, r2, MESSAGE_OPPORTUNITY_ID, r9, r1, r11) != r3) goto L_0x0118;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0117, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x011a, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x011b, code lost:
        r4 = java.util.UUID.fromString(r2);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, "fromString(opportunityId)");
        r4 = com.unity3d.ads.core.extensions.ProtobufExtensionsKt.toByteString(r4);
        r5 = r12.adRepository;
        r11.L$0 = r12;
        r11.L$1 = r10;
        r11.L$2 = r9;
        r11.L$3 = r1;
        r11.L$4 = r2;
        r11.J$0 = r7;
        r11.label = 4;
        r4 = r5.getAd(r4, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x013d, code lost:
        if (r4 != r3) goto L_0x0140;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x013f, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0140, code lost:
        r21 = r1;
        r1 = r2;
        r2 = r4;
        r4 = r12;
        r24 = r10;
        r10 = r9;
        r9 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x014a, code lost:
        r2 = (com.unity3d.ads.core.data.model.AdObject) r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x014c, code lost:
        if (r2 != null) goto L_0x017b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x014e, code lost:
        r2 = com.unity3d.ads.UnityAds.UnityAdsShowError.INTERNAL_ERROR;
        r1 = MESSAGE_NO_AD_OBJECT + r1;
        r11.L$0 = null;
        r11.L$1 = null;
        r11.L$2 = null;
        r11.L$3 = null;
        r11.L$4 = null;
        r11.label = 5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0175, code lost:
        if (r4.showError(r7, r2, r1, r10, r21, r11) != r3) goto L_0x0178;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0177, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x017a, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0189, code lost:
        if (r4.sessionRepository.getNativeConfiguration().getFeatureFlags().getOpportunityIdPlacementValidation() == false) goto L_0x01b6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0193, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2.getPlacementId(), (java.lang.Object) r10) != false) goto L_0x01b6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0195, code lost:
        r1 = com.unity3d.ads.UnityAds.UnityAdsShowError.INVALID_ARGUMENT;
        r11.L$0 = null;
        r11.L$1 = null;
        r11.L$2 = null;
        r11.L$3 = null;
        r11.L$4 = null;
        r11.label = 6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x01b0, code lost:
        if (r4.showError(r7, r1, MSG_OPPORTUNITY_AND_PLACEMENT_NOT_MATCHING, r10, r21, r11) != r3) goto L_0x01b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x01b2, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x01b5, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x01b6, code lost:
        r1 = com.unity3d.ads.core.extensions.FlowExtensionsKt.timeoutAfter$default(r4.show.invoke(r9, r2), (long) r4.sessionRepository.getNativeConfiguration().getAdOperations().getShowTimeoutMs(), false, new com.unity3d.ads.core.domain.LegacyShowUseCase$invoke$2(r4, r2, true, r7, r10, r21, (kotlin.coroutines.Continuation<? super com.unity3d.ads.core.domain.LegacyShowUseCase$invoke$2>) null), 2, (java.lang.Object) null);
        r13 = r4;
        r14 = r7;
        r16 = r10;
        r17 = r21;
        r11.L$0 = r4;
        r11.L$1 = null;
        r11.L$2 = null;
        r11.L$3 = null;
        r11.L$4 = null;
        r11.label = 7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x021f, code lost:
        if (kotlinx.coroutines.flow.FlowKt.m1940catch(r1, new com.unity3d.ads.core.domain.LegacyShowUseCase$invoke$3(r13, r14, r16, r17, (kotlin.coroutines.Continuation<? super com.unity3d.ads.core.domain.LegacyShowUseCase$invoke$3>) null)).collect(new com.unity3d.ads.core.domain.LegacyShowUseCase$invoke$4(r13, r14, r16, r17, r2), r11) != r3) goto L_0x0222;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0221, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0222, code lost:
        r1 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0223, code lost:
        r1.isShowing.set(false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x022b, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invoke(android.content.Context r26, java.lang.String r27, com.unity3d.ads.UnityAdsShowOptions r28, com.unity3d.ads.IUnityAdsShowListener r29, kotlin.coroutines.Continuation<? super kotlin.Unit> r30) {
        /*
            r25 = this;
            r0 = r25
            r1 = r27
            r2 = r30
            boolean r3 = r2 instanceof com.unity3d.ads.core.domain.LegacyShowUseCase$invoke$1
            if (r3 == 0) goto L_0x001a
            r3 = r2
            com.unity3d.ads.core.domain.LegacyShowUseCase$invoke$1 r3 = (com.unity3d.ads.core.domain.LegacyShowUseCase$invoke$1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r4 & r5
            if (r4 == 0) goto L_0x001a
            int r2 = r3.label
            int r2 = r2 - r5
            r3.label = r2
            goto L_0x001f
        L_0x001a:
            com.unity3d.ads.core.domain.LegacyShowUseCase$invoke$1 r3 = new com.unity3d.ads.core.domain.LegacyShowUseCase$invoke$1
            r3.<init>(r0, r2)
        L_0x001f:
            r11 = r3
            java.lang.Object r2 = r11.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r11.label
            r5 = 1
            r6 = 0
            switch(r4) {
                case 0: goto L_0x008f;
                case 1: goto L_0x0075;
                case 2: goto L_0x0070;
                case 3: goto L_0x006b;
                case 4: goto L_0x0048;
                case 5: goto L_0x0043;
                case 6: goto L_0x003e;
                case 7: goto L_0x0035;
                default: goto L_0x002d;
            }
        L_0x002d:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0035:
            java.lang.Object r1 = r11.L$0
            com.unity3d.ads.core.domain.LegacyShowUseCase r1 = (com.unity3d.ads.core.domain.LegacyShowUseCase) r1
            kotlin.ResultKt.throwOnFailure(r2)
            goto L_0x0223
        L_0x003e:
            kotlin.ResultKt.throwOnFailure(r2)
            goto L_0x01b3
        L_0x0043:
            kotlin.ResultKt.throwOnFailure(r2)
            goto L_0x0178
        L_0x0048:
            long r4 = r11.J$0
            java.lang.Object r1 = r11.L$4
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r7 = r11.L$3
            com.unity3d.ads.IUnityAdsShowListener r7 = (com.unity3d.ads.IUnityAdsShowListener) r7
            java.lang.Object r8 = r11.L$2
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r9 = r11.L$1
            android.content.Context r9 = (android.content.Context) r9
            java.lang.Object r10 = r11.L$0
            com.unity3d.ads.core.domain.LegacyShowUseCase r10 = (com.unity3d.ads.core.domain.LegacyShowUseCase) r10
            kotlin.ResultKt.throwOnFailure(r2)
            r21 = r7
            r24 = r10
            r10 = r8
            r7 = r4
            r4 = r24
            goto L_0x014a
        L_0x006b:
            kotlin.ResultKt.throwOnFailure(r2)
            goto L_0x0118
        L_0x0070:
            kotlin.ResultKt.throwOnFailure(r2)
            goto L_0x00ee
        L_0x0075:
            long r7 = r11.J$0
            java.lang.Object r1 = r11.L$4
            com.unity3d.ads.IUnityAdsShowListener r1 = (com.unity3d.ads.IUnityAdsShowListener) r1
            java.lang.Object r4 = r11.L$3
            com.unity3d.ads.UnityAdsShowOptions r4 = (com.unity3d.ads.UnityAdsShowOptions) r4
            java.lang.Object r9 = r11.L$2
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Object r10 = r11.L$1
            android.content.Context r10 = (android.content.Context) r10
            java.lang.Object r12 = r11.L$0
            com.unity3d.ads.core.domain.LegacyShowUseCase r12 = (com.unity3d.ads.core.domain.LegacyShowUseCase) r12
            kotlin.ResultKt.throwOnFailure(r2)
            goto L_0x00c9
        L_0x008f:
            kotlin.ResultKt.throwOnFailure(r2)
            long r7 = java.lang.System.nanoTime()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r4 = "Unity Ads Show Start for placement "
            r2.<init>(r4)
            r2.append(r1)
            java.lang.String r2 = r2.toString()
            com.unity3d.services.core.log.DeviceLog.debug(r2)
            r11.L$0 = r0
            r2 = r26
            r11.L$1 = r2
            r11.L$2 = r1
            r4 = r28
            r11.L$3 = r4
            r9 = r29
            r11.L$4 = r9
            r11.J$0 = r7
            r11.label = r5
            java.lang.Object r10 = r0.showStart(r11)
            if (r10 != r3) goto L_0x00c2
            return r3
        L_0x00c2:
            r12 = r0
            r10 = r2
            r24 = r9
            r9 = r1
            r1 = r24
        L_0x00c9:
            java.util.concurrent.atomic.AtomicBoolean r2 = r12.isShowing
            boolean r2 = r2.getAndSet(r5)
            if (r2 == 0) goto L_0x00f1
            com.unity3d.ads.UnityAds$UnityAdsShowError r2 = com.unity3d.ads.UnityAds.UnityAdsShowError.ALREADY_SHOWING
            java.lang.String r10 = "Can't show a new ad unit when ad unit is already open"
            r11.L$0 = r6
            r11.L$1 = r6
            r11.L$2 = r6
            r11.L$3 = r6
            r11.L$4 = r6
            r4 = 2
            r11.label = r4
            r4 = r12
            r5 = r7
            r7 = r2
            r8 = r10
            r10 = r1
            java.lang.Object r1 = r4.showError(r5, r7, r8, r9, r10, r11)
            if (r1 != r3) goto L_0x00ee
            return r3
        L_0x00ee:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        L_0x00f1:
            if (r4 == 0) goto L_0x00f8
            java.lang.String r2 = r12.getOpportunityId(r4)
            goto L_0x00f9
        L_0x00f8:
            r2 = r6
        L_0x00f9:
            if (r2 != 0) goto L_0x011b
            com.unity3d.ads.UnityAds$UnityAdsShowError r2 = com.unity3d.ads.UnityAds.UnityAdsShowError.INVALID_ARGUMENT
            java.lang.String r10 = "No valid opportunity id provided"
            r11.L$0 = r6
            r11.L$1 = r6
            r11.L$2 = r6
            r11.L$3 = r6
            r11.L$4 = r6
            r4 = 3
            r11.label = r4
            r4 = r12
            r5 = r7
            r7 = r2
            r8 = r10
            r10 = r1
            java.lang.Object r1 = r4.showError(r5, r7, r8, r9, r10, r11)
            if (r1 != r3) goto L_0x0118
            return r3
        L_0x0118:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        L_0x011b:
            java.util.UUID r4 = java.util.UUID.fromString(r2)
            java.lang.String r5 = "fromString(opportunityId)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            com.google.protobuf.ByteString r4 = com.unity3d.ads.core.extensions.ProtobufExtensionsKt.toByteString(r4)
            com.unity3d.ads.core.data.repository.AdRepository r5 = r12.adRepository
            r11.L$0 = r12
            r11.L$1 = r10
            r11.L$2 = r9
            r11.L$3 = r1
            r11.L$4 = r2
            r11.J$0 = r7
            r13 = 4
            r11.label = r13
            java.lang.Object r4 = r5.getAd(r4, r11)
            if (r4 != r3) goto L_0x0140
            return r3
        L_0x0140:
            r21 = r1
            r1 = r2
            r2 = r4
            r4 = r12
            r24 = r10
            r10 = r9
            r9 = r24
        L_0x014a:
            com.unity3d.ads.core.data.model.AdObject r2 = (com.unity3d.ads.core.data.model.AdObject) r2
            if (r2 != 0) goto L_0x017b
            com.unity3d.ads.UnityAds$UnityAdsShowError r2 = com.unity3d.ads.UnityAds.UnityAdsShowError.INTERNAL_ERROR
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r9 = "No ad object found for opportunity id: "
            r5.<init>(r9)
            r5.append(r1)
            java.lang.String r1 = r5.toString()
            r11.L$0 = r6
            r11.L$1 = r6
            r11.L$2 = r6
            r11.L$3 = r6
            r11.L$4 = r6
            r5 = 5
            r11.label = r5
            r5 = r7
            r7 = r2
            r8 = r1
            r9 = r10
            r10 = r21
            java.lang.Object r1 = r4.showError(r5, r7, r8, r9, r10, r11)
            if (r1 != r3) goto L_0x0178
            return r3
        L_0x0178:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        L_0x017b:
            com.unity3d.ads.core.data.repository.SessionRepository r1 = r4.sessionRepository
            gateway.v1.NativeConfigurationOuterClass$NativeConfiguration r1 = r1.getNativeConfiguration()
            gateway.v1.NativeConfigurationOuterClass$FeatureFlags r1 = r1.getFeatureFlags()
            boolean r1 = r1.getOpportunityIdPlacementValidation()
            if (r1 == 0) goto L_0x01b6
            java.lang.String r1 = r2.getPlacementId()
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r10)
            if (r1 != 0) goto L_0x01b6
            com.unity3d.ads.UnityAds$UnityAdsShowError r1 = com.unity3d.ads.UnityAds.UnityAdsShowError.INVALID_ARGUMENT
            java.lang.String r2 = "[UnityAds] Object ID and Placement ID provided does not match previously loaded ad"
            r11.L$0 = r6
            r11.L$1 = r6
            r11.L$2 = r6
            r11.L$3 = r6
            r11.L$4 = r6
            r5 = 6
            r11.label = r5
            r5 = r7
            r7 = r1
            r8 = r2
            r9 = r10
            r10 = r21
            java.lang.Object r1 = r4.showError(r5, r7, r8, r9, r10, r11)
            if (r1 != r3) goto L_0x01b3
            return r3
        L_0x01b3:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        L_0x01b6:
            com.unity3d.ads.core.data.repository.SessionRepository r1 = r4.sessionRepository
            gateway.v1.NativeConfigurationOuterClass$NativeConfiguration r1 = r1.getNativeConfiguration()
            gateway.v1.NativeConfigurationOuterClass$AdOperationsConfiguration r1 = r1.getAdOperations()
            int r1 = r1.getShowTimeoutMs()
            long r14 = (long) r1
            com.unity3d.ads.core.domain.Show r1 = r4.show
            kotlinx.coroutines.flow.Flow r1 = r1.invoke(r9, r2)
            r5 = 0
            com.unity3d.ads.core.domain.LegacyShowUseCase$invoke$2 r9 = new com.unity3d.ads.core.domain.LegacyShowUseCase$invoke$2
            r16 = 1
            r20 = 0
            r12 = r9
            r13 = r4
            r22 = r14
            r14 = r2
            r15 = r16
            r16 = r7
            r18 = r10
            r19 = r21
            r12.<init>(r13, r14, r15, r16, r18, r19, r20)
            r16 = r9
            kotlin.jvm.functions.Function1 r16 = (kotlin.jvm.functions.Function1) r16
            r17 = 2
            r18 = 0
            r12 = r1
            r13 = r22
            r15 = r5
            kotlinx.coroutines.flow.Flow r1 = com.unity3d.ads.core.extensions.FlowExtensionsKt.timeoutAfter$default(r12, r13, r15, r16, r17, r18)
            com.unity3d.ads.core.domain.LegacyShowUseCase$invoke$3 r5 = new com.unity3d.ads.core.domain.LegacyShowUseCase$invoke$3
            r12 = r5
            r13 = r4
            r14 = r7
            r16 = r10
            r17 = r21
            r12.<init>(r13, r14, r16, r17, r18)
            kotlin.jvm.functions.Function3 r5 = (kotlin.jvm.functions.Function3) r5
            kotlinx.coroutines.flow.Flow r1 = kotlinx.coroutines.flow.FlowKt.m1940catch(r1, r5)
            com.unity3d.ads.core.domain.LegacyShowUseCase$invoke$4 r5 = new com.unity3d.ads.core.domain.LegacyShowUseCase$invoke$4
            r12 = r5
            r18 = r2
            r12.<init>(r13, r14, r16, r17, r18)
            kotlinx.coroutines.flow.FlowCollector r5 = (kotlinx.coroutines.flow.FlowCollector) r5
            r11.L$0 = r4
            r11.L$1 = r6
            r11.L$2 = r6
            r11.L$3 = r6
            r11.L$4 = r6
            r2 = 7
            r11.label = r2
            java.lang.Object r1 = r1.collect(r5, r11)
            if (r1 != r3) goto L_0x0222
            return r3
        L_0x0222:
            r1 = r4
        L_0x0223:
            java.util.concurrent.atomic.AtomicBoolean r1 = r1.isShowing
            r2 = 0
            r1.set(r2)
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.LegacyShowUseCase.invoke(android.content.Context, java.lang.String, com.unity3d.ads.UnityAdsShowOptions, com.unity3d.ads.IUnityAdsShowListener, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0092 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object showTimeout(com.unity3d.ads.core.data.model.AdObject r13, boolean r14, long r15, java.lang.String r17, com.unity3d.ads.IUnityAdsShowListener r18, kotlin.coroutines.Continuation<? super kotlin.Unit> r19) {
        /*
            r12 = this;
            r0 = r12
            r1 = r19
            boolean r2 = r1 instanceof com.unity3d.ads.core.domain.LegacyShowUseCase$showTimeout$1
            if (r2 == 0) goto L_0x0017
            r2 = r1
            com.unity3d.ads.core.domain.LegacyShowUseCase$showTimeout$1 r2 = (com.unity3d.ads.core.domain.LegacyShowUseCase$showTimeout$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0017
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L_0x001c
        L_0x0017:
            com.unity3d.ads.core.domain.LegacyShowUseCase$showTimeout$1 r2 = new com.unity3d.ads.core.domain.LegacyShowUseCase$showTimeout$1
            r2.<init>(r12, r1)
        L_0x001c:
            r10 = r2
            java.lang.Object r1 = r10.result
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r10.label
            r4 = 2
            r5 = 1
            if (r3 == 0) goto L_0x004f
            if (r3 == r5) goto L_0x003a
            if (r3 != r4) goto L_0x0032
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x0093
        L_0x0032:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x003a:
            long r5 = r10.J$0
            java.lang.Object r3 = r10.L$2
            com.unity3d.ads.IUnityAdsShowListener r3 = (com.unity3d.ads.IUnityAdsShowListener) r3
            java.lang.Object r7 = r10.L$1
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r8 = r10.L$0
            com.unity3d.ads.core.domain.LegacyShowUseCase r8 = (com.unity3d.ads.core.domain.LegacyShowUseCase) r8
            kotlin.ResultKt.throwOnFailure(r1)
            r9 = r3
            r3 = r8
            r8 = r7
            goto L_0x0071
        L_0x004f:
            kotlin.ResultKt.throwOnFailure(r1)
            if (r14 == 0) goto L_0x0096
            com.unity3d.ads.core.domain.Show r1 = r0.show
            r10.L$0 = r0
            r3 = r17
            r10.L$1 = r3
            r6 = r18
            r10.L$2 = r6
            r7 = r15
            r10.J$0 = r7
            r10.label = r5
            r5 = r13
            java.lang.Object r1 = r1.terminate(r13, r10)
            if (r1 != r2) goto L_0x006d
            return r2
        L_0x006d:
            r9 = r6
            r5 = r7
            r8 = r3
            r3 = r0
        L_0x0071:
            com.unity3d.ads.UnityAds$UnityAdsShowError r1 = com.unity3d.ads.UnityAds.UnityAdsShowError.TIMEOUT
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r11 = "[UnityAds] Timeout while trying to show "
            r7.<init>(r11)
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            r11 = 0
            r10.L$0 = r11
            r10.L$1 = r11
            r10.L$2 = r11
            r10.label = r4
            r4 = r5
            r6 = r1
            java.lang.Object r1 = r3.showError(r4, r6, r7, r8, r9, r10)
            if (r1 != r2) goto L_0x0093
            return r2
        L_0x0093:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        L_0x0096:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.LegacyShowUseCase.showTimeout(com.unity3d.ads.core.data.model.AdObject, boolean, long, java.lang.String, com.unity3d.ads.IUnityAdsShowListener, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final Object cancelTimeout(long j, Continuation<? super Unit> continuation) {
        this.timeoutCancellationRequested.setValue(Boxing.boxBoolean(true));
        Object invoke$default = SendDiagnosticEvent.DefaultImpls.invoke$default(this.sendDiagnosticEvent, "native_show_cancel_timeout", Boxing.boxLong(TimestampExtensionsKt.duration(j)), (Map) null, (Map) null, continuation, 12, (Object) null);
        return invoke$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? invoke$default : Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00a9 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00aa A[PHI: r2 
      PHI: (r2v2 java.lang.Object) = (r2v5 java.lang.Object), (r2v1 java.lang.Object) binds: [B:19:0x00a7, B:10:0x002e] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object showStarted(long r16, java.lang.String r18, com.unity3d.ads.IUnityAdsShowListener r19, kotlin.coroutines.Continuation<? super kotlin.Unit> r20) {
        /*
            r15 = this;
            r0 = r15
            r1 = r18
            r2 = r20
            boolean r3 = r2 instanceof com.unity3d.ads.core.domain.LegacyShowUseCase$showStarted$1
            if (r3 == 0) goto L_0x0019
            r3 = r2
            com.unity3d.ads.core.domain.LegacyShowUseCase$showStarted$1 r3 = (com.unity3d.ads.core.domain.LegacyShowUseCase$showStarted$1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r4 & r5
            if (r4 == 0) goto L_0x0019
            int r2 = r3.label
            int r2 = r2 - r5
            r3.label = r2
            goto L_0x001e
        L_0x0019:
            com.unity3d.ads.core.domain.LegacyShowUseCase$showStarted$1 r3 = new com.unity3d.ads.core.domain.LegacyShowUseCase$showStarted$1
            r3.<init>(r15, r2)
        L_0x001e:
            java.lang.Object r2 = r3.result
            java.lang.Object r12 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r3.label
            r13 = 2
            r5 = 1
            if (r4 == 0) goto L_0x004d
            if (r4 == r5) goto L_0x003b
            if (r4 != r13) goto L_0x0033
            kotlin.ResultKt.throwOnFailure(r2)
            goto L_0x00aa
        L_0x0033:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x003b:
            java.lang.Object r1 = r3.L$2
            com.unity3d.ads.IUnityAdsShowListener r1 = (com.unity3d.ads.IUnityAdsShowListener) r1
            java.lang.Object r4 = r3.L$1
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r5 = r3.L$0
            com.unity3d.ads.core.domain.LegacyShowUseCase r5 = (com.unity3d.ads.core.domain.LegacyShowUseCase) r5
            kotlin.ResultKt.throwOnFailure(r2)
            r14 = r1
            r1 = r4
            goto L_0x008f
        L_0x004d:
            kotlin.ResultKt.throwOnFailure(r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r4 = "Unity Ads Show WV Start for placement "
            r2.<init>(r4)
            r2.append(r1)
            java.lang.String r2 = r2.toString()
            com.unity3d.services.core.log.DeviceLog.debug(r2)
            kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> r2 = r0.hasStarted
            java.lang.Boolean r4 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
            r2.setValue(r4)
            com.unity3d.ads.core.domain.SendDiagnosticEvent r4 = r0.sendDiagnosticEvent
            java.lang.String r2 = "native_show_wv_started"
            long r6 = com.unity3d.ads.core.extensions.TimestampExtensionsKt.duration(r16)
            java.lang.Long r6 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r6)
            r7 = 0
            r8 = 0
            r10 = 12
            r11 = 0
            r3.L$0 = r0
            r3.L$1 = r1
            r14 = r19
            r3.L$2 = r14
            r3.label = r5
            r5 = r2
            r9 = r3
            java.lang.Object r2 = com.unity3d.ads.core.domain.SendDiagnosticEvent.DefaultImpls.invoke$default(r4, r5, r6, r7, r8, r9, r10, r11)
            if (r2 != r12) goto L_0x008e
            return r12
        L_0x008e:
            r5 = r0
        L_0x008f:
            kotlinx.coroutines.CoroutineDispatcher r2 = r5.dispatcher
            kotlin.coroutines.CoroutineContext r2 = (kotlin.coroutines.CoroutineContext) r2
            com.unity3d.ads.core.domain.LegacyShowUseCase$showStarted$2 r4 = new com.unity3d.ads.core.domain.LegacyShowUseCase$showStarted$2
            r5 = 0
            r4.<init>(r14, r1, r5)
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            r3.L$0 = r5
            r3.L$1 = r5
            r3.L$2 = r5
            r3.label = r13
            java.lang.Object r2 = kotlinx.coroutines.BuildersKt.withContext(r2, r4, r3)
            if (r2 != r12) goto L_0x00aa
            return r12
        L_0x00aa:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.LegacyShowUseCase.showStarted(long, java.lang.String, com.unity3d.ads.IUnityAdsShowListener, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00a0 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00a1 A[PHI: r2 
      PHI: (r2v2 java.lang.Object) = (r2v5 java.lang.Object), (r2v1 java.lang.Object) binds: [B:19:0x009e, B:10:0x002e] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object showClicked(long r16, java.lang.String r18, com.unity3d.ads.IUnityAdsShowListener r19, kotlin.coroutines.Continuation<? super kotlin.Unit> r20) {
        /*
            r15 = this;
            r0 = r15
            r1 = r18
            r2 = r20
            boolean r3 = r2 instanceof com.unity3d.ads.core.domain.LegacyShowUseCase$showClicked$1
            if (r3 == 0) goto L_0x0019
            r3 = r2
            com.unity3d.ads.core.domain.LegacyShowUseCase$showClicked$1 r3 = (com.unity3d.ads.core.domain.LegacyShowUseCase$showClicked$1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r4 & r5
            if (r4 == 0) goto L_0x0019
            int r2 = r3.label
            int r2 = r2 - r5
            r3.label = r2
            goto L_0x001e
        L_0x0019:
            com.unity3d.ads.core.domain.LegacyShowUseCase$showClicked$1 r3 = new com.unity3d.ads.core.domain.LegacyShowUseCase$showClicked$1
            r3.<init>(r15, r2)
        L_0x001e:
            java.lang.Object r2 = r3.result
            java.lang.Object r12 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r3.label
            r13 = 2
            r5 = 1
            if (r4 == 0) goto L_0x004d
            if (r4 == r5) goto L_0x003b
            if (r4 != r13) goto L_0x0033
            kotlin.ResultKt.throwOnFailure(r2)
            goto L_0x00a1
        L_0x0033:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x003b:
            java.lang.Object r1 = r3.L$2
            com.unity3d.ads.IUnityAdsShowListener r1 = (com.unity3d.ads.IUnityAdsShowListener) r1
            java.lang.Object r4 = r3.L$1
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r5 = r3.L$0
            com.unity3d.ads.core.domain.LegacyShowUseCase r5 = (com.unity3d.ads.core.domain.LegacyShowUseCase) r5
            kotlin.ResultKt.throwOnFailure(r2)
            r14 = r1
            r1 = r4
            goto L_0x0086
        L_0x004d:
            kotlin.ResultKt.throwOnFailure(r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r4 = "Unity Ads Show Clicked for placement "
            r2.<init>(r4)
            r2.append(r1)
            java.lang.String r2 = r2.toString()
            com.unity3d.services.core.log.DeviceLog.debug(r2)
            com.unity3d.ads.core.domain.SendDiagnosticEvent r4 = r0.sendDiagnosticEvent
            java.lang.String r2 = "native_show_clicked"
            long r6 = com.unity3d.ads.core.extensions.TimestampExtensionsKt.duration(r16)
            java.lang.Long r6 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r6)
            r7 = 0
            r8 = 0
            r10 = 12
            r11 = 0
            r3.L$0 = r0
            r3.L$1 = r1
            r14 = r19
            r3.L$2 = r14
            r3.label = r5
            r5 = r2
            r9 = r3
            java.lang.Object r2 = com.unity3d.ads.core.domain.SendDiagnosticEvent.DefaultImpls.invoke$default(r4, r5, r6, r7, r8, r9, r10, r11)
            if (r2 != r12) goto L_0x0085
            return r12
        L_0x0085:
            r5 = r0
        L_0x0086:
            kotlinx.coroutines.CoroutineDispatcher r2 = r5.dispatcher
            kotlin.coroutines.CoroutineContext r2 = (kotlin.coroutines.CoroutineContext) r2
            com.unity3d.ads.core.domain.LegacyShowUseCase$showClicked$2 r4 = new com.unity3d.ads.core.domain.LegacyShowUseCase$showClicked$2
            r5 = 0
            r4.<init>(r14, r1, r5)
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            r3.L$0 = r5
            r3.L$1 = r5
            r3.L$2 = r5
            r3.label = r13
            java.lang.Object r2 = kotlinx.coroutines.BuildersKt.withContext(r2, r4, r3)
            if (r2 != r12) goto L_0x00a1
            return r12
        L_0x00a1:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.LegacyShowUseCase.showClicked(long, java.lang.String, com.unity3d.ads.IUnityAdsShowListener, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0007, code lost:
        r3 = r3.opt("objectId");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String getOpportunityId(com.unity3d.ads.UnityAdsShowOptions r3) {
        /*
            r2 = this;
            org.json.JSONObject r3 = r3.getData()
            r0 = 0
            if (r3 == 0) goto L_0x0014
            java.lang.String r1 = "objectId"
            java.lang.Object r3 = r3.opt(r1)
            if (r3 == 0) goto L_0x0014
            java.lang.String r3 = r3.toString()
            goto L_0x0015
        L_0x0014:
            r3 = r0
        L_0x0015:
            java.util.UUID r3 = java.util.UUID.fromString(r3)     // Catch:{ all -> 0x001d }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x001d }
        L_0x001d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.LegacyShowUseCase.getOpportunityId(com.unity3d.ads.UnityAdsShowOptions):java.lang.String");
    }

    /* access modifiers changed from: private */
    public final Object showStart(Continuation<? super Unit> continuation) {
        Object invoke$default = SendDiagnosticEvent.DefaultImpls.invoke$default(this.sendDiagnosticEvent, "native_show_started", (Long) null, (Map) null, (Map) null, continuation, 14, (Object) null);
        return invoke$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? invoke$default : Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00ac A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00ad A[PHI: r2 
      PHI: (r2v2 java.lang.Object) = (r2v5 java.lang.Object), (r2v1 java.lang.Object) binds: [B:19:0x00aa, B:10:0x002f] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object showCompleted(long r17, java.lang.String r19, com.unity3d.ads.core.data.model.ShowStatus r20, com.unity3d.ads.IUnityAdsShowListener r21, kotlin.coroutines.Continuation<? super kotlin.Unit> r22) {
        /*
            r16 = this;
            r0 = r16
            r1 = r19
            r2 = r22
            boolean r3 = r2 instanceof com.unity3d.ads.core.domain.LegacyShowUseCase$showCompleted$1
            if (r3 == 0) goto L_0x001a
            r3 = r2
            com.unity3d.ads.core.domain.LegacyShowUseCase$showCompleted$1 r3 = (com.unity3d.ads.core.domain.LegacyShowUseCase$showCompleted$1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r4 & r5
            if (r4 == 0) goto L_0x001a
            int r2 = r3.label
            int r2 = r2 - r5
            r3.label = r2
            goto L_0x001f
        L_0x001a:
            com.unity3d.ads.core.domain.LegacyShowUseCase$showCompleted$1 r3 = new com.unity3d.ads.core.domain.LegacyShowUseCase$showCompleted$1
            r3.<init>(r0, r2)
        L_0x001f:
            java.lang.Object r2 = r3.result
            java.lang.Object r12 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r3.label
            r13 = 2
            r5 = 1
            if (r4 == 0) goto L_0x0053
            if (r4 == r5) goto L_0x003c
            if (r4 != r13) goto L_0x0034
            kotlin.ResultKt.throwOnFailure(r2)
            goto L_0x00ad
        L_0x0034:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x003c:
            java.lang.Object r1 = r3.L$3
            com.unity3d.ads.IUnityAdsShowListener r1 = (com.unity3d.ads.IUnityAdsShowListener) r1
            java.lang.Object r4 = r3.L$2
            com.unity3d.ads.core.data.model.ShowStatus r4 = (com.unity3d.ads.core.data.model.ShowStatus) r4
            java.lang.Object r5 = r3.L$1
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r6 = r3.L$0
            com.unity3d.ads.core.domain.LegacyShowUseCase r6 = (com.unity3d.ads.core.domain.LegacyShowUseCase) r6
            kotlin.ResultKt.throwOnFailure(r2)
            r15 = r1
            r14 = r4
            r1 = r5
            goto L_0x0090
        L_0x0053:
            kotlin.ResultKt.throwOnFailure(r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r4 = "Unity Ads Show Completed for placement "
            r2.<init>(r4)
            r2.append(r1)
            java.lang.String r2 = r2.toString()
            com.unity3d.services.core.log.DeviceLog.debug(r2)
            com.unity3d.ads.core.domain.SendDiagnosticEvent r4 = r0.sendDiagnosticEvent
            java.lang.String r2 = "native_show_success_time"
            long r6 = com.unity3d.ads.core.extensions.TimestampExtensionsKt.duration(r17)
            java.lang.Long r6 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r6)
            r7 = 0
            r8 = 0
            r10 = 12
            r11 = 0
            r3.L$0 = r0
            r3.L$1 = r1
            r14 = r20
            r3.L$2 = r14
            r15 = r21
            r3.L$3 = r15
            r3.label = r5
            r5 = r2
            r9 = r3
            java.lang.Object r2 = com.unity3d.ads.core.domain.SendDiagnosticEvent.DefaultImpls.invoke$default(r4, r5, r6, r7, r8, r9, r10, r11)
            if (r2 != r12) goto L_0x008f
            return r12
        L_0x008f:
            r6 = r0
        L_0x0090:
            kotlinx.coroutines.CoroutineDispatcher r2 = r6.dispatcher
            kotlin.coroutines.CoroutineContext r2 = (kotlin.coroutines.CoroutineContext) r2
            com.unity3d.ads.core.domain.LegacyShowUseCase$showCompleted$2 r4 = new com.unity3d.ads.core.domain.LegacyShowUseCase$showCompleted$2
            r5 = 0
            r4.<init>(r15, r1, r14, r5)
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            r3.L$0 = r5
            r3.L$1 = r5
            r3.L$2 = r5
            r3.L$3 = r5
            r3.label = r13
            java.lang.Object r2 = kotlinx.coroutines.BuildersKt.withContext(r2, r4, r3)
            if (r2 != r12) goto L_0x00ad
            return r12
        L_0x00ad:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.LegacyShowUseCase.showCompleted(long, java.lang.String, com.unity3d.ads.core.data.model.ShowStatus, com.unity3d.ads.IUnityAdsShowListener, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00ce A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00cf  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object showError(long r17, com.unity3d.ads.UnityAds.UnityAdsShowError r19, java.lang.String r20, java.lang.String r21, com.unity3d.ads.IUnityAdsShowListener r22, kotlin.coroutines.Continuation<? super kotlin.Unit> r23) {
        /*
            r16 = this;
            r0 = r16
            r1 = r19
            r2 = r21
            r3 = r23
            boolean r4 = r3 instanceof com.unity3d.ads.core.domain.LegacyShowUseCase$showError$1
            if (r4 == 0) goto L_0x001c
            r4 = r3
            com.unity3d.ads.core.domain.LegacyShowUseCase$showError$1 r4 = (com.unity3d.ads.core.domain.LegacyShowUseCase$showError$1) r4
            int r5 = r4.label
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r5 & r6
            if (r5 == 0) goto L_0x001c
            int r3 = r4.label
            int r3 = r3 - r6
            r4.label = r3
            goto L_0x0021
        L_0x001c:
            com.unity3d.ads.core.domain.LegacyShowUseCase$showError$1 r4 = new com.unity3d.ads.core.domain.LegacyShowUseCase$showError$1
            r4.<init>(r0, r3)
        L_0x0021:
            java.lang.Object r3 = r4.result
            java.lang.Object r13 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r4.label
            r14 = 2
            r6 = 1
            if (r5 == 0) goto L_0x005e
            if (r5 == r6) goto L_0x0042
            if (r5 != r14) goto L_0x003a
            java.lang.Object r1 = r4.L$0
            com.unity3d.ads.core.domain.LegacyShowUseCase r1 = (com.unity3d.ads.core.domain.LegacyShowUseCase) r1
            kotlin.ResultKt.throwOnFailure(r3)
            goto L_0x00d0
        L_0x003a:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0042:
            java.lang.Object r1 = r4.L$4
            com.unity3d.ads.IUnityAdsShowListener r1 = (com.unity3d.ads.IUnityAdsShowListener) r1
            java.lang.Object r2 = r4.L$3
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r5 = r4.L$2
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r6 = r4.L$1
            com.unity3d.ads.UnityAds$UnityAdsShowError r6 = (com.unity3d.ads.UnityAds.UnityAdsShowError) r6
            java.lang.Object r7 = r4.L$0
            com.unity3d.ads.core.domain.LegacyShowUseCase r7 = (com.unity3d.ads.core.domain.LegacyShowUseCase) r7
            kotlin.ResultKt.throwOnFailure(r3)
            r3 = r2
            r15 = r5
            r2 = r1
            r1 = r6
            goto L_0x00a3
        L_0x005e:
            kotlin.ResultKt.throwOnFailure(r3)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r5 = "Unity Ads Show Failed for placement "
            r3.<init>(r5)
            r3.append(r2)
            java.lang.String r3 = r3.toString()
            com.unity3d.services.core.log.DeviceLog.debug(r3)
            com.unity3d.ads.core.domain.SendDiagnosticEvent r5 = r0.sendDiagnosticEvent
            java.lang.String r3 = "native_show_failure_time"
            long r7 = com.unity3d.ads.core.extensions.TimestampExtensionsKt.duration(r17)
            java.lang.Long r7 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r7)
            java.util.Map r8 = r0.getTags(r1)
            r9 = 0
            r11 = 8
            r12 = 0
            r4.L$0 = r0
            r4.L$1 = r1
            r15 = r20
            r4.L$2 = r15
            r4.L$3 = r2
            r10 = r22
            r4.L$4 = r10
            r4.label = r6
            r6 = r3
            r10 = r4
            java.lang.Object r3 = com.unity3d.ads.core.domain.SendDiagnosticEvent.DefaultImpls.invoke$default(r5, r6, r7, r8, r9, r10, r11, r12)
            if (r3 != r13) goto L_0x009f
            return r13
        L_0x009f:
            r7 = r0
            r3 = r2
            r2 = r22
        L_0x00a3:
            kotlinx.coroutines.CoroutineDispatcher r5 = r7.dispatcher
            kotlin.coroutines.CoroutineContext r5 = (kotlin.coroutines.CoroutineContext) r5
            com.unity3d.ads.core.domain.LegacyShowUseCase$showError$2 r6 = new com.unity3d.ads.core.domain.LegacyShowUseCase$showError$2
            r8 = 0
            r17 = r6
            r18 = r2
            r19 = r3
            r20 = r1
            r21 = r15
            r22 = r8
            r17.<init>(r18, r19, r20, r21, r22)
            kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6
            r4.L$0 = r7
            r1 = 0
            r4.L$1 = r1
            r4.L$2 = r1
            r4.L$3 = r1
            r4.L$4 = r1
            r4.label = r14
            java.lang.Object r1 = kotlinx.coroutines.BuildersKt.withContext(r5, r6, r4)
            if (r1 != r13) goto L_0x00cf
            return r13
        L_0x00cf:
            r1 = r7
        L_0x00d0:
            java.util.concurrent.atomic.AtomicBoolean r1 = r1.isShowing
            r2 = 0
            r1.set(r2)
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.LegacyShowUseCase.showError(long, com.unity3d.ads.UnityAds$UnityAdsShowError, java.lang.String, java.lang.String, com.unity3d.ads.IUnityAdsShowListener, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object showError$default(LegacyShowUseCase legacyShowUseCase, long j, UnityAds.UnityAdsShowError unityAdsShowError, String str, String str2, IUnityAdsShowListener iUnityAdsShowListener, Continuation continuation, int i, Object obj) {
        return legacyShowUseCase.showError(j, unityAdsShowError, (i & 4) != 0 ? "" : str, str2, iUnityAdsShowListener, continuation);
    }

    private final Map<String, String> getTags(UnityAds.UnityAdsShowError unityAdsShowError) {
        return MapsKt.mapOf(TuplesKt.to("operation", OperationType.SHOW.toString()), TuplesKt.to("reason", UnityAdsShowErrorMapperExtensionKt.toDiagnosticReason(unityAdsShowError)));
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/unity3d/ads/core/domain/LegacyShowUseCase$Companion;", "", "()V", "KEY_OBJECT_ID", "", "MESSAGE_ALREADY_SHOWING", "MESSAGE_NO_AD_OBJECT", "MESSAGE_OPPORTUNITY_ID", "MESSAGE_OPT_TIMEOUT", "MESSAGE_TIMEOUT", "MSG_OPPORTUNITY_AND_PLACEMENT_NOT_MATCHING", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: LegacyShowUseCase.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* access modifiers changed from: private */
    public final Object sendOperativeError(OperativeEventRequestOuterClass.OperativeEventErrorType operativeEventErrorType, String str, AdObject adObject, Continuation<? super Unit> continuation) {
        OperativeEventErrorDataKt.Dsl.Companion companion = OperativeEventErrorDataKt.Dsl.Companion;
        OperativeEventRequestOuterClass.OperativeEventErrorData.Builder newBuilder = OperativeEventRequestOuterClass.OperativeEventErrorData.newBuilder();
        Intrinsics.checkNotNullExpressionValue(newBuilder, "newBuilder()");
        OperativeEventErrorDataKt.Dsl _create = companion._create(newBuilder);
        _create.setErrorType(operativeEventErrorType);
        _create.setMessage(str);
        OperativeEventRequestOuterClass.OperativeEventErrorData _build = _create._build();
        GetOperativeEventApi getOperativeEventApi2 = this.getOperativeEventApi;
        OperativeEventRequestOuterClass.OperativeEventType operativeEventType = OperativeEventRequestOuterClass.OperativeEventType.OPERATIVE_EVENT_TYPE_SHOW_ERROR;
        ByteString byteString = _build.toByteString();
        Intrinsics.checkNotNullExpressionValue(byteString, "errorData.toByteString()");
        Object invoke = getOperativeEventApi2.invoke(operativeEventType, adObject, byteString, continuation);
        return invoke == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? invoke : Unit.INSTANCE;
    }
}
