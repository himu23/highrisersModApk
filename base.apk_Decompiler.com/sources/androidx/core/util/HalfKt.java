package androidx.core.util;

import android.util.Half;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\u0010\u0007\n\u0002\u0010\n\n\u0002\u0010\u000e\n\u0000\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\b\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0003H\b\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0004H\b\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0005H\b¨\u0006\u0006"}, d2 = {"toHalf", "Landroid/util/Half;", "", "", "", "", "core-ktx_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: Half.kt */
public final class HalfKt {
    public static final Half toHalf(short s) {
        Half m = Half.valueOf(s);
        Intrinsics.checkNotNullExpressionValue(m, "valueOf(this)");
        return m;
    }

    public static final Half toHalf(float f) {
        Half m = Half.valueOf(f);
        Intrinsics.checkNotNullExpressionValue(m, "valueOf(this)");
        return m;
    }

    public static final Half toHalf(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Half m = Half.valueOf(str);
        Intrinsics.checkNotNullExpressionValue(m, "valueOf(this)");
        return m;
    }

    public static final Half toHalf(double d) {
        Half m = Half.valueOf((float) d);
        Intrinsics.checkNotNullExpressionValue(m, "valueOf(this)");
        return m;
    }
}
