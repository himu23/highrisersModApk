package com.unity3d.ads.gatewayclient;

import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import com.unity3d.ads.core.data.model.OperationType;
import com.unity3d.ads.core.data.model.UnityAdsNetworkException;
import com.unity3d.ads.core.domain.HandleGatewayUniversalResponse;
import com.unity3d.ads.core.domain.SendDiagnosticEvent;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.network.core.HttpClient;
import com.unity3d.services.core.network.model.HttpResponse;
import gateway.v1.ErrorKt;
import gateway.v1.ErrorOuterClass;
import gateway.v1.UniversalResponseKt;
import gateway.v1.UniversalResponseOuterClass;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 ,2\u00020\u0001:\u0001,B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0018\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0018\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J1\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u001c2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u001eH@ø\u0001\u0000¢\u0006\u0002\u0010\u001fJ1\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0002\u0010%J1\u0010&\u001a\u00020!2\u0006\u0010'\u001a\u00020\u00182\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0002\u0010(J\u0010\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u000eH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006-"}, d2 = {"Lcom/unity3d/ads/gatewayclient/CommonGatewayClient;", "Lcom/unity3d/ads/gatewayclient/GatewayClient;", "httpClient", "Lcom/unity3d/services/core/network/core/HttpClient;", "handleGatewayUniversalResponse", "Lcom/unity3d/ads/core/domain/HandleGatewayUniversalResponse;", "sendDiagnosticEvent", "Lcom/unity3d/ads/core/domain/SendDiagnosticEvent;", "(Lcom/unity3d/services/core/network/core/HttpClient;Lcom/unity3d/ads/core/domain/HandleGatewayUniversalResponse;Lcom/unity3d/ads/core/domain/SendDiagnosticEvent;)V", "calculateDelayTime", "", "requestPolicy", "Lcom/unity3d/ads/gatewayclient/RequestPolicy;", "retryCount", "", "calculateExponentialBackoff", "retryWaitBase", "calculateJitter", "retryWaitTime", "retryJitterPct", "", "getUniversalResponse", "Lgateway/v1/UniversalResponseOuterClass$UniversalResponse;", "response", "Lcom/unity3d/services/core/network/model/HttpResponse;", "request", "url", "", "Lgateway/v1/UniversalRequestOuterClass$UniversalRequest;", "operationType", "Lcom/unity3d/ads/core/data/model/OperationType;", "(Ljava/lang/String;Lgateway/v1/UniversalRequestOuterClass$UniversalRequest;Lcom/unity3d/ads/gatewayclient/RequestPolicy;Lcom/unity3d/ads/core/data/model/OperationType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendNetworkErrorDiagnosticEvent", "", "e", "Lcom/unity3d/ads/core/data/model/UnityAdsNetworkException;", "duration", "(Lcom/unity3d/ads/core/data/model/UnityAdsNetworkException;ILcom/unity3d/ads/core/data/model/OperationType;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendNetworkSuccessDiagnosticEvent", "httpResponse", "(Lcom/unity3d/services/core/network/model/HttpResponse;ILcom/unity3d/ads/core/data/model/OperationType;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shouldRetry", "", "responseCode", "Companion", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: CommonGatewayClient.kt */
public final class CommonGatewayClient implements GatewayClient {
    public static final int CODE_400 = 400;
    public static final int CODE_599 = 599;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String RETRY_ATTEMPT_HEADER = "X-RETRY-ATTEMPT";
    private final HandleGatewayUniversalResponse handleGatewayUniversalResponse;
    private final HttpClient httpClient;
    private final SendDiagnosticEvent sendDiagnosticEvent;

    private final boolean shouldRetry(int i) {
        return 400 <= i && i < 600;
    }

    public CommonGatewayClient(HttpClient httpClient2, HandleGatewayUniversalResponse handleGatewayUniversalResponse2, SendDiagnosticEvent sendDiagnosticEvent2) {
        Intrinsics.checkNotNullParameter(httpClient2, "httpClient");
        Intrinsics.checkNotNullParameter(handleGatewayUniversalResponse2, "handleGatewayUniversalResponse");
        Intrinsics.checkNotNullParameter(sendDiagnosticEvent2, "sendDiagnosticEvent");
        this.httpClient = httpClient2;
        this.handleGatewayUniversalResponse = handleGatewayUniversalResponse2;
        this.sendDiagnosticEvent = sendDiagnosticEvent2;
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/unity3d/ads/gatewayclient/CommonGatewayClient$Companion;", "", "()V", "CODE_400", "", "CODE_599", "RETRY_ATTEMPT_HEADER", "", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: CommonGatewayClient.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(11:24|(3:25|26|27)|(2:43|44)|45|46|47|48|49|50|(1:52)(6:53|54|70|(0)(0)|72|(0)(0))|52) */
    /* JADX WARNING: Can't wrap try/catch for region: R(13:24|25|26|27|(2:43|44)|45|46|47|48|49|50|(1:52)(6:53|54|70|(0)(0)|72|(0)(0))|52) */
    /* JADX WARNING: Can't wrap try/catch for region: R(15:0|(2:2|(13:4|6|(1:(1:(1:(1:(1:(5:13|84|(1:86)|87|88)(2:14|15))(2:16|90))(6:17|69|70|(1:72)(3:80|(1:82)(5:83|84|(1:87)(0)|87|88)|82)|72|(2:74|(1:76)(2:77|89))(2:78|79)))(9:18|19|20|21|54|70|(0)|72|(0)(0)))(14:24|25|26|27|43|44|45|46|47|48|49|50|(1:52)(6:53|54|70|(0)(0)|72|(0)(0))|52))(1:30)|31|(1:33)|34|35|36|37|38|39|(1:41)(11:42|43|44|45|46|47|48|49|50|(0)|52)|41))|5|6|(0)(0)|31|(0)|34|35|36|37|38|39|(0)|41) */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0209, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x020b, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x020c, code lost:
        r23 = r9;
        r24 = r10;
        r17 = r11;
        r25 = r12;
        r20 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0225, code lost:
        r10 = r5;
        r13 = r17;
        r8 = r20;
        r5 = r22;
        r15 = r23;
        r14 = r24;
        r11 = r25;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0233, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0235, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0236, code lost:
        r41 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0238, code lost:
        r5 = r41;
        r37 = r14;
        r14 = r3;
        r15 = r2;
        r1 = r9;
        r2 = r13;
        r13 = r4;
        r4 = r10;
        r10 = r8;
        r8 = r37;
     */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0125  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0150  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x01b6  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x01f9  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0270 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0271  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0284  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x028a  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x02aa  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x02d3  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x031c  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0034  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object request(java.lang.String r41, gateway.v1.UniversalRequestOuterClass.UniversalRequest r42, com.unity3d.ads.gatewayclient.RequestPolicy r43, com.unity3d.ads.core.data.model.OperationType r44, kotlin.coroutines.Continuation<? super gateway.v1.UniversalResponseOuterClass.UniversalResponse> r45) {
        /*
            r40 = this;
            r0 = r45
            boolean r1 = r0 instanceof com.unity3d.ads.gatewayclient.CommonGatewayClient$request$1
            if (r1 == 0) goto L_0x0018
            r1 = r0
            com.unity3d.ads.gatewayclient.CommonGatewayClient$request$1 r1 = (com.unity3d.ads.gatewayclient.CommonGatewayClient$request$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L_0x0018
            int r0 = r1.label
            int r0 = r0 - r3
            r1.label = r0
            r2 = r40
            goto L_0x001f
        L_0x0018:
            com.unity3d.ads.gatewayclient.CommonGatewayClient$request$1 r1 = new com.unity3d.ads.gatewayclient.CommonGatewayClient$request$1
            r2 = r40
            r1.<init>(r2, r0)
        L_0x001f:
            java.lang.Object r0 = r1.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r1.label
            java.lang.String r5 = "ms"
            java.lang.String r6 = " retries and duration: "
            java.lang.String r7 = "Gateway request failed after "
            r8 = 5
            r9 = 4
            r10 = 3
            r11 = 2
            r12 = 1
            if (r4 == 0) goto L_0x0125
            if (r4 == r12) goto L_0x00e6
            if (r4 == r11) goto L_0x00ab
            if (r4 == r10) goto L_0x007f
            if (r4 == r9) goto L_0x0076
            if (r4 != r8) goto L_0x006e
            long r13 = r1.J$0
            java.lang.Object r4 = r1.L$5
            kotlin.jvm.internal.Ref$IntRef r4 = (kotlin.jvm.internal.Ref.IntRef) r4
            java.lang.Object r15 = r1.L$4
            com.unity3d.ads.core.data.model.OperationType r15 = (com.unity3d.ads.core.data.model.OperationType) r15
            java.lang.Object r8 = r1.L$3
            com.unity3d.ads.gatewayclient.RequestPolicy r8 = (com.unity3d.ads.gatewayclient.RequestPolicy) r8
            java.lang.Object r9 = r1.L$2
            gateway.v1.UniversalRequestOuterClass$UniversalRequest r9 = (gateway.v1.UniversalRequestOuterClass.UniversalRequest) r9
            java.lang.Object r10 = r1.L$1
            java.lang.String r10 = (java.lang.String) r10
            java.lang.Object r11 = r1.L$0
            com.unity3d.ads.gatewayclient.CommonGatewayClient r11 = (com.unity3d.ads.gatewayclient.CommonGatewayClient) r11
            kotlin.ResultKt.throwOnFailure(r0)
            r0 = r4
            r2 = r9
            r4 = r15
            r9 = 5
            r37 = r5
            r5 = r1
            r1 = r10
            r10 = r3
            r3 = r8
            r8 = r37
            r38 = r13
            r13 = r11
            r11 = r38
            goto L_0x030b
        L_0x006e:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0076:
            java.lang.Object r1 = r1.L$0
            gateway.v1.UniversalResponseOuterClass$UniversalResponse r1 = (gateway.v1.UniversalResponseOuterClass.UniversalResponse) r1
            kotlin.ResultKt.throwOnFailure(r0)
            goto L_0x02a9
        L_0x007f:
            long r8 = r1.J$0
            java.lang.Object r4 = r1.L$6
            com.unity3d.ads.core.data.model.UnityAdsNetworkException r4 = (com.unity3d.ads.core.data.model.UnityAdsNetworkException) r4
            java.lang.Object r10 = r1.L$5
            kotlin.jvm.internal.Ref$IntRef r10 = (kotlin.jvm.internal.Ref.IntRef) r10
            java.lang.Object r11 = r1.L$4
            com.unity3d.ads.core.data.model.OperationType r11 = (com.unity3d.ads.core.data.model.OperationType) r11
            java.lang.Object r13 = r1.L$3
            com.unity3d.ads.gatewayclient.RequestPolicy r13 = (com.unity3d.ads.gatewayclient.RequestPolicy) r13
            java.lang.Object r14 = r1.L$2
            gateway.v1.UniversalRequestOuterClass$UniversalRequest r14 = (gateway.v1.UniversalRequestOuterClass.UniversalRequest) r14
            java.lang.Object r15 = r1.L$1
            java.lang.String r15 = (java.lang.String) r15
            java.lang.Object r12 = r1.L$0
            com.unity3d.ads.gatewayclient.CommonGatewayClient r12 = (com.unity3d.ads.gatewayclient.CommonGatewayClient) r12
            kotlin.ResultKt.throwOnFailure(r0)
            r19 = r5
            r2 = r12
            r5 = r15
            r15 = r14
            r14 = r13
            r13 = r11
            r11 = r8
            r8 = 3
            goto L_0x0273
        L_0x00ab:
            long r8 = r1.J$1
            long r10 = r1.J$0
            java.lang.Object r4 = r1.L$6
            com.unity3d.services.core.network.model.HttpResponse r4 = (com.unity3d.services.core.network.model.HttpResponse) r4
            java.lang.Object r12 = r1.L$5
            kotlin.jvm.internal.Ref$IntRef r12 = (kotlin.jvm.internal.Ref.IntRef) r12
            java.lang.Object r13 = r1.L$4
            com.unity3d.ads.core.data.model.OperationType r13 = (com.unity3d.ads.core.data.model.OperationType) r13
            java.lang.Object r14 = r1.L$3
            com.unity3d.ads.gatewayclient.RequestPolicy r14 = (com.unity3d.ads.gatewayclient.RequestPolicy) r14
            java.lang.Object r15 = r1.L$2
            gateway.v1.UniversalRequestOuterClass$UniversalRequest r15 = (gateway.v1.UniversalRequestOuterClass.UniversalRequest) r15
            java.lang.Object r2 = r1.L$1
            java.lang.String r2 = (java.lang.String) r2
            r41 = r2
            java.lang.Object r2 = r1.L$0
            com.unity3d.ads.gatewayclient.CommonGatewayClient r2 = (com.unity3d.ads.gatewayclient.CommonGatewayClient) r2
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ UnityAdsNetworkException -> 0x00d9 }
            r22 = r41
            r0 = r4
            r19 = r5
            r4 = r3
            r3 = 2
            goto L_0x0202
        L_0x00d9:
            r0 = move-exception
            r4 = r3
            r19 = r5
            r5 = r41
            r37 = r10
            r10 = r12
            r11 = r37
            goto L_0x0247
        L_0x00e6:
            long r8 = r1.J$1
            long r10 = r1.J$0
            java.lang.Object r2 = r1.L$5
            kotlin.jvm.internal.Ref$IntRef r2 = (kotlin.jvm.internal.Ref.IntRef) r2
            java.lang.Object r4 = r1.L$4
            com.unity3d.ads.core.data.model.OperationType r4 = (com.unity3d.ads.core.data.model.OperationType) r4
            java.lang.Object r12 = r1.L$3
            com.unity3d.ads.gatewayclient.RequestPolicy r12 = (com.unity3d.ads.gatewayclient.RequestPolicy) r12
            java.lang.Object r13 = r1.L$2
            gateway.v1.UniversalRequestOuterClass$UniversalRequest r13 = (gateway.v1.UniversalRequestOuterClass.UniversalRequest) r13
            java.lang.Object r14 = r1.L$1
            java.lang.String r14 = (java.lang.String) r14
            java.lang.Object r15 = r1.L$0
            com.unity3d.ads.gatewayclient.CommonGatewayClient r15 = (com.unity3d.ads.gatewayclient.CommonGatewayClient) r15
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ UnityAdsNetworkException -> 0x0118 }
            r19 = r5
            r5 = r2
            r2 = r15
            r37 = r4
            r4 = r3
            r3 = r14
            r14 = r8
            r9 = r13
            r38 = r10
            r11 = r37
            r10 = r12
            r12 = r38
            goto L_0x01c0
        L_0x0118:
            r0 = move-exception
            r19 = r5
            r5 = r14
            r14 = r12
            r11 = r10
            r10 = r2
            r2 = r15
            r15 = r13
            r13 = r4
            r4 = r3
            goto L_0x0247
        L_0x0125:
            kotlin.ResultKt.throwOnFailure(r0)
            kotlin.jvm.internal.Ref$IntRef r0 = new kotlin.jvm.internal.Ref$IntRef
            r0.<init>()
            r8 = 0
            r13 = r40
            r2 = r42
            r4 = r44
            r10 = r3
            r11 = r8
            r3 = r43
            r8 = r0
            r9 = r1
            r1 = r41
        L_0x013d:
            java.util.Map r0 = kotlin.collections.MapsKt.createMapBuilder()
            java.lang.String r14 = "application/x-protobuf"
            java.util.List r14 = kotlin.collections.CollectionsKt.listOf(r14)
            java.lang.String r15 = "Content-Type"
            r0.put(r15, r14)
            int r14 = r8.element
            if (r14 <= 0) goto L_0x015f
            int r14 = r8.element
            java.lang.String r14 = java.lang.String.valueOf(r14)
            java.util.List r14 = kotlin.collections.CollectionsKt.listOf(r14)
            java.lang.String r15 = "X-RETRY-ATTEMPT"
            r0.put(r15, r14)
        L_0x015f:
            java.util.Map r24 = kotlin.collections.MapsKt.build(r0)
            com.unity3d.services.core.network.model.HttpRequest r0 = new com.unity3d.services.core.network.model.HttpRequest
            r19 = r0
            r21 = 0
            com.unity3d.services.core.network.model.RequestType r22 = com.unity3d.services.core.network.model.RequestType.POST
            byte[] r23 = r2.toByteArray()
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            int r29 = r3.getConnectTimeout()
            int r30 = r3.getReadTimeout()
            int r31 = r3.getWriteTimeout()
            r32 = 0
            r33 = 1
            r34 = 0
            r35 = 20962(0x51e2, float:2.9374E-41)
            r36 = 0
            r20 = r1
            r19.<init>(r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36)
            long r14 = java.lang.System.nanoTime()
            r19 = r5
            com.unity3d.services.core.network.core.HttpClient r5 = r13.httpClient     // Catch:{ UnityAdsNetworkException -> 0x0235 }
            r9.L$0 = r13     // Catch:{ UnityAdsNetworkException -> 0x0235 }
            r9.L$1 = r1     // Catch:{ UnityAdsNetworkException -> 0x0235 }
            r9.L$2 = r2     // Catch:{ UnityAdsNetworkException -> 0x0235 }
            r9.L$3 = r3     // Catch:{ UnityAdsNetworkException -> 0x0235 }
            r9.L$4 = r4     // Catch:{ UnityAdsNetworkException -> 0x0235 }
            r9.L$5 = r8     // Catch:{ UnityAdsNetworkException -> 0x0235 }
            r9.J$0 = r11     // Catch:{ UnityAdsNetworkException -> 0x0235 }
            r9.J$1 = r14     // Catch:{ UnityAdsNetworkException -> 0x0235 }
            r41 = r1
            r1 = 1
            r9.label = r1     // Catch:{ UnityAdsNetworkException -> 0x0233 }
            java.lang.Object r0 = r5.execute(r0, r9)     // Catch:{ UnityAdsNetworkException -> 0x0233 }
            if (r0 != r10) goto L_0x01b6
            return r10
        L_0x01b6:
            r5 = r8
            r1 = r9
            r9 = r2
            r2 = r13
            r12 = r11
            r11 = r4
            r4 = r10
            r10 = r3
            r3 = r41
        L_0x01c0:
            com.unity3d.services.core.network.model.HttpResponse r0 = (com.unity3d.services.core.network.model.HttpResponse) r0     // Catch:{ UnityAdsNetworkException -> 0x0217 }
            int r8 = r5.element     // Catch:{ UnityAdsNetworkException -> 0x0217 }
            long r20 = com.unity3d.ads.core.extensions.TimestampExtensionsKt.duration(r14)     // Catch:{ UnityAdsNetworkException -> 0x0217 }
            r1.L$0 = r2     // Catch:{ UnityAdsNetworkException -> 0x0217 }
            r1.L$1 = r3     // Catch:{ UnityAdsNetworkException -> 0x0217 }
            r1.L$2 = r9     // Catch:{ UnityAdsNetworkException -> 0x0217 }
            r1.L$3 = r10     // Catch:{ UnityAdsNetworkException -> 0x0217 }
            r1.L$4 = r11     // Catch:{ UnityAdsNetworkException -> 0x0217 }
            r1.L$5 = r5     // Catch:{ UnityAdsNetworkException -> 0x0217 }
            r1.L$6 = r0     // Catch:{ UnityAdsNetworkException -> 0x0217 }
            r1.J$0 = r12     // Catch:{ UnityAdsNetworkException -> 0x0217 }
            r1.J$1 = r14     // Catch:{ UnityAdsNetworkException -> 0x0217 }
            r22 = r3
            r3 = 2
            r1.label = r3     // Catch:{ UnityAdsNetworkException -> 0x020b }
            r17 = r8
            r8 = r2
            r23 = r9
            r9 = r0
            r24 = r10
            r10 = r17
            r17 = r11
            r25 = r12
            r12 = r20
            r20 = r14
            r14 = r1
            java.lang.Object r8 = r8.sendNetworkSuccessDiagnosticEvent(r9, r10, r11, r12, r14)     // Catch:{ UnityAdsNetworkException -> 0x0209 }
            if (r8 != r4) goto L_0x01f9
            return r4
        L_0x01f9:
            r12 = r5
            r13 = r17
            r15 = r23
            r14 = r24
            r10 = r25
        L_0x0202:
            r3 = r4
            r4 = r12
            r5 = r22
            r8 = 3
            goto L_0x0279
        L_0x0209:
            r0 = move-exception
            goto L_0x0225
        L_0x020b:
            r0 = move-exception
            r23 = r9
            r24 = r10
            r17 = r11
            r25 = r12
            r20 = r14
            goto L_0x0225
        L_0x0217:
            r0 = move-exception
            r22 = r3
            r23 = r9
            r24 = r10
            r17 = r11
            r25 = r12
            r20 = r14
            r3 = 2
        L_0x0225:
            r10 = r5
            r13 = r17
            r8 = r20
            r5 = r22
            r15 = r23
            r14 = r24
            r11 = r25
            goto L_0x0247
        L_0x0233:
            r0 = move-exception
            goto L_0x0238
        L_0x0235:
            r0 = move-exception
            r41 = r1
        L_0x0238:
            r1 = r3
            r3 = 2
            r5 = r41
            r37 = r14
            r14 = r1
            r15 = r2
            r1 = r9
            r2 = r13
            r13 = r4
            r4 = r10
            r10 = r8
            r8 = r37
        L_0x0247:
            int r3 = r10.element
            long r24 = com.unity3d.ads.core.extensions.TimestampExtensionsKt.duration(r8)
            r1.L$0 = r2
            r1.L$1 = r5
            r1.L$2 = r15
            r1.L$3 = r14
            r1.L$4 = r13
            r1.L$5 = r10
            r1.L$6 = r0
            r1.J$0 = r11
            r8 = 3
            r1.label = r8
            r20 = r2
            r21 = r0
            r22 = r3
            r23 = r13
            r26 = r1
            java.lang.Object r3 = r20.sendNetworkErrorDiagnosticEvent(r21, r22, r23, r24, r26)
            if (r3 != r4) goto L_0x0271
            return r4
        L_0x0271:
            r3 = r4
            r4 = r0
        L_0x0273:
            com.unity3d.services.core.network.model.HttpResponse r0 = com.unity3d.services.core.network.model.HttpResponseKt.toHttpResponse(r4)
            r4 = r10
            r10 = r11
        L_0x0279:
            int r9 = r0.getStatusCode()
            boolean r9 = r2.shouldRetry(r9)
            r12 = 0
            if (r9 != 0) goto L_0x02d3
            boolean r5 = com.unity3d.services.core.network.model.HttpResponseKt.isSuccessful(r0)
            if (r5 == 0) goto L_0x02aa
            gateway.v1.UniversalResponseOuterClass$UniversalResponse r0 = r2.getUniversalResponse(r0)
            com.unity3d.ads.core.domain.HandleGatewayUniversalResponse r2 = r2.handleGatewayUniversalResponse
            r1.L$0 = r0
            r1.L$1 = r12
            r1.L$2 = r12
            r1.L$3 = r12
            r1.L$4 = r12
            r1.L$5 = r12
            r1.L$6 = r12
            r9 = 4
            r1.label = r9
            java.lang.Object r1 = r2.invoke(r0, r1)
            if (r1 != r3) goto L_0x02a8
            return r3
        L_0x02a8:
            r1 = r0
        L_0x02a9:
            return r1
        L_0x02aa:
            com.unity3d.ads.core.data.model.UnityAdsNetworkException r0 = new com.unity3d.ads.core.data.model.UnityAdsNetworkException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r7)
            int r2 = r4.element
            r1.append(r2)
            r1.append(r6)
            r1.append(r10)
            r2 = r19
            r1.append(r2)
            java.lang.String r3 = r1.toString()
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 126(0x7e, float:1.77E-43)
            r11 = 0
            r2 = r0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11)
            throw r0
        L_0x02d3:
            r8 = r19
            r9 = 4
            int r0 = r4.element
            r16 = r13
            long r12 = r2.calculateDelayTime(r14, r0)
            long r10 = r10 + r12
            r1.L$0 = r2
            r1.L$1 = r5
            r1.L$2 = r15
            r1.L$3 = r14
            r0 = r16
            r1.L$4 = r0
            r1.L$5 = r4
            r9 = 0
            r1.L$6 = r9
            r1.J$0 = r10
            r9 = 5
            r1.label = r9
            java.lang.Object r12 = kotlinx.coroutines.DelayKt.delay(r12, r1)
            if (r12 != r3) goto L_0x02fc
            return r3
        L_0x02fc:
            r13 = r2
            r11 = r10
            r2 = r15
            r10 = r3
            r3 = r14
            r37 = r4
            r4 = r0
            r0 = r37
            r38 = r5
            r5 = r1
            r1 = r38
        L_0x030b:
            int r14 = r0.element
            r15 = 1
            int r14 = r14 + r15
            r0.element = r14
            int r14 = r3.getMaxDuration()
            r41 = r10
            long r9 = (long) r14
            int r14 = (r11 > r9 ? 1 : (r11 == r9 ? 0 : -1))
            if (r14 > 0) goto L_0x0323
            r10 = r41
            r9 = r5
            r5 = r8
            r8 = r0
            goto L_0x013d
        L_0x0323:
            com.unity3d.ads.core.data.model.UnityAdsNetworkException r1 = new com.unity3d.ads.core.data.model.UnityAdsNetworkException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r7)
            int r0 = r0.element
            r2.append(r0)
            r2.append(r6)
            r2.append(r11)
            r2.append(r8)
            java.lang.String r19 = r2.toString()
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 126(0x7e, float:1.77E-43)
            r27 = 0
            r18 = r1
            r18.<init>(r19, r20, r21, r22, r23, r24, r25, r26, r27)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.gatewayclient.CommonGatewayClient.request(java.lang.String, gateway.v1.UniversalRequestOuterClass$UniversalRequest, com.unity3d.ads.gatewayclient.RequestPolicy, com.unity3d.ads.core.data.model.OperationType, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final Object sendNetworkErrorDiagnosticEvent(UnityAdsNetworkException unityAdsNetworkException, int i, OperationType operationType, long j, Continuation<? super Unit> continuation) {
        if (operationType == OperationType.UNIVERSAL_EVENT) {
            return Unit.INSTANCE;
        }
        Object invoke$default = SendDiagnosticEvent.DefaultImpls.invoke$default(this.sendDiagnosticEvent, "native_network_failure_time", Boxing.boxLong(j), MapsKt.mutableMapOf(TuplesKt.to("operation", operationType.toString()), TuplesKt.to("retries", String.valueOf(i)), TuplesKt.to("protocol", String.valueOf(unityAdsNetworkException.getProtocol())), TuplesKt.to("network_client", String.valueOf(unityAdsNetworkException.getClient()))), (Map) null, continuation, 8, (Object) null);
        return invoke$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? invoke$default : Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public final Object sendNetworkSuccessDiagnosticEvent(HttpResponse httpResponse, int i, OperationType operationType, long j, Continuation<? super Unit> continuation) {
        if (operationType == OperationType.UNIVERSAL_EVENT) {
            return Unit.INSTANCE;
        }
        Object invoke$default = SendDiagnosticEvent.DefaultImpls.invoke$default(this.sendDiagnosticEvent, "native_network_success_time", Boxing.boxLong(j), MapsKt.mutableMapOf(TuplesKt.to("operation", operationType.toString()), TuplesKt.to("retries", String.valueOf(i)), TuplesKt.to("protocol", httpResponse.getProtocol()), TuplesKt.to("network_client", httpResponse.getClient())), (Map) null, continuation, 8, (Object) null);
        return invoke$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? invoke$default : Unit.INSTANCE;
    }

    private final UniversalResponseOuterClass.UniversalResponse getUniversalResponse(HttpResponse httpResponse) {
        try {
            Object body = httpResponse.getBody();
            if (body instanceof byte[]) {
                UniversalResponseOuterClass.UniversalResponse parseFrom = UniversalResponseOuterClass.UniversalResponse.parseFrom((byte[]) body);
                Intrinsics.checkNotNullExpressionValue(parseFrom, "parseFrom(responseBody)");
                return parseFrom;
            } else if (body instanceof String) {
                UniversalResponseOuterClass.UniversalResponse parseFrom2 = UniversalResponseOuterClass.UniversalResponse.parseFrom(ByteString.copyFromUtf8(httpResponse.getBody().toString()));
                Intrinsics.checkNotNullExpressionValue(parseFrom2, "parseFrom(\n             …ring())\n                )");
                return parseFrom2;
            } else {
                throw new InvalidProtocolBufferException("Could not parse response from gateway service");
            }
        } catch (InvalidProtocolBufferException e) {
            DeviceLog.debug("Failed to parse response from gateway service with exception: %s", e.getLocalizedMessage());
            UniversalResponseKt.Dsl.Companion companion = UniversalResponseKt.Dsl.Companion;
            UniversalResponseOuterClass.UniversalResponse.Builder newBuilder = UniversalResponseOuterClass.UniversalResponse.newBuilder();
            Intrinsics.checkNotNullExpressionValue(newBuilder, "newBuilder()");
            UniversalResponseKt.Dsl _create = companion._create(newBuilder);
            ErrorKt.Dsl.Companion companion2 = ErrorKt.Dsl.Companion;
            ErrorOuterClass.Error.Builder newBuilder2 = ErrorOuterClass.Error.newBuilder();
            Intrinsics.checkNotNullExpressionValue(newBuilder2, "newBuilder()");
            ErrorKt.Dsl _create2 = companion2._create(newBuilder2);
            _create2.setErrorText("ERROR: Could not parse response from gateway service");
            _create.setError(_create2._build());
            return _create._build();
        }
    }

    private final long calculateDelayTime(RequestPolicy requestPolicy, int i) {
        long calculateExponentialBackoff = calculateExponentialBackoff(requestPolicy.getRetryWaitBase(), i);
        return calculateExponentialBackoff + calculateJitter(calculateExponentialBackoff, requestPolicy.getRetryJitterPct());
    }

    private final long calculateExponentialBackoff(int i, int i2) {
        return ((long) i) * ((long) Math.pow(2.0d, (double) i2));
    }

    private final long calculateJitter(long j, float f) {
        long j2 = (long) (((float) j) * f);
        return Random.Default.nextLong(-j2, j2 + 1);
    }
}
