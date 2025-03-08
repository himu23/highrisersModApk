package com.unity3d.ads.core.domain;

import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.unity3d.ads.core.domain.AndroidSendDiagnosticEvent", f = "AndroidSendDiagnosticEvent.kt", i = {0}, l = {19}, m = "invoke", n = {"this"}, s = {"L$0"})
/* compiled from: AndroidSendDiagnosticEvent.kt */
final class AndroidSendDiagnosticEvent$invoke$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AndroidSendDiagnosticEvent this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AndroidSendDiagnosticEvent$invoke$1(AndroidSendDiagnosticEvent androidSendDiagnosticEvent, Continuation<? super AndroidSendDiagnosticEvent$invoke$1> continuation) {
        super(continuation);
        this.this$0 = androidSendDiagnosticEvent;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.invoke((String) null, (Long) null, (Map<String, String>) null, (Map<String, Integer>) null, this);
    }
}
