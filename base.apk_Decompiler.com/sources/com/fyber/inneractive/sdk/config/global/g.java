package com.fyber.inneractive.sdk.config.global;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.util.IAlog;
import com.ironsource.w5;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class g {
    public static JSONArray a(Map<Class<? extends com.fyber.inneractive.sdk.config.global.features.g>, com.fyber.inneractive.sdk.config.global.features.g> map, boolean z) {
        d dVar;
        JSONArray jSONArray = new JSONArray();
        try {
            for (com.fyber.inneractive.sdk.config.global.features.g next : map.values()) {
                List<b> c = next.c();
                Map<String, k> map2 = next.d;
                Iterator it = ((ArrayList) c).iterator();
                while (it.hasNext()) {
                    b bVar = (b) it.next();
                    JSONObject jSONObject = new JSONObject();
                    String str = bVar != null ? bVar.a : null;
                    if (!TextUtils.isEmpty(str)) {
                        k kVar = map2.get(str);
                        jSONObject.put(w5.x, str);
                        if (kVar != null) {
                            jSONObject.put("v", kVar.b);
                        } else {
                            jSONObject.put("v", "control");
                        }
                        if (z) {
                            Class<c> cls = c.class;
                            Iterator<d> it2 = bVar.d.iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    dVar = null;
                                    break;
                                }
                                dVar = it2.next();
                                if (cls.equals(dVar.getClass())) {
                                    break;
                                }
                            }
                            if (dVar != null && ((c) dVar).b) {
                                Set<Long> set = ((c) dVar).a;
                                JSONArray jSONArray2 = new JSONArray();
                                for (Long put : set) {
                                    jSONArray2.put(put);
                                }
                                if (jSONArray2.length() > 0) {
                                    jSONObject.put("d", jSONArray2);
                                }
                            }
                        }
                        jSONArray.put(jSONObject);
                    }
                }
            }
            return jSONArray;
        } catch (JSONException e) {
            IAlog.a("ExperimentParamBuilder: Json exception during experiments Json build!", new Object[0]);
            if (IAlog.a <= 3) {
                e.printStackTrace();
            }
            return null;
        }
    }
}
