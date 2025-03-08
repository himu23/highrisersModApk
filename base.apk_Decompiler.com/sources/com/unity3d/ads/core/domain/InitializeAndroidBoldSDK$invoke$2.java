package com.unity3d.ads.core.domain;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutKt;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.unity3d.ads.core.domain.InitializeAndroidBoldSDK$invoke$2", f = "InitializeAndroidBoldSDK.kt", i = {0}, l = {51, 60, 64}, m = "invokeSuspend", n = {"startTime"}, s = {"J$0"})
/* compiled from: InitializeAndroidBoldSDK.kt */
final class InitializeAndroidBoldSDK$invoke$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    long J$0;
    int label;
    final /* synthetic */ InitializeAndroidBoldSDK this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InitializeAndroidBoldSDK$invoke$2(InitializeAndroidBoldSDK initializeAndroidBoldSDK, Continuation<? super InitializeAndroidBoldSDK$invoke$2> continuation) {
        super(2, continuation);
        this.this$0 = initializeAndroidBoldSDK;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new InitializeAndroidBoldSDK$invoke$2(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((InitializeAndroidBoldSDK$invoke$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        long j;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            long nanoTime = System.nanoTime();
            try {
                final InitializeAndroidBoldSDK initializeAndroidBoldSDK = this.this$0;
                this.J$0 = nanoTime;
                this.label = 1;
                if (TimeoutKt.withTimeout(10000, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                j = nanoTime;
            } catch (Exception e) {
                e = e;
                j = nanoTime;
                this.label = 2;
                if (this.this$0.initializationFailure(j, e, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
        } else if (i == 1) {
            j = this.J$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Exception e2) {
                e = e2;
            }
        } else if (i == 2) {
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        } else if (i == 3) {
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.label = 3;
        if (this.this$0.initializationSuccess(j, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    @DebugMetadata(c = "com.unity3d.ads.core.domain.InitializeAndroidBoldSDK$invoke$2$1", f = "InitializeAndroidBoldSDK.kt", i = {}, l = {52, 54, 56, 57}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.unity3d.ads.core.domain.InitializeAndroidBoldSDK$invoke$2$1  reason: invalid class name */
    /* compiled from: InitializeAndroidBoldSDK.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(initializeAndroidBoldSDK, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARNING: Removed duplicated region for block: B:20:0x0078 A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x0099 A[RETURN] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r13) {
            /*
                r12 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r12.label
                r2 = 4
                r3 = 3
                r4 = 2
                r5 = 1
                if (r1 == 0) goto L_0x002d
                if (r1 == r5) goto L_0x0029
                if (r1 == r4) goto L_0x0025
                if (r1 == r3) goto L_0x0021
                if (r1 != r2) goto L_0x0019
                kotlin.ResultKt.throwOnFailure(r13)
                goto L_0x009a
            L_0x0019:
                java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r13.<init>(r0)
                throw r13
            L_0x0021:
                kotlin.ResultKt.throwOnFailure(r13)
                goto L_0x0079
            L_0x0025:
                kotlin.ResultKt.throwOnFailure(r13)
                goto L_0x0055
            L_0x0029:
                kotlin.ResultKt.throwOnFailure(r13)
                goto L_0x003e
            L_0x002d:
                kotlin.ResultKt.throwOnFailure(r13)
                com.unity3d.ads.core.domain.InitializeAndroidBoldSDK r13 = r1
                r1 = r12
                kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
                r12.label = r5
                java.lang.Object r13 = r13.initializationStart(r1)
                if (r13 != r0) goto L_0x003e
                return r0
            L_0x003e:
                com.unity3d.ads.core.domain.InitializeAndroidBoldSDK r13 = r1
                r13.checkCanInitialize()
                com.unity3d.ads.core.domain.InitializeAndroidBoldSDK r13 = r1
                com.unity3d.ads.core.domain.GetInitializationRequest r13 = r13.getInitializeRequest
                r1 = r12
                kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
                r12.label = r4
                java.lang.Object r13 = r13.invoke(r1)
                if (r13 != r0) goto L_0x0055
                return r0
            L_0x0055:
                r6 = r13
                gateway.v1.UniversalRequestOuterClass$UniversalRequest r6 = (gateway.v1.UniversalRequestOuterClass.UniversalRequest) r6
                com.unity3d.ads.core.domain.InitializeAndroidBoldSDK r13 = r1
                com.unity3d.ads.core.domain.GetRequestPolicy r13 = r13.getRequestPolicy
                com.unity3d.ads.gatewayclient.RequestPolicy r7 = r13.invoke()
                com.unity3d.ads.core.domain.InitializeAndroidBoldSDK r13 = r1
                com.unity3d.ads.gatewayclient.GatewayClient r4 = r13.gatewayClient
                r5 = 0
                com.unity3d.ads.core.data.model.OperationType r8 = com.unity3d.ads.core.data.model.OperationType.INITIALIZATION
                r9 = r12
                kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9
                r10 = 1
                r11 = 0
                r12.label = r3
                java.lang.Object r13 = com.unity3d.ads.gatewayclient.GatewayClient.DefaultImpls.request$default(r4, r5, r6, r7, r8, r9, r10, r11)
                if (r13 != r0) goto L_0x0079
                return r0
            L_0x0079:
                gateway.v1.UniversalResponseOuterClass$UniversalResponse r13 = (gateway.v1.UniversalResponseOuterClass.UniversalResponse) r13
                com.unity3d.ads.core.domain.InitializeAndroidBoldSDK r1 = r1
                com.unity3d.ads.core.domain.HandleGatewayInitializationResponse r1 = r1.handleGatewayInitializationResponse
                gateway.v1.UniversalResponseOuterClass$UniversalResponse$Payload r13 = r13.getPayload()
                gateway.v1.InitializationResponseOuterClass$InitializationResponse r13 = r13.getInitializationResponse()
                java.lang.String r3 = "response.payload.initializationResponse"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r13, r3)
                r3 = r12
                kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
                r12.label = r2
                java.lang.Object r13 = r1.invoke(r13, r3)
                if (r13 != r0) goto L_0x009a
                return r0
            L_0x009a:
                kotlin.Unit r13 = kotlin.Unit.INSTANCE
                return r13
            */
            throw new UnsupportedOperationException("Method not decompiled: com.unity3d.ads.core.domain.InitializeAndroidBoldSDK$invoke$2.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }
}
