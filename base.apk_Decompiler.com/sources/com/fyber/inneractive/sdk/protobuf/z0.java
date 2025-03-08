package com.fyber.inneractive.sdk.protobuf;

import java.nio.charset.Charset;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public final class z0 {
    public static final z0 c = new z0();
    public final e1 a = new g0();
    public final ConcurrentMap<Class<?>, d1<?>> b = new ConcurrentHashMap();

    public <T> d1<T> a(Class<T> cls) {
        d1<T> d1Var;
        Class<?> cls2;
        Charset charset = y.a;
        if (cls != null) {
            d1<T> d1Var2 = (d1) this.b.get(cls);
            if (d1Var2 != null) {
                return d1Var2;
            }
            g0 g0Var = (g0) this.a;
            g0Var.getClass();
            Class<?> cls3 = f1.a;
            if (GeneratedMessageLite.class.isAssignableFrom(cls) || (cls2 = f1.a) == null || cls2.isAssignableFrom(cls)) {
                m0 b2 = g0Var.a.b(cls);
                if (b2.c()) {
                    if (GeneratedMessageLite.class.isAssignableFrom(cls)) {
                        k1<?, ?> k1Var = f1.d;
                        r<?> rVar = t.a;
                        d1Var = new s0<>(k1Var, t.a, b2.b());
                    } else {
                        k1<?, ?> k1Var2 = f1.b;
                        r<?> rVar2 = t.b;
                        if (rVar2 != null) {
                            d1Var = new s0<>(k1Var2, rVar2, b2.b());
                        } else {
                            throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
                        }
                    }
                } else if (GeneratedMessageLite.class.isAssignableFrom(cls)) {
                    if (b2.a() == y0.PROTO2) {
                        t0 t0Var = v0.b;
                        e0 e0Var = e0.b;
                        k1<?, ?> k1Var3 = f1.d;
                        r<?> rVar3 = t.a;
                        d1Var = r0.a(b2, t0Var, e0Var, (k1) k1Var3, (r) t.a, l0.b);
                    } else {
                        d1Var = r0.a(b2, v0.b, e0.b, (k1) f1.d, (r) null, l0.b);
                    }
                } else if (b2.a() == y0.PROTO2) {
                    t0 t0Var2 = v0.a;
                    e0 e0Var2 = e0.a;
                    k1<?, ?> k1Var4 = f1.b;
                    r<?> rVar4 = t.b;
                    if (rVar4 != null) {
                        d1Var = r0.a(b2, t0Var2, e0Var2, (k1) k1Var4, (r) rVar4, l0.a);
                    } else {
                        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
                    }
                } else {
                    d1Var = r0.a(b2, v0.a, e0.a, (k1) f1.c, (r) null, l0.a);
                }
                d1<T> putIfAbsent = this.b.putIfAbsent(cls, d1Var);
                return putIfAbsent != null ? putIfAbsent : d1Var;
            }
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
        throw new NullPointerException("messageType");
    }
}
