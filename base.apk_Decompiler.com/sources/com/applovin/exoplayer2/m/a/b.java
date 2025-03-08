package com.applovin.exoplayer2.m.a;

import com.applovin.exoplayer2.as;
import com.applovin.exoplayer2.c.g;
import com.applovin.exoplayer2.e;
import com.applovin.exoplayer2.l.ai;
import com.applovin.exoplayer2.l.y;
import com.applovin.exoplayer2.p;
import com.applovin.exoplayer2.v;
import java.nio.ByteBuffer;

public final class b extends e {
    private final g HD = new g(1);
    private long afm;
    private a afn;
    private long afo;
    private final y uO = new y();

    /* access modifiers changed from: protected */
    public void a(v[] vVarArr, long j, long j2) {
        this.afm = j2;
    }

    public String getName() {
        return "CameraMotionRenderer";
    }

    public boolean isReady() {
        return true;
    }

    public b() {
        super(6);
    }

    public int b(v vVar) {
        if ("application/x-camera-motion".equals(vVar.dz)) {
            return as.CC.ae(4);
        }
        return as.CC.ae(0);
    }

    public void a(int i, Object obj) throws p {
        if (i == 8) {
            this.afn = (a) obj;
        } else {
            super.a(i, obj);
        }
    }

    /* access modifiers changed from: protected */
    public void a(long j, boolean z) {
        this.afo = Long.MIN_VALUE;
        qJ();
    }

    /* access modifiers changed from: protected */
    public void ac() {
        qJ();
    }

    public void g(long j, long j2) {
        while (!R() && this.afo < 100000 + j) {
            this.HD.clear();
            if (a(ae(), this.HD, 0) == -4 && !this.HD.gY()) {
                this.afo = this.HD.rJ;
                if (this.afn != null && !this.HD.gX()) {
                    this.HD.hh();
                    float[] n = n((ByteBuffer) ai.R(this.HD.rH));
                    if (n != null) {
                        ((a) ai.R(this.afn)).a(this.afo - this.afm, n);
                    }
                }
            } else {
                return;
            }
        }
    }

    public boolean cR() {
        return R();
    }

    private float[] n(ByteBuffer byteBuffer) {
        if (byteBuffer.remaining() != 16) {
            return null;
        }
        this.uO.l(byteBuffer.array(), byteBuffer.limit());
        this.uO.fx(byteBuffer.arrayOffset() + 4);
        float[] fArr = new float[3];
        for (int i = 0; i < 3; i++) {
            fArr[i] = Float.intBitsToFloat(this.uO.py());
        }
        return fArr;
    }

    private void qJ() {
        a aVar = this.afn;
        if (aVar != null) {
            aVar.cZ();
        }
    }
}
