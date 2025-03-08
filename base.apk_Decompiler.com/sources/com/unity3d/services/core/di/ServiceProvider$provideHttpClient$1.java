package com.unity3d.services.core.di;

import android.content.Context;
import com.unity3d.ads.core.configuration.AlternativeFlowReader;
import com.unity3d.ads.core.domain.SendDiagnosticEvent;
import com.unity3d.services.core.domain.ISDKDispatchers;
import com.unity3d.services.core.domain.task.ConfigFileFromLocalStorage;
import com.unity3d.services.core.network.core.HttpClient;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/unity3d/services/core/network/core/HttpClient;", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.unity3d.services.core.di.ServiceProvider$provideHttpClient$1", f = "ServiceProvider.kt", i = {0, 1}, l = {536, 540}, m = "invokeSuspend", n = {"startTime", "client"}, s = {"J$0", "L$0"})
/* compiled from: ServiceProvider.kt */
final class ServiceProvider$provideHttpClient$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super HttpClient>, Object> {
    final /* synthetic */ AlternativeFlowReader $alternativeFlowReader;
    final /* synthetic */ ConfigFileFromLocalStorage $configFileFromLocalStorage;
    final /* synthetic */ Context $context;
    final /* synthetic */ ISDKDispatchers $dispatchers;
    final /* synthetic */ SendDiagnosticEvent $sendDiagnosticEvent;
    long J$0;
    Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ServiceProvider$provideHttpClient$1(AlternativeFlowReader alternativeFlowReader, SendDiagnosticEvent sendDiagnosticEvent, ISDKDispatchers iSDKDispatchers, Context context, ConfigFileFromLocalStorage configFileFromLocalStorage, Continuation<? super ServiceProvider$provideHttpClient$1> continuation) {
        super(2, continuation);
        this.$alternativeFlowReader = alternativeFlowReader;
        this.$sendDiagnosticEvent = sendDiagnosticEvent;
        this.$dispatchers = iSDKDispatchers;
        this.$context = context;
        this.$configFileFromLocalStorage = configFileFromLocalStorage;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ServiceProvider$provideHttpClient$1(this.$alternativeFlowReader, this.$sendDiagnosticEvent, this.$dispatchers, this.$context, this.$configFileFromLocalStorage, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super HttpClient> continuation) {
        return ((ServiceProvider$provideHttpClient$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r14) {
        /*
            r13 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r13.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x0024
            if (r1 == r3) goto L_0x001e
            if (r1 != r2) goto L_0x0016
            java.lang.Object r0 = r13.L$0
            com.unity3d.services.core.network.core.HttpClient r0 = (com.unity3d.services.core.network.core.HttpClient) r0
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x0078
        L_0x0016:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r0)
            throw r14
        L_0x001e:
            long r3 = r13.J$0
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x0050
        L_0x0024:
            kotlin.ResultKt.throwOnFailure(r14)
            com.unity3d.ads.core.configuration.AlternativeFlowReader r14 = r13.$alternativeFlowReader
            boolean r14 = r14.invoke()
            r1 = 0
            if (r14 == 0) goto L_0x008a
            long r4 = java.lang.System.nanoTime()
            com.unity3d.services.core.di.ServiceProvider$provideHttpClient$1$client$1 r14 = new com.unity3d.services.core.di.ServiceProvider$provideHttpClient$1$client$1
            android.content.Context r6 = r13.$context
            com.unity3d.services.core.domain.ISDKDispatchers r7 = r13.$dispatchers
            r14.<init>(r6, r7, r1)
            kotlin.jvm.functions.Function2 r14 = (kotlin.jvm.functions.Function2) r14
            r1 = r13
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r13.J$0 = r4
            r13.label = r3
            r6 = 500(0x1f4, double:2.47E-321)
            java.lang.Object r14 = kotlinx.coroutines.TimeoutKt.withTimeoutOrNull(r6, r14, r1)
            if (r14 != r0) goto L_0x004f
            return r0
        L_0x004f:
            r3 = r4
        L_0x0050:
            com.unity3d.services.core.network.core.HttpClient r14 = (com.unity3d.services.core.network.core.HttpClient) r14
            if (r14 != 0) goto L_0x0057
            java.lang.String r1 = "native_cronet_failure_time"
            goto L_0x0059
        L_0x0057:
            java.lang.String r1 = "native_cronet_success_time"
        L_0x0059:
            r6 = r1
            com.unity3d.ads.core.domain.SendDiagnosticEvent r5 = r13.$sendDiagnosticEvent
            long r3 = com.unity3d.ads.core.extensions.TimestampExtensionsKt.duration(r3)
            java.lang.Long r7 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r3)
            r8 = 0
            r9 = 0
            r10 = r13
            kotlin.coroutines.Continuation r10 = (kotlin.coroutines.Continuation) r10
            r11 = 12
            r12 = 0
            r13.L$0 = r14
            r13.label = r2
            java.lang.Object r1 = com.unity3d.ads.core.domain.SendDiagnosticEvent.DefaultImpls.invoke$default(r5, r6, r7, r8, r9, r10, r11, r12)
            if (r1 != r0) goto L_0x0077
            return r0
        L_0x0077:
            r0 = r14
        L_0x0078:
            if (r0 != 0) goto L_0x00c1
            com.unity3d.services.core.network.core.OkHttp3Client r14 = new com.unity3d.services.core.network.core.OkHttp3Client
            com.unity3d.services.core.domain.ISDKDispatchers r0 = r13.$dispatchers
            okhttp3.OkHttpClient r1 = new okhttp3.OkHttpClient
            r1.<init>()
            r14.<init>(r0, r1)
            r0 = r14
            com.unity3d.services.core.network.core.HttpClient r0 = (com.unity3d.services.core.network.core.HttpClient) r0
            goto L_0x00c1
        L_0x008a:
            com.unity3d.services.core.di.ServiceProvider$provideHttpClient$1$config$1 r14 = new com.unity3d.services.core.di.ServiceProvider$provideHttpClient$1$config$1
            com.unity3d.services.core.domain.task.ConfigFileFromLocalStorage r0 = r13.$configFileFromLocalStorage
            r14.<init>(r0, r1)
            kotlin.jvm.functions.Function2 r14 = (kotlin.jvm.functions.Function2) r14
            java.lang.Object r14 = kotlinx.coroutines.BuildersKt__BuildersKt.runBlocking$default(r1, r14, r3, r1)
            com.unity3d.services.core.configuration.Configuration r14 = (com.unity3d.services.core.configuration.Configuration) r14
            if (r14 == 0) goto L_0x00b7
            com.unity3d.services.core.configuration.IExperiments r14 = r14.getExperiments()
            if (r14 == 0) goto L_0x00b7
            boolean r14 = r14.isOkHttpEnabled()
            if (r14 != r3) goto L_0x00b7
            com.unity3d.services.core.network.core.OkHttp3Client r14 = new com.unity3d.services.core.network.core.OkHttp3Client
            com.unity3d.services.core.domain.ISDKDispatchers r0 = r13.$dispatchers
            okhttp3.OkHttpClient r1 = new okhttp3.OkHttpClient
            r1.<init>()
            r14.<init>(r0, r1)
            r0 = r14
            com.unity3d.services.core.network.core.HttpClient r0 = (com.unity3d.services.core.network.core.HttpClient) r0
            goto L_0x00c1
        L_0x00b7:
            com.unity3d.services.core.network.core.LegacyHttpClient r14 = new com.unity3d.services.core.network.core.LegacyHttpClient
            com.unity3d.services.core.domain.ISDKDispatchers r0 = r13.$dispatchers
            r14.<init>(r0)
            r0 = r14
            com.unity3d.services.core.network.core.HttpClient r0 = (com.unity3d.services.core.network.core.HttpClient) r0
        L_0x00c1:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.services.core.di.ServiceProvider$provideHttpClient$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
