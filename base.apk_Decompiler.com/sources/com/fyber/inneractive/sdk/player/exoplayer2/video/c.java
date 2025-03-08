package com.fyber.inneractive.sdk.player.exoplayer2.video;

import com.fyber.inneractive.sdk.player.exoplayer2.l;
import com.fyber.inneractive.sdk.player.exoplayer2.util.i;
import com.fyber.inneractive.sdk.player.exoplayer2.util.k;
import java.util.Collections;
import java.util.List;

public final class c {
    public final List<byte[]> a;
    public final int b;

    public c(List<byte[]> list, int i) {
        this.a = list;
        this.b = i;
    }

    public static c a(k kVar) throws l {
        List list;
        try {
            kVar.f(21);
            int l = kVar.l() & 3;
            int l2 = kVar.l();
            int i = kVar.b;
            int i2 = 0;
            for (int i3 = 0; i3 < l2; i3++) {
                kVar.f(1);
                int q = kVar.q();
                for (int i4 = 0; i4 < q; i4++) {
                    int q2 = kVar.q();
                    i2 += q2 + 4;
                    kVar.f(q2);
                }
            }
            kVar.e(i);
            byte[] bArr = new byte[i2];
            int i5 = 0;
            for (int i6 = 0; i6 < l2; i6++) {
                kVar.f(1);
                int q3 = kVar.q();
                for (int i7 = 0; i7 < q3; i7++) {
                    int q4 = kVar.q();
                    byte[] bArr2 = i.a;
                    System.arraycopy(bArr2, 0, bArr, i5, bArr2.length);
                    int length = i5 + bArr2.length;
                    System.arraycopy(kVar.a, kVar.b, bArr, length, q4);
                    i5 = length + q4;
                    kVar.f(q4);
                }
            }
            if (i2 == 0) {
                list = null;
            } else {
                list = Collections.singletonList(bArr);
            }
            return new c(list, l + 1);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new l("Error parsing HEVC config", e);
        }
    }
}
