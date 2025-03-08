package com.unity3d.services.core.domain.task;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/Result;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.unity3d.services.core.domain.task.InitializeSDK$doWork$2", f = "InitializeSDK.kt", i = {0, 1, 1, 2, 3, 3, 4, 4, 4, 5, 5, 5, 7, 7, 7, 8, 8, 8, 9, 10, 11, 11, 12, 13}, l = {43, 48, 50, 55, 57, 62, 66, 69, 74, 77, 92, 95, 103, 106, 109}, m = "invokeSuspend", n = {"$this$withContext", "$this$withContext", "configuration", "resetResult", "$this$withContext", "configuration", "$this$withContext", "configResult", "configuration", "$this$withContext", "configResult", "configuration", "$this$withContext", "configResult", "configuration", "$this$withContext", "configResult", "configuration", "loadCacheResult", "configResult", "configResult", "loadWebResult", "configResult", "configResult"}, s = {"L$0", "L$0", "L$2", "L$0", "L$0", "L$2", "L$0", "L$2", "L$3", "L$0", "L$2", "L$3", "L$0", "L$2", "L$3", "L$0", "L$2", "L$3", "L$0", "L$1", "L$1", "L$2", "L$1", "L$1"})
/* compiled from: InitializeSDK.kt */
final class InitializeSDK$doWork$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Unit>>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ InitializeSDK this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InitializeSDK$doWork$2(InitializeSDK initializeSDK, Continuation<? super InitializeSDK$doWork$2> continuation) {
        super(2, continuation);
        this.this$0 = initializeSDK;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        InitializeSDK$doWork$2 initializeSDK$doWork$2 = new InitializeSDK$doWork$2(this.this$0, continuation);
        initializeSDK$doWork$2.L$0 = obj;
        return initializeSDK$doWork$2;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<Unit>> continuation) {
        return ((InitializeSDK$doWork$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x0298, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x029d, code lost:
        if (kotlin.Result.m150isFailureimpl(r0) == false) goto L_0x02cc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x029f, code lost:
        r2 = com.unity3d.services.core.configuration.ErrorState.LoadCache;
        r5 = kotlin.Result.m147exceptionOrNullimpl(r0);
        r12.L$0 = r0;
        r12.L$1 = null;
        r12.L$2 = null;
        r12.L$3 = null;
        r12.label = 10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x02b5, code lost:
        if (r4.m60executeErrorStateBWLJW6A(r2, r5, r13, r12) != r1) goto L_0x02b8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x02b7, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x02b8, code lost:
        r13 = kotlin.Result.m147exceptionOrNullimpl(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x02bc, code lost:
        if (r13 != null) goto L_0x02cb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x02be, code lost:
        r13 = new java.lang.Exception(com.unity3d.services.core.configuration.ErrorState.LoadCache.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x02cb, code lost:
        throw r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x02cc, code lost:
        kotlin.ResultKt.throwOnFailure(r0);
        r0 = (com.unity3d.services.core.domain.task.InitializeStateLoadCache.LoadCacheResult) r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x02d5, code lost:
        if (r0.getHasHashMismatch() == false) goto L_0x034d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x02df, code lost:
        if (r13.getExperiments().isWebViewAsyncDownloadEnabled() == false) goto L_0x0304;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x02e5, code lost:
        if (r0.getWebViewData() == null) goto L_0x0304;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x02e7, code lost:
        kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r5, new kotlinx.coroutines.CoroutineName("LaunchLoadWeb"), (kotlinx.coroutines.CoroutineStart) null, new com.unity3d.services.core.domain.task.InitializeSDK$doWork$2$1$webViewData$1(r4, r2, (kotlin.coroutines.Continuation<? super com.unity3d.services.core.domain.task.InitializeSDK$doWork$2$1$webViewData$1>) null), 2, (java.lang.Object) null);
        r13 = r0.getWebViewData();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x0304, code lost:
        r13 = r4.initializeStateLoadWeb;
        kotlin.ResultKt.throwOnFailure(r2);
        r12.L$0 = r4;
        r12.L$1 = r2;
        r12.L$2 = null;
        r12.L$3 = null;
        r12.label = 11;
        r13 = r13.m87invokegIAlus(new com.unity3d.services.core.domain.task.InitializeStateLoadWeb.Params((com.unity3d.services.core.configuration.Configuration) r2), r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x0325, code lost:
        if (r13 != r1) goto L_0x0059;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x0327, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x032c, code lost:
        if (kotlin.Result.m150isFailureimpl(r0) == false) goto L_0x0343;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x032e, code lost:
        r13 = com.unity3d.services.core.domain.ResultExtensionsKt.getInitializationExceptionOrThrow(r0);
        r12.L$0 = r4;
        r12.L$1 = r2;
        r12.L$2 = r0;
        r12.label = 12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x0340, code lost:
        if (r4.handleInitializationException(r13, r12) != r1) goto L_0x0343;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x0342, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x0343, code lost:
        kotlin.ResultKt.throwOnFailure(r0);
        r13 = ((com.unity3d.services.core.domain.task.InitializeStateLoadWeb.LoadWebResult) r0).getWebViewDataString();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x034d, code lost:
        r13 = r0.getWebViewData();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x0351, code lost:
        if (r13 == null) goto L_0x03bb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x0353, code lost:
        r0 = r4.initializeStateCreate;
        kotlin.ResultKt.throwOnFailure(r2);
        r12.L$0 = r4;
        r12.L$1 = r2;
        r12.L$2 = null;
        r12.L$3 = null;
        r12.label = 13;
        r13 = r0.m87invokegIAlus(new com.unity3d.services.core.domain.task.InitializeStateCreate.Params((com.unity3d.services.core.configuration.Configuration) r2, r13), r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x0374, code lost:
        if (r13 != r1) goto L_0x0377;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x0376, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x0377, code lost:
        r0 = r2;
        r2 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x037d, code lost:
        if (kotlin.Result.m150isFailureimpl(r13) == false) goto L_0x0392;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x037f, code lost:
        r13 = com.unity3d.services.core.domain.ResultExtensionsKt.getInitializationExceptionOrThrow(r13);
        r12.L$0 = r2;
        r12.L$1 = r0;
        r12.label = 14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x038f, code lost:
        if (r2.handleInitializationException(r13, r12) != r1) goto L_0x0392;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x0391, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x0392, code lost:
        r13 = r2.initializeStateComplete;
        kotlin.ResultKt.throwOnFailure(r0);
        r12.L$0 = null;
        r12.L$1 = null;
        r12.label = 15;
        r13 = r13.m87invokegIAlus(new com.unity3d.services.core.domain.task.InitializeStateComplete.Params((com.unity3d.services.core.configuration.Configuration) r0), r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x03ae, code lost:
        if (r13 != r1) goto L_0x03b1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x03b0, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x03b1, code lost:
        kotlin.ResultKt.throwOnFailure(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x03b4, code lost:
        r13 = kotlin.Result.m144constructorimpl(kotlin.Unit.INSTANCE);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x03c6, code lost:
        throw new java.lang.IllegalStateException("WebView is missing.".toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0059, code lost:
        r0 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x007f, code lost:
        r11 = r0;
        r0 = r13;
        r13 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0109, code lost:
        r11 = r0;
        r0 = r13;
        r13 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0156, code lost:
        r5 = kotlin.Result.m147exceptionOrNullimpl(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x015a, code lost:
        if (r5 == null) goto L_0x016f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x015c, code lost:
        com.unity3d.services.core.log.DeviceLog.debug("Unity Ads Init: Could not load config file from local storage: " + r5.getMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x016f, code lost:
        r0 = new com.unity3d.services.core.configuration.Configuration();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0178, code lost:
        if (kotlin.Result.m150isFailureimpl(r13) == false) goto L_0x017b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x017a, code lost:
        r13 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x017b, code lost:
        r0 = (com.unity3d.services.core.configuration.Configuration) r13;
        r12.L$0 = r4;
        r12.L$1 = r2;
        r12.L$2 = r0;
        r12.label = 2;
        r13 = r2.initializeStateReset.m87invokegIAlus(new com.unity3d.services.core.domain.task.InitializeStateReset.Params(r0), r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0196, code lost:
        if (r13 != r1) goto L_0x0109;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0198, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x019d, code lost:
        if (kotlin.Result.m150isFailureimpl(r0) == false) goto L_0x01c9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x019f, code lost:
        r4 = com.unity3d.services.core.configuration.ErrorState.ResetWebApp;
        r5 = kotlin.Result.m147exceptionOrNullimpl(r0);
        r12.L$0 = r0;
        r12.L$1 = null;
        r12.L$2 = null;
        r12.label = 3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x01b2, code lost:
        if (r2.m60executeErrorStateBWLJW6A(r4, r5, r13, r12) != r1) goto L_0x01b5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x01b4, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x01b5, code lost:
        r13 = kotlin.Result.m147exceptionOrNullimpl(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x01b9, code lost:
        if (r13 != null) goto L_0x01c8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x01bb, code lost:
        r13 = new java.lang.Exception(com.unity3d.services.core.configuration.ErrorState.ResetWebApp.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x01c8, code lost:
        throw r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x01c9, code lost:
        r12.L$0 = r4;
        r12.L$1 = r2;
        r12.L$2 = r13;
        r12.label = 4;
        r0 = r2.initializeStateConfig.m87invokegIAlus(new com.unity3d.services.core.domain.task.InitializeStateConfig.Params(r13), r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x01e1, code lost:
        if (r0 != r1) goto L_0x01e4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x01e3, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x01e4, code lost:
        r5 = r4;
        r4 = r2;
        r2 = r0;
        r0 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x01ec, code lost:
        if (kotlin.Result.m150isFailureimpl(r2) == false) goto L_0x0204;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x01ee, code lost:
        r13 = com.unity3d.services.core.domain.ResultExtensionsKt.getInitializationExceptionOrThrow(r2);
        r12.L$0 = r5;
        r12.L$1 = r4;
        r12.L$2 = r2;
        r12.L$3 = r0;
        r12.label = 5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0201, code lost:
        if (r4.handleInitializationException(r13, r12) != r1) goto L_0x0204;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0203, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x020c, code lost:
        if (r0.getExperiments().isNativeWebViewCacheEnabled() == false) goto L_0x0275;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x020e, code lost:
        r13 = r4.initializeStateCreateWithRemote;
        kotlin.ResultKt.throwOnFailure(r2);
        r12.L$0 = r5;
        r12.L$1 = r4;
        r12.L$2 = r2;
        r12.L$3 = r0;
        r12.label = 6;
        r13 = r13.m87invokegIAlus(new com.unity3d.services.core.domain.task.InitializeStateCreateWithRemote.Params((com.unity3d.services.core.configuration.Configuration) r2), r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x022e, code lost:
        if (r13 != r1) goto L_0x0231;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x0230, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x0235, code lost:
        if (kotlin.Result.m151isSuccessimpl(r13) == false) goto L_0x025e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x0237, code lost:
        r13 = r4.initializeStateComplete;
        kotlin.ResultKt.throwOnFailure(r2);
        r12.L$0 = null;
        r12.L$1 = null;
        r12.L$2 = null;
        r12.L$3 = null;
        r12.label = 7;
        r13 = r13.m87invokegIAlus(new com.unity3d.services.core.domain.task.InitializeStateComplete.Params((com.unity3d.services.core.configuration.Configuration) r2), r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x0256, code lost:
        if (r13 != r1) goto L_0x0259;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x0258, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x0259, code lost:
        kotlin.ResultKt.throwOnFailure(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x025e, code lost:
        r13 = com.unity3d.services.core.domain.ResultExtensionsKt.getInitializationExceptionOrThrow(r13);
        r12.L$0 = r5;
        r12.L$1 = r4;
        r12.L$2 = r2;
        r12.L$3 = r0;
        r12.label = 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x0272, code lost:
        if (r4.handleInitializationException(r13, r12) != r1) goto L_0x0275;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x0274, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x0275, code lost:
        r13 = r4.initializeStateLoadCache;
        kotlin.ResultKt.throwOnFailure(r2);
        r12.L$0 = r5;
        r12.L$1 = r4;
        r12.L$2 = r2;
        r12.L$3 = r0;
        r12.label = 9;
        r13 = r13.m87invokegIAlus(new com.unity3d.services.core.domain.task.InitializeStateLoadCache.Params((com.unity3d.services.core.configuration.Configuration) r2), r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x0296, code lost:
        if (r13 != r1) goto L_0x007f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) {
        /*
            r12 = this;
            java.lang.String r0 = "Unity Ads Init: Could not load config file from local storage: "
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r12.label
            r3 = 0
            switch(r2) {
                case 0: goto L_0x0120;
                case 1: goto L_0x010e;
                case 2: goto L_0x00f4;
                case 3: goto L_0x00e8;
                case 4: goto L_0x00ce;
                case 5: goto L_0x00bb;
                case 6: goto L_0x00a2;
                case 7: goto L_0x0097;
                case 8: goto L_0x0084;
                case 9: goto L_0x0068;
                case 10: goto L_0x005c;
                case 11: goto L_0x0048;
                case 12: goto L_0x003b;
                case 13: goto L_0x002a;
                case 14: goto L_0x001f;
                case 15: goto L_0x0014;
                default: goto L_0x000c;
            }
        L_0x000c:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L_0x0014:
            kotlin.ResultKt.throwOnFailure(r13)     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            kotlin.Result r13 = (kotlin.Result) r13     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            java.lang.Object r13 = r13.m153unboximpl()     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            goto L_0x03b1
        L_0x001f:
            java.lang.Object r0 = r12.L$1
            java.lang.Object r2 = r12.L$0
            com.unity3d.services.core.domain.task.InitializeSDK r2 = (com.unity3d.services.core.domain.task.InitializeSDK) r2
            kotlin.ResultKt.throwOnFailure(r13)     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            goto L_0x0392
        L_0x002a:
            java.lang.Object r0 = r12.L$1
            java.lang.Object r2 = r12.L$0
            com.unity3d.services.core.domain.task.InitializeSDK r2 = (com.unity3d.services.core.domain.task.InitializeSDK) r2
            kotlin.ResultKt.throwOnFailure(r13)     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            kotlin.Result r13 = (kotlin.Result) r13     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            java.lang.Object r13 = r13.m153unboximpl()     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            goto L_0x0379
        L_0x003b:
            java.lang.Object r0 = r12.L$2
            java.lang.Object r2 = r12.L$1
            java.lang.Object r4 = r12.L$0
            com.unity3d.services.core.domain.task.InitializeSDK r4 = (com.unity3d.services.core.domain.task.InitializeSDK) r4
            kotlin.ResultKt.throwOnFailure(r13)     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            goto L_0x0343
        L_0x0048:
            java.lang.Object r0 = r12.L$1
            java.lang.Object r2 = r12.L$0
            com.unity3d.services.core.domain.task.InitializeSDK r2 = (com.unity3d.services.core.domain.task.InitializeSDK) r2
            kotlin.ResultKt.throwOnFailure(r13)     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            kotlin.Result r13 = (kotlin.Result) r13     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            java.lang.Object r13 = r13.m153unboximpl()     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            r4 = r2
            r2 = r0
        L_0x0059:
            r0 = r13
            goto L_0x0328
        L_0x005c:
            java.lang.Object r0 = r12.L$0
            kotlin.ResultKt.throwOnFailure(r13)     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            kotlin.Result r13 = (kotlin.Result) r13     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            r13.m153unboximpl()     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            goto L_0x02b8
        L_0x0068:
            java.lang.Object r0 = r12.L$3
            com.unity3d.services.core.configuration.Configuration r0 = (com.unity3d.services.core.configuration.Configuration) r0
            java.lang.Object r2 = r12.L$2
            java.lang.Object r4 = r12.L$1
            com.unity3d.services.core.domain.task.InitializeSDK r4 = (com.unity3d.services.core.domain.task.InitializeSDK) r4
            java.lang.Object r5 = r12.L$0
            kotlinx.coroutines.CoroutineScope r5 = (kotlinx.coroutines.CoroutineScope) r5
            kotlin.ResultKt.throwOnFailure(r13)     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            kotlin.Result r13 = (kotlin.Result) r13     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            java.lang.Object r13 = r13.m153unboximpl()     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
        L_0x007f:
            r11 = r0
            r0 = r13
            r13 = r11
            goto L_0x0299
        L_0x0084:
            java.lang.Object r0 = r12.L$3
            com.unity3d.services.core.configuration.Configuration r0 = (com.unity3d.services.core.configuration.Configuration) r0
            java.lang.Object r2 = r12.L$2
            java.lang.Object r4 = r12.L$1
            com.unity3d.services.core.domain.task.InitializeSDK r4 = (com.unity3d.services.core.domain.task.InitializeSDK) r4
            java.lang.Object r5 = r12.L$0
            kotlinx.coroutines.CoroutineScope r5 = (kotlinx.coroutines.CoroutineScope) r5
            kotlin.ResultKt.throwOnFailure(r13)     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            goto L_0x0275
        L_0x0097:
            kotlin.ResultKt.throwOnFailure(r13)     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            kotlin.Result r13 = (kotlin.Result) r13     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            java.lang.Object r13 = r13.m153unboximpl()     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            goto L_0x0259
        L_0x00a2:
            java.lang.Object r0 = r12.L$3
            com.unity3d.services.core.configuration.Configuration r0 = (com.unity3d.services.core.configuration.Configuration) r0
            java.lang.Object r2 = r12.L$2
            java.lang.Object r4 = r12.L$1
            com.unity3d.services.core.domain.task.InitializeSDK r4 = (com.unity3d.services.core.domain.task.InitializeSDK) r4
            java.lang.Object r5 = r12.L$0
            kotlinx.coroutines.CoroutineScope r5 = (kotlinx.coroutines.CoroutineScope) r5
            kotlin.ResultKt.throwOnFailure(r13)     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            kotlin.Result r13 = (kotlin.Result) r13     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            java.lang.Object r13 = r13.m153unboximpl()     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            goto L_0x0231
        L_0x00bb:
            java.lang.Object r0 = r12.L$3
            com.unity3d.services.core.configuration.Configuration r0 = (com.unity3d.services.core.configuration.Configuration) r0
            java.lang.Object r2 = r12.L$2
            java.lang.Object r4 = r12.L$1
            com.unity3d.services.core.domain.task.InitializeSDK r4 = (com.unity3d.services.core.domain.task.InitializeSDK) r4
            java.lang.Object r5 = r12.L$0
            kotlinx.coroutines.CoroutineScope r5 = (kotlinx.coroutines.CoroutineScope) r5
            kotlin.ResultKt.throwOnFailure(r13)     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            goto L_0x0204
        L_0x00ce:
            java.lang.Object r0 = r12.L$2
            com.unity3d.services.core.configuration.Configuration r0 = (com.unity3d.services.core.configuration.Configuration) r0
            java.lang.Object r2 = r12.L$1
            com.unity3d.services.core.domain.task.InitializeSDK r2 = (com.unity3d.services.core.domain.task.InitializeSDK) r2
            java.lang.Object r4 = r12.L$0
            kotlinx.coroutines.CoroutineScope r4 = (kotlinx.coroutines.CoroutineScope) r4
            kotlin.ResultKt.throwOnFailure(r13)     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            kotlin.Result r13 = (kotlin.Result) r13     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            java.lang.Object r13 = r13.m153unboximpl()     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            r5 = r4
            r4 = r2
            r2 = r13
            goto L_0x01e8
        L_0x00e8:
            java.lang.Object r0 = r12.L$0
            kotlin.ResultKt.throwOnFailure(r13)     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            kotlin.Result r13 = (kotlin.Result) r13     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            r13.m153unboximpl()     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            goto L_0x01b5
        L_0x00f4:
            java.lang.Object r0 = r12.L$2
            com.unity3d.services.core.configuration.Configuration r0 = (com.unity3d.services.core.configuration.Configuration) r0
            java.lang.Object r2 = r12.L$1
            com.unity3d.services.core.domain.task.InitializeSDK r2 = (com.unity3d.services.core.domain.task.InitializeSDK) r2
            java.lang.Object r4 = r12.L$0
            kotlinx.coroutines.CoroutineScope r4 = (kotlinx.coroutines.CoroutineScope) r4
            kotlin.ResultKt.throwOnFailure(r13)     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            kotlin.Result r13 = (kotlin.Result) r13     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            java.lang.Object r13 = r13.m153unboximpl()     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
        L_0x0109:
            r11 = r0
            r0 = r13
            r13 = r11
            goto L_0x0199
        L_0x010e:
            java.lang.Object r2 = r12.L$1
            com.unity3d.services.core.domain.task.InitializeSDK r2 = (com.unity3d.services.core.domain.task.InitializeSDK) r2
            java.lang.Object r4 = r12.L$0
            kotlinx.coroutines.CoroutineScope r4 = (kotlinx.coroutines.CoroutineScope) r4
            kotlin.ResultKt.throwOnFailure(r13)     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            kotlin.Result r13 = (kotlin.Result) r13     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            java.lang.Object r13 = r13.m153unboximpl()     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            goto L_0x0156
        L_0x0120:
            kotlin.ResultKt.throwOnFailure(r13)
            java.lang.Object r13 = r12.L$0
            kotlinx.coroutines.CoroutineScope r13 = (kotlinx.coroutines.CoroutineScope) r13
            com.unity3d.services.core.domain.task.InitializeSDK r2 = r12.this$0
            kotlin.Result$Companion r4 = kotlin.Result.Companion     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            com.unity3d.services.core.configuration.IInitializeEventsMetricSender r4 = com.unity3d.services.core.configuration.InitializeEventsMetricSender.getInstance()     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            r4.didInitStart()     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            com.unity3d.services.core.lifecycle.CachedLifecycle.register()     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            java.lang.String r4 = "Unity Ads Init: Loading Config File From Local Storage"
            com.unity3d.services.core.log.DeviceLog.debug(r4)     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            com.unity3d.services.core.domain.task.ConfigFileFromLocalStorage r4 = r2.configFileFromLocalStorage     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            com.unity3d.services.core.domain.task.ConfigFileFromLocalStorage$Params r5 = new com.unity3d.services.core.domain.task.ConfigFileFromLocalStorage$Params     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            r5.<init>()     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            com.unity3d.services.core.domain.task.BaseParams r5 = (com.unity3d.services.core.domain.task.BaseParams) r5     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            r12.L$0 = r13     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            r12.L$1 = r2     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            r6 = 1
            r12.label = r6     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            java.lang.Object r4 = r4.m87invokegIAlus(r5, r12)     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            if (r4 != r1) goto L_0x0153
            return r1
        L_0x0153:
            r11 = r4
            r4 = r13
            r13 = r11
        L_0x0156:
            java.lang.Throwable r5 = kotlin.Result.m147exceptionOrNullimpl(r13)     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            if (r5 == 0) goto L_0x016f
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            r6.<init>(r0)     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            java.lang.String r0 = r5.getMessage()     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            r6.append(r0)     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            java.lang.String r0 = r6.toString()     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            com.unity3d.services.core.log.DeviceLog.debug(r0)     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
        L_0x016f:
            com.unity3d.services.core.configuration.Configuration r0 = new com.unity3d.services.core.configuration.Configuration     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            r0.<init>()     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            boolean r5 = kotlin.Result.m150isFailureimpl(r13)     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            if (r5 == 0) goto L_0x017b
            r13 = r0
        L_0x017b:
            r0 = r13
            com.unity3d.services.core.configuration.Configuration r0 = (com.unity3d.services.core.configuration.Configuration) r0     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            com.unity3d.services.core.domain.task.InitializeStateReset r13 = r2.initializeStateReset     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            com.unity3d.services.core.domain.task.InitializeStateReset$Params r5 = new com.unity3d.services.core.domain.task.InitializeStateReset$Params     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            r5.<init>(r0)     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            com.unity3d.services.core.domain.task.BaseParams r5 = (com.unity3d.services.core.domain.task.BaseParams) r5     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            r12.L$0 = r4     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            r12.L$1 = r2     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            r12.L$2 = r0     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            r6 = 2
            r12.label = r6     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            java.lang.Object r13 = r13.m87invokegIAlus(r5, r12)     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            if (r13 != r1) goto L_0x0109
            return r1
        L_0x0199:
            boolean r5 = kotlin.Result.m150isFailureimpl(r0)     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            if (r5 == 0) goto L_0x01c9
            com.unity3d.services.core.configuration.ErrorState r4 = com.unity3d.services.core.configuration.ErrorState.ResetWebApp     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            java.lang.Throwable r5 = kotlin.Result.m147exceptionOrNullimpl(r0)     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            r12.L$0 = r0     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            r12.L$1 = r3     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            r12.L$2 = r3     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            r3 = 3
            r12.label = r3     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            java.lang.Object r13 = r2.m60executeErrorStateBWLJW6A(r4, r5, r13, r12)     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            if (r13 != r1) goto L_0x01b5
            return r1
        L_0x01b5:
            java.lang.Throwable r13 = kotlin.Result.m147exceptionOrNullimpl(r0)     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            if (r13 != 0) goto L_0x01c8
            java.lang.Exception r13 = new java.lang.Exception     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            com.unity3d.services.core.configuration.ErrorState r0 = com.unity3d.services.core.configuration.ErrorState.ResetWebApp     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            java.lang.String r0 = r0.toString()     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            r13.<init>(r0)     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            java.lang.Throwable r13 = (java.lang.Throwable) r13     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
        L_0x01c8:
            throw r13     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
        L_0x01c9:
            com.unity3d.services.core.domain.task.InitializeStateConfig r0 = r2.initializeStateConfig     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            com.unity3d.services.core.domain.task.InitializeStateConfig$Params r5 = new com.unity3d.services.core.domain.task.InitializeStateConfig$Params     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            r5.<init>(r13)     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            com.unity3d.services.core.domain.task.BaseParams r5 = (com.unity3d.services.core.domain.task.BaseParams) r5     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            r12.L$0 = r4     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            r12.L$1 = r2     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            r12.L$2 = r13     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            r6 = 4
            r12.label = r6     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            java.lang.Object r0 = r0.m87invokegIAlus(r5, r12)     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            if (r0 != r1) goto L_0x01e4
            return r1
        L_0x01e4:
            r5 = r4
            r4 = r2
            r2 = r0
            r0 = r13
        L_0x01e8:
            boolean r13 = kotlin.Result.m150isFailureimpl(r2)     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            if (r13 == 0) goto L_0x0204
            com.unity3d.services.core.domain.task.InitializationException r13 = com.unity3d.services.core.domain.ResultExtensionsKt.getInitializationExceptionOrThrow(r2)     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            r12.L$0 = r5     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            r12.L$1 = r4     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            r12.L$2 = r2     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            r12.L$3 = r0     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            r6 = 5
            r12.label = r6     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            java.lang.Object r13 = r4.handleInitializationException(r13, r12)     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            if (r13 != r1) goto L_0x0204
            return r1
        L_0x0204:
            com.unity3d.services.core.configuration.IExperiments r13 = r0.getExperiments()     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            boolean r13 = r13.isNativeWebViewCacheEnabled()     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            if (r13 == 0) goto L_0x0275
            com.unity3d.services.core.domain.task.InitializeStateCreateWithRemote r13 = r4.initializeStateCreateWithRemote     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            com.unity3d.services.core.domain.task.InitializeStateCreateWithRemote$Params r6 = new com.unity3d.services.core.domain.task.InitializeStateCreateWithRemote$Params     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            kotlin.ResultKt.throwOnFailure(r2)     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            r7 = r2
            com.unity3d.services.core.configuration.Configuration r7 = (com.unity3d.services.core.configuration.Configuration) r7     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            r6.<init>(r7)     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            com.unity3d.services.core.domain.task.BaseParams r6 = (com.unity3d.services.core.domain.task.BaseParams) r6     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            r12.L$0 = r5     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            r12.L$1 = r4     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            r12.L$2 = r2     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            r12.L$3 = r0     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            r7 = 6
            r12.label = r7     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            java.lang.Object r13 = r13.m87invokegIAlus(r6, r12)     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            if (r13 != r1) goto L_0x0231
            return r1
        L_0x0231:
            boolean r6 = kotlin.Result.m151isSuccessimpl(r13)     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            if (r6 == 0) goto L_0x025e
            com.unity3d.services.core.domain.task.InitializeStateComplete r13 = r4.initializeStateComplete     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            com.unity3d.services.core.domain.task.InitializeStateComplete$Params r0 = new com.unity3d.services.core.domain.task.InitializeStateComplete$Params     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            kotlin.ResultKt.throwOnFailure(r2)     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            com.unity3d.services.core.configuration.Configuration r2 = (com.unity3d.services.core.configuration.Configuration) r2     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            r0.<init>(r2)     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            com.unity3d.services.core.domain.task.BaseParams r0 = (com.unity3d.services.core.domain.task.BaseParams) r0     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            r12.L$0 = r3     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            r12.L$1 = r3     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            r12.L$2 = r3     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            r12.L$3 = r3     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            r2 = 7
            r12.label = r2     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            java.lang.Object r13 = r13.m87invokegIAlus(r0, r12)     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            if (r13 != r1) goto L_0x0259
            return r1
        L_0x0259:
            kotlin.ResultKt.throwOnFailure(r13)     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            goto L_0x03b4
        L_0x025e:
            com.unity3d.services.core.domain.task.InitializationException r13 = com.unity3d.services.core.domain.ResultExtensionsKt.getInitializationExceptionOrThrow(r13)     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            r12.L$0 = r5     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            r12.L$1 = r4     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            r12.L$2 = r2     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            r12.L$3 = r0     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            r6 = 8
            r12.label = r6     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            java.lang.Object r13 = r4.handleInitializationException(r13, r12)     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            if (r13 != r1) goto L_0x0275
            return r1
        L_0x0275:
            com.unity3d.services.core.domain.task.InitializeStateLoadCache r13 = r4.initializeStateLoadCache     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            com.unity3d.services.core.domain.task.InitializeStateLoadCache$Params r6 = new com.unity3d.services.core.domain.task.InitializeStateLoadCache$Params     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            kotlin.ResultKt.throwOnFailure(r2)     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            r7 = r2
            com.unity3d.services.core.configuration.Configuration r7 = (com.unity3d.services.core.configuration.Configuration) r7     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            r6.<init>(r7)     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            com.unity3d.services.core.domain.task.BaseParams r6 = (com.unity3d.services.core.domain.task.BaseParams) r6     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            r12.L$0 = r5     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            r12.L$1 = r4     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            r12.L$2 = r2     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            r12.L$3 = r0     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            r7 = 9
            r12.label = r7     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            java.lang.Object r13 = r13.m87invokegIAlus(r6, r12)     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            if (r13 != r1) goto L_0x007f
            return r1
        L_0x0299:
            boolean r6 = kotlin.Result.m150isFailureimpl(r0)     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            if (r6 == 0) goto L_0x02cc
            com.unity3d.services.core.configuration.ErrorState r2 = com.unity3d.services.core.configuration.ErrorState.LoadCache     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            java.lang.Throwable r5 = kotlin.Result.m147exceptionOrNullimpl(r0)     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            r12.L$0 = r0     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            r12.L$1 = r3     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            r12.L$2 = r3     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            r12.L$3 = r3     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            r3 = 10
            r12.label = r3     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            java.lang.Object r13 = r4.m60executeErrorStateBWLJW6A(r2, r5, r13, r12)     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            if (r13 != r1) goto L_0x02b8
            return r1
        L_0x02b8:
            java.lang.Throwable r13 = kotlin.Result.m147exceptionOrNullimpl(r0)     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            if (r13 != 0) goto L_0x02cb
            java.lang.Exception r13 = new java.lang.Exception     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            com.unity3d.services.core.configuration.ErrorState r0 = com.unity3d.services.core.configuration.ErrorState.LoadCache     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            java.lang.String r0 = r0.toString()     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            r13.<init>(r0)     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            java.lang.Throwable r13 = (java.lang.Throwable) r13     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
        L_0x02cb:
            throw r13     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
        L_0x02cc:
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            com.unity3d.services.core.domain.task.InitializeStateLoadCache$LoadCacheResult r0 = (com.unity3d.services.core.domain.task.InitializeStateLoadCache.LoadCacheResult) r0     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            boolean r6 = r0.getHasHashMismatch()     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            if (r6 == 0) goto L_0x034d
            com.unity3d.services.core.configuration.IExperiments r13 = r13.getExperiments()     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            boolean r13 = r13.isWebViewAsyncDownloadEnabled()     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            if (r13 == 0) goto L_0x0304
            java.lang.String r13 = r0.getWebViewData()     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            if (r13 == 0) goto L_0x0304
            kotlinx.coroutines.CoroutineName r13 = new kotlinx.coroutines.CoroutineName     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            java.lang.String r6 = "LaunchLoadWeb"
            r13.<init>(r6)     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            r6 = r13
            kotlin.coroutines.CoroutineContext r6 = (kotlin.coroutines.CoroutineContext) r6     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            r7 = 0
            com.unity3d.services.core.domain.task.InitializeSDK$doWork$2$1$webViewData$1 r13 = new com.unity3d.services.core.domain.task.InitializeSDK$doWork$2$1$webViewData$1     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            r13.<init>(r4, r2, r3)     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            r8 = r13
            kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            r9 = 2
            r10 = 0
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r5, r6, r7, r8, r9, r10)     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            java.lang.String r13 = r0.getWebViewData()     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            goto L_0x0353
        L_0x0304:
            com.unity3d.services.core.domain.task.InitializeStateLoadWeb r13 = r4.initializeStateLoadWeb     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            com.unity3d.services.core.domain.task.InitializeStateLoadWeb$Params r0 = new com.unity3d.services.core.domain.task.InitializeStateLoadWeb$Params     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            kotlin.ResultKt.throwOnFailure(r2)     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            r5 = r2
            com.unity3d.services.core.configuration.Configuration r5 = (com.unity3d.services.core.configuration.Configuration) r5     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            r0.<init>(r5)     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            com.unity3d.services.core.domain.task.BaseParams r0 = (com.unity3d.services.core.domain.task.BaseParams) r0     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            r12.L$0 = r4     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            r12.L$1 = r2     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            r12.L$2 = r3     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            r12.L$3 = r3     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            r5 = 11
            r12.label = r5     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            java.lang.Object r13 = r13.m87invokegIAlus(r0, r12)     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            if (r13 != r1) goto L_0x0059
            return r1
        L_0x0328:
            boolean r13 = kotlin.Result.m150isFailureimpl(r0)     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            if (r13 == 0) goto L_0x0343
            com.unity3d.services.core.domain.task.InitializationException r13 = com.unity3d.services.core.domain.ResultExtensionsKt.getInitializationExceptionOrThrow(r0)     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            r12.L$0 = r4     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            r12.L$1 = r2     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            r12.L$2 = r0     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            r5 = 12
            r12.label = r5     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            java.lang.Object r13 = r4.handleInitializationException(r13, r12)     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            if (r13 != r1) goto L_0x0343
            return r1
        L_0x0343:
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            com.unity3d.services.core.domain.task.InitializeStateLoadWeb$LoadWebResult r0 = (com.unity3d.services.core.domain.task.InitializeStateLoadWeb.LoadWebResult) r0     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            java.lang.String r13 = r0.getWebViewDataString()     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            goto L_0x0353
        L_0x034d:
            java.lang.String r13 = r0.getWebViewData()     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            if (r13 == 0) goto L_0x03bb
        L_0x0353:
            com.unity3d.services.core.domain.task.InitializeStateCreate r0 = r4.initializeStateCreate     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            com.unity3d.services.core.domain.task.InitializeStateCreate$Params r5 = new com.unity3d.services.core.domain.task.InitializeStateCreate$Params     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            kotlin.ResultKt.throwOnFailure(r2)     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            r6 = r2
            com.unity3d.services.core.configuration.Configuration r6 = (com.unity3d.services.core.configuration.Configuration) r6     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            r5.<init>(r6, r13)     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            com.unity3d.services.core.domain.task.BaseParams r5 = (com.unity3d.services.core.domain.task.BaseParams) r5     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            r12.L$0 = r4     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            r12.L$1 = r2     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            r12.L$2 = r3     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            r12.L$3 = r3     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            r13 = 13
            r12.label = r13     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            java.lang.Object r13 = r0.m87invokegIAlus(r5, r12)     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            if (r13 != r1) goto L_0x0377
            return r1
        L_0x0377:
            r0 = r2
            r2 = r4
        L_0x0379:
            boolean r4 = kotlin.Result.m150isFailureimpl(r13)     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            if (r4 == 0) goto L_0x0392
            com.unity3d.services.core.domain.task.InitializationException r13 = com.unity3d.services.core.domain.ResultExtensionsKt.getInitializationExceptionOrThrow(r13)     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            r12.L$0 = r2     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            r12.L$1 = r0     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            r4 = 14
            r12.label = r4     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            java.lang.Object r13 = r2.handleInitializationException(r13, r12)     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            if (r13 != r1) goto L_0x0392
            return r1
        L_0x0392:
            com.unity3d.services.core.domain.task.InitializeStateComplete r13 = r2.initializeStateComplete     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            com.unity3d.services.core.domain.task.InitializeStateComplete$Params r2 = new com.unity3d.services.core.domain.task.InitializeStateComplete$Params     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            com.unity3d.services.core.configuration.Configuration r0 = (com.unity3d.services.core.configuration.Configuration) r0     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            r2.<init>(r0)     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            com.unity3d.services.core.domain.task.BaseParams r2 = (com.unity3d.services.core.domain.task.BaseParams) r2     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            r12.L$0 = r3     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            r12.L$1 = r3     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            r0 = 15
            r12.label = r0     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            java.lang.Object r13 = r13.m87invokegIAlus(r2, r12)     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            if (r13 != r1) goto L_0x03b1
            return r1
        L_0x03b1:
            kotlin.ResultKt.throwOnFailure(r13)     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
        L_0x03b4:
            kotlin.Unit r13 = kotlin.Unit.INSTANCE     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            java.lang.Object r13 = kotlin.Result.m144constructorimpl(r13)     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            goto L_0x03d2
        L_0x03bb:
            java.lang.String r13 = "WebView is missing."
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            java.lang.String r13 = r13.toString()     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            r0.<init>(r13)     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
            throw r0     // Catch:{ CancellationException -> 0x03f4, all -> 0x03c7 }
        L_0x03c7:
            r13 = move-exception
            kotlin.Result$Companion r0 = kotlin.Result.Companion
            java.lang.Object r13 = kotlin.ResultKt.createFailure(r13)
            java.lang.Object r13 = kotlin.Result.m144constructorimpl(r13)
        L_0x03d2:
            boolean r0 = kotlin.Result.m151isSuccessimpl(r13)
            if (r0 == 0) goto L_0x03df
            kotlin.Result$Companion r0 = kotlin.Result.Companion
            java.lang.Object r13 = kotlin.Result.m144constructorimpl(r13)
            goto L_0x03ef
        L_0x03df:
            java.lang.Throwable r0 = kotlin.Result.m147exceptionOrNullimpl(r13)
            if (r0 == 0) goto L_0x03ef
            kotlin.Result$Companion r13 = kotlin.Result.Companion
            java.lang.Object r13 = kotlin.ResultKt.createFailure(r0)
            java.lang.Object r13 = kotlin.Result.m144constructorimpl(r13)
        L_0x03ef:
            kotlin.Result r13 = kotlin.Result.m143boximpl(r13)
            return r13
        L_0x03f4:
            r13 = move-exception
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.core.domain.task.InitializeSDK$doWork$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
