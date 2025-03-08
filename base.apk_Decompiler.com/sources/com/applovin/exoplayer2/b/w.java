package com.applovin.exoplayer2.b;

import android.support.v4.media.session.PlaybackStateCompat;
import com.applovin.exoplayer2.b.f;
import com.applovin.exoplayer2.l.a;
import com.applovin.exoplayer2.l.ai;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

public final class w implements f {
    private float gD = 1.0f;
    private float gE = 1.0f;
    private f.a kO = f.a.jP;
    private f.a kP = f.a.jP;
    private f.a kQ = f.a.jP;
    private f.a kR = f.a.jP;
    private ByteBuffer kS;
    private ByteBuffer kT;
    private boolean kU;
    private int nm;
    private boolean nn;
    private v no;
    private ShortBuffer np;
    private long nq;
    private long nr;

    public void l(float f) {
        if (this.gD != f) {
            this.gD = f;
            this.nn = true;
        }
    }

    public void m(float f) {
        if (this.gE != f) {
            this.gE = f;
            this.nn = true;
        }
    }

    public w() {
        ByteBuffer byteBuffer = jO;
        this.kS = byteBuffer;
        this.np = byteBuffer.asShortBuffer();
        this.kT = jO;
        this.nm = -1;
    }

    public long U(long j) {
        if (this.nr < PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID) {
            return (long) (((double) this.gD) * ((double) j));
        }
        long eN = this.nq - ((long) ((v) a.checkNotNull(this.no)).eN());
        if (this.kP.dM == this.kO.dM) {
            return ai.e(j, eN, this.nr);
        }
        return ai.e(j, eN * ((long) this.kP.dM), this.nr * ((long) this.kO.dM));
    }

    public f.a a(f.a aVar) throws f.b {
        if (aVar.jQ == 2) {
            int i = this.nm;
            if (i == -1) {
                i = aVar.dM;
            }
            this.kQ = aVar;
            f.a aVar2 = new f.a(i, aVar.dL, 2);
            this.kR = aVar2;
            this.nn = true;
            return aVar2;
        }
        throw new f.b(aVar);
    }

    public boolean isActive() {
        return this.kR.dM != -1 && (Math.abs(this.gD - 1.0f) >= 1.0E-4f || Math.abs(this.gE - 1.0f) >= 1.0E-4f || this.kR.dM != this.kQ.dM);
    }

    public void d(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            ShortBuffer asShortBuffer = byteBuffer.asShortBuffer();
            int remaining = byteBuffer.remaining();
            this.nq += (long) remaining;
            ((v) a.checkNotNull(this.no)).a(asShortBuffer);
            byteBuffer.position(byteBuffer.position() + remaining);
        }
    }

    public void dG() {
        v vVar = this.no;
        if (vVar != null) {
            vVar.dG();
        }
        this.kU = true;
    }

    public ByteBuffer dH() {
        int eO;
        v vVar = this.no;
        if (vVar != null && (eO = vVar.eO()) > 0) {
            if (this.kS.capacity() < eO) {
                ByteBuffer order = ByteBuffer.allocateDirect(eO).order(ByteOrder.nativeOrder());
                this.kS = order;
                this.np = order.asShortBuffer();
            } else {
                this.kS.clear();
                this.np.clear();
            }
            vVar.b(this.np);
            this.nr += (long) eO;
            this.kS.limit(eO);
            this.kT = this.kS;
        }
        ByteBuffer byteBuffer = this.kT;
        this.kT = jO;
        return byteBuffer;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r1.no;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean cR() {
        /*
            r1 = this;
            boolean r0 = r1.kU
            if (r0 == 0) goto L_0x0010
            com.applovin.exoplayer2.b.v r0 = r1.no
            if (r0 == 0) goto L_0x000e
            int r0 = r0.eO()
            if (r0 != 0) goto L_0x0010
        L_0x000e:
            r0 = 1
            goto L_0x0011
        L_0x0010:
            r0 = 0
        L_0x0011:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.b.w.cR():boolean");
    }

    public void dI() {
        if (isActive()) {
            f.a aVar = this.kQ;
            this.kO = aVar;
            this.kP = this.kR;
            if (this.nn) {
                this.no = new v(aVar.dM, this.kO.dL, this.gD, this.gE, this.kP.dM);
            } else {
                v vVar = this.no;
                if (vVar != null) {
                    vVar.dI();
                }
            }
        }
        this.kT = jO;
        this.nq = 0;
        this.nr = 0;
        this.kU = false;
    }

    public void Y() {
        this.gD = 1.0f;
        this.gE = 1.0f;
        this.kQ = f.a.jP;
        this.kR = f.a.jP;
        this.kO = f.a.jP;
        this.kP = f.a.jP;
        ByteBuffer byteBuffer = jO;
        this.kS = byteBuffer;
        this.np = byteBuffer.asShortBuffer();
        this.kT = jO;
        this.nm = -1;
        this.nn = false;
        this.no = null;
        this.nq = 0;
        this.nr = 0;
        this.kU = false;
    }
}
