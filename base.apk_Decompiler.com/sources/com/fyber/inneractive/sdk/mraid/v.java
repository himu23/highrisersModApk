package com.fyber.inneractive.sdk.mraid;

public class v extends u {
    public final int a;
    public final int b;
    public final int c;
    public final int d;

    public v(int i, int i2, int i3, int i4) {
        this.a = i3;
        this.b = i4;
        this.d = i2;
        this.c = i;
    }

    public String a() {
        return "currentPosition: { x: " + this.c + ", y: " + this.d + ", width: " + this.a + ", height: " + this.b + " }";
    }
}
