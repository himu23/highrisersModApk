package com.applovin.exoplayer2.a;

import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import androidx.core.view.PointerIconCompat;
import com.applovin.exoplayer2.a.b;
import com.applovin.exoplayer2.ab;
import com.applovin.exoplayer2.ac;
import com.applovin.exoplayer2.ak;
import com.applovin.exoplayer2.am;
import com.applovin.exoplayer2.an;
import com.applovin.exoplayer2.b.g;
import com.applovin.exoplayer2.ba;
import com.applovin.exoplayer2.c.e;
import com.applovin.exoplayer2.c.h;
import com.applovin.exoplayer2.common.a.s;
import com.applovin.exoplayer2.common.a.u;
import com.applovin.exoplayer2.common.a.x;
import com.applovin.exoplayer2.common.base.Objects;
import com.applovin.exoplayer2.d.g;
import com.applovin.exoplayer2.h.ad;
import com.applovin.exoplayer2.h.j;
import com.applovin.exoplayer2.h.p;
import com.applovin.exoplayer2.h.q;
import com.applovin.exoplayer2.k.d;
import com.applovin.exoplayer2.l.ai;
import com.applovin.exoplayer2.l.m;
import com.applovin.exoplayer2.l.o;
import com.applovin.exoplayer2.l.p;
import com.applovin.exoplayer2.m.n;
import com.applovin.exoplayer2.v;
import com.ironsource.mediationsdk.logger.IronSourceError;
import java.io.IOException;
import java.util.List;

public class a implements an.d, g, com.applovin.exoplayer2.d.g, q, d.a, n {
    private final ba.c U = new ba.c();
    private p<b> bG;
    private final ba.a bI;
    private final com.applovin.exoplayer2.l.d bR;
    private o cm;
    private final C0028a iZ;
    private final SparseArray<b.a> ja;
    private an jb;
    private boolean jc;

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(b bVar, m mVar) {
    }

    public /* synthetic */ void a(an anVar, an.c cVar) {
        an.d.CC.$default$a((an.d) this, anVar, cVar);
    }

    public /* synthetic */ void a(com.applovin.exoplayer2.o oVar) {
        an.d.CC.$default$a((an.d) this, oVar);
    }

    public /* synthetic */ void ac(int i) {
        an.b.CC.$default$ac(this, i);
    }

    public /* synthetic */ void b(ak akVar) {
        an.d.CC.$default$b((an.d) this, akVar);
    }

    public /* synthetic */ void c(v vVar) {
        g.CC.$default$c((g) this, vVar);
    }

    public /* synthetic */ void cE() {
        an.d.CC.$default$cE(this);
    }

    public /* synthetic */ void e(int i, boolean z) {
        an.d.CC.$default$e((an.d) this, i, z);
    }

    public /* synthetic */ void e(List list) {
        an.d.CC.$default$e(this, list);
    }

    public /* synthetic */ void g(int i, p.a aVar) {
        g.CC.$default$g(this, i, aVar);
    }

    public /* synthetic */ void x(boolean z) {
        an.b.CC.$default$x(this, z);
    }

    public /* synthetic */ void y(v vVar) {
        n.CC.$default$y(this, vVar);
    }

    public a(com.applovin.exoplayer2.l.d dVar) {
        this.bR = (com.applovin.exoplayer2.l.d) com.applovin.exoplayer2.l.a.checkNotNull(dVar);
        this.bG = new com.applovin.exoplayer2.l.p<>(ai.pZ(), dVar, new a$$ExternalSyntheticLambda21());
        ba.a aVar = new ba.a();
        this.bI = aVar;
        this.iZ = new C0028a(aVar);
        this.ja = new SparseArray<>();
    }

    public void a(an anVar, Looper looper) {
        com.applovin.exoplayer2.l.a.checkState(this.jb == null || this.iZ.jd.isEmpty());
        this.jb = (an) com.applovin.exoplayer2.l.a.checkNotNull(anVar);
        this.cm = this.bR.a(looper, (Handler.Callback) null);
        this.bG = this.bG.a(looper, new a$$ExternalSyntheticLambda52(this, anVar));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(an anVar, b bVar, m mVar) {
        bVar.a(anVar, new b.C0029b(mVar, this.ja));
    }

    public void release() {
        b.a dr = dr();
        this.ja.put(IronSourceError.ERROR_IS_SHOW_CALLED_DURING_SHOW, dr);
        a(dr, (int) IronSourceError.ERROR_IS_SHOW_CALLED_DURING_SHOW, (p.a<b>) new a$$ExternalSyntheticLambda14(dr));
        ((o) com.applovin.exoplayer2.l.a.N(this.cm)).e(new a$$ExternalSyntheticLambda15(this));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void dv() {
        this.bG.release();
    }

    public final void a(List<p.a> list, p.a aVar) {
        this.iZ.a(list, aVar, (an) com.applovin.exoplayer2.l.a.checkNotNull(this.jb));
    }

    public final void dq() {
        if (!this.jc) {
            b.a dr = dr();
            this.jc = true;
            a(dr, -1, (p.a<b>) new a$$ExternalSyntheticLambda22(dr));
        }
    }

    public final void c(e eVar) {
        b.a dt = dt();
        a(dt, 1008, (p.a<b>) new a$$ExternalSyntheticLambda45(dt, eVar));
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void d(b.a aVar, e eVar, b bVar) {
        bVar.a(aVar, eVar);
        bVar.a(aVar, 1, eVar);
    }

    public final void b(String str, long j, long j2) {
        b.a dt = dt();
        a(dt, 1009, (p.a<b>) new a$$ExternalSyntheticLambda46(dt, str, j2, j));
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void b(b.a aVar, String str, long j, long j2, b bVar) {
        bVar.a(aVar, str, j);
        long j3 = j;
        bVar.a(aVar, str, j2, j3);
        bVar.a(aVar, 1, str, j3);
    }

    public final void b(v vVar, h hVar) {
        b.a dt = dt();
        a(dt, 1010, (p.a<b>) new a$$ExternalSyntheticLambda35(dt, vVar, hVar));
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void b(b.a aVar, v vVar, h hVar, b bVar) {
        bVar.a(aVar, vVar);
        bVar.a(aVar, vVar, hVar);
        bVar.a(aVar, 1, vVar);
    }

    public final void z(long j) {
        b.a dt = dt();
        a(dt, 1011, (p.a<b>) new a$$ExternalSyntheticLambda36(dt, j));
    }

    public final void a(int i, long j, long j2) {
        b.a dt = dt();
        a(dt, (int) PointerIconCompat.TYPE_NO_DROP, (p.a<b>) new a$$ExternalSyntheticLambda18(dt, i, j, j2));
    }

    public final void s(String str) {
        b.a dt = dt();
        a(dt, 1013, (p.a<b>) new a$$ExternalSyntheticLambda1(dt, str));
    }

    public final void d(e eVar) {
        b.a ds = ds();
        a(ds, 1014, (p.a<b>) new a$$ExternalSyntheticLambda49(ds, eVar));
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void c(b.a aVar, e eVar, b bVar) {
        bVar.b(aVar, eVar);
        bVar.b(aVar, 1, eVar);
    }

    public final void A(boolean z) {
        b.a dt = dt();
        a(dt, (int) PointerIconCompat.TYPE_TOP_LEFT_DIAGONAL_DOUBLE_ARROW, (p.a<b>) new a$$ExternalSyntheticLambda24(dt, z));
    }

    public final void b(Exception exc) {
        b.a dt = dt();
        a(dt, 1018, (p.a<b>) new a$$ExternalSyntheticLambda26(dt, exc));
    }

    public final void c(Exception exc) {
        b.a dt = dt();
        a(dt, (int) IronSourceError.ERROR_IS_LOAD_DURING_SHOW, (p.a<b>) new a$$ExternalSyntheticLambda2(dt, exc));
    }

    public final void g(float f) {
        b.a dt = dt();
        a(dt, 1019, (p.a<b>) new a$$ExternalSyntheticLambda54(dt, f));
    }

    public final void a(e eVar) {
        b.a dt = dt();
        a(dt, 1020, (p.a<b>) new a$$ExternalSyntheticLambda20(dt, eVar));
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void b(b.a aVar, e eVar, b bVar) {
        bVar.c(aVar, eVar);
        bVar.a(aVar, 2, eVar);
    }

    public final void a(String str, long j, long j2) {
        b.a dt = dt();
        a(dt, 1021, (p.a<b>) new a$$ExternalSyntheticLambda16(dt, str, j2, j));
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(b.a aVar, String str, long j, long j2, b bVar) {
        bVar.b(aVar, str, j);
        long j3 = j;
        bVar.b(aVar, str, j2, j3);
        bVar.a(aVar, 2, str, j3);
    }

    public final void a(v vVar, h hVar) {
        b.a dt = dt();
        a(dt, 1022, (p.a<b>) new a$$ExternalSyntheticLambda27(dt, vVar, hVar));
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(b.a aVar, v vVar, h hVar, b bVar) {
        bVar.b(aVar, vVar);
        bVar.b(aVar, vVar, hVar);
        bVar.a(aVar, 2, vVar);
    }

    public final void b(int i, long j) {
        b.a ds = ds();
        a(ds, 1023, (p.a<b>) new a$$ExternalSyntheticLambda19(ds, i, j));
    }

    public final void r(String str) {
        b.a dt = dt();
        a(dt, 1024, (p.a<b>) new a$$ExternalSyntheticLambda7(dt, str));
    }

    public final void b(e eVar) {
        b.a ds = ds();
        a(ds, 1025, (p.a<b>) new a$$ExternalSyntheticLambda53(ds, eVar));
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(b.a aVar, e eVar, b bVar) {
        bVar.d(aVar, eVar);
        bVar.b(aVar, 2, eVar);
    }

    public final void a(com.applovin.exoplayer2.m.o oVar) {
        b.a dt = dt();
        a(dt, (int) IronSourceError.ERROR_RV_LOAD_SUCCESS_UNEXPECTED, (p.a<b>) new a$$ExternalSyntheticLambda34(dt, oVar));
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(b.a aVar, com.applovin.exoplayer2.m.o oVar, b bVar) {
        bVar.a(aVar, oVar);
        bVar.a(aVar, oVar.dE, oVar.height, oVar.afl, oVar.dH);
    }

    public final void a(Object obj, long j) {
        b.a dt = dt();
        a(dt, (int) IronSourceError.ERROR_RV_LOAD_DURING_SHOW, (p.a<b>) new a$$ExternalSyntheticLambda10(dt, obj, j));
    }

    public final void a(long j, int i) {
        b.a ds = ds();
        a(ds, (int) IronSourceError.ERROR_RV_LOAD_DURING_LOAD, (p.a<b>) new a$$ExternalSyntheticLambda6(ds, j, i));
    }

    public final void a(Exception exc) {
        b.a dt = dt();
        a(dt, (int) IronSourceError.ERROR_RV_SHOW_EXCEPTION, (p.a<b>) new a$$ExternalSyntheticLambda0(dt, exc));
    }

    public void f(int i, int i2) {
        b.a dt = dt();
        a(dt, (int) IronSourceError.ERROR_RV_LOAD_SUCCESS_WRONG_AUCTION_ID, (p.a<b>) new a$$ExternalSyntheticLambda4(dt, i, i2));
    }

    public final void a(int i, p.a aVar, j jVar, com.applovin.exoplayer2.h.m mVar) {
        b.a f = f(i, aVar);
        a(f, 1000, (p.a<b>) new a$$ExternalSyntheticLambda40(f, jVar, mVar));
    }

    public final void b(int i, p.a aVar, j jVar, com.applovin.exoplayer2.h.m mVar) {
        b.a f = f(i, aVar);
        a(f, 1001, (p.a<b>) new a$$ExternalSyntheticLambda51(f, jVar, mVar));
    }

    public final void c(int i, p.a aVar, j jVar, com.applovin.exoplayer2.h.m mVar) {
        b.a f = f(i, aVar);
        a(f, 1002, (p.a<b>) new a$$ExternalSyntheticLambda23(f, jVar, mVar));
    }

    public final void a(int i, p.a aVar, j jVar, com.applovin.exoplayer2.h.m mVar, IOException iOException, boolean z) {
        b.a f = f(i, aVar);
        a(f, 1003, (p.a<b>) new a$$ExternalSyntheticLambda37(f, jVar, mVar, iOException, z));
    }

    public final void a(int i, p.a aVar, com.applovin.exoplayer2.h.m mVar) {
        b.a f = f(i, aVar);
        a(f, 1004, (p.a<b>) new a$$ExternalSyntheticLambda38(f, mVar));
    }

    public final void b(ba baVar, int i) {
        this.iZ.g((an) com.applovin.exoplayer2.l.a.checkNotNull(this.jb));
        b.a dr = dr();
        a(dr, 0, (p.a<b>) new a$$ExternalSyntheticLambda5(dr, i));
    }

    public final void a(ab abVar, int i) {
        b.a dr = dr();
        a(dr, 1, (p.a<b>) new a$$ExternalSyntheticLambda32(dr, abVar, i));
    }

    public final void a(ad adVar, com.applovin.exoplayer2.j.h hVar) {
        b.a dr = dr();
        a(dr, 2, (p.a<b>) new a$$ExternalSyntheticLambda8(dr, adVar, hVar));
    }

    public final void w(boolean z) {
        b.a dr = dr();
        a(dr, 3, (p.a<b>) new a$$ExternalSyntheticLambda31(dr, z));
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void c(b.a aVar, boolean z, b bVar) {
        bVar.d(aVar, z);
        bVar.c(aVar, z);
    }

    public void d(an.a aVar) {
        b.a dr = dr();
        a(dr, 13, (p.a<b>) new a$$ExternalSyntheticLambda11(dr, aVar));
    }

    public final void d(boolean z, int i) {
        b.a dr = dr();
        a(dr, -1, (p.a<b>) new a$$ExternalSyntheticLambda29(dr, z, i));
    }

    public final void Z(int i) {
        b.a dr = dr();
        a(dr, 4, (p.a<b>) new a$$ExternalSyntheticLambda30(dr, i));
    }

    public final void e(boolean z, int i) {
        b.a dr = dr();
        a(dr, 5, (p.a<b>) new a$$ExternalSyntheticLambda17(dr, z, i));
    }

    public final void aa(int i) {
        b.a dr = dr();
        a(dr, 6, (p.a<b>) new a$$ExternalSyntheticLambda55(dr, i));
    }

    public void y(boolean z) {
        b.a dr = dr();
        a(dr, 7, (p.a<b>) new a$$ExternalSyntheticLambda44(dr, z));
    }

    public final void ab(int i) {
        b.a dr = dr();
        a(dr, 8, (p.a<b>) new a$$ExternalSyntheticLambda50(dr, i));
    }

    public final void z(boolean z) {
        b.a dr = dr();
        a(dr, 9, (p.a<b>) new a$$ExternalSyntheticLambda12(dr, z));
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x001a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.applovin.exoplayer2.ak r3) {
        /*
            r2 = this;
            boolean r0 = r3 instanceof com.applovin.exoplayer2.p
            if (r0 == 0) goto L_0x0017
            r0 = r3
            com.applovin.exoplayer2.p r0 = (com.applovin.exoplayer2.p) r0
            com.applovin.exoplayer2.h.o r1 = r0.bx
            if (r1 == 0) goto L_0x0017
            com.applovin.exoplayer2.h.p$a r1 = new com.applovin.exoplayer2.h.p$a
            com.applovin.exoplayer2.h.o r0 = r0.bx
            r1.<init>((com.applovin.exoplayer2.h.o) r0)
            com.applovin.exoplayer2.a.b$a r0 = r2.c((com.applovin.exoplayer2.h.p.a) r1)
            goto L_0x0018
        L_0x0017:
            r0 = 0
        L_0x0018:
            if (r0 != 0) goto L_0x001e
            com.applovin.exoplayer2.a.b$a r0 = r2.dr()
        L_0x001e:
            com.applovin.exoplayer2.a.a$$ExternalSyntheticLambda33 r1 = new com.applovin.exoplayer2.a.a$$ExternalSyntheticLambda33
            r1.<init>(r0, r3)
            r3 = 10
            r2.a((com.applovin.exoplayer2.a.b.a) r0, (int) r3, (com.applovin.exoplayer2.l.p.a<com.applovin.exoplayer2.a.b>) r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.a.a.a(com.applovin.exoplayer2.ak):void");
    }

    public final void a(an.e eVar, an.e eVar2, int i) {
        if (i == 1) {
            this.jc = false;
        }
        this.iZ.f((an) com.applovin.exoplayer2.l.a.checkNotNull(this.jb));
        b.a dr = dr();
        a(dr, 11, (p.a<b>) new a$$ExternalSyntheticLambda28(dr, i, eVar, eVar2));
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(b.a aVar, int i, an.e eVar, an.e eVar2, b bVar) {
        bVar.d(aVar, i);
        bVar.a(aVar, eVar, eVar2, i);
    }

    public final void b(am amVar) {
        b.a dr = dr();
        a(dr, 12, (p.a<b>) new a$$ExternalSyntheticLambda25(dr, amVar));
    }

    public void a(ac acVar) {
        b.a dr = dr();
        a(dr, 14, (p.a<b>) new a$$ExternalSyntheticLambda9(dr, acVar));
    }

    public final void a(com.applovin.exoplayer2.g.a aVar) {
        b.a dr = dr();
        a(dr, 1007, (p.a<b>) new a$$ExternalSyntheticLambda13(dr, aVar));
    }

    public final void cD() {
        b.a dr = dr();
        a(dr, -1, (p.a<b>) new a$$ExternalSyntheticLambda47(dr));
    }

    public final void b(int i, long j, long j2) {
        b.a du = du();
        a(du, 1006, (p.a<b>) new a$$ExternalSyntheticLambda43(du, i, j, j2));
    }

    public final void a(int i, p.a aVar, int i2) {
        b.a f = f(i, aVar);
        a(f, (int) IronSourceError.ERROR_RV_LOAD_FAIL_UNEXPECTED, (p.a<b>) new a$$ExternalSyntheticLambda48(f, i2));
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(b.a aVar, int i, b bVar) {
        bVar.c(aVar);
        bVar.f(aVar, i);
    }

    public final void a(int i, p.a aVar) {
        b.a f = f(i, aVar);
        a(f, (int) IronSourceError.ERROR_RV_LOAD_FAIL_WRONG_AUCTION_ID, (p.a<b>) new a$$ExternalSyntheticLambda42(f));
    }

    public final void a(int i, p.a aVar, Exception exc) {
        b.a f = f(i, aVar);
        a(f, (int) IronSourceError.ERROR_RV_INIT_FAILED_TIMEOUT, (p.a<b>) new a$$ExternalSyntheticLambda3(f, exc));
    }

    public final void b(int i, p.a aVar) {
        b.a f = f(i, aVar);
        a(f, (int) IronSourceError.ERROR_RV_LOAD_FAIL_DUE_TO_INIT, (p.a<b>) new a$$ExternalSyntheticLambda56(f));
    }

    public final void c(int i, p.a aVar) {
        b.a f = f(i, aVar);
        a(f, (int) IronSourceError.ERROR_RV_LOAD_UNEXPECTED_CALLBACK, (p.a<b>) new a$$ExternalSyntheticLambda39(f));
    }

    public final void d(int i, p.a aVar) {
        b.a f = f(i, aVar);
        a(f, (int) IronSourceError.ERROR_IS_LOAD_FAILED_NO_CANDIDATES, (p.a<b>) new a$$ExternalSyntheticLambda41(f));
    }

    /* access modifiers changed from: protected */
    public final void a(b.a aVar, int i, p.a<b> aVar2) {
        this.ja.put(i, aVar);
        this.bG.b(i, aVar2);
    }

    /* access modifiers changed from: protected */
    public final b.a dr() {
        return c(this.iZ.dw());
    }

    /* access modifiers changed from: protected */
    public final b.a a(ba baVar, int i, p.a aVar) {
        ba baVar2 = baVar;
        int i2 = i;
        p.a aVar2 = baVar.isEmpty() ? null : aVar;
        long oK = this.bR.oK();
        boolean z = baVar2.equals(this.jb.aX()) && i2 == this.jb.aL();
        long j = 0;
        if (aVar2 == null || !aVar2.la()) {
            if (z) {
                j = this.jb.aS();
            } else if (!baVar.isEmpty()) {
                j = baVar2.a(i2, this.U).dj();
            }
        } else if (z && this.jb.aQ() == aVar2.gP && this.jb.aR() == aVar2.gQ) {
            j = this.jb.aN();
        }
        return new b.a(oK, baVar, i, aVar2, j, this.jb.aX(), this.jb.aL(), this.iZ.dw(), this.jb.aN(), this.jb.aO());
    }

    private b.a c(p.a aVar) {
        ba baVar;
        com.applovin.exoplayer2.l.a.checkNotNull(this.jb);
        if (aVar == null) {
            baVar = null;
        } else {
            baVar = this.iZ.d(aVar);
        }
        if (aVar != null && baVar != null) {
            return a(baVar, baVar.a(aVar.gM, this.bI).cN, aVar);
        }
        int aL = this.jb.aL();
        ba aX = this.jb.aX();
        if (aL >= aX.cP()) {
            aX = ba.iw;
        }
        return a(aX, aL, (p.a) null);
    }

    private b.a ds() {
        return c(this.iZ.dx());
    }

    private b.a dt() {
        return c(this.iZ.dy());
    }

    private b.a du() {
        return c(this.iZ.dz());
    }

    private b.a f(int i, p.a aVar) {
        com.applovin.exoplayer2.l.a.checkNotNull(this.jb);
        if (aVar == null) {
            ba aX = this.jb.aX();
            if (i >= aX.cP()) {
                aX = ba.iw;
            }
            return a(aX, i, (p.a) null);
        } else if (this.iZ.d(aVar) != null) {
            return c(aVar);
        } else {
            return a(ba.iw, i, aVar);
        }
    }

    /* renamed from: com.applovin.exoplayer2.a.a$a  reason: collision with other inner class name */
    private static final class C0028a {
        private final ba.a bI;
        /* access modifiers changed from: private */
        public s<p.a> jd = s.ga();
        private u<p.a, ba> je = u.gi();
        private p.a jf;
        private p.a jg;
        private p.a jh;

        public p.a dw() {
            return this.jf;
        }

        public p.a dx() {
            return this.jg;
        }

        public p.a dy() {
            return this.jh;
        }

        public C0028a(ba.a aVar) {
            this.bI = aVar;
        }

        public p.a dz() {
            if (this.jd.isEmpty()) {
                return null;
            }
            return (p.a) x.f(this.jd);
        }

        public ba d(p.a aVar) {
            return this.je.get(aVar);
        }

        public void f(an anVar) {
            this.jf = a(anVar, this.jd, this.jg, this.bI);
        }

        public void g(an anVar) {
            this.jf = a(anVar, this.jd, this.jg, this.bI);
            d(anVar.aX());
        }

        public void a(List<p.a> list, p.a aVar, an anVar) {
            this.jd = s.d(list);
            if (!list.isEmpty()) {
                this.jg = list.get(0);
                this.jh = (p.a) com.applovin.exoplayer2.l.a.checkNotNull(aVar);
            }
            if (this.jf == null) {
                this.jf = a(anVar, this.jd, this.jg, this.bI);
            }
            d(anVar.aX());
        }

        private void d(ba baVar) {
            u.a gj = u.gj();
            if (this.jd.isEmpty()) {
                a((u.a<p.a, ba>) gj, this.jg, baVar);
                if (!Objects.equal(this.jh, this.jg)) {
                    a((u.a<p.a, ba>) gj, this.jh, baVar);
                }
                if (!Objects.equal(this.jf, this.jg) && !Objects.equal(this.jf, this.jh)) {
                    a((u.a<p.a, ba>) gj, this.jf, baVar);
                }
            } else {
                for (int i = 0; i < this.jd.size(); i++) {
                    a((u.a<p.a, ba>) gj, (p.a) this.jd.get(i), baVar);
                }
                if (!this.jd.contains(this.jf)) {
                    a((u.a<p.a, ba>) gj, this.jf, baVar);
                }
            }
            this.je = gj.gq();
        }

        private void a(u.a<p.a, ba> aVar, p.a aVar2, ba baVar) {
            if (aVar2 != null) {
                if (baVar.c(aVar2.gM) != -1) {
                    aVar.l(aVar2, baVar);
                    return;
                }
                ba baVar2 = this.je.get(aVar2);
                if (baVar2 != null) {
                    aVar.l(aVar2, baVar2);
                }
            }
        }

        private static p.a a(an anVar, s<p.a> sVar, p.a aVar, ba.a aVar2) {
            ba aX = anVar.aX();
            int aK = anVar.aK();
            Object b = aX.isEmpty() ? null : aX.b(aK);
            int B = (anVar.aP() || aX.isEmpty()) ? -1 : aX.a(aK, aVar2).B(com.applovin.exoplayer2.h.g(anVar.aN()) - aVar2.df());
            for (int i = 0; i < sVar.size(); i++) {
                p.a aVar3 = (p.a) sVar.get(i);
                if (a(aVar3, b, anVar.aP(), anVar.aQ(), anVar.aR(), B)) {
                    return aVar3;
                }
            }
            if (sVar.isEmpty() && aVar != null) {
                if (a(aVar, b, anVar.aP(), anVar.aQ(), anVar.aR(), B)) {
                    return aVar;
                }
            }
            return null;
        }

        private static boolean a(p.a aVar, Object obj, boolean z, int i, int i2, int i3) {
            if (!aVar.gM.equals(obj)) {
                return false;
            }
            if ((z && aVar.gP == i && aVar.gQ == i2) || (!z && aVar.gP == -1 && aVar.LM == i3)) {
                return true;
            }
            return false;
        }
    }
}
