package com.applovin.sdk;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.applovin.impl.privacy.a.c;
import com.applovin.impl.privacy.a.d;
import com.applovin.impl.sdk.AppLovinSdkSettingsBase;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.AppLovinSdkExtraParameterKey;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.u;
import com.applovin.impl.sdk.x;
import com.applovin.sdk.AppLovinSdkConfiguration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class AppLovinSdkSettings extends AppLovinSdkSettingsBase {
    private boolean aZr;
    private boolean aZs = true;
    private boolean aZt = true;
    private boolean aZu = true;
    private boolean aZv = true;
    private String aZw;
    private List<String> aZx = Collections.emptyList();
    private List<String> aZy = Collections.emptyList();
    private final Object aZz = new Object();
    private String abm = "";
    private final Map<String, String> extraParameters = new HashMap();
    private boolean it;
    private final Map<String, Object> localSettings = new HashMap();
    private final Map<String, String> metaData = new HashMap();
    private n sdk;

    public interface TermsAndPrivacyPolicyFlowSettings extends TermsFlowSettings {
        AppLovinSdkConfiguration.ConsentFlowUserGeography getDebugUserGeography();

        void setDebugUserGeography(AppLovinSdkConfiguration.ConsentFlowUserGeography consentFlowUserGeography);
    }

    public interface TermsFlowSettings {
        Uri getPrivacyPolicyUri();

        Uri getTermsOfServiceUri();

        boolean isEnabled();

        void setEnabled(boolean z);

        void setPrivacyPolicyUri(Uri uri);

        void setTermsOfServiceUri(Uri uri);
    }

    public List<String> getInitializationAdUnitIds() {
        return this.aZy;
    }

    public List<String> getTestDeviceAdvertisingIds() {
        return this.aZx;
    }

    public boolean isCreativeDebuggerEnabled() {
        return this.aZs;
    }

    public boolean isExceptionHandlerEnabled() {
        return this.aZt;
    }

    public boolean isLocationCollectionEnabled() {
        return this.aZu;
    }

    public boolean isMuted() {
        return this.it;
    }

    public boolean isVerboseLoggingEnabled() {
        return this.aZr;
    }

    public boolean shouldFailAdDisplayIfDontKeepActivitiesIsEnabled() {
        return this.aZv;
    }

    public AppLovinSdkSettings(Context context) {
        if (context == null) {
            x.H("AppLovinSdkSettings", "context cannot be null. Please provide a valid context.");
        }
        Context an = u.an(context);
        this.aZr = u.ae(an);
        this.backingConsentFlowSettings = c.D(an);
        this.abm = an.getPackageName();
        ap(an);
    }

    public TermsAndPrivacyPolicyFlowSettings getTermsAndPrivacyPolicyFlowSettings() {
        ((d) this.backingConsentFlowSettings).a(d.a.UNIFIED);
        return this.backingConsentFlowSettings;
    }

    public void setTestDeviceAdvertisingIds(List<String> list) {
        x.logApiCall("AppLovinSdkSettings", "setTestDeviceAdvertisingIds(testDeviceAdvertisingIds=" + list + ")");
        if (list != null) {
            ArrayList arrayList = new ArrayList(list.size());
            for (String next : list) {
                if (next == null || next.length() != 36) {
                    x.H("AppLovinSdkSettings", "Unable to set test device advertising id (" + next + ") - please make sure it is in the format of xxxxxxxx-xxxx-xxxx-xxxx-xxxxxxxxxxxx");
                } else {
                    arrayList.add(next);
                }
            }
            this.aZx = arrayList;
            return;
        }
        this.aZx = Collections.emptyList();
    }

    public void setInitializationAdUnitIds(List<String> list) {
        x.logApiCall("AppLovinSdkSettings", "setInitializationAdUnitIds(initializationAdUnitIds=" + list + ")");
        if (list != null) {
            ArrayList arrayList = new ArrayList(list.size());
            for (String next : list) {
                if (StringUtils.isValidString(next) && next.length() > 0) {
                    if (next.length() == 16) {
                        arrayList.add(next);
                    } else {
                        x.H("AppLovinSdkSettings", "Unable to set initialization ad unit id (" + next + ") - please make sure it is in the format of XXXXXXXXXXXXXXXX");
                    }
                }
            }
            this.aZy = arrayList;
            return;
        }
        this.aZy = Collections.emptyList();
    }

    public void setVerboseLogging(boolean z) {
        x.logApiCall("AppLovinSdkSettings", "setVerboseLogging(isVerboseLoggingEnabled=" + z + ")");
        if (u.Lw()) {
            x.H("AppLovinSdkSettings", "Ignoring setting of verbose logging - it is configured from Android manifest already.");
            if (u.ae((Context) null) != z) {
                x.H("AppLovinSdkSettings", "Attempted to programmatically set verbose logging flag to value different from value configured in Android Manifest.");
                return;
            }
            return;
        }
        this.aZr = z;
    }

    public void setMuted(boolean z) {
        x.logApiCall("AppLovinSdkSettings", "setMuted(muted=" + z + ")");
        this.it = z;
    }

    public void setCreativeDebuggerEnabled(boolean z) {
        x.logApiCall("AppLovinSdkSettings", "setCreativeDebuggerEnabled(creativeDebuggerEnabled=" + z + ")");
        if (this.aZs != z) {
            this.aZs = z;
            n nVar = this.sdk;
            if (nVar != null) {
                if (z) {
                    nVar.Co().tv();
                } else {
                    nVar.Co().tw();
                }
            }
        }
    }

    public void setExceptionHandlerEnabled(boolean z) {
        x.logApiCall("AppLovinSdkSettings", "setExceptionHandlerEnabled(exceptionHandlerEnabled=" + z + ")");
        this.aZt = z;
    }

    public void setLocationCollectionEnabled(boolean z) {
        x.logApiCall("AppLovinSdkSettings", "setLocationCollectionEnabled(locationCollectionEnabled=" + z + ")");
        this.aZu = z;
    }

    public Map<String, String> getExtraParameters() {
        Map<String, String> map;
        synchronized (this.aZz) {
            map = CollectionUtils.map(this.extraParameters);
        }
        return map;
    }

    public void setExtraParameter(String str, String str2) {
        x.logApiCall("AppLovinSdkSettings", "setExtraParameter(key=" + str + ", value=" + str2 + ")");
        if (TextUtils.isEmpty(str)) {
            x.H("AppLovinSdkSettings", "Failed to set extra parameter for null or empty key: " + str);
            return;
        }
        String trim = str2 != null ? str2.trim() : null;
        if ("test_mode_network".equalsIgnoreCase(str)) {
            if (this.sdk == null) {
                this.aZw = trim;
            } else if (StringUtils.isValidString(trim)) {
                this.sdk.CE().C(Arrays.asList(trim.split(",")));
            } else {
                this.sdk.CE().bT((String) null);
            }
        } else if ((AppLovinSdkExtraParameterKey.FILTER_AD_NETWORK.equals(str) || AppLovinSdkExtraParameterKey.ENABLE_SEQUENTIAL_CACHING.equals(str)) && !this.abm.startsWith("com.unity.")) {
            return;
        }
        synchronized (this.aZz) {
            this.extraParameters.put(str, trim);
        }
    }

    public void setShouldFailAdDisplayIfDontKeepActivitiesIsEnabled(boolean z) {
        x.logApiCall("AppLovinSdkSettings", "setShouldFailAdDisplayIfDontKeepActivitiesIsEnabled(shouldFailAdDisplayIfDontKeepActivitiesIsEnabled=" + z + ")");
        this.aZv = z;
    }

    /* access modifiers changed from: protected */
    public void attachAppLovinSdk(n nVar) {
        this.sdk = nVar;
        if (StringUtils.isValidString(this.aZw)) {
            nVar.CE().C(Arrays.asList(this.aZw.split(",")));
            this.aZw = null;
        }
    }

    private void ap(Context context) {
        int identifier = context.getResources().getIdentifier("applovin_settings", "raw", context.getPackageName());
        if (identifier != 0) {
            String a = u.a(identifier, context, (n) null);
            Map<String, String> tryToStringMap = JsonUtils.tryToStringMap(StringUtils.isValidString(a) ? JsonUtils.jsonObjectFromJsonString(a, new JSONObject()) : new JSONObject());
            synchronized (this.aZz) {
                this.extraParameters.putAll(tryToStringMap);
            }
        }
    }

    @Deprecated
    public TermsFlowSettings getTermsFlowSettings() {
        ((d) this.backingConsentFlowSettings).a(d.a.TERMS);
        return this.backingConsentFlowSettings;
    }

    public String toString() {
        return "AppLovinSdkSettings{isVerboseLoggingEnabled=" + this.aZr + ", muted=" + this.it + ", testDeviceAdvertisingIds=" + this.aZx.toString() + ", initializationAdUnitIds=" + this.aZy.toString() + ", creativeDebuggerEnabled=" + this.aZs + ", exceptionHandlerEnabled=" + this.aZt + ", locationCollectionEnabled=" + this.aZu + '}';
    }
}
