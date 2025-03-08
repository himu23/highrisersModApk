package com.fyber.inneractive.sdk.config.global;

import com.fyber.inneractive.sdk.cache.a;
import com.fyber.inneractive.sdk.config.f;
import com.fyber.inneractive.sdk.util.IAlog;
import java.util.Locale;
import org.json.JSONObject;

public class m implements a<l> {
    public /* bridge */ /* synthetic */ void a(Object obj) {
        l lVar = (l) obj;
    }

    public String b() {
        return "IALastModifiedFromHeader.remote";
    }

    public String c() {
        return "ia-remote.config";
    }

    public boolean d() {
        return true;
    }

    public Object a(String str) throws Exception {
        try {
            return l.a(new JSONObject(str));
        } catch (Exception e) {
            IAlog.b("internal error while parsing remote features config file", new Object[0]);
            if (IAlog.a <= 5) {
                e.printStackTrace();
            }
            throw e;
        }
    }

    public String a() {
        int i = f.a;
        if (System.getProperty("ia.testEnvironmentConfiguration.remoteConfigUrl") != null) {
            return System.getProperty("ia.testEnvironmentConfiguration.remoteConfigUrl");
        }
        return String.format(Locale.ENGLISH, "https://%sfeatures_config.json", new Object[]{"cdn2.inner-active.mobi/ia-sdk-config/"});
    }
}
