package com.unity3d.ads.core.extensions;

import android.util.Base64;
import com.google.protobuf.ByteString;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0002*\u00020\u0001\u001a\n\u0010\u0004\u001a\u00020\u0001*\u00020\u0005\u001a\n\u0010\u0006\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0007\u001a\u00020\u0002*\u00020\u0001\u001a\n\u0010\b\u001a\u00020\u0005*\u00020\u0001¨\u0006\t"}, d2 = {"fromBase64", "Lcom/google/protobuf/ByteString;", "", "toBase64", "toByteString", "Ljava/util/UUID;", "toISO8859ByteString", "toISO8859String", "toUUID", "unity-ads_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: ProtobufExtensions.kt */
public final class ProtobufExtensionsKt {
    public static final ByteString toByteString(UUID uuid) {
        Intrinsics.checkNotNullParameter(uuid, "<this>");
        ByteString copyFrom = ByteString.copyFrom(ByteBuffer.wrap(new byte[16]).order(ByteOrder.BIG_ENDIAN).putLong(uuid.getMostSignificantBits()).putLong(uuid.getLeastSignificantBits()).array());
        Intrinsics.checkNotNullExpressionValue(copyFrom, "copyFrom(bytes.array())");
        return copyFrom;
    }

    public static final UUID toUUID(ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        ByteBuffer asReadOnlyByteBuffer = byteString.asReadOnlyByteBuffer();
        Intrinsics.checkNotNullExpressionValue(asReadOnlyByteBuffer, "this.asReadOnlyByteBuffer()");
        return new UUID(asReadOnlyByteBuffer.getLong(), asReadOnlyByteBuffer.getLong());
    }

    public static final String toBase64(ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        String encodeToString = Base64.encodeToString(byteString.toByteArray(), 2);
        Intrinsics.checkNotNullExpressionValue(encodeToString, "encodeToString(this.toBy…roid.util.Base64.NO_WRAP)");
        return encodeToString;
    }

    public static final ByteString fromBase64(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        ByteString copyFrom = ByteString.copyFrom(Base64.decode(str, 2));
        Intrinsics.checkNotNullExpressionValue(copyFrom, "copyFrom(android.util.Ba…oid.util.Base64.NO_WRAP))");
        return copyFrom;
    }

    public static final ByteString toISO8859ByteString(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        byte[] bytes = str.getBytes(Charsets.ISO_8859_1);
        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
        ByteString copyFrom = ByteString.copyFrom(bytes);
        Intrinsics.checkNotNullExpressionValue(copyFrom, "copyFrom(this.toByteArray(Charsets.ISO_8859_1))");
        return copyFrom;
    }

    public static final String toISO8859String(ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "<this>");
        String byteString2 = byteString.toString(Charsets.ISO_8859_1);
        Intrinsics.checkNotNullExpressionValue(byteString2, "this.toString(Charsets.ISO_8859_1)");
        return byteString2;
    }
}
