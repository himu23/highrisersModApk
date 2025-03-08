package com.fyber.inneractive.sdk.protobuf;

public final class v0 {
    public static final t0 a;
    public static final t0 b = new u0();

    static {
        t0 t0Var;
        try {
            t0Var = (t0) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            t0Var = null;
        }
        a = t0Var;
    }
}
