package com.unity3d.ads.core.data.datasource;

import com.google.protobuf.ByteString;
import com.unity3d.ads.core.extensions.ProtobufExtensionsKt;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0002J\u0011\u0010\u0004\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0005H\u0002¨\u0006\b"}, d2 = {"Lcom/unity3d/ads/core/data/datasource/GetIdfiData;", "Lcom/unity3d/ads/core/data/datasource/GetByteStringData;", "Lcom/unity3d/ads/core/data/datasource/GetPreferenceString;", "()V", "invoke", "", "Lcom/google/protobuf/ByteString;", "data", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: GetIdfiData.kt */
public final class GetIdfiData implements GetByteStringData, GetPreferenceString {
    public ByteString invoke(String str) {
        Intrinsics.checkNotNullParameter(str, "data");
        UUID fromString = UUID.fromString(str);
        Intrinsics.checkNotNullExpressionValue(fromString, "fromString(data)");
        return ProtobufExtensionsKt.toByteString(fromString);
    }

    public String invoke() {
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
        return uuid;
    }
}
