package com.unity3d.ads.core.domain;

import com.google.protobuf.ByteString;
import com.unity3d.ads.core.data.model.OperationType;
import com.unity3d.ads.gatewayclient.GatewayClient;
import com.unity3d.ads.gatewayclient.RequestPolicy;
import gateway.v1.AdDataRefreshResponseOuterClass;
import gateway.v1.UniversalRequestOuterClass;
import gateway.v1.UniversalResponseOuterClass;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lgateway/v1/AdDataRefreshResponseOuterClass$AdDataRefreshResponse;", "kotlin.jvm.PlatformType", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.unity3d.ads.core.domain.AndroidRefresh$invoke$2", f = "AndroidRefresh.kt", i = {}, l = {21, 23}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: AndroidRefresh.kt */
final class AndroidRefresh$invoke$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super AdDataRefreshResponseOuterClass.AdDataRefreshResponse>, Object> {
    final /* synthetic */ ByteString $adDataRefreshToken;
    final /* synthetic */ ByteString $opportunityId;
    int label;
    final /* synthetic */ AndroidRefresh this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AndroidRefresh$invoke$2(AndroidRefresh androidRefresh, ByteString byteString, ByteString byteString2, Continuation<? super AndroidRefresh$invoke$2> continuation) {
        super(2, continuation);
        this.this$0 = androidRefresh;
        this.$adDataRefreshToken = byteString;
        this.$opportunityId = byteString2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AndroidRefresh$invoke$2(this.this$0, this.$adDataRefreshToken, this.$opportunityId, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super AdDataRefreshResponseOuterClass.AdDataRefreshResponse> continuation) {
        return ((AndroidRefresh$invoke$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = this.this$0.getAdDataRefreshRequest.invoke(this.$adDataRefreshToken, this.$opportunityId, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else if (i == 2) {
            ResultKt.throwOnFailure(obj);
            return ((UniversalResponseOuterClass.UniversalResponse) obj).getPayload().getAdDataRefreshResponse();
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        RequestPolicy invoke = this.this$0.getRequestPolicy.invoke();
        GatewayClient access$getGatewayClient$p = this.this$0.gatewayClient;
        this.label = 2;
        obj = GatewayClient.DefaultImpls.request$default(access$getGatewayClient$p, (String) null, (UniversalRequestOuterClass.UniversalRequest) obj, invoke, OperationType.REFRESH, this, 1, (Object) null);
        if (obj == coroutine_suspended) {
            return coroutine_suspended;
        }
        return ((UniversalResponseOuterClass.UniversalResponse) obj).getPayload().getAdDataRefreshResponse();
    }
}
