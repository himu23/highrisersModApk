package com.fyber.inneractive.sdk.player.exoplayer2.util;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public final class o extends BufferedOutputStream {
    public boolean a;

    public o(OutputStream outputStream) {
        super(outputStream);
    }

    public void a(OutputStream outputStream) {
        a.b(this.a);
        this.out = outputStream;
        this.count = 0;
        this.a = false;
    }

    public o(OutputStream outputStream, int i) {
        super(outputStream, i);
    }

    public void close() throws IOException {
        this.a = true;
        try {
            flush();
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            this.out.close();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        if (th != null) {
            int i = u.a;
            throw th;
        }
    }
}
