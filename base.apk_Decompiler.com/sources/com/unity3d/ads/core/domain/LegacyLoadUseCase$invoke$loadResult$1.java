package com.unity3d.ads.core.domain;

import android.content.Context;
import com.google.protobuf.ByteString;
import com.unity3d.ads.core.data.model.LoadResult;
import gateway.v1.AdResponseOuterClass;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/unity3d/ads/core/data/model/LoadResult;", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.unity3d.ads.core.domain.LegacyLoadUseCase$invoke$loadResult$1", f = "LegacyLoadUseCase.kt", i = {}, l = {75}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: LegacyLoadUseCase.kt */
final class LegacyLoadUseCase$invoke$loadResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super LoadResult>, Object> {
    final /* synthetic */ AdResponseOuterClass.AdResponse $adResponse;
    final /* synthetic */ Context $context;
    final /* synthetic */ ByteString $opportunityIdByteString;
    final /* synthetic */ String $placement;
    int label;
    final /* synthetic */ LegacyLoadUseCase this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LegacyLoadUseCase$invoke$loadResult$1(LegacyLoadUseCase legacyLoadUseCase, Context context, String str, ByteString byteString, AdResponseOuterClass.AdResponse adResponse, Continuation<? super LegacyLoadUseCase$invoke$loadResult$1> continuation) {
        super(2, continuation);
        this.this$0 = legacyLoadUseCase;
        this.$context = context;
        this.$placement = str;
        this.$opportunityIdByteString = byteString;
        this.$adResponse = adResponse;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LegacyLoadUseCase$invoke$loadResult$1(this.this$0, this.$context, this.$placement, this.$opportunityIdByteString, this.$adResponse, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super LoadResult> continuation) {
        return ((LegacyLoadUseCase$invoke$loadResult$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Load access$getLoad$p = this.this$0.load;
            Context context = this.$context;
            String str = this.$placement;
            ByteString byteString = this.$opportunityIdByteString;
            AdResponseOuterClass.AdResponse adResponse = this.$adResponse;
            Intrinsics.checkNotNullExpressionValue(adResponse, "adResponse");
            this.label = 1;
            obj = access$getLoad$p.invoke(context, str, byteString, adResponse, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return obj;
    }
}
