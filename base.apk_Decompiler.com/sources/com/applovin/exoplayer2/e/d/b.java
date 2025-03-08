package com.applovin.exoplayer2.e.d;

import java.util.List;

final class b {
    public final long wy;
    public final List<a> wz;

    public static final class a {
        public final String wA;
        public final String wB;
        public final long wC;
        public final long wD;

        public a(String str, String str2, long j, long j2) {
            this.wA = str;
            this.wB = str2;
            this.wC = j;
            this.wD = j2;
        }
    }

    public b(long j, List<a> list) {
        this.wy = j;
        this.wz = list;
    }

    public com.applovin.exoplayer2.g.f.b ao(long j) {
        long j2;
        if (this.wz.size() < 2) {
            return null;
        }
        long j3 = j;
        long j4 = -1;
        long j5 = -1;
        long j6 = -1;
        long j7 = -1;
        boolean z = false;
        for (int size = this.wz.size() - 1; size >= 0; size--) {
            a aVar = this.wz.get(size);
            boolean equals = "video/mp4".equals(aVar.wA) | z;
            if (size == 0) {
                j3 -= aVar.wD;
                j2 = 0;
            } else {
                j2 = j3 - aVar.wC;
            }
            long j8 = j3;
            j3 = j2;
            long j9 = j8;
            if (!equals || j3 == j9) {
                z = equals;
            } else {
                j7 = j9 - j3;
                j6 = j3;
                z = false;
            }
            if (size == 0) {
                j4 = j3;
                j5 = j9;
            }
        }
        if (j6 == -1 || j7 == -1 || j4 == -1 || j5 == -1) {
            return null;
        }
        return new com.applovin.exoplayer2.g.f.b(j4, j5, this.wy, j6, j7);
    }
}
