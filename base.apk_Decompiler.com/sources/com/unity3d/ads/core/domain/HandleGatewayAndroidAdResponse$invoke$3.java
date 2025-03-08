package com.unity3d.ads.core.domain;

import com.google.protobuf.ByteString;
import com.unity3d.ads.core.data.model.CampaignState;
import gateway.v1.TimestampsKt;
import gateway.v1.TimestampsOuterClass;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0005\u001a\u00020\u00042\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000H@"}, d2 = {"Lkotlin/Pair;", "Lcom/google/protobuf/ByteString;", "", "<name for destructuring parameter 0>", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.unity3d.ads.core.domain.HandleGatewayAndroidAdResponse$invoke$3", f = "HandleGatewayAndroidAdResponse.kt", i = {0, 0}, l = {113, 117}, m = "invokeSuspend", n = {"data", "dataVersion"}, s = {"L$0", "I$0"})
/* compiled from: HandleGatewayAndroidAdResponse.kt */
final class HandleGatewayAndroidAdResponse$invoke$3 extends SuspendLambda implements Function2<Pair<? extends ByteString, ? extends Integer>, Continuation<? super Unit>, Object> {
    final /* synthetic */ ByteString $opportunityId;
    final /* synthetic */ String $placementId;
    int I$0;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ HandleGatewayAndroidAdResponse this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HandleGatewayAndroidAdResponse$invoke$3(HandleGatewayAndroidAdResponse handleGatewayAndroidAdResponse, ByteString byteString, String str, Continuation<? super HandleGatewayAndroidAdResponse$invoke$3> continuation) {
        super(2, continuation);
        this.this$0 = handleGatewayAndroidAdResponse;
        this.$opportunityId = byteString;
        this.$placementId = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        HandleGatewayAndroidAdResponse$invoke$3 handleGatewayAndroidAdResponse$invoke$3 = new HandleGatewayAndroidAdResponse$invoke$3(this.this$0, this.$opportunityId, this.$placementId, continuation);
        handleGatewayAndroidAdResponse$invoke$3.L$0 = obj;
        return handleGatewayAndroidAdResponse$invoke$3;
    }

    public final Object invoke(Pair<? extends ByteString, Integer> pair, Continuation<? super Unit> continuation) {
        return ((HandleGatewayAndroidAdResponse$invoke$3) create(pair, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        ByteString byteString;
        int i;
        CampaignState campaignState;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = this.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            Pair pair = (Pair) this.L$0;
            ByteString byteString2 = (ByteString) pair.component1();
            int intValue = ((Number) pair.component2()).intValue();
            this.L$0 = byteString2;
            this.I$0 = intValue;
            this.label = 1;
            Object state = this.this$0.campaignStateRepository.getState(this.$opportunityId, this);
            if (state == coroutine_suspended) {
                return coroutine_suspended;
            }
            byteString = byteString2;
            i = intValue;
            obj = state;
        } else if (i2 == 1) {
            i = this.I$0;
            ResultKt.throwOnFailure(obj);
            byteString = (ByteString) this.L$0;
        } else if (i2 == 2) {
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        CampaignState campaignState2 = (CampaignState) obj;
        if (campaignState2 == null || (campaignState = CampaignState.copy$default(campaignState2, byteString, i, (String) null, (TimestampsOuterClass.Timestamps) null, (TimestampsOuterClass.Timestamps) null, 28, (Object) null)) == null) {
            String str = this.$placementId;
            TimestampsKt.Dsl.Companion companion = TimestampsKt.Dsl.Companion;
            TimestampsOuterClass.Timestamps.Builder newBuilder = TimestampsOuterClass.Timestamps.newBuilder();
            Intrinsics.checkNotNullExpressionValue(newBuilder, "newBuilder()");
            TimestampsKt.Dsl _create = companion._create(newBuilder);
            Unit unit = Unit.INSTANCE;
            TimestampsOuterClass.Timestamps _build = _create._build();
            TimestampsKt.Dsl.Companion companion2 = TimestampsKt.Dsl.Companion;
            TimestampsOuterClass.Timestamps.Builder newBuilder2 = TimestampsOuterClass.Timestamps.newBuilder();
            Intrinsics.checkNotNullExpressionValue(newBuilder2, "newBuilder()");
            TimestampsKt.Dsl _create2 = companion2._create(newBuilder2);
            Unit unit2 = Unit.INSTANCE;
            campaignState = new CampaignState(byteString, i, str, _build, _create2._build());
        }
        this.L$0 = null;
        this.label = 2;
        if (this.this$0.campaignStateRepository.updateState(this.$opportunityId, campaignState, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }
}
