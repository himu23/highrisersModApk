package com.fyber.inneractive.sdk.metrics;

import java.util.HashMap;
import java.util.Map;

public class d implements f {
    public Long a = null;
    public Long b = null;
    public Long c = null;
    public Long d = null;
    public Long e = null;
    public Long f = null;
    public Long g = null;
    public Long h = null;

    public boolean a() {
        return true;
    }

    public Long b() {
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        this.g = valueOf;
        return valueOf;
    }

    public Long c() {
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        this.a = valueOf;
        return valueOf;
    }

    public Long d() {
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        this.d = valueOf;
        return valueOf;
    }

    public Long e() {
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        this.f = valueOf;
        return valueOf;
    }

    public Long f() {
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        this.b = valueOf;
        return valueOf;
    }

    public Long g() {
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        this.c = valueOf;
        return valueOf;
    }

    public Long h() {
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        this.h = valueOf;
        return valueOf;
    }

    public Long i() {
        Long valueOf = Long.valueOf(System.currentTimeMillis());
        this.e = valueOf;
        return valueOf;
    }

    public Map<String, Long> j() {
        HashMap hashMap = new HashMap();
        Long l = this.b;
        if (!(l == null || this.a == null)) {
            hashMap.put("sdk_init_network_req", Long.valueOf(l.longValue() - this.a.longValue()));
        }
        Long l2 = this.h;
        if (!(l2 == null || this.b == null)) {
            hashMap.put("sdk_got_response_from_markup_url", Long.valueOf(l2.longValue() - this.b.longValue()));
        }
        Long l3 = this.d;
        if (!(l3 == null || this.h == null)) {
            hashMap.put("sdk_parsed_res", Long.valueOf(l3.longValue() - this.h.longValue()));
        }
        Long l4 = this.c;
        if (!(l4 == null || this.b == null)) {
            hashMap.put("sdk_got_server_res", Long.valueOf(l4.longValue() - this.b.longValue()));
        }
        Long l5 = this.d;
        if (!(l5 == null || this.c == null)) {
            hashMap.put("sdk_parsed_res", Long.valueOf(l5.longValue() - this.c.longValue()));
        }
        Long l6 = this.e;
        if (!(l6 == null || this.d == null)) {
            hashMap.put("ad_loaded_result", Long.valueOf(l6.longValue() - this.d.longValue()));
        }
        Long l7 = this.f;
        if (!(l7 == null || this.e == null)) {
            hashMap.put("publisher_notified", Long.valueOf(l7.longValue() - this.e.longValue()));
        }
        Long l8 = this.g;
        if (!(l8 == null || this.a == null)) {
            hashMap.put("roundtrip", Long.valueOf(l8.longValue() - this.a.longValue()));
        }
        return hashMap;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("MetricsCollectorData{");
        if (!(this.a == null || this.b == null)) {
            sb.append(" sdk_init_network_req=");
            sb.append(this.b.longValue() - this.a.longValue());
        }
        if (!(this.h == null || this.b == null)) {
            sb.append(", sdk_got_response_from_markup_url=");
            sb.append(this.h.longValue() - this.b.longValue());
        }
        if (!(this.c == null || this.b == null)) {
            sb.append(", sdk_got_server_res=");
            sb.append(this.c.longValue() - this.b.longValue());
        }
        if (!(this.d == null || this.c == null)) {
            sb.append(", sdk_parsed_res=");
            sb.append(this.d.longValue() - this.c.longValue());
        }
        if (!(this.e == null || this.d == null)) {
            sb.append(", ad_loaded_result=");
            sb.append(this.e.longValue() - this.d.longValue());
        }
        if (!(this.f == null || this.e == null)) {
            sb.append(", publisher_notified=");
            sb.append(this.f.longValue() - this.e.longValue());
        }
        if (!(this.g == null || this.a == null)) {
            sb.append(", roundtrip=");
            sb.append(this.g.longValue() - this.a.longValue());
        }
        sb.append(" }");
        return sb.toString();
    }
}
