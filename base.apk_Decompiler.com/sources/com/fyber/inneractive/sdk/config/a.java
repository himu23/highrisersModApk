package com.fyber.inneractive.sdk.config;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.util.IAlog;
import java.util.Map;
import java.util.regex.Pattern;

public class a {
    public static z a(String str) {
        IAConfigManager iAConfigManager = IAConfigManager.M;
        Map<String, z> map = iAConfigManager.a;
        if (map == null || !map.containsKey(str)) {
            return null;
        }
        return iAConfigManager.a.get(str);
    }

    public static a0 b(String str) {
        IAConfigManager iAConfigManager = IAConfigManager.M;
        Map<String, a0> map = iAConfigManager.b;
        if (map != null && map.containsKey(str)) {
            return iAConfigManager.b.get(str);
        }
        IAlog.c("Requested unit config doesn't exists - %s", str);
        return null;
    }

    public static String a() {
        int i = f.a;
        String property = System.getProperty("ia.testEnvironmentConfiguration.name");
        if (TextUtils.isEmpty(property)) {
            return "wv.inner-active.mobi/simpleM2M/";
        }
        return property + ".inner-active.mobi/simpleM2M/";
    }

    public static String b() {
        int i = f.a;
        String property = System.getProperty("ia.testEnvironmentConfiguration.name");
        if (!TextUtils.isEmpty(property)) {
            return a(property, "Event");
        }
        return "https://" + IAConfigManager.M.i.f;
    }

    public static String a(String str, String str2) {
        if (Pattern.compile("^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])$").matcher(str).matches()) {
            return "https://" + str + "/simpleM2M/" + str2;
        }
        return "https://" + str + ".inner-active.mobi/simpleM2M/" + str2;
    }
}
