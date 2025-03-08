package com.applovin.exoplayer2.common.a;

import com.applovin.exoplayer2.common.b.c;
import com.applovin.exoplayer2.common.b.d;
import java.util.Comparator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract class n {
    /* access modifiers changed from: private */
    public static final n pW = new n() {
        public int fQ() {
            return 0;
        }

        public <T> n a(@NullableDecl T t, @NullableDecl T t2, Comparator<T> comparator) {
            return bf(comparator.compare(t, t2));
        }

        public n r(int i, int i2) {
            return bf(c.w(i, i2));
        }

        public n i(long j, long j2) {
            return bf(d.j(j, j2));
        }

        public n c(boolean z, boolean z2) {
            return bf(com.applovin.exoplayer2.common.b.a.e(z2, z));
        }

        public n d(boolean z, boolean z2) {
            return bf(com.applovin.exoplayer2.common.b.a.e(z, z2));
        }

        /* access modifiers changed from: package-private */
        public n bf(int i) {
            if (i < 0) {
                return n.pX;
            }
            return i > 0 ? n.pY : n.pW;
        }
    };
    /* access modifiers changed from: private */
    public static final n pX = new a(-1);
    /* access modifiers changed from: private */
    public static final n pY = new a(1);

    public static n fP() {
        return pW;
    }

    public abstract <T> n a(@NullableDecl T t, @NullableDecl T t2, Comparator<T> comparator);

    public abstract n c(boolean z, boolean z2);

    public abstract n d(boolean z, boolean z2);

    public abstract int fQ();

    public abstract n i(long j, long j2);

    public abstract n r(int i, int i2);

    private n() {
    }

    private static final class a extends n {
        final int pZ;

        public <T> n a(@NullableDecl T t, @NullableDecl T t2, @NullableDecl Comparator<T> comparator) {
            return this;
        }

        public n c(boolean z, boolean z2) {
            return this;
        }

        public n d(boolean z, boolean z2) {
            return this;
        }

        public int fQ() {
            return this.pZ;
        }

        public n i(long j, long j2) {
            return this;
        }

        public n r(int i, int i2) {
            return this;
        }

        a(int i) {
            super();
            this.pZ = i;
        }
    }
}
