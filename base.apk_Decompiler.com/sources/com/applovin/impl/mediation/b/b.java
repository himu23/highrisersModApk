package com.applovin.impl.mediation.b;

import com.applovin.impl.mediation.g;
import com.applovin.impl.sdk.c.a;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.u;
import com.applovin.mediation.MaxAdFormat;
import java.util.Map;
import org.json.JSONObject;

public class b extends e {
    public b(int i, Map<String, Object> map, JSONObject jSONObject, JSONObject jSONObject2, n nVar) {
        super(i, map, jSONObject, jSONObject2, (g) null, nVar);
    }

    private b(b bVar, g gVar) {
        super(bVar.ah(), bVar.getLocalExtraParameters(), bVar.yz(), bVar.yy(), gVar, bVar.sdk);
    }

    public a k(g gVar) {
        return new b(this, gVar);
    }

    public int getWidth() {
        int intFromAdObject = getIntFromAdObject("ad_view_width", -2);
        if (intFromAdObject != -2) {
            return intFromAdObject;
        }
        MaxAdFormat format = getFormat();
        if (format.isAdViewAd()) {
            return format.getSize().getWidth();
        }
        throw new IllegalStateException("Invalid ad format");
    }

    public int getHeight() {
        int intFromAdObject = getIntFromAdObject("ad_view_height", -2);
        if (intFromAdObject != -2) {
            return intFromAdObject;
        }
        MaxAdFormat format = getFormat();
        if (format.isAdViewAd()) {
            return format.getSize().getHeight();
        }
        throw new IllegalStateException("Invalid ad format");
    }

    public long xR() {
        return getLongFromAdObject("viewability_imp_delay_ms", ((Long) this.sdk.a(com.applovin.impl.sdk.c.b.aMs)).longValue());
    }

    public boolean xS() {
        return xT() >= 0;
    }

    public long xT() {
        long longFromAdObject = getLongFromAdObject("ad_refresh_ms", -1);
        if (longFromAdObject >= 0) {
            return longFromAdObject;
        }
        return getLongFromFullResponse("ad_refresh_ms", ((Long) this.sdk.a(a.aJp)).longValue());
    }

    public boolean xU() {
        return b("proe", (Boolean) this.sdk.a(a.aJR)).booleanValue();
    }

    public long xV() {
        return u.dF(getStringFromAdObject("bg_color", (String) null));
    }
}
