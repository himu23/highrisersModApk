package com.applovin.exoplayer2.e.g;

import com.applovin.exoplayer2.ai;
import com.applovin.exoplayer2.common.base.Splitter;
import com.applovin.exoplayer2.e.u;
import com.applovin.exoplayer2.g.a;
import com.applovin.exoplayer2.g.f.c;
import com.applovin.exoplayer2.l.y;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

final class i {
    private static final Splitter AJ = Splitter.on(':');
    private static final Splitter AK = Splitter.on('*');
    private final List<a> AL = new ArrayList();
    private int AM = 0;
    private int AN;

    public void Y() {
        this.AL.clear();
        this.AM = 0;
    }

    public int a(com.applovin.exoplayer2.e.i iVar, u uVar, List<a.C0047a> list) throws IOException {
        int i = this.AM;
        long j = 0;
        if (i == 0) {
            long j2 = iVar.m1771if();
            if (j2 != -1 && j2 >= 8) {
                j = j2 - 8;
            }
            uVar.uc = j;
            this.AM = 1;
        } else if (i == 1) {
            g(iVar, uVar);
        } else if (i == 2) {
            h(iVar, uVar);
        } else if (i == 3) {
            a(iVar, list);
            uVar.uc = 0;
        } else {
            throw new IllegalStateException();
        }
        return 1;
    }

    private void g(com.applovin.exoplayer2.e.i iVar, u uVar) throws IOException {
        y yVar = new y(8);
        iVar.a(yVar.hO(), 0, 8);
        this.AN = yVar.py() + 8;
        if (yVar.px() != 1397048916) {
            uVar.uc = 0;
            return;
        }
        uVar.uc = iVar.ie() - ((long) (this.AN - 12));
        this.AM = 2;
    }

    private void h(com.applovin.exoplayer2.e.i iVar, u uVar) throws IOException {
        long j = iVar.m1771if();
        int i = this.AN - 20;
        y yVar = new y(i);
        iVar.a(yVar.hO(), 0, i);
        for (int i2 = 0; i2 < i / 12; i2++) {
            yVar.fz(2);
            short ps = yVar.ps();
            if (ps == 2192 || ps == 2816 || ps == 2817 || ps == 2819 || ps == 2820) {
                this.AL.add(new a(ps, (j - ((long) this.AN)) - ((long) yVar.py()), yVar.py()));
            } else {
                yVar.fz(8);
            }
        }
        if (this.AL.isEmpty()) {
            uVar.uc = 0;
            return;
        }
        this.AM = 3;
        uVar.uc = this.AL.get(0).wE;
    }

    private void a(com.applovin.exoplayer2.e.i iVar, List<a.C0047a> list) throws IOException {
        long ie = iVar.ie();
        int i = (int) ((iVar.m1771if() - iVar.ie()) - ((long) this.AN));
        y yVar = new y(i);
        iVar.a(yVar.hO(), 0, i);
        for (int i2 = 0; i2 < this.AL.size(); i2++) {
            a aVar = this.AL.get(i2);
            yVar.fx((int) (aVar.wE - ie));
            yVar.fz(4);
            int py = yVar.py();
            int I = I(yVar.fB(py));
            int i3 = aVar.oW - (py + 8);
            if (I == 2192) {
                list.add(m(yVar, i3));
            } else if (!(I == 2816 || I == 2817 || I == 2819 || I == 2820)) {
                throw new IllegalStateException();
            }
        }
    }

    private static c m(y yVar, int i) throws ai {
        ArrayList arrayList = new ArrayList();
        List<String> splitToList = AK.splitToList(yVar.fB(i));
        int i2 = 0;
        while (i2 < splitToList.size()) {
            List<String> splitToList2 = AJ.splitToList(splitToList.get(i2));
            if (splitToList2.size() == 3) {
                try {
                    arrayList.add(new c.a(Long.parseLong(splitToList2.get(0)), Long.parseLong(splitToList2.get(1)), 1 << (Integer.parseInt(splitToList2.get(2)) - 1)));
                    i2++;
                } catch (NumberFormatException e) {
                    throw ai.c((String) null, e);
                }
            } else {
                throw ai.c((String) null, (Throwable) null);
            }
        }
        return new c(arrayList);
    }

    private static int I(String str) throws ai {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1711564334:
                if (str.equals("SlowMotion_Data")) {
                    c = 0;
                    break;
                }
                break;
            case -1332107749:
                if (str.equals("Super_SlowMotion_Edit_Data")) {
                    c = 1;
                    break;
                }
                break;
            case -1251387154:
                if (str.equals("Super_SlowMotion_Data")) {
                    c = 2;
                    break;
                }
                break;
            case -830665521:
                if (str.equals("Super_SlowMotion_Deflickering_On")) {
                    c = 3;
                    break;
                }
                break;
            case 1760745220:
                if (str.equals("Super_SlowMotion_BGM")) {
                    c = 4;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return 2192;
            case 1:
                return 2819;
            case 2:
                return 2816;
            case 3:
                return 2820;
            case 4:
                return 2817;
            default:
                throw ai.c("Invalid SEF name", (Throwable) null);
        }
    }

    private static final class a {
        public final int gn;
        public final int oW;
        public final long wE;

        public a(int i, long j, int i2) {
            this.gn = i;
            this.wE = j;
            this.oW = i2;
        }
    }
}
