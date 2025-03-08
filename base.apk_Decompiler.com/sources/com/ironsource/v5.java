package com.ironsource;

public class v5 {
    private int a;
    private int b;
    private String c;

    public v5() {
        this.a = 0;
        this.b = 0;
        this.c = "";
    }

    public v5(int i, int i2, String str) {
        this.a = i;
        this.b = i2;
        this.c = str;
    }

    public int a() {
        return this.b;
    }

    public String b() {
        return this.c;
    }

    public int c() {
        return this.a;
    }

    public boolean d() {
        return this.b > 0 && this.a > 0;
    }

    public boolean e() {
        return this.b == 0 && this.a == 0;
    }

    public String toString() {
        return this.c;
    }
}
