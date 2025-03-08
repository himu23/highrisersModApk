package com.fyber.inneractive.sdk.player.exoplayer2;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.util.Pair;
import com.fyber.inneractive.sdk.player.exoplayer2.e;
import com.fyber.inneractive.sdk.player.exoplayer2.p;
import com.fyber.inneractive.sdk.player.exoplayer2.source.m;
import com.fyber.inneractive.sdk.player.exoplayer2.source.n;
import com.fyber.inneractive.sdk.player.exoplayer2.source.o;
import com.fyber.inneractive.sdk.player.exoplayer2.source.s;
import com.fyber.inneractive.sdk.player.exoplayer2.trackselection.e;
import com.fyber.inneractive.sdk.player.exoplayer2.trackselection.f;
import com.fyber.inneractive.sdk.player.exoplayer2.trackselection.g;
import com.fyber.inneractive.sdk.player.exoplayer2.upstream.k;
import com.fyber.inneractive.sdk.player.exoplayer2.util.q;
import com.fyber.inneractive.sdk.player.exoplayer2.util.u;
import java.io.IOException;

public final class h implements Handler.Callback, m.a, n.a {
    public c A;
    public long B;
    public a C;
    public a D;
    public a E;
    public p F;
    public final n[] a;
    public final a[] b;
    public final g c;
    public final c d;
    public final q e;
    public final Handler f;
    public final HandlerThread g;
    public final Handler h;
    public final e i;
    public final p.c j;
    public final p.b k;
    public b l;
    public m m;
    public n n;
    public com.fyber.inneractive.sdk.player.exoplayer2.util.g o;
    public n p;
    public n[] q;
    public boolean r;
    public boolean s;
    public boolean t;
    public boolean u;
    public int v = 1;
    public int w;
    public int x;
    public long y;
    public int z;

    public static final class a {
        public final m a;
        public final Object b;
        public final o[] c;
        public final boolean[] d;
        public final long e;
        public int f;
        public long g;
        public boolean h;
        public boolean i;
        public boolean j;
        public a k;
        public boolean l;
        public com.fyber.inneractive.sdk.player.exoplayer2.trackselection.h m;
        public final n[] n;
        public final a[] o;
        public final g p;
        public final c q;
        public final n r;
        public com.fyber.inneractive.sdk.player.exoplayer2.trackselection.h s;

        public a(n[] nVarArr, a[] aVarArr, long j2, g gVar, c cVar, n nVar, Object obj, int i2, boolean z, long j3) {
            this.n = nVarArr;
            this.o = aVarArr;
            this.e = j2;
            this.p = gVar;
            this.q = cVar;
            this.r = nVar;
            this.b = com.fyber.inneractive.sdk.player.exoplayer2.util.a.a(obj);
            this.f = i2;
            this.h = z;
            this.g = j3;
            this.c = new o[nVarArr.length];
            this.d = new boolean[nVarArr.length];
            this.a = nVar.a(i2, cVar.a(), j3);
        }

        public long a() {
            return this.e - this.g;
        }

        public long a(long j2) {
            return Math.abs(j2 - a());
        }

        public void c() {
            try {
                this.r.a(this.a);
            } catch (RuntimeException e2) {
                Log.e("ExoPlayerImplInternal", "Period release failed.", e2);
            }
        }

        public boolean b() {
            return this.i && (!this.j || this.a.d() == Long.MIN_VALUE);
        }

        public boolean d() throws d {
            com.fyber.inneractive.sdk.player.exoplayer2.trackselection.h a2 = this.p.a(this.o, this.a.b());
            com.fyber.inneractive.sdk.player.exoplayer2.trackselection.h hVar = this.s;
            a2.getClass();
            if (hVar != null) {
                int i2 = 0;
                while (i2 < a2.b.a) {
                    if (a2.a(hVar, i2)) {
                        i2++;
                    }
                }
                return false;
            }
            this.m = a2;
            return true;
        }

        public long a(long j2, boolean z, boolean[] zArr) {
            int i2;
            f fVar = this.m.b;
            boolean z2 = false;
            int i3 = 0;
            while (true) {
                boolean z3 = true;
                if (i3 >= fVar.a) {
                    break;
                }
                boolean[] zArr2 = this.d;
                if (z || !this.m.a(this.s, i3)) {
                    z3 = false;
                }
                zArr2[i3] = z3;
                i3++;
            }
            long a2 = this.a.a((e[]) fVar.b.clone(), this.d, this.c, zArr, j2);
            this.s = this.m;
            this.j = false;
            int i4 = 0;
            while (true) {
                o[] oVarArr = this.c;
                if (i4 >= oVarArr.length) {
                    break;
                }
                if (oVarArr[i4] != null) {
                    com.fyber.inneractive.sdk.player.exoplayer2.util.a.b(fVar.b[i4] != null);
                    this.j = true;
                } else {
                    com.fyber.inneractive.sdk.player.exoplayer2.util.a.b(fVar.b[i4] == null);
                }
                i4++;
            }
            c cVar = this.q;
            n[] nVarArr = this.n;
            s sVar = this.m.a;
            cVar.f = 0;
            for (int i5 = 0; i5 < nVarArr.length; i5++) {
                if (fVar.b[i5] != null) {
                    int i6 = cVar.f;
                    int k2 = nVarArr[i5].k();
                    int i7 = u.a;
                    if (k2 == 0) {
                        i2 = 16777216;
                    } else if (k2 == 1) {
                        i2 = 3538944;
                    } else if (k2 == 2) {
                        i2 = 13107200;
                    } else if (k2 == 3 || k2 == 4) {
                        i2 = 131072;
                    } else {
                        throw new IllegalStateException();
                    }
                    cVar.f = i6 + i2;
                }
            }
            k kVar = cVar.a;
            int i8 = cVar.f;
            synchronized (kVar) {
                if (i8 < kVar.e) {
                    z2 = true;
                }
                kVar.e = i8;
                if (z2) {
                    kVar.b();
                }
            }
            return a2;
        }
    }

    public static final class b {
        public final int a;
        public final long b;
        public volatile long c;
        public volatile long d;

        public b(int i, long j) {
            this.a = i;
            this.b = j;
            this.c = j;
            this.d = j;
        }
    }

    public static final class c {
        public final p a;
        public final int b;
        public final long c;

        public c(p pVar, int i, long j) {
            this.a = pVar;
            this.b = i;
            this.c = j;
        }
    }

    public static final class d {
        public final p a;
        public final Object b;
        public final b c;
        public final int d;

        public d(p pVar, Object obj, b bVar, int i) {
            this.a = pVar;
            this.b = obj;
            this.c = bVar;
            this.d = i;
        }
    }

    public h(n[] nVarArr, g gVar, c cVar, boolean z2, Handler handler, b bVar, e eVar) {
        this.a = nVarArr;
        this.c = gVar;
        this.d = cVar;
        this.s = z2;
        this.h = handler;
        this.l = bVar;
        this.i = eVar;
        this.b = new a[nVarArr.length];
        for (int i2 = 0; i2 < nVarArr.length; i2++) {
            nVarArr[i2].a(i2);
            this.b[i2] = nVarArr[i2].m();
        }
        this.e = new q();
        this.q = new n[0];
        this.j = new p.c();
        this.k = new p.b();
        this.m = m.d;
        HandlerThread handlerThread = new HandlerThread("ExoPlayerImplInternal:Handler", -16);
        this.g = handlerThread;
        handlerThread.start();
        this.f = new Handler(handlerThread.getLooper(), this);
    }

    public void a(com.fyber.inneractive.sdk.player.exoplayer2.source.p pVar) {
        this.f.obtainMessage(9, (m) pVar).sendToTarget();
    }

    public final void g() {
        b(true);
        this.d.a(true);
        a(1);
    }

    public boolean handleMessage(Message message) {
        try {
            switch (message.what) {
                case 0:
                    a((n) message.obj, message.arg1 != 0);
                    return true;
                case 1:
                    d(message.arg1 != 0);
                    return true;
                case 2:
                    a();
                    return true;
                case 3:
                    b((c) message.obj);
                    return true;
                case 4:
                    a((m) message.obj);
                    return true;
                case 5:
                    g();
                    return true;
                case 6:
                    d();
                    return true;
                case 7:
                    a((Pair<p, Object>) (Pair) message.obj);
                    return true;
                case 8:
                    a((m) message.obj);
                    return true;
                case 9:
                    m mVar = (m) message.obj;
                    a aVar = this.C;
                    if (aVar != null) {
                        if (aVar.a == mVar) {
                            b();
                        }
                    }
                    return true;
                case 10:
                    e();
                    return true;
                case 11:
                    a((e.c[]) message.obj);
                    return true;
                default:
                    return false;
            }
        } catch (d e2) {
            Log.e("ExoPlayerImplInternal", "Renderer error.", e2);
            this.h.obtainMessage(8, e2).sendToTarget();
            g();
            return true;
        } catch (IOException e3) {
            Log.e("ExoPlayerImplInternal", "Source error.", e3);
            this.h.obtainMessage(8, new d(0, (String) null, e3, -1)).sendToTarget();
            g();
            return true;
        } catch (RuntimeException e4) {
            Log.e("ExoPlayerImplInternal", "Internal runtime error.", e4);
            this.h.obtainMessage(8, new d(2, (String) null, e4, -1)).sendToTarget();
            g();
            return true;
        }
    }

    public final void h() throws d {
        q qVar = this.e;
        if (qVar.a) {
            qVar.a(qVar.o());
            qVar.a = false;
        }
        for (n a2 : this.q) {
            a(a2);
        }
    }

    public void a(p pVar, Object obj) {
        this.f.obtainMessage(7, Pair.create(pVar, obj)).sendToTarget();
    }

    public final void c(boolean z2) {
        if (this.u != z2) {
            this.u = z2;
            this.h.obtainMessage(2, z2 ? 1 : 0, 0).sendToTarget();
        }
    }

    public final void f() throws d {
        this.t = false;
        q qVar = this.e;
        if (!qVar.a) {
            qVar.c = SystemClock.elapsedRealtime();
            qVar.a = true;
        }
        for (n f2 : this.q) {
            f2.f();
        }
    }

    public final void c() throws IOException {
        a aVar = this.C;
        if (aVar != null && !aVar.i) {
            a aVar2 = this.D;
            if (aVar2 == null || aVar2.k == aVar) {
                n[] nVarArr = this.q;
                int length = nVarArr.length;
                int i2 = 0;
                while (i2 < length) {
                    if (nVarArr[i2].g()) {
                        i2++;
                    } else {
                        return;
                    }
                }
                this.C.a.e();
            }
        }
    }

    public final void d(boolean z2) throws d {
        this.t = false;
        this.s = z2;
        if (!z2) {
            h();
            i();
            b(false);
            return;
        }
        int i2 = this.v;
        if (i2 == 3) {
            f();
            this.f.sendEmptyMessage(2);
        } else if (i2 == 2) {
            this.f.sendEmptyMessage(2);
        }
    }

    public final void a(int i2) {
        if (this.v != i2) {
            this.v = i2;
            this.h.obtainMessage(1, i2, 0).sendToTarget();
        }
    }

    public final void i() throws d {
        long j2;
        a aVar = this.E;
        if (aVar != null) {
            long f2 = aVar.a.f();
            if (f2 != -9223372036854775807L) {
                b(f2);
            } else {
                n nVar = this.n;
                if (nVar == null || nVar.b()) {
                    this.B = this.e.o();
                } else {
                    long o2 = this.o.o();
                    this.B = o2;
                    this.e.a(o2);
                }
                f2 = this.E.a(this.B);
            }
            this.l.c = f2;
            this.y = SystemClock.elapsedRealtime() * 1000;
            if (this.q.length == 0) {
                j2 = Long.MIN_VALUE;
            } else {
                j2 = this.E.a.d();
            }
            b bVar = this.l;
            if (j2 == Long.MIN_VALUE) {
                j2 = this.F.a(this.E.f, this.k, false).d;
            }
            bVar.d = j2;
        }
    }

    public final void a(n nVar, boolean z2) {
        this.h.sendEmptyMessage(0);
        b(true);
        this.d.a(false);
        if (z2) {
            this.l = new b(0, -9223372036854775807L);
        }
        this.p = nVar;
        nVar.a(this.i, true, (n.a) this);
        a(2);
        this.f.sendEmptyMessage(2);
    }

    public final void b(c cVar) throws d {
        int i2 = 1;
        if (this.F == null) {
            this.z++;
            this.A = cVar;
            return;
        }
        Pair<Integer, Long> a2 = a(cVar);
        if (a2 == null) {
            b bVar = new b(0, 0);
            this.l = bVar;
            this.h.obtainMessage(4, 1, 0, bVar).sendToTarget();
            this.l = new b(0, -9223372036854775807L);
            a(4);
            b(false);
            return;
        }
        int i3 = cVar.c == -9223372036854775807L ? 1 : 0;
        int intValue = ((Integer) a2.first).intValue();
        long longValue = ((Long) a2.second).longValue();
        try {
            b bVar2 = this.l;
            if (intValue != bVar2.a || longValue / 1000 != bVar2.c / 1000) {
                long b2 = b(intValue, longValue);
                if (longValue == b2) {
                    i2 = 0;
                }
                b bVar3 = new b(intValue, b2);
                this.l = bVar3;
                this.h.obtainMessage(4, i3 | i2, 0, bVar3).sendToTarget();
            }
        } finally {
            b bVar4 = new b(intValue, longValue);
            this.l = bVar4;
            this.h.obtainMessage(4, i3, 0, bVar4).sendToTarget();
        }
    }

    public final void e() throws d {
        a aVar = this.E;
        if (aVar != null) {
            boolean z2 = true;
            while (aVar != null && aVar.i) {
                if (aVar.d()) {
                    if (z2) {
                        a aVar2 = this.D;
                        a aVar3 = this.E;
                        boolean z3 = aVar2 != aVar3;
                        a(aVar3.k);
                        a aVar4 = this.E;
                        aVar4.k = null;
                        this.C = aVar4;
                        this.D = aVar4;
                        boolean[] zArr = new boolean[this.a.length];
                        long a2 = aVar4.a(this.l.c, z3, zArr);
                        if (a2 != this.l.c) {
                            this.l.c = a2;
                            b(a2);
                        }
                        boolean[] zArr2 = new boolean[this.a.length];
                        int i2 = 0;
                        int i3 = 0;
                        while (true) {
                            n[] nVarArr = this.a;
                            if (i2 >= nVarArr.length) {
                                break;
                            }
                            n nVar = nVarArr[i2];
                            zArr2[i2] = nVar.a() != 0;
                            o oVar = this.E.c[i2];
                            if (oVar != null) {
                                i3++;
                            }
                            if (zArr2[i2]) {
                                if (oVar != nVar.n()) {
                                    if (nVar == this.n) {
                                        if (oVar == null) {
                                            this.e.a(this.o);
                                        }
                                        this.o = null;
                                        this.n = null;
                                    }
                                    a(nVar);
                                    nVar.l();
                                } else if (zArr[i2]) {
                                    nVar.a(this.B);
                                }
                            }
                            i2++;
                        }
                        this.h.obtainMessage(3, aVar.m).sendToTarget();
                        a(zArr2, i3);
                    } else {
                        this.C = aVar;
                        for (a aVar5 = aVar.k; aVar5 != null; aVar5 = aVar5.k) {
                            aVar5.c();
                        }
                        a aVar6 = this.C;
                        aVar6.k = null;
                        if (aVar6.i) {
                            long max = Math.max(aVar6.g, aVar6.a(this.B));
                            a aVar7 = this.C;
                            aVar7.a(max, false, new boolean[aVar7.n.length]);
                        }
                    }
                    b();
                    i();
                    this.f.sendEmptyMessage(2);
                    return;
                }
                if (aVar == this.D) {
                    z2 = false;
                }
                aVar = aVar.k;
            }
        }
    }

    public final void d() {
        b(true);
        this.d.a(true);
        a(1);
        synchronized (this) {
            this.r = true;
            notifyAll();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x0145  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0151  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x015a A[LOOP:0: B:55:0x015a->B:59:0x016a, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a() throws com.fyber.inneractive.sdk.player.exoplayer2.d, java.io.IOException {
        /*
            r27 = this;
            r7 = r27
            long r8 = android.os.SystemClock.elapsedRealtime()
            com.fyber.inneractive.sdk.player.exoplayer2.p r0 = r7.F
            r10 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r12 = 0
            r13 = 1
            if (r0 != 0) goto L_0x0018
            com.fyber.inneractive.sdk.player.exoplayer2.source.n r0 = r7.p
            r0.a()
            goto L_0x0253
        L_0x0018:
            com.fyber.inneractive.sdk.player.exoplayer2.h$a r0 = r7.C
            if (r0 != 0) goto L_0x0021
            com.fyber.inneractive.sdk.player.exoplayer2.h$b r0 = r7.l
            int r0 = r0.a
            goto L_0x004f
        L_0x0021:
            int r1 = r0.f
            boolean r2 = r0.h
            if (r2 != 0) goto L_0x013a
            boolean r0 = r0.b()
            if (r0 == 0) goto L_0x013a
            com.fyber.inneractive.sdk.player.exoplayer2.p r0 = r7.F
            com.fyber.inneractive.sdk.player.exoplayer2.p$b r2 = r7.k
            com.fyber.inneractive.sdk.player.exoplayer2.p$b r0 = r0.a(r1, r2, r12)
            long r2 = r0.d
            int r0 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1))
            if (r0 != 0) goto L_0x003d
            goto L_0x013a
        L_0x003d:
            com.fyber.inneractive.sdk.player.exoplayer2.h$a r0 = r7.E
            if (r0 == 0) goto L_0x004a
            int r0 = r0.f
            int r1 = r1 - r0
            r0 = 100
            if (r1 != r0) goto L_0x004a
            goto L_0x013a
        L_0x004a:
            com.fyber.inneractive.sdk.player.exoplayer2.h$a r0 = r7.C
            int r0 = r0.f
            int r0 = r0 + r13
        L_0x004f:
            com.fyber.inneractive.sdk.player.exoplayer2.p r1 = r7.F
            int r1 = r1.a()
            if (r0 < r1) goto L_0x005e
            com.fyber.inneractive.sdk.player.exoplayer2.source.n r0 = r7.p
            r0.a()
            goto L_0x013a
        L_0x005e:
            com.fyber.inneractive.sdk.player.exoplayer2.h$a r1 = r7.C
            if (r1 != 0) goto L_0x0069
            com.fyber.inneractive.sdk.player.exoplayer2.h$b r1 = r7.l
            long r1 = r1.c
            r25 = r1
            goto L_0x00c6
        L_0x0069:
            com.fyber.inneractive.sdk.player.exoplayer2.p r1 = r7.F
            com.fyber.inneractive.sdk.player.exoplayer2.p$b r2 = r7.k
            com.fyber.inneractive.sdk.player.exoplayer2.p$b r1 = r1.a(r0, r2, r12)
            int r2 = r1.c
            com.fyber.inneractive.sdk.player.exoplayer2.p r1 = r7.F
            com.fyber.inneractive.sdk.player.exoplayer2.p$c r3 = r7.j
            com.fyber.inneractive.sdk.player.exoplayer2.p$c r1 = r1.a(r2, r3)
            int r1 = r1.c
            r3 = 0
            if (r0 == r1) goto L_0x0084
            r25 = r3
            goto L_0x00c6
        L_0x0084:
            com.fyber.inneractive.sdk.player.exoplayer2.h$a r0 = r7.C
            long r0 = r0.a()
            com.fyber.inneractive.sdk.player.exoplayer2.p r5 = r7.F
            com.fyber.inneractive.sdk.player.exoplayer2.h$a r6 = r7.C
            int r6 = r6.f
            com.fyber.inneractive.sdk.player.exoplayer2.p$b r14 = r7.k
            com.fyber.inneractive.sdk.player.exoplayer2.p$b r5 = r5.a(r6, r14, r12)
            long r5 = r5.d
            long r0 = r0 + r5
            long r5 = r7.B
            long r0 = r0 - r5
            com.fyber.inneractive.sdk.player.exoplayer2.p r5 = r7.F
            long r14 = java.lang.Math.max(r3, r0)
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r0 = r27
            r1 = r5
            r5 = r14
            android.util.Pair r0 = r0.a(r1, r2, r3, r5)
            if (r0 != 0) goto L_0x00b3
            goto L_0x013a
        L_0x00b3:
            java.lang.Object r1 = r0.first
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            java.lang.Object r0 = r0.second
            java.lang.Long r0 = (java.lang.Long) r0
            long r2 = r0.longValue()
            r0 = r1
            r25 = r2
        L_0x00c6:
            com.fyber.inneractive.sdk.player.exoplayer2.h$a r1 = r7.C
            if (r1 != 0) goto L_0x00d0
            r1 = 60000000(0x3938700, double:2.96439388E-316)
            long r1 = r25 + r1
            goto L_0x00e3
        L_0x00d0:
            long r1 = r1.a()
            com.fyber.inneractive.sdk.player.exoplayer2.p r3 = r7.F
            com.fyber.inneractive.sdk.player.exoplayer2.h$a r4 = r7.C
            int r4 = r4.f
            com.fyber.inneractive.sdk.player.exoplayer2.p$b r5 = r7.k
            com.fyber.inneractive.sdk.player.exoplayer2.p$b r3 = r3.a(r4, r5, r12)
            long r3 = r3.d
            long r1 = r1 + r3
        L_0x00e3:
            r17 = r1
            com.fyber.inneractive.sdk.player.exoplayer2.p r1 = r7.F
            com.fyber.inneractive.sdk.player.exoplayer2.p$b r2 = r7.k
            r1.a(r0, r2, r13)
            com.fyber.inneractive.sdk.player.exoplayer2.p r1 = r7.F
            int r1 = r1.a()
            int r1 = r1 - r13
            if (r0 != r1) goto L_0x0108
            com.fyber.inneractive.sdk.player.exoplayer2.p r1 = r7.F
            com.fyber.inneractive.sdk.player.exoplayer2.p$b r2 = r7.k
            int r2 = r2.c
            com.fyber.inneractive.sdk.player.exoplayer2.p$c r3 = r7.j
            com.fyber.inneractive.sdk.player.exoplayer2.p$c r1 = r1.a(r2, r3)
            boolean r1 = r1.b
            if (r1 != 0) goto L_0x0108
            r24 = 1
            goto L_0x010a
        L_0x0108:
            r24 = 0
        L_0x010a:
            com.fyber.inneractive.sdk.player.exoplayer2.h$a r1 = new com.fyber.inneractive.sdk.player.exoplayer2.h$a
            com.fyber.inneractive.sdk.player.exoplayer2.n[] r15 = r7.a
            com.fyber.inneractive.sdk.player.exoplayer2.a[] r2 = r7.b
            com.fyber.inneractive.sdk.player.exoplayer2.trackselection.g r3 = r7.c
            com.fyber.inneractive.sdk.player.exoplayer2.c r4 = r7.d
            com.fyber.inneractive.sdk.player.exoplayer2.source.n r5 = r7.p
            com.fyber.inneractive.sdk.player.exoplayer2.p$b r6 = r7.k
            java.lang.Object r6 = r6.b
            r14 = r1
            r16 = r2
            r19 = r3
            r20 = r4
            r21 = r5
            r22 = r6
            r23 = r0
            r14.<init>(r15, r16, r17, r19, r20, r21, r22, r23, r24, r25)
            com.fyber.inneractive.sdk.player.exoplayer2.h$a r0 = r7.C
            if (r0 == 0) goto L_0x0130
            r0.k = r1
        L_0x0130:
            r7.C = r1
            com.fyber.inneractive.sdk.player.exoplayer2.source.m r0 = r1.a
            r0.a((com.fyber.inneractive.sdk.player.exoplayer2.source.m.a) r7)
            r7.c(r13)
        L_0x013a:
            com.fyber.inneractive.sdk.player.exoplayer2.h$a r0 = r7.C
            if (r0 == 0) goto L_0x0151
            boolean r0 = r0.b()
            if (r0 == 0) goto L_0x0145
            goto L_0x0151
        L_0x0145:
            com.fyber.inneractive.sdk.player.exoplayer2.h$a r0 = r7.C
            if (r0 == 0) goto L_0x0154
            boolean r0 = r0.l
            if (r0 == 0) goto L_0x0154
            r27.b()
            goto L_0x0154
        L_0x0151:
            r7.c(r12)
        L_0x0154:
            com.fyber.inneractive.sdk.player.exoplayer2.h$a r0 = r7.E
            if (r0 != 0) goto L_0x015a
            goto L_0x0253
        L_0x015a:
            com.fyber.inneractive.sdk.player.exoplayer2.h$a r0 = r7.E
            com.fyber.inneractive.sdk.player.exoplayer2.h$a r1 = r7.D
            if (r0 == r1) goto L_0x0191
            long r2 = r7.B
            com.fyber.inneractive.sdk.player.exoplayer2.h$a r4 = r0.k
            long r4 = r4.e
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 < 0) goto L_0x0191
            r0.c()
            com.fyber.inneractive.sdk.player.exoplayer2.h$a r0 = r7.E
            com.fyber.inneractive.sdk.player.exoplayer2.h$a r0 = r0.k
            r7.b((com.fyber.inneractive.sdk.player.exoplayer2.h.a) r0)
            com.fyber.inneractive.sdk.player.exoplayer2.h$b r0 = new com.fyber.inneractive.sdk.player.exoplayer2.h$b
            com.fyber.inneractive.sdk.player.exoplayer2.h$a r1 = r7.E
            int r2 = r1.f
            long r3 = r1.g
            r0.<init>(r2, r3)
            r7.l = r0
            r27.i()
            android.os.Handler r0 = r7.h
            com.fyber.inneractive.sdk.player.exoplayer2.h$b r1 = r7.l
            r2 = 5
            android.os.Message r0 = r0.obtainMessage(r2, r1)
            r0.sendToTarget()
            goto L_0x015a
        L_0x0191:
            boolean r0 = r1.h
            if (r0 == 0) goto L_0x01b7
            r0 = 0
        L_0x0196:
            com.fyber.inneractive.sdk.player.exoplayer2.n[] r1 = r7.a
            int r2 = r1.length
            if (r0 >= r2) goto L_0x0253
            r1 = r1[r0]
            com.fyber.inneractive.sdk.player.exoplayer2.h$a r2 = r7.D
            com.fyber.inneractive.sdk.player.exoplayer2.source.o[] r2 = r2.c
            r2 = r2[r0]
            if (r2 == 0) goto L_0x01b4
            com.fyber.inneractive.sdk.player.exoplayer2.source.o r3 = r1.n()
            if (r3 != r2) goto L_0x01b4
            boolean r2 = r1.g()
            if (r2 == 0) goto L_0x01b4
            r1.c()
        L_0x01b4:
            int r0 = r0 + 1
            goto L_0x0196
        L_0x01b7:
            r0 = 0
        L_0x01b8:
            com.fyber.inneractive.sdk.player.exoplayer2.n[] r1 = r7.a
            int r2 = r1.length
            if (r0 >= r2) goto L_0x01d8
            r1 = r1[r0]
            com.fyber.inneractive.sdk.player.exoplayer2.h$a r2 = r7.D
            com.fyber.inneractive.sdk.player.exoplayer2.source.o[] r2 = r2.c
            r2 = r2[r0]
            com.fyber.inneractive.sdk.player.exoplayer2.source.o r3 = r1.n()
            if (r3 != r2) goto L_0x0253
            if (r2 == 0) goto L_0x01d5
            boolean r1 = r1.g()
            if (r1 != 0) goto L_0x01d5
            goto L_0x0253
        L_0x01d5:
            int r0 = r0 + 1
            goto L_0x01b8
        L_0x01d8:
            com.fyber.inneractive.sdk.player.exoplayer2.h$a r0 = r7.D
            com.fyber.inneractive.sdk.player.exoplayer2.h$a r1 = r0.k
            if (r1 == 0) goto L_0x0253
            boolean r2 = r1.i
            if (r2 == 0) goto L_0x0253
            com.fyber.inneractive.sdk.player.exoplayer2.trackselection.h r0 = r0.m
            r7.D = r1
            com.fyber.inneractive.sdk.player.exoplayer2.trackselection.h r2 = r1.m
            com.fyber.inneractive.sdk.player.exoplayer2.source.m r1 = r1.a
            long r3 = r1.f()
            int r1 = (r3 > r10 ? 1 : (r3 == r10 ? 0 : -1))
            if (r1 == 0) goto L_0x01f4
            r1 = 1
            goto L_0x01f5
        L_0x01f4:
            r1 = 0
        L_0x01f5:
            r3 = 0
        L_0x01f6:
            com.fyber.inneractive.sdk.player.exoplayer2.n[] r4 = r7.a
            int r5 = r4.length
            if (r3 >= r5) goto L_0x0253
            r4 = r4[r3]
            com.fyber.inneractive.sdk.player.exoplayer2.trackselection.f r5 = r0.b
            com.fyber.inneractive.sdk.player.exoplayer2.trackselection.e[] r5 = r5.b
            r5 = r5[r3]
            if (r5 != 0) goto L_0x0206
            goto L_0x024b
        L_0x0206:
            if (r1 == 0) goto L_0x020c
            r4.c()
            goto L_0x024b
        L_0x020c:
            boolean r5 = r4.h()
            if (r5 != 0) goto L_0x024b
            com.fyber.inneractive.sdk.player.exoplayer2.trackselection.f r5 = r2.b
            com.fyber.inneractive.sdk.player.exoplayer2.trackselection.e[] r5 = r5.b
            r5 = r5[r3]
            com.fyber.inneractive.sdk.player.exoplayer2.o[] r6 = r0.d
            r6 = r6[r3]
            com.fyber.inneractive.sdk.player.exoplayer2.o[] r14 = r2.d
            r14 = r14[r3]
            if (r5 == 0) goto L_0x0248
            boolean r6 = r14.equals(r6)
            if (r6 == 0) goto L_0x0248
            int r6 = r5.f()
            com.fyber.inneractive.sdk.player.exoplayer2.i[] r14 = new com.fyber.inneractive.sdk.player.exoplayer2.i[r6]
            r15 = 0
        L_0x022f:
            if (r15 >= r6) goto L_0x023a
            com.fyber.inneractive.sdk.player.exoplayer2.i r16 = r5.a((int) r15)
            r14[r15] = r16
            int r15 = r15 + 1
            goto L_0x022f
        L_0x023a:
            com.fyber.inneractive.sdk.player.exoplayer2.h$a r5 = r7.D
            com.fyber.inneractive.sdk.player.exoplayer2.source.o[] r6 = r5.c
            r6 = r6[r3]
            long r10 = r5.a()
            r4.a(r14, r6, r10)
            goto L_0x024b
        L_0x0248:
            r4.c()
        L_0x024b:
            int r3 = r3 + 1
            r10 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            goto L_0x01f6
        L_0x0253:
            com.fyber.inneractive.sdk.player.exoplayer2.h$a r0 = r7.E
            r1 = 10
            if (r0 != 0) goto L_0x0260
            r27.c()
            r7.a((long) r8, (long) r1)
            return
        L_0x0260:
            java.lang.String r0 = "doSomeWork"
            com.fyber.inneractive.sdk.player.exoplayer2.util.s.a(r0)
            r27.i()
            com.fyber.inneractive.sdk.player.exoplayer2.h$a r0 = r7.E
            com.fyber.inneractive.sdk.player.exoplayer2.source.m r0 = r0.a
            com.fyber.inneractive.sdk.player.exoplayer2.h$b r3 = r7.l
            long r3 = r3.c
            r0.c(r3)
            com.fyber.inneractive.sdk.player.exoplayer2.n[] r0 = r7.q
            int r3 = r0.length
            r4 = 0
            r5 = 1
            r6 = 1
        L_0x0279:
            if (r4 >= r3) goto L_0x02b1
            r10 = r0[r4]
            long r13 = r7.B
            long r1 = r7.y
            r10.a(r13, r1)
            if (r6 == 0) goto L_0x028e
            boolean r1 = r10.b()
            if (r1 == 0) goto L_0x028e
            r6 = 1
            goto L_0x028f
        L_0x028e:
            r6 = 0
        L_0x028f:
            boolean r1 = r10.isReady()
            if (r1 != 0) goto L_0x029e
            boolean r1 = r10.b()
            if (r1 == 0) goto L_0x029c
            goto L_0x029e
        L_0x029c:
            r1 = 0
            goto L_0x029f
        L_0x029e:
            r1 = 1
        L_0x029f:
            if (r1 != 0) goto L_0x02a4
            r10.e()
        L_0x02a4:
            if (r5 == 0) goto L_0x02aa
            if (r1 == 0) goto L_0x02aa
            r5 = 1
            goto L_0x02ab
        L_0x02aa:
            r5 = 0
        L_0x02ab:
            int r4 = r4 + 1
            r1 = 10
            r13 = 1
            goto L_0x0279
        L_0x02b1:
            if (r5 != 0) goto L_0x02b6
            r27.c()
        L_0x02b6:
            com.fyber.inneractive.sdk.player.exoplayer2.util.g r0 = r7.o
            if (r0 == 0) goto L_0x02d9
            com.fyber.inneractive.sdk.player.exoplayer2.m r0 = r0.i()
            com.fyber.inneractive.sdk.player.exoplayer2.m r1 = r7.m
            boolean r1 = r0.equals(r1)
            if (r1 != 0) goto L_0x02d9
            r7.m = r0
            com.fyber.inneractive.sdk.player.exoplayer2.util.q r1 = r7.e
            com.fyber.inneractive.sdk.player.exoplayer2.util.g r2 = r7.o
            r1.a((com.fyber.inneractive.sdk.player.exoplayer2.util.g) r2)
            android.os.Handler r1 = r7.h
            r2 = 7
            android.os.Message r0 = r1.obtainMessage(r2, r0)
            r0.sendToTarget()
        L_0x02d9:
            com.fyber.inneractive.sdk.player.exoplayer2.p r0 = r7.F
            com.fyber.inneractive.sdk.player.exoplayer2.h$a r1 = r7.E
            int r1 = r1.f
            com.fyber.inneractive.sdk.player.exoplayer2.p$b r2 = r7.k
            com.fyber.inneractive.sdk.player.exoplayer2.p$b r0 = r0.a(r1, r2, r12)
            long r0 = r0.d
            r2 = 3
            r3 = 2
            if (r6 == 0) goto L_0x030a
            r10 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r4 = (r0 > r10 ? 1 : (r0 == r10 ? 0 : -1))
            if (r4 == 0) goto L_0x02fc
            com.fyber.inneractive.sdk.player.exoplayer2.h$b r4 = r7.l
            long r10 = r4.c
            int r4 = (r0 > r10 ? 1 : (r0 == r10 ? 0 : -1))
            if (r4 > 0) goto L_0x030a
        L_0x02fc:
            com.fyber.inneractive.sdk.player.exoplayer2.h$a r4 = r7.E
            boolean r4 = r4.h
            if (r4 == 0) goto L_0x030a
            r0 = 4
            r7.a((int) r0)
            r27.h()
            goto L_0x0347
        L_0x030a:
            int r4 = r7.v
            if (r4 != r3) goto L_0x032f
            com.fyber.inneractive.sdk.player.exoplayer2.n[] r4 = r7.q
            int r4 = r4.length
            if (r4 <= 0) goto L_0x031e
            if (r5 == 0) goto L_0x0347
            boolean r0 = r7.t
            boolean r0 = r7.a((boolean) r0)
            if (r0 == 0) goto L_0x0347
            goto L_0x0324
        L_0x031e:
            boolean r0 = r7.a((long) r0)
            if (r0 == 0) goto L_0x0347
        L_0x0324:
            r7.a((int) r2)
            boolean r0 = r7.s
            if (r0 == 0) goto L_0x0347
            r27.f()
            goto L_0x0347
        L_0x032f:
            if (r4 != r2) goto L_0x0347
            com.fyber.inneractive.sdk.player.exoplayer2.n[] r4 = r7.q
            int r4 = r4.length
            if (r4 <= 0) goto L_0x0337
            goto L_0x033b
        L_0x0337:
            boolean r5 = r7.a((long) r0)
        L_0x033b:
            if (r5 != 0) goto L_0x0347
            boolean r0 = r7.s
            r7.t = r0
            r7.a((int) r3)
            r27.h()
        L_0x0347:
            int r0 = r7.v
            if (r0 != r3) goto L_0x0358
            com.fyber.inneractive.sdk.player.exoplayer2.n[] r0 = r7.q
            int r1 = r0.length
        L_0x034e:
            if (r12 >= r1) goto L_0x0358
            r4 = r0[r12]
            r4.e()
            int r12 = r12 + 1
            goto L_0x034e
        L_0x0358:
            boolean r0 = r7.s
            if (r0 == 0) goto L_0x0360
            int r0 = r7.v
            if (r0 == r2) goto L_0x0364
        L_0x0360:
            int r0 = r7.v
            if (r0 != r3) goto L_0x036a
        L_0x0364:
            r0 = 10
            r7.a((long) r8, (long) r0)
            goto L_0x037a
        L_0x036a:
            com.fyber.inneractive.sdk.player.exoplayer2.n[] r0 = r7.q
            int r0 = r0.length
            if (r0 == 0) goto L_0x0375
            r0 = 1000(0x3e8, double:4.94E-321)
            r7.a((long) r8, (long) r0)
            goto L_0x037a
        L_0x0375:
            android.os.Handler r0 = r7.f
            r0.removeMessages(r3)
        L_0x037a:
            com.fyber.inneractive.sdk.player.exoplayer2.util.s.a()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.exoplayer2.h.a():void");
    }

    public final long b(int i2, long j2) throws d {
        a aVar;
        h();
        this.t = false;
        a(2);
        a aVar2 = this.E;
        if (aVar2 == null) {
            a aVar3 = this.C;
            if (aVar3 != null) {
                aVar3.c();
            }
            aVar = null;
        } else {
            aVar = null;
            while (aVar2 != null) {
                if (aVar2.f != i2 || !aVar2.i) {
                    aVar2.c();
                } else {
                    aVar = aVar2;
                }
                aVar2 = aVar2.k;
            }
        }
        a aVar4 = this.E;
        if (!(aVar4 == aVar && aVar4 == this.D)) {
            for (n l2 : this.q) {
                l2.l();
            }
            this.q = new n[0];
            this.o = null;
            this.n = null;
            this.E = null;
        }
        if (aVar != null) {
            aVar.k = null;
            this.C = aVar;
            this.D = aVar;
            b(aVar);
            a aVar5 = this.E;
            if (aVar5.j) {
                j2 = aVar5.a.b(j2);
            }
            b(j2);
            b();
        } else {
            this.C = null;
            this.D = null;
            this.E = null;
            b(j2);
        }
        this.f.sendEmptyMessage(2);
        return j2;
    }

    public final void b(long j2) throws d {
        a aVar = this.E;
        long a2 = j2 + (aVar == null ? 60000000 : aVar.a());
        this.B = a2;
        this.e.a(a2);
        for (n a3 : this.q) {
            a3.a(this.B);
        }
    }

    public final void b(boolean z2) {
        this.f.removeMessages(2);
        this.t = false;
        q qVar = this.e;
        if (qVar.a) {
            qVar.a(qVar.o());
            qVar.a = false;
        }
        this.o = null;
        this.n = null;
        this.B = 60000000;
        for (n nVar : this.q) {
            try {
                a(nVar);
                nVar.l();
            } catch (d | RuntimeException e2) {
                Log.e("ExoPlayerImplInternal", "Stop failed.", e2);
            }
        }
        this.q = new n[0];
        a aVar = this.E;
        if (aVar == null) {
            aVar = this.C;
        }
        a(aVar);
        this.C = null;
        this.D = null;
        this.E = null;
        c(false);
        if (z2) {
            n nVar2 = this.p;
            if (nVar2 != null) {
                nVar2.b();
                this.p = null;
            }
            this.F = null;
        }
    }

    public final void b(Object obj, int i2) {
        this.h.obtainMessage(6, new d(this.F, obj, this.l, i2)).sendToTarget();
    }

    public final void b() {
        long j2;
        a aVar = this.C;
        if (!aVar.i) {
            j2 = 0;
        } else {
            j2 = aVar.a.a();
        }
        if (j2 == Long.MIN_VALUE) {
            c(false);
            return;
        }
        long a2 = this.C.a(this.B);
        boolean a3 = this.d.a(j2 - a2);
        c(a3);
        if (a3) {
            a aVar2 = this.C;
            aVar2.l = false;
            aVar2.a.a(a2);
            return;
        }
        this.C.l = true;
    }

    public final void b(a aVar) throws d {
        if (this.E != aVar) {
            boolean[] zArr = new boolean[this.a.length];
            int i2 = 0;
            int i3 = 0;
            while (true) {
                n[] nVarArr = this.a;
                if (i2 < nVarArr.length) {
                    n nVar = nVarArr[i2];
                    zArr[i2] = nVar.a() != 0;
                    com.fyber.inneractive.sdk.player.exoplayer2.trackselection.e eVar = aVar.m.b.b[i2];
                    if (eVar != null) {
                        i3++;
                    }
                    if (zArr[i2] && (eVar == null || (nVar.h() && nVar.n() == this.E.c[i2]))) {
                        if (nVar == this.n) {
                            this.e.a(this.o);
                            this.o = null;
                            this.n = null;
                        }
                        a(nVar);
                        nVar.l();
                    }
                    i2++;
                } else {
                    this.E = aVar;
                    this.h.obtainMessage(3, aVar.m).sendToTarget();
                    a(zArr, i3);
                    return;
                }
            }
        }
    }

    public final void a(long j2, long j3) {
        this.f.removeMessages(2);
        long elapsedRealtime = (j2 + j3) - SystemClock.elapsedRealtime();
        if (elapsedRealtime <= 0) {
            this.f.sendEmptyMessage(2);
        } else {
            this.f.sendEmptyMessageDelayed(2, elapsedRealtime);
        }
    }

    public final void a(m mVar) {
        com.fyber.inneractive.sdk.player.exoplayer2.util.g gVar = this.o;
        if (gVar != null) {
            mVar = gVar.a(mVar);
        } else {
            q qVar = this.e;
            if (qVar.a) {
                qVar.a(qVar.o());
            }
            qVar.d = mVar;
        }
        this.m = mVar;
        this.h.obtainMessage(7, mVar).sendToTarget();
    }

    public final void a(e.c[] cVarArr) throws d {
        try {
            for (e.c cVar : cVarArr) {
                cVar.a.a(cVar.b, cVar.c);
            }
            if (this.p != null) {
                this.f.sendEmptyMessage(2);
            }
            synchronized (this) {
                this.x++;
                notifyAll();
            }
        } catch (Throwable th) {
            synchronized (this) {
                this.x++;
                notifyAll();
                throw th;
            }
        }
    }

    public final void a(n nVar) throws d {
        if (nVar.a() == 2) {
            nVar.d();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0011, code lost:
        r4 = r3.E.k;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(long r4) {
        /*
            r3 = this;
            r0 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r2 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r2 == 0) goto L_0x001e
            com.fyber.inneractive.sdk.player.exoplayer2.h$b r0 = r3.l
            long r0 = r0.c
            int r2 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r2 < 0) goto L_0x001e
            com.fyber.inneractive.sdk.player.exoplayer2.h$a r4 = r3.E
            com.fyber.inneractive.sdk.player.exoplayer2.h$a r4 = r4.k
            if (r4 == 0) goto L_0x001c
            boolean r4 = r4.i
            if (r4 == 0) goto L_0x001c
            goto L_0x001e
        L_0x001c:
            r4 = 0
            goto L_0x001f
        L_0x001e:
            r4 = 1
        L_0x001f:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.exoplayer2.h.a(long):boolean");
    }

    public final boolean a(boolean z2) {
        long j2;
        a aVar = this.C;
        if (!aVar.i) {
            j2 = aVar.g;
        } else {
            j2 = aVar.a.d();
        }
        if (j2 == Long.MIN_VALUE) {
            a aVar2 = this.C;
            if (aVar2.h) {
                return true;
            }
            j2 = this.F.a(aVar2.f, this.k, false).d;
        }
        c cVar = this.d;
        long a2 = j2 - this.C.a(this.B);
        long j3 = z2 ? cVar.e : cVar.d;
        if (j3 <= 0 || a2 >= j3) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x007c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(android.util.Pair<com.fyber.inneractive.sdk.player.exoplayer2.p, java.lang.Object> r13) throws com.fyber.inneractive.sdk.player.exoplayer2.d {
        /*
            r12 = this;
            com.fyber.inneractive.sdk.player.exoplayer2.p r0 = r12.F
            java.lang.Object r1 = r13.first
            com.fyber.inneractive.sdk.player.exoplayer2.p r1 = (com.fyber.inneractive.sdk.player.exoplayer2.p) r1
            r12.F = r1
            java.lang.Object r13 = r13.second
            r2 = 0
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r5 = 0
            if (r0 != 0) goto L_0x006e
            int r6 = r12.z
            if (r6 <= 0) goto L_0x0041
            com.fyber.inneractive.sdk.player.exoplayer2.h$c r1 = r12.A
            android.util.Pair r1 = r12.a((com.fyber.inneractive.sdk.player.exoplayer2.h.c) r1)
            int r6 = r12.z
            r12.z = r5
            r12.A = r2
            if (r1 != 0) goto L_0x0029
            r12.a((java.lang.Object) r13, (int) r6)
            return
        L_0x0029:
            com.fyber.inneractive.sdk.player.exoplayer2.h$b r7 = new com.fyber.inneractive.sdk.player.exoplayer2.h$b
            java.lang.Object r8 = r1.first
            java.lang.Integer r8 = (java.lang.Integer) r8
            int r8 = r8.intValue()
            java.lang.Object r1 = r1.second
            java.lang.Long r1 = (java.lang.Long) r1
            long r9 = r1.longValue()
            r7.<init>(r8, r9)
            r12.l = r7
            goto L_0x006f
        L_0x0041:
            com.fyber.inneractive.sdk.player.exoplayer2.h$b r6 = r12.l
            long r6 = r6.b
            int r8 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r8 != 0) goto L_0x006e
            boolean r1 = r1.c()
            if (r1 == 0) goto L_0x0053
            r12.a((java.lang.Object) r13, (int) r5)
            return
        L_0x0053:
            android.util.Pair r1 = r12.a((int) r5, (long) r3)
            com.fyber.inneractive.sdk.player.exoplayer2.h$b r6 = new com.fyber.inneractive.sdk.player.exoplayer2.h$b
            java.lang.Object r7 = r1.first
            java.lang.Integer r7 = (java.lang.Integer) r7
            int r7 = r7.intValue()
            java.lang.Object r1 = r1.second
            java.lang.Long r1 = (java.lang.Long) r1
            long r8 = r1.longValue()
            r6.<init>(r7, r8)
            r12.l = r6
        L_0x006e:
            r6 = 0
        L_0x006f:
            com.fyber.inneractive.sdk.player.exoplayer2.h$a r1 = r12.E
            if (r1 == 0) goto L_0x0074
            goto L_0x0076
        L_0x0074:
            com.fyber.inneractive.sdk.player.exoplayer2.h$a r1 = r12.C
        L_0x0076:
            if (r1 != 0) goto L_0x007c
            r12.b((java.lang.Object) r13, (int) r6)
            return
        L_0x007c:
            com.fyber.inneractive.sdk.player.exoplayer2.p r7 = r12.F
            java.lang.Object r8 = r1.b
            int r7 = r7.a(r8)
            r8 = -1
            r9 = 1
            if (r7 != r8) goto L_0x00e2
            int r2 = r1.f
            com.fyber.inneractive.sdk.player.exoplayer2.p r7 = r12.F
            int r0 = r12.a(r2, r0, r7)
            if (r0 != r8) goto L_0x0096
            r12.a((java.lang.Object) r13, (int) r6)
            return
        L_0x0096:
            com.fyber.inneractive.sdk.player.exoplayer2.p r2 = r12.F
            com.fyber.inneractive.sdk.player.exoplayer2.p$b r7 = r12.k
            com.fyber.inneractive.sdk.player.exoplayer2.p$b r0 = r2.a(r0, r7, r5)
            int r0 = r0.c
            android.util.Pair r0 = r12.a((int) r0, (long) r3)
            java.lang.Object r2 = r0.first
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            java.lang.Object r0 = r0.second
            java.lang.Long r0 = (java.lang.Long) r0
            long r3 = r0.longValue()
            com.fyber.inneractive.sdk.player.exoplayer2.p r0 = r12.F
            com.fyber.inneractive.sdk.player.exoplayer2.p$b r5 = r12.k
            r0.a(r2, r5, r9)
            com.fyber.inneractive.sdk.player.exoplayer2.p$b r0 = r12.k
            java.lang.Object r0 = r0.b
            r1.f = r8
        L_0x00c1:
            com.fyber.inneractive.sdk.player.exoplayer2.h$a r1 = r1.k
            if (r1 == 0) goto L_0x00d3
            java.lang.Object r5 = r1.b
            boolean r5 = r5.equals(r0)
            if (r5 == 0) goto L_0x00cf
            r5 = r2
            goto L_0x00d0
        L_0x00cf:
            r5 = -1
        L_0x00d0:
            r1.f = r5
            goto L_0x00c1
        L_0x00d3:
            long r0 = r12.b((int) r2, (long) r3)
            com.fyber.inneractive.sdk.player.exoplayer2.h$b r3 = new com.fyber.inneractive.sdk.player.exoplayer2.h$b
            r3.<init>(r2, r0)
            r12.l = r3
            r12.b((java.lang.Object) r13, (int) r6)
            return
        L_0x00e2:
            com.fyber.inneractive.sdk.player.exoplayer2.p r0 = r12.F
            com.fyber.inneractive.sdk.player.exoplayer2.p$b r3 = r12.k
            r0.a(r7, r3, r5)
            com.fyber.inneractive.sdk.player.exoplayer2.p r0 = r12.F
            int r0 = r0.a()
            int r0 = r0 - r9
            if (r7 != r0) goto L_0x0104
            com.fyber.inneractive.sdk.player.exoplayer2.p r0 = r12.F
            com.fyber.inneractive.sdk.player.exoplayer2.p$b r3 = r12.k
            int r3 = r3.c
            com.fyber.inneractive.sdk.player.exoplayer2.p$c r4 = r12.j
            com.fyber.inneractive.sdk.player.exoplayer2.p$c r0 = r0.a(r3, r4)
            boolean r0 = r0.b
            if (r0 != 0) goto L_0x0104
            r0 = 1
            goto L_0x0105
        L_0x0104:
            r0 = 0
        L_0x0105:
            r1.f = r7
            r1.h = r0
            com.fyber.inneractive.sdk.player.exoplayer2.h$a r0 = r12.D
            if (r1 != r0) goto L_0x010f
            r0 = 1
            goto L_0x0110
        L_0x010f:
            r0 = 0
        L_0x0110:
            com.fyber.inneractive.sdk.player.exoplayer2.h$b r3 = r12.l
            int r4 = r3.a
            if (r7 == r4) goto L_0x0127
            com.fyber.inneractive.sdk.player.exoplayer2.h$b r4 = new com.fyber.inneractive.sdk.player.exoplayer2.h$b
            long r10 = r3.b
            r4.<init>(r7, r10)
            long r10 = r3.c
            r4.c = r10
            long r10 = r3.d
            r4.d = r10
            r12.l = r4
        L_0x0127:
            com.fyber.inneractive.sdk.player.exoplayer2.h$a r3 = r1.k
            if (r3 == 0) goto L_0x0186
            int r7 = r7 + r9
            com.fyber.inneractive.sdk.player.exoplayer2.p r4 = r12.F
            com.fyber.inneractive.sdk.player.exoplayer2.p$b r8 = r12.k
            r4.a(r7, r8, r9)
            com.fyber.inneractive.sdk.player.exoplayer2.p r4 = r12.F
            int r4 = r4.a()
            int r4 = r4 - r9
            if (r7 != r4) goto L_0x014e
            com.fyber.inneractive.sdk.player.exoplayer2.p r4 = r12.F
            com.fyber.inneractive.sdk.player.exoplayer2.p$b r8 = r12.k
            int r8 = r8.c
            com.fyber.inneractive.sdk.player.exoplayer2.p$c r10 = r12.j
            com.fyber.inneractive.sdk.player.exoplayer2.p$c r4 = r4.a(r8, r10)
            boolean r4 = r4.b
            if (r4 != 0) goto L_0x014e
            r4 = 1
            goto L_0x014f
        L_0x014e:
            r4 = 0
        L_0x014f:
            java.lang.Object r8 = r3.b
            com.fyber.inneractive.sdk.player.exoplayer2.p$b r10 = r12.k
            java.lang.Object r10 = r10.b
            boolean r8 = r8.equals(r10)
            if (r8 == 0) goto L_0x0169
            r3.f = r7
            r3.h = r4
            com.fyber.inneractive.sdk.player.exoplayer2.h$a r1 = r12.D
            if (r3 != r1) goto L_0x0165
            r1 = 1
            goto L_0x0166
        L_0x0165:
            r1 = 0
        L_0x0166:
            r0 = r0 | r1
            r1 = r3
            goto L_0x0127
        L_0x0169:
            if (r0 != 0) goto L_0x017f
            com.fyber.inneractive.sdk.player.exoplayer2.h$a r0 = r12.E
            int r0 = r0.f
            com.fyber.inneractive.sdk.player.exoplayer2.h$b r1 = r12.l
            long r1 = r1.c
            long r1 = r12.b((int) r0, (long) r1)
            com.fyber.inneractive.sdk.player.exoplayer2.h$b r3 = new com.fyber.inneractive.sdk.player.exoplayer2.h$b
            r3.<init>(r0, r1)
            r12.l = r3
            goto L_0x0186
        L_0x017f:
            r12.C = r1
            r1.k = r2
            r12.a((com.fyber.inneractive.sdk.player.exoplayer2.h.a) r3)
        L_0x0186:
            r12.b((java.lang.Object) r13, (int) r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.exoplayer2.h.a(android.util.Pair):void");
    }

    public final void a(Object obj, int i2) {
        this.l = new b(0, 0);
        b(obj, i2);
        this.l = new b(0, -9223372036854775807L);
        a(4);
        b(false);
    }

    public final int a(int i2, p pVar, p pVar2) {
        int i3 = -1;
        while (i3 == -1 && i2 < pVar.a() - 1) {
            i2++;
            i3 = pVar2.a(pVar.a(i2, this.k, true).b);
        }
        return i3;
    }

    public final Pair<Integer, Long> a(c cVar) {
        p pVar = cVar.a;
        if (pVar.c()) {
            pVar = this.F;
        }
        try {
            Pair<Integer, Long> a2 = a(pVar, cVar.b, cVar.c, 0);
            p pVar2 = this.F;
            if (pVar2 == pVar) {
                return a2;
            }
            int a3 = pVar2.a(pVar.a(((Integer) a2.first).intValue(), this.k, true).b);
            if (a3 != -1) {
                return Pair.create(Integer.valueOf(a3), a2.second);
            }
            int a4 = a(((Integer) a2.first).intValue(), pVar, this.F);
            if (a4 != -1) {
                return a(this.F.a(a4, this.k, false).c, -9223372036854775807L);
            }
            return null;
        } catch (IndexOutOfBoundsException unused) {
            throw new k(this.F, cVar.b, cVar.c);
        }
    }

    public final Pair<Integer, Long> a(int i2, long j2) {
        return a(this.F, i2, j2, 0);
    }

    public final Pair<Integer, Long> a(p pVar, int i2, long j2, long j3) {
        com.fyber.inneractive.sdk.player.exoplayer2.util.a.a(i2, 0, pVar.b());
        pVar.a(i2, this.j, false, j3);
        if (j2 == -9223372036854775807L) {
            j2 = this.j.e;
            if (j2 == -9223372036854775807L) {
                return null;
            }
        }
        p.c cVar = this.j;
        int i3 = cVar.c;
        long j4 = cVar.g + j2;
        long j5 = pVar.a(i3, this.k, false).d;
        while (j5 != -9223372036854775807L && j4 >= j5 && i3 < this.j.d) {
            j4 -= j5;
            i3++;
            j5 = pVar.a(i3, this.k, false).d;
        }
        return Pair.create(Integer.valueOf(i3), Long.valueOf(j4));
    }

    public final void a(m mVar) throws d {
        a aVar = this.C;
        if (aVar != null && aVar.a == mVar) {
            aVar.i = true;
            aVar.d();
            aVar.g = aVar.a(aVar.g, false, new boolean[aVar.n.length]);
            if (this.E == null) {
                a aVar2 = this.C;
                this.D = aVar2;
                b(aVar2.g);
                b(this.D);
            }
            b();
        }
    }

    public final void a(a aVar) {
        while (aVar != null) {
            aVar.c();
            aVar = aVar.k;
        }
    }

    public final void a(boolean[] zArr, int i2) throws d {
        this.q = new n[i2];
        int i3 = 0;
        int i4 = 0;
        while (true) {
            n[] nVarArr = this.a;
            if (i3 < nVarArr.length) {
                n nVar = nVarArr[i3];
                com.fyber.inneractive.sdk.player.exoplayer2.trackselection.e eVar = this.E.m.b.b[i3];
                if (eVar != null) {
                    int i5 = i4 + 1;
                    this.q[i4] = nVar;
                    if (nVar.a() == 0) {
                        o oVar = this.E.m.d[i3];
                        boolean z2 = this.s && this.v == 3;
                        boolean z3 = !zArr[i3] && z2;
                        int f2 = eVar.f();
                        i[] iVarArr = new i[f2];
                        for (int i6 = 0; i6 < f2; i6++) {
                            iVarArr[i6] = eVar.a(i6);
                        }
                        a aVar = this.E;
                        nVar.a(oVar, iVarArr, aVar.c[i3], this.B, z3, aVar.a());
                        com.fyber.inneractive.sdk.player.exoplayer2.util.g j2 = nVar.j();
                        if (j2 != null) {
                            if (this.o == null) {
                                this.o = j2;
                                this.n = nVar;
                                j2.a(this.m);
                            } else {
                                throw new d(2, (String) null, new IllegalStateException("Multiple renderer media clocks enabled."), -1);
                            }
                        }
                        if (z2) {
                            nVar.f();
                        }
                    }
                    i4 = i5;
                }
                i3++;
            } else {
                return;
            }
        }
    }
}
