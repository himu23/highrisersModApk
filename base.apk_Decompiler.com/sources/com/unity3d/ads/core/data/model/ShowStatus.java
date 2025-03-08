package com.unity3d.ads.core.data.model;

import com.unity3d.ads.UnityAds;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/unity3d/ads/core/data/model/ShowStatus;", "", "(Ljava/lang/String;I)V", "toUnityAdsShowCompletionState", "Lcom/unity3d/ads/UnityAds$UnityAdsShowCompletionState;", "COMPLETED", "SKIPPED", "ERROR", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: ShowStatus.kt */
public enum ShowStatus {
    COMPLETED,
    SKIPPED,
    ERROR;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* compiled from: ShowStatus.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        static {
            /*
                com.unity3d.ads.core.data.model.ShowStatus[] r0 = com.unity3d.ads.core.data.model.ShowStatus.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.unity3d.ads.core.data.model.ShowStatus r1 = com.unity3d.ads.core.data.model.ShowStatus.COMPLETED     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.unity3d.ads.core.data.model.ShowStatus r1 = com.unity3d.ads.core.data.model.ShowStatus.SKIPPED     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.data.model.ShowStatus.WhenMappings.<clinit>():void");
        }
    }

    public final UnityAds.UnityAdsShowCompletionState toUnityAdsShowCompletionState() {
        int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i == 1) {
            return UnityAds.UnityAdsShowCompletionState.COMPLETED;
        }
        if (i == 2) {
            return UnityAds.UnityAdsShowCompletionState.SKIPPED;
        }
        throw new IllegalStateException("Unexpected show status: " + this);
    }
}
