package com.applovin.impl.sdk.e;

import com.applovin.impl.sdk.b.c;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.network.b;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.i;
import com.applovin.impl.sdk.x;
import java.util.Collections;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public abstract class ad extends aa {
    /* access modifiers changed from: protected */
    public abstract void b(c cVar);

    /* access modifiers changed from: protected */
    public abstract boolean zN();

    protected ad(String str, n nVar) {
        super(str, nVar);
    }

    public void run() {
        a(KO(), new b.d<JSONObject>() {
            /* renamed from: a */
            public void d(JSONObject jSONObject, int i) {
                if (ad.this.zN()) {
                    x xVar = ad.this.logger;
                    if (x.Fn()) {
                        x xVar2 = ad.this.logger;
                        String str = ad.this.tag;
                        xVar2.i(str, "Reward validation succeeded with code " + i + " but task was cancelled already");
                    }
                    x xVar3 = ad.this.logger;
                    if (x.Fn()) {
                        x xVar4 = ad.this.logger;
                        String str2 = ad.this.tag;
                        xVar4.i(str2, "Response: " + jSONObject);
                        return;
                    }
                    return;
                }
                x xVar5 = ad.this.logger;
                if (x.Fn()) {
                    x xVar6 = ad.this.logger;
                    String str3 = ad.this.tag;
                    xVar6.f(str3, "Reward validation succeeded with code " + i + " and response: " + jSONObject);
                }
                ad.this.S(jSONObject);
            }

            public void a(int i, String str, JSONObject jSONObject) {
                if (ad.this.zN()) {
                    x xVar = ad.this.logger;
                    if (x.Fn()) {
                        x xVar2 = ad.this.logger;
                        String str2 = ad.this.tag;
                        xVar2.i(str2, "Reward validation failed with error code " + i + " but task was cancelled already");
                        return;
                    }
                    return;
                }
                x xVar3 = ad.this.logger;
                if (x.Fn()) {
                    x xVar4 = ad.this.logger;
                    String str3 = ad.this.tag;
                    xVar4.i(str3, "Reward validation failed with code " + i + " and error: " + str);
                }
                ad.this.gu(i);
            }
        });
    }

    /* access modifiers changed from: protected */
    public int KN() {
        return ((Integer) this.sdk.a(com.applovin.impl.sdk.c.b.aMf)).intValue();
    }

    /* access modifiers changed from: private */
    public void S(JSONObject jSONObject) {
        c T = T(jSONObject);
        b(T);
        x xVar = this.logger;
        if (x.Fn()) {
            x xVar2 = this.logger;
            String str = this.tag;
            xVar2.f(str, "Pending reward handled: " + T);
        }
    }

    private c T(JSONObject jSONObject) {
        Map<String, String> map;
        String str;
        JSONObject jSONObject2 = JsonUtils.getJSONObject(JsonUtils.getJSONArray(jSONObject, "results", new JSONArray()), 0, new JSONObject());
        i.j(jSONObject2, this.sdk);
        i.i(jSONObject, this.sdk);
        i.k(jSONObject, this.sdk);
        try {
            map = JsonUtils.toStringMap((JSONObject) jSONObject2.get("params"));
        } catch (Throwable unused) {
            map = Collections.emptyMap();
        }
        try {
            str = jSONObject2.getString("result");
        } catch (Throwable unused2) {
            str = "network_timeout";
        }
        return c.e(str, map);
    }
}
