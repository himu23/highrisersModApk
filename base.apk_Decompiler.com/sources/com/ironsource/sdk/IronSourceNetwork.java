package com.ironsource.sdk;

import android.app.Activity;
import android.content.Context;
import com.ironsource.b4;
import com.ironsource.l6;
import com.ironsource.m6;
import com.ironsource.nc;
import com.ironsource.p7;
import com.ironsource.sdk.controller.e;
import com.ironsource.sdk.utils.SDKUtils;
import com.ironsource.v9;
import com.ironsource.w9;
import com.ironsource.x7;
import java.util.Map;
import org.json.JSONObject;

public class IronSourceNetwork {
    static final String a = "IronSourceNetwork";
    private static x7 b;
    private static v9 c;
    private static JSONObject d;

    private static synchronized void a() throws Exception {
        synchronized (IronSourceNetwork.class) {
            if (b == null) {
                throw new NullPointerException("Call initSDK first");
            }
        }
    }

    private static void a(Context context, JSONObject jSONObject, String str, String str2, Map<String, String> map) throws Exception {
        if (jSONObject != null) {
            b4 a2 = m6.a(jSONObject);
            if (a2.a()) {
                l6.a(a2, m6.a(context, str, str2, map));
            }
        }
    }

    public static synchronized void applyConsentInfo(JSONObject jSONObject) {
        synchronized (IronSourceNetwork.class) {
            x7 x7Var = b;
            if (x7Var != null) {
                if (jSONObject != null) {
                    x7Var.a(jSONObject);
                }
            }
        }
    }

    public static synchronized void destroyAd(p7 p7Var) throws Exception {
        synchronized (IronSourceNetwork.class) {
            a();
            b.b(p7Var);
        }
    }

    public static synchronized e getControllerManager() {
        e a2;
        synchronized (IronSourceNetwork.class) {
            a2 = b.a();
        }
        return a2;
    }

    public static v9 getInitListener() {
        return c;
    }

    public static synchronized void getOfferWallCredits(w9 w9Var) throws Exception {
        synchronized (IronSourceNetwork.class) {
            a();
            b.a(w9Var);
        }
    }

    public static synchronized JSONObject getRawToken(Context context) {
        JSONObject c2;
        synchronized (IronSourceNetwork.class) {
            c2 = nc.d().c(context);
        }
        return c2;
    }

    public static synchronized String getToken(Context context) {
        String d2;
        synchronized (IronSourceNetwork.class) {
            d2 = nc.d().d(context);
        }
        return d2;
    }

    public static String getVersion() {
        return SDKUtils.getSDKVersion();
    }

    public static synchronized void initOfferWall(Map<String, String> map, w9 w9Var) throws Exception {
        synchronized (IronSourceNetwork.class) {
            a();
            b.a(map, w9Var);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004b, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void initSDK(android.content.Context r4, java.lang.String r5, java.lang.String r6, java.util.Map<java.lang.String, java.lang.String> r7) {
        /*
            java.lang.String r0 = "Failed to init event tracker: "
            java.lang.Class<com.ironsource.sdk.IronSourceNetwork> r1 = com.ironsource.sdk.IronSourceNetwork.class
            monitor-enter(r1)
            boolean r2 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x004c }
            if (r2 == 0) goto L_0x0014
            java.lang.String r4 = "IronSourceNetwork"
            java.lang.String r5 = "applicationKey is NULL"
            com.ironsource.sdk.utils.Logger.e(r4, r5)     // Catch:{ all -> 0x004c }
            monitor-exit(r1)
            return
        L_0x0014:
            com.ironsource.x7 r2 = b     // Catch:{ all -> 0x004c }
            if (r2 != 0) goto L_0x004a
            com.ironsource.sdk.utils.SDKUtils.setInitSDKParams(r7)     // Catch:{ all -> 0x004c }
            org.json.JSONObject r2 = com.ironsource.sdk.utils.SDKUtils.getNetworkConfiguration()     // Catch:{ all -> 0x004c }
            java.lang.String r3 = "events"
            org.json.JSONObject r2 = r2.optJSONObject(r3)     // Catch:{ Exception -> 0x0029 }
            a(r4, r2, r6, r5, r7)     // Catch:{ Exception -> 0x0029 }
            goto L_0x003f
        L_0x0029:
            r7 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x004c }
            r2.<init>(r0)     // Catch:{ all -> 0x004c }
            java.lang.String r7 = r7.getMessage()     // Catch:{ all -> 0x004c }
            r2.append(r7)     // Catch:{ all -> 0x004c }
            java.lang.String r7 = r2.toString()     // Catch:{ all -> 0x004c }
            java.lang.String r0 = "IronSourceNetwork"
            com.ironsource.sdk.utils.Logger.e(r0, r7)     // Catch:{ all -> 0x004c }
        L_0x003f:
            com.ironsource.x7 r4 = com.ironsource.r7.a((android.content.Context) r4, (java.lang.String) r5, (java.lang.String) r6)     // Catch:{ all -> 0x004c }
            b = r4     // Catch:{ all -> 0x004c }
            org.json.JSONObject r4 = d     // Catch:{ all -> 0x004c }
            applyConsentInfo(r4)     // Catch:{ all -> 0x004c }
        L_0x004a:
            monitor-exit(r1)
            return
        L_0x004c:
            r4 = move-exception
            monitor-exit(r1)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.sdk.IronSourceNetwork.initSDK(android.content.Context, java.lang.String, java.lang.String, java.util.Map):void");
    }

    public static synchronized boolean isAdAvailableForInstance(p7 p7Var) {
        synchronized (IronSourceNetwork.class) {
            x7 x7Var = b;
            if (x7Var == null) {
                return false;
            }
            boolean a2 = x7Var.a(p7Var);
            return a2;
        }
    }

    public static synchronized void loadAd(p7 p7Var, Map<String, String> map) throws Exception {
        synchronized (IronSourceNetwork.class) {
            a();
            b.a(p7Var, map);
        }
    }

    public static synchronized void loadAdView(Activity activity, p7 p7Var, Map<String, String> map) throws Exception {
        synchronized (IronSourceNetwork.class) {
            a();
            b.b(activity, p7Var, map);
        }
    }

    public static void onPause(Activity activity) {
        x7 x7Var = b;
        if (x7Var != null) {
            x7Var.onPause(activity);
        }
    }

    public static void onResume(Activity activity) {
        x7 x7Var = b;
        if (x7Var != null) {
            x7Var.onResume(activity);
        }
    }

    public static synchronized void release(Activity activity) {
        synchronized (IronSourceNetwork.class) {
            x7 x7Var = b;
            if (x7Var != null) {
                x7Var.a(activity);
            }
        }
    }

    public static synchronized void setInitListener(v9 v9Var) {
        synchronized (IronSourceNetwork.class) {
            c = v9Var;
        }
    }

    public static synchronized void showAd(Activity activity, p7 p7Var, Map<String, String> map) throws Exception {
        synchronized (IronSourceNetwork.class) {
            a();
            b.a(activity, p7Var, map);
        }
    }

    public static synchronized void showOfferWall(Activity activity, Map<String, String> map) throws Exception {
        synchronized (IronSourceNetwork.class) {
            a();
            b.a(activity, map);
        }
    }

    public static synchronized void updateConsentInfo(JSONObject jSONObject) {
        synchronized (IronSourceNetwork.class) {
            d = jSONObject;
            applyConsentInfo(jSONObject);
        }
    }

    public static synchronized void updateMetadata(JSONObject jSONObject) {
        synchronized (IronSourceNetwork.class) {
            nc.d().b(jSONObject);
        }
    }
}
