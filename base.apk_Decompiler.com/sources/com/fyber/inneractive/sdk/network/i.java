package com.fyber.inneractive.sdk.network;

import android.text.TextUtils;
import android.util.Pair;
import androidx.work.impl.Scheduler;
import com.fyber.inneractive.sdk.util.IAlog;
import com.ironsource.z3;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class i extends h implements g {

    public static class a extends j {
        public final HttpURLConnection g;

        public a(HttpURLConnection httpURLConnection, int i, InputStream inputStream, Map<String, List<String>> map, String str) {
            this.g = httpURLConnection;
            a(i);
            a(inputStream);
            a(map);
            a(str);
        }

        public void a() throws IOException {
            try {
                HttpURLConnection httpURLConnection = this.g;
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
            } catch (Throwable unused) {
            }
            super.a();
        }
    }

    public <T> j a(c0<T> c0Var, String str, String str2) throws Exception {
        j jVar;
        InputStream inputStream;
        IAlog.a("%s hurl network stack is in use", "HttpExecutorImpl");
        URL url = new URL(c0Var.a());
        ArrayList arrayList = new ArrayList();
        arrayList.add(c0Var.a());
        Pair<List<String>, HttpURLConnection> a2 = a(c0Var, arrayList, url, str, str2);
        HttpURLConnection httpURLConnection = (HttpURLConnection) a2.second;
        List<String> list = (List) a2.first;
        if (httpURLConnection == null) {
            try {
                if (list.size() <= 0) {
                    throw new x0("failed reading network response connection null");
                }
            } catch (SocketTimeoutException e) {
                throw new a1(e);
            } catch (IOException e2) {
                IAlog.a("failed reading network response", e2, new Object[0]);
                throw new x0((Throwable) e2);
            }
        }
        if (httpURLConnection == null) {
            jVar = a((InputStream) null, Scheduler.MAX_GREEDY_SCHEDULER_LIMIT, "", (Map<String, List<String>>) null, (String) null);
        } else {
            try {
                inputStream = a(httpURLConnection.getInputStream(), TextUtils.equals("gzip", httpURLConnection.getContentEncoding()));
            } catch (Exception unused) {
                inputStream = null;
            }
            jVar = a(inputStream, httpURLConnection.getResponseCode(), httpURLConnection.getResponseMessage(), httpURLConnection.getHeaderFields(), httpURLConnection.getHeaderField("Last-Modified"));
        }
        a aVar = new a(httpURLConnection, jVar.a, jVar.c, jVar.d, jVar.e);
        for (String add : list) {
            aVar.f.add(add);
        }
        return aVar;
    }

    public void b() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x00b5 A[Catch:{ Exception -> 0x012c }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0126 A[Catch:{ Exception -> 0x012c }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <T> android.util.Pair<java.util.List<java.lang.String>, java.net.HttpURLConnection> a(com.fyber.inneractive.sdk.network.c0<T> r10, java.util.List<java.lang.String> r11, java.net.URL r12, java.lang.String r13, java.lang.String r14) throws com.fyber.inneractive.sdk.network.b {
        /*
            r9 = this;
            java.lang.String r0 = "http"
            r1 = 0
            java.net.URLConnection r2 = r12.openConnection()     // Catch:{ Exception -> 0x012c }
            java.net.HttpURLConnection r2 = (java.net.HttpURLConnection) r2     // Catch:{ Exception -> 0x012c }
            boolean r3 = r10.l()     // Catch:{ Exception -> 0x012c }
            if (r3 != 0) goto L_0x0012
            r2.setInstanceFollowRedirects(r1)     // Catch:{ Exception -> 0x012c }
        L_0x0012:
            com.fyber.inneractive.sdk.network.u0 r3 = r10.n()     // Catch:{ Exception -> 0x012c }
            int r4 = r3.a     // Catch:{ Exception -> 0x012c }
            r2.setConnectTimeout(r4)     // Catch:{ Exception -> 0x012c }
            int r3 = r3.b     // Catch:{ Exception -> 0x012c }
            r2.setReadTimeout(r3)     // Catch:{ Exception -> 0x012c }
            java.lang.String r3 = "User-Agent"
            r9.a((java.net.HttpURLConnection) r2, (java.lang.String) r3, (java.lang.String) r13)     // Catch:{ Exception -> 0x012c }
            java.lang.String r3 = "If-Modified-Since"
            r9.a((java.net.HttpURLConnection) r2, (java.lang.String) r3, (java.lang.String) r14)     // Catch:{ Exception -> 0x012c }
            java.lang.String r3 = "Accept-Encoding"
            java.lang.String r4 = "gzip"
            r9.a((java.net.HttpURLConnection) r2, (java.lang.String) r3, (java.lang.String) r4)     // Catch:{ Exception -> 0x012c }
            java.util.Map r3 = r10.w()     // Catch:{ Exception -> 0x012c }
            if (r3 == 0) goto L_0x0055
            java.util.Set r4 = r3.keySet()     // Catch:{ Exception -> 0x012c }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ Exception -> 0x012c }
        L_0x003f:
            boolean r5 = r4.hasNext()     // Catch:{ Exception -> 0x012c }
            if (r5 == 0) goto L_0x0055
            java.lang.Object r5 = r4.next()     // Catch:{ Exception -> 0x012c }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ Exception -> 0x012c }
            java.lang.Object r6 = r3.get(r5)     // Catch:{ Exception -> 0x012c }
            java.lang.String r6 = (java.lang.String) r6     // Catch:{ Exception -> 0x012c }
            r9.a((java.net.HttpURLConnection) r2, (java.lang.String) r5, (java.lang.String) r6)     // Catch:{ Exception -> 0x012c }
            goto L_0x003f
        L_0x0055:
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x012c }
            r10.b(r3)     // Catch:{ Exception -> 0x012c }
            com.fyber.inneractive.sdk.network.z r3 = r10.r()     // Catch:{ Exception -> 0x012c }
            com.fyber.inneractive.sdk.network.z r4 = com.fyber.inneractive.sdk.network.z.POST     // Catch:{ Exception -> 0x012c }
            if (r3 == r4) goto L_0x0071
            com.fyber.inneractive.sdk.network.z r3 = r10.r()     // Catch:{ Exception -> 0x012c }
            com.fyber.inneractive.sdk.network.z r4 = com.fyber.inneractive.sdk.network.z.PUT     // Catch:{ Exception -> 0x012c }
            if (r3 != r4) goto L_0x006d
            goto L_0x0071
        L_0x006d:
            r2.connect()     // Catch:{ Exception -> 0x012c }
            goto L_0x0074
        L_0x0071:
            r9.a(r2, r10)     // Catch:{ Exception -> 0x012c }
        L_0x0074:
            int r3 = r2.getResponseCode()     // Catch:{ Exception -> 0x012c }
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x012c }
            r10.a((long) r4)     // Catch:{ Exception -> 0x012c }
            java.lang.String r4 = "%s (%s) response code - %d"
            r5 = 3
            java.lang.Object[] r6 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x012c }
            java.lang.String r7 = r10.toString()     // Catch:{ Exception -> 0x012c }
            r6[r1] = r7     // Catch:{ Exception -> 0x012c }
            r7 = 1
            r6[r7] = r12     // Catch:{ Exception -> 0x012c }
            java.lang.Integer r12 = java.lang.Integer.valueOf(r3)     // Catch:{ Exception -> 0x012c }
            r8 = 2
            r6[r8] = r12     // Catch:{ Exception -> 0x012c }
            com.fyber.inneractive.sdk.util.IAlog.a(r4, r6)     // Catch:{ Exception -> 0x012c }
            boolean r12 = r10.l()     // Catch:{ Exception -> 0x012c }
            if (r12 != 0) goto L_0x0126
            r12 = 300(0x12c, float:4.2E-43)
            if (r3 <= r12) goto L_0x00a5
            r12 = 304(0x130, float:4.26E-43)
            if (r3 < r12) goto L_0x00ad
        L_0x00a5:
            r12 = 307(0x133, float:4.3E-43)
            if (r3 == r12) goto L_0x00ad
            r12 = 308(0x134, float:4.32E-43)
            if (r3 != r12) goto L_0x0126
        L_0x00ad:
            java.lang.String r12 = "Location"
            java.lang.String r12 = r2.getHeaderField(r12)     // Catch:{ Exception -> 0x012c }
            if (r12 == 0) goto L_0x0126
            boolean r2 = r12.startsWith(r0)     // Catch:{ Exception -> 0x012c }
            if (r2 != 0) goto L_0x00f9
            java.lang.String r2 = "://"
            boolean r2 = r12.contains(r2)     // Catch:{ Exception -> 0x012c }
            if (r2 != 0) goto L_0x00f9
            int r2 = r11.size()     // Catch:{ Exception -> 0x012c }
            if (r2 <= 0) goto L_0x00f9
            int r2 = r11.size()     // Catch:{ Exception -> 0x012c }
            int r2 = r2 - r7
            java.lang.Object r2 = r11.get(r2)     // Catch:{ Exception -> 0x012c }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ Exception -> 0x012c }
            android.net.Uri r2 = android.net.Uri.parse(r2)     // Catch:{ Exception -> 0x012c }
            java.lang.String r3 = "/"
            boolean r3 = r12.startsWith(r3)     // Catch:{ Exception -> 0x012c }
            if (r3 == 0) goto L_0x00e3
            java.lang.String r3 = "%s://%s%s"
            goto L_0x00e5
        L_0x00e3:
            java.lang.String r3 = "%s://%s/%s"
        L_0x00e5:
            java.lang.Object[] r4 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x012c }
            java.lang.String r5 = r2.getScheme()     // Catch:{ Exception -> 0x012c }
            r4[r1] = r5     // Catch:{ Exception -> 0x012c }
            java.lang.String r2 = r2.getHost()     // Catch:{ Exception -> 0x012c }
            r4[r7] = r2     // Catch:{ Exception -> 0x012c }
            r4[r8] = r12     // Catch:{ Exception -> 0x012c }
            java.lang.String r12 = java.lang.String.format(r3, r4)     // Catch:{ Exception -> 0x012c }
        L_0x00f9:
            r11.add(r12)     // Catch:{ Exception -> 0x012c }
            int r2 = r11.size()     // Catch:{ Exception -> 0x012c }
            r3 = 5
            if (r2 > r3) goto L_0x011e
            boolean r0 = r12.startsWith(r0)     // Catch:{ Exception -> 0x012c }
            if (r0 == 0) goto L_0x0118
            java.net.URL r5 = new java.net.URL     // Catch:{ Exception -> 0x012c }
            r5.<init>(r12)     // Catch:{ Exception -> 0x012c }
            r2 = r9
            r3 = r10
            r4 = r11
            r6 = r13
            r7 = r14
            android.util.Pair r10 = r2.a(r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x012c }
            return r10
        L_0x0118:
            r12 = 0
            android.util.Pair r10 = android.util.Pair.create(r11, r12)     // Catch:{ Exception -> 0x012c }
            return r10
        L_0x011e:
            com.fyber.inneractive.sdk.network.b r11 = new com.fyber.inneractive.sdk.network.b     // Catch:{ Exception -> 0x012c }
            java.lang.String r12 = "Url chain too big for us"
            r11.<init>((java.lang.String) r12)     // Catch:{ Exception -> 0x012c }
            throw r11     // Catch:{ Exception -> 0x012c }
        L_0x0126:
            android.util.Pair r12 = new android.util.Pair     // Catch:{ Exception -> 0x012c }
            r12.<init>(r11, r2)     // Catch:{ Exception -> 0x012c }
            return r12
        L_0x012c:
            r11 = move-exception
            long r12 = java.lang.System.currentTimeMillis()
            r10.a((long) r12)
            java.lang.Object[] r10 = new java.lang.Object[r1]
            java.lang.String r12 = "failed executing network request"
            com.fyber.inneractive.sdk.util.IAlog.a(r12, r11, r10)
            com.fyber.inneractive.sdk.network.b r10 = new com.fyber.inneractive.sdk.network.b
            r10.<init>((java.lang.Throwable) r11)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.network.i.a(com.fyber.inneractive.sdk.network.c0, java.util.List, java.net.URL, java.lang.String, java.lang.String):android.util.Pair");
    }

    public final void a(HttpURLConnection httpURLConnection, c0<?> c0Var) throws Exception {
        httpURLConnection.setRequestMethod(c0Var.r().key);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setDoOutput(true);
        byte[] u = c0Var.u();
        int length = u != null ? u.length : 0;
        httpURLConnection.setRequestProperty("Content-Length", "" + length);
        httpURLConnection.setRequestProperty(z3.I, c0Var.q());
        httpURLConnection.connect();
        OutputStream outputStream = httpURLConnection.getOutputStream();
        outputStream.write(u);
        try {
            outputStream.close();
        } catch (Throwable unused) {
        }
    }

    public final void a(HttpURLConnection httpURLConnection, String str, String str2) {
        if (httpURLConnection != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            int i = IAlog.a;
            IAlog.a(1, (Exception) null, "%s %s : %s", "REQUEST_HEADER", str, str2);
            httpURLConnection.addRequestProperty(str, str2);
        }
    }
}
