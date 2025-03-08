package com.applovin.exoplayer2.j;

import com.applovin.exoplayer2.ba;
import com.applovin.exoplayer2.common.a.ad;
import com.applovin.exoplayer2.common.a.s;
import com.applovin.exoplayer2.common.a.z;
import com.applovin.exoplayer2.h.ac;
import com.applovin.exoplayer2.h.p;
import com.applovin.exoplayer2.j.d;
import com.applovin.exoplayer2.k.d;
import com.applovin.exoplayer2.l.q;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class a extends b {
    private final long TO;
    private final long TP;
    private final long TQ;
    private final float TR;
    private final float TS;
    private final s<C0057a> TT;
    private float TU;
    private int TV;
    private long TW;
    private com.applovin.exoplayer2.h.b.b TX;
    private final d bO;
    private final com.applovin.exoplayer2.l.d bR;
    private int tA;

    public void X() {
        this.TX = null;
    }

    public void enable() {
        this.TW = -9223372036854775807L;
        this.TX = null;
    }

    public int ne() {
        return this.TV;
    }

    public void v(float f) {
        this.TU = f;
    }

    public static class b implements d.b {
        private final float TR;
        private final float TS;
        private final int Ua;
        private final int Ub;
        private final int Uc;
        private final com.applovin.exoplayer2.l.d bR;

        public b() {
            this(10000, 25000, 25000, 0.7f, 0.75f, com.applovin.exoplayer2.l.d.abJ);
        }

        public b(int i, int i2, int i3, float f, float f2, com.applovin.exoplayer2.l.d dVar) {
            this.Ua = i;
            this.Ub = i2;
            this.Uc = i3;
            this.TR = f;
            this.TS = f2;
            this.bR = dVar;
        }

        public final d[] a(d.a[] aVarArr, com.applovin.exoplayer2.k.d dVar, p.a aVar, ba baVar) {
            d dVar2;
            d.a[] aVarArr2 = aVarArr;
            s c = a.a(aVarArr);
            d[] dVarArr = new d[aVarArr2.length];
            for (int i = 0; i < aVarArr2.length; i++) {
                d.a aVar2 = aVarArr2[i];
                if (!(aVar2 == null || aVar2.Ue.length == 0)) {
                    if (aVar2.Ue.length == 1) {
                        dVar2 = new e(aVar2.Ud, aVar2.Ue[0], aVar2.bs);
                    } else {
                        dVar2 = a(aVar2.Ud, aVar2.Ue, aVar2.bs, dVar, (s) c.get(i));
                    }
                    dVarArr[i] = dVar2;
                }
            }
            return dVarArr;
        }

        /* access modifiers changed from: protected */
        public a a(ac acVar, int[] iArr, int i, com.applovin.exoplayer2.k.d dVar, s<C0057a> sVar) {
            return new a(acVar, iArr, i, dVar, (long) this.Ua, (long) this.Ub, (long) this.Uc, this.TR, this.TS, sVar, this.bR);
        }
    }

    protected a(ac acVar, int[] iArr, int i, com.applovin.exoplayer2.k.d dVar, long j, long j2, long j3, float f, float f2, List<C0057a> list, com.applovin.exoplayer2.l.d dVar2) {
        super(acVar, iArr, i);
        if (j3 < j) {
            q.h("AdaptiveTrackSelection", "Adjusting minDurationToRetainAfterDiscardMs to be at least minDurationForQualityIncreaseMs");
            j3 = j;
        }
        this.bO = dVar;
        this.TO = j * 1000;
        this.TP = j2 * 1000;
        this.TQ = j3 * 1000;
        this.TR = f;
        this.TS = f2;
        this.TT = s.d(list);
        this.bR = dVar2;
        this.TU = 1.0f;
        this.tA = 0;
        this.TW = -9223372036854775807L;
    }

    /* access modifiers changed from: private */
    public static s<s<C0057a>> a(d.a[] aVarArr) {
        ArrayList arrayList = new ArrayList();
        for (d.a aVar : aVarArr) {
            if (aVar == null || aVar.Ue.length <= 1) {
                arrayList.add((Object) null);
            } else {
                s.a gc = s.gc();
                gc.t(new C0057a(0, 0));
                arrayList.add(gc);
            }
        }
        long[][] b2 = b(aVarArr);
        int[] iArr = new int[b2.length];
        long[] jArr = new long[b2.length];
        for (int i = 0; i < b2.length; i++) {
            long[] jArr2 = b2[i];
            jArr[i] = jArr2.length == 0 ? 0 : jArr2[0];
        }
        a(arrayList, jArr);
        s<Integer> a = a(b2);
        for (int i2 = 0; i2 < a.size(); i2++) {
            int intValue = ((Integer) a.get(i2)).intValue();
            int i3 = iArr[intValue] + 1;
            iArr[intValue] = i3;
            jArr[intValue] = b2[intValue][i3];
            a(arrayList, jArr);
        }
        for (int i4 = 0; i4 < aVarArr.length; i4++) {
            if (arrayList.get(i4) != null) {
                jArr[i4] = jArr[i4] * 2;
            }
        }
        a(arrayList, jArr);
        s.a gc2 = s.gc();
        for (int i5 = 0; i5 < arrayList.size(); i5++) {
            s.a aVar2 = (s.a) arrayList.get(i5);
            gc2.t(aVar2 == null ? s.ga() : aVar2.gd());
        }
        return gc2.gd();
    }

    private static long[][] b(d.a[] aVarArr) {
        long[][] jArr = new long[aVarArr.length][];
        for (int i = 0; i < aVarArr.length; i++) {
            d.a aVar = aVarArr[i];
            if (aVar == null) {
                jArr[i] = new long[0];
            } else {
                jArr[i] = new long[aVar.Ue.length];
                for (int i2 = 0; i2 < aVar.Ue.length; i2++) {
                    jArr[i][i2] = (long) aVar.Ud.dZ(aVar.Ue[i2]).dv;
                }
                Arrays.sort(jArr[i]);
            }
        }
        return jArr;
    }

    private static s<Integer> a(long[][] jArr) {
        double d;
        z<K, V> gL = ad.gI().gM().gL();
        for (int i = 0; i < jArr.length; i++) {
            long[] jArr2 = jArr[i];
            if (jArr2.length > 1) {
                int length = jArr2.length;
                double[] dArr = new double[length];
                int i2 = 0;
                while (true) {
                    long[] jArr3 = jArr[i];
                    double d2 = 0.0d;
                    if (i2 >= jArr3.length) {
                        break;
                    }
                    long j = jArr3[i2];
                    if (j != -1) {
                        d2 = Math.log((double) j);
                    }
                    dArr[i2] = d2;
                    i2++;
                }
                int i3 = length - 1;
                double d3 = dArr[i3] - dArr[0];
                int i4 = 0;
                while (i4 < i3) {
                    double d4 = dArr[i4];
                    i4++;
                    double d5 = (d4 + dArr[i4]) * 0.5d;
                    if (d3 == 0.0d) {
                        d = 1.0d;
                    } else {
                        d = (d5 - dArr[0]) / d3;
                    }
                    gL.c(Double.valueOf(d), Integer.valueOf(i));
                }
            }
        }
        return s.d(gL.values());
    }

    private static void a(List<s.a<C0057a>> list, long[] jArr) {
        long j = 0;
        for (long j2 : jArr) {
            j += j2;
        }
        for (int i = 0; i < list.size(); i++) {
            s.a aVar = list.get(i);
            if (aVar != null) {
                aVar.t(new C0057a(j, jArr[i]));
            }
        }
    }

    /* renamed from: com.applovin.exoplayer2.j.a$a  reason: collision with other inner class name */
    public static final class C0057a {
        public final long TY;
        public final long TZ;

        public int hashCode() {
            return (((int) this.TY) * 31) + ((int) this.TZ);
        }

        public C0057a(long j, long j2) {
            this.TY = j;
            this.TZ = j2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0057a)) {
                return false;
            }
            C0057a aVar = (C0057a) obj;
            if (this.TY == aVar.TY && this.TZ == aVar.TZ) {
                return true;
            }
            return false;
        }
    }
}
