package com.applovin.exoplayer2.common.a;

import com.applovin.exoplayer2.common.base.Preconditions;
import com.google.errorprone.annotations.concurrent.LazyInit;
import com.ironsource.m2;

final class ar<E> extends w<E> {
    final transient E rg;
    @LazyInit
    private transient int rh;

    /* access modifiers changed from: package-private */
    public boolean fZ() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean gz() {
        return this.rh != 0;
    }

    public int size() {
        return 1;
    }

    ar(E e) {
        this.rg = Preconditions.checkNotNull(e);
    }

    ar(E e, int i) {
        this.rg = e;
        this.rh = i;
    }

    public boolean contains(Object obj) {
        return this.rg.equals(obj);
    }

    /* renamed from: fU */
    public ax<E> iterator() {
        return y.z(this.rg);
    }

    /* access modifiers changed from: package-private */
    public s<E> gA() {
        return s.u(this.rg);
    }

    /* access modifiers changed from: package-private */
    public int a(Object[] objArr, int i) {
        objArr[i] = this.rg;
        return i + 1;
    }

    public final int hashCode() {
        int i = this.rh;
        if (i != 0) {
            return i;
        }
        int hashCode = this.rg.hashCode();
        this.rh = hashCode;
        return hashCode;
    }

    public String toString() {
        return m2.i.d + this.rg.toString() + ']';
    }
}
