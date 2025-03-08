package com.applovin.exoplayer2.d;

import android.net.Uri;
import com.applovin.exoplayer2.k.l;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public final class s extends IOException {
    public final l tw;
    public final Uri tx;
    public final Map<String, List<String>> ty;
    public final long tz;

    public s(l lVar, Uri uri, Map<String, List<String>> map, long j, Throwable th) {
        super(th);
        this.tw = lVar;
        this.tx = uri;
        this.ty = map;
        this.tz = j;
    }
}
