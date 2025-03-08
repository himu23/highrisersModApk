package com.applovin.impl.adview;

import android.content.Context;
import com.applovin.impl.adview.j;

public final class r extends j {
    public r(Context context) {
        super(context);
    }

    public j.a getStyle() {
        return j.a.INVISIBLE;
    }

    public void fZ(int i) {
        setViewScale(((float) i) / 30.0f);
    }
}
