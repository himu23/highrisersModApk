package com.fyber.inneractive.sdk.network;

import com.fyber.inneractive.sdk.util.IAlog;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class i0 extends f0<String> {
    public String r;
    public final String s;
    public final AtomicInteger t = new AtomicInteger();

    public i0(w<String> wVar, String str, String str2, g gVar) {
        super(wVar, gVar);
        this.s = str;
        this.r = str2;
    }

    public String a() {
        return this.s;
    }

    public p0 i() {
        return p0.LOW;
    }

    public boolean o() {
        return this.t.getAndIncrement() < 4;
    }

    public z r() {
        return z.POST;
    }

    public int v() {
        return ((int) Math.pow(2.0d, (double) this.t.get())) * 1000;
    }

    public b0 a(j jVar, Map<String, List<String>> map, int i) throws Exception {
        try {
            b0 b0Var = new b0();
            b0Var.a = String.valueOf(i);
            return b0Var;
        } catch (Exception e) {
            IAlog.a("failed parse event network request", e, new Object[0]);
            throw new a0(e);
        }
    }

    public byte[] u() {
        try {
            IAlog.a("NetworkRequestEvent: network request body %s", this.r);
            return this.r.getBytes(StandardCharsets.UTF_8);
        } catch (Exception unused) {
            return new byte[0];
        }
    }
}
