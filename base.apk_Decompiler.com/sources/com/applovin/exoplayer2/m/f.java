package com.applovin.exoplayer2.m;

import com.applovin.exoplayer2.ai;
import com.applovin.exoplayer2.l.e;
import com.applovin.exoplayer2.l.v;
import com.applovin.exoplayer2.l.y;
import com.applovin.exoplayer2.l.z;
import java.util.Collections;
import java.util.List;
import kotlinx.coroutines.scheduling.WorkQueueKt;

public final class f {
    public final List<byte[]> dB;
    public final String dw;
    public final int wo;

    public static f av(y yVar) throws ai {
        List list;
        y yVar2 = yVar;
        try {
            yVar2.fz(21);
            int po = yVar.po() & 3;
            int po2 = yVar.po();
            int il = yVar.il();
            int i = 0;
            for (int i2 = 0; i2 < po2; i2++) {
                yVar2.fz(1);
                int pp = yVar.pp();
                for (int i3 = 0; i3 < pp; i3++) {
                    int pp2 = yVar.pp();
                    i += pp2 + 4;
                    yVar2.fz(pp2);
                }
            }
            yVar2.fx(il);
            byte[] bArr = new byte[i];
            String str = null;
            int i4 = 0;
            for (int i5 = 0; i5 < po2; i5++) {
                int po3 = yVar.po() & WorkQueueKt.MASK;
                int pp3 = yVar.pp();
                for (int i6 = 0; i6 < pp3; i6++) {
                    int pp4 = yVar.pp();
                    System.arraycopy(v.abK, 0, bArr, i4, v.abK.length);
                    int length = i4 + v.abK.length;
                    System.arraycopy(yVar.hO(), yVar.il(), bArr, length, pp4);
                    if (po3 == 33 && i6 == 0) {
                        str = e.c(new z(bArr, length, length + pp4));
                    }
                    i4 = length + pp4;
                    yVar2.fz(pp4);
                }
            }
            if (i == 0) {
                list = null;
            } else {
                list = Collections.singletonList(bArr);
            }
            return new f(list, po + 1, str);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw ai.c("Error parsing HEVC config", e);
        }
    }

    private f(List<byte[]> list, int i, String str) {
        this.dB = list;
        this.wo = i;
        this.dw = str;
    }
}
