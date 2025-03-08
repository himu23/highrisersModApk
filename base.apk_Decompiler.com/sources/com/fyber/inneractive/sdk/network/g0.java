package com.fyber.inneractive.sdk.network;

import android.content.Context;
import com.fyber.inneractive.sdk.cache.a;
import com.fyber.inneractive.sdk.cache.j;
import com.fyber.inneractive.sdk.external.InvalidAppIdException;
import com.fyber.inneractive.sdk.network.v;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.u;
import java.util.List;
import java.util.Map;

public class g0<T> extends f0<T> {
    public final Context r;
    public final a<T> s;
    public v<T> t;

    public g0(w<T> wVar, Context context, a<T> aVar) {
        this(wVar, context, aVar, x.a().b());
    }

    public b0 a(j jVar, Map<String, List<String>> map, int i) throws Exception {
        b0 b0Var = new b0();
        try {
            String stringBuffer = u.a(jVar.c, false).toString();
            b0Var.a = this.s.a(stringBuffer);
            b0Var.b = stringBuffer;
            return b0Var;
        } catch (Exception e) {
            IAlog.a("failed parse cacheable network request", e, new Object[0]);
            if (e instanceof InvalidAppIdException) {
                throw e;
            }
            throw new a0(e);
        }
    }

    public String c() {
        return this.s.c();
    }

    public p0 i() {
        return p0.LOW;
    }

    public a<T> k() {
        j jVar;
        Context context = this.r;
        a<T> aVar = this.s;
        v<T> vVar = new v<>(context, aVar);
        this.t = vVar;
        try {
            if (!aVar.d()) {
                jVar = new j(new v.a());
            } else {
                ResultData a = vVar.b.a(vVar.a(vVar.b.c()));
                if (vVar.c == null) {
                    vVar.c = context.getSharedPreferences("IAConfigurationPreferences", 0);
                }
                jVar = new j(a, vVar.c.getString(vVar.b.b(), (String) null));
            }
        } catch (Exception e) {
            if (vVar.c == null) {
                vVar.c = vVar.a.getSharedPreferences("IAConfigurationPreferences", 0);
            }
            vVar.c.edit().remove(vVar.b.b()).apply();
            jVar = new j(e);
        }
        return new a<>(jVar.b, jVar.a, this.s.c());
    }

    public boolean o() {
        return false;
    }

    public z r() {
        return z.GET;
    }

    public int v() {
        return 0;
    }

    public g0(w<T> wVar, Context context, a<T> aVar, g gVar) {
        super(wVar, gVar);
        this.r = context;
        this.s = aVar;
    }

    public String a() {
        return this.s.a();
    }

    public void a(b0 b0Var, String str, String str2) {
        v<T> vVar = this.t;
        if (vVar != null) {
            if (vVar.c == null) {
                vVar.c = vVar.a.getSharedPreferences("IAConfigurationPreferences", 0);
            }
            vVar.c.edit().putString(vVar.b.b(), str2).apply();
            if (!b0Var.b.isEmpty() && !str.isEmpty()) {
                if (!this.t.a(str, b0Var.b)) {
                    IAlog.b("Failed to cache file", new Object[0]);
                } else {
                    this.s.a(b0Var.a);
                }
            }
        }
    }
}
