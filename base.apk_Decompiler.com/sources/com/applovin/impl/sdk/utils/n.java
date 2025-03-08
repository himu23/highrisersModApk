package com.applovin.impl.sdk.utils;

import android.os.Bundle;
import com.applovin.adview.AppLovinAdView;
import com.applovin.impl.b.a;
import com.applovin.impl.sdk.ad.e;

public class n {
    private final StringBuilder aqX = new StringBuilder();

    public String toString() {
        return this.aqX.toString();
    }

    public n e(String str, Object obj) {
        return a(str, obj, "");
    }

    public n a(String str, Object obj, String str2) {
        StringBuilder sb = this.aqX;
        sb.append("\n");
        sb.append(str);
        sb.append(": ");
        sb.append(obj);
        sb.append(str2);
        return this;
    }

    public n dz(String str) {
        StringBuilder sb = this.aqX;
        sb.append("\n");
        sb.append(str);
        return this;
    }

    public n dA(String str) {
        this.aqX.append(str);
        return this;
    }

    public n Lo() {
        this.aqX.append("\n========================================");
        return this;
    }

    public n g(e eVar) {
        boolean z = eVar instanceof a;
        e("Format", eVar.getAdZone().getFormat() != null ? eVar.getAdZone().getFormat().getLabel() : null).e("Ad ID", Long.valueOf(eVar.getAdIdNumber())).e("Zone ID", eVar.getAdZone().mQ()).e("Source", eVar.getSource()).e("Ad Class", z ? "VastAd" : "AdServerAd");
        String dspName = eVar.getDspName();
        if (StringUtils.isValidString(dspName)) {
            e("DSP Name", dspName);
        }
        if (z) {
            e("VAST DSP", ((a) eVar).LT());
        }
        return this;
    }

    public n h(e eVar) {
        e("Target", eVar.Gb()).e("close_style", eVar.Gg()).a("close_delay_graphic", Long.valueOf(eVar.Ge()), "s");
        if (eVar instanceof com.applovin.impl.sdk.ad.a) {
            com.applovin.impl.sdk.ad.a aVar = (com.applovin.impl.sdk.ad.a) eVar;
            e("HTML", aVar.FB().substring(0, Math.min(aVar.FB().length(), 64)));
        }
        if (eVar.hasVideoUrl()) {
            a("close_delay", Long.valueOf(eVar.Gc()), "s").e("skip_style", eVar.Gj()).e("Streaming", Boolean.valueOf(eVar.FF())).e("Video Location", eVar.FD()).e("video_button_properties", eVar.Gp());
        }
        return this;
    }

    public n n(com.applovin.impl.mediation.b.a aVar) {
        String str = "None";
        n e = e("Network", aVar.yA()).e("Adapter Version", aVar.getAdapterVersion()).e("Format", aVar.getFormat().getLabel()).e("Ad Unit ID", aVar.getAdUnitId()).e("Placement", aVar.getPlacement()).e("Network Placement", aVar.getThirdPartyAdPlacementId()).e("Serve ID", aVar.xA()).e("Creative ID", StringUtils.isValidString(aVar.getCreativeId()) ? aVar.getCreativeId() : str).e("Ad Review Creative ID", StringUtils.isValidString(aVar.getAdReviewCreativeId()) ? aVar.getAdReviewCreativeId() : str).e("Ad Domain", StringUtils.isValidString(aVar.xB()) ? aVar.xB() : str).e("DSP Name", StringUtils.isValidString(aVar.getDspName()) ? aVar.getDspName() : str);
        if (StringUtils.isValidString(aVar.getDspId())) {
            str = aVar.getDspId();
        }
        return e.e("DSP ID", str).e("Server Parameters", aVar.getServerParameters());
    }

    public n a(AppLovinAdView appLovinAdView) {
        return e("Size", appLovinAdView.getSize().getWidth() + "x" + appLovinAdView.getSize().getHeight()).e("Alpha", Float.valueOf(appLovinAdView.getAlpha())).e("Visibility", v.ha(appLovinAdView.getVisibility()));
    }

    public n L(com.applovin.impl.sdk.n nVar) {
        return e("Muted", Boolean.valueOf(nVar.getSettings().isMuted()));
    }

    public n T(Bundle bundle) {
        if (bundle == null) {
            return this;
        }
        for (String str : bundle.keySet()) {
            e(str, bundle.get(str));
        }
        return this;
    }
}
