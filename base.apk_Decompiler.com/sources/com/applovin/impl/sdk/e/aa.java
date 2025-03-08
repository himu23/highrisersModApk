package com.applovin.impl.sdk.e;

import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.network.b;
import com.applovin.impl.sdk.network.c;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.i;
import com.applovin.impl.sdk.utils.p;
import com.ironsource.i9;
import java.util.Map;
import org.json.JSONObject;

public abstract class aa extends d {
    /* access modifiers changed from: protected */
    public abstract int KN();

    /* access modifiers changed from: protected */
    public abstract void x(JSONObject jSONObject);

    /* access modifiers changed from: protected */
    public abstract String zL();

    protected aa(String str, n nVar) {
        super(str, nVar);
    }

    /* access modifiers changed from: package-private */
    public void a(JSONObject jSONObject, final b.d<JSONObject> dVar) {
        Map<String, String> F = i.F(this.sdk);
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aQf)).booleanValue() || ((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aPY)).booleanValue()) {
            JsonUtils.putAll(jSONObject, (Map<String, ?>) F);
            F = null;
        }
        AnonymousClass1 r0 = new w<JSONObject>(c.D(this.sdk).cW(i.c(zL(), this.sdk)).cY(i.d(zL(), this.sdk)).k(F).K(jSONObject).cX(i9.b).aU(((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aQo)).booleanValue()).ad(new JSONObject()).gE(KN()).a(p.a.gW(((Integer) this.sdk.a(com.applovin.impl.sdk.c.b.aPX)).intValue())).Ig(), this.sdk) {
            /* renamed from: a */
            public void d(JSONObject jSONObject, int i) {
                dVar.d(jSONObject, i);
            }

            public void a(int i, String str, JSONObject jSONObject) {
                dVar.a(i, str, jSONObject);
            }
        };
        r0.e(com.applovin.impl.sdk.c.b.aLw);
        r0.f(com.applovin.impl.sdk.c.b.aLx);
        this.sdk.BO().b((d) r0);
    }

    /* access modifiers changed from: protected */
    public JSONObject KO() {
        JSONObject jSONObject = new JSONObject();
        String Bz = this.sdk.Bz();
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aOu)).booleanValue() && StringUtils.isValidString(Bz)) {
            JsonUtils.putString(jSONObject, "cuid", Bz);
        }
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aOw)).booleanValue()) {
            JsonUtils.putString(jSONObject, "compass_random_token", this.sdk.BA());
        }
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aOy)).booleanValue()) {
            JsonUtils.putString(jSONObject, "applovin_random_token", this.sdk.BB());
        }
        x(jSONObject);
        return jSONObject;
    }

    /* access modifiers changed from: protected */
    public void gu(int i) {
        i.b(i, this.sdk);
    }
}
