package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.domain.task.InitializeStateLoadCache;
import com.unity3d.services.core.log.DeviceLog;
import com.unity3d.services.core.misc.Utilities;
import java.nio.charset.Charset;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/Result;", "Lcom/unity3d/services/core/domain/task/InitializeStateLoadCache$LoadCacheResult;", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.unity3d.services.core.domain.task.InitializeStateLoadCache$doWork$2", f = "InitializeStateLoadCache.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: InitializeStateLoadCache.kt */
final class InitializeStateLoadCache$doWork$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends InitializeStateLoadCache.LoadCacheResult>>, Object> {
    final /* synthetic */ InitializeStateLoadCache.Params $params;
    int label;
    final /* synthetic */ InitializeStateLoadCache this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InitializeStateLoadCache$doWork$2(InitializeStateLoadCache initializeStateLoadCache, InitializeStateLoadCache.Params params, Continuation<? super InitializeStateLoadCache$doWork$2> continuation) {
        super(2, continuation);
        this.this$0 = initializeStateLoadCache;
        this.$params = params;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new InitializeStateLoadCache$doWork$2(this.this$0, this.$params, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<InitializeStateLoadCache.LoadCacheResult>> continuation) {
        return ((InitializeStateLoadCache$doWork$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object obj2;
        InitializeStateLoadCache.LoadCacheResult loadCacheResult;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            InitializeStateLoadCache initializeStateLoadCache = this.this$0;
            InitializeStateLoadCache.Params params = this.$params;
            try {
                Result.Companion companion = Result.Companion;
                DeviceLog.debug("Unity Ads init: check if webapp can be loaded from local cache");
                byte[] access$getWebViewData = initializeStateLoadCache.getWebViewData();
                boolean z = true;
                if (access$getWebViewData == null) {
                    loadCacheResult = new InitializeStateLoadCache.LoadCacheResult(true, (String) null, 2, (DefaultConstructorMarker) null);
                } else {
                    String Sha256 = Utilities.Sha256(access$getWebViewData);
                    Charset forName = Charset.forName("UTF-8");
                    Intrinsics.checkNotNullExpressionValue(forName, "forName(\"UTF-8\")");
                    String str = new String(access$getWebViewData, forName);
                    if (Sha256 != null) {
                        if (Intrinsics.areEqual((Object) Sha256, (Object) params.getConfig().getWebViewHash())) {
                            z = false;
                        }
                    }
                    if (!z) {
                        DeviceLog.info("Unity Ads init: webapp loaded from local cache");
                    }
                    loadCacheResult = new InitializeStateLoadCache.LoadCacheResult(z, str);
                }
                obj2 = Result.m144constructorimpl(loadCacheResult);
            } catch (CancellationException e) {
                throw e;
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj2 = Result.m144constructorimpl(ResultKt.createFailure(th));
            }
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
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
