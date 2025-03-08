package com.ironsource;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.support.v4.media.session.PlaybackStateCompat;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.applovin.sdk.AppLovinEventTypes;
import com.fyber.inneractive.sdk.external.InneractiveMediationNameConsts;
import com.ironsource.mediationsdk.config.ConfigFile;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.p;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

public class r4 implements Runnable {
    public static final String K = "sdkVersion";
    public static final String L = "AdvIdOptOutReason";
    private static final int M = 15;
    private static final int N = 840;
    private static final int O = -720;
    private final String A = "mnc";
    private final String B = "icc";
    private final String C = "tz";
    private final String D = "auid";
    private final String E = "userLat";
    private final String F = "publisherAPI";
    private final String G = "missingDependencies";
    private final String H = "missingManifest";
    private final String I = InneractiveMediationNameConsts.OTHER;
    private Context J;
    private final String a = getClass().getSimpleName();
    private final String b = "bundleId";
    private final String c = jc.h1;
    private final String d = "isLimitAdTrackingEnabled";
    private final String e = "appKey";
    private final String f = jc.p0;
    private final String g = "osVersion";
    private final String h = "connectionType";
    private final String i = "language";
    private final String j = "deviceOEM";
    private final String k = "deviceModel";
    private final String l = "mobileCarrier";
    private final String m = "externalFreeMemory";
    private final String n = "internalFreeMemory";
    private final String o = "battery";
    private final String p = "gmtMinutesOffset";
    private final String q = "appVersion";
    private final String r = "sessionId";
    private final String s = "pluginType";
    private final String t = "pluginVersion";
    private final String u = "plugin_fw_v";
    private final String v = "jb";
    private final String w = "advertisingIdType";
    private final String x = "mt";
    private final String y = "firstSession";
    private final String z = "mcc";

    private r4() {
    }

    public r4(Context context) {
        this.J = context.getApplicationContext();
    }

    private String a(String str) {
        return TextUtils.isEmpty(str) ? "missingDependencies" : !j3.a.b() ? "publisherAPI" : !m3.E(this.J) ? "missingManifest" : Boolean.parseBoolean(str) ? "userLat" : InneractiveMediationNameConsts.OTHER;
    }

    private Map<String, Object> a() {
        boolean z2;
        String str;
        HashMap hashMap = new HashMap();
        hashMap.put("sessionId", IronSourceUtils.getSessionId());
        String e2 = e();
        if (!TextUtils.isEmpty(e2)) {
            hashMap.put("bundleId", e2);
            String b2 = k0.b(this.J, e2);
            if (!TextUtils.isEmpty(b2)) {
                hashMap.put("appVersion", b2);
            }
        }
        hashMap.put("appKey", c());
        String N2 = m3.N(this.J);
        String O2 = m3.O(this.J);
        boolean z3 = false;
        if (!TextUtils.isEmpty(N2)) {
            str = IronSourceConstants.TYPE_GAID;
            z2 = false;
        } else {
            N2 = m3.z(this.J);
            z2 = true;
            str = !TextUtils.isEmpty(N2) ? IronSourceConstants.TYPE_UUID : "";
        }
        if (!TextUtils.isEmpty(N2)) {
            hashMap.put(jc.h1, N2);
            hashMap.put("advertisingIdType", str);
        }
        if (!TextUtils.isEmpty(O2)) {
            z3 = Boolean.parseBoolean(O2);
            hashMap.put("isLimitAdTrackingEnabled", Boolean.valueOf(z3));
        }
        if (z2 || z3) {
            hashMap.put(L, a(O2));
        }
        hashMap.put(jc.p0, h());
        if (!TextUtils.isEmpty(b())) {
            hashMap.put("osVersion", b());
        }
        String connectionType = IronSourceUtils.getConnectionType(this.J);
        if (!TextUtils.isEmpty(connectionType)) {
            hashMap.put("connectionType", connectionType);
        }
        hashMap.put("sdkVersion", r());
        String l2 = l();
        if (!TextUtils.isEmpty(l2)) {
            hashMap.put("language", l2);
        }
        String g2 = g();
        if (!TextUtils.isEmpty(g2)) {
            hashMap.put("deviceOEM", g2);
        }
        String f2 = f();
        if (!TextUtils.isEmpty(f2)) {
            hashMap.put("deviceModel", f2);
        }
        String n2 = n();
        if (!TextUtils.isEmpty(n2)) {
            hashMap.put("mobileCarrier", n2);
        }
        hashMap.put("internalFreeMemory", Long.valueOf(k()));
        hashMap.put("externalFreeMemory", Long.valueOf(i()));
        hashMap.put("battery", Integer.valueOf(d()));
        int j2 = j();
        if (a(j2)) {
            hashMap.put("gmtMinutesOffset", Integer.valueOf(j2));
        }
        String p2 = p();
        if (!TextUtils.isEmpty(p2)) {
            hashMap.put("pluginType", p2);
        }
        String q2 = q();
        if (!TextUtils.isEmpty(q2)) {
            hashMap.put("pluginVersion", q2);
        }
        String o2 = o();
        if (!TextUtils.isEmpty(o2)) {
            hashMap.put("plugin_fw_v", o2);
        }
        String valueOf = String.valueOf(m3.s());
        if (!TextUtils.isEmpty(valueOf)) {
            hashMap.put("jb", valueOf);
        }
        String m2 = m();
        if (!TextUtils.isEmpty(m2)) {
            hashMap.put("mt", m2);
        }
        String valueOf2 = String.valueOf(IronSourceUtils.getFirstSession(this.J));
        if (!TextUtils.isEmpty(valueOf2)) {
            hashMap.put("firstSession", valueOf2);
        }
        String f3 = m3.f(this.J);
        if (!TextUtils.isEmpty(f3)) {
            hashMap.put("auid", f3);
        }
        hashMap.put("mcc", Integer.valueOf(k2.b(this.J)));
        hashMap.put("mnc", Integer.valueOf(k2.c(this.J)));
        String y2 = m3.y(this.J);
        if (!TextUtils.isEmpty(y2)) {
            hashMap.put("icc", y2);
        }
        String m3 = m3.m();
        if (!TextUtils.isEmpty(m3)) {
            hashMap.put("tz", m3);
        }
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose("collecting data for events: " + hashMap);
        return hashMap;
    }

    private boolean a(int i2) {
        return i2 <= N && i2 >= O && i2 % 15 == 0;
    }

    private String b() {
        try {
            String str = Build.VERSION.RELEASE;
            int i2 = Build.VERSION.SDK_INT;
            return "" + i2 + "(" + str + ")";
        } catch (Exception unused) {
            return "";
        }
    }

    private String c() {
        return p.o().p();
    }

    private int d() {
        try {
            Intent registerReceiver = this.J.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            int i2 = 0;
            int intExtra = registerReceiver != null ? registerReceiver.getIntExtra(AppLovinEventTypes.USER_COMPLETED_LEVEL, -1) : 0;
            if (registerReceiver != null) {
                i2 = registerReceiver.getIntExtra("scale", -1);
            }
            if (intExtra == -1 || i2 == -1) {
                return -1;
            }
            return (int) ((((float) intExtra) / ((float) i2)) * 100.0f);
        } catch (Exception e2) {
            IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.NATIVE;
            logger.logException(ironSourceTag, this.a + ":getBatteryLevel()", e2);
            return -1;
        }
    }

    private String e() {
        try {
            return this.J.getPackageName();
        } catch (Exception unused) {
            return "";
        }
    }

    private String f() {
        try {
            return Build.MODEL;
        } catch (Exception unused) {
            return "";
        }
    }

    private String g() {
        try {
            return Build.MANUFACTURER;
        } catch (Exception unused) {
            return "";
        }
    }

    private String h() {
        return m2.e;
    }

    private long i() {
        if (!s()) {
            return -1;
        }
        StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
        return (((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize())) / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
    }

    private int j() {
        try {
            TimeZone timeZone = TimeZone.getDefault();
            return Math.round((float) (((timeZone.getOffset(Calendar.getInstance(timeZone).getTimeInMillis()) / 1000) / 60) / 15)) * 15;
        } catch (Exception e2) {
            IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.NATIVE;
            logger.logException(ironSourceTag, this.a + ":getGmtMinutesOffset()", e2);
            return 0;
        }
    }

    private long k() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return (((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize())) / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
        } catch (Exception unused) {
            return -1;
        }
    }

    private String l() {
        try {
            return Locale.getDefault().getLanguage();
        } catch (Exception unused) {
            return "";
        }
    }

    private String m() {
        return p.o().r();
    }

    private String n() {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) this.J.getSystemService("phone");
            if (telephonyManager == null) {
                return "";
            }
            String networkOperatorName = telephonyManager.getNetworkOperatorName();
            return !networkOperatorName.equals("") ? networkOperatorName : "";
        } catch (Exception e2) {
            IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.NATIVE;
            logger.logException(ironSourceTag, this.a + ":getMobileCarrier()", e2);
            return "";
        }
    }

    private String o() {
        try {
            return ConfigFile.getConfigFile().getPluginFrameworkVersion();
        } catch (Exception e2) {
            IronSourceLoggerManager.getLogger().logException(IronSourceLogger.IronSourceTag.NATIVE, "getPluginFrameworkVersion()", e2);
            return "";
        }
    }

    private String p() {
        try {
            return ConfigFile.getConfigFile().getPluginType();
        } catch (Exception e2) {
            IronSourceLoggerManager.getLogger().logException(IronSourceLogger.IronSourceTag.NATIVE, "getPluginType()", e2);
            return "";
        }
    }

    private String q() {
        try {
            return ConfigFile.getConfigFile().getPluginVersion();
        } catch (Exception e2) {
            IronSourceLoggerManager.getLogger().logException(IronSourceLogger.IronSourceTag.NATIVE, "getPluginVersion()", e2);
            return "";
        }
    }

    private String r() {
        return IronSourceUtils.getSDKVersion();
    }

    private boolean s() {
        try {
            return Environment.getExternalStorageState().equals("mounted");
        } catch (Exception unused) {
            return false;
        }
    }

    public void run() {
        try {
            q4.a().a(a());
        } catch (Exception e2) {
            IronSourceLoggerManager logger = IronSourceLoggerManager.getLogger();
            IronSourceLogger.IronSourceTag ironSourceTag = IronSourceLogger.IronSourceTag.NATIVE;
            logger.logException(ironSourceTag, "Thread name = " + getClass().getSimpleName(), e2);
        }
    }
}
