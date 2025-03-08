package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.domain.task.InitializeStateLoadWeb;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.unity3d.services.core.domain.task.InitializeSDK$doWork$2$1$webViewData$1", f = "InitializeSDK.kt", i = {}, l = {87}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: InitializeSDK.kt */
final class InitializeSDK$doWork$2$1$webViewData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Object $configResult;
    int label;
    final /* synthetic */ InitializeSDK this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InitializeSDK$doWork$2$1$webViewData$1(InitializeSDK initializeSDK, Object obj, Continuation<? super InitializeSDK$doWork$2$1$webViewData$1> continuation) {
        super(2, continuation);
        this.this$0 = initializeSDK;
        this.$configResult = obj;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new InitializeSDK$doWork$2$1$webViewData$1(this.this$0, this.$configResult, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((InitializeSDK$doWork$2$1$webViewData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            InitializeStateLoadWeb access$getInitializeStateLoadWeb$p = this.this$0.initializeStateLoadWeb;
            Object obj2 = this.$configResult;
            ResultKt.throwOnFailure(obj2);
            this.label = 1;
            if (access$getInitializeStateLoadWeb$p.m87invokegIAlus(new InitializeStateLoadWeb.Params((Configuration) obj2), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
            ((Result) obj).m153unboximpl();
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
