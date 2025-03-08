package com.applovin.exoplayer2.common.base;

import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract class Equivalence<T> {
    /* access modifiers changed from: protected */
    public abstract boolean doEquivalent(T t, T t2);

    /* access modifiers changed from: protected */
    public abstract int doHash(T t);

    protected Equivalence() {
    }

    public final boolean equivalent(@NullableDecl T t, @NullableDecl T t2) {
        if (t == t2) {
            return true;
        }
        if (t == null || t2 == null) {
            return false;
        }
        return doEquivalent(t, t2);
    }

    public final int hash(@NullableDecl T t) {
        if (t == null) {
            return 0;
        }
        return doHash(t);
    }

    public final <S extends T> Wrapper<S> wrap(@NullableDecl S s) {
        return new Wrapper<>(s);
    }

    public static final class Wrapper<T> implements Serializable {
        private static final long serialVersionUID = 0;
        private final Equivalence<? super T> equivalence;
        @NullableDecl
        private final T reference;

        @NullableDecl
        public T get() {
            return this.reference;
        }

        private Wrapper(Equivalence<? super T> equivalence2, @NullableDecl T t) {
            this.equivalence = (Equivalence) Preconditions.checkNotNull(equivalence2);
            this.reference = t;
        }

        public boolean equals(@NullableDecl Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Wrapper)) {
                return false;
            }
            Wrapper wrapper = (Wrapper) obj;
            if (this.equivalence.equals(wrapper.equivalence)) {
                return this.equivalence.equivalent(this.reference, wrapper.reference);
            }
            return false;
        }

        public int hashCode() {
            return this.equivalence.hash(this.reference);
        }

        public String toString() {
            return this.equivalence + ".wrap(" + this.reference + ")";
        }
    }

    public final Predicate<T> equivalentTo(@NullableDecl T t) {
        return new b(this, t);
    }

    private static final class b<T> implements Predicate<T>, Serializable {
        private final Equivalence<T> equivalence;
        @NullableDecl
        private final T ow;

        b(Equivalence<T> equivalence2, @NullableDecl T t) {
            this.equivalence = (Equivalence) Preconditions.checkNotNull(equivalence2);
            this.ow = t;
        }

        public boolean apply(@NullableDecl T t) {
            return this.equivalence.equivalent(t, this.ow);
        }

        public boolean equals(@NullableDecl Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (!this.equivalence.equals(bVar.equivalence) || !Objects.equal(this.ow, bVar.ow)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return Objects.hashCode(this.equivalence, this.ow);
        }

        public String toString() {
            return this.equivalence + ".equivalentTo(" + this.ow + ")";
        }
    }

    public static Equivalence<Object> equals() {
        return a.ov;
    }

    public static Equivalence<Object> identity() {
        return c.ox;
    }

    static final class a extends Equivalence<Object> implements Serializable {
        static final a ov = new a();

        a() {
        }

        /* access modifiers changed from: protected */
        public boolean doEquivalent(Object obj, Object obj2) {
            return obj.equals(obj2);
        }

        /* access modifiers changed from: protected */
        public int doHash(Object obj) {
            return obj.hashCode();
        }
    }

    static final class c extends Equivalence<Object> implements Serializable {
        static final c ox = new c();

        /* access modifiers changed from: protected */
        public boolean doEquivalent(Object obj, Object obj2) {
            return false;
        }

        c() {
        }

        /* access modifiers changed from: protected */
        public int doHash(Object obj) {
            return System.identityHashCode(obj);
        }
    }
}
