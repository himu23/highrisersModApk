package com.iab.omid.library.ironsrc.utils;

import android.text.TextUtils;
import android.util.Log;
import com.iab.omid.library.ironsrc.a;

public final class d {
    public static void a(String str) {
        if (a.a.booleanValue() && !TextUtils.isEmpty(str)) {
            Log.i("OMIDLIB", str);
        }
    }

    public static void a(String str, Exception exc) {
        if ((a.a.booleanValue() && !TextUtils.isEmpty(str)) || exc != null) {
            Log.e("OMIDLIB", str, exc);
        }
    }
}
