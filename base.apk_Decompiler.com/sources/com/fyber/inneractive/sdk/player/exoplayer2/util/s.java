package com.fyber.inneractive.sdk.player.exoplayer2.util;

import android.os.Trace;

public final class s {
    public static void a(String str) {
        if (u.a >= 18) {
            Trace.beginSection(str);
        }
    }

    public static void a() {
        if (u.a >= 18) {
            Trace.endSection();
        }
    }
}
