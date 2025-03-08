package com.unity3d.ads.core.domain;

import com.unity3d.ads.core.data.repository.DiagnosticEventRepository;
import com.unity3d.ads.core.domain.events.GetDiagnosticEventRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006JO\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0014\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u000e2\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000eHBø\u0001\u0000¢\u0006\u0002\u0010\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Lcom/unity3d/ads/core/domain/AndroidSendDiagnosticEvent;", "Lcom/unity3d/ads/core/domain/SendDiagnosticEvent;", "diagnosticEventRepository", "Lcom/unity3d/ads/core/data/repository/DiagnosticEventRepository;", "getDiagnosticEventRequest", "Lcom/unity3d/ads/core/domain/events/GetDiagnosticEventRequest;", "(Lcom/unity3d/ads/core/data/repository/DiagnosticEventRepository;Lcom/unity3d/ads/core/domain/events/GetDiagnosticEventRequest;)V", "invoke", "", "event", "", "value", "", "tags", "", "intTags", "", "(Ljava/lang/String;Ljava/lang/Long;Ljava/util/Map;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidSendDiagnosticEvent.kt */
public final class AndroidSendDiagnosticEvent implements SendDiagnosticEvent {
    private final DiagnosticEventRepository diagnosticEventRepository;
    private final GetDiagnosticEventRequest getDiagnosticEventRequest;

    public AndroidSendDiagnosticEvent(DiagnosticEventRepository diagnosticEventRepository2, GetDiagnosticEventRequest getDiagnosticEventRequest2) {
        Intrinsics.checkNotNullParameter(diagnosticEventRepository2, "diagnosticEventRepository");
        Intrinsics.checkNotNullParameter(getDiagnosticEventRequest2, "getDiagnosticEventRequest");
        this.diagnosticEventRepository = diagnosticEventRepository2;
        this.getDiagnosticEventRequest = getDiagnosticEventRequest2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object invoke(java.lang.String r8, java.lang.Long r9, java.util.Map<java.lang.String, java.lang.String> r10, java.util.Map<java.lang.String, java.lang.Integer> r11, kotlin.coroutines.Continuation<? super kotlin.Unit> r12) {
        /*
            r7 = this;
            boolean r0 = r12 instanceof com.unity3d.ads.core.domain.AndroidSendDiagnosticEvent$invoke$1
            if (r0 == 0) goto L_0x0014
            r0 = r12
            com.unity3d.ads.core.domain.AndroidSendDiagnosticEvent$invoke$1 r0 = (com.unity3d.ads.core.domain.AndroidSendDiagnosticEvent$invoke$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r12 = r0.label
            int r12 = r12 - r2
            r0.label = r12
            goto L_0x0019
        L_0x0014:
            com.unity3d.ads.core.domain.AndroidSendDiagnosticEvent$invoke$1 r0 = new com.unity3d.ads.core.domain.AndroidSendDiagnosticEvent$invoke$1
            r0.<init>(r7, r12)
        L_0x0019:
            r6 = r0
            java.lang.Object r12 = r6.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 1
            if (r1 == 0) goto L_0x0037
            if (r1 != r2) goto L_0x002f
            java.lang.Object r8 = r6.L$0
            com.unity3d.ads.core.domain.AndroidSendDiagnosticEvent r8 = (com.unity3d.ads.core.domain.AndroidSendDiagnosticEvent) r8
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x0061
        L_0x002f:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r12)
            if (r9 == 0) goto L_0x004e
            java.lang.Number r9 = (java.lang.Number) r9
            long r3 = r9.longValue()
            java.util.concurrent.TimeUnit r9 = java.util.concurrent.TimeUnit.NANOSECONDS
            long r3 = r9.toMillis(r3)
            double r3 = (double) r3
            java.lang.Double r9 = kotlin.coroutines.jvm.internal.Boxing.boxDouble(r3)
            goto L_0x004f
        L_0x004e:
            r9 = 0
        L_0x004f:
            r5 = r9
            com.unity3d.ads.core.domain.events.GetDiagnosticEventRequest r1 = r7.getDiagnosticEventRequest
            r6.L$0 = r7
            r6.label = r2
            r2 = r8
            r3 = r10
            r4 = r11
            java.lang.Object r12 = r1.invoke(r2, r3, r4, r5, r6)
            if (r12 != r0) goto L_0x0060
            return r0
        L_0x0060:
            r8 = r7
        L_0x0061:
            gateway.v1.DiagnosticEventRequestOuterClass$DiagnosticEvent r12 = (gateway.v1.DiagnosticEventRequestOuterClass.DiagnosticEvent) r12
            com.unity3d.ads.core.data.repository.DiagnosticEventRepository r8 = r8.diagnosticEventRepository
            r8.addDiagnosticEvent(r12)
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.AndroidSendDiagnosticEvent.invoke(java.lang.String, java.lang.Long, java.util.Map, java.util.Map, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
