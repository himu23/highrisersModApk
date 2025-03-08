package com.ironsource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ab {
    private JSONObject a;

    public ab() {
        this.a = new JSONObject();
    }

    public ab(String str) {
        f(str);
    }

    private Object a(Object obj) throws JSONException {
        if (obj == JSONObject.NULL) {
            return null;
        }
        return obj instanceof JSONObject ? b((JSONObject) obj) : obj instanceof JSONArray ? a((JSONArray) obj) : obj;
    }

    public static boolean a(JSONObject jSONObject) {
        return jSONObject.names() == null;
    }

    public static Object b(Object obj) throws JSONException {
        if (obj instanceof Map) {
            JSONObject jSONObject = new JSONObject();
            Map map = (Map) obj;
            for (Object next : map.keySet()) {
                if (next != null) {
                    jSONObject.put(next.toString(), b(map.get(next)));
                }
            }
            return jSONObject;
        } else if (!(obj instanceof Iterable)) {
            return obj;
        } else {
            JSONArray jSONArray = new JSONArray();
            for (Object put : (Iterable) obj) {
                jSONArray.put(put);
            }
            return jSONArray;
        }
    }

    private Map<String, Object> b(JSONObject jSONObject) throws JSONException {
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            hashMap.put(next, a(jSONObject.get(next)));
        }
        return hashMap;
    }

    private void f(String str) {
        try {
            this.a = new JSONObject(str);
        } catch (Exception unused) {
            this.a = new JSONObject();
        }
    }

    public int a(String str, int i) {
        return this.a.optInt(str, i);
    }

    public String a(String str, String str2) {
        return this.a.optString(str, str2);
    }

    public List a(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(a(jSONArray.get(i)));
        }
        return arrayList;
    }

    public JSONObject a() {
        return this.a;
    }

    public void a(String str, JSONObject jSONObject) {
        try {
            this.a.put(str, jSONObject);
        } catch (Exception unused) {
        }
    }

    public boolean a(String str) {
        return a().has(str);
    }

    public Object b(String str) {
        try {
            return a().get(str);
        } catch (JSONException unused) {
            return null;
        }
    }

    public void b(String str, String str2) {
        try {
            this.a.put(str, str2);
        } catch (Exception unused) {
        }
    }

    public boolean c(String str) {
        try {
            return this.a.getBoolean(str);
        } catch (JSONException unused) {
            return false;
        }
    }

    public String d(String str) {
        try {
            return this.a.getString(str);
        } catch (JSONException unused) {
            return null;
        }
    }

    public boolean e(String str) {
        return a().isNull(str);
    }

    public String toString() {
        JSONObject jSONObject = this.a;
        return jSONObject == null ? "" : jSONObject.toString();
    }
}
