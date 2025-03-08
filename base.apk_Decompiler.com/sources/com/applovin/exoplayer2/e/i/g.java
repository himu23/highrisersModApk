package com.applovin.exoplayer2.e.i;

import android.util.SparseArray;
import com.applovin.exoplayer2.common.a.s;
import com.applovin.exoplayer2.e.i.ad;
import com.applovin.exoplayer2.l.e;
import com.applovin.exoplayer2.l.y;
import com.applovin.exoplayer2.v;
import java.util.ArrayList;
import java.util.List;

public final class g implements ad.c {
    private final int jF;
    private final List<v> zN;

    private boolean cv(int i) {
        return (i & this.jF) != 0;
    }

    public g() {
        this(0);
    }

    public g(int i) {
        this(i, s.ga());
    }

    public g(int i, List<v> list) {
        this.jF = i;
        this.zN = list;
    }

    public SparseArray<ad> jn() {
        return new SparseArray<>();
    }

    public ad a(int i, ad.b bVar) {
        if (i == 2) {
            return new t(new k(b(bVar)));
        }
        if (i == 3 || i == 4) {
            return new t(new q(bVar.dq));
        }
        if (i == 21) {
            return new t(new o());
        }
        if (i != 27) {
            if (i == 36) {
                return new t(new n(a(bVar)));
            }
            if (i == 89) {
                return new t(new i(bVar.FR));
            }
            if (i != 138) {
                if (i == 172) {
                    return new t(new d(bVar.dq));
                }
                if (i == 257) {
                    return new y(new s("application/vnd.dvb.ait"));
                }
                if (i != 129) {
                    if (i != 130) {
                        if (i != 134) {
                            if (i != 135) {
                                switch (i) {
                                    case 15:
                                        if (cv(2)) {
                                            return null;
                                        }
                                        return new t(new f(false, bVar.dq));
                                    case 16:
                                        return new t(new l(b(bVar)));
                                    case 17:
                                        if (cv(2)) {
                                            return null;
                                        }
                                        return new t(new p(bVar.dq));
                                    default:
                                        return null;
                                }
                            }
                        } else if (cv(16)) {
                            return null;
                        } else {
                            return new y(new s("application/x-scte35"));
                        }
                    } else if (!cv(64)) {
                        return null;
                    }
                }
                return new t(new b(bVar.dq));
            }
            return new t(new h(bVar.dq));
        } else if (cv(4)) {
            return null;
        } else {
            return new t(new m(a(bVar), cv(1), cv(8)));
        }
    }

    private z a(ad.b bVar) {
        return new z(c(bVar));
    }

    private af b(ad.b bVar) {
        return new af(c(bVar));
    }

    private List<v> c(ad.b bVar) {
        String str;
        int i;
        List<byte[]> list;
        if (cv(32)) {
            return this.zN;
        }
        y yVar = new y(bVar.FT);
        List<v> list2 = this.zN;
        while (yVar.pj() > 0) {
            int po = yVar.po();
            int il = yVar.il() + yVar.po();
            if (po == 134) {
                list2 = new ArrayList<>();
                int po2 = yVar.po() & 31;
                for (int i2 = 0; i2 < po2; i2++) {
                    String fB = yVar.fB(3);
                    int po3 = yVar.po();
                    boolean z = true;
                    boolean z2 = (po3 & 128) != 0;
                    if (z2) {
                        i = po3 & 63;
                        str = "application/cea-708";
                    } else {
                        str = "application/cea-608";
                        i = 1;
                    }
                    byte po4 = (byte) yVar.po();
                    yVar.fz(1);
                    if (z2) {
                        if ((po4 & 64) == 0) {
                            z = false;
                        }
                        list = e.as(z);
                    } else {
                        list = null;
                    }
                    list2.add(new v.a().m(str).j(fB).S(i).c(list).bT());
                }
            }
            yVar.fx(il);
        }
        return list2;
    }
}
