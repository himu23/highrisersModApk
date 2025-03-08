package com.unity3d.ads.core.configuration;

import com.ironsource.m2;
import com.unity3d.services.core.misc.JsonStorage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u001e\u0010\f\u001a\u0002H\u0001\"\u0006\b\u0001\u0010\u0001\u0018\u00012\u0006\u0010\r\u001a\u0002H\u0001H\b¢\u0006\u0002\u0010\u000eJ\u001e\u0010\u000f\u001a\u0002H\u0001\"\u0006\b\u0001\u0010\u0001\u0018\u00012\u0006\u0010\r\u001a\u0002H\u0001H\b¢\u0006\u0002\u0010\u000eR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0010"}, d2 = {"Lcom/unity3d/ads/core/configuration/MetadataReader;", "T", "", "jsonStorage", "Lcom/unity3d/services/core/misc/JsonStorage;", "key", "", "(Lcom/unity3d/services/core/misc/JsonStorage;Ljava/lang/String;)V", "getJsonStorage", "()Lcom/unity3d/services/core/misc/JsonStorage;", "getKey", "()Ljava/lang/String;", "read", "defaultValue", "(Ljava/lang/Object;)Ljava/lang/Object;", "readAndDelete", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: MetadataReader.kt */
public abstract class MetadataReader<T> {
    private final JsonStorage jsonStorage;
    private final String key;

    public final JsonStorage getJsonStorage() {
        return this.jsonStorage;
    }

    public final String getKey() {
        return this.key;
    }

    public MetadataReader(JsonStorage jsonStorage2, String str) {
        Intrinsics.checkNotNullParameter(jsonStorage2, "jsonStorage");
        Intrinsics.checkNotNullParameter(str, m2.h.W);
        this.jsonStorage = jsonStorage2;
        this.key = str;
    }

    public final /* synthetic */ <T> T read(T t) {
        T t2 = getJsonStorage().get(getKey());
        if (t2 == null) {
            return t;
        }
        Intrinsics.reifiedOperationMarker(3, "T");
        if (!(t2 instanceof Object)) {
            t2 = t;
        }
        return t2 == null ? t : t2;
    }

    public final /* synthetic */ <T> T readAndDelete(T t) {
        T t2 = getJsonStorage().get(getKey());
        if (t2 != null) {
            Intrinsics.checkNotNullExpressionValue(t2, "get(key)");
            Intrinsics.reifiedOperationMarker(3, "T");
            if (!(t2 instanceof Object)) {
                t2 = t;
            }
            if (t2 != null) {
                t = t2;
            }
        }
        Object obj = getJsonStorage().get(getKey());
        if (obj != null) {
            Intrinsics.checkNotNullExpressionValue(obj, "get(key)");
            getJsonStorage().delete(getKey());
        }
        return t;
    }
}
