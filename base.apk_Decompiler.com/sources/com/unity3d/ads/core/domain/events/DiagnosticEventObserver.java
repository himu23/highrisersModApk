package com.unity3d.ads.core.domain.events;

import com.unity3d.ads.core.data.datasource.UniversalRequestDataSource;
import com.unity3d.ads.core.data.repository.DiagnosticEventRepository;
import com.unity3d.ads.core.domain.GetUniversalRequestForPayLoad;
import com.unity3d.ads.core.domain.work.BackgroundWorker;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0011\u0010\u0012\u001a\u00020\u0013HBø\u0001\u0000¢\u0006\u0002\u0010\u0014R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"Lcom/unity3d/ads/core/domain/events/DiagnosticEventObserver;", "", "getUniversalRequestForPayLoad", "Lcom/unity3d/ads/core/domain/GetUniversalRequestForPayLoad;", "getDiagnosticEventBatchRequest", "Lcom/unity3d/ads/core/domain/events/GetDiagnosticEventBatchRequest;", "defaultDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "diagnosticEventRepository", "Lcom/unity3d/ads/core/data/repository/DiagnosticEventRepository;", "universalRequestDataSource", "Lcom/unity3d/ads/core/data/datasource/UniversalRequestDataSource;", "backgroundWorker", "Lcom/unity3d/ads/core/domain/work/BackgroundWorker;", "(Lcom/unity3d/ads/core/domain/GetUniversalRequestForPayLoad;Lcom/unity3d/ads/core/domain/events/GetDiagnosticEventBatchRequest;Lkotlinx/coroutines/CoroutineDispatcher;Lcom/unity3d/ads/core/data/repository/DiagnosticEventRepository;Lcom/unity3d/ads/core/data/datasource/UniversalRequestDataSource;Lcom/unity3d/ads/core/domain/work/BackgroundWorker;)V", "isRunning", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "invoke", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: DiagnosticEventObserver.kt */
public final class DiagnosticEventObserver {
    /* access modifiers changed from: private */
    public final BackgroundWorker backgroundWorker;
    /* access modifiers changed from: private */
    public final CoroutineDispatcher defaultDispatcher;
    /* access modifiers changed from: private */
    public final DiagnosticEventRepository diagnosticEventRepository;
    /* access modifiers changed from: private */
    public final GetDiagnosticEventBatchRequest getDiagnosticEventBatchRequest;
    /* access modifiers changed from: private */
    public final GetUniversalRequestForPayLoad getUniversalRequestForPayLoad;
    /* access modifiers changed from: private */
    public final MutableStateFlow<Boolean> isRunning = StateFlowKt.MutableStateFlow(false);
    /* access modifiers changed from: private */
    public final UniversalRequestDataSource universalRequestDataSource;

    public DiagnosticEventObserver(GetUniversalRequestForPayLoad getUniversalRequestForPayLoad2, GetDiagnosticEventBatchRequest getDiagnosticEventBatchRequest2, CoroutineDispatcher coroutineDispatcher, DiagnosticEventRepository diagnosticEventRepository2, UniversalRequestDataSource universalRequestDataSource2, BackgroundWorker backgroundWorker2) {
        Intrinsics.checkNotNullParameter(getUniversalRequestForPayLoad2, "getUniversalRequestForPayLoad");
        Intrinsics.checkNotNullParameter(getDiagnosticEventBatchRequest2, "getDiagnosticEventBatchRequest");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "defaultDispatcher");
        Intrinsics.checkNotNullParameter(diagnosticEventRepository2, "diagnosticEventRepository");
        Intrinsics.checkNotNullParameter(universalRequestDataSource2, "universalRequestDataSource");
        Intrinsics.checkNotNullParameter(backgroundWorker2, "backgroundWorker");
        this.getUniversalRequestForPayLoad = getUniversalRequestForPayLoad2;
        this.getDiagnosticEventBatchRequest = getDiagnosticEventBatchRequest2;
        this.defaultDispatcher = coroutineDispatcher;
        this.diagnosticEventRepository = diagnosticEventRepository2;
        this.universalRequestDataSource = universalRequestDataSource2;
        this.backgroundWorker = backgroundWorker2;
    }

    public final Object invoke(Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(this.defaultDispatcher, new DiagnosticEventObserver$invoke$2(this, (Continuation<? super DiagnosticEventObserver$invoke$2>) null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }
}
