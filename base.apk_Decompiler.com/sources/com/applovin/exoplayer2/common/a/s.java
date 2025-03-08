package com.applovin.exoplayer2.common.a;

import com.applovin.exoplayer2.common.a.q;
import com.applovin.exoplayer2.common.base.Preconditions;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public abstract class s<E> extends q<E> implements List<E>, RandomAccess {
    private static final ay<Object> qe = new b(ak.qO, 0);

    public final s<E> fY() {
        return this;
    }

    public static <E> s<E> ga() {
        return ak.qO;
    }

    public static <E> s<E> u(E e) {
        return c(e);
    }

    public static <E> s<E> k(E e, E e2) {
        return c(e, e2);
    }

    public static <E> s<E> a(E e, E e2, E e3, E e4, E e5) {
        return c(e, e2, e3, e4, e5);
    }

    public static <E> s<E> a(E e, E e2, E e3, E e4, E e5, E e6) {
        return c(e, e2, e3, e4, e5, e6);
    }

    public static <E> s<E> d(Collection<? extends E> collection) {
        if (!(collection instanceof q)) {
            return c(collection.toArray());
        }
        s<E> fY = ((q) collection).fY();
        return fY.fZ() ? d(fY.toArray()) : fY;
    }

    public static <E> s<E> b(E[] eArr) {
        if (eArr.length == 0) {
            return ga();
        }
        return c((Object[]) eArr.clone());
    }

    public static <E> s<E> a(Comparator<? super E> comparator, Iterable<? extends E> iterable) {
        Preconditions.checkNotNull(comparator);
        Object[] d = x.d(iterable);
        ah.f(d);
        Arrays.sort(d, comparator);
        return d(d);
    }

    private static <E> s<E> c(Object... objArr) {
        return d(ah.f(objArr));
    }

    static <E> s<E> d(Object[] objArr) {
        return b(objArr, objArr.length);
    }

    static <E> s<E> b(Object[] objArr, int i) {
        if (i == 0) {
            return ga();
        }
        return new ak(objArr, i);
    }

    s() {
    }

    /* renamed from: fU */
    public ax<E> iterator() {
        return listIterator();
    }

    /* renamed from: gb */
    public ay<E> listIterator() {
        return listIterator(0);
    }

    /* renamed from: bi */
    public ay<E> listIterator(int i) {
        Preconditions.checkPositionIndex(i, size());
        if (isEmpty()) {
            return qe;
        }
        return new b(this, i);
    }

    static class b<E> extends a<E> {
        private final s<E> ai;

        b(s<E> sVar, int i) {
            super(sVar.size(), i);
            this.ai = sVar;
        }

        /* access modifiers changed from: protected */
        public E get(int i) {
            return this.ai.get(i);
        }
    }

    public int indexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        return aa.b(this, obj);
    }

    public int lastIndexOf(Object obj) {
        if (obj == null) {
            return -1;
        }
        return aa.d(this, obj);
    }

    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    /* renamed from: t */
    public s<E> subList(int i, int i2) {
        Preconditions.checkPositionIndexes(i, i2, size());
        int i3 = i2 - i;
        if (i3 == size()) {
            return this;
        }
        if (i3 == 0) {
            return ga();
        }
        return u(i, i2);
    }

    /* access modifiers changed from: package-private */
    public s<E> u(int i, int i2) {
        return new c(i, i2 - i);
    }

    class c extends s<E> {
        final transient int fR;
        final transient int oU;

        /* access modifiers changed from: package-private */
        public boolean fZ() {
            return true;
        }

        public int size() {
            return this.fR;
        }

        public /* synthetic */ Iterator iterator() {
            return s.super.iterator();
        }

        public /* synthetic */ ListIterator listIterator() {
            return s.super.listIterator();
        }

        public /* synthetic */ ListIterator listIterator(int i) {
            return s.super.listIterator(i);
        }

        c(int i, int i2) {
            this.oU = i;
            this.fR = i2;
        }

        /* access modifiers changed from: package-private */
        public Object[] fV() {
            return s.this.fV();
        }

        /* access modifiers changed from: package-private */
        public int fW() {
            return s.this.fW() + this.oU;
        }

        /* access modifiers changed from: package-private */
        public int fX() {
            return s.this.fW() + this.oU + this.fR;
        }

        public E get(int i) {
            Preconditions.checkElementIndex(i, this.fR);
            return s.this.get(i + this.oU);
        }

        /* renamed from: t */
        public s<E> subList(int i, int i2) {
            Preconditions.checkPositionIndexes(i, i2, this.fR);
            s sVar = s.this;
            int i3 = this.oU;
            return sVar.subList(i + i3, i2 + i3);
        }
    }

    @Deprecated
    public final boolean addAll(int i, Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final E set(int i, E e) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void add(int i, E e) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final E remove(int i) {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    public int a(Object[] objArr, int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            objArr[i + i2] = get(i2);
        }
        return i + size;
    }

    public boolean equals(Object obj) {
        return aa.a(this, obj);
    }

    public int hashCode() {
        int size = size();
        int i = 1;
        for (int i2 = 0; i2 < size; i2++) {
            i = ~(~((i * 31) + get(i2).hashCode()));
        }
        return i;
    }

    public static <E> a<E> gc() {
        return new a<>();
    }

    public static final class a<E> extends q.a<E> {
        public a() {
            this(4);
        }

        a(int i) {
            super(i);
        }

        /* renamed from: v */
        public a<E> t(E e) {
            super.t(e);
            return this;
        }

        public s<E> gd() {
            this.qd = true;
            return s.b(this.qc, this.oW);
        }
    }
}
