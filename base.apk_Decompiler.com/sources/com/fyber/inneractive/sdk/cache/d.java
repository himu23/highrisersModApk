package com.fyber.inneractive.sdk.cache;

import com.fyber.inneractive.sdk.config.f;
import com.fyber.inneractive.sdk.config.i;
import com.fyber.inneractive.sdk.util.IAlog;
import org.json.JSONException;
import org.json.JSONObject;

public class d implements a<i> {
    public static final String a = String.format("https://%sconfig_android.json", new Object[]{"cdn2.inner-active.mobi/ia-sdk-config/"});

    public /* bridge */ /* synthetic */ void a(Object obj) {
        i iVar = (i) obj;
    }

    public String b() {
        return "IALastModifiedFromHeader.global";
    }

    public String c() {
        return "ia-global.config";
    }

    public boolean d() {
        return true;
    }

    public Object a(String str) throws Exception {
        try {
            return i.a(new JSONObject(str));
        } catch (JSONException e) {
            IAlog.b("internal error while parsing global config file", new Object[0]);
            throw e;
        }
    }

    public String a() {
        int i = f.a;
        if (System.getProperty("ia.testEnvironmentConfiguration.globalConfigUrl") == null) {
            return a;
        }
        return System.getProperty("ia.testEnvironmentConfiguration.globalConfigUrl");
    }
}
