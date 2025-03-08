package com.applovin.exoplayer2.k;

import android.net.Uri;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public interface i extends g {

    public interface a {
        i of();
    }

    long a(l lVar) throws IOException;

    void c(aa aaVar);

    void close() throws IOException;

    Uri getUri();

    Map<String, List<String>> kT();

    /* renamed from: com.applovin.exoplayer2.k.i$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static Map $default$kT(i _this) {
            return Collections.emptyMap();
        }
    }
}
