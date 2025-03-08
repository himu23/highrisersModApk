package com.applovin.exoplayer2.b;

import com.applovin.exoplayer2.b.f;
import com.applovin.exoplayer2.l.a;
import java.nio.ByteBuffer;

final class m extends l {
    private int[] kV;
    private int[] kW;

    /* access modifiers changed from: protected */
    public void ad() {
        this.kW = null;
        this.kV = null;
    }

    public void c(int[] iArr) {
        this.kV = iArr;
    }

    /* access modifiers changed from: protected */
    public void eg() {
        this.kW = this.kV;
    }

    m() {
    }

    public f.a b(f.a aVar) throws f.b {
        int[] iArr = this.kV;
        if (iArr == null) {
            return f.a.jP;
        }
        if (aVar.jQ == 2) {
            boolean z = aVar.dL != iArr.length;
            int i = 0;
            while (i < iArr.length) {
                int i2 = iArr[i];
                if (i2 < aVar.dL) {
                    z |= i2 != i;
                    i++;
                } else {
                    throw new f.b(aVar);
                }
            }
            if (z) {
                return new f.a(aVar.dM, iArr.length, 2);
            }
            return f.a.jP;
        }
        throw new f.b(aVar);
    }

    public void d(ByteBuffer byteBuffer) {
        int[] iArr = (int[]) a.checkNotNull(this.kW);
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        ByteBuffer az = az(((limit - position) / this.kO.jR) * this.kP.jR);
        while (position < limit) {
            for (int i : iArr) {
                az.putShort(byteBuffer.getShort((i * 2) + position));
            }
            position += this.kO.jR;
        }
        byteBuffer.position(limit);
        az.flip();
    }
}
