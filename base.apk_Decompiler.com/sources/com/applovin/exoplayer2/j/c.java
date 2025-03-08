package com.applovin.exoplayer2.j;

import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import androidx.core.view.PointerIconCompat;
import com.applovin.exoplayer2.as;
import com.applovin.exoplayer2.at;
import com.applovin.exoplayer2.ba;
import com.applovin.exoplayer2.common.a.ai;
import com.applovin.exoplayer2.common.a.n;
import com.applovin.exoplayer2.common.a.s;
import com.applovin.exoplayer2.g;
import com.applovin.exoplayer2.h.ac;
import com.applovin.exoplayer2.h.ad;
import com.applovin.exoplayer2.h.p;
import com.applovin.exoplayer2.j.a;
import com.applovin.exoplayer2.j.d;
import com.applovin.exoplayer2.j.f;
import com.applovin.exoplayer2.j.i;
import com.applovin.exoplayer2.v;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

public class c extends f {
    private static final int[] Ug = new int[0];
    /* access modifiers changed from: private */
    public static final ai<Integer> Uh = ai.b(new c$$ExternalSyntheticLambda0());
    /* access modifiers changed from: private */
    public static final ai<Integer> Ui = ai.b(new c$$ExternalSyntheticLambda1());
    private final d.b Uj;
    private final AtomicReference<C0058c> Uk;

    /* access modifiers changed from: private */
    public static /* synthetic */ int a(Integer num, Integer num2) {
        return 0;
    }

    public boolean nh() {
        return true;
    }

    public static final class d extends i.a {
        /* access modifiers changed from: private */
        public boolean UA;
        /* access modifiers changed from: private */
        public boolean UB;
        /* access modifiers changed from: private */
        public boolean UC;
        /* access modifiers changed from: private */
        public boolean UD;
        /* access modifiers changed from: private */
        public boolean UE;
        /* access modifiers changed from: private */
        public boolean UF;
        /* access modifiers changed from: private */
        public boolean UG;
        /* access modifiers changed from: private */
        public boolean UH;
        /* access modifiers changed from: private */
        public boolean UI;
        /* access modifiers changed from: private */
        public final SparseArray<Map<ad, e>> UJ;
        /* access modifiers changed from: private */
        public final SparseBooleanArray UK;
        /* access modifiers changed from: private */
        public int Uy;
        /* access modifiers changed from: private */
        public boolean Uz;

        private void nl() {
            this.Uz = true;
            this.UA = false;
            this.UB = true;
            this.UC = true;
            this.UD = false;
            this.UE = false;
            this.UF = false;
            this.Uy = 0;
            this.UG = true;
            this.UH = false;
            this.UI = true;
        }

        public d ac(boolean z) {
            this.Uz = z;
            return this;
        }

        public d ad(boolean z) {
            this.UA = z;
            return this;
        }

        public d ae(boolean z) {
            this.UB = z;
            return this;
        }

        public d af(boolean z) {
            this.UC = z;
            return this;
        }

        public d ag(boolean z) {
            this.UD = z;
            return this;
        }

        public d ah(boolean z) {
            this.UE = z;
            return this;
        }

        public d ai(boolean z) {
            this.UF = z;
            return this;
        }

        public d aj(boolean z) {
            this.UG = z;
            return this;
        }

        public d ak(boolean z) {
            this.UH = z;
            return this;
        }

        public d al(boolean z) {
            this.UI = z;
            return this;
        }

        public d eR(int i) {
            this.Uy = i;
            return this;
        }

        @Deprecated
        public d() {
            this.UJ = new SparseArray<>();
            this.UK = new SparseBooleanArray();
            nl();
        }

        public d(Context context) {
            super(context);
            this.UJ = new SparseArray<>();
            this.UK = new SparseBooleanArray();
            nl();
        }

        private d(Bundle bundle) {
            super(bundle);
            C0058c cVar = C0058c.Uw;
            ac(bundle.getBoolean(C0058c.t(1000), cVar.Uz));
            ad(bundle.getBoolean(C0058c.t(1001), cVar.UA));
            ae(bundle.getBoolean(C0058c.t(1002), cVar.UB));
            af(bundle.getBoolean(C0058c.t(1003), cVar.UC));
            ag(bundle.getBoolean(C0058c.t(1004), cVar.UD));
            ah(bundle.getBoolean(C0058c.t(1005), cVar.UE));
            ai(bundle.getBoolean(C0058c.t(1006), cVar.UF));
            eR(bundle.getInt(C0058c.t(1007), cVar.Uy));
            aj(bundle.getBoolean(C0058c.t(1008), cVar.UG));
            ak(bundle.getBoolean(C0058c.t(1009), cVar.UH));
            al(bundle.getBoolean(C0058c.t(1010), cVar.UI));
            this.UJ = new SparseArray<>();
            B(bundle);
            this.UK = f(bundle.getIntArray(C0058c.t(1014)));
        }

        /* renamed from: a */
        public d b(Context context, boolean z) {
            super.b(context, z);
            return this;
        }

        /* renamed from: c */
        public d d(int i, int i2, boolean z) {
            super.d(i, i2, z);
            return this;
        }

        /* renamed from: f */
        public d g(Context context) {
            super.g(context);
            return this;
        }

        public final d a(int i, ad adVar, e eVar) {
            Map map = this.UJ.get(i);
            if (map == null) {
                map = new HashMap();
                this.UJ.put(i, map);
            }
            if (map.containsKey(adVar) && com.applovin.exoplayer2.l.ai.r(map.get(adVar), eVar)) {
                return this;
            }
            map.put(adVar, eVar);
            return this;
        }

        /* renamed from: nk */
        public C0058c nm() {
            return new C0058c(this);
        }

        private void B(Bundle bundle) {
            int[] intArray = bundle.getIntArray(C0058c.t(1011));
            List<ad> a = com.applovin.exoplayer2.l.c.a(ad.br, (List<Bundle>) bundle.getParcelableArrayList(C0058c.t(PointerIconCompat.TYPE_NO_DROP)), s.ga());
            SparseArray<e> a2 = com.applovin.exoplayer2.l.c.a(e.br, (SparseArray<Bundle>) bundle.getSparseParcelableArray(C0058c.t(1013)), new SparseArray());
            if (intArray != null && intArray.length == a.size()) {
                for (int i = 0; i < intArray.length; i++) {
                    a(intArray[i], a.get(i), a2.get(i));
                }
            }
        }

        private SparseBooleanArray f(int[] iArr) {
            if (iArr == null) {
                return new SparseBooleanArray();
            }
            SparseBooleanArray sparseBooleanArray = new SparseBooleanArray(iArr.length);
            for (int append : iArr) {
                sparseBooleanArray.append(append, true);
            }
            return sparseBooleanArray;
        }
    }

    /* renamed from: com.applovin.exoplayer2.j.c$c  reason: collision with other inner class name */
    public static final class C0058c extends i implements com.applovin.exoplayer2.g {
        public static final C0058c Uw;
        @Deprecated
        public static final C0058c Ux;
        public static final g.a<C0058c> br = new c$c$$ExternalSyntheticLambda0();
        public final boolean UA;
        public final boolean UB;
        public final boolean UC;
        public final boolean UD;
        public final boolean UE;
        public final boolean UF;
        public final boolean UG;
        public final boolean UH;
        public final boolean UI;
        private final SparseArray<Map<ad, e>> UJ;
        private final SparseBooleanArray UK;
        public final int Uy;
        public final boolean Uz;

        static {
            C0058c nk = new d().nm();
            Uw = nk;
            Ux = nk;
        }

        public static C0058c e(Context context) {
            return new d(context).nm();
        }

        private C0058c(d dVar) {
            super(dVar);
            this.Uz = dVar.Uz;
            this.UA = dVar.UA;
            this.UB = dVar.UB;
            this.UC = dVar.UC;
            this.UD = dVar.UD;
            this.UE = dVar.UE;
            this.UF = dVar.UF;
            this.Uy = dVar.Uy;
            this.UG = dVar.UG;
            this.UH = dVar.UH;
            this.UI = dVar.UI;
            this.UJ = dVar.UJ;
            this.UK = dVar.UK;
        }

        public final boolean eQ(int i) {
            return this.UK.get(i);
        }

        public final boolean a(int i, ad adVar) {
            Map map = this.UJ.get(i);
            return map != null && map.containsKey(adVar);
        }

        public final e b(int i, ad adVar) {
            Map map = this.UJ.get(i);
            if (map != null) {
                return (e) map.get(adVar);
            }
            return null;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            C0058c cVar = (C0058c) obj;
            if (super.equals(cVar) && this.Uz == cVar.Uz && this.UA == cVar.UA && this.UB == cVar.UB && this.UC == cVar.UC && this.UD == cVar.UD && this.UE == cVar.UE && this.UF == cVar.UF && this.Uy == cVar.Uy && this.UG == cVar.UG && this.UH == cVar.UH && this.UI == cVar.UI && a(this.UK, cVar.UK) && a(this.UJ, cVar.UJ)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return ((((((((((((((((((((((super.hashCode() + 31) * 31) + (this.Uz ? 1 : 0)) * 31) + (this.UA ? 1 : 0)) * 31) + (this.UB ? 1 : 0)) * 31) + (this.UC ? 1 : 0)) * 31) + (this.UD ? 1 : 0)) * 31) + (this.UE ? 1 : 0)) * 31) + (this.UF ? 1 : 0)) * 31) + this.Uy) * 31) + (this.UG ? 1 : 0)) * 31) + (this.UH ? 1 : 0)) * 31) + (this.UI ? 1 : 0);
        }

        /* access modifiers changed from: private */
        public static String t(int i) {
            return Integer.toString(i, 36);
        }

        private static boolean a(SparseBooleanArray sparseBooleanArray, SparseBooleanArray sparseBooleanArray2) {
            int size = sparseBooleanArray.size();
            if (sparseBooleanArray2.size() != size) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                if (sparseBooleanArray2.indexOfKey(sparseBooleanArray.keyAt(i)) < 0) {
                    return false;
                }
            }
            return true;
        }

        private static boolean a(SparseArray<Map<ad, e>> sparseArray, SparseArray<Map<ad, e>> sparseArray2) {
            int size = sparseArray.size();
            if (sparseArray2.size() != size) {
                return false;
            }
            for (int i = 0; i < size; i++) {
                int indexOfKey = sparseArray2.indexOfKey(sparseArray.keyAt(i));
                if (indexOfKey < 0 || !a(sparseArray.valueAt(i), sparseArray2.valueAt(indexOfKey))) {
                    return false;
                }
            }
            return true;
        }

        /* JADX WARNING: Removed duplicated region for block: B:6:0x001a  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static boolean a(java.util.Map<com.applovin.exoplayer2.h.ad, com.applovin.exoplayer2.j.c.e> r4, java.util.Map<com.applovin.exoplayer2.h.ad, com.applovin.exoplayer2.j.c.e> r5) {
            /*
                int r0 = r4.size()
                int r1 = r5.size()
                r2 = 0
                if (r1 == r0) goto L_0x000c
                return r2
            L_0x000c:
                java.util.Set r4 = r4.entrySet()
                java.util.Iterator r4 = r4.iterator()
            L_0x0014:
                boolean r0 = r4.hasNext()
                if (r0 == 0) goto L_0x003b
                java.lang.Object r0 = r4.next()
                java.util.Map$Entry r0 = (java.util.Map.Entry) r0
                java.lang.Object r1 = r0.getKey()
                com.applovin.exoplayer2.h.ad r1 = (com.applovin.exoplayer2.h.ad) r1
                boolean r3 = r5.containsKey(r1)
                if (r3 == 0) goto L_0x003a
                java.lang.Object r0 = r0.getValue()
                java.lang.Object r1 = r5.get(r1)
                boolean r0 = com.applovin.exoplayer2.l.ai.r(r0, r1)
                if (r0 != 0) goto L_0x0014
            L_0x003a:
                return r2
            L_0x003b:
                r4 = 1
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.j.c.C0058c.a(java.util.Map, java.util.Map):boolean");
        }
    }

    public static final class e implements com.applovin.exoplayer2.g {
        public static final g.a<e> br = new c$e$$ExternalSyntheticLambda0();
        public final int UL;
        public final int[] Ue;
        public final int bs;
        public final int fR;

        public e(int i, int[] iArr, int i2) {
            this.UL = i;
            int[] copyOf = Arrays.copyOf(iArr, iArr.length);
            this.Ue = copyOf;
            this.fR = iArr.length;
            this.bs = i2;
            Arrays.sort(copyOf);
        }

        public int hashCode() {
            return (((this.UL * 31) + Arrays.hashCode(this.Ue)) * 31) + this.bs;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            e eVar = (e) obj;
            if (this.UL == eVar.UL && Arrays.equals(this.Ue, eVar.Ue) && this.bs == eVar.bs) {
                return true;
            }
            return false;
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ e C(Bundle bundle) {
            boolean z = false;
            int i = bundle.getInt(t(0), -1);
            int[] intArray = bundle.getIntArray(t(1));
            int i2 = bundle.getInt(t(2), -1);
            if (i >= 0 && i2 >= 0) {
                z = true;
            }
            com.applovin.exoplayer2.l.a.checkArgument(z);
            com.applovin.exoplayer2.l.a.checkNotNull(intArray);
            return new e(i, intArray, i2);
        }

        private static String t(int i) {
            return Integer.toString(i, 36);
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ int b(Integer num, Integer num2) {
        if (num.intValue() == -1) {
            if (num2.intValue() == -1) {
                return 0;
            }
            return -1;
        } else if (num2.intValue() == -1) {
            return 1;
        } else {
            return num.intValue() - num2.intValue();
        }
    }

    @Deprecated
    public c() {
        this(C0058c.Uw, (d.b) new a.b());
    }

    public c(Context context) {
        this(context, (d.b) new a.b());
    }

    public c(Context context, d.b bVar) {
        this(C0058c.e(context), bVar);
    }

    public c(C0058c cVar, d.b bVar) {
        this.Uj = bVar;
        this.Uk = new AtomicReference<>(cVar);
    }

    /* access modifiers changed from: protected */
    public final Pair<at[], d[]> a(f.a aVar, int[][][] iArr, int[] iArr2, p.a aVar2, ba baVar) throws com.applovin.exoplayer2.p {
        C0058c cVar = this.Uk.get();
        int np = aVar.np();
        d.a[] a2 = a(aVar, iArr, iArr2, cVar);
        int i = 0;
        while (true) {
            d.a aVar3 = null;
            if (i >= np) {
                break;
            }
            int eS = aVar.eS(i);
            if (cVar.eQ(i) || cVar.VB.contains(Integer.valueOf(eS))) {
                a2[i] = null;
            } else {
                ad eT = aVar.eT(i);
                if (cVar.a(i, eT)) {
                    e b2 = cVar.b(i, eT);
                    if (b2 != null) {
                        aVar3 = new d.a(eT.eb(b2.UL), b2.Ue, b2.bs);
                    }
                    a2[i] = aVar3;
                }
            }
            i++;
        }
        d[] a3 = this.Uj.a(a2, nq(), aVar2, baVar);
        at[] atVarArr = new at[np];
        for (int i2 = 0; i2 < np; i2++) {
            atVarArr[i2] = (cVar.eQ(i2) || cVar.VB.contains(Integer.valueOf(aVar.eS(i2))) || (aVar.eS(i2) != -2 && a3[i2] == null)) ? null : at.hh;
        }
        if (cVar.UH) {
            a(aVar, iArr, atVarArr, a3);
        }
        return Pair.create(atVarArr, a3);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v13, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: com.applovin.exoplayer2.j.c$a} */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.applovin.exoplayer2.j.d.a[] a(com.applovin.exoplayer2.j.f.a r22, int[][][] r23, int[] r24, com.applovin.exoplayer2.j.c.C0058c r25) throws com.applovin.exoplayer2.p {
        /*
            r21 = this;
            r6 = r21
            r7 = r22
            r8 = r25
            int r9 = r22.np()
            com.applovin.exoplayer2.j.d$a[] r10 = new com.applovin.exoplayer2.j.d.a[r9]
            r11 = 0
            r0 = 0
            r12 = 0
            r13 = 0
        L_0x0010:
            r14 = 2
            r15 = 1
            if (r12 >= r9) goto L_0x0042
            int r1 = r7.eS(r12)
            if (r14 != r1) goto L_0x003f
            if (r0 != 0) goto L_0x0034
            com.applovin.exoplayer2.h.ad r1 = r7.eT(r12)
            r2 = r23[r12]
            r3 = r24[r12]
            r5 = 1
            r0 = r21
            r4 = r25
            com.applovin.exoplayer2.j.d$a r0 = r0.a((com.applovin.exoplayer2.h.ad) r1, (int[][]) r2, (int) r3, (com.applovin.exoplayer2.j.c.C0058c) r4, (boolean) r5)
            r10[r12] = r0
            if (r0 == 0) goto L_0x0033
            r0 = 1
            goto L_0x0034
        L_0x0033:
            r0 = 0
        L_0x0034:
            com.applovin.exoplayer2.h.ad r1 = r7.eT(r12)
            int r1 = r1.fR
            if (r1 <= 0) goto L_0x003d
            goto L_0x003e
        L_0x003d:
            r15 = 0
        L_0x003e:
            r13 = r13 | r15
        L_0x003f:
            int r12 = r12 + 1
            goto L_0x0010
        L_0x0042:
            r12 = -1
            r16 = 0
            r3 = r16
            r4 = r3
            r2 = -1
            r5 = 0
        L_0x004a:
            if (r5 >= r9) goto L_0x00b5
            int r0 = r7.eS(r5)
            if (r15 != r0) goto L_0x00a6
            boolean r0 = r8.UI
            if (r0 != 0) goto L_0x005c
            if (r13 != 0) goto L_0x0059
            goto L_0x005c
        L_0x0059:
            r17 = 0
            goto L_0x005e
        L_0x005c:
            r17 = 1
        L_0x005e:
            com.applovin.exoplayer2.h.ad r1 = r7.eT(r5)
            r18 = r23[r5]
            r19 = r24[r5]
            r0 = r21
            r14 = r2
            r2 = r18
            r15 = r3
            r3 = r19
            r20 = r4
            r4 = r25
            r19 = r5
            r5 = r17
            android.util.Pair r0 = r0.b(r1, r2, r3, r4, r5)
            if (r0 == 0) goto L_0x00ac
            if (r15 == 0) goto L_0x0088
            java.lang.Object r1 = r0.second
            com.applovin.exoplayer2.j.c$a r1 = (com.applovin.exoplayer2.j.c.a) r1
            int r1 = r1.compareTo(r15)
            if (r1 <= 0) goto L_0x00ac
        L_0x0088:
            if (r14 == r12) goto L_0x008c
            r10[r14] = r16
        L_0x008c:
            java.lang.Object r1 = r0.first
            com.applovin.exoplayer2.j.d$a r1 = (com.applovin.exoplayer2.j.d.a) r1
            r10[r19] = r1
            com.applovin.exoplayer2.h.ac r2 = r1.Ud
            int[] r1 = r1.Ue
            r1 = r1[r11]
            com.applovin.exoplayer2.v r1 = r2.dZ(r1)
            java.lang.String r4 = r1.dq
            java.lang.Object r0 = r0.second
            r3 = r0
            com.applovin.exoplayer2.j.c$a r3 = (com.applovin.exoplayer2.j.c.a) r3
            r2 = r19
            goto L_0x00b0
        L_0x00a6:
            r14 = r2
            r15 = r3
            r20 = r4
            r19 = r5
        L_0x00ac:
            r2 = r14
            r3 = r15
            r4 = r20
        L_0x00b0:
            int r5 = r19 + 1
            r14 = 2
            r15 = 1
            goto L_0x004a
        L_0x00b5:
            r20 = r4
            r0 = r16
            r1 = -1
        L_0x00ba:
            if (r11 >= r9) goto L_0x010b
            int r2 = r7.eS(r11)
            r3 = 1
            if (r2 == r3) goto L_0x0103
            r4 = 2
            if (r2 == r4) goto L_0x0100
            r5 = 3
            if (r2 == r5) goto L_0x00d6
            com.applovin.exoplayer2.h.ad r5 = r7.eT(r11)
            r13 = r23[r11]
            com.applovin.exoplayer2.j.d$a r2 = r6.a((int) r2, (com.applovin.exoplayer2.h.ad) r5, (int[][]) r13, (com.applovin.exoplayer2.j.c.C0058c) r8)
            r10[r11] = r2
            goto L_0x0100
        L_0x00d6:
            com.applovin.exoplayer2.h.ad r2 = r7.eT(r11)
            r5 = r23[r11]
            r13 = r20
            android.util.Pair r2 = r6.a((com.applovin.exoplayer2.h.ad) r2, (int[][]) r5, (com.applovin.exoplayer2.j.c.C0058c) r8, (java.lang.String) r13)
            if (r2 == 0) goto L_0x0106
            if (r0 == 0) goto L_0x00f0
            java.lang.Object r5 = r2.second
            com.applovin.exoplayer2.j.c$f r5 = (com.applovin.exoplayer2.j.c.f) r5
            int r5 = r5.compareTo(r0)
            if (r5 <= 0) goto L_0x0106
        L_0x00f0:
            if (r1 == r12) goto L_0x00f4
            r10[r1] = r16
        L_0x00f4:
            java.lang.Object r0 = r2.first
            com.applovin.exoplayer2.j.d$a r0 = (com.applovin.exoplayer2.j.d.a) r0
            r10[r11] = r0
            java.lang.Object r0 = r2.second
            com.applovin.exoplayer2.j.c$f r0 = (com.applovin.exoplayer2.j.c.f) r0
            r1 = r11
            goto L_0x0106
        L_0x0100:
            r13 = r20
            goto L_0x0106
        L_0x0103:
            r13 = r20
            r4 = 2
        L_0x0106:
            int r11 = r11 + 1
            r20 = r13
            goto L_0x00ba
        L_0x010b:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.j.c.a(com.applovin.exoplayer2.j.f$a, int[][][], int[], com.applovin.exoplayer2.j.c$c):com.applovin.exoplayer2.j.d$a[]");
    }

    /* access modifiers changed from: protected */
    public d.a a(ad adVar, int[][] iArr, int i, C0058c cVar, boolean z) throws com.applovin.exoplayer2.p {
        d.a a2 = (cVar.VA || cVar.Vz || !z) ? null : a(adVar, iArr, i, cVar);
        return a2 == null ? a(adVar, iArr, cVar) : a2;
    }

    private static d.a a(ad adVar, int[][] iArr, int i, C0058c cVar) {
        ad adVar2 = adVar;
        C0058c cVar2 = cVar;
        int i2 = cVar2.UB ? 24 : 16;
        boolean z = cVar2.UA && (i & i2) != 0;
        int i3 = 0;
        while (i3 < adVar2.fR) {
            ac eb = adVar2.eb(i3);
            int[] iArr2 = iArr[i3];
            int i4 = cVar2.Vf;
            int i5 = cVar2.Vg;
            int i6 = cVar2.Vh;
            int i7 = cVar2.Vi;
            int i8 = cVar2.Vj;
            int i9 = cVar2.Vk;
            int i10 = cVar2.Vl;
            int i11 = cVar2.Vm;
            int i12 = cVar2.Vn;
            int i13 = cVar2.Vo;
            boolean z2 = cVar2.Vp;
            ac acVar = eb;
            int i14 = i3;
            int[] a2 = a(eb, iArr2, z, i2, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13, z2);
            if (a2.length > 0) {
                return new d.a(acVar, a2);
            }
            i3 = i14 + 1;
            adVar2 = adVar;
            cVar2 = cVar;
        }
        return null;
    }

    private static int[] a(ac acVar, int[] iArr, boolean z, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, boolean z2) {
        String str;
        HashSet hashSet;
        int i12;
        int i13;
        ac acVar2 = acVar;
        if (acVar2.fR < 2) {
            return Ug;
        }
        List<Integer> a2 = a(acVar2, i10, i11, z2);
        if (a2.size() < 2) {
            return Ug;
        }
        if (!z) {
            HashSet hashSet2 = new HashSet();
            String str2 = null;
            int i14 = 0;
            int i15 = 0;
            while (i15 < a2.size()) {
                String str3 = acVar2.dZ(a2.get(i15).intValue()).dz;
                if (hashSet2.add(str3)) {
                    String str4 = str3;
                    i13 = i14;
                    i12 = i15;
                    hashSet = hashSet2;
                    int a3 = a(acVar, iArr, i, str3, i2, i3, i4, i5, i6, i7, i8, i9, a2);
                    if (a3 > i13) {
                        i14 = a3;
                        str2 = str4;
                        i15 = i12 + 1;
                        hashSet2 = hashSet;
                    }
                } else {
                    i13 = i14;
                    i12 = i15;
                    hashSet = hashSet2;
                }
                i14 = i13;
                i15 = i12 + 1;
                hashSet2 = hashSet;
            }
            str = str2;
        } else {
            str = null;
        }
        b(acVar, iArr, i, str, i2, i3, i4, i5, i6, i7, i8, i9, a2);
        return a2.size() < 2 ? Ug : com.applovin.exoplayer2.common.b.c.f(a2);
    }

    private static int a(ac acVar, int[] iArr, int i, String str, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, List<Integer> list) {
        int i10 = 0;
        for (int i11 = 0; i11 < list.size(); i11++) {
            int intValue = list.get(i11).intValue();
            if (a(acVar.dZ(intValue), str, iArr[intValue], i, i2, i3, i4, i5, i6, i7, i8, i9)) {
                i10++;
            }
        }
        return i10;
    }

    private static void b(ac acVar, int[] iArr, int i, String str, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, List<Integer> list) {
        List<Integer> list2 = list;
        for (int size = list.size() - 1; size >= 0; size--) {
            int intValue = list2.get(size).intValue();
            if (!a(acVar.dZ(intValue), str, iArr[intValue], i, i2, i3, i4, i5, i6, i7, i8, i9)) {
                list2.remove(size);
            }
        }
    }

    private static boolean a(v vVar, String str, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        if ((vVar.ds & 16384) != 0 || !n(i, false) || (i & i2) == 0) {
            return false;
        }
        if (str != null && !com.applovin.exoplayer2.l.ai.r(vVar.dz, str)) {
            return false;
        }
        if (vVar.dE != -1 && (i7 > vVar.dE || vVar.dE > i3)) {
            return false;
        }
        if (vVar.height != -1 && (i8 > vVar.height || vVar.height > i4)) {
            return false;
        }
        if ((vVar.dF == -1.0f || (((float) i9) <= vVar.dF && vVar.dF <= ((float) i5))) && vVar.dv != -1 && i10 <= vVar.dv && vVar.dv <= i6) {
            return true;
        }
        return false;
    }

    private static d.a a(ad adVar, int[][] iArr, C0058c cVar) {
        ad adVar2 = adVar;
        C0058c cVar2 = cVar;
        int i = -1;
        ac acVar = null;
        g gVar = null;
        for (int i2 = 0; i2 < adVar2.fR; i2++) {
            ac eb = adVar2.eb(i2);
            List<Integer> a2 = a(eb, cVar2.Vn, cVar2.Vo, cVar2.Vp);
            int[] iArr2 = iArr[i2];
            for (int i3 = 0; i3 < eb.fR; i3++) {
                v dZ = eb.dZ(i3);
                if ((dZ.ds & 16384) == 0 && n(iArr2[i3], cVar2.UG)) {
                    g gVar2 = new g(dZ, cVar2, iArr2[i3], a2.contains(Integer.valueOf(i3)));
                    if ((gVar2.UP || cVar2.Uz) && (gVar == null || gVar2.compareTo(gVar) > 0)) {
                        acVar = eb;
                        i = i3;
                        gVar = gVar2;
                    }
                }
            }
        }
        if (acVar == null) {
            return null;
        }
        return new d.a(acVar, i);
    }

    /* access modifiers changed from: protected */
    public Pair<d.a, a> b(ad adVar, int[][] iArr, int i, C0058c cVar, boolean z) throws com.applovin.exoplayer2.p {
        ad adVar2 = adVar;
        C0058c cVar2 = cVar;
        d.a aVar = null;
        a aVar2 = null;
        int i2 = -1;
        int i3 = -1;
        for (int i4 = 0; i4 < adVar2.fR; i4++) {
            ac eb = adVar2.eb(i4);
            int[] iArr2 = iArr[i4];
            for (int i5 = 0; i5 < eb.fR; i5++) {
                if (n(iArr2[i5], cVar2.UG)) {
                    a aVar3 = new a(eb.dZ(i5), cVar2, iArr2[i5]);
                    if ((aVar3.Ul || cVar2.UC) && (aVar2 == null || aVar3.compareTo(aVar2) > 0)) {
                        i2 = i4;
                        i3 = i5;
                        aVar2 = aVar3;
                    }
                }
            }
        }
        if (i2 == -1) {
            return null;
        }
        ac eb2 = adVar2.eb(i2);
        if (!cVar2.VA && !cVar2.Vz && z) {
            int[] a2 = a(eb2, iArr[i2], i3, cVar2.Vu, cVar2.UD, cVar2.UE, cVar2.UF);
            if (a2.length > 1) {
                aVar = new d.a(eb2, a2);
            }
        }
        if (aVar == null) {
            aVar = new d.a(eb2, i3);
        }
        return Pair.create(aVar, (a) com.applovin.exoplayer2.l.a.checkNotNull(aVar2));
    }

    private static int[] a(ac acVar, int[] iArr, int i, int i2, boolean z, boolean z2, boolean z3) {
        ac acVar2 = acVar;
        int i3 = i;
        v dZ = acVar.dZ(i);
        int[] iArr2 = new int[acVar2.fR];
        int i4 = 0;
        for (int i5 = 0; i5 < acVar2.fR; i5++) {
            if (i5 == i3 || a(acVar.dZ(i5), iArr[i5], dZ, i2, z, z2, z3)) {
                iArr2[i4] = i5;
                i4++;
            }
        }
        return Arrays.copyOf(iArr2, i4);
    }

    private static boolean a(v vVar, int i, v vVar2, int i2, boolean z, boolean z2, boolean z3) {
        if (!n(i, false) || vVar.dv == -1 || vVar.dv > i2) {
            return false;
        }
        if (!z3 && (vVar.dL == -1 || vVar.dL != vVar2.dL)) {
            return false;
        }
        if (!z && (vVar.dz == null || !TextUtils.equals(vVar.dz, vVar2.dz))) {
            return false;
        }
        if (z2 || (vVar.dM != -1 && vVar.dM == vVar2.dM)) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public Pair<d.a, f> a(ad adVar, int[][] iArr, C0058c cVar, String str) throws com.applovin.exoplayer2.p {
        ad adVar2 = adVar;
        C0058c cVar2 = cVar;
        int i = -1;
        ac acVar = null;
        f fVar = null;
        for (int i2 = 0; i2 < adVar2.fR; i2++) {
            ac eb = adVar2.eb(i2);
            int[] iArr2 = iArr[i2];
            for (int i3 = 0; i3 < eb.fR; i3++) {
                if (n(iArr2[i3], cVar2.UG)) {
                    f fVar2 = new f(eb.dZ(i3), cVar2, iArr2[i3], str);
                    if (fVar2.Ul && (fVar == null || fVar2.compareTo(fVar) > 0)) {
                        acVar = eb;
                        i = i3;
                        fVar = fVar2;
                    }
                } else {
                    String str2 = str;
                }
            }
            String str3 = str;
        }
        if (acVar == null) {
            return null;
        }
        return Pair.create(new d.a(acVar, i), (f) com.applovin.exoplayer2.l.a.checkNotNull(fVar));
    }

    /* access modifiers changed from: protected */
    public d.a a(int i, ad adVar, int[][] iArr, C0058c cVar) throws com.applovin.exoplayer2.p {
        ac acVar = null;
        b bVar = null;
        int i2 = 0;
        for (int i3 = 0; i3 < adVar.fR; i3++) {
            ac eb = adVar.eb(i3);
            int[] iArr2 = iArr[i3];
            for (int i4 = 0; i4 < eb.fR; i4++) {
                if (n(iArr2[i4], cVar.UG)) {
                    b bVar2 = new b(eb.dZ(i4), iArr2[i4]);
                    if (bVar == null || bVar2.compareTo(bVar) > 0) {
                        acVar = eb;
                        i2 = i4;
                        bVar = bVar2;
                    }
                }
            }
        }
        if (acVar == null) {
            return null;
        }
        return new d.a(acVar, i2);
    }

    private static void a(f.a aVar, int[][][] iArr, at[] atVarArr, d[] dVarArr) {
        boolean z;
        boolean z2 = false;
        int i = 0;
        int i2 = -1;
        int i3 = -1;
        while (true) {
            if (i >= aVar.np()) {
                z = true;
                break;
            }
            int eS = aVar.eS(i);
            d dVar = dVarArr[i];
            if ((eS == 1 || eS == 2) && dVar != null && a(iArr[i], aVar.eT(i), dVar)) {
                if (eS == 1) {
                    if (i3 != -1) {
                        break;
                    }
                    i3 = i;
                } else if (i2 != -1) {
                    break;
                } else {
                    i2 = i;
                }
            }
            i++;
        }
        z = false;
        if (!(i3 == -1 || i2 == -1)) {
            z2 = true;
        }
        if (z && z2) {
            at atVar = new at(true);
            atVarArr[i3] = atVar;
            atVarArr[i2] = atVar;
        }
    }

    private static boolean a(int[][] iArr, ad adVar, d dVar) {
        if (dVar == null) {
            return false;
        }
        int a2 = adVar.a(dVar.nf());
        for (int i = 0; i < dVar.kD(); i++) {
            if (as.CC.ag(iArr[a2][dVar.eP(i)]) != 32) {
                return false;
            }
        }
        return true;
    }

    protected static boolean n(int i, boolean z) {
        int af = as.CC.af(i);
        return af == 4 || (z && af == 3);
    }

    protected static String aI(String str) {
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, "und")) {
            return null;
        }
        return str;
    }

    protected static int a(v vVar, String str, boolean z) {
        if (!TextUtils.isEmpty(str) && str.equals(vVar.dq)) {
            return 4;
        }
        String aI = aI(str);
        String aI2 = aI(vVar.dq);
        if (aI2 == null || aI == null) {
            if (!z || aI2 != null) {
                return 0;
            }
            return 1;
        } else if (aI2.startsWith(aI) || aI.startsWith(aI2)) {
            return 3;
        } else {
            if (com.applovin.exoplayer2.l.ai.m(aI2, "-")[0].equals(com.applovin.exoplayer2.l.ai.m(aI, "-")[0])) {
                return 2;
            }
            return 0;
        }
    }

    private static List<Integer> a(ac acVar, int i, int i2, boolean z) {
        ArrayList arrayList = new ArrayList(acVar.fR);
        for (int i3 = 0; i3 < acVar.fR; i3++) {
            arrayList.add(Integer.valueOf(i3));
        }
        if (!(i == Integer.MAX_VALUE || i2 == Integer.MAX_VALUE)) {
            int i4 = Integer.MAX_VALUE;
            for (int i5 = 0; i5 < acVar.fR; i5++) {
                v dZ = acVar.dZ(i5);
                if (dZ.dE > 0 && dZ.height > 0) {
                    Point a2 = a(z, i, i2, dZ.dE, dZ.height);
                    int i6 = dZ.dE * dZ.height;
                    if (dZ.dE >= ((int) (((float) a2.x) * 0.98f)) && dZ.height >= ((int) (((float) a2.y) * 0.98f)) && i6 < i4) {
                        i4 = i6;
                    }
                }
            }
            if (i4 != Integer.MAX_VALUE) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    int bS = acVar.dZ(((Integer) arrayList.get(size)).intValue()).bS();
                    if (bS == -1 || bS > i4) {
                        arrayList.remove(size);
                    }
                }
            }
        }
        return arrayList;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x000d, code lost:
        if (r1 != r3) goto L_0x0013;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.graphics.Point a(boolean r3, int r4, int r5, int r6, int r7) {
        /*
            if (r3 == 0) goto L_0x0010
            r3 = 1
            r0 = 0
            if (r6 <= r7) goto L_0x0008
            r1 = 1
            goto L_0x0009
        L_0x0008:
            r1 = 0
        L_0x0009:
            if (r4 <= r5) goto L_0x000c
            goto L_0x000d
        L_0x000c:
            r3 = 0
        L_0x000d:
            if (r1 == r3) goto L_0x0010
            goto L_0x0013
        L_0x0010:
            r2 = r5
            r5 = r4
            r4 = r2
        L_0x0013:
            int r3 = r6 * r4
            int r0 = r7 * r5
            if (r3 < r0) goto L_0x0023
            android.graphics.Point r3 = new android.graphics.Point
            int r4 = com.applovin.exoplayer2.l.ai.N(r0, r6)
            r3.<init>(r5, r4)
            return r3
        L_0x0023:
            android.graphics.Point r5 = new android.graphics.Point
            int r3 = com.applovin.exoplayer2.l.ai.N(r3, r7)
            r5.<init>(r3, r4)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.j.c.a(boolean, int, int, int, int):android.graphics.Point");
    }

    protected static final class g implements Comparable<g> {
        public final boolean UP;
        private final boolean UQ;
        private final int UR;
        private final C0058c Um;
        private final boolean Un;
        private final int Uu;
        private final int dv;

        public g(v vVar, C0058c cVar, int i, boolean z) {
            this.Um = cVar;
            boolean z2 = true;
            int i2 = 0;
            this.UP = z && (vVar.dE == -1 || vVar.dE <= cVar.Vf) && ((vVar.height == -1 || vVar.height <= cVar.Vg) && ((vVar.dF == -1.0f || vVar.dF <= ((float) cVar.Vh)) && (vVar.dv == -1 || vVar.dv <= cVar.Vi)));
            if (!z || ((vVar.dE != -1 && vVar.dE < cVar.Vj) || ((vVar.height != -1 && vVar.height < cVar.Vk) || ((vVar.dF != -1.0f && vVar.dF < ((float) cVar.Vl)) || (vVar.dv != -1 && vVar.dv < cVar.Vm))))) {
                z2 = false;
            }
            this.UQ = z2;
            this.Un = c.n(i, false);
            this.dv = vVar.dv;
            this.UR = vVar.bS();
            while (true) {
                if (i2 < cVar.Vq.size()) {
                    if (vVar.dz != null && vVar.dz.equals(cVar.Vq.get(i2))) {
                        break;
                    }
                    i2++;
                } else {
                    i2 = Integer.MAX_VALUE;
                    break;
                }
            }
            this.Uu = i2;
        }

        /* renamed from: a */
        public int compareTo(g gVar) {
            ai aiVar;
            if (!this.UP || !this.Un) {
                aiVar = c.Uh.gO();
            } else {
                aiVar = c.Uh;
            }
            return n.fP().d(this.Un, gVar.Un).d(this.UP, gVar.UP).d(this.UQ, gVar.UQ).a(Integer.valueOf(this.Uu), Integer.valueOf(gVar.Uu), ai.gP().gO()).a(Integer.valueOf(this.dv), Integer.valueOf(gVar.dv), this.Um.Vz ? c.Uh.gO() : c.Ui).a(Integer.valueOf(this.UR), Integer.valueOf(gVar.UR), aiVar).a(Integer.valueOf(this.dv), Integer.valueOf(gVar.dv), aiVar).fQ();
        }
    }

    protected static final class a implements Comparable<a> {
        public final boolean Ul;
        private final C0058c Um;
        private final boolean Un;
        private final int Uo;
        private final int Up;
        private final int Uq;
        private final int Ur;
        private final int Us;
        private final boolean Ut;
        private final int Uu;
        private final int dL;
        private final int dM;
        private final String dq;
        private final int dv;

        public a(v vVar, C0058c cVar, int i) {
            int i2;
            int i3;
            int i4;
            this.Um = cVar;
            this.dq = c.aI(vVar.dq);
            int i5 = 0;
            this.Un = c.n(i, false);
            int i6 = 0;
            while (true) {
                i2 = Integer.MAX_VALUE;
                if (i6 >= cVar.Vr.size()) {
                    i6 = Integer.MAX_VALUE;
                    i3 = 0;
                    break;
                }
                i3 = c.a(vVar, (String) cVar.Vr.get(i6), false);
                if (i3 > 0) {
                    break;
                }
                i6++;
            }
            this.Up = i6;
            this.Uo = i3;
            this.Uq = Integer.bitCount(vVar.ds & cVar.Vs);
            boolean z = true;
            this.Ut = (vVar.dr & 1) != 0;
            this.dL = vVar.dL;
            this.dM = vVar.dM;
            this.dv = vVar.dv;
            if ((vVar.dv != -1 && vVar.dv > cVar.Vu) || (vVar.dL != -1 && vVar.dL > cVar.Vt)) {
                z = false;
            }
            this.Ul = z;
            String[] qa = com.applovin.exoplayer2.l.ai.qa();
            int i7 = 0;
            while (true) {
                if (i7 >= qa.length) {
                    i7 = Integer.MAX_VALUE;
                    i4 = 0;
                    break;
                }
                i4 = c.a(vVar, qa[i7], false);
                if (i4 > 0) {
                    break;
                }
                i7++;
            }
            this.Ur = i7;
            this.Us = i4;
            while (true) {
                if (i5 < cVar.Vv.size()) {
                    if (vVar.dz != null && vVar.dz.equals(cVar.Vv.get(i5))) {
                        i2 = i5;
                        break;
                    }
                    i5++;
                } else {
                    break;
                }
            }
            this.Uu = i2;
        }

        /* renamed from: a */
        public int compareTo(a aVar) {
            ai aiVar;
            if (!this.Ul || !this.Un) {
                aiVar = c.Uh.gO();
            } else {
                aiVar = c.Uh;
            }
            n a = n.fP().d(this.Un, aVar.Un).a(Integer.valueOf(this.Up), Integer.valueOf(aVar.Up), ai.gP().gO()).r(this.Uo, aVar.Uo).r(this.Uq, aVar.Uq).d(this.Ul, aVar.Ul).a(Integer.valueOf(this.Uu), Integer.valueOf(aVar.Uu), ai.gP().gO()).a(Integer.valueOf(this.dv), Integer.valueOf(aVar.dv), this.Um.Vz ? c.Uh.gO() : c.Ui).d(this.Ut, aVar.Ut).a(Integer.valueOf(this.Ur), Integer.valueOf(aVar.Ur), ai.gP().gO()).r(this.Us, aVar.Us).a(Integer.valueOf(this.dL), Integer.valueOf(aVar.dL), aiVar).a(Integer.valueOf(this.dM), Integer.valueOf(aVar.dM), aiVar);
            Integer valueOf = Integer.valueOf(this.dv);
            Integer valueOf2 = Integer.valueOf(aVar.dv);
            if (!com.applovin.exoplayer2.l.ai.r(this.dq, aVar.dq)) {
                aiVar = c.Ui;
            }
            return a.a(valueOf, valueOf2, aiVar).fQ();
        }
    }

    protected static final class f implements Comparable<f> {
        private final boolean UM;
        private final int UN;
        private final boolean UO;
        public final boolean Ul;
        private final boolean Un;
        private final int Uo;
        private final int Up;
        private final int Uq;
        private final boolean Uv;

        public f(v vVar, C0058c cVar, int i, String str) {
            s sVar;
            int i2;
            boolean z = false;
            this.Un = c.n(i, false);
            int i3 = vVar.dr & (~cVar.Uy);
            this.Uv = (i3 & 1) != 0;
            this.UM = (i3 & 2) != 0;
            if (cVar.Vw.isEmpty()) {
                sVar = s.u("");
            } else {
                sVar = cVar.Vw;
            }
            int i4 = 0;
            while (true) {
                if (i4 >= sVar.size()) {
                    i4 = Integer.MAX_VALUE;
                    i2 = 0;
                    break;
                }
                i2 = c.a(vVar, (String) sVar.get(i4), cVar.Vy);
                if (i2 > 0) {
                    break;
                }
                i4++;
            }
            this.Up = i4;
            this.Uo = i2;
            int bitCount = Integer.bitCount(vVar.ds & cVar.Vx);
            this.Uq = bitCount;
            this.UO = (vVar.ds & 1088) != 0;
            int a = c.a(vVar, str, c.aI(str) == null);
            this.UN = a;
            if (i2 > 0 || ((cVar.Vw.isEmpty() && bitCount > 0) || this.Uv || (this.UM && a > 0))) {
                z = true;
            }
            this.Ul = z;
        }

        /* renamed from: a */
        public int compareTo(f fVar) {
            ai aiVar;
            n d = n.fP().d(this.Un, fVar.Un).a(Integer.valueOf(this.Up), Integer.valueOf(fVar.Up), ai.gP().gO()).r(this.Uo, fVar.Uo).r(this.Uq, fVar.Uq).d(this.Uv, fVar.Uv);
            Boolean valueOf = Boolean.valueOf(this.UM);
            Boolean valueOf2 = Boolean.valueOf(fVar.UM);
            if (this.Uo == 0) {
                aiVar = ai.gP();
            } else {
                aiVar = ai.gP().gO();
            }
            n r = d.a(valueOf, valueOf2, aiVar).r(this.UN, fVar.UN);
            if (this.Uq == 0) {
                r = r.c(this.UO, fVar.UO);
            }
            return r.fQ();
        }
    }

    protected static final class b implements Comparable<b> {
        private final boolean Un;
        private final boolean Uv;

        public b(v vVar, int i) {
            this.Uv = (vVar.dr & 1) == 0 ? false : true;
            this.Un = c.n(i, false);
        }

        /* renamed from: a */
        public int compareTo(b bVar) {
            return n.fP().d(this.Un, bVar.Un).d(this.Uv, bVar.Uv).fQ();
        }
    }
}
