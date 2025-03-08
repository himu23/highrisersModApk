package com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist;

import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import androidx.work.WorkRequest;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.h;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.a;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.b;
import com.fyber.inneractive.sdk.player.exoplayer2.i;
import com.fyber.inneractive.sdk.player.exoplayer2.l;
import com.fyber.inneractive.sdk.player.exoplayer2.source.f;
import com.fyber.inneractive.sdk.player.exoplayer2.source.q;
import com.fyber.inneractive.sdk.player.exoplayer2.upstream.x;
import com.fyber.inneractive.sdk.player.exoplayer2.upstream.y;
import com.fyber.inneractive.sdk.player.exoplayer2.util.t;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;

public final class e implements x.a<y<c>> {
    public final Uri a;
    public final com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.d b;
    public final d c = new d();
    public final int d;
    public final IdentityHashMap<a.C0117a, a> e = new IdentityHashMap<>();
    public final Handler f = new Handler();
    public final C0118e g;
    public final List<b> h = new ArrayList();
    public final x i = new x("HlsPlaylistTracker:MasterPlaylist");
    public final f.a j;
    public a k;
    public a.C0117a l;
    public b m;
    public boolean n;

    public final class a implements x.a<y<c>>, Runnable {
        public final a.C0117a a;
        public final x b = new x("HlsPlaylistTracker:MediaPlaylist");
        public final y<c> c;
        public b d;
        public long e;
        public long f;
        public long g;
        public long h;
        public boolean i;
        public IOException j;

        public a(a.C0117a aVar, long j2) {
            this.a = aVar;
            this.g = j2;
            this.c = new y<>(((com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.b) e.this.b).a(4), t.a(e.this.k.a, aVar.a), 4, e.this.c);
        }

        public void a(x.c cVar, long j2, long j3, boolean z) {
            y yVar = (y) cVar;
            e.this.j.a(yVar.a, 4, j2, j3, yVar.f);
        }

        public void b() {
            this.h = 0;
            if (!this.i && !this.b.b()) {
                this.b.a(this.c, this, e.this.d);
            }
        }

        public void run() {
            this.i = false;
            b();
        }

        public void a(x.c cVar, long j2, long j3) {
            y yVar = (y) cVar;
            c cVar2 = (c) yVar.d;
            if (cVar2 instanceof b) {
                a((b) cVar2);
                e.this.j.b(yVar.a, 4, j2, j3, yVar.f);
                return;
            }
            this.j = new l("Loaded playlist has unexpected type.");
        }

        public int a(x.c cVar, long j2, long j3, IOException iOException) {
            y yVar = (y) cVar;
            boolean z = iOException instanceof l;
            e.this.j.a(yVar.a, 4, j2, j3, yVar.f, iOException, z);
            if (z) {
                return 3;
            }
            if (com.fyber.inneractive.sdk.player.exoplayer2.source.chunk.b.a(iOException)) {
                a();
                e eVar = e.this;
                if (eVar.l != this.a || e.a(eVar)) {
                    return 2;
                }
            }
            return 0;
        }

        /* JADX WARNING: Removed duplicated region for block: B:64:0x0176  */
        /* JADX WARNING: Removed duplicated region for block: B:66:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.b r28) {
            /*
                r27 = this;
                r0 = r27
                r1 = r28
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.b r2 = r0.d
                long r3 = android.os.SystemClock.elapsedRealtime()
                r0.e = r3
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.e r5 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.e.this
                r5.getClass()
                r28.getClass()
                if (r2 == 0) goto L_0x007e
                int r6 = r1.g
                int r7 = r2.g
                if (r6 <= r7) goto L_0x001e
                goto L_0x007e
            L_0x001e:
                if (r6 >= r7) goto L_0x0021
                goto L_0x003a
            L_0x0021:
                java.util.List<com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.b$a> r6 = r1.m
                int r6 = r6.size()
                java.util.List<com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.b$a> r7 = r2.m
                int r7 = r7.size()
                if (r6 > r7) goto L_0x007e
                if (r6 != r7) goto L_0x003a
                boolean r6 = r1.j
                if (r6 == 0) goto L_0x003a
                boolean r6 = r2.j
                if (r6 != 0) goto L_0x003a
                goto L_0x007e
            L_0x003a:
                boolean r5 = r1.j
                if (r5 == 0) goto L_0x0079
                boolean r5 = r2.j
                if (r5 == 0) goto L_0x0043
                goto L_0x0079
            L_0x0043:
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.b r5 = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.b
                r6 = r5
                int r7 = r2.b
                java.lang.String r8 = r2.a
                long r9 = r2.c
                long r11 = r2.d
                boolean r13 = r2.e
                int r14 = r2.f
                int r15 = r2.g
                r24 = r5
                int r5 = r2.h
                r16 = r5
                r25 = r3
                long r3 = r2.i
                r17 = r3
                boolean r3 = r2.k
                r20 = r3
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.b$a r3 = r2.l
                r21 = r3
                java.util.List<com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.b$a> r3 = r2.m
                r22 = r3
                java.util.List<java.lang.String> r3 = r2.n
                r23 = r3
                r19 = 1
                r6.<init>(r7, r8, r9, r11, r13, r14, r15, r16, r17, r19, r20, r21, r22, r23)
                r5 = r24
                goto L_0x0108
            L_0x0079:
                r25 = r3
                r5 = r2
                goto L_0x0108
            L_0x007e:
                r25 = r3
                boolean r3 = r1.k
                if (r3 == 0) goto L_0x0088
                long r3 = r1.d
            L_0x0086:
                r11 = r3
                goto L_0x00b2
            L_0x0088:
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.b r3 = r5.m
                if (r3 == 0) goto L_0x008f
                long r3 = r3.d
                goto L_0x0091
            L_0x008f:
                r3 = 0
            L_0x0091:
                if (r2 != 0) goto L_0x0094
                goto L_0x0086
            L_0x0094:
                java.util.List<com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.b$a> r6 = r2.m
                int r6 = r6.size()
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.b$a r7 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.e.a(r2, r1)
                if (r7 == 0) goto L_0x00a6
                long r3 = r2.d
                long r6 = r7.d
            L_0x00a4:
                long r3 = r3 + r6
                goto L_0x0086
            L_0x00a6:
                int r7 = r1.g
                int r8 = r2.g
                int r7 = r7 - r8
                if (r6 != r7) goto L_0x0086
                long r3 = r2.d
                long r6 = r2.o
                goto L_0x00a4
            L_0x00b2:
                boolean r3 = r1.e
                if (r3 == 0) goto L_0x00ba
                int r3 = r1.f
            L_0x00b8:
                r14 = r3
                goto L_0x00dd
            L_0x00ba:
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.b r3 = r5.m
                r4 = 0
                if (r3 == 0) goto L_0x00c2
                int r3 = r3.f
                goto L_0x00c3
            L_0x00c2:
                r3 = 0
            L_0x00c3:
                if (r2 != 0) goto L_0x00c6
                goto L_0x00b8
            L_0x00c6:
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.b$a r5 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.e.a(r2, r1)
                if (r5 == 0) goto L_0x00b8
                int r3 = r2.f
                int r5 = r5.c
                int r3 = r3 + r5
                java.util.List<com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.b$a> r5 = r1.m
                java.lang.Object r4 = r5.get(r4)
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.b$a r4 = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.b.a) r4
                int r4 = r4.c
                int r3 = r3 - r4
                goto L_0x00b8
            L_0x00dd:
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.b r5 = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.b
                r6 = r5
                int r7 = r1.b
                java.lang.String r8 = r1.a
                long r9 = r1.c
                int r15 = r1.g
                int r3 = r1.h
                r16 = r3
                long r3 = r1.i
                r17 = r3
                boolean r3 = r1.j
                r19 = r3
                boolean r3 = r1.k
                r20 = r3
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.b$a r3 = r1.l
                r21 = r3
                java.util.List<com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.b$a> r3 = r1.m
                r22 = r3
                java.util.List<java.lang.String> r3 = r1.n
                r23 = r3
                r13 = 1
                r6.<init>(r7, r8, r9, r11, r13, r14, r15, r16, r17, r19, r20, r21, r22, r23)
            L_0x0108:
                r0.d = r5
                r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
                if (r5 == r2) goto L_0x0127
                r1 = 0
                r0.j = r1
                r6 = r25
                r0.f = r6
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.e r1 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.e.this
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.a$a r2 = r0.a
                boolean r1 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.e.a((com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.e) r1, (com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.a.C0117a) r2, (com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.b) r5)
                if (r1 == 0) goto L_0x0171
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.b r1 = r0.d
                long r1 = r1.i
                goto L_0x0172
            L_0x0127:
                r6 = r25
                boolean r2 = r5.j
                if (r2 != 0) goto L_0x0171
                long r8 = r0.f
                long r6 = r6 - r8
                double r6 = (double) r6
                long r8 = r5.i
                long r8 = com.fyber.inneractive.sdk.player.exoplayer2.b.b(r8)
                double r8 = (double) r8
                r10 = 4615063718147915776(0x400c000000000000, double:3.5)
                double r8 = r8 * r10
                int r2 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
                if (r2 <= 0) goto L_0x014f
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.e$d r1 = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.e$d
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.a$a r2 = r0.a
                java.lang.String r2 = r2.a
                r1.<init>(r2)
                r0.j = r1
                r27.a()
                goto L_0x0169
            L_0x014f:
                int r2 = r1.g
                java.util.List<com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.b$a> r1 = r1.m
                int r1 = r1.size()
                int r2 = r2 + r1
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.b r1 = r0.d
                int r1 = r1.g
                if (r2 >= r1) goto L_0x0169
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.e$c r1 = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.e$c
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.a$a r2 = r0.a
                java.lang.String r2 = r2.a
                r1.<init>(r2)
                r0.j = r1
            L_0x0169:
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.b r1 = r0.d
                long r1 = r1.i
                r5 = 2
                long r1 = r1 / r5
                goto L_0x0172
            L_0x0171:
                r1 = r3
            L_0x0172:
                int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
                if (r5 == 0) goto L_0x0184
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.e r3 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.e.this
                android.os.Handler r3 = r3.f
                long r1 = com.fyber.inneractive.sdk.player.exoplayer2.b.b(r1)
                boolean r1 = r3.postDelayed(r0, r1)
                r0.i = r1
            L_0x0184:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.e.a.a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.b):void");
        }

        public final void a() {
            this.h = SystemClock.elapsedRealtime() + 60000;
            e eVar = e.this;
            a.C0117a aVar = this.a;
            int size = eVar.h.size();
            for (int i2 = 0; i2 < size; i2++) {
                eVar.h.get(i2).a(aVar, 60000);
            }
        }
    }

    public interface b {
        void a(a.C0117a aVar, long j);

        void c();
    }

    public static final class c extends IOException {
        public c(String str) {
        }
    }

    public static final class d extends IOException {
        public d(String str) {
        }
    }

    /* renamed from: com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.playlist.e$e  reason: collision with other inner class name */
    public interface C0118e {
    }

    public e(Uri uri, com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.d dVar, f.a aVar, int i2, C0118e eVar) {
        this.a = uri;
        this.b = dVar;
        this.j = aVar;
        this.d = i2;
        this.g = eVar;
    }

    public void a(x.c cVar, long j2, long j3, boolean z) {
        y yVar = (y) cVar;
        this.j.a(yVar.a, 4, j2, j3, yVar.f);
    }

    public boolean b(a.C0117a aVar) {
        int i2;
        a aVar2 = this.e.get(aVar);
        if (aVar2.d != null) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long max = Math.max(WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS, com.fyber.inneractive.sdk.player.exoplayer2.b.b(aVar2.d.o));
            b bVar = aVar2.d;
            if (bVar.j || (i2 = bVar.b) == 2 || i2 == 1 || aVar2.e + max > elapsedRealtime) {
                return true;
            }
        }
        return false;
    }

    public void a(x.c cVar, long j2, long j3) {
        a aVar;
        y yVar = (y) cVar;
        c cVar2 = (c) yVar.d;
        boolean z = cVar2 instanceof b;
        if (z) {
            String str = cVar2.a;
            i iVar = r5;
            i iVar2 = new i("0", "application/x-mpegURL", (String) null, (String) null, -1, -1, -1, -1, -1.0f, -1, -1.0f, (byte[]) null, -1, (com.fyber.inneractive.sdk.player.exoplayer2.video.b) null, -1, -1, -1, -1, -1, 0, (String) null, -1, Long.MAX_VALUE, (List<byte[]>) null, (com.fyber.inneractive.sdk.player.exoplayer2.drm.a) null, (com.fyber.inneractive.sdk.player.exoplayer2.metadata.a) null);
            List singletonList = Collections.singletonList(new a.C0117a(str, iVar));
            List emptyList = Collections.emptyList();
            aVar = new a((String) null, singletonList, emptyList, emptyList, (i) null, (List<i>) null);
        } else {
            aVar = (a) cVar2;
        }
        this.k = aVar;
        this.l = aVar.b.get(0);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(aVar.b);
        arrayList.addAll(aVar.c);
        arrayList.addAll(aVar.d);
        int size = arrayList.size();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        for (int i2 = 0; i2 < size; i2++) {
            a.C0117a aVar2 = (a.C0117a) arrayList.get(i2);
            this.e.put(aVar2, new a(aVar2, elapsedRealtime));
        }
        a aVar3 = this.e.get(this.l);
        if (z) {
            aVar3.a((b) cVar2);
        } else {
            aVar3.b();
        }
        this.j.b(yVar.a, 4, j2, j3, yVar.f);
    }

    public int a(x.c cVar, long j2, long j3, IOException iOException) {
        y yVar = (y) cVar;
        IOException iOException2 = iOException;
        boolean z = iOException2 instanceof l;
        this.j.a(yVar.a, 4, j2, j3, yVar.f, iOException2, z);
        return z ? 3 : 0;
    }

    public b a(a.C0117a aVar) {
        b bVar;
        a aVar2 = this.e.get(aVar);
        aVar2.getClass();
        aVar2.g = SystemClock.elapsedRealtime();
        b bVar2 = aVar2.d;
        if (bVar2 != null && this.k.b.contains(aVar) && (((bVar = this.m) == null || !bVar.j) && this.e.get(this.l).g - SystemClock.elapsedRealtime() > 15000)) {
            this.l = aVar;
            this.e.get(aVar).b();
        }
        return bVar2;
    }

    public static boolean a(e eVar) {
        List<a.C0117a> list = eVar.k.b;
        int size = list.size();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        for (int i2 = 0; i2 < size; i2++) {
            a aVar = eVar.e.get(list.get(i2));
            if (elapsedRealtime > aVar.h) {
                eVar.l = aVar.a;
                aVar.b();
                return true;
            }
        }
        return false;
    }

    public static boolean a(e eVar, a.C0117a aVar, b bVar) {
        q qVar;
        long j2;
        e eVar2 = eVar;
        a.C0117a aVar2 = aVar;
        b bVar2 = bVar;
        if (aVar2 == eVar2.l) {
            if (eVar2.m == null) {
                eVar2.n = !bVar2.j;
            }
            eVar2.m = bVar2;
            h hVar = (h) eVar2.g;
            hVar.getClass();
            long j3 = bVar2.c;
            if (hVar.d.n) {
                long j4 = bVar2.j ? bVar2.d + bVar2.o : -9223372036854775807L;
                List<b.a> list = bVar2.m;
                if (j3 == -9223372036854775807L) {
                    if (list.isEmpty()) {
                        j2 = 0;
                        qVar = new q(j4, bVar2.o, bVar2.d, j2, true, !bVar2.j);
                    } else {
                        j3 = list.get(Math.max(0, list.size() - 3)).d;
                    }
                }
                j2 = j3;
                qVar = new q(j4, bVar2.o, bVar2.d, j2, true, !bVar2.j);
            } else {
                long j5 = j3 == -9223372036854775807L ? 0 : j3;
                long j6 = bVar2.d;
                long j7 = bVar2.o;
                qVar = new q(j6 + j7, j7, j6, j5, true, false);
            }
            hVar.e.a(qVar, new com.fyber.inneractive.sdk.player.exoplayer2.extractor.hls.e(hVar.d.k, bVar2));
        }
        int size = eVar2.h.size();
        for (int i2 = 0; i2 < size; i2++) {
            eVar2.h.get(i2).c();
        }
        if (aVar2 != eVar2.l || bVar2.j) {
            return false;
        }
        return true;
    }

    public static b.a a(b bVar, b bVar2) {
        int i2 = bVar2.g - bVar.g;
        List<b.a> list = bVar.m;
        if (i2 < list.size()) {
            return list.get(i2);
        }
        return null;
    }
}
