package com.fyber.inneractive.sdk.flow;

import android.app.Application;
import android.content.SharedPreferences;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.i;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveError;
import com.fyber.inneractive.sdk.metrics.a;
import com.fyber.inneractive.sdk.network.r;
import com.fyber.inneractive.sdk.network.s;
import com.fyber.inneractive.sdk.response.e;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.p;
import com.fyber.inneractive.sdk.util.u;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class c implements Runnable {
    public final /* synthetic */ InneractiveError a;
    public final /* synthetic */ d b;

    public c(d dVar, InneractiveError inneractiveError) {
        this.b = dVar;
        this.a = inneractiveError;
    }

    public void run() {
        String str;
        String str2;
        T t = this.b.b;
        if (t != null && (str = t.h) != null) {
            Map<String, String> map = t.p;
            if (map != null || t.q != null) {
                i iVar = IAConfigManager.M.u.b;
                String str3 = d.e;
                if (iVar.a.containsKey("max_failed_creatives_interval_hours")) {
                    str3 = iVar.a.get("max_failed_creatives_interval_hours");
                }
                String str4 = d.f;
                if (iVar.a.containsKey("max_failed_creatives_per_interval")) {
                    str4 = iVar.a.get("max_failed_creatives_per_interval");
                }
                int a2 = u.a(str3, 24);
                int a3 = u.a(str4, 1);
                Application application = p.a;
                if (application != null) {
                    SharedPreferences sharedPreferences = application.getSharedPreferences("IAConfigPrefs", 0);
                    JSONArray jSONArray = new JSONArray();
                    try {
                        jSONArray = new JSONArray(sharedPreferences.getString("lt", "[]"));
                    } catch (JSONException unused) {
                    }
                    CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
                    if (iVar.a(this.b.a, false) && !a.a(a2, a3, jSONArray, copyOnWriteArrayList)) {
                        copyOnWriteArrayList.add(Long.valueOf(System.currentTimeMillis()));
                        if (map != null) {
                            try {
                                str2 = new JSONObject(map).toString();
                            } catch (Throwable unused2) {
                                str2 = "";
                            }
                        } else {
                            str2 = this.b.b.q;
                        }
                        d dVar = this.b;
                        InneractiveAdRequest inneractiveAdRequest = dVar.c;
                        T t2 = dVar.b;
                        InneractiveError inneractiveError = this.a;
                        s.a aVar = new s.a(r.IA_AD_FAILURE_DATA, inneractiveAdRequest, (e) t2, dVar.d);
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("raw_response", str);
                        } catch (Exception unused3) {
                            IAlog.e("Got exception adding param to json object: %s, %s", "raw_response", str);
                        }
                        try {
                            jSONObject.put("headers", str2);
                        } catch (Exception unused4) {
                            IAlog.e("Got exception adding param to json object: %s, %s", "headers", str2);
                        }
                        String description = inneractiveError.description();
                        try {
                            jSONObject.put("error_code", description);
                        } catch (Exception unused5) {
                            IAlog.e("Got exception adding param to json object: %s, %s", "error_code", description);
                        }
                        aVar.f.put(jSONObject);
                        aVar.a((String) null);
                    }
                    sharedPreferences.edit().putString("lt", new JSONArray(copyOnWriteArrayList).toString()).apply();
                }
            }
        }
    }
}
