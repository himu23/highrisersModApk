package com.fyber.inneractive.sdk.dv;

import com.fyber.inneractive.sdk.config.a0;
import com.fyber.inneractive.sdk.dv.enums.a;
import com.fyber.inneractive.sdk.dv.handler.c;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.response.b;
import org.json.JSONException;
import org.json.JSONObject;

public class e extends b {
    public void a(String str, a0 a0Var) {
        try {
            ((f) this.a).J = new JSONObject(str).getString("adm");
        } catch (JSONException e) {
            c.a(a0Var != null ? a0Var.b : null, a.Parse, (InneractiveAdRequest) null, (com.fyber.inneractive.sdk.response.e) null, e.getLocalizedMessage());
        }
    }

    public boolean b() {
        return true;
    }

    public com.fyber.inneractive.sdk.response.e a() {
        return new f();
    }
}
