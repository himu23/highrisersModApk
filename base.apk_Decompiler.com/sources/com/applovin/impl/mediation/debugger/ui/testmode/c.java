package com.applovin.impl.mediation.debugger.ui.testmode;

import com.applovin.impl.sdk.c.d;
import com.applovin.impl.sdk.k;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.e;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class c {
    private List<String> aun;
    private boolean iV;
    private final n sdk;

    public boolean isEnabled() {
        return this.iV;
    }

    public List<String> xk() {
        return this.aun;
    }

    public c(n nVar) {
        this.sdk = nVar;
        boolean z = false;
        this.iV = (((Boolean) nVar.b(d.aRO, false)).booleanValue() || e.X(n.getApplicationContext()).dy("applovin.sdk.is_test_environment") || AppLovinSdkUtils.isEmulator()) ? true : z;
        nVar.b(d.aRO);
    }

    public boolean xj() {
        List<String> list = this.aun;
        return list != null && !list.isEmpty();
    }

    public void bT(String str) {
        if (StringUtils.isValidString(str)) {
            C(Collections.singletonList(str));
        } else {
            C((List<String>) null);
        }
    }

    public void C(List<String> list) {
        if (list != null || this.aun != null) {
            if (list == null || !list.equals(this.aun)) {
                this.aun = list;
                xm();
            }
        }
    }

    public void xl() {
        this.sdk.a(d.aRO, true);
    }

    public void f(JSONObject jSONObject) {
        boolean z;
        String str;
        if (!this.iV) {
            JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, "test_mode_idfas", new JSONArray());
            if (this.sdk.BV() != null) {
                str = this.sdk.BU().DM().KR();
                z = this.sdk.BU().Da();
            } else {
                str = this.sdk.BS().Di().KR();
                z = this.sdk.BS().Da();
            }
            this.iV = z || JsonUtils.containsCaseInsensitiveString(str, jSONArray);
        }
    }

    private void xm() {
        k Ch = this.sdk.Ch();
        if (this.iV) {
            Ch.H(this.aun);
        } else {
            Ch.G(this.aun);
        }
    }
}
