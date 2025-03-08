package com.applovin.exoplayer2;

import android.util.Pair;
import com.applovin.exoplayer2.ba;
import com.applovin.exoplayer2.h.z;

public abstract class a extends ba {
    private final int B;
    private final z C;
    private final boolean D;

    /* access modifiers changed from: protected */
    public abstract int c(int i);

    /* access modifiers changed from: protected */
    public abstract int d(int i);

    /* access modifiers changed from: protected */
    public abstract int d(Object obj);

    /* access modifiers changed from: protected */
    public abstract ba e(int i);

    /* access modifiers changed from: protected */
    public abstract int f(int i);

    /* access modifiers changed from: protected */
    public abstract int g(int i);

    /* access modifiers changed from: protected */
    public abstract Object h(int i);

    public static Object a(Object obj) {
        return ((Pair) obj).first;
    }

    public static Object b(Object obj) {
        return ((Pair) obj).second;
    }

    public static Object a(Object obj, Object obj2) {
        return Pair.create(obj, obj2);
    }

    public a(boolean z, z zVar) {
        this.D = z;
        this.C = zVar;
        this.B = zVar.lG();
    }

    public int a(int i, int i2, boolean z) {
        int i3 = 0;
        if (this.D) {
            if (i2 == 1) {
                i2 = 2;
            }
            z = false;
        }
        int d = d(i);
        int g = g(d);
        ba e = e(d);
        int i4 = i - g;
        if (i2 != 2) {
            i3 = i2;
        }
        int a = e.a(i4, i3, z);
        if (a != -1) {
            return g + a;
        }
        int a2 = a(d, z);
        while (a2 != -1 && e(a2).isEmpty()) {
            a2 = a(a2, z);
        }
        if (a2 != -1) {
            return g(a2) + e(a2).d(z);
        }
        if (i2 == 2) {
            return d(z);
        }
        return -1;
    }

    public int b(int i, int i2, boolean z) {
        int i3 = 0;
        if (this.D) {
            if (i2 == 1) {
                i2 = 2;
            }
            z = false;
        }
        int d = d(i);
        int g = g(d);
        ba e = e(d);
        int i4 = i - g;
        if (i2 != 2) {
            i3 = i2;
        }
        int b = e.b(i4, i3, z);
        if (b != -1) {
            return g + b;
        }
        int b2 = b(d, z);
        while (b2 != -1 && e(b2).isEmpty()) {
            b2 = b(b2, z);
        }
        if (b2 != -1) {
            return g(b2) + e(b2).c(z);
        }
        if (i2 == 2) {
            return c(z);
        }
        return -1;
    }

    public int c(boolean z) {
        int i = this.B;
        if (i == 0) {
            return -1;
        }
        if (this.D) {
            z = false;
        }
        int lH = z ? this.C.lH() : i - 1;
        while (e(lH).isEmpty()) {
            lH = b(lH, z);
            if (lH == -1) {
                return -1;
            }
        }
        return g(lH) + e(lH).c(z);
    }

    public int d(boolean z) {
        if (this.B == 0) {
            return -1;
        }
        int i = 0;
        if (this.D) {
            z = false;
        }
        if (z) {
            i = this.C.lI();
        }
        while (e(i).isEmpty()) {
            i = a(i, z);
            if (i == -1) {
                return -1;
            }
        }
        return g(i) + e(i).d(z);
    }

    public final ba.c a(int i, ba.c cVar, long j) {
        int d = d(i);
        int g = g(d);
        int f = f(d);
        e(d).a(i - g, cVar, j);
        Object h = h(d);
        if (!ba.c.iF.equals(cVar.ch)) {
            h = a(h, cVar.ch);
        }
        cVar.ch = h;
        cVar.iQ += f;
        cVar.iR += f;
        return cVar;
    }

    public final ba.a a(Object obj, ba.a aVar) {
        Object a = a(obj);
        Object b = b(obj);
        int d = d(a);
        int g = g(d);
        e(d).a(b, aVar);
        aVar.cN += g;
        aVar.ch = obj;
        return aVar;
    }

    public final ba.a a(int i, ba.a aVar, boolean z) {
        int c = c(i);
        int g = g(c);
        e(c).a(i - f(c), aVar, z);
        aVar.cN += g;
        if (z) {
            aVar.ch = a(h(c), com.applovin.exoplayer2.l.a.checkNotNull(aVar.ch));
        }
        return aVar;
    }

    public final int c(Object obj) {
        int c;
        if (!(obj instanceof Pair)) {
            return -1;
        }
        Object a = a(obj);
        Object b = b(obj);
        int d = d(a);
        if (d == -1 || (c = e(d).c(b)) == -1) {
            return -1;
        }
        return f(d) + c;
    }

    public final Object b(int i) {
        int c = c(i);
        return a(h(c), e(c).b(i - f(c)));
    }

    private int a(int i, boolean z) {
        if (z) {
            return this.C.dV(i);
        }
        if (i < this.B - 1) {
            return i + 1;
        }
        return -1;
    }

    private int b(int i, boolean z) {
        if (z) {
            return this.C.dW(i);
        }
        if (i > 0) {
            return i - 1;
        }
        return -1;
    }
}
