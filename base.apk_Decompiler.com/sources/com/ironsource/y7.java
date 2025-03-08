package com.ironsource;

import com.ironsource.e6;
import org.json.JSONObject;

public class y7 {
    static String a = "ManRewInst_";

    public static String a() {
        return String.valueOf(System.currentTimeMillis());
    }

    public static String a(p7 p7Var) {
        return (p7Var.g() ? e6.e.Banner : p7Var.k() ? e6.e.RewardedVideo : e6.e.Interstitial).toString();
    }

    public static String a(JSONObject jSONObject) {
        if (!jSONObject.optBoolean("rewarded")) {
            return jSONObject.optString("name");
        }
        return a + jSONObject.optString("name");
    }
}
