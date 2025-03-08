package com.fyber.inneractive.sdk.player.exoplayer2.util;

import android.util.Pair;
import com.google.android.gms.games.GamesStatusCodes;

public final class c {
    public static final byte[] a = {0, 0, 0, 1};
    public static final int[] b = {96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, GamesStatusCodes.STATUS_MILESTONE_CLAIMED_PREVIOUSLY, 7350};
    public static final int[] c = {0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1};

    public static Pair<Integer, Integer> a(byte[] bArr) {
        j jVar = new j(bArr, bArr.length);
        int a2 = jVar.a(5);
        if (a2 == 31) {
            a2 = jVar.a(6) + 32;
        }
        int a3 = a(jVar);
        int a4 = jVar.a(4);
        if (a2 == 5 || a2 == 29) {
            a3 = a(jVar);
            int a5 = jVar.a(5);
            if (a5 == 31) {
                a5 = jVar.a(6) + 32;
            }
            if (a5 == 22) {
                a4 = jVar.a(4);
            }
        }
        int i = c[a4];
        a.a(i != -1);
        return Pair.create(Integer.valueOf(a3), Integer.valueOf(i));
    }

    public static int a(j jVar) {
        int a2 = jVar.a(4);
        if (a2 == 15) {
            return jVar.a(24);
        }
        a.a(a2 < 13);
        return b[a2];
    }
}
