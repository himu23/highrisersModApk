package com.fyber.inneractive.sdk.player.exoplayer2.extractor.mkv;

import com.fyber.inneractive.sdk.player.exoplayer2.extractor.b;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.g;
import com.fyber.inneractive.sdk.player.exoplayer2.util.k;
import java.io.IOException;
import kotlin.UByte;

public final class e {
    public final k a = new k(8);
    public int b;

    public final long a(g gVar) throws IOException, InterruptedException {
        b bVar = (b) gVar;
        int i = 0;
        bVar.a(this.a.a, 0, 1, false);
        byte b2 = this.a.a[0] & UByte.MAX_VALUE;
        if (b2 == 0) {
            return Long.MIN_VALUE;
        }
        int i2 = 128;
        int i3 = 0;
        while ((b2 & i2) == 0) {
            i2 >>= 1;
            i3++;
        }
        int i4 = b2 & (~i2);
        bVar.a(this.a.a, 1, i3, false);
        while (i < i3) {
            i++;
            i4 = (this.a.a[i] & UByte.MAX_VALUE) + (i4 << 8);
        }
        this.b += i3 + 1;
        return (long) i4;
    }
}
