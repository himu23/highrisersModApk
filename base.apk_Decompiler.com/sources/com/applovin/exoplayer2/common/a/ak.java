package com.applovin.exoplayer2.common.a;

import com.applovin.exoplayer2.common.base.Preconditions;

class ak<E> extends s<E> {
    static final s<Object> qO = new ak(new Object[0], 0);
    private final transient int oW;
    final transient Object[] qA;

    /* access modifiers changed from: package-private */
    public Object[] fV() {
        return this.qA;
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

    public int size() {
        return this.oW;
    }

    ak(Object[] objArr, int i) {
        this.qA = objArr;
        this.oW = i;
    }

    /* access modifiers changed from: package-private */
    public int a(Object[] objArr, int i) {
        System.arraycopy(this.qA, 0, objArr, i, this.oW);
        return i + this.oW;
    }

    public E get(int i) {
        Preconditions.checkElementIndex(i, this.oW);
        return this.qA[i];
    }
}
