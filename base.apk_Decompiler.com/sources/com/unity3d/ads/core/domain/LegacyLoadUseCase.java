package com.unity3d.ads.core.domain;

import com.unity3d.ads.IUnityAdsLoadListener;
import com.unity3d.ads.UnityAds;
import com.unity3d.ads.UnityAdsLoadOptions;
import com.unity3d.ads.core.data.model.OperationType;
import com.unity3d.ads.core.data.repository.AdRepository;
import com.unity3d.ads.core.data.repository.SessionRepository;
import com.unity3d.ads.core.extensions.InitializationStatusReaderExtensionKt;
import com.unity3d.ads.core.extensions.UnityAdsLoadErrorMapperExtensionKt;
import com.unity3d.services.core.properties.SdkProperties;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\b\u0000\u0018\u0000 (2\u00020\u0001:\u0001(B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0012\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J \u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002J3\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u00102\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHBø\u0001\u0000¢\u0006\u0002\u0010\u001eJ=\u0010\u001f\u001a\u00020\u00172\u0006\u0010 \u001a\u00020!2\u0006\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\"\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u000e2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH@ø\u0001\u0000¢\u0006\u0002\u0010#J\u0011\u0010$\u001a\u00020!H@ø\u0001\u0000¢\u0006\u0002\u0010%J+\u0010&\u001a\u00020\u00172\u0006\u0010 \u001a\u00020!2\u0006\u0010\u001a\u001a\u00020\u000e2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH@ø\u0001\u0000¢\u0006\u0002\u0010'R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006)"}, d2 = {"Lcom/unity3d/ads/core/domain/LegacyLoadUseCase;", "", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "load", "Lcom/unity3d/ads/core/domain/Load;", "sendDiagnosticEvent", "Lcom/unity3d/ads/core/domain/SendDiagnosticEvent;", "sessionRepository", "Lcom/unity3d/ads/core/data/repository/SessionRepository;", "adRepository", "Lcom/unity3d/ads/core/data/repository/AdRepository;", "(Lkotlinx/coroutines/CoroutineDispatcher;Lcom/unity3d/ads/core/domain/Load;Lcom/unity3d/ads/core/domain/SendDiagnosticEvent;Lcom/unity3d/ads/core/data/repository/SessionRepository;Lcom/unity3d/ads/core/data/repository/AdRepository;)V", "getAdMarkup", "", "unityAdsLoadOptions", "Lcom/unity3d/ads/UnityAdsLoadOptions;", "getOpportunityId", "getTags", "", "reason", "Lcom/unity3d/ads/UnityAds$UnityAdsLoadError;", "invoke", "", "context", "Landroid/content/Context;", "placement", "loadOptions", "unityLoadListener", "Lcom/unity3d/ads/IUnityAdsLoadListener;", "(Landroid/content/Context;Ljava/lang/String;Lcom/unity3d/ads/UnityAdsLoadOptions;Lcom/unity3d/ads/IUnityAdsLoadListener;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadFailure", "startTime", "", "message", "(JLcom/unity3d/ads/UnityAds$UnityAdsLoadError;Ljava/lang/String;Ljava/lang/String;Lcom/unity3d/ads/IUnityAdsLoadListener;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadStart", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadSuccess", "(JLjava/lang/String;Lcom/unity3d/ads/IUnityAdsLoadListener;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LegacyLoadUseCase.kt */
public final class LegacyLoadUseCase {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String KEY_AD_MARKUP = "adMarkup";
    public static final String KEY_OBJECT_ID = "objectId";
    private final AdRepository adRepository;
    private final CoroutineDispatcher dispatcher;
    /* access modifiers changed from: private */
    public final Load load;
    private final SendDiagnosticEvent sendDiagnosticEvent;
    private final SessionRepository sessionRepository;

    public LegacyLoadUseCase(CoroutineDispatcher coroutineDispatcher, Load load2, SendDiagnosticEvent sendDiagnosticEvent2, SessionRepository sessionRepository2, AdRepository adRepository2) {
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "dispatcher");
        Intrinsics.checkNotNullParameter(load2, "load");
        Intrinsics.checkNotNullParameter(sendDiagnosticEvent2, "sendDiagnosticEvent");
        Intrinsics.checkNotNullParameter(sessionRepository2, "sessionRepository");
        Intrinsics.checkNotNullParameter(adRepository2, "adRepository");
        this.dispatcher = coroutineDispatcher;
        this.load = load2;
        this.sendDiagnosticEvent = sendDiagnosticEvent2;
        this.sessionRepository = sessionRepository2;
        this.adRepository = adRepository2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x02b3, code lost:
        r10 = r2;
        r9 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x02b7, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x02b9, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x02bb, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x02bc, code lost:
        r4 = r28;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x02be, code lost:
        r10 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x02c0, code lost:
        r12 = r19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x02c3, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x02c4, code lost:
        r4 = r28;
        r1 = r29;
        r11 = r5;
        r10 = r7;
        r18 = "";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x02cc, code lost:
        r5 = r1;
        r9 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x02d6, code lost:
        r8 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x02d9, code lost:
        r8 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x02f2, code lost:
        return r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        kotlin.ResultKt.throwOnFailure(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0076, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0077, code lost:
        r10 = r2;
        r9 = r6;
        r18 = "";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x007b, code lost:
        r5 = r4;
        r4 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00c9, code lost:
        r9 = r25;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0114, code lost:
        r6 = ((java.lang.Number) r7).longValue();
        com.unity3d.services.core.log.DeviceLog.debug("Unity Ads Load Start for placement " + r9);
        r8 = r4.getOpportunityId(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x012f, code lost:
        if (r8 != null) goto L_0x014f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0131, code lost:
        r0 = com.unity3d.ads.UnityAds.UnityAdsLoadError.INVALID_ARGUMENT;
        r3.L$0 = null;
        r3.L$1 = null;
        r3.L$2 = null;
        r3.L$3 = null;
        r3.L$4 = null;
        r3.label = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0149, code lost:
        if (r4.loadFailure(r6, r0, com.unity3d.ads.core.data.model.LoadResult.MSG_OPPORTUNITY_ID, r9, r10, r3) != r12) goto L_0x014c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x014b, code lost:
        return r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x014e, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x014f, code lost:
        r8 = java.util.UUID.fromString(r8);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, "fromString(opportunityId)");
        r8 = com.unity3d.ads.core.extensions.ProtobufExtensionsKt.toByteString(r8);
        r11 = r4.adRepository;
        r3.L$0 = r4;
        r3.L$1 = r0;
        r3.L$2 = r9;
        r3.L$3 = r5;
        r3.L$4 = r10;
        r3.L$5 = r8;
        r3.J$0 = r6;
        r3.label = 3;
        r11 = r11.hasOpportunityId(r8, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0173, code lost:
        if (r11 != r12) goto L_0x0176;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0175, code lost:
        return r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0176, code lost:
        r15 = r8;
        r8 = r5;
        r5 = r10;
        r25 = r6;
        r6 = r0;
        r7 = r9;
        r0 = r11;
        r11 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0187, code lost:
        if (((java.lang.Boolean) r0).booleanValue() == false) goto L_0x01ad;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0189, code lost:
        r0 = com.unity3d.ads.UnityAds.UnityAdsLoadError.INVALID_ARGUMENT;
        r3.L$0 = null;
        r3.L$1 = null;
        r3.L$2 = null;
        r3.L$3 = null;
        r3.L$4 = null;
        r3.L$5 = null;
        r3.label = 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x01a7, code lost:
        if (r11.loadFailure(r9, r0, com.unity3d.ads.core.data.model.LoadResult.MSG_OPPORTUNITY_ID_USED, r7, r5, r3) != r12) goto L_0x01aa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x01a9, code lost:
        return r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x01ac, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x01ad, code lost:
        r25 = r7;
        r7 = r5;
        r5 = r25;
        r0 = r11.getAdMarkup(r8);
        r4 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x01b9, code lost:
        if (r4 == null) goto L_0x01e2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x01bf, code lost:
        if (kotlin.text.StringsKt.isBlank(r4) == false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x01c2, code lost:
        r4 = gateway.v1.AdResponseKt.Dsl.Companion;
        r8 = gateway.v1.AdResponseOuterClass.AdResponse.newBuilder();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, "newBuilder()");
        r4 = r4._create(r8);
        r0 = com.google.protobuf.ByteString.copyFromUtf8(r0);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, "copyFromUtf8(adMarkup)");
        r4.setAdData(r0);
        r0 = r4._build();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x01e2, code lost:
        r0 = gateway.v1.AdResponseOuterClass.AdResponse.getDefaultInstance();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x01e6, code lost:
        r29 = r9;
        r28 = r11;
        r10 = (long) r11.sessionRepository.getNativeConfiguration().getAdOperations().getLoadTimeoutMs();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x01fb, code lost:
        r4 = r4;
        r9 = r5;
        r5 = r28;
        r8 = r7;
        r7 = r9;
        r17 = r8;
        r8 = r15;
        r15 = com.unity3d.ads.core.data.model.LoadResult.MSG_TIMEOUT;
        r1 = r29;
        r11 = r9;
        r19 = r12;
        r18 = "";
        r12 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:?, code lost:
        r4 = new com.unity3d.ads.core.domain.LegacyLoadUseCase$invoke$loadResult$1(r5, r6, r7, r8, r0, (kotlin.coroutines.Continuation<? super com.unity3d.ads.core.domain.LegacyLoadUseCase$invoke$loadResult$1>) null);
        r14 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x021a, code lost:
        r4 = r28;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:?, code lost:
        r3.L$0 = r4;
        r3.L$1 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0220, code lost:
        r10 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:?, code lost:
        r3.L$2 = r10;
        r3.L$3 = null;
        r3.L$4 = null;
        r3.L$5 = null;
        r3.J$0 = r1;
        r3.label = 5;
        r0 = kotlinx.coroutines.TimeoutKt.withTimeoutOrNull(r12, r14, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x0234, code lost:
        r12 = r19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0236, code lost:
        if (r0 != r12) goto L_0x0239;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0238, code lost:
        return r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0239, code lost:
        r7 = r4;
        r6 = r11;
        r4 = r1;
        r2 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:?, code lost:
        r0 = (com.unity3d.ads.core.data.model.LoadResult) r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x023f, code lost:
        if (r0 != null) goto L_0x025f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0241, code lost:
        r0 = new com.unity3d.ads.core.data.model.LoadResult.Failure(com.unity3d.ads.UnityAds.UnityAdsLoadError.TIMEOUT, r15 + r6, (java.lang.Throwable) null, 4, (kotlin.jvm.internal.DefaultConstructorMarker) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x025f, code lost:
        r13 = r4;
        r1 = r6;
        r15 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0264, code lost:
        if ((r0 instanceof com.unity3d.ads.core.data.model.LoadResult.Success) == false) goto L_0x027d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0266, code lost:
        r3.L$0 = r15;
        r3.L$1 = r1;
        r3.L$2 = r2;
        r3.J$0 = r13;
        r3.label = 7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x027a, code lost:
        if (r15.loadSuccess(r13, r1, r2, r3) != r12) goto L_0x02f3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x027c, code lost:
        return r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x027f, code lost:
        if ((r0 instanceof com.unity3d.ads.core.data.model.LoadResult.Failure) == false) goto L_0x02f3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x0281, code lost:
        r7 = ((com.unity3d.ads.core.data.model.LoadResult.Failure) r0).getError();
        r0 = ((com.unity3d.ads.core.data.model.LoadResult.Failure) r0).getMessage();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x028e, code lost:
        if (r0 != null) goto L_0x0293;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x0290, code lost:
        r8 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x0293, code lost:
        r8 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x0294, code lost:
        r3.L$0 = r15;
        r3.L$1 = r1;
        r3.L$2 = r2;
        r3.J$0 = r13;
        r3.label = 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x02a9, code lost:
        if (r15.loadFailure(r13, r7, r8, r1, r2, r3) != r12) goto L_0x02f3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x02ab, code lost:
        return r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x02ac, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x02ad, code lost:
        r9 = r1;
        r10 = r2;
        r5 = r13;
        r4 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x02b2, code lost:
        r0 = e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x02d6  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x02d9  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x02f2 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00cd  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00f2  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invoke(android.content.Context r28, java.lang.String r29, com.unity3d.ads.UnityAdsLoadOptions r30, com.unity3d.ads.IUnityAdsLoadListener r31, kotlin.coroutines.Continuation<? super kotlin.Unit> r32) {
        /*
            r27 = this;
            r1 = r27
            r0 = r32
            java.lang.String r2 = "[UnityAds] Timeout while loading "
            boolean r3 = r0 instanceof com.unity3d.ads.core.domain.LegacyLoadUseCase$invoke$1
            if (r3 == 0) goto L_0x001a
            r3 = r0
            com.unity3d.ads.core.domain.LegacyLoadUseCase$invoke$1 r3 = (com.unity3d.ads.core.domain.LegacyLoadUseCase$invoke$1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r4 & r5
            if (r4 == 0) goto L_0x001a
            int r0 = r3.label
            int r0 = r0 - r5
            r3.label = r0
            goto L_0x001f
        L_0x001a:
            com.unity3d.ads.core.domain.LegacyLoadUseCase$invoke$1 r3 = new com.unity3d.ads.core.domain.LegacyLoadUseCase$invoke$1
            r3.<init>(r1, r0)
        L_0x001f:
            java.lang.Object r0 = r3.result
            java.lang.Object r12 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r3.label
            java.lang.String r13 = ""
            r14 = 0
            switch(r4) {
                case 0: goto L_0x00f2;
                case 1: goto L_0x00d2;
                case 2: goto L_0x00cd;
                case 3: goto L_0x00a6;
                case 4: goto L_0x00a1;
                case 5: goto L_0x007f;
                case 6: goto L_0x005c;
                case 7: goto L_0x004d;
                case 8: goto L_0x003a;
                case 9: goto L_0x0035;
                default: goto L_0x002d;
            }
        L_0x002d:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x02f3
        L_0x003a:
            long r4 = r3.J$0
            java.lang.Object r2 = r3.L$2
            com.unity3d.ads.IUnityAdsLoadListener r2 = (com.unity3d.ads.IUnityAdsLoadListener) r2
            java.lang.Object r6 = r3.L$1
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r7 = r3.L$0
            com.unity3d.ads.core.domain.LegacyLoadUseCase r7 = (com.unity3d.ads.core.domain.LegacyLoadUseCase) r7
        L_0x0048:
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ Exception -> 0x0076 }
            goto L_0x02f3
        L_0x004d:
            long r4 = r3.J$0
            java.lang.Object r2 = r3.L$2
            com.unity3d.ads.IUnityAdsLoadListener r2 = (com.unity3d.ads.IUnityAdsLoadListener) r2
            java.lang.Object r6 = r3.L$1
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r7 = r3.L$0
            com.unity3d.ads.core.domain.LegacyLoadUseCase r7 = (com.unity3d.ads.core.domain.LegacyLoadUseCase) r7
            goto L_0x0048
        L_0x005c:
            long r4 = r3.J$0
            java.lang.Object r2 = r3.L$2
            com.unity3d.ads.IUnityAdsLoadListener r2 = (com.unity3d.ads.IUnityAdsLoadListener) r2
            java.lang.Object r6 = r3.L$1
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r7 = r3.L$0
            com.unity3d.ads.core.domain.LegacyLoadUseCase r7 = (com.unity3d.ads.core.domain.LegacyLoadUseCase) r7
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ Exception -> 0x0076 }
            com.unity3d.ads.core.data.model.LoadResult r0 = (com.unity3d.ads.core.data.model.LoadResult) r0     // Catch:{ Exception -> 0x0076 }
            r1 = r6
            r15 = r7
            r18 = r13
            r13 = r4
            goto L_0x0262
        L_0x0076:
            r0 = move-exception
            r10 = r2
            r9 = r6
            r18 = r13
        L_0x007b:
            r5 = r4
            r4 = r7
            goto L_0x02ce
        L_0x007f:
            long r4 = r3.J$0
            java.lang.Object r6 = r3.L$2
            com.unity3d.ads.IUnityAdsLoadListener r6 = (com.unity3d.ads.IUnityAdsLoadListener) r6
            java.lang.Object r7 = r3.L$1
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r8 = r3.L$0
            com.unity3d.ads.core.domain.LegacyLoadUseCase r8 = (com.unity3d.ads.core.domain.LegacyLoadUseCase) r8
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ Exception -> 0x0098 }
            r15 = r2
            r2 = r6
            r6 = r7
            r7 = r8
            r18 = r13
            goto L_0x023d
        L_0x0098:
            r0 = move-exception
            r10 = r6
            r9 = r7
            r18 = r13
            r5 = r4
            r4 = r8
            goto L_0x02ce
        L_0x00a1:
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x01aa
        L_0x00a6:
            long r4 = r3.J$0
            java.lang.Object r6 = r3.L$5
            com.google.protobuf.ByteString r6 = (com.google.protobuf.ByteString) r6
            java.lang.Object r7 = r3.L$4
            com.unity3d.ads.IUnityAdsLoadListener r7 = (com.unity3d.ads.IUnityAdsLoadListener) r7
            java.lang.Object r8 = r3.L$3
            com.unity3d.ads.UnityAdsLoadOptions r8 = (com.unity3d.ads.UnityAdsLoadOptions) r8
            java.lang.Object r9 = r3.L$2
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Object r10 = r3.L$1
            android.content.Context r10 = (android.content.Context) r10
            java.lang.Object r11 = r3.L$0
            com.unity3d.ads.core.domain.LegacyLoadUseCase r11 = (com.unity3d.ads.core.domain.LegacyLoadUseCase) r11
            kotlin.ResultKt.throwOnFailure(r0)
            r15 = r6
            r6 = r10
            r25 = r4
            r5 = r7
            r7 = r9
        L_0x00c9:
            r9 = r25
            goto L_0x0181
        L_0x00cd:
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x014c
        L_0x00d2:
            java.lang.Object r4 = r3.L$4
            com.unity3d.ads.IUnityAdsLoadListener r4 = (com.unity3d.ads.IUnityAdsLoadListener) r4
            java.lang.Object r5 = r3.L$3
            com.unity3d.ads.UnityAdsLoadOptions r5 = (com.unity3d.ads.UnityAdsLoadOptions) r5
            java.lang.Object r6 = r3.L$2
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r7 = r3.L$1
            android.content.Context r7 = (android.content.Context) r7
            java.lang.Object r8 = r3.L$0
            com.unity3d.ads.core.domain.LegacyLoadUseCase r8 = (com.unity3d.ads.core.domain.LegacyLoadUseCase) r8
            kotlin.ResultKt.throwOnFailure(r0)
            r10 = r4
            r9 = r6
            r4 = r8
            r25 = r7
            r7 = r0
            r0 = r25
            goto L_0x0114
        L_0x00f2:
            kotlin.ResultKt.throwOnFailure(r0)
            r3.L$0 = r1
            r0 = r28
            r3.L$1 = r0
            r4 = r29
            r3.L$2 = r4
            r5 = r30
            r3.L$3 = r5
            r6 = r31
            r3.L$4 = r6
            r7 = 1
            r3.label = r7
            java.lang.Object r7 = r1.loadStart(r3)
            if (r7 != r12) goto L_0x0111
            return r12
        L_0x0111:
            r9 = r4
            r10 = r6
            r4 = r1
        L_0x0114:
            java.lang.Number r7 = (java.lang.Number) r7
            long r6 = r7.longValue()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r11 = "Unity Ads Load Start for placement "
            r8.<init>(r11)
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            com.unity3d.services.core.log.DeviceLog.debug(r8)
            java.lang.String r8 = r4.getOpportunityId(r5)
            if (r8 != 0) goto L_0x014f
            com.unity3d.ads.UnityAds$UnityAdsLoadError r0 = com.unity3d.ads.UnityAds.UnityAdsLoadError.INVALID_ARGUMENT
            java.lang.String r8 = "[UnityAds] Object ID cannot be null"
            r3.L$0 = r14
            r3.L$1 = r14
            r3.L$2 = r14
            r3.L$3 = r14
            r3.L$4 = r14
            r2 = 2
            r3.label = r2
            r5 = r6
            r7 = r0
            r11 = r3
            java.lang.Object r0 = r4.loadFailure(r5, r7, r8, r9, r10, r11)
            if (r0 != r12) goto L_0x014c
            return r12
        L_0x014c:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x014f:
            java.util.UUID r8 = java.util.UUID.fromString(r8)
            java.lang.String r11 = "fromString(opportunityId)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r11)
            com.google.protobuf.ByteString r8 = com.unity3d.ads.core.extensions.ProtobufExtensionsKt.toByteString(r8)
            com.unity3d.ads.core.data.repository.AdRepository r11 = r4.adRepository
            r3.L$0 = r4
            r3.L$1 = r0
            r3.L$2 = r9
            r3.L$3 = r5
            r3.L$4 = r10
            r3.L$5 = r8
            r3.J$0 = r6
            r15 = 3
            r3.label = r15
            java.lang.Object r11 = r11.hasOpportunityId(r8, r3)
            if (r11 != r12) goto L_0x0176
            return r12
        L_0x0176:
            r15 = r8
            r8 = r5
            r5 = r10
            r25 = r6
            r6 = r0
            r7 = r9
            r0 = r11
            r11 = r4
            goto L_0x00c9
        L_0x0181:
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x01ad
            com.unity3d.ads.UnityAds$UnityAdsLoadError r0 = com.unity3d.ads.UnityAds.UnityAdsLoadError.INVALID_ARGUMENT
            java.lang.String r8 = "[UnityAds] Object ID already used"
            r3.L$0 = r14
            r3.L$1 = r14
            r3.L$2 = r14
            r3.L$3 = r14
            r3.L$4 = r14
            r3.L$5 = r14
            r2 = 4
            r3.label = r2
            r4 = r11
            r2 = r5
            r5 = r9
            r9 = r7
            r7 = r0
            r10 = r2
            r11 = r3
            java.lang.Object r0 = r4.loadFailure(r5, r7, r8, r9, r10, r11)
            if (r0 != r12) goto L_0x01aa
            return r12
        L_0x01aa:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x01ad:
            r25 = r7
            r7 = r5
            r5 = r25
            java.lang.String r0 = r11.getAdMarkup(r8)
            r4 = r0
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            if (r4 == 0) goto L_0x01e2
            boolean r4 = kotlin.text.StringsKt.isBlank(r4)
            if (r4 == 0) goto L_0x01c2
            goto L_0x01e2
        L_0x01c2:
            gateway.v1.AdResponseKt$Dsl$Companion r4 = gateway.v1.AdResponseKt.Dsl.Companion
            gateway.v1.AdResponseOuterClass$AdResponse$Builder r8 = gateway.v1.AdResponseOuterClass.AdResponse.newBuilder()
            java.lang.String r14 = "newBuilder()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r14)
            gateway.v1.AdResponseKt$Dsl r4 = r4._create(r8)
            com.google.protobuf.ByteString r0 = com.google.protobuf.ByteString.copyFromUtf8(r0)
            java.lang.String r8 = "copyFromUtf8(adMarkup)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r8)
            r4.setAdData(r0)
            gateway.v1.AdResponseOuterClass$AdResponse r0 = r4._build()
            goto L_0x01e6
        L_0x01e2:
            gateway.v1.AdResponseOuterClass$AdResponse r0 = gateway.v1.AdResponseOuterClass.AdResponse.getDefaultInstance()
        L_0x01e6:
            com.unity3d.ads.core.data.repository.SessionRepository r4 = r11.sessionRepository
            gateway.v1.NativeConfigurationOuterClass$NativeConfiguration r4 = r4.getNativeConfiguration()
            gateway.v1.NativeConfigurationOuterClass$AdOperationsConfiguration r4 = r4.getAdOperations()
            int r4 = r4.getLoadTimeoutMs()
            r29 = r9
            r28 = r11
            long r10 = (long) r4
            com.unity3d.ads.core.domain.LegacyLoadUseCase$invoke$loadResult$1 r14 = new com.unity3d.ads.core.domain.LegacyLoadUseCase$invoke$loadResult$1     // Catch:{ Exception -> 0x02c3 }
            r16 = 0
            r4 = r14
            r9 = r5
            r5 = r28
            r8 = r7
            r7 = r9
            r17 = r8
            r8 = r15
            r15 = r2
            r1 = r29
            r29 = r10
            r11 = r9
            r9 = r0
            r19 = r12
            r18 = r13
            r12 = r29
            r10 = r16
            r4.<init>(r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x02bb }
            kotlin.jvm.functions.Function2 r14 = (kotlin.jvm.functions.Function2) r14     // Catch:{ Exception -> 0x02bb }
            r4 = r28
            r3.L$0 = r4     // Catch:{ Exception -> 0x02b9 }
            r3.L$1 = r11     // Catch:{ Exception -> 0x02b9 }
            r10 = r17
            r3.L$2 = r10     // Catch:{ Exception -> 0x02b7 }
            r5 = 0
            r3.L$3 = r5     // Catch:{ Exception -> 0x02b7 }
            r3.L$4 = r5     // Catch:{ Exception -> 0x02b7 }
            r3.L$5 = r5     // Catch:{ Exception -> 0x02b7 }
            r3.J$0 = r1     // Catch:{ Exception -> 0x02b7 }
            r0 = 5
            r3.label = r0     // Catch:{ Exception -> 0x02b7 }
            java.lang.Object r0 = kotlinx.coroutines.TimeoutKt.withTimeoutOrNull(r12, r14, r3)     // Catch:{ Exception -> 0x02b7 }
            r12 = r19
            if (r0 != r12) goto L_0x0239
            return r12
        L_0x0239:
            r7 = r4
            r6 = r11
            r4 = r1
            r2 = r10
        L_0x023d:
            com.unity3d.ads.core.data.model.LoadResult r0 = (com.unity3d.ads.core.data.model.LoadResult) r0     // Catch:{ Exception -> 0x02b2 }
            if (r0 != 0) goto L_0x025f
            com.unity3d.ads.core.data.model.LoadResult$Failure r0 = new com.unity3d.ads.core.data.model.LoadResult$Failure     // Catch:{ Exception -> 0x02b2 }
            com.unity3d.ads.UnityAds$UnityAdsLoadError r20 = com.unity3d.ads.UnityAds.UnityAdsLoadError.TIMEOUT     // Catch:{ Exception -> 0x02b2 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02b2 }
            r8 = r15
            r1.<init>(r8)     // Catch:{ Exception -> 0x02b2 }
            r1.append(r6)     // Catch:{ Exception -> 0x02b2 }
            java.lang.String r21 = r1.toString()     // Catch:{ Exception -> 0x02b2 }
            r22 = 0
            r23 = 4
            r24 = 0
            r19 = r0
            r19.<init>(r20, r21, r22, r23, r24)     // Catch:{ Exception -> 0x02b2 }
            com.unity3d.ads.core.data.model.LoadResult r0 = (com.unity3d.ads.core.data.model.LoadResult) r0     // Catch:{ Exception -> 0x02b2 }
        L_0x025f:
            r13 = r4
            r1 = r6
            r15 = r7
        L_0x0262:
            boolean r4 = r0 instanceof com.unity3d.ads.core.data.model.LoadResult.Success     // Catch:{ Exception -> 0x02ac }
            if (r4 == 0) goto L_0x027d
            r3.L$0 = r15     // Catch:{ Exception -> 0x02ac }
            r3.L$1 = r1     // Catch:{ Exception -> 0x02ac }
            r3.L$2 = r2     // Catch:{ Exception -> 0x02ac }
            r3.J$0 = r13     // Catch:{ Exception -> 0x02ac }
            r0 = 7
            r3.label = r0     // Catch:{ Exception -> 0x02ac }
            r4 = r15
            r5 = r13
            r7 = r1
            r8 = r2
            r9 = r3
            java.lang.Object r0 = r4.loadSuccess(r5, r7, r8, r9)     // Catch:{ Exception -> 0x02ac }
            if (r0 != r12) goto L_0x02f3
            return r12
        L_0x027d:
            boolean r4 = r0 instanceof com.unity3d.ads.core.data.model.LoadResult.Failure     // Catch:{ Exception -> 0x02ac }
            if (r4 == 0) goto L_0x02f3
            r4 = r0
            com.unity3d.ads.core.data.model.LoadResult$Failure r4 = (com.unity3d.ads.core.data.model.LoadResult.Failure) r4     // Catch:{ Exception -> 0x02ac }
            com.unity3d.ads.UnityAds$UnityAdsLoadError r7 = r4.getError()     // Catch:{ Exception -> 0x02ac }
            com.unity3d.ads.core.data.model.LoadResult$Failure r0 = (com.unity3d.ads.core.data.model.LoadResult.Failure) r0     // Catch:{ Exception -> 0x02ac }
            java.lang.String r0 = r0.getMessage()     // Catch:{ Exception -> 0x02ac }
            if (r0 != 0) goto L_0x0293
            r8 = r18
            goto L_0x0294
        L_0x0293:
            r8 = r0
        L_0x0294:
            r3.L$0 = r15     // Catch:{ Exception -> 0x02ac }
            r3.L$1 = r1     // Catch:{ Exception -> 0x02ac }
            r3.L$2 = r2     // Catch:{ Exception -> 0x02ac }
            r3.J$0 = r13     // Catch:{ Exception -> 0x02ac }
            r0 = 8
            r3.label = r0     // Catch:{ Exception -> 0x02ac }
            r4 = r15
            r5 = r13
            r9 = r1
            r10 = r2
            r11 = r3
            java.lang.Object r0 = r4.loadFailure(r5, r7, r8, r9, r10, r11)     // Catch:{ Exception -> 0x02ac }
            if (r0 != r12) goto L_0x02f3
            return r12
        L_0x02ac:
            r0 = move-exception
            r9 = r1
            r10 = r2
            r5 = r13
            r4 = r15
            goto L_0x02ce
        L_0x02b2:
            r0 = move-exception
            r10 = r2
            r9 = r6
            goto L_0x007b
        L_0x02b7:
            r0 = move-exception
            goto L_0x02c0
        L_0x02b9:
            r0 = move-exception
            goto L_0x02be
        L_0x02bb:
            r0 = move-exception
            r4 = r28
        L_0x02be:
            r10 = r17
        L_0x02c0:
            r12 = r19
            goto L_0x02cc
        L_0x02c3:
            r0 = move-exception
            r4 = r28
            r1 = r29
            r11 = r5
            r10 = r7
            r18 = r13
        L_0x02cc:
            r5 = r1
            r9 = r11
        L_0x02ce:
            com.unity3d.ads.UnityAds$UnityAdsLoadError r7 = com.unity3d.ads.UnityAds.UnityAdsLoadError.INTERNAL_ERROR
            java.lang.String r0 = r0.getMessage()
            if (r0 != 0) goto L_0x02d9
            r8 = r18
            goto L_0x02da
        L_0x02d9:
            r8 = r0
        L_0x02da:
            r1 = 0
            r3.L$0 = r1
            r3.L$1 = r1
            r3.L$2 = r1
            r3.L$3 = r1
            r3.L$4 = r1
            r3.L$5 = r1
            r0 = 9
            r3.label = r0
            r11 = r3
            java.lang.Object r0 = r4.loadFailure(r5, r7, r8, r9, r10, r11)
            if (r0 != r12) goto L_0x02f3
            return r12
        L_0x02f3:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.LegacyLoadUseCase.invoke(android.content.Context, java.lang.String, com.unity3d.ads.UnityAdsLoadOptions, com.unity3d.ads.IUnityAdsLoadListener, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final String getOpportunityId(UnityAdsLoadOptions unityAdsLoadOptions) {
        Object opt;
        JSONObject data = unityAdsLoadOptions.getData();
        if (data == null || (opt = data.opt("objectId")) == null) {
            return null;
        }
        return opt.toString();
    }

    private final String getAdMarkup(UnityAdsLoadOptions unityAdsLoadOptions) {
        Object opt;
        JSONObject data = unityAdsLoadOptions.getData();
        if (data == null || (opt = data.opt("adMarkup")) == null) {
            return null;
        }
        return opt.toString();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object loadStart(kotlin.coroutines.Continuation<? super java.lang.Long> r12) {
        /*
            r11 = this;
            boolean r0 = r12 instanceof com.unity3d.ads.core.domain.LegacyLoadUseCase$loadStart$1
            if (r0 == 0) goto L_0x0014
            r0 = r12
            com.unity3d.ads.core.domain.LegacyLoadUseCase$loadStart$1 r0 = (com.unity3d.ads.core.domain.LegacyLoadUseCase$loadStart$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r12 = r0.label
            int r12 = r12 - r2
            r0.label = r12
            goto L_0x0019
        L_0x0014:
            com.unity3d.ads.core.domain.LegacyLoadUseCase$loadStart$1 r0 = new com.unity3d.ads.core.domain.LegacyLoadUseCase$loadStart$1
            r0.<init>(r11, r12)
        L_0x0019:
            r6 = r0
            java.lang.Object r12 = r6.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 1
            if (r1 == 0) goto L_0x0035
            if (r1 != r2) goto L_0x002d
            long r0 = r6.J$0
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x0053
        L_0x002d:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r12)
            long r9 = java.lang.System.nanoTime()
            com.unity3d.ads.core.domain.SendDiagnosticEvent r1 = r11.sendDiagnosticEvent
            java.lang.String r12 = "native_load_started"
            r3 = 0
            r4 = 0
            r5 = 0
            r7 = 14
            r8 = 0
            r6.J$0 = r9
            r6.label = r2
            r2 = r12
            java.lang.Object r12 = com.unity3d.ads.core.domain.SendDiagnosticEvent.DefaultImpls.invoke$default(r1, r2, r3, r4, r5, r6, r7, r8)
            if (r12 != r0) goto L_0x0052
            return r0
        L_0x0052:
            r0 = r9
        L_0x0053:
            java.lang.Long r12 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r0)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.LegacyLoadUseCase.loadStart(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00a4 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00a5 A[PHI: r2 
      PHI: (r2v2 java.lang.Object) = (r2v5 java.lang.Object), (r2v1 java.lang.Object) binds: [B:19:0x00a2, B:10:0x0030] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object loadSuccess(long r17, java.lang.String r19, com.unity3d.ads.IUnityAdsLoadListener r20, kotlin.coroutines.Continuation<? super kotlin.Unit> r21) {
        /*
            r16 = this;
            r0 = r16
            r1 = r19
            r2 = r21
            boolean r3 = r2 instanceof com.unity3d.ads.core.domain.LegacyLoadUseCase$loadSuccess$1
            if (r3 == 0) goto L_0x001a
            r3 = r2
            com.unity3d.ads.core.domain.LegacyLoadUseCase$loadSuccess$1 r3 = (com.unity3d.ads.core.domain.LegacyLoadUseCase$loadSuccess$1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r4 & r5
            if (r4 == 0) goto L_0x001a
            int r2 = r3.label
            int r2 = r2 - r5
            r3.label = r2
            goto L_0x001f
        L_0x001a:
            com.unity3d.ads.core.domain.LegacyLoadUseCase$loadSuccess$1 r3 = new com.unity3d.ads.core.domain.LegacyLoadUseCase$loadSuccess$1
            r3.<init>(r0, r2)
        L_0x001f:
            java.lang.Object r2 = r3.result
            java.lang.Object r12 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r3.label
            r13 = 2
            r5 = 1
            r14 = 0
            if (r4 == 0) goto L_0x004f
            if (r4 == r5) goto L_0x003d
            if (r4 != r13) goto L_0x0035
            kotlin.ResultKt.throwOnFailure(r2)
            goto L_0x00a5
        L_0x0035:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x003d:
            java.lang.Object r1 = r3.L$2
            com.unity3d.ads.IUnityAdsLoadListener r1 = (com.unity3d.ads.IUnityAdsLoadListener) r1
            java.lang.Object r4 = r3.L$1
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r5 = r3.L$0
            com.unity3d.ads.core.domain.LegacyLoadUseCase r5 = (com.unity3d.ads.core.domain.LegacyLoadUseCase) r5
            kotlin.ResultKt.throwOnFailure(r2)
            r15 = r1
            r1 = r4
            goto L_0x008b
        L_0x004f:
            kotlin.ResultKt.throwOnFailure(r2)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r4 = "Unity Ads Load Success for placement: "
            r2.<init>(r4)
            r2.append(r1)
            java.lang.String r2 = r2.toString()
            com.unity3d.services.core.log.DeviceLog.debug(r2)
            com.unity3d.ads.core.domain.SendDiagnosticEvent r4 = r0.sendDiagnosticEvent
            java.lang.String r2 = "native_load_success_time"
            long r6 = com.unity3d.ads.core.extensions.TimestampExtensionsKt.duration(r17)
            java.lang.Long r6 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r6)
            java.util.Map r7 = getTags$default(r0, r14, r5, r14)
            r8 = 0
            r10 = 8
            r11 = 0
            r3.L$0 = r0
            r3.L$1 = r1
            r15 = r20
            r3.L$2 = r15
            r3.label = r5
            r5 = r2
            r9 = r3
            java.lang.Object r2 = com.unity3d.ads.core.domain.SendDiagnosticEvent.DefaultImpls.invoke$default(r4, r5, r6, r7, r8, r9, r10, r11)
            if (r2 != r12) goto L_0x008a
            return r12
        L_0x008a:
            r5 = r0
        L_0x008b:
            kotlinx.coroutines.CoroutineDispatcher r2 = r5.dispatcher
            kotlin.coroutines.CoroutineContext r2 = (kotlin.coroutines.CoroutineContext) r2
            com.unity3d.ads.core.domain.LegacyLoadUseCase$loadSuccess$2 r4 = new com.unity3d.ads.core.domain.LegacyLoadUseCase$loadSuccess$2
            r4.<init>(r15, r1, r14)
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
            r3.L$0 = r14
            r3.L$1 = r14
            r3.L$2 = r14
            r3.label = r13
            java.lang.Object r2 = kotlinx.coroutines.BuildersKt.withContext(r2, r4, r3)
            if (r2 != r12) goto L_0x00a5
            return r12
        L_0x00a5:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.LegacyLoadUseCase.loadSuccess(long, java.lang.String, com.unity3d.ads.IUnityAdsLoadListener, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00e1 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00e2 A[PHI: r4 
      PHI: (r4v2 java.lang.Object) = (r4v4 java.lang.Object), (r4v1 java.lang.Object) binds: [B:23:0x00df, B:10:0x0033] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object loadFailure(long r17, com.unity3d.ads.UnityAds.UnityAdsLoadError r19, java.lang.String r20, java.lang.String r21, com.unity3d.ads.IUnityAdsLoadListener r22, kotlin.coroutines.Continuation<? super kotlin.Unit> r23) {
        /*
            r16 = this;
            r0 = r16
            r1 = r19
            r2 = r20
            r3 = r21
            r4 = r23
            boolean r5 = r4 instanceof com.unity3d.ads.core.domain.LegacyLoadUseCase$loadFailure$1
            if (r5 == 0) goto L_0x001e
            r5 = r4
            com.unity3d.ads.core.domain.LegacyLoadUseCase$loadFailure$1 r5 = (com.unity3d.ads.core.domain.LegacyLoadUseCase$loadFailure$1) r5
            int r6 = r5.label
            r7 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = r6 & r7
            if (r6 == 0) goto L_0x001e
            int r4 = r5.label
            int r4 = r4 - r7
            r5.label = r4
            goto L_0x0023
        L_0x001e:
            com.unity3d.ads.core.domain.LegacyLoadUseCase$loadFailure$1 r5 = new com.unity3d.ads.core.domain.LegacyLoadUseCase$loadFailure$1
            r5.<init>(r0, r4)
        L_0x0023:
            java.lang.Object r4 = r5.result
            java.lang.Object r14 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r6 = r5.label
            r15 = 2
            r7 = 1
            if (r6 == 0) goto L_0x005c
            if (r6 == r7) goto L_0x0040
            if (r6 != r15) goto L_0x0038
            kotlin.ResultKt.throwOnFailure(r4)
            goto L_0x00e2
        L_0x0038:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0040:
            java.lang.Object r1 = r5.L$4
            com.unity3d.ads.IUnityAdsLoadListener r1 = (com.unity3d.ads.IUnityAdsLoadListener) r1
            java.lang.Object r2 = r5.L$3
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r3 = r5.L$2
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r6 = r5.L$1
            com.unity3d.ads.UnityAds$UnityAdsLoadError r6 = (com.unity3d.ads.UnityAds.UnityAdsLoadError) r6
            java.lang.Object r7 = r5.L$0
            com.unity3d.ads.core.domain.LegacyLoadUseCase r7 = (com.unity3d.ads.core.domain.LegacyLoadUseCase) r7
            kotlin.ResultKt.throwOnFailure(r4)
            r4 = r3
            r3 = r2
            r2 = r1
            r1 = r6
            goto L_0x00b6
        L_0x005c:
            kotlin.ResultKt.throwOnFailure(r4)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r6 = "Unity Ads Load Failure for placement: "
            r4.<init>(r6)
            r4.append(r3)
            java.lang.String r6 = " reason: "
            r4.append(r6)
            r4.append(r1)
            java.lang.String r6 = " :: "
            r4.append(r6)
            r4.append(r2)
            java.lang.String r4 = r4.toString()
            com.unity3d.services.core.log.DeviceLog.debug(r4)
            com.unity3d.ads.UnityAds$UnityAdsLoadError r4 = com.unity3d.ads.UnityAds.UnityAdsLoadError.TIMEOUT
            if (r1 != r4) goto L_0x0087
            java.lang.String r4 = "native_load_timeout"
            goto L_0x0089
        L_0x0087:
            java.lang.String r4 = "native_load_failure_time"
        L_0x0089:
            com.unity3d.ads.core.domain.SendDiagnosticEvent r6 = r0.sendDiagnosticEvent
            long r8 = com.unity3d.ads.core.extensions.TimestampExtensionsKt.duration(r17)
            java.lang.Long r8 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r8)
            java.util.Map r9 = r0.getTags(r1)
            r10 = 0
            r12 = 8
            r13 = 0
            r5.L$0 = r0
            r5.L$1 = r1
            r5.L$2 = r2
            r5.L$3 = r3
            r11 = r22
            r5.L$4 = r11
            r5.label = r7
            r7 = r4
            r11 = r5
            java.lang.Object r4 = com.unity3d.ads.core.domain.SendDiagnosticEvent.DefaultImpls.invoke$default(r6, r7, r8, r9, r10, r11, r12, r13)
            if (r4 != r14) goto L_0x00b2
            return r14
        L_0x00b2:
            r7 = r0
            r4 = r2
            r2 = r22
        L_0x00b6:
            kotlinx.coroutines.CoroutineDispatcher r6 = r7.dispatcher
            kotlin.coroutines.CoroutineContext r6 = (kotlin.coroutines.CoroutineContext) r6
            com.unity3d.ads.core.domain.LegacyLoadUseCase$loadFailure$2 r7 = new com.unity3d.ads.core.domain.LegacyLoadUseCase$loadFailure$2
            r8 = 0
            r17 = r7
            r18 = r2
            r19 = r3
            r20 = r1
            r21 = r4
            r22 = r8
            r17.<init>(r18, r19, r20, r21, r22)
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            r1 = 0
            r5.L$0 = r1
            r5.L$1 = r1
            r5.L$2 = r1
            r5.L$3 = r1
            r5.L$4 = r1
            r5.label = r15
            java.lang.Object r4 = kotlinx.coroutines.BuildersKt.withContext(r6, r7, r5)
            if (r4 != r14) goto L_0x00e2
            return r14
        L_0x00e2:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.LegacyLoadUseCase.loadFailure(long, com.unity3d.ads.UnityAds$UnityAdsLoadError, java.lang.String, java.lang.String, com.unity3d.ads.IUnityAdsLoadListener, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object loadFailure$default(LegacyLoadUseCase legacyLoadUseCase, long j, UnityAds.UnityAdsLoadError unityAdsLoadError, String str, String str2, IUnityAdsLoadListener iUnityAdsLoadListener, Continuation continuation, int i, Object obj) {
        return legacyLoadUseCase.loadFailure(j, unityAdsLoadError, (i & 4) != 0 ? "" : str, str2, iUnityAdsLoadListener, continuation);
    }

    static /* synthetic */ Map getTags$default(LegacyLoadUseCase legacyLoadUseCase, UnityAds.UnityAdsLoadError unityAdsLoadError, int i, Object obj) {
        if ((i & 1) != 0) {
            unityAdsLoadError = null;
        }
        return legacyLoadUseCase.getTags(unityAdsLoadError);
    }

    private final Map<String, String> getTags(UnityAds.UnityAdsLoadError unityAdsLoadError) {
        SdkProperties.InitializationState currentInitializationState = SdkProperties.getCurrentInitializationState();
        Intrinsics.checkNotNullExpressionValue(currentInitializationState, "initState");
        Map<String, String> mutableMapOf = MapsKt.mutableMapOf(TuplesKt.to("state", InitializationStatusReaderExtensionKt.getInitializationStateString(currentInitializationState).toString()));
        if (unityAdsLoadError != null) {
            mutableMapOf.put("reason", UnityAdsLoadErrorMapperExtensionKt.toDiagnosticReason(unityAdsLoadError));
            mutableMapOf.put("operation", OperationType.LOAD.toString());
        }
        return mutableMapOf;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/unity3d/ads/core/domain/LegacyLoadUseCase$Companion;", "", "()V", "KEY_AD_MARKUP", "", "KEY_OBJECT_ID", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: LegacyLoadUseCase.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
