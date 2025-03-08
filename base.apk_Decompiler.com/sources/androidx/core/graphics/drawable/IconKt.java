package androidx.core.graphics.drawable;

import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.net.Uri;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\b\u001a\r\u0010\u0003\u001a\u00020\u0001*\u00020\u0002H\b\u001a\r\u0010\u0003\u001a\u00020\u0001*\u00020\u0004H\b\u001a\r\u0010\u0003\u001a\u00020\u0001*\u00020\u0005H\b¨\u0006\u0006"}, d2 = {"toAdaptiveIcon", "Landroid/graphics/drawable/Icon;", "Landroid/graphics/Bitmap;", "toIcon", "Landroid/net/Uri;", "", "core-ktx_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: Icon.kt */
public final class IconKt {
    public static final Icon toAdaptiveIcon(Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "<this>");
        Icon m$1 = Icon.createWithAdaptiveBitmap(bitmap);
        Intrinsics.checkNotNullExpressionValue(m$1, "createWithAdaptiveBitmap(this)");
        return m$1;
    }

    public static final Icon toIcon(Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "<this>");
        Icon m = Icon.createWithBitmap(bitmap);
        Intrinsics.checkNotNullExpressionValue(m, "createWithBitmap(this)");
        return m;
    }

    public static final Icon toIcon(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "<this>");
        Icon m = Icon.createWithContentUri(uri);
        Intrinsics.checkNotNullExpressionValue(m, "createWithContentUri(this)");
        return m;
    }

    public static final Icon toIcon(byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Icon m = Icon.createWithData(bArr, 0, bArr.length);
        Intrinsics.checkNotNullExpressionValue(m, "createWithData(this, 0, size)");
        return m;
    }
}
