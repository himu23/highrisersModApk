package com.applovin.exoplayer2.common.a;

import com.applovin.exoplayer2.common.base.Preconditions;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.util.Arrays;
import java.util.Collection;
import java.util.Set;
import java.util.SortedSet;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract class w<E> extends q<E> implements Set<E> {
    @NullableDecl
    @LazyInit
    private transient s<E> qw;

    private static boolean v(int i, int i2) {
        return i < (i2 >> 1) + (i2 >> 2);
    }

    /* renamed from: fU */
    public abstract ax<E> iterator();

    /* access modifiers changed from: package-private */
    public boolean gz() {
        return false;
    }

    public static <E> w<E> gy() {
        return am.qT;
    }

    public static <E> w<E> y(E e) {
        return new ar(e);
    }

    public static <E> w<E> m(E e, E e2) {
        return a(2, e, e2);
    }

    public static <E> w<E> a(E e, E e2, E e3) {
        return a(3, e, e2, e3);
    }

    private static <E> w<E> a(int i, Object... objArr) {
        if (i == 0) {
            return gy();
        }
        if (i == 1) {
            return y(objArr[0]);
        }
        int bk = bk(i);
        Object[] objArr2 = new Object[bk];
        int i2 = bk - 1;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < i; i5++) {
            Object b = ah.b(objArr[i5], i5);
            int hashCode = b.hashCode();
            int bg = p.bg(hashCode);
            while (true) {
                int i6 = bg & i2;
                Object obj = objArr2[i6];
                if (obj == null) {
                    objArr[i4] = b;
                    objArr2[i6] = b;
                    i3 += hashCode;
                    i4++;
                    break;
                } else if (obj.equals(b)) {
                    break;
                } else {
                    bg++;
                }
            }
        }
        Arrays.fill(objArr, i4, i, (Object) null);
        if (i4 == 1) {
            return new ar(objArr[0], i3);
        }
        if (bk(i4) < bk / 2) {
            return a(i4, objArr);
        }
        if (v(i4, objArr.length)) {
            objArr = Arrays.copyOf(objArr, i4);
        }
        return new am(objArr, i3, objArr2, i2, i4);
    }

    static int bk(int i) {
        int max = Math.max(i, 2);
        boolean z = true;
        if (max < 751619276) {
            int highestOneBit = Integer.highestOneBit(max - 1) << 1;
            while (((double) highestOneBit) * 0.7d < ((double) max)) {
                highestOneBit <<= 1;
            }
            return highestOneBit;
        }
        if (max >= 1073741824) {
            z = false;
        }
        Preconditions.checkArgument(z, "collection too large");
        return 1073741824;
    }

    public static <E> w<E> e(Collection<? extends E> collection) {
        if ((collection instanceof w) && !(collection instanceof SortedSet)) {
            w<E> wVar = (w) collection;
            if (!wVar.fZ()) {
                return wVar;
            }
        }
        Object[] array = collection.toArray();
        return a(array.length, array);
    }

    public static <E> w<E> e(E[] eArr) {
        int length = eArr.length;
        if (length == 0) {
            return gy();
        }
        if (length != 1) {
            return a(eArr.length, (Object[]) eArr.clone());
        }
        return y(eArr[0]);
    }

    w() {
    }

    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof w) || !gz() || !((w) obj).gz() || hashCode() == obj.hashCode()) {
            return aq.a((Set<?>) this, obj);
        }
        return false;
    }

    public int hashCode() {
        return aq.a(this);
    }

    public s<E> fY() {
        s<E> sVar = this.qw;
        if (sVar != null) {
            return sVar;
        }
        s<E> gA = gA();
        this.qw = gA;
        return gA;
    }

    /* access modifiers changed from: package-private */
    public s<E> gA() {
        return s.d(toArray());
    }
}
