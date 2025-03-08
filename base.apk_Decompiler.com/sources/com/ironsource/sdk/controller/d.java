package com.ironsource.sdk.controller;

import com.ironsource.g6;
import com.ironsource.l6;
import com.ironsource.m2;
import com.ironsource.n6;
import com.ironsource.q3;
import com.ironsource.sdk.utils.IronSourceStorageUtils;
import com.ironsource.sdk.utils.SDKUtils;
import com.ironsource.z3;
import com.ironsource.za;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

class d {
    static final String h = "controllerSourceData";
    private static final String i = "next_";
    private static final String j = "fallback_";
    private static final String k = "controllerSourceCode";
    private long a;
    /* access modifiers changed from: private */
    public int b;
    private c c;
    /* access modifiers changed from: private */
    public C0021d d = C0021d.NONE;
    private String e;
    private String f;
    private q3 g;

    class a extends JSONObject {
        a() throws JSONException {
            putOpt(m2.a.h, Integer.valueOf(d.this.b));
            putOpt(d.k, Integer.valueOf(d.this.d.a()));
        }
    }

    static /* synthetic */ class b {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.ironsource.sdk.controller.d$c[] r0 = com.ironsource.sdk.controller.d.c.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                a = r0
                com.ironsource.sdk.controller.d$c r1 = com.ironsource.sdk.controller.d.c.FETCH_FROM_SERVER_NO_FALLBACK     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.ironsource.sdk.controller.d$c r1 = com.ironsource.sdk.controller.d.c.FETCH_FROM_SERVER_WITH_LOCAL_FALLBACK     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.ironsource.sdk.controller.d$c r1 = com.ironsource.sdk.controller.d.c.FETCH_FOR_NEXT_SESSION_LOAD_FROM_LOCAL     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ironsource.sdk.controller.d.b.<clinit>():void");
        }
    }

    public enum c {
        FETCH_FROM_SERVER_NO_FALLBACK,
        FETCH_FROM_SERVER_WITH_LOCAL_FALLBACK,
        FETCH_FOR_NEXT_SESSION_LOAD_FROM_LOCAL
    }

    /* renamed from: com.ironsource.sdk.controller.d$d  reason: collision with other inner class name */
    public enum C0021d {
        NONE(0),
        PREPARED_CONTROLLER_LOADED(1),
        CONTROLLER_FROM_SERVER(2),
        MISSING_PREPARED_CONTROLLER_LOAD_LAST_USED_CONTROLLER(3),
        FAILED_RENAME_PREPARED_CONTROLLER_LOAD_LAST_USED_CONTROLLER(4),
        FALLBACK_CONTROLLER_RECOVERY(5);
        
        private int a;

        private C0021d(int i) {
            this.a = i;
        }

        public int a() {
            return this.a;
        }
    }

    d(JSONObject jSONObject, String str, String str2, q3 q3Var) {
        int optInt = jSONObject.optInt(m2.a.h, -1);
        this.b = optInt;
        this.c = a(optInt);
        this.e = str;
        this.f = str2;
        this.g = q3Var;
    }

    private c a(int i2) {
        return i2 != 1 ? i2 != 2 ? c.FETCH_FROM_SERVER_NO_FALLBACK : c.FETCH_FOR_NEXT_SESSION_LOAD_FROM_LOCAL : c.FETCH_FROM_SERVER_WITH_LOCAL_FALLBACK;
    }

    private void a(n6 n6Var) {
        if (!this.g.c()) {
            this.g.a(n6Var, this.f);
        }
    }

    private void a(C0021d dVar) {
        g6 a2 = new g6().a(z3.x, Integer.valueOf(this.b)).a(z3.y, Integer.valueOf(dVar.a()));
        if (this.a > 0) {
            a2.a(z3.A, Long.valueOf(System.currentTimeMillis() - this.a));
        }
        l6.a(za.w, (Map<String, Object>) a2.a());
    }

    private boolean a() {
        try {
            if (!j()) {
                return false;
            }
            return IronSourceStorageUtils.renameFile(h().getPath(), g().getPath());
        } catch (Exception unused) {
            return false;
        }
    }

    private boolean b() throws Exception {
        return IronSourceStorageUtils.renameFile(i().getPath(), g().getPath());
    }

    private void c() {
        try {
            n6 g2 = g();
            if (g2.exists()) {
                n6 h2 = h();
                if (h2.exists()) {
                    h2.delete();
                }
                IronSourceStorageUtils.renameFile(g2.getPath(), h2.getPath());
            }
        } catch (Exception unused) {
        }
    }

    private void d() {
        IronSourceStorageUtils.deleteFile(h());
    }

    private void e() {
        IronSourceStorageUtils.deleteFile(g());
    }

    private n6 h() {
        return new n6(this.e, "fallback_mobileController.html");
    }

    private n6 i() {
        return new n6(this.e, "next_mobileController.html");
    }

    private boolean j() {
        return h().exists();
    }

    private void l() {
        g6 a2 = new g6().a(z3.x, Integer.valueOf(this.b));
        if (this.a > 0) {
            a2.a(z3.A, Long.valueOf(System.currentTimeMillis() - this.a));
        }
        l6.a(za.x, (Map<String, Object>) a2.a());
    }

    /* access modifiers changed from: package-private */
    public void a(g6 g6Var) {
        g6Var.a(z3.x, Integer.valueOf(this.b));
        l6.a(za.v, (Map<String, Object>) g6Var.a());
        this.a = System.currentTimeMillis();
    }

    /* access modifiers changed from: package-private */
    public void a(Runnable runnable) {
        if (!m()) {
            if (this.c == c.FETCH_FROM_SERVER_WITH_LOCAL_FALLBACK) {
                d();
            }
            C0021d dVar = C0021d.CONTROLLER_FROM_SERVER;
            this.d = dVar;
            a(dVar);
            runnable.run();
        }
    }

    /* access modifiers changed from: package-private */
    public void a(Runnable runnable, Runnable runnable2) {
        if (!m()) {
            if (this.c != c.FETCH_FROM_SERVER_WITH_LOCAL_FALLBACK || !a()) {
                l();
                runnable2.run();
                return;
            }
            C0021d dVar = C0021d.FALLBACK_CONTROLLER_RECOVERY;
            this.d = dVar;
            a(dVar);
            runnable.run();
        }
    }

    /* access modifiers changed from: package-private */
    public JSONObject f() throws JSONException {
        return new a();
    }

    /* access modifiers changed from: package-private */
    public n6 g() {
        return new n6(this.e, m2.g);
    }

    /* access modifiers changed from: package-private */
    public boolean k() {
        n6 n6Var;
        int i2 = b.a[this.c.ordinal()];
        if (i2 == 1) {
            e();
            n6Var = new n6(this.e, SDKUtils.getFileName(this.f));
        } else if (i2 != 2) {
            if (i2 == 3) {
                try {
                    n6 g2 = g();
                    n6 i3 = i();
                    if (!i3.exists() && !g2.exists()) {
                        a(new n6(this.e, SDKUtils.getFileName(this.f)));
                        return false;
                    } else if (i3.exists() || !g2.exists()) {
                        c();
                        if (b()) {
                            C0021d dVar = C0021d.PREPARED_CONTROLLER_LOADED;
                            this.d = dVar;
                            a(dVar);
                            d();
                            a(new n6(this.e, i3.getName()));
                            return true;
                        } else if (a()) {
                            C0021d dVar2 = C0021d.FAILED_RENAME_PREPARED_CONTROLLER_LOAD_LAST_USED_CONTROLLER;
                            this.d = dVar2;
                            a(dVar2);
                            a(new n6(this.e, i3.getName()));
                            return true;
                        } else {
                            a(new n6(this.e, SDKUtils.getFileName(this.f)));
                        }
                    } else {
                        C0021d dVar3 = C0021d.MISSING_PREPARED_CONTROLLER_LOAD_LAST_USED_CONTROLLER;
                        this.d = dVar3;
                        a(dVar3);
                        a(new n6(this.e, i3.getName()));
                        return true;
                    }
                } catch (Exception unused) {
                }
            }
            return false;
        } else {
            c();
            n6Var = new n6(this.e, SDKUtils.getFileName(this.f));
        }
        a(n6Var);
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean m() {
        return this.d != C0021d.NONE;
    }
}
