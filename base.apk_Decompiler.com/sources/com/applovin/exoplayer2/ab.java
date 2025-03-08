package com.applovin.exoplayer2;

import android.net.Uri;
import android.os.Bundle;
import com.applovin.exoplayer2.common.a.s;
import com.applovin.exoplayer2.common.a.u;
import com.applovin.exoplayer2.g;
import com.applovin.exoplayer2.l.ai;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public final class ab implements g {
    public static final g.a<ab> br = new ab$$ExternalSyntheticLambda0();
    public static final ab dY = new b().bV();
    public final ac cb;
    public final String dZ;
    public final f ea;
    public final e eb;
    public final c ec;

    public static ab a(Uri uri) {
        return new b().b(uri).bV();
    }

    public static final class b {
        private ac cb;
        private String dZ;
        private Uri ef;
        private String eg;
        private long eh;
        private long ei;
        private boolean ej;
        private boolean ek;
        private boolean el;
        private d.a em;
        private List<Object> en;
        private String eo;
        private List<Object> ep;
        private a eq;
        private Object er;
        private e.a es;

        public b b(Uri uri) {
            this.ef = uri;
            return this;
        }

        public b e(Object obj) {
            this.er = obj;
            return this;
        }

        public b o(String str) {
            this.eo = str;
            return this;
        }

        public b() {
            this.ei = Long.MIN_VALUE;
            this.em = new d.a();
            this.en = Collections.emptyList();
            this.ep = Collections.emptyList();
            this.es = new e.a();
        }

        private b(ab abVar) {
            this();
            d.a aVar;
            this.ei = abVar.ec.eu;
            this.ej = abVar.ec.ev;
            this.ek = abVar.ec.ew;
            this.eh = abVar.ec.et;
            this.el = abVar.ec.ex;
            this.dZ = abVar.dZ;
            this.cb = abVar.cb;
            this.es = abVar.eb.bZ();
            f fVar = abVar.ea;
            if (fVar != null) {
                this.eo = fVar.eo;
                this.eg = fVar.eg;
                this.ef = fVar.ef;
                this.en = fVar.en;
                this.ep = fVar.ep;
                this.er = fVar.er;
                if (fVar.eL != null) {
                    aVar = fVar.eL.bX();
                } else {
                    aVar = new d.a();
                }
                this.em = aVar;
                this.eq = fVar.eq;
            }
        }

        public b n(String str) {
            this.dZ = (String) com.applovin.exoplayer2.l.a.checkNotNull(str);
            return this;
        }

        public ab bV() {
            f fVar;
            com.applovin.exoplayer2.l.a.checkState(this.em.ez == null || this.em.ey != null);
            Uri uri = this.ef;
            d dVar = null;
            if (uri != null) {
                String str = this.eg;
                if (this.em.ey != null) {
                    dVar = this.em.bY();
                }
                fVar = new f(uri, str, dVar, this.eq, this.en, this.eo, this.ep, this.er);
            } else {
                fVar = null;
            }
            String str2 = this.dZ;
            if (str2 == null) {
                str2 = "";
            }
            String str3 = str2;
            c cVar = new c(this.eh, this.ei, this.ej, this.ek, this.el);
            e ca = this.es.ca();
            ac acVar = this.cb;
            if (acVar == null) {
                acVar = ac.eM;
            }
            return new ab(str3, cVar, fVar, ca, acVar);
        }
    }

    public static final class d {
        public final u<String, String> eA;
        public final boolean eB;
        public final boolean eC;
        public final boolean eD;
        public final s<Integer> eE;
        /* access modifiers changed from: private */
        public final byte[] eF;
        public final UUID ey;
        public final Uri ez;

        public static final class a {
            /* access modifiers changed from: private */
            public boolean eB;
            /* access modifiers changed from: private */
            public boolean eC;
            /* access modifiers changed from: private */
            public boolean eD;
            /* access modifiers changed from: private */
            public s<Integer> eE;
            /* access modifiers changed from: private */
            public byte[] eF;
            /* access modifiers changed from: private */
            public u<String, String> eG;
            /* access modifiers changed from: private */
            public UUID ey;
            /* access modifiers changed from: private */
            public Uri ez;

            @Deprecated
            private a() {
                this.eG = u.gi();
                this.eE = s.ga();
            }

            private a(d dVar) {
                this.ey = dVar.ey;
                this.ez = dVar.ez;
                this.eG = dVar.eA;
                this.eB = dVar.eB;
                this.eC = dVar.eC;
                this.eD = dVar.eD;
                this.eE = dVar.eE;
                this.eF = dVar.eF;
            }

            public d bY() {
                return new d(this);
            }
        }

        private d(a aVar) {
            com.applovin.exoplayer2.l.a.checkState(!aVar.eD || aVar.ez != null);
            this.ey = (UUID) com.applovin.exoplayer2.l.a.checkNotNull(aVar.ey);
            this.ez = aVar.ez;
            this.eA = aVar.eG;
            this.eB = aVar.eB;
            this.eD = aVar.eD;
            this.eC = aVar.eC;
            this.eE = aVar.eE;
            this.eF = aVar.eF != null ? Arrays.copyOf(aVar.eF, aVar.eF.length) : null;
        }

        public byte[] bW() {
            byte[] bArr = this.eF;
            if (bArr != null) {
                return Arrays.copyOf(bArr, bArr.length);
            }
            return null;
        }

        public a bX() {
            return new a();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            if (!this.ey.equals(dVar.ey) || !ai.r(this.ez, dVar.ez) || !ai.r(this.eA, dVar.eA) || this.eB != dVar.eB || this.eD != dVar.eD || this.eC != dVar.eC || !this.eE.equals(dVar.eE) || !Arrays.equals(this.eF, dVar.eF)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int hashCode = this.ey.hashCode() * 31;
            Uri uri = this.ez;
            return ((((((((((((hashCode + (uri != null ? uri.hashCode() : 0)) * 31) + this.eA.hashCode()) * 31) + (this.eB ? 1 : 0)) * 31) + (this.eD ? 1 : 0)) * 31) + (this.eC ? 1 : 0)) * 31) + this.eE.hashCode()) * 31) + Arrays.hashCode(this.eF);
        }
    }

    public static final class a {
        public final Uri ed;
        public final Object ee;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (!this.ed.equals(aVar.ed) || !ai.r(this.ee, aVar.ee)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int hashCode = this.ed.hashCode() * 31;
            Object obj = this.ee;
            return hashCode + (obj != null ? obj.hashCode() : 0);
        }
    }

    public static final class f {
        public final d eL;
        public final Uri ef;
        public final String eg;
        public final List<Object> en;
        public final String eo;
        public final List<Object> ep;
        public final a eq;
        public final Object er;

        private f(Uri uri, String str, d dVar, a aVar, List<Object> list, String str2, List<Object> list2, Object obj) {
            this.ef = uri;
            this.eg = str;
            this.eL = dVar;
            this.eq = aVar;
            this.en = list;
            this.eo = str2;
            this.ep = list2;
            this.er = obj;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof f)) {
                return false;
            }
            f fVar = (f) obj;
            if (!this.ef.equals(fVar.ef) || !ai.r(this.eg, fVar.eg) || !ai.r(this.eL, fVar.eL) || !ai.r(this.eq, fVar.eq) || !this.en.equals(fVar.en) || !ai.r(this.eo, fVar.eo) || !this.ep.equals(fVar.ep) || !ai.r(this.er, fVar.er)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int i;
            int i2;
            int i3;
            int i4;
            int hashCode = this.ef.hashCode() * 31;
            String str = this.eg;
            int i5 = 0;
            if (str == null) {
                i = 0;
            } else {
                i = str.hashCode();
            }
            int i6 = (hashCode + i) * 31;
            d dVar = this.eL;
            if (dVar == null) {
                i2 = 0;
            } else {
                i2 = dVar.hashCode();
            }
            int i7 = (i6 + i2) * 31;
            a aVar = this.eq;
            if (aVar == null) {
                i3 = 0;
            } else {
                i3 = aVar.hashCode();
            }
            int hashCode2 = (((i7 + i3) * 31) + this.en.hashCode()) * 31;
            String str2 = this.eo;
            if (str2 == null) {
                i4 = 0;
            } else {
                i4 = str2.hashCode();
            }
            int hashCode3 = (((hashCode2 + i4) * 31) + this.ep.hashCode()) * 31;
            Object obj = this.er;
            if (obj != null) {
                i5 = obj.hashCode();
            }
            return hashCode3 + i5;
        }
    }

    public static final class e implements g {
        public static final g.a<e> br = new ab$e$$ExternalSyntheticLambda0();
        public static final e eH = new a().ca();
        public final float aE;
        public final float aF;
        public final long eI;
        public final long eJ;
        public final long eK;

        public static final class a {
            /* access modifiers changed from: private */
            public float aE;
            /* access modifiers changed from: private */
            public float aF;
            /* access modifiers changed from: private */
            public long eI;
            /* access modifiers changed from: private */
            public long eJ;
            /* access modifiers changed from: private */
            public long eK;

            public a() {
                this.eI = -9223372036854775807L;
                this.eJ = -9223372036854775807L;
                this.eK = -9223372036854775807L;
                this.aF = -3.4028235E38f;
                this.aE = -3.4028235E38f;
            }

            private a(e eVar) {
                this.eI = eVar.eI;
                this.eJ = eVar.eJ;
                this.eK = eVar.eK;
                this.aF = eVar.aF;
                this.aE = eVar.aE;
            }

            public e ca() {
                return new e(this);
            }
        }

        private e(a aVar) {
            this(aVar.eI, aVar.eJ, aVar.eK, aVar.aF, aVar.aE);
        }

        @Deprecated
        public e(long j, long j2, long j3, float f, float f2) {
            this.eI = j;
            this.eJ = j2;
            this.eK = j3;
            this.aF = f;
            this.aE = f2;
        }

        public a bZ() {
            return new a();
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof e)) {
                return false;
            }
            e eVar = (e) obj;
            if (this.eI == eVar.eI && this.eJ == eVar.eJ && this.eK == eVar.eK && this.aF == eVar.aF && this.aE == eVar.aE) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            long j = this.eI;
            long j2 = this.eJ;
            long j3 = this.eK;
            int i = ((((((int) (j ^ (j >>> 32))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31;
            float f = this.aF;
            int i2 = 0;
            int floatToIntBits = (i + (f != 0.0f ? Float.floatToIntBits(f) : 0)) * 31;
            float f2 = this.aE;
            if (f2 != 0.0f) {
                i2 = Float.floatToIntBits(f2);
            }
            return floatToIntBits + i2;
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ e f(Bundle bundle) {
            return new e(bundle.getLong(t(0), -9223372036854775807L), bundle.getLong(t(1), -9223372036854775807L), bundle.getLong(t(2), -9223372036854775807L), bundle.getFloat(t(3), -3.4028235E38f), bundle.getFloat(t(4), -3.4028235E38f));
        }

        private static String t(int i) {
            return Integer.toString(i, 36);
        }
    }

    public static final class c implements g {
        public static final g.a<c> br = new ab$c$$ExternalSyntheticLambda0();
        public final long et;
        public final long eu;
        public final boolean ev;
        public final boolean ew;
        public final boolean ex;

        public int hashCode() {
            long j = this.et;
            long j2 = this.eu;
            return (((((((((int) (j ^ (j >>> 32))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + (this.ev ? 1 : 0)) * 31) + (this.ew ? 1 : 0)) * 31) + (this.ex ? 1 : 0);
        }

        private c(long j, long j2, boolean z, boolean z2, boolean z3) {
            this.et = j;
            this.eu = j2;
            this.ev = z;
            this.ew = z2;
            this.ex = z3;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            if (this.et == cVar.et && this.eu == cVar.eu && this.ev == cVar.ev && this.ew == cVar.ew && this.ex == cVar.ex) {
                return true;
            }
            return false;
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ c e(Bundle bundle) {
            return new c(bundle.getLong(t(0), 0), bundle.getLong(t(1), Long.MIN_VALUE), bundle.getBoolean(t(2), false), bundle.getBoolean(t(3), false), bundle.getBoolean(t(4), false));
        }

        private static String t(int i) {
            return Integer.toString(i, 36);
        }
    }

    private ab(String str, c cVar, f fVar, e eVar, ac acVar) {
        this.dZ = str;
        this.ea = fVar;
        this.eb = eVar;
        this.cb = acVar;
        this.ec = cVar;
    }

    public b bU() {
        return new b();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ab)) {
            return false;
        }
        ab abVar = (ab) obj;
        if (!ai.r(this.dZ, abVar.dZ) || !this.ec.equals(abVar.ec) || !ai.r(this.ea, abVar.ea) || !ai.r(this.eb, abVar.eb) || !ai.r(this.cb, abVar.cb)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hashCode = this.dZ.hashCode() * 31;
        f fVar = this.ea;
        return ((((((hashCode + (fVar != null ? fVar.hashCode() : 0)) * 31) + this.eb.hashCode()) * 31) + this.ec.hashCode()) * 31) + this.cb.hashCode();
    }

    /* access modifiers changed from: private */
    public static ab d(Bundle bundle) {
        e eVar;
        ac acVar;
        c cVar;
        Bundle bundle2 = bundle;
        String str = (String) com.applovin.exoplayer2.l.a.checkNotNull(bundle2.getString(t(0), ""));
        Bundle bundle3 = bundle2.getBundle(t(1));
        if (bundle3 == null) {
            eVar = e.eH;
        } else {
            eVar = e.br.fromBundle(bundle3);
        }
        e eVar2 = eVar;
        Bundle bundle4 = bundle2.getBundle(t(2));
        if (bundle4 == null) {
            acVar = ac.eM;
        } else {
            acVar = ac.br.fromBundle(bundle4);
        }
        ac acVar2 = acVar;
        Bundle bundle5 = bundle2.getBundle(t(3));
        if (bundle5 == null) {
            cVar = new c(0, Long.MIN_VALUE, false, false, false);
        } else {
            cVar = c.br.fromBundle(bundle5);
        }
        return new ab(str, cVar, (f) null, eVar2, acVar2);
    }

    private static String t(int i) {
        return Integer.toString(i, 36);
    }
}
