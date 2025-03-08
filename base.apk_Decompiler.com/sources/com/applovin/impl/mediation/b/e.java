package com.applovin.impl.mediation.b;

import com.applovin.impl.mediation.g;
import com.applovin.impl.sdk.c.a;
import com.applovin.impl.sdk.c.b;
import com.applovin.impl.sdk.n;
import com.applovin.mediation.MaxAdFormat;
import java.util.Map;
import org.json.JSONObject;

public abstract class e extends a {
    protected e(int i, Map<String, Object> map, JSONObject jSONObject, JSONObject jSONObject2, g gVar, n nVar) {
        super(i, map, jSONObject, jSONObject2, gVar, nVar);
    }

    public int yq() {
        b bVar;
        MaxAdFormat format = getFormat();
        if (format == MaxAdFormat.BANNER) {
            bVar = b.aMt;
        } else if (format == MaxAdFormat.MREC) {
            bVar = b.aMv;
        } else if (format == MaxAdFormat.LEADER) {
            bVar = b.aMx;
        } else {
            bVar = format == MaxAdFormat.NATIVE ? b.aMz : null;
        }
        if (bVar != null) {
            return getIntFromAdObject("viewability_min_width", ((Integer) this.sdk.a(bVar)).intValue());
        }
        return 0;
    }

    public int yr() {
        b bVar;
        MaxAdFormat format = getFormat();
        if (format == MaxAdFormat.BANNER) {
            bVar = b.aMu;
        } else if (format == MaxAdFormat.MREC) {
            bVar = b.aMw;
        } else if (format == MaxAdFormat.LEADER) {
            bVar = b.aMy;
        } else {
            bVar = format == MaxAdFormat.NATIVE ? b.aMA : null;
        }
        if (bVar != null) {
            return getIntFromAdObject("viewability_min_height", ((Integer) this.sdk.a(bVar)).intValue());
        }
        return 0;
    }

    public float ys() {
        return getFloatFromAdObject("viewability_min_alpha", ((Float) this.sdk.a(a.aMB)).floatValue() / 100.0f);
    }

    public int yt() {
        return getIntFromAdObject("viewability_min_pixels", -1);
    }

    public float yu() {
        return getFloatFromAdObject("viewability_min_percentage_dp", -1.0f);
    }

    public float yv() {
        return getFloatFromAdObject("viewability_min_percentage_pixels", -1.0f);
    }

    public boolean yw() {
        return yt() >= 0 || yu() >= 0.0f || yv() >= 0.0f;
    }

    public long yx() {
        return getLongFromAdObject("viewability_timer_min_visible_ms", ((Long) this.sdk.a(a.aMC)).longValue());
    }
}
