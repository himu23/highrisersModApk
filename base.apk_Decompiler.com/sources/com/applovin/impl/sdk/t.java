package com.applovin.impl.sdk;

import android.content.Context;
import android.net.Uri;
import android.support.v4.media.session.PlaybackStateCompat;
import com.applovin.impl.sdk.c.b;
import com.applovin.impl.sdk.d.e;
import com.applovin.impl.sdk.d.f;
import com.applovin.impl.sdk.e.ab;
import com.applovin.impl.sdk.e.d;
import com.applovin.impl.sdk.e.q;
import com.applovin.impl.sdk.r;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.u;
import com.ironsource.m2;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class t {
    private final String TAG = "FileManager";
    private final Object aEU = new Object();
    private final Set<String> aEV = new HashSet();
    private final x logger;
    private final n sdk;

    t(n nVar) {
        this.sdk = nVar;
        this.logger = nVar.BN();
    }

    public File a(String str, Context context) {
        return a(str, true, context);
    }

    private File a(String str, boolean z, Context context) {
        if (!StringUtils.isValidString(str)) {
            if (x.Fn()) {
                this.logger.f("FileManager", "Nothing to look up, skipping...");
            }
            return null;
        }
        if (x.Fn()) {
            x xVar = this.logger;
            xVar.f("FileManager", "Looking up cached resource: " + str);
        }
        String replace = str.contains(m2.h.H0) ? str.replace("/", "_").replace(".", "_") : str;
        File K = K(context);
        File file = new File(K, replace);
        if (u.a(b.aLU, this.sdk)) {
            boolean z2 = file.length() == 0;
            boolean equals = str.equals(".nomedia");
            if (file.exists() && z2 && !equals) {
                this.sdk.Cs().a(r.a.FILE_ERROR, "removeEmptyCachedResource", file.getAbsolutePath());
                b(file);
            }
        }
        if (z) {
            try {
                K.mkdirs();
            } catch (Throwable th) {
                if (x.Fn()) {
                    x xVar2 = this.logger;
                    xVar2.c("FileManager", "Unable to make cache directory at " + K, th);
                }
                this.sdk.Cs().d("FileManager", "createCacheDir", th);
                return null;
            }
        }
        return file;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v11, resolved type: com.applovin.impl.sdk.x} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v12, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v16, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v22, resolved type: boolean} */
    /* JADX WARNING: type inference failed for: r2v2, types: [java.io.Closeable] */
    /* JADX WARNING: type inference failed for: r2v13 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0076 A[Catch:{ FileNotFoundException -> 0x00b8, IOException -> 0x0087, all -> 0x006e, all -> 0x00e3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x008f A[Catch:{ FileNotFoundException -> 0x00b8, IOException -> 0x0087, all -> 0x006e, all -> 0x00e3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00c0 A[Catch:{ FileNotFoundException -> 0x00b8, IOException -> 0x0087, all -> 0x006e, all -> 0x00e3 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String a(java.io.File r10) {
        /*
            r9 = this;
            java.lang.String r0 = "readFile"
            r1 = 0
            if (r10 != 0) goto L_0x0006
            return r1
        L_0x0006:
            boolean r2 = com.applovin.impl.sdk.x.Fn()
            java.lang.String r3 = "FileManager"
            if (r2 == 0) goto L_0x0025
            com.applovin.impl.sdk.x r2 = r9.logger
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "Reading resource from filesystem: "
            r4.<init>(r5)
            java.lang.String r5 = r10.getName()
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            r2.f(r3, r4)
        L_0x0025:
            r9.c(r10)     // Catch:{ FileNotFoundException -> 0x00b8, IOException -> 0x0087, all -> 0x006e }
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x00b8, IOException -> 0x0087, all -> 0x006e }
            r2.<init>(r10)     // Catch:{ FileNotFoundException -> 0x00b8, IOException -> 0x0087, all -> 0x006e }
            java.io.ByteArrayOutputStream r4 = new java.io.ByteArrayOutputStream     // Catch:{ FileNotFoundException -> 0x006c, IOException -> 0x006a, all -> 0x0068 }
            r4.<init>()     // Catch:{ FileNotFoundException -> 0x006c, IOException -> 0x006a, all -> 0x0068 }
            r5 = 8192(0x2000, float:1.14794E-41)
            byte[] r6 = new byte[r5]     // Catch:{ FileNotFoundException -> 0x006c, IOException -> 0x006a, all -> 0x0068 }
        L_0x0036:
            r7 = 0
            int r8 = r2.read(r6, r7, r5)     // Catch:{ FileNotFoundException -> 0x006c, IOException -> 0x006a, all -> 0x0068 }
            if (r8 < 0) goto L_0x0059
            r4.write(r6, r7, r8)     // Catch:{ all -> 0x0041 }
            goto L_0x0036
        L_0x0041:
            r5 = move-exception
            com.applovin.impl.sdk.n r6 = r9.sdk     // Catch:{ FileNotFoundException -> 0x006c, IOException -> 0x006a, all -> 0x0068 }
            com.applovin.impl.sdk.utils.u.a((java.io.Closeable) r4, (com.applovin.impl.sdk.n) r6)     // Catch:{ FileNotFoundException -> 0x006c, IOException -> 0x006a, all -> 0x0068 }
            com.applovin.impl.sdk.n r4 = r9.sdk     // Catch:{ FileNotFoundException -> 0x006c, IOException -> 0x006a, all -> 0x0068 }
            com.applovin.impl.sdk.r r4 = r4.Cs()     // Catch:{ FileNotFoundException -> 0x006c, IOException -> 0x006a, all -> 0x0068 }
            r4.d(r3, r0, r5)     // Catch:{ FileNotFoundException -> 0x006c, IOException -> 0x006a, all -> 0x0068 }
        L_0x0050:
            com.applovin.impl.sdk.n r0 = r9.sdk
            com.applovin.impl.sdk.utils.u.a((java.io.Closeable) r2, (com.applovin.impl.sdk.n) r0)
            r9.d(r10)
            return r1
        L_0x0059:
            java.lang.String r5 = "UTF-8"
            java.lang.String r0 = r4.toString(r5)     // Catch:{ FileNotFoundException -> 0x006c, IOException -> 0x006a, all -> 0x0068 }
            com.applovin.impl.sdk.n r1 = r9.sdk
            com.applovin.impl.sdk.utils.u.a((java.io.Closeable) r2, (com.applovin.impl.sdk.n) r1)
            r9.d(r10)
            return r0
        L_0x0068:
            r4 = move-exception
            goto L_0x0070
        L_0x006a:
            r0 = move-exception
            goto L_0x0089
        L_0x006c:
            r0 = move-exception
            goto L_0x00ba
        L_0x006e:
            r4 = move-exception
            r2 = r1
        L_0x0070:
            boolean r5 = com.applovin.impl.sdk.x.Fn()     // Catch:{ all -> 0x00e3 }
            if (r5 == 0) goto L_0x007d
            com.applovin.impl.sdk.x r5 = r9.logger     // Catch:{ all -> 0x00e3 }
            java.lang.String r6 = "Unknown failure to read file."
            r5.c(r3, r6, r4)     // Catch:{ all -> 0x00e3 }
        L_0x007d:
            com.applovin.impl.sdk.n r5 = r9.sdk     // Catch:{ all -> 0x00e3 }
            com.applovin.impl.sdk.r r5 = r5.Cs()     // Catch:{ all -> 0x00e3 }
            r5.d(r3, r0, r4)     // Catch:{ all -> 0x00e3 }
            goto L_0x0050
        L_0x0087:
            r0 = move-exception
            r2 = r1
        L_0x0089:
            boolean r4 = com.applovin.impl.sdk.x.Fn()     // Catch:{ all -> 0x00e3 }
            if (r4 == 0) goto L_0x00ac
            com.applovin.impl.sdk.x r4 = r9.logger     // Catch:{ all -> 0x00e3 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00e3 }
            r5.<init>()     // Catch:{ all -> 0x00e3 }
            java.lang.String r6 = "Failed to read file: "
            r5.append(r6)     // Catch:{ all -> 0x00e3 }
            java.lang.String r6 = r10.getName()     // Catch:{ all -> 0x00e3 }
            r5.append(r6)     // Catch:{ all -> 0x00e3 }
            r5.append(r0)     // Catch:{ all -> 0x00e3 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x00e3 }
            r4.f(r3, r5)     // Catch:{ all -> 0x00e3 }
        L_0x00ac:
            com.applovin.impl.sdk.n r4 = r9.sdk     // Catch:{ all -> 0x00e3 }
            com.applovin.impl.sdk.r r4 = r4.Cs()     // Catch:{ all -> 0x00e3 }
            java.lang.String r5 = "readFileIO"
            r4.d(r3, r5, r0)     // Catch:{ all -> 0x00e3 }
            goto L_0x0050
        L_0x00b8:
            r0 = move-exception
            r2 = r1
        L_0x00ba:
            boolean r4 = com.applovin.impl.sdk.x.Fn()     // Catch:{ all -> 0x00e3 }
            if (r4 == 0) goto L_0x00d6
            com.applovin.impl.sdk.x r4 = r9.logger     // Catch:{ all -> 0x00e3 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00e3 }
            r5.<init>()     // Catch:{ all -> 0x00e3 }
            java.lang.String r6 = "File not found. "
            r5.append(r6)     // Catch:{ all -> 0x00e3 }
            r5.append(r0)     // Catch:{ all -> 0x00e3 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x00e3 }
            r4.g(r3, r5)     // Catch:{ all -> 0x00e3 }
        L_0x00d6:
            com.applovin.impl.sdk.n r4 = r9.sdk     // Catch:{ all -> 0x00e3 }
            com.applovin.impl.sdk.r r4 = r4.Cs()     // Catch:{ all -> 0x00e3 }
            java.lang.String r5 = "readFileNotFound"
            r4.d(r3, r5, r0)     // Catch:{ all -> 0x00e3 }
            goto L_0x0050
        L_0x00e3:
            r0 = move-exception
            com.applovin.impl.sdk.n r1 = r9.sdk
            com.applovin.impl.sdk.utils.u.a((java.io.Closeable) r2, (com.applovin.impl.sdk.n) r1)
            r9.d(r10)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.t.a(java.io.File):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:56:0x010e A[Catch:{ all -> 0x0173 }] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x012f A[SYNTHETIC, Splitter:B:61:0x012f] */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x018c A[Catch:{ all -> 0x019c }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(java.io.InputStream r11, java.io.File r12, boolean r13) {
        /*
            r10 = this;
            java.lang.String r0 = " from filesystem!"
            java.lang.String r1 = "Failed to remove file "
            java.lang.String r2 = "removeFileAfterCacheFail"
            java.lang.String r3 = "Overwrite not allowed for local resource: "
            boolean r4 = com.applovin.impl.sdk.x.Fn()
            java.lang.String r5 = "FileManager"
            if (r4 == 0) goto L_0x0027
            com.applovin.impl.sdk.x r4 = r10.logger
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r7 = "Writing resource to filesystem: "
            r6.<init>(r7)
            java.lang.String r7 = r12.getName()
            r6.append(r7)
            java.lang.String r6 = r6.toString()
            r4.f(r5, r6)
        L_0x0027:
            r4 = 1
            r6 = 0
            r7 = 0
            r10.c(r12)     // Catch:{ all -> 0x0106 }
            com.applovin.impl.sdk.c.b<java.lang.Boolean> r8 = com.applovin.impl.sdk.c.b.aMa     // Catch:{ all -> 0x0106 }
            com.applovin.impl.sdk.n r9 = r10.sdk     // Catch:{ all -> 0x0106 }
            boolean r8 = com.applovin.impl.sdk.utils.u.a((com.applovin.impl.sdk.c.b<java.lang.Boolean>) r8, (com.applovin.impl.sdk.n) r9)     // Catch:{ all -> 0x0106 }
            if (r8 == 0) goto L_0x0079
            if (r13 != 0) goto L_0x0079
            boolean r13 = r12.exists()     // Catch:{ all -> 0x0106 }
            if (r13 == 0) goto L_0x0079
            boolean r11 = com.applovin.impl.sdk.x.Fn()     // Catch:{ all -> 0x0106 }
            if (r11 == 0) goto L_0x005f
            com.applovin.impl.sdk.x r11 = r10.logger     // Catch:{ all -> 0x0106 }
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ all -> 0x0106 }
            r13.<init>(r3)     // Catch:{ all -> 0x0106 }
            java.lang.String r3 = r12.getName()     // Catch:{ all -> 0x0106 }
            r13.append(r3)     // Catch:{ all -> 0x0106 }
            java.lang.String r3 = " - aborting write."
            r13.append(r3)     // Catch:{ all -> 0x0106 }
            java.lang.String r13 = r13.toString()     // Catch:{ all -> 0x0106 }
            r11.f(r5, r13)     // Catch:{ all -> 0x0106 }
        L_0x005f:
            com.applovin.impl.sdk.n r11 = r10.sdk     // Catch:{ all -> 0x0106 }
            com.applovin.impl.sdk.r r11 = r11.Cs()     // Catch:{ all -> 0x0106 }
            com.applovin.impl.sdk.r$a r13 = com.applovin.impl.sdk.r.a.FILE_ERROR     // Catch:{ all -> 0x0106 }
            java.lang.String r3 = "cacheResourceOverwriteAttempted"
            java.lang.String r8 = r12.getAbsolutePath()     // Catch:{ all -> 0x0106 }
            r11.a((com.applovin.impl.sdk.r.a) r13, (java.lang.String) r3, (java.lang.String) r8)     // Catch:{ all -> 0x0106 }
            com.applovin.impl.sdk.n r11 = r10.sdk
            com.applovin.impl.sdk.utils.u.a((java.io.Closeable) r7, (com.applovin.impl.sdk.n) r11)
            r10.d(r12)
            return r4
        L_0x0079:
            java.io.FileOutputStream r13 = new java.io.FileOutputStream     // Catch:{ all -> 0x0106 }
            r13.<init>(r12)     // Catch:{ all -> 0x0106 }
            r3 = 8192(0x2000, float:1.14794E-41)
            byte[] r7 = new byte[r3]     // Catch:{ all -> 0x0103 }
        L_0x0082:
            int r8 = r11.read(r7, r6, r3)     // Catch:{ all -> 0x0103 }
            if (r8 < 0) goto L_0x00fa
            r13.write(r7, r6, r8)     // Catch:{ all -> 0x008c }
            goto L_0x0082
        L_0x008c:
            r11 = move-exception
            boolean r3 = com.applovin.impl.sdk.x.Fn()     // Catch:{ all -> 0x0103 }
            if (r3 == 0) goto L_0x009a
            com.applovin.impl.sdk.x r3 = r10.logger     // Catch:{ all -> 0x0103 }
            java.lang.String r7 = "Failed to write next buffer to file"
            r3.c(r5, r7, r11)     // Catch:{ all -> 0x0103 }
        L_0x009a:
            com.applovin.impl.sdk.n r3 = r10.sdk     // Catch:{ all -> 0x00f6 }
            com.applovin.impl.sdk.r r3 = r3.Cs()     // Catch:{ all -> 0x00f6 }
            java.lang.String r7 = "writeResourceStream"
            r3.d(r5, r7, r11)     // Catch:{ all -> 0x00f6 }
            com.applovin.impl.sdk.n r11 = r10.sdk
            com.applovin.impl.sdk.utils.u.a((java.io.Closeable) r13, (com.applovin.impl.sdk.n) r11)
            com.applovin.impl.sdk.c.b<java.lang.Boolean> r11 = com.applovin.impl.sdk.c.b.aLT
            com.applovin.impl.sdk.n r13 = r10.sdk
            boolean r11 = com.applovin.impl.sdk.utils.u.a((com.applovin.impl.sdk.c.b<java.lang.Boolean>) r11, (com.applovin.impl.sdk.n) r13)
            if (r11 == 0) goto L_0x00f2
            boolean r11 = r12.delete()     // Catch:{ all -> 0x00ca }
            if (r11 != 0) goto L_0x00f2
            com.applovin.impl.sdk.n r11 = r10.sdk     // Catch:{ all -> 0x00ca }
            com.applovin.impl.sdk.r r11 = r11.Cs()     // Catch:{ all -> 0x00ca }
            com.applovin.impl.sdk.r$a r13 = com.applovin.impl.sdk.r.a.FILE_ERROR     // Catch:{ all -> 0x00ca }
            java.lang.String r3 = r12.getAbsolutePath()     // Catch:{ all -> 0x00ca }
            r11.a((com.applovin.impl.sdk.r.a) r13, (java.lang.String) r2, (java.lang.String) r3)     // Catch:{ all -> 0x00ca }
            goto L_0x00f2
        L_0x00ca:
            r11 = move-exception
            boolean r13 = com.applovin.impl.sdk.x.Fn()
            if (r13 == 0) goto L_0x00e9
            com.applovin.impl.sdk.x r13 = r10.logger
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r1)
            java.lang.String r1 = r12.getName()
            r3.append(r1)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r13.c(r5, r0, r11)
        L_0x00e9:
            com.applovin.impl.sdk.n r13 = r10.sdk
            com.applovin.impl.sdk.r r13 = r13.Cs()
            r13.d(r5, r2, r11)
        L_0x00f2:
            r10.d(r12)
            return r6
        L_0x00f6:
            r11 = move-exception
            r7 = r13
            r13 = 1
            goto L_0x0108
        L_0x00fa:
            com.applovin.impl.sdk.n r11 = r10.sdk
            com.applovin.impl.sdk.utils.u.a((java.io.Closeable) r13, (com.applovin.impl.sdk.n) r11)
            r10.d(r12)
            return r4
        L_0x0103:
            r11 = move-exception
            r7 = r13
            goto L_0x0107
        L_0x0106:
            r11 = move-exception
        L_0x0107:
            r13 = 0
        L_0x0108:
            boolean r3 = com.applovin.impl.sdk.x.Fn()     // Catch:{ all -> 0x0173 }
            if (r3 == 0) goto L_0x0115
            com.applovin.impl.sdk.x r3 = r10.logger     // Catch:{ all -> 0x0173 }
            java.lang.String r8 = "Unknown failure to write file."
            r3.c(r5, r8, r11)     // Catch:{ all -> 0x0173 }
        L_0x0115:
            com.applovin.impl.sdk.n r13 = r10.sdk     // Catch:{ all -> 0x0171 }
            com.applovin.impl.sdk.r r13 = r13.Cs()     // Catch:{ all -> 0x0171 }
            java.lang.String r3 = "writeResource"
            r13.d(r5, r3, r11)     // Catch:{ all -> 0x0171 }
            com.applovin.impl.sdk.n r11 = r10.sdk
            com.applovin.impl.sdk.utils.u.a((java.io.Closeable) r7, (com.applovin.impl.sdk.n) r11)
            com.applovin.impl.sdk.c.b<java.lang.Boolean> r11 = com.applovin.impl.sdk.c.b.aLT
            com.applovin.impl.sdk.n r13 = r10.sdk
            boolean r11 = com.applovin.impl.sdk.utils.u.a((com.applovin.impl.sdk.c.b<java.lang.Boolean>) r11, (com.applovin.impl.sdk.n) r13)
            if (r11 == 0) goto L_0x016d
            boolean r11 = r12.delete()     // Catch:{ all -> 0x0145 }
            if (r11 != 0) goto L_0x016d
            com.applovin.impl.sdk.n r11 = r10.sdk     // Catch:{ all -> 0x0145 }
            com.applovin.impl.sdk.r r11 = r11.Cs()     // Catch:{ all -> 0x0145 }
            com.applovin.impl.sdk.r$a r13 = com.applovin.impl.sdk.r.a.FILE_ERROR     // Catch:{ all -> 0x0145 }
            java.lang.String r3 = r12.getAbsolutePath()     // Catch:{ all -> 0x0145 }
            r11.a((com.applovin.impl.sdk.r.a) r13, (java.lang.String) r2, (java.lang.String) r3)     // Catch:{ all -> 0x0145 }
            goto L_0x016d
        L_0x0145:
            r11 = move-exception
            boolean r13 = com.applovin.impl.sdk.x.Fn()
            if (r13 == 0) goto L_0x0164
            com.applovin.impl.sdk.x r13 = r10.logger
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r1)
            java.lang.String r1 = r12.getName()
            r3.append(r1)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r13.c(r5, r0, r11)
        L_0x0164:
            com.applovin.impl.sdk.n r13 = r10.sdk
            com.applovin.impl.sdk.r r13 = r13.Cs()
            r13.d(r5, r2, r11)
        L_0x016d:
            r10.d(r12)
            return r6
        L_0x0171:
            r11 = move-exception
            goto L_0x0175
        L_0x0173:
            r11 = move-exception
            r4 = r13
        L_0x0175:
            com.applovin.impl.sdk.n r13 = r10.sdk
            com.applovin.impl.sdk.utils.u.a((java.io.Closeable) r7, (com.applovin.impl.sdk.n) r13)
            if (r4 == 0) goto L_0x01c4
            com.applovin.impl.sdk.c.b<java.lang.Boolean> r13 = com.applovin.impl.sdk.c.b.aLT
            com.applovin.impl.sdk.n r3 = r10.sdk
            boolean r13 = com.applovin.impl.sdk.utils.u.a((com.applovin.impl.sdk.c.b<java.lang.Boolean>) r13, (com.applovin.impl.sdk.n) r3)
            if (r13 == 0) goto L_0x01c4
            boolean r13 = r12.delete()     // Catch:{ all -> 0x019c }
            if (r13 != 0) goto L_0x01c4
            com.applovin.impl.sdk.n r13 = r10.sdk     // Catch:{ all -> 0x019c }
            com.applovin.impl.sdk.r r13 = r13.Cs()     // Catch:{ all -> 0x019c }
            com.applovin.impl.sdk.r$a r3 = com.applovin.impl.sdk.r.a.FILE_ERROR     // Catch:{ all -> 0x019c }
            java.lang.String r4 = r12.getAbsolutePath()     // Catch:{ all -> 0x019c }
            r13.a((com.applovin.impl.sdk.r.a) r3, (java.lang.String) r2, (java.lang.String) r4)     // Catch:{ all -> 0x019c }
            goto L_0x01c4
        L_0x019c:
            r13 = move-exception
            boolean r3 = com.applovin.impl.sdk.x.Fn()
            if (r3 == 0) goto L_0x01bb
            com.applovin.impl.sdk.x r3 = r10.logger
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r1)
            java.lang.String r1 = r12.getName()
            r4.append(r1)
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            r3.c(r5, r0, r13)
        L_0x01bb:
            com.applovin.impl.sdk.n r0 = r10.sdk
            com.applovin.impl.sdk.r r0 = r0.Cs()
            r0.d(r5, r2, r13)
        L_0x01c4:
            r10.d(r12)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.t.a(java.io.InputStream, java.io.File, boolean):boolean");
    }

    public boolean a(File file, String str, List<String> list, e eVar) {
        return a(file, str, list, true, eVar);
    }

    private boolean a(File file, String str, List<String> list, boolean z, e eVar) {
        InputStream inputStream;
        if (g(file)) {
            if (x.Fn()) {
                x xVar = this.logger;
                xVar.f("FileManager", "File exists for " + str);
            }
            if (eVar == null) {
                return true;
            }
            eVar.bX(file.length());
            return true;
        }
        try {
            inputStream = a(str, list, z, eVar);
            try {
                boolean a = a(inputStream, file);
                u.a((Closeable) inputStream, this.sdk);
                return a;
            } catch (Throwable th) {
                th = th;
                u.a((Closeable) inputStream, this.sdk);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            inputStream = null;
            u.a((Closeable) inputStream, this.sdk);
            throw th;
        }
    }

    public InputStream a(String str, List<String> list, boolean z, e eVar) {
        if (!z || u.d(str, list)) {
            if (((Boolean) this.sdk.a(b.aNN)).booleanValue() && !str.contains("https://")) {
                if (x.Fn()) {
                    this.logger.h("FileManager", "Plaintext HTTP operation requested; upgrading to HTTPS due to universal SSL setting...");
                }
                str = str.replace("http://", "https://");
            }
            if (x.Fn()) {
                x xVar = this.logger;
                xVar.f("FileManager", "Loading " + str + "...");
            }
            try {
                HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                httpURLConnection.setConnectTimeout(((Integer) this.sdk.a(b.aNL)).intValue());
                httpURLConnection.setReadTimeout(((Integer) this.sdk.a(b.aNM)).intValue());
                httpURLConnection.setDefaultUseCaches(true);
                httpURLConnection.setUseCaches(true);
                httpURLConnection.setAllowUserInteraction(false);
                httpURLConnection.setInstanceFollowRedirects(true);
                int responseCode = httpURLConnection.getResponseCode();
                eVar.gO(responseCode);
                this.sdk.Cs().b(str, "loadResource", responseCode);
                if (responseCode >= 200) {
                    if (responseCode < 300) {
                        if (x.Fn()) {
                            x xVar2 = this.logger;
                            xVar2.f("FileManager", "Opened stream to resource " + str);
                        }
                        return httpURLConnection.getInputStream();
                    }
                }
                return null;
            } catch (Throwable th) {
                if (x.Fn()) {
                    x xVar3 = this.logger;
                    xVar3.c("FileManager", "Error loading " + str, th);
                }
                r Cs = this.sdk.Cs();
                Cs.d("FileManager", "loadResource-" + str, th);
                eVar.p(th);
                return null;
            }
        } else {
            if (x.Fn()) {
                x xVar4 = this.logger;
                xVar4.f("FileManager", "Domain is not whitelisted, skipping precache for url: " + str);
            }
            return null;
        }
    }

    public boolean a(InputStream inputStream, File file) {
        if (file == null) {
            return false;
        }
        if (x.Fn()) {
            x xVar = this.logger;
            xVar.f("FileManager", "Caching " + file.getAbsolutePath() + "...");
        }
        if (!a(inputStream, file, false)) {
            if (x.Fn()) {
                x xVar2 = this.logger;
                xVar2.i("FileManager", "Unable to cache " + file.getAbsolutePath());
            }
            return false;
        } else if (!x.Fn()) {
            return true;
        } else {
            x xVar3 = this.logger;
            xVar3.f("FileManager", "Caching completed for " + file);
            return true;
        }
    }

    public String a(Context context, String str, String str2, List<String> list, boolean z, e eVar) {
        return a(context, str, str2, list, z, false, eVar);
    }

    public String a(Context context, String str, String str2, List<String> list, boolean z, boolean z2, e eVar) {
        if (!StringUtils.isValidString(str)) {
            if (x.Fn()) {
                this.logger.f("FileManager", "Nothing to cache, skipping...");
            }
            this.sdk.Cs().a(r.a.FILE_ERROR, "cacheResource", (String) null);
            return null;
        }
        String str3 = str2;
        String a = u.a(Uri.parse(str), str2, this.sdk);
        Context context2 = context;
        File a2 = a(a, context);
        if (!a(a2, str, list, z, eVar)) {
            return null;
        }
        if (x.Fn()) {
            x xVar = this.logger;
            xVar.f("FileManager", "Caching succeeded for file " + a);
        }
        return z2 ? Uri.fromFile(a2).toString() : a;
    }

    public void H(Context context) {
        if (Fa() && this.sdk.Bp()) {
            if (x.Fn()) {
                this.logger.f("FileManager", "Compacting cache...");
            }
            a(I(context), context);
        }
    }

    private long I(Context context) {
        long EZ = EZ();
        boolean z = EZ != -1;
        long seconds = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
        List<String> b = this.sdk.b(b.aLO);
        long j = 0;
        for (File next : J(context)) {
            if (z && !b.contains(next.getName()) && !e(next) && seconds - TimeUnit.MILLISECONDS.toSeconds(next.lastModified()) > EZ) {
                if (x.Fn()) {
                    x xVar = this.logger;
                    xVar.f("FileManager", "File " + next.getName() + " has expired, removing...");
                }
                if (b(next)) {
                    this.sdk.BR().a(f.aSY);
                }
            }
            j += next.length();
        }
        return j;
    }

    private void a(long j, Context context) {
        if (Fa()) {
            long intValue = (long) ((Integer) this.sdk.a(b.aLK)).intValue();
            if (intValue == -1) {
                if (x.Fn()) {
                    this.logger.f("FileManager", "Cache has no maximum size set; skipping drop...");
                }
            } else if (bO(j) > intValue) {
                if (x.Fn()) {
                    this.logger.f("FileManager", "Cache has exceeded maximum size; dropping...");
                }
                for (File b : J(context)) {
                    b(b);
                }
                this.sdk.BR().a(f.aSZ);
            } else if (x.Fn()) {
                this.logger.f("FileManager", "Cache is present but under size limit; not dropping...");
            }
        }
    }

    public void b(com.applovin.impl.sdk.ad.e eVar, Context context) {
        this.sdk.BO().a((d) new ab(this.sdk, false, "removeCachedResourcesForAd", new t$$ExternalSyntheticLambda0(this, eVar, context)), q.b.BACKGROUND);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void e(com.applovin.impl.sdk.ad.e eVar, Context context) {
        ArrayList<Uri> arrayList = new ArrayList<>(eVar.Gn());
        arrayList.add(eVar.FI());
        for (Uri lastPathSegment : arrayList) {
            b(a(lastPathSegment.getLastPathSegment(), context));
        }
    }

    public void c(com.applovin.impl.sdk.ad.e eVar, Context context) {
        this.sdk.BO().a((d) new ab(this.sdk, false, "removeCachedVideoResourceForAd", new t$$ExternalSyntheticLambda1(this, eVar, context)), q.b.BACKGROUND);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d(com.applovin.impl.sdk.ad.e eVar, Context context) {
        b(a(eVar.FI().getLastPathSegment(), context));
    }

    /* JADX INFO: finally extract failed */
    private boolean b(File file) {
        if (x.Fn()) {
            x xVar = this.logger;
            xVar.f("FileManager", "Removing file " + file.getName() + " from filesystem...");
        }
        try {
            c(file);
            boolean delete = file.delete();
            if (!delete) {
                this.sdk.Cs().a(r.a.FILE_ERROR, "removeFile", file.getAbsolutePath());
            }
            d(file);
            return delete;
        } catch (Throwable th) {
            d(file);
            throw th;
        }
    }

    private long EZ() {
        long longValue = ((Long) this.sdk.a(b.aLJ)).longValue();
        if (longValue < 0 || !Fa()) {
            return -1;
        }
        return longValue;
    }

    private boolean Fa() {
        return ((Boolean) this.sdk.a(b.aLI)).booleanValue();
    }

    private long bO(long j) {
        return j / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
    }

    private void c(File file) {
        String absolutePath = file.getAbsolutePath();
        synchronized (this.aEU) {
            boolean add = this.aEV.add(absolutePath);
            while (!add) {
                try {
                    this.aEU.wait();
                    add = this.aEV.add(absolutePath);
                } catch (InterruptedException e) {
                    if (x.Fn()) {
                        x xVar = this.logger;
                        xVar.c("FileManager", "Lock '" + absolutePath + "' interrupted", e);
                    }
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private void d(File file) {
        String absolutePath = file.getAbsolutePath();
        synchronized (this.aEU) {
            if (!this.aEV.remove(absolutePath)) {
                this.sdk.Cs().a(r.a.FILE_ERROR, "unlockFile", absolutePath);
            }
            this.aEU.notifyAll();
        }
    }

    private boolean e(File file) {
        boolean contains;
        String absolutePath = file.getAbsolutePath();
        synchronized (this.aEU) {
            contains = this.aEV.contains(absolutePath);
        }
        return contains;
    }

    private boolean f(File file) {
        if (file == null) {
            return false;
        }
        String absolutePath = file.getAbsolutePath();
        synchronized (this.aEU) {
            if (this.aEV.contains(absolutePath)) {
                return false;
            }
            c(file);
            return true;
        }
    }

    private List<File> J(Context context) {
        File[] listFiles;
        File K = K(context);
        if (!K.isDirectory() || (listFiles = K.listFiles()) == null) {
            return Collections.emptyList();
        }
        return Arrays.asList(listFiles);
    }

    private File K(Context context) {
        return new File(context.getFilesDir(), "al");
    }

    public boolean b(String str, Context context) {
        boolean z = false;
        File a = a(str, false, context);
        if (!f(a)) {
            return false;
        }
        if (a.exists() && !a.isDirectory()) {
            z = true;
        }
        d(a);
        return z;
    }

    public boolean c(String str, Context context) {
        return g(a(str, false, context));
    }

    public boolean g(File file) {
        boolean z = true;
        if (u.a(b.aLZ, this.sdk)) {
            if (file == null) {
                return false;
            }
            u.LE();
            c(file);
            if (!file.exists() || file.isDirectory()) {
                z = false;
            }
            d(file);
            return z;
        } else if (file == null || !file.exists() || file.isDirectory()) {
            return false;
        } else {
            return true;
        }
    }

    public void L(Context context) {
        try {
            a(".nomedia", context);
            File file = new File(K(context), ".nomedia");
            if (!g(file)) {
                if (x.Fn()) {
                    x xVar = this.logger;
                    xVar.f("FileManager", "Creating .nomedia file at " + file.getAbsolutePath());
                }
                if (!file.createNewFile()) {
                    if (x.Fn()) {
                        this.logger.i("FileManager", "Failed to create .nomedia file");
                    }
                    this.sdk.Cs().a(r.a.FILE_ERROR, "createNoMediaFile", (String) null);
                }
            }
        } catch (IOException e) {
            if (x.Fn()) {
                this.logger.c("FileManager", "Failed to create .nomedia file", e);
            }
        }
    }
}
