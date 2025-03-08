package com.unity3d.ads.core.extensions;

import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Timestamp;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\n\u0010\u0004\u001a\u00020\u0003*\u00020\u0003¨\u0006\u0005"}, d2 = {"fromMillis", "Lcom/google/protobuf/Timestamp;", "millis", "", "duration", "unity-ads_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: TimestampExtensions.kt */
public final class TimestampExtensionsKt {
    public static final Timestamp fromMillis(long j) {
        long j2 = (long) 1000;
        GeneratedMessageLite build = Timestamp.newBuilder().setSeconds(j / j2).setNanos((int) ((j % j2) * ((long) 1000000))).build();
        Intrinsics.checkNotNullExpressionValue(build, "newBuilder().setSeconds(…000000).toInt())).build()");
        return (Timestamp) build;
    }

    public static final long duration(long j) {
        return System.nanoTime() - j;
    }
}
