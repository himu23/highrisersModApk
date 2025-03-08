package com.unity3d.ads.core.domain.events;

import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.core.domain.events.GetDiagnosticEventRequest", f = "GetDiagnosticEventRequest.kt", i = {0, 0, 0, 0, 0}, l = {14}, m = "invoke", n = {"eventName", "tags", "intTags", "value", "$this$invoke_u24lambda_u243"}, s = {"L$0", "L$1", "L$2", "L$3", "L$5"})
/* compiled from: GetDiagnosticEventRequest.kt */
final class GetDiagnosticEventRequest$invoke$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GetDiagnosticEventRequest this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GetDiagnosticEventRequest$invoke$1(GetDiagnosticEventRequest getDiagnosticEventRequest, Continuation<? super GetDiagnosticEventRequest$invoke$1> continuation) {
        super(continuation);
        this.this$0 = getDiagnosticEventRequest;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.invoke((String) null, (Map<String, String>) null, (Map<String, Integer>) null, (Double) null, this);
    }
}
