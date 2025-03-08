package com.fyber.inneractive.sdk.network;

public class x {
    public static final x c = new x();
    public final g a = new i();
    public g b;

    public static x a() {
        return c;
    }

    public g b() {
        String str;
        if (this.b == null) {
            try {
                str = System.getProperty("fyber.marketplace.http_executor_stack_name");
            } catch (Throwable unused) {
                str = "hurl";
            }
            if (str != null && str.equals("okhttp")) {
                try {
                    Class.forName("okhttp3.OkHttpClient");
                    this.b = new w0();
                } catch (ClassNotFoundException unused2) {
                }
            }
        }
        g gVar = this.b;
        return gVar != null ? gVar : this.a;
    }
}
