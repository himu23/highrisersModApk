package com.ironsource;

import com.ironsource.mediationsdk.adunit.adapter.utility.AdData;
import com.ironsource.mediationsdk.bidding.BiddingDataCallback;
import com.ironsource.mediationsdk.model.NetworkSettings;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;

public class x1 implements Callable<b2> {
    private final int a;
    private final String b;
    private final AdData c;
    private final z1 d;
    private final y1 e;
    private final NetworkSettings f;

    class a implements BiddingDataCallback {
        final /* synthetic */ r3 a;
        final /* synthetic */ BlockingQueue b;

        a(r3 r3Var, BlockingQueue blockingQueue) {
            this.a = r3Var;
            this.b = blockingQueue;
        }

        public void onFailure(String str) {
            this.b.add(new b2(x1.this.d(), x1.this.c(), (Map<String, Object>) null, r3.a(this.a), str));
        }

        public void onSuccess(Map<String, Object> map) {
            this.b.add(new b2(x1.this.d(), x1.this.c(), map, r3.a(this.a), (String) null));
        }
    }

    public x1(int i, String str, AdData adData, z1 z1Var, y1 y1Var, NetworkSettings networkSettings) {
        this.a = i;
        this.b = str;
        this.c = adData;
        this.d = z1Var;
        this.e = y1Var;
        this.f = networkSettings;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x004e, code lost:
        if (r2 == null) goto L_0x0070;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x006b, code lost:
        if (r2 == null) goto L_0x0070;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x006d, code lost:
        r2.a(r0);
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.ironsource.b2 call() throws java.lang.Exception {
        /*
            r4 = this;
            com.ironsource.r3 r0 = new com.ironsource.r3
            r0.<init>()
            com.ironsource.mediationsdk.logger.IronLog r1 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = r4.c()
            r2.append(r3)
            java.lang.String r3 = " fetching bidding data"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.verbose(r2)
            java.util.concurrent.ArrayBlockingQueue r1 = new java.util.concurrent.ArrayBlockingQueue
            r2 = 1
            r1.<init>(r2)
            com.ironsource.x1$a r2 = new com.ironsource.x1$a
            r2.<init>(r0, r1)
            com.ironsource.z1 r0 = r4.b()     // Catch:{ Exception -> 0x0051, NoClassDefFoundError -> 0x0034 }
            com.ironsource.mediationsdk.adunit.adapter.utility.AdData r3 = r4.c     // Catch:{ Exception -> 0x0051, NoClassDefFoundError -> 0x0034 }
            r0.a(r3, r2)     // Catch:{ Exception -> 0x0051, NoClassDefFoundError -> 0x0034 }
            goto L_0x0070
        L_0x0034:
            r0 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Error while calling collectBiddingData - "
            r2.<init>(r3)
            java.lang.String r0 = r0.getMessage()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            com.ironsource.mediationsdk.logger.IronLog r2 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL
            r2.error(r0)
            com.ironsource.y1 r2 = r4.e
            if (r2 == 0) goto L_0x0070
            goto L_0x006d
        L_0x0051:
            r0 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Exception while calling collectBiddingData - "
            r2.<init>(r3)
            java.lang.String r0 = r0.getMessage()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            com.ironsource.mediationsdk.logger.IronLog r2 = com.ironsource.mediationsdk.logger.IronLog.INTERNAL
            r2.error(r0)
            com.ironsource.y1 r2 = r4.e
            if (r2 == 0) goto L_0x0070
        L_0x006d:
            r2.a((java.lang.String) r0)
        L_0x0070:
            com.ironsource.y1 r0 = r4.e
            if (r0 == 0) goto L_0x0079
            com.ironsource.mediationsdk.model.NetworkSettings r2 = r4.f
            r0.a((com.ironsource.mediationsdk.model.NetworkSettings) r2)
        L_0x0079:
            java.lang.Object r0 = r1.take()
            com.ironsource.b2 r0 = (com.ironsource.b2) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.x1.call():com.ironsource.b2");
    }

    public z1 b() {
        return this.d;
    }

    public String c() {
        return this.b;
    }

    public int d() {
        return this.a;
    }
}
