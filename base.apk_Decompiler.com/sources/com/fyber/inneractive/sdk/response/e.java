package com.fyber.inneractive.sdk.response;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.config.global.s;
import com.fyber.inneractive.sdk.dv.g;
import com.fyber.inneractive.sdk.external.ImpressionData;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveErrorCode;
import com.fyber.inneractive.sdk.ignite.k;
import java.util.Map;

public abstract class e {
    public String A;
    public boolean B = false;
    public String C;
    public String D;
    public String E;
    public k F = k.NONE;
    public String G;
    public boolean H = false;
    public long I = 0;
    public long a;
    public long b;
    public long c;
    public String d;
    public int e;
    public int f;
    public int g;
    public String h;
    public String i;
    public String j;
    public String k;
    public String l;
    public String m;
    public UnitDisplayType n;
    public String o;
    public Map<String, String> p;
    public String q;
    public ImpressionData r;
    public g s;
    public int t = 0;
    public float u = -1.0f;
    public String v;
    public int w = -1;
    public Exception x;
    public String y;
    public String z;

    public UnitDisplayType a() {
        return this.n;
    }

    public abstract InneractiveErrorCode a(InneractiveAdRequest inneractiveAdRequest);

    public abstract InneractiveErrorCode a(InneractiveAdRequest inneractiveAdRequest, s sVar);

    public boolean b() {
        return this.F != k.NONE && !TextUtils.isEmpty(this.y) && !TextUtils.isEmpty(this.E) && !TextUtils.isEmpty(this.G);
    }

    public boolean c() {
        return this.a < System.currentTimeMillis();
    }

    public void a(k kVar) {
        if (kVar == null) {
            kVar = k.NONE;
        }
        this.F = kVar;
    }
}
