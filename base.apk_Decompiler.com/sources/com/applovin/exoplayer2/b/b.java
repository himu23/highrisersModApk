package com.applovin.exoplayer2.b;

import com.applovin.exoplayer2.d.e;
import com.applovin.exoplayer2.l.ai;
import com.applovin.exoplayer2.l.x;
import com.applovin.exoplayer2.l.y;
import com.applovin.exoplayer2.v;
import java.nio.ByteBuffer;
import kotlin.UByte;

public final class b {
    private static final int[] jt = {1, 2, 3, 6};
    private static final int[] ju = {48000, 44100, 32000};
    private static final int[] jv = {24000, 22050, 16000};
    private static final int[] jw = {2, 1, 2, 3, 3, 4, 4, 5};
    private static final int[] jx = {32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, 320, 384, 448, 512, 576, 640};
    private static final int[] jy = {69, 87, 104, 121, 139, 174, 208, 243, 278, 348, 417, 487, 557, 696, 835, 975, 1114, 1253, 1393};

    public static final class a {
        public final int dL;
        public final int dM;
        public final String eg;
        public final int ir;
        public final int jA;
        public final int jz;

        private a(String str, int i, int i2, int i3, int i4, int i5) {
            this.eg = str;
            this.ir = i;
            this.dL = i2;
            this.dM = i3;
            this.jz = i4;
            this.jA = i5;
        }
    }

    public static v a(y yVar, String str, String str2, e eVar) {
        int i = ju[(yVar.po() & 192) >> 6];
        int po = yVar.po();
        int i2 = jw[(po & 56) >> 3];
        if ((po & 4) != 0) {
            i2++;
        }
        return new v.a().g(str).m("audio/ac3").N(i2).O(i).a(eVar).j(str2).bT();
    }

    public static v b(y yVar, String str, String str2, e eVar) {
        yVar.fz(2);
        int i = ju[(yVar.po() & 192) >> 6];
        int po = yVar.po();
        int i2 = jw[(po & 14) >> 1];
        if ((po & 1) != 0) {
            i2++;
        }
        if (((yVar.po() & 30) >> 1) > 0 && (2 & yVar.po()) != 0) {
            i2 += 2;
        }
        return new v.a().g(str).m((yVar.pj() <= 0 || (yVar.po() & 1) == 0) ? "audio/eac3" : "audio/eac3-joc").N(i2).O(i).a(eVar).j(str2).bT();
    }

    public static a c(x xVar) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        String str;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        x xVar2 = xVar;
        int il = xVar.il();
        xVar2.bR(40);
        boolean z = xVar2.bQ(5) > 10;
        xVar2.fx(il);
        int i12 = -1;
        if (z) {
            xVar2.bR(16);
            int bQ = xVar2.bQ(2);
            if (bQ == 0) {
                i12 = 0;
            } else if (bQ == 1) {
                i12 = 1;
            } else if (bQ == 2) {
                i12 = 2;
            }
            xVar2.bR(3);
            int bQ2 = (xVar2.bQ(11) + 1) * 2;
            int bQ3 = xVar2.bQ(2);
            if (bQ3 == 3) {
                i6 = jv[xVar2.bQ(2)];
                i8 = 3;
                i7 = 6;
            } else {
                i8 = xVar2.bQ(2);
                i7 = jt[i8];
                i6 = ju[bQ3];
            }
            int i13 = i7 * 256;
            int bQ4 = xVar2.bQ(3);
            boolean ik = xVar.ik();
            int i14 = jw[bQ4] + (ik ? 1 : 0);
            xVar2.bR(10);
            if (xVar.ik()) {
                xVar2.bR(8);
            }
            if (bQ4 == 0) {
                xVar2.bR(5);
                if (xVar.ik()) {
                    xVar2.bR(8);
                }
            }
            if (i12 == 1 && xVar.ik()) {
                xVar2.bR(16);
            }
            if (xVar.ik()) {
                if (bQ4 > 2) {
                    xVar2.bR(2);
                }
                if ((bQ4 & 1) == 0 || bQ4 <= 2) {
                    i10 = 6;
                } else {
                    i10 = 6;
                    xVar2.bR(6);
                }
                if ((bQ4 & 4) != 0) {
                    xVar2.bR(i10);
                }
                if (ik && xVar.ik()) {
                    xVar2.bR(5);
                }
                if (i12 == 0) {
                    if (xVar.ik()) {
                        i11 = 6;
                        xVar2.bR(6);
                    } else {
                        i11 = 6;
                    }
                    if (bQ4 == 0 && xVar.ik()) {
                        xVar2.bR(i11);
                    }
                    if (xVar.ik()) {
                        xVar2.bR(i11);
                    }
                    int bQ5 = xVar2.bQ(2);
                    if (bQ5 == 1) {
                        xVar2.bR(5);
                    } else if (bQ5 == 2) {
                        xVar2.bR(12);
                    } else if (bQ5 == 3) {
                        int bQ6 = xVar2.bQ(5);
                        if (xVar.ik()) {
                            xVar2.bR(5);
                            if (xVar.ik()) {
                                xVar2.bR(4);
                            }
                            if (xVar.ik()) {
                                xVar2.bR(4);
                            }
                            if (xVar.ik()) {
                                xVar2.bR(4);
                            }
                            if (xVar.ik()) {
                                xVar2.bR(4);
                            }
                            if (xVar.ik()) {
                                xVar2.bR(4);
                            }
                            if (xVar.ik()) {
                                xVar2.bR(4);
                            }
                            if (xVar.ik()) {
                                xVar2.bR(4);
                            }
                            if (xVar.ik()) {
                                if (xVar.ik()) {
                                    xVar2.bR(4);
                                }
                                if (xVar.ik()) {
                                    xVar2.bR(4);
                                }
                            }
                        }
                        if (xVar.ik()) {
                            xVar2.bR(5);
                            if (xVar.ik()) {
                                xVar2.bR(7);
                                if (xVar.ik()) {
                                    xVar2.bR(8);
                                }
                            }
                        }
                        xVar2.bR((bQ6 + 2) * 8);
                        xVar.pi();
                    }
                    if (bQ4 < 2) {
                        if (xVar.ik()) {
                            xVar2.bR(14);
                        }
                        if (bQ4 == 0 && xVar.ik()) {
                            xVar2.bR(14);
                        }
                    }
                    if (xVar.ik()) {
                        if (i8 == 0) {
                            xVar2.bR(5);
                        } else {
                            for (int i15 = 0; i15 < i7; i15++) {
                                if (xVar.ik()) {
                                    xVar2.bR(5);
                                }
                            }
                        }
                    }
                }
            }
            if (xVar.ik()) {
                xVar2.bR(5);
                if (bQ4 == 2) {
                    xVar2.bR(4);
                }
                if (bQ4 >= 6) {
                    xVar2.bR(2);
                }
                if (xVar.ik()) {
                    xVar2.bR(8);
                }
                if (bQ4 == 0 && xVar.ik()) {
                    xVar2.bR(8);
                }
                if (bQ3 < 3) {
                    xVar.ph();
                }
            }
            if (i12 == 0 && i8 != 3) {
                xVar.ph();
            }
            if (i12 != 2 || (i8 != 3 && !xVar.ik())) {
                i9 = 6;
            } else {
                i9 = 6;
                xVar2.bR(6);
            }
            str = (xVar.ik() && xVar2.bQ(i9) == 1 && xVar2.bQ(8) == 1) ? "audio/eac3-joc" : "audio/eac3";
            i5 = i12;
            i = i13;
            i2 = bQ2;
            i3 = i6;
            i4 = i14;
        } else {
            xVar2.bR(32);
            int bQ7 = xVar2.bQ(2);
            String str2 = bQ7 == 3 ? null : "audio/ac3";
            int j = j(bQ7, xVar2.bQ(6));
            xVar2.bR(8);
            int bQ8 = xVar2.bQ(3);
            if (!((bQ8 & 1) == 0 || bQ8 == 1)) {
                xVar2.bR(2);
            }
            if ((bQ8 & 4) != 0) {
                xVar2.bR(2);
            }
            if (bQ8 == 2) {
                xVar2.bR(2);
            }
            int[] iArr = ju;
            str = str2;
            i2 = j;
            i3 = bQ7 < iArr.length ? iArr[bQ7] : -1;
            i4 = jw[bQ8] + (xVar.ik() ? 1 : 0);
            i5 = -1;
            i = 1536;
        }
        return new a(str, i5, i4, i3, i2, i);
    }

    public static int c(byte[] bArr) {
        if (bArr.length < 6) {
            return -1;
        }
        if (((bArr[5] & 248) >> 3) > 10) {
            return (((bArr[3] & UByte.MAX_VALUE) | ((bArr[2] & 7) << 8)) + 1) * 2;
        }
        byte b = bArr[4];
        return j((b & 192) >> 6, b & 63);
    }

    public static int a(ByteBuffer byteBuffer) {
        int i = 3;
        if (((byteBuffer.get(byteBuffer.position() + 5) & 248) >> 3) <= 10) {
            return 1536;
        }
        if (((byteBuffer.get(byteBuffer.position() + 4) & 192) >> 6) != 3) {
            i = (byteBuffer.get(byteBuffer.position() + 4) & 48) >> 4;
        }
        return jt[i] * 256;
    }

    public static int b(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int limit = byteBuffer.limit() - 10;
        for (int i = position; i <= limit; i++) {
            if ((ai.b(byteBuffer, i + 4) & -2) == -126718022) {
                return i - position;
            }
        }
        return -1;
    }

    public static int d(byte[] bArr) {
        boolean z = false;
        if (bArr[4] == -8 && bArr[5] == 114 && bArr[6] == 111) {
            byte b = bArr[7];
            if ((b & 254) == 186) {
                if ((b & UByte.MAX_VALUE) == 187) {
                    z = true;
                }
                return 40 << ((bArr[z ? (char) 9 : 8] >> 4) & 7);
            }
        }
        return 0;
    }

    public static int a(ByteBuffer byteBuffer, int i) {
        return 40 << ((byteBuffer.get((byteBuffer.position() + i) + ((byteBuffer.get((byteBuffer.position() + i) + 7) & UByte.MAX_VALUE) == 187 ? 9 : 8)) >> 4) & 7);
    }

    private static int j(int i, int i2) {
        int i3 = i2 / 2;
        if (i < 0) {
            return -1;
        }
        int[] iArr = ju;
        if (i >= iArr.length || i2 < 0) {
            return -1;
        }
        int[] iArr2 = jy;
        if (i3 >= iArr2.length) {
            return -1;
        }
        int i4 = iArr[i];
        if (i4 == 44100) {
            return (iArr2[i3] + (i2 % 2)) * 2;
        }
        int i5 = jx[i3];
        return i4 == 32000 ? i5 * 6 : i5 * 4;
    }
}
