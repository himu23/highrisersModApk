package com.applovin.exoplayer2.common.base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class Predicates {

    enum g implements Predicate<Object> {
        ALWAYS_TRUE {
            public boolean apply(@NullableDecl Object obj) {
                return true;
            }

            public String toString() {
                return "Predicates.alwaysTrue()";
            }
        },
        ALWAYS_FALSE {
            public boolean apply(@NullableDecl Object obj) {
                return false;
            }

            public String toString() {
                return "Predicates.alwaysFalse()";
            }
        },
        IS_NULL {
            public boolean apply(@NullableDecl Object obj) {
                return obj == null;
            }

            public String toString() {
                return "Predicates.isNull()";
            }
        },
        NOT_NULL {
            public boolean apply(@NullableDecl Object obj) {
                return obj != null;
            }

            public String toString() {
                return "Predicates.notNull()";
            }
        };

        /* access modifiers changed from: package-private */
        public <T> Predicate<T> eZ() {
            return this;
        }
    }

    private Predicates() {
    }

    public static <T> Predicate<T> alwaysTrue() {
        return g.ALWAYS_TRUE.eZ();
    }

    public static <T> Predicate<T> alwaysFalse() {
        return g.ALWAYS_FALSE.eZ();
    }

    public static <T> Predicate<T> isNull() {
        return g.IS_NULL.eZ();
    }

    public static <T> Predicate<T> notNull() {
        return g.NOT_NULL.eZ();
    }

    public static <T> Predicate<T> not(Predicate<T> predicate) {
        return new f(predicate);
    }

    public static <T> Predicate<T> and(Iterable<? extends Predicate<? super T>> iterable) {
        return new a(defensiveCopy(iterable));
    }

    @SafeVarargs
    public static <T> Predicate<T> and(Predicate<? super T>... predicateArr) {
        return new a(defensiveCopy((T[]) predicateArr));
    }

    public static <T> Predicate<T> and(Predicate<? super T> predicate, Predicate<? super T> predicate2) {
        return new a(asList((Predicate) Preconditions.checkNotNull(predicate), (Predicate) Preconditions.checkNotNull(predicate2)));
    }

    public static <T> Predicate<T> or(Iterable<? extends Predicate<? super T>> iterable) {
        return new h(defensiveCopy(iterable));
    }

    @SafeVarargs
    public static <T> Predicate<T> or(Predicate<? super T>... predicateArr) {
        return new h(defensiveCopy((T[]) predicateArr));
    }

    public static <T> Predicate<T> or(Predicate<? super T> predicate, Predicate<? super T> predicate2) {
        return new h(asList((Predicate) Preconditions.checkNotNull(predicate), (Predicate) Preconditions.checkNotNull(predicate2)));
    }

    public static <T> Predicate<T> equalTo(@NullableDecl T t) {
        return t == null ? isNull() : new e(t);
    }

    public static Predicate<Object> instanceOf(Class<?> cls) {
        return new d(cls);
    }

    public static Predicate<Class<?>> subtypeOf(Class<?> cls) {
        return new i(cls);
    }

    public static <T> Predicate<T> in(Collection<? extends T> collection) {
        return new c(collection);
    }

    public static <A, B> Predicate<A> compose(Predicate<B> predicate, Function<A, ? extends B> function) {
        return new b(predicate, function);
    }

    private static class f<T> implements Predicate<T>, Serializable {
        final Predicate<T> nP;

        f(Predicate<T> predicate) {
            this.nP = (Predicate) Preconditions.checkNotNull(predicate);
        }

        public boolean apply(@NullableDecl T t) {
            return !this.nP.apply(t);
        }

        public int hashCode() {
            return ~this.nP.hashCode();
        }

        public boolean equals(@NullableDecl Object obj) {
            if (obj instanceof f) {
                return this.nP.equals(((f) obj).nP);
            }
            return false;
        }

        public String toString() {
            return "Predicates.not(" + this.nP + ")";
        }
    }

    private static class a<T> implements Predicate<T>, Serializable {
        private final List<? extends Predicate<? super T>> oD;

        private a(List<? extends Predicate<? super T>> list) {
            this.oD = list;
        }

        public boolean apply(@NullableDecl T t) {
            for (int i = 0; i < this.oD.size(); i++) {
                if (!((Predicate) this.oD.get(i)).apply(t)) {
                    return false;
                }
            }
            return true;
        }

        public int hashCode() {
            return this.oD.hashCode() + 306654252;
        }

        public boolean equals(@NullableDecl Object obj) {
            if (obj instanceof a) {
                return this.oD.equals(((a) obj).oD);
            }
            return false;
        }

        public String toString() {
            return Predicates.toStringHelper("and", this.oD);
        }
    }

    private static class h<T> implements Predicate<T>, Serializable {
        private final List<? extends Predicate<? super T>> oD;

        private h(List<? extends Predicate<? super T>> list) {
            this.oD = list;
        }

        public boolean apply(@NullableDecl T t) {
            for (int i = 0; i < this.oD.size(); i++) {
                if (((Predicate) this.oD.get(i)).apply(t)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return this.oD.hashCode() + 87855567;
        }

        public boolean equals(@NullableDecl Object obj) {
            if (obj instanceof h) {
                return this.oD.equals(((h) obj).oD);
            }
            return false;
        }

        public String toString() {
            return Predicates.toStringHelper("or", this.oD);
        }
    }

    /* access modifiers changed from: private */
    public static String toStringHelper(String str, Iterable<?> iterable) {
        StringBuilder sb = new StringBuilder("Predicates.");
        sb.append(str);
        sb.append('(');
        boolean z = true;
        for (Object next : iterable) {
            if (!z) {
                sb.append(',');
            }
            sb.append(next);
            z = false;
        }
        sb.append(')');
        return sb.toString();
    }

    private static class e<T> implements Predicate<T>, Serializable {
        private final T ow;

        private e(T t) {
            this.ow = t;
        }

        public boolean apply(T t) {
            return this.ow.equals(t);
        }

        public int hashCode() {
            return this.ow.hashCode();
        }

        public boolean equals(@NullableDecl Object obj) {
            if (obj instanceof e) {
                return this.ow.equals(((e) obj).ow);
            }
            return false;
        }

        public String toString() {
            return "Predicates.equalTo(" + this.ow + ")";
        }
    }

    private static class d implements Predicate<Object>, Serializable {
        private final Class<?> oH;

        private d(Class<?> cls) {
            this.oH = (Class) Preconditions.checkNotNull(cls);
        }

        public boolean apply(@NullableDecl Object obj) {
            return this.oH.isInstance(obj);
        }

        public int hashCode() {
            return this.oH.hashCode();
        }

        public boolean equals(@NullableDecl Object obj) {
            if (!(obj instanceof d) || this.oH != ((d) obj).oH) {
                return false;
            }
            return true;
        }

        public String toString() {
            return "Predicates.instanceOf(" + this.oH.getName() + ")";
        }
    }

    private static class i implements Predicate<Class<?>>, Serializable {
        private final Class<?> oH;

        private i(Class<?> cls) {
            this.oH = (Class) Preconditions.checkNotNull(cls);
        }

        /* renamed from: a */
        public boolean apply(Class<?> cls) {
            return this.oH.isAssignableFrom(cls);
        }

        public int hashCode() {
            return this.oH.hashCode();
        }

        public boolean equals(@NullableDecl Object obj) {
            if (!(obj instanceof i) || this.oH != ((i) obj).oH) {
                return false;
            }
            return true;
        }

        public String toString() {
            return "Predicates.subtypeOf(" + this.oH.getName() + ")";
        }
    }

    private static class c<T> implements Predicate<T>, Serializable {
        private final Collection<?> oG;

        private c(Collection<?> collection) {
            this.oG = (Collection) Preconditions.checkNotNull(collection);
        }

        public boolean apply(@NullableDecl T t) {
            try {
                return this.oG.contains(t);
            } catch (ClassCastException | NullPointerException unused) {
                return false;
            }
        }

        public boolean equals(@NullableDecl Object obj) {
            if (obj instanceof c) {
                return this.oG.equals(((c) obj).oG);
            }
            return false;
        }

        public int hashCode() {
            return this.oG.hashCode();
        }

        public String toString() {
            return "Predicates.in(" + this.oG + ")";
        }
    }

    private static class b<A, B> implements Predicate<A>, Serializable {
        final Predicate<B> oE;
        final Function<A, ? extends B> oF;

        private b(Predicate<B> predicate, Function<A, ? extends B> function) {
            this.oE = (Predicate) Preconditions.checkNotNull(predicate);
            this.oF = (Function) Preconditions.checkNotNull(function);
        }

        public boolean apply(@NullableDecl A a) {
            return this.oE.apply(this.oF.apply(a));
        }

        public boolean equals(@NullableDecl Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (!this.oF.equals(bVar.oF) || !this.oE.equals(bVar.oE)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return this.oF.hashCode() ^ this.oE.hashCode();
        }

        public String toString() {
            return this.oE + "(" + this.oF + ")";
        }
    }

    private static <T> List<Predicate<? super T>> asList(Predicate<? super T> predicate, Predicate<? super T> predicate2) {
        return Arrays.asList(new Predicate[]{predicate, predicate2});
    }

    private static <T> List<T> defensiveCopy(T... tArr) {
        return defensiveCopy(Arrays.asList(tArr));
    }

    static <T> List<T> defensiveCopy(Iterable<T> iterable) {
        ArrayList arrayList = new ArrayList();
        for (T checkNotNull : iterable) {
            arrayList.add(Preconditions.checkNotNull(checkNotNull));
        }
        return arrayList;
    }
}
