package com.applovin.exoplayer2.i.b;

import com.applovin.exoplayer2.i.d;
import com.applovin.exoplayer2.i.f;
import com.applovin.exoplayer2.l.y;
import java.util.List;

public final class a extends d {
    private final b Ql;

    public a(List<byte[]> list) {
        super("DvbDecoder");
        y yVar = new y(list.get(0));
        this.Ql = new b(yVar.pp(), yVar.pp());
    }

    /* access modifiers changed from: protected */
    public f c(byte[] bArr, int i, boolean z) {
        if (z) {
            this.Ql.Y();
        }
        return new c(this.Ql.h(bArr, i));
    }
}
