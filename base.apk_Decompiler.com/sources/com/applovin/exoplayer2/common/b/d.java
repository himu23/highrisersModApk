package com.applovin.exoplayer2.common.b;

import com.applovin.exoplayer2.common.base.Preconditions;

public final class d {
    public static int ae(long j) {
        return (int) (j ^ (j >>> 32));
    }

    public static int j(long j, long j2) {
        int i = (j > j2 ? 1 : (j == j2 ? 0 : -1));
        if (i < 0) {
            return -1;
        }
        return i > 0 ? 1 : 0;
    }

    public static long a(long... jArr) {
        Preconditions.checkArgument(jArr.length > 0);
        long j = jArr[0];
        for (int i = 1; i < jArr.length; i++) {
            long j2 = jArr[i];
            if (j2 > j) {
                j = j2;
            }
        }
        return j;
    }
}
