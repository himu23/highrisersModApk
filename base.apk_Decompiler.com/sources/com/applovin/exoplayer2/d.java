package com.applovin.exoplayer2;

import com.applovin.exoplayer2.an;
import com.applovin.exoplayer2.ba;

public abstract class d implements an {
    protected final ba.c U = new ba.c();

    protected d() {
    }

    public final boolean n(int i) {
        return aA().X(i);
    }

    public final boolean v() {
        return aB() == 3 && aE() && aC() == 0;
    }

    public final void w() {
        o(aL());
    }

    public final void o(int i) {
        a(i, -9223372036854775807L);
    }

    public final void b(long j) {
        a(aL(), j);
    }

    public final void x() {
        c(-aH());
    }

    public final void y() {
        c(aI());
    }

    public final boolean z() {
        return G() != -1;
    }

    public final void A() {
        int G = G();
        if (G != -1) {
            o(G);
        }
    }

    public final void B() {
        if (!aX().isEmpty() && !aP()) {
            boolean z = z();
            if (!I() || J()) {
                if (!z || aN() > aJ()) {
                    b(0);
                } else {
                    A();
                }
            } else if (z) {
                A();
            }
        }
    }

    public final boolean C() {
        return F() != -1;
    }

    public final void D() {
        int F = F();
        if (F != -1) {
            o(F);
        }
    }

    public final void E() {
        if (!aX().isEmpty() && !aP()) {
            if (C()) {
                D();
            } else if (I() && H()) {
                w();
            }
        }
    }

    public final int F() {
        ba aX = aX();
        if (aX.isEmpty()) {
            return -1;
        }
        return aX.a(aL(), L(), aG());
    }

    public final int G() {
        ba aX = aX();
        if (aX.isEmpty()) {
            return -1;
        }
        return aX.b(aL(), L(), aG());
    }

    public final boolean H() {
        ba aX = aX();
        return !aX.isEmpty() && aX.a(aL(), this.U).iN;
    }

    public final boolean I() {
        ba aX = aX();
        return !aX.isEmpty() && aX.a(aL(), this.U).dn();
    }

    public final boolean J() {
        ba aX = aX();
        return !aX.isEmpty() && aX.a(aL(), this.U).iM;
    }

    public final long K() {
        ba aX = aX();
        if (aX.isEmpty()) {
            return -9223372036854775807L;
        }
        return aX.a(aL(), this.U).dl();
    }

    /* access modifiers changed from: protected */
    public an.a a(an.a aVar) {
        boolean z = true;
        an.a.C0030a d = new an.a.C0030a().c(aVar).d(3, !aP()).d(4, J() && !aP()).d(5, z() && !aP()).d(6, !aX().isEmpty() && (z() || !I() || J()) && !aP()).d(7, C() && !aP()).d(8, !aX().isEmpty() && (C() || (I() && H())) && !aP()).d(9, !aP()).d(10, J() && !aP());
        if (!J() || aP()) {
            z = false;
        }
        return d.d(11, z).cC();
    }

    private int L() {
        int aF = aF();
        if (aF == 1) {
            return 0;
        }
        return aF;
    }

    private void c(long j) {
        long aN = aN() + j;
        long aM = aM();
        if (aM != -9223372036854775807L) {
            aN = Math.min(aN, aM);
        }
        b(Math.max(aN, 0));
    }
}
