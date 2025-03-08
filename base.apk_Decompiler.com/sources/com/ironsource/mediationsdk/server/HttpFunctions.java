package com.ironsource.mediationsdk.server;

import com.ironsource.mediationsdk.p;
import com.ironsource.y4;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpFunctions {
    public static final String ERROR_PREFIX = "ERROR:";
    private static final int a = 15000;
    private static final String b = "GET";
    private static final String c = "POST";
    private static final String d = "UTF-8";
    private static final String e = "Bad Request - 400";
    private static final ExecutorService f = Executors.newSingleThreadExecutor();

    class a implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ String b;
        final /* synthetic */ String c;
        final /* synthetic */ String d;
        final /* synthetic */ y4 e;

        a(String str, String str2, String str3, String str4, y4 y4Var) {
            this.a = str;
            this.b = str2;
            this.c = str3;
            this.d = str4;
            this.e = y4Var;
        }

        /* JADX WARNING: type inference failed for: r3v0, types: [java.io.OutputStream, java.lang.Throwable] */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x00a7 A[SYNTHETIC, Splitter:B:32:0x00a7] */
        /* JADX WARNING: Removed duplicated region for block: B:40:0x00b8 A[SYNTHETIC, Splitter:B:40:0x00b8] */
        /* JADX WARNING: Removed duplicated region for block: B:45:0x00c2  */
        /* JADX WARNING: Removed duplicated region for block: B:48:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r9 = this;
                java.lang.String r0 = "invalid response code "
                java.lang.String r1 = "exception while sending request "
                r2 = 0
                r3 = 0
                java.net.URL r4 = new java.net.URL     // Catch:{ Exception -> 0x0086, all -> 0x0083 }
                java.lang.String r5 = r9.a     // Catch:{ Exception -> 0x0086, all -> 0x0083 }
                r4.<init>(r5)     // Catch:{ Exception -> 0x0086, all -> 0x0083 }
                java.lang.String r5 = r9.b     // Catch:{ Exception -> 0x0086, all -> 0x0083 }
                if (r5 == 0) goto L_0x001a
                java.lang.String r6 = r9.c     // Catch:{ Exception -> 0x0086, all -> 0x0083 }
                if (r6 != 0) goto L_0x0016
                goto L_0x001a
            L_0x0016:
                com.ironsource.mediationsdk.utils.IronSourceUtils.getBase64Auth(r5, r6)     // Catch:{ Exception -> 0x0086, all -> 0x0083 }
                throw r3     // Catch:{ Exception -> 0x0086, all -> 0x0083 }
            L_0x001a:
                java.net.URLConnection r4 = r4.openConnection()     // Catch:{ Exception -> 0x0086, all -> 0x0083 }
                java.net.HttpURLConnection r4 = (java.net.HttpURLConnection) r4     // Catch:{ Exception -> 0x0086, all -> 0x0083 }
                r5 = 15000(0x3a98, float:2.102E-41)
                r4.setReadTimeout(r5)     // Catch:{ Exception -> 0x0081 }
                r4.setConnectTimeout(r5)     // Catch:{ Exception -> 0x0081 }
                java.lang.String r5 = "POST"
                r4.setRequestMethod(r5)     // Catch:{ Exception -> 0x0081 }
                r5 = 1
                r4.setDoInput(r5)     // Catch:{ Exception -> 0x0081 }
                r4.setDoOutput(r5)     // Catch:{ Exception -> 0x0081 }
                java.io.OutputStream r3 = r4.getOutputStream()     // Catch:{ Exception -> 0x0081 }
                java.io.BufferedWriter r6 = new java.io.BufferedWriter     // Catch:{ Exception -> 0x0081 }
                java.io.OutputStreamWriter r7 = new java.io.OutputStreamWriter     // Catch:{ Exception -> 0x0081 }
                java.lang.String r8 = "UTF-8"
                r7.<init>(r3, r8)     // Catch:{ Exception -> 0x0081 }
                r6.<init>(r7)     // Catch:{ Exception -> 0x0081 }
                java.lang.String r7 = r9.d     // Catch:{ Exception -> 0x0081 }
                r6.write(r7)     // Catch:{ Exception -> 0x0081 }
                r6.flush()     // Catch:{ Exception -> 0x0081 }
                r6.close()     // Catch:{ Exception -> 0x0081 }
                int r6 = r4.getResponseCode()     // Catch:{ Exception -> 0x0081 }
                r7 = 200(0xc8, float:2.8E-43)
                if (r6 != r7) goto L_0x0058
                goto L_0x0059
            L_0x0058:
                r5 = 0
            L_0x0059:
                if (r5 != 0) goto L_0x0071
                com.ironsource.mediationsdk.logger.IronLog r7 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL     // Catch:{ Exception -> 0x0081 }
                java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0081 }
                r8.<init>(r0)     // Catch:{ Exception -> 0x0081 }
                r8.append(r6)     // Catch:{ Exception -> 0x0081 }
                java.lang.String r0 = " sending request"
                r8.append(r0)     // Catch:{ Exception -> 0x0081 }
                java.lang.String r0 = r8.toString()     // Catch:{ Exception -> 0x0081 }
                r7.error(r0)     // Catch:{ Exception -> 0x0081 }
            L_0x0071:
                com.ironsource.y4 r0 = r9.e     // Catch:{ Exception -> 0x0081 }
                r0.a(r5)     // Catch:{ Exception -> 0x0081 }
                if (r3 == 0) goto L_0x00b1
                r3.close()     // Catch:{ IOException -> 0x007c }
                goto L_0x00b1
            L_0x007c:
                r0 = move-exception
                r0.printStackTrace()
                goto L_0x00b1
            L_0x0081:
                r0 = move-exception
                goto L_0x0088
            L_0x0083:
                r0 = move-exception
                r4 = r3
                goto L_0x00b6
            L_0x0086:
                r0 = move-exception
                r4 = r3
            L_0x0088:
                r0.printStackTrace()     // Catch:{ all -> 0x00b5 }
                com.ironsource.mediationsdk.logger.IronLog r5 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL     // Catch:{ all -> 0x00b5 }
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b5 }
                r6.<init>(r1)     // Catch:{ all -> 0x00b5 }
                java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x00b5 }
                r6.append(r0)     // Catch:{ all -> 0x00b5 }
                java.lang.String r0 = r6.toString()     // Catch:{ all -> 0x00b5 }
                r5.error(r0)     // Catch:{ all -> 0x00b5 }
                com.ironsource.y4 r0 = r9.e     // Catch:{ all -> 0x00b5 }
                r0.a(r2)     // Catch:{ all -> 0x00b5 }
                if (r3 == 0) goto L_0x00af
                r3.close()     // Catch:{ IOException -> 0x00ab }
                goto L_0x00af
            L_0x00ab:
                r0 = move-exception
                r0.printStackTrace()
            L_0x00af:
                if (r4 == 0) goto L_0x00b4
            L_0x00b1:
                r4.disconnect()
            L_0x00b4:
                return
            L_0x00b5:
                r0 = move-exception
            L_0x00b6:
                if (r3 == 0) goto L_0x00c0
                r3.close()     // Catch:{ IOException -> 0x00bc }
                goto L_0x00c0
            L_0x00bc:
                r1 = move-exception
                r1.printStackTrace()
            L_0x00c0:
                if (r4 == 0) goto L_0x00c5
                r4.disconnect()
            L_0x00c5:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.server.HttpFunctions.a.run():void");
        }
    }

    public static String getStringFromURL(String str) throws Exception {
        return getStringFromURL(str, (p.c) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0084  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getStringFromURL(java.lang.String r4, com.ironsource.mediationsdk.p.c r5) throws java.lang.Exception {
        /*
            r0 = 0
            java.net.URL r1 = new java.net.URL     // Catch:{ Exception -> 0x007a, all -> 0x006d }
            r1.<init>(r4)     // Catch:{ Exception -> 0x007a, all -> 0x006d }
            java.net.URLConnection r4 = r1.openConnection()     // Catch:{ Exception -> 0x007a, all -> 0x006d }
            java.net.HttpURLConnection r4 = (java.net.HttpURLConnection) r4     // Catch:{ Exception -> 0x007a, all -> 0x006d }
            r1 = 15000(0x3a98, float:2.102E-41)
            r4.setReadTimeout(r1)     // Catch:{ Exception -> 0x006b, all -> 0x0069 }
            r4.setConnectTimeout(r1)     // Catch:{ Exception -> 0x006b, all -> 0x0069 }
            java.lang.String r1 = "GET"
            r4.setRequestMethod(r1)     // Catch:{ Exception -> 0x006b, all -> 0x0069 }
            r1 = 1
            r4.setDoInput(r1)     // Catch:{ Exception -> 0x006b, all -> 0x0069 }
            r4.connect()     // Catch:{ Exception -> 0x006b, all -> 0x0069 }
            int r1 = r4.getResponseCode()     // Catch:{ Exception -> 0x006b, all -> 0x0069 }
            r2 = 400(0x190, float:5.6E-43)
            if (r1 != r2) goto L_0x0033
            if (r5 == 0) goto L_0x002f
            java.lang.String r1 = "Bad Request - 400"
            r5.a(r1)     // Catch:{ Exception -> 0x006b, all -> 0x0069 }
        L_0x002f:
            r4.disconnect()
            return r0
        L_0x0033:
            java.io.BufferedReader r5 = new java.io.BufferedReader     // Catch:{ Exception -> 0x006b, all -> 0x0069 }
            java.io.InputStreamReader r1 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x006b, all -> 0x0069 }
            java.io.InputStream r2 = r4.getInputStream()     // Catch:{ Exception -> 0x006b, all -> 0x0069 }
            r1.<init>(r2)     // Catch:{ Exception -> 0x006b, all -> 0x0069 }
            r5.<init>(r1)     // Catch:{ Exception -> 0x006b, all -> 0x0069 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0067, all -> 0x0062 }
            r1.<init>()     // Catch:{ Exception -> 0x0067, all -> 0x0062 }
        L_0x0046:
            java.lang.String r2 = r5.readLine()     // Catch:{ Exception -> 0x0067, all -> 0x0062 }
            if (r2 == 0) goto L_0x0050
            r1.append(r2)     // Catch:{ Exception -> 0x0067, all -> 0x0062 }
            goto L_0x0046
        L_0x0050:
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0067, all -> 0x0062 }
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x0067, all -> 0x0062 }
            r4.disconnect()
            r5.close()
            if (r2 == 0) goto L_0x0061
            return r0
        L_0x0061:
            return r1
        L_0x0062:
            r0 = move-exception
            r3 = r0
            r0 = r5
            r5 = r3
            goto L_0x006f
        L_0x0067:
            goto L_0x007d
        L_0x0069:
            r5 = move-exception
            goto L_0x006f
        L_0x006b:
            goto L_0x007c
        L_0x006d:
            r5 = move-exception
            r4 = r0
        L_0x006f:
            if (r4 == 0) goto L_0x0074
            r4.disconnect()
        L_0x0074:
            if (r0 == 0) goto L_0x0079
            r0.close()
        L_0x0079:
            throw r5
        L_0x007a:
            r4 = r0
        L_0x007c:
            r5 = r0
        L_0x007d:
            if (r4 == 0) goto L_0x0082
            r4.disconnect()
        L_0x0082:
            if (r5 == 0) goto L_0x0087
            r5.close()
        L_0x0087:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.server.HttpFunctions.getStringFromURL(java.lang.String, com.ironsource.mediationsdk.p$c):java.lang.String");
    }

    public static void sendPostRequest(String str, String str2, y4 y4Var) {
        sendPostRequestWithAutho(str, str2, (String) null, (String) null, y4Var);
    }

    public static void sendPostRequestWithAutho(String str, String str2, String str3, String str4, y4 y4Var) {
        f.submit(new a(str, str3, str4, str2, y4Var));
    }
}
