package com.fyber.inneractive.sdk.network;

import com.fyber.inneractive.sdk.config.global.s;
import com.fyber.inneractive.sdk.ignite.IgniteResponseOuterClass$IgniteResponse;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.u;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class k0 extends f0<IgniteResponseOuterClass$IgniteResponse> {
    public final byte[] r;
    public final AtomicInteger s = new AtomicInteger();

    public k0(w<IgniteResponseOuterClass$IgniteResponse> wVar, byte[] bArr, g gVar, s sVar) {
        super(wVar, gVar, sVar);
        this.r = bArr;
    }

    public String a() {
        return "https://init-mp.fyber.com/init";
    }

    public p0 i() {
        return p0.HIGH;
    }

    public boolean o() {
        return this.s.getAndIncrement() < 4;
    }

    public String q() {
        return "application/x-protobuf; messageType=IgniteRequest";
    }

    public z r() {
        return z.POST;
    }

    public byte[] u() {
        return this.r;
    }

    public int v() {
        return ((int) Math.pow(2.0d, (double) this.s.get())) * 1000;
    }

    public b0 a(j jVar, Map<String, List<String>> map, int i) throws Exception {
        try {
            b0 b0Var = new b0();
            InputStream inputStream = jVar.c;
            if (inputStream != null) {
                String str = new String(u.a(inputStream), "UTF-8");
                T parseFrom = IgniteResponseOuterClass$IgniteResponse.parseFrom(str.getBytes());
                b0Var.b = str;
                b0Var.a = parseFrom;
            }
            return b0Var;
        } catch (Exception e) {
            IAlog.a("failed parse ignite network request", e, new Object[0]);
            throw new a0(e);
        } catch (Throwable th) {
            IAlog.a("failed parse ignite network request", th, new Object[0]);
            throw new a0("failed to parse ignite network request");
        }
    }
}
