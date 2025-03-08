package com.fyber.inneractive.sdk.player.cache;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.config.global.features.r;
import com.fyber.inneractive.sdk.config.global.s;
import com.fyber.inneractive.sdk.player.cache.h;
import com.fyber.inneractive.sdk.player.exoplayer2.upstream.g;
import com.fyber.inneractive.sdk.util.j;
import com.fyber.inneractive.sdk.util.n0;
import com.fyber.inneractive.sdk.util.u;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class d implements g {
    public boolean a = false;
    public a b;
    public h c;
    public Uri d;
    public long e = 0;
    public FileInputStream f;
    public FileInputStream g;
    public b h;
    public c i;
    public int j;
    public s k;

    public class a implements h.i {
        public final /* synthetic */ j a;
        public final /* synthetic */ AtomicReference b;
        public final /* synthetic */ CountDownLatch c;

        public a(j jVar, AtomicReference atomicReference, CountDownLatch countDownLatch) {
            this.a = jVar;
            this.b = atomicReference;
            this.c = countDownLatch;
        }

        public void a(h hVar, a aVar, Exception exc) {
            b bVar;
            d dVar = d.this;
            if (!dVar.a) {
                if (exc == null) {
                    Bitmap bitmap = this.a.b;
                    if (!(bitmap == null || (bVar = dVar.h) == null)) {
                        ((com.fyber.inneractive.sdk.player.controller.d) bVar).C = bitmap;
                    }
                    dVar.b = aVar;
                } else {
                    this.b.set(exc);
                }
            }
            this.c.countDown();
        }
    }

    public interface b {
    }

    public interface c {
    }

    public Uri a() {
        return this.d;
    }

    public long a(com.fyber.inneractive.sdk.player.exoplayer2.upstream.j jVar) throws IOException {
        String str;
        r rVar;
        b bVar;
        r.d dVar;
        com.fyber.inneractive.sdk.player.exoplayer2.upstream.j jVar2 = jVar;
        if (this.b == null) {
            CountDownLatch countDownLatch = new CountDownLatch(1);
            AtomicReference atomicReference = new AtomicReference();
            j jVar3 = new j();
            Uri uri = jVar2.a;
            this.d = uri;
            n nVar = n.f;
            int i2 = this.j;
            String uri2 = uri.toString();
            s sVar = this.k;
            a aVar = new a(jVar3, atomicReference, countDownLatch);
            c cVar = nVar.b;
            boolean a2 = IAConfigManager.M.u.b.a("validateHasVideoTracks", false);
            if (sVar == null) {
                rVar = null;
            } else {
                rVar = (r) sVar.a(r.class);
            }
            if (rVar != null) {
                int[] iArr = h.d.a;
                r.d dVar2 = r.d.LEGACY;
                r.d dVar3 = dVar2;
                String a3 = rVar.a("v_type", dVar2.key);
                r.d[] values = r.d.values();
                int length = values.length;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        dVar = dVar3;
                        break;
                    }
                    int i4 = length;
                    r.d dVar4 = values[i3];
                    r.d[] dVarArr = values;
                    r.d dVar5 = dVar4;
                    if (TextUtils.equals(dVar4.key, a3.toLowerCase(Locale.US))) {
                        dVar = dVar5;
                        break;
                    }
                    i3++;
                    length = i4;
                    values = dVarArr;
                }
                int i5 = iArr[dVar.ordinal()];
                bVar = i5 != 1 ? i5 != 2 ? new j(a2) : new i() : new k();
            } else {
                bVar = new j(a2);
            }
            h hVar = new h(cVar, uri2, bVar, i2, sVar);
            hVar.g = aVar;
            nVar.d.add(hVar.a());
            this.c = hVar;
            hVar.q = jVar3;
            hVar.o = true;
            HandlerThread handlerThread = hVar.i;
            if (handlerThread != null) {
                handlerThread.start();
                n0 n0Var = new n0(hVar.i.getLooper(), hVar);
                hVar.j = n0Var;
                n0Var.post(new f(hVar));
            }
            c cVar2 = this.i;
            if (cVar2 != null) {
                ((com.fyber.inneractive.sdk.player.controller.d) cVar2).F.add(this.c);
            }
            try {
                countDownLatch.await(7, TimeUnit.SECONDS);
                if (this.b == null) {
                    if (atomicReference.get() == null) {
                        throw new IOException("Cache has failed to download");
                    }
                    throw new IOException((Throwable) atomicReference.get());
                }
            } catch (InterruptedException e2) {
                h hVar2 = this.c;
                hVar2.a(hVar2.o);
                throw new IOException(e2);
            }
        }
        this.e = jVar.d;
        a aVar2 = this.b;
        if (aVar2.c) {
            str = aVar2.e.get("http.file.length");
        } else {
            str = String.valueOf(aVar2.a().length());
        }
        if (str == null || !TextUtils.isDigitsOnly(str)) {
            return -1;
        }
        return Long.parseLong(str);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(10:7|(2:10|8)|48|11|12|13|29|30|31|33) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x007b */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0073 A[SYNTHETIC, Splitter:B:24:0x0073] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x007a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int b(byte[] r12, int r13, int r14) throws java.io.IOException {
        /*
            r11 = this;
            com.fyber.inneractive.sdk.player.cache.a r0 = r11.b
            java.lang.String r0 = r0.b
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream
            int r2 = r12.length
            r1.<init>(r2)
            long r2 = r11.e
            int r3 = (int) r2
            com.fyber.inneractive.sdk.util.h r2 = com.fyber.inneractive.sdk.util.h.b
            java.nio.ByteBuffer r2 = r2.b()
            r4 = 0
            r5 = 0
            java.net.URL r6 = new java.net.URL     // Catch:{ IOException -> 0x0086, all -> 0x006f }
            r6.<init>(r0)     // Catch:{ IOException -> 0x0086, all -> 0x006f }
            java.net.URLConnection r0 = r6.openConnection()     // Catch:{ IOException -> 0x0086, all -> 0x006f }
            java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0     // Catch:{ IOException -> 0x0086, all -> 0x006f }
            java.lang.String r6 = "Range"
            java.util.Locale r7 = java.util.Locale.ENGLISH     // Catch:{ IOException -> 0x006b, all -> 0x0066 }
            java.lang.String r8 = "bytes=%d-"
            r9 = 1
            java.lang.Object[] r9 = new java.lang.Object[r9]     // Catch:{ IOException -> 0x006b, all -> 0x0066 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ IOException -> 0x006b, all -> 0x0066 }
            r9[r4] = r3     // Catch:{ IOException -> 0x006b, all -> 0x0066 }
            java.lang.String r3 = java.lang.String.format(r7, r8, r9)     // Catch:{ IOException -> 0x006b, all -> 0x0066 }
            r0.setRequestProperty(r6, r3)     // Catch:{ IOException -> 0x006b, all -> 0x0066 }
            r0.connect()     // Catch:{ IOException -> 0x006b, all -> 0x0066 }
            int r3 = r0.getResponseCode()     // Catch:{ IOException -> 0x006b, all -> 0x0066 }
            r6 = 206(0xce, float:2.89E-43)
            if (r3 != r6) goto L_0x005e
            java.io.InputStream r5 = r0.getInputStream()     // Catch:{ IOException -> 0x006b, all -> 0x0066 }
            byte[] r2 = r2.array()     // Catch:{ IOException -> 0x006b, all -> 0x0066 }
        L_0x0049:
            int r3 = r5.read(r2)     // Catch:{ IOException -> 0x006b, all -> 0x0066 }
            r6 = -1
            if (r3 == r6) goto L_0x0054
            r1.write(r2)     // Catch:{ IOException -> 0x006b, all -> 0x0066 }
            goto L_0x0049
        L_0x0054:
            r5.close()     // Catch:{ IOException -> 0x006b, all -> 0x0066 }
            r0.disconnect()     // Catch:{ IOException -> 0x006b, all -> 0x0066 }
            r0.disconnect()     // Catch:{ Exception -> 0x007b }
            goto L_0x007b
        L_0x005e:
            java.io.IOException r2 = new java.io.IOException     // Catch:{ IOException -> 0x006b, all -> 0x0066 }
            java.lang.String r3 = "Server did not reply with proper range."
            r2.<init>(r3)     // Catch:{ IOException -> 0x006b, all -> 0x0066 }
            throw r2     // Catch:{ IOException -> 0x006b, all -> 0x0066 }
        L_0x0066:
            r10 = r5
            r5 = r0
            r0 = r10
            goto L_0x0071
        L_0x006b:
            r12 = move-exception
            r13 = r5
            r5 = r0
            goto L_0x0088
        L_0x006f:
            r0 = r5
        L_0x0071:
            if (r5 == 0) goto L_0x0078
            r5.disconnect()     // Catch:{ Exception -> 0x0077 }
            goto L_0x0078
        L_0x0077:
        L_0x0078:
            if (r0 == 0) goto L_0x007e
            r5 = r0
        L_0x007b:
            r5.close()     // Catch:{ Exception -> 0x007e }
        L_0x007e:
            byte[] r0 = r1.toByteArray()
            java.lang.System.arraycopy(r0, r4, r12, r13, r14)
            return r14
        L_0x0086:
            r12 = move-exception
            r13 = r5
        L_0x0088:
            throw r12     // Catch:{ all -> 0x0089 }
        L_0x0089:
            r12 = move-exception
            if (r5 == 0) goto L_0x0091
            r5.disconnect()     // Catch:{ Exception -> 0x0090 }
            goto L_0x0091
        L_0x0090:
        L_0x0091:
            if (r13 == 0) goto L_0x0096
            r13.close()     // Catch:{ Exception -> 0x0096 }
        L_0x0096:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.cache.d.b(byte[], int, int):int");
    }

    public void close() throws IOException {
        this.a = true;
        this.e = 0;
        u.b((Closeable) this.f);
        u.b((Closeable) this.g);
        this.f = null;
        this.g = null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x0083 A[Catch:{ InterruptedException -> 0x003e }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0097 A[Catch:{ InterruptedException -> 0x003e }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0098 A[Catch:{ InterruptedException -> 0x003e }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int a(byte[] r10, int r11, int r12) throws java.io.IOException {
        /*
            r9 = this;
            com.fyber.inneractive.sdk.player.cache.a r0 = r9.b
            if (r0 != 0) goto L_0x0006
            r10 = -1
            return r10
        L_0x0006:
            if (r12 != 0) goto L_0x0009
            return r12
        L_0x0009:
            java.lang.Object r0 = r0.d
            monitor-enter(r0)
            com.fyber.inneractive.sdk.player.cache.a r1 = r9.b     // Catch:{ all -> 0x00b6 }
            java.io.File r1 = r1.a()     // Catch:{ all -> 0x00b6 }
            long r1 = r1.length()     // Catch:{ all -> 0x00b6 }
            int r2 = (int) r1     // Catch:{ all -> 0x00b6 }
            if (r11 <= r2) goto L_0x001f
            int r10 = r9.b(r10, r11, r12)     // Catch:{ all -> 0x00b6 }
            monitor-exit(r0)     // Catch:{ all -> 0x00b6 }
            return r10
        L_0x001f:
            com.fyber.inneractive.sdk.player.cache.a r1 = r9.b     // Catch:{ all -> 0x00b6 }
            boolean r1 = r1.c     // Catch:{ all -> 0x00b6 }
            r3 = 0
            r5 = 0
            r6 = 1
            if (r1 == 0) goto L_0x0058
        L_0x0029:
            int r1 = r2 - r11
            if (r1 > 0) goto L_0x0045
            r1 = 50
            r9.wait(r3, r1)     // Catch:{ InterruptedException -> 0x003e }
            com.fyber.inneractive.sdk.player.cache.a r1 = r9.b     // Catch:{ all -> 0x00b6 }
            java.io.File r1 = r1.a()     // Catch:{ all -> 0x00b6 }
            long r1 = r1.length()     // Catch:{ all -> 0x00b6 }
            int r2 = (int) r1     // Catch:{ all -> 0x00b6 }
            goto L_0x0029
        L_0x003e:
            r10 = move-exception
            java.io.IOException r11 = new java.io.IOException     // Catch:{ all -> 0x00b6 }
            r11.<init>(r10)     // Catch:{ all -> 0x00b6 }
            throw r11     // Catch:{ all -> 0x00b6 }
        L_0x0045:
            java.io.FileInputStream r1 = r9.g     // Catch:{ all -> 0x00b6 }
            if (r1 != 0) goto L_0x007f
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ all -> 0x00b6 }
            com.fyber.inneractive.sdk.player.cache.a r5 = r9.b     // Catch:{ all -> 0x00b6 }
            java.io.File r5 = r5.a()     // Catch:{ all -> 0x00b6 }
            r1.<init>(r5)     // Catch:{ all -> 0x00b6 }
            r9.g = r1     // Catch:{ all -> 0x00b6 }
        L_0x0056:
            r5 = 1
            goto L_0x007f
        L_0x0058:
            java.io.FileInputStream r1 = r9.f     // Catch:{ all -> 0x00b6 }
            if (r1 != 0) goto L_0x007f
            java.lang.String r1 = "%s creating a single instance of fis"
            java.lang.Object[] r7 = new java.lang.Object[r6]     // Catch:{ all -> 0x00b6 }
            java.lang.String r8 = r9.toString()     // Catch:{ all -> 0x00b6 }
            r7[r5] = r8     // Catch:{ all -> 0x00b6 }
            com.fyber.inneractive.sdk.util.IAlog.a(r1, r7)     // Catch:{ all -> 0x00b6 }
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ all -> 0x00b6 }
            com.fyber.inneractive.sdk.player.cache.a r5 = r9.b     // Catch:{ all -> 0x00b6 }
            java.io.File r5 = r5.a()     // Catch:{ all -> 0x00b6 }
            r1.<init>(r5)     // Catch:{ all -> 0x00b6 }
            r9.f = r1     // Catch:{ all -> 0x00b6 }
            java.io.FileInputStream r1 = r9.g     // Catch:{ all -> 0x00b6 }
            com.fyber.inneractive.sdk.util.u.b((java.io.Closeable) r1)     // Catch:{ all -> 0x00b6 }
            r1 = 0
            r9.g = r1     // Catch:{ all -> 0x00b6 }
            goto L_0x0056
        L_0x007f:
            java.io.FileInputStream r1 = r9.f     // Catch:{ all -> 0x00b6 }
            if (r1 != 0) goto L_0x0085
            java.io.FileInputStream r1 = r9.g     // Catch:{ all -> 0x00b6 }
        L_0x0085:
            long r6 = r9.e     // Catch:{ all -> 0x00b6 }
            int r8 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r8 <= 0) goto L_0x00a0
            if (r5 == 0) goto L_0x00a0
            long r3 = r1.skip(r6)     // Catch:{ all -> 0x00b6 }
            long r5 = r9.e     // Catch:{ all -> 0x00b6 }
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L_0x0098
            goto L_0x00a0
        L_0x0098:
            java.io.IOException r10 = new java.io.IOException     // Catch:{ all -> 0x00b6 }
            java.lang.String r11 = "Failed to skip the stream"
            r10.<init>(r11)     // Catch:{ all -> 0x00b6 }
            throw r10     // Catch:{ all -> 0x00b6 }
        L_0x00a0:
            int r2 = r2 - r11
            int r3 = r10.length     // Catch:{ all -> 0x00b6 }
            int r2 = java.lang.Math.min(r3, r2)     // Catch:{ all -> 0x00b6 }
            int r12 = java.lang.Math.min(r2, r12)     // Catch:{ all -> 0x00b6 }
            int r10 = r1.read(r10, r11, r12)     // Catch:{ all -> 0x00b6 }
            monitor-exit(r0)     // Catch:{ all -> 0x00b6 }
            long r11 = r9.e
            long r0 = (long) r10
            long r11 = r11 + r0
            r9.e = r11
            return r10
        L_0x00b6:
            r10 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00b6 }
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.player.cache.d.a(byte[], int, int):int");
    }
}
