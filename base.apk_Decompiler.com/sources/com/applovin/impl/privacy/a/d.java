package com.applovin.impl.privacy.a;

import android.net.Uri;
import com.applovin.impl.sdk.x;
import com.applovin.sdk.AppLovinSdkConfiguration;
import com.applovin.sdk.AppLovinSdkSettings;

public class d implements AppLovinSdkSettings.TermsAndPrivacyPolicyFlowSettings {
    private boolean axN;
    private a axO;
    private Uri axP;
    private Uri axQ;
    private AppLovinSdkConfiguration.ConsentFlowUserGeography axr;

    public void a(a aVar) {
        this.axO = aVar;
    }

    public AppLovinSdkConfiguration.ConsentFlowUserGeography getDebugUserGeography() {
        return this.axr;
    }

    public Uri getPrivacyPolicyUri() {
        return this.axP;
    }

    public Uri getTermsOfServiceUri() {
        return this.axQ;
    }

    public boolean isEnabled() {
        return this.axN;
    }

    public a zX() {
        return this.axO;
    }

    public enum a {
        TERMS("default"),
        UNIFIED("unified");
        
        private final String awi;

        public String getType() {
            return this.awi;
        }

        private a(String str) {
            this.awi = str;
        }
    }

    public d(boolean z, AppLovinSdkConfiguration.ConsentFlowUserGeography consentFlowUserGeography, a aVar, Uri uri, Uri uri2) {
        this.axN = z;
        this.axr = consentFlowUserGeography;
        this.axO = aVar;
        this.axP = uri;
        this.axQ = uri2;
        if (z) {
            x.D("ConsentFlowSettings", "Creating with initial values: isEnabled=" + z + ",\n\tprivacyPolicyUri=" + uri + ",\n\ttermsOfServiceUri=" + uri2);
        }
    }

    public void setEnabled(boolean z) {
        x.D("ConsentFlowSettingsImpl", "Setting consent flow enabled: " + z);
        this.axN = z;
    }

    public void setDebugUserGeography(AppLovinSdkConfiguration.ConsentFlowUserGeography consentFlowUserGeography) {
        x.D("ConsentFlowSettingsImpl", "Setting user debug geography: " + consentFlowUserGeography);
        this.axr = consentFlowUserGeography;
    }

    public void setPrivacyPolicyUri(Uri uri) {
        x.D("ConsentFlowSettingsImpl", "Setting privacy policy: " + uri);
        this.axP = uri;
    }

    public void setTermsOfServiceUri(Uri uri) {
        x.D("ConsentFlowSettingsImpl", "Setting terms of service: " + uri);
        this.axQ = uri;
    }

    public String toString() {
        return "ConsentFlowSettings{isEnabled=" + this.axN + ", privacyPolicyUri=" + this.axP + ", termsOfServiceUri=" + this.axQ + '}';
    }
}
