package com.unity3d.ads.core.domain.events;

import androidx.work.Constraints;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkRequest;
import com.google.protobuf.kotlin.ByteStringsKt;
import com.unity3d.ads.core.data.datasource.UniversalRequestDataSource;
import com.unity3d.ads.core.domain.work.BackgroundWorker;
import com.unity3d.ads.core.domain.work.DiagnosticEventJob;
import com.unity3d.ads.core.domain.work.UniversalRequestWorkerData;
import gateway.v1.DiagnosticEventRequestOuterClass;
import gateway.v1.UniversalRequestKt;
import gateway.v1.UniversalRequestOuterClass;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.unity3d.ads.core.domain.events.DiagnosticEventObserver$invoke$2", f = "DiagnosticEventObserver.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: DiagnosticEventObserver.kt */
final class DiagnosticEventObserver$invoke$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DiagnosticEventObserver this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DiagnosticEventObserver$invoke$2(DiagnosticEventObserver diagnosticEventObserver, Continuation<? super DiagnosticEventObserver$invoke$2> continuation) {
        super(2, continuation);
        this.this$0 = diagnosticEventObserver;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DiagnosticEventObserver$invoke$2(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DiagnosticEventObserver$invoke$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object value;
        Boolean bool;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            MutableStateFlow access$isRunning$p = this.this$0.isRunning;
            do {
                value = access$isRunning$p.getValue();
                bool = (Boolean) value;
                bool.booleanValue();
            } while (!access$isRunning$p.compareAndSet(value, Boxing.boxBoolean(true)));
            if (bool.booleanValue()) {
                return Unit.INSTANCE;
            }
            final DiagnosticEventObserver diagnosticEventObserver = this.this$0;
            FlowKt.launchIn(FlowKt.onEach(this.this$0.diagnosticEventRepository.getDiagnosticEvents(), new AnonymousClass2((Continuation<? super AnonymousClass2>) null)), CoroutineScopeKt.CoroutineScope(this.this$0.defaultDispatcher));
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H@"}, d2 = {"", "Lgateway/v1/DiagnosticEventRequestOuterClass$DiagnosticEvent;", "currentDiagnosticEventRequest", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    @DebugMetadata(c = "com.unity3d.ads.core.domain.events.DiagnosticEventObserver$invoke$2$2", f = "DiagnosticEventObserver.kt", i = {1}, l = {38, 41}, m = "invokeSuspend", n = {"workId"}, s = {"L$0"})
    /* renamed from: com.unity3d.ads.core.domain.events.DiagnosticEventObserver$invoke$2$2  reason: invalid class name */
    /* compiled from: DiagnosticEventObserver.kt */
    static final class AnonymousClass2 extends SuspendLambda implements Function2<List<? extends DiagnosticEventRequestOuterClass.DiagnosticEvent>, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 r0 = new AnonymousClass2(diagnosticEventObserver, continuation);
            r0.L$0 = obj;
            return r0;
        }

        public final Object invoke(List<DiagnosticEventRequestOuterClass.DiagnosticEvent> list, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(list, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            String str;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                UniversalRequestKt universalRequestKt = UniversalRequestKt.INSTANCE;
                DiagnosticEventObserver diagnosticEventObserver = diagnosticEventObserver;
                UniversalRequestKt.PayloadKt.Dsl.Companion companion = UniversalRequestKt.PayloadKt.Dsl.Companion;
                UniversalRequestOuterClass.UniversalRequest.Payload.Builder newBuilder = UniversalRequestOuterClass.UniversalRequest.Payload.newBuilder();
                Intrinsics.checkNotNullExpressionValue(newBuilder, "newBuilder()");
                UniversalRequestKt.PayloadKt.Dsl _create = companion._create(newBuilder);
                _create.setDiagnosticEventRequest(diagnosticEventObserver.getDiagnosticEventBatchRequest.invoke((List) this.L$0));
                UniversalRequestOuterClass.UniversalRequest.Payload _build = _create._build();
                this.label = 1;
                obj = diagnosticEventObserver.getUniversalRequestForPayLoad.invoke(_build, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else if (i == 2) {
                str = (String) this.L$0;
                ResultKt.throwOnFailure(obj);
                UniversalRequestWorkerData universalRequestWorkerData = new UniversalRequestWorkerData(str);
                BackgroundWorker access$getBackgroundWorker$p = diagnosticEventObserver.backgroundWorker;
                Constraints build = new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build();
                Intrinsics.checkNotNullExpressionValue(build, "Builder()\n            .s…TED)\n            .build()");
                WorkRequest build2 = ((OneTimeWorkRequest.Builder) ((OneTimeWorkRequest.Builder) new OneTimeWorkRequest.Builder(DiagnosticEventJob.class).setConstraints(build)).setInputData(universalRequestWorkerData.invoke())).build();
                Intrinsics.checkNotNullExpressionValue(build2, "OneTimeWorkRequestBuilde…a())\n            .build()");
                access$getBackgroundWorker$p.getWorkManager().enqueue((WorkRequest) (OneTimeWorkRequest) build2);
                return Unit.INSTANCE;
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            String uuid = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
            UniversalRequestDataSource access$getUniversalRequestDataSource$p = diagnosticEventObserver.universalRequestDataSource;
            byte[] byteArray = ((UniversalRequestOuterClass.UniversalRequest) obj).toByteArray();
            Intrinsics.checkNotNullExpressionValue(byteArray, "fullRequest.toByteArray()");
            this.L$0 = uuid;
            this.label = 2;
            if (access$getUniversalRequestDataSource$p.set(uuid, ByteStringsKt.toByteString(byteArray), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            str = uuid;
            UniversalRequestWorkerData universalRequestWorkerData2 = new UniversalRequestWorkerData(str);
            BackgroundWorker access$getBackgroundWorker$p2 = diagnosticEventObserver.backgroundWorker;
            Constraints build3 = new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build();
            Intrinsics.checkNotNullExpressionValue(build3, "Builder()\n            .s…TED)\n            .build()");
            WorkRequest build22 = ((OneTimeWorkRequest.Builder) ((OneTimeWorkRequest.Builder) new OneTimeWorkRequest.Builder(DiagnosticEventJob.class).setConstraints(build3)).setInputData(universalRequestWorkerData2.invoke())).build();
            Intrinsics.checkNotNullExpressionValue(build22, "OneTimeWorkRequestBuilde…a())\n            .build()");
            access$getBackgroundWorker$p2.getWorkManager().enqueue((WorkRequest) (OneTimeWorkRequest) build22);
            return Unit.INSTANCE;
        }
    }
}
