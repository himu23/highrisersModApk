package com.fyber.inneractive.sdk.ui;

import android.view.View;

public class b implements View.OnLayoutChangeListener {
    public final /* synthetic */ FyberAdIdentifier a;

    public b(FyberAdIdentifier fyberAdIdentifier) {
        this.a = fyberAdIdentifier;
    }

    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        FyberAdIdentifier fyberAdIdentifier = this.a;
        fyberAdIdentifier.f = (float) (fyberAdIdentifier.b.getWidth() + this.a.b.getWidth());
        if (FyberAdIdentifier.a(this.a)) {
            this.a.f *= -1.0f;
        }
        FyberAdIdentifier fyberAdIdentifier2 = this.a;
        fyberAdIdentifier2.b.setTranslationX(fyberAdIdentifier2.f);
        FyberAdIdentifier fyberAdIdentifier3 = this.a;
        if (fyberAdIdentifier3.d) {
            fyberAdIdentifier3.a();
        }
    }
}
