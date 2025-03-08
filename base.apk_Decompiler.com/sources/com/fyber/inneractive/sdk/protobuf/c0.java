package com.fyber.inneractive.sdk.protobuf;

import com.fyber.inneractive.sdk.protobuf.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public class c0 extends c<String> implements d0, RandomAccess {
    public final List<Object> b;

    static {
        new c0(10).a = false;
    }

    public c0(int i) {
        this((ArrayList<Object>) new ArrayList(i));
    }

    public d0 a() {
        return this.a ? new n1(this) : this;
    }

    public void add(int i, Object obj) {
        e();
        this.b.add(i, (String) obj);
        this.modCount++;
    }

    public boolean addAll(Collection<? extends String> collection) {
        return addAll(this.b.size(), collection);
    }

    public y.j b(int i) {
        if (i >= this.b.size()) {
            ArrayList arrayList = new ArrayList(i);
            arrayList.addAll(this.b);
            return new c0((ArrayList<Object>) arrayList);
        }
        throw new IllegalArgumentException();
    }

    public List<?> c() {
        return Collections.unmodifiableList(this.b);
    }

    public void clear() {
        e();
        this.b.clear();
        this.modCount++;
    }

    public Object get(int i) {
        String str;
        Object obj = this.b.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof i) {
            i iVar = (i) obj;
            str = iVar.i();
            if (iVar.e()) {
                this.b.set(i, str);
            }
        } else {
            byte[] bArr = (byte[]) obj;
            str = new String(bArr, y.a);
            if (q1.a(bArr)) {
                this.b.set(i, str);
            }
        }
        return str;
    }

    public Object remove(int i) {
        e();
        Object remove = this.b.remove(i);
        this.modCount++;
        return a(remove);
    }

    public Object set(int i, Object obj) {
        e();
        return a(this.b.set(i, (String) obj));
    }

    public int size() {
        return this.b.size();
    }

    public c0(ArrayList<Object> arrayList) {
        this.b = arrayList;
    }

    public void a(i iVar) {
        e();
        this.b.add(iVar);
        this.modCount++;
    }

    public boolean addAll(int i, Collection<? extends String> collection) {
        e();
        if (collection instanceof d0) {
            collection = ((d0) collection).c();
        }
        boolean addAll = this.b.addAll(i, collection);
        this.modCount++;
        return addAll;
    }

    public Object a(int i) {
        return this.b.get(i);
    }

    public static String a(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof i) {
            return ((i) obj).i();
        }
        return new String((byte[]) obj, y.a);
    }
}
