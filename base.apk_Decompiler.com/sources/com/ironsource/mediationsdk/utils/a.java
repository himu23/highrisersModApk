package com.ironsource.mediationsdk.utils;

import android.text.TextUtils;
import java.util.ArrayList;

public class a {
    private boolean a;
    private String b;
    private String c;
    private String d;
    private int e;
    private int f;
    private int g;
    private long h;
    private long i;
    private long j;
    private long k;
    private long l;
    private boolean m;
    private ArrayList<String> n;
    private boolean o;
    private boolean p;
    private int q;
    private boolean r;

    public a() {
        this.b = "";
        this.c = "";
        this.d = "";
        this.i = 0;
        this.j = 0;
        this.k = 0;
        this.l = 0;
        this.m = true;
        this.n = new ArrayList<>();
        this.g = 0;
        this.o = false;
        this.p = false;
        this.q = 1;
    }

    a(String str, String str2, String str3, int i2, int i3, long j2, long j3, long j4, long j5, long j6, boolean z, int i4, boolean z2, boolean z3, boolean z4, int i5, boolean z5) {
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = i2;
        this.f = i3;
        this.h = j2;
        this.a = z4;
        this.i = j3;
        this.j = j4;
        this.k = j5;
        this.l = j6;
        this.m = z;
        this.g = i4;
        this.n = new ArrayList<>();
        this.o = z2;
        this.p = z3;
        this.q = i5;
        this.r = z5;
    }

    public String a() {
        return this.b;
    }

    public String a(boolean z) {
        return z ? this.d : this.c;
    }

    public void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.n.add(str);
        }
    }

    public long b() {
        return this.j;
    }

    public int c() {
        return this.f;
    }

    public int d() {
        return this.q;
    }

    public boolean e() {
        return this.m;
    }

    public ArrayList<String> f() {
        return this.n;
    }

    public int g() {
        return this.e;
    }

    public boolean h() {
        return this.a;
    }

    public int i() {
        return this.g;
    }

    public long j() {
        return this.k;
    }

    public long k() {
        return this.i;
    }

    public long l() {
        return this.l;
    }

    public long m() {
        return this.h;
    }

    public boolean n() {
        return this.o;
    }

    public boolean o() {
        return this.p;
    }

    public boolean p() {
        return this.r;
    }
}
