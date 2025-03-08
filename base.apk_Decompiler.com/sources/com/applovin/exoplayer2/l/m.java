package com.applovin.exoplayer2.l;

import android.util.SparseBooleanArray;

public final class m {
    private final SparseBooleanArray acb;

    public static final class a {
        private final SparseBooleanArray acb = new SparseBooleanArray();
        private boolean ih;

        public a fo(int i) {
            a.checkState(!this.ih);
            this.acb.append(i, true);
            return this;
        }

        public a o(int i, boolean z) {
            return z ? fo(i) : this;
        }

        public a h(int... iArr) {
            for (int fo : iArr) {
                fo(fo);
            }
            return this;
        }

        public a a(m mVar) {
            for (int i = 0; i < mVar.size(); i++) {
                fo(mVar.fn(i));
            }
            return this;
        }

        public m oV() {
            a.checkState(!this.ih);
            this.ih = true;
            return new m(this.acb);
        }
    }

    private m(SparseBooleanArray sparseBooleanArray) {
        this.acb = sparseBooleanArray;
    }

    public boolean X(int i) {
        return this.acb.get(i);
    }

    public boolean b(int... iArr) {
        for (int X : iArr) {
            if (X(X)) {
                return true;
            }
        }
        return false;
    }

    public int size() {
        return this.acb.size();
    }

    public int fn(int i) {
        a.h(i, 0, size());
        return this.acb.keyAt(i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        if (ai.acV >= 24) {
            return this.acb.equals(mVar.acb);
        }
        if (size() != mVar.size()) {
            return false;
        }
        for (int i = 0; i < size(); i++) {
            if (fn(i) != mVar.fn(i)) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        if (ai.acV >= 24) {
            return this.acb.hashCode();
        }
        int size = size();
        for (int i = 0; i < size(); i++) {
            size = (size * 31) + fn(i);
        }
        return size;
    }
}
