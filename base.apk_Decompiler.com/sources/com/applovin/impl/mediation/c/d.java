package com.applovin.impl.mediation.c;

import androidx.core.app.NotificationCompat;
import androidx.work.impl.Scheduler;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.adapter.parameters.MaxAdapterResponseParameters;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import com.ironsource.m2;
import com.ironsource.w5;
import com.unity3d.ads.metadata.MediationMetaData;
import org.json.JSONArray;
import org.json.JSONObject;

public abstract class d extends com.applovin.impl.sdk.e.d {
    private static JSONObject avH;
    private static JSONObject avI;
    private static JSONObject avJ;
    protected final JSONObject avK;
    private final AppLovinAdSize avL;
    private final AppLovinAdType avM;
    protected String avN;
    protected final MaxAdFormat format;
    protected final MaxAdapterResponseParameters parameters;
    protected final n sdk;

    /* access modifiers changed from: protected */
    public abstract JSONObject zv();

    public d(String str, JSONObject jSONObject, MaxAdapterResponseParameters maxAdapterResponseParameters, MaxAdFormat maxAdFormat, n nVar) {
        super(str, nVar);
        this.avK = jSONObject;
        this.parameters = maxAdapterResponseParameters;
        this.format = maxAdFormat;
        this.sdk = nVar;
        this.avL = d(maxAdFormat);
        this.avM = e(maxAdFormat);
    }

    /* access modifiers changed from: protected */
    public JSONObject o(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        JsonUtils.putString(jSONObject2, "ad_size", this.avL.toString());
        JsonUtils.putString(jSONObject2, "ad_type", this.avM.toString());
        JsonUtils.putString(jSONObject2, "dsp_name", this.avN);
        JsonUtils.putInt(jSONObject2, "status", Scheduler.MAX_GREEDY_SCHEDULER_LIMIT);
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(jSONObject);
        JsonUtils.putJsonArray(jSONObject2, "ads", jSONArray);
        return jSONObject2;
    }

    /* access modifiers changed from: protected */
    public JSONObject a(String str, JSONObject jSONObject, JSONObject jSONObject2) {
        JSONObject zw = zw();
        JsonUtils.putAll(zw, JsonUtils.deserialize(this.parameters.getServerParameters().getString("ad_object")));
        JsonUtils.putString(zw, "html", str);
        JsonUtils.putJSONObject(zw, "click_tracking_urls", jSONObject);
        JsonUtils.putJSONObject(zw, "imp_urls", jSONObject2);
        return zw;
    }

    /* access modifiers changed from: protected */
    public JSONObject a(a aVar) {
        JSONObject zx = zx();
        JsonUtils.putAll(zx, JsonUtils.deserialize(this.parameters.getServerParameters().getString("ad_object")));
        JsonUtils.putJSONObject(zx, "ortb_response", b(aVar));
        return zx;
    }

    private JSONObject zw() {
        JSONObject jSONObject = avH;
        if (jSONObject != null) {
            return jSONObject;
        }
        JSONObject jSONObject2 = new JSONObject();
        JsonUtils.putInt(jSONObject2, "ad_id", 0);
        JsonUtils.putString(jSONObject2, "base_url", "file://");
        JsonUtils.putString(jSONObject2, "graphic_background_color", "#000000");
        JsonUtils.putBoolean(jSONObject2, "lock_current_orientation", true);
        JsonUtils.putBoolean(jSONObject2, "omsdk_enabled", false);
        JsonUtils.putBoolean(jSONObject2, "playback_requires_user_action", true);
        JsonUtils.putString(jSONObject2, "presentation_mode", "activity");
        JsonUtils.putBoolean(jSONObject2, "unhide_adview_on_render", true);
        JsonUtils.putJSONObject(jSONObject2, "web_view_settings", zy());
        avH = jSONObject2;
        return jSONObject2;
    }

    private JSONObject zx() {
        JSONObject jSONObject = avI;
        if (jSONObject != null) {
            return jSONObject;
        }
        JSONObject jSONObject2 = new JSONObject();
        JsonUtils.putInt(jSONObject2, "ad_id", 0);
        JsonUtils.putBoolean(jSONObject2, "uerp", true);
        JsonUtils.putString(jSONObject2, "presentation_mode", "activity");
        JsonUtils.putJSONObject(jSONObject2, "web_view_settings", zy());
        avI = jSONObject2;
        return jSONObject2;
    }

    private JSONObject b(a aVar) {
        JSONObject jSONObject = new JSONObject();
        JsonUtils.putJsonArray(jSONObject, "assets", c(aVar));
        JsonUtils.putJSONObject(jSONObject, "link", d(aVar));
        JsonUtils.putJsonArray(jSONObject, "eventtrackers", e(aVar));
        JsonUtils.putString(jSONObject, "ver", aVar.getVersion());
        JSONObject jSONObject2 = new JSONObject();
        JsonUtils.putJSONObject(jSONObject2, "native", jSONObject);
        JSONObject jSONObject3 = new JSONObject();
        JsonUtils.putString(jSONObject3, MediationMetaData.KEY_VERSION, aVar.getVersion());
        JsonUtils.putJSONObject(jSONObject3, m2.h.X, jSONObject2);
        return jSONObject3;
    }

    private JSONArray c(a aVar) {
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject = new JSONObject();
        JsonUtils.putInt(jSONObject, w5.x, 1);
        JSONObject jSONObject2 = new JSONObject();
        JsonUtils.putString(jSONObject2, m2.h.K0, aVar.getTitle());
        JsonUtils.putJSONObject(jSONObject, m2.h.D0, jSONObject2);
        jSONArray.put(jSONObject);
        JSONObject jSONObject3 = new JSONObject();
        JsonUtils.putInt(jSONObject3, w5.x, 8);
        JSONObject jSONObject4 = new JSONObject();
        JsonUtils.putString(jSONObject4, m2.h.X, aVar.getAdvertiser());
        JsonUtils.putJSONObject(jSONObject3, "data", jSONObject4);
        jSONArray.put(jSONObject3);
        JSONObject jSONObject5 = new JSONObject();
        JsonUtils.putInt(jSONObject5, w5.x, 4);
        JSONObject jSONObject6 = new JSONObject();
        JsonUtils.putString(jSONObject6, m2.h.X, aVar.getBody());
        JsonUtils.putJSONObject(jSONObject5, "data", jSONObject6);
        jSONArray.put(jSONObject5);
        if (StringUtils.isValidString(aVar.zb())) {
            JSONObject jSONObject7 = new JSONObject();
            JsonUtils.putInt(jSONObject7, w5.x, 2);
            JSONObject jSONObject8 = new JSONObject();
            JsonUtils.putString(jSONObject8, "url", aVar.zb());
            JsonUtils.putInt(jSONObject8, "w", aVar.zc());
            JsonUtils.putInt(jSONObject8, "h", aVar.zd());
            JsonUtils.putJSONObject(jSONObject7, "img", jSONObject8);
            jSONArray.put(jSONObject7);
        }
        return jSONArray;
    }

    private JSONObject d(a aVar) {
        JSONObject jSONObject = new JSONObject();
        JsonUtils.putString(jSONObject, "url", aVar.ze());
        JsonUtils.putJsonArray(jSONObject, "clicktrackers", aVar.zf());
        return jSONObject;
    }

    private JSONArray e(a aVar) {
        JSONArray jSONArray = new JSONArray();
        for (String putString : aVar.zh()) {
            JSONObject jSONObject = new JSONObject();
            JsonUtils.putString(jSONObject, "url", putString);
            JsonUtils.putInt(jSONObject, NotificationCompat.CATEGORY_EVENT, 1);
            JsonUtils.putInt(jSONObject, "method", 1);
            jSONArray.put(jSONObject);
        }
        for (String putString2 : aVar.zg()) {
            JSONObject jSONObject2 = new JSONObject();
            JsonUtils.putString(jSONObject2, "url", putString2);
            JsonUtils.putInt(jSONObject2, "type", 1);
            JsonUtils.putInt(jSONObject2, "method", 2);
            jSONArray.put(jSONObject2);
        }
        return jSONArray;
    }

    private static AppLovinAdSize d(MaxAdFormat maxAdFormat) {
        if (maxAdFormat.isFullscreenAd()) {
            return AppLovinAdSize.INTERSTITIAL;
        }
        if (MaxAdFormat.BANNER == maxAdFormat) {
            return AppLovinAdSize.BANNER;
        }
        if (MaxAdFormat.LEADER == maxAdFormat) {
            return AppLovinAdSize.LEADER;
        }
        if (MaxAdFormat.MREC == maxAdFormat) {
            return AppLovinAdSize.MREC;
        }
        if (MaxAdFormat.NATIVE == maxAdFormat) {
            return AppLovinAdSize.NATIVE;
        }
        throw new IllegalArgumentException("Unsupported ad format: " + maxAdFormat);
    }

    private static AppLovinAdType e(MaxAdFormat maxAdFormat) {
        if (maxAdFormat.isAdViewAd() || MaxAdFormat.INTERSTITIAL == maxAdFormat) {
            return AppLovinAdType.REGULAR;
        }
        if (MaxAdFormat.NATIVE == maxAdFormat) {
            return AppLovinAdType.NATIVE;
        }
        if (MaxAdFormat.REWARDED == maxAdFormat) {
            return AppLovinAdType.INCENTIVIZED;
        }
        if (MaxAdFormat.REWARDED_INTERSTITIAL == maxAdFormat) {
            return AppLovinAdType.AUTO_INCENTIVIZED;
        }
        if (MaxAdFormat.APP_OPEN == maxAdFormat) {
            return AppLovinAdType.APP_OPEN;
        }
        throw new IllegalArgumentException("Unsupported ad format: " + maxAdFormat);
    }

    private static JSONObject zy() {
        JSONObject jSONObject = avJ;
        if (jSONObject != null) {
            return jSONObject;
        }
        JSONObject jSONObject2 = new JSONObject();
        JsonUtils.putBoolean(jSONObject2, "allow_file_access", true);
        avJ = jSONObject2;
        return jSONObject2;
    }
}
