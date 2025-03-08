package com.applovin.exoplayer2.e;

import com.applovin.exoplayer2.e.x;
import com.applovin.exoplayer2.l.q;
import com.applovin.exoplayer2.l.y;

public final class b {
    public static void a(long j, y yVar, x[] xVarArr) {
        while (true) {
            boolean z = true;
            if (yVar.pj() > 1) {
                int a = a(yVar);
                int a2 = a(yVar);
                int il = yVar.il() + a2;
                if (a2 == -1 || a2 > yVar.pj()) {
                    q.h("CeaUtil", "Skipping remainder of malformed SEI NAL unit.");
                    il = yVar.pk();
                } else if (a == 4 && a2 >= 8) {
                    int po = yVar.po();
                    int pp = yVar.pp();
                    int px = pp == 49 ? yVar.px() : 0;
                    int po2 = yVar.po();
                    if (pp == 47) {
                        yVar.fz(1);
                    }
                    boolean z2 = po == 181 && (pp == 49 || pp == 47) && po2 == 3;
                    if (pp == 49) {
                        if (px != 1195456820) {
                            z = false;
                        }
                        z2 &= z;
                    }
                    if (z2) {
                        b(j, yVar, xVarArr);
                    }
                }
                yVar.fx(il);
            } else {
                return;
            }
        }
    }

    public static void b(long j, y yVar, x[] xVarArr) {
        int po = yVar.po();
        if ((po & 64) != 0) {
            yVar.fz(1);
            int i = (po & 31) * 3;
            int il = yVar.il();
            for (x xVar : xVarArr) {
                yVar.fx(il);
                xVar.c(yVar, i);
                if (j != -9223372036854775807L) {
                    xVar.a(j, 1, i, 0, (x.a) null);
                }
            }
        }
    }

    private static int a(y yVar) {
        int i = 0;
        while (yVar.pj() != 0) {
            int po = yVar.po();
            i += po;
            if (po != 255) {
                return i;
            }
        }
        return -1;
    }
}
