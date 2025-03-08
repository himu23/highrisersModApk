package com.fyber.inneractive.sdk.player.ui;

import android.view.ViewGroup;
import android.widget.ImageView;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.util.q0;
import com.fyber.inneractive.sdk.util.w0;

public class e implements a {
    public q0 a(UnitDisplayType unitDisplayType, int i, int i2, boolean z, q0 q0Var, int i3, int i4, int i5, int i6) {
        if (unitDisplayType == UnitDisplayType.DEFAULT && z) {
            w0.a(unitDisplayType, q0Var, i, i2, i3, i4);
        }
        q0Var.a = 0;
        q0Var.b = 0;
        return q0Var;
    }

    public q0 a(UnitDisplayType unitDisplayType, int i, int i2, q0 q0Var, int i3, ViewGroup viewGroup, ImageView imageView) {
        q0 q0Var2 = new q0(0, 0);
        if (unitDisplayType == UnitDisplayType.SQUARE) {
            int min = Math.min(q0Var.a, i3);
            if (viewGroup != null) {
                viewGroup.getLayoutParams().width = min;
                viewGroup.getLayoutParams().height = min;
            }
            if (imageView != null) {
                imageView.getLayoutParams().width = min;
                imageView.getLayoutParams().height = min;
            }
            w0.a(unitDisplayType, q0Var2, i, i2, min, min);
        } else {
            w0.a(unitDisplayType, q0Var2, i, i2, q0Var.a, q0Var.b);
            if (imageView != null) {
                imageView.getLayoutParams().width = q0Var2.a;
                imageView.getLayoutParams().height = q0Var2.b;
            }
        }
        return q0Var2;
    }
}
