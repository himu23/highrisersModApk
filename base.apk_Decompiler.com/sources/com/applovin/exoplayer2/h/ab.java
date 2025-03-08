package com.applovin.exoplayer2.h;

import android.util.SparseArray;
import com.applovin.exoplayer2.l.a;
import com.applovin.exoplayer2.l.h;

final class ab<V> {
    private int NC;
    private final SparseArray<V> ND;
    private final h<V> NE;

    /* access modifiers changed from: private */
    public static /* synthetic */ void I(Object obj) {
    }

    public ab() {
        this(new ab$$ExternalSyntheticLambda0());
    }

    public ab(h<V> hVar) {
        this.ND = new SparseArray<>();
        this.NE = hVar;
        this.NC = -1;
    }

    public V get(int i) {
        if (this.NC == -1) {
            this.NC = 0;
        }
        while (true) {
            int i2 = this.NC;
            if (i2 > 0 && i < this.ND.keyAt(i2)) {
                this.NC--;
            }
        }
        while (this.NC < this.ND.size() - 1 && i >= this.ND.keyAt(this.NC + 1)) {
            this.NC++;
        }
        return this.ND.valueAt(this.NC);
    }

    public void b(int i, V v) {
        boolean z = false;
        if (this.NC == -1) {
            a.checkState(this.ND.size() == 0);
            this.NC = 0;
        }
        if (this.ND.size() > 0) {
            SparseArray<V> sparseArray = this.ND;
            int keyAt = sparseArray.keyAt(sparseArray.size() - 1);
            if (i >= keyAt) {
                z = true;
            }
            a.checkArgument(z);
            if (keyAt == i) {
                h<V> hVar = this.NE;
                SparseArray<V> sparseArray2 = this.ND;
                hVar.accept(sparseArray2.valueAt(sparseArray2.size() - 1));
            }
        }
        this.ND.append(i, v);
    }

    public V lK() {
        SparseArray<V> sparseArray = this.ND;
        return sparseArray.valueAt(sparseArray.size() - 1);
    }

    public void dX(int i) {
        int i2 = 0;
        while (i2 < this.ND.size() - 1) {
            int i3 = i2 + 1;
            if (i >= this.ND.keyAt(i3)) {
                this.NE.accept(this.ND.valueAt(i2));
                this.ND.removeAt(i2);
                int i4 = this.NC;
                if (i4 > 0) {
                    this.NC = i4 - 1;
                }
                i2 = i3;
            } else {
                return;
            }
        }
    }

    public void dY(int i) {
        int size = this.ND.size() - 1;
        while (size >= 0 && i < this.ND.keyAt(size)) {
            this.NE.accept(this.ND.valueAt(size));
            this.ND.removeAt(size);
            size--;
        }
        this.NC = this.ND.size() > 0 ? Math.min(this.NC, this.ND.size() - 1) : -1;
    }

    public void clear() {
        for (int i = 0; i < this.ND.size(); i++) {
            this.NE.accept(this.ND.valueAt(i));
        }
        this.NC = -1;
        this.ND.clear();
    }

    public boolean isEmpty() {
        return this.ND.size() == 0;
    }
}
