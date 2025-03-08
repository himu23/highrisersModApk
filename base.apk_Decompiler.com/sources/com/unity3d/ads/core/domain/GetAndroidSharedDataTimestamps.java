package com.unity3d.ads.core.domain;

import android.os.SystemClock;
import com.unity3d.ads.core.extensions.TimestampExtensionsKt;
import com.unity3d.services.core.properties.SdkProperties;
import gateway.v1.TimestampsKt;
import gateway.v1.TimestampsOuterClass;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0011\u0010\u0003\u001a\u00020\u0004HBø\u0001\u0000¢\u0006\u0002\u0010\u0005\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006"}, d2 = {"Lcom/unity3d/ads/core/domain/GetAndroidSharedDataTimestamps;", "Lcom/unity3d/ads/core/domain/GetSharedDataTimestamps;", "()V", "invoke", "Lgateway/v1/TimestampsOuterClass$Timestamps;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: GetAndroidSharedDataTimestamps.kt */
public final class GetAndroidSharedDataTimestamps implements GetSharedDataTimestamps {
    public Object invoke(Continuation<? super TimestampsOuterClass.Timestamps> continuation) {
        TimestampsKt.Dsl.Companion companion = TimestampsKt.Dsl.Companion;
        TimestampsOuterClass.Timestamps.Builder newBuilder = TimestampsOuterClass.Timestamps.newBuilder();
        Intrinsics.checkNotNullExpressionValue(newBuilder, "newBuilder()");
        TimestampsKt.Dsl _create = companion._create(newBuilder);
        _create.setTimestamp(TimestampExtensionsKt.fromMillis(System.currentTimeMillis()));
        _create.setSessionTimestamp(SystemClock.elapsedRealtime() - SdkProperties.getInitializationTime());
        return _create._build();
    }
}
