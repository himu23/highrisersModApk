package com.ironsource.sdk.utils;

import android.text.TextUtils;
import android.util.Log;
import com.ironsource.e6;

public class Logger {
    private static boolean a;

    public static void d(String str, String str2) {
        if (a) {
            Log.d(str, str2);
        }
    }

    public static void d(String str, String str2, Throwable th) {
        if (a) {
            Log.d(str, str2, th);
        }
    }

    public static void e(String str, String str2) {
        if (a) {
            Log.e(str, str2);
        }
    }

    public static void e(String str, String str2, Throwable th) {
        if (a) {
            Log.e(str, str2, th);
        }
    }

    public static void enableLogging(int i) {
        a = e6.d.MODE_0.a() != i;
    }

    public static void i(String str, String str2) {
        if (a) {
            Log.i(str, str2);
        }
    }

    public static void i(String str, String str2, Throwable th) {
        if (a && !TextUtils.isEmpty(str2)) {
            Log.i(str, str2, th);
        }
    }

    public static void v(String str, String str2) {
        if (a) {
            Log.v(str, str2);
        }
    }

    public static void v(String str, String str2, Throwable th) {
        if (a) {
            Log.v(str, str2, th);
        }
    }

    public static void w(String str, String str2) {
        if (a) {
            Log.w(str, str2);
        }
    }

    public static void w(String str, String str2, Throwable th) {
        if (a) {
            Log.w(str, str2, th);
        }
    }
}
