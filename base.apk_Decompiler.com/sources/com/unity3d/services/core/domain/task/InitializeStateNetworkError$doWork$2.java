package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.connectivity.ConnectivityMonitor;
import com.unity3d.services.core.domain.task.InitializeStateNetworkError;
import com.unity3d.services.core.log.DeviceLog;
import java.util.concurrent.CancellationException;
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
import kotlinx.coroutines.TimeoutKt;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/Result;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.unity3d.services.core.domain.task.InitializeStateNetworkError$doWork$2", f = "InitializeStateNetworkError.kt", i = {}, l = {39}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: InitializeStateNetworkError.kt */
final class InitializeStateNetworkError$doWork$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Unit>>, Object> {
    final /* synthetic */ InitializeStateNetworkError.Params $params;
    Object L$0;
    int label;
    final /* synthetic */ InitializeStateNetworkError this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InitializeStateNetworkError$doWork$2(InitializeStateNetworkError initializeStateNetworkError, InitializeStateNetworkError.Params params, Continuation<? super InitializeStateNetworkError$doWork$2> continuation) {
        super(2, continuation);
        this.this$0 = initializeStateNetworkError;
        this.$params = params;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new InitializeStateNetworkError$doWork$2(this.this$0, this.$params, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<Unit>> continuation) {
        return ((InitializeStateNetworkError$doWork$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object obj2;
        InitializeStateNetworkError initializeStateNetworkError;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            InitializeStateNetworkError initializeStateNetworkError2 = this.this$0;
            InitializeStateNetworkError.Params params = this.$params;
            Result.Companion companion = Result.Companion;
            DeviceLog.error("Unity Ads init: network error, waiting for connection events");
            initializeStateNetworkError2.maximumConnectedEvents = params.getConfig().getMaximumConnectedEvents();
            initializeStateNetworkError2.connectedEventThreshold = params.getConfig().getConnectedEventThreshold();
            this.L$0 = initializeStateNetworkError2;
            this.label = 1;
            Object withTimeoutOrNull = TimeoutKt.withTimeoutOrNull(params.getConfig().getNetworkErrorTimeout(), new InitializeStateNetworkError$doWork$2$1$success$1(initializeStateNetworkError2, (Continuation<? super InitializeStateNetworkError$doWork$2$1$success$1>) null), this);
            if (withTimeoutOrNull == coroutine_suspended) {
                return coroutine_suspended;
            }
            initializeStateNetworkError = initializeStateNetworkError2;
            obj = withTimeoutOrNull;
        } else if (i == 1) {
            initializeStateNetworkError = (InitializeStateNetworkError) this.L$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (CancellationException e) {
                throw e;
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj2 = Result.m144constructorimpl(ResultKt.createFailure(th));
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (((Unit) obj) != null) {
            obj2 = Result.m144constructorimpl(Unit.INSTANCE);
            if (Result.m151isSuccessimpl(obj2)) {
                Result.Companion companion3 = Result.Companion;
                obj2 = Result.m144constructorimpl(obj2);
            } else {
                Throwable r0 = Result.m147exceptionOrNullimpl(obj2);
                if (r0 != null) {
                    Result.Companion companion4 = Result.Companion;
                    obj2 = Result.m144constructorimpl(ResultKt.createFailure(r0));
                }
            }
            return Result.m143boximpl(obj2);
        }
        ConnectivityMonitor.removeListener(initializeStateNetworkError);
        throw new Exception("No connected events within the timeout!");
    }
}
