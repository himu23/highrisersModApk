package com.fyber.inneractive.sdk.protobuf;

import com.fyber.inneractive.sdk.protobuf.u;
import com.ironsource.m2;
import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class g1<K extends Comparable<K>, V> extends AbstractMap<K, V> {
    public static final /* synthetic */ int h = 0;
    public final int a;
    public List<g1<K, V>.e> b;
    public Map<K, V> c;
    public boolean d;
    public volatile g1<K, V>.g e;
    public Map<K, V> f;
    public volatile g1<K, V>.c g;

    public class a extends g1<FieldDescriptorType, Object> {
        public a(int i) {
            super(i, (a) null);
        }

        public void d() {
            if (!this.d) {
                for (int i = 0; i < this.b.size(); i++) {
                    Map.Entry a = a(i);
                    if (((u.b) a.getKey()).b()) {
                        a.setValue(Collections.unmodifiableList((List) a.getValue()));
                    }
                }
                for (Map.Entry entry : b()) {
                    if (((u.b) entry.getKey()).b()) {
                        entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                    }
                }
            }
            g1.super.d();
        }

        public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
            return put((Comparable) obj, obj2);
        }
    }

    public class b implements Iterator<Map.Entry<K, V>> {
        public int a;
        public Iterator<Map.Entry<K, V>> b;

        public b() {
            this.a = g1.this.b.size();
        }

        public Object next() {
            if (b().hasNext()) {
                return (Map.Entry) b().next();
            }
            List<g1<K, V>.e> list = g1.this.b;
            int i = this.a - 1;
            this.a = i;
            return list.get(i);
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public boolean hasNext() {
            int i = this.a;
            return (i > 0 && i <= g1.this.b.size()) || b().hasNext();
        }

        public final Iterator<Map.Entry<K, V>> b() {
            if (this.b == null) {
                this.b = g1.this.f.entrySet().iterator();
            }
            return this.b;
        }
    }

    public class c extends g1<K, V>.g {
        public c() {
            super(g1.this, (a) null);
        }

        public Iterator<Map.Entry<K, V>> iterator() {
            return new b();
        }
    }

    public static class d {
        public static final Iterator<Object> a = new a();
        public static final Iterable<Object> b = new b();

        public class a implements Iterator<Object> {
            public boolean hasNext() {
                return false;
            }

            public Object next() {
                throw new NoSuchElementException();
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        }

        public class b implements Iterable<Object> {
            public Iterator<Object> iterator() {
                return d.a;
            }
        }
    }

    public class e implements Map.Entry<K, V>, Comparable<g1<K, V>.e> {
        public final K a;
        public V b;

        public e(K k, V v) {
            this.a = k;
            this.b = v;
        }

        public int compareTo(Object obj) {
            return this.a.compareTo(((e) obj).a);
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            K k = this.a;
            Object key = entry.getKey();
            if (k != null ? k.equals(key) : key == null) {
                V v = this.b;
                Object value = entry.getValue();
                if (v == null) {
                    if (value == null) {
                        return true;
                    }
                } else if (v.equals(value)) {
                    return true;
                }
            }
            return false;
        }

        public Object getKey() {
            return this.a;
        }

        public V getValue() {
            return this.b;
        }

        public int hashCode() {
            K k = this.a;
            int i = 0;
            int hashCode = k == null ? 0 : k.hashCode();
            V v = this.b;
            if (v != null) {
                i = v.hashCode();
            }
            return hashCode ^ i;
        }

        public V setValue(V v) {
            g1 g1Var = g1.this;
            int i = g1.h;
            g1Var.a();
            V v2 = this.b;
            this.b = v;
            return v2;
        }

        public String toString() {
            return this.a + m2.i.b + this.b;
        }
    }

    public class f implements Iterator<Map.Entry<K, V>> {
        public int a = -1;
        public boolean b;
        public Iterator<Map.Entry<K, V>> c;

        public f() {
        }

        public boolean hasNext() {
            if (this.a + 1 < g1.this.b.size()) {
                return true;
            }
            if (g1.this.c.isEmpty() || !b().hasNext()) {
                return false;
            }
            return true;
        }

        public final Iterator<Map.Entry<K, V>> b() {
            if (this.c == null) {
                this.c = g1.this.c.entrySet().iterator();
            }
            return this.c;
        }

        public Object next() {
            this.b = true;
            int i = this.a + 1;
            this.a = i;
            if (i < g1.this.b.size()) {
                return g1.this.b.get(this.a);
            }
            return (Map.Entry) b().next();
        }

        public void remove() {
            if (this.b) {
                this.b = false;
                g1 g1Var = g1.this;
                int i = g1.h;
                g1Var.a();
                if (this.a < g1.this.b.size()) {
                    g1 g1Var2 = g1.this;
                    int i2 = this.a;
                    this.a = i2 - 1;
                    g1Var2.c(i2);
                    return;
                }
                b().remove();
                return;
            }
            throw new IllegalStateException("remove() was called before next()");
        }
    }

    public class g extends AbstractSet<Map.Entry<K, V>> {
        public g() {
        }

        public boolean add(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            if (contains(entry)) {
                return false;
            }
            g1.this.put((Comparable) entry.getKey(), entry.getValue());
            return true;
        }

        public void clear() {
            g1.this.clear();
        }

        public boolean contains(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            Object obj2 = g1.this.get(entry.getKey());
            Object value = entry.getValue();
            return obj2 == value || (obj2 != null && obj2.equals(value));
        }

        public Iterator<Map.Entry<K, V>> iterator() {
            return new f();
        }

        public boolean remove(Object obj) {
            Map.Entry entry = (Map.Entry) obj;
            if (!contains(entry)) {
                return false;
            }
            g1.this.remove(entry.getKey());
            return true;
        }

        public int size() {
            return g1.this.size();
        }

        public /* synthetic */ g(g1 g1Var, a aVar) {
            this();
        }
    }

    public /* synthetic */ g1(int i, a aVar) {
        this(i);
    }

    public static <FieldDescriptorType extends u.b<FieldDescriptorType>> g1<FieldDescriptorType, Object> b(int i) {
        return new a(i);
    }

    public final V c(int i) {
        a();
        V v = this.b.remove(i).b;
        if (!this.c.isEmpty()) {
            Iterator it = c().entrySet().iterator();
            List<g1<K, V>.e> list = this.b;
            Map.Entry entry = (Map.Entry) it.next();
            list.add(new e((Comparable) entry.getKey(), entry.getValue()));
            it.remove();
        }
        return v;
    }

    public void clear() {
        a();
        if (!this.b.isEmpty()) {
            this.b.clear();
        }
        if (!this.c.isEmpty()) {
            this.c.clear();
        }
    }

    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return a(comparable) >= 0 || this.c.containsKey(comparable);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g1)) {
            return super.equals(obj);
        }
        g1 g1Var = (g1) obj;
        int size = size();
        if (size != g1Var.size()) {
            return false;
        }
        int size2 = this.b.size();
        if (size2 != g1Var.b.size()) {
            return entrySet().equals(g1Var.entrySet());
        }
        for (int i = 0; i < size2; i++) {
            if (!a(i).equals(g1Var.a(i))) {
                return false;
            }
        }
        if (size2 != size) {
            return this.c.equals(g1Var.c);
        }
        return true;
    }

    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int a2 = a(comparable);
        if (a2 >= 0) {
            return this.b.get(a2).b;
        }
        return this.c.get(comparable);
    }

    public int hashCode() {
        int size = this.b.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i += this.b.get(i2).hashCode();
        }
        return this.c.size() > 0 ? i + this.c.hashCode() : i;
    }

    public V remove(Object obj) {
        a();
        Comparable comparable = (Comparable) obj;
        int a2 = a(comparable);
        if (a2 >= 0) {
            return c(a2);
        }
        if (this.c.isEmpty()) {
            return null;
        }
        return this.c.remove(comparable);
    }

    public int size() {
        return this.b.size() + this.c.size();
    }

    public g1(int i) {
        this.a = i;
        this.b = Collections.emptyList();
        this.c = Collections.emptyMap();
        this.f = Collections.emptyMap();
    }

    public Map.Entry<K, V> a(int i) {
        return this.b.get(i);
    }

    public Iterable<Map.Entry<K, V>> b() {
        if (this.c.isEmpty()) {
            return d.b;
        }
        return this.c.entrySet();
    }

    public Set<Map.Entry<K, V>> entrySet() {
        if (this.e == null) {
            this.e = new g();
        }
        return this.e;
    }

    /* renamed from: a */
    public V put(K k, V v) {
        a();
        int a2 = a(k);
        if (a2 >= 0) {
            e eVar = this.b.get(a2);
            g1.this.a();
            V v2 = eVar.b;
            eVar.b = v;
            return v2;
        }
        a();
        if (this.b.isEmpty() && !(this.b instanceof ArrayList)) {
            this.b = new ArrayList(this.a);
        }
        int i = -(a2 + 1);
        if (i >= this.a) {
            return c().put(k, v);
        }
        int size = this.b.size();
        int i2 = this.a;
        if (size == i2) {
            e remove = this.b.remove(i2 - 1);
            c().put(remove.a, remove.b);
        }
        this.b.add(i, new e(k, v));
        return null;
    }

    public void d() {
        Map<K, V> map;
        Map<K, V> map2;
        if (!this.d) {
            if (this.c.isEmpty()) {
                map = Collections.emptyMap();
            } else {
                map = Collections.unmodifiableMap(this.c);
            }
            this.c = map;
            if (this.f.isEmpty()) {
                map2 = Collections.emptyMap();
            } else {
                map2 = Collections.unmodifiableMap(this.f);
            }
            this.f = map2;
            this.d = true;
        }
    }

    public final SortedMap<K, V> c() {
        a();
        if (this.c.isEmpty() && !(this.c instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.c = treeMap;
            TreeMap treeMap2 = treeMap;
            this.f = treeMap.descendingMap();
        }
        return (SortedMap) this.c;
    }

    public final int a(K k) {
        int i;
        int size = this.b.size();
        int i2 = size - 1;
        if (i2 >= 0) {
            int compareTo = k.compareTo(this.b.get(i2).a);
            if (compareTo > 0) {
                i = size + 1;
                return -i;
            } else if (compareTo == 0) {
                return i2;
            }
        }
        int i3 = 0;
        while (i3 <= i2) {
            int i4 = (i3 + i2) / 2;
            int compareTo2 = k.compareTo(this.b.get(i4).a);
            if (compareTo2 < 0) {
                i2 = i4 - 1;
            } else if (compareTo2 <= 0) {
                return i4;
            } else {
                i3 = i4 + 1;
            }
        }
        i = i3 + 1;
        return -i;
    }

    public final void a() {
        if (this.d) {
            throw new UnsupportedOperationException();
        }
    }
}
