package com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4;

import android.support.v4.media.session.PlaybackStateCompat;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.b;
import com.fyber.inneractive.sdk.player.exoplayer2.util.k;
import com.fyber.inneractive.sdk.player.exoplayer2.util.u;
import java.io.IOException;

public final class g {
    public static final int[] a = {u.a("isom"), u.a("iso2"), u.a("iso3"), u.a("iso4"), u.a("iso5"), u.a("iso6"), u.a("avc1"), u.a("hvc1"), u.a("hev1"), u.a("mp41"), u.a("mp42"), u.a("3g2a"), u.a("3g2b"), u.a("3gr6"), u.a("3gs6"), u.a("3ge6"), u.a("3gg6"), u.a("M4V "), u.a("M4A "), u.a("f4v "), u.a("kddi"), u.a("M4VP"), u.a("qt  "), u.a("MSNV")};

    public static boolean a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.g gVar, boolean z) throws IOException, InterruptedException {
        boolean z2;
        int i;
        b bVar = (b) gVar;
        long j = bVar.b;
        if (j == -1 || j > PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM) {
            j = 4096;
        }
        int i2 = (int) j;
        k kVar = new k(64);
        int i3 = 0;
        boolean z3 = false;
        while (true) {
            if (i3 >= i2) {
                break;
            }
            kVar.c(8);
            bVar.a(kVar.a, 0, 8, false);
            long m = kVar.m();
            int c = kVar.c();
            if (m == 1) {
                bVar.a(kVar.a, 8, 8, false);
                kVar.d(16);
                m = kVar.p();
                i = 16;
            } else {
                i = 8;
            }
            long j2 = (long) i;
            if (m < j2) {
                return false;
            }
            i3 += i;
            if (c != a.C) {
                if (c == a.L || c == a.N) {
                    z2 = true;
                } else if ((((long) i3) + m) - j2 >= ((long) i2)) {
                    break;
                } else {
                    int i4 = (int) (m - j2);
                    i3 += i4;
                    if (c == a.b) {
                        if (i4 < 8) {
                            return false;
                        }
                        kVar.c(i4);
                        bVar.a(kVar.a, 0, i4, false);
                        int i5 = i4 / 4;
                        int i6 = 0;
                        while (true) {
                            if (i6 >= i5) {
                                break;
                            }
                            if (i6 == 1) {
                                kVar.f(4);
                            } else {
                                int c2 = kVar.c();
                                if ((c2 >>> 8) == u.a("3gp")) {
                                    break;
                                }
                                for (int i7 : a) {
                                    if (i7 == c2) {
                                        break;
                                    }
                                }
                                continue;
                            }
                            i6++;
                        }
                        z3 = true;
                        if (!z3) {
                            return false;
                        }
                    } else if (i4 != 0) {
                        bVar.a(i4, false);
                    }
                }
            }
        }
        z2 = false;
        if (!z3 || z != z2) {
            return false;
        }
        return true;
    }
}
