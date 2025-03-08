package com.applovin.exoplayer2.common.a;

import com.applovin.exoplayer2.common.base.Objects;
import com.applovin.exoplayer2.common.base.Preconditions;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

class l<K, V> extends AbstractMap<K, V> implements Serializable {
    /* access modifiers changed from: private */
    public transient int oW;
    @MonotonicNonNullDecl
    private transient int[] pG;
    @MonotonicNonNullDecl
    transient long[] pH;
    @MonotonicNonNullDecl
    transient Object[] pI;
    @MonotonicNonNullDecl
    transient Object[] pJ;
    transient float pK;
    transient int pL;
    private transient int pM;
    @MonotonicNonNullDecl
    private transient Set<K> pN;
    @MonotonicNonNullDecl
    private transient Set<Map.Entry<K, V>> pO;
    @MonotonicNonNullDecl
    private transient Collection<V> pP;

    private static int ab(long j) {
        return (int) (j >>> 32);
    }

    private static int ac(long j) {
        return (int) j;
    }

    private static long b(long j, int i) {
        return (j & -4294967296L) | (4294967295L & ((long) i));
    }

    /* access modifiers changed from: package-private */
    public void aW(int i) {
    }

    /* access modifiers changed from: package-private */
    public int bc(int i) {
        int i2 = i + 1;
        if (i2 < this.oW) {
            return i2;
        }
        return -1;
    }

    public boolean isEmpty() {
        return this.oW == 0;
    }

    /* access modifiers changed from: package-private */
    public int q(int i, int i2) {
        return i - 1;
    }

    public int size() {
        return this.oW;
    }

    public static <K, V> l<K, V> fH() {
        return new l<>();
    }

    public static <K, V> l<K, V> aT(int i) {
        return new l<>(i);
    }

    l() {
        a(3, 1.0f);
    }

    l(int i) {
        this(i, 1.0f);
    }

    l(int i, float f) {
        a(i, f);
    }

    /* access modifiers changed from: package-private */
    public void a(int i, float f) {
        boolean z = false;
        Preconditions.checkArgument(i >= 0, "Initial capacity must be non-negative");
        if (f > 0.0f) {
            z = true;
        }
        Preconditions.checkArgument(z, "Illegal load factor");
        int a2 = p.a(i, (double) f);
        this.pG = aU(a2);
        this.pK = f;
        this.pI = new Object[i];
        this.pJ = new Object[i];
        this.pH = aV(i);
        this.pM = Math.max(1, (int) (((float) a2) * f));
    }

    private static int[] aU(int i) {
        int[] iArr = new int[i];
        Arrays.fill(iArr, -1);
        return iArr;
    }

    private static long[] aV(int i) {
        long[] jArr = new long[i];
        Arrays.fill(jArr, -1);
        return jArr;
    }

    private int fI() {
        return this.pG.length - 1;
    }

    @NullableDecl
    public V put(@NullableDecl K k, @NullableDecl V v) {
        long[] jArr = this.pH;
        Object[] objArr = this.pI;
        V[] vArr = this.pJ;
        int s = p.s(k);
        int fI = fI() & s;
        int i = this.oW;
        int[] iArr = this.pG;
        int i2 = iArr[fI];
        if (i2 == -1) {
            iArr[fI] = i;
        } else {
            while (true) {
                long j = jArr[i2];
                if (ab(j) != s || !Objects.equal(k, objArr[i2])) {
                    int ac = ac(j);
                    if (ac == -1) {
                        jArr[i2] = b(j, i);
                        break;
                    }
                    i2 = ac;
                } else {
                    V v2 = vArr[i2];
                    vArr[i2] = v;
                    aW(i2);
                    return v2;
                }
            }
        }
        if (i != Integer.MAX_VALUE) {
            int i3 = i + 1;
            aX(i3);
            a(i, k, v, s);
            this.oW = i3;
            if (i >= this.pM) {
                aZ(this.pG.length * 2);
            }
            this.pL++;
            return null;
        }
        throw new IllegalStateException("Cannot contain more than Integer.MAX_VALUE elements!");
    }

    /* access modifiers changed from: package-private */
    public void a(int i, @NullableDecl K k, @NullableDecl V v, int i2) {
        this.pH[i] = (((long) i2) << 32) | 4294967295L;
        this.pI[i] = k;
        this.pJ[i] = v;
    }

    private void aX(int i) {
        int length = this.pH.length;
        if (i > length) {
            int max = Math.max(1, length >>> 1) + length;
            if (max < 0) {
                max = Integer.MAX_VALUE;
            }
            if (max != length) {
                aY(max);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void aY(int i) {
        this.pI = Arrays.copyOf(this.pI, i);
        this.pJ = Arrays.copyOf(this.pJ, i);
        long[] jArr = this.pH;
        int length = jArr.length;
        long[] copyOf = Arrays.copyOf(jArr, i);
        if (i > length) {
            Arrays.fill(copyOf, length, i, -1);
        }
        this.pH = copyOf;
    }

    private void aZ(int i) {
        if (this.pG.length >= 1073741824) {
            this.pM = Integer.MAX_VALUE;
            return;
        }
        int i2 = ((int) (((float) i) * this.pK)) + 1;
        int[] aU = aU(i);
        long[] jArr = this.pH;
        int length = aU.length - 1;
        for (int i3 = 0; i3 < this.oW; i3++) {
            int ab = ab(jArr[i3]);
            int i4 = ab & length;
            int i5 = aU[i4];
            aU[i4] = i3;
            jArr[i3] = (((long) ab) << 32) | (((long) i5) & 4294967295L);
        }
        this.pM = i2;
        this.pG = aU;
    }

    /* access modifiers changed from: private */
    public int indexOf(@NullableDecl Object obj) {
        int s = p.s(obj);
        int i = this.pG[fI() & s];
        while (i != -1) {
            long j = this.pH[i];
            if (ab(j) == s && Objects.equal(obj, this.pI[i])) {
                return i;
            }
            i = ac(j);
        }
        return -1;
    }

    public boolean containsKey(@NullableDecl Object obj) {
        return indexOf(obj) != -1;
    }

    public V get(@NullableDecl Object obj) {
        int indexOf = indexOf(obj);
        aW(indexOf);
        if (indexOf == -1) {
            return null;
        }
        return this.pJ[indexOf];
    }

    @NullableDecl
    public V remove(@NullableDecl Object obj) {
        return a(obj, p.s(obj));
    }

    @NullableDecl
    private V a(@NullableDecl Object obj, int i) {
        int fI = fI() & i;
        int i2 = this.pG[fI];
        if (i2 == -1) {
            return null;
        }
        int i3 = -1;
        while (true) {
            if (ab(this.pH[i2]) != i || !Objects.equal(obj, this.pI[i2])) {
                int ac = ac(this.pH[i2]);
                if (ac == -1) {
                    return null;
                }
                int i4 = ac;
                i3 = i2;
                i2 = i4;
            } else {
                V v = this.pJ[i2];
                if (i3 == -1) {
                    this.pG[fI] = ac(this.pH[i2]);
                } else {
                    long[] jArr = this.pH;
                    jArr[i3] = b(jArr[i3], ac(jArr[i2]));
                }
                bb(i2);
                this.oW--;
                this.pL++;
                return v;
            }
        }
    }

    /* access modifiers changed from: private */
    public V ba(int i) {
        return a(this.pI[i], ab(this.pH[i]));
    }

    /* access modifiers changed from: package-private */
    public void bb(int i) {
        int size = size() - 1;
        if (i < size) {
            Object[] objArr = this.pI;
            objArr[i] = objArr[size];
            Object[] objArr2 = this.pJ;
            objArr2[i] = objArr2[size];
            objArr[size] = null;
            objArr2[size] = null;
            long[] jArr = this.pH;
            long j = jArr[size];
            jArr[i] = j;
            jArr[size] = -1;
            int ab = ab(j) & fI();
            int[] iArr = this.pG;
            int i2 = iArr[ab];
            if (i2 == size) {
                iArr[ab] = i;
                return;
            }
            while (true) {
                long j2 = this.pH[i2];
                int ac = ac(j2);
                if (ac == size) {
                    this.pH[i2] = b(j2, i);
                    return;
                }
                i2 = ac;
            }
        } else {
            this.pI[i] = null;
            this.pJ[i] = null;
            this.pH[i] = -1;
        }
    }

    /* access modifiers changed from: package-private */
    public int fJ() {
        return isEmpty() ? -1 : 0;
    }

    private abstract class b<T> implements Iterator<T> {
        int pR;
        int pS;
        int pT;

        /* access modifiers changed from: package-private */
        public abstract T bd(int i);

        public boolean hasNext() {
            return this.pS >= 0;
        }

        private b() {
            this.pR = l.this.pL;
            this.pS = l.this.fJ();
            this.pT = -1;
        }

        public T next() {
            fN();
            if (hasNext()) {
                int i = this.pS;
                this.pT = i;
                T bd = bd(i);
                this.pS = l.this.bc(this.pS);
                return bd;
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            fN();
            j.I(this.pT >= 0);
            this.pR++;
            Object unused = l.this.ba(this.pT);
            this.pS = l.this.q(this.pS, this.pT);
            this.pT = -1;
        }

        private void fN() {
            if (l.this.pL != this.pR) {
                throw new ConcurrentModificationException();
            }
        }
    }

    public Set<K> keySet() {
        Set<K> set = this.pN;
        if (set != null) {
            return set;
        }
        Set<K> fe = fe();
        this.pN = fe;
        return fe;
    }

    /* access modifiers changed from: package-private */
    public Set<K> fe() {
        return new c();
    }

    class c extends AbstractSet<K> {
        c() {
        }

        public int size() {
            return l.this.oW;
        }

        public boolean contains(Object obj) {
            return l.this.containsKey(obj);
        }

        public boolean remove(@NullableDecl Object obj) {
            int a = l.this.indexOf(obj);
            if (a == -1) {
                return false;
            }
            Object unused = l.this.ba(a);
            return true;
        }

        public Iterator<K> iterator() {
            return l.this.fK();
        }

        public void clear() {
            l.this.clear();
        }
    }

    /* access modifiers changed from: package-private */
    public Iterator<K> fK() {
        return new l<K, V>.b<K>() {
            /* access modifiers changed from: package-private */
            public K bd(int i) {
                return l.this.pI[i];
            }
        };
    }

    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.pO;
        if (set != null) {
            return set;
        }
        Set<Map.Entry<K, V>> fn = fn();
        this.pO = fn;
        return fn;
    }

    /* access modifiers changed from: package-private */
    public Set<Map.Entry<K, V>> fn() {
        return new a();
    }

    class a extends AbstractSet<Map.Entry<K, V>> {
        a() {
        }

        public int size() {
            return l.this.oW;
        }

        public void clear() {
            l.this.clear();
        }

        public Iterator<Map.Entry<K, V>> iterator() {
            return l.this.fL();
        }

        public boolean contains(@NullableDecl Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            int a = l.this.indexOf(entry.getKey());
            if (a == -1 || !Objects.equal(l.this.pJ[a], entry.getValue())) {
                return false;
            }
            return true;
        }

        public boolean remove(@NullableDecl Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            int a = l.this.indexOf(entry.getKey());
            if (a == -1 || !Objects.equal(l.this.pJ[a], entry.getValue())) {
                return false;
            }
            Object unused = l.this.ba(a);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public Iterator<Map.Entry<K, V>> fL() {
        return new l<K, V>.b<Map.Entry<K, V>>() {
            /* access modifiers changed from: package-private */
            /* renamed from: be */
            public Map.Entry<K, V> bd(int i) {
                return new d(i);
            }
        };
    }

    final class d extends e<K, V> {
        private int pU;
        @NullableDecl
        private final K pn;

        public K getKey() {
            return this.pn;
        }

        d(int i) {
            this.pn = l.this.pI[i];
            this.pU = i;
        }

        private void fO() {
            int i = this.pU;
            if (i == -1 || i >= l.this.size() || !Objects.equal(this.pn, l.this.pI[this.pU])) {
                this.pU = l.this.indexOf(this.pn);
            }
        }

        public V getValue() {
            fO();
            if (this.pU == -1) {
                return null;
            }
            return l.this.pJ[this.pU];
        }

        public V setValue(V v) {
            fO();
            if (this.pU == -1) {
                l.this.put(this.pn, v);
                return null;
            }
            V v2 = l.this.pJ[this.pU];
            l.this.pJ[this.pU] = v;
            return v2;
        }
    }

    public boolean containsValue(@NullableDecl Object obj) {
        for (int i = 0; i < this.oW; i++) {
            if (Objects.equal(obj, this.pJ[i])) {
                return true;
            }
        }
        return false;
    }

    public Collection<V> values() {
        Collection<V> collection = this.pP;
        if (collection != null) {
            return collection;
        }
        Collection<V> fg = fg();
        this.pP = fg;
        return fg;
    }

    /* access modifiers changed from: package-private */
    public Collection<V> fg() {
        return new e();
    }

    class e extends AbstractCollection<V> {
        e() {
        }

        public int size() {
            return l.this.oW;
        }

        public void clear() {
            l.this.clear();
        }

        public Iterator<V> iterator() {
            return l.this.fM();
        }
    }

    /* access modifiers changed from: package-private */
    public Iterator<V> fM() {
        return new l<K, V>.b<V>() {
            /* access modifiers changed from: package-private */
            public V bd(int i) {
                return l.this.pJ[i];
            }
        };
    }

    public void clear() {
        this.pL++;
        Arrays.fill(this.pI, 0, this.oW, (Object) null);
        Arrays.fill(this.pJ, 0, this.oW, (Object) null);
        Arrays.fill(this.pG, -1);
        Arrays.fill(this.pH, -1);
        this.oW = 0;
    }
}
