package com.applovin.impl.mediation.c.b;

import android.net.Uri;
import android.webkit.URLUtil;
import com.applovin.impl.mediation.c.b;
import com.applovin.impl.mediation.c.c;
import com.applovin.impl.sdk.AppLovinError;
import com.applovin.impl.sdk.e.d;
import com.applovin.impl.sdk.e.w;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.nativeAd.AppLovinNativeAdLoadListener;
import com.applovin.impl.sdk.network.c;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.x;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.adapter.parameters.MaxAdapterInitializationParameters;
import com.applovin.mediation.adapter.parameters.MaxAdapterResponseParameters;
import com.ironsource.i9;
import com.ironsource.m2;
import com.ironsource.w5;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

public class a extends b {
    public static final Uri avZ = Uri.parse("https://api.taboola.com/");
    private final String avO;
    /* access modifiers changed from: private */
    public String avR = m2.a.e;
    private final Uri awa;
    private final Map<String, Object> awb;
    /* access modifiers changed from: private */
    public String awc = "";

    public a(String str, String str2, String str3, n nVar) {
        super("TaboolaApiService", nVar);
        this.avO = str;
        Uri parse = URLUtil.isValidUrl(str3) ? Uri.parse(str3) : avZ;
        this.awa = Uri.withAppendedPath(parse, "2.0/json/" + str2);
        HashMap hashMap = new HashMap(3);
        this.awb = hashMap;
        hashMap.put("type", "mobile");
        hashMap.put("apiKey", str);
        hashMap.put("origin", "SERVER");
    }

    public void a(MaxAdapterInitializationParameters maxAdapterInitializationParameters, b bVar) {
        String str = (String) this.sdk.b(c.avE, null, this.avw);
        Long l = (Long) this.sdk.b(c.avF, null, this.avw);
        if (!StringUtils.isValidString(str) || l == null) {
            a(bVar);
        } else if (maxAdapterInitializationParameters.getServerParameters().getLong("user_id_expiration_millis", TimeUnit.DAYS.toMillis(30)) - (System.currentTimeMillis() - l.longValue()) > TimeUnit.HOURS.toMillis(1)) {
            this.awc = str;
            bVar.onInitialized(true, (String) null);
        } else {
            a(bVar);
        }
    }

    public void a(MaxAdapterResponseParameters maxAdapterResponseParameters, AppLovinNativeAdLoadListener appLovinNativeAdLoadListener) {
        JSONObject jSONObject = new JSONObject();
        JsonUtils.putJSONObject(jSONObject, "app", new JSONObject(this.awb));
        JsonUtils.putJSONObject(jSONObject, "consent", zA());
        JsonUtils.putJSONObject(jSONObject, "user", a(maxAdapterResponseParameters));
        JsonUtils.putJSONObject(jSONObject, "source", b(maxAdapterResponseParameters));
        JsonUtils.putJSONObject(jSONObject, "view", c(maxAdapterResponseParameters));
        JsonUtils.putJsonArray(jSONObject, "placements", d(maxAdapterResponseParameters));
        c.a D = com.applovin.impl.sdk.network.c.D(this.sdk);
        com.applovin.impl.sdk.network.c Ig = D.cW(this.awa.toString() + "/recommendations.get").cX(i9.b).K(jSONObject).ad(new JSONObject()).aS(false).aU(false).Ig();
        final MaxAdapterResponseParameters maxAdapterResponseParameters2 = maxAdapterResponseParameters;
        final AppLovinNativeAdLoadListener appLovinNativeAdLoadListener2 = appLovinNativeAdLoadListener;
        this.sdk.BO().b((d) new w<JSONObject>(Ig, this.sdk) {
            /* renamed from: a */
            public void d(JSONObject jSONObject, int i) {
                if (i != 200 || jSONObject == null) {
                    x xVar = this.logger;
                    if (x.Fn()) {
                        x xVar2 = this.logger;
                        String str = this.tag;
                        xVar2.i(str, "Unable to fetch " + maxAdapterResponseParameters2.getThirdPartyAdPlacementId() + " Taboola ad: server returned " + i);
                    }
                    AppLovinNativeAdLoadListener appLovinNativeAdLoadListener = appLovinNativeAdLoadListener2;
                    appLovinNativeAdLoadListener.onNativeAdLoadFailed(new AppLovinError(i, "Taboola server returned with code: " + jSONObject));
                    return;
                }
                String unused = a.this.avR = JsonUtils.getString(JsonUtils.getJSONObject(jSONObject, "user", new JSONObject()), "session", "");
                this.sdk.BO().b((d) new c(jSONObject, maxAdapterResponseParameters2, MaxAdFormat.NATIVE, appLovinNativeAdLoadListener2, this.sdk));
            }

            public void a(int i, String str, JSONObject jSONObject) {
                x xVar = this.logger;
                if (x.Fn()) {
                    x xVar2 = this.logger;
                    String str2 = this.tag;
                    xVar2.i(str2, "Unable to fetch " + maxAdapterResponseParameters2.getThirdPartyAdPlacementId() + " Taboola ad: server returned " + i);
                }
                AppLovinNativeAdLoadListener appLovinNativeAdLoadListener = appLovinNativeAdLoadListener2;
                appLovinNativeAdLoadListener.onNativeAdLoadFailed(new AppLovinError(i, "Taboola server returned with code: " + jSONObject));
            }
        });
    }

    private void a(final b bVar) {
        HashMap hashMap = new HashMap(2);
        hashMap.put("app.type", "mobile");
        hashMap.put("app.apikey", this.avO);
        c.a D = com.applovin.impl.sdk.network.c.D(this.sdk);
        this.sdk.BO().b((d) new w<JSONObject>(D.cW(this.awa.toString() + "/user.sync").cX(i9.a).k(hashMap).ad(new JSONObject()).aS(false).aU(false).Ig(), this.sdk) {
            /* renamed from: a */
            public void d(JSONObject jSONObject, int i) {
                if (i != 200 || jSONObject == null) {
                    String str = "Unable to fetch user id. Server returned " + i;
                    x xVar = this.logger;
                    if (x.Fn()) {
                        this.logger.i(this.tag, str);
                    }
                    bVar.onInitialized(false, str);
                    return;
                }
                String unused = a.this.awc = JsonUtils.getString(JsonUtils.getJSONObject(jSONObject, "user", new JSONObject()), w5.x, "");
                this.sdk.a(com.applovin.impl.mediation.c.c.avE, a.this.awc, a.this.avw);
                this.sdk.a(com.applovin.impl.mediation.c.c.avF, Long.valueOf(System.currentTimeMillis()), a.this.avw);
                bVar.onInitialized(true, (String) null);
            }

            public void a(int i, String str, JSONObject jSONObject) {
                x xVar = this.logger;
                if (x.Fn()) {
                    x xVar2 = this.logger;
                    String str2 = this.tag;
                    xVar2.i(str2, "Unable to fetch user id. Server returned " + i);
                }
                bVar.onInitialized(false, str);
            }
        });
    }

    private JSONObject zA() {
        Map<String, Object> map;
        JSONObject jSONObject = new JSONObject();
        if (this.sdk.BV() != null) {
            map = this.sdk.BV().DI();
        } else {
            map = this.sdk.BS().Db();
        }
        Object obj = map.get("IABTCF_gdprApplies");
        if (obj != null) {
            JsonUtils.putObject(jSONObject, "gdpr_applies", obj);
            JsonUtils.putString(jSONObject, "daisyBit", String.valueOf(map.get("IABTCF_TCString")));
        }
        return jSONObject;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private org.json.JSONObject a(com.applovin.mediation.adapter.parameters.MaxAdapterResponseParameters r7) {
        /*
            r6 = this;
            com.applovin.impl.sdk.n r0 = r6.sdk
            com.applovin.impl.sdk.p r0 = r0.BV()
            if (r0 == 0) goto L_0x0013
            com.applovin.impl.sdk.n r0 = r6.sdk
            com.applovin.impl.sdk.p r0 = r0.BV()
            java.util.Map r0 = r0.CV()
            goto L_0x001d
        L_0x0013:
            com.applovin.impl.sdk.n r0 = r6.sdk
            com.applovin.impl.sdk.o r0 = r0.BS()
            java.util.Map r0 = r0.CV()
        L_0x001d:
            java.lang.String r1 = "ua"
            java.lang.Object r1 = r0.get(r1)
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r2 = "idfa"
            java.lang.Object r0 = r0.get(r2)
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r2 = r6.avR
            java.util.Map r3 = r7.getLocalExtraParameters()
            java.lang.String r4 = "taboola_session"
            boolean r5 = r3.containsKey(r4)
            if (r5 == 0) goto L_0x004a
            java.lang.Object r3 = r3.get(r4)
            boolean r4 = r3 instanceof java.lang.String
            if (r4 == 0) goto L_0x004a
            r2 = r3
            java.lang.String r2 = (java.lang.String) r2
        L_0x004a:
            org.json.JSONObject r3 = new org.json.JSONObject
            r3.<init>()
            java.lang.String r4 = "session"
            com.applovin.impl.sdk.utils.JsonUtils.putString(r3, r4, r2)
            java.lang.String r2 = ""
            if (r1 == 0) goto L_0x0059
            goto L_0x005a
        L_0x0059:
            r1 = r2
        L_0x005a:
            java.lang.String r4 = "agent"
            com.applovin.impl.sdk.utils.JsonUtils.putString(r3, r4, r1)
            if (r0 == 0) goto L_0x0062
            goto L_0x0063
        L_0x0062:
            r0 = r2
        L_0x0063:
            java.lang.String r1 = "device"
            com.applovin.impl.sdk.utils.JsonUtils.putString(r3, r1, r0)
            java.lang.String r0 = "id"
            java.lang.String r1 = r6.awc
            com.applovin.impl.sdk.utils.JsonUtils.putString(r3, r0, r1)
            android.os.Bundle r7 = r7.getServerParameters()
            java.lang.String r0 = "s2s_ip"
            java.lang.String r7 = r7.getString(r0, r2)
            java.lang.String r0 = "realip"
            com.applovin.impl.sdk.utils.JsonUtils.putString(r3, r0, r7)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.mediation.c.b.a.a(com.applovin.mediation.adapter.parameters.MaxAdapterResponseParameters):org.json.JSONObject");
    }

    private JSONObject b(MaxAdapterResponseParameters maxAdapterResponseParameters) {
        JSONObject jSONObject = new JSONObject();
        JsonUtils.putString(jSONObject, "type", maxAdapterResponseParameters.getCustomParameters().getString("source_type", ""));
        JsonUtils.putString(jSONObject, w5.x, maxAdapterResponseParameters.getCustomParameters().getString("source_id", ""));
        JsonUtils.putString(jSONObject, "url", maxAdapterResponseParameters.getCustomParameters().getString("source_url", ""));
        return jSONObject;
    }

    private JSONObject c(MaxAdapterResponseParameters maxAdapterResponseParameters) {
        JSONObject jSONObject = new JSONObject();
        JsonUtils.putString(jSONObject, w5.x, a(maxAdapterResponseParameters, "taboola_view_id", ""));
        return jSONObject;
    }

    private JSONArray d(MaxAdapterResponseParameters maxAdapterResponseParameters) {
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject = new JSONObject();
        JsonUtils.putString(jSONObject, "name", maxAdapterResponseParameters.getThirdPartyAdPlacementId());
        JsonUtils.putInt(jSONObject, "recCount", 1);
        JsonUtils.putString(jSONObject, "organicType", maxAdapterResponseParameters.getCustomParameters().getString("placement_type", "MIX"));
        Map<String, Object> localExtraParameters = maxAdapterResponseParameters.getLocalExtraParameters();
        if (localExtraParameters.containsKey("taboola_thumbnail_height") && localExtraParameters.containsKey("taboola_thumbnail_width")) {
            Integer a = a(maxAdapterResponseParameters, "taboola_thumbnail_height", (Integer) 0);
            Integer a2 = a(maxAdapterResponseParameters, "taboola_thumbnail_width", (Integer) 0);
            if (a.intValue() > 0 && a2.intValue() > 0) {
                JSONObject jSONObject2 = new JSONObject();
                JsonUtils.putInt(jSONObject2, "width", a.intValue());
                JsonUtils.putInt(jSONObject2, "height", a2.intValue());
                JsonUtils.putJSONObject(jSONObject, "thumbnail", jSONObject2);
            }
        }
        jSONArray.put(jSONObject);
        return jSONArray;
    }

    private String a(MaxAdapterResponseParameters maxAdapterResponseParameters, String str, String str2) {
        if (maxAdapterResponseParameters.getLocalExtraParameters().containsKey(str)) {
            Object obj = maxAdapterResponseParameters.getLocalExtraParameters().get(str);
            if (obj instanceof String) {
                return (String) obj;
            }
        }
        return maxAdapterResponseParameters.getCustomParameters().getString(str, str2);
    }

    private Integer a(MaxAdapterResponseParameters maxAdapterResponseParameters, String str, Integer num) {
        if (maxAdapterResponseParameters.getLocalExtraParameters().containsKey(str)) {
            Object obj = maxAdapterResponseParameters.getLocalExtraParameters().get(str);
            if (obj instanceof Integer) {
                return (Integer) obj;
            }
        }
        return Integer.valueOf(maxAdapterResponseParameters.getCustomParameters().getInt(str, num.intValue()));
    }
}
