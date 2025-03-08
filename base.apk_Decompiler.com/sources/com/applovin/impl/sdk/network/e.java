package com.applovin.impl.sdk.network;

import android.os.Process;
import androidx.core.util.Consumer;
import com.applovin.impl.sdk.n;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class e {
    private final PriorityBlockingQueue<b> aHR = new PriorityBlockingQueue<>();
    private final n sdk;

    public e(n nVar) {
        this.sdk = nVar;
    }

    public void start() {
        for (int i = 0; i < ((Integer) this.sdk.a(com.applovin.impl.sdk.c.b.aKB)).intValue(); i++) {
            new a(this.aHR, i, this.sdk).start();
        }
    }

    public void a(b bVar) {
        if (bVar != null) {
            this.aHR.add(bVar);
            return;
        }
        throw new IllegalArgumentException("No request specified");
    }

    private static class a extends Thread {
        private final BlockingQueue<b> aHS;
        private final n sdk;

        private a(BlockingQueue<b> blockingQueue, int i, n nVar) {
            super("AppLovinSdk:network");
            if (blockingQueue == null) {
                throw new IllegalArgumentException("No request queue specified");
            } else if (nVar != null) {
                this.aHS = blockingQueue;
                this.sdk = nVar;
                setPriority(((Integer) nVar.a(com.applovin.impl.sdk.c.b.aQK)).intValue());
            } else {
                throw new IllegalArgumentException("No sdk specified");
            }
        }

        public void run() {
            Process.setThreadPriority(10);
            while (true) {
                try {
                    Ih();
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                }
            }
        }

        private void Ih() throws InterruptedException {
            b(this.aHS.take());
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v0, resolved type: byte[]} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: byte[]} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v0, resolved type: java.io.InputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: java.net.HttpURLConnection} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v1, resolved type: byte[]} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: java.io.Closeable} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v2, resolved type: byte[]} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v3, resolved type: byte[]} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v5, resolved type: byte[]} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: java.net.HttpURLConnection} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: java.io.InputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: java.net.HttpURLConnection} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v3, resolved type: java.io.InputStream} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v7, resolved type: byte[]} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v14, resolved type: java.lang.Throwable} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v10, resolved type: java.io.InputStream} */
        /* JADX WARNING: type inference failed for: r3v0, types: [java.io.Closeable] */
        /* JADX WARNING: type inference failed for: r5v0, types: [java.lang.Throwable] */
        /* JADX WARNING: type inference failed for: r3v2 */
        /* JADX WARNING: type inference failed for: r5v6 */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x0077 A[Catch:{ all -> 0x00cf }] */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x0086 A[SYNTHETIC, Splitter:B:26:0x0086] */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x0094  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void b(com.applovin.impl.sdk.network.e.b r13) {
            /*
                r12 = this;
                long r0 = android.os.SystemClock.elapsedRealtime()
                r2 = 0
                r3 = 0
                java.net.HttpURLConnection r4 = r12.c(r13)     // Catch:{ all -> 0x0065 }
                byte[] r5 = r13.aHV     // Catch:{ all -> 0x0062 }
                if (r5 == 0) goto L_0x0031
                byte[] r5 = r13.aHV     // Catch:{ all -> 0x0062 }
                int r5 = r5.length     // Catch:{ all -> 0x0062 }
                if (r5 <= 0) goto L_0x0031
                r5 = 1
                r4.setDoOutput(r5)     // Catch:{ all -> 0x0062 }
                byte[] r5 = r13.aHV     // Catch:{ all -> 0x0062 }
                int r5 = r5.length     // Catch:{ all -> 0x0062 }
                r4.setFixedLengthStreamingMode(r5)     // Catch:{ all -> 0x0062 }
                java.io.OutputStream r5 = r4.getOutputStream()     // Catch:{ all -> 0x0062 }
                byte[] r6 = r13.aHV     // Catch:{ all -> 0x0062 }
                r5.write(r6)     // Catch:{ all -> 0x0062 }
                r5.close()     // Catch:{ all -> 0x0062 }
            L_0x0031:
                long r0 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x0062 }
                int r2 = r4.getResponseCode()     // Catch:{ all -> 0x0062 }
                long r5 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x0062 }
                if (r2 <= 0) goto L_0x004c
                java.io.InputStream r7 = r4.getInputStream()     // Catch:{ all -> 0x0062 }
                com.applovin.impl.sdk.n r8 = r12.sdk     // Catch:{ all -> 0x004a }
                byte[] r8 = com.applovin.impl.sdk.utils.i.a((java.io.InputStream) r7, (com.applovin.impl.sdk.n) r8)     // Catch:{ all -> 0x004a }
                goto L_0x004e
            L_0x004a:
                r5 = move-exception
                goto L_0x0068
            L_0x004c:
                r7 = r3
                r8 = r7
            L_0x004e:
                com.applovin.impl.sdk.n r9 = r12.sdk
                com.applovin.impl.sdk.utils.u.a((java.io.Closeable) r7, (com.applovin.impl.sdk.n) r9)
                com.applovin.impl.sdk.n r7 = r12.sdk
                com.applovin.impl.sdk.utils.u.a((java.io.Closeable) r3, (com.applovin.impl.sdk.n) r7)
                com.applovin.impl.sdk.n r7 = r12.sdk
                com.applovin.impl.sdk.utils.u.a((java.net.HttpURLConnection) r4, (com.applovin.impl.sdk.n) r7)
                r10 = r3
                r3 = r8
                r8 = r5
                r5 = r10
                goto L_0x00a5
            L_0x0062:
                r5 = move-exception
                r7 = r3
                goto L_0x0068
            L_0x0065:
                r5 = move-exception
                r4 = r3
                r7 = r4
            L_0x0068:
                long r8 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x00cf }
                com.applovin.impl.sdk.n r6 = r12.sdk     // Catch:{ all -> 0x00cf }
                r6.BN()     // Catch:{ all -> 0x00cf }
                boolean r6 = com.applovin.impl.sdk.x.Fn()     // Catch:{ all -> 0x00cf }
                if (r6 == 0) goto L_0x0084
                com.applovin.impl.sdk.n r6 = r12.sdk     // Catch:{ all -> 0x00cf }
                com.applovin.impl.sdk.x r6 = r6.BN()     // Catch:{ all -> 0x00cf }
                java.lang.String r10 = "NetworkCommunicationThread"
                java.lang.String r11 = "Failed to make HTTP request"
                r6.b((java.lang.String) r10, (java.lang.String) r11, (java.lang.Throwable) r5)     // Catch:{ all -> 0x00cf }
            L_0x0084:
                if (r4 == 0) goto L_0x0094
                java.io.InputStream r6 = r4.getErrorStream()     // Catch:{ all -> 0x0091 }
                com.applovin.impl.sdk.n r10 = r12.sdk     // Catch:{ all -> 0x0092 }
                byte[] r10 = com.applovin.impl.sdk.utils.i.a((java.io.InputStream) r6, (com.applovin.impl.sdk.n) r10)     // Catch:{ all -> 0x0092 }
                goto L_0x0096
            L_0x0091:
                r6 = r3
            L_0x0092:
                r10 = r3
                goto L_0x0096
            L_0x0094:
                r6 = r3
                r10 = r6
            L_0x0096:
                com.applovin.impl.sdk.n r11 = r12.sdk
                com.applovin.impl.sdk.utils.u.a((java.io.Closeable) r7, (com.applovin.impl.sdk.n) r11)
                com.applovin.impl.sdk.n r7 = r12.sdk
                com.applovin.impl.sdk.utils.u.a((java.io.Closeable) r6, (com.applovin.impl.sdk.n) r7)
                com.applovin.impl.sdk.n r6 = r12.sdk
                com.applovin.impl.sdk.utils.u.a((java.net.HttpURLConnection) r4, (com.applovin.impl.sdk.n) r6)
            L_0x00a5:
                com.applovin.impl.sdk.network.e$c$a r4 = com.applovin.impl.sdk.network.e.c.Io()
                com.applovin.impl.sdk.network.e$c$a r2 = r4.gI(r2)
                com.applovin.impl.sdk.network.e$c$a r2 = r2.L(r3)
                com.applovin.impl.sdk.network.e$c$a r2 = r2.M(r10)
                long r8 = r8 - r0
                com.applovin.impl.sdk.network.e$c$a r0 = r2.bR(r8)
                com.applovin.impl.sdk.network.e$c$a r0 = r0.o(r5)
                com.applovin.impl.sdk.network.e$c r0 = r0.Ip()
                java.util.concurrent.Executor r1 = r13.aHX
                com.applovin.impl.sdk.network.e$a$$ExternalSyntheticLambda0 r2 = new com.applovin.impl.sdk.network.e$a$$ExternalSyntheticLambda0
                r2.<init>(r13, r0)
                r1.execute(r2)
                return
            L_0x00cf:
                r13 = move-exception
                com.applovin.impl.sdk.n r0 = r12.sdk
                com.applovin.impl.sdk.utils.u.a((java.io.Closeable) r7, (com.applovin.impl.sdk.n) r0)
                com.applovin.impl.sdk.n r0 = r12.sdk
                com.applovin.impl.sdk.utils.u.a((java.io.Closeable) r3, (com.applovin.impl.sdk.n) r0)
                com.applovin.impl.sdk.n r0 = r12.sdk
                com.applovin.impl.sdk.utils.u.a((java.net.HttpURLConnection) r4, (com.applovin.impl.sdk.n) r0)
                throw r13
            */
            throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.network.e.a.b(com.applovin.impl.sdk.network.e$b):void");
        }

        private HttpURLConnection c(b bVar) throws IOException {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(bVar.aHr).openConnection();
            httpURLConnection.setRequestMethod(bVar.aHs);
            httpURLConnection.setConnectTimeout(bVar.aHI);
            httpURLConnection.setReadTimeout(bVar.aHI);
            httpURLConnection.setDefaultUseCaches(false);
            httpURLConnection.setAllowUserInteraction(false);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setInstanceFollowRedirects(true);
            httpURLConnection.setDoInput(true);
            if (!bVar.aHU.isEmpty()) {
                for (Map.Entry entry : bVar.aHU.entrySet()) {
                    httpURLConnection.setRequestProperty((String) entry.getKey(), (String) entry.getValue());
                }
            }
            return httpURLConnection;
        }
    }

    public static class b implements Comparable<b> {
        private static final AtomicInteger aHT = new AtomicInteger();
        /* access modifiers changed from: private */
        public final int aHI;
        /* access modifiers changed from: private */
        public final Map<String, String> aHU;
        /* access modifiers changed from: private */
        public final byte[] aHV;
        /* access modifiers changed from: private */
        public final Consumer<c> aHW;
        /* access modifiers changed from: private */
        public final Executor aHX;
        private final int aHY;
        /* access modifiers changed from: private */
        public final String aHr;
        /* access modifiers changed from: private */
        public final String aHs;

        private b(a aVar) {
            this.aHr = aVar.aHr;
            this.aHs = aVar.aHs;
            this.aHU = aVar.aHU != null ? aVar.aHU : Collections.emptyMap();
            this.aHV = aVar.aHV;
            this.aHI = aVar.aHI;
            this.aHW = aVar.aHW;
            this.aHX = aVar.aHX;
            this.aHY = aHT.incrementAndGet();
        }

        /* renamed from: d */
        public int compareTo(b bVar) {
            return this.aHY - bVar.aHY;
        }

        public static class a {
            /* access modifiers changed from: private */
            public int aHI;
            /* access modifiers changed from: private */
            public Map<String, String> aHU = new HashMap();
            /* access modifiers changed from: private */
            public byte[] aHV;
            /* access modifiers changed from: private */
            public Consumer<c> aHW;
            /* access modifiers changed from: private */
            public Executor aHX;
            /* access modifiers changed from: private */
            public String aHr;
            /* access modifiers changed from: private */
            public String aHs;

            public a K(byte[] bArr) {
                this.aHV = bArr;
                return this;
            }

            public a a(Consumer<c> consumer) {
                this.aHW = consumer;
                return this;
            }

            public a a(Executor executor) {
                this.aHX = executor;
                return this;
            }

            public a cZ(String str) {
                this.aHr = str;
                return this;
            }

            public a da(String str) {
                this.aHs = str;
                return this;
            }

            public a gH(int i) {
                this.aHI = i;
                return this;
            }

            public a m(Map<String, String> map) {
                if (map == null) {
                    map = new HashMap<>();
                }
                this.aHU = map;
                return this;
            }

            public a I(String str, String str2) {
                this.aHU.put(str, str2);
                return this;
            }

            public b Ii() {
                return new b(this);
            }
        }
    }

    public static class c {
        private final byte[] aHZ;
        private final byte[] aIa;
        private final long aIb;
        private final Throwable aIc;
        private final int aaC;

        public int Ik() {
            return this.aaC;
        }

        public byte[] Im() {
            return this.aIa;
        }

        public long In() {
            return this.aIb;
        }

        private c(a aVar) {
            this.aaC = aVar.aaC;
            this.aHZ = aVar.aHZ;
            this.aIa = aVar.aIa;
            this.aIb = aVar.aIb;
            this.aIc = aVar.aIc;
        }

        public int Ij() throws Throwable {
            Throwable th = this.aIc;
            if (th == null) {
                return this.aaC;
            }
            throw th;
        }

        public byte[] Il() throws Throwable {
            Throwable th = this.aIc;
            if (th == null) {
                return this.aHZ;
            }
            throw th;
        }

        public static a Io() {
            return new a();
        }

        public static class a {
            /* access modifiers changed from: private */
            public byte[] aHZ;
            /* access modifiers changed from: private */
            public byte[] aIa;
            /* access modifiers changed from: private */
            public long aIb;
            /* access modifiers changed from: private */
            public Throwable aIc;
            /* access modifiers changed from: private */
            public int aaC;

            public a L(byte[] bArr) {
                this.aHZ = bArr;
                return this;
            }

            public a M(byte[] bArr) {
                this.aIa = bArr;
                return this;
            }

            public a bR(long j) {
                this.aIb = j;
                return this;
            }

            public a gI(int i) {
                this.aaC = i;
                return this;
            }

            public a o(Throwable th) {
                this.aIc = th;
                return this;
            }

            public c Ip() {
                return new c(this);
            }
        }
    }
}
