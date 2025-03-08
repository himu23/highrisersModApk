package com.ironsource;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import java.io.DataOutputStream;
import java.lang.Thread;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class s2 {
    private static final String j = "1.0.5";
    public static String k = "";
    /* access modifiers changed from: private */
    public JSONObject a;
    private String b;
    /* access modifiers changed from: private */
    public String c;
    private String d;
    /* access modifiers changed from: private */
    public String e;
    private Context f;
    private Thread.UncaughtExceptionHandler g;
    /* access modifiers changed from: private */
    public String h;
    private String i;

    class a implements b {
        a() {
        }

        public void a() {
            Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
            StringBuilder sb = new StringBuilder(128);
            for (Thread next : allStackTraces.keySet()) {
                StackTraceElement[] stackTrace = next.getStackTrace();
                if (stackTrace != null && stackTrace.length > 0) {
                    sb.append("*** Thread Name ");
                    sb.append(next.getName());
                    sb.append(" Thread ID ");
                    sb.append(next.getId());
                    sb.append(" (");
                    sb.append(next.getState().toString());
                    sb.append(") ***\n");
                    for (StackTraceElement stackTraceElement : stackTrace) {
                        sb.append(stackTraceElement.toString());
                        sb.append(" ");
                        sb.append(next.getState().toString());
                        sb.append("\n");
                    }
                }
            }
            s2.k = sb.toString();
        }

        public void b() {
        }
    }

    class b implements Runnable {
        final /* synthetic */ Context a;
        final /* synthetic */ String b;

        b(Context context, String str) {
            this.a = context;
            this.b = str;
        }

        public void run() {
            try {
                String N = m3.N(this.a);
                if (!TextUtils.isEmpty(N)) {
                    String unused = s2.this.c = N;
                }
                String O = m3.O(this.a);
                if (!TextUtils.isEmpty(O)) {
                    String unused2 = s2.this.e = O;
                }
                SharedPreferences.Editor edit = this.a.getSharedPreferences("CRep", 0).edit();
                edit.putString("String1", s2.this.c);
                edit.putString(jc.m, this.b);
                edit.apply();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    class c implements Runnable {
        c() {
        }

        public void run() {
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(s2.d().h).openConnection();
                httpURLConnection.setRequestMethod(i9.b);
                httpURLConnection.setRequestProperty(z3.I, "application/json;charset=UTF-8");
                httpURLConnection.setRequestProperty("Accept", z3.J);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                Log.i("JSON", s2.this.a.toString());
                DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                dataOutputStream.writeBytes(s2.this.a.toString());
                dataOutputStream.flush();
                dataOutputStream.close();
                Log.i("STATUS", String.valueOf(httpURLConnection.getResponseCode()));
                Log.i("MSG", httpURLConnection.getResponseMessage());
                httpURLConnection.disconnect();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static class d {
        static volatile s2 a = new s2((a) null);

        private d() {
        }
    }

    private s2() {
        this.a = new JSONObject();
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        this.g = defaultUncaughtExceptionHandler;
        this.i = " ";
        this.h = "https://outcome-crash-report.supersonicads.com/reporter";
        Thread.setDefaultUncaughtExceptionHandler(new r2(defaultUncaughtExceptionHandler));
    }

    /* synthetic */ s2(a aVar) {
        this();
    }

    private String a(Context context) {
        ConnectivityManager connectivityManager;
        if (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null) {
            return "none";
        }
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
                if (networkCapabilities == null) {
                    return "none";
                }
                if (networkCapabilities.hasTransport(1)) {
                    return k2.b;
                }
                if (networkCapabilities.hasTransport(0)) {
                    return k2.g;
                }
            } else {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                    if (activeNetworkInfo.getTypeName().equalsIgnoreCase("WIFI")) {
                        return k2.b;
                    }
                    if (activeNetworkInfo.getTypeName().equalsIgnoreCase("MOBILE")) {
                        return k2.g;
                    }
                }
            }
            return "none";
        } catch (Exception e2) {
            e2.printStackTrace();
            return "none";
        }
    }

    private void a(Context context, HashSet<String> hashSet) {
        String a2 = a(a());
        if (!a2.equals("none")) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("CRep", 0);
            String string = sharedPreferences.getString("String1", this.c);
            String string2 = sharedPreferences.getString(jc.m, this.d);
            for (h4 next : z2.b()) {
                String b2 = next.b();
                String e2 = next.e();
                String d2 = next.d();
                String packageName = context.getPackageName();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("crashDate", b2);
                    jSONObject.put("stacktraceCrash", e2);
                    jSONObject.put("crashType", d2);
                    jSONObject.put("CrashReporterVersion", j);
                    jSONObject.put("SDKVersion", "7.6.1");
                    jSONObject.put("deviceLanguage", m3.k(context));
                    jSONObject.put("appVersion", k0.b(context, packageName));
                    jSONObject.put("deviceOSVersion", m3.c());
                    jSONObject.put("network", a2);
                    jSONObject.put("deviceApiLevel", m3.b());
                    jSONObject.put("deviceModel", m3.j());
                    jSONObject.put(jc.p0, m3.l());
                    jSONObject.put(jc.h1, string);
                    jSONObject.put("deviceOEM", m3.k());
                    jSONObject.put("systemProperties", System.getProperties());
                    jSONObject.put("bundleId", packageName);
                    jSONObject.put(jc.m, string2);
                    if (!TextUtils.isEmpty(this.e)) {
                        jSONObject.put("isLimitAdTrackingEnabled", Boolean.parseBoolean(this.e));
                    }
                    JSONObject jSONObject2 = new JSONObject();
                    if (hashSet != null && !hashSet.isEmpty()) {
                        Iterator<String> it = hashSet.iterator();
                        while (it.hasNext()) {
                            String next2 = it.next();
                            try {
                                if (jSONObject.has(next2)) {
                                    jSONObject2.put(next2, jSONObject.opt(next2));
                                }
                            } catch (Exception e3) {
                                e3.printStackTrace();
                            }
                        }
                        jSONObject = jSONObject2;
                    }
                    this.a = jSONObject;
                } catch (Exception unused) {
                }
                if (this.a.length() == 0) {
                    Log.d("ISCrashReport", " Is Empty");
                } else {
                    new Thread(new c()).start();
                    z2.a();
                }
            }
        }
    }

    static List<h4> c() {
        return null;
    }

    public static s2 d() {
        return d.a;
    }

    /* access modifiers changed from: package-private */
    public Context a() {
        return this.f;
    }

    public void a(Context context, HashSet<String> hashSet, String str, String str2, boolean z, String str3, int i2, boolean z2) {
        if (context != null) {
            Log.d("automation_log", "init ISCrashReporter");
            this.f = context;
            if (!TextUtils.isEmpty(str2)) {
                this.i = str2;
            }
            if (!TextUtils.isEmpty(str)) {
                this.h = str;
            }
            this.d = str3;
            if (z) {
                new a(i2).a(z2).b(true).a((b) new a()).start();
            }
            a(context, hashSet);
            new Thread(new b(context, str3)).start();
        }
    }

    public String b() {
        return j;
    }

    /* access modifiers changed from: package-private */
    public String e() {
        return this.i;
    }
}
