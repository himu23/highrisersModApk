package com.applovin.impl.sdk.ad;

import android.os.Bundle;
import com.applovin.impl.sdk.AppLovinAdBase;
import com.applovin.impl.sdk.c.b;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.BundleUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.x;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import org.json.JSONObject;

public abstract class AppLovinAdImpl extends AppLovinAdBase implements g, AppLovinAd {
    private final Bundle aGu = new Bundle();
    private f aGv;
    private d azA;
    private boolean isExpired;
    protected final b source;

    public f getDummyAd() {
        return this.aGv;
    }

    public Bundle getMAXAdValues() {
        return this.aGu;
    }

    public abstract JSONObject getOriginalFullResponse();

    public b getSource() {
        return this.source;
    }

    public boolean isExpired() {
        return this.isExpired;
    }

    public void setDummyAd(f fVar) {
        this.aGv = fVar;
    }

    public void setExpired() {
        this.isExpired = true;
    }

    protected AppLovinAdImpl(JSONObject jSONObject, JSONObject jSONObject2, b bVar, n nVar) {
        super(jSONObject, jSONObject2, nVar);
        this.source = bVar;
    }

    public String getRawFullResponse() {
        String jSONObject;
        synchronized (this.fullResponseLock) {
            jSONObject = this.fullResponse.toString();
        }
        return jSONObject;
    }

    public boolean hasVideoUrl() {
        this.sdk.BN();
        if (!x.Fn()) {
            return false;
        }
        this.sdk.BN().i("AppLovinAd", "Attempting to invoke hasVideoUrl() from base ad class");
        return false;
    }

    public boolean hasShown() {
        return getBooleanFromAdObject("shown", false);
    }

    public void setHasShown(boolean z) {
        try {
            synchronized (this.adObjectLock) {
                this.adObject.put("shown", z);
            }
        } catch (Throwable unused) {
        }
    }

    public boolean shouldCancelHtmlCachingIfShown() {
        return getBooleanFromAdObject("chcis", false);
    }

    public void setMaxAdValue(String str, Object obj) {
        BundleUtils.put(str, obj, this.aGu);
    }

    public long getAdIdNumber() {
        return getLongFromAdObject("ad_id", -1);
    }

    public AppLovinAdSize getSize() {
        return AppLovinAdSize.fromString(getStringFromFullResponse("ad_size", (String) null));
    }

    public AppLovinAdType getType() {
        return AppLovinAdType.fromString(getStringFromFullResponse("ad_type", (String) null));
    }

    public String getZoneId() {
        if (getAdZone().FS()) {
            return null;
        }
        return getStringFromFullResponse("zone_id", (String) null);
    }

    public boolean isVideoAd() {
        if (this.adObject.has("is_video_ad")) {
            return getBooleanFromAdObject("is_video_ad", false);
        }
        return hasVideoUrl();
    }

    public String getAdValue(String str) {
        return getAdValue(str, (String) null);
    }

    public String getAdValue(String str, String str2) {
        return JsonUtils.getString(getJsonObjectFromAdObject("ad_values", new JSONObject()), str, str2);
    }

    public d getAdZone() {
        d dVar = this.azA;
        if (dVar != null) {
            if (dVar.getSize() != null && this.azA.getType() != null) {
                return this.azA;
            }
            if (getSize() == null && getType() == null) {
                return this.azA;
            }
        }
        d a = d.a(getSize(), getType(), getStringFromFullResponse("zone_id", (String) null), getBooleanFromFullResponse("is_bidding", false), getBooleanFromFullResponse("is_direct_sold", false));
        this.azA = a;
        return a;
    }

    public boolean canExpire() {
        return getSize() == AppLovinAdSize.INTERSTITIAL && yj() > 0;
    }

    public long getTimeToLiveMillis() {
        if (!canExpire()) {
            return Long.MAX_VALUE;
        }
        return yj() - (System.currentTimeMillis() - getCreatedAtMillis());
    }

    private long yj() {
        return getLongFromAdObject("ad_expiration_ms", ((Long) this.sdk.a(b.aMd)).longValue());
    }

    public boolean equals(Object obj) {
        AppLovinAd HC;
        if ((obj instanceof f) && (HC = ((f) obj).HC()) != null) {
            obj = HC;
        }
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass() && getAdIdNumber() == ((AppLovinAdImpl) obj).getAdIdNumber()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (int) getAdIdNumber();
    }

    public String toString() {
        return "AppLovinAd{adIdNumber=" + getAdIdNumber() + ", source=" + getSource() + ", zoneId=\"" + getZoneId() + "\"}";
    }
}
