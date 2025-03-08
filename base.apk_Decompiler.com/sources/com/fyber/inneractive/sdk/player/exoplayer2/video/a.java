package com.fyber.inneractive.sdk.player.exoplayer2.video;

import com.fyber.inneractive.sdk.player.exoplayer2.l;
import com.fyber.inneractive.sdk.player.exoplayer2.util.c;
import com.fyber.inneractive.sdk.player.exoplayer2.util.i;
import com.fyber.inneractive.sdk.player.exoplayer2.util.k;
import java.util.ArrayList;
import java.util.List;

public final class a {
    public final List<byte[]> a;
    public final int b;
    public final int c;
    public final int d;
    public final float e;

    public a(List<byte[]> list, int i, int i2, int i3, float f) {
        this.a = list;
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = f;
    }

    public static byte[] a(k kVar) {
        int q = kVar.q();
        int i = kVar.b;
        kVar.f(q);
        byte[] bArr = kVar.a;
        byte[] bArr2 = c.a;
        byte[] bArr3 = new byte[(bArr2.length + q)];
        System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
        System.arraycopy(bArr, i, bArr3, bArr2.length, q);
        return bArr3;
    }

    public static a b(k kVar) throws l {
        float f;
        int i;
        int i2;
        try {
            kVar.f(4);
            int l = (kVar.l() & 3) + 1;
            if (l != 3) {
                ArrayList arrayList = new ArrayList();
                int l2 = kVar.l() & 31;
                for (int i3 = 0; i3 < l2; i3++) {
                    arrayList.add(a(kVar));
                }
                int l3 = kVar.l();
                for (int i4 = 0; i4 < l3; i4++) {
                    arrayList.add(a(kVar));
                }
                if (l2 > 0) {
                    i.b b2 = i.b((byte[]) arrayList.get(0), l, ((byte[]) arrayList.get(0)).length);
                    int i5 = b2.b;
                    int i6 = b2.c;
                    f = b2.d;
                    i2 = i5;
                    i = i6;
                } else {
                    i2 = -1;
                    i = -1;
                    f = 1.0f;
                }
                return new a(arrayList, l, i2, i, f);
            }
            throw new IllegalStateException();
        } catch (ArrayIndexOutOfBoundsException e2) {
            throw new l("Error parsing AVC config", e2);
        }
    }
}
