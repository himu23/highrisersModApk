package com.applovin.impl.sdk.network;

import androidx.core.util.Consumer;
import com.applovin.impl.sdk.n;
import com.applovin.impl.sdk.network.e;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.sdk.utils.i;
import com.applovin.impl.sdk.utils.y;
import com.applovin.impl.sdk.utils.z;
import com.applovin.impl.sdk.x;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import org.xml.sax.SAXException;

public class b {
    private static final List<String> aHn = Arrays.asList(new String[]{"5.0/i", "4.0/ad", "1.0/mediate"});
    private final e aHo;
    /* access modifiers changed from: private */
    public c aHp;
    /* access modifiers changed from: private */
    public final x logger;
    /* access modifiers changed from: private */
    public final n sdk;

    public static class a {
        private long aHq;
        private long akZ;

        /* access modifiers changed from: private */
        public void bP(long j) {
            this.akZ = j;
        }

        /* access modifiers changed from: private */
        public void bQ(long j) {
            this.aHq = j;
        }

        public long HL() {
            return this.aHq;
        }

        public long getLatencyMillis() {
            return this.akZ;
        }
    }

    public interface d<T> {
        void a(int i, String str, T t);

        void d(T t, int i);
    }

    public c HK() {
        return this.aHp;
    }

    public b(n nVar) {
        this.sdk = nVar;
        this.logger = nVar.BN();
        e eVar = new e(nVar);
        this.aHo = eVar;
        eVar.start();
    }

    /* JADX WARNING: Removed duplicated region for block: B:81:0x0246 A[Catch:{ all -> 0x01f3, all -> 0x0294 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> void a(com.applovin.impl.sdk.network.c<T> r24, com.applovin.impl.sdk.network.b.a r25, com.applovin.impl.sdk.network.b.d<T> r26) {
        /*
            r23 = this;
            r11 = r23
            r12 = r26
            java.lang.String r1 = "gzip:"
            java.lang.String r2 = "Failed to gzip POST body for request "
            java.lang.String r0 = "Sending "
            if (r24 == 0) goto L_0x02c8
            java.lang.String r3 = r24.zL()
            java.lang.String r13 = r24.HQ()
            if (r3 == 0) goto L_0x02c0
            if (r13 == 0) goto L_0x02b8
            if (r12 == 0) goto L_0x02b0
            java.lang.String r4 = r3.toLowerCase()
            java.lang.String r5 = "http"
            boolean r4 = r4.startsWith(r5)
            r14 = 0
            java.lang.String r5 = "ConnectionManager"
            if (r4 != 0) goto L_0x0045
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Requested postback submission to non HTTP endpoint "
            r0.<init>(r1)
            r0.append(r3)
            java.lang.String r1 = "; skipping..."
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.applovin.impl.sdk.x.H(r5, r0)
            r1 = -900(0xfffffffffffffc7c, float:NaN)
            r12.a(r1, r0, r14)
            return
        L_0x0045:
            com.applovin.impl.sdk.n r4 = r11.sdk
            com.applovin.impl.sdk.c.b<java.lang.Boolean> r6 = com.applovin.impl.sdk.c.b.aNN
            java.lang.Object r4 = r4.a(r6)
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            if (r4 == 0) goto L_0x0079
            java.lang.String r4 = "https://"
            boolean r6 = r3.contains(r4)
            if (r6 != 0) goto L_0x0079
            com.applovin.impl.sdk.n r6 = r11.sdk
            r6.BN()
            boolean r6 = com.applovin.impl.sdk.x.Fn()
            if (r6 == 0) goto L_0x0073
            com.applovin.impl.sdk.n r6 = r11.sdk
            com.applovin.impl.sdk.x r6 = r6.BN()
            java.lang.String r7 = "Plaintext HTTP operation requested; upgrading to HTTPS due to universal SSL setting..."
            r6.h(r5, r7)
        L_0x0073:
            java.lang.String r6 = "http://"
            java.lang.String r3 = r3.replace(r6, r4)
        L_0x0079:
            java.util.HashMap r4 = new java.util.HashMap
            r6 = 2
            r4.<init>(r6)
            boolean r7 = r24.Ic()
            com.applovin.impl.sdk.n r6 = r11.sdk
            com.applovin.impl.sdk.c.b<java.lang.Boolean> r8 = com.applovin.impl.sdk.c.b.aPP
            java.lang.Object r6 = r6.a(r8)
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            if (r6 == 0) goto L_0x00a6
            com.applovin.impl.sdk.n r6 = r11.sdk
            com.applovin.impl.sdk.c.b<java.lang.Integer> r8 = com.applovin.impl.sdk.c.b.aPM
            java.lang.Object r6 = r6.a(r8)
            java.lang.Integer r6 = (java.lang.Integer) r6
            int r6 = r6.intValue()
            com.applovin.impl.sdk.utils.p$a r6 = com.applovin.impl.sdk.utils.p.a.gW(r6)
            goto L_0x00aa
        L_0x00a6:
            com.applovin.impl.sdk.utils.p$a r6 = r24.Id()
        L_0x00aa:
            com.applovin.impl.sdk.n r8 = r11.sdk
            long r8 = com.applovin.impl.sdk.utils.u.N((com.applovin.impl.sdk.n) r8)
            java.util.Map r10 = r24.HR()
            if (r10 == 0) goto L_0x00c0
            java.util.Map r10 = r24.HR()
            boolean r10 = r10.isEmpty()
            if (r10 == 0) goto L_0x00c6
        L_0x00c0:
            int r10 = r24.HW()
            if (r10 <= 0) goto L_0x0126
        L_0x00c6:
            java.util.Map r10 = r24.HR()
            com.applovin.impl.sdk.n r15 = r11.sdk
            com.applovin.impl.sdk.c.b<java.lang.Boolean> r14 = com.applovin.impl.sdk.c.b.aOb
            java.lang.Object r14 = r15.a(r14)
            java.lang.Boolean r14 = (java.lang.Boolean) r14
            if (r10 == 0) goto L_0x00e9
            int r15 = r24.HW()
            if (r15 <= 0) goto L_0x00e9
            int r15 = r24.HW()
            java.lang.String r15 = java.lang.String.valueOf(r15)
            java.lang.String r12 = "current_retry_attempt"
            r10.put(r12, r15)
        L_0x00e9:
            if (r7 == 0) goto L_0x011e
            boolean r12 = r14.booleanValue()
            java.lang.String r10 = com.applovin.impl.sdk.utils.u.b((java.util.Map<java.lang.String, java.lang.String>) r10, (boolean) r12)
            com.applovin.impl.sdk.n r12 = r11.sdk
            java.lang.String r19 = r12.getSdkKey()
            com.applovin.impl.sdk.n r12 = r11.sdk
            r15 = r10
            r16 = r8
            r18 = r6
            r20 = r12
            java.lang.String r12 = com.applovin.impl.sdk.utils.p.a((java.lang.String) r15, (long) r16, (com.applovin.impl.sdk.utils.p.a) r18, (java.lang.String) r19, (com.applovin.impl.sdk.n) r20)
            boolean r14 = com.applovin.impl.sdk.utils.StringUtils.isValidString(r10)
            if (r14 == 0) goto L_0x0117
            boolean r14 = android.text.TextUtils.isEmpty(r12)
            if (r14 == 0) goto L_0x0117
            java.lang.String r14 = "query"
            r4.put(r14, r10)
        L_0x0117:
            java.lang.String r10 = "p"
            java.lang.String r3 = com.applovin.impl.sdk.utils.StringUtils.appendQueryParameter(r3, r10, r12)
            goto L_0x0126
        L_0x011e:
            boolean r12 = r14.booleanValue()
            java.lang.String r3 = com.applovin.impl.sdk.utils.StringUtils.appendQueryParameters(r3, r10, r12)
        L_0x0126:
            r12 = r3
            long r21 = android.os.SystemClock.elapsedRealtime()
            java.lang.String r3 = com.applovin.impl.sdk.utils.StringUtils.getHostAndPath(r12)     // Catch:{ all -> 0x0294 }
            java.util.List<java.lang.String> r10 = aHn     // Catch:{ all -> 0x0294 }
            java.lang.Boolean r3 = com.applovin.impl.sdk.utils.StringUtils.endsWith(r3, r10)     // Catch:{ all -> 0x0294 }
            boolean r10 = com.applovin.impl.sdk.x.Fn()     // Catch:{ all -> 0x0294 }
            if (r10 == 0) goto L_0x0171
            com.applovin.impl.sdk.x r10 = r11.logger     // Catch:{ all -> 0x0294 }
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ all -> 0x0294 }
            r14.<init>(r0)     // Catch:{ all -> 0x0294 }
            r14.append(r13)     // Catch:{ all -> 0x0294 }
            java.lang.String r0 = " request to id=#"
            r14.append(r0)     // Catch:{ all -> 0x0294 }
            int r0 = r12.hashCode()     // Catch:{ all -> 0x0294 }
            r14.append(r0)     // Catch:{ all -> 0x0294 }
            java.lang.String r0 = " \""
            r14.append(r0)     // Catch:{ all -> 0x0294 }
            boolean r0 = r3.booleanValue()     // Catch:{ all -> 0x0294 }
            if (r0 == 0) goto L_0x015e
            r0 = r12
            goto L_0x0162
        L_0x015e:
            java.lang.String r0 = com.applovin.impl.sdk.utils.StringUtils.getHostAndPath(r12)     // Catch:{ all -> 0x0294 }
        L_0x0162:
            r14.append(r0)     // Catch:{ all -> 0x0294 }
            java.lang.String r0 = "\"..."
            r14.append(r0)     // Catch:{ all -> 0x0294 }
            java.lang.String r0 = r14.toString()     // Catch:{ all -> 0x0294 }
            r10.g(r5, r0)     // Catch:{ all -> 0x0294 }
        L_0x0171:
            com.applovin.impl.sdk.network.e$b$a r0 = new com.applovin.impl.sdk.network.e$b$a     // Catch:{ all -> 0x0294 }
            r0.<init>()     // Catch:{ all -> 0x0294 }
            com.applovin.impl.sdk.network.e$b$a r0 = r0.cZ(r12)     // Catch:{ all -> 0x0294 }
            com.applovin.impl.sdk.network.e$b$a r0 = r0.da(r13)     // Catch:{ all -> 0x0294 }
            java.util.Map r3 = r24.HS()     // Catch:{ all -> 0x0294 }
            com.applovin.impl.sdk.network.e$b$a r0 = r0.m(r3)     // Catch:{ all -> 0x0294 }
            int r3 = r24.HX()     // Catch:{ all -> 0x0294 }
            com.applovin.impl.sdk.network.e$b$a r14 = r0.gH(r3)     // Catch:{ all -> 0x0294 }
            org.json.JSONObject r0 = r24.vS()     // Catch:{ all -> 0x0294 }
            if (r0 == 0) goto L_0x0249
            if (r7 == 0) goto L_0x01c0
            org.json.JSONObject r0 = r24.vS()     // Catch:{ all -> 0x0294 }
            java.lang.String r15 = r0.toString()     // Catch:{ all -> 0x0294 }
            com.applovin.impl.sdk.n r0 = r11.sdk     // Catch:{ all -> 0x0294 }
            java.lang.String r19 = r0.getSdkKey()     // Catch:{ all -> 0x0294 }
            com.applovin.impl.sdk.n r0 = r11.sdk     // Catch:{ all -> 0x0294 }
            r16 = r8
            r18 = r6
            r20 = r0
            byte[] r0 = com.applovin.impl.sdk.utils.p.b(r15, r16, r18, r19, r20)     // Catch:{ all -> 0x0294 }
            if (r0 != 0) goto L_0x01ce
            java.lang.String r3 = "body"
            org.json.JSONObject r8 = r24.vS()     // Catch:{ all -> 0x0294 }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x0294 }
            r4.put(r3, r8)     // Catch:{ all -> 0x0294 }
            goto L_0x01ce
        L_0x01c0:
            org.json.JSONObject r0 = r24.vS()     // Catch:{ all -> 0x0294 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0294 }
            java.lang.String r3 = "UTF-8"
            byte[] r0 = r0.getBytes(r3)     // Catch:{ all -> 0x0294 }
        L_0x01ce:
            r3 = r0
            if (r7 == 0) goto L_0x01d5
            com.applovin.impl.sdk.utils.p$a r0 = com.applovin.impl.sdk.utils.p.a.V2     // Catch:{ all -> 0x0294 }
            if (r6 == r0) goto L_0x0229
        L_0x01d5:
            boolean r0 = r24.If()     // Catch:{ all -> 0x0294 }
            if (r0 == 0) goto L_0x0229
            if (r3 == 0) goto L_0x0229
            int r0 = r3.length     // Catch:{ all -> 0x0294 }
            com.applovin.impl.sdk.n r6 = r11.sdk     // Catch:{ all -> 0x0294 }
            com.applovin.impl.sdk.c.b<java.lang.Integer> r8 = com.applovin.impl.sdk.c.b.aQi     // Catch:{ all -> 0x0294 }
            java.lang.Object r6 = r6.a(r8)     // Catch:{ all -> 0x0294 }
            java.lang.Integer r6 = (java.lang.Integer) r6     // Catch:{ all -> 0x0294 }
            int r6 = r6.intValue()     // Catch:{ all -> 0x0294 }
            if (r0 <= r6) goto L_0x0229
            byte[] r0 = com.applovin.impl.sdk.utils.u.R(r3)     // Catch:{ all -> 0x01f3 }
            goto L_0x022a
        L_0x01f3:
            r0 = move-exception
            r6 = r0
            boolean r0 = com.applovin.impl.sdk.x.Fn()     // Catch:{ all -> 0x0294 }
            if (r0 == 0) goto L_0x0210
            com.applovin.impl.sdk.x r0 = r11.logger     // Catch:{ all -> 0x0294 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0294 }
            r8.<init>(r2)     // Catch:{ all -> 0x0294 }
            java.lang.String r2 = r11.cT(r12)     // Catch:{ all -> 0x0294 }
            r8.append(r2)     // Catch:{ all -> 0x0294 }
            java.lang.String r2 = r8.toString()     // Catch:{ all -> 0x0294 }
            r0.c(r5, r2, r6)     // Catch:{ all -> 0x0294 }
        L_0x0210:
            com.applovin.impl.sdk.n r0 = r11.sdk     // Catch:{ all -> 0x0294 }
            com.applovin.impl.sdk.r r0 = r0.Cs()     // Catch:{ all -> 0x0294 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0294 }
            r2.<init>(r1)     // Catch:{ all -> 0x0294 }
            java.lang.String r1 = com.applovin.impl.sdk.utils.StringUtils.getHost(r12)     // Catch:{ all -> 0x0294 }
            r2.append(r1)     // Catch:{ all -> 0x0294 }
            java.lang.String r1 = r2.toString()     // Catch:{ all -> 0x0294 }
            r0.d(r5, r1, r6)     // Catch:{ all -> 0x0294 }
        L_0x0229:
            r0 = 0
        L_0x022a:
            java.lang.String r1 = "Content-Type"
            java.lang.String r2 = "application/json; charset=utf-8"
            r14.I(r1, r2)     // Catch:{ all -> 0x0294 }
            boolean r1 = r24.If()     // Catch:{ all -> 0x0294 }
            if (r1 == 0) goto L_0x0244
            if (r0 == 0) goto L_0x0244
            java.lang.String r1 = "Content-Encoding"
            java.lang.String r2 = "gzip"
            r14.I(r1, r2)     // Catch:{ all -> 0x0294 }
            r14.K(r0)     // Catch:{ all -> 0x0294 }
            goto L_0x0249
        L_0x0244:
            if (r3 == 0) goto L_0x0249
            r14.K(r3)     // Catch:{ all -> 0x0294 }
        L_0x0249:
            boolean r0 = r4.isEmpty()     // Catch:{ all -> 0x0294 }
            if (r0 != 0) goto L_0x0263
            java.lang.String r0 = "request"
            java.lang.String r1 = com.applovin.impl.sdk.utils.StringUtils.getHostAndPath(r12)     // Catch:{ all -> 0x0294 }
            r4.put(r0, r1)     // Catch:{ all -> 0x0294 }
            com.applovin.impl.sdk.n r0 = r11.sdk     // Catch:{ all -> 0x0294 }
            com.applovin.impl.sdk.EventServiceImpl r0 = r0.BF()     // Catch:{ all -> 0x0294 }
            java.lang.String r1 = "ref"
            r0.trackEvent(r1, r4)     // Catch:{ all -> 0x0294 }
        L_0x0263:
            com.applovin.impl.sdk.network.e r0 = r11.aHo     // Catch:{ all -> 0x0294 }
            com.applovin.impl.sdk.network.b$b r15 = new com.applovin.impl.sdk.network.b$b     // Catch:{ all -> 0x0294 }
            java.lang.Object r6 = r24.HU()     // Catch:{ all -> 0x0294 }
            r10 = 0
            r1 = r15
            r2 = r23
            r3 = r12
            r4 = r24
            r5 = r13
            r8 = r25
            r9 = r26
            r1.<init>(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x0294 }
            com.applovin.impl.sdk.network.e$b$a r1 = r14.a((androidx.core.util.Consumer<com.applovin.impl.sdk.network.e.c>) r15)     // Catch:{ all -> 0x0294 }
            com.applovin.impl.sdk.n r2 = r11.sdk     // Catch:{ all -> 0x0294 }
            com.applovin.impl.sdk.e.q r2 = r2.BO()     // Catch:{ all -> 0x0294 }
            java.util.concurrent.Executor r2 = r2.KI()     // Catch:{ all -> 0x0294 }
            com.applovin.impl.sdk.network.e$b$a r1 = r1.a((java.util.concurrent.Executor) r2)     // Catch:{ all -> 0x0294 }
            com.applovin.impl.sdk.network.e$b r1 = r1.Ii()     // Catch:{ all -> 0x0294 }
            r0.a(r1)     // Catch:{ all -> 0x0294 }
            goto L_0x02af
        L_0x0294:
            r0 = move-exception
            r4 = 0
            long r1 = android.os.SystemClock.elapsedRealtime()
            long r5 = r1 - r21
            r1 = r23
            r2 = r13
            r3 = r12
            r7 = r0
            r1.a((java.lang.String) r2, (java.lang.String) r3, (int) r4, (long) r5, (java.lang.Throwable) r7)
            r1 = 0
            java.lang.String r0 = r0.getMessage()
            r2 = r26
            r3 = 0
            r2.a(r1, r0, r3)
        L_0x02af:
            return
        L_0x02b0:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "No callback specified"
            r0.<init>(r1)
            throw r0
        L_0x02b8:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "No method specified"
            r0.<init>(r1)
            throw r0
        L_0x02c0:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "No endpoint specified"
            r0.<init>(r1)
            throw r0
        L_0x02c8:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "No request specified"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.network.b.a(com.applovin.impl.sdk.network.c, com.applovin.impl.sdk.network.b$a, com.applovin.impl.sdk.network.b$d):void");
    }

    /* renamed from: com.applovin.impl.sdk.network.b$b  reason: collision with other inner class name */
    private class C0083b<T> implements Consumer<e.c> {
        private final c<T> aHl;
        private final String aHr;
        private final String aHs;
        private final T aHt;
        private final boolean aHu;
        private final a aHv;
        private final d<T> aHw;

        private C0083b(String str, c<T> cVar, String str2, T t, boolean z, a aVar, d<T> dVar) {
            this.aHr = str;
            this.aHl = cVar;
            this.aHs = str2;
            this.aHt = t;
            this.aHu = z;
            this.aHv = aVar;
            this.aHw = dVar;
        }

        /* JADX WARNING: Removed duplicated region for block: B:61:0x01bc  */
        /* JADX WARNING: Removed duplicated region for block: B:63:0x01c2  */
        /* JADX WARNING: Removed duplicated region for block: B:68:0x01d4 A[Catch:{ all -> 0x01f5 }] */
        /* JADX WARNING: Removed duplicated region for block: B:79:0x0214  */
        /* JADX WARNING: Removed duplicated region for block: B:80:0x022a  */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void accept(com.applovin.impl.sdk.network.e.c r17) {
            /*
                r16 = this;
                r1 = r16
                java.lang.String r2 = "failedToParseResponse:"
                java.lang.String r3 = "Unable to parse response from "
                long r11 = r17.In()
                r4 = 0
                int r14 = r17.Ij()     // Catch:{ MalformedURLException -> 0x020c, all -> 0x01a7 }
                if (r14 <= 0) goto L_0x018d
                r0 = 200(0xc8, float:2.8E-43)
                if (r14 < r0) goto L_0x0185
                r0 = 400(0x190, float:5.6E-43)
                if (r14 >= r0) goto L_0x0185
                com.applovin.impl.sdk.network.b$a r0 = r1.aHv     // Catch:{ MalformedURLException -> 0x01a4, all -> 0x01a1 }
                if (r0 == 0) goto L_0x0020
                r0.bP(r11)     // Catch:{ MalformedURLException -> 0x01a4, all -> 0x01a1 }
            L_0x0020:
                com.applovin.impl.sdk.network.b r4 = com.applovin.impl.sdk.network.b.this     // Catch:{ MalformedURLException -> 0x01a4, all -> 0x01a1 }
                java.lang.String r5 = r1.aHs     // Catch:{ MalformedURLException -> 0x01a4, all -> 0x01a1 }
                java.lang.String r6 = r1.aHr     // Catch:{ MalformedURLException -> 0x01a4, all -> 0x01a1 }
                r7 = r14
                r8 = r11
                r4.a(r5, r6, r7, r8)     // Catch:{ MalformedURLException -> 0x01a4, all -> 0x01a1 }
                byte[] r0 = r17.Il()     // Catch:{ MalformedURLException -> 0x01a4, all -> 0x01a1 }
                android.content.Context r4 = com.applovin.impl.sdk.n.getApplicationContext()     // Catch:{ MalformedURLException -> 0x01a4, all -> 0x01a1 }
                boolean r4 = com.applovin.impl.sdk.utils.u.ak(r4)     // Catch:{ MalformedURLException -> 0x01a4, all -> 0x01a1 }
                java.lang.String r5 = "UTF-8"
                if (r4 == 0) goto L_0x007b
                boolean r4 = r1.aHu     // Catch:{ MalformedURLException -> 0x01a4, all -> 0x01a1 }
                if (r4 == 0) goto L_0x0047
                com.applovin.impl.sdk.utils.p$a r4 = com.applovin.impl.sdk.utils.p.N(r0)     // Catch:{ MalformedURLException -> 0x01a4, all -> 0x01a1 }
                com.applovin.impl.sdk.utils.p$a r6 = com.applovin.impl.sdk.utils.p.a.V2     // Catch:{ MalformedURLException -> 0x01a4, all -> 0x01a1 }
                if (r4 == r6) goto L_0x007b
            L_0x0047:
                java.lang.String r4 = ""
                if (r0 == 0) goto L_0x0059
                java.lang.String r6 = new java.lang.String     // Catch:{ MalformedURLException -> 0x01a4, all -> 0x01a1 }
                byte[] r7 = r17.Il()     // Catch:{ MalformedURLException -> 0x01a4, all -> 0x01a1 }
                java.nio.charset.Charset r8 = java.nio.charset.Charset.forName(r5)     // Catch:{ MalformedURLException -> 0x01a4, all -> 0x01a1 }
                r6.<init>(r7, r8)     // Catch:{ MalformedURLException -> 0x01a4, all -> 0x01a1 }
                goto L_0x005a
            L_0x0059:
                r6 = r4
            L_0x005a:
                com.applovin.impl.sdk.network.c<T> r7 = r1.aHl     // Catch:{ MalformedURLException -> 0x01a4, all -> 0x01a1 }
                org.json.JSONObject r7 = r7.vS()     // Catch:{ MalformedURLException -> 0x01a4, all -> 0x01a1 }
                if (r7 == 0) goto L_0x006c
                com.applovin.impl.sdk.network.c<T> r4 = r1.aHl     // Catch:{ MalformedURLException -> 0x01a4, all -> 0x01a1 }
                org.json.JSONObject r4 = r4.vS()     // Catch:{ MalformedURLException -> 0x01a4, all -> 0x01a1 }
                java.lang.String r4 = r4.toString()     // Catch:{ MalformedURLException -> 0x01a4, all -> 0x01a1 }
            L_0x006c:
                com.applovin.impl.sdk.network.b r7 = com.applovin.impl.sdk.network.b.this     // Catch:{ MalformedURLException -> 0x01a4, all -> 0x01a1 }
                com.applovin.impl.sdk.n r7 = r7.sdk     // Catch:{ MalformedURLException -> 0x01a4, all -> 0x01a1 }
                com.applovin.impl.sdk.k r7 = r7.Ch()     // Catch:{ MalformedURLException -> 0x01a4, all -> 0x01a1 }
                java.lang.String r8 = r1.aHr     // Catch:{ MalformedURLException -> 0x01a4, all -> 0x01a1 }
                r7.b(r6, r8, r4)     // Catch:{ MalformedURLException -> 0x01a4, all -> 0x01a1 }
            L_0x007b:
                if (r0 == 0) goto L_0x017c
                java.lang.String r10 = new java.lang.String     // Catch:{ MalformedURLException -> 0x01a4, all -> 0x01a1 }
                byte[] r4 = r17.Il()     // Catch:{ MalformedURLException -> 0x01a4, all -> 0x01a1 }
                java.nio.charset.Charset r5 = java.nio.charset.Charset.forName(r5)     // Catch:{ MalformedURLException -> 0x01a4, all -> 0x01a1 }
                r10.<init>(r4, r5)     // Catch:{ MalformedURLException -> 0x01a4, all -> 0x01a1 }
                com.applovin.impl.sdk.network.b$a r4 = r1.aHv     // Catch:{ MalformedURLException -> 0x01a4, all -> 0x01a1 }
                if (r4 == 0) goto L_0x00b0
                int r5 = r0.length     // Catch:{ MalformedURLException -> 0x01a4, all -> 0x01a1 }
                long r5 = (long) r5     // Catch:{ MalformedURLException -> 0x01a4, all -> 0x01a1 }
                r4.bQ(r5)     // Catch:{ MalformedURLException -> 0x01a4, all -> 0x01a1 }
                com.applovin.impl.sdk.network.c<T> r4 = r1.aHl     // Catch:{ MalformedURLException -> 0x01a4, all -> 0x01a1 }
                boolean r4 = r4.Ie()     // Catch:{ MalformedURLException -> 0x01a4, all -> 0x01a1 }
                if (r4 == 0) goto L_0x00b0
                com.applovin.impl.sdk.network.b r15 = com.applovin.impl.sdk.network.b.this     // Catch:{ MalformedURLException -> 0x01a4, all -> 0x01a1 }
                com.applovin.impl.sdk.network.b$c r8 = new com.applovin.impl.sdk.network.b$c     // Catch:{ MalformedURLException -> 0x01a4, all -> 0x01a1 }
                com.applovin.impl.sdk.network.c<T> r4 = r1.aHl     // Catch:{ MalformedURLException -> 0x01a4, all -> 0x01a1 }
                java.lang.String r5 = r4.zL()     // Catch:{ MalformedURLException -> 0x01a4, all -> 0x01a1 }
                int r4 = r0.length     // Catch:{ MalformedURLException -> 0x01a4, all -> 0x01a1 }
                long r6 = (long) r4     // Catch:{ MalformedURLException -> 0x01a4, all -> 0x01a1 }
                r4 = r8
                r13 = r8
                r8 = r11
                r4.<init>(r5, r6, r8)     // Catch:{ MalformedURLException -> 0x01a4, all -> 0x01a1 }
                com.applovin.impl.sdk.network.b.c unused = r15.aHp = r13     // Catch:{ MalformedURLException -> 0x01a4, all -> 0x01a1 }
            L_0x00b0:
                boolean r4 = r1.aHu     // Catch:{ MalformedURLException -> 0x01a4, all -> 0x01a1 }
                if (r4 == 0) goto L_0x00f0
                com.applovin.impl.sdk.network.b r4 = com.applovin.impl.sdk.network.b.this     // Catch:{ MalformedURLException -> 0x01a4, all -> 0x01a1 }
                com.applovin.impl.sdk.n r4 = r4.sdk     // Catch:{ MalformedURLException -> 0x01a4, all -> 0x01a1 }
                java.lang.String r4 = r4.getSdkKey()     // Catch:{ MalformedURLException -> 0x01a4, all -> 0x01a1 }
                com.applovin.impl.sdk.network.b r5 = com.applovin.impl.sdk.network.b.this     // Catch:{ MalformedURLException -> 0x01a4, all -> 0x01a1 }
                com.applovin.impl.sdk.n r5 = r5.sdk     // Catch:{ MalformedURLException -> 0x01a4, all -> 0x01a1 }
                java.lang.String r0 = com.applovin.impl.sdk.utils.p.a((byte[]) r0, (java.lang.String) r4, (com.applovin.impl.sdk.n) r5)     // Catch:{ MalformedURLException -> 0x01a4, all -> 0x01a1 }
                if (r0 != 0) goto L_0x00ef
                java.util.HashMap r4 = new java.util.HashMap     // Catch:{ MalformedURLException -> 0x01a4, all -> 0x01a1 }
                r5 = 2
                r4.<init>(r5)     // Catch:{ MalformedURLException -> 0x01a4, all -> 0x01a1 }
                java.lang.String r5 = "request"
                java.lang.String r6 = r1.aHr     // Catch:{ MalformedURLException -> 0x01a4, all -> 0x01a1 }
                java.lang.String r6 = com.applovin.impl.sdk.utils.StringUtils.getHostAndPath(r6)     // Catch:{ MalformedURLException -> 0x01a4, all -> 0x01a1 }
                r4.put(r5, r6)     // Catch:{ MalformedURLException -> 0x01a4, all -> 0x01a1 }
                java.lang.String r5 = "response"
                r4.put(r5, r10)     // Catch:{ MalformedURLException -> 0x01a4, all -> 0x01a1 }
                com.applovin.impl.sdk.network.b r5 = com.applovin.impl.sdk.network.b.this     // Catch:{ MalformedURLException -> 0x01a4, all -> 0x01a1 }
                com.applovin.impl.sdk.n r5 = r5.sdk     // Catch:{ MalformedURLException -> 0x01a4, all -> 0x01a1 }
                com.applovin.impl.sdk.EventServiceImpl r5 = r5.BF()     // Catch:{ MalformedURLException -> 0x01a4, all -> 0x01a1 }
                java.lang.String r6 = "rdf"
                r5.trackEvent(r6, r4)     // Catch:{ MalformedURLException -> 0x01a4, all -> 0x01a1 }
            L_0x00ef:
                r10 = r0
            L_0x00f0:
                com.applovin.impl.sdk.network.b r0 = com.applovin.impl.sdk.network.b.this     // Catch:{ all -> 0x00ff }
                T r4 = r1.aHt     // Catch:{ all -> 0x00ff }
                java.lang.Object r0 = r0.c(r10, r4)     // Catch:{ all -> 0x00ff }
                com.applovin.impl.sdk.network.b$d<T> r4 = r1.aHw     // Catch:{ all -> 0x00ff }
                r4.d(r0, r14)     // Catch:{ all -> 0x00ff }
                goto L_0x023b
            L_0x00ff:
                r0 = move-exception
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ MalformedURLException -> 0x01a4, all -> 0x01a1 }
                r4.<init>(r3)     // Catch:{ MalformedURLException -> 0x01a4, all -> 0x01a1 }
                java.lang.String r3 = r1.aHr     // Catch:{ MalformedURLException -> 0x01a4, all -> 0x01a1 }
                java.lang.String r3 = com.applovin.impl.sdk.utils.StringUtils.getHostAndPath(r3)     // Catch:{ MalformedURLException -> 0x01a4, all -> 0x01a1 }
                r4.append(r3)     // Catch:{ MalformedURLException -> 0x01a4, all -> 0x01a1 }
                java.lang.String r3 = " because of "
                r4.append(r3)     // Catch:{ MalformedURLException -> 0x01a4, all -> 0x01a1 }
                java.lang.Class r3 = r0.getClass()     // Catch:{ MalformedURLException -> 0x01a4, all -> 0x01a1 }
                java.lang.String r3 = r3.getName()     // Catch:{ MalformedURLException -> 0x01a4, all -> 0x01a1 }
                r4.append(r3)     // Catch:{ MalformedURLException -> 0x01a4, all -> 0x01a1 }
                java.lang.String r3 = " : "
                r4.append(r3)     // Catch:{ MalformedURLException -> 0x01a4, all -> 0x01a1 }
                java.lang.String r3 = r0.getMessage()     // Catch:{ MalformedURLException -> 0x01a4, all -> 0x01a1 }
                r4.append(r3)     // Catch:{ MalformedURLException -> 0x01a4, all -> 0x01a1 }
                java.lang.String r3 = r4.toString()     // Catch:{ MalformedURLException -> 0x01a4, all -> 0x01a1 }
                com.applovin.impl.sdk.network.b r4 = com.applovin.impl.sdk.network.b.this     // Catch:{ MalformedURLException -> 0x01a4, all -> 0x01a1 }
                com.applovin.impl.sdk.x unused = r4.logger     // Catch:{ MalformedURLException -> 0x01a4, all -> 0x01a1 }
                boolean r4 = com.applovin.impl.sdk.x.Fn()     // Catch:{ MalformedURLException -> 0x01a4, all -> 0x01a1 }
                java.lang.String r5 = "ConnectionManager"
                if (r4 == 0) goto L_0x0144
                com.applovin.impl.sdk.network.b r4 = com.applovin.impl.sdk.network.b.this     // Catch:{ MalformedURLException -> 0x01a4, all -> 0x01a1 }
                com.applovin.impl.sdk.x r4 = r4.logger     // Catch:{ MalformedURLException -> 0x01a4, all -> 0x01a1 }
                r4.c(r5, r3, r0)     // Catch:{ MalformedURLException -> 0x01a4, all -> 0x01a1 }
            L_0x0144:
                com.applovin.impl.sdk.network.b r4 = com.applovin.impl.sdk.network.b.this     // Catch:{ MalformedURLException -> 0x01a4, all -> 0x01a1 }
                com.applovin.impl.sdk.n r4 = r4.sdk     // Catch:{ MalformedURLException -> 0x01a4, all -> 0x01a1 }
                com.applovin.impl.sdk.d.g r4 = r4.BR()     // Catch:{ MalformedURLException -> 0x01a4, all -> 0x01a1 }
                com.applovin.impl.sdk.d.f r6 = com.applovin.impl.sdk.d.f.aTc     // Catch:{ MalformedURLException -> 0x01a4, all -> 0x01a1 }
                r4.a(r6)     // Catch:{ MalformedURLException -> 0x01a4, all -> 0x01a1 }
                com.applovin.impl.sdk.network.b r4 = com.applovin.impl.sdk.network.b.this     // Catch:{ MalformedURLException -> 0x01a4, all -> 0x01a1 }
                com.applovin.impl.sdk.n r4 = r4.sdk     // Catch:{ MalformedURLException -> 0x01a4, all -> 0x01a1 }
                com.applovin.impl.sdk.r r4 = r4.Cs()     // Catch:{ MalformedURLException -> 0x01a4, all -> 0x01a1 }
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ MalformedURLException -> 0x01a4, all -> 0x01a1 }
                r6.<init>(r2)     // Catch:{ MalformedURLException -> 0x01a4, all -> 0x01a1 }
                java.lang.String r2 = r1.aHr     // Catch:{ MalformedURLException -> 0x01a4, all -> 0x01a1 }
                java.lang.String r2 = com.applovin.impl.sdk.utils.StringUtils.getHost(r2)     // Catch:{ MalformedURLException -> 0x01a4, all -> 0x01a1 }
                r6.append(r2)     // Catch:{ MalformedURLException -> 0x01a4, all -> 0x01a1 }
                java.lang.String r2 = r6.toString()     // Catch:{ MalformedURLException -> 0x01a4, all -> 0x01a1 }
                r4.d(r5, r2, r0)     // Catch:{ MalformedURLException -> 0x01a4, all -> 0x01a1 }
                com.applovin.impl.sdk.network.b$d<T> r0 = r1.aHw     // Catch:{ MalformedURLException -> 0x01a4, all -> 0x01a1 }
                r2 = -800(0xfffffffffffffce0, float:NaN)
                r4 = 0
                r0.a(r2, r3, r4)     // Catch:{ MalformedURLException -> 0x01a4, all -> 0x01a1 }
                goto L_0x023b
            L_0x017c:
                com.applovin.impl.sdk.network.b$d<T> r0 = r1.aHw     // Catch:{ MalformedURLException -> 0x01a4, all -> 0x01a1 }
                T r2 = r1.aHt     // Catch:{ MalformedURLException -> 0x01a4, all -> 0x01a1 }
                r0.d(r2, r14)     // Catch:{ MalformedURLException -> 0x01a4, all -> 0x01a1 }
                goto L_0x023b
            L_0x0185:
                com.applovin.impl.sdk.network.b$d<T> r0 = r1.aHw     // Catch:{ MalformedURLException -> 0x01a4, all -> 0x01a1 }
                r2 = 0
                r0.a(r14, r2, r2)     // Catch:{ MalformedURLException -> 0x01a4, all -> 0x01a1 }
                goto L_0x023b
            L_0x018d:
                com.applovin.impl.sdk.network.b r4 = com.applovin.impl.sdk.network.b.this     // Catch:{ MalformedURLException -> 0x01a4, all -> 0x01a1 }
                java.lang.String r5 = r1.aHs     // Catch:{ MalformedURLException -> 0x01a4, all -> 0x01a1 }
                java.lang.String r6 = r1.aHr     // Catch:{ MalformedURLException -> 0x01a4, all -> 0x01a1 }
                r10 = 0
                r7 = r14
                r8 = r11
                r4.a((java.lang.String) r5, (java.lang.String) r6, (int) r7, (long) r8, (java.lang.Throwable) r10)     // Catch:{ MalformedURLException -> 0x01a4, all -> 0x01a1 }
                com.applovin.impl.sdk.network.b$d<T> r0 = r1.aHw     // Catch:{ MalformedURLException -> 0x01a4, all -> 0x01a1 }
                r2 = 0
                r0.a(r14, r2, r2)     // Catch:{ MalformedURLException -> 0x01a4, all -> 0x01a1 }
                goto L_0x023b
            L_0x01a1:
                r0 = move-exception
                r4 = r14
                goto L_0x01a8
            L_0x01a4:
                r0 = move-exception
                r7 = r14
                goto L_0x020e
            L_0x01a7:
                r0 = move-exception
            L_0x01a8:
                com.applovin.impl.sdk.network.b r2 = com.applovin.impl.sdk.network.b.this
                com.applovin.impl.sdk.n r2 = r2.sdk
                com.applovin.impl.sdk.c.b<java.lang.Boolean> r3 = com.applovin.impl.sdk.c.b.aKv
                java.lang.Object r2 = r2.a(r3)
                java.lang.Boolean r2 = (java.lang.Boolean) r2
                boolean r2 = r2.booleanValue()
                if (r2 == 0) goto L_0x01c0
                int r4 = r17.Ik()
            L_0x01c0:
                if (r4 != 0) goto L_0x01c8
                com.applovin.impl.sdk.network.b r2 = com.applovin.impl.sdk.network.b.this
                int r4 = r2.n(r0)
            L_0x01c8:
                r2 = r4
                byte[] r3 = r17.Im()     // Catch:{ all -> 0x01f5 }
                java.lang.String r4 = new java.lang.String     // Catch:{ all -> 0x01f5 }
                r4.<init>(r3)     // Catch:{ all -> 0x01f5 }
                if (r3 == 0) goto L_0x01f5
                boolean r5 = r1.aHu     // Catch:{ all -> 0x01f5 }
                if (r5 == 0) goto L_0x01ec
                com.applovin.impl.sdk.network.b r4 = com.applovin.impl.sdk.network.b.this     // Catch:{ all -> 0x01f5 }
                com.applovin.impl.sdk.n r4 = r4.sdk     // Catch:{ all -> 0x01f5 }
                java.lang.String r4 = r4.getSdkKey()     // Catch:{ all -> 0x01f5 }
                com.applovin.impl.sdk.network.b r5 = com.applovin.impl.sdk.network.b.this     // Catch:{ all -> 0x01f5 }
                com.applovin.impl.sdk.n r5 = r5.sdk     // Catch:{ all -> 0x01f5 }
                java.lang.String r4 = com.applovin.impl.sdk.utils.p.a((byte[]) r3, (java.lang.String) r4, (com.applovin.impl.sdk.n) r5)     // Catch:{ all -> 0x01f5 }
            L_0x01ec:
                com.applovin.impl.sdk.network.b r3 = com.applovin.impl.sdk.network.b.this     // Catch:{ all -> 0x01f5 }
                T r5 = r1.aHt     // Catch:{ all -> 0x01f5 }
                java.lang.Object r13 = r3.c(r4, r5)     // Catch:{ all -> 0x01f5 }
                goto L_0x01f6
            L_0x01f5:
                r13 = 0
            L_0x01f6:
                com.applovin.impl.sdk.network.b r4 = com.applovin.impl.sdk.network.b.this
                java.lang.String r5 = r1.aHs
                java.lang.String r6 = r1.aHr
                r7 = r2
                r8 = r11
                r10 = r0
                r4.a((java.lang.String) r5, (java.lang.String) r6, (int) r7, (long) r8, (java.lang.Throwable) r10)
                com.applovin.impl.sdk.network.b$d<T> r3 = r1.aHw
                java.lang.String r0 = r0.getMessage()
                r3.a(r2, r0, r13)
                goto L_0x023b
            L_0x020c:
                r0 = move-exception
                r7 = 0
            L_0x020e:
                T r2 = r1.aHt
                r3 = -901(0xfffffffffffffc7b, float:NaN)
                if (r2 == 0) goto L_0x022a
                com.applovin.impl.sdk.network.b r4 = com.applovin.impl.sdk.network.b.this
                java.lang.String r5 = r1.aHs
                java.lang.String r6 = r1.aHr
                r8 = r11
                r10 = r0
                r4.a((java.lang.String) r5, (java.lang.String) r6, (int) r7, (long) r8, (java.lang.Throwable) r10)
                com.applovin.impl.sdk.network.b$d<T> r2 = r1.aHw
                java.lang.String r0 = r0.getMessage()
                r4 = 0
                r2.a(r3, r0, r4)
                goto L_0x023b
            L_0x022a:
                com.applovin.impl.sdk.network.b r4 = com.applovin.impl.sdk.network.b.this
                java.lang.String r5 = r1.aHs
                java.lang.String r6 = r1.aHr
                r8 = r11
                r4.a(r5, r6, r7, r8)
                com.applovin.impl.sdk.network.b$d<T> r0 = r1.aHw
                T r2 = r1.aHt
                r0.d(r2, r3)
            L_0x023b:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.network.b.C0083b.accept(com.applovin.impl.sdk.network.e$c):void");
        }
    }

    /* access modifiers changed from: private */
    public <T> T c(String str, T t) throws JSONException, SAXException, ClassCastException {
        if (t == null) {
            return str;
        }
        if (str != null && str.length() >= 3) {
            if (t instanceof JSONObject) {
                return new JSONObject(str);
            }
            if (t instanceof y) {
                return z.e(str, this.sdk);
            }
            if (t instanceof String) {
                return str;
            }
            if (x.Fn()) {
                x xVar = this.logger;
                xVar.i("ConnectionManager", "Failed to process response of type '" + t.getClass().getName() + "'");
            }
        }
        return t;
    }

    /* access modifiers changed from: private */
    public int n(Throwable th) {
        if (th instanceof UnknownHostException) {
            return -1009;
        }
        if (th instanceof SocketTimeoutException) {
            return -1001;
        }
        if (th instanceof IOException) {
            return -100;
        }
        return th instanceof JSONException ? -104 : -1;
    }

    /* access modifiers changed from: private */
    public void a(String str, String str2, int i, long j) {
        if (x.Fn()) {
            x xVar = this.logger;
            xVar.g("ConnectionManager", "Successful " + str + " returned " + i + " in " + (((float) j) / 1000.0f) + " s over " + i.G(this.sdk) + " to " + cT(str2));
        }
    }

    /* access modifiers changed from: private */
    public void a(String str, String str2, int i, long j, Throwable th) {
        if (x.Fn()) {
            x xVar = this.logger;
            xVar.c("ConnectionManager", "Failed " + str + " returned " + i + " in " + (((float) j) / 1000.0f) + " s over " + i.G(this.sdk) + " to " + cT(str2), th);
        }
    }

    private String cT(String str) {
        return "#" + str.hashCode() + " \"" + StringUtils.getHostAndPath(str) + "\"";
    }

    public static class c {
        private final long aHA;
        private final long aHB;
        private final long aHy = System.currentTimeMillis();
        private final String aHz;

        public long HM() {
            return this.aHy;
        }

        public String HN() {
            return this.aHz;
        }

        public long HO() {
            return this.aHA;
        }

        public long HP() {
            return this.aHB;
        }

        public c(String str, long j, long j2) {
            this.aHz = str;
            this.aHA = j;
            this.aHB = j2;
        }

        /* access modifiers changed from: protected */
        public boolean canEqual(Object obj) {
            return obj instanceof c;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            if (!cVar.canEqual(this) || HM() != cVar.HM() || HO() != cVar.HO() || HP() != cVar.HP()) {
                return false;
            }
            String HN = HN();
            String HN2 = cVar.HN();
            return HN != null ? HN.equals(HN2) : HN2 == null;
        }

        public int hashCode() {
            long HM = HM();
            long HO = HO();
            long HP = HP();
            String HN = HN();
            return ((((((((int) (HM ^ (HM >>> 32))) + 59) * 59) + ((int) (HO ^ (HO >>> 32)))) * 59) + ((int) ((HP >>> 32) ^ HP))) * 59) + (HN == null ? 43 : HN.hashCode());
        }

        public String toString() {
            return "ConnectionManager.RequestMeasurement(timestampMillis=" + HM() + ", urlHostAndPathString=" + HN() + ", responseSizeBytes=" + HO() + ", connectionTimeMillis=" + HP() + ")";
        }
    }
}
