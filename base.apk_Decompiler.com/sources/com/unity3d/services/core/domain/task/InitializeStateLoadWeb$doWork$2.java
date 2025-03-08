package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.domain.task.InitializeStateLoadWeb;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/Result;", "Lcom/unity3d/services/core/domain/task/InitializeStateLoadWeb$LoadWebResult;", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.unity3d.services.core.domain.task.InitializeStateLoadWeb$doWork$2", f = "InitializeStateLoadWeb.kt", i = {0, 0, 1}, l = {44, 62, 69}, m = "invokeSuspend", n = {"$this$withContext", "request", "request"}, s = {"L$0", "L$3", "L$2"})
/* compiled from: InitializeStateLoadWeb.kt */
final class InitializeStateLoadWeb$doWork$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends InitializeStateLoadWeb.LoadWebResult>>, Object> {
    final /* synthetic */ InitializeStateLoadWeb.Params $params;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ InitializeStateLoadWeb this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InitializeStateLoadWeb$doWork$2(InitializeStateLoadWeb.Params params, InitializeStateLoadWeb initializeStateLoadWeb, Continuation<? super InitializeStateLoadWeb$doWork$2> continuation) {
        super(2, continuation);
        this.$params = params;
        this.this$0 = initializeStateLoadWeb;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        InitializeStateLoadWeb$doWork$2 initializeStateLoadWeb$doWork$2 = new InitializeStateLoadWeb$doWork$2(this.$params, this.this$0, continuation);
        initializeStateLoadWeb$doWork$2.L$0 = obj;
        return initializeStateLoadWeb$doWork$2;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<InitializeStateLoadWeb.LoadWebResult>> continuation) {
        return ((InitializeStateLoadWeb$doWork$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v59, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v25, resolved type: com.unity3d.services.core.network.model.HttpRequest} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v60, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v18, resolved type: com.unity3d.services.core.domain.task.InitializeStateLoadWeb} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v61, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v17, resolved type: com.unity3d.services.core.domain.task.InitializeStateLoadWeb$Params} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v65, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v27, resolved type: com.unity3d.services.core.network.model.HttpRequest} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v66, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v20, resolved type: com.unity3d.services.core.domain.task.InitializeStateLoadWeb} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v67, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v19, resolved type: com.unity3d.services.core.domain.task.InitializeStateLoadWeb$Params} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x012d A[SYNTHETIC, Splitter:B:41:0x012d] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0169 A[Catch:{ CancellationException -> 0x0220, all -> 0x01f3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x018f A[Catch:{ CancellationException -> 0x0220, all -> 0x01f3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x01a2 A[Catch:{ CancellationException -> 0x0220, all -> 0x01f3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x01b9 A[Catch:{ CancellationException -> 0x0220, all -> 0x01f3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x01d9 A[Catch:{ CancellationException -> 0x0220, all -> 0x01f3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0204  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x020b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r35) {
        /*
            r34 = this;
            r9 = r34
            java.lang.String r0 = "Unity Ads init: loading webapp from "
            java.lang.Object r10 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r9.label
            r11 = 3
            r12 = 2
            r2 = 1
            r13 = 0
            if (r1 == 0) goto L_0x0066
            if (r1 == r2) goto L_0x0049
            if (r1 == r12) goto L_0x002a
            if (r1 != r11) goto L_0x0022
            java.lang.Object r0 = r9.L$0
            com.unity3d.services.core.domain.task.InitializeStateLoadWeb$Params r0 = (com.unity3d.services.core.domain.task.InitializeStateLoadWeb.Params) r0
            kotlin.ResultKt.throwOnFailure(r35)     // Catch:{ CancellationException -> 0x0220, all -> 0x01f3 }
            r3 = r0
            r0 = r35
            goto L_0x018c
        L_0x0022:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x002a:
            java.lang.Object r0 = r9.L$2
            r1 = r0
            com.unity3d.services.core.network.model.HttpRequest r1 = (com.unity3d.services.core.network.model.HttpRequest) r1
            java.lang.Object r0 = r9.L$1
            r2 = r0
            com.unity3d.services.core.domain.task.InitializeStateLoadWeb r2 = (com.unity3d.services.core.domain.task.InitializeStateLoadWeb) r2
            java.lang.Object r0 = r9.L$0
            r3 = r0
            com.unity3d.services.core.domain.task.InitializeStateLoadWeb$Params r3 = (com.unity3d.services.core.domain.task.InitializeStateLoadWeb.Params) r3
            kotlin.ResultKt.throwOnFailure(r35)     // Catch:{ all -> 0x0046 }
            r0 = r35
            kotlin.Result r0 = (kotlin.Result) r0     // Catch:{ all -> 0x0046 }
            java.lang.Object r0 = r0.m153unboximpl()     // Catch:{ all -> 0x0046 }
            goto L_0x0150
        L_0x0046:
            r0 = move-exception
            goto L_0x0159
        L_0x0049:
            java.lang.Object r0 = r9.L$3
            r1 = r0
            com.unity3d.services.core.network.model.HttpRequest r1 = (com.unity3d.services.core.network.model.HttpRequest) r1
            java.lang.Object r0 = r9.L$2
            r2 = r0
            com.unity3d.services.core.domain.task.InitializeStateLoadWeb r2 = (com.unity3d.services.core.domain.task.InitializeStateLoadWeb) r2
            java.lang.Object r0 = r9.L$1
            r3 = r0
            com.unity3d.services.core.domain.task.InitializeStateLoadWeb$Params r3 = (com.unity3d.services.core.domain.task.InitializeStateLoadWeb.Params) r3
            java.lang.Object r0 = r9.L$0
            kotlinx.coroutines.CoroutineScope r0 = (kotlinx.coroutines.CoroutineScope) r0
            kotlin.ResultKt.throwOnFailure(r35)     // Catch:{ all -> 0x0063 }
            r0 = r35
            goto L_0x010f
        L_0x0063:
            r0 = move-exception
            goto L_0x011d
        L_0x0066:
            kotlin.ResultKt.throwOnFailure(r35)
            java.lang.Object r1 = r9.L$0
            kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
            com.unity3d.services.core.domain.task.InitializeStateLoadWeb$Params r14 = r9.$params
            com.unity3d.services.core.domain.task.InitializeStateLoadWeb r15 = r9.this$0
            kotlin.Result$Companion r3 = kotlin.Result.Companion     // Catch:{ CancellationException -> 0x0220, all -> 0x01f3 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ CancellationException -> 0x0220, all -> 0x01f3 }
            r3.<init>(r0)     // Catch:{ CancellationException -> 0x0220, all -> 0x01f3 }
            com.unity3d.services.core.configuration.Configuration r0 = r14.getConfig()     // Catch:{ CancellationException -> 0x0220, all -> 0x01f3 }
            java.lang.String r0 = r0.getWebViewUrl()     // Catch:{ CancellationException -> 0x0220, all -> 0x01f3 }
            r3.append(r0)     // Catch:{ CancellationException -> 0x0220, all -> 0x01f3 }
            java.lang.String r0 = r3.toString()     // Catch:{ CancellationException -> 0x0220, all -> 0x01f3 }
            com.unity3d.services.core.log.DeviceLog.info(r0)     // Catch:{ CancellationException -> 0x0220, all -> 0x01f3 }
            com.unity3d.services.core.network.model.HttpRequest r8 = new com.unity3d.services.core.network.model.HttpRequest     // Catch:{ CancellationException -> 0x0220, all -> 0x01f3 }
            com.unity3d.services.core.configuration.Configuration r0 = r14.getConfig()     // Catch:{ CancellationException -> 0x0220, all -> 0x01f3 }
            java.lang.String r0 = r0.getWebViewUrl()     // Catch:{ CancellationException -> 0x0220, all -> 0x01f3 }
            java.lang.String r3 = "params.config.webViewUrl"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)     // Catch:{ CancellationException -> 0x0220, all -> 0x01f3 }
            r18 = 0
            com.unity3d.services.core.network.model.RequestType r19 = com.unity3d.services.core.network.model.RequestType.GET     // Catch:{ CancellationException -> 0x0220, all -> 0x01f3 }
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r30 = 0
            r31 = 0
            r32 = 32762(0x7ffa, float:4.591E-41)
            r33 = 0
            r16 = r8
            r17 = r0
            r16.<init>(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33)     // Catch:{ CancellationException -> 0x0220, all -> 0x01f3 }
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x0118 }
            com.unity3d.services.core.configuration.Configuration r0 = r14.getConfig()     // Catch:{ all -> 0x0118 }
            int r3 = r0.getMaxRetries()     // Catch:{ all -> 0x0118 }
            com.unity3d.services.core.configuration.Configuration r0 = r14.getConfig()     // Catch:{ all -> 0x0118 }
            double r4 = r0.getRetryScalingFactor()     // Catch:{ all -> 0x0118 }
            com.unity3d.services.core.configuration.Configuration r0 = r14.getConfig()     // Catch:{ all -> 0x0118 }
            long r6 = r0.getRetryDelay()     // Catch:{ all -> 0x0118 }
            com.unity3d.services.core.domain.task.InitializationException r0 = new com.unity3d.services.core.domain.task.InitializationException     // Catch:{ all -> 0x0118 }
            com.unity3d.services.core.configuration.ErrorState r11 = com.unity3d.services.core.configuration.ErrorState.NetworkWebviewRequest     // Catch:{ all -> 0x0118 }
            java.lang.Exception r12 = new java.lang.Exception     // Catch:{ all -> 0x0118 }
            r12.<init>()     // Catch:{ all -> 0x0118 }
            com.unity3d.services.core.configuration.Configuration r2 = r14.getConfig()     // Catch:{ all -> 0x0118 }
            r0.<init>(r11, r12, r2)     // Catch:{ all -> 0x0118 }
            java.lang.Exception r0 = (java.lang.Exception) r0     // Catch:{ all -> 0x0118 }
            com.unity3d.services.core.domain.task.InitializeStateLoadWeb$doWork$2$1$webViewDataResult$1$1 r2 = new com.unity3d.services.core.domain.task.InitializeStateLoadWeb$doWork$2$1$webViewDataResult$1$1     // Catch:{ all -> 0x0118 }
            r2.<init>(r15, r8, r13)     // Catch:{ all -> 0x0118 }
            r11 = r2
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11     // Catch:{ all -> 0x0118 }
            r9.L$0 = r1     // Catch:{ all -> 0x0118 }
            r9.L$1 = r14     // Catch:{ all -> 0x0118 }
            r9.L$2 = r15     // Catch:{ all -> 0x0118 }
            r9.L$3 = r8     // Catch:{ all -> 0x0118 }
            r1 = 1
            r9.label = r1     // Catch:{ all -> 0x0118 }
            r1 = r6
            r6 = r0
            r7 = r11
            r11 = r8
            r8 = r34
            java.lang.Object r0 = com.unity3d.services.core.extensions.TaskExtensionsKt.withRetry(r1, r3, r4, r6, r7, r8)     // Catch:{ all -> 0x0116 }
            if (r0 != r10) goto L_0x010c
            return r10
        L_0x010c:
            r1 = r11
            r3 = r14
            r2 = r15
        L_0x010f:
            com.unity3d.services.core.network.model.HttpResponse r0 = (com.unity3d.services.core.network.model.HttpResponse) r0     // Catch:{ all -> 0x0063 }
            java.lang.Object r0 = kotlin.Result.m144constructorimpl(r0)     // Catch:{ all -> 0x0063 }
            goto L_0x0127
        L_0x0116:
            r0 = move-exception
            goto L_0x011a
        L_0x0118:
            r0 = move-exception
            r11 = r8
        L_0x011a:
            r1 = r11
            r3 = r14
            r2 = r15
        L_0x011d:
            kotlin.Result$Companion r4 = kotlin.Result.Companion     // Catch:{ CancellationException -> 0x0220, all -> 0x01f3 }
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)     // Catch:{ CancellationException -> 0x0220, all -> 0x01f3 }
            java.lang.Object r0 = kotlin.Result.m144constructorimpl(r0)     // Catch:{ CancellationException -> 0x0220, all -> 0x01f3 }
        L_0x0127:
            boolean r4 = kotlin.Result.m150isFailureimpl(r0)     // Catch:{ CancellationException -> 0x0220, all -> 0x01f3 }
            if (r4 == 0) goto L_0x01a2
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x0046 }
            com.unity3d.services.core.domain.task.InitializeStateNetworkError r0 = r2.initializeStateNetworkError     // Catch:{ all -> 0x0046 }
            com.unity3d.services.core.domain.task.InitializeStateNetworkError$Params r4 = new com.unity3d.services.core.domain.task.InitializeStateNetworkError$Params     // Catch:{ all -> 0x0046 }
            com.unity3d.services.core.configuration.Configuration r5 = r3.getConfig()     // Catch:{ all -> 0x0046 }
            r4.<init>(r5)     // Catch:{ all -> 0x0046 }
            com.unity3d.services.core.domain.task.BaseParams r4 = (com.unity3d.services.core.domain.task.BaseParams) r4     // Catch:{ all -> 0x0046 }
            r9.L$0 = r3     // Catch:{ all -> 0x0046 }
            r9.L$1 = r2     // Catch:{ all -> 0x0046 }
            r9.L$2 = r1     // Catch:{ all -> 0x0046 }
            r9.L$3 = r13     // Catch:{ all -> 0x0046 }
            r5 = 2
            r9.label = r5     // Catch:{ all -> 0x0046 }
            java.lang.Object r0 = r0.m87invokegIAlus(r4, r9)     // Catch:{ all -> 0x0046 }
            if (r0 != r10) goto L_0x0150
            return r10
        L_0x0150:
            kotlin.Result r0 = kotlin.Result.m143boximpl(r0)     // Catch:{ all -> 0x0046 }
            java.lang.Object r0 = kotlin.Result.m144constructorimpl(r0)     // Catch:{ all -> 0x0046 }
            goto L_0x0163
        L_0x0159:
            kotlin.Result$Companion r4 = kotlin.Result.Companion     // Catch:{ CancellationException -> 0x0220, all -> 0x01f3 }
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)     // Catch:{ CancellationException -> 0x0220, all -> 0x01f3 }
            java.lang.Object r0 = kotlin.Result.m144constructorimpl(r0)     // Catch:{ CancellationException -> 0x0220, all -> 0x01f3 }
        L_0x0163:
            boolean r0 = kotlin.Result.m151isSuccessimpl(r0)     // Catch:{ CancellationException -> 0x0220, all -> 0x01f3 }
            if (r0 == 0) goto L_0x018f
            com.unity3d.services.core.domain.ISDKDispatchers r0 = r2.dispatchers     // Catch:{ CancellationException -> 0x0220, all -> 0x01f3 }
            kotlinx.coroutines.CoroutineDispatcher r0 = r0.getIo()     // Catch:{ CancellationException -> 0x0220, all -> 0x01f3 }
            kotlin.coroutines.CoroutineContext r0 = (kotlin.coroutines.CoroutineContext) r0     // Catch:{ CancellationException -> 0x0220, all -> 0x01f3 }
            com.unity3d.services.core.domain.task.InitializeStateLoadWeb$doWork$2$1$webViewData$1 r4 = new com.unity3d.services.core.domain.task.InitializeStateLoadWeb$doWork$2$1$webViewData$1     // Catch:{ CancellationException -> 0x0220, all -> 0x01f3 }
            r4.<init>(r2, r1, r13)     // Catch:{ CancellationException -> 0x0220, all -> 0x01f3 }
            kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4     // Catch:{ CancellationException -> 0x0220, all -> 0x01f3 }
            r9.L$0 = r3     // Catch:{ CancellationException -> 0x0220, all -> 0x01f3 }
            r9.L$1 = r13     // Catch:{ CancellationException -> 0x0220, all -> 0x01f3 }
            r9.L$2 = r13     // Catch:{ CancellationException -> 0x0220, all -> 0x01f3 }
            r9.L$3 = r13     // Catch:{ CancellationException -> 0x0220, all -> 0x01f3 }
            r1 = 3
            r9.label = r1     // Catch:{ CancellationException -> 0x0220, all -> 0x01f3 }
            java.lang.Object r0 = kotlinx.coroutines.BuildersKt.withContext(r0, r4, r9)     // Catch:{ CancellationException -> 0x0220, all -> 0x01f3 }
            if (r0 != r10) goto L_0x018c
            return r10
        L_0x018c:
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ CancellationException -> 0x0220, all -> 0x01f3 }
            goto L_0x01af
        L_0x018f:
            com.unity3d.services.core.domain.task.InitializationException r0 = new com.unity3d.services.core.domain.task.InitializationException     // Catch:{ CancellationException -> 0x0220, all -> 0x01f3 }
            com.unity3d.services.core.configuration.ErrorState r1 = com.unity3d.services.core.configuration.ErrorState.NetworkWebviewRequest     // Catch:{ CancellationException -> 0x0220, all -> 0x01f3 }
            java.lang.Exception r2 = new java.lang.Exception     // Catch:{ CancellationException -> 0x0220, all -> 0x01f3 }
            java.lang.String r4 = "No connected events within the timeout!"
            r2.<init>(r4)     // Catch:{ CancellationException -> 0x0220, all -> 0x01f3 }
            com.unity3d.services.core.configuration.Configuration r3 = r3.getConfig()     // Catch:{ CancellationException -> 0x0220, all -> 0x01f3 }
            r0.<init>(r1, r2, r3)     // Catch:{ CancellationException -> 0x0220, all -> 0x01f3 }
            throw r0     // Catch:{ CancellationException -> 0x0220, all -> 0x01f3 }
        L_0x01a2:
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ CancellationException -> 0x0220, all -> 0x01f3 }
            com.unity3d.services.core.network.model.HttpResponse r0 = (com.unity3d.services.core.network.model.HttpResponse) r0     // Catch:{ CancellationException -> 0x0220, all -> 0x01f3 }
            java.lang.Object r0 = r0.getBody()     // Catch:{ CancellationException -> 0x0220, all -> 0x01f3 }
            java.lang.String r0 = r0.toString()     // Catch:{ CancellationException -> 0x0220, all -> 0x01f3 }
        L_0x01af:
            com.unity3d.services.core.configuration.Configuration r1 = r3.getConfig()     // Catch:{ CancellationException -> 0x0220, all -> 0x01f3 }
            java.lang.String r1 = r1.getWebViewHash()     // Catch:{ CancellationException -> 0x0220, all -> 0x01f3 }
            if (r1 == 0) goto L_0x01d7
            java.lang.String r2 = com.unity3d.services.core.misc.Utilities.Sha256((java.lang.String) r0)     // Catch:{ CancellationException -> 0x0220, all -> 0x01f3 }
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r1)     // Catch:{ CancellationException -> 0x0220, all -> 0x01f3 }
            if (r2 == 0) goto L_0x01c4
            goto L_0x01d7
        L_0x01c4:
            com.unity3d.services.core.domain.task.InitializationException r0 = new com.unity3d.services.core.domain.task.InitializationException     // Catch:{ CancellationException -> 0x0220, all -> 0x01f3 }
            com.unity3d.services.core.configuration.ErrorState r1 = com.unity3d.services.core.configuration.ErrorState.InvalidHash     // Catch:{ CancellationException -> 0x0220, all -> 0x01f3 }
            java.lang.Exception r2 = new java.lang.Exception     // Catch:{ CancellationException -> 0x0220, all -> 0x01f3 }
            java.lang.String r4 = "Invalid webViewHash"
            r2.<init>(r4)     // Catch:{ CancellationException -> 0x0220, all -> 0x01f3 }
            com.unity3d.services.core.configuration.Configuration r3 = r3.getConfig()     // Catch:{ CancellationException -> 0x0220, all -> 0x01f3 }
            r0.<init>(r1, r2, r3)     // Catch:{ CancellationException -> 0x0220, all -> 0x01f3 }
            throw r0     // Catch:{ CancellationException -> 0x0220, all -> 0x01f3 }
        L_0x01d7:
            if (r1 == 0) goto L_0x01e5
            java.io.File r1 = new java.io.File     // Catch:{ CancellationException -> 0x0220, all -> 0x01f3 }
            java.lang.String r2 = com.unity3d.services.core.properties.SdkProperties.getLocalWebViewFile()     // Catch:{ CancellationException -> 0x0220, all -> 0x01f3 }
            r1.<init>(r2)     // Catch:{ CancellationException -> 0x0220, all -> 0x01f3 }
            com.unity3d.services.core.misc.Utilities.writeFile(r1, r0)     // Catch:{ CancellationException -> 0x0220, all -> 0x01f3 }
        L_0x01e5:
            com.unity3d.services.core.domain.task.InitializeStateLoadWeb$LoadWebResult r1 = new com.unity3d.services.core.domain.task.InitializeStateLoadWeb$LoadWebResult     // Catch:{ CancellationException -> 0x0220, all -> 0x01f3 }
            com.unity3d.services.core.configuration.Configuration r2 = r3.getConfig()     // Catch:{ CancellationException -> 0x0220, all -> 0x01f3 }
            r1.<init>(r2, r0)     // Catch:{ CancellationException -> 0x0220, all -> 0x01f3 }
            java.lang.Object r0 = kotlin.Result.m144constructorimpl(r1)     // Catch:{ CancellationException -> 0x0220, all -> 0x01f3 }
            goto L_0x01fe
        L_0x01f3:
            r0 = move-exception
            kotlin.Result$Companion r1 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            java.lang.Object r0 = kotlin.Result.m144constructorimpl(r0)
        L_0x01fe:
            boolean r1 = kotlin.Result.m151isSuccessimpl(r0)
            if (r1 == 0) goto L_0x020b
            kotlin.Result$Companion r1 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.Result.m144constructorimpl(r0)
            goto L_0x021b
        L_0x020b:
            java.lang.Throwable r1 = kotlin.Result.m147exceptionOrNullimpl(r0)
            if (r1 == 0) goto L_0x021b
            kotlin.Result$Companion r0 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r1)
            java.lang.Object r0 = kotlin.Result.m144constructorimpl(r0)
        L_0x021b:
            kotlin.Result r0 = kotlin.Result.m143boximpl(r0)
            return r0
        L_0x0220:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.core.domain.task.InitializeStateLoadWeb$doWork$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
