package com.applovin.exoplayer2.e;

import com.applovin.exoplayer2.e.x;
import com.applovin.exoplayer2.l.y;
import com.applovin.exoplayer2.v;
import java.io.EOFException;
import java.io.IOException;

public final class g implements x {
    private final byte[] uv = new byte[4096];

    public /* synthetic */ int a(com.applovin.exoplayer2.k.g gVar, int i, boolean z) {
        return x.CC.$default$a(this, gVar, i, z);
    }

    public void a(long j, int i, int i2, int i3, x.a aVar) {
    }

    public /* synthetic */ void c(y yVar, int i) {
        x.CC.$default$c(this, yVar, i);
    }

    public void j(v vVar) {
    }

    public int a(com.applovin.exoplayer2.k.g gVar, int i, boolean z, int i2) throws IOException {
        int read = gVar.read(this.uv, 0, Math.min(this.uv.length, i));
        if (read != -1) {
            return read;
        }
        if (z) {
            return -1;
        }
        throw new EOFException();
    }

    public void a(y yVar, int i, int i2) {
        yVar.fz(i);
    }
}
