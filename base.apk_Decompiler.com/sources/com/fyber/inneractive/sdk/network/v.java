package com.fyber.inneractive.sdk.network;

import android.content.Context;
import android.content.SharedPreferences;

public class v<ResultData> {
    public final Context a;
    public com.fyber.inneractive.sdk.cache.a<ResultData> b;
    public SharedPreferences c;

    public static class a extends Exception {
    }

    public v(Context context, com.fyber.inneractive.sdk.cache.a<ResultData> aVar) {
        this.a = context;
        this.b = aVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0049 A[SYNTHETIC, Splitter:B:19:0x0049] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(java.lang.String r7, java.lang.String r8) {
        /*
            r6 = this;
            java.lang.String r0 = "Failed closing cache file: %s"
            r1 = 1
            java.lang.Object[] r2 = new java.lang.Object[r1]
            r3 = 0
            r2[r3] = r7
            java.lang.String r4 = "caching file %s"
            com.fyber.inneractive.sdk.util.IAlog.a(r4, r2)
            r2 = 0
            android.content.Context r4 = r6.a     // Catch:{ Exception -> 0x0038 }
            java.io.FileOutputStream r2 = r4.openFileOutput(r7, r3)     // Catch:{ Exception -> 0x0038 }
            byte[] r7 = r8.getBytes()     // Catch:{ Exception -> 0x0038 }
            r2.write(r7)     // Catch:{ Exception -> 0x0038 }
            java.lang.String r7 = "File cached successfully"
            java.lang.Object[] r8 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x0033 }
            com.fyber.inneractive.sdk.util.IAlog.a(r7, r8)     // Catch:{ Exception -> 0x0033 }
            r2.close()     // Catch:{ Exception -> 0x0026 }
            goto L_0x005a
        L_0x0026:
            r7 = move-exception
            java.lang.Object[] r8 = new java.lang.Object[r1]
            java.lang.String r7 = r7.getMessage()
            r8[r3] = r7
            com.fyber.inneractive.sdk.util.IAlog.e(r0, r8)
            goto L_0x005a
        L_0x0033:
            r7 = move-exception
            r8 = 1
            goto L_0x003a
        L_0x0036:
            r7 = move-exception
            goto L_0x005b
        L_0x0038:
            r7 = move-exception
            r8 = 0
        L_0x003a:
            java.lang.String r4 = "Failed caching file: %s"
            java.lang.Object[] r5 = new java.lang.Object[r1]     // Catch:{ all -> 0x0036 }
            java.lang.String r7 = r7.getMessage()     // Catch:{ all -> 0x0036 }
            r5[r3] = r7     // Catch:{ all -> 0x0036 }
            com.fyber.inneractive.sdk.util.IAlog.e(r4, r5)     // Catch:{ all -> 0x0036 }
            if (r2 == 0) goto L_0x0059
            r2.close()     // Catch:{ Exception -> 0x004d }
            goto L_0x0059
        L_0x004d:
            r7 = move-exception
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.String r7 = r7.getMessage()
            r1[r3] = r7
            com.fyber.inneractive.sdk.util.IAlog.e(r0, r1)
        L_0x0059:
            r1 = r8
        L_0x005a:
            return r1
        L_0x005b:
            if (r2 == 0) goto L_0x006d
            r2.close()     // Catch:{ Exception -> 0x0061 }
            goto L_0x006d
        L_0x0061:
            r8 = move-exception
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.String r8 = r8.getMessage()
            r1[r3] = r8
            com.fyber.inneractive.sdk.util.IAlog.e(r0, r1)
        L_0x006d:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.network.v.a(java.lang.String, java.lang.String):boolean");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r2v1 */
    /* JADX WARNING: type inference failed for: r2v2, types: [java.io.FileInputStream] */
    /* JADX WARNING: type inference failed for: r2v6 */
    /* JADX WARNING: type inference failed for: r2v7 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0040 A[Catch:{ all -> 0x006f }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0069 A[SYNTHETIC, Splitter:B:25:0x0069] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0073 A[SYNTHETIC, Splitter:B:31:0x0073] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String a(java.lang.String r9) throws java.io.FileNotFoundException {
        /*
            r8 = this;
            java.lang.String r0 = "Failed closing local file: %s"
            r1 = 1
            java.lang.Object[] r2 = new java.lang.Object[r1]
            r3 = 0
            r2[r3] = r9
            java.lang.String r4 = "reading local file: %s"
            com.fyber.inneractive.sdk.util.IAlog.a(r4, r2)
            r2 = 0
            android.content.Context r4 = r8.a     // Catch:{ Exception -> 0x003a, all -> 0x0038 }
            java.io.FileInputStream r4 = r4.openFileInput(r9)     // Catch:{ Exception -> 0x003a, all -> 0x0038 }
            int r5 = r4.available()     // Catch:{ Exception -> 0x0036 }
            byte[] r5 = new byte[r5]     // Catch:{ Exception -> 0x0036 }
            r4.read(r5)     // Catch:{ Exception -> 0x0036 }
            java.lang.String r6 = new java.lang.String     // Catch:{ Exception -> 0x0036 }
            java.lang.String r7 = "UTF-8"
            r6.<init>(r5, r7)     // Catch:{ Exception -> 0x0036 }
            r4.close()     // Catch:{ Exception -> 0x0028 }
            goto L_0x0034
        L_0x0028:
            r2 = move-exception
            java.lang.Object[] r4 = new java.lang.Object[r1]
            java.lang.String r2 = r2.getMessage()
            r4[r3] = r2
            com.fyber.inneractive.sdk.util.IAlog.e(r0, r4)
        L_0x0034:
            r2 = r6
            goto L_0x005f
        L_0x0036:
            r5 = move-exception
            goto L_0x003c
        L_0x0038:
            r9 = move-exception
            goto L_0x0071
        L_0x003a:
            r5 = move-exception
            r4 = r2
        L_0x003c:
            boolean r6 = r5 instanceof java.io.FileNotFoundException     // Catch:{ all -> 0x006f }
            if (r6 != 0) goto L_0x0069
            java.lang.String r6 = "Failed reading local file: %s"
            java.lang.Object[] r7 = new java.lang.Object[r1]     // Catch:{ all -> 0x006f }
            java.lang.String r5 = r5.getMessage()     // Catch:{ all -> 0x006f }
            r7[r3] = r5     // Catch:{ all -> 0x006f }
            com.fyber.inneractive.sdk.util.IAlog.a(r6, r7)     // Catch:{ all -> 0x006f }
            if (r4 == 0) goto L_0x005f
            r4.close()     // Catch:{ Exception -> 0x0053 }
            goto L_0x005f
        L_0x0053:
            r4 = move-exception
            java.lang.Object[] r5 = new java.lang.Object[r1]
            java.lang.String r4 = r4.getMessage()
            r5[r3] = r4
            com.fyber.inneractive.sdk.util.IAlog.e(r0, r5)
        L_0x005f:
            java.lang.Object[] r0 = new java.lang.Object[r1]
            r0[r3] = r9
            java.lang.String r9 = "local file %s read successfully"
            com.fyber.inneractive.sdk.util.IAlog.a(r9, r0)
            return r2
        L_0x0069:
            java.io.FileNotFoundException r9 = new java.io.FileNotFoundException     // Catch:{ all -> 0x006f }
            r9.<init>()     // Catch:{ all -> 0x006f }
            throw r9     // Catch:{ all -> 0x006f }
        L_0x006f:
            r9 = move-exception
            r2 = r4
        L_0x0071:
            if (r2 == 0) goto L_0x0083
            r2.close()     // Catch:{ Exception -> 0x0077 }
            goto L_0x0083
        L_0x0077:
            r2 = move-exception
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.String r2 = r2.getMessage()
            r1[r3] = r2
            com.fyber.inneractive.sdk.util.IAlog.e(r0, r1)
        L_0x0083:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.network.v.a(java.lang.String):java.lang.String");
    }
}
