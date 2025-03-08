package com.applovin.exoplayer2.b;

import com.applovin.exoplayer2.b.f;
import com.applovin.exoplayer2.l.ai;
import java.nio.ByteBuffer;

final class x extends l {
    private int ns;
    private int nt;
    private boolean nu;
    private int nv;
    private byte[] nw = ai.ada;
    private int nx;
    private long ny;

    public void eQ() {
        this.ny = 0;
    }

    public long eR() {
        return this.ny;
    }

    public void o(int i, int i2) {
        this.ns = i;
        this.nt = i2;
    }

    public f.a b(f.a aVar) throws f.b {
        if (aVar.jQ == 2) {
            this.nu = true;
            return (this.ns == 0 && this.nt == 0) ? f.a.jP : aVar;
        }
        throw new f.b(aVar);
    }

    public void d(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int i = limit - position;
        if (i != 0) {
            int min = Math.min(i, this.nv);
            this.ny += (long) (min / this.kO.jR);
            this.nv -= min;
            byteBuffer.position(position + min);
            if (this.nv <= 0) {
                int i2 = i - min;
                int length = (this.nx + i2) - this.nw.length;
                ByteBuffer az = az(length);
                int k = ai.k(length, 0, this.nx);
                az.put(this.nw, 0, k);
                int k2 = ai.k(length - k, 0, i2);
                byteBuffer.limit(byteBuffer.position() + k2);
                az.put(byteBuffer);
                byteBuffer.limit(limit);
                int i3 = i2 - k2;
                int i4 = this.nx - k;
                this.nx = i4;
                byte[] bArr = this.nw;
                System.arraycopy(bArr, k, bArr, 0, i4);
                byteBuffer.get(this.nw, this.nx, i3);
                this.nx += i3;
                az.flip();
            }
        }
    }

    public ByteBuffer dH() {
        int i;
        if (super.cR() && (i = this.nx) > 0) {
            az(i).put(this.nw, 0, this.nx).flip();
            this.nx = 0;
        }
        return super.dH();
    }

    public boolean cR() {
        return super.cR() && this.nx == 0;
    }

    /* access modifiers changed from: protected */
    public void ef() {
        if (this.nu) {
            int i = this.nx;
            if (i > 0) {
                this.ny += (long) (i / this.kO.jR);
            }
            this.nx = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void eg() {
        if (this.nu) {
            this.nu = false;
            this.nw = new byte[(this.nt * this.kO.jR)];
            this.nv = this.ns * this.kO.jR;
        }
        this.nx = 0;
    }

    /* access modifiers changed from: protected */
    public void ad() {
        this.nw = ai.ada;
    }
}
