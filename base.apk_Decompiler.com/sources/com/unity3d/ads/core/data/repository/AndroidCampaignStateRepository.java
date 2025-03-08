package com.unity3d.ads.core.data.repository;

import com.google.protobuf.ByteString;
import com.unity3d.ads.core.data.model.CampaignState;
import com.unity3d.ads.core.domain.GetSharedDataTimestamps;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0011\u0010\t\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0002\u0010\u000bJ\u001b\u0010\f\u001a\u0004\u0018\u00010\b2\u0006\u0010\r\u001a\u00020\u0007H@ø\u0001\u0000¢\u0006\u0002\u0010\u000eJ#\u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00110\u0010H@ø\u0001\u0000¢\u0006\u0002\u0010\u000bJ\u0019\u0010\u0012\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u0007H@ø\u0001\u0000¢\u0006\u0002\u0010\u000eJ\u0019\u0010\u0014\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u0007H@ø\u0001\u0000¢\u0006\u0002\u0010\u000eJ\u0019\u0010\u0015\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u0007H@ø\u0001\u0000¢\u0006\u0002\u0010\u000eJ!\u0010\u0016\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010\u0018R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0019"}, d2 = {"Lcom/unity3d/ads/core/data/repository/AndroidCampaignStateRepository;", "Lcom/unity3d/ads/core/data/repository/CampaignStateRepository;", "getSharedDataTimestamps", "Lcom/unity3d/ads/core/domain/GetSharedDataTimestamps;", "(Lcom/unity3d/ads/core/domain/GetSharedDataTimestamps;)V", "campaignStates", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/google/protobuf/ByteString;", "Lcom/unity3d/ads/core/data/model/CampaignState;", "getCampaignState", "Lgateway/v1/CampaignStateOuterClass$CampaignState;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getState", "opportunityId", "(Lcom/google/protobuf/ByteString;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getStates", "", "Lkotlin/Pair;", "removeState", "", "setLoadTimestamp", "setShowTimestamp", "updateState", "campaignState", "(Lcom/google/protobuf/ByteString;Lcom/unity3d/ads/core/data/model/CampaignState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidCampaignStateRepository.kt */
public final class AndroidCampaignStateRepository implements CampaignStateRepository {
    private final ConcurrentHashMap<ByteString, CampaignState> campaignStates = new ConcurrentHashMap<>();
    private final GetSharedDataTimestamps getSharedDataTimestamps;

    public AndroidCampaignStateRepository(GetSharedDataTimestamps getSharedDataTimestamps2) {
        Intrinsics.checkNotNullParameter(getSharedDataTimestamps2, "getSharedDataTimestamps");
        this.getSharedDataTimestamps = getSharedDataTimestamps2;
    }

    public Object updateState(ByteString byteString, CampaignState campaignState, Continuation<? super Unit> continuation) {
        this.campaignStates.put(byteString, campaignState);
        return Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x009d A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object setShowTimestamp(com.google.protobuf.ByteString r14, kotlin.coroutines.Continuation<? super kotlin.Unit> r15) {
        /*
            r13 = this;
            boolean r0 = r15 instanceof com.unity3d.ads.core.data.repository.AndroidCampaignStateRepository$setShowTimestamp$1
            if (r0 == 0) goto L_0x0014
            r0 = r15
            com.unity3d.ads.core.data.repository.AndroidCampaignStateRepository$setShowTimestamp$1 r0 = (com.unity3d.ads.core.data.repository.AndroidCampaignStateRepository$setShowTimestamp$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r15 = r0.label
            int r15 = r15 - r2
            r0.label = r15
            goto L_0x0019
        L_0x0014:
            com.unity3d.ads.core.data.repository.AndroidCampaignStateRepository$setShowTimestamp$1 r0 = new com.unity3d.ads.core.data.repository.AndroidCampaignStateRepository$setShowTimestamp$1
            r0.<init>(r13, r15)
        L_0x0019:
            java.lang.Object r15 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0056
            if (r2 == r5) goto L_0x004a
            if (r2 == r4) goto L_0x0039
            if (r2 != r3) goto L_0x0031
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x009e
        L_0x0031:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r15)
            throw r14
        L_0x0039:
            java.lang.Object r14 = r0.L$2
            com.unity3d.ads.core.data.model.CampaignState r14 = (com.unity3d.ads.core.data.model.CampaignState) r14
            java.lang.Object r2 = r0.L$1
            com.google.protobuf.ByteString r2 = (com.google.protobuf.ByteString) r2
            java.lang.Object r4 = r0.L$0
            com.unity3d.ads.core.data.repository.AndroidCampaignStateRepository r4 = (com.unity3d.ads.core.data.repository.AndroidCampaignStateRepository) r4
            kotlin.ResultKt.throwOnFailure(r15)
            r5 = r14
            goto L_0x0080
        L_0x004a:
            java.lang.Object r14 = r0.L$1
            com.google.protobuf.ByteString r14 = (com.google.protobuf.ByteString) r14
            java.lang.Object r2 = r0.L$0
            com.unity3d.ads.core.data.repository.AndroidCampaignStateRepository r2 = (com.unity3d.ads.core.data.repository.AndroidCampaignStateRepository) r2
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x0067
        L_0x0056:
            kotlin.ResultKt.throwOnFailure(r15)
            r0.L$0 = r13
            r0.L$1 = r14
            r0.label = r5
            java.lang.Object r15 = r13.getState(r14, r0)
            if (r15 != r1) goto L_0x0066
            return r1
        L_0x0066:
            r2 = r13
        L_0x0067:
            com.unity3d.ads.core.data.model.CampaignState r15 = (com.unity3d.ads.core.data.model.CampaignState) r15
            if (r15 == 0) goto L_0x00a1
            com.unity3d.ads.core.domain.GetSharedDataTimestamps r5 = r2.getSharedDataTimestamps
            r0.L$0 = r2
            r0.L$1 = r14
            r0.L$2 = r15
            r0.label = r4
            java.lang.Object r4 = r5.invoke(r0)
            if (r4 != r1) goto L_0x007c
            return r1
        L_0x007c:
            r5 = r15
            r15 = r4
            r4 = r2
            r2 = r14
        L_0x0080:
            r10 = r15
            gateway.v1.TimestampsOuterClass$Timestamps r10 = (gateway.v1.TimestampsOuterClass.Timestamps) r10
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r11 = 15
            r12 = 0
            com.unity3d.ads.core.data.model.CampaignState r14 = com.unity3d.ads.core.data.model.CampaignState.copy$default(r5, r6, r7, r8, r9, r10, r11, r12)
            r15 = 0
            r0.L$0 = r15
            r0.L$1 = r15
            r0.L$2 = r15
            r0.label = r3
            java.lang.Object r14 = r4.updateState(r2, r14, r0)
            if (r14 != r1) goto L_0x009e
            return r1
        L_0x009e:
            kotlin.Unit r14 = kotlin.Unit.INSTANCE
            return r14
        L_0x00a1:
            kotlin.Unit r14 = kotlin.Unit.INSTANCE
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.data.repository.AndroidCampaignStateRepository.setShowTimestamp(com.google.protobuf.ByteString, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public Object getState(ByteString byteString, Continuation<? super CampaignState> continuation) {
        return this.campaignStates.get(byteString);
    }

    public Object removeState(ByteString byteString, Continuation<? super Unit> continuation) {
        this.campaignStates.remove(byteString);
        return Unit.INSTANCE;
    }

    public Object getStates(Continuation<? super List<? extends Pair<? extends ByteString, CampaignState>>> continuation) {
        return MapsKt.toList(this.campaignStates);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x009d A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object setLoadTimestamp(com.google.protobuf.ByteString r14, kotlin.coroutines.Continuation<? super kotlin.Unit> r15) {
        /*
            r13 = this;
            boolean r0 = r15 instanceof com.unity3d.ads.core.data.repository.AndroidCampaignStateRepository$setLoadTimestamp$1
            if (r0 == 0) goto L_0x0014
            r0 = r15
            com.unity3d.ads.core.data.repository.AndroidCampaignStateRepository$setLoadTimestamp$1 r0 = (com.unity3d.ads.core.data.repository.AndroidCampaignStateRepository$setLoadTimestamp$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r15 = r0.label
            int r15 = r15 - r2
            r0.label = r15
            goto L_0x0019
        L_0x0014:
            com.unity3d.ads.core.data.repository.AndroidCampaignStateRepository$setLoadTimestamp$1 r0 = new com.unity3d.ads.core.data.repository.AndroidCampaignStateRepository$setLoadTimestamp$1
            r0.<init>(r13, r15)
        L_0x0019:
            java.lang.Object r15 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0056
            if (r2 == r5) goto L_0x004a
            if (r2 == r4) goto L_0x0039
            if (r2 != r3) goto L_0x0031
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x009e
        L_0x0031:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r15)
            throw r14
        L_0x0039:
            java.lang.Object r14 = r0.L$2
            com.unity3d.ads.core.data.model.CampaignState r14 = (com.unity3d.ads.core.data.model.CampaignState) r14
            java.lang.Object r2 = r0.L$1
            com.google.protobuf.ByteString r2 = (com.google.protobuf.ByteString) r2
            java.lang.Object r4 = r0.L$0
            com.unity3d.ads.core.data.repository.AndroidCampaignStateRepository r4 = (com.unity3d.ads.core.data.repository.AndroidCampaignStateRepository) r4
            kotlin.ResultKt.throwOnFailure(r15)
            r5 = r14
            goto L_0x0080
        L_0x004a:
            java.lang.Object r14 = r0.L$1
            com.google.protobuf.ByteString r14 = (com.google.protobuf.ByteString) r14
            java.lang.Object r2 = r0.L$0
            com.unity3d.ads.core.data.repository.AndroidCampaignStateRepository r2 = (com.unity3d.ads.core.data.repository.AndroidCampaignStateRepository) r2
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x0067
        L_0x0056:
            kotlin.ResultKt.throwOnFailure(r15)
            r0.L$0 = r13
            r0.L$1 = r14
            r0.label = r5
            java.lang.Object r15 = r13.getState(r14, r0)
            if (r15 != r1) goto L_0x0066
            return r1
        L_0x0066:
            r2 = r13
        L_0x0067:
            com.unity3d.ads.core.data.model.CampaignState r15 = (com.unity3d.ads.core.data.model.CampaignState) r15
            if (r15 == 0) goto L_0x00a1
            com.unity3d.ads.core.domain.GetSharedDataTimestamps r5 = r2.getSharedDataTimestamps
            r0.L$0 = r2
            r0.L$1 = r14
            r0.L$2 = r15
            r0.label = r4
            java.lang.Object r4 = r5.invoke(r0)
            if (r4 != r1) goto L_0x007c
            return r1
        L_0x007c:
            r5 = r15
            r15 = r4
            r4 = r2
            r2 = r14
        L_0x0080:
            r9 = r15
            gateway.v1.TimestampsOuterClass$Timestamps r9 = (gateway.v1.TimestampsOuterClass.Timestamps) r9
            r6 = 0
            r7 = 0
            r8 = 0
            r10 = 0
            r11 = 23
            r12 = 0
            com.unity3d.ads.core.data.model.CampaignState r14 = com.unity3d.ads.core.data.model.CampaignState.copy$default(r5, r6, r7, r8, r9, r10, r11, r12)
            r15 = 0
            r0.L$0 = r15
            r0.L$1 = r15
            r0.L$2 = r15
            r0.label = r3
            java.lang.Object r14 = r4.updateState(r2, r14, r0)
            if (r14 != r1) goto L_0x009e
            return r1
        L_0x009e:
            kotlin.Unit r14 = kotlin.Unit.INSTANCE
            return r14
        L_0x00a1:
            kotlin.Unit r14 = kotlin.Unit.INSTANCE
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.data.repository.AndroidCampaignStateRepository.setLoadTimestamp(com.google.protobuf.ByteString, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object getCampaignState(kotlin.coroutines.Continuation<? super gateway.v1.CampaignStateOuterClass.CampaignState> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof com.unity3d.ads.core.data.repository.AndroidCampaignStateRepository$getCampaignState$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            com.unity3d.ads.core.data.repository.AndroidCampaignStateRepository$getCampaignState$1 r0 = (com.unity3d.ads.core.data.repository.AndroidCampaignStateRepository$getCampaignState$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            com.unity3d.ads.core.data.repository.AndroidCampaignStateRepository$getCampaignState$1 r0 = new com.unity3d.ads.core.data.repository.AndroidCampaignStateRepository$getCampaignState$1
            r0.<init>(r6, r7)
        L_0x0019:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x003e
        L_0x002a:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r7)
            r0.label = r3
            java.lang.Object r7 = r6.getStates(r0)
            if (r7 != r1) goto L_0x003e
            return r1
        L_0x003e:
            java.util.List r7 = (java.util.List) r7
            gateway.v1.CampaignStateKt$Dsl$Companion r0 = gateway.v1.CampaignStateKt.Dsl.Companion
            gateway.v1.CampaignStateOuterClass$CampaignState$Builder r1 = gateway.v1.CampaignStateOuterClass.CampaignState.newBuilder()
            java.lang.String r2 = "newBuilder()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            gateway.v1.CampaignStateKt$Dsl r0 = r0._create(r1)
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.Iterator r7 = r7.iterator()
        L_0x0055:
            boolean r1 = r7.hasNext()
            if (r1 == 0) goto L_0x00c8
            java.lang.Object r1 = r7.next()
            kotlin.Pair r1 = (kotlin.Pair) r1
            java.lang.Object r3 = r1.component1()
            com.google.protobuf.ByteString r3 = (com.google.protobuf.ByteString) r3
            java.lang.Object r1 = r1.component2()
            com.unity3d.ads.core.data.model.CampaignState r1 = (com.unity3d.ads.core.data.model.CampaignState) r1
            gateway.v1.CampaignKt$Dsl$Companion r4 = gateway.v1.CampaignKt.Dsl.Companion
            gateway.v1.CampaignStateOuterClass$Campaign$Builder r5 = gateway.v1.CampaignStateOuterClass.Campaign.newBuilder()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r2)
            gateway.v1.CampaignKt$Dsl r4 = r4._create(r5)
            com.google.protobuf.ByteString r5 = r1.getData()
            r4.setData(r5)
            int r5 = r1.getDataVersion()
            r4.setDataVersion(r5)
            java.lang.String r5 = r1.getPlacementId()
            r4.setPlacementId(r5)
            r4.setImpressionOpportunityId(r3)
            gateway.v1.TimestampsOuterClass$Timestamps r3 = r1.getLoadTimestamp()
            r4.setLoadTimestamp(r3)
            gateway.v1.TimestampsOuterClass$Timestamps r3 = r1.getShowTimestamp()
            boolean r3 = r3.hasTimestamp()
            if (r3 == 0) goto L_0x00aa
            gateway.v1.TimestampsOuterClass$Timestamps r3 = r1.getShowTimestamp()
            r4.setShowTimestamp(r3)
        L_0x00aa:
            gateway.v1.CampaignStateOuterClass$Campaign r3 = r4._build()
            gateway.v1.TimestampsOuterClass$Timestamps r1 = r1.getShowTimestamp()
            boolean r1 = r1.hasTimestamp()
            if (r1 == 0) goto L_0x00c0
            com.google.protobuf.kotlin.DslList r1 = r0.getShownCampaigns()
            r0.addShownCampaigns(r1, r3)
            goto L_0x0055
        L_0x00c0:
            com.google.protobuf.kotlin.DslList r1 = r0.getLoadedCampaigns()
            r0.addLoadedCampaigns(r1, r3)
            goto L_0x0055
        L_0x00c8:
            gateway.v1.CampaignStateOuterClass$CampaignState r7 = r0._build()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.data.repository.AndroidCampaignStateRepository.getCampaignState(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
