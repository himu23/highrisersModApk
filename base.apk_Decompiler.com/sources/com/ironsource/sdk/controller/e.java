package com.ironsource.sdk.controller;

import android.app.Activity;
import android.content.Context;
import android.os.CountDownTimer;
import android.util.Log;
import com.ironsource.e2;
import com.ironsource.e6;
import com.ironsource.f6;
import com.ironsource.fd;
import com.ironsource.g6;
import com.ironsource.h3;
import com.ironsource.i3;
import com.ironsource.k9;
import com.ironsource.l6;
import com.ironsource.m2;
import com.ironsource.m4;
import com.ironsource.m6;
import com.ironsource.n4;
import com.ironsource.n5;
import com.ironsource.nc;
import com.ironsource.o2;
import com.ironsource.q3;
import com.ironsource.sdk.IronSourceNetwork;
import com.ironsource.sdk.controller.f;
import com.ironsource.sdk.controller.k;
import com.ironsource.sdk.utils.IronSourceStorageUtils;
import com.ironsource.sdk.utils.Logger;
import com.ironsource.v2;
import com.ironsource.v9;
import com.ironsource.w2;
import com.ironsource.w9;
import com.ironsource.x2;
import com.ironsource.x8;
import com.ironsource.z3;
import com.ironsource.z8;
import com.ironsource.za;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class e implements c, k {
    /* access modifiers changed from: private */
    public final String a = "e";
    /* access modifiers changed from: private */
    public k b;
    private e6.b c = e6.b.None;
    private CountDownTimer d;
    private final e2 e;
    private final e2 f;
    private final n5 g;
    /* access modifiers changed from: private */
    public final fd h;
    /* access modifiers changed from: private */
    public final Map<String, k.a> i;
    /* access modifiers changed from: private */
    public final Map<String, k.b> j;
    private final k9 k;

    class a implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ String b;
        final /* synthetic */ w9 c;

        a(String str, String str2, w9 w9Var) {
            this.a = str;
            this.b = str2;
            this.c = w9Var;
        }

        public void run() {
            if (e.this.b != null) {
                e.this.b.a(this.a, this.b, this.c);
            }
        }
    }

    class b implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ String b;
        final /* synthetic */ h3 c;
        final /* synthetic */ x2 d;

        b(String str, String str2, h3 h3Var, x2 x2Var) {
            this.a = str;
            this.b = str2;
            this.c = h3Var;
            this.d = x2Var;
        }

        public void run() {
            if (e.this.b != null) {
                e.this.b.a(this.a, this.b, this.c, this.d);
            }
        }
    }

    class c implements Runnable {
        final /* synthetic */ JSONObject a;
        final /* synthetic */ x2 b;

        c(JSONObject jSONObject, x2 x2Var) {
            this.a = jSONObject;
            this.b = x2Var;
        }

        public void run() {
            if (e.this.b != null) {
                e.this.b.a(this.a, this.b);
            }
        }
    }

    class d implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ String b;
        final /* synthetic */ h3 c;
        final /* synthetic */ w2 d;

        d(String str, String str2, h3 h3Var, w2 w2Var) {
            this.a = str;
            this.b = str2;
            this.c = h3Var;
            this.d = w2Var;
        }

        public void run() {
            if (e.this.b != null) {
                e.this.b.a(this.a, this.b, this.c, this.d);
            }
        }
    }

    /* renamed from: com.ironsource.sdk.controller.e$e  reason: collision with other inner class name */
    class C0022e implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ w2 b;

        C0022e(String str, w2 w2Var) {
            this.a = str;
            this.b = w2Var;
        }

        public void run() {
            if (e.this.b != null) {
                e.this.b.a(this.a, this.b);
            }
        }
    }

    class f implements Runnable {
        final /* synthetic */ h3 a;
        final /* synthetic */ Map b;
        final /* synthetic */ w2 c;

        f(h3 h3Var, Map map, w2 w2Var) {
            this.a = h3Var;
            this.b = map;
            this.c = w2Var;
        }

        public void run() {
            l6.a(za.j, (Map<String, Object>) new g6().a(z3.u, this.a.f()).a(z3.v, m6.a(this.a, e6.e.Interstitial)).a(z3.w, Boolean.valueOf(m6.a(this.a))).a(z3.G, Long.valueOf(com.ironsource.j.a.b(this.a.h()))).a());
            if (e.this.b != null) {
                e.this.b.b(this.a, this.b, this.c);
            }
        }
    }

    class g implements Runnable {
        final /* synthetic */ JSONObject a;
        final /* synthetic */ w2 b;

        g(JSONObject jSONObject, w2 w2Var) {
            this.a = jSONObject;
            this.b = w2Var;
        }

        public void run() {
            if (e.this.b != null) {
                e.this.b.a(this.a, this.b);
            }
        }
    }

    class h implements Runnable {
        final /* synthetic */ h3 a;
        final /* synthetic */ Map b;
        final /* synthetic */ w2 c;

        h(h3 h3Var, Map map, w2 w2Var) {
            this.a = h3Var;
            this.b = map;
            this.c = w2Var;
        }

        public void run() {
            if (e.this.b != null) {
                e.this.b.a(this.a, (Map<String, String>) this.b, this.c);
            }
        }
    }

    class i implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ String b;
        final /* synthetic */ h3 c;
        final /* synthetic */ v2 d;

        i(String str, String str2, h3 h3Var, v2 v2Var) {
            this.a = str;
            this.b = str2;
            this.c = h3Var;
            this.d = v2Var;
        }

        public void run() {
            if (e.this.b != null) {
                e.this.b.a(this.a, this.b, this.c, this.d);
            }
        }
    }

    class j implements Runnable {
        final /* synthetic */ JSONObject a;
        final /* synthetic */ v2 b;

        j(JSONObject jSONObject, v2 v2Var) {
            this.a = jSONObject;
            this.b = v2Var;
        }

        public void run() {
            if (e.this.b != null) {
                e.this.b.a(this.a, this.b);
            }
        }
    }

    class k implements k.a {
        k() {
        }

        public void a(f.a aVar) {
            k.a aVar2 = (k.a) e.this.i.remove(aVar.c());
            if (aVar2 != null) {
                aVar2.a(aVar);
            }
        }
    }

    class l implements Runnable {
        final /* synthetic */ h3 a;

        l(h3 h3Var) {
            this.a = h3Var;
        }

        public void run() {
            if (e.this.b != null) {
                e.this.b.a(this.a);
            }
        }
    }

    class m implements Runnable {
        final /* synthetic */ h3 a;
        final /* synthetic */ Map b;
        final /* synthetic */ v2 c;

        m(h3 h3Var, Map map, v2 v2Var) {
            this.a = h3Var;
            this.b = map;
            this.c = v2Var;
        }

        public void run() {
            if (e.this.b != null) {
                e.this.b.a(this.a, (Map<String, String>) this.b, this.c);
            }
        }
    }

    class n implements Runnable {
        final /* synthetic */ k.a a;
        final /* synthetic */ f.c b;

        n(k.a aVar, f.c cVar) {
            this.a = aVar;
            this.b = cVar;
        }

        public void run() {
            if (e.this.b != null) {
                if (this.a != null) {
                    e.this.i.put(this.b.f(), this.a);
                }
                e.this.b.a(this.b, this.a);
            }
        }
    }

    class o implements Runnable {
        final /* synthetic */ JSONObject a;

        o(JSONObject jSONObject) {
            this.a = jSONObject;
        }

        public void run() {
            if (e.this.b != null) {
                e.this.b.a(this.a);
            }
        }
    }

    class p implements Runnable {
        p() {
        }

        public void run() {
            if (e.this.b != null) {
                e.this.b.destroy();
                k unused = e.this.b = null;
            }
        }
    }

    class q implements k.b {
        q() {
        }

        public void a(x8 x8Var) {
            k.b bVar = (k.b) e.this.j.get(x8Var.d());
            if (bVar != null) {
                bVar.a(x8Var);
            }
        }
    }

    class r implements Runnable {
        final /* synthetic */ Context a;
        final /* synthetic */ o2 b;
        final /* synthetic */ nc c;
        final /* synthetic */ i3 d;
        final /* synthetic */ int e;
        final /* synthetic */ q3 f;
        final /* synthetic */ String g;
        final /* synthetic */ String h;
        final /* synthetic */ String i;

        r(Context context, o2 o2Var, nc ncVar, i3 i3Var, int i2, q3 q3Var, String str, String str2, String str3) {
            this.a = context;
            this.b = o2Var;
            this.c = ncVar;
            this.d = i3Var;
            this.e = i2;
            this.f = q3Var;
            this.g = str;
            this.h = str2;
            this.i = str3;
        }

        public void run() {
            try {
                e eVar = e.this;
                k unused = eVar.b = eVar.b(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i);
                e.this.b.e();
            } catch (Throwable th) {
                e.this.d(Log.getStackTraceString(th));
            }
        }
    }

    class s extends CountDownTimer {
        s(long j, long j2) {
            super(j, j2);
        }

        public void onFinish() {
            Logger.i(e.this.a, "Global Controller Timer Finish");
            e.this.d(m2.c.k);
        }

        public void onTick(long j) {
            String d = e.this.a;
            Logger.i(d, "Global Controller Timer Tick " + j);
        }
    }

    class t implements Runnable {
        t() {
        }

        public void run() {
            e.this.f();
        }
    }

    class u implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ String b;

        u(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        public void run() {
            try {
                e eVar = e.this;
                k unused = eVar.b = eVar.b(eVar.h.b(), e.this.h.d(), e.this.h.j(), e.this.h.f(), e.this.h.e(), e.this.h.g(), e.this.h.c(), this.a, this.b);
                e.this.b.e();
            } catch (Throwable th) {
                e.this.d(Log.getStackTraceString(th));
            }
        }
    }

    class v extends CountDownTimer {
        v(long j, long j2) {
            super(j, j2);
        }

        public void onFinish() {
            Logger.i(e.this.a, "Recovered Controller | Global Controller Timer Finish");
            e.this.d(m2.c.k);
        }

        public void onTick(long j) {
            String d = e.this.a;
            Logger.i(d, "Recovered Controller | Global Controller Timer Tick " + j);
        }
    }

    class w implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ String b;
        final /* synthetic */ Map c;
        final /* synthetic */ w9 d;

        w(String str, String str2, Map map, w9 w9Var) {
            this.a = str;
            this.b = str2;
            this.c = map;
            this.d = w9Var;
        }

        public void run() {
            if (e.this.b != null) {
                e.this.b.a(this.a, this.b, (Map<String, String>) this.c, this.d);
            }
        }
    }

    class x implements Runnable {
        final /* synthetic */ Map a;
        final /* synthetic */ w9 b;

        x(Map map, w9 w9Var) {
            this.a = map;
            this.b = w9Var;
        }

        public void run() {
            if (e.this.b != null) {
                e.this.b.a((Map<String, String>) this.a, this.b);
            }
        }
    }

    public e(Context context, o2 o2Var, nc ncVar, i3 i3Var, n5 n5Var, int i2, JSONObject jSONObject, String str, String str2, k9 k9Var) {
        n5 n5Var2 = n5Var;
        this.k = k9Var;
        this.e = new e2("NativeCommandExecutor");
        this.f = new e2("ControllerCommandsExecutor");
        this.g = n5Var2;
        this.i = new HashMap();
        this.j = new HashMap();
        String networkStorageDir = IronSourceStorageUtils.getNetworkStorageDir(context);
        q3 a2 = q3.a(networkStorageDir, n5Var2, jSONObject);
        this.h = new fd(context, o2Var, ncVar, i3Var, i2, a2, networkStorageDir);
        a(context, o2Var, ncVar, i3Var, i2, a2, networkStorageDir, str, str2);
    }

    private void a(Context context, o2 o2Var, nc ncVar, i3 i3Var, int i2, q3 q3Var, String str, String str2, String str3) {
        b((Runnable) new r(context, o2Var, ncVar, i3Var, i2, q3Var, str, str2, str3));
        this.d = new s(200000, 1000).start();
    }

    private void a(e6.e eVar, h3 h3Var, String str, String str2) {
        String str3 = this.a;
        Logger.i(str3, "recoverWebController for product: " + eVar.toString());
        g6 g6Var = new g6();
        g6Var.a(z3.v, eVar.toString());
        g6Var.a(z3.u, h3Var.f());
        l6.a(za.b, (Map<String, Object>) g6Var.a());
        this.h.o();
        destroy();
        b((Runnable) new u(str, str2));
        this.d = new v(200000, 1000).start();
    }

    /* access modifiers changed from: private */
    public u b(Context context, o2 o2Var, nc ncVar, i3 i3Var, int i2, q3 q3Var, String str, String str2, String str3) throws Throwable {
        Context context2 = context;
        l6.a(za.c);
        u uVar = new u(context, i3Var, o2Var, this, this.g, i2, q3Var, str, g(), h(), str2, str3);
        n4 n4Var = new n4(context2, q3Var, new m4(this.g.a()), new z8(q3Var.a()));
        uVar.a(new t(context2, ncVar));
        uVar.a(new o(context2));
        uVar.a(new p(context2));
        uVar.a(new i(context2));
        uVar.a(new a(context2));
        uVar.a(new j(q3Var.a(), n4Var));
        return uVar;
    }

    /* access modifiers changed from: private */
    public void d(String str) {
        l6.a(za.d, (Map<String, Object>) new g6().a(z3.z, str).a());
        this.c = e6.b.Loading;
        this.b = new n(str, this.g);
        this.e.c();
        this.e.a();
        n5 n5Var = this.g;
        if (n5Var != null) {
            n5Var.b(new t());
        }
    }

    private void e(String str) {
        v9 initListener = IronSourceNetwork.getInitListener();
        if (initListener != null) {
            initListener.onFail(new f6(1001, str));
            IronSourceNetwork.setInitListener((v9) null);
        }
    }

    private k.a g() {
        return new k();
    }

    private k.b h() {
        return new q();
    }

    private void j() {
        Logger.i(this.a, "handleReadyState");
        this.c = e6.b.Ready;
        CountDownTimer countDownTimer = this.d;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        l();
        this.f.c();
        this.f.a();
        k kVar = this.b;
        if (kVar != null) {
            kVar.c();
        }
    }

    private boolean k() {
        return e6.b.Ready.equals(this.c);
    }

    private void l() {
        this.h.a(true);
        k kVar = this.b;
        if (kVar != null) {
            kVar.b(this.h.i());
        }
    }

    private void m() {
        v9 initListener = IronSourceNetwork.getInitListener();
        if (initListener != null) {
            initListener.onSuccess();
            IronSourceNetwork.setInitListener((v9) null);
        }
    }

    public void a() {
        Logger.i(this.a, "handleControllerLoaded");
        this.c = e6.b.Loaded;
        this.e.c();
        this.e.a();
    }

    public void a(Activity activity) {
        this.b.a(activity);
    }

    public void a(Context context) {
        k kVar;
        if (k() && (kVar = this.b) != null) {
            kVar.a(context);
        }
    }

    public void a(h3 h3Var) {
        this.f.a(new l(h3Var));
    }

    public void a(h3 h3Var, Map<String, String> map, v2 v2Var) {
        this.f.a(new m(h3Var, map, v2Var));
    }

    public void a(h3 h3Var, Map<String, String> map, w2 w2Var) {
        this.f.a(new h(h3Var, map, w2Var));
    }

    public void a(f.c cVar, k.a aVar) {
        this.f.a(new n(aVar, cVar));
    }

    public void a(Runnable runnable) {
        this.e.a(runnable);
    }

    public void a(String str, k.b bVar) {
        this.j.put(str, bVar);
    }

    public void a(String str, w2 w2Var) {
        Logger.i(this.a, "load interstitial");
        this.f.a(new C0022e(str, w2Var));
    }

    public void a(String str, String str2, h3 h3Var, v2 v2Var) {
        if (this.h.a(getType(), this.c)) {
            a(e6.e.Banner, h3Var, str, str2);
        }
        this.f.a(new i(str, str2, h3Var, v2Var));
    }

    public void a(String str, String str2, h3 h3Var, w2 w2Var) {
        if (this.h.a(getType(), this.c)) {
            a(e6.e.Interstitial, h3Var, str, str2);
        }
        this.f.a(new d(str, str2, h3Var, w2Var));
    }

    public void a(String str, String str2, h3 h3Var, x2 x2Var) {
        if (this.h.a(getType(), this.c)) {
            a(e6.e.RewardedVideo, h3Var, str, str2);
        }
        this.f.a(new b(str, str2, h3Var, x2Var));
    }

    public void a(String str, String str2, w9 w9Var) {
        this.f.a(new a(str, str2, w9Var));
    }

    public void a(String str, String str2, Map<String, String> map, w9 w9Var) {
        this.f.a(new w(str, str2, map, w9Var));
    }

    public void a(Map<String, String> map, w9 w9Var) {
        this.f.a(new x(map, w9Var));
    }

    public void a(JSONObject jSONObject) {
        this.f.a(new o(jSONObject));
    }

    public void a(JSONObject jSONObject, v2 v2Var) {
        this.f.a(new j(jSONObject, v2Var));
    }

    public void a(JSONObject jSONObject, w2 w2Var) {
        this.f.a(new g(jSONObject, w2Var));
    }

    public void a(JSONObject jSONObject, x2 x2Var) {
        this.f.a(new c(jSONObject, x2Var));
    }

    public boolean a(String str) {
        if (this.b == null || !k()) {
            return false;
        }
        return this.b.a(str);
    }

    public void b() {
        k kVar;
        if (k() && (kVar = this.b) != null) {
            kVar.b();
        }
    }

    public void b(Context context) {
        k kVar;
        if (k() && (kVar = this.b) != null) {
            kVar.b(context);
        }
    }

    public void b(h3 h3Var, Map<String, String> map, w2 w2Var) {
        this.f.a(new f(h3Var, map, w2Var));
    }

    /* access modifiers changed from: package-private */
    public void b(Runnable runnable) {
        n5 n5Var = this.g;
        if (n5Var != null) {
            n5Var.c(runnable);
        } else {
            Logger.e(this.a, "mThreadManager = null");
        }
    }

    public void b(String str) {
        Logger.i(this.a, "handleControllerFailed ");
        g6 g6Var = new g6();
        g6Var.a(z3.z, str);
        g6Var.a(z3.x, String.valueOf(this.h.m()));
        l6.a(za.o, (Map<String, Object>) g6Var.a());
        this.h.a(false);
        e(str);
        if (this.d != null) {
            Logger.i(this.a, "cancel timer mControllerReadyTimer");
            this.d.cancel();
        }
        d(str);
    }

    public void b(JSONObject jSONObject) {
    }

    @Deprecated
    public void c() {
    }

    public void c(String str) {
        l6.a(za.y, (Map<String, Object>) new g6().a(z3.x, str).a());
        CountDownTimer countDownTimer = this.d;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        d(str);
    }

    public void d() {
        k kVar;
        if (k() && (kVar = this.b) != null) {
            kVar.d();
        }
    }

    public void destroy() {
        Logger.i(this.a, "destroy controller");
        CountDownTimer countDownTimer = this.d;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        e2 e2Var = this.f;
        if (e2Var != null) {
            e2Var.b();
        }
        this.d = null;
        b((Runnable) new p());
    }

    public void e() {
    }

    public void f() {
        Logger.i(this.a, "handleControllerReady ");
        this.k.a(getType());
        if (e6.c.Web.equals(getType())) {
            l6.a(za.e, (Map<String, Object>) new g6().a(z3.x, String.valueOf(this.h.m())).a());
            m();
        }
        j();
    }

    public e6.c getType() {
        k kVar = this.b;
        return kVar != null ? kVar.getType() : e6.c.None;
    }

    public k i() {
        return this.b;
    }
}
