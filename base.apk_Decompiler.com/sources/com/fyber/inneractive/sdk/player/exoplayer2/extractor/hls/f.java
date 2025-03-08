package com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls;

import com.fyber.inneractive.sdk.player.exoplayer2.extractor.b;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.h;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.a;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.c;
import com.fyber.inneractive.sdk.player.exoplayer2.i;
import com.fyber.inneractive.sdk.player.exoplayer2.metadata.a;
import com.fyber.inneractive.sdk.player.exoplayer2.source.chunk.d;
import com.fyber.inneractive.sdk.player.exoplayer2.upstream.g;
import com.fyber.inneractive.sdk.player.exoplayer2.upstream.j;
import com.fyber.inneractive.sdk.player.exoplayer2.util.k;
import com.fyber.inneractive.sdk.player.exoplayer2.util.r;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public final class f extends d {
    public static final AtomicInteger G = new AtomicInteger();
    public int A;
    public int B;
    public boolean C;
    public j D;
    public volatile boolean E;
    public volatile boolean F;
    public final int j;
    public final int k;
    public final a.C0117a l;
    public final g m;
    public final j n;
    public final boolean o = (this.h instanceof a);
    public final boolean p;
    public final r q;
    public final String r;
    public final com.fyber.inneractive.sdk.player.exoplayer2.extractor.f s;
    public final boolean t;
    public final boolean u;
    public final List<i> v;
    public final boolean w;
    public final com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.g x;
    public final k y;
    public com.fyber.inneractive.sdk.player.exoplayer2.extractor.f z;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public f(com.fyber.inneractive.sdk.player.exoplayer2.upstream.g r17, com.fyber.inneractive.sdk.player.exoplayer2.upstream.j r18, com.fyber.inneractive.sdk.player.exoplayer2.upstream.j r19, com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.a.C0117a r20, java.util.List<com.fyber.inneractive.sdk.player.exoplayer2.i> r21, int r22, java.lang.Object r23, long r24, long r26, int r28, int r29, boolean r30, com.fyber.inneractive.sdk.player.exoplayer2.util.r r31, com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.f r32, byte[] r33, byte[] r34) {
        /*
            r16 = this;
            r11 = r16
            r12 = r17
            r13 = r20
            r14 = r29
            r15 = r32
            r0 = r33
            r1 = r34
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.g r1 = a(r12, r0, r1)
            com.fyber.inneractive.sdk.player.exoplayer2.i r3 = r13.b
            r0 = r16
            r2 = r18
            r4 = r22
            r5 = r23
            r6 = r24
            r8 = r26
            r10 = r28
            r0.<init>(r1, r2, r3, r4, r5, r6, r8, r10)
            r11.k = r14
            r0 = r19
            r11.n = r0
            r11.l = r13
            r0 = r21
            r11.v = r0
            r0 = r30
            r11.p = r0
            r0 = r31
            r11.q = r0
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.g r0 = r11.h
            boolean r0 = r0 instanceof com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.a
            r11.o = r0
            r0 = r18
            android.net.Uri r0 = r0.a
            java.lang.String r0 = r0.getLastPathSegment()
            r11.r = r0
            java.lang.String r1 = ".aac"
            boolean r1 = r0.endsWith(r1)
            r2 = 0
            r3 = 1
            if (r1 != 0) goto L_0x006e
            java.lang.String r1 = ".ac3"
            boolean r1 = r0.endsWith(r1)
            if (r1 != 0) goto L_0x006e
            java.lang.String r1 = ".ec3"
            boolean r1 = r0.endsWith(r1)
            if (r1 != 0) goto L_0x006e
            java.lang.String r1 = ".mp3"
            boolean r0 = r0.endsWith(r1)
            if (r0 == 0) goto L_0x006c
            goto L_0x006e
        L_0x006c:
            r0 = 0
            goto L_0x006f
        L_0x006e:
            r0 = 1
        L_0x006f:
            r11.w = r0
            if (r15 == 0) goto L_0x0092
            com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.g r0 = r15.x
            r11.x = r0
            com.fyber.inneractive.sdk.player.exoplayer2.util.k r0 = r15.y
            r11.y = r0
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.f r0 = r15.z
            r11.s = r0
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.a$a r0 = r15.l
            if (r0 == r13) goto L_0x0085
            r0 = 1
            goto L_0x0086
        L_0x0085:
            r0 = 0
        L_0x0086:
            r11.t = r0
            int r1 = r15.k
            if (r1 != r14) goto L_0x008e
            if (r0 == 0) goto L_0x008f
        L_0x008e:
            r2 = 1
        L_0x008f:
            r11.u = r2
            goto L_0x00b1
        L_0x0092:
            r1 = 0
            if (r0 == 0) goto L_0x009b
            com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.g r4 = new com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.g
            r4.<init>()
            goto L_0x009c
        L_0x009b:
            r4 = r1
        L_0x009c:
            r11.x = r4
            if (r0 == 0) goto L_0x00a8
            com.fyber.inneractive.sdk.player.exoplayer2.util.k r0 = new com.fyber.inneractive.sdk.player.exoplayer2.util.k
            r4 = 10
            r0.<init>((int) r4)
            goto L_0x00a9
        L_0x00a8:
            r0 = r1
        L_0x00a9:
            r11.y = r0
            r11.s = r1
            r11.t = r2
            r11.u = r3
        L_0x00b1:
            r11.m = r12
            java.util.concurrent.atomic.AtomicInteger r0 = G
            int r0 = r0.getAndIncrement()
            r11.j = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.f.<init>(com.fyber.inneractive.sdk.player.exoplayer2.upstream.g, com.fyber.inneractive.sdk.player.exoplayer2.upstream.j, com.fyber.inneractive.sdk.player.exoplayer2.upstream.j, com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.a$a, java.util.List, int, java.lang.Object, long, long, int, int, boolean, com.fyber.inneractive.sdk.player.exoplayer2.util.r, com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.f, byte[], byte[]):void");
    }

    public boolean a() {
        return this.E;
    }

    public void b() {
        this.E = true;
    }

    public long c() {
        return (long) this.B;
    }

    public final long a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.g gVar) throws IOException, InterruptedException {
        com.fyber.inneractive.sdk.player.exoplayer2.metadata.a a;
        b bVar = (b) gVar;
        bVar.e = 0;
        if (!bVar.a(this.y.a, 0, 10, true)) {
            return -9223372036854775807L;
        }
        this.y.c(10);
        if (this.y.n() != com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.g.b) {
            return -9223372036854775807L;
        }
        this.y.f(3);
        int k2 = this.y.k();
        int i = k2 + 10;
        if (i > this.y.b()) {
            k kVar = this.y;
            byte[] bArr = kVar.a;
            kVar.c(i);
            System.arraycopy(bArr, 0, this.y.a, 0, 10);
        }
        if (!bVar.a(this.y.a, 10, k2, true) || (a = this.x.a(this.y.a, k2)) == null) {
            return -9223372036854775807L;
        }
        for (a.b bVar2 : a.a) {
            if (bVar2 instanceof com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.i) {
                com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.i iVar = (com.fyber.inneractive.sdk.player.exoplayer2.metadata.id3.i) bVar2;
                if ("com.apple.streaming.transportStreamTimestamp".equals(iVar.b)) {
                    System.arraycopy(iVar.c, 0, this.y.a, 0, 8);
                    this.y.c(8);
                    return this.y.i();
                }
            }
        }
        return -9223372036854775807L;
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:0x0174  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x01a7 A[Catch:{ all -> 0x01e4, all -> 0x01f0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x01c0 A[Catch:{ all -> 0x01e4, all -> 0x01f0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0162  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void load() throws java.io.IOException, java.lang.InterruptedException {
        /*
            r14 = this;
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.f r0 = r14.z
            r1 = 0
            r2 = 0
            r3 = 1
            if (r0 != 0) goto L_0x00eb
            boolean r0 = r14.w
            if (r0 != 0) goto L_0x00eb
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.a$a r0 = r14.l
            com.fyber.inneractive.sdk.player.exoplayer2.i r0 = r0.b
            java.lang.String r0 = r0.f
            java.lang.String r4 = "text/vtt"
            boolean r0 = r4.equals(r0)
            if (r0 != 0) goto L_0x00d6
            java.lang.String r0 = r14.r
            java.lang.String r4 = ".webvtt"
            boolean r0 = r0.endsWith(r4)
            if (r0 != 0) goto L_0x00d6
            java.lang.String r0 = r14.r
            java.lang.String r4 = ".vtt"
            boolean r0 = r0.endsWith(r4)
            if (r0 == 0) goto L_0x002f
            goto L_0x00d6
        L_0x002f:
            boolean r0 = r14.u
            if (r0 != 0) goto L_0x0038
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.f r0 = r14.s
            r4 = 0
            goto L_0x00e2
        L_0x0038:
            java.lang.String r0 = r14.r
            java.lang.String r4 = ".mp4"
            boolean r0 = r0.endsWith(r4)
            if (r0 != 0) goto L_0x00ce
            java.lang.String r0 = r14.r
            int r4 = r0.length()
            int r4 = r4 + -4
            java.lang.String r5 = ".m4"
            boolean r0 = r0.startsWith(r5, r4)
            if (r0 == 0) goto L_0x0054
            goto L_0x00ce
        L_0x0054:
            java.util.List<com.fyber.inneractive.sdk.player.exoplayer2.i> r0 = r14.v
            if (r0 == 0) goto L_0x005b
            r4 = 48
            goto L_0x0061
        L_0x005b:
            java.util.List r0 = java.util.Collections.emptyList()
            r4 = 16
        L_0x0061:
            com.fyber.inneractive.sdk.player.exoplayer2.i r5 = r14.c
            java.lang.String r5 = r5.c
            boolean r6 = android.text.TextUtils.isEmpty(r5)
            if (r6 != 0) goto L_0x00bf
            java.lang.String r6 = "audio/mp4a-latm"
            if (r5 != 0) goto L_0x0070
            goto L_0x008c
        L_0x0070:
            java.lang.String r7 = ","
            java.lang.String[] r7 = r5.split(r7)
            int r8 = r7.length
            r9 = 0
        L_0x0078:
            if (r9 >= r8) goto L_0x008c
            r10 = r7[r9]
            java.lang.String r10 = com.fyber.inneractive.sdk.player.exoplayer2.util.h.a(r10)
            if (r10 == 0) goto L_0x0089
            boolean r11 = com.fyber.inneractive.sdk.player.exoplayer2.util.h.d(r10)
            if (r11 == 0) goto L_0x0089
            goto L_0x008d
        L_0x0089:
            int r9 = r9 + 1
            goto L_0x0078
        L_0x008c:
            r10 = r1
        L_0x008d:
            boolean r6 = r6.equals(r10)
            if (r6 != 0) goto L_0x0095
            r4 = r4 | 2
        L_0x0095:
            java.lang.String r6 = "video/avc"
            if (r5 != 0) goto L_0x009a
            goto L_0x00b6
        L_0x009a:
            java.lang.String r7 = ","
            java.lang.String[] r5 = r5.split(r7)
            int r7 = r5.length
            r8 = 0
        L_0x00a2:
            if (r8 >= r7) goto L_0x00b6
            r9 = r5[r8]
            java.lang.String r9 = com.fyber.inneractive.sdk.player.exoplayer2.util.h.a(r9)
            if (r9 == 0) goto L_0x00b3
            boolean r10 = com.fyber.inneractive.sdk.player.exoplayer2.util.h.e(r9)
            if (r10 == 0) goto L_0x00b3
            goto L_0x00b7
        L_0x00b3:
            int r8 = r8 + 1
            goto L_0x00a2
        L_0x00b6:
            r9 = r1
        L_0x00b7:
            boolean r5 = r6.equals(r9)
            if (r5 != 0) goto L_0x00bf
            r4 = r4 | 4
        L_0x00bf:
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.u r5 = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.u
            com.fyber.inneractive.sdk.player.exoplayer2.util.r r6 = r14.q
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.e r7 = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.e
            r7.<init>(r4, r0)
            r0 = 2
            r5.<init>(r0, r6, r7)
            r0 = r5
            goto L_0x00e1
        L_0x00ce:
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.d r0 = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp4.d
            com.fyber.inneractive.sdk.player.exoplayer2.util.r r4 = r14.q
            r0.<init>(r2, r4, r1)
            goto L_0x00e1
        L_0x00d6:
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.l r0 = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.l
            com.fyber.inneractive.sdk.player.exoplayer2.i r4 = r14.c
            java.lang.String r4 = r4.y
            com.fyber.inneractive.sdk.player.exoplayer2.util.r r5 = r14.q
            r0.<init>(r4, r5)
        L_0x00e1:
            r4 = 1
        L_0x00e2:
            if (r4 == 0) goto L_0x00e9
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.j r4 = r14.D
            r0.a((com.fyber.inneractive.sdk.player.exoplayer2.extractor.h) r4)
        L_0x00e9:
            r14.z = r0
        L_0x00eb:
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.f r0 = r14.s
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.f r4 = r14.z
            if (r0 == r4) goto L_0x0140
            boolean r0 = r14.C
            if (r0 != 0) goto L_0x0140
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.j r0 = r14.n
            if (r0 != 0) goto L_0x00fa
            goto L_0x0140
        L_0x00fa:
            int r4 = r14.A
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.j r0 = com.fyber.inneractive.sdk.player.exoplayer2.util.u.a((com.fyber.inneractive.sdk.player.exoplayer2.upstream.j) r0, (int) r4)
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.b r10 = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.b     // Catch:{ all -> 0x0139 }
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.g r5 = r14.m     // Catch:{ all -> 0x0139 }
            long r6 = r0.c     // Catch:{ all -> 0x0139 }
            long r8 = r5.a(r0)     // Catch:{ all -> 0x0139 }
            r4 = r10
            r4.<init>(r5, r6, r8)     // Catch:{ all -> 0x0139 }
        L_0x010e:
            boolean r0 = r14.E     // Catch:{ all -> 0x012d }
            if (r0 != 0) goto L_0x011b
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.f r0 = r14.z     // Catch:{ all -> 0x012d }
            int r0 = r0.a((com.fyber.inneractive.sdk.player.exoplayer2.extractor.g) r10, (com.fyber.inneractive.sdk.player.exoplayer2.extractor.l) r1)     // Catch:{ all -> 0x012d }
            if (r0 != 0) goto L_0x011b
            goto L_0x010e
        L_0x011b:
            long r4 = r10.c     // Catch:{ all -> 0x0139 }
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.j r0 = r14.n     // Catch:{ all -> 0x0139 }
            long r6 = r0.c     // Catch:{ all -> 0x0139 }
            long r4 = r4 - r6
            int r0 = (int) r4     // Catch:{ all -> 0x0139 }
            r14.A = r0     // Catch:{ all -> 0x0139 }
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.g r0 = r14.h
            com.fyber.inneractive.sdk.player.exoplayer2.util.u.a((com.fyber.inneractive.sdk.player.exoplayer2.upstream.g) r0)
            r14.C = r3
            goto L_0x0140
        L_0x012d:
            r0 = move-exception
            long r1 = r10.c     // Catch:{ all -> 0x0139 }
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.j r3 = r14.n     // Catch:{ all -> 0x0139 }
            long r3 = r3.c     // Catch:{ all -> 0x0139 }
            long r1 = r1 - r3
            int r2 = (int) r1     // Catch:{ all -> 0x0139 }
            r14.A = r2     // Catch:{ all -> 0x0139 }
            throw r0     // Catch:{ all -> 0x0139 }
        L_0x0139:
            r0 = move-exception
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.g r1 = r14.h
            com.fyber.inneractive.sdk.player.exoplayer2.util.u.a((com.fyber.inneractive.sdk.player.exoplayer2.upstream.g) r1)
            throw r0
        L_0x0140:
            boolean r0 = r14.E
            if (r0 != 0) goto L_0x01f7
            boolean r0 = r14.o
            if (r0 == 0) goto L_0x0150
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.j r0 = r14.a
            int r4 = r14.B
            if (r4 == 0) goto L_0x0158
            r4 = 1
            goto L_0x0159
        L_0x0150:
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.j r0 = r14.a
            int r4 = r14.B
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.j r0 = com.fyber.inneractive.sdk.player.exoplayer2.util.u.a((com.fyber.inneractive.sdk.player.exoplayer2.upstream.j) r0, (int) r4)
        L_0x0158:
            r4 = 0
        L_0x0159:
            boolean r5 = r14.p
            r6 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r5 != 0) goto L_0x0174
            com.fyber.inneractive.sdk.player.exoplayer2.util.r r2 = r14.q
            monitor-enter(r2)
        L_0x0165:
            long r8 = r2.c     // Catch:{ all -> 0x0171 }
            int r5 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r5 != 0) goto L_0x016f
            r2.wait()     // Catch:{ all -> 0x0171 }
            goto L_0x0165
        L_0x016f:
            monitor-exit(r2)
            goto L_0x0195
        L_0x0171:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        L_0x0174:
            com.fyber.inneractive.sdk.player.exoplayer2.util.r r5 = r14.q
            long r8 = r5.a
            r10 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            int r12 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r12 != 0) goto L_0x0195
            long r8 = r14.f
            monitor-enter(r5)
            long r10 = r5.c     // Catch:{ all -> 0x0192 }
            int r12 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            if (r12 != 0) goto L_0x018b
            r2 = 1
        L_0x018b:
            com.fyber.inneractive.sdk.player.exoplayer2.util.a.b(r2)     // Catch:{ all -> 0x0192 }
            r5.a = r8     // Catch:{ all -> 0x0192 }
            monitor-exit(r5)
            goto L_0x0195
        L_0x0192:
            r0 = move-exception
            monitor-exit(r5)
            throw r0
        L_0x0195:
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.b r2 = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.b     // Catch:{ all -> 0x01f0 }
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.g r9 = r14.h     // Catch:{ all -> 0x01f0 }
            long r10 = r0.c     // Catch:{ all -> 0x01f0 }
            long r12 = r9.a(r0)     // Catch:{ all -> 0x01f0 }
            r8 = r2
            r8.<init>(r9, r10, r12)     // Catch:{ all -> 0x01f0 }
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.f r0 = r14.z     // Catch:{ all -> 0x01f0 }
            if (r0 != 0) goto L_0x01be
            long r8 = r14.a((com.fyber.inneractive.sdk.player.exoplayer2.extractor.g) r2)     // Catch:{ all -> 0x01f0 }
            int r0 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r0 == 0) goto L_0x01b6
            com.fyber.inneractive.sdk.player.exoplayer2.util.r r0 = r14.q     // Catch:{ all -> 0x01f0 }
            long r5 = r0.b(r8)     // Catch:{ all -> 0x01f0 }
            goto L_0x01b8
        L_0x01b6:
            long r5 = r14.f     // Catch:{ all -> 0x01f0 }
        L_0x01b8:
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.f r0 = r14.a((long) r5)     // Catch:{ all -> 0x01f0 }
            r14.z = r0     // Catch:{ all -> 0x01f0 }
        L_0x01be:
            if (r4 == 0) goto L_0x01c5
            int r0 = r14.B     // Catch:{ all -> 0x01f0 }
            r2.c(r0)     // Catch:{ all -> 0x01f0 }
        L_0x01c5:
            boolean r0 = r14.E     // Catch:{ all -> 0x01e4 }
            if (r0 != 0) goto L_0x01d2
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.f r0 = r14.z     // Catch:{ all -> 0x01e4 }
            int r0 = r0.a((com.fyber.inneractive.sdk.player.exoplayer2.extractor.g) r2, (com.fyber.inneractive.sdk.player.exoplayer2.extractor.l) r1)     // Catch:{ all -> 0x01e4 }
            if (r0 != 0) goto L_0x01d2
            goto L_0x01c5
        L_0x01d2:
            long r0 = r2.c     // Catch:{ all -> 0x01f0 }
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.j r2 = r14.a     // Catch:{ all -> 0x01f0 }
            long r4 = r2.c     // Catch:{ all -> 0x01f0 }
            long r0 = r0 - r4
            int r1 = (int) r0     // Catch:{ all -> 0x01f0 }
            r14.B = r1     // Catch:{ all -> 0x01f0 }
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.g r0 = r14.h
            com.fyber.inneractive.sdk.player.exoplayer2.util.u.a((com.fyber.inneractive.sdk.player.exoplayer2.upstream.g) r0)
            r14.F = r3
            goto L_0x01f7
        L_0x01e4:
            r0 = move-exception
            long r1 = r2.c     // Catch:{ all -> 0x01f0 }
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.j r3 = r14.a     // Catch:{ all -> 0x01f0 }
            long r3 = r3.c     // Catch:{ all -> 0x01f0 }
            long r1 = r1 - r3
            int r2 = (int) r1     // Catch:{ all -> 0x01f0 }
            r14.B = r2     // Catch:{ all -> 0x01f0 }
            throw r0     // Catch:{ all -> 0x01f0 }
        L_0x01f0:
            r0 = move-exception
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.g r1 = r14.h
            com.fyber.inneractive.sdk.player.exoplayer2.util.u.a((com.fyber.inneractive.sdk.player.exoplayer2.upstream.g) r1)
            throw r0
        L_0x01f7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.f.load():void");
    }

    public static g a(g gVar, byte[] bArr, byte[] bArr2) {
        return (bArr == null || bArr2 == null) ? gVar : new a(gVar, bArr, bArr2);
    }

    public final com.fyber.inneractive.sdk.player.exoplayer2.extractor.f a(long j2) {
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.f fVar;
        if (this.r.endsWith(".aac")) {
            fVar = new c(j2);
        } else if (this.r.endsWith(".ac3") || this.r.endsWith(".ec3")) {
            fVar = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.ts.a(j2);
        } else if (this.r.endsWith(".mp3")) {
            fVar = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp3.b(0, j2);
        } else {
            throw new IllegalArgumentException("Unkown extension for audio file: " + this.r);
        }
        fVar.a((h) this.D);
        return fVar;
    }
}
