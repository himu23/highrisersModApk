package com.fyber.inneractive.sdk.util;

import android.graphics.Bitmap;
import com.fyber.inneractive.sdk.player.b;
import com.fyber.inneractive.sdk.player.c;
import java.io.File;

public class s extends b<Void, Void, Bitmap> {
    public final File g;
    public a h;
    public String i;
    public String j = null;
    public int k;

    public interface a {
    }

    public s(File file, a aVar, String str, String str2, int i2) {
        this.g = file;
        this.h = aVar;
        this.i = str;
        this.k = i2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v0, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v1, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v2, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: java.net.HttpURLConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v6, resolved type: java.io.FileOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v6, resolved type: java.io.InputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v16, resolved type: java.net.HttpURLConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v17, resolved type: java.net.HttpURLConnection} */
    /* JADX WARNING: type inference failed for: r6v0, types: [java.net.HttpURLConnection] */
    /* JADX WARNING: type inference failed for: r6v15 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00cd A[Catch:{ all -> 0x00e4, all -> 0x00f5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00d2 A[SYNTHETIC, Splitter:B:69:0x00d2] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x00d7 A[Catch:{ all -> 0x00e0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00dc A[Catch:{ all -> 0x00e0 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object a(java.lang.Object[] r12) {
        /*
            r11 = this;
            java.lang.Void[] r12 = (java.lang.Void[]) r12
            r12 = 8192(0x2000, float:1.14794E-41)
            byte[] r0 = new byte[r12]
            r1 = 1
            r2 = 0
            r3 = 0
            java.io.File r4 = new java.io.File     // Catch:{ all -> 0x00b9 }
            java.io.File r5 = r11.g     // Catch:{ all -> 0x00b9 }
            java.lang.String r6 = r11.j     // Catch:{ all -> 0x00b9 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x00b9 }
            if (r6 == 0) goto L_0x002f
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b9 }
            r6.<init>()     // Catch:{ all -> 0x00b9 }
            java.util.UUID r7 = java.util.UUID.randomUUID()     // Catch:{ all -> 0x00b9 }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x00b9 }
            r6.append(r7)     // Catch:{ all -> 0x00b9 }
            java.lang.String r7 = ".mp4"
            r6.append(r7)     // Catch:{ all -> 0x00b9 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x00b9 }
            goto L_0x0031
        L_0x002f:
            java.lang.String r6 = r11.j     // Catch:{ all -> 0x00b9 }
        L_0x0031:
            r4.<init>(r5, r6)     // Catch:{ all -> 0x00b9 }
            java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch:{ all -> 0x00b6 }
            r5.<init>(r4)     // Catch:{ all -> 0x00b6 }
            java.net.URL r6 = new java.net.URL     // Catch:{ all -> 0x00b3 }
            java.lang.String r7 = r11.i     // Catch:{ all -> 0x00b3 }
            r6.<init>(r7)     // Catch:{ all -> 0x00b3 }
            java.net.URLConnection r6 = r6.openConnection()     // Catch:{ all -> 0x00b3 }
            java.net.HttpURLConnection r6 = (java.net.HttpURLConnection) r6     // Catch:{ all -> 0x00b3 }
            r7 = 5000(0x1388, float:7.006E-42)
            r6.setConnectTimeout(r7)     // Catch:{ all -> 0x00b0 }
            r6.setReadTimeout(r7)     // Catch:{ all -> 0x00b0 }
            java.io.InputStream r7 = r6.getInputStream()     // Catch:{ all -> 0x00b0 }
            r8 = 0
        L_0x0053:
            int r9 = r11.k     // Catch:{ all -> 0x00ae }
            int r9 = r9 - r12
            if (r8 >= r9) goto L_0x0064
            int r9 = r7.read(r0, r2, r12)     // Catch:{ all -> 0x00ae }
            r10 = -1
            if (r9 <= r10) goto L_0x0053
            r5.write(r0, r2, r9)     // Catch:{ all -> 0x00ae }
            int r8 = r8 + r9
            goto L_0x0053
        L_0x0064:
            r6.disconnect()     // Catch:{ all -> 0x0070 }
            r5.close()     // Catch:{ all -> 0x0070 }
            if (r7 == 0) goto L_0x0073
            r7.close()     // Catch:{ all -> 0x0070 }
            goto L_0x0073
        L_0x0070:
            r4.delete()
        L_0x0073:
            java.lang.Object r0 = new java.lang.Object
            r0.<init>()
            android.media.MediaMetadataRetriever r5 = new android.media.MediaMetadataRetriever
            r5.<init>()
            monitor-enter(r0)     // Catch:{ Exception -> 0x0095 }
            java.lang.String r6 = r4.getPath()     // Catch:{ all -> 0x0090 }
            r5.setDataSource(r6)     // Catch:{ all -> 0x0090 }
            r5.extractMetadata(r12)     // Catch:{ all -> 0x0090 }
            r6 = 1
            android.graphics.Bitmap r3 = r5.getFrameAtTime(r6)     // Catch:{ all -> 0x0090 }
            monitor-exit(r0)     // Catch:{ all -> 0x0090 }
            goto L_0x00a3
        L_0x0090:
            r12 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0090 }
            throw r12     // Catch:{ Exception -> 0x0095 }
        L_0x0093:
            r12 = move-exception
            goto L_0x00aa
        L_0x0095:
            r12 = move-exception
            java.lang.String r0 = "Failed getting frame from video file%s"
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x0093 }
            java.lang.String r12 = com.fyber.inneractive.sdk.util.u.b((java.lang.Throwable) r12)     // Catch:{ all -> 0x0093 }
            r1[r2] = r12     // Catch:{ all -> 0x0093 }
            com.fyber.inneractive.sdk.util.IAlog.a(r0, r1)     // Catch:{ all -> 0x0093 }
        L_0x00a3:
            r5.release()     // Catch:{ all -> 0x00a6 }
        L_0x00a6:
            r4.delete()
            goto L_0x00e3
        L_0x00aa:
            r5.release()     // Catch:{ all -> 0x00ad }
        L_0x00ad:
            throw r12
        L_0x00ae:
            r12 = move-exception
            goto L_0x00be
        L_0x00b0:
            r12 = move-exception
            r7 = r3
            goto L_0x00be
        L_0x00b3:
            r12 = move-exception
            r6 = r3
            goto L_0x00bd
        L_0x00b6:
            r12 = move-exception
            r5 = r3
            goto L_0x00bc
        L_0x00b9:
            r12 = move-exception
            r4 = r3
            r5 = r4
        L_0x00bc:
            r6 = r5
        L_0x00bd:
            r7 = r6
        L_0x00be:
            java.lang.String r0 = "Failed getting frame from video file%s"
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x00e4 }
            java.lang.String r12 = com.fyber.inneractive.sdk.util.u.b((java.lang.Throwable) r12)     // Catch:{ all -> 0x00e4 }
            r1[r2] = r12     // Catch:{ all -> 0x00e4 }
            com.fyber.inneractive.sdk.util.IAlog.a(r0, r1)     // Catch:{ all -> 0x00e4 }
            if (r4 == 0) goto L_0x00d0
            r4.delete()     // Catch:{ all -> 0x00e4 }
        L_0x00d0:
            if (r6 == 0) goto L_0x00d5
            r6.disconnect()     // Catch:{ all -> 0x00e0 }
        L_0x00d5:
            if (r5 == 0) goto L_0x00da
            r5.close()     // Catch:{ all -> 0x00e0 }
        L_0x00da:
            if (r7 == 0) goto L_0x00e3
            r7.close()     // Catch:{ all -> 0x00e0 }
            goto L_0x00e3
        L_0x00e0:
            r4.delete()
        L_0x00e3:
            return r3
        L_0x00e4:
            r12 = move-exception
            if (r6 == 0) goto L_0x00ea
            r6.disconnect()     // Catch:{ all -> 0x00f5 }
        L_0x00ea:
            if (r5 == 0) goto L_0x00ef
            r5.close()     // Catch:{ all -> 0x00f5 }
        L_0x00ef:
            if (r7 == 0) goto L_0x00f8
            r7.close()     // Catch:{ all -> 0x00f5 }
            goto L_0x00f8
        L_0x00f5:
            r4.delete()
        L_0x00f8:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.util.s.a(java.lang.Object[]):java.lang.Object");
    }

    public void d() {
        c();
        this.h = null;
    }

    public void a(Object obj) {
        Bitmap bitmap = (Bitmap) obj;
        a aVar = this.h;
        if (aVar != null) {
            if (bitmap != null) {
                b bVar = (b) aVar;
                c cVar = bVar.a;
                if (cVar.m != null) {
                    cVar.a(bitmap);
                    bVar.a.l.d();
                    c cVar2 = bVar.a;
                    cVar2.l = null;
                    cVar2.m = null;
                }
                IAlog.a("MediaPlayerController: fetching video frame success!", new Object[0]);
            } else {
                b bVar2 = (b) aVar;
                c cVar3 = bVar2.a;
                if (cVar3.m != null) {
                    cVar3.a((Bitmap) null);
                    bVar2.a.l.d();
                    c cVar4 = bVar2.a;
                    cVar4.l = null;
                    cVar4.m = null;
                }
                IAlog.a("MediaPlayerController: fetching video frame failed!", new Object[0]);
            }
            this.h = null;
        }
    }
}
