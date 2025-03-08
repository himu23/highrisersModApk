package com.applovin.exoplayer2.m.a;

import com.applovin.exoplayer2.l.ai;
import com.applovin.exoplayer2.l.x;
import com.applovin.exoplayer2.l.y;
import com.applovin.exoplayer2.m.a.e;
import java.util.ArrayList;
import java.util.zip.Inflater;

final class f {
    private static int fV(int i) {
        return (-(i & 1)) ^ (i >> 1);
    }

    public static e m(byte[] bArr, int i) {
        ArrayList<e.a> arrayList;
        y yVar = new y(bArr);
        try {
            arrayList = aw(yVar) ? ax(yVar) : ay(yVar);
        } catch (ArrayIndexOutOfBoundsException unused) {
            arrayList = null;
        }
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        if (size == 1) {
            return new e(arrayList.get(0), i);
        }
        if (size != 2) {
            return null;
        }
        return new e(arrayList.get(0), arrayList.get(1), i);
    }

    private static boolean aw(y yVar) {
        yVar.fz(4);
        int px = yVar.px();
        yVar.fx(0);
        if (px == 1886547818) {
            return true;
        }
        return false;
    }

    private static ArrayList<e.a> ax(y yVar) {
        int px;
        yVar.fz(8);
        int il = yVar.il();
        int pk = yVar.pk();
        while (il < pk && (px = yVar.px() + il) > il && px <= pk) {
            int px2 = yVar.px();
            if (px2 == 2037673328 || px2 == 1836279920) {
                yVar.fA(px);
                return ay(yVar);
            }
            yVar.fx(px);
            il = px;
        }
        return null;
    }

    private static ArrayList<e.a> ay(y yVar) {
        if (yVar.po() != 0) {
            return null;
        }
        yVar.fz(7);
        int px = yVar.px();
        if (px == 1684433976) {
            y yVar2 = new y();
            Inflater inflater = new Inflater(true);
            try {
                if (!ai.a(yVar, yVar2, inflater)) {
                    return null;
                }
                inflater.end();
                yVar = yVar2;
            } finally {
                inflater.end();
            }
        } else if (px != 1918990112) {
            return null;
        }
        return az(yVar);
    }

    private static ArrayList<e.a> az(y yVar) {
        ArrayList<e.a> arrayList = new ArrayList<>();
        int il = yVar.il();
        int pk = yVar.pk();
        while (il < pk) {
            int px = yVar.px() + il;
            if (px <= il || px > pk) {
                return null;
            }
            if (yVar.px() == 1835365224) {
                e.a aA = aA(yVar);
                if (aA == null) {
                    return null;
                }
                arrayList.add(aA);
            }
            yVar.fx(px);
            il = px;
        }
        return arrayList;
    }

    private static e.a aA(y yVar) {
        int px = yVar.px();
        if (px > 10000) {
            return null;
        }
        float[] fArr = new float[px];
        for (int i = 0; i < px; i++) {
            fArr[i] = yVar.pG();
        }
        int px2 = yVar.px();
        if (px2 > 32000) {
            return null;
        }
        double d = 2.0d;
        double log = Math.log(2.0d);
        int ceil = (int) Math.ceil(Math.log(((double) px) * 2.0d) / log);
        x xVar = new x(yVar.hO());
        int i2 = 8;
        xVar.fx(yVar.il() * 8);
        float[] fArr2 = new float[(px2 * 5)];
        int i3 = 5;
        int[] iArr = new int[5];
        int i4 = 0;
        int i5 = 0;
        while (i4 < px2) {
            int i6 = 0;
            while (i6 < i3) {
                int fV = iArr[i6] + fV(xVar.bQ(ceil));
                if (fV >= px || fV < 0) {
                    return null;
                }
                fArr2[i5] = fArr[fV];
                iArr[i6] = fV;
                i6++;
                i5++;
                i3 = 5;
            }
            i4++;
            i3 = 5;
        }
        xVar.fx((xVar.il() + 7) & -8);
        int i7 = 32;
        int bQ = xVar.bQ(32);
        e.b[] bVarArr = new e.b[bQ];
        int i8 = 0;
        while (i8 < bQ) {
            int bQ2 = xVar.bQ(i2);
            int bQ3 = xVar.bQ(i2);
            int bQ4 = xVar.bQ(i7);
            if (bQ4 > 128000) {
                return null;
            }
            int i9 = bQ2;
            int ceil2 = (int) Math.ceil(Math.log(((double) px2) * d) / log);
            float[] fArr3 = new float[(bQ4 * 3)];
            float[] fArr4 = new float[(bQ4 * 2)];
            int i10 = 0;
            for (int i11 = 0; i11 < bQ4; i11++) {
                i10 += fV(xVar.bQ(ceil2));
                if (i10 < 0 || i10 >= px2) {
                    return null;
                }
                int i12 = i11 * 3;
                int i13 = i10 * 5;
                fArr3[i12] = fArr2[i13];
                fArr3[i12 + 1] = fArr2[i13 + 1];
                fArr3[i12 + 2] = fArr2[i13 + 2];
                int i14 = i11 * 2;
                fArr4[i14] = fArr2[i13 + 3];
                fArr4[i14 + 1] = fArr2[i13 + 4];
            }
            bVarArr[i8] = new e.b(i9, fArr3, fArr4, bQ3);
            i8++;
            i7 = 32;
            d = 2.0d;
            i2 = 8;
        }
        return new e.a(bVarArr);
    }
}
