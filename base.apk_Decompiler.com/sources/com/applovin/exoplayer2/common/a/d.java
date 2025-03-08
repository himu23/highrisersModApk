package com.applovin.exoplayer2.common.a;

import com.applovin.exoplayer2.common.a.ab;
import com.applovin.exoplayer2.common.a.f;
import com.applovin.exoplayer2.common.base.Preconditions;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

abstract class d<K, V> extends f<K, V> implements Serializable {
    /* access modifiers changed from: private */
    public transient Map<K, Collection<V>> pf;
    private transient int pg;

    /* access modifiers changed from: package-private */
    public abstract Collection<V> fd();

    public int size() {
        return this.pg;
    }

    static /* synthetic */ int a(d dVar, int i2) {
        int i3 = dVar.pg + i2;
        dVar.pg = i3;
        return i3;
    }

    static /* synthetic */ int b(d dVar) {
        int i2 = dVar.pg;
        dVar.pg = i2 - 1;
        return i2;
    }

    static /* synthetic */ int b(d dVar, int i2) {
        int i3 = dVar.pg - i2;
        dVar.pg = i3;
        return i3;
    }

    static /* synthetic */ int c(d dVar) {
        int i2 = dVar.pg;
        dVar.pg = i2 + 1;
        return i2;
    }

    protected d(Map<K, Collection<V>> map) {
        Preconditions.checkArgument(map.isEmpty());
        this.pf = map;
    }

    /* access modifiers changed from: package-private */
    public Collection<V> l(@NullableDecl K k) {
        return fd();
    }

    public boolean c(@NullableDecl K k, @NullableDecl V v) {
        Collection collection = this.pf.get(k);
        if (collection == null) {
            Collection l = l(k);
            if (l.add(v)) {
                this.pg++;
                this.pf.put(k, l);
                return true;
            }
            throw new AssertionError("New Collection violated the Collection spec");
        } else if (!collection.add(v)) {
            return false;
        } else {
            this.pg++;
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public <E> Collection<E> a(Collection<E> collection) {
        return Collections.unmodifiableCollection(collection);
    }

    public void clear() {
        for (Collection<V> clear : this.pf.values()) {
            clear.clear();
        }
        this.pf.clear();
        this.pg = 0;
    }

    public Collection<V> k(@NullableDecl K k) {
        Collection collection = this.pf.get(k);
        if (collection == null) {
            collection = l(k);
        }
        return a(k, collection);
    }

    /* access modifiers changed from: package-private */
    public Collection<V> a(@NullableDecl K k, Collection<V> collection) {
        return new i(k, collection, (d<K, V>.i) null);
    }

    /* access modifiers changed from: package-private */
    public final List<V> a(@NullableDecl K k, List<V> list, @NullableDecl d<K, V>.i iVar) {
        if (list instanceof RandomAccess) {
            return new f(k, list, iVar);
        }
        return new j(k, list, iVar);
    }

    class i extends AbstractCollection<V> {
        @NullableDecl
        final K pn;
        Collection<V> pt;
        @NullableDecl
        final d<K, V>.i pu;
        @NullableDecl
        final Collection<V> pv;

        /* access modifiers changed from: package-private */
        public d<K, V>.i fA() {
            return this.pu;
        }

        /* access modifiers changed from: package-private */
        public Collection<V> fz() {
            return this.pt;
        }

        /* access modifiers changed from: package-private */
        public K getKey() {
            return this.pn;
        }

        i(@NullableDecl K k, Collection<V> collection, @NullableDecl d<K, V>.i iVar) {
            Collection<V> collection2;
            this.pn = k;
            this.pt = collection;
            this.pu = iVar;
            if (iVar == null) {
                collection2 = null;
            } else {
                collection2 = iVar.fz();
            }
            this.pv = collection2;
        }

        /* access modifiers changed from: package-private */
        public void fw() {
            Collection<V> collection;
            d<K, V>.i iVar = this.pu;
            if (iVar != null) {
                iVar.fw();
                if (this.pu.fz() != this.pv) {
                    throw new ConcurrentModificationException();
                }
            } else if (this.pt.isEmpty() && (collection = (Collection) d.this.pf.get(this.pn)) != null) {
                this.pt = collection;
            }
        }

        /* access modifiers changed from: package-private */
        public void fx() {
            d<K, V>.i iVar = this.pu;
            if (iVar != null) {
                iVar.fx();
            } else if (this.pt.isEmpty()) {
                d.this.pf.remove(this.pn);
            }
        }

        /* access modifiers changed from: package-private */
        public void fy() {
            d<K, V>.i iVar = this.pu;
            if (iVar != null) {
                iVar.fy();
            } else {
                d.this.pf.put(this.pn, this.pt);
            }
        }

        public int size() {
            fw();
            return this.pt.size();
        }

        public boolean equals(@NullableDecl Object obj) {
            if (obj == this) {
                return true;
            }
            fw();
            return this.pt.equals(obj);
        }

        public int hashCode() {
            fw();
            return this.pt.hashCode();
        }

        public String toString() {
            fw();
            return this.pt.toString();
        }

        public Iterator<V> iterator() {
            fw();
            return new a();
        }

        class a implements Iterator<V> {
            final Iterator<V> pk;
            final Collection<V> pw;

            a() {
                this.pw = i.this.pt;
                this.pk = d.b(i.this.pt);
            }

            a(Iterator<V> it) {
                this.pw = i.this.pt;
                this.pk = it;
            }

            /* access modifiers changed from: package-private */
            public void fB() {
                i.this.fw();
                if (i.this.pt != this.pw) {
                    throw new ConcurrentModificationException();
                }
            }

            public boolean hasNext() {
                fB();
                return this.pk.hasNext();
            }

            public V next() {
                fB();
                return this.pk.next();
            }

            public void remove() {
                this.pk.remove();
                d.b(d.this);
                i.this.fx();
            }

            /* access modifiers changed from: package-private */
            public Iterator<V> fC() {
                fB();
                return this.pk;
            }
        }

        public boolean add(V v) {
            fw();
            boolean isEmpty = this.pt.isEmpty();
            boolean add = this.pt.add(v);
            if (add) {
                d.c(d.this);
                if (isEmpty) {
                    fy();
                }
            }
            return add;
        }

        public boolean addAll(Collection<? extends V> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean addAll = this.pt.addAll(collection);
            if (addAll) {
                d.a(d.this, this.pt.size() - size);
                if (size == 0) {
                    fy();
                }
            }
            return addAll;
        }

        public boolean contains(Object obj) {
            fw();
            return this.pt.contains(obj);
        }

        public boolean containsAll(Collection<?> collection) {
            fw();
            return this.pt.containsAll(collection);
        }

        public void clear() {
            int size = size();
            if (size != 0) {
                this.pt.clear();
                d.b(d.this, size);
                fx();
            }
        }

        public boolean remove(Object obj) {
            fw();
            boolean remove = this.pt.remove(obj);
            if (remove) {
                d.b(d.this);
                fx();
            }
            return remove;
        }

        public boolean removeAll(Collection<?> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean removeAll = this.pt.removeAll(collection);
            if (removeAll) {
                d.a(d.this, this.pt.size() - size);
                fx();
            }
            return removeAll;
        }

        public boolean retainAll(Collection<?> collection) {
            Preconditions.checkNotNull(collection);
            int size = size();
            boolean retainAll = this.pt.retainAll(collection);
            if (retainAll) {
                d.a(d.this, this.pt.size() - size);
                fx();
            }
            return retainAll;
        }
    }

    /* access modifiers changed from: private */
    public static <E> Iterator<E> b(Collection<E> collection) {
        if (collection instanceof List) {
            return ((List) collection).listIterator();
        }
        return collection.iterator();
    }

    class j extends d<K, V>.i implements List<V> {
        j(@NullableDecl K k, List<V> list, @NullableDecl d<K, V>.i iVar) {
            super(k, list, iVar);
        }

        /* access modifiers changed from: package-private */
        public List<V> fD() {
            return (List) fz();
        }

        public boolean addAll(int i, Collection<? extends V> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean addAll = fD().addAll(i, collection);
            if (addAll) {
                d.a(d.this, fz().size() - size);
                if (size == 0) {
                    fy();
                }
            }
            return addAll;
        }

        public V get(int i) {
            fw();
            return fD().get(i);
        }

        public V set(int i, V v) {
            fw();
            return fD().set(i, v);
        }

        public void add(int i, V v) {
            fw();
            boolean isEmpty = fz().isEmpty();
            fD().add(i, v);
            d.c(d.this);
            if (isEmpty) {
                fy();
            }
        }

        public V remove(int i) {
            fw();
            V remove = fD().remove(i);
            d.b(d.this);
            fx();
            return remove;
        }

        public int indexOf(Object obj) {
            fw();
            return fD().indexOf(obj);
        }

        public int lastIndexOf(Object obj) {
            fw();
            return fD().lastIndexOf(obj);
        }

        public ListIterator<V> listIterator() {
            fw();
            return new a();
        }

        public ListIterator<V> listIterator(int i) {
            fw();
            return new a(i);
        }

        public List<V> subList(int i, int i2) {
            fw();
            return d.this.a(getKey(), fD().subList(i, i2), fA() == null ? this : fA());
        }

        private class a extends d<K, V>.i.a implements ListIterator<V> {
            a() {
                super();
            }

            public a(int i) {
                super(j.this.fD().listIterator(i));
            }

            private ListIterator<V> fE() {
                return (ListIterator) fC();
            }

            public boolean hasPrevious() {
                return fE().hasPrevious();
            }

            public V previous() {
                return fE().previous();
            }

            public int nextIndex() {
                return fE().nextIndex();
            }

            public int previousIndex() {
                return fE().previousIndex();
            }

            public void set(V v) {
                fE().set(v);
            }

            public void add(V v) {
                boolean isEmpty = j.this.isEmpty();
                fE().add(v);
                d.c(d.this);
                if (isEmpty) {
                    j.this.fy();
                }
            }
        }
    }

    private class f extends d<K, V>.j implements RandomAccess {
        f(@NullableDecl K k, List<V> list, @NullableDecl d<K, V>.i iVar) {
            super(k, list, iVar);
        }
    }

    /* access modifiers changed from: package-private */
    public Set<K> fe() {
        return new c(this.pf);
    }

    /* access modifiers changed from: package-private */
    public final Set<K> ff() {
        Map<K, Collection<V>> map = this.pf;
        if (map instanceof NavigableMap) {
            return new e((NavigableMap) this.pf);
        }
        if (map instanceof SortedMap) {
            return new h((SortedMap) this.pf);
        }
        return new c(this.pf);
    }

    private class c extends ab.c<K, Collection<V>> {
        c(Map<K, Collection<V>> map) {
            super(map);
        }

        public Iterator<K> iterator() {
            final Iterator it = fo().entrySet().iterator();
            return new Iterator<K>() {
                @NullableDecl
                Map.Entry<K, Collection<V>> pp;

                public boolean hasNext() {
                    return it.hasNext();
                }

                public K next() {
                    Map.Entry<K, Collection<V>> entry = (Map.Entry) it.next();
                    this.pp = entry;
                    return entry.getKey();
                }

                public void remove() {
                    j.I(this.pp != null);
                    Collection value = this.pp.getValue();
                    it.remove();
                    d.b(d.this, value.size());
                    value.clear();
                    this.pp = null;
                }
            };
        }

        public boolean remove(Object obj) {
            Collection collection = (Collection) fo().remove(obj);
            if (collection != null) {
                int size = collection.size();
                collection.clear();
                d.b(d.this, size);
                if (size > 0) {
                    return true;
                }
            }
            return false;
        }

        public void clear() {
            y.e(iterator());
        }

        public boolean containsAll(Collection<?> collection) {
            return fo().keySet().containsAll(collection);
        }

        public boolean equals(@NullableDecl Object obj) {
            return this == obj || fo().keySet().equals(obj);
        }

        public int hashCode() {
            return fo().keySet().hashCode();
        }
    }

    private class h extends d<K, V>.c implements SortedSet<K> {
        h(SortedMap<K, Collection<V>> sortedMap) {
            super(sortedMap);
        }

        /* access modifiers changed from: package-private */
        public SortedMap<K, Collection<V>> fv() {
            return (SortedMap) super.fo();
        }

        public Comparator<? super K> comparator() {
            return fv().comparator();
        }

        public K first() {
            return fv().firstKey();
        }

        public SortedSet<K> headSet(K k) {
            return new h(fv().headMap(k));
        }

        public K last() {
            return fv().lastKey();
        }

        public SortedSet<K> subSet(K k, K k2) {
            return new h(fv().subMap(k, k2));
        }

        public SortedSet<K> tailSet(K k) {
            return new h(fv().tailMap(k));
        }
    }

    class e extends d<K, V>.h implements NavigableSet<K> {
        e(NavigableMap<K, Collection<V>> navigableMap) {
            super(navigableMap);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: fq */
        public NavigableMap<K, Collection<V>> fv() {
            return (NavigableMap) super.fv();
        }

        public K lower(K k) {
            return fv().lowerKey(k);
        }

        public K floor(K k) {
            return fv().floorKey(k);
        }

        public K ceiling(K k) {
            return fv().ceilingKey(k);
        }

        public K higher(K k) {
            return fv().higherKey(k);
        }

        public K pollFirst() {
            return y.d(iterator());
        }

        public K pollLast() {
            return y.d(descendingIterator());
        }

        public NavigableSet<K> descendingSet() {
            return new e(fv().descendingMap());
        }

        public Iterator<K> descendingIterator() {
            return descendingSet().iterator();
        }

        /* renamed from: q */
        public NavigableSet<K> headSet(K k) {
            return headSet(k, false);
        }

        public NavigableSet<K> headSet(K k, boolean z) {
            return new e(fv().headMap(k, z));
        }

        /* renamed from: g */
        public NavigableSet<K> subSet(K k, K k2) {
            return subSet(k, true, k2, false);
        }

        public NavigableSet<K> subSet(K k, boolean z, K k2, boolean z2) {
            return new e(fv().subMap(k, z, k2, z2));
        }

        /* renamed from: r */
        public NavigableSet<K> tailSet(K k) {
            return tailSet(k, true);
        }

        public NavigableSet<K> tailSet(K k, boolean z) {
            return new e(fv().tailMap(k, z));
        }
    }

    /* access modifiers changed from: private */
    public void m(Object obj) {
        Collection collection = (Collection) ab.c(this.pf, obj);
        if (collection != null) {
            int size = collection.size();
            collection.clear();
            this.pg -= size;
        }
    }

    private abstract class b<T> implements Iterator<T> {
        @MonotonicNonNullDecl
        Collection<V> pl = null;
        final Iterator<Map.Entry<K, Collection<V>>> pm;
        @NullableDecl
        K pn = null;
        Iterator<V> po = y.gD();

        /* access modifiers changed from: package-private */
        public abstract T d(K k, V v);

        b() {
            this.pm = d.this.pf.entrySet().iterator();
        }

        public boolean hasNext() {
            return this.pm.hasNext() || this.po.hasNext();
        }

        public T next() {
            if (!this.po.hasNext()) {
                Map.Entry next = this.pm.next();
                this.pn = next.getKey();
                Collection<V> collection = (Collection) next.getValue();
                this.pl = collection;
                this.po = collection.iterator();
            }
            return d(this.pn, this.po.next());
        }

        public void remove() {
            this.po.remove();
            if (this.pl.isEmpty()) {
                this.pm.remove();
            }
            d.b(d.this);
        }
    }

    public Collection<V> values() {
        return super.values();
    }

    /* access modifiers changed from: package-private */
    public Collection<V> fg() {
        return new f.c();
    }

    /* access modifiers changed from: package-private */
    public Iterator<V> fh() {
        return new d<K, V>.b<V>() {
            /* access modifiers changed from: package-private */
            public V d(K k, V v) {
                return v;
            }
        };
    }

    public Collection<Map.Entry<K, V>> fi() {
        return super.fi();
    }

    /* access modifiers changed from: package-private */
    public Collection<Map.Entry<K, V>> fj() {
        if (this instanceof ap) {
            return new f.b();
        }
        return new f.a();
    }

    /* access modifiers changed from: package-private */
    public Iterator<Map.Entry<K, V>> fk() {
        return new d<K, V>.b<Map.Entry<K, V>>() {
            /* access modifiers changed from: package-private */
            /* renamed from: e */
            public Map.Entry<K, V> d(K k, V v) {
                return ab.n(k, v);
            }
        };
    }

    /* access modifiers changed from: package-private */
    public Map<K, Collection<V>> fl() {
        return new a(this.pf);
    }

    /* access modifiers changed from: package-private */
    public final Map<K, Collection<V>> fm() {
        Map<K, Collection<V>> map = this.pf;
        if (map instanceof NavigableMap) {
            return new C0034d((NavigableMap) this.pf);
        }
        if (map instanceof SortedMap) {
            return new g((SortedMap) this.pf);
        }
        return new a(this.pf);
    }

    private class a extends ab.e<K, Collection<V>> {
        final transient Map<K, Collection<V>> pi;

        a(Map<K, Collection<V>> map) {
            this.pi = map;
        }

        /* access modifiers changed from: protected */
        public Set<Map.Entry<K, Collection<V>>> fn() {
            return new C0033a();
        }

        public boolean containsKey(Object obj) {
            return ab.b(this.pi, obj);
        }

        /* renamed from: k */
        public Collection<V> get(Object obj) {
            Collection collection = (Collection) ab.a(this.pi, obj);
            if (collection == null) {
                return null;
            }
            return d.this.a(obj, collection);
        }

        public Set<K> keySet() {
            return d.this.keySet();
        }

        public int size() {
            return this.pi.size();
        }

        /* renamed from: n */
        public Collection<V> remove(Object obj) {
            Collection remove = this.pi.remove(obj);
            if (remove == null) {
                return null;
            }
            Collection<V> fd = d.this.fd();
            fd.addAll(remove);
            d.b(d.this, remove.size());
            remove.clear();
            return fd;
        }

        public boolean equals(@NullableDecl Object obj) {
            return this == obj || this.pi.equals(obj);
        }

        public int hashCode() {
            return this.pi.hashCode();
        }

        public String toString() {
            return this.pi.toString();
        }

        public void clear() {
            if (this.pi == d.this.pf) {
                d.this.clear();
            } else {
                y.e(new b());
            }
        }

        /* access modifiers changed from: package-private */
        public Map.Entry<K, Collection<V>> a(Map.Entry<K, Collection<V>> entry) {
            K key = entry.getKey();
            return ab.n(key, d.this.a(key, entry.getValue()));
        }

        /* renamed from: com.applovin.exoplayer2.common.a.d$a$a  reason: collision with other inner class name */
        class C0033a extends ab.b<K, Collection<V>> {
            /* access modifiers changed from: package-private */
            public Map<K, Collection<V>> fo() {
                return a.this;
            }

            C0033a() {
            }

            public Iterator<Map.Entry<K, Collection<V>>> iterator() {
                return new b();
            }

            public boolean contains(Object obj) {
                return k.a(a.this.pi.entrySet(), obj);
            }

            public boolean remove(Object obj) {
                if (!contains(obj)) {
                    return false;
                }
                d.this.m(((Map.Entry) obj).getKey());
                return true;
            }
        }

        class b implements Iterator<Map.Entry<K, Collection<V>>> {
            final Iterator<Map.Entry<K, Collection<V>>> pk;
            @NullableDecl
            Collection<V> pl;

            b() {
                this.pk = a.this.pi.entrySet().iterator();
            }

            public boolean hasNext() {
                return this.pk.hasNext();
            }

            /* renamed from: fp */
            public Map.Entry<K, Collection<V>> next() {
                Map.Entry next = this.pk.next();
                this.pl = (Collection) next.getValue();
                return a.this.a(next);
            }

            public void remove() {
                j.I(this.pl != null);
                this.pk.remove();
                d.b(d.this, this.pl.size());
                this.pl.clear();
                this.pl = null;
            }
        }
    }

    private class g extends d<K, V>.a implements SortedMap<K, Collection<V>> {
        @MonotonicNonNullDecl
        SortedSet<K> ps;

        g(SortedMap<K, Collection<V>> sortedMap) {
            super(sortedMap);
        }

        /* access modifiers changed from: package-private */
        public SortedMap<K, Collection<V>> fv() {
            return (SortedMap) this.pi;
        }

        public Comparator<? super K> comparator() {
            return fv().comparator();
        }

        public K firstKey() {
            return fv().firstKey();
        }

        public K lastKey() {
            return fv().lastKey();
        }

        public SortedMap<K, Collection<V>> headMap(K k) {
            return new g(fv().headMap(k));
        }

        public SortedMap<K, Collection<V>> subMap(K k, K k2) {
            return new g(fv().subMap(k, k2));
        }

        public SortedMap<K, Collection<V>> tailMap(K k) {
            return new g(fv().tailMap(k));
        }

        /* renamed from: fu */
        public SortedSet<K> keySet() {
            SortedSet<K> sortedSet = this.ps;
            if (sortedSet != null) {
                return sortedSet;
            }
            SortedSet<K> ft = fe();
            this.ps = ft;
            return ft;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: ft */
        public SortedSet<K> fe() {
            return new h(fv());
        }
    }

    /* renamed from: com.applovin.exoplayer2.common.a.d$d  reason: collision with other inner class name */
    class C0034d extends d<K, V>.g implements NavigableMap<K, Collection<V>> {
        C0034d(NavigableMap<K, Collection<V>> navigableMap) {
            super(navigableMap);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: fq */
        public NavigableMap<K, Collection<V>> fv() {
            return (NavigableMap) super.fv();
        }

        public Map.Entry<K, Collection<V>> lowerEntry(K k) {
            Map.Entry lowerEntry = fv().lowerEntry(k);
            if (lowerEntry == null) {
                return null;
            }
            return a(lowerEntry);
        }

        public K lowerKey(K k) {
            return fv().lowerKey(k);
        }

        public Map.Entry<K, Collection<V>> floorEntry(K k) {
            Map.Entry floorEntry = fv().floorEntry(k);
            if (floorEntry == null) {
                return null;
            }
            return a(floorEntry);
        }

        public K floorKey(K k) {
            return fv().floorKey(k);
        }

        public Map.Entry<K, Collection<V>> ceilingEntry(K k) {
            Map.Entry ceilingEntry = fv().ceilingEntry(k);
            if (ceilingEntry == null) {
                return null;
            }
            return a(ceilingEntry);
        }

        public K ceilingKey(K k) {
            return fv().ceilingKey(k);
        }

        public Map.Entry<K, Collection<V>> higherEntry(K k) {
            Map.Entry higherEntry = fv().higherEntry(k);
            if (higherEntry == null) {
                return null;
            }
            return a(higherEntry);
        }

        public K higherKey(K k) {
            return fv().higherKey(k);
        }

        public Map.Entry<K, Collection<V>> firstEntry() {
            Map.Entry firstEntry = fv().firstEntry();
            if (firstEntry == null) {
                return null;
            }
            return a(firstEntry);
        }

        public Map.Entry<K, Collection<V>> lastEntry() {
            Map.Entry lastEntry = fv().lastEntry();
            if (lastEntry == null) {
                return null;
            }
            return a(lastEntry);
        }

        public Map.Entry<K, Collection<V>> pollFirstEntry() {
            return a(entrySet().iterator());
        }

        public Map.Entry<K, Collection<V>> pollLastEntry() {
            return a(descendingMap().entrySet().iterator());
        }

        /* access modifiers changed from: package-private */
        public Map.Entry<K, Collection<V>> a(Iterator<Map.Entry<K, Collection<V>>> it) {
            if (!it.hasNext()) {
                return null;
            }
            Map.Entry next = it.next();
            Collection fd = d.this.fd();
            fd.addAll((Collection) next.getValue());
            it.remove();
            return ab.n(next.getKey(), d.this.a(fd));
        }

        public NavigableMap<K, Collection<V>> descendingMap() {
            return new C0034d(fv().descendingMap());
        }

        /* renamed from: fr */
        public NavigableSet<K> keySet() {
            return (NavigableSet) super.keySet();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: fs */
        public NavigableSet<K> ft() {
            return new e(fv());
        }

        public NavigableSet<K> navigableKeySet() {
            return keySet();
        }

        public NavigableSet<K> descendingKeySet() {
            return descendingMap().navigableKeySet();
        }

        /* renamed from: f */
        public NavigableMap<K, Collection<V>> subMap(K k, K k2) {
            return subMap(k, true, k2, false);
        }

        public NavigableMap<K, Collection<V>> subMap(K k, boolean z, K k2, boolean z2) {
            return new C0034d(fv().subMap(k, z, k2, z2));
        }

        /* renamed from: o */
        public NavigableMap<K, Collection<V>> headMap(K k) {
            return headMap(k, false);
        }

        public NavigableMap<K, Collection<V>> headMap(K k, boolean z) {
            return new C0034d(fv().headMap(k, z));
        }

        /* renamed from: p */
        public NavigableMap<K, Collection<V>> tailMap(K k) {
            return tailMap(k, true);
        }

        public NavigableMap<K, Collection<V>> tailMap(K k, boolean z) {
            return new C0034d(fv().tailMap(k, z));
        }
    }
}
