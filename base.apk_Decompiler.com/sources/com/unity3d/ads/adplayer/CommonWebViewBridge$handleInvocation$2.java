package com.unity3d.ads.adplayer;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONArray;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.unity3d.ads.adplayer.CommonWebViewBridge$handleInvocation$2", f = "CommonWebViewBridge.kt", i = {0, 1}, l = {108, 110, 111, 111, 117}, m = "invokeSuspend", n = {"invocation", "invocation"}, s = {"L$0", "L$0"})
/* compiled from: CommonWebViewBridge.kt */
final class CommonWebViewBridge$handleInvocation$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $callback;
    final /* synthetic */ ExposedFunctionLocation $location;
    final /* synthetic */ JSONArray $parameters;
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    final /* synthetic */ CommonWebViewBridge this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CommonWebViewBridge$handleInvocation$2(ExposedFunctionLocation exposedFunctionLocation, JSONArray jSONArray, CommonWebViewBridge commonWebViewBridge, String str, Continuation<? super CommonWebViewBridge$handleInvocation$2> continuation) {
        super(2, continuation);
        this.$location = exposedFunctionLocation;
        this.$parameters = jSONArray;
        this.this$0 = commonWebViewBridge;
        this.$callback = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CommonWebViewBridge$handleInvocation$2(this.$location, this.$parameters, this.this$0, this.$callback, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CommonWebViewBridge$handleInvocation$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x00b4 A[Catch:{ Exception -> 0x002b }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00b5 A[Catch:{ Exception -> 0x002b }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00d0 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) {
        /*
            r12 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r12.label
            r2 = 0
            r3 = 5
            r4 = 4
            r5 = 3
            r6 = 2
            r7 = 1
            r8 = 0
            if (r1 == 0) goto L_0x0059
            if (r1 == r7) goto L_0x0051
            if (r1 == r6) goto L_0x0049
            if (r1 == r5) goto L_0x002e
            if (r1 == r4) goto L_0x0026
            if (r1 != r3) goto L_0x001e
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x0113
        L_0x001e:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L_0x0026:
            kotlin.ResultKt.throwOnFailure(r13)     // Catch:{ Exception -> 0x002b }
            goto L_0x0113
        L_0x002b:
            r13 = move-exception
            goto L_0x00d1
        L_0x002e:
            int r1 = r12.I$0
            java.lang.Object r5 = r12.L$4
            java.lang.Object[] r5 = (java.lang.Object[]) r5
            java.lang.Object r6 = r12.L$3
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r9 = r12.L$2
            java.lang.String r9 = (java.lang.String) r9
            java.lang.Object r10 = r12.L$1
            com.unity3d.ads.adplayer.CommonWebViewBridge r10 = (com.unity3d.ads.adplayer.CommonWebViewBridge) r10
            java.lang.Object r11 = r12.L$0
            java.lang.Object[] r11 = (java.lang.Object[]) r11
            kotlin.ResultKt.throwOnFailure(r13)     // Catch:{ Exception -> 0x002b }
            goto L_0x00b9
        L_0x0049:
            java.lang.Object r1 = r12.L$0
            com.unity3d.ads.adplayer.Invocation r1 = (com.unity3d.ads.adplayer.Invocation) r1
            kotlin.ResultKt.throwOnFailure(r13)     // Catch:{ Exception -> 0x002b }
            goto L_0x0095
        L_0x0051:
            java.lang.Object r1 = r12.L$0
            com.unity3d.ads.adplayer.Invocation r1 = (com.unity3d.ads.adplayer.Invocation) r1
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x007e
        L_0x0059:
            kotlin.ResultKt.throwOnFailure(r13)
            com.unity3d.ads.adplayer.Invocation r13 = new com.unity3d.ads.adplayer.Invocation
            com.unity3d.ads.adplayer.ExposedFunctionLocation r1 = r12.$location
            org.json.JSONArray r9 = r12.$parameters
            java.lang.Object[] r9 = com.unity3d.ads.core.extensions.JSONArrayExtensionsKt.toTypedArray(r9)
            r13.<init>(r1, r9)
            com.unity3d.ads.adplayer.CommonWebViewBridge r1 = r12.this$0
            kotlinx.coroutines.flow.MutableSharedFlow r1 = r1._onInvocation
            r9 = r12
            kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9
            r12.L$0 = r13
            r12.label = r7
            java.lang.Object r1 = r1.emit(r13, r9)
            if (r1 != r0) goto L_0x007d
            return r0
        L_0x007d:
            r1 = r13
        L_0x007e:
            com.unity3d.ads.adplayer.CommonWebViewBridge$handleInvocation$2$1 r13 = new com.unity3d.ads.adplayer.CommonWebViewBridge$handleInvocation$2$1     // Catch:{ Exception -> 0x002b }
            r13.<init>(r1, r8)     // Catch:{ Exception -> 0x002b }
            kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13     // Catch:{ Exception -> 0x002b }
            r9 = r12
            kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9     // Catch:{ Exception -> 0x002b }
            r12.L$0 = r1     // Catch:{ Exception -> 0x002b }
            r12.label = r6     // Catch:{ Exception -> 0x002b }
            r10 = 5000(0x1388, double:2.4703E-320)
            java.lang.Object r13 = kotlinx.coroutines.TimeoutKt.withTimeout(r10, r13, r9)     // Catch:{ Exception -> 0x002b }
            if (r13 != r0) goto L_0x0095
            return r0
        L_0x0095:
            com.unity3d.ads.adplayer.CommonWebViewBridge r10 = r12.this$0     // Catch:{ Exception -> 0x002b }
            java.lang.String r9 = r12.$callback     // Catch:{ Exception -> 0x002b }
            java.lang.String r6 = "OK"
            java.lang.Object[] r13 = new java.lang.Object[r7]     // Catch:{ Exception -> 0x002b }
            r11 = r12
            kotlin.coroutines.Continuation r11 = (kotlin.coroutines.Continuation) r11     // Catch:{ Exception -> 0x002b }
            r12.L$0 = r13     // Catch:{ Exception -> 0x002b }
            r12.L$1 = r10     // Catch:{ Exception -> 0x002b }
            r12.L$2 = r9     // Catch:{ Exception -> 0x002b }
            r12.L$3 = r6     // Catch:{ Exception -> 0x002b }
            r12.L$4 = r13     // Catch:{ Exception -> 0x002b }
            r12.I$0 = r2     // Catch:{ Exception -> 0x002b }
            r12.label = r5     // Catch:{ Exception -> 0x002b }
            java.lang.Object r1 = r1.getResult(r11)     // Catch:{ Exception -> 0x002b }
            if (r1 != r0) goto L_0x00b5
            return r0
        L_0x00b5:
            r5 = r13
            r11 = r5
            r13 = r1
            r1 = 0
        L_0x00b9:
            r5[r1] = r13     // Catch:{ Exception -> 0x002b }
            r13 = r12
            kotlin.coroutines.Continuation r13 = (kotlin.coroutines.Continuation) r13     // Catch:{ Exception -> 0x002b }
            r12.L$0 = r8     // Catch:{ Exception -> 0x002b }
            r12.L$1 = r8     // Catch:{ Exception -> 0x002b }
            r12.L$2 = r8     // Catch:{ Exception -> 0x002b }
            r12.L$3 = r8     // Catch:{ Exception -> 0x002b }
            r12.L$4 = r8     // Catch:{ Exception -> 0x002b }
            r12.label = r4     // Catch:{ Exception -> 0x002b }
            java.lang.Object r13 = r10.respond(r9, r6, r11, r13)     // Catch:{ Exception -> 0x002b }
            if (r13 != r0) goto L_0x0113
            return r0
        L_0x00d1:
            boolean r1 = r13 instanceof kotlinx.coroutines.TimeoutCancellationException
            if (r1 == 0) goto L_0x00eb
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            java.lang.String r1 = "Invocation("
            r13.<init>(r1)
            com.unity3d.ads.adplayer.ExposedFunctionLocation r1 = r12.$location
            r13.append(r1)
            java.lang.String r1 = ") is not handled"
            r13.append(r1)
            java.lang.String r13 = r13.toString()
            goto L_0x00f3
        L_0x00eb:
            java.lang.String r13 = r13.getMessage()
            if (r13 != 0) goto L_0x00f3
            java.lang.String r13 = "Unknown error"
        L_0x00f3:
            com.unity3d.ads.adplayer.CommonWebViewBridge r1 = r12.this$0
            java.lang.String r4 = r12.$callback
            java.lang.Object[] r5 = new java.lang.Object[r7]
            r5[r2] = r13
            r13 = r12
            kotlin.coroutines.Continuation r13 = (kotlin.coroutines.Continuation) r13
            r12.L$0 = r8
            r12.L$1 = r8
            r12.L$2 = r8
            r12.L$3 = r8
            r12.L$4 = r8
            r12.label = r3
            java.lang.String r2 = "ERROR"
            java.lang.Object r13 = r1.respond(r4, r2, r5, r13)
            if (r13 != r0) goto L_0x0113
            return r0
        L_0x0113:
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.adplayer.CommonWebViewBridge$handleInvocation$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
