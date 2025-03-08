package com.applovin.exoplayer2;

import com.applovin.exoplayer2.l.ac;
import com.applovin.exoplayer2.l.d;
import com.applovin.exoplayer2.l.s;

final class m implements s {
    private final ac aX;
    private final a aY;
    private ar aZ;
    private s ba;
    private boolean bb = true;
    private boolean bc;

    public interface a {
        void b(am amVar);
    }

    public void b(ar arVar) {
        if (arVar == this.aZ) {
            this.ba = null;
            this.aZ = null;
            this.bb = true;
        }
    }

    public m(a aVar, d dVar) {
        this.aY = aVar;
        this.aX = new ac(dVar);
    }

    public void start() {
        this.bc = true;
        this.aX.start();
    }

    public void W() {
        this.bc = false;
        this.aX.W();
    }

    public void d(long j) {
        this.aX.d(j);
    }

    public void a(ar arVar) throws p {
        s sVar;
        s O = arVar.O();
        if (O != null && O != (sVar = this.ba)) {
            if (sVar == null) {
                this.ba = O;
                this.aZ = arVar;
                O.a(this.aX.av());
                return;
            }
            throw p.a((RuntimeException) new IllegalStateException("Multiple renderer media clocks enabled."));
        }
    }

    public long f(boolean z) {
        g(z);
        return au();
    }

    public long au() {
        if (this.bb) {
            return this.aX.au();
        }
        return ((s) com.applovin.exoplayer2.l.a.checkNotNull(this.ba)).au();
    }

    public void a(am amVar) {
        s sVar = this.ba;
        if (sVar != null) {
            sVar.a(amVar);
            amVar = this.ba.av();
        }
        this.aX.a(amVar);
    }

    public am av() {
        s sVar = this.ba;
        if (sVar != null) {
            return sVar.av();
        }
        return this.aX.av();
    }

    private void g(boolean z) {
        if (h(z)) {
            this.bb = true;
            if (this.bc) {
                this.aX.start();
                return;
            }
            return;
        }
        s sVar = (s) com.applovin.exoplayer2.l.a.checkNotNull(this.ba);
        long au = sVar.au();
        if (this.bb) {
            if (au < this.aX.au()) {
                this.aX.W();
                return;
            }
            this.bb = false;
            if (this.bc) {
                this.aX.start();
            }
        }
        this.aX.d(au);
        am av = sVar.av();
        if (!av.equals(this.aX.av())) {
            this.aX.a(av);
            this.aY.b(av);
        }
    }

    private boolean h(boolean z) {
        ar arVar = this.aZ;
        return arVar == null || arVar.cR() || (!this.aZ.isReady() && (z || this.aZ.R()));
    }
}
