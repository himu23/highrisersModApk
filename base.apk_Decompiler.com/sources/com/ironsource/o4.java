package com.ironsource;

import com.ironsource.sdk.utils.IronSourceStorageUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Callable;

class o4 implements Callable<o3> {
    private static final String d = "FileWorkerThread";
    private final n3 a;
    private final String b;
    private long c;

    o4(n3 n3Var, String str, long j) {
        this.a = n3Var;
        this.b = str;
        this.c = j;
    }

    /* access modifiers changed from: package-private */
    public int a(byte[] bArr, String str) throws Exception {
        return IronSourceStorageUtils.saveFile(bArr, str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0019, code lost:
        r1 = a(r9.a.e(), r2, r9.a.a(), r9.a.c());
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.ironsource.o3 call() {
        /*
            r9 = this;
            java.lang.String r0 = "FileWorkerThread"
            long r1 = r9.c
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 != 0) goto L_0x000e
            r1 = 1
            r9.c = r1
        L_0x000e:
            r1 = 0
            r2 = 0
        L_0x0010:
            long r3 = (long) r2
            long r5 = r9.c
            r7 = 1009(0x3f1, float:1.414E-42)
            int r8 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r8 >= 0) goto L_0x003d
            com.ironsource.n3 r1 = r9.a
            java.lang.String r1 = r1.e()
            com.ironsource.n3 r3 = r9.a
            int r3 = r3.a()
            com.ironsource.n3 r4 = r9.a
            int r4 = r4.c()
            com.ironsource.o3 r1 = r9.a(r1, r2, r3, r4)
            int r3 = r1.b()
            r4 = 1008(0x3f0, float:1.413E-42)
            if (r3 == r4) goto L_0x003a
            if (r3 == r7) goto L_0x003a
            goto L_0x003d
        L_0x003a:
            int r2 = r2 + 1
            goto L_0x0010
        L_0x003d:
            if (r1 == 0) goto L_0x00d8
            byte[] r2 = r1.a()
            if (r2 == 0) goto L_0x00d8
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = r9.b
            r2.append(r3)
            java.lang.String r3 = java.io.File.separator
            r2.append(r3)
            com.ironsource.n3 r4 = r9.a
            com.ironsource.n6 r4 = r4.b()
            java.lang.String r4 = r4.getName()
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            com.ironsource.n3 r5 = r9.a
            java.lang.String r5 = r5.d()
            r4.append(r5)
            r4.append(r3)
            java.lang.String r3 = "tmp_"
            r4.append(r3)
            com.ironsource.n3 r3 = r9.a
            com.ironsource.n6 r3 = r3.b()
            java.lang.String r3 = r3.getName()
            r4.append(r3)
            java.lang.String r3 = r4.toString()
            byte[] r4 = r1.a()     // Catch:{ FileNotFoundException -> 0x00d3, Exception -> 0x00bd, Error -> 0x00a8 }
            int r4 = r9.a((byte[]) r4, (java.lang.String) r3)     // Catch:{ FileNotFoundException -> 0x00d3, Exception -> 0x00bd, Error -> 0x00a8 }
            if (r4 != 0) goto L_0x009c
            r2 = 1006(0x3ee, float:1.41E-42)
            r1.a((int) r2)     // Catch:{ FileNotFoundException -> 0x00d3, Exception -> 0x00bd, Error -> 0x00a8 }
            goto L_0x00d8
        L_0x009c:
            boolean r2 = r9.a((java.lang.String) r3, (java.lang.String) r2)     // Catch:{ FileNotFoundException -> 0x00d3, Exception -> 0x00bd, Error -> 0x00a8 }
            if (r2 != 0) goto L_0x00d8
            r2 = 1014(0x3f6, float:1.421E-42)
            r1.a((int) r2)     // Catch:{ FileNotFoundException -> 0x00d3, Exception -> 0x00bd, Error -> 0x00a8 }
            goto L_0x00d8
        L_0x00a8:
            r2 = move-exception
            java.lang.String r3 = r2.getMessage()
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x00ba
            java.lang.String r2 = r2.getMessage()
            com.ironsource.sdk.utils.Logger.i(r0, r2)
        L_0x00ba:
            r0 = 1019(0x3fb, float:1.428E-42)
            goto L_0x00d5
        L_0x00bd:
            r2 = move-exception
            java.lang.String r3 = r2.getMessage()
            boolean r3 = android.text.TextUtils.isEmpty(r3)
            if (r3 != 0) goto L_0x00cf
            java.lang.String r2 = r2.getMessage()
            com.ironsource.sdk.utils.Logger.i(r0, r2)
        L_0x00cf:
            r1.a((int) r7)
            goto L_0x00d8
        L_0x00d3:
            r0 = 1018(0x3fa, float:1.427E-42)
        L_0x00d5:
            r1.a((int) r0)
        L_0x00d8:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.o4.call():com.ironsource.o3");
    }

    /* JADX WARNING: type inference failed for: r3v1, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r3v2, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r3v4 */
    /* JADX WARNING: type inference failed for: r3v5, types: [java.net.HttpURLConnection] */
    /* JADX WARNING: type inference failed for: r3v6, types: [java.net.HttpURLConnection] */
    /* JADX WARNING: type inference failed for: r3v7 */
    /* JADX WARNING: type inference failed for: r3v8 */
    /* JADX WARNING: type inference failed for: r3v9, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r3v13 */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x0132 A[SYNTHETIC, Splitter:B:103:0x0132] */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x013a A[Catch:{ all -> 0x0136 }] */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x0148 A[SYNTHETIC, Splitter:B:114:0x0148] */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x0150 A[Catch:{ all -> 0x014c }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x007e A[SYNTHETIC, Splitter:B:26:0x007e] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00a6 A[Catch:{ all -> 0x00e7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00af A[SYNTHETIC, Splitter:B:46:0x00af] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00b4 A[Catch:{ all -> 0x0085 }] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00cb A[Catch:{ all -> 0x00e7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00d4 A[SYNTHETIC, Splitter:B:58:0x00d4] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00dc A[Catch:{ all -> 0x00d8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00ec A[SYNTHETIC, Splitter:B:69:0x00ec] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00f4 A[Catch:{ all -> 0x00f0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0106 A[SYNTHETIC, Splitter:B:81:0x0106] */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x010e A[Catch:{ all -> 0x010a }] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x011c A[SYNTHETIC, Splitter:B:92:0x011c] */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0124 A[Catch:{ all -> 0x0120 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.ironsource.o3 a(java.lang.String r8, int r9, int r10, int r11) {
        /*
            r7 = this;
            java.lang.String r0 = "FileWorkerThread"
            java.lang.String r1 = " RESPONSE CODE: "
            com.ironsource.o3 r2 = new com.ironsource.o3
            r2.<init>()
            boolean r3 = android.text.TextUtils.isEmpty(r8)
            if (r3 == 0) goto L_0x0018
            r2.a((java.lang.String) r8)
            r8 = 1007(0x3ef, float:1.411E-42)
            r2.a((int) r8)
            return r2
        L_0x0018:
            r3 = 0
            r4 = 0
            java.net.URL r5 = new java.net.URL     // Catch:{ MalformedURLException -> 0x0144, URISyntaxException -> 0x012e, SocketTimeoutException -> 0x0118, FileNotFoundException -> 0x0102, Exception -> 0x00bf, Error -> 0x0098, all -> 0x0095 }
            r5.<init>(r8)     // Catch:{ MalformedURLException -> 0x0144, URISyntaxException -> 0x012e, SocketTimeoutException -> 0x0118, FileNotFoundException -> 0x0102, Exception -> 0x00bf, Error -> 0x0098, all -> 0x0095 }
            r5.toURI()     // Catch:{ MalformedURLException -> 0x0144, URISyntaxException -> 0x012e, SocketTimeoutException -> 0x0118, FileNotFoundException -> 0x0102, Exception -> 0x00bf, Error -> 0x0098, all -> 0x0095 }
            java.net.URLConnection r5 = r5.openConnection()     // Catch:{ MalformedURLException -> 0x0144, URISyntaxException -> 0x012e, SocketTimeoutException -> 0x0118, FileNotFoundException -> 0x0102, Exception -> 0x00bf, Error -> 0x0098, all -> 0x0095 }
            java.net.HttpURLConnection r5 = (java.net.HttpURLConnection) r5     // Catch:{ MalformedURLException -> 0x0144, URISyntaxException -> 0x012e, SocketTimeoutException -> 0x0118, FileNotFoundException -> 0x0102, Exception -> 0x00bf, Error -> 0x0098, all -> 0x0095 }
            java.lang.String r6 = "GET"
            r5.setRequestMethod(r6)     // Catch:{ MalformedURLException -> 0x0058, URISyntaxException -> 0x0055, SocketTimeoutException -> 0x0052, FileNotFoundException -> 0x004f, Exception -> 0x0091, Error -> 0x008d, all -> 0x008a }
            r5.setConnectTimeout(r10)     // Catch:{ MalformedURLException -> 0x0058, URISyntaxException -> 0x0055, SocketTimeoutException -> 0x0052, FileNotFoundException -> 0x004f, Exception -> 0x0091, Error -> 0x008d, all -> 0x008a }
            r5.setReadTimeout(r11)     // Catch:{ MalformedURLException -> 0x0058, URISyntaxException -> 0x0055, SocketTimeoutException -> 0x0052, FileNotFoundException -> 0x004f, Exception -> 0x0091, Error -> 0x008d, all -> 0x008a }
            r5.connect()     // Catch:{ MalformedURLException -> 0x0058, URISyntaxException -> 0x0055, SocketTimeoutException -> 0x0052, FileNotFoundException -> 0x004f, Exception -> 0x0091, Error -> 0x008d, all -> 0x008a }
            int r4 = r5.getResponseCode()     // Catch:{ MalformedURLException -> 0x0058, URISyntaxException -> 0x0055, SocketTimeoutException -> 0x0052, FileNotFoundException -> 0x004f, Exception -> 0x0091, Error -> 0x008d, all -> 0x008a }
            r10 = 200(0xc8, float:2.8E-43)
            if (r4 < r10) goto L_0x005b
            r10 = 400(0x190, float:5.6E-43)
            if (r4 < r10) goto L_0x0043
            goto L_0x005b
        L_0x0043:
            java.io.InputStream r3 = r5.getInputStream()     // Catch:{ MalformedURLException -> 0x0058, URISyntaxException -> 0x0055, SocketTimeoutException -> 0x0052, FileNotFoundException -> 0x004f, Exception -> 0x0091, Error -> 0x008d, all -> 0x008a }
            byte[] r9 = r7.a(r3)     // Catch:{ MalformedURLException -> 0x0058, URISyntaxException -> 0x0055, SocketTimeoutException -> 0x0052, FileNotFoundException -> 0x004f, Exception -> 0x0091, Error -> 0x008d, all -> 0x008a }
            r2.a((byte[]) r9)     // Catch:{ MalformedURLException -> 0x0058, URISyntaxException -> 0x0055, SocketTimeoutException -> 0x0052, FileNotFoundException -> 0x004f, Exception -> 0x0091, Error -> 0x008d, all -> 0x008a }
            goto L_0x007c
        L_0x004f:
            goto L_0x0104
        L_0x0052:
            goto L_0x011a
        L_0x0055:
            goto L_0x0130
        L_0x0058:
            goto L_0x0146
        L_0x005b:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ MalformedURLException -> 0x0058, URISyntaxException -> 0x0055, SocketTimeoutException -> 0x0052, FileNotFoundException -> 0x004f, Exception -> 0x0091, Error -> 0x008d, all -> 0x008a }
            r10.<init>(r1)     // Catch:{ MalformedURLException -> 0x0058, URISyntaxException -> 0x0055, SocketTimeoutException -> 0x0052, FileNotFoundException -> 0x004f, Exception -> 0x0091, Error -> 0x008d, all -> 0x008a }
            r10.append(r4)     // Catch:{ MalformedURLException -> 0x0058, URISyntaxException -> 0x0055, SocketTimeoutException -> 0x0052, FileNotFoundException -> 0x004f, Exception -> 0x0091, Error -> 0x008d, all -> 0x008a }
            java.lang.String r11 = " URL: "
            r10.append(r11)     // Catch:{ MalformedURLException -> 0x0058, URISyntaxException -> 0x0055, SocketTimeoutException -> 0x0052, FileNotFoundException -> 0x004f, Exception -> 0x0091, Error -> 0x008d, all -> 0x008a }
            r10.append(r8)     // Catch:{ MalformedURLException -> 0x0058, URISyntaxException -> 0x0055, SocketTimeoutException -> 0x0052, FileNotFoundException -> 0x004f, Exception -> 0x0091, Error -> 0x008d, all -> 0x008a }
            java.lang.String r11 = " ATTEMPT: "
            r10.append(r11)     // Catch:{ MalformedURLException -> 0x0058, URISyntaxException -> 0x0055, SocketTimeoutException -> 0x0052, FileNotFoundException -> 0x004f, Exception -> 0x0091, Error -> 0x008d, all -> 0x008a }
            r10.append(r9)     // Catch:{ MalformedURLException -> 0x0058, URISyntaxException -> 0x0055, SocketTimeoutException -> 0x0052, FileNotFoundException -> 0x004f, Exception -> 0x0091, Error -> 0x008d, all -> 0x008a }
            java.lang.String r9 = r10.toString()     // Catch:{ MalformedURLException -> 0x0058, URISyntaxException -> 0x0055, SocketTimeoutException -> 0x0052, FileNotFoundException -> 0x004f, Exception -> 0x0091, Error -> 0x008d, all -> 0x008a }
            com.ironsource.sdk.utils.Logger.i(r0, r9)     // Catch:{ MalformedURLException -> 0x0058, URISyntaxException -> 0x0055, SocketTimeoutException -> 0x0052, FileNotFoundException -> 0x004f, Exception -> 0x0091, Error -> 0x008d, all -> 0x008a }
            r4 = 1011(0x3f3, float:1.417E-42)
        L_0x007c:
            if (r3 == 0) goto L_0x0081
            r3.close()     // Catch:{ all -> 0x0085 }
        L_0x0081:
            r5.disconnect()     // Catch:{ all -> 0x0085 }
            goto L_0x00b7
        L_0x0085:
            r9 = move-exception
            r9.printStackTrace()
            goto L_0x00b7
        L_0x008a:
            r9 = move-exception
            goto L_0x00ea
        L_0x008d:
            r9 = move-exception
            r10 = r3
            r3 = r5
            goto L_0x009a
        L_0x0091:
            r9 = move-exception
            r10 = r3
            r3 = r5
            goto L_0x00c1
        L_0x0095:
            r9 = move-exception
            r5 = r3
            goto L_0x00ea
        L_0x0098:
            r9 = move-exception
            r10 = r3
        L_0x009a:
            r4 = 1019(0x3fb, float:1.428E-42)
            java.lang.String r11 = r9.getMessage()     // Catch:{ all -> 0x00e7 }
            boolean r11 = android.text.TextUtils.isEmpty(r11)     // Catch:{ all -> 0x00e7 }
            if (r11 != 0) goto L_0x00ad
            java.lang.String r9 = r9.getMessage()     // Catch:{ all -> 0x00e7 }
            com.ironsource.sdk.utils.Logger.i(r0, r9)     // Catch:{ all -> 0x00e7 }
        L_0x00ad:
            if (r10 == 0) goto L_0x00b2
            r10.close()     // Catch:{ all -> 0x0085 }
        L_0x00b2:
            if (r3 == 0) goto L_0x00b7
            r3.disconnect()     // Catch:{ all -> 0x0085 }
        L_0x00b7:
            r2.a((java.lang.String) r8)
            r2.a((int) r4)
            goto L_0x015f
        L_0x00bf:
            r9 = move-exception
            r10 = r3
        L_0x00c1:
            java.lang.String r11 = r9.getMessage()     // Catch:{ all -> 0x00e7 }
            boolean r11 = android.text.TextUtils.isEmpty(r11)     // Catch:{ all -> 0x00e7 }
            if (r11 != 0) goto L_0x00d2
            java.lang.String r9 = r9.getMessage()     // Catch:{ all -> 0x00e7 }
            com.ironsource.sdk.utils.Logger.i(r0, r9)     // Catch:{ all -> 0x00e7 }
        L_0x00d2:
            if (r10 == 0) goto L_0x00da
            r10.close()     // Catch:{ all -> 0x00d8 }
            goto L_0x00da
        L_0x00d8:
            r9 = move-exception
            goto L_0x00e0
        L_0x00da:
            if (r3 == 0) goto L_0x00e3
            r3.disconnect()     // Catch:{ all -> 0x00d8 }
            goto L_0x00e3
        L_0x00e0:
            r9.printStackTrace()
        L_0x00e3:
            r9 = 1009(0x3f1, float:1.414E-42)
            goto L_0x0159
        L_0x00e7:
            r9 = move-exception
            r5 = r3
            r3 = r10
        L_0x00ea:
            if (r3 == 0) goto L_0x00f2
            r3.close()     // Catch:{ all -> 0x00f0 }
            goto L_0x00f2
        L_0x00f0:
            r10 = move-exception
            goto L_0x00f8
        L_0x00f2:
            if (r5 == 0) goto L_0x00fb
            r5.disconnect()     // Catch:{ all -> 0x00f0 }
            goto L_0x00fb
        L_0x00f8:
            r10.printStackTrace()
        L_0x00fb:
            r2.a((java.lang.String) r8)
            r2.a((int) r4)
            throw r9
        L_0x0102:
            r5 = r3
        L_0x0104:
            if (r3 == 0) goto L_0x010c
            r3.close()     // Catch:{ all -> 0x010a }
            goto L_0x010c
        L_0x010a:
            r9 = move-exception
            goto L_0x0112
        L_0x010c:
            if (r5 == 0) goto L_0x0115
            r5.disconnect()     // Catch:{ all -> 0x010a }
            goto L_0x0115
        L_0x0112:
            r9.printStackTrace()
        L_0x0115:
            r9 = 1018(0x3fa, float:1.427E-42)
            goto L_0x0159
        L_0x0118:
            r5 = r3
        L_0x011a:
            if (r3 == 0) goto L_0x0122
            r3.close()     // Catch:{ all -> 0x0120 }
            goto L_0x0122
        L_0x0120:
            r9 = move-exception
            goto L_0x0128
        L_0x0122:
            if (r5 == 0) goto L_0x012b
            r5.disconnect()     // Catch:{ all -> 0x0120 }
            goto L_0x012b
        L_0x0128:
            r9.printStackTrace()
        L_0x012b:
            r9 = 1008(0x3f0, float:1.413E-42)
            goto L_0x0159
        L_0x012e:
            r5 = r3
        L_0x0130:
            if (r3 == 0) goto L_0x0138
            r3.close()     // Catch:{ all -> 0x0136 }
            goto L_0x0138
        L_0x0136:
            r9 = move-exception
            goto L_0x013e
        L_0x0138:
            if (r5 == 0) goto L_0x0141
            r5.disconnect()     // Catch:{ all -> 0x0136 }
            goto L_0x0141
        L_0x013e:
            r9.printStackTrace()
        L_0x0141:
            r9 = 1010(0x3f2, float:1.415E-42)
            goto L_0x0159
        L_0x0144:
            r5 = r3
        L_0x0146:
            if (r3 == 0) goto L_0x014e
            r3.close()     // Catch:{ all -> 0x014c }
            goto L_0x014e
        L_0x014c:
            r9 = move-exception
            goto L_0x0154
        L_0x014e:
            if (r5 == 0) goto L_0x0157
            r5.disconnect()     // Catch:{ all -> 0x014c }
            goto L_0x0157
        L_0x0154:
            r9.printStackTrace()
        L_0x0157:
            r9 = 1004(0x3ec, float:1.407E-42)
        L_0x0159:
            r2.a((java.lang.String) r8)
            r2.a((int) r9)
        L_0x015f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.o4.a(java.lang.String, int, int, int):com.ironsource.o3");
    }

    /* access modifiers changed from: package-private */
    public boolean a(String str, String str2) throws Exception {
        return IronSourceStorageUtils.renameFile(str, str2);
    }

    /* access modifiers changed from: package-private */
    public byte[] a(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[8192];
        while (true) {
            int read = inputStream.read(bArr, 0, 8192);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                byteArrayOutputStream.flush();
                return byteArrayOutputStream.toByteArray();
            }
        }
    }
}
