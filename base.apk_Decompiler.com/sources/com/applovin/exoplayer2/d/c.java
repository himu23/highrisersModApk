package com.applovin.exoplayer2.d;

import android.media.ResourceBusyException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import androidx.work.PeriodicWorkRequest;
import com.applovin.exoplayer2.common.a.aq;
import com.applovin.exoplayer2.common.a.ax;
import com.applovin.exoplayer2.common.a.s;
import com.applovin.exoplayer2.common.a.w;
import com.applovin.exoplayer2.d.b;
import com.applovin.exoplayer2.d.e;
import com.applovin.exoplayer2.d.f;
import com.applovin.exoplayer2.d.g;
import com.applovin.exoplayer2.d.h;
import com.applovin.exoplayer2.d.m;
import com.applovin.exoplayer2.h;
import com.applovin.exoplayer2.k.r;
import com.applovin.exoplayer2.k.v;
import com.applovin.exoplayer2.l.ai;
import com.applovin.exoplayer2.l.q;
import com.applovin.exoplayer2.l.u;
import com.google.android.gms.games.GamesStatusCodes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class c implements h {
    /* access modifiers changed from: private */
    public Looper co;
    private final boolean eB;
    private final UUID ey;
    private int rm;
    private final m.c sF;
    private final int[] sG;
    /* access modifiers changed from: private */
    public final f sH;
    private final g sI;
    /* access modifiers changed from: private */
    public final long sJ;
    /* access modifiers changed from: private */
    public final List<b> sK;
    /* access modifiers changed from: private */
    public final Set<e> sL;
    /* access modifiers changed from: private */
    public final Set<b> sM;
    /* access modifiers changed from: private */
    public int sN;
    private m sO;
    /* access modifiers changed from: private */
    public b sP;
    /* access modifiers changed from: private */
    public b sQ;
    /* access modifiers changed from: private */
    public Handler sR;
    volatile C0036c sS;
    private final boolean si;
    private final HashMap<String, String> sk;
    private final v sm;
    private final r sn;
    private byte[] sv;

    public static final class a {
        private boolean eB;
        private UUID ey = h.am;
        private m.c sF = o.tq;
        private int[] sG = new int[0];
        private long sJ = PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS;
        private boolean si;
        private final HashMap<String, String> sk = new HashMap<>();
        private v sm = new r();

        public a K(boolean z) {
            this.eB = z;
            return this;
        }

        public a L(boolean z) {
            this.si = z;
            return this;
        }

        public a a(UUID uuid, m.c cVar) {
            this.ey = (UUID) com.applovin.exoplayer2.l.a.checkNotNull(uuid);
            this.sF = (m.c) com.applovin.exoplayer2.l.a.checkNotNull(cVar);
            return this;
        }

        public a e(int... iArr) {
            for (int i : iArr) {
                boolean z = true;
                if (!(i == 2 || i == 1)) {
                    z = false;
                }
                com.applovin.exoplayer2.l.a.checkArgument(z);
            }
            this.sG = (int[]) iArr.clone();
            return this;
        }

        public c a(r rVar) {
            return new c(this.ey, this.sF, rVar, this.sk, this.eB, this.sG, this.si, this.sm, this.sJ);
        }
    }

    public static final class d extends Exception {
        private d(UUID uuid) {
            super("Media does not support uuid: " + uuid);
        }
    }

    private c(UUID uuid, m.c cVar, r rVar, HashMap<String, String> hashMap, boolean z, int[] iArr, boolean z2, v vVar, long j) {
        com.applovin.exoplayer2.l.a.checkNotNull(uuid);
        com.applovin.exoplayer2.l.a.checkArgument(!h.ak.equals(uuid), "Use C.CLEARKEY_UUID instead");
        this.ey = uuid;
        this.sF = cVar;
        this.sn = rVar;
        this.sk = hashMap;
        this.eB = z;
        this.sG = iArr;
        this.si = z2;
        this.sm = vVar;
        this.sH = new f();
        this.sI = new g();
        this.rm = 0;
        this.sK = new ArrayList();
        this.sL = aq.gT();
        this.sM = aq.gT();
        this.sJ = j;
    }

    public void a(int i, byte[] bArr) {
        com.applovin.exoplayer2.l.a.checkState(this.sK.isEmpty());
        if (i == 1 || i == 3) {
            com.applovin.exoplayer2.l.a.checkNotNull(bArr);
        }
        this.rm = i;
        this.sv = bArr;
    }

    public final void aD() {
        int i = this.sN;
        this.sN = i + 1;
        if (i == 0) {
            if (this.sO == null) {
                m acquireExoMediaDrm = this.sF.acquireExoMediaDrm(this.ey);
                this.sO = acquireExoMediaDrm;
                acquireExoMediaDrm.a(new b());
            } else if (this.sJ != -9223372036854775807L) {
                for (int i2 = 0; i2 < this.sK.size(); i2++) {
                    this.sK.get(i2).a((g.a) null);
                }
            }
        }
    }

    public final void release() {
        int i = this.sN - 1;
        this.sN = i;
        if (i == 0) {
            if (this.sJ != -9223372036854775807L) {
                ArrayList arrayList = new ArrayList(this.sK);
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    ((b) arrayList.get(i2)).b((g.a) null);
                }
            }
            hD();
            hE();
        }
    }

    public h.a a(Looper looper, g.a aVar, com.applovin.exoplayer2.v vVar) {
        com.applovin.exoplayer2.l.a.checkState(this.sN > 0);
        a(looper);
        e eVar = new e(aVar);
        eVar.h(vVar);
        return eVar;
    }

    public f b(Looper looper, g.a aVar, com.applovin.exoplayer2.v vVar) {
        com.applovin.exoplayer2.l.a.checkState(this.sN > 0);
        a(looper);
        return a(looper, aVar, vVar, true);
    }

    /* access modifiers changed from: private */
    public f a(Looper looper, g.a aVar, com.applovin.exoplayer2.v vVar, boolean z) {
        List<e.a> list;
        b(looper);
        if (vVar.dC == null) {
            return h(u.ba(vVar.dz), z);
        }
        b bVar = null;
        if (this.sv == null) {
            list = a((e) com.applovin.exoplayer2.l.a.checkNotNull(vVar.dC), this.ey, false);
            if (list.isEmpty()) {
                d dVar = new d(this.ey);
                q.c("DefaultDrmSessionMgr", "DRM error", dVar);
                if (aVar != null) {
                    aVar.j(dVar);
                }
                return new l(new f.a(dVar, GamesStatusCodes.STATUS_MULTIPLAYER_DISABLED));
            }
        } else {
            list = null;
        }
        if (this.eB) {
            Iterator<b> it = this.sK.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                b next = it.next();
                if (ai.r(next.se, list)) {
                    bVar = next;
                    break;
                }
            }
        } else {
            bVar = this.sQ;
        }
        if (bVar == null) {
            bVar = a(list, false, aVar, z);
            if (!this.eB) {
                this.sQ = bVar;
            }
            this.sK.add(bVar);
        } else {
            bVar.a(aVar);
        }
        return bVar;
    }

    public int g(com.applovin.exoplayer2.v vVar) {
        int hN = ((m) com.applovin.exoplayer2.l.a.checkNotNull(this.sO)).hN();
        if (vVar.dC == null) {
            if (ai.c(this.sG, u.ba(vVar.dz)) != -1) {
                return hN;
            }
            return 0;
        } else if (b(vVar.dC)) {
            return hN;
        } else {
            return 1;
        }
    }

    private f h(int i, boolean z) {
        m mVar = (m) com.applovin.exoplayer2.l.a.checkNotNull(this.sO);
        if ((mVar.hN() == 2 && n.to) || ai.c(this.sG, i) == -1 || mVar.hN() == 1) {
            return null;
        }
        b bVar = this.sP;
        if (bVar == null) {
            b a2 = a((List<e.a>) s.ga(), true, (g.a) null, z);
            this.sK.add(a2);
            this.sP = a2;
        } else {
            bVar.a((g.a) null);
        }
        return this.sP;
    }

    private boolean b(e eVar) {
        if (this.sv != null) {
            return true;
        }
        if (a(eVar, this.ey, true).isEmpty()) {
            if (eVar.td != 1 || !eVar.bC(0).a(com.applovin.exoplayer2.h.ak)) {
                return false;
            }
            q.h("DefaultDrmSessionMgr", "DrmInitData only contains common PSSH SchemeData. Assuming support for: " + this.ey);
        }
        String str = eVar.tc;
        if (str == null || "cenc".equals(str)) {
            return true;
        }
        if ("cbcs".equals(str)) {
            if (ai.acV >= 25) {
                return true;
            }
            return false;
        } else if ("cbc1".equals(str) || "cens".equals(str)) {
            return false;
        } else {
            return true;
        }
    }

    private synchronized void a(Looper looper) {
        Looper looper2 = this.co;
        if (looper2 == null) {
            this.co = looper;
            this.sR = new Handler(looper);
        } else {
            com.applovin.exoplayer2.l.a.checkState(looper2 == looper);
            com.applovin.exoplayer2.l.a.checkNotNull(this.sR);
        }
    }

    private void b(Looper looper) {
        if (this.sS == null) {
            this.sS = new C0036c(looper);
        }
    }

    private b a(List<e.a> list, boolean z, g.a aVar, boolean z2) {
        b a2 = a(list, z, aVar);
        if (a((f) a2) && !this.sM.isEmpty()) {
            hC();
            a((f) a2, aVar);
            a2 = a(list, z, aVar);
        }
        if (!a((f) a2) || !z2 || this.sL.isEmpty()) {
            return a2;
        }
        hD();
        if (!this.sM.isEmpty()) {
            hC();
        }
        a((f) a2, aVar);
        return a(list, z, aVar);
    }

    private static boolean a(f fVar) {
        if (fVar.P() != 1 || (ai.acV >= 19 && !(((f.a) com.applovin.exoplayer2.l.a.checkNotNull(fVar.ht())).getCause() instanceof ResourceBusyException))) {
            return false;
        }
        return true;
    }

    private void a(f fVar, g.a aVar) {
        fVar.b(aVar);
        if (this.sJ != -9223372036854775807L) {
            fVar.b((g.a) null);
        }
    }

    private void hC() {
        ax<b> fU = w.e(this.sM).iterator();
        while (fU.hasNext()) {
            fU.next().b((g.a) null);
        }
    }

    private void hD() {
        ax<e> fU = w.e(this.sL).iterator();
        while (fU.hasNext()) {
            fU.next().release();
        }
    }

    private b a(List<e.a> list, boolean z, g.a aVar) {
        com.applovin.exoplayer2.l.a.checkNotNull(this.sO);
        List<e.a> list2 = list;
        b bVar = new b(this.ey, this.sO, this.sH, this.sI, list2, this.rm, this.si | z, z, this.sv, this.sk, this.sn, (Looper) com.applovin.exoplayer2.l.a.checkNotNull(this.co), this.sm);
        bVar.a(aVar);
        if (this.sJ != -9223372036854775807L) {
            bVar.a((g.a) null);
        }
        return bVar;
    }

    /* access modifiers changed from: private */
    public void hE() {
        if (this.sO != null && this.sN == 0 && this.sK.isEmpty() && this.sL.isEmpty()) {
            ((m) com.applovin.exoplayer2.l.a.checkNotNull(this.sO)).release();
            this.sO = null;
        }
    }

    private static List<e.a> a(e eVar, UUID uuid, boolean z) {
        ArrayList arrayList = new ArrayList(eVar.td);
        for (int i = 0; i < eVar.td; i++) {
            e.a bC = eVar.bC(i);
            if ((bC.a(uuid) || (com.applovin.exoplayer2.h.al.equals(uuid) && bC.a(com.applovin.exoplayer2.h.ak))) && (bC.tf != null || z)) {
                arrayList.add(bC);
            }
        }
        return arrayList;
    }

    /* renamed from: com.applovin.exoplayer2.d.c$c  reason: collision with other inner class name */
    private class C0036c extends Handler {
        public C0036c(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            byte[] bArr = (byte[]) message.obj;
            if (bArr != null) {
                for (b bVar : c.this.sK) {
                    if (bVar.n(bArr)) {
                        bVar.bB(message.what);
                        return;
                    }
                }
            }
        }
    }

    private class f implements b.a {
        private final Set<b> sW = new HashSet();
        private b sX;

        public f() {
        }

        public void b(b bVar) {
            this.sW.add(bVar);
            if (this.sX == null) {
                this.sX = bVar;
                bVar.hq();
            }
        }

        public void hr() {
            this.sX = null;
            s<b> d = s.d(this.sW);
            this.sW.clear();
            ax<b> fU = d.iterator();
            while (fU.hasNext()) {
                fU.next().hr();
            }
        }

        public void a(Exception exc, boolean z) {
            this.sX = null;
            s<b> d = s.d(this.sW);
            this.sW.clear();
            ax<b> fU = d.iterator();
            while (fU.hasNext()) {
                fU.next().a(exc, z);
            }
        }

        public void c(b bVar) {
            this.sW.remove(bVar);
            if (this.sX == bVar) {
                this.sX = null;
                if (!this.sW.isEmpty()) {
                    b next = this.sW.iterator().next();
                    this.sX = next;
                    next.hq();
                }
            }
        }
    }

    private class g implements b.C0035b {
        private g() {
        }

        public void a(b bVar, int i) {
            if (c.this.sJ != -9223372036854775807L) {
                c.this.sM.remove(bVar);
                ((Handler) com.applovin.exoplayer2.l.a.checkNotNull(c.this.sR)).removeCallbacksAndMessages(bVar);
            }
        }

        public void b(b bVar, int i) {
            if (i == 1 && c.this.sN > 0 && c.this.sJ != -9223372036854775807L) {
                c.this.sM.add(bVar);
                ((Handler) com.applovin.exoplayer2.l.a.checkNotNull(c.this.sR)).postAtTime(new c$g$$ExternalSyntheticLambda0(bVar), bVar, SystemClock.uptimeMillis() + c.this.sJ);
            } else if (i == 0) {
                c.this.sK.remove(bVar);
                if (c.this.sP == bVar) {
                    b unused = c.this.sP = null;
                }
                if (c.this.sQ == bVar) {
                    b unused2 = c.this.sQ = null;
                }
                c.this.sH.c(bVar);
                if (c.this.sJ != -9223372036854775807L) {
                    ((Handler) com.applovin.exoplayer2.l.a.checkNotNull(c.this.sR)).removeCallbacksAndMessages(bVar);
                    c.this.sM.remove(bVar);
                }
            }
            c.this.hE();
        }
    }

    private class b implements m.b {
        private b() {
        }

        public void a(m mVar, byte[] bArr, int i, int i2, byte[] bArr2) {
            ((C0036c) com.applovin.exoplayer2.l.a.checkNotNull(c.this.sS)).obtainMessage(i, bArr).sendToTarget();
        }
    }

    private class e implements h.a {
        private final g.a sU;
        private f sV;
        private boolean sy;

        public e(g.a aVar) {
            this.sU = aVar;
        }

        public void h(com.applovin.exoplayer2.v vVar) {
            ((Handler) com.applovin.exoplayer2.l.a.checkNotNull(c.this.sR)).post(new c$e$$ExternalSyntheticLambda1(this, vVar));
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void i(com.applovin.exoplayer2.v vVar) {
            if (c.this.sN != 0 && !this.sy) {
                c cVar = c.this;
                this.sV = cVar.a((Looper) com.applovin.exoplayer2.l.a.checkNotNull(cVar.co), this.sU, vVar, false);
                c.this.sL.add(this);
            }
        }

        public void release() {
            ai.a((Handler) com.applovin.exoplayer2.l.a.checkNotNull(c.this.sR), (Runnable) new c$e$$ExternalSyntheticLambda0(this));
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void hF() {
            if (!this.sy) {
                f fVar = this.sV;
                if (fVar != null) {
                    fVar.b(this.sU);
                }
                c.this.sL.remove(this);
                this.sy = true;
            }
        }
    }
}
