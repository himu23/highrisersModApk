package com.applovin.impl.mediation.b;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import com.applovin.impl.mediation.a.c;
import com.applovin.impl.mediation.g;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.BundleUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.x;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdWaterfallInfo;
import com.applovin.mediation.nativeAds.MaxNativeAd;
import com.applovin.sdk.AppLovinSdkUtils;
import com.ironsource.mediationsdk.impressionData.ImpressionData;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public abstract class a extends f implements MaxAd {
    private final int Y;
    private final String apj;
    private final AtomicBoolean auu = new AtomicBoolean();
    private final AtomicBoolean auv = new AtomicBoolean();
    protected g auw;
    private String aux;
    private c auy;
    private String loadTag;
    private long requestLatencyMillis;
    private MaxAdWaterfallInfo waterfall;

    public int ah() {
        return this.Y;
    }

    public void bV(String str) {
        this.aux = str;
    }

    public String getAdReviewCreativeId() {
        return this.aux;
    }

    public String getAdapterVersion() {
        return this.apj;
    }

    public String getLoadTag() {
        return this.loadTag;
    }

    public long getRequestLatencyMillis() {
        return this.requestLatencyMillis;
    }

    public MaxAdWaterfallInfo getWaterfall() {
        return this.waterfall;
    }

    public abstract a k(g gVar);

    public void setLoadTag(String str) {
        this.loadTag = str;
    }

    public void setRequestLatencyMillis(long j) {
        this.requestLatencyMillis = j;
    }

    public void setWaterfall(MaxAdWaterfallInfo maxAdWaterfallInfo) {
        this.waterfall = maxAdWaterfallInfo;
    }

    public g xC() {
        return this.auw;
    }

    public AtomicBoolean xO() {
        return this.auu;
    }

    public AtomicBoolean xP() {
        return this.auv;
    }

    public void xQ() {
        this.auw = null;
        this.waterfall = null;
    }

    public static a a(int i, Map<String, Object> map, JSONObject jSONObject, JSONObject jSONObject2, n nVar) {
        String string = JsonUtils.getString(jSONObject2, "ad_format", (String) null);
        MaxAdFormat formatFromString = MaxAdFormat.formatFromString(string);
        Objects.requireNonNull(formatFromString, "Invalid ad format for string: " + string);
        if (formatFromString.isAdViewAd()) {
            return new b(i, map, jSONObject, jSONObject2, nVar);
        }
        if (formatFromString == MaxAdFormat.NATIVE) {
            return new d(i, map, jSONObject, jSONObject2, nVar);
        }
        if (formatFromString.isFullscreenAd()) {
            return new c(i, map, jSONObject, jSONObject2, nVar);
        }
        throw new IllegalArgumentException("Unsupported ad format: " + string);
    }

    protected a(int i, Map<String, Object> map, JSONObject jSONObject, JSONObject jSONObject2, g gVar, n nVar) {
        super(map, jSONObject, jSONObject2, nVar);
        this.Y = i;
        this.auw = gVar;
        this.apj = gVar != null ? gVar.getAdapterVersion() : null;
    }

    public String xs() {
        return getStringFromAdObject("bcode", "");
    }

    public long xt() {
        return getLongFromAdObject("bwt_ms", ((Long) this.sdk.a(com.applovin.impl.sdk.c.a.aKc)).longValue());
    }

    public long xu() {
        return getLongFromAdObject("twt_ms", ((Long) this.sdk.a(com.applovin.impl.sdk.c.a.aKd)).longValue());
    }

    public MaxAdFormat getFormat() {
        return MaxAdFormat.formatFromString(getStringFromAdObject("ad_format", getStringFromFullResponse("ad_format", (String) null)));
    }

    public AppLovinSdkUtils.Size getSize() {
        int intFromAdObject = getIntFromAdObject("ad_width", -3);
        int intFromAdObject2 = getIntFromAdObject("ad_height", -3);
        if (intFromAdObject == -3 || intFromAdObject2 == -3) {
            return getFormat().getSize();
        }
        return new AppLovinSdkUtils.Size(intFromAdObject, intFromAdObject2);
    }

    public String getNetworkName() {
        return getStringFromAdObject("network_name", "");
    }

    public String getNetworkPlacement() {
        return StringUtils.emptyIfNull(getThirdPartyAdPlacementId());
    }

    public String getCreativeId() {
        return getStringFromAdObject("creative_id", (String) null);
    }

    public double getRevenue() {
        if (!((Boolean) this.sdk.a(com.applovin.impl.sdk.c.a.aJZ)).booleanValue() || !getFormat().isFullscreenAd() || xO().get()) {
            return JsonUtils.getDouble(getJsonObjectFromAdObject("revenue_parameters", (JSONObject) null), ImpressionData.IMPRESSION_DATA_KEY_REVENUE, -1.0d);
        }
        this.sdk.BN();
        if (!x.Fn()) {
            return 0.0d;
        }
        this.sdk.BN().i("MediatedAd", "Attempting to retrieve revenue when not available yet");
        return 0.0d;
    }

    public String getRevenuePrecision() {
        return JsonUtils.getString(getJsonObjectFromAdObject("revenue_parameters", (JSONObject) null), ImpressionData.IMPRESSION_DATA_KEY_PRECISION, "");
    }

    public String getDspName() {
        return getStringFromAdObject("dsp_name", (String) null);
    }

    public String getDspId() {
        return getStringFromAdObject("dsp_id", (String) null);
    }

    public String getAdValue(String str) {
        return getAdValue(str, (String) null);
    }

    public String getAdValue(String str, String str2) {
        JSONObject xw = xw();
        if (xw.has(str)) {
            return JsonUtils.getString(xw, str, str2);
        }
        Bundle serverParameters = getServerParameters();
        if (serverParameters.containsKey(str)) {
            return serverParameters.getString(str);
        }
        JSONObject xx = xx();
        if (xx.has(str)) {
            return JsonUtils.getString(xx, str, str2);
        }
        return getStringFromAdObject(str, str2);
    }

    public double xv() {
        return a("price", -1.0f);
    }

    public void g(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.length() != 0) {
            JSONObject xw = xw();
            JsonUtils.putAll(xw, jSONObject);
            a("ad_values", (Object) xw);
        }
    }

    public void h(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.length() != 0) {
            JSONObject xx = xx();
            JsonUtils.putAll(xx, jSONObject);
            a("publisher_extra_info", (Object) xx);
        }
    }

    public JSONObject xw() {
        return getJsonObjectFromAdObject("ad_values", new JSONObject());
    }

    public JSONObject xx() {
        return getJsonObjectFromAdObject("publisher_extra_info", new JSONObject());
    }

    public JSONObject xy() {
        return getJsonObjectFromAdObject("revenue_parameters", new JSONObject());
    }

    public String xz() {
        return JsonUtils.getString(xy(), "revenue_event", "");
    }

    public String xA() {
        return getStringFromFullResponse("event_id", "");
    }

    public String xB() {
        return getStringFromAdObject("adomain", (String) null);
    }

    public boolean isReady() {
        g gVar = this.auw;
        return gVar != null && gVar.isEnabled() && this.auw.ug();
    }

    public Bundle getCredentials() {
        JSONObject jSONObject;
        if (bX("credentials")) {
            jSONObject = getJsonObjectFromAdObject("credentials", new JSONObject());
        } else {
            jSONObject = getJsonObjectFromAdObject("server_parameters", new JSONObject());
            JsonUtils.putString(jSONObject, "placement_id", getThirdPartyAdPlacementId());
        }
        return JsonUtils.toBundle(jSONObject);
    }

    public String getBidResponse() {
        return getStringFromAdObject("bid_response", (String) null);
    }

    public boolean isBidding() {
        return StringUtils.isValidString(getBidResponse());
    }

    public long getBidExpirationMillis() {
        return getLongFromAdObject("bid_expiration_ms", BundleUtils.getLong("bid_expiration_ms", -1, getServerParameters()));
    }

    public boolean xD() {
        return b("is_js_tag_ad", (Boolean) false).booleanValue();
    }

    public MaxAdFormat xE() {
        String stringFromAdObject = getStringFromAdObject("haf", (String) null);
        if (StringUtils.isValidString(stringFromAdObject)) {
            return MaxAdFormat.formatFromString(stringFromAdObject);
        }
        return null;
    }

    public boolean xF() {
        return xE() != null;
    }

    public c xG() {
        c cVar = this.auy;
        if (cVar != null) {
            return cVar;
        }
        c cVar2 = new c(getJsonObjectFromAdObject("hybrid_ad_config", (JSONObject) null));
        this.auy = cVar2;
        return cVar2;
    }

    public View getAdView() {
        g gVar;
        if (!isReady() || (gVar = this.auw) == null) {
            return null;
        }
        return gVar.ub();
    }

    public MaxNativeAd getNativeAd() {
        g gVar = this.auw;
        if (gVar != null) {
            return gVar.uc();
        }
        return null;
    }

    public String getThirdPartyAdPlacementId() {
        return getStringFromAdObject("third_party_ad_placement_id", (String) null);
    }

    public String xH() {
        return getStringFromFullResponse("waterfall_name", "");
    }

    public String xI() {
        return getStringFromFullResponse("waterfall_test_name", "");
    }

    public long xJ() {
        if (xK() > 0) {
            return xM() - xK();
        }
        return -1;
    }

    private long xK() {
        return getLongFromAdObject("load_started_time_ms", 0);
    }

    public void xL() {
        e("load_started_time_ms", SystemClock.elapsedRealtime());
    }

    public long xM() {
        return getLongFromAdObject("load_completed_time_ms", 0);
    }

    public void xN() {
        e("load_completed_time_ms", SystemClock.elapsedRealtime());
    }

    public void S(Bundle bundle) {
        if (bundle != null) {
            if (bundle.containsKey("ad_values")) {
                g(BundleUtils.toJSONObject(bundle.getBundle("ad_values")));
            }
            if (bundle.containsKey("creative_id") && !bX("creative_id")) {
                x("creative_id", BundleUtils.getString("creative_id", bundle));
            }
            if (bundle.containsKey("ad_width") && !bX("ad_width") && bundle.containsKey("ad_height") && !bX("ad_height")) {
                int i = BundleUtils.getInt("ad_width", bundle);
                int i2 = BundleUtils.getInt("ad_height", bundle);
                d("ad_width", i);
                d("ad_height", i2);
            }
            if (bundle.containsKey("publisher_extra_info")) {
                h(BundleUtils.toJSONObject(bundle.getBundle("publisher_extra_info")));
            }
        }
    }

    public String toString() {
        return "MediatedAd{thirdPartyAdPlacementId=" + getThirdPartyAdPlacementId() + ", adUnitId=" + getAdUnitId() + ", format=" + getFormat().getLabel() + ", networkName='" + getNetworkName() + "'}";
    }
}
