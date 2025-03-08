package com.applovin.exoplayer2.l;

import android.util.Pair;
import java.util.Collections;
import java.util.List;

public final class e {
    private static final byte[] abK = {0, 0, 0, 1};
    private static final String[] abL = {"", "A", "B", "C"};

    public static Pair<Integer, Integer> H(byte[] bArr) {
        y yVar = new y(bArr);
        yVar.fx(9);
        int po = yVar.po();
        yVar.fx(20);
        return Pair.create(Integer.valueOf(yVar.pD()), Integer.valueOf(po));
    }

    public static List<byte[]> as(boolean z) {
        return Collections.singletonList(z ? new byte[]{1} : new byte[]{0});
    }

    public static boolean m(List<byte[]> list) {
        if (list.size() == 1 && list.get(0).length == 1 && list.get(0)[0] == 1) {
            return true;
        }
        return false;
    }

    public static String i(int i, int i2, int i3) {
        return String.format("avc1.%02X%02X%02X", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
    }

    public static String c(z zVar) {
        zVar.bR(24);
        int bQ = zVar.bQ(2);
        boolean ik = zVar.ik();
        int bQ2 = zVar.bQ(5);
        int i = 0;
        for (int i2 = 0; i2 < 32; i2++) {
            if (zVar.ik()) {
                i |= 1 << i2;
            }
        }
        int i3 = 6;
        int[] iArr = new int[6];
        for (int i4 = 0; i4 < 6; i4++) {
            iArr[i4] = zVar.bQ(8);
        }
        int bQ3 = zVar.bQ(8);
        Object[] objArr = new Object[5];
        objArr[0] = abL[bQ];
        objArr[1] = Integer.valueOf(bQ2);
        objArr[2] = Integer.valueOf(i);
        objArr[3] = Character.valueOf(ik ? 'H' : 'L');
        objArr[4] = Integer.valueOf(bQ3);
        StringBuilder sb = new StringBuilder(ai.a("hvc1.%s%d.%X.%c%d", objArr));
        while (i3 > 0 && iArr[i3 - 1] == 0) {
            i3--;
        }
        for (int i5 = 0; i5 < i3; i5++) {
            sb.append(String.format(".%02X", new Object[]{Integer.valueOf(iArr[i5])}));
        }
        return sb.toString();
    }

    public static byte[] m(byte[] bArr, int i, int i2) {
        byte[] bArr2 = abK;
        byte[] bArr3 = new byte[(bArr2.length + i2)];
        System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
        System.arraycopy(bArr, i, bArr3, bArr2.length, i2);
        return bArr3;
    }
}
