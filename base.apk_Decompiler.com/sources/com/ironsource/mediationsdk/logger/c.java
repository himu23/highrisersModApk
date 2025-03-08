package com.ironsource.mediationsdk.logger;

import com.applovin.sdk.AppLovinEventTypes;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.y2;
import org.json.JSONException;
import org.json.JSONObject;

class c {
    private IronSourceLogger.IronSourceTag a;
    private String b;
    private String c;
    private int d;

    public c(IronSourceLogger.IronSourceTag ironSourceTag, String str, String str2, int i) {
        this.a = ironSourceTag;
        this.b = str;
        this.c = str2;
        this.d = i;
    }

    public int a() {
        return this.d;
    }

    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(y2.a.d, this.b);
            jSONObject.put("tag", this.a);
            jSONObject.put(AppLovinEventTypes.USER_COMPLETED_LEVEL, this.d);
            jSONObject.put("message", this.c);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
