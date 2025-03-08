package com.applovin.sdk;

import android.content.Context;
import com.applovin.impl.mediation.MaxMediatedNetworkInfoImpl;
import com.applovin.impl.mediation.e.c;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.utils.AppLovinSdkExtraParameterKey;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.e;
import com.applovin.impl.sdk.x;
import com.applovin.mediation.MaxMediatedNetworkInfo;
import com.ironsource.m2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class AppLovinSdk {
    private static final String TAG = "AppLovinSdk";
    public static final String VERSION = getVersion();
    public static final int VERSION_CODE = getVersionCode();
    private static final Map<String, AppLovinSdk> sdkInstances = new HashMap(1);
    private static final Object sdkInstancesLock = new Object();
    private final n coreSdk;

    public interface SdkInitializationListener {
        void onSdkInitialized(AppLovinSdkConfiguration appLovinSdkConfiguration);
    }

    private static String getVersion() {
        return "12.1.0";
    }

    private static int getVersionCode() {
        return 12010099;
    }

    public n a() {
        return this.coreSdk;
    }

    public void initializeSdk() {
    }

    public String getSdkKey() {
        return this.coreSdk.getSdkKey();
    }

    public AppLovinSdkSettings getSettings() {
        return this.coreSdk.getSettings();
    }

    public void setPluginVersion(String str) {
        this.coreSdk.setPluginVersion(str);
    }

    public void setUserIdentifier(String str) {
        this.coreSdk.cA(str);
    }

    public String getUserIdentifier() {
        return this.coreSdk.Bz();
    }

    public AppLovinUserSegment getUserSegment() {
        return this.coreSdk.getUserSegment();
    }

    public AppLovinTargetingData getTargetingData() {
        return this.coreSdk.BC();
    }

    public AppLovinAdService getAdService() {
        return this.coreSdk.BD();
    }

    public AppLovinEventService getEventService() {
        return this.coreSdk.BF();
    }

    public AppLovinCmpService getCmpService() {
        return this.coreSdk.Cn();
    }

    public AppLovinUserService getUserService() {
        return this.coreSdk.BG();
    }

    public void setMediationProvider(String str) {
        this.coreSdk.setMediationProvider(str);
    }

    public String getMediationProvider() {
        return this.coreSdk.getMediationProvider();
    }

    public List<MaxMediatedNetworkInfo> getAvailableMediatedNetworks() {
        JSONArray f = c.f(this.coreSdk);
        ArrayList arrayList = new ArrayList(f.length());
        for (int i = 0; i < f.length(); i++) {
            arrayList.add(new MaxMediatedNetworkInfoImpl(JsonUtils.getJSONObject(f, i, (JSONObject) null)));
        }
        return arrayList;
    }

    public void showMediationDebugger() {
        this.coreSdk.showMediationDebugger();
    }

    public void showMediationDebugger(Map<String, List<?>> map) {
        this.coreSdk.showMediationDebugger(map);
    }

    public void showCreativeDebugger() {
        this.coreSdk.showCreativeDebugger();
    }

    public boolean isInitialized() {
        return this.coreSdk.isEnabled();
    }

    public void initializeSdk(SdkInitializationListener sdkInitializationListener) {
        this.coreSdk.initializeSdk(sdkInitializationListener);
    }

    public static void initializeSdk(Context context) {
        initializeSdk(context, (SdkInitializationListener) null);
    }

    public static void initializeSdk(Context context, SdkInitializationListener sdkInitializationListener) {
        if (context != null) {
            AppLovinSdk instance = getInstance(context);
            if (instance != null) {
                instance.initializeSdk(sdkInitializationListener);
            } else {
                x.H(TAG, "Unable to initialize AppLovin SDK: SDK object not created");
            }
        } else {
            throw new IllegalArgumentException("No context specified");
        }
    }

    public AppLovinSdkConfiguration getConfiguration() {
        return this.coreSdk.getConfiguration();
    }

    public static AppLovinSdk getInstance(Context context) {
        return getInstance(new a(context), context);
    }

    public static AppLovinSdk getInstance(AppLovinSdkSettings appLovinSdkSettings, Context context) {
        if (context != null) {
            return getInstance(e.X(context).L("applovin.sdk.key", ""), appLovinSdkSettings, context);
        }
        throw new IllegalArgumentException("No context specified");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0072, code lost:
        return r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.applovin.sdk.AppLovinSdk getInstance(java.lang.String r4, com.applovin.sdk.AppLovinSdkSettings r5, android.content.Context r6) {
        /*
            java.lang.String r0 = "\n**************************************************\nINVALID SDK KEY: "
            if (r5 == 0) goto L_0x007e
            if (r6 == 0) goto L_0x0076
            java.lang.Object r1 = sdkInstancesLock
            monitor-enter(r1)
            java.util.Map<java.lang.String, com.applovin.sdk.AppLovinSdk> r2 = sdkInstances     // Catch:{ all -> 0x0073 }
            boolean r3 = r2.containsKey(r4)     // Catch:{ all -> 0x0073 }
            if (r3 == 0) goto L_0x0018
            java.lang.Object r4 = r2.get(r4)     // Catch:{ all -> 0x0073 }
            com.applovin.sdk.AppLovinSdk r4 = (com.applovin.sdk.AppLovinSdk) r4     // Catch:{ all -> 0x0073 }
            goto L_0x0071
        L_0x0018:
            boolean r3 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x0073 }
            if (r3 != 0) goto L_0x005a
            java.lang.String r3 = java.io.File.separator     // Catch:{ all -> 0x0073 }
            boolean r3 = r4.contains(r3)     // Catch:{ all -> 0x0073 }
            if (r3 == 0) goto L_0x005a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0073 }
            r3.<init>(r0)     // Catch:{ all -> 0x0073 }
            r3.append(r4)     // Catch:{ all -> 0x0073 }
            java.lang.String r0 = "\n**************************************************\n"
            r3.append(r0)     // Catch:{ all -> 0x0073 }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x0073 }
            java.lang.String r3 = "AppLovinSdk"
            com.applovin.impl.sdk.x.H(r3, r0)     // Catch:{ all -> 0x0073 }
            boolean r0 = r2.isEmpty()     // Catch:{ all -> 0x0073 }
            if (r0 != 0) goto L_0x0052
            java.util.Collection r4 = r2.values()     // Catch:{ all -> 0x0073 }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ all -> 0x0073 }
            java.lang.Object r4 = r4.next()     // Catch:{ all -> 0x0073 }
            com.applovin.sdk.AppLovinSdk r4 = (com.applovin.sdk.AppLovinSdk) r4     // Catch:{ all -> 0x0073 }
            monitor-exit(r1)     // Catch:{ all -> 0x0073 }
            return r4
        L_0x0052:
            java.lang.String r0 = java.io.File.separator     // Catch:{ all -> 0x0073 }
            java.lang.String r3 = ""
            java.lang.String r4 = r4.replace(r0, r3)     // Catch:{ all -> 0x0073 }
        L_0x005a:
            com.applovin.impl.sdk.n r0 = new com.applovin.impl.sdk.n     // Catch:{ all -> 0x0073 }
            r0.<init>()     // Catch:{ all -> 0x0073 }
            r0.a((java.lang.String) r4, (com.applovin.sdk.AppLovinSdkSettings) r5, (android.content.Context) r6)     // Catch:{ all -> 0x0073 }
            com.applovin.sdk.AppLovinSdk r6 = new com.applovin.sdk.AppLovinSdk     // Catch:{ all -> 0x0073 }
            r6.<init>(r0)     // Catch:{ all -> 0x0073 }
            r0.a((com.applovin.sdk.AppLovinSdk) r6)     // Catch:{ all -> 0x0073 }
            r5.attachAppLovinSdk(r0)     // Catch:{ all -> 0x0073 }
            r2.put(r4, r6)     // Catch:{ all -> 0x0073 }
            r4 = r6
        L_0x0071:
            monitor-exit(r1)     // Catch:{ all -> 0x0073 }
            return r4
        L_0x0073:
            r4 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0073 }
            throw r4
        L_0x0076:
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
            java.lang.String r5 = "No context specified"
            r4.<init>(r5)
            throw r4
        L_0x007e:
            java.lang.IllegalArgumentException r4 = new java.lang.IllegalArgumentException
            java.lang.String r5 = "No userSettings specified"
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.sdk.AppLovinSdk.getInstance(java.lang.String, com.applovin.sdk.AppLovinSdkSettings, android.content.Context):com.applovin.sdk.AppLovinSdk");
    }

    public boolean isEnabled() {
        return this.coreSdk.isEnabled();
    }

    private AppLovinSdk(n nVar) {
        this.coreSdk = nVar;
    }

    static void reinitializeAll(Boolean bool, Boolean bool2, Boolean bool3) {
        synchronized (sdkInstancesLock) {
            for (AppLovinSdk next : sdkInstances.values()) {
                next.coreSdk.Bm();
                next.coreSdk.Bu();
                if (bool != null) {
                    next.coreSdk.BN();
                    if (x.Fn()) {
                        x BN = next.coreSdk.BN();
                        BN.g(TAG, "Toggled 'huc' to " + bool);
                    }
                    next.getEventService().trackEvent(AppLovinSdkExtraParameterKey.HAS_USER_CONSENT, CollectionUtils.map(m2.h.X, bool.toString()));
                }
                if (bool2 != null) {
                    next.coreSdk.BN();
                    if (x.Fn()) {
                        x BN2 = next.coreSdk.BN();
                        BN2.g(TAG, "Toggled 'aru' to " + bool2);
                    }
                    next.getEventService().trackEvent(AppLovinSdkExtraParameterKey.AGE_RESTRICTED_USER, CollectionUtils.map(m2.h.X, bool2.toString()));
                }
                if (bool3 != null) {
                    next.coreSdk.BN();
                    if (x.Fn()) {
                        x BN3 = next.coreSdk.BN();
                        BN3.g(TAG, "Toggled 'dns' to " + bool3);
                    }
                    next.getEventService().trackEvent(AppLovinSdkExtraParameterKey.DO_NOT_SELL, CollectionUtils.map(m2.h.X, bool3.toString()));
                }
            }
        }
    }

    private static class a extends AppLovinSdkSettings {
        a(Context context) {
            super(context);
        }
    }

    public String toString() {
        return "AppLovinSdk{sdkKey='" + getSdkKey() + "', isEnabled=" + isEnabled() + ", isFirstSession=" + this.coreSdk.CK() + '}';
    }

    @Deprecated
    public AppLovinPostbackService getPostbackService() {
        return this.coreSdk.Ct();
    }
}
