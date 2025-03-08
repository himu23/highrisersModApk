package com.applovin.exoplayer2.e.c;

import com.applovin.exoplayer2.ai;
import com.applovin.exoplayer2.e.x;
import com.applovin.exoplayer2.l.y;

abstract class d {
    protected final x wl;

    /* access modifiers changed from: protected */
    public abstract boolean a(y yVar, long j) throws ai;

    /* access modifiers changed from: protected */
    public abstract boolean e(y yVar) throws ai;

    public static final class a extends ai {
        public a(String str) {
            super(str, (Throwable) null, false, 1);
        }
    }

    protected d(x xVar) {
        this.wl = xVar;
    }

    public final boolean b(y yVar, long j) throws ai {
        return e(yVar) && a(yVar, j);
    }
}
