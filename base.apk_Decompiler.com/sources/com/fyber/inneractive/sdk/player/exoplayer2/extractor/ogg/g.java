package com.fyber.inneractive.sdk.player.exoplayer2.extractor.ogg;

import com.fyber.inneractive.sdk.player.exoplayer2.drm.a;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.ogg.h;
import com.fyber.inneractive.sdk.player.exoplayer2.i;
import com.fyber.inneractive.sdk.player.exoplayer2.util.k;
import com.fyber.inneractive.sdk.player.exoplayer2.util.u;
import com.ironsource.mediationsdk.demandOnly.e;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.UByte;

public final class g extends h {
    public static final int o = u.a("Opus");
    public static final byte[] p = {79, 112, 117, 115, 72, 101, 97, 100};
    public boolean n;

    public void a(boolean z) {
        super.a(z);
        if (z) {
            this.n = false;
        }
    }

    public long a(k kVar) {
        byte b;
        byte[] bArr = kVar.a;
        byte b2 = bArr[0];
        byte b3 = b2 & UByte.MAX_VALUE;
        byte b4 = b2 & 3;
        if (b4 != 0) {
            b = 2;
            if (!(b4 == 1 || b4 == 2)) {
                b = bArr[1] & 63;
            }
        } else {
            b = 1;
        }
        int i = b3 >> 3;
        int i2 = i & 3;
        return a((long) (b * (i >= 16 ? e.b.p << i2 : i >= 12 ? 10000 << (i & 1) : i2 == 3 ? 60000 : 10000 << i2)));
    }

    public boolean a(k kVar, long j, h.a aVar) throws IOException, InterruptedException {
        k kVar2 = kVar;
        boolean z = true;
        if (!this.n) {
            byte[] copyOf = Arrays.copyOf(kVar2.a, kVar2.c);
            byte b = copyOf[9] & UByte.MAX_VALUE;
            ArrayList arrayList = new ArrayList(3);
            arrayList.add(copyOf);
            a(arrayList, ((copyOf[11] & UByte.MAX_VALUE) << 8) | (copyOf[10] & UByte.MAX_VALUE));
            a(arrayList, 3840);
            aVar.a = i.a((String) null, "audio/opus", (String) null, -1, -1, (int) b, 48000, -1, (List<byte[]>) arrayList, (a) null, 0, (String) null);
            this.n = true;
            return true;
        }
        if (kVar.c() != o) {
            z = false;
        }
        kVar2.e(0);
        return z;
    }

    public final void a(List<byte[]> list, int i) {
        list.add(ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong((((long) i) * 1000000000) / 48000).array());
    }
}
