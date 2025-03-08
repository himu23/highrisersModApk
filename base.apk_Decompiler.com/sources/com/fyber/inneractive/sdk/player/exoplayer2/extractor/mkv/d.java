package com.fyber.inneractive.sdk.player.exoplayer2.extractor.mkv;

import android.util.SparseArray;
import androidx.work.impl.Scheduler;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.f;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.g;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.h;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.i;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.m;
import com.fyber.inneractive.sdk.player.exoplayer2.extractor.n;
import com.fyber.inneractive.sdk.player.exoplayer2.l;
import com.fyber.inneractive.sdk.player.exoplayer2.util.k;
import com.fyber.inneractive.sdk.player.exoplayer2.util.u;
import com.google.android.gms.games.GamesStatusCodes;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Locale;
import java.util.UUID;
import kotlin.jvm.internal.ByteCompanionObject;

public final class d implements f {
    public static final byte[] Z = {49, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, 45, 45, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};
    public static final byte[] a0 = {32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32};
    public static final UUID b0 = new UUID(72057594037932032L, -9223371306706625679L);
    public long A = -9223372036854775807L;
    public com.fyber.inneractive.sdk.player.exoplayer2.util.f B;
    public com.fyber.inneractive.sdk.player.exoplayer2.util.f C;
    public boolean D;
    public int E;
    public long F;
    public long G;
    public int H;
    public int I;
    public int[] J;
    public int K;
    public int L;
    public int M;
    public int N;
    public boolean O;
    public boolean P;
    public boolean Q;
    public boolean R;
    public byte S;
    public int T;
    public int U;
    public int V;
    public boolean W;
    public boolean X;
    public h Y;
    public final b a;
    public final f b;
    public final SparseArray<c> c;
    public final boolean d;
    public final k e;
    public final k f;
    public final k g;
    public final k h;
    public final k i;
    public final k j;
    public final k k;
    public final k l;
    public final k m;
    public ByteBuffer n;
    public long o;
    public long p = -1;
    public long q = -9223372036854775807L;
    public long r = -9223372036854775807L;
    public long s = -9223372036854775807L;
    public c t;
    public boolean u;
    public int v;
    public long w;
    public boolean x;
    public long y = -1;
    public long z = -1;

    public class a implements i {
    }

    public final class b implements c {
        public b() {
        }

        public boolean a(int i) {
            d.this.getClass();
            return i == 357149030 || i == 524531317 || i == 475249515 || i == 374648427;
        }

        public /* synthetic */ b(d dVar, a aVar) {
            this();
        }

        public void a(int i, long j, long j2) throws l {
            d dVar = d.this;
            dVar.getClass();
            if (i == 160) {
                dVar.X = false;
            } else if (i == 174) {
                dVar.t = new c();
            } else if (i == 187) {
                dVar.D = false;
            } else if (i == 19899) {
                dVar.v = -1;
                dVar.w = -1;
            } else if (i == 20533) {
                dVar.t.e = true;
            } else if (i == 21968) {
                dVar.t.q = true;
            } else if (i == 408125543) {
                long j3 = dVar.p;
                if (j3 == -1 || j3 == j) {
                    dVar.p = j;
                    dVar.o = j2;
                    return;
                }
                throw new l("Multiple Segment elements not supported");
            } else if (i == 475249515) {
                dVar.B = new com.fyber.inneractive.sdk.player.exoplayer2.util.f(32);
                dVar.C = new com.fyber.inneractive.sdk.player.exoplayer2.util.f(32);
            } else if (i != 524531317 || dVar.u) {
            } else {
                if (!dVar.d || dVar.y == -1) {
                    dVar.Y.a(new m.a(dVar.s));
                    dVar.u = true;
                    return;
                }
                dVar.x = true;
            }
        }

        public void a(int i, long j) throws l {
            d dVar = d.this;
            dVar.getClass();
            if (i != 20529) {
                if (i != 20530) {
                    boolean z = false;
                    switch (i) {
                        case 131:
                            dVar.t.c = (int) j;
                            return;
                        case 136:
                            c cVar = dVar.t;
                            if (j == 1) {
                                z = true;
                            }
                            cVar.L = z;
                            return;
                        case 155:
                            dVar.G = dVar.a(j);
                            return;
                        case 159:
                            dVar.t.G = (int) j;
                            return;
                        case 176:
                            dVar.t.j = (int) j;
                            return;
                        case 179:
                            dVar.B.a(dVar.a(j));
                            return;
                        case 186:
                            dVar.t.k = (int) j;
                            return;
                        case 215:
                            dVar.t.b = (int) j;
                            return;
                        case 231:
                            dVar.A = dVar.a(j);
                            return;
                        case 241:
                            if (!dVar.D) {
                                dVar.C.a(j);
                                dVar.D = true;
                                return;
                            }
                            return;
                        case 251:
                            dVar.X = true;
                            return;
                        case 16980:
                            if (j != 3) {
                                throw new l("ContentCompAlgo " + j + " not supported");
                            }
                            return;
                        case 17029:
                            if (j < 1 || j > 2) {
                                throw new l("DocTypeReadVersion " + j + " not supported");
                            }
                            return;
                        case 17143:
                            if (j != 1) {
                                throw new l("EBMLReadVersion " + j + " not supported");
                            }
                            return;
                        case 18401:
                            if (j != 5) {
                                throw new l("ContentEncAlgo " + j + " not supported");
                            }
                            return;
                        case 18408:
                            if (j != 1) {
                                throw new l("AESSettingsCipherMode " + j + " not supported");
                            }
                            return;
                        case 21420:
                            dVar.w = j + dVar.p;
                            return;
                        case 21432:
                            int i2 = (int) j;
                            if (i2 == 0) {
                                dVar.t.p = 0;
                                return;
                            } else if (i2 == 1) {
                                dVar.t.p = 2;
                                return;
                            } else if (i2 == 3) {
                                dVar.t.p = 1;
                                return;
                            } else if (i2 == 15) {
                                dVar.t.p = 3;
                                return;
                            } else {
                                return;
                            }
                        case 21680:
                            dVar.t.l = (int) j;
                            return;
                        case 21682:
                            dVar.t.n = (int) j;
                            return;
                        case 21690:
                            dVar.t.m = (int) j;
                            return;
                        case 21930:
                            c cVar2 = dVar.t;
                            if (j == 1) {
                                z = true;
                            }
                            cVar2.M = z;
                            return;
                        case 22186:
                            dVar.t.J = j;
                            return;
                        case 22203:
                            dVar.t.K = j;
                            return;
                        case 25188:
                            dVar.t.H = (int) j;
                            return;
                        case 2352003:
                            dVar.t.d = (int) j;
                            return;
                        case 2807729:
                            dVar.q = j;
                            return;
                        default:
                            switch (i) {
                                case 21945:
                                    int i3 = (int) j;
                                    if (i3 == 1) {
                                        dVar.t.t = 2;
                                        return;
                                    } else if (i3 == 2) {
                                        dVar.t.t = 1;
                                        return;
                                    } else {
                                        return;
                                    }
                                case 21946:
                                    int i4 = (int) j;
                                    if (i4 != 1) {
                                        if (i4 == 16) {
                                            dVar.t.s = 6;
                                            return;
                                        } else if (i4 == 18) {
                                            dVar.t.s = 7;
                                            return;
                                        } else if (!(i4 == 6 || i4 == 7)) {
                                            return;
                                        }
                                    }
                                    dVar.t.s = 3;
                                    return;
                                case 21947:
                                    c cVar3 = dVar.t;
                                    cVar3.q = true;
                                    int i5 = (int) j;
                                    if (i5 == 1) {
                                        cVar3.r = 1;
                                        return;
                                    } else if (i5 == 9) {
                                        cVar3.r = 6;
                                        return;
                                    } else if (i5 == 4 || i5 == 5 || i5 == 6 || i5 == 7) {
                                        cVar3.r = 2;
                                        return;
                                    } else {
                                        return;
                                    }
                                case 21948:
                                    dVar.t.u = (int) j;
                                    return;
                                case 21949:
                                    dVar.t.v = (int) j;
                                    return;
                                default:
                                    return;
                            }
                    }
                } else if (j != 1) {
                    throw new l("ContentEncodingScope " + j + " not supported");
                }
            } else if (j != 0) {
                throw new l("ContentEncodingOrder " + j + " not supported");
            }
        }

        public void a(int i, double d) throws l {
            d dVar = d.this;
            dVar.getClass();
            if (i == 181) {
                dVar.t.I = (int) d;
            } else if (i != 17545) {
                switch (i) {
                    case 21969:
                        dVar.t.w = (float) d;
                        return;
                    case 21970:
                        dVar.t.x = (float) d;
                        return;
                    case 21971:
                        dVar.t.y = (float) d;
                        return;
                    case 21972:
                        dVar.t.z = (float) d;
                        return;
                    case 21973:
                        dVar.t.A = (float) d;
                        return;
                    case 21974:
                        dVar.t.B = (float) d;
                        return;
                    case 21975:
                        dVar.t.C = (float) d;
                        return;
                    case 21976:
                        dVar.t.D = (float) d;
                        return;
                    case 21977:
                        dVar.t.E = (float) d;
                        return;
                    case 21978:
                        dVar.t.F = (float) d;
                        return;
                    default:
                        return;
                }
            } else {
                dVar.r = (long) d;
            }
        }

        public void a(int i, String str) throws l {
            d dVar = d.this;
            dVar.getClass();
            if (i == 134) {
                dVar.t.a = str;
            } else if (i != 17026) {
                if (i == 2274716) {
                    dVar.t.N = str;
                }
            } else if (!"webm".equals(str) && !"matroska".equals(str)) {
                throw new l("DocType " + str + " not supported");
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:71:0x01f3, code lost:
            throw new com.fyber.inneractive.sdk.player.exoplayer2.l("EBML lacing sample size out of range.");
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void a(int r21, int r22, com.fyber.inneractive.sdk.player.exoplayer2.extractor.g r23) throws java.io.IOException, java.lang.InterruptedException {
            /*
                r20 = this;
                r0 = r21
                r1 = r22
                r2 = r20
                r3 = r23
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.mkv.d r4 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mkv.d.this
                r4.getClass()
                r5 = 161(0xa1, float:2.26E-43)
                r6 = 163(0xa3, float:2.28E-43)
                r7 = 0
                if (r0 == r5) goto L_0x0098
                if (r0 == r6) goto L_0x0098
                r5 = 16981(0x4255, float:2.3795E-41)
                if (r0 == r5) goto L_0x008a
                r5 = 18402(0x47e2, float:2.5787E-41)
                if (r0 == r5) goto L_0x007c
                r5 = 21419(0x53ab, float:3.0014E-41)
                if (r0 == r5) goto L_0x005a
                r5 = 25506(0x63a2, float:3.5742E-41)
                if (r0 == r5) goto L_0x004c
                r5 = 30322(0x7672, float:4.249E-41)
                if (r0 != r5) goto L_0x0038
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.mkv.d$c r0 = r4.t
                byte[] r4 = new byte[r1]
                r0.o = r4
                r0 = r3
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.b r0 = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) r0
                r0.b(r4, r7, r1, r7)
                goto L_0x029d
            L_0x0038:
                com.fyber.inneractive.sdk.player.exoplayer2.l r1 = new com.fyber.inneractive.sdk.player.exoplayer2.l
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                java.lang.String r4 = "Unexpected id: "
                r3.<init>(r4)
                r3.append(r0)
                java.lang.String r0 = r3.toString()
                r1.<init>((java.lang.String) r0)
                throw r1
            L_0x004c:
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.mkv.d$c r0 = r4.t
                byte[] r4 = new byte[r1]
                r0.h = r4
                r0 = r3
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.b r0 = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) r0
                r0.b(r4, r7, r1, r7)
                goto L_0x029d
            L_0x005a:
                com.fyber.inneractive.sdk.player.exoplayer2.util.k r0 = r4.i
                byte[] r0 = r0.a
                java.util.Arrays.fill(r0, r7)
                com.fyber.inneractive.sdk.player.exoplayer2.util.k r0 = r4.i
                byte[] r0 = r0.a
                int r5 = 4 - r1
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.b r3 = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) r3
                r3.b(r0, r5, r1, r7)
                com.fyber.inneractive.sdk.player.exoplayer2.util.k r0 = r4.i
                r0.e(r7)
                com.fyber.inneractive.sdk.player.exoplayer2.util.k r0 = r4.i
                long r0 = r0.m()
                int r1 = (int) r0
                r4.v = r1
                goto L_0x029d
            L_0x007c:
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.mkv.d$c r0 = r4.t
                byte[] r4 = new byte[r1]
                r0.g = r4
                r0 = r3
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.b r0 = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) r0
                r0.b(r4, r7, r1, r7)
                goto L_0x029d
            L_0x008a:
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.mkv.d$c r0 = r4.t
                byte[] r4 = new byte[r1]
                r0.f = r4
                r0 = r3
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.b r0 = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) r0
                r0.b(r4, r7, r1, r7)
                goto L_0x029d
            L_0x0098:
                int r5 = r4.E
                r8 = 8
                r9 = 1
                if (r5 != 0) goto L_0x00bc
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.mkv.f r5 = r4.b
                long r10 = r5.a(r3, r7, r9, r8)
                int r5 = (int) r10
                r4.K = r5
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.mkv.f r5 = r4.b
                int r5 = r5.c
                r4.L = r5
                r10 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
                r4.G = r10
                r4.E = r9
                com.fyber.inneractive.sdk.player.exoplayer2.util.k r5 = r4.g
                r5.r()
            L_0x00bc:
                android.util.SparseArray<com.fyber.inneractive.sdk.player.exoplayer2.extractor.mkv.d$c> r5 = r4.c
                int r10 = r4.K
                java.lang.Object r5 = r5.get(r10)
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.mkv.d$c r5 = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.mkv.d.c) r5
                if (r5 != 0) goto L_0x00d6
                int r0 = r4.L
                int r0 = r1 - r0
                r1 = r3
                com.fyber.inneractive.sdk.player.exoplayer2.extractor.b r1 = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) r1
                r1.c(r0)
                r4.E = r7
                goto L_0x029d
            L_0x00d6:
                int r10 = r4.E
                if (r10 != r9) goto L_0x026c
                r10 = 3
                r4.a((com.fyber.inneractive.sdk.player.exoplayer2.extractor.g) r3, (int) r10)
                com.fyber.inneractive.sdk.player.exoplayer2.util.k r11 = r4.g
                byte[] r11 = r11.a
                r12 = 2
                byte r11 = r11[r12]
                r11 = r11 & 6
                int r11 = r11 >> r9
                r13 = 255(0xff, float:3.57E-43)
                if (r11 != 0) goto L_0x00fe
                r4.I = r9
                int[] r11 = r4.J
                int[] r11 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mkv.d.a((int[]) r11, (int) r9)
                r4.J = r11
                int r14 = r4.L
                int r1 = r1 - r14
                int r1 = r1 - r10
                r11[r7] = r1
                goto L_0x0205
            L_0x00fe:
                if (r0 != r6) goto L_0x0264
                r14 = 4
                r4.a((com.fyber.inneractive.sdk.player.exoplayer2.extractor.g) r3, (int) r14)
                com.fyber.inneractive.sdk.player.exoplayer2.util.k r15 = r4.g
                byte[] r15 = r15.a
                byte r15 = r15[r10]
                r15 = r15 & r13
                int r15 = r15 + r9
                r4.I = r15
                int[] r6 = r4.J
                int[] r6 = com.fyber.inneractive.sdk.player.exoplayer2.extractor.mkv.d.a((int[]) r6, (int) r15)
                r4.J = r6
                if (r11 != r12) goto L_0x0124
                int r10 = r4.L
                int r1 = r1 - r10
                int r1 = r1 - r14
                int r10 = r4.I
                int r1 = r1 / r10
                java.util.Arrays.fill(r6, r7, r10, r1)
                goto L_0x0205
            L_0x0124:
                if (r11 != r9) goto L_0x015a
                r6 = 0
                r10 = 0
            L_0x0128:
                int r11 = r4.I
                int r11 = r11 - r9
                if (r6 >= r11) goto L_0x014f
                int[] r11 = r4.J
                r11[r6] = r7
            L_0x0131:
                int r11 = r14 + 1
                r4.a((com.fyber.inneractive.sdk.player.exoplayer2.extractor.g) r3, (int) r11)
                com.fyber.inneractive.sdk.player.exoplayer2.util.k r15 = r4.g
                byte[] r15 = r15.a
                byte r14 = r15[r14]
                r14 = r14 & r13
                int[] r15 = r4.J
                r16 = r15[r6]
                int r16 = r16 + r14
                r15[r6] = r16
                if (r14 == r13) goto L_0x014d
                int r10 = r10 + r16
                int r6 = r6 + 1
                r14 = r11
                goto L_0x0128
            L_0x014d:
                r14 = r11
                goto L_0x0131
            L_0x014f:
                int[] r6 = r4.J
                int r15 = r4.L
                int r1 = r1 - r15
                int r1 = r1 - r14
                int r1 = r1 - r10
                r6[r11] = r1
                goto L_0x0205
            L_0x015a:
                if (r11 != r10) goto L_0x0250
                r6 = 0
                r10 = 0
            L_0x015e:
                int r11 = r4.I
                int r11 = r11 - r9
                if (r6 >= r11) goto L_0x01fc
                int[] r11 = r4.J
                r11[r6] = r7
                int r11 = r14 + 1
                r4.a((com.fyber.inneractive.sdk.player.exoplayer2.extractor.g) r3, (int) r11)
                com.fyber.inneractive.sdk.player.exoplayer2.util.k r15 = r4.g
                byte[] r15 = r15.a
                byte r15 = r15[r14]
                if (r15 == 0) goto L_0x01f4
                r15 = 0
            L_0x0175:
                if (r15 >= r8) goto L_0x01c3
                int r16 = 7 - r15
                int r12 = r9 << r16
                com.fyber.inneractive.sdk.player.exoplayer2.util.k r9 = r4.g
                byte[] r9 = r9.a
                byte r9 = r9[r14]
                r9 = r9 & r12
                if (r9 == 0) goto L_0x01ba
                int r11 = r11 + r15
                r4.a((com.fyber.inneractive.sdk.player.exoplayer2.extractor.g) r3, (int) r11)
                com.fyber.inneractive.sdk.player.exoplayer2.util.k r9 = r4.g
                byte[] r9 = r9.a
                int r17 = r14 + 1
                byte r9 = r9[r14]
                r9 = r9 & r13
                int r12 = ~r12
                r9 = r9 & r12
                long r13 = (long) r9
                r9 = r17
            L_0x0196:
                if (r9 >= r11) goto L_0x01ab
                long r13 = r13 << r8
                com.fyber.inneractive.sdk.player.exoplayer2.util.k r12 = r4.g
                byte[] r12 = r12.a
                int r18 = r9 + 1
                byte r9 = r12[r9]
                r12 = 255(0xff, float:3.57E-43)
                r9 = r9 & r12
                long r8 = (long) r9
                long r13 = r13 | r8
                r9 = r18
                r8 = 8
                goto L_0x0196
            L_0x01ab:
                if (r6 <= 0) goto L_0x01c5
                int r15 = r15 * 7
                int r15 = r15 + 6
                r8 = 1
                long r18 = r8 << r15
                long r18 = r18 - r8
                long r13 = r13 - r18
                goto L_0x01c5
            L_0x01ba:
                int r15 = r15 + 1
                r8 = 8
                r9 = 1
                r12 = 2
                r13 = 255(0xff, float:3.57E-43)
                goto L_0x0175
            L_0x01c3:
                r13 = 0
            L_0x01c5:
                r8 = -2147483648(0xffffffff80000000, double:NaN)
                int r15 = (r13 > r8 ? 1 : (r13 == r8 ? 0 : -1))
                if (r15 < 0) goto L_0x01ec
                r8 = 2147483647(0x7fffffff, double:1.060997895E-314)
                int r15 = (r13 > r8 ? 1 : (r13 == r8 ? 0 : -1))
                if (r15 > 0) goto L_0x01ec
                int r8 = (int) r13
                int[] r9 = r4.J
                if (r6 != 0) goto L_0x01d9
                goto L_0x01de
            L_0x01d9:
                int r13 = r6 + -1
                r13 = r9[r13]
                int r8 = r8 + r13
            L_0x01de:
                r9[r6] = r8
                int r10 = r10 + r8
                int r6 = r6 + 1
                r14 = r11
                r8 = 8
                r9 = 1
                r12 = 2
                r13 = 255(0xff, float:3.57E-43)
                goto L_0x015e
            L_0x01ec:
                com.fyber.inneractive.sdk.player.exoplayer2.l r0 = new com.fyber.inneractive.sdk.player.exoplayer2.l
                java.lang.String r1 = "EBML lacing sample size out of range."
                r0.<init>((java.lang.String) r1)
                throw r0
            L_0x01f4:
                com.fyber.inneractive.sdk.player.exoplayer2.l r0 = new com.fyber.inneractive.sdk.player.exoplayer2.l
                java.lang.String r1 = "No valid varint length mask found"
                r0.<init>((java.lang.String) r1)
                throw r0
            L_0x01fc:
                int[] r6 = r4.J
                int r8 = r4.L
                int r1 = r1 - r8
                int r1 = r1 - r14
                int r1 = r1 - r10
                r6[r11] = r1
            L_0x0205:
                com.fyber.inneractive.sdk.player.exoplayer2.util.k r1 = r4.g
                byte[] r1 = r1.a
                byte r6 = r1[r7]
                r8 = 8
                int r6 = r6 << r8
                r8 = 1
                byte r1 = r1[r8]
                r8 = 255(0xff, float:3.57E-43)
                r1 = r1 & r8
                r1 = r1 | r6
                long r8 = r4.A
                long r10 = (long) r1
                long r10 = r4.a((long) r10)
                long r8 = r8 + r10
                r4.F = r8
                com.fyber.inneractive.sdk.player.exoplayer2.util.k r1 = r4.g
                byte[] r1 = r1.a
                r6 = 2
                byte r8 = r1[r6]
                r9 = 8
                r8 = r8 & r9
                if (r8 != r9) goto L_0x022d
                r8 = 1
                goto L_0x022e
            L_0x022d:
                r8 = 0
            L_0x022e:
                int r9 = r5.c
                if (r9 == r6) goto L_0x0240
                r9 = 163(0xa3, float:2.28E-43)
                if (r0 != r9) goto L_0x023e
                byte r1 = r1[r6]
                r6 = 128(0x80, float:1.794E-43)
                r1 = r1 & r6
                if (r1 != r6) goto L_0x023e
                goto L_0x0240
            L_0x023e:
                r1 = 0
                goto L_0x0241
            L_0x0240:
                r1 = 1
            L_0x0241:
                if (r8 == 0) goto L_0x0246
                r6 = -2147483648(0xffffffff80000000, float:-0.0)
                goto L_0x0247
            L_0x0246:
                r6 = 0
            L_0x0247:
                r1 = r1 | r6
                r4.M = r1
                r1 = 2
                r4.E = r1
                r4.H = r7
                goto L_0x026c
            L_0x0250:
                com.fyber.inneractive.sdk.player.exoplayer2.l r0 = new com.fyber.inneractive.sdk.player.exoplayer2.l
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                java.lang.String r3 = "Unexpected lacing value: "
                r1.<init>(r3)
                r1.append(r11)
                java.lang.String r1 = r1.toString()
                r0.<init>((java.lang.String) r1)
                throw r0
            L_0x0264:
                com.fyber.inneractive.sdk.player.exoplayer2.l r0 = new com.fyber.inneractive.sdk.player.exoplayer2.l
                java.lang.String r1 = "Lacing only supported in SimpleBlocks."
                r0.<init>((java.lang.String) r1)
                throw r0
            L_0x026c:
                r1 = 163(0xa3, float:2.28E-43)
                if (r0 != r1) goto L_0x0296
            L_0x0270:
                int r0 = r4.H
                int r1 = r4.I
                if (r0 >= r1) goto L_0x0293
                int[] r1 = r4.J
                r0 = r1[r0]
                r4.a((com.fyber.inneractive.sdk.player.exoplayer2.extractor.g) r3, (com.fyber.inneractive.sdk.player.exoplayer2.extractor.mkv.d.c) r5, (int) r0)
                long r0 = r4.F
                int r6 = r4.H
                int r8 = r5.d
                int r6 = r6 * r8
                int r6 = r6 / 1000
                long r8 = (long) r6
                long r0 = r0 + r8
                r4.a((com.fyber.inneractive.sdk.player.exoplayer2.extractor.mkv.d.c) r5, (long) r0)
                int r0 = r4.H
                r1 = 1
                int r0 = r0 + r1
                r4.H = r0
                goto L_0x0270
            L_0x0293:
                r4.E = r7
                goto L_0x029d
            L_0x0296:
                int[] r0 = r4.J
                r0 = r0[r7]
                r4.a((com.fyber.inneractive.sdk.player.exoplayer2.extractor.g) r3, (com.fyber.inneractive.sdk.player.exoplayer2.extractor.mkv.d.c) r5, (int) r0)
            L_0x029d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.exoplayer2.extractor.mkv.d.b.a(int, int, com.fyber.inneractive.sdk.player.exoplayer2.extractor.g):void");
        }
    }

    public static final class c {
        public float A = -1.0f;
        public float B = -1.0f;
        public float C = -1.0f;
        public float D = -1.0f;
        public float E = -1.0f;
        public float F = -1.0f;
        public int G = 1;
        public int H = -1;
        public int I = GamesStatusCodes.STATUS_MILESTONE_CLAIMED_PREVIOUSLY;
        public long J = 0;
        public long K = 0;
        public boolean L;
        public boolean M = true;
        public String N = "eng";
        public n O;
        public int P;
        public String a;
        public int b;
        public int c;
        public int d;
        public boolean e;
        public byte[] f;
        public byte[] g;
        public byte[] h;
        public com.fyber.inneractive.sdk.player.exoplayer2.drm.a i;
        public int j = -1;
        public int k = -1;
        public int l = -1;
        public int m = -1;
        public int n = 0;
        public byte[] o = null;
        public int p = -1;
        public boolean q = false;
        public int r = -1;
        public int s = -1;
        public int t = -1;
        public int u = 1000;
        public int v = Scheduler.MAX_GREEDY_SCHEDULER_LIMIT;
        public float w = -1.0f;
        public float x = -1.0f;
        public float y = -1.0f;
        public float z = -1.0f;
    }

    public d(b bVar, int i2) {
        this.a = bVar;
        ((a) bVar).a((c) new b(this, (a) null));
        this.d = (i2 & 1) != 0 ? false : true;
        this.b = new f();
        this.c = new SparseArray<>();
        this.g = new k(4);
        this.h = new k(ByteBuffer.allocate(4).putInt(-1).array());
        this.i = new k(4);
        this.e = new k(com.fyber.inneractive.sdk.player.exoplayer2.util.i.a);
        this.f = new k(4);
        this.j = new k();
        this.k = new k();
        this.l = new k(8);
        this.m = new k();
    }

    public void a(h hVar) {
        this.Y = hVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x007c, code lost:
        r3 = r1.a(r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.g r18) throws java.io.IOException, java.lang.InterruptedException {
        /*
            r17 = this;
            r0 = r18
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.mkv.e r1 = new com.fyber.inneractive.sdk.player.exoplayer2.extractor.mkv.e
            r1.<init>()
            r2 = r0
            com.fyber.inneractive.sdk.player.exoplayer2.extractor.b r2 = (com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) r2
            long r3 = r2.b
            r5 = -1
            r7 = 1024(0x400, double:5.06E-321)
            int r9 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r9 == 0) goto L_0x001a
            int r5 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r5 <= 0) goto L_0x0019
            goto L_0x001a
        L_0x0019:
            r7 = r3
        L_0x001a:
            int r5 = (int) r7
            com.fyber.inneractive.sdk.player.exoplayer2.util.k r6 = r1.a
            byte[] r6 = r6.a
            r7 = 0
            r8 = 4
            r2.a(r6, r7, r8, r7)
            com.fyber.inneractive.sdk.player.exoplayer2.util.k r6 = r1.a
            long r10 = r6.m()
            r1.b = r8
        L_0x002c:
            r12 = 440786851(0x1a45dfa3, double:2.1777764E-315)
            r6 = 1
            int r8 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r8 == 0) goto L_0x0054
            int r8 = r1.b
            int r8 = r8 + r6
            r1.b = r8
            if (r8 != r5) goto L_0x003c
            goto L_0x009f
        L_0x003c:
            com.fyber.inneractive.sdk.player.exoplayer2.util.k r8 = r1.a
            byte[] r8 = r8.a
            r2.a(r8, r7, r6, r7)
            r6 = 8
            long r10 = r10 << r6
            r12 = -256(0xffffffffffffff00, double:NaN)
            long r10 = r10 & r12
            com.fyber.inneractive.sdk.player.exoplayer2.util.k r6 = r1.a
            byte[] r6 = r6.a
            byte r6 = r6[r7]
            r6 = r6 & 255(0xff, float:3.57E-43)
            long r12 = (long) r6
            long r10 = r10 | r12
            goto L_0x002c
        L_0x0054:
            long r10 = r1.a(r0)
            int r5 = r1.b
            long r12 = (long) r5
            r14 = -9223372036854775808
            int r5 = (r10 > r14 ? 1 : (r10 == r14 ? 0 : -1))
            if (r5 == 0) goto L_0x009f
            if (r9 == 0) goto L_0x006a
            long r8 = r12 + r10
            int r5 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r5 < 0) goto L_0x006a
            goto L_0x009f
        L_0x006a:
            int r3 = r1.b
            long r3 = (long) r3
            long r8 = r12 + r10
            int r5 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r5 >= 0) goto L_0x009c
            long r3 = r1.a(r0)
            int r5 = (r3 > r14 ? 1 : (r3 == r14 ? 0 : -1))
            if (r5 != 0) goto L_0x007c
            goto L_0x009f
        L_0x007c:
            long r3 = r1.a(r0)
            r8 = 0
            int r5 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r5 < 0) goto L_0x009f
            r8 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r16 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r16 <= 0) goto L_0x008e
            goto L_0x009f
        L_0x008e:
            if (r5 == 0) goto L_0x006a
            int r5 = (int) r3
            r2.a(r5, r7)
            int r5 = r1.b
            long r8 = (long) r5
            long r8 = r8 + r3
            int r3 = (int) r8
            r1.b = r3
            goto L_0x006a
        L_0x009c:
            if (r5 != 0) goto L_0x009f
            r7 = 1
        L_0x009f:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.exoplayer2.extractor.mkv.d.a(com.fyber.inneractive.sdk.player.exoplayer2.extractor.g):boolean");
    }

    public void b() {
    }

    public void a(long j2, long j3) {
        this.A = -9223372036854775807L;
        this.E = 0;
        a aVar = (a) this.a;
        aVar.e = 0;
        aVar.b.clear();
        f fVar = aVar.c;
        fVar.b = 0;
        fVar.c = 0;
        f fVar2 = this.b;
        fVar2.b = 0;
        fVar2.c = 0;
        a();
    }

    public int a(g gVar, com.fyber.inneractive.sdk.player.exoplayer2.extractor.l lVar) throws IOException, InterruptedException {
        this.W = false;
        boolean z2 = true;
        while (z2 && !this.W) {
            z2 = ((a) this.a).a(gVar);
            if (z2) {
                long j2 = ((com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) gVar).c;
                if (this.x) {
                    this.z = j2;
                    lVar.a = this.y;
                    this.x = false;
                } else if (this.u) {
                    long j3 = this.z;
                    if (j3 != -1) {
                        lVar.a = j3;
                        this.z = -1;
                    }
                } else {
                    continue;
                }
                return 1;
            }
        }
        if (z2) {
            return 0;
        }
        return -1;
    }

    public final void a(c cVar, long j2) {
        byte[] bArr;
        if ("S_TEXT/UTF8".equals(cVar.a)) {
            byte[] bArr2 = this.k.a;
            long j3 = this.G;
            if (j3 == -9223372036854775807L) {
                bArr = a0;
            } else {
                int i2 = (int) (j3 / 3600000000L);
                long j4 = j3 - (((long) i2) * 3600000000L);
                int i3 = (int) (j4 / 60000000);
                long j5 = j4 - ((long) (60000000 * i3));
                int i4 = (int) (j5 / 1000000);
                String format = String.format(Locale.US, "%02d:%02d:%02d,%03d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf((int) ((j5 - ((long) (1000000 * i4))) / 1000))});
                int i5 = u.a;
                bArr = format.getBytes(Charset.defaultCharset());
            }
            System.arraycopy(bArr, 0, bArr2, 19, 12);
            n nVar = cVar.O;
            k kVar = this.k;
            nVar.a(kVar, kVar.c);
            this.V += this.k.c;
        }
        cVar.O.a(j2, this.M, this.V, 0, cVar.g);
        this.W = true;
        a();
    }

    public final void a() {
        this.N = 0;
        this.V = 0;
        this.U = 0;
        this.O = false;
        this.P = false;
        this.R = false;
        this.T = 0;
        this.S = 0;
        this.Q = false;
        this.j.r();
    }

    public final void a(g gVar, int i2) throws IOException, InterruptedException {
        k kVar = this.g;
        if (kVar.c < i2) {
            if (kVar.b() < i2) {
                k kVar2 = this.g;
                byte[] bArr = kVar2.a;
                kVar2.a(Arrays.copyOf(bArr, Math.max(bArr.length * 2, i2)), this.g.c);
            }
            k kVar3 = this.g;
            byte[] bArr2 = kVar3.a;
            int i3 = kVar3.c;
            ((com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) gVar).b(bArr2, i3, i2 - i3, false);
            this.g.d(i2);
        }
    }

    public final void a(g gVar, c cVar, int i2) throws IOException, InterruptedException {
        int i3;
        if ("S_TEXT/UTF8".equals(cVar.a)) {
            byte[] bArr = Z;
            int length = bArr.length + i2;
            if (this.k.b() < length) {
                this.k.a = Arrays.copyOf(bArr, length + i2);
            }
            ((com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) gVar).b(this.k.a, bArr.length, i2, false);
            this.k.e(0);
            this.k.d(length);
            return;
        }
        n nVar = cVar.O;
        if (!this.O) {
            if (cVar.e) {
                this.M &= -1073741825;
                int i4 = 128;
                if (!this.P) {
                    ((com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) gVar).b(this.g.a, 0, 1, false);
                    this.N++;
                    byte b2 = this.g.a[0];
                    if ((b2 & ByteCompanionObject.MIN_VALUE) != 128) {
                        this.S = b2;
                        this.P = true;
                    } else {
                        throw new l("Extension bit is set in signal byte");
                    }
                }
                byte b3 = this.S;
                if ((b3 & 1) == 1) {
                    boolean z2 = (b3 & 2) == 2;
                    this.M |= 1073741824;
                    if (!this.Q) {
                        ((com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) gVar).b(this.l.a, 0, 8, false);
                        this.N += 8;
                        this.Q = true;
                        k kVar = this.g;
                        byte[] bArr2 = kVar.a;
                        if (!z2) {
                            i4 = 0;
                        }
                        bArr2[0] = (byte) (i4 | 8);
                        kVar.e(0);
                        nVar.a(this.g, 1);
                        this.V++;
                        this.l.e(0);
                        nVar.a(this.l, 8);
                        this.V += 8;
                    }
                    if (z2) {
                        if (!this.R) {
                            ((com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) gVar).b(this.g.a, 0, 1, false);
                            this.N++;
                            this.g.e(0);
                            this.T = this.g.l();
                            this.R = true;
                        }
                        int i5 = this.T * 4;
                        this.g.c(i5);
                        ((com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) gVar).b(this.g.a, 0, i5, false);
                        this.N += i5;
                        short s2 = (short) ((this.T / 2) + 1);
                        int i6 = (s2 * 6) + 2;
                        ByteBuffer byteBuffer = this.n;
                        if (byteBuffer == null || byteBuffer.capacity() < i6) {
                            this.n = ByteBuffer.allocate(i6);
                        }
                        this.n.position(0);
                        this.n.putShort(s2);
                        int i7 = 0;
                        int i8 = 0;
                        while (true) {
                            i3 = this.T;
                            if (i7 >= i3) {
                                break;
                            }
                            int o2 = this.g.o();
                            if (i7 % 2 == 0) {
                                this.n.putShort((short) (o2 - i8));
                            } else {
                                this.n.putInt(o2 - i8);
                            }
                            i7++;
                            i8 = o2;
                        }
                        int i9 = (i2 - this.N) - i8;
                        if (i3 % 2 == 1) {
                            this.n.putInt(i9);
                        } else {
                            this.n.putShort((short) i9);
                            this.n.putInt(0);
                        }
                        this.m.a(this.n.array(), i6);
                        nVar.a(this.m, i6);
                        this.V += i6;
                    }
                }
            } else {
                byte[] bArr3 = cVar.f;
                if (bArr3 != null) {
                    k kVar2 = this.j;
                    int length2 = bArr3.length;
                    kVar2.a = bArr3;
                    kVar2.c = length2;
                    kVar2.b = 0;
                }
            }
            this.O = true;
        }
        int i10 = i2 + this.j.c;
        if (!"V_MPEG4/ISO/AVC".equals(cVar.a) && !"V_MPEGH/ISO/HEVC".equals(cVar.a)) {
            while (true) {
                int i11 = this.N;
                if (i11 >= i10) {
                    break;
                }
                a(gVar, nVar, i10 - i11);
            }
        } else {
            byte[] bArr4 = this.f.a;
            bArr4[0] = 0;
            bArr4[1] = 0;
            bArr4[2] = 0;
            int i12 = cVar.P;
            int i13 = 4 - i12;
            while (this.N < i10) {
                int i14 = this.U;
                if (i14 == 0) {
                    int min = Math.min(i12, this.j.a());
                    ((com.fyber.inneractive.sdk.player.exoplayer2.extractor.b) gVar).b(bArr4, i13 + min, i12 - min, false);
                    if (min > 0) {
                        k kVar3 = this.j;
                        System.arraycopy(kVar3.a, kVar3.b, bArr4, i13, min);
                        kVar3.b += min;
                    }
                    this.N += i12;
                    this.f.e(0);
                    this.U = this.f.o();
                    this.e.e(0);
                    nVar.a(this.e, 4);
                    this.V += 4;
                } else {
                    this.U = i14 - a(gVar, nVar, i14);
                }
            }
        }
        if ("A_VORBIS".equals(cVar.a)) {
            this.h.e(0);
            nVar.a(this.h, 4);
            this.V += 4;
        }
    }

    public final int a(g gVar, n nVar, int i2) throws IOException, InterruptedException {
        int i3;
        int a2 = this.j.a();
        if (a2 > 0) {
            i3 = Math.min(i2, a2);
            nVar.a(this.j, i3);
        } else {
            i3 = nVar.a(gVar, i2, false);
        }
        this.N += i3;
        this.V += i3;
        return i3;
    }

    public final long a(long j2) throws l {
        long j3 = this.q;
        if (j3 != -9223372036854775807L) {
            return u.a(j2, j3, 1000);
        }
        throw new l("Can't scale timecode prior to timecodeScale being set.");
    }

    public static int[] a(int[] iArr, int i2) {
        if (iArr == null) {
            return new int[i2];
        }
        if (iArr.length >= i2) {
            return iArr;
        }
        return new int[Math.max(iArr.length * 2, i2)];
    }
}
