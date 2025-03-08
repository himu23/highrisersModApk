package com.applovin.exoplayer2;

import com.applovin.exoplayer2.ar;
import com.applovin.exoplayer2.as;
import com.applovin.exoplayer2.c.g;
import com.applovin.exoplayer2.h.x;
import com.applovin.exoplayer2.l.a;
import com.applovin.exoplayer2.l.s;
import java.io.IOException;

public abstract class e implements ar, as {
    private final int V;
    private final w W = new w();
    private at X;
    private int Y;
    private int Z;
    private x aa;
    private v[] ab;
    private long ac;
    private long ad;
    private long ae = Long.MIN_VALUE;
    private boolean af;
    private boolean ag;

    public final int M() {
        return this.V;
    }

    public final as N() {
        return this;
    }

    public s O() {
        return null;
    }

    public final int P() {
        return this.Z;
    }

    public final x Q() {
        return this.aa;
    }

    public final boolean R() {
        return this.ae == Long.MIN_VALUE;
    }

    public final long S() {
        return this.ae;
    }

    public final void T() {
        this.af = true;
    }

    public final boolean U() {
        return this.af;
    }

    public int Z() throws p {
        return 0;
    }

    public /* synthetic */ void a(float f, float f2) {
        ar.CC.$default$a(this, f, f2);
    }

    public void a(int i, Object obj) throws p {
    }

    /* access modifiers changed from: protected */
    public void a(long j, boolean z) throws p {
    }

    /* access modifiers changed from: protected */
    public void a(boolean z, boolean z2) throws p {
    }

    /* access modifiers changed from: protected */
    public void a(v[] vVarArr, long j, long j2) throws p {
    }

    /* access modifiers changed from: protected */
    public void aa() throws p {
    }

    /* access modifiers changed from: protected */
    public void ab() {
    }

    /* access modifiers changed from: protected */
    public void ac() {
    }

    /* access modifiers changed from: protected */
    public void ad() {
    }

    /* access modifiers changed from: protected */
    public final int ah() {
        return this.Y;
    }

    public final void p(int i) {
        this.Y = i;
    }

    public e(int i) {
        this.V = i;
    }

    public final void a(at atVar, v[] vVarArr, x xVar, long j, boolean z, boolean z2, long j2, long j3) throws p {
        long j4 = j;
        boolean z3 = z;
        a.checkState(this.Z == 0);
        this.X = atVar;
        this.Z = 1;
        this.ad = j4;
        a(z3, z2);
        a(vVarArr, xVar, j2, j3);
        a(j4, z3);
    }

    public final void start() throws p {
        boolean z = true;
        if (this.Z != 1) {
            z = false;
        }
        a.checkState(z);
        this.Z = 2;
        aa();
    }

    public final void a(v[] vVarArr, x xVar, long j, long j2) throws p {
        a.checkState(!this.af);
        this.aa = xVar;
        if (this.ae == Long.MIN_VALUE) {
            this.ae = j;
        }
        this.ab = vVarArr;
        this.ac = j2;
        a(vVarArr, j, j2);
    }

    public final void V() throws IOException {
        ((x) a.checkNotNull(this.aa)).kR();
    }

    public final void d(long j) throws p {
        this.af = false;
        this.ad = j;
        this.ae = j;
        a(j, false);
    }

    public final void W() {
        a.checkState(this.Z == 2);
        this.Z = 1;
        ab();
    }

    public final void X() {
        boolean z = true;
        if (this.Z != 1) {
            z = false;
        }
        a.checkState(z);
        this.W.clear();
        this.Z = 0;
        this.aa = null;
        this.ab = null;
        this.af = false;
        ac();
    }

    public final void Y() {
        a.checkState(this.Z == 0);
        this.W.clear();
        ad();
    }

    /* access modifiers changed from: protected */
    public final w ae() {
        this.W.clear();
        return this.W;
    }

    /* access modifiers changed from: protected */
    public final v[] af() {
        return (v[]) a.checkNotNull(this.ab);
    }

    /* access modifiers changed from: protected */
    public final at ag() {
        return (at) a.checkNotNull(this.X);
    }

    /* access modifiers changed from: protected */
    public final p a(Throwable th, v vVar, int i) {
        return a(th, vVar, false, i);
    }

    /* access modifiers changed from: protected */
    public final p a(Throwable th, v vVar, boolean z, int i) {
        int i2;
        if (vVar != null && !this.ag) {
            this.ag = true;
            try {
                int af2 = as.CC.af(b(vVar));
                this.ag = false;
                i2 = af2;
            } catch (p unused) {
                this.ag = false;
            } catch (Throwable th2) {
                this.ag = false;
                throw th2;
            }
            return p.a(th, getName(), ah(), vVar, i2, z, i);
        }
        i2 = 4;
        return p.a(th, getName(), ah(), vVar, i2, z, i);
    }

    /* access modifiers changed from: protected */
    public final int a(w wVar, g gVar, int i) {
        int b = ((x) a.checkNotNull(this.aa)).b(wVar, gVar, i);
        if (b == -4) {
            if (gVar.gY()) {
                this.ae = Long.MIN_VALUE;
                if (this.af) {
                    return -4;
                }
                return -3;
            }
            gVar.rJ += this.ac;
            this.ae = Math.max(this.ae, gVar.rJ);
        } else if (b == -5) {
            v vVar = (v) a.checkNotNull(wVar.dU);
            if (vVar.dD != Long.MAX_VALUE) {
                wVar.dU = vVar.bR().p(vVar.dD + this.ac).bT();
            }
        }
        return b;
    }

    /* access modifiers changed from: protected */
    public int e(long j) {
        return ((x) a.checkNotNull(this.aa)).aS(j - this.ac);
    }

    /* access modifiers changed from: protected */
    public final boolean ai() {
        return R() ? this.af : ((x) a.checkNotNull(this.aa)).isReady();
    }
}
