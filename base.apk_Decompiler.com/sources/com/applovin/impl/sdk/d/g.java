package com.applovin.impl.sdk.d;

import com.applovin.impl.sdk.c.d;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.x;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class g {
    private final Map<String, Long> aTm = new HashMap();
    private final n sdk;

    public g(n nVar) {
        if (nVar != null) {
            this.sdk = nVar;
            return;
        }
        throw new IllegalArgumentException("No sdk specified");
    }

    public long a(f fVar) {
        return a(fVar, 1);
    }

    /* access modifiers changed from: package-private */
    public long a(f fVar, long j) {
        long longValue;
        synchronized (this.aTm) {
            Long l = this.aTm.get(fVar.getName());
            if (l == null) {
                l = 0L;
            }
            longValue = l.longValue() + j;
            this.aTm.put(fVar.getName(), Long.valueOf(longValue));
        }
        Ka();
        return longValue;
    }

    public long b(f fVar) {
        long longValue;
        synchronized (this.aTm) {
            Long l = this.aTm.get(fVar.getName());
            if (l == null) {
                l = 0L;
            }
            longValue = l.longValue();
        }
        return longValue;
    }

    public void b(f fVar, long j) {
        synchronized (this.aTm) {
            this.aTm.put(fVar.getName(), Long.valueOf(j));
        }
        Ka();
    }

    public void JW() {
        synchronized (this.aTm) {
            this.aTm.clear();
        }
        Ka();
    }

    public void c(f fVar) {
        synchronized (this.aTm) {
            this.aTm.remove(fVar.getName());
        }
        Ka();
    }

    public void JX() {
        synchronized (this.aTm) {
            for (f name : f.JV()) {
                this.aTm.remove(name.getName());
            }
            Ka();
        }
    }

    public JSONObject JY() {
        JSONObject jSONObject;
        synchronized (this.aTm) {
            jSONObject = new JSONObject();
            for (Map.Entry next : this.aTm.entrySet()) {
                JsonUtils.putLong(jSONObject, (String) next.getKey(), ((Long) next.getValue()).longValue());
            }
        }
        return jSONObject;
    }

    public void JZ() {
        try {
            JSONObject jSONObject = new JSONObject((String) this.sdk.b(d.aRD, JsonUtils.EMPTY_JSON));
            synchronized (this.aTm) {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    try {
                        String next = keys.next();
                        this.aTm.put(next, Long.valueOf(jSONObject.getLong(next)));
                    } catch (JSONException unused) {
                    }
                }
            }
        } catch (Throwable th) {
            this.sdk.BN();
            if (x.Fn()) {
                this.sdk.BN().c("GlobalStatsManager", "Unable to load stats", th);
            }
        }
    }

    private void Ka() {
        this.sdk.BO().h(new g$$ExternalSyntheticLambda0(this));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Kb() {
        try {
            this.sdk.a(d.aRD, JY().toString());
        } catch (Throwable th) {
            this.sdk.BN();
            if (x.Fn()) {
                this.sdk.BN().c("GlobalStatsManager", "Unable to save stats", th);
            }
        }
    }
}
