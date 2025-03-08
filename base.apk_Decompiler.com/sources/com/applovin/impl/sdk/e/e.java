package com.applovin.impl.sdk.e;

import com.applovin.impl.sdk.c.b;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.network.c;
import com.applovin.impl.sdk.o;
import com.applovin.impl.sdk.p;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.i;
import com.applovin.impl.sdk.utils.p;
import com.applovin.impl.sdk.utils.u;
import com.applovin.impl.sdk.x;
import com.applovin.sdk.AppLovinSdk;
import com.ironsource.i9;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

class e extends d {
    e(n nVar) {
        super("TaskApiSubmitData", nVar);
    }

    public void run() {
        x xVar = this.logger;
        if (x.Fn()) {
            this.logger.g(this.tag, "Submitting user data...");
        }
        Map<String, String> F = i.F(this.sdk);
        JSONObject jSONObject = new JSONObject();
        O(jSONObject);
        P(jSONObject);
        if (((Boolean) this.sdk.a(b.aQe)).booleanValue() || ((Boolean) this.sdk.a(b.aPY)).booleanValue()) {
            JsonUtils.putAll(jSONObject, (Map<String, ?>) F);
            F = null;
        }
        a(F, jSONObject);
    }

    /* access modifiers changed from: private */
    public void N(JSONObject jSONObject) {
        JSONObject jSONObject2 = JsonUtils.getJSONObject(JsonUtils.getJSONArray(jSONObject, "results", new JSONArray()), 0, new JSONObject());
        this.sdk.BP().a((b<?>) b.aKl, (Object) JsonUtils.getString(jSONObject2, "device_id", ""));
        this.sdk.BP().a((b<?>) b.aKo, (Object) JsonUtils.getString(jSONObject2, "device_token", ""));
        this.sdk.BP().a((b<?>) b.aKp, (Object) Long.valueOf(JsonUtils.getLong(jSONObject2, "publisher_id", 0)));
        i.j(jSONObject2, this.sdk);
        i.k(jSONObject2, this.sdk);
        String string = JsonUtils.getString(jSONObject2, "latest_version", "");
        if (StringUtils.isValidString(string) && !AppLovinSdk.VERSION.equals(string)) {
            String str = "Current SDK version (" + AppLovinSdk.VERSION + ") is outdated. Please integrate the latest version of the AppLovin SDK (" + string + "). Doing so will improve your CPMs and ensure you have access to the latest revenue earning features.";
            if (JsonUtils.valueExists(jSONObject2, "sdk_update_message")) {
                str = JsonUtils.getString(jSONObject2, "sdk_update_message", str);
            }
            x.F("AppLovinSdk", str);
        }
        this.sdk.BR().JX();
    }

    private void O(JSONObject jSONObject) {
        Map<String, Object> map;
        Map<String, Object> map2;
        if (this.sdk.BV() != null) {
            p BV = this.sdk.BV();
            map = BV.CV();
            map2 = BV.DI();
        } else {
            o BS = this.sdk.BS();
            map = BS.CV();
            map2 = BS.Db();
        }
        u.a("platform", "type", map);
        u.a("api_level", "sdk_version", map);
        JsonUtils.putObject(jSONObject, "device_info", new JSONObject(map));
        u.a("sdk_version", "applovin_sdk_version", map2);
        u.a("ia", "installed_at", map2);
        JsonUtils.putObject(jSONObject, "app_info", new JSONObject(map2));
    }

    private void P(JSONObject jSONObject) {
        if (((Boolean) this.sdk.a(b.aPn)).booleanValue()) {
            JsonUtils.putJSONObjectIfValid(jSONObject, "stats", this.sdk.BR().JY());
        }
    }

    private void a(Map<String, String> map, JSONObject jSONObject) {
        AnonymousClass1 r5 = new w<JSONObject>(c.D(this.sdk).cW(i.c("2.0/device", this.sdk)).cY(i.d("2.0/device", this.sdk)).k(map).K(jSONObject).cX(i9.b).aU(((Boolean) this.sdk.a(b.aQl)).booleanValue()).ad(new JSONObject()).gE(((Integer) this.sdk.a(b.aNS)).intValue()).a(p.a.gW(((Integer) this.sdk.a(b.aPW)).intValue())).Ig(), this.sdk) {
            /* renamed from: a */
            public void d(JSONObject jSONObject, int i) {
                e.this.N(jSONObject);
            }

            public void a(int i, String str, JSONObject jSONObject) {
                i.b(i, this.sdk);
            }
        };
        r5.e(b.aLw);
        r5.f(b.aLx);
        this.sdk.BO().b((d) r5);
    }
}
