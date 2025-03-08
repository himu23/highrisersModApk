package com.fyber.inneractive.sdk.cache;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Base64;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.p;
import java.io.ByteArrayOutputStream;

public class b implements a<Bitmap> {
    public final String a;

    public b(String str) {
        this.a = str;
    }

    public String a() {
        return this.a;
    }

    public void a(Object obj) {
        Bitmap bitmap = (Bitmap) obj;
        if (bitmap != null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            p.a.getSharedPreferences("IAConfigurationPreferences", 0).edit().putString("dt.dynamic.icon.data", Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0)).apply();
        }
    }

    public String b() {
        return "dt.dynamic.icon.last.modified";
    }

    public String c() {
        return String.valueOf(("dt.dynamic.icon_" + this.a).hashCode());
    }

    public boolean d() {
        return true;
    }

    public Object a(String str) throws Exception {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            byte[] decode = Base64.decode(str, 0);
            return BitmapFactory.decodeByteArray(decode, 0, decode.length);
        } catch (Exception e) {
            IAlog.a("IAimageLoaderUtil failed stringToBitMap with %s", e.getMessage());
            return null;
        }
    }
}
