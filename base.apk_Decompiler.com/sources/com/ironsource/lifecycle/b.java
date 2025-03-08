package com.ironsource.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.ironsource.environment.thread.IronSourceThreadManager;
import com.ironsource.h8;
import com.ironsource.i8;
import com.ironsource.lifecycle.a;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class b implements Application.ActivityLifecycleCallbacks {
    private static b j = new b();
    private static AtomicBoolean k = new AtomicBoolean(false);
    static final long l = 700;
    private String a = "IronsourceLifecycleManager";
    private int b = 0;
    private int c = 0;
    private boolean d = true;
    private boolean e = true;
    private i8 f = i8.NONE;
    /* access modifiers changed from: private */
    public List<h8> g = new CopyOnWriteArrayList();
    private Runnable h = new a();
    private a.C0013a i = new f();

    class a implements Runnable {
        a() {
        }

        public void run() {
            b.this.a();
            b.this.b();
        }
    }

    /* renamed from: com.ironsource.lifecycle.b$b  reason: collision with other inner class name */
    class C0014b implements Runnable {
        C0014b() {
        }

        public void run() {
            for (h8 c : b.this.g) {
                c.c();
            }
        }
    }

    class c implements Runnable {
        c() {
        }

        public void run() {
            for (h8 a2 : b.this.g) {
                a2.a();
            }
        }
    }

    class d implements Runnable {
        d() {
        }

        public void run() {
            for (h8 d : b.this.g) {
                d.d();
            }
        }
    }

    class e implements Runnable {
        e() {
        }

        public void run() {
            for (h8 b : b.this.g) {
                b.b();
            }
        }
    }

    class f implements a.C0013a {
        f() {
        }

        public void a(Activity activity) {
            b.this.c(activity);
        }

        public void b(Activity activity) {
        }

        public void onResume(Activity activity) {
            b.this.b(activity);
        }
    }

    /* access modifiers changed from: private */
    public void a() {
        if (this.c == 0) {
            this.d = true;
            IronSourceThreadManager.INSTANCE.postMediationBackgroundTask(new d());
            this.f = i8.PAUSED;
        }
    }

    /* access modifiers changed from: private */
    public void b() {
        if (this.b == 0 && this.d) {
            IronSourceThreadManager.INSTANCE.postMediationBackgroundTask(new e());
            this.e = true;
            this.f = i8.STOPPED;
        }
    }

    public static b d() {
        return j;
    }

    /* access modifiers changed from: package-private */
    public void a(Activity activity) {
        int i2 = this.c - 1;
        this.c = i2;
        if (i2 == 0) {
            IronSourceThreadManager.INSTANCE.postOnUiThreadTask(this.h, 700);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(Context context) {
        Application application;
        if (k.compareAndSet(false, true) && (application = (Application) context.getApplicationContext()) != null) {
            application.registerActivityLifecycleCallbacks(this);
        }
    }

    public void a(h8 h8Var) {
        if (IronsourceLifecycleProvider.a() && h8Var != null && !this.g.contains(h8Var)) {
            this.g.add(h8Var);
        }
    }

    /* access modifiers changed from: package-private */
    public void b(Activity activity) {
        int i2 = this.c + 1;
        this.c = i2;
        if (i2 != 1) {
            return;
        }
        if (this.d) {
            IronSourceThreadManager.INSTANCE.postMediationBackgroundTask(new c());
            this.d = false;
            this.f = i8.RESUMED;
            return;
        }
        IronSourceThreadManager.INSTANCE.removeUiThreadTask(this.h);
    }

    public void b(h8 h8Var) {
        if (this.g.contains(h8Var)) {
            this.g.remove(h8Var);
        }
    }

    public i8 c() {
        return this.f;
    }

    /* access modifiers changed from: package-private */
    public void c(Activity activity) {
        int i2 = this.b + 1;
        this.b = i2;
        if (i2 == 1 && this.e) {
            IronSourceThreadManager.INSTANCE.postMediationBackgroundTask(new C0014b());
            this.e = false;
            this.f = i8.STARTED;
        }
    }

    /* access modifiers changed from: package-private */
    public void d(Activity activity) {
        this.b--;
        b();
    }

    public boolean e() {
        return this.f == i8.STOPPED;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        a.b(activity);
        a a2 = a.a(activity);
        if (a2 != null) {
            a2.d(this.i);
        }
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
        a(activity);
    }

    public void onActivityResumed(Activity activity) {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public void onActivityStopped(Activity activity) {
        d(activity);
    }
}
