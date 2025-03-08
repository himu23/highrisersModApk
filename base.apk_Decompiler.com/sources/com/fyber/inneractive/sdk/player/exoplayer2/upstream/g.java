package com.fyber.inneractive.sdk.player.exoplayer2.upstream;

import android.net.Uri;
import java.io.IOException;

public interface g {

    public interface a {
        g a();
    }

    int a(byte[] bArr, int i, int i2) throws IOException;

    long a(j jVar) throws IOException;

    Uri a();

    void close() throws IOException;
}
