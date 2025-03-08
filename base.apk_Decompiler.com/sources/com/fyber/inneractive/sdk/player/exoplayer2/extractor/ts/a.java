package com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts;

import com.fyber.inneractive.sdk.player.exoplayer2.extractor.b;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.f;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.g;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.h;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.l;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.m;
import com.fyber.inneractive.sdk.player.exoplayer2.util.k;
import com.fyber.inneractive.sdk.player.exoplayer2.util.u;
import java.io.IOException;

public final class a implements f {
    public static final int e = u.a("ID3");
    public final long a;
    public final k b = new k(2786);
    public b c;
    public boolean d;

    public a(long j) {
        this.a = j;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0034, code lost:
        r5.e = 0;
        r1 = r1 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x003c, code lost:
        if ((r1 - r3) < 8192) goto L_0x003f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x003e, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.g r11) throws java.io.IOException, java.lang.InterruptedException {
        /*
            r10 = this;
            com.fyber.inneractive.sdk.player.exoplayer2.util.k r0 = new com.fyber.inneractive.sdk.player.exoplayer2.util.k
            r1 = 10
            r0.<init>((int) r1)
            r2 = 0
            r3 = 0
        L_0x0009:
            byte[] r4 = r0.a
            r5 = r11
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.b r5 = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) r5
            r5.a(r4, r2, r1, r2)
            r0.e(r2)
            int r4 = r0.n()
            int r6 = e
            if (r4 == r6) goto L_0x0066
            r5.e = r2
            r5.a(r3, r2)
            r1 = r3
        L_0x0022:
            r11 = 0
        L_0x0023:
            byte[] r4 = r0.a
            r6 = 5
            r5.a(r4, r2, r6, r2)
            r0.e(r2)
            int r4 = r0.q()
            r7 = 2935(0xb77, float:4.113E-42)
            if (r4 == r7) goto L_0x0043
            r5.e = r2
            int r1 = r1 + 1
            int r11 = r1 - r3
            r4 = 8192(0x2000, float:1.14794E-41)
            if (r11 < r4) goto L_0x003f
            return r2
        L_0x003f:
            r5.a(r1, r2)
            goto L_0x0022
        L_0x0043:
            r4 = 1
            int r11 = r11 + r4
            r7 = 4
            if (r11 < r7) goto L_0x0049
            return r4
        L_0x0049:
            byte[] r4 = r0.a
            int r8 = r4.length
            r9 = -1
            if (r8 >= r6) goto L_0x0051
            r4 = -1
            goto L_0x005d
        L_0x0051:
            byte r4 = r4[r7]
            r6 = r4 & 192(0xc0, float:2.69E-43)
            int r6 = r6 >> 6
            r4 = r4 & 63
            int r4 = com.fyber.inneractive.sdk.player.exoplayer2.audio.a.a(r6, r4)
        L_0x005d:
            if (r4 != r9) goto L_0x0060
            return r2
        L_0x0060:
            int r4 = r4 + -5
            r5.a(r4, r2)
            goto L_0x0023
        L_0x0066:
            r4 = 3
            r0.f(r4)
            int r4 = r0.k()
            int r6 = r4 + 10
            int r3 = r3 + r6
            r5.a(r4, r2)
            goto L_0x0009
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.a.a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.g):boolean");
    }

    public void b() {
    }

    public void a(h hVar) {
        b bVar = new b((String) null);
        this.c = bVar;
        bVar.d = "0";
        bVar.e = hVar.a(0, 1);
        hVar.c();
        hVar.a(new m.a(-9223372036854775807L));
    }

    public void a(long j, long j2) {
        this.d = false;
        this.c.a();
    }

    public int a(g gVar, l lVar) throws IOException, InterruptedException {
        int a2 = ((b) gVar).a(this.b.a, 0, 2786);
        if (a2 == -1) {
            return -1;
        }
        this.b.e(0);
        this.b.d(a2);
        if (!this.d) {
            this.c.l = this.a;
            this.d = true;
        }
        this.c.a(this.b);
        return 0;
    }
}
