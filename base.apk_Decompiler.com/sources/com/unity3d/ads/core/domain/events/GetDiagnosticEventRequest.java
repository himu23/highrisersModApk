package com.unity3d.ads.core.domain.events;

import com.unity3d.ads.core.domain.GetSharedDataTimestamps;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004JO\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\n2\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\f\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHBø\u0001\u0000¢\u0006\u0002\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"Lcom/unity3d/ads/core/domain/events/GetDiagnosticEventRequest;", "", "getSharedDataTimestamps", "Lcom/unity3d/ads/core/domain/GetSharedDataTimestamps;", "(Lcom/unity3d/ads/core/domain/GetSharedDataTimestamps;)V", "invoke", "Lgateway/v1/DiagnosticEventRequestOuterClass$DiagnosticEvent;", "eventName", "", "tags", "", "intTags", "", "value", "", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/lang/Double;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: GetDiagnosticEventRequest.kt */
public final class GetDiagnosticEventRequest {
    private final GetSharedDataTimestamps getSharedDataTimestamps;

    public GetDiagnosticEventRequest(GetSharedDataTimestamps getSharedDataTimestamps2) {
        Intrinsics.checkNotNullParameter(getSharedDataTimestamps2, "getSharedDataTimestamps");
        this.getSharedDataTimestamps = getSharedDataTimestamps2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00a3  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invoke(java.lang.String r7, java.util.Map<java.lang.String, java.lang.String> r8, java.util.Map<java.lang.String, java.lang.Integer> r9, java.lang.Double r10, kotlin.coroutines.Continuation<? super gateway.v1.DiagnosticEventRequestOuterClass.DiagnosticEvent> r11) {
        /*
            r6 = this;
            boolean r0 = r11 instanceof com.unity3d.ads.core.domain.events.GetDiagnosticEventRequest$invoke$1
            if (r0 == 0) goto L_0x0014
            r0 = r11
            com.unity3d.ads.core.domain.events.GetDiagnosticEventRequest$invoke$1 r0 = (com.unity3d.ads.core.domain.events.GetDiagnosticEventRequest$invoke$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L_0x0019
        L_0x0014:
            com.unity3d.ads.core.domain.events.GetDiagnosticEventRequest$invoke$1 r0 = new com.unity3d.ads.core.domain.events.GetDiagnosticEventRequest$invoke$1
            r0.<init>(r6, r11)
        L_0x0019:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0052
            if (r2 != r3) goto L_0x004a
            java.lang.Object r7 = r0.L$6
            gateway.v1.DiagnosticEventKt$Dsl r7 = (gateway.v1.DiagnosticEventKt.Dsl) r7
            java.lang.Object r8 = r0.L$5
            gateway.v1.DiagnosticEventKt$Dsl r8 = (gateway.v1.DiagnosticEventKt.Dsl) r8
            java.lang.Object r9 = r0.L$4
            gateway.v1.DiagnosticEventKt$Dsl r9 = (gateway.v1.DiagnosticEventKt.Dsl) r9
            java.lang.Object r10 = r0.L$3
            java.lang.Double r10 = (java.lang.Double) r10
            java.lang.Object r1 = r0.L$2
            java.util.Map r1 = (java.util.Map) r1
            java.lang.Object r2 = r0.L$1
            java.util.Map r2 = (java.util.Map) r2
            java.lang.Object r0 = r0.L$0
            java.lang.String r0 = (java.lang.String) r0
            kotlin.ResultKt.throwOnFailure(r11)
            r5 = r11
            r11 = r9
            r9 = r1
            r1 = r5
            goto L_0x0087
        L_0x004a:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0052:
            kotlin.ResultKt.throwOnFailure(r11)
            gateway.v1.DiagnosticEventKt$Dsl$Companion r11 = gateway.v1.DiagnosticEventKt.Dsl.Companion
            gateway.v1.DiagnosticEventRequestOuterClass$DiagnosticEvent$Builder r2 = gateway.v1.DiagnosticEventRequestOuterClass.DiagnosticEvent.newBuilder()
            java.lang.String r4 = "newBuilder()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r4)
            gateway.v1.DiagnosticEventKt$Dsl r11 = r11._create(r2)
            gateway.v1.DiagnosticEventRequestOuterClass$DiagnosticEventType r2 = gateway.v1.DiagnosticEventRequestOuterClass.DiagnosticEventType.DIAGNOSTIC_EVENT_TYPE_CUSTOM
            r11.setEventType(r2)
            com.unity3d.ads.core.domain.GetSharedDataTimestamps r2 = r6.getSharedDataTimestamps
            r0.L$0 = r7
            r0.L$1 = r8
            r0.L$2 = r9
            r0.L$3 = r10
            r0.L$4 = r11
            r0.L$5 = r11
            r0.L$6 = r11
            r0.label = r3
            java.lang.Object r0 = r2.invoke(r0)
            if (r0 != r1) goto L_0x0082
            return r1
        L_0x0082:
            r2 = r8
            r8 = r11
            r1 = r0
            r0 = r7
            r7 = r8
        L_0x0087:
            gateway.v1.TimestampsOuterClass$Timestamps r1 = (gateway.v1.TimestampsOuterClass.Timestamps) r1
            r7.setTimestamps(r1)
            r8.setCustomEventType(r0)
            if (r2 == 0) goto L_0x0098
            com.google.protobuf.kotlin.DslMap r7 = r8.getStringTagsMap()
            r8.putAllStringTags(r7, r2)
        L_0x0098:
            if (r9 == 0) goto L_0x00a1
            com.google.protobuf.kotlin.DslMap r7 = r8.getIntTagsMap()
            r8.putAllIntTags(r7, r9)
        L_0x00a1:
            if (r10 == 0) goto L_0x00ac
            java.lang.Number r10 = (java.lang.Number) r10
            double r9 = r10.doubleValue()
            r8.setTimeValue(r9)
        L_0x00ac:
            gateway.v1.DiagnosticEventRequestOuterClass$DiagnosticEvent r7 = r11._build()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.events.GetDiagnosticEventRequest.invoke(java.lang.String, java.util.Map, java.util.Map, java.lang.Double, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
