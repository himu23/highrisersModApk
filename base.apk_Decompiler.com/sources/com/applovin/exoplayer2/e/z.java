package com.applovin.exoplayer2.e;

import com.applovin.exoplayer2.ai;
import com.applovin.exoplayer2.l.q;
import com.applovin.exoplayer2.l.y;
import java.util.Arrays;

public final class z {
    public static int bS(int i) {
        int i2 = 0;
        while (i > 0) {
            i2++;
            i >>>= 1;
        }
        return i2;
    }

    public static final class b {
        public final int fR;
        public final String ve;
        public final String[] vf;

        public b(String str, String[] strArr, int i) {
            this.ve = str;
            this.vf = strArr;
            this.fR = i;
        }
    }

    public static final class d {
        public final int dM;
        public final int mH;
        public final int mI;
        public final byte[] tf;
        public final int vk;
        public final int vl;
        public final int vm;
        public final int vn;
        public final int vo;
        public final boolean vp;

        public d(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z, byte[] bArr) {
            this.mH = i;
            this.mI = i2;
            this.dM = i3;
            this.vk = i4;
            this.vl = i5;
            this.vm = i6;
            this.vn = i7;
            this.vo = i8;
            this.vp = z;
            this.tf = bArr;
        }
    }

    public static final class c {
        public final boolean vg;
        public final int vh;
        public final int vi;
        public final int vj;

        public c(boolean z, int i, int i2, int i3) {
            this.vg = z;
            this.vh = i;
            this.vi = i2;
            this.vj = i3;
        }
    }

    public static d c(y yVar) throws ai {
        boolean z = true;
        a(1, yVar, false);
        int pE = yVar.pE();
        int po = yVar.po();
        int pE2 = yVar.pE();
        int py = yVar.py();
        if (py <= 0) {
            py = -1;
        }
        int py2 = yVar.py();
        if (py2 <= 0) {
            py2 = -1;
        }
        int py3 = yVar.py();
        if (py3 <= 0) {
            py3 = -1;
        }
        int po2 = yVar.po();
        int pow = (int) Math.pow(2.0d, (double) (po2 & 15));
        int pow2 = (int) Math.pow(2.0d, (double) ((po2 & 240) >> 4));
        if ((yVar.po() & 1) <= 0) {
            z = false;
        }
        return new d(pE, po, pE2, py, py2, py3, pow, pow2, z, Arrays.copyOf(yVar.hO(), yVar.pk()));
    }

    public static b d(y yVar) throws ai {
        return a(yVar, true, true);
    }

    public static b a(y yVar, boolean z, boolean z2) throws ai {
        if (z) {
            a(3, yVar, false);
        }
        String fB = yVar.fB((int) yVar.pw());
        int length = fB.length();
        long pw = yVar.pw();
        String[] strArr = new String[((int) pw)];
        int i = length + 15;
        for (int i2 = 0; ((long) i2) < pw; i2++) {
            String fB2 = yVar.fB((int) yVar.pw());
            strArr[i2] = fB2;
            i = i + 4 + fB2.length();
        }
        if (!z2 || (yVar.po() & 1) != 0) {
            return new b(fB, strArr, i + 1);
        }
        throw ai.c("framing bit expected to be set", (Throwable) null);
    }

    public static boolean a(int i, y yVar, boolean z) throws ai {
        if (yVar.pj() < 7) {
            if (z) {
                return false;
            }
            throw ai.c("too short header: " + yVar.pj(), (Throwable) null);
        } else if (yVar.po() != i) {
            if (z) {
                return false;
            }
            throw ai.c("expected header type " + Integer.toHexString(i), (Throwable) null);
        } else if (yVar.po() == 118 && yVar.po() == 111 && yVar.po() == 114 && yVar.po() == 98 && yVar.po() == 105 && yVar.po() == 115) {
            return true;
        } else {
            if (z) {
                return false;
            }
            throw ai.c("expected characters 'vorbis'", (Throwable) null);
        }
    }

    public static c[] d(y yVar, int i) throws ai {
        int i2 = 0;
        a(5, yVar, false);
        int po = yVar.po() + 1;
        y yVar2 = new y(yVar.hO());
        yVar2.bR(yVar.il() * 8);
        for (int i3 = 0; i3 < po; i3++) {
            d(yVar2);
        }
        int bQ = yVar2.bQ(6) + 1;
        while (i2 < bQ) {
            if (yVar2.bQ(16) == 0) {
                i2++;
            } else {
                throw ai.c("placeholder of time domain transforms not zeroed out", (Throwable) null);
            }
        }
        c(yVar2);
        b(yVar2);
        a(i, yVar2);
        c[] a2 = a(yVar2);
        if (yVar2.ik()) {
            return a2;
        }
        throw ai.c("framing bit after modes not set as expected", (Throwable) null);
    }

    private static c[] a(y yVar) {
        int bQ = yVar.bQ(6) + 1;
        c[] cVarArr = new c[bQ];
        for (int i = 0; i < bQ; i++) {
            cVarArr[i] = new c(yVar.ik(), yVar.bQ(16), yVar.bQ(16), yVar.bQ(8));
        }
        return cVarArr;
    }

    private static void a(int i, y yVar) throws ai {
        int bQ = yVar.bQ(6) + 1;
        for (int i2 = 0; i2 < bQ; i2++) {
            int bQ2 = yVar.bQ(16);
            if (bQ2 != 0) {
                q.i("VorbisUtil", "mapping type other than 0 not supported: " + bQ2);
            } else {
                int bQ3 = yVar.ik() ? yVar.bQ(4) + 1 : 1;
                if (yVar.ik()) {
                    int bQ4 = yVar.bQ(8) + 1;
                    for (int i3 = 0; i3 < bQ4; i3++) {
                        int i4 = i - 1;
                        yVar.bR(bS(i4));
                        yVar.bR(bS(i4));
                    }
                }
                if (yVar.bQ(2) == 0) {
                    if (bQ3 > 1) {
                        for (int i5 = 0; i5 < i; i5++) {
                            yVar.bR(4);
                        }
                    }
                    for (int i6 = 0; i6 < bQ3; i6++) {
                        yVar.bR(8);
                        yVar.bR(8);
                        yVar.bR(8);
                    }
                } else {
                    throw ai.c("to reserved bits must be zero after mapping coupling steps", (Throwable) null);
                }
            }
        }
    }

    private static void b(y yVar) throws ai {
        int bQ = yVar.bQ(6) + 1;
        int i = 0;
        while (i < bQ) {
            if (yVar.bQ(16) <= 2) {
                yVar.bR(24);
                yVar.bR(24);
                yVar.bR(24);
                int bQ2 = yVar.bQ(6) + 1;
                yVar.bR(8);
                int[] iArr = new int[bQ2];
                for (int i2 = 0; i2 < bQ2; i2++) {
                    iArr[i2] = ((yVar.ik() ? yVar.bQ(5) : 0) * 8) + yVar.bQ(3);
                }
                for (int i3 = 0; i3 < bQ2; i3++) {
                    for (int i4 = 0; i4 < 8; i4++) {
                        if ((iArr[i3] & (1 << i4)) != 0) {
                            yVar.bR(8);
                        }
                    }
                }
                i++;
            } else {
                throw ai.c("residueType greater than 2 is not decodable", (Throwable) null);
            }
        }
    }

    private static void c(y yVar) throws ai {
        int bQ = yVar.bQ(6) + 1;
        for (int i = 0; i < bQ; i++) {
            int bQ2 = yVar.bQ(16);
            if (bQ2 == 0) {
                yVar.bR(8);
                yVar.bR(16);
                yVar.bR(16);
                yVar.bR(6);
                yVar.bR(8);
                int bQ3 = yVar.bQ(4) + 1;
                for (int i2 = 0; i2 < bQ3; i2++) {
                    yVar.bR(8);
                }
            } else if (bQ2 == 1) {
                int bQ4 = yVar.bQ(5);
                int[] iArr = new int[bQ4];
                int i3 = -1;
                for (int i4 = 0; i4 < bQ4; i4++) {
                    int bQ5 = yVar.bQ(4);
                    iArr[i4] = bQ5;
                    if (bQ5 > i3) {
                        i3 = bQ5;
                    }
                }
                int i5 = i3 + 1;
                int[] iArr2 = new int[i5];
                for (int i6 = 0; i6 < i5; i6++) {
                    iArr2[i6] = yVar.bQ(3) + 1;
                    int bQ6 = yVar.bQ(2);
                    if (bQ6 > 0) {
                        yVar.bR(8);
                    }
                    for (int i7 = 0; i7 < (1 << bQ6); i7++) {
                        yVar.bR(8);
                    }
                }
                yVar.bR(2);
                int bQ7 = yVar.bQ(4);
                int i8 = 0;
                int i9 = 0;
                for (int i10 = 0; i10 < bQ4; i10++) {
                    i8 += iArr2[iArr[i10]];
                    while (i9 < i8) {
                        yVar.bR(bQ7);
                        i9++;
                    }
                }
            } else {
                throw ai.c("floor type greater than 1 not decodable: " + bQ2, (Throwable) null);
            }
        }
    }

    private static a d(y yVar) throws ai {
        if (yVar.bQ(24) == 5653314) {
            int bQ = yVar.bQ(16);
            int bQ2 = yVar.bQ(24);
            long[] jArr = new long[bQ2];
            boolean ik = yVar.ik();
            long j = 0;
            if (!ik) {
                boolean ik2 = yVar.ik();
                for (int i = 0; i < bQ2; i++) {
                    if (!ik2) {
                        jArr[i] = (long) (yVar.bQ(5) + 1);
                    } else if (yVar.ik()) {
                        jArr[i] = (long) (yVar.bQ(5) + 1);
                    } else {
                        jArr[i] = 0;
                    }
                }
            } else {
                int bQ3 = yVar.bQ(5) + 1;
                int i2 = 0;
                while (i2 < bQ2) {
                    int bQ4 = yVar.bQ(bS(bQ2 - i2));
                    for (int i3 = 0; i3 < bQ4 && i2 < bQ2; i3++) {
                        jArr[i2] = (long) bQ3;
                        i2++;
                    }
                    bQ3++;
                }
            }
            int bQ5 = yVar.bQ(4);
            if (bQ5 <= 2) {
                if (bQ5 == 1 || bQ5 == 2) {
                    yVar.bR(32);
                    yVar.bR(32);
                    int bQ6 = yVar.bQ(4) + 1;
                    yVar.bR(1);
                    if (bQ5 != 1) {
                        j = ((long) bQ2) * ((long) bQ);
                    } else if (bQ != 0) {
                        j = q((long) bQ2, (long) bQ);
                    }
                    yVar.bR((int) (j * ((long) bQ6)));
                }
                return new a(bQ, bQ2, jArr, bQ5, ik);
            }
            throw ai.c("lookup type greater than 2 not decodable: " + bQ5, (Throwable) null);
        }
        throw ai.c("expected code book to start with [0x56, 0x43, 0x42] at " + yVar.il(), (Throwable) null);
    }

    private static long q(long j, long j2) {
        return (long) Math.floor(Math.pow((double) j, 1.0d / ((double) j2)));
    }

    private static final class a {
        public final int uZ;
        public final int va;
        public final long[] vb;
        public final int vc;
        public final boolean vd;

        public a(int i, int i2, long[] jArr, int i3, boolean z) {
            this.uZ = i;
            this.va = i2;
            this.vb = jArr;
            this.vc = i3;
            this.vd = z;
        }
    }
}
