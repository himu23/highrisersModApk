package com.fyber.inneractive.sdk.network;

public class t0 extends Exception {
    public int a;

    public t0(int i, String str) {
        super(str);
        this.a = i;
    }

    public String toString() {
        return String.valueOf(this.a);
    }
}
