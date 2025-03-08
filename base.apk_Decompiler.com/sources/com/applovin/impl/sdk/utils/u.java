package com.applovin.impl.sdk.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.graphics.Color;
import android.icu.util.VersionInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.Toast;
import com.applovin.exoplayer2.ak;
import com.applovin.impl.mediation.e.c;
import com.applovin.impl.sdk.AppLovinAdBase;
import com.applovin.impl.sdk.ad.AppLovinAdImpl;
import com.applovin.impl.sdk.ad.d;
import com.applovin.impl.sdk.ad.e;
import com.applovin.impl.sdk.ad.f;
import com.applovin.impl.sdk.c.b;
import com.applovin.impl.sdk.e.ab;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.x;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.MaxNetworkResponseInfo;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import com.applovin.sdk.AppLovinSdkSettings;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.AppLovinWebViewActivity;
import com.fyber.inneractive.sdk.external.InneractiveMediationDefs;
import com.ironsource.m2;
import com.ironsource.z3;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.net.HttpURLConnection;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import org.json.JSONObject;

public abstract class u {
    private static final String[] aWn = {" second ago", " minute ago", " hour ago", " day ago", " week ago", " month ago"};
    private static final String[] aWo = {" seconds ago", " minutes ago", " hours ago", " days ago", " weeks ago", " months ago"};
    private static final String[] aWp = {"s", InneractiveMediationDefs.GENDER_MALE, "h", "d", "w", "mth"};
    private static final int[] aWq = {60, 60, 24, 7, 4, 12};
    private static final DecimalFormat aWr = new DecimalFormat();
    private static Boolean aWs;
    private static Boolean aWt;

    public interface a {
        void onCachedResourcesChecked(boolean z);
    }

    public static float A(float f) {
        return f * 1000.0f;
    }

    public static boolean E(long j, long j2) {
        return (j & j2) != 0;
    }

    public static int LC() {
        return 2015001;
    }

    public static void LE() {
    }

    public static void LF() {
    }

    public static double bY(long j) {
        return ((double) j) / 1000.0d;
    }

    public static long bZ(long j) {
        return j * 8;
    }

    public static double ca(long j) {
        return ((double) j) / 1024.0d;
    }

    public static int gX(int i) {
        return i * 1024;
    }

    public static boolean Lw() {
        Context applicationContext = n.getApplicationContext();
        if (applicationContext != null) {
            return e.X(applicationContext).dy("applovin.sdk.verbose_logging");
        }
        return false;
    }

    public static boolean ae(Context context) {
        if (context == null) {
            context = n.getApplicationContext();
        }
        if (context != null) {
            return e.X(context).e("applovin.sdk.verbose_logging", false);
        }
        return false;
    }

    public static String dD(String str) {
        return (str == null || str.length() <= 4) ? "NOKEY" : str.substring(str.length() - 4);
    }

    public static String b(Map<String, String> map, boolean z) {
        if (map == null || map.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        if (z) {
            TreeMap treeMap = new TreeMap(new Comparator<String>() {
                /* renamed from: M */
                public int compare(String str, String str2) {
                    return str.compareToIgnoreCase(str2);
                }
            });
            treeMap.putAll(map);
            map = treeMap;
        }
        for (Map.Entry next : map.entrySet()) {
            if (sb.length() > 0) {
                sb.append(m2.i.c);
            }
            Object value = next.getValue();
            if (value instanceof String) {
                String str = (String) value;
                if (str.contains(m2.i.c)) {
                    value = str.replace(m2.i.c, "%26");
                }
            }
            sb.append(next.getKey());
            sb.append(z3.R);
            sb.append(value);
        }
        return sb.toString();
    }

    public static Map<String, String> s(Map<String, Object> map) {
        HashMap hashMap = new HashMap();
        if (map != null && !map.isEmpty()) {
            for (Map.Entry next : map.entrySet()) {
                hashMap.put((String) next.getKey(), String.valueOf(next.getValue()));
            }
        }
        return hashMap;
    }

    public static boolean d(String str, List<String> list) {
        return StringUtils.startsWithAtLeastOnePrefix(str, list);
    }

    public static int U(JSONObject jSONObject) {
        int i = JsonUtils.getInt(jSONObject, "video_completion_percent", -1);
        if (i < 0 || i > 100) {
            return 95;
        }
        return i;
    }

    public static long N(n nVar) {
        long longValue = ((Long) nVar.a(b.aQg)).longValue();
        long longValue2 = ((Long) nVar.a(b.aQh)).longValue();
        long currentTimeMillis = System.currentTimeMillis();
        return (longValue <= 0 || longValue2 <= 0) ? currentTimeMillis : currentTimeMillis + (longValue - longValue2);
    }

    public static void a(String str, String str2, Map<String, Object> map) {
        if (map.containsKey(str)) {
            map.put(str2, map.get(str));
            map.remove(str);
        }
    }

    private static long B(float f) {
        return (long) Math.round(f);
    }

    public static long C(float f) {
        return B(A(f));
    }

    public static String i(long j, boolean z) {
        String[] strArr = z ? aWn : aWp;
        String[] strArr2 = z ? aWo : aWp;
        long currentTimeMillis = (System.currentTimeMillis() - j) / 1000;
        int i = 0;
        while (i < strArr.length) {
            int i2 = aWq[i];
            if (currentTimeMillis >= ((long) i2)) {
                currentTimeMillis /= (long) i2;
                i++;
            } else if (currentTimeMillis <= 0) {
                return z ? "just now" : "now";
            } else {
                Object[] objArr = new Object[2];
                if (currentTimeMillis == 1) {
                    objArr[0] = Long.valueOf(currentTimeMillis);
                    objArr[1] = strArr[i];
                    return String.format("%d%s", objArr);
                }
                objArr[0] = Long.valueOf(currentTimeMillis);
                objArr[1] = strArr2[i];
                return String.format("%d%s", objArr);
            }
        }
        return z ? "just now" : "now";
    }

    public static double a(String str, double d) {
        try {
            return Double.parseDouble(str);
        } catch (Throwable th) {
            x.e("Utils", "Failed to parse double from String: " + str, th);
            return d;
        }
    }

    public static String a(Uri uri, String str, n nVar) {
        if (((Boolean) nVar.a(b.aLX)).booleanValue()) {
            List<String> b = nVar.b(b.aLO);
            String lastPathSegment = uri.getLastPathSegment();
            if (b.contains(lastPathSegment)) {
                return lastPathSegment;
            }
        }
        ArrayList arrayList = new ArrayList();
        for (String queryParameter : uri.getQueryParameterNames()) {
            String queryParameter2 = uri.getQueryParameter(queryParameter);
            if (StringUtils.isValidString(queryParameter2)) {
                arrayList.add(queryParameter2);
            }
        }
        arrayList.addAll(uri.getPathSegments());
        String encodeUriString = StringUtils.encodeUriString(TextUtils.join("_", arrayList));
        Integer num = (Integer) nVar.a(b.aLP);
        int length = StringUtils.emptyIfNull(encodeUriString).length() + StringUtils.emptyIfNull(str).length();
        if (length > num.intValue() && StringUtils.isValidString(encodeUriString)) {
            encodeUriString = encodeUriString.substring(length - num.intValue());
        }
        if (!StringUtils.isValidString(encodeUriString) || !StringUtils.isValidString(str)) {
            return encodeUriString;
        }
        return str + encodeUriString;
    }

    public static void N(String str, String str2) {
        if (str != null && str.length() > gX(8)) {
            x.F(str2, "Provided custom data parameter longer than supported (" + str.length() + " bytes, " + gX(8) + " maximum)");
        }
    }

    public static double cb(long j) {
        return ca(bZ(j));
    }

    public static Activity a(View view, n nVar) {
        if (view == null) {
            return null;
        }
        int i = 0;
        while (i < 1000) {
            i++;
            try {
                Context context = view.getContext();
                if (context instanceof Activity) {
                    return (Activity) context;
                }
                ViewParent parent = view.getParent();
                if (!(parent instanceof View)) {
                    return null;
                }
                view = (View) parent;
            } catch (Throwable th) {
                nVar.BN();
                if (x.Fn()) {
                    nVar.BN().c("Utils", "Encountered error while retrieving activity from view", th);
                }
            }
        }
        return null;
    }

    public static void a(String str, MaxAdFormat maxAdFormat, JSONObject jSONObject, n nVar) {
        if (jSONObject.has("no_fill_reason")) {
            Object object = JsonUtils.getObject(jSONObject, "no_fill_reason", new Object());
            StringBuilder sb = new StringBuilder("\n**************************************************\nNO FILL received:\n..ID: \"");
            sb.append(str);
            sb.append("\"\n..FORMAT: \"");
            sb.append(maxAdFormat != null ? maxAdFormat.getLabel() : "None");
            sb.append("\"\n..SDK KEY: \"");
            sb.append(nVar.getSdkKey());
            sb.append("\"\n..PACKAGE NAME: \"");
            sb.append(n.getApplicationContext().getPackageName());
            sb.append("\"\n..Reason: ");
            sb.append(object);
            sb.append("\n**************************************************\n");
            String sb2 = sb.toString();
            nVar.BN();
            if (x.Fn()) {
                nVar.BN().i("AppLovinSdk", sb2);
            }
        }
    }

    public static AppLovinAd a(AppLovinAd appLovinAd, n nVar) {
        if (!(appLovinAd instanceof f)) {
            return appLovinAd;
        }
        f fVar = (f) appLovinAd;
        AppLovinAd dequeueAd = nVar.BD().dequeueAd(fVar.getAdZone());
        nVar.BN();
        if (x.Fn()) {
            x BN = nVar.BN();
            BN.f("Utils", "Dequeued ad for dummy ad: " + dequeueAd);
        }
        if (dequeueAd == null) {
            return fVar.HB();
        }
        fVar.e(dequeueAd);
        ((AppLovinAdImpl) dequeueAd).setDummyAd(fVar);
        return dequeueAd;
    }

    public static d l(JSONObject jSONObject, n nVar) {
        return d.a(AppLovinAdSize.fromString(JsonUtils.getString(jSONObject, "ad_size", (String) null)), AppLovinAdType.fromString(JsonUtils.getString(jSONObject, "ad_type", (String) null)), JsonUtils.getString(jSONObject, "zone_id", (String) null), true, JsonUtils.getBoolean(jSONObject, "is_direct_sold", false).booleanValue());
    }

    public static Field b(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Class superclass = cls.getSuperclass();
            if (superclass == null) {
                return null;
            }
            return b(superclass, str);
        }
    }

    public static String c(Class cls, String str) {
        try {
            Field b = b(cls, str);
            b.setAccessible(true);
            return (String) b.get((Object) null);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static List<com.applovin.impl.sdk.d.a> a(String str, JSONObject jSONObject, String str2, String str3, n nVar) {
        return a(str, jSONObject, str2, (Map<String, String>) null, str3, nVar);
    }

    public static List<com.applovin.impl.sdk.d.a> a(String str, JSONObject jSONObject, String str2, Map<String, String> map, String str3, n nVar) {
        return a(str, jSONObject, str2, map, str3, (Map<String, String>) null, false, nVar);
    }

    public static List<com.applovin.impl.sdk.d.a> a(String str, JSONObject jSONObject, String str2, Map<String, String> map, String str3, Map<String, String> map2, boolean z, n nVar) {
        if (map == null) {
            map = new HashMap<>(1);
        }
        Map<String, String> map3 = map;
        map3.put("{CLCODE}", str2);
        return a(str, jSONObject, map3, str3, map2, z, nVar);
    }

    public static List<com.applovin.impl.sdk.d.a> a(String str, JSONObject jSONObject, Map<String, String> map, String str2, Map<String, String> map2, boolean z, n nVar) {
        JSONObject jSONObject2 = JsonUtils.getJSONObject(jSONObject, str, new JSONObject());
        ArrayList arrayList = new ArrayList(jSONObject2.length() + 1);
        if (StringUtils.isValidString(str2)) {
            arrayList.add(new com.applovin.impl.sdk.d.a(str2, (String) null, map2, z));
        }
        if (jSONObject2.length() > 0) {
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                try {
                    String next = keys.next();
                    if (!TextUtils.isEmpty(next)) {
                        String optString = jSONObject2.optString(next);
                        String replace = StringUtils.replace(next, map);
                        if (!TextUtils.isEmpty(optString)) {
                            optString = StringUtils.replace(optString, map);
                        }
                        arrayList.add(new com.applovin.impl.sdk.d.a(replace, optString, map2, z));
                    }
                } catch (Throwable th) {
                    nVar.BN();
                    if (x.Fn()) {
                        nVar.BN().c("Utils", "Failed to create and add postback url.", th);
                    }
                }
            }
        }
        return arrayList;
    }

    public static boolean a(View view, Activity activity) {
        if (!(activity == null || view == null)) {
            Window window = activity.getWindow();
            if (window != null) {
                return c(view, window.getDecorView());
            }
            View findViewById = activity.findViewById(16908290);
            if (findViewById != null) {
                return c(view, findViewById.getRootView());
            }
        }
        return false;
    }

    public static boolean c(View view, View view2) {
        if (view == view2) {
            return true;
        }
        if (view2 instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view2;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                if (c(view, viewGroup.getChildAt(i))) {
                    return true;
                }
            }
        }
        return false;
    }

    public static View A(View view) {
        View rootView;
        if (view == null || (rootView = view.getRootView()) == null) {
            return null;
        }
        View findViewById = rootView.findViewById(16908290);
        return findViewById != null ? findViewById : rootView;
    }

    public static void b(AppLovinAd appLovinAd, n nVar) {
        if (appLovinAd instanceof AppLovinAdBase) {
            String sdkKey = nVar.getSdkKey();
            String sdkKey2 = ((AppLovinAdBase) appLovinAd).getSdk().getSdkKey();
            if (!sdkKey.equals(sdkKey2)) {
                x.H("AppLovinAd", "Ad was loaded from sdk with key: " + sdkKey2 + ", but is being rendered from sdk with key: " + sdkKey);
                nVar.BR().a(com.applovin.impl.sdk.d.f.aTf);
            }
        }
    }

    public static Map<String, String> a(Map<String, String> map, n nVar) {
        Map<String, String> map2 = CollectionUtils.map(map);
        for (String next : map2.keySet()) {
            String str = map2.get(next);
            if (str != null) {
                map2.put(next, StringUtils.encodeUriString(str));
            }
        }
        return map2;
    }

    public static boolean a(Object obj, List<String> list, n nVar) {
        if (list == null) {
            return false;
        }
        for (Class isInstance : b(list, nVar)) {
            if (isInstance.isInstance(obj)) {
                if (obj instanceof Map) {
                    for (Map.Entry entry : ((Map) obj).entrySet()) {
                        if (!(entry.getKey() instanceof String)) {
                            nVar.BN();
                            if (x.Fn()) {
                                nVar.BN().f("Utils", "Invalid key type used. Map keys should be of type String.");
                            }
                            return false;
                        } else if (!a(entry.getValue(), list, nVar)) {
                            return false;
                        }
                    }
                    return true;
                } else if (!(obj instanceof List)) {
                    return true;
                } else {
                    for (Object a2 : (List) obj) {
                        if (!a(a2, list, nVar)) {
                            return false;
                        }
                    }
                    return true;
                }
            }
        }
        nVar.BN();
        if (x.Fn()) {
            x BN = nVar.BN();
            BN.f("Utils", "Object '" + obj + "' does not match any of the required types '" + list + "'.");
        }
        return false;
    }

    private static List<Class> b(List<String> list, n nVar) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (String next : list) {
            try {
                arrayList.add(Class.forName(next));
            } catch (ClassNotFoundException unused) {
                nVar.BN();
                if (x.Fn()) {
                    x BN = nVar.BN();
                    BN.i("Utils", "Failed to create class for name: " + next);
                }
            }
        }
        return arrayList;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x009a, code lost:
        r4 = ((java.lang.Integer) r5.a(com.applovin.impl.sdk.c.b.aLG)).intValue();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Object a(java.lang.Object r4, com.applovin.impl.sdk.n r5) {
        /*
            boolean r0 = r4 instanceof java.util.Map
            if (r0 == 0) goto L_0x003f
            java.util.Map r4 = (java.util.Map) r4
            java.util.HashMap r0 = new java.util.HashMap
            int r1 = r4.size()
            r0.<init>(r1)
            java.util.Set r4 = r4.entrySet()
            java.util.Iterator r4 = r4.iterator()
        L_0x0017:
            boolean r1 = r4.hasNext()
            if (r1 == 0) goto L_0x003e
            java.lang.Object r1 = r4.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r2 = r1.getKey()
            boolean r3 = r2 instanceof java.lang.String
            if (r3 == 0) goto L_0x002e
            java.lang.String r2 = (java.lang.String) r2
            goto L_0x0032
        L_0x002e:
            java.lang.String r2 = java.lang.String.valueOf(r2)
        L_0x0032:
            java.lang.Object r1 = r1.getValue()
            java.lang.Object r1 = a((java.lang.Object) r1, (com.applovin.impl.sdk.n) r5)
            r0.put(r2, r1)
            goto L_0x0017
        L_0x003e:
            return r0
        L_0x003f:
            boolean r0 = r4 instanceof java.util.List
            if (r0 == 0) goto L_0x0065
            java.util.List r4 = (java.util.List) r4
            java.util.ArrayList r0 = new java.util.ArrayList
            int r1 = r4.size()
            r0.<init>(r1)
            java.util.Iterator r4 = r4.iterator()
        L_0x0052:
            boolean r1 = r4.hasNext()
            if (r1 == 0) goto L_0x0064
            java.lang.Object r1 = r4.next()
            java.lang.Object r1 = a((java.lang.Object) r1, (com.applovin.impl.sdk.n) r5)
            r0.add(r1)
            goto L_0x0052
        L_0x0064:
            return r0
        L_0x0065:
            boolean r0 = r4 instanceof java.util.Date
            if (r0 == 0) goto L_0x0074
            java.util.Date r4 = (java.util.Date) r4
            long r4 = r4.getTime()
            java.lang.String r4 = java.lang.String.valueOf(r4)
            return r4
        L_0x0074:
            java.lang.String r0 = java.lang.String.valueOf(r4)
            boolean r1 = r4 instanceof java.lang.String
            r2 = 0
            if (r1 == 0) goto L_0x0096
            com.applovin.impl.sdk.c.b<java.lang.Integer> r4 = com.applovin.impl.sdk.c.b.aLF
            java.lang.Object r4 = r5.a(r4)
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            if (r4 <= 0) goto L_0x00b2
            int r5 = r0.length()
            if (r5 <= r4) goto L_0x00b2
            java.lang.String r0 = r0.substring(r2, r4)
            goto L_0x00b2
        L_0x0096:
            boolean r4 = r4 instanceof android.net.Uri
            if (r4 == 0) goto L_0x00b2
            com.applovin.impl.sdk.c.b<java.lang.Integer> r4 = com.applovin.impl.sdk.c.b.aLG
            java.lang.Object r4 = r5.a(r4)
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            if (r4 <= 0) goto L_0x00b2
            int r5 = r0.length()
            if (r5 <= r4) goto L_0x00b2
            java.lang.String r0 = r0.substring(r2, r4)
        L_0x00b2:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.utils.u.a(java.lang.Object, com.applovin.impl.sdk.n):java.lang.Object");
    }

    public static String af(Context context) {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.setPackage(context.getPackageName());
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
        if (!queryIntentActivities.isEmpty()) {
            return queryIntentActivities.get(0).activityInfo.name;
        }
        return null;
    }

    public static int ag(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager == null) {
            return 0;
        }
        return windowManager.getDefaultDisplay().getRotation();
    }

    public static boolean dE(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Class.forName(str);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean M(List<String> list) {
        for (String dE : list) {
            if (dE(dE)) {
                return true;
            }
        }
        return false;
    }

    public static boolean Lx() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [com.applovin.impl.sdk.c.b<java.lang.Boolean>, com.applovin.impl.sdk.c.b] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(com.applovin.impl.sdk.c.b<java.lang.Boolean> r2, com.applovin.impl.sdk.n r3) {
        /*
            com.applovin.sdk.AppLovinSdkSettings r0 = r3.getSettings()
            java.util.Map r0 = r0.getExtraParameters()
            java.lang.String r1 = "enable_black_screen_fixes"
            java.lang.Object r0 = r0.get(r1)
            java.lang.String r0 = (java.lang.String) r0
            boolean r1 = com.applovin.impl.sdk.utils.StringUtils.isValidString(r0)
            if (r1 == 0) goto L_0x001b
            boolean r2 = java.lang.Boolean.parseBoolean(r0)
            return r2
        L_0x001b:
            java.lang.Object r2 = r3.a(r2)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.utils.u.a(com.applovin.impl.sdk.c.b, com.applovin.impl.sdk.n):boolean");
    }

    public static void k(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setPriority(1);
        thread.start();
    }

    public static long dF(String str) {
        if (!StringUtils.isValidString(str)) {
            return Long.MAX_VALUE;
        }
        try {
            return (long) Color.parseColor(str);
        } catch (Throwable unused) {
            return Long.MAX_VALUE;
        }
    }

    public static void a(Closeable closeable, n nVar) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
                if (nVar != null) {
                    nVar.BN();
                    if (x.Fn()) {
                        x BN = nVar.BN();
                        BN.c("Utils", "Unable to close stream: " + closeable, th);
                    }
                }
            }
        }
    }

    public static void a(HttpURLConnection httpURLConnection, n nVar) {
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Throwable th) {
                if (nVar != null) {
                    nVar.BN();
                    if (x.Fn()) {
                        x BN = nVar.BN();
                        BN.c("Utils", "Unable to disconnect connection: " + httpURLConnection, th);
                    }
                }
            }
        }
    }

    public static boolean Ly() {
        ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
        try {
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
        } catch (Throwable th) {
            x.e("Utils", "Exception thrown while getting memory state.", th);
        }
        return runningAppProcessInfo.importance == 100 || runningAppProcessInfo.importance == 200;
    }

    public static int dG(String str) {
        int i = 0;
        for (String str2 : str.replaceAll("-beta", ".").split("\\.")) {
            if (str2.length() > 2) {
                x.H("Utils", "Version number components cannot be longer than two digits -> " + str);
                return i;
            }
            i = (i * 100) + Integer.parseInt(str2);
        }
        return !str.contains("-beta") ? (i * 100) + 99 : i;
    }

    /* JADX WARNING: Removed duplicated region for block: B:4:0x000a A[Catch:{ all -> 0x002e }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean Lz() {
        /*
            java.util.Enumeration r0 = java.net.NetworkInterface.getNetworkInterfaces()     // Catch:{ all -> 0x002e }
        L_0x0004:
            boolean r1 = r0.hasMoreElements()     // Catch:{ all -> 0x002e }
            if (r1 == 0) goto L_0x0036
            java.lang.Object r1 = r0.nextElement()     // Catch:{ all -> 0x002e }
            java.net.NetworkInterface r1 = (java.net.NetworkInterface) r1     // Catch:{ all -> 0x002e }
            java.lang.String r1 = r1.getDisplayName()     // Catch:{ all -> 0x002e }
            java.lang.String r2 = "tun"
            boolean r2 = r1.contains(r2)     // Catch:{ all -> 0x002e }
            if (r2 != 0) goto L_0x002c
            java.lang.String r2 = "ppp"
            boolean r2 = r1.contains(r2)     // Catch:{ all -> 0x002e }
            if (r2 != 0) goto L_0x002c
            java.lang.String r2 = "ipsec"
            boolean r1 = r1.contains(r2)     // Catch:{ all -> 0x002e }
            if (r1 == 0) goto L_0x0004
        L_0x002c:
            r0 = 1
            return r0
        L_0x002e:
            r0 = move-exception
            java.lang.String r1 = "Utils"
            java.lang.String r2 = "Unable to check Network Interfaces"
            com.applovin.impl.sdk.x.e(r1, r2, r0)
        L_0x0036:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.utils.u.Lz():boolean");
    }

    public static boolean b(Context context, n nVar) {
        String str = nVar.getSettings().getExtraParameters().get(AppLovinSdkExtraParameterKey.RUN_IN_RELEASE_MODE);
        if ((!StringUtils.isValidString(str) || !Boolean.parseBoolean(str)) && (context.getApplicationInfo().flags & 2) != 0) {
            return true;
        }
        return false;
    }

    public static void e(String str, Context context) {
        AppLovinSdkUtils.runOnUiThread(new u$$ExternalSyntheticLambda7(context, str));
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void c(Context context, String str) {
        Toast makeText = Toast.makeText(context, str, 0);
        makeText.setMargin(0.0f, 0.1f);
        makeText.show();
    }

    public static void a(String str, MaxAd maxAd, Context context) {
        Toast.makeText(context, maxAd.getFormat().getLabel() + ": " + str, 1).show();
    }

    public static boolean c(AppLovinAdSize appLovinAdSize) {
        return appLovinAdSize == AppLovinAdSize.BANNER || appLovinAdSize == AppLovinAdSize.MREC || appLovinAdSize == AppLovinAdSize.LEADER || appLovinAdSize == AppLovinAdSize.CROSS_PROMO;
    }

    public static String LA() {
        try {
            for (Field field : Build.VERSION_CODES.class.getFields()) {
                if (field.getInt((Object) null) == Build.VERSION.SDK_INT) {
                    return field.getName();
                }
            }
            return "";
        } catch (Throwable th) {
            x.e("Utils", "Unable to get Android SDK codename", th);
            return "";
        }
    }

    public static String LB() {
        try {
            return Build.VERSION.RELEASE + " (" + LA() + " - API " + Build.VERSION.SDK_INT + ")";
        } catch (Throwable th) {
            x.e("Utils", "Unable to get Android OS info", th);
            return "";
        }
    }

    public static String ah(Object obj) {
        if (obj instanceof com.applovin.impl.mediation.b.a) {
            return ((com.applovin.impl.mediation.b.a) obj).xA();
        }
        if (c.Z(obj)) {
            return ((e) obj).GB();
        }
        return null;
    }

    public static List<Uri> a(boolean z, e eVar, n nVar, Context context) {
        if (eVar instanceof com.applovin.impl.b.a) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (Uri uri : new ArrayList(eVar.Gn())) {
            if (!nVar.Cc().c(uri.getLastPathSegment(), context)) {
                nVar.BN();
                if (x.Fn()) {
                    x BN = nVar.BN();
                    BN.i("Utils", "Cached HTML asset missing: " + uri);
                }
                arrayList.add(uri);
            }
        }
        if (z) {
            Uri FI = eVar.FI();
            if (!nVar.Cc().c(FI.getLastPathSegment(), context)) {
                nVar.BN();
                if (x.Fn()) {
                    x BN2 = nVar.BN();
                    BN2.i("Utils", "Cached video missing: " + FI);
                }
                arrayList.add(FI);
            }
        }
        return arrayList;
    }

    public static void a(boolean z, e eVar, n nVar, Context context, a aVar) {
        nVar.BO().b((com.applovin.impl.sdk.e.d) new ab(nVar, "checkIfAdContainsUnavailableCachedResources", new u$$ExternalSyntheticLambda2(new WeakReference(aVar), eVar, nVar, context, z)));
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(WeakReference weakReference, e eVar, n nVar, Context context, boolean z) {
        a aVar = (a) weakReference.get();
        if (aVar != null) {
            if (eVar instanceof com.applovin.impl.b.a) {
                AppLovinSdkUtils.runOnUiThread(new u$$ExternalSyntheticLambda3(aVar));
                return;
            }
            for (Uri uri : new ArrayList(eVar.Gn())) {
                if (!nVar.Cc().b(uri.getLastPathSegment(), context)) {
                    nVar.BN();
                    if (x.Fn()) {
                        x BN = nVar.BN();
                        BN.i("Utils", "Cached HTML asset unavailable: " + uri);
                    }
                    AppLovinSdkUtils.runOnUiThread(new u$$ExternalSyntheticLambda4(aVar));
                    return;
                }
            }
            if (z) {
                Uri FI = eVar.FI();
                if (!nVar.Cc().b(FI.getLastPathSegment(), context)) {
                    nVar.BN();
                    if (x.Fn()) {
                        x BN2 = nVar.BN();
                        BN2.i("Utils", "Cached video unavailable: " + FI);
                    }
                    AppLovinSdkUtils.runOnUiThread(new u$$ExternalSyntheticLambda5(aVar));
                    return;
                }
            }
            AppLovinSdkUtils.runOnUiThread(new u$$ExternalSyntheticLambda6(aVar));
        }
    }

    public static void a(MaxError maxError, String str, Context context) {
        StringBuilder sb = new StringBuilder();
        if (maxError.getCode() == -5001) {
            for (MaxNetworkResponseInfo next : maxError.getWaterfall().getNetworkResponses()) {
                MaxError error = next.getError();
                String name = next.getMediatedNetwork().getName();
                sb.append("\nFailed to load " + str + " from " + name + ":\n");
                sb.append("\nMAX Error " + error.getCode() + ": " + error.getMessage() + "\n");
                sb.append("\n" + name + " Error " + error.getMediatedNetworkErrorCode() + ": " + error.getMediatedNetworkErrorMessage() + "\n\n");
            }
        } else {
            sb.append("Failed to load " + str + " with error " + maxError.getCode() + ": " + maxError.getMessage());
        }
        a("", sb.toString(), context);
    }

    public static void a(String str, String str2, Context context) {
        new AlertDialog.Builder(context).setTitle(str).setMessage(str2).setNegativeButton(17039370, (DialogInterface.OnClickListener) null).create().show();
    }

    public static boolean gY(int i) {
        return i > 0 && i <= 100 && ((int) (Math.random() * 100.0d)) + 1 <= i;
    }

    public static boolean ah(Context context) {
        return e.X(context).dy("applovin.sdk.is_test_environment");
    }

    public static Map<String, String> a(AppLovinSdkSettings appLovinSdkSettings) {
        try {
            Field b = b((Class) appLovinSdkSettings.getClass(), "metaData");
            if (b != null) {
                b.setAccessible(true);
            }
            return (Map) b.get(appLovinSdkSettings);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean LD() {
        try {
            Class.forName("com.applovin.sdk.AppLovinSdk");
            return false;
        } catch (ClassNotFoundException unused) {
            return true;
        }
    }

    public static boolean Q(byte[] bArr) {
        return bArr.length >= 2 && bArr[0] == 31 && bArr[1] == -117;
    }

    public static byte[] R(byte[] bArr) throws IOException {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        gZIPOutputStream.write(bArr);
        gZIPOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] S(byte[] bArr) throws IOException {
        if (bArr == null || bArr.length == 0 || !Q(bArr)) {
            return bArr;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPInputStream gZIPInputStream = new GZIPInputStream(new ByteArrayInputStream(bArr));
        byte[] bArr2 = new byte[1024];
        while (true) {
            int read = gZIPInputStream.read(bArr2);
            if (read > 0) {
                byteArrayOutputStream.write(bArr2, 0, read);
            } else {
                gZIPInputStream.close();
                byteArrayOutputStream.close();
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    public static long T(byte[] bArr) {
        return n(bArr, 0);
    }

    public static long n(byte[] bArr, int i) {
        int i2 = i + 8;
        if (bArr.length >= i2) {
            long j = 0;
            while (i < i2) {
                j |= (((long) bArr[i]) & 255) << (i * 8);
                i++;
            }
            return j;
        }
        throw new IllegalArgumentException("byte array must be at least 8 bytes long");
    }

    public static int ai(Context context) {
        h.KV();
        return Settings.System.getInt(context.getContentResolver(), "always_finish_activities", 0);
    }

    public static boolean O(n nVar) {
        if (!h.KW()) {
            return true;
        }
        try {
            JSONObject.wrap(JSONObject.NULL);
            return true;
        } catch (Throwable th) {
            nVar.BN();
            if (!x.Fn()) {
                return false;
            }
            nVar.BN().b("Utils", "Failed to wrap JSONObject with exception", th);
            return false;
        }
    }

    public static boolean aj(Context context) {
        String packageName = context.getPackageName();
        return "com.revolverolver.fliptrickster".equals(packageName) || "com.mindstormstudios.idlemakeover".equals(packageName);
    }

    public static boolean ak(Context context) {
        if (aWs == null) {
            aWs = Boolean.valueOf("com.applovin.apps.dspdemo".equals(context.getPackageName()));
        }
        return aWs.booleanValue();
    }

    public static boolean al(Context context) {
        if (aWt == null) {
            aWt = Boolean.valueOf("com.applovin.apps.playables".equals(context.getPackageName()));
        }
        return aWt.booleanValue();
    }

    public static String dH(String str) {
        return str.replace("ALPlayableAnalytics.trackEvent = ", "ALPlayableAnalytics.trackEvent = function (eventName) {const SDK_URL = 'applovin://com.applovin.sdk/playable_event';if (!Object.values(ALPlayableEvent).includes(eventName)) {var aTag = document.createElement('a');aTag.setAttribute('href', SDK_URL + '?success=0&type=' + encodeURIComponent(eventName));aTag.innerHTML = 'empty';aTag.click();return;}var aTag = document.createElement('a');aTag.setAttribute('href', SDK_URL + '?success=1&type=' + encodeURIComponent(eventName));aTag.innerHTML = 'empty';aTag.click();}; ALPlayableAnalytics.trackEvent_ignore = ");
    }

    public static boolean N(List<String> list) {
        Context applicationContext = n.getApplicationContext();
        if (applicationContext != null) {
            return list.contains(applicationContext.getPackageName());
        }
        x.H("Utils", "Failed to check whether or not app is member of package names");
        return false;
    }

    public static String a(double d, int i) {
        DecimalFormat decimalFormat = aWr;
        decimalFormat.setMaximumFractionDigits(i);
        return decimalFormat.format(d);
    }

    public static boolean P(n nVar) {
        if (((Boolean) nVar.a(b.aNi)).booleanValue()) {
            return nVar.getSettings().isMuted();
        }
        return ((Boolean) nVar.a(b.aNg)).booleanValue();
    }

    public static int M(String str, String str2) {
        String digitsOnlyVersionString = StringUtils.toDigitsOnlyVersionString(str);
        String digitsOnlyVersionString2 = StringUtils.toDigitsOnlyVersionString(str2);
        try {
            if (Build.VERSION.SDK_INT >= 24) {
                int m = VersionInfo.getInstance(digitsOnlyVersionString).compareTo(VersionInfo.getInstance(digitsOnlyVersionString2));
                if (m == 0) {
                    return m;
                }
                if (m > 0) {
                    return 1;
                }
                return -1;
            }
            String[] split = digitsOnlyVersionString.split("\\.");
            String[] split2 = digitsOnlyVersionString2.split("\\.");
            int max = Math.max(split.length, split2.length);
            int i = 0;
            while (i < max) {
                String str3 = "0";
                String str4 = StringUtils.isValidString(split[i]) ? split[i] : str3;
                if (StringUtils.isValidString(split2[i])) {
                    str3 = split2[i];
                }
                int parseInt = i < split.length ? Integer.parseInt(str4) : 0;
                int parseInt2 = i < split2.length ? Integer.parseInt(str3) : 0;
                if (parseInt < parseInt2) {
                    return -1;
                }
                if (parseInt > parseInt2) {
                    return 1;
                }
                i++;
            }
            return 0;
        } catch (Throwable th) {
            x.e("Utils", "Failed to process version string.", th);
            return 0;
        }
    }

    public static WebView b(Context context, String str) {
        return a(context, str, false);
    }

    public static WebView a(Context context, String str, boolean z) {
        try {
            WebView webView = new WebView(context);
            if (z) {
                webView.setWebViewClient(new com.applovin.impl.sdk.ab());
            }
            return webView;
        } catch (Throwable th) {
            x.e("Utils", "Failed to initialize WebView for " + str + ".", th);
            return null;
        }
    }

    public static boolean Q(n nVar) {
        String str = nVar.getSettings().getExtraParameters().get(AppLovinSdkExtraParameterKey.USER_AGENT_COLLECTION_ENABLED);
        if (StringUtils.isValidString(str)) {
            return Boolean.parseBoolean(str);
        }
        return true;
    }

    public static void a(Uri uri, Activity activity, n nVar) {
        if (activity == null) {
            activity = nVar.CF();
        }
        Intent intent = new Intent(activity, AppLovinWebViewActivity.class);
        intent.putExtra(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, nVar.getSdkKey());
        intent.putExtra(AppLovinWebViewActivity.INTENT_EXTRA_KEY_LOAD_URL, uri.toString());
        activity.startActivity(intent);
    }

    public static String a(int i, Context context, n nVar) {
        if (i == 0) {
            return "";
        }
        try {
            InputStream openRawResource = context.getResources().openRawResource(i);
            try {
                byte[] bArr = new byte[openRawResource.available()];
                openRawResource.read(bArr);
                return new String(bArr);
            } catch (IOException e) {
                if (nVar != null) {
                    nVar.BN();
                    if (x.Fn()) {
                        nVar.BN().c("Utils", "Opening raw resource file threw exception", e);
                    }
                }
                return "";
            } finally {
                a((Closeable) openRawResource, nVar);
            }
        } catch (Throwable th) {
            if (nVar != null) {
                nVar.BN();
                if (x.Fn()) {
                    x BN = nVar.BN();
                    BN.c("Utils", "Failed to retrieve resource " + i, th);
                }
            }
            return "";
        }
    }

    public static void LG() {
        x.D("AppLovinSdk", "Java version 8 supported.");
    }

    public static String a(ak akVar, n nVar) {
        if (akVar == null) {
            return "Unknown error";
        }
        if (!((Boolean) nVar.a(b.aQP)).booleanValue()) {
            return akVar.toString();
        }
        Throwable cause = akVar.getCause();
        String message = cause != null ? cause.getMessage() : "Unknown";
        String name = cause != null ? cause.getClass().getName() : "";
        return "Code: " + akVar.errorCode + ", Name: " + akVar.cA() + ", Message: " + akVar.getMessage() + ", Cause Class: " + name + ", Cause Message: " + message;
    }

    public static boolean a(MaxAdFormat maxAdFormat, MaxAdFormat maxAdFormat2) {
        return (maxAdFormat == null || maxAdFormat2 == null || (maxAdFormat != maxAdFormat2 && (!maxAdFormat.isBannerOrLeaderAd() || !maxAdFormat2.isBannerOrLeaderAd()))) ? false : true;
    }

    public static boolean am(Context context) {
        if (context == null) {
            return false;
        }
        try {
            context.getResources();
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static Context an(Context context) {
        return am(context) ? context : n.getApplicationContext();
    }

    public static boolean dI(String str) {
        return str != null && (str.contains("applovin.com") || str.contains("applvn.com"));
    }
}
