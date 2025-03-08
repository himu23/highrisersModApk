package com.applovin.exoplayer2.i.i;

import com.applovin.exoplayer2.i.a;
import com.applovin.exoplayer2.i.d;
import com.applovin.exoplayer2.i.f;
import com.applovin.exoplayer2.i.h;
import com.applovin.exoplayer2.l.ai;
import com.applovin.exoplayer2.l.y;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class a extends d {
    private final y Cp = new y();

    public a() {
        super("Mp4WebvttDecoder");
    }

    /* access modifiers changed from: protected */
    public f c(byte[] bArr, int i, boolean z) throws h {
        this.Cp.l(bArr, i);
        ArrayList arrayList = new ArrayList();
        while (this.Cp.pj() > 0) {
            if (this.Cp.pj() >= 8) {
                int px = this.Cp.px();
                if (this.Cp.px() == 1987343459) {
                    arrayList.add(D(this.Cp, px - 8));
                } else {
                    this.Cp.fz(px - 8);
                }
            } else {
                throw new h("Incomplete Mp4Webvtt Top Level box header found.");
            }
        }
        return new b(arrayList);
    }

    private static com.applovin.exoplayer2.i.a D(y yVar, int i) throws h {
        CharSequence charSequence = null;
        a.C0050a aVar = null;
        while (i > 0) {
            if (i >= 8) {
                int px = yVar.px();
                int px2 = yVar.px();
                int i2 = px - 8;
                String t = ai.t(yVar.hO(), yVar.il(), i2);
                yVar.fz(i2);
                i = (i - 8) - i2;
                if (px2 == 1937011815) {
                    aVar = f.aA(t);
                } else if (px2 == 1885436268) {
                    charSequence = f.a((String) null, t.trim(), (List<d>) Collections.emptyList());
                }
            } else {
                throw new h("Incomplete vtt cue box header found.");
            }
        }
        if (charSequence == null) {
            charSequence = "";
        }
        if (aVar != null) {
            return aVar.m(charSequence).lU();
        }
        return f.n(charSequence);
    }
}
