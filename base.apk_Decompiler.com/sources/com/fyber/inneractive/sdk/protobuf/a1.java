package com.fyber.inneractive.sdk.protobuf;

import com.fyber.inneractive.sdk.protobuf.y;
import java.util.Arrays;
import java.util.RandomAccess;

public final class a1<E> extends c<E> implements RandomAccess {
    public static final a1<Object> d;
    public E[] b;
    public int c;

    static {
        a1<Object> a1Var = new a1<>(new Object[0], 0);
        d = a1Var;
        a1Var.a = false;
    }

    public a1(E[] eArr, int i) {
        this.b = eArr;
        this.c = i;
    }

    public boolean add(E e) {
        e();
        int i = this.c;
        E[] eArr = this.b;
        if (i == eArr.length) {
            this.b = Arrays.copyOf(eArr, ((i * 3) / 2) + 1);
        }
        E[] eArr2 = this.b;
        int i2 = this.c;
        this.c = i2 + 1;
        eArr2[i2] = e;
        this.modCount++;
        return true;
    }

    public final String d(int i) {
        return "Index:" + i + ", Size:" + this.c;
    }

    public E get(int i) {
        c(i);
        return this.b[i];
    }

    public E remove(int i) {
        e();
        c(i);
        E[] eArr = this.b;
        E e = eArr[i];
        int i2 = this.c;
        if (i < i2 - 1) {
            System.arraycopy(eArr, i + 1, eArr, i, (i2 - i) - 1);
        }
        this.c--;
        this.modCount++;
        return e;
    }

    public E set(int i, E e) {
        e();
        c(i);
        E[] eArr = this.b;
        E e2 = eArr[i];
        eArr[i] = e;
        this.modCount++;
        return e2;
    }

    public int size() {
        return this.c;
    }

    public final void c(int i) {
        if (i < 0 || i >= this.c) {
            throw new IndexOutOfBoundsException(d(i));
        }
    }

    public y.j b(int i) {
        if (i >= this.c) {
            return new a1(Arrays.copyOf(this.b, i), this.c);
        }
        throw new IllegalArgumentException();
    }

    public void add(int i, E e) {
        int i2;
        e();
        if (i < 0 || i > (i2 = this.c)) {
            throw new IndexOutOfBoundsException(d(i));
        }
        E[] eArr = this.b;
        if (i2 < eArr.length) {
            System.arraycopy(eArr, i, eArr, i + 1, i2 - i);
        } else {
            E[] eArr2 = new Object[(((i2 * 3) / 2) + 1)];
            System.arraycopy(eArr, 0, eArr2, 0, i);
            System.arraycopy(this.b, i, eArr2, i + 1, this.c - i);
            this.b = eArr2;
        }
        this.b[i] = e;
        this.c++;
        this.modCount++;
    }
}
