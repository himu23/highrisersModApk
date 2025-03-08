package com.ironsource.mediationsdk.server;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import com.ironsource.e7;
import com.ironsource.k0;
import com.ironsource.k2;
import com.ironsource.k8;
import com.ironsource.m3;
import com.ironsource.mediationsdk.config.ConfigFile;
import com.ironsource.mediationsdk.utils.IronSourceAES;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.ironsource.o;
import com.ironsource.t4;
import com.ironsource.u3;
import com.ironsource.y8;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class ServerURL {
    private static final String AMPERSAND = "&";
    private static final String ANDROID = "android";
    private static final String APPLICATION_KEY = "applicationKey";
    private static final String APPLICATION_USER_ID = "applicationUserId";
    private static final String APPLICATION_VERSION = "appVer";
    private static final String AUID = "auid";
    private static String BASE_URL_PREFIX = "https://init.supersonicads.com/sdk/v";
    private static final String BASE_URL_SUFFIX = "?request=";
    private static final String BROWSER_USER_AGENT = "browserUserAgent";
    private static final String BUNDLE_ID = "bundleId";
    private static final String CONNECTION_TYPE = "connType";
    private static final String COPPA = "coppa";
    private static final String DEVICE_LANG = "deviceLang";
    private static final String DEVICE_MAKE = "devMake";
    private static final String DEVICE_MODEL = "devModel";
    private static final String EQUAL = "=";
    private static final String FIRST_SESSION = "fs";
    private static final String GAID = "advId";
    private static final String GOOGLE_FAMILY_SUPPORT = "dff";
    private static final String IMPRESSION = "impression";
    private static final String ISO_COUNTRY_CODE = "icc";
    private static final String IS_DEMAND_ONLY = "isDemandOnly";
    private static final String MEDIATION_TYPE = "mt";
    private static final String MOBILE_CARRIER = "mCar";
    private static final String MOBILE_COUNTRY_CODE = "mcc";
    private static final String MOBILE_NETWORK_CODE = "mnc";
    private static final String OS_VERSION = "osVer";
    private static final String PLACEMENT = "placementId";
    private static final String PLATFORM_KEY = "platform";
    private static final String PLUGIN_FW_VERSION = "plugin_fw_v";
    private static final String PLUGIN_TYPE = "pluginType";
    private static final String PLUGIN_VERSION = "pluginVersion";
    private static final String REWARDED_VIDEO_MANUAL_MODE = "rvManual";
    private static final String SDK_VERSION = "sdkVersion";
    private static final String SERR = "serr";
    private static final String TEST_SUITE = "ts";
    private static final String TIME_ZONE_ID = "tz";
    private static final String TIME_ZONE_OFFSET = "tzOff";

    private static String createURLParams(List<Pair<String, String>> list) throws UnsupportedEncodingException {
        String str = "";
        for (Pair next : list) {
            if (str.length() > 0) {
                str = str + "&";
            }
            str = str + ((String) next.first) + "=" + URLEncoder.encode((String) next.second, "UTF-8");
        }
        return str;
    }

    private static String getBaseUrl(String str) {
        return BASE_URL_PREFIX + str + BASE_URL_SUFFIX;
    }

    public static String getCPVProvidersURL(Context context, String str, String str2, String str3, String str4, boolean z, List<Pair<String, String>> list, boolean z2) throws UnsupportedEncodingException {
        String str5;
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Pair(PLATFORM_KEY, "android"));
        arrayList.add(new Pair("applicationKey", str));
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(new Pair("applicationUserId", str2));
        }
        arrayList.add(new Pair("sdkVersion", IronSourceUtils.getSDKVersion()));
        if (z) {
            arrayList.add(new Pair(REWARDED_VIDEO_MANUAL_MODE, "1"));
        }
        if (!IronSourceUtils.isEncryptedResponse()) {
            arrayList.add(new Pair(SERR, "0"));
        }
        if (!TextUtils.isEmpty(ConfigFile.getConfigFile().getPluginType())) {
            arrayList.add(new Pair(PLUGIN_TYPE, ConfigFile.getConfigFile().getPluginType()));
        }
        if (!TextUtils.isEmpty(ConfigFile.getConfigFile().getPluginVersion())) {
            arrayList.add(new Pair(PLUGIN_VERSION, ConfigFile.getConfigFile().getPluginVersion()));
        }
        if (!TextUtils.isEmpty(ConfigFile.getConfigFile().getPluginFrameworkVersion())) {
            arrayList.add(new Pair(PLUGIN_FW_VERSION, ConfigFile.getConfigFile().getPluginFrameworkVersion()));
        }
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(new Pair("advId", str3));
        }
        if (!TextUtils.isEmpty(str4)) {
            arrayList.add(new Pair("mt", str4));
        }
        String b = k0.b(context, context.getPackageName());
        if (!TextUtils.isEmpty(b)) {
            arrayList.add(new Pair(APPLICATION_VERSION, b));
        }
        arrayList.add(new Pair(OS_VERSION, Build.VERSION.SDK_INT + ""));
        arrayList.add(new Pair(DEVICE_MAKE, Build.MANUFACTURER));
        arrayList.add(new Pair(DEVICE_MODEL, Build.MODEL));
        arrayList.add(new Pair("fs", (IronSourceUtils.getFirstSession(context) ? 1 : 0) + ""));
        ConcurrentHashMap<String, List<String>> c = k8.b().c();
        if (c.containsKey(y8.b)) {
            arrayList.add(new Pair(COPPA, (String) c.get(y8.b).get(0)));
        }
        if (c.containsKey(y8.g)) {
            String str6 = (String) c.get(y8.g).get(0);
            if (!TextUtils.isEmpty(str6) && str6.equalsIgnoreCase(y8.h)) {
                arrayList.add(new Pair("ts", "1"));
            }
        }
        if (c.containsKey(y8.d)) {
            String str7 = (String) c.get(y8.d).get(0);
            if (!TextUtils.isEmpty(str7) && str7.equalsIgnoreCase("true")) {
                arrayList.add(new Pair(GOOGLE_FAMILY_SUPPORT, "1"));
            }
        }
        String connectionType = IronSourceUtils.getConnectionType(context);
        if (!TextUtils.isEmpty(connectionType)) {
            arrayList.add(new Pair(CONNECTION_TYPE, connectionType));
        }
        if (list != null) {
            arrayList.addAll(list);
        }
        String f = m3.f();
        if (f.length() != 0) {
            arrayList.add(new Pair(BROWSER_USER_AGENT, f));
        }
        try {
            str5 = m3.k(context) + "-" + m3.l(context);
        } catch (Exception e) {
            e.printStackTrace();
            str5 = null;
        }
        if (!(str5 == null || str5.length() == 0)) {
            arrayList.add(new Pair(DEVICE_LANG, str5));
        }
        arrayList.add(new Pair("bundleId", context.getPackageName()));
        arrayList.add(new Pair("mcc", "" + k2.b(context)));
        arrayList.add(new Pair("mnc", "" + k2.c(context)));
        String y = m3.y(context);
        if (!TextUtils.isEmpty(y)) {
            arrayList.add(new Pair("icc", y));
        }
        String x = m3.x(context);
        if (!TextUtils.isEmpty(x)) {
            arrayList.add(new Pair("mCar", x));
        }
        String m = m3.m();
        if (!TextUtils.isEmpty(m)) {
            arrayList.add(new Pair("tz", m));
        }
        arrayList.add(new Pair("tzOff", "" + m3.n()));
        String f2 = m3.f(context);
        if (!TextUtils.isEmpty(f2)) {
            arrayList.add(new Pair("auid", f2));
        }
        if (z2) {
            arrayList.add(new Pair("isDemandOnly", "1"));
        }
        arrayList.add(new Pair(t4.V, String.valueOf(o.a())));
        arrayList.addAll(IronSourceUtils.parseJsonToPairList(new e7().a()));
        return getBaseUrl(IronSourceUtils.getSDKVersion()) + URLEncoder.encode(IronSourceAES.encode(u3.b().c(), createURLParams(arrayList)), "UTF-8");
    }

    public static String getRequestURL(String str, boolean z, int i) throws UnsupportedEncodingException {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Pair(IMPRESSION, Boolean.toString(z)));
        arrayList.add(new Pair("placementId", Integer.toString(i)));
        String createURLParams = createURLParams(arrayList);
        return str + "&" + createURLParams;
    }

    private static void setBaseUrlPrefix(String str) {
        BASE_URL_PREFIX = str;
    }
}
