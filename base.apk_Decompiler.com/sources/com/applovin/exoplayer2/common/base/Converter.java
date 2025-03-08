package com.applovin.exoplayer2.common.base;

import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.Serializable;
import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract class Converter<A, B> implements Function<A, B> {
    private final boolean handleNullAutomatically;
    @MonotonicNonNullDecl
    @LazyInit
    private transient Converter<B, A> reverse;

    /* access modifiers changed from: protected */
    public abstract A doBackward(B b2);

    /* access modifiers changed from: protected */
    public abstract B doForward(A a2);

    protected Converter() {
        this(true);
    }

    Converter(boolean z) {
        this.handleNullAutomatically = z;
    }

    @NullableDecl
    public final B convert(@NullableDecl A a2) {
        return correctedDoForward(a2);
    }

    /* access modifiers changed from: package-private */
    @NullableDecl
    public B correctedDoForward(@NullableDecl A a2) {
        if (!this.handleNullAutomatically) {
            return doForward(a2);
        }
        if (a2 == null) {
            return null;
        }
        return Preconditions.checkNotNull(doForward(a2));
    }

    /* access modifiers changed from: package-private */
    @NullableDecl
    public A correctedDoBackward(@NullableDecl B b2) {
        if (!this.handleNullAutomatically) {
            return doBackward(b2);
        }
        if (b2 == null) {
            return null;
        }
        return Preconditions.checkNotNull(doBackward(b2));
    }

    public Iterable<B> convertAll(final Iterable<? extends A> iterable) {
        Preconditions.checkNotNull(iterable, "fromIterable");
        return new Iterable<B>() {
            public Iterator<B> iterator() {
                return new Iterator<B>() {
                    private final Iterator<? extends A> om;

                    {
                        this.om = iterable.iterator();
                    }

                    public boolean hasNext() {
                        return this.om.hasNext();
                    }

                    public B next() {
                        return Converter.this.convert(this.om.next());
                    }

                    public void remove() {
                        this.om.remove();
                    }
                };
            }
        };
    }

    public Converter<B, A> reverse() {
        Converter<B, A> converter = this.reverse;
        if (converter != null) {
            return converter;
        }
        d dVar = new d(this);
        this.reverse = dVar;
        return dVar;
    }

    private static final class d<A, B> extends Converter<B, A> implements Serializable {
        final Converter<A, B> ou;

        public Converter<A, B> reverse() {
            return this.ou;
        }

        d(Converter<A, B> converter) {
            this.ou = converter;
        }

        /* access modifiers changed from: protected */
        public A doForward(B b) {
            throw new AssertionError();
        }

        /* access modifiers changed from: protected */
        public B doBackward(A a) {
            throw new AssertionError();
        }

        /* access modifiers changed from: package-private */
        @NullableDecl
        public A correctedDoForward(@NullableDecl B b) {
            return this.ou.correctedDoBackward(b);
        }

        /* access modifiers changed from: package-private */
        @NullableDecl
        public B correctedDoBackward(@NullableDecl A a) {
            return this.ou.correctedDoForward(a);
        }

        public boolean equals(@NullableDecl Object obj) {
            if (obj instanceof d) {
                return this.ou.equals(((d) obj).ou);
            }
            return false;
        }

        public int hashCode() {
            return ~this.ou.hashCode();
        }

        public String toString() {
            return this.ou + ".reverse()";
        }
    }

    public final <C> Converter<A, C> andThen(Converter<B, C> converter) {
        return doAndThen(converter);
    }

    /* access modifiers changed from: package-private */
    public <C> Converter<A, C> doAndThen(Converter<B, C> converter) {
        return new a(this, (Converter) Preconditions.checkNotNull(converter));
    }

    private static final class a<A, B, C> extends Converter<A, C> implements Serializable {
        final Converter<A, B> op;
        final Converter<B, C> oq;

        a(Converter<A, B> converter, Converter<B, C> converter2) {
            this.op = converter;
            this.oq = converter2;
        }

        /* access modifiers changed from: protected */
        public C doForward(A a) {
            throw new AssertionError();
        }

        /* access modifiers changed from: protected */
        public A doBackward(C c) {
            throw new AssertionError();
        }

        /* access modifiers changed from: package-private */
        @NullableDecl
        public C correctedDoForward(@NullableDecl A a) {
            return this.oq.correctedDoForward(this.op.correctedDoForward(a));
        }

        /* access modifiers changed from: package-private */
        @NullableDecl
        public A correctedDoBackward(@NullableDecl C c) {
            return this.op.correctedDoBackward(this.oq.correctedDoBackward(c));
        }

        public boolean equals(@NullableDecl Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (!this.op.equals(aVar.op) || !this.oq.equals(aVar.oq)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (this.op.hashCode() * 31) + this.oq.hashCode();
        }

        public String toString() {
            return this.op + ".andThen(" + this.oq + ")";
        }
    }

    @NullableDecl
    @Deprecated
    public final B apply(@NullableDecl A a2) {
        return convert(a2);
    }

    public boolean equals(@NullableDecl Object obj) {
        return super.equals(obj);
    }

    public static <A, B> Converter<A, B> from(Function<? super A, ? extends B> function, Function<? super B, ? extends A> function2) {
        return new b(function, function2);
    }

    private static final class b<A, B> extends Converter<A, B> implements Serializable {
        private final Function<? super A, ? extends B> or;
        private final Function<? super B, ? extends A> os;

        private b(Function<? super A, ? extends B> function, Function<? super B, ? extends A> function2) {
            this.or = (Function) Preconditions.checkNotNull(function);
            this.os = (Function) Preconditions.checkNotNull(function2);
        }

        /* access modifiers changed from: protected */
        public B doForward(A a) {
            return this.or.apply(a);
        }

        /* access modifiers changed from: protected */
        public A doBackward(B b) {
            return this.os.apply(b);
        }

        public boolean equals(@NullableDecl Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (!this.or.equals(bVar.or) || !this.os.equals(bVar.os)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (this.or.hashCode() * 31) + this.os.hashCode();
        }

        public String toString() {
            return "Converter.from(" + this.or + ", " + this.os + ")";
        }
    }

    public static <T> Converter<T, T> identity() {
        return c.ot;
    }

    private static final class c<T> extends Converter<T, T> implements Serializable {
        static final c ot = new c();

        /* access modifiers changed from: protected */
        public T doBackward(T t) {
            return t;
        }

        /* access modifiers changed from: protected */
        public T doForward(T t) {
            return t;
        }

        /* renamed from: eY */
        public c<T> reverse() {
            return this;
        }

        public String toString() {
            return "Converter.identity()";
        }

        private c() {
        }

        /* access modifiers changed from: package-private */
        public <S> Converter<T, S> doAndThen(Converter<T, S> converter) {
            return (Converter) Preconditions.checkNotNull(converter, "otherConverter");
        }
    }
}
