package com.applovin.impl.sdk.utils;

import android.graphics.Bitmap;
import android.widget.ImageView;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class l$$ExternalSyntheticLambda2 implements Runnable {
    public final /* synthetic */ ImageView f$0;
    public final /* synthetic */ Bitmap f$1;

    public /* synthetic */ l$$ExternalSyntheticLambda2(ImageView imageView, Bitmap bitmap) {
        this.f$0 = imageView;
        this.f$1 = bitmap;
    }

    public final void run() {
        this.f$0.setImageBitmap(this.f$1);
    }
}
