package com.fyber.inneractive.sdk.protobuf;

import com.fyber.inneractive.sdk.protobuf.y;
import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

public abstract class c<E> extends AbstractList<E> implements y.j<E> {
    public boolean a = true;

    public boolean add(E e) {
        e();
        return super.add(e);
    }

    public boolean addAll(Collection<? extends E> collection) {
        e();
        return super.addAll(collection);
    }

    public final void b() {
        this.a = false;
    }

    public void clear() {
        e();
        super.clear();
    }

    public boolean d() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        if (!(obj instanceof RandomAccess)) {
            return super.equals(obj);
        }
        List list = (List) obj;
        int size = size();
        if (size != list.size()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!get(i).equals(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int size = size();
        int i = 1;
        for (int i2 = 0; i2 < size; i2++) {
            i = (i * 31) + get(i2).hashCode();
        }
        return i;
    }

    public abstract E remove(int i);

    public boolean remove(Object obj) {
        e();
        int indexOf = indexOf(obj);
        if (indexOf == -1) {
            return false;
        }
        remove(indexOf);
        return true;
    }

    public boolean removeAll(Collection<?> collection) {
        e();
        return super.removeAll(collection);
    }

    public boolean retainAll(Collection<?> collection) {
        e();
        return super.retainAll(collection);
    }

    public void e() {
        if (!this.a) {
            throw new UnsupportedOperationException();
        }
    }

    public boolean addAll(int i, Collection<? extends E> collection) {
        e();
        return super.addAll(i, collection);
    }
}
