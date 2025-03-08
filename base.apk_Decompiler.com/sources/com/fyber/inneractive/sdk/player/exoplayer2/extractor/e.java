package com.fyber.inneractive.sdk.player.exoplayer2.extractor;

import com.fyber.inneractive.sdk.player.exoplayer2.i;
import com.fyber.inneractive.sdk.player.exoplayer2.util.k;
import java.io.EOFException;
import java.io.IOException;

public final class e implements n {
    public int a(g gVar, int i, boolean z) throws IOException, InterruptedException {
        int b = ((b) gVar).b(i);
        if (b != -1) {
            return b;
        }
        if (z) {
            return -1;
        }
        throw new EOFException();
    }

    public void a(long j, int i, int i2, int i3, byte[] bArr) {
    }

    public void a(i iVar) {
    }

    public void a(k kVar, int i) {
        kVar.e(kVar.b + i);
    }
}
