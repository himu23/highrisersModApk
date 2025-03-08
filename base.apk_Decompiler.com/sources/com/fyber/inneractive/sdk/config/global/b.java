package com.fyber.inneractive.sdk.config.global;

import com.fyber.inneractive.sdk.util.IAlog;
import com.ironsource.t4;
import com.unity3d.services.core.di.ServiceProvider;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class b {
    public String a;
    public int b;
    public final List<k> c = new ArrayList();
    public List<d> d = new ArrayList();

    public static void a(b bVar, JSONObject jSONObject, boolean z) throws Exception {
        Object obj;
        if (jSONObject != null) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                next.getClass();
                next.hashCode();
                char c2 = 65535;
                switch (next.hashCode()) {
                    case -1335432629:
                        if (next.equals("demand")) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case -977436259:
                        if (next.equals("pub_id")) {
                            c2 = 1;
                            break;
                        }
                        break;
                    case -212583340:
                        if (next.equals("placement_type")) {
                            c2 = 2;
                            break;
                        }
                        break;
                    case 3556:
                        if (next.equals(t4.x)) {
                            c2 = 3;
                            break;
                        }
                        break;
                    case 113722:
                        if (next.equals(ServiceProvider.NAMED_SDK)) {
                            c2 = 4;
                            break;
                        }
                        break;
                }
                switch (c2) {
                    case 0:
                        obj = new c(jSONObject.getJSONArray(next), z);
                        break;
                    case 1:
                        obj = new i(jSONObject.getJSONArray(next), z);
                        break;
                    case 2:
                        obj = new h(jSONObject.getJSONArray(next), z);
                        break;
                    case 3:
                        obj = new f(jSONObject.getString(next), z);
                        break;
                    case 4:
                        obj = new j(jSONObject.getString(next), z);
                        break;
                    default:
                        obj = null;
                        break;
                }
                if (obj != null) {
                    bVar.d.add(obj);
                } else {
                    IAlog.a(String.format("%s: Unsupported filter type: %s", new Object[]{"b", next}), new Object[0]);
                }
            }
        }
    }

    public String toString() {
        return String.format("experiment: id=%s, variants=%s, filters=%s", new Object[]{this.a, this.c, this.d});
    }
}
