package com.applovin.exoplayer2.e.c;

import com.applovin.exoplayer2.e.g;
import com.applovin.exoplayer2.l.y;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class c extends d {
    private long fH = -9223372036854775807L;
    private long[] wj = new long[0];
    private long[] wk = new long[0];

    public long dd() {
        return this.fH;
    }

    /* access modifiers changed from: protected */
    public boolean e(y yVar) {
        return true;
    }

    public long[] is() {
        return this.wj;
    }

    public long[] it() {
        return this.wk;
    }

    public c() {
        super(new g());
    }

    /* access modifiers changed from: protected */
    public boolean a(y yVar, long j) {
        if (f(yVar) != 2 || !"onMetaData".equals(i(yVar)) || f(yVar) != 8) {
            return false;
        }
        HashMap<String, Object> l = l(yVar);
        Object obj = l.get(IronSourceConstants.EVENTS_DURATION);
        if (obj instanceof Double) {
            double doubleValue = ((Double) obj).doubleValue();
            if (doubleValue > 0.0d) {
                this.fH = (long) (doubleValue * 1000000.0d);
            }
        }
        Object obj2 = l.get("keyframes");
        if (obj2 instanceof Map) {
            Map map = (Map) obj2;
            Object obj3 = map.get("filepositions");
            Object obj4 = map.get("times");
            if ((obj3 instanceof List) && (obj4 instanceof List)) {
                List list = (List) obj3;
                List list2 = (List) obj4;
                int size = list2.size();
                this.wj = new long[size];
                this.wk = new long[size];
                int i = 0;
                while (true) {
                    if (i >= size) {
                        break;
                    }
                    Object obj5 = list.get(i);
                    Object obj6 = list2.get(i);
                    if (!(obj6 instanceof Double) || !(obj5 instanceof Double)) {
                        this.wj = new long[0];
                        this.wk = new long[0];
                    } else {
                        this.wj[i] = (long) (((Double) obj6).doubleValue() * 1000000.0d);
                        this.wk[i] = ((Double) obj5).longValue();
                        i++;
                    }
                }
                this.wj = new long[0];
                this.wk = new long[0];
            }
        }
        return false;
    }

    private static int f(y yVar) {
        return yVar.po();
    }

    private static Boolean g(y yVar) {
        boolean z = true;
        if (yVar.po() != 1) {
            z = false;
        }
        return Boolean.valueOf(z);
    }

    private static Double h(y yVar) {
        return Double.valueOf(Double.longBitsToDouble(yVar.pz()));
    }

    private static String i(y yVar) {
        int pp = yVar.pp();
        int il = yVar.il();
        yVar.fz(pp);
        return new String(yVar.hO(), il, pp);
    }

    private static ArrayList<Object> j(y yVar) {
        int pD = yVar.pD();
        ArrayList<Object> arrayList = new ArrayList<>(pD);
        for (int i = 0; i < pD; i++) {
            Object e = e(yVar, f(yVar));
            if (e != null) {
                arrayList.add(e);
            }
        }
        return arrayList;
    }

    private static HashMap<String, Object> k(y yVar) {
        HashMap<String, Object> hashMap = new HashMap<>();
        while (true) {
            String i = i(yVar);
            int f = f(yVar);
            if (f == 9) {
                return hashMap;
            }
            Object e = e(yVar, f);
            if (e != null) {
                hashMap.put(i, e);
            }
        }
    }

    private static HashMap<String, Object> l(y yVar) {
        int pD = yVar.pD();
        HashMap<String, Object> hashMap = new HashMap<>(pD);
        for (int i = 0; i < pD; i++) {
            String i2 = i(yVar);
            Object e = e(yVar, f(yVar));
            if (e != null) {
                hashMap.put(i2, e);
            }
        }
        return hashMap;
    }

    private static Date m(y yVar) {
        Date date = new Date((long) h(yVar).doubleValue());
        yVar.fz(2);
        return date;
    }

    private static Object e(y yVar, int i) {
        if (i == 0) {
            return h(yVar);
        }
        if (i == 1) {
            return g(yVar);
        }
        if (i == 2) {
            return i(yVar);
        }
        if (i == 3) {
            return k(yVar);
        }
        if (i == 8) {
            return l(yVar);
        }
        if (i == 10) {
            return j(yVar);
        }
        if (i != 11) {
            return null;
        }
        return m(yVar);
    }
}
