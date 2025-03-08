package com.applovin.impl.privacy.cmp;

import android.app.Activity;
import android.os.Bundle;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.AppLovinSdkExtraParameterKey;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.u;
import com.applovin.impl.sdk.x;
import com.applovin.sdk.AppLovinCmpError;
import com.applovin.sdk.AppLovinSdkConfiguration;
import com.google.android.ump.ConsentDebugSettings;
import com.google.android.ump.ConsentForm;
import com.google.android.ump.ConsentInformation;
import com.google.android.ump.ConsentRequestParameters;
import com.google.android.ump.FormError;
import com.google.android.ump.UserMessagingPlatform;

public class b {
    /* access modifiers changed from: private */
    public ConsentForm axE;
    private final x logger;
    private final n sdk;

    public interface a {
        void onFlowHidden(Bundle bundle);

        void onFlowLoadFailed(CmpErrorImpl cmpErrorImpl);

        void onFlowLoaded(Bundle bundle);

        void onFlowShowFailed(CmpErrorImpl cmpErrorImpl);
    }

    public void destroy() {
        if (this.axE != null) {
            this.axE = null;
        }
    }

    public String getSdkVersion() {
        return null;
    }

    public boolean zU() {
        return true;
    }

    public boolean zV() {
        return true;
    }

    public b(n nVar) {
        this.sdk = nVar;
        this.logger = nVar.BN();
        ConsentInformation consentInformation = UserMessagingPlatform.getConsentInformation(n.getApplicationContext());
        d("Initializing with SDK Version: " + getSdkVersion() + ", consentStatus: " + consentInformation.getConsentStatus() + ", consentFormAvailable: " + consentInformation.isConsentFormAvailable());
    }

    public void a(final Activity activity, a aVar, final a aVar2) {
        ConsentRequestParameters.Builder builder = new ConsentRequestParameters.Builder();
        if (u.b(n.getApplicationContext(), this.sdk) && aVar.getDebugUserGeography() == AppLovinSdkConfiguration.ConsentFlowUserGeography.GDPR) {
            UserMessagingPlatform.getConsentInformation(activity).reset();
            builder.setConsentDebugSettings(new ConsentDebugSettings.Builder(activity).setForceTesting(true).setDebugGeography(1).addTestDeviceHashedId(StringUtils.emptyIfNull(this.sdk.getSettings().getExtraParameters().get(AppLovinSdkExtraParameterKey.GOOGLE_TEST_DEVICE_HASHED_ID))).build());
        }
        UserMessagingPlatform.getConsentInformation(activity).requestConsentInfoUpdate(activity, builder.build(), new ConsentInformation.OnConsentInfoUpdateSuccessListener() {
            public void onConsentInfoUpdateSuccess() {
                ConsentInformation consentInformation = UserMessagingPlatform.getConsentInformation(activity);
                boolean isConsentFormAvailable = consentInformation.isConsentFormAvailable();
                int consentStatus = consentInformation.getConsentStatus();
                b bVar = b.this;
                bVar.d("Loaded parameters consentStatus: " + consentStatus + ", consentFormAvailable: " + isConsentFormAvailable);
                if (!isConsentFormAvailable) {
                    b.this.e("Failed to load form.");
                    aVar2.onFlowLoadFailed(new CmpErrorImpl(AppLovinCmpError.Code.FORM_UNAVAILABLE, "Consent form unavailable"));
                } else if (consentStatus != 2) {
                    b bVar2 = b.this;
                    bVar2.e("Failed to load with consent status: " + consentStatus);
                    a aVar = aVar2;
                    AppLovinCmpError.Code code = AppLovinCmpError.Code.FORM_NOT_REQUIRED;
                    aVar.onFlowLoadFailed(new CmpErrorImpl(code, "Consent form not required for consent status: " + consentStatus));
                } else {
                    b.this.d("Successfully requested consent info");
                    b.this.d("Loading consent form...");
                    UserMessagingPlatform.loadConsentForm(activity, new UserMessagingPlatform.OnConsentFormLoadSuccessListener() {
                        public void onConsentFormLoadSuccess(ConsentForm consentForm) {
                            b.this.d("Successfully loaded consent form");
                            ConsentForm unused = b.this.axE = consentForm;
                            aVar2.onFlowLoaded((Bundle) null);
                        }
                    }, new UserMessagingPlatform.OnConsentFormLoadFailureListener() {
                        public void onConsentFormLoadFailure(FormError formError) {
                            b bVar = b.this;
                            bVar.e("Failed to load with error: " + formError);
                            aVar2.onFlowLoadFailed(b.this.a(formError, "Consent form load failed"));
                        }
                    });
                }
            }
        }, new ConsentInformation.OnConsentInfoUpdateFailureListener() {
            public void onConsentInfoUpdateFailure(FormError formError) {
                b bVar = b.this;
                bVar.e("Failed to request consent info with error: " + formError);
                aVar2.onFlowLoadFailed(b.this.a(formError, "Consent info update failed"));
            }
        });
    }

    public void b(Activity activity, a aVar, final a aVar2) {
        if (this.axE == null) {
            e("Failed to show - not ready yet");
            aVar2.onFlowShowFailed(new CmpErrorImpl(AppLovinCmpError.Code.FORM_UNAVAILABLE, "Consent form not ready"));
            return;
        }
        d("Showing consent form...");
        this.axE.show(activity, new ConsentForm.OnConsentFormDismissedListener() {
            public void onConsentFormDismissed(FormError formError) {
                if (formError != null) {
                    b bVar = b.this;
                    bVar.e("Failed to show with error: " + formError);
                    aVar2.onFlowShowFailed(b.this.a(formError, "Consent form show failed"));
                    return;
                }
                b.this.d("Consent form finished showing");
                aVar2.onFlowHidden((Bundle) null);
            }
        });
    }

    public void zS() {
        d("Resetting consent information");
        UserMessagingPlatform.getConsentInformation(n.getApplicationContext()).reset();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0010, code lost:
        if (r1 != 4) goto L_0x0018;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.applovin.impl.privacy.cmp.CmpErrorImpl a(com.google.android.ump.FormError r4, java.lang.String r5) {
        /*
            r3 = this;
            com.applovin.sdk.AppLovinCmpError$Code r0 = com.applovin.sdk.AppLovinCmpError.Code.UNSPECIFIED
            int r1 = r4.getErrorCode()
            r2 = 1
            if (r1 == r2) goto L_0x0016
            r2 = 2
            if (r1 == r2) goto L_0x0016
            r2 = 3
            if (r1 == r2) goto L_0x0013
            r2 = 4
            if (r1 == r2) goto L_0x0016
            goto L_0x0018
        L_0x0013:
            com.applovin.sdk.AppLovinCmpError$Code r0 = com.applovin.sdk.AppLovinCmpError.Code.INTEGRATION_ERROR
            goto L_0x0018
        L_0x0016:
            com.applovin.sdk.AppLovinCmpError$Code r0 = com.applovin.sdk.AppLovinCmpError.Code.FORM_UNAVAILABLE
        L_0x0018:
            com.applovin.impl.privacy.cmp.CmpErrorImpl r1 = new com.applovin.impl.privacy.cmp.CmpErrorImpl
            int r2 = r4.getErrorCode()
            java.lang.String r4 = r4.getMessage()
            r1.<init>(r0, r5, r2, r4)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.privacy.cmp.b.a(com.google.android.ump.FormError, java.lang.String):com.applovin.impl.privacy.cmp.CmpErrorImpl");
    }

    /* access modifiers changed from: private */
    public void d(String str) {
        if (x.Fn()) {
            this.logger.f("GoogleCmpAdapter", str);
        }
    }

    /* access modifiers changed from: private */
    public void e(String str) {
        if (x.Fn()) {
            this.logger.i("GoogleCmpAdapter", str);
        }
    }
}
