package com.applovin.exoplayer2.h;

import android.net.Uri;
import com.applovin.exoplayer2.k.aa;
import com.applovin.exoplayer2.k.l;
import com.applovin.exoplayer2.l.y;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import kotlin.UByte;

final class i implements com.applovin.exoplayer2.k.i {
    private final com.applovin.exoplayer2.k.i Lk;
    private final int Ll;
    private final a Lm;
    private final byte[] Ln;
    private int Lo;

    public interface a {
        void ab(y yVar);
    }

    public i(com.applovin.exoplayer2.k.i iVar, int i, a aVar) {
        com.applovin.exoplayer2.l.a.checkArgument(i > 0);
        this.Lk = iVar;
        this.Ll = i;
        this.Lm = aVar;
        this.Ln = new byte[1];
        this.Lo = i;
    }

    public void c(aa aaVar) {
        com.applovin.exoplayer2.l.a.checkNotNull(aaVar);
        this.Lk.c(aaVar);
    }

    public long a(l lVar) {
        throw new UnsupportedOperationException();
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (this.Lo == 0) {
            if (!kU()) {
                return -1;
            }
            this.Lo = this.Ll;
        }
        int read = this.Lk.read(bArr, i, Math.min(this.Lo, i2));
        if (read != -1) {
            this.Lo -= read;
        }
        return read;
    }

    public Uri getUri() {
        return this.Lk.getUri();
    }

    public Map<String, List<String>> kT() {
        return this.Lk.kT();
    }

    public void close() {
        throw new UnsupportedOperationException();
    }

    private boolean kU() throws IOException {
        if (this.Lk.read(this.Ln, 0, 1) == -1) {
            return false;
        }
        int i = (this.Ln[0] & UByte.MAX_VALUE) << 4;
        if (i == 0) {
            return true;
        }
        byte[] bArr = new byte[i];
        int i2 = i;
        int i3 = 0;
        while (i2 > 0) {
            int read = this.Lk.read(bArr, i3, i2);
            if (read == -1) {
                return false;
            }
            i3 += read;
            i2 -= read;
        }
        while (i > 0 && bArr[i - 1] == 0) {
            i--;
        }
        if (i > 0) {
            this.Lm.ab(new y(bArr, i));
        }
        return true;
    }
}
