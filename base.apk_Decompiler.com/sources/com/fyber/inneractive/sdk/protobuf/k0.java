package com.fyber.inneractive.sdk.protobuf;

import com.fyber.inneractive.sdk.protobuf.h0;
import java.util.Iterator;
import java.util.Map;

public class k0 implements j0 {
    public Map<?, ?> a(Object obj) {
        return (i0) obj;
    }

    public Object b(Object obj) {
        i0 i0Var = i0.b;
        return i0Var.isEmpty() ? new i0() : new i0(i0Var);
    }

    public Map<?, ?> c(Object obj) {
        return (i0) obj;
    }

    public boolean d(Object obj) {
        return !((i0) obj).a;
    }

    public Object e(Object obj) {
        ((i0) obj).a = false;
        return obj;
    }

    public h0.a<?, ?> f(Object obj) {
        ((h0) obj).getClass();
        return null;
    }

    public Object a(Object obj, Object obj2) {
        i0 i0Var = (i0) obj;
        i0 i0Var2 = (i0) obj2;
        if (!i0Var2.isEmpty()) {
            if (!i0Var.a) {
                i0Var = i0Var.isEmpty() ? new i0() : new i0(i0Var);
            }
            i0Var.a();
            if (!i0Var2.isEmpty()) {
                i0Var.putAll(i0Var2);
            }
        }
        return i0Var;
    }

    public int a(int i, Object obj, Object obj2) {
        i0 i0Var = (i0) obj;
        h0 h0Var = (h0) obj2;
        if (i0Var.isEmpty()) {
            return 0;
        }
        Iterator it = i0Var.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        h0Var.getClass();
        l.b(i);
        throw null;
    }
}
