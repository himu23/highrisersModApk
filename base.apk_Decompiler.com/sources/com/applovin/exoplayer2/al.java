package com.applovin.exoplayer2;

import com.applovin.exoplayer2.common.a.s;
import com.applovin.exoplayer2.g.a;
import com.applovin.exoplayer2.h.ad;
import com.applovin.exoplayer2.h.p;
import com.applovin.exoplayer2.j.k;
import java.util.List;

final class al {
    private static final p.a gq = new p.a(new Object());
    public final boolean aW;
    public final boolean cD;
    public volatile long cO;
    public final ba ci;
    public final p.a dc;
    public final long de;
    public final ad fB;
    public final k fC;
    public volatile long gA;
    public volatile long gB;
    public final long gr;
    public final int gs;
    public final p gt;
    public final List<a> gu;
    public final p.a gv;
    public final boolean gw;
    public final int gx;
    public final am gy;
    public final boolean gz;

    public static p.a cB() {
        return gq;
    }

    public static al a(k kVar) {
        ba baVar = ba.iw;
        p.a aVar = gq;
        return new al(baVar, aVar, -9223372036854775807L, 0, 1, (p) null, false, ad.NG, kVar, s.ga(), aVar, false, 0, am.gC, 0, 0, 0, false, false);
    }

    public al(ba baVar, p.a aVar, long j, long j2, int i, p pVar, boolean z, ad adVar, k kVar, List<a> list, p.a aVar2, boolean z2, int i2, am amVar, long j3, long j4, long j5, boolean z3, boolean z4) {
        this.ci = baVar;
        this.dc = aVar;
        this.de = j;
        this.gr = j2;
        this.gs = i;
        this.gt = pVar;
        this.aW = z;
        this.fB = adVar;
        this.fC = kVar;
        this.gu = list;
        this.gv = aVar2;
        this.gw = z2;
        this.gx = i2;
        this.gy = amVar;
        this.gA = j3;
        this.gB = j4;
        this.cO = j5;
        this.cD = z3;
        this.gz = z4;
    }

    public al a(p.a aVar, long j, long j2, long j3, long j4, ad adVar, k kVar, List<a> list) {
        long j5 = j;
        ad adVar2 = adVar;
        k kVar2 = kVar;
        List<a> list2 = list;
        ba baVar = this.ci;
        return new al(baVar, aVar, j2, j3, this.gs, this.gt, this.aW, adVar2, kVar2, list2, this.gv, this.gw, this.gx, this.gy, this.gA, j4, j5, this.cD, this.gz);
    }

    public al c(ba baVar) {
        return new al(baVar, this.dc, this.de, this.gr, this.gs, this.gt, this.aW, this.fB, this.fC, this.gu, this.gv, this.gw, this.gx, this.gy, this.gA, this.gB, this.cO, this.cD, this.gz);
    }

    public al W(int i) {
        ba baVar = this.ci;
        return new al(baVar, this.dc, this.de, this.gr, i, this.gt, this.aW, this.fB, this.fC, this.gu, this.gv, this.gw, this.gx, this.gy, this.gA, this.gB, this.cO, this.cD, this.gz);
    }

    public al a(p pVar) {
        ba baVar = this.ci;
        return new al(baVar, this.dc, this.de, this.gr, this.gs, pVar, this.aW, this.fB, this.fC, this.gu, this.gv, this.gw, this.gx, this.gy, this.gA, this.gB, this.cO, this.cD, this.gz);
    }

    public al t(boolean z) {
        ba baVar = this.ci;
        return new al(baVar, this.dc, this.de, this.gr, this.gs, this.gt, z, this.fB, this.fC, this.gu, this.gv, this.gw, this.gx, this.gy, this.gA, this.gB, this.cO, this.cD, this.gz);
    }

    public al b(p.a aVar) {
        ba baVar = this.ci;
        return new al(baVar, this.dc, this.de, this.gr, this.gs, this.gt, this.aW, this.fB, this.fC, this.gu, aVar, this.gw, this.gx, this.gy, this.gA, this.gB, this.cO, this.cD, this.gz);
    }

    public al c(boolean z, int i) {
        ba baVar = this.ci;
        return new al(baVar, this.dc, this.de, this.gr, this.gs, this.gt, this.aW, this.fB, this.fC, this.gu, this.gv, z, i, this.gy, this.gA, this.gB, this.cO, this.cD, this.gz);
    }

    public al d(am amVar) {
        ba baVar = this.ci;
        return new al(baVar, this.dc, this.de, this.gr, this.gs, this.gt, this.aW, this.fB, this.fC, this.gu, this.gv, this.gw, this.gx, amVar, this.gA, this.gB, this.cO, this.cD, this.gz);
    }

    public al u(boolean z) {
        ba baVar = this.ci;
        return new al(baVar, this.dc, this.de, this.gr, this.gs, this.gt, this.aW, this.fB, this.fC, this.gu, this.gv, this.gw, this.gx, this.gy, this.gA, this.gB, this.cO, z, this.gz);
    }

    public al v(boolean z) {
        ba baVar = this.ci;
        return new al(baVar, this.dc, this.de, this.gr, this.gs, this.gt, this.aW, this.fB, this.fC, this.gu, this.gv, this.gw, this.gx, this.gy, this.gA, this.gB, this.cO, this.cD, z);
    }
}
