package com.fyber.inneractive.sdk.player.exoplayer2.source;

import android.net.Uri;
import android.os.Handler;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseArray;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.d;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.f;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.h;
import com.fyber.inneractive.sdk.player.exoplayer2.j;
import com.fyber.inneractive.sdk.player.exoplayer2.source.l;
import com.fyber.inneractive.sdk.player.exoplayer2.source.m;
import com.fyber.inneractive.sdk.player.exoplayer2.source.n;
import com.fyber.inneractive.sdk.player.exoplayer2.upstream.g;
import com.fyber.inneractive.sdk.player.exoplayer2.upstream.t;
import com.fyber.inneractive.sdk.player.exoplayer2.upstream.v;
import com.fyber.inneractive.sdk.player.exoplayer2.upstream.x;
import com.fyber.inneractive.sdk.player.exoplayer2.util.u;
import java.io.EOFException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.UnknownHostException;

public final class i implements m, h, x.a<c>, d.C0115d {
    public boolean A;
    public long B;
    public long C;
    public long D;
    public int E;
    public boolean F;
    public boolean G;
    public final Uri a;
    public final g b;
    public final int c;
    public final Handler d;
    public final l.a e;
    public final n.a f;
    public final com.fyber.inneractive.sdk.player.exoplayer2.upstream.b g;
    public final String h;
    public final x i = new x("Loader:ExtractorMediaPeriod");
    public final d j;
    public final com.fyber.inneractive.sdk.player.exoplayer2.util.d k;
    public final Runnable l;
    public final Runnable m;
    public final Handler n;
    public final SparseArray<com.fyber.inneractive.sdk.player.exoplayer2.extractor.d> o;
    public m.a p;
    public com.fyber.inneractive.sdk.player.exoplayer2.extractor.m q;
    public boolean r;
    public boolean s;
    public boolean t;
    public boolean u;
    public int v;
    public s w;
    public long x;
    public boolean[] y;
    public boolean[] z;

    public class a implements Runnable {
        public a() {
        }

        /*  JADX ERROR: JadxRuntimeException in pass: InitCodeVariables
            jadx.core.utils.exceptions.JadxRuntimeException: Several immutable types in one variable: [int, boolean], vars: [r5v0 ?, r5v3 ?, r5v5 ?]
            	at jadx.core.dex.visitors.InitCodeVariables.setCodeVarType(InitCodeVariables.java:102)
            	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:78)
            	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:69)
            	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:51)
            	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:32)
            */
        public void run() {
            /*
                r9 = this;
                com.fyber.inneractive.sdk.player.exoplayer2.source.i r0 = com.fyber.inneractive.sdk.player.exoplayer2.source.i.this
                boolean r1 = r0.G
                if (r1 != 0) goto L_0x00af
                boolean r1 = r0.s
                if (r1 != 0) goto L_0x00af
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.m r1 = r0.q
                if (r1 == 0) goto L_0x00af
                boolean r1 = r0.r
                if (r1 != 0) goto L_0x0014
                goto L_0x00af
            L_0x0014:
                android.util.SparseArray<com.fyber.inneractive.sdk.player.exoplayer2.extractor.d> r1 = r0.o
                int r1 = r1.size()
                r2 = 0
                r3 = 0
            L_0x001c:
                if (r3 >= r1) goto L_0x0031
                android.util.SparseArray<com.fyber.inneractive.sdk.player.exoplayer2.extractor.d> r4 = r0.o
                java.lang.Object r4 = r4.valueAt(r3)
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.d r4 = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.d) r4
                com.fyber.inneractive.sdk.player.exoplayer2.i r4 = r4.e()
                if (r4 != 0) goto L_0x002e
                goto L_0x00af
            L_0x002e:
                int r3 = r3 + 1
                goto L_0x001c
            L_0x0031:
                com.fyber.inneractive.sdk.player.exoplayer2.util.d r3 = r0.k
                monitor-enter(r3)
                r3.a = r2     // Catch:{ all -> 0x00ac }
                monitor-exit(r3)
                com.fyber.inneractive.sdk.player.exoplayer2.source.r[] r3 = new com.fyber.inneractive.sdk.player.exoplayer2.source.r[r1]
                boolean[] r4 = new boolean[r1]
                r0.z = r4
                boolean[] r4 = new boolean[r1]
                r0.y = r4
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.m r4 = r0.q
                long r4 = r4.c()
                r0.x = r4
                r4 = 0
            L_0x004a:
                r5 = 1
                if (r4 >= r1) goto L_0x0080
                android.util.SparseArray<com.fyber.inneractive.sdk.player.exoplayer2.extractor.d> r6 = r0.o
                java.lang.Object r6 = r6.valueAt(r4)
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.d r6 = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.d) r6
                com.fyber.inneractive.sdk.player.exoplayer2.i r6 = r6.e()
                com.fyber.inneractive.sdk.player.exoplayer2.source.r r7 = new com.fyber.inneractive.sdk.player.exoplayer2.source.r
                com.fyber.inneractive.sdk.player.exoplayer2.i[] r8 = new com.fyber.inneractive.sdk.player.exoplayer2.i[r5]
                r8[r2] = r6
                r7.<init>(r8)
                r3[r4] = r7
                java.lang.String r6 = r6.f
                boolean r7 = com.fyber.inneractive.sdk.player.exoplayer2.util.h.e(r6)
                if (r7 != 0) goto L_0x0074
                boolean r6 = com.fyber.inneractive.sdk.player.exoplayer2.util.h.d(r6)
                if (r6 == 0) goto L_0x0073
                goto L_0x0074
            L_0x0073:
                r5 = 0
            L_0x0074:
                boolean[] r6 = r0.z
                r6[r4] = r5
                boolean r6 = r0.A
                r5 = r5 | r6
                r0.A = r5
                int r4 = r4 + 1
                goto L_0x004a
            L_0x0080:
                com.fyber.inneractive.sdk.player.exoplayer2.source.s r1 = new com.fyber.inneractive.sdk.player.exoplayer2.source.s
                r1.<init>(r3)
                r0.w = r1
                r0.s = r5
                com.fyber.inneractive.sdk.player.exoplayer2.source.n$a r1 = r0.f
                com.fyber.inneractive.sdk.player.exoplayer2.source.q r2 = new com.fyber.inneractive.sdk.player.exoplayer2.source.q
                long r3 = r0.x
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.m r5 = r0.q
                boolean r5 = r5.a()
                r2.<init>(r3, r5)
                r3 = 0
                r1.a(r2, r3)
                com.fyber.inneractive.sdk.player.exoplayer2.source.m$a r1 = r0.p
                com.fyber.inneractive.sdk.player.exoplayer2.h r1 = (com.fyber.inneractive.sdk.player.exoplayer2.h) r1
                android.os.Handler r1 = r1.f
                r2 = 8
                android.os.Message r0 = r1.obtainMessage(r2, r0)
                r0.sendToTarget()
                goto L_0x00af
            L_0x00ac:
                r0 = move-exception
                monitor-exit(r3)
                throw r0
            L_0x00af:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.exoplayer2.source.i.a.run():void");
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void run() {
            i iVar = i.this;
            if (!iVar.G) {
                ((com.fyber.inneractive.sdk.player.exoplayer2.h) iVar.p).a((p) iVar);
            }
        }
    }

    public final class e implements o {
        public final int a;

        public e(int i) {
            this.a = i;
        }

        public void a() throws IOException {
            i.this.i.c();
        }

        public boolean isReady() {
            i iVar = i.this;
            return iVar.F || (!iVar.i() && !iVar.o.valueAt(this.a).f());
        }

        public int a(j jVar, com.fyber.inneractive.sdk.player.exoplayer2.decoder.b bVar, boolean z) {
            i iVar = i.this;
            int i = this.a;
            if (iVar.u || iVar.i()) {
                return -3;
            }
            return iVar.o.valueAt(i).a(jVar, bVar, z, iVar.F, iVar.C);
        }

        public void a(long j) {
            i iVar = i.this;
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.d valueAt = iVar.o.valueAt(this.a);
            if (!iVar.F || j <= valueAt.d()) {
                valueAt.a(j, true);
            } else {
                valueAt.g();
            }
        }
    }

    public i(Uri uri, g gVar, f[] fVarArr, int i2, Handler handler, l.a aVar, n.a aVar2, com.fyber.inneractive.sdk.player.exoplayer2.upstream.b bVar, String str) {
        this.a = uri;
        this.b = gVar;
        this.c = i2;
        this.d = handler;
        this.e = aVar;
        this.f = aVar2;
        this.g = bVar;
        this.h = str;
        this.j = new d(fVarArr, this);
        this.k = new com.fyber.inneractive.sdk.player.exoplayer2.util.d();
        this.l = new a();
        this.m = new b();
        this.n = new Handler();
        this.D = -9223372036854775807L;
        this.o = new SparseArray<>();
        this.B = -1;
    }

    public void a(x.c cVar, long j2, long j3, boolean z2) {
        c cVar2 = (c) cVar;
        if (this.B == -1) {
            this.B = cVar2.i;
        }
        if (!z2 && this.v > 0) {
            int size = this.o.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.o.valueAt(i2).a(this.y[i2]);
            }
            ((com.fyber.inneractive.sdk.player.exoplayer2.h) this.p).a((p) this);
        }
    }

    public s b() {
        return this.w;
    }

    public void c(long j2) {
    }

    public void e() throws IOException {
        this.i.c();
    }

    public long f() {
        if (!this.u) {
            return -9223372036854775807L;
        }
        this.u = false;
        return this.C;
    }

    public final int g() {
        int size = this.o.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            d.c cVar = this.o.valueAt(i3).c;
            i2 += cVar.j + cVar.i;
        }
        return i2;
    }

    public final long h() {
        int size = this.o.size();
        long j2 = Long.MIN_VALUE;
        for (int i2 = 0; i2 < size; i2++) {
            j2 = Math.max(j2, this.o.valueAt(i2).d());
        }
        return j2;
    }

    public final boolean i() {
        return this.D != -9223372036854775807L;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x005c, code lost:
        r0 = r9.q;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void j() {
        /*
            r9 = this;
            com.fyber.inneractive.sdk.player.exoplayer2.source.i$c r6 = new com.fyber.inneractive.sdk.player.exoplayer2.source.i$c
            android.net.Uri r2 = r9.a
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.g r3 = r9.b
            com.fyber.inneractive.sdk.player.exoplayer2.source.i$d r4 = r9.j
            com.fyber.inneractive.sdk.player.exoplayer2.util.d r5 = r9.k
            r0 = r6
            r1 = r9
            r0.<init>(r2, r3, r4, r5)
            boolean r0 = r9.s
            r1 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r0 == 0) goto L_0x0045
            boolean r0 = r9.i()
            com.fyber.inneractive.sdk.player.exoplayer2.util.a.b(r0)
            long r3 = r9.x
            r0 = 1
            int r5 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r5 == 0) goto L_0x0031
            long r7 = r9.D
            int r5 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r5 < 0) goto L_0x0031
            r9.F = r0
            r9.D = r1
            return
        L_0x0031:
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.m r3 = r9.q
            long r4 = r9.D
            long r3 = r3.a(r4)
            long r7 = r9.D
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.l r5 = r6.e
            r5.a = r3
            r6.h = r7
            r6.g = r0
            r9.D = r1
        L_0x0045:
            int r0 = r9.g()
            r9.E = r0
            int r0 = r9.c
            r3 = -1
            if (r0 != r3) goto L_0x006c
            boolean r0 = r9.s
            if (r0 == 0) goto L_0x006b
            long r3 = r9.B
            r7 = -1
            int r0 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r0 != 0) goto L_0x006b
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.m r0 = r9.q
            if (r0 == 0) goto L_0x0069
            long r3 = r0.c()
            int r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x0069
            goto L_0x006b
        L_0x0069:
            r0 = 6
            goto L_0x006c
        L_0x006b:
            r0 = 3
        L_0x006c:
            com.fyber.inneractive.sdk.player.exoplayer2.upstream.x r1 = r9.i
            r1.a(r6, r9, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.exoplayer2.source.i.j():void");
    }

    public long b(long j2) {
        if (!this.q.a()) {
            j2 = 0;
        }
        this.C = j2;
        int size = this.o.size();
        boolean z2 = !i();
        int i2 = 0;
        while (z2 && i2 < size) {
            if (this.y[i2]) {
                z2 = this.o.valueAt(i2).a(j2, false);
            }
            i2++;
        }
        if (!z2) {
            this.D = j2;
            this.F = false;
            if (this.i.b()) {
                this.i.a();
            } else {
                for (int i3 = 0; i3 < size; i3++) {
                    this.o.valueAt(i3).a(this.y[i3]);
                }
            }
        }
        this.u = false;
        return j2;
    }

    public void c() {
        this.r = true;
        this.n.post(this.l);
    }

    public final class c implements x.c {
        public final Uri a;
        public final g b;
        public final d c;
        public final com.fyber.inneractive.sdk.player.exoplayer2.util.d d;
        public final com.fyber.inneractive.sdk.player.exoplayer2.extractor.l e = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.l();
        public volatile boolean f;
        public boolean g = true;
        public long h;
        public long i = -1;

        public c(Uri uri, g gVar, d dVar, com.fyber.inneractive.sdk.player.exoplayer2.util.d dVar2) {
            this.a = (Uri) com.fyber.inneractive.sdk.player.exoplayer2.util.a.a(uri);
            this.b = (g) com.fyber.inneractive.sdk.player.exoplayer2.util.a.a(gVar);
            this.c = (d) com.fyber.inneractive.sdk.player.exoplayer2.util.a.a(dVar);
            this.d = dVar2;
        }

        public boolean a() {
            return this.f;
        }

        public void b() {
            this.f = true;
        }

        public void load() throws IOException, InterruptedException {
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.b bVar;
            int i2 = 0;
            while (i2 == 0 && !this.f) {
                try {
                    long j2 = this.e.a;
                    g gVar = this.b;
                    com.fyber.inneractive.sdk.player.exoplayer2.upstream.j jVar = r5;
                    com.fyber.inneractive.sdk.player.exoplayer2.upstream.j jVar2 = new com.fyber.inneractive.sdk.player.exoplayer2.upstream.j(this.a, (byte[]) null, j2, j2, -1, i.this.h, 0);
                    long a2 = gVar.a(jVar);
                    this.i = a2;
                    long j3 = j2;
                    if (a2 != -1) {
                        this.i = a2 + j3;
                    }
                    g gVar2 = this.b;
                    bVar = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.b(gVar2, j3, this.i);
                    f a3 = this.c.a(bVar, gVar2.a());
                    if (this.g) {
                        a3.a(j3, this.h);
                        this.g = false;
                    }
                    long j4 = j3;
                    while (i2 == 0 && !this.f) {
                        com.fyber.inneractive.sdk.player.exoplayer2.util.d dVar = this.d;
                        synchronized (dVar) {
                            while (!dVar.a) {
                                dVar.wait();
                            }
                        }
                        i2 = a3.a((com.fyber.inneractive.sdk.player.exoplayer2.extractor.g) bVar, this.e);
                        long j5 = bVar.c;
                        if (j5 > PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED + j4) {
                            com.fyber.inneractive.sdk.player.exoplayer2.util.d dVar2 = this.d;
                            synchronized (dVar2) {
                                try {
                                    dVar2.a = false;
                                } catch (Throwable th) {
                                    th = th;
                                    if (!(i2 == 1 || bVar == null)) {
                                        this.e.a = bVar.c;
                                    }
                                    u.a(this.b);
                                    throw th;
                                }
                            }
                            i iVar = i.this;
                            iVar.n.post(iVar.m);
                            j4 = j5;
                        }
                    }
                    if (i2 == 1) {
                        i2 = 0;
                    } else {
                        this.e.a = bVar.c;
                    }
                    u.a(this.b);
                } catch (Throwable th2) {
                    th = th2;
                    bVar = null;
                    this.e.a = bVar.c;
                    u.a(this.b);
                    throw th;
                }
            }
        }
    }

    public static final class d {
        public final f[] a;
        public final h b;
        public f c;

        public d(f[] fVarArr, h hVar) {
            this.a = fVarArr;
            this.b = hVar;
        }

        public f a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.g gVar, Uri uri) throws IOException, InterruptedException {
            f fVar = this.c;
            if (fVar != null) {
                return fVar;
            }
            f[] fVarArr = this.a;
            int length = fVarArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                f fVar2 = fVarArr[i];
                try {
                    if (fVar2.a(gVar)) {
                        this.c = fVar2;
                        ((com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) gVar).e = 0;
                        break;
                    }
                    ((com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) gVar).e = 0;
                    i++;
                } catch (EOFException unused) {
                } catch (Throwable th) {
                    ((com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) gVar).e = 0;
                    throw th;
                }
            }
            f fVar3 = this.c;
            if (fVar3 == null) {
                StringBuilder sb = new StringBuilder("None of the available extractors (");
                f[] fVarArr2 = this.a;
                int i2 = u.a;
                StringBuilder sb2 = new StringBuilder();
                for (int i3 = 0; i3 < fVarArr2.length; i3++) {
                    sb2.append(fVarArr2[i3].getClass().getSimpleName());
                    if (i3 < fVarArr2.length - 1) {
                        sb2.append(", ");
                    }
                }
                sb.append(sb2.toString());
                sb.append(") could read the stream.");
                throw new t(sb.toString(), uri);
            }
            fVar3.a(this.b);
            return this.c;
        }
    }

    public long d() {
        long j2;
        if (this.F) {
            return Long.MIN_VALUE;
        }
        if (i()) {
            return this.D;
        }
        if (this.A) {
            int size = this.o.size();
            j2 = Long.MAX_VALUE;
            for (int i2 = 0; i2 < size; i2++) {
                if (this.z[i2]) {
                    j2 = Math.min(j2, this.o.valueAt(i2).d());
                }
            }
        } else {
            j2 = h();
        }
        return j2 == Long.MIN_VALUE ? this.C : j2;
    }

    public void a(x.c cVar, long j2, long j3) {
        c cVar2 = (c) cVar;
        if (this.B == -1) {
            this.B = cVar2.i;
        }
        this.F = true;
        if (this.x == -9223372036854775807L) {
            long h2 = h();
            this.x = h2 == Long.MIN_VALUE ? 0 : h2 + 10000;
            this.f.a(new q(this.x, this.q.a()), (Object) null);
        }
        ((com.fyber.inneractive.sdk.player.exoplayer2.h) this.p).a((p) this);
    }

    public int a(x.c cVar, long j2, long j3, IOException iOException) {
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.m mVar;
        c cVar2 = (c) cVar;
        if (this.B == -1) {
            this.B = cVar2.i;
        }
        Handler handler = this.d;
        if (!(handler == null || this.e == null)) {
            handler.post(new k(this, iOException));
        }
        if ((iOException instanceof t) || (iOException instanceof v) || ((iOException instanceof t) && iOException.getCause() != null && ((iOException.getCause() instanceof MalformedURLException) || (iOException.getCause() instanceof UnknownHostException)))) {
            return 3;
        }
        int i2 = g() > this.E ? 1 : 0;
        if (this.B == -1 && ((mVar = this.q) == null || mVar.c() == -9223372036854775807L)) {
            this.C = 0;
            this.u = this.s;
            int size = this.o.size();
            for (int i3 = 0; i3 < size; i3++) {
                this.o.valueAt(i3).a(!this.s || this.y[i3]);
            }
            cVar2.e.a = 0;
            cVar2.h = 0;
            cVar2.g = true;
        }
        this.E = g();
        return i2;
    }

    public void a(m.a aVar) {
        this.p = aVar;
        com.fyber.inneractive.sdk.player.exoplayer2.util.d dVar = this.k;
        synchronized (dVar) {
            if (!dVar.a) {
                dVar.a = true;
                dVar.notifyAll();
            }
        }
        j();
    }

    public long a(com.fyber.inneractive.sdk.player.exoplayer2.trackselection.e[] eVarArr, boolean[] zArr, o[] oVarArr, boolean[] zArr2, long j2) {
        com.fyber.inneractive.sdk.player.exoplayer2.trackselection.e eVar;
        com.fyber.inneractive.sdk.player.exoplayer2.util.a.b(this.s);
        for (int i2 = 0; i2 < eVarArr.length; i2++) {
            e eVar2 = oVarArr[i2];
            if (eVar2 != null && (eVarArr[i2] == null || !zArr[i2])) {
                int i3 = eVar2.a;
                com.fyber.inneractive.sdk.player.exoplayer2.util.a.b(this.y[i3]);
                this.v--;
                this.y[i3] = false;
                this.o.valueAt(i3).b();
                oVarArr[i2] = null;
            }
        }
        boolean z2 = false;
        for (int i4 = 0; i4 < eVarArr.length; i4++) {
            if (oVarArr[i4] == null && (eVar = eVarArr[i4]) != null) {
                com.fyber.inneractive.sdk.player.exoplayer2.util.a.b(eVar.f() == 1);
                com.fyber.inneractive.sdk.player.exoplayer2.util.a.b(eVar.b(0) == 0);
                int a2 = this.w.a(eVar.b());
                com.fyber.inneractive.sdk.player.exoplayer2.util.a.b(!this.y[a2]);
                this.v++;
                this.y[a2] = true;
                oVarArr[i4] = new e(a2);
                zArr2[i4] = true;
                z2 = true;
            }
        }
        if (!this.t) {
            int size = this.o.size();
            for (int i5 = 0; i5 < size; i5++) {
                if (!this.y[i5]) {
                    this.o.valueAt(i5).b();
                }
            }
        }
        if (this.v == 0) {
            this.u = false;
            if (this.i.b()) {
                this.i.a();
            }
        } else if (!this.t ? j2 != 0 : z2) {
            j2 = b(j2);
            for (int i6 = 0; i6 < oVarArr.length; i6++) {
                if (oVarArr[i6] != null) {
                    zArr2[i6] = true;
                }
            }
        }
        this.t = true;
        return j2;
    }

    public boolean a(long j2) {
        boolean z2 = false;
        if (this.F || (this.s && this.v == 0)) {
            return false;
        }
        com.fyber.inneractive.sdk.player.exoplayer2.util.d dVar = this.k;
        synchronized (dVar) {
            if (!dVar.a) {
                dVar.a = true;
                dVar.notifyAll();
                z2 = true;
            }
        }
        if (this.i.b()) {
            return z2;
        }
        j();
        return true;
    }

    public long a() {
        if (this.v == 0) {
            return Long.MIN_VALUE;
        }
        return d();
    }

    public com.fyber.inneractive.sdk.player.exoplayer2.extractor.n a(int i2, int i3) {
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.d dVar = this.o.get(i2);
        if (dVar != null) {
            return dVar;
        }
        com.fyber.inneractive.sdk.player.exoplayer2.extractor.d dVar2 = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.d(this.g);
        dVar2.n = this;
        this.o.put(i2, dVar2);
        return dVar2;
    }

    public void a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.m mVar) {
        this.q = mVar;
        this.n.post(this.l);
    }

    public void a(com.fyber.inneractive.sdk.player.exoplayer2.i iVar) {
        this.n.post(this.l);
    }
}
