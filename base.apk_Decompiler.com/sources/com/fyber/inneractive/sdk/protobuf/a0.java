package com.fyber.inneractive.sdk.protobuf;

import java.util.Iterator;
import java.util.Map;

public class a0 extends b0 {

    public static class a<K> implements Map.Entry<K, Object> {
        public Map.Entry<K, a0> a;

        public a(Map.Entry<K, a0> entry) {
            this.a = entry;
        }

        public K getKey() {
            return this.a.getKey();
        }

        public Object getValue() {
            a0 value = this.a.getValue();
            if (value == null) {
                return null;
            }
            return value.a((o0) null);
        }

        public Object setValue(Object obj) {
            if (obj instanceof o0) {
                a0 value = this.a.getValue();
                o0 o0Var = value.a;
                value.b = null;
                value.a = (o0) obj;
                return o0Var;
            }
            throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
        }
    }

    public static class b<K> implements Iterator<Map.Entry<K, Object>> {
        public Iterator<Map.Entry<K, Object>> a;

        public b(Iterator<Map.Entry<K, Object>> it) {
            this.a = it;
        }

        public boolean hasNext() {
            return this.a.hasNext();
        }

        public Object next() {
            Map.Entry next = this.a.next();
            return next.getValue() instanceof a0 ? new a(next) : next;
        }

        public void remove() {
            this.a.remove();
        }
    }

    public boolean equals(Object obj) {
        return a((o0) null).equals(obj);
    }

    public int hashCode() {
        return a((o0) null).hashCode();
    }

    public String toString() {
        return a((o0) null).toString();
    }
}
