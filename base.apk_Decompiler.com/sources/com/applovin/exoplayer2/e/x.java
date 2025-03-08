package com.applovin.exoplayer2.e;

import com.applovin.exoplayer2.k.g;
import com.applovin.exoplayer2.l.y;
import com.applovin.exoplayer2.v;
import java.io.IOException;
import java.util.Arrays;

public interface x {
    int a(g gVar, int i, boolean z) throws IOException;

    int a(g gVar, int i, boolean z, int i2) throws IOException;

    void a(long j, int i, int i2, int i3, a aVar);

    void a(y yVar, int i, int i2);

    void c(y yVar, int i);

    void j(v vVar);

    public static final class a {
        public final int rq;
        public final int rr;
        public final int uU;
        public final byte[] uV;

        public a(int i, byte[] bArr, int i2, int i3) {
            this.uU = i;
            this.uV = bArr;
            this.rq = i2;
            this.rr = i3;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            if (this.uU == aVar.uU && this.rq == aVar.rq && this.rr == aVar.rr && Arrays.equals(this.uV, aVar.uV)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (((((this.uU * 31) + Arrays.hashCode(this.uV)) * 31) + this.rq) * 31) + this.rr;
        }
    }

    /* renamed from: com.applovin.exoplayer2.e.x$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static int $default$a(x _this, g gVar, int i, boolean z) throws IOException {
            return _this.a(gVar, i, z, 0);
        }

        public static void $default$c(x _this, y yVar, int i) {
            _this.a(yVar, i, 0);
        }
    }
}
