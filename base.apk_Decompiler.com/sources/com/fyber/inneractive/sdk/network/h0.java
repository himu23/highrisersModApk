package com.fyber.inneractive.sdk.network;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Base64;
import com.fyber.inneractive.sdk.cache.a;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.i0;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.Map;

public class h0 extends g0<Bitmap> {
    public h0(w<Bitmap> wVar, Context context, a<Bitmap> aVar) {
        super(wVar, context, aVar);
    }

    public b0 a(j jVar, Map<String, List<String>> map, int i) throws Exception {
        b0 b0Var = new b0();
        try {
            T a = i0.a(jVar.c, a(map));
            if (a != null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                a.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                String encodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
                b0Var.a = a;
                b0Var.b = encodeToString;
            }
            return b0Var;
        } catch (Exception e) {
            IAlog.a("failed parse cacheable network request", e, new Object[0]);
            throw new a0(e);
        }
    }
}
