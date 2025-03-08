package com.applovin.exoplayer2.h;

import android.os.Handler;
import android.os.Looper;
import com.applovin.exoplayer2.ba;
import com.applovin.exoplayer2.d.g;
import com.applovin.exoplayer2.h.p;
import com.applovin.exoplayer2.h.q;
import com.applovin.exoplayer2.k.aa;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public abstract class a implements p {
    private final ArrayList<p.b> KM = new ArrayList<>(1);
    private final HashSet<p.b> KN = new HashSet<>(1);
    private final q.a KO = new q.a();
    private ba ci;
    private final g.a fY = new g.a();
    private Looper gU;

    /* access modifiers changed from: protected */
    public abstract void b(aa aaVar);

    /* access modifiers changed from: protected */
    public void kH() {
    }

    /* access modifiers changed from: protected */
    public void kI() {
    }

    /* access modifiers changed from: protected */
    public abstract void kJ();

    public /* synthetic */ ba lb() {
        return p.CC.$default$lb(this);
    }

    public /* synthetic */ boolean lc() {
        return p.CC.$default$lc(this);
    }

    /* access modifiers changed from: protected */
    public final void e(ba baVar) {
        this.ci = baVar;
        Iterator<p.b> it = this.KM.iterator();
        while (it.hasNext()) {
            it.next().onSourceInfoRefreshed(this, baVar);
        }
    }

    /* access modifiers changed from: protected */
    public final q.a e(p.a aVar) {
        return this.KO.b(0, aVar, 0);
    }

    /* access modifiers changed from: protected */
    public final q.a a(int i, p.a aVar, long j) {
        return this.KO.b(i, aVar, j);
    }

    /* access modifiers changed from: protected */
    public final g.a f(p.a aVar) {
        return this.fY.h(0, aVar);
    }

    /* access modifiers changed from: protected */
    public final g.a i(int i, p.a aVar) {
        return this.fY.h(i, aVar);
    }

    /* access modifiers changed from: protected */
    public final boolean isEnabled() {
        return !this.KN.isEmpty();
    }

    public final void a(Handler handler, q qVar) {
        com.applovin.exoplayer2.l.a.checkNotNull(handler);
        com.applovin.exoplayer2.l.a.checkNotNull(qVar);
        this.KO.a(handler, qVar);
    }

    public final void a(q qVar) {
        this.KO.a(qVar);
    }

    public final void b(Handler handler, g gVar) {
        com.applovin.exoplayer2.l.a.checkNotNull(handler);
        com.applovin.exoplayer2.l.a.checkNotNull(gVar);
        this.fY.a(handler, gVar);
    }

    public final void f(g gVar) {
        this.fY.a(gVar);
    }

    public final void a(p.b bVar, aa aaVar) {
        Looper myLooper = Looper.myLooper();
        Looper looper = this.gU;
        com.applovin.exoplayer2.l.a.checkArgument(looper == null || looper == myLooper);
        ba baVar = this.ci;
        this.KM.add(bVar);
        if (this.gU == null) {
            this.gU = myLooper;
            this.KN.add(bVar);
            b(aaVar);
        } else if (baVar != null) {
            a(bVar);
            bVar.onSourceInfoRefreshed(this, baVar);
        }
    }

    public final void a(p.b bVar) {
        com.applovin.exoplayer2.l.a.checkNotNull(this.gU);
        boolean isEmpty = this.KN.isEmpty();
        this.KN.add(bVar);
        if (isEmpty) {
            kH();
        }
    }

    public final void b(p.b bVar) {
        boolean z = !this.KN.isEmpty();
        this.KN.remove(bVar);
        if (z && this.KN.isEmpty()) {
            kI();
        }
    }

    public final void c(p.b bVar) {
        this.KM.remove(bVar);
        if (this.KM.isEmpty()) {
            this.gU = null;
            this.ci = null;
            this.KN.clear();
            kJ();
            return;
        }
        b(bVar);
    }
}
