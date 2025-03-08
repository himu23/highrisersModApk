package com.ironsource;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.ironsource.sdk.utils.IronSourceQaProperties;
import com.ironsource.sdk.utils.SDKUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class nc {
    private static nc b;
    private JSONObject a = new JSONObject();

    class a implements Runnable {
        final /* synthetic */ Context a;

        a(Context context) {
            this.a = context;
        }

        public void run() {
            try {
                nc.this.a(k3.a(this.a));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private nc() {
    }

    public static synchronized nc d() {
        nc ncVar;
        synchronized (nc.class) {
            if (b == null) {
                b = new nc();
            }
            ncVar = b;
        }
        return ncVar;
    }

    public void a() {
        HashMap hashMap = new HashMap();
        hashMap.put("omidVersion", m9.f);
        hashMap.put("omidPartnerVersion", m9.e);
        b.a((Map<String, String>) hashMap);
    }

    public void a(Activity activity) {
        if (activity != null) {
            a(SDKUtils.encodeString("immersiveMode"), Boolean.valueOf(m3.a(activity)));
            a("appOrientation", SDKUtils.translateRequestedOrientation(m3.b((Context) activity)));
        }
    }

    public void a(Context context) {
        if (context != null) {
            try {
                new Thread(new a(context)).start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void a(Context context, String str, String str2) {
        a(context);
        if (context instanceof Activity) {
            a((Activity) context);
        }
        b(context);
        b(str2);
        a(str);
    }

    public void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            a("applicationKey", SDKUtils.encodeString(str));
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized void a(String str, Object obj) {
        try {
            this.a.put(str, obj);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return;
    }

    public void a(Map<String, String> map) {
        if (map == null) {
            Log.d("TokenService", "collectDataFromExternalParams params=null");
            return;
        }
        for (String next : map.keySet()) {
            a(next, SDKUtils.encodeString(map.get(next)));
        }
    }

    public void a(JSONObject jSONObject) {
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            a(next, jSONObject.opt(next));
        }
    }

    public void b() {
        if (IronSourceQaProperties.isInitialized()) {
            b.a(IronSourceQaProperties.getInstance().getParameters());
        }
    }

    public void b(Context context) {
        if (context != null) {
            a(k3.c(context));
            a(k3.b(context));
        }
    }

    public void b(String str) {
        if (!TextUtils.isEmpty(str)) {
            a("applicationUserId", SDKUtils.encodeString(str));
        }
    }

    public void b(JSONObject jSONObject) {
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            a(jc.r1 + next, jSONObject.opt(next));
        }
    }

    public JSONObject c(Context context) {
        c();
        b(context);
        try {
            return new JSONObject(this.a.toString());
        } catch (Exception e) {
            e.printStackTrace();
            return new JSONObject();
        }
    }

    public void c() {
        c(SDKUtils.getControllerConfig());
        a(SDKUtils.getInitSDKParams());
        b();
        a();
    }

    public void c(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                a("chinaCDN", new JSONObject(str).opt("chinaCDN"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public String d(Context context) {
        try {
            return s4.b(c(context).toString());
        } catch (Exception unused) {
            return s4.b(new JSONObject().toString());
        }
    }
}
