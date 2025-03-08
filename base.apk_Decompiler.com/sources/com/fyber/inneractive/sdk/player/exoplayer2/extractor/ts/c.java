package com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts;

import androidx.work.impl.Scheduler;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.b;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.f;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.g;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.h;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.l;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.m;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.v;
import com.fyber.inneractive.sdk.player.exoplayer2.util.k;
import com.fyber.inneractive.sdk.player.exoplayer2.util.u;
import java.io.IOException;

public final class c implements f {
    public static final int e = u.a("ID3");
    public final long a;
    public final k b = new k((int) Scheduler.MAX_GREEDY_SCHEDULER_LIMIT);
    public d c;
    public boolean d;

    public c(long j) {
        this.a = j;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0042, code lost:
        r6.e = 0;
        r1 = r1 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x004a, code lost:
        if ((r1 - r4) < 8192) goto L_0x004d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x004c, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.g r11) throws java.io.IOException, java.lang.InterruptedException {
        /*
            r10 = this;
            com.fyber.inneractive.sdk.player.exoplayer2.util.k r0 = new com.fyber.inneractive.sdk.player.exoplayer2.util.k
            r1 = 10
            r0.<init>((int) r1)
            com.fyber.inneractive.sdk.player.exoplayer2.util.j r2 = new com.fyber.inneractive.sdk.player.exoplayer2.util.j
            byte[] r3 = r0.a
            int r4 = r3.length
            r2.<init>(r3, r4)
            r3 = 0
            r4 = 0
        L_0x0011:
            byte[] r5 = r0.a
            r6 = r11
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.b r6 = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) r6
            r6.a(r5, r3, r1, r3)
            r0.e(r3)
            int r5 = r0.n()
            int r7 = e
            if (r5 == r7) goto L_0x0076
            r6.e = r3
            r6.a(r4, r3)
            r1 = r4
        L_0x002a:
            r11 = 0
            r5 = 0
        L_0x002c:
            byte[] r7 = r0.a
            r8 = 2
            r6.a(r7, r3, r8, r3)
            r0.e(r3)
            int r7 = r0.q()
            r8 = 65526(0xfff6, float:9.1821E-41)
            r7 = r7 & r8
            r8 = 65520(0xfff0, float:9.1813E-41)
            if (r7 == r8) goto L_0x0051
            r6.e = r3
            int r1 = r1 + 1
            int r11 = r1 - r4
            r5 = 8192(0x2000, float:1.14794E-41)
            if (r11 < r5) goto L_0x004d
            return r3
        L_0x004d:
            r6.a(r1, r3)
            goto L_0x002a
        L_0x0051:
            r7 = 1
            int r11 = r11 + r7
            r8 = 4
            if (r11 < r8) goto L_0x005b
            r9 = 188(0xbc, float:2.63E-43)
            if (r5 <= r9) goto L_0x005b
            return r7
        L_0x005b:
            byte[] r7 = r0.a
            r6.a(r7, r3, r8, r3)
            r7 = 14
            r2.b(r7)
            r7 = 13
            int r7 = r2.a(r7)
            r8 = 6
            if (r7 > r8) goto L_0x006f
            return r3
        L_0x006f:
            int r8 = r7 + -6
            r6.a(r8, r3)
            int r5 = r5 + r7
            goto L_0x002c
        L_0x0076:
            r5 = 3
            r0.f(r5)
            int r5 = r0.k()
            int r7 = r5 + 10
            int r4 = r4 + r7
            r6.a(r5, r3)
            goto L_0x0011
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.c.a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.g):boolean");
    }

    public void b() {
    }

    public void a(h hVar) {
        d dVar = new d(true, (String) null);
        this.c = dVar;
        dVar.a(hVar, new v.d(Integer.MIN_VALUE, 0, 1));
        hVar.c();
        hVar.a(new m.a(-9223372036854775807L));
    }

    public void a(long j, long j2) {
        this.d = false;
        this.c.c();
    }

    public int a(g gVar, l lVar) throws IOException, InterruptedException {
        int a2 = ((b) gVar).a(this.b.a, 0, Scheduler.MAX_GREEDY_SCHEDULER_LIMIT);
        if (a2 == -1) {
            return -1;
        }
        this.b.e(0);
        this.b.d(a2);
        if (!this.d) {
            this.c.o = this.a;
            this.d = true;
        }
        this.c.a(this.b);
        return 0;
    }
}
