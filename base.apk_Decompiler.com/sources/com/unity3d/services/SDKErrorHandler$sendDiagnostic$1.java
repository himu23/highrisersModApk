package com.unity3d.services;

import com.unity3d.ads.core.domain.SendDiagnosticEvent;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.unity3d.services.SDKErrorHandler$sendDiagnostic$1", f = "SDKErrorHandler.kt", i = {}, l = {55}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: SDKErrorHandler.kt */
final class SDKErrorHandler$sendDiagnostic$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $name;
    final /* synthetic */ String $value;
    int label;
    final /* synthetic */ SDKErrorHandler this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SDKErrorHandler$sendDiagnostic$1(SDKErrorHandler sDKErrorHandler, String str, String str2, Continuation<? super SDKErrorHandler$sendDiagnostic$1> continuation) {
        super(2, continuation);
        this.this$0 = sDKErrorHandler;
        this.$name = str;
        this.$value = str2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SDKErrorHandler$sendDiagnostic$1(this.this$0, this.$name, this.$value, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SDKErrorHandler$sendDiagnostic$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (SendDiagnosticEvent.DefaultImpls.invoke$default(this.this$0.sendDiagnosticEvent, this.$name, (Long) null, MapsKt.mapOf(TuplesKt.to("reason", this.$value)), (Map) null, this, 10, (Object) null) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
