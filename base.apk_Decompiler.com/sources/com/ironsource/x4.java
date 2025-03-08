package com.ironsource;

import android.content.Context;
import com.ironsource.environment.ContextProvider;
import com.ironsource.t4;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class x4 {
    private static final String a = "adunit_data";

    public void a(Context context) {
        u4.a().c(context);
    }

    public void a(String str, t4.a aVar) {
        JSONObject optJSONObject;
        try {
            String name = aVar.name();
            u4 a2 = u4.a();
            JSONObject optJSONObject2 = a2.b(ContextProvider.getInstance().getApplicationContext()).optJSONObject(a);
            if (optJSONObject2 != null && (optJSONObject = optJSONObject2.optJSONObject(name)) != null && optJSONObject.remove(str) != null) {
                a2.b(a, optJSONObject2.put(name, optJSONObject));
            }
        } catch (JSONException unused) {
        }
    }

    public void a(String str, Object obj) {
        u4.a().b(str, obj);
    }

    public void a(String str, Object obj, t4.a aVar) {
        try {
            String name = aVar.name();
            u4 a2 = u4.a();
            JSONObject optJSONObject = a2.b(ContextProvider.getInstance().getApplicationContext()).optJSONObject(a);
            if (optJSONObject == null) {
                a2.b(a, new JSONObject().put(name, new JSONObject().put(str, obj)));
                return;
            }
            JSONObject optJSONObject2 = optJSONObject.optJSONObject(name);
            if (optJSONObject2 == null) {
                a2.b(a, optJSONObject.put(name, new JSONObject().put(str, obj)));
            } else {
                a2.b(a, optJSONObject.put(name, optJSONObject2.put(str, obj)));
            }
        } catch (JSONException unused) {
        }
    }

    public void a(String str, JSONObject jSONObject) {
        u4.a().a(str, jSONObject);
    }

    public void a(Map<String, Object> map) {
        u4.a().a(map);
    }
}
