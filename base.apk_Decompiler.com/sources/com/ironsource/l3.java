package com.ironsource;

import android.content.Context;

public class l3 {
    private static l3 g;
    private String a = m3.k();
    private String b = m3.j();
    private String c = m3.l();
    private String d = m3.c();
    private int e = m3.b();
    private String f;

    private l3(Context context) {
        this.f = m3.x(context);
    }

    public static l3 b(Context context) {
        if (g == null) {
            g = new l3(context);
        }
        return g;
    }

    public static void g() {
        g = null;
    }

    public float a(Context context) {
        return m3.B(context);
    }

    public int a() {
        return this.e;
    }

    public String b() {
        return this.f;
    }

    public String c() {
        return this.b;
    }

    public String d() {
        return this.a;
    }

    public String e() {
        return this.c;
    }

    public String f() {
        return this.d;
    }
}
