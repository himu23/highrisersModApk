package com.applovin.impl.privacy.a;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import com.applovin.communicator.AppLovinCommunicator;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorPublisher;
import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.applovin.impl.privacy.a.d;
import com.applovin.impl.sdk.c.b;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.s;
import com.applovin.impl.sdk.utils.u;
import com.applovin.impl.sdk.x;
import com.applovin.sdk.AppLovinSdkConfiguration;
import com.applovin.sdk.AppLovinSdkUtils;
import com.fyber.inneractive.sdk.external.InneractiveMediationNameConsts;
import com.ironsource.z3;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class c implements AppLovinCommunicatorPublisher, AppLovinCommunicatorSubscriber {
    private final i axK;
    private List<e> axL;
    private final n sdk;

    public interface a {
        void onFlowCompleted(a aVar);
    }

    public String getCommunicatorId() {
        return "consent_flow_manager";
    }

    public c(n nVar) {
        this.sdk = nVar;
        this.axK = new i(nVar);
    }

    public d zW() {
        return (d) this.sdk.Ck();
    }

    public boolean isEnabled() {
        Map<String, String> extraParameters = this.sdk.getSettings().getExtraParameters();
        if (extraParameters.containsKey("consent_flow_enabled")) {
            return Boolean.parseBoolean(extraParameters.get("consent_flow_enabled"));
        }
        return zW().isEnabled();
    }

    public d.a zX() {
        return zW().zX();
    }

    public Uri getPrivacyPolicyUri() {
        return zW().getPrivacyPolicyUri();
    }

    public Uri getTermsOfServiceUri() {
        return zW().getTermsOfServiceUri();
    }

    public AppLovinSdkConfiguration.ConsentFlowUserGeography getDebugUserGeography() {
        return zW().getDebugUserGeography();
    }

    private static d.a A(JSONObject jSONObject) {
        return jSONObject.has("consent_flow_settings") ? d.a.UNIFIED : d.a.TERMS;
    }

    public static d D(Context context) {
        if (context == null) {
            x.H("AppLovinSdk", "Failed to get default terms flow settings.");
            return new d(false, AppLovinSdkConfiguration.ConsentFlowUserGeography.UNKNOWN, d.a.TERMS, (Uri) null, (Uri) null);
        }
        String a2 = u.a(context.getResources().getIdentifier("applovin_settings", "raw", context.getPackageName()), context, (n) null);
        JSONObject jsonObjectFromJsonString = StringUtils.isValidString(a2) ? JsonUtils.jsonObjectFromJsonString(a2, new JSONObject()) : new JSONObject();
        d.a A = A(jsonObjectFromJsonString);
        int i = AnonymousClass1.axM[A.ordinal()];
        if (i == 1) {
            return B(JsonUtils.getJSONObject(jsonObjectFromJsonString, "consent_flow_settings", new JSONObject()));
        }
        if (i == 2) {
            return C(JsonUtils.getJSONObject(jsonObjectFromJsonString, "terms_flow_settings", new JSONObject()));
        }
        throw new IllegalStateException("Unknown consent flow type: " + A);
    }

    /* renamed from: com.applovin.impl.privacy.a.c$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] axM;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.applovin.impl.privacy.a.d$a[] r0 = com.applovin.impl.privacy.a.d.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                axM = r0
                com.applovin.impl.privacy.a.d$a r1 = com.applovin.impl.privacy.a.d.a.UNIFIED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = axM     // Catch:{ NoSuchFieldError -> 0x001d }
                com.applovin.impl.privacy.a.d$a r1 = com.applovin.impl.privacy.a.d.a.TERMS     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.privacy.a.c.AnonymousClass1.<clinit>():void");
        }
    }

    public static d B(JSONObject jSONObject) {
        Boolean bool = JsonUtils.getBoolean(jSONObject, "consent_flow_enabled", false);
        String string = JsonUtils.getString(jSONObject, "consent_flow_debug_user_geography", "");
        Uri uri = null;
        String string2 = JsonUtils.getString(jSONObject, "consent_flow_terms_of_service", (String) null);
        Uri parse = StringUtils.isValidString(string2) ? Uri.parse(string2) : null;
        String string3 = JsonUtils.getString(jSONObject, "consent_flow_privacy_policy", (String) null);
        if (StringUtils.isValidString(string3)) {
            uri = Uri.parse(string3);
        }
        return new d(bool.booleanValue(), ci(string), d.a.UNIFIED, uri, parse);
    }

    public static d C(JSONObject jSONObject) {
        Boolean bool = JsonUtils.getBoolean(jSONObject, "terms_flow_enabled", false);
        Uri uri = null;
        String string = JsonUtils.getString(jSONObject, "terms_flow_terms_of_service", (String) null);
        Uri parse = StringUtils.isValidString(string) ? Uri.parse(string) : null;
        String string2 = JsonUtils.getString(jSONObject, "terms_flow_privacy_policy", (String) null);
        if (StringUtils.isValidString(string2)) {
            uri = Uri.parse(string2);
        }
        return new d(bool.booleanValue(), AppLovinSdkConfiguration.ConsentFlowUserGeography.UNKNOWN, d.a.TERMS, uri, parse);
    }

    private static AppLovinSdkConfiguration.ConsentFlowUserGeography ci(String str) {
        if ("gdpr".equalsIgnoreCase(str)) {
            return AppLovinSdkConfiguration.ConsentFlowUserGeography.GDPR;
        }
        if (InneractiveMediationNameConsts.OTHER.equalsIgnoreCase(str)) {
            return AppLovinSdkConfiguration.ConsentFlowUserGeography.OTHER;
        }
        return AppLovinSdkConfiguration.ConsentFlowUserGeography.UNKNOWN;
    }

    public void a(Activity activity, a aVar) {
        if (!isEnabled()) {
            aVar.onFlowCompleted(new a(a.axI, "Failed to start consent flow. Please make sure that the consent flow is enabled."));
            return;
        }
        List<e> list = this.axL;
        if (list == null || list.size() == 0) {
            this.sdk.a(com.applovin.impl.sdk.c.d.aRt, false);
            aVar.onFlowCompleted(new a(a.ERROR_CODE_UNSPECIFIED, "User may not be eligible for flow."));
            return;
        }
        a(activity, (Runnable) new c$$ExternalSyntheticLambda3(this, activity, aVar));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(Activity activity, a aVar) {
        this.sdk.BN();
        if (x.Fn()) {
            x BN = this.sdk.BN();
            BN.f("ConsentFlowManager", "Starting consent flow with states: " + this.axL);
        }
        if (!this.sdk.BL()) {
            this.sdk.a(com.applovin.impl.sdk.c.d.aRt, true);
        }
        this.axK.a(this.axL, activity, (a) new c$$ExternalSyntheticLambda4(this, aVar));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(a aVar, a aVar2) {
        if (aVar2 == null) {
            this.sdk.a(com.applovin.impl.sdk.c.d.aRt, false);
            this.axL = null;
        }
        aVar.onFlowCompleted(aVar2);
    }

    private void a(Activity activity, Runnable runnable) {
        if (zW().getPrivacyPolicyUri() != null) {
            runnable.run();
        } else {
            AppLovinSdkUtils.runOnUiThread(new c$$ExternalSyntheticLambda0(this, activity));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void g(Activity activity) {
        Uri zZ = zZ();
        new AlertDialog.Builder(activity).setTitle("Missing Privacy Policy URL").setMessage("You cannot use the AppLovin SDK's consent flow without defining a Privacy Policy URL").setNeutralButton("Go To Documentation", new c$$ExternalSyntheticLambda1(this, zZ)).setNegativeButton("DISMISS", new c$$ExternalSyntheticLambda2(zZ)).create().show();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(Uri uri, DialogInterface dialogInterface, int i) {
        s.a(uri, n.getApplicationContext(), this.sdk);
        throw new IllegalStateException("You cannot use the AppLovin SDK's consent flow without defining a Privacy Policy URL Please refer to " + uri.toString());
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(Uri uri, DialogInterface dialogInterface, int i) {
        throw new IllegalStateException("You cannot use the AppLovin SDK's consent flow without defining a Privacy Policy URL Please refer to " + uri.toString());
    }

    public boolean zY() {
        n nVar = n.aAC;
        if (!nVar.Br()) {
            return false;
        }
        c Cl = nVar.Cl();
        List<e> list = Cl.axL;
        if (Cl.axK.zY() || (list != null && list.size() > 0)) {
            return true;
        }
        return false;
    }

    private Uri zZ() {
        return Uri.parse((String) this.sdk.a(this.sdk.Bs() ? b.aQW : b.aQV));
    }

    public void Aa() {
        if (!this.sdk.Bq() && isEnabled()) {
            if (zW().zX() == d.a.UNIFIED) {
                this.sdk.BN();
                if (x.Fn()) {
                    this.sdk.BN().f("AppLovinSdk", "Generating Unified Consent Flow...");
                }
                this.axL = b.h(this.sdk);
            } else {
                this.sdk.BN();
                if (x.Fn()) {
                    this.sdk.BN().f("AppLovinSdk", "Generating Terms Flow...");
                }
                this.axL = b.i(this.sdk);
            }
        }
        if (u.aj(n.getApplicationContext())) {
            AppLovinCommunicator.getInstance(n.getApplicationContext()).subscribe((AppLovinCommunicatorSubscriber) this, "start_sdk_consent_flow");
        }
    }

    public void onMessageReceived(AppLovinCommunicatorMessage appLovinCommunicatorMessage) {
        if (getTermsOfServiceUri() == null || !appLovinCommunicatorMessage.getMessageData().getBoolean("include_tos")) {
            this.axL = j.k(this.sdk);
        } else {
            this.axL = j.l(this.sdk);
        }
        if (this.axL.size() == 0) {
            u.a("No Consent Flow Available", (String) null, (Context) this.sdk.CF());
        } else {
            a(this.sdk.CF(), (a) new c$$ExternalSyntheticLambda5(this));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(a aVar) {
        AppLovinCommunicator.getInstance(n.getApplicationContext()).getMessagingService().publish(new AppLovinCommunicatorMessage(new Bundle(), "sdk_consent_flow_finished", this));
    }

    public JSONObject Ab() {
        d zW = zW();
        Uri privacyPolicyUri = zW.getPrivacyPolicyUri();
        Uri termsOfServiceUri = zW.getTermsOfServiceUri();
        JSONObject jSONObject = new JSONObject();
        JsonUtils.putString(jSONObject, z3.r, String.valueOf(isEnabled()));
        String str = "";
        JsonUtils.putString(jSONObject, "privacy_policy_url", privacyPolicyUri != null ? privacyPolicyUri.toString() : str);
        if (termsOfServiceUri != null) {
            str = termsOfServiceUri.toString();
        }
        JsonUtils.putString(jSONObject, "terms_of_service_url", str);
        return jSONObject;
    }

    public String uI() {
        zW();
        Uri privacyPolicyUri = getPrivacyPolicyUri();
        Uri termsOfServiceUri = getTermsOfServiceUri();
        StringBuilder sb = new StringBuilder("\nConsent Flow Enabled - ");
        sb.append(isEnabled());
        sb.append("\nPrivacy Policy - ");
        if (privacyPolicyUri == null) {
            privacyPolicyUri = "undefined";
        }
        sb.append(privacyPolicyUri);
        sb.append("\nTerms of Service - ");
        if (termsOfServiceUri == null) {
            termsOfServiceUri = "undefined";
        }
        sb.append(termsOfServiceUri);
        return sb.toString();
    }
}
