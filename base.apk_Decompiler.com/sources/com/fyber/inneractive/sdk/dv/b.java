package com.fyber.inneractive.sdk.dv;

import com.fyber.inneractive.sdk.external.InneractiveErrorCode;
import com.fyber.inneractive.sdk.external.InneractiveInfrastructureError;
import com.fyber.inneractive.sdk.flow.g;
import com.fyber.inneractive.sdk.flow.h;
import com.fyber.inneractive.sdk.util.p;

public class b extends h<f, a> implements d {
    public final boolean m = (!p.a("com.google.android.gms.ads.InterstitialAd"));

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.fyber.inneractive.sdk.config.enums.UnitDisplayType[] r0 = com.fyber.inneractive.sdk.config.enums.UnitDisplayType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                a = r0
                com.fyber.inneractive.sdk.config.enums.UnitDisplayType r1 = com.fyber.inneractive.sdk.config.enums.UnitDisplayType.INTERSTITIAL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.fyber.inneractive.sdk.config.enums.UnitDisplayType r1 = com.fyber.inneractive.sdk.config.enums.UnitDisplayType.BANNER     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.fyber.inneractive.sdk.config.enums.UnitDisplayType r1 = com.fyber.inneractive.sdk.config.enums.UnitDisplayType.MRECT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.fyber.inneractive.sdk.config.enums.UnitDisplayType r1 = com.fyber.inneractive.sdk.config.enums.UnitDisplayType.REWARDED     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.dv.b.a.<clinit>():void");
        }
    }

    public void a() {
        Content content = this.c;
        if (content != null) {
            ((a) content).a();
        }
        super.a();
    }

    public void b() {
        Content content = this.c;
        if (content != null) {
            ((a) content).a();
        }
        super.b();
    }

    public String f() {
        return null;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(8:37|38|39|40|41|42|43|51) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x00c3 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void j() {
        /*
            r8 = this;
            Response r0 = r8.b
            if (r0 == 0) goto L_0x00e5
            com.fyber.inneractive.sdk.dv.f r0 = (com.fyber.inneractive.sdk.dv.f) r0
            com.fyber.inneractive.sdk.dv.g r0 = r0.s
            if (r0 == 0) goto L_0x00e5
            com.fyber.inneractive.sdk.external.InneractiveAdRequest r0 = r8.a
            if (r0 == 0) goto L_0x001e
            boolean r0 = r0.getMuteVideo()
            com.google.android.gms.ads.MobileAds.setAppMuted(r0)     // Catch:{ all -> 0x001e }
            if (r0 == 0) goto L_0x0019
            r0 = 0
            goto L_0x001b
        L_0x0019:
            r0 = 1065353216(0x3f800000, float:1.0)
        L_0x001b:
            com.google.android.gms.ads.MobileAds.setAppVolume(r0)     // Catch:{ all -> 0x001e }
        L_0x001e:
            Response r0 = r8.b
            com.fyber.inneractive.sdk.dv.f r0 = (com.fyber.inneractive.sdk.dv.f) r0
            com.fyber.inneractive.sdk.config.enums.UnitDisplayType r1 = r0.n
            com.fyber.inneractive.sdk.dv.g r0 = r0.s
            com.google.android.gms.ads.query.QueryInfo r0 = r0.a
            int[] r2 = com.fyber.inneractive.sdk.dv.b.a.a
            int r1 = r1.ordinal()
            r1 = r2[r1]
            r2 = 1
            if (r1 == r2) goto L_0x0072
            r3 = 2
            if (r1 == r3) goto L_0x0062
            r3 = 3
            if (r1 == r3) goto L_0x0062
            r3 = 4
            if (r1 == r3) goto L_0x003e
            r1 = 0
            goto L_0x0095
        L_0x003e:
            boolean r1 = r8.m
            if (r1 == 0) goto L_0x0052
            com.fyber.inneractive.sdk.dv.rewarded.a r1 = new com.fyber.inneractive.sdk.dv.rewarded.a
            com.fyber.inneractive.sdk.config.b0 r3 = r8.g()
            com.fyber.inneractive.sdk.config.global.s r4 = r8.g
            Response r5 = r8.b
            com.fyber.inneractive.sdk.dv.f r5 = (com.fyber.inneractive.sdk.dv.f) r5
            r1.<init>(r3, r4, r5)
            goto L_0x0095
        L_0x0052:
            com.fyber.inneractive.sdk.dv.rewarded.b r1 = new com.fyber.inneractive.sdk.dv.rewarded.b
            com.fyber.inneractive.sdk.config.b0 r3 = r8.g()
            com.fyber.inneractive.sdk.config.global.s r4 = r8.g
            Response r5 = r8.b
            com.fyber.inneractive.sdk.dv.f r5 = (com.fyber.inneractive.sdk.dv.f) r5
            r1.<init>(r3, r4, r5)
            goto L_0x0095
        L_0x0062:
            com.fyber.inneractive.sdk.dv.banner.a r1 = new com.fyber.inneractive.sdk.dv.banner.a
            com.fyber.inneractive.sdk.config.b0 r3 = r8.g()
            com.fyber.inneractive.sdk.config.global.s r4 = r8.g
            Response r5 = r8.b
            com.fyber.inneractive.sdk.dv.f r5 = (com.fyber.inneractive.sdk.dv.f) r5
            r1.<init>(r3, r4, r5)
            goto L_0x0095
        L_0x0072:
            boolean r1 = r8.m
            if (r1 == 0) goto L_0x0086
            com.fyber.inneractive.sdk.dv.interstitial.b r1 = new com.fyber.inneractive.sdk.dv.interstitial.b
            com.fyber.inneractive.sdk.config.b0 r3 = r8.g()
            com.fyber.inneractive.sdk.config.global.s r4 = r8.g
            Response r5 = r8.b
            com.fyber.inneractive.sdk.dv.f r5 = (com.fyber.inneractive.sdk.dv.f) r5
            r1.<init>(r3, r4, r5)
            goto L_0x0095
        L_0x0086:
            com.fyber.inneractive.sdk.dv.interstitial.c r1 = new com.fyber.inneractive.sdk.dv.interstitial.c
            com.fyber.inneractive.sdk.config.b0 r3 = r8.g()
            com.fyber.inneractive.sdk.config.global.s r4 = r8.g
            Response r5 = r8.b
            com.fyber.inneractive.sdk.dv.f r5 = (com.fyber.inneractive.sdk.dv.f) r5
            r1.<init>(r3, r4, r5)
        L_0x0095:
            r8.c = r1
            if (r0 == 0) goto L_0x00e1
            if (r1 == 0) goto L_0x00e1
            Response r1 = r8.b
            if (r1 == 0) goto L_0x00e1
            com.google.android.gms.ads.AdRequest$Builder r1 = new com.google.android.gms.ads.AdRequest$Builder     // Catch:{ all -> 0x00dd }
            r1.<init>()     // Catch:{ all -> 0x00dd }
            java.lang.Class r3 = r1.getClass()     // Catch:{ Exception -> 0x00c3 }
            java.lang.String r4 = "setAdString"
            java.lang.Class[] r5 = new java.lang.Class[r2]     // Catch:{ Exception -> 0x00c3 }
            java.lang.Class<java.lang.String> r6 = java.lang.String.class
            r7 = 0
            r5[r7] = r6     // Catch:{ Exception -> 0x00c3 }
            java.lang.reflect.Method r3 = r3.getMethod(r4, r5)     // Catch:{ Exception -> 0x00c3 }
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ Exception -> 0x00c3 }
            Response r4 = r8.b     // Catch:{ Exception -> 0x00c3 }
            com.fyber.inneractive.sdk.dv.f r4 = (com.fyber.inneractive.sdk.dv.f) r4     // Catch:{ Exception -> 0x00c3 }
            java.lang.String r4 = r4.J     // Catch:{ Exception -> 0x00c3 }
            r2[r7] = r4     // Catch:{ Exception -> 0x00c3 }
            r3.invoke(r1, r2)     // Catch:{ Exception -> 0x00c3 }
            goto L_0x00d1
        L_0x00c3:
            com.google.android.gms.ads.query.AdInfo r2 = new com.google.android.gms.ads.query.AdInfo     // Catch:{ all -> 0x00dd }
            Response r3 = r8.b     // Catch:{ all -> 0x00dd }
            com.fyber.inneractive.sdk.dv.f r3 = (com.fyber.inneractive.sdk.dv.f) r3     // Catch:{ all -> 0x00dd }
            java.lang.String r3 = r3.J     // Catch:{ all -> 0x00dd }
            r2.<init>(r0, r3)     // Catch:{ all -> 0x00dd }
            r1.setAdInfo(r2)     // Catch:{ all -> 0x00dd }
        L_0x00d1:
            com.google.android.gms.ads.AdRequest r0 = r1.build()     // Catch:{ all -> 0x00dd }
            Content r1 = r8.c     // Catch:{ all -> 0x00dd }
            com.fyber.inneractive.sdk.dv.a r1 = (com.fyber.inneractive.sdk.dv.a) r1     // Catch:{ all -> 0x00dd }
            r1.a(r0, r8)     // Catch:{ all -> 0x00dd }
            goto L_0x00e8
        L_0x00dd:
            r8.l()
            goto L_0x00e8
        L_0x00e1:
            r8.l()
            goto L_0x00e8
        L_0x00e5:
            r8.l()
        L_0x00e8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.dv.b.j():void");
    }

    public void l() {
        a(new InneractiveInfrastructureError(InneractiveErrorCode.SDK_INTERNAL_ERROR, g.NETWORK_ERROR));
    }
}
