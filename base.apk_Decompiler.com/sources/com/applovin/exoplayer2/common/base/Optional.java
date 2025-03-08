package com.applovin.exoplayer2.common.base;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract class Optional<T> implements Serializable {
    private static final long serialVersionUID = 0;

    public abstract Set<T> asSet();

    public abstract boolean equals(@NullableDecl Object obj);

    public abstract T get();

    public abstract int hashCode();

    public abstract boolean isPresent();

    public abstract Optional<T> or(Optional<? extends T> optional);

    public abstract T or(Supplier<? extends T> supplier);

    public abstract T or(T t);

    @NullableDecl
    public abstract T orNull();

    public abstract String toString();

    public abstract <V> Optional<V> transform(Function<? super T, V> function);

    public static <T> Optional<T> absent() {
        return a.eS();
    }

    public static <T> Optional<T> of(T t) {
        return new d(Preconditions.checkNotNull(t));
    }

    public static <T> Optional<T> fromNullable(@NullableDecl T t) {
        return t == null ? absent() : new d(t);
    }

    Optional() {
    }

    public static <T> Iterable<T> presentInstances(final Iterable<? extends Optional<? extends T>> iterable) {
        Preconditions.checkNotNull(iterable);
        return new Iterable<T>() {
            public Iterator<T> iterator() {
                return new b<T>() {
                    private final Iterator<? extends Optional<? extends T>> oB;

                    {
                        this.oB = (Iterator) Preconditions.checkNotNull(iterable.iterator());
                    }

                    /* access modifiers changed from: protected */
                    public T eT() {
                        while (this.oB.hasNext()) {
                            Optional optional = (Optional) this.oB.next();
                            if (optional.isPresent()) {
                                return optional.get();
                            }
                        }
                        return eU();
                    }
                };
            }
        };
    }
}
