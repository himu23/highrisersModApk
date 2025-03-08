package com.fyber.inneractive.sdk.bidder.adm;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.bidder.adm.AdmParametersOuterClass$AdmParameters;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.enums.UnitDisplayType;
import com.fyber.inneractive.sdk.config.global.s;
import com.fyber.inneractive.sdk.external.ImpressionData;
import com.fyber.inneractive.sdk.factories.b;
import com.fyber.inneractive.sdk.ignite.k;
import com.fyber.inneractive.sdk.network.n;
import com.fyber.inneractive.sdk.network.o0;
import com.fyber.inneractive.sdk.network.r0;
import com.fyber.inneractive.sdk.network.t0;
import com.fyber.inneractive.sdk.response.b;
import com.fyber.inneractive.sdk.response.e;
import com.fyber.inneractive.sdk.response.j;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.q;
import java.util.concurrent.TimeUnit;

public class f implements j {
    public AdmParametersOuterClass$AdmParameters a;
    public final String b;
    public String c;
    public final String d;

    public interface a {
    }

    public f(String str, String str2) {
        this.b = str;
        this.d = str2;
    }

    public static boolean a(f fVar, Exception exc) {
        fVar.getClass();
        return (exc instanceof t0) && ((t0) exc).a == 404;
    }

    public String a() {
        return this.c;
    }

    public int b() {
        AdmParametersOuterClass$AdmParameters admParametersOuterClass$AdmParameters = this.a;
        if (admParametersOuterClass$AdmParameters != null) {
            return admParametersOuterClass$AdmParameters.getAdType().a();
        }
        return AdmParametersOuterClass$AdmParameters.a.OTHER.a();
    }

    public static void a(f fVar, a aVar, s sVar) {
        int i;
        AdmParametersOuterClass$AdmParameters admParametersOuterClass$AdmParameters = fVar.a;
        e eVar = null;
        String markupUrl = (admParametersOuterClass$AdmParameters == null || !admParametersOuterClass$AdmParameters.hasMarkupUrl()) ? null : fVar.a.getMarkupUrl();
        if (!TextUtils.isEmpty(markupUrl)) {
            try {
                AdmParametersOuterClass$AdmParameters admParametersOuterClass$AdmParameters2 = fVar.a;
                if (admParametersOuterClass$AdmParameters2 != null) {
                    i = admParametersOuterClass$AdmParameters2.getAdType().a();
                } else {
                    i = AdmParametersOuterClass$AdmParameters.a.OTHER.a();
                }
                com.fyber.inneractive.sdk.response.a a2 = com.fyber.inneractive.sdk.response.a.a(i);
                if (a2 == null) {
                    a2 = com.fyber.inneractive.sdk.response.a.RETURNED_ADTYPE_MRAID;
                }
                b a3 = b.a.a.a(a2);
                if (a3 != null) {
                    a3.a((n) null);
                    fVar.a(a3);
                    eVar = a3.a;
                } else {
                    IAlog.a("failed parse adm network request with no input stream - received ad type %s does not have an appropriate parser", Integer.valueOf(i));
                }
            } catch (Exception e) {
                IAlog.a("failed parse adm network request with no input stream", e, new Object[0]);
            }
            e eVar2 = eVar;
            o0 o0Var = new o0(new c(fVar, aVar, eVar2), markupUrl, fVar, sVar, eVar2);
            o0Var.d = new d(fVar);
            IAConfigManager.M.s.a.offer(o0Var);
            o0Var.a(r0.QUEUED);
            return;
        }
        q.b.post(new e(fVar, aVar));
    }

    public void a(com.fyber.inneractive.sdk.response.b bVar) {
        String str;
        String str2;
        String str3;
        String str4;
        Integer num;
        String str5;
        String str6;
        String str7;
        long j;
        int i;
        int i2;
        int i3;
        String str8;
        com.fyber.inneractive.sdk.response.b bVar2 = bVar;
        bVar2.a.B = true;
        IAConfigManager.M.x.e = true;
        ImpressionData impressionData = new ImpressionData();
        AdmParametersOuterClass$AdmParameters admParametersOuterClass$AdmParameters = this.a;
        if (admParametersOuterClass$AdmParameters != null) {
            int a2 = admParametersOuterClass$AdmParameters.getAdType().a();
            if (this.a.hasErrorMessage()) {
                this.a.getErrorMessage();
            }
            String sessionId = this.a.hasSessionId() ? this.a.getSessionId() : null;
            Long valueOf = this.a.hasContentId() ? Long.valueOf(this.a.getContentId()) : null;
            if (this.a.hasPublisherId()) {
                this.a.getPublisherId();
            }
            Integer valueOf2 = this.a.hasAdWidth() ? Integer.valueOf(this.a.getAdWidth()) : null;
            Integer valueOf3 = this.a.hasAdHeight() ? Integer.valueOf(this.a.getAdHeight()) : null;
            String sdkImpressionUrl = this.a.hasSdkImpressionUrl() ? this.a.getSdkImpressionUrl() : null;
            String sdkClickUrl = this.a.hasSdkClickUrl() ? this.a.getSdkClickUrl() : null;
            Integer valueOf4 = this.a.hasAdExpirationInterval() ? Integer.valueOf(this.a.getAdExpirationInterval()) : null;
            String adCompletionUrl = this.a.hasAdCompletionUrl() ? this.a.getAdCompletionUrl() : null;
            bVar2.b = this.a.hasAdUnitId() ? this.a.getAdUnitId() : null;
            this.a.getAdUnitType().name().toLowerCase();
            String lowerCase = this.a.hasAdUnitId() ? this.a.getAdUnitDisplayType().name().toLowerCase() : null;
            String adNetworkName = this.a.hasAdNetworkName() ? this.a.getAdNetworkName() : null;
            Long valueOf5 = this.a.hasAdNetworkId() ? Long.valueOf(this.a.getAdNetworkId()) : null;
            String creativeId = this.a.hasCreativeId() ? this.a.getCreativeId() : null;
            String adDomain = this.a.hasAdDomain() ? this.a.getAdDomain() : null;
            if (this.a.hasAppBundleId()) {
                str2 = this.a.getAppBundleId();
                str = lowerCase;
            } else {
                str = lowerCase;
                str2 = null;
            }
            String campaignId = this.a.hasCampaignId() ? this.a.getCampaignId() : null;
            if (this.a.hasPricingValue()) {
                str4 = Double.toString(this.a.getPricingValue());
                str3 = adCompletionUrl;
            } else {
                str3 = adCompletionUrl;
                str4 = null;
            }
            String valueOf6 = this.a.hasSpotId() ? String.valueOf(this.a.getSpotId()) : null;
            impressionData.setCpmValue(str4);
            impressionData.setCurrency("USD");
            if (this.a.hasMrcData()) {
                if (this.a.getMrcData().hasPixelPercent()) {
                    i2 = this.a.getMrcData().getPixelPercent();
                    str6 = sdkClickUrl;
                } else {
                    str6 = sdkClickUrl;
                    i2 = 0;
                }
                if (this.a.getMrcData().hasPixelDuration()) {
                    i3 = this.a.getMrcData().getPixelDuration();
                    str5 = sdkImpressionUrl;
                } else {
                    str5 = sdkImpressionUrl;
                    i3 = -1;
                }
                if (this.a.getMrcData().hasPixelImpressionUrl()) {
                    str8 = this.a.getMrcData().getPixelImpressionUrl();
                    num = valueOf3;
                } else {
                    num = valueOf3;
                    str8 = null;
                }
                e eVar = bVar2.a;
                eVar.t = i2;
                eVar.u = (float) i3;
                eVar.v = str8;
            } else {
                num = valueOf3;
                str5 = sdkImpressionUrl;
                str6 = sdkClickUrl;
            }
            Boolean valueOf7 = this.a.hasSkipMode() ? Boolean.valueOf(this.a.getSkipMode()) : null;
            if (bVar.b()) {
                bVar2.a.q = this.a.toString();
            }
            e eVar2 = bVar2.a;
            if (valueOf4 != null) {
                str7 = valueOf4.toString();
            } else {
                str7 = "";
            }
            eVar2.getClass();
            try {
                j = Long.parseLong(str7);
            } catch (NumberFormatException unused) {
                j = 20;
            }
            String str9 = "";
            long j2 = j;
            eVar2.b = j2;
            Integer num2 = valueOf2;
            Boolean bool = valueOf7;
            String str10 = str9;
            eVar2.a = eVar2.c + TimeUnit.MINUTES.toMillis(j2);
            impressionData.setImpressionId(sessionId);
            impressionData.setDemandSource(adNetworkName);
            bVar2.a.d = valueOf != null ? valueOf.toString() : str10;
            bVar2.a.getClass();
            bVar2.a.getClass();
            e eVar3 = bVar2.a;
            eVar3.y = str2;
            eVar3.z = this.d;
            eVar3.A = valueOf6;
            if (valueOf5 != null) {
                impressionData.setDemandId(valueOf5);
            }
            e eVar4 = bVar2.a;
            eVar4.g = a2;
            if (num2 != null) {
                eVar4.e = num2.intValue();
            }
            if (num != null) {
                bVar2.a.f = num.intValue();
            }
            e eVar5 = bVar2.a;
            eVar5.k = str5;
            eVar5.l = str6;
            eVar5.o = str3;
            eVar5.m = bVar2.b;
            try {
                eVar5.n = UnitDisplayType.fromValue(str);
            } catch (IllegalArgumentException unused2) {
                bVar2.a.n = UnitDisplayType.INTERSTITIAL;
            }
            if (!TextUtils.isEmpty(creativeId)) {
                impressionData.setCreativeId(creativeId);
            }
            if (!TextUtils.isEmpty(adDomain)) {
                impressionData.setAdvertiserDomain(adDomain);
            }
            if (!TextUtils.isEmpty(campaignId)) {
                impressionData.setCampaignId(campaignId);
            }
            impressionData.setCountry(com.fyber.inneractive.sdk.util.n.h());
            bVar2.a.r = impressionData;
            if (bool == null) {
                i = -1;
            } else {
                i = bool.booleanValue() ? 1 : 0;
            }
            bVar2.a.w = i;
            String igniteInstallUrl = this.a.hasIgniteInstallUrl() ? this.a.getIgniteInstallUrl() : null;
            if (!TextUtils.isEmpty(igniteInstallUrl)) {
                bVar2.a.E = igniteInstallUrl;
            }
            e eVar6 = bVar2.a;
            k kVar = k.NONE;
            AdmParametersOuterClass$AdmParameters admParametersOuterClass$AdmParameters2 = this.a;
            if (admParametersOuterClass$AdmParameters2 != null) {
                AdmParametersOuterClass$AdmParameters.f igniteMode = admParametersOuterClass$AdmParameters2.hasIgniteMode() ? this.a.getIgniteMode() : null;
                if (igniteMode != null && !igniteMode.equals(AdmParametersOuterClass$AdmParameters.f.NONE)) {
                    kVar = igniteMode.equals(AdmParametersOuterClass$AdmParameters.f.SINGLETAP) ? k.SINGLE_TAP : k.TRUE_SINGLE_TAP;
                }
            }
            eVar6.a(kVar);
            String igniteLauncherActivity = this.a.hasIgniteLauncherActivity() ? this.a.getIgniteLauncherActivity() : null;
            if (!TextUtils.isEmpty(igniteLauncherActivity)) {
                bVar2.a.G = igniteLauncherActivity;
            }
            Boolean valueOf8 = this.a.hasBrandBidderDontShowEndcard() ? Boolean.valueOf(this.a.getBrandBidderDontShowEndcard()) : null;
            if (valueOf8 != null) {
                bVar2.a.C = valueOf8.booleanValue() ? "1" : "0";
            }
            String brandBidderCtaText = this.a.getBrandBidderCtaText();
            if (!TextUtils.isEmpty(brandBidderCtaText)) {
                bVar2.a.D = brandBidderCtaText;
            }
            Boolean valueOf9 = this.a.hasMraidVideoOMSignal() ? Boolean.valueOf(this.a.getMraidVideoOMSignal()) : null;
            if (valueOf9 != null) {
                bVar2.a.H = valueOf9.booleanValue();
            }
        }
    }
}
