package com.fyber.inneractive.sdk.player.exoplayer2.trackselection;

import android.os.SystemClock;
import com.fyber.inneractive.sdk.player.exoplayer2.i;
import com.fyber.inneractive.sdk.player.exoplayer2.source.r;
import java.util.Arrays;
import java.util.Comparator;

public abstract class a implements e {
    public final r a;
    public final int b;
    public final int[] c;
    public final i[] d;
    public final long[] e;
    public int f;

    public static final class b implements Comparator<i> {
        public b() {
        }

        public int compare(Object obj, Object obj2) {
            return ((i) obj2).b - ((i) obj).b;
        }
    }

    public a(r rVar, int... iArr) {
        int i = 0;
        com.fyber.inneractive.sdk.player.exoplayer2.util.a.b(iArr.length > 0);
        this.a = (r) com.fyber.inneractive.sdk.player.exoplayer2.util.a.a(rVar);
        int length = iArr.length;
        this.b = length;
        this.d = new i[length];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            this.d[i2] = rVar.a(iArr[i2]);
        }
        Arrays.sort(this.d, new b());
        this.c = new int[this.b];
        while (true) {
            int i3 = this.b;
            if (i < i3) {
                this.c[i] = rVar.a(this.d[i]);
                i++;
            } else {
                this.e = new long[i3];
                return;
            }
        }
    }

    public final i a(int i) {
        return this.d[i];
    }

    public final r b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        if (this.a != aVar.a || !Arrays.equals(this.c, aVar.c)) {
            return false;
        }
        return true;
    }

    public final int f() {
        return this.c.length;
    }

    public final int b(int i) {
        return this.c[i];
    }

    public final int c(int i) {
        for (int i2 = 0; i2 < this.b; i2++) {
            if (this.c[i2] == i) {
                return i2;
            }
        }
        return -1;
    }

    public int hashCode() {
        if (this.f == 0) {
            this.f = (System.identityHashCode(this.a) * 31) + Arrays.hashCode(this.c);
        }
        return this.f;
    }

    public final int a(i iVar) {
        for (int i = 0; i < this.b; i++) {
            if (this.d[i] == iVar) {
                return i;
            }
        }
        return -1;
    }

    public final boolean b(int i, long j) {
        return this.e[i] > j;
    }

    public final i c() {
        return this.d[e()];
    }

    public final int a() {
        return this.c[e()];
    }

    public final boolean a(int i, long j) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        boolean b2 = b(i, elapsedRealtime);
        int i2 = 0;
        while (i2 < this.b && !b2) {
            b2 = i2 != i && !b(i2, elapsedRealtime);
            i2++;
        }
        if (!b2) {
            return false;
        }
        long[] jArr = this.e;
        jArr[i] = Math.max(jArr[i], elapsedRealtime + j);
        return true;
    }
}
