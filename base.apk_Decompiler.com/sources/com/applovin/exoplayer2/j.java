package com.applovin.exoplayer2;

@Deprecated
public class j implements i {
    private final long ao = -9223372036854775807L;
    private final long ap = -9223372036854775807L;
    private final boolean aq = false;

    public boolean aj() {
        return !this.aq || this.ao > 0;
    }

    public boolean ak() {
        return !this.aq || this.ap > 0;
    }

    public boolean a(an anVar) {
        anVar.aD();
        return true;
    }

    public boolean a(an anVar, boolean z) {
        anVar.k(z);
        return true;
    }

    public boolean a(an anVar, int i, long j) {
        anVar.a(i, j);
        return true;
    }

    public boolean b(an anVar) {
        anVar.B();
        return true;
    }

    public boolean c(an anVar) {
        anVar.E();
        return true;
    }

    public boolean d(an anVar) {
        if (!this.aq) {
            anVar.x();
            return true;
        } else if (!aj() || !anVar.J()) {
            return true;
        } else {
            a(anVar, -this.ao);
            return true;
        }
    }

    public boolean e(an anVar) {
        if (!this.aq) {
            anVar.y();
            return true;
        } else if (!ak() || !anVar.J()) {
            return true;
        } else {
            a(anVar, this.ap);
            return true;
        }
    }

    public boolean a(an anVar, int i) {
        anVar.u(i);
        return true;
    }

    public boolean b(an anVar, boolean z) {
        anVar.l(z);
        return true;
    }

    private static void a(an anVar, long j) {
        long aN = anVar.aN() + j;
        long aM = anVar.aM();
        if (aM != -9223372036854775807L) {
            aN = Math.min(aN, aM);
        }
        anVar.b(Math.max(aN, 0));
    }
}
