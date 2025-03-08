package com.applovin.impl.adview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

public abstract class j extends View {
    protected final Context E;
    protected float ahA = 1.0f;

    public float getSize() {
        return this.ahA * 30.0f;
    }

    public abstract a getStyle();

    public void setViewScale(float f) {
        this.ahA = f;
    }

    public enum a {
        WHITE_ON_BLACK(0),
        WHITE_ON_TRANSPARENT(1),
        INVISIBLE(2),
        TRANSPARENT_SKIP(3);
        
        private final int ahF;

        public int getValue() {
            return this.ahF;
        }

        private a(int i) {
            this.ahF = i;
        }
    }

    protected j(Context context) {
        super(context);
        this.E = context;
    }

    public void fZ(int i) {
        setViewScale(((float) i) / 30.0f);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = (int) getSize();
            layoutParams.height = (int) getSize();
        }
    }

    public static j a(a aVar, Context context) {
        if (aVar.equals(a.INVISIBLE)) {
            return new r(context);
        }
        if (aVar.equals(a.WHITE_ON_TRANSPARENT)) {
            return new s(context);
        }
        if (aVar.equals(a.TRANSPARENT_SKIP)) {
            return new t(context);
        }
        return new z(context);
    }
}
