package com.fyber.inneractive.sdk.config;

import com.fyber.inneractive.sdk.util.m0;
import com.ironsource.m2;
import com.ironsource.w5;
import com.unity3d.services.core.device.MimeTypes;
import org.json.JSONObject;

public class a0 implements b0 {
    public String a;
    public String b;
    public t c;
    public x d;
    public y e;
    public c0 f;
    public e0 g;

    public d0 a() {
        return this.f;
    }

    public e0 b() {
        return this.g;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        m0.a(jSONObject, w5.x, this.a);
        m0.a(jSONObject, "spotId", this.b);
        m0.a(jSONObject, m2.h.d, this.c);
        m0.a(jSONObject, "monitor", this.d);
        m0.a(jSONObject, "native", this.e);
        m0.a(jSONObject, MimeTypes.BASE_TYPE_VIDEO, this.f);
        m0.a(jSONObject, "viewability", this.g);
        return jSONObject.toString();
    }
}
