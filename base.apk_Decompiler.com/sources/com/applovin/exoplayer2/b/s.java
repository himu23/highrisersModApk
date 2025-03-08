package com.applovin.exoplayer2.b;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;
import kotlin.UByte;

public class s {
    public static int i(byte[] bArr) {
        return bArr[9] & UByte.MAX_VALUE;
    }

    public static List<byte[]> j(byte[] bArr) {
        long Z = Z((long) k(bArr));
        long Z2 = Z(3840);
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(bArr);
        arrayList.add(Y(Z));
        arrayList.add(Y(Z2));
        return arrayList;
    }

    private static int k(byte[] bArr) {
        return (bArr[10] & UByte.MAX_VALUE) | ((bArr[11] & UByte.MAX_VALUE) << 8);
    }

    private static byte[] Y(long j) {
        return ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(j).array();
    }

    private static long Z(long j) {
        return (j * 1000000000) / 48000;
    }
}
