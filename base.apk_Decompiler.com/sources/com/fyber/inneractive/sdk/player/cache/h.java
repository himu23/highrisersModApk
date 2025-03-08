package com.fyber.inneractive.sdk.player.cache;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.webkit.MimeTypeMap;
import com.fyber.inneractive.sdk.config.global.features.r;
import com.fyber.inneractive.sdk.config.global.s;
import com.fyber.inneractive.sdk.player.cache.b;
import com.fyber.inneractive.sdk.player.cache.c;
import com.fyber.inneractive.sdk.player.cache.d;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.j;
import com.fyber.inneractive.sdk.util.o0;
import com.fyber.inneractive.sdk.util.q;
import com.fyber.inneractive.sdk.util.u;
import com.unity3d.ads.core.data.datasource.AndroidStaticDeviceInfoDataSource;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.UByte;

public class h implements o0 {
    public String a = ("MediaDownloader-" + hashCode());
    public c b;
    public c.f c;
    public b d;
    public final String e;
    public a f;
    public i g;
    public f h;
    public HandlerThread i;
    public Handler j;
    public final Object k = new Object();
    public String l;
    public volatile boolean m = false;
    public boolean n = false;
    public boolean o = false;
    public String p = null;
    public C0108h q;
    public final s r;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            h hVar = h.this;
            i iVar = hVar.g;
            if (iVar != null) {
                ((d.a) iVar).a(hVar, hVar.f, (Exception) null);
            }
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ Exception a;

        public b(Exception exc) {
            this.a = exc;
        }

        public void run() {
            h hVar = h.this;
            i iVar = hVar.g;
            if (iVar != null) {
                ((d.a) iVar).a(hVar, hVar.f, this.a);
            }
        }
    }

    public class c implements Runnable {
        public c() {
        }

        public void run() {
            h.this.a(false);
        }
    }

    public static /* synthetic */ class d {
        public static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.fyber.inneractive.sdk.config.global.features.r$d[] r0 = com.fyber.inneractive.sdk.config.global.features.r.d.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                a = r0
                com.fyber.inneractive.sdk.config.global.features.r$d r1 = com.fyber.inneractive.sdk.config.global.features.r.d.NONE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.fyber.inneractive.sdk.config.global.features.r$d r1 = com.fyber.inneractive.sdk.config.global.features.r.d.EXTRACTOR     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.fyber.inneractive.sdk.config.global.features.r$d r1 = com.fyber.inneractive.sdk.config.global.features.r.d.LEGACY     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.cache.h.d.<clinit>():void");
        }
    }

    public static class e extends Exception {
        public e(String str) {
            super(str);
        }
    }

    public class f extends Thread {
        public AtomicBoolean a = new AtomicBoolean(false);
        public InputStream b;
        public boolean c = false;
        public boolean d = false;
        public long e = -1;
        public long f = 0;
        public c.C0107c g;
        public int h;
        public int i;
        public int j;
        public int k;

        /* JADX WARNING: Removed duplicated region for block: B:42:0x0130  */
        /* JADX WARNING: Removed duplicated region for block: B:73:0x01dd A[EDGE_INSN: B:73:0x01dd->B:69:0x01dd ?: BREAK  , SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.net.HttpURLConnection a(java.io.OutputStream r23, java.net.URL r24, java.nio.ByteBuffer r25, long r26, int r28) throws java.io.IOException, com.fyber.inneractive.sdk.player.cache.h.e {
            /*
                r22 = this;
                r0 = r22
                java.net.URLConnection r1 = r24.openConnection()
                java.net.HttpURLConnection r1 = (java.net.HttpURLConnection) r1
                r2 = 0
                r3 = 1
                r4 = 0
                int r6 = (r26 > r4 ? 1 : (r26 == r4 ? 0 : -1))
                if (r6 <= 0) goto L_0x0023
                java.lang.Object[] r7 = new java.lang.Object[r3]
                java.lang.Long r8 = java.lang.Long.valueOf(r26)
                r7[r2] = r8
                java.lang.String r8 = "bytes=%d-"
                java.lang.String r7 = java.lang.String.format(r8, r7)
                java.lang.String r8 = "Range"
                r1.addRequestProperty(r8, r7)
            L_0x0023:
                com.fyber.inneractive.sdk.player.cache.h r7 = com.fyber.inneractive.sdk.player.cache.h.this
                com.fyber.inneractive.sdk.config.global.s r7 = r7.r
                if (r7 == 0) goto L_0x005b
                java.lang.Class<com.fyber.inneractive.sdk.config.global.features.r> r8 = com.fyber.inneractive.sdk.config.global.features.r.class
                com.fyber.inneractive.sdk.config.global.features.g r7 = r7.a(r8)
                com.fyber.inneractive.sdk.config.global.features.r r7 = (com.fyber.inneractive.sdk.config.global.features.r) r7
                java.lang.String r8 = "url_conn_connection_timeout"
                java.lang.Integer r7 = r7.b(r8)
                com.fyber.inneractive.sdk.player.cache.h r8 = com.fyber.inneractive.sdk.player.cache.h.this
                com.fyber.inneractive.sdk.config.global.s r8 = r8.r
                java.lang.Class<com.fyber.inneractive.sdk.config.global.features.r> r9 = com.fyber.inneractive.sdk.config.global.features.r.class
                com.fyber.inneractive.sdk.config.global.features.g r8 = r8.a(r9)
                com.fyber.inneractive.sdk.config.global.features.r r8 = (com.fyber.inneractive.sdk.config.global.features.r) r8
                java.lang.String r9 = "url_conn_read_timeout"
                java.lang.Integer r8 = r8.b(r9)
                if (r7 == 0) goto L_0x0052
                int r7 = r7.intValue()
                r1.setConnectTimeout(r7)
            L_0x0052:
                if (r8 == 0) goto L_0x005b
                int r7 = r8.intValue()
                r1.setReadTimeout(r7)
            L_0x005b:
                r1.connect()
                int r7 = r1.getResponseCode()
                r8 = 3
                java.lang.Object[] r8 = new java.lang.Object[r8]
                com.fyber.inneractive.sdk.player.cache.h r9 = com.fyber.inneractive.sdk.player.cache.h.this
                java.lang.String r10 = r9.a
                r8[r2] = r10
                java.lang.String r9 = r9.a()
                r8[r3] = r9
                java.lang.Integer r9 = java.lang.Integer.valueOf(r7)
                r10 = 2
                r8[r10] = r9
                java.lang.String r9 = "%s http response code for %s is %d"
                com.fyber.inneractive.sdk.util.IAlog.d(r9, r8)
                r8 = 200(0xc8, float:2.8E-43)
                if (r7 == r8) goto L_0x0093
                r9 = 206(0xce, float:2.89E-43)
                if (r7 == r9) goto L_0x0093
                if (r6 > 0) goto L_0x0088
                goto L_0x0093
            L_0x0088:
                r1.disconnect()
                com.fyber.inneractive.sdk.player.cache.h$e r1 = new com.fyber.inneractive.sdk.player.cache.h$e
                java.lang.String r2 = "HTTP status code != 200"
                r1.<init>(r2)
                throw r1
            L_0x0093:
                int r9 = r1.getContentLength()
                long r11 = (long) r9
                r13 = 36700160(0x2300000, double:1.81322883E-316)
                int r9 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
                if (r9 > 0) goto L_0x01de
                if (r6 > 0) goto L_0x00a3
                r0.f = r11
            L_0x00a3:
                java.io.InputStream r9 = r1.getInputStream()
                r0.b = r9
                r9 = 100
                int r15 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
                if (r15 > 0) goto L_0x00b3
                r13 = 716800(0xaf000, double:3.541463E-318)
                goto L_0x00b8
            L_0x00b3:
                int r13 = r9 / r28
                long r13 = (long) r13
                long r13 = r11 / r13
            L_0x00b8:
                if (r15 > 0) goto L_0x00be
                r2 = 716800(0xaf000, double:3.541463E-318)
                goto L_0x00ca
            L_0x00be:
                int r15 = r0.k
                int r15 = r28 + r15
                if (r15 <= r9) goto L_0x00c6
                r15 = r28
            L_0x00c6:
                int r9 = r9 / r15
                long r2 = (long) r9
                long r2 = r11 / r2
            L_0x00ca:
                com.fyber.inneractive.sdk.util.h r9 = com.fyber.inneractive.sdk.util.h.b
                r11 = r25
                byte[] r9 = r9.a(r11)
                long r11 = r0.f
                int r16 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
                if (r16 <= 0) goto L_0x00e3
                long r11 = r0.e
                r16 = -1
                int r18 = (r11 > r16 ? 1 : (r11 == r16 ? 0 : -1))
                if (r18 != 0) goto L_0x00e3
                r0.e = r4
                goto L_0x0125
            L_0x00e3:
                if (r6 <= 0) goto L_0x0125
                if (r7 != r8) goto L_0x0125
                r0.e = r4
                java.lang.Object[] r6 = new java.lang.Object[r10]
                com.fyber.inneractive.sdk.player.cache.h r7 = com.fyber.inneractive.sdk.player.cache.h.this
                java.lang.String r8 = r7.a
                r11 = 0
                r6[r11] = r8
                java.lang.String r7 = r7.a()
                r8 = 1
                r6[r8] = r7
                java.lang.String r7 = "%s | Server rejected Range header for %s | restarting"
                com.fyber.inneractive.sdk.util.IAlog.d(r7, r6)
                com.fyber.inneractive.sdk.player.cache.m.a((java.io.Closeable) r23)
                com.fyber.inneractive.sdk.player.cache.c$c r6 = r0.g
                r6.a()
                com.fyber.inneractive.sdk.player.cache.h r6 = com.fyber.inneractive.sdk.player.cache.h.this
                com.fyber.inneractive.sdk.player.cache.c r7 = r6.b
                java.lang.String r6 = r6.a()
                r7.d(r6)
                com.fyber.inneractive.sdk.player.cache.h r6 = com.fyber.inneractive.sdk.player.cache.h.this
                com.fyber.inneractive.sdk.player.cache.c r7 = r6.b
                java.lang.String r6 = r6.a()
                com.fyber.inneractive.sdk.player.cache.c$c r6 = r7.a((java.lang.String) r6)
                r7 = 0
                java.io.OutputStream r8 = r6.a(r7)
                r0.g = r6
                goto L_0x0127
            L_0x0125:
                r8 = r23
            L_0x0127:
                java.io.InputStream r6 = r0.b
                int r6 = r6.read(r9)
                r7 = -1
                if (r6 == r7) goto L_0x01dd
                java.util.concurrent.atomic.AtomicBoolean r7 = r0.a
                r11 = 1
                boolean r7 = r7.compareAndSet(r11, r11)
                if (r7 == 0) goto L_0x014f
                java.lang.Object[] r2 = new java.lang.Object[r10]
                com.fyber.inneractive.sdk.player.cache.h r3 = com.fyber.inneractive.sdk.player.cache.h.this
                java.lang.String r4 = r3.a
                r7 = 0
                r2[r7] = r4
                java.lang.String r3 = r3.a()
                r2[r11] = r3
                java.lang.String r3 = "%s | aborting download for cache %s"
                com.fyber.inneractive.sdk.util.IAlog.d(r3, r2)
                goto L_0x01dd
            L_0x014f:
                r7 = 0
                r8.write(r9, r7, r6)
                long r11 = r0.e
                long r6 = (long) r6
                long r11 = r11 + r6
                r0.e = r11
                boolean r6 = r0.c
                if (r6 != 0) goto L_0x0164
                int r6 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
                if (r6 >= 0) goto L_0x0162
                goto L_0x0164
            L_0x0162:
                r6 = 1
                goto L_0x016d
            L_0x0164:
                boolean r6 = r0.d
                if (r6 != 0) goto L_0x0127
                int r6 = (r11 > r2 ? 1 : (r11 == r2 ? 0 : -1))
                if (r6 < 0) goto L_0x0127
                goto L_0x0162
            L_0x016d:
                r0.c = r6
                int r7 = (r11 > r2 ? 1 : (r11 == r2 ? 0 : -1))
                if (r7 < 0) goto L_0x0175
                r0.d = r6
            L_0x0175:
                com.fyber.inneractive.sdk.player.cache.h r6 = com.fyber.inneractive.sdk.player.cache.h.this
                com.fyber.inneractive.sdk.player.cache.a r7 = r6.f
                if (r7 != 0) goto L_0x01ca
                java.lang.String r17 = r6.a()
                com.fyber.inneractive.sdk.player.cache.h r7 = com.fyber.inneractive.sdk.player.cache.h.this
                java.lang.String r11 = r7.e
                com.fyber.inneractive.sdk.player.cache.c r12 = r7.b
                java.lang.String r7 = r7.a()
                r12.a()
                r12.e(r7)
                java.util.LinkedHashMap<java.lang.String, com.fyber.inneractive.sdk.player.cache.c$d> r12 = r12.j
                java.lang.Object r7 = r12.get(r7)
                com.fyber.inneractive.sdk.player.cache.c$d r7 = (com.fyber.inneractive.sdk.player.cache.c.d) r7
                if (r7 != 0) goto L_0x019b
                r7 = 0
                goto L_0x01a0
            L_0x019b:
                r12 = 0
                java.io.File r7 = r7.b(r12)
            L_0x01a0:
                r19 = r7
                com.fyber.inneractive.sdk.player.cache.h r7 = com.fyber.inneractive.sdk.player.cache.h.this
                java.lang.String r7 = r7.l
                com.fyber.inneractive.sdk.player.cache.a r12 = new com.fyber.inneractive.sdk.player.cache.a
                r20 = 1
                r16 = r12
                r18 = r11
                r21 = r7
                r16.<init>(r17, r18, r19, r20, r21)
                r6.f = r12
                long r6 = r0.f
                int r11 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
                if (r11 <= 0) goto L_0x01ca
                com.fyber.inneractive.sdk.player.cache.h r11 = com.fyber.inneractive.sdk.player.cache.h.this
                com.fyber.inneractive.sdk.player.cache.a r11 = r11.f
                java.lang.String r6 = java.lang.String.valueOf(r6)
                java.util.Map<java.lang.String, java.lang.String> r7 = r11.e
                java.lang.String r11 = "http.file.length"
                r7.put(r11, r6)
            L_0x01ca:
                com.fyber.inneractive.sdk.player.cache.h r6 = com.fyber.inneractive.sdk.player.cache.h.this
                android.os.Handler r6 = r6.j
                if (r6 == 0) goto L_0x0127
                r8.flush()
                com.fyber.inneractive.sdk.player.cache.h r6 = com.fyber.inneractive.sdk.player.cache.h.this
                android.os.Handler r6 = r6.j
                r7 = 4
                r6.sendEmptyMessage(r7)
                goto L_0x0127
            L_0x01dd:
                return r1
            L_0x01de:
                com.fyber.inneractive.sdk.player.cache.h$g r1 = new com.fyber.inneractive.sdk.player.cache.h$g
                java.lang.Object[] r2 = new java.lang.Object[r10]
                java.text.NumberFormat r3 = java.text.NumberFormat.getInstance()
                java.lang.String r3 = r3.format(r13)
                r4 = 0
                r2[r4] = r3
                java.text.NumberFormat r3 = java.text.NumberFormat.getInstance()
                java.lang.String r3 = r3.format(r11)
                r4 = 1
                r2[r4] = r3
                java.lang.String r3 = "File size to big for cache (max=%s current=%s)"
                java.lang.String r2 = java.lang.String.format(r3, r2)
                r1.<init>(r2)
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.cache.h.f.a(java.io.OutputStream, java.net.URL, java.nio.ByteBuffer, long, int):java.net.HttpURLConnection");
        }

        public f(String str, int i2) {
            super(str);
            this.h = i2;
            this.i = h.this.r != null ? ((r) h.this.r.a(r.class)).e() : 10;
            this.j = h.this.r != null ? ((r) h.this.r.a(r.class)).f() : 500;
            this.k = h.this.r != null ? ((r) h.this.r.a(r.class)).h() : 25;
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(14:88|89|92|93|94|95|96|97|98|(0)|101|(0)|105|107) */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0073 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:97:0x01e0 */
        /* JADX WARNING: Removed duplicated region for block: B:100:0x01e6 A[Catch:{ all -> 0x01fd, all -> 0x0206 }] */
        /* JADX WARNING: Removed duplicated region for block: B:103:0x01f2 A[SYNTHETIC, Splitter:B:103:0x01f2] */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x00a7 A[Catch:{ g -> 0x00c3, all -> 0x0073, all -> 0x01bd }] */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x00a9 A[Catch:{ g -> 0x00c3, all -> 0x0073, all -> 0x01bd }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r22 = this;
                r8 = r22
                java.lang.String r0 = "%s | Starting a fresh download for %s"
                r9 = 2
                java.lang.Object[] r1 = new java.lang.Object[r9]
                com.fyber.inneractive.sdk.player.cache.h r2 = com.fyber.inneractive.sdk.player.cache.h.this
                java.lang.String r3 = r2.a
                r10 = 0
                r1[r10] = r3
                java.lang.String r2 = r2.a()
                r11 = 1
                r1[r11] = r2
                com.fyber.inneractive.sdk.util.IAlog.d(r0, r1)
                com.fyber.inneractive.sdk.util.h r0 = com.fyber.inneractive.sdk.util.h.b
                java.nio.ByteBuffer r12 = r0.b()
                r13 = 0
                java.net.URL r0 = new java.net.URL     // Catch:{ all -> 0x01c2 }
                com.fyber.inneractive.sdk.player.cache.h r1 = com.fyber.inneractive.sdk.player.cache.h.this     // Catch:{ all -> 0x01c2 }
                java.lang.String r1 = r1.e     // Catch:{ all -> 0x01c2 }
                r0.<init>(r1)     // Catch:{ all -> 0x01c2 }
                java.lang.String r1 = "%s | opening an editor for %s"
                java.lang.Object[] r2 = new java.lang.Object[r9]     // Catch:{ all -> 0x01c2 }
                com.fyber.inneractive.sdk.player.cache.h r3 = com.fyber.inneractive.sdk.player.cache.h.this     // Catch:{ all -> 0x01c2 }
                java.lang.String r4 = r3.a     // Catch:{ all -> 0x01c2 }
                r2[r10] = r4     // Catch:{ all -> 0x01c2 }
                java.lang.String r3 = r3.a()     // Catch:{ all -> 0x01c2 }
                r2[r11] = r3     // Catch:{ all -> 0x01c2 }
                com.fyber.inneractive.sdk.util.IAlog.d(r1, r2)     // Catch:{ all -> 0x01c2 }
                com.fyber.inneractive.sdk.player.cache.h r1 = com.fyber.inneractive.sdk.player.cache.h.this     // Catch:{ all -> 0x01c2 }
                com.fyber.inneractive.sdk.player.cache.c r2 = r1.b     // Catch:{ all -> 0x01c2 }
                java.lang.String r1 = r1.a()     // Catch:{ all -> 0x01c2 }
                com.fyber.inneractive.sdk.player.cache.c$c r1 = r2.a((java.lang.String) r1)     // Catch:{ all -> 0x01c2 }
                r8.g = r1     // Catch:{ all -> 0x01c2 }
                java.io.OutputStream r14 = r1.a(r10)     // Catch:{ all -> 0x01c2 }
                int r1 = r8.i     // Catch:{ all -> 0x01bf }
                int r1 = r1 - r11
                r15 = r13
            L_0x0051:
                if (r1 <= 0) goto L_0x00c5
                java.util.concurrent.atomic.AtomicBoolean r2 = r8.a     // Catch:{ all -> 0x01bd }
                boolean r2 = r2.compareAndSet(r10, r10)     // Catch:{ all -> 0x01bd }
                if (r2 == 0) goto L_0x00c5
                if (r15 == 0) goto L_0x0060
                r15.disconnect()     // Catch:{ all -> 0x0060 }
            L_0x0060:
                int r16 = r1 + -1
                long r17 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x01bd }
                long r5 = r8.e     // Catch:{ g -> 0x00c3, all -> 0x0073 }
                int r7 = r8.h     // Catch:{ g -> 0x00c3, all -> 0x0073 }
                r1 = r22
                r2 = r14
                r3 = r0
                r4 = r12
                java.net.HttpURLConnection r15 = r1.a(r2, r3, r4, r5, r7)     // Catch:{ g -> 0x00c3, all -> 0x0073 }
            L_0x0073:
                java.io.InputStream r1 = r8.b     // Catch:{ all -> 0x01bd }
                com.fyber.inneractive.sdk.player.cache.m.a((java.io.Closeable) r1)     // Catch:{ all -> 0x01bd }
                java.lang.String r1 = "%s Downloaded %d out of %d for key %s"
                r2 = 4
                java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x01bd }
                com.fyber.inneractive.sdk.player.cache.h r3 = com.fyber.inneractive.sdk.player.cache.h.this     // Catch:{ all -> 0x01bd }
                java.lang.String r3 = r3.a     // Catch:{ all -> 0x01bd }
                r2[r10] = r3     // Catch:{ all -> 0x01bd }
                long r3 = r8.e     // Catch:{ all -> 0x01bd }
                java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch:{ all -> 0x01bd }
                r2[r11] = r3     // Catch:{ all -> 0x01bd }
                long r3 = r8.f     // Catch:{ all -> 0x01bd }
                java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch:{ all -> 0x01bd }
                r2[r9] = r3     // Catch:{ all -> 0x01bd }
                com.fyber.inneractive.sdk.player.cache.h r3 = com.fyber.inneractive.sdk.player.cache.h.this     // Catch:{ all -> 0x01bd }
                java.lang.String r3 = r3.a()     // Catch:{ all -> 0x01bd }
                r4 = 3
                r2[r4] = r3     // Catch:{ all -> 0x01bd }
                com.fyber.inneractive.sdk.util.IAlog.d(r1, r2)     // Catch:{ all -> 0x01bd }
                long r1 = r8.e     // Catch:{ all -> 0x01bd }
                long r3 = r8.f     // Catch:{ all -> 0x01bd }
                int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
                if (r5 < 0) goto L_0x00a9
                r1 = 0
                goto L_0x0051
            L_0x00a9:
                long r1 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x01bd }
                long r1 = r1 - r17
                int r3 = r8.j     // Catch:{ all -> 0x01bd }
                long r3 = (long) r3     // Catch:{ all -> 0x01bd }
                int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
                if (r5 >= 0) goto L_0x00c0
                long r1 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x01bd }
                long r1 = r1 - r17
                long r3 = r3 - r1
                java.lang.Thread.sleep(r3)     // Catch:{ all -> 0x01bd }
            L_0x00c0:
                r1 = r16
                goto L_0x0051
            L_0x00c3:
                r0 = move-exception
                throw r0     // Catch:{ all -> 0x01bd }
            L_0x00c5:
                com.fyber.inneractive.sdk.player.cache.h r0 = com.fyber.inneractive.sdk.player.cache.h.this     // Catch:{ all -> 0x01bd }
                java.lang.Object r1 = r0.k     // Catch:{ all -> 0x01bd }
                monitor-enter(r1)     // Catch:{ all -> 0x01bd }
                long r2 = r8.f     // Catch:{ all -> 0x01ba }
                long r4 = r8.e     // Catch:{ all -> 0x01ba }
                int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r0 > 0) goto L_0x016a
                java.util.concurrent.atomic.AtomicBoolean r0 = r8.a     // Catch:{ all -> 0x01ba }
                boolean r0 = r0.compareAndSet(r11, r11)     // Catch:{ all -> 0x01ba }
                if (r0 == 0) goto L_0x00dc
                goto L_0x016a
            L_0x00dc:
                java.lang.String r0 = "%s | committing to cache - %s"
                java.lang.Object[] r2 = new java.lang.Object[r9]     // Catch:{ all -> 0x01ba }
                com.fyber.inneractive.sdk.player.cache.h r3 = com.fyber.inneractive.sdk.player.cache.h.this     // Catch:{ all -> 0x01ba }
                java.lang.String r4 = r3.a     // Catch:{ all -> 0x01ba }
                r2[r10] = r4     // Catch:{ all -> 0x01ba }
                java.lang.String r3 = r3.a()     // Catch:{ all -> 0x01ba }
                r2[r11] = r3     // Catch:{ all -> 0x01ba }
                com.fyber.inneractive.sdk.util.IAlog.d(r0, r2)     // Catch:{ all -> 0x01ba }
                com.fyber.inneractive.sdk.player.cache.m.a((java.io.Closeable) r14)     // Catch:{ all -> 0x01ba }
                com.fyber.inneractive.sdk.player.cache.h r0 = com.fyber.inneractive.sdk.player.cache.h.this     // Catch:{ all -> 0x01ba }
                com.fyber.inneractive.sdk.player.cache.a r2 = r0.f     // Catch:{ all -> 0x01ba }
                if (r2 == 0) goto L_0x0144
                java.lang.Object r2 = r2.d     // Catch:{ all -> 0x01ba }
                monitor-enter(r2)     // Catch:{ all -> 0x01ba }
                com.fyber.inneractive.sdk.player.cache.c$c r0 = r8.g     // Catch:{ all -> 0x0141 }
                boolean r3 = r0.c     // Catch:{ all -> 0x0141 }
                if (r3 == 0) goto L_0x0110
                com.fyber.inneractive.sdk.player.cache.c r3 = com.fyber.inneractive.sdk.player.cache.c.this     // Catch:{ all -> 0x0141 }
                com.fyber.inneractive.sdk.player.cache.c.a((com.fyber.inneractive.sdk.player.cache.c) r3, (com.fyber.inneractive.sdk.player.cache.c.C0107c) r0, (boolean) r10)     // Catch:{ all -> 0x0141 }
                com.fyber.inneractive.sdk.player.cache.c r3 = com.fyber.inneractive.sdk.player.cache.c.this     // Catch:{ all -> 0x0141 }
                com.fyber.inneractive.sdk.player.cache.c$d r0 = r0.a     // Catch:{ all -> 0x0141 }
                java.lang.String r0 = r0.a     // Catch:{ all -> 0x0141 }
                r3.d(r0)     // Catch:{ all -> 0x0141 }
                goto L_0x0115
            L_0x0110:
                com.fyber.inneractive.sdk.player.cache.c r3 = com.fyber.inneractive.sdk.player.cache.c.this     // Catch:{ all -> 0x0141 }
                com.fyber.inneractive.sdk.player.cache.c.a((com.fyber.inneractive.sdk.player.cache.c) r3, (com.fyber.inneractive.sdk.player.cache.c.C0107c) r0, (boolean) r11)     // Catch:{ all -> 0x0141 }
            L_0x0115:
                com.fyber.inneractive.sdk.player.cache.h r0 = com.fyber.inneractive.sdk.player.cache.h.this     // Catch:{ all -> 0x0141 }
                com.fyber.inneractive.sdk.player.cache.c r3 = r0.b     // Catch:{ all -> 0x0141 }
                monitor-enter(r3)     // Catch:{ all -> 0x0141 }
                r3.a()     // Catch:{ all -> 0x013e }
                r3.f()     // Catch:{ all -> 0x013e }
                java.io.Writer r0 = r3.i     // Catch:{ all -> 0x013e }
                r0.flush()     // Catch:{ all -> 0x013e }
                monitor-exit(r3)     // Catch:{ all -> 0x0141 }
                com.fyber.inneractive.sdk.player.cache.h r0 = com.fyber.inneractive.sdk.player.cache.h.this     // Catch:{ all -> 0x0141 }
                com.fyber.inneractive.sdk.player.cache.a r3 = r0.f     // Catch:{ all -> 0x0141 }
                com.fyber.inneractive.sdk.player.cache.c r4 = r0.b     // Catch:{ all -> 0x0141 }
                java.lang.String r0 = r0.a()     // Catch:{ all -> 0x0141 }
                java.io.File r0 = r4.a(r0, r10)     // Catch:{ all -> 0x0141 }
                r3.a = r0     // Catch:{ all -> 0x0141 }
                monitor-exit(r2)     // Catch:{ all -> 0x0141 }
                com.fyber.inneractive.sdk.player.cache.h r0 = com.fyber.inneractive.sdk.player.cache.h.this     // Catch:{ all -> 0x01ba }
                com.fyber.inneractive.sdk.player.cache.a r0 = r0.f     // Catch:{ all -> 0x01ba }
                r0.c = r10     // Catch:{ all -> 0x01ba }
                goto L_0x018d
            L_0x013e:
                r0 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x0141 }
                throw r0     // Catch:{ all -> 0x0141 }
            L_0x0141:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x0141 }
                throw r0     // Catch:{ all -> 0x01ba }
            L_0x0144:
                java.lang.String r17 = r0.a()     // Catch:{ all -> 0x01ba }
                com.fyber.inneractive.sdk.player.cache.h r2 = com.fyber.inneractive.sdk.player.cache.h.this     // Catch:{ all -> 0x01ba }
                java.lang.String r3 = r2.e     // Catch:{ all -> 0x01ba }
                com.fyber.inneractive.sdk.player.cache.c r4 = r2.b     // Catch:{ all -> 0x01ba }
                java.lang.String r2 = r2.a()     // Catch:{ all -> 0x01ba }
                java.io.File r19 = r4.a(r2, r10)     // Catch:{ all -> 0x01ba }
                r20 = 1
                com.fyber.inneractive.sdk.player.cache.h r2 = com.fyber.inneractive.sdk.player.cache.h.this     // Catch:{ all -> 0x01ba }
                java.lang.String r2 = r2.l     // Catch:{ all -> 0x01ba }
                com.fyber.inneractive.sdk.player.cache.a r4 = new com.fyber.inneractive.sdk.player.cache.a     // Catch:{ all -> 0x01ba }
                r16 = r4
                r18 = r3
                r21 = r2
                r16.<init>(r17, r18, r19, r20, r21)     // Catch:{ all -> 0x01ba }
                r0.f = r4     // Catch:{ all -> 0x01ba }
                goto L_0x018d
            L_0x016a:
                com.fyber.inneractive.sdk.player.cache.c$c r0 = r8.g     // Catch:{ all -> 0x01ba }
                r0.a()     // Catch:{ all -> 0x01ba }
                com.fyber.inneractive.sdk.player.cache.h r0 = com.fyber.inneractive.sdk.player.cache.h.this     // Catch:{ all -> 0x01ba }
                com.fyber.inneractive.sdk.player.cache.c r2 = r0.b     // Catch:{ all -> 0x01ba }
                java.lang.String r0 = r0.a()     // Catch:{ all -> 0x01ba }
                r2.d(r0)     // Catch:{ all -> 0x01ba }
                java.lang.String r0 = "%s | aborting cache - %s"
                java.lang.Object[] r2 = new java.lang.Object[r9]     // Catch:{ all -> 0x01ba }
                com.fyber.inneractive.sdk.player.cache.h r3 = com.fyber.inneractive.sdk.player.cache.h.this     // Catch:{ all -> 0x01ba }
                java.lang.String r4 = r3.a     // Catch:{ all -> 0x01ba }
                r2[r10] = r4     // Catch:{ all -> 0x01ba }
                java.lang.String r3 = r3.a()     // Catch:{ all -> 0x01ba }
                r2[r11] = r3     // Catch:{ all -> 0x01ba }
                com.fyber.inneractive.sdk.util.IAlog.d(r0, r2)     // Catch:{ all -> 0x01ba }
            L_0x018d:
                monitor-exit(r1)     // Catch:{ all -> 0x01ba }
                com.fyber.inneractive.sdk.player.cache.h r0 = com.fyber.inneractive.sdk.player.cache.h.this     // Catch:{ all -> 0x01bd }
                boolean unused = r0.o = r10     // Catch:{ all -> 0x01bd }
                if (r15 == 0) goto L_0x0198
                r15.disconnect()     // Catch:{ all -> 0x01bd }
            L_0x0198:
                java.util.concurrent.atomic.AtomicBoolean r0 = r8.a     // Catch:{ all -> 0x01bd }
                boolean r0 = r0.compareAndSet(r10, r10)     // Catch:{ all -> 0x01bd }
                if (r0 == 0) goto L_0x01b1
                com.fyber.inneractive.sdk.player.cache.h r0 = com.fyber.inneractive.sdk.player.cache.h.this     // Catch:{ all -> 0x01bd }
                android.os.Handler r0 = r0.j     // Catch:{ all -> 0x01bd }
                if (r0 == 0) goto L_0x01b1
                long r1 = r8.e     // Catch:{ all -> 0x01bd }
                long r3 = r8.f     // Catch:{ all -> 0x01bd }
                int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
                if (r5 < 0) goto L_0x01b1
                r0.sendEmptyMessage(r9)     // Catch:{ all -> 0x01bd }
            L_0x01b1:
                com.fyber.inneractive.sdk.player.cache.m.a((java.io.Closeable) r14)
                if (r15 == 0) goto L_0x01f5
                r15.disconnect()     // Catch:{ all -> 0x01f5 }
                goto L_0x01f5
            L_0x01ba:
                r0 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x01ba }
                throw r0     // Catch:{ all -> 0x01bd }
            L_0x01bd:
                r0 = move-exception
                goto L_0x01c5
            L_0x01bf:
                r0 = move-exception
                r15 = r13
                goto L_0x01c5
            L_0x01c2:
                r0 = move-exception
                r14 = r13
                r15 = r14
            L_0x01c5:
                java.lang.String r1 = "%s | mDownloadRunnable exception raised during download"
                java.lang.Object[] r2 = new java.lang.Object[r11]     // Catch:{ all -> 0x01fd }
                com.fyber.inneractive.sdk.player.cache.h r3 = com.fyber.inneractive.sdk.player.cache.h.this     // Catch:{ all -> 0x01fd }
                java.lang.String r3 = r3.a     // Catch:{ all -> 0x01fd }
                r2[r10] = r3     // Catch:{ all -> 0x01fd }
                com.fyber.inneractive.sdk.util.IAlog.a(r1, r0, r2)     // Catch:{ all -> 0x01fd }
                java.lang.String r1 = "mDownloadRunnable exception raised during download"
                java.lang.String r2 = r0.getMessage()     // Catch:{ all -> 0x01fd }
                com.fyber.inneractive.sdk.network.t.a(r1, r2, r13, r13)     // Catch:{ all -> 0x01fd }
                com.fyber.inneractive.sdk.player.cache.c$c r1 = r8.g     // Catch:{ Exception -> 0x01e0 }
                r1.a()     // Catch:{ Exception -> 0x01e0 }
            L_0x01e0:
                com.fyber.inneractive.sdk.player.cache.h r1 = com.fyber.inneractive.sdk.player.cache.h.this     // Catch:{ all -> 0x01fd }
                android.os.Handler r1 = r1.j     // Catch:{ all -> 0x01fd }
                if (r1 == 0) goto L_0x01ed
                android.os.Message r0 = r1.obtainMessage(r11, r0)     // Catch:{ all -> 0x01fd }
                r1.sendMessage(r0)     // Catch:{ all -> 0x01fd }
            L_0x01ed:
                com.fyber.inneractive.sdk.player.cache.m.a((java.io.Closeable) r14)
                if (r15 == 0) goto L_0x01f5
                r15.disconnect()     // Catch:{ all -> 0x01f5 }
            L_0x01f5:
                com.fyber.inneractive.sdk.util.h r0 = com.fyber.inneractive.sdk.util.h.b
                java.util.Queue<java.nio.ByteBuffer> r0 = r0.a
                r0.offer(r12)
                return
            L_0x01fd:
                r0 = move-exception
                com.fyber.inneractive.sdk.player.cache.m.a((java.io.Closeable) r14)
                if (r15 == 0) goto L_0x0206
                r15.disconnect()     // Catch:{ all -> 0x0206 }
            L_0x0206:
                com.fyber.inneractive.sdk.util.h r1 = com.fyber.inneractive.sdk.util.h.b
                java.util.Queue<java.nio.ByteBuffer> r1 = r1.a
                r1.offer(r12)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.cache.h.f.run():void");
        }
    }

    public static class g extends e {
        public g(String str) {
            super(str);
        }
    }

    /* renamed from: com.fyber.inneractive.sdk.player.cache.h$h  reason: collision with other inner class name */
    public interface C0108h {
    }

    public interface i {
    }

    public h(c cVar, String str, b bVar, int i2, s sVar) {
        this.b = cVar;
        this.e = str;
        this.l = MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(str).toLowerCase(Locale.US));
        this.d = bVar;
        this.r = sVar;
        this.h = new f(String.format("MediaDownloader-%s-A", new Object[]{a()}), i2);
        this.i = new HandlerThread(String.format("MediaDownloader-%s-A", new Object[]{a()}));
    }

    public final void b() {
        q.b.post(new a());
    }

    public void handleMessage(Message message) {
        if (message.what != 4 || this.f.f) {
            int i2 = message.what;
            if (i2 == 1) {
                Object obj = message.obj;
                if (obj instanceof Exception) {
                    a((Exception) obj);
                } else {
                    a((Exception) new e("download failed"));
                }
                a(false);
            } else if (i2 == 2) {
                if (this.m) {
                    synchronized (this.k) {
                        IAlog.d("%s | reading from cache 2 - %s", this.a, a());
                        if (this.d.a(this.f, this.l) == b.a.INVALID) {
                            a((Exception) new e("Failed cache validation after downloading complete file"));
                            a(true);
                        } else {
                            a(this.f);
                            a aVar = this.f;
                            aVar.e.putAll(this.d.a);
                            b();
                        }
                    }
                } else {
                    q.b.post(new c());
                }
                IAlog.d("%s | Download success for cache key %s", this.a, a());
            }
        } else {
            synchronized (this.k) {
                IAlog.d("%s | reading from cache 1 - %s", this.a, a());
                b.a a2 = this.d.a(this.f, this.l);
                if (a2 == b.a.INVALID) {
                    a((Exception) new e("Failed cache validation"));
                    a(true);
                } else if (a2 == b.a.PARTIAL_CANNOT_VALIDATE) {
                    this.m = true;
                } else {
                    this.f.f = true;
                    a(this.f);
                    a aVar2 = this.f;
                    aVar2.e.putAll(this.d.a);
                    b();
                }
            }
        }
    }

    public static void b(h hVar, boolean z) {
        g gVar = new g(hVar);
        Handler handler = hVar.j;
        if (handler == null) {
            return;
        }
        if (z) {
            handler.postAtFrontOfQueue(gVar);
        } else {
            handler.postDelayed(gVar, 4);
        }
    }

    public final void a(Exception exc) {
        q.b.post(new b(exc));
    }

    public final void a(boolean z) {
        f fVar = this.h;
        if (fVar != null) {
            fVar.a.compareAndSet(false, true);
            this.h = null;
        }
        HandlerThread handlerThread = this.i;
        if (handlerThread != null) {
            handlerThread.quit();
        }
        this.j = null;
        if (z) {
            try {
                this.b.d(a());
            } catch (IOException e2) {
                IAlog.a("failed to remove cache key", e2, new Object[0]);
            }
        }
    }

    public String a() {
        String str = "";
        if (this.p == null) {
            String str2 = this.e;
            try {
                MessageDigest instance = MessageDigest.getInstance(AndroidStaticDeviceInfoDataSource.ALGORITHM_SHA1);
                instance.update(str2.getBytes());
                byte[] digest = instance.digest();
                StringBuffer stringBuffer = new StringBuffer();
                for (byte b2 : digest) {
                    stringBuffer.append(Integer.toHexString((b2 & UByte.MAX_VALUE) | 256).substring(1));
                }
                str = stringBuffer.toString();
            } catch (NoSuchAlgorithmException unused) {
                try {
                    MessageDigest instance2 = MessageDigest.getInstance("MD5");
                    instance2.update(str2.getBytes());
                    byte[] digest2 = instance2.digest();
                    StringBuffer stringBuffer2 = new StringBuffer();
                    for (byte b3 : digest2) {
                        stringBuffer2.append(Integer.toHexString((b3 & UByte.MAX_VALUE) | 256).substring(1));
                    }
                    str = stringBuffer2.toString();
                } catch (NoSuchAlgorithmException unused2) {
                    str = str2.replaceAll("\\W+", str);
                }
            } catch (NullPointerException unused3) {
            }
            this.p = str;
        }
        return this.p;
    }

    public final void a(a aVar) {
        C0108h hVar;
        if (aVar != null && (hVar = this.q) != null) {
            File a2 = aVar.a();
            File file = ((j) hVar).a;
            if (file == null || a2 == null || !file.getAbsolutePath().equals(a2.getAbsolutePath())) {
                C0108h hVar2 = this.q;
                File a3 = aVar.a();
                j jVar = (j) hVar2;
                jVar.getClass();
                long currentTimeMillis = System.currentTimeMillis();
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                try {
                    mediaMetadataRetriever.setDataSource(a3.getPath());
                    mediaMetadataRetriever.extractMetadata(8192);
                    Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(1);
                    jVar.b = frameAtTime;
                    if (frameAtTime != null && frameAtTime.getWidth() > 0 && jVar.b.getHeight() > 0) {
                        jVar.a = a3;
                    }
                    mediaMetadataRetriever.release();
                } catch (Exception e2) {
                    try {
                        IAlog.a("Failed getting frame from video file%s", u.b((Throwable) e2));
                        mediaMetadataRetriever.release();
                    } catch (Throwable unused) {
                    }
                } catch (Throwable unused2) {
                }
                IAlog.d("FirstFrameDownloadMediaProcessor processing finished in %dms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                return;
            }
            return;
        }
        return;
        throw th;
    }
}
