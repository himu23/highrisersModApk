package com.fyber.inneractive.sdk.web;

public class w implements Runnable {
    public final /* synthetic */ x a;

    public w(x xVar) {
        this.a = xVar;
    }

    public void run() {
        try {
            this.a.a.evictAll();
        } catch (Throwable unused) {
        }
    }
}
