package com.unity3d.ads.adplayer;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/unity3d/ads/adplayer/AndroidShowOptions;", "Lcom/unity3d/ads/adplayer/ShowOptions;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AndroidShowOptions.kt */
public final class AndroidShowOptions implements ShowOptions {
    private final Context context;

    public static /* synthetic */ AndroidShowOptions copy$default(AndroidShowOptions androidShowOptions, Context context2, int i, Object obj) {
        if ((i & 1) != 0) {
            context2 = androidShowOptions.context;
        }
        return androidShowOptions.copy(context2);
    }

    public final Context component1() {
        return this.context;
    }

    public final AndroidShowOptions copy(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        return new AndroidShowOptions(context2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof AndroidShowOptions) && Intrinsics.areEqual((Object) this.context, (Object) ((AndroidShowOptions) obj).context);
    }

    public final Context getContext() {
        return this.context;
    }

    public int hashCode() {
        return this.context.hashCode();
    }

    public String toString() {
        return "AndroidShowOptions(context=" + this.context + ')';
    }

    public AndroidShowOptions(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
    }
}
