package com.applovin.exoplayer2;

import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Pair;
import com.applovin.exoplayer2.ab;
import com.applovin.exoplayer2.common.a.s;
import com.applovin.exoplayer2.g;
import com.applovin.exoplayer2.h.a.a;
import com.applovin.exoplayer2.l.ai;

public abstract class ba implements g {
    public static final g.a<ba> br = new ba$$ExternalSyntheticLambda0();
    public static final ba iw = new ba() {
        public int c(Object obj) {
            return -1;
        }

        public int cP() {
            return 0;
        }

        public int cQ() {
            return 0;
        }

        public c a(int i, c cVar, long j) {
            throw new IndexOutOfBoundsException();
        }

        public a a(int i, a aVar, boolean z) {
            throw new IndexOutOfBoundsException();
        }

        public Object b(int i) {
            throw new IndexOutOfBoundsException();
        }
    };

    public abstract a a(int i, a aVar, boolean z);

    public abstract c a(int i, c cVar, long j);

    public abstract Object b(int i);

    public abstract int c(Object obj);

    public abstract int cP();

    public abstract int cQ();

    public static final class c implements g {
        public static final g.a<c> br = new ba$c$$ExternalSyntheticLambda0();
        public static final Object iF = new Object();
        private static final Object iG = new Object();
        private static final ab iH = new ab.b().n("com.applovin.exoplayer2.Timeline").b(Uri.EMPTY).bV();
        public Object ch = iF;
        public ab.e eb;
        @Deprecated
        public Object er;
        public long fH;
        public ab gL = iH;
        public Object iI;
        public long iJ;
        public long iK;
        public long iL;
        public boolean iM;
        public boolean iN;
        @Deprecated
        public boolean iO;
        public long iP;
        public int iQ;
        public int iR;
        public long iS;
        public boolean iz;

        public long dk() {
            return this.iP;
        }

        public c a(Object obj, ab abVar, Object obj2, long j, long j2, long j3, boolean z, boolean z2, ab.e eVar, long j4, long j5, int i, int i2, long j6) {
            ab abVar2 = abVar;
            ab.e eVar2 = eVar;
            this.ch = obj;
            this.gL = abVar2 != null ? abVar2 : iH;
            this.er = (abVar2 == null || abVar2.ea == null) ? null : abVar2.ea.er;
            this.iI = obj2;
            this.iJ = j;
            this.iK = j2;
            this.iL = j3;
            this.iM = z;
            this.iN = z2;
            this.iO = eVar2 != null;
            this.eb = eVar2;
            this.iP = j4;
            this.fH = j5;
            this.iQ = i;
            this.iR = i2;
            this.iS = j6;
            this.iz = false;
            return this;
        }

        public long dj() {
            return h.f(this.iP);
        }

        public long dl() {
            return h.f(this.fH);
        }

        public long dm() {
            return ai.bv(this.iL);
        }

        public boolean dn() {
            com.applovin.exoplayer2.l.a.checkState(this.iO == (this.eb != null));
            return this.eb != null;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !getClass().equals(obj.getClass())) {
                return false;
            }
            c cVar = (c) obj;
            if (ai.r(this.ch, cVar.ch) && ai.r(this.gL, cVar.gL) && ai.r(this.iI, cVar.iI) && ai.r(this.eb, cVar.eb) && this.iJ == cVar.iJ && this.iK == cVar.iK && this.iL == cVar.iL && this.iM == cVar.iM && this.iN == cVar.iN && this.iz == cVar.iz && this.iP == cVar.iP && this.fH == cVar.fH && this.iQ == cVar.iQ && this.iR == cVar.iR && this.iS == cVar.iS) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i;
            int hashCode = (((217 + this.ch.hashCode()) * 31) + this.gL.hashCode()) * 31;
            Object obj = this.iI;
            int i2 = 0;
            if (obj == null) {
                i = 0;
            } else {
                i = obj.hashCode();
            }
            int i3 = (hashCode + i) * 31;
            ab.e eVar = this.eb;
            if (eVar != null) {
                i2 = eVar.hashCode();
            }
            long j = this.iJ;
            long j2 = this.iK;
            long j3 = this.iL;
            long j4 = this.iP;
            long j5 = this.fH;
            long j6 = this.iS;
            return ((((((((((((((((((((((i3 + i2) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31) + (this.iM ? 1 : 0)) * 31) + (this.iN ? 1 : 0)) * 31) + (this.iz ? 1 : 0)) * 31) + ((int) (j4 ^ (j4 >>> 32)))) * 31) + ((int) (j5 ^ (j5 >>> 32)))) * 31) + this.iQ) * 31) + this.iR) * 31) + ((int) (j6 ^ (j6 >>> 32)));
        }

        /* access modifiers changed from: private */
        public static c s(Bundle bundle) {
            Bundle bundle2 = bundle;
            Bundle bundle3 = bundle2.getBundle(t(1));
            ab.e eVar = null;
            ab fromBundle = bundle3 != null ? ab.br.fromBundle(bundle3) : null;
            long j = bundle2.getLong(t(2), -9223372036854775807L);
            long j2 = bundle2.getLong(t(3), -9223372036854775807L);
            long j3 = bundle2.getLong(t(4), -9223372036854775807L);
            boolean z = bundle2.getBoolean(t(5), false);
            boolean z2 = bundle2.getBoolean(t(6), false);
            Bundle bundle4 = bundle2.getBundle(t(7));
            if (bundle4 != null) {
                eVar = ab.e.br.fromBundle(bundle4);
            }
            boolean z3 = bundle2.getBoolean(t(8), false);
            long j4 = bundle2.getLong(t(9), 0);
            long j5 = bundle2.getLong(t(10), -9223372036854775807L);
            int i = bundle2.getInt(t(11), 0);
            int i2 = bundle2.getInt(t(12), 0);
            long j6 = bundle2.getLong(t(13), 0);
            c cVar = r0;
            c cVar2 = new c();
            cVar.a(iG, fromBundle, (Object) null, j, j2, j3, z, z2, eVar, j4, j5, i, i2, j6);
            cVar2.iz = z3;
            return cVar2;
        }

        private static String t(int i) {
            return Integer.toString(i, 36);
        }
    }

    public static final class a implements g {
        public static final g.a<a> br = new ba$a$$ExternalSyntheticLambda0();
        public int cN;
        public Object ch;
        public long fH;
        /* access modifiers changed from: private */
        public com.applovin.exoplayer2.h.a.a iA = com.applovin.exoplayer2.h.a.a.NI;
        public Object ix;
        public long iy;
        public boolean iz;

        public a a(Object obj, Object obj2, int i, long j, long j2, com.applovin.exoplayer2.h.a.a aVar, boolean z) {
            this.ix = obj;
            this.ch = obj2;
            this.cN = i;
            this.fH = j;
            this.iy = j2;
            this.iA = aVar;
            this.iz = z;
            return this;
        }

        public long dd() {
            return this.fH;
        }

        public long df() {
            return this.iy;
        }

        public a a(Object obj, Object obj2, int i, long j, long j2) {
            return a(obj, obj2, i, j, j2, com.applovin.exoplayer2.h.a.a.NI, false);
        }

        public long de() {
            return h.f(this.iy);
        }

        public int dg() {
            return this.iA.NK;
        }

        public int dh() {
            return this.iA.NO;
        }

        public long al(int i) {
            return this.iA.ec(i).rJ;
        }

        public int am(int i) {
            return this.iA.ec(i).lM();
        }

        public int h(int i, int i2) {
            return this.iA.ec(i).ed(i2);
        }

        public boolean an(int i) {
            return !this.iA.ec(i).lO();
        }

        public int A(long j) {
            return this.iA.x(j, this.fH);
        }

        public int B(long j) {
            return this.iA.y(j, this.fH);
        }

        public int ao(int i) {
            return this.iA.ec(i).NQ;
        }

        public long i(int i, int i2) {
            a.C0048a ec = this.iA.ec(i);
            if (ec.NQ != -1) {
                return ec.tT[i2];
            }
            return -9223372036854775807L;
        }

        public long di() {
            return this.iA.NM;
        }

        public boolean ap(int i) {
            return this.iA.ec(i).NU;
        }

        public long aq(int i) {
            return this.iA.ec(i).NT;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !getClass().equals(obj.getClass())) {
                return false;
            }
            a aVar = (a) obj;
            if (ai.r(this.ix, aVar.ix) && ai.r(this.ch, aVar.ch) && this.cN == aVar.cN && this.fH == aVar.fH && this.iy == aVar.iy && this.iz == aVar.iz && ai.r(this.iA, aVar.iA)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            Object obj = this.ix;
            int i = 0;
            int hashCode = (217 + (obj == null ? 0 : obj.hashCode())) * 31;
            Object obj2 = this.ch;
            if (obj2 != null) {
                i = obj2.hashCode();
            }
            long j = this.fH;
            long j2 = this.iy;
            return ((((((((((hashCode + i) * 31) + this.cN) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + (this.iz ? 1 : 0)) * 31) + this.iA.hashCode();
        }

        /* access modifiers changed from: private */
        public static a r(Bundle bundle) {
            com.applovin.exoplayer2.h.a.a aVar;
            int i = bundle.getInt(t(0), 0);
            long j = bundle.getLong(t(1), -9223372036854775807L);
            long j2 = bundle.getLong(t(2), 0);
            boolean z = bundle.getBoolean(t(3));
            Bundle bundle2 = bundle.getBundle(t(4));
            if (bundle2 != null) {
                aVar = com.applovin.exoplayer2.h.a.a.br.fromBundle(bundle2);
            } else {
                aVar = com.applovin.exoplayer2.h.a.a.NI;
            }
            com.applovin.exoplayer2.h.a.a aVar2 = aVar;
            a aVar3 = new a();
            aVar3.a((Object) null, (Object) null, i, j, j2, aVar2, z);
            return aVar3;
        }

        private static String t(int i) {
            return Integer.toString(i, 36);
        }
    }

    protected ba() {
    }

    public final boolean isEmpty() {
        return cP() == 0;
    }

    public int a(int i, int i2, boolean z) {
        if (i2 != 0) {
            if (i2 == 1) {
                return i;
            }
            if (i2 == 2) {
                return i == c(z) ? d(z) : i + 1;
            }
            throw new IllegalStateException();
        } else if (i == c(z)) {
            return -1;
        } else {
            return i + 1;
        }
    }

    public int b(int i, int i2, boolean z) {
        if (i2 != 0) {
            if (i2 == 1) {
                return i;
            }
            if (i2 == 2) {
                return i == d(z) ? c(z) : i - 1;
            }
            throw new IllegalStateException();
        } else if (i == d(z)) {
            return -1;
        } else {
            return i - 1;
        }
    }

    public int c(boolean z) {
        if (isEmpty()) {
            return -1;
        }
        return cP() - 1;
    }

    public int d(boolean z) {
        return isEmpty() ? -1 : 0;
    }

    public final c a(int i, c cVar) {
        return a(i, cVar, 0);
    }

    public final int a(int i, a aVar, c cVar, int i2, boolean z) {
        int i3 = a(i, aVar).cN;
        if (a(i3, cVar).iR != i) {
            return i + 1;
        }
        int a2 = a(i3, i2, z);
        if (a2 == -1) {
            return -1;
        }
        return a(a2, cVar).iQ;
    }

    public final boolean b(int i, a aVar, c cVar, int i2, boolean z) {
        return a(i, aVar, cVar, i2, z) == -1;
    }

    public final Pair<Object, Long> a(c cVar, a aVar, int i, long j) {
        return (Pair) com.applovin.exoplayer2.l.a.checkNotNull(a(cVar, aVar, i, j, 0));
    }

    public final Pair<Object, Long> a(c cVar, a aVar, int i, long j, long j2) {
        com.applovin.exoplayer2.l.a.h(i, 0, cP());
        a(i, cVar, j2);
        if (j == -9223372036854775807L) {
            j = cVar.dk();
            if (j == -9223372036854775807L) {
                return null;
            }
        }
        int i2 = cVar.iQ;
        a(i2, aVar);
        while (i2 < cVar.iR && aVar.iy != j) {
            int i3 = i2 + 1;
            if (a(i3, aVar).iy > j) {
                break;
            }
            i2 = i3;
        }
        a(i2, aVar, true);
        long j3 = j - aVar.iy;
        if (aVar.fH != -9223372036854775807L) {
            j3 = Math.min(j3, aVar.fH - 1);
        }
        return Pair.create(com.applovin.exoplayer2.l.a.checkNotNull(aVar.ch), Long.valueOf(Math.max(0, j3)));
    }

    public a a(Object obj, a aVar) {
        return a(c(obj), aVar, true);
    }

    public final a a(int i, a aVar) {
        return a(i, aVar, false);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ba)) {
            return false;
        }
        ba baVar = (ba) obj;
        if (baVar.cP() != cP() || baVar.cQ() != cQ()) {
            return false;
        }
        c cVar = new c();
        a aVar = new a();
        c cVar2 = new c();
        a aVar2 = new a();
        for (int i = 0; i < cP(); i++) {
            if (!a(i, cVar).equals(baVar.a(i, cVar2))) {
                return false;
            }
        }
        for (int i2 = 0; i2 < cQ(); i2++) {
            if (!a(i2, aVar, true).equals(baVar.a(i2, aVar2, true))) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        c cVar = new c();
        a aVar = new a();
        int cP = 217 + cP();
        for (int i = 0; i < cP(); i++) {
            cP = (cP * 31) + a(i, cVar).hashCode();
        }
        int cQ = (cP * 31) + cQ();
        for (int i2 = 0; i2 < cQ(); i2++) {
            cQ = (cQ * 31) + a(i2, aVar, true).hashCode();
        }
        return cQ;
    }

    /* access modifiers changed from: private */
    public static ba q(Bundle bundle) {
        s<c> a2 = a(c.br, com.applovin.exoplayer2.l.b.a(bundle, t(0)));
        s<a> a3 = a(a.br, com.applovin.exoplayer2.l.b.a(bundle, t(1)));
        int[] intArray = bundle.getIntArray(t(2));
        if (intArray == null) {
            intArray = ak(a2.size());
        }
        return new b(a2, a3, intArray);
    }

    private static <T extends g> s<T> a(g.a<T> aVar, IBinder iBinder) {
        if (iBinder == null) {
            return s.ga();
        }
        s.a aVar2 = new s.a();
        s<Bundle> a2 = f.a(iBinder);
        for (int i = 0; i < a2.size(); i++) {
            aVar2.t(aVar.fromBundle(a2.get(i)));
        }
        return aVar2.gd();
    }

    private static String t(int i) {
        return Integer.toString(i, 36);
    }

    private static int[] ak(int i) {
        int[] iArr = new int[i];
        for (int i2 = 0; i2 < i; i2++) {
            iArr[i2] = i2;
        }
        return iArr;
    }

    public static final class b extends ba {
        private final s<c> iB;
        private final s<a> iC;
        private final int[] iD;
        private final int[] iE;

        public b(s<c> sVar, s<a> sVar2, int[] iArr) {
            com.applovin.exoplayer2.l.a.checkArgument(sVar.size() == iArr.length);
            this.iB = sVar;
            this.iC = sVar2;
            this.iD = iArr;
            this.iE = new int[iArr.length];
            for (int i = 0; i < iArr.length; i++) {
                this.iE[iArr[i]] = i;
            }
        }

        public int cP() {
            return this.iB.size();
        }

        public c a(int i, c cVar, long j) {
            c cVar2 = cVar;
            c cVar3 = (c) this.iB.get(i);
            Object obj = cVar3.ch;
            ab abVar = cVar3.gL;
            ab abVar2 = abVar;
            c cVar4 = cVar3;
            c cVar5 = cVar;
            cVar5.a(obj, abVar2, cVar3.iI, cVar3.iJ, cVar3.iK, cVar3.iL, cVar3.iM, cVar3.iN, cVar3.eb, cVar3.iP, cVar4.fH, cVar4.iQ, cVar4.iR, cVar4.iS);
            c cVar6 = cVar;
            cVar6.iz = cVar4.iz;
            return cVar6;
        }

        public int a(int i, int i2, boolean z) {
            if (i2 == 1) {
                return i;
            }
            if (i != c(z)) {
                return z ? this.iD[this.iE[i] + 1] : i + 1;
            }
            if (i2 == 2) {
                return d(z);
            }
            return -1;
        }

        public int b(int i, int i2, boolean z) {
            if (i2 == 1) {
                return i;
            }
            if (i != d(z)) {
                return z ? this.iD[this.iE[i] - 1] : i - 1;
            }
            if (i2 == 2) {
                return c(z);
            }
            return -1;
        }

        public int c(boolean z) {
            if (isEmpty()) {
                return -1;
            }
            if (z) {
                return this.iD[cP() - 1];
            }
            return cP() - 1;
        }

        public int d(boolean z) {
            if (isEmpty()) {
                return -1;
            }
            if (z) {
                return this.iD[0];
            }
            return 0;
        }

        public int cQ() {
            return this.iC.size();
        }

        public a a(int i, a aVar, boolean z) {
            a aVar2 = (a) this.iC.get(i);
            aVar.a(aVar2.ix, aVar2.ch, aVar2.cN, aVar2.fH, aVar2.iy, aVar2.iA, aVar2.iz);
            return aVar;
        }

        public int c(Object obj) {
            throw new UnsupportedOperationException();
        }

        public Object b(int i) {
            throw new UnsupportedOperationException();
        }
    }
}
