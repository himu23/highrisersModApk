package com.ironsource;

import android.net.Uri;
import android.util.Pair;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class t5 {
    private static final String a = "POST";
    private static final String b = "GET";
    private static final String c = "ISHttpService";

    public static class a {
        private static final int h = 15000;
        private static final int i = 15000;
        private static final String j = "UTF-8";
        final String a;
        final String b;
        final String c;
        final int d;
        final int e;
        final String f;
        ArrayList<Pair<String, String>> g;

        /* renamed from: com.ironsource.t5$a$a  reason: collision with other inner class name */
        static class C0027a {
            List<Pair<String, String>> a = new ArrayList();
            String b;
            String c = "POST";
            String d;
            int e = 15000;
            int f = 15000;
            String g = a.j;

            C0027a() {
            }

            /* access modifiers changed from: package-private */
            public C0027a a(int i) {
                this.e = i;
                return this;
            }

            /* access modifiers changed from: package-private */
            public C0027a a(Pair<String, String> pair) {
                this.a.add(pair);
                return this;
            }

            /* access modifiers changed from: package-private */
            public C0027a a(String str) {
                this.d = str;
                return this;
            }

            /* access modifiers changed from: package-private */
            public C0027a a(List<Pair<String, String>> list) {
                this.a.addAll(list);
                return this;
            }

            /* access modifiers changed from: package-private */
            public a a() {
                return new a(this);
            }

            /* access modifiers changed from: package-private */
            public C0027a b(int i) {
                this.f = i;
                return this;
            }

            /* access modifiers changed from: package-private */
            public C0027a b(String str) {
                this.g = str;
                return this;
            }

            /* access modifiers changed from: package-private */
            public C0027a c(String str) {
                this.b = str;
                return this;
            }

            /* access modifiers changed from: package-private */
            public C0027a d(String str) {
                this.c = str;
                return this;
            }
        }

        public a(C0027a aVar) {
            this.a = aVar.b;
            this.b = aVar.c;
            this.c = aVar.d;
            this.g = new ArrayList<>(aVar.a);
            this.d = aVar.e;
            this.e = aVar.f;
            this.f = aVar.g;
        }

        /* access modifiers changed from: package-private */
        public boolean a() {
            return "POST".equals(this.b);
        }
    }

    public static pa a(String str, String str2, List<Pair<String, String>> list) throws Exception {
        Uri build = Uri.parse(str).buildUpon().encodedQuery(str2).build();
        a.C0027a aVar = new a.C0027a();
        aVar.c(build.toString()).a(str2).d("GET").a(list);
        return b(aVar.a());
    }

    private static HttpURLConnection a(a aVar) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(aVar.a).openConnection();
        httpURLConnection.setConnectTimeout(aVar.d);
        httpURLConnection.setReadTimeout(aVar.e);
        httpURLConnection.setRequestMethod(aVar.b);
        return httpURLConnection;
    }

    private static void a(HttpURLConnection httpURLConnection, a aVar) throws Exception {
        if (aVar.a()) {
            byte[] bytes = aVar.c.getBytes(aVar.f);
            httpURLConnection.setRequestProperty("Content-Length", Integer.toString(bytes.length));
            a(httpURLConnection, bytes);
        }
    }

    private static void a(HttpURLConnection httpURLConnection, List<Pair<String, String>> list) throws ProtocolException {
        for (Pair next : list) {
            httpURLConnection.setRequestProperty((String) next.first, (String) next.second);
        }
    }

    private static void a(HttpURLConnection httpURLConnection, byte[] bArr) throws Exception {
        httpURLConnection.setDoOutput(true);
        DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
        try {
            dataOutputStream.write(bArr);
            dataOutputStream.flush();
        } finally {
            dataOutputStream.close();
        }
    }

    private static boolean a(String str, String str2) {
        return str != null && !str.isEmpty() && str2 != null && !str2.isEmpty();
    }

    /* JADX WARNING: type inference failed for: r2v1 */
    /* JADX WARNING: type inference failed for: r2v2, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r2v4, types: [java.net.HttpURLConnection] */
    /* JADX WARNING: type inference failed for: r2v5 */
    /* JADX WARNING: type inference failed for: r2v7 */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0030, code lost:
        if (r2 != null) goto L_0x006d;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0041 A[SYNTHETIC, Splitter:B:18:0x0041] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0082  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.ironsource.pa b(com.ironsource.t5.a r8) throws java.lang.Exception {
        /*
            java.lang.String r0 = "Failed post to "
            java.lang.String r1 = r8.a
            java.lang.String r2 = r8.c
            boolean r1 = a((java.lang.String) r1, (java.lang.String) r2)
            if (r1 == 0) goto L_0x0086
            com.ironsource.pa r1 = new com.ironsource.pa
            r1.<init>()
            r2 = 0
            java.net.HttpURLConnection r3 = a(r8)     // Catch:{ IOException -> 0x003d, all -> 0x003a }
            java.util.ArrayList<android.util.Pair<java.lang.String, java.lang.String>> r4 = r8.g     // Catch:{ IOException -> 0x0035, all -> 0x0033 }
            a((java.net.HttpURLConnection) r3, (java.util.List<android.util.Pair<java.lang.String, java.lang.String>>) r4)     // Catch:{ IOException -> 0x0035, all -> 0x0033 }
            a((java.net.HttpURLConnection) r3, (com.ironsource.t5.a) r8)     // Catch:{ IOException -> 0x0035, all -> 0x0033 }
            java.io.InputStream r2 = r3.getInputStream()     // Catch:{ IOException -> 0x0035, all -> 0x0033 }
            int r4 = r3.getResponseCode()     // Catch:{ IOException -> 0x0035, all -> 0x0033 }
            r1.a = r4     // Catch:{ IOException -> 0x0035, all -> 0x0033 }
            if (r2 == 0) goto L_0x0030
            byte[] r4 = com.ironsource.rc.a(r2)     // Catch:{ IOException -> 0x0035, all -> 0x0033 }
            r1.b = r4     // Catch:{ IOException -> 0x0035, all -> 0x0033 }
        L_0x0030:
            if (r2 == 0) goto L_0x0072
            goto L_0x006d
        L_0x0033:
            r8 = move-exception
            goto L_0x007b
        L_0x0035:
            r4 = move-exception
            r7 = r3
            r3 = r2
            r2 = r7
            goto L_0x003f
        L_0x003a:
            r8 = move-exception
            r3 = r2
            goto L_0x007b
        L_0x003d:
            r4 = move-exception
            r3 = r2
        L_0x003f:
            if (r2 == 0) goto L_0x0076
            int r5 = r2.getResponseCode()     // Catch:{ all -> 0x0077 }
            r1.a = r5     // Catch:{ all -> 0x0077 }
            r6 = 400(0x190, float:5.6E-43)
            if (r5 < r6) goto L_0x0076
            java.lang.String r4 = "ISHttpService"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0077 }
            r5.<init>(r0)     // Catch:{ all -> 0x0077 }
            java.lang.String r8 = r8.a     // Catch:{ all -> 0x0077 }
            r5.append(r8)     // Catch:{ all -> 0x0077 }
            java.lang.String r8 = " StatusCode: "
            r5.append(r8)     // Catch:{ all -> 0x0077 }
            int r8 = r1.a     // Catch:{ all -> 0x0077 }
            r5.append(r8)     // Catch:{ all -> 0x0077 }
            java.lang.String r8 = r5.toString()     // Catch:{ all -> 0x0077 }
            android.util.Log.d(r4, r8)     // Catch:{ all -> 0x0077 }
            if (r3 == 0) goto L_0x0071
            r7 = r3
            r3 = r2
            r2 = r7
        L_0x006d:
            r2.close()
            goto L_0x0072
        L_0x0071:
            r3 = r2
        L_0x0072:
            r3.disconnect()
            return r1
        L_0x0076:
            throw r4     // Catch:{ all -> 0x0077 }
        L_0x0077:
            r8 = move-exception
            r7 = r3
            r3 = r2
            r2 = r7
        L_0x007b:
            if (r2 == 0) goto L_0x0080
            r2.close()
        L_0x0080:
            if (r3 == 0) goto L_0x0085
            r3.disconnect()
        L_0x0085:
            throw r8
        L_0x0086:
            java.security.InvalidParameterException r8 = new java.security.InvalidParameterException
            java.lang.String r0 = "not valid params"
            r8.<init>(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.t5.b(com.ironsource.t5$a):com.ironsource.pa");
    }

    public static pa b(String str, String str2, List<Pair<String, String>> list) throws Exception {
        a.C0027a aVar = new a.C0027a();
        aVar.c(str).a(str2).d("POST").a(list);
        return b(aVar.a());
    }
}
