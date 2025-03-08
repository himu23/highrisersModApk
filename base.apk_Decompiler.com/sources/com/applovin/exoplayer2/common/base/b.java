package com.applovin.exoplayer2.common.base;

import java.util.Iterator;
import java.util.NoSuchElementException;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

abstract class b<T> implements Iterator<T> {
    private a nA = a.NOT_READY;
    @NullableDecl
    private T nB;

    private enum a {
        READY,
        NOT_READY,
        DONE,
        FAILED
    }

    /* access modifiers changed from: protected */
    public abstract T eT();

    protected b() {
    }

    /* access modifiers changed from: protected */
    @NullableDecl
    public final T eU() {
        this.nA = a.DONE;
        return null;
    }

    /* renamed from: com.applovin.exoplayer2.common.base.b$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] nC;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.applovin.exoplayer2.common.base.b$a[] r0 = com.applovin.exoplayer2.common.base.b.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                nC = r0
                com.applovin.exoplayer2.common.base.b$a r1 = com.applovin.exoplayer2.common.base.b.a.READY     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = nC     // Catch:{ NoSuchFieldError -> 0x001d }
                com.applovin.exoplayer2.common.base.b$a r1 = com.applovin.exoplayer2.common.base.b.a.DONE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.applovin.exoplayer2.common.base.b.AnonymousClass1.<clinit>():void");
        }
    }

    public final boolean hasNext() {
        Preconditions.checkState(this.nA != a.FAILED);
        int i = AnonymousClass1.nC[this.nA.ordinal()];
        if (i == 1) {
            return true;
        }
        if (i != 2) {
            return eV();
        }
        return false;
    }

    private boolean eV() {
        this.nA = a.FAILED;
        this.nB = eT();
        if (this.nA == a.DONE) {
            return false;
        }
        this.nA = a.READY;
        return true;
    }

    public final T next() {
        if (hasNext()) {
            this.nA = a.NOT_READY;
            T t = this.nB;
            this.nB = null;
            return t;
        }
        throw new NoSuchElementException();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
