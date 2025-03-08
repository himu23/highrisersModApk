package com.unity3d.ads.core.data.datasource;

import androidx.datastore.core.DataMigration;
import com.google.protobuf.GeneratedMessageLite;
import com.ironsource.m2;
import com.unity3d.ads.core.extensions.ProtobufExtensionsKt;
import com.unity3d.services.core.preferences.AndroidPreferences;
import defpackage.ByteStringStoreOuterClass;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0011\u0010\t\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0002\u0010\u000bJ\u0019\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0002H@ø\u0001\u0000¢\u0006\u0002\u0010\u000eJ\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u0002H@ø\u0001\u0000¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"Lcom/unity3d/ads/core/data/datasource/DefaultByteStringMigration;", "Landroidx/datastore/core/DataMigration;", "LByteStringStoreOuterClass$ByteStringStore;", "name", "", "key", "getPreferenceString", "Lcom/unity3d/ads/core/data/datasource/GetPreferenceString;", "(Ljava/lang/String;Ljava/lang/String;Lcom/unity3d/ads/core/data/datasource/GetPreferenceString;)V", "cleanUp", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "migrate", "currentData", "(LByteStringStoreOuterClass$ByteStringStore;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shouldMigrate", "", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: DefaultByteStringMigration.kt */
public final class DefaultByteStringMigration implements DataMigration<ByteStringStoreOuterClass.ByteStringStore> {
    private final GetPreferenceString getPreferenceString;
    private final String key;
    private final String name;

    public DefaultByteStringMigration(String str, String str2, GetPreferenceString getPreferenceString2) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, m2.h.W);
        Intrinsics.checkNotNullParameter(getPreferenceString2, "getPreferenceString");
        this.name = str;
        this.key = str2;
        this.getPreferenceString = getPreferenceString2;
    }

    public Object cleanUp(Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    public Object shouldMigrate(ByteStringStoreOuterClass.ByteStringStore byteStringStore, Continuation<? super Boolean> continuation) {
        return Boxing.boxBoolean(byteStringStore.getData().isEmpty());
    }

    public Object migrate(ByteStringStoreOuterClass.ByteStringStore byteStringStore, Continuation<? super ByteStringStoreOuterClass.ByteStringStore> continuation) {
        String invoke = this.getPreferenceString.invoke();
        AndroidPreferences.setString(this.name, this.key, invoke);
        GeneratedMessageLite build = ByteStringStoreOuterClass.ByteStringStore.newBuilder().setData(ProtobufExtensionsKt.toISO8859ByteString(invoke)).build();
        Intrinsics.checkNotNullExpressionValue(build, "newBuilder()\n           …g())\n            .build()");
        return build;
    }
}
