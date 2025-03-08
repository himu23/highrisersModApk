package com.applovin.impl.sdk.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.preference.PreferenceManager;
import com.applovin.impl.sdk.c.b;
import com.applovin.impl.sdk.c.c;
import com.applovin.impl.sdk.c.d;
import com.applovin.impl.sdk.c.e;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.network.b;
import com.applovin.impl.sdk.x;
import com.ironsource.k2;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class i {
    private static final int[] aVH = {7, 4, 2, 1, 11};
    private static final int[] aVI = {5, 6, 12, 10, 3, 9, 8, 14};
    private static final int[] aVJ = {15, 13};
    private static final int[] aVK = {20};

    public static String c(String str, n nVar) {
        return a((String) nVar.a(b.aLw), str, nVar);
    }

    public static String d(String str, n nVar) {
        return a((String) nVar.a(b.aLx), str, nVar);
    }

    public static Map<String, String> F(n nVar) {
        HashMap hashMap = new HashMap();
        String str = (String) nVar.a(b.aKo);
        if (StringUtils.isValidString(str)) {
            hashMap.put("device_token", str);
        } else if (!((Boolean) nVar.a(b.aPL)).booleanValue()) {
            hashMap.put("api_key", nVar.getSdkKey());
        }
        if (nVar.BV() != null) {
            hashMap.putAll(u.s(nVar.BV().De()));
        } else {
            hashMap.putAll(u.s(nVar.BS().De()));
        }
        return hashMap;
    }

    public static void a(JSONObject jSONObject, boolean z, n nVar) {
        nVar.Ch().a(jSONObject, z);
    }

    public static void b(int i, n nVar) {
        if (i == 401) {
            x.H("AppLovinSdk", "SDK key \"" + nVar.getSdkKey() + "\" is rejected by AppLovin. Please make sure the SDK key is correct.");
        } else if (i == 418) {
            nVar.BP().a((b<?>) b.aKk, (Object) true);
            nVar.BP().JF();
        } else if (i < 400 || i >= 500) {
            if (i == -1 && ((Boolean) nVar.a(b.aKm)).booleanValue()) {
                nVar.Bx();
            }
        } else if (((Boolean) nVar.a(b.aKm)).booleanValue()) {
            nVar.Bx();
        }
    }

    public static String a(String str, String str2, n nVar) {
        if (str == null || str.length() < 4) {
            throw new IllegalArgumentException("Invalid domain specified");
        } else if (str2 == null) {
            throw new IllegalArgumentException("No endpoint specified");
        } else if (nVar != null) {
            return str + str2;
        } else {
            throw new IllegalArgumentException("No sdk specified");
        }
    }

    public static void i(JSONObject jSONObject, n nVar) {
        String string = JsonUtils.getString(jSONObject, "persisted_data", (String) null);
        if (StringUtils.isValidString(string)) {
            nVar.a(d.aRM, string);
            nVar.BN();
            if (x.Fn()) {
                nVar.BN().g("ConnectionUtils", "Updated persisted data");
            }
        }
    }

    public static void j(JSONObject jSONObject, n nVar) {
        if (jSONObject == null) {
            throw new IllegalArgumentException("No response specified");
        } else if (nVar != null) {
            try {
                if (jSONObject.has(com.ironsource.mediationsdk.d.f)) {
                    c BP = nVar.BP();
                    if (!jSONObject.isNull(com.ironsource.mediationsdk.d.f)) {
                        BP.M(jSONObject.getJSONObject(com.ironsource.mediationsdk.d.f));
                        BP.JF();
                    }
                }
            } catch (JSONException e) {
                nVar.BN();
                if (x.Fn()) {
                    nVar.BN().c("ConnectionUtils", "Unable to parse settings out of API response", e);
                }
            }
        } else {
            throw new IllegalArgumentException("No sdk specified");
        }
    }

    public static void k(JSONObject jSONObject, n nVar) {
        JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONObject, "filesystem_values", (JSONObject) null);
        if (jSONObject2 != null) {
            SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(n.getApplicationContext()).edit();
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Object object = JsonUtils.getObject(jSONObject2, next, (Object) null);
                if (object != null) {
                    e.a(next, object, (SharedPreferences) null, edit);
                }
            }
            edit.apply();
        }
    }

    public static byte[] a(InputStream inputStream, n nVar) throws IOException {
        if (inputStream == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[((Integer) nVar.a(b.aNT)).intValue()];
        while (true) {
            int read = inputStream.read(bArr);
            if (read <= 0) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    public static String G(n nVar) {
        NetworkInfo ab = ab(n.getApplicationContext());
        if (ab == null) {
            return "unknown";
        }
        int type = ab.getType();
        int subtype = ab.getSubtype();
        if (type == 1) {
            return k2.b;
        }
        if (type != 0) {
            return "unknown";
        }
        if (a(subtype, aVH)) {
            return "2g";
        }
        if (a(subtype, aVI)) {
            return k2.a;
        }
        if (a(subtype, aVJ)) {
            return "4g";
        }
        return a(subtype, aVK) ? "5g" : "mobile";
    }

    public static int H(n nVar) {
        NetworkInfo ab = ab(n.getApplicationContext());
        if (ab != null) {
            int type = ab.getType();
            int subtype = ab.getSubtype();
            if (type == 1) {
                return 2;
            }
            if (type == 0) {
                if (a(subtype, aVH)) {
                    return 4;
                }
                if (a(subtype, aVI)) {
                    return 5;
                }
                if (a(subtype, aVJ)) {
                    return 6;
                }
                return a(subtype, aVK) ? 7 : 3;
            }
        }
        return 0;
    }

    public static boolean aa(Context context) {
        if (context.getSystemService("connectivity") == null) {
            return true;
        }
        NetworkInfo ab = ab(context);
        if (ab != null) {
            return ab.isConnected();
        }
        return false;
    }

    private static NetworkInfo ab(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null) {
            return connectivityManager.getActiveNetworkInfo();
        }
        return null;
    }

    private static boolean a(int i, int[] iArr) {
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    public static String b(n nVar) {
        return a((String) nVar.a(b.aLu), ((Boolean) nVar.a(b.aOa)).booleanValue() ? "5.0/ad" : "4.0/ad", nVar);
    }

    public static String c(n nVar) {
        return a((String) nVar.a(b.aLv), ((Boolean) nVar.a(b.aOa)).booleanValue() ? "5.0/ad" : "4.0/ad", nVar);
    }

    public static String I(n nVar) {
        return a((String) nVar.a(b.aLu), "4.0/ad", nVar);
    }

    public static String J(n nVar) {
        return a((String) nVar.a(b.aLv), "4.0/ad", nVar);
    }

    public static Long K(n nVar) {
        b.c HK = nVar.BQ().HK();
        if (HK == null) {
            return null;
        }
        double cb = u.cb(HK.HO());
        double bY = u.bY(HK.HP());
        if (bY == 0.0d) {
            return null;
        }
        return Long.valueOf((long) (cb / bY));
    }
}
