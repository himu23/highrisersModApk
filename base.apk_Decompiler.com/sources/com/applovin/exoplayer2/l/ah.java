package com.applovin.exoplayer2.l;

import android.os.Trace;

public final class ah {
    public static void bg(String str) {
        if (ai.acV >= 18) {
            bh(str);
        }
    }

    public static void pV() {
        if (ai.acV >= 18) {
            pW();
        }
    }

    private static void bh(String str) {
        Trace.beginSection(str);
    }

    private static void pW() {
        Trace.endSection();
    }
}
