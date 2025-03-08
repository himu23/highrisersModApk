package com.ironsource;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class w4 {
    private static w4 a = new w4();

    public static w4 a() {
        return a;
    }

    public static HashMap<String, Object> a(ConcurrentHashMap<String, Object> concurrentHashMap) throws JSONException {
        Object a2;
        HashMap<String, Object> hashMap = new HashMap<>();
        for (Map.Entry next : concurrentHashMap.entrySet()) {
            if (next.getValue() instanceof JSONObject) {
                a2 = a((JSONObject) next.getValue());
            } else if (next.getValue() instanceof JSONArray) {
                a2 = a((JSONArray) next.getValue());
            } else if (next.getValue() instanceof Map) {
                a2 = a((Map<String, Object>) (Map) next.getValue());
            } else {
                hashMap.put((String) next.getKey(), next.getValue());
            }
            hashMap.put((String) next.getKey(), a2);
        }
        return hashMap;
    }

    public static Map<String, Object> a(Map<String, Object> map) {
        HashMap hashMap = new HashMap();
        for (String next : map.keySet()) {
            hashMap.put(next, map.get(next));
        }
        return hashMap;
    }

    public static JSONArray a(JSONArray jSONArray) {
        JSONArray jSONArray2 = new JSONArray();
        for (int i = 0; i < jSONArray.length(); i++) {
            jSONArray2.put(jSONArray.opt(i));
        }
        return jSONArray2;
    }

    public static JSONObject a(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            jSONObject2.put(next, jSONObject.opt(next));
        }
        return jSONObject2;
    }

    public static JSONObject b(JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Object opt = jSONObject.opt(next);
                if (opt instanceof List) {
                    jSONObject.put(next, TextUtils.join(",", (List) opt));
                }
            }
        }
        return jSONObject;
    }
}
