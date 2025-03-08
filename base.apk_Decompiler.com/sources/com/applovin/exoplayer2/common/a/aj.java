package com.applovin.exoplayer2.common.a;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Map;

final class aj {
    static <K, V> Map<K, V> bn(int i) {
        return l.aT(i);
    }

    static <K, V> Map<K, V> gR() {
        return l.fH();
    }

    static <T> T[] c(T[] tArr, int i) {
        return (Object[]) Array.newInstance(tArr.getClass().getComponentType(), i);
    }

    static <T> T[] a(Object[] objArr, int i, int i2, T[] tArr) {
        return Arrays.copyOfRange(objArr, i, i2, tArr.getClass());
    }
}
