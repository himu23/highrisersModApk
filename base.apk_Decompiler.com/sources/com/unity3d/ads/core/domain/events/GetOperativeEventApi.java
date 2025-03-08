package com.unity3d.ads.core.domain.events;

import com.google.protobuf.ByteString;
import com.unity3d.ads.core.data.model.AdObject;
import com.unity3d.ads.core.data.repository.OperativeEventRepository;
import gateway.v1.OperativeEventRequestOuterClass;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J=\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010HBø\u0001\u0000¢\u0006\u0002\u0010\u0011J)\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\fHBø\u0001\u0000¢\u0006\u0002\u0010\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"Lcom/unity3d/ads/core/domain/events/GetOperativeEventApi;", "", "operativeEventRepository", "Lcom/unity3d/ads/core/data/repository/OperativeEventRepository;", "operativeEventRequest", "Lcom/unity3d/ads/core/domain/events/GetOperativeEventRequest;", "(Lcom/unity3d/ads/core/data/repository/OperativeEventRepository;Lcom/unity3d/ads/core/domain/events/GetOperativeEventRequest;)V", "invoke", "", "operativeEventType", "Lgateway/v1/OperativeEventRequestOuterClass$OperativeEventType;", "opportunityId", "Lcom/google/protobuf/ByteString;", "trackingToken", "additionalEventData", "playerServerId", "", "(Lgateway/v1/OperativeEventRequestOuterClass$OperativeEventType;Lcom/google/protobuf/ByteString;Lcom/google/protobuf/ByteString;Lcom/google/protobuf/ByteString;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "adObject", "Lcom/unity3d/ads/core/data/model/AdObject;", "(Lgateway/v1/OperativeEventRequestOuterClass$OperativeEventType;Lcom/unity3d/ads/core/data/model/AdObject;Lcom/google/protobuf/ByteString;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: GetOperativeEventApi.kt */
public final class GetOperativeEventApi {
    private final OperativeEventRepository operativeEventRepository;
    private final GetOperativeEventRequest operativeEventRequest;

    public GetOperativeEventApi(OperativeEventRepository operativeEventRepository2, GetOperativeEventRequest getOperativeEventRequest) {
        Intrinsics.checkNotNullParameter(operativeEventRepository2, "operativeEventRepository");
        Intrinsics.checkNotNullParameter(getOperativeEventRequest, "operativeEventRequest");
        this.operativeEventRepository = operativeEventRepository2;
        this.operativeEventRequest = getOperativeEventRequest;
    }

    public static /* synthetic */ Object invoke$default(GetOperativeEventApi getOperativeEventApi, OperativeEventRequestOuterClass.OperativeEventType operativeEventType, ByteString byteString, ByteString byteString2, ByteString byteString3, String str, Continuation continuation, int i, Object obj) {
        if ((i & 16) != 0) {
            str = null;
        }
        return getOperativeEventApi.invoke(operativeEventType, byteString, byteString2, byteString3, str, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invoke(gateway.v1.OperativeEventRequestOuterClass.OperativeEventType r9, com.google.protobuf.ByteString r10, com.google.protobuf.ByteString r11, com.google.protobuf.ByteString r12, java.lang.String r13, kotlin.coroutines.Continuation<? super kotlin.Unit> r14) {
        /*
            r8 = this;
            boolean r0 = r14 instanceof com.unity3d.ads.core.domain.events.GetOperativeEventApi$invoke$1
            if (r0 == 0) goto L_0x0014
            r0 = r14
            com.unity3d.ads.core.domain.events.GetOperativeEventApi$invoke$1 r0 = (com.unity3d.ads.core.domain.events.GetOperativeEventApi$invoke$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r14 = r0.label
            int r14 = r14 - r2
            r0.label = r14
            goto L_0x0019
        L_0x0014:
            com.unity3d.ads.core.domain.events.GetOperativeEventApi$invoke$1 r0 = new com.unity3d.ads.core.domain.events.GetOperativeEventApi$invoke$1
            r0.<init>(r8, r14)
        L_0x0019:
            r7 = r0
            java.lang.Object r14 = r7.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r7.label
            r2 = 1
            if (r1 == 0) goto L_0x0037
            if (r1 != r2) goto L_0x002f
            java.lang.Object r9 = r7.L$0
            com.unity3d.ads.core.domain.events.GetOperativeEventApi r9 = (com.unity3d.ads.core.domain.events.GetOperativeEventApi) r9
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x004d
        L_0x002f:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r14)
            com.unity3d.ads.core.domain.events.GetOperativeEventRequest r1 = r8.operativeEventRequest
            r7.L$0 = r8
            r7.label = r2
            r2 = r9
            r3 = r11
            r4 = r10
            r5 = r12
            r6 = r13
            java.lang.Object r14 = r1.invoke(r2, r3, r4, r5, r6, r7)
            if (r14 != r0) goto L_0x004c
            return r0
        L_0x004c:
            r9 = r8
        L_0x004d:
            gateway.v1.OperativeEventRequestOuterClass$OperativeEventRequest r14 = (gateway.v1.OperativeEventRequestOuterClass.OperativeEventRequest) r14
            com.unity3d.ads.core.data.repository.OperativeEventRepository r9 = r9.operativeEventRepository
            r9.addOperativeEvent(r14)
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.events.GetOperativeEventApi.invoke(gateway.v1.OperativeEventRequestOuterClass$OperativeEventType, com.google.protobuf.ByteString, com.google.protobuf.ByteString, com.google.protobuf.ByteString, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object invoke(OperativeEventRequestOuterClass.OperativeEventType operativeEventType, AdObject adObject, ByteString byteString, Continuation<? super Unit> continuation) {
        Object invoke = invoke(operativeEventType, adObject.getOpportunityId(), adObject.getTrackingToken(), byteString, adObject.getPlayerServerId(), continuation);
        return invoke == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? invoke : Unit.INSTANCE;
    }
}
