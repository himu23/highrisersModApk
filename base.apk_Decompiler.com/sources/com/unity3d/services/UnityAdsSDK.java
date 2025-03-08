package com.unity3d.services;

import android.content.Context;
import com.ironsource.m2;
import com.unity3d.ads.IUnityAdsLoadListener;
import com.unity3d.ads.IUnityAdsShowListener;
import com.unity3d.ads.UnityAdsLoadOptions;
import com.unity3d.ads.UnityAdsShowOptions;
import com.unity3d.ads.core.configuration.AlternativeFlowReader;
import com.unity3d.ads.core.domain.InitializeBoldSDK;
import com.unity3d.ads.core.domain.LegacyShowUseCase;
import com.unity3d.services.core.di.IServiceComponent;
import com.unity3d.services.core.di.IServiceProvider;
import com.unity3d.services.core.di.ServiceProvider;
import com.unity3d.services.core.domain.task.InitializeSDK;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\"\u001a\u00020#J \u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*J\"\u0010+\u001a\u00020#2\u0006\u0010%\u001a\u00020&2\b\u0010,\u001a\u0004\u0018\u00010-2\b\u0010)\u001a\u0004\u0018\u00010.R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\b\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0002¢\u0006\f\n\u0004\b\u0017\u0010\b\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0002¢\u0006\f\n\u0004\b\u001c\u0010\b\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010\u001d\u001a\u00020\u001e8BX\u0002¢\u0006\f\n\u0004\b!\u0010\b\u001a\u0004\b\u001f\u0010 ¨\u0006/"}, d2 = {"Lcom/unity3d/services/UnityAdsSDK;", "Lcom/unity3d/services/core/di/IServiceComponent;", "()V", "alternativeFlowReader", "Lcom/unity3d/ads/core/configuration/AlternativeFlowReader;", "getAlternativeFlowReader", "()Lcom/unity3d/ads/core/configuration/AlternativeFlowReader;", "alternativeFlowReader$delegate", "Lkotlin/Lazy;", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context$delegate", "initializeBoldSDK", "Lcom/unity3d/ads/core/domain/InitializeBoldSDK;", "getInitializeBoldSDK", "()Lcom/unity3d/ads/core/domain/InitializeBoldSDK;", "initializeBoldSDK$delegate", "initializeSDK", "Lcom/unity3d/services/core/domain/task/InitializeSDK;", "getInitializeSDK", "()Lcom/unity3d/services/core/domain/task/InitializeSDK;", "initializeSDK$delegate", "sdkScope", "Lkotlinx/coroutines/CoroutineScope;", "getSdkScope", "()Lkotlinx/coroutines/CoroutineScope;", "sdkScope$delegate", "showBoldSDK", "Lcom/unity3d/ads/core/domain/LegacyShowUseCase;", "getShowBoldSDK", "()Lcom/unity3d/ads/core/domain/LegacyShowUseCase;", "showBoldSDK$delegate", "initialize", "Lkotlinx/coroutines/Job;", "load", "placementId", "", "loadOptions", "Lcom/unity3d/ads/UnityAdsLoadOptions;", "listener", "Lcom/unity3d/ads/IUnityAdsLoadListener;", "show", "showOptions", "Lcom/unity3d/ads/UnityAdsShowOptions;", "Lcom/unity3d/ads/IUnityAdsShowListener;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: UnityAdsSDK.kt */
public final class UnityAdsSDK implements IServiceComponent {
    public static final UnityAdsSDK INSTANCE;
    private static final Lazy alternativeFlowReader$delegate;
    private static final Lazy context$delegate;
    private static final Lazy initializeBoldSDK$delegate;
    private static final Lazy initializeSDK$delegate;
    private static final Lazy sdkScope$delegate;
    private static final Lazy showBoldSDK$delegate;

    private UnityAdsSDK() {
    }

    public IServiceProvider getServiceProvider() {
        return IServiceComponent.DefaultImpls.getServiceProvider(this);
    }

    static {
        UnityAdsSDK unityAdsSDK = new UnityAdsSDK();
        INSTANCE = unityAdsSDK;
        sdkScope$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new UnityAdsSDK$special$$inlined$inject$default$1(unityAdsSDK, ServiceProvider.NAMED_SDK));
        initializeSDK$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new UnityAdsSDK$special$$inlined$inject$default$2(unityAdsSDK, ""));
        alternativeFlowReader$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new UnityAdsSDK$special$$inlined$inject$default$3(unityAdsSDK, ""));
        initializeBoldSDK$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new UnityAdsSDK$special$$inlined$inject$default$4(unityAdsSDK, ""));
        showBoldSDK$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new UnityAdsSDK$special$$inlined$inject$default$5(unityAdsSDK, ""));
        context$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new UnityAdsSDK$special$$inlined$inject$default$6(unityAdsSDK, ""));
    }

    private final CoroutineScope getSdkScope() {
        return (CoroutineScope) sdkScope$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final InitializeSDK getInitializeSDK() {
        return (InitializeSDK) initializeSDK$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final AlternativeFlowReader getAlternativeFlowReader() {
        return (AlternativeFlowReader) alternativeFlowReader$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final InitializeBoldSDK getInitializeBoldSDK() {
        return (InitializeBoldSDK) initializeBoldSDK$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final LegacyShowUseCase getShowBoldSDK() {
        return (LegacyShowUseCase) showBoldSDK$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final Context getContext() {
        return (Context) context$delegate.getValue();
    }

    public final Job initialize() {
        return BuildersKt__Builders_commonKt.launch$default(getSdkScope(), (CoroutineContext) null, (CoroutineStart) null, new UnityAdsSDK$initialize$1((Continuation<? super UnityAdsSDK$initialize$1>) null), 3, (Object) null);
    }

    public final Job load(String str, UnityAdsLoadOptions unityAdsLoadOptions, IUnityAdsLoadListener iUnityAdsLoadListener) {
        Intrinsics.checkNotNullParameter(str, m2.i);
        Intrinsics.checkNotNullParameter(unityAdsLoadOptions, "loadOptions");
        return BuildersKt__Builders_commonKt.launch$default(getSdkScope(), (CoroutineContext) null, (CoroutineStart) null, new UnityAdsSDK$load$1(str, unityAdsLoadOptions, iUnityAdsLoadListener, (Continuation<? super UnityAdsSDK$load$1>) null), 3, (Object) null);
    }

    public final Job show(String str, UnityAdsShowOptions unityAdsShowOptions, IUnityAdsShowListener iUnityAdsShowListener) {
        Intrinsics.checkNotNullParameter(str, m2.i);
        return BuildersKt__Builders_commonKt.launch$default(getSdkScope(), (CoroutineContext) null, (CoroutineStart) null, new UnityAdsSDK$show$1(str, unityAdsShowOptions, iUnityAdsShowListener, (Continuation<? super UnityAdsSDK$show$1>) null), 3, (Object) null);
    }
}
