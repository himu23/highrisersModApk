package com.fyber.inneractive.sdk.protobuf;

import com.fyber.inneractive.sdk.protobuf.y;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public final class i0<K, V> extends LinkedHashMap<K, V> {
    public static final i0 b;
    public boolean a = true;

    static {
        i0 i0Var = new i0();
        b = i0Var;
        i0Var.a = false;
    }

    public i0() {
    }

    public static int a(Object obj) {
        if (obj instanceof byte[]) {
            Charset charset = y.a;
            int i = r0;
            for (byte b2 : (byte[]) obj) {
                i = (i * 31) + b2;
            }
            if (i == 0) {
                return 1;
            }
            return i;
        } else if (!(obj instanceof y.c)) {
            return obj.hashCode();
        } else {
            throw new UnsupportedOperationException();
        }
    }

    public void clear() {
        a();
        super.clear();
    }

    public Set<Map.Entry<K, V>> entrySet() {
        return isEmpty() ? Collections.emptySet() : super.entrySet();
    }

    public boolean equals(Object obj) {
        boolean z;
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (this != map) {
                if (size() == map.size()) {
                    for (Map.Entry entry : entrySet()) {
                        if (map.containsKey(entry.getKey())) {
                            Object value = entry.getValue();
                            Object obj2 = map.get(entry.getKey());
                            if (!(value instanceof byte[]) || !(obj2 instanceof byte[])) {
                                z = value.equals(obj2);
                                continue;
                            } else {
                                z = Arrays.equals((byte[]) value, (byte[]) obj2);
                                continue;
                            }
                            if (!z) {
                            }
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i = 0;
        for (Map.Entry entry : entrySet()) {
            i += a(entry.getValue()) ^ a(entry.getKey());
        }
        return i;
    }

    public V put(K k, V v) {
        a();
        Charset charset = y.a;
        k.getClass();
        v.getClass();
        return super.put(k, v);
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        a();
        for (Object next : map.keySet()) {
            Charset charset = y.a;
            next.getClass();
            map.get(next).getClass();
        }
        super.putAll(map);
    }

    public V remove(Object obj) {
        a();
        return super.remove(obj);
    }

    public i0(Map<K, V> map) {
        super(map);
    }

    public final void a() {
        if (!this.a) {
            throw new UnsupportedOperationException();
        }
    }
}
