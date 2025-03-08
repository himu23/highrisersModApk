package com.unity3d.ads.core.extensions;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u0002¨\u0006\u0003"}, d2 = {"removeViewFromParent", "", "Landroid/view/View;", "unity-ads_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: ViewExtensions.kt */
public final class ViewExtensionsKt {
    public static final void removeViewFromParent(View view) {
        ViewGroup viewGroup = null;
        ViewParent parent = view != null ? view.getParent() : null;
        if (parent instanceof ViewGroup) {
            viewGroup = (ViewGroup) parent;
        }
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
    }
}
