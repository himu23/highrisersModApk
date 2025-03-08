package com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4;

import android.util.Pair;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a;
import com.fyber.inneractive.sdk.player.exoplayer2.i;
import com.fyber.inneractive.sdk.player.exoplayer2.util.k;
import com.fyber.inneractive.sdk.player.exoplayer2.util.u;
import com.ironsource.m2;
import com.unity3d.services.core.device.MimeTypes;
import kotlinx.coroutines.scheduling.WorkQueueKt;

public final class b {
    public static final int a = u.a("vide");
    public static final int b = u.a("soun");
    public static final int c = u.a(m2.h.K0);
    public static final int d = u.a("sbtl");
    public static final int e = u.a("subt");
    public static final int f = u.a("clcp");
    public static final int g = u.a("cenc");
    public static final int h = u.a("meta");

    public interface a {
        int a();

        int b();

        boolean c();
    }

    /* renamed from: com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.b$b  reason: collision with other inner class name */
    public static final class C0121b {
        public final i[] a;
        public i b;
        public int c;
        public int d = 0;

        public C0121b(int i) {
            this.a = new i[i];
        }
    }

    public static final class c implements a {
        public final int a;
        public final int b;
        public final k c;

        public c(a.b bVar) {
            k kVar = bVar.P0;
            this.c = kVar;
            kVar.e(12);
            this.a = kVar.o();
            this.b = kVar.o();
        }

        public int a() {
            return this.b;
        }

        public int b() {
            int i = this.a;
            return i == 0 ? this.c.o() : i;
        }

        public boolean c() {
            return this.a != 0;
        }
    }

    public static final class d implements a {
        public final k a;
        public final int b;
        public final int c;
        public int d;
        public int e;

        public d(a.b bVar) {
            k kVar = bVar.P0;
            this.a = kVar;
            kVar.e(12);
            this.c = kVar.o() & 255;
            this.b = kVar.o();
        }

        public int a() {
            return this.b;
        }

        public boolean c() {
            return false;
        }

        public int b() {
            int i = this.c;
            if (i == 8) {
                return this.a.l();
            }
            if (i == 16) {
                return this.a.q();
            }
            int i2 = this.d;
            this.d = i2 + 1;
            if (i2 % 2 != 0) {
                return this.e & 15;
            }
            int l = this.a.l();
            this.e = l;
            return (l & 240) >> 4;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v8, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r26v6, resolved type: java.lang.String} */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0092, code lost:
        if (r8 == 0) goto L_0x009b;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.h a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.C0120a r46, com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.b r47, long r48, com.fyber.inneractive.sdk.player.exoplayer2.drm.a r50, boolean r51) throws com.fyber.inneractive.sdk.player.exoplayer2.l {
        /*
            r0 = r46
            int r1 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.F
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a$a r1 = r0.c(r1)
            int r2 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.T
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a$b r2 = r1.d(r2)
            com.fyber.inneractive.sdk.player.exoplayer2.util.k r2 = r2.P0
            r3 = 16
            r2.e(r3)
            int r2 = r2.c()
            int r4 = b
            r6 = 4
            r7 = -1
            if (r2 != r4) goto L_0x0021
            r12 = 1
            goto L_0x0041
        L_0x0021:
            int r4 = a
            if (r2 != r4) goto L_0x0027
            r12 = 2
            goto L_0x0041
        L_0x0027:
            int r4 = c
            if (r2 == r4) goto L_0x0040
            int r4 = d
            if (r2 == r4) goto L_0x0040
            int r4 = e
            if (r2 == r4) goto L_0x0040
            int r4 = f
            if (r2 != r4) goto L_0x0038
            goto L_0x0040
        L_0x0038:
            int r4 = h
            if (r2 != r4) goto L_0x003e
            r12 = 4
            goto L_0x0041
        L_0x003e:
            r12 = -1
            goto L_0x0041
        L_0x0040:
            r12 = 3
        L_0x0041:
            r2 = 0
            if (r12 != r7) goto L_0x0045
            return r2
        L_0x0045:
            int r4 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.P
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a$b r4 = r0.d(r4)
            com.fyber.inneractive.sdk.player.exoplayer2.util.k r4 = r4.P0
            r10 = 8
            r4.e(r10)
            int r11 = r4.c()
            int r11 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.b(r11)
            if (r11 != 0) goto L_0x005f
            r13 = 8
            goto L_0x0061
        L_0x005f:
            r13 = 16
        L_0x0061:
            r4.f(r13)
            int r13 = r4.c()
            r4.f(r6)
            int r14 = r4.b
            if (r11 != 0) goto L_0x0071
            r15 = 4
            goto L_0x0073
        L_0x0071:
            r15 = 8
        L_0x0073:
            r8 = 0
        L_0x0074:
            r18 = 0
            r20 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r8 >= r15) goto L_0x0098
            byte[] r9 = r4.a
            int r23 = r14 + r8
            byte r9 = r9[r23]
            if (r9 == r7) goto L_0x0095
            if (r11 != 0) goto L_0x008c
            long r8 = r4.m()
            goto L_0x0090
        L_0x008c:
            long r8 = r4.p()
        L_0x0090:
            int r11 = (r8 > r18 ? 1 : (r8 == r18 ? 0 : -1))
            if (r11 != 0) goto L_0x009d
            goto L_0x009b
        L_0x0095:
            int r8 = r8 + 1
            goto L_0x0074
        L_0x0098:
            r4.f(r15)
        L_0x009b:
            r8 = r20
        L_0x009d:
            r4.f(r3)
            int r11 = r4.c()
            int r14 = r4.c()
            r4.f(r6)
            int r15 = r4.c()
            int r4 = r4.c()
            r6 = -65536(0xffffffffffff0000, float:NaN)
            r3 = 65536(0x10000, float:9.18355E-41)
            if (r11 != 0) goto L_0x00c2
            if (r14 != r3) goto L_0x00c2
            if (r15 != r6) goto L_0x00c2
            if (r4 != 0) goto L_0x00c2
            r3 = 90
            goto L_0x00d9
        L_0x00c2:
            if (r11 != 0) goto L_0x00cd
            if (r14 != r6) goto L_0x00cd
            if (r15 != r3) goto L_0x00cd
            if (r4 != 0) goto L_0x00cd
            r3 = 270(0x10e, float:3.78E-43)
            goto L_0x00d9
        L_0x00cd:
            if (r11 != r6) goto L_0x00d8
            if (r14 != 0) goto L_0x00d8
            if (r15 != 0) goto L_0x00d8
            if (r4 != r6) goto L_0x00d8
            r3 = 180(0xb4, float:2.52E-43)
            goto L_0x00d9
        L_0x00d8:
            r3 = 0
        L_0x00d9:
            int r4 = (r48 > r20 ? 1 : (r48 == r20 ? 0 : -1))
            if (r4 != 0) goto L_0x00e2
            r4 = r47
            r25 = r8
            goto L_0x00e6
        L_0x00e2:
            r4 = r47
            r25 = r48
        L_0x00e6:
            com.fyber.inneractive.sdk.player.exoplayer2.util.k r4 = r4.P0
            r4.e(r10)
            int r6 = r4.c()
            int r6 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.b(r6)
            if (r6 != 0) goto L_0x00f8
            r6 = 8
            goto L_0x00fa
        L_0x00f8:
            r6 = 16
        L_0x00fa:
            r4.f(r6)
            long r8 = r4.m()
            int r4 = (r25 > r20 ? 1 : (r25 == r20 ? 0 : -1))
            if (r4 != 0) goto L_0x0106
            goto L_0x0111
        L_0x0106:
            r27 = 1000000(0xf4240, double:4.940656E-318)
            r29 = r8
            long r14 = com.fyber.inneractive.sdk.player.exoplayer2.util.u.a((long) r25, (long) r27, (long) r29)
            r20 = r14
        L_0x0111:
            int r4 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.G
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a$a r4 = r1.c(r4)
            int r6 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.H
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a$a r4 = r4.c(r6)
            int r6 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.S
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a$b r1 = r1.d(r6)
            com.fyber.inneractive.sdk.player.exoplayer2.util.k r1 = r1.P0
            r1.e(r10)
            int r6 = r1.c()
            int r6 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.b(r6)
            if (r6 != 0) goto L_0x0135
            r11 = 8
            goto L_0x0137
        L_0x0135:
            r11 = 16
        L_0x0137:
            r1.f(r11)
            long r14 = r1.m()
            if (r6 != 0) goto L_0x0142
            r6 = 4
            goto L_0x0144
        L_0x0142:
            r6 = 8
        L_0x0144:
            r1.f(r6)
            int r1 = r1.q()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r11 = ""
            r6.<init>(r11)
            int r11 = r1 >> 10
            r11 = r11 & 31
            int r11 = r11 + 96
            char r11 = (char) r11
            r6.append(r11)
            int r11 = r1 >> 5
            r11 = r11 & 31
            int r11 = r11 + 96
            char r11 = (char) r11
            r6.append(r11)
            r1 = r1 & 31
            int r1 = r1 + 96
            char r1 = (char) r1
            r6.append(r1)
            java.lang.String r1 = r6.toString()
            java.lang.Long r6 = java.lang.Long.valueOf(r14)
            android.util.Pair r1 = android.util.Pair.create(r6, r1)
            int r6 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.U
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a$b r4 = r4.d(r6)
            com.fyber.inneractive.sdk.player.exoplayer2.util.k r4 = r4.P0
            java.lang.Object r6 = r1.second
            java.lang.String r6 = (java.lang.String) r6
            r11 = 12
            r4.e(r11)
            int r11 = r4.c()
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.b$b r14 = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.b$b
            r14.<init>(r11)
            r15 = 0
        L_0x0195:
            if (r15 >= r11) goto L_0x0701
            int r10 = r4.b
            int r5 = r4.c()
            if (r5 <= 0) goto L_0x01a1
            r2 = 1
            goto L_0x01a2
        L_0x01a1:
            r2 = 0
        L_0x01a2:
            java.lang.String r7 = "childAtomSize should be positive"
            com.fyber.inneractive.sdk.player.exoplayer2.util.a.a(r2, r7)
            int r2 = r4.c()
            r47 = r11
            int r11 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.c
            if (r2 == r11) goto L_0x0557
            int r11 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.d
            if (r2 == r11) goto L_0x0557
            int r11 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.a0
            if (r2 == r11) goto L_0x0557
            int r11 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.l0
            if (r2 == r11) goto L_0x0557
            int r11 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.e
            if (r2 == r11) goto L_0x0557
            int r11 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.f
            if (r2 == r11) goto L_0x0557
            int r11 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.g
            if (r2 == r11) goto L_0x0557
            int r11 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.K0
            if (r2 == r11) goto L_0x0557
            int r11 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.L0
            if (r2 != r11) goto L_0x01d3
            goto L_0x0557
        L_0x01d3:
            int r11 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.j
            if (r2 == r11) goto L_0x02ba
            int r11 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.b0
            if (r2 == r11) goto L_0x02ba
            int r11 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.o
            if (r2 == r11) goto L_0x02ba
            int r11 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.q
            if (r2 == r11) goto L_0x02ba
            int r11 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.s
            if (r2 == r11) goto L_0x02ba
            int r11 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.v
            if (r2 == r11) goto L_0x02ba
            int r11 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.t
            if (r2 == r11) goto L_0x02ba
            int r11 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.u
            if (r2 == r11) goto L_0x02ba
            int r11 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.y0
            if (r2 == r11) goto L_0x02ba
            int r11 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.z0
            if (r2 == r11) goto L_0x02ba
            int r11 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.m
            if (r2 == r11) goto L_0x02ba
            int r11 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.n
            if (r2 == r11) goto L_0x02ba
            int r11 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.k
            if (r2 == r11) goto L_0x02ba
            int r11 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.O0
            if (r2 != r11) goto L_0x020d
            goto L_0x02ba
        L_0x020d:
            int r7 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.k0
            if (r2 == r7) goto L_0x0240
            int r11 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.u0
            if (r2 == r11) goto L_0x0240
            int r11 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.v0
            if (r2 == r11) goto L_0x0240
            int r11 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.w0
            if (r2 == r11) goto L_0x0240
            int r11 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.x0
            if (r2 != r11) goto L_0x0222
            goto L_0x0240
        L_0x0222:
            int r7 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.N0
            if (r2 != r7) goto L_0x023a
            java.lang.String r2 = java.lang.Integer.toString(r13)
            java.lang.String r7 = "application/x-camera-motion"
            r11 = r50
            r48 = r8
            r8 = -1
            r9 = 0
            com.fyber.inneractive.sdk.player.exoplayer2.i r2 = com.fyber.inneractive.sdk.player.exoplayer2.i.a(r2, r7, r9, r8, r11)
            r14.b = r2
            goto L_0x02fb
        L_0x023a:
            r11 = r50
            r48 = r8
            goto L_0x02fb
        L_0x0240:
            r11 = r50
            r48 = r8
            int r8 = r10 + 16
            r4.e(r8)
            java.lang.String r8 = "application/ttml+xml"
            r25 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            if (r2 != r7) goto L_0x0259
            r33 = r25
            r35 = 0
            r26 = r8
            goto L_0x029d
        L_0x0259:
            int r7 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.u0
            if (r2 != r7) goto L_0x027b
            int r2 = r5 + -16
            byte[] r7 = new byte[r2]
            byte[] r8 = r4.a
            int r9 = r4.b
            r11 = 0
            java.lang.System.arraycopy(r8, r9, r7, r11, r2)
            int r8 = r4.b
            int r8 = r8 + r2
            r4.b = r8
            java.util.List r2 = java.util.Collections.singletonList(r7)
            java.lang.String r7 = "application/x-quicktime-tx3g"
            r35 = r2
            r33 = r25
            r26 = r7
            goto L_0x029d
        L_0x027b:
            int r7 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.v0
            if (r2 != r7) goto L_0x0288
            java.lang.String r2 = "application/x-mp4-vtt"
        L_0x0281:
            r33 = r25
            r35 = 0
            r26 = r2
            goto L_0x029d
        L_0x0288:
            int r7 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.w0
            if (r2 != r7) goto L_0x0293
            r26 = r8
            r33 = r18
            r35 = 0
            goto L_0x029d
        L_0x0293:
            int r7 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.x0
            if (r2 != r7) goto L_0x02b4
            r2 = 1
            r14.d = r2
            java.lang.String r2 = "application/x-mp4-cea-608"
            goto L_0x0281
        L_0x029d:
            java.lang.String r25 = java.lang.Integer.toString(r13)
            r27 = 0
            r28 = -1
            r29 = 0
            r31 = -1
            r30 = r6
            r32 = r50
            com.fyber.inneractive.sdk.player.exoplayer2.i r2 = com.fyber.inneractive.sdk.player.exoplayer2.i.a(r25, r26, r27, r28, r29, r30, r31, r32, r33, r35)
            r14.b = r2
            goto L_0x02fb
        L_0x02b4:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r0.<init>()
            throw r0
        L_0x02ba:
            r48 = r8
            int r8 = r10 + 16
            r4.e(r8)
            r8 = 6
            if (r51 == 0) goto L_0x02cc
            int r11 = r4.q()
            r4.f(r8)
            goto L_0x02d2
        L_0x02cc:
            r9 = 8
            r4.f(r9)
            r11 = 0
        L_0x02d2:
            if (r11 == 0) goto L_0x0306
            r9 = 1
            if (r11 != r9) goto L_0x02d8
            goto L_0x0306
        L_0x02d8:
            r9 = 2
            if (r11 != r9) goto L_0x02fb
            r9 = 16
            r4.f(r9)
            long r25 = r4.i()
            double r25 = java.lang.Double.longBitsToDouble(r25)
            long r8 = java.lang.Math.round(r25)
            int r9 = (int) r8
            int r8 = r4.o()
            r11 = 20
            r4.f(r11)
            r41 = r1
            r40 = r12
            goto L_0x033c
        L_0x02fb:
            r41 = r1
            r42 = r3
            r7 = r5
            r40 = r12
            r3 = r15
        L_0x0303:
            r2 = 3
            goto L_0x06e9
        L_0x0306:
            int r8 = r4.q()
            r9 = 6
            r4.f(r9)
            byte[] r9 = r4.a
            r25 = r8
            int r8 = r4.b
            r40 = r12
            int r12 = r8 + 1
            r4.b = r12
            r41 = r1
            byte r1 = r9[r8]
            r1 = r1 & 255(0xff, float:3.57E-43)
            r26 = 8
            int r1 = r1 << 8
            int r0 = r8 + 2
            r4.b = r0
            byte r0 = r9[r12]
            r0 = r0 & 255(0xff, float:3.57E-43)
            r9 = r1 | r0
            r0 = 4
            int r8 = r8 + r0
            r4.b = r8
            r0 = 1
            if (r11 != r0) goto L_0x033a
            r0 = 16
            r4.f(r0)
        L_0x033a:
            r8 = r25
        L_0x033c:
            int r0 = r4.b
            int r1 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.b0
            if (r2 != r1) goto L_0x0349
            int r2 = a((com.fyber.inneractive.sdk.player.exoplayer2.util.k) r4, (int) r10, (int) r5, (com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.b.C0121b) r14, (int) r15)
            r4.e(r0)
        L_0x0349:
            int r1 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.o
            java.lang.String r11 = "audio/raw"
            if (r2 != r1) goto L_0x0352
            java.lang.String r1 = "audio/ac3"
            goto L_0x039b
        L_0x0352:
            int r1 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.q
            if (r2 != r1) goto L_0x0359
            java.lang.String r1 = "audio/eac3"
            goto L_0x039b
        L_0x0359:
            int r1 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.s
            if (r2 != r1) goto L_0x0360
            java.lang.String r1 = "audio/vnd.dts"
            goto L_0x039b
        L_0x0360:
            int r1 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.t
            if (r2 == r1) goto L_0x0399
            int r1 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.u
            if (r2 != r1) goto L_0x0369
            goto L_0x0399
        L_0x0369:
            int r1 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.v
            if (r2 != r1) goto L_0x0370
            java.lang.String r1 = "audio/vnd.dts.hd;profile=lbr"
            goto L_0x039b
        L_0x0370:
            int r1 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.y0
            if (r2 != r1) goto L_0x0377
            java.lang.String r1 = "audio/3gpp"
            goto L_0x039b
        L_0x0377:
            int r1 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.z0
            if (r2 != r1) goto L_0x037e
            java.lang.String r1 = "audio/amr-wb"
            goto L_0x039b
        L_0x037e:
            int r1 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.m
            if (r2 == r1) goto L_0x0397
            int r1 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.n
            if (r2 != r1) goto L_0x0387
            goto L_0x0397
        L_0x0387:
            int r1 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.k
            if (r2 != r1) goto L_0x038e
            java.lang.String r1 = "audio/mpeg"
            goto L_0x039b
        L_0x038e:
            int r1 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.O0
            if (r2 != r1) goto L_0x0395
            java.lang.String r1 = "audio/alac"
            goto L_0x039b
        L_0x0395:
            r1 = 0
            goto L_0x039b
        L_0x0397:
            r1 = r11
            goto L_0x039b
        L_0x0399:
            java.lang.String r1 = "audio/vnd.dts.hd"
        L_0x039b:
            r2 = r9
            r9 = 0
            r45 = r8
            r8 = r0
            r0 = r45
        L_0x03a2:
            int r12 = r8 - r10
            if (r12 >= r5) goto L_0x0512
            r4.e(r8)
            int r12 = r4.c()
            r42 = r3
            if (r12 <= 0) goto L_0x03b3
            r3 = 1
            goto L_0x03b4
        L_0x03b3:
            r3 = 0
        L_0x03b4:
            com.fyber.inneractive.sdk.player.exoplayer2.util.a.a(r3, r7)
            int r3 = r4.c()
            r43 = r5
            int r5 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.K
            r44 = r15
            if (r3 == r5) goto L_0x04aa
            if (r51 == 0) goto L_0x03cb
            int r15 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.l
            if (r3 != r15) goto L_0x03cb
            goto L_0x04aa
        L_0x03cb:
            int r5 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.p
            if (r3 != r5) goto L_0x0419
            int r3 = r8 + 8
            r4.e(r3)
            java.lang.String r25 = java.lang.Integer.toString(r13)
            int r3 = r4.l()
            r3 = r3 & 192(0xc0, float:2.69E-43)
            r5 = 6
            int r3 = r3 >> r5
            int[] r5 = com.fyber.inneractive.sdk.player.exoplayer2.audio.a.b
            r31 = r5[r3]
            int r3 = r4.l()
            int[] r5 = com.fyber.inneractive.sdk.player.exoplayer2.audio.a.d
            r15 = r3 & 56
            r16 = 3
            int r15 = r15 >> 3
            r5 = r5[r15]
            r15 = 4
            r3 = r3 & r15
            if (r3 == 0) goto L_0x03f8
            int r5 = r5 + 1
        L_0x03f8:
            r30 = r5
            java.lang.String r26 = "audio/ac3"
            r27 = 0
            r28 = -1
            r29 = -1
            r32 = -1
            r33 = 0
            r35 = 0
            r34 = r50
            r36 = r6
            com.fyber.inneractive.sdk.player.exoplayer2.i r3 = com.fyber.inneractive.sdk.player.exoplayer2.i.a((java.lang.String) r25, (java.lang.String) r26, (java.lang.String) r27, (int) r28, (int) r29, (int) r30, (int) r31, (int) r32, (java.util.List<byte[]>) r33, (com.fyber.inneractive.sdk.player.exoplayer2.drm.a) r34, (int) r35, (java.lang.String) r36)
            r14.b = r3
            r25 = r7
            r5 = -1
            r23 = 6
            goto L_0x0507
        L_0x0419:
            r15 = 4
            int r5 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.r
            if (r3 != r5) goto L_0x0468
            int r3 = r8 + 8
            r4.e(r3)
            java.lang.String r25 = java.lang.Integer.toString(r13)
            r3 = 2
            r4.f(r3)
            int r3 = r4.l()
            r3 = r3 & 192(0xc0, float:2.69E-43)
            r23 = 6
            int r3 = r3 >> 6
            int[] r5 = com.fyber.inneractive.sdk.player.exoplayer2.audio.a.b
            r31 = r5[r3]
            int r3 = r4.l()
            int[] r5 = com.fyber.inneractive.sdk.player.exoplayer2.audio.a.d
            r26 = r3 & 14
            r22 = 1
            int r26 = r26 >> 1
            r5 = r5[r26]
            r3 = r3 & 1
            if (r3 == 0) goto L_0x044d
            int r5 = r5 + 1
        L_0x044d:
            r30 = r5
            java.lang.String r26 = "audio/eac3"
            r27 = 0
            r28 = -1
            r29 = -1
            r32 = -1
            r33 = 0
            r35 = 0
            r34 = r50
            r36 = r6
            com.fyber.inneractive.sdk.player.exoplayer2.i r3 = com.fyber.inneractive.sdk.player.exoplayer2.i.a((java.lang.String) r25, (java.lang.String) r26, (java.lang.String) r27, (int) r28, (int) r29, (int) r30, (int) r31, (int) r32, (java.util.List<byte[]>) r33, (com.fyber.inneractive.sdk.player.exoplayer2.drm.a) r34, (int) r35, (java.lang.String) r36)
            r14.b = r3
            goto L_0x04a6
        L_0x0468:
            r23 = 6
            int r5 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.w
            if (r3 != r5) goto L_0x048f
            java.lang.String r25 = java.lang.Integer.toString(r13)
            r27 = 0
            r28 = -1
            r29 = -1
            r32 = -1
            r33 = 0
            r35 = 0
            r26 = r1
            r30 = r0
            r31 = r2
            r34 = r50
            r36 = r6
            com.fyber.inneractive.sdk.player.exoplayer2.i r3 = com.fyber.inneractive.sdk.player.exoplayer2.i.a((java.lang.String) r25, (java.lang.String) r26, (java.lang.String) r27, (int) r28, (int) r29, (int) r30, (int) r31, (int) r32, (java.util.List<byte[]>) r33, (com.fyber.inneractive.sdk.player.exoplayer2.drm.a) r34, (int) r35, (java.lang.String) r36)
            r14.b = r3
            goto L_0x04a6
        L_0x048f:
            int r5 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.O0
            if (r3 != r5) goto L_0x04a6
            byte[] r3 = new byte[r12]
            r4.e(r8)
            byte[] r5 = r4.a
            int r9 = r4.b
            r15 = 0
            java.lang.System.arraycopy(r5, r9, r3, r15, r12)
            int r5 = r4.b
            int r5 = r5 + r12
            r4.b = r5
            r9 = r3
        L_0x04a6:
            r25 = r7
            r5 = -1
            goto L_0x0507
        L_0x04aa:
            r15 = 0
            r23 = 6
            if (r3 != r5) goto L_0x04b4
            r25 = r7
            r3 = r8
        L_0x04b2:
            r5 = -1
            goto L_0x04db
        L_0x04b4:
            int r3 = r4.b
        L_0x04b6:
            int r5 = r3 - r8
            if (r5 >= r12) goto L_0x04d7
            r4.e(r3)
            int r5 = r4.c()
            if (r5 <= 0) goto L_0x04c4
            r15 = 1
        L_0x04c4:
            com.fyber.inneractive.sdk.player.exoplayer2.util.a.a(r15, r7)
            int r15 = r4.c()
            r25 = r7
            int r7 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.K
            if (r15 != r7) goto L_0x04d2
            goto L_0x04b2
        L_0x04d2:
            int r3 = r3 + r5
            r7 = r25
            r15 = 0
            goto L_0x04b6
        L_0x04d7:
            r25 = r7
            r3 = -1
            goto L_0x04b2
        L_0x04db:
            if (r3 == r5) goto L_0x0507
            android.util.Pair r1 = a(r4, r3)
            java.lang.Object r3 = r1.first
            java.lang.String r3 = (java.lang.String) r3
            java.lang.Object r1 = r1.second
            byte[] r1 = (byte[]) r1
            java.lang.String r7 = "audio/mp4a-latm"
            boolean r7 = r7.equals(r3)
            if (r7 == 0) goto L_0x0505
            android.util.Pair r0 = com.fyber.inneractive.sdk.player.exoplayer2.util.c.a((byte[]) r1)
            java.lang.Object r2 = r0.first
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            java.lang.Object r0 = r0.second
            java.lang.Integer r0 = (java.lang.Integer) r0
            int r0 = r0.intValue()
        L_0x0505:
            r9 = r1
            r1 = r3
        L_0x0507:
            int r8 = r8 + r12
            r7 = r25
            r3 = r42
            r5 = r43
            r15 = r44
            goto L_0x03a2
        L_0x0512:
            r42 = r3
            r43 = r5
            r44 = r15
            r5 = -1
            com.fyber.inneractive.sdk.player.exoplayer2.i r3 = r14.b
            if (r3 != 0) goto L_0x0551
            if (r1 == 0) goto L_0x0551
            boolean r3 = r11.equals(r1)
            if (r3 == 0) goto L_0x0528
            r32 = 2
            goto L_0x052a
        L_0x0528:
            r32 = -1
        L_0x052a:
            java.lang.String r25 = java.lang.Integer.toString(r13)
            r27 = 0
            r28 = -1
            r29 = -1
            if (r9 != 0) goto L_0x0539
            r33 = 0
            goto L_0x053f
        L_0x0539:
            java.util.List r3 = java.util.Collections.singletonList(r9)
            r33 = r3
        L_0x053f:
            r35 = 0
            r26 = r1
            r30 = r0
            r31 = r2
            r34 = r50
            r36 = r6
            com.fyber.inneractive.sdk.player.exoplayer2.i r0 = com.fyber.inneractive.sdk.player.exoplayer2.i.a((java.lang.String) r25, (java.lang.String) r26, (java.lang.String) r27, (int) r28, (int) r29, (int) r30, (int) r31, (int) r32, (java.util.List<byte[]>) r33, (com.fyber.inneractive.sdk.player.exoplayer2.drm.a) r34, (int) r35, (java.lang.String) r36)
            r14.b = r0
        L_0x0551:
            r7 = r43
            r3 = r44
            goto L_0x0303
        L_0x0557:
            r41 = r1
            r42 = r3
            r43 = r5
            r25 = r7
            r48 = r8
            r40 = r12
            r44 = r15
            r5 = -1
            int r0 = r10 + 16
            r4.e(r0)
            r0 = 16
            r4.f(r0)
            int r30 = r4.q()
            int r31 = r4.q()
            r1 = 50
            r4.f(r1)
            int r1 = r4.b
            int r3 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.a0
            r7 = r43
            if (r2 != r3) goto L_0x058f
            r3 = r44
            int r2 = a((com.fyber.inneractive.sdk.player.exoplayer2.util.k) r4, (int) r10, (int) r7, (com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.b.C0121b) r14, (int) r3)
            r4.e(r1)
            goto L_0x0591
        L_0x058f:
            r3 = r44
        L_0x0591:
            r8 = 1065353216(0x3f800000, float:1.0)
            r8 = 0
            r26 = 0
            r33 = 0
            r35 = 1065353216(0x3f800000, float:1.0)
            r36 = 0
            r37 = -1
        L_0x059e:
            int r9 = r1 - r10
            if (r9 >= r7) goto L_0x06cd
            r4.e(r1)
            int r9 = r4.b
            int r11 = r4.c()
            if (r11 != 0) goto L_0x05b4
            int r12 = r4.b
            int r12 = r12 - r10
            if (r12 != r7) goto L_0x05b4
            goto L_0x06cd
        L_0x05b4:
            r15 = r25
            if (r11 <= 0) goto L_0x05ba
            r12 = 1
            goto L_0x05bb
        L_0x05ba:
            r12 = 0
        L_0x05bb:
            com.fyber.inneractive.sdk.player.exoplayer2.util.a.a(r12, r15)
            int r12 = r4.c()
            int r0 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.I
            if (r12 != r0) goto L_0x05e6
            if (r26 != 0) goto L_0x05ca
            r0 = 1
            goto L_0x05cb
        L_0x05ca:
            r0 = 0
        L_0x05cb:
            com.fyber.inneractive.sdk.player.exoplayer2.util.a.b(r0)
            int r9 = r9 + 8
            r4.e(r9)
            com.fyber.inneractive.sdk.player.exoplayer2.video.a r0 = com.fyber.inneractive.sdk.player.exoplayer2.video.a.b(r4)
            java.util.List<byte[]> r9 = r0.a
            int r12 = r0.b
            r14.c = r12
            if (r8 != 0) goto L_0x05e3
            float r0 = r0.e
            r35 = r0
        L_0x05e3:
            java.lang.String r26 = "video/avc"
            goto L_0x0603
        L_0x05e6:
            int r0 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.J
            if (r12 != r0) goto L_0x060a
            if (r26 != 0) goto L_0x05ee
            r0 = 1
            goto L_0x05ef
        L_0x05ee:
            r0 = 0
        L_0x05ef:
            com.fyber.inneractive.sdk.player.exoplayer2.util.a.b(r0)
            int r9 = r9 + 8
            r4.e(r9)
            com.fyber.inneractive.sdk.player.exoplayer2.video.c r0 = com.fyber.inneractive.sdk.player.exoplayer2.video.c.a(r4)
            java.util.List<byte[]> r9 = r0.a
            int r0 = r0.b
            r14.c = r0
            java.lang.String r26 = "video/hevc"
        L_0x0603:
            r23 = r2
            r33 = r9
        L_0x0607:
            r2 = 3
            goto L_0x06c3
        L_0x060a:
            int r0 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.M0
            if (r12 != r0) goto L_0x0620
            if (r26 != 0) goto L_0x0612
            r0 = 1
            goto L_0x0613
        L_0x0612:
            r0 = 0
        L_0x0613:
            com.fyber.inneractive.sdk.player.exoplayer2.util.a.b(r0)
            int r0 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.K0
            if (r2 != r0) goto L_0x061d
            java.lang.String r26 = "video/x-vnd.on2.vp8"
            goto L_0x062e
        L_0x061d:
            java.lang.String r26 = "video/x-vnd.on2.vp9"
            goto L_0x062e
        L_0x0620:
            int r0 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.h
            if (r12 != r0) goto L_0x0631
            if (r26 != 0) goto L_0x0628
            r0 = 1
            goto L_0x0629
        L_0x0628:
            r0 = 0
        L_0x0629:
            com.fyber.inneractive.sdk.player.exoplayer2.util.a.b(r0)
            java.lang.String r26 = "video/3gpp"
        L_0x062e:
            r23 = r2
            goto L_0x0607
        L_0x0631:
            int r0 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.K
            if (r12 != r0) goto L_0x064e
            if (r26 != 0) goto L_0x0639
            r0 = 1
            goto L_0x063a
        L_0x0639:
            r0 = 0
        L_0x063a:
            com.fyber.inneractive.sdk.player.exoplayer2.util.a.b(r0)
            android.util.Pair r0 = a(r4, r9)
            java.lang.Object r9 = r0.first
            r26 = r9
            java.lang.String r26 = (java.lang.String) r26
            java.lang.Object r0 = r0.second
            java.util.List r33 = java.util.Collections.singletonList(r0)
            goto L_0x062e
        L_0x064e:
            int r0 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.j0
            if (r12 != r0) goto L_0x0668
            int r9 = r9 + 8
            r4.e(r9)
            int r0 = r4.o()
            int r8 = r4.o()
            float r0 = (float) r0
            float r8 = (float) r8
            float r35 = r0 / r8
            r23 = r2
            r2 = 3
            r8 = 1
            goto L_0x06c3
        L_0x0668:
            int r0 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.I0
            if (r12 != r0) goto L_0x0699
            int r0 = r9 + 8
        L_0x066e:
            int r12 = r0 - r9
            if (r12 >= r11) goto L_0x0693
            r4.e(r0)
            int r12 = r4.c()
            int r5 = r4.c()
            r23 = r2
            int r2 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.J0
            if (r5 != r2) goto L_0x068e
            byte[] r2 = r4.a
            int r12 = r12 + r0
            byte[] r9 = java.util.Arrays.copyOfRange(r2, r0, r12)
            r36 = r9
            goto L_0x0607
        L_0x068e:
            int r0 = r0 + r12
            r2 = r23
            r5 = -1
            goto L_0x066e
        L_0x0693:
            r23 = r2
            r2 = 3
            r36 = 0
            goto L_0x06c3
        L_0x0699:
            r23 = r2
            int r0 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.H0
            if (r12 != r0) goto L_0x0607
            int r0 = r4.l()
            r2 = 3
            r4.f(r2)
            if (r0 != 0) goto L_0x06c3
            int r0 = r4.l()
            if (r0 == 0) goto L_0x06c1
            r5 = 1
            if (r0 == r5) goto L_0x06be
            r5 = 2
            if (r0 == r5) goto L_0x06bb
            if (r0 == r2) goto L_0x06b8
            goto L_0x06c3
        L_0x06b8:
            r37 = 3
            goto L_0x06c3
        L_0x06bb:
            r37 = 2
            goto L_0x06c3
        L_0x06be:
            r37 = 1
            goto L_0x06c3
        L_0x06c1:
            r37 = 0
        L_0x06c3:
            int r1 = r1 + r11
            r25 = r15
            r2 = r23
            r0 = 16
            r5 = -1
            goto L_0x059e
        L_0x06cd:
            r2 = 3
            if (r26 != 0) goto L_0x06d1
            goto L_0x06e9
        L_0x06d1:
            java.lang.String r25 = java.lang.Integer.toString(r13)
            r27 = 0
            r28 = -1
            r29 = -1
            r32 = -1082130432(0xffffffffbf800000, float:-1.0)
            r38 = 0
            r34 = r42
            r39 = r50
            com.fyber.inneractive.sdk.player.exoplayer2.i r0 = com.fyber.inneractive.sdk.player.exoplayer2.i.a((java.lang.String) r25, (java.lang.String) r26, (java.lang.String) r27, (int) r28, (int) r29, (int) r30, (int) r31, (float) r32, (java.util.List<byte[]>) r33, (int) r34, (float) r35, (byte[]) r36, (int) r37, (com.fyber.inneractive.sdk.player.exoplayer2.video.b) r38, (com.fyber.inneractive.sdk.player.exoplayer2.drm.a) r39)
            r14.b = r0
        L_0x06e9:
            int r10 = r10 + r7
            r4.e(r10)
            int r15 = r3 + 1
            r0 = r46
            r11 = r47
            r8 = r48
            r12 = r40
            r1 = r41
            r3 = r42
            r2 = 0
            r7 = -1
            r10 = 8
            goto L_0x0195
        L_0x0701:
            r41 = r1
            r48 = r8
            r40 = r12
            int r0 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.Q
            r1 = r46
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a$a r0 = r1.c(r0)
            if (r0 == 0) goto L_0x0781
            int r1 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.R
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a$b r0 = r0.d(r1)
            if (r0 != 0) goto L_0x071a
            goto L_0x0781
        L_0x071a:
            com.fyber.inneractive.sdk.player.exoplayer2.util.k r0 = r0.P0
            r1 = 8
            r0.e(r1)
            int r1 = r0.c()
            int r1 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a.b(r1)
            int r2 = r0.o()
            long[] r3 = new long[r2]
            long[] r4 = new long[r2]
            r5 = 0
        L_0x0732:
            if (r5 >= r2) goto L_0x077a
            r6 = 1
            if (r1 != r6) goto L_0x073c
            long r7 = r0.p()
            goto L_0x0740
        L_0x073c:
            long r7 = r0.m()
        L_0x0740:
            r3[r5] = r7
            if (r1 != r6) goto L_0x0749
            long r6 = r0.i()
            goto L_0x074e
        L_0x0749:
            int r6 = r0.c()
            long r6 = (long) r6
        L_0x074e:
            r4[r5] = r6
            byte[] r6 = r0.a
            int r7 = r0.b
            int r8 = r7 + 1
            r0.b = r8
            byte r9 = r6[r7]
            r9 = r9 & 255(0xff, float:3.57E-43)
            r10 = 8
            int r9 = r9 << r10
            r11 = 2
            int r7 = r7 + r11
            r0.b = r7
            byte r6 = r6[r8]
            r6 = r6 & 255(0xff, float:3.57E-43)
            r6 = r6 | r9
            short r6 = (short) r6
            r7 = 1
            if (r6 != r7) goto L_0x0772
            r0.f(r11)
            int r5 = r5 + 1
            goto L_0x0732
        L_0x0772:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Unsupported media rate."
            r0.<init>(r1)
            throw r0
        L_0x077a:
            android.util.Pair r0 = android.util.Pair.create(r3, r4)
            r1 = r0
            r0 = 0
            goto L_0x0786
        L_0x0781:
            r0 = 0
            android.util.Pair r1 = android.util.Pair.create(r0, r0)
        L_0x0786:
            com.fyber.inneractive.sdk.player.exoplayer2.i r2 = r14.b
            if (r2 != 0) goto L_0x078c
            r2 = r0
            goto L_0x07c0
        L_0x078c:
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.h r2 = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.h
            r0 = r41
            java.lang.Object r0 = r0.first
            java.lang.Long r0 = (java.lang.Long) r0
            long r3 = r0.longValue()
            com.fyber.inneractive.sdk.player.exoplayer2.i r0 = r14.b
            int r5 = r14.d
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.i[] r6 = r14.a
            int r7 = r14.c
            java.lang.Object r8 = r1.first
            r23 = r8
            long[] r23 = (long[]) r23
            java.lang.Object r1 = r1.second
            r24 = r1
            long[] r24 = (long[]) r24
            r10 = r2
            r11 = r13
            r12 = r40
            r13 = r3
            r15 = r48
            r17 = r20
            r19 = r0
            r20 = r5
            r21 = r6
            r22 = r7
            r10.<init>(r11, r12, r13, r15, r17, r19, r20, r21, r22, r23, r24)
        L_0x07c0:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.b.a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a$a, com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.a$b, long, com.fyber.inneractive.sdk.player.exoplayer2.drm.a, boolean):com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.h");
    }

    public static int a(k kVar, int i, int i2, C0121b bVar, int i3) {
        k kVar2 = kVar;
        int i4 = kVar2.b;
        while (true) {
            boolean z = false;
            if (i4 - i >= i2) {
                return 0;
            }
            kVar2.e(i4);
            int c2 = kVar.c();
            int i5 = 1;
            com.fyber.inneractive.sdk.player.exoplayer2.util.a.a(c2 > 0, "childAtomSize should be positive");
            if (kVar.c() == a.W) {
                int i6 = i4 + 8;
                Pair pair = null;
                Integer num = null;
                i iVar = null;
                boolean z2 = false;
                while (i6 - i4 < c2) {
                    kVar2.e(i6);
                    int c3 = kVar.c();
                    int c4 = kVar.c();
                    if (c4 == a.c0) {
                        num = Integer.valueOf(kVar.c());
                    } else if (c4 == a.X) {
                        kVar2.f(4);
                        z2 = kVar.c() == g;
                    } else if (c4 == a.Y) {
                        int i7 = i6 + 8;
                        while (true) {
                            if (i7 - i6 >= c3) {
                                iVar = null;
                                break;
                            }
                            kVar2.e(i7);
                            int c5 = kVar.c();
                            if (kVar.c() == a.Z) {
                                kVar2.f(6);
                                boolean z3 = kVar.l() == i5;
                                int l = kVar.l();
                                byte[] bArr = new byte[16];
                                System.arraycopy(kVar2.a, kVar2.b, bArr, 0, 16);
                                kVar2.b += 16;
                                iVar = new i(z3, l, bArr);
                            } else {
                                i7 += c5;
                                i5 = 1;
                            }
                        }
                    }
                    i6 += c3;
                    i5 = 1;
                }
                if (z2) {
                    com.fyber.inneractive.sdk.player.exoplayer2.util.a.a(num != null, "frma atom is mandatory");
                    if (iVar != null) {
                        z = true;
                    }
                    com.fyber.inneractive.sdk.player.exoplayer2.util.a.a(z, "schi->tenc atom is mandatory");
                    pair = Pair.create(num, iVar);
                }
                if (pair != null) {
                    bVar.a[i3] = (i) pair.second;
                    return ((Integer) pair.first).intValue();
                }
            }
            C0121b bVar2 = bVar;
            i4 += c2;
        }
    }

    public static Pair<String, byte[]> a(k kVar, int i) {
        String str;
        kVar.e(i + 12);
        kVar.f(1);
        a(kVar);
        kVar.f(2);
        int l = kVar.l();
        if ((l & 128) != 0) {
            kVar.f(2);
        }
        if ((l & 64) != 0) {
            kVar.f(kVar.q());
        }
        if ((l & 32) != 0) {
            kVar.f(2);
        }
        kVar.f(1);
        a(kVar);
        int l2 = kVar.l();
        if (l2 == 32) {
            str = "video/mp4v-es";
        } else if (l2 == 33) {
            str = MimeTypes.VIDEO_H264;
        } else if (l2 != 35) {
            if (l2 != 64) {
                str = null;
                if (l2 == 107) {
                    return Pair.create("audio/mpeg", (Object) null);
                }
                if (l2 == 165) {
                    str = "audio/ac3";
                } else if (l2 != 166) {
                    switch (l2) {
                        case 102:
                        case 103:
                        case 104:
                            break;
                        default:
                            switch (l2) {
                                case 169:
                                case 172:
                                    return Pair.create("audio/vnd.dts", (Object) null);
                                case 170:
                                case 171:
                                    return Pair.create("audio/vnd.dts.hd", (Object) null);
                            }
                    }
                } else {
                    str = "audio/eac3";
                }
            }
            str = "audio/mp4a-latm";
        } else {
            str = MimeTypes.VIDEO_H265;
        }
        kVar.f(12);
        kVar.f(1);
        int a2 = a(kVar);
        byte[] bArr = new byte[a2];
        System.arraycopy(kVar.a, kVar.b, bArr, 0, a2);
        kVar.b += a2;
        return Pair.create(str, bArr);
    }

    public static int a(k kVar) {
        int l = kVar.l();
        int i = l & WorkQueueKt.MASK;
        while ((l & 128) == 128) {
            l = kVar.l();
            i = (i << 7) | (l & WorkQueueKt.MASK);
        }
        return i;
    }
}
