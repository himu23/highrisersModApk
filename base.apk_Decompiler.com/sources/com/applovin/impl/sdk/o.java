package com.applovin.impl.sdk;

import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.hardware.SensorManager;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Environment;
import android.os.LocaleList;
import android.os.PowerManager;
import android.os.SystemClock;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import androidx.activity.ComponentDialog$$ExternalSyntheticApiModelOutline0;
import androidx.core.graphics.ColorKt$$ExternalSyntheticApiModelOutline0;
import com.applovin.impl.sdk.array.ArrayService;
import com.applovin.impl.sdk.d.f;
import com.applovin.impl.sdk.d.g;
import com.applovin.impl.sdk.e.ab;
import com.applovin.impl.sdk.e.i;
import com.applovin.impl.sdk.e.q;
import com.applovin.impl.sdk.network.b;
import com.applovin.impl.sdk.utils.AppLovinSdkExtraParameterKey;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.d;
import com.applovin.impl.sdk.utils.h;
import com.applovin.impl.sdk.utils.i;
import com.applovin.impl.sdk.utils.p;
import com.applovin.impl.sdk.utils.t;
import com.applovin.impl.sdk.utils.u;
import com.applovin.sdk.AppLovinEventTypes;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.AppLovinWebViewActivity;
import com.ironsource.m2;
import com.ironsource.t4;
import com.unity3d.services.core.device.MimeTypes;
import java.io.File;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

public class o {
    /* access modifiers changed from: private */
    public static final AtomicReference<d.a> aDd = new AtomicReference<>();
    private static final AtomicReference<a> aDf = new AtomicReference<>();
    private final Context E;
    private final Map<String, Object> aDa;
    private final Object aDb = new Object();
    private boolean aDc;
    private final AtomicReference<Integer> aDe = new AtomicReference<>();
    private final Map<String, Object> awb;
    private final x logger;
    private final n sdk;

    public static class b {
        public int aDi = -1;
        public Boolean aDj = null;
        public int adn = -1;
    }

    public boolean Da() {
        return this.aDc;
    }

    protected o(n nVar) {
        if (nVar != null) {
            this.sdk = nVar;
            this.logger = nVar.BN();
            this.E = n.getApplicationContext();
            this.aDa = CY();
            this.awb = Dc();
            return;
        }
        throw new IllegalArgumentException("No sdk specified");
    }

    /* access modifiers changed from: package-private */
    public String getBidToken() {
        String encodeToString = Base64.encodeToString(new JSONObject(CS()).toString().getBytes(Charset.defaultCharset()), 2);
        return ((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aPN)).booleanValue() ? p.a(encodeToString, u.N(this.sdk), p.a.gW(((Integer) this.sdk.a(com.applovin.impl.sdk.c.b.aPO)).intValue()), this.sdk.getSdkKey(), this.sdk) : encodeToString;
    }

    private Map<String, String> CS() {
        return u.s(a((Map<String, String>) null, true, false));
    }

    public Map<String, Object> a(Map<String, String> map, boolean z, boolean z2) {
        HashMap hashMap = new HashMap(64);
        Map<String, Object> aL = aL(z);
        Map<String, Object> Db = Db();
        Map<String, Object> Df = Df();
        Map<String, Object> Dg = Dg();
        Map<String, String> allData = this.sdk.BC().getAllData();
        if (z2) {
            hashMap.put("device_info", aL);
            hashMap.put("app_info", Db);
            if (Df != null) {
                hashMap.put("connection_info", Df);
            }
            if (map != null) {
                hashMap.put("ad_info", map);
            }
            if (Dg != null) {
                hashMap.put("location_info", Dg);
            }
            if (!allData.isEmpty()) {
                hashMap.put("targeting_data", allData);
            }
        } else {
            hashMap.putAll(aL);
            hashMap.putAll(Db);
            if (Df != null) {
                hashMap.putAll(Df);
            }
            if (map != null) {
                hashMap.putAll(map);
            }
            if (Dg != null) {
                hashMap.putAll(Dg);
            }
            if (!allData.isEmpty()) {
                hashMap.putAll(allData);
            }
        }
        hashMap.put("accept", "custom_size,launch_app,video");
        hashMap.put("format", "json");
        CollectionUtils.putStringIfValid("mediation_provider", this.sdk.getMediationProvider(), hashMap);
        CollectionUtils.putStringIfValid("mediation_provider_v2", this.sdk.CL(), hashMap);
        CollectionUtils.putStringIfValid("plugin_version", (String) this.sdk.a(com.applovin.impl.sdk.c.b.aOD), hashMap);
        CollectionUtils.putLongIfValid("tssf_ms", Long.valueOf(this.sdk.By()), hashMap);
        if (!((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aPL)).booleanValue()) {
            hashMap.put(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, this.sdk.getSdkKey());
        }
        hashMap.putAll(De());
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aPn)).booleanValue()) {
            g BR = this.sdk.BR();
            hashMap.put("li", Long.valueOf(BR.b(f.aST)));
            hashMap.put("si", Long.valueOf(BR.b(f.aSW)));
            hashMap.put("mad", Long.valueOf(BR.b(f.aSU)));
            hashMap.put("msad", Long.valueOf(BR.b(f.aSX)));
            hashMap.put("pf", Long.valueOf(BR.b(f.aTb)));
            hashMap.put("mpf", Long.valueOf(BR.b(f.aTi)));
            hashMap.put("gpf", Long.valueOf(BR.b(f.aTc)));
            hashMap.put("asoac", Long.valueOf(BR.b(f.aTg)));
        }
        hashMap.put("rid", UUID.randomUUID().toString());
        return hashMap;
    }

    public Map<String, Object> CT() {
        return CollectionUtils.map(this.aDa);
    }

    public Map<String, Object> CU() {
        return CollectionUtils.map(this.awb);
    }

    public Map<String, Object> CV() {
        return aL(false);
    }

    public Map<String, Object> aL(boolean z) {
        Map<String, Object> map;
        synchronized (this.aDb) {
            map = CollectionUtils.map(this.aDa);
        }
        return a(map, z);
    }

    public void CW() {
        synchronized (this.aDb) {
            g(this.aDa);
        }
    }

    public String CX() {
        return AppLovinSdkUtils.isFireOS(this.E) ? "fireos" : "android";
    }

    private Map<String, Object> CY() {
        HashMap hashMap = new HashMap(34);
        hashMap.put("api_level", Integer.valueOf(Build.VERSION.SDK_INT));
        hashMap.put("brand", Build.MANUFACTURER);
        hashMap.put("brand_name", Build.BRAND);
        hashMap.put("hardware", Build.HARDWARE);
        hashMap.put("sim", Boolean.valueOf(AppLovinSdkUtils.isEmulator()));
        hashMap.put("aida", Boolean.valueOf(d.KP()));
        hashMap.put("locale", Locale.getDefault().toString());
        hashMap.put(t4.u, Build.MODEL);
        hashMap.put(t4.x, Build.VERSION.RELEASE);
        hashMap.put("platform", CX());
        hashMap.put("revision", Build.DEVICE);
        hashMap.put("tz_offset", Double.valueOf(Ds()));
        hashMap.put("gy", Boolean.valueOf(Dt()));
        hashMap.put("country_code", Du());
        hashMap.put("mcc", Dv());
        hashMap.put("mnc", Dw());
        hashMap.put(t4.s0, Dx());
        hashMap.put("is_tablet", Boolean.valueOf(AppLovinSdkUtils.isTablet(this.E)));
        hashMap.put("tv", Boolean.valueOf(AppLovinSdkUtils.isTv(this.E)));
        hashMap.put("pc", Integer.valueOf(Runtime.getRuntime().availableProcessors()));
        hashMap.put("hdr", Dz());
        hashMap.put("supported_abis", DA());
        DisplayMetrics displayMetrics = this.E.getResources().getDisplayMetrics();
        if (displayMetrics != null) {
            hashMap.put("adns", Float.valueOf(displayMetrics.density));
            hashMap.put("adnsd", Integer.valueOf(displayMetrics.densityDpi));
            hashMap.put("xdpi", Float.valueOf(displayMetrics.xdpi));
            hashMap.put("ydpi", Float.valueOf(displayMetrics.ydpi));
            Point Y = h.Y(this.E);
            hashMap.put("screen_size_in", Double.valueOf(Math.sqrt(Math.pow((double) Y.x, 2.0d) + Math.pow((double) Y.y, 2.0d)) / ((double) displayMetrics.xdpi)));
            h.a a2 = h.a(this.E, this.sdk);
            if (a2 != null) {
                hashMap.put("tl_cr", Integer.valueOf(a2.Lh()));
                hashMap.put("tr_cr", Integer.valueOf(a2.Li()));
                hashMap.put("bl_cr", Integer.valueOf(a2.Lj()));
                hashMap.put("br_cr", Integer.valueOf(a2.Lk()));
            }
        }
        hashMap.put("bt_ms", Long.valueOf(System.currentTimeMillis() - SystemClock.elapsedRealtime()));
        hashMap.put("tbalsi_ms", Long.valueOf(this.sdk.CJ() - n.CH()));
        CollectionUtils.putBooleanIfValid("psase", Boolean.valueOf(aa.M(this.E)), hashMap);
        g(hashMap);
        return hashMap;
    }

    private void g(Map<String, Object> map) {
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aOK)).booleanValue() && !map.containsKey("af")) {
            map.put("af", Long.valueOf(Dl()));
        }
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aOL)).booleanValue() && !map.containsKey("font")) {
            map.put("font", Float.valueOf(Dm()));
        }
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aOS)).booleanValue() && u.Q(this.sdk)) {
            af.A(this.sdk);
        }
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aOR)).booleanValue() && !map.containsKey("sua")) {
            map.put("sua", System.getProperty("http.agent"));
        }
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aON)).booleanValue() && !map.containsKey("network_restricted")) {
            map.put("network_restricted", Boolean.valueOf(Dh()));
        }
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aOV)).booleanValue()) {
            boolean z = true;
            boolean z2 = this.E.getResources().getConfiguration().keyboard == 2;
            boolean hasSystemFeature = this.E.getPackageManager().hasSystemFeature("com.google.android.play.feature.HPE_EXPERIENCE");
            boolean hasSystemFeature2 = this.E.getPackageManager().hasSystemFeature("android.hardware.type.pc");
            if (!z2 || (!hasSystemFeature && !hasSystemFeature2)) {
                z = false;
            }
            map.put("is_pc", Boolean.valueOf(z));
        }
    }

    private Map<String, Object> a(Map<String, Object> map, boolean z) {
        d.a aVar;
        PowerManager powerManager;
        Map<String, Object> map2 = CollectionUtils.map(map);
        Point Y = h.Y(this.E);
        map2.put("dx", Integer.valueOf(Y.x));
        map2.put("dy", Integer.valueOf(Y.y));
        if (z) {
            aVar = aDd.get();
            if (aVar != null) {
                DD();
            } else if (u.Lx()) {
                aVar = new d.a();
                map2.put("inc", true);
            } else {
                aVar = this.sdk.BS().Di();
            }
        } else {
            aVar = this.sdk.BS().Di();
        }
        String KR = aVar.KR();
        if (StringUtils.isValidString(KR)) {
            map2.put("idfa", KR);
        }
        map2.put("dnt", Boolean.valueOf(aVar.KQ()));
        map2.put("dnt_code", aVar.KS().KT());
        a aVar2 = aDf.get();
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aOs)).booleanValue() && aVar2 != null) {
            map2.put("idfv", aVar2.f15do);
            map2.put("idfv_scope", Integer.valueOf(aVar2.aDh));
        }
        Boolean B = com.applovin.impl.privacy.a.zP().B(this.E);
        if (B != null) {
            map2.put(AppLovinSdkExtraParameterKey.HAS_USER_CONSENT, B);
        }
        Boolean B2 = com.applovin.impl.privacy.a.zO().B(this.E);
        if (B2 != null) {
            map2.put(AppLovinSdkExtraParameterKey.AGE_RESTRICTED_USER, B2);
        }
        Boolean B3 = com.applovin.impl.privacy.a.zQ().B(this.E);
        if (B3 != null) {
            map2.put(AppLovinSdkExtraParameterKey.DO_NOT_SELL, B3);
        }
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aOE)).booleanValue()) {
            b Dk = Dk();
            CollectionUtils.putIntegerIfValid("act", Integer.valueOf(Dk.aDi), map2);
            CollectionUtils.putIntegerIfValid("acm", Integer.valueOf(Dk.adn), map2);
            CollectionUtils.putBooleanIfValid("sowpie", Dk.aDj, map2);
        }
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aOM)).booleanValue()) {
            map2.put("mtl", Integer.valueOf(this.sdk.Ce().getLastTrimMemoryLevel()));
        }
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aOP)).booleanValue()) {
            map2.put("adr", Boolean.valueOf(Dy()));
        }
        Integer Dp = z ? this.aDe.get() : Dp();
        if (Dp != null) {
            map2.put("volume", Dp);
        }
        CollectionUtils.putBooleanIfValid("ma", Dq(), map2);
        CollectionUtils.putBooleanIfValid("spo", Dr(), map2);
        CollectionUtils.putBooleanIfValid("aif", Boolean.valueOf(!this.sdk.Ce().isApplicationPaused()), map2);
        CollectionUtils.putLongIfValid("af_ts_ms", Long.valueOf(this.sdk.Ce().getAppEnteredForegroundTimeMillis()), map2);
        CollectionUtils.putLongIfValid("ab_ts_ms", Long.valueOf(this.sdk.Ce().getAppEnteredBackgroundTimeMillis()), map2);
        try {
            map2.put("sb", Integer.valueOf((int) ((((float) Settings.System.getInt(this.E.getContentResolver(), "screen_brightness")) / 255.0f) * 100.0f)));
        } catch (Settings.SettingNotFoundException e) {
            if (x.Fn()) {
                this.logger.c("DataCollector", "Unable to collect screen brightness", e);
            }
        }
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aOS)).booleanValue() && u.Q(this.sdk)) {
            af.A(this.sdk);
            String Fy = af.Fy();
            if (StringUtils.isValidString(Fy)) {
                map2.put(t4.R, Fy);
            }
        }
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aOG)).booleanValue()) {
            try {
                map2.put(t4.u0, Long.valueOf(Environment.getDataDirectory().getFreeSpace()));
                map2.put("tds", Long.valueOf(Environment.getDataDirectory().getTotalSpace()));
            } catch (Throwable th) {
                map2.put(t4.u0, -1);
                map2.put("tds", -1);
                if (x.Fn()) {
                    this.logger.c("DataCollector", "Unable to collect total & free space.", th);
                }
            }
        }
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aOH)).booleanValue()) {
            ActivityManager activityManager = (ActivityManager) this.E.getSystemService("activity");
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            if (activityManager != null) {
                try {
                    activityManager.getMemoryInfo(memoryInfo);
                    map2.put("fm", Long.valueOf(memoryInfo.availMem));
                    map2.put("tm", Long.valueOf(memoryInfo.totalMem));
                    map2.put("lmt", Long.valueOf(memoryInfo.threshold));
                    map2.put("lm", Boolean.valueOf(memoryInfo.lowMemory));
                } catch (Throwable th2) {
                    map2.put("fm", -1);
                    map2.put("tm", -1);
                    map2.put("lmt", -1);
                    if (x.Fn()) {
                        this.logger.c("DataCollector", "Unable to collect memory info.", th2);
                    }
                }
            }
        }
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aOI)).booleanValue() && h.d("android.permission.READ_PHONE_STATE", this.E) && h.KZ()) {
            map2.put("rat", Integer.valueOf(((TelephonyManager) this.E.getSystemService("phone")).getDataNetworkType()));
        }
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aOF)).booleanValue()) {
            String Dn = Dn();
            if (!TextUtils.isEmpty(Dn)) {
                map2.put("so", Dn);
            }
        }
        map2.put("orientation_lock", CZ());
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aOJ)).booleanValue()) {
            map2.put("vs", Boolean.valueOf(u.Lz()));
        }
        if (h.KX() && (powerManager = (PowerManager) this.E.getSystemService("power")) != null) {
            map2.put("lpm", Integer.valueOf(powerManager.isPowerSaveMode() ? 1 : 0));
        }
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aOT)).booleanValue() && this.sdk.Ci() != null) {
            map2.put("da", Float.valueOf(this.sdk.Ci().Ls()));
        }
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aOU)).booleanValue() && this.sdk.Ci() != null) {
            map2.put("dm", Float.valueOf(this.sdk.Ci().Lr()));
        }
        map2.put("mute_switch", Integer.valueOf(this.sdk.Cj().AV()));
        map2.put("network", i.G(this.sdk));
        String Do = Do();
        if (StringUtils.isValidString(Do)) {
            map2.put("kb", Do);
        }
        ArrayService Cr = this.sdk.Cr();
        if (Cr.isAppHubInstalled()) {
            if (Cr.getIsDirectDownloadEnabled() != null) {
                map2.put("ah_dd_enabled", Cr.getIsDirectDownloadEnabled());
            }
            map2.put("ah_sdk_version_code", Long.valueOf(Cr.getAppHubVersionCode()));
            map2.put("ah_random_user_token", StringUtils.emptyIfNull(Cr.getRandomUserToken()));
            map2.put("ah_sdk_package_name", StringUtils.emptyIfNull(Cr.getAppHubPackageName()));
        }
        return map2;
    }

    private String CZ() {
        int orientation = AppLovinSdkUtils.getOrientation(this.E);
        if (orientation == 1) {
            return m2.h.D;
        }
        return orientation == 2 ? m2.h.C : "none";
    }

    public Map<String, Object> Db() {
        Map<String, Object> map = CollectionUtils.map(this.awb);
        map.put("first_install", Boolean.valueOf(this.sdk.CK()));
        map.put("first_install_v2", Boolean.valueOf(!this.sdk.BL()));
        map.put("test_ads", Boolean.valueOf(this.aDc));
        map.put("muted", Boolean.valueOf(this.sdk.getSettings().isMuted()));
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aOt)).booleanValue()) {
            CollectionUtils.putStringIfValid("cuid", this.sdk.Bz(), map);
        }
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aOw)).booleanValue()) {
            map.put("compass_random_token", this.sdk.BA());
        }
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aOy)).booleanValue()) {
            map.put("applovin_random_token", this.sdk.BB());
        }
        String name = this.sdk.getUserSegment().getName();
        if (StringUtils.isValidString(name)) {
            map.put("user_segment_name", name);
        }
        map.putAll(Dd());
        if (this.sdk.BW() != null) {
            CollectionUtils.putJsonArrayIfValid("ps_topics", this.sdk.BW().Ft(), map);
        }
        return map;
    }

    private Map<String, Object> Dc() {
        PackageInfo packageInfo;
        HashMap hashMap = new HashMap();
        PackageManager packageManager = this.E.getPackageManager();
        ApplicationInfo applicationInfo = this.E.getApplicationInfo();
        long lastModified = new File(applicationInfo.sourceDir).lastModified();
        String str = null;
        try {
            packageInfo = packageManager.getPackageInfo(this.E.getPackageName(), 0);
            try {
                str = packageManager.getInstallerPackageName(applicationInfo.packageName);
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            packageInfo = null;
        }
        hashMap.put("app_name", packageManager.getApplicationLabel(applicationInfo));
        Object obj = "";
        hashMap.put("app_version", packageInfo != null ? packageInfo.versionName : obj);
        hashMap.put("app_version_code", Integer.valueOf(packageInfo != null ? packageInfo.versionCode : -1));
        hashMap.put(m2.h.V, applicationInfo.packageName);
        hashMap.put("vz", StringUtils.toShortSHA1Hash(applicationInfo.packageName));
        if (str == null) {
            str = obj;
        }
        hashMap.put("installer_name", str);
        hashMap.put("tg", t.M(this.sdk));
        hashMap.put("debug", Boolean.valueOf(u.b(n.getApplicationContext(), this.sdk)));
        hashMap.put("ia", Long.valueOf(lastModified));
        hashMap.put("alts_ms", Long.valueOf(n.CH()));
        hashMap.put("j8", Boolean.valueOf(n.CI()));
        hashMap.put("ps_tpg", Boolean.valueOf(aa.O(this.E)));
        hashMap.put("ps_apg", Boolean.valueOf(aa.P(this.E)));
        hashMap.put("ps_capg", Boolean.valueOf(aa.Q(this.E)));
        hashMap.put("ps_aipg", Boolean.valueOf(aa.R(this.E)));
        Long l = (Long) this.sdk.a(com.applovin.impl.sdk.c.d.aRk);
        if (l != null) {
            hashMap.put("ia_v2", l);
        } else {
            this.sdk.a(com.applovin.impl.sdk.c.d.aRk, Long.valueOf(lastModified));
        }
        hashMap.put("sdk_version", AppLovinSdk.VERSION);
        hashMap.put("omid_sdk_version", this.sdk.Cp().getSdkVersion());
        hashMap.put("api_did", this.sdk.a(com.applovin.impl.sdk.c.b.aKl));
        if (packageInfo != null) {
            obj = Long.valueOf(packageInfo.firstInstallTime);
        }
        hashMap.put("first_install_v3_ms", obj);
        hashMap.put("target_sdk", Integer.valueOf(applicationInfo.targetSdkVersion));
        hashMap.put("epv", Integer.valueOf(u.LC()));
        return hashMap;
    }

    private Map<String, Object> Dd() {
        HashMap hashMap = new HashMap();
        CollectionUtils.putIntegerIfValid("IABTCF_gdprApplies", this.sdk.Cm().Ar(), hashMap);
        CollectionUtils.putStringIfValid("IABTCF_TCString", this.sdk.Cm().As(), hashMap);
        CollectionUtils.putStringIfValid("IABTCF_AddtlConsent", this.sdk.Cm().At(), hashMap);
        return hashMap;
    }

    public Map<String, Object> De() {
        HashMap hashMap = new HashMap();
        hashMap.put("sc", this.sdk.a(com.applovin.impl.sdk.c.b.aKr));
        hashMap.put("sc2", this.sdk.a(com.applovin.impl.sdk.c.b.aKs));
        hashMap.put("sc3", this.sdk.a(com.applovin.impl.sdk.c.b.aKt));
        hashMap.put("server_installed_at", this.sdk.a(com.applovin.impl.sdk.c.b.aKu));
        CollectionUtils.putStringIfValid("persisted_data", (String) this.sdk.a(com.applovin.impl.sdk.c.d.aRM), hashMap);
        return hashMap;
    }

    public Map<String, Object> Df() {
        b.c HK = this.sdk.BQ().HK();
        if (HK == null) {
            return null;
        }
        HashMap hashMap = new HashMap(4);
        hashMap.put("lrm_ts_ms", String.valueOf(HK.HM()));
        hashMap.put("lrm_url", HK.HN());
        hashMap.put("lrm_ct_ms", String.valueOf(HK.HP()));
        hashMap.put("lrm_rs", String.valueOf(HK.HO()));
        return hashMap;
    }

    public Map<String, Object> Dg() {
        if (!this.sdk.getSettings().isLocationCollectionEnabled() || !((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aPk)).booleanValue()) {
            return null;
        }
        HashMap hashMap = new HashMap();
        w Cq = this.sdk.Cq();
        boolean Fi = Cq.Fi();
        hashMap.put("loc_services_enabled", Boolean.valueOf(Fi));
        if (!Fi) {
            return hashMap;
        }
        hashMap.put("loc_auth", Boolean.valueOf(Cq.Fh()));
        if (Cq.Fj()) {
            hashMap.put("loc_lat", u.a(Cq.Fl(), ((Integer) this.sdk.a(com.applovin.impl.sdk.c.b.aPm)).intValue()));
            hashMap.put("loc_long", u.a(Cq.Fm(), ((Integer) this.sdk.a(com.applovin.impl.sdk.c.b.aPm)).intValue()));
        }
        return hashMap;
    }

    private boolean Dh() {
        ConnectivityManager connectivityManager;
        if (h.KZ() && (connectivityManager = (ConnectivityManager) this.E.getSystemService("connectivity")) != null) {
            try {
                if (connectivityManager.getRestrictBackgroundStatus() == 3) {
                    return true;
                }
                return false;
            } catch (Throwable th) {
                this.sdk.BN();
                if (x.Fn()) {
                    this.sdk.BN().c("DataCollector", "Unable to collect constrained network info.", th);
                }
            }
        }
        return false;
    }

    public d.a Di() {
        d.a U = d.U(this.E);
        if (U == null) {
            return new d.a();
        }
        if (((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aOr)).booleanValue()) {
            if (U.KQ() && !((Boolean) this.sdk.a(com.applovin.impl.sdk.c.b.aOq)).booleanValue()) {
                U.dx("");
            }
            aDd.set(U);
        } else {
            U = new d.a();
        }
        boolean z = false;
        if (StringUtils.isValidString(U.KR())) {
            List<String> testDeviceAdvertisingIds = this.sdk.getSettings().getTestDeviceAdvertisingIds();
            if (testDeviceAdvertisingIds != null && testDeviceAdvertisingIds.contains(U.KR())) {
                z = true;
            }
            this.aDc = z;
        } else {
            this.aDc = false;
        }
        return U;
    }

    public static void a(d.a aVar) {
        aDd.set(aVar);
    }

    public a Dj() {
        return aDf.get();
    }

    public static void a(a aVar) {
        aDf.set(aVar);
    }

    private b Dk() {
        b bVar = new b();
        Intent registerReceiver = this.E.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        int intExtra = registerReceiver != null ? registerReceiver.getIntExtra(AppLovinEventTypes.USER_COMPLETED_LEVEL, -1) : -1;
        int intExtra2 = registerReceiver != null ? registerReceiver.getIntExtra("scale", -1) : -1;
        if (intExtra <= 0 || intExtra2 <= 0) {
            bVar.adn = -1;
        } else {
            bVar.adn = (int) ((((float) intExtra) / ((float) intExtra2)) * 100.0f);
        }
        bVar.aDi = registerReceiver != null ? registerReceiver.getIntExtra("status", -1) : -1;
        boolean z = false;
        if (h.KV()) {
            if (Settings.Global.getInt(this.E.getContentResolver(), "stay_on_while_plugged_in", -1) > 0) {
                z = true;
            }
            bVar.aDj = Boolean.valueOf(z);
        } else {
            if (((registerReceiver.getIntExtra("plugged", -1) & 1) | 14) > 0) {
                z = true;
            }
            bVar.aDj = Boolean.valueOf(z);
        }
        return bVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:104:0x01aa  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x01b1  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x01c1  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x01c8  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x01d8  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x01df  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private long Dl() {
        /*
            r6 = this;
            android.content.Context r0 = r6.E
            android.content.ContentResolver r0 = r0.getContentResolver()
            java.lang.String r1 = "enabled_accessibility_services"
            java.lang.String r0 = android.provider.Settings.Secure.getString(r0, r1)
            java.lang.String r0 = com.applovin.impl.sdk.utils.StringUtils.emptyIfNull(r0)
            java.lang.String r1 = ":"
            java.lang.String[] r0 = r0.split(r1)
            java.util.List r0 = java.util.Arrays.asList(r0)
            java.lang.String r1 = "AccessibilityMenuService"
            boolean r1 = r0.contains(r1)
            if (r1 == 0) goto L_0x0025
            r1 = 256(0x100, double:1.265E-321)
            goto L_0x0027
        L_0x0025:
            r1 = 0
        L_0x0027:
            java.lang.String r3 = "SelectToSpeakService"
            boolean r3 = r0.contains(r3)
            if (r3 == 0) goto L_0x0032
            r3 = 512(0x200, double:2.53E-321)
            long r1 = r1 | r3
        L_0x0032:
            java.lang.String r3 = "SoundAmplifierService"
            boolean r3 = r0.contains(r3)
            if (r3 == 0) goto L_0x003d
            r3 = 2
            long r1 = r1 | r3
        L_0x003d:
            java.lang.String r3 = "SpeechToTextAccessibilityService"
            boolean r3 = r0.contains(r3)
            if (r3 == 0) goto L_0x0048
            r3 = 128(0x80, double:6.32E-322)
            long r1 = r1 | r3
        L_0x0048:
            java.lang.String r3 = "SwitchAccessService"
            boolean r0 = r0.contains(r3)
            if (r0 == 0) goto L_0x0053
            r3 = 4
            long r1 = r1 | r3
        L_0x0053:
            android.content.Context r0 = r6.E
            android.content.res.Resources r0 = r0.getResources()
            android.content.res.Configuration r0 = r0.getConfiguration()
            int r0 = r0.uiMode
            r0 = r0 & 48
            r3 = 32
            if (r0 != r3) goto L_0x0068
            r3 = 1024(0x400, double:5.06E-321)
            long r1 = r1 | r3
        L_0x0068:
            java.lang.String r0 = "accessibility_enabled"
            boolean r0 = r6.cD(r0)
            if (r0 == 0) goto L_0x0073
            r3 = 8
            long r1 = r1 | r3
        L_0x0073:
            java.lang.String r0 = "touch_exploration_enabled"
            boolean r0 = r6.cD(r0)
            if (r0 == 0) goto L_0x007e
            r3 = 16
            long r1 = r1 | r3
        L_0x007e:
            boolean r0 = com.applovin.impl.sdk.utils.h.KX()
            if (r0 == 0) goto L_0x009a
            java.lang.String r0 = "accessibility_display_inversion_enabled"
            boolean r0 = r6.cD(r0)
            if (r0 == 0) goto L_0x008f
            r3 = 32
            long r1 = r1 | r3
        L_0x008f:
            java.lang.String r0 = "skip_first_use_hints"
            boolean r0 = r6.cD(r0)
            if (r0 == 0) goto L_0x009a
            r3 = 64
            long r1 = r1 | r3
        L_0x009a:
            java.lang.String r0 = "lock_screen_allow_remote_input"
            boolean r0 = r6.cD(r0)
            if (r0 == 0) goto L_0x00a5
            r3 = 2048(0x800, double:1.0118E-320)
            long r1 = r1 | r3
        L_0x00a5:
            java.lang.String r0 = "enabled_accessibility_audio_description_by_default"
            boolean r0 = r6.cD(r0)
            if (r0 == 0) goto L_0x00b0
            r3 = 4096(0x1000, double:2.0237E-320)
            long r1 = r1 | r3
        L_0x00b0:
            java.lang.String r0 = "accessibility_shortcut_on_lock_screen"
            boolean r0 = r6.cD(r0)
            if (r0 == 0) goto L_0x00bb
            r3 = 8192(0x2000, double:4.0474E-320)
            long r1 = r1 | r3
        L_0x00bb:
            java.lang.String r0 = "wear_talkback_enabled"
            boolean r0 = r6.cD(r0)
            if (r0 == 0) goto L_0x00c6
            r3 = 16384(0x4000, double:8.0948E-320)
            long r1 = r1 | r3
        L_0x00c6:
            java.lang.String r0 = "hush_gesture_used"
            boolean r0 = r6.cD(r0)
            if (r0 == 0) goto L_0x00d2
            r3 = 32768(0x8000, double:1.61895E-319)
            long r1 = r1 | r3
        L_0x00d2:
            java.lang.String r0 = "high_text_contrast_enabled"
            boolean r0 = r6.cD(r0)
            if (r0 == 0) goto L_0x00de
            r3 = 65536(0x10000, double:3.2379E-319)
            long r1 = r1 | r3
        L_0x00de:
            java.lang.String r0 = "accessibility_display_magnification_enabled"
            boolean r0 = r6.cD(r0)
            if (r0 == 0) goto L_0x00ea
            r3 = 131072(0x20000, double:6.47582E-319)
            long r1 = r1 | r3
        L_0x00ea:
            java.lang.String r0 = "accessibility_display_magnification_navbar_enabled"
            boolean r0 = r6.cD(r0)
            if (r0 == 0) goto L_0x00f6
            r3 = 262144(0x40000, double:1.295163E-318)
            long r1 = r1 | r3
        L_0x00f6:
            java.lang.String r0 = "accessibility_captioning_enabled"
            boolean r0 = r6.cD(r0)
            if (r0 == 0) goto L_0x0102
            r3 = 524288(0x80000, double:2.590327E-318)
            long r1 = r1 | r3
        L_0x0102:
            java.lang.String r0 = "accessibility_display_daltonizer_enabled"
            boolean r0 = r6.cD(r0)
            if (r0 == 0) goto L_0x010e
            r3 = 1048576(0x100000, double:5.180654E-318)
            long r1 = r1 | r3
        L_0x010e:
            java.lang.String r0 = "accessibility_autoclick_enabled"
            boolean r0 = r6.cD(r0)
            if (r0 == 0) goto L_0x011a
            r3 = 2097152(0x200000, double:1.0361308E-317)
            long r1 = r1 | r3
        L_0x011a:
            java.lang.String r0 = "accessibility_large_pointer_icon"
            boolean r0 = r6.cD(r0)
            if (r0 == 0) goto L_0x0126
            r3 = 4194304(0x400000, double:2.0722615E-317)
            long r1 = r1 | r3
        L_0x0126:
            java.lang.String r0 = "reduce_bright_colors_activated"
            boolean r0 = r6.cD(r0)
            if (r0 == 0) goto L_0x0132
            r3 = 8388608(0x800000, double:4.144523E-317)
            long r1 = r1 | r3
        L_0x0132:
            java.lang.String r0 = "reduce_bright_colors_persist_across_reboots"
            boolean r0 = r6.cD(r0)
            if (r0 == 0) goto L_0x013e
            r3 = 16777216(0x1000000, double:8.289046E-317)
            long r1 = r1 | r3
        L_0x013e:
            java.lang.String r0 = "tty_mode_enabled"
            boolean r0 = r6.cD(r0)
            if (r0 == 0) goto L_0x014a
            r3 = 33554432(0x2000000, double:1.6578092E-316)
            long r1 = r1 | r3
        L_0x014a:
            java.lang.String r0 = "rtt_calling_mode"
            boolean r0 = r6.cD(r0)
            if (r0 == 0) goto L_0x0156
            r3 = 67108864(0x4000000, double:3.31561842E-316)
            long r1 = r1 | r3
        L_0x0156:
            java.lang.String r0 = "accessibility_floating_menu_fade_enabled"
            boolean r0 = r6.cD(r0)
            if (r0 == 0) goto L_0x0162
            r3 = 134217728(0x8000000, double:6.63123685E-316)
            long r1 = r1 | r3
        L_0x0162:
            java.lang.String r0 = "accessibility_show_window_magnification_prompt"
            boolean r0 = r6.cD(r0)
            if (r0 == 0) goto L_0x016e
            r3 = 268435456(0x10000000, double:1.32624737E-315)
            long r1 = r1 | r3
        L_0x016e:
            java.lang.String r0 = "accessibility_floating_menu_migration_tooltip_prompt"
            boolean r0 = r6.cD(r0)
            if (r0 == 0) goto L_0x017a
            r3 = 536870912(0x20000000, double:2.652494739E-315)
            long r1 = r1 | r3
        L_0x017a:
            java.lang.String r0 = "accessibility_magnification_mode"
            int r0 = r6.cE(r0)
            r3 = 1
            if (r0 != 0) goto L_0x0188
            r4 = 1073741824(0x40000000, double:5.304989477E-315)
        L_0x0186:
            long r1 = r1 | r4
            goto L_0x01a2
        L_0x0188:
            if (r0 != r3) goto L_0x0190
            r4 = 2147483648(0x80000000, double:1.0609978955E-314)
            goto L_0x0186
        L_0x0190:
            r4 = 2
            if (r0 != r4) goto L_0x0199
            r4 = 4294967296(0x100000000, double:2.121995791E-314)
            goto L_0x0186
        L_0x0199:
            r4 = 3
            if (r0 != r4) goto L_0x01a2
            r4 = 8589934592(0x200000000, double:4.243991582E-314)
            goto L_0x0186
        L_0x01a2:
            java.lang.String r0 = "accessibility_button_mode"
            int r0 = r6.cE(r0)
            if (r0 != 0) goto L_0x01b1
            r4 = 17179869184(0x400000000, double:8.4879831639E-314)
        L_0x01af:
            long r1 = r1 | r4
            goto L_0x01b9
        L_0x01b1:
            if (r0 != r3) goto L_0x01b9
            r4 = 34359738368(0x800000000, double:1.69759663277E-313)
            goto L_0x01af
        L_0x01b9:
            java.lang.String r0 = "accessibility_floating_menu_size"
            int r0 = r6.cE(r0)
            if (r0 != 0) goto L_0x01c8
            r4 = 68719476736(0x1000000000, double:3.39519326554E-313)
        L_0x01c6:
            long r1 = r1 | r4
            goto L_0x01d0
        L_0x01c8:
            if (r0 != r3) goto L_0x01d0
            r4 = 137438953472(0x2000000000, double:6.7903865311E-313)
            goto L_0x01c6
        L_0x01d0:
            java.lang.String r0 = "accessibility_floating_menu_icon_type"
            int r0 = r6.cE(r0)
            if (r0 != 0) goto L_0x01df
            r3 = 274877906944(0x4000000000, double:1.358077306218E-312)
        L_0x01dd:
            long r1 = r1 | r3
            goto L_0x01e7
        L_0x01df:
            if (r0 != r3) goto L_0x01e7
            r3 = 549755813888(0x8000000000, double:2.716154612436E-312)
            goto L_0x01dd
        L_0x01e7:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.o.Dl():long");
    }

    private boolean cD(String str) {
        return cE(str) == 1;
    }

    private int cE(String str) {
        try {
            return Settings.Secure.getInt(this.E.getContentResolver(), str);
        } catch (Throwable unused) {
            return -1;
        }
    }

    private float Dm() {
        try {
            return Settings.System.getFloat(this.E.getContentResolver(), "font_scale");
        } catch (Settings.SettingNotFoundException e) {
            if (!x.Fn()) {
                return -1.0f;
            }
            this.logger.c("DataCollector", "Error collecting font scale", e);
            return -1.0f;
        }
    }

    private String Dn() {
        AudioManager audioManager = (AudioManager) this.E.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        if (audioManager == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        if (h.KY()) {
            for (AudioDeviceInfo m : audioManager.getDevices(2)) {
                sb.append(m.getType());
                sb.append(",");
            }
        } else {
            if (audioManager.isWiredHeadsetOn()) {
                sb.append("3,");
            }
            if (audioManager.isBluetoothScoOn()) {
                sb.append("7,");
            }
            if (audioManager.isBluetoothA2dpOn()) {
                sb.append(8);
            }
        }
        if (sb.length() > 0 && sb.charAt(sb.length() - 1) == ',') {
            sb.deleteCharAt(sb.length() - 1);
        }
        String sb2 = sb.toString();
        if (TextUtils.isEmpty(sb2) && x.Fn()) {
            this.logger.f("DataCollector", "No sound outputs detected");
        }
        return sb2;
    }

    private String Do() {
        if (!h.KZ()) {
            return null;
        }
        try {
            StringBuilder sb = new StringBuilder();
            LocaleList m = ComponentDialog$$ExternalSyntheticApiModelOutline0.m(this.E.getResources().getConfiguration());
            for (int i = 0; i < ColorKt$$ExternalSyntheticApiModelOutline0.m(m); i++) {
                sb.append(m.get(i));
                sb.append(",");
            }
            if (sb.length() > 0 && sb.charAt(sb.length() - 1) == ',') {
                sb.deleteCharAt(sb.length() - 1);
            }
            return sb.toString();
        } catch (Throwable unused) {
            return null;
        }
    }

    private Integer Dp() {
        AudioManager audioManager = (AudioManager) this.E.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        if (audioManager == null) {
            return null;
        }
        try {
            return Integer.valueOf((int) (((float) audioManager.getStreamVolume(3)) * ((Float) this.sdk.a(com.applovin.impl.sdk.c.b.aOQ)).floatValue()));
        } catch (Throwable th) {
            this.sdk.BN();
            if (x.Fn()) {
                this.sdk.BN().c("DataCollector", "Unable to collect device volume", th);
            }
            return null;
        }
    }

    private Boolean Dq() {
        AudioManager audioManager = (AudioManager) this.E.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        if (audioManager == null) {
            return null;
        }
        return Boolean.valueOf(audioManager.isMusicActive());
    }

    private Boolean Dr() {
        AudioManager audioManager = (AudioManager) this.E.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        if (audioManager == null) {
            return null;
        }
        return Boolean.valueOf(audioManager.isSpeakerphoneOn());
    }

    private double Ds() {
        return ((double) Math.round((((double) TimeZone.getDefault().getOffset(new Date().getTime())) * 10.0d) / 3600000.0d)) / 10.0d;
    }

    private boolean Dt() {
        SensorManager sensorManager = (SensorManager) this.E.getSystemService("sensor");
        return (sensorManager == null || sensorManager.getDefaultSensor(4) == null) ? false : true;
    }

    private String Du() {
        TelephonyManager telephonyManager = (TelephonyManager) this.E.getSystemService("phone");
        return telephonyManager != null ? telephonyManager.getSimCountryIso().toUpperCase(Locale.ENGLISH) : "";
    }

    private String Dv() {
        TelephonyManager telephonyManager = (TelephonyManager) this.E.getSystemService("phone");
        if (telephonyManager == null) {
            return "";
        }
        try {
            String networkOperator = telephonyManager.getNetworkOperator();
            return networkOperator.substring(0, Math.min(3, networkOperator.length()));
        } catch (Throwable th) {
            if (!x.Fn()) {
                return "";
            }
            this.logger.c("DataCollector", "Unable to collect mobile country code", th);
            return "";
        }
    }

    private String Dw() {
        TelephonyManager telephonyManager = (TelephonyManager) this.E.getSystemService("phone");
        if (telephonyManager == null) {
            return "";
        }
        try {
            String networkOperator = telephonyManager.getNetworkOperator();
            return networkOperator.substring(Math.min(3, networkOperator.length()));
        } catch (Throwable th) {
            if (!x.Fn()) {
                return "";
            }
            this.logger.c("DataCollector", "Unable to collect mobile network code", th);
            return "";
        }
    }

    private String Dx() {
        TelephonyManager telephonyManager = (TelephonyManager) this.E.getSystemService("phone");
        if (telephonyManager == null) {
            return "";
        }
        try {
            return telephonyManager.getNetworkOperatorName();
        } catch (Throwable th) {
            if (!x.Fn()) {
                return "";
            }
            this.logger.c("DataCollector", "Unable to collect carrier", th);
            return "";
        }
    }

    private boolean Dy() {
        try {
            return DB() || DC();
        } catch (Throwable unused) {
            return false;
        }
    }

    private Boolean Dz() {
        if (!h.La()) {
            return null;
        }
        return Boolean.valueOf(this.E.getResources().getConfiguration().isScreenHdr());
    }

    private String[] DA() {
        if (!h.KX()) {
            return null;
        }
        return Build.SUPPORTED_ABIS;
    }

    private boolean DB() {
        String str = Build.TAGS;
        return str != null && str.contains(cF("lz}$blpz"));
    }

    private boolean DC() {
        String[] strArr = {"&zpz}ld&hyy&Z|yl{|zl{'hyb", "&zk`g&z|", "&zpz}ld&k`g&z|", "&zpz}ld&qk`g&z|", "&mh}h&efjhe&qk`g&z|", "&mh}h&efjhe&k`g&z|", "&zpz}ld&zm&qk`g&z|", "&zpz}ld&k`g&oh`ezhol&z|", "&mh}h&efjhe&z|"};
        for (int i = 0; i < 9; i++) {
            if (new File(cF(strArr[i])).exists()) {
                return true;
            }
        }
        return false;
    }

    private String cF(String str) {
        int length = str.length();
        int[] iArr = {11, 12, 10, 3, 2, 1, 15, 10, 15, 14};
        char[] cArr = new char[length];
        for (int i = 0; i < length; i++) {
            cArr[i] = str.charAt(i);
            for (int i2 = 9; i2 >= 0; i2--) {
                cArr[i] = (char) (cArr[i] ^ iArr[i2]);
            }
        }
        return new String(cArr);
    }

    public void DD() {
        this.sdk.BO().a((com.applovin.impl.sdk.e.d) new com.applovin.impl.sdk.e.i(this.sdk, new i.a() {
            public void b(d.a aVar) {
                o.aDd.set(aVar);
            }
        }), q.b.ADVERTISING_INFO_COLLECTION);
        this.sdk.BO().a((com.applovin.impl.sdk.e.d) new ab(this.sdk, true, "setDeviceVolume", new o$$ExternalSyntheticLambda5(this)), q.b.CACHING_OTHER);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void DE() {
        this.aDe.set(Dp());
    }

    public static class a {
        public final int aDh;

        /* renamed from: do  reason: not valid java name */
        public final String f15do;

        public a(String str, int i) {
            this.f15do = str;
            this.aDh = i;
        }
    }
}
