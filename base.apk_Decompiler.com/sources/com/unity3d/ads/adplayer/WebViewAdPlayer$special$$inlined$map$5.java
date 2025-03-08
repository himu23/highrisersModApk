package com.unity3d.ads.adplayer;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\t"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$$inlined$unsafeFlow$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: SafeCollector.common.kt */
public final class WebViewAdPlayer$special$$inlined$map$5 implements Flow<Unit> {
    final /* synthetic */ Flow $this_unsafeTransform$inlined;
    final /* synthetic */ WebViewAdPlayer this$0;

    public WebViewAdPlayer$special$$inlined$map$5(Flow flow, WebViewAdPlayer webViewAdPlayer) {
        this.$this_unsafeTransform$inlined = flow;
        this.this$0 = webViewAdPlayer;
    }

    public Object collect(final FlowCollector flowCollector, Continuation continuation) {
        Flow flow = this.$this_unsafeTransform$inlined;
        final WebViewAdPlayer webViewAdPlayer = this.this$0;
        Object collect = flow.collect(new FlowCollector() {
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v8, resolved type: java.lang.String} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v6, resolved type: java.lang.String} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v20, resolved type: java.lang.Object} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v4, resolved type: java.lang.String} */
            /* JADX WARNING: Multi-variable type inference failed */
            /* JADX WARNING: Removed duplicated region for block: B:25:0x008d  */
            /* JADX WARNING: Removed duplicated region for block: B:31:0x00d3  */
            /* JADX WARNING: Removed duplicated region for block: B:39:0x00f8  */
            /* JADX WARNING: Removed duplicated region for block: B:43:0x0114 A[RETURN] */
            /* JADX WARNING: Removed duplicated region for block: B:44:0x0115  */
            /* JADX WARNING: Removed duplicated region for block: B:48:0x0122 A[Catch:{ Exception -> 0x0079 }] */
            /* JADX WARNING: Removed duplicated region for block: B:49:0x0125 A[Catch:{ Exception -> 0x0079 }] */
            /* JADX WARNING: Removed duplicated region for block: B:55:0x0177 A[RETURN] */
            /* JADX WARNING: Removed duplicated region for block: B:69:0x01c6 A[RETURN] */
            /* JADX WARNING: Removed duplicated region for block: B:8:0x002e  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object emit(java.lang.Object r18, kotlin.coroutines.Continuation r19) {
                /*
                    r17 = this;
                    r1 = r17
                    r0 = r19
                    boolean r2 = r0 instanceof com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$map$5.AnonymousClass2.AnonymousClass1
                    if (r2 == 0) goto L_0x0018
                    r2 = r0
                    com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$map$5$2$1 r2 = (com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$map$5.AnonymousClass2.AnonymousClass1) r2
                    int r3 = r2.label
                    r4 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r3 & r4
                    if (r3 == 0) goto L_0x0018
                    int r0 = r2.label
                    int r0 = r0 - r4
                    r2.label = r0
                    goto L_0x001d
                L_0x0018:
                    com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$map$5$2$1 r2 = new com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$map$5$2$1
                    r2.<init>(r1, r0)
                L_0x001d:
                    java.lang.Object r0 = r2.result
                    java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r4 = r2.label
                    r5 = 0
                    r6 = 5
                    r7 = 4
                    r8 = 3
                    r9 = 2
                    r10 = 1
                    r11 = 0
                    if (r4 == 0) goto L_0x008d
                    if (r4 == r10) goto L_0x007c
                    if (r4 == r9) goto L_0x0064
                    if (r4 == r8) goto L_0x004f
                    if (r4 == r7) goto L_0x0045
                    if (r4 != r6) goto L_0x003d
                    kotlin.ResultKt.throwOnFailure(r0)
                    goto L_0x01c7
                L_0x003d:
                    java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                    java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                    r0.<init>(r2)
                    throw r0
                L_0x0045:
                    java.lang.Object r4 = r2.L$0
                    kotlinx.coroutines.flow.FlowCollector r4 = (kotlinx.coroutines.flow.FlowCollector) r4
                    kotlin.ResultKt.throwOnFailure(r0)
                    r7 = r11
                    goto L_0x01b3
                L_0x004f:
                    java.lang.Object r4 = r2.L$3
                    java.lang.String r4 = (java.lang.String) r4
                    java.lang.Object r12 = r2.L$2
                    java.lang.String r12 = (java.lang.String) r12
                    java.lang.Object r13 = r2.L$1
                    kotlinx.coroutines.flow.FlowCollector r13 = (kotlinx.coroutines.flow.FlowCollector) r13
                    java.lang.Object r14 = r2.L$0
                    com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$map$5$2 r14 = (com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$map$5.AnonymousClass2) r14
                    kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ Exception -> 0x0079 }
                    goto L_0x0178
                L_0x0064:
                    java.lang.Object r4 = r2.L$3
                    java.lang.String r4 = (java.lang.String) r4
                    java.lang.Object r12 = r2.L$2
                    java.lang.String r12 = (java.lang.String) r12
                    java.lang.Object r13 = r2.L$1
                    kotlinx.coroutines.flow.FlowCollector r13 = (kotlinx.coroutines.flow.FlowCollector) r13
                    java.lang.Object r14 = r2.L$0
                    com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$map$5$2 r14 = (com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$map$5.AnonymousClass2) r14
                    kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ Exception -> 0x0079 }
                    goto L_0x0118
                L_0x0079:
                    r0 = move-exception
                    goto L_0x017e
                L_0x007c:
                    java.lang.Object r4 = r2.L$2
                    com.unity3d.ads.adplayer.Invocation r4 = (com.unity3d.ads.adplayer.Invocation) r4
                    java.lang.Object r12 = r2.L$1
                    kotlinx.coroutines.flow.FlowCollector r12 = (kotlinx.coroutines.flow.FlowCollector) r12
                    java.lang.Object r13 = r2.L$0
                    com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$map$5$2 r13 = (com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$map$5.AnonymousClass2) r13
                    kotlin.ResultKt.throwOnFailure(r0)
                    r14 = r13
                    goto L_0x00a9
                L_0x008d:
                    kotlin.ResultKt.throwOnFailure(r0)
                    kotlinx.coroutines.flow.FlowCollector r12 = r4
                    r0 = r2
                    kotlin.coroutines.Continuation r0 = (kotlin.coroutines.Continuation) r0
                    r4 = r18
                    com.unity3d.ads.adplayer.Invocation r4 = (com.unity3d.ads.adplayer.Invocation) r4
                    r2.L$0 = r1
                    r2.L$1 = r12
                    r2.L$2 = r4
                    r2.label = r10
                    java.lang.Object r0 = com.unity3d.ads.adplayer.Invocation.handle$default(r4, r11, r2, r10, r11)
                    if (r0 != r3) goto L_0x00a8
                    return r3
                L_0x00a8:
                    r14 = r1
                L_0x00a9:
                    java.lang.Object[] r0 = r4.getParameters()
                    java.lang.Object r0 = kotlin.collections.ArraysKt.first((T[]) r0)
                    java.lang.String r13 = "null cannot be cast to non-null type kotlin.String"
                    kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r13)
                    r13 = r0
                    java.lang.String r13 = (java.lang.String) r13
                    java.lang.Object[] r0 = r4.getParameters()
                    java.lang.Object r0 = kotlin.collections.ArraysKt.getOrNull((T[]) r0, (int) r10)
                    r15 = r0
                    java.lang.String r15 = (java.lang.String) r15
                    com.unity3d.ads.adplayer.ExposedFunctionLocation r0 = r4.getLocation()
                    int[] r16 = com.unity3d.ads.adplayer.WebViewAdPlayer.WhenMappings.$EnumSwitchMapping$0
                    int r0 = r0.ordinal()
                    r0 = r16[r0]
                    r11 = 6
                    if (r0 == r11) goto L_0x00f8
                    r11 = 7
                    if (r0 == r11) goto L_0x00f5
                    r11 = 8
                    if (r0 != r11) goto L_0x00dd
                    com.unity3d.services.core.network.model.RequestType r0 = com.unity3d.services.core.network.model.RequestType.HEAD
                    goto L_0x00fa
                L_0x00dd:
                    java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                    java.lang.StringBuilder r2 = new java.lang.StringBuilder
                    java.lang.String r3 = "Unexpected location: "
                    r2.<init>(r3)
                    com.unity3d.ads.adplayer.ExposedFunctionLocation r3 = r4.getLocation()
                    r2.append(r3)
                    java.lang.String r2 = r2.toString()
                    r0.<init>(r2)
                    throw r0
                L_0x00f5:
                    com.unity3d.services.core.network.model.RequestType r0 = com.unity3d.services.core.network.model.RequestType.POST
                    goto L_0x00fa
                L_0x00f8:
                    com.unity3d.services.core.network.model.RequestType r0 = com.unity3d.services.core.network.model.RequestType.GET
                L_0x00fa:
                    com.unity3d.ads.adplayer.WebViewAdPlayer r11 = r2     // Catch:{ Exception -> 0x017a }
                    com.unity3d.ads.core.domain.ExecuteAdViewerRequest r11 = r11.executeAdViewerRequest     // Catch:{ Exception -> 0x017a }
                    java.lang.Object[] r4 = r4.getParameters()     // Catch:{ Exception -> 0x017a }
                    r2.L$0 = r14     // Catch:{ Exception -> 0x017a }
                    r2.L$1 = r12     // Catch:{ Exception -> 0x017a }
                    r2.L$2 = r15     // Catch:{ Exception -> 0x017a }
                    r2.L$3 = r13     // Catch:{ Exception -> 0x017a }
                    r2.label = r9     // Catch:{ Exception -> 0x017a }
                    java.lang.Object r0 = r11.invoke(r0, r4, r2)     // Catch:{ Exception -> 0x017a }
                    if (r0 != r3) goto L_0x0115
                    return r3
                L_0x0115:
                    r4 = r13
                    r13 = r12
                    r12 = r15
                L_0x0118:
                    com.unity3d.services.core.network.model.HttpResponse r0 = (com.unity3d.services.core.network.model.HttpResponse) r0     // Catch:{ Exception -> 0x0079 }
                    java.lang.Object r11 = r0.getBody()     // Catch:{ Exception -> 0x0079 }
                    boolean r15 = r11 instanceof java.lang.String     // Catch:{ Exception -> 0x0079 }
                    if (r15 == 0) goto L_0x0125
                    java.lang.String r11 = (java.lang.String) r11     // Catch:{ Exception -> 0x0079 }
                    goto L_0x0135
                L_0x0125:
                    boolean r15 = r11 instanceof byte[]     // Catch:{ Exception -> 0x0079 }
                    if (r15 == 0) goto L_0x0134
                    java.lang.String r15 = new java.lang.String     // Catch:{ Exception -> 0x0079 }
                    byte[] r11 = (byte[]) r11     // Catch:{ Exception -> 0x0079 }
                    java.nio.charset.Charset r7 = kotlin.text.Charsets.UTF_8     // Catch:{ Exception -> 0x0079 }
                    r15.<init>(r11, r7)     // Catch:{ Exception -> 0x0079 }
                    r11 = r15
                    goto L_0x0135
                L_0x0134:
                    r11 = 0
                L_0x0135:
                    java.lang.Object[] r7 = new java.lang.Object[r6]     // Catch:{ Exception -> 0x0079 }
                    r7[r5] = r4     // Catch:{ Exception -> 0x0079 }
                    java.lang.String r15 = r0.getUrlString()     // Catch:{ Exception -> 0x0079 }
                    r7[r10] = r15     // Catch:{ Exception -> 0x0079 }
                    r7[r9] = r11     // Catch:{ Exception -> 0x0079 }
                    int r11 = r0.getStatusCode()     // Catch:{ Exception -> 0x0079 }
                    java.lang.Integer r11 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r11)     // Catch:{ Exception -> 0x0079 }
                    r7[r8] = r11     // Catch:{ Exception -> 0x0079 }
                    java.util.Map r0 = r0.getHeaders()     // Catch:{ Exception -> 0x0079 }
                    org.json.JSONArray r0 = com.unity3d.services.core.network.mapper.HttpResponseHeaderToJSONArrayKt.toResponseHeadersMap(r0)     // Catch:{ Exception -> 0x0079 }
                    r11 = 4
                    r7[r11] = r0     // Catch:{ Exception -> 0x0079 }
                    java.util.List r0 = kotlin.collections.CollectionsKt.listOf(r7)     // Catch:{ Exception -> 0x0079 }
                    com.unity3d.ads.adplayer.WebViewAdPlayer r7 = r2     // Catch:{ Exception -> 0x0079 }
                    com.unity3d.ads.adplayer.WebViewBridge r7 = r7.bridge     // Catch:{ Exception -> 0x0079 }
                    com.unity3d.ads.adplayer.OnWebRequestComplete r11 = new com.unity3d.ads.adplayer.OnWebRequestComplete     // Catch:{ Exception -> 0x0079 }
                    r11.<init>(r0)     // Catch:{ Exception -> 0x0079 }
                    com.unity3d.ads.adplayer.WebViewEvent r11 = (com.unity3d.ads.adplayer.WebViewEvent) r11     // Catch:{ Exception -> 0x0079 }
                    r2.L$0 = r14     // Catch:{ Exception -> 0x0079 }
                    r2.L$1 = r13     // Catch:{ Exception -> 0x0079 }
                    r2.L$2 = r12     // Catch:{ Exception -> 0x0079 }
                    r2.L$3 = r4     // Catch:{ Exception -> 0x0079 }
                    r2.label = r8     // Catch:{ Exception -> 0x0079 }
                    java.lang.Object r0 = r7.sendEvent(r11, r2)     // Catch:{ Exception -> 0x0079 }
                    if (r0 != r3) goto L_0x0178
                    return r3
                L_0x0178:
                    r7 = 0
                    goto L_0x01b4
                L_0x017a:
                    r0 = move-exception
                    r4 = r13
                    r13 = r12
                    r12 = r15
                L_0x017e:
                    java.lang.String[] r7 = new java.lang.String[r8]
                    r7[r5] = r4
                    r7[r10] = r12
                    java.lang.String r0 = r0.getMessage()
                    if (r0 != 0) goto L_0x018c
                    java.lang.String r0 = ""
                L_0x018c:
                    r7[r9] = r0
                    java.util.List r0 = kotlin.collections.CollectionsKt.listOf(r7)
                    com.unity3d.ads.adplayer.WebViewAdPlayer r4 = r2
                    com.unity3d.ads.adplayer.WebViewBridge r4 = r4.bridge
                    com.unity3d.ads.adplayer.OnWebRequestFailed r5 = new com.unity3d.ads.adplayer.OnWebRequestFailed
                    r5.<init>(r0)
                    com.unity3d.ads.adplayer.WebViewEvent r5 = (com.unity3d.ads.adplayer.WebViewEvent) r5
                    r2.L$0 = r13
                    r7 = 0
                    r2.L$1 = r7
                    r2.L$2 = r7
                    r2.L$3 = r7
                    r8 = 4
                    r2.label = r8
                    java.lang.Object r0 = r4.sendEvent(r5, r2)
                    if (r0 != r3) goto L_0x01b2
                    return r3
                L_0x01b2:
                    r4 = r13
                L_0x01b3:
                    r13 = r4
                L_0x01b4:
                    kotlin.Unit r0 = kotlin.Unit.INSTANCE
                    r2.L$0 = r7
                    r2.L$1 = r7
                    r2.L$2 = r7
                    r2.L$3 = r7
                    r2.label = r6
                    java.lang.Object r0 = r13.emit(r0, r2)
                    if (r0 != r3) goto L_0x01c7
                    return r3
                L_0x01c7:
                    kotlin.Unit r0 = kotlin.Unit.INSTANCE
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.adplayer.WebViewAdPlayer$special$$inlined$map$5.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
            }
        }, continuation);
        if (collect == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return collect;
        }
        return Unit.INSTANCE;
    }
}
