package com.fyber.inneractive.sdk.player.exoplayer2.upstream;

import com.fyber.inneractive.sdk.player.exoplayer2.util.a;
import java.io.IOException;
import java.io.InputStream;
import kotlin.UByte;

public final class i extends InputStream {
    public final g a;
    public final j b;
    public final byte[] c;
    public boolean d = false;
    public boolean e = false;
    public long f;

    public i(g gVar, j jVar) {
        this.a = gVar;
        this.b = jVar;
        this.c = new byte[1];
    }

    public int read() throws IOException {
        if (read(this.c) == -1) {
            return -1;
        }
        return this.c[0] & UByte.MAX_VALUE;
    }

    public void close() throws IOException {
        if (!this.e) {
            this.a.close();
            this.e = true;
        }
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        a.b(!this.e);
        if (!this.d) {
            this.a.a(this.b);
            this.d = true;
        }
        int a2 = this.a.a(bArr, i, i2);
        if (a2 == -1) {
            return -1;
        }
        this.f += (long) a2;
        return a2;
    }
}
