package com.applovin.impl.mediation.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.preference.PreferenceManager;
import com.applovin.impl.sdk.c.d;
import com.applovin.impl.sdk.c.e;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.network.c;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.i;
import com.applovin.impl.sdk.x;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.adapter.parameters.MaxAdapterResponseParameters;
import com.ironsource.i9;
import com.ironsource.m2;
import com.ironsource.t4;
import com.ironsource.w5;
import com.ironsource.z3;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public abstract class b {
    private static JSONObject avv;
    /* access modifiers changed from: protected */
    public final SharedPreferences avw = PreferenceManager.getDefaultSharedPreferences(n.getApplicationContext());
    protected final n sdk;
    protected final String tag;

    protected b(String str, n nVar) {
        this.tag = str;
        this.sdk = nVar;
    }

    public c a(String str, String str2, MaxAdapterResponseParameters maxAdapterResponseParameters, MaxAdFormat maxAdFormat, a aVar, Map<String, String> map, boolean z, n nVar) {
        Map<String, Object> map2;
        nVar.BN();
        if (x.Fn()) {
            x BN = nVar.BN();
            String str3 = this.tag;
            BN.f(str3, "Creating OpenRTB request with " + str2);
        }
        Bundle customParameters = maxAdapterResponseParameters.getCustomParameters();
        Context applicationContext = n.getApplicationContext();
        if (nVar.BV() != null) {
            map2 = nVar.BV().CV();
        } else {
            map2 = nVar.BS().aL(false);
        }
        JSONObject jSONObject = new JSONObject();
        JsonUtils.putString(jSONObject, w5.x, str2);
        JsonUtils.putBoolean(jSONObject, "test", maxAdapterResponseParameters.isTesting());
        JsonUtils.putJsonArrayIfValid(jSONObject, "imp", a(customParameters, maxAdFormat, aVar.avy));
        JsonUtils.putJSONObjectIfValid(jSONObject, "app", a(customParameters, aVar.avz, applicationContext));
        JsonUtils.putJSONObjectIfValid(jSONObject, m2.h.G, a(aVar.avA, map2, nVar));
        JsonUtils.putJSONObjectIfValid(jSONObject, "user", i(aVar.avB));
        JsonUtils.putJSONObjectIfValid(jSONObject, "source", j(aVar.avC));
        JsonUtils.putJSONObjectIfValid(jSONObject, "regs", a(aVar.avD, applicationContext));
        JsonUtils.putJSONObjectIfValid(jSONObject, "format", f(map2));
        JsonUtils.putJSONObjectIfValid(jSONObject, "ext", aVar.avx);
        return c.D(nVar).cW(str).cX(i9.b).l(map).K(jSONObject).ad(new JSONObject()).aS(false).aU(z).Ig();
    }

    private JSONArray a(Bundle bundle, MaxAdFormat maxAdFormat, JSONObject jSONObject) {
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject2 = new JSONObject();
        JsonUtils.putDouble(jSONObject2, "bidfloor", bundle.getDouble("bidfloor", 0.0d));
        if (maxAdFormat.isAdViewAd()) {
            JSONObject jSONObject3 = new JSONObject();
            JsonUtils.putInt(jSONObject3, "w", bundle.getInt("width", maxAdFormat.getSize().getWidth()));
            JsonUtils.putInt(jSONObject3, "h", bundle.getInt("height", maxAdFormat.getSize().getHeight()));
            JSONArray jSONArray2 = new JSONArray();
            jSONArray2.put(3);
            jSONArray2.put(5);
            jSONArray2.put(6);
            JsonUtils.putJsonArray(jSONObject3, "api", jSONArray2);
            JsonUtils.putJSONObject(jSONObject2, "banner", jSONObject3);
        }
        JsonUtils.putJSONObjectIfValid(jSONObject2, "ext", jSONObject);
        jSONArray.put(jSONObject2);
        return jSONArray;
    }

    private JSONObject a(Bundle bundle, JSONObject jSONObject, Context context) {
        JSONObject z = z(context);
        JsonUtils.putString(z, m2.i.C, bundle.getString(m2.i.C, ""));
        JsonUtils.putString(z, "storeurl", bundle.getString("storeurl", ""));
        JsonUtils.putJSONObjectIfValid(z, "ext", jSONObject);
        return z;
    }

    private JSONObject a(JSONObject jSONObject, Map<String, Object> map, n nVar) {
        JSONObject jSONObject2 = new JSONObject();
        JsonUtils.putString(jSONObject2, t4.R, String.valueOf(map.get(t4.R)));
        JsonUtils.putBoolean(jSONObject2, "dnt", ((Boolean) map.get("dnt")).booleanValue());
        JsonUtils.putBoolean(jSONObject2, "lmt", ((Boolean) map.get("dnt")).booleanValue());
        JsonUtils.putString(jSONObject2, "ifa", String.valueOf(map.get("idfa")));
        JsonUtils.putString(jSONObject2, t4.q, String.valueOf(map.get("brand_name")));
        JsonUtils.putString(jSONObject2, t4.u, String.valueOf(map.get(t4.u)));
        JsonUtils.putString(jSONObject2, t4.x, "android");
        JsonUtils.putString(jSONObject2, t4.y, String.valueOf(map.get(t4.x)));
        JsonUtils.putInt(jSONObject2, "devicetype", 1);
        JsonUtils.putInt(jSONObject2, z3.e, i.H(nVar));
        JsonUtils.putInt(jSONObject2, "w", ((Integer) map.get("dx")).intValue());
        JsonUtils.putInt(jSONObject2, "h", ((Integer) map.get("dy")).intValue());
        JsonUtils.putJSONObjectIfValid(jSONObject2, "ext", jSONObject);
        return jSONObject2;
    }

    private JSONObject i(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        JsonUtils.putJSONObjectIfValid(jSONObject2, "ext", jSONObject);
        return jSONObject2;
    }

    private JSONObject j(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        JsonUtils.putJSONObjectIfValid(jSONObject2, "ext", jSONObject);
        return jSONObject2;
    }

    private JSONObject a(JSONObject jSONObject, Context context) {
        JSONObject jSONObject2 = new JSONObject();
        Boolean B = com.applovin.impl.privacy.a.zO().B(context);
        if (B != null) {
            JsonUtils.putBoolean(jSONObject2, "coppa", B.booleanValue());
        }
        JsonUtils.putJSONObjectIfValid(jSONObject2, "ext", jSONObject);
        return jSONObject2;
    }

    private JSONObject f(Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        JsonUtils.putInt(jSONObject, "w", ((Integer) map.get("dx")).intValue());
        JsonUtils.putInt(jSONObject, "h", ((Integer) map.get("dy")).intValue());
        return jSONObject;
    }

    /* access modifiers changed from: protected */
    public JSONObject zq() {
        Map<String, Object> map;
        JSONObject jSONObject = new JSONObject();
        if (this.sdk.BV() != null) {
            map = this.sdk.BV().DI();
        } else {
            map = this.sdk.BS().Db();
        }
        JsonUtils.putObject(jSONObject, "gdpr", map.get("IABTCF_gdprApplies"));
        Boolean B = com.applovin.impl.privacy.a.zQ().B(n.getApplicationContext());
        if (B != null) {
            JsonUtils.putString(jSONObject, "us_privacy", B.booleanValue() ? "1YY-" : "1YN-");
        }
        return jSONObject;
    }

    /* access modifiers changed from: protected */
    public JSONObject zr() {
        JSONObject jSONObject = new JSONObject();
        Boolean zs = zs();
        if (zs != null && zs.booleanValue()) {
            JsonUtils.putBoolean(jSONObject, "did_consent", com.applovin.impl.privacy.a.zP().B(n.getApplicationContext()).booleanValue());
            JsonUtils.putString(jSONObject, "consent", this.sdk.Cm().As());
        }
        return jSONObject;
    }

    private static JSONObject z(Context context) {
        PackageInfo packageInfo;
        JSONObject jSONObject = avv;
        if (jSONObject != null) {
            return jSONObject;
        }
        PackageManager packageManager = context.getPackageManager();
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        try {
            packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
        } catch (Throwable unused) {
            packageInfo = null;
        }
        JSONObject jSONObject2 = new JSONObject();
        JsonUtils.putString(jSONObject2, "name", packageManager.getApplicationLabel(applicationInfo).toString());
        JsonUtils.putString(jSONObject2, "bundle", applicationInfo.packageName);
        JsonUtils.putString(jSONObject2, "ver", packageInfo != null ? packageInfo.versionName : "");
        avv = jSONObject2;
        return jSONObject2;
    }

    /* access modifiers changed from: protected */
    public Boolean zs() {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(n.getApplicationContext());
        String name = d.aRw.getName();
        if (!defaultSharedPreferences.contains(name)) {
            return null;
        }
        boolean z = false;
        String str = (String) e.a(name, "", String.class, defaultSharedPreferences, false);
        if (StringUtils.isValidString(str)) {
            if (str.equals("1") || str.equalsIgnoreCase("true")) {
                z = true;
            }
            return Boolean.valueOf(z);
        }
        Integer num = (Integer) e.a(name, Integer.MAX_VALUE, Integer.class, defaultSharedPreferences, false);
        if (num == null || num.intValue() == Integer.MAX_VALUE) {
            Long l = (Long) e.a(name, Long.MAX_VALUE, Long.class, defaultSharedPreferences, false);
            if (l == null || l.longValue() == Long.MAX_VALUE) {
                return (Boolean) e.a(name, false, Boolean.class, defaultSharedPreferences, false);
            }
            if (l.longValue() > 0) {
                z = true;
            }
            return Boolean.valueOf(z);
        }
        if (num.intValue() > 0) {
            z = true;
        }
        return Boolean.valueOf(z);
    }

    public static class a {
        /* access modifiers changed from: private */
        public final JSONObject avA;
        /* access modifiers changed from: private */
        public final JSONObject avB;
        /* access modifiers changed from: private */
        public final JSONObject avC;
        /* access modifiers changed from: private */
        public final JSONObject avD;
        /* access modifiers changed from: private */
        public final JSONObject avx;
        /* access modifiers changed from: private */
        public final JSONObject avy;
        /* access modifiers changed from: private */
        public final JSONObject avz;

        /* renamed from: com.applovin.impl.mediation.c.b$a$a  reason: collision with other inner class name */
        public static class C0069a {
            private JSONObject avA;
            private JSONObject avB;
            private JSONObject avC;
            private JSONObject avD;
            private JSONObject avx;
            private JSONObject avy;
            private JSONObject avz;

            public C0069a k(JSONObject jSONObject) {
                this.avx = jSONObject;
                return this;
            }

            public C0069a l(JSONObject jSONObject) {
                this.avy = jSONObject;
                return this;
            }

            public C0069a m(JSONObject jSONObject) {
                this.avB = jSONObject;
                return this;
            }

            public C0069a n(JSONObject jSONObject) {
                this.avD = jSONObject;
                return this;
            }

            C0069a() {
            }

            public String toString() {
                return "S2SApiService.Extensions.Builder(bidRequestExtObject=" + this.avx + ", impExtObject=" + this.avy + ", appExtObject=" + this.avz + ", deviceExtObject=" + this.avA + ", userExtObject=" + this.avB + ", sourceExtObject=" + this.avC + ", regsExtObject=" + this.avD + ")";
            }

            public a zu() {
                return new a(this.avx, this.avy, this.avz, this.avA, this.avB, this.avC, this.avD);
            }
        }

        a(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4, JSONObject jSONObject5, JSONObject jSONObject6, JSONObject jSONObject7) {
            this.avx = jSONObject;
            this.avy = jSONObject2;
            this.avz = jSONObject3;
            this.avA = jSONObject4;
            this.avB = jSONObject5;
            this.avC = jSONObject6;
            this.avD = jSONObject7;
        }

        public static C0069a zt() {
            return new C0069a();
        }
    }
}
