package com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp3;

import com.fyber.inneractive.sdk.player.exoplayer2.extractor.mp3.b;
import com.fyber.inneractive.sdk.player.exoplayer2.util.u;

public final class d implements b.a {
    public final long a;
    public final long b;
    public final long c;
    public final long[] d;
    public final long e;
    public final int f;

    public d(long j, long j2, long j3, long[] jArr, long j4, int i) {
        this.a = j;
        this.b = j2;
        this.c = j3;
        this.d = jArr;
        this.e = j4;
        this.f = i;
    }

    public boolean a() {
        return this.d != null;
    }

    public long b(long j) {
        long j2;
        long j3;
        if (!a()) {
            return 0;
        }
        long j4 = this.a;
        if (j < j4) {
            return 0;
        }
        double d2 = (((double) (j - j4)) * 256.0d) / ((double) this.e);
        int b2 = u.b(this.d, (long) d2, true, false);
        int i = b2 + 1;
        long j5 = this.b;
        long j6 = (((long) i) * j5) / 100;
        if (i == 0) {
            j2 = 0;
        } else {
            j2 = this.d[b2];
        }
        if (i == 99) {
            j3 = 256;
        } else {
            j3 = this.d[i];
        }
        return j6 + (j3 == j2 ? 0 : (long) ((((double) (((j5 * ((long) (b2 + 2))) / 100) - j6)) * (d2 - ((double) j2))) / ((double) (j3 - j2))));
    }

    public long c() {
        return this.b;
    }

    public long a(long j) {
        if (!a()) {
            return this.a;
        }
        float f2 = (((float) j) * 100.0f) / ((float) this.b);
        float f3 = 0.0f;
        if (f2 > 0.0f) {
            float f4 = 256.0f;
            if (f2 >= 100.0f) {
                f3 = 256.0f;
            } else {
                int i = (int) f2;
                if (i != 0) {
                    f3 = (float) this.d[i - 1];
                }
                if (i < 99) {
                    f4 = (float) this.d[i];
                }
                f3 += (f4 - f3) * (f2 - ((float) i));
            }
        }
        long round = Math.round(((double) f3) * 0.00390625d * ((double) this.e));
        long j2 = this.a;
        long j3 = round + j2;
        long j4 = this.c;
        return Math.min(j3, j4 != -1 ? j4 - 1 : ((j2 - ((long) this.f)) + this.e) - 1);
    }
}
