package com.ironsource.mediationsdk;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.fyber.inneractive.sdk.external.InneractiveMediationNameConsts;
import com.ironsource.d1;
import com.ironsource.environment.thread.IronSourceThreadManager;
import com.ironsource.i9;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.d;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceLogger;
import com.ironsource.mediationsdk.logger.IronSourceLoggerManager;
import com.ironsource.mediationsdk.utils.IronSourceAES;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.ironsource.mediationsdk.utils.c;
import com.ironsource.t0;
import com.ironsource.u3;
import com.ironsource.z3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class e {
    private final String a = "1";
    private final String b = "102";
    private final String c = "102";
    private final String d = "GenericNotifications";
    private f e;
    private IronSource.AD_UNIT f;
    private String g;
    private com.ironsource.mediationsdk.utils.a h;
    private t0 i;
    private ISBannerSize j;

    public static class a implements Runnable {
        protected WeakReference<t0> a;
        protected d.a b;
        protected int c;
        protected String d;
        protected long e;
        protected int f;
        protected String g = InneractiveMediationNameConsts.OTHER;
        private int h;
        protected String i = "";
        protected int j = 0;
        private final URL k;
        private final JSONObject l;
        private final boolean m;
        private final int n;
        private final long o;
        private final boolean p;
        private final boolean q;

        public a(t0 t0Var, URL url, JSONObject jSONObject, boolean z, int i2, long j2, boolean z2, boolean z3, int i3) {
            this.a = new WeakReference<>(t0Var);
            this.k = url;
            this.l = jSONObject;
            this.m = z;
            this.n = i2;
            this.o = j2;
            this.p = z2;
            this.q = z3;
            this.h = i3;
        }

        private String a() {
            return this.h == 2 ? u3.b().d() : u3.b().c();
        }

        private String a(HttpURLConnection httpURLConnection) throws IOException {
            InputStreamReader inputStreamReader = new InputStreamReader(httpURLConnection.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb.append(readLine);
                } else {
                    bufferedReader.close();
                    inputStreamReader.close();
                    return sb.toString();
                }
            }
        }

        private HttpURLConnection a(URL url, long j2) throws IOException {
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod(i9.b);
            httpURLConnection.setRequestProperty(z3.I, "application/json; charset=utf-8");
            httpURLConnection.setReadTimeout((int) j2);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            return httpURLConnection;
        }

        private JSONObject a(String str, String str2) throws JSONException {
            String decode = IronSourceAES.decode(str, str2);
            if (!TextUtils.isEmpty(decode)) {
                return new JSONObject(decode);
            }
            throw new JSONException("decryption error");
        }

        private void a(long j2, long j3) {
            long time = j2 - (new Date().getTime() - j3);
            if (time > 0) {
                SystemClock.sleep(time);
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:10:0x005b  */
        /* JADX WARNING: Removed duplicated region for block: B:13:0x0064  */
        /* JADX WARNING: Removed duplicated region for block: B:14:0x0071  */
        /* JADX WARNING: Removed duplicated region for block: B:9:0x004f  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void a(java.net.HttpURLConnection r9, org.json.JSONObject r10, boolean r11) throws java.lang.Exception {
            /*
                r8 = this;
                java.io.OutputStream r9 = r9.getOutputStream()
                java.io.OutputStreamWriter r0 = new java.io.OutputStreamWriter
                java.lang.String r1 = "UTF-8"
                r0.<init>(r9, r1)
                java.io.BufferedWriter r1 = new java.io.BufferedWriter
                r1.<init>(r0)
                int r2 = r8.h
                r3 = 1
                r4 = 2
                if (r2 != r4) goto L_0x0043
                com.ironsource.u3 r2 = com.ironsource.u3.b()     // Catch:{ JSONException -> 0x001f }
                java.lang.String r2 = r2.a()     // Catch:{ JSONException -> 0x001f }
                goto L_0x0045
            L_0x001f:
                r2 = move-exception
                java.lang.String r5 = r2.getLocalizedMessage()
                r8.i = r5
                r5 = 1015(0x3f7, float:1.422E-42)
                r8.j = r5
                r8.h = r3
                com.ironsource.mediationsdk.logger.IronLog r5 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                java.lang.String r7 = "get encrypted session key exception "
                r6.<init>(r7)
                java.lang.String r2 = r2.getMessage()
                r6.append(r2)
                java.lang.String r2 = r6.toString()
                r5.error(r2)
            L_0x0043:
                java.lang.String r2 = ""
            L_0x0045:
                java.lang.String r10 = r10.toString()
                java.lang.String r5 = r8.a()
                if (r11 == 0) goto L_0x005b
                com.ironsource.mediationsdk.logger.IronLog r11 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL
                java.lang.String r6 = "compressing and encrypting auction request"
                r11.verbose(r6)
                java.lang.String r10 = com.ironsource.mediationsdk.utils.IronSourceAES.compressAndEncrypt(r5, r10)
                goto L_0x005f
            L_0x005b:
                java.lang.String r10 = com.ironsource.mediationsdk.utils.IronSourceAES.encode(r5, r10)
            L_0x005f:
                int r11 = r8.h
                r5 = 0
                if (r11 != r4) goto L_0x0071
                java.lang.Object[] r11 = new java.lang.Object[r4]
                r11[r5] = r2
                r11[r3] = r10
                java.lang.String r10 = "{\"sk\" : \"%1$s\", \"ct\" : \"%2$s\"}"
                java.lang.String r10 = java.lang.String.format(r10, r11)
                goto L_0x007b
            L_0x0071:
                java.lang.Object[] r11 = new java.lang.Object[r3]
                r11[r5] = r10
                java.lang.String r10 = "{\"request\" : \"%1$s\"}"
                java.lang.String r10 = java.lang.String.format(r10, r11)
            L_0x007b:
                r1.write(r10)
                r1.flush()
                r1.close()
                r0.close()
                r9.close()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.e.a.a(java.net.HttpURLConnection, org.json.JSONObject, boolean):void");
        }

        private JSONObject b(String str, String str2) throws JSONException {
            IronLog.INTERNAL.verbose("decrypting and decompressing auction response");
            String decryptAndDecompress = IronSourceAES.decryptAndDecompress(str, str2);
            if (decryptAndDecompress != null) {
                return new JSONObject(decryptAndDecompress);
            }
            throw new JSONException("decompression error");
        }

        /* access modifiers changed from: protected */
        public JSONObject a(JSONObject jSONObject, boolean z) throws JSONException {
            String a2 = a();
            String string = jSONObject.getString(this.h == 2 ? "ct" : c.Y1);
            return z ? b(a2, string) : a(a2, string);
        }

        /* access modifiers changed from: protected */
        public void a(String str, boolean z, boolean z2) throws JSONException {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                if (z) {
                    jSONObject = a(jSONObject, z2);
                }
                d.a b2 = d.c().b(jSONObject);
                this.b = b2;
                this.c = b2.c();
                this.d = this.b.d();
                return;
            }
            throw new JSONException("empty response");
        }

        /* access modifiers changed from: protected */
        public void a(boolean z, t0 t0Var, long j2) {
            if (z) {
                t0Var.a(this.b.h(), this.b.a(), this.b.e(), this.b.f(), this.b.b(), this.f + 1, j2, this.j, this.i);
                return;
            }
            t0Var.a(this.c, this.d, this.f + 1, this.g, j2);
        }

        /* access modifiers changed from: protected */
        public boolean b() {
            String str;
            this.e = new Date().getTime();
            try {
                this.h = this.j == 1015 ? 1 : this.h;
                this.f = 0;
                HttpURLConnection httpURLConnection = null;
                while (true) {
                    int i2 = this.f;
                    int i3 = this.n;
                    if (i2 < i3) {
                        try {
                            long time = new Date().getTime();
                            String str2 = "Auction Handler: auction trial " + (this.f + 1) + " out of " + this.n + " max trials";
                            IronSourceLoggerManager.getLogger().log(IronSourceLogger.IronSourceTag.INTERNAL, str2, 0);
                            IronSourceUtils.sendAutomationLog(str2);
                            httpURLConnection = a(this.k, this.o);
                            a(httpURLConnection, this.l, this.p);
                            int responseCode = httpURLConnection.getResponseCode();
                            if (responseCode == 200 || responseCode == 204) {
                                try {
                                    a(a(httpURLConnection), this.m, this.q);
                                    httpURLConnection.disconnect();
                                    return true;
                                } catch (JSONException e2) {
                                    if (e2.getMessage() != null && e2.getMessage().equalsIgnoreCase("decryption error")) {
                                        this.c = 1003;
                                        str = "Auction decryption error";
                                    } else if (e2.getMessage() == null || !e2.getMessage().equalsIgnoreCase("decompression error")) {
                                        this.c = 1002;
                                        str = "Auction parsing error";
                                    } else {
                                        this.c = 1008;
                                        str = "Auction decompression error";
                                    }
                                    this.d = str;
                                    this.g = "parsing";
                                    IronLog.INTERNAL.error("Auction handle response exception " + e2.getMessage());
                                    httpURLConnection.disconnect();
                                    return false;
                                }
                            } else {
                                this.c = 1001;
                                String str3 = "Auction response code not valid, error code response from server - " + responseCode;
                                this.d = str3;
                                IronLog.INTERNAL.error(str3);
                                httpURLConnection.disconnect();
                                if (this.f < this.n - 1) {
                                    a(this.o, time);
                                }
                                this.f++;
                            }
                        } catch (SocketTimeoutException e3) {
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            this.c = 1006;
                            this.d = "Connection timed out";
                            IronLog.INTERNAL.error("Auction socket timeout exception " + e3.getMessage());
                        } catch (Throwable th) {
                            IronLog.INTERNAL.error("getting exception " + th);
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                            }
                            this.c = 1000;
                            this.d = th.getMessage();
                            this.g = InneractiveMediationNameConsts.OTHER;
                            return false;
                        }
                    } else {
                        this.f = i3 - 1;
                        this.g = "trials_fail";
                        return false;
                    }
                }
            } catch (Exception e4) {
                this.c = 1007;
                this.d = e4.getMessage();
                this.f = 0;
                this.g = InneractiveMediationNameConsts.OTHER;
                IronLog.INTERNAL.error("Auction request exception " + e4.getMessage());
                return false;
            }
        }

        public void run() {
            boolean b2 = b();
            t0 t0Var = this.a.get();
            if (t0Var != null) {
                a(b2, t0Var, new Date().getTime() - this.e);
            }
        }
    }

    @Deprecated
    public e(IronSource.AD_UNIT ad_unit, com.ironsource.mediationsdk.utils.a aVar, t0 t0Var) {
        this.f = ad_unit;
        this.h = aVar;
        this.i = t0Var;
        this.g = IronSourceUtils.getSessionId();
    }

    public e(f fVar) {
        this.e = fVar;
    }

    private JSONObject a(Context context, Map<String, Object> map, List<String> list, h hVar, int i2, boolean z, IronSourceSegment ironSourceSegment) throws JSONException {
        boolean z2 = z;
        IronSourceSegment ironSourceSegment2 = ironSourceSegment;
        new JSONObject();
        if (p.o().k().b().b().j().f()) {
            i iVar = new i(this.f);
            iVar.a(map);
            iVar.a(list);
            iVar.a(hVar);
            iVar.a(i2);
            iVar.a(this.j);
            iVar.a(ironSourceSegment2);
            iVar.b(z2);
            return d.c().a(iVar);
        }
        Map<String, Object> map2 = map;
        List<String> list2 = list;
        h hVar2 = hVar;
        int i3 = i2;
        JSONObject a2 = d.c().a(context, map, list, hVar, i2, this.g, this.h, this.j, ironSourceSegment2 != null ? ironSourceSegment.toJson() : null, false, false);
        a2.put("adUnit", this.f.toString());
        a2.put(d.k0, z2 ? "false" : "true");
        return a2;
    }

    public void a(Context context, i iVar, t0 t0Var) {
        try {
            IronSourceThreadManager.INSTANCE.postMediationBackgroundTask(this.e.a(context, iVar, t0Var));
        } catch (Exception e2) {
            IronLog ironLog = IronLog.INTERNAL;
            ironLog.error("execute auction exception " + e2.getMessage());
            if (t0Var != null) {
                t0Var.a(1000, e2.getMessage(), 0, InneractiveMediationNameConsts.OTHER, 0);
            }
        }
    }

    @Deprecated
    public void a(Context context, Map<String, Object> map, List<String> list, h hVar, int i2, IronSourceSegment ironSourceSegment) {
        try {
            boolean isEncryptedResponse = IronSourceUtils.isEncryptedResponse();
            IronSourceThreadManager.INSTANCE.postMediationBackgroundTask(new a(this.i, new URL(this.h.a(false)), a(context, map, list, hVar, i2, isEncryptedResponse, ironSourceSegment), isEncryptedResponse, this.h.g(), this.h.m(), this.h.n(), this.h.o(), this.h.d()));
        } catch (Exception e2) {
            IronLog ironLog = IronLog.INTERNAL;
            ironLog.error("execute auction exception " + e2.getMessage());
            this.i.a(1000, e2.getMessage(), 0, InneractiveMediationNameConsts.OTHER, 0);
        }
    }

    @Deprecated
    public void a(Context context, Map<String, Object> map, List<String> list, h hVar, int i2, IronSourceSegment ironSourceSegment, ISBannerSize iSBannerSize) {
        this.j = iSBannerSize;
        a(context, map, list, hVar, i2, ironSourceSegment);
    }

    public void a(d1 d1Var, int i2, d1 d1Var2) {
        for (String a2 : d1Var.g()) {
            d.c().a("reportLoadSuccess", d1Var.c(), d.c().a(a2, i2, d1Var, "", "", ""));
        }
        if (d1Var2 != null) {
            for (String a3 : d1Var2.g()) {
                d.c().a("reportLoadSuccess", "GenericNotifications", d.c().a(a3, i2, d1Var, "", "102", ""));
            }
        }
    }

    public void a(d1 d1Var, int i2, d1 d1Var2, String str) {
        for (String a2 : d1Var.b()) {
            d.c().a("reportImpression", d1Var.c(), d.c().a(a2, i2, d1Var, "", "", str));
        }
        if (d1Var2 != null) {
            for (String a3 : d1Var2.b()) {
                d.c().a("reportImpression", "GenericNotifications", d.c().a(a3, i2, d1Var, "", "102", str));
            }
        }
    }

    public void a(ArrayList<String> arrayList, ConcurrentHashMap<String, d1> concurrentHashMap, int i2, d1 d1Var, d1 d1Var2) {
        int i3 = d1Var2.i();
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!next.equals(d1Var2.c())) {
                d1 d1Var3 = concurrentHashMap.get(next);
                int i4 = d1Var3.i();
                String h2 = d1Var3.h();
                String str = i4 < i3 ? "1" : "102";
                IronLog ironLog = IronLog.INTERNAL;
                ironLog.verbose("instance=" + d1Var3.c() + ", instancePriceOrder= " + i4 + ", loseReasonCode=" + str + ", winnerInstance=" + d1Var2.c() + ", winnerInstancePriceOrder=" + i3);
                for (String a2 : d1Var3.f()) {
                    d.c().a("reportAuctionLose", d1Var3.c(), d.c().a(a2, i2, d1Var2, h2, str, ""));
                }
            } else {
                ConcurrentHashMap<String, d1> concurrentHashMap2 = concurrentHashMap;
            }
        }
        if (d1Var != null) {
            for (String a3 : d1Var.f()) {
                d.c().a("reportAuctionLose", "GenericNotifications", d.c().a(a3, i2, d1Var2, "", "102", ""));
            }
        }
    }

    public void a(CopyOnWriteArrayList<a0> copyOnWriteArrayList, ConcurrentHashMap<String, d1> concurrentHashMap, int i2, d1 d1Var, d1 d1Var2) {
        ArrayList arrayList = new ArrayList();
        Iterator<a0> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().c());
        }
        a((ArrayList<String>) arrayList, concurrentHashMap, i2, d1Var, d1Var2);
    }

    public boolean a() {
        return this.e.a();
    }
}
