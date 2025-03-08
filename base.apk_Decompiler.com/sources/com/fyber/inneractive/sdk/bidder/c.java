package com.fyber.inneractive.sdk.bidder;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.bidder.TokenParametersOuterClass$TokenParameters;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.f;
import com.fyber.inneractive.sdk.config.l;
import com.fyber.inneractive.sdk.external.InneractiveAdManager;
import com.fyber.inneractive.sdk.external.InneractiveUserConfig;
import com.fyber.inneractive.sdk.serverapi.b;
import com.fyber.inneractive.sdk.util.k0;
import com.fyber.inneractive.sdk.util.n;
import com.fyber.inneractive.sdk.util.p;
import com.fyber.inneractive.sdk.util.q;
import java.util.List;

public class c {
    public String A;
    public Boolean B;
    public String C;
    public String D;
    public int E;
    public InneractiveUserConfig.Gender F;
    public boolean G;
    public String H;
    public String I;
    public String J;
    public String K;
    public boolean L;
    public final b a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public Long l;
    public int m;
    public int n;
    public TokenParametersOuterClass$TokenParameters.d o = f.a(com.fyber.inneractive.sdk.serverapi.a.c());
    public String p;
    public String q;
    public TokenParametersOuterClass$TokenParameters.h r;
    public Boolean s;
    public Boolean t;
    public Boolean u;
    public boolean v;
    public Boolean w;
    public Boolean x;
    public Boolean y;
    public int z;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            c.this.b = p.g();
        }
    }

    public c(b bVar) {
        this.a = bVar;
        c();
        this.c = bVar.a("2.2.0");
        this.d = bVar.e();
        this.e = bVar.b();
        this.f = bVar.f();
        this.m = bVar.h();
        this.n = bVar.g();
        this.r = bVar.i() ? TokenParametersOuterClass$TokenParameters.h.SECURE : TokenParametersOuterClass$TokenParameters.h.UNSECURE;
        b();
        this.L = InneractiveAdManager.isCurrentUserAChild();
        a();
        this.t = com.fyber.inneractive.sdk.serverapi.a.f();
        this.B = com.fyber.inneractive.sdk.serverapi.a.h();
        this.w = com.fyber.inneractive.sdk.serverapi.a.e();
        this.x = com.fyber.inneractive.sdk.serverapi.a.j();
        this.y = com.fyber.inneractive.sdk.serverapi.a.i();
    }

    public void a() {
        this.a.getClass();
        IAConfigManager iAConfigManager = IAConfigManager.M;
        this.g = iAConfigManager.p;
        if (!InneractiveAdManager.isCurrentUserAChild()) {
            this.a.getClass();
            this.h = n.h();
            this.i = this.a.a();
            this.j = this.a.c();
            this.k = this.a.d();
            this.a.getClass();
            this.q = k0.e().key;
            int i2 = f.a;
            String property = System.getProperty("ia.testEnvironmentConfiguration.device");
            if (TextUtils.isEmpty(property)) {
                property = l.a();
            }
            this.A = property;
            this.H = iAConfigManager.j.getZipCode();
        }
        this.F = iAConfigManager.j.getGender();
        this.E = iAConfigManager.j.getAge();
        this.D = iAConfigManager.k;
        this.l = com.fyber.inneractive.sdk.serverapi.a.d();
        this.a.getClass();
        List<String> list = iAConfigManager.q;
        if (list != null && !list.isEmpty()) {
            this.p = p.b(",", list);
        }
        this.C = com.fyber.inneractive.sdk.serverapi.a.a();
        this.v = com.fyber.inneractive.sdk.serverapi.a.g().booleanValue();
        this.z = com.fyber.inneractive.sdk.serverapi.a.b().intValue();
        this.G = iAConfigManager.l;
        this.s = com.fyber.inneractive.sdk.serverapi.a.k();
        b();
        this.u = com.fyber.inneractive.sdk.serverapi.a.l();
        iAConfigManager.E.d();
        com.fyber.inneractive.sdk.ignite.c cVar = iAConfigManager.E;
        this.J = cVar.d;
        this.K = cVar.c;
        this.a.getClass();
        this.m = p.b(p.f());
        this.a.getClass();
        this.n = p.b(p.e());
    }

    public void a(String str) {
        this.b = str;
    }

    public final void b() {
        IAConfigManager iAConfigManager = IAConfigManager.M;
        if (!TextUtils.isEmpty(iAConfigManager.o)) {
            this.I = String.format("%s_%s", new Object[]{iAConfigManager.m, iAConfigManager.o});
            return;
        }
        this.I = iAConfigManager.m;
    }

    public final void c() {
        if (TextUtils.isEmpty(this.b)) {
            q.a(new a());
        }
    }
}
