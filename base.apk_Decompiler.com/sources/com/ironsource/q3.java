package com.ironsource;

import android.os.Handler;
import com.ironsource.sdk.utils.IronSourceStorageUtils;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

public class q3 {
    private static final int e = 5;
    private static q3 f;
    private p3 a;
    private final JSONObject b;
    private Thread c;
    private final String d;

    private q3(String str, n5 n5Var, JSONObject jSONObject) {
        this.d = str;
        this.a = new p3(n5Var.a());
        this.b = jSONObject;
        IronSourceStorageUtils.deleteFolder(b());
        IronSourceStorageUtils.makeDir(b());
    }

    public static synchronized q3 a(String str, n5 n5Var, JSONObject jSONObject) {
        q3 q3Var;
        synchronized (q3.class) {
            if (f == null) {
                f = new q3(str, n5Var, jSONObject);
            }
            q3Var = f;
        }
        return q3Var;
    }

    private Thread a(n3 n3Var, Handler handler) {
        return new Thread(new mb(n3Var, handler));
    }

    private Thread a(n6 n6Var, String str, int i, int i2, Handler handler) {
        if (i <= 0) {
            i = this.b.optInt("connectionTimeout", 5);
        }
        if (i2 <= 0) {
            i2 = this.b.optInt("readTimeout", 5);
        }
        TimeUnit timeUnit = TimeUnit.SECONDS;
        return a(new n3(n6Var, str, (int) timeUnit.toMillis((long) i), (int) timeUnit.toMillis((long) i2), b()), handler);
    }

    private String b() {
        return IronSourceStorageUtils.buildAbsolutePathToDirInCache(this.d, n2.D);
    }

    public String a() {
        return this.d;
    }

    public void a(n6 n6Var, String str) {
        int optInt = this.b.optInt("connectionTimeout", 5);
        int optInt2 = this.b.optInt("readTimeout", 5);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        Thread a2 = a(new n3(n6Var, str, (int) timeUnit.toMillis((long) optInt), (int) timeUnit.toMillis((long) optInt2), b()), (Handler) this.a);
        this.c = a2;
        a2.start();
    }

    public void a(n6 n6Var, String str, int i, int i2) {
        a(n6Var, str, i, i2, this.a).start();
    }

    public void a(y9 y9Var) {
        this.a.a(y9Var);
    }

    public void b(n6 n6Var, String str, int i, int i2, Handler handler) {
        a(n6Var, str, i, i2, handler).start();
    }

    public boolean c() {
        Thread thread = this.c;
        return thread != null && thread.isAlive();
    }

    public synchronized void d() {
        f = null;
        p3 p3Var = this.a;
        if (p3Var != null) {
            p3Var.a();
            this.a = null;
        }
    }
}
