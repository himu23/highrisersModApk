package com.applovin.impl.sdk.a;

import android.webkit.WebView;
import com.applovin.impl.sdk.ad.a;
import com.applovin.impl.sdk.x;
import com.iab.omid.library.applovin.adsession.AdSessionConfiguration;
import com.iab.omid.library.applovin.adsession.AdSessionContext;
import com.iab.omid.library.applovin.adsession.CreativeType;
import com.iab.omid.library.applovin.adsession.ImpressionType;
import com.iab.omid.library.applovin.adsession.Owner;

public class c extends b {
    public c(a aVar) {
        super(aVar);
    }

    /* access modifiers changed from: protected */
    public AdSessionContext h(WebView webView) {
        try {
            if (this.aIy.getOpenMeasurementVerificationScriptResources().size() > 0) {
                return AdSessionContext.createNativeAdSessionContext(this.sdk.Cp().getPartner(), this.sdk.Cp().IT(), this.aIy.getOpenMeasurementVerificationScriptResources(), this.aIy.getOpenMeasurementContentUrl(), this.aIy.getOpenMeasurementCustomReferenceData());
            }
            return AdSessionContext.createHtmlAdSessionContext(this.sdk.Cp().getPartner(), webView, this.aIy.getOpenMeasurementContentUrl(), this.aIy.getOpenMeasurementCustomReferenceData());
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
            return AdSessionConfiguration.createAdSessionConfiguration(CreativeType.HTML_DISPLAY, ImpressionType.LOADED, Owner.NATIVE, Owner.NONE, false);
        } catch (Throwable th) {
            x xVar = this.logger;
            if (x.Fn()) {
                this.logger.c(this.tag, "Failed to create ad session configuration", th);
            }
            return null;
        }
    }
}
