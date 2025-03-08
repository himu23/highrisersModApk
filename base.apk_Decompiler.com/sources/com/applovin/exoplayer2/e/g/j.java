package com.applovin.exoplayer2.e.g;

import android.support.v4.media.session.PlaybackStateCompat;
import com.applovin.exoplayer2.e.i;
import com.applovin.exoplayer2.l.y;
import java.io.IOException;

final class j {
    private static final int[] AO = {1769172845, 1769172786, 1769172787, 1769172788, 1769172789, 1769172790, 1769172793, 1635148593, 1752589105, 1751479857, 1635135537, 1836069937, 1836069938, 862401121, 862401122, 862417462, 862417718, 862414134, 862414646, 1295275552, 1295270176, 1714714144, 1801741417, 1295275600, 1903435808, 1297305174, 1684175153, 1769172332, 1885955686};

    public static boolean L(i iVar) throws IOException {
        return a(iVar, true, false);
    }

    public static boolean e(i iVar, boolean z) throws IOException {
        return a(iVar, false, z);
    }

    private static boolean a(i iVar, boolean z, boolean z2) throws IOException {
        boolean z3;
        boolean z4;
        int i;
        i iVar2 = iVar;
        long j = iVar.m1771if();
        long j2 = PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
        long j3 = -1;
        int i2 = (j > -1 ? 1 : (j == -1 ? 0 : -1));
        if (i2 != 0 && j <= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM) {
            j2 = j;
        }
        int i3 = (int) j2;
        y yVar = new y(64);
        boolean z5 = false;
        int i4 = 0;
        boolean z6 = false;
        while (true) {
            if (i4 >= i3) {
                break;
            }
            yVar.U(8);
            if (!iVar2.b(yVar.hO(), z5 ? 1 : 0, 8, true)) {
                break;
            }
            long pv = yVar.pv();
            int px = yVar.px();
            if (pv == 1) {
                iVar2.c(yVar.hO(), 8, 8);
                yVar.fA(16);
                pv = yVar.pz();
                i = 16;
            } else {
                if (pv == 0) {
                    long j4 = iVar.m1771if();
                    if (j4 != j3) {
                        pv = (j4 - iVar.id()) + ((long) 8);
                    }
                }
                i = 8;
            }
            long j5 = (long) i;
            if (pv < j5) {
                return z5;
            }
            i4 += i;
            if (px == 1836019574) {
                i3 += (int) pv;
                if (i2 != 0 && ((long) i3) > j) {
                    i3 = (int) j;
                }
                j3 = -1;
            } else if (px == 1836019558 || px == 1836475768) {
                z3 = true;
                z4 = true;
            } else {
                int i5 = i2;
                int i6 = i4;
                if ((((long) i4) + pv) - j5 >= ((long) i3)) {
                    break;
                }
                int i7 = (int) (pv - j5);
                i4 = i6 + i7;
                if (px != 1718909296) {
                    boolean z7 = z2;
                    if (i7 != 0) {
                        iVar2.bI(i7);
                    }
                } else if (i7 < 8) {
                    return false;
                } else {
                    yVar.U(i7);
                    iVar2.c(yVar.hO(), 0, i7);
                    int i8 = i7 / 4;
                    int i9 = 0;
                    while (true) {
                        if (i9 >= i8) {
                            boolean z8 = z2;
                            break;
                        }
                        if (i9 == 1) {
                            yVar.fz(4);
                            boolean z9 = z2;
                        } else if (k(yVar.px(), z2)) {
                            z6 = true;
                            break;
                        }
                        i9++;
                    }
                    if (!z6) {
                        return false;
                    }
                }
                i2 = i5;
                j3 = -1;
                z5 = false;
            }
        }
        z3 = true;
        z4 = false;
        if (!z6 || z != z4) {
            return false;
        }
        return z3;
    }

    private static boolean k(int i, boolean z) {
        if ((i >>> 8) == 3368816) {
            return true;
        }
        if (i == 1751476579 && z) {
            return true;
        }
        for (int i2 : AO) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }
}
