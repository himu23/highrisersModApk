package com.unity3d.services.core.di;

import androidx.datastore.core.CorruptionException;
import com.google.protobuf.GeneratedMessageLite;
import com.unity3d.ads.core.data.datasource.AndroidStaticDeviceInfoDataSource;
import com.unity3d.ads.core.extensions.ProtobufExtensionsKt;
import com.unity3d.services.ads.gmascar.utils.ScarConstants;
import com.unity3d.services.core.preferences.AndroidPreferences;
import defpackage.ByteStringStoreOuterClass;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "LByteStringStoreOuterClass$ByteStringStore;", "it", "Landroidx/datastore/core/CorruptionException;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: ServiceProvider.kt */
final class ServiceProvider$provideIdfiDataStore$1 extends Lambda implements Function1<CorruptionException, ByteStringStoreOuterClass.ByteStringStore> {
    public static final ServiceProvider$provideIdfiDataStore$1 INSTANCE = new ServiceProvider$provideIdfiDataStore$1();

    ServiceProvider$provideIdfiDataStore$1() {
        super(1);
    }

    public final ByteStringStoreOuterClass.ByteStringStore invoke(CorruptionException corruptionException) {
        Intrinsics.checkNotNullParameter(corruptionException, "it");
        UUID randomUUID = UUID.randomUUID();
        AndroidPreferences.setString("unityads-installinfo", AndroidStaticDeviceInfoDataSource.PREF_KEY_IDFI, randomUUID.toString());
        ByteStringStoreOuterClass.ByteStringStore.Builder newBuilder = ByteStringStoreOuterClass.ByteStringStore.newBuilder();
        Intrinsics.checkNotNullExpressionValue(randomUUID, ScarConstants.IDFI_KEY);
        GeneratedMessageLite build = newBuilder.setData(ProtobufExtensionsKt.toByteString(randomUUID)).build();
        Intrinsics.checkNotNullExpressionValue(build, "newBuilder().setData(idfi.toByteString()).build()");
        return (ByteStringStoreOuterClass.ByteStringStore) build;
    }
}
