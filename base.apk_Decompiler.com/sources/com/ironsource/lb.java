package com.ironsource;

import com.ironsource.mediationsdk.IronSource;
import com.ironsource.w6;
import java.util.HashMap;
import java.util.Map;

class lb implements w6, w6.a {
    private static final int c = 1;
    private final Map<IronSource.AD_UNIT, Integer> a = new HashMap();
    private final c8 b = new c8();

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.ironsource.mediationsdk.IronSource$AD_UNIT[] r0 = com.ironsource.mediationsdk.IronSource.AD_UNIT.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                a = r0
                com.ironsource.mediationsdk.IronSource$AD_UNIT r1 = com.ironsource.mediationsdk.IronSource.AD_UNIT.REWARDED_VIDEO     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.ironsource.mediationsdk.IronSource$AD_UNIT r1 = com.ironsource.mediationsdk.IronSource.AD_UNIT.INTERSTITIAL     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.ironsource.mediationsdk.IronSource$AD_UNIT r1 = com.ironsource.mediationsdk.IronSource.AD_UNIT.BANNER     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.ironsource.mediationsdk.IronSource$AD_UNIT r1 = com.ironsource.mediationsdk.IronSource.AD_UNIT.NATIVE_AD     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ironsource.lb.a.<clinit>():void");
        }
    }

    lb() {
        for (IronSource.AD_UNIT a2 : IronSource.AD_UNIT.values()) {
            a(a2, 1);
        }
    }

    private void a(IronSource.AD_UNIT ad_unit, int i) {
        this.a.put(ad_unit, Integer.valueOf(i));
        int i2 = a.a[ad_unit.ordinal()];
        if (i2 == 1) {
            this.b.d(i);
        } else if (i2 == 2) {
            this.b.b(i);
        } else if (i2 == 3) {
            this.b.a(i);
        } else if (i2 == 4) {
            this.b.c(i);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0016, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized int a(com.ironsource.mediationsdk.IronSource.AD_UNIT r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            r0 = -1
            if (r3 != 0) goto L_0x0006
            monitor-exit(r2)
            return r0
        L_0x0006:
            java.util.Map<com.ironsource.mediationsdk.IronSource$AD_UNIT, java.lang.Integer> r1 = r2.a     // Catch:{ all -> 0x0017 }
            java.lang.Object r3 = r1.get(r3)     // Catch:{ all -> 0x0017 }
            java.lang.Integer r3 = (java.lang.Integer) r3     // Catch:{ all -> 0x0017 }
            if (r3 != 0) goto L_0x0011
            goto L_0x0015
        L_0x0011:
            int r0 = r3.intValue()     // Catch:{ all -> 0x0017 }
        L_0x0015:
            monitor-exit(r2)
            return r0
        L_0x0017:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.lb.a(com.ironsource.mediationsdk.IronSource$AD_UNIT):int");
    }

    public synchronized void b(IronSource.AD_UNIT ad_unit) {
        if (ad_unit != null) {
            a(ad_unit, this.a.get(ad_unit).intValue() + 1);
        }
    }
}
