package com.applovin.exoplayer2.m;

import com.applovin.exoplayer2.ai;
import com.applovin.exoplayer2.l.e;
import com.applovin.exoplayer2.l.v;
import com.applovin.exoplayer2.l.y;
import java.util.ArrayList;
import java.util.List;

public final class a {
    public final float acy;
    public final List<byte[]> dB;
    public final int dE;
    public final String dw;
    public final int height;
    public final int wo;

    public static a as(y yVar) throws ai {
        String str;
        float f;
        int i;
        int i2;
        try {
            yVar.fz(4);
            int po = (yVar.po() & 3) + 1;
            if (po != 3) {
                ArrayList arrayList = new ArrayList();
                int po2 = yVar.po() & 31;
                for (int i3 = 0; i3 < po2; i3++) {
                    arrayList.add(at(yVar));
                }
                int po3 = yVar.po();
                for (int i4 = 0; i4 < po3; i4++) {
                    arrayList.add(at(yVar));
                }
                if (po2 > 0) {
                    v.b n = v.n((byte[]) arrayList.get(0), po, ((byte[]) arrayList.get(0)).length);
                    int i5 = n.dE;
                    int i6 = n.height;
                    float f2 = n.acy;
                    str = e.i(n.acv, n.acw, n.acx);
                    i2 = i5;
                    i = i6;
                    f = f2;
                } else {
                    str = null;
                    i2 = -1;
                    i = -1;
                    f = 1.0f;
                }
                return new a(arrayList, po, i2, i, f, str);
            }
            throw new IllegalStateException();
        } catch (ArrayIndexOutOfBoundsException e) {
            throw ai.c("Error parsing AVC config", e);
        }
    }

    private a(List<byte[]> list, int i, int i2, int i3, float f, String str) {
        this.dB = list;
        this.wo = i;
        this.dE = i2;
        this.height = i3;
        this.acy = f;
        this.dw = str;
    }

    private static byte[] at(y yVar) {
        int pp = yVar.pp();
        int il = yVar.il();
        yVar.fz(pp);
        return e.m(yVar.hO(), il, pp);
    }
}
