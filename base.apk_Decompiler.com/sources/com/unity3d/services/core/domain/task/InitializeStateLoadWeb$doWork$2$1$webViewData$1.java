package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.network.model.HttpRequest;
import com.unity3d.services.core.network.model.HttpResponse;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.unity3d.services.core.domain.task.InitializeStateLoadWeb$doWork$2$1$webViewData$1", f = "InitializeStateLoadWeb.kt", i = {}, l = {69}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: InitializeStateLoadWeb.kt */
final class InitializeStateLoadWeb$doWork$2$1$webViewData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ HttpRequest $request;
    int label;
    final /* synthetic */ InitializeStateLoadWeb this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InitializeStateLoadWeb$doWork$2$1$webViewData$1(InitializeStateLoadWeb initializeStateLoadWeb, HttpRequest httpRequest, Continuation<? super InitializeStateLoadWeb$doWork$2$1$webViewData$1> continuation) {
        super(2, continuation);
        this.this$0 = initializeStateLoadWeb;
        this.$request = httpRequest;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new InitializeStateLoadWeb$doWork$2$1$webViewData$1(this.this$0, this.$request, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super String> continuation) {
        return ((InitializeStateLoadWeb$doWork$2$1$webViewData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = this.this$0.httpClient.execute(this.$request, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return ((HttpResponse) obj).getBody().toString();
    }
}
