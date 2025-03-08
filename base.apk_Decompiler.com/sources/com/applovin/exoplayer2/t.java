package com.applovin.exoplayer2;

import android.os.Build;
import java.util.HashSet;

public final class t {
    @Deprecated
    public static final String dj = ("ExoPlayerLib/2.15.1 (Linux; Android " + Build.VERSION.RELEASE + ") ExoPlayerLib/2.15.1");
    private static final HashSet<String> dk = new HashSet<>();
    private static String dl = "goog.exo.core";

    public static synchronized String bQ() {
        String str;
        synchronized (t.class) {
            str = dl;
        }
        return str;
    }

    public static synchronized void f(String str) {
        synchronized (t.class) {
            if (dk.add(str)) {
                dl += ", " + str;
            }
        }
    }
}
