package com.fyber.inneractive.sdk.ui;

import android.graphics.Bitmap;
import com.fyber.inneractive.sdk.network.w;

public class a implements w<Bitmap> {
    public final /* synthetic */ FyberAdIdentifier a;

    public a(FyberAdIdentifier fyberAdIdentifier) {
        this.a = fyberAdIdentifier;
    }

    public void a(Object obj, Exception exc, boolean z) {
        Bitmap bitmap = (Bitmap) obj;
        if (exc == null && bitmap != null) {
            this.a.h = bitmap;
        }
    }
}
