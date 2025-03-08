package com.fyber.inneractive.sdk.player.exoplayer2;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.fyber.inneractive.sdk.player.exoplayer2.e;
import com.fyber.inneractive.sdk.player.exoplayer2.h;
import com.fyber.inneractive.sdk.player.exoplayer2.p;
import com.fyber.inneractive.sdk.player.exoplayer2.source.s;
import com.fyber.inneractive.sdk.player.exoplayer2.trackselection.f;
import com.fyber.inneractive.sdk.player.exoplayer2.util.a;
import com.fyber.inneractive.sdk.player.exoplayer2.util.u;
import com.ironsource.m2;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

public final class g implements e {
    public final n[] a;
    public final com.fyber.inneractive.sdk.player.exoplayer2.trackselection.g b;
    public final f c;
    public final Handler d;
    public final h e;
    public final CopyOnWriteArraySet<e.a> f;
    public final p.c g;
    public final p.b h;
    public boolean i;
    public boolean j;
    public int k;
    public int l;
    public int m;
    public boolean n;
    public p o;
    public Object p;
    public s q;
    public f r;
    public m s;
    public h.b t;
    public int u;
    public long v;

    public g(n[] nVarArr, com.fyber.inneractive.sdk.player.exoplayer2.trackselection.g gVar, c cVar) {
        Log.i("ExoPlayerImpl", "Init ExoPlayerLib/2.4.4 [" + u.e + m2.i.e);
        a.b(nVarArr.length > 0);
        this.a = (n[]) a.a(nVarArr);
        this.b = (com.fyber.inneractive.sdk.player.exoplayer2.trackselection.g) a.a(gVar);
        this.j = false;
        this.k = 1;
        this.f = new CopyOnWriteArraySet<>();
        f fVar = new f(new com.fyber.inneractive.sdk.player.exoplayer2.trackselection.e[nVarArr.length]);
        this.c = fVar;
        this.o = p.a;
        this.g = new p.c();
        this.h = new p.b();
        this.q = s.d;
        this.r = fVar;
        this.s = m.d;
        f fVar2 = new f(this, Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper());
        this.d = fVar2;
        h.b bVar = new h.b(0, 0);
        this.t = bVar;
        this.e = new h(nVarArr, gVar, cVar, this.j, fVar2, bVar, this);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:10|11|12|13|24|21|8) */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x000f, code lost:
        continue;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0017 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b() {
        /*
            r3 = this;
            com.fyber.inneractive.sdk.player.exoplayer2.h r0 = r3.e
            monitor-enter(r0)
            boolean r1 = r0.r     // Catch:{ all -> 0x002c }
            if (r1 == 0) goto L_0x0009
            monitor-exit(r0)
            goto L_0x0025
        L_0x0009:
            android.os.Handler r1 = r0.f     // Catch:{ all -> 0x002c }
            r2 = 6
            r1.sendEmptyMessage(r2)     // Catch:{ all -> 0x002c }
        L_0x000f:
            boolean r1 = r0.r     // Catch:{ all -> 0x002c }
            if (r1 != 0) goto L_0x001f
            r0.wait()     // Catch:{ InterruptedException -> 0x0017 }
            goto L_0x000f
        L_0x0017:
            java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x002c }
            r1.interrupt()     // Catch:{ all -> 0x002c }
            goto L_0x000f
        L_0x001f:
            android.os.HandlerThread r1 = r0.g     // Catch:{ all -> 0x002c }
            r1.quit()     // Catch:{ all -> 0x002c }
            monitor-exit(r0)
        L_0x0025:
            android.os.Handler r0 = r3.d
            r1 = 0
            r0.removeCallbacksAndMessages(r1)
            return
        L_0x002c:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.exoplayer2.g.b():void");
    }

    public void a(boolean z) {
        if (this.j != z) {
            this.j = z;
            this.e.f.obtainMessage(1, z ? 1 : 0, 0).sendToTarget();
            Iterator<e.a> it = this.f.iterator();
            while (it.hasNext()) {
                it.next().a(z, this.k);
            }
        }
    }

    public void a(int i2, long j2) {
        if (i2 < 0 || (!this.o.c() && i2 >= this.o.b())) {
            throw new k(this.o, i2, j2);
        }
        this.l++;
        this.u = i2;
        if (!this.o.c()) {
            this.o.a(i2, this.g, false, 0);
            long j3 = j2 == -9223372036854775807L ? this.g.e : j2;
            p.c cVar = this.g;
            int i3 = cVar.c;
            long a2 = cVar.g + b.a(j3);
            long j4 = this.o.a(i3, this.h, false).d;
            while (j4 != -9223372036854775807L && a2 >= j4 && i3 < this.g.d) {
                a2 -= j4;
                i3++;
                j4 = this.o.a(i3, this.h, false).d;
            }
        }
        if (j2 == -9223372036854775807L) {
            this.v = 0;
            this.e.f.obtainMessage(3, new h.c(this.o, i2, -9223372036854775807L)).sendToTarget();
            return;
        }
        this.v = j2;
        this.e.f.obtainMessage(3, new h.c(this.o, i2, b.a(j2))).sendToTarget();
        Iterator<e.a> it = this.f.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    public void a(e.c... cVarArr) {
        h hVar = this.e;
        if (hVar.r) {
            Log.w("ExoPlayerImplInternal", "Ignoring messages sent after release.");
            return;
        }
        hVar.w++;
        hVar.f.obtainMessage(11, cVarArr).sendToTarget();
    }

    public int a() {
        return (this.o.c() || this.l > 0) ? this.u : this.o.a(this.t.a, this.h, false).c;
    }
}
