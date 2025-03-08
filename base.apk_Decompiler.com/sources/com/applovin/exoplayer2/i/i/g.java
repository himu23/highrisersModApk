package com.applovin.exoplayer2.i.i;

import android.text.TextUtils;
import com.applovin.exoplayer2.ai;
import com.applovin.exoplayer2.i.d;
import com.applovin.exoplayer2.i.f;
import com.applovin.exoplayer2.i.h;
import com.applovin.exoplayer2.l.y;
import java.util.ArrayList;
import java.util.List;

public final class g extends d {
    private final y TJ = new y();
    private final c TK = new c();

    public g() {
        super("WebvttDecoder");
    }

    /* access modifiers changed from: protected */
    public f c(byte[] bArr, int i, boolean z) throws h {
        e a;
        this.TJ.l(bArr, i);
        ArrayList arrayList = new ArrayList();
        try {
            h.ap(this.TJ);
            do {
            } while (!TextUtils.isEmpty(this.TJ.pJ()));
            ArrayList arrayList2 = new ArrayList();
            while (true) {
                int an = an(this.TJ);
                if (an == 0) {
                    return new i(arrayList2);
                }
                if (an == 1) {
                    ao(this.TJ);
                } else if (an == 2) {
                    if (arrayList2.isEmpty()) {
                        this.TJ.pJ();
                        arrayList.addAll(this.TK.ah(this.TJ));
                    } else {
                        throw new h("A style block was found after the first cue.");
                    }
                } else if (an == 3 && (a = f.a(this.TJ, (List<d>) arrayList)) != null) {
                    arrayList2.add(a);
                }
            }
        } catch (ai e) {
            throw new h((Throwable) e);
        }
    }

    private static int an(y yVar) {
        int i = -1;
        int i2 = 0;
        while (i == -1) {
            i2 = yVar.il();
            String pJ = yVar.pJ();
            if (pJ == null) {
                i = 0;
            } else if ("STYLE".equals(pJ)) {
                i = 2;
            } else {
                i = pJ.startsWith("NOTE") ? 1 : 3;
            }
        }
        yVar.fx(i2);
        return i;
    }

    private static void ao(y yVar) {
        do {
        } while (!TextUtils.isEmpty(yVar.pJ()));
    }
}
