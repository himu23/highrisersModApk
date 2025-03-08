package com.ironsource;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.ironsource.sdk.utils.IronSourceStorageUtils;
import com.ironsource.sdk.utils.Logger;
import com.ironsource.sdk.utils.SDKUtils;
import org.json.JSONObject;

public class k3 {
    private static final String a = "k3";

    public static JSONObject a(Context context) {
        SDKUtils.loadGoogleAdvertiserInfo(context);
        String advertiserId = SDKUtils.getAdvertiserId();
        String limitAdTracking = SDKUtils.getLimitAdTracking();
        JSONObject jSONObject = new JSONObject();
        try {
            if (!TextUtils.isEmpty(advertiserId)) {
                Logger.i(a, "add AID");
                jSONObject.put(jc.n0, SDKUtils.encodeString(advertiserId));
            }
            if (!TextUtils.isEmpty(limitAdTracking)) {
                Logger.i(a, "add LAT");
                jSONObject.put("isLimitAdTrackingEnabled", Boolean.parseBoolean(limitAdTracking));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private static void a(Context context, JSONObject jSONObject) {
        try {
            if (a("airplaneMode")) {
                jSONObject.put(SDKUtils.encodeString("airplaneMode"), m3.F(context));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void a(JSONObject jSONObject) {
        try {
            a(jSONObject, "displaySizeWidth", String.valueOf(m3.q()));
            a(jSONObject, "displaySizeHeight", String.valueOf(m3.p()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void a(JSONObject jSONObject, String str, String str2) {
        try {
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put(str, SDKUtils.encodeString(str2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean a(String str) {
        return SDKUtils.getControllerConfigAsJSONObject().optBoolean(str);
    }

    public static JSONObject b(Context context) {
        JSONObject jSONObject = new JSONObject();
        a(jSONObject);
        d(context, jSONObject);
        c(jSONObject);
        b(context, jSONObject);
        g(context, jSONObject);
        e(context, jSONObject);
        b(jSONObject);
        f(context, jSONObject);
        c(context, jSONObject);
        a(context, jSONObject);
        h(context, jSONObject);
        return jSONObject;
    }

    private static void b(Context context, JSONObject jSONObject) {
        try {
            jSONObject.put(SDKUtils.encodeString("batteryLevel"), m3.h(context));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void b(JSONObject jSONObject) {
        try {
            if (a("sdCardAvailable")) {
                jSONObject.put(SDKUtils.encodeString("sdCardAvailable"), m3.r());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static JSONObject c(Context context) {
        l3 b = l3.b(context);
        JSONObject jSONObject = new JSONObject();
        try {
            String d = b.d();
            if (d != null) {
                jSONObject.put(SDKUtils.encodeString("deviceOEM"), SDKUtils.encodeString(d));
            }
            String c = b.c();
            if (c != null) {
                jSONObject.put(SDKUtils.encodeString("deviceModel"), SDKUtils.encodeString(c));
            }
            String e = b.e();
            if (e != null) {
                jSONObject.put(SDKUtils.encodeString("deviceOs"), SDKUtils.encodeString(e));
            }
            String f = b.f();
            if (f != null) {
                jSONObject.put(SDKUtils.encodeString("deviceOSVersion"), f.replaceAll("[^0-9/.]", ""));
            }
            String f2 = b.f();
            if (f2 != null) {
                jSONObject.put(SDKUtils.encodeString("deviceOSVersionFull"), SDKUtils.encodeString(f2));
            }
            jSONObject.put(SDKUtils.encodeString("deviceApiLevel"), String.valueOf(b.a()));
            jSONObject.put(SDKUtils.encodeString("SDKVersion"), SDKUtils.encodeString(SDKUtils.getSDKVersion()));
            if (b.b() != null && b.b().length() > 0) {
                jSONObject.put(SDKUtils.encodeString("mobileCarrier"), SDKUtils.encodeString(b.b()));
            }
            String language = context.getResources().getConfiguration().locale.getLanguage();
            if (!TextUtils.isEmpty(language)) {
                jSONObject.put(SDKUtils.encodeString("deviceLanguage"), SDKUtils.encodeString(language.toUpperCase()));
            }
            if (a("totalDeviceRAM")) {
                jSONObject.put(SDKUtils.encodeString("totalDeviceRAM"), SDKUtils.encodeString(String.valueOf(m3.D(context))));
            }
            String g = k0.g(context);
            if (!TextUtils.isEmpty(g)) {
                jSONObject.put(SDKUtils.encodeString("bundleId"), SDKUtils.encodeString(g));
            }
            String valueOf = String.valueOf(m3.g());
            if (!TextUtils.isEmpty(valueOf)) {
                jSONObject.put(SDKUtils.encodeString("deviceScreenScale"), SDKUtils.encodeString(valueOf));
            }
            String valueOf2 = String.valueOf(m3.s());
            if (!TextUtils.isEmpty(valueOf2)) {
                jSONObject.put(SDKUtils.encodeString("unLocked"), SDKUtils.encodeString(valueOf2));
            }
            jSONObject.put(SDKUtils.encodeString("gpi"), ca.d(context));
            jSONObject.put("mcc", k2.b(context));
            jSONObject.put("mnc", k2.c(context));
            jSONObject.put(SDKUtils.encodeString("phoneType"), k2.e(context));
            jSONObject.put(SDKUtils.encodeString("simOperator"), SDKUtils.encodeString(k2.f(context)));
            jSONObject.put(SDKUtils.encodeString("lastUpdateTime"), k0.f(context));
            jSONObject.put(SDKUtils.encodeString("firstInstallTime"), k0.d(context));
            jSONObject.put(SDKUtils.encodeString("appVersion"), SDKUtils.encodeString(k0.b(context)));
            jSONObject.put(SDKUtils.encodeString("stid"), ca.c(context));
            String e2 = k0.e(context);
            if (!TextUtils.isEmpty(e2)) {
                jSONObject.put(SDKUtils.encodeString("installerPackageName"), SDKUtils.encodeString(e2));
            }
            jSONObject.put("localTime", SDKUtils.encodeString(String.valueOf(m3.i())));
            jSONObject.put("timezoneOffset", SDKUtils.encodeString(String.valueOf(m3.n())));
            String y = m3.y(context);
            if (!TextUtils.isEmpty(y)) {
                jSONObject.put("icc", y);
            }
            String m = m3.m();
            if (!TextUtils.isEmpty(m)) {
                jSONObject.put("tz", SDKUtils.encodeString(m));
            }
            jSONObject.put("uxt", IronSourceStorageUtils.isUxt());
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        return jSONObject;
    }

    private static void c(Context context, JSONObject jSONObject) {
        try {
            if (a("chargingType")) {
                jSONObject.put(SDKUtils.encodeString("chargingType"), m3.a(context));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void c(JSONObject jSONObject) {
        try {
            jSONObject.put(SDKUtils.encodeString("diskFreeSize"), SDKUtils.encodeString(String.valueOf(m3.e())));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void d(Context context, JSONObject jSONObject) {
        try {
            String b = l2.b(context);
            if (!TextUtils.isEmpty(b) && !b.equals("none")) {
                jSONObject.put(SDKUtils.encodeString("connectionType"), SDKUtils.encodeString(b));
            }
            if (Build.VERSION.SDK_INT >= 23) {
                jSONObject.put(SDKUtils.encodeString("hasVPN"), l2.d(context));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void e(Context context, JSONObject jSONObject) {
        try {
            jSONObject.put(SDKUtils.encodeString("deviceVolume"), (double) l3.b(context).a(context));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void f(Context context, JSONObject jSONObject) {
        try {
            if (a("isCharging")) {
                jSONObject.put(SDKUtils.encodeString("isCharging"), m3.G(context));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void g(Context context, JSONObject jSONObject) {
        try {
            jSONObject.put(SDKUtils.encodeString("lpm"), m3.I(context));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void h(Context context, JSONObject jSONObject) {
        try {
            if (a("stayOnWhenPluggedIn")) {
                jSONObject.put(SDKUtils.encodeString("stayOnWhenPluggedIn"), m3.K(context));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
