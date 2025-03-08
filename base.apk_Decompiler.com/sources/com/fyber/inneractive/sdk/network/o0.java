package com.fyber.inneractive.sdk.network;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.bidder.adm.AdmParametersOuterClass$AdmParameters;
import com.fyber.inneractive.sdk.bidder.adm.f;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.config.global.features.j;
import com.fyber.inneractive.sdk.config.global.s;
import com.fyber.inneractive.sdk.dv.g;
import com.fyber.inneractive.sdk.network.timeouts.request.a;
import com.fyber.inneractive.sdk.network.timeouts.request.b;
import com.fyber.inneractive.sdk.network.timeouts.request.d;
import com.fyber.inneractive.sdk.response.e;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.u;
import com.fyber.inneractive.sdk.util.x0;
import java.io.InputStream;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class o0 extends f0<e> {
    public final String r;
    public final f s;
    public int t = 0;
    public final e u;
    public final s v;
    public final a w;

    public o0(w<e> wVar, String str, f fVar, s sVar, e eVar) {
        super(wVar, x.a().b(), sVar);
        this.q = true;
        this.r = str;
        this.s = fVar;
        this.u = eVar;
        this.v = sVar;
        this.w = a(eVar, fVar, sVar);
    }

    public String a() {
        return this.r;
    }

    public void b(long j) {
        super.b(j);
        IAlog.a("%s : NetworkRequestMarkup : set start connection timestamp", IAlog.a((Object) this));
    }

    public void c(long j) {
        super.c(j);
        IAlog.a("%s : NetworkRequestMarkup : set end read timestamp, total execution time: %d", IAlog.a((Object) this), Integer.valueOf(super.y()));
    }

    public void d() {
        super.d();
        IAlog.a("%s : NetworkRequestMarkup cancel by timeout at retry: %d", IAlog.a((Object) this), Integer.valueOf(this.t));
        y yVar = IAConfigManager.M.s;
        this.a = true;
        o0 o0Var = new o0(this);
        if (!(yVar instanceof y) || !yVar.d(o0Var)) {
            IAlog.a("%s : NetworkRequestMarkup won't retry - resolve request with `Bidding ad request passed allowed time` at retry: %d", IAlog.a((Object) this), Integer.valueOf(this.t));
            a(null, new Exception("Bidding ad request passed allowed time"), false);
        }
    }

    public p0 i() {
        return p0.HIGH;
    }

    public s m() {
        return this.v;
    }

    public u0 n() {
        a aVar = this.w;
        return new u0(aVar.i, aVar.h);
    }

    public boolean o() {
        if (this.a) {
            return false;
        }
        int i = this.t + 1;
        this.t = i;
        if (i > this.w.b()) {
            IAlog.a("%s : NetworkRequestMarkup Should enable retry - FALSE, current retry: %d total retries: %d, request id: %s", IAlog.a((Object) this), Integer.valueOf(this.t - 1), Integer.valueOf(this.w.b()), this.g);
            return false;
        }
        IAlog.a("%s : NetworkRequestMarkup Should enable retry - TRUE, current retry: %d total retries: %d, request id: %s", IAlog.a((Object) this), Integer.valueOf(this.t - 1), Integer.valueOf(this.w.b()), this.g);
        this.w.a(this.t);
        return true;
    }

    public z r() {
        return z.GET;
    }

    public int v() {
        return this.w.c();
    }

    public int x() {
        int y = super.y();
        a aVar = this.w;
        return y + ((aVar.f + aVar.c()) * this.t);
    }

    public int y() {
        return super.y();
    }

    public b0 a(j jVar, Map<String, List<String>> map, int i) throws Exception {
        b0 b0Var = new b0();
        try {
            InputStream inputStream = jVar.c;
            if (inputStream != null) {
                d(System.currentTimeMillis());
                StringBuffer a = u.a(inputStream, false);
                c(System.currentTimeMillis());
                String stringBuffer = a.toString();
                int b = this.s.b();
                f fVar = this.s;
                fVar.c = stringBuffer;
                T a2 = a(b, (n) null, fVar, (g) null);
                a2.h = stringBuffer;
                b0Var.a = a2;
            }
            return b0Var;
        } catch (b | SocketTimeoutException | UnknownHostException e) {
            IAlog.a("failed parse adm network request but will re-try", e, new Object[0]);
            c(System.currentTimeMillis());
            throw new a1(e);
        } catch (Exception e2) {
            c(System.currentTimeMillis());
            IAlog.a("failed parse adm network request", e2, new Object[0]);
            throw new a0(e2);
        }
    }

    public int h() {
        return this.w.f;
    }

    public void d(long j) {
        super.d(j);
        IAlog.a("%s : NetworkRequestMarkup : set start read timestamp", IAlog.a((Object) this));
    }

    public static a a(e eVar, f fVar, s sVar) {
        String lowerCase = UnitDisplayType.BANNER.name().toLowerCase(Locale.US);
        if (eVar == null || eVar.n == null) {
            AdmParametersOuterClass$AdmParameters admParametersOuterClass$AdmParameters = fVar.a;
            if (admParametersOuterClass$AdmParameters != null) {
                lowerCase = x0.a(String.valueOf(admParametersOuterClass$AdmParameters.getSpotId()));
            }
        } else {
            lowerCase = x0.a(eVar);
        }
        String str = IAConfigManager.M.m;
        j jVar = (j) sVar.a(j.class);
        if (TextUtils.isEmpty(str)) {
            return new b(lowerCase, jVar);
        }
        return new d(lowerCase, jVar, str);
    }

    public o0(o0 o0Var) {
        super(o0Var);
        this.q = true;
        this.r = o0Var.r;
        this.s = o0Var.s;
        this.u = o0Var.u;
        this.v = o0Var.v;
        this.w = o0Var.w;
        this.t = o0Var.t;
    }

    public j a(String str) throws Exception {
        IAlog.a("%s : NetworkRequestMarkup Ad request execution started, retry number: %d, timeouts(connection: %d read: %d)", IAlog.a((Object) this), Integer.valueOf(this.t), Integer.valueOf(n().a), Integer.valueOf(n().b));
        return super.a(str);
    }

    public void a(long j) {
        super.a(j);
        IAlog.a("%s : NetworkRequestMarkup : set end connection timestamp, total execution time: %d", IAlog.a((Object) this), Integer.valueOf(super.y()));
    }
}
