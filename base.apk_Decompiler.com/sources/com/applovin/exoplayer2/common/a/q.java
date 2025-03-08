package com.applovin.exoplayer2.common.a;

import com.applovin.exoplayer2.common.base.Preconditions;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract class q<E> extends AbstractCollection<E> implements Serializable {
    private static final Object[] qb = new Object[0];

    public abstract boolean contains(@NullableDecl Object obj);

    /* renamed from: fU */
    public abstract ax<E> iterator();

    /* access modifiers changed from: package-private */
    public Object[] fV() {
        return null;
    }

    /* access modifiers changed from: package-private */
    public abstract boolean fZ();

    q() {
    }

    public final Object[] toArray() {
        return toArray(qb);
    }

    public final <T> T[] toArray(T[] tArr) {
        Preconditions.checkNotNull(tArr);
        int size = size();
        if (tArr.length < size) {
            Object[] fV = fV();
            if (fV != null) {
                return aj.a(fV, fW(), fX(), tArr);
            }
            tArr = ah.c(tArr, size);
        } else if (tArr.length > size) {
            tArr[size] = null;
        }
        a(tArr, 0);
        return tArr;
    }

    /* access modifiers changed from: package-private */
    public int fW() {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    public int fX() {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean add(E e) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public s<E> fY() {
        return isEmpty() ? s.ga() : s.d(toArray());
    }

    /* access modifiers changed from: package-private */
    public int a(Object[] objArr, int i) {
        ax fU = iterator();
        while (fU.hasNext()) {
            objArr[i] = fU.next();
            i++;
        }
        return i;
    }

    public static abstract class b<E> {
        static int s(int i, int i2) {
            if (i2 >= 0) {
                int i3 = i + (i >> 1) + 1;
                if (i3 < i2) {
                    i3 = Integer.highestOneBit(i2 - 1) << 1;
                }
                if (i3 < 0) {
                    return Integer.MAX_VALUE;
                }
                return i3;
            }
            throw new AssertionError("cannot store more than MAX_VALUE elements");
        }

        b() {
        }
    }

    static abstract class a<E> extends b<E> {
        int oW = 0;
        Object[] qc;
        boolean qd;

        a(int i) {
            j.a(i, "initialCapacity");
            this.qc = new Object[i];
        }

        private void bh(int i) {
            Object[] objArr = this.qc;
            if (objArr.length < i) {
                this.qc = Arrays.copyOf(objArr, s(objArr.length, i));
                this.qd = false;
            } else if (this.qd) {
                this.qc = (Object[]) objArr.clone();
                this.qd = false;
            }
        }

        public a<E> t(E e) {
            Preconditions.checkNotNull(e);
            bh(this.oW + 1);
            Object[] objArr = this.qc;
            int i = this.oW;
            this.oW = i + 1;
            objArr[i] = e;
            return this;
        }
    }
}
