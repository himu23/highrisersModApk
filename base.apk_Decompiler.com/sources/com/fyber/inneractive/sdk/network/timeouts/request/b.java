package com.fyber.inneractive.sdk.network.timeouts.request;

import com.fyber.inneractive.sdk.config.global.features.j;

public class b extends a {
    public b(String str, j jVar) {
        super(str, jVar, (String) null);
    }

    public int a(j jVar, String str) {
        return jVar.e(str);
    }

    public int b(j jVar, String str) {
        jVar.getClass();
        String a = j.a(str, "min", "rat");
        jVar.h(str);
        return jVar.a(a, 5000);
    }

    public int c(j jVar, String str) {
        jVar.getClass();
        return jVar.a(j.a(str, "rat_perc"), "read".equalsIgnoreCase(str) ? 15 : 10);
    }

    public int a(j jVar) {
        return jVar.d();
    }
}
