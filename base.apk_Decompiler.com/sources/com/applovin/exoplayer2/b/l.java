package com.applovin.exoplayer2.b;

import com.applovin.exoplayer2.b.f;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public abstract class l implements f {
    protected f.a kO = f.a.jP;
    protected f.a kP = f.a.jP;
    private f.a kQ = f.a.jP;
    private f.a kR = f.a.jP;
    private ByteBuffer kS = jO;
    private ByteBuffer kT = jO;
    private boolean kU;

    /* access modifiers changed from: protected */
    public void ad() {
    }

    /* access modifiers changed from: protected */
    public void ef() {
    }

    /* access modifiers changed from: protected */
    public void eg() {
    }

    public final f.a a(f.a aVar) throws f.b {
        this.kQ = aVar;
        this.kR = b(aVar);
        return isActive() ? this.kR : f.a.jP;
    }

    public boolean isActive() {
        return this.kR != f.a.jP;
    }

    public final void dG() {
        this.kU = true;
        ef();
    }

    public ByteBuffer dH() {
        ByteBuffer byteBuffer = this.kT;
        this.kT = jO;
        return byteBuffer;
    }

    public boolean cR() {
        return this.kU && this.kT == jO;
    }

    public final void dI() {
        this.kT = jO;
        this.kU = false;
        this.kO = this.kQ;
        this.kP = this.kR;
        eg();
    }

    public final void Y() {
        dI();
        this.kS = jO;
        this.kQ = f.a.jP;
        this.kR = f.a.jP;
        this.kO = f.a.jP;
        this.kP = f.a.jP;
        ad();
    }

    /* access modifiers changed from: protected */
    public final ByteBuffer az(int i) {
        if (this.kS.capacity() < i) {
            this.kS = ByteBuffer.allocateDirect(i).order(ByteOrder.nativeOrder());
        } else {
            this.kS.clear();
        }
        ByteBuffer byteBuffer = this.kS;
        this.kT = byteBuffer;
        return byteBuffer;
    }

    /* access modifiers changed from: protected */
    public final boolean ee() {
        return this.kT.hasRemaining();
    }

    /* access modifiers changed from: protected */
    public f.a b(f.a aVar) throws f.b {
        return f.a.jP;
    }
}
