package com.applovin.exoplayer2.h;

import android.net.Uri;
import com.applovin.exoplayer2.e.j;
import com.applovin.exoplayer2.e.u;
import com.applovin.exoplayer2.k.g;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface s {

    public interface a {
        s createProgressiveMediaExtractor();
    }

    int a(u uVar) throws IOException;

    void a(g gVar, Uri uri, Map<String, List<String>> map, long j, long j2, j jVar) throws IOException;

    void kK();

    long kL();

    void o(long j, long j2);

    void release();
}
