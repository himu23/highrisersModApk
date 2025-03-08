package com.unity3d.ads.core.domain.events;

import com.unity3d.ads.core.data.datasource.UniversalRequestDataSource;
import com.unity3d.ads.core.data.repository.OperativeEventRepository;
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

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u0011\u0010\u0010\u001a\u00020\u0011HBø\u0001\u0000¢\u0006\u0002\u0010\u0012R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Lcom/unity3d/ads/core/domain/events/OperativeEventObserver;", "", "getUniversalRequestForPayLoad", "Lcom/unity3d/ads/core/domain/GetUniversalRequestForPayLoad;", "defaultDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "operativeEventRepository", "Lcom/unity3d/ads/core/data/repository/OperativeEventRepository;", "universalRequestDataSource", "Lcom/unity3d/ads/core/data/datasource/UniversalRequestDataSource;", "backgroundWorker", "Lcom/unity3d/ads/core/domain/work/BackgroundWorker;", "(Lcom/unity3d/ads/core/domain/GetUniversalRequestForPayLoad;Lkotlinx/coroutines/CoroutineDispatcher;Lcom/unity3d/ads/core/data/repository/OperativeEventRepository;Lcom/unity3d/ads/core/data/datasource/UniversalRequestDataSource;Lcom/unity3d/ads/core/domain/work/BackgroundWorker;)V", "isRunning", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "invoke", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: OperativeEventObserver.kt */
public final class OperativeEventObserver {
    /* access modifiers changed from: private */
    public final BackgroundWorker backgroundWorker;
    /* access modifiers changed from: private */
    public final CoroutineDispatcher defaultDispatcher;
    /* access modifiers changed from: private */
    public final GetUniversalRequestForPayLoad getUniversalRequestForPayLoad;
    /* access modifiers changed from: private */
    public final MutableStateFlow<Boolean> isRunning = StateFlowKt.MutableStateFlow(false);
    /* access modifiers changed from: private */
    public final OperativeEventRepository operativeEventRepository;
    /* access modifiers changed from: private */
    public final UniversalRequestDataSource universalRequestDataSource;

    public OperativeEventObserver(GetUniversalRequestForPayLoad getUniversalRequestForPayLoad2, CoroutineDispatcher coroutineDispatcher, OperativeEventRepository operativeEventRepository2, UniversalRequestDataSource universalRequestDataSource2, BackgroundWorker backgroundWorker2) {
        Intrinsics.checkNotNullParameter(getUniversalRequestForPayLoad2, "getUniversalRequestForPayLoad");
        Intrinsics.checkNotNullParameter(coroutineDispatcher, "defaultDispatcher");
        Intrinsics.checkNotNullParameter(operativeEventRepository2, "operativeEventRepository");
        Intrinsics.checkNotNullParameter(universalRequestDataSource2, "universalRequestDataSource");
        Intrinsics.checkNotNullParameter(backgroundWorker2, "backgroundWorker");
        this.getUniversalRequestForPayLoad = getUniversalRequestForPayLoad2;
        this.defaultDispatcher = coroutineDispatcher;
        this.operativeEventRepository = operativeEventRepository2;
        this.universalRequestDataSource = universalRequestDataSource2;
        this.backgroundWorker = backgroundWorker2;
    }

    public final Object invoke(Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(this.defaultDispatcher, new OperativeEventObserver$invoke$2(this, (Continuation<? super OperativeEventObserver$invoke$2>) null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }
}
