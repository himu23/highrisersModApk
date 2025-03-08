package com.ironsource;

import com.ironsource.mediationsdk.utils.a;
import java.util.ArrayList;
import java.util.Iterator;

public class k1 {
    private static final int q = 0;
    private m0 a;
    private int b;
    private long c;
    private boolean d;
    private ArrayList<m1> e;
    private m1 f;
    private int g;
    private int h;
    private a i;
    private boolean j;
    private boolean k;
    private long l;
    private boolean m;
    private boolean n;
    private boolean o;
    private boolean p;

    public k1() {
        this.a = new m0();
        this.e = new ArrayList<>();
    }

    public k1(int i2, long j2, boolean z, m0 m0Var, int i3, a aVar, int i4, boolean z2, boolean z3, long j3, boolean z4, boolean z5, boolean z6, boolean z7) {
        this.e = new ArrayList<>();
        this.b = i2;
        this.c = j2;
        this.d = z;
        this.a = m0Var;
        this.g = i3;
        this.h = i4;
        this.i = aVar;
        this.j = z2;
        this.k = z3;
        this.l = j3;
        this.m = z4;
        this.n = z5;
        this.o = z6;
        this.p = z7;
    }

    public int a() {
        return this.b;
    }

    public m1 a(String str) {
        Iterator<m1> it = this.e.iterator();
        while (it.hasNext()) {
            m1 next = it.next();
            if (next.getPlacementName().equals(str)) {
                return next;
            }
        }
        return null;
    }

    public void a(m1 m1Var) {
        if (m1Var != null) {
            this.e.add(m1Var);
            if (this.f == null || m1Var.isPlacementId(0)) {
                this.f = m1Var;
            }
        }
    }

    public long b() {
        return this.c;
    }

    public boolean c() {
        return this.d;
    }

    public a d() {
        return this.i;
    }

    public boolean e() {
        return this.k;
    }

    public long f() {
        return this.l;
    }

    public int g() {
        return this.h;
    }

    public m0 h() {
        return this.a;
    }

    public int i() {
        return this.g;
    }

    public m1 j() {
        Iterator<m1> it = this.e.iterator();
        while (it.hasNext()) {
            m1 next = it.next();
            if (next.isDefault()) {
                return next;
            }
        }
        return this.f;
    }

    public boolean k() {
        return this.j;
    }

    public boolean l() {
        return this.m;
    }

    public boolean m() {
        return this.p;
    }

    public boolean n() {
        return this.o;
    }

    public boolean o() {
        return this.n;
    }

    public String toString() {
        return "BannerConfigurations{parallelLoad=" + this.b + ", bidderExclusive=" + this.d + '}';
    }
}
