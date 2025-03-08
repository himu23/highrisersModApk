package com.applovin.impl.sdk.ad;

import android.text.TextUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

public final class d {
    private static final Map<String, d> aGq = new HashMap();
    private static final Object aGr = new Object();
    private JSONObject aGs;
    private AppLovinAdType aGt;
    private AppLovinAdSize agh;

    /* renamed from: do  reason: not valid java name */
    private final String f14do;

    public String mQ() {
        return this.f14do;
    }

    public static d cQ(String str) {
        return a((AppLovinAdSize) null, (AppLovinAdType) null, str);
    }

    public static d a(AppLovinAdSize appLovinAdSize, AppLovinAdType appLovinAdType) {
        return a(appLovinAdSize, appLovinAdType, (String) null);
    }

    public static d cR(String str) {
        return a(AppLovinAdSize.INTERSTITIAL, AppLovinAdType.INCENTIVIZED, str);
    }

    public static d a(AppLovinAdSize appLovinAdSize, AppLovinAdType appLovinAdType, String str) {
        return a(appLovinAdSize, appLovinAdType, str, false, false);
    }

    public static d a(AppLovinAdSize appLovinAdSize, AppLovinAdType appLovinAdType, String str, boolean z, boolean z2) {
        d dVar = new d(appLovinAdSize, appLovinAdType, str, z, z2);
        synchronized (aGr) {
            String str2 = dVar.f14do;
            Map<String, d> map = aGq;
            if (map.containsKey(str2)) {
                dVar = map.get(str2);
            } else {
                map.put(str2, dVar);
            }
        }
        return dVar;
    }

    private d(AppLovinAdSize appLovinAdSize, AppLovinAdType appLovinAdType, String str, boolean z, boolean z2) {
        String str2;
        if (!TextUtils.isEmpty(str) || !(appLovinAdType == null || appLovinAdSize == null)) {
            this.agh = appLovinAdSize;
            this.aGt = appLovinAdType;
            if (StringUtils.isValidString(str)) {
                str2 = str.trim().toLowerCase(Locale.ENGLISH);
            } else {
                str2 = (appLovinAdSize.getLabel() + "_" + appLovinAdType.getLabel()).toLowerCase(Locale.ENGLISH);
            }
            if (z) {
                str2 = str2 + "_bidding";
            }
            if (z2) {
                str2 = str2 + "_direct_sold";
            }
            this.f14do = str2;
            return;
        }
        throw new IllegalArgumentException("No zone identifier or type or size specified");
    }

    public static void H(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.has("ad_size") && jSONObject.has("ad_type")) {
            synchronized (aGr) {
                d dVar = aGq.get(JsonUtils.getString(jSONObject, "zone_id", ""));
                if (dVar != null) {
                    dVar.agh = AppLovinAdSize.fromString(JsonUtils.getString(jSONObject, "ad_size", ""));
                    dVar.aGt = AppLovinAdType.fromString(JsonUtils.getString(jSONObject, "ad_type", ""));
                }
            }
        }
    }

    public MaxAdFormat getFormat() {
        AppLovinAdSize size = getSize();
        if (size == AppLovinAdSize.BANNER) {
            return MaxAdFormat.BANNER;
        }
        if (size == AppLovinAdSize.LEADER) {
            return MaxAdFormat.LEADER;
        }
        if (size == AppLovinAdSize.MREC) {
            return MaxAdFormat.MREC;
        }
        if (size == AppLovinAdSize.CROSS_PROMO) {
            return MaxAdFormat.CROSS_PROMO;
        }
        if (size == AppLovinAdSize.INTERSTITIAL) {
            if (getType() == AppLovinAdType.REGULAR) {
                return MaxAdFormat.INTERSTITIAL;
            }
            if (getType() == AppLovinAdType.APP_OPEN) {
                return MaxAdFormat.APP_OPEN;
            }
            if (getType() == AppLovinAdType.INCENTIVIZED) {
                return MaxAdFormat.REWARDED;
            }
            if (getType() == AppLovinAdType.AUTO_INCENTIVIZED) {
                return MaxAdFormat.REWARDED_INTERSTITIAL;
            }
            return null;
        } else if (size == AppLovinAdSize.NATIVE) {
            return MaxAdFormat.NATIVE;
        } else {
            return null;
        }
    }

    public AppLovinAdSize getSize() {
        if (this.agh == null && JsonUtils.valueExists(this.aGs, "ad_size")) {
            this.agh = AppLovinAdSize.fromString(JsonUtils.getString(this.aGs, "ad_size", (String) null));
        }
        return this.agh;
    }

    public AppLovinAdType getType() {
        if (this.aGt == null && JsonUtils.valueExists(this.aGs, "ad_type")) {
            this.aGt = AppLovinAdType.fromString(JsonUtils.getString(this.aGs, "ad_type", (String) null));
        }
        return this.aGt;
    }

    public boolean FS() {
        return FT().contains(this);
    }

    public static Collection<d> FT() {
        LinkedHashSet linkedHashSet = new LinkedHashSet(7);
        Collections.addAll(linkedHashSet, new d[]{FU(), FV(), FW(), FX(), FY(), FZ(), Ga()});
        return Collections.unmodifiableSet(linkedHashSet);
    }

    public static d FU() {
        return a(AppLovinAdSize.BANNER, AppLovinAdType.REGULAR);
    }

    public static d FV() {
        return a(AppLovinAdSize.MREC, AppLovinAdType.REGULAR);
    }

    public static d FW() {
        return a(AppLovinAdSize.LEADER, AppLovinAdType.REGULAR);
    }

    public static d FX() {
        return a(AppLovinAdSize.INTERSTITIAL, AppLovinAdType.REGULAR);
    }

    public static d FY() {
        return a(AppLovinAdSize.INTERSTITIAL, AppLovinAdType.APP_OPEN);
    }

    public static d FZ() {
        return a(AppLovinAdSize.INTERSTITIAL, AppLovinAdType.INCENTIVIZED);
    }

    public static d Ga() {
        return a(AppLovinAdSize.NATIVE, AppLovinAdType.NATIVE);
    }

    public String toString() {
        return "AdZone{id=" + this.f14do + ", zoneObject=" + this.aGs + '}';
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.f14do.equalsIgnoreCase(((d) obj).f14do);
    }

    public int hashCode() {
        return this.f14do.hashCode();
    }
}
