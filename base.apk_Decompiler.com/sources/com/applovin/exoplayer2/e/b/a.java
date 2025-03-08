package com.applovin.exoplayer2.e.b;

import com.applovin.exoplayer2.e.a;
import com.applovin.exoplayer2.e.i;
import com.applovin.exoplayer2.e.m;
import com.applovin.exoplayer2.e.p;
import java.io.IOException;

final class a extends com.applovin.exoplayer2.e.a {
    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public a(com.applovin.exoplayer2.e.p r17, int r18, long r19, long r21) {
        /*
            r16 = this;
            r0 = r17
            java.util.Objects.requireNonNull(r17)
            com.applovin.exoplayer2.e.b.a$$ExternalSyntheticLambda0 r1 = new com.applovin.exoplayer2.e.b.a$$ExternalSyntheticLambda0
            r1.<init>(r0)
            com.applovin.exoplayer2.e.b.a$a r2 = new com.applovin.exoplayer2.e.b.a$a
            r3 = 0
            r4 = r18
            r2.<init>(r0, r4)
            long r3 = r17.dd()
            r5 = 0
            long r7 = r0.uI
            long r13 = r17.ii()
            r9 = 6
            int r0 = r0.uD
            int r15 = java.lang.Math.max(r9, r0)
            r0 = r16
            r9 = r19
            r11 = r21
            r0.<init>(r1, r2, r3, r5, r7, r9, r11, r13, r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.e.b.a.<init>(com.applovin.exoplayer2.e.p, int, long, long):void");
    }

    /* renamed from: com.applovin.exoplayer2.e.b.a$a  reason: collision with other inner class name */
    private static final class C0039a implements a.f {
        private final p uz;
        private final int vK;
        private final m.a vL;

        public /* synthetic */ void ib() {
            a.f.CC.$default$ib(this);
        }

        private C0039a(p pVar, int i) {
            this.uz = pVar;
            this.vK = i;
            this.vL = new m.a();
        }

        public a.e b(i iVar, long j) throws IOException {
            long ie = iVar.ie();
            long i = i(iVar);
            long id = iVar.id();
            iVar.bI(Math.max(6, this.uz.uD));
            long i2 = i(iVar);
            long id2 = iVar.id();
            if (i <= j && i2 > j) {
                return a.e.aj(id);
            }
            if (i2 <= j) {
                return a.e.n(i2, id2);
            }
            return a.e.m(i, ie);
        }

        private long i(i iVar) throws IOException {
            while (iVar.id() < iVar.m1771if() - 6 && !m.a(iVar, this.uz, this.vK, this.vL)) {
                iVar.bI(1);
            }
            if (iVar.id() < iVar.m1771if() - 6) {
                return this.vL.uy;
            }
            iVar.bI((int) (iVar.m1771if() - iVar.id()));
            return this.uz.uI;
        }
    }
}
