package com.applovin.exoplayer2.d;

import com.applovin.exoplayer2.c.b;
import com.applovin.exoplayer2.d.g;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

public interface f {
    boolean A(String str);

    int P();

    void a(g.a aVar);

    void b(g.a aVar);

    boolean hs();

    a ht();

    UUID hu();

    b hv();

    Map<String, String> hw();

    /* renamed from: com.applovin.exoplayer2.d.f$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static boolean $default$hs(f _this) {
            return false;
        }

        public static void a(f fVar, f fVar2) {
            if (fVar != fVar2) {
                if (fVar2 != null) {
                    fVar2.a((g.a) null);
                }
                if (fVar != null) {
                    fVar.b((g.a) null);
                }
            }
        }
    }

    public static class a extends IOException {
        public final int errorCode;

        public a(Throwable th, int i) {
            super(th);
            this.errorCode = i;
        }
    }
}
