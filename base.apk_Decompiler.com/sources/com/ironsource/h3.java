package com.ironsource;

import java.util.HashMap;
import java.util.Map;

public class h3 {
    public static final int i = 0;
    public static final int j = 1;
    public static final int k = 2;
    public static final int l = 3;
    public static final int m = -1;
    private String a;
    private String b;
    private int c;
    private Map<String, String> d;
    private int e;
    private boolean f;
    private r9 g;
    private p7 h;

    public h3(p7 p7Var) {
        this(p7Var.d(), p7Var.e(), p7Var.a(), p7Var.b());
        this.h = p7Var;
    }

    public h3(String str, String str2, Map<String, String> map, r9 r9Var) {
        this.c = -1;
        this.b = str;
        this.a = str2;
        this.d = map;
        this.g = r9Var;
        this.e = 0;
        this.f = false;
        this.h = null;
    }

    public void a() {
        this.g = null;
        Map<String, String> map = this.d;
        if (map != null) {
            map.clear();
        }
        this.d = null;
    }

    public void a(boolean z) {
        this.f = z;
    }

    public boolean a(int i2) {
        return this.c == i2;
    }

    public Map<String, String> b() {
        HashMap hashMap = new HashMap();
        hashMap.put("demandSourceId", this.b);
        hashMap.put("demandSourceName", this.a);
        Map<String, String> map = this.d;
        if (map != null) {
            hashMap.putAll(map);
        }
        return hashMap;
    }

    public synchronized void b(int i2) {
        this.e = i2;
    }

    public p7 c() {
        return this.h;
    }

    public void c(int i2) {
        this.c = i2;
    }

    public boolean d() {
        return this.f;
    }

    public int e() {
        return this.e;
    }

    public String f() {
        return this.a;
    }

    public Map<String, String> g() {
        return this.d;
    }

    public String h() {
        return this.b;
    }

    public r9 i() {
        return this.g;
    }

    public int j() {
        return this.c;
    }

    public boolean k() {
        Map<String, String> map = this.d;
        if (map == null || !map.containsKey("rewarded")) {
            return false;
        }
        return Boolean.parseBoolean(this.d.get("rewarded"));
    }
}
