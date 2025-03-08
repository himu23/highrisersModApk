package com.fyber.inneractive.sdk.protobuf;

import java.io.IOException;

public final class m implements s1 {
    public final l a;

    public m(l lVar) {
        l lVar2 = (l) y.a(lVar, "output");
        this.a = lVar2;
        lVar2.a = this;
    }

    public void a(int i, float f) throws IOException {
        l lVar = this.a;
        lVar.getClass();
        lVar.g(i, Float.floatToRawIntBits(f));
    }

    public void b(int i, Object obj, d1 d1Var) throws IOException {
        this.a.b(i, (o0) obj, d1Var);
    }

    public void a(int i, double d) throws IOException {
        l lVar = this.a;
        lVar.getClass();
        lVar.f(i, Double.doubleToRawLongBits(d));
    }

    public void a(int i, int i2) throws IOException {
        this.a.j(i, l.d(i2));
    }

    public void a(int i, long j) throws IOException {
        this.a.g(i, l.b(j));
    }

    public void a(int i, Object obj, d1 d1Var) throws IOException {
        l lVar = this.a;
        lVar.i(i, 3);
        d1Var.a((o0) obj, (s1) lVar.a);
        lVar.i(i, 4);
    }

    public final void a(int i, Object obj) throws IOException {
        if (obj instanceof i) {
            this.a.c(i, (i) obj);
        } else {
            this.a.a(i, (o0) obj);
        }
    }
}
