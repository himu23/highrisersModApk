package com.applovin.impl.sdk;

import java.util.HashMap;
import java.util.Map;

public class y {
    private final Map<String, a> aFn = new HashMap(4);
    private final Object aFo = new Object();
    private final x logger;

    public static class a {
        private final String aFp;
        private final String aFq;
        private final String aFr;
        /* access modifiers changed from: private */
        public String aFs;
        /* access modifiers changed from: private */
        public String aFt;

        public String Fo() {
            return this.aFs;
        }

        public String Fp() {
            return this.aFt;
        }

        public String getNetworkName() {
            return this.aFr;
        }

        public String xs() {
            return this.aFp;
        }

        public String yA() {
            return this.aFq;
        }

        /* access modifiers changed from: protected */
        public boolean canEqual(Object obj) {
            return obj instanceof a;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (!aVar.canEqual(this)) {
                return false;
            }
            String xs = xs();
            String xs2 = aVar.xs();
            if (xs != null ? !xs.equals(xs2) : xs2 != null) {
                return false;
            }
            String yA = yA();
            String yA2 = aVar.yA();
            if (yA != null ? !yA.equals(yA2) : yA2 != null) {
                return false;
            }
            String networkName = getNetworkName();
            String networkName2 = aVar.getNetworkName();
            if (networkName != null ? !networkName.equals(networkName2) : networkName2 != null) {
                return false;
            }
            String Fo = Fo();
            String Fo2 = aVar.Fo();
            if (Fo != null ? !Fo.equals(Fo2) : Fo2 != null) {
                return false;
            }
            String Fp = Fp();
            String Fp2 = aVar.Fp();
            return Fp != null ? Fp.equals(Fp2) : Fp2 == null;
        }

        public int hashCode() {
            String xs = xs();
            int i = 43;
            int hashCode = xs == null ? 43 : xs.hashCode();
            String yA = yA();
            int hashCode2 = ((hashCode + 59) * 59) + (yA == null ? 43 : yA.hashCode());
            String networkName = getNetworkName();
            int hashCode3 = (hashCode2 * 59) + (networkName == null ? 43 : networkName.hashCode());
            String Fo = Fo();
            int hashCode4 = (hashCode3 * 59) + (Fo == null ? 43 : Fo.hashCode());
            String Fp = Fp();
            int i2 = hashCode4 * 59;
            if (Fp != null) {
                i = Fp.hashCode();
            }
            return i2 + i;
        }

        public String toString() {
            return "MediationWaterfallWinnerTracker.WinningAd(bCode=" + xs() + ", adapterName=" + yA() + ", networkName=" + getNetworkName() + ", secondWinnerAdapterName=" + Fo() + ", secondWinnerNetworkName=" + Fp() + ")";
        }

        public a(String str, String str2, String str3) {
            this.aFp = str;
            this.aFq = str2;
            this.aFr = str3;
        }
    }

    y(n nVar) {
        this.logger = nVar.BN();
    }

    public void l(com.applovin.impl.mediation.b.a aVar) {
        b(aVar, (com.applovin.impl.mediation.b.a) null);
    }

    public void b(com.applovin.impl.mediation.b.a aVar, com.applovin.impl.mediation.b.a aVar2) {
        synchronized (this.aFo) {
            if (x.Fn()) {
                x xVar = this.logger;
                xVar.f("MediationWaterfallWinnerTracker", "Tracking winning ad: " + aVar);
            }
            a aVar3 = new a(aVar.xs(), aVar.yA(), aVar.getNetworkName());
            if (aVar2 != null) {
                String unused = aVar3.aFs = aVar2.yA();
                String unused2 = aVar3.aFt = aVar2.getNetworkName();
            }
            this.aFn.put(aVar.getAdUnitId(), aVar3);
        }
    }

    public a cK(String str) {
        a aVar;
        synchronized (this.aFo) {
            aVar = this.aFn.get(str);
        }
        return aVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0075, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0025, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m(com.applovin.impl.mediation.b.a r8) {
        /*
            r7 = this;
            java.lang.String r0 = "Clearing previous winning ad: "
            java.lang.String r1 = "Previous winner not cleared for ad: "
            java.lang.Object r2 = r7.aFo
            monitor-enter(r2)
            java.lang.String r3 = r8.getAdUnitId()     // Catch:{ all -> 0x0076 }
            java.util.Map<java.lang.String, com.applovin.impl.sdk.y$a> r4 = r7.aFn     // Catch:{ all -> 0x0076 }
            java.lang.Object r4 = r4.get(r3)     // Catch:{ all -> 0x0076 }
            com.applovin.impl.sdk.y$a r4 = (com.applovin.impl.sdk.y.a) r4     // Catch:{ all -> 0x0076 }
            if (r4 != 0) goto L_0x0026
            boolean r8 = com.applovin.impl.sdk.x.Fn()     // Catch:{ all -> 0x0076 }
            if (r8 == 0) goto L_0x0024
            com.applovin.impl.sdk.x r8 = r7.logger     // Catch:{ all -> 0x0076 }
            java.lang.String r0 = "MediationWaterfallWinnerTracker"
            java.lang.String r1 = "No previous winner to clear."
            r8.f(r0, r1)     // Catch:{ all -> 0x0076 }
        L_0x0024:
            monitor-exit(r2)     // Catch:{ all -> 0x0076 }
            return
        L_0x0026:
            java.lang.String r5 = r8.xs()     // Catch:{ all -> 0x0076 }
            java.lang.String r6 = r4.xs()     // Catch:{ all -> 0x0076 }
            boolean r5 = r5.equals(r6)     // Catch:{ all -> 0x0076 }
            if (r5 == 0) goto L_0x0053
            boolean r8 = com.applovin.impl.sdk.x.Fn()     // Catch:{ all -> 0x0076 }
            if (r8 == 0) goto L_0x004d
            com.applovin.impl.sdk.x r8 = r7.logger     // Catch:{ all -> 0x0076 }
            java.lang.String r1 = "MediationWaterfallWinnerTracker"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0076 }
            r5.<init>(r0)     // Catch:{ all -> 0x0076 }
            r5.append(r4)     // Catch:{ all -> 0x0076 }
            java.lang.String r0 = r5.toString()     // Catch:{ all -> 0x0076 }
            r8.f(r1, r0)     // Catch:{ all -> 0x0076 }
        L_0x004d:
            java.util.Map<java.lang.String, com.applovin.impl.sdk.y$a> r8 = r7.aFn     // Catch:{ all -> 0x0076 }
            r8.remove(r3)     // Catch:{ all -> 0x0076 }
            goto L_0x0074
        L_0x0053:
            boolean r0 = com.applovin.impl.sdk.x.Fn()     // Catch:{ all -> 0x0076 }
            if (r0 == 0) goto L_0x0074
            com.applovin.impl.sdk.x r0 = r7.logger     // Catch:{ all -> 0x0076 }
            java.lang.String r3 = "MediationWaterfallWinnerTracker"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0076 }
            r5.<init>(r1)     // Catch:{ all -> 0x0076 }
            r5.append(r8)     // Catch:{ all -> 0x0076 }
            java.lang.String r8 = " , since it could have already been updated with a new ad: "
            r5.append(r8)     // Catch:{ all -> 0x0076 }
            r5.append(r4)     // Catch:{ all -> 0x0076 }
            java.lang.String r8 = r5.toString()     // Catch:{ all -> 0x0076 }
            r0.f(r3, r8)     // Catch:{ all -> 0x0076 }
        L_0x0074:
            monitor-exit(r2)     // Catch:{ all -> 0x0076 }
            return
        L_0x0076:
            r8 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0076 }
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.y.m(com.applovin.impl.mediation.b.a):void");
    }
}
