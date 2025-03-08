package com.ironsource;

public class hc {
    protected long a;
    protected long b;
    protected long c;

    public long a() {
        return Math.max(0, this.a - System.currentTimeMillis());
    }

    public void a(long j) {
        this.a = System.currentTimeMillis() + j;
    }

    public void b() {
        this.a = 0;
        this.b = 0;
        this.c = 0;
    }

    public void b(long j) {
        this.c = j;
        this.a += j - this.b;
    }

    public void c(long j) {
        this.b = j;
        this.c = 0;
    }
}
