package com.applovin.exoplayer2.common.a;

import com.applovin.exoplayer2.common.base.Preconditions;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class aq {

    static abstract class a<E> extends AbstractSet<E> {
        a() {
        }

        public boolean removeAll(Collection<?> collection) {
            return aq.a((Set<?>) this, collection);
        }

        public boolean retainAll(Collection<?> collection) {
            return super.retainAll((Collection) Preconditions.checkNotNull(collection));
        }
    }

    public static <E> HashSet<E> gS() {
        return new HashSet<>();
    }

    public static <E> HashSet<E> bp(int i) {
        return new HashSet<>(ab.bl(i));
    }

    public static <E> Set<E> gT() {
        return Collections.newSetFromMap(ab.gH());
    }

    public static abstract class b<E> extends AbstractSet<E> {
        /* renamed from: fU */
        public abstract ax<E> iterator();

        /* synthetic */ b(AnonymousClass1 r1) {
            this();
        }

        private b() {
        }

        @Deprecated
        public final boolean add(E e) {
            throw new UnsupportedOperationException();
        }

        @Deprecated
        public final boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Deprecated
        public final boolean addAll(Collection<? extends E> collection) {
            throw new UnsupportedOperationException();
        }

        @Deprecated
        public final boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Deprecated
        public final boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Deprecated
        public final void clear() {
            throw new UnsupportedOperationException();
        }
    }

    /* renamed from: com.applovin.exoplayer2.common.a.aq$1  reason: invalid class name */
    class AnonymousClass1 extends b<E> {
        final /* synthetic */ Set qZ;
        final /* synthetic */ Set ra;

        public int size() {
            int size = this.qZ.size();
            for (Object contains : this.ra) {
                if (!this.qZ.contains(contains)) {
                    size++;
                }
            }
            return size;
        }

        public boolean isEmpty() {
            return this.qZ.isEmpty() && this.ra.isEmpty();
        }

        /* renamed from: fU */
        public ax<E> iterator() {
            return new b<E>() {
                final Iterator<? extends E> rb;
                final Iterator<? extends E> rc;

                {
                    this.rb = AnonymousClass1.this.qZ.iterator();
                    this.rc = AnonymousClass1.this.ra.iterator();
                }

                /* access modifiers changed from: protected */
                public E eT() {
                    if (this.rb.hasNext()) {
                        return this.rb.next();
                    }
                    while (this.rc.hasNext()) {
                        E next = this.rc.next();
                        if (!AnonymousClass1.this.qZ.contains(next)) {
                            return next;
                        }
                    }
                    return eU();
                }
            };
        }

        public boolean contains(Object obj) {
            return this.qZ.contains(obj) || this.ra.contains(obj);
        }
    }

    public static <E> b<E> a(final Set<E> set, final Set<?> set2) {
        Preconditions.checkNotNull(set, "set1");
        Preconditions.checkNotNull(set2, "set2");
        return new b<E>() {
            /* renamed from: fU */
            public ax<E> iterator() {
                return new b<E>() {
                    final Iterator<E> re;

                    {
                        this.re = set.iterator();
                    }

                    /* access modifiers changed from: protected */
                    public E eT() {
                        while (this.re.hasNext()) {
                            E next = this.re.next();
                            if (set2.contains(next)) {
                                return next;
                            }
                        }
                        return eU();
                    }
                };
            }

            public int size() {
                int i = 0;
                for (Object contains : set) {
                    if (set2.contains(contains)) {
                        i++;
                    }
                }
                return i;
            }

            public boolean isEmpty() {
                return Collections.disjoint(set2, set);
            }

            public boolean contains(Object obj) {
                return set.contains(obj) && set2.contains(obj);
            }

            public boolean containsAll(Collection<?> collection) {
                return set.containsAll(collection) && set2.containsAll(collection);
            }
        };
    }

    static int a(Set<?> set) {
        Iterator<?> it = set.iterator();
        int i = 0;
        while (it.hasNext()) {
            Object next = it.next();
            i = ~(~(i + (next != null ? next.hashCode() : 0)));
        }
        return i;
    }

    static boolean a(Set<?> set, @NullableDecl Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                if (set.size() != set2.size() || !set.containsAll(set2)) {
                    return false;
                }
                return true;
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    static boolean a(Set<?> set, Iterator<?> it) {
        boolean z = false;
        while (it.hasNext()) {
            z |= set.remove(it.next());
        }
        return z;
    }

    static boolean a(Set<?> set, Collection<?> collection) {
        Preconditions.checkNotNull(collection);
        if (collection instanceof af) {
            collection = ((af) collection).gN();
        }
        if (!(collection instanceof Set) || collection.size() <= set.size()) {
            return a(set, collection.iterator());
        }
        return y.a(set.iterator(), collection);
    }
}
