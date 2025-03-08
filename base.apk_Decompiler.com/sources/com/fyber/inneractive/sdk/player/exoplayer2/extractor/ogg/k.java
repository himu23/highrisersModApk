package com.fyber.inneractive.sdk.player.exoplayer2.extractor.ogg;

import com.fyber.inneractive.sdk.player.exoplayer2.l;

public final class k {

    public static final class a {
        public a(String str, String[] strArr, int i) {
        }
    }

    public static final class b {
        public final boolean a;

        public b(boolean z, int i, int i2, int i3) {
            this.a = z;
        }
    }

    public static final class c {
        public final int a;
        public final long b;
        public final int c;
        public final int d;
        public final int e;
        public final byte[] f;

        public c(long j, int i, long j2, int i2, int i3, int i4, int i5, int i6, boolean z, byte[] bArr) {
            this.a = i;
            this.b = j2;
            this.c = i3;
            this.d = i5;
            this.e = i6;
            this.f = bArr;
        }
    }

    public static int a(int i) {
        int i2 = 0;
        while (i > 0) {
            i2++;
            i >>>= 1;
        }
        return i2;
    }

    public static boolean a(int i, com.fyber.inneractive.sdk.player.exoplayer2.util.k kVar, boolean z) throws l {
        if (kVar.a() < 7) {
            if (z) {
                return false;
            }
            throw new l("too short header: " + kVar.a());
        } else if (kVar.l() != i) {
            if (z) {
                return false;
            }
            throw new l("expected header type " + Integer.toHexString(i));
        } else if (kVar.l() == 118 && kVar.l() == 111 && kVar.l() == 114 && kVar.l() == 98 && kVar.l() == 105 && kVar.l() == 115) {
            return true;
        } else {
            if (z) {
                return false;
            }
            throw new l("expected characters 'vorbis'");
        }
    }
}
