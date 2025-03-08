package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.domain.task.InitializeStateReset;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/Result;", "Lcom/unity3d/services/core/configuration/Configuration;", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.unity3d.services.core.domain.task.InitializeStateReset$doWork$2", f = "InitializeStateReset.kt", i = {}, l = {39}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: InitializeStateReset.kt */
final class InitializeStateReset$doWork$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Configuration>>, Object> {
    final /* synthetic */ InitializeStateReset.Params $params;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ InitializeStateReset this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InitializeStateReset$doWork$2(InitializeStateReset.Params params, InitializeStateReset initializeStateReset, Continuation<? super InitializeStateReset$doWork$2> continuation) {
        super(2, continuation);
        this.$params = params;
        this.this$0 = initializeStateReset;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new InitializeStateReset$doWork$2(this.$params, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends Configuration>> continuation) {
        return ((InitializeStateReset$doWork$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0079 A[Catch:{ CancellationException -> 0x00e4, all -> 0x00b7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00af A[Catch:{ CancellationException -> 0x00e4, all -> 0x00b7 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r8.label
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L_0x0020
            if (r1 != r3) goto L_0x0018
            java.lang.Object r0 = r8.L$1
            com.unity3d.services.core.domain.task.InitializeStateReset r0 = (com.unity3d.services.core.domain.task.InitializeStateReset) r0
            java.lang.Object r1 = r8.L$0
            com.unity3d.services.core.domain.task.InitializeStateReset$Params r1 = (com.unity3d.services.core.domain.task.InitializeStateReset.Params) r1
            kotlin.ResultKt.throwOnFailure(r9)     // Catch:{ CancellationException -> 0x00e4, all -> 0x00b7 }
            goto L_0x005f
        L_0x0018:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L_0x0020:
            kotlin.ResultKt.throwOnFailure(r9)
            com.unity3d.services.core.domain.task.InitializeStateReset$Params r1 = r8.$params
            com.unity3d.services.core.domain.task.InitializeStateReset r9 = r8.this$0
            kotlin.Result$Companion r4 = kotlin.Result.Companion     // Catch:{ CancellationException -> 0x00e4, all -> 0x00b7 }
            java.lang.String r4 = "Unity Ads init: starting init"
            com.unity3d.services.core.log.DeviceLog.debug(r4)     // Catch:{ CancellationException -> 0x00e4, all -> 0x00b7 }
            com.unity3d.services.core.webview.WebViewApp r4 = com.unity3d.services.core.webview.WebViewApp.getCurrentApp()     // Catch:{ CancellationException -> 0x00e4, all -> 0x00b7 }
            if (r4 == 0) goto L_0x0037
            r4.resetWebViewAppInitialization()     // Catch:{ CancellationException -> 0x00e4, all -> 0x00b7 }
        L_0x0037:
            if (r4 == 0) goto L_0x003e
            com.unity3d.services.core.webview.WebView r5 = r4.getWebView()     // Catch:{ CancellationException -> 0x00e4, all -> 0x00b7 }
            goto L_0x003f
        L_0x003e:
            r5 = r2
        L_0x003f:
            if (r5 == 0) goto L_0x006d
            com.unity3d.services.core.configuration.Configuration r5 = r1.getConfig()     // Catch:{ CancellationException -> 0x00e4, all -> 0x00b7 }
            long r5 = r5.getWebViewAppCreateTimeout()     // Catch:{ CancellationException -> 0x00e4, all -> 0x00b7 }
            com.unity3d.services.core.domain.task.InitializeStateReset$doWork$2$1$success$1 r7 = new com.unity3d.services.core.domain.task.InitializeStateReset$doWork$2$1$success$1     // Catch:{ CancellationException -> 0x00e4, all -> 0x00b7 }
            r7.<init>(r9, r4, r2)     // Catch:{ CancellationException -> 0x00e4, all -> 0x00b7 }
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7     // Catch:{ CancellationException -> 0x00e4, all -> 0x00b7 }
            r8.L$0 = r1     // Catch:{ CancellationException -> 0x00e4, all -> 0x00b7 }
            r8.L$1 = r9     // Catch:{ CancellationException -> 0x00e4, all -> 0x00b7 }
            r8.label = r3     // Catch:{ CancellationException -> 0x00e4, all -> 0x00b7 }
            java.lang.Object r3 = kotlinx.coroutines.TimeoutKt.withTimeoutOrNull(r5, r7, r8)     // Catch:{ CancellationException -> 0x00e4, all -> 0x00b7 }
            if (r3 != r0) goto L_0x005d
            return r0
        L_0x005d:
            r0 = r9
            r9 = r3
        L_0x005f:
            kotlin.Unit r9 = (kotlin.Unit) r9     // Catch:{ CancellationException -> 0x00e4, all -> 0x00b7 }
            if (r9 == 0) goto L_0x0065
            r9 = r0
            goto L_0x006d
        L_0x0065:
            java.lang.Exception r9 = new java.lang.Exception     // Catch:{ CancellationException -> 0x00e4, all -> 0x00b7 }
            java.lang.String r0 = "Reset failed on opening ConditionVariable"
            r9.<init>(r0)     // Catch:{ CancellationException -> 0x00e4, all -> 0x00b7 }
            throw r9     // Catch:{ CancellationException -> 0x00e4, all -> 0x00b7 }
        L_0x006d:
            r9.unregisterLifecycleCallbacks()     // Catch:{ CancellationException -> 0x00e4, all -> 0x00b7 }
            com.unity3d.services.core.properties.SdkProperties.setCacheDirectory(r2)     // Catch:{ CancellationException -> 0x00e4, all -> 0x00b7 }
            java.io.File r9 = com.unity3d.services.core.properties.SdkProperties.getCacheDirectory()     // Catch:{ CancellationException -> 0x00e4, all -> 0x00b7 }
            if (r9 == 0) goto L_0x00af
            r9 = 0
            com.unity3d.services.core.properties.SdkProperties.setInitialized(r9)     // Catch:{ CancellationException -> 0x00e4, all -> 0x00b7 }
            com.unity3d.services.core.configuration.Configuration r0 = r1.getConfig()     // Catch:{ CancellationException -> 0x00e4, all -> 0x00b7 }
            java.lang.Class[] r0 = r0.getModuleConfigurationList()     // Catch:{ CancellationException -> 0x00e4, all -> 0x00b7 }
            if (r0 != 0) goto L_0x0089
            java.lang.Class[] r0 = new java.lang.Class[r9]     // Catch:{ CancellationException -> 0x00e4, all -> 0x00b7 }
        L_0x0089:
            int r2 = r0.length     // Catch:{ CancellationException -> 0x00e4, all -> 0x00b7 }
        L_0x008a:
            if (r9 >= r2) goto L_0x00a6
            r3 = r0[r9]     // Catch:{ CancellationException -> 0x00e4, all -> 0x00b7 }
            com.unity3d.services.core.configuration.Configuration r4 = r1.getConfig()     // Catch:{ CancellationException -> 0x00e4, all -> 0x00b7 }
            com.unity3d.services.core.configuration.IModuleConfiguration r3 = r4.getModuleConfiguration(r3)     // Catch:{ CancellationException -> 0x00e4, all -> 0x00b7 }
            if (r3 == 0) goto L_0x00a3
            com.unity3d.services.core.configuration.Configuration r4 = r1.getConfig()     // Catch:{ CancellationException -> 0x00e4, all -> 0x00b7 }
            boolean r3 = r3.resetState(r4)     // Catch:{ CancellationException -> 0x00e4, all -> 0x00b7 }
            kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)     // Catch:{ CancellationException -> 0x00e4, all -> 0x00b7 }
        L_0x00a3:
            int r9 = r9 + 1
            goto L_0x008a
        L_0x00a6:
            com.unity3d.services.core.configuration.Configuration r9 = r1.getConfig()     // Catch:{ CancellationException -> 0x00e4, all -> 0x00b7 }
            java.lang.Object r9 = kotlin.Result.m144constructorimpl(r9)     // Catch:{ CancellationException -> 0x00e4, all -> 0x00b7 }
            goto L_0x00c2
        L_0x00af:
            java.lang.Exception r9 = new java.lang.Exception     // Catch:{ CancellationException -> 0x00e4, all -> 0x00b7 }
            java.lang.String r0 = "Cache directory is NULL"
            r9.<init>(r0)     // Catch:{ CancellationException -> 0x00e4, all -> 0x00b7 }
            throw r9     // Catch:{ CancellationException -> 0x00e4, all -> 0x00b7 }
        L_0x00b7:
            r9 = move-exception
            kotlin.Result$Companion r0 = kotlin.Result.Companion
            java.lang.Object r9 = kotlin.ResultKt.createFailure(r9)
            java.lang.Object r9 = kotlin.Result.m144constructorimpl(r9)
        L_0x00c2:
            boolean r0 = kotlin.Result.m151isSuccessimpl(r9)
            if (r0 == 0) goto L_0x00cf
            kotlin.Result$Companion r0 = kotlin.Result.Companion
            java.lang.Object r9 = kotlin.Result.m144constructorimpl(r9)
            goto L_0x00df
        L_0x00cf:
            java.lang.Throwable r0 = kotlin.Result.m147exceptionOrNullimpl(r9)
            if (r0 == 0) goto L_0x00df
            kotlin.Result$Companion r9 = kotlin.Result.Companion
            java.lang.Object r9 = kotlin.ResultKt.createFailure(r0)
            java.lang.Object r9 = kotlin.Result.m144constructorimpl(r9)
        L_0x00df:
            kotlin.Result r9 = kotlin.Result.m143boximpl(r9)
            return r9
        L_0x00e4:
            r9 = move-exception
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.core.domain.task.InitializeStateReset$doWork$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
