package com.unity3d.ads.adplayer;

import com.unity3d.ads.core.data.model.ShowEvent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\t"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SafeCollector.common.kt */
public final class WebViewAdPlayer$special$$inlined$map$1 implements Flow<ShowEvent> {
    final /* synthetic */ Flow $this_unsafeTransform$inlined;

    public WebViewAdPlayer$special$$inlined$map$1(Flow flow) {
        this.$this_unsafeTransform$inlined = flow;
    }

    public Object collect(final FlowCollector flowCollector, Continuation continuation) {
        Object collect = this.$this_unsafeTransform$inlined.collect(new FlowCollector() {
            /* JADX WARNING: Removed duplicated region for block: B:14:0x0044  */
            /* JADX WARNING: Removed duplicated region for block: B:47:0x0101 A[RETURN] */
            /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object emit(java.lang.Object r10, kotlin.coroutines.Continuation r11) {
                /*
                    r9 = this;
                    boolean r0 = r11 instanceof com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$map$1.AnonymousClass2.AnonymousClass1
                    if (r0 == 0) goto L_0x0014
                    r0 = r11
                    com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$map$1$2$1 r0 = (com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                    int r1 = r0.label
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r1 = r1 & r2
                    if (r1 == 0) goto L_0x0014
                    int r11 = r0.label
                    int r11 = r11 - r2
                    r0.label = r11
                    goto L_0x0019
                L_0x0014:
                    com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$map$1$2$1 r0 = new com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$map$1$2$1
                    r0.<init>(r9, r11)
                L_0x0019:
                    java.lang.Object r11 = r0.result
                    java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r2 = r0.label
                    r3 = 2
                    r4 = 1
                    r5 = 0
                    if (r2 == 0) goto L_0x0044
                    if (r2 == r4) goto L_0x0037
                    if (r2 != r3) goto L_0x002f
                    kotlin.ResultKt.throwOnFailure(r11)
                    goto L_0x0102
                L_0x002f:
                    java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                    java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
                    r10.<init>(r11)
                    throw r10
                L_0x0037:
                    java.lang.Object r10 = r0.L$1
                    com.unity3d.ads.core.data.model.ShowEvent r10 = (com.unity3d.ads.core.data.model.ShowEvent) r10
                    java.lang.Object r2 = r0.L$0
                    kotlinx.coroutines.flow.FlowCollector r2 = (kotlinx.coroutines.flow.FlowCollector) r2
                    kotlin.ResultKt.throwOnFailure(r11)
                    goto L_0x00f5
                L_0x0044:
                    kotlin.ResultKt.throwOnFailure(r11)
                    kotlinx.coroutines.flow.FlowCollector r2 = r3
                    r11 = r0
                    kotlin.coroutines.Continuation r11 = (kotlin.coroutines.Continuation) r11
                    com.unity3d.ads.adplayer.Invocation r10 = (com.unity3d.ads.adplayer.Invocation) r10
                    com.unity3d.ads.adplayer.ExposedFunctionLocation r11 = r10.getLocation()
                    int[] r6 = com.unity3d.ads.adplayer.WebViewAdPlayer.WhenMappings.$EnumSwitchMapping$0
                    int r11 = r11.ordinal()
                    r11 = r6[r11]
                    if (r11 == r4) goto L_0x00e3
                    if (r11 == r3) goto L_0x00de
                    r6 = 3
                    if (r11 == r6) goto L_0x00ae
                    r6 = 4
                    if (r11 == r6) goto L_0x0085
                    r6 = 5
                    if (r11 != r6) goto L_0x006d
                    com.unity3d.ads.core.data.model.ShowEvent$CancelTimeout r11 = com.unity3d.ads.core.data.model.ShowEvent.CancelTimeout.INSTANCE
                    com.unity3d.ads.core.data.model.ShowEvent r11 = (com.unity3d.ads.core.data.model.ShowEvent) r11
                    goto L_0x00e7
                L_0x006d:
                    java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                    java.lang.StringBuilder r0 = new java.lang.StringBuilder
                    java.lang.String r1 = "Unexpected location: "
                    r0.<init>(r1)
                    com.unity3d.ads.adplayer.ExposedFunctionLocation r10 = r10.getLocation()
                    r0.append(r10)
                    java.lang.String r10 = r0.toString()
                    r11.<init>(r10)
                    throw r11
                L_0x0085:
                    java.lang.Object[] r11 = r10.getParameters()
                    java.lang.Object r11 = kotlin.collections.ArraysKt.first((T[]) r11)
                    java.lang.String r6 = "null cannot be cast to non-null type org.json.JSONObject"
                    kotlin.jvm.internal.Intrinsics.checkNotNull(r11, r6)
                    org.json.JSONObject r11 = (org.json.JSONObject) r11
                    java.lang.String r6 = "code"
                    int r6 = r11.optInt(r6)
                    java.lang.String r7 = "message"
                    java.lang.String r11 = r11.optString(r7)
                    com.unity3d.ads.core.data.model.ShowEvent$Error r7 = new com.unity3d.ads.core.data.model.ShowEvent$Error
                    java.lang.String r8 = "errorMessage"
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r11, r8)
                    r7.<init>(r11, r6)
                    com.unity3d.ads.core.data.model.ShowEvent r7 = (com.unity3d.ads.core.data.model.ShowEvent) r7
                    r11 = r7
                    goto L_0x00e7
                L_0x00ae:
                    com.unity3d.ads.core.data.model.ShowEvent$Completed r11 = new com.unity3d.ads.core.data.model.ShowEvent$Completed
                    java.lang.Object[] r6 = r10.getParameters()
                    java.lang.Object r6 = kotlin.collections.ArraysKt.first((T[]) r6)
                    boolean r7 = r6 instanceof java.lang.String
                    if (r7 == 0) goto L_0x00bf
                    java.lang.String r6 = (java.lang.String) r6
                    goto L_0x00c0
                L_0x00bf:
                    r6 = r5
                L_0x00c0:
                    java.lang.String r7 = "COMPLETED"
                    boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r7)
                    if (r7 == 0) goto L_0x00cb
                    com.unity3d.ads.core.data.model.ShowStatus r6 = com.unity3d.ads.core.data.model.ShowStatus.COMPLETED
                    goto L_0x00d8
                L_0x00cb:
                    java.lang.String r7 = "SKIPPED"
                    boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r7)
                    if (r6 == 0) goto L_0x00d6
                    com.unity3d.ads.core.data.model.ShowStatus r6 = com.unity3d.ads.core.data.model.ShowStatus.SKIPPED
                    goto L_0x00d8
                L_0x00d6:
                    com.unity3d.ads.core.data.model.ShowStatus r6 = com.unity3d.ads.core.data.model.ShowStatus.ERROR
                L_0x00d8:
                    r11.<init>(r6)
                    com.unity3d.ads.core.data.model.ShowEvent r11 = (com.unity3d.ads.core.data.model.ShowEvent) r11
                    goto L_0x00e7
                L_0x00de:
                    com.unity3d.ads.core.data.model.ShowEvent$Clicked r11 = com.unity3d.ads.core.data.model.ShowEvent.Clicked.INSTANCE
                    com.unity3d.ads.core.data.model.ShowEvent r11 = (com.unity3d.ads.core.data.model.ShowEvent) r11
                    goto L_0x00e7
                L_0x00e3:
                    com.unity3d.ads.core.data.model.ShowEvent$Started r11 = com.unity3d.ads.core.data.model.ShowEvent.Started.INSTANCE
                    com.unity3d.ads.core.data.model.ShowEvent r11 = (com.unity3d.ads.core.data.model.ShowEvent) r11
                L_0x00e7:
                    r0.L$0 = r2
                    r0.L$1 = r11
                    r0.label = r4
                    java.lang.Object r10 = com.unity3d.ads.adplayer.Invocation.handle$default(r10, r5, r0, r4, r5)
                    if (r10 != r1) goto L_0x00f4
                    return r1
                L_0x00f4:
                    r10 = r11
                L_0x00f5:
                    r0.L$0 = r5
                    r0.L$1 = r5
                    r0.label = r3
                    java.lang.Object r10 = r2.emit(r10, r0)
                    if (r10 != r1) goto L_0x0102
                    return r1
                L_0x0102:
                    kotlin.Unit r10 = kotlin.Unit.INSTANCE
                    return r10
                */
                throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
            }
        }, continuation);
        if (collect == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return collect;
        }
        return Unit.INSTANCE;
    }
}
