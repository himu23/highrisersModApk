package com.fyber.inneractive.sdk.protobuf;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public class n1 extends AbstractList<String> implements d0, RandomAccess {
    public final d0 a;

    public class a implements ListIterator<String> {
        public ListIterator<String> a;

        public a(n1 n1Var, int i) {
            this.a = n1Var.a.listIterator(i);
        }

        public void add(Object obj) {
            String str = (String) obj;
            throw new UnsupportedOperationException();
        }

        public boolean hasNext() {
            return this.a.hasNext();
        }

        public boolean hasPrevious() {
            return this.a.hasPrevious();
        }

        public Object next() {
            return this.a.next();
        }

        public int nextIndex() {
            return this.a.nextIndex();
        }

        public Object previous() {
            return this.a.previous();
        }

        public int previousIndex() {
            return this.a.previousIndex();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public void set(Object obj) {
            String str = (String) obj;
            throw new UnsupportedOperationException();
        }
    }

    public class b implements Iterator<String> {
        public Iterator<String> a;

        public b(n1 n1Var) {
            this.a = n1Var.a.iterator();
        }

        public boolean hasNext() {
            return this.a.hasNext();
        }

        public Object next() {
            return this.a.next();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public n1(d0 d0Var) {
        this.a = d0Var;
    }

    public d0 a() {
        return this;
    }

    public List<?> c() {
        return this.a.c();
    }

    public Object get(int i) {
        return (String) this.a.get(i);
    }

    public Iterator<String> iterator() {
        return new b(this);
    }

    public ListIterator<String> listIterator(int i) {
        return new a(this, i);
    }

    public int size() {
        return this.a.size();
    }

    public Object a(int i) {
        return this.a.a(i);
    }

    public void a(i iVar) {
        throw new UnsupportedOperationException();
    }
}
