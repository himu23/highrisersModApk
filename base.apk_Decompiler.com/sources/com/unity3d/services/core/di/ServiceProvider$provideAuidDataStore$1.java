package com.unity3d.services.core.di;

import androidx.datastore.core.CorruptionException;
import com.google.protobuf.ByteString;
import com.google.protobuf.GeneratedMessageLite;
import defpackage.ByteStringStoreOuterClass;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "LByteStringStoreOuterClass$ByteStringStore;", "it", "Landroidx/datastore/core/CorruptionException;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ServiceProvider.kt */
final class ServiceProvider$provideAuidDataStore$1 extends Lambda implements Function1<CorruptionException, ByteStringStoreOuterClass.ByteStringStore> {
    public static final ServiceProvider$provideAuidDataStore$1 INSTANCE = new ServiceProvider$provideAuidDataStore$1();

    ServiceProvider$provideAuidDataStore$1() {
        super(1);
    }

    public final ByteStringStoreOuterClass.ByteStringStore invoke(CorruptionException corruptionException) {
        Intrinsics.checkNotNullParameter(corruptionException, "it");
        GeneratedMessageLite build = ByteStringStoreOuterClass.ByteStringStore.newBuilder().setData(ByteString.empty()).build();
        Intrinsics.checkNotNullExpressionValue(build, "newBuilder().setData(ByteString.empty()).build()");
        return (ByteStringStoreOuterClass.ByteStringStore) build;
    }
}
