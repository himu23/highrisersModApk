package com.applovin.exoplayer2.i.i;

import com.applovin.exoplayer2.ai;
import com.applovin.exoplayer2.l.y;
import java.util.regex.Pattern;

public final class h {
    private static final Pattern TL = Pattern.compile("^NOTE([ \t].*)?$");

    public static void ap(y yVar) throws ai {
        int il = yVar.il();
        if (!aq(yVar)) {
            yVar.fx(il);
            throw ai.c("Expected WEBVTT. Got " + yVar.pJ(), (Throwable) null);
        }
    }

    public static boolean aq(y yVar) {
        String pJ = yVar.pJ();
        return pJ != null && pJ.startsWith("WEBVTT");
    }

    public static long aG(String str) throws NumberFormatException {
        String[] m = com.applovin.exoplayer2.l.ai.m(str, "\\.");
        long j = 0;
        for (String parseLong : com.applovin.exoplayer2.l.ai.l(m[0], ":")) {
            j = (j * 60) + Long.parseLong(parseLong);
        }
        long j2 = j * 1000;
        if (m.length == 2) {
            j2 += Long.parseLong(m[1]);
        }
        return j2 * 1000;
    }

    public static float aH(String str) throws NumberFormatException {
        if (str.endsWith("%")) {
            return Float.parseFloat(str.substring(0, str.length() - 1)) / 100.0f;
        }
        throw new NumberFormatException("Percentages must end with %");
    }
}
