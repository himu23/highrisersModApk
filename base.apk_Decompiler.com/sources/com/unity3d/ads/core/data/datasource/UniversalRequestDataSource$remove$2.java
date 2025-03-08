package com.unity3d.ads.core.data.datasource;

import com.google.protobuf.GeneratedMessageLite;
import defpackage.UniversalRequestStoreOuterClass;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H@"}, d2 = {"LUniversalRequestStoreOuterClass$UniversalRequestStore;", "currentData", "<anonymous>"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "com.unity3d.ads.core.data.datasource.UniversalRequestDataSource$remove$2", f = "UniversalRequestDataSource.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: UniversalRequestDataSource.kt */
final class UniversalRequestDataSource$remove$2 extends SuspendLambda implements Function2<UniversalRequestStoreOuterClass.UniversalRequestStore, Continuation<? super UniversalRequestStoreOuterClass.UniversalRequestStore>, Object> {
    final /* synthetic */ String $key;
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UniversalRequestDataSource$remove$2(String str, Continuation<? super UniversalRequestDataSource$remove$2> continuation) {
        super(2, continuation);
        this.$key = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        UniversalRequestDataSource$remove$2 universalRequestDataSource$remove$2 = new UniversalRequestDataSource$remove$2(this.$key, continuation);
        universalRequestDataSource$remove$2.L$0 = obj;
        return universalRequestDataSource$remove$2;
    }

    public final Object invoke(UniversalRequestStoreOuterClass.UniversalRequestStore universalRequestStore, Continuation<? super UniversalRequestStoreOuterClass.UniversalRequestStore> continuation) {
        return ((UniversalRequestDataSource$remove$2) create(universalRequestStore, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            UniversalRequestStoreOuterClass.UniversalRequestStore.Builder builder = (UniversalRequestStoreOuterClass.UniversalRequestStore.Builder) ((UniversalRequestStoreOuterClass.UniversalRequestStore) this.L$0).toBuilder();
            builder.removeUniversalRequestMap(this.$key);
            GeneratedMessageLite build = builder.build();
            Intrinsics.checkNotNullExpressionValue(build, "dataBuilder.build()");
            return build;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
