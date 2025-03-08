package com.applovin.exoplayer2.common.a;

import com.applovin.exoplayer2.common.base.Function;
import java.util.Comparator;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract class ai<T> implements Comparator<T> {
    public abstract int compare(@NullableDecl T t, @NullableDecl T t2);

    public static <C extends Comparable> ai<C> gP() {
        return ag.qN;
    }

    public static <T> ai<T> b(Comparator<T> comparator) {
        if (comparator instanceof ai) {
            return (ai) comparator;
        }
        return new m(comparator);
    }

    protected ai() {
    }

    public <S extends T> ai<S> gO() {
        return new ao(this);
    }

    public <F> ai<F> a(Function<F, ? extends T> function) {
        return new i(function, this);
    }

    /* access modifiers changed from: package-private */
    public <T2 extends T> ai<Map.Entry<T2, ?>> gQ() {
        return a(ab.gF());
    }

    public <E extends T> s<E> g(Iterable<E> iterable) {
        return s.a(this, iterable);
    }
}
