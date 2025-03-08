package com.applovin.exoplayer2.k;

import com.applovin.exoplayer2.l.a;
import java.io.IOException;
import java.io.InputStream;
import kotlin.UByte;

public final class k extends InputStream {
    private final i LR;
    private boolean Zk = false;
    private final byte[] Zu;
    private boolean Zv = false;
    private long Zw;
    private final l tw;

    public k(i iVar, l lVar) {
        this.LR = iVar;
        this.tw = lVar;
        this.Zu = new byte[1];
    }

    public int read() throws IOException {
        if (read(this.Zu) == -1) {
            return -1;
        }
        return this.Zu[0] & UByte.MAX_VALUE;
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        a.checkState(!this.Zv);
        og();
        int read = this.LR.read(bArr, i, i2);
        if (read == -1) {
            return -1;
        }
        this.Zw += (long) read;
        return read;
    }

    public void close() throws IOException {
        if (!this.Zv) {
            this.LR.close();
            this.Zv = true;
        }
    }

    private void og() throws IOException {
        if (!this.Zk) {
            this.LR.a(this.tw);
            this.Zk = true;
        }
    }
}
