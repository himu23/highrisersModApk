package com.fyber.inneractive.sdk.external;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.fyber.inneractive.sdk.cache.session.d;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.a0;
import com.fyber.inneractive.sdk.config.d;
import com.fyber.inneractive.sdk.config.f;
import com.fyber.inneractive.sdk.config.f0;
import com.fyber.inneractive.sdk.config.global.r;
import com.fyber.inneractive.sdk.config.i;
import com.fyber.inneractive.sdk.config.j;
import com.fyber.inneractive.sdk.config.k;
import com.fyber.inneractive.sdk.config.l;
import com.fyber.inneractive.sdk.config.m;
import com.fyber.inneractive.sdk.config.o;
import com.fyber.inneractive.sdk.config.u;
import com.fyber.inneractive.sdk.dv.c;
import com.fyber.inneractive.sdk.external.OnFyberMarketplaceInitializedListener;
import com.fyber.inneractive.sdk.factories.b;
import com.fyber.inneractive.sdk.logger.FMPLogger;
import com.fyber.inneractive.sdk.mraid.IAMraidKit;
import com.fyber.inneractive.sdk.network.g0;
import com.fyber.inneractive.sdk.network.q;
import com.fyber.inneractive.sdk.network.s;
import com.fyber.inneractive.sdk.response.e;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.b1;
import com.fyber.inneractive.sdk.util.n0;
import com.fyber.inneractive.sdk.util.p;
import com.fyber.inneractive.sdk.util.t;
import com.fyber.inneractive.sdk.util.y;
import com.fyber.inneractive.sdk.util.y0;
import com.fyber.inneractive.sdk.util.z;
import com.fyber.inneractive.sdk.util.z0;
import com.fyber.inneractive.sdk.video.IAVideoKit;
import com.fyber.inneractive.sdk.web.x;
import com.ironsource.m2;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

public final class InneractiveAdManager implements j.b {
    public static final String GLOBAL_CONFIG_PARAM_FIRST_INIT_EVENT = "sdk_first_init";
    public static IAConfigManager.OnConfigurationReadyAndValidListener d;
    public volatile Context a;
    public String b;
    public boolean c = false;

    public enum GdprConsentSource {
        Internal,
        External
    }

    public class a implements IAConfigManager.OnConfigurationReadyAndValidListener {
        public final /* synthetic */ Context a;
        public final /* synthetic */ OnFyberMarketplaceInitializedListener b;

        public a(Context context, OnFyberMarketplaceInitializedListener onFyberMarketplaceInitializedListener) {
            this.a = context;
            this.b = onFyberMarketplaceInitializedListener;
        }

        public void onConfigurationReadyAndValid(IAConfigManager iAConfigManager, boolean z, Exception exc) {
            OnFyberMarketplaceInitializedListener.FyberInitStatus fyberInitStatus;
            if (this.a.getApplicationContext() != null) {
                IAConfigManager.removeListener(this);
                InneractiveAdManager.d = null;
                if (z) {
                    InneractiveAdManager.a(this.b, OnFyberMarketplaceInitializedListener.FyberInitStatus.SUCCESSFULLY, (String) null);
                    return;
                }
                OnFyberMarketplaceInitializedListener onFyberMarketplaceInitializedListener = this.b;
                if (exc instanceof InvalidAppIdException) {
                    fyberInitStatus = OnFyberMarketplaceInitializedListener.FyberInitStatus.INVALID_APP_ID;
                } else {
                    fyberInitStatus = OnFyberMarketplaceInitializedListener.FyberInitStatus.FAILED;
                }
                InneractiveAdManager.a(onFyberMarketplaceInitializedListener, fyberInitStatus, exc.getLocalizedMessage());
            }
        }
    }

    public static class b {
        public static volatile InneractiveAdManager a = new InneractiveAdManager();
    }

    public static void a(OnFyberMarketplaceInitializedListener onFyberMarketplaceInitializedListener, OnFyberMarketplaceInitializedListener.FyberInitStatus fyberInitStatus, String str) {
        if (onFyberMarketplaceInitializedListener != null) {
            onFyberMarketplaceInitializedListener.onFyberMarketplaceInitialized(fyberInitStatus);
        }
        if (b.a.a != null && fyberInitStatus != OnFyberMarketplaceInitializedListener.FyberInitStatus.SUCCESSFULLY) {
            s.a aVar = new s.a(q.FMP_SDK_INIT_FAILED, (InneractiveAdRequest) null, (e) null, (JSONArray) null);
            if (!TextUtils.isEmpty(str)) {
                aVar.a("message", str);
            }
            aVar.a("init_status", fyberInitStatus.name());
            aVar.a((String) null);
        }
    }

    @Deprecated
    public static boolean areNativeAdsSupportedForOS() {
        return true;
    }

    public static void clearGdprConsentData() {
        d dVar = IAConfigManager.M.D;
        if (dVar != null) {
            dVar.getClass();
            IAlog.a("Clearing GDPR Consent String and status", new Object[0]);
            if (p.a == null) {
                IAlog.e("ClearGdprConsent was invoked, but the Inneractive SDK was not properly initialized, or destroyed.", new Object[0]);
                return;
            }
            dVar.b();
            dVar.a = null;
            dVar.b = null;
            SharedPreferences sharedPreferences = dVar.h;
            if (sharedPreferences != null) {
                sharedPreferences.edit().remove("IAGdprConsentData").remove("IAGDPRBool").remove("IAGdprSource").apply();
                return;
            }
            return;
        }
        IAlog.e("clearGdprConsentData() was invoked, but Fyber SDK was not properly initialized", new Object[0]);
    }

    public static void clearImpressionDataListener() {
        IAConfigManager.M.A.a = null;
    }

    public static void clearLgpdConsentData() {
        d dVar = IAConfigManager.M.D;
        if (dVar != null) {
            dVar.getClass();
            IAlog.a("Clearing LGPD consent status", new Object[0]);
            if (p.a == null) {
                IAlog.e("clearLgpdConsentStatus was invoked, but the Inneractive SDK was not properly initialized, or destroyed.", new Object[0]);
                return;
            }
            dVar.b();
            dVar.f = null;
            SharedPreferences sharedPreferences = dVar.h;
            if (sharedPreferences != null) {
                sharedPreferences.edit().remove("IALgpdConsentStatus").apply();
                return;
            }
            return;
        }
        IAlog.e("clearLgpdConsentData was invoked, but Fyber SDK was not properly initialized", new Object[0]);
    }

    public static void clearUSPrivacyString() {
        d dVar = IAConfigManager.M.D;
        if (dVar != null) {
            dVar.getClass();
            IAlog.a("Clearing CCPA Consent String", new Object[0]);
            if (p.a == null) {
                IAlog.e("clearUSPrivacyString was invoked, but the Inneractive SDK was not properly initialized, or destroyed.", new Object[0]);
                return;
            }
            dVar.b();
            dVar.e = null;
            SharedPreferences sharedPreferences = dVar.h;
            if (sharedPreferences != null) {
                sharedPreferences.edit().remove("IACCPAConsentData").apply();
            }
        }
    }

    public static void currentAudienceAppliesToCoppa() {
        d dVar = IAConfigManager.M.D;
        if (dVar != null) {
            dVar.getClass();
            if (p.a == null) {
                IAlog.e("setCurrentAudienceAppliesToCoppa was invoked, but the Inneractive SDK was not properly initialized, or destroyed.", new Object[0]);
            } else {
                dVar.g = Boolean.TRUE;
            }
        } else {
            IAlog.e("currentAudienceAppliesToCoppa was invoked, but Fyber SDK was not properly initialized", new Object[0]);
        }
    }

    public static void currentAudienceIsAChild() {
        b.a.c = true;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:17|18|19|20|21) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x0088 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void destroy() {
        /*
            r0 = 0
            java.lang.Object[] r1 = new java.lang.Object[r0]
            java.lang.String r2 = "InneractiveAdManager:destroy called"
            com.fyber.inneractive.sdk.util.IAlog.a(r2, r1)
            com.fyber.inneractive.sdk.external.InneractiveAdManager r1 = com.fyber.inneractive.sdk.external.InneractiveAdManager.b.a
            android.content.Context r1 = r1.a
            if (r1 != 0) goto L_0x0016
            java.lang.Object[] r0 = new java.lang.Object[r0]
            java.lang.String r1 = "InneractiveAdManager:destroy called, but manager is not initialized"
            com.fyber.inneractive.sdk.util.IAlog.a(r1, r0)
            return
        L_0x0016:
            com.fyber.inneractive.sdk.external.InneractiveAdManager r1 = com.fyber.inneractive.sdk.external.InneractiveAdManager.b.a
            r2 = 0
            r1.a = r2
            com.fyber.inneractive.sdk.config.IAConfigManager$OnConfigurationReadyAndValidListener r1 = d
            com.fyber.inneractive.sdk.config.IAConfigManager.removeListener(r1)
            d = r2
            com.fyber.inneractive.sdk.config.IAConfigManager r1 = com.fyber.inneractive.sdk.config.IAConfigManager.M
            com.fyber.inneractive.sdk.util.j0 r3 = r1.A
            r3.a = r2
            r1.h = r0
            com.fyber.inneractive.sdk.util.d0 r1 = com.fyber.inneractive.sdk.util.d0.d.a
            java.util.WeakHashMap<android.content.Context, java.util.WeakHashMap<android.view.View, com.fyber.inneractive.sdk.util.d0$e>> r3 = r1.b
            r3.clear()
            java.util.Map<android.content.Context, android.util.Pair<android.view.ViewTreeObserver, android.view.ViewTreeObserver$OnPreDrawListener>> r3 = r1.a
            java.util.Set r3 = r3.keySet()
            java.util.Iterator r3 = r3.iterator()
        L_0x003b:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0067
            java.lang.Object r4 = r3.next()
            android.content.Context r4 = (android.content.Context) r4
            java.util.Map<android.content.Context, android.util.Pair<android.view.ViewTreeObserver, android.view.ViewTreeObserver$OnPreDrawListener>> r5 = r1.a
            java.lang.Object r4 = r5.get(r4)
            android.util.Pair r4 = (android.util.Pair) r4
            if (r4 == 0) goto L_0x003b
            java.lang.Object r5 = r4.first
            android.view.ViewTreeObserver r5 = (android.view.ViewTreeObserver) r5
            boolean r5 = r5.isAlive()
            if (r5 == 0) goto L_0x003b
            java.lang.Object r5 = r4.first
            android.view.ViewTreeObserver r5 = (android.view.ViewTreeObserver) r5
            java.lang.Object r4 = r4.second
            android.view.ViewTreeObserver$OnPreDrawListener r4 = (android.view.ViewTreeObserver.OnPreDrawListener) r4
            r5.removeOnPreDrawListener(r4)
            goto L_0x003b
        L_0x0067:
            java.util.Map<android.content.Context, android.util.Pair<android.view.ViewTreeObserver, android.view.ViewTreeObserver$OnPreDrawListener>> r1 = r1.a
            r1.clear()
            com.fyber.inneractive.sdk.util.z r1 = com.fyber.inneractive.sdk.util.z.a.a
            monitor-enter(r1)
            android.content.Context r3 = r1.c     // Catch:{ all -> 0x00bf }
            if (r3 == 0) goto L_0x0091
            java.lang.String r3 = "%sremoving screen state receiver and destroying singleton"
            r4 = 1
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ all -> 0x00bf }
            java.lang.String r5 = com.fyber.inneractive.sdk.util.IAlog.a((java.lang.Object) r1)     // Catch:{ all -> 0x00bf }
            r4[r0] = r5     // Catch:{ all -> 0x00bf }
            com.fyber.inneractive.sdk.util.IAlog.a(r3, r4)     // Catch:{ all -> 0x00bf }
            android.content.Context r0 = r1.c     // Catch:{ Exception -> 0x0088 }
            android.content.BroadcastReceiver r3 = r1.d     // Catch:{ Exception -> 0x0088 }
            r0.unregisterReceiver(r3)     // Catch:{ Exception -> 0x0088 }
        L_0x0088:
            r1.c = r2     // Catch:{ all -> 0x00bf }
            r1.d = r2     // Catch:{ all -> 0x00bf }
            java.util.List<com.fyber.inneractive.sdk.util.z$b> r0 = r1.a     // Catch:{ all -> 0x00bf }
            r0.clear()     // Catch:{ all -> 0x00bf }
        L_0x0091:
            monitor-exit(r1)
            com.fyber.inneractive.sdk.factories.b r0 = com.fyber.inneractive.sdk.factories.b.a.a
            java.util.HashMap<com.fyber.inneractive.sdk.response.a, com.fyber.inneractive.sdk.factories.b$b> r0 = r0.a
            r0.clear()
            com.fyber.inneractive.sdk.factories.a r0 = com.fyber.inneractive.sdk.factories.a.b.a
            java.util.Set<com.fyber.inneractive.sdk.factories.a$a> r0 = r0.a
            r0.clear()
            com.fyber.inneractive.sdk.factories.c r0 = com.fyber.inneractive.sdk.factories.c.b.a
            java.util.Set<com.fyber.inneractive.sdk.factories.c$a> r0 = r0.a
            r0.clear()
            com.fyber.inneractive.sdk.external.InneractiveAdSpotManager.destroy()
            java.util.Map<java.lang.String, java.lang.String> r0 = com.fyber.inneractive.sdk.util.p.a.a
            java.util.HashMap r0 = (java.util.HashMap) r0
            r0.clear()
            com.fyber.inneractive.sdk.bidder.a r0 = com.fyber.inneractive.sdk.bidder.a.h
            com.fyber.inneractive.sdk.bidder.e r1 = r0.d
            if (r1 == 0) goto L_0x00bc
            android.app.Application r3 = com.fyber.inneractive.sdk.util.p.a     // Catch:{ Exception -> 0x00bc }
            r3.unregisterReceiver(r1)     // Catch:{ Exception -> 0x00bc }
        L_0x00bc:
            r0.d = r2
            return
        L_0x00bf:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.external.InneractiveAdManager.destroy():void");
    }

    public static String getAppId() {
        return IAConfigManager.M.c;
    }

    @Deprecated
    public static String getDevPlatform() {
        return b.a.b;
    }

    public static Boolean getGdprConsent() {
        d dVar = IAConfigManager.M.D;
        if (dVar != null) {
            return dVar.a();
        }
        return null;
    }

    public static GdprConsentSource getGdprStatusSource() {
        d dVar = IAConfigManager.M.D;
        if (dVar != null) {
            return dVar.c;
        }
        IAlog.e("getGdprStatusSource() was invoked, but Fyber SDK was not properly initialized", new Object[0]);
        return null;
    }

    @Deprecated
    public static String getKeywords() {
        return IAConfigManager.M.k;
    }

    public static boolean getMuteVideo() {
        return IAConfigManager.M.l;
    }

    public static String getUserId() {
        return IAConfigManager.g();
    }

    public static InneractiveUserConfig getUserParams() {
        return IAConfigManager.M.j;
    }

    public static String getVersion() {
        return "8.2.5";
    }

    public static void initialize(Context context, String str) {
        initialize(context, str, (OnFyberMarketplaceInitializedListener) null);
    }

    @Deprecated
    public static boolean isCurrentDeviceSupportsVideo() {
        return true;
    }

    public static boolean isCurrentUserAChild() {
        return b.a.c;
    }

    @Deprecated
    public static void setDevPlatform(String str) {
        b.a.b = str;
    }

    public static void setGdprConsent(boolean z) {
        setGdprConsent(z, GdprConsentSource.Internal);
    }

    public static void setGdprConsentString(String str) {
        d dVar = IAConfigManager.M.D;
        if (dVar != null) {
            dVar.getClass();
            if (p.a == null) {
                IAlog.e("SetGdprConsentString() was invoked, but the Inneractive SDK was not properly initialized, or destroyed.", new Object[0]);
                return;
            }
            dVar.b = str;
            if (!dVar.a("IAGdprConsentData", str)) {
                IAlog.e("SetGdprConsentString() was invoked, but the Inneractive SDK was not properly initialized, destroyed, or data is empty.", new Object[0]);
                return;
            }
            return;
        }
        IAlog.e("setGdprConsentString() was invoked, but Fyber SDK was not properly initialized", new Object[0]);
    }

    public static void setImpressionDataListener(OnGlobalImpressionDataListener onGlobalImpressionDataListener) {
        IAConfigManager.M.A.a = onGlobalImpressionDataListener;
    }

    @Deprecated
    public static void setKeywords(String str) {
        IAConfigManager.M.k = str;
    }

    public static void setLgpdConsent(boolean z) {
        d dVar = IAConfigManager.M.D;
        if (dVar != null) {
            dVar.getClass();
            if (p.a == null) {
                IAlog.e("setLgpdConsentStatus was invoked, but the Inneractive SDK was not properly initialized, or destroyed.", new Object[0]);
                return;
            }
            dVar.f = Boolean.valueOf(z);
            if (!dVar.a("IALgpdConsentStatus", z)) {
                IAlog.e("setLgpdConsentStatus was invoked, but the Inneractive SDK was not properly initialized, or destroyed.", new Object[0]);
                return;
            }
            return;
        }
        IAlog.e("setLgpdConsent was invoked, but Fyber SDK was not properly initialized", new Object[0]);
    }

    public static void setLogLevel(int i) {
        IAlog.a = i;
    }

    public static void setMediationName(String str) {
        IAConfigManager.M.m = str;
    }

    public static void setMediationVersion(String str) {
        if (str != null) {
            IAConfigManager.M.o = str;
        }
    }

    public static void setMuteVideo(boolean z) {
        IAConfigManager.M.l = z;
    }

    public static void setUSPrivacyString(String str) {
        d dVar = IAConfigManager.M.D;
        if (dVar != null) {
            dVar.getClass();
            if (p.a == null) {
                IAlog.e("setUSPrivacyString() was invoked, but the Inneractive SDK was not properly initialized, or destroyed.", new Object[0]);
                return;
            }
            dVar.e = str;
            if (!dVar.a("IACCPAConsentData", str)) {
                IAlog.e("setUSPrivacyString() was invoked, but the Inneractive SDK was not properly initialized, destroyed, or data is empty.", new Object[0]);
                return;
            }
            return;
        }
        IAlog.e("setUSPrivacyString() was invoked, but Fyber SDK was not properly initialized", new Object[0]);
    }

    public static void setUseLocation(boolean z) {
        IAConfigManager.M.getClass();
    }

    public static void setUserId(String str) {
        IAConfigManager iAConfigManager = IAConfigManager.M;
        if (p.a == null) {
            IAlog.e("setUsedId() was invoked, but the Inneractive SDK was not properly initialized, or destroyed.", new Object[0]);
            return;
        }
        d dVar = IAConfigManager.M.D;
        dVar.getClass();
        if (p.a != null) {
            dVar.b();
            if (TextUtils.isEmpty(str)) {
                dVar.d = str;
                SharedPreferences sharedPreferences = dVar.h;
                if (sharedPreferences != null) {
                    sharedPreferences.edit().remove("keyUserID").apply();
                    return;
                }
                return;
            }
            if (str.length() > 256) {
                str = str.substring(0, 256);
            }
            SharedPreferences sharedPreferences2 = dVar.h;
            if (sharedPreferences2 != null) {
                dVar.d = str;
                sharedPreferences2.edit().putString("keyUserID", str).apply();
            }
        }
    }

    public static void setUserParams(InneractiveUserConfig inneractiveUserConfig) {
        IAConfigManager.M.j = inneractiveUserConfig;
        IAlog.a("config manager: setUserParams called with: age:" + inneractiveUserConfig.getAge() + " gender: " + inneractiveUserConfig.getGender() + " zip: " + inneractiveUserConfig.getZipCode(), new Object[0]);
    }

    public static void useSecureConnections(boolean z) {
        IAConfigManager.M.r = z;
        IAlog.a("config manager: useSecureConnections called with: isSecured: + %s", Boolean.valueOf(z));
        if (!t.a() && !z) {
            IAlog.e("************************************************************************************************************************", new Object[0]);
            IAlog.e("*** useSecureConnections was set to false while secure traffic is enabled in the network security config", new Object[0]);
            IAlog.e("***  The traffic will be Secured  ", new Object[0]);
            IAlog.e("************************************************************************************************************************", new Object[0]);
        }
    }

    public static boolean wasInitialized() {
        return b.a.a != null;
    }

    public Context getAppContext() {
        return this.a;
    }

    public void onGlobalConfigChanged(j jVar, i iVar) {
        if (iVar != null && iVar.a(GLOBAL_CONFIG_PARAM_FIRST_INIT_EVENT, false)) {
            com.fyber.inneractive.sdk.util.q.b.post(new b(this));
        }
    }

    public static void initialize(Context context, String str, OnFyberMarketplaceInitializedListener onFyberMarketplaceInitializedListener) {
        OnFyberMarketplaceInitializedListener.FyberInitStatus fyberInitStatus;
        char c2;
        char c3;
        String str2;
        Context context2 = context;
        String str3 = str;
        OnFyberMarketplaceInitializedListener onFyberMarketplaceInitializedListener2 = onFyberMarketplaceInitializedListener;
        if (context2 == null || str3 == null) {
            IAlog.b("InneractiveAdManager:initialize. No context or App Id given", new Object[0]);
            Object[] objArr = new Object[1];
            objArr[0] = str3 == null ? "appid" : "context";
            String format = String.format("%s is null", objArr);
            if (str3 == null || TextUtils.isEmpty(str.trim())) {
                fyberInitStatus = OnFyberMarketplaceInitializedListener.FyberInitStatus.INVALID_APP_ID;
            } else {
                fyberInitStatus = OnFyberMarketplaceInitializedListener.FyberInitStatus.FAILED;
            }
            a(onFyberMarketplaceInitializedListener2, fyberInitStatus, format);
            return;
        }
        String str4 = IAConfigManager.M.c;
        boolean z = str4 != null && !str4.equalsIgnoreCase(str3);
        if (b.a.a == null || z) {
            ((CopyOnWriteArrayList) IAlog.c).retainAll(Collections.singleton(IAlog.b));
            int i = f.a;
            String property = System.getProperty("ia.testEnvironmentConfiguration.logger");
            if (property != null) {
                for (String cls : property.split(",")) {
                    try {
                        FMPLogger fMPLogger = (FMPLogger) Class.forName(cls).newInstance();
                        fMPLogger.initialize(context2);
                        ((CopyOnWriteArrayList) IAlog.c).add(fMPLogger);
                    } catch (Throwable unused) {
                    }
                }
            }
            p.a = (Application) context.getApplicationContext();
            z zVar = z.a.a;
            Context applicationContext = context.getApplicationContext();
            zVar.getClass();
            IAlog.a("%sinit called", IAlog.a((Object) zVar));
            zVar.c = applicationContext;
            zVar.d = new y(zVar);
            IntentFilter intentFilter = new IntentFilter("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            zVar.c.registerReceiver(zVar.d, intentFilter);
            Intent intent = new Intent();
            intent.setAction("com.fyber.inneractive.sdk.intent.action.REGISTER_KIT");
            intent.setPackage(p.a.getPackageName());
            Context applicationContext2 = context.getApplicationContext();
            if (applicationContext2 != null) {
                List<BroadcastReceiver> asList = Arrays.asList(new BroadcastReceiver[]{new IAMraidKit(), new IAVideoKit(), new c()});
                for (BroadcastReceiver broadcastReceiver : asList) {
                    try {
                        broadcastReceiver.onReceive(applicationContext2, intent);
                    } catch (Throwable unused2) {
                        IAlog.e("%sCould not trigger receiver for %s", IAlog.a((Class<?>) com.fyber.inneractive.sdk.b.class), broadcastReceiver);
                    }
                }
                if (b.a.a.a.size() == 0) {
                    Log.e("Inneractive_error", "Critical error raised while initializing SDK - please make sure you have added all the required fyber libraries (ia-mraid-kit, ia-video-kit) to your project");
                }
                if (asList.size() == 0) {
                    IAlog.b("InneractiveAdManager:initialize. please make sure you have added all the required fyber libraries (ia-mraid-kit, ia-video-kit) to your project", new Object[0]);
                    a(onFyberMarketplaceInitializedListener2, OnFyberMarketplaceInitializedListener.FyberInitStatus.FAILED_NO_KITS_DETECTED, (String) null);
                    return;
                }
                a aVar = new a(context2, onFyberMarketplaceInitializedListener2);
                d = aVar;
                IAConfigManager.addListener(aVar);
                if (z) {
                    IAConfigManager iAConfigManager = IAConfigManager.M;
                    iAConfigManager.c = str3;
                    Map<String, com.fyber.inneractive.sdk.config.z> map = iAConfigManager.a;
                    if (map != null) {
                        map.clear();
                    }
                    Map<String, a0> map2 = iAConfigManager.b;
                    if (map2 != null) {
                        map2.clear();
                    }
                    iAConfigManager.e = null;
                    iAConfigManager.d = "";
                    IAConfigManager.a();
                } else {
                    Context applicationContext3 = context.getApplicationContext();
                    IAConfigManager iAConfigManager2 = IAConfigManager.M;
                    if (!iAConfigManager2.h) {
                        iAConfigManager2.v = new com.fyber.inneractive.sdk.config.e(context2, applicationContext3);
                        z0 z0Var = new z0();
                        iAConfigManager2.y = z0Var;
                        z0Var.b = applicationContext3.getApplicationContext();
                        com.fyber.inneractive.sdk.util.q.a(new y0(z0Var));
                        com.fyber.inneractive.sdk.network.y yVar = iAConfigManager2.s;
                        if (!yVar.b) {
                            yVar.b = true;
                            for (int i2 = 0; i2 < 6; i2++) {
                                yVar.d.submit(yVar.e);
                            }
                        }
                        x.c.getClass();
                        iAConfigManager2.D = new d();
                        j jVar = new j(applicationContext3);
                        iAConfigManager2.u = jVar;
                        iAConfigManager2.w = new k(jVar);
                        jVar.b();
                        com.fyber.inneractive.sdk.network.c cVar = iAConfigManager2.H;
                        Application application = (Application) applicationContext3.getApplicationContext();
                        if (!cVar.g) {
                            cVar.g = true;
                            cVar.c.start();
                            cVar.d = new n0(cVar.c.getLooper(), cVar);
                            cVar.a(30);
                        }
                        application.registerActivityLifecycleCallbacks(new com.fyber.inneractive.sdk.network.d(cVar));
                        iAConfigManager2.u.c.add(new m(iAConfigManager2));
                        iAConfigManager2.z = new com.fyber.inneractive.sdk.config.global.a(new r());
                        IAlog.a("Initializing config manager", new Object[0]);
                        IAlog.a("Config manager: lib name = %s", m2.e);
                        IAlog.a("Config manager: app version = %s", "8.2.5");
                        l lVar = l.b.a;
                        if (lVar.a == null) {
                            lVar.a = applicationContext3;
                            new Thread(new u(applicationContext3, lVar)).start();
                        }
                        if (!str3.matches("[0-9]+")) {
                            IAlog.b("************************************************************************************************************************", new Object[0]);
                            IAlog.b("*************************************** APP ID Must contain only numbers ***********************************************", new Object[0]);
                            IAlog.b("*************************************** Are you sure that you are using the correct APP ID *****************************", new Object[0]);
                            IAlog.b("************************************************************************************************************************", new Object[0]);
                        }
                        iAConfigManager2.f = applicationContext3;
                        iAConfigManager2.c = str3;
                        iAConfigManager2.j = new InneractiveUserConfig();
                        iAConfigManager2.h = true;
                        f0 f0Var = iAConfigManager2.x;
                        f0Var.getClass();
                        com.fyber.inneractive.sdk.config.b bVar = new com.fyber.inneractive.sdk.config.b(f0Var);
                        IAConfigManager iAConfigManager3 = IAConfigManager.M;
                        j jVar2 = iAConfigManager3.u;
                        if (!jVar2.d) {
                            jVar2.c.add(bVar);
                        }
                        b1 b1Var = new b1(TimeUnit.MINUTES, (long) iAConfigManager3.u.b.a("session_duration", 30, 1));
                        bVar.c = b1Var;
                        b1Var.e = bVar.f;
                        f0Var.c.put("SESSION_STAMP", Long.toString(SystemClock.elapsedRealtime()));
                        com.fyber.inneractive.sdk.cache.session.d dVar = new com.fyber.inneractive.sdk.cache.session.d(25, (d.a) null);
                        f0Var.a = dVar;
                        com.fyber.inneractive.sdk.util.q.a(new com.fyber.inneractive.sdk.cache.session.b(dVar));
                        iAConfigManager2.B = new g0(new o(iAConfigManager2), iAConfigManager2.f, new com.fyber.inneractive.sdk.config.c());
                        com.fyber.inneractive.sdk.util.q.a(new com.fyber.inneractive.sdk.config.p(iAConfigManager2));
                        try {
                            str2 = Locale.getDefault().getLanguage();
                            try {
                                IAlog.a("Available device language: %s", str2);
                            } catch (Exception unused3) {
                            }
                        } catch (Exception unused4) {
                            str2 = null;
                        }
                        iAConfigManager2.p = str2;
                        iAConfigManager2.E.a = applicationContext3;
                    }
                }
                b.a.a = context.getApplicationContext();
                SharedPreferences sharedPreferences = context2.getSharedPreferences("Fyber_Shared_File", 0);
                String string = sharedPreferences.getString("FyberExceptionKey", "empty");
                String string2 = sharedPreferences.getString("FyberDescriptionKey", "empty");
                String string3 = sharedPreferences.getString("FyberNameKey", "empty");
                String string4 = sharedPreferences.getString("FyberVersionKey", getVersion());
                IAlog.a(" name- %s   description - %s exception - %s", string3, string2, string);
                if (!string.contains("OutOfMemoryError") && !string.equals("empty") && !string2.equals("empty") && !string3.equals("empty")) {
                    IAlog.a("Firing Event 999 for %s", string);
                    s.a aVar2 = new s.a(com.fyber.inneractive.sdk.network.r.IA_UNCAUGHT_EXCEPTION, (InneractiveAdRequest) null, (e) null, (JSONArray) null);
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("exception_name", string3);
                        c3 = 1;
                        c2 = 0;
                    } catch (Exception unused5) {
                        c2 = 0;
                        c3 = 1;
                        IAlog.e("Got exception adding param to json object: %s, %s", "exception_name", string3);
                    }
                    try {
                        jSONObject.put("description", string2);
                    } catch (Exception unused6) {
                        Object[] objArr2 = new Object[2];
                        objArr2[c2] = "description";
                        objArr2[c3] = string2;
                        IAlog.e("Got exception adding param to json object: %s, %s", objArr2);
                    }
                    try {
                        jSONObject.put("stack_trace", string);
                    } catch (Exception unused7) {
                        Object[] objArr3 = new Object[2];
                        objArr3[c2] = "stack_trace";
                        objArr3[c3] = string;
                        IAlog.e("Got exception adding param to json object: %s, %s", objArr3);
                    }
                    aVar2.f.put(jSONObject);
                    aVar2.a(string4);
                    sharedPreferences.edit().remove("FyberExceptionKey").remove("FyberVersionKey").remove("FyberDescriptionKey").remove("FyberNameKey").apply();
                }
                Thread.setDefaultUncaughtExceptionHandler(new a(sharedPreferences, Thread.getDefaultUncaughtExceptionHandler()));
                IAConfigManager iAConfigManager4 = IAConfigManager.M;
                iAConfigManager4.u.c.remove(b.a);
                iAConfigManager4.u.c.add(b.a);
                return;
            }
            throw new IllegalArgumentException("Context can't be null");
        }
        IAlog.a("InneractiveAdManager:initialize called, but manager is already initialized. ignoring", new Object[0]);
        a(onFyberMarketplaceInitializedListener2, OnFyberMarketplaceInitializedListener.FyberInitStatus.SUCCESSFULLY, (String) null);
    }

    public static void setGdprConsent(boolean z, GdprConsentSource gdprConsentSource) {
        com.fyber.inneractive.sdk.config.d dVar = IAConfigManager.M.D;
        if (dVar != null) {
            dVar.getClass();
            if (p.a == null) {
                IAlog.e("SetGdprConsent(boolean) was invoked, but the Inneractive SDK was not properly initialized, or destroyed.", new Object[0]);
                return;
            }
            dVar.a = Boolean.valueOf(z);
            if (!dVar.a("IAGDPRBool", z)) {
                IAlog.e("SetGdprConsent(boolean) was invoked, but the Inneractive SDK was not properly initialized, or destroyed.", new Object[0]);
            }
            dVar.c = gdprConsentSource;
            if (!dVar.a("IAGdprSource", gdprConsentSource.name())) {
                IAlog.e("SetGdprConsent(boolean) was invoked, but the Inneractive SDK was not properly initialized, or destroyed.", new Object[0]);
                return;
            }
            return;
        }
        IAlog.e("setGdprConsent() was invoked, but Fyber SDK was not properly initialized", new Object[0]);
    }

    public static void setMediationName(InneractiveMediationName inneractiveMediationName) {
        if (inneractiveMediationName != null) {
            IAConfigManager iAConfigManager = IAConfigManager.M;
            iAConfigManager.n = inneractiveMediationName;
            iAConfigManager.m = inneractiveMediationName.getKey();
        }
    }
}
