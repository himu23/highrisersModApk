package com.fyber.inneractive.sdk.network;

import android.os.Environment;
import android.text.TextUtils;
import com.fyber.inneractive.sdk.config.global.s;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.u;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.util.List;
import java.util.Map;

public class l0 extends f0<String> {
    public final String r;

    public l0(w<String> wVar, String str, s sVar) {
        super(wVar, x.a().b(), sVar);
        this.r = str;
    }

    public String a() {
        return this.r;
    }

    public p0 i() {
        return p0.LOW;
    }

    public boolean o() {
        return false;
    }

    public z r() {
        return z.GET;
    }

    public int v() {
        return 0;
    }

    public b0 a(j jVar, Map<String, List<String>> map, int i) throws Exception {
        T t;
        b0 b0Var = new b0();
        FileOutputStream fileOutputStream = null;
        try {
            InputStream inputStream = jVar.c;
            File file = new File(Environment.getExternalStorageDirectory(), "Pictures");
            file.mkdirs();
            String a = a(URI.create(this.r), map);
            if (!TextUtils.isEmpty(a)) {
                File file2 = new File(file, a);
                t = file2.toString();
                FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
                try {
                    u.a(inputStream, (OutputStream) fileOutputStream2);
                    fileOutputStream = fileOutputStream2;
                } catch (Exception unused) {
                    fileOutputStream = fileOutputStream2;
                    try {
                        IAlog.a("failed to download and save the image file.", new Object[0]);
                        u.b((Closeable) fileOutputStream);
                        return b0Var;
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream2 = fileOutputStream;
                        u.b((Closeable) fileOutputStream2);
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    u.b((Closeable) fileOutputStream2);
                    throw th;
                }
            } else {
                t = null;
            }
            b0Var.a = t;
        } catch (Exception unused2) {
        }
        u.b((Closeable) fileOutputStream);
        return b0Var;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v6, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v9, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String a(java.net.URI r5, java.util.Map<java.lang.String, java.util.List<java.lang.String>> r6) {
        /*
            r4 = this;
            java.lang.String r5 = r5.getPath()
            r0 = 0
            if (r5 != 0) goto L_0x0008
            return r0
        L_0x0008:
            java.io.File r1 = new java.io.File
            r1.<init>(r5)
            java.lang.String r5 = r1.getName()
            if (r6 == 0) goto L_0x001c
            java.lang.String r1 = "Content-Type"
            java.lang.Object r6 = r6.get(r1)
            java.util.List r6 = (java.util.List) r6
            goto L_0x001d
        L_0x001c:
            r6 = r0
        L_0x001d:
            r1 = 0
            if (r6 == 0) goto L_0x0027
            java.lang.Object r6 = r6.get(r1)
            r0 = r6
            java.lang.String r0 = (java.lang.String) r0
        L_0x0027:
            if (r0 == 0) goto L_0x006c
            java.lang.String r6 = ";"
            java.lang.String[] r6 = r0.split(r6)
            int r0 = r6.length
        L_0x0030:
            if (r1 >= r0) goto L_0x006c
            r2 = r6[r1]
            java.lang.String r3 = "image/"
            boolean r3 = r2.contains(r3)
            if (r3 == 0) goto L_0x0069
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r0 = "."
            r6.<init>(r0)
            java.lang.String r0 = "/"
            java.lang.String[] r0 = r2.split(r0)
            r1 = 1
            r0 = r0[r1]
            r6.append(r0)
            java.lang.String r6 = r6.toString()
            boolean r0 = r5.endsWith(r6)
            if (r0 != 0) goto L_0x006c
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r5)
            r0.append(r6)
            java.lang.String r5 = r0.toString()
            goto L_0x006c
        L_0x0069:
            int r1 = r1 + 1
            goto L_0x0030
        L_0x006c:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.network.l0.a(java.net.URI, java.util.Map):java.lang.String");
    }
}
