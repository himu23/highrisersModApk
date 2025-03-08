package com.applovin.exoplayer2.k;

import com.applovin.exoplayer2.k.i;
import com.applovin.exoplayer2.l.a;
import com.applovin.exoplayer2.l.ai;
import java.util.ArrayList;
import java.util.Map;

public abstract class e implements i {
    private final boolean Zn;
    private final ArrayList<aa> Zo = new ArrayList<>(1);
    private int Zp;
    private l tw;

    public /* synthetic */ Map kT() {
        return i.CC.$default$kT(this);
    }

    protected e(boolean z) {
        this.Zn = z;
    }

    public final void c(aa aaVar) {
        a.checkNotNull(aaVar);
        if (!this.Zo.contains(aaVar)) {
            this.Zo.add(aaVar);
            this.Zp++;
        }
    }

    /* access modifiers changed from: protected */
    public final void b(l lVar) {
        for (int i = 0; i < this.Zp; i++) {
            this.Zo.get(i).a(this, lVar, this.Zn);
        }
    }

    /* access modifiers changed from: protected */
    public final void c(l lVar) {
        this.tw = lVar;
        for (int i = 0; i < this.Zp; i++) {
            this.Zo.get(i).b(this, lVar, this.Zn);
        }
    }

    /* access modifiers changed from: protected */
    public final void fe(int i) {
        l lVar = (l) ai.R(this.tw);
        for (int i2 = 0; i2 < this.Zp; i2++) {
            this.Zo.get(i2).a(this, lVar, this.Zn, i);
        }
    }

    /* access modifiers changed from: protected */
    public final void oe() {
        l lVar = (l) ai.R(this.tw);
        for (int i = 0; i < this.Zp; i++) {
            this.Zo.get(i).c(this, lVar, this.Zn);
        }
        this.tw = null;
    }
}
