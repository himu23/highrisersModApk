package com.applovin.exoplayer2.h.a;

import android.net.Uri;
import android.os.Bundle;
import com.applovin.exoplayer2.g;
import com.applovin.exoplayer2.l.ai;
import java.util.ArrayList;
import java.util.Arrays;

public final class a implements g {
    public static final a NI = new a((Object) null, new C0048a[0], 0, -9223372036854775807L, 0);
    private static final C0048a NJ = new C0048a(0).ee(0);
    public static final g.a<a> br = new a$$ExternalSyntheticLambda0();
    public final int NK;
    public final long NM;
    public final long NN;
    public final int NO;
    private final C0048a[] NP;
    public final Object ee;

    /* renamed from: com.applovin.exoplayer2.h.a.a$a  reason: collision with other inner class name */
    public static final class C0048a implements g {
        public static final g.a<C0048a> br = new a$a$$ExternalSyntheticLambda0();
        public final int NQ;
        public final Uri[] NR;
        public final int[] NS;
        public final long NT;
        public final boolean NU;
        public final long rJ;
        public final long[] tT;

        public C0048a(long j) {
            this(j, -1, new int[0], new Uri[0], new long[0], 0, false);
        }

        private C0048a(long j, int i, int[] iArr, Uri[] uriArr, long[] jArr, long j2, boolean z) {
            com.applovin.exoplayer2.l.a.checkArgument(iArr.length == uriArr.length);
            this.rJ = j;
            this.NQ = i;
            this.NS = iArr;
            this.NR = uriArr;
            this.tT = jArr;
            this.NT = j2;
            this.NU = z;
        }

        public int lM() {
            return ed(-1);
        }

        public int ed(int i) {
            int i2;
            int i3 = i + 1;
            while (true) {
                int[] iArr = this.NS;
                if (i3 >= iArr.length || this.NU || (i2 = iArr[i3]) == 0 || i2 == 1) {
                    return i3;
                }
                i3++;
            }
            return i3;
        }

        public boolean lN() {
            return this.NQ == -1 || lM() < this.NQ;
        }

        public boolean lO() {
            if (this.NQ == -1) {
                return true;
            }
            for (int i = 0; i < this.NQ; i++) {
                int i2 = this.NS[i];
                if (i2 == 0 || i2 == 1) {
                    return true;
                }
            }
            return false;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            C0048a aVar = (C0048a) obj;
            if (this.rJ == aVar.rJ && this.NQ == aVar.NQ && Arrays.equals(this.NR, aVar.NR) && Arrays.equals(this.NS, aVar.NS) && Arrays.equals(this.tT, aVar.tT) && this.NT == aVar.NT && this.NU == aVar.NU) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            long j = this.rJ;
            long j2 = this.NT;
            return (((((((((((this.NQ * 31) + ((int) (j ^ (j >>> 32)))) * 31) + Arrays.hashCode(this.NR)) * 31) + Arrays.hashCode(this.NS)) * 31) + Arrays.hashCode(this.tT)) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + (this.NU ? 1 : 0);
        }

        public C0048a ee(int i) {
            int[] b = b(this.NS, i);
            long[] a = a(this.tT, i);
            return new C0048a(this.rJ, i, b, (Uri[]) Arrays.copyOf(this.NR, i), a, this.NT, this.NU);
        }

        private static int[] b(int[] iArr, int i) {
            int length = iArr.length;
            int max = Math.max(i, length);
            int[] copyOf = Arrays.copyOf(iArr, max);
            Arrays.fill(copyOf, length, max, 0);
            return copyOf;
        }

        private static long[] a(long[] jArr, int i) {
            int length = jArr.length;
            int max = Math.max(i, length);
            long[] copyOf = Arrays.copyOf(jArr, max);
            Arrays.fill(copyOf, length, max, -9223372036854775807L);
            return copyOf;
        }

        /* access modifiers changed from: private */
        public static C0048a y(Bundle bundle) {
            Uri[] uriArr;
            long j = bundle.getLong(t(0));
            int i = bundle.getInt(t(1), -1);
            ArrayList parcelableArrayList = bundle.getParcelableArrayList(t(2));
            int[] intArray = bundle.getIntArray(t(3));
            long[] longArray = bundle.getLongArray(t(4));
            long j2 = bundle.getLong(t(5));
            boolean z = bundle.getBoolean(t(6));
            if (intArray == null) {
                intArray = new int[0];
            }
            int[] iArr = intArray;
            if (parcelableArrayList == null) {
                uriArr = new Uri[0];
            } else {
                uriArr = (Uri[]) parcelableArrayList.toArray(new Uri[0]);
            }
            return new C0048a(j, i, iArr, uriArr, longArray == null ? new long[0] : longArray, j2, z);
        }

        private static String t(int i) {
            return Integer.toString(i, 36);
        }
    }

    private a(Object obj, C0048a[] aVarArr, long j, long j2, int i) {
        this.ee = obj;
        this.NM = j;
        this.NN = j2;
        this.NK = aVarArr.length + i;
        this.NP = aVarArr;
        this.NO = i;
    }

    public C0048a ec(int i) {
        int i2 = this.NO;
        return i < i2 ? NJ : this.NP[i - i2];
    }

    public int x(long j, long j2) {
        int i = this.NK - 1;
        while (i >= 0 && b(j, j2, i)) {
            i--;
        }
        if (i < 0 || !ec(i).lO()) {
            return -1;
        }
        return i;
    }

    public int y(long j, long j2) {
        if (j == Long.MIN_VALUE) {
            return -1;
        }
        if (j2 != -9223372036854775807L && j >= j2) {
            return -1;
        }
        int i = this.NO;
        while (i < this.NK && ((ec(i).rJ != Long.MIN_VALUE && ec(i).rJ <= j) || !ec(i).lN())) {
            i++;
        }
        if (i < this.NK) {
            return i;
        }
        return -1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        if (ai.r(this.ee, aVar.ee) && this.NK == aVar.NK && this.NM == aVar.NM && this.NN == aVar.NN && this.NO == aVar.NO && Arrays.equals(this.NP, aVar.NP)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i = this.NK * 31;
        Object obj = this.ee;
        return ((((((((i + (obj == null ? 0 : obj.hashCode())) * 31) + ((int) this.NM)) * 31) + ((int) this.NN)) * 31) + this.NO) * 31) + Arrays.hashCode(this.NP);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("AdPlaybackState(adsId=");
        sb.append(this.ee);
        sb.append(", adResumePositionUs=");
        sb.append(this.NM);
        sb.append(", adGroups=[");
        for (int i = 0; i < this.NP.length; i++) {
            sb.append("adGroup(timeUs=");
            sb.append(this.NP[i].rJ);
            sb.append(", ads=[");
            for (int i2 = 0; i2 < this.NP[i].NS.length; i2++) {
                sb.append("ad(state=");
                int i3 = this.NP[i].NS[i2];
                if (i3 == 0) {
                    sb.append('_');
                } else if (i3 == 1) {
                    sb.append('R');
                } else if (i3 == 2) {
                    sb.append('S');
                } else if (i3 == 3) {
                    sb.append('P');
                } else if (i3 != 4) {
                    sb.append('?');
                } else {
                    sb.append('!');
                }
                sb.append(", durationUs=");
                sb.append(this.NP[i].tT[i2]);
                sb.append(')');
                if (i2 < this.NP[i].NS.length - 1) {
                    sb.append(", ");
                }
            }
            sb.append("])");
            if (i < this.NP.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("])");
        return sb.toString();
    }

    private boolean b(long j, long j2, int i) {
        if (j == Long.MIN_VALUE) {
            return false;
        }
        long j3 = ec(i).rJ;
        return j3 == Long.MIN_VALUE ? j2 == -9223372036854775807L || j < j2 : j < j3;
    }

    /* access modifiers changed from: private */
    public static a x(Bundle bundle) {
        C0048a[] aVarArr;
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(t(1));
        if (parcelableArrayList == null) {
            aVarArr = new C0048a[0];
        } else {
            C0048a[] aVarArr2 = new C0048a[parcelableArrayList.size()];
            for (int i = 0; i < parcelableArrayList.size(); i++) {
                aVarArr2[i] = C0048a.br.fromBundle((Bundle) parcelableArrayList.get(i));
            }
            aVarArr = aVarArr2;
        }
        return new a((Object) null, aVarArr, bundle.getLong(t(2), 0), bundle.getLong(t(3), -9223372036854775807L), bundle.getInt(t(4)));
    }

    private static String t(int i) {
        return Integer.toString(i, 36);
    }
}
