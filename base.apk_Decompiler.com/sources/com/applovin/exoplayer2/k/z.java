package com.applovin.exoplayer2.k;

import android.net.Uri;
import com.applovin.exoplayer2.l.a;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class z implements i {
    private final i LR;
    private long aaE;
    private Uri aby = Uri.EMPTY;
    private Map<String, List<String>> abz = Collections.emptyMap();

    public long oH() {
        return this.aaE;
    }

    public Uri oI() {
        return this.aby;
    }

    public Map<String, List<String>> oJ() {
        return this.abz;
    }

    public z(i iVar) {
        this.LR = (i) a.checkNotNull(iVar);
    }

    public void c(aa aaVar) {
        a.checkNotNull(aaVar);
        this.LR.c(aaVar);
    }

    public long a(l lVar) throws IOException {
        this.aby = lVar.ef;
        this.abz = Collections.emptyMap();
        long a = this.LR.a(lVar);
        this.aby = (Uri) a.checkNotNull(getUri());
        this.abz = kT();
        return a;
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        int read = this.LR.read(bArr, i, i2);
        if (read != -1) {
            this.aaE += (long) read;
        }
        return read;
    }

    public Uri getUri() {
        return this.LR.getUri();
    }

    public Map<String, List<String>> kT() {
        return this.LR.kT();
    }

    public void close() throws IOException {
        this.LR.close();
    }
}
