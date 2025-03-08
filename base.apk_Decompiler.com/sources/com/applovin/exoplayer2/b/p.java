package com.applovin.exoplayer2.b;

import com.applovin.exoplayer2.b.f;
import com.applovin.exoplayer2.common.base.Ascii;
import com.applovin.exoplayer2.l.ai;
import java.nio.ByteBuffer;
import kotlin.UByte;

final class p extends l {
    private static final int mn = Float.floatToIntBits(Float.NaN);

    p() {
    }

    public f.a b(f.a aVar) throws f.b {
        int i = aVar.jQ;
        if (!ai.fK(i)) {
            throw new f.b(aVar);
        } else if (i != 4) {
            return new f.a(aVar.dM, aVar.dL, 4);
        } else {
            return f.a.jP;
        }
    }

    public void d(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2;
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int i = limit - position;
        int i2 = this.kO.jQ;
        if (i2 == 536870912) {
            byteBuffer2 = az((i / 3) * 4);
            while (position < limit) {
                b(((byteBuffer.get(position) & UByte.MAX_VALUE) << 8) | ((byteBuffer.get(position + 1) & UByte.MAX_VALUE) << Ascii.DLE) | ((byteBuffer.get(position + 2) & UByte.MAX_VALUE) << Ascii.CAN), byteBuffer2);
                position += 3;
            }
        } else if (i2 == 805306368) {
            byteBuffer2 = az(i);
            while (position < limit) {
                b((byteBuffer.get(position) & UByte.MAX_VALUE) | ((byteBuffer.get(position + 1) & UByte.MAX_VALUE) << 8) | ((byteBuffer.get(position + 2) & UByte.MAX_VALUE) << Ascii.DLE) | ((byteBuffer.get(position + 3) & UByte.MAX_VALUE) << Ascii.CAN), byteBuffer2);
                position += 4;
            }
        } else {
            throw new IllegalStateException();
        }
        byteBuffer.position(byteBuffer.limit());
        byteBuffer2.flip();
    }

    private static void b(int i, ByteBuffer byteBuffer) {
        int floatToIntBits = Float.floatToIntBits((float) (((double) i) * 4.656612875245797E-10d));
        if (floatToIntBits == mn) {
            floatToIntBits = Float.floatToIntBits(0.0f);
        }
        byteBuffer.putInt(floatToIntBits);
    }
}
