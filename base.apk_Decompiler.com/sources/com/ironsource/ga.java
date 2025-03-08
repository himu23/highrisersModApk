package com.ironsource;

public class ga {
    private boolean a;
    private boolean b;
    private boolean c;
    private ha d;
    private int e;
    private int f;

    public static class b {
        private boolean a = true;
        private boolean b = false;
        private boolean c = false;
        private ha d = null;
        private int e = 0;
        private int f = 0;

        public b a(boolean z) {
            this.a = z;
            return this;
        }

        public b a(boolean z, int i) {
            this.c = z;
            this.f = i;
            return this;
        }

        public b a(boolean z, ha haVar, int i) {
            this.b = z;
            if (haVar == null) {
                haVar = ha.PER_DAY;
            }
            this.d = haVar;
            this.e = i;
            return this;
        }

        public ga a() {
            return new ga(this.a, this.b, this.c, this.d, this.e, this.f);
        }
    }

    private ga(boolean z, boolean z2, boolean z3, ha haVar, int i, int i2) {
        this.a = z;
        this.b = z2;
        this.c = z3;
        this.d = haVar;
        this.e = i;
        this.f = i2;
    }

    public ha a() {
        return this.d;
    }

    public int b() {
        return this.e;
    }

    public int c() {
        return this.f;
    }

    public boolean d() {
        return this.b;
    }

    public boolean e() {
        return this.a;
    }

    public boolean f() {
        return this.c;
    }
}
