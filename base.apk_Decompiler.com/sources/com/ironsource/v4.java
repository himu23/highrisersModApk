package com.ironsource;

import android.content.Context;
import com.ironsource.environment.ContextProvider;
import com.ironsource.t4;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class v4 {
    private static final String a = "adunit_data";

    private JSONObject a(Context context, t4.a aVar) throws JSONException {
        String name = aVar.name();
        JSONObject b = u4.a().b(context);
        JSONObject optJSONObject = b.optJSONObject(a);
        JSONObject a2 = a(b);
        if (!(optJSONObject == null || optJSONObject.optJSONObject(name) == null)) {
            JSONObject jSONObject = optJSONObject.getJSONObject(name);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                a2.putOpt(next, jSONObject.opt(next));
            }
        }
        return a2;
    }

    private JSONObject a(Context context, List<String> list) throws JSONException {
        return a(a(u4.a().b(context)), (String[]) list.toArray(new String[list.size()]));
    }

    private JSONObject a(JSONObject jSONObject) {
        jSONObject.remove(a);
        return jSONObject;
    }

    private JSONObject a(JSONObject jSONObject, String[] strArr) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        for (String str : strArr) {
            if (jSONObject.has(str)) {
                jSONObject2.put(str, jSONObject.opt(str));
            }
        }
        return jSONObject2;
    }

    public JSONObject a(Context context, String[] strArr) throws JSONException {
        return a(a(u4.a().b(context)), strArr);
    }

    public JSONObject a(List<String> list) throws JSONException {
        return a(ContextProvider.getInstance().getApplicationContext(), list);
    }

    public JSONObject a(List<String> list, t4.a aVar) throws JSONException {
        return a(a(ContextProvider.getInstance().getApplicationContext(), aVar), (String[]) list.toArray(new String[list.size()]));
    }

    public JSONObject a(String[] strArr) throws JSONException {
        return a(a(u4.a().b(ContextProvider.getInstance().getApplicationContext())), strArr);
    }
}
