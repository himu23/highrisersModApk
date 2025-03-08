package com.unity3d.ads.core.domain.events;

import com.unity3d.ads.gatewayclient.RequestPolicy;
import gateway.v1.UniversalRequestOuterClass;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.core.domain.events.UniversalRequestEventSender", f = "UniversalRequestEventSender.kt", i = {0}, l = {13, 19}, m = "invoke", n = {"this"}, s = {"L$0"})
/* compiled from: UniversalRequestEventSender.kt */
final class UniversalRequestEventSender$invoke$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ UniversalRequestEventSender this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UniversalRequestEventSender$invoke$1(UniversalRequestEventSender universalRequestEventSender, Continuation<? super UniversalRequestEventSender$invoke$1> continuation) {
        super(continuation);
        this.this$0 = universalRequestEventSender;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.invoke((UniversalRequestOuterClass.UniversalRequest) null, (RequestPolicy) null, this);
    }
}
