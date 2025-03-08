package com.fyber.inneractive.sdk.protobuf;

public final class l0 {
    public static final j0 a;
    public static final j0 b = new k0();

    static {
        j0 j0Var;
        try {
            j0Var = (j0) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            j0Var = null;
        }
        a = j0Var;
    }
}
