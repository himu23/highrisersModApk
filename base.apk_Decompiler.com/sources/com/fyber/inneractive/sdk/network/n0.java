package com.fyber.inneractive.sdk.network;

import android.graphics.Bitmap;
import com.fyber.inneractive.sdk.config.global.s;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.i0;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class n0 extends f0<a> {
    public final String r;

    public static class a {
        public Bitmap a = null;
        public String b = null;

        public a(Bitmap bitmap, String str) {
        }
    }

    public n0(w<a> wVar, String str, s sVar) {
        super(wVar, x.a().b(), sVar);
        this.r = str;
    }

    public String a() {
        return this.r;
    }

    public p0 i() {
        return p0.LOW;
    }

    public boolean o() {
        return false;
    }

    public z r() {
        return z.GET;
    }

    public int v() {
        return 0;
    }

    public b0 a(j jVar, Map<String, List<String>> map, int i) throws Exception {
        b0 b0Var = new b0();
        T aVar = new a((Bitmap) null, (String) null);
        try {
            InputStream inputStream = jVar.c;
            if (inputStream != null) {
                Bitmap a2 = i0.a(inputStream, a(map));
                if (a2 != null) {
                    int width = a2.getWidth();
                    int height = a2.getHeight();
                    int i2 = width * height;
                    int[] iArr = new int[i2];
                    a2.getPixels(iArr, 0, width, 0, 0, width, height);
                    int i3 = -1;
                    int i4 = 0;
                    while (true) {
                        if (i4 >= i2) {
                            break;
                        }
                        int i5 = iArr[i4];
                        if (i4 == 0) {
                            i3 = i5;
                        } else if (i5 != i3) {
                            aVar.a = a2;
                            IAlog.a("SimpleImageLoader: Got a valid bitmap %s", this.r);
                            break;
                        }
                        i4++;
                    }
                }
                IAlog.a("SimpleImageLoader: Got an invalid bitmap", new Object[0]);
                aVar.b = "Got an invalid bitmap";
            }
        } catch (Exception e) {
            IAlog.c("SimpleImageLoader: Exception on load image %s %s", e.getMessage(), e.toString());
            aVar.b = e.getMessage();
        } catch (OutOfMemoryError e2) {
            IAlog.c("SimpleImageLoader: OutOfMemoryError on load image %s", e2.getMessage());
            Bitmap bitmap = aVar.a;
            if (bitmap != null) {
                bitmap.recycle();
            }
            aVar.b = e2.getMessage();
        }
        b0Var.a = aVar;
        return b0Var;
    }
}
