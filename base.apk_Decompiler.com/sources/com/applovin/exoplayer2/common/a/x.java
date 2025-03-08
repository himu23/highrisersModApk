package com.applovin.exoplayer2.common.a;

import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class x {
    public static String c(Iterable<?> iterable) {
        return y.b(iterable.iterator());
    }

    static Object[] d(Iterable<?> iterable) {
        return e(iterable).toArray();
    }

    private static <E> Collection<E> e(Iterable<E> iterable) {
        if (iterable instanceof Collection) {
            return (Collection) iterable;
        }
        return aa.f(iterable.iterator());
    }

    @NullableDecl
    public static <T> T a(Iterable<? extends T> iterable, @NullableDecl T t) {
        return y.a(iterable.iterator(), t);
    }

    public static <T> T f(Iterable<T> iterable) {
        if (!(iterable instanceof List)) {
            return y.c(iterable.iterator());
        }
        List list = (List) iterable;
        if (!list.isEmpty()) {
            return f(list);
        }
        throw new NoSuchElementException();
    }

    private static <T> T f(List<T> list) {
        return list.get(list.size() - 1);
    }
}
