package com.unity3d.ads.core.domain;

import com.unity3d.ads.IUnityAdsShowListener;
import com.unity3d.ads.core.data.model.AdObject;
import kotlin.Metadata;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "Lcom/unity3d/ads/core/data/model/ShowEvent;", "emit", "(Lcom/unity3d/ads/core/data/model/ShowEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: LegacyShowUseCase.kt */
final class LegacyShowUseCase$invoke$4<T> implements FlowCollector {
    final /* synthetic */ AdObject $adObject;
    final /* synthetic */ String $placement;
    final /* synthetic */ long $startTime;
    final /* synthetic */ IUnityAdsShowListener $unityShowListener;
    final /* synthetic */ LegacyShowUseCase this$0;

    LegacyShowUseCase$invoke$4(LegacyShowUseCase legacyShowUseCase, long j, String str, IUnityAdsShowListener iUnityAdsShowListener, AdObject adObject) {
        this.this$0 = legacyShowUseCase;
        this.$startTime = j;
        this.$placement = str;
        this.$unityShowListener = iUnityAdsShowListener;
        this.$adObject = adObject;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x006c, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0086, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00a6, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00c7, code lost:
        r11 = r1.this$0;
        r2 = r1.$startTime;
        r4 = com.unity3d.ads.UnityAds.UnityAdsShowError.INTERNAL_ERROR;
        r5 = ((com.unity3d.ads.core.data.model.ShowEvent.Error) r10).getMessage();
        r6 = r1.$placement;
        r7 = r1.$unityShowListener;
        r8.L$0 = null;
        r8.L$1 = null;
        r8.label = 5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00e4, code lost:
        if (r11.showError(r2, r4, r5, r6, r7, r8) != r0) goto L_0x00e7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00e6, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00e9, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00fe, code lost:
        return kotlin.Unit.INSTANCE;
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object emit(com.unity3d.ads.core.data.model.ShowEvent r10, kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            r9 = this;
            boolean r0 = r11 instanceof com.unity3d.ads.core.domain.LegacyShowUseCase$invoke$4$emit$1
            if (r0 == 0) goto L_0x0014
            r0 = r11
            com.unity3d.ads.core.domain.LegacyShowUseCase$invoke$4$emit$1 r0 = (com.unity3d.ads.core.domain.LegacyShowUseCase$invoke$4$emit$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L_0x0019
        L_0x0014:
            com.unity3d.ads.core.domain.LegacyShowUseCase$invoke$4$emit$1 r0 = new com.unity3d.ads.core.domain.LegacyShowUseCase$invoke$4$emit$1
            r0.<init>(r9, r11)
        L_0x0019:
            r8 = r0
            java.lang.Object r11 = r8.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r8.label
            switch(r1) {
                case 0: goto L_0x0050;
                case 1: goto L_0x004c;
                case 2: goto L_0x0048;
                case 3: goto L_0x0044;
                case 4: goto L_0x0037;
                case 5: goto L_0x0032;
                case 6: goto L_0x002d;
                default: goto L_0x0025;
            }
        L_0x0025:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x002d:
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x00fc
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x00e7
        L_0x0037:
            java.lang.Object r10 = r8.L$1
            com.unity3d.ads.core.data.model.ShowEvent r10 = (com.unity3d.ads.core.data.model.ShowEvent) r10
            java.lang.Object r1 = r8.L$0
            com.unity3d.ads.core.domain.LegacyShowUseCase$invoke$4 r1 = (com.unity3d.ads.core.domain.LegacyShowUseCase$invoke$4) r1
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x00c7
        L_0x0044:
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x00a4
        L_0x0048:
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x0084
        L_0x004c:
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x006a
        L_0x0050:
            kotlin.ResultKt.throwOnFailure(r11)
            boolean r11 = r10 instanceof com.unity3d.ads.core.data.model.ShowEvent.Started
            if (r11 == 0) goto L_0x006d
            com.unity3d.ads.core.domain.LegacyShowUseCase r1 = r9.this$0
            long r2 = r9.$startTime
            java.lang.String r4 = r9.$placement
            com.unity3d.ads.IUnityAdsShowListener r5 = r9.$unityShowListener
            r10 = 1
            r8.label = r10
            r6 = r8
            java.lang.Object r10 = r1.showStarted(r2, r4, r5, r6)
            if (r10 != r0) goto L_0x006a
            return r0
        L_0x006a:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        L_0x006d:
            boolean r11 = r10 instanceof com.unity3d.ads.core.data.model.ShowEvent.Clicked
            if (r11 == 0) goto L_0x0087
            com.unity3d.ads.core.domain.LegacyShowUseCase r1 = r9.this$0
            long r2 = r9.$startTime
            java.lang.String r4 = r9.$placement
            com.unity3d.ads.IUnityAdsShowListener r5 = r9.$unityShowListener
            r10 = 2
            r8.label = r10
            r6 = r8
            java.lang.Object r10 = r1.showClicked(r2, r4, r5, r6)
            if (r10 != r0) goto L_0x0084
            return r0
        L_0x0084:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        L_0x0087:
            boolean r11 = r10 instanceof com.unity3d.ads.core.data.model.ShowEvent.Completed
            if (r11 == 0) goto L_0x00a7
            com.unity3d.ads.core.domain.LegacyShowUseCase r1 = r9.this$0
            long r2 = r9.$startTime
            java.lang.String r4 = r9.$placement
            com.unity3d.ads.core.data.model.ShowEvent$Completed r10 = (com.unity3d.ads.core.data.model.ShowEvent.Completed) r10
            com.unity3d.ads.core.data.model.ShowStatus r5 = r10.getStatus()
            com.unity3d.ads.IUnityAdsShowListener r6 = r9.$unityShowListener
            r10 = 3
            r8.label = r10
            r7 = r8
            java.lang.Object r10 = r1.showCompleted(r2, r4, r5, r6, r7)
            if (r10 != r0) goto L_0x00a4
            return r0
        L_0x00a4:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        L_0x00a7:
            boolean r11 = r10 instanceof com.unity3d.ads.core.data.model.ShowEvent.Error
            if (r11 == 0) goto L_0x00ea
            com.unity3d.ads.core.domain.LegacyShowUseCase r11 = r9.this$0
            gateway.v1.OperativeEventRequestOuterClass$OperativeEventErrorType r1 = gateway.v1.OperativeEventRequestOuterClass.OperativeEventErrorType.OPERATIVE_EVENT_ERROR_TYPE_UNSPECIFIED
            r2 = r10
            com.unity3d.ads.core.data.model.ShowEvent$Error r2 = (com.unity3d.ads.core.data.model.ShowEvent.Error) r2
            java.lang.String r2 = r2.getMessage()
            com.unity3d.ads.core.data.model.AdObject r3 = r9.$adObject
            r8.L$0 = r9
            r8.L$1 = r10
            r4 = 4
            r8.label = r4
            java.lang.Object r11 = r11.sendOperativeError(r1, r2, r3, r8)
            if (r11 != r0) goto L_0x00c6
            return r0
        L_0x00c6:
            r1 = r9
        L_0x00c7:
            com.unity3d.ads.core.domain.LegacyShowUseCase r11 = r1.this$0
            long r2 = r1.$startTime
            com.unity3d.ads.UnityAds$UnityAdsShowError r4 = com.unity3d.ads.UnityAds.UnityAdsShowError.INTERNAL_ERROR
            com.unity3d.ads.core.data.model.ShowEvent$Error r10 = (com.unity3d.ads.core.data.model.ShowEvent.Error) r10
            java.lang.String r5 = r10.getMessage()
            java.lang.String r6 = r1.$placement
            com.unity3d.ads.IUnityAdsShowListener r7 = r1.$unityShowListener
            r10 = 0
            r8.L$0 = r10
            r8.L$1 = r10
            r10 = 5
            r8.label = r10
            r1 = r11
            java.lang.Object r10 = r1.showError(r2, r4, r5, r6, r7, r8)
            if (r10 != r0) goto L_0x00e7
            return r0
        L_0x00e7:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        L_0x00ea:
            boolean r10 = r10 instanceof com.unity3d.ads.core.data.model.ShowEvent.CancelTimeout
            if (r10 == 0) goto L_0x00ff
            com.unity3d.ads.core.domain.LegacyShowUseCase r10 = r9.this$0
            long r1 = r9.$startTime
            r11 = 6
            r8.label = r11
            java.lang.Object r10 = r10.cancelTimeout(r1, r8)
            if (r10 != r0) goto L_0x00fc
            return r0
        L_0x00fc:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        L_0x00ff:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.LegacyShowUseCase$invoke$4.emit(com.unity3d.ads.core.data.model.ShowEvent, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
