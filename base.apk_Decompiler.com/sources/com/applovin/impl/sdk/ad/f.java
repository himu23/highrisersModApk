package com.applovin.impl.sdk.ad;

import android.os.Bundle;
import com.applovin.impl.sdk.n;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import com.iab.omid.library.applovin.adsession.VerificationScriptResource;
import java.util.List;
import org.json.JSONObject;

public final class f extends AppLovinAdImpl {
    private AppLovinAd aGZ;
    private final d aHa;

    public AppLovinAd HB() {
        return this.aGZ;
    }

    public void e(AppLovinAd appLovinAd) {
        this.aGZ = appLovinAd;
    }

    public String getDirectDownloadToken() {
        return null;
    }

    public String getOpenMeasurementContentUrl() {
        return null;
    }

    public String getOpenMeasurementCustomReferenceData() {
        return null;
    }

    public List<VerificationScriptResource> getOpenMeasurementVerificationScriptResources() {
        return null;
    }

    public boolean isDirectDownloadEnabled() {
        return false;
    }

    public boolean isOpenMeasurementEnabled() {
        return false;
    }

    public f(d dVar, n nVar) {
        super(new JSONObject(), new JSONObject(), b.UNKNOWN, nVar);
        this.aHa = dVar;
    }

    public d getAdZone() {
        AppLovinAdImpl appLovinAdImpl = (AppLovinAdImpl) HC();
        return appLovinAdImpl != null ? appLovinAdImpl.getAdZone() : this.aHa;
    }

    public b getSource() {
        AppLovinAdImpl appLovinAdImpl = (AppLovinAdImpl) HC();
        return appLovinAdImpl != null ? appLovinAdImpl.getSource() : b.UNKNOWN;
    }

    public boolean isExpired() {
        AppLovinAdImpl appLovinAdImpl = (AppLovinAdImpl) HC();
        return appLovinAdImpl != null && appLovinAdImpl.isExpired();
    }

    public long getAdIdNumber() {
        AppLovinAd HC = HC();
        if (HC != null) {
            return HC.getAdIdNumber();
        }
        return 0;
    }

    public AppLovinAdSize getSize() {
        return getAdZone().getSize();
    }

    public AppLovinAdType getType() {
        return getAdZone().getType();
    }

    public String getZoneId() {
        if (this.aHa.FS()) {
            return null;
        }
        return this.aHa.mQ();
    }

    public boolean isVideoAd() {
        AppLovinAd HC = HC();
        return HC != null && HC.isVideoAd();
    }

    public AppLovinAd HC() {
        AppLovinAd appLovinAd = this.aGZ;
        return appLovinAd != null ? appLovinAd : HD();
    }

    public long getCreatedAtMillis() {
        AppLovinAd HC = HC();
        if (HC instanceof AppLovinAdImpl) {
            return ((AppLovinAdImpl) HC).getCreatedAtMillis();
        }
        return 0;
    }

    public JSONObject getOriginalFullResponse() {
        AppLovinAd HC = HC();
        if (HC instanceof AppLovinAdImpl) {
            return ((AppLovinAdImpl) HC).getOriginalFullResponse();
        }
        return null;
    }

    private AppLovinAd HD() {
        return (AppLovinAd) this.sdk.Ca().c(this.aHa);
    }

    public Bundle getDirectDownloadParameters() {
        return new Bundle();
    }

    public String toString() {
        return "AppLovinAd{ #" + getAdIdNumber() + ", adType=" + getType() + ", adSize=" + getSize() + ", zoneId='" + HE() + "'}";
    }

    private String HE() {
        d adZone = getAdZone();
        if (adZone == null || adZone.FS()) {
            return null;
        }
        return adZone.mQ();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AppLovinAd HC = HC();
        if (HC != null) {
            return HC.equals(obj);
        }
        return super.equals(obj);
    }

    public int hashCode() {
        AppLovinAd HC = HC();
        if (HC != null) {
            return HC.hashCode();
        }
        return super.hashCode();
    }
}
