package com.unity3d.services.core.di;

import android.content.Context;
import com.unity3d.services.core.domain.ISDKDispatchers;
import com.unity3d.services.core.network.core.HttpClient;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/unity3d/services/core/network/core/HttpClient;", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.unity3d.services.core.di.ServiceProvider$provideHttpClient$1$client$1", f = "ServiceProvider.kt", i = {}, l = {537}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ServiceProvider.kt */
final class ServiceProvider$provideHttpClient$1$client$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super HttpClient>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ ISDKDispatchers $dispatchers;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ServiceProvider$provideHttpClient$1$client$1(Context context, ISDKDispatchers iSDKDispatchers, Continuation<? super ServiceProvider$provideHttpClient$1$client$1> continuation) {
        super(2, continuation);
        this.$context = context;
        this.$dispatchers = iSDKDispatchers;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ServiceProvider$provideHttpClient$1$client$1(this.$context, this.$dispatchers, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super HttpClient> continuation) {
        return ((ServiceProvider$provideHttpClient$1$client$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = ServiceProvider.INSTANCE.buildNetworkClient(this.$context, this.$dispatchers, this);
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
