package com.fyber.inneractive.sdk.player.exoplayer2.extractor;

import com.fyber.inneractive.sdk.player.exoplayer2.i;
import com.fyber.inneractive.sdk.player.exoplayer2.util.k;
import com.fyber.inneractive.sdk.player.exoplayer2.util.u;
import java.io.EOFException;
import java.io.IOException;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;

public final class d implements n {
    public final com.fyber.inneractive.sdk.player.exoplayer2.upstream.b a;
    public final int b;
    public final c c = new c();
    public final LinkedBlockingDeque<com.fyber.inneractive.sdk.player.exoplayer2.upstream.a> d = new LinkedBlockingDeque<>();
    public final b e = new b();
    public final k f = new k(32);
    public final AtomicInteger g = new AtomicInteger();
    public long h;
    public i i;
    public long j;
    public com.fyber.inneractive.sdk.player.exoplayer2.upstream.a k;
    public int l;
    public boolean m;
    public C0115d n;

    public static final class b {
        public int a;
        public long b;
        public long c;
        public byte[] d;

        public b() {
        }
    }

    /* renamed from: com.fyber.inneractive.sdk.player.exoplayer2.extractor.d$d  reason: collision with other inner class name */
    public interface C0115d {
        void a(i iVar);
    }

    public d(com.fyber.inneractive.sdk.player.exoplayer2.upstream.b bVar) {
        this.a = bVar;
        int a2 = ((com.fyber.inneractive.sdk.player.exoplayer2.upstream.k) bVar).a();
        this.b = a2;
        this.l = a2;
    }

    public void a(boolean z) {
        int andSet = this.g.getAndSet(z ? 0 : 2);
        a();
        c cVar = this.c;
        cVar.m = Long.MIN_VALUE;
        cVar.n = Long.MIN_VALUE;
        if (andSet == 2) {
            this.i = null;
        }
    }

    public void b() {
        if (this.g.getAndSet(2) == 0) {
            a();
        }
    }

    public final void c() {
        if (!this.g.compareAndSet(1, 0)) {
            a();
        }
    }

    public long d() {
        long max;
        c cVar = this.c;
        synchronized (cVar) {
            max = Math.max(cVar.m, cVar.n);
        }
        return max;
    }

    public i e() {
        i iVar;
        c cVar = this.c;
        synchronized (cVar) {
            iVar = cVar.p ? null : cVar.q;
        }
        return iVar;
    }

    public boolean f() {
        boolean z;
        c cVar = this.c;
        synchronized (cVar) {
            z = cVar.i == 0;
        }
        return z;
    }

    public void g() {
        long j2;
        c cVar = this.c;
        synchronized (cVar) {
            int i2 = cVar.i;
            if (i2 == 0) {
                j2 = -1;
            } else {
                int i3 = cVar.k + i2;
                int i4 = cVar.a;
                int i5 = (i3 - 1) % i4;
                cVar.k = i3 % i4;
                cVar.j += i2;
                cVar.i = 0;
                j2 = cVar.c[i5] + ((long) cVar.d[i5]);
            }
        }
        if (j2 != -1) {
            a(j2);
        }
    }

    public final boolean h() {
        return this.g.compareAndSet(0, 1);
    }

    public boolean a(long j2, boolean z) {
        long j3;
        c cVar = this.c;
        synchronized (cVar) {
            if (cVar.i != 0) {
                long[] jArr = cVar.f;
                int i2 = cVar.k;
                if (j2 >= jArr[i2]) {
                    if (j2 <= cVar.n || z) {
                        int i3 = -1;
                        int i4 = 0;
                        while (true) {
                            if (i2 == cVar.l) {
                                break;
                            } else if (cVar.f[i2] > j2) {
                                break;
                            } else {
                                if ((cVar.e[i2] & 1) != 0) {
                                    i3 = i4;
                                }
                                i2 = (i2 + 1) % cVar.a;
                                i4++;
                            }
                        }
                        if (i3 != -1) {
                            int i5 = (cVar.k + i3) % cVar.a;
                            cVar.k = i5;
                            cVar.j += i3;
                            cVar.i -= i3;
                            j3 = cVar.c[i5];
                        }
                    }
                }
            }
            j3 = -1;
        }
        if (j3 == -1) {
            return false;
        }
        a(j3);
        return true;
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:32:0x008b=Splitter:B:32:0x008b, B:22:0x003c=Splitter:B:22:0x003c} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int a(com.fyber.inneractive.sdk.player.exoplayer2.j r17, com.fyber.inneractive.sdk.player.exoplayer2.decoder.b r18, boolean r19, boolean r20, long r21) {
        /*
            r16 = this;
            r1 = r16
            r0 = r17
            r2 = r18
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.d$c r3 = r1.c
            com.fyber.inneractive.sdk.player.exoplayer2.i r4 = r1.i
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.d$b r5 = r1.e
            monitor-enter(r3)
            int r6 = r3.i     // Catch:{ all -> 0x020d }
            r7 = 4
            r8 = -5
            r11 = 1
            r12 = 0
            if (r6 != 0) goto L_0x0026
            if (r20 == 0) goto L_0x001b
            r2.a = r7     // Catch:{ all -> 0x020d }
            goto L_0x0088
        L_0x001b:
            com.fyber.inneractive.sdk.player.exoplayer2.i r5 = r3.q     // Catch:{ all -> 0x020d }
            if (r5 == 0) goto L_0x0039
            if (r19 != 0) goto L_0x0023
            if (r5 == r4) goto L_0x0039
        L_0x0023:
            r0.a = r5     // Catch:{ all -> 0x020d }
            goto L_0x0093
        L_0x0026:
            if (r19 != 0) goto L_0x008b
            com.fyber.inneractive.sdk.player.exoplayer2.i[] r6 = r3.h     // Catch:{ all -> 0x020d }
            int r13 = r3.k     // Catch:{ all -> 0x020d }
            r6 = r6[r13]     // Catch:{ all -> 0x020d }
            if (r6 == r4) goto L_0x0031
            goto L_0x008b
        L_0x0031:
            java.nio.ByteBuffer r4 = r2.c     // Catch:{ all -> 0x020d }
            if (r4 != 0) goto L_0x003c
            int r4 = r2.e     // Catch:{ all -> 0x020d }
            if (r4 != 0) goto L_0x003c
        L_0x0039:
            monitor-exit(r3)
            r10 = -3
            goto L_0x0095
        L_0x003c:
            long[] r4 = r3.f     // Catch:{ all -> 0x020d }
            r14 = r4[r13]     // Catch:{ all -> 0x020d }
            r2.d = r14     // Catch:{ all -> 0x020d }
            int[] r4 = r3.e     // Catch:{ all -> 0x020d }
            r4 = r4[r13]     // Catch:{ all -> 0x020d }
            r2.a = r4     // Catch:{ all -> 0x020d }
            int[] r4 = r3.d     // Catch:{ all -> 0x020d }
            r4 = r4[r13]     // Catch:{ all -> 0x020d }
            r5.a = r4     // Catch:{ all -> 0x020d }
            long[] r4 = r3.c     // Catch:{ all -> 0x020d }
            r9 = r4[r13]     // Catch:{ all -> 0x020d }
            r5.b = r9     // Catch:{ all -> 0x020d }
            byte[][] r4 = r3.g     // Catch:{ all -> 0x020d }
            r4 = r4[r13]     // Catch:{ all -> 0x020d }
            r5.d = r4     // Catch:{ all -> 0x020d }
            long r9 = r3.m     // Catch:{ all -> 0x020d }
            long r9 = java.lang.Math.max(r9, r14)     // Catch:{ all -> 0x020d }
            r3.m = r9     // Catch:{ all -> 0x020d }
            int r4 = r3.i     // Catch:{ all -> 0x020d }
            int r4 = r4 - r11
            r3.i = r4     // Catch:{ all -> 0x020d }
            int r9 = r3.k     // Catch:{ all -> 0x020d }
            int r9 = r9 + r11
            r3.k = r9     // Catch:{ all -> 0x020d }
            int r10 = r3.j     // Catch:{ all -> 0x020d }
            int r10 = r10 + r11
            r3.j = r10     // Catch:{ all -> 0x020d }
            int r10 = r3.a     // Catch:{ all -> 0x020d }
            if (r9 != r10) goto L_0x0077
            r3.k = r12     // Catch:{ all -> 0x020d }
        L_0x0077:
            if (r4 <= 0) goto L_0x0080
            long[] r4 = r3.c     // Catch:{ all -> 0x020d }
            int r9 = r3.k     // Catch:{ all -> 0x020d }
            r9 = r4[r9]     // Catch:{ all -> 0x020d }
            goto L_0x0086
        L_0x0080:
            long r9 = r5.b     // Catch:{ all -> 0x020d }
            int r4 = r5.a     // Catch:{ all -> 0x020d }
            long r13 = (long) r4     // Catch:{ all -> 0x020d }
            long r9 = r9 + r13
        L_0x0086:
            r5.c = r9     // Catch:{ all -> 0x020d }
        L_0x0088:
            monitor-exit(r3)
            r10 = -4
            goto L_0x0095
        L_0x008b:
            com.fyber.inneractive.sdk.player.exoplayer2.i[] r4 = r3.h     // Catch:{ all -> 0x020d }
            int r5 = r3.k     // Catch:{ all -> 0x020d }
            r4 = r4[r5]     // Catch:{ all -> 0x020d }
            r0.a = r4     // Catch:{ all -> 0x020d }
        L_0x0093:
            monitor-exit(r3)
            r10 = -5
        L_0x0095:
            if (r10 == r8) goto L_0x0208
            r3 = -4
            if (r10 == r3) goto L_0x00a4
            r0 = -3
            if (r10 != r0) goto L_0x009e
            return r0
        L_0x009e:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r0.<init>()
            throw r0
        L_0x00a4:
            boolean r0 = r2.b(r7)
            if (r0 != 0) goto L_0x0206
            long r3 = r2.d
            int r0 = (r3 > r21 ? 1 : (r3 == r21 ? 0 : -1))
            if (r0 >= 0) goto L_0x00b7
            int r0 = r2.a
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r0 = r0 | r3
            r2.a = r0
        L_0x00b7:
            r0 = 1073741824(0x40000000, float:2.0)
            boolean r0 = r2.b(r0)
            if (r0 == 0) goto L_0x019e
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.d$b r0 = r1.e
            long r3 = r0.b
            com.fyber.inneractive.sdk.player.exoplayer2.util.k r5 = r1.f
            r5.c(r11)
            com.fyber.inneractive.sdk.player.exoplayer2.util.k r5 = r1.f
            byte[] r5 = r5.a
            r1.a((long) r3, (byte[]) r5, (int) r11)
            r7 = 1
            long r3 = r3 + r7
            com.fyber.inneractive.sdk.player.exoplayer2.util.k r5 = r1.f
            byte[] r5 = r5.a
            byte r5 = r5[r12]
            r7 = r5 & 128(0x80, float:1.794E-43)
            if (r7 == 0) goto L_0x00de
            r7 = 1
            goto L_0x00df
        L_0x00de:
            r7 = 0
        L_0x00df:
            r5 = r5 & 127(0x7f, float:1.78E-43)
            com.fyber.inneractive.sdk.player.exoplayer2.decoder.a r8 = r2.b
            byte[] r9 = r8.a
            r10 = 16
            if (r9 != 0) goto L_0x00ed
            byte[] r9 = new byte[r10]
            r8.a = r9
        L_0x00ed:
            byte[] r8 = r8.a
            r1.a((long) r3, (byte[]) r8, (int) r5)
            long r8 = (long) r5
            long r3 = r3 + r8
            if (r7 == 0) goto L_0x010d
            com.fyber.inneractive.sdk.player.exoplayer2.util.k r5 = r1.f
            r8 = 2
            r5.c(r8)
            com.fyber.inneractive.sdk.player.exoplayer2.util.k r5 = r1.f
            byte[] r5 = r5.a
            r1.a((long) r3, (byte[]) r5, (int) r8)
            r8 = 2
            long r3 = r3 + r8
            com.fyber.inneractive.sdk.player.exoplayer2.util.k r5 = r1.f
            int r5 = r5.q()
            goto L_0x010e
        L_0x010d:
            r5 = 1
        L_0x010e:
            com.fyber.inneractive.sdk.player.exoplayer2.decoder.a r8 = r2.b
            int[] r9 = r8.d
            if (r9 == 0) goto L_0x0117
            int r13 = r9.length
            if (r13 >= r5) goto L_0x0119
        L_0x0117:
            int[] r9 = new int[r5]
        L_0x0119:
            int[] r8 = r8.e
            if (r8 == 0) goto L_0x0120
            int r13 = r8.length
            if (r13 >= r5) goto L_0x0122
        L_0x0120:
            int[] r8 = new int[r5]
        L_0x0122:
            if (r7 == 0) goto L_0x014f
            int r7 = r5 * 6
            com.fyber.inneractive.sdk.player.exoplayer2.util.k r13 = r1.f
            r13.c(r7)
            com.fyber.inneractive.sdk.player.exoplayer2.util.k r13 = r1.f
            byte[] r13 = r13.a
            r1.a((long) r3, (byte[]) r13, (int) r7)
            long r13 = (long) r7
            long r3 = r3 + r13
            com.fyber.inneractive.sdk.player.exoplayer2.util.k r7 = r1.f
            r7.e(r12)
            r7 = 0
        L_0x013a:
            if (r7 >= r5) goto L_0x015b
            com.fyber.inneractive.sdk.player.exoplayer2.util.k r13 = r1.f
            int r13 = r13.q()
            r9[r7] = r13
            com.fyber.inneractive.sdk.player.exoplayer2.util.k r13 = r1.f
            int r13 = r13.o()
            r8[r7] = r13
            int r7 = r7 + 1
            goto L_0x013a
        L_0x014f:
            r9[r12] = r12
            int r7 = r0.a
            long r13 = r0.b
            long r13 = r3 - r13
            int r14 = (int) r13
            int r7 = r7 - r14
            r8[r12] = r7
        L_0x015b:
            com.fyber.inneractive.sdk.player.exoplayer2.decoder.a r7 = r2.b
            byte[] r13 = r0.d
            byte[] r14 = r7.a
            r7.f = r5
            r7.d = r9
            r7.e = r8
            r7.b = r13
            r7.a = r14
            r7.c = r11
            int r15 = com.fyber.inneractive.sdk.player.exoplayer2.util.u.a
            if (r15 < r10) goto L_0x0191
            android.media.MediaCodec$CryptoInfo r10 = r7.g
            r10.numSubSamples = r5
            r10.numBytesOfClearData = r9
            r10.numBytesOfEncryptedData = r8
            r10.key = r13
            r10.iv = r14
            r10.mode = r11
            r5 = 24
            if (r15 < r5) goto L_0x0191
            com.fyber.inneractive.sdk.player.exoplayer2.decoder.a$b r5 = r7.h
            android.media.MediaCodec$CryptoInfo$Pattern r7 = r5.b
            r7.set(r12, r12)
            android.media.MediaCodec$CryptoInfo r7 = r5.a
            android.media.MediaCodec$CryptoInfo$Pattern r5 = r5.b
            r7.setPattern(r5)
        L_0x0191:
            long r7 = r0.b
            long r3 = r3 - r7
            int r4 = (int) r3
            long r9 = (long) r4
            long r7 = r7 + r9
            r0.b = r7
            int r3 = r0.a
            int r3 = r3 - r4
            r0.a = r3
        L_0x019e:
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.d$b r0 = r1.e
            int r0 = r0.a
            java.nio.ByteBuffer r3 = r2.c
            if (r3 != 0) goto L_0x01ad
            java.nio.ByteBuffer r0 = r2.a(r0)
            r2.c = r0
            goto L_0x01d2
        L_0x01ad:
            int r3 = r3.capacity()
            java.nio.ByteBuffer r4 = r2.c
            int r4 = r4.position()
            int r0 = r0 + r4
            if (r3 < r0) goto L_0x01bb
            goto L_0x01d2
        L_0x01bb:
            java.nio.ByteBuffer r0 = r2.a(r0)
            if (r4 <= 0) goto L_0x01d0
            java.nio.ByteBuffer r3 = r2.c
            r3.position(r12)
            java.nio.ByteBuffer r3 = r2.c
            r3.limit(r4)
            java.nio.ByteBuffer r3 = r2.c
            r0.put(r3)
        L_0x01d0:
            r2.c = r0
        L_0x01d2:
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.d$b r0 = r1.e
            long r3 = r0.b
            java.nio.ByteBuffer r2 = r2.c
            int r0 = r0.a
        L_0x01da:
            if (r0 <= 0) goto L_0x01ff
            r1.a((long) r3)
            long r7 = r1.h
            long r7 = r3 - r7
            int r5 = (int) r7
            int r7 = r1.b
            int r7 = r7 - r5
            int r7 = java.lang.Math.min(r0, r7)
            java.util.concurrent.LinkedBlockingDeque<com.fyber.inneractive.sdk.player.exoplayer2.upstream.a> r8 = r1.d
            java.lang.Object r8 = r8.peek()
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.a r8 = (com.fyber.inneractive.sdk.player.exoplayer2.upstream.a) r8
            byte[] r9 = r8.a
            int r8 = r8.b
            int r8 = r8 + r5
            r2.put(r9, r8, r7)
            long r8 = (long) r7
            long r3 = r3 + r8
            int r0 = r0 - r7
            goto L_0x01da
        L_0x01ff:
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.d$b r0 = r1.e
            long r2 = r0.c
            r1.a((long) r2)
        L_0x0206:
            r0 = -4
            return r0
        L_0x0208:
            com.fyber.inneractive.sdk.player.exoplayer2.i r0 = r0.a
            r1.i = r0
            return r8
        L_0x020d:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.exoplayer2.extractor.d.a(com.fyber.inneractive.sdk.player.exoplayer2.j, com.fyber.inneractive.sdk.player.exoplayer2.decoder.b, boolean, boolean, long):int");
    }

    public static final class c {
        public int a = 1000;
        public int[] b = new int[1000];
        public long[] c = new long[1000];
        public int[] d = new int[1000];
        public int[] e = new int[1000];
        public long[] f = new long[1000];
        public byte[][] g = new byte[1000][];
        public i[] h = new i[1000];
        public int i;
        public int j;
        public int k;
        public int l;
        public long m = Long.MIN_VALUE;
        public long n = Long.MIN_VALUE;
        public boolean o = true;
        public boolean p = true;
        public i q;
        public int r;

        /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
            java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
            	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
            	at java.util.ArrayList.get(ArrayList.java:435)
            	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
            	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
            	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
            	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
            	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
            	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
            */
        public synchronized void a(long r6, int r8, long r9, int r11, byte[] r12) {
            /*
                r5 = this;
                monitor-enter(r5)
                boolean r0 = r5.o     // Catch:{ all -> 0x00d6 }
                r1 = 0
                if (r0 == 0) goto L_0x000e
                r0 = r8 & 1
                if (r0 != 0) goto L_0x000c
                monitor-exit(r5)
                return
            L_0x000c:
                r5.o = r1     // Catch:{ all -> 0x00d6 }
            L_0x000e:
                boolean r0 = r5.p     // Catch:{ all -> 0x00d6 }
                r0 = r0 ^ 1
                com.fyber.inneractive.sdk.player.exoplayer2.util.a.b(r0)     // Catch:{ all -> 0x00d6 }
                monitor-enter(r5)     // Catch:{ all -> 0x00d6 }
                long r2 = r5.n     // Catch:{ all -> 0x00d3 }
                long r2 = java.lang.Math.max(r2, r6)     // Catch:{ all -> 0x00d3 }
                r5.n = r2     // Catch:{ all -> 0x00d3 }
                monitor-exit(r5)     // Catch:{ all -> 0x00d6 }
                long[] r0 = r5.f     // Catch:{ all -> 0x00d6 }
                int r2 = r5.l     // Catch:{ all -> 0x00d6 }
                r0[r2] = r6     // Catch:{ all -> 0x00d6 }
                long[] r6 = r5.c     // Catch:{ all -> 0x00d6 }
                r6[r2] = r9     // Catch:{ all -> 0x00d6 }
                int[] r7 = r5.d     // Catch:{ all -> 0x00d6 }
                r7[r2] = r11     // Catch:{ all -> 0x00d6 }
                int[] r7 = r5.e     // Catch:{ all -> 0x00d6 }
                r7[r2] = r8     // Catch:{ all -> 0x00d6 }
                byte[][] r7 = r5.g     // Catch:{ all -> 0x00d6 }
                r7[r2] = r12     // Catch:{ all -> 0x00d6 }
                com.fyber.inneractive.sdk.player.exoplayer2.i[] r7 = r5.h     // Catch:{ all -> 0x00d6 }
                com.fyber.inneractive.sdk.player.exoplayer2.i r8 = r5.q     // Catch:{ all -> 0x00d6 }
                r7[r2] = r8     // Catch:{ all -> 0x00d6 }
                int[] r7 = r5.b     // Catch:{ all -> 0x00d6 }
                int r8 = r5.r     // Catch:{ all -> 0x00d6 }
                r7[r2] = r8     // Catch:{ all -> 0x00d6 }
                int r7 = r5.i     // Catch:{ all -> 0x00d6 }
                int r7 = r7 + 1
                r5.i = r7     // Catch:{ all -> 0x00d6 }
                int r8 = r5.a     // Catch:{ all -> 0x00d6 }
                if (r7 != r8) goto L_0x00c9
                int r7 = r8 + 1000
                int[] r9 = new int[r7]     // Catch:{ all -> 0x00d6 }
                long[] r10 = new long[r7]     // Catch:{ all -> 0x00d6 }
                long[] r11 = new long[r7]     // Catch:{ all -> 0x00d6 }
                int[] r12 = new int[r7]     // Catch:{ all -> 0x00d6 }
                int[] r0 = new int[r7]     // Catch:{ all -> 0x00d6 }
                byte[][] r2 = new byte[r7][]     // Catch:{ all -> 0x00d6 }
                com.fyber.inneractive.sdk.player.exoplayer2.i[] r3 = new com.fyber.inneractive.sdk.player.exoplayer2.i[r7]     // Catch:{ all -> 0x00d6 }
                int r4 = r5.k     // Catch:{ all -> 0x00d6 }
                int r8 = r8 - r4
                java.lang.System.arraycopy(r6, r4, r10, r1, r8)     // Catch:{ all -> 0x00d6 }
                long[] r6 = r5.f     // Catch:{ all -> 0x00d6 }
                int r4 = r5.k     // Catch:{ all -> 0x00d6 }
                java.lang.System.arraycopy(r6, r4, r11, r1, r8)     // Catch:{ all -> 0x00d6 }
                int[] r6 = r5.e     // Catch:{ all -> 0x00d6 }
                int r4 = r5.k     // Catch:{ all -> 0x00d6 }
                java.lang.System.arraycopy(r6, r4, r12, r1, r8)     // Catch:{ all -> 0x00d6 }
                int[] r6 = r5.d     // Catch:{ all -> 0x00d6 }
                int r4 = r5.k     // Catch:{ all -> 0x00d6 }
                java.lang.System.arraycopy(r6, r4, r0, r1, r8)     // Catch:{ all -> 0x00d6 }
                byte[][] r6 = r5.g     // Catch:{ all -> 0x00d6 }
                int r4 = r5.k     // Catch:{ all -> 0x00d6 }
                java.lang.System.arraycopy(r6, r4, r2, r1, r8)     // Catch:{ all -> 0x00d6 }
                com.fyber.inneractive.sdk.player.exoplayer2.i[] r6 = r5.h     // Catch:{ all -> 0x00d6 }
                int r4 = r5.k     // Catch:{ all -> 0x00d6 }
                java.lang.System.arraycopy(r6, r4, r3, r1, r8)     // Catch:{ all -> 0x00d6 }
                int[] r6 = r5.b     // Catch:{ all -> 0x00d6 }
                int r4 = r5.k     // Catch:{ all -> 0x00d6 }
                java.lang.System.arraycopy(r6, r4, r9, r1, r8)     // Catch:{ all -> 0x00d6 }
                int r6 = r5.k     // Catch:{ all -> 0x00d6 }
                long[] r4 = r5.c     // Catch:{ all -> 0x00d6 }
                java.lang.System.arraycopy(r4, r1, r10, r8, r6)     // Catch:{ all -> 0x00d6 }
                long[] r4 = r5.f     // Catch:{ all -> 0x00d6 }
                java.lang.System.arraycopy(r4, r1, r11, r8, r6)     // Catch:{ all -> 0x00d6 }
                int[] r4 = r5.e     // Catch:{ all -> 0x00d6 }
                java.lang.System.arraycopy(r4, r1, r12, r8, r6)     // Catch:{ all -> 0x00d6 }
                int[] r4 = r5.d     // Catch:{ all -> 0x00d6 }
                java.lang.System.arraycopy(r4, r1, r0, r8, r6)     // Catch:{ all -> 0x00d6 }
                byte[][] r4 = r5.g     // Catch:{ all -> 0x00d6 }
                java.lang.System.arraycopy(r4, r1, r2, r8, r6)     // Catch:{ all -> 0x00d6 }
                com.fyber.inneractive.sdk.player.exoplayer2.i[] r4 = r5.h     // Catch:{ all -> 0x00d6 }
                java.lang.System.arraycopy(r4, r1, r3, r8, r6)     // Catch:{ all -> 0x00d6 }
                int[] r4 = r5.b     // Catch:{ all -> 0x00d6 }
                java.lang.System.arraycopy(r4, r1, r9, r8, r6)     // Catch:{ all -> 0x00d6 }
                r5.c = r10     // Catch:{ all -> 0x00d6 }
                r5.f = r11     // Catch:{ all -> 0x00d6 }
                r5.e = r12     // Catch:{ all -> 0x00d6 }
                r5.d = r0     // Catch:{ all -> 0x00d6 }
                r5.g = r2     // Catch:{ all -> 0x00d6 }
                r5.h = r3     // Catch:{ all -> 0x00d6 }
                r5.b = r9     // Catch:{ all -> 0x00d6 }
                r5.k = r1     // Catch:{ all -> 0x00d6 }
                int r6 = r5.a     // Catch:{ all -> 0x00d6 }
                r5.l = r6     // Catch:{ all -> 0x00d6 }
                r5.i = r6     // Catch:{ all -> 0x00d6 }
                r5.a = r7     // Catch:{ all -> 0x00d6 }
                goto L_0x00d1
            L_0x00c9:
                int r2 = r2 + 1
                r5.l = r2     // Catch:{ all -> 0x00d6 }
                if (r2 != r8) goto L_0x00d1
                r5.l = r1     // Catch:{ all -> 0x00d6 }
            L_0x00d1:
                monitor-exit(r5)
                return
            L_0x00d3:
                r6 = move-exception
                monitor-exit(r5)     // Catch:{ all -> 0x00d6 }
                throw r6     // Catch:{ all -> 0x00d6 }
            L_0x00d6:
                r6 = move-exception
                monitor-exit(r5)
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.exoplayer2.extractor.d.c.a(long, int, long, int, byte[]):void");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:35:0x0080, code lost:
            return true;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public synchronized boolean a(long r7) {
            /*
                r6 = this;
                monitor-enter(r6)
                long r0 = r6.m     // Catch:{ all -> 0x0081 }
                r2 = 0
                int r3 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
                if (r3 < 0) goto L_0x000a
                monitor-exit(r6)
                return r2
            L_0x000a:
                int r0 = r6.i     // Catch:{ all -> 0x0081 }
            L_0x000c:
                r1 = 1
                if (r0 <= 0) goto L_0x0021
                long[] r3 = r6.f     // Catch:{ all -> 0x0081 }
                int r4 = r6.k     // Catch:{ all -> 0x0081 }
                int r4 = r4 + r0
                int r4 = r4 - r1
                int r5 = r6.a     // Catch:{ all -> 0x0081 }
                int r4 = r4 % r5
                r4 = r3[r4]     // Catch:{ all -> 0x0081 }
                int r3 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
                if (r3 < 0) goto L_0x0021
                int r0 = r0 + -1
                goto L_0x000c
            L_0x0021:
                int r7 = r6.j     // Catch:{ all -> 0x0081 }
                int r0 = r0 + r7
                int r8 = r6.i     // Catch:{ all -> 0x0081 }
                int r7 = r7 + r8
                int r7 = r7 - r0
                if (r7 < 0) goto L_0x002d
                if (r7 > r8) goto L_0x002d
                r2 = 1
            L_0x002d:
                com.fyber.inneractive.sdk.player.exoplayer2.util.a.a((boolean) r2)     // Catch:{ all -> 0x0081 }
                if (r7 != 0) goto L_0x0047
                int r7 = r6.j     // Catch:{ all -> 0x0081 }
                if (r7 != 0) goto L_0x0037
                goto L_0x007f
            L_0x0037:
                int r7 = r6.l     // Catch:{ all -> 0x0081 }
                if (r7 != 0) goto L_0x003d
                int r7 = r6.a     // Catch:{ all -> 0x0081 }
            L_0x003d:
                int r7 = r7 - r1
                long[] r8 = r6.c     // Catch:{ all -> 0x0081 }
                r2 = r8[r7]     // Catch:{ all -> 0x0081 }
                int[] r8 = r6.d     // Catch:{ all -> 0x0081 }
                r7 = r8[r7]     // Catch:{ all -> 0x0081 }
                goto L_0x007f
            L_0x0047:
                int r8 = r6.i     // Catch:{ all -> 0x0081 }
                int r8 = r8 - r7
                r6.i = r8     // Catch:{ all -> 0x0081 }
                int r0 = r6.l     // Catch:{ all -> 0x0081 }
                int r2 = r6.a     // Catch:{ all -> 0x0081 }
                int r0 = r0 + r2
                int r0 = r0 - r7
                int r0 = r0 % r2
                r6.l = r0     // Catch:{ all -> 0x0081 }
                r2 = -9223372036854775808
                r6.n = r2     // Catch:{ all -> 0x0081 }
                int r8 = r8 - r1
            L_0x005a:
                if (r8 < 0) goto L_0x0079
                int r7 = r6.k     // Catch:{ all -> 0x0081 }
                int r7 = r7 + r8
                int r0 = r6.a     // Catch:{ all -> 0x0081 }
                int r7 = r7 % r0
                long r2 = r6.n     // Catch:{ all -> 0x0081 }
                long[] r0 = r6.f     // Catch:{ all -> 0x0081 }
                r4 = r0[r7]     // Catch:{ all -> 0x0081 }
                long r2 = java.lang.Math.max(r2, r4)     // Catch:{ all -> 0x0081 }
                r6.n = r2     // Catch:{ all -> 0x0081 }
                int[] r0 = r6.e     // Catch:{ all -> 0x0081 }
                r7 = r0[r7]     // Catch:{ all -> 0x0081 }
                r7 = r7 & r1
                if (r7 == 0) goto L_0x0076
                goto L_0x0079
            L_0x0076:
                int r8 = r8 + -1
                goto L_0x005a
            L_0x0079:
                long[] r7 = r6.c     // Catch:{ all -> 0x0081 }
                int r8 = r6.l     // Catch:{ all -> 0x0081 }
                r2 = r7[r8]     // Catch:{ all -> 0x0081 }
            L_0x007f:
                monitor-exit(r6)
                return r1
            L_0x0081:
                r7 = move-exception
                monitor-exit(r6)
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.exoplayer2.extractor.d.c.a(long):boolean");
        }
    }

    public final void a(long j2, byte[] bArr, int i2) {
        int i3 = 0;
        while (i3 < i2) {
            a(j2);
            int i4 = (int) (j2 - this.h);
            int min = Math.min(i2 - i3, this.b - i4);
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.a peek = this.d.peek();
            System.arraycopy(peek.a, peek.b + i4, bArr, i3, min);
            j2 += (long) min;
            i3 += min;
        }
    }

    public final void a(long j2) {
        int i2 = ((int) (j2 - this.h)) / this.b;
        for (int i3 = 0; i3 < i2; i3++) {
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.b bVar = this.a;
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.a remove = this.d.remove();
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.k kVar = (com.fyber.inneractive.sdk.player.exoplayer2.upstream.k) bVar;
            synchronized (kVar) {
                com.fyber.inneractive.sdk.player.exoplayer2.upstream.a[] aVarArr = kVar.d;
                aVarArr[0] = remove;
                kVar.a(aVarArr);
            }
            this.h += (long) this.b;
        }
    }

    public void a(i iVar) {
        boolean z;
        if (iVar == null) {
            iVar = null;
        }
        c cVar = this.c;
        synchronized (cVar) {
            z = true;
            if (iVar == null) {
                cVar.p = true;
            } else {
                cVar.p = false;
                if (!u.a((Object) iVar, (Object) cVar.q)) {
                    cVar.q = iVar;
                }
            }
            z = false;
        }
        C0115d dVar = this.n;
        if (dVar != null && z) {
            dVar.a(iVar);
        }
    }

    public int a(g gVar, int i2, boolean z) throws IOException, InterruptedException {
        if (!h()) {
            int b2 = ((b) gVar).b(i2);
            if (b2 != -1) {
                return b2;
            }
            if (z) {
                return -1;
            }
            throw new EOFException();
        }
        try {
            int a2 = a(i2);
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.a aVar = this.k;
            int a3 = ((b) gVar).a(aVar.a, aVar.b + this.l, a2);
            if (a3 != -1) {
                this.l += a3;
                this.j += (long) a3;
                c();
                return a3;
            } else if (z) {
                return -1;
            } else {
                throw new EOFException();
            }
        } finally {
            c();
        }
    }

    public void a(k kVar, int i2) {
        if (!h()) {
            kVar.e(kVar.b + i2);
            return;
        }
        while (i2 > 0) {
            int a2 = a(i2);
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.a aVar = this.k;
            kVar.a(aVar.a, aVar.b + this.l, a2);
            this.l += a2;
            this.j += (long) a2;
            i2 -= a2;
        }
        c();
    }

    public void a(long j2, int i2, int i3, int i4, byte[] bArr) {
        long j3 = j2;
        if (!h()) {
            c cVar = this.c;
            synchronized (cVar) {
                cVar.n = Math.max(cVar.n, j2);
            }
            return;
        }
        try {
            if (this.m) {
                if ((i2 & 1) != 0) {
                    if (this.c.a(j2)) {
                        this.m = false;
                    }
                }
                return;
            }
            this.c.a(j2, i2, (this.j - ((long) i3)) - ((long) i4), i3, bArr);
            c();
        } finally {
            c();
        }
    }

    public final void a() {
        c cVar = this.c;
        cVar.j = 0;
        cVar.k = 0;
        cVar.l = 0;
        cVar.i = 0;
        cVar.o = true;
        com.fyber.inneractive.sdk.player.exoplayer2.upstream.b bVar = this.a;
        LinkedBlockingDeque<com.fyber.inneractive.sdk.player.exoplayer2.upstream.a> linkedBlockingDeque = this.d;
        ((com.fyber.inneractive.sdk.player.exoplayer2.upstream.k) bVar).a((com.fyber.inneractive.sdk.player.exoplayer2.upstream.a[]) linkedBlockingDeque.toArray(new com.fyber.inneractive.sdk.player.exoplayer2.upstream.a[linkedBlockingDeque.size()]));
        this.d.clear();
        ((com.fyber.inneractive.sdk.player.exoplayer2.upstream.k) this.a).b();
        this.h = 0;
        this.j = 0;
        this.k = null;
        this.l = this.b;
    }

    public final int a(int i2) {
        com.fyber.inneractive.sdk.player.exoplayer2.upstream.a aVar;
        if (this.l == this.b) {
            this.l = 0;
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.k kVar = (com.fyber.inneractive.sdk.player.exoplayer2.upstream.k) this.a;
            synchronized (kVar) {
                kVar.f++;
                int i3 = kVar.g;
                if (i3 > 0) {
                    com.fyber.inneractive.sdk.player.exoplayer2.upstream.a[] aVarArr = kVar.h;
                    int i4 = i3 - 1;
                    kVar.g = i4;
                    aVar = aVarArr[i4];
                    aVarArr[i4] = null;
                } else {
                    aVar = new com.fyber.inneractive.sdk.player.exoplayer2.upstream.a(new byte[kVar.b], 0);
                }
            }
            this.k = aVar;
            this.d.add(aVar);
        }
        return Math.min(i2, this.b - this.l);
    }
}
