package com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts;

import android.util.SparseArray;
import com.applovin.exoplayer2.common.base.Ascii;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.b;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.f;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.g;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.h;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.m;
import com.fyber.inneractive.sdk.player.exoplayer2.util.j;
import com.fyber.inneractive.sdk.player.exoplayer2.util.k;
import com.fyber.inneractive.sdk.player.exoplayer2.util.r;
import java.io.IOException;
import kotlin.UByte;

public final class p implements f {
    public final r a;
    public final SparseArray<a> b = new SparseArray<>();
    public final k c = new k(4096);
    public boolean d;
    public boolean e;
    public boolean f;
    public h g;

    public static final class a {
        public final h a;
        public final r b;
        public final j c = new j(new byte[64]);
        public boolean d;
        public boolean e;
        public boolean f;
        public long g;

        public a(h hVar, r rVar) {
            this.a = hVar;
            this.b = rVar;
        }
    }

    public p(r rVar) {
        this.a = rVar;
    }

    public void b() {
    }

    public boolean a(g gVar) throws IOException, InterruptedException {
        byte[] bArr = new byte[14];
        b bVar = (b) gVar;
        bVar.a(bArr, 0, 14, false);
        if (442 != (((bArr[0] & UByte.MAX_VALUE) << Ascii.CAN) | ((bArr[1] & UByte.MAX_VALUE) << Ascii.DLE) | ((bArr[2] & UByte.MAX_VALUE) << 8) | (bArr[3] & UByte.MAX_VALUE)) || (bArr[4] & 196) != 68 || (bArr[6] & 4) != 4 || (bArr[8] & 4) != 4 || (bArr[9] & 1) != 1 || (bArr[12] & 3) != 3) {
            return false;
        }
        bVar.a(bArr[13] & 7, false);
        bVar.a(bArr, 0, 3, false);
        if (1 == (((bArr[0] & UByte.MAX_VALUE) << Ascii.DLE) | ((bArr[1] & UByte.MAX_VALUE) << 8) | (bArr[2] & UByte.MAX_VALUE))) {
            return true;
        }
        return false;
    }

    public void a(h hVar) {
        this.g = hVar;
        hVar.a(new m.a(-9223372036854775807L));
    }

    public void a(long j, long j2) {
        this.a.c = -9223372036854775807L;
        for (int i = 0; i < this.b.size(); i++) {
            a valueAt = this.b.valueAt(i);
            valueAt.f = false;
            valueAt.a.a();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x00b0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.g r14, com.fyber.inneractive.sdk.player.exoplayer2.extractor.l r15) throws java.io.IOException, java.lang.InterruptedException {
        /*
            r13 = this;
            com.fyber.inneractive.sdk.player.exoplayer2.util.k r15 = r13.c
            byte[] r15 = r15.a
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.b r14 = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) r14
            r0 = 0
            r1 = 4
            r2 = 1
            boolean r15 = r14.a(r15, r0, r1, r2)
            r3 = -1
            if (r15 != 0) goto L_0x0011
            return r3
        L_0x0011:
            com.fyber.inneractive.sdk.player.exoplayer2.util.k r15 = r13.c
            r15.e(r0)
            com.fyber.inneractive.sdk.player.exoplayer2.util.k r15 = r13.c
            int r15 = r15.c()
            r4 = 441(0x1b9, float:6.18E-43)
            if (r15 != r4) goto L_0x0021
            return r3
        L_0x0021:
            r3 = 442(0x1ba, float:6.2E-43)
            if (r15 != r3) goto L_0x0043
            com.fyber.inneractive.sdk.player.exoplayer2.util.k r15 = r13.c
            byte[] r15 = r15.a
            r1 = 10
            r14.a(r15, r0, r1, r0)
            com.fyber.inneractive.sdk.player.exoplayer2.util.k r15 = r13.c
            r1 = 9
            r15.e(r1)
            com.fyber.inneractive.sdk.player.exoplayer2.util.k r15 = r13.c
            int r15 = r15.l()
            r15 = r15 & 7
            int r15 = r15 + 14
            r14.c(r15)
            return r0
        L_0x0043:
            r3 = 443(0x1bb, float:6.21E-43)
            r4 = 2
            r5 = 6
            if (r15 != r3) goto L_0x0060
            com.fyber.inneractive.sdk.player.exoplayer2.util.k r15 = r13.c
            byte[] r15 = r15.a
            r14.a(r15, r0, r4, r0)
            com.fyber.inneractive.sdk.player.exoplayer2.util.k r15 = r13.c
            r15.e(r0)
            com.fyber.inneractive.sdk.player.exoplayer2.util.k r15 = r13.c
            int r15 = r15.q()
            int r15 = r15 + r5
            r14.c(r15)
            return r0
        L_0x0060:
            r3 = r15 & -256(0xffffffffffffff00, float:NaN)
            r6 = 8
            int r3 = r3 >> r6
            if (r3 == r2) goto L_0x006b
            r14.c(r2)
            return r0
        L_0x006b:
            r3 = r15 & 255(0xff, float:3.57E-43)
            android.util.SparseArray<com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.p$a> r7 = r13.b
            java.lang.Object r7 = r7.get(r3)
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.p$a r7 = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.p.a) r7
            boolean r8 = r13.d
            if (r8 != 0) goto L_0x00e3
            if (r7 != 0) goto L_0x00cb
            boolean r8 = r13.e
            r9 = 0
            if (r8 != 0) goto L_0x008d
            r10 = 189(0xbd, float:2.65E-43)
            if (r3 != r10) goto L_0x008d
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.b r15 = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.b
            r15.<init>(r9)
            r13.e = r2
        L_0x008b:
            r9 = r15
            goto L_0x00ae
        L_0x008d:
            if (r8 != 0) goto L_0x009d
            r8 = r15 & 224(0xe0, float:3.14E-43)
            r10 = 192(0xc0, float:2.69E-43)
            if (r8 != r10) goto L_0x009d
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.m r15 = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.m
            r15.<init>(r9)
            r13.e = r2
            goto L_0x008b
        L_0x009d:
            boolean r8 = r13.f
            if (r8 != 0) goto L_0x00ae
            r15 = r15 & 240(0xf0, float:3.36E-43)
            r8 = 224(0xe0, float:3.14E-43)
            if (r15 != r8) goto L_0x00ae
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.i r9 = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.i
            r9.<init>()
            r13.f = r2
        L_0x00ae:
            if (r9 == 0) goto L_0x00cb
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.v$d r15 = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.v$d
            r7 = -2147483648(0xffffffff80000000, float:-0.0)
            r8 = 256(0x100, float:3.59E-43)
            r15.<init>(r7, r3, r8)
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.h r7 = r13.g
            r9.a((com.fyber.inneractive.sdk.player.exoplayer2.extractor.h) r7, (com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.v.d) r15)
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.p$a r15 = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.p$a
            com.fyber.inneractive.sdk.player.exoplayer2.util.r r7 = r13.a
            r15.<init>(r9, r7)
            android.util.SparseArray<com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.p$a> r7 = r13.b
            r7.put(r3, r15)
            r7 = r15
        L_0x00cb:
            boolean r15 = r13.e
            if (r15 == 0) goto L_0x00d3
            boolean r15 = r13.f
            if (r15 != 0) goto L_0x00dc
        L_0x00d3:
            long r8 = r14.c
            r10 = 1048576(0x100000, double:5.180654E-318)
            int r15 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r15 <= 0) goto L_0x00e3
        L_0x00dc:
            r13.d = r2
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.h r15 = r13.g
            r15.c()
        L_0x00e3:
            com.fyber.inneractive.sdk.player.exoplayer2.util.k r15 = r13.c
            byte[] r15 = r15.a
            r14.a(r15, r0, r4, r0)
            com.fyber.inneractive.sdk.player.exoplayer2.util.k r15 = r13.c
            r15.e(r0)
            com.fyber.inneractive.sdk.player.exoplayer2.util.k r15 = r13.c
            int r15 = r15.q()
            int r15 = r15 + r5
            if (r7 != 0) goto L_0x00fd
            r14.c(r15)
            goto L_0x01e1
        L_0x00fd:
            com.fyber.inneractive.sdk.player.exoplayer2.util.k r3 = r13.c
            r3.c(r15)
            com.fyber.inneractive.sdk.player.exoplayer2.util.k r3 = r13.c
            byte[] r3 = r3.a
            r14.b(r3, r0, r15, r0)
            com.fyber.inneractive.sdk.player.exoplayer2.util.k r14 = r13.c
            r14.e(r5)
            com.fyber.inneractive.sdk.player.exoplayer2.util.k r14 = r13.c
            com.fyber.inneractive.sdk.player.exoplayer2.util.j r15 = r7.c
            byte[] r15 = r15.a
            r3 = 3
            r14.a(r15, r0, r3)
            com.fyber.inneractive.sdk.player.exoplayer2.util.j r15 = r7.c
            r15.b(r0)
            com.fyber.inneractive.sdk.player.exoplayer2.util.j r15 = r7.c
            r15.c(r6)
            com.fyber.inneractive.sdk.player.exoplayer2.util.j r15 = r7.c
            boolean r15 = r15.b()
            r7.d = r15
            com.fyber.inneractive.sdk.player.exoplayer2.util.j r15 = r7.c
            boolean r15 = r15.b()
            r7.e = r15
            com.fyber.inneractive.sdk.player.exoplayer2.util.j r15 = r7.c
            r15.c(r5)
            com.fyber.inneractive.sdk.player.exoplayer2.util.j r15 = r7.c
            int r15 = r15.a(r6)
            com.fyber.inneractive.sdk.player.exoplayer2.util.j r4 = r7.c
            byte[] r4 = r4.a
            r14.a(r4, r0, r15)
            com.fyber.inneractive.sdk.player.exoplayer2.util.j r15 = r7.c
            r15.b(r0)
            r4 = 0
            r7.g = r4
            boolean r15 = r7.d
            if (r15 == 0) goto L_0x01c7
            com.fyber.inneractive.sdk.player.exoplayer2.util.j r15 = r7.c
            r15.c(r1)
            com.fyber.inneractive.sdk.player.exoplayer2.util.j r15 = r7.c
            int r15 = r15.a(r3)
            long r4 = (long) r15
            r15 = 30
            long r4 = r4 << r15
            com.fyber.inneractive.sdk.player.exoplayer2.util.j r6 = r7.c
            r6.c(r2)
            com.fyber.inneractive.sdk.player.exoplayer2.util.j r6 = r7.c
            r8 = 15
            int r6 = r6.a(r8)
            int r6 = r6 << r8
            long r9 = (long) r6
            long r4 = r4 | r9
            com.fyber.inneractive.sdk.player.exoplayer2.util.j r6 = r7.c
            r6.c(r2)
            com.fyber.inneractive.sdk.player.exoplayer2.util.j r6 = r7.c
            int r6 = r6.a(r8)
            long r9 = (long) r6
            long r4 = r4 | r9
            com.fyber.inneractive.sdk.player.exoplayer2.util.j r6 = r7.c
            r6.c(r2)
            boolean r6 = r7.f
            if (r6 != 0) goto L_0x01bf
            boolean r6 = r7.e
            if (r6 == 0) goto L_0x01bf
            com.fyber.inneractive.sdk.player.exoplayer2.util.j r6 = r7.c
            r6.c(r1)
            com.fyber.inneractive.sdk.player.exoplayer2.util.j r1 = r7.c
            int r1 = r1.a(r3)
            long r9 = (long) r1
            long r9 = r9 << r15
            com.fyber.inneractive.sdk.player.exoplayer2.util.j r15 = r7.c
            r15.c(r2)
            com.fyber.inneractive.sdk.player.exoplayer2.util.j r15 = r7.c
            int r15 = r15.a(r8)
            int r15 = r15 << r8
            long r11 = (long) r15
            long r9 = r9 | r11
            com.fyber.inneractive.sdk.player.exoplayer2.util.j r15 = r7.c
            r15.c(r2)
            com.fyber.inneractive.sdk.player.exoplayer2.util.j r15 = r7.c
            int r15 = r15.a(r8)
            long r11 = (long) r15
            long r8 = r9 | r11
            com.fyber.inneractive.sdk.player.exoplayer2.util.j r15 = r7.c
            r15.c(r2)
            com.fyber.inneractive.sdk.player.exoplayer2.util.r r15 = r7.b
            r15.b(r8)
            r7.f = r2
        L_0x01bf:
            com.fyber.inneractive.sdk.player.exoplayer2.util.r r15 = r7.b
            long r3 = r15.b(r4)
            r7.g = r3
        L_0x01c7:
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h r15 = r7.a
            long r3 = r7.g
            r15.a((long) r3, (boolean) r2)
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h r15 = r7.a
            r15.a(r14)
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.h r14 = r7.a
            r14.b()
            com.fyber.inneractive.sdk.player.exoplayer2.util.k r14 = r13.c
            int r15 = r14.b()
            r14.d(r15)
        L_0x01e1:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.p.a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.g, com.fyber.inneractive.sdk.player.exoplayer2.extractor.l):int");
    }
}
