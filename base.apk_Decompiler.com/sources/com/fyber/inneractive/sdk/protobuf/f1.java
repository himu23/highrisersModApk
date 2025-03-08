package com.fyber.inneractive.sdk.protobuf;

import com.fyber.inneractive.sdk.protobuf.y;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;
import java.util.logging.Logger;

public final class f1 {
    public static final Class<?> a;
    public static final k1<?, ?> b = a(false);
    public static final k1<?, ?> c = a(true);
    public static final k1<?, ?> d = new m1();

    static {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.protobuf.GeneratedMessageV3");
        } catch (Throwable unused) {
            cls = null;
        }
        a = cls;
    }

    public static void a(int i, List<Boolean> list, s1 s1Var, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            m mVar = (m) s1Var;
            mVar.getClass();
            int i2 = 0;
            if (z) {
                mVar.a.i(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    list.get(i4).booleanValue();
                    Logger logger = l.b;
                    i3++;
                }
                mVar.a.g(i3);
                while (i2 < list.size()) {
                    mVar.a.a(list.get(i2).booleanValue() ? (byte) 1 : 0);
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                mVar.a.b(i, list.get(i2).booleanValue());
                i2++;
            }
        }
    }

    public static void b(int i, List<Double> list, s1 s1Var, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            m mVar = (m) s1Var;
            mVar.getClass();
            int i2 = 0;
            if (z) {
                mVar.a.i(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    list.get(i4).doubleValue();
                    Logger logger = l.b;
                    i3 += 8;
                }
                mVar.a.g(i3);
                while (i2 < list.size()) {
                    l lVar = mVar.a;
                    double doubleValue = list.get(i2).doubleValue();
                    lVar.getClass();
                    lVar.c(Double.doubleToRawLongBits(doubleValue));
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                l lVar2 = mVar.a;
                double doubleValue2 = list.get(i2).doubleValue();
                lVar2.getClass();
                lVar2.f(i, Double.doubleToRawLongBits(doubleValue2));
                i2++;
            }
        }
    }

    public static void c(int i, List<Integer> list, s1 s1Var, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            m mVar = (m) s1Var;
            mVar.getClass();
            int i2 = 0;
            if (z) {
                mVar.a.i(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    i3 += l.a(list.get(i4).intValue());
                }
                mVar.a.g(i3);
                while (i2 < list.size()) {
                    mVar.a.f(list.get(i2).intValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                mVar.a.h(i, list.get(i2).intValue());
                i2++;
            }
        }
    }

    public static void d(int i, List<Integer> list, s1 s1Var, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            m mVar = (m) s1Var;
            mVar.getClass();
            int i2 = 0;
            if (z) {
                mVar.a.i(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    list.get(i4).intValue();
                    Logger logger = l.b;
                    i3 += 4;
                }
                mVar.a.g(i3);
                while (i2 < list.size()) {
                    mVar.a.e(list.get(i2).intValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                mVar.a.g(i, list.get(i2).intValue());
                i2++;
            }
        }
    }

    public static void e(int i, List<Long> list, s1 s1Var, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            m mVar = (m) s1Var;
            mVar.getClass();
            int i2 = 0;
            if (z) {
                mVar.a.i(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    list.get(i4).longValue();
                    Logger logger = l.b;
                    i3 += 8;
                }
                mVar.a.g(i3);
                while (i2 < list.size()) {
                    mVar.a.c(list.get(i2).longValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                mVar.a.f(i, list.get(i2).longValue());
                i2++;
            }
        }
    }

    public static void f(int i, List<Float> list, s1 s1Var, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            m mVar = (m) s1Var;
            mVar.getClass();
            int i2 = 0;
            if (z) {
                mVar.a.i(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    list.get(i4).floatValue();
                    Logger logger = l.b;
                    i3 += 4;
                }
                mVar.a.g(i3);
                while (i2 < list.size()) {
                    l lVar = mVar.a;
                    float floatValue = list.get(i2).floatValue();
                    lVar.getClass();
                    lVar.e(Float.floatToRawIntBits(floatValue));
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                l lVar2 = mVar.a;
                float floatValue2 = list.get(i2).floatValue();
                lVar2.getClass();
                lVar2.g(i, Float.floatToRawIntBits(floatValue2));
                i2++;
            }
        }
    }

    public static void g(int i, List<Integer> list, s1 s1Var, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            m mVar = (m) s1Var;
            mVar.getClass();
            int i2 = 0;
            if (z) {
                mVar.a.i(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    i3 += l.a(list.get(i4).intValue());
                }
                mVar.a.g(i3);
                while (i2 < list.size()) {
                    mVar.a.f(list.get(i2).intValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                mVar.a.h(i, list.get(i2).intValue());
                i2++;
            }
        }
    }

    public static void h(int i, List<Long> list, s1 s1Var, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            m mVar = (m) s1Var;
            mVar.getClass();
            int i2 = 0;
            if (z) {
                mVar.a.i(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    i3 += l.a(list.get(i4).longValue());
                }
                mVar.a.g(i3);
                while (i2 < list.size()) {
                    mVar.a.d(list.get(i2).longValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                mVar.a.g(i, list.get(i2).longValue());
                i2++;
            }
        }
    }

    public static void i(int i, List<Integer> list, s1 s1Var, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            m mVar = (m) s1Var;
            mVar.getClass();
            int i2 = 0;
            if (z) {
                mVar.a.i(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    list.get(i4).intValue();
                    Logger logger = l.b;
                    i3 += 4;
                }
                mVar.a.g(i3);
                while (i2 < list.size()) {
                    mVar.a.e(list.get(i2).intValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                mVar.a.g(i, list.get(i2).intValue());
                i2++;
            }
        }
    }

    public static void j(int i, List<Long> list, s1 s1Var, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            m mVar = (m) s1Var;
            mVar.getClass();
            int i2 = 0;
            if (z) {
                mVar.a.i(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    list.get(i4).longValue();
                    Logger logger = l.b;
                    i3 += 8;
                }
                mVar.a.g(i3);
                while (i2 < list.size()) {
                    mVar.a.c(list.get(i2).longValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                mVar.a.f(i, list.get(i2).longValue());
                i2++;
            }
        }
    }

    public static void k(int i, List<Integer> list, s1 s1Var, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            m mVar = (m) s1Var;
            mVar.getClass();
            int i2 = 0;
            if (z) {
                mVar.a.i(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    i3 += l.c(l.d(list.get(i4).intValue()));
                }
                mVar.a.g(i3);
                while (i2 < list.size()) {
                    mVar.a.g(l.d(list.get(i2).intValue()));
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                mVar.a.j(i, l.d(list.get(i2).intValue()));
                i2++;
            }
        }
    }

    public static void l(int i, List<Long> list, s1 s1Var, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            m mVar = (m) s1Var;
            mVar.getClass();
            int i2 = 0;
            if (z) {
                mVar.a.i(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    i3 += l.a(l.b(list.get(i4).longValue()));
                }
                mVar.a.g(i3);
                while (i2 < list.size()) {
                    mVar.a.d(l.b(list.get(i2).longValue()));
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                mVar.a.g(i, l.b(list.get(i2).longValue()));
                i2++;
            }
        }
    }

    public static void m(int i, List<Integer> list, s1 s1Var, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            m mVar = (m) s1Var;
            mVar.getClass();
            int i2 = 0;
            if (z) {
                mVar.a.i(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    i3 += l.c(list.get(i4).intValue());
                }
                mVar.a.g(i3);
                while (i2 < list.size()) {
                    mVar.a.g(list.get(i2).intValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                mVar.a.j(i, list.get(i2).intValue());
                i2++;
            }
        }
    }

    public static void n(int i, List<Long> list, s1 s1Var, boolean z) throws IOException {
        if (list != null && !list.isEmpty()) {
            m mVar = (m) s1Var;
            mVar.getClass();
            int i2 = 0;
            if (z) {
                mVar.a.i(i, 2);
                int i3 = 0;
                for (int i4 = 0; i4 < list.size(); i4++) {
                    i3 += l.a(list.get(i4).longValue());
                }
                mVar.a.g(i3);
                while (i2 < list.size()) {
                    mVar.a.d(list.get(i2).longValue());
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                mVar.a.g(i, list.get(i2).longValue());
                i2++;
            }
        }
    }

    public static void a(int i, List<i> list, s1 s1Var) throws IOException {
        if (list != null && !list.isEmpty()) {
            m mVar = (m) s1Var;
            mVar.getClass();
            for (int i2 = 0; i2 < list.size(); i2++) {
                mVar.a.b(i, list.get(i2));
            }
        }
    }

    public static void b(int i, List<String> list, s1 s1Var) throws IOException {
        if (list != null && !list.isEmpty()) {
            m mVar = (m) s1Var;
            mVar.getClass();
            int i2 = 0;
            if (list instanceof d0) {
                d0 d0Var = (d0) list;
                while (i2 < list.size()) {
                    Object a2 = d0Var.a(i2);
                    if (a2 instanceof String) {
                        mVar.a.b(i, (String) a2);
                    } else {
                        mVar.a.b(i, (i) a2);
                    }
                    i2++;
                }
                return;
            }
            while (i2 < list.size()) {
                mVar.a.b(i, list.get(i2));
                i2++;
            }
        }
    }

    public static int c(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (!z) {
            return size * l.b(i, 0);
        }
        int i2 = size * 4;
        return l.b(i) + l.c(i2) + i2;
    }

    public static int d(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof x) {
            x xVar = (x) list;
            i = 0;
            while (i2 < size) {
                i += l.a(xVar.e(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + l.a(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    public static int e(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof f0) {
            f0 f0Var = (f0) list;
            i = 0;
            while (i2 < size) {
                i += l.a(f0Var.d(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + l.a(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    public static int f(int i, List<Long> list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        int e = e(list);
        if (z) {
            return l.b(i) + l.c(e) + e;
        }
        return e + (list.size() * l.b(i));
    }

    public static int g(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof f0) {
            f0 f0Var = (f0) list;
            i = 0;
            while (i2 < size) {
                i += l.a(l.b(f0Var.d(i2)));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + l.a(l.b(list.get(i2).longValue()));
                i2++;
            }
        }
        return i;
    }

    public static int h(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int g = g(list);
        if (z) {
            return l.b(i) + l.c(g) + g;
        }
        return g + (size * l.b(i));
    }

    public static int i(List<Long> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof f0) {
            f0 f0Var = (f0) list;
            i = 0;
            while (i2 < size) {
                i += l.a(f0Var.d(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + l.a(list.get(i2).longValue());
                i2++;
            }
        }
        return i;
    }

    public static int j(int i, List<Long> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2 = i(list);
        if (z) {
            return l.b(i) + l.c(i2) + i2;
        }
        return i2 + (size * l.b(i));
    }

    public static void a(int i, List<?> list, s1 s1Var, d1 d1Var) throws IOException {
        if (list != null && !list.isEmpty()) {
            m mVar = (m) s1Var;
            mVar.getClass();
            for (int i2 = 0; i2 < list.size(); i2++) {
                mVar.a(i, list.get(i2), d1Var);
            }
        }
    }

    public static int a(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof x) {
            x xVar = (x) list;
            i = 0;
            while (i2 < size) {
                i += l.a(xVar.e(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + l.a(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    public static int c(List<?> list) {
        return list.size() * 8;
    }

    public static int f(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof x) {
            x xVar = (x) list;
            i = 0;
            while (i2 < size) {
                i += l.c(l.d(xVar.e(i2)));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + l.c(l.d(list.get(i2).intValue()));
                i2++;
            }
        }
        return i;
    }

    public static int h(List<Integer> list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof x) {
            x xVar = (x) list;
            i = 0;
            while (i2 < size) {
                i += l.c(xVar.e(i2));
                i2++;
            }
        } else {
            int i3 = 0;
            while (i2 < size) {
                i3 = i + l.c(list.get(i2).intValue());
                i2++;
            }
        }
        return i;
    }

    public static void b(int i, List<?> list, s1 s1Var, d1 d1Var) throws IOException {
        if (list != null && !list.isEmpty()) {
            m mVar = (m) s1Var;
            mVar.getClass();
            for (int i2 = 0; i2 < list.size(); i2++) {
                mVar.a.b(i, (o0) list.get(i2), d1Var);
            }
        }
    }

    public static int e(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int d2 = d(list);
        if (z) {
            return l.b(i) + l.c(d2) + d2;
        }
        return d2 + (size * l.b(i));
    }

    public static int g(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int f = f(list);
        if (z) {
            return l.b(i) + l.c(f) + f;
        }
        return f + (size * l.b(i));
    }

    public static int d(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (!z) {
            return size * l.a(i, 0);
        }
        int i2 = size * 8;
        return l.b(i) + l.c(i2) + i2;
    }

    public static int i(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int h = h(list);
        if (z) {
            return l.b(i) + l.c(h) + h;
        }
        return h + (size * l.b(i));
    }

    public static int b(int i, List<Integer> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int a2 = a(list);
        if (z) {
            return l.b(i) + l.c(a2) + a2;
        }
        return a2 + (size * l.b(i));
    }

    public static int a(int i, List<?> list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (z) {
            return l.b(i) + l.c(size) + size;
        }
        return size * l.a(i, true);
    }

    public static int b(List<?> list) {
        return list.size() * 4;
    }

    public static int b(int i, List<?> list) {
        int i2;
        int i3;
        int size = list.size();
        int i4 = 0;
        if (size == 0) {
            return 0;
        }
        int b2 = l.b(i) * size;
        if (list instanceof d0) {
            d0 d0Var = (d0) list;
            while (i4 < size) {
                Object a2 = d0Var.a(i4);
                if (a2 instanceof i) {
                    i3 = l.a((i) a2);
                } else {
                    i3 = l.a((String) a2);
                }
                b2 += i3;
                i4++;
            }
        } else {
            while (i4 < size) {
                Object obj = list.get(i4);
                if (obj instanceof i) {
                    i2 = l.a((i) obj);
                } else {
                    i2 = l.a((String) obj);
                }
                b2 += i2;
                i4++;
            }
        }
        return b2;
    }

    public static int a(int i, Object obj, d1 d1Var) {
        if (obj instanceof b0) {
            return l.b(i) + l.a((b0) obj);
        }
        int b2 = l.b(i);
        int serializedSize = ((a) ((o0) obj)).getSerializedSize(d1Var);
        return b2 + l.c(serializedSize) + serializedSize;
    }

    public static int a(int i, List<i> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int b2 = size * l.b(i);
        for (int i2 = 0; i2 < list.size(); i2++) {
            b2 += l.a(list.get(i2));
        }
        return b2;
    }

    public static int a(int i, List<o0> list, d1 d1Var) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += l.a(i, list.get(i3), d1Var);
        }
        return i2;
    }

    public static int b(int i, List<?> list, d1 d1Var) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int b2 = l.b(i) * size;
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = list.get(i2);
            if (obj instanceof b0) {
                b2 += l.a((b0) obj);
            } else {
                int serializedSize = ((a) ((o0) obj)).getSerializedSize(d1Var);
                b2 += l.c(serializedSize) + serializedSize;
            }
        }
        return b2;
    }

    public static k1<?, ?> a(boolean z) {
        Class<?> cls;
        try {
            cls = Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            cls = null;
        }
        if (cls == null) {
            return null;
        }
        try {
            return (k1) cls.getConstructor(new Class[]{Boolean.TYPE}).newInstance(new Object[]{Boolean.valueOf(z)});
        } catch (Throwable unused2) {
            return null;
        }
    }

    public static boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static <UT, UB> UB a(int i, List<Integer> list, y.d<?> dVar, UB ub, k1<UT, UB> k1Var) {
        if (dVar == null) {
            return ub;
        }
        int size = list.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            int intValue = list.get(i3).intValue();
            if (dVar.a(intValue) != null) {
                if (i3 != i2) {
                    list.set(i2, Integer.valueOf(intValue));
                }
                i2++;
            } else {
                if (ub == null) {
                    ub = k1Var.a();
                }
                k1Var.b(ub, i, (long) intValue);
            }
        }
        if (i2 != size) {
            list.subList(i2, size).clear();
        }
        return ub;
    }

    public static <UT, UB> UB a(int i, List<Integer> list, y.e eVar, UB ub, k1<UT, UB> k1Var) {
        if (eVar == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                int intValue = list.get(i3).intValue();
                if (eVar.a(intValue)) {
                    if (i3 != i2) {
                        list.set(i2, Integer.valueOf(intValue));
                    }
                    i2++;
                } else {
                    if (ub == null) {
                        ub = k1Var.a();
                    }
                    k1Var.b(ub, i, (long) intValue);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
            }
        } else {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = it.next().intValue();
                if (!eVar.a(intValue2)) {
                    if (ub == null) {
                        ub = k1Var.a();
                    }
                    k1Var.b(ub, i, (long) intValue2);
                    it.remove();
                }
            }
        }
        return ub;
    }

    public static <UT, UB> UB a(int i, int i2, UB ub, k1<UT, UB> k1Var) {
        if (ub == null) {
            ub = k1Var.a();
        }
        k1Var.b(ub, i, (long) i2);
        return ub;
    }
}
