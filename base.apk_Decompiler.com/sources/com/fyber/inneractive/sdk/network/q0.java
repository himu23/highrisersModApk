package com.fyber.inneractive.sdk.network;

import com.fyber.inneractive.sdk.click.c;
import com.fyber.inneractive.sdk.util.u;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class q0 extends f0<c> {
    public final String r;

    public q0(w<c> wVar, String str, g gVar) {
        super(wVar, gVar);
        this.r = str;
    }

    public String a() {
        return this.r;
    }

    public p0 i() {
        return p0.LOW;
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

    public b0 a(j jVar, Map<String, List<String>> map, int i) throws Exception {
        b0 b0Var = new b0();
        T cVar = new c();
        if (jVar != null) {
            List<String> list = jVar.f;
            cVar.a.clear();
            cVar.a.addAll(list);
            InputStream inputStream = jVar.c;
            if (inputStream != null) {
                String stringBuffer = u.a(inputStream, false).toString();
                cVar.b = stringBuffer;
                b0Var.b = stringBuffer;
            }
        }
        b0Var.a = cVar;
        return b0Var;
    }
}
