package com.applovin.impl.sdk.a;

import android.webkit.WebView;
import com.applovin.impl.sdk.nativeAd.AppLovinNativeAdImpl;
import com.applovin.impl.sdk.x;
import com.iab.omid.library.applovin.adsession.AdSessionConfiguration;
import com.iab.omid.library.applovin.adsession.AdSessionContext;
import com.iab.omid.library.applovin.adsession.CreativeType;
import com.iab.omid.library.applovin.adsession.ImpressionType;
import com.iab.omid.library.applovin.adsession.Owner;

public class e extends b {
    public e(AppLovinNativeAdImpl appLovinNativeAdImpl) {
        super(appLovinNativeAdImpl);
    }

    /* access modifiers changed from: protected */
    public AdSessionContext h(WebView webView) {
        try {
            return AdSessionContext.createNativeAdSessionContext(this.sdk.Cp().getPartner(), this.sdk.Cp().IT(), this.aIy.getOpenMeasurementVerificationScriptResources(), this.aIy.getOpenMeasurementContentUrl(), this.aIy.getOpenMeasurementCustomReferenceData());
        } catch (Throwable th) {
            x xVar = this.logger;
            if (x.Fn()) {
                this.logger.c(this.tag, "Failed to create ad session context", th);
            }
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public AdSessionConfiguration II() {
        try {
            return AdSessionConfiguration.createAdSessionConfiguration(CreativeType.NATIVE_DISPLAY, ImpressionType.BEGIN_TO_RENDER, Owner.NATIVE, Owner.NONE, false);
        } catch (Throwable th) {
            x xVar = this.logger;
            if (x.Fn()) {
                this.logger.c(this.tag, "Failed to create ad session configuration", th);
            }
            return null;
        }
    }
}
