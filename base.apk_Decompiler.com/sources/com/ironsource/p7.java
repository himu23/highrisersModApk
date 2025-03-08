package com.ironsource;

import java.util.HashMap;
import java.util.Map;

public class p7 {
    private final boolean a;
    private String b;
    private String c;
    private boolean d;
    private v5 e;
    private Map<String, String> f;
    private r9 g;
    private boolean h;

    p7(String str, String str2, boolean z, boolean z2, boolean z3, Map<String, String> map, r9 r9Var, v5 v5Var) {
        this.b = str;
        this.c = str2;
        this.a = z;
        this.d = z2;
        this.f = map;
        this.g = r9Var;
        this.e = v5Var;
        this.h = z3;
    }

    public Map<String, String> a() {
        HashMap hashMap = new HashMap();
        hashMap.put("instanceId", this.b);
        hashMap.put("instanceName", this.c);
        hashMap.put("rewarded", Boolean.toString(this.a));
        hashMap.put("inAppBidding", Boolean.toString(this.d));
        hashMap.put("isOneFlow", Boolean.toString(this.h));
        hashMap.put(m2.q, String.valueOf(2));
        v5 v5Var = this.e;
        String str = "0";
        hashMap.put("width", v5Var != null ? Integer.toString(v5Var.c()) : str);
        v5 v5Var2 = this.e;
        if (v5Var2 != null) {
            str = Integer.toString(v5Var2.a());
        }
        hashMap.put("height", str);
        v5 v5Var3 = this.e;
        hashMap.put("label", v5Var3 != null ? v5Var3.b() : "");
        hashMap.put(m2.u, Boolean.toString(g()));
        Map<String, String> map = this.f;
        if (map != null) {
            hashMap.putAll(map);
        }
        return hashMap;
    }

    public final r9 b() {
        return this.g;
    }

    public Map<String, String> c() {
        return this.f;
    }

    public String d() {
        return this.b;
    }

    public String e() {
        return this.c;
    }

    public v5 f() {
        return this.e;
    }

    public boolean g() {
        return f() != null && f().d();
    }

    public boolean h() {
        return this.d;
    }

    public boolean i() {
        return h() || j();
    }

    public boolean j() {
        return this.h;
    }

    public boolean k() {
        return this.a;
    }
}
