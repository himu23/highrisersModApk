package com.applovin.exoplayer2.h;

import android.os.Handler;
import com.applovin.exoplayer2.ab;
import com.applovin.exoplayer2.ba;
import com.applovin.exoplayer2.d.g;
import com.applovin.exoplayer2.k.aa;
import java.io.IOException;

public interface p {

    /* renamed from: com.applovin.exoplayer2.h.p$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static ba $default$lb(p _this) {
            return null;
        }

        public static boolean $default$lc(p _this) {
            return true;
        }
    }

    public interface b {
        void onSourceInfoRefreshed(p pVar, ba baVar);
    }

    n a(a aVar, com.applovin.exoplayer2.k.b bVar, long j);

    void a(Handler handler, q qVar);

    void a(b bVar);

    void a(b bVar, aa aaVar);

    void a(q qVar);

    void b(Handler handler, g gVar);

    void b(b bVar);

    void c(b bVar);

    void f(g gVar);

    void f(n nVar);

    void kS() throws IOException;

    ab kZ();

    ba lb();

    boolean lc();

    public static final class a extends o {
        public a(Object obj) {
            super(obj);
        }

        public a(Object obj, long j, int i) {
            super(obj, j, i);
        }

        public a(Object obj, int i, int i2, long j) {
            super(obj, i, i2, j);
        }

        public a(o oVar) {
            super(oVar);
        }

        /* renamed from: H */
        public a G(Object obj) {
            return new a(super.G(obj));
        }
    }
}
