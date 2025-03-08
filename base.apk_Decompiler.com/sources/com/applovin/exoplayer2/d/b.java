package com.applovin.exoplayer2.d;

import android.media.NotProvisionedException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import com.applovin.exoplayer2.d.e;
import com.applovin.exoplayer2.d.f;
import com.applovin.exoplayer2.d.g;
import com.applovin.exoplayer2.d.m;
import com.applovin.exoplayer2.h.j;
import com.applovin.exoplayer2.k.v;
import com.applovin.exoplayer2.l.ai;
import com.applovin.exoplayer2.l.h;
import com.applovin.exoplayer2.l.i;
import com.applovin.exoplayer2.l.q;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

class b implements f {
    private int Z;
    final UUID ey;
    private final int rm;
    public final List<e.a> se;
    private final m sf;
    private final a sg;
    private final C0035b sh;
    private final boolean si;
    private final boolean sj;
    private final HashMap<String, String> sk;
    private final i<g.a> sl;
    /* access modifiers changed from: private */
    public final v sm;
    final r sn;
    final e so;
    private int sp;
    private HandlerThread sq;
    private c sr;
    private com.applovin.exoplayer2.c.b ss;
    private f.a st;
    private byte[] su;
    private byte[] sv;
    private m.a sw;
    private m.d sx;

    public interface a {
        void a(Exception exc, boolean z);

        void b(b bVar);

        void hr();
    }

    /* renamed from: com.applovin.exoplayer2.d.b$b  reason: collision with other inner class name */
    public interface C0035b {
        void a(b bVar, int i);

        void b(b bVar, int i);
    }

    private boolean hB() {
        int i = this.Z;
        return i == 3 || i == 4;
    }

    public final int P() {
        return this.Z;
    }

    public boolean hs() {
        return this.si;
    }

    public final f.a ht() {
        if (this.Z == 1) {
            return this.st;
        }
        return null;
    }

    public final UUID hu() {
        return this.ey;
    }

    public final com.applovin.exoplayer2.c.b hv() {
        return this.ss;
    }

    public static final class f extends IOException {
        public f(Throwable th) {
            super(th);
        }
    }

    public b(UUID uuid, m mVar, a aVar, C0035b bVar, List<e.a> list, int i, boolean z, boolean z2, byte[] bArr, HashMap<String, String> hashMap, r rVar, Looper looper, v vVar) {
        if (i == 1 || i == 3) {
            com.applovin.exoplayer2.l.a.checkNotNull(bArr);
        }
        this.ey = uuid;
        this.sg = aVar;
        this.sh = bVar;
        this.sf = mVar;
        this.rm = i;
        this.si = z;
        this.sj = z2;
        if (bArr != null) {
            this.sv = bArr;
            this.se = null;
        } else {
            this.se = Collections.unmodifiableList((List) com.applovin.exoplayer2.l.a.checkNotNull(list));
        }
        this.sk = hashMap;
        this.sn = rVar;
        this.sl = new i<>();
        this.sm = vVar;
        this.Z = 2;
        this.so = new e(looper);
    }

    public boolean n(byte[] bArr) {
        return Arrays.equals(this.su, bArr);
    }

    public void bB(int i) {
        if (i == 2) {
            hA();
        }
    }

    public void hq() {
        this.sx = this.sf.hM();
        ((c) ai.R(this.sr)).a(0, com.applovin.exoplayer2.l.a.checkNotNull(this.sx), true);
    }

    public void hr() {
        if (hx()) {
            J(true);
        }
    }

    public void a(Exception exc, boolean z) {
        a(exc, z ? 1 : 3);
    }

    public Map<String, String> hw() {
        byte[] bArr = this.su;
        if (bArr == null) {
            return null;
        }
        return this.sf.r(bArr);
    }

    public boolean A(String str) {
        return this.sf.a((byte[]) com.applovin.exoplayer2.l.a.N(this.su), str);
    }

    public void a(g.a aVar) {
        boolean z = false;
        com.applovin.exoplayer2.l.a.checkState(this.sp >= 0);
        if (aVar != null) {
            this.sl.add(aVar);
        }
        int i = this.sp + 1;
        this.sp = i;
        if (i == 1) {
            if (this.Z == 2) {
                z = true;
            }
            com.applovin.exoplayer2.l.a.checkState(z);
            HandlerThread handlerThread = new HandlerThread("ExoPlayer:DrmRequestHandler");
            this.sq = handlerThread;
            handlerThread.start();
            this.sr = new c(this.sq.getLooper());
            if (hx()) {
                J(true);
            }
        } else if (aVar != null && hB() && this.sl.P(aVar) == 1) {
            aVar.bF(this.Z);
        }
        this.sh.a(this, this.sp);
    }

    public void b(g.a aVar) {
        com.applovin.exoplayer2.l.a.checkState(this.sp > 0);
        int i = this.sp - 1;
        this.sp = i;
        if (i == 0) {
            this.Z = 0;
            ((e) ai.R(this.so)).removeCallbacksAndMessages((Object) null);
            ((c) ai.R(this.sr)).release();
            this.sr = null;
            ((HandlerThread) ai.R(this.sq)).quit();
            this.sq = null;
            this.ss = null;
            this.st = null;
            this.sw = null;
            this.sx = null;
            byte[] bArr = this.su;
            if (bArr != null) {
                this.sf.p(bArr);
                this.su = null;
            }
        }
        if (aVar != null) {
            this.sl.O(aVar);
            if (this.sl.P(aVar) == 0) {
                aVar.hJ();
            }
        }
        this.sh.b(this, this.sp);
    }

    private boolean hx() {
        if (hB()) {
            return true;
        }
        try {
            byte[] hL = this.sf.hL();
            this.su = hL;
            this.ss = this.sf.s(hL);
            this.Z = 3;
            a((h<g.a>) new b$$ExternalSyntheticLambda2(3));
            com.applovin.exoplayer2.l.a.checkNotNull(this.su);
            return true;
        } catch (NotProvisionedException unused) {
            this.sg.b(this);
            return false;
        } catch (Exception e2) {
            a(e2, 1);
            return false;
        }
    }

    /* access modifiers changed from: private */
    public void o(Object obj, Object obj2) {
        if (obj != this.sx) {
            return;
        }
        if (this.Z == 2 || hB()) {
            this.sx = null;
            if (obj2 instanceof Exception) {
                this.sg.a((Exception) obj2, false);
                return;
            }
            try {
                this.sf.q((byte[]) obj2);
                this.sg.hr();
            } catch (Exception e2) {
                this.sg.a(e2, true);
            }
        }
    }

    private void J(boolean z) {
        if (!this.sj) {
            byte[] bArr = (byte[]) ai.R(this.su);
            int i = this.rm;
            if (i == 0 || i == 1) {
                if (this.sv == null) {
                    a(bArr, 1, z);
                } else if (this.Z == 4 || hy()) {
                    long hz = hz();
                    if (this.rm == 0 && hz <= 60) {
                        q.f("DefaultDrmSession", "Offline license has expired or will expire soon. Remaining seconds: " + hz);
                        a(bArr, 2, z);
                    } else if (hz <= 0) {
                        a((Exception) new q(), 2);
                    } else {
                        this.Z = 4;
                        a((h<g.a>) new b$$ExternalSyntheticLambda3());
                    }
                }
            } else if (i != 2) {
                if (i == 3) {
                    com.applovin.exoplayer2.l.a.checkNotNull(this.sv);
                    com.applovin.exoplayer2.l.a.checkNotNull(this.su);
                    a(this.sv, 3, z);
                }
            } else if (this.sv == null || hy()) {
                a(bArr, 2, z);
            }
        }
    }

    private boolean hy() {
        try {
            this.sf.b(this.su, this.sv);
            return true;
        } catch (Exception e2) {
            a(e2, 1);
            return false;
        }
    }

    private long hz() {
        if (!com.applovin.exoplayer2.h.am.equals(this.ey)) {
            return Long.MAX_VALUE;
        }
        Pair pair = (Pair) com.applovin.exoplayer2.l.a.checkNotNull(u.b(this));
        return Math.min(((Long) pair.first).longValue(), ((Long) pair.second).longValue());
    }

    private void a(byte[] bArr, int i, boolean z) {
        try {
            this.sw = this.sf.a(bArr, this.se, i, this.sk);
            ((c) ai.R(this.sr)).a(1, com.applovin.exoplayer2.l.a.checkNotNull(this.sw), z);
        } catch (Exception e2) {
            b(e2, true);
        }
    }

    /* access modifiers changed from: private */
    public void p(Object obj, Object obj2) {
        if (obj == this.sw && hB()) {
            this.sw = null;
            if (obj2 instanceof Exception) {
                b((Exception) obj2, false);
                return;
            }
            try {
                byte[] bArr = (byte[]) obj2;
                if (this.rm == 3) {
                    this.sf.a((byte[]) ai.R(this.sv), bArr);
                    a((h<g.a>) new b$$ExternalSyntheticLambda0());
                    return;
                }
                byte[] a2 = this.sf.a(this.su, bArr);
                int i = this.rm;
                if (!((i != 2 && (i != 0 || this.sv == null)) || a2 == null || a2.length == 0)) {
                    this.sv = a2;
                }
                this.Z = 4;
                a((h<g.a>) new b$$ExternalSyntheticLambda1());
            } catch (Exception e2) {
                b(e2, true);
            }
        }
    }

    private void hA() {
        if (this.rm == 0 && this.Z == 4) {
            ai.R(this.su);
            J(false);
        }
    }

    private void b(Exception exc, boolean z) {
        if (exc instanceof NotProvisionedException) {
            this.sg.b(this);
        } else {
            a(exc, z ? 1 : 2);
        }
    }

    private void a(Exception exc, int i) {
        this.st = new f.a(exc, j.b(exc, i));
        q.c("DefaultDrmSession", "DRM session error", exc);
        a((h<g.a>) new b$$ExternalSyntheticLambda4(exc));
        if (this.Z != 4) {
            this.Z = 1;
        }
    }

    private void a(h<g.a> hVar) {
        for (g.a accept : this.sl.gN()) {
            hVar.accept(accept);
        }
    }

    private class e extends Handler {
        public e(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            Pair pair = (Pair) message.obj;
            Object obj = pair.first;
            Object obj2 = pair.second;
            int i = message.what;
            if (i == 0) {
                b.this.o(obj, obj2);
            } else if (i == 1) {
                b.this.p(obj, obj2);
            }
        }
    }

    private class c extends Handler {
        private boolean sy;

        public c(Looper looper) {
            super(looper);
        }

        /* access modifiers changed from: package-private */
        public void a(int i, Object obj, boolean z) {
            obtainMessage(i, new d(j.kV(), z, SystemClock.elapsedRealtime(), obj)).sendToTarget();
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: com.applovin.exoplayer2.d.s} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v11, resolved type: com.applovin.exoplayer2.d.s} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v12, resolved type: com.applovin.exoplayer2.d.s} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v13, resolved type: byte[]} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v14, resolved type: byte[]} */
        /* JADX WARNING: type inference failed for: r1v2, types: [java.lang.Throwable, java.lang.Exception] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void handleMessage(android.os.Message r6) {
            /*
                r5 = this;
                java.lang.Object r0 = r6.obj
                com.applovin.exoplayer2.d.b$d r0 = (com.applovin.exoplayer2.d.b.d) r0
                int r1 = r6.what     // Catch:{ s -> 0x003c, Exception -> 0x0033 }
                if (r1 == 0) goto L_0x0022
                r2 = 1
                if (r1 != r2) goto L_0x001c
                com.applovin.exoplayer2.d.b r1 = com.applovin.exoplayer2.d.b.this     // Catch:{ s -> 0x003c, Exception -> 0x0033 }
                com.applovin.exoplayer2.d.r r1 = r1.sn     // Catch:{ s -> 0x003c, Exception -> 0x0033 }
                com.applovin.exoplayer2.d.b r2 = com.applovin.exoplayer2.d.b.this     // Catch:{ s -> 0x003c, Exception -> 0x0033 }
                java.util.UUID r2 = r2.ey     // Catch:{ s -> 0x003c, Exception -> 0x0033 }
                java.lang.Object r3 = r0.sD     // Catch:{ s -> 0x003c, Exception -> 0x0033 }
                com.applovin.exoplayer2.d.m$a r3 = (com.applovin.exoplayer2.d.m.a) r3     // Catch:{ s -> 0x003c, Exception -> 0x0033 }
                byte[] r1 = r1.a((java.util.UUID) r2, (com.applovin.exoplayer2.d.m.a) r3)     // Catch:{ s -> 0x003c, Exception -> 0x0033 }
                goto L_0x0044
            L_0x001c:
                java.lang.RuntimeException r1 = new java.lang.RuntimeException     // Catch:{ s -> 0x003c, Exception -> 0x0033 }
                r1.<init>()     // Catch:{ s -> 0x003c, Exception -> 0x0033 }
                throw r1     // Catch:{ s -> 0x003c, Exception -> 0x0033 }
            L_0x0022:
                com.applovin.exoplayer2.d.b r1 = com.applovin.exoplayer2.d.b.this     // Catch:{ s -> 0x003c, Exception -> 0x0033 }
                com.applovin.exoplayer2.d.r r1 = r1.sn     // Catch:{ s -> 0x003c, Exception -> 0x0033 }
                com.applovin.exoplayer2.d.b r2 = com.applovin.exoplayer2.d.b.this     // Catch:{ s -> 0x003c, Exception -> 0x0033 }
                java.util.UUID r2 = r2.ey     // Catch:{ s -> 0x003c, Exception -> 0x0033 }
                java.lang.Object r3 = r0.sD     // Catch:{ s -> 0x003c, Exception -> 0x0033 }
                com.applovin.exoplayer2.d.m$d r3 = (com.applovin.exoplayer2.d.m.d) r3     // Catch:{ s -> 0x003c, Exception -> 0x0033 }
                byte[] r1 = r1.a((java.util.UUID) r2, (com.applovin.exoplayer2.d.m.d) r3)     // Catch:{ s -> 0x003c, Exception -> 0x0033 }
                goto L_0x0044
            L_0x0033:
                r1 = move-exception
                java.lang.String r2 = "DefaultDrmSession"
                java.lang.String r3 = "Key/provisioning request produced an unexpected exception. Not retrying."
                com.applovin.exoplayer2.l.q.b(r2, r3, r1)
                goto L_0x0044
            L_0x003c:
                r1 = move-exception
                boolean r2 = r5.a(r6, r1)
                if (r2 == 0) goto L_0x0044
                return
            L_0x0044:
                com.applovin.exoplayer2.d.b r2 = com.applovin.exoplayer2.d.b.this
                com.applovin.exoplayer2.k.v r2 = r2.sm
                long r3 = r0.sA
                r2.bm(r3)
                monitor-enter(r5)
                boolean r2 = r5.sy     // Catch:{ all -> 0x0069 }
                if (r2 != 0) goto L_0x0067
                com.applovin.exoplayer2.d.b r2 = com.applovin.exoplayer2.d.b.this     // Catch:{ all -> 0x0069 }
                com.applovin.exoplayer2.d.b$e r2 = r2.so     // Catch:{ all -> 0x0069 }
                int r6 = r6.what     // Catch:{ all -> 0x0069 }
                java.lang.Object r0 = r0.sD     // Catch:{ all -> 0x0069 }
                android.util.Pair r0 = android.util.Pair.create(r0, r1)     // Catch:{ all -> 0x0069 }
                android.os.Message r6 = r2.obtainMessage(r6, r0)     // Catch:{ all -> 0x0069 }
                r6.sendToTarget()     // Catch:{ all -> 0x0069 }
            L_0x0067:
                monitor-exit(r5)     // Catch:{ all -> 0x0069 }
                return
            L_0x0069:
                r6 = move-exception
                monitor-exit(r5)     // Catch:{ all -> 0x0069 }
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.d.b.c.handleMessage(android.os.Message):void");
        }

        private boolean a(Message message, s sVar) {
            IOException iOException;
            s sVar2 = sVar;
            d dVar = (d) message.obj;
            if (!dVar.sB) {
                return false;
            }
            dVar.sE++;
            if (dVar.sE > b.this.sm.fl(3)) {
                return false;
            }
            j jVar = new j(dVar.sA, sVar2.tw, sVar2.tx, sVar2.ty, SystemClock.elapsedRealtime(), SystemClock.elapsedRealtime() - dVar.sC, sVar2.tz);
            com.applovin.exoplayer2.h.m mVar = new com.applovin.exoplayer2.h.m(3);
            if (sVar.getCause() instanceof IOException) {
                iOException = (IOException) sVar.getCause();
            } else {
                iOException = new f(sVar.getCause());
            }
            long a = b.this.sm.a(new v.a(jVar, mVar, iOException, dVar.sE));
            if (a == -9223372036854775807L) {
                return false;
            }
            synchronized (this) {
                if (this.sy) {
                    return false;
                }
                sendMessageDelayed(Message.obtain(message), a);
                return true;
            }
        }

        public synchronized void release() {
            removeCallbacksAndMessages((Object) null);
            this.sy = true;
        }
    }

    private static final class d {
        public final long sA;
        public final boolean sB;
        public final long sC;
        public final Object sD;
        public int sE;

        public d(long j, boolean z, long j2, Object obj) {
            this.sA = j;
            this.sB = z;
            this.sC = j2;
            this.sD = obj;
        }
    }
}
