package com.fyber.inneractive.sdk.protobuf;

import com.fyber.inneractive.sdk.protobuf.h0;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public final class k implements c1 {
    public final j a;
    public int b;
    public int c;
    public int d = 0;

    public k(j jVar) {
        j jVar2 = (j) y.a(jVar, "input");
        this.a = jVar2;
        jVar2.d = this;
    }

    public <T> T a(Class<T> cls, q qVar) throws IOException {
        b(3);
        return c(z0.c.a(cls), qVar);
    }

    public final void b(int i) throws IOException {
        int i2 = this.b;
        int i3 = r1.a;
        if ((i2 & 7) != i) {
            throw z.d();
        }
    }

    public int d() throws IOException {
        b(0);
        return this.a.k();
    }

    public int e() {
        return this.b;
    }

    public long f() throws IOException {
        b(0);
        return this.a.v();
    }

    public long g() throws IOException {
        b(1);
        return this.a.i();
    }

    public double h() throws IOException {
        b(1);
        return this.a.f();
    }

    public boolean i() throws IOException {
        int i;
        if (this.a.c() || (i = this.b) == this.c) {
            return false;
        }
        return this.a.e(i);
    }

    public int j() throws IOException {
        b(0);
        return this.a.p();
    }

    public float k() throws IOException {
        b(5);
        return this.a.j();
    }

    public long l() throws IOException {
        b(0);
        return this.a.q();
    }

    public int m() throws IOException {
        b(5);
        return this.a.n();
    }

    public String n() throws IOException {
        b(2);
        return this.a.r();
    }

    public long o() throws IOException {
        b(0);
        return this.a.l();
    }

    public String p() throws IOException {
        b(2);
        return this.a.s();
    }

    public int q() throws IOException {
        b(5);
        return this.a.h();
    }

    public boolean r() throws IOException {
        b(0);
        return this.a.d();
    }

    public long t() throws IOException {
        b(1);
        return this.a.o();
    }

    public final <T> T c(d1<T> d1Var, q qVar) throws IOException {
        int i = this.c;
        int i2 = this.b;
        int i3 = r1.a;
        this.c = r1.a(i2 >>> 3, 4);
        try {
            T a2 = d1Var.a();
            d1Var.a(a2, this, qVar);
            d1Var.c(a2);
            if (this.b == this.c) {
                return a2;
            }
            throw z.g();
        } finally {
            this.c = i;
        }
    }

    public void e(List<Integer> list) throws IOException {
        int t;
        int t2;
        if (list instanceof x) {
            x xVar = (x) list;
            int i = this.b;
            int i2 = r1.a;
            int i3 = i & 7;
            if (i3 == 2) {
                int u = this.a.u();
                c(u);
                int b2 = this.a.b() + u;
                do {
                    xVar.c(this.a.h());
                } while (this.a.b() < b2);
            } else if (i3 == 5) {
                do {
                    xVar.c(this.a.h());
                    if (!this.a.c()) {
                        t2 = this.a.t();
                    } else {
                        return;
                    }
                } while (t2 == this.b);
                this.d = t2;
            } else {
                throw z.d();
            }
        } else {
            int i4 = this.b;
            int i5 = r1.a;
            int i6 = i4 & 7;
            if (i6 == 2) {
                int u2 = this.a.u();
                c(u2);
                int b3 = this.a.b() + u2;
                do {
                    list.add(Integer.valueOf(this.a.h()));
                } while (this.a.b() < b3);
            } else if (i6 == 5) {
                do {
                    list.add(Integer.valueOf(this.a.h()));
                    if (!this.a.c()) {
                        t = this.a.t();
                    } else {
                        return;
                    }
                } while (t == this.b);
                this.d = t;
            } else {
                throw z.d();
            }
        }
    }

    public <T> T b(Class<T> cls, q qVar) throws IOException {
        b(2);
        return d(z0.c.a(cls), qVar);
    }

    public final <T> T d(d1<T> d1Var, q qVar) throws IOException {
        int u = this.a.u();
        j jVar = this.a;
        if (jVar.a < jVar.b) {
            int d2 = jVar.d(u);
            T a2 = d1Var.a();
            this.a.a++;
            d1Var.a(a2, this, qVar);
            d1Var.c(a2);
            this.a.a(0);
            j jVar2 = this.a;
            jVar2.a--;
            jVar2.c(d2);
            return a2;
        }
        throw z.h();
    }

    public void f(List<Integer> list) throws IOException {
        int t;
        int t2;
        if (list instanceof x) {
            x xVar = (x) list;
            int i = this.b;
            int i2 = r1.a;
            int i3 = i & 7;
            if (i3 == 2) {
                int u = this.a.u();
                c(u);
                int b2 = this.a.b() + u;
                do {
                    xVar.c(this.a.n());
                } while (this.a.b() < b2);
            } else if (i3 == 5) {
                do {
                    xVar.c(this.a.n());
                    if (!this.a.c()) {
                        t2 = this.a.t();
                    } else {
                        return;
                    }
                } while (t2 == this.b);
                this.d = t2;
            } else {
                throw z.d();
            }
        } else {
            int i4 = this.b;
            int i5 = r1.a;
            int i6 = i4 & 7;
            if (i6 == 2) {
                int u2 = this.a.u();
                c(u2);
                int b3 = this.a.b() + u2;
                do {
                    list.add(Integer.valueOf(this.a.n()));
                } while (this.a.b() < b3);
            } else if (i6 == 5) {
                do {
                    list.add(Integer.valueOf(this.a.n()));
                    if (!this.a.c()) {
                        t = this.a.t();
                    } else {
                        return;
                    }
                } while (t == this.b);
                this.d = t;
            } else {
                throw z.d();
            }
        }
    }

    public void g(List<Long> list) throws IOException {
        int t;
        int t2;
        if (list instanceof f0) {
            f0 f0Var = (f0) list;
            int i = this.b;
            int i2 = r1.a;
            int i3 = i & 7;
            if (i3 == 0) {
                do {
                    f0Var.a(this.a.q());
                    if (!this.a.c()) {
                        t2 = this.a.t();
                    } else {
                        return;
                    }
                } while (t2 == this.b);
                this.d = t2;
            } else if (i3 == 2) {
                int b2 = this.a.b() + this.a.u();
                do {
                    f0Var.a(this.a.q());
                } while (this.a.b() < b2);
                a(b2);
            } else {
                throw z.d();
            }
        } else {
            int i4 = this.b;
            int i5 = r1.a;
            int i6 = i4 & 7;
            if (i6 == 0) {
                do {
                    list.add(Long.valueOf(this.a.q()));
                    if (!this.a.c()) {
                        t = this.a.t();
                    } else {
                        return;
                    }
                } while (t == this.b);
                this.d = t;
            } else if (i6 == 2) {
                int b3 = this.a.b() + this.a.u();
                do {
                    list.add(Long.valueOf(this.a.q()));
                } while (this.a.b() < b3);
                a(b3);
            } else {
                throw z.d();
            }
        }
    }

    public void h(List<i> list) throws IOException {
        int t;
        int i = this.b;
        int i2 = r1.a;
        if ((i & 7) == 2) {
            do {
                list.add(a());
                if (!this.a.c()) {
                    t = this.a.t();
                } else {
                    return;
                }
            } while (t == this.b);
            this.d = t;
            return;
        }
        throw z.d();
    }

    public void j(List<Double> list) throws IOException {
        int t;
        int t2;
        if (list instanceof n) {
            n nVar = (n) list;
            int i = this.b;
            int i2 = r1.a;
            int i3 = i & 7;
            if (i3 == 1) {
                do {
                    nVar.a(this.a.f());
                    if (!this.a.c()) {
                        t2 = this.a.t();
                    } else {
                        return;
                    }
                } while (t2 == this.b);
                this.d = t2;
            } else if (i3 == 2) {
                int u = this.a.u();
                d(u);
                int b2 = this.a.b() + u;
                do {
                    nVar.a(this.a.f());
                } while (this.a.b() < b2);
            } else {
                throw z.d();
            }
        } else {
            int i4 = this.b;
            int i5 = r1.a;
            int i6 = i4 & 7;
            if (i6 == 1) {
                do {
                    list.add(Double.valueOf(this.a.f()));
                    if (!this.a.c()) {
                        t = this.a.t();
                    } else {
                        return;
                    }
                } while (t == this.b);
                this.d = t;
            } else if (i6 == 2) {
                int u2 = this.a.u();
                d(u2);
                int b3 = this.a.b() + u2;
                do {
                    list.add(Double.valueOf(this.a.f()));
                } while (this.a.b() < b3);
            } else {
                throw z.d();
            }
        }
    }

    public void k(List<Long> list) throws IOException {
        int t;
        int t2;
        if (list instanceof f0) {
            f0 f0Var = (f0) list;
            int i = this.b;
            int i2 = r1.a;
            int i3 = i & 7;
            if (i3 == 0) {
                do {
                    f0Var.a(this.a.l());
                    if (!this.a.c()) {
                        t2 = this.a.t();
                    } else {
                        return;
                    }
                } while (t2 == this.b);
                this.d = t2;
            } else if (i3 == 2) {
                int b2 = this.a.b() + this.a.u();
                do {
                    f0Var.a(this.a.l());
                } while (this.a.b() < b2);
                a(b2);
            } else {
                throw z.d();
            }
        } else {
            int i4 = this.b;
            int i5 = r1.a;
            int i6 = i4 & 7;
            if (i6 == 0) {
                do {
                    list.add(Long.valueOf(this.a.l()));
                    if (!this.a.c()) {
                        t = this.a.t();
                    } else {
                        return;
                    }
                } while (t == this.b);
                this.d = t;
            } else if (i6 == 2) {
                int b3 = this.a.b() + this.a.u();
                do {
                    list.add(Long.valueOf(this.a.l()));
                } while (this.a.b() < b3);
                a(b3);
            } else {
                throw z.d();
            }
        }
    }

    public void l(List<Boolean> list) throws IOException {
        int t;
        int t2;
        if (list instanceof g) {
            g gVar = (g) list;
            int i = this.b;
            int i2 = r1.a;
            int i3 = i & 7;
            if (i3 == 0) {
                do {
                    gVar.a(this.a.d());
                    if (!this.a.c()) {
                        t2 = this.a.t();
                    } else {
                        return;
                    }
                } while (t2 == this.b);
                this.d = t2;
            } else if (i3 == 2) {
                int b2 = this.a.b() + this.a.u();
                do {
                    gVar.a(this.a.d());
                } while (this.a.b() < b2);
                a(b2);
            } else {
                throw z.d();
            }
        } else {
            int i4 = this.b;
            int i5 = r1.a;
            int i6 = i4 & 7;
            if (i6 == 0) {
                do {
                    list.add(Boolean.valueOf(this.a.d()));
                    if (!this.a.c()) {
                        t = this.a.t();
                    } else {
                        return;
                    }
                } while (t == this.b);
                this.d = t;
            } else if (i6 == 2) {
                int b3 = this.a.b() + this.a.u();
                do {
                    list.add(Boolean.valueOf(this.a.d()));
                } while (this.a.b() < b3);
                a(b3);
            } else {
                throw z.d();
            }
        }
    }

    public void m(List<Long> list) throws IOException {
        int t;
        int t2;
        if (list instanceof f0) {
            f0 f0Var = (f0) list;
            int i = this.b;
            int i2 = r1.a;
            int i3 = i & 7;
            if (i3 == 1) {
                do {
                    f0Var.a(this.a.o());
                    if (!this.a.c()) {
                        t2 = this.a.t();
                    } else {
                        return;
                    }
                } while (t2 == this.b);
                this.d = t2;
            } else if (i3 == 2) {
                int u = this.a.u();
                d(u);
                int b2 = this.a.b() + u;
                do {
                    f0Var.a(this.a.o());
                } while (this.a.b() < b2);
            } else {
                throw z.d();
            }
        } else {
            int i4 = this.b;
            int i5 = r1.a;
            int i6 = i4 & 7;
            if (i6 == 1) {
                do {
                    list.add(Long.valueOf(this.a.o()));
                    if (!this.a.c()) {
                        t = this.a.t();
                    } else {
                        return;
                    }
                } while (t == this.b);
                this.d = t;
            } else if (i6 == 2) {
                int u2 = this.a.u();
                d(u2);
                int b3 = this.a.b() + u2;
                do {
                    list.add(Long.valueOf(this.a.o()));
                } while (this.a.b() < b3);
            } else {
                throw z.d();
            }
        }
    }

    public void n(List<Long> list) throws IOException {
        int t;
        int t2;
        if (list instanceof f0) {
            f0 f0Var = (f0) list;
            int i = this.b;
            int i2 = r1.a;
            int i3 = i & 7;
            if (i3 == 1) {
                do {
                    f0Var.a(this.a.i());
                    if (!this.a.c()) {
                        t2 = this.a.t();
                    } else {
                        return;
                    }
                } while (t2 == this.b);
                this.d = t2;
            } else if (i3 == 2) {
                int u = this.a.u();
                d(u);
                int b2 = this.a.b() + u;
                do {
                    f0Var.a(this.a.i());
                } while (this.a.b() < b2);
            } else {
                throw z.d();
            }
        } else {
            int i4 = this.b;
            int i5 = r1.a;
            int i6 = i4 & 7;
            if (i6 == 1) {
                do {
                    list.add(Long.valueOf(this.a.i()));
                    if (!this.a.c()) {
                        t = this.a.t();
                    } else {
                        return;
                    }
                } while (t == this.b);
                this.d = t;
            } else if (i6 == 2) {
                int u2 = this.a.u();
                d(u2);
                int b3 = this.a.b() + u2;
                do {
                    list.add(Long.valueOf(this.a.i()));
                } while (this.a.b() < b3);
            } else {
                throw z.d();
            }
        }
    }

    public void o(List<Integer> list) throws IOException {
        int t;
        int t2;
        if (list instanceof x) {
            x xVar = (x) list;
            int i = this.b;
            int i2 = r1.a;
            int i3 = i & 7;
            if (i3 == 0) {
                do {
                    xVar.c(this.a.k());
                    if (!this.a.c()) {
                        t2 = this.a.t();
                    } else {
                        return;
                    }
                } while (t2 == this.b);
                this.d = t2;
            } else if (i3 == 2) {
                int b2 = this.a.b() + this.a.u();
                do {
                    xVar.c(this.a.k());
                } while (this.a.b() < b2);
                a(b2);
            } else {
                throw z.d();
            }
        } else {
            int i4 = this.b;
            int i5 = r1.a;
            int i6 = i4 & 7;
            if (i6 == 0) {
                do {
                    list.add(Integer.valueOf(this.a.k()));
                    if (!this.a.c()) {
                        t = this.a.t();
                    } else {
                        return;
                    }
                } while (t == this.b);
                this.d = t;
            } else if (i6 == 2) {
                int b3 = this.a.b() + this.a.u();
                do {
                    list.add(Integer.valueOf(this.a.k()));
                } while (this.a.b() < b3);
                a(b3);
            } else {
                throw z.d();
            }
        }
    }

    public void p(List<Integer> list) throws IOException {
        int t;
        int t2;
        if (list instanceof x) {
            x xVar = (x) list;
            int i = this.b;
            int i2 = r1.a;
            int i3 = i & 7;
            if (i3 == 0) {
                do {
                    xVar.c(this.a.g());
                    if (!this.a.c()) {
                        t2 = this.a.t();
                    } else {
                        return;
                    }
                } while (t2 == this.b);
                this.d = t2;
            } else if (i3 == 2) {
                int b2 = this.a.b() + this.a.u();
                do {
                    xVar.c(this.a.g());
                } while (this.a.b() < b2);
                a(b2);
            } else {
                throw z.d();
            }
        } else {
            int i4 = this.b;
            int i5 = r1.a;
            int i6 = i4 & 7;
            if (i6 == 0) {
                do {
                    list.add(Integer.valueOf(this.a.g()));
                    if (!this.a.c()) {
                        t = this.a.t();
                    } else {
                        return;
                    }
                } while (t == this.b);
                this.d = t;
            } else if (i6 == 2) {
                int b3 = this.a.b() + this.a.u();
                do {
                    list.add(Integer.valueOf(this.a.g()));
                } while (this.a.b() < b3);
                a(b3);
            } else {
                throw z.d();
            }
        }
    }

    public void q(List<String> list) throws IOException {
        a(list, false);
    }

    public <T> T a(d1<T> d1Var, q qVar) throws IOException {
        b(3);
        return c(d1Var, qVar);
    }

    public void i(List<Integer> list) throws IOException {
        int t;
        int t2;
        if (list instanceof x) {
            x xVar = (x) list;
            int i = this.b;
            int i2 = r1.a;
            int i3 = i & 7;
            if (i3 == 0) {
                do {
                    xVar.c(this.a.u());
                    if (!this.a.c()) {
                        t2 = this.a.t();
                    } else {
                        return;
                    }
                } while (t2 == this.b);
                this.d = t2;
            } else if (i3 == 2) {
                int b2 = this.a.b() + this.a.u();
                do {
                    xVar.c(this.a.u());
                } while (this.a.b() < b2);
                a(b2);
            } else {
                throw z.d();
            }
        } else {
            int i4 = this.b;
            int i5 = r1.a;
            int i6 = i4 & 7;
            if (i6 == 0) {
                do {
                    list.add(Integer.valueOf(this.a.u()));
                    if (!this.a.c()) {
                        t = this.a.t();
                    } else {
                        return;
                    }
                } while (t == this.b);
                this.d = t;
            } else if (i6 == 2) {
                int b3 = this.a.b() + this.a.u();
                do {
                    list.add(Integer.valueOf(this.a.u()));
                } while (this.a.b() < b3);
                a(b3);
            } else {
                throw z.d();
            }
        }
    }

    public int s() throws IOException {
        int i = this.d;
        if (i != 0) {
            this.b = i;
            this.d = 0;
        } else {
            this.b = this.a.t();
        }
        int i2 = this.b;
        if (i2 == 0 || i2 == this.c) {
            return Integer.MAX_VALUE;
        }
        int i3 = r1.a;
        return i2 >>> 3;
    }

    public i a() throws IOException {
        b(2);
        return this.a.e();
    }

    public <T> T b(d1<T> d1Var, q qVar) throws IOException {
        b(2);
        return d(d1Var, qVar);
    }

    public void a(List<Long> list) throws IOException {
        int t;
        int t2;
        if (list instanceof f0) {
            f0 f0Var = (f0) list;
            int i = this.b;
            int i2 = r1.a;
            int i3 = i & 7;
            if (i3 == 0) {
                do {
                    f0Var.a(this.a.v());
                    if (!this.a.c()) {
                        t2 = this.a.t();
                    } else {
                        return;
                    }
                } while (t2 == this.b);
                this.d = t2;
            } else if (i3 == 2) {
                int b2 = this.a.b() + this.a.u();
                do {
                    f0Var.a(this.a.v());
                } while (this.a.b() < b2);
                a(b2);
            } else {
                throw z.d();
            }
        } else {
            int i4 = this.b;
            int i5 = r1.a;
            int i6 = i4 & 7;
            if (i6 == 0) {
                do {
                    list.add(Long.valueOf(this.a.v()));
                    if (!this.a.c()) {
                        t = this.a.t();
                    } else {
                        return;
                    }
                } while (t == this.b);
                this.d = t;
            } else if (i6 == 2) {
                int b3 = this.a.b() + this.a.u();
                do {
                    list.add(Long.valueOf(this.a.v()));
                } while (this.a.b() < b3);
                a(b3);
            } else {
                throw z.d();
            }
        }
    }

    public int b() throws IOException {
        b(0);
        return this.a.g();
    }

    public void b(List<String> list) throws IOException {
        a(list, true);
    }

    public <T> void b(List<T> list, d1<T> d1Var, q qVar) throws IOException {
        int t;
        int i = this.b;
        int i2 = r1.a;
        if ((i & 7) == 2) {
            do {
                list.add(d(d1Var, qVar));
                if (!this.a.c() && this.d == 0) {
                    t = this.a.t();
                } else {
                    return;
                }
            } while (t == i);
            this.d = t;
            return;
        }
        throw z.d();
    }

    public void d(List<Float> list) throws IOException {
        int t;
        int t2;
        if (list instanceof v) {
            v vVar = (v) list;
            int i = this.b;
            int i2 = r1.a;
            int i3 = i & 7;
            if (i3 == 2) {
                int u = this.a.u();
                c(u);
                int b2 = this.a.b() + u;
                do {
                    vVar.a(this.a.j());
                } while (this.a.b() < b2);
            } else if (i3 == 5) {
                do {
                    vVar.a(this.a.j());
                    if (!this.a.c()) {
                        t2 = this.a.t();
                    } else {
                        return;
                    }
                } while (t2 == this.b);
                this.d = t2;
            } else {
                throw z.d();
            }
        } else {
            int i4 = this.b;
            int i5 = r1.a;
            int i6 = i4 & 7;
            if (i6 == 2) {
                int u2 = this.a.u();
                c(u2);
                int b3 = this.a.b() + u2;
                do {
                    list.add(Float.valueOf(this.a.j()));
                } while (this.a.b() < b3);
            } else if (i6 == 5) {
                do {
                    list.add(Float.valueOf(this.a.j()));
                    if (!this.a.c()) {
                        t = this.a.t();
                    } else {
                        return;
                    }
                } while (t == this.b);
                this.d = t;
            } else {
                throw z.d();
            }
        }
    }

    public int c() throws IOException {
        b(0);
        return this.a.u();
    }

    public void c(List<Integer> list) throws IOException {
        int t;
        int t2;
        if (list instanceof x) {
            x xVar = (x) list;
            int i = this.b;
            int i2 = r1.a;
            int i3 = i & 7;
            if (i3 == 0) {
                do {
                    xVar.c(this.a.p());
                    if (!this.a.c()) {
                        t2 = this.a.t();
                    } else {
                        return;
                    }
                } while (t2 == this.b);
                this.d = t2;
            } else if (i3 == 2) {
                int b2 = this.a.b() + this.a.u();
                do {
                    xVar.c(this.a.p());
                } while (this.a.b() < b2);
                a(b2);
            } else {
                throw z.d();
            }
        } else {
            int i4 = this.b;
            int i5 = r1.a;
            int i6 = i4 & 7;
            if (i6 == 0) {
                do {
                    list.add(Integer.valueOf(this.a.p()));
                    if (!this.a.c()) {
                        t = this.a.t();
                    } else {
                        return;
                    }
                } while (t == this.b);
                this.d = t;
            } else if (i6 == 2) {
                int b3 = this.a.b() + this.a.u();
                do {
                    list.add(Integer.valueOf(this.a.p()));
                } while (this.a.b() < b3);
                a(b3);
            } else {
                throw z.d();
            }
        }
    }

    public void a(List<String> list, boolean z) throws IOException {
        int t;
        int t2;
        int i = this.b;
        int i2 = r1.a;
        if ((i & 7) != 2) {
            throw z.d();
        } else if (!(list instanceof d0) || z) {
            do {
                list.add(z ? p() : n());
                if (!this.a.c()) {
                    t = this.a.t();
                } else {
                    return;
                }
            } while (t == this.b);
            this.d = t;
        } else {
            d0 d0Var = (d0) list;
            do {
                d0Var.a(a());
                if (!this.a.c()) {
                    t2 = this.a.t();
                } else {
                    return;
                }
            } while (t2 == this.b);
            this.d = t2;
        }
    }

    public final void c(int i) throws IOException {
        if ((i & 3) != 0) {
            throw z.g();
        }
    }

    public final void d(int i) throws IOException {
        if ((i & 7) != 0) {
            throw z.g();
        }
    }

    public <T> void a(List<T> list, d1<T> d1Var, q qVar) throws IOException {
        int t;
        int i = this.b;
        int i2 = r1.a;
        if ((i & 7) == 3) {
            do {
                list.add(c(d1Var, qVar));
                if (!this.a.c() && this.d == 0) {
                    t = this.a.t();
                } else {
                    return;
                }
            } while (t == i);
            this.d = t;
            return;
        }
        throw z.d();
    }

    public <K, V> void a(Map<K, V> map, h0.a<K, V> aVar, q qVar) throws IOException {
        b(2);
        this.a.d(this.a.u());
        throw null;
    }

    public final void a(int i) throws IOException {
        if (this.a.b() != i) {
            throw z.i();
        }
    }
}
