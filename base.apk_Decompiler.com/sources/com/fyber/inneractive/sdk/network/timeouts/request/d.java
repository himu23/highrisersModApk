package com.fyber.inneractive.sdk.network.timeouts.request;

import com.fyber.inneractive.sdk.config.global.features.j;
import com.fyber.inneractive.sdk.util.IAlog;

public class d extends a {
    public double m;

    public d(String str, j jVar, String str2) {
        super(str, jVar, str2);
    }

    public int a(j jVar, String str) {
        return jVar.b(str, this.l);
    }

    public int b(j jVar, String str) {
        String str2 = this.l;
        jVar.getClass();
        String a = j.a(str, "min", "rat", "bidding", j.i(str2));
        String a2 = j.a(str, "min", "rat", "bidding", "all_mediators");
        jVar.h(str);
        return jVar.a(a, jVar.a(a2, 5000));
    }

    public int c(j jVar, String str) {
        String str2 = this.l;
        jVar.getClass();
        String a = j.a(str, "rat", "bidding", "perc", j.i(str2));
        String a2 = j.a(str, "rat", "bidding", "perc", "all_mediators");
        "read".equalsIgnoreCase(str);
        return jVar.a(a, jVar.a(a2, 15));
    }

    public void d(j jVar, String str) {
        super.d(jVar, str);
        this.g = jVar.a("reverse_retries", true);
        int a = jVar.a(j.a("retry_interval", "rat", "bidding"), jVar.a(j.a("retry_interval", "all_mediators"), 100));
        this.e = a;
        this.c = (this.i + this.h) - (a + this.f);
        this.d = jVar.a(j.a("bidding", "irat", j.i(this.l)), jVar.a(j.a("bidding", "irat", "all_mediators"), 10000));
        this.m = ((double) Math.min(this.k, this.j)) / ((double) Math.max(this.k, this.j));
        b(this.d);
        this.a = Math.max(0, a());
        if (this.g) {
            IAlog.a("%s : RequestBiddingAdTimeout shouldReverseRetries - reversing timeouts", IAlog.a((Object) this));
            a(0);
        }
        IAlog.a("%s : RequestBiddingAdTimeout init timeouts, total retries: %d", IAlog.a((Object) this), Integer.valueOf(this.a));
    }

    public int a(j jVar) {
        String str = this.l;
        jVar.getClass();
        return jVar.a(j.a("timeout", "threshold", "rat", "bidding", j.i(str)), jVar.a(j.a("timeout", "threshold", "rat", "bidding", "all_mediators"), 300));
    }

    public int a(int i) {
        if (this.g) {
            i = this.a - i;
        }
        int i2 = this.d + (this.b * i);
        IAlog.a("%s : RequestBiddingAdTimeout resolveTimeoutForRetry, timeout: %d ms for retry: %d", IAlog.a((Object) this), Integer.valueOf(i2), Integer.valueOf(i));
        b(i2);
        return i2;
    }

    public int b() {
        return this.a;
    }

    public int c() {
        return this.e;
    }

    public void b(int i) {
        double d = this.m;
        if (d == 1.0d || d == 0.0d) {
            IAlog.a("%s : RequestBiddingAdTimeout Ratio: %f, connection and read timeouts should be divided in equal proportions", IAlog.a((Object) this), Double.valueOf(this.m));
            this.m = 0.5d;
        }
        int i2 = (int) (((double) i) * this.m);
        this.h = i2;
        this.i = i - i2;
        IAlog.a("%s : RequestBiddingAdTimeout Update timeouts connection: %d read: %d", IAlog.a((Object) this), Integer.valueOf(this.i), Integer.valueOf(this.h));
    }
}
