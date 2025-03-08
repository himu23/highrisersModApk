package com.applovin.exoplayer2.b;

import com.applovin.exoplayer2.b.f;
import com.applovin.exoplayer2.l.a;
import com.applovin.exoplayer2.l.ai;
import java.nio.ByteBuffer;

public final class u extends l {
    private int Z;
    private boolean iV;
    private int jR;
    private final long mK;
    private final long mL;
    private final short mM;
    private byte[] mN;
    private byte[] mO;
    private int mP;
    private int mQ;
    private boolean mR;
    private long mS;

    public long eM() {
        return this.mS;
    }

    public boolean isActive() {
        return this.iV;
    }

    public void setEnabled(boolean z) {
        this.iV = z;
    }

    public u() {
        this(150000, 20000, 1024);
    }

    public u(long j, long j2, short s) {
        a.checkArgument(j2 <= j);
        this.mK = j;
        this.mL = j2;
        this.mM = s;
        this.mN = ai.ada;
        this.mO = ai.ada;
    }

    public f.a b(f.a aVar) throws f.b {
        if (aVar.jQ == 2) {
            return this.iV ? aVar : f.a.jP;
        }
        throw new f.b(aVar);
    }

    public void d(ByteBuffer byteBuffer) {
        while (byteBuffer.hasRemaining() && !ee()) {
            int i = this.Z;
            if (i == 0) {
                f(byteBuffer);
            } else if (i == 1) {
                g(byteBuffer);
            } else if (i == 2) {
                h(byteBuffer);
            } else {
                throw new IllegalStateException();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void ef() {
        int i = this.mP;
        if (i > 0) {
            c(this.mN, i);
        }
        if (!this.mR) {
            this.mS += (long) (this.mQ / this.jR);
        }
    }

    /* access modifiers changed from: protected */
    public void eg() {
        if (this.iV) {
            this.jR = this.kO.jR;
            int aa = aa(this.mK) * this.jR;
            if (this.mN.length != aa) {
                this.mN = new byte[aa];
            }
            int aa2 = aa(this.mL) * this.jR;
            this.mQ = aa2;
            if (this.mO.length != aa2) {
                this.mO = new byte[aa2];
            }
        }
        this.Z = 0;
        this.mS = 0;
        this.mP = 0;
        this.mR = false;
    }

    /* access modifiers changed from: protected */
    public void ad() {
        this.iV = false;
        this.mQ = 0;
        this.mN = ai.ada;
        this.mO = ai.ada;
    }

    private void f(ByteBuffer byteBuffer) {
        int limit = byteBuffer.limit();
        byteBuffer.limit(Math.min(limit, byteBuffer.position() + this.mN.length));
        int k = k(byteBuffer);
        if (k == byteBuffer.position()) {
            this.Z = 1;
        } else {
            byteBuffer.limit(k);
            i(byteBuffer);
        }
        byteBuffer.limit(limit);
    }

    private void g(ByteBuffer byteBuffer) {
        int limit = byteBuffer.limit();
        int j = j(byteBuffer);
        int position = j - byteBuffer.position();
        byte[] bArr = this.mN;
        int length = bArr.length;
        int i = this.mP;
        int i2 = length - i;
        if (j >= limit || position >= i2) {
            int min = Math.min(position, i2);
            byteBuffer.limit(byteBuffer.position() + min);
            byteBuffer.get(this.mN, this.mP, min);
            int i3 = this.mP + min;
            this.mP = i3;
            byte[] bArr2 = this.mN;
            if (i3 == bArr2.length) {
                if (this.mR) {
                    c(bArr2, this.mQ);
                    this.mS += (long) ((this.mP - (this.mQ * 2)) / this.jR);
                } else {
                    this.mS += (long) ((i3 - this.mQ) / this.jR);
                }
                a(byteBuffer, this.mN, this.mP);
                this.mP = 0;
                this.Z = 2;
            }
            byteBuffer.limit(limit);
            return;
        }
        c(bArr, i);
        this.mP = 0;
        this.Z = 0;
    }

    private void h(ByteBuffer byteBuffer) {
        int limit = byteBuffer.limit();
        int j = j(byteBuffer);
        byteBuffer.limit(j);
        this.mS += (long) (byteBuffer.remaining() / this.jR);
        a(byteBuffer, this.mO, this.mQ);
        if (j < limit) {
            c(this.mO, this.mQ);
            this.Z = 0;
            byteBuffer.limit(limit);
        }
    }

    private void c(byte[] bArr, int i) {
        az(i).put(bArr, 0, i).flip();
        if (i > 0) {
            this.mR = true;
        }
    }

    private void i(ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining();
        az(remaining).put(byteBuffer).flip();
        if (remaining > 0) {
            this.mR = true;
        }
    }

    private void a(ByteBuffer byteBuffer, byte[] bArr, int i) {
        int min = Math.min(byteBuffer.remaining(), this.mQ);
        int i2 = this.mQ - min;
        System.arraycopy(bArr, i - i2, this.mO, 0, i2);
        byteBuffer.position(byteBuffer.limit() - min);
        byteBuffer.get(this.mO, i2, min);
    }

    private int aa(long j) {
        return (int) ((j * ((long) this.kO.dM)) / 1000000);
    }

    private int j(ByteBuffer byteBuffer) {
        for (int position = byteBuffer.position(); position < byteBuffer.limit(); position += 2) {
            if (Math.abs(byteBuffer.getShort(position)) > this.mM) {
                int i = this.jR;
                return i * (position / i);
            }
        }
        return byteBuffer.limit();
    }

    private int k(ByteBuffer byteBuffer) {
        int limit = byteBuffer.limit();
        while (true) {
            limit -= 2;
            if (limit < byteBuffer.position()) {
                return byteBuffer.position();
            }
            if (Math.abs(byteBuffer.getShort(limit)) > this.mM) {
                int i = this.jR;
                return ((limit / i) * i) + i;
            }
        }
    }
}
