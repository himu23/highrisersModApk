package com.applovin.impl.mediation.debugger.c;

import com.applovin.impl.sdk.c.a;
import com.applovin.impl.sdk.e.d;
import com.applovin.impl.sdk.e.w;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.network.b;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.d;
import com.applovin.impl.sdk.utils.p;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinWebViewActivity;
import com.ironsource.i9;
import com.ironsource.m2;
import com.ironsource.t4;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class c extends d {
    /* access modifiers changed from: private */
    public final b.d<JSONObject> apS;

    public c(b.d<JSONObject> dVar, n nVar) {
        super("TaskFetchMediationDebuggerInfo", nVar, true);
        this.apS = dVar;
    }

    public void run() {
        Map<String, String> vR = vR();
        JSONObject vS = vS();
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aQb)).booleanValue() || ((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aPY)).booleanValue()) {
            JsonUtils.putAll(vS, (Map<String, ?>) vR);
            vR = null;
        }
        AnonymousClass1 r1 = new w<JSONObject>(com.applovin.impl.sdk.network.c.D(this.sdk).cX(i9.b).cW(com.applovin.impl.mediation.e.b.d(this.sdk)).cY(com.applovin.impl.mediation.e.b.e(this.sdk)).k(vR).K(vS).ad(new JSONObject()).gF(((Long) this.sdk.a(a.aJk)).intValue()).a(p.a.gW(((Integer) this.sdk.a(com.applovin.impl.sdk.c.b.aPS)).intValue())).Ig(), this.sdk, Kh()) {
            /* renamed from: a */
            public void d(JSONObject jSONObject, int i) {
                c.this.apS.d(jSONObject, i);
            }

            public void a(int i, String str, JSONObject jSONObject) {
                c.this.apS.a(i, str, jSONObject);
            }
        };
        r1.e(a.aJg);
        r1.f(a.aJh);
        this.sdk.BO().b((d) r1);
    }

    /* access modifiers changed from: protected */
    public Map<String, String> vR() {
        Map<String, Object> map;
        Map<String, Object> map2;
        HashMap hashMap = new HashMap();
        hashMap.put("sdk_version", AppLovinSdk.VERSION);
        if (!((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aPL)).booleanValue()) {
            hashMap.put(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, this.sdk.getSdkKey());
        }
        if (this.sdk.BV() != null) {
            map2 = this.sdk.BV().DI();
            map = this.sdk.BV().CT();
        } else {
            map2 = this.sdk.BS().Db();
            map = this.sdk.BS().CT();
        }
        hashMap.put(m2.h.V, String.valueOf(map2.get(m2.h.V)));
        hashMap.put("app_version", String.valueOf(map2.get("app_version")));
        hashMap.put("platform", String.valueOf(map.get("platform")));
        hashMap.put(t4.x, String.valueOf(map.get(t4.x)));
        return hashMap;
    }

    private JSONObject vS() {
        d.a aVar;
        JSONObject jSONObject = new JSONObject();
        JsonUtils.putJsonArrayIfValid(jSONObject, "installed_mediation_adapters", com.applovin.impl.mediation.e.c.f(this.sdk));
        if (this.sdk.BV() != null) {
            aVar = this.sdk.BU().DM();
        } else {
            aVar = this.sdk.BS().Di();
        }
        JsonUtils.putStringIfValid(jSONObject, "dnt_code", aVar.KS().KT());
        Boolean B = com.applovin.impl.privacy.a.zO().B(rQ());
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aOB)).booleanValue() && !Boolean.TRUE.equals(B)) {
            JsonUtils.putStringIfValid(jSONObject, "idfa", aVar.KR());
        }
        return jSONObject;
    }
}
