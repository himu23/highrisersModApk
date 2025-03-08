package com.fyber.inneractive.sdk.player.ui;

import android.view.TextureView;
import android.view.View;
import com.fyber.inneractive.sdk.util.u;
import java.lang.ref.WeakReference;

public class f extends TextureView {
    public WeakReference<l> a;

    public f(l lVar) {
        super(lVar.getContext());
        this.a = new WeakReference<>(lVar);
    }

    public void onMeasure(int i, int i2) {
        l lVar = (l) u.a(this.a);
        if (lVar != null) {
            i = View.MeasureSpec.makeMeasureSpec(lVar.D.a, 1073741824);
            i2 = View.MeasureSpec.makeMeasureSpec(lVar.D.b, 1073741824);
        }
        super.onMeasure(i, i2);
    }
}
