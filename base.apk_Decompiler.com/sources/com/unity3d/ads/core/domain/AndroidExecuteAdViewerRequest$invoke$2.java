package com.unity3d.ads.core.domain;

import com.unity3d.services.core.network.model.HttpRequest;
import com.unity3d.services.core.network.model.HttpResponse;
import com.unity3d.services.core.network.model.RequestType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/unity3d/services/core/network/model/HttpResponse;", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.unity3d.ads.core.domain.AndroidExecuteAdViewerRequest$invoke$2", f = "AndroidExecuteAdViewerRequest.kt", i = {}, l = {19}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: AndroidExecuteAdViewerRequest.kt */
final class AndroidExecuteAdViewerRequest$invoke$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super HttpResponse>, Object> {
    final /* synthetic */ Object[] $parameters;
    final /* synthetic */ RequestType $type;
    int label;
    final /* synthetic */ AndroidExecuteAdViewerRequest this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AndroidExecuteAdViewerRequest$invoke$2(AndroidExecuteAdViewerRequest androidExecuteAdViewerRequest, RequestType requestType, Object[] objArr, Continuation<? super AndroidExecuteAdViewerRequest$invoke$2> continuation) {
        super(2, continuation);
        this.this$0 = androidExecuteAdViewerRequest;
        this.$type = requestType;
        this.$parameters = objArr;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AndroidExecuteAdViewerRequest$invoke$2(this.this$0, this.$type, this.$parameters, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super HttpResponse> continuation) {
        return ((AndroidExecuteAdViewerRequest$invoke$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            HttpRequest access$createRequest = this.this$0.createRequest(this.$type, this.$parameters);
            this.label = 1;
            obj = this.this$0.httpClient.execute(access$createRequest, this);
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
