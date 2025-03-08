package com.unity3d.ads.core.data.datasource;

import androidx.datastore.core.DataStore;
import com.google.protobuf.ByteString;
import defpackage.ByteStringStoreOuterClass;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0011\u0010\u0006\u001a\u00020\u0004H@ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\u0019\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH@ø\u0001\u0000¢\u0006\u0002\u0010\fR\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, d2 = {"Lcom/unity3d/ads/core/data/datasource/AndroidByteStringDataSource;", "Lcom/unity3d/ads/core/data/datasource/ByteStringDataSource;", "dataStore", "Landroidx/datastore/core/DataStore;", "LByteStringStoreOuterClass$ByteStringStore;", "(Landroidx/datastore/core/DataStore;)V", "get", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "set", "", "data", "Lcom/google/protobuf/ByteString;", "(Lcom/google/protobuf/ByteString;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidByteStringDataSource.kt */
public final class AndroidByteStringDataSource implements ByteStringDataSource {
    private final DataStore<ByteStringStoreOuterClass.ByteStringStore> dataStore;

    public AndroidByteStringDataSource(DataStore<ByteStringStoreOuterClass.ByteStringStore> dataStore2) {
        Intrinsics.checkNotNullParameter(dataStore2, "dataStore");
        this.dataStore = dataStore2;
    }

    public Object get(Continuation<? super ByteStringStoreOuterClass.ByteStringStore> continuation) {
        return FlowKt.first(FlowKt.m1940catch(this.dataStore.getData(), new AndroidByteStringDataSource$get$2((Continuation<? super AndroidByteStringDataSource$get$2>) null)), continuation);
    }

    public Object set(ByteString byteString, Continuation<? super Unit> continuation) {
        Object updateData = this.dataStore.updateData(new AndroidByteStringDataSource$set$2(byteString, (Continuation<? super AndroidByteStringDataSource$set$2>) null), continuation);
        return updateData == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? updateData : Unit.INSTANCE;
    }
}
