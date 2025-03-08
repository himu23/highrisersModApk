package com.ironsource;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Paint;
import android.media.AudioManager;
import android.os.Build;
import android.os.Environment;
import android.os.PowerManager;
import android.os.StatFs;
import android.provider.Settings;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.applovin.sdk.AppLovinEventTypes;
import com.ironsource.environment.ContextProvider;
import com.ironsource.environment.IronSourceSharedPreferencesUtilities;
import com.ironsource.gc;
import com.ironsource.m2;
import com.unity3d.ads.core.data.datasource.AndroidStaticDeviceInfoDataSource;
import com.unity3d.services.core.device.MimeTypes;
import java.io.File;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.UUID;

public class m3 {
    private static volatile String A = null;
    private static final String a = "android";
    private static final String b = "com.google.android.gms.permission.AD_ID";
    private static final String c = "com.google.android.gms.ads.identifier.AdvertisingIdClient";
    private static final String d = "com.google.android.gms.appset.AppSet";
    private static final String e = "com.google.android.gms.tasks.OnSuccessListener";
    private static final String f = "getAdvertisingIdInfo";
    private static final String g = "getClient";
    private static final String h = "getAppSetIdInfo";
    private static final String i = "addOnSuccessListener";
    private static final String j = "getId";
    private static final String k = "isLimitAdTrackingEnabled";
    private static final String l = "Mediation_Shared_Preferences";
    private static final String m = "supersonic_shared_preferen";
    public static final String n = "uuidEnabled";
    private static final String o = "cachedUUID";
    private static final String p = "auid";
    private static final String q = "browser_user_agent";
    private static final String r = "browser_user_agent_time";
    private static final String s = "IABTCF_gdprApplies";
    private static final String t = "IABTCF_TCString";
    private static String u = null;
    private static String v = null;
    /* access modifiers changed from: private */
    public static String w = "";
    public static boolean x = false;
    /* access modifiers changed from: private */
    public static String y = "";
    private static volatile String z;

    class a implements InvocationHandler {
        a() {
        }

        public Object invoke(Object obj, Method method, Object[] objArr) {
            Object obj2;
            if (objArr == null) {
                return null;
            }
            try {
                if (objArr.length <= 0 || (obj2 = objArr[0]) == null) {
                    return null;
                }
                String obj3 = obj2.getClass().getMethod(m3.j, new Class[0]).invoke(objArr[0], new Object[0]).toString();
                if (TextUtils.isEmpty(obj3)) {
                    return null;
                }
                String unused = m3.y = obj3;
                return null;
            } catch (Exception unused2) {
                return null;
            }
        }
    }

    class b implements Runnable {
        final /* synthetic */ Context a;
        final /* synthetic */ long b;

        b(Context context, long j) {
            this.a = context;
            this.b = j;
        }

        public void run() {
            try {
                WebView webView = new WebView(this.a);
                webView.setLayerType(1, (Paint) null);
                String unused = m3.w = webView.getSettings().getUserAgentString();
                webView.destroy();
                m3.a(this.a, m3.w);
                if (this.b > 0) {
                    m3.a(this.a, System.currentTimeMillis());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static int A(Context context) {
        if (context != null) {
            return Settings.System.getInt(context.getContentResolver(), "screen_brightness", -1);
        }
        return -1;
    }

    public static float B(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        try {
            return ((float) audioManager.getStreamVolume(3)) / ((float) audioManager.getStreamMaxVolume(3));
        } catch (Exception e2) {
            e2.printStackTrace();
            return -1.0f;
        }
    }

    public static String C(Context context) {
        try {
            return IronSourceSharedPreferencesUtilities.getStringFromDefaultSharedPrefs(context, t, (String) null);
        } catch (Exception unused) {
            return null;
        }
    }

    public static long D(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        if (activityManager == null) {
            return -1;
        }
        activityManager.getMemoryInfo(memoryInfo);
        return memoryInfo.totalMem;
    }

    public static boolean E(Context context) {
        try {
            for (String equalsIgnoreCase : context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions) {
                if (equalsIgnoreCase.equalsIgnoreCase(b)) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean F(Context context) {
        try {
            return Settings.System.getInt(context.getContentResolver(), "airplane_mode_on", 0) != 0;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean G(Context context) {
        Intent registerReceiver = context.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        int i2 = -1;
        if (registerReceiver != null) {
            i2 = registerReceiver.getIntExtra("status", -1);
        }
        return i2 == 2 || i2 == 5;
    }

    public static boolean H(Context context) {
        return Settings.System.getInt(context.getContentResolver(), "accelerometer_rotation", 0) != 1;
    }

    public static boolean I(Context context) {
        try {
            return ((PowerManager) context.getSystemService("power")).isPowerSaveMode();
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean J(Context context) {
        return context.getResources().getConfiguration().getLayoutDirection() == 1;
    }

    public static boolean K(Context context) {
        try {
            return Settings.Global.getInt(context.getContentResolver(), "stay_on_while_plugged_in", 0) != 0;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    static String L(Context context) {
        try {
            return IronSourceSharedPreferencesUtilities.getStringFromSharedPrefs(context, l, q, "");
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    static long M(Context context) {
        try {
            return Long.parseLong(IronSourceSharedPreferencesUtilities.getStringFromSharedPrefs(context, l, r, String.valueOf(-1)));
        } catch (Exception e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    public static String N(Context context) {
        j3 j3Var = j3.a;
        if (j3Var.b()) {
            try {
                if (!j3Var.a()) {
                    return d(context);
                }
                if (A != null) {
                    return A;
                }
                String d2 = d(context);
                try {
                    if (TextUtils.isEmpty(d2)) {
                        return d2;
                    }
                    A = d2;
                    return d2;
                } catch (Exception unused) {
                    return d2;
                }
            } catch (Exception unused2) {
            }
        }
        return null;
    }

    public static String O(Context context) {
        try {
            if (!j3.a.a()) {
                return w(context);
            }
            if (z != null) {
                return z;
            }
            String w2 = w(context);
            try {
                if (TextUtils.isEmpty(w2)) {
                    return w2;
                }
                z = w2;
                return w2;
            } catch (Exception unused) {
                return w2;
            }
        } catch (Exception unused2) {
            return null;
        }
    }

    public static String P(Context context) {
        if (j3.a.c()) {
            try {
                e(context);
                if (!TextUtils.isEmpty(y)) {
                    return y;
                }
            } catch (Exception unused) {
            }
        }
        return "";
    }

    public static int a(Context context) {
        Intent registerReceiver = context.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver != null) {
            return registerReceiver.getIntExtra("plugged", -1);
        }
        return -1;
    }

    private static long a(File file) {
        StatFs statFs = new StatFs(file.getPath());
        return (statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong()) / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
    }

    static void a(Context context, long j2) {
        try {
            IronSourceSharedPreferencesUtilities.saveStringToSharedPrefs(context, l, r, String.valueOf(j2));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    static void a(Context context, String str) {
        try {
            IronSourceSharedPreferencesUtilities.saveStringToSharedPrefs(context, l, q, str);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static boolean a(Activity activity) {
        int systemUiVisibility = activity.getWindow().getDecorView().getSystemUiVisibility();
        return (systemUiVisibility | 4096) == systemUiVisibility || (systemUiVisibility | 2048) == systemUiVisibility;
    }

    public static int b() {
        return Build.VERSION.SDK_INT;
    }

    public static int b(Context context) {
        if (context instanceof Activity) {
            return ((Activity) context).getRequestedOrientation();
        }
        return -1;
    }

    public static void b(Context context, long j2) {
        if (context != null) {
            if (!new qc(new gc.a()).a(M(context), j2)) {
                String L = L(context);
                w = L;
                x = !L.isEmpty();
            }
            if (w.isEmpty()) {
                try {
                    String defaultUserAgent = WebSettings.getDefaultUserAgent(context);
                    w = defaultUserAgent;
                    a(context, defaultUserAgent);
                    if (j2 > 0) {
                        a(context, System.currentTimeMillis());
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public static String c() {
        return Build.VERSION.RELEASE;
    }

    public static String c(Context context) {
        if (context == null) {
            return "";
        }
        int b2 = b(context);
        if (b2 != 0) {
            if (b2 != 1) {
                if (b2 != 11) {
                    if (b2 != 12) {
                        switch (b2) {
                            case 6:
                            case 8:
                                break;
                            case 7:
                            case 9:
                                break;
                            default:
                                return "none";
                        }
                    }
                }
            }
            return m2.h.D;
        }
        return m2.h.C;
    }

    private static boolean c(String str) {
        try {
            String[] strArr = {"/sbin/", "/system/bin/", "/system/xbin/", "/data/local/xbin/", "/data/local/bin/", "/system/sd/xbin/", "/system/bin/failsafe/", "/data/local/"};
            for (int i2 = 0; i2 < 8; i2++) {
                String str2 = strArr[i2];
                if (new File(str2 + str).exists()) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static long d() {
        if (r()) {
            return a(Environment.getExternalStorageDirectory());
        }
        return 0;
    }

    public static long d(String str) {
        return a(new File(str));
    }

    private static String d(Context context) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Object r2 = r(context);
        return r2.getClass().getMethod(j, new Class[0]).invoke(r2, new Object[0]).toString();
    }

    public static long e() {
        return a(Environment.getDataDirectory());
    }

    private static void e(Context context) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<?> cls = Class.forName(d);
        Object invoke = cls.getMethod(g, new Class[]{Context.class}).invoke(cls, new Object[]{context});
        Object invoke2 = invoke.getClass().getMethod(h, new Class[0]).invoke(invoke, new Object[0]);
        Class<?> cls2 = Class.forName(e);
        Object newProxyInstance = Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{cls2}, new a());
        invoke2.getClass().getMethod(i, new Class[]{cls2}).invoke(invoke2, new Object[]{newProxyInstance});
    }

    public static String f() {
        try {
            return w.isEmpty() ? L(ContextProvider.getInstance().getApplicationContext()) : w;
        } catch (Exception unused) {
            return "";
        }
    }

    public static synchronized String f(Context context) {
        synchronized (m3.class) {
            if (!TextUtils.isEmpty(v)) {
                String str = v;
                return str;
            } else if (context == null) {
                return "";
            } else {
                String stringFromSharedPrefs = IronSourceSharedPreferencesUtilities.getStringFromSharedPrefs(context, "supersonic_shared_preferen", "auid", "");
                v = stringFromSharedPrefs;
                if (TextUtils.isEmpty(stringFromSharedPrefs)) {
                    String uuid = UUID.randomUUID().toString();
                    v = uuid;
                    IronSourceSharedPreferencesUtilities.saveStringToSharedPrefs(context, "supersonic_shared_preferen", "auid", uuid);
                }
                String str2 = v;
                return str2;
            }
        }
    }

    public static float g() {
        return Resources.getSystem().getDisplayMetrics().density;
    }

    public static int g(Context context) {
        return ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRotation();
    }

    public static int h() {
        return p();
    }

    public static int h(Context context) {
        try {
            Intent registerReceiver = context.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
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
            e2.printStackTrace();
            return -1;
        }
    }

    public static long i() {
        return Calendar.getInstance(TimeZone.getDefault()).getTime().getTime();
    }

    public static String i(Context context) {
        return Locale.getDefault().toString();
    }

    public static int j(Context context) {
        int g2 = g(context);
        int m2 = m(context);
        return (((g2 == 0 || g2 == 2) && m2 == 2) || ((g2 == 1 || g2 == 3) && m2 == 1)) ? 2 : 1;
    }

    public static String j() {
        return Build.MODEL;
    }

    public static String k() {
        return Build.MANUFACTURER;
    }

    public static String k(Context context) throws Exception {
        return context.getResources().getConfiguration().locale.getLanguage();
    }

    public static String l() {
        return "android";
    }

    public static String l(Context context) throws Exception {
        return context.getResources().getConfiguration().locale.getCountry();
    }

    public static int m(Context context) {
        return context.getResources().getConfiguration().orientation;
    }

    public static String m() {
        String id = TimeZone.getDefault().getID();
        return id != null ? id : "";
    }

    public static int n() {
        return -(TimeZone.getDefault().getOffset(i()) / 60000);
    }

    public static String n(Context context) {
        return v(context) ? "Tablet" : "Phone";
    }

    public static int o() {
        return q();
    }

    public static File o(Context context) {
        return context.getExternalCacheDir();
    }

    public static int p() {
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }

    public static File p(Context context) {
        return context.getExternalFilesDir((String) null);
    }

    public static int q() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    public static int q(Context context) {
        try {
            return IronSourceSharedPreferencesUtilities.getIntFromDefaultSharedPrefs(context, s, -1);
        } catch (Exception unused) {
            return -1;
        }
    }

    private static Object r(Context context) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<?> cls = Class.forName(c);
        return cls.getMethod(f, new Class[]{Context.class}).invoke(cls, new Object[]{context});
    }

    public static boolean r() {
        try {
            return "mounted".equals(Environment.getExternalStorageState()) && Environment.isExternalStorageRemovable();
        } catch (Exception unused) {
            return false;
        }
    }

    public static List<ApplicationInfo> s(Context context) {
        return context.getPackageManager().getInstalledApplications(0);
    }

    public static boolean s() {
        return c(AndroidStaticDeviceInfoDataSource.BINARY_SU);
    }

    public static File t(Context context) {
        return context.getCacheDir();
    }

    public static File u(Context context) {
        return context.getFilesDir();
    }

    public static boolean v(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager == null) {
            return false;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return ((float) displayMetrics.widthPixels) / displayMetrics.density >= 600.0f;
    }

    private static String w(Context context) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Object r2 = r(context);
        return String.valueOf(((Boolean) r2.getClass().getMethod("isLimitAdTrackingEnabled", new Class[0]).invoke(r2, new Object[0])).booleanValue());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r2 = (android.telephony.TelephonyManager) r2.getSystemService("phone");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String x(android.content.Context r2) {
        /*
            java.lang.String r0 = ""
            if (r2 == 0) goto L_0x0012
            java.lang.String r1 = "phone"
            java.lang.Object r2 = r2.getSystemService(r1)
            android.telephony.TelephonyManager r2 = (android.telephony.TelephonyManager) r2
            if (r2 == 0) goto L_0x0012
            java.lang.String r0 = r2.getNetworkOperatorName()
        L_0x0012:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.m3.x(android.content.Context):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r2 = (android.telephony.TelephonyManager) r2.getSystemService("phone");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String y(android.content.Context r2) {
        /*
            java.lang.String r0 = ""
            if (r2 == 0) goto L_0x0012
            java.lang.String r1 = "phone"
            java.lang.Object r2 = r2.getSystemService(r1)
            android.telephony.TelephonyManager r2 = (android.telephony.TelephonyManager) r2
            if (r2 == 0) goto L_0x0012
            java.lang.String r0 = r2.getNetworkCountryIso()
        L_0x0012:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.m3.y(android.content.Context):java.lang.String");
    }

    public static synchronized String z(Context context) {
        synchronized (m3.class) {
            if (!TextUtils.isEmpty(u)) {
                String str = u;
                return str;
            }
            if (IronSourceSharedPreferencesUtilities.getBooleanFromSharedPrefs(context, l, n, true)) {
                String stringFromSharedPrefs = IronSourceSharedPreferencesUtilities.getStringFromSharedPrefs(context, l, o, "");
                if (TextUtils.isEmpty(stringFromSharedPrefs)) {
                    String uuid = UUID.randomUUID().toString();
                    u = uuid;
                    IronSourceSharedPreferencesUtilities.saveStringToSharedPrefs(context, l, o, uuid);
                } else {
                    u = stringFromSharedPrefs;
                }
            }
            String str2 = u;
            return str2;
        }
    }
}
