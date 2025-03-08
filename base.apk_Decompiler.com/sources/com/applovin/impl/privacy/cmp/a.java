package com.applovin.impl.privacy.cmp;

import com.applovin.sdk.AppLovinSdkConfiguration;

public class a {
    private final AppLovinSdkConfiguration.ConsentFlowUserGeography axr;

    public AppLovinSdkConfiguration.ConsentFlowUserGeography getDebugUserGeography() {
        return this.axr;
    }

    /* access modifiers changed from: protected */
    public boolean canEqual(Object obj) {
        return obj instanceof a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (!aVar.canEqual(this)) {
            return false;
        }
        AppLovinSdkConfiguration.ConsentFlowUserGeography debugUserGeography = getDebugUserGeography();
        AppLovinSdkConfiguration.ConsentFlowUserGeography debugUserGeography2 = aVar.getDebugUserGeography();
        return debugUserGeography != null ? debugUserGeography.equals(debugUserGeography2) : debugUserGeography2 == null;
    }

    public int hashCode() {
        AppLovinSdkConfiguration.ConsentFlowUserGeography debugUserGeography = getDebugUserGeography();
        return 59 + (debugUserGeography == null ? 43 : debugUserGeography.hashCode());
    }

    public String toString() {
        return "CmpAdapterParameters(debugUserGeography=" + getDebugUserGeography() + ")";
    }

    public a(AppLovinSdkConfiguration.ConsentFlowUserGeography consentFlowUserGeography) {
        this.axr = consentFlowUserGeography;
    }
}
