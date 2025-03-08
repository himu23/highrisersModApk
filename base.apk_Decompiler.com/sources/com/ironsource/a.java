package com.ironsource;

import android.os.Debug;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

public class a extends Thread {
    private static final int l = 1;
    private static final b m = new C0011a();
    private static final i7 n = new b();
    private b a = m;
    private i7 b = n;
    private final Handler c = new Handler(Looper.getMainLooper());
    private final int d;
    private String e = "";
    private boolean f = false;
    private boolean g = false;
    /* access modifiers changed from: private */
    public volatile int h = 0;
    private int i = 1;
    private int j = 0;
    private final Runnable k = new c();

    /* renamed from: com.ironsource.a$a  reason: collision with other inner class name */
    class C0011a implements b {
        C0011a() {
        }

        public void a() {
        }

        public void b() {
            throw new RuntimeException("ANRHandler has given up");
        }
    }

    class b implements i7 {
        b() {
        }

        public void a(InterruptedException interruptedException) {
            Log.w("ANRHandler", "Interrupted: " + interruptedException.getMessage());
        }
    }

    class c implements Runnable {
        c() {
        }

        public void run() {
            a aVar = a.this;
            int unused = aVar.h = (aVar.h + 1) % Integer.MAX_VALUE;
        }
    }

    public a(int i2) {
        this.d = i2;
    }

    private String a(StackTraceElement[] stackTraceElementArr) {
        String str = "";
        if (stackTraceElementArr != null && stackTraceElementArr.length > 0) {
            for (StackTraceElement stackTraceElement : stackTraceElementArr) {
                if (stackTraceElement != null) {
                    str = str + stackTraceElement.toString() + ";\n";
                }
            }
        }
        return str;
    }

    public int a() {
        return this.j;
    }

    public a a(b bVar) {
        if (bVar == null) {
            bVar = m;
        }
        this.a = bVar;
        return this;
    }

    public a a(i7 i7Var) {
        if (i7Var == null) {
            i7Var = n;
        }
        this.b = i7Var;
        return this;
    }

    public a a(String str) {
        if (str == null) {
            str = "";
        }
        this.e = str;
        return this;
    }

    public a a(boolean z) {
        this.g = z;
        return this;
    }

    public void a(int i2) {
        this.i = i2;
    }

    public int b() {
        return this.i;
    }

    public a b(boolean z) {
        this.f = z;
        return this;
    }

    public a c() {
        this.e = null;
        return this;
    }

    public void run() {
        setName("|ANR-ANRHandler|");
        int i2 = -1;
        while (!isInterrupted() && this.j < this.i) {
            int i3 = this.h;
            this.c.post(this.k);
            try {
                Thread.sleep((long) this.d);
                if (this.h != i3) {
                    this.j = 0;
                } else if (this.g || !Debug.isDebuggerConnected()) {
                    this.j++;
                    this.a.a();
                    String str = s2.k;
                    if (str != null && !str.trim().isEmpty()) {
                        new h4(s2.k, String.valueOf(System.currentTimeMillis()), "ANR").a();
                    }
                } else {
                    if (this.h != i2) {
                        Log.w("ANRHandler", "An ANR was detected but ignored because the debugger is connected (you can prevent this with setIgnoreDebugger(true))");
                    }
                    i2 = this.h;
                }
            } catch (InterruptedException e2) {
                this.b.a(e2);
                return;
            }
        }
        if (this.j >= this.i) {
            this.a.b();
        }
    }
}
