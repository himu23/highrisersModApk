package com.applovin.exoplayer2.common.a;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class am<E> extends w<E> {
    static final am<Object> qT = new am(new Object[0], 0, (Object[]) null, 0, 0);
    private final transient int dS;
    private final transient int oW;
    final transient Object[] qU;
    final transient Object[] qV;
    private final transient int qW;

    /* access modifiers changed from: package-private */
    public Object[] fV() {
        return this.qU;
    }

    /* access modifiers changed from: package-private */
    public int fW() {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public int fX() {
        return this.oW;
    }

    /* access modifiers changed from: package-private */
    public boolean fZ() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean gz() {
        return true;
    }

    public int hashCode() {
        return this.dS;
    }

    public int size() {
        return this.oW;
    }

    am(Object[] objArr, int i, Object[] objArr2, int i2, int i3) {
        this.qU = objArr;
        this.qV = objArr2;
        this.qW = i2;
        this.dS = i;
        this.oW = i3;
    }

    public boolean contains(@NullableDecl Object obj) {
        Object[] objArr = this.qV;
        if (obj == null || objArr == null) {
            return false;
        }
        int s = p.s(obj);
        while (true) {
            int i = s & this.qW;
            Object obj2 = objArr[i];
            if (obj2 == null) {
                return false;
            }
            if (obj2.equals(obj)) {
                return true;
            }
            s = i + 1;
        }
    }

    /* renamed from: fU */
    public ax<E> iterator() {
        return fY().iterator();
    }

    /* access modifiers changed from: package-private */
    public int a(Object[] objArr, int i) {
        System.arraycopy(this.qU, 0, objArr, i, this.oW);
        return i + this.oW;
    }

    /* access modifiers changed from: package-private */
    public s<E> gA() {
        return s.b(this.qU, this.oW);
    }
}
