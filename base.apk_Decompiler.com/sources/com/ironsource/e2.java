package com.ironsource;

import java.util.ArrayList;

public class e2 {
    private a a = a.NOT_READY;
    private ArrayList b = new ArrayList();
    private String c;

    enum a {
        NOT_READY,
        READY
    }

    public e2(String str) {
        this.c = str;
    }

    public synchronized void a() {
        Object[] array = this.b.toArray();
        for (int i = 0; i < array.length; i++) {
            ((Runnable) array[i]).run();
            array[i] = null;
        }
        this.b.clear();
    }

    public synchronized void a(Runnable runnable) {
        if (this.a != a.READY) {
            this.b.add(runnable);
        } else {
            runnable.run();
        }
    }

    public synchronized void b() {
        this.a = a.NOT_READY;
    }

    public synchronized void c() {
        this.a = a.READY;
    }
}
