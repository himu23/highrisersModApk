package com.google.protobuf.kotlin;

import com.fyber.inneractive.sdk.external.InneractiveMediationNameConsts;
import com.google.protobuf.ByteString;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0002\u001a\u0015\u0010\u0005\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0002\u001a\n\u0010\u0007\u001a\u00020\u0002*\u00020\b\u001a\n\u0010\u0007\u001a\u00020\u0002*\u00020\t\u001a\n\u0010\n\u001a\u00020\u0002*\u00020\u000b¨\u0006\f"}, d2 = {"get", "", "Lcom/google/protobuf/ByteString;", "index", "", "plus", "other", "toByteString", "Ljava/nio/ByteBuffer;", "", "toByteStringUtf8", "", "protobuf-kotlin-lite"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: ByteStrings.kt */
public final class ByteStringsKt {
    public static final ByteString toByteStringUtf8(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        ByteString copyFromUtf8 = ByteString.copyFromUtf8(str);
        Intrinsics.checkNotNullExpressionValue(copyFromUtf8, "copyFromUtf8(this)");
        return copyFromUtf8;
    }

    public static final ByteString plus(ByteString byteString, ByteString byteString2) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        Intrinsics.checkNotNullParameter(byteString2, InneractiveMediationNameConsts.OTHER);
        ByteString concat = byteString.concat(byteString2);
        Intrinsics.checkNotNullExpressionValue(concat, "concat(other)");
        return concat;
    }

    public static final byte get(ByteString byteString, int i) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        return byteString.byteAt(i);
    }

    public static final ByteString toByteString(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        ByteString copyFrom = ByteString.copyFrom(bArr);
        Intrinsics.checkNotNullExpressionValue(copyFrom, "copyFrom(this)");
        return copyFrom;
    }

    public static final ByteString toByteString(ByteBuffer byteBuffer) {
        Intrinsics.checkNotNullParameter(byteBuffer, "<this>");
        ByteString copyFrom = ByteString.copyFrom(byteBuffer);
        Intrinsics.checkNotNullExpressionValue(copyFrom, "copyFrom(this)");
        return copyFrom;
    }
}
