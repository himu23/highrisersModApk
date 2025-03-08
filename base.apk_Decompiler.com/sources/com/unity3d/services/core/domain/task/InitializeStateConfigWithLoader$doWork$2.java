package com.unity3d.services.core.domain.task;

import com.unity3d.services.core.configuration.Configuration;
import com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lkotlin/Result;", "Lcom/unity3d/services/core/configuration/Configuration;", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader$doWork$2", f = "InitializeStateConfigWithLoader.kt", i = {0, 0, 0, 1, 1, 2}, l = {56, 99, 107}, m = "invokeSuspend", n = {"$this$withContext", "configurationLoader", "config", "configurationLoader", "config", "config"}, s = {"L$0", "L$3", "L$4", "L$2", "L$3", "L$0"})
/* compiled from: InitializeStateConfigWithLoader.kt */
final class InitializeStateConfigWithLoader$doWork$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends Configuration>>, Object> {
    final /* synthetic */ InitializeStateConfigWithLoader.Params $params;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    final /* synthetic */ InitializeStateConfigWithLoader this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InitializeStateConfigWithLoader$doWork$2(InitializeStateConfigWithLoader initializeStateConfigWithLoader, InitializeStateConfigWithLoader.Params params, Continuation<? super InitializeStateConfigWithLoader$doWork$2> continuation) {
        super(2, continuation);
        this.this$0 = initializeStateConfigWithLoader;
        this.$params = params;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        InitializeStateConfigWithLoader$doWork$2 initializeStateConfigWithLoader$doWork$2 = new InitializeStateConfigWithLoader$doWork$2(this.this$0, this.$params, continuation);
        initializeStateConfigWithLoader$doWork$2.L$0 = obj;
        return initializeStateConfigWithLoader$doWork$2;
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends Configuration>> continuation) {
        return ((InitializeStateConfigWithLoader$doWork$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v62, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v25, resolved type: kotlin.jvm.internal.Ref$ObjectRef} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v63, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v29, resolved type: kotlin.jvm.internal.Ref$ObjectRef} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v64, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v17, resolved type: com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader$Params} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v65, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v19, resolved type: com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v68, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v27, resolved type: kotlin.jvm.internal.Ref$ObjectRef} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v69, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v31, resolved type: kotlin.jvm.internal.Ref$ObjectRef} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v70, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v19, resolved type: kotlin.jvm.internal.Ref$ObjectRef} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v71, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v21, resolved type: com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader$Params} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v72, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v9, resolved type: com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader} */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x022e, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x022f, code lost:
        r1 = kotlin.Result.Companion;
        r0 = kotlin.Result.m144constructorimpl(kotlin.ResultKt.createFailure(r0));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x025b, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x025c, code lost:
        throw r0;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:6:0x001d, B:35:0x0162] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0175 A[Catch:{ CancellationException -> 0x025b, all -> 0x022e }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x01c0 A[Catch:{ CancellationException -> 0x025b, all -> 0x022e }] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x01fc A[Catch:{ CancellationException -> 0x025b, all -> 0x022e }] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x021d A[Catch:{ CancellationException -> 0x025b, all -> 0x022e }] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x023f  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0246  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r19) {
        /*
            r18 = this;
            r9 = r18
            java.lang.String r0 = ""
            java.lang.Object r10 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r9.label
            r11 = 3
            r12 = 2
            r2 = 1
            if (r1 == 0) goto L_0x0073
            if (r1 == r2) goto L_0x0053
            if (r1 == r12) goto L_0x002a
            if (r1 != r11) goto L_0x0022
            java.lang.Object r0 = r9.L$1
            kotlin.jvm.internal.Ref$ObjectRef r0 = (kotlin.jvm.internal.Ref.ObjectRef) r0
            java.lang.Object r1 = r9.L$0
            kotlin.jvm.internal.Ref$ObjectRef r1 = (kotlin.jvm.internal.Ref.ObjectRef) r1
            kotlin.ResultKt.throwOnFailure(r19)     // Catch:{ CancellationException -> 0x025b, all -> 0x022e }
            goto L_0x01f2
        L_0x0022:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x002a:
            java.lang.Object r0 = r9.L$4
            r1 = r0
            kotlin.jvm.internal.Ref$ObjectRef r1 = (kotlin.jvm.internal.Ref.ObjectRef) r1
            java.lang.Object r0 = r9.L$3
            r2 = r0
            kotlin.jvm.internal.Ref$ObjectRef r2 = (kotlin.jvm.internal.Ref.ObjectRef) r2
            java.lang.Object r0 = r9.L$2
            r3 = r0
            kotlin.jvm.internal.Ref$ObjectRef r3 = (kotlin.jvm.internal.Ref.ObjectRef) r3
            java.lang.Object r0 = r9.L$1
            r4 = r0
            com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader$Params r4 = (com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader.Params) r4
            java.lang.Object r0 = r9.L$0
            r5 = r0
            com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader r5 = (com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader) r5
            kotlin.ResultKt.throwOnFailure(r19)     // Catch:{ all -> 0x0050 }
            r0 = r19
            kotlin.Result r0 = (kotlin.Result) r0     // Catch:{ all -> 0x0050 }
            java.lang.Object r0 = r0.m153unboximpl()     // Catch:{ all -> 0x0050 }
            goto L_0x01a3
        L_0x0050:
            r0 = move-exception
            goto L_0x01ae
        L_0x0053:
            java.lang.Object r0 = r9.L$4
            r1 = r0
            kotlin.jvm.internal.Ref$ObjectRef r1 = (kotlin.jvm.internal.Ref.ObjectRef) r1
            java.lang.Object r0 = r9.L$3
            r2 = r0
            kotlin.jvm.internal.Ref$ObjectRef r2 = (kotlin.jvm.internal.Ref.ObjectRef) r2
            java.lang.Object r0 = r9.L$2
            r3 = r0
            com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader$Params r3 = (com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader.Params) r3
            java.lang.Object r0 = r9.L$1
            r4 = r0
            com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader r4 = (com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader) r4
            java.lang.Object r0 = r9.L$0
            kotlinx.coroutines.CoroutineScope r0 = (kotlinx.coroutines.CoroutineScope) r0
            kotlin.ResultKt.throwOnFailure(r19)     // Catch:{ all -> 0x0070 }
            goto L_0x0153
        L_0x0070:
            r0 = move-exception
            goto L_0x0162
        L_0x0073:
            kotlin.ResultKt.throwOnFailure(r19)
            java.lang.Object r1 = r9.L$0
            kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
            com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader r14 = r9.this$0
            com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader$Params r15 = r9.$params
            kotlin.Result$Companion r3 = kotlin.Result.Companion     // Catch:{ CancellationException -> 0x025b, all -> 0x022e }
            com.unity3d.services.core.configuration.PrivacyConfigStorage r3 = com.unity3d.services.core.configuration.PrivacyConfigStorage.getInstance()     // Catch:{ CancellationException -> 0x025b, all -> 0x022e }
            com.unity3d.services.core.device.reader.DeviceInfoDataFactory r4 = new com.unity3d.services.core.device.reader.DeviceInfoDataFactory     // Catch:{ CancellationException -> 0x025b, all -> 0x022e }
            com.unity3d.services.core.request.metrics.SDKMetricsSender r5 = r14.sdkMetricsSender     // Catch:{ CancellationException -> 0x025b, all -> 0x022e }
            r4.<init>(r5)     // Catch:{ CancellationException -> 0x025b, all -> 0x022e }
            kotlin.jvm.internal.Ref$ObjectRef r8 = new kotlin.jvm.internal.Ref$ObjectRef     // Catch:{ CancellationException -> 0x025b, all -> 0x022e }
            r8.<init>()     // Catch:{ CancellationException -> 0x025b, all -> 0x022e }
            com.unity3d.services.core.configuration.ConfigurationLoader r5 = new com.unity3d.services.core.configuration.ConfigurationLoader     // Catch:{ CancellationException -> 0x025b, all -> 0x022e }
            com.unity3d.services.core.configuration.ConfigurationRequestFactory r6 = new com.unity3d.services.core.configuration.ConfigurationRequestFactory     // Catch:{ CancellationException -> 0x025b, all -> 0x022e }
            com.unity3d.services.core.configuration.Configuration r7 = r15.getConfig()     // Catch:{ CancellationException -> 0x025b, all -> 0x022e }
            com.unity3d.services.core.configuration.InitRequestType r11 = com.unity3d.services.core.configuration.InitRequestType.TOKEN     // Catch:{ CancellationException -> 0x025b, all -> 0x022e }
            com.unity3d.services.core.device.reader.IDeviceInfoDataContainer r11 = r4.getDeviceInfoData(r11)     // Catch:{ CancellationException -> 0x025b, all -> 0x022e }
            r6.<init>(r7, r11)     // Catch:{ CancellationException -> 0x025b, all -> 0x022e }
            com.unity3d.services.core.request.metrics.SDKMetricsSender r7 = r14.sdkMetricsSender     // Catch:{ CancellationException -> 0x025b, all -> 0x022e }
            r11 = r14
            com.unity3d.services.core.di.IServiceComponent r11 = (com.unity3d.services.core.di.IServiceComponent) r11     // Catch:{ CancellationException -> 0x025b, all -> 0x022e }
            com.unity3d.services.core.di.IServiceProvider r11 = r11.getServiceProvider()     // Catch:{ CancellationException -> 0x025b, all -> 0x022e }
            com.unity3d.services.core.di.IServicesRegistry r11 = r11.getRegistry()     // Catch:{ CancellationException -> 0x025b, all -> 0x022e }
            java.lang.Class<com.unity3d.services.core.network.core.HttpClient> r16 = com.unity3d.services.core.network.core.HttpClient.class
            kotlin.reflect.KClass r12 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r16)     // Catch:{ CancellationException -> 0x025b, all -> 0x022e }
            java.lang.Object r11 = r11.getService(r0, r12)     // Catch:{ CancellationException -> 0x025b, all -> 0x022e }
            com.unity3d.services.core.network.core.HttpClient r11 = (com.unity3d.services.core.network.core.HttpClient) r11     // Catch:{ CancellationException -> 0x025b, all -> 0x022e }
            r5.<init>(r6, r7, r11)     // Catch:{ CancellationException -> 0x025b, all -> 0x022e }
            r8.element = r5     // Catch:{ CancellationException -> 0x025b, all -> 0x022e }
            com.unity3d.services.core.configuration.PrivacyConfigurationLoader r5 = new com.unity3d.services.core.configuration.PrivacyConfigurationLoader     // Catch:{ CancellationException -> 0x025b, all -> 0x022e }
            T r6 = r8.element     // Catch:{ CancellationException -> 0x025b, all -> 0x022e }
            com.unity3d.services.core.configuration.IConfigurationLoader r6 = (com.unity3d.services.core.configuration.IConfigurationLoader) r6     // Catch:{ CancellationException -> 0x025b, all -> 0x022e }
            com.unity3d.services.core.configuration.ConfigurationRequestFactory r7 = new com.unity3d.services.core.configuration.ConfigurationRequestFactory     // Catch:{ CancellationException -> 0x025b, all -> 0x022e }
            com.unity3d.services.core.configuration.Configuration r11 = r15.getConfig()     // Catch:{ CancellationException -> 0x025b, all -> 0x022e }
            com.unity3d.services.core.configuration.InitRequestType r12 = com.unity3d.services.core.configuration.InitRequestType.PRIVACY     // Catch:{ CancellationException -> 0x025b, all -> 0x022e }
            com.unity3d.services.core.device.reader.IDeviceInfoDataContainer r4 = r4.getDeviceInfoData(r12)     // Catch:{ CancellationException -> 0x025b, all -> 0x022e }
            r7.<init>(r11, r4)     // Catch:{ CancellationException -> 0x025b, all -> 0x022e }
            r4 = r14
            com.unity3d.services.core.di.IServiceComponent r4 = (com.unity3d.services.core.di.IServiceComponent) r4     // Catch:{ CancellationException -> 0x025b, all -> 0x022e }
            com.unity3d.services.core.di.IServiceProvider r4 = r4.getServiceProvider()     // Catch:{ CancellationException -> 0x025b, all -> 0x022e }
            com.unity3d.services.core.di.IServicesRegistry r4 = r4.getRegistry()     // Catch:{ CancellationException -> 0x025b, all -> 0x022e }
            java.lang.Class<com.unity3d.services.core.network.core.HttpClient> r11 = com.unity3d.services.core.network.core.HttpClient.class
            kotlin.reflect.KClass r11 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r11)     // Catch:{ CancellationException -> 0x025b, all -> 0x022e }
            java.lang.Object r0 = r4.getService(r0, r11)     // Catch:{ CancellationException -> 0x025b, all -> 0x022e }
            com.unity3d.services.core.network.core.HttpClient r0 = (com.unity3d.services.core.network.core.HttpClient) r0     // Catch:{ CancellationException -> 0x025b, all -> 0x022e }
            r5.<init>(r6, r7, r3, r0)     // Catch:{ CancellationException -> 0x025b, all -> 0x022e }
            r8.element = r5     // Catch:{ CancellationException -> 0x025b, all -> 0x022e }
            kotlin.jvm.internal.Ref$ObjectRef r11 = new kotlin.jvm.internal.Ref$ObjectRef     // Catch:{ CancellationException -> 0x025b, all -> 0x022e }
            r11.<init>()     // Catch:{ CancellationException -> 0x025b, all -> 0x022e }
            com.unity3d.services.core.configuration.Configuration r0 = new com.unity3d.services.core.configuration.Configuration     // Catch:{ CancellationException -> 0x025b, all -> 0x022e }
            r0.<init>()     // Catch:{ CancellationException -> 0x025b, all -> 0x022e }
            r11.element = r0     // Catch:{ CancellationException -> 0x025b, all -> 0x022e }
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x015c }
            com.unity3d.services.core.configuration.Configuration r0 = r15.getConfig()     // Catch:{ all -> 0x015c }
            int r3 = r0.getMaxRetries()     // Catch:{ all -> 0x015c }
            com.unity3d.services.core.configuration.Configuration r0 = r15.getConfig()     // Catch:{ all -> 0x015c }
            double r4 = r0.getRetryScalingFactor()     // Catch:{ all -> 0x015c }
            com.unity3d.services.core.configuration.Configuration r0 = r15.getConfig()     // Catch:{ all -> 0x015c }
            long r6 = r0.getRetryDelay()     // Catch:{ all -> 0x015c }
            com.unity3d.services.core.domain.task.InitializationException r0 = new com.unity3d.services.core.domain.task.InitializationException     // Catch:{ all -> 0x015c }
            com.unity3d.services.core.configuration.ErrorState r12 = com.unity3d.services.core.configuration.ErrorState.NetworkConfigRequest     // Catch:{ all -> 0x015c }
            java.lang.Exception r2 = new java.lang.Exception     // Catch:{ all -> 0x015c }
            r2.<init>()     // Catch:{ all -> 0x015c }
            com.unity3d.services.core.configuration.Configuration r13 = r15.getConfig()     // Catch:{ all -> 0x015c }
            r0.<init>(r12, r2, r13)     // Catch:{ all -> 0x015c }
            java.lang.Exception r0 = (java.lang.Exception) r0     // Catch:{ all -> 0x015c }
            com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader$doWork$2$1$configResult$1$1 r2 = new com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader$doWork$2$1$configResult$1$1     // Catch:{ all -> 0x015c }
            r12 = 0
            r2.<init>(r14, r8, r11, r12)     // Catch:{ all -> 0x015c }
            r12 = r2
            kotlin.jvm.functions.Function2 r12 = (kotlin.jvm.functions.Function2) r12     // Catch:{ all -> 0x015c }
            r9.L$0 = r1     // Catch:{ all -> 0x015c }
            r9.L$1 = r14     // Catch:{ all -> 0x015c }
            r9.L$2 = r15     // Catch:{ all -> 0x015c }
            r9.L$3 = r8     // Catch:{ all -> 0x015c }
            r9.L$4 = r11     // Catch:{ all -> 0x015c }
            r1 = 1
            r9.label = r1     // Catch:{ all -> 0x015c }
            r1 = r6
            r6 = r0
            r7 = r12
            r12 = r8
            r8 = r18
            java.lang.Object r0 = com.unity3d.services.core.extensions.TaskExtensionsKt.withRetry(r1, r3, r4, r6, r7, r8)     // Catch:{ all -> 0x015a }
            if (r0 != r10) goto L_0x014f
            return r10
        L_0x014f:
            r1 = r11
            r2 = r12
            r4 = r14
            r3 = r15
        L_0x0153:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0070 }
            java.lang.Object r0 = kotlin.Result.m144constructorimpl(r0)     // Catch:{ all -> 0x0070 }
            goto L_0x016c
        L_0x015a:
            r0 = move-exception
            goto L_0x015e
        L_0x015c:
            r0 = move-exception
            r12 = r8
        L_0x015e:
            r1 = r11
            r2 = r12
            r4 = r14
            r3 = r15
        L_0x0162:
            kotlin.Result$Companion r5 = kotlin.Result.Companion     // Catch:{ CancellationException -> 0x025b, all -> 0x022e }
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)     // Catch:{ CancellationException -> 0x025b, all -> 0x022e }
            java.lang.Object r0 = kotlin.Result.m144constructorimpl(r0)     // Catch:{ CancellationException -> 0x025b, all -> 0x022e }
        L_0x016c:
            r5 = r4
            r4 = r3
            r3 = r2
            boolean r2 = kotlin.Result.m150isFailureimpl(r0)     // Catch:{ CancellationException -> 0x025b, all -> 0x022e }
            if (r2 == 0) goto L_0x021d
            java.lang.Throwable r0 = kotlin.Result.m147exceptionOrNullimpl(r0)     // Catch:{ CancellationException -> 0x025b, all -> 0x022e }
            boolean r2 = r0 instanceof com.unity3d.services.core.extensions.AbortRetryException     // Catch:{ CancellationException -> 0x025b, all -> 0x022e }
            if (r2 != 0) goto L_0x020f
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x01ac }
            com.unity3d.services.core.domain.task.InitializeStateNetworkError r0 = r5.initializeStateNetworkError     // Catch:{ all -> 0x01ac }
            com.unity3d.services.core.domain.task.InitializeStateNetworkError$Params r2 = new com.unity3d.services.core.domain.task.InitializeStateNetworkError$Params     // Catch:{ all -> 0x01ac }
            com.unity3d.services.core.configuration.Configuration r6 = r4.getConfig()     // Catch:{ all -> 0x01ac }
            r2.<init>(r6)     // Catch:{ all -> 0x01ac }
            com.unity3d.services.core.domain.task.BaseParams r2 = (com.unity3d.services.core.domain.task.BaseParams) r2     // Catch:{ all -> 0x01ac }
            r9.L$0 = r5     // Catch:{ all -> 0x01ac }
            r9.L$1 = r4     // Catch:{ all -> 0x01ac }
            r9.L$2 = r3     // Catch:{ all -> 0x01ac }
            r9.L$3 = r1     // Catch:{ all -> 0x01ac }
            r9.L$4 = r1     // Catch:{ all -> 0x01ac }
            r6 = 2
            r9.label = r6     // Catch:{ all -> 0x01ac }
            java.lang.Object r0 = r0.m87invokegIAlus(r2, r9)     // Catch:{ all -> 0x01ac }
            if (r0 != r10) goto L_0x01a2
            return r10
        L_0x01a2:
            r2 = r1
        L_0x01a3:
            kotlin.Result r0 = kotlin.Result.m143boximpl(r0)     // Catch:{ all -> 0x0050 }
            java.lang.Object r0 = kotlin.Result.m144constructorimpl(r0)     // Catch:{ all -> 0x0050 }
            goto L_0x01b8
        L_0x01ac:
            r0 = move-exception
            r2 = r1
        L_0x01ae:
            kotlin.Result$Companion r6 = kotlin.Result.Companion     // Catch:{ CancellationException -> 0x025b, all -> 0x022e }
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)     // Catch:{ CancellationException -> 0x025b, all -> 0x022e }
            java.lang.Object r0 = kotlin.Result.m144constructorimpl(r0)     // Catch:{ CancellationException -> 0x025b, all -> 0x022e }
        L_0x01b8:
            r8 = r2
            r6 = r4
            boolean r0 = kotlin.Result.m151isSuccessimpl(r0)     // Catch:{ CancellationException -> 0x025b, all -> 0x022e }
            if (r0 == 0) goto L_0x01fc
            com.unity3d.services.core.configuration.IInitializeEventsMetricSender r0 = com.unity3d.services.core.configuration.InitializeEventsMetricSender.getInstance()     // Catch:{ CancellationException -> 0x025b, all -> 0x022e }
            r0.onRetryConfig()     // Catch:{ CancellationException -> 0x025b, all -> 0x022e }
            com.unity3d.services.core.domain.ISDKDispatchers r0 = r5.dispatchers     // Catch:{ CancellationException -> 0x025b, all -> 0x022e }
            kotlinx.coroutines.CoroutineDispatcher r0 = r0.getIo()     // Catch:{ CancellationException -> 0x025b, all -> 0x022e }
            kotlin.coroutines.CoroutineContext r0 = (kotlin.coroutines.CoroutineContext) r0     // Catch:{ CancellationException -> 0x025b, all -> 0x022e }
            com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader$doWork$2$1$1 r11 = new com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader$doWork$2$1$1     // Catch:{ CancellationException -> 0x025b, all -> 0x022e }
            r7 = 0
            r2 = r11
            r4 = r8
            r2.<init>(r3, r4, r5, r6, r7)     // Catch:{ CancellationException -> 0x025b, all -> 0x022e }
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11     // Catch:{ CancellationException -> 0x025b, all -> 0x022e }
            r9.L$0 = r8     // Catch:{ CancellationException -> 0x025b, all -> 0x022e }
            r9.L$1 = r1     // Catch:{ CancellationException -> 0x025b, all -> 0x022e }
            r2 = 0
            r9.L$2 = r2     // Catch:{ CancellationException -> 0x025b, all -> 0x022e }
            r9.L$3 = r2     // Catch:{ CancellationException -> 0x025b, all -> 0x022e }
            r9.L$4 = r2     // Catch:{ CancellationException -> 0x025b, all -> 0x022e }
            r2 = 3
            r9.label = r2     // Catch:{ CancellationException -> 0x025b, all -> 0x022e }
            java.lang.Object r0 = kotlinx.coroutines.BuildersKt.withContext(r0, r11, r9)     // Catch:{ CancellationException -> 0x025b, all -> 0x022e }
            if (r0 != r10) goto L_0x01f0
            return r10
        L_0x01f0:
            r0 = r1
            r1 = r8
        L_0x01f2:
            T r2 = r1.element     // Catch:{ CancellationException -> 0x025b, all -> 0x022e }
            com.unity3d.services.core.configuration.Configuration r2 = (com.unity3d.services.core.configuration.Configuration) r2     // Catch:{ CancellationException -> 0x025b, all -> 0x022e }
            r17 = r1
            r1 = r0
            r0 = r17
            goto L_0x0223
        L_0x01fc:
            com.unity3d.services.core.domain.task.InitializationException r0 = new com.unity3d.services.core.domain.task.InitializationException     // Catch:{ CancellationException -> 0x025b, all -> 0x022e }
            com.unity3d.services.core.configuration.ErrorState r1 = com.unity3d.services.core.configuration.ErrorState.NetworkConfigRequest     // Catch:{ CancellationException -> 0x025b, all -> 0x022e }
            java.lang.Exception r2 = new java.lang.Exception     // Catch:{ CancellationException -> 0x025b, all -> 0x022e }
            java.lang.String r3 = "No connected events within the timeout!"
            r2.<init>(r3)     // Catch:{ CancellationException -> 0x025b, all -> 0x022e }
            com.unity3d.services.core.configuration.Configuration r3 = r6.getConfig()     // Catch:{ CancellationException -> 0x025b, all -> 0x022e }
            r0.<init>(r1, r2, r3)     // Catch:{ CancellationException -> 0x025b, all -> 0x022e }
            throw r0     // Catch:{ CancellationException -> 0x025b, all -> 0x022e }
        L_0x020f:
            com.unity3d.services.core.domain.task.InitializationException r1 = new com.unity3d.services.core.domain.task.InitializationException     // Catch:{ CancellationException -> 0x025b, all -> 0x022e }
            com.unity3d.services.core.configuration.ErrorState r2 = com.unity3d.services.core.configuration.ErrorState.NetworkConfigRequest     // Catch:{ CancellationException -> 0x025b, all -> 0x022e }
            java.lang.Exception r0 = (java.lang.Exception) r0     // Catch:{ CancellationException -> 0x025b, all -> 0x022e }
            com.unity3d.services.core.configuration.Configuration r3 = r4.getConfig()     // Catch:{ CancellationException -> 0x025b, all -> 0x022e }
            r1.<init>(r2, r0, r3)     // Catch:{ CancellationException -> 0x025b, all -> 0x022e }
            throw r1     // Catch:{ CancellationException -> 0x025b, all -> 0x022e }
        L_0x021d:
            T r0 = r1.element     // Catch:{ CancellationException -> 0x025b, all -> 0x022e }
            r2 = r0
            com.unity3d.services.core.configuration.Configuration r2 = (com.unity3d.services.core.configuration.Configuration) r2     // Catch:{ CancellationException -> 0x025b, all -> 0x022e }
            r0 = r1
        L_0x0223:
            r1.element = r2     // Catch:{ CancellationException -> 0x025b, all -> 0x022e }
            T r0 = r0.element     // Catch:{ CancellationException -> 0x025b, all -> 0x022e }
            com.unity3d.services.core.configuration.Configuration r0 = (com.unity3d.services.core.configuration.Configuration) r0     // Catch:{ CancellationException -> 0x025b, all -> 0x022e }
            java.lang.Object r0 = kotlin.Result.m144constructorimpl(r0)     // Catch:{ CancellationException -> 0x025b, all -> 0x022e }
            goto L_0x0239
        L_0x022e:
            r0 = move-exception
            kotlin.Result$Companion r1 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            java.lang.Object r0 = kotlin.Result.m144constructorimpl(r0)
        L_0x0239:
            boolean r1 = kotlin.Result.m151isSuccessimpl(r0)
            if (r1 == 0) goto L_0x0246
            kotlin.Result$Companion r1 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.Result.m144constructorimpl(r0)
            goto L_0x0256
        L_0x0246:
            java.lang.Throwable r1 = kotlin.Result.m147exceptionOrNullimpl(r0)
            if (r1 == 0) goto L_0x0256
            kotlin.Result$Companion r0 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r1)
            java.lang.Object r0 = kotlin.Result.m144constructorimpl(r0)
        L_0x0256:
            kotlin.Result r0 = kotlin.Result.m143boximpl(r0)
            return r0
        L_0x025b:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.core.domain.task.InitializeStateConfigWithLoader$doWork$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
