package com.ironsource;

import android.util.Base64;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class k6 implements g5 {
    public String a(Map<String, Object> map) {
        try {
            return String.format("%s=%s", new Object[]{"data", Base64.encodeToString(new JSONObject().put(z3.O, z3.P).put("data", new JSONObject(map)).toString().getBytes(), 2)});
        } catch (JSONException e) {
            e.printStackTrace();
            return "";
        }
    }
}
