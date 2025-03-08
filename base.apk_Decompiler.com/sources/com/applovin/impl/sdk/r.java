package com.applovin.impl.sdk;

import android.os.Build;
import com.applovin.impl.sdk.ad.e;
import com.applovin.impl.sdk.c.b;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.u;
import com.applovin.sdk.AppLovinSdk;
import com.ironsource.i9;
import com.ironsource.m2;
import com.ironsource.t4;
import java.io.UnsupportedEncodingException;
import java.lang.Thread;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class r {
    private static final int aEA = ((int) TimeUnit.SECONDS.toMillis(30));
    private final ExecutorService aEB;
    private final Map<a, Long> aEC = Collections.synchronizedMap(new HashMap());
    protected final x logger;
    protected final n sdk;

    public enum a {
        ANR("anr"),
        BLACK_VIEW("black_view"),
        CRASH("crash"),
        TASK_EXCEPTION("task_exception"),
        CAUGHT_EXCEPTION("caught_exception"),
        WEB_VIEW_ERROR("web_view_error"),
        INTEGRATION_ERROR("integration_error"),
        TEMPLATE_ERROR("template_error"),
        FILE_ERROR("file_error"),
        NETWORK_ERROR("network_error");
        
        private final String Jn;

        public String tU() {
            return this.Jn;
        }

        private a(String str) {
            this.Jn = str;
        }
    }

    public r(final n nVar) {
        this.sdk = nVar;
        this.logger = nVar.BN();
        this.aEB = Executors.newFixedThreadPool(1, new ThreadFactory() {
            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable, "AppLovinSdk:error_reporter");
                thread.setDaemon(true);
                thread.setPriority(((Integer) nVar.a(b.aQK)).intValue());
                thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
                    public void uncaughtException(Thread thread, Throwable th) {
                        nVar.BN();
                        if (x.Fn()) {
                            nVar.BN().c("ErrorReporter", "Caught unhandled exception", th);
                        }
                    }
                });
                return thread;
            }
        });
    }

    public void g(String str, Throwable th) {
        d(str, (String) null, th);
    }

    public void d(String str, String str2, Throwable th) {
        HashMap hashMap = new HashMap(3);
        hashMap.put("source", str);
        hashMap.put("details", StringUtils.emptyIfNull(str2));
        hashMap.put("top_main_method", th.toString());
        a(a.CAUGHT_EXCEPTION, (Map<String, String>) hashMap);
    }

    public void b(String str, String str2, int i) {
        if (i >= 400) {
            HashMap hashMap = new HashMap(3);
            hashMap.put("source", str2);
            hashMap.put("details", StringUtils.emptyIfNull(str));
            hashMap.put("top_main_method", String.valueOf(i));
            a(a.NETWORK_ERROR, (Map<String, String>) hashMap);
        }
    }

    public void a(a aVar, String str, String str2) {
        HashMap hashMap = new HashMap(2);
        hashMap.put("source", str);
        hashMap.put("details", StringUtils.emptyIfNull(str2));
        a(aVar, (Map<String, String>) hashMap);
    }

    public void a(a aVar, Map<String, String> map) {
        a(aVar, map, 0);
    }

    public void a(a aVar, Map<String, String> map, long j) {
        if (!a(aVar, j)) {
            try {
                if (u.Lx()) {
                    this.aEB.execute(new r$$ExternalSyntheticLambda0(this, aVar, map));
                } else {
                    d(aVar, map);
                }
            } catch (Throwable th) {
                if (x.Fn()) {
                    x xVar = this.logger;
                    xVar.b("ErrorReporter", "Failed to report " + aVar.tU(), th);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void d(a aVar, Map<String, String> map) {
        if (x.Fn()) {
            x xVar = this.logger;
            xVar.f("ErrorReporter", "Reporting " + aVar.tU() + " error...");
        }
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) c(aVar, map).openConnection();
            int i = aEA;
            httpURLConnection.setConnectTimeout(i);
            httpURLConnection.setReadTimeout(i);
            httpURLConnection.setDefaultUseCaches(false);
            httpURLConnection.setAllowUserInteraction(false);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setInstanceFollowRedirects(true);
            httpURLConnection.setDoOutput(false);
            httpURLConnection.setRequestMethod(i9.b);
            int responseCode = httpURLConnection.getResponseCode();
            if (x.Fn()) {
                x xVar2 = this.logger;
                xVar2.f("ErrorReporter", aVar.tU() + " reported with code " + responseCode);
            }
            this.aEC.put(aVar, Long.valueOf(System.currentTimeMillis()));
        } catch (Throwable th) {
            if (x.Fn()) {
                x xVar3 = this.logger;
                xVar3.b("ErrorReporter", "Failed to report " + aVar.tU(), th);
            }
        }
    }

    private URL c(a aVar, Map<String, String> map) throws MalformedURLException, UnsupportedEncodingException {
        StringBuilder sb = new StringBuilder("https://ms.applovin.com/1.0/sdk/error?");
        Iterator<Map.Entry<String, String>> it = d(aVar.tU(), map).entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            String encode = URLEncoder.encode((String) next.getKey(), "UTF-8");
            String encode2 = URLEncoder.encode((String) next.getValue(), "UTF-8");
            sb.append(encode);
            sb.append(m2.i.b);
            sb.append(encode2);
            if (it.hasNext()) {
                sb.append(m2.i.c);
            }
        }
        return new URL(sb.toString());
    }

    private Map<String, String> d(String str, Map<String, String> map) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", str);
        if (this.sdk.BV() != null) {
            hashMap.put("platform", this.sdk.BU().Ed());
        } else {
            hashMap.put("platform", this.sdk.BS().CX());
        }
        hashMap.put("applovin_random_token", this.sdk.BB());
        hashMap.put("compass_random_token", this.sdk.BA());
        hashMap.put(t4.u, Build.MODEL);
        hashMap.put("brand", Build.MANUFACTURER);
        hashMap.put("brand_name", Build.BRAND);
        hashMap.put("hardware", Build.HARDWARE);
        hashMap.put("revision", Build.DEVICE);
        hashMap.put(t4.x, Build.VERSION.RELEASE);
        hashMap.put("api_level", String.valueOf(Build.VERSION.SDK_INT));
        hashMap.put("sdk_version", String.valueOf(AppLovinSdk.VERSION));
        hashMap.put("aei", String.valueOf(this.sdk.a(b.aKC)));
        hashMap.put("mei", String.valueOf(this.sdk.a(b.aKD)));
        i(hashMap);
        j(hashMap);
        if (map != null) {
            hashMap.putAll(map);
        }
        return hashMap;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0021  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x002a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void i(java.util.Map<java.lang.String, java.lang.String> r6) {
        /*
            r5 = this;
            java.lang.String r0 = ""
            r1 = 0
            android.content.Context r2 = com.applovin.impl.sdk.n.getApplicationContext()     // Catch:{ all -> 0x0018 }
            android.content.pm.PackageManager r2 = r2.getPackageManager()     // Catch:{ all -> 0x0018 }
            android.content.Context r3 = com.applovin.impl.sdk.n.getApplicationContext()     // Catch:{ all -> 0x0018 }
            java.lang.String r3 = r3.getPackageName()     // Catch:{ all -> 0x0018 }
            android.content.pm.PackageInfo r2 = r2.getPackageInfo(r3, r1)     // Catch:{ all -> 0x0019 }
            goto L_0x001a
        L_0x0018:
            r3 = r0
        L_0x0019:
            r2 = 0
        L_0x001a:
            java.lang.String r4 = "package_name"
            r6.put(r4, r3)
            if (r2 == 0) goto L_0x0023
            java.lang.String r0 = r2.versionName
        L_0x0023:
            java.lang.String r3 = "app_version"
            r6.put(r3, r0)
            if (r2 == 0) goto L_0x002c
            int r1 = r2.versionCode
        L_0x002c:
            java.lang.String r0 = java.lang.String.valueOf(r1)
            java.lang.String r1 = "app_version_code"
            r6.put(r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.r.i(java.util.Map):void");
    }

    private void j(Map<String, String> map) {
        Object Fd = this.sdk.Cf().Fd();
        if (Fd instanceof e) {
            map.put("fs_ad_network", "AppLovin");
            map.put("fs_ad_creative_id", Long.toString(((e) Fd).getAdIdNumber()));
        } else if (Fd instanceof com.applovin.impl.mediation.b.a) {
            com.applovin.impl.mediation.b.a aVar = (com.applovin.impl.mediation.b.a) Fd;
            map.put("fs_ad_network", aVar.getNetworkName());
            map.put("fs_ad_creative_id", aVar.getCreativeId());
        } else {
            map.put("fs_ad_network", "None");
            map.put("fs_ad_creative_id", "None");
        }
    }

    private boolean a(a aVar, long j) {
        Long l = this.aEC.get(aVar);
        return System.currentTimeMillis() - (l != null ? l.longValue() : -1) < j;
    }
}
