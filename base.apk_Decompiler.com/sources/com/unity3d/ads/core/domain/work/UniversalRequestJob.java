package com.unity3d.ads.core.domain.work;

import android.content.Context;
import androidx.work.CoroutineWorker;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import com.unity3d.ads.core.data.datasource.UniversalRequestDataSource;
import com.unity3d.ads.core.domain.events.UniversalRequestEventSender;
import com.unity3d.ads.gatewayclient.RequestPolicy;
import com.unity3d.services.core.di.IServiceComponent;
import com.unity3d.services.core.di.IServiceProvider;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0011\u0010\u0019\u001a\u00020\u001aH@ø\u0001\u0000¢\u0006\u0002\u0010\u001bR\u001a\u0010\b\u001a\u00020\tX.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0014\u001a\u00020\u00158FX\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u001c"}, d2 = {"Lcom/unity3d/ads/core/domain/work/UniversalRequestJob;", "Landroidx/work/CoroutineWorker;", "Lcom/unity3d/services/core/di/IServiceComponent;", "context", "Landroid/content/Context;", "workerParams", "Landroidx/work/WorkerParameters;", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "requestPolicy", "Lcom/unity3d/ads/gatewayclient/RequestPolicy;", "getRequestPolicy", "()Lcom/unity3d/ads/gatewayclient/RequestPolicy;", "setRequestPolicy", "(Lcom/unity3d/ads/gatewayclient/RequestPolicy;)V", "universalRequestDataSource", "Lcom/unity3d/ads/core/data/datasource/UniversalRequestDataSource;", "getUniversalRequestDataSource", "()Lcom/unity3d/ads/core/data/datasource/UniversalRequestDataSource;", "universalRequestDataSource$delegate", "Lkotlin/Lazy;", "universalRequestEventSender", "Lcom/unity3d/ads/core/domain/events/UniversalRequestEventSender;", "getUniversalRequestEventSender", "()Lcom/unity3d/ads/core/domain/events/UniversalRequestEventSender;", "universalRequestEventSender$delegate", "doWork", "Landroidx/work/ListenableWorker$Result;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: UniversalRequestJob.kt */
public abstract class UniversalRequestJob extends CoroutineWorker implements IServiceComponent {
    public RequestPolicy requestPolicy;
    private final Lazy universalRequestDataSource$delegate;
    private final Lazy universalRequestEventSender$delegate;
    private final WorkerParameters workerParams;

    public Object doWork(Continuation<? super ListenableWorker.Result> continuation) {
        return doWork$suspendImpl(this, continuation);
    }

    public final void setRequestPolicy(RequestPolicy requestPolicy2) {
        Intrinsics.checkNotNullParameter(requestPolicy2, "<set-?>");
        this.requestPolicy = requestPolicy2;
    }

    public IServiceProvider getServiceProvider() {
        return IServiceComponent.DefaultImpls.getServiceProvider(this);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UniversalRequestJob(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(workerParameters, "workerParams");
        this.workerParams = workerParameters;
        IServiceComponent iServiceComponent = this;
        this.universalRequestEventSender$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new UniversalRequestJob$special$$inlined$inject$default$1(iServiceComponent, ""));
        this.universalRequestDataSource$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new UniversalRequestJob$special$$inlined$inject$default$2(iServiceComponent, ""));
    }

    public final RequestPolicy getRequestPolicy() {
        RequestPolicy requestPolicy2 = this.requestPolicy;
        if (requestPolicy2 != null) {
            return requestPolicy2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("requestPolicy");
        return null;
    }

    public final UniversalRequestEventSender getUniversalRequestEventSender() {
        return (UniversalRequestEventSender) this.universalRequestEventSender$delegate.getValue();
    }

    private final UniversalRequestDataSource getUniversalRequestDataSource() {
        return (UniversalRequestDataSource) this.universalRequestDataSource$delegate.getValue();
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a8 A[Catch:{ all -> 0x0045 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ java.lang.Object doWork$suspendImpl(com.unity3d.ads.core.domain.work.UniversalRequestJob r8, kotlin.coroutines.Continuation<? super androidx.work.ListenableWorker.Result> r9) {
        /*
            boolean r0 = r9 instanceof com.unity3d.ads.core.domain.work.UniversalRequestJob$doWork$1
            if (r0 == 0) goto L_0x0014
            r0 = r9
            com.unity3d.ads.core.domain.work.UniversalRequestJob$doWork$1 r0 = (com.unity3d.ads.core.domain.work.UniversalRequestJob$doWork$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L_0x0019
        L_0x0014:
            com.unity3d.ads.core.domain.work.UniversalRequestJob$doWork$1 r0 = new com.unity3d.ads.core.domain.work.UniversalRequestJob$doWork$1
            r0.<init>(r8, r9)
        L_0x0019:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0053
            if (r2 == r5) goto L_0x0047
            if (r2 == r4) goto L_0x0039
            if (r2 != r3) goto L_0x0031
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x00d2
        L_0x0031:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0039:
            java.lang.Object r8 = r0.L$1
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r2 = r0.L$0
            com.unity3d.ads.core.domain.work.UniversalRequestJob r2 = (com.unity3d.ads.core.domain.work.UniversalRequestJob) r2
            kotlin.ResultKt.throwOnFailure(r9)     // Catch:{ all -> 0x0045 }
            goto L_0x00a9
        L_0x0045:
            r9 = move-exception
            goto L_0x00b0
        L_0x0047:
            java.lang.Object r8 = r0.L$1
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r2 = r0.L$0
            com.unity3d.ads.core.domain.work.UniversalRequestJob r2 = (com.unity3d.ads.core.domain.work.UniversalRequestJob) r2
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0083
        L_0x0053:
            kotlin.ResultKt.throwOnFailure(r9)
            androidx.work.WorkerParameters r9 = r8.workerParams
            androidx.work.Data r9 = r9.getInputData()
            java.lang.String r2 = "universalRequestId"
            java.lang.String r9 = r9.getString(r2)
            if (r9 != 0) goto L_0x006e
            androidx.work.ListenableWorker$Result r8 = androidx.work.ListenableWorker.Result.success()
            java.lang.String r9 = "success()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r9)
            return r8
        L_0x006e:
            com.unity3d.ads.core.data.datasource.UniversalRequestDataSource r2 = r8.getUniversalRequestDataSource()
            r0.L$0 = r8
            r0.L$1 = r9
            r0.label = r5
            java.lang.Object r2 = r2.get(r0)
            if (r2 != r1) goto L_0x007f
            return r1
        L_0x007f:
            r7 = r2
            r2 = r8
            r8 = r9
            r9 = r7
        L_0x0083:
            UniversalRequestStoreOuterClass$UniversalRequestStore r9 = (defpackage.UniversalRequestStoreOuterClass.UniversalRequestStore) r9
            com.google.protobuf.ByteString r9 = r9.getUniversalRequestMapOrThrow(r8)
            gateway.v1.UniversalRequestOuterClass$UniversalRequest r9 = gateway.v1.UniversalRequestOuterClass.UniversalRequest.parseFrom((com.google.protobuf.ByteString) r9)
            kotlin.Result$Companion r5 = kotlin.Result.Companion     // Catch:{ all -> 0x0045 }
            com.unity3d.ads.core.domain.events.UniversalRequestEventSender r5 = r2.getUniversalRequestEventSender()     // Catch:{ all -> 0x0045 }
            java.lang.String r6 = "universalRequest"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r6)     // Catch:{ all -> 0x0045 }
            com.unity3d.ads.gatewayclient.RequestPolicy r6 = r2.getRequestPolicy()     // Catch:{ all -> 0x0045 }
            r0.L$0 = r2     // Catch:{ all -> 0x0045 }
            r0.L$1 = r8     // Catch:{ all -> 0x0045 }
            r0.label = r4     // Catch:{ all -> 0x0045 }
            java.lang.Object r9 = r5.invoke(r9, r6, r0)     // Catch:{ all -> 0x0045 }
            if (r9 != r1) goto L_0x00a9
            return r1
        L_0x00a9:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0045 }
            java.lang.Object r9 = kotlin.Result.m144constructorimpl(r9)     // Catch:{ all -> 0x0045 }
            goto L_0x00ba
        L_0x00b0:
            kotlin.Result$Companion r4 = kotlin.Result.Companion
            java.lang.Object r9 = kotlin.ResultKt.createFailure(r9)
            java.lang.Object r9 = kotlin.Result.m144constructorimpl(r9)
        L_0x00ba:
            boolean r9 = kotlin.Result.m151isSuccessimpl(r9)
            if (r9 == 0) goto L_0x00dc
            com.unity3d.ads.core.data.datasource.UniversalRequestDataSource r9 = r2.getUniversalRequestDataSource()
            r2 = 0
            r0.L$0 = r2
            r0.L$1 = r2
            r0.label = r3
            java.lang.Object r8 = r9.remove(r8, r0)
            if (r8 != r1) goto L_0x00d2
            return r1
        L_0x00d2:
            androidx.work.ListenableWorker$Result r8 = androidx.work.ListenableWorker.Result.success()
            java.lang.String r9 = "{\n            universalR…esult.success()\n        }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r9)
            goto L_0x00e5
        L_0x00dc:
            androidx.work.ListenableWorker$Result r8 = androidx.work.ListenableWorker.Result.retry()
            java.lang.String r9 = "{\n            Result.retry()\n        }"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r9)
        L_0x00e5:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.work.UniversalRequestJob.doWork$suspendImpl(com.unity3d.ads.core.domain.work.UniversalRequestJob, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
