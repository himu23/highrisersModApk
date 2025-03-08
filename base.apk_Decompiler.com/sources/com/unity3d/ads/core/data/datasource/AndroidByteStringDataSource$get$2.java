package com.unity3d.ads.core.data.datasource;

import androidx.datastore.core.CorruptionException;
import com.google.protobuf.ByteString;
import defpackage.ByteStringStoreKt;
import defpackage.ByteStringStoreOuterClass;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0005\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H@"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "LByteStringStoreOuterClass$ByteStringStore;", "", "exception", "", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.unity3d.ads.core.data.datasource.AndroidByteStringDataSource$get$2", f = "AndroidByteStringDataSource.kt", i = {}, l = {18}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: AndroidByteStringDataSource.kt */
final class AndroidByteStringDataSource$get$2 extends SuspendLambda implements Function3<FlowCollector<? super ByteStringStoreOuterClass.ByteStringStore>, Throwable, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    AndroidByteStringDataSource$get$2(Continuation<? super AndroidByteStringDataSource$get$2> continuation) {
        super(3, continuation);
    }

    public final Object invoke(FlowCollector<? super ByteStringStoreOuterClass.ByteStringStore> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
        AndroidByteStringDataSource$get$2 androidByteStringDataSource$get$2 = new AndroidByteStringDataSource$get$2(continuation);
        androidByteStringDataSource$get$2.L$0 = flowCollector;
        androidByteStringDataSource$get$2.L$1 = th;
        return androidByteStringDataSource$get$2.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            Throwable th = (Throwable) this.L$1;
            if (th instanceof CorruptionException) {
                ByteStringStoreKt.Dsl.Companion companion = ByteStringStoreKt.Dsl.Companion;
                ByteStringStoreOuterClass.ByteStringStore.Builder newBuilder = ByteStringStoreOuterClass.ByteStringStore.newBuilder();
                Intrinsics.checkNotNullExpressionValue(newBuilder, "newBuilder()");
                ByteStringStoreKt.Dsl _create = companion._create(newBuilder);
                ByteString byteString = ByteString.EMPTY;
                Intrinsics.checkNotNullExpressionValue(byteString, "EMPTY");
                _create.setData(byteString);
                this.L$0 = null;
                this.label = 1;
                if (flowCollector.emit(_create._build(), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                throw th;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
