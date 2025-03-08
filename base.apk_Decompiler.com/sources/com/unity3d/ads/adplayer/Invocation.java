package com.unity3d.ads.adplayer;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0011\u0010\u0013\u001a\u00020\u0001H@ø\u0001\u0000¢\u0006\u0002\u0010\u0014J1\u0010\u0015\u001a\u00020\t2\u001e\b\u0002\u0010\u0016\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0017H@ø\u0001\u0000¢\u0006\u0002\u0010\u0019R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\bX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\f8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Lcom/unity3d/ads/adplayer/Invocation;", "", "location", "Lcom/unity3d/ads/adplayer/ExposedFunctionLocation;", "parameters", "", "(Lcom/unity3d/ads/adplayer/ExposedFunctionLocation;[Ljava/lang/Object;)V", "_isHandled", "Lkotlinx/coroutines/CompletableDeferred;", "", "completableDeferred", "isHandled", "Lkotlinx/coroutines/Deferred;", "()Lkotlinx/coroutines/Deferred;", "getLocation", "()Lcom/unity3d/ads/adplayer/ExposedFunctionLocation;", "getParameters", "()[Ljava/lang/Object;", "[Ljava/lang/Object;", "getResult", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handle", "handler", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Invocation.kt */
public final class Invocation {
    private final CompletableDeferred<Unit> _isHandled = CompletableDeferredKt.CompletableDeferred$default((Job) null, 1, (Object) null);
    private final CompletableDeferred<Object> completableDeferred = CompletableDeferredKt.CompletableDeferred$default((Job) null, 1, (Object) null);
    private final ExposedFunctionLocation location;
    private final Object[] parameters;

    public final ExposedFunctionLocation getLocation() {
        return this.location;
    }

    public final Object[] getParameters() {
        return this.parameters;
    }

    public Invocation(ExposedFunctionLocation exposedFunctionLocation, Object[] objArr) {
        Intrinsics.checkNotNullParameter(exposedFunctionLocation, "location");
        Intrinsics.checkNotNullParameter(objArr, "parameters");
        this.location = exposedFunctionLocation;
        this.parameters = objArr;
    }

    public final Deferred<Unit> isHandled() {
        return this._isHandled;
    }

    public static /* synthetic */ Object handle$default(Invocation invocation, Function1 function1, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = new Invocation$handle$2((Continuation<? super Invocation$handle$2>) null);
        }
        return invocation.handle(function1, continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object handle(kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<java.lang.Object>, ? extends java.lang.Object> r5, kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.unity3d.ads.adplayer.Invocation$handle$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            com.unity3d.ads.adplayer.Invocation$handle$1 r0 = (com.unity3d.ads.adplayer.Invocation$handle$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            com.unity3d.ads.adplayer.Invocation$handle$1 r0 = new com.unity3d.ads.adplayer.Invocation$handle$1
            r0.<init>(r4, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0038
            if (r2 != r3) goto L_0x0030
            java.lang.Object r5 = r0.L$0
            com.unity3d.ads.adplayer.Invocation r5 = (com.unity3d.ads.adplayer.Invocation) r5
            kotlin.ResultKt.throwOnFailure(r6)     // Catch:{ all -> 0x002e }
            goto L_0x004e
        L_0x002e:
            r6 = move-exception
            goto L_0x0056
        L_0x0030:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0038:
            kotlin.ResultKt.throwOnFailure(r6)
            kotlinx.coroutines.CompletableDeferred<kotlin.Unit> r6 = r4._isHandled
            kotlin.Unit r2 = kotlin.Unit.INSTANCE
            r6.complete(r2)
            r0.L$0 = r4     // Catch:{ all -> 0x0054 }
            r0.label = r3     // Catch:{ all -> 0x0054 }
            java.lang.Object r6 = r5.invoke(r0)     // Catch:{ all -> 0x0054 }
            if (r6 != r1) goto L_0x004d
            return r1
        L_0x004d:
            r5 = r4
        L_0x004e:
            kotlinx.coroutines.CompletableDeferred<java.lang.Object> r0 = r5.completableDeferred     // Catch:{ all -> 0x002e }
            r0.complete(r6)     // Catch:{ all -> 0x002e }
            goto L_0x005b
        L_0x0054:
            r6 = move-exception
            r5 = r4
        L_0x0056:
            kotlinx.coroutines.CompletableDeferred<java.lang.Object> r5 = r5.completableDeferred
            r5.completeExceptionally(r6)
        L_0x005b:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.adplayer.Invocation.handle(kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object getResult(Continuation<Object> continuation) {
        return this.completableDeferred.await(continuation);
    }
}
