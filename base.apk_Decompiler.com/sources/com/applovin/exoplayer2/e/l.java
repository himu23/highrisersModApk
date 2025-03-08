package com.applovin.exoplayer2.e;

import android.net.Uri;
import java.util.List;
import java.util.Map;

public interface l {
    public static final l ux = new l$$ExternalSyntheticLambda0();

    h[] a(Uri uri, Map<String, List<String>> map);

    h[] createExtractors();

    /* renamed from: com.applovin.exoplayer2.e.l$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        static {
            l lVar = l.ux;
        }

        public static /* synthetic */ h[] ih() {
            return new h[0];
        }

        public static h[] $default$a(l _this, Uri uri, Map map) {
            return _this.createExtractors();
        }
    }
}
