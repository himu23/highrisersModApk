package com.fyber.inneractive.sdk.util;

import android.content.Context;
import android.graphics.Bitmap;

public class s0 {

    public interface a {
        void a(Bitmap bitmap);
    }

    public static Bitmap a(Context context, Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        g gVar = new g();
        gVar.c = 20;
        gVar.d = 1;
        gVar.a = bitmap.getWidth();
        gVar.b = bitmap.getHeight();
        return f.a(context, bitmap, gVar);
    }
}
