package com.unity3d.ads.core.domain;

import com.unity3d.ads.UnityAds;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/unity3d/ads/core/domain/TriggerInitializeListener;", "", "coroutineDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Lkotlinx/coroutines/CoroutineDispatcher;)V", "error", "", "unityAdsInitializationError", "Lcom/unity3d/ads/UnityAds$UnityAdsInitializationError;", "errorMsg", "", "success", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: TriggerInitializeListener.kt */
public final class TriggerInitializeListener {
    private final CoroutineDispatcher coroutineDispatcher;

    public TriggerInitializeListener(CoroutineDispatcher coroutineDispatcher2) {
        Intrinsics.checkNotNullParameter(coroutineDispatcher2, "coroutineDispatcher");
        this.coroutineDispatcher = coroutineDispatcher2;
    }

    public final void success() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(this.coroutineDispatcher), (CoroutineContext) null, (CoroutineStart) null, new TriggerInitializeListener$success$1((Continuation<? super TriggerInitializeListener$success$1>) null), 3, (Object) null);
    }

    public final void error(UnityAds.UnityAdsInitializationError unityAdsInitializationError, String str) {
        Intrinsics.checkNotNullParameter(unityAdsInitializationError, "unityAdsInitializationError");
        Intrinsics.checkNotNullParameter(str, "errorMsg");
        Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(this.coroutineDispatcher), (CoroutineContext) null, (CoroutineStart) null, new TriggerInitializeListener$error$1(unityAdsInitializationError, str, (Continuation<? super TriggerInitializeListener$error$1>) null), 3, (Object) null);
    }
}
