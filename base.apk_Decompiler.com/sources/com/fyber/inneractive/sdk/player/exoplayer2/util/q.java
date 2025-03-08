package com.fyber.inneractive.sdk.player.exoplayer2.util;

import android.os.SystemClock;
import com.fyber.inneractive.sdk.player.exoplayer2.b;
import com.fyber.inneractive.sdk.player.exoplayer2.m;

public final class q implements g {
    public boolean a;
    public long b;
    public long c;
    public m d = m.d;

    public m i() {
        return this.d;
    }

    public void a(long j) {
        this.b = j;
        if (this.a) {
            this.c = SystemClock.elapsedRealtime();
        }
    }

    public long o() {
        long j;
        long j2 = this.b;
        if (!this.a) {
            return j2;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.c;
        m mVar = this.d;
        if (mVar.a == 1.0f) {
            j = b.a(elapsedRealtime);
        } else {
            j = elapsedRealtime * ((long) mVar.c);
        }
        return j2 + j;
    }

    public void a(g gVar) {
        a(gVar.o());
        this.d = gVar.i();
    }

    public m a(m mVar) {
        if (this.a) {
            a(o());
        }
        this.d = mVar;
        return mVar;
    }
}
