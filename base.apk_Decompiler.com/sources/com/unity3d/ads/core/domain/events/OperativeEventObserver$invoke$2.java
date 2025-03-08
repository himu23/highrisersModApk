package com.unity3d.ads.core.domain.events;

import androidx.work.Constraints;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkRequest;
import com.google.protobuf.kotlin.ByteStringsKt;
import com.unity3d.ads.core.data.datasource.UniversalRequestDataSource;
import com.unity3d.ads.core.domain.work.BackgroundWorker;
import com.unity3d.ads.core.domain.work.OperativeEventJob;
import com.unity3d.ads.core.domain.work.UniversalRequestWorkerData;
import gateway.v1.OperativeEventRequestOuterClass;
import gateway.v1.UniversalRequestKt;
import gateway.v1.UniversalRequestOuterClass;
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
@DebugMetadata(c = "com.unity3d.ads.core.domain.events.OperativeEventObserver$invoke$2", f = "OperativeEventObserver.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: OperativeEventObserver.kt */
final class OperativeEventObserver$invoke$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ OperativeEventObserver this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OperativeEventObserver$invoke$2(OperativeEventObserver operativeEventObserver, Continuation<? super OperativeEventObserver$invoke$2> continuation) {
        super(2, continuation);
        this.this$0 = operativeEventObserver;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OperativeEventObserver$invoke$2(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((OperativeEventObserver$invoke$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
            final OperativeEventObserver operativeEventObserver = this.this$0;
            FlowKt.launchIn(FlowKt.onEach(this.this$0.operativeEventRepository.getOperativeEvents(), new AnonymousClass2((Continuation<? super AnonymousClass2>) null)), CoroutineScopeKt.CoroutineScope(this.this$0.defaultDispatcher));
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H@"}, d2 = {"Lgateway/v1/OperativeEventRequestOuterClass$OperativeEventRequest;", "operativeEventRequest", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    @DebugMetadata(c = "com.unity3d.ads.core.domain.events.OperativeEventObserver$invoke$2$2", f = "OperativeEventObserver.kt", i = {1}, l = {36, 39}, m = "invokeSuspend", n = {"workId"}, s = {"L$0"})
    /* renamed from: com.unity3d.ads.core.domain.events.OperativeEventObserver$invoke$2$2  reason: invalid class name */
    /* compiled from: OperativeEventObserver.kt */
    static final class AnonymousClass2 extends SuspendLambda implements Function2<OperativeEventRequestOuterClass.OperativeEventRequest, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 r0 = new AnonymousClass2(operativeEventObserver, continuation);
            r0.L$0 = obj;
            return r0;
        }

        public final Object invoke(OperativeEventRequestOuterClass.OperativeEventRequest operativeEventRequest, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(operativeEventRequest, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            String str;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                UniversalRequestKt universalRequestKt = UniversalRequestKt.INSTANCE;
                UniversalRequestKt.PayloadKt.Dsl.Companion companion = UniversalRequestKt.PayloadKt.Dsl.Companion;
                UniversalRequestOuterClass.UniversalRequest.Payload.Builder newBuilder = UniversalRequestOuterClass.UniversalRequest.Payload.newBuilder();
                Intrinsics.checkNotNullExpressionValue(newBuilder, "newBuilder()");
                UniversalRequestKt.PayloadKt.Dsl _create = companion._create(newBuilder);
                _create.setOperativeEvent((OperativeEventRequestOuterClass.OperativeEventRequest) this.L$0);
                UniversalRequestOuterClass.UniversalRequest.Payload _build = _create._build();
                this.label = 1;
                obj = operativeEventObserver.getUniversalRequestForPayLoad.invoke(_build, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else if (i == 2) {
                str = (String) this.L$0;
                ResultKt.throwOnFailure(obj);
                UniversalRequestWorkerData universalRequestWorkerData = new UniversalRequestWorkerData(str);
                BackgroundWorker access$getBackgroundWorker$p = operativeEventObserver.backgroundWorker;
                Constraints build = new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build();
                Intrinsics.checkNotNullExpressionValue(build, "Builder()\n            .s…TED)\n            .build()");
                WorkRequest build2 = ((OneTimeWorkRequest.Builder) ((OneTimeWorkRequest.Builder) new OneTimeWorkRequest.Builder(OperativeEventJob.class).setConstraints(build)).setInputData(universalRequestWorkerData.invoke())).build();
                Intrinsics.checkNotNullExpressionValue(build2, "OneTimeWorkRequestBuilde…a())\n            .build()");
                access$getBackgroundWorker$p.getWorkManager().enqueue((WorkRequest) (OneTimeWorkRequest) build2);
                return Unit.INSTANCE;
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            String uuid = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
            UniversalRequestDataSource access$getUniversalRequestDataSource$p = operativeEventObserver.universalRequestDataSource;
            byte[] byteArray = ((UniversalRequestOuterClass.UniversalRequest) obj).toByteArray();
            Intrinsics.checkNotNullExpressionValue(byteArray, "fullRequest.toByteArray()");
            this.L$0 = uuid;
            this.label = 2;
            if (access$getUniversalRequestDataSource$p.set(uuid, ByteStringsKt.toByteString(byteArray), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            str = uuid;
            UniversalRequestWorkerData universalRequestWorkerData2 = new UniversalRequestWorkerData(str);
            BackgroundWorker access$getBackgroundWorker$p2 = operativeEventObserver.backgroundWorker;
            Constraints build3 = new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build();
            Intrinsics.checkNotNullExpressionValue(build3, "Builder()\n            .s…TED)\n            .build()");
            WorkRequest build22 = ((OneTimeWorkRequest.Builder) ((OneTimeWorkRequest.Builder) new OneTimeWorkRequest.Builder(OperativeEventJob.class).setConstraints(build3)).setInputData(universalRequestWorkerData2.invoke())).build();
            Intrinsics.checkNotNullExpressionValue(build22, "OneTimeWorkRequestBuilde…a())\n            .build()");
            access$getBackgroundWorker$p2.getWorkManager().enqueue((WorkRequest) (OneTimeWorkRequest) build22);
            return Unit.INSTANCE;
        }
    }
}
