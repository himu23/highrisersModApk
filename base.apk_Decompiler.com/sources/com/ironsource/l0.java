package com.ironsource;

import android.text.TextUtils;
import java.util.HashSet;

public class l0 {
    private boolean a = false;
    private HashSet<String> b = new HashSet<>();
    private String c;
    private String d;
    private boolean e = false;
    private int f;
    private boolean g = true;

    public int a() {
        return this.f;
    }

    public void a(int i) {
        this.f = i;
    }

    public void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.b.add(str);
        }
    }

    public void a(boolean z) {
        this.a = z;
    }

    public HashSet<String> b() {
        return this.b;
    }

    public void b(String str) {
        this.d = str;
    }

    public void b(boolean z) {
        this.g = z;
    }

    public String c() {
        return this.d;
    }

    public void c(String str) {
        this.c = str;
    }

    public void c(boolean z) {
        this.e = z;
    }

    public String d() {
        return this.c;
    }

    public boolean e() {
        return this.e;
    }

    public boolean f() {
        return this.a;
    }

    public boolean g() {
        return this.g;
    }
}
