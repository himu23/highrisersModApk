package com.applovin.impl.mediation.b;

import android.os.SystemClock;
import android.view.ViewGroup;
import com.applovin.impl.sdk.ad.g;
import com.applovin.impl.sdk.c.a;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.BundleUtils;
import com.applovin.mediation.nativeAds.MaxNativeAd;
import com.applovin.mediation.nativeAds.MaxNativeAdView;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class d extends e implements g {
    private final AtomicBoolean auD = new AtomicBoolean();
    private final AtomicBoolean auE = new AtomicBoolean();

    public AtomicBoolean yo() {
        return this.auD;
    }

    public AtomicBoolean yp() {
        return this.auE;
    }

    public d(int i, Map<String, Object> map, JSONObject jSONObject, JSONObject jSONObject2, n nVar) {
        super(i, map, jSONObject, jSONObject2, (com.applovin.impl.mediation.g) null, nVar);
    }

    private d(d dVar, com.applovin.impl.mediation.g gVar) {
        super(dVar.ah(), dVar.getLocalExtraParameters(), dVar.yz(), dVar.yy(), gVar, dVar.sdk);
    }

    public a k(com.applovin.impl.mediation.g gVar) {
        return new d(this, gVar);
    }

    public void setNativeAdView(MaxNativeAdView maxNativeAdView) {
        this.auw.a(maxNativeAdView);
    }

    public MaxNativeAdView yl() {
        return this.auw.ud();
    }

    public void c(ViewGroup viewGroup) {
        this.auw.b(viewGroup);
    }

    public ViewGroup ym() {
        return this.auw.ue();
    }

    public String yn() {
        return BundleUtils.getString("template", "", getServerParameters());
    }

    public boolean isContainerClickable() {
        return b("inacc", (Boolean) this.sdk.a(a.aKa)).booleanValue();
    }

    public boolean ur() {
        return this.auw == null;
    }

    public long getTimeToLiveMillis() {
        return yj() - (SystemClock.elapsedRealtime() - xM());
    }

    private long yj() {
        long longFromAdObject = getLongFromAdObject("ad_expiration_ms", -1);
        return longFromAdObject < 0 ? getLongFromFullResponse("ad_expiration_ms", ((Long) this.sdk.a(a.aJI)).longValue()) : longFromAdObject;
    }

    public void setExpired() {
        MaxNativeAd nativeAd = getNativeAd();
        if (nativeAd != null) {
            nativeAd.setExpired();
        }
    }
}
