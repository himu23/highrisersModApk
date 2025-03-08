package com.unity3d.ads.core.data.model;

import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/unity3d/ads/core/data/model/CacheDirectory;", "", "access", "Ljava/io/File;", "type", "Lcom/unity3d/ads/core/data/model/CacheDirectoryType;", "(Ljava/io/File;Lcom/unity3d/ads/core/data/model/CacheDirectoryType;)V", "getAccess", "()Ljava/io/File;", "getType", "()Lcom/unity3d/ads/core/data/model/CacheDirectoryType;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: CacheDirectory.kt */
public final class CacheDirectory {
    private final File access;
    private final CacheDirectoryType type;

    public final File getAccess() {
        return this.access;
    }

    public final CacheDirectoryType getType() {
        return this.type;
    }

    public CacheDirectory(File file, CacheDirectoryType cacheDirectoryType) {
        Intrinsics.checkNotNullParameter(file, "access");
        Intrinsics.checkNotNullParameter(cacheDirectoryType, "type");
        this.access = file;
        this.type = cacheDirectoryType;
    }
}
