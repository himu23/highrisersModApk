package com.unity3d.ads.core.domain;

import android.content.Context;
import com.google.protobuf.ByteString;
import com.unity3d.ads.core.data.model.LoadResult;
import gateway.v1.AdResponseOuterClass;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/unity3d/ads/core/data/model/LoadResult;", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.unity3d.ads.core.domain.AndroidLoad$invoke$2", f = "AndroidLoad.kt", i = {}, l = {38, 40, 47, 50}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: AndroidLoad.kt */
final class AndroidLoad$invoke$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super LoadResult>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ AdResponseOuterClass.AdResponse $loadAdResponse;
    final /* synthetic */ ByteString $opportunityId;
    final /* synthetic */ String $placement;
    int label;
    final /* synthetic */ AndroidLoad this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AndroidLoad$invoke$2(AndroidLoad androidLoad, AdResponseOuterClass.AdResponse adResponse, String str, ByteString byteString, Context context, Continuation<? super AndroidLoad$invoke$2> continuation) {
        super(2, continuation);
        this.this$0 = androidLoad;
        this.$loadAdResponse = adResponse;
        this.$placement = str;
        this.$opportunityId = byteString;
        this.$context = context;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AndroidLoad$invoke$2(this.this$0, this.$loadAdResponse, this.$placement, this.$opportunityId, this.$context, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super LoadResult> continuation) {
        return ((AndroidLoad$invoke$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x00cd A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00d4  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00ec  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00fc  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0105  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r14) {
        /*
            r13 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r13.label
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L_0x002e
            if (r1 == r5) goto L_0x002a
            if (r1 == r4) goto L_0x0026
            if (r1 == r3) goto L_0x0021
            if (r1 != r2) goto L_0x0019
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x00e8
        L_0x0019:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r0)
            throw r14
        L_0x0021:
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x00ce
        L_0x0026:
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x0099
        L_0x002a:
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x0075
        L_0x002e:
            kotlin.ResultKt.throwOnFailure(r14)
            com.unity3d.ads.core.domain.AndroidLoad r14 = r13.this$0
            com.unity3d.ads.core.data.repository.SessionRepository r14 = r14.sessionRepository
            boolean r14 = r14.isSdkInitialized()
            if (r14 != 0) goto L_0x004a
            com.unity3d.ads.core.data.model.LoadResult$Failure r14 = new com.unity3d.ads.core.data.model.LoadResult$Failure
            com.unity3d.ads.UnityAds$UnityAdsLoadError r7 = com.unity3d.ads.UnityAds.UnityAdsLoadError.INITIALIZE_FAILED
            r8 = 0
            r9 = 0
            r10 = 6
            r11 = 0
            r6 = r14
            r6.<init>(r7, r8, r9, r10, r11)
            return r14
        L_0x004a:
            gateway.v1.AdResponseOuterClass$AdResponse r14 = r13.$loadAdResponse
            com.google.protobuf.ByteString r14 = r14.getAdData()
            boolean r14 = r14.isEmpty()
            if (r14 == 0) goto L_0x00a5
            com.unity3d.ads.core.domain.AndroidLoad r14 = r13.this$0
            com.unity3d.ads.core.data.repository.SessionRepository r14 = r14.sessionRepository
            r14.incrementLoadRequestCount()
            com.unity3d.ads.core.domain.AndroidLoad r14 = r13.this$0
            com.unity3d.ads.core.domain.GetAdRequest r14 = r14.getAdRequest
            java.lang.String r1 = r13.$placement
            com.google.protobuf.ByteString r6 = r13.$opportunityId
            r7 = r13
            kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
            r13.label = r5
            java.lang.Object r14 = r14.invoke(r1, r6, r7)
            if (r14 != r0) goto L_0x0075
            return r0
        L_0x0075:
            r7 = r14
            gateway.v1.UniversalRequestOuterClass$UniversalRequest r7 = (gateway.v1.UniversalRequestOuterClass.UniversalRequest) r7
            com.unity3d.ads.core.domain.AndroidLoad r14 = r13.this$0
            com.unity3d.ads.core.domain.GetRequestPolicy r14 = r14.getRequestPolicy
            com.unity3d.ads.gatewayclient.RequestPolicy r8 = r14.invoke()
            com.unity3d.ads.core.domain.AndroidLoad r14 = r13.this$0
            com.unity3d.ads.gatewayclient.GatewayClient r5 = r14.gatewayClient
            r6 = 0
            com.unity3d.ads.core.data.model.OperationType r9 = com.unity3d.ads.core.data.model.OperationType.LOAD
            r10 = r13
            kotlin.coroutines.Continuation r10 = (kotlin.coroutines.Continuation) r10
            r11 = 1
            r12 = 0
            r13.label = r4
            java.lang.Object r14 = com.unity3d.ads.gatewayclient.GatewayClient.DefaultImpls.request$default(r5, r6, r7, r8, r9, r10, r11, r12)
            if (r14 != r0) goto L_0x0099
            return r0
        L_0x0099:
            gateway.v1.UniversalResponseOuterClass$UniversalResponse r14 = (gateway.v1.UniversalResponseOuterClass.UniversalResponse) r14
            gateway.v1.UniversalResponseOuterClass$UniversalResponse$Payload r14 = r14.getPayload()
            gateway.v1.AdResponseOuterClass$AdResponse r14 = r14.getAdResponse()
        L_0x00a3:
            r6 = r14
            goto L_0x00b1
        L_0x00a5:
            com.unity3d.ads.core.domain.AndroidLoad r14 = r13.this$0
            com.unity3d.ads.core.data.repository.SessionRepository r14 = r14.sessionRepository
            r14.incrementLoadRequestAdmCount()
            gateway.v1.AdResponseOuterClass$AdResponse r14 = r13.$loadAdResponse
            goto L_0x00a3
        L_0x00b1:
            com.unity3d.ads.core.domain.AndroidLoad r14 = r13.this$0
            com.unity3d.ads.core.domain.HandleGatewayAdResponse r4 = r14.handleGatewayAdResponse
            com.google.protobuf.ByteString r5 = r13.$opportunityId
            java.lang.String r14 = "response"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r14)
            android.content.Context r7 = r13.$context
            java.lang.String r8 = r13.$placement
            r9 = r13
            kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9
            r13.label = r3
            java.lang.Object r14 = r4.invoke(r5, r6, r7, r8, r9)
            if (r14 != r0) goto L_0x00ce
            return r0
        L_0x00ce:
            com.unity3d.ads.core.data.model.LoadResult r14 = (com.unity3d.ads.core.data.model.LoadResult) r14
            boolean r1 = r14 instanceof com.unity3d.ads.core.data.model.LoadResult.Success
            if (r1 == 0) goto L_0x0105
            com.unity3d.ads.core.domain.AndroidLoad r14 = r13.this$0
            com.unity3d.ads.core.data.repository.AdRepository r14 = r14.adRepository
            com.google.protobuf.ByteString r1 = r13.$opportunityId
            r3 = r13
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            r13.label = r2
            java.lang.Object r14 = r14.getAd(r1, r3)
            if (r14 != r0) goto L_0x00e8
            return r0
        L_0x00e8:
            com.unity3d.ads.core.data.model.AdObject r14 = (com.unity3d.ads.core.data.model.AdObject) r14
            if (r14 != 0) goto L_0x00fc
            com.unity3d.ads.core.data.model.LoadResult$Failure r14 = new com.unity3d.ads.core.data.model.LoadResult$Failure
            com.unity3d.ads.UnityAds$UnityAdsLoadError r1 = com.unity3d.ads.UnityAds.UnityAdsLoadError.INTERNAL_ERROR
            java.lang.String r2 = "[UnityAds] Ad not found"
            r3 = 0
            r4 = 4
            r5 = 0
            r0 = r14
            r0.<init>(r1, r2, r3, r4, r5)
            com.unity3d.ads.core.data.model.LoadResult r14 = (com.unity3d.ads.core.data.model.LoadResult) r14
            goto L_0x0109
        L_0x00fc:
            com.unity3d.ads.core.data.model.LoadResult$Success r0 = new com.unity3d.ads.core.data.model.LoadResult$Success
            r0.<init>(r14)
            r14 = r0
            com.unity3d.ads.core.data.model.LoadResult r14 = (com.unity3d.ads.core.data.model.LoadResult) r14
            goto L_0x0109
        L_0x0105:
            boolean r0 = r14 instanceof com.unity3d.ads.core.data.model.LoadResult.Failure
            if (r0 == 0) goto L_0x010a
        L_0x0109:
            return r14
        L_0x010a:
            kotlin.NoWhenBranchMatchedException r14 = new kotlin.NoWhenBranchMatchedException
            r14.<init>()
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.AndroidLoad$invoke$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
