package com.ironsource;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.ironsource.environment.thread.IronSourceThreadManager;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

public class u4 {
    private final ConcurrentHashMap<String, Object> a;
    /* access modifiers changed from: private */
    public final AtomicBoolean b;
    private final AtomicBoolean c;

    class a implements Runnable {
        final /* synthetic */ Context a;

        a(Context context) {
            this.a = context;
        }

        public void run() {
            try {
                u4.this.e(this.a);
            } catch (Exception unused) {
            }
            u4.this.b.set(false);
        }
    }

    private static class b {
        static volatile u4 a = new u4((a) null);

        private b() {
        }
    }

    private u4() {
        this.b = new AtomicBoolean(false);
        this.c = new AtomicBoolean(false);
        this.a = new ConcurrentHashMap<>();
    }

    /* synthetic */ u4(a aVar) {
        this();
    }

    static u4 a() {
        return b.a;
    }

    private void a(Context context) {
        if (!this.b.get()) {
            try {
                this.b.set(true);
                IronSourceThreadManager.INSTANCE.postMediationBackgroundTask(new a(context));
            } catch (Exception unused) {
                this.b.set(false);
            }
        }
    }

    private void a(String str, Object obj) {
        if (str != null && obj != null) {
            try {
                if (obj instanceof Boolean) {
                    obj = Integer.valueOf(((Boolean) obj).booleanValue() ? 1 : 0);
                }
                this.a.put(str, obj);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private boolean a(String str) {
        if (str == null) {
            return false;
        }
        try {
            return this.a.containsKey(str);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private void d(Context context) {
        if (context != null && !this.c.getAndSet(true)) {
            a("auid", (Object) m3.f(context));
            a(t4.u, (Object) m3.j());
            a(t4.q, (Object) m3.k());
            a(t4.x, (Object) m3.l());
            String c2 = m3.c();
            if (c2 != null) {
                a(t4.y, (Object) c2.replaceAll("[^0-9/.]", ""));
                a(t4.z, (Object) c2);
            }
            a(t4.a, (Object) String.valueOf(m3.b()));
            String x = m3.x(context);
            if (!TextUtils.isEmpty(x)) {
                a(t4.s0, (Object) x);
            }
            String e = k0.e(context);
            if (!TextUtils.isEmpty(e)) {
                a(t4.n, (Object) e);
            }
            String n = m3.n(context);
            if (!TextUtils.isEmpty(n)) {
                a(t4.f0, (Object) n);
            }
            a(t4.f, (Object) context.getPackageName());
            a(t4.s, (Object) String.valueOf(m3.D(context)));
            a(t4.P, (Object) t4.W);
            a(t4.Q, (Object) Long.valueOf(k0.f(context)));
            a(t4.O, (Object) Long.valueOf(k0.d(context)));
            a(t4.d, (Object) k0.b(context));
            a(t4.C, (Object) Integer.valueOf(k2.e(context)));
            a(t4.M, (Object) k2.f(context));
            a("stid", (Object) ca.c(context));
        }
    }

    /* access modifiers changed from: private */
    public void e(Context context) {
        if (context != null) {
            try {
                String N = m3.N(context);
                if (!TextUtils.isEmpty(N)) {
                    a(t4.v0, (Object) N);
                }
                String O = m3.O(context);
                if (!TextUtils.isEmpty(O)) {
                    a(t4.p, (Object) Boolean.valueOf(Boolean.parseBoolean(O)));
                }
            } catch (Exception unused) {
            }
        }
    }

    private void f(Context context) {
        if (context != null) {
            a(context);
            String P = m3.P(context);
            if (!TextUtils.isEmpty(P)) {
                a("asid", (Object) P);
            } else if (a("asid")) {
                b("asid");
            }
            String language = context.getResources().getConfiguration().locale.getLanguage();
            if (!TextUtils.isEmpty(language)) {
                a(t4.o, (Object) language.toUpperCase());
            }
            String m = m3.m();
            if (!TextUtils.isEmpty(m)) {
                a("tz", (Object) m);
            }
            String b2 = l2.b(context);
            if (!TextUtils.isEmpty(b2) && !b2.equals("none")) {
                a(t4.j, (Object) b2);
            }
            if (Build.VERSION.SDK_INT >= 23) {
                a("vpn", (Object) Boolean.valueOf(l2.d(context)));
            }
            String y = m3.y(context);
            if (!TextUtils.isEmpty(y)) {
                a("icc", (Object) y);
            }
            a(t4.U, (Object) Float.valueOf(m3.B(context)));
            a(t4.l, (Object) String.valueOf(m3.e()));
            a(t4.F, (Object) Integer.valueOf(m3.q()));
            a(t4.E, (Object) Integer.valueOf(m3.p()));
            a(t4.y0, (Object) String.valueOf(m3.i()));
            a(t4.H0, (Object) String.valueOf(m3.n()));
            a("mcc", (Object) Integer.valueOf(k2.b(context)));
            a("mnc", (Object) Integer.valueOf(k2.c(context)));
            a(t4.H, (Object) Boolean.valueOf(m3.r()));
            a(t4.g, (Object) Boolean.valueOf(m3.G(context)));
            a(t4.h, (Object) Integer.valueOf(m3.a(context)));
            a(t4.b, (Object) Boolean.valueOf(m3.F(context)));
            a(t4.A, (Object) Boolean.valueOf(m3.K(context)));
            a(t4.D, (Object) Boolean.valueOf(m3.s()));
            a(t4.N, (Object) String.valueOf(m3.g()));
            a("bat", (Object) Integer.valueOf(m3.h(context)));
            a("lpm", (Object) Boolean.valueOf(m3.I(context)));
            a(t4.c, (Object) m3.c(context));
            a(t4.R, (Object) m3.f());
            int q = m3.q(context);
            if (q >= 0) {
                a(t4.K0, (Object) Integer.valueOf(q));
            }
            String C = m3.C(context);
            if (C != null) {
                a(t4.L0, (Object) C);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void a(String str, JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                Object obj = this.a.get(str);
                if (!(obj instanceof JSONObject)) {
                    a(str, (Object) jSONObject);
                    return;
                }
                JSONObject jSONObject2 = (JSONObject) obj;
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    jSONObject2.putOpt(next, jSONObject.opt(next));
                }
                a(str, (Object) jSONObject2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void a(Map<String, Object> map) {
        if (map != null) {
            try {
                for (String next : map.keySet()) {
                    if (map.containsKey(next)) {
                        a(next, map.get(next));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: protected */
    public JSONObject b(Context context) throws JSONException {
        f(context);
        return new JSONObject(w4.a(this.a));
    }

    /* access modifiers changed from: protected */
    public void b(String str) {
        if (str != null) {
            try {
                this.a.remove(str);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void b(String str, Object obj) {
        a(str, obj);
    }

    /* access modifiers changed from: protected */
    public void c(Context context) {
        try {
            d(context);
            f(context);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
